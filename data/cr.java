package com.whatsapp.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.whatsapp.qz;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.a.c;
import com.whatsapp.util.bd;
import com.whatsapp.va;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class cr
{
  private static volatile cr a;
  private final Context b;
  private final va c;
  private final c d;
  private final e e;
  private final cj f;
  private final File g;
  private final n h;
  private final ReentrantReadWriteLock.ReadLock i;
  
  private cr(Context paramContext, va paramva, c paramc, e parame, cj paramcj, ch paramch)
  {
    this.b = paramContext;
    this.c = paramva;
    this.d = paramc;
    this.e = parame;
    this.f = paramcj;
    this.g = paramch.c;
    this.h = paramch.a;
    this.i = paramch.b.readLock();
  }
  
  public static cr a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new cr(u.a(), va.a(), c.a(), e.a(), cj.a(), ch.a());
      }
      return a;
    }
    finally {}
  }
  
  private int d()
  {
    this.i.lock();
    for (;;)
    {
      SQLiteDatabase localSQLiteDatabase;
      long l;
      Cursor localCursor;
      int j;
      int i1;
      int i4;
      Object localObject3;
      try
      {
        localSQLiteDatabase = this.h.getWritableDatabase();
        l = this.f.b("vcards_index_start");
        Log.i("vcardmsgstore/populate; idStart=" + l + "; batchSize=2048");
        localCursor = localSQLiteDatabase.rawQuery("SELECT _id, key_remote_jid, remote_resource, data, raw_data, media_caption, media_wa_type FROM messages WHERE _id>? ORDER BY _id ASC LIMIT 2048", new String[] { String.valueOf(l) });
        j = 0;
        if (localCursor != null)
        {
          try
          {
            localSQLiteDatabase.beginTransaction();
            int k = localCursor.getColumnIndex("_id");
            int m = localCursor.getColumnIndex("key_remote_jid");
            n = localCursor.getColumnIndex("data");
            i1 = localCursor.getColumnIndex("raw_data");
            int i2 = localCursor.getColumnIndex("media_wa_type");
            int i3 = localCursor.getColumnIndex("remote_resource");
            l = 0L;
            j = 0;
            if (!localCursor.moveToNext()) {
              break label371;
            }
            i4 = localCursor.getInt(i2);
            l = localCursor.getLong(k);
            localObject3 = localCursor.getString(m);
            String str2 = localCursor.getString(i3);
            if (localObject3 == null) {
              break label460;
            }
            localObject1 = localObject3;
            if (!qz.e((String)localObject3)) {
              break label431;
            }
            localObject1 = str2;
          }
          finally
          {
            int n;
            Object localObject1;
            localCursor.close();
            if (!localSQLiteDatabase.inTransaction()) {
              continue;
            }
            localSQLiteDatabase.endTransaction();
          }
          a(localCursor.getString(n), l, (String)localObject1);
        }
      }
      finally
      {
        this.i.unlock();
      }
      try
      {
        localObject3 = new ArrayList((List)new ObjectInputStream(new ByteArrayInputStream(localCursor.getBlob(i1))).readObject()).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          a((String)((Iterator)localObject3).next(), l, str1);
          continue;
          label371:
          switch (i4)
          {
          }
        }
      }
      catch (IOException localIOException)
      {
        Log.d("vcardmsgstore/populatevcardstablebatch error deserializing contact array", localIOException);
        break label460;
        if (l != 0L) {
          this.f.a("vcards_index_start", l);
        }
        localSQLiteDatabase.setTransactionSuccessful();
        localCursor.close();
        if (localSQLiteDatabase.inTransaction())
        {
          localSQLiteDatabase.endTransaction();
          this.i.unlock();
          return j;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;) {}
      }
      label431:
      label460:
      j += 1;
    }
  }
  
  /* Error */
  public final String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: aload_0
    //   10: getfield 47	com/whatsapp/data/cr:h	Lcom/whatsapp/data/n;
    //   13: invokevirtual 262	com/whatsapp/data/n:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 8
    //   18: aload 4
    //   20: astore_3
    //   21: aload 8
    //   23: ldc_w 264
    //   26: iconst_1
    //   27: anewarray 141	java/lang/String
    //   30: dup
    //   31: iconst_0
    //   32: aload_1
    //   33: aastore
    //   34: invokevirtual 151	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore 7
    //   39: aload 6
    //   41: astore_1
    //   42: aload 7
    //   44: ifnull +120 -> 164
    //   47: aload 4
    //   49: astore_3
    //   50: aload 7
    //   52: ldc_w 266
    //   55: invokeinterface 162 2 0
    //   60: istore_2
    //   61: aload 4
    //   63: astore_3
    //   64: aload 7
    //   66: invokeinterface 176 1 0
    //   71: pop
    //   72: aload 4
    //   74: astore_3
    //   75: aload 8
    //   77: ldc_w 268
    //   80: iconst_1
    //   81: anewarray 141	java/lang/String
    //   84: dup
    //   85: iconst_0
    //   86: aload 7
    //   88: iload_2
    //   89: invokeinterface 184 2 0
    //   94: invokestatic 145	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   97: aastore
    //   98: invokevirtual 151	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   101: astore 6
    //   103: aload 5
    //   105: astore_1
    //   106: aload 6
    //   108: ifnull +47 -> 155
    //   111: aload 4
    //   113: astore_3
    //   114: aload 6
    //   116: ldc_w 270
    //   119: invokeinterface 162 2 0
    //   124: istore_2
    //   125: aload 4
    //   127: astore_3
    //   128: aload 6
    //   130: invokeinterface 176 1 0
    //   135: pop
    //   136: aload 4
    //   138: astore_3
    //   139: aload 6
    //   141: iload_2
    //   142: invokeinterface 188 2 0
    //   147: astore_1
    //   148: aload 6
    //   150: invokeinterface 199 1 0
    //   155: aload_1
    //   156: astore_3
    //   157: aload 7
    //   159: invokeinterface 199 1 0
    //   164: aload_1
    //   165: areturn
    //   166: astore_1
    //   167: ldc_w 272
    //   170: aload_1
    //   171: invokestatic 250	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   174: aload_3
    //   175: areturn
    //   176: astore 4
    //   178: aload_1
    //   179: astore_3
    //   180: aload 4
    //   182: astore_1
    //   183: goto -16 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	cr
    //   0	186	1	paramString	String
    //   60	82	2	j	int
    //   20	160	3	localObject1	Object
    //   4	133	4	localObject2	Object
    //   176	5	4	localException	Exception
    //   7	97	5	localObject3	Object
    //   1	148	6	localCursor1	Cursor
    //   37	121	7	localCursor2	Cursor
    //   16	60	8	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   21	39	166	java/lang/Exception
    //   50	61	166	java/lang/Exception
    //   64	72	166	java/lang/Exception
    //   75	103	166	java/lang/Exception
    //   114	125	166	java/lang/Exception
    //   128	136	166	java/lang/Exception
    //   139	148	166	java/lang/Exception
    //   157	164	166	java/lang/Exception
    //   148	155	176	java/lang/Exception
  }
  
  /* Error */
  final void a(String paramString1, long paramLong, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +8 -> 9
    //   4: aload 4
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: getfield 31	com/whatsapp/data/cr:c	Lcom/whatsapp/va;
    //   14: invokevirtual 276	com/whatsapp/va:b	()Ljava/lang/String;
    //   17: ifnull +37 -> 54
    //   20: aload 4
    //   22: new 115	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   29: aload_0
    //   30: getfield 31	com/whatsapp/data/cr:c	Lcom/whatsapp/va;
    //   33: invokevirtual 276	com/whatsapp/va:b	()Ljava/lang/String;
    //   36: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc_w 279
    //   42: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokevirtual 283	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   51: ifne -42 -> 9
    //   54: aload_0
    //   55: getfield 35	com/whatsapp/data/cr:e	Lcom/whatsapp/data/e;
    //   58: aload 4
    //   60: invokevirtual 286	com/whatsapp/data/e:c	(Ljava/lang/String;)Lcom/whatsapp/data/cs;
    //   63: astore 7
    //   65: aload 7
    //   67: ifnull -58 -> 9
    //   70: aload 7
    //   72: getfield 291	com/whatsapp/data/cs:d	Lcom/whatsapp/data/cs$a;
    //   75: ifnull -66 -> 9
    //   78: aload_0
    //   79: getfield 29	com/whatsapp/data/cr:b	Landroid/content/Context;
    //   82: aload_0
    //   83: getfield 35	com/whatsapp/data/cr:e	Lcom/whatsapp/data/e;
    //   86: aload_1
    //   87: invokestatic 296	a/a/a/a/a/a:a	(Landroid/content/Context;Lcom/whatsapp/data/e;Ljava/lang/String;)La/a/a/a/a/a;
    //   90: astore 7
    //   92: aload 7
    //   94: ifnull -85 -> 9
    //   97: aload 7
    //   99: invokevirtual 298	a/a/a/a/a/a:b	()Z
    //   102: ifeq -93 -> 9
    //   105: new 300	android/content/ContentValues
    //   108: dup
    //   109: invokespecial 301	android/content/ContentValues:<init>	()V
    //   112: astore 8
    //   114: aload 8
    //   116: ldc_w 303
    //   119: lload_2
    //   120: invokestatic 308	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   123: invokevirtual 312	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   126: aload 8
    //   128: ldc_w 314
    //   131: aload 4
    //   133: invokevirtual 317	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload 8
    //   138: ldc_w 270
    //   141: aload_1
    //   142: invokevirtual 317	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload_0
    //   146: getfield 47	com/whatsapp/data/cr:h	Lcom/whatsapp/data/n;
    //   149: invokevirtual 108	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   152: ldc_w 319
    //   155: aconst_null
    //   156: aload 8
    //   158: invokevirtual 323	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   161: lstore 5
    //   163: aload 7
    //   165: getfield 326	a/a/a/a/a/a:h	Ljava/util/List;
    //   168: invokeinterface 327 1 0
    //   173: astore_1
    //   174: aload_1
    //   175: invokeinterface 242 1 0
    //   180: ifeq -171 -> 9
    //   183: aload_1
    //   184: invokeinterface 245 1 0
    //   189: checkcast 329	a/a/a/a/a/a$e
    //   192: astore 4
    //   194: aload 4
    //   196: getfield 332	a/a/a/a/a/a$e:e	Ljava/lang/String;
    //   199: invokestatic 338	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   202: ifne -28 -> 174
    //   205: new 300	android/content/ContentValues
    //   208: dup
    //   209: invokespecial 301	android/content/ContentValues:<init>	()V
    //   212: astore 7
    //   214: aload 7
    //   216: ldc_w 303
    //   219: lload_2
    //   220: invokestatic 308	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   223: invokevirtual 312	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   226: aload 7
    //   228: ldc_w 266
    //   231: lload 5
    //   233: invokestatic 308	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   236: invokevirtual 312	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   239: aload 7
    //   241: ldc_w 340
    //   244: new 115	java/lang/StringBuilder
    //   247: dup
    //   248: invokespecial 277	java/lang/StringBuilder:<init>	()V
    //   251: aload 4
    //   253: getfield 332	a/a/a/a/a/a$e:e	Ljava/lang/String;
    //   256: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: ldc_w 279
    //   262: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokevirtual 317	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: aload_0
    //   272: getfield 47	com/whatsapp/data/cr:h	Lcom/whatsapp/data/n;
    //   275: invokevirtual 108	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   278: ldc_w 342
    //   281: aconst_null
    //   282: aload 7
    //   284: invokevirtual 323	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   287: pop2
    //   288: goto -114 -> 174
    //   291: astore_1
    //   292: ldc_w 344
    //   295: aload_1
    //   296: invokestatic 250	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   299: return
    //   300: astore_1
    //   301: ldc_w 346
    //   304: aload_1
    //   305: invokestatic 250	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   308: aload_0
    //   309: getfield 33	com/whatsapp/data/cr:d	Lcom/whatsapp/util/a/c;
    //   312: new 115	java/lang/StringBuilder
    //   315: dup
    //   316: ldc_w 348
    //   319: invokespecial 120	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   322: aload_1
    //   323: invokevirtual 351	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   326: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: iconst_0
    //   333: aconst_null
    //   334: iconst_m1
    //   335: invokevirtual 354	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   338: return
    //   339: astore_1
    //   340: goto -48 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	cr
    //   0	343	1	paramString1	String
    //   0	343	2	paramLong	long
    //   0	343	4	paramString2	String
    //   161	71	5	l	long
    //   63	220	7	localObject	Object
    //   112	45	8	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   78	92	291	a/a/a/a/a/d
    //   97	174	291	a/a/a/a/a/d
    //   174	288	291	a/a/a/a/a/d
    //   78	92	300	java/lang/Exception
    //   97	174	300	java/lang/Exception
    //   174	288	300	java/lang/Exception
    //   78	92	339	java/io/IOException
    //   97	174	339	java/io/IOException
    //   174	288	339	java/io/IOException
  }
  
  public final int b(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = this.h.getReadableDatabase();
    try
    {
      paramString = localSQLiteDatabase.rawQuery("SELECT count(*) FROM messages_vcards_jids WHERE vcard_jid=?", new String[] { paramString });
      paramString.moveToFirst();
      j = paramString.getInt(0);
      Log.d("vcardmsgstore/getvcardscountbyjid error accessing db", paramString);
    }
    catch (Exception paramString)
    {
      try
      {
        paramString.close();
        return j;
      }
      catch (Exception paramString)
      {
        int j;
        for (;;) {}
      }
      paramString = paramString;
      j = 0;
    }
    return j;
  }
  
  public final boolean b()
  {
    return this.f.b("vcards_ready") != 0L;
  }
  
  public final void c()
  {
    long l1 = this.g.length();
    Log.i("vcardmsgstore/populate/beging/db size:" + l1 + " start:" + this.f.b("vcards_index_start"));
    bd localbd = new bd("msgstore/fts/populate");
    while (d() == 2048) {}
    Log.i("vcardmsgstore/populate time spent:" + localbd.b());
    this.f.a("vcards_ready", 1);
    this.f.a("vcards_version", 1);
    long l2 = this.g.length();
    Log.i("vcardmsgstore/populate/end/db size:" + l2 + " increase:" + l2 / l1);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */