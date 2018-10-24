package com.whatsapp.gdrive;

import a.a.a.a.a.a.d;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Pair;
import com.whatsapp.ape;
import com.whatsapp.atu;
import com.whatsapp.ox;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRoute;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.DefaultHttpRoutePlanner;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.impl.io.AbstractSessionInputBuffer;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class at
{
  public static final Comparator<bb> b = aw.a();
  private static final Pair<String, Long> c = Pair.create(null, null);
  private static final ConnPerRoute d = av.a();
  private static final String e = "foo_bar_baz" + UUID.randomUUID().toString();
  private static final Pattern f = Pattern.compile("bytes=0-(\\d*)");
  final Set<String> a = new HashSet();
  private final Context g;
  private final DefaultHttpClient h;
  private final b i;
  private final SSLSocketFactory j;
  private final AtomicInteger k = new AtomicInteger(0);
  private final String l;
  private boolean m = true;
  private long n;
  private String o;
  private SharedPreferences p;
  private final d q;
  private ex r;
  private final com.whatsapp.util.a.c s;
  private final ox t;
  private final atu u;
  
  public at(Context paramContext, com.whatsapp.util.a.c paramc, ox paramox, atu paramatu, String paramString, d paramd)
  {
    this.g = paramContext;
    this.s = paramc;
    this.t = paramox;
    this.u = paramatu;
    this.l = paramString;
    this.q = paramd;
    this.i = new b();
    paramContext = this.i;
    paramc = new c();
    paramatu = new BasicHttpParams();
    paramatu.setParameter("http.protocol.version", HttpVersion.HTTP_1_1);
    HttpConnectionParams.setConnectionTimeout(paramatu, 15000);
    HttpConnectionParams.setSoTimeout(paramatu, 30000);
    ConnManagerParams.setMaxConnectionsPerRoute(paramatu, d);
    Log.d("gdrive-api/construct max connections per route: " + ConnManagerParams.getMaxConnectionsPerRoute(paramatu).getMaxForRoute(new HttpRoute(new HttpHost("www.googleapis.com"))));
    HttpProtocolParams.setUseExpectContinue(paramatu, true);
    HttpProtocolParams.setUserAgent(paramatu, ape.a());
    paramox = com.whatsapp.i.d.a(false);
    paramatu = new DefaultHttpClient(new ThreadSafeClientConnManager(paramatu, paramox), paramatu);
    paramatu.setRoutePlanner(new DefaultHttpRoutePlanner(paramox));
    paramatu.addResponseInterceptor(paramc);
    paramatu.addRequestInterceptor(paramContext);
    this.h = paramatu;
    this.j = new d((SSLSocketFactory)SSLSocketFactory.getDefault(), new au(this));
    System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
  }
  
  /* Error */
  private Pair<String, Long> a(File paramFile, String paramString, ev paramev)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: invokespecial 316	com/whatsapp/gdrive/at:g	()Landroid/content/SharedPreferences;
    //   7: aload_0
    //   8: aload_2
    //   9: invokespecial 319	com/whatsapp/gdrive/at:c	(Ljava/lang/String;)Ljava/lang/String;
    //   12: aconst_null
    //   13: invokeinterface 324 3 0
    //   18: astore 8
    //   20: new 84	java/lang/StringBuilder
    //   23: dup
    //   24: ldc_w 326
    //   27: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: aload_2
    //   31: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 328
    //   37: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload 8
    //   42: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   51: aload 8
    //   53: ifnonnull +11 -> 64
    //   56: getstatic 75	com/whatsapp/gdrive/at:c	Landroid/util/Pair;
    //   59: astore 7
    //   61: aload 7
    //   63: areturn
    //   64: new 330	org/apache/http/client/methods/HttpPut
    //   67: dup
    //   68: aload 8
    //   70: invokespecial 331	org/apache/http/client/methods/HttpPut:<init>	(Ljava/lang/String;)V
    //   73: astore 9
    //   75: aload 9
    //   77: ldc_w 333
    //   80: new 84	java/lang/StringBuilder
    //   83: dup
    //   84: ldc_w 335
    //   87: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: aload_0
    //   91: getfield 337	com/whatsapp/gdrive/at:o	Ljava/lang/String;
    //   94: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokevirtual 341	org/apache/http/client/methods/HttpPut:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload 9
    //   105: ldc_w 343
    //   108: getstatic 349	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   111: ldc_w 351
    //   114: iconst_1
    //   115: anewarray 4	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: aload_1
    //   121: invokevirtual 357	java/io/File:length	()J
    //   124: invokestatic 361	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   127: aastore
    //   128: invokestatic 367	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   131: invokevirtual 341	org/apache/http/client/methods/HttpPut:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload_3
    //   135: invokevirtual 372	com/whatsapp/gdrive/ev:a	()Z
    //   138: ifeq -77 -> 61
    //   141: aload_0
    //   142: aload 9
    //   144: invokespecial 375	com/whatsapp/gdrive/at:a	(Lorg/apache/http/client/methods/HttpRequestBase;)Lorg/apache/http/HttpResponse;
    //   147: astore 10
    //   149: aload 10
    //   151: invokeinterface 381 1 0
    //   156: astore 7
    //   158: aload 7
    //   160: astore_3
    //   161: aload 9
    //   163: invokestatic 386	com/whatsapp/gdrive/ch:a	(Lorg/apache/http/client/methods/HttpRequestBase;)V
    //   166: aload 7
    //   168: astore_3
    //   169: aload 10
    //   171: invokeinterface 390 1 0
    //   176: invokeinterface 396 1 0
    //   181: istore 4
    //   183: iload 4
    //   185: sipush 403
    //   188: if_icmpne +117 -> 305
    //   191: aload 7
    //   193: ifnull +61 -> 254
    //   196: aload 7
    //   198: astore_3
    //   199: aload 7
    //   201: invokestatic 401	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   204: astore_1
    //   205: aload 7
    //   207: astore_3
    //   208: aload_0
    //   209: aload_2
    //   210: invokespecial 404	com/whatsapp/gdrive/at:d	(Ljava/lang/String;)Z
    //   213: pop
    //   214: aload 7
    //   216: astore_3
    //   217: aload_1
    //   218: invokestatic 406	com/whatsapp/gdrive/at:e	(Ljava/lang/String;)Z
    //   221: ifeq +38 -> 259
    //   224: aload 7
    //   226: astore_3
    //   227: new 408	com/whatsapp/gdrive/bf
    //   230: dup
    //   231: invokespecial 409	com/whatsapp/gdrive/bf:<init>	()V
    //   234: athrow
    //   235: astore_1
    //   236: aload 7
    //   238: astore_3
    //   239: ldc_w 411
    //   242: aload_1
    //   243: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   246: aload 7
    //   248: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   251: pop
    //   252: aconst_null
    //   253: areturn
    //   254: aconst_null
    //   255: astore_1
    //   256: goto -51 -> 205
    //   259: aload 7
    //   261: astore_3
    //   262: new 84	java/lang/StringBuilder
    //   265: dup
    //   266: ldc_w 419
    //   269: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   272: astore_2
    //   273: aload 7
    //   275: ifnull +25 -> 300
    //   278: aload 7
    //   280: astore_3
    //   281: aload_2
    //   282: aload_1
    //   283: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   292: aload 7
    //   294: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   297: pop
    //   298: aconst_null
    //   299: areturn
    //   300: aconst_null
    //   301: astore_1
    //   302: goto -24 -> 278
    //   305: iload 4
    //   307: sipush 401
    //   310: if_icmpne +19 -> 329
    //   313: aload 7
    //   315: astore_3
    //   316: aload_0
    //   317: invokevirtual 423	com/whatsapp/gdrive/at:b	()Z
    //   320: pop
    //   321: aload 7
    //   323: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   326: pop
    //   327: aconst_null
    //   328: areturn
    //   329: iload 4
    //   331: sipush 308
    //   334: if_icmpne +388 -> 722
    //   337: aload 7
    //   339: astore_3
    //   340: aload 10
    //   342: ldc_w 425
    //   345: invokeinterface 429 2 0
    //   350: astore 9
    //   352: aload 7
    //   354: astore_3
    //   355: aload 9
    //   357: arraylength
    //   358: iconst_1
    //   359: if_icmple +48 -> 407
    //   362: aload 7
    //   364: astore_3
    //   365: new 84	java/lang/StringBuilder
    //   368: dup
    //   369: ldc_w 431
    //   372: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   375: ldc_w 433
    //   378: aload 9
    //   380: invokestatic 439	android/text/TextUtils:join	(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;
    //   383: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   392: aload 7
    //   394: astore_3
    //   395: getstatic 75	com/whatsapp/gdrive/at:c	Landroid/util/Pair;
    //   398: astore_1
    //   399: aload 7
    //   401: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   404: pop
    //   405: aload_1
    //   406: areturn
    //   407: aload 7
    //   409: astore_3
    //   410: aload 9
    //   412: arraylength
    //   413: iconst_1
    //   414: if_icmpne +267 -> 681
    //   417: aload 7
    //   419: astore_3
    //   420: getstatic 117	com/whatsapp/gdrive/at:f	Ljava/util/regex/Pattern;
    //   423: aload 9
    //   425: iconst_0
    //   426: aaload
    //   427: invokeinterface 444 1 0
    //   432: invokevirtual 448	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   435: astore 11
    //   437: aload 7
    //   439: astore_3
    //   440: aload 11
    //   442: invokevirtual 453	java/util/regex/Matcher:find	()Z
    //   445: ifeq +190 -> 635
    //   448: aload 7
    //   450: astore_3
    //   451: aload 11
    //   453: iconst_1
    //   454: invokevirtual 457	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   457: invokestatic 461	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   460: lconst_1
    //   461: ladd
    //   462: lstore 5
    //   464: aload 7
    //   466: astore_3
    //   467: aload_0
    //   468: aload_1
    //   469: lload 5
    //   471: aload 10
    //   473: ldc_w 463
    //   476: invokeinterface 429 2 0
    //   481: iconst_0
    //   482: aaload
    //   483: invokeinterface 444 1 0
    //   488: invokespecial 466	com/whatsapp/gdrive/at:a	(Ljava/io/File;JLjava/lang/String;)Z
    //   491: ifeq +89 -> 580
    //   494: aload 7
    //   496: astore_3
    //   497: new 84	java/lang/StringBuilder
    //   500: dup
    //   501: ldc_w 468
    //   504: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   507: aload_2
    //   508: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: ldc_w 470
    //   514: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: lload 5
    //   519: invokevirtual 473	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   522: ldc_w 475
    //   525: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: aload_1
    //   529: invokevirtual 357	java/io/File:length	()J
    //   532: invokevirtual 473	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   535: ldc_w 477
    //   538: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: lload 5
    //   543: invokevirtual 473	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   546: ldc_w 479
    //   549: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   558: aload 7
    //   560: astore_3
    //   561: aload 8
    //   563: lload 5
    //   565: invokestatic 361	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   568: invokestatic 73	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   571: astore_1
    //   572: aload 7
    //   574: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   577: pop
    //   578: aload_1
    //   579: areturn
    //   580: aload 7
    //   582: astore_3
    //   583: new 84	java/lang/StringBuilder
    //   586: dup
    //   587: ldc_w 468
    //   590: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   593: aload_2
    //   594: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: ldc_w 481
    //   600: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: lload 5
    //   605: invokevirtual 473	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   608: ldc_w 483
    //   611: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   617: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   620: aload 7
    //   622: astore_3
    //   623: getstatic 75	com/whatsapp/gdrive/at:c	Landroid/util/Pair;
    //   626: astore_1
    //   627: aload 7
    //   629: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   632: pop
    //   633: aload_1
    //   634: areturn
    //   635: aload 7
    //   637: astore_3
    //   638: new 84	java/lang/StringBuilder
    //   641: dup
    //   642: ldc_w 487
    //   645: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   648: aload 9
    //   650: iconst_0
    //   651: aaload
    //   652: invokeinterface 444 1 0
    //   657: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   666: aload 7
    //   668: astore_3
    //   669: getstatic 75	com/whatsapp/gdrive/at:c	Landroid/util/Pair;
    //   672: astore_1
    //   673: aload 7
    //   675: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   678: pop
    //   679: aload_1
    //   680: areturn
    //   681: aload 7
    //   683: astore_3
    //   684: ldc_w 489
    //   687: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   690: aload 7
    //   692: astore_3
    //   693: aload 10
    //   695: invokestatic 492	com/whatsapp/gdrive/ch:a	(Lorg/apache/http/HttpResponse;)V
    //   698: aload 7
    //   700: astore_3
    //   701: aload_0
    //   702: aload_2
    //   703: invokespecial 404	com/whatsapp/gdrive/at:d	(Ljava/lang/String;)Z
    //   706: pop
    //   707: aload 7
    //   709: astore_3
    //   710: getstatic 75	com/whatsapp/gdrive/at:c	Landroid/util/Pair;
    //   713: astore_1
    //   714: aload 7
    //   716: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   719: pop
    //   720: aload_1
    //   721: areturn
    //   722: aload 7
    //   724: astore_3
    //   725: new 84	java/lang/StringBuilder
    //   728: dup
    //   729: ldc_w 494
    //   732: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   735: iload 4
    //   737: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   740: ldc_w 433
    //   743: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: aload 10
    //   748: invokeinterface 390 1 0
    //   753: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   756: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   762: aload 7
    //   764: astore_3
    //   765: aload 10
    //   767: invokestatic 492	com/whatsapp/gdrive/ch:a	(Lorg/apache/http/HttpResponse;)V
    //   770: aload 7
    //   772: astore_3
    //   773: aload_0
    //   774: aload_2
    //   775: invokespecial 404	com/whatsapp/gdrive/at:d	(Ljava/lang/String;)Z
    //   778: pop
    //   779: aload 7
    //   781: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   784: pop
    //   785: aconst_null
    //   786: areturn
    //   787: astore_1
    //   788: aconst_null
    //   789: astore_3
    //   790: aload_3
    //   791: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   794: pop
    //   795: aload_1
    //   796: athrow
    //   797: astore_1
    //   798: goto -8 -> 790
    //   801: astore_1
    //   802: aconst_null
    //   803: astore 7
    //   805: goto -569 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	808	0	this	at
    //   0	808	1	paramFile	File
    //   0	808	2	paramString	String
    //   0	808	3	paramev	ev
    //   181	555	4	i1	int
    //   462	142	5	l1	long
    //   1	803	7	localObject1	Object
    //   18	544	8	str	String
    //   73	576	9	localObject2	Object
    //   147	619	10	localHttpResponse	HttpResponse
    //   435	17	11	localMatcher	java.util.regex.Matcher
    // Exception table:
    //   from	to	target	type
    //   161	166	235	java/io/IOException
    //   169	183	235	java/io/IOException
    //   199	205	235	java/io/IOException
    //   208	214	235	java/io/IOException
    //   217	224	235	java/io/IOException
    //   227	235	235	java/io/IOException
    //   262	273	235	java/io/IOException
    //   281	292	235	java/io/IOException
    //   316	321	235	java/io/IOException
    //   340	352	235	java/io/IOException
    //   355	362	235	java/io/IOException
    //   365	392	235	java/io/IOException
    //   395	399	235	java/io/IOException
    //   410	417	235	java/io/IOException
    //   420	437	235	java/io/IOException
    //   440	448	235	java/io/IOException
    //   451	464	235	java/io/IOException
    //   467	494	235	java/io/IOException
    //   497	558	235	java/io/IOException
    //   561	572	235	java/io/IOException
    //   583	620	235	java/io/IOException
    //   623	627	235	java/io/IOException
    //   638	666	235	java/io/IOException
    //   669	673	235	java/io/IOException
    //   684	690	235	java/io/IOException
    //   693	698	235	java/io/IOException
    //   701	707	235	java/io/IOException
    //   710	714	235	java/io/IOException
    //   725	762	235	java/io/IOException
    //   765	770	235	java/io/IOException
    //   773	779	235	java/io/IOException
    //   141	158	787	finally
    //   161	166	797	finally
    //   169	183	797	finally
    //   199	205	797	finally
    //   208	214	797	finally
    //   217	224	797	finally
    //   227	235	797	finally
    //   239	246	797	finally
    //   262	273	797	finally
    //   281	292	797	finally
    //   316	321	797	finally
    //   340	352	797	finally
    //   355	362	797	finally
    //   365	392	797	finally
    //   395	399	797	finally
    //   410	417	797	finally
    //   420	437	797	finally
    //   440	448	797	finally
    //   451	464	797	finally
    //   467	494	797	finally
    //   497	558	797	finally
    //   561	572	797	finally
    //   583	620	797	finally
    //   623	627	797	finally
    //   638	666	797	finally
    //   669	673	797	finally
    //   684	690	797	finally
    //   693	698	797	finally
    //   701	707	797	finally
    //   710	714	797	finally
    //   725	762	797	finally
    //   765	770	797	finally
    //   773	779	797	finally
    //   141	158	801	java/io/IOException
  }
  
  /* Error */
  private bb a(File paramFile, String paramString1, final b paramb, ev paramev, final String paramString2, long paramLong)
  {
    // Byte code:
    //   0: new 330	org/apache/http/client/methods/HttpPut
    //   3: dup
    //   4: aload 5
    //   6: invokespecial 331	org/apache/http/client/methods/HttpPut:<init>	(Ljava/lang/String;)V
    //   9: astore 24
    //   11: aload_1
    //   12: invokevirtual 357	java/io/File:length	()J
    //   15: lstore 9
    //   17: lload 9
    //   19: lconst_1
    //   20: lsub
    //   21: lstore 11
    //   23: new 508	java/io/FileInputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 511	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore 5
    //   33: aload 5
    //   35: lload 6
    //   37: invokevirtual 515	java/io/FileInputStream:skip	(J)J
    //   40: lstore 13
    //   42: lload 13
    //   44: lload 6
    //   46: lcmp
    //   47: ifeq +48 -> 95
    //   50: new 84	java/lang/StringBuilder
    //   53: dup
    //   54: ldc_w 517
    //   57: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: aload_1
    //   61: invokevirtual 520	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   64: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 522
    //   70: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: lload 6
    //   75: invokevirtual 473	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   78: ldc_w 524
    //   81: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: lload 13
    //   86: invokevirtual 473	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   89: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   95: new 526	java/util/concurrent/atomic/AtomicLong
    //   98: dup
    //   99: lconst_0
    //   100: invokespecial 529	java/util/concurrent/atomic/AtomicLong:<init>	(J)V
    //   103: astore 21
    //   105: new 6	com/whatsapp/gdrive/at$1
    //   108: dup
    //   109: aload_0
    //   110: aload_1
    //   111: ldc_w 531
    //   114: lload 11
    //   116: lload 6
    //   118: aload 5
    //   120: aload 4
    //   122: aload 24
    //   124: aload 21
    //   126: aload_3
    //   127: invokespecial 534	com/whatsapp/gdrive/at$1:<init>	(Lcom/whatsapp/gdrive/at;Ljava/io/File;Ljava/lang/String;JJLjava/io/FileInputStream;Lcom/whatsapp/gdrive/ev;Lorg/apache/http/client/methods/HttpPut;Ljava/util/concurrent/atomic/AtomicLong;Lcom/whatsapp/gdrive/at$b;)V
    //   130: astore 22
    //   132: aload 4
    //   134: invokevirtual 372	com/whatsapp/gdrive/ev:a	()Z
    //   137: ifne +15 -> 152
    //   140: aconst_null
    //   141: areturn
    //   142: astore_1
    //   143: ldc_w 536
    //   146: aload_1
    //   147: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   150: aconst_null
    //   151: areturn
    //   152: aload 24
    //   154: ldc_w 333
    //   157: new 84	java/lang/StringBuilder
    //   160: dup
    //   161: ldc_w 335
    //   164: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: aload_0
    //   168: getfield 337	com/whatsapp/gdrive/at:o	Ljava/lang/String;
    //   171: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokevirtual 341	org/apache/http/client/methods/HttpPut:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload 24
    //   182: ldc_w 343
    //   185: new 84	java/lang/StringBuilder
    //   188: dup
    //   189: ldc_w 538
    //   192: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   195: lload 6
    //   197: invokevirtual 473	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   200: ldc_w 540
    //   203: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: lload 11
    //   208: invokevirtual 473	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   211: ldc_w 542
    //   214: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: lload 9
    //   219: invokevirtual 473	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   222: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokevirtual 341	org/apache/http/client/methods/HttpPut:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload 24
    //   230: ldc_w 544
    //   233: ldc_w 531
    //   236: invokevirtual 341	org/apache/http/client/methods/HttpPut:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload 24
    //   241: aload 22
    //   243: invokevirtual 548	org/apache/http/client/methods/HttpPut:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   246: new 84	java/lang/StringBuilder
    //   249: dup
    //   250: ldc_w 550
    //   253: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   256: lload 6
    //   258: invokevirtual 473	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   261: ldc_w 552
    //   264: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: lload 11
    //   269: invokevirtual 473	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   272: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   278: aload_0
    //   279: invokevirtual 553	com/whatsapp/gdrive/at:a	()Z
    //   282: ifeq +11 -> 293
    //   285: ldc_w 555
    //   288: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   291: aconst_null
    //   292: areturn
    //   293: new 8	com/whatsapp/gdrive/at$2
    //   296: dup
    //   297: aload_0
    //   298: aload 24
    //   300: invokespecial 558	com/whatsapp/gdrive/at$2:<init>	(Lcom/whatsapp/gdrive/at;Lorg/apache/http/client/methods/HttpPut;)V
    //   303: astore 23
    //   305: aload 24
    //   307: invokevirtual 561	org/apache/http/client/methods/HttpPut:isAborted	()Z
    //   310: ifeq +11 -> 321
    //   313: ldc_w 563
    //   316: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   319: aconst_null
    //   320: areturn
    //   321: aconst_null
    //   322: astore 18
    //   324: aconst_null
    //   325: astore 19
    //   327: aconst_null
    //   328: astore 20
    //   330: aconst_null
    //   331: astore 5
    //   333: aload 5
    //   335: astore 15
    //   337: aload 18
    //   339: astore 16
    //   341: aload 19
    //   343: astore 4
    //   345: aload 20
    //   347: astore 17
    //   349: aload_0
    //   350: aload 24
    //   352: invokespecial 375	com/whatsapp/gdrive/at:a	(Lorg/apache/http/client/methods/HttpRequestBase;)Lorg/apache/http/HttpResponse;
    //   355: astore 25
    //   357: aload 5
    //   359: astore 15
    //   361: aload 18
    //   363: astore 16
    //   365: aload 19
    //   367: astore 4
    //   369: aload 20
    //   371: astore 17
    //   373: aload 24
    //   375: invokestatic 386	com/whatsapp/gdrive/ch:a	(Lorg/apache/http/client/methods/HttpRequestBase;)V
    //   378: aload 5
    //   380: astore 15
    //   382: aload 18
    //   384: astore 16
    //   386: aload 19
    //   388: astore 4
    //   390: aload 20
    //   392: astore 17
    //   394: aload 25
    //   396: invokestatic 492	com/whatsapp/gdrive/ch:a	(Lorg/apache/http/HttpResponse;)V
    //   399: aload 5
    //   401: astore 15
    //   403: aload 18
    //   405: astore 16
    //   407: aload 19
    //   409: astore 4
    //   411: aload 20
    //   413: astore 17
    //   415: aload 25
    //   417: invokeinterface 390 1 0
    //   422: invokeinterface 396 1 0
    //   427: istore 8
    //   429: aload 5
    //   431: astore 15
    //   433: aload 18
    //   435: astore 16
    //   437: aload 19
    //   439: astore 4
    //   441: aload 20
    //   443: astore 17
    //   445: aload 25
    //   447: invokeinterface 381 1 0
    //   452: astore 5
    //   454: iload 8
    //   456: sipush 200
    //   459: if_icmpeq +11 -> 470
    //   462: iload 8
    //   464: sipush 201
    //   467: if_icmpne +797 -> 1264
    //   470: aload 5
    //   472: ifnonnull +65 -> 537
    //   475: aload 5
    //   477: astore 15
    //   479: aload 5
    //   481: astore 16
    //   483: aload 5
    //   485: astore 4
    //   487: aload 5
    //   489: astore 17
    //   491: ldc_w 565
    //   494: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   497: aload_3
    //   498: ldc2_w 566
    //   501: aload 21
    //   503: invokevirtual 570	java/util/concurrent/atomic/AtomicLong:get	()J
    //   506: lload 6
    //   508: ladd
    //   509: lmul
    //   510: invokeinterface 572 3 0
    //   515: aload 22
    //   517: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   520: pop
    //   521: aload 5
    //   523: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   526: pop
    //   527: invokestatic 577	b/a/a/c:a	()Lb/a/a/c;
    //   530: aload 23
    //   532: invokevirtual 580	b/a/a/c:a	(Ljava/lang/Object;)V
    //   535: aconst_null
    //   536: areturn
    //   537: aload 5
    //   539: astore 15
    //   541: aload 5
    //   543: astore 16
    //   545: aload 5
    //   547: astore 4
    //   549: aload 5
    //   551: astore 17
    //   553: aload 5
    //   555: invokestatic 401	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   558: astore 18
    //   560: aload 5
    //   562: astore 15
    //   564: aload 5
    //   566: astore 16
    //   568: aload 5
    //   570: astore 4
    //   572: aload 5
    //   574: astore 17
    //   576: new 582	com/whatsapp/gdrive/bb$a
    //   579: dup
    //   580: invokespecial 583	com/whatsapp/gdrive/bb$a:<init>	()V
    //   583: astore 19
    //   585: aload 5
    //   587: astore 15
    //   589: aload 5
    //   591: astore 16
    //   593: aload 5
    //   595: astore 4
    //   597: aload 5
    //   599: astore 17
    //   601: aload 19
    //   603: lload 9
    //   605: putfield 585	com/whatsapp/gdrive/bb$a:b	J
    //   608: aload 5
    //   610: astore 15
    //   612: aload 5
    //   614: astore 16
    //   616: aload 5
    //   618: astore 4
    //   620: aload 5
    //   622: astore 17
    //   624: aload 19
    //   626: aload_1
    //   627: invokevirtual 588	java/io/File:isDirectory	()Z
    //   630: putfield 590	com/whatsapp/gdrive/bb$a:c	Z
    //   633: aload 5
    //   635: astore 15
    //   637: aload 5
    //   639: astore 16
    //   641: aload 5
    //   643: astore 4
    //   645: aload 5
    //   647: astore 17
    //   649: aload 19
    //   651: aload_2
    //   652: putfield 591	com/whatsapp/gdrive/bb$a:e	Ljava/lang/String;
    //   655: aload 5
    //   657: astore 15
    //   659: aload 5
    //   661: astore 16
    //   663: aload 5
    //   665: astore 4
    //   667: aload 5
    //   669: astore 17
    //   671: aload 19
    //   673: new 593	org/json/JSONObject
    //   676: dup
    //   677: aload 18
    //   679: invokespecial 594	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   682: invokestatic 597	com/whatsapp/gdrive/bb:a	(Lcom/whatsapp/gdrive/bb$a;Lorg/json/JSONObject;)Lcom/whatsapp/gdrive/bb$a;
    //   685: invokevirtual 600	com/whatsapp/gdrive/bb$a:a	()Lcom/whatsapp/gdrive/bb;
    //   688: astore 19
    //   690: aload 5
    //   692: astore 15
    //   694: aload 5
    //   696: astore 16
    //   698: aload 5
    //   700: astore 4
    //   702: aload 5
    //   704: astore 17
    //   706: aload 19
    //   708: getfield 602	com/whatsapp/gdrive/bb:b	Z
    //   711: aload_1
    //   712: invokevirtual 588	java/io/File:isDirectory	()Z
    //   715: if_icmpeq +158 -> 873
    //   718: aload 5
    //   720: astore 15
    //   722: aload 5
    //   724: astore 16
    //   726: aload 5
    //   728: astore 4
    //   730: aload 5
    //   732: astore 17
    //   734: new 84	java/lang/StringBuilder
    //   737: dup
    //   738: ldc_w 604
    //   741: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   744: aload_1
    //   745: invokevirtual 588	java/io/File:isDirectory	()Z
    //   748: invokevirtual 607	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   751: ldc_w 433
    //   754: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: aload 19
    //   759: getfield 602	com/whatsapp/gdrive/bb:b	Z
    //   762: invokevirtual 607	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   765: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   768: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   771: aload 5
    //   773: astore 15
    //   775: aload 5
    //   777: astore 16
    //   779: aload 5
    //   781: astore 4
    //   783: aload 5
    //   785: astore 17
    //   787: aload_0
    //   788: getfield 146	com/whatsapp/gdrive/at:s	Lcom/whatsapp/util/a/c;
    //   791: ldc_w 609
    //   794: iconst_0
    //   795: aconst_null
    //   796: iconst_2
    //   797: invokevirtual 614	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   800: aload_3
    //   801: ldc2_w 566
    //   804: aload 21
    //   806: invokevirtual 570	java/util/concurrent/atomic/AtomicLong:get	()J
    //   809: lload 6
    //   811: ladd
    //   812: lmul
    //   813: invokeinterface 572 3 0
    //   818: aload 22
    //   820: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   823: pop
    //   824: aload 5
    //   826: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   829: pop
    //   830: invokestatic 577	b/a/a/c:a	()Lb/a/a/c;
    //   833: aload 23
    //   835: invokevirtual 580	b/a/a/c:a	(Ljava/lang/Object;)V
    //   838: new 84	java/lang/StringBuilder
    //   841: dup
    //   842: ldc_w 616
    //   845: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   848: aload_2
    //   849: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: ldc_w 618
    //   855: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   861: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   864: aload_0
    //   865: aload_2
    //   866: invokespecial 404	com/whatsapp/gdrive/at:d	(Ljava/lang/String;)Z
    //   869: pop
    //   870: aload 19
    //   872: areturn
    //   873: aload 5
    //   875: astore 15
    //   877: aload 5
    //   879: astore 16
    //   881: aload 5
    //   883: astore 4
    //   885: aload 5
    //   887: astore 17
    //   889: aload_2
    //   890: aload 19
    //   892: getfield 620	com/whatsapp/gdrive/bb:d	Ljava/lang/String;
    //   895: invokevirtual 624	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   898: ifne +169 -> 1067
    //   901: aload 5
    //   903: astore 15
    //   905: aload 5
    //   907: astore 16
    //   909: aload 5
    //   911: astore 4
    //   913: aload 5
    //   915: astore 17
    //   917: new 84	java/lang/StringBuilder
    //   920: dup
    //   921: ldc_w 626
    //   924: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   927: aload_2
    //   928: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: ldc_w 628
    //   934: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   937: aload 19
    //   939: getfield 620	com/whatsapp/gdrive/bb:d	Ljava/lang/String;
    //   942: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: ldc_w 630
    //   948: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   954: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   957: aload 5
    //   959: astore 15
    //   961: aload 5
    //   963: astore 16
    //   965: aload 5
    //   967: astore 4
    //   969: aload 5
    //   971: astore 17
    //   973: aload_0
    //   974: getfield 146	com/whatsapp/gdrive/at:s	Lcom/whatsapp/util/a/c;
    //   977: ldc_w 632
    //   980: iconst_0
    //   981: aconst_null
    //   982: iconst_2
    //   983: invokevirtual 614	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   986: goto -186 -> 800
    //   989: astore_1
    //   990: aload 5
    //   992: astore 15
    //   994: aload 5
    //   996: astore 16
    //   998: aload 5
    //   1000: astore 4
    //   1002: aload 5
    //   1004: astore 17
    //   1006: new 84	java/lang/StringBuilder
    //   1009: dup
    //   1010: ldc_w 634
    //   1013: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1016: aload 18
    //   1018: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1024: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1027: aload_3
    //   1028: ldc2_w 566
    //   1031: aload 21
    //   1033: invokevirtual 570	java/util/concurrent/atomic/AtomicLong:get	()J
    //   1036: lload 6
    //   1038: ladd
    //   1039: lmul
    //   1040: invokeinterface 572 3 0
    //   1045: aload 22
    //   1047: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   1050: pop
    //   1051: aload 5
    //   1053: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   1056: pop
    //   1057: invokestatic 577	b/a/a/c:a	()Lb/a/a/c;
    //   1060: aload 23
    //   1062: invokevirtual 580	b/a/a/c:a	(Ljava/lang/Object;)V
    //   1065: aconst_null
    //   1066: areturn
    //   1067: aload 5
    //   1069: astore 15
    //   1071: aload 5
    //   1073: astore 16
    //   1075: aload 5
    //   1077: astore 4
    //   1079: aload 5
    //   1081: astore 17
    //   1083: aload 19
    //   1085: getfield 636	com/whatsapp/gdrive/bb:a	J
    //   1088: lload 9
    //   1090: lcmp
    //   1091: ifeq -291 -> 800
    //   1094: aload 5
    //   1096: astore 15
    //   1098: aload 5
    //   1100: astore 16
    //   1102: aload 5
    //   1104: astore 4
    //   1106: aload 5
    //   1108: astore 17
    //   1110: aload_1
    //   1111: invokevirtual 588	java/io/File:isDirectory	()Z
    //   1114: ifne -314 -> 800
    //   1117: aload 5
    //   1119: astore 15
    //   1121: aload 5
    //   1123: astore 16
    //   1125: aload 5
    //   1127: astore 4
    //   1129: aload 5
    //   1131: astore 17
    //   1133: new 84	java/lang/StringBuilder
    //   1136: dup
    //   1137: ldc_w 604
    //   1140: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1143: lload 9
    //   1145: invokevirtual 473	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1148: ldc_w 433
    //   1151: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: aload 19
    //   1156: getfield 636	com/whatsapp/gdrive/bb:a	J
    //   1159: invokevirtual 473	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1162: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1165: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1168: aload 5
    //   1170: astore 15
    //   1172: aload 5
    //   1174: astore 16
    //   1176: aload 5
    //   1178: astore 4
    //   1180: aload 5
    //   1182: astore 17
    //   1184: aload_0
    //   1185: getfield 146	com/whatsapp/gdrive/at:s	Lcom/whatsapp/util/a/c;
    //   1188: ldc_w 638
    //   1191: iconst_0
    //   1192: aconst_null
    //   1193: iconst_2
    //   1194: invokevirtual 614	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   1197: goto -397 -> 800
    //   1200: astore_1
    //   1201: aload 15
    //   1203: astore 4
    //   1205: aload 24
    //   1207: invokevirtual 561	org/apache/http/client/methods/HttpPut:isAborted	()Z
    //   1210: ifeq +537 -> 1747
    //   1213: aload 15
    //   1215: astore 4
    //   1217: ldc_w 640
    //   1220: aload_1
    //   1221: invokestatic 642	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1224: aload_3
    //   1225: ldc2_w 566
    //   1228: aload 21
    //   1230: invokevirtual 570	java/util/concurrent/atomic/AtomicLong:get	()J
    //   1233: lload 6
    //   1235: ladd
    //   1236: lmul
    //   1237: invokeinterface 572 3 0
    //   1242: aload 22
    //   1244: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   1247: pop
    //   1248: aload 15
    //   1250: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   1253: pop
    //   1254: invokestatic 577	b/a/a/c:a	()Lb/a/a/c;
    //   1257: aload 23
    //   1259: invokevirtual 580	b/a/a/c:a	(Ljava/lang/Object;)V
    //   1262: aconst_null
    //   1263: areturn
    //   1264: iload 8
    //   1266: sipush 401
    //   1269: if_icmpne +64 -> 1333
    //   1272: aload 5
    //   1274: astore 15
    //   1276: aload 5
    //   1278: astore 16
    //   1280: aload 5
    //   1282: astore 4
    //   1284: aload 5
    //   1286: astore 17
    //   1288: aload_0
    //   1289: invokevirtual 423	com/whatsapp/gdrive/at:b	()Z
    //   1292: pop
    //   1293: aload_3
    //   1294: ldc2_w 566
    //   1297: aload 21
    //   1299: invokevirtual 570	java/util/concurrent/atomic/AtomicLong:get	()J
    //   1302: lload 6
    //   1304: ladd
    //   1305: lmul
    //   1306: invokeinterface 572 3 0
    //   1311: aload 22
    //   1313: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   1316: pop
    //   1317: aload 5
    //   1319: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   1322: pop
    //   1323: invokestatic 577	b/a/a/c:a	()Lb/a/a/c;
    //   1326: aload 23
    //   1328: invokevirtual 580	b/a/a/c:a	(Ljava/lang/Object;)V
    //   1331: aconst_null
    //   1332: areturn
    //   1333: iload 8
    //   1335: sipush 403
    //   1338: if_icmpne +264 -> 1602
    //   1341: aload 5
    //   1343: astore 15
    //   1345: aload 5
    //   1347: astore 16
    //   1349: aload 5
    //   1351: astore 4
    //   1353: aload 5
    //   1355: astore 17
    //   1357: aload_0
    //   1358: aload_2
    //   1359: invokespecial 404	com/whatsapp/gdrive/at:d	(Ljava/lang/String;)Z
    //   1362: pop
    //   1363: aload 5
    //   1365: ifnull +156 -> 1521
    //   1368: aload 5
    //   1370: astore 15
    //   1372: aload 5
    //   1374: astore 16
    //   1376: aload 5
    //   1378: astore 4
    //   1380: aload 5
    //   1382: astore 17
    //   1384: aload 5
    //   1386: invokestatic 401	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   1389: astore_1
    //   1390: aload 5
    //   1392: astore 15
    //   1394: aload 5
    //   1396: astore 16
    //   1398: aload 5
    //   1400: astore 4
    //   1402: aload 5
    //   1404: astore 17
    //   1406: aload_1
    //   1407: invokestatic 406	com/whatsapp/gdrive/at:e	(Ljava/lang/String;)Z
    //   1410: ifeq +116 -> 1526
    //   1413: aload 5
    //   1415: astore 15
    //   1417: aload 5
    //   1419: astore 16
    //   1421: aload 5
    //   1423: astore 4
    //   1425: aload 5
    //   1427: astore 17
    //   1429: new 84	java/lang/StringBuilder
    //   1432: dup
    //   1433: ldc_w 644
    //   1436: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1439: aload_1
    //   1440: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1443: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1446: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1449: aload 5
    //   1451: astore 15
    //   1453: aload 5
    //   1455: astore 16
    //   1457: aload 5
    //   1459: astore 4
    //   1461: aload 5
    //   1463: astore 17
    //   1465: new 408	com/whatsapp/gdrive/bf
    //   1468: dup
    //   1469: invokespecial 409	com/whatsapp/gdrive/bf:<init>	()V
    //   1472: athrow
    //   1473: astore_1
    //   1474: aload 16
    //   1476: astore 4
    //   1478: aload_1
    //   1479: athrow
    //   1480: astore_1
    //   1481: aload_3
    //   1482: ldc2_w 566
    //   1485: aload 21
    //   1487: invokevirtual 570	java/util/concurrent/atomic/AtomicLong:get	()J
    //   1490: lload 6
    //   1492: ladd
    //   1493: lmul
    //   1494: invokeinterface 572 3 0
    //   1499: aload 22
    //   1501: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   1504: pop
    //   1505: aload 4
    //   1507: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   1510: pop
    //   1511: invokestatic 577	b/a/a/c:a	()Lb/a/a/c;
    //   1514: aload 23
    //   1516: invokevirtual 580	b/a/a/c:a	(Ljava/lang/Object;)V
    //   1519: aload_1
    //   1520: athrow
    //   1521: aconst_null
    //   1522: astore_1
    //   1523: goto -133 -> 1390
    //   1526: aload 5
    //   1528: astore 15
    //   1530: aload 5
    //   1532: astore 16
    //   1534: aload 5
    //   1536: astore 4
    //   1538: aload 5
    //   1540: astore 17
    //   1542: new 84	java/lang/StringBuilder
    //   1545: dup
    //   1546: ldc_w 646
    //   1549: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1552: aload_1
    //   1553: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1556: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1559: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1562: aload_3
    //   1563: ldc2_w 566
    //   1566: aload 21
    //   1568: invokevirtual 570	java/util/concurrent/atomic/AtomicLong:get	()J
    //   1571: lload 6
    //   1573: ladd
    //   1574: lmul
    //   1575: invokeinterface 572 3 0
    //   1580: aload 22
    //   1582: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   1585: pop
    //   1586: aload 5
    //   1588: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   1591: pop
    //   1592: invokestatic 577	b/a/a/c:a	()Lb/a/a/c;
    //   1595: aload 23
    //   1597: invokevirtual 580	b/a/a/c:a	(Ljava/lang/Object;)V
    //   1600: aconst_null
    //   1601: areturn
    //   1602: aload 5
    //   1604: ifnull +138 -> 1742
    //   1607: aload 5
    //   1609: astore 15
    //   1611: aload 5
    //   1613: astore 16
    //   1615: aload 5
    //   1617: astore 4
    //   1619: aload 5
    //   1621: astore 17
    //   1623: aload 5
    //   1625: invokestatic 401	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   1628: astore_1
    //   1629: aload 5
    //   1631: astore 15
    //   1633: aload 5
    //   1635: astore 16
    //   1637: aload 5
    //   1639: astore 4
    //   1641: aload 5
    //   1643: astore 17
    //   1645: new 84	java/lang/StringBuilder
    //   1648: dup
    //   1649: ldc_w 646
    //   1652: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1655: aload_1
    //   1656: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1659: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1662: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1665: aload 5
    //   1667: astore 15
    //   1669: aload 5
    //   1671: astore 16
    //   1673: aload 5
    //   1675: astore 4
    //   1677: aload 5
    //   1679: astore 17
    //   1681: new 648	com/whatsapp/gdrive/bg
    //   1684: dup
    //   1685: aload_1
    //   1686: invokespecial 649	com/whatsapp/gdrive/bg:<init>	(Ljava/lang/String;)V
    //   1689: athrow
    //   1690: astore_1
    //   1691: aload 17
    //   1693: astore 4
    //   1695: ldc_w 411
    //   1698: aload_1
    //   1699: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1702: aload_3
    //   1703: ldc2_w 566
    //   1706: aload 21
    //   1708: invokevirtual 570	java/util/concurrent/atomic/AtomicLong:get	()J
    //   1711: lload 6
    //   1713: ladd
    //   1714: lmul
    //   1715: invokeinterface 572 3 0
    //   1720: aload 22
    //   1722: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   1725: pop
    //   1726: aload 17
    //   1728: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   1731: pop
    //   1732: invokestatic 577	b/a/a/c:a	()Lb/a/a/c;
    //   1735: aload 23
    //   1737: invokevirtual 580	b/a/a/c:a	(Ljava/lang/Object;)V
    //   1740: aconst_null
    //   1741: areturn
    //   1742: aconst_null
    //   1743: astore_1
    //   1744: goto -115 -> 1629
    //   1747: aload 15
    //   1749: astore 4
    //   1751: aload_1
    //   1752: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1753	0	this	at
    //   0	1753	1	paramFile	File
    //   0	1753	2	paramString1	String
    //   0	1753	3	paramb	b
    //   0	1753	4	paramev	ev
    //   0	1753	5	paramString2	String
    //   0	1753	6	paramLong	long
    //   427	912	8	i1	int
    //   15	1129	9	l1	long
    //   21	247	11	l2	long
    //   40	45	13	l3	long
    //   335	1413	15	str1	String
    //   339	1333	16	str2	String
    //   347	1380	17	localObject1	Object
    //   322	695	18	str3	String
    //   325	830	19	localObject2	Object
    //   328	114	20	localObject3	Object
    //   103	1604	21	localAtomicLong	AtomicLong
    //   130	1591	22	local1	1
    //   303	1433	23	local2	2
    //   9	1197	24	localHttpPut	HttpPut
    //   355	91	25	localHttpResponse	HttpResponse
    // Exception table:
    //   from	to	target	type
    //   33	42	142	java/io/IOException
    //   50	95	142	java/io/IOException
    //   576	585	989	org/json/JSONException
    //   601	608	989	org/json/JSONException
    //   624	633	989	org/json/JSONException
    //   649	655	989	org/json/JSONException
    //   671	690	989	org/json/JSONException
    //   706	718	989	org/json/JSONException
    //   734	771	989	org/json/JSONException
    //   787	800	989	org/json/JSONException
    //   889	901	989	org/json/JSONException
    //   917	957	989	org/json/JSONException
    //   973	986	989	org/json/JSONException
    //   1083	1094	989	org/json/JSONException
    //   1110	1117	989	org/json/JSONException
    //   1133	1168	989	org/json/JSONException
    //   1184	1197	989	org/json/JSONException
    //   349	357	1200	java/lang/IllegalStateException
    //   373	378	1200	java/lang/IllegalStateException
    //   394	399	1200	java/lang/IllegalStateException
    //   415	429	1200	java/lang/IllegalStateException
    //   445	454	1200	java/lang/IllegalStateException
    //   491	497	1200	java/lang/IllegalStateException
    //   553	560	1200	java/lang/IllegalStateException
    //   576	585	1200	java/lang/IllegalStateException
    //   601	608	1200	java/lang/IllegalStateException
    //   624	633	1200	java/lang/IllegalStateException
    //   649	655	1200	java/lang/IllegalStateException
    //   671	690	1200	java/lang/IllegalStateException
    //   706	718	1200	java/lang/IllegalStateException
    //   734	771	1200	java/lang/IllegalStateException
    //   787	800	1200	java/lang/IllegalStateException
    //   889	901	1200	java/lang/IllegalStateException
    //   917	957	1200	java/lang/IllegalStateException
    //   973	986	1200	java/lang/IllegalStateException
    //   1006	1027	1200	java/lang/IllegalStateException
    //   1083	1094	1200	java/lang/IllegalStateException
    //   1110	1117	1200	java/lang/IllegalStateException
    //   1133	1168	1200	java/lang/IllegalStateException
    //   1184	1197	1200	java/lang/IllegalStateException
    //   1288	1293	1200	java/lang/IllegalStateException
    //   1357	1363	1200	java/lang/IllegalStateException
    //   1384	1390	1200	java/lang/IllegalStateException
    //   1406	1413	1200	java/lang/IllegalStateException
    //   1429	1449	1200	java/lang/IllegalStateException
    //   1465	1473	1200	java/lang/IllegalStateException
    //   1542	1562	1200	java/lang/IllegalStateException
    //   1623	1629	1200	java/lang/IllegalStateException
    //   1645	1665	1200	java/lang/IllegalStateException
    //   1681	1690	1200	java/lang/IllegalStateException
    //   349	357	1473	java/io/FileNotFoundException
    //   373	378	1473	java/io/FileNotFoundException
    //   394	399	1473	java/io/FileNotFoundException
    //   415	429	1473	java/io/FileNotFoundException
    //   445	454	1473	java/io/FileNotFoundException
    //   491	497	1473	java/io/FileNotFoundException
    //   553	560	1473	java/io/FileNotFoundException
    //   576	585	1473	java/io/FileNotFoundException
    //   601	608	1473	java/io/FileNotFoundException
    //   624	633	1473	java/io/FileNotFoundException
    //   649	655	1473	java/io/FileNotFoundException
    //   671	690	1473	java/io/FileNotFoundException
    //   706	718	1473	java/io/FileNotFoundException
    //   734	771	1473	java/io/FileNotFoundException
    //   787	800	1473	java/io/FileNotFoundException
    //   889	901	1473	java/io/FileNotFoundException
    //   917	957	1473	java/io/FileNotFoundException
    //   973	986	1473	java/io/FileNotFoundException
    //   1006	1027	1473	java/io/FileNotFoundException
    //   1083	1094	1473	java/io/FileNotFoundException
    //   1110	1117	1473	java/io/FileNotFoundException
    //   1133	1168	1473	java/io/FileNotFoundException
    //   1184	1197	1473	java/io/FileNotFoundException
    //   1288	1293	1473	java/io/FileNotFoundException
    //   1357	1363	1473	java/io/FileNotFoundException
    //   1384	1390	1473	java/io/FileNotFoundException
    //   1406	1413	1473	java/io/FileNotFoundException
    //   1429	1449	1473	java/io/FileNotFoundException
    //   1465	1473	1473	java/io/FileNotFoundException
    //   1542	1562	1473	java/io/FileNotFoundException
    //   1623	1629	1473	java/io/FileNotFoundException
    //   1645	1665	1473	java/io/FileNotFoundException
    //   1681	1690	1473	java/io/FileNotFoundException
    //   349	357	1480	finally
    //   373	378	1480	finally
    //   394	399	1480	finally
    //   415	429	1480	finally
    //   445	454	1480	finally
    //   491	497	1480	finally
    //   553	560	1480	finally
    //   576	585	1480	finally
    //   601	608	1480	finally
    //   624	633	1480	finally
    //   649	655	1480	finally
    //   671	690	1480	finally
    //   706	718	1480	finally
    //   734	771	1480	finally
    //   787	800	1480	finally
    //   889	901	1480	finally
    //   917	957	1480	finally
    //   973	986	1480	finally
    //   1006	1027	1480	finally
    //   1083	1094	1480	finally
    //   1110	1117	1480	finally
    //   1133	1168	1480	finally
    //   1184	1197	1480	finally
    //   1205	1213	1480	finally
    //   1217	1224	1480	finally
    //   1288	1293	1480	finally
    //   1357	1363	1480	finally
    //   1384	1390	1480	finally
    //   1406	1413	1480	finally
    //   1429	1449	1480	finally
    //   1465	1473	1480	finally
    //   1478	1480	1480	finally
    //   1542	1562	1480	finally
    //   1623	1629	1480	finally
    //   1645	1665	1480	finally
    //   1681	1690	1480	finally
    //   1695	1702	1480	finally
    //   1751	1753	1480	finally
    //   349	357	1690	java/io/IOException
    //   373	378	1690	java/io/IOException
    //   394	399	1690	java/io/IOException
    //   415	429	1690	java/io/IOException
    //   445	454	1690	java/io/IOException
    //   491	497	1690	java/io/IOException
    //   553	560	1690	java/io/IOException
    //   576	585	1690	java/io/IOException
    //   601	608	1690	java/io/IOException
    //   624	633	1690	java/io/IOException
    //   649	655	1690	java/io/IOException
    //   671	690	1690	java/io/IOException
    //   706	718	1690	java/io/IOException
    //   734	771	1690	java/io/IOException
    //   787	800	1690	java/io/IOException
    //   889	901	1690	java/io/IOException
    //   917	957	1690	java/io/IOException
    //   973	986	1690	java/io/IOException
    //   1006	1027	1690	java/io/IOException
    //   1083	1094	1690	java/io/IOException
    //   1110	1117	1690	java/io/IOException
    //   1133	1168	1690	java/io/IOException
    //   1184	1197	1690	java/io/IOException
    //   1288	1293	1690	java/io/IOException
    //   1357	1363	1690	java/io/IOException
    //   1384	1390	1690	java/io/IOException
    //   1406	1413	1690	java/io/IOException
    //   1429	1449	1690	java/io/IOException
    //   1465	1473	1690	java/io/IOException
    //   1542	1562	1690	java/io/IOException
    //   1623	1629	1690	java/io/IOException
    //   1645	1665	1690	java/io/IOException
    //   1681	1690	1690	java/io/IOException
  }
  
  /* Error */
  private String a(String paramString1, File paramFile, String paramString2, ev paramev, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 154	com/whatsapp/gdrive/at:q	Lcom/whatsapp/gdrive/at$d;
    //   4: getfield 654	com/whatsapp/gdrive/at$d:g	Ljava/lang/String;
    //   7: astore 9
    //   9: iload 6
    //   11: ifeq +227 -> 238
    //   14: iconst_1
    //   15: invokestatic 657	com/whatsapp/gdrive/bb:a	(Z)Ljava/lang/String;
    //   18: astore 8
    //   20: new 659	org/apache/http/client/methods/HttpPost
    //   23: dup
    //   24: ldc_w 661
    //   27: iconst_4
    //   28: anewarray 363	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: ldc_w 663
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: aload 9
    //   41: aastore
    //   42: dup
    //   43: iconst_2
    //   44: ldc_w 665
    //   47: aastore
    //   48: dup
    //   49: iconst_3
    //   50: aload 8
    //   52: aastore
    //   53: invokestatic 668	com/whatsapp/gdrive/ch:a	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   56: invokespecial 669	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   59: astore 8
    //   61: aload 8
    //   63: ldc_w 333
    //   66: new 84	java/lang/StringBuilder
    //   69: dup
    //   70: ldc_w 335
    //   73: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   76: aload_0
    //   77: getfield 337	com/whatsapp/gdrive/at:o	Ljava/lang/String;
    //   80: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokevirtual 670	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload 8
    //   91: ldc_w 544
    //   94: ldc_w 672
    //   97: invokevirtual 670	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload 8
    //   102: ldc_w 674
    //   105: ldc_w 531
    //   108: invokevirtual 670	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload 8
    //   113: ldc_w 676
    //   116: aload_2
    //   117: invokevirtual 357	java/io/File:length	()J
    //   120: invokestatic 679	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   123: invokevirtual 670	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload 8
    //   128: new 681	org/apache/http/entity/StringEntity
    //   131: dup
    //   132: new 593	org/json/JSONObject
    //   135: dup
    //   136: invokespecial 682	org/json/JSONObject:<init>	()V
    //   139: ldc_w 684
    //   142: aload_3
    //   143: invokevirtual 688	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   146: ldc_w 690
    //   149: new 692	org/json/JSONArray
    //   152: dup
    //   153: invokespecial 693	org/json/JSONArray:<init>	()V
    //   156: new 593	org/json/JSONObject
    //   159: dup
    //   160: invokespecial 682	org/json/JSONObject:<init>	()V
    //   163: ldc_w 695
    //   166: ldc_w 697
    //   169: invokevirtual 688	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   172: ldc_w 699
    //   175: aload_1
    //   176: invokevirtual 688	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   179: invokevirtual 702	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   182: invokevirtual 688	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   185: ldc_w 704
    //   188: aload 5
    //   190: invokevirtual 707	org/json/JSONObject:putOpt	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   193: invokevirtual 708	org/json/JSONObject:toString	()Ljava/lang/String;
    //   196: ldc_w 710
    //   199: invokespecial 712	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: invokevirtual 713	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   205: new 84	java/lang/StringBuilder
    //   208: dup
    //   209: ldc_w 715
    //   212: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   215: aload_2
    //   216: invokevirtual 520	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   219: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   228: aload 4
    //   230: invokevirtual 372	com/whatsapp/gdrive/ev:a	()Z
    //   233: ifne +33 -> 266
    //   236: aconst_null
    //   237: areturn
    //   238: invokestatic 716	com/whatsapp/gdrive/bb:a	()Ljava/lang/String;
    //   241: astore 8
    //   243: goto -223 -> 20
    //   246: astore_1
    //   247: ldc_w 411
    //   250: aload_1
    //   251: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   254: aconst_null
    //   255: areturn
    //   256: astore_1
    //   257: ldc_w 411
    //   260: aload_1
    //   261: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   264: aconst_null
    //   265: areturn
    //   266: aload_0
    //   267: aload 8
    //   269: invokespecial 375	com/whatsapp/gdrive/at:a	(Lorg/apache/http/client/methods/HttpRequestBase;)Lorg/apache/http/HttpResponse;
    //   272: astore 5
    //   274: aload 5
    //   276: invokeinterface 381 1 0
    //   281: astore_2
    //   282: aload_2
    //   283: ifnull +115 -> 398
    //   286: aload_2
    //   287: astore_1
    //   288: aload_2
    //   289: invokestatic 401	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   292: astore 4
    //   294: aload_2
    //   295: astore_1
    //   296: aload 8
    //   298: invokestatic 386	com/whatsapp/gdrive/ch:a	(Lorg/apache/http/client/methods/HttpRequestBase;)V
    //   301: aload_2
    //   302: astore_1
    //   303: aload 5
    //   305: invokestatic 492	com/whatsapp/gdrive/ch:a	(Lorg/apache/http/HttpResponse;)V
    //   308: aload_2
    //   309: astore_1
    //   310: aload 5
    //   312: invokeinterface 390 1 0
    //   317: invokeinterface 396 1 0
    //   322: istore 7
    //   324: aload_2
    //   325: astore_1
    //   326: new 84	java/lang/StringBuilder
    //   329: dup
    //   330: ldc_w 718
    //   333: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   336: iload 7
    //   338: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   341: ldc_w 720
    //   344: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: aload 5
    //   349: invokeinterface 390 1 0
    //   354: invokeinterface 723 1 0
    //   359: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   368: iload 7
    //   370: sipush 200
    //   373: if_icmpeq +171 -> 544
    //   376: iload 7
    //   378: sipush 401
    //   381: if_icmpne +23 -> 404
    //   384: aload_2
    //   385: astore_1
    //   386: aload_0
    //   387: invokevirtual 423	com/whatsapp/gdrive/at:b	()Z
    //   390: pop
    //   391: aload_2
    //   392: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   395: pop
    //   396: aconst_null
    //   397: areturn
    //   398: aconst_null
    //   399: astore 4
    //   401: goto -107 -> 294
    //   404: iload 7
    //   406: sipush 403
    //   409: if_icmpne +70 -> 479
    //   412: aload_2
    //   413: astore_1
    //   414: aload 4
    //   416: invokestatic 406	com/whatsapp/gdrive/at:e	(Ljava/lang/String;)Z
    //   419: ifeq +30 -> 449
    //   422: aload_2
    //   423: astore_1
    //   424: new 408	com/whatsapp/gdrive/bf
    //   427: dup
    //   428: invokespecial 409	com/whatsapp/gdrive/bf:<init>	()V
    //   431: athrow
    //   432: astore_3
    //   433: aload_2
    //   434: astore_1
    //   435: ldc_w 411
    //   438: aload_3
    //   439: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   442: aload_2
    //   443: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   446: pop
    //   447: aconst_null
    //   448: areturn
    //   449: aload_2
    //   450: astore_1
    //   451: new 84	java/lang/StringBuilder
    //   454: dup
    //   455: ldc_w 646
    //   458: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   461: aload 4
    //   463: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   469: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   472: aload_2
    //   473: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   476: pop
    //   477: aconst_null
    //   478: areturn
    //   479: iload 7
    //   481: sipush 404
    //   484: if_icmpne +25 -> 509
    //   487: aload_2
    //   488: astore_1
    //   489: new 725	com/whatsapp/gdrive/ay
    //   492: dup
    //   493: invokespecial 726	com/whatsapp/gdrive/ay:<init>	()V
    //   496: athrow
    //   497: astore_3
    //   498: aload_1
    //   499: astore_2
    //   500: aload_3
    //   501: astore_1
    //   502: aload_2
    //   503: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   506: pop
    //   507: aload_1
    //   508: athrow
    //   509: aload_2
    //   510: astore_1
    //   511: new 84	java/lang/StringBuilder
    //   514: dup
    //   515: ldc_w 646
    //   518: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   521: iload 7
    //   523: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   526: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   532: aload_2
    //   533: astore_1
    //   534: new 648	com/whatsapp/gdrive/bg
    //   537: dup
    //   538: aload 4
    //   540: invokespecial 649	com/whatsapp/gdrive/bg:<init>	(Ljava/lang/String;)V
    //   543: athrow
    //   544: aload_2
    //   545: astore_1
    //   546: aload 5
    //   548: ldc_w 728
    //   551: invokeinterface 429 2 0
    //   556: astore 4
    //   558: aload_2
    //   559: astore_1
    //   560: aload 4
    //   562: arraylength
    //   563: iconst_1
    //   564: if_icmpeq +40 -> 604
    //   567: aload_2
    //   568: astore_1
    //   569: new 84	java/lang/StringBuilder
    //   572: dup
    //   573: ldc_w 730
    //   576: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   579: aload 4
    //   581: arraylength
    //   582: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   585: ldc_w 732
    //   588: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   597: aload_2
    //   598: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   601: pop
    //   602: aconst_null
    //   603: areturn
    //   604: aload_2
    //   605: astore_1
    //   606: new 84	java/lang/StringBuilder
    //   609: dup
    //   610: ldc_w 734
    //   613: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   616: aload 4
    //   618: iconst_0
    //   619: aaload
    //   620: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   623: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   629: aload_2
    //   630: astore_1
    //   631: ldc_w 736
    //   634: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   637: aload_2
    //   638: astore_1
    //   639: aload 4
    //   641: iconst_0
    //   642: aaload
    //   643: invokeinterface 444 1 0
    //   648: astore 4
    //   650: aload_2
    //   651: astore_1
    //   652: new 84	java/lang/StringBuilder
    //   655: dup
    //   656: ldc_w 738
    //   659: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   662: aload_3
    //   663: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: ldc_w 328
    //   669: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: aload 4
    //   674: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   680: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   683: aload_2
    //   684: astore_1
    //   685: aload_0
    //   686: invokespecial 316	com/whatsapp/gdrive/at:g	()Landroid/content/SharedPreferences;
    //   689: invokeinterface 742 1 0
    //   694: astore 5
    //   696: aload_2
    //   697: astore_1
    //   698: aload 5
    //   700: aload_0
    //   701: aload_3
    //   702: invokespecial 319	com/whatsapp/gdrive/at:c	(Ljava/lang/String;)Ljava/lang/String;
    //   705: aload 4
    //   707: invokeinterface 748 3 0
    //   712: pop
    //   713: aload_2
    //   714: astore_1
    //   715: aload 5
    //   717: invokeinterface 751 1 0
    //   722: ifne +11 -> 733
    //   725: aload_2
    //   726: astore_1
    //   727: ldc_w 753
    //   730: invokestatic 756	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   733: aload_2
    //   734: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   737: pop
    //   738: aload 4
    //   740: areturn
    //   741: astore_1
    //   742: aconst_null
    //   743: astore_2
    //   744: goto -242 -> 502
    //   747: astore_3
    //   748: aconst_null
    //   749: astore_2
    //   750: goto -317 -> 433
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	753	0	this	at
    //   0	753	1	paramString1	String
    //   0	753	2	paramFile	File
    //   0	753	3	paramString2	String
    //   0	753	4	paramev	ev
    //   0	753	5	paramString3	String
    //   0	753	6	paramBoolean	boolean
    //   322	200	7	i1	int
    //   18	279	8	localObject	Object
    //   7	33	9	str	String
    // Exception table:
    //   from	to	target	type
    //   126	205	246	org/json/JSONException
    //   126	205	256	java/io/UnsupportedEncodingException
    //   288	294	432	java/io/IOException
    //   296	301	432	java/io/IOException
    //   303	308	432	java/io/IOException
    //   310	324	432	java/io/IOException
    //   326	368	432	java/io/IOException
    //   386	391	432	java/io/IOException
    //   414	422	432	java/io/IOException
    //   424	432	432	java/io/IOException
    //   451	472	432	java/io/IOException
    //   489	497	432	java/io/IOException
    //   511	532	432	java/io/IOException
    //   534	544	432	java/io/IOException
    //   546	558	432	java/io/IOException
    //   560	567	432	java/io/IOException
    //   569	597	432	java/io/IOException
    //   606	629	432	java/io/IOException
    //   631	637	432	java/io/IOException
    //   639	650	432	java/io/IOException
    //   652	683	432	java/io/IOException
    //   685	696	432	java/io/IOException
    //   698	713	432	java/io/IOException
    //   715	725	432	java/io/IOException
    //   727	733	432	java/io/IOException
    //   288	294	497	finally
    //   296	301	497	finally
    //   303	308	497	finally
    //   310	324	497	finally
    //   326	368	497	finally
    //   386	391	497	finally
    //   414	422	497	finally
    //   424	432	497	finally
    //   435	442	497	finally
    //   451	472	497	finally
    //   489	497	497	finally
    //   511	532	497	finally
    //   534	544	497	finally
    //   546	558	497	finally
    //   560	567	497	finally
    //   569	597	497	finally
    //   606	629	497	finally
    //   631	637	497	finally
    //   639	650	497	finally
    //   652	683	497	finally
    //   685	696	497	finally
    //   698	713	497	finally
    //   715	725	497	finally
    //   727	733	497	finally
    //   266	282	741	finally
    //   266	282	747	java/io/IOException
  }
  
  private HttpURLConnection a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    paramString1 = (HttpsURLConnection)new URL(paramString1.replace("www.googleapis.com", f())).openConnection();
    paramString1.setSSLSocketFactory(this.j);
    paramString1.setRequestProperty("Host", "www.googleapis.com");
    paramString1.setHostnameVerifier(new c((byte)0));
    paramString1.setRequestProperty("Authorization", "Bearer " + this.o);
    paramString1.setRequestProperty("Expect", "100-continue");
    paramString1.setRequestProperty("User-Agent", ape.a());
    paramString1.setConnectTimeout(15000);
    paramString1.setReadTimeout(30000);
    paramString1.setRequestMethod(paramString2);
    if (paramString3 != null) {
      paramString1.setRequestProperty("Content-Type", paramString3);
    }
    paramString1.setDoOutput(paramBoolean);
    this.k.incrementAndGet();
    return paramString1;
  }
  
  /* Error */
  private List<bb> a(String paramString, ev paramev, StringBuffer paramStringBuffer)
  {
    // Byte code:
    //   0: new 818	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 819	java/util/ArrayList:<init>	()V
    //   7: astore 10
    //   9: aload_0
    //   10: aload_1
    //   11: ldc_w 821
    //   14: aconst_null
    //   15: iconst_0
    //   16: invokespecial 823	com/whatsapp/gdrive/at:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/net/HttpURLConnection;
    //   19: astore_1
    //   20: aload_1
    //   21: invokevirtual 828	java/net/HttpURLConnection:connect	()V
    //   24: aload_1
    //   25: invokevirtual 831	java/net/HttpURLConnection:getResponseCode	()I
    //   28: istore 4
    //   30: new 84	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 833
    //   37: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: iload 4
    //   42: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: ldc_w 433
    //   48: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_1
    //   52: invokevirtual 836	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   55: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   64: iload 4
    //   66: sipush 200
    //   69: if_icmpne +703 -> 772
    //   72: new 838	com/google/a/b/a
    //   75: dup
    //   76: new 840	java/io/InputStreamReader
    //   79: dup
    //   80: aload_1
    //   81: invokevirtual 844	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   84: invokespecial 847	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   87: invokespecial 850	com/google/a/b/a:<init>	(Ljava/io/Reader;)V
    //   90: astore 9
    //   92: aload 9
    //   94: astore 8
    //   96: aload_1
    //   97: astore 7
    //   99: aload_3
    //   100: iconst_0
    //   101: invokevirtual 855	java/lang/StringBuffer:setLength	(I)V
    //   104: aload 9
    //   106: astore 8
    //   108: aload_1
    //   109: astore 7
    //   111: aload 9
    //   113: invokevirtual 857	com/google/a/b/a:c	()V
    //   116: iconst_0
    //   117: istore 5
    //   119: aload 9
    //   121: astore 8
    //   123: aload_1
    //   124: astore 7
    //   126: aload 9
    //   128: invokevirtual 859	com/google/a/b/a:e	()Z
    //   131: ifeq +506 -> 637
    //   134: aload 9
    //   136: astore 8
    //   138: aload_1
    //   139: astore 7
    //   141: aload_2
    //   142: invokevirtual 372	com/whatsapp/gdrive/ev:a	()Z
    //   145: istore 6
    //   147: iload 6
    //   149: ifne +14 -> 163
    //   152: aload 9
    //   154: invokestatic 864	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   157: aload_1
    //   158: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   161: aconst_null
    //   162: areturn
    //   163: aload 9
    //   165: astore 8
    //   167: aload_1
    //   168: astore 7
    //   170: aload 9
    //   172: invokevirtual 868	com/google/a/b/a:f	()Ljava/lang/String;
    //   175: astore 11
    //   177: iconst_m1
    //   178: istore 4
    //   180: aload 9
    //   182: astore 8
    //   184: aload_1
    //   185: astore 7
    //   187: aload 11
    //   189: invokevirtual 871	java/lang/String:hashCode	()I
    //   192: lookupswitch	default:+720->912, -1386094857:+141->333, 100526016:+117->309
    //   220: aload 9
    //   222: astore 8
    //   224: aload_1
    //   225: astore 7
    //   227: new 84	java/lang/StringBuilder
    //   230: dup
    //   231: ldc_w 873
    //   234: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   237: aload 11
    //   239: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: ldc_w 875
    //   245: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload 9
    //   250: invokevirtual 877	com/google/a/b/a:g	()Ljava/lang/String;
    //   253: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   262: goto -143 -> 119
    //   265: astore_3
    //   266: aload_1
    //   267: astore_2
    //   268: aload 9
    //   270: astore_1
    //   271: ldc_w 879
    //   274: aload_3
    //   275: invokestatic 642	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   278: new 881	java/lang/InterruptedException
    //   281: dup
    //   282: aload_3
    //   283: invokevirtual 884	java/nio/channels/ClosedByInterruptException:getMessage	()Ljava/lang/String;
    //   286: invokespecial 885	java/lang/InterruptedException:<init>	(Ljava/lang/String;)V
    //   289: athrow
    //   290: astore_3
    //   291: aload_1
    //   292: astore 8
    //   294: aload_2
    //   295: astore_1
    //   296: aload_3
    //   297: astore_2
    //   298: aload 8
    //   300: invokestatic 864	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   303: aload_1
    //   304: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   307: aload_2
    //   308: athrow
    //   309: aload 9
    //   311: astore 8
    //   313: aload_1
    //   314: astore 7
    //   316: aload 11
    //   318: ldc_w 887
    //   321: invokevirtual 624	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   324: ifeq +588 -> 912
    //   327: iconst_0
    //   328: istore 4
    //   330: goto +582 -> 912
    //   333: aload 9
    //   335: astore 8
    //   337: aload_1
    //   338: astore 7
    //   340: aload 11
    //   342: ldc_w 889
    //   345: invokevirtual 624	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   348: ifeq +564 -> 912
    //   351: iconst_1
    //   352: istore 4
    //   354: goto +558 -> 912
    //   357: aload 9
    //   359: astore 8
    //   361: aload_1
    //   362: astore 7
    //   364: aload 9
    //   366: invokevirtual 891	com/google/a/b/a:a	()V
    //   369: aload 9
    //   371: astore 8
    //   373: aload_1
    //   374: astore 7
    //   376: aload 9
    //   378: invokevirtual 859	com/google/a/b/a:e	()Z
    //   381: ifeq +114 -> 495
    //   384: aload 9
    //   386: astore 8
    //   388: aload_1
    //   389: astore 7
    //   391: aload_0
    //   392: invokevirtual 553	com/whatsapp/gdrive/at:a	()Z
    //   395: ifeq +47 -> 442
    //   398: aload 9
    //   400: astore 8
    //   402: aload_1
    //   403: astore 7
    //   405: new 881	java/lang/InterruptedException
    //   408: dup
    //   409: ldc_w 879
    //   412: invokespecial 885	java/lang/InterruptedException:<init>	(Ljava/lang/String;)V
    //   415: athrow
    //   416: astore_2
    //   417: aload 9
    //   419: astore 8
    //   421: aload_1
    //   422: astore 7
    //   424: ldc_w 893
    //   427: aload_2
    //   428: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   431: aload 9
    //   433: invokestatic 864	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   436: aload_1
    //   437: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   440: aconst_null
    //   441: areturn
    //   442: aload 9
    //   444: astore 8
    //   446: aload_1
    //   447: astore 7
    //   449: aload 9
    //   451: invokevirtual 857	com/google/a/b/a:c	()V
    //   454: aload 9
    //   456: astore 8
    //   458: aload_1
    //   459: astore 7
    //   461: aload 10
    //   463: aload 9
    //   465: invokestatic 896	com/whatsapp/gdrive/bb:a	(Lcom/google/a/b/a;)Lcom/whatsapp/gdrive/bb;
    //   468: invokeinterface 901 2 0
    //   473: pop
    //   474: aload 9
    //   476: astore 8
    //   478: aload_1
    //   479: astore 7
    //   481: aload 9
    //   483: invokevirtual 903	com/google/a/b/a:d	()V
    //   486: iload 5
    //   488: iconst_1
    //   489: iadd
    //   490: istore 5
    //   492: goto -123 -> 369
    //   495: aload 9
    //   497: astore 8
    //   499: aload_1
    //   500: astore 7
    //   502: aload 9
    //   504: invokevirtual 905	com/google/a/b/a:b	()V
    //   507: goto -388 -> 119
    //   510: astore_2
    //   511: aload 9
    //   513: astore 8
    //   515: aload_1
    //   516: astore 7
    //   518: ldc_w 893
    //   521: aload_2
    //   522: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   525: aload 9
    //   527: astore 8
    //   529: aload_1
    //   530: astore 7
    //   532: aload_1
    //   533: aload_2
    //   534: invokestatic 908	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;Ljava/io/IOException;)Z
    //   537: ifeq +69 -> 606
    //   540: aload 9
    //   542: astore 8
    //   544: aload_1
    //   545: astore 7
    //   547: new 84	java/lang/StringBuilder
    //   550: dup
    //   551: ldc_w 910
    //   554: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   557: astore_3
    //   558: aload_1
    //   559: ifnull +292 -> 851
    //   562: aload 9
    //   564: astore 8
    //   566: aload_1
    //   567: astore 7
    //   569: aload_1
    //   570: invokevirtual 914	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   573: astore_2
    //   574: aload 9
    //   576: astore 8
    //   578: aload_1
    //   579: astore 7
    //   581: aload_3
    //   582: aload_2
    //   583: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   586: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   592: aload 9
    //   594: astore 8
    //   596: aload_1
    //   597: astore 7
    //   599: aload_0
    //   600: invokestatic 917	java/lang/System:currentTimeMillis	()J
    //   603: putfield 919	com/whatsapp/gdrive/at:n	J
    //   606: aload 9
    //   608: invokestatic 864	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   611: aload_1
    //   612: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   615: aconst_null
    //   616: areturn
    //   617: aload 9
    //   619: astore 8
    //   621: aload_1
    //   622: astore 7
    //   624: aload_3
    //   625: aload 9
    //   627: invokevirtual 877	com/google/a/b/a:g	()Ljava/lang/String;
    //   630: invokevirtual 922	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   633: pop
    //   634: goto -515 -> 119
    //   637: aload 9
    //   639: astore 8
    //   641: aload_1
    //   642: astore 7
    //   644: aload 9
    //   646: invokevirtual 903	com/google/a/b/a:d	()V
    //   649: aload 9
    //   651: astore 8
    //   653: aload_1
    //   654: astore 7
    //   656: aload 9
    //   658: invokevirtual 925	com/google/a/b/a:close	()V
    //   661: aload 9
    //   663: astore 8
    //   665: aload_1
    //   666: astore 7
    //   668: aload_1
    //   669: invokevirtual 928	java/net/HttpURLConnection:disconnect	()V
    //   672: aload 9
    //   674: astore 8
    //   676: aload_1
    //   677: astore 7
    //   679: new 84	java/lang/StringBuilder
    //   682: dup
    //   683: ldc_w 930
    //   686: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   689: iload 5
    //   691: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   694: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   697: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   700: aload 9
    //   702: astore 8
    //   704: aload_1
    //   705: astore 7
    //   707: aload_3
    //   708: invokevirtual 932	java/lang/StringBuffer:length	()I
    //   711: ifne +28 -> 739
    //   714: aload 9
    //   716: astore 8
    //   718: aload_1
    //   719: astore 7
    //   721: ldc_w 934
    //   724: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   727: aload 9
    //   729: invokestatic 864	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   732: aload_1
    //   733: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   736: aload 10
    //   738: areturn
    //   739: aload 9
    //   741: astore 8
    //   743: aload_1
    //   744: astore 7
    //   746: new 84	java/lang/StringBuilder
    //   749: dup
    //   750: ldc_w 936
    //   753: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   756: aload_3
    //   757: invokevirtual 937	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   760: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   766: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   769: goto -42 -> 727
    //   772: iload 4
    //   774: sipush 401
    //   777: if_icmpne +18 -> 795
    //   780: aload_0
    //   781: invokevirtual 423	com/whatsapp/gdrive/at:b	()Z
    //   784: pop
    //   785: aconst_null
    //   786: invokestatic 864	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   789: aload_1
    //   790: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   793: aconst_null
    //   794: areturn
    //   795: aload_1
    //   796: invokevirtual 940	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   799: invokestatic 943	com/whatsapp/gdrive/ch:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   802: astore_2
    //   803: new 84	java/lang/StringBuilder
    //   806: dup
    //   807: ldc_w 945
    //   810: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   813: iload 4
    //   815: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   818: ldc_w 433
    //   821: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: aload_2
    //   825: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   831: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   834: new 648	com/whatsapp/gdrive/bg
    //   837: dup
    //   838: aload_2
    //   839: invokespecial 649	com/whatsapp/gdrive/bg:<init>	(Ljava/lang/String;)V
    //   842: athrow
    //   843: astore_3
    //   844: aload_1
    //   845: astore_2
    //   846: aconst_null
    //   847: astore_1
    //   848: goto -577 -> 271
    //   851: aconst_null
    //   852: astore_2
    //   853: goto -279 -> 574
    //   856: astore_2
    //   857: aconst_null
    //   858: astore 8
    //   860: aconst_null
    //   861: astore_1
    //   862: goto -564 -> 298
    //   865: astore_2
    //   866: aconst_null
    //   867: astore 8
    //   869: goto -571 -> 298
    //   872: astore_2
    //   873: aconst_null
    //   874: astore 9
    //   876: aconst_null
    //   877: astore_1
    //   878: goto -367 -> 511
    //   881: astore_2
    //   882: aconst_null
    //   883: astore 9
    //   885: goto -374 -> 511
    //   888: astore_2
    //   889: aconst_null
    //   890: astore 9
    //   892: aconst_null
    //   893: astore_1
    //   894: goto -477 -> 417
    //   897: astore_2
    //   898: aconst_null
    //   899: astore 9
    //   901: goto -484 -> 417
    //   904: astore_3
    //   905: aconst_null
    //   906: astore_2
    //   907: aconst_null
    //   908: astore_1
    //   909: goto -638 -> 271
    //   912: iload 4
    //   914: tableswitch	default:+22->936, 0:+-557->357, 1:+-297->617
    //   936: goto -716 -> 220
    //   939: astore_2
    //   940: aload 7
    //   942: astore_1
    //   943: goto -645 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	946	0	this	at
    //   0	946	1	paramString	String
    //   0	946	2	paramev	ev
    //   0	946	3	paramStringBuffer	StringBuffer
    //   28	885	4	i1	int
    //   117	573	5	i2	int
    //   145	3	6	bool	boolean
    //   97	844	7	str1	String
    //   94	774	8	localObject	Object
    //   90	810	9	locala	com.google.a.b.a
    //   7	730	10	localArrayList	ArrayList
    //   175	166	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   99	104	265	java/nio/channels/ClosedByInterruptException
    //   111	116	265	java/nio/channels/ClosedByInterruptException
    //   126	134	265	java/nio/channels/ClosedByInterruptException
    //   141	147	265	java/nio/channels/ClosedByInterruptException
    //   170	177	265	java/nio/channels/ClosedByInterruptException
    //   187	220	265	java/nio/channels/ClosedByInterruptException
    //   227	262	265	java/nio/channels/ClosedByInterruptException
    //   316	327	265	java/nio/channels/ClosedByInterruptException
    //   340	351	265	java/nio/channels/ClosedByInterruptException
    //   364	369	265	java/nio/channels/ClosedByInterruptException
    //   376	384	265	java/nio/channels/ClosedByInterruptException
    //   391	398	265	java/nio/channels/ClosedByInterruptException
    //   405	416	265	java/nio/channels/ClosedByInterruptException
    //   449	454	265	java/nio/channels/ClosedByInterruptException
    //   461	474	265	java/nio/channels/ClosedByInterruptException
    //   481	486	265	java/nio/channels/ClosedByInterruptException
    //   502	507	265	java/nio/channels/ClosedByInterruptException
    //   624	634	265	java/nio/channels/ClosedByInterruptException
    //   644	649	265	java/nio/channels/ClosedByInterruptException
    //   656	661	265	java/nio/channels/ClosedByInterruptException
    //   668	672	265	java/nio/channels/ClosedByInterruptException
    //   679	700	265	java/nio/channels/ClosedByInterruptException
    //   707	714	265	java/nio/channels/ClosedByInterruptException
    //   721	727	265	java/nio/channels/ClosedByInterruptException
    //   746	769	265	java/nio/channels/ClosedByInterruptException
    //   271	290	290	finally
    //   99	104	416	java/lang/IllegalStateException
    //   111	116	416	java/lang/IllegalStateException
    //   126	134	416	java/lang/IllegalStateException
    //   141	147	416	java/lang/IllegalStateException
    //   170	177	416	java/lang/IllegalStateException
    //   187	220	416	java/lang/IllegalStateException
    //   227	262	416	java/lang/IllegalStateException
    //   316	327	416	java/lang/IllegalStateException
    //   340	351	416	java/lang/IllegalStateException
    //   364	369	416	java/lang/IllegalStateException
    //   376	384	416	java/lang/IllegalStateException
    //   391	398	416	java/lang/IllegalStateException
    //   405	416	416	java/lang/IllegalStateException
    //   449	454	416	java/lang/IllegalStateException
    //   461	474	416	java/lang/IllegalStateException
    //   481	486	416	java/lang/IllegalStateException
    //   502	507	416	java/lang/IllegalStateException
    //   624	634	416	java/lang/IllegalStateException
    //   644	649	416	java/lang/IllegalStateException
    //   656	661	416	java/lang/IllegalStateException
    //   668	672	416	java/lang/IllegalStateException
    //   679	700	416	java/lang/IllegalStateException
    //   707	714	416	java/lang/IllegalStateException
    //   721	727	416	java/lang/IllegalStateException
    //   746	769	416	java/lang/IllegalStateException
    //   99	104	510	java/io/IOException
    //   111	116	510	java/io/IOException
    //   126	134	510	java/io/IOException
    //   141	147	510	java/io/IOException
    //   170	177	510	java/io/IOException
    //   187	220	510	java/io/IOException
    //   227	262	510	java/io/IOException
    //   316	327	510	java/io/IOException
    //   340	351	510	java/io/IOException
    //   364	369	510	java/io/IOException
    //   376	384	510	java/io/IOException
    //   391	398	510	java/io/IOException
    //   405	416	510	java/io/IOException
    //   449	454	510	java/io/IOException
    //   461	474	510	java/io/IOException
    //   481	486	510	java/io/IOException
    //   502	507	510	java/io/IOException
    //   624	634	510	java/io/IOException
    //   644	649	510	java/io/IOException
    //   656	661	510	java/io/IOException
    //   668	672	510	java/io/IOException
    //   679	700	510	java/io/IOException
    //   707	714	510	java/io/IOException
    //   721	727	510	java/io/IOException
    //   746	769	510	java/io/IOException
    //   20	64	843	java/nio/channels/ClosedByInterruptException
    //   72	92	843	java/nio/channels/ClosedByInterruptException
    //   780	785	843	java/nio/channels/ClosedByInterruptException
    //   795	843	843	java/nio/channels/ClosedByInterruptException
    //   9	20	856	finally
    //   20	64	865	finally
    //   72	92	865	finally
    //   780	785	865	finally
    //   795	843	865	finally
    //   9	20	872	java/io/IOException
    //   20	64	881	java/io/IOException
    //   72	92	881	java/io/IOException
    //   780	785	881	java/io/IOException
    //   795	843	881	java/io/IOException
    //   9	20	888	java/lang/IllegalStateException
    //   20	64	897	java/lang/IllegalStateException
    //   72	92	897	java/lang/IllegalStateException
    //   780	785	897	java/lang/IllegalStateException
    //   795	843	897	java/lang/IllegalStateException
    //   9	20	904	java/nio/channels/ClosedByInterruptException
    //   99	104	939	finally
    //   111	116	939	finally
    //   126	134	939	finally
    //   141	147	939	finally
    //   170	177	939	finally
    //   187	220	939	finally
    //   227	262	939	finally
    //   316	327	939	finally
    //   340	351	939	finally
    //   364	369	939	finally
    //   376	384	939	finally
    //   391	398	939	finally
    //   405	416	939	finally
    //   424	431	939	finally
    //   449	454	939	finally
    //   461	474	939	finally
    //   481	486	939	finally
    //   502	507	939	finally
    //   518	525	939	finally
    //   532	540	939	finally
    //   547	558	939	finally
    //   569	574	939	finally
    //   581	592	939	finally
    //   599	606	939	finally
    //   624	634	939	finally
    //   644	649	939	finally
    //   656	661	939	finally
    //   668	672	939	finally
    //   679	700	939	finally
    //   707	714	939	finally
    //   721	727	939	finally
    //   746	769	939	finally
  }
  
  private List<bb> a(String paramString1, boolean paramBoolean, String paramString2, final ev paramev)
  {
    ArrayList localArrayList = new ArrayList();
    final StringBuffer localStringBuffer = new StringBuffer("");
    String str = String.format(Locale.ENGLISH, "%s(%s),%s", new Object[] { "items", bb.a(paramBoolean), "nextPageToken" });
    int i1 = 0;
    for (;;)
    {
      Log.i("gdrive-api/query-files/" + i1 + "/query:" + paramString1 + " pageToken:" + localStringBuffer + " space:" + paramString2 + " fetch-properties:" + paramBoolean + " access-condition:" + paramev);
      final Object localObject = Uri.parse("https://www.googleapis.com/drive/v2/files").buildUpon().appendQueryParameter("mode", this.q.g).appendQueryParameter("spaces", paramString2).appendQueryParameter("maxResults", "1000").appendQueryParameter("fields", str).appendQueryParameter("q", paramString1);
      if (localStringBuffer.length() > 0) {
        ((Uri.Builder)localObject).appendQueryParameter("pageToken", localStringBuffer.toString());
      }
      localObject = ((Uri.Builder)localObject).build().toString();
      Log.i("gdrive-api/query-files url to be opened is " + (String)localObject);
      if (a()) {
        throw new InterruptedException("gdrive-api/query-files/interrupted");
      }
      localObject = (List)cs.a(paramev, new cd() {}, "gdrive-api/query-files query: \"" + paramString1 + "\" pageToken:" + localStringBuffer);
      if (localObject != null)
      {
        localArrayList.addAll((Collection)localObject);
        Log.i(String.format(Locale.ENGLISH, "gdrive-api/query-files retrieved %d files (new total %d)", new Object[] { Integer.valueOf(((List)localObject).size()), Integer.valueOf(localArrayList.size()) }));
        if (localStringBuffer.length() <= 0) {
          return localArrayList;
        }
      }
      else
      {
        return null;
      }
      i1 += 1;
    }
  }
  
  private HttpResponse a(HttpRequestBase paramHttpRequestBase)
  {
    paramHttpRequestBase.setURI(URI.create(paramHttpRequestBase.getURI().toString().replace("www.googleapis.com", f())));
    paramHttpRequestBase.setHeader("Host", "www.googleapis.com");
    try
    {
      HttpResponse localHttpResponse = this.h.execute(paramHttpRequestBase);
      return localHttpResponse;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      if (paramHttpRequestBase.getURI().getHost().startsWith("[")) {
        this.n = System.currentTimeMillis();
      }
      throw localSocketTimeoutException;
    }
    catch (ConnectTimeoutException localConnectTimeoutException)
    {
      for (;;) {}
    }
    catch (SocketException localSocketException)
    {
      for (;;) {}
    }
  }
  
  private static void a(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection != null) {
      paramHttpURLConnection.disconnect();
    }
  }
  
  /* Error */
  private void a(final HttpURLConnection paramHttpURLConnection, File paramFile, a parama, ev paramev)
  {
    // Byte code:
    //   0: new 1063	java/util/concurrent/atomic/AtomicBoolean
    //   3: dup
    //   4: iconst_1
    //   5: invokespecial 1065	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   8: astore 12
    //   10: new 1067	java/io/BufferedInputStream
    //   13: dup
    //   14: aload_1
    //   15: invokevirtual 844	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   18: invokespecial 1068	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore 13
    //   23: new 10	com/whatsapp/gdrive/at$3
    //   26: dup
    //   27: aload_0
    //   28: aload 12
    //   30: aload_1
    //   31: aload 13
    //   33: invokespecial 1071	com/whatsapp/gdrive/at$3:<init>	(Lcom/whatsapp/gdrive/at;Ljava/util/concurrent/atomic/AtomicBoolean;Ljava/net/HttpURLConnection;Ljava/io/BufferedInputStream;)V
    //   36: astore 11
    //   38: new 1073	java/io/FileOutputStream
    //   41: dup
    //   42: aload_2
    //   43: iconst_1
    //   44: invokespecial 1076	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   47: astore 10
    //   49: sipush 8192
    //   52: newarray <illegal type>
    //   54: astore 14
    //   56: lconst_0
    //   57: lstore 8
    //   59: lload 8
    //   61: lstore 6
    //   63: aload 4
    //   65: invokevirtual 372	com/whatsapp/gdrive/ev:a	()Z
    //   68: ifne +30 -> 98
    //   71: lload 8
    //   73: lstore 6
    //   75: aload 12
    //   77: iconst_0
    //   78: invokevirtual 1079	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   81: lload 8
    //   83: lstore 6
    //   85: aload_1
    //   86: invokevirtual 928	java/net/HttpURLConnection:disconnect	()V
    //   89: lload 8
    //   91: lstore 6
    //   93: aload 13
    //   95: invokestatic 864	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   98: lload 8
    //   100: lstore 6
    //   102: aload 12
    //   104: invokevirtual 1081	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   107: ifne +81 -> 188
    //   110: lload 8
    //   112: lstore 6
    //   114: getstatic 349	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   117: ldc_w 1083
    //   120: iconst_4
    //   121: anewarray 4	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: lload 8
    //   128: invokestatic 361	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   131: aastore
    //   132: dup
    //   133: iconst_1
    //   134: aload_1
    //   135: invokevirtual 914	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   138: aastore
    //   139: dup
    //   140: iconst_2
    //   141: aload_2
    //   142: invokevirtual 520	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   145: aastore
    //   146: dup
    //   147: iconst_3
    //   148: aload_2
    //   149: invokevirtual 357	java/io/File:length	()J
    //   152: invokestatic 361	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   155: aastore
    //   156: invokestatic 367	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   159: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   162: invokestatic 577	b/a/a/c:a	()Lb/a/a/c;
    //   165: aload 11
    //   167: invokevirtual 580	b/a/a/c:a	(Ljava/lang/Object;)V
    //   170: aload_3
    //   171: lload 8
    //   173: ldc2_w 566
    //   176: lmul
    //   177: invokeinterface 1084 3 0
    //   182: aload 10
    //   184: invokestatic 864	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   187: return
    //   188: lload 8
    //   190: lstore 6
    //   192: aload 13
    //   194: aload 14
    //   196: iconst_0
    //   197: sipush 8192
    //   200: invokevirtual 1088	java/io/BufferedInputStream:read	([BII)I
    //   203: istore 5
    //   205: iload 5
    //   207: ifle -45 -> 162
    //   210: lload 8
    //   212: lstore 6
    //   214: aload 10
    //   216: aload 14
    //   218: iconst_0
    //   219: iload 5
    //   221: invokevirtual 1094	java/io/OutputStream:write	([BII)V
    //   224: lload 8
    //   226: iload 5
    //   228: i2l
    //   229: ladd
    //   230: lstore 8
    //   232: lload 8
    //   234: lstore 6
    //   236: aload_3
    //   237: iload 5
    //   239: i2l
    //   240: invokeinterface 1084 3 0
    //   245: goto -186 -> 59
    //   248: astore_1
    //   249: aload 10
    //   251: astore_2
    //   252: invokestatic 577	b/a/a/c:a	()Lb/a/a/c;
    //   255: aload 11
    //   257: invokevirtual 580	b/a/a/c:a	(Ljava/lang/Object;)V
    //   260: aload_3
    //   261: lload 6
    //   263: ldc2_w 566
    //   266: lmul
    //   267: invokeinterface 1084 3 0
    //   272: aload_2
    //   273: invokestatic 864	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   276: aload_1
    //   277: athrow
    //   278: astore_1
    //   279: lload 8
    //   281: lstore 6
    //   283: ldc_w 1096
    //   286: aload_1
    //   287: invokestatic 642	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   290: goto -128 -> 162
    //   293: astore_1
    //   294: aconst_null
    //   295: astore_2
    //   296: lconst_0
    //   297: lstore 6
    //   299: goto -47 -> 252
    //   302: astore_1
    //   303: lconst_0
    //   304: lstore 6
    //   306: aload 10
    //   308: astore_2
    //   309: goto -57 -> 252
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	this	at
    //   0	312	1	paramHttpURLConnection	HttpURLConnection
    //   0	312	2	paramFile	File
    //   0	312	3	parama	a
    //   0	312	4	paramev	ev
    //   203	35	5	i1	int
    //   61	244	6	l1	long
    //   57	223	8	l2	long
    //   47	260	10	localFileOutputStream	java.io.FileOutputStream
    //   36	220	11	local3	3
    //   8	95	12	localAtomicBoolean	AtomicBoolean
    //   21	172	13	localBufferedInputStream	BufferedInputStream
    //   54	163	14	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   63	71	248	finally
    //   75	81	248	finally
    //   85	89	248	finally
    //   93	98	248	finally
    //   102	110	248	finally
    //   114	162	248	finally
    //   192	205	248	finally
    //   214	224	248	finally
    //   236	245	248	finally
    //   283	290	248	finally
    //   192	205	278	java/lang/IllegalStateException
    //   38	49	293	finally
    //   49	56	302	finally
  }
  
  private static boolean a(File paramFile)
  {
    if (!paramFile.delete())
    {
      Log.e("gdrive-api/delete-local-file/failed " + paramFile.getAbsolutePath());
      return false;
    }
    return true;
  }
  
  private boolean a(File paramFile, long paramLong, String paramString)
  {
    String str = ch.a(this.t, this.u, paramFile, paramLong);
    if (paramString == null)
    {
      Log.e("gdrive-api/save-file/check-md5 " + paramFile.getAbsolutePath() + " downloaded but its remote md5 is null.");
      return false;
    }
    if (!paramString.equals(str))
    {
      Log.e("gdrive-api/save-file/check-md5 " + paramFile.getAbsolutePath() + " downloaded but its MD5(" + str + ") does not match remote md5(" + paramString + ").");
      return false;
    }
    return true;
  }
  
  private static boolean a(HttpURLConnection paramHttpURLConnection, IOException paramIOException)
  {
    return (((paramIOException instanceof SocketException)) || ((paramIOException instanceof SocketTimeoutException))) && (paramHttpURLConnection != null) && (paramHttpURLConnection.getURL().getHost().contains(":"));
  }
  
  private boolean a(List<bb> paramList, int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1) {
      throw new IllegalArgumentException("endIndex (" + paramInt2 + ") cannot be smaller than startIndex(" + paramInt1 + ")");
    }
    if (a())
    {
      Log.i("gdrive-api/delete-batch/interrupted");
      return false;
    }
    int i1;
    int i3;
    if (paramInt2 - paramInt1 > 50)
    {
      Log.i("gdrive-api/delete-batch/too-many-files/" + paramInt1 + "-" + paramInt2);
      i1 = paramInt1;
      i3 = 1;
      for (;;)
      {
        if (i1 >= paramInt2) {
          break label148;
        }
        i3 = a(paramList, i1 * 50 + paramInt1, (i1 + 1) * 50 + paramInt1);
        if (i3 == 0) {
          break;
        }
        i1 += 1;
      }
      label148:
      if (i1 < paramInt2) {
        i3 = a(paramList, i1, paramInt2);
      }
    }
    for (;;)
    {
      Object localObject = new HttpDelete[paramInt2 - paramInt1];
      i1 = paramInt1;
      while (i1 < paramInt2)
      {
        localObject[(i1 - paramInt1)] = new HttpDelete(ch.a(String.format("https://www.googleapis.com/drive/v2/files/%s", new Object[] { URLEncoder.encode(((bb)paramList.get(i1)).c) }), "mode", this.q.g));
        i1 += 1;
      }
      localObject = a((HttpRequestBase[])localObject);
      if (localObject != null) {
        paramInt1 = 1;
      }
      int i2;
      for (;;)
      {
        i3 = paramInt1 & i3;
        i4 = i3;
        if (localObject == null) {
          break label456;
        }
        i1 = localObject.length;
        paramInt1 = 0;
        if (paramInt1 >= i1) {
          break label452;
        }
        paramList = localObject[paramInt1];
        i2 = paramList.getStatusLine().getStatusCode();
        if (i2 == 204)
        {
          paramInt2 = 1;
          label316:
          i3 &= paramInt2;
          paramList = paramList.getEntity();
          if (paramList == null) {
            break label362;
          }
        }
        try
        {
          label362:
          for (paramList = EntityUtils.toString(paramList);; paramList = null)
          {
            if (i2 != 404) {
              break label380;
            }
            throw new be();
            paramInt1 = 0;
            break;
            paramInt2 = 0;
            break label316;
          }
        }
        catch (IOException paramList)
        {
          for (;;)
          {
            Log.d("gdrive-api/delete-batch", paramList);
            paramList = null;
          }
        }
      }
      label380:
      if (i2 == 401) {
        b();
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        if (i2 != 204)
        {
          Log.d("gdrive-api/delete-batch status for file deletion " + i2);
          Log.d("gdrive-api/delete-batch response " + paramList);
        }
      }
      label452:
      int i4 = i3;
      label456:
      return i4;
      continue;
      i3 = 1;
    }
  }
  
  private static boolean a(HttpEntity paramHttpEntity)
  {
    if (paramHttpEntity != null) {}
    try
    {
      paramHttpEntity.consumeContent();
      return true;
    }
    catch (IOException paramHttpEntity)
    {
      Log.d("gdrive-api/consume-entity", paramHttpEntity);
    }
    return false;
  }
  
  /* Error */
  private BasicHttpResponse[] a(String paramString1, final String paramString2, int paramInt)
  {
    // Byte code:
    //   0: iload_3
    //   1: anewarray 1162	org/apache/http/message/BasicHttpResponse
    //   4: astore 4
    //   6: aload_1
    //   7: new 84	java/lang/StringBuilder
    //   10: dup
    //   11: ldc_w 1188
    //   14: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   17: aload_2
    //   18: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokevirtual 1192	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   27: astore 5
    //   29: aload 5
    //   31: arraylength
    //   32: iload_3
    //   33: iconst_2
    //   34: iadd
    //   35: if_icmpeq +39 -> 74
    //   38: new 84	java/lang/StringBuilder
    //   41: dup
    //   42: ldc_w 1194
    //   45: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   48: iload_3
    //   49: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: ldc_w 1196
    //   55: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload 5
    //   60: arraylength
    //   61: iconst_2
    //   62: isub
    //   63: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   72: aconst_null
    //   73: areturn
    //   74: new 1198	org/apache/http/message/BasicLineParser
    //   77: dup
    //   78: getstatic 173	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   81: invokespecial 1201	org/apache/http/message/BasicLineParser:<init>	(Lorg/apache/http/ProtocolVersion;)V
    //   84: astore 6
    //   86: new 1203	org/apache/http/impl/DefaultHttpResponseFactory
    //   89: dup
    //   90: invokespecial 1204	org/apache/http/impl/DefaultHttpResponseFactory:<init>	()V
    //   93: astore 7
    //   95: new 164	org/apache/http/params/BasicHttpParams
    //   98: dup
    //   99: invokespecial 165	org/apache/http/params/BasicHttpParams:<init>	()V
    //   102: astore 8
    //   104: iconst_0
    //   105: istore_3
    //   106: iload_3
    //   107: aload 4
    //   109: arraylength
    //   110: if_icmpge +187 -> 297
    //   113: aload 5
    //   115: iload_3
    //   116: iconst_1
    //   117: iadd
    //   118: aload 5
    //   120: iload_3
    //   121: iconst_1
    //   122: iadd
    //   123: aaload
    //   124: aload 5
    //   126: iload_3
    //   127: iconst_1
    //   128: iadd
    //   129: aaload
    //   130: ldc_w 1206
    //   133: invokevirtual 1210	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   136: iconst_2
    //   137: iadd
    //   138: invokevirtual 1213	java/lang/String:substring	(I)Ljava/lang/String;
    //   141: aastore
    //   142: new 1215	java/io/ByteArrayInputStream
    //   145: dup
    //   146: aload 5
    //   148: iload_3
    //   149: iconst_1
    //   150: iadd
    //   151: aaload
    //   152: invokevirtual 1219	java/lang/String:getBytes	()[B
    //   155: invokespecial 1222	java/io/ByteArrayInputStream:<init>	([B)V
    //   158: astore_2
    //   159: new 14	com/whatsapp/gdrive/at$5
    //   162: dup
    //   163: aload_0
    //   164: aload_2
    //   165: aload 8
    //   167: invokespecial 1225	com/whatsapp/gdrive/at$5:<init>	(Lcom/whatsapp/gdrive/at;Ljava/io/ByteArrayInputStream;Lorg/apache/http/params/HttpParams;)V
    //   170: astore_1
    //   171: aload 4
    //   173: iload_3
    //   174: new 1227	org/apache/http/impl/conn/DefaultResponseParser
    //   177: dup
    //   178: aload_1
    //   179: aload 6
    //   181: aload 7
    //   183: aload 8
    //   185: invokespecial 1230	org/apache/http/impl/conn/DefaultResponseParser:<init>	(Lorg/apache/http/io/SessionInputBuffer;Lorg/apache/http/message/LineParser;Lorg/apache/http/HttpResponseFactory;Lorg/apache/http/params/HttpParams;)V
    //   188: invokevirtual 1233	org/apache/http/impl/conn/DefaultResponseParser:parse	()Lorg/apache/http/HttpMessage;
    //   191: checkcast 1162	org/apache/http/message/BasicHttpResponse
    //   194: aastore
    //   195: aload 5
    //   197: iload_3
    //   198: iconst_1
    //   199: iadd
    //   200: aload 5
    //   202: iload_3
    //   203: iconst_1
    //   204: iadd
    //   205: aaload
    //   206: aload 5
    //   208: iload_3
    //   209: iconst_1
    //   210: iadd
    //   211: aaload
    //   212: ldc_w 1206
    //   215: invokevirtual 1210	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   218: iconst_2
    //   219: iadd
    //   220: invokevirtual 1213	java/lang/String:substring	(I)Ljava/lang/String;
    //   223: aastore
    //   224: aload 5
    //   226: iload_3
    //   227: iconst_1
    //   228: iadd
    //   229: aaload
    //   230: invokevirtual 1234	java/lang/String:length	()I
    //   233: ifle +26 -> 259
    //   236: aload 4
    //   238: iload_3
    //   239: aaload
    //   240: new 681	org/apache/http/entity/StringEntity
    //   243: dup
    //   244: aload 5
    //   246: iload_3
    //   247: iconst_1
    //   248: iadd
    //   249: aaload
    //   250: ldc_w 710
    //   253: invokespecial 712	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: invokevirtual 1235	org/apache/http/message/BasicHttpResponse:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   259: aload_2
    //   260: invokestatic 864	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   263: iload_3
    //   264: iconst_1
    //   265: iadd
    //   266: istore_3
    //   267: goto -161 -> 106
    //   270: astore_1
    //   271: ldc_w 1237
    //   274: aload_1
    //   275: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   278: aload 4
    //   280: iload_3
    //   281: aconst_null
    //   282: aastore
    //   283: aload_2
    //   284: invokestatic 864	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   287: goto -24 -> 263
    //   290: astore_1
    //   291: aload_2
    //   292: invokestatic 864	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   295: aload_1
    //   296: athrow
    //   297: aload 4
    //   299: areturn
    //   300: astore_1
    //   301: goto -30 -> 271
    //   304: astore_1
    //   305: goto -34 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	at
    //   0	308	1	paramString1	String
    //   0	308	2	paramString2	String
    //   0	308	3	paramInt	int
    //   4	294	4	arrayOfBasicHttpResponse	BasicHttpResponse[]
    //   27	218	5	arrayOfString	String[]
    //   84	96	6	localBasicLineParser	org.apache.http.message.BasicLineParser
    //   93	89	7	localDefaultHttpResponseFactory	org.apache.http.impl.DefaultHttpResponseFactory
    //   102	82	8	localBasicHttpParams	BasicHttpParams
    // Exception table:
    //   from	to	target	type
    //   171	259	270	org/apache/http/ParseException
    //   171	259	290	finally
    //   271	278	290	finally
    //   171	259	300	org/apache/http/HttpException
    //   171	259	304	java/io/IOException
  }
  
  /* Error */
  private BasicHttpResponse[] a(HttpRequestBase[] paramArrayOfHttpRequestBase)
  {
    // Byte code:
    //   0: aload_1
    //   1: arraylength
    //   2: ifne +5 -> 7
    //   5: aconst_null
    //   6: areturn
    //   7: aload_1
    //   8: arraylength
    //   9: bipush 50
    //   11: if_icmple +35 -> 46
    //   14: new 1123	java/lang/IllegalArgumentException
    //   17: dup
    //   18: new 84	java/lang/StringBuilder
    //   21: dup
    //   22: ldc_w 1239
    //   25: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: aload_1
    //   29: arraylength
    //   30: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: ldc_w 1241
    //   36: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokespecial 1130	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   45: athrow
    //   46: new 659	org/apache/http/client/methods/HttpPost
    //   49: dup
    //   50: ldc_w 1243
    //   53: iconst_4
    //   54: anewarray 363	java/lang/String
    //   57: dup
    //   58: iconst_0
    //   59: ldc_w 663
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: aload_0
    //   66: getfield 154	com/whatsapp/gdrive/at:q	Lcom/whatsapp/gdrive/at$d;
    //   69: getfield 654	com/whatsapp/gdrive/at$d:g	Ljava/lang/String;
    //   72: aastore
    //   73: dup
    //   74: iconst_2
    //   75: ldc_w 984
    //   78: aastore
    //   79: dup
    //   80: iconst_3
    //   81: getstatic 349	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   84: ldc_w 1245
    //   87: iconst_2
    //   88: anewarray 4	java/lang/Object
    //   91: dup
    //   92: iconst_0
    //   93: ldc_w 1247
    //   96: aastore
    //   97: dup
    //   98: iconst_1
    //   99: ldc_w 1249
    //   102: aastore
    //   103: invokestatic 367	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   106: aastore
    //   107: invokestatic 668	com/whatsapp/gdrive/ch:a	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   110: invokespecial 669	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   113: astore 10
    //   115: aload 10
    //   117: ldc_w 544
    //   120: new 84	java/lang/StringBuilder
    //   123: dup
    //   124: ldc_w 1251
    //   127: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   130: getstatic 107	com/whatsapp/gdrive/at:e	Ljava/lang/String;
    //   133: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: ldc_w 630
    //   139: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokevirtual 670	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: new 84	java/lang/StringBuilder
    //   151: dup
    //   152: new 84	java/lang/StringBuilder
    //   155: dup
    //   156: ldc_w 1253
    //   159: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   162: getstatic 107	com/whatsapp/gdrive/at:e	Ljava/lang/String;
    //   165: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc_w 1255
    //   171: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   180: astore 6
    //   182: aload_1
    //   183: arraylength
    //   184: istore 4
    //   186: iconst_0
    //   187: istore_2
    //   188: iload_2
    //   189: iload 4
    //   191: if_icmpge +195 -> 386
    //   194: aload_1
    //   195: iload_2
    //   196: aaload
    //   197: astore 7
    //   199: aload 6
    //   201: ldc_w 1257
    //   204: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 6
    //   210: ldc_w 1259
    //   213: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 6
    //   219: aload 7
    //   221: invokevirtual 1263	org/apache/http/client/methods/HttpRequestBase:getRequestLine	()Lorg/apache/http/RequestLine;
    //   224: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   227: ldc_w 1255
    //   230: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 7
    //   236: invokevirtual 1267	org/apache/http/client/methods/HttpRequestBase:getAllHeaders	()[Lorg/apache/http/Header;
    //   239: astore 8
    //   241: aload 8
    //   243: arraylength
    //   244: istore 5
    //   246: iconst_0
    //   247: istore_3
    //   248: iload_3
    //   249: iload 5
    //   251: if_icmpge +55 -> 306
    //   254: aload 8
    //   256: iload_3
    //   257: aaload
    //   258: astore 9
    //   260: aload 6
    //   262: getstatic 349	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   265: ldc_w 1269
    //   268: iconst_2
    //   269: anewarray 4	java/lang/Object
    //   272: dup
    //   273: iconst_0
    //   274: aload 9
    //   276: invokeinterface 1272 1 0
    //   281: aastore
    //   282: dup
    //   283: iconst_1
    //   284: aload 9
    //   286: invokeinterface 444 1 0
    //   291: aastore
    //   292: invokestatic 367	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   295: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: iload_3
    //   300: iconst_1
    //   301: iadd
    //   302: istore_3
    //   303: goto -55 -> 248
    //   306: aload 7
    //   308: instanceof 1274
    //   311: ifeq +33 -> 344
    //   314: aload 6
    //   316: ldc_w 1255
    //   319: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 7
    //   325: checkcast 1274	org/apache/http/client/methods/HttpEntityEnclosingRequestBase
    //   328: invokevirtual 1275	org/apache/http/client/methods/HttpEntityEnclosingRequestBase:getEntity	()Lorg/apache/http/HttpEntity;
    //   331: astore 7
    //   333: aload 6
    //   335: aload 7
    //   337: invokestatic 401	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   340: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload 6
    //   346: getstatic 349	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   349: ldc_w 1277
    //   352: iconst_1
    //   353: anewarray 4	java/lang/Object
    //   356: dup
    //   357: iconst_0
    //   358: getstatic 107	com/whatsapp/gdrive/at:e	Ljava/lang/String;
    //   361: aastore
    //   362: invokestatic 367	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   365: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: iload_2
    //   370: iconst_1
    //   371: iadd
    //   372: istore_2
    //   373: goto -185 -> 188
    //   376: astore_1
    //   377: ldc_w 1279
    //   380: aload_1
    //   381: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   384: aconst_null
    //   385: areturn
    //   386: aload 6
    //   388: ldc_w 1281
    //   391: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload 10
    //   397: new 681	org/apache/http/entity/StringEntity
    //   400: dup
    //   401: aload 6
    //   403: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   406: ldc_w 710
    //   409: invokespecial 712	org/apache/http/entity/StringEntity:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   412: invokevirtual 713	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   415: aload 10
    //   417: ldc_w 333
    //   420: new 84	java/lang/StringBuilder
    //   423: dup
    //   424: ldc_w 335
    //   427: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   430: aload_0
    //   431: getfield 337	com/whatsapp/gdrive/at:o	Ljava/lang/String;
    //   434: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokevirtual 670	org/apache/http/client/methods/HttpPost:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   443: aconst_null
    //   444: astore 9
    //   446: aconst_null
    //   447: astore 8
    //   449: aload 8
    //   451: astore 7
    //   453: aload 9
    //   455: astore 6
    //   457: aload_0
    //   458: aload 10
    //   460: invokespecial 375	com/whatsapp/gdrive/at:a	(Lorg/apache/http/client/methods/HttpRequestBase;)Lorg/apache/http/HttpResponse;
    //   463: astore 12
    //   465: aload 8
    //   467: astore 7
    //   469: aload 9
    //   471: astore 6
    //   473: aload 12
    //   475: invokeinterface 381 1 0
    //   480: astore 8
    //   482: aload 8
    //   484: ifnull +294 -> 778
    //   487: aload 8
    //   489: astore 7
    //   491: aload 8
    //   493: astore 6
    //   495: aload 8
    //   497: invokestatic 401	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   500: astore 9
    //   502: aload 8
    //   504: astore 7
    //   506: aload 8
    //   508: astore 6
    //   510: aload 12
    //   512: invokeinterface 390 1 0
    //   517: invokeinterface 396 1 0
    //   522: istore_2
    //   523: aload 8
    //   525: astore 7
    //   527: aload 8
    //   529: astore 6
    //   531: new 84	java/lang/StringBuilder
    //   534: dup
    //   535: ldc_w 1283
    //   538: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   541: iload_2
    //   542: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   545: ldc_w 720
    //   548: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload 12
    //   553: invokeinterface 390 1 0
    //   558: invokeinterface 723 1 0
    //   563: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   572: iload_2
    //   573: sipush 200
    //   576: if_icmpne +275 -> 851
    //   579: aconst_null
    //   580: astore 11
    //   582: aload 8
    //   584: astore 7
    //   586: aload 8
    //   588: astore 6
    //   590: aload 12
    //   592: ldc_w 544
    //   595: invokeinterface 1287 2 0
    //   600: astore 13
    //   602: aload 11
    //   604: astore 10
    //   606: aload 8
    //   608: astore 7
    //   610: aload 8
    //   612: astore 6
    //   614: aload 13
    //   616: invokeinterface 1291 1 0
    //   621: ifnull +104 -> 725
    //   624: aload 11
    //   626: astore 10
    //   628: aload 8
    //   630: astore 7
    //   632: aload 8
    //   634: astore 6
    //   636: aload 13
    //   638: invokeinterface 1291 1 0
    //   643: arraylength
    //   644: ifle +81 -> 725
    //   647: aload 8
    //   649: astore 7
    //   651: aload 8
    //   653: astore 6
    //   655: aload 13
    //   657: invokeinterface 1291 1 0
    //   662: iconst_0
    //   663: aaload
    //   664: astore 13
    //   666: aload 11
    //   668: astore 10
    //   670: aload 13
    //   672: ifnull +53 -> 725
    //   675: aload 11
    //   677: astore 10
    //   679: aload 8
    //   681: astore 7
    //   683: aload 8
    //   685: astore 6
    //   687: aload 13
    //   689: ldc_w 1293
    //   692: invokeinterface 1299 2 0
    //   697: ifnull +28 -> 725
    //   700: aload 8
    //   702: astore 7
    //   704: aload 8
    //   706: astore 6
    //   708: aload 13
    //   710: ldc_w 1293
    //   713: invokeinterface 1299 2 0
    //   718: invokeinterface 1302 1 0
    //   723: astore 10
    //   725: aload 10
    //   727: ifnonnull +57 -> 784
    //   730: aload 8
    //   732: astore 7
    //   734: aload 8
    //   736: astore 6
    //   738: ldc_w 1304
    //   741: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   744: aload 8
    //   746: astore 7
    //   748: aload 8
    //   750: astore 6
    //   752: aload 12
    //   754: invokestatic 492	com/whatsapp/gdrive/ch:a	(Lorg/apache/http/HttpResponse;)V
    //   757: aload 8
    //   759: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   762: pop
    //   763: aconst_null
    //   764: areturn
    //   765: astore 6
    //   767: ldc_w 1279
    //   770: aload 6
    //   772: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   775: goto -360 -> 415
    //   778: aconst_null
    //   779: astore 9
    //   781: goto -279 -> 502
    //   784: aload 9
    //   786: ifnonnull +38 -> 824
    //   789: aload 8
    //   791: astore 7
    //   793: aload 8
    //   795: astore 6
    //   797: ldc_w 1306
    //   800: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   803: aload 8
    //   805: astore 7
    //   807: aload 8
    //   809: astore 6
    //   811: aload 12
    //   813: invokestatic 492	com/whatsapp/gdrive/ch:a	(Lorg/apache/http/HttpResponse;)V
    //   816: aload 8
    //   818: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   821: pop
    //   822: aconst_null
    //   823: areturn
    //   824: aload 8
    //   826: astore 7
    //   828: aload 8
    //   830: astore 6
    //   832: aload_0
    //   833: aload 9
    //   835: aload 10
    //   837: aload_1
    //   838: arraylength
    //   839: invokespecial 1308	com/whatsapp/gdrive/at:a	(Ljava/lang/String;Ljava/lang/String;I)[Lorg/apache/http/message/BasicHttpResponse;
    //   842: astore_1
    //   843: aload 8
    //   845: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   848: pop
    //   849: aload_1
    //   850: areturn
    //   851: iload_2
    //   852: sipush 401
    //   855: if_icmpne +24 -> 879
    //   858: aload 8
    //   860: astore 7
    //   862: aload 8
    //   864: astore 6
    //   866: aload_0
    //   867: invokevirtual 423	com/whatsapp/gdrive/at:b	()Z
    //   870: pop
    //   871: aload 8
    //   873: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   876: pop
    //   877: aconst_null
    //   878: areturn
    //   879: aload 8
    //   881: astore 7
    //   883: aload 8
    //   885: astore 6
    //   887: new 84	java/lang/StringBuilder
    //   890: dup
    //   891: ldc_w 1310
    //   894: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   897: iload_2
    //   898: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   901: ldc_w 433
    //   904: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: aload 9
    //   909: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   915: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   918: aload 8
    //   920: astore 7
    //   922: aload 8
    //   924: astore 6
    //   926: new 648	com/whatsapp/gdrive/bg
    //   929: dup
    //   930: aload 9
    //   932: invokespecial 649	com/whatsapp/gdrive/bg:<init>	(Ljava/lang/String;)V
    //   935: athrow
    //   936: astore_1
    //   937: aload 7
    //   939: astore 6
    //   941: ldc_w 1279
    //   944: aload_1
    //   945: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   948: aload 7
    //   950: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   953: pop
    //   954: goto -77 -> 877
    //   957: astore_1
    //   958: aload 6
    //   960: invokestatic 417	com/whatsapp/gdrive/at:a	(Lorg/apache/http/HttpEntity;)Z
    //   963: pop
    //   964: aload_1
    //   965: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	966	0	this	at
    //   0	966	1	paramArrayOfHttpRequestBase	HttpRequestBase[]
    //   187	711	2	i1	int
    //   247	56	3	i2	int
    //   184	8	4	i3	int
    //   244	8	5	i4	int
    //   180	571	6	localObject1	Object
    //   765	6	6	localUnsupportedEncodingException	java.io.UnsupportedEncodingException
    //   795	164	6	localObject2	Object
    //   197	752	7	localObject3	Object
    //   239	684	8	localObject4	Object
    //   258	673	9	str	String
    //   113	723	10	localObject5	Object
    //   580	96	11	localObject6	Object
    //   463	349	12	localHttpResponse	HttpResponse
    //   600	109	13	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   333	344	376	java/io/IOException
    //   395	415	765	java/io/UnsupportedEncodingException
    //   457	465	936	java/io/IOException
    //   473	482	936	java/io/IOException
    //   495	502	936	java/io/IOException
    //   510	523	936	java/io/IOException
    //   531	572	936	java/io/IOException
    //   590	602	936	java/io/IOException
    //   614	624	936	java/io/IOException
    //   636	647	936	java/io/IOException
    //   655	666	936	java/io/IOException
    //   687	700	936	java/io/IOException
    //   708	725	936	java/io/IOException
    //   738	744	936	java/io/IOException
    //   752	757	936	java/io/IOException
    //   797	803	936	java/io/IOException
    //   811	816	936	java/io/IOException
    //   832	843	936	java/io/IOException
    //   866	871	936	java/io/IOException
    //   887	918	936	java/io/IOException
    //   926	936	936	java/io/IOException
    //   457	465	957	finally
    //   473	482	957	finally
    //   495	502	957	finally
    //   510	523	957	finally
    //   531	572	957	finally
    //   590	602	957	finally
    //   614	624	957	finally
    //   636	647	957	finally
    //   655	666	957	finally
    //   687	700	957	finally
    //   708	725	957	finally
    //   738	744	957	finally
    //   752	757	957	finally
    //   797	803	957	finally
    //   811	816	957	finally
    //   832	843	957	finally
    //   866	871	957	finally
    //   887	918	957	finally
    //   926	936	957	finally
    //   941	948	957	finally
  }
  
  private String b(String paramString)
  {
    return ch.a(String.format("https://www.googleapis.com/drive/v2/files/%s?alt=media", new Object[] { paramString }), new String[] { "mode", this.q.g, "spaces", String.format(Locale.ENGLISH, "%s,%s", new Object[] { "appDataFolder", "appContent" }) });
  }
  
  private String c(String paramString)
  {
    return "gdrive-ResumableUrl-" + this.l + "-" + paramString;
  }
  
  private boolean d(String paramString)
  {
    Log.d("gdrive-api/remove-uri " + paramString);
    SharedPreferences.Editor localEditor = g().edit();
    localEditor.remove(c(paramString));
    if (!localEditor.commit())
    {
      Log.w("gdrive-api/remove-resumable-uri unable to commit resumable uri to shared prefs.");
      return false;
    }
    return true;
  }
  
  private static boolean e(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new JSONObject(paramString);
        if ((!paramString.has("error")) || (paramString.getJSONObject("error").optInt("code", -1) != 403)) {
          continue;
        }
        paramString = paramString.getJSONObject("error").getJSONArray("errors");
        int i1 = 0;
        while (i1 < paramString.length())
        {
          boolean bool = "quotaExceeded".equals(paramString.getJSONObject(i1).optString("reason"));
          if (bool) {
            return true;
          }
          i1 += 1;
        }
        return false;
      }
      catch (JSONException paramString)
      {
        Log.d("gdrive-api/is-gdrive-full", paramString);
      }
    }
  }
  
  private String f()
  {
    Object localObject = com.whatsapp.util.dns.b.a().a("www.googleapis.com");
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      throw new IOException("gdrive-api/get-ip-for-googleapis/failed");
    }
    Log.d("gdrive-api/get-ip-for-googleapis " + TextUtils.join(" ", (Iterable)localObject));
    String str = null;
    Iterator localIterator = ((List)localObject).iterator();
    localObject = str;
    InetAddress localInetAddress;
    if (localIterator.hasNext())
    {
      localInetAddress = (InetAddress)localIterator.next();
      localObject = localInetAddress.getHostAddress();
      if (!(localInetAddress instanceof Inet6Address)) {
        break label158;
      }
      if (System.currentTimeMillis() - this.n <= 600000L) {
        break label198;
      }
      localObject = "[" + (String)localObject + "]";
    }
    label158:
    while ((localInetAddress instanceof Inet4Address))
    {
      if (localObject != null) {
        break;
      }
      throw new IOException("No IP found for www.googleapis.com");
    }
    throw new IllegalStateException("We have an InetAddress which is neither IPv4 and nor IPv6: " + localInetAddress.getHostAddress());
    label198:
    if (str == null) {
      str = "[" + (String)localObject + "]";
    }
    for (;;)
    {
      break;
      this.a.add(localObject);
      return (String)localObject;
    }
  }
  
  private SharedPreferences g()
  {
    if (this.p == null) {
      this.p = u.a().getSharedPreferences("com.whatsapp_preferences", 0);
    }
    return this.p;
  }
  
  public final bb a(String paramString1, File paramFile, String paramString2, String paramString3, boolean paramBoolean, b paramb, ev paramev)
  {
    if (!paramFile.exists())
    {
      Log.e("gdrive-api/upload-file file " + paramFile.getAbsolutePath() + " does not exist.");
      throw new FileNotFoundException("file " + paramFile.getAbsolutePath() + " does not exist.");
    }
    Pair localPair = a(paramFile, paramString2, paramev);
    if (localPair == null)
    {
      Log.i("gdrive-api/upload-file/error-while-fetching-previous-upload-session");
      return null;
    }
    long l1;
    if (localPair.first != null)
    {
      paramString1 = (String)localPair.first;
      l1 = ((Long)localPair.second).longValue();
      paramb.a(l1);
      if (this.r == null) {
        break label252;
      }
      this.r.a(paramFile.length());
    }
    label252:
    for (;;)
    {
      try
      {
        paramString1 = a(paramFile, paramString2, paramb, paramev, paramString1, l1);
        return paramString1;
      }
      catch (FileNotFoundException paramString1)
      {
        if ((!this.t.a(paramFile)) || (this.u.b())) {
          continue;
        }
        Log.d("gdrive-api/upload-file/missing-read-external-storage-permission/ " + paramFile, paramString1);
        throw new a(paramString1);
        throw paramString1;
      }
      paramString1 = a(paramString1, paramFile, paramString2, paramev, paramString3, paramBoolean);
      if (paramString1 == null)
      {
        Log.i("gdrive-api/upload-file/error-creating-new-session");
        return null;
      }
      l1 = 0L;
    }
  }
  
  /* Error */
  public final bb a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 84	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 1474
    //   7: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc_w 1476
    //   17: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   26: ldc_w 1478
    //   29: iconst_4
    //   30: anewarray 363	java/lang/String
    //   33: dup
    //   34: iconst_0
    //   35: ldc_w 663
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: aload_0
    //   42: getfield 154	com/whatsapp/gdrive/at:q	Lcom/whatsapp/gdrive/at$d;
    //   45: getfield 654	com/whatsapp/gdrive/at$d:g	Ljava/lang/String;
    //   48: aastore
    //   49: dup
    //   50: iconst_2
    //   51: ldc_w 665
    //   54: aastore
    //   55: dup
    //   56: iconst_3
    //   57: iconst_1
    //   58: invokestatic 657	com/whatsapp/gdrive/bb:a	(Z)Ljava/lang/String;
    //   61: aastore
    //   62: invokestatic 668	com/whatsapp/gdrive/ch:a	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   65: astore 4
    //   67: new 84	java/lang/StringBuilder
    //   70: dup
    //   71: ldc_w 1480
    //   74: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: getstatic 107	com/whatsapp/gdrive/at:e	Ljava/lang/String;
    //   80: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 1255
    //   86: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore 5
    //   94: new 84	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 1481	java/lang/StringBuilder:<init>	()V
    //   101: aload 5
    //   103: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc_w 1483
    //   109: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: astore 5
    //   117: new 84	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 1481	java/lang/StringBuilder:<init>	()V
    //   124: aload 5
    //   126: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: new 593	org/json/JSONObject
    //   132: dup
    //   133: invokespecial 682	org/json/JSONObject:<init>	()V
    //   136: ldc_w 684
    //   139: aload_1
    //   140: invokevirtual 688	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   143: ldc_w 690
    //   146: new 692	org/json/JSONArray
    //   149: dup
    //   150: invokespecial 693	org/json/JSONArray:<init>	()V
    //   153: new 593	org/json/JSONObject
    //   156: dup
    //   157: invokespecial 682	org/json/JSONObject:<init>	()V
    //   160: ldc_w 695
    //   163: ldc_w 697
    //   166: invokevirtual 688	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   169: ldc_w 699
    //   172: aload_2
    //   173: invokevirtual 688	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   176: invokevirtual 702	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   179: invokevirtual 688	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   182: ldc_w 1485
    //   185: ldc_w 1487
    //   188: invokevirtual 688	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   191: invokevirtual 708	org/json/JSONObject:toString	()Ljava/lang/String;
    //   194: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: astore_1
    //   201: new 84	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 1481	java/lang/StringBuilder:<init>	()V
    //   208: aload_1
    //   209: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc_w 1480
    //   215: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: getstatic 107	com/whatsapp/gdrive/at:e	Ljava/lang/String;
    //   221: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: ldc_w 1188
    //   227: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: astore 5
    //   235: new 84	java/lang/StringBuilder
    //   238: dup
    //   239: ldc_w 1489
    //   242: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   245: aload 5
    //   247: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   256: aload_0
    //   257: aload 4
    //   259: ldc_w 1491
    //   262: new 84	java/lang/StringBuilder
    //   265: dup
    //   266: ldc_w 1493
    //   269: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   272: getstatic 107	com/whatsapp/gdrive/at:e	Ljava/lang/String;
    //   275: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc_w 630
    //   281: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: iconst_1
    //   288: invokespecial 823	com/whatsapp/gdrive/at:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/net/HttpURLConnection;
    //   291: astore_2
    //   292: aload_2
    //   293: astore_1
    //   294: aload_2
    //   295: aload 5
    //   297: ldc_w 1495
    //   300: invokevirtual 1498	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   303: arraylength
    //   304: invokevirtual 1501	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   307: aload_2
    //   308: astore_1
    //   309: aload_2
    //   310: invokevirtual 1505	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   313: aload 5
    //   315: ldc_w 1495
    //   318: invokevirtual 1498	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   321: invokevirtual 1507	java/io/OutputStream:write	([B)V
    //   324: aload_2
    //   325: astore_1
    //   326: aload_2
    //   327: invokevirtual 828	java/net/HttpURLConnection:connect	()V
    //   330: aload_2
    //   331: astore_1
    //   332: aload_2
    //   333: invokevirtual 831	java/net/HttpURLConnection:getResponseCode	()I
    //   336: istore_3
    //   337: aload_2
    //   338: astore_1
    //   339: new 84	java/lang/StringBuilder
    //   342: dup
    //   343: ldc_w 1509
    //   346: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   349: iload_3
    //   350: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   353: ldc_w 720
    //   356: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload_2
    //   360: invokevirtual 836	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   363: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   372: iload_3
    //   373: sipush 200
    //   376: if_icmpne +88 -> 464
    //   379: aload_2
    //   380: astore_1
    //   381: aload_2
    //   382: invokevirtual 844	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   385: invokestatic 943	com/whatsapp/gdrive/ch:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   388: astore 4
    //   390: aload_2
    //   391: astore_1
    //   392: new 84	java/lang/StringBuilder
    //   395: dup
    //   396: ldc_w 1511
    //   399: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   402: aload 4
    //   404: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   413: aload_2
    //   414: astore_1
    //   415: new 593	org/json/JSONObject
    //   418: dup
    //   419: aload 4
    //   421: invokespecial 594	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   424: invokestatic 1514	com/whatsapp/gdrive/bb:a	(Lorg/json/JSONObject;)Lcom/whatsapp/gdrive/bb;
    //   427: astore 4
    //   429: aload_2
    //   430: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   433: aload 4
    //   435: areturn
    //   436: astore_1
    //   437: ldc_w 1516
    //   440: aload_1
    //   441: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   444: aconst_null
    //   445: areturn
    //   446: astore 4
    //   448: aload_2
    //   449: astore_1
    //   450: ldc_w 1516
    //   453: aload 4
    //   455: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   458: aload_2
    //   459: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   462: aconst_null
    //   463: areturn
    //   464: iload_3
    //   465: sipush 401
    //   468: if_icmpne +92 -> 560
    //   471: aload_2
    //   472: astore_1
    //   473: aload_0
    //   474: invokevirtual 423	com/whatsapp/gdrive/at:b	()Z
    //   477: pop
    //   478: goto -20 -> 458
    //   481: astore 4
    //   483: aload_2
    //   484: astore_1
    //   485: ldc_w 1516
    //   488: aload 4
    //   490: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   493: aload_2
    //   494: astore_1
    //   495: aload_2
    //   496: aload 4
    //   498: invokestatic 908	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;Ljava/io/IOException;)Z
    //   501: ifeq +53 -> 554
    //   504: aload_2
    //   505: astore_1
    //   506: new 84	java/lang/StringBuilder
    //   509: dup
    //   510: ldc_w 1518
    //   513: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   516: astore 5
    //   518: aload_2
    //   519: ifnull +136 -> 655
    //   522: aload_2
    //   523: astore_1
    //   524: aload_2
    //   525: invokevirtual 914	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   528: astore 4
    //   530: aload_2
    //   531: astore_1
    //   532: aload 5
    //   534: aload 4
    //   536: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   539: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   545: aload_2
    //   546: astore_1
    //   547: aload_0
    //   548: invokestatic 917	java/lang/System:currentTimeMillis	()J
    //   551: putfield 919	com/whatsapp/gdrive/at:n	J
    //   554: aload_2
    //   555: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   558: aconst_null
    //   559: areturn
    //   560: aload_2
    //   561: astore_1
    //   562: aload_2
    //   563: invokevirtual 940	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   566: invokestatic 943	com/whatsapp/gdrive/ch:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   569: astore 4
    //   571: aload_2
    //   572: astore_1
    //   573: new 84	java/lang/StringBuilder
    //   576: dup
    //   577: ldc_w 1520
    //   580: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   583: iload_3
    //   584: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   587: ldc_w 1522
    //   590: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: aload 4
    //   595: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   604: aload_2
    //   605: astore_1
    //   606: new 648	com/whatsapp/gdrive/bg
    //   609: dup
    //   610: new 84	java/lang/StringBuilder
    //   613: dup
    //   614: ldc_w 1524
    //   617: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   620: iload_3
    //   621: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   624: ldc_w 1522
    //   627: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: aload 4
    //   632: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokespecial 649	com/whatsapp/gdrive/bg:<init>	(Ljava/lang/String;)V
    //   641: athrow
    //   642: astore 4
    //   644: aload_1
    //   645: astore_2
    //   646: aload 4
    //   648: astore_1
    //   649: aload_2
    //   650: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   653: aload_1
    //   654: athrow
    //   655: aconst_null
    //   656: astore 4
    //   658: goto -128 -> 530
    //   661: astore_1
    //   662: aconst_null
    //   663: astore_2
    //   664: goto -15 -> 649
    //   667: astore 4
    //   669: aconst_null
    //   670: astore_2
    //   671: goto -188 -> 483
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	674	0	this	at
    //   0	674	1	paramString1	String
    //   0	674	2	paramString2	String
    //   336	285	3	i1	int
    //   65	369	4	localObject1	Object
    //   446	8	4	localJSONException	JSONException
    //   481	16	4	localIOException1	IOException
    //   528	103	4	localObject2	Object
    //   642	5	4	localObject3	Object
    //   656	1	4	localObject4	Object
    //   667	1	4	localIOException2	IOException
    //   92	441	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   67	235	436	org/json/JSONException
    //   415	429	446	org/json/JSONException
    //   294	307	481	java/io/IOException
    //   309	324	481	java/io/IOException
    //   326	330	481	java/io/IOException
    //   332	337	481	java/io/IOException
    //   339	372	481	java/io/IOException
    //   381	390	481	java/io/IOException
    //   392	413	481	java/io/IOException
    //   415	429	481	java/io/IOException
    //   450	458	481	java/io/IOException
    //   473	478	481	java/io/IOException
    //   562	571	481	java/io/IOException
    //   573	604	481	java/io/IOException
    //   606	642	481	java/io/IOException
    //   294	307	642	finally
    //   309	324	642	finally
    //   326	330	642	finally
    //   332	337	642	finally
    //   339	372	642	finally
    //   381	390	642	finally
    //   392	413	642	finally
    //   415	429	642	finally
    //   450	458	642	finally
    //   473	478	642	finally
    //   485	493	642	finally
    //   495	504	642	finally
    //   506	518	642	finally
    //   524	530	642	finally
    //   532	545	642	finally
    //   547	554	642	finally
    //   562	571	642	finally
    //   573	604	642	finally
    //   606	642	642	finally
    //   256	292	661	finally
    //   256	292	667	java/io/IOException
  }
  
  /* Error */
  public final bb a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 1150	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore 5
    //   6: ldc_w 1140
    //   9: iconst_1
    //   10: anewarray 4	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: aload 5
    //   17: aastore
    //   18: invokestatic 1153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   21: bipush 6
    //   23: anewarray 363	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: ldc_w 663
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: aload_0
    //   35: getfield 154	com/whatsapp/gdrive/at:q	Lcom/whatsapp/gdrive/at$d;
    //   38: getfield 654	com/whatsapp/gdrive/at$d:g	Ljava/lang/String;
    //   41: aastore
    //   42: dup
    //   43: iconst_2
    //   44: ldc_w 984
    //   47: aastore
    //   48: dup
    //   49: iconst_3
    //   50: aload_2
    //   51: aastore
    //   52: dup
    //   53: iconst_4
    //   54: ldc_w 665
    //   57: aastore
    //   58: dup
    //   59: iconst_5
    //   60: iload_3
    //   61: invokestatic 657	com/whatsapp/gdrive/bb:a	(Z)Ljava/lang/String;
    //   64: aastore
    //   65: invokestatic 668	com/whatsapp/gdrive/ch:a	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   68: astore_1
    //   69: new 84	java/lang/StringBuilder
    //   72: dup
    //   73: ldc_w 1527
    //   76: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   79: aload_1
    //   80: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   89: aload_0
    //   90: aload_1
    //   91: ldc_w 821
    //   94: aconst_null
    //   95: iconst_0
    //   96: invokespecial 823	com/whatsapp/gdrive/at:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/net/HttpURLConnection;
    //   99: astore_2
    //   100: aload_2
    //   101: astore_1
    //   102: aload_2
    //   103: invokevirtual 831	java/net/HttpURLConnection:getResponseCode	()I
    //   106: istore 4
    //   108: iload 4
    //   110: sipush 401
    //   113: if_icmpne +28 -> 141
    //   116: aload_2
    //   117: astore_1
    //   118: ldc_w 1529
    //   121: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   124: aload_2
    //   125: astore_1
    //   126: aload_0
    //   127: invokevirtual 423	com/whatsapp/gdrive/at:b	()Z
    //   130: pop
    //   131: aload_2
    //   132: ifnull +7 -> 139
    //   135: aload_2
    //   136: invokevirtual 928	java/net/HttpURLConnection:disconnect	()V
    //   139: aconst_null
    //   140: areturn
    //   141: iload 4
    //   143: sipush 404
    //   146: if_icmpne +153 -> 299
    //   149: aload_2
    //   150: astore_1
    //   151: new 84	java/lang/StringBuilder
    //   154: dup
    //   155: ldc_w 1531
    //   158: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload 5
    //   163: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc_w 1533
    //   169: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   178: aload_2
    //   179: astore_1
    //   180: new 84	java/lang/StringBuilder
    //   183: dup
    //   184: ldc_w 1535
    //   187: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   190: aload_2
    //   191: invokevirtual 940	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   194: invokestatic 943	com/whatsapp/gdrive/ch:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   197: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   206: aload_2
    //   207: astore_1
    //   208: new 1166	com/whatsapp/gdrive/be
    //   211: dup
    //   212: invokespecial 1167	com/whatsapp/gdrive/be:<init>	()V
    //   215: athrow
    //   216: astore 5
    //   218: aload_2
    //   219: astore_1
    //   220: ldc_w 1537
    //   223: aload 5
    //   225: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   228: aload_2
    //   229: astore_1
    //   230: aload_2
    //   231: aload 5
    //   233: invokestatic 908	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;Ljava/io/IOException;)Z
    //   236: ifeq +53 -> 289
    //   239: aload_2
    //   240: astore_1
    //   241: new 84	java/lang/StringBuilder
    //   244: dup
    //   245: ldc_w 1539
    //   248: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   251: astore 6
    //   253: aload_2
    //   254: ifnull +200 -> 454
    //   257: aload_2
    //   258: astore_1
    //   259: aload_2
    //   260: invokevirtual 914	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   263: astore 5
    //   265: aload_2
    //   266: astore_1
    //   267: aload 6
    //   269: aload 5
    //   271: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   280: aload_2
    //   281: astore_1
    //   282: aload_0
    //   283: invokestatic 917	java/lang/System:currentTimeMillis	()J
    //   286: putfield 919	com/whatsapp/gdrive/at:n	J
    //   289: aload_2
    //   290: ifnull -151 -> 139
    //   293: aload_2
    //   294: invokevirtual 928	java/net/HttpURLConnection:disconnect	()V
    //   297: aconst_null
    //   298: areturn
    //   299: iload 4
    //   301: sipush 200
    //   304: if_icmpne +59 -> 363
    //   307: aload_2
    //   308: astore_1
    //   309: new 838	com/google/a/b/a
    //   312: dup
    //   313: new 840	java/io/InputStreamReader
    //   316: dup
    //   317: aload_2
    //   318: invokevirtual 844	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   321: invokespecial 847	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   324: invokespecial 850	com/google/a/b/a:<init>	(Ljava/io/Reader;)V
    //   327: astore 5
    //   329: aload_2
    //   330: astore_1
    //   331: aload 5
    //   333: invokevirtual 857	com/google/a/b/a:c	()V
    //   336: aload_2
    //   337: astore_1
    //   338: aload 5
    //   340: invokestatic 896	com/whatsapp/gdrive/bb:a	(Lcom/google/a/b/a;)Lcom/whatsapp/gdrive/bb;
    //   343: astore 6
    //   345: aload_2
    //   346: astore_1
    //   347: aload 5
    //   349: invokevirtual 903	com/google/a/b/a:d	()V
    //   352: aload_2
    //   353: ifnull +7 -> 360
    //   356: aload_2
    //   357: invokevirtual 928	java/net/HttpURLConnection:disconnect	()V
    //   360: aload 6
    //   362: areturn
    //   363: aload_2
    //   364: astore_1
    //   365: new 84	java/lang/StringBuilder
    //   368: dup
    //   369: ldc_w 1541
    //   372: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   375: iload 4
    //   377: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   380: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   386: aload_2
    //   387: astore_1
    //   388: invokestatic 1542	com/whatsapp/gdrive/ch:b	()V
    //   391: aload_2
    //   392: astore_1
    //   393: aload_2
    //   394: invokevirtual 940	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   397: invokestatic 943	com/whatsapp/gdrive/ch:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   400: astore 5
    //   402: aload_2
    //   403: astore_1
    //   404: new 84	java/lang/StringBuilder
    //   407: dup
    //   408: ldc_w 1535
    //   411: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   414: aload 5
    //   416: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   425: aload_2
    //   426: astore_1
    //   427: new 648	com/whatsapp/gdrive/bg
    //   430: dup
    //   431: aload 5
    //   433: invokespecial 649	com/whatsapp/gdrive/bg:<init>	(Ljava/lang/String;)V
    //   436: athrow
    //   437: astore 5
    //   439: aload_1
    //   440: astore_2
    //   441: aload 5
    //   443: astore_1
    //   444: aload_2
    //   445: ifnull +7 -> 452
    //   448: aload_2
    //   449: invokevirtual 928	java/net/HttpURLConnection:disconnect	()V
    //   452: aload_1
    //   453: athrow
    //   454: aconst_null
    //   455: astore 5
    //   457: goto -192 -> 265
    //   460: astore_1
    //   461: aconst_null
    //   462: astore_2
    //   463: goto -19 -> 444
    //   466: astore 5
    //   468: aconst_null
    //   469: astore_2
    //   470: goto -252 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	473	0	this	at
    //   0	473	1	paramString1	String
    //   0	473	2	paramString2	String
    //   0	473	3	paramBoolean	boolean
    //   106	270	4	i1	int
    //   4	158	5	str	String
    //   216	16	5	localIOException1	IOException
    //   263	169	5	localObject1	Object
    //   437	5	5	localObject2	Object
    //   455	1	5	localObject3	Object
    //   466	1	5	localIOException2	IOException
    //   251	110	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   102	108	216	java/io/IOException
    //   118	124	216	java/io/IOException
    //   126	131	216	java/io/IOException
    //   151	178	216	java/io/IOException
    //   180	206	216	java/io/IOException
    //   208	216	216	java/io/IOException
    //   309	329	216	java/io/IOException
    //   331	336	216	java/io/IOException
    //   338	345	216	java/io/IOException
    //   347	352	216	java/io/IOException
    //   365	386	216	java/io/IOException
    //   388	391	216	java/io/IOException
    //   393	402	216	java/io/IOException
    //   404	425	216	java/io/IOException
    //   427	437	216	java/io/IOException
    //   102	108	437	finally
    //   118	124	437	finally
    //   126	131	437	finally
    //   151	178	437	finally
    //   180	206	437	finally
    //   208	216	437	finally
    //   220	228	437	finally
    //   230	239	437	finally
    //   241	253	437	finally
    //   259	265	437	finally
    //   267	280	437	finally
    //   282	289	437	finally
    //   309	329	437	finally
    //   331	336	437	finally
    //   338	345	437	finally
    //   347	352	437	finally
    //   365	386	437	finally
    //   388	391	437	finally
    //   393	402	437	finally
    //   404	425	437	finally
    //   427	437	437	finally
    //   89	100	460	finally
    //   89	100	466	java/io/IOException
  }
  
  public final List<bb> a(String paramString, ev paramev)
  {
    return a(new String[] { paramString }, paramev);
  }
  
  public final List<bb> a(String paramString1, String paramString2, String paramString3, ev paramev, boolean paramBoolean)
  {
    String str = paramString2.replace("'", "");
    paramString2 = paramString1.replace("'", "");
    if ((!"appDataFolder".equals(paramString3)) && (!"appContent".equals(paramString3))) {
      throw new IllegalArgumentException("Unexpected space name: " + paramString3);
    }
    paramString1 = paramString2;
    if ("appDataFolder".equals(paramString2)) {
      paramString1 = "appfolder";
    }
    paramString1 = String.format(Locale.ENGLISH, "title = '%s' and '%s' in parents", new Object[] { str, paramString1 });
    try
    {
      paramString2 = a(paramString1, paramBoolean, paramString3, paramev);
      paramString1 = paramString2;
      if (paramString2 != null)
      {
        Collections.sort(paramString2, b);
        paramString3 = paramString2.iterator();
        for (;;)
        {
          paramString1 = paramString2;
          if (!paramString3.hasNext()) {
            break;
          }
          paramString3.next();
        }
      }
      return paramString1;
    }
    catch (InterruptedException paramString1)
    {
      Log.i("gdrive-api/get-files/interrupted");
      paramString1 = null;
    }
  }
  
  public final List<bb> a(List<String> paramList, String paramString, ev paramev)
  {
    if ((!"appDataFolder".equals(paramString)) && (!"appContent".equals(paramString))) {
      throw new IllegalArgumentException("Unexpected space name: " + paramString);
    }
    String[] arrayOfString = new String[paramList.size()];
    int i1 = 0;
    while (i1 < paramList.size())
    {
      arrayOfString[i1] = String.format(Locale.ENGLISH, "title = '%s'", new Object[] { ((String)paramList.get(i1)).replace("'", "") });
      i1 += 1;
    }
    paramList = TextUtils.join(" or ", arrayOfString);
    try
    {
      paramString = a(paramList, true, paramString, paramev);
      paramList = paramString;
      if (paramString != null)
      {
        Collections.sort(paramString, b);
        paramev = paramString.iterator();
        for (;;)
        {
          paramList = paramString;
          if (!paramev.hasNext()) {
            break;
          }
          paramev.next();
        }
      }
      return paramList;
    }
    catch (InterruptedException paramList)
    {
      Log.i("gdrive-api/get-files/interrupted");
      paramList = null;
    }
  }
  
  public final List<bb> a(String[] paramArrayOfString, ev paramev)
  {
    Log.i("gdrive-api/list-files/" + TextUtils.join(",", paramArrayOfString));
    Object localObject = new String[paramArrayOfString.length];
    int i1 = 0;
    while (i1 < paramArrayOfString.length)
    {
      if ("appDataFolder".equals(paramArrayOfString[i1])) {
        paramArrayOfString[i1] = "appfolder";
      }
      localObject[i1] = String.format(Locale.ENGLISH, "'%s' in parents", new Object[] { paramArrayOfString[i1].replace("'", "") });
      i1 += 1;
    }
    paramArrayOfString = TextUtils.join(" or ", (Object[])localObject);
    localObject = String.format("%s,%s", new Object[] { "appDataFolder", "appContent" });
    try
    {
      paramArrayOfString = a(paramArrayOfString, false, (String)localObject, paramev);
      return paramArrayOfString;
    }
    catch (InterruptedException paramArrayOfString)
    {
      Log.i("gdrive-api/list-files/interrupted");
    }
    return null;
  }
  
  public final void a(ex paramex)
  {
    this.i.a = 0;
    this.k.set(0);
    this.r = paramex;
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.m != paramBoolean) {
      if (!paramBoolean) {
        break label26;
      }
    }
    label26:
    for (String str = "gdrive-api/enabled";; str = "gdrive-api/disabled")
    {
      Log.i(str);
      this.m = paramBoolean;
      return;
    }
  }
  
  public final boolean a()
  {
    return !this.m;
  }
  
  /* Error */
  public final boolean a(File paramFile, bb parambb, a parama, ev paramev)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: getfield 1145	com/whatsapp/gdrive/bb:c	Ljava/lang/String;
    //   5: invokespecial 1597	com/whatsapp/gdrive/at:b	(Ljava/lang/String;)Ljava/lang/String;
    //   8: astore 11
    //   10: new 84	java/lang/StringBuilder
    //   13: dup
    //   14: ldc_w 1599
    //   17: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   20: aload 11
    //   22: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc_w 1601
    //   28: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_1
    //   32: invokevirtual 520	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   35: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   44: aload_2
    //   45: getfield 1603	com/whatsapp/gdrive/bb:f	Ljava/lang/String;
    //   48: ifnonnull +19 -> 67
    //   51: ldc_w 1605
    //   54: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   57: iconst_0
    //   58: istore 5
    //   60: iload 5
    //   62: ifne +130 -> 192
    //   65: iconst_0
    //   66: ireturn
    //   67: aload_2
    //   68: getfield 636	com/whatsapp/gdrive/bb:a	J
    //   71: lconst_0
    //   72: lcmp
    //   73: ifge +15 -> 88
    //   76: ldc_w 1607
    //   79: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   82: iconst_0
    //   83: istore 5
    //   85: goto -25 -> 60
    //   88: aload_1
    //   89: invokevirtual 1425	java/io/File:exists	()Z
    //   92: ifeq +42 -> 134
    //   95: aload_1
    //   96: invokevirtual 588	java/io/File:isDirectory	()Z
    //   99: ifeq +35 -> 134
    //   102: new 84	java/lang/StringBuilder
    //   105: dup
    //   106: ldc_w 1599
    //   109: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: aload_1
    //   113: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   116: ldc_w 1609
    //   119: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   128: iconst_0
    //   129: istore 5
    //   131: goto -71 -> 60
    //   134: aload_1
    //   135: invokevirtual 1613	java/io/File:getParentFile	()Ljava/io/File;
    //   138: astore 11
    //   140: aload 11
    //   142: invokevirtual 1425	java/io/File:exists	()Z
    //   145: ifne +41 -> 186
    //   148: aload 11
    //   150: invokevirtual 1616	java/io/File:mkdirs	()Z
    //   153: ifne +33 -> 186
    //   156: new 84	java/lang/StringBuilder
    //   159: dup
    //   160: ldc_w 1618
    //   163: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   166: aload 11
    //   168: invokevirtual 520	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   171: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   180: iconst_0
    //   181: istore 5
    //   183: goto -123 -> 60
    //   186: iconst_1
    //   187: istore 5
    //   189: goto -129 -> 60
    //   192: new 353	java/io/File
    //   195: dup
    //   196: aload_1
    //   197: invokevirtual 1613	java/io/File:getParentFile	()Ljava/io/File;
    //   200: new 84	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 1481	java/lang/StringBuilder:<init>	()V
    //   207: aload_1
    //   208: invokevirtual 1619	java/io/File:getName	()Ljava/lang/String;
    //   211: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc_w 1621
    //   217: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokespecial 1624	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   226: astore 12
    //   228: aload 12
    //   230: invokevirtual 1425	java/io/File:exists	()Z
    //   233: ifeq +221 -> 454
    //   236: aload 12
    //   238: invokevirtual 357	java/io/File:length	()J
    //   241: lstore 6
    //   243: aload_2
    //   244: getfield 636	com/whatsapp/gdrive/bb:a	J
    //   247: lstore 8
    //   249: lload 6
    //   251: lload 8
    //   253: lcmp
    //   254: ifle +172 -> 426
    //   257: new 84	java/lang/StringBuilder
    //   260: dup
    //   261: ldc_w 1626
    //   264: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   267: aload 12
    //   269: invokevirtual 520	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   272: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: ldc_w 1628
    //   278: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: lload 6
    //   283: invokevirtual 473	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   286: ldc_w 1630
    //   289: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_2
    //   293: invokevirtual 1631	com/whatsapp/gdrive/bb:toString	()Ljava/lang/String;
    //   296: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   305: iconst_0
    //   306: istore 10
    //   308: iload 10
    //   310: ifne +176 -> 486
    //   313: aload 12
    //   315: invokestatic 1632	com/whatsapp/gdrive/at:a	(Ljava/io/File;)Z
    //   318: ifeq +142 -> 460
    //   321: new 84	java/lang/StringBuilder
    //   324: dup
    //   325: ldc_w 1634
    //   328: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   331: aload 12
    //   333: invokevirtual 520	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   336: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   345: aload 12
    //   347: invokevirtual 357	java/io/File:length	()J
    //   350: lstore 6
    //   352: lload 6
    //   354: aload_2
    //   355: getfield 636	com/whatsapp/gdrive/bb:a	J
    //   358: lcmp
    //   359: ifne +144 -> 503
    //   362: aload 12
    //   364: aload_1
    //   365: invokevirtual 1637	java/io/File:renameTo	(Ljava/io/File;)Z
    //   368: ifne +127 -> 495
    //   371: new 84	java/lang/StringBuilder
    //   374: dup
    //   375: ldc_w 1639
    //   378: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   381: aload 12
    //   383: invokevirtual 520	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   386: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: ldc_w 1641
    //   392: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload_1
    //   396: invokevirtual 520	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   399: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   408: iconst_0
    //   409: istore 5
    //   411: iload 5
    //   413: ifeq +88 -> 501
    //   416: aload_3
    //   417: lload 6
    //   419: invokeinterface 1084 3 0
    //   424: iconst_1
    //   425: ireturn
    //   426: lload 6
    //   428: lload 8
    //   430: lcmp
    //   431: ifne +23 -> 454
    //   434: aload_0
    //   435: aload 12
    //   437: aload 12
    //   439: invokevirtual 357	java/io/File:length	()J
    //   442: aload_2
    //   443: getfield 1603	com/whatsapp/gdrive/bb:f	Ljava/lang/String;
    //   446: invokespecial 466	com/whatsapp/gdrive/at:a	(Ljava/io/File;JLjava/lang/String;)Z
    //   449: istore 10
    //   451: goto -143 -> 308
    //   454: iconst_1
    //   455: istore 10
    //   457: goto -149 -> 308
    //   460: new 84	java/lang/StringBuilder
    //   463: dup
    //   464: ldc_w 1643
    //   467: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   470: aload 12
    //   472: invokevirtual 520	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   475: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   484: iconst_0
    //   485: ireturn
    //   486: aload 12
    //   488: invokevirtual 357	java/io/File:length	()J
    //   491: pop2
    //   492: goto -147 -> 345
    //   495: iconst_1
    //   496: istore 5
    //   498: goto -87 -> 411
    //   501: iconst_0
    //   502: ireturn
    //   503: aload_3
    //   504: lload 6
    //   506: invokeinterface 1084 3 0
    //   511: aload 4
    //   513: invokevirtual 372	com/whatsapp/gdrive/ev:a	()Z
    //   516: ifne +11 -> 527
    //   519: ldc_w 1645
    //   522: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   525: iconst_0
    //   526: ireturn
    //   527: aload_0
    //   528: aload_0
    //   529: aload_2
    //   530: getfield 1145	com/whatsapp/gdrive/bb:c	Ljava/lang/String;
    //   533: invokespecial 1597	com/whatsapp/gdrive/at:b	(Ljava/lang/String;)Ljava/lang/String;
    //   536: ldc_w 821
    //   539: aconst_null
    //   540: iconst_0
    //   541: invokespecial 823	com/whatsapp/gdrive/at:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/net/HttpURLConnection;
    //   544: astore 11
    //   546: lload 6
    //   548: lconst_0
    //   549: lcmp
    //   550: ifle +32 -> 582
    //   553: aload 11
    //   555: ldc_w 425
    //   558: getstatic 349	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   561: ldc_w 1647
    //   564: iconst_1
    //   565: anewarray 4	java/lang/Object
    //   568: dup
    //   569: iconst_0
    //   570: lload 6
    //   572: invokestatic 361	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   575: aastore
    //   576: invokestatic 367	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   579: invokevirtual 1648	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   582: aload 11
    //   584: invokevirtual 831	java/net/HttpURLConnection:getResponseCode	()I
    //   587: istore 5
    //   589: iload 5
    //   591: sipush 200
    //   594: if_icmpeq +11 -> 605
    //   597: iload 5
    //   599: sipush 206
    //   602: if_icmpne +293 -> 895
    //   605: new 84	java/lang/StringBuilder
    //   608: dup
    //   609: ldc_w 1650
    //   612: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   615: aload 12
    //   617: invokevirtual 520	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   620: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: ldc_w 1652
    //   626: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: aload 11
    //   631: ldc_w 1654
    //   634: invokevirtual 1657	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   637: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   643: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   646: aload_0
    //   647: aload 11
    //   649: aload 12
    //   651: aload_3
    //   652: aload 4
    //   654: invokespecial 1659	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;Ljava/io/File;Lcom/whatsapp/gdrive/at$a;Lcom/whatsapp/gdrive/ev;)V
    //   657: new 84	java/lang/StringBuilder
    //   660: dup
    //   661: ldc_w 1661
    //   664: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   667: aload 12
    //   669: invokevirtual 520	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   672: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: ldc_w 1663
    //   678: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload 12
    //   683: invokevirtual 357	java/io/File:length	()J
    //   686: invokevirtual 473	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   689: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   692: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   695: aload 12
    //   697: invokevirtual 357	java/io/File:length	()J
    //   700: aload_2
    //   701: getfield 636	com/whatsapp/gdrive/bb:a	J
    //   704: lcmp
    //   705: ifge +69 -> 774
    //   708: getstatic 349	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   711: ldc_w 1665
    //   714: iconst_2
    //   715: anewarray 4	java/lang/Object
    //   718: dup
    //   719: iconst_0
    //   720: aload_2
    //   721: getfield 636	com/whatsapp/gdrive/bb:a	J
    //   724: invokestatic 361	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   727: aastore
    //   728: dup
    //   729: iconst_1
    //   730: aload 12
    //   732: invokevirtual 357	java/io/File:length	()J
    //   735: invokestatic 361	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   738: aastore
    //   739: invokestatic 367	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   742: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   745: aload_3
    //   746: ldc2_w 566
    //   749: lload 6
    //   751: lmul
    //   752: invokeinterface 1084 3 0
    //   757: aload 11
    //   759: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   762: iconst_0
    //   763: ireturn
    //   764: astore_1
    //   765: ldc_w 1667
    //   768: aload_1
    //   769: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   772: iconst_0
    //   773: ireturn
    //   774: aload_0
    //   775: aload 12
    //   777: aload 12
    //   779: invokevirtual 357	java/io/File:length	()J
    //   782: aload_2
    //   783: getfield 1603	com/whatsapp/gdrive/bb:f	Ljava/lang/String;
    //   786: invokespecial 466	com/whatsapp/gdrive/at:a	(Ljava/io/File;JLjava/lang/String;)Z
    //   789: ifne +28 -> 817
    //   792: aload 12
    //   794: invokestatic 1632	com/whatsapp/gdrive/at:a	(Ljava/io/File;)Z
    //   797: pop
    //   798: aload_3
    //   799: ldc2_w 566
    //   802: lload 6
    //   804: lmul
    //   805: invokeinterface 1084 3 0
    //   810: aload 11
    //   812: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   815: iconst_0
    //   816: ireturn
    //   817: aload 12
    //   819: aload_1
    //   820: invokevirtual 1637	java/io/File:renameTo	(Ljava/io/File;)Z
    //   823: ifne +53 -> 876
    //   826: new 84	java/lang/StringBuilder
    //   829: dup
    //   830: ldc_w 1669
    //   833: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   836: aload 12
    //   838: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   841: ldc_w 1671
    //   844: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: aload_1
    //   848: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   851: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   854: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   857: aload_3
    //   858: ldc2_w 566
    //   861: lload 6
    //   863: lmul
    //   864: invokeinterface 1084 3 0
    //   869: aload 11
    //   871: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   874: iconst_0
    //   875: ireturn
    //   876: aload_3
    //   877: ldc2_w 566
    //   880: lload 6
    //   882: lmul
    //   883: invokeinterface 1084 3 0
    //   888: aload 11
    //   890: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   893: iconst_1
    //   894: ireturn
    //   895: iload 5
    //   897: sipush 401
    //   900: if_icmpne +27 -> 927
    //   903: aload_0
    //   904: invokevirtual 423	com/whatsapp/gdrive/at:b	()Z
    //   907: pop
    //   908: aload_3
    //   909: ldc2_w 566
    //   912: lload 6
    //   914: lmul
    //   915: invokeinterface 1084 3 0
    //   920: aload 11
    //   922: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   925: iconst_0
    //   926: ireturn
    //   927: new 84	java/lang/StringBuilder
    //   930: dup
    //   931: ldc_w 1673
    //   934: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   937: iload 5
    //   939: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   942: ldc_w 720
    //   945: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: aload 11
    //   950: invokevirtual 836	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   953: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   959: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   962: aload 11
    //   964: invokevirtual 940	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   967: invokestatic 943	com/whatsapp/gdrive/ch:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   970: astore_2
    //   971: new 84	java/lang/StringBuilder
    //   974: dup
    //   975: ldc_w 1675
    //   978: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   981: aload_2
    //   982: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   985: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   991: iload 5
    //   993: sipush 404
    //   996: if_icmpeq +11 -> 1007
    //   999: iload 5
    //   1001: sipush 403
    //   1004: if_icmpne +55 -> 1059
    //   1007: new 1166	com/whatsapp/gdrive/be
    //   1010: dup
    //   1011: invokespecial 1167	com/whatsapp/gdrive/be:<init>	()V
    //   1014: athrow
    //   1015: astore_1
    //   1016: new 84	java/lang/StringBuilder
    //   1019: dup
    //   1020: ldc_w 1677
    //   1023: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1026: aload 11
    //   1028: invokevirtual 914	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   1031: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1034: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1037: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1040: aload_3
    //   1041: ldc2_w 566
    //   1044: lload 6
    //   1046: lmul
    //   1047: invokeinterface 1084 3 0
    //   1052: aload 11
    //   1054: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   1057: iconst_0
    //   1058: ireturn
    //   1059: new 648	com/whatsapp/gdrive/bg
    //   1062: dup
    //   1063: aload_2
    //   1064: invokespecial 649	com/whatsapp/gdrive/bg:<init>	(Ljava/lang/String;)V
    //   1067: athrow
    //   1068: astore_2
    //   1069: new 84	java/lang/StringBuilder
    //   1072: dup
    //   1073: ldc_w 1679
    //   1076: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1079: aload_1
    //   1080: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1083: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1086: aload_2
    //   1087: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1090: aload_2
    //   1091: invokevirtual 1680	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1094: astore 4
    //   1096: aload 4
    //   1098: ifnull +48 -> 1146
    //   1101: aload 4
    //   1103: ldc_w 1682
    //   1106: invokevirtual 1120	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1109: ifeq +37 -> 1146
    //   1112: ldc_w 1684
    //   1115: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1118: new 1686	com/whatsapp/gdrive/cn
    //   1121: dup
    //   1122: invokespecial 1687	com/whatsapp/gdrive/cn:<init>	()V
    //   1125: athrow
    //   1126: astore_1
    //   1127: aload_3
    //   1128: lload 6
    //   1130: ldc2_w 566
    //   1133: lmul
    //   1134: invokeinterface 1084 3 0
    //   1139: aload 11
    //   1141: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   1144: aload_1
    //   1145: athrow
    //   1146: aload 4
    //   1148: ifnull +175 -> 1323
    //   1151: aload 4
    //   1153: ldc_w 1689
    //   1156: invokevirtual 1120	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1159: ifne +158 -> 1317
    //   1162: aload 4
    //   1164: ldc_w 1691
    //   1167: invokevirtual 1120	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1170: ifeq +153 -> 1323
    //   1173: goto +144 -> 1317
    //   1176: iload 5
    //   1178: ifeq +19 -> 1197
    //   1181: ldc_w 1693
    //   1184: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1187: new 1166	com/whatsapp/gdrive/be
    //   1190: dup
    //   1191: aload 4
    //   1193: invokespecial 1694	com/whatsapp/gdrive/be:<init>	(Ljava/lang/String;)V
    //   1196: athrow
    //   1197: aload_0
    //   1198: getfield 148	com/whatsapp/gdrive/at:t	Lcom/whatsapp/ox;
    //   1201: aload_1
    //   1202: invokevirtual 1461	com/whatsapp/ox:a	(Ljava/io/File;)Z
    //   1205: ifeq +22 -> 1227
    //   1208: aload_0
    //   1209: getfield 150	com/whatsapp/gdrive/at:u	Lcom/whatsapp/atu;
    //   1212: invokevirtual 1464	com/whatsapp/atu:b	()Z
    //   1215: ifne +12 -> 1227
    //   1218: new 1468	com/whatsapp/gdrive/a
    //   1221: dup
    //   1222: aload_2
    //   1223: invokespecial 1471	com/whatsapp/gdrive/a:<init>	(Ljava/lang/Throwable;)V
    //   1226: athrow
    //   1227: aload 4
    //   1229: ifnull +29 -> 1258
    //   1232: aload 4
    //   1234: ldc_w 1696
    //   1237: invokevirtual 1120	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1240: ifeq +18 -> 1258
    //   1243: ldc_w 1698
    //   1246: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1249: new 1468	com/whatsapp/gdrive/a
    //   1252: dup
    //   1253: aload_2
    //   1254: invokespecial 1471	com/whatsapp/gdrive/a:<init>	(Ljava/lang/Throwable;)V
    //   1257: athrow
    //   1258: aload 11
    //   1260: aload_2
    //   1261: invokestatic 908	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;Ljava/io/IOException;)Z
    //   1264: ifeq +34 -> 1298
    //   1267: new 84	java/lang/StringBuilder
    //   1270: dup
    //   1271: ldc_w 1700
    //   1274: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1277: aload 11
    //   1279: invokevirtual 914	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   1282: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1285: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1288: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   1291: aload_0
    //   1292: invokestatic 917	java/lang/System:currentTimeMillis	()J
    //   1295: putfield 919	com/whatsapp/gdrive/at:n	J
    //   1298: aload_3
    //   1299: ldc2_w 566
    //   1302: lload 6
    //   1304: lmul
    //   1305: invokeinterface 1084 3 0
    //   1310: aload 11
    //   1312: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   1315: iconst_0
    //   1316: ireturn
    //   1317: iconst_1
    //   1318: istore 5
    //   1320: goto -144 -> 1176
    //   1323: iconst_0
    //   1324: istore 5
    //   1326: goto -150 -> 1176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1329	0	this	at
    //   0	1329	1	paramFile	File
    //   0	1329	2	parambb	bb
    //   0	1329	3	parama	a
    //   0	1329	4	paramev	ev
    //   58	1267	5	i1	int
    //   241	1062	6	l1	long
    //   247	182	8	l2	long
    //   306	150	10	bool	boolean
    //   8	1303	11	localObject	Object
    //   226	611	12	localFile	File
    // Exception table:
    //   from	to	target	type
    //   527	546	764	java/io/IOException
    //   582	589	1015	java/net/UnknownHostException
    //   605	745	1015	java/net/UnknownHostException
    //   774	798	1015	java/net/UnknownHostException
    //   817	857	1015	java/net/UnknownHostException
    //   903	908	1015	java/net/UnknownHostException
    //   927	991	1015	java/net/UnknownHostException
    //   1007	1015	1015	java/net/UnknownHostException
    //   1059	1068	1015	java/net/UnknownHostException
    //   582	589	1068	java/io/IOException
    //   605	745	1068	java/io/IOException
    //   774	798	1068	java/io/IOException
    //   817	857	1068	java/io/IOException
    //   903	908	1068	java/io/IOException
    //   927	991	1068	java/io/IOException
    //   1007	1015	1068	java/io/IOException
    //   1059	1068	1068	java/io/IOException
    //   582	589	1126	finally
    //   605	745	1126	finally
    //   774	798	1126	finally
    //   817	857	1126	finally
    //   903	908	1126	finally
    //   927	991	1126	finally
    //   1007	1015	1126	finally
    //   1016	1040	1126	finally
    //   1059	1068	1126	finally
    //   1069	1096	1126	finally
    //   1101	1126	1126	finally
    //   1151	1173	1126	finally
    //   1181	1197	1126	finally
    //   1197	1227	1126	finally
    //   1232	1258	1126	finally
    //   1258	1298	1126	finally
  }
  
  /* Error */
  public final boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: invokestatic 1150	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore 4
    //   9: ldc_w 1140
    //   12: iconst_1
    //   13: anewarray 4	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: aload 4
    //   20: aastore
    //   21: invokestatic 1153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   24: ldc_w 663
    //   27: aload_0
    //   28: getfield 154	com/whatsapp/gdrive/at:q	Lcom/whatsapp/gdrive/at$d;
    //   31: getfield 654	com/whatsapp/gdrive/at$d:g	Ljava/lang/String;
    //   34: invokestatic 1156	com/whatsapp/gdrive/ch:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: astore_1
    //   38: aload_0
    //   39: aload_1
    //   40: ldc_w 1702
    //   43: aconst_null
    //   44: iconst_0
    //   45: invokespecial 823	com/whatsapp/gdrive/at:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/net/HttpURLConnection;
    //   48: astore_3
    //   49: aload_3
    //   50: astore_1
    //   51: aload_3
    //   52: invokevirtual 828	java/net/HttpURLConnection:connect	()V
    //   55: aload_3
    //   56: astore_1
    //   57: aload_3
    //   58: invokevirtual 831	java/net/HttpURLConnection:getResponseCode	()I
    //   61: istore_2
    //   62: aload_3
    //   63: astore_1
    //   64: new 84	java/lang/StringBuilder
    //   67: dup
    //   68: ldc_w 1704
    //   71: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   74: iload_2
    //   75: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   78: ldc_w 433
    //   81: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_3
    //   85: invokevirtual 836	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   88: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   97: iload_2
    //   98: sipush 204
    //   101: if_icmpne +38 -> 139
    //   104: aload_3
    //   105: astore_1
    //   106: new 84	java/lang/StringBuilder
    //   109: dup
    //   110: ldc_w 1706
    //   113: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   116: aload 4
    //   118: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: ldc_w 630
    //   124: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   133: aload_3
    //   134: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   137: iconst_1
    //   138: ireturn
    //   139: iload_2
    //   140: sipush 401
    //   143: if_icmpne +16 -> 159
    //   146: aload_3
    //   147: astore_1
    //   148: aload_0
    //   149: invokevirtual 423	com/whatsapp/gdrive/at:b	()Z
    //   152: pop
    //   153: aload_3
    //   154: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   157: iconst_0
    //   158: ireturn
    //   159: iload_2
    //   160: sipush 404
    //   163: if_icmpne +132 -> 295
    //   166: aload_3
    //   167: astore_1
    //   168: aload_3
    //   169: invokevirtual 940	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   172: invokestatic 943	com/whatsapp/gdrive/ch:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   175: astore 4
    //   177: aload_3
    //   178: astore_1
    //   179: new 84	java/lang/StringBuilder
    //   182: dup
    //   183: ldc_w 1708
    //   186: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   189: aload 4
    //   191: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   200: aload_3
    //   201: astore_1
    //   202: new 1166	com/whatsapp/gdrive/be
    //   205: dup
    //   206: aload 4
    //   208: invokespecial 1694	com/whatsapp/gdrive/be:<init>	(Ljava/lang/String;)V
    //   211: athrow
    //   212: astore 4
    //   214: aload_3
    //   215: astore_1
    //   216: ldc_w 1710
    //   219: aload 4
    //   221: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   224: aload_3
    //   225: astore_1
    //   226: aload_3
    //   227: aload 4
    //   229: invokestatic 908	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;Ljava/io/IOException;)Z
    //   232: ifeq +57 -> 289
    //   235: aload_3
    //   236: astore_1
    //   237: new 84	java/lang/StringBuilder
    //   240: dup
    //   241: ldc_w 1712
    //   244: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   247: astore 6
    //   249: aload 5
    //   251: astore 4
    //   253: aload_3
    //   254: ifnull +11 -> 265
    //   257: aload_3
    //   258: astore_1
    //   259: aload_3
    //   260: invokevirtual 914	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   263: astore 4
    //   265: aload_3
    //   266: astore_1
    //   267: aload 6
    //   269: aload 4
    //   271: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   274: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   280: aload_3
    //   281: astore_1
    //   282: aload_0
    //   283: invokestatic 917	java/lang/System:currentTimeMillis	()J
    //   286: putfield 919	com/whatsapp/gdrive/at:n	J
    //   289: aload_3
    //   290: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   293: iconst_0
    //   294: ireturn
    //   295: aload_3
    //   296: astore_1
    //   297: aload_3
    //   298: invokevirtual 940	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   301: invokestatic 943	com/whatsapp/gdrive/ch:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   304: astore 4
    //   306: aload_3
    //   307: astore_1
    //   308: new 84	java/lang/StringBuilder
    //   311: dup
    //   312: ldc_w 1714
    //   315: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   318: iload_2
    //   319: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   322: ldc_w 433
    //   325: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload 4
    //   330: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   339: aload_3
    //   340: astore_1
    //   341: new 648	com/whatsapp/gdrive/bg
    //   344: dup
    //   345: aload 4
    //   347: invokespecial 649	com/whatsapp/gdrive/bg:<init>	(Ljava/lang/String;)V
    //   350: athrow
    //   351: astore 4
    //   353: aload_1
    //   354: astore_3
    //   355: aload 4
    //   357: astore_1
    //   358: aload_3
    //   359: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   362: aload_1
    //   363: athrow
    //   364: astore_1
    //   365: aconst_null
    //   366: astore_3
    //   367: goto -9 -> 358
    //   370: astore 4
    //   372: aconst_null
    //   373: astore_3
    //   374: goto -160 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	this	at
    //   0	377	1	paramString	String
    //   61	258	2	i1	int
    //   48	326	3	localObject1	Object
    //   7	200	4	str	String
    //   212	16	4	localIOException1	IOException
    //   251	95	4	localObject2	Object
    //   351	5	4	localObject3	Object
    //   370	1	4	localIOException2	IOException
    //   1	249	5	localObject4	Object
    //   247	21	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   51	55	212	java/io/IOException
    //   57	62	212	java/io/IOException
    //   64	97	212	java/io/IOException
    //   106	133	212	java/io/IOException
    //   148	153	212	java/io/IOException
    //   168	177	212	java/io/IOException
    //   179	200	212	java/io/IOException
    //   202	212	212	java/io/IOException
    //   297	306	212	java/io/IOException
    //   308	339	212	java/io/IOException
    //   341	351	212	java/io/IOException
    //   51	55	351	finally
    //   57	62	351	finally
    //   64	97	351	finally
    //   106	133	351	finally
    //   148	153	351	finally
    //   168	177	351	finally
    //   179	200	351	finally
    //   202	212	351	finally
    //   216	224	351	finally
    //   226	235	351	finally
    //   237	249	351	finally
    //   259	265	351	finally
    //   267	280	351	finally
    //   282	289	351	finally
    //   297	306	351	finally
    //   308	339	351	finally
    //   341	351	351	finally
    //   38	49	364	finally
    //   38	49	370	java/io/IOException
  }
  
  /* Error */
  public final boolean a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc_w 1140
    //   3: iconst_1
    //   4: anewarray 4	java/lang/Object
    //   7: dup
    //   8: iconst_0
    //   9: aload_1
    //   10: invokestatic 1150	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   13: aastore
    //   14: invokestatic 1153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   17: bipush 6
    //   19: anewarray 363	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: ldc_w 663
    //   27: aastore
    //   28: dup
    //   29: iconst_1
    //   30: aload_0
    //   31: getfield 154	com/whatsapp/gdrive/at:q	Lcom/whatsapp/gdrive/at$d;
    //   34: getfield 654	com/whatsapp/gdrive/at$d:g	Ljava/lang/String;
    //   37: aastore
    //   38: dup
    //   39: iconst_2
    //   40: ldc_w 984
    //   43: aastore
    //   44: dup
    //   45: iconst_3
    //   46: aload_3
    //   47: aastore
    //   48: dup
    //   49: iconst_4
    //   50: ldc_w 665
    //   53: aastore
    //   54: dup
    //   55: iconst_5
    //   56: iconst_0
    //   57: invokestatic 657	com/whatsapp/gdrive/bb:a	(Z)Ljava/lang/String;
    //   60: aastore
    //   61: invokestatic 668	com/whatsapp/gdrive/ch:a	(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
    //   64: astore 5
    //   66: aconst_null
    //   67: astore_3
    //   68: aconst_null
    //   69: astore_1
    //   70: new 593	org/json/JSONObject
    //   73: dup
    //   74: invokespecial 682	org/json/JSONObject:<init>	()V
    //   77: ldc_w 684
    //   80: aload_2
    //   81: invokevirtual 688	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   84: invokevirtual 708	org/json/JSONObject:toString	()Ljava/lang/String;
    //   87: astore 6
    //   89: aload_3
    //   90: astore_2
    //   91: aload_0
    //   92: aload 5
    //   94: ldc_w 1717
    //   97: ldc_w 672
    //   100: iconst_1
    //   101: invokespecial 823	com/whatsapp/gdrive/at:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/net/HttpURLConnection;
    //   104: astore_3
    //   105: aload_3
    //   106: astore_1
    //   107: aload_3
    //   108: astore_2
    //   109: invokestatic 1718	com/whatsapp/gdrive/ch:a	()V
    //   112: aload_3
    //   113: astore_1
    //   114: aload_3
    //   115: astore_2
    //   116: aload_3
    //   117: invokevirtual 1505	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   120: aload 6
    //   122: invokevirtual 1219	java/lang/String:getBytes	()[B
    //   125: invokevirtual 1507	java/io/OutputStream:write	([B)V
    //   128: aload_3
    //   129: astore_1
    //   130: aload_3
    //   131: astore_2
    //   132: aload_3
    //   133: invokevirtual 828	java/net/HttpURLConnection:connect	()V
    //   136: aload_3
    //   137: astore_1
    //   138: aload_3
    //   139: astore_2
    //   140: aload_3
    //   141: invokevirtual 831	java/net/HttpURLConnection:getResponseCode	()I
    //   144: istore 4
    //   146: aload_3
    //   147: astore_1
    //   148: aload_3
    //   149: astore_2
    //   150: invokestatic 1542	com/whatsapp/gdrive/ch:b	()V
    //   153: aload_3
    //   154: astore_1
    //   155: aload_3
    //   156: astore_2
    //   157: new 84	java/lang/StringBuilder
    //   160: dup
    //   161: ldc_w 1720
    //   164: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   167: iload 4
    //   169: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: ldc_w 1722
    //   175: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload_3
    //   179: invokevirtual 836	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   182: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   191: iload 4
    //   193: sipush 200
    //   196: if_icmpne +57 -> 253
    //   199: aload_3
    //   200: astore_1
    //   201: aload_3
    //   202: astore_2
    //   203: aload_3
    //   204: invokevirtual 844	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   207: invokestatic 943	com/whatsapp/gdrive/ch:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   210: astore 5
    //   212: aload_3
    //   213: astore_1
    //   214: aload_3
    //   215: astore_2
    //   216: new 84	java/lang/StringBuilder
    //   219: dup
    //   220: ldc_w 1724
    //   223: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: aload 5
    //   228: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   237: aload_3
    //   238: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   241: iconst_1
    //   242: ireturn
    //   243: astore_1
    //   244: ldc_w 1726
    //   247: aload_1
    //   248: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   251: iconst_0
    //   252: ireturn
    //   253: iload 4
    //   255: sipush 401
    //   258: if_icmpne +18 -> 276
    //   261: aload_3
    //   262: astore_1
    //   263: aload_3
    //   264: astore_2
    //   265: aload_0
    //   266: invokevirtual 423	com/whatsapp/gdrive/at:b	()Z
    //   269: pop
    //   270: aload_3
    //   271: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   274: iconst_0
    //   275: ireturn
    //   276: aload_3
    //   277: astore_1
    //   278: aload_3
    //   279: astore_2
    //   280: aload_3
    //   281: invokevirtual 940	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   284: invokestatic 943	com/whatsapp/gdrive/ch:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   287: astore 5
    //   289: aload_3
    //   290: astore_1
    //   291: aload_3
    //   292: astore_2
    //   293: new 84	java/lang/StringBuilder
    //   296: dup
    //   297: ldc_w 1728
    //   300: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   303: iload 4
    //   305: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   308: ldc_w 433
    //   311: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload 5
    //   316: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   325: aload_3
    //   326: astore_1
    //   327: aload_3
    //   328: astore_2
    //   329: new 648	com/whatsapp/gdrive/bg
    //   332: dup
    //   333: aload 5
    //   335: invokespecial 649	com/whatsapp/gdrive/bg:<init>	(Ljava/lang/String;)V
    //   338: athrow
    //   339: astore_3
    //   340: aload_1
    //   341: astore_2
    //   342: ldc_w 1726
    //   345: aload_3
    //   346: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   349: aload_1
    //   350: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   353: iconst_0
    //   354: ireturn
    //   355: astore_1
    //   356: aload_2
    //   357: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   360: aload_1
    //   361: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	362	0	this	at
    //   0	362	1	paramString1	String
    //   0	362	2	paramString2	String
    //   0	362	3	paramString3	String
    //   144	160	4	i1	int
    //   64	270	5	str1	String
    //   87	34	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   70	89	243	org/json/JSONException
    //   91	105	339	java/io/IOException
    //   109	112	339	java/io/IOException
    //   116	128	339	java/io/IOException
    //   132	136	339	java/io/IOException
    //   140	146	339	java/io/IOException
    //   150	153	339	java/io/IOException
    //   157	191	339	java/io/IOException
    //   203	212	339	java/io/IOException
    //   216	237	339	java/io/IOException
    //   265	270	339	java/io/IOException
    //   280	289	339	java/io/IOException
    //   293	325	339	java/io/IOException
    //   329	339	339	java/io/IOException
    //   91	105	355	finally
    //   109	112	355	finally
    //   116	128	355	finally
    //   132	136	355	finally
    //   140	146	355	finally
    //   150	153	355	finally
    //   157	191	355	finally
    //   203	212	355	finally
    //   216	237	355	finally
    //   265	270	355	finally
    //   280	289	355	finally
    //   293	325	355	finally
    //   329	339	355	finally
    //   342	349	355	finally
  }
  
  public final boolean a(List<bb> paramList)
  {
    boolean bool2 = false;
    if (a()) {
      Log.i("gdrive-api/delete-batch/interrupted");
    }
    int i2;
    boolean bool1;
    do
    {
      return bool2;
      i2 = paramList.size() / 50;
      bool1 = true;
      int i1 = 0;
      while (i1 < i2)
      {
        Log.i("gdrive-api/delete-files deleting complete batch #" + (i1 + 1) + "/" + i2 + " containing 50 requests.");
        bool1 = a(paramList, i1 * 50, (i1 + 1) * 50);
        if (bool1)
        {
          Log.i("gdrive-api/delete-files deleting complete batch #" + (i1 + 1) + "/" + i2 + " containing 50 succeeded.");
          i1 += 1;
        }
        else
        {
          Log.i("GoogleDriveApi/delete-files deleting complete batch #" + (i1 + 1) + "/" + i2 + " containing 50 failed.");
        }
      }
      bool2 = bool1;
    } while (paramList.size() % 50 == 0);
    Log.i("gdrive-api/delete-files deleting final batch containing " + (paramList.size() - i2 * 50));
    return bool1 & a(paramList, i2 * 50, paramList.size());
  }
  
  public final boolean b()
  {
    boolean bool = false;
    try
    {
      Log.i("gdrive-api/auth-request asking GoogleAuthUtil for auth token: " + ch.a(this.l));
      if (this.o != null) {
        com.google.android.gms.auth.b.a(this.g, this.o);
      }
      this.o = com.google.android.gms.auth.b.a(this.g, this.l, "oauth2:https://www.googleapis.com/auth/drive.appdata https://www.googleapis.com/auth/drive.file");
      Log.i("gdrive-api/auth-request/received-auth-token");
      bool = true;
    }
    catch (com.google.android.gms.auth.c localc)
    {
      Log.e("gdrive-api/auth-request Google Play services is unavailable, if it was unavailable from the beginning code would not have reached here, so, most likely it became unavailable while the backup/restore was in progress");
      Log.d("gdrive-api/auth-request", localc);
      this.o = null;
      throw new ax(localc);
    }
    catch (com.google.android.gms.auth.d locald)
    {
      Log.i("gdrive-api/auth-request permission to access Google Drive for " + ch.a(this.l) + " is not available and we cannot ask user for permission either.");
      throw new ax(locald);
    }
    catch (IOException localIOException)
    {
      Log.d("gdrive-api/auth-request IOException while trying to fetch auth token");
      Log.d("gdrive-api/auth-request", localIOException);
      this.o = null;
      return false;
    }
    catch (com.google.android.gms.auth.a locala)
    {
      do
      {
        Log.d("gdrive-api/auth-request", locala);
        if ("BadUsername".equals(locala.getMessage())) {
          throw new f(locala);
        }
      } while ("ServiceUnavailable".equals(locala.getMessage()));
      this.o = null;
      throw new ax(locala);
    }
    catch (SecurityException localSecurityException)
    {
      Log.d("gdrive-api/auth-request", localSecurityException);
      this.o = null;
      throw new ax(localSecurityException);
    }
    catch (NullPointerException localNullPointerException)
    {
      Log.e("gdrive-api/auth-request unexpected NullPointerException while trying to get  auth token for the account " + ch.a(this.l));
      Log.d("gdrive-api/auth-request", localNullPointerException);
      this.o = null;
      throw new ax(localNullPointerException);
    }
    return bool;
  }
  
  /* Error */
  public final boolean b(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc_w 1793
    //   6: iconst_1
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_1
    //   13: invokestatic 1150	java/net/URLEncoder:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   16: aastore
    //   17: invokestatic 1153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   20: ldc_w 663
    //   23: aload_0
    //   24: getfield 154	com/whatsapp/gdrive/at:q	Lcom/whatsapp/gdrive/at$d;
    //   27: getfield 654	com/whatsapp/gdrive/at$d:g	Ljava/lang/String;
    //   30: invokestatic 1156	com/whatsapp/gdrive/ch:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: astore_1
    //   34: new 593	org/json/JSONObject
    //   37: dup
    //   38: invokespecial 682	org/json/JSONObject:<init>	()V
    //   41: ldc_w 695
    //   44: ldc_w 1795
    //   47: invokevirtual 688	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   50: ldc_w 1797
    //   53: aload_2
    //   54: invokevirtual 688	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   57: ldc_w 1799
    //   60: aload_3
    //   61: invokevirtual 688	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   64: ldc_w 1801
    //   67: ldc_w 1803
    //   70: invokevirtual 688	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   73: invokevirtual 708	org/json/JSONObject:toString	()Ljava/lang/String;
    //   76: astore_3
    //   77: aload_0
    //   78: aload_1
    //   79: ldc_w 821
    //   82: ldc_w 672
    //   85: iconst_1
    //   86: invokespecial 823	com/whatsapp/gdrive/at:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/net/HttpURLConnection;
    //   89: astore_2
    //   90: aload_2
    //   91: astore_1
    //   92: aload_2
    //   93: invokevirtual 1505	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   96: aload_3
    //   97: invokevirtual 1219	java/lang/String:getBytes	()[B
    //   100: invokevirtual 1507	java/io/OutputStream:write	([B)V
    //   103: aload_2
    //   104: astore_1
    //   105: aload_2
    //   106: invokevirtual 1505	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   109: invokevirtual 1804	java/io/OutputStream:close	()V
    //   112: aload_2
    //   113: astore_1
    //   114: aload_2
    //   115: invokevirtual 828	java/net/HttpURLConnection:connect	()V
    //   118: aload_2
    //   119: astore_1
    //   120: aload_2
    //   121: invokevirtual 831	java/net/HttpURLConnection:getResponseCode	()I
    //   124: istore 4
    //   126: iload 4
    //   128: sipush 200
    //   131: if_icmpne +27 -> 158
    //   134: aload_2
    //   135: astore_1
    //   136: ldc_w 1806
    //   139: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   142: aload_2
    //   143: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   146: iconst_1
    //   147: ireturn
    //   148: astore_1
    //   149: ldc_w 1808
    //   152: aload_1
    //   153: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   156: iconst_0
    //   157: ireturn
    //   158: iload 4
    //   160: sipush 401
    //   163: if_icmpne +24 -> 187
    //   166: aload_2
    //   167: astore_1
    //   168: ldc_w 1810
    //   171: invokestatic 485	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   174: aload_2
    //   175: astore_1
    //   176: aload_0
    //   177: invokevirtual 423	com/whatsapp/gdrive/at:b	()Z
    //   180: pop
    //   181: aload_2
    //   182: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   185: iconst_0
    //   186: ireturn
    //   187: iload 4
    //   189: sipush 404
    //   192: if_icmpne +98 -> 290
    //   195: aload_2
    //   196: astore_1
    //   197: ldc_w 1812
    //   200: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   203: aload_2
    //   204: astore_1
    //   205: new 1166	com/whatsapp/gdrive/be
    //   208: dup
    //   209: invokespecial 1167	com/whatsapp/gdrive/be:<init>	()V
    //   212: athrow
    //   213: astore_3
    //   214: aload_2
    //   215: astore_1
    //   216: ldc_w 1808
    //   219: aload_3
    //   220: invokestatic 414	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   223: aload_2
    //   224: astore_1
    //   225: aload_2
    //   226: aload_3
    //   227: invokestatic 908	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;Ljava/io/IOException;)Z
    //   230: ifeq +54 -> 284
    //   233: aload_2
    //   234: astore_1
    //   235: new 84	java/lang/StringBuilder
    //   238: dup
    //   239: ldc_w 1814
    //   242: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   245: astore 6
    //   247: aload 5
    //   249: astore_3
    //   250: aload_2
    //   251: ifnull +10 -> 261
    //   254: aload_2
    //   255: astore_1
    //   256: aload_2
    //   257: invokevirtual 914	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   260: astore_3
    //   261: aload_2
    //   262: astore_1
    //   263: aload 6
    //   265: aload_3
    //   266: invokevirtual 497	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 223	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   275: aload_2
    //   276: astore_1
    //   277: aload_0
    //   278: invokestatic 917	java/lang/System:currentTimeMillis	()J
    //   281: putfield 919	com/whatsapp/gdrive/at:n	J
    //   284: aload_2
    //   285: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   288: iconst_0
    //   289: ireturn
    //   290: iload 4
    //   292: sipush 403
    //   295: if_icmpne +71 -> 366
    //   298: aload_2
    //   299: astore_1
    //   300: aload_2
    //   301: invokevirtual 940	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   304: invokestatic 943	com/whatsapp/gdrive/ch:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   307: astore_3
    //   308: aload_2
    //   309: astore_1
    //   310: aload_3
    //   311: invokestatic 406	com/whatsapp/gdrive/at:e	(Ljava/lang/String;)Z
    //   314: ifeq +24 -> 338
    //   317: aload_2
    //   318: astore_1
    //   319: new 408	com/whatsapp/gdrive/bf
    //   322: dup
    //   323: invokespecial 409	com/whatsapp/gdrive/bf:<init>	()V
    //   326: athrow
    //   327: astore_3
    //   328: aload_1
    //   329: astore_2
    //   330: aload_3
    //   331: astore_1
    //   332: aload_2
    //   333: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   336: aload_1
    //   337: athrow
    //   338: aload_2
    //   339: astore_1
    //   340: new 84	java/lang/StringBuilder
    //   343: dup
    //   344: ldc_w 1816
    //   347: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   350: aload_3
    //   351: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 421	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   360: aload_2
    //   361: invokestatic 867	com/whatsapp/gdrive/at:a	(Ljava/net/HttpURLConnection;)V
    //   364: iconst_0
    //   365: ireturn
    //   366: aload_2
    //   367: astore_1
    //   368: new 648	com/whatsapp/gdrive/bg
    //   371: dup
    //   372: aload_2
    //   373: invokevirtual 940	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   376: invokestatic 943	com/whatsapp/gdrive/ch:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   379: invokespecial 649	com/whatsapp/gdrive/bg:<init>	(Ljava/lang/String;)V
    //   382: athrow
    //   383: astore_1
    //   384: aconst_null
    //   385: astore_2
    //   386: goto -54 -> 332
    //   389: astore_3
    //   390: aconst_null
    //   391: astore_2
    //   392: goto -178 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	this	at
    //   0	395	1	paramString1	String
    //   0	395	2	paramString2	String
    //   0	395	3	paramString3	String
    //   124	172	4	i1	int
    //   1	247	5	localObject	Object
    //   245	19	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   34	77	148	org/json/JSONException
    //   92	103	213	java/io/IOException
    //   105	112	213	java/io/IOException
    //   114	118	213	java/io/IOException
    //   120	126	213	java/io/IOException
    //   136	142	213	java/io/IOException
    //   168	174	213	java/io/IOException
    //   176	181	213	java/io/IOException
    //   197	203	213	java/io/IOException
    //   205	213	213	java/io/IOException
    //   300	308	213	java/io/IOException
    //   310	317	213	java/io/IOException
    //   319	327	213	java/io/IOException
    //   340	360	213	java/io/IOException
    //   368	383	213	java/io/IOException
    //   92	103	327	finally
    //   105	112	327	finally
    //   114	118	327	finally
    //   120	126	327	finally
    //   136	142	327	finally
    //   168	174	327	finally
    //   176	181	327	finally
    //   197	203	327	finally
    //   205	213	327	finally
    //   216	223	327	finally
    //   225	233	327	finally
    //   235	247	327	finally
    //   256	261	327	finally
    //   263	275	327	finally
    //   277	284	327	finally
    //   300	308	327	finally
    //   310	317	327	finally
    //   319	327	327	finally
    //   340	360	327	finally
    //   368	383	327	finally
    //   77	90	383	finally
    //   77	90	389	java/io/IOException
  }
  
  public final boolean c()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = g().getAll().keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      if ((str != null) && ((str.startsWith("ResumableUrl-")) || (str.startsWith("gdrive-ResumableUrl-" + this.l)))) {
        ((ArrayList)localObject1).add(str);
      }
    }
    localObject2 = g().edit();
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((SharedPreferences.Editor)localObject2).remove((String)((Iterator)localObject1).next());
    }
    if (!((SharedPreferences.Editor)localObject2).commit())
    {
      Log.w("gdrive-api/remove-all-resumable-uris unable to commit after cleanup to shared prefs.");
      return false;
    }
    return true;
  }
  
  public final int d()
  {
    return this.i.a + this.k.get();
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong);
  }
  
  public static abstract interface b
  {
    public abstract void a(long paramLong);
  }
  
  static final class c
    implements HostnameVerifier
  {
    private final BrowserCompatHostnameVerifier a = new BrowserCompatHostnameVerifier();
    
    public final boolean verify(String paramString, SSLSession paramSSLSession)
    {
      return this.a.verify("www.googleapis.com", paramSSLSession);
    }
  }
  
  public static enum d
  {
    final String g;
    
    private d(String paramString)
    {
      this.g = paramString;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gdrive/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */