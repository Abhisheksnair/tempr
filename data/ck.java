package com.whatsapp.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.f.f;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.qz;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class ck
{
  private static volatile ck b;
  private static final String c = "SELECT key_remote_jid, receipt_device_timestamp, read_device_timestamp, played_device_timestamp FROM messages WHERE key_id=? AND key_from_me=1 AND needs_push=" + Integer.toString(2) + " AND NOT (key_remote_jid LIKE '%@broadcast') AND (receipt_device_timestamp>0 OR read_device_timestamp>0 OR played_device_timestamp>0)";
  final f<j.b, a> a = new f(250);
  private final n d;
  private final ReentrantReadWriteLock.ReadLock e;
  
  private ck(ch paramch)
  {
    this.d = paramch.a;
    this.e = paramch.b.readLock();
  }
  
  public static ck a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new ck(ch.a());
      }
      return b;
    }
    finally {}
  }
  
  public final a a(j.b paramb)
  {
    this.e.lock();
    try
    {
      paramb = new a(b(paramb));
      return paramb;
    }
    finally
    {
      this.e.unlock();
    }
  }
  
  final a b(j.b paramb)
  {
    Object localObject1 = (a)this.a.a(paramb);
    if (localObject1 != null) {
      return (a)localObject1;
    }
    Object localObject2;
    if ((qz.e(paramb.a)) || (j.c(paramb.a)))
    {
      localObject1 = paramb.a;
      localObject2 = paramb.c;
      localObject1 = this.d.getReadableDatabase().rawQuery("SELECT remote_resource, receipt_device_timestamp, read_device_timestamp, played_device_timestamp FROM receipts WHERE key_remote_jid=? AND key_id=?", new String[] { localObject1, localObject2 });
    }
    a locala;
    for (;;)
    {
      locala = new a();
      if (localObject1 == null) {
        break label268;
      }
      try
      {
        while (((Cursor)localObject1).moveToNext())
        {
          Object localObject3 = ((Cursor)localObject1).getString(0);
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localObject3 = new ad.i();
          ((ad.i)localObject3).b = ((Cursor)localObject1).getLong(1);
          ((ad.i)localObject3).c = ((Cursor)localObject1).getLong(2);
          ((ad.i)localObject3).d = ((Cursor)localObject1).getLong(3);
          locala.a.put(localObject2, localObject3);
        }
        if (!cs.e(paramb.a)) {
          break label224;
        }
      }
      finally
      {
        ((Cursor)localObject1).close();
      }
      localObject1 = paramb.c;
      localObject1 = this.d.getReadableDatabase().rawQuery(c, new String[] { localObject1 });
      continue;
      label224:
      localObject1 = paramb.a;
      localObject2 = paramb.c;
      localObject1 = this.d.getReadableDatabase().rawQuery("SELECT key_remote_jid, receipt_device_timestamp, read_device_timestamp, played_device_timestamp FROM messages WHERE key_remote_jid=? AND key_id=?", new String[] { localObject1, localObject2 });
    }
    ((Cursor)localObject1).close();
    label268:
    this.a.a(paramb, locala);
    return locala;
  }
  
  public static final class a
  {
    public final ConcurrentHashMap<String, ad.i> a;
    
    a()
    {
      this.a = new ConcurrentHashMap();
    }
    
    a(a parama)
    {
      this.a = new ConcurrentHashMap(parama.a);
    }
    
    final int a(int paramInt)
    {
      Iterator localIterator = this.a.values().iterator();
      int i = 0;
      int j = 0;
      int k = 0;
      if (localIterator.hasNext())
      {
        int m = i;
        int i1 = i;
        int n = j;
        switch (((ad.i)localIterator.next()).a())
        {
        }
        for (;;)
        {
          break;
          m = i + 1;
          n = j + 1;
          i1 = m;
          i = i1;
          j = n;
          k += 1;
        }
      }
      if (i >= paramInt) {
        return 8;
      }
      if (j >= paramInt) {
        return 13;
      }
      if (k >= paramInt) {
        return 5;
      }
      return 4;
    }
    
    final boolean a(String paramString, int paramInt, long paramLong)
    {
      ad.i locali2 = (ad.i)this.a.get(paramString);
      ad.i locali1 = locali2;
      if (locali2 == null)
      {
        locali1 = new ad.i();
        this.a.put(paramString, locali1);
      }
      switch (paramInt)
      {
      }
      for (;;)
      {
        return true;
        if ((locali1.d > 0L) && (locali1.d <= paramLong)) {
          return false;
        }
        locali1.d = paramLong;
        continue;
        if ((locali1.c > 0L) && (locali1.c <= paramLong)) {
          return false;
        }
        locali1.c = paramLong;
        continue;
        if ((locali1.b > 0L) && (locali1.b <= paramLong)) {
          return false;
        }
        locali1.b = paramLong;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */