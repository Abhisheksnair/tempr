package com.whatsapp.emoji.search;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.whatsapp.atv;
import com.whatsapp.aus;
import com.whatsapp.emoji.h;
import com.whatsapp.os;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.be;
import java.lang.invoke.LambdaForm.Hidden;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  private static List<com.whatsapp.emoji.a> c = Arrays.asList(new com.whatsapp.emoji.a[] { new com.whatsapp.emoji.a(new int[] { 128514 }), new com.whatsapp.emoji.a(new int[] { 128525 }), new com.whatsapp.emoji.a(new int[] { 128536 }), new com.whatsapp.emoji.a(new int[] { 129315 }), new com.whatsapp.emoji.a(new int[] { 128512 }), new com.whatsapp.emoji.a(new int[] { 10084, 65039 }), new com.whatsapp.emoji.a(new int[] { 128521 }), new com.whatsapp.emoji.a(new int[] { 128522 }), new com.whatsapp.emoji.a(new int[] { 129300 }), new com.whatsapp.emoji.a(new int[] { 128557 }), new com.whatsapp.emoji.a(new int[] { 128513 }), new com.whatsapp.emoji.a(new int[] { 128540 }), new com.whatsapp.emoji.a(new int[] { 128079 }), new com.whatsapp.emoji.a(new int[] { 128526 }), new com.whatsapp.emoji.a(new int[] { 128077 }), new com.whatsapp.emoji.a(new int[] { 128556 }), new com.whatsapp.emoji.a(new int[] { 128518 }), new com.whatsapp.emoji.a(new int[] { 128578 }), new com.whatsapp.emoji.a(new int[] { 128519 }), new com.whatsapp.emoji.a(new int[] { 128544 }), new com.whatsapp.emoji.a(new int[] { 128517 }), new com.whatsapp.emoji.a(new int[] { 9786, 65039 }), new com.whatsapp.emoji.a(new int[] { 129303 }), new com.whatsapp.emoji.a(new int[] { 128516 }), new com.whatsapp.emoji.a(new int[] { 128530 }), new com.whatsapp.emoji.a(new int[] { 128515 }), new com.whatsapp.emoji.a(new int[] { 128527 }), new com.whatsapp.emoji.a(new int[] { 128524 }), new com.whatsapp.emoji.a(new int[] { 128076 }), new com.whatsapp.emoji.a(new int[] { 128541 }), new com.whatsapp.emoji.a(new int[] { 128579 }), new com.whatsapp.emoji.a(new int[] { 128523 }), new com.whatsapp.emoji.a(new int[] { 127874 }), new com.whatsapp.emoji.a(new int[] { 128545 }), new com.whatsapp.emoji.a(new int[] { 128561 }), new com.whatsapp.emoji.a(new int[] { 128591 }), new com.whatsapp.emoji.a(new int[] { 128532 }), new com.whatsapp.emoji.a(new int[] { 128546 }), new com.whatsapp.emoji.a(new int[] { 128563 }), new com.whatsapp.emoji.a(new int[] { 128542 }), new com.whatsapp.emoji.a(new int[] { 129316 }), new com.whatsapp.emoji.a(new int[] { 128074 }), new com.whatsapp.emoji.a(new int[] { 128539 }), new com.whatsapp.emoji.a(new int[] { 128538 }), new com.whatsapp.emoji.a(new int[] { 128580 }), new com.whatsapp.emoji.a(new int[] { 128149 }), new com.whatsapp.emoji.a(new int[] { 9996, 65039 }), new com.whatsapp.emoji.a(new int[] { 128170 }), new com.whatsapp.emoji.a(new int[] { 128158 }), new com.whatsapp.emoji.a(new int[] { 127801 }) });
  private static String d = "https://static.whatsapp.net/emoji?lg=";
  private static long e = 86400000L;
  private static volatile a n;
  b a;
  AsyncTask b;
  private final h f;
  private final aus g;
  private final atv h;
  private final r i;
  private HashMap<String, List<com.whatsapp.emoji.a>> j;
  private HashSet<com.whatsapp.emoji.a> k;
  private HashMap<String, List<com.whatsapp.emoji.a>> l;
  private HashSet<com.whatsapp.emoji.a> m;
  
  private a(Context paramContext, h paramh, aus paramaus, atv paramatv)
  {
    this.f = paramh;
    this.g = paramaus;
    this.h = paramatv;
    this.i = new r(paramContext);
  }
  
  /* Error */
  private b a(c paramc, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 141	com/whatsapp/emoji/search/a:d	()I
    //   6: ifne +27 -> 33
    //   9: aload_1
    //   10: getfield 143	com/whatsapp/emoji/search/a$c:c	J
    //   13: lconst_0
    //   14: lcmp
    //   15: ifle +11 -> 26
    //   18: getstatic 145	com/whatsapp/emoji/search/a$b:b	Lcom/whatsapp/emoji/search/a$b;
    //   21: astore_1
    //   22: aload_0
    //   23: monitorexit
    //   24: aload_1
    //   25: areturn
    //   26: getstatic 147	com/whatsapp/emoji/search/a$b:a	Lcom/whatsapp/emoji/search/a$b;
    //   29: astore_1
    //   30: goto -8 -> 22
    //   33: aload_2
    //   34: ifnull +43 -> 77
    //   37: aload_2
    //   38: aload_1
    //   39: getfield 148	com/whatsapp/emoji/search/a$c:d	Ljava/lang/String;
    //   42: invokevirtual 154	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   45: ifeq +32 -> 77
    //   48: aload_1
    //   49: getfield 143	com/whatsapp/emoji/search/a$c:c	J
    //   52: getstatic 119	com/whatsapp/emoji/search/a:e	J
    //   55: ladd
    //   56: invokestatic 160	java/lang/System:currentTimeMillis	()J
    //   59: lcmp
    //   60: ifge +10 -> 70
    //   63: getstatic 162	com/whatsapp/emoji/search/a$b:d	Lcom/whatsapp/emoji/search/a$b;
    //   66: astore_1
    //   67: goto -45 -> 22
    //   70: getstatic 164	com/whatsapp/emoji/search/a$b:e	Lcom/whatsapp/emoji/search/a$b;
    //   73: astore_1
    //   74: goto -52 -> 22
    //   77: getstatic 166	com/whatsapp/emoji/search/a$b:c	Lcom/whatsapp/emoji/search/a$b;
    //   80: astore_1
    //   81: goto -59 -> 22
    //   84: astore_1
    //   85: aload_0
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	a
    //   0	89	1	paramc	c
    //   0	89	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	22	84	finally
    //   26	30	84	finally
    //   37	67	84	finally
    //   70	74	84	finally
    //   77	81	84	finally
  }
  
  public static a a()
  {
    try
    {
      if (n == null) {
        n = new a(u.a(), h.a(), aus.a(), atv.a());
      }
      a locala = n;
      return locala;
    }
    finally {}
  }
  
  /* Error */
  private HashMap<String, List<com.whatsapp.emoji.a>> a(List<com.whatsapp.emoji.a> paramList, Set<com.whatsapp.emoji.a> paramSet)
  {
    // Byte code:
    //   0: new 201	java/util/HashMap
    //   3: dup
    //   4: invokespecial 202	java/util/HashMap:<init>	()V
    //   7: astore 12
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore 8
    //   15: aconst_null
    //   16: astore 7
    //   18: aconst_null
    //   19: astore 5
    //   21: aconst_null
    //   22: astore 10
    //   24: aconst_null
    //   25: astore 9
    //   27: aconst_null
    //   28: astore 6
    //   30: aload_0
    //   31: getfield 136	com/whatsapp/emoji/search/a:i	Lcom/whatsapp/emoji/search/r;
    //   34: astore 11
    //   36: aload 11
    //   38: monitorenter
    //   39: aload_0
    //   40: getfield 136	com/whatsapp/emoji/search/a:i	Lcom/whatsapp/emoji/search/r;
    //   43: invokevirtual 206	com/whatsapp/emoji/search/r:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   46: astore_3
    //   47: aload 10
    //   49: astore 4
    //   51: aload 9
    //   53: astore 5
    //   55: aload_1
    //   56: invokeinterface 212 1 0
    //   61: astore 7
    //   63: aload 6
    //   65: astore_1
    //   66: aload_1
    //   67: astore 4
    //   69: aload_1
    //   70: astore 5
    //   72: aload 7
    //   74: invokeinterface 218 1 0
    //   79: ifeq +327 -> 406
    //   82: aload_1
    //   83: astore 4
    //   85: aload_1
    //   86: astore 5
    //   88: aload 7
    //   90: invokeinterface 222 1 0
    //   95: checkcast 51	com/whatsapp/emoji/a
    //   98: astore 6
    //   100: aload_1
    //   101: astore 4
    //   103: aload_1
    //   104: astore 5
    //   106: aload_2
    //   107: aload 6
    //   109: invokeinterface 227 2 0
    //   114: ifne +289 -> 403
    //   117: aload_1
    //   118: astore 4
    //   120: aload_1
    //   121: astore 5
    //   123: new 150	java/lang/String
    //   126: dup
    //   127: aload 6
    //   129: getfield 230	com/whatsapp/emoji/a:a	[I
    //   132: iconst_0
    //   133: aload 6
    //   135: getfield 230	com/whatsapp/emoji/a:a	[I
    //   138: arraylength
    //   139: invokespecial 233	java/lang/String:<init>	([III)V
    //   142: astore 9
    //   144: aload_1
    //   145: astore 4
    //   147: aload_1
    //   148: astore 5
    //   150: new 235	java/util/ArrayList
    //   153: dup
    //   154: invokespecial 236	java/util/ArrayList:<init>	()V
    //   157: astore 8
    //   159: aload_1
    //   160: astore 4
    //   162: aload_1
    //   163: astore 5
    //   165: aload_3
    //   166: ldc -18
    //   168: iconst_1
    //   169: anewarray 150	java/lang/String
    //   172: dup
    //   173: iconst_0
    //   174: ldc -16
    //   176: aastore
    //   177: ldc -14
    //   179: iconst_2
    //   180: anewarray 150	java/lang/String
    //   183: dup
    //   184: iconst_0
    //   185: ldc -12
    //   187: aastore
    //   188: dup
    //   189: iconst_1
    //   190: aload 9
    //   192: aastore
    //   193: aconst_null
    //   194: aconst_null
    //   195: aconst_null
    //   196: invokevirtual 250	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   199: astore_1
    //   200: aload_1
    //   201: ifnull +76 -> 277
    //   204: aload_1
    //   205: invokeinterface 255 1 0
    //   210: ifeq +67 -> 277
    //   213: aload 8
    //   215: aload_1
    //   216: iconst_0
    //   217: invokeinterface 259 2 0
    //   222: invokeinterface 262 2 0
    //   227: pop
    //   228: goto -24 -> 204
    //   231: astore 4
    //   233: aload_1
    //   234: astore_2
    //   235: aload_3
    //   236: astore_1
    //   237: aload 4
    //   239: astore_3
    //   240: aload_1
    //   241: astore 4
    //   243: aload_2
    //   244: astore 5
    //   246: ldc_w 264
    //   249: aload_3
    //   250: invokestatic 269	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   253: aload_2
    //   254: ifnull +9 -> 263
    //   257: aload_2
    //   258: invokeinterface 272 1 0
    //   263: aload_1
    //   264: ifnull +7 -> 271
    //   267: aload_1
    //   268: invokevirtual 273	android/database/sqlite/SQLiteDatabase:close	()V
    //   271: aload 11
    //   273: monitorexit
    //   274: aload 12
    //   276: areturn
    //   277: aload_2
    //   278: aload 6
    //   280: invokeinterface 274 2 0
    //   285: pop
    //   286: aload 8
    //   288: invokeinterface 212 1 0
    //   293: astore 4
    //   295: aload 4
    //   297: invokeinterface 218 1 0
    //   302: ifeq +163 -> 465
    //   305: aload 4
    //   307: invokeinterface 222 1 0
    //   312: checkcast 150	java/lang/String
    //   315: astore 5
    //   317: aload 12
    //   319: aload 5
    //   321: invokevirtual 277	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   324: ifne +18 -> 342
    //   327: aload 12
    //   329: aload 5
    //   331: new 235	java/util/ArrayList
    //   334: dup
    //   335: invokespecial 236	java/util/ArrayList:<init>	()V
    //   338: invokevirtual 281	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   341: pop
    //   342: aload 12
    //   344: aload 5
    //   346: invokevirtual 285	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   349: checkcast 208	java/util/List
    //   352: aload 6
    //   354: invokeinterface 262 2 0
    //   359: pop
    //   360: goto -65 -> 295
    //   363: astore 4
    //   365: aload_3
    //   366: astore_2
    //   367: aload 4
    //   369: astore_3
    //   370: aload_1
    //   371: astore 4
    //   373: aload_3
    //   374: astore_1
    //   375: aload 4
    //   377: ifnull +10 -> 387
    //   380: aload 4
    //   382: invokeinterface 272 1 0
    //   387: aload_2
    //   388: ifnull +7 -> 395
    //   391: aload_2
    //   392: invokevirtual 273	android/database/sqlite/SQLiteDatabase:close	()V
    //   395: aload_1
    //   396: athrow
    //   397: astore_1
    //   398: aload 11
    //   400: monitorexit
    //   401: aload_1
    //   402: athrow
    //   403: goto -337 -> 66
    //   406: aload_1
    //   407: ifnull +9 -> 416
    //   410: aload_1
    //   411: invokeinterface 272 1 0
    //   416: aload_3
    //   417: ifnull -146 -> 271
    //   420: aload_3
    //   421: invokevirtual 273	android/database/sqlite/SQLiteDatabase:close	()V
    //   424: goto -153 -> 271
    //   427: astore_1
    //   428: aload 4
    //   430: astore_2
    //   431: aload 5
    //   433: astore 4
    //   435: goto -60 -> 375
    //   438: astore_1
    //   439: aload_3
    //   440: astore_2
    //   441: goto -66 -> 375
    //   444: astore_3
    //   445: aload 8
    //   447: astore_1
    //   448: aload 7
    //   450: astore_2
    //   451: goto -211 -> 240
    //   454: astore_2
    //   455: aload_3
    //   456: astore_1
    //   457: aload_2
    //   458: astore_3
    //   459: aload 5
    //   461: astore_2
    //   462: goto -222 -> 240
    //   465: goto -62 -> 403
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	a
    //   0	468	1	paramList	List<com.whatsapp.emoji.a>
    //   0	468	2	paramSet	Set<com.whatsapp.emoji.a>
    //   46	394	3	localObject1	Object
    //   444	12	3	localSQLiteException1	android.database.sqlite.SQLiteException
    //   458	1	3	localSet	Set<com.whatsapp.emoji.a>
    //   10	151	4	localObject2	Object
    //   231	7	4	localSQLiteException2	android.database.sqlite.SQLiteException
    //   241	65	4	localObject3	Object
    //   363	5	4	localObject4	Object
    //   371	63	4	localObject5	Object
    //   19	441	5	localObject6	Object
    //   28	325	6	locala	com.whatsapp.emoji.a
    //   16	433	7	localIterator	Iterator
    //   13	433	8	localArrayList	ArrayList
    //   25	166	9	str	String
    //   22	26	10	localObject7	Object
    //   34	365	11	localr	r
    //   7	336	12	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   204	228	231	android/database/sqlite/SQLiteException
    //   277	295	231	android/database/sqlite/SQLiteException
    //   295	342	231	android/database/sqlite/SQLiteException
    //   342	360	231	android/database/sqlite/SQLiteException
    //   204	228	363	finally
    //   277	295	363	finally
    //   295	342	363	finally
    //   342	360	363	finally
    //   257	263	397	finally
    //   267	271	397	finally
    //   271	274	397	finally
    //   380	387	397	finally
    //   391	395	397	finally
    //   395	397	397	finally
    //   398	401	397	finally
    //   410	416	397	finally
    //   420	424	397	finally
    //   39	47	427	finally
    //   246	253	427	finally
    //   55	63	438	finally
    //   72	82	438	finally
    //   88	100	438	finally
    //   106	117	438	finally
    //   123	144	438	finally
    //   150	159	438	finally
    //   165	200	438	finally
    //   39	47	444	android/database/sqlite/SQLiteException
    //   55	63	454	android/database/sqlite/SQLiteException
    //   72	82	454	android/database/sqlite/SQLiteException
    //   88	100	454	android/database/sqlite/SQLiteException
    //   106	117	454	android/database/sqlite/SQLiteException
    //   123	144	454	android/database/sqlite/SQLiteException
    //   150	159	454	android/database/sqlite/SQLiteException
    //   165	200	454	android/database/sqlite/SQLiteException
  }
  
  private LinkedHashSet<com.whatsapp.emoji.a> a(String paramString, int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (this.a == b.a) {
      throw new IllegalStateException("emoji dictionary is not prepared yet, state=" + this.a);
    }
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    SQLiteDatabase localSQLiteDatabase;
    synchronized (this.i)
    {
      localSQLiteDatabase = this.i.getReadableDatabase();
      localObject1 = localObject2;
      for (;;)
      {
        try
        {
          StringBuilder localStringBuilder = new StringBuilder("SELECT DISTINCT symbol FROM emoji_search_tag WHERE type=? AND tag");
          if (!paramBoolean) {
            break label259;
          }
          str = " = ";
          localObject1 = localObject2;
          str = str + "? ORDER BY _id ASC LIMIT ?";
          localObject1 = localObject2;
          localStringBuilder = new StringBuilder().append(paramString);
          if (!paramBoolean) {
            break label267;
          }
          paramString = "";
          localObject1 = localObject2;
          paramString = localSQLiteDatabase.rawQuery(str, new String[] { "1", paramString, String.valueOf(paramInt) });
          if (paramString == null) {
            break;
          }
          localObject1 = paramString;
          if (!paramString.moveToNext()) {
            break;
          }
          localObject1 = paramString;
          localLinkedHashSet.add(new com.whatsapp.emoji.a(a(paramString.getString(0))));
          continue;
          if (localObject1 == null) {}
        }
        finally {}
        try
        {
          ((Cursor)localObject1).close();
          if (localSQLiteDatabase != null) {
            localSQLiteDatabase.close();
          }
          throw paramString;
        }
        finally {}
        label259:
        String str = " LIKE ";
        continue;
        label267:
        paramString = "%";
      }
      if (paramString != null) {
        paramString.close();
      }
      if (localSQLiteDatabase != null) {
        localSQLiteDatabase.close();
      }
      return localLinkedHashSet;
    }
  }
  
  private static LinkedHashSet<com.whatsapp.emoji.a> a(String paramString, HashSet<com.whatsapp.emoji.a> paramHashSet, HashMap<String, List<com.whatsapp.emoji.a>> paramHashMap)
  {
    HashSet localHashSet = new HashSet();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      if ((paramString.equals(localEntry.getKey())) || (paramString.regionMatches(0, (String)localEntry.getKey(), 0, paramString.length()))) {
        localHashSet.addAll((Collection)localEntry.getValue());
      }
    }
    paramString = new LinkedHashSet();
    if (!localHashSet.isEmpty())
    {
      paramHashSet = paramHashSet.iterator();
      while (paramHashSet.hasNext())
      {
        paramHashMap = (com.whatsapp.emoji.a)paramHashSet.next();
        if (localHashSet.contains(paramHashMap)) {
          paramString.add(paramHashMap);
        }
      }
    }
    return paramString;
  }
  
  private static Set<String> a(com.google.a.b.a parama)
  {
    HashSet localHashSet = new HashSet();
    parama.a();
    while (parama.e()) {
      localHashSet.add(com.whatsapp.data.q.a(parama.g()));
    }
    parama.b();
    return localHashSet;
  }
  
  /* Error */
  private static javax.net.ssl.HttpsURLConnection a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 292	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   7: getstatic 115	com/whatsapp/emoji/search/a:d	Ljava/lang/String;
    //   10: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: aload_1
    //   14: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: invokestatic 401	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   23: astore_1
    //   24: new 403	java/net/URL
    //   27: dup
    //   28: aload_1
    //   29: invokevirtual 404	android/net/Uri:toString	()Ljava/lang/String;
    //   32: invokespecial 405	java/net/URL:<init>	(Ljava/lang/String;)V
    //   35: astore_1
    //   36: aload_1
    //   37: invokevirtual 409	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   40: astore_1
    //   41: aload_1
    //   42: instanceof 411
    //   45: ifeq +132 -> 177
    //   48: aload_1
    //   49: checkcast 411	javax/net/ssl/HttpsURLConnection
    //   52: astore_1
    //   53: aload_1
    //   54: invokestatic 416	com/whatsapp/messaging/ar:a	()Lcom/whatsapp/messaging/ar;
    //   57: invokevirtual 420	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   60: aload_1
    //   61: sipush 15000
    //   64: invokevirtual 424	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   67: aload_1
    //   68: sipush 30000
    //   71: invokevirtual 427	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   74: aload_0
    //   75: ifnull +11 -> 86
    //   78: aload_1
    //   79: ldc_w 429
    //   82: aload_0
    //   83: invokevirtual 433	javax/net/ssl/HttpsURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload_1
    //   87: ldc_w 435
    //   90: invokestatic 439	com/whatsapp/ape:a	()Ljava/lang/String;
    //   93: invokevirtual 442	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_1
    //   97: ldc_w 444
    //   100: ldc_w 446
    //   103: invokevirtual 442	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload_1
    //   107: ldc_w 448
    //   110: ldc_w 450
    //   113: invokevirtual 442	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_1
    //   117: invokevirtual 453	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   120: istore_2
    //   121: aload_1
    //   122: astore_0
    //   123: iload_2
    //   124: sipush 200
    //   127: if_icmpeq +38 -> 165
    //   130: aload_1
    //   131: astore_0
    //   132: iload_2
    //   133: sipush 304
    //   136: if_icmpeq +29 -> 165
    //   139: new 292	java/lang/StringBuilder
    //   142: dup
    //   143: ldc_w 455
    //   146: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   149: iload_2
    //   150: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 461	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   159: aload_1
    //   160: invokevirtual 464	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   163: aconst_null
    //   164: astore_0
    //   165: aload_0
    //   166: areturn
    //   167: astore_0
    //   168: ldc_w 466
    //   171: aload_0
    //   172: invokestatic 269	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   175: aload_0
    //   176: athrow
    //   177: new 395	java/io/IOException
    //   180: dup
    //   181: ldc_w 468
    //   184: invokespecial 469	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   187: athrow
    //   188: astore_0
    //   189: new 395	java/io/IOException
    //   192: dup
    //   193: ldc_w 468
    //   196: invokespecial 469	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   199: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	paramString1	String
    //   0	200	1	paramString2	String
    //   120	30	2	i1	int
    // Exception table:
    //   from	to	target	type
    //   24	36	167	java/net/MalformedURLException
    //   36	53	188	java/io/IOException
    //   177	188	188	java/io/IOException
  }
  
  private void a(String paramString, Set<String> paramSet)
  {
    SQLiteDatabase localSQLiteDatabase = this.i.getWritableDatabase();
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("type", Integer.valueOf(1));
      localContentValues.put("symbol", paramString);
      localContentValues.put("tag", str);
      localSQLiteDatabase.replace("emoji_search_tag", null, localContentValues);
    }
  }
  
  /* Error */
  private boolean a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 136	com/whatsapp/emoji/search/a:i	Lcom/whatsapp/emoji/search/r;
    //   11: astore 7
    //   13: aload 7
    //   15: monitorenter
    //   16: new 376	com/google/a/b/a
    //   19: dup
    //   20: new 539	java/io/InputStreamReader
    //   23: dup
    //   24: aload_1
    //   25: invokespecial 542	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   28: invokespecial 545	com/google/a/b/a:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 136	com/whatsapp/emoji/search/a:i	Lcom/whatsapp/emoji/search/r;
    //   36: invokevirtual 514	com/whatsapp/emoji/search/r:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   39: astore 4
    //   41: aload 4
    //   43: invokevirtual 548	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   46: aload_0
    //   47: getfield 136	com/whatsapp/emoji/search/a:i	Lcom/whatsapp/emoji/search/r;
    //   50: invokevirtual 514	com/whatsapp/emoji/search/r:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   53: ldc -18
    //   55: ldc_w 550
    //   58: iconst_1
    //   59: anewarray 150	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: ldc -12
    //   66: aastore
    //   67: invokevirtual 554	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   70: istore_2
    //   71: new 292	java/lang/StringBuilder
    //   74: dup
    //   75: ldc_w 556
    //   78: invokespecial 297	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   81: iload_2
    //   82: invokevirtual 458	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 558	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   91: aload_1
    //   92: invokevirtual 560	com/google/a/b/a:c	()V
    //   95: aload_1
    //   96: invokevirtual 380	com/google/a/b/a:e	()Z
    //   99: ifeq +49 -> 148
    //   102: aload_0
    //   103: aload_1
    //   104: invokevirtual 562	com/google/a/b/a:f	()Ljava/lang/String;
    //   107: aload_1
    //   108: invokestatic 564	com/whatsapp/emoji/search/a:a	(Lcom/google/a/b/a;)Ljava/util/Set;
    //   111: invokespecial 566	com/whatsapp/emoji/search/a:a	(Ljava/lang/String;Ljava/util/Set;)V
    //   114: goto -19 -> 95
    //   117: astore 5
    //   119: ldc_w 568
    //   122: aload 5
    //   124: invokestatic 269	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   127: aload_1
    //   128: invokevirtual 569	com/google/a/b/a:close	()V
    //   131: aload 4
    //   133: ifnull +8 -> 141
    //   136: aload 4
    //   138: invokevirtual 572	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   141: aload 7
    //   143: monitorexit
    //   144: aload_0
    //   145: monitorexit
    //   146: iload_3
    //   147: ireturn
    //   148: aload_1
    //   149: invokevirtual 574	com/google/a/b/a:d	()V
    //   152: aload 4
    //   154: invokevirtual 577	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   157: aload_1
    //   158: invokevirtual 569	com/google/a/b/a:close	()V
    //   161: aload 4
    //   163: ifnull +8 -> 171
    //   166: aload 4
    //   168: invokevirtual 572	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   171: aload 7
    //   173: monitorexit
    //   174: iconst_1
    //   175: istore_3
    //   176: goto -32 -> 144
    //   179: astore_1
    //   180: aload_1
    //   181: invokevirtual 580	java/io/IOException:printStackTrace	()V
    //   184: goto -23 -> 161
    //   187: astore_1
    //   188: aload 7
    //   190: monitorexit
    //   191: aload_1
    //   192: athrow
    //   193: astore_1
    //   194: aload_0
    //   195: monitorexit
    //   196: aload_1
    //   197: athrow
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 580	java/io/IOException:printStackTrace	()V
    //   203: goto -72 -> 131
    //   206: astore_1
    //   207: aconst_null
    //   208: astore 4
    //   210: aload 5
    //   212: ifnull +8 -> 220
    //   215: aload 5
    //   217: invokevirtual 569	com/google/a/b/a:close	()V
    //   220: aload 4
    //   222: ifnull +8 -> 230
    //   225: aload 4
    //   227: invokevirtual 572	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   230: aload_1
    //   231: athrow
    //   232: astore 5
    //   234: aload 5
    //   236: invokevirtual 580	java/io/IOException:printStackTrace	()V
    //   239: goto -19 -> 220
    //   242: astore 6
    //   244: aconst_null
    //   245: astore 4
    //   247: aload_1
    //   248: astore 5
    //   250: aload 6
    //   252: astore_1
    //   253: goto -43 -> 210
    //   256: astore 6
    //   258: aload_1
    //   259: astore 5
    //   261: aload 6
    //   263: astore_1
    //   264: goto -54 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	267	0	this	a
    //   0	267	1	paramInputStream	java.io.InputStream
    //   70	12	2	i1	int
    //   4	172	3	bool	boolean
    //   39	207	4	localSQLiteDatabase	SQLiteDatabase
    //   1	1	5	localObject1	Object
    //   117	99	5	localIOException1	java.io.IOException
    //   232	3	5	localIOException2	java.io.IOException
    //   248	12	5	localInputStream	java.io.InputStream
    //   242	9	6	localObject2	Object
    //   256	6	6	localObject3	Object
    //   11	178	7	localr	r
    // Exception table:
    //   from	to	target	type
    //   91	95	117	java/io/IOException
    //   95	114	117	java/io/IOException
    //   148	157	117	java/io/IOException
    //   157	161	179	java/io/IOException
    //   127	131	187	finally
    //   136	141	187	finally
    //   141	144	187	finally
    //   157	161	187	finally
    //   166	171	187	finally
    //   171	174	187	finally
    //   180	184	187	finally
    //   188	191	187	finally
    //   199	203	187	finally
    //   215	220	187	finally
    //   225	230	187	finally
    //   230	232	187	finally
    //   234	239	187	finally
    //   7	16	193	finally
    //   191	193	193	finally
    //   127	131	198	java/io/IOException
    //   16	32	206	finally
    //   215	220	232	java/io/IOException
    //   32	41	242	finally
    //   41	91	256	finally
    //   91	95	256	finally
    //   95	114	256	finally
    //   119	127	256	finally
    //   148	157	256	finally
  }
  
  private static int[] a(String paramString)
  {
    int i3 = 0;
    int[] arrayOfInt = new int[paramString.length()];
    int i2 = 0;
    int i4;
    for (int i1 = 0; i1 < paramString.length(); i1 = i4 + i1)
    {
      int i5 = Character.codePointAt(paramString, i1);
      i4 = Character.charCount(i5);
      arrayOfInt[i2] = i5;
      i2 += 1;
    }
    paramString = new int[i2];
    i1 = i3;
    while (i1 < paramString.length)
    {
      paramString[i1] = arrayOfInt[i1];
      i1 += 1;
    }
    return paramString;
  }
  
  /* Error */
  private c b(c paramc, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_0
    //   10: getfield 136	com/whatsapp/emoji/search/a:i	Lcom/whatsapp/emoji/search/r;
    //   13: astore 8
    //   15: aload 8
    //   17: monitorenter
    //   18: aload_1
    //   19: getfield 481	com/whatsapp/emoji/search/a$c:b	Ljava/lang/String;
    //   22: aload_2
    //   23: invokestatic 593	com/whatsapp/emoji/search/a:a	(Ljava/lang/String;Ljava/lang/String;)Ljavax/net/ssl/HttpsURLConnection;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnonnull +58 -> 86
    //   31: aload_3
    //   32: astore 5
    //   34: aload 6
    //   36: astore 4
    //   38: ldc_w 595
    //   41: invokestatic 597	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   44: aload_3
    //   45: astore 5
    //   47: aload 6
    //   49: astore 4
    //   51: new 18	com/whatsapp/emoji/search/a$c
    //   54: dup
    //   55: getstatic 145	com/whatsapp/emoji/search/a$b:b	Lcom/whatsapp/emoji/search/a$b;
    //   58: aload_1
    //   59: getfield 481	com/whatsapp/emoji/search/a$c:b	Ljava/lang/String;
    //   62: invokestatic 160	java/lang/System:currentTimeMillis	()J
    //   65: aload_1
    //   66: getfield 148	com/whatsapp/emoji/search/a$c:d	Ljava/lang/String;
    //   69: invokespecial 600	com/whatsapp/emoji/search/a$c:<init>	(Lcom/whatsapp/emoji/search/a$b;Ljava/lang/String;JLjava/lang/String;)V
    //   72: astore_2
    //   73: aload_3
    //   74: ifnull +7 -> 81
    //   77: aload_3
    //   78: invokevirtual 464	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   81: aload 8
    //   83: monitorexit
    //   84: aload_2
    //   85: areturn
    //   86: aload_3
    //   87: astore 5
    //   89: aload 6
    //   91: astore 4
    //   93: aload_3
    //   94: invokevirtual 453	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   97: sipush 304
    //   100: if_icmpne +61 -> 161
    //   103: aload_3
    //   104: astore 5
    //   106: aload 6
    //   108: astore 4
    //   110: ldc_w 602
    //   113: invokestatic 604	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   116: aload_3
    //   117: astore 5
    //   119: aload 6
    //   121: astore 4
    //   123: new 18	com/whatsapp/emoji/search/a$c
    //   126: dup
    //   127: getstatic 164	com/whatsapp/emoji/search/a$b:e	Lcom/whatsapp/emoji/search/a$b;
    //   130: aload_1
    //   131: getfield 481	com/whatsapp/emoji/search/a$c:b	Ljava/lang/String;
    //   134: invokestatic 160	java/lang/System:currentTimeMillis	()J
    //   137: aload_2
    //   138: invokespecial 600	com/whatsapp/emoji/search/a$c:<init>	(Lcom/whatsapp/emoji/search/a$b;Ljava/lang/String;JLjava/lang/String;)V
    //   141: astore_2
    //   142: aload_3
    //   143: ifnull +7 -> 150
    //   146: aload_3
    //   147: invokevirtual 464	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   150: aload 8
    //   152: monitorexit
    //   153: aload_2
    //   154: areturn
    //   155: astore_1
    //   156: aload 8
    //   158: monitorexit
    //   159: aload_1
    //   160: athrow
    //   161: aload_3
    //   162: astore 5
    //   164: aload 6
    //   166: astore 4
    //   168: new 606	com/whatsapp/Statistics$a
    //   171: dup
    //   172: aload_3
    //   173: invokevirtual 610	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   176: iconst_0
    //   177: invokespecial 613	com/whatsapp/Statistics$a:<init>	(Ljava/io/InputStream;I)V
    //   180: astore 6
    //   182: aload_0
    //   183: aload 6
    //   185: invokespecial 615	com/whatsapp/emoji/search/a:a	(Ljava/io/InputStream;)Z
    //   188: ifeq +114 -> 302
    //   191: aload_3
    //   192: invokevirtual 619	javax/net/ssl/HttpsURLConnection:getHeaderFields	()Ljava/util/Map;
    //   195: astore 4
    //   197: aload 4
    //   199: ldc_w 621
    //   202: invokeinterface 624 2 0
    //   207: ifeq +280 -> 487
    //   210: aload 4
    //   212: ldc_w 621
    //   215: invokeinterface 625 2 0
    //   220: checkcast 208	java/util/List
    //   223: invokeinterface 626 1 0
    //   228: ifne +259 -> 487
    //   231: aload 4
    //   233: ldc_w 621
    //   236: invokeinterface 625 2 0
    //   241: checkcast 208	java/util/List
    //   244: iconst_0
    //   245: invokeinterface 629 2 0
    //   250: checkcast 150	java/lang/String
    //   253: astore 4
    //   255: aload_0
    //   256: invokespecial 631	com/whatsapp/emoji/search/a:e	()V
    //   259: new 18	com/whatsapp/emoji/search/a$c
    //   262: dup
    //   263: getstatic 164	com/whatsapp/emoji/search/a$b:e	Lcom/whatsapp/emoji/search/a$b;
    //   266: aload 4
    //   268: invokestatic 160	java/lang/System:currentTimeMillis	()J
    //   271: aload_2
    //   272: invokespecial 600	com/whatsapp/emoji/search/a$c:<init>	(Lcom/whatsapp/emoji/search/a$b;Ljava/lang/String;JLjava/lang/String;)V
    //   275: astore_2
    //   276: aload 6
    //   278: invokevirtual 634	java/io/InputStream:close	()V
    //   281: aload_3
    //   282: ifnull +7 -> 289
    //   285: aload_3
    //   286: invokevirtual 464	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   289: aload 8
    //   291: monitorexit
    //   292: aload_2
    //   293: areturn
    //   294: astore_1
    //   295: aload_1
    //   296: invokevirtual 580	java/io/IOException:printStackTrace	()V
    //   299: goto -18 -> 281
    //   302: new 18	com/whatsapp/emoji/search/a$c
    //   305: dup
    //   306: getstatic 145	com/whatsapp/emoji/search/a$b:b	Lcom/whatsapp/emoji/search/a$b;
    //   309: aload_1
    //   310: getfield 481	com/whatsapp/emoji/search/a$c:b	Ljava/lang/String;
    //   313: invokestatic 160	java/lang/System:currentTimeMillis	()J
    //   316: aload_1
    //   317: getfield 148	com/whatsapp/emoji/search/a$c:d	Ljava/lang/String;
    //   320: invokespecial 600	com/whatsapp/emoji/search/a$c:<init>	(Lcom/whatsapp/emoji/search/a$b;Ljava/lang/String;JLjava/lang/String;)V
    //   323: astore_2
    //   324: aload 6
    //   326: invokevirtual 634	java/io/InputStream:close	()V
    //   329: aload_3
    //   330: ifnull +7 -> 337
    //   333: aload_3
    //   334: invokevirtual 464	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   337: aload 8
    //   339: monitorexit
    //   340: aload_2
    //   341: areturn
    //   342: astore_1
    //   343: aload_1
    //   344: invokevirtual 580	java/io/IOException:printStackTrace	()V
    //   347: goto -18 -> 329
    //   350: astore_2
    //   351: aconst_null
    //   352: astore_3
    //   353: aload 7
    //   355: astore 6
    //   357: aload_3
    //   358: astore 5
    //   360: aload 6
    //   362: astore 4
    //   364: ldc_w 636
    //   367: aload_2
    //   368: invokestatic 269	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   371: aload_3
    //   372: astore 5
    //   374: aload 6
    //   376: astore 4
    //   378: new 18	com/whatsapp/emoji/search/a$c
    //   381: dup
    //   382: aconst_null
    //   383: aload_1
    //   384: getfield 481	com/whatsapp/emoji/search/a$c:b	Ljava/lang/String;
    //   387: invokestatic 160	java/lang/System:currentTimeMillis	()J
    //   390: aload_1
    //   391: getfield 148	com/whatsapp/emoji/search/a$c:d	Ljava/lang/String;
    //   394: invokespecial 600	com/whatsapp/emoji/search/a$c:<init>	(Lcom/whatsapp/emoji/search/a$b;Ljava/lang/String;JLjava/lang/String;)V
    //   397: astore_1
    //   398: aload 6
    //   400: ifnull +8 -> 408
    //   403: aload 6
    //   405: invokevirtual 634	java/io/InputStream:close	()V
    //   408: aload_3
    //   409: ifnull +7 -> 416
    //   412: aload_3
    //   413: invokevirtual 464	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   416: aload 8
    //   418: monitorexit
    //   419: aload_1
    //   420: areturn
    //   421: astore_2
    //   422: aload_2
    //   423: invokevirtual 580	java/io/IOException:printStackTrace	()V
    //   426: goto -18 -> 408
    //   429: astore_1
    //   430: aconst_null
    //   431: astore_3
    //   432: aload 4
    //   434: ifnull +8 -> 442
    //   437: aload 4
    //   439: invokevirtual 634	java/io/InputStream:close	()V
    //   442: aload_3
    //   443: ifnull +7 -> 450
    //   446: aload_3
    //   447: invokevirtual 464	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   450: aload_1
    //   451: athrow
    //   452: astore_2
    //   453: aload_2
    //   454: invokevirtual 580	java/io/IOException:printStackTrace	()V
    //   457: goto -15 -> 442
    //   460: astore_1
    //   461: aload 5
    //   463: astore_3
    //   464: goto -32 -> 432
    //   467: astore_1
    //   468: aload 6
    //   470: astore 4
    //   472: goto -40 -> 432
    //   475: astore_2
    //   476: aload 7
    //   478: astore 6
    //   480: goto -123 -> 357
    //   483: astore_2
    //   484: goto -127 -> 357
    //   487: aconst_null
    //   488: astore 4
    //   490: goto -235 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	this	a
    //   0	493	1	paramc	c
    //   0	493	2	paramString	String
    //   26	438	3	localObject1	Object
    //   1	488	4	localObject2	Object
    //   32	430	5	localObject3	Object
    //   4	475	6	localObject4	Object
    //   7	470	7	localObject5	Object
    //   13	404	8	localr	r
    // Exception table:
    //   from	to	target	type
    //   77	81	155	finally
    //   81	84	155	finally
    //   146	150	155	finally
    //   150	153	155	finally
    //   156	159	155	finally
    //   276	281	155	finally
    //   285	289	155	finally
    //   289	292	155	finally
    //   295	299	155	finally
    //   324	329	155	finally
    //   333	337	155	finally
    //   337	340	155	finally
    //   343	347	155	finally
    //   403	408	155	finally
    //   412	416	155	finally
    //   416	419	155	finally
    //   422	426	155	finally
    //   437	442	155	finally
    //   446	450	155	finally
    //   450	452	155	finally
    //   453	457	155	finally
    //   276	281	294	java/io/IOException
    //   324	329	342	java/io/IOException
    //   18	27	350	java/io/IOException
    //   403	408	421	java/io/IOException
    //   18	27	429	finally
    //   437	442	452	java/io/IOException
    //   38	44	460	finally
    //   51	73	460	finally
    //   93	103	460	finally
    //   110	116	460	finally
    //   123	142	460	finally
    //   168	182	460	finally
    //   364	371	460	finally
    //   378	398	460	finally
    //   182	255	467	finally
    //   255	276	467	finally
    //   302	324	467	finally
    //   38	44	475	java/io/IOException
    //   51	73	475	java/io/IOException
    //   93	103	475	java/io/IOException
    //   110	116	475	java/io/IOException
    //   123	142	475	java/io/IOException
    //   168	182	475	java/io/IOException
    //   182	255	483	java/io/IOException
    //   255	276	483	java/io/IOException
    //   302	324	483	java/io/IOException
  }
  
  private c c()
  {
    Object localObject = this.h.a.getString("emoji_dictionary_info", null);
    if (localObject == null) {
      return new c();
    }
    try
    {
      c localc = new c();
      localObject = new JSONObject((String)localObject);
      localc.b = ((JSONObject)localObject).optString("request_etag", null);
      localc.c = ((JSONObject)localObject).optLong("last_fetch_attempt_time", 0L);
      localc.d = ((JSONObject)localObject).optString("language", null);
      return localc;
    }
    catch (JSONException localJSONException)
    {
      Log.a("emojidictionaryloader/load/fail", localJSONException);
    }
    return new c();
  }
  
  private int d()
  {
    Cursor localCursor2 = null;
    Cursor localCursor1 = null;
    int i2 = 0;
    SQLiteDatabase localSQLiteDatabase;
    synchronized (this.i)
    {
      localSQLiteDatabase = this.i.getReadableDatabase();
      localCursor1 = localCursor2;
      for (;;)
      {
        try
        {
          localCursor2 = localSQLiteDatabase.rawQuery("SELECT count(*) FROM emoji_search_tag WHERE type=?", new String[] { "1" });
          i1 = i2;
          if (localCursor2 != null)
          {
            i1 = i2;
            localCursor1 = localCursor2;
            if (localCursor2.moveToNext())
            {
              localCursor1 = localCursor2;
              i1 = localCursor2.getInt(0);
            }
          }
          if (localCursor2 == null) {}
        }
        finally
        {
          int i1;
          continue;
        }
        try
        {
          localCursor2.close();
          if (localSQLiteDatabase != null) {
            localSQLiteDatabase.close();
          }
          return i1;
        }
        finally {}
      }
      if (localCursor1 != null) {
        localCursor1.close();
      }
      if (localSQLiteDatabase != null) {
        localSQLiteDatabase.close();
      }
      throw localCursor2;
    }
  }
  
  private void e()
  {
    try
    {
      this.j = null;
      this.k = null;
      this.l = null;
      this.m = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void f()
  {
    if (this.j == null)
    {
      this.j = new HashMap();
      this.k = new HashSet();
    }
    Object localObject2 = this.f.c();
    Object localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(new com.whatsapp.emoji.a((int[])((Iterator)localObject2).next()));
    }
    localObject1 = a((List)localObject1, this.k);
    this.j.putAll((Map)localObject1);
  }
  
  final List<com.whatsapp.emoji.a> a(String paramString, int paramInt)
  {
    ArrayList localArrayList;
    try
    {
      localArrayList = be.c(com.whatsapp.data.q.a(paramString));
      localObject = new LinkedHashSet();
      if (TextUtils.isEmpty(paramString))
      {
        paramString = this.f.c().iterator();
        while (paramString.hasNext()) {
          ((LinkedHashSet)localObject).add(new com.whatsapp.emoji.a((int[])paramString.next()));
        }
        ((LinkedHashSet)localObject).addAll(c);
      }
    }
    finally {}
    paramString = localArrayList.iterator();
    while (paramString.hasNext()) {
      ((LinkedHashSet)localObject).addAll(a((String)paramString.next(), paramInt, true));
    }
    String str;
    if (((LinkedHashSet)localObject).size() < paramInt)
    {
      paramString = localArrayList.iterator();
      while (paramString.hasNext())
      {
        str = (String)paramString.next();
        f();
        ((LinkedHashSet)localObject).addAll(a(str, this.k, this.j));
      }
    }
    if (((LinkedHashSet)localObject).size() < paramInt)
    {
      paramString = localArrayList.iterator();
      while (paramString.hasNext())
      {
        str = (String)paramString.next();
        if (this.l == null)
        {
          this.m = new HashSet();
          this.l = a(c, this.m);
        }
        ((LinkedHashSet)localObject).addAll(a(str, this.m, this.l));
      }
    }
    if (((LinkedHashSet)localObject).size() < paramInt)
    {
      paramString = localArrayList.iterator();
      while (paramString.hasNext()) {
        ((LinkedHashSet)localObject).addAll(a((String)paramString.next(), paramInt, false));
      }
    }
    Object localObject = new ArrayList((Collection)localObject);
    paramString = (String)localObject;
    if (((List)localObject).size() > paramInt) {
      paramString = ((List)localObject).subList(0, paramInt);
    }
    return paramString;
  }
  
  public static final class a
  {
    final q a;
    
    a(q paramq)
    {
      this.a = paramq;
    }
    
    @LambdaForm.Hidden
    public final void a(boolean paramBoolean1, boolean paramBoolean2)
    {
      q localq = this.a;
      if (localq.b != paramBoolean1)
      {
        localq.b = paramBoolean1;
        if (localq.a != null)
        {
          q.a locala = localq.a;
          paramBoolean1 = localq.b;
          os.a(locala.a, paramBoolean1);
        }
      }
      if (paramBoolean2) {
        localq.c = false;
      }
    }
  }
  
  public static enum b
  {
    public final boolean f;
    private final boolean g;
    
    private b(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.f = paramBoolean1;
      this.g = paramBoolean2;
    }
  }
  
  static final class c
  {
    a.b a;
    String b;
    long c;
    String d;
    
    c() {}
    
    c(a.b paramb, String paramString1, long paramLong, String paramString2)
    {
      this.a = paramb;
      this.b = paramString1;
      this.c = paramLong;
      this.d = paramString2;
    }
  }
  
  public static final class d
  {
    final s a;
    
    d(s params)
    {
      this.a = params;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/emoji/search/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */