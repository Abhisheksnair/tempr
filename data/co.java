package com.whatsapp.data;

import a.a.a.a.a.a.d;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.whatsapp.ant;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class co
{
  private static volatile co d;
  final ant a;
  public final cj b;
  ConcurrentHashMap<String, ad.n> c;
  private final n e;
  private final ReentrantReadWriteLock.ReadLock f;
  private final Object g = new Object();
  
  private co(ant paramant, cj paramcj, ch paramch)
  {
    this.a = paramant;
    this.b = paramcj;
    this.e = paramch.a;
    this.f = paramch.b.readLock();
  }
  
  public static co a()
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new co(ant.a(), cj.a(), ch.a());
      }
      return d;
    }
    finally {}
  }
  
  private ConcurrentHashMap<String, ad.n> i()
  {
    this.f.lock();
    try
    {
      ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
      Cursor localCursor = this.e.getWritableDatabase().rawQuery("SELECT key_remote_jid, message_table_id, last_read_message_table_id, last_read_receipt_sent_message_table_id, first_unread_message_table_id, autodownload_limit_message_table_id, timestamp, unseen_count, total_count FROM status_list", null);
      if (localCursor != null)
      {
        ad.n localn;
        ((Cursor)localObject).close();
      }
    }
    finally
    {
      try
      {
        while (localCursor.moveToNext())
        {
          localn = new ad.n(this.a, localCursor.getString(0), localCursor.getLong(1), localCursor.getLong(2), localCursor.getLong(3), localCursor.getLong(4), localCursor.getLong(5), localCursor.getLong(6), localCursor.getInt(7), localCursor.getInt(8));
          localConcurrentHashMap.put(localn.a, localn);
          Log.d("statusmsgstore/status-init: " + localn);
          continue;
          this.f.unlock();
        }
      }
      finally
      {
        localCursor.close();
      }
    }
    this.f.unlock();
    return localConcurrentHashMap1;
  }
  
  public final ad.n a(String paramString)
  {
    return (ad.n)c().get(paramString);
  }
  
  public final void a(int paramInt, Collection<String> paramCollection)
  {
    this.b.a("status_distribution", paramInt);
    if (paramInt == 2) {
      this.b.a("status_black_list", TextUtils.join(",", paramCollection));
    }
    while (paramInt != 1) {
      return;
    }
    this.b.a("status_white_list", TextUtils.join(",", paramCollection));
  }
  
  public final boolean a(j paramj)
  {
    if (paramj.e.b) {
      return false;
    }
    ad.n localn = a(paramj.f);
    if (localn == null)
    {
      Log.w("statusmsgstore/isstatusunseen/no status for " + paramj.f);
      return false;
    }
    return localn.d(paramj);
  }
  
  public final boolean b()
  {
    return this.b.a("status_distribution") != null;
  }
  
  public final boolean b(j paramj)
  {
    a.d.a(j.c(paramj.e.a), "isStatusExpired should be called for statuses only");
    if (e.b(paramj.f))
    {
      l1 = this.b.b("status_psa_viewed_time");
      l2 = this.b.b("status_psa_exipration_time");
      if ((paramj.n >= l1) || (l2 == 0L) || (l2 >= this.a.b())) {}
    }
    while (paramj.n < this.a.b() - 86400000L)
    {
      long l1;
      long l2;
      return true;
      return false;
    }
    return false;
  }
  
  public final Map<String, ad.n> c()
  {
    if (this.c == null) {}
    synchronized (this.g)
    {
      if (this.c == null) {
        this.c = i();
      }
      return this.c;
    }
  }
  
  public final List<ad.n> d()
  {
    Object localObject = c();
    ArrayList localArrayList = new ArrayList(((Map)localObject).size());
    localObject = ((Map)localObject).values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ad.n localn = (ad.n)((Iterator)localObject).next();
      if (!localn.c()) {
        localArrayList.add(localn.a());
      }
    }
    return localArrayList;
  }
  
  public final long e()
  {
    long l1 = 0L;
    long l2 = this.a.b() - 86400000L;
    long l3 = this.b.b("earliest_status_time");
    if (l3 == 0L) {
      l1 = -1L;
    }
    while (l3 <= l2) {
      return l1;
    }
    return l3 - l2;
  }
  
  public final int f()
  {
    String str = this.b.a("status_distribution");
    if (str == null) {
      return 0;
    }
    return Integer.parseInt(str);
  }
  
  public final String[] g()
  {
    String str = this.b.a("status_white_list");
    if (TextUtils.isEmpty(str)) {
      return new String[0];
    }
    return str.split(",");
  }
  
  public final String[] h()
  {
    String str = this.b.a("status_black_list");
    if (TextUtils.isEmpty(str)) {
      return new String[0];
    }
    return str.split(",");
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */