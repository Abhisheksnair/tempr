package com.whatsapp.gcm.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.HandlerThread;
import b.a.a.c;
import com.whatsapp.g.i;
import com.whatsapp.g.j;
import java.util.ArrayList;
import java.util.List;

public final class a
{
  public static a a;
  final g b;
  public final Handler c;
  Boolean d;
  
  public a(Context paramContext)
  {
    this.b = new g(paramContext);
    paramContext = new HandlerThread("network-timeline", 10);
    paramContext.start();
    this.c = new Handler(paramContext.getLooper());
  }
  
  public static long b()
  {
    return ((j)c.a().a(j.class)).a();
  }
  
  final b a(String paramString)
  {
    for (;;)
    {
      synchronized (this.b)
      {
        SQLiteDatabase localSQLiteDatabase = this.b.getReadableDatabase();
        Cursor localCursor = localSQLiteDatabase.query("network_timeline", new String[] { "_id", "reason", "timestamp", "extra_data" }, "extra_data IS ?", new String[] { paramString }, null, null, "timestamp ASC");
        if (localCursor.moveToNext())
        {
          paramString = new b(localCursor.getInt(0), localCursor.getInt(1), localCursor.getLong(2), localCursor.getString(3));
          localCursor.close();
          localSQLiteDatabase.close();
          return paramString;
        }
      }
      paramString = null;
    }
  }
  
  final List<b> a(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase;
    try
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject2;
      synchronized (this.b)
      {
        localSQLiteDatabase = this.b.getReadableDatabase();
        localObject2 = b() - paramLong;
        localObject2 = localSQLiteDatabase.query("network_timeline", new String[] { "_id", "reason", "timestamp", "extra_data" }, "timestamp > ?", new String[] { localObject2 }, null, null, "timestamp ASC");
        if (((Cursor)localObject2).moveToNext()) {
          localArrayList.add(new b(((Cursor)localObject2).getInt(0), ((Cursor)localObject2).getInt(1), ((Cursor)localObject2).getLong(2), ((Cursor)localObject2).getString(3)));
        }
      }
      ((Cursor)localObject2).close();
    }
    finally {}
    localSQLiteDatabase.close();
    return localList;
  }
  
  public final void a()
  {
    try
    {
      this.c.post(f.a(this));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  final void a(int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/whatsapp/gcm/a/a:b	Lcom/whatsapp/gcm/a/g;
    //   6: astore 4
    //   8: aload 4
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 27	com/whatsapp/gcm/a/a:b	Lcom/whatsapp/gcm/a/g;
    //   15: invokevirtual 154	com/whatsapp/gcm/a/g:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   18: astore 5
    //   20: new 156	android/content/ContentValues
    //   23: dup
    //   24: invokespecial 157	android/content/ContentValues:<init>	()V
    //   27: astore 6
    //   29: aload 6
    //   31: ldc 75
    //   33: iload_1
    //   34: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   37: invokevirtual 167	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   40: aload 6
    //   42: ldc 77
    //   44: lload_2
    //   45: invokestatic 172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   48: invokevirtual 175	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   51: aload 5
    //   53: ldc 69
    //   55: aconst_null
    //   56: aload 6
    //   58: invokevirtual 179	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   61: pop2
    //   62: aload 5
    //   64: invokevirtual 114	android/database/sqlite/SQLiteDatabase:close	()V
    //   67: aload 4
    //   69: monitorexit
    //   70: aload_0
    //   71: monitorexit
    //   72: return
    //   73: astore 5
    //   75: aload 4
    //   77: monitorexit
    //   78: aload 5
    //   80: athrow
    //   81: astore 4
    //   83: aload_0
    //   84: monitorexit
    //   85: aload 4
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	a
    //   0	88	1	paramInt	int
    //   0	88	2	paramLong	long
    //   81	5	4	localObject1	Object
    //   18	45	5	localSQLiteDatabase	SQLiteDatabase
    //   73	6	5	localObject2	Object
    //   27	30	6	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   11	70	73	finally
    //   75	78	73	finally
    //   2	11	81	finally
    //   78	81	81	finally
  }
  
  /* Error */
  final void a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/whatsapp/gcm/a/a:b	Lcom/whatsapp/gcm/a/g;
    //   6: astore 4
    //   8: aload 4
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 27	com/whatsapp/gcm/a/a:b	Lcom/whatsapp/gcm/a/g;
    //   15: invokevirtual 154	com/whatsapp/gcm/a/g:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   18: astore 5
    //   20: new 156	android/content/ContentValues
    //   23: dup
    //   24: invokespecial 157	android/content/ContentValues:<init>	()V
    //   27: astore 6
    //   29: aload 6
    //   31: ldc 75
    //   33: bipush 6
    //   35: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: invokevirtual 167	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   41: aload 6
    //   43: ldc 79
    //   45: aload_1
    //   46: invokevirtual 183	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   49: aload 6
    //   51: ldc 77
    //   53: lload_2
    //   54: invokestatic 172	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   57: invokevirtual 175	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   60: aload 5
    //   62: ldc 69
    //   64: aconst_null
    //   65: aload 6
    //   67: invokevirtual 179	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   70: pop2
    //   71: aload 5
    //   73: invokevirtual 114	android/database/sqlite/SQLiteDatabase:close	()V
    //   76: aload 4
    //   78: monitorexit
    //   79: aload_0
    //   80: monitorexit
    //   81: return
    //   82: astore_1
    //   83: aload 4
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	a
    //   0	93	1	paramString	String
    //   0	93	2	paramLong	long
    //   18	54	5	localSQLiteDatabase	SQLiteDatabase
    //   27	39	6	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   11	79	82	finally
    //   83	86	82	finally
    //   2	11	88	finally
    //   86	88	88	finally
  }
  
  public final void onEventAsync(i parami)
  {
    long l = b();
    this.c.post(b.a(this, parami, l));
  }
  
  public static final class a
  {
    public final long a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final long e;
    public final boolean f;
    public final int g;
    public final int h;
    public boolean i;
    public long j;
    
    public a(long paramLong1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong2, boolean paramBoolean4, int paramInt1, int paramInt2)
    {
      this.a = paramLong1;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      this.d = paramBoolean3;
      this.e = paramLong2;
      this.f = paramBoolean4;
      this.g = paramInt1;
      this.h = paramInt2;
    }
    
    public final String toString()
    {
      return "NetworkTimeline.Result: delayMsec=" + this.a + ", delayDataAvailable=" + this.b + ", deviceConnectedDuringDelay=" + this.c + ", xmppConnectData=" + this.d + ", xmppConnectMSec=" + this.e + ", messageReceivedBefore=" + this.i + ", messageReceivedMSec=" + this.j;
    }
  }
  
  public final class b
  {
    public int a;
    public int b;
    public long c;
    public String d;
    
    public b(int paramInt1, int paramInt2, long paramLong, String paramString)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramLong;
      this.d = paramString;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gcm/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */