package com.whatsapp.data;

import a.a.a.a.a.a;
import a.a.a.a.a.d;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.whatsapp.protocol.j;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.a.c;
import com.whatsapp.util.bd;
import com.whatsapp.util.be;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.BreakIterator;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class q
{
  private static volatile q a;
  private static final Pattern b = Pattern.compile("\\p{Mn}+");
  private final Context c;
  private final c d;
  private final e e;
  private final cj f;
  private final File g;
  private final n h;
  private final ReentrantReadWriteLock.ReadLock i;
  
  private q(Context paramContext, c paramc, e parame, cj paramcj, ch paramch)
  {
    this.c = paramContext;
    this.d = paramc;
    this.e = parame;
    this.f = paramcj;
    this.g = paramch.c;
    this.h = paramch.a;
    this.i = paramch.b.readLock();
  }
  
  public static q a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new q(u.a(), c.a(), e.a(), cj.a(), ch.a());
      }
      return a;
    }
    finally {}
  }
  
  public static String a(String paramString)
  {
    return b.matcher(Normalizer.normalize(paramString, Normalizer.Form.NFKD)).replaceAll("").toLowerCase();
  }
  
  static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    BreakIterator localBreakIterator = be.a();
    localBreakIterator.setText(paramString);
    int k = localBreakIterator.first();
    int m;
    for (int j = localBreakIterator.next(); j != -1; j = m)
    {
      localStringBuilder.append(a(paramString.substring(k, j))).append(' ');
      m = localBreakIterator.next();
      k = j;
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.setLength(localStringBuilder.length() - 1);
    }
    return localStringBuilder.toString();
  }
  
  static String c(String paramString)
  {
    String str = b(paramString).trim();
    paramString = str;
    if (!TextUtils.isEmpty(str)) {
      if ((!str.startsWith("\"")) || (!str.endsWith("\"")) || (str.length() <= 2)) {
        break label116;
      }
    }
    label116:
    for (int j = 1;; j = 0)
    {
      paramString = str;
      if (j != 0) {
        paramString = str.substring(1, str.length() - 1);
      }
      str = be.a.matcher(paramString).replaceAll(" ").trim();
      paramString = str;
      if (!TextUtils.isEmpty(str))
      {
        if (j == 0) {
          break;
        }
        paramString = "\"" + str + "\"";
      }
      return paramString;
    }
    return str + "*";
  }
  
  /* Error */
  private int e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 68	com/whatsapp/data/q:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   4: invokevirtual 214	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   7: aload_0
    //   8: getfield 57	com/whatsapp/data/q:h	Lcom/whatsapp/data/n;
    //   11: invokevirtual 220	com/whatsapp/data/n:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore 13
    //   16: aload 13
    //   18: ldc -34
    //   20: iconst_1
    //   21: anewarray 122	java/lang/String
    //   24: dup
    //   25: iconst_0
    //   26: aload_0
    //   27: getfield 47	com/whatsapp/data/q:f	Lcom/whatsapp/data/cj;
    //   30: ldc -32
    //   32: invokevirtual 227	com/whatsapp/data/cj:b	(Ljava/lang/String;)J
    //   35: invokestatic 231	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   38: aastore
    //   39: invokevirtual 237	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   42: astore 14
    //   44: iconst_0
    //   45: istore_1
    //   46: aload 14
    //   48: ifnull +708 -> 756
    //   51: aload 13
    //   53: invokevirtual 240	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   56: aload 14
    //   58: ldc -14
    //   60: invokeinterface 248 2 0
    //   65: istore_2
    //   66: aload 14
    //   68: ldc -6
    //   70: invokeinterface 248 2 0
    //   75: istore_3
    //   76: aload 14
    //   78: ldc -4
    //   80: invokeinterface 248 2 0
    //   85: istore 4
    //   87: aload 14
    //   89: ldc -2
    //   91: invokeinterface 248 2 0
    //   96: istore 5
    //   98: aload 14
    //   100: ldc_w 256
    //   103: invokeinterface 248 2 0
    //   108: istore 6
    //   110: aload 14
    //   112: ldc_w 258
    //   115: invokeinterface 248 2 0
    //   120: istore 7
    //   122: aload 14
    //   124: ldc_w 260
    //   127: invokeinterface 248 2 0
    //   132: istore 8
    //   134: lconst_0
    //   135: lstore 9
    //   137: iconst_0
    //   138: istore_1
    //   139: aload 14
    //   141: invokeinterface 264 1 0
    //   146: ifeq +567 -> 713
    //   149: aload 14
    //   151: iload 6
    //   153: invokeinterface 268 2 0
    //   158: tableswitch	default:+610->768, 0:+147->305, 1:+310->468, 2:+610->768, 3:+310->468, 4:+324->482, 5:+324->482, 6:+610->768, 7:+610->768, 8:+610->768, 9:+310->468, 10:+610->768, 11:+610->768, 12:+610->768, 13:+310->468, 14:+338->496
    //   232: aload 14
    //   234: iload_3
    //   235: invokeinterface 272 2 0
    //   240: lstore 9
    //   242: aload 11
    //   244: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   247: ifne +527 -> 774
    //   250: aload 11
    //   252: invokestatic 180	com/whatsapp/data/q:b	(Ljava/lang/String;)Ljava/lang/String;
    //   255: astore 11
    //   257: new 274	android/content/ContentValues
    //   260: dup
    //   261: iconst_2
    //   262: invokespecial 275	android/content/ContentValues:<init>	(I)V
    //   265: astore 12
    //   267: aload 12
    //   269: ldc_w 277
    //   272: lload 9
    //   274: invokestatic 282	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   277: invokevirtual 286	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   280: aload 12
    //   282: ldc_w 288
    //   285: aload 11
    //   287: invokevirtual 291	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: aload 13
    //   292: ldc_w 293
    //   295: aconst_null
    //   296: aload 12
    //   298: invokevirtual 297	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   301: pop2
    //   302: goto +472 -> 774
    //   305: aload 14
    //   307: iload_2
    //   308: invokeinterface 301 2 0
    //   313: astore 12
    //   315: aload 14
    //   317: iload 4
    //   319: invokeinterface 301 2 0
    //   324: astore 15
    //   326: aload 12
    //   328: astore 11
    //   330: aload 15
    //   332: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   335: ifne +30 -> 365
    //   338: new 134	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   345: aload 12
    //   347: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: ldc -60
    //   352: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload 15
    //   357: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: astore 11
    //   365: aload 14
    //   367: iload 5
    //   369: invokeinterface 301 2 0
    //   374: astore 15
    //   376: aload 11
    //   378: astore 12
    //   380: aload 15
    //   382: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   385: ifne +30 -> 415
    //   388: new 134	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   395: aload 11
    //   397: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: ldc -60
    //   402: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload 15
    //   407: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: astore 12
    //   415: aload 14
    //   417: iload 7
    //   419: invokeinterface 301 2 0
    //   424: astore 15
    //   426: aload 12
    //   428: astore 11
    //   430: aload 15
    //   432: invokestatic 132	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   435: ifne -203 -> 232
    //   438: new 134	java/lang/StringBuilder
    //   441: dup
    //   442: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   445: aload 12
    //   447: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: ldc -60
    //   452: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload 15
    //   457: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: astore 11
    //   465: goto -233 -> 232
    //   468: aload 14
    //   470: iload 4
    //   472: invokeinterface 301 2 0
    //   477: astore 11
    //   479: goto -247 -> 232
    //   482: aload 14
    //   484: iload 5
    //   486: invokeinterface 301 2 0
    //   491: astore 11
    //   493: goto -261 -> 232
    //   496: new 134	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   503: astore 11
    //   505: new 303	java/util/ArrayList
    //   508: dup
    //   509: new 305	java/io/ObjectInputStream
    //   512: dup
    //   513: new 307	java/io/ByteArrayInputStream
    //   516: dup
    //   517: aload 14
    //   519: iload 8
    //   521: invokeinterface 311 2 0
    //   526: invokespecial 314	java/io/ByteArrayInputStream:<init>	([B)V
    //   529: invokespecial 317	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   532: invokevirtual 321	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   535: checkcast 323	java/util/List
    //   538: invokespecial 326	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   541: invokevirtual 330	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   544: astore 12
    //   546: aload 12
    //   548: invokeinterface 335 1 0
    //   553: ifeq +150 -> 703
    //   556: aload 12
    //   558: invokeinterface 337 1 0
    //   563: checkcast 122	java/lang/String
    //   566: astore 15
    //   568: aload 11
    //   570: aload_0
    //   571: getfield 41	com/whatsapp/data/q:c	Landroid/content/Context;
    //   574: aload_0
    //   575: getfield 45	com/whatsapp/data/q:e	Lcom/whatsapp/data/e;
    //   578: aload 15
    //   580: invokestatic 342	a/a/a/a/a/a:a	(Landroid/content/Context;Lcom/whatsapp/data/e;Ljava/lang/String;)La/a/a/a/a/a;
    //   583: invokevirtual 344	a/a/a/a/a/a:a	()Ljava/lang/String;
    //   586: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: ldc -60
    //   591: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: goto -49 -> 546
    //   598: astore 15
    //   600: ldc_w 346
    //   603: invokestatic 351	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   606: goto -60 -> 546
    //   609: astore 11
    //   611: ldc_w 353
    //   614: aload 11
    //   616: invokestatic 356	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   619: goto +149 -> 768
    //   622: astore 11
    //   624: aload 14
    //   626: invokeinterface 359 1 0
    //   631: aload 13
    //   633: invokevirtual 362	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   636: ifeq +8 -> 644
    //   639: aload 13
    //   641: invokevirtual 365	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   644: aload 11
    //   646: athrow
    //   647: astore 11
    //   649: aload_0
    //   650: getfield 68	com/whatsapp/data/q:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   653: invokevirtual 368	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   656: aload 11
    //   658: athrow
    //   659: astore 15
    //   661: ldc_w 370
    //   664: aload 15
    //   666: invokestatic 356	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   669: aload_0
    //   670: getfield 43	com/whatsapp/data/q:d	Lcom/whatsapp/util/a/c;
    //   673: new 134	java/lang/StringBuilder
    //   676: dup
    //   677: ldc_w 372
    //   680: invokespecial 198	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   683: aload 15
    //   685: invokevirtual 375	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   688: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: iconst_0
    //   695: aconst_null
    //   696: iconst_m1
    //   697: invokevirtual 378	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   700: goto -154 -> 546
    //   703: aload 11
    //   705: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   708: astore 11
    //   710: goto -478 -> 232
    //   713: lload 9
    //   715: lconst_0
    //   716: lcmp
    //   717: ifeq +14 -> 731
    //   720: aload_0
    //   721: getfield 47	com/whatsapp/data/q:f	Lcom/whatsapp/data/cj;
    //   724: ldc -32
    //   726: lload 9
    //   728: invokevirtual 381	com/whatsapp/data/cj:a	(Ljava/lang/String;J)V
    //   731: aload 13
    //   733: invokevirtual 384	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   736: aload 14
    //   738: invokeinterface 359 1 0
    //   743: aload 13
    //   745: invokevirtual 362	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   748: ifeq +17 -> 765
    //   751: aload 13
    //   753: invokevirtual 365	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   756: aload_0
    //   757: getfield 68	com/whatsapp/data/q:i	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   760: invokevirtual 368	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   763: iload_1
    //   764: ireturn
    //   765: goto -9 -> 756
    //   768: aconst_null
    //   769: astore 11
    //   771: goto -539 -> 232
    //   774: iload_1
    //   775: iconst_1
    //   776: iadd
    //   777: istore_1
    //   778: goto -639 -> 139
    //   781: astore 11
    //   783: goto -172 -> 611
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	786	0	this	q
    //   45	733	1	j	int
    //   65	243	2	k	int
    //   75	160	3	m	int
    //   85	386	4	n	int
    //   96	389	5	i1	int
    //   108	44	6	i2	int
    //   120	298	7	i3	int
    //   132	388	8	i4	int
    //   135	592	9	l	long
    //   242	327	11	localObject1	Object
    //   609	6	11	localIOException	IOException
    //   622	23	11	localObject2	Object
    //   647	57	11	localObject3	Object
    //   708	62	11	str1	String
    //   781	1	11	localClassNotFoundException	ClassNotFoundException
    //   265	292	12	localObject4	Object
    //   14	738	13	localSQLiteDatabase	SQLiteDatabase
    //   42	695	14	localCursor	android.database.Cursor
    //   324	255	15	str2	String
    //   598	1	15	locald	d
    //   659	25	15	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   568	595	598	a/a/a/a/a/d
    //   496	546	609	java/io/IOException
    //   546	568	609	java/io/IOException
    //   568	595	609	java/io/IOException
    //   600	606	609	java/io/IOException
    //   661	700	609	java/io/IOException
    //   703	710	609	java/io/IOException
    //   51	134	622	finally
    //   139	232	622	finally
    //   232	302	622	finally
    //   305	326	622	finally
    //   330	365	622	finally
    //   365	376	622	finally
    //   380	415	622	finally
    //   415	426	622	finally
    //   430	465	622	finally
    //   468	479	622	finally
    //   482	493	622	finally
    //   496	546	622	finally
    //   546	568	622	finally
    //   568	595	622	finally
    //   600	606	622	finally
    //   611	619	622	finally
    //   661	700	622	finally
    //   703	710	622	finally
    //   720	731	622	finally
    //   731	736	622	finally
    //   7	44	647	finally
    //   624	644	647	finally
    //   644	647	647	finally
    //   736	756	647	finally
    //   568	595	659	java/lang/Exception
    //   496	546	781	java/lang/ClassNotFoundException
    //   546	568	781	java/lang/ClassNotFoundException
    //   568	595	781	java/lang/ClassNotFoundException
    //   600	606	781	java/lang/ClassNotFoundException
    //   661	700	781	java/lang/ClassNotFoundException
    //   703	710	781	java/lang/ClassNotFoundException
  }
  
  final String a(j paramj)
  {
    switch (paramj.s)
    {
    }
    for (;;)
    {
      Object localObject1 = null;
      Object localObject2;
      do
      {
        do
        {
          return (String)localObject1;
          localObject2 = paramj.e();
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramj.z)) {
            localObject1 = (String)localObject2 + " " + paramj.z;
          }
          localObject2 = localObject1;
          if (!TextUtils.isEmpty(paramj.y)) {
            localObject2 = (String)localObject1 + " " + paramj.y;
          }
          localObject1 = localObject2;
        } while (TextUtils.isEmpty(paramj.p));
        return (String)localObject2 + " " + paramj.p;
        return paramj.z;
        localObject2 = paramj.z;
        paramj = MediaFileUtils.b(paramj.r);
        if (TextUtils.isEmpty(paramj)) {
          break;
        }
        localObject1 = paramj;
      } while (TextUtils.isEmpty((CharSequence)localObject2));
      return (String)localObject2 + " " + paramj;
      return paramj.y;
      try
      {
        localObject1 = new StringBuilder();
        paramj = new ArrayList((List)new ObjectInputStream(new ByteArrayInputStream(paramj.h())).readObject()).iterator();
        if (paramj.hasNext()) {
          localObject2 = (String)paramj.next();
        }
      }
      catch (IOException paramj)
      {
        for (;;)
        {
          try
          {
            ((StringBuilder)localObject1).append(a.a(this.c, this.e, (String)localObject2).a()).append(" ");
          }
          catch (d locald)
          {
            Log.w("ftsmsgstore/gettextforfts/error parsing vcard");
            continue;
            paramj = paramj;
            Log.d("ftsmsgstore/populateftstablebatch/error deserializing contact array", paramj);
            break;
          }
          catch (Exception localException)
          {
            Log.d("ftsmsgstore/gettextforfts/unexpected error parsing vcard", localException);
            this.d.a("FtsMessageStore getTextForFts unexpected vcard parsing exception: " + localException.getMessage(), false, null, -1);
          }
        }
        paramj = ((StringBuilder)localObject1).toString();
        return paramj;
        return localException;
      }
      catch (ClassNotFoundException paramj)
      {
        for (;;) {}
      }
    }
  }
  
  public final boolean b()
  {
    return this.f.b("fts_ready") != 0L;
  }
  
  public final void c()
  {
    bd localbd = new bd("ftsmsgstore/drop");
    SQLiteDatabase localSQLiteDatabase = this.h.getWritableDatabase();
    try
    {
      localSQLiteDatabase.beginTransaction();
      localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS messages_fts");
      localSQLiteDatabase.execSQL("DROP TRIGGER IF EXISTS messages_bd_trigger");
      this.f.a("fts_index_start", 0);
      this.f.a("fts_ready", 0);
      this.f.a("fts_tokenizer_version", 0);
      localSQLiteDatabase.setTransactionSuccessful();
      if (localSQLiteDatabase.inTransaction()) {
        localSQLiteDatabase.endTransaction();
      }
      Log.i("ftsmsgstore/drop time spent:" + localbd.b());
      return;
    }
    finally
    {
      if (localSQLiteDatabase.inTransaction()) {
        localSQLiteDatabase.endTransaction();
      }
    }
  }
  
  public final void d()
  {
    long l1 = this.g.length();
    Log.i("ftsmsgstore/populate/beging/db size:" + l1 + " start:" + this.f.b("fts_index_start"));
    bd localbd = new bd("msgstore/fts/populate");
    while (e() == 2048) {}
    Log.i("ftsmsgstore/populate time spent:" + localbd.b());
    localbd = new bd("msgstore/fts/optimize");
    ContentValues localContentValues = new ContentValues(1);
    localContentValues.put("messages_fts", "optimize");
    this.h.getWritableDatabase().insert("messages_fts", null, localContentValues);
    Log.i("ftsmsgstore/optimize time spent:" + localbd.b());
    this.f.a("fts_ready", 1);
    this.f.a("fts_tokenizer_version", 1);
    long l2 = this.g.length();
    Log.i("ftsmsgstore/populate/end/db size:" + l2 + " increase:" + l2 / l1);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */