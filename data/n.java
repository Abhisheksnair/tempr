package com.whatsapp.data;

import a.a.a.a.d;
import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.whatsapp.registration.bb;
import com.whatsapp.util.Log;
import com.whatsapp.vv;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;

public final class n
  extends SQLiteOpenHelper
{
  @SuppressLint({"InlinedApi"})
  public static final int h;
  SQLiteDatabase a;
  boolean b;
  boolean c;
  boolean d;
  boolean e;
  final File f;
  public int g;
  private final Context i;
  private final vv j;
  private final bb k;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (int m = 536870912;; m = 0)
    {
      h = m | 0x10;
      return;
    }
  }
  
  n(Context paramContext, vv paramvv, bb parambb, File paramFile)
  {
    super(paramContext, "msgstore.db", null, 1);
    this.k = parambb;
    this.j = paramvv;
    this.f = paramFile;
    this.i = paramContext;
  }
  
  private String a(String paramString)
  {
    String str1 = "";
    Cursor localCursor = this.a.rawQuery("select sql from sqlite_master where type='table' and name='" + paramString + "';", null);
    String str2 = str1;
    if (localCursor != null) {}
    try
    {
      if (localCursor.moveToNext()) {
        str1 = localCursor.getString(0);
      }
      localCursor.close();
      str2 = str1;
      return str2;
    }
    catch (Exception localException)
    {
      Log.d("msgstore/getwritabledb/messages schema " + paramString, localException);
      return "";
    }
    finally
    {
      localCursor.close();
    }
  }
  
  static void a(int paramInt, Object paramObject, SQLiteStatement paramSQLiteStatement)
  {
    if (paramObject == null)
    {
      paramSQLiteStatement.bindNull(paramInt);
      return;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    new ObjectOutputStream(localByteArrayOutputStream).writeObject(paramObject);
    paramSQLiteStatement.bindBlob(paramInt, localByteArrayOutputStream.toByteArray());
  }
  
  static void a(int paramInt, String paramString, SQLiteStatement paramSQLiteStatement)
  {
    if (paramString == null)
    {
      paramSQLiteStatement.bindNull(paramInt);
      return;
    }
    paramSQLiteStatement.bindString(paramInt, paramString);
  }
  
  static void a(int paramInt, byte[] paramArrayOfByte, SQLiteStatement paramSQLiteStatement)
  {
    if (paramArrayOfByte == null)
    {
      paramSQLiteStatement.bindNull(paramInt);
      return;
    }
    paramSQLiteStatement.bindBlob(paramInt, paramArrayOfByte);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!paramString1.contains(paramString3 + " " + paramString4)) {}
    try
    {
      this.a.execSQL("ALTER TABLE " + paramString2 + " ADD " + paramString3 + " " + paramString4);
      return;
    }
    catch (SQLiteException paramString1)
    {
      Log.c("msgstore/alter_table " + paramString3, paramString1);
    }
  }
  
  private boolean b(String paramString)
  {
    str = "";
    localCursor = this.a.rawQuery("select sql from sqlite_master where type='index' and name='" + paramString + "';", null);
    paramString = str;
    if (localCursor != null) {
      paramString = str;
    }
    try
    {
      if (localCursor.moveToNext()) {
        paramString = localCursor.getString(0);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.d("msgstore/getwritabledb/mediatypeindex ", paramString);
        localCursor.close();
        paramString = str;
      }
    }
    finally
    {
      localCursor.close();
    }
    return !TextUtils.isEmpty(paramString);
  }
  
  /* Error */
  private boolean f()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc -82
    //   4: invokestatic 176	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   7: new 178	com/whatsapp/util/bd
    //   10: dup
    //   11: ldc -82
    //   13: invokespecial 179	com/whatsapp/util/bd:<init>	(Ljava/lang/String;)V
    //   16: astore 4
    //   18: aload_0
    //   19: getfield 58	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   22: ldc -75
    //   24: aconst_null
    //   25: invokevirtual 81	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull +247 -> 277
    //   33: new 60	java/lang/StringBuilder
    //   36: dup
    //   37: ldc -73
    //   39: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: aload_3
    //   43: invokeinterface 187 1 0
    //   48: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 176	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   57: aload_3
    //   58: invokeinterface 87 1 0
    //   63: ifeq +74 -> 137
    //   66: aload_0
    //   67: aload_3
    //   68: iconst_0
    //   69: invokeinterface 194 2 0
    //   74: putfield 196	com/whatsapp/data/n:g	I
    //   77: aload_0
    //   78: getfield 196	com/whatsapp/data/n:g	I
    //   81: ifle +13 -> 94
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 196	com/whatsapp/data/n:g	I
    //   89: iconst_1
    //   90: isub
    //   91: putfield 196	com/whatsapp/data/n:g	I
    //   94: new 60	java/lang/StringBuilder
    //   97: dup
    //   98: ldc -58
    //   100: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   103: aload_0
    //   104: getfield 196	com/whatsapp/data/n:g	I
    //   107: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: ldc -56
    //   112: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 4
    //   117: invokevirtual 203	com/whatsapp/util/bd:b	()J
    //   120: invokevirtual 206	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   123: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 176	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   129: aload_3
    //   130: invokeinterface 94 1 0
    //   135: iconst_1
    //   136: ireturn
    //   137: aload_3
    //   138: invokeinterface 94 1 0
    //   143: iconst_0
    //   144: istore_1
    //   145: new 60	java/lang/StringBuilder
    //   148: dup
    //   149: ldc -48
    //   151: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   154: aload 4
    //   156: invokevirtual 203	com/whatsapp/util/bd:b	()J
    //   159: invokevirtual 206	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   162: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 176	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   168: iload_1
    //   169: ifeq +13 -> 182
    //   172: ldc -46
    //   174: invokestatic 176	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   177: aload_0
    //   178: invokevirtual 212	com/whatsapp/data/n:a	()Z
    //   181: pop
    //   182: iconst_0
    //   183: ireturn
    //   184: astore 4
    //   186: aload_0
    //   187: getfield 51	com/whatsapp/data/n:i	Landroid/content/Context;
    //   190: invokestatic 217	a/a/a/a/d:g	(Landroid/content/Context;)V
    //   193: aload 4
    //   195: athrow
    //   196: astore 4
    //   198: aload_3
    //   199: invokeinterface 94 1 0
    //   204: aload 4
    //   206: athrow
    //   207: astore_3
    //   208: ldc -37
    //   210: invokestatic 222	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   213: iload_2
    //   214: istore_1
    //   215: goto -47 -> 168
    //   218: astore 5
    //   220: aload 5
    //   222: invokevirtual 223	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   225: ldc -31
    //   227: invokevirtual 147	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   230: ifeq +19 -> 249
    //   233: ldc -29
    //   235: invokestatic 222	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   238: aload_3
    //   239: invokeinterface 94 1 0
    //   244: iconst_1
    //   245: istore_1
    //   246: goto -101 -> 145
    //   249: aload 5
    //   251: athrow
    //   252: astore_3
    //   253: aload_3
    //   254: invokevirtual 223	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   257: ldc -31
    //   259: invokevirtual 147	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   262: ifeq +13 -> 275
    //   265: ldc -27
    //   267: invokestatic 222	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   270: iload_2
    //   271: istore_1
    //   272: goto -104 -> 168
    //   275: aload_3
    //   276: athrow
    //   277: iconst_0
    //   278: istore_1
    //   279: goto -134 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	n
    //   144	135	1	m	int
    //   1	270	2	n	int
    //   28	171	3	localCursor	Cursor
    //   207	32	3	localSQLiteDatabaseCorruptException	SQLiteDatabaseCorruptException
    //   252	24	3	localSQLiteException1	SQLiteException
    //   16	139	4	localbd	com.whatsapp.util.bd
    //   184	10	4	localSQLiteFullException	android.database.sqlite.SQLiteFullException
    //   196	9	4	localObject	Object
    //   218	32	5	localSQLiteException2	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   33	94	184	android/database/sqlite/SQLiteFullException
    //   94	129	184	android/database/sqlite/SQLiteFullException
    //   33	94	196	finally
    //   94	129	196	finally
    //   186	196	196	finally
    //   220	238	196	finally
    //   249	252	196	finally
    //   18	29	207	android/database/sqlite/SQLiteDatabaseCorruptException
    //   129	135	207	android/database/sqlite/SQLiteDatabaseCorruptException
    //   137	143	207	android/database/sqlite/SQLiteDatabaseCorruptException
    //   145	168	207	android/database/sqlite/SQLiteDatabaseCorruptException
    //   198	207	207	android/database/sqlite/SQLiteDatabaseCorruptException
    //   238	244	207	android/database/sqlite/SQLiteDatabaseCorruptException
    //   33	94	218	android/database/sqlite/SQLiteException
    //   94	129	218	android/database/sqlite/SQLiteException
    //   18	29	252	android/database/sqlite/SQLiteException
    //   129	135	252	android/database/sqlite/SQLiteException
    //   137	143	252	android/database/sqlite/SQLiteException
    //   145	168	252	android/database/sqlite/SQLiteException
    //   198	207	252	android/database/sqlite/SQLiteException
    //   238	244	252	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  private boolean g()
  {
    // Byte code:
    //   0: ldc -25
    //   2: invokestatic 176	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   5: new 178	com/whatsapp/util/bd
    //   8: dup
    //   9: ldc -25
    //   11: invokespecial 179	com/whatsapp/util/bd:<init>	(Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_0
    //   16: getfield 58	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   19: invokevirtual 234	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   22: aload_0
    //   23: getfield 58	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   26: ldc -20
    //   28: invokevirtual 154	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 58	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   35: invokevirtual 239	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   38: new 60	java/lang/StringBuilder
    //   41: dup
    //   42: ldc -15
    //   44: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   47: aload_1
    //   48: invokevirtual 203	com/whatsapp/util/bd:b	()J
    //   51: invokevirtual 206	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   54: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 176	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   60: aload_0
    //   61: getfield 58	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   64: ifnull +20 -> 84
    //   67: aload_0
    //   68: getfield 58	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   71: invokevirtual 244	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   74: ifeq +10 -> 84
    //   77: aload_0
    //   78: getfield 58	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   81: invokevirtual 247	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   84: iconst_1
    //   85: ireturn
    //   86: astore_1
    //   87: ldc -7
    //   89: invokestatic 222	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   92: aload_0
    //   93: invokevirtual 212	com/whatsapp/data/n:a	()Z
    //   96: pop
    //   97: aload_0
    //   98: getfield 58	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   101: ifnull +20 -> 121
    //   104: aload_0
    //   105: getfield 58	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   108: invokevirtual 244	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   111: ifeq +10 -> 121
    //   114: aload_0
    //   115: getfield 58	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   118: invokevirtual 247	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   121: iconst_0
    //   122: ireturn
    //   123: astore_1
    //   124: aload_0
    //   125: getfield 51	com/whatsapp/data/n:i	Landroid/content/Context;
    //   128: invokestatic 217	a/a/a/a/d:g	(Landroid/content/Context;)V
    //   131: aload_1
    //   132: athrow
    //   133: astore_1
    //   134: aload_0
    //   135: getfield 58	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   138: ifnull +20 -> 158
    //   141: aload_0
    //   142: getfield 58	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   145: invokevirtual 244	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   148: ifeq +10 -> 158
    //   151: aload_0
    //   152: getfield 58	com/whatsapp/data/n:a	Landroid/database/sqlite/SQLiteDatabase;
    //   155: invokevirtual 247	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   158: aload_1
    //   159: athrow
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 223	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   165: ldc -5
    //   167: invokevirtual 147	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   170: ifeq +22 -> 192
    //   173: aload_0
    //   174: getfield 51	com/whatsapp/data/n:i	Landroid/content/Context;
    //   177: aload_0
    //   178: getfield 51	com/whatsapp/data/n:i	Landroid/content/Context;
    //   181: ldc -4
    //   183: invokevirtual 255	android/content/Context:getString	(I)Ljava/lang/String;
    //   186: iconst_2
    //   187: invokestatic 258	a/a/a/a/d:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   190: aload_1
    //   191: athrow
    //   192: aload_1
    //   193: invokevirtual 223	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   196: ldc_w 260
    //   199: invokevirtual 147	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   202: ifeq -12 -> 190
    //   205: aload_0
    //   206: getfield 51	com/whatsapp/data/n:i	Landroid/content/Context;
    //   209: aload_0
    //   210: getfield 51	com/whatsapp/data/n:i	Landroid/content/Context;
    //   213: ldc_w 261
    //   216: invokevirtual 255	android/content/Context:getString	(I)Ljava/lang/String;
    //   219: iconst_2
    //   220: invokestatic 258	a/a/a/a/d:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   223: goto -33 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	n
    //   14	34	1	localbd	com.whatsapp.util.bd
    //   86	1	1	localSQLiteDatabaseCorruptException	SQLiteDatabaseCorruptException
    //   123	9	1	localSQLiteFullException	android.database.sqlite.SQLiteFullException
    //   133	26	1	localObject	Object
    //   160	33	1	localSQLiteException	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   15	60	86	android/database/sqlite/SQLiteDatabaseCorruptException
    //   15	60	123	android/database/sqlite/SQLiteFullException
    //   15	60	133	finally
    //   87	97	133	finally
    //   124	133	133	finally
    //   161	190	133	finally
    //   190	192	133	finally
    //   192	223	133	finally
    //   15	60	160	android/database/sqlite/SQLiteException
  }
  
  private boolean h()
  {
    Log.i("msgstore/open-existing-db" + this.f.getAbsolutePath());
    ad.a(this.f, "msgstore/open-existing-db/list ");
    boolean bool2;
    if (!this.f.exists())
    {
      Log.i("msgstore/open-existing-db/no-file");
      if (this.k.b()) {
        d.i(this.i);
      }
      bool2 = false;
      return bool2;
    }
    int i2 = 0;
    int m = 0;
    int n = -1;
    int i1;
    for (;;)
    {
      i1 = n;
      try
      {
        this.a = SQLiteDatabase.openDatabase(this.f.getAbsolutePath(), null, h);
        i1 = n;
        n = this.a.getVersion();
        i1 = n;
        Log.i("msgstore/open-existing-db/version " + n);
      }
      catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
      {
        for (;;)
        {
          Log.d("msgstore/open-existing-db/corrupt", localSQLiteDatabaseCorruptException);
          n = -1;
        }
      }
      catch (SQLiteException localSQLiteException)
      {
        for (;;)
        {
          n = i1;
          StringBuilder localStringBuilder = new StringBuilder("msgstore/open-existing-db/nodb/sqlerror");
          if (i2 == 0) {}
          for (String str = "/will-retry ";; str = " ")
          {
            Log.w(str + localSQLiteException);
            if (i2 > 0) {
              Log.i("msgstore/open-existing-db/stack " + d.m());
            }
            m = 1;
            break;
          }
          boolean bool1 = false;
        }
        i2 += 1;
      }
      if ((m == 0) || (i2 != 0)) {
        if ((this.a != null) && (n > 0) && (n <= 1))
        {
          bool1 = true;
          if ((!bool1) && (this.k.b())) {
            d.i(this.i);
          }
          bool2 = bool1;
          if (this.a == null) {
            break;
          }
          if (this.a.isReadOnly()) {
            Log.w("msgstore/open-existing-db/ is read only");
          }
          bool2 = bool1;
          if (bool1) {
            break;
          }
          this.a.close();
          this.a = null;
          return bool1;
        }
      }
    }
  }
  
  final boolean a()
  {
    return this.f.delete() | new File(this.f.getPath() + "-journal").delete() | new File(this.f.getPath() + "-shm").delete() | new File(this.f.getPath() + "-wal").delete();
  }
  
  final void b()
  {
    if ((!this.c) && (this.a != null) && (this.a.isOpen()))
    {
      this.a.execSQL("CREATE INDEX media_type_index on messages (media_wa_type)");
      this.c = true;
    }
  }
  
  final void c()
  {
    if ((!this.d) && (this.a != null) && (this.a.isOpen()))
    {
      this.a.execSQL("CREATE INDEX messages_jid_id_index on messages (key_remote_jid, _id)");
      this.d = true;
    }
  }
  
  public final void close()
  {
    try
    {
      if ((this.a != null) && (this.a.isOpen())) {
        this.a.close();
      }
      this.a = null;
      return;
    }
    finally {}
  }
  
  final void d()
  {
    if ((!this.e) && (this.a != null) && (this.a.isOpen()))
    {
      this.a.execSQL("CREATE INDEX media_type_jid_index on messages (key_remote_jid, media_wa_type)");
      this.e = true;
    }
  }
  
  final void e()
  {
    if ((this.a != null) && (this.a.isOpen())) {
      this.a.execSQL("CREATE INDEX IF NOT EXISTS starred_index on messages (starred)");
    }
  }
  
  public final SQLiteDatabase getReadableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      return localSQLiteDatabase;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    try
    {
      if (ad.a) {
        throw new ad.f("Db has been deleted, waiting for exiting the app");
      }
    }
    finally {}
    Object localObject2;
    if ((this.a != null) && (this.a.isOpen())) {
      localObject2 = this.a;
    }
    for (;;)
    {
      return (SQLiteDatabase)localObject2;
      if ((!h()) || (!f()) || (!g()))
      {
        close();
        localObject2 = null;
        continue;
      }
      try
      {
        localObject2 = a("messages");
        a((String)localObject2, "messages", "raw_data", "BLOB");
        a((String)localObject2, "messages", "media_hash", "TEXT");
        a((String)localObject2, "messages", "media_duration", "INTEGER");
        a((String)localObject2, "messages", "origin", "INTEGER");
        a((String)localObject2, "messages", "recipient_count", "INTEGER");
        a((String)localObject2, "messages", "read_device_timestamp", "INTEGER");
        a((String)localObject2, "messages", "played_device_timestamp", "INTEGER");
        a((String)localObject2, "messages", "media_caption", "TEXT");
        a((String)localObject2, "messages", "participant_hash", "TEXT");
        a((String)localObject2, "messages", "starred", "INTEGER");
        a((String)localObject2, "messages", "quoted_row_id", "INTEGER");
        a((String)localObject2, "messages", "mentioned_jids", "TEXT");
        a((String)localObject2, "messages", "multicast_id", "TEXT");
        a((String)localObject2, "messages", "edit_version", "INTEGER");
        a((String)localObject2, "messages", "media_enc_hash", "TEXT");
        localObject2 = a("messages_quotes");
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.a.execSQL("CREATE TABLE messages_quotes (_id INTEGER PRIMARY KEY AUTOINCREMENT, key_remote_jid TEXT NOT NULL, key_from_me INTEGER, key_id TEXT NOT NULL, status INTEGER, needs_push INTEGER, data TEXT, timestamp INTEGER, media_url TEXT, media_mime_type TEXT, media_wa_type TEXT, media_size INTEGER, media_name TEXT, media_caption TEXT, media_hash TEXT, media_duration INTEGER, origin INTEGER, latitude REAL, longitude REAL, thumb_image TEXT, remote_resource TEXT, received_timestamp INTEGER, send_timestamp INTEGER, receipt_server_timestamp INTEGER, receipt_device_timestamp INTEGER, read_device_timestamp INTEGER, played_device_timestamp INTEGER, raw_data BLOB, recipient_count INTEGER, participant_hash TEXT, starred INTEGER, quoted_row_id INTEGER, mentioned_jids TEXT, multicast_id TEXT, edit_version INTEGER, media_enc_hash TEXT)");
          this.a.execSQL("CREATE TRIGGER messages_bd_for_quotes_trigger BEFORE DELETE ON messages BEGIN DELETE FROM messages_quotes WHERE _id=old.quoted_row_id; END");
          localObject2 = a("messages_edits");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label1152;
          }
          this.a.execSQL("CREATE TABLE messages_edits (_id INTEGER PRIMARY KEY AUTOINCREMENT, key_remote_jid TEXT NOT NULL, key_from_me INTEGER, key_id TEXT NOT NULL, status INTEGER, needs_push INTEGER, data TEXT, timestamp INTEGER, media_url TEXT, media_mime_type TEXT, media_wa_type TEXT, media_size INTEGER, media_name TEXT, media_caption TEXT, media_hash TEXT, media_duration INTEGER, origin INTEGER, latitude REAL, longitude REAL, thumb_image TEXT, remote_resource TEXT, received_timestamp INTEGER, send_timestamp INTEGER, receipt_server_timestamp INTEGER, receipt_device_timestamp INTEGER, read_device_timestamp INTEGER, played_device_timestamp INTEGER, raw_data BLOB, recipient_count INTEGER, participant_hash TEXT, starred INTEGER, quoted_row_id INTEGER, mentioned_jids TEXT, multicast_id TEXT, edit_version INTEGER, media_enc_hash TEXT)");
          localObject2 = a("chat_list");
          a((String)localObject2, "chat_list", "subject", "TEXT");
          a((String)localObject2, "chat_list", "creation", "INTEGER");
          a((String)localObject2, "chat_list", "last_read_message_table_id", "INTEGER");
          a((String)localObject2, "chat_list", "last_read_receipt_sent_message_table_id", "INTEGER");
          a((String)localObject2, "chat_list", "archived", "INTEGER");
          a((String)localObject2, "chat_list", "sort_timestamp", "INTEGER");
          a((String)localObject2, "chat_list", "mod_tag", "INTEGER");
          a((String)localObject2, "chat_list", "gen", "REAL");
          a((String)localObject2, "chat_list", "my_messages", "INTEGER");
          a((String)localObject2, "chat_list", "plaintext_disabled", "BOOLEAN");
          a((String)localObject2, "chat_list", "last_message_table_id", "INTEGER");
          a((String)localObject2, "chat_list", "unseen_message_count", "INTEGER");
          a((String)localObject2, "chat_list", "unseen_missed_calls_count", "INTEGER");
          a((String)localObject2, "chat_list", "unseen_row_count", "INTEGER");
          a((String)localObject2, "chat_list", "vcard_ui_dismissed", "INTEGER");
          if (TextUtils.isEmpty(a("media_refs"))) {
            this.a.execSQL("CREATE TABLE media_refs (_id INTEGER PRIMARY KEY AUTOINCREMENT, path TEXT UNIQUE, ref_count INTEGER)");
          }
          localObject2 = a("media_streaming_sidecar");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label1169;
          }
          this.a.execSQL("CREATE TABLE media_streaming_sidecar (_id INTEGER PRIMARY KEY AUTOINCREMENT, sidecar BLOB, timestamp DATETIME, key_remote_jid TEXT NOT NULL, key_from_me INTEGER, key_id TEXT NOT NULL)");
          if (TextUtils.isEmpty(a("message_thumbnails")))
          {
            this.a.execSQL("CREATE TABLE message_thumbnails (thumbnail BLOB, timestamp DATETIME, key_remote_jid TEXT NOT NULL, key_from_me INTEGER, key_id TEXT NOT NULL)");
            this.a.execSQL("CREATE UNIQUE INDEX messages_thumbnail_key_index on message_thumbnails (key_remote_jid, key_from_me, key_id)");
          }
          if (TextUtils.isEmpty(a("receipts")))
          {
            this.a.execSQL("CREATE TABLE receipts (_id INTEGER PRIMARY KEY AUTOINCREMENT, key_remote_jid TEXT NOT NULL, key_id TEXT NOT NULL, remote_resource TEXT, receipt_device_timestamp INTEGER, read_device_timestamp INTEGER, played_device_timestamp INTEGER)");
            this.a.execSQL("CREATE INDEX receipts_key_index on receipts (key_remote_jid, key_id)");
          }
          this.a.execSQL("CREATE TRIGGER IF NOT EXISTS messages_bd_for_receipts_trigger BEFORE DELETE ON messages BEGIN DELETE FROM receipts WHERE key_remote_jid=old.key_remote_jid AND key_id=old.key_id; END");
          localObject2 = a("group_participants");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            break label1215;
          }
          this.a.execSQL("CREATE TABLE group_participants (_id INTEGER PRIMARY KEY AUTOINCREMENT, gjid TEXT NOT NULL, jid TEXT NOT NULL, admin INTEGER, pending INTEGER, sent_sender_key INTEGER)");
          this.a.execSQL("CREATE UNIQUE INDEX group_participants_index on group_participants (gjid, jid)");
          if (TextUtils.isEmpty(a("group_participants_history")))
          {
            this.a.execSQL("CREATE TABLE group_participants_history (_id INTEGER PRIMARY KEY AUTOINCREMENT, timestamp DATETIME NOT NULL, gjid TEXT NOT NULL, jid TEXT NOT NULL, action INTEGER NOT NULL, old_phash TEXT NOT NULL, new_phash TEXT NOT NULL)");
            this.a.execSQL("CREATE INDEX group_participants_history_index on group_participants_history (gjid)");
          }
          if (TextUtils.isEmpty(a("props"))) {
            this.a.execSQL("CREATE TABLE props (_id INTEGER PRIMARY KEY AUTOINCREMENT, key TEXT UNIQUE, value TEXT)");
          }
          if (TextUtils.isEmpty(a("messages_fts")))
          {
            this.a.execSQL("CREATE VIRTUAL TABLE messages_fts USING FTS3()");
            this.a.execSQL("CREATE TRIGGER messages_bd_trigger BEFORE DELETE ON messages BEGIN DELETE FROM messages_fts WHERE docid=old._id; END");
          }
          if (TextUtils.isEmpty(a("messages_vcards")))
          {
            this.a.execSQL("CREATE TABLE messages_vcards (_id INTEGER PRIMARY KEY AUTOINCREMENT, message_row_id INTEGER, sender_jid TEXT, vcard TEXT)");
            this.a.execSQL("CREATE TRIGGER messages_bd_for_vcards_trigger BEFORE DELETE ON messages BEGIN DELETE FROM messages_vcards WHERE message_row_id=old._id; END");
          }
          if (TextUtils.isEmpty(a("messages_vcards_jids")))
          {
            this.a.execSQL("CREATE TABLE messages_vcards_jids (_id INTEGER PRIMARY KEY AUTOINCREMENT, message_row_id INTEGER, vcard_jid TEXT, vcard_row_id INTEGER)");
            this.a.execSQL("CREATE TRIGGER messages_bd_for_vcards_jids_trigger BEFORE DELETE ON messages BEGIN DELETE FROM messages_vcards_jids WHERE message_row_id=old._id; END");
          }
          if (TextUtils.isEmpty(a("messages_links")))
          {
            this.a.execSQL("CREATE TABLE messages_links (_id INTEGER PRIMARY KEY AUTOINCREMENT, key_remote_jid TEXT, message_row_id INTEGER, link_index INTEGER)");
            this.a.execSQL("CREATE TRIGGER messages_bd_for_links_trigger BEFORE DELETE ON messages BEGIN DELETE FROM messages_links WHERE message_row_id=old._id; END");
          }
          if (TextUtils.isEmpty(a("frequents"))) {
            this.a.execSQL("CREATE TABLE frequents (_id INTEGER PRIMARY KEY AUTOINCREMENT, jid TEXT NOT NULL, type INTEGER NOT NULL, message_count INTEGER NOT NULL)");
          }
          if (TextUtils.isEmpty(a("conversion_tuples"))) {
            this.a.execSQL("CREATE TABLE conversion_tuples (key_remote_jid TEXT PRIMARY KEY, data TEXT, source TEXT, last_interaction INTEGER)");
          }
          localObject2 = a("status_list");
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            this.a.execSQL("CREATE TABLE status_list (_id INTEGER PRIMARY KEY AUTOINCREMENT, key_remote_jid TEXT UNIQUE, message_table_id INTEGER, last_read_message_table_id INTEGER, last_read_receipt_sent_message_table_id INTEGER, first_unread_message_table_id INTEGER, autodownload_limit_message_table_id INTEGER, timestamp INTEGER, unseen_count INTEGER, total_count INTEGER)");
          }
          a((String)localObject2, "status_list", "first_unread_message_table_id", "INTEGER");
          a((String)localObject2, "status_list", "autodownload_limit_message_table_id", "INTEGER");
          this.b = b("media_hash_index");
          this.c = b("media_type_index");
          this.d = b("messages_jid_id_index");
          this.e = b("media_type_jid_index");
        }
      }
      catch (SQLiteException localSQLiteException1)
      {
        try
        {
          for (;;)
          {
            onOpen(this.a);
            localObject2 = this.a;
            break;
            a((String)localObject2, "messages_quotes", "mentioned_jids", "TEXT");
            a((String)localObject2, "messages_quotes", "multicast_id", "TEXT");
            a((String)localObject2, "messages_quotes", "edit_version", "INTEGER");
            a((String)localObject2, "messages_quotes", "media_enc_hash", "TEXT");
            continue;
            localSQLiteException1 = localSQLiteException1;
            Log.d("msgstore/getwritabledb/prepare", localSQLiteException1);
            continue;
            label1152:
            a(localSQLiteException1, "messages_edits", "media_enc_hash", "TEXT");
            continue;
            label1169:
            if (!localSQLiteException1.contains("timestamp DATETIME"))
            {
              boolean bool = localSQLiteException1.contains("timestamp datetime");
              if (!bool) {
                try
                {
                  this.a.execSQL("ALTER TABLE media_streaming_sidecar ADD timestamp DATETIME");
                }
                catch (SQLiteException localSQLiteException2)
                {
                  Log.c("msgstore/alter_table timestamp", localSQLiteException2);
                }
              }
            }
          }
          label1215:
          a(localSQLiteException2, "group_participants", "sent_sender_key", "INTEGER");
        }
        catch (SQLiteException localSQLiteException3)
        {
          for (;;)
          {
            Log.d("msgstore/getwritabledb/onopen", localSQLiteException3);
          }
        }
      }
    }
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    Log.i("msgstore/create");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS messages");
    paramSQLiteDatabase.execSQL("CREATE TABLE messages (_id INTEGER PRIMARY KEY AUTOINCREMENT, key_remote_jid TEXT NOT NULL, key_from_me INTEGER, key_id TEXT NOT NULL, status INTEGER, needs_push INTEGER, data TEXT, timestamp INTEGER, media_url TEXT, media_mime_type TEXT, media_wa_type TEXT, media_size INTEGER, media_name TEXT, media_caption TEXT, media_hash TEXT, media_duration INTEGER, origin INTEGER, latitude REAL, longitude REAL, thumb_image TEXT, remote_resource TEXT, received_timestamp INTEGER, send_timestamp INTEGER, receipt_server_timestamp INTEGER, receipt_device_timestamp INTEGER, read_device_timestamp INTEGER, played_device_timestamp INTEGER, raw_data BLOB, recipient_count INTEGER, participant_hash TEXT, starred INTEGER, quoted_row_id INTEGER, mentioned_jids TEXT, multicast_id TEXT, edit_version INTEGER, media_enc_hash TEXT)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX messages_key_index on messages (key_remote_jid, key_from_me, key_id)");
    paramSQLiteDatabase.execSQL("CREATE INDEX messages_jid_id_index on messages (key_remote_jid, _id)");
    paramSQLiteDatabase.execSQL("CREATE INDEX media_hash_index on messages (media_hash)");
    paramSQLiteDatabase.execSQL("CREATE INDEX media_type_index on messages (media_wa_type)");
    paramSQLiteDatabase.execSQL("CREATE INDEX media_type_jid_index on messages (key_remote_jid, media_wa_type)");
    paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS starred_index on messages (starred)");
    paramSQLiteDatabase.execSQL("INSERT INTO messages(_id, key_remote_jid, key_from_me, key_id, status, needs_push, data, timestamp, media_url, media_mime_type, media_wa_type, media_size, media_name, media_hash, media_duration, origin, latitude, longitude, thumb_image, received_timestamp, send_timestamp, receipt_server_timestamp, receipt_device_timestamp, read_device_timestamp, played_device_timestamp, mentioned_jids) VALUES (1, '-1', 0, '-1', -1, 0, NULL, 0, NULL, NULL, -1, -1, NULL, NULL, 0, 0, 0, 0, NULL, -1, -1, -1, -1, -1, -1, NULL)");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS chat_list");
    paramSQLiteDatabase.execSQL("CREATE TABLE chat_list (_id INTEGER PRIMARY KEY AUTOINCREMENT, key_remote_jid TEXT UNIQUE, message_table_id INTEGER, subject TEXT, creation INTEGER, last_read_message_table_id INTEGER, last_read_receipt_sent_message_table_id INTEGER, archived INTEGER, sort_timestamp INTEGER, mod_tag INTEGER, gen REAL, my_messages INTEGER, plaintext_disabled BOOLEAN, last_message_table_id INTEGER, unseen_message_count INTEGER, unseen_missed_calls_count INTEGER, unseen_row_count INTEGER, vcard_ui_dismissed INTEGER)");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS props");
    paramSQLiteDatabase.execSQL("CREATE TABLE props (_id INTEGER PRIMARY KEY AUTOINCREMENT, key TEXT UNIQUE, value TEXT)");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS messages_fts");
    paramSQLiteDatabase.execSQL("CREATE VIRTUAL TABLE messages_fts USING FTS3()");
    paramSQLiteDatabase.execSQL("INSERT INTO props(key, value) VALUES ('fts_ready', 1)");
    paramSQLiteDatabase.execSQL("INSERT INTO props(key, value) VALUES ('fts_tokenizer_version', 1)");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS messages_bd_trigger");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER messages_bd_trigger BEFORE DELETE ON messages BEGIN DELETE FROM messages_fts WHERE docid=old._id; END");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS messages_quotes");
    paramSQLiteDatabase.execSQL("CREATE TABLE messages_quotes (_id INTEGER PRIMARY KEY AUTOINCREMENT, key_remote_jid TEXT NOT NULL, key_from_me INTEGER, key_id TEXT NOT NULL, status INTEGER, needs_push INTEGER, data TEXT, timestamp INTEGER, media_url TEXT, media_mime_type TEXT, media_wa_type TEXT, media_size INTEGER, media_name TEXT, media_caption TEXT, media_hash TEXT, media_duration INTEGER, origin INTEGER, latitude REAL, longitude REAL, thumb_image TEXT, remote_resource TEXT, received_timestamp INTEGER, send_timestamp INTEGER, receipt_server_timestamp INTEGER, receipt_device_timestamp INTEGER, read_device_timestamp INTEGER, played_device_timestamp INTEGER, raw_data BLOB, recipient_count INTEGER, participant_hash TEXT, starred INTEGER, quoted_row_id INTEGER, mentioned_jids TEXT, multicast_id TEXT, edit_version INTEGER, media_enc_hash TEXT)");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS messages_bd_for_quotes_trigger");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER messages_bd_for_quotes_trigger BEFORE DELETE ON messages BEGIN DELETE FROM messages_quotes WHERE _id=old.quoted_row_id; END");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS messages_vcards");
    paramSQLiteDatabase.execSQL("CREATE TABLE messages_vcards (_id INTEGER PRIMARY KEY AUTOINCREMENT, message_row_id INTEGER, sender_jid TEXT, vcard TEXT)");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS messages_vcards_jids");
    paramSQLiteDatabase.execSQL("CREATE TABLE messages_vcards_jids (_id INTEGER PRIMARY KEY AUTOINCREMENT, message_row_id INTEGER, vcard_jid TEXT, vcard_row_id INTEGER)");
    paramSQLiteDatabase.execSQL("INSERT INTO props(key, value) VALUES ('vcards_ready', 1)");
    paramSQLiteDatabase.execSQL("INSERT INTO props(key, value) VALUES ('vcards_version', 1)");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS messages_bd_for_vcards_trigger");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS messages_bd_for_vcards_jids_trigger");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER messages_bd_for_vcards_trigger BEFORE DELETE ON messages BEGIN DELETE FROM messages_vcards WHERE message_row_id=old._id; END");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER messages_bd_for_vcards_jids_trigger BEFORE DELETE ON messages BEGIN DELETE FROM messages_vcards_jids WHERE message_row_id=old._id; END");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS messages_edits");
    paramSQLiteDatabase.execSQL("CREATE TABLE messages_edits (_id INTEGER PRIMARY KEY AUTOINCREMENT, key_remote_jid TEXT NOT NULL, key_from_me INTEGER, key_id TEXT NOT NULL, status INTEGER, needs_push INTEGER, data TEXT, timestamp INTEGER, media_url TEXT, media_mime_type TEXT, media_wa_type TEXT, media_size INTEGER, media_name TEXT, media_caption TEXT, media_hash TEXT, media_duration INTEGER, origin INTEGER, latitude REAL, longitude REAL, thumb_image TEXT, remote_resource TEXT, received_timestamp INTEGER, send_timestamp INTEGER, receipt_server_timestamp INTEGER, receipt_device_timestamp INTEGER, read_device_timestamp INTEGER, played_device_timestamp INTEGER, raw_data BLOB, recipient_count INTEGER, participant_hash TEXT, starred INTEGER, quoted_row_id INTEGER, mentioned_jids TEXT, multicast_id TEXT, edit_version INTEGER, media_enc_hash TEXT)");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS messages_links");
    paramSQLiteDatabase.execSQL("CREATE TABLE messages_links (_id INTEGER PRIMARY KEY AUTOINCREMENT, key_remote_jid TEXT, message_row_id INTEGER, link_index INTEGER)");
    paramSQLiteDatabase.execSQL("INSERT INTO props(key, value) VALUES ('links_ready', 1)");
    paramSQLiteDatabase.execSQL("INSERT INTO props(key, value) VALUES ('links_version', 1)");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS messages_bd_for_links_trigger");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER messages_bd_for_links_trigger BEFORE DELETE ON messages BEGIN DELETE FROM messages_links WHERE message_row_id=old._id; END");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS frequents");
    paramSQLiteDatabase.execSQL("CREATE TABLE frequents (_id INTEGER PRIMARY KEY AUTOINCREMENT, jid TEXT NOT NULL, type INTEGER NOT NULL, message_count INTEGER NOT NULL)");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS receipts");
    paramSQLiteDatabase.execSQL("CREATE TABLE receipts (_id INTEGER PRIMARY KEY AUTOINCREMENT, key_remote_jid TEXT NOT NULL, key_id TEXT NOT NULL, remote_resource TEXT, receipt_device_timestamp INTEGER, read_device_timestamp INTEGER, played_device_timestamp INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE INDEX receipts_key_index on receipts (key_remote_jid, key_id)");
    paramSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS messages_bd_for_receipts_trigger");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER IF NOT EXISTS messages_bd_for_receipts_trigger BEFORE DELETE ON messages BEGIN DELETE FROM receipts WHERE key_remote_jid=old.key_remote_jid AND key_id=old.key_id; END");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS group_participants");
    paramSQLiteDatabase.execSQL("CREATE TABLE group_participants (_id INTEGER PRIMARY KEY AUTOINCREMENT, gjid TEXT NOT NULL, jid TEXT NOT NULL, admin INTEGER, pending INTEGER, sent_sender_key INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX group_participants_index on group_participants (gjid, jid)");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS group_participants_history");
    paramSQLiteDatabase.execSQL("CREATE TABLE group_participants_history (_id INTEGER PRIMARY KEY AUTOINCREMENT, timestamp DATETIME NOT NULL, gjid TEXT NOT NULL, jid TEXT NOT NULL, action INTEGER NOT NULL, old_phash TEXT NOT NULL, new_phash TEXT NOT NULL)");
    paramSQLiteDatabase.execSQL("CREATE INDEX group_participants_history_index on group_participants_history (gjid)");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS media_refs");
    paramSQLiteDatabase.execSQL("CREATE TABLE media_refs (_id INTEGER PRIMARY KEY AUTOINCREMENT, path TEXT UNIQUE, ref_count INTEGER)");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS media_streaming_sidecar");
    paramSQLiteDatabase.execSQL("CREATE TABLE media_streaming_sidecar (_id INTEGER PRIMARY KEY AUTOINCREMENT, sidecar BLOB, timestamp DATETIME, key_remote_jid TEXT NOT NULL, key_from_me INTEGER, key_id TEXT NOT NULL)");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS message_thumbnails");
    paramSQLiteDatabase.execSQL("CREATE TABLE message_thumbnails (thumbnail BLOB, timestamp DATETIME, key_remote_jid TEXT NOT NULL, key_from_me INTEGER, key_id TEXT NOT NULL)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX messages_thumbnail_key_index on message_thumbnails (key_remote_jid, key_from_me, key_id)");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS status_list");
    paramSQLiteDatabase.execSQL("CREATE TABLE status_list (_id INTEGER PRIMARY KEY AUTOINCREMENT, key_remote_jid TEXT UNIQUE, message_table_id INTEGER, last_read_message_table_id INTEGER, last_read_receipt_sent_message_table_id INTEGER, first_unread_message_table_id INTEGER, autodownload_limit_message_table_id INTEGER, timestamp INTEGER, unseen_count INTEGER, total_count INTEGER)");
    paramSQLiteDatabase.setVersion(1);
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS conversion_tuples");
    paramSQLiteDatabase.execSQL("CREATE TABLE conversion_tuples (key_remote_jid TEXT PRIMARY KEY, data TEXT, source TEXT, last_interaction INTEGER)");
  }
  
  /* Error */
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: ldc_w 640
    //   3: invokestatic 642	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc_w 644
    //   10: invokevirtual 154	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   13: aload_1
    //   14: ldc_w 646
    //   17: aconst_null
    //   18: invokevirtual 81	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   21: astore_3
    //   22: aload_3
    //   23: ifnull +59 -> 82
    //   26: aload_3
    //   27: invokeinterface 87 1 0
    //   32: ifeq +78 -> 110
    //   35: aload_3
    //   36: iconst_0
    //   37: invokeinterface 194 2 0
    //   42: istore_2
    //   43: new 60	java/lang/StringBuilder
    //   46: dup
    //   47: ldc_w 648
    //   50: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   53: iload_2
    //   54: invokevirtual 190	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 642	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   63: goto -37 -> 26
    //   66: astore 4
    //   68: ldc_w 650
    //   71: aload 4
    //   73: invokestatic 101	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   76: aload_3
    //   77: invokeinterface 94 1 0
    //   82: getstatic 32	android/os/Build$VERSION:SDK_INT	I
    //   85: bipush 11
    //   87: if_icmplt +22 -> 109
    //   90: getstatic 32	android/os/Build$VERSION:SDK_INT	I
    //   93: bipush 16
    //   95: if_icmpge +14 -> 109
    //   98: invokestatic 653	com/whatsapp/util/a:a	()Z
    //   101: ifne +8 -> 109
    //   104: aload_1
    //   105: invokevirtual 656	android/database/sqlite/SQLiteDatabase:enableWriteAheadLogging	()Z
    //   108: pop
    //   109: return
    //   110: aload_3
    //   111: invokeinterface 94 1 0
    //   116: goto -34 -> 82
    //   119: astore_1
    //   120: aload_3
    //   121: invokeinterface 94 1 0
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	n
    //   0	128	1	paramSQLiteDatabase	SQLiteDatabase
    //   42	12	2	m	int
    //   21	100	3	localCursor	Cursor
    //   66	6	4	localSQLiteDiskIOException	android.database.sqlite.SQLiteDiskIOException
    // Exception table:
    //   from	to	target	type
    //   26	63	66	android/database/sqlite/SQLiteDiskIOException
    //   26	63	119	finally
    //   68	76	119	finally
  }
  
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Log.i("msgstore/upgrade version " + paramInt1 + " to " + paramInt2);
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */