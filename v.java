package com.whatsapp;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.aw;
import android.support.v7.app.n.b;
import android.telephony.PhoneStateListener;
import com.whatsapp.data.cs;
import com.whatsapp.data.ct;
import com.whatsapp.data.e;
import com.whatsapp.memory.a.a.a;
import com.whatsapp.messaging.m;
import com.whatsapp.notification.f;
import com.whatsapp.notification.k;
import com.whatsapp.registration.bb;
import com.whatsapp.util.Log;
import com.whatsapp.util.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class v
{
  private static final long a = ;
  private static boolean b;
  
  /* Error */
  public static void a(final Application paramApplication)
  {
    // Byte code:
    //   0: invokestatic 43	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_3
    //   4: ldc 45
    //   6: invokestatic 50	com/whatsapp/k/c:a	(Ljava/lang/String;)Lcom/whatsapp/k/d;
    //   9: astore 9
    //   11: aload 9
    //   13: lload_3
    //   14: invokeinterface 55 3 0
    //   19: invokestatic 60	com/whatsapp/ant:a	()Lcom/whatsapp/ant;
    //   22: astore 7
    //   24: invokestatic 65	com/whatsapp/c/a:a	()Lcom/whatsapp/c/a;
    //   27: astore 21
    //   29: invokestatic 70	com/whatsapp/aog:a	()Lcom/whatsapp/aog;
    //   32: astore 22
    //   34: invokestatic 75	com/whatsapp/pv:a	()Lcom/whatsapp/pv;
    //   37: astore 10
    //   39: invokestatic 80	com/whatsapp/util/a/a:a	()Lcom/whatsapp/util/a/a;
    //   42: astore 11
    //   44: invokestatic 85	com/whatsapp/util/a/c:a	()Lcom/whatsapp/util/a/c;
    //   47: astore 30
    //   49: invokestatic 90	com/whatsapp/va:a	()Lcom/whatsapp/va;
    //   52: astore 23
    //   54: invokestatic 95	com/whatsapp/ahc:a	()Lcom/whatsapp/ahc;
    //   57: astore 24
    //   59: invokestatic 100	com/whatsapp/ox:a	()Lcom/whatsapp/ox;
    //   62: astore 12
    //   64: invokestatic 105	com/whatsapp/util/bf:a	()Lcom/whatsapp/util/bf;
    //   67: astore 13
    //   69: invokestatic 110	com/whatsapp/registration/x:a	()Lcom/whatsapp/registration/x;
    //   72: astore 14
    //   74: invokestatic 115	com/whatsapp/data/ad:a	()Lcom/whatsapp/data/ad;
    //   77: astore 33
    //   79: invokestatic 120	com/whatsapp/att:a	()Lcom/whatsapp/att;
    //   82: astore 8
    //   84: invokestatic 125	com/whatsapp/mg:a	()Lcom/whatsapp/mg;
    //   87: astore 34
    //   89: invokestatic 130	com/whatsapp/data/e:a	()Lcom/whatsapp/data/e;
    //   92: astore 25
    //   94: invokestatic 135	com/whatsapp/messaging/m:a	()Lcom/whatsapp/messaging/m;
    //   97: astore 26
    //   99: invokestatic 140	com/whatsapp/and:a	()Lcom/whatsapp/and;
    //   102: astore 15
    //   104: invokestatic 145	com/whatsapp/messaging/aj:a	()Lcom/whatsapp/messaging/aj;
    //   107: astore 40
    //   109: invokestatic 150	com/whatsapp/aus:a	()Lcom/whatsapp/aus;
    //   112: astore 35
    //   114: invokestatic 155	com/whatsapp/mf:a	()Lcom/whatsapp/mf;
    //   117: astore 16
    //   119: invokestatic 160	com/whatsapp/data/ac:a	()Lcom/whatsapp/data/ac;
    //   122: astore 36
    //   124: invokestatic 165	com/whatsapp/contact/sync/i:a	()Lcom/whatsapp/contact/sync/i;
    //   127: astore 31
    //   129: invokestatic 170	com/whatsapp/vv:a	()Lcom/whatsapp/vv;
    //   132: astore 17
    //   134: invokestatic 175	com/whatsapp/ane:a	()Lcom/whatsapp/ane;
    //   137: astore 18
    //   139: invokestatic 180	com/whatsapp/rl:a	()Lcom/whatsapp/rl;
    //   142: astore 32
    //   144: invokestatic 185	com/whatsapp/data/v:a	()Lcom/whatsapp/data/v;
    //   147: astore 41
    //   149: invokestatic 190	com/whatsapp/us:a	()Lcom/whatsapp/us;
    //   152: astore 43
    //   154: invokestatic 195	com/whatsapp/notification/f:a	()Lcom/whatsapp/notification/f;
    //   157: astore 37
    //   159: invokestatic 200	com/whatsapp/registration/aw:a	()Lcom/whatsapp/registration/aw;
    //   162: astore 27
    //   164: invokestatic 205	com/whatsapp/atu:a	()Lcom/whatsapp/atu;
    //   167: astore 19
    //   169: invokestatic 210	com/whatsapp/atv:a	()Lcom/whatsapp/atv;
    //   172: astore 20
    //   174: invokestatic 215	com/whatsapp/lt:a	()Lcom/whatsapp/lt;
    //   177: astore 38
    //   179: invokestatic 220	com/whatsapp/sh:a	()Lcom/whatsapp/sh;
    //   182: astore 42
    //   184: invokestatic 225	com/whatsapp/pd:a	()Lcom/whatsapp/pd;
    //   187: astore 28
    //   189: invokestatic 230	com/whatsapp/notification/k:a	()Lcom/whatsapp/notification/k;
    //   192: astore 39
    //   194: invokestatic 235	com/whatsapp/registration/bb:a	()Lcom/whatsapp/registration/bb;
    //   197: astore 29
    //   199: invokestatic 241	a/a/a/a/d:k	()Z
    //   202: putstatic 243	com/whatsapp/v:b	Z
    //   205: aload_0
    //   206: invokestatic 248	com/whatsapp/util/Log:a	(Landroid/content/Context;)V
    //   209: invokestatic 251	com/whatsapp/util/Log:c	()V
    //   212: new 253	java/lang/StringBuilder
    //   215: dup
    //   216: ldc -1
    //   218: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   221: getstatic 243	com/whatsapp/v:b	Z
    //   224: invokevirtual 263	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   227: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 270	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   233: aload 9
    //   235: getstatic 275	com/whatsapp/k/d$a:b	Lcom/whatsapp/k/d$a;
    //   238: getstatic 243	com/whatsapp/v:b	Z
    //   241: invokeinterface 278 3 0
    //   246: aload 30
    //   248: new 280	java/io/File
    //   251: dup
    //   252: aload_0
    //   253: invokevirtual 286	android/app/Application:getFilesDir	()Ljava/io/File;
    //   256: ldc_w 288
    //   259: invokespecial 291	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   262: putfield 294	com/whatsapp/util/a/c:c	Ljava/io/File;
    //   265: aload 30
    //   267: new 280	java/io/File
    //   270: dup
    //   271: aload_0
    //   272: invokevirtual 286	android/app/Application:getFilesDir	()Ljava/io/File;
    //   275: ldc_w 296
    //   278: invokespecial 291	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   281: putfield 299	com/whatsapp/util/a/c:d	Ljava/io/File;
    //   284: aload_0
    //   285: invokestatic 302	com/whatsapp/util/a:a	(Landroid/content/Context;)V
    //   288: aload 15
    //   290: getfield 305	com/whatsapp/and:a	Landroid/os/PowerManager;
    //   293: astore 6
    //   295: aload 6
    //   297: ifnonnull +325 -> 622
    //   300: ldc_w 307
    //   303: invokestatic 310	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   306: aload 36
    //   308: aload 43
    //   310: invokevirtual 314	com/whatsapp/data/ac:registerObserver	(Ljava/lang/Object;)V
    //   313: new 316	org/whispersystems/a/e/a
    //   316: dup
    //   317: invokespecial 318	org/whispersystems/a/e/a:<init>	()V
    //   320: putstatic 322	a/a/a/a/d:aN	Lorg/whispersystems/a/e/a;
    //   323: invokestatic 327	b/a/a/c:a	()Lb/a/a/c;
    //   326: astore 6
    //   328: aload 6
    //   330: aload 7
    //   332: iconst_0
    //   333: invokevirtual 330	b/a/a/c:a	(Ljava/lang/Object;Z)V
    //   336: aload 6
    //   338: aload 40
    //   340: iconst_0
    //   341: invokevirtual 330	b/a/a/c:a	(Ljava/lang/Object;Z)V
    //   344: aload 6
    //   346: aload 41
    //   348: iconst_0
    //   349: invokevirtual 330	b/a/a/c:a	(Ljava/lang/Object;Z)V
    //   352: aload 6
    //   354: aload 42
    //   356: iconst_0
    //   357: invokevirtual 330	b/a/a/c:a	(Ljava/lang/Object;Z)V
    //   360: new 332	com/whatsapp/ak
    //   363: dup
    //   364: invokespecial 333	com/whatsapp/ak:<init>	()V
    //   367: astore 6
    //   369: new 335	android/content/IntentFilter
    //   372: dup
    //   373: invokespecial 336	android/content/IntentFilter:<init>	()V
    //   376: astore 40
    //   378: aload 40
    //   380: ldc_w 338
    //   383: invokevirtual 341	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   386: getstatic 347	android/os/Build$VERSION:SDK_INT	I
    //   389: bipush 21
    //   391: if_icmplt +11 -> 402
    //   394: aload 40
    //   396: ldc_w 349
    //   399: invokevirtual 341	android/content/IntentFilter:addAction	(Ljava/lang/String;)V
    //   402: aload_0
    //   403: aload 6
    //   405: aload 40
    //   407: invokevirtual 355	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   410: pop
    //   411: getstatic 347	android/os/Build$VERSION:SDK_INT	I
    //   414: bipush 21
    //   416: if_icmplt +255 -> 671
    //   419: aload 15
    //   421: invokestatic 358	com/whatsapp/ak:a	(Lcom/whatsapp/and;)V
    //   424: aload_0
    //   425: new 360	com/whatsapp/cf
    //   428: dup
    //   429: invokespecial 361	com/whatsapp/cf:<init>	()V
    //   432: new 335	android/content/IntentFilter
    //   435: dup
    //   436: ldc_w 363
    //   439: invokespecial 364	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   442: invokevirtual 355	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   445: pop
    //   446: aload 15
    //   448: getfield 368	com/whatsapp/and:e	Landroid/net/ConnectivityManager;
    //   451: astore 6
    //   453: aload 6
    //   455: ifnonnull +233 -> 688
    //   458: ldc_w 370
    //   461: invokestatic 310	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   464: aconst_null
    //   465: astore 6
    //   467: invokestatic 375	com/whatsapp/r:s	()Z
    //   470: ifne +14 -> 484
    //   473: invokestatic 327	b/a/a/c:a	()Lb/a/a/c;
    //   476: aload 6
    //   478: invokestatic 380	com/whatsapp/g/f:a	(Landroid/net/NetworkInfo;)Lcom/whatsapp/g/f;
    //   481: invokevirtual 382	b/a/a/c:c	(Ljava/lang/Object;)V
    //   484: aload_0
    //   485: aload 6
    //   487: invokestatic 385	com/whatsapp/cf:a	(Landroid/content/Context;Landroid/net/NetworkInfo;)V
    //   490: aload_0
    //   491: aload 15
    //   493: invokestatic 390	com/whatsapp/ahk:a	(Landroid/content/Context;Lcom/whatsapp/and;)V
    //   496: aload_0
    //   497: new 392	android/content/Intent
    //   500: dup
    //   501: getstatic 397	com/whatsapp/AlarmService:c	Ljava/lang/String;
    //   504: aconst_null
    //   505: aload_0
    //   506: ldc_w 394
    //   509: invokespecial 400	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;Landroid/content/Context;Ljava/lang/Class;)V
    //   512: invokevirtual 404	android/app/Application:startService	(Landroid/content/Intent;)Landroid/content/ComponentName;
    //   515: pop
    //   516: aload_0
    //   517: invokestatic 407	com/whatsapp/ape:a	(Landroid/content/Context;)V
    //   520: aload_0
    //   521: invokestatic 410	com/whatsapp/aoa:a	(Landroid/content/Context;)V
    //   524: aload 35
    //   526: getfield 413	com/whatsapp/aus:c	Lcom/whatsapp/atv;
    //   529: getfield 416	com/whatsapp/atv:a	Landroid/content/SharedPreferences;
    //   532: ldc_w 418
    //   535: aconst_null
    //   536: invokeinterface 424 3 0
    //   541: astore 6
    //   543: aload 6
    //   545: invokestatic 430	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   548: ifeq +150 -> 698
    //   551: ldc_w 432
    //   554: invokestatic 270	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   557: aload 35
    //   559: iconst_0
    //   560: putfield 433	com/whatsapp/aus:b	Z
    //   563: aload 10
    //   565: invokevirtual 435	com/whatsapp/pv:e	()V
    //   568: invokestatic 439	com/a/a/a/a:a	()V
    //   571: aload_0
    //   572: invokestatic 444	com/whatsapp/util/WhatsAppLibLoader:a	(Landroid/content/Context;)Z
    //   575: ifne +175 -> 750
    //   578: aload 9
    //   580: invokeinterface 445 1 0
    //   585: aload_0
    //   586: aload 10
    //   588: aload 11
    //   590: aload 12
    //   592: aload 13
    //   594: aload 14
    //   596: aload 15
    //   598: aload 16
    //   600: aload 17
    //   602: aload 18
    //   604: aload 19
    //   606: aload 20
    //   608: invokestatic 450	com/whatsapp/w:a	(Landroid/app/Application;Lcom/whatsapp/pv;Lcom/whatsapp/util/a/a;Lcom/whatsapp/ox;Lcom/whatsapp/util/bf;Lcom/whatsapp/registration/x;Lcom/whatsapp/and;Lcom/whatsapp/mf;Lcom/whatsapp/vv;Lcom/whatsapp/ane;Lcom/whatsapp/atu;Lcom/whatsapp/atv;)Ljava/lang/Runnable;
    //   611: invokestatic 455	com/whatsapp/util/bu:a	(Ljava/lang/Runnable;)V
    //   614: aload 9
    //   616: invokeinterface 457 1 0
    //   621: return
    //   622: new 253	java/lang/StringBuilder
    //   625: dup
    //   626: ldc_w 459
    //   629: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   632: astore 44
    //   634: aload 6
    //   636: invokevirtual 464	android/os/PowerManager:isScreenOn	()Z
    //   639: ifeq +24 -> 663
    //   642: ldc_w 466
    //   645: astore 6
    //   647: aload 44
    //   649: aload 6
    //   651: invokevirtual 469	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   657: invokestatic 270	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   660: goto -354 -> 306
    //   663: ldc_w 471
    //   666: astore 6
    //   668: goto -21 -> 647
    //   671: invokestatic 327	b/a/a/c:a	()Lb/a/a/c;
    //   674: new 473	com/whatsapp/g/k
    //   677: dup
    //   678: iconst_0
    //   679: invokespecial 476	com/whatsapp/g/k:<init>	(Z)V
    //   682: invokevirtual 382	b/a/a/c:c	(Ljava/lang/Object;)V
    //   685: goto -261 -> 424
    //   688: aload 6
    //   690: invokevirtual 482	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   693: astore 6
    //   695: goto -228 -> 467
    //   698: new 253	java/lang/StringBuilder
    //   701: dup
    //   702: ldc_w 484
    //   705: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   708: aload 6
    //   710: invokevirtual 469	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   716: invokestatic 270	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   719: aload 35
    //   721: new 486	java/util/Locale
    //   724: dup
    //   725: aload 6
    //   727: ldc_w 488
    //   730: invokespecial 491	java/util/Locale:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   733: putfield 494	com/whatsapp/aus:a	Ljava/util/Locale;
    //   736: aload 35
    //   738: iconst_1
    //   739: putfield 433	com/whatsapp/aus:b	Z
    //   742: aload 35
    //   744: invokevirtual 497	com/whatsapp/aus:f	()V
    //   747: goto -184 -> 563
    //   750: invokestatic 501	com/whatsapp/av:d	()Z
    //   753: ifeq +97 -> 850
    //   756: new 503	android/os/StrictMode$ThreadPolicy$Builder
    //   759: dup
    //   760: invokespecial 504	android/os/StrictMode$ThreadPolicy$Builder:<init>	()V
    //   763: invokevirtual 508	android/os/StrictMode$ThreadPolicy$Builder:detectAll	()Landroid/os/StrictMode$ThreadPolicy$Builder;
    //   766: invokevirtual 511	android/os/StrictMode$ThreadPolicy$Builder:penaltyLog	()Landroid/os/StrictMode$ThreadPolicy$Builder;
    //   769: astore 6
    //   771: getstatic 347	android/os/Build$VERSION:SDK_INT	I
    //   774: bipush 11
    //   776: if_icmplt +15 -> 791
    //   779: aload 6
    //   781: invokevirtual 514	android/os/StrictMode$ThreadPolicy$Builder:penaltyDeathOnNetwork	()Landroid/os/StrictMode$ThreadPolicy$Builder;
    //   784: pop
    //   785: aload 6
    //   787: invokevirtual 517	android/os/StrictMode$ThreadPolicy$Builder:penaltyFlashScreen	()Landroid/os/StrictMode$ThreadPolicy$Builder;
    //   790: pop
    //   791: aload 6
    //   793: invokevirtual 521	android/os/StrictMode$ThreadPolicy$Builder:build	()Landroid/os/StrictMode$ThreadPolicy;
    //   796: invokestatic 527	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   799: new 529	android/os/StrictMode$VmPolicy$Builder
    //   802: dup
    //   803: invokespecial 530	android/os/StrictMode$VmPolicy$Builder:<init>	()V
    //   806: invokevirtual 533	android/os/StrictMode$VmPolicy$Builder:detectAll	()Landroid/os/StrictMode$VmPolicy$Builder;
    //   809: invokevirtual 535	android/os/StrictMode$VmPolicy$Builder:penaltyLog	()Landroid/os/StrictMode$VmPolicy$Builder;
    //   812: astore 6
    //   814: getstatic 347	android/os/Build$VERSION:SDK_INT	I
    //   817: bipush 23
    //   819: if_icmplt +9 -> 828
    //   822: aload 6
    //   824: invokevirtual 538	android/os/StrictMode$VmPolicy$Builder:penaltyDeathOnCleartextNetwork	()Landroid/os/StrictMode$VmPolicy$Builder;
    //   827: pop
    //   828: getstatic 347	android/os/Build$VERSION:SDK_INT	I
    //   831: bipush 24
    //   833: if_icmplt +9 -> 842
    //   836: aload 6
    //   838: invokevirtual 541	android/os/StrictMode$VmPolicy$Builder:penaltyDeathOnFileUriExposure	()Landroid/os/StrictMode$VmPolicy$Builder;
    //   841: pop
    //   842: aload 6
    //   844: invokevirtual 544	android/os/StrictMode$VmPolicy$Builder:build	()Landroid/os/StrictMode$VmPolicy;
    //   847: invokestatic 548	android/os/StrictMode:setVmPolicy	(Landroid/os/StrictMode$VmPolicy;)V
    //   850: aload 8
    //   852: aload 8
    //   854: getfield 551	com/whatsapp/att:b	Landroid/content/Context;
    //   857: invokestatic 556	org/whispersystems/jobqueue/a:a	(Landroid/content/Context;)Lorg/whispersystems/jobqueue/a$a;
    //   860: ldc_w 558
    //   863: invokevirtual 563	org/whispersystems/jobqueue/a$a:a	(Ljava/lang/String;)Lorg/whispersystems/jobqueue/a$a;
    //   866: invokevirtual 566	org/whispersystems/jobqueue/a$a:a	()Lorg/whispersystems/jobqueue/a$a;
    //   869: bipush 7
    //   871: anewarray 568	org/whispersystems/jobqueue/requirements/b
    //   874: dup
    //   875: iconst_0
    //   876: new 570	com/whatsapp/jobqueue/requirement/b
    //   879: dup
    //   880: invokespecial 571	com/whatsapp/jobqueue/requirement/b:<init>	()V
    //   883: aastore
    //   884: dup
    //   885: iconst_1
    //   886: new 573	com/whatsapp/jobqueue/requirement/a
    //   889: dup
    //   890: invokespecial 574	com/whatsapp/jobqueue/requirement/a:<init>	()V
    //   893: aastore
    //   894: dup
    //   895: iconst_2
    //   896: new 576	com/whatsapp/jobqueue/requirement/c
    //   899: dup
    //   900: invokespecial 577	com/whatsapp/jobqueue/requirement/c:<init>	()V
    //   903: aastore
    //   904: dup
    //   905: iconst_3
    //   906: new 579	com/whatsapp/jobqueue/requirement/g
    //   909: dup
    //   910: invokespecial 580	com/whatsapp/jobqueue/requirement/g:<init>	()V
    //   913: aastore
    //   914: dup
    //   915: iconst_4
    //   916: new 582	com/whatsapp/jobqueue/requirement/e
    //   919: dup
    //   920: invokespecial 583	com/whatsapp/jobqueue/requirement/e:<init>	()V
    //   923: aastore
    //   924: dup
    //   925: iconst_5
    //   926: new 585	com/whatsapp/jobqueue/requirement/d
    //   929: dup
    //   930: invokespecial 586	com/whatsapp/jobqueue/requirement/d:<init>	()V
    //   933: aastore
    //   934: dup
    //   935: bipush 6
    //   937: new 588	com/whatsapp/jobqueue/requirement/f
    //   940: dup
    //   941: invokespecial 589	com/whatsapp/jobqueue/requirement/f:<init>	()V
    //   944: aastore
    //   945: invokevirtual 592	org/whispersystems/jobqueue/a$a:a	([Lorg/whispersystems/jobqueue/requirements/b;)Lorg/whispersystems/jobqueue/a$a;
    //   948: new 594	com/whatsapp/att$1
    //   951: dup
    //   952: aload 8
    //   954: invokespecial 597	com/whatsapp/att$1:<init>	(Lcom/whatsapp/att;)V
    //   957: invokevirtual 600	org/whispersystems/jobqueue/a$a:a	(Lorg/whispersystems/jobqueue/b/a;)Lorg/whispersystems/jobqueue/a$a;
    //   960: invokevirtual 603	org/whispersystems/jobqueue/a$a:b	()Lorg/whispersystems/jobqueue/a;
    //   963: putfield 606	com/whatsapp/att:a	Lorg/whispersystems/jobqueue/a;
    //   966: new 608	com/whatsapp/j/a/a
    //   969: dup
    //   970: aload_0
    //   971: invokevirtual 612	android/app/Application:getResources	()Landroid/content/res/Resources;
    //   974: invokespecial 615	com/whatsapp/j/a/a:<init>	(Landroid/content/res/Resources;)V
    //   977: putstatic 620	com/whatsapp/u:a	Lcom/whatsapp/j/a/a;
    //   980: aload 20
    //   982: getfield 416	com/whatsapp/atv:a	Landroid/content/SharedPreferences;
    //   985: ldc_w 622
    //   988: ldc_w 624
    //   991: invokeinterface 424 3 0
    //   996: invokestatic 629	com/whatsapp/apw:a	(Ljava/lang/String;)Lcom/whatsapp/apw;
    //   999: astore 6
    //   1001: aload 6
    //   1003: ifnull +145 -> 1148
    //   1006: new 253	java/lang/StringBuilder
    //   1009: dup
    //   1010: ldc_w 631
    //   1013: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1016: aload 6
    //   1018: invokevirtual 634	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1021: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1024: invokestatic 636	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   1027: invokestatic 640	com/whatsapp/au:d	()Ljava/lang/String;
    //   1030: invokestatic 629	com/whatsapp/apw:a	(Ljava/lang/String;)Lcom/whatsapp/apw;
    //   1033: astore 8
    //   1035: aload 8
    //   1037: ifnull +111 -> 1148
    //   1040: new 253	java/lang/StringBuilder
    //   1043: dup
    //   1044: ldc_w 642
    //   1047: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1050: aload 8
    //   1052: invokevirtual 634	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1055: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1058: invokestatic 636	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   1061: aload 22
    //   1063: aload 8
    //   1065: aload 6
    //   1067: invokevirtual 645	com/whatsapp/apw:a	(Lcom/whatsapp/apw;)I
    //   1070: putfield 647	com/whatsapp/aog:e	I
    //   1073: aload 22
    //   1075: getfield 647	com/whatsapp/aog:e	I
    //   1078: ifeq +70 -> 1148
    //   1081: aload 22
    //   1083: invokevirtual 648	com/whatsapp/aog:f	()V
    //   1086: aload 29
    //   1088: invokevirtual 651	com/whatsapp/registration/bb:c	()I
    //   1091: iconst_3
    //   1092: if_icmpge +9 -> 1101
    //   1095: aload 29
    //   1097: iconst_0
    //   1098: invokevirtual 654	com/whatsapp/registration/bb:a	(I)V
    //   1101: invokestatic 640	com/whatsapp/au:d	()Ljava/lang/String;
    //   1104: astore 6
    //   1106: invokestatic 659	java/lang/System:currentTimeMillis	()J
    //   1109: lstore_3
    //   1110: aload 20
    //   1112: invokevirtual 662	com/whatsapp/atv:c	()Landroid/content/SharedPreferences$Editor;
    //   1115: ldc_w 622
    //   1118: aload 6
    //   1120: invokeinterface 668 3 0
    //   1125: ldc_w 670
    //   1128: lload_3
    //   1129: invokeinterface 674 4 0
    //   1134: ldc_w 676
    //   1137: iconst_1
    //   1138: invokeinterface 680 3 0
    //   1143: invokeinterface 683 1 0
    //   1148: aload 7
    //   1150: getfield 685	com/whatsapp/ant:d	J
    //   1153: lstore_3
    //   1154: aload 7
    //   1156: aload 20
    //   1158: getfield 416	com/whatsapp/atv:a	Landroid/content/SharedPreferences;
    //   1161: ldc_w 687
    //   1164: lload_3
    //   1165: invokeinterface 691 4 0
    //   1170: putfield 685	com/whatsapp/ant:d	J
    //   1173: aload 30
    //   1175: getfield 294	com/whatsapp/util/a/c:c	Ljava/io/File;
    //   1178: invokevirtual 694	java/io/File:exists	()Z
    //   1181: ifeq +33 -> 1214
    //   1184: aload 30
    //   1186: getfield 697	com/whatsapp/util/a/c:f	Lcom/whatsapp/aog;
    //   1189: getfield 647	com/whatsapp/aog:e	I
    //   1192: ifne +1165 -> 2357
    //   1195: iconst_1
    //   1196: istore 5
    //   1198: aload 30
    //   1200: iload 5
    //   1202: putfield 699	com/whatsapp/util/a/c:e	Z
    //   1205: aload 30
    //   1207: getfield 294	com/whatsapp/util/a/c:c	Ljava/io/File;
    //   1210: invokevirtual 702	java/io/File:delete	()Z
    //   1213: pop
    //   1214: aload 15
    //   1216: getfield 705	com/whatsapp/and:b	Landroid/app/ActivityManager;
    //   1219: astore 7
    //   1221: aconst_null
    //   1222: astore 6
    //   1224: aload 7
    //   1226: ifnonnull +1137 -> 2363
    //   1229: ldc_w 707
    //   1232: invokestatic 310	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1235: iconst_1
    //   1236: istore_1
    //   1237: iload_1
    //   1238: ifeq +1222 -> 2460
    //   1241: aload 6
    //   1243: ifnull +8 -> 1251
    //   1246: aload 6
    //   1248: invokestatic 710	com/whatsapp/ane:a	(Ljava/util/List;)V
    //   1251: aload_0
    //   1252: invokestatic 715	com/whatsapp/fieldstats/l:a	(Landroid/content/Context;)Lcom/whatsapp/fieldstats/l;
    //   1255: astore 6
    //   1257: aload_0
    //   1258: aload 15
    //   1260: aload 35
    //   1262: aload 20
    //   1264: invokestatic 720	com/whatsapp/x:a	(Landroid/app/Application;Lcom/whatsapp/and;Lcom/whatsapp/aus;Lcom/whatsapp/atv;)Ljava/lang/Runnable;
    //   1267: astore 7
    //   1269: aload 6
    //   1271: getfield 723	com/whatsapp/fieldstats/l:a	Landroid/os/Handler;
    //   1274: aload 6
    //   1276: aload 7
    //   1278: invokestatic 728	com/whatsapp/fieldstats/t:a	(Lcom/whatsapp/fieldstats/l;Ljava/lang/Runnable;)Ljava/lang/Runnable;
    //   1281: invokevirtual 734	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   1284: pop
    //   1285: aload 30
    //   1287: getfield 299	com/whatsapp/util/a/c:d	Ljava/io/File;
    //   1290: invokevirtual 694	java/io/File:exists	()Z
    //   1293: ifeq +145 -> 1438
    //   1296: aload 30
    //   1298: getfield 699	com/whatsapp/util/a/c:e	Z
    //   1301: ifne +128 -> 1429
    //   1304: aload 30
    //   1306: getfield 697	com/whatsapp/util/a/c:f	Lcom/whatsapp/aog;
    //   1309: getfield 647	com/whatsapp/aog:e	I
    //   1312: ifne +117 -> 1429
    //   1315: iconst_0
    //   1316: istore_2
    //   1317: new 736	java/io/BufferedReader
    //   1320: dup
    //   1321: new 738	java/io/FileReader
    //   1324: dup
    //   1325: aload 30
    //   1327: getfield 299	com/whatsapp/util/a/c:d	Ljava/io/File;
    //   1330: invokespecial 741	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   1333: invokespecial 744	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1336: astore 6
    //   1338: aload 6
    //   1340: invokevirtual 747	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1343: astore 7
    //   1345: aload 6
    //   1347: invokevirtual 750	java/io/BufferedReader:close	()V
    //   1350: aload 7
    //   1352: astore 6
    //   1354: iload_2
    //   1355: istore_1
    //   1356: aload 7
    //   1358: invokestatic 430	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1361: ifeq +10 -> 1371
    //   1364: ldc_w 752
    //   1367: astore 6
    //   1369: iconst_1
    //   1370: istore_1
    //   1371: new 754	com/whatsapp/fieldstats/events/r
    //   1374: dup
    //   1375: invokespecial 755	com/whatsapp/fieldstats/events/r:<init>	()V
    //   1378: astore 7
    //   1380: aload 7
    //   1382: ldc_w 757
    //   1385: putfield 759	com/whatsapp/fieldstats/events/r:a	Ljava/lang/String;
    //   1388: aload 7
    //   1390: aload 6
    //   1392: putfield 761	com/whatsapp/fieldstats/events/r:b	Ljava/lang/String;
    //   1395: aload_0
    //   1396: aload 7
    //   1398: invokestatic 764	com/whatsapp/fieldstats/l:a	(Landroid/content/Context;Lcom/whatsapp/fieldstats/e;)V
    //   1401: new 766	com/whatsapp/any
    //   1404: dup
    //   1405: invokespecial 767	com/whatsapp/any:<init>	()V
    //   1408: astore 7
    //   1410: iload_1
    //   1411: ifeq +1079 -> 2490
    //   1414: ldc_w 769
    //   1417: astore 6
    //   1419: aload 7
    //   1421: aload 6
    //   1423: invokevirtual 772	com/whatsapp/any:a	(Ljava/lang/String;)Lcom/whatsapp/any;
    //   1426: invokevirtual 773	com/whatsapp/any:e	()V
    //   1429: aload 30
    //   1431: getfield 299	com/whatsapp/util/a/c:d	Ljava/io/File;
    //   1434: invokevirtual 702	java/io/File:delete	()Z
    //   1437: pop
    //   1438: aload 15
    //   1440: getfield 776	com/whatsapp/and:c	Landroid/telephony/TelephonyManager;
    //   1443: astore 6
    //   1445: aload 6
    //   1447: ifnonnull +1051 -> 2498
    //   1450: ldc_w 778
    //   1453: invokestatic 270	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1456: ldc_w 780
    //   1459: invokestatic 270	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1462: aconst_null
    //   1463: astore 6
    //   1465: new 280	java/io/File
    //   1468: dup
    //   1469: aload 23
    //   1471: getfield 782	com/whatsapp/va:a	Landroid/content/Context;
    //   1474: invokevirtual 783	android/content/Context:getFilesDir	()Ljava/io/File;
    //   1477: ldc_w 785
    //   1480: invokespecial 291	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   1483: invokevirtual 694	java/io/File:exists	()Z
    //   1486: ifeq +38 -> 1524
    //   1489: aload 23
    //   1491: aload 23
    //   1493: getfield 782	com/whatsapp/va:a	Landroid/content/Context;
    //   1496: ldc_w 785
    //   1499: invokevirtual 789	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   1502: invokevirtual 792	com/whatsapp/va:a	(Ljava/io/InputStream;)Ljava/io/ObjectInputStream;
    //   1505: astore 6
    //   1507: aload 6
    //   1509: astore 7
    //   1511: aload 23
    //   1513: aload 6
    //   1515: invokevirtual 798	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   1518: checkcast 800	com/whatsapp/Me
    //   1521: putfield 803	com/whatsapp/va:b	Lcom/whatsapp/Me;
    //   1524: aload 6
    //   1526: invokestatic 808	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   1529: aload 24
    //   1531: invokevirtual 810	com/whatsapp/ahc:c	()Z
    //   1534: pop
    //   1535: aload_0
    //   1536: invokevirtual 286	android/app/Application:getFilesDir	()Ljava/io/File;
    //   1539: invokestatic 814	com/whatsapp/Statistics:a	(Ljava/io/File;)V
    //   1542: aload 17
    //   1544: invokevirtual 816	com/whatsapp/vv:d	()V
    //   1547: new 392	android/content/Intent
    //   1550: dup
    //   1551: ldc_w 818
    //   1554: invokespecial 819	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   1557: invokestatic 821	com/whatsapp/au:b	()Ljava/lang/String;
    //   1560: invokevirtual 825	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   1563: astore 6
    //   1565: aload 20
    //   1567: invokevirtual 828	com/whatsapp/atv:t	()J
    //   1570: lconst_0
    //   1571: lcmp
    //   1572: ifle +36 -> 1608
    //   1575: aload_0
    //   1576: iconst_0
    //   1577: aload 6
    //   1579: ldc_w 829
    //   1582: invokestatic 835	android/app/PendingIntent:getBroadcast	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   1585: ifnonnull +23 -> 1608
    //   1588: ldc_w 837
    //   1591: invokestatic 270	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1594: aload 27
    //   1596: invokevirtual 840	com/whatsapp/registration/aw:b	()Lcom/whatsapp/registration/i;
    //   1599: aload 27
    //   1601: getfield 841	com/whatsapp/registration/aw:a	Landroid/content/Context;
    //   1604: aconst_null
    //   1605: invokevirtual 847	com/whatsapp/registration/i:onReceive	(Landroid/content/Context;Landroid/content/Intent;)V
    //   1608: ldc_w 849
    //   1611: invokestatic 50	com/whatsapp/k/c:a	(Ljava/lang/String;)Lcom/whatsapp/k/d;
    //   1614: astore 6
    //   1616: aload 6
    //   1618: invokeinterface 850 1 0
    //   1623: aload 36
    //   1625: invokestatic 855	com/whatsapp/yx:a	(Lcom/whatsapp/data/ac;)V
    //   1628: aload 29
    //   1630: invokevirtual 651	com/whatsapp/registration/bb:c	()I
    //   1633: bipush 6
    //   1635: if_icmpne +8 -> 1643
    //   1638: aload 34
    //   1640: invokevirtual 856	com/whatsapp/mg:b	()V
    //   1643: aload 23
    //   1645: getfield 803	com/whatsapp/va:b	Lcom/whatsapp/Me;
    //   1648: ifnull +32 -> 1680
    //   1651: aload 33
    //   1653: invokevirtual 857	com/whatsapp/data/ad:d	()Z
    //   1656: ifeq +24 -> 1680
    //   1659: ldc_w 859
    //   1662: invokestatic 270	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1665: aload 33
    //   1667: invokevirtual 860	com/whatsapp/data/ad:c	()V
    //   1670: aload 26
    //   1672: invokevirtual 861	com/whatsapp/messaging/m:c	()V
    //   1675: aload 31
    //   1677: invokevirtual 862	com/whatsapp/contact/sync/i:d	()V
    //   1680: aload 6
    //   1682: invokeinterface 457 1 0
    //   1687: aload 36
    //   1689: invokestatic 865	com/whatsapp/MediaTranscodeService:a	(Lcom/whatsapp/data/ac;)V
    //   1692: new 18	com/whatsapp/v$7
    //   1695: dup
    //   1696: aload 25
    //   1698: aload 38
    //   1700: aload 39
    //   1702: aload_0
    //   1703: aload 35
    //   1705: aload 37
    //   1707: invokespecial 868	com/whatsapp/v$7:<init>	(Lcom/whatsapp/data/e;Lcom/whatsapp/lt;Lcom/whatsapp/notification/k;Landroid/app/Application;Lcom/whatsapp/aus;Lcom/whatsapp/notification/f;)V
    //   1710: iconst_0
    //   1711: anewarray 870	java/lang/Void
    //   1714: invokestatic 873	com/whatsapp/util/bu:a	(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   1717: pop
    //   1718: aload_0
    //   1719: ldc_w 875
    //   1722: iconst_0
    //   1723: invokevirtual 879	android/app/Application:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1726: astore 6
    //   1728: aload 6
    //   1730: ifnull +22 -> 1752
    //   1733: aload 6
    //   1735: ldc_w 875
    //   1738: iconst_0
    //   1739: invokeinterface 883 3 0
    //   1744: ifne +8 -> 1752
    //   1747: aload 20
    //   1749: invokevirtual 886	com/whatsapp/atv:P	()V
    //   1752: aload_0
    //   1753: invokevirtual 890	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   1756: getstatic 896	android/provider/ContactsContract$Contacts:CONTENT_URI	Landroid/net/Uri;
    //   1759: iconst_1
    //   1760: aload 31
    //   1762: getfield 900	com/whatsapp/contact/sync/i:g	Lcom/whatsapp/s;
    //   1765: invokevirtual 906	android/content/ContentResolver:registerContentObserver	(Landroid/net/Uri;ZLandroid/database/ContentObserver;)V
    //   1768: aload_0
    //   1769: new 10	com/whatsapp/v$3
    //   1772: dup
    //   1773: aload 20
    //   1775: aload 26
    //   1777: aload 18
    //   1779: invokespecial 909	com/whatsapp/v$3:<init>	(Lcom/whatsapp/atv;Lcom/whatsapp/messaging/m;Lcom/whatsapp/ane;)V
    //   1782: new 335	android/content/IntentFilter
    //   1785: dup
    //   1786: ldc_w 911
    //   1789: invokespecial 364	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   1792: invokevirtual 912	android/app/Application:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   1795: pop
    //   1796: aload_0
    //   1797: new 914	com/whatsapp/util/a/c$1
    //   1800: dup
    //   1801: aload 30
    //   1803: invokespecial 917	com/whatsapp/util/a/c$1:<init>	(Lcom/whatsapp/util/a/c;)V
    //   1806: new 335	android/content/IntentFilter
    //   1809: dup
    //   1810: ldc_w 919
    //   1813: invokespecial 364	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   1816: ldc_w 921
    //   1819: aconst_null
    //   1820: invokevirtual 924	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   1823: pop
    //   1824: aload_0
    //   1825: aload 32
    //   1827: getfield 927	com/whatsapp/rl:b	Lcom/whatsapp/rl$a;
    //   1830: new 335	android/content/IntentFilter
    //   1833: dup
    //   1834: ldc_w 929
    //   1837: invokespecial 364	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   1840: invokevirtual 355	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   1843: pop
    //   1844: aload_0
    //   1845: new 931	com/whatsapp/alt
    //   1848: dup
    //   1849: invokespecial 932	com/whatsapp/alt:<init>	()V
    //   1852: new 335	android/content/IntentFilter
    //   1855: dup
    //   1856: ldc_w 934
    //   1859: invokespecial 364	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   1862: invokevirtual 355	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   1865: pop
    //   1866: aload 28
    //   1868: getfield 935	com/whatsapp/pd:b	Landroid/content/Context;
    //   1871: invokestatic 938	com/whatsapp/aj:a	(Landroid/content/Context;)V
    //   1874: aload 28
    //   1876: getfield 941	com/whatsapp/pd:c	Lcom/whatsapp/aj;
    //   1879: astore 6
    //   1881: aload 28
    //   1883: getfield 935	com/whatsapp/pd:b	Landroid/content/Context;
    //   1886: aload 6
    //   1888: new 335	android/content/IntentFilter
    //   1891: dup
    //   1892: ldc_w 943
    //   1895: invokespecial 364	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   1898: ldc_w 921
    //   1901: aconst_null
    //   1902: invokevirtual 924	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   1905: pop
    //   1906: aload 26
    //   1908: getfield 946	com/whatsapp/messaging/m:h	Landroid/content/Context;
    //   1911: new 948	com/whatsapp/messaging/m$3
    //   1914: dup
    //   1915: aload 26
    //   1917: invokespecial 951	com/whatsapp/messaging/m$3:<init>	(Lcom/whatsapp/messaging/m;)V
    //   1920: new 335	android/content/IntentFilter
    //   1923: dup
    //   1924: ldc_w 953
    //   1927: invokespecial 364	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   1930: ldc_w 921
    //   1933: aconst_null
    //   1934: invokevirtual 924	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   1937: pop
    //   1938: aload_0
    //   1939: new 12	com/whatsapp/v$4
    //   1942: dup
    //   1943: aload 29
    //   1945: aload_0
    //   1946: invokespecial 956	com/whatsapp/v$4:<init>	(Lcom/whatsapp/registration/bb;Landroid/app/Application;)V
    //   1949: new 335	android/content/IntentFilter
    //   1952: dup
    //   1953: ldc_w 958
    //   1956: invokespecial 364	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   1959: ldc_w 921
    //   1962: aconst_null
    //   1963: invokevirtual 959	android/app/Application:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   1966: pop
    //   1967: aload 27
    //   1969: getfield 841	com/whatsapp/registration/aw:a	Landroid/content/Context;
    //   1972: aload 27
    //   1974: invokevirtual 840	com/whatsapp/registration/aw:b	()Lcom/whatsapp/registration/i;
    //   1977: new 335	android/content/IntentFilter
    //   1980: dup
    //   1981: ldc_w 818
    //   1984: invokespecial 364	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   1987: ldc_w 921
    //   1990: aconst_null
    //   1991: invokevirtual 924	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   1994: pop
    //   1995: aload_0
    //   1996: new 961	com/whatsapp/auj$f
    //   1999: dup
    //   2000: invokespecial 962	com/whatsapp/auj$f:<init>	()V
    //   2003: new 335	android/content/IntentFilter
    //   2006: dup
    //   2007: ldc_w 964
    //   2010: invokespecial 364	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   2013: ldc_w 921
    //   2016: aconst_null
    //   2017: invokevirtual 924	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;
    //   2020: pop
    //   2021: aload_0
    //   2022: new 966	com/whatsapp/ahc$1
    //   2025: dup
    //   2026: aload 24
    //   2028: aload_0
    //   2029: invokespecial 969	com/whatsapp/ahc$1:<init>	(Lcom/whatsapp/ahc;Landroid/content/Context;)V
    //   2032: new 335	android/content/IntentFilter
    //   2035: dup
    //   2036: ldc_w 971
    //   2039: invokespecial 364	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   2042: invokevirtual 355	android/content/Context:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   2045: pop
    //   2046: aload_0
    //   2047: new 14	com/whatsapp/v$5
    //   2050: dup
    //   2051: invokespecial 972	com/whatsapp/v$5:<init>	()V
    //   2054: new 335	android/content/IntentFilter
    //   2057: dup
    //   2058: ldc_w 974
    //   2061: invokespecial 364	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   2064: invokevirtual 912	android/app/Application:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   2067: pop
    //   2068: aload_0
    //   2069: new 16	com/whatsapp/v$6
    //   2072: dup
    //   2073: aload 25
    //   2075: invokespecial 977	com/whatsapp/v$6:<init>	(Lcom/whatsapp/data/e;)V
    //   2078: new 335	android/content/IntentFilter
    //   2081: dup
    //   2082: ldc_w 979
    //   2085: invokespecial 364	android/content/IntentFilter:<init>	(Ljava/lang/String;)V
    //   2088: invokevirtual 912	android/app/Application:registerReceiver	(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;
    //   2091: pop
    //   2092: aload 15
    //   2094: getfield 368	com/whatsapp/and:e	Landroid/net/ConnectivityManager;
    //   2097: astore 6
    //   2099: aload 6
    //   2101: ifnull +507 -> 2608
    //   2104: aload 6
    //   2106: invokevirtual 982	android/net/ConnectivityManager:getBackgroundDataSetting	()Z
    //   2109: ifeq +499 -> 2608
    //   2112: iconst_1
    //   2113: istore 5
    //   2115: new 253	java/lang/StringBuilder
    //   2118: dup
    //   2119: ldc_w 984
    //   2122: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2125: iload 5
    //   2127: invokevirtual 263	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2130: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2133: invokestatic 270	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2136: iload 5
    //   2138: ifne +9 -> 2147
    //   2141: aload 20
    //   2143: iconst_1
    //   2144: invokevirtual 986	com/whatsapp/atv:c	(Z)V
    //   2147: invokestatic 988	com/whatsapp/av:f	()Z
    //   2150: ifeq +66 -> 2216
    //   2153: aload 23
    //   2155: getfield 803	com/whatsapp/va:b	Lcom/whatsapp/Me;
    //   2158: ifnull +14 -> 2172
    //   2161: aload 22
    //   2163: aload 23
    //   2165: invokevirtual 989	com/whatsapp/va:b	()Ljava/lang/String;
    //   2168: invokevirtual 992	com/whatsapp/aog:a	(Ljava/lang/String;)Z
    //   2171: pop
    //   2172: aload 15
    //   2174: getfield 995	com/whatsapp/and:f	Landroid/content/ContentResolver;
    //   2177: astore 6
    //   2179: aload 6
    //   2181: ifnull +35 -> 2216
    //   2184: aload 6
    //   2186: ldc_w 997
    //   2189: invokestatic 1003	android/provider/Settings$Secure:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;)I
    //   2192: iconst_1
    //   2193: if_icmpne +23 -> 2216
    //   2196: aload 22
    //   2198: getfield 1005	com/whatsapp/aog:d	Z
    //   2201: ifeq +15 -> 2216
    //   2204: aload 22
    //   2206: invokevirtual 1007	com/whatsapp/aog:g	()Z
    //   2209: istore 5
    //   2211: iload 5
    //   2213: ifne +401 -> 2614
    //   2216: aload 14
    //   2218: invokevirtual 1009	com/whatsapp/registration/x:b	()Z
    //   2221: pop
    //   2222: new 253	java/lang/StringBuilder
    //   2225: dup
    //   2226: ldc_w 1011
    //   2229: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2232: aload 20
    //   2234: invokevirtual 1012	com/whatsapp/atv:b	()Z
    //   2237: invokevirtual 263	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2240: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2243: invokestatic 270	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2246: getstatic 347	android/os/Build$VERSION:SDK_INT	I
    //   2249: bipush 14
    //   2251: if_icmplt +18 -> 2269
    //   2254: aload_0
    //   2255: new 8	com/whatsapp/v$2
    //   2258: dup
    //   2259: aload 21
    //   2261: aload 10
    //   2263: invokespecial 1015	com/whatsapp/v$2:<init>	(Lcom/whatsapp/c/a;Lcom/whatsapp/pv;)V
    //   2266: invokevirtual 1019	android/app/Application:registerActivityLifecycleCallbacks	(Landroid/app/Application$ActivityLifecycleCallbacks;)V
    //   2269: new 253	java/lang/StringBuilder
    //   2272: dup
    //   2273: ldc_w 1021
    //   2276: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2279: getstatic 1026	android/os/Build:DISPLAY	Ljava/lang/String;
    //   2282: invokevirtual 469	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2285: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2288: invokestatic 270	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2291: invokestatic 1027	com/whatsapp/av:k	()Z
    //   2294: ifeq +54 -> 2348
    //   2297: new 1029	com/whatsapp/gcm/a/a
    //   2300: dup
    //   2301: aload_0
    //   2302: invokespecial 1031	com/whatsapp/gcm/a/a:<init>	(Landroid/content/Context;)V
    //   2305: putstatic 1034	com/whatsapp/gcm/a/a:a	Lcom/whatsapp/gcm/a/a;
    //   2308: invokestatic 327	b/a/a/c:a	()Lb/a/a/c;
    //   2311: getstatic 1034	com/whatsapp/gcm/a/a:a	Lcom/whatsapp/gcm/a/a;
    //   2314: iconst_0
    //   2315: invokevirtual 330	b/a/a/c:a	(Ljava/lang/Object;Z)V
    //   2318: getstatic 1034	com/whatsapp/gcm/a/a:a	Lcom/whatsapp/gcm/a/a;
    //   2321: invokevirtual 1035	com/whatsapp/gcm/a/a:a	()V
    //   2324: getstatic 1034	com/whatsapp/gcm/a/a:a	Lcom/whatsapp/gcm/a/a;
    //   2327: astore 6
    //   2329: invokestatic 1037	com/whatsapp/gcm/a/a:b	()J
    //   2332: lstore_3
    //   2333: aload 6
    //   2335: getfield 1039	com/whatsapp/gcm/a/a:c	Landroid/os/Handler;
    //   2338: aload 6
    //   2340: lload_3
    //   2341: invokestatic 1044	com/whatsapp/gcm/a/c:a	(Lcom/whatsapp/gcm/a/a;J)Ljava/lang/Runnable;
    //   2344: invokevirtual 734	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   2347: pop
    //   2348: ldc_w 1046
    //   2351: invokestatic 270	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2354: goto -1769 -> 585
    //   2357: iconst_0
    //   2358: istore 5
    //   2360: goto -1162 -> 1198
    //   2363: aload 7
    //   2365: invokevirtual 1052	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   2368: astore 6
    //   2370: aload 6
    //   2372: ifnull +300 -> 2672
    //   2375: aload 6
    //   2377: invokeinterface 1058 1 0
    //   2382: astore 7
    //   2384: aload 7
    //   2386: invokeinterface 1063 1 0
    //   2391: ifeq +281 -> 2672
    //   2394: aload 7
    //   2396: invokeinterface 1066 1 0
    //   2401: checkcast 1068	android/app/ActivityManager$RunningAppProcessInfo
    //   2404: astore 8
    //   2406: invokestatic 1073	android/os/Process:myPid	()I
    //   2409: aload 8
    //   2411: getfield 1076	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   2414: if_icmpne -30 -> 2384
    //   2417: ldc_w 1078
    //   2420: aload 8
    //   2422: getfield 1081	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   2425: invokevirtual 1087	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2428: ifne -44 -> 2384
    //   2431: new 253	java/lang/StringBuilder
    //   2434: dup
    //   2435: ldc_w 1089
    //   2438: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2441: aload 8
    //   2443: getfield 1081	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   2446: invokevirtual 469	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2449: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2452: invokestatic 270	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2455: iconst_0
    //   2456: istore_1
    //   2457: goto -1220 -> 1237
    //   2460: ldc_w 1091
    //   2463: invokestatic 270	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2466: aload 9
    //   2468: invokeinterface 445 1 0
    //   2473: goto -1888 -> 585
    //   2476: astore 6
    //   2478: aload 6
    //   2480: invokevirtual 1092	java/io/IOException:toString	()Ljava/lang/String;
    //   2483: astore 6
    //   2485: iload_2
    //   2486: istore_1
    //   2487: goto -1116 -> 1371
    //   2490: ldc_w 757
    //   2493: astore 6
    //   2495: goto -1076 -> 1419
    //   2498: aload 6
    //   2500: new 6	com/whatsapp/v$1
    //   2503: dup
    //   2504: invokespecial 1093	com/whatsapp/v$1:<init>	()V
    //   2507: bipush 32
    //   2509: invokevirtual 1099	android/telephony/TelephonyManager:listen	(Landroid/telephony/PhoneStateListener;I)V
    //   2512: goto -1056 -> 1456
    //   2515: astore 8
    //   2517: aconst_null
    //   2518: astore 6
    //   2520: aload 6
    //   2522: astore 7
    //   2524: new 253	java/lang/StringBuilder
    //   2527: dup
    //   2528: ldc_w 1101
    //   2531: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2534: aload 8
    //   2536: invokevirtual 1102	java/lang/ClassNotFoundException:toString	()Ljava/lang/String;
    //   2539: invokevirtual 469	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2542: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2545: invokestatic 310	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   2548: aload 6
    //   2550: invokestatic 808	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   2553: goto -1024 -> 1529
    //   2556: astore 8
    //   2558: aconst_null
    //   2559: astore 6
    //   2561: aload 6
    //   2563: astore 7
    //   2565: new 253	java/lang/StringBuilder
    //   2568: dup
    //   2569: ldc_w 1104
    //   2572: invokespecial 259	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2575: aload 8
    //   2577: invokevirtual 1092	java/io/IOException:toString	()Ljava/lang/String;
    //   2580: invokevirtual 469	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2583: invokevirtual 267	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2586: invokestatic 1106	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   2589: aload 6
    //   2591: invokestatic 808	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   2594: goto -1065 -> 1529
    //   2597: astore_0
    //   2598: aconst_null
    //   2599: astore 7
    //   2601: aload 7
    //   2603: invokestatic 808	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   2606: aload_0
    //   2607: athrow
    //   2608: iconst_0
    //   2609: istore 5
    //   2611: goto -496 -> 2115
    //   2614: aload 22
    //   2616: getfield 1107	com/whatsapp/aog:c	Lcom/whatsapp/atv;
    //   2619: getfield 416	com/whatsapp/atv:a	Landroid/content/SharedPreferences;
    //   2622: ldc_w 1109
    //   2625: lconst_0
    //   2626: invokeinterface 691 4 0
    //   2631: ldc2_w 1110
    //   2634: ladd
    //   2635: invokestatic 659	java/lang/System:currentTimeMillis	()J
    //   2638: lcmp
    //   2639: ifgt -423 -> 2216
    //   2642: aload 22
    //   2644: invokestatic 1116	com/whatsapp/aoh:a	(Lcom/whatsapp/aog;)Ljava/lang/Runnable;
    //   2647: invokestatic 455	com/whatsapp/util/bu:a	(Ljava/lang/Runnable;)V
    //   2650: goto -434 -> 2216
    //   2653: astore 6
    //   2655: goto -439 -> 2216
    //   2658: astore_0
    //   2659: goto -58 -> 2601
    //   2662: astore 8
    //   2664: goto -103 -> 2561
    //   2667: astore 8
    //   2669: goto -149 -> 2520
    //   2672: iconst_1
    //   2673: istore_1
    //   2674: goto -1437 -> 1237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2677	0	paramApplication	Application
    //   1236	1438	1	i	int
    //   1316	1170	2	j	int
    //   3	2338	3	l	long
    //   1196	1414	5	bool	boolean
    //   293	2083	6	localObject1	Object
    //   2476	3	6	localIOException1	java.io.IOException
    //   2483	107	6	str	String
    //   2653	1	6	localSettingNotFoundException	android.provider.Settings.SettingNotFoundException
    //   22	2580	7	localObject2	Object
    //   82	2360	8	localObject3	Object
    //   2515	20	8	localClassNotFoundException1	ClassNotFoundException
    //   2556	20	8	localIOException2	java.io.IOException
    //   2662	1	8	localIOException3	java.io.IOException
    //   2667	1	8	localClassNotFoundException2	ClassNotFoundException
    //   9	2458	9	locald	com.whatsapp.k.d
    //   37	2225	10	localpv	pv
    //   42	547	11	locala	com.whatsapp.util.a.a
    //   62	529	12	localox	ox
    //   67	526	13	localbf	com.whatsapp.util.bf
    //   72	2145	14	localx	com.whatsapp.registration.x
    //   102	2071	15	localand	and
    //   117	482	16	localmf	mf
    //   132	1411	17	localvv	vv
    //   137	1641	18	localane	ane
    //   167	438	19	localatu	atu
    //   172	2061	20	localatv	atv
    //   27	2233	21	locala1	com.whatsapp.c.a
    //   32	2611	22	localaog	aog
    //   52	2112	23	localva	va
    //   57	1970	24	localahc	ahc
    //   92	1982	25	locale	e
    //   97	1819	26	localm	m
    //   162	1811	27	localaw	com.whatsapp.registration.aw
    //   187	1695	28	localpd	pd
    //   197	1747	29	localbb	bb
    //   47	1755	30	localc	com.whatsapp.util.a.c
    //   127	1634	31	locali	com.whatsapp.contact.sync.i
    //   142	1684	32	localrl	rl
    //   77	1589	33	localad	com.whatsapp.data.ad
    //   87	1552	34	localmg	mg
    //   112	1592	35	localaus	aus
    //   122	1566	36	localac	com.whatsapp.data.ac
    //   157	1549	37	localf	f
    //   177	1522	38	locallt	lt
    //   192	1509	39	localk	k
    //   107	299	40	localObject4	Object
    //   147	200	41	localv	com.whatsapp.data.v
    //   182	173	42	localsh	sh
    //   152	157	43	localus	us
    //   632	16	44	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   1317	1350	2476	java/io/IOException
    //   1356	1364	2476	java/io/IOException
    //   1465	1507	2515	java/lang/ClassNotFoundException
    //   1465	1507	2556	java/io/IOException
    //   1465	1507	2597	finally
    //   2172	2179	2653	android/provider/Settings$SettingNotFoundException
    //   2184	2211	2653	android/provider/Settings$SettingNotFoundException
    //   2614	2650	2653	android/provider/Settings$SettingNotFoundException
    //   1511	1524	2658	finally
    //   2524	2548	2658	finally
    //   2565	2589	2658	finally
    //   1511	1524	2662	java/io/IOException
    //   1511	1524	2667	java/lang/ClassNotFoundException
  }
  
  public static boolean a()
  {
    return b;
  }
  
  public static long b()
  {
    return a;
  }
  
  private static void c(Application paramApplication)
  {
    Object localObject2;
    try
    {
      paramApplication = paramApplication.getPackageManager();
      if (paramApplication == null) {
        return;
      }
      localObject2 = paramApplication.getInstalledApplications(1152);
      if (localObject2 == null) {
        return;
      }
      paramApplication = new StringBuilder("app/installed");
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ArrayList)localObject1).add(((ApplicationInfo)((Iterator)localObject2).next()).packageName);
      }
      Collections.sort((List)localObject1);
    }
    catch (Exception paramApplication)
    {
      Log.e("app-init/async/installed " + paramApplication.toString());
      return;
    }
    Object localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      paramApplication.append(" ").append((String)localObject2);
    }
    Log.d(paramApplication.toString());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */