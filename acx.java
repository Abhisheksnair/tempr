package com.whatsapp;

import android.content.Context;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.webkit.URLUtil;
import com.whatsapp.data.ad;
import com.whatsapp.data.e;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import com.whatsapp.util.w;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class acx
  extends AsyncTask<Void, Void, b>
{
  private static final HashMap<String, acx> c = new HashMap();
  private ace a;
  private int b;
  private final pv d = pv.a();
  private final ad e = ad.a();
  private final e f = e.a();
  private final mf g = mf.a();
  private final dh h = dh.a();
  private final w i = w.a();
  
  private acx(ace paramace, int paramInt)
  {
    this.a = paramace;
    this.b = paramInt;
  }
  
  /* Error */
  private b a(File paramFile, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 14
    //   9: aconst_null
    //   10: astore 11
    //   12: aconst_null
    //   13: astore 12
    //   15: aconst_null
    //   16: astore 9
    //   18: new 95	java/io/FileOutputStream
    //   21: dup
    //   22: aload_1
    //   23: iconst_1
    //   24: invokespecial 98	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   27: astore 15
    //   29: aload 13
    //   31: astore 7
    //   33: aload 14
    //   35: astore 8
    //   37: aload_0
    //   38: getfield 86	com/whatsapp/acx:a	Lcom/whatsapp/ace;
    //   41: getfield 103	com/whatsapp/ace:e	Ljava/net/URL;
    //   44: invokevirtual 109	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   47: astore 6
    //   49: aload 13
    //   51: astore 7
    //   53: aload 14
    //   55: astore 8
    //   57: aload 6
    //   59: instanceof 111
    //   62: ifeq +206 -> 268
    //   65: aload 13
    //   67: astore 7
    //   69: aload 14
    //   71: astore 8
    //   73: aload 6
    //   75: checkcast 111	javax/net/ssl/HttpsURLConnection
    //   78: astore 6
    //   80: aload 13
    //   82: astore 7
    //   84: aload 14
    //   86: astore 8
    //   88: aload 6
    //   90: invokestatic 116	com/whatsapp/messaging/ar:a	()Lcom/whatsapp/messaging/ar;
    //   93: invokevirtual 120	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   96: aload 13
    //   98: astore 7
    //   100: aload 14
    //   102: astore 8
    //   104: aload 6
    //   106: sipush 15000
    //   109: invokevirtual 124	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   112: aload 13
    //   114: astore 7
    //   116: aload 14
    //   118: astore 8
    //   120: aload 6
    //   122: sipush 30000
    //   125: invokevirtual 127	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   128: aload 13
    //   130: astore 7
    //   132: aload 14
    //   134: astore 8
    //   136: aload 6
    //   138: ldc -127
    //   140: invokestatic 134	com/whatsapp/ape:a	()Ljava/lang/String;
    //   143: invokevirtual 138	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: lload_2
    //   147: lconst_0
    //   148: lcmp
    //   149: ifle +39 -> 188
    //   152: aload 13
    //   154: astore 7
    //   156: aload 14
    //   158: astore 8
    //   160: aload 6
    //   162: ldc -116
    //   164: new 142	java/lang/StringBuilder
    //   167: dup
    //   168: ldc -112
    //   170: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   173: lload_2
    //   174: invokevirtual 151	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   177: ldc -103
    //   179: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokevirtual 138	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload 6
    //   190: ifnonnull +257 -> 447
    //   193: aload 11
    //   195: astore 8
    //   197: aload 12
    //   199: astore 9
    //   201: new 10	com/whatsapp/acx$b
    //   204: dup
    //   205: aload_0
    //   206: aload_1
    //   207: getstatic 162	com/whatsapp/acx$c:b	Lcom/whatsapp/acx$c;
    //   210: invokespecial 165	com/whatsapp/acx$b:<init>	(Lcom/whatsapp/acx;Ljava/io/File;Lcom/whatsapp/acx$c;)V
    //   213: astore 7
    //   215: aload 6
    //   217: ifnull +8 -> 225
    //   220: aload 6
    //   222: invokevirtual 168	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   225: aload 15
    //   227: invokevirtual 171	java/io/FileOutputStream:close	()V
    //   230: aload 7
    //   232: areturn
    //   233: astore 6
    //   235: new 142	java/lang/StringBuilder
    //   238: dup
    //   239: ldc -83
    //   241: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   244: aload 6
    //   246: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   249: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   255: new 10	com/whatsapp/acx$b
    //   258: dup
    //   259: aload_0
    //   260: aload_1
    //   261: getstatic 162	com/whatsapp/acx$c:b	Lcom/whatsapp/acx$c;
    //   264: invokespecial 165	com/whatsapp/acx$b:<init>	(Lcom/whatsapp/acx;Ljava/io/File;Lcom/whatsapp/acx$c;)V
    //   267: areturn
    //   268: aload 13
    //   270: astore 7
    //   272: aload 14
    //   274: astore 8
    //   276: new 7	com/whatsapp/acx$a
    //   279: dup
    //   280: aload_0
    //   281: new 142	java/lang/StringBuilder
    //   284: dup
    //   285: ldc -73
    //   287: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   290: aload 6
    //   292: invokevirtual 189	java/lang/Object:getClass	()Ljava/lang/Class;
    //   295: invokevirtual 194	java/lang/Class:getName	()Ljava/lang/String;
    //   298: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokespecial 197	com/whatsapp/acx$a:<init>	(Lcom/whatsapp/acx;Ljava/lang/String;)V
    //   307: athrow
    //   308: astore 8
    //   310: aconst_null
    //   311: astore 7
    //   313: aconst_null
    //   314: astore 6
    //   316: aload 8
    //   318: instanceof 199
    //   321: ifne +19 -> 340
    //   324: aload 8
    //   326: instanceof 201
    //   329: ifne +11 -> 340
    //   332: aload 8
    //   334: instanceof 203
    //   337: ifeq +1053 -> 1390
    //   340: new 142	java/lang/StringBuilder
    //   343: dup
    //   344: ldc -51
    //   346: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   349: aload 8
    //   351: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   360: new 10	com/whatsapp/acx$b
    //   363: dup
    //   364: aload_0
    //   365: aload_1
    //   366: getstatic 207	com/whatsapp/acx$c:a	Lcom/whatsapp/acx$c;
    //   369: invokespecial 165	com/whatsapp/acx$b:<init>	(Lcom/whatsapp/acx;Ljava/io/File;Lcom/whatsapp/acx$c;)V
    //   372: astore_1
    //   373: aload 7
    //   375: ifnull +8 -> 383
    //   378: aload 7
    //   380: invokevirtual 168	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   383: aload 6
    //   385: ifnull +8 -> 393
    //   388: aload 6
    //   390: invokevirtual 210	java/io/InputStream:close	()V
    //   393: aload 15
    //   395: invokevirtual 171	java/io/FileOutputStream:close	()V
    //   398: aload_1
    //   399: areturn
    //   400: astore 6
    //   402: new 142	java/lang/StringBuilder
    //   405: dup
    //   406: ldc -44
    //   408: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   411: aload 6
    //   413: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   422: aload_1
    //   423: areturn
    //   424: astore_1
    //   425: new 142	java/lang/StringBuilder
    //   428: dup
    //   429: ldc -44
    //   431: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   434: aload_1
    //   435: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   444: goto -214 -> 230
    //   447: aload 11
    //   449: astore 8
    //   451: aload 12
    //   453: astore 9
    //   455: aload 6
    //   457: invokevirtual 215	javax/net/ssl/HttpsURLConnection:connect	()V
    //   460: aload 11
    //   462: astore 8
    //   464: aload 12
    //   466: astore 9
    //   468: aload 6
    //   470: invokevirtual 219	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   473: istore 5
    //   475: sipush 200
    //   478: istore 4
    //   480: lload_2
    //   481: lconst_0
    //   482: lcmp
    //   483: ifle +8 -> 491
    //   486: sipush 206
    //   489: istore 4
    //   491: iload 5
    //   493: iload 4
    //   495: if_icmpne +728 -> 1223
    //   498: aload 11
    //   500: astore 8
    //   502: aload 12
    //   504: astore 9
    //   506: aload 6
    //   508: invokevirtual 223	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   511: astore 7
    //   513: aload 7
    //   515: astore 8
    //   517: aload 7
    //   519: astore 9
    //   521: sipush 8192
    //   524: newarray <illegal type>
    //   526: astore 10
    //   528: aload 7
    //   530: astore 8
    //   532: aload 7
    //   534: astore 9
    //   536: aload 7
    //   538: aload 10
    //   540: iconst_0
    //   541: sipush 8192
    //   544: invokevirtual 227	java/io/InputStream:read	([BII)I
    //   547: istore 4
    //   549: iload 4
    //   551: iconst_m1
    //   552: if_icmpeq +215 -> 767
    //   555: aload 7
    //   557: astore 8
    //   559: aload 7
    //   561: astore 9
    //   563: aload_0
    //   564: invokevirtual 231	com/whatsapp/acx:isCancelled	()Z
    //   567: ifeq +99 -> 666
    //   570: aload 7
    //   572: astore 8
    //   574: aload 7
    //   576: astore 9
    //   578: new 10	com/whatsapp/acx$b
    //   581: dup
    //   582: aload_0
    //   583: aload_1
    //   584: getstatic 162	com/whatsapp/acx$c:b	Lcom/whatsapp/acx$c;
    //   587: invokespecial 165	com/whatsapp/acx$b:<init>	(Lcom/whatsapp/acx;Ljava/io/File;Lcom/whatsapp/acx$c;)V
    //   590: astore 10
    //   592: aload 6
    //   594: ifnull +8 -> 602
    //   597: aload 6
    //   599: invokevirtual 168	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   602: aload 7
    //   604: ifnull +8 -> 612
    //   607: aload 7
    //   609: invokevirtual 210	java/io/InputStream:close	()V
    //   612: aload 15
    //   614: invokevirtual 171	java/io/FileOutputStream:close	()V
    //   617: aload 10
    //   619: areturn
    //   620: astore_1
    //   621: new 142	java/lang/StringBuilder
    //   624: dup
    //   625: ldc -23
    //   627: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   630: aload_1
    //   631: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   634: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   640: goto -28 -> 612
    //   643: astore_1
    //   644: new 142	java/lang/StringBuilder
    //   647: dup
    //   648: ldc -44
    //   650: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   653: aload_1
    //   654: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   657: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   660: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   663: goto -46 -> 617
    //   666: aload 7
    //   668: astore 8
    //   670: aload 7
    //   672: astore 9
    //   674: aload 15
    //   676: aload 10
    //   678: iconst_0
    //   679: iload 4
    //   681: invokevirtual 237	java/io/FileOutputStream:write	([BII)V
    //   684: goto -156 -> 528
    //   687: astore 10
    //   689: aload 7
    //   691: astore 8
    //   693: aload 7
    //   695: astore 9
    //   697: new 142	java/lang/StringBuilder
    //   700: dup
    //   701: ldc -17
    //   703: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   706: aload 10
    //   708: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   711: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   714: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   717: aload 7
    //   719: astore 8
    //   721: aload 7
    //   723: astore 9
    //   725: new 10	com/whatsapp/acx$b
    //   728: dup
    //   729: aload_0
    //   730: aload_1
    //   731: getstatic 207	com/whatsapp/acx$c:a	Lcom/whatsapp/acx$c;
    //   734: invokespecial 165	com/whatsapp/acx$b:<init>	(Lcom/whatsapp/acx;Ljava/io/File;Lcom/whatsapp/acx$c;)V
    //   737: astore 10
    //   739: aload 6
    //   741: ifnull +8 -> 749
    //   744: aload 6
    //   746: invokevirtual 168	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   749: aload 7
    //   751: ifnull +8 -> 759
    //   754: aload 7
    //   756: invokevirtual 210	java/io/InputStream:close	()V
    //   759: aload 15
    //   761: invokevirtual 171	java/io/FileOutputStream:close	()V
    //   764: aload 10
    //   766: areturn
    //   767: iload 5
    //   769: sipush 200
    //   772: if_icmpne +121 -> 893
    //   775: aload 7
    //   777: astore 8
    //   779: aload 7
    //   781: astore 9
    //   783: aload 6
    //   785: invokevirtual 242	javax/net/ssl/HttpsURLConnection:getContentLength	()I
    //   788: i2l
    //   789: aload_1
    //   790: invokevirtual 248	java/io/File:length	()J
    //   793: lcmp
    //   794: ifne +99 -> 893
    //   797: aload 7
    //   799: astore 8
    //   801: aload 7
    //   803: astore 9
    //   805: new 10	com/whatsapp/acx$b
    //   808: dup
    //   809: aload_0
    //   810: aload_1
    //   811: getstatic 250	com/whatsapp/acx$c:c	Lcom/whatsapp/acx$c;
    //   814: invokespecial 165	com/whatsapp/acx$b:<init>	(Lcom/whatsapp/acx;Ljava/io/File;Lcom/whatsapp/acx$c;)V
    //   817: astore 10
    //   819: aload 6
    //   821: ifnull +8 -> 829
    //   824: aload 6
    //   826: invokevirtual 168	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   829: aload 7
    //   831: ifnull +8 -> 839
    //   834: aload 7
    //   836: invokevirtual 210	java/io/InputStream:close	()V
    //   839: aload 15
    //   841: invokevirtual 171	java/io/FileOutputStream:close	()V
    //   844: aload 10
    //   846: areturn
    //   847: astore_1
    //   848: new 142	java/lang/StringBuilder
    //   851: dup
    //   852: ldc -23
    //   854: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   857: aload_1
    //   858: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   861: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   864: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   867: goto -28 -> 839
    //   870: astore_1
    //   871: new 142	java/lang/StringBuilder
    //   874: dup
    //   875: ldc -44
    //   877: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   880: aload_1
    //   881: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   884: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   887: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   890: goto -46 -> 844
    //   893: iload 5
    //   895: sipush 206
    //   898: if_icmpne +207 -> 1105
    //   901: aload 7
    //   903: astore 8
    //   905: aload 7
    //   907: astore 9
    //   909: aload 6
    //   911: ldc -4
    //   913: invokevirtual 256	javax/net/ssl/HttpsURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   916: astore 10
    //   918: aload 7
    //   920: astore 8
    //   922: aload 7
    //   924: astore 9
    //   926: aload 10
    //   928: invokevirtual 261	java/lang/String:isEmpty	()Z
    //   931: ifne +122 -> 1053
    //   934: aload 7
    //   936: astore 8
    //   938: aload 7
    //   940: astore 9
    //   942: aload 10
    //   944: ldc_w 263
    //   947: invokevirtual 267	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   950: astore 10
    //   952: aload 7
    //   954: astore 8
    //   956: aload 7
    //   958: astore 9
    //   960: aload 10
    //   962: arraylength
    //   963: iconst_2
    //   964: if_icmpne +89 -> 1053
    //   967: aload 7
    //   969: astore 8
    //   971: aload 7
    //   973: astore 9
    //   975: aload 10
    //   977: iconst_1
    //   978: aaload
    //   979: invokestatic 273	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   982: istore 4
    //   984: aload 7
    //   986: astore 8
    //   988: aload 7
    //   990: astore 9
    //   992: iload 4
    //   994: i2l
    //   995: aload_1
    //   996: invokevirtual 248	java/io/File:length	()J
    //   999: lcmp
    //   1000: ifne +105 -> 1105
    //   1003: aload 7
    //   1005: astore 8
    //   1007: aload 7
    //   1009: astore 9
    //   1011: new 10	com/whatsapp/acx$b
    //   1014: dup
    //   1015: aload_0
    //   1016: aload_1
    //   1017: getstatic 250	com/whatsapp/acx$c:c	Lcom/whatsapp/acx$c;
    //   1020: invokespecial 165	com/whatsapp/acx$b:<init>	(Lcom/whatsapp/acx;Ljava/io/File;Lcom/whatsapp/acx$c;)V
    //   1023: astore 10
    //   1025: aload 6
    //   1027: ifnull +8 -> 1035
    //   1030: aload 6
    //   1032: invokevirtual 168	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1035: aload 7
    //   1037: ifnull +8 -> 1045
    //   1040: aload 7
    //   1042: invokevirtual 210	java/io/InputStream:close	()V
    //   1045: aload 15
    //   1047: invokevirtual 171	java/io/FileOutputStream:close	()V
    //   1050: aload 10
    //   1052: areturn
    //   1053: iconst_m1
    //   1054: istore 4
    //   1056: goto -72 -> 984
    //   1059: astore_1
    //   1060: new 142	java/lang/StringBuilder
    //   1063: dup
    //   1064: ldc -23
    //   1066: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1069: aload_1
    //   1070: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1073: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1076: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1079: goto -34 -> 1045
    //   1082: astore_1
    //   1083: new 142	java/lang/StringBuilder
    //   1086: dup
    //   1087: ldc -44
    //   1089: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1092: aload_1
    //   1093: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1096: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1099: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1102: goto -52 -> 1050
    //   1105: aload 7
    //   1107: astore 8
    //   1109: aload 7
    //   1111: astore 9
    //   1113: new 142	java/lang/StringBuilder
    //   1116: dup
    //   1117: ldc_w 275
    //   1120: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1123: aload_0
    //   1124: getfield 86	com/whatsapp/acx:a	Lcom/whatsapp/ace;
    //   1127: getfield 103	com/whatsapp/ace:e	Ljava/net/URL;
    //   1130: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1133: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1136: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1139: aload 6
    //   1141: ifnull +8 -> 1149
    //   1144: aload 6
    //   1146: invokevirtual 168	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1149: aload 7
    //   1151: ifnull +8 -> 1159
    //   1154: aload 7
    //   1156: invokevirtual 210	java/io/InputStream:close	()V
    //   1159: aload 15
    //   1161: invokevirtual 171	java/io/FileOutputStream:close	()V
    //   1164: new 10	com/whatsapp/acx$b
    //   1167: dup
    //   1168: aload_0
    //   1169: aload_1
    //   1170: getstatic 162	com/whatsapp/acx$c:b	Lcom/whatsapp/acx$c;
    //   1173: invokespecial 165	com/whatsapp/acx$b:<init>	(Lcom/whatsapp/acx;Ljava/io/File;Lcom/whatsapp/acx$c;)V
    //   1176: areturn
    //   1177: astore_1
    //   1178: new 142	java/lang/StringBuilder
    //   1181: dup
    //   1182: ldc -23
    //   1184: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1187: aload_1
    //   1188: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1191: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1194: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1197: goto -438 -> 759
    //   1200: astore_1
    //   1201: new 142	java/lang/StringBuilder
    //   1204: dup
    //   1205: ldc -44
    //   1207: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1210: aload_1
    //   1211: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1214: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1217: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1220: goto -456 -> 764
    //   1223: aload 11
    //   1225: astore 8
    //   1227: aload 12
    //   1229: astore 9
    //   1231: new 142	java/lang/StringBuilder
    //   1234: dup
    //   1235: ldc_w 277
    //   1238: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1241: iload 5
    //   1243: invokevirtual 280	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1246: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1249: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1252: aload 11
    //   1254: astore 8
    //   1256: aload 12
    //   1258: astore 9
    //   1260: new 10	com/whatsapp/acx$b
    //   1263: dup
    //   1264: aload_0
    //   1265: aload_1
    //   1266: getstatic 162	com/whatsapp/acx$c:b	Lcom/whatsapp/acx$c;
    //   1269: invokespecial 165	com/whatsapp/acx$b:<init>	(Lcom/whatsapp/acx;Ljava/io/File;Lcom/whatsapp/acx$c;)V
    //   1272: astore 7
    //   1274: aload 6
    //   1276: ifnull +8 -> 1284
    //   1279: aload 6
    //   1281: invokevirtual 168	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1284: aload 15
    //   1286: invokevirtual 171	java/io/FileOutputStream:close	()V
    //   1289: aload 7
    //   1291: areturn
    //   1292: astore_1
    //   1293: new 142	java/lang/StringBuilder
    //   1296: dup
    //   1297: ldc -44
    //   1299: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1302: aload_1
    //   1303: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1306: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1309: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1312: goto -23 -> 1289
    //   1315: astore 6
    //   1317: new 142	java/lang/StringBuilder
    //   1320: dup
    //   1321: ldc -23
    //   1323: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1326: aload 6
    //   1328: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1331: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1334: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1337: goto -178 -> 1159
    //   1340: astore 6
    //   1342: new 142	java/lang/StringBuilder
    //   1345: dup
    //   1346: ldc -44
    //   1348: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1351: aload 6
    //   1353: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1356: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1359: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1362: goto -198 -> 1164
    //   1365: astore 6
    //   1367: new 142	java/lang/StringBuilder
    //   1370: dup
    //   1371: ldc -23
    //   1373: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1376: aload 6
    //   1378: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1381: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1384: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1387: goto -994 -> 393
    //   1390: new 142	java/lang/StringBuilder
    //   1393: dup
    //   1394: ldc_w 282
    //   1397: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1400: aload 8
    //   1402: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1405: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1408: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1411: new 10	com/whatsapp/acx$b
    //   1414: dup
    //   1415: aload_0
    //   1416: aload_1
    //   1417: getstatic 162	com/whatsapp/acx$c:b	Lcom/whatsapp/acx$c;
    //   1420: invokespecial 165	com/whatsapp/acx$b:<init>	(Lcom/whatsapp/acx;Ljava/io/File;Lcom/whatsapp/acx$c;)V
    //   1423: astore_1
    //   1424: aload 7
    //   1426: ifnull +8 -> 1434
    //   1429: aload 7
    //   1431: invokevirtual 168	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1434: aload 6
    //   1436: ifnull +8 -> 1444
    //   1439: aload 6
    //   1441: invokevirtual 210	java/io/InputStream:close	()V
    //   1444: aload 15
    //   1446: invokevirtual 171	java/io/FileOutputStream:close	()V
    //   1449: aload_1
    //   1450: areturn
    //   1451: astore 6
    //   1453: new 142	java/lang/StringBuilder
    //   1456: dup
    //   1457: ldc -44
    //   1459: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1462: aload 6
    //   1464: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1467: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1470: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1473: aload_1
    //   1474: areturn
    //   1475: astore 6
    //   1477: new 142	java/lang/StringBuilder
    //   1480: dup
    //   1481: ldc -23
    //   1483: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1486: aload 6
    //   1488: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1491: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1494: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1497: goto -53 -> 1444
    //   1500: astore 7
    //   1502: aload 10
    //   1504: astore 6
    //   1506: aload 7
    //   1508: astore 10
    //   1510: aload 6
    //   1512: astore 7
    //   1514: aload 9
    //   1516: astore 8
    //   1518: new 142	java/lang/StringBuilder
    //   1521: dup
    //   1522: ldc_w 284
    //   1525: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1528: aload 10
    //   1530: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1533: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1536: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1539: aload 6
    //   1541: astore 7
    //   1543: aload 9
    //   1545: astore 8
    //   1547: new 10	com/whatsapp/acx$b
    //   1550: dup
    //   1551: aload_0
    //   1552: aload_1
    //   1553: getstatic 207	com/whatsapp/acx$c:a	Lcom/whatsapp/acx$c;
    //   1556: invokespecial 165	com/whatsapp/acx$b:<init>	(Lcom/whatsapp/acx;Ljava/io/File;Lcom/whatsapp/acx$c;)V
    //   1559: astore_1
    //   1560: aload 6
    //   1562: ifnull +8 -> 1570
    //   1565: aload 6
    //   1567: invokevirtual 168	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1570: aload 9
    //   1572: ifnull +8 -> 1580
    //   1575: aload 9
    //   1577: invokevirtual 210	java/io/InputStream:close	()V
    //   1580: aload 15
    //   1582: invokevirtual 171	java/io/FileOutputStream:close	()V
    //   1585: aload_1
    //   1586: areturn
    //   1587: astore 6
    //   1589: new 142	java/lang/StringBuilder
    //   1592: dup
    //   1593: ldc -44
    //   1595: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1598: aload 6
    //   1600: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1603: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1606: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1609: aload_1
    //   1610: areturn
    //   1611: astore 6
    //   1613: new 142	java/lang/StringBuilder
    //   1616: dup
    //   1617: ldc -23
    //   1619: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1622: aload 6
    //   1624: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1627: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1630: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1633: goto -53 -> 1580
    //   1636: astore_1
    //   1637: aload 7
    //   1639: ifnull +8 -> 1647
    //   1642: aload 7
    //   1644: invokevirtual 168	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1647: aload 8
    //   1649: ifnull +8 -> 1657
    //   1652: aload 8
    //   1654: invokevirtual 210	java/io/InputStream:close	()V
    //   1657: aload 15
    //   1659: invokevirtual 171	java/io/FileOutputStream:close	()V
    //   1662: aload_1
    //   1663: athrow
    //   1664: astore 6
    //   1666: new 142	java/lang/StringBuilder
    //   1669: dup
    //   1670: ldc -23
    //   1672: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1675: aload 6
    //   1677: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1680: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1683: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1686: goto -29 -> 1657
    //   1689: astore 6
    //   1691: new 142	java/lang/StringBuilder
    //   1694: dup
    //   1695: ldc -44
    //   1697: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1700: aload 6
    //   1702: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1705: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1708: invokestatic 181	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1711: goto -49 -> 1662
    //   1714: astore_1
    //   1715: aload 6
    //   1717: astore 7
    //   1719: goto -82 -> 1637
    //   1722: astore_1
    //   1723: aload 6
    //   1725: astore 8
    //   1727: goto -90 -> 1637
    //   1730: astore 10
    //   1732: goto -222 -> 1510
    //   1735: astore 8
    //   1737: aconst_null
    //   1738: astore 9
    //   1740: aload 6
    //   1742: astore 7
    //   1744: aload 9
    //   1746: astore 6
    //   1748: goto -1432 -> 316
    //   1751: astore 8
    //   1753: aload 6
    //   1755: astore 9
    //   1757: aload 7
    //   1759: astore 6
    //   1761: aload 9
    //   1763: astore 7
    //   1765: goto -1449 -> 316
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1768	0	this	acx
    //   0	1768	1	paramFile	File
    //   0	1768	2	paramLong	long
    //   478	577	4	j	int
    //   473	769	5	k	int
    //   47	174	6	localObject1	Object
    //   233	58	6	localFileNotFoundException	java.io.FileNotFoundException
    //   314	75	6	localObject2	Object
    //   400	880	6	localIOException1	IOException
    //   1315	12	6	localIOException2	IOException
    //   1340	12	6	localIOException3	IOException
    //   1365	75	6	localIOException4	IOException
    //   1451	12	6	localIOException5	IOException
    //   1475	12	6	localIOException6	IOException
    //   1504	62	6	localObject3	Object
    //   1587	12	6	localIOException7	IOException
    //   1611	12	6	localIOException8	IOException
    //   1664	12	6	localIOException9	IOException
    //   1689	52	6	localIOException10	IOException
    //   1746	14	6	localObject4	Object
    //   31	1399	7	localObject5	Object
    //   1500	7	7	locala1	a
    //   1512	252	7	localObject6	Object
    //   35	240	8	localObject7	Object
    //   308	42	8	localIOException11	IOException
    //   449	1277	8	localObject8	Object
    //   1735	1	8	localIOException12	IOException
    //   1751	1	8	localIOException13	IOException
    //   16	1746	9	localObject9	Object
    //   4	673	10	localObject10	Object
    //   687	20	10	localIOException14	IOException
    //   737	792	10	localObject11	Object
    //   1730	1	10	locala2	a
    //   10	1243	11	localObject12	Object
    //   13	1244	12	localObject13	Object
    //   1	268	13	localObject14	Object
    //   7	266	14	localObject15	Object
    //   27	1631	15	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   18	29	233	java/io/FileNotFoundException
    //   37	49	308	java/io/IOException
    //   57	65	308	java/io/IOException
    //   73	80	308	java/io/IOException
    //   88	96	308	java/io/IOException
    //   104	112	308	java/io/IOException
    //   120	128	308	java/io/IOException
    //   136	146	308	java/io/IOException
    //   160	188	308	java/io/IOException
    //   276	308	308	java/io/IOException
    //   393	398	400	java/io/IOException
    //   225	230	424	java/io/IOException
    //   607	612	620	java/io/IOException
    //   612	617	643	java/io/IOException
    //   521	528	687	java/io/IOException
    //   536	549	687	java/io/IOException
    //   563	570	687	java/io/IOException
    //   578	592	687	java/io/IOException
    //   674	684	687	java/io/IOException
    //   783	797	687	java/io/IOException
    //   805	819	687	java/io/IOException
    //   909	918	687	java/io/IOException
    //   926	934	687	java/io/IOException
    //   942	952	687	java/io/IOException
    //   960	967	687	java/io/IOException
    //   975	984	687	java/io/IOException
    //   992	1003	687	java/io/IOException
    //   1011	1025	687	java/io/IOException
    //   1113	1139	687	java/io/IOException
    //   834	839	847	java/io/IOException
    //   839	844	870	java/io/IOException
    //   1040	1045	1059	java/io/IOException
    //   1045	1050	1082	java/io/IOException
    //   754	759	1177	java/io/IOException
    //   759	764	1200	java/io/IOException
    //   1284	1289	1292	java/io/IOException
    //   1154	1159	1315	java/io/IOException
    //   1159	1164	1340	java/io/IOException
    //   388	393	1365	java/io/IOException
    //   1444	1449	1451	java/io/IOException
    //   1439	1444	1475	java/io/IOException
    //   37	49	1500	com/whatsapp/acx$a
    //   57	65	1500	com/whatsapp/acx$a
    //   73	80	1500	com/whatsapp/acx$a
    //   88	96	1500	com/whatsapp/acx$a
    //   104	112	1500	com/whatsapp/acx$a
    //   120	128	1500	com/whatsapp/acx$a
    //   136	146	1500	com/whatsapp/acx$a
    //   160	188	1500	com/whatsapp/acx$a
    //   276	308	1500	com/whatsapp/acx$a
    //   1580	1585	1587	java/io/IOException
    //   1575	1580	1611	java/io/IOException
    //   37	49	1636	finally
    //   57	65	1636	finally
    //   73	80	1636	finally
    //   88	96	1636	finally
    //   104	112	1636	finally
    //   120	128	1636	finally
    //   136	146	1636	finally
    //   160	188	1636	finally
    //   276	308	1636	finally
    //   1518	1539	1636	finally
    //   1547	1560	1636	finally
    //   1652	1657	1664	java/io/IOException
    //   1657	1662	1689	java/io/IOException
    //   201	215	1714	finally
    //   455	460	1714	finally
    //   468	475	1714	finally
    //   506	513	1714	finally
    //   521	528	1714	finally
    //   536	549	1714	finally
    //   563	570	1714	finally
    //   578	592	1714	finally
    //   674	684	1714	finally
    //   697	717	1714	finally
    //   725	739	1714	finally
    //   783	797	1714	finally
    //   805	819	1714	finally
    //   909	918	1714	finally
    //   926	934	1714	finally
    //   942	952	1714	finally
    //   960	967	1714	finally
    //   975	984	1714	finally
    //   992	1003	1714	finally
    //   1011	1025	1714	finally
    //   1113	1139	1714	finally
    //   1231	1252	1714	finally
    //   1260	1274	1714	finally
    //   316	340	1722	finally
    //   340	373	1722	finally
    //   1390	1424	1722	finally
    //   201	215	1730	com/whatsapp/acx$a
    //   455	460	1730	com/whatsapp/acx$a
    //   468	475	1730	com/whatsapp/acx$a
    //   506	513	1730	com/whatsapp/acx$a
    //   521	528	1730	com/whatsapp/acx$a
    //   536	549	1730	com/whatsapp/acx$a
    //   563	570	1730	com/whatsapp/acx$a
    //   578	592	1730	com/whatsapp/acx$a
    //   674	684	1730	com/whatsapp/acx$a
    //   697	717	1730	com/whatsapp/acx$a
    //   725	739	1730	com/whatsapp/acx$a
    //   783	797	1730	com/whatsapp/acx$a
    //   805	819	1730	com/whatsapp/acx$a
    //   909	918	1730	com/whatsapp/acx$a
    //   926	934	1730	com/whatsapp/acx$a
    //   942	952	1730	com/whatsapp/acx$a
    //   960	967	1730	com/whatsapp/acx$a
    //   975	984	1730	com/whatsapp/acx$a
    //   992	1003	1730	com/whatsapp/acx$a
    //   1011	1025	1730	com/whatsapp/acx$a
    //   1113	1139	1730	com/whatsapp/acx$a
    //   1231	1252	1730	com/whatsapp/acx$a
    //   1260	1274	1730	com/whatsapp/acx$a
    //   201	215	1735	java/io/IOException
    //   455	460	1735	java/io/IOException
    //   468	475	1735	java/io/IOException
    //   506	513	1735	java/io/IOException
    //   1231	1252	1735	java/io/IOException
    //   1260	1274	1735	java/io/IOException
    //   697	717	1751	java/io/IOException
    //   725	739	1751	java/io/IOException
  }
  
  public static void a()
  {
    Object localObject3 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    Object localObject4;
    for (;;)
    {
      synchronized (c)
      {
        localObject4 = c.keySet().iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject5 = (String)((Iterator)localObject4).next();
        localObject5 = (acx)c.get(localObject5);
        if (localObject5 == null) {
          continue;
        }
        if (!((acx)localObject5).getStatus().equals(AsyncTask.Status.RUNNING))
        {
          a((acx)localObject5);
          ((List)localObject3).add(localObject5);
        }
      }
      Object localObject5 = b((acx)localObject5);
      if (((File)localObject5).exists()) {
        ((List)localObject1).add(localObject5);
      }
    }
    localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (acx)((Iterator)localObject3).next();
      c.remove(((acx)localObject4).a.a);
    }
    ??? = c().listFiles();
    int k = ???.length;
    int j = 0;
    while (j < k)
    {
      localObject3 = ???[j];
      if (!((List)localObject1).contains(localObject3)) {
        ((File)localObject3).delete();
      }
      j += 1;
    }
  }
  
  public static void a(ace paramace)
  {
    a(paramace, 0);
  }
  
  private static void a(ace paramace, int paramInt)
  {
    synchronized (c)
    {
      acx localacx;
      if (c.containsKey(paramace.a))
      {
        localacx = (acx)c.get(paramace.a);
        if (!localacx.a.e.equals(paramace.e)) {
          break label85;
        }
        if (!localacx.getStatus().equals(AsyncTask.Status.RUNNING)) {
          c.remove(localacx.a.a);
        }
      }
      else
      {
        b(paramace, paramInt);
      }
      return;
      label85:
      localacx.cancel(true);
      c.remove(localacx.a.a);
      b(paramace, paramInt);
    }
  }
  
  private static void a(acx paramacx)
  {
    paramacx = b(paramacx);
    if (paramacx.exists()) {
      paramacx.delete();
    }
  }
  
  private b b()
  {
    File localFile = b(this);
    long l = 0L;
    try
    {
      if (!localFile.createNewFile()) {
        l = localFile.length();
      }
      return a(localFile, l);
    }
    catch (IOException localIOException)
    {
      Log.w("ProfilePictureDownload: Failed, could not create temp file:" + localIOException);
    }
    return new b(localFile, c.b);
  }
  
  private static File b(acx paramacx)
  {
    return new File(c(), URLUtil.guessFileName(paramacx.a.e.toString(), null, null));
  }
  
  private static void b(ace paramace, int paramInt)
  {
    acx localacx = new acx(paramace, paramInt);
    c.put(paramace.a, localacx);
    bu.a(localacx, new Void[0]);
  }
  
  private static File c()
  {
    File localFile = new File(u.a().getCacheDir(), "ProfilePictureTemp");
    localFile.mkdirs();
    return localFile;
  }
  
  protected final void onCancelled()
  {
    a(this);
  }
  
  final class a
    extends Exception
  {
    private final String b;
    
    public a(String paramString)
    {
      this.b = paramString;
    }
    
    public final String toString()
    {
      return this.b;
    }
  }
  
  public final class b
  {
    File a;
    acx.c b;
    
    public b(File paramFile, acx.c paramc)
    {
      this.a = paramFile;
      this.b = paramc;
    }
  }
  
  public static enum c
  {
    private c() {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/acx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */