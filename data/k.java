package com.whatsapp.data;

import android.database.sqlite.SQLiteDatabase;
import com.whatsapp.util.Log;

public class k
{
  private static volatile k b;
  public final n a;
  
  private k(ch paramch)
  {
    this.a = paramch.a;
  }
  
  public static k a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new k(ch.a());
      }
      return b;
    }
    finally {}
  }
  
  public static void a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    try
    {
      paramSQLiteDatabase.delete("conversion_tuples", "key_remote_jid=?", new String[] { paramString });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      Log.d("conversiontuplemsgstore/deleteConversionTuple error accessing db", paramSQLiteDatabase);
    }
  }
  
  /* Error */
  public final com.whatsapp.messaging.h a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/whatsapp/data/k:a	Lcom/whatsapp/data/n;
    //   4: invokevirtual 57	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore_2
    //   8: aload_2
    //   9: ldc 59
    //   11: iconst_1
    //   12: anewarray 36	java/lang/String
    //   15: dup
    //   16: iconst_0
    //   17: aload_1
    //   18: aastore
    //   19: invokevirtual 63	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore_2
    //   23: aload_2
    //   24: invokeinterface 69 1 0
    //   29: ifeq +134 -> 163
    //   32: new 71	com/whatsapp/messaging/h
    //   35: dup
    //   36: aload_1
    //   37: aload_2
    //   38: iconst_0
    //   39: invokeinterface 75 2 0
    //   44: aload_2
    //   45: iconst_1
    //   46: invokeinterface 75 2 0
    //   51: aload_2
    //   52: iconst_2
    //   53: invokeinterface 79 2 0
    //   58: invokespecial 82	com/whatsapp/messaging/h:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   61: astore_1
    //   62: aload_2
    //   63: invokeinterface 85 1 0
    //   68: aload_2
    //   69: ifnull +18 -> 87
    //   72: aload_2
    //   73: invokeinterface 88 1 0
    //   78: ifne +9 -> 87
    //   81: aload_2
    //   82: invokeinterface 85 1 0
    //   87: aload_1
    //   88: areturn
    //   89: astore_2
    //   90: aconst_null
    //   91: astore_1
    //   92: ldc 90
    //   94: aload_2
    //   95: invokestatic 50	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   98: aload_1
    //   99: ifnull +18 -> 117
    //   102: aload_1
    //   103: invokeinterface 88 1 0
    //   108: ifne +9 -> 117
    //   111: aload_1
    //   112: invokeinterface 85 1 0
    //   117: aconst_null
    //   118: areturn
    //   119: astore_1
    //   120: aconst_null
    //   121: astore_2
    //   122: aload_2
    //   123: ifnull +18 -> 141
    //   126: aload_2
    //   127: invokeinterface 88 1 0
    //   132: ifne +9 -> 141
    //   135: aload_2
    //   136: invokeinterface 85 1 0
    //   141: aload_1
    //   142: athrow
    //   143: astore_1
    //   144: goto -22 -> 122
    //   147: astore_3
    //   148: aload_1
    //   149: astore_2
    //   150: aload_3
    //   151: astore_1
    //   152: goto -30 -> 122
    //   155: astore_3
    //   156: aload_2
    //   157: astore_1
    //   158: aload_3
    //   159: astore_2
    //   160: goto -68 -> 92
    //   163: aconst_null
    //   164: astore_1
    //   165: goto -103 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	this	k
    //   0	168	1	paramString	String
    //   7	75	2	localObject1	Object
    //   89	6	2	localException1	Exception
    //   121	39	2	localObject2	Object
    //   147	4	3	localObject3	Object
    //   155	4	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   8	23	89	java/lang/Exception
    //   8	23	119	finally
    //   23	62	143	finally
    //   62	68	143	finally
    //   92	98	147	finally
    //   23	62	155	java/lang/Exception
    //   62	68	155	java/lang/Exception
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/whatsapp/data/k:a	Lcom/whatsapp/data/n;
    //   4: invokevirtual 57	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore_3
    //   8: aconst_null
    //   9: astore_1
    //   10: aload_3
    //   11: ldc 92
    //   13: iconst_0
    //   14: anewarray 36	java/lang/String
    //   17: invokevirtual 63	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   20: astore_2
    //   21: aload_2
    //   22: astore_1
    //   23: aload_1
    //   24: invokeinterface 69 1 0
    //   29: ifeq +84 -> 113
    //   32: new 71	com/whatsapp/messaging/h
    //   35: dup
    //   36: aload_1
    //   37: iconst_0
    //   38: invokeinterface 75 2 0
    //   43: aload_1
    //   44: iconst_1
    //   45: invokeinterface 75 2 0
    //   50: aload_1
    //   51: iconst_2
    //   52: invokeinterface 75 2 0
    //   57: aload_1
    //   58: iconst_3
    //   59: invokeinterface 79 2 0
    //   64: invokespecial 82	com/whatsapp/messaging/h:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 94	com/whatsapp/messaging/h:a	()Z
    //   72: ifeq -49 -> 23
    //   75: aload_3
    //   76: aload_2
    //   77: getfield 97	com/whatsapp/messaging/h:a	Ljava/lang/String;
    //   80: invokestatic 99	com/whatsapp/data/k:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)V
    //   83: goto -60 -> 23
    //   86: astore_2
    //   87: ldc 90
    //   89: aload_2
    //   90: invokestatic 50	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   93: aload_1
    //   94: ifnull +18 -> 112
    //   97: aload_1
    //   98: invokeinterface 88 1 0
    //   103: ifne +9 -> 112
    //   106: aload_1
    //   107: invokeinterface 85 1 0
    //   112: return
    //   113: aload_1
    //   114: invokeinterface 85 1 0
    //   119: aload_1
    //   120: ifnull -8 -> 112
    //   123: aload_1
    //   124: invokeinterface 88 1 0
    //   129: ifne -17 -> 112
    //   132: aload_1
    //   133: invokeinterface 85 1 0
    //   138: return
    //   139: astore_2
    //   140: aconst_null
    //   141: astore_1
    //   142: aload_1
    //   143: ifnull +18 -> 161
    //   146: aload_1
    //   147: invokeinterface 88 1 0
    //   152: ifne +9 -> 161
    //   155: aload_1
    //   156: invokeinterface 85 1 0
    //   161: aload_2
    //   162: athrow
    //   163: astore_2
    //   164: goto -22 -> 142
    //   167: astore_2
    //   168: goto -26 -> 142
    //   171: astore_2
    //   172: goto -85 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	k
    //   9	147	1	localObject1	Object
    //   20	57	2	localObject2	Object
    //   86	4	2	localException1	Exception
    //   139	23	2	localObject3	Object
    //   163	1	2	localObject4	Object
    //   167	1	2	localObject5	Object
    //   171	1	2	localException2	Exception
    //   7	69	3	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   23	83	86	java/lang/Exception
    //   113	119	86	java/lang/Exception
    //   10	21	139	finally
    //   23	83	163	finally
    //   113	119	163	finally
    //   87	93	167	finally
    //   10	21	171	java/lang/Exception
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */