package com.whatsapp.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.whatsapp.ant;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;
import com.whatsapp.util.bd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class o
{
  private static volatile o c;
  public final ant a;
  public final cj b;
  private ConcurrentHashMap<c, Integer> d;
  private final d e;
  private final n f;
  private final ReentrantReadWriteLock.ReadLock g;
  
  private o(ant paramant, d paramd, cj paramcj, ch paramch)
  {
    this.a = paramant;
    this.e = paramd;
    this.b = paramcj;
    this.f = paramch.a;
    this.g = paramch.b.readLock();
  }
  
  public static o a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new o(ant.a(), d.a(), cj.a(), ch.a());
      }
      return c;
    }
    finally {}
  }
  
  public final List<String> a(b paramb)
  {
    Object localObject1 = c();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = ((ConcurrentHashMap)localObject1).entrySet().iterator();
    Object localObject2;
    label219:
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      String str = ((c)((Map.Entry)localObject1).getKey()).a;
      byte b1 = ((c)((Map.Entry)localObject1).getKey()).b;
      int i = ((Integer)((Map.Entry)localObject1).getValue()).intValue();
      Log.d("frequentmsgstore/getfrequents/" + str + " " + b1 + " " + i);
      if (paramb == null) {}
      for (;;)
      {
        if (i == 0) {
          break label219;
        }
        localObject2 = (a)localHashMap.get(str);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new a((byte)0);
          ((a)localObject1).b = this.e.b(str);
        }
        ((a)localObject1).a = (i + ((a)localObject1).a);
        localHashMap.put(str, localObject1);
        break;
        i *= paramb.a(b1);
      }
    }
    localObject1 = new ArrayList(localHashMap.entrySet());
    Collections.sort((List)localObject1, p.a());
    paramb = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      paramb.add(((Map.Entry)localObject2).getKey());
      Log.d("frequentmsgstore/getfrequents/sorted/" + (String)((Map.Entry)localObject2).getKey() + " " + ((a)((Map.Entry)localObject2).getValue()).a + " " + ((a)((Map.Entry)localObject2).getValue()).b);
    }
    return paramb;
  }
  
  final void a(String paramString)
  {
    this.g.lock();
    Object localObject;
    try
    {
      this.f.getWritableDatabase().delete("frequents", "jid=?", new String[] { paramString });
      if (this.d == null) {
        break label150;
      }
      localObject = new ArrayList();
      Iterator localIterator = this.d.keySet().iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (paramString.equals(localc.a)) {
          ((List)localObject).add(localc);
        }
      }
      paramString = ((List)localObject).iterator();
    }
    finally
    {
      this.g.unlock();
    }
    while (paramString.hasNext())
    {
      localObject = (c)paramString.next();
      this.d.remove(localObject);
    }
    label150:
    this.g.unlock();
  }
  
  public final void b()
  {
    this.d = new ConcurrentHashMap();
  }
  
  /* Error */
  final ConcurrentHashMap<c, Integer> c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/whatsapp/data/o:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   4: invokevirtual 216	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   7: aload_0
    //   8: getfield 234	com/whatsapp/data/o:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   11: ifnonnull +111 -> 122
    //   14: aload_0
    //   15: new 96	java/util/concurrent/ConcurrentHashMap
    //   18: dup
    //   19: invokespecial 248	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   22: putfield 234	com/whatsapp/data/o:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_0
    //   26: getfield 42	com/whatsapp/data/o:f	Lcom/whatsapp/data/n;
    //   29: invokevirtual 222	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   32: ldc -6
    //   34: aconst_null
    //   35: invokevirtual 254	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore_1
    //   39: aload_1
    //   40: ifnull +82 -> 122
    //   43: aload_1
    //   44: invokeinterface 259 1 0
    //   49: ifeq +67 -> 116
    //   52: new 12	com/whatsapp/data/o$c
    //   55: dup
    //   56: aload_1
    //   57: iconst_0
    //   58: invokeinterface 263 2 0
    //   63: aload_1
    //   64: iconst_1
    //   65: invokeinterface 267 2 0
    //   70: i2b
    //   71: invokespecial 270	com/whatsapp/data/o$c:<init>	(Ljava/lang/String;B)V
    //   74: astore_2
    //   75: aload_0
    //   76: getfield 234	com/whatsapp/data/o:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   79: aload_2
    //   80: aload_1
    //   81: iconst_2
    //   82: invokeinterface 267 2 0
    //   87: invokestatic 274	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: invokevirtual 275	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   93: pop
    //   94: goto -51 -> 43
    //   97: astore_2
    //   98: aload_1
    //   99: invokeinterface 278 1 0
    //   104: aload_2
    //   105: athrow
    //   106: astore_1
    //   107: aload_0
    //   108: getfield 53	com/whatsapp/data/o:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   111: invokevirtual 244	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   114: aload_1
    //   115: athrow
    //   116: aload_1
    //   117: invokeinterface 278 1 0
    //   122: aload_0
    //   123: getfield 53	com/whatsapp/data/o:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   126: invokevirtual 244	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   129: aload_0
    //   130: getfield 234	com/whatsapp/data/o:d	Ljava/util/concurrent/ConcurrentHashMap;
    //   133: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	o
    //   38	61	1	localCursor	Cursor
    //   106	11	1	localObject1	Object
    //   74	6	2	localc	c
    //   97	8	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   43	94	97	finally
    //   7	39	106	finally
    //   98	106	106	finally
    //   116	122	106	finally
  }
  
  public final void d()
  {
    int j = 0;
    int i = 0;
    bd localbd = new bd();
    localbd.a("frequentmsgstore/updateFrequents");
    this.g.lock();
    SQLiteDatabase localSQLiteDatabase;
    Object localObject6;
    HashMap localHashMap;
    Object localObject7;
    Object localObject4;
    for (;;)
    {
      try
      {
        localSQLiteDatabase = this.f.getWritableDatabase();
        long l3 = System.currentTimeMillis();
        long l1 = 0L;
        Object localObject1 = localSQLiteDatabase.rawQuery("SELECT _id, received_timestamp FROM messages ORDER BY _id DESC LIMIT 4096", null);
        long l2 = l1;
        if (localObject1 != null)
        {
          j = i;
          if (((Cursor)localObject1).moveToNext())
          {
            long l4 = ((Cursor)localObject1).getLong(1);
            l2 = ((Cursor)localObject1).getLong(0);
            j = i + 1;
            i = j;
            l1 = l2;
            if (l4 > l3 - 691200000L) {
              continue;
            }
            l1 = l2;
          }
          ((Cursor)localObject1).close();
          l2 = l1;
        }
        Log.i("frequentmsgstore/updateFrequents/start row:" + l2 + " " + j);
        localObject6 = localSQLiteDatabase.rawQuery("SELECT key_remote_jid, media_wa_type FROM messages WHERE _id>=? AND key_from_me=1 AND status!=?", new String[] { Long.toString(l2), Integer.toString(6) });
        localHashMap = new HashMap();
        if (localObject6 == null) {
          break label657;
        }
        try
        {
          if (!((Cursor)localObject6).moveToNext()) {
            break;
          }
          localObject1 = ((Cursor)localObject6).getString(0);
          if (j.c((String)localObject1)) {
            continue;
          }
          localObject7 = new c((String)localObject1, (byte)((Cursor)localObject6).getInt(1));
          localObject1 = (Integer)localHashMap.get(localObject7);
          if (localObject1 == null)
          {
            localObject1 = Integer.valueOf(1);
            localHashMap.put(localObject7, localObject1);
            continue;
            localObject3 = finally;
          }
        }
        finally
        {
          ((Cursor)localObject6).close();
        }
        i = ((Integer)localObject3).intValue();
      }
      finally
      {
        this.g.unlock();
      }
      localObject4 = Integer.valueOf(i + 1);
    }
    ((Cursor)localObject6).close();
    label657:
    for (;;)
    {
      Log.d("frequentmsgstore/updateFrequents/calculated " + localHashMap.size());
      try
      {
        localSQLiteDatabase.beginTransaction();
        localSQLiteDatabase.delete("frequents", null, null);
        localObject4 = localHashMap.entrySet().iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject6 = (Map.Entry)((Iterator)localObject4).next();
          localObject7 = new ContentValues(3);
          ((ContentValues)localObject7).put("jid", ((c)((Map.Entry)localObject6).getKey()).a);
          ((ContentValues)localObject7).put("type", Byte.valueOf(((c)((Map.Entry)localObject6).getKey()).b));
          ((ContentValues)localObject7).put("message_count", (Integer)((Map.Entry)localObject6).getValue());
          Log.d("frequentmsgstore/updatefrequents/" + ((c)((Map.Entry)localObject6).getKey()).a + " " + ((c)((Map.Entry)localObject6).getKey()).b + " " + ((Map.Entry)localObject6).getValue());
          if (localSQLiteDatabase.insert("frequents", null, (ContentValues)localObject7) == -1L) {
            Log.e("frequentmsgstore/insert/failed jid=" + ((c)((Map.Entry)localObject6).getKey()).a + " type=" + ((c)((Map.Entry)localObject6).getKey()).b + " count=" + ((Map.Entry)localObject6).getValue());
          }
        }
        Log.e("frequentmsgstore/updateFrequents/cursor is null");
      }
      finally
      {
        if (localSQLiteDatabase.inTransaction()) {
          localSQLiteDatabase.endTransaction();
        }
      }
    }
    localSQLiteDatabase.setTransactionSuccessful();
    if (localSQLiteDatabase.inTransaction()) {
      localSQLiteDatabase.endTransaction();
    }
    this.d = new ConcurrentHashMap(localHashMap);
    this.b.a("frequents", this.a.b());
    this.g.unlock();
    localbd.b();
  }
  
  static final class a
    implements Comparable<a>
  {
    int a;
    long b;
    
    public final int a(a parama)
    {
      if (parama == this) {}
      long l1;
      do
      {
        return 0;
        long l2 = this.a - parama.a;
        l1 = l2;
        if (l2 == 0L) {
          l1 = this.b - parama.b;
        }
        if (l1 < 0L) {
          return -1;
        }
      } while (l1 <= 0L);
      return 1;
    }
    
    public final String toString()
    {
      return this.a + " " + this.b;
    }
  }
  
  public static abstract interface b
  {
    public abstract int a(byte paramByte);
  }
  
  static final class c
  {
    String a;
    byte b;
    
    c(String paramString, byte paramByte)
    {
      this.a = paramString;
      this.b = paramByte;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (c)paramObject;
      } while ((this.b == ((c)paramObject).b) && (this.a.equals(((c)paramObject).a)));
      return false;
    }
    
    public final int hashCode()
    {
      return this.a.hashCode() * 31 + this.b;
    }
    
    public final String toString()
    {
      return this.a + " " + this.b;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */