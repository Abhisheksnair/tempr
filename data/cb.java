package com.whatsapp.data;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import com.whatsapp.InsufficientStorageSpaceActivity;
import com.whatsapp.apg.a;
import com.whatsapp.atu;
import com.whatsapp.av;
import com.whatsapp.fieldstats.events.m;
import com.whatsapp.fieldstats.l;
import com.whatsapp.k.d.b;
import com.whatsapp.ox;
import com.whatsapp.pv;
import com.whatsapp.r.a;
import com.whatsapp.util.Log;
import com.whatsapp.util.bd;
import com.whatsapp.util.bk;
import com.whatsapp.util.j;
import com.whatsapp.util.r.b;
import com.whatsapp.va;
import com.whatsapp.vv;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.invoke.LambdaForm.Hidden;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class cb
{
  public static final r.b a;
  public final HashMap<d, b> b;
  final Context c;
  public final Set<String> d = new HashSet();
  c e;
  final File f;
  final File g;
  private final pv i;
  private final com.whatsapp.util.a.c j;
  private final va k;
  private final ox l;
  private final vv m;
  private final atu n;
  
  static
  {
    if (!cb.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      h = bool;
      a = r.b.a();
      return;
    }
  }
  
  public cb(Context paramContext, pv parampv, com.whatsapp.util.a.c paramc, va paramva, ox paramox, vv paramvv, atu paramatu, File paramFile)
  {
    this.c = paramContext;
    this.i = parampv;
    this.j = paramc;
    this.k = paramva;
    this.l = paramox;
    this.m = paramvv;
    this.n = paramatu;
    this.f = paramFile;
    this.g = new File(paramox.b(), "msgstore.db");
    this.b = new HashMap();
  }
  
  private int a(ad paramad, File paramFile, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = true;
    if (!paramFile.exists())
    {
      Log.e("msgstore/restore-db-backup-file/does-not-exist " + paramFile.getAbsolutePath());
      return 3;
    }
    String str = paramFile.getName();
    Log.i("msgstore/restore/copy " + str + " size: " + paramFile.length());
    int i1 = a(str);
    r.b localb;
    m localm;
    long l1;
    if (i1 > 0)
    {
      localb = r.b.a(i1);
      localm = new m();
      if (localb == null) {
        break label378;
      }
      l1 = localb.m;
      label113:
      localm.b = Long.valueOf(l1);
    }
    for (;;)
    {
      try
      {
        if (!a(r.b.h, str)) {
          a(paramFile.length());
        }
        if (localb == null) {
          continue;
        }
        paramInt1 = a(localb, paramFile, paramInt1, paramInt2, localm);
      }
      catch (Exception paramFile)
      {
        label378:
        Log.c("msgstore/restore/error", paramFile);
        paramInt1 = 3;
        continue;
        paramInt2 = 3;
        continue;
        paramBoolean = false;
        continue;
      }
      paramInt2 = paramInt1;
      if (paramInt1 == 1)
      {
        localm.e = Boolean.valueOf(paramBoolean);
        if (!a(paramad, paramBoolean, localm)) {
          continue;
        }
        paramInt2 = 1;
      }
      Log.i("msgstore/restore/result/" + paramInt2);
      if (paramInt2 != 1) {
        continue;
      }
      paramBoolean = bool;
      localm.a = Boolean.valueOf(paramBoolean);
      Log.i("msgstore/restore/log-chat-db-restore-event overall-result: " + localm.a + " database-backup-version: " + localm.b + " file-integrity-check: " + localm.c + " jid-correct: " + localm.d + " database-repair-enabled: " + localm.e + " sqlite-integrity-check: " + localm.f + " has-only-index-errors: " + localm.g + " dump-and-restore-result: " + localm.i + " dump-and-restore-recovery-percentage: " + localm.j);
      l.a(this.c, localm);
      return paramInt2;
      localb = null;
      break;
      l1 = 0L;
      break label113;
      paramInt1 = a(paramFile, paramInt1, paramInt2);
    }
  }
  
  /* Error */
  private int a(r.b paramb, File paramFile, int paramInt1, int paramInt2, m paramm)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 16
    //   9: aconst_null
    //   10: astore 15
    //   12: aconst_null
    //   13: astore 17
    //   15: aconst_null
    //   16: astore 14
    //   18: iconst_3
    //   19: istore 7
    //   21: iload 7
    //   23: istore 6
    //   25: aload 17
    //   27: astore 12
    //   29: aload_0
    //   30: getfield 80	com/whatsapp/data/cb:m	Lcom/whatsapp/vv;
    //   33: aload_0
    //   34: getfield 84	com/whatsapp/data/cb:f	Ljava/io/File;
    //   37: invokevirtual 250	com/whatsapp/vv:a	(Ljava/io/File;)Lcom/whatsapp/util/e;
    //   40: astore 11
    //   42: iload 7
    //   44: istore 6
    //   46: aload 17
    //   48: astore 12
    //   50: aload 11
    //   52: astore 10
    //   54: aload 11
    //   56: astore 13
    //   58: aload_0
    //   59: getfield 76	com/whatsapp/data/cb:k	Lcom/whatsapp/va;
    //   62: aload_1
    //   63: aload_2
    //   64: invokestatic 255	a/a/a/a/d:a	(Lcom/whatsapp/va;Lcom/whatsapp/util/r$b;Ljava/io/File;)Lcom/whatsapp/data/cg;
    //   67: astore 18
    //   69: iload 7
    //   71: istore 6
    //   73: aload 17
    //   75: astore 12
    //   77: aload 11
    //   79: astore 10
    //   81: aload 11
    //   83: astore 13
    //   85: aload 18
    //   87: getfield 260	com/whatsapp/data/cg:b	Ljava/lang/String;
    //   90: ifnull +34 -> 124
    //   93: iload 7
    //   95: istore 6
    //   97: aload 17
    //   99: astore 12
    //   101: aload 11
    //   103: astore 10
    //   105: aload 11
    //   107: astore 13
    //   109: aload_0
    //   110: getfield 68	com/whatsapp/data/cb:d	Ljava/util/Set;
    //   113: aload 18
    //   115: getfield 260	com/whatsapp/data/cg:b	Ljava/lang/String;
    //   118: invokeinterface 266 2 0
    //   123: pop
    //   124: iload 7
    //   126: istore 6
    //   128: aload 17
    //   130: astore 12
    //   132: aload 11
    //   134: astore 10
    //   136: aload 11
    //   138: astore 13
    //   140: aload 18
    //   142: getfield 268	com/whatsapp/data/cg:a	I
    //   145: istore 8
    //   147: iload 8
    //   149: iconst_1
    //   150: if_icmpne +227 -> 377
    //   153: aload 14
    //   155: astore 13
    //   157: aload 15
    //   159: astore 12
    //   161: aload 5
    //   163: iconst_1
    //   164: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   167: putfield 208	com/whatsapp/fieldstats/events/m:c	Ljava/lang/Boolean;
    //   170: aload 14
    //   172: astore 13
    //   174: aload 15
    //   176: astore 12
    //   178: ldc_w 270
    //   181: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   184: aload 14
    //   186: astore 13
    //   188: aload 15
    //   190: astore 12
    //   192: new 272	java/io/BufferedInputStream
    //   195: dup
    //   196: new 274	java/io/FileInputStream
    //   199: dup
    //   200: aload_2
    //   201: invokespecial 277	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   204: invokespecial 280	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   207: astore 10
    //   209: aload 14
    //   211: astore 13
    //   213: aload 15
    //   215: astore 12
    //   217: aload_1
    //   218: getfield 159	com/whatsapp/util/r$b:m	I
    //   221: getstatic 282	com/whatsapp/util/r$b:j	Lcom/whatsapp/util/r$b;
    //   224: getfield 159	com/whatsapp/util/r$b:m	I
    //   227: if_icmpge +467 -> 694
    //   230: aconst_null
    //   231: astore 14
    //   233: aconst_null
    //   234: astore 15
    //   236: aconst_null
    //   237: astore 16
    //   239: aload 10
    //   241: astore 13
    //   243: aload 10
    //   245: astore 12
    //   247: getstatic 284	com/whatsapp/util/r$b:f	Lcom/whatsapp/util/r$b;
    //   250: aload_2
    //   251: invokevirtual 134	java/io/File:getName	()Ljava/lang/String;
    //   254: invokestatic 173	com/whatsapp/data/cb:a	(Lcom/whatsapp/util/r$b;Ljava/lang/String;)Z
    //   257: ifeq +1791 -> 2048
    //   260: aload 10
    //   262: astore 13
    //   264: aload 10
    //   266: astore 12
    //   268: aload 10
    //   270: invokestatic 289	com/whatsapp/r:a	(Ljava/io/InputStream;)Lcom/whatsapp/r$a;
    //   273: astore 14
    //   275: aload 10
    //   277: astore 13
    //   279: aload 10
    //   281: astore 12
    //   283: aload_0
    //   284: aload 14
    //   286: invokevirtual 292	com/whatsapp/data/cb:a	(Lcom/whatsapp/r$a;)Lcom/whatsapp/data/cb$b;
    //   289: astore 17
    //   291: aload 17
    //   293: ifnonnull +540 -> 833
    //   296: aload 10
    //   298: astore 13
    //   300: aload 10
    //   302: astore 12
    //   304: ldc_w 294
    //   307: invokestatic 131	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   310: aload 10
    //   312: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   315: aload 11
    //   317: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   320: iload 8
    //   322: iconst_1
    //   323: if_icmpne +486 -> 809
    //   326: ldc_w 301
    //   329: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   332: aload 5
    //   334: iconst_1
    //   335: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   338: putfield 212	com/whatsapp/fieldstats/events/m:d	Ljava/lang/Boolean;
    //   341: iload 8
    //   343: iconst_2
    //   344: if_icmpne +31 -> 375
    //   347: aload_0
    //   348: getfield 74	com/whatsapp/data/cb:j	Lcom/whatsapp/util/a/c;
    //   351: new 111	java/lang/StringBuilder
    //   354: dup
    //   355: ldc_w 303
    //   358: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   361: aload_1
    //   362: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   365: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: iconst_0
    //   369: aconst_null
    //   370: bipush 7
    //   372: invokevirtual 308	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   375: iconst_3
    //   376: ireturn
    //   377: iload 8
    //   379: iconst_2
    //   380: if_icmpne -196 -> 184
    //   383: aload 14
    //   385: astore 13
    //   387: aload 15
    //   389: astore 12
    //   391: aload 5
    //   393: iconst_0
    //   394: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   397: putfield 208	com/whatsapp/fieldstats/events/m:c	Ljava/lang/Boolean;
    //   400: aload 14
    //   402: astore 13
    //   404: aload 15
    //   406: astore 12
    //   408: ldc_w 310
    //   411: invokestatic 131	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   414: goto -230 -> 184
    //   417: astore 14
    //   419: iload 8
    //   421: istore_3
    //   422: aload 13
    //   424: astore_2
    //   425: iload_3
    //   426: istore 6
    //   428: aload_2
    //   429: astore 12
    //   431: aload 11
    //   433: astore 10
    //   435: aload 14
    //   437: invokevirtual 313	java/io/IOException:getMessage	()Ljava/lang/String;
    //   440: ifnull +846 -> 1286
    //   443: iload_3
    //   444: istore 6
    //   446: aload_2
    //   447: astore 12
    //   449: aload 11
    //   451: astore 10
    //   453: aload 14
    //   455: invokevirtual 313	java/io/IOException:getMessage	()Ljava/lang/String;
    //   458: ldc_w 315
    //   461: invokevirtual 321	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   464: ifeq +822 -> 1286
    //   467: iconst_1
    //   468: istore 4
    //   470: iload 4
    //   472: ifne +119 -> 591
    //   475: iload_3
    //   476: istore 6
    //   478: aload_2
    //   479: astore 12
    //   481: aload 11
    //   483: astore 10
    //   485: aload 14
    //   487: invokevirtual 325	java/io/IOException:getCause	()Ljava/lang/Throwable;
    //   490: ifnull +802 -> 1292
    //   493: iload_3
    //   494: istore 6
    //   496: aload_2
    //   497: astore 12
    //   499: aload 11
    //   501: astore 10
    //   503: aload 14
    //   505: invokevirtual 325	java/io/IOException:getCause	()Ljava/lang/Throwable;
    //   508: instanceof 327
    //   511: ifeq +781 -> 1292
    //   514: iconst_1
    //   515: istore 4
    //   517: iload 4
    //   519: ifne +72 -> 591
    //   522: iload_3
    //   523: istore 6
    //   525: aload_2
    //   526: astore 12
    //   528: aload 11
    //   530: astore 10
    //   532: getstatic 332	android/os/Build$VERSION:SDK_INT	I
    //   535: bipush 19
    //   537: if_icmplt +767 -> 1304
    //   540: iload_3
    //   541: istore 6
    //   543: aload_2
    //   544: astore 12
    //   546: aload 11
    //   548: astore 10
    //   550: aload 14
    //   552: invokevirtual 325	java/io/IOException:getCause	()Ljava/lang/Throwable;
    //   555: ifnull +743 -> 1298
    //   558: iload_3
    //   559: istore 6
    //   561: aload_2
    //   562: astore 12
    //   564: aload 11
    //   566: astore 10
    //   568: aload 14
    //   570: invokevirtual 325	java/io/IOException:getCause	()Ljava/lang/Throwable;
    //   573: instanceof 334
    //   576: istore 9
    //   578: iload 9
    //   580: ifeq +718 -> 1298
    //   583: iconst_1
    //   584: istore 4
    //   586: iload 4
    //   588: ifeq +774 -> 1362
    //   591: iconst_1
    //   592: istore 9
    //   594: iload_3
    //   595: iconst_2
    //   596: if_icmpne +831 -> 1427
    //   599: ldc -16
    //   601: aload 14
    //   603: invokestatic 336	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   606: aload_2
    //   607: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   610: aload 11
    //   612: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   615: iload_3
    //   616: iconst_1
    //   617: if_icmpne +757 -> 1374
    //   620: new 111	java/lang/StringBuilder
    //   623: dup
    //   624: ldc_w 338
    //   627: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   630: iload 9
    //   632: invokevirtual 341	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   635: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   641: iload 9
    //   643: ifne +725 -> 1368
    //   646: iconst_1
    //   647: istore 9
    //   649: aload 5
    //   651: iload 9
    //   653: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   656: putfield 212	com/whatsapp/fieldstats/events/m:d	Ljava/lang/Boolean;
    //   659: iload_3
    //   660: iconst_2
    //   661: if_icmpne +31 -> 692
    //   664: aload_0
    //   665: getfield 74	com/whatsapp/data/cb:j	Lcom/whatsapp/util/a/c;
    //   668: new 111	java/lang/StringBuilder
    //   671: dup
    //   672: ldc_w 303
    //   675: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   678: aload_1
    //   679: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   682: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   685: iconst_0
    //   686: aconst_null
    //   687: bipush 7
    //   689: invokevirtual 308	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   692: iconst_2
    //   693: ireturn
    //   694: aload 14
    //   696: astore 13
    //   698: aload 15
    //   700: astore 12
    //   702: aload_1
    //   703: getfield 159	com/whatsapp/util/r$b:m	I
    //   706: getstatic 282	com/whatsapp/util/r$b:j	Lcom/whatsapp/util/r$b;
    //   709: getfield 159	com/whatsapp/util/r$b:m	I
    //   712: if_icmpge +24 -> 736
    //   715: aload 14
    //   717: astore 13
    //   719: aload 15
    //   721: astore 12
    //   723: aload_1
    //   724: getfield 159	com/whatsapp/util/r$b:m	I
    //   727: getstatic 343	com/whatsapp/util/r$b:l	Lcom/whatsapp/util/r$b;
    //   730: getfield 159	com/whatsapp/util/r$b:m	I
    //   733: if_icmpgt +35 -> 768
    //   736: aload 14
    //   738: astore 13
    //   740: aload 15
    //   742: astore 12
    //   744: new 345	com/whatsapp/util/k
    //   747: dup
    //   748: aload 10
    //   750: aload_2
    //   751: invokevirtual 142	java/io/File:length	()J
    //   754: aload_1
    //   755: invokestatic 350	com/whatsapp/data/cf:a	(Lcom/whatsapp/util/r$b;)I
    //   758: i2l
    //   759: lsub
    //   760: invokespecial 353	com/whatsapp/util/k:<init>	(Ljava/io/InputStream;J)V
    //   763: astore 10
    //   765: goto -535 -> 230
    //   768: aload 14
    //   770: astore 13
    //   772: aload 15
    //   774: astore 12
    //   776: new 111	java/lang/StringBuilder
    //   779: dup
    //   780: ldc_w 355
    //   783: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   786: aload_1
    //   787: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   790: ldc_w 357
    //   793: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: aload_2
    //   797: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   800: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   803: invokestatic 131	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   806: goto -576 -> 230
    //   809: iload 8
    //   811: iconst_4
    //   812: if_icmpne -471 -> 341
    //   815: ldc_w 359
    //   818: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   821: aload 5
    //   823: iconst_1
    //   824: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   827: putfield 212	com/whatsapp/fieldstats/events/m:d	Ljava/lang/Boolean;
    //   830: goto -489 -> 341
    //   833: aload 10
    //   835: astore 13
    //   837: aload 10
    //   839: astore 12
    //   841: aload 17
    //   843: getfield 362	com/whatsapp/data/cb$b:b	[B
    //   846: astore 15
    //   848: aload 10
    //   850: astore 13
    //   852: aload 10
    //   854: astore 12
    //   856: aload 14
    //   858: getfield 366	com/whatsapp/r$a:e	[B
    //   861: astore 16
    //   863: aload 10
    //   865: astore 13
    //   867: aload 10
    //   869: astore 12
    //   871: new 111	java/lang/StringBuilder
    //   874: dup
    //   875: ldc_w 368
    //   878: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   881: aload_1
    //   882: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   885: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   888: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   891: aload 10
    //   893: astore 13
    //   895: aload 10
    //   897: astore 12
    //   899: new 111	java/lang/StringBuilder
    //   902: dup
    //   903: ldc_w 370
    //   906: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   909: aload_2
    //   910: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   913: ldc_w 372
    //   916: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   919: aload_2
    //   920: invokevirtual 142	java/io/File:length	()J
    //   923: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   926: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   929: invokestatic 374	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   932: aload 10
    //   934: astore 13
    //   936: aload 10
    //   938: astore 12
    //   940: invokestatic 379	com/whatsapp/util/r:a	()Lcom/whatsapp/util/r;
    //   943: aload 10
    //   945: aload 11
    //   947: iload_3
    //   948: iload 4
    //   950: aload_2
    //   951: invokevirtual 142	java/io/File:length	()J
    //   954: aload_0
    //   955: getfield 381	com/whatsapp/data/cb:e	Lcom/whatsapp/data/cb$c;
    //   958: aload_1
    //   959: aload 15
    //   961: aload 16
    //   963: invokevirtual 384	com/whatsapp/util/r:a	(Ljava/io/InputStream;Ljava/io/OutputStream;IIJLcom/whatsapp/data/cb$c;Lcom/whatsapp/util/r$b;[B[B)V
    //   966: aload 10
    //   968: astore 13
    //   970: aload 10
    //   972: astore 12
    //   974: aload 11
    //   976: invokevirtual 389	java/io/OutputStream:close	()V
    //   979: aload 10
    //   981: astore 13
    //   983: aload 10
    //   985: astore 12
    //   987: getstatic 391	com/whatsapp/util/r$b:g	Lcom/whatsapp/util/r$b;
    //   990: aload_2
    //   991: invokevirtual 134	java/io/File:getName	()Ljava/lang/String;
    //   994: invokestatic 173	com/whatsapp/data/cb:a	(Lcom/whatsapp/util/r$b;Ljava/lang/String;)Z
    //   997: ifeq +198 -> 1195
    //   1000: aload 10
    //   1002: astore 13
    //   1004: aload 10
    //   1006: astore 12
    //   1008: getstatic 51	com/whatsapp/data/cb:h	Z
    //   1011: ifne +128 -> 1139
    //   1014: aload 17
    //   1016: ifnonnull +123 -> 1139
    //   1019: aload 10
    //   1021: astore 13
    //   1023: aload 10
    //   1025: astore 12
    //   1027: new 393	java/lang/AssertionError
    //   1030: dup
    //   1031: invokespecial 394	java/lang/AssertionError:<init>	()V
    //   1034: athrow
    //   1035: astore 13
    //   1037: iconst_0
    //   1038: istore 9
    //   1040: iload 8
    //   1042: istore_3
    //   1043: aload 11
    //   1045: astore 10
    //   1047: aload 12
    //   1049: astore_2
    //   1050: aload_2
    //   1051: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1054: aload 10
    //   1056: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1059: iload_3
    //   1060: iconst_1
    //   1061: if_icmpne +905 -> 1966
    //   1064: new 111	java/lang/StringBuilder
    //   1067: dup
    //   1068: ldc_w 338
    //   1071: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1074: iload 9
    //   1076: invokevirtual 341	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1079: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1082: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1085: iload 9
    //   1087: ifne +873 -> 1960
    //   1090: iconst_1
    //   1091: istore 9
    //   1093: aload 5
    //   1095: iload 9
    //   1097: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1100: putfield 212	com/whatsapp/fieldstats/events/m:d	Ljava/lang/Boolean;
    //   1103: iload_3
    //   1104: iconst_2
    //   1105: if_icmpne +31 -> 1136
    //   1108: aload_0
    //   1109: getfield 74	com/whatsapp/data/cb:j	Lcom/whatsapp/util/a/c;
    //   1112: new 111	java/lang/StringBuilder
    //   1115: dup
    //   1116: ldc_w 303
    //   1119: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1122: aload_1
    //   1123: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1126: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1129: iconst_0
    //   1130: aconst_null
    //   1131: bipush 7
    //   1133: invokevirtual 308	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   1136: aload 13
    //   1138: athrow
    //   1139: aload 10
    //   1141: astore 13
    //   1143: aload 10
    //   1145: astore 12
    //   1147: aload 17
    //   1149: getfield 396	com/whatsapp/data/cb$b:c	[B
    //   1152: astore_2
    //   1153: aload 10
    //   1155: astore 13
    //   1157: aload 10
    //   1159: astore 12
    //   1161: aload 14
    //   1163: getfield 397	com/whatsapp/r$a:b	Ljava/lang/String;
    //   1166: aload 14
    //   1168: getfield 398	com/whatsapp/r$a:c	[B
    //   1171: aload 15
    //   1173: aload_2
    //   1174: aload 14
    //   1176: getfield 400	com/whatsapp/r$a:d	[B
    //   1179: invokestatic 403	com/whatsapp/r:a	(Ljava/lang/String;[B[B[B[B)Z
    //   1182: pop
    //   1183: aload 10
    //   1185: astore 13
    //   1187: aload 10
    //   1189: astore 12
    //   1191: invokestatic 406	com/whatsapp/r:n	()Lcom/whatsapp/r$b;
    //   1194: pop
    //   1195: aload 10
    //   1197: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1200: aload 11
    //   1202: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1205: iload 8
    //   1207: iconst_1
    //   1208: if_icmpne +54 -> 1262
    //   1211: ldc_w 301
    //   1214: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1217: aload 5
    //   1219: iconst_1
    //   1220: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1223: putfield 212	com/whatsapp/fieldstats/events/m:d	Ljava/lang/Boolean;
    //   1226: iload 8
    //   1228: iconst_2
    //   1229: if_icmpne +31 -> 1260
    //   1232: aload_0
    //   1233: getfield 74	com/whatsapp/data/cb:j	Lcom/whatsapp/util/a/c;
    //   1236: new 111	java/lang/StringBuilder
    //   1239: dup
    //   1240: ldc_w 303
    //   1243: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1246: aload_1
    //   1247: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1250: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1253: iconst_0
    //   1254: aconst_null
    //   1255: bipush 7
    //   1257: invokevirtual 308	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   1260: iconst_1
    //   1261: ireturn
    //   1262: iload 8
    //   1264: iconst_4
    //   1265: if_icmpne -39 -> 1226
    //   1268: ldc_w 359
    //   1271: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1274: aload 5
    //   1276: iconst_1
    //   1277: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1280: putfield 212	com/whatsapp/fieldstats/events/m:d	Ljava/lang/Boolean;
    //   1283: goto -57 -> 1226
    //   1286: iconst_0
    //   1287: istore 4
    //   1289: goto -819 -> 470
    //   1292: iconst_0
    //   1293: istore 4
    //   1295: goto -778 -> 517
    //   1298: iconst_0
    //   1299: istore 4
    //   1301: goto -715 -> 586
    //   1304: iload_3
    //   1305: istore 6
    //   1307: aload_2
    //   1308: astore 12
    //   1310: aload 11
    //   1312: astore 10
    //   1314: aload 14
    //   1316: invokevirtual 313	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1319: ifnull +37 -> 1356
    //   1322: iload_3
    //   1323: istore 6
    //   1325: aload_2
    //   1326: astore 12
    //   1328: aload 11
    //   1330: astore 10
    //   1332: aload 14
    //   1334: invokevirtual 313	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1337: ldc_w 408
    //   1340: invokevirtual 321	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1343: istore 9
    //   1345: iload 9
    //   1347: ifeq +9 -> 1356
    //   1350: iconst_1
    //   1351: istore 4
    //   1353: goto -767 -> 586
    //   1356: iconst_0
    //   1357: istore 4
    //   1359: goto -773 -> 586
    //   1362: iconst_0
    //   1363: istore 9
    //   1365: goto -771 -> 594
    //   1368: iconst_0
    //   1369: istore 9
    //   1371: goto -722 -> 649
    //   1374: iload_3
    //   1375: iconst_4
    //   1376: if_icmpne -717 -> 659
    //   1379: new 111	java/lang/StringBuilder
    //   1382: dup
    //   1383: ldc_w 410
    //   1386: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1389: iload 9
    //   1391: invokevirtual 341	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1394: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1397: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1400: iload 9
    //   1402: ifne +19 -> 1421
    //   1405: iconst_1
    //   1406: istore 9
    //   1408: aload 5
    //   1410: iload 9
    //   1412: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1415: putfield 212	com/whatsapp/fieldstats/events/m:d	Ljava/lang/Boolean;
    //   1418: goto -759 -> 659
    //   1421: iconst_0
    //   1422: istore 9
    //   1424: goto -16 -> 1408
    //   1427: iload 9
    //   1429: ifeq +328 -> 1757
    //   1432: iload_3
    //   1433: iconst_4
    //   1434: if_icmpeq +8 -> 1442
    //   1437: iload_3
    //   1438: iconst_1
    //   1439: if_icmpne +318 -> 1757
    //   1442: iload_3
    //   1443: iconst_4
    //   1444: if_icmpne +158 -> 1602
    //   1447: ldc_w 412
    //   1450: aload 14
    //   1452: invokestatic 336	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1455: aload_2
    //   1456: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1459: aload 11
    //   1461: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1464: iload_3
    //   1465: iconst_1
    //   1466: if_icmpne +83 -> 1549
    //   1469: new 111	java/lang/StringBuilder
    //   1472: dup
    //   1473: ldc_w 338
    //   1476: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1479: iload 9
    //   1481: invokevirtual 341	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1484: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1487: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1490: iload 9
    //   1492: ifne +51 -> 1543
    //   1495: iconst_1
    //   1496: istore 9
    //   1498: aload 5
    //   1500: iload 9
    //   1502: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1505: putfield 212	com/whatsapp/fieldstats/events/m:d	Ljava/lang/Boolean;
    //   1508: iload_3
    //   1509: iconst_2
    //   1510: if_icmpne +31 -> 1541
    //   1513: aload_0
    //   1514: getfield 74	com/whatsapp/data/cb:j	Lcom/whatsapp/util/a/c;
    //   1517: new 111	java/lang/StringBuilder
    //   1520: dup
    //   1521: ldc_w 303
    //   1524: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1527: aload_1
    //   1528: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1531: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1534: iconst_0
    //   1535: aconst_null
    //   1536: bipush 7
    //   1538: invokevirtual 308	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   1541: iconst_4
    //   1542: ireturn
    //   1543: iconst_0
    //   1544: istore 9
    //   1546: goto -48 -> 1498
    //   1549: iload_3
    //   1550: iconst_4
    //   1551: if_icmpne -43 -> 1508
    //   1554: new 111	java/lang/StringBuilder
    //   1557: dup
    //   1558: ldc_w 410
    //   1561: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1564: iload 9
    //   1566: invokevirtual 341	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1569: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1572: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1575: iload 9
    //   1577: ifne +19 -> 1596
    //   1580: iconst_1
    //   1581: istore 9
    //   1583: aload 5
    //   1585: iload 9
    //   1587: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1590: putfield 212	com/whatsapp/fieldstats/events/m:d	Ljava/lang/Boolean;
    //   1593: goto -85 -> 1508
    //   1596: iconst_0
    //   1597: istore 9
    //   1599: goto -16 -> 1583
    //   1602: ldc_w 414
    //   1605: aload 14
    //   1607: invokestatic 336	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1610: aload_2
    //   1611: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1614: aload 11
    //   1616: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1619: iload_3
    //   1620: iconst_1
    //   1621: if_icmpne +83 -> 1704
    //   1624: new 111	java/lang/StringBuilder
    //   1627: dup
    //   1628: ldc_w 338
    //   1631: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1634: iload 9
    //   1636: invokevirtual 341	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1639: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1642: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1645: iload 9
    //   1647: ifne +51 -> 1698
    //   1650: iconst_1
    //   1651: istore 9
    //   1653: aload 5
    //   1655: iload 9
    //   1657: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1660: putfield 212	com/whatsapp/fieldstats/events/m:d	Ljava/lang/Boolean;
    //   1663: iload_3
    //   1664: iconst_2
    //   1665: if_icmpne +31 -> 1696
    //   1668: aload_0
    //   1669: getfield 74	com/whatsapp/data/cb:j	Lcom/whatsapp/util/a/c;
    //   1672: new 111	java/lang/StringBuilder
    //   1675: dup
    //   1676: ldc_w 303
    //   1679: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1682: aload_1
    //   1683: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1686: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1689: iconst_0
    //   1690: aconst_null
    //   1691: bipush 7
    //   1693: invokevirtual 308	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   1696: iconst_3
    //   1697: ireturn
    //   1698: iconst_0
    //   1699: istore 9
    //   1701: goto -48 -> 1653
    //   1704: iload_3
    //   1705: iconst_4
    //   1706: if_icmpne -43 -> 1663
    //   1709: new 111	java/lang/StringBuilder
    //   1712: dup
    //   1713: ldc_w 410
    //   1716: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1719: iload 9
    //   1721: invokevirtual 341	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1724: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1727: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1730: iload 9
    //   1732: ifne +19 -> 1751
    //   1735: iconst_1
    //   1736: istore 9
    //   1738: aload 5
    //   1740: iload 9
    //   1742: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1745: putfield 212	com/whatsapp/fieldstats/events/m:d	Ljava/lang/Boolean;
    //   1748: goto -85 -> 1663
    //   1751: iconst_0
    //   1752: istore 9
    //   1754: goto -16 -> 1738
    //   1757: aload 14
    //   1759: invokevirtual 313	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1762: ifnull +121 -> 1883
    //   1765: aload 14
    //   1767: invokevirtual 313	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1770: ldc_w 416
    //   1773: invokevirtual 419	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1776: ifeq +107 -> 1883
    //   1779: iconst_1
    //   1780: istore 4
    //   1782: iload 4
    //   1784: ifeq +164 -> 1948
    //   1787: ldc_w 421
    //   1790: aload 14
    //   1792: invokestatic 336	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1795: aload_2
    //   1796: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1799: aload 11
    //   1801: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1804: iload_3
    //   1805: iconst_1
    //   1806: if_icmpne +89 -> 1895
    //   1809: new 111	java/lang/StringBuilder
    //   1812: dup
    //   1813: ldc_w 338
    //   1816: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1819: iload 9
    //   1821: invokevirtual 341	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1824: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1827: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1830: iload 9
    //   1832: ifne +57 -> 1889
    //   1835: iconst_1
    //   1836: istore 9
    //   1838: aload 5
    //   1840: iload 9
    //   1842: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1845: putfield 212	com/whatsapp/fieldstats/events/m:d	Ljava/lang/Boolean;
    //   1848: iload_3
    //   1849: iconst_2
    //   1850: if_icmpne +31 -> 1881
    //   1853: aload_0
    //   1854: getfield 74	com/whatsapp/data/cb:j	Lcom/whatsapp/util/a/c;
    //   1857: new 111	java/lang/StringBuilder
    //   1860: dup
    //   1861: ldc_w 303
    //   1864: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1867: aload_1
    //   1868: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1871: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1874: iconst_0
    //   1875: aconst_null
    //   1876: bipush 7
    //   1878: invokevirtual 308	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   1881: iconst_5
    //   1882: ireturn
    //   1883: iconst_0
    //   1884: istore 4
    //   1886: goto -104 -> 1782
    //   1889: iconst_0
    //   1890: istore 9
    //   1892: goto -54 -> 1838
    //   1895: iload_3
    //   1896: iconst_4
    //   1897: if_icmpne -49 -> 1848
    //   1900: new 111	java/lang/StringBuilder
    //   1903: dup
    //   1904: ldc_w 410
    //   1907: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1910: iload 9
    //   1912: invokevirtual 341	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1915: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1918: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1921: iload 9
    //   1923: ifne +19 -> 1942
    //   1926: iconst_1
    //   1927: istore 9
    //   1929: aload 5
    //   1931: iload 9
    //   1933: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1936: putfield 212	com/whatsapp/fieldstats/events/m:d	Ljava/lang/Boolean;
    //   1939: goto -91 -> 1848
    //   1942: iconst_0
    //   1943: istore 9
    //   1945: goto -16 -> 1929
    //   1948: aload 14
    //   1950: athrow
    //   1951: astore 13
    //   1953: aload 11
    //   1955: astore 10
    //   1957: goto -907 -> 1050
    //   1960: iconst_0
    //   1961: istore 9
    //   1963: goto -870 -> 1093
    //   1966: iload_3
    //   1967: iconst_4
    //   1968: if_icmpne -865 -> 1103
    //   1971: new 111	java/lang/StringBuilder
    //   1974: dup
    //   1975: ldc_w 410
    //   1978: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1981: iload 9
    //   1983: invokevirtual 341	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1986: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1989: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1992: iload 9
    //   1994: ifne +19 -> 2013
    //   1997: iconst_1
    //   1998: istore 9
    //   2000: aload 5
    //   2002: iload 9
    //   2004: invokestatic 184	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2007: putfield 212	com/whatsapp/fieldstats/events/m:d	Ljava/lang/Boolean;
    //   2010: goto -907 -> 1103
    //   2013: iconst_0
    //   2014: istore 9
    //   2016: goto -16 -> 2000
    //   2019: astore 13
    //   2021: iload 6
    //   2023: istore_3
    //   2024: iconst_0
    //   2025: istore 9
    //   2027: aload 12
    //   2029: astore_2
    //   2030: goto -980 -> 1050
    //   2033: astore 14
    //   2035: iload 7
    //   2037: istore_3
    //   2038: aload 16
    //   2040: astore_2
    //   2041: aload 13
    //   2043: astore 11
    //   2045: goto -1620 -> 425
    //   2048: aconst_null
    //   2049: astore 17
    //   2051: goto -1188 -> 863
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2054	0	this	cb
    //   0	2054	1	paramb	r.b
    //   0	2054	2	paramFile	File
    //   0	2054	3	paramInt1	int
    //   0	2054	4	paramInt2	int
    //   0	2054	5	paramm	m
    //   23	1999	6	i1	int
    //   19	2017	7	i2	int
    //   145	1121	8	i3	int
    //   576	1450	9	bool	boolean
    //   4	1952	10	localObject1	Object
    //   40	2004	11	localObject2	Object
    //   27	2001	12	localObject3	Object
    //   1	1021	13	localObject4	Object
    //   1035	102	13	localObject5	Object
    //   1141	45	13	localObject6	Object
    //   1951	1	13	localObject7	Object
    //   2019	23	13	localObject8	Object
    //   16	385	14	locala	r.a
    //   417	1532	14	localIOException1	IOException
    //   2033	1	14	localIOException2	IOException
    //   10	1162	15	arrayOfByte1	byte[]
    //   7	2032	16	arrayOfByte2	byte[]
    //   13	2037	17	localb	b
    //   67	74	18	localcg	cg
    // Exception table:
    //   from	to	target	type
    //   161	170	417	java/io/IOException
    //   178	184	417	java/io/IOException
    //   192	209	417	java/io/IOException
    //   217	230	417	java/io/IOException
    //   247	260	417	java/io/IOException
    //   268	275	417	java/io/IOException
    //   283	291	417	java/io/IOException
    //   304	310	417	java/io/IOException
    //   391	400	417	java/io/IOException
    //   408	414	417	java/io/IOException
    //   702	715	417	java/io/IOException
    //   723	736	417	java/io/IOException
    //   744	765	417	java/io/IOException
    //   776	806	417	java/io/IOException
    //   841	848	417	java/io/IOException
    //   856	863	417	java/io/IOException
    //   871	891	417	java/io/IOException
    //   899	932	417	java/io/IOException
    //   940	966	417	java/io/IOException
    //   974	979	417	java/io/IOException
    //   987	1000	417	java/io/IOException
    //   1008	1014	417	java/io/IOException
    //   1027	1035	417	java/io/IOException
    //   1147	1153	417	java/io/IOException
    //   1161	1183	417	java/io/IOException
    //   1191	1195	417	java/io/IOException
    //   161	170	1035	finally
    //   178	184	1035	finally
    //   192	209	1035	finally
    //   217	230	1035	finally
    //   247	260	1035	finally
    //   268	275	1035	finally
    //   283	291	1035	finally
    //   304	310	1035	finally
    //   391	400	1035	finally
    //   408	414	1035	finally
    //   702	715	1035	finally
    //   723	736	1035	finally
    //   744	765	1035	finally
    //   776	806	1035	finally
    //   841	848	1035	finally
    //   856	863	1035	finally
    //   871	891	1035	finally
    //   899	932	1035	finally
    //   940	966	1035	finally
    //   974	979	1035	finally
    //   987	1000	1035	finally
    //   1008	1014	1035	finally
    //   1027	1035	1035	finally
    //   1147	1153	1035	finally
    //   1161	1183	1035	finally
    //   1191	1195	1035	finally
    //   599	606	1951	finally
    //   1447	1455	1951	finally
    //   1602	1610	1951	finally
    //   1757	1779	1951	finally
    //   1787	1795	1951	finally
    //   1948	1951	1951	finally
    //   29	42	2019	finally
    //   58	69	2019	finally
    //   85	93	2019	finally
    //   109	124	2019	finally
    //   140	147	2019	finally
    //   435	443	2019	finally
    //   453	467	2019	finally
    //   485	493	2019	finally
    //   503	514	2019	finally
    //   532	540	2019	finally
    //   550	558	2019	finally
    //   568	578	2019	finally
    //   1314	1322	2019	finally
    //   1332	1345	2019	finally
    //   29	42	2033	java/io/IOException
    //   58	69	2033	java/io/IOException
    //   85	93	2033	java/io/IOException
    //   109	124	2033	java/io/IOException
    //   140	147	2033	java/io/IOException
  }
  
  /* Error */
  private int a(File paramFile, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: getfield 80	com/whatsapp/data/cb:m	Lcom/whatsapp/vv;
    //   7: aload_0
    //   8: getfield 84	com/whatsapp/data/cb:f	Ljava/io/File;
    //   11: invokevirtual 250	com/whatsapp/vv:a	(Ljava/io/File;)Lcom/whatsapp/util/e;
    //   14: astore 4
    //   16: new 274	java/io/FileInputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 277	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore_1
    //   25: aload_0
    //   26: aload_1
    //   27: invokevirtual 425	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   30: aload 4
    //   32: invokestatic 431	java/nio/channels/Channels:newChannel	(Ljava/io/OutputStream;)Ljava/nio/channels/WritableByteChannel;
    //   35: iload_2
    //   36: iload_3
    //   37: invokespecial 434	com/whatsapp/data/cb:a	(Ljava/nio/channels/FileChannel;Ljava/nio/channels/WritableByteChannel;II)V
    //   40: aload 4
    //   42: invokevirtual 389	java/io/OutputStream:close	()V
    //   45: aload_1
    //   46: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   49: aload 4
    //   51: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   54: iconst_1
    //   55: ireturn
    //   56: astore_1
    //   57: aconst_null
    //   58: astore 4
    //   60: aload 5
    //   62: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   65: aload 4
    //   67: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   70: aload_1
    //   71: athrow
    //   72: astore_1
    //   73: goto -13 -> 60
    //   76: astore 6
    //   78: aload_1
    //   79: astore 5
    //   81: aload 6
    //   83: astore_1
    //   84: goto -24 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	cb
    //   0	87	1	paramFile	File
    //   0	87	2	paramInt1	int
    //   0	87	3	paramInt2	int
    //   14	52	4	locale	com.whatsapp.util.e
    //   1	79	5	localObject1	Object
    //   76	6	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	16	56	finally
    //   16	25	72	finally
    //   25	45	76	finally
  }
  
  public static int a(String paramString)
  {
    int i1 = 1;
    if ("msgstore.db".equals(paramString)) {
      i1 = 0;
    }
    while (paramString.endsWith(".crypt")) {
      return i1;
    }
    String[] arrayOfString = paramString.split(".crypt");
    if (arrayOfString.length != 2)
    {
      Log.e("msgstore/get-version/unexpected-filename " + paramString);
      return -1;
    }
    try
    {
      i1 = Integer.parseInt(arrayOfString[1]);
      return i1;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      Log.e("msgstore/get-version/unexpected-filename " + paramString);
    }
    return -1;
  }
  
  private File a(File paramFile, long paramLong)
  {
    if (vv.e() < 3L * paramLong)
    {
      Log.i("msgstore/backup/prepare/db/not enough internal storage to make db copy");
      return paramFile;
    }
    com.whatsapp.k.d locald;
    try
    {
      File localFile = this.m.d.a("");
      locald = com.whatsapp.k.c.a("msgstore/backup/db/copy");
      locald.a();
      locald.a(d.b.b, (int)paramLong);
      if (!a.a.a.a.d.a(this.m, paramFile, localFile))
      {
        Log.i("msgstore/backup/prepare/db/failed to copy");
        return paramFile;
      }
    }
    catch (IOException localIOException)
    {
      Log.c("msgstore/backup/prepare/db/source failed", localIOException);
      return paramFile;
    }
    locald.b();
    if (vv.f() < 2L * paramLong)
    {
      Log.i("msgstore/backup/prepare/db/not enough external storage to use db copy");
      localIOException.delete();
      return paramFile;
    }
    Log.i("msgstore/backup/prepare/db/let's use db copy");
    return localIOException;
  }
  
  public static String a()
  {
    return "msgstore.db";
  }
  
  static String a(r.b paramb)
  {
    int i1 = paramb.m;
    if (i1 == 1) {
      return ".crypt";
    }
    return ".crypt" + i1;
  }
  
  private static void a(InputStream paramInputStream, long paramLong, OutputStream paramOutputStream, com.whatsapp.gdrive.ch.a<Void, Integer> parama)
  {
    byte[] arrayOfByte = new byte[131072];
    long l1 = 0L;
    int i1 = -1;
    for (;;)
    {
      int i2 = paramInputStream.read(arrayOfByte);
      if (i2 < 0) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i2);
      long l2 = l1 + i2;
      i2 = (int)(100L * l2 / paramLong);
      l1 = l2;
      if (i1 != i2)
      {
        if (parama != null) {
          parama.a(Integer.valueOf(i2));
        }
        i1 = i2;
        l1 = l2;
      }
    }
  }
  
  private void a(FileChannel paramFileChannel, WritableByteChannel paramWritableByteChannel, int paramInt1, int paramInt2)
  {
    long l1 = 0L;
    long l2 = 0L;
    while (l1 < paramFileChannel.size())
    {
      l2 += paramFileChannel.transferTo(l1, Math.min(131072L, paramFileChannel.size() - l1), paramWritableByteChannel);
      if ((this.e != null) && (paramInt2 > 0)) {
        this.e.a(l2, paramFileChannel.size(), paramInt1, paramInt2);
      }
      l1 += 131072L;
    }
  }
  
  private boolean a(ad paramad, boolean paramBoolean, m paramm)
  {
    boolean bool3 = paramad.n();
    if (!bool3)
    {
      Log.i("msgstore/restore/check-restored-db/missing-file " + this.f);
      return false;
    }
    Object localObject2 = paramad.c(this.f);
    int i1;
    label62:
    StringBuilder localStringBuilder;
    if (localObject2 == null)
    {
      i1 = -1;
      if (i1 != 0) {
        break label182;
      }
      bool1 = true;
      paramm.f = Boolean.valueOf(bool1);
      localStringBuilder = new StringBuilder("msgstore/restore/errors/count ").append(i1);
      if (localObject2 == null) {
        break label188;
      }
    }
    label182:
    label188:
    for (Object localObject1 = " index=" + ((ad.h)localObject2).b.size() + " other=" + ((ad.h)localObject2).c.size();; localObject1 = "")
    {
      Log.i((String)localObject1);
      bool1 = bool3;
      if (i1 == 0) {
        break label650;
      }
      if (paramBoolean) {
        break label196;
      }
      a.a.a.a.d.d(this.f);
      return false;
      i1 = ((ad.h)localObject2).a;
      break;
      bool1 = false;
      break label62;
    }
    label196:
    boolean bool2;
    int i2;
    if ((localObject2 != null) && (((ad.h)localObject2).b.size() > 0) && (((ad.h)localObject2).c.size() == 0))
    {
      bool2 = true;
      paramm.g = Boolean.valueOf(bool2);
      if (!bool2) {
        break label732;
      }
      paramad.p();
      localObject2 = ((ad.h)localObject2).b.entrySet().iterator();
      i1 = 0;
      i2 = 0;
      label265:
      if (!((Iterator)localObject2).hasNext()) {
        break label389;
      }
      localObject1 = (Map.Entry)((Iterator)localObject2).next();
      bool1 = b((String)((Map.Entry)localObject1).getKey());
      localStringBuilder = new StringBuilder("msgstore/restore/reindex/key: ").append((String)((Map.Entry)localObject1).getKey());
      if (!bool1) {
        break label381;
      }
    }
    label381:
    for (localObject1 = " ok";; localObject1 = " failed")
    {
      Log.i((String)localObject1);
      i1 += 1;
      i3 = i1;
      if (!bool1) {
        break label393;
      }
      i2 += 1;
      break label265;
      bool2 = false;
      break;
    }
    label389:
    int i3 = i1;
    label393:
    boolean bool1 = ad.b(this.f);
    localObject2 = new StringBuilder("msgstore/restore/reindexresult/dbintegrity ");
    if (bool1)
    {
      localObject1 = "ok";
      Log.i((String)localObject1);
      Log.i("msgstore/restore/reindexresult/reindexed " + i2 + "/" + i3);
      paramm.h = Boolean.valueOf(bool1);
      if (!bool1)
      {
        this.j.a("Database reindexing failed", false, null, 7);
        paramad.q();
      }
    }
    for (;;)
    {
      if (bool2)
      {
        bool3 = bool1;
        if (bool1) {}
      }
      else
      {
        localObject1 = new AtomicReference(Double.valueOf(0.0D));
        bool3 = a.a.a.a.d.a(this, this.f, (AtomicReference)localObject1);
        Log.i("msgstore/restore/dumpAndRestoreResult/" + bool3 + " recovery %age: " + localObject1);
        paramm.i = Boolean.valueOf(bool3);
        paramm.j = Long.valueOf(((Double)((AtomicReference)localObject1).get()).longValue());
        bool1 = bool3;
        if (bool2)
        {
          l.a(this.c, 859, Boolean.valueOf(bool3));
          bool1 = bool3;
          if (!bool3)
          {
            this.j.a("Dump and restore failed after reindex failed", false, null, 7);
            bool1 = bool3;
          }
        }
        label650:
        bool3 = bool1;
      }
      if ((!bool3) || (!paramad.n())) {
        break;
      }
      if (paramBoolean)
      {
        paramad = this.c.getSharedPreferences("com.whatsapp_preferences", 0).edit();
        paramad.putBoolean("maintain_db_integrity", true);
        if (paramad.commit()) {
          break label723;
        }
        Log.e("msgstore/restore/maintain-db-integrity/failed");
      }
      for (;;)
      {
        return true;
        localObject1 = "failed";
        break;
        label723:
        Log.d("msgstore/restore/maintain-db-integrity/success");
      }
      label732:
      bool1 = bool3;
    }
  }
  
  private static boolean a(r.b paramb, String paramString)
  {
    int i1 = paramb.m;
    int i2 = a(paramString);
    if (i2 < 0) {
      throw new IllegalArgumentException("msgstore/is-at-least-version/unexpected-file-name: " + paramString);
    }
    return i2 >= i1;
  }
  
  static String[] a(r.b paramb1, r.b paramb2)
  {
    if (paramb1.m > paramb2.m) {
      throw new IllegalArgumentException("msgstore/get-db-crypt-extension-range/illegal-range [" + paramb1 + ", " + paramb2 + ")");
    }
    paramb1 = r.b.a(paramb1, paramb2);
    paramb2 = new String[paramb1.length];
    int i1 = 0;
    while (i1 < paramb2.length)
    {
      paramb2[i1] = a(paramb1[i1]);
      i1 += 1;
    }
    return paramb2;
  }
  
  private File b(r.b paramb)
  {
    return new File(this.l.b(), "msgstore.db" + a(paramb));
  }
  
  /* Error */
  private boolean b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: new 722	com/whatsapp/util/bd
    //   9: dup
    //   10: ldc_w 724
    //   13: invokespecial 725	com/whatsapp/util/bd:<init>	(Ljava/lang/String;)V
    //   16: astore 6
    //   18: aload_0
    //   19: getfield 84	com/whatsapp/data/cb:f	Ljava/io/File;
    //   22: invokevirtual 120	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   25: aconst_null
    //   26: getstatic 729	com/whatsapp/data/n:h	I
    //   29: invokestatic 735	android/database/sqlite/SQLiteDatabase:openDatabase	(Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)Landroid/database/sqlite/SQLiteDatabase;
    //   32: astore_2
    //   33: aload_2
    //   34: astore 4
    //   36: aload_2
    //   37: astore 5
    //   39: aload_2
    //   40: astore_3
    //   41: aload_2
    //   42: new 111	java/lang/StringBuilder
    //   45: dup
    //   46: ldc_w 737
    //   49: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   52: aload_1
    //   53: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokevirtual 740	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   62: aload_2
    //   63: astore 4
    //   65: aload_2
    //   66: astore 5
    //   68: aload_2
    //   69: astore_3
    //   70: new 111	java/lang/StringBuilder
    //   73: dup
    //   74: ldc_w 742
    //   77: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   80: aload 6
    //   82: invokevirtual 744	com/whatsapp/util/bd:b	()J
    //   85: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   88: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   94: aload_2
    //   95: ifnull +14 -> 109
    //   98: aload_2
    //   99: invokevirtual 747	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   102: ifeq +7 -> 109
    //   105: aload_2
    //   106: invokevirtual 748	android/database/sqlite/SQLiteDatabase:close	()V
    //   109: iconst_1
    //   110: ireturn
    //   111: astore_1
    //   112: aload 4
    //   114: astore_3
    //   115: ldc_w 750
    //   118: invokestatic 753	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   121: aload 4
    //   123: ifnull +16 -> 139
    //   126: aload 4
    //   128: invokevirtual 747	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   131: ifeq +8 -> 139
    //   134: aload 4
    //   136: invokevirtual 748	android/database/sqlite/SQLiteDatabase:close	()V
    //   139: iconst_0
    //   140: ireturn
    //   141: astore_3
    //   142: aconst_null
    //   143: astore_2
    //   144: aload_2
    //   145: astore_1
    //   146: new 111	java/lang/StringBuilder
    //   149: dup
    //   150: ldc_w 755
    //   153: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   156: aload_3
    //   157: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 753	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   166: aload_2
    //   167: ifnull -28 -> 139
    //   170: aload_2
    //   171: invokevirtual 747	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   174: ifeq -35 -> 139
    //   177: aload_2
    //   178: invokevirtual 748	android/database/sqlite/SQLiteDatabase:close	()V
    //   181: goto -42 -> 139
    //   184: astore_1
    //   185: aload 5
    //   187: astore_3
    //   188: aload_0
    //   189: getfield 70	com/whatsapp/data/cb:c	Landroid/content/Context;
    //   192: invokestatic 758	a/a/a/a/d:g	(Landroid/content/Context;)V
    //   195: aload 5
    //   197: ifnull -58 -> 139
    //   200: aload 5
    //   202: invokevirtual 747	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   205: ifeq -66 -> 139
    //   208: aload 5
    //   210: invokevirtual 748	android/database/sqlite/SQLiteDatabase:close	()V
    //   213: goto -74 -> 139
    //   216: astore_3
    //   217: aconst_null
    //   218: astore_2
    //   219: aload_2
    //   220: astore_1
    //   221: aload_3
    //   222: invokevirtual 759	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   225: ldc_w 761
    //   228: invokevirtual 321	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   231: ifeq +41 -> 272
    //   234: aload_2
    //   235: astore_1
    //   236: aload_0
    //   237: getfield 70	com/whatsapp/data/cb:c	Landroid/content/Context;
    //   240: aload_0
    //   241: getfield 70	com/whatsapp/data/cb:c	Landroid/content/Context;
    //   244: ldc_w 762
    //   247: invokevirtual 766	android/content/Context:getString	(I)Ljava/lang/String;
    //   250: iconst_2
    //   251: invokestatic 769	a/a/a/a/d:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   254: aload_2
    //   255: ifnull -116 -> 139
    //   258: aload_2
    //   259: invokevirtual 747	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   262: ifeq -123 -> 139
    //   265: aload_2
    //   266: invokevirtual 748	android/database/sqlite/SQLiteDatabase:close	()V
    //   269: goto -130 -> 139
    //   272: aload_2
    //   273: astore_1
    //   274: aload_3
    //   275: invokevirtual 759	android/database/sqlite/SQLiteException:toString	()Ljava/lang/String;
    //   278: ldc_w 771
    //   281: invokevirtual 321	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   284: ifeq -30 -> 254
    //   287: aload_2
    //   288: astore_1
    //   289: aload_0
    //   290: getfield 70	com/whatsapp/data/cb:c	Landroid/content/Context;
    //   293: aload_0
    //   294: getfield 70	com/whatsapp/data/cb:c	Landroid/content/Context;
    //   297: ldc_w 772
    //   300: invokevirtual 766	android/content/Context:getString	(I)Ljava/lang/String;
    //   303: iconst_2
    //   304: invokestatic 769	a/a/a/a/d:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   307: goto -53 -> 254
    //   310: astore_3
    //   311: aload_1
    //   312: astore_2
    //   313: aload_3
    //   314: astore_1
    //   315: aload_2
    //   316: ifnull +14 -> 330
    //   319: aload_2
    //   320: invokevirtual 747	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   323: ifeq +7 -> 330
    //   326: aload_2
    //   327: invokevirtual 748	android/database/sqlite/SQLiteDatabase:close	()V
    //   330: aload_1
    //   331: athrow
    //   332: astore_1
    //   333: aconst_null
    //   334: astore_2
    //   335: goto -20 -> 315
    //   338: astore_1
    //   339: aload_3
    //   340: astore_2
    //   341: goto -26 -> 315
    //   344: astore_3
    //   345: goto -126 -> 219
    //   348: astore_3
    //   349: goto -205 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	352	0	this	cb
    //   0	352	1	paramString	String
    //   32	309	2	localObject1	Object
    //   40	75	3	localObject2	Object
    //   141	16	3	localSQLiteConstraintException1	android.database.sqlite.SQLiteConstraintException
    //   187	1	3	localObject3	Object
    //   216	59	3	localSQLiteException1	android.database.sqlite.SQLiteException
    //   310	30	3	localObject4	Object
    //   344	1	3	localSQLiteException2	android.database.sqlite.SQLiteException
    //   348	1	3	localSQLiteConstraintException2	android.database.sqlite.SQLiteConstraintException
    //   4	131	4	localObject5	Object
    //   1	208	5	localObject6	Object
    //   16	65	6	localbd	bd
    // Exception table:
    //   from	to	target	type
    //   18	33	111	android/database/sqlite/SQLiteDatabaseCorruptException
    //   41	62	111	android/database/sqlite/SQLiteDatabaseCorruptException
    //   70	94	111	android/database/sqlite/SQLiteDatabaseCorruptException
    //   18	33	141	android/database/sqlite/SQLiteConstraintException
    //   18	33	184	android/database/sqlite/SQLiteFullException
    //   41	62	184	android/database/sqlite/SQLiteFullException
    //   70	94	184	android/database/sqlite/SQLiteFullException
    //   18	33	216	android/database/sqlite/SQLiteException
    //   146	166	310	finally
    //   221	234	310	finally
    //   236	254	310	finally
    //   274	287	310	finally
    //   289	307	310	finally
    //   18	33	332	finally
    //   41	62	338	finally
    //   70	94	338	finally
    //   115	121	338	finally
    //   188	195	338	finally
    //   41	62	344	android/database/sqlite/SQLiteException
    //   70	94	344	android/database/sqlite/SQLiteException
    //   41	62	348	android/database/sqlite/SQLiteConstraintException
    //   70	94	348	android/database/sqlite/SQLiteConstraintException
  }
  
  private void i()
  {
    r.b[] arrayOfb = r.b.values();
    int i2 = arrayOfb.length;
    int i1 = 0;
    if (i1 < i2)
    {
      File localFile = b(arrayOfb[i1]);
      if (localFile.exists())
      {
        if (System.currentTimeMillis() - localFile.lastModified() < 604800000L) {
          break label123;
        }
        Log.i("msgstore/backup/too_old " + new Date(localFile.lastModified()));
        Log.i("msgstore/backup/delete " + localFile.getName() + " " + localFile.delete());
      }
      for (;;)
      {
        i1 += 1;
        break;
        label123:
        a.a.a.a.d.c(localFile, "");
      }
    }
  }
  
  private void j()
  {
    r.b[] arrayOfb = r.b.values();
    int i2 = arrayOfb.length;
    int i1 = 0;
    while (i1 < i2)
    {
      a.a.a.a.d.a(b(arrayOfb[i1]), 7, "", false);
      i1 += 1;
    }
    a.a.a.a.d.a(this.g, 7, "", false);
    if ((this.g.exists()) && (System.currentTimeMillis() - this.g.lastModified() > 604800000L)) {
      Log.i("msgstore/backup/basefile_delete " + this.g.delete());
    }
  }
  
  /* Error */
  public final ad.c a(com.whatsapp.gdrive.ch.a<Void, Integer> parama, r.b paramb, Runnable paramRunnable, com.whatsapp.fieldstats.events.l paraml)
  {
    // Byte code:
    //   0: ldc_w 817
    //   3: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   6: aload_0
    //   7: getfield 80	com/whatsapp/data/cb:m	Lcom/whatsapp/vv;
    //   10: invokevirtual 819	com/whatsapp/vv:c	()Z
    //   13: ifeq +13 -> 26
    //   16: ldc_w 821
    //   19: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   22: getstatic 826	com/whatsapp/data/ad$c:b	Lcom/whatsapp/data/ad$c;
    //   25: areturn
    //   26: aload_0
    //   27: getfield 84	com/whatsapp/data/cb:f	Ljava/io/File;
    //   30: invokevirtual 109	java/io/File:exists	()Z
    //   33: ifne +30 -> 63
    //   36: new 111	java/lang/StringBuilder
    //   39: dup
    //   40: ldc_w 828
    //   43: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   46: aload_0
    //   47: getfield 84	com/whatsapp/data/cb:f	Ljava/io/File;
    //   50: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 131	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   59: getstatic 826	com/whatsapp/data/ad$c:b	Lcom/whatsapp/data/ad$c;
    //   62: areturn
    //   63: new 722	com/whatsapp/util/bd
    //   66: dup
    //   67: new 111	java/lang/StringBuilder
    //   70: dup
    //   71: ldc_w 830
    //   74: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: aload_2
    //   78: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokespecial 725	com/whatsapp/util/bd:<init>	(Ljava/lang/String;)V
    //   87: astore 20
    //   89: aload_0
    //   90: aload_2
    //   91: invokespecial 778	com/whatsapp/data/cb:b	(Lcom/whatsapp/util/r$b;)Ljava/io/File;
    //   94: invokevirtual 833	java/io/File:getParentFile	()Ljava/io/File;
    //   97: astore 11
    //   99: aload 11
    //   101: invokevirtual 109	java/io/File:exists	()Z
    //   104: ifne +23 -> 127
    //   107: ldc_w 835
    //   110: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   113: aload 11
    //   115: invokevirtual 838	java/io/File:mkdirs	()Z
    //   118: ifne +9 -> 127
    //   121: ldc_w 840
    //   124: invokestatic 753	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   127: aload_0
    //   128: invokespecial 842	com/whatsapp/data/cb:i	()V
    //   131: aload 4
    //   133: aload_2
    //   134: getfield 159	com/whatsapp/util/r$b:m	I
    //   137: i2l
    //   138: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   141: putfield 845	com/whatsapp/fieldstats/events/l:b	Ljava/lang/Long;
    //   144: aconst_null
    //   145: astore 17
    //   147: aconst_null
    //   148: astore 18
    //   150: aconst_null
    //   151: astore 14
    //   153: aconst_null
    //   154: astore 15
    //   156: aconst_null
    //   157: astore 19
    //   159: aconst_null
    //   160: astore 16
    //   162: aconst_null
    //   163: astore 13
    //   165: aload 19
    //   167: astore 11
    //   169: aload 18
    //   171: astore 12
    //   173: aload_0
    //   174: getfield 84	com/whatsapp/data/cb:f	Ljava/io/File;
    //   177: invokevirtual 142	java/io/File:length	()J
    //   180: lstore 7
    //   182: aload 19
    //   184: astore 11
    //   186: aload 18
    //   188: astore 12
    //   190: aload 4
    //   192: lload 7
    //   194: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   197: putfield 847	com/whatsapp/fieldstats/events/l:c	Ljava/lang/Long;
    //   200: aload 19
    //   202: astore 11
    //   204: aload 18
    //   206: astore 12
    //   208: new 111	java/lang/StringBuilder
    //   211: dup
    //   212: ldc_w 849
    //   215: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   218: lload 7
    //   220: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   229: aload 19
    //   231: astore 11
    //   233: aload 18
    //   235: astore 12
    //   237: invokestatic 406	com/whatsapp/r:n	()Lcom/whatsapp/r$b;
    //   240: astore 24
    //   242: aload 24
    //   244: ifnonnull +199 -> 443
    //   247: aload 19
    //   249: astore 11
    //   251: aload 18
    //   253: astore 12
    //   255: ldc_w 851
    //   258: invokestatic 753	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   261: aload 19
    //   263: astore 11
    //   265: aload 18
    //   267: astore 12
    //   269: getstatic 826	com/whatsapp/data/ad$c:b	Lcom/whatsapp/data/ad$c;
    //   272: astore_1
    //   273: aconst_null
    //   274: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   277: aconst_null
    //   278: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   281: aload 20
    //   283: invokevirtual 744	com/whatsapp/util/bd:b	()J
    //   286: lstore 7
    //   288: aload_0
    //   289: getfield 72	com/whatsapp/data/cb:i	Lcom/whatsapp/pv;
    //   292: getstatic 857	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   295: ldc_w 859
    //   298: iconst_1
    //   299: anewarray 4	java/lang/Object
    //   302: dup
    //   303: iconst_0
    //   304: lload 7
    //   306: l2d
    //   307: ldc2_w 860
    //   310: ddiv
    //   311: invokestatic 642	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   314: aastore
    //   315: invokestatic 865	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   318: invokevirtual 869	com/whatsapp/pv:a	(Ljava/lang/String;)V
    //   321: new 111	java/lang/StringBuilder
    //   324: dup
    //   325: ldc_w 871
    //   328: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   331: lload 7
    //   333: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   336: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   342: aload_1
    //   343: areturn
    //   344: astore_1
    //   345: aload 19
    //   347: astore 11
    //   349: aload 18
    //   351: astore 12
    //   353: ldc_w 873
    //   356: aload_1
    //   357: invokestatic 243	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   360: aload 19
    //   362: astore 11
    //   364: aload 18
    //   366: astore 12
    //   368: getstatic 826	com/whatsapp/data/ad$c:b	Lcom/whatsapp/data/ad$c;
    //   371: astore_1
    //   372: aconst_null
    //   373: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   376: aconst_null
    //   377: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   380: aload 20
    //   382: invokevirtual 744	com/whatsapp/util/bd:b	()J
    //   385: lstore 7
    //   387: aload_0
    //   388: getfield 72	com/whatsapp/data/cb:i	Lcom/whatsapp/pv;
    //   391: getstatic 857	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   394: ldc_w 859
    //   397: iconst_1
    //   398: anewarray 4	java/lang/Object
    //   401: dup
    //   402: iconst_0
    //   403: lload 7
    //   405: l2d
    //   406: ldc2_w 860
    //   409: ddiv
    //   410: invokestatic 642	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   413: aastore
    //   414: invokestatic 865	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   417: invokevirtual 869	com/whatsapp/pv:a	(Ljava/lang/String;)V
    //   420: new 111	java/lang/StringBuilder
    //   423: dup
    //   424: ldc_w 871
    //   427: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   430: lload 7
    //   432: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   435: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   441: aload_1
    //   442: areturn
    //   443: aload 19
    //   445: astore 11
    //   447: aload 18
    //   449: astore 12
    //   451: aload_0
    //   452: aload_0
    //   453: getfield 84	com/whatsapp/data/cb:f	Ljava/io/File;
    //   456: lload 7
    //   458: invokespecial 875	com/whatsapp/data/cb:a	(Ljava/io/File;J)Ljava/io/File;
    //   461: astore 21
    //   463: aload_3
    //   464: ifnull +51 -> 515
    //   467: aload 19
    //   469: astore 11
    //   471: aload 18
    //   473: astore 12
    //   475: aload_0
    //   476: getfield 84	com/whatsapp/data/cb:f	Ljava/io/File;
    //   479: aload 21
    //   481: invokevirtual 876	java/io/File:equals	(Ljava/lang/Object;)Z
    //   484: ifne +31 -> 515
    //   487: aload 19
    //   489: astore 11
    //   491: aload 18
    //   493: astore 12
    //   495: ldc_w 878
    //   498: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   501: aload 19
    //   503: astore 11
    //   505: aload 18
    //   507: astore 12
    //   509: aload_3
    //   510: invokeinterface 883 1 0
    //   515: aload 19
    //   517: astore 11
    //   519: aload 18
    //   521: astore 12
    //   523: aload_0
    //   524: aload_2
    //   525: invokespecial 778	com/whatsapp/data/cb:b	(Lcom/whatsapp/util/r$b;)Ljava/io/File;
    //   528: astore 22
    //   530: aload 19
    //   532: astore 11
    //   534: aload 18
    //   536: astore 12
    //   538: aload_0
    //   539: getfield 80	com/whatsapp/data/cb:m	Lcom/whatsapp/vv;
    //   542: invokevirtual 884	com/whatsapp/vv:b	()Ljava/io/File;
    //   545: astore 23
    //   547: aload 19
    //   549: astore 11
    //   551: aload 18
    //   553: astore 12
    //   555: new 111	java/lang/StringBuilder
    //   558: dup
    //   559: ldc_w 886
    //   562: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   565: aload 22
    //   567: invokevirtual 134	java/io/File:getName	()Ljava/lang/String;
    //   570: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   579: aload 19
    //   581: astore 11
    //   583: aload 18
    //   585: astore 12
    //   587: aload_0
    //   588: getfield 76	com/whatsapp/data/cb:k	Lcom/whatsapp/va;
    //   591: astore 25
    //   593: aload 19
    //   595: astore 11
    //   597: aload 18
    //   599: astore 12
    //   601: new 888	java/io/FileOutputStream
    //   604: dup
    //   605: aload 23
    //   607: invokespecial 889	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   610: astore_3
    //   611: aload 19
    //   613: astore 11
    //   615: aload 18
    //   617: astore 12
    //   619: aload_2
    //   620: getfield 159	com/whatsapp/util/r$b:m	I
    //   623: istore 5
    //   625: aload 19
    //   627: astore 11
    //   629: aload 18
    //   631: astore 12
    //   633: getstatic 282	com/whatsapp/util/r$b:j	Lcom/whatsapp/util/r$b;
    //   636: getfield 159	com/whatsapp/util/r$b:m	I
    //   639: istore 6
    //   641: iload 5
    //   643: iload 6
    //   645: if_icmpge +275 -> 920
    //   648: aload_3
    //   649: astore 11
    //   651: new 274	java/io/FileInputStream
    //   654: dup
    //   655: aload 21
    //   657: invokespecial 277	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   660: astore_3
    //   661: aload 11
    //   663: aload 24
    //   665: invokestatic 892	com/whatsapp/r:a	(Ljava/io/OutputStream;Lcom/whatsapp/r$b;)V
    //   668: invokestatic 379	com/whatsapp/util/r:a	()Lcom/whatsapp/util/r;
    //   671: aload 11
    //   673: aload_2
    //   674: aload 24
    //   676: getfield 895	com/whatsapp/r$b:c	[B
    //   679: aload 24
    //   681: getfield 898	com/whatsapp/r$b:a	Lcom/whatsapp/r$a;
    //   684: getfield 366	com/whatsapp/r$a:e	[B
    //   687: invokevirtual 901	com/whatsapp/util/r:a	(Ljava/io/OutputStream;Lcom/whatsapp/util/r$b;[B[B)Ljava/io/OutputStream;
    //   690: astore 12
    //   692: ldc_w 903
    //   695: invokestatic 477	com/whatsapp/k/c:a	(Ljava/lang/String;)Lcom/whatsapp/k/d;
    //   698: astore 11
    //   700: aload 11
    //   702: invokeinterface 481 1 0
    //   707: aload 11
    //   709: getstatic 486	com/whatsapp/k/d$b:b	Lcom/whatsapp/k/d$b;
    //   712: lload 7
    //   714: l2i
    //   715: invokeinterface 489 3 0
    //   720: aload_3
    //   721: lload 7
    //   723: aload 12
    //   725: aload_1
    //   726: invokestatic 905	com/whatsapp/data/cb:a	(Ljava/io/InputStream;JLjava/io/OutputStream;Lcom/whatsapp/gdrive/ch$a;)V
    //   729: aload 11
    //   731: invokeinterface 498 1 0
    //   736: aload 12
    //   738: invokevirtual 389	java/io/OutputStream:close	()V
    //   741: aload 22
    //   743: invokevirtual 507	java/io/File:delete	()Z
    //   746: pop
    //   747: aload_0
    //   748: getfield 84	com/whatsapp/data/cb:f	Ljava/io/File;
    //   751: aload 21
    //   753: invokevirtual 876	java/io/File:equals	(Ljava/lang/Object;)Z
    //   756: ifne +9 -> 765
    //   759: aload 21
    //   761: invokevirtual 507	java/io/File:delete	()Z
    //   764: pop
    //   765: aload 23
    //   767: aload 22
    //   769: invokevirtual 908	java/io/File:renameTo	(Ljava/io/File;)Z
    //   772: ifne +314 -> 1086
    //   775: new 245	java/io/IOException
    //   778: dup
    //   779: ldc_w 910
    //   782: invokespecial 911	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   785: athrow
    //   786: astore_1
    //   787: aconst_null
    //   788: astore_2
    //   789: aload_3
    //   790: astore 11
    //   792: aload_2
    //   793: astore 12
    //   795: ldc_w 913
    //   798: aload_1
    //   799: invokestatic 336	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   802: aload_3
    //   803: astore 11
    //   805: aload_2
    //   806: astore 12
    //   808: aload_0
    //   809: getfield 74	com/whatsapp/data/cb:j	Lcom/whatsapp/util/a/c;
    //   812: new 111	java/lang/StringBuilder
    //   815: dup
    //   816: ldc_w 915
    //   819: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   822: aload_1
    //   823: invokevirtual 916	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   826: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: iconst_0
    //   833: aconst_null
    //   834: bipush 7
    //   836: invokevirtual 308	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   839: aload_3
    //   840: astore 11
    //   842: aload_2
    //   843: astore 12
    //   845: getstatic 826	com/whatsapp/data/ad$c:b	Lcom/whatsapp/data/ad$c;
    //   848: astore_1
    //   849: aload_3
    //   850: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   853: aload_2
    //   854: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   857: aload 20
    //   859: invokevirtual 744	com/whatsapp/util/bd:b	()J
    //   862: lstore 7
    //   864: aload_0
    //   865: getfield 72	com/whatsapp/data/cb:i	Lcom/whatsapp/pv;
    //   868: getstatic 857	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   871: ldc_w 859
    //   874: iconst_1
    //   875: anewarray 4	java/lang/Object
    //   878: dup
    //   879: iconst_0
    //   880: lload 7
    //   882: l2d
    //   883: ldc2_w 860
    //   886: ddiv
    //   887: invokestatic 642	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   890: aastore
    //   891: invokestatic 865	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   894: invokevirtual 869	com/whatsapp/pv:a	(Ljava/lang/String;)V
    //   897: new 111	java/lang/StringBuilder
    //   900: dup
    //   901: ldc_w 871
    //   904: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   907: lload 7
    //   909: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   912: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   915: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   918: aload_1
    //   919: areturn
    //   920: aload 19
    //   922: astore 11
    //   924: aload 18
    //   926: astore 12
    //   928: aload_2
    //   929: getfield 159	com/whatsapp/util/r$b:m	I
    //   932: getstatic 343	com/whatsapp/util/r$b:l	Lcom/whatsapp/util/r$b;
    //   935: getfield 159	com/whatsapp/util/r$b:m	I
    //   938: if_icmpgt +93 -> 1031
    //   941: aload 19
    //   943: astore 11
    //   945: aload 18
    //   947: astore 12
    //   949: aload_2
    //   950: invokestatic 919	a/a/a/a/d:a	(Lcom/whatsapp/util/r$b;)Ljava/security/MessageDigest;
    //   953: astore 26
    //   955: aload 19
    //   957: astore 11
    //   959: aload 18
    //   961: astore 12
    //   963: new 111	java/lang/StringBuilder
    //   966: dup
    //   967: ldc_w 921
    //   970: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   973: aload 26
    //   975: invokevirtual 927	java/security/MessageDigest:digest	()[B
    //   978: invokestatic 930	com/whatsapp/r:c	([B)Ljava/lang/String;
    //   981: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   987: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   990: aload 19
    //   992: astore 11
    //   994: aload 18
    //   996: astore 12
    //   998: aload 26
    //   1000: invokevirtual 933	java/security/MessageDigest:reset	()V
    //   1003: aload 19
    //   1005: astore 11
    //   1007: aload 18
    //   1009: astore 12
    //   1011: new 935	com/whatsapp/data/cd
    //   1014: dup
    //   1015: aload_3
    //   1016: aload 26
    //   1018: aload 25
    //   1020: aload_2
    //   1021: invokespecial 938	com/whatsapp/data/cd:<init>	(Ljava/io/OutputStream;Ljava/security/MessageDigest;Lcom/whatsapp/va;Lcom/whatsapp/util/r$b;)V
    //   1024: astore_3
    //   1025: aload_3
    //   1026: astore 11
    //   1028: goto -377 -> 651
    //   1031: aload 19
    //   1033: astore 11
    //   1035: aload 18
    //   1037: astore 12
    //   1039: new 111	java/lang/StringBuilder
    //   1042: dup
    //   1043: ldc_w 940
    //   1046: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1049: aload_2
    //   1050: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1053: ldc_w 357
    //   1056: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: aload 23
    //   1061: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1064: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1067: invokestatic 131	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1070: aload_3
    //   1071: astore 11
    //   1073: goto -422 -> 651
    //   1076: astore_1
    //   1077: aload 13
    //   1079: astore_3
    //   1080: aload 14
    //   1082: astore_2
    //   1083: goto -294 -> 789
    //   1086: new 111	java/lang/StringBuilder
    //   1089: dup
    //   1090: ldc_w 942
    //   1093: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1096: aload 22
    //   1098: invokevirtual 142	java/io/File:length	()J
    //   1101: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1104: ldc_w 944
    //   1107: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1110: aload 22
    //   1112: invokevirtual 786	java/io/File:lastModified	()J
    //   1115: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1118: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1121: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1124: aload 22
    //   1126: invokevirtual 142	java/io/File:length	()J
    //   1129: lstore 9
    //   1131: lload 9
    //   1133: lconst_0
    //   1134: lcmp
    //   1135: ifle +18 -> 1153
    //   1138: aload 4
    //   1140: lload 7
    //   1142: l2d
    //   1143: lload 9
    //   1145: l2d
    //   1146: ddiv
    //   1147: invokestatic 642	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1150: putfield 947	com/whatsapp/fieldstats/events/l:d	Ljava/lang/Double;
    //   1153: aload_0
    //   1154: getfield 76	com/whatsapp/data/cb:k	Lcom/whatsapp/va;
    //   1157: aload_2
    //   1158: aload 22
    //   1160: invokestatic 255	a/a/a/a/d:a	(Lcom/whatsapp/va;Lcom/whatsapp/util/r$b;Ljava/io/File;)Lcom/whatsapp/data/cg;
    //   1163: getfield 268	com/whatsapp/data/cg:a	I
    //   1166: iconst_1
    //   1167: if_icmpeq +112 -> 1279
    //   1170: ldc_w 949
    //   1173: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1176: aload_0
    //   1177: getfield 74	com/whatsapp/data/cb:j	Lcom/whatsapp/util/a/c;
    //   1180: new 111	java/lang/StringBuilder
    //   1183: dup
    //   1184: ldc_w 951
    //   1187: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1190: aload_2
    //   1191: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1194: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1197: iconst_0
    //   1198: aconst_null
    //   1199: bipush 7
    //   1201: invokevirtual 308	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   1204: getstatic 953	com/whatsapp/data/ad$c:d	Lcom/whatsapp/data/ad$c;
    //   1207: astore_1
    //   1208: aload_3
    //   1209: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1212: aconst_null
    //   1213: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1216: aload 20
    //   1218: invokevirtual 744	com/whatsapp/util/bd:b	()J
    //   1221: lstore 7
    //   1223: aload_0
    //   1224: getfield 72	com/whatsapp/data/cb:i	Lcom/whatsapp/pv;
    //   1227: getstatic 857	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   1230: ldc_w 859
    //   1233: iconst_1
    //   1234: anewarray 4	java/lang/Object
    //   1237: dup
    //   1238: iconst_0
    //   1239: lload 7
    //   1241: l2d
    //   1242: ldc2_w 860
    //   1245: ddiv
    //   1246: invokestatic 642	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1249: aastore
    //   1250: invokestatic 865	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1253: invokevirtual 869	com/whatsapp/pv:a	(Ljava/lang/String;)V
    //   1256: new 111	java/lang/StringBuilder
    //   1259: dup
    //   1260: ldc_w 871
    //   1263: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1266: lload 7
    //   1268: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1271: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1274: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1277: aload_1
    //   1278: areturn
    //   1279: aload_0
    //   1280: invokespecial 955	com/whatsapp/data/cb:j	()V
    //   1283: aload_3
    //   1284: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1287: aconst_null
    //   1288: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1291: aload 20
    //   1293: invokevirtual 744	com/whatsapp/util/bd:b	()J
    //   1296: lstore 7
    //   1298: aload_0
    //   1299: getfield 72	com/whatsapp/data/cb:i	Lcom/whatsapp/pv;
    //   1302: getstatic 857	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   1305: ldc_w 859
    //   1308: iconst_1
    //   1309: anewarray 4	java/lang/Object
    //   1312: dup
    //   1313: iconst_0
    //   1314: lload 7
    //   1316: l2d
    //   1317: ldc2_w 860
    //   1320: ddiv
    //   1321: invokestatic 642	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1324: aastore
    //   1325: invokestatic 865	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1328: invokevirtual 869	com/whatsapp/pv:a	(Ljava/lang/String;)V
    //   1331: new 111	java/lang/StringBuilder
    //   1334: dup
    //   1335: ldc_w 871
    //   1338: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1341: lload 7
    //   1343: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1346: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1349: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1352: getstatic 957	com/whatsapp/data/ad$c:a	Lcom/whatsapp/data/ad$c;
    //   1355: areturn
    //   1356: astore_2
    //   1357: aload 17
    //   1359: astore_1
    //   1360: aload 15
    //   1362: astore_3
    //   1363: aload_3
    //   1364: astore 11
    //   1366: aload_1
    //   1367: astore 12
    //   1369: invokestatic 500	com/whatsapp/vv:f	()J
    //   1372: lconst_0
    //   1373: lcmp
    //   1374: ifne +96 -> 1470
    //   1377: aload_3
    //   1378: astore 11
    //   1380: aload_1
    //   1381: astore 12
    //   1383: ldc_w 959
    //   1386: invokestatic 753	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1389: aload_3
    //   1390: astore 11
    //   1392: aload_1
    //   1393: astore 12
    //   1395: getstatic 961	com/whatsapp/data/ad$c:c	Lcom/whatsapp/data/ad$c;
    //   1398: astore_2
    //   1399: aload_3
    //   1400: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1403: aload_1
    //   1404: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1407: aload 20
    //   1409: invokevirtual 744	com/whatsapp/util/bd:b	()J
    //   1412: lstore 7
    //   1414: aload_0
    //   1415: getfield 72	com/whatsapp/data/cb:i	Lcom/whatsapp/pv;
    //   1418: getstatic 857	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   1421: ldc_w 859
    //   1424: iconst_1
    //   1425: anewarray 4	java/lang/Object
    //   1428: dup
    //   1429: iconst_0
    //   1430: lload 7
    //   1432: l2d
    //   1433: ldc2_w 860
    //   1436: ddiv
    //   1437: invokestatic 642	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1440: aastore
    //   1441: invokestatic 865	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1444: invokevirtual 869	com/whatsapp/pv:a	(Ljava/lang/String;)V
    //   1447: new 111	java/lang/StringBuilder
    //   1450: dup
    //   1451: ldc_w 871
    //   1454: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1457: lload 7
    //   1459: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1462: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1465: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1468: aload_2
    //   1469: areturn
    //   1470: aload_3
    //   1471: astore 11
    //   1473: aload_1
    //   1474: astore 12
    //   1476: aload_2
    //   1477: athrow
    //   1478: astore_1
    //   1479: aload 12
    //   1481: astore_3
    //   1482: aload 11
    //   1484: astore_2
    //   1485: aload_2
    //   1486: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1489: aload_3
    //   1490: invokestatic 299	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1493: aload 20
    //   1495: invokevirtual 744	com/whatsapp/util/bd:b	()J
    //   1498: lstore 7
    //   1500: aload_0
    //   1501: getfield 72	com/whatsapp/data/cb:i	Lcom/whatsapp/pv;
    //   1504: getstatic 857	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   1507: ldc_w 859
    //   1510: iconst_1
    //   1511: anewarray 4	java/lang/Object
    //   1514: dup
    //   1515: iconst_0
    //   1516: lload 7
    //   1518: l2d
    //   1519: ldc2_w 860
    //   1522: ddiv
    //   1523: invokestatic 642	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1526: aastore
    //   1527: invokestatic 865	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   1530: invokevirtual 869	com/whatsapp/pv:a	(Ljava/lang/String;)V
    //   1533: new 111	java/lang/StringBuilder
    //   1536: dup
    //   1537: ldc_w 871
    //   1540: invokespecial 116	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1543: lload 7
    //   1545: invokevirtual 145	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1548: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1551: invokestatic 147	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1554: aload_1
    //   1555: athrow
    //   1556: astore_1
    //   1557: aload 11
    //   1559: astore_3
    //   1560: aload 16
    //   1562: astore_2
    //   1563: goto -78 -> 1485
    //   1566: astore_1
    //   1567: aload_3
    //   1568: astore_2
    //   1569: aload 11
    //   1571: astore_3
    //   1572: goto -87 -> 1485
    //   1575: astore_1
    //   1576: aload_3
    //   1577: astore_2
    //   1578: aload 12
    //   1580: astore_3
    //   1581: goto -96 -> 1485
    //   1584: astore_1
    //   1585: aconst_null
    //   1586: astore 4
    //   1588: aload_3
    //   1589: astore_2
    //   1590: aload 4
    //   1592: astore_3
    //   1593: goto -108 -> 1485
    //   1596: astore_2
    //   1597: aload 11
    //   1599: astore_1
    //   1600: aload 15
    //   1602: astore_3
    //   1603: goto -240 -> 1363
    //   1606: astore_2
    //   1607: aload 11
    //   1609: astore_1
    //   1610: goto -247 -> 1363
    //   1613: astore_2
    //   1614: aload 12
    //   1616: astore_1
    //   1617: goto -254 -> 1363
    //   1620: astore_2
    //   1621: aconst_null
    //   1622: astore_1
    //   1623: goto -260 -> 1363
    //   1626: astore_1
    //   1627: aload 13
    //   1629: astore_3
    //   1630: aload 14
    //   1632: astore_2
    //   1633: goto -844 -> 789
    //   1636: astore_1
    //   1637: aload 11
    //   1639: astore_2
    //   1640: aload 13
    //   1642: astore_3
    //   1643: goto -854 -> 789
    //   1646: astore_1
    //   1647: aload 11
    //   1649: astore_2
    //   1650: goto -861 -> 789
    //   1653: astore_1
    //   1654: aload 12
    //   1656: astore_2
    //   1657: goto -868 -> 789
    //   1660: astore_1
    //   1661: aconst_null
    //   1662: astore_2
    //   1663: goto -874 -> 789
    //   1666: astore_1
    //   1667: aload 11
    //   1669: astore_2
    //   1670: aload 13
    //   1672: astore_3
    //   1673: goto -884 -> 789
    //   1676: astore_1
    //   1677: aload 11
    //   1679: astore_2
    //   1680: goto -891 -> 789
    //   1683: astore_1
    //   1684: aload 12
    //   1686: astore_2
    //   1687: goto -898 -> 789
    //   1690: astore_1
    //   1691: aload 13
    //   1693: astore_3
    //   1694: aload 14
    //   1696: astore_2
    //   1697: goto -908 -> 789
    //   1700: astore_1
    //   1701: aload 11
    //   1703: astore_2
    //   1704: aload 13
    //   1706: astore_3
    //   1707: goto -918 -> 789
    //   1710: astore_1
    //   1711: aload 11
    //   1713: astore_2
    //   1714: goto -925 -> 789
    //   1717: astore_1
    //   1718: aload 12
    //   1720: astore_2
    //   1721: goto -932 -> 789
    //   1724: astore_1
    //   1725: aconst_null
    //   1726: astore_2
    //   1727: goto -938 -> 789
    //   1730: astore_1
    //   1731: aload 13
    //   1733: astore_3
    //   1734: aload 14
    //   1736: astore_2
    //   1737: goto -948 -> 789
    //   1740: astore_1
    //   1741: aload 11
    //   1743: astore_2
    //   1744: aload 13
    //   1746: astore_3
    //   1747: goto -958 -> 789
    //   1750: astore_1
    //   1751: aload 11
    //   1753: astore_2
    //   1754: goto -965 -> 789
    //   1757: astore_1
    //   1758: aload 12
    //   1760: astore_2
    //   1761: goto -972 -> 789
    //   1764: astore_1
    //   1765: aconst_null
    //   1766: astore_2
    //   1767: goto -978 -> 789
    //   1770: astore_1
    //   1771: aload 13
    //   1773: astore_3
    //   1774: aload 14
    //   1776: astore_2
    //   1777: goto -988 -> 789
    //   1780: astore_1
    //   1781: aload 11
    //   1783: astore_2
    //   1784: aload 13
    //   1786: astore_3
    //   1787: goto -998 -> 789
    //   1790: astore_1
    //   1791: aload 11
    //   1793: astore_2
    //   1794: goto -1005 -> 789
    //   1797: astore_1
    //   1798: aload 12
    //   1800: astore_2
    //   1801: goto -1012 -> 789
    //   1804: astore_1
    //   1805: aconst_null
    //   1806: astore_2
    //   1807: goto -1018 -> 789
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1810	0	this	cb
    //   0	1810	1	parama	com.whatsapp.gdrive.ch.a<Void, Integer>
    //   0	1810	2	paramb	r.b
    //   0	1810	3	paramRunnable	Runnable
    //   0	1810	4	paraml	com.whatsapp.fieldstats.events.l
    //   623	23	5	i1	int
    //   639	7	6	i2	int
    //   180	1364	7	l1	long
    //   1129	15	9	l2	long
    //   97	1695	11	localObject1	Object
    //   171	1628	12	localObject2	Object
    //   163	1622	13	localObject3	Object
    //   151	1624	14	localObject4	Object
    //   154	1447	15	localObject5	Object
    //   160	1401	16	localObject6	Object
    //   145	1213	17	localObject7	Object
    //   148	888	18	localObject8	Object
    //   157	875	19	localObject9	Object
    //   87	1407	20	localbd	bd
    //   461	299	21	localFile1	File
    //   528	631	22	localFile2	File
    //   545	515	23	localFile3	File
    //   240	440	24	localb	com.whatsapp.r.b
    //   591	428	25	localva	va
    //   953	64	26	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   237	242	344	java/lang/Exception
    //   255	261	344	java/lang/Exception
    //   269	273	344	java/lang/Exception
    //   741	765	786	java/security/InvalidAlgorithmParameterException
    //   765	786	786	java/security/InvalidAlgorithmParameterException
    //   1086	1131	786	java/security/InvalidAlgorithmParameterException
    //   1138	1153	786	java/security/InvalidAlgorithmParameterException
    //   1153	1208	786	java/security/InvalidAlgorithmParameterException
    //   1279	1283	786	java/security/InvalidAlgorithmParameterException
    //   173	182	1076	java/security/InvalidAlgorithmParameterException
    //   190	200	1076	java/security/InvalidAlgorithmParameterException
    //   208	229	1076	java/security/InvalidAlgorithmParameterException
    //   237	242	1076	java/security/InvalidAlgorithmParameterException
    //   255	261	1076	java/security/InvalidAlgorithmParameterException
    //   269	273	1076	java/security/InvalidAlgorithmParameterException
    //   353	360	1076	java/security/InvalidAlgorithmParameterException
    //   368	372	1076	java/security/InvalidAlgorithmParameterException
    //   451	463	1076	java/security/InvalidAlgorithmParameterException
    //   475	487	1076	java/security/InvalidAlgorithmParameterException
    //   495	501	1076	java/security/InvalidAlgorithmParameterException
    //   509	515	1076	java/security/InvalidAlgorithmParameterException
    //   523	530	1076	java/security/InvalidAlgorithmParameterException
    //   538	547	1076	java/security/InvalidAlgorithmParameterException
    //   555	579	1076	java/security/InvalidAlgorithmParameterException
    //   587	593	1076	java/security/InvalidAlgorithmParameterException
    //   601	611	1076	java/security/InvalidAlgorithmParameterException
    //   619	625	1076	java/security/InvalidAlgorithmParameterException
    //   633	641	1076	java/security/InvalidAlgorithmParameterException
    //   928	941	1076	java/security/InvalidAlgorithmParameterException
    //   949	955	1076	java/security/InvalidAlgorithmParameterException
    //   963	990	1076	java/security/InvalidAlgorithmParameterException
    //   998	1003	1076	java/security/InvalidAlgorithmParameterException
    //   1011	1025	1076	java/security/InvalidAlgorithmParameterException
    //   1039	1070	1076	java/security/InvalidAlgorithmParameterException
    //   173	182	1356	java/io/IOException
    //   190	200	1356	java/io/IOException
    //   208	229	1356	java/io/IOException
    //   237	242	1356	java/io/IOException
    //   255	261	1356	java/io/IOException
    //   269	273	1356	java/io/IOException
    //   353	360	1356	java/io/IOException
    //   368	372	1356	java/io/IOException
    //   451	463	1356	java/io/IOException
    //   475	487	1356	java/io/IOException
    //   495	501	1356	java/io/IOException
    //   509	515	1356	java/io/IOException
    //   523	530	1356	java/io/IOException
    //   538	547	1356	java/io/IOException
    //   555	579	1356	java/io/IOException
    //   587	593	1356	java/io/IOException
    //   601	611	1356	java/io/IOException
    //   619	625	1356	java/io/IOException
    //   633	641	1356	java/io/IOException
    //   928	941	1356	java/io/IOException
    //   949	955	1356	java/io/IOException
    //   963	990	1356	java/io/IOException
    //   998	1003	1356	java/io/IOException
    //   1011	1025	1356	java/io/IOException
    //   1039	1070	1356	java/io/IOException
    //   173	182	1478	finally
    //   190	200	1478	finally
    //   208	229	1478	finally
    //   237	242	1478	finally
    //   255	261	1478	finally
    //   269	273	1478	finally
    //   353	360	1478	finally
    //   368	372	1478	finally
    //   451	463	1478	finally
    //   475	487	1478	finally
    //   495	501	1478	finally
    //   509	515	1478	finally
    //   523	530	1478	finally
    //   538	547	1478	finally
    //   555	579	1478	finally
    //   587	593	1478	finally
    //   601	611	1478	finally
    //   619	625	1478	finally
    //   633	641	1478	finally
    //   795	802	1478	finally
    //   808	839	1478	finally
    //   845	849	1478	finally
    //   928	941	1478	finally
    //   949	955	1478	finally
    //   963	990	1478	finally
    //   998	1003	1478	finally
    //   1011	1025	1478	finally
    //   1039	1070	1478	finally
    //   1369	1377	1478	finally
    //   1383	1389	1478	finally
    //   1395	1399	1478	finally
    //   1476	1478	1478	finally
    //   651	661	1556	finally
    //   661	692	1566	finally
    //   692	741	1575	finally
    //   741	765	1584	finally
    //   765	786	1584	finally
    //   1086	1131	1584	finally
    //   1138	1153	1584	finally
    //   1153	1208	1584	finally
    //   1279	1283	1584	finally
    //   651	661	1596	java/io/IOException
    //   661	692	1606	java/io/IOException
    //   692	741	1613	java/io/IOException
    //   741	765	1620	java/io/IOException
    //   765	786	1620	java/io/IOException
    //   1086	1131	1620	java/io/IOException
    //   1138	1153	1620	java/io/IOException
    //   1153	1208	1620	java/io/IOException
    //   1279	1283	1620	java/io/IOException
    //   173	182	1626	java/security/NoSuchAlgorithmException
    //   190	200	1626	java/security/NoSuchAlgorithmException
    //   208	229	1626	java/security/NoSuchAlgorithmException
    //   237	242	1626	java/security/NoSuchAlgorithmException
    //   255	261	1626	java/security/NoSuchAlgorithmException
    //   269	273	1626	java/security/NoSuchAlgorithmException
    //   353	360	1626	java/security/NoSuchAlgorithmException
    //   368	372	1626	java/security/NoSuchAlgorithmException
    //   451	463	1626	java/security/NoSuchAlgorithmException
    //   475	487	1626	java/security/NoSuchAlgorithmException
    //   495	501	1626	java/security/NoSuchAlgorithmException
    //   509	515	1626	java/security/NoSuchAlgorithmException
    //   523	530	1626	java/security/NoSuchAlgorithmException
    //   538	547	1626	java/security/NoSuchAlgorithmException
    //   555	579	1626	java/security/NoSuchAlgorithmException
    //   587	593	1626	java/security/NoSuchAlgorithmException
    //   601	611	1626	java/security/NoSuchAlgorithmException
    //   619	625	1626	java/security/NoSuchAlgorithmException
    //   633	641	1626	java/security/NoSuchAlgorithmException
    //   928	941	1626	java/security/NoSuchAlgorithmException
    //   949	955	1626	java/security/NoSuchAlgorithmException
    //   963	990	1626	java/security/NoSuchAlgorithmException
    //   998	1003	1626	java/security/NoSuchAlgorithmException
    //   1011	1025	1626	java/security/NoSuchAlgorithmException
    //   1039	1070	1626	java/security/NoSuchAlgorithmException
    //   651	661	1636	java/security/NoSuchAlgorithmException
    //   661	692	1646	java/security/NoSuchAlgorithmException
    //   692	741	1653	java/security/NoSuchAlgorithmException
    //   741	765	1660	java/security/NoSuchAlgorithmException
    //   765	786	1660	java/security/NoSuchAlgorithmException
    //   1086	1131	1660	java/security/NoSuchAlgorithmException
    //   1138	1153	1660	java/security/NoSuchAlgorithmException
    //   1153	1208	1660	java/security/NoSuchAlgorithmException
    //   1279	1283	1660	java/security/NoSuchAlgorithmException
    //   651	661	1666	java/security/InvalidAlgorithmParameterException
    //   661	692	1676	java/security/InvalidAlgorithmParameterException
    //   692	741	1683	java/security/InvalidAlgorithmParameterException
    //   173	182	1690	javax/crypto/NoSuchPaddingException
    //   190	200	1690	javax/crypto/NoSuchPaddingException
    //   208	229	1690	javax/crypto/NoSuchPaddingException
    //   237	242	1690	javax/crypto/NoSuchPaddingException
    //   255	261	1690	javax/crypto/NoSuchPaddingException
    //   269	273	1690	javax/crypto/NoSuchPaddingException
    //   353	360	1690	javax/crypto/NoSuchPaddingException
    //   368	372	1690	javax/crypto/NoSuchPaddingException
    //   451	463	1690	javax/crypto/NoSuchPaddingException
    //   475	487	1690	javax/crypto/NoSuchPaddingException
    //   495	501	1690	javax/crypto/NoSuchPaddingException
    //   509	515	1690	javax/crypto/NoSuchPaddingException
    //   523	530	1690	javax/crypto/NoSuchPaddingException
    //   538	547	1690	javax/crypto/NoSuchPaddingException
    //   555	579	1690	javax/crypto/NoSuchPaddingException
    //   587	593	1690	javax/crypto/NoSuchPaddingException
    //   601	611	1690	javax/crypto/NoSuchPaddingException
    //   619	625	1690	javax/crypto/NoSuchPaddingException
    //   633	641	1690	javax/crypto/NoSuchPaddingException
    //   928	941	1690	javax/crypto/NoSuchPaddingException
    //   949	955	1690	javax/crypto/NoSuchPaddingException
    //   963	990	1690	javax/crypto/NoSuchPaddingException
    //   998	1003	1690	javax/crypto/NoSuchPaddingException
    //   1011	1025	1690	javax/crypto/NoSuchPaddingException
    //   1039	1070	1690	javax/crypto/NoSuchPaddingException
    //   651	661	1700	javax/crypto/NoSuchPaddingException
    //   661	692	1710	javax/crypto/NoSuchPaddingException
    //   692	741	1717	javax/crypto/NoSuchPaddingException
    //   741	765	1724	javax/crypto/NoSuchPaddingException
    //   765	786	1724	javax/crypto/NoSuchPaddingException
    //   1086	1131	1724	javax/crypto/NoSuchPaddingException
    //   1138	1153	1724	javax/crypto/NoSuchPaddingException
    //   1153	1208	1724	javax/crypto/NoSuchPaddingException
    //   1279	1283	1724	javax/crypto/NoSuchPaddingException
    //   173	182	1730	java/security/InvalidKeyException
    //   190	200	1730	java/security/InvalidKeyException
    //   208	229	1730	java/security/InvalidKeyException
    //   237	242	1730	java/security/InvalidKeyException
    //   255	261	1730	java/security/InvalidKeyException
    //   269	273	1730	java/security/InvalidKeyException
    //   353	360	1730	java/security/InvalidKeyException
    //   368	372	1730	java/security/InvalidKeyException
    //   451	463	1730	java/security/InvalidKeyException
    //   475	487	1730	java/security/InvalidKeyException
    //   495	501	1730	java/security/InvalidKeyException
    //   509	515	1730	java/security/InvalidKeyException
    //   523	530	1730	java/security/InvalidKeyException
    //   538	547	1730	java/security/InvalidKeyException
    //   555	579	1730	java/security/InvalidKeyException
    //   587	593	1730	java/security/InvalidKeyException
    //   601	611	1730	java/security/InvalidKeyException
    //   619	625	1730	java/security/InvalidKeyException
    //   633	641	1730	java/security/InvalidKeyException
    //   928	941	1730	java/security/InvalidKeyException
    //   949	955	1730	java/security/InvalidKeyException
    //   963	990	1730	java/security/InvalidKeyException
    //   998	1003	1730	java/security/InvalidKeyException
    //   1011	1025	1730	java/security/InvalidKeyException
    //   1039	1070	1730	java/security/InvalidKeyException
    //   651	661	1740	java/security/InvalidKeyException
    //   661	692	1750	java/security/InvalidKeyException
    //   692	741	1757	java/security/InvalidKeyException
    //   741	765	1764	java/security/InvalidKeyException
    //   765	786	1764	java/security/InvalidKeyException
    //   1086	1131	1764	java/security/InvalidKeyException
    //   1138	1153	1764	java/security/InvalidKeyException
    //   1153	1208	1764	java/security/InvalidKeyException
    //   1279	1283	1764	java/security/InvalidKeyException
    //   173	182	1770	java/io/UnsupportedEncodingException
    //   190	200	1770	java/io/UnsupportedEncodingException
    //   208	229	1770	java/io/UnsupportedEncodingException
    //   237	242	1770	java/io/UnsupportedEncodingException
    //   255	261	1770	java/io/UnsupportedEncodingException
    //   269	273	1770	java/io/UnsupportedEncodingException
    //   353	360	1770	java/io/UnsupportedEncodingException
    //   368	372	1770	java/io/UnsupportedEncodingException
    //   451	463	1770	java/io/UnsupportedEncodingException
    //   475	487	1770	java/io/UnsupportedEncodingException
    //   495	501	1770	java/io/UnsupportedEncodingException
    //   509	515	1770	java/io/UnsupportedEncodingException
    //   523	530	1770	java/io/UnsupportedEncodingException
    //   538	547	1770	java/io/UnsupportedEncodingException
    //   555	579	1770	java/io/UnsupportedEncodingException
    //   587	593	1770	java/io/UnsupportedEncodingException
    //   601	611	1770	java/io/UnsupportedEncodingException
    //   619	625	1770	java/io/UnsupportedEncodingException
    //   633	641	1770	java/io/UnsupportedEncodingException
    //   928	941	1770	java/io/UnsupportedEncodingException
    //   949	955	1770	java/io/UnsupportedEncodingException
    //   963	990	1770	java/io/UnsupportedEncodingException
    //   998	1003	1770	java/io/UnsupportedEncodingException
    //   1011	1025	1770	java/io/UnsupportedEncodingException
    //   1039	1070	1770	java/io/UnsupportedEncodingException
    //   651	661	1780	java/io/UnsupportedEncodingException
    //   661	692	1790	java/io/UnsupportedEncodingException
    //   692	741	1797	java/io/UnsupportedEncodingException
    //   741	765	1804	java/io/UnsupportedEncodingException
    //   765	786	1804	java/io/UnsupportedEncodingException
    //   1086	1131	1804	java/io/UnsupportedEncodingException
    //   1138	1153	1804	java/io/UnsupportedEncodingException
    //   1153	1208	1804	java/io/UnsupportedEncodingException
    //   1279	1283	1804	java/io/UnsupportedEncodingException
  }
  
  public final b a(r.a parama)
  {
    parama = new d(parama.b, parama.c);
    return (b)this.b.get(parama);
  }
  
  final ch.a a(ad paramad, int paramInt, ArrayList<File> paramArrayList)
  {
    int i8 = paramArrayList.size() * 2;
    int i9 = paramInt / i8;
    int i1 = -1;
    paramInt = 0;
    int i3 = 0;
    boolean bool = false;
    int i2 = 0;
    int i5 = 0;
    Object localObject1;
    while (i5 < 2)
    {
      int i11 = new boolean[] { 1, 0 }[i5];
      int i4 = paramArrayList.size() - 1;
      if ((i4 >= 0) && (!bool) && (i2 == 0))
      {
        int i10 = i4 * i9;
        localObject2 = (File)paramArrayList.get(i4);
        StringBuilder localStringBuilder = new StringBuilder("msgstore/restore/");
        if (i11 != 0)
        {
          localObject1 = "repair-enabled";
          label120:
          localObject1 = new bd((String)localObject1 + " " + ((File)localObject2).getAbsolutePath());
          switch (a(paramad, (File)localObject2, i10, i9, i11))
          {
          }
        }
        for (;;)
        {
          int i6 = i2;
          int i7 = i3;
          i3 = i1;
          i2 = paramInt;
          i1 = i7;
          paramInt = i6;
          for (;;)
          {
            ((bd)localObject1).b();
            this.e.a(0L, 1L, i10, 0);
            i7 = i4 - 1;
            i4 = i2;
            i6 = i3;
            i2 = paramInt;
            i3 = i1;
            paramInt = i4;
            i1 = i6;
            i4 = i7;
            break;
            localObject1 = "repair-disabled";
            break label120;
            Log.i("msgstore/restore/success " + ((File)localObject2).getName());
            bool = true;
            i1 = i3;
            i3 = i4;
            i6 = i2;
            i2 = paramInt;
            paramInt = i6;
            continue;
            Log.w("msgstore/restore/failure/file-integrity " + ((File)localObject2).getName());
            i6 = i3;
            i3 = i1;
            i7 = paramInt + 1;
            paramInt = i2;
            i1 = i6;
            i2 = i7;
            continue;
            Log.w("msgstore/restore/failure/jid-mismatch " + ((File)localObject2).getName());
            i6 = i3 + 1;
            i3 = i1;
            i1 = i2;
            i2 = paramInt;
            paramInt = i1;
            i1 = i6;
            continue;
            Log.w("msgstore/restore/failure/out-of-space " + ((File)localObject2).getName());
            i7 = 1;
            i2 = paramInt;
            i6 = i1;
            paramInt = i7;
            i1 = i3;
            i3 = i6;
          }
          Log.w("msgstore/restore/failure " + ((File)localObject2).getName());
        }
      }
      i5 += 1;
    }
    Object localObject2 = new StringBuilder("msgstore/restore/");
    if (bool)
    {
      localObject1 = "success";
      Log.i((String)localObject1 + " num-backup-files-attempts: " + i8 + " num-integrity-failure: " + paramInt + " num-jid-mismatch: " + i3);
      if (!bool) {
        break label650;
      }
      paramad = ch.a.b;
      label593:
      a.a.a.a.d.c(this.c, Boolean.valueOf(bool));
      localObject1 = this.c;
      if ((!bool) || (i1 != paramArrayList.size() - 1)) {
        break label729;
      }
    }
    label650:
    label729:
    for (bool = true;; bool = false)
    {
      a.a.a.a.d.d((Context)localObject1, Boolean.valueOf(bool));
      return paramad;
      localObject1 = "failed";
      break;
      paramad.b();
      if (i2 != 0)
      {
        Log.w("msgstore/restore/nothing-restored/out-of-space");
        paramad = ch.a.f;
        break label593;
      }
      if (i3 > 0)
      {
        Log.w("msgstore/restore/nothing-restored/some-failures-are-jid-mismatch");
        if (av.k())
        {
          paramad = ch.a.d;
          break label593;
        }
        paramad = ch.a.a;
        break label593;
      }
      if (paramInt == i8)
      {
        Log.w("msgstore/restore/nothing-restored/all-failures-are-file-integrity-issues");
        paramad = ch.a.e;
        break label593;
      }
      paramad = ch.a.a;
      break label593;
    }
  }
  
  public final void a(long paramLong)
  {
    if (vv.e() < paramLong) {
      this.c.startActivity(new Intent(this.c, InsufficientStorageSpaceActivity.class).setFlags(268435456).putExtra("spaceNeededInBytes", paramLong));
    }
    while (vv.e() < paramLong)
    {
      Log.d("waiting for " + paramLong + " bytes storage to be available, currently available storage space is " + vv.e() + " bytes (using file " + this.f.getAbsolutePath() + " )");
      try
      {
        Thread.sleep(200L);
      }
      catch (InterruptedException localInterruptedException)
      {
        Log.d("msgstore/blockTillInternalStorageIsAvailable", localInterruptedException);
      }
    }
  }
  
  public final File b()
  {
    File[] arrayOfFile = c();
    if (arrayOfFile.length == 0) {
      throw new IllegalStateException("msgstore/backup/list-of-backup-files-is-null");
    }
    int i2 = arrayOfFile.length;
    int i1 = 0;
    while (i1 < i2)
    {
      File localFile = arrayOfFile[i1];
      if (localFile.exists())
      {
        Log.i("msgstore/get-latest-db-backup-for-gdrive " + localFile.getAbsolutePath());
        return localFile;
      }
      i1 += 1;
    }
    Log.i("msgstore/get-latest-db-backup-for-gdrive/no-file-exists " + arrayOfFile[0].getAbsolutePath());
    return arrayOfFile[0];
  }
  
  public final File[] c()
  {
    r.b[] arrayOfb = r.b.a(r.b.h, r.b.a());
    File[] arrayOfFile = new File[arrayOfb.length];
    int i1 = 0;
    while (i1 < arrayOfFile.length)
    {
      arrayOfFile[i1] = b(arrayOfb[(arrayOfFile.length - i1 - 1)]);
      i1 += 1;
    }
    return arrayOfFile;
  }
  
  public final int d()
  {
    r.b[] arrayOfb = r.b.values();
    int i2 = arrayOfb.length;
    int i1 = 0;
    while (i1 < i2)
    {
      r.b localb = arrayOfb[i1];
      Log.d("msgstore/getbackupfilecount/backupfile/" + a(localb) + " " + b(localb));
      i1 += 1;
    }
    return e().size();
  }
  
  final ArrayList<File> e()
  {
    Log.d("msgstore/getbackupfiles/includeolderfiles");
    ArrayList localArrayList = a.a.a.a.d.a(this.j, this.g, -1, a(r.b.g, r.b.a()));
    localArrayList.addAll(a.a.a.a.d.a(this.j, this.g, 7, a(r.b.a, r.b.f)));
    File localFile = this.g;
    SimpleDateFormat localSimpleDateFormat = a.a.a.a.d.l();
    Collections.sort(localArrayList, new j(a.a.a.a.d.k(localFile.getName()), localSimpleDateFormat));
    return localArrayList;
  }
  
  public final void f()
  {
    r.b[] arrayOfb = r.b.values();
    int i2 = arrayOfb.length;
    int i1 = 0;
    while (i1 < i2)
    {
      a.a.a.a.d.a(b(arrayOfb[i1]), -1, "", false);
      i1 += 1;
    }
    a.a.a.a.d.a(this.g, -1, "", false);
  }
  
  public final File g()
  {
    Object localObject1 = Environment.getExternalStorageState();
    Object localObject2 = this.n;
    if ((("mounted".equals(localObject1)) || ("mounted_ro".equals(localObject1))) && (((atu)localObject2).a("android.permission.READ_EXTERNAL_STORAGE") == 0)) {}
    for (int i1 = 1; i1 == 0; i1 = 0)
    {
      Log.i("msgstore/lastbackupfiletime/media_unavailable " + (String)localObject1);
      throw new IOException("External media not readable");
    }
    localObject1 = e();
    i1 = ((ArrayList)localObject1).size() - 1;
    while (i1 >= 0)
    {
      localObject2 = (File)((ArrayList)localObject1).get(i1);
      if (((File)localObject2).length() > 0L)
      {
        Log.i("msgstore/lastbackupfile/file " + ((File)localObject2).getName() + " size=" + ((File)localObject2).length());
        return (File)localObject2;
      }
      i1 -= 1;
    }
    return null;
  }
  
  public final long h()
  {
    try
    {
      File localFile = g();
      if (localFile != null)
      {
        long l1 = localFile.lastModified();
        return l1;
      }
      return 0L;
    }
    catch (IOException localIOException)
    {
      Log.b("msgstore/lastbackupfiletime", localIOException);
    }
    return -1L;
  }
  
  static final class a
  {
    final String a;
    final byte[] b;
    final byte[] c;
    
    a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      this.a = paramString;
      this.b = paramArrayOfByte1;
      this.c = paramArrayOfByte2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        do
        {
          return true;
          if (paramObject == null) {
            return false;
          }
          if (getClass() != paramObject.getClass()) {
            return false;
          }
          paramObject = (a)paramObject;
          if (!Arrays.equals(this.c, ((a)paramObject).c)) {
            return false;
          }
          if (!Arrays.equals(this.b, ((a)paramObject).b)) {
            return false;
          }
          if (this.a != null) {
            break;
          }
        } while (((a)paramObject).a == null);
        return false;
      } while (this.a.equals(((a)paramObject).a));
      return false;
    }
    
    public final int hashCode()
    {
      int j = Arrays.hashCode(this.c);
      int k = Arrays.hashCode(this.b);
      if (this.a == null) {}
      for (int i = 0;; i = this.a.hashCode()) {
        return i + ((j + 31) * 31 + k) * 31;
      }
    }
  }
  
  public static final class b
  {
    public final int a;
    public final byte[] b;
    public final byte[] c;
    
    public b(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    {
      this.a = paramInt;
      this.b = paramArrayOfByte1;
      this.c = paramArrayOfByte2;
    }
    
    public final String toString()
    {
      return "GetCipherKeyResult [code=" + this.a + ", key=" + Arrays.toString(this.b) + ", accountHash=" + Arrays.toString(this.c) + "]";
    }
  }
  
  public static final class c
  {
    public final apg.a a;
    
    public c(apg.a parama)
    {
      this.a = parama;
    }
    
    @LambdaForm.Hidden
    public final void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2)
    {
      this.a.a(paramLong1, paramLong2, paramInt1, paramInt2);
    }
  }
  
  public static final class d
  {
    private final String a;
    private final byte[] b;
    
    public d(String paramString, byte[] paramArrayOfByte)
    {
      this.a = paramString;
      this.b = paramArrayOfByte;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        do
        {
          return true;
          if (paramObject == null) {
            return false;
          }
          if (getClass() != paramObject.getClass()) {
            return false;
          }
          paramObject = (d)paramObject;
          if (!Arrays.equals(this.b, ((d)paramObject).b)) {
            return false;
          }
          if (this.a != null) {
            break;
          }
        } while (((d)paramObject).a == null);
        return false;
      } while (this.a.equals(((d)paramObject).a));
      return false;
    }
    
    public final int hashCode()
    {
      int j = Arrays.hashCode(this.b);
      if (this.a == null) {}
      for (int i = 0;; i = this.a.hashCode()) {
        return i + (j + 31) * 31;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */