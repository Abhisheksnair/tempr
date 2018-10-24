package com.whatsapp.contact;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import com.whatsapp.util.Log;
import java.io.File;

final class a
  extends SQLiteOpenHelper
{
  private final Context a;
  
  public a(Context paramContext)
  {
    super(paramContext, "wa.db", null, 15);
    if ((Build.VERSION.SDK_INT >= 16) && (!com.whatsapp.util.a.a())) {
      setWriteAheadLoggingEnabled(true);
    }
    this.a = paramContext;
  }
  
  private static String a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    String str = "";
    Cursor localCursor = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type='table' and name='" + paramString + "';", null);
    paramSQLiteDatabase = str;
    if (localCursor != null) {
      paramSQLiteDatabase = str;
    }
    try
    {
      if (localCursor.moveToNext()) {
        paramSQLiteDatabase = localCursor.getString(0);
      }
      return paramSQLiteDatabase;
    }
    catch (Exception paramSQLiteDatabase)
    {
      Log.d("cannot get schema for " + paramString, paramSQLiteDatabase);
      return "";
    }
    finally
    {
      localCursor.close();
    }
  }
  
  private static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    Log.i("creating contact capabilities table for contacts database version 15");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS wa_contact_capabilities");
    paramSQLiteDatabase.execSQL("CREATE TABLE wa_contact_capabilities (_id INTEGER PRIMARY KEY AUTOINCREMENT, jid TEXT NOT NULL, capability TEXT NOT NULL, value TEXT NOT NULL, updated_at INTEGER NOT NULL)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX wa_contact_capabilities_jid_capability_index ON wa_contact_capabilities(jid,capability)");
  }
  
  /* Error */
  private static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 100
    //   5: invokestatic 86	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   8: aload_0
    //   9: ldc 102
    //   11: aconst_null
    //   12: invokevirtual 59	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   15: astore 5
    //   17: invokestatic 108	java/lang/System:currentTimeMillis	()J
    //   20: lstore_1
    //   21: new 110	android/content/ContentValues
    //   24: dup
    //   25: invokespecial 112	android/content/ContentValues:<init>	()V
    //   28: astore_3
    //   29: aload_3
    //   30: ldc 114
    //   32: ldc 116
    //   34: invokevirtual 120	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aload_3
    //   38: ldc 122
    //   40: lload_1
    //   41: invokestatic 128	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   44: invokevirtual 131	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   47: aload 5
    //   49: invokeinterface 64 1 0
    //   54: ifeq +79 -> 133
    //   57: aload 5
    //   59: iconst_0
    //   60: invokeinterface 68 2 0
    //   65: astore 6
    //   67: aload 5
    //   69: iconst_1
    //   70: invokeinterface 68 2 0
    //   75: astore 7
    //   77: aload_3
    //   78: ldc -123
    //   80: aload 6
    //   82: invokevirtual 120	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_3
    //   86: ldc -121
    //   88: aload 7
    //   90: invokevirtual 120	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload_0
    //   94: ldc -119
    //   96: aconst_null
    //   97: aload_3
    //   98: invokevirtual 141	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   101: pop2
    //   102: goto -55 -> 47
    //   105: astore_0
    //   106: aload_0
    //   107: athrow
    //   108: astore_3
    //   109: aload_0
    //   110: astore 4
    //   112: aload_3
    //   113: astore_0
    //   114: aload 5
    //   116: ifnull +15 -> 131
    //   119: aload 4
    //   121: ifnull +25 -> 146
    //   124: aload 5
    //   126: invokeinterface 72 1 0
    //   131: aload_0
    //   132: athrow
    //   133: aload 5
    //   135: ifnull +10 -> 145
    //   138: aload 5
    //   140: invokeinterface 72 1 0
    //   145: return
    //   146: aload 5
    //   148: invokeinterface 72 1 0
    //   153: goto -22 -> 131
    //   156: astore_3
    //   157: goto -26 -> 131
    //   160: astore_0
    //   161: goto -47 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramSQLiteDatabase	SQLiteDatabase
    //   20	21	1	l	long
    //   28	70	3	localContentValues	android.content.ContentValues
    //   108	5	3	localObject	Object
    //   156	1	3	localThrowable	Throwable
    //   1	119	4	localSQLiteDatabase	SQLiteDatabase
    //   15	132	5	localCursor	Cursor
    //   65	16	6	str1	String
    //   75	14	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   17	47	105	java/lang/Throwable
    //   47	102	105	java/lang/Throwable
    //   106	108	108	finally
    //   124	131	156	java/lang/Throwable
    //   17	47	160	finally
    //   47	102	160	finally
  }
  
  private static String c()
  {
    int i = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    while (i < 18)
    {
      localStringBuilder.append(new String[] { "_id", "jid", "is_whatsapp_user", "status", "status_timestamp", "number", "raw_contact_id", "display_name", "phone_type", "phone_label", "unseen_msg_count", "photo_ts", "thumb_ts", "photo_id_timestamp", "given_name", "family_name", "wa_name", "sort_name" }[i]).append(',');
      i += 1;
    }
    localStringBuilder.setLength(localStringBuilder.length() - 1);
    return localStringBuilder.toString();
  }
  
  private static void c(SQLiteDatabase paramSQLiteDatabase)
  {
    Log.i("creating system contacts version table for contacts database version 15");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS system_contacts_version_table");
    paramSQLiteDatabase.execSQL("CREATE TABLE system_contacts_version_table (id INTEGER PRIMARY KEY, version INTEGER)");
  }
  
  private static void d(SQLiteDatabase paramSQLiteDatabase)
  {
    Log.i("creating wa_vnames table for contacts database version 15");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS wa_vnames");
    paramSQLiteDatabase.execSQL("CREATE TABLE wa_vnames (_id INTEGER PRIMARY KEY AUTOINCREMENT, jid TEXT NOT NULL, serial INTEGER NOT NULL, issuer TEXT NOT NULL, expires INTEGER, verified_name TEXT NOT NULL, industry TEXT, city TEXT, country TEXT)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX vname_jid_index ON wa_vnames(jid);");
  }
  
  private static void e(SQLiteDatabase paramSQLiteDatabase)
  {
    Log.i("creating wa_vnames_localized table for contacts database version 15");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS wa_vnames_localized");
    paramSQLiteDatabase.execSQL("CREATE TABLE wa_vnames_localized (_id INTEGER PRIMARY KEY AUTOINCREMENT, jid TEXT NOT NULL, lg TEXT NOT NULL, lc TEXT NOT NULL, verified_name TEXT NOT NULL)");
    paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX vname_localized_index ON wa_vnames_localized(jid, lg, lc);");
  }
  
  final boolean a()
  {
    try
    {
      close();
      Log.i("deleting contact database...");
      boolean bool1 = b().delete();
      File localFile = b();
      boolean bool2 = new File(localFile.getPath(), localFile.getName() + "-journal").delete();
      localFile = b();
      boolean bool3 = new File(localFile.getPath(), localFile.getName() + "-wal").delete();
      Log.i("deleted contact database; databaseDeleted=" + bool1 + "; journalDeleted=" + bool2 + "; writeAheadLogDeleted=" + bool3);
      return bool1;
    }
    finally {}
  }
  
  final File b()
  {
    return this.a.getDatabasePath("wa.db");
  }
  
  public final SQLiteDatabase getReadableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = super.getReadableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      Log.w("Contacts database is corrupt. Removing...");
      a();
      return super.getReadableDatabase();
    }
    catch (SQLiteException localSQLiteException)
    {
      localObject = localSQLiteException.toString();
      if (((String)localObject).contains("file is encrypted"))
      {
        Log.w("Contacts database is encrypted. Removing...");
        a();
        return super.getReadableDatabase();
      }
      if (((String)localObject).contains("upgrade read-only database"))
      {
        Log.w("Client actually opened database as read-only and can't upgrade. Switching to writable...");
        return getWritableDatabase();
      }
      throw localSQLiteException;
    }
    catch (StackOverflowError localStackOverflowError)
    {
      Log.w("StackOverflowError during db init check");
      Object localObject = localStackOverflowError.getStackTrace();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (localObject[i].getMethodName().equals("onCorruption"))
        {
          Log.w("Contacts database is corrupt. Found via StackOverflowError. Removing...");
          a();
          return super.getReadableDatabase();
        }
        i += 1;
      }
      throw localStackOverflowError;
    }
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteDatabaseCorruptException localSQLiteDatabaseCorruptException)
    {
      Log.w("Contacts database is corrupt. Removing...");
      a();
      return super.getWritableDatabase();
    }
    catch (SQLiteException localSQLiteException)
    {
      if (localSQLiteException.toString().contains("file is encrypted"))
      {
        Log.w("Contacts database is encrypted. Removing...");
        a();
        return super.getWritableDatabase();
      }
      throw localSQLiteException;
    }
    catch (StackOverflowError localStackOverflowError)
    {
      Log.w("StackOverflowError during db init check");
      StackTraceElement[] arrayOfStackTraceElement = localStackOverflowError.getStackTrace();
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfStackTraceElement[i].getMethodName().equals("onCorruption"))
        {
          Log.w("Contacts database is corrupt. Found via StackOverflowError. Removing...");
          a();
          return super.getWritableDatabase();
        }
        i += 1;
      }
      throw localStackOverflowError;
    }
  }
  
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    Log.i("creating contacts database version 15");
    Log.i("creating contacts table for contacts database version 15");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS wa_contacts");
    paramSQLiteDatabase.execSQL("CREATE TABLE wa_contacts (_id INTEGER PRIMARY KEY AUTOINCREMENT, jid TEXT NOT NULL, is_whatsapp_user BOOLEAN NOT NULL, status TEXT, status_timestamp INTEGER, number TEXT, raw_contact_id INTEGER, display_name TEXT, phone_type INTEGER, phone_label TEXT, unseen_msg_count INTEGER, photo_ts INTEGER, thumb_ts INTEGER, photo_id_timestamp INTEGER, given_name TEXT, family_name TEXT, wa_name TEXT, sort_name TEXT, nickname TEXT, company TEXT, title TEXT, status_autodownload_disabled INTEGER, keep_timestamp INTEGER, is_spam_reported INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE INDEX is_wa_index ON wa_contacts(is_whatsapp_user);");
    paramSQLiteDatabase.execSQL("CREATE INDEX jid_index ON wa_contacts(jid);");
    a(paramSQLiteDatabase);
    c(paramSQLiteDatabase);
    d(paramSQLiteDatabase);
    e(paramSQLiteDatabase);
  }
  
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Log.w("Downgrading contacts database from version " + paramInt1 + " to " + paramInt2);
    onCreate(paramSQLiteDatabase);
  }
  
  public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onOpen(paramSQLiteDatabase);
    if ((Build.VERSION.SDK_INT >= 11) && (Build.VERSION.SDK_INT < 16) && (!com.whatsapp.util.a.a())) {
      paramSQLiteDatabase.enableWriteAheadLogging();
    }
    paramSQLiteDatabase.beginTransaction();
    try
    {
      paramSQLiteDatabase.delete("wa_contact_capabilities", "capability IN ('identity_verification','document','encrypt_audio','encrypt_blist','encrypt_contact','encrypt_group_gen2','encrypt_image','encrypt_location','encrypt_url','encrypt_v2','encrypt_video')", null);
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  /* Error */
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 38	java/lang/StringBuilder
    //   6: dup
    //   7: ldc_w 358
    //   10: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: iload_2
    //   14: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17: ldc_w 333
    //   20: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_3
    //   24: invokevirtual 331	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 86	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   33: iload_2
    //   34: tableswitch	default:+62->96, 3:+74->108, 4:+81->115, 5:+88->122, 6:+594->628, 7:+267->301, 8:+364->398, 9:+368->402, 10:+389->423, 11:+397->431, 12:+404->438, 13:+498->532, 14:+505->539
    //   96: ldc_w 360
    //   99: invokestatic 266	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   102: aload_0
    //   103: aload_1
    //   104: invokevirtual 335	com/whatsapp/contact/a:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   107: return
    //   108: aload_1
    //   109: ldc_w 362
    //   112: invokevirtual 91	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   115: aload_1
    //   116: ldc_w 364
    //   119: invokevirtual 91	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   122: aload_1
    //   123: invokestatic 318	com/whatsapp/contact/a:a	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   126: aload_1
    //   127: invokestatic 366	com/whatsapp/contact/a:b	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   130: iconst_1
    //   131: istore_3
    //   132: iload_3
    //   133: ifne +168 -> 301
    //   136: aload_1
    //   137: ldc_w 368
    //   140: invokevirtual 91	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   143: new 370	java/util/HashSet
    //   146: dup
    //   147: invokespecial 371	java/util/HashSet:<init>	()V
    //   150: astore 4
    //   152: aload_1
    //   153: ldc -119
    //   155: iconst_2
    //   156: anewarray 145	java/lang/String
    //   159: dup
    //   160: iconst_0
    //   161: ldc -123
    //   163: aastore
    //   164: dup
    //   165: iconst_1
    //   166: ldc 114
    //   168: aastore
    //   169: aconst_null
    //   170: aconst_null
    //   171: aconst_null
    //   172: aconst_null
    //   173: aconst_null
    //   174: invokevirtual 375	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   177: astore 6
    //   179: aload 6
    //   181: invokeinterface 64 1 0
    //   186: ifeq +97 -> 283
    //   189: aload 6
    //   191: iconst_0
    //   192: invokeinterface 68 2 0
    //   197: astore 7
    //   199: aload 6
    //   201: iconst_1
    //   202: invokeinterface 68 2 0
    //   207: astore 8
    //   209: aload 4
    //   211: aload 7
    //   213: aload 8
    //   215: invokestatic 381	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   218: invokeinterface 386 2 0
    //   223: ifne -44 -> 179
    //   226: aload_1
    //   227: ldc -119
    //   229: ldc_w 388
    //   232: iconst_2
    //   233: anewarray 145	java/lang/String
    //   236: dup
    //   237: iconst_0
    //   238: aload 7
    //   240: aastore
    //   241: dup
    //   242: iconst_1
    //   243: aload 8
    //   245: aastore
    //   246: invokevirtual 349	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   249: pop
    //   250: goto -71 -> 179
    //   253: astore_1
    //   254: aload_1
    //   255: athrow
    //   256: astore 4
    //   258: aload_1
    //   259: astore 5
    //   261: aload 4
    //   263: astore_1
    //   264: aload 6
    //   266: ifnull +15 -> 281
    //   269: aload 5
    //   271: ifnull +276 -> 547
    //   274: aload 6
    //   276: invokeinterface 72 1 0
    //   281: aload_1
    //   282: athrow
    //   283: aload 6
    //   285: ifnull +10 -> 295
    //   288: aload 6
    //   290: invokeinterface 72 1 0
    //   295: aload_1
    //   296: ldc 95
    //   298: invokevirtual 91	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   301: aload_1
    //   302: invokevirtual 344	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   305: aload_1
    //   306: ldc_w 390
    //   309: invokevirtual 91	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   312: aload_1
    //   313: ldc_w 392
    //   316: invokevirtual 91	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   319: aload_1
    //   320: ldc_w 394
    //   323: invokevirtual 91	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   326: aload_1
    //   327: ldc_w 310
    //   330: invokevirtual 91	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   333: aload_1
    //   334: ldc_w 396
    //   337: invokevirtual 91	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   340: aload_1
    //   341: ldc_w 314
    //   344: invokevirtual 91	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   347: aload_1
    //   348: ldc_w 316
    //   351: invokevirtual 91	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   354: aload_1
    //   355: new 38	java/lang/StringBuilder
    //   358: dup
    //   359: ldc_w 398
    //   362: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   365: invokestatic 400	com/whatsapp/contact/a:c	()Ljava/lang/String;
    //   368: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: ldc_w 402
    //   374: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokevirtual 91	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   383: aload_1
    //   384: ldc_w 404
    //   387: invokevirtual 91	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   390: aload_1
    //   391: invokevirtual 352	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   394: aload_1
    //   395: invokevirtual 355	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   398: aload_1
    //   399: invokestatic 320	com/whatsapp/contact/a:c	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   402: aload_1
    //   403: ldc_w 406
    //   406: invokevirtual 91	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   409: aload_1
    //   410: ldc_w 408
    //   413: invokevirtual 91	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   416: aload_1
    //   417: ldc_w 410
    //   420: invokevirtual 91	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   423: aload_1
    //   424: invokestatic 322	com/whatsapp/contact/a:d	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   427: aload_1
    //   428: invokestatic 324	com/whatsapp/contact/a:e	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   431: aload_1
    //   432: ldc_w 412
    //   435: invokevirtual 91	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   438: iload_2
    //   439: bipush 12
    //   441: if_icmpne +91 -> 532
    //   444: aload_1
    //   445: ldc_w 414
    //   448: invokestatic 416	com/whatsapp/contact/a:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;
    //   451: new 38	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   458: ldc_w 418
    //   461: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: ldc_w 420
    //   467: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: ldc_w 422
    //   473: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokevirtual 274	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   482: ifne +50 -> 532
    //   485: aload_1
    //   486: new 38	java/lang/StringBuilder
    //   489: dup
    //   490: ldc_w 424
    //   493: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   496: ldc_w 414
    //   499: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: ldc_w 426
    //   505: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: ldc_w 418
    //   511: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: ldc_w 420
    //   517: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: ldc_w 422
    //   523: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokevirtual 91	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   532: aload_1
    //   533: ldc_w 428
    //   536: invokevirtual 91	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   539: aload_1
    //   540: ldc_w 430
    //   543: invokevirtual 91	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   546: return
    //   547: aload 6
    //   549: invokeinterface 72 1 0
    //   554: goto -273 -> 281
    //   557: astore 4
    //   559: aload_1
    //   560: invokevirtual 355	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   563: aload 4
    //   565: athrow
    //   566: astore 4
    //   568: new 38	java/lang/StringBuilder
    //   571: dup
    //   572: ldc_w 432
    //   575: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   578: ldc_w 418
    //   581: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: ldc_w 420
    //   587: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: ldc_w 422
    //   593: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: ldc_w 333
    //   599: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: ldc_w 414
    //   605: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: aload 4
    //   613: invokestatic 80	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   616: goto -84 -> 532
    //   619: astore 4
    //   621: goto -340 -> 281
    //   624: astore_1
    //   625: goto -361 -> 264
    //   628: iconst_0
    //   629: istore_3
    //   630: goto -498 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	633	0	this	a
    //   0	633	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	633	2	paramInt1	int
    //   0	633	3	paramInt2	int
    //   150	60	4	localHashSet	java.util.HashSet
    //   256	6	4	localObject1	Object
    //   557	7	4	localObject2	Object
    //   566	46	4	localSQLiteException	SQLiteException
    //   619	1	4	localThrowable	Throwable
    //   1	269	5	localSQLiteDatabase	SQLiteDatabase
    //   177	371	6	localCursor	Cursor
    //   197	42	7	str1	String
    //   207	37	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   179	250	253	java/lang/Throwable
    //   254	256	256	finally
    //   305	394	557	finally
    //   485	532	566	android/database/sqlite/SQLiteException
    //   274	281	619	java/lang/Throwable
    //   179	250	624	finally
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/contact/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */