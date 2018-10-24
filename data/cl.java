package com.whatsapp.data;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class cl
{
  private static volatile cl a;
  private final c b;
  private final l c;
  private final cn d;
  private final z e;
  private final n f;
  private final ReentrantReadWriteLock.ReadLock g;
  
  private cl(c paramc, l paraml, cn paramcn, aa paramaa, ch paramch)
  {
    this.b = paramc;
    this.c = paraml;
    this.d = paramcn;
    this.e = paramaa.a;
    this.f = paramch.a;
    this.g = paramch.b.readLock();
  }
  
  public static cl a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new cl(c.a(), l.a(), cn.a(), aa.a(), ch.a());
      }
      return a;
    }
    finally {}
  }
  
  /* Error */
  private java.util.List<j.b> b(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: new 82	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 83	java/util/ArrayList:<init>	()V
    //   9: astore 5
    //   11: aload_0
    //   12: getfield 52	com/whatsapp/data/cl:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   15: invokevirtual 88	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   18: aload_0
    //   19: getfield 41	com/whatsapp/data/cl:f	Lcom/whatsapp/data/n;
    //   22: invokevirtual 94	com/whatsapp/data/n:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   25: ldc 96
    //   27: iconst_1
    //   28: anewarray 98	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: lload_1
    //   34: invokestatic 102	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   37: aastore
    //   38: invokevirtual 108	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore 4
    //   43: aload 4
    //   45: ifnull +68 -> 113
    //   48: aload 4
    //   50: invokeinterface 114 1 0
    //   55: ifeq +51 -> 106
    //   58: aload 4
    //   60: iconst_0
    //   61: invokeinterface 118 2 0
    //   66: astore 6
    //   68: aload 4
    //   70: iconst_1
    //   71: invokeinterface 122 2 0
    //   76: iconst_1
    //   77: if_icmpne +46 -> 123
    //   80: aload 5
    //   82: new 124	com/whatsapp/protocol/j$b
    //   85: dup
    //   86: aload 6
    //   88: iload_3
    //   89: aload 4
    //   91: iconst_2
    //   92: invokeinterface 118 2 0
    //   97: invokespecial 127	com/whatsapp/protocol/j$b:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   100: invokeinterface 133 2 0
    //   105: pop
    //   106: aload 4
    //   108: invokeinterface 136 1 0
    //   113: aload_0
    //   114: getfield 52	com/whatsapp/data/cl:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   117: invokevirtual 139	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   120: aload 5
    //   122: areturn
    //   123: iconst_0
    //   124: istore_3
    //   125: goto -45 -> 80
    //   128: astore 5
    //   130: aload 4
    //   132: invokeinterface 136 1 0
    //   137: aload 5
    //   139: athrow
    //   140: astore 4
    //   142: aload_0
    //   143: getfield 52	com/whatsapp/data/cl:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   146: invokevirtual 139	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   149: aload 4
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	cl
    //   0	152	1	paramLong	long
    //   1	124	3	bool	boolean
    //   41	90	4	localCursor	Cursor
    //   140	10	4	localObject1	Object
    //   9	112	5	localArrayList	java.util.ArrayList
    //   128	10	5	localObject2	Object
    //   66	21	6	str	String
    // Exception table:
    //   from	to	target	type
    //   48	80	128	finally
    //   80	106	128	finally
    //   18	43	140	finally
    //   106	113	140	finally
    //   130	140	140	finally
  }
  
  /* Error */
  public final boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: lload_1
    //   2: invokespecial 146	com/whatsapp/data/cl:b	(J)Ljava/util/List;
    //   5: astore 4
    //   7: new 82	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 83	java/util/ArrayList:<init>	()V
    //   14: astore 6
    //   16: aload 4
    //   18: invokeinterface 150 1 0
    //   23: astore 4
    //   25: aload 4
    //   27: invokeinterface 155 1 0
    //   32: ifeq +78 -> 110
    //   35: aload 4
    //   37: invokeinterface 159 1 0
    //   42: checkcast 124	com/whatsapp/protocol/j$b
    //   45: astore 5
    //   47: aload_0
    //   48: getfield 27	com/whatsapp/data/cl:c	Lcom/whatsapp/data/l;
    //   51: aload 5
    //   53: invokevirtual 162	com/whatsapp/data/l:a	(Lcom/whatsapp/protocol/j$b;)Lcom/whatsapp/protocol/j;
    //   56: astore 5
    //   58: aload 5
    //   60: ifnull -35 -> 25
    //   63: aload 5
    //   65: getfield 168	com/whatsapp/protocol/j:N	Ljava/lang/Object;
    //   68: instanceof 170
    //   71: ifeq -46 -> 25
    //   74: aload 5
    //   76: invokevirtual 173	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   79: iconst_0
    //   80: putfield 177	com/whatsapp/MediaData:hasStreamingSidecar	Z
    //   83: aload 6
    //   85: aload 5
    //   87: invokeinterface 133 2 0
    //   92: pop
    //   93: aload_0
    //   94: getfield 35	com/whatsapp/data/cl:e	Lcom/whatsapp/data/z;
    //   97: aload 5
    //   99: getfield 180	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
    //   102: aload 5
    //   104: invokevirtual 185	com/whatsapp/data/z:a	(Lcom/whatsapp/protocol/j$b;Lcom/whatsapp/protocol/j;)V
    //   107: goto -82 -> 25
    //   110: aconst_null
    //   111: astore 4
    //   113: aload_0
    //   114: getfield 52	com/whatsapp/data/cl:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   117: invokevirtual 88	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   120: aload_0
    //   121: getfield 41	com/whatsapp/data/cl:f	Lcom/whatsapp/data/n;
    //   124: invokevirtual 188	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   127: astore 5
    //   129: aload 5
    //   131: astore 4
    //   133: aload_0
    //   134: getfield 29	com/whatsapp/data/cl:d	Lcom/whatsapp/data/cn;
    //   137: invokevirtual 190	com/whatsapp/data/cn:b	()V
    //   140: aload 5
    //   142: astore 4
    //   144: aload 5
    //   146: invokevirtual 193	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   149: aload 5
    //   151: astore 4
    //   153: aload 6
    //   155: invokeinterface 150 1 0
    //   160: astore 6
    //   162: aload 5
    //   164: astore 4
    //   166: aload 6
    //   168: invokeinterface 155 1 0
    //   173: ifeq +101 -> 274
    //   176: aload 5
    //   178: astore 4
    //   180: aload 6
    //   182: invokeinterface 159 1 0
    //   187: checkcast 164	com/whatsapp/protocol/j
    //   190: astore 7
    //   192: aload 5
    //   194: astore 4
    //   196: aload_0
    //   197: getfield 29	com/whatsapp/data/cl:d	Lcom/whatsapp/data/cn;
    //   200: getfield 197	com/whatsapp/data/cn:h	Landroid/database/sqlite/SQLiteStatement;
    //   203: astore 8
    //   205: aload 5
    //   207: astore 4
    //   209: aload_0
    //   210: getfield 25	com/whatsapp/data/cl:b	Lcom/whatsapp/data/c;
    //   213: aload 7
    //   215: aload 8
    //   217: invokevirtual 200	com/whatsapp/data/c:b	(Lcom/whatsapp/protocol/j;Landroid/database/sqlite/SQLiteStatement;)V
    //   220: aload 5
    //   222: astore 4
    //   224: aload 8
    //   226: invokevirtual 205	android/database/sqlite/SQLiteStatement:execute	()V
    //   229: goto -67 -> 162
    //   232: astore 6
    //   234: aload 5
    //   236: astore 4
    //   238: aload 6
    //   240: astore 5
    //   242: aload 5
    //   244: invokestatic 210	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   247: aload 4
    //   249: ifnull +16 -> 265
    //   252: aload 4
    //   254: invokevirtual 213	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   257: ifeq +8 -> 265
    //   260: aload 4
    //   262: invokevirtual 216	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   265: aload_0
    //   266: getfield 52	com/whatsapp/data/cl:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   269: invokevirtual 139	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   272: iconst_0
    //   273: ireturn
    //   274: aload 5
    //   276: astore 4
    //   278: aload 5
    //   280: ldc -38
    //   282: ldc -36
    //   284: iconst_1
    //   285: anewarray 98	java/lang/String
    //   288: dup
    //   289: iconst_0
    //   290: lload_1
    //   291: invokestatic 102	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   294: aastore
    //   295: invokevirtual 224	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   298: istore_3
    //   299: aload 5
    //   301: astore 4
    //   303: new 226	java/lang/StringBuilder
    //   306: dup
    //   307: ldc -28
    //   309: invokespecial 231	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   312: lload_1
    //   313: invokevirtual 235	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   316: ldc -19
    //   318: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: iload_3
    //   322: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   325: invokevirtual 247	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 250	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   331: aload 5
    //   333: astore 4
    //   335: aload 5
    //   337: invokevirtual 253	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   340: aload 5
    //   342: ifnull +16 -> 358
    //   345: aload 5
    //   347: invokevirtual 213	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   350: ifeq +8 -> 358
    //   353: aload 5
    //   355: invokevirtual 216	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   358: aload_0
    //   359: getfield 52	com/whatsapp/data/cl:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   362: invokevirtual 139	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   365: iconst_1
    //   366: ireturn
    //   367: astore 6
    //   369: aload 4
    //   371: astore 5
    //   373: aload 6
    //   375: astore 4
    //   377: aload 5
    //   379: ifnull +16 -> 395
    //   382: aload 5
    //   384: invokevirtual 213	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   387: ifeq +8 -> 395
    //   390: aload 5
    //   392: invokevirtual 216	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   395: aload 4
    //   397: athrow
    //   398: astore 4
    //   400: aload_0
    //   401: getfield 52	com/whatsapp/data/cl:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   404: invokevirtual 139	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   407: aload 4
    //   409: athrow
    //   410: astore 6
    //   412: aload 4
    //   414: astore 5
    //   416: aload 6
    //   418: astore 4
    //   420: goto -43 -> 377
    //   423: astore 5
    //   425: aconst_null
    //   426: astore 4
    //   428: goto -186 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	cl
    //   0	431	1	paramLong	long
    //   298	24	3	i	int
    //   5	391	4	localObject1	Object
    //   398	15	4	localObject2	Object
    //   418	9	4	localObject3	Object
    //   45	370	5	localObject4	Object
    //   423	1	5	localIOException1	java.io.IOException
    //   14	167	6	localObject5	Object
    //   232	7	6	localIOException2	java.io.IOException
    //   367	7	6	localObject6	Object
    //   410	7	6	localObject7	Object
    //   190	24	7	localj	com.whatsapp.protocol.j
    //   203	22	8	localSQLiteStatement	android.database.sqlite.SQLiteStatement
    // Exception table:
    //   from	to	target	type
    //   133	140	232	java/io/IOException
    //   144	149	232	java/io/IOException
    //   153	162	232	java/io/IOException
    //   166	176	232	java/io/IOException
    //   180	192	232	java/io/IOException
    //   196	205	232	java/io/IOException
    //   209	220	232	java/io/IOException
    //   224	229	232	java/io/IOException
    //   278	299	232	java/io/IOException
    //   303	331	232	java/io/IOException
    //   335	340	232	java/io/IOException
    //   120	129	367	finally
    //   133	140	367	finally
    //   144	149	367	finally
    //   153	162	367	finally
    //   166	176	367	finally
    //   180	192	367	finally
    //   196	205	367	finally
    //   209	220	367	finally
    //   224	229	367	finally
    //   278	299	367	finally
    //   303	331	367	finally
    //   335	340	367	finally
    //   252	265	398	finally
    //   345	358	398	finally
    //   382	395	398	finally
    //   395	398	398	finally
    //   242	247	410	finally
    //   120	129	423	java/io/IOException
  }
  
  /* Error */
  public final boolean a(byte[] paramArrayOfByte, j.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/whatsapp/data/cl:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   4: invokevirtual 88	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   7: new 262	android/content/ContentValues
    //   10: dup
    //   11: invokespecial 263	android/content/ContentValues:<init>	()V
    //   14: astore 4
    //   16: aload 4
    //   18: ldc_w 265
    //   21: aload_1
    //   22: invokevirtual 269	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   25: aload 4
    //   27: ldc_w 271
    //   30: aload_2
    //   31: getfield 274	com/whatsapp/protocol/j$b:a	Ljava/lang/String;
    //   34: invokevirtual 277	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_2
    //   38: getfield 279	com/whatsapp/protocol/j$b:b	Z
    //   41: ifeq +72 -> 113
    //   44: iconst_1
    //   45: istore_3
    //   46: aload 4
    //   48: ldc_w 281
    //   51: iload_3
    //   52: invokestatic 283	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   55: invokevirtual 277	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload 4
    //   60: ldc_w 285
    //   63: aload_2
    //   64: getfield 287	com/whatsapp/protocol/j$b:c	Ljava/lang/String;
    //   67: invokevirtual 277	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload 4
    //   72: ldc_w 289
    //   75: invokestatic 295	java/lang/System:currentTimeMillis	()J
    //   78: ldc2_w 296
    //   81: ldiv
    //   82: invokestatic 302	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   85: invokevirtual 305	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   88: aload_0
    //   89: getfield 41	com/whatsapp/data/cl:f	Lcom/whatsapp/data/n;
    //   92: invokevirtual 188	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   95: ldc -38
    //   97: aconst_null
    //   98: aload 4
    //   100: invokevirtual 309	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   103: pop2
    //   104: aload_0
    //   105: getfield 52	com/whatsapp/data/cl:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   108: invokevirtual 139	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   111: iconst_1
    //   112: ireturn
    //   113: iconst_0
    //   114: istore_3
    //   115: goto -69 -> 46
    //   118: astore_1
    //   119: ldc_w 311
    //   122: aload_1
    //   123: invokestatic 314	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   126: aload_0
    //   127: getfield 52	com/whatsapp/data/cl:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   130: invokevirtual 139	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   133: iconst_0
    //   134: ireturn
    //   135: astore_1
    //   136: aload_1
    //   137: invokestatic 210	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   140: aload_1
    //   141: athrow
    //   142: astore_1
    //   143: aload_0
    //   144: getfield 52	com/whatsapp/data/cl:g	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   147: invokevirtual 139	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   150: aload_1
    //   151: athrow
    //   152: astore_1
    //   153: goto -17 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	cl
    //   0	156	1	paramArrayOfByte	byte[]
    //   0	156	2	paramb	j.b
    //   45	70	3	i	int
    //   14	85	4	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   7	44	118	android/database/sqlite/SQLiteDatabaseCorruptException
    //   46	104	118	android/database/sqlite/SQLiteDatabaseCorruptException
    //   7	44	135	java/lang/RuntimeException
    //   46	104	135	java/lang/RuntimeException
    //   7	44	142	finally
    //   46	104	142	finally
    //   119	126	142	finally
    //   136	142	142	finally
    //   7	44	152	java/lang/Error
    //   46	104	152	java/lang/Error
  }
  
  public final byte[] a(j.b paramb)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    int i = 1;
    if (paramb == null) {
      return null;
    }
    this.g.lock();
    for (;;)
    {
      try
      {
        Object localObject3 = this.f.getReadableDatabase();
        String str = paramb.a;
        if (paramb.b)
        {
          localObject3 = ((SQLiteDatabase)localObject3).rawQuery("SELECT sidecar FROM media_streaming_sidecar WHERE key_remote_jid=? AND key_from_me=? AND key_id=?", new String[] { str, String.valueOf(i), paramb.c });
          if (localObject3 != null) {
            paramb = (j.b)localObject1;
          }
        }
        else
        {
          try
          {
            if (((Cursor)localObject3).moveToLast()) {
              paramb = ((Cursor)localObject3).getBlob(0);
            }
            ((Cursor)localObject3).close();
            return paramb;
          }
          finally
          {
            ((Cursor)localObject3).close();
          }
          i = 0;
          continue;
        }
        Log.e("sidecarmsgstore/getStreamingSidecar no cursor");
      }
      finally
      {
        this.g.unlock();
      }
      paramb = (j.b)localObject2;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */