package com.whatsapp;

import a.a.a.a.d;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.BaseColumns;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.whatsapp.data.ad;
import com.whatsapp.data.e;
import com.whatsapp.messaging.aj;
import com.whatsapp.protocol.ar;
import com.whatsapp.util.Log;
import java.io.File;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class cc
{
  private static volatile cc b;
  final Map<String, a> a = new ConcurrentHashMap();
  private final String c;
  private b d;
  private final ant e;
  private final and f;
  private final aj g;
  private final dh h;
  private final vv i;
  private final atu j;
  private final lt k;
  private final hx l;
  private final ox m;
  private final ad n;
  private final e o;
  
  private cc(ant paramant, and paramand, aj paramaj, dh paramdh, vv paramvv, atu paramatu, lt paramlt, hx paramhx, ox paramox, ad paramad, e parame, String paramString)
  {
    this.e = paramant;
    this.f = paramand;
    this.g = paramaj;
    this.h = paramdh;
    this.i = paramvv;
    this.j = paramatu;
    this.k = paramlt;
    this.l = paramhx;
    this.m = paramox;
    this.n = paramad;
    this.o = parame;
    this.c = paramString;
  }
  
  private a a(Cursor paramCursor)
  {
    boolean bool2 = true;
    a locala = new a(this.f, this.j, (byte)0);
    locala.a = paramCursor.getString(0);
    locala.c = paramCursor.getLong(1);
    if (paramCursor.getInt(2) == 1)
    {
      bool1 = true;
      locala.d = bool1;
      if (paramCursor.getInt(3) != 1) {
        break label239;
      }
      bool1 = true;
      label76:
      locala.e = bool1;
      locala.f = paramCursor.getString(4);
      locala.g = paramCursor.getString(5);
      locala.h = paramCursor.getString(6);
      locala.i = paramCursor.getString(7);
      locala.j = paramCursor.getString(8);
      locala.k = paramCursor.getString(9);
      if (paramCursor.getInt(10) != 1) {
        break label244;
      }
      bool1 = true;
      label172:
      locala.l = bool1;
      if (paramCursor.getInt(11) != 1) {
        break label249;
      }
    }
    label239:
    label244:
    label249:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locala.m = bool1;
      locala.n = paramCursor.getLong(12);
      if ("0".equals(locala.i)) {
        locala.i = "000000";
      }
      return locala;
      bool1 = false;
      break;
      bool1 = false;
      break label76;
      bool1 = false;
      break label172;
    }
  }
  
  public static cc a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new cc(ant.a(), and.a(), aj.a(), dh.a(), vv.a(), atu.a(), lt.a(), hx.a(), ox.a(), ad.a(), e.a(), "chatsettings.db");
      }
      return b;
    }
    finally {}
  }
  
  public static File a(Context paramContext)
  {
    return paramContext.getDatabasePath("chatsettingsbackup.db");
  }
  
  public static File a(ox paramox)
  {
    return new File(paramox.a("Backups"), "chatsettingsbackup.db.crypt1");
  }
  
  /* Error */
  private static boolean a(cc paramcc1, cc paramcc2)
  {
    // Byte code:
    //   0: new 220	java/lang/StringBuilder
    //   3: dup
    //   4: ldc -34
    //   6: invokespecial 225	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: aload_0
    //   10: invokevirtual 228	com/whatsapp/cc:c	()Lcom/whatsapp/cc$b;
    //   13: invokestatic 231	com/whatsapp/cc$b:a	(Lcom/whatsapp/cc$b;)Ljava/io/File;
    //   16: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: ldc -19
    //   21: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: aload_1
    //   25: invokevirtual 228	com/whatsapp/cc:c	()Lcom/whatsapp/cc$b;
    //   28: invokestatic 231	com/whatsapp/cc$b:a	(Lcom/whatsapp/cc$b;)Ljava/io/File;
    //   31: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 248	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   40: aload_1
    //   41: invokevirtual 228	com/whatsapp/cc:c	()Lcom/whatsapp/cc$b;
    //   44: invokevirtual 252	com/whatsapp/cc$b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   47: astore 4
    //   49: aload 4
    //   51: invokevirtual 257	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   54: aload_0
    //   55: invokevirtual 228	com/whatsapp/cc:c	()Lcom/whatsapp/cc$b;
    //   58: invokevirtual 252	com/whatsapp/cc$b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   61: ldc_w 259
    //   64: getstatic 262	com/whatsapp/cc$c:a	[Ljava/lang/String;
    //   67: aconst_null
    //   68: aconst_null
    //   69: aconst_null
    //   70: aconst_null
    //   71: aconst_null
    //   72: invokevirtual 266	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore_3
    //   76: aload_3
    //   77: ifnull +128 -> 205
    //   80: aload_3
    //   81: astore_2
    //   82: aload_3
    //   83: invokeinterface 270 1 0
    //   88: ifeq +117 -> 205
    //   91: aload_3
    //   92: astore_2
    //   93: aload_0
    //   94: aload_3
    //   95: invokespecial 272	com/whatsapp/cc:a	(Landroid/database/Cursor;)Lcom/whatsapp/cc$a;
    //   98: astore 5
    //   100: aload_3
    //   101: astore_2
    //   102: aload 5
    //   104: getfield 88	com/whatsapp/cc$a:a	Ljava/lang/String;
    //   107: ifnull +59 -> 166
    //   110: aload_3
    //   111: astore_2
    //   112: new 220	java/lang/StringBuilder
    //   115: dup
    //   116: ldc_w 274
    //   119: invokespecial 225	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: aload 5
    //   124: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 248	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   133: aload_3
    //   134: astore_2
    //   135: aload_1
    //   136: aload 5
    //   138: invokevirtual 277	com/whatsapp/cc:a	(Lcom/whatsapp/cc$a;)V
    //   141: goto -65 -> 76
    //   144: astore_0
    //   145: aload_3
    //   146: astore_2
    //   147: ldc_w 279
    //   150: aload_0
    //   151: invokestatic 282	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   154: aload_3
    //   155: ifnull +9 -> 164
    //   158: aload_3
    //   159: invokeinterface 285 1 0
    //   164: iconst_0
    //   165: ireturn
    //   166: aload_3
    //   167: astore_2
    //   168: new 220	java/lang/StringBuilder
    //   171: dup
    //   172: ldc_w 287
    //   175: invokespecial 225	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   178: aload 5
    //   180: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 289	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   189: goto -113 -> 76
    //   192: astore_0
    //   193: aload_2
    //   194: ifnull +9 -> 203
    //   197: aload_2
    //   198: invokeinterface 285 1 0
    //   203: aload_0
    //   204: athrow
    //   205: aload_3
    //   206: astore_2
    //   207: aload 4
    //   209: invokevirtual 292	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   212: aload_3
    //   213: astore_2
    //   214: aload 4
    //   216: invokevirtual 295	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   219: aload_3
    //   220: ifnull +9 -> 229
    //   223: aload_3
    //   224: invokeinterface 285 1 0
    //   229: iconst_1
    //   230: ireturn
    //   231: astore_0
    //   232: aconst_null
    //   233: astore_2
    //   234: goto -41 -> 193
    //   237: astore_0
    //   238: aconst_null
    //   239: astore_3
    //   240: goto -95 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramcc1	cc
    //   0	243	1	paramcc2	cc
    //   81	153	2	localCursor1	Cursor
    //   75	165	3	localCursor2	Cursor
    //   47	168	4	localSQLiteDatabase	SQLiteDatabase
    //   98	81	5	locala	a
    // Exception table:
    //   from	to	target	type
    //   82	91	144	android/database/sqlite/SQLiteDatabaseCorruptException
    //   93	100	144	android/database/sqlite/SQLiteDatabaseCorruptException
    //   102	110	144	android/database/sqlite/SQLiteDatabaseCorruptException
    //   112	133	144	android/database/sqlite/SQLiteDatabaseCorruptException
    //   135	141	144	android/database/sqlite/SQLiteDatabaseCorruptException
    //   168	189	144	android/database/sqlite/SQLiteDatabaseCorruptException
    //   207	212	144	android/database/sqlite/SQLiteDatabaseCorruptException
    //   214	219	144	android/database/sqlite/SQLiteDatabaseCorruptException
    //   82	91	192	finally
    //   93	100	192	finally
    //   102	110	192	finally
    //   112	133	192	finally
    //   135	141	192	finally
    //   147	154	192	finally
    //   168	189	192	finally
    //   207	212	192	finally
    //   214	219	192	finally
    //   40	76	231	finally
    //   40	76	237	android/database/sqlite/SQLiteDatabaseCorruptException
  }
  
  private static boolean b(a parama)
  {
    boolean bool = true;
    if (("group_chat_defaults".equals(parama.a)) || ("individual_chat_defaults".equals(parama.a))) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if ((parama.c == 0L) && (!parama.e) && (!parama.l))
      {
        a locala = parama.j();
        if ((!TextUtils.equals(parama.d(), locala.d())) || (!TextUtils.equals(parama.e(), locala.e())) || (!TextUtils.equals(parama.g(), locala.g())) || (!TextUtils.equals(parama.f(), locala.f())) || (!TextUtils.equals(parama.h(), locala.h())) || (!TextUtils.equals(parama.i(), locala.i()))) {
          break label159;
        }
      }
      label159:
      for (int i1 = 1; (i1 == 0) || (parama.m); i1 = 0) {
        return false;
      }
    }
  }
  
  private void h()
  {
    this.a.clear();
    c().a();
    b = null;
  }
  
  /* Error */
  public final a a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	com/whatsapp/cc:a	Ljava/util/Map;
    //   4: aload_1
    //   5: invokeinterface 332 2 0
    //   10: checkcast 6	com/whatsapp/cc$a
    //   13: astore_3
    //   14: aload_3
    //   15: astore_2
    //   16: aload_3
    //   17: ifnonnull +97 -> 114
    //   20: aload_0
    //   21: invokevirtual 228	com/whatsapp/cc:c	()Lcom/whatsapp/cc$b;
    //   24: invokevirtual 252	com/whatsapp/cc$b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   27: ldc_w 259
    //   30: getstatic 262	com/whatsapp/cc$c:a	[Ljava/lang/String;
    //   33: ldc_w 334
    //   36: iconst_1
    //   37: anewarray 126	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: aload_1
    //   43: aastore
    //   44: aconst_null
    //   45: aconst_null
    //   46: aconst_null
    //   47: invokevirtual 266	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnull +64 -> 116
    //   55: aload_3
    //   56: astore_2
    //   57: aload_3
    //   58: invokeinterface 270 1 0
    //   63: ifeq +53 -> 116
    //   66: aload_3
    //   67: astore_2
    //   68: aload_0
    //   69: aload_3
    //   70: invokespecial 272	com/whatsapp/cc:a	(Landroid/database/Cursor;)Lcom/whatsapp/cc$a;
    //   73: astore 4
    //   75: aload_3
    //   76: astore_2
    //   77: aload 4
    //   79: aload_1
    //   80: putfield 88	com/whatsapp/cc$a:a	Ljava/lang/String;
    //   83: aload_3
    //   84: astore_2
    //   85: aload_0
    //   86: getfield 51	com/whatsapp/cc:a	Ljava/util/Map;
    //   89: aload_1
    //   90: aload 4
    //   92: invokeinterface 338 3 0
    //   97: pop
    //   98: aload 4
    //   100: astore_2
    //   101: aload_3
    //   102: ifnull +12 -> 114
    //   105: aload_3
    //   106: invokeinterface 285 1 0
    //   111: aload 4
    //   113: astore_2
    //   114: aload_2
    //   115: areturn
    //   116: aload_3
    //   117: astore_2
    //   118: new 6	com/whatsapp/cc$a
    //   121: dup
    //   122: aload_0
    //   123: getfield 55	com/whatsapp/cc:f	Lcom/whatsapp/and;
    //   126: aload_0
    //   127: getfield 63	com/whatsapp/cc:j	Lcom/whatsapp/atu;
    //   130: iconst_0
    //   131: invokespecial 80	com/whatsapp/cc$a:<init>	(Lcom/whatsapp/and;Lcom/whatsapp/atu;B)V
    //   134: astore 4
    //   136: goto -61 -> 75
    //   139: astore_1
    //   140: aload_3
    //   141: astore_2
    //   142: ldc_w 340
    //   145: aload_1
    //   146: invokestatic 342	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   149: aload_3
    //   150: astore_2
    //   151: aload_0
    //   152: invokespecial 344	com/whatsapp/cc:h	()V
    //   155: aload_3
    //   156: astore_2
    //   157: aload_1
    //   158: athrow
    //   159: astore_1
    //   160: aload_2
    //   161: ifnull +9 -> 170
    //   164: aload_2
    //   165: invokeinterface 285 1 0
    //   170: aload_1
    //   171: athrow
    //   172: astore_1
    //   173: aconst_null
    //   174: astore_2
    //   175: goto -15 -> 160
    //   178: astore_1
    //   179: aconst_null
    //   180: astore_3
    //   181: goto -41 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	cc
    //   0	184	1	paramString	String
    //   15	160	2	localObject1	Object
    //   13	168	3	localObject2	Object
    //   73	62	4	locala	a
    // Exception table:
    //   from	to	target	type
    //   57	66	139	android/database/sqlite/SQLiteDatabaseCorruptException
    //   68	75	139	android/database/sqlite/SQLiteDatabaseCorruptException
    //   77	83	139	android/database/sqlite/SQLiteDatabaseCorruptException
    //   85	98	139	android/database/sqlite/SQLiteDatabaseCorruptException
    //   118	136	139	android/database/sqlite/SQLiteDatabaseCorruptException
    //   57	66	159	finally
    //   68	75	159	finally
    //   77	83	159	finally
    //   85	98	159	finally
    //   118	136	159	finally
    //   142	149	159	finally
    //   151	155	159	finally
    //   157	159	159	finally
    //   20	51	172	finally
    //   20	51	178	android/database/sqlite/SQLiteDatabaseCorruptException
  }
  
  final void a(a parama)
  {
    int i2 = 1;
    ContentValues localContentValues = new ContentValues(8);
    if (parama.e)
    {
      i1 = 1;
      localContentValues.put("use_custom_notifications", Integer.valueOf(i1));
      localContentValues.put("message_tone", parama.d());
      localContentValues.put("message_vibrate", parama.e());
      localContentValues.put("message_popup", parama.g());
      localContentValues.put("message_light", parama.f());
      localContentValues.put("call_tone", parama.h());
      localContentValues.put("call_vibrate", parama.i());
      localContentValues.put("pinned", Boolean.valueOf(parama.m));
      localContentValues.put("pinned_time", Long.valueOf(parama.n));
      if (!parama.l) {
        break label326;
      }
    }
    label326:
    for (int i1 = i2;; i1 = 0)
    {
      localContentValues.put("status_muted", Integer.valueOf(i1));
      if (parama.b())
      {
        localContentValues.put("mute_end", Long.valueOf(parama.a()));
        localContentValues.put("muted_notifications", Boolean.valueOf(parama.c()));
      }
      try
      {
        if (b(parama))
        {
          c().getWritableDatabase().delete("settings", "jid = ?", new String[] { parama.a });
          this.a.remove(parama.a);
          return;
        }
        if (c().getWritableDatabase().update("settings", localContentValues, "jid = ?", new String[] { parama.a }) == 0)
        {
          localContentValues.put("jid", parama.a);
          c().getWritableDatabase().insert("settings", null, localContentValues);
          return;
        }
      }
      catch (SQLiteDatabaseCorruptException parama)
      {
        Log.b("chat-settings-store/save", parama);
        h();
        throw parama;
      }
      return;
      i1 = 0;
      break;
    }
  }
  
  /* Error */
  public final void a(String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 432	com/whatsapp/cc:a	(Ljava/lang/String;)Lcom/whatsapp/cc$a;
    //   5: astore 6
    //   7: lload_2
    //   8: aload 6
    //   10: getfield 95	com/whatsapp/cc$a:c	J
    //   13: lcmp
    //   14: ifne +13 -> 27
    //   17: iload 4
    //   19: aload 6
    //   21: getfield 102	com/whatsapp/cc$a:d	Z
    //   24: if_icmpeq +77 -> 101
    //   27: aload 6
    //   29: lload_2
    //   30: putfield 95	com/whatsapp/cc$a:c	J
    //   33: aload 6
    //   35: invokestatic 410	com/whatsapp/cc:b	(Lcom/whatsapp/cc$a;)Z
    //   38: ifeq +64 -> 102
    //   41: aload_0
    //   42: invokevirtual 228	com/whatsapp/cc:c	()Lcom/whatsapp/cc$b;
    //   45: invokevirtual 252	com/whatsapp/cc$b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   48: ldc_w 259
    //   51: ldc_w 334
    //   54: iconst_1
    //   55: anewarray 126	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: aload_1
    //   61: aastore
    //   62: invokevirtual 414	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   65: pop
    //   66: aload_0
    //   67: getfield 51	com/whatsapp/cc:a	Ljava/util/Map;
    //   70: aload_1
    //   71: invokeinterface 417 2 0
    //   76: pop
    //   77: aload_0
    //   78: getfield 67	com/whatsapp/cc:l	Lcom/whatsapp/hx;
    //   81: aload_1
    //   82: invokevirtual 434	com/whatsapp/hx:a	(Ljava/lang/String;)V
    //   85: iload 5
    //   87: ifeq +14 -> 101
    //   90: aload_0
    //   91: getfield 57	com/whatsapp/cc:g	Lcom/whatsapp/messaging/aj;
    //   94: iconst_5
    //   95: aload_1
    //   96: lload_2
    //   97: iconst_0
    //   98: invokevirtual 437	com/whatsapp/messaging/aj:a	(ILjava/lang/String;JI)V
    //   101: return
    //   102: aload 6
    //   104: iload 4
    //   106: putfield 102	com/whatsapp/cc$a:d	Z
    //   109: new 346	android/content/ContentValues
    //   112: dup
    //   113: iconst_2
    //   114: invokespecial 349	android/content/ContentValues:<init>	(I)V
    //   117: astore 6
    //   119: aload 6
    //   121: ldc_w 401
    //   124: lload_2
    //   125: invokestatic 392	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   128: invokevirtual 395	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   131: aload 6
    //   133: ldc_w 406
    //   136: iload 4
    //   138: invokestatic 382	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   141: invokevirtual 385	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Boolean;)V
    //   144: aload_0
    //   145: invokevirtual 228	com/whatsapp/cc:c	()Lcom/whatsapp/cc$b;
    //   148: invokevirtual 252	com/whatsapp/cc$b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   151: ldc_w 259
    //   154: aload 6
    //   156: ldc_w 334
    //   159: iconst_1
    //   160: anewarray 126	java/lang/String
    //   163: dup
    //   164: iconst_0
    //   165: aload_1
    //   166: aastore
    //   167: invokevirtual 421	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   170: ifne -93 -> 77
    //   173: aload 6
    //   175: ldc_w 423
    //   178: aload_1
    //   179: invokevirtual 365	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload_0
    //   183: invokevirtual 228	com/whatsapp/cc:c	()Lcom/whatsapp/cc$b;
    //   186: invokevirtual 252	com/whatsapp/cc$b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   189: ldc_w 259
    //   192: aconst_null
    //   193: aload 6
    //   195: invokevirtual 427	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   198: pop2
    //   199: goto -122 -> 77
    //   202: astore_1
    //   203: ldc_w 439
    //   206: aload_1
    //   207: invokestatic 342	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   210: aload_0
    //   211: invokespecial 344	com/whatsapp/cc:h	()V
    //   214: aload_1
    //   215: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	cc
    //   0	216	1	paramString	String
    //   0	216	2	paramLong	long
    //   0	216	4	paramBoolean1	boolean
    //   0	216	5	paramBoolean2	boolean
    //   5	189	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   27	77	202	android/database/sqlite/SQLiteDatabaseCorruptException
    //   102	199	202	android/database/sqlite/SQLiteDatabaseCorruptException
  }
  
  public final void a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if (!TextUtils.equals(paramString2, paramString1.f))
    {
      paramString1.f = paramString2;
      a(paramString1);
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    a(paramString, 0L, a(paramString).d, paramBoolean);
  }
  
  public final void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    a locala = a(paramString);
    for (;;)
    {
      try
      {
        boolean bool = locala.m;
        long l1 = locala.n;
        locala.m = paramBoolean1;
        if (paramBoolean1)
        {
          if (paramLong > 0L)
          {
            locala.n = paramLong;
            ContentValues localContentValues = new ContentValues(2);
            localContentValues.put("pinned", Boolean.valueOf(locala.m));
            localContentValues.put("pinned_time", Long.valueOf(locala.n));
            if (c().getWritableDatabase().update("settings", localContentValues, "jid =?", new String[] { paramString }) == 0)
            {
              localContentValues.put("jid", paramString);
              c().getWritableDatabase().insert("settings", null, localContentValues);
            }
            if (paramBoolean2)
            {
              if (bool != paramBoolean1) {
                break label242;
              }
              if (l1 != locala.n)
              {
                break label242;
                this.g.a(new ar(locala.n, i1, paramString), 0);
              }
            }
            this.l.b();
            return;
          }
          locala.n = this.e.b();
          continue;
        }
        locala.n = 0L;
      }
      catch (SQLiteDatabaseCorruptException paramString)
      {
        Log.b("chat-settings-store/set-pin", paramString);
        h();
        throw paramString;
      }
      continue;
      label242:
      do
      {
        i1 = 12;
        break;
      } while (!paramBoolean1);
      int i1 = 11;
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if (!TextUtils.equals(paramString2, paramString1.g))
    {
      paramString1.g = paramString2;
      a(paramString1);
    }
  }
  
  public final void b(String paramString, boolean paramBoolean)
  {
    a locala = a(paramString);
    if (!locala.l)
    {
      locala.l = true;
      a(locala);
      this.h.c();
      if (paramBoolean) {
        this.g.a(this.o, paramString);
      }
    }
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: new 2	com/whatsapp/cc
    //   3: dup
    //   4: aload_0
    //   5: getfield 53	com/whatsapp/cc:e	Lcom/whatsapp/ant;
    //   8: aload_0
    //   9: getfield 55	com/whatsapp/cc:f	Lcom/whatsapp/and;
    //   12: aload_0
    //   13: getfield 57	com/whatsapp/cc:g	Lcom/whatsapp/messaging/aj;
    //   16: aload_0
    //   17: getfield 59	com/whatsapp/cc:h	Lcom/whatsapp/dh;
    //   20: aload_0
    //   21: getfield 61	com/whatsapp/cc:i	Lcom/whatsapp/vv;
    //   24: aload_0
    //   25: getfield 63	com/whatsapp/cc:j	Lcom/whatsapp/atu;
    //   28: aload_0
    //   29: getfield 65	com/whatsapp/cc:k	Lcom/whatsapp/lt;
    //   32: aload_0
    //   33: getfield 67	com/whatsapp/cc:l	Lcom/whatsapp/hx;
    //   36: aload_0
    //   37: getfield 69	com/whatsapp/cc:m	Lcom/whatsapp/ox;
    //   40: aload_0
    //   41: getfield 71	com/whatsapp/cc:n	Lcom/whatsapp/data/ad;
    //   44: aload_0
    //   45: getfield 73	com/whatsapp/cc:o	Lcom/whatsapp/data/e;
    //   48: ldc -59
    //   50: invokespecial 194	com/whatsapp/cc:<init>	(Lcom/whatsapp/ant;Lcom/whatsapp/and;Lcom/whatsapp/messaging/aj;Lcom/whatsapp/dh;Lcom/whatsapp/vv;Lcom/whatsapp/atu;Lcom/whatsapp/lt;Lcom/whatsapp/hx;Lcom/whatsapp/ox;Lcom/whatsapp/data/ad;Lcom/whatsapp/data/e;Ljava/lang/String;)V
    //   53: astore 4
    //   55: aload_0
    //   56: aload 4
    //   58: invokestatic 470	com/whatsapp/cc:a	(Lcom/whatsapp/cc;Lcom/whatsapp/cc;)Z
    //   61: ifne +36 -> 97
    //   64: ldc_w 472
    //   67: invokestatic 289	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   70: aload 4
    //   72: invokevirtual 228	com/whatsapp/cc:c	()Lcom/whatsapp/cc$b;
    //   75: invokevirtual 473	com/whatsapp/cc$b:close	()V
    //   78: aload 4
    //   80: invokevirtual 228	com/whatsapp/cc:c	()Lcom/whatsapp/cc$b;
    //   83: invokevirtual 327	com/whatsapp/cc$b:a	()Z
    //   86: ifne +9 -> 95
    //   89: ldc_w 475
    //   92: invokestatic 478	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   95: iconst_0
    //   96: ireturn
    //   97: ldc_w 480
    //   100: invokestatic 248	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   103: aload 4
    //   105: invokevirtual 228	com/whatsapp/cc:c	()Lcom/whatsapp/cc$b;
    //   108: invokevirtual 473	com/whatsapp/cc$b:close	()V
    //   111: aload_0
    //   112: getfield 61	com/whatsapp/cc:i	Lcom/whatsapp/vv;
    //   115: invokevirtual 481	com/whatsapp/vv:c	()Z
    //   118: ifeq +28 -> 146
    //   121: ldc_w 483
    //   124: invokestatic 248	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   127: aload 4
    //   129: invokevirtual 228	com/whatsapp/cc:c	()Lcom/whatsapp/cc$b;
    //   132: invokevirtual 327	com/whatsapp/cc$b:a	()Z
    //   135: ifne +9 -> 144
    //   138: ldc_w 475
    //   141: invokestatic 478	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   144: iconst_0
    //   145: ireturn
    //   146: invokestatic 488	com/whatsapp/r:n	()Lcom/whatsapp/r$b;
    //   149: astore_1
    //   150: aload_1
    //   151: ifnonnull +55 -> 206
    //   154: ldc_w 490
    //   157: invokestatic 478	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   160: aload 4
    //   162: invokevirtual 228	com/whatsapp/cc:c	()Lcom/whatsapp/cc$b;
    //   165: invokevirtual 327	com/whatsapp/cc$b:a	()Z
    //   168: ifne +9 -> 177
    //   171: ldc_w 475
    //   174: invokestatic 478	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   177: iconst_0
    //   178: ireturn
    //   179: astore_1
    //   180: ldc_w 492
    //   183: aload_1
    //   184: invokestatic 494	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   187: aload 4
    //   189: invokevirtual 228	com/whatsapp/cc:c	()Lcom/whatsapp/cc$b;
    //   192: invokevirtual 327	com/whatsapp/cc$b:a	()Z
    //   195: ifne +9 -> 204
    //   198: ldc_w 475
    //   201: invokestatic 478	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   204: iconst_0
    //   205: ireturn
    //   206: aload_0
    //   207: getfield 69	com/whatsapp/cc:m	Lcom/whatsapp/ox;
    //   210: invokestatic 496	com/whatsapp/cc:a	(Lcom/whatsapp/ox;)Ljava/io/File;
    //   213: astore_2
    //   214: new 220	java/lang/StringBuilder
    //   217: dup
    //   218: ldc_w 498
    //   221: invokespecial 225	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   224: aload_2
    //   225: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   228: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 248	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   234: new 500	java/io/FileInputStream
    //   237: dup
    //   238: aload 4
    //   240: invokevirtual 228	com/whatsapp/cc:c	()Lcom/whatsapp/cc$b;
    //   243: invokestatic 231	com/whatsapp/cc$b:a	(Lcom/whatsapp/cc$b;)Ljava/io/File;
    //   246: invokespecial 503	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   249: astore 5
    //   251: new 505	java/io/FileOutputStream
    //   254: dup
    //   255: aload_2
    //   256: invokespecial 506	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   259: astore 6
    //   261: aload 6
    //   263: aload_1
    //   264: invokestatic 509	com/whatsapp/r:a	(Ljava/io/OutputStream;Lcom/whatsapp/r$b;)V
    //   267: invokestatic 514	com/whatsapp/util/r:a	()Lcom/whatsapp/util/r;
    //   270: aload 6
    //   272: getstatic 519	com/whatsapp/util/r$b:l	Lcom/whatsapp/util/r$b;
    //   275: aload_1
    //   276: getfield 524	com/whatsapp/r$b:c	[B
    //   279: aload_1
    //   280: getfield 527	com/whatsapp/r$b:a	Lcom/whatsapp/r$a;
    //   283: getfield 531	com/whatsapp/r$a:e	[B
    //   286: invokevirtual 534	com/whatsapp/util/r:a	(Ljava/io/OutputStream;Lcom/whatsapp/util/r$b;[B[B)Ljava/io/OutputStream;
    //   289: astore 7
    //   291: aload 7
    //   293: invokestatic 540	java/nio/channels/Channels:newChannel	(Ljava/io/OutputStream;)Ljava/nio/channels/WritableByteChannel;
    //   296: astore 8
    //   298: aload 5
    //   300: invokevirtual 544	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   303: astore_3
    //   304: aconst_null
    //   305: astore_1
    //   306: aload_3
    //   307: aload 8
    //   309: invokestatic 549	a/a/a/a/d:a	(Ljava/nio/channels/FileChannel;Ljava/nio/channels/WritableByteChannel;)V
    //   312: aload_3
    //   313: ifnull +7 -> 320
    //   316: aload_3
    //   317: invokevirtual 552	java/nio/channels/FileChannel:close	()V
    //   320: aload 8
    //   322: ifnull +10 -> 332
    //   325: aload 8
    //   327: invokeinterface 555 1 0
    //   332: aload 7
    //   334: ifnull +8 -> 342
    //   337: aload 7
    //   339: invokevirtual 558	java/io/OutputStream:close	()V
    //   342: aload 6
    //   344: invokevirtual 558	java/io/OutputStream:close	()V
    //   347: aload 5
    //   349: invokevirtual 559	java/io/FileInputStream:close	()V
    //   352: aload 4
    //   354: invokevirtual 228	com/whatsapp/cc:c	()Lcom/whatsapp/cc$b;
    //   357: invokevirtual 327	com/whatsapp/cc$b:a	()Z
    //   360: ifne +9 -> 369
    //   363: ldc_w 475
    //   366: invokestatic 478	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   369: iconst_1
    //   370: ireturn
    //   371: astore_2
    //   372: aload_2
    //   373: astore_1
    //   374: aload_2
    //   375: athrow
    //   376: astore_2
    //   377: aload_3
    //   378: ifnull +11 -> 389
    //   381: aload_1
    //   382: ifnull +128 -> 510
    //   385: aload_3
    //   386: invokevirtual 552	java/nio/channels/FileChannel:close	()V
    //   389: aload_2
    //   390: athrow
    //   391: astore_1
    //   392: aload_1
    //   393: athrow
    //   394: astore_2
    //   395: aload_1
    //   396: astore_3
    //   397: aload_2
    //   398: astore_1
    //   399: aload 8
    //   401: ifnull +14 -> 415
    //   404: aload_3
    //   405: ifnull +118 -> 523
    //   408: aload 8
    //   410: invokeinterface 555 1 0
    //   415: aload_1
    //   416: athrow
    //   417: astore_1
    //   418: aload_1
    //   419: athrow
    //   420: astore_2
    //   421: aload_1
    //   422: astore_3
    //   423: aload_2
    //   424: astore_1
    //   425: aload 7
    //   427: ifnull +12 -> 439
    //   430: aload_3
    //   431: ifnull +108 -> 539
    //   434: aload 7
    //   436: invokevirtual 558	java/io/OutputStream:close	()V
    //   439: aload_1
    //   440: athrow
    //   441: astore_1
    //   442: aload_1
    //   443: athrow
    //   444: astore_2
    //   445: aload_1
    //   446: astore_3
    //   447: aload_2
    //   448: astore_1
    //   449: aload_3
    //   450: ifnull +103 -> 553
    //   453: aload 6
    //   455: invokevirtual 558	java/io/OutputStream:close	()V
    //   458: aload_1
    //   459: athrow
    //   460: astore_1
    //   461: aload_1
    //   462: athrow
    //   463: astore_2
    //   464: aload_1
    //   465: astore_3
    //   466: aload_2
    //   467: astore_1
    //   468: aload_3
    //   469: ifnull +98 -> 567
    //   472: aload 5
    //   474: invokevirtual 559	java/io/FileInputStream:close	()V
    //   477: aload_1
    //   478: athrow
    //   479: astore_1
    //   480: ldc_w 561
    //   483: aload_1
    //   484: invokestatic 282	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   487: goto -135 -> 352
    //   490: astore_1
    //   491: aload 4
    //   493: invokevirtual 228	com/whatsapp/cc:c	()Lcom/whatsapp/cc$b;
    //   496: invokevirtual 327	com/whatsapp/cc$b:a	()Z
    //   499: ifne +9 -> 508
    //   502: ldc_w 475
    //   505: invokestatic 478	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   508: aload_1
    //   509: athrow
    //   510: aload_3
    //   511: invokevirtual 552	java/nio/channels/FileChannel:close	()V
    //   514: goto -125 -> 389
    //   517: astore_1
    //   518: aconst_null
    //   519: astore_3
    //   520: goto -121 -> 399
    //   523: aload 8
    //   525: invokeinterface 555 1 0
    //   530: goto -115 -> 415
    //   533: astore_1
    //   534: aconst_null
    //   535: astore_3
    //   536: goto -111 -> 425
    //   539: aload 7
    //   541: invokevirtual 558	java/io/OutputStream:close	()V
    //   544: goto -105 -> 439
    //   547: astore_1
    //   548: aconst_null
    //   549: astore_3
    //   550: goto -101 -> 449
    //   553: aload 6
    //   555: invokevirtual 558	java/io/OutputStream:close	()V
    //   558: goto -100 -> 458
    //   561: astore_1
    //   562: aconst_null
    //   563: astore_3
    //   564: goto -96 -> 468
    //   567: aload 5
    //   569: invokevirtual 559	java/io/FileInputStream:close	()V
    //   572: goto -95 -> 477
    //   575: astore_1
    //   576: goto -187 -> 389
    //   579: astore_2
    //   580: goto -165 -> 415
    //   583: astore_2
    //   584: goto -145 -> 439
    //   587: astore_2
    //   588: goto -130 -> 458
    //   591: astore_2
    //   592: goto -115 -> 477
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	595	0	this	cc
    //   149	2	1	localb	r.b
    //   179	101	1	localException1	Exception
    //   305	77	1	localObject1	Object
    //   391	5	1	localThrowable1	Throwable
    //   398	18	1	localObject2	Object
    //   417	5	1	localThrowable2	Throwable
    //   424	16	1	localObject3	Object
    //   441	5	1	localThrowable3	Throwable
    //   448	11	1	localObject4	Object
    //   460	5	1	localThrowable4	Throwable
    //   467	11	1	localObject5	Object
    //   479	5	1	localException2	Exception
    //   490	19	1	localObject6	Object
    //   517	1	1	localObject7	Object
    //   533	1	1	localObject8	Object
    //   547	1	1	localObject9	Object
    //   561	1	1	localObject10	Object
    //   575	1	1	localThrowable5	Throwable
    //   213	43	2	localFile	File
    //   371	4	2	localThrowable6	Throwable
    //   376	14	2	localObject11	Object
    //   394	4	2	localObject12	Object
    //   420	4	2	localObject13	Object
    //   444	4	2	localObject14	Object
    //   463	4	2	localObject15	Object
    //   579	1	2	localThrowable7	Throwable
    //   583	1	2	localThrowable8	Throwable
    //   587	1	2	localThrowable9	Throwable
    //   591	1	2	localThrowable10	Throwable
    //   303	261	3	localObject16	Object
    //   53	439	4	localcc	cc
    //   249	319	5	localFileInputStream	java.io.FileInputStream
    //   259	295	6	localFileOutputStream	java.io.FileOutputStream
    //   289	251	7	localOutputStream	java.io.OutputStream
    //   296	228	8	localWritableByteChannel	java.nio.channels.WritableByteChannel
    // Exception table:
    //   from	to	target	type
    //   146	150	179	java/lang/Exception
    //   154	160	179	java/lang/Exception
    //   306	312	371	java/lang/Throwable
    //   306	312	376	finally
    //   374	376	376	finally
    //   298	304	391	java/lang/Throwable
    //   316	320	391	java/lang/Throwable
    //   389	391	391	java/lang/Throwable
    //   510	514	391	java/lang/Throwable
    //   392	394	394	finally
    //   291	298	417	java/lang/Throwable
    //   325	332	417	java/lang/Throwable
    //   415	417	417	java/lang/Throwable
    //   523	530	417	java/lang/Throwable
    //   418	420	420	finally
    //   261	291	441	java/lang/Throwable
    //   337	342	441	java/lang/Throwable
    //   439	441	441	java/lang/Throwable
    //   539	544	441	java/lang/Throwable
    //   442	444	444	finally
    //   251	261	460	java/lang/Throwable
    //   342	347	460	java/lang/Throwable
    //   458	460	460	java/lang/Throwable
    //   553	558	460	java/lang/Throwable
    //   461	463	463	finally
    //   234	251	479	java/lang/Exception
    //   347	352	479	java/lang/Exception
    //   472	477	479	java/lang/Exception
    //   477	479	479	java/lang/Exception
    //   567	572	479	java/lang/Exception
    //   55	78	490	finally
    //   97	127	490	finally
    //   146	150	490	finally
    //   154	160	490	finally
    //   180	187	490	finally
    //   206	234	490	finally
    //   234	251	490	finally
    //   347	352	490	finally
    //   472	477	490	finally
    //   477	479	490	finally
    //   480	487	490	finally
    //   567	572	490	finally
    //   298	304	517	finally
    //   316	320	517	finally
    //   385	389	517	finally
    //   389	391	517	finally
    //   510	514	517	finally
    //   291	298	533	finally
    //   325	332	533	finally
    //   408	415	533	finally
    //   415	417	533	finally
    //   523	530	533	finally
    //   261	291	547	finally
    //   337	342	547	finally
    //   434	439	547	finally
    //   439	441	547	finally
    //   539	544	547	finally
    //   251	261	561	finally
    //   342	347	561	finally
    //   453	458	561	finally
    //   458	460	561	finally
    //   553	558	561	finally
    //   385	389	575	java/lang/Throwable
    //   408	415	579	java/lang/Throwable
    //   434	439	583	java/lang/Throwable
    //   453	458	587	java/lang/Throwable
    //   472	477	591	java/lang/Throwable
  }
  
  /* Error */
  public final boolean b(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_0
    //   4: istore_2
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 564	com/whatsapp/cc:d	Lcom/whatsapp/cc$b;
    //   11: ifnull +15 -> 26
    //   14: aload_0
    //   15: getfield 564	com/whatsapp/cc:d	Lcom/whatsapp/cc$b;
    //   18: invokevirtual 473	com/whatsapp/cc$b:close	()V
    //   21: aload_0
    //   22: aconst_null
    //   23: putfield 564	com/whatsapp/cc:d	Lcom/whatsapp/cc$b;
    //   26: aload_1
    //   27: ldc -64
    //   29: invokevirtual 203	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   32: astore 5
    //   34: aload_0
    //   35: getfield 69	com/whatsapp/cc:m	Lcom/whatsapp/ox;
    //   38: invokestatic 496	com/whatsapp/cc:a	(Lcom/whatsapp/ox;)Ljava/io/File;
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 567	java/io/File:exists	()Z
    //   48: ifne +56 -> 104
    //   51: aload_1
    //   52: ldc -59
    //   54: invokevirtual 203	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 567	java/io/File:exists	()Z
    //   62: ifeq +42 -> 104
    //   65: ldc_w 569
    //   68: invokestatic 248	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   71: aload_0
    //   72: getfield 61	com/whatsapp/cc:i	Lcom/whatsapp/vv;
    //   75: aload 4
    //   77: aload 5
    //   79: invokestatic 572	a/a/a/a/d:a	(Lcom/whatsapp/vv;Ljava/io/File;Ljava/io/File;)Z
    //   82: istore_3
    //   83: iload_3
    //   84: istore_2
    //   85: aload_1
    //   86: invokevirtual 574	java/io/File:delete	()Z
    //   89: ifne +11 -> 100
    //   92: ldc_w 576
    //   95: invokestatic 478	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   98: iload_3
    //   99: istore_2
    //   100: aload_0
    //   101: monitorexit
    //   102: iload_2
    //   103: ireturn
    //   104: aload_0
    //   105: getfield 61	com/whatsapp/cc:i	Lcom/whatsapp/vv;
    //   108: aload 5
    //   110: invokevirtual 579	com/whatsapp/vv:a	(Ljava/io/File;)Lcom/whatsapp/util/e;
    //   113: astore 7
    //   115: new 581	java/io/BufferedInputStream
    //   118: dup
    //   119: new 500	java/io/FileInputStream
    //   122: dup
    //   123: aload 4
    //   125: invokespecial 503	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   128: invokespecial 584	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   131: astore 8
    //   133: aload 8
    //   135: invokestatic 587	com/whatsapp/r:a	(Ljava/io/InputStream;)Lcom/whatsapp/r$a;
    //   138: astore_1
    //   139: aload_0
    //   140: getfield 71	com/whatsapp/cc:n	Lcom/whatsapp/data/ad;
    //   143: getfield 590	com/whatsapp/data/ad:c	Lcom/whatsapp/data/cb;
    //   146: aload_1
    //   147: invokevirtual 595	com/whatsapp/data/cb:a	(Lcom/whatsapp/r$a;)Lcom/whatsapp/data/cb$b;
    //   150: astore 5
    //   152: aload 5
    //   154: ifnonnull +38 -> 192
    //   157: ldc_w 597
    //   160: invokestatic 289	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   163: aload 8
    //   165: invokevirtual 600	java/io/InputStream:close	()V
    //   168: aload 7
    //   170: invokevirtual 558	java/io/OutputStream:close	()V
    //   173: goto -73 -> 100
    //   176: astore_1
    //   177: ldc_w 602
    //   180: aload_1
    //   181: invokestatic 282	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   184: goto -84 -> 100
    //   187: astore_1
    //   188: aload_0
    //   189: monitorexit
    //   190: aload_1
    //   191: athrow
    //   192: new 220	java/lang/StringBuilder
    //   195: dup
    //   196: ldc_w 604
    //   199: invokespecial 225	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: aload 4
    //   204: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   207: ldc_w 606
    //   210: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 4
    //   215: invokevirtual 609	java/io/File:length	()J
    //   218: invokevirtual 612	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   221: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 614	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   227: invokestatic 514	com/whatsapp/util/r:a	()Lcom/whatsapp/util/r;
    //   230: aload 8
    //   232: aload 7
    //   234: iconst_0
    //   235: iconst_0
    //   236: aload 4
    //   238: invokevirtual 609	java/io/File:length	()J
    //   241: aconst_null
    //   242: getstatic 519	com/whatsapp/util/r$b:l	Lcom/whatsapp/util/r$b;
    //   245: aload 5
    //   247: getfield 618	com/whatsapp/data/cb$b:b	[B
    //   250: aload_1
    //   251: getfield 531	com/whatsapp/r$a:e	[B
    //   254: invokevirtual 621	com/whatsapp/util/r:a	(Ljava/io/InputStream;Ljava/io/OutputStream;IIJLcom/whatsapp/data/cb$c;Lcom/whatsapp/util/r$b;[B[B)V
    //   257: aload 8
    //   259: invokevirtual 600	java/io/InputStream:close	()V
    //   262: aload 7
    //   264: invokevirtual 558	java/io/OutputStream:close	()V
    //   267: iconst_1
    //   268: istore_2
    //   269: goto -169 -> 100
    //   272: astore_1
    //   273: aload_1
    //   274: athrow
    //   275: astore 4
    //   277: aload_1
    //   278: astore 5
    //   280: aload 4
    //   282: astore_1
    //   283: aload 5
    //   285: ifnull +33 -> 318
    //   288: aload 8
    //   290: invokevirtual 600	java/io/InputStream:close	()V
    //   293: aload_1
    //   294: athrow
    //   295: astore_1
    //   296: aload_1
    //   297: athrow
    //   298: astore 4
    //   300: aload_1
    //   301: astore 5
    //   303: aload 4
    //   305: astore_1
    //   306: aload 5
    //   308: ifnull +26 -> 334
    //   311: aload 7
    //   313: invokevirtual 558	java/io/OutputStream:close	()V
    //   316: aload_1
    //   317: athrow
    //   318: aload 8
    //   320: invokevirtual 600	java/io/InputStream:close	()V
    //   323: goto -30 -> 293
    //   326: astore_1
    //   327: aload 6
    //   329: astore 5
    //   331: goto -25 -> 306
    //   334: aload 7
    //   336: invokevirtual 558	java/io/OutputStream:close	()V
    //   339: goto -23 -> 316
    //   342: astore 4
    //   344: goto -51 -> 293
    //   347: astore 4
    //   349: goto -33 -> 316
    //   352: astore_1
    //   353: aconst_null
    //   354: astore 5
    //   356: goto -73 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	this	cc
    //   0	359	1	paramContext	Context
    //   4	265	2	bool1	boolean
    //   82	17	3	bool2	boolean
    //   41	196	4	localFile	File
    //   275	6	4	localObject1	Object
    //   298	6	4	localObject2	Object
    //   342	1	4	localThrowable1	Throwable
    //   347	1	4	localThrowable2	Throwable
    //   32	323	5	localObject3	Object
    //   1	327	6	localObject4	Object
    //   113	222	7	locale	com.whatsapp.util.e
    //   131	188	8	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   104	115	176	java/lang/Exception
    //   168	173	176	java/lang/Exception
    //   262	267	176	java/lang/Exception
    //   311	316	176	java/lang/Exception
    //   316	318	176	java/lang/Exception
    //   334	339	176	java/lang/Exception
    //   7	26	187	finally
    //   26	83	187	finally
    //   85	98	187	finally
    //   104	115	187	finally
    //   168	173	187	finally
    //   177	184	187	finally
    //   262	267	187	finally
    //   311	316	187	finally
    //   316	318	187	finally
    //   334	339	187	finally
    //   133	152	272	java/lang/Throwable
    //   157	163	272	java/lang/Throwable
    //   192	257	272	java/lang/Throwable
    //   273	275	275	finally
    //   115	133	295	java/lang/Throwable
    //   163	168	295	java/lang/Throwable
    //   257	262	295	java/lang/Throwable
    //   293	295	295	java/lang/Throwable
    //   318	323	295	java/lang/Throwable
    //   296	298	298	finally
    //   115	133	326	finally
    //   163	168	326	finally
    //   257	262	326	finally
    //   288	293	326	finally
    //   293	295	326	finally
    //   318	323	326	finally
    //   288	293	342	java/lang/Throwable
    //   311	316	347	java/lang/Throwable
    //   133	152	352	finally
    //   157	163	352	finally
    //   192	257	352	finally
  }
  
  public final boolean b(String paramString)
  {
    return a(paramString).b();
  }
  
  final b c()
  {
    try
    {
      if (this.d == null) {
        this.d = new b(u.a(), this.c);
      }
      b localb = this.d;
      return localb;
    }
    finally {}
  }
  
  public final void c(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if (!TextUtils.equals(paramString2, paramString1.h))
    {
      paramString1.h = paramString2;
      a(paramString1);
    }
  }
  
  public final void c(String paramString, boolean paramBoolean)
  {
    a locala = a(paramString);
    if (locala.l)
    {
      locala.l = false;
      a(locala);
      this.h.c();
      if (paramBoolean) {
        this.g.a(this.o, paramString);
      }
    }
  }
  
  public final boolean c(String paramString)
  {
    return a(paramString).m;
  }
  
  public final long d(String paramString)
  {
    paramString = a(paramString);
    if (paramString.m) {
      return paramString.n;
    }
    return 0L;
  }
  
  public final a d()
  {
    a locala = a("group_chat_defaults");
    if (locala.f == null) {
      locala.f = Settings.System.DEFAULT_NOTIFICATION_URI.toString();
    }
    if (TextUtils.isEmpty(locala.g)) {
      locala.g = "1";
    }
    if (TextUtils.isEmpty(locala.h)) {
      locala.h = Integer.toString(0);
    }
    if (TextUtils.isEmpty(locala.i)) {
      locala.i = "FFFFFF";
    }
    return locala;
  }
  
  public final void d(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if (!TextUtils.equals(paramString2, paramString1.i))
    {
      paramString1.i = paramString2;
      a(paramString1);
    }
  }
  
  public final long e(String paramString)
  {
    return a(paramString).a();
  }
  
  public final a e()
  {
    a locala = a("individual_chat_defaults");
    if (locala.f == null) {
      locala.f = Settings.System.DEFAULT_NOTIFICATION_URI.toString();
    }
    if (TextUtils.isEmpty(locala.g)) {
      locala.g = "1";
    }
    if (TextUtils.isEmpty(locala.h)) {
      locala.h = Integer.toString(0);
    }
    if (TextUtils.isEmpty(locala.i)) {
      locala.i = "FFFFFF";
    }
    if (locala.j == null) {
      locala.j = Settings.System.DEFAULT_RINGTONE_URI.toString();
    }
    if (TextUtils.isEmpty(locala.k)) {
      locala.k = "1";
    }
    return locala;
  }
  
  public final void e(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if (!TextUtils.equals(paramString2, paramString1.j))
    {
      paramString1.j = paramString2;
      a(paramString1);
    }
  }
  
  /* Error */
  public final java.util.Set<String> f()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 656	java/util/LinkedHashSet
    //   5: dup
    //   6: iconst_3
    //   7: invokespecial 657	java/util/LinkedHashSet:<init>	(I)V
    //   10: astore_3
    //   11: aload_0
    //   12: invokevirtual 228	com/whatsapp/cc:c	()Lcom/whatsapp/cc$b;
    //   15: invokevirtual 252	com/whatsapp/cc$b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   18: ldc_w 259
    //   21: iconst_1
    //   22: anewarray 126	java/lang/String
    //   25: dup
    //   26: iconst_0
    //   27: ldc_w 423
    //   30: aastore
    //   31: ldc_w 659
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: ldc_w 661
    //   40: invokevirtual 266	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore_1
    //   44: aload_1
    //   45: astore_2
    //   46: aload_2
    //   47: ifnull +70 -> 117
    //   50: aload_2
    //   51: astore_1
    //   52: aload_2
    //   53: invokeinterface 270 1 0
    //   58: ifeq +59 -> 117
    //   61: aload_2
    //   62: astore_1
    //   63: aload_3
    //   64: aload_2
    //   65: iconst_0
    //   66: invokeinterface 86 2 0
    //   71: invokeinterface 666 2 0
    //   76: pop
    //   77: goto -31 -> 46
    //   80: astore_3
    //   81: aload_2
    //   82: astore_1
    //   83: ldc_w 668
    //   86: aload_3
    //   87: invokestatic 342	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   90: aload_2
    //   91: astore_1
    //   92: aload_0
    //   93: invokespecial 344	com/whatsapp/cc:h	()V
    //   96: aload_2
    //   97: astore_1
    //   98: aload_3
    //   99: athrow
    //   100: astore_3
    //   101: aload_1
    //   102: astore_2
    //   103: aload_3
    //   104: astore_1
    //   105: aload_2
    //   106: ifnull +9 -> 115
    //   109: aload_2
    //   110: invokeinterface 285 1 0
    //   115: aload_1
    //   116: athrow
    //   117: aload_2
    //   118: ifnull +9 -> 127
    //   121: aload_2
    //   122: invokeinterface 285 1 0
    //   127: aload_3
    //   128: areturn
    //   129: astore_1
    //   130: goto -25 -> 105
    //   133: astore_3
    //   134: aconst_null
    //   135: astore_2
    //   136: goto -55 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	cc
    //   43	73	1	localObject1	Object
    //   129	1	1	localObject2	Object
    //   1	135	2	localObject3	Object
    //   10	54	3	localLinkedHashSet	java.util.LinkedHashSet
    //   80	19	3	localSQLiteDatabaseCorruptException1	SQLiteDatabaseCorruptException
    //   100	28	3	localSet	java.util.Set<String>
    //   133	1	3	localSQLiteDatabaseCorruptException2	SQLiteDatabaseCorruptException
    // Exception table:
    //   from	to	target	type
    //   52	61	80	android/database/sqlite/SQLiteDatabaseCorruptException
    //   63	77	80	android/database/sqlite/SQLiteDatabaseCorruptException
    //   52	61	100	finally
    //   63	77	100	finally
    //   83	90	100	finally
    //   92	96	100	finally
    //   98	100	100	finally
    //   11	44	129	finally
    //   11	44	133	android/database/sqlite/SQLiteDatabaseCorruptException
  }
  
  public final void f(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if (!TextUtils.equals(paramString2, paramString1.k))
    {
      paramString1.k = paramString2;
      a(paramString1);
    }
  }
  
  public final boolean f(String paramString)
  {
    return a(paramString).l;
  }
  
  /* Error */
  public final void g(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 228	com/whatsapp/cc:c	()Lcom/whatsapp/cc$b;
    //   4: invokevirtual 252	com/whatsapp/cc$b:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: ldc_w 259
    //   10: getstatic 262	com/whatsapp/cc$c:a	[Ljava/lang/String;
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: invokevirtual 266	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   21: astore_3
    //   22: aload_3
    //   23: ifnull +291 -> 314
    //   26: aload_3
    //   27: astore_2
    //   28: aload_3
    //   29: invokeinterface 270 1 0
    //   34: ifeq +280 -> 314
    //   37: aload_3
    //   38: astore_2
    //   39: new 220	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 671	java/lang/StringBuilder:<init>	()V
    //   46: aload_1
    //   47: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc_w 673
    //   53: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload_3
    //   57: iconst_0
    //   58: invokeinterface 86 2 0
    //   63: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 675
    //   69: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_3
    //   73: iconst_1
    //   74: invokeinterface 92 2 0
    //   79: invokevirtual 612	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   82: ldc_w 677
    //   85: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_3
    //   89: iconst_2
    //   90: invokeinterface 99 2 0
    //   95: invokevirtual 680	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: ldc_w 682
    //   101: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_3
    //   105: iconst_3
    //   106: invokeinterface 99 2 0
    //   111: invokevirtual 680	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: ldc_w 684
    //   117: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_3
    //   121: iconst_4
    //   122: invokeinterface 86 2 0
    //   127: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc_w 686
    //   133: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_3
    //   137: iconst_5
    //   138: invokeinterface 86 2 0
    //   143: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc_w 688
    //   149: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload_3
    //   153: bipush 6
    //   155: invokeinterface 86 2 0
    //   160: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: ldc_w 690
    //   166: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_3
    //   170: bipush 7
    //   172: invokeinterface 86 2 0
    //   177: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc_w 692
    //   183: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload_3
    //   187: bipush 8
    //   189: invokeinterface 86 2 0
    //   194: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc_w 694
    //   200: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_3
    //   204: bipush 9
    //   206: invokeinterface 86 2 0
    //   211: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc_w 696
    //   217: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: aload_3
    //   221: bipush 10
    //   223: invokeinterface 86 2 0
    //   228: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc_w 698
    //   234: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_3
    //   238: bipush 11
    //   240: invokeinterface 86 2 0
    //   245: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc_w 700
    //   251: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload_3
    //   255: bipush 12
    //   257: invokeinterface 92 2 0
    //   262: invokevirtual 612	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   265: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 248	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   271: goto -249 -> 22
    //   274: astore 4
    //   276: aload_3
    //   277: astore_2
    //   278: new 220	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 671	java/lang/StringBuilder:<init>	()V
    //   285: aload_1
    //   286: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc_w 702
    //   292: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: invokevirtual 244	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: aload 4
    //   300: invokestatic 282	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   303: aload_3
    //   304: ifnull +9 -> 313
    //   307: aload_3
    //   308: invokeinterface 285 1 0
    //   313: return
    //   314: aload_3
    //   315: ifnull -2 -> 313
    //   318: aload_3
    //   319: invokeinterface 285 1 0
    //   324: return
    //   325: astore_1
    //   326: aconst_null
    //   327: astore_2
    //   328: aload_2
    //   329: ifnull +9 -> 338
    //   332: aload_2
    //   333: invokeinterface 285 1 0
    //   338: aload_1
    //   339: athrow
    //   340: astore_1
    //   341: goto -13 -> 328
    //   344: astore 4
    //   346: aconst_null
    //   347: astore_3
    //   348: goto -72 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	cc
    //   0	351	1	paramString	String
    //   27	306	2	localCursor1	Cursor
    //   21	327	3	localCursor2	Cursor
    //   274	25	4	localException1	Exception
    //   344	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   28	37	274	java/lang/Exception
    //   39	271	274	java/lang/Exception
    //   0	22	325	finally
    //   28	37	340	finally
    //   39	271	340	finally
    //   278	303	340	finally
    //   0	22	344	java/lang/Exception
  }
  
  public static final class a
  {
    String a;
    long b;
    long c;
    boolean d;
    boolean e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    boolean l;
    boolean m;
    long n;
    private final and o;
    private final atu p;
    
    private a(and paramand, atu paramatu)
    {
      this.o = paramand;
      this.p = paramatu;
    }
    
    public final long a()
    {
      if (this.c > System.currentTimeMillis()) {
        return this.c;
      }
      return 0L;
    }
    
    public final boolean b()
    {
      return a() != 0L;
    }
    
    public final boolean c()
    {
      return (!b()) || (this.d);
    }
    
    public final String d()
    {
      if ((!this.e) || (this.f == null)) {}
      for (String str = j().f; (str != null) && (d.a(this.o, this.p, Uri.parse(str))); str = this.f) {
        return str;
      }
      return Settings.System.DEFAULT_NOTIFICATION_URI.toString();
    }
    
    public final String e()
    {
      if ((!this.e) || (TextUtils.isEmpty(this.g))) {
        return j().g;
      }
      return this.g;
    }
    
    public final String f()
    {
      if ((!this.e) || (TextUtils.isEmpty(this.i))) {
        return j().i;
      }
      return this.i;
    }
    
    public final String g()
    {
      if ((!this.e) || (TextUtils.isEmpty(this.h))) {
        return j().h;
      }
      return this.h;
    }
    
    public final String h()
    {
      if ((!this.e) || (this.j == null)) {}
      for (String str = j().j; (str != null) && (d.a(this.o, this.p, Uri.parse(str))); str = this.j) {
        return str;
      }
      return Settings.System.DEFAULT_NOTIFICATION_URI.toString();
    }
    
    public final String i()
    {
      if ((!this.e) || (TextUtils.isEmpty(this.k))) {
        return j().k;
      }
      return this.k;
    }
    
    final a j()
    {
      if (("group_chat_defaults".equals(this.a)) || ("individual_chat_defaults".equals(this.a))) {
        return this;
      }
      if (qz.e(this.a)) {
        return cc.g().d();
      }
      return cc.g().e();
    }
    
    public final String toString()
    {
      return String.format(Locale.ENGLISH, "jid: %s deleted:%d muteEndTime:%d showNotificationWhenMuted:%b useCustomNotification:%b messageTone:%s messageVibrate:%s messagePopup:%s messageLight:%scallTone:%s callVibrate:%s statusMuted:%b pinned:%b pinned_time:%d", new Object[] { this.a, Long.valueOf(this.b), Long.valueOf(this.c), Boolean.valueOf(this.d), Boolean.valueOf(this.e), this.f, this.g, this.h, this.i, this.j, this.k, Boolean.valueOf(this.l), Boolean.valueOf(this.m), Long.valueOf(this.n) });
    }
  }
  
  static final class b
    extends SQLiteOpenHelper
  {
    private final Context a;
    private final String b;
    
    b(Context paramContext, String paramString)
    {
      super(paramString, null, 1);
      this.b = paramString;
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
        Log.d("chat-settings-store/schema " + paramString, paramSQLiteDatabase);
        return "";
      }
      finally
      {
        localCursor.close();
      }
    }
    
    private static void a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      if (!paramString1.contains(paramString3 + " " + paramString4)) {}
      try
      {
        paramSQLiteDatabase.execSQL("ALTER TABLE " + paramString2 + " ADD " + paramString3 + " " + paramString4);
        return;
      }
      catch (SQLiteException paramSQLiteDatabase)
      {
        Log.d("chat-settings-store/add-column " + paramString3, paramSQLiteDatabase);
      }
    }
    
    private File b()
    {
      return this.a.getDatabasePath(this.b);
    }
    
    final boolean a()
    {
      try
      {
        close();
        Log.i("chat-settings-store/delete-database");
        boolean bool = b().delete();
        File localFile = b();
        if (!new File(localFile.getPath(), localFile.getName() + "-journal").delete()) {
          Log.w("chat-settings-store/delete-database/failed to delete journal file");
        }
        Log.i("chat-settings-store/delete-database/result=" + bool);
        return bool;
      }
      finally {}
    }
    
    public final SQLiteDatabase getReadableDatabase()
    {
      return getWritableDatabase();
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
        Log.w("chat-settings-store/corrupt/removing");
        a();
        return super.getWritableDatabase();
      }
      catch (SQLiteException localSQLiteException)
      {
        if (localSQLiteException.toString().contains("file is encrypted"))
        {
          Log.w("chat-settings-store/encrypted/removing");
          a();
          return super.getWritableDatabase();
        }
        throw localSQLiteException;
      }
      catch (StackOverflowError localStackOverflowError)
      {
        Log.w("chat-settings-store/stackoverflowerror");
        StackTraceElement[] arrayOfStackTraceElement = localStackOverflowError.getStackTrace();
        int j = arrayOfStackTraceElement.length;
        int i = 0;
        while (i < j)
        {
          if (arrayOfStackTraceElement[i].getMethodName().equals("onCorruption"))
          {
            Log.w("chat-settings-store/stackoverflowerror/corrupt/removing");
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
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS settings");
      paramSQLiteDatabase.execSQL("CREATE TABLE settings (_id INTEGER PRIMARY KEY AUTOINCREMENT,jid TEXT,deleted INTEGER,mute_end INTEGER,muted_notifications BOOLEAN,use_custom_notifications BOOLEAN,message_tone TEXT,message_vibrate INTEGER,message_popup INTEGER,message_light INTEGER,call_tone TEXT,call_vibrate INTEGER,status_muted INTEGER,pinned BOOLEAN,pinned_time INTEGER);");
      paramSQLiteDatabase.execSQL("CREATE UNIQUE INDEX jid_index ON settings(jid);");
    }
    
    public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      Log.i("chat-settings-store/downgrade from " + paramInt1 + " to " + paramInt2);
      onCreate(paramSQLiteDatabase);
    }
    
    public final void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      super.onOpen(paramSQLiteDatabase);
      String str = a(paramSQLiteDatabase, "settings");
      if (str != null)
      {
        a(paramSQLiteDatabase, str, "settings", "status_muted", "INTEGER");
        a(paramSQLiteDatabase, str, "settings", "pinned", "BOOLEAN");
        a(paramSQLiteDatabase, str, "settings", "pinned_time", "INTEGER");
      }
    }
    
    public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
      Log.i("chat-settings-store/upgrade from " + paramInt1 + " to " + paramInt2);
      Log.e("chat-settings-store/upgrade unknown old version");
      onCreate(paramSQLiteDatabase);
    }
  }
  
  static final class c
    implements BaseColumns
  {
    public static final String[] a = { "jid", "mute_end", "muted_notifications", "use_custom_notifications", "message_tone", "message_vibrate", "message_popup", "message_light", "call_tone", "call_vibrate", "status_muted", "pinned", "pinned_time" };
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */