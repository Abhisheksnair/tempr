package com.whatsapp.i;

import a.a.a.a.d;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.whatsapp.aat;
import com.whatsapp.aic;
import com.whatsapp.and;
import com.whatsapp.ape;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.aus;
import com.whatsapp.aut;
import com.whatsapp.av;
import com.whatsapp.l.f;
import com.whatsapp.pb;
import com.whatsapp.r;
import com.whatsapp.registration.bc;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.ad;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.RequestExpectContinue;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  private static volatile b c;
  final Context a;
  final com.whatsapp.a.c b;
  private final aic d;
  private final and e;
  private final aus f;
  private final f g;
  private final aat h;
  private final atu i;
  private final atv j;
  
  private b(Context paramContext, aic paramaic, and paramand, aus paramaus, f paramf, aat paramaat, com.whatsapp.a.c paramc, atu paramatu, atv paramatv)
  {
    this.a = paramContext;
    this.d = paramaic;
    this.e = paramand;
    this.f = paramaus;
    this.g = paramf;
    this.h = paramaat;
    this.b = paramc;
    this.i = paramatu;
    this.j = paramatv;
  }
  
  /* Error */
  public static e a(com.whatsapp.registration.bk parambk)
  {
    // Byte code:
    //   0: invokestatic 81	com/whatsapp/aic:j	()Landroid/net/Uri$Builder;
    //   3: ldc 83
    //   5: invokevirtual 89	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   8: astore 4
    //   10: ldc 91
    //   12: astore_3
    //   13: aload_0
    //   14: getfield 95	com/whatsapp/registration/bk:i	Lcom/whatsapp/and;
    //   17: getfield 100	com/whatsapp/and:c	Landroid/telephony/TelephonyManager;
    //   20: astore 5
    //   22: aload 5
    //   24: ifnull +14 -> 38
    //   27: aload 5
    //   29: invokevirtual 106	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
    //   32: ldc 108
    //   34: invokestatic 113	com/whatsapp/util/ad:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   37: astore_3
    //   38: new 115	java/util/HashMap
    //   41: dup
    //   42: invokespecial 116	java/util/HashMap:<init>	()V
    //   45: astore 5
    //   47: aload_0
    //   48: getfield 119	com/whatsapp/registration/bk:a	Ljava/lang/String;
    //   51: ifnull +211 -> 262
    //   54: aload 5
    //   56: ldc 121
    //   58: ldc 123
    //   60: invokeinterface 129 3 0
    //   65: pop
    //   66: aload 5
    //   68: ldc -125
    //   70: aload_3
    //   71: invokeinterface 129 3 0
    //   76: pop
    //   77: aload 5
    //   79: ldc -123
    //   81: aload_0
    //   82: getfield 135	com/whatsapp/registration/bk:j	Lcom/whatsapp/aus;
    //   85: invokevirtual 139	com/whatsapp/aus:c	()Ljava/lang/String;
    //   88: invokeinterface 129 3 0
    //   93: pop
    //   94: aload 5
    //   96: ldc -115
    //   98: aload_0
    //   99: getfield 135	com/whatsapp/registration/bk:j	Lcom/whatsapp/aus;
    //   102: invokevirtual 143	com/whatsapp/aus:d	()Ljava/lang/String;
    //   105: invokeinterface 129 3 0
    //   110: pop
    //   111: aload 5
    //   113: ldc -111
    //   115: aload_0
    //   116: getfield 119	com/whatsapp/registration/bk:a	Ljava/lang/String;
    //   119: invokeinterface 129 3 0
    //   124: pop
    //   125: aload 5
    //   127: ldc -109
    //   129: aload_0
    //   130: invokevirtual 149	com/whatsapp/registration/bk:b	()Ljava/lang/String;
    //   133: invokeinterface 129 3 0
    //   138: pop
    //   139: aload_0
    //   140: getfield 152	com/whatsapp/registration/bk:b	Z
    //   143: ifeq +184 -> 327
    //   146: ldc -102
    //   148: astore_3
    //   149: aload 5
    //   151: ldc -100
    //   153: aload_3
    //   154: invokeinterface 129 3 0
    //   159: pop
    //   160: aload_0
    //   161: getfield 158	com/whatsapp/registration/bk:c	Z
    //   164: ifeq +169 -> 333
    //   167: ldc -102
    //   169: astore_3
    //   170: aload 5
    //   172: ldc -96
    //   174: aload_3
    //   175: invokeinterface 129 3 0
    //   180: pop
    //   181: aload_0
    //   182: getfield 162	com/whatsapp/registration/bk:d	Z
    //   185: ifeq +154 -> 339
    //   188: ldc -102
    //   190: astore_3
    //   191: aload 5
    //   193: ldc -92
    //   195: aload_3
    //   196: invokeinterface 129 3 0
    //   201: pop
    //   202: aload_0
    //   203: getfield 166	com/whatsapp/registration/bk:h	Z
    //   206: ifeq +139 -> 345
    //   209: ldc -102
    //   211: astore_3
    //   212: aload 5
    //   214: ldc -88
    //   216: aload_3
    //   217: invokeinterface 129 3 0
    //   222: pop
    //   223: aload_0
    //   224: getfield 170	com/whatsapp/registration/bk:g	Z
    //   227: ifeq +124 -> 351
    //   230: ldc -102
    //   232: astore_3
    //   233: aload 5
    //   235: ldc -84
    //   237: aload_3
    //   238: invokeinterface 129 3 0
    //   243: pop
    //   244: aload 5
    //   246: ldc -82
    //   248: aload_0
    //   249: aload_0
    //   250: getfield 119	com/whatsapp/registration/bk:a	Ljava/lang/String;
    //   253: invokevirtual 177	com/whatsapp/registration/bk:c	(Ljava/lang/String;)Ljava/lang/String;
    //   256: invokeinterface 129 3 0
    //   261: pop
    //   262: aload 5
    //   264: invokeinterface 181 1 0
    //   269: invokeinterface 187 1 0
    //   274: astore_3
    //   275: aload_3
    //   276: invokeinterface 193 1 0
    //   281: ifeq +82 -> 363
    //   284: aload_3
    //   285: invokeinterface 197 1 0
    //   290: checkcast 199	java/lang/String
    //   293: astore 6
    //   295: aload 5
    //   297: aload 6
    //   299: invokeinterface 203 2 0
    //   304: checkcast 199	java/lang/String
    //   307: astore_0
    //   308: aload_0
    //   309: invokestatic 209	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   312: ifne +45 -> 357
    //   315: aload 4
    //   317: aload 6
    //   319: aload_0
    //   320: invokevirtual 213	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   323: pop
    //   324: goto -49 -> 275
    //   327: ldc -41
    //   329: astore_3
    //   330: goto -181 -> 149
    //   333: ldc -41
    //   335: astore_3
    //   336: goto -166 -> 170
    //   339: ldc -41
    //   341: astore_3
    //   342: goto -151 -> 191
    //   345: ldc -41
    //   347: astore_3
    //   348: goto -136 -> 212
    //   351: ldc -41
    //   353: astore_3
    //   354: goto -121 -> 233
    //   357: ldc -39
    //   359: astore_0
    //   360: goto -45 -> 315
    //   363: aload 4
    //   365: invokevirtual 221	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   368: invokevirtual 226	android/net/Uri:toString	()Ljava/lang/String;
    //   371: astore_0
    //   372: new 228	java/lang/StringBuilder
    //   375: dup
    //   376: ldc -26
    //   378: invokespecial 233	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   381: aload_0
    //   382: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 242	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   391: new 244	java/net/URL
    //   394: dup
    //   395: aload_0
    //   396: invokespecial 245	java/net/URL:<init>	(Ljava/lang/String;)V
    //   399: invokevirtual 249	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   402: astore_0
    //   403: aload_0
    //   404: sipush 15000
    //   407: invokevirtual 255	java/net/URLConnection:setConnectTimeout	(I)V
    //   410: aload_0
    //   411: sipush 30000
    //   414: invokevirtual 258	java/net/URLConnection:setReadTimeout	(I)V
    //   417: aload_0
    //   418: checkcast 260	javax/net/ssl/HttpsURLConnection
    //   421: astore_3
    //   422: aload_3
    //   423: ldc_w 262
    //   426: invokevirtual 265	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   429: new 267	java/io/InputStreamReader
    //   432: dup
    //   433: aload_0
    //   434: invokevirtual 271	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   437: invokespecial 274	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   440: astore 5
    //   442: sipush 2048
    //   445: newarray <illegal type>
    //   447: astore_0
    //   448: aload 5
    //   450: aload_0
    //   451: iconst_0
    //   452: sipush 2048
    //   455: invokevirtual 278	java/io/InputStreamReader:read	([CII)I
    //   458: istore_1
    //   459: new 228	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   466: astore 4
    //   468: iconst_0
    //   469: istore_2
    //   470: iload_1
    //   471: iconst_m1
    //   472: if_icmpeq +79 -> 551
    //   475: iload_2
    //   476: iload_1
    //   477: iadd
    //   478: istore_2
    //   479: iload_2
    //   480: ldc_w 280
    //   483: if_icmple +45 -> 528
    //   486: new 282	java/io/IOException
    //   489: dup
    //   490: ldc_w 284
    //   493: invokespecial 285	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   496: athrow
    //   497: astore 4
    //   499: aload 5
    //   501: astore_0
    //   502: ldc_w 287
    //   505: aload 4
    //   507: invokestatic 290	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   510: aload_3
    //   511: ifnull +7 -> 518
    //   514: aload_3
    //   515: invokevirtual 293	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   518: aload_0
    //   519: ifnull +7 -> 526
    //   522: aload_0
    //   523: invokevirtual 296	java/io/InputStreamReader:close	()V
    //   526: aconst_null
    //   527: areturn
    //   528: aload 4
    //   530: aload_0
    //   531: iconst_0
    //   532: iload_1
    //   533: invokevirtual 299	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload 5
    //   539: aload_0
    //   540: iconst_0
    //   541: sipush 2048
    //   544: invokevirtual 278	java/io/InputStreamReader:read	([CII)I
    //   547: istore_1
    //   548: goto -78 -> 470
    //   551: new 301	org/json/JSONObject
    //   554: dup
    //   555: aload 4
    //   557: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokespecial 302	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   563: astore_0
    //   564: new 20	com/whatsapp/i/b$e
    //   567: dup
    //   568: aload_0
    //   569: ldc_w 304
    //   572: invokevirtual 307	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   575: aload_0
    //   576: ldc 121
    //   578: invokevirtual 307	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   581: aload_0
    //   582: ldc_w 309
    //   585: invokevirtual 307	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   588: aload_0
    //   589: ldc_w 311
    //   592: invokevirtual 307	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   595: aload_0
    //   596: ldc_w 313
    //   599: invokevirtual 307	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   602: aload_0
    //   603: ldc_w 315
    //   606: invokevirtual 307	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   609: invokespecial 318	com/whatsapp/i/b$e:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   612: astore_0
    //   613: aload_3
    //   614: ifnull +7 -> 621
    //   617: aload_3
    //   618: invokevirtual 293	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   621: aload 5
    //   623: invokevirtual 296	java/io/InputStreamReader:close	()V
    //   626: aload_0
    //   627: areturn
    //   628: astore_0
    //   629: aconst_null
    //   630: astore_3
    //   631: aconst_null
    //   632: astore 4
    //   634: aload 4
    //   636: ifnull +8 -> 644
    //   639: aload 4
    //   641: invokevirtual 293	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   644: aload_3
    //   645: ifnull +7 -> 652
    //   648: aload_3
    //   649: invokevirtual 296	java/io/InputStreamReader:close	()V
    //   652: aload_0
    //   653: athrow
    //   654: astore_0
    //   655: aconst_null
    //   656: astore 5
    //   658: aload_3
    //   659: astore 4
    //   661: aload 5
    //   663: astore_3
    //   664: goto -30 -> 634
    //   667: astore_0
    //   668: aload_3
    //   669: astore 4
    //   671: aload 5
    //   673: astore_3
    //   674: goto -40 -> 634
    //   677: astore 4
    //   679: aload_0
    //   680: astore 5
    //   682: aload 4
    //   684: astore_0
    //   685: aload_3
    //   686: astore 4
    //   688: aload 5
    //   690: astore_3
    //   691: goto -57 -> 634
    //   694: astore 4
    //   696: aconst_null
    //   697: astore_0
    //   698: aconst_null
    //   699: astore_3
    //   700: goto -198 -> 502
    //   703: astore 4
    //   705: aconst_null
    //   706: astore_0
    //   707: goto -205 -> 502
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	710	0	parambk	com.whatsapp.registration.bk
    //   458	90	1	k	int
    //   469	15	2	m	int
    //   12	688	3	localObject1	Object
    //   8	459	4	localObject2	Object
    //   497	59	4	localException1	Exception
    //   632	38	4	localObject3	Object
    //   677	6	4	localObject4	Object
    //   686	1	4	localObject5	Object
    //   694	1	4	localException2	Exception
    //   703	1	4	localException3	Exception
    //   20	669	5	localObject6	Object
    //   293	25	6	str	String
    // Exception table:
    //   from	to	target	type
    //   442	468	497	java/lang/Exception
    //   486	497	497	java/lang/Exception
    //   528	548	497	java/lang/Exception
    //   551	613	497	java/lang/Exception
    //   363	422	628	finally
    //   422	442	654	finally
    //   442	468	667	finally
    //   486	497	667	finally
    //   528	548	667	finally
    //   551	613	667	finally
    //   502	510	677	finally
    //   363	422	694	java/lang/Exception
    //   422	442	703	java/lang/Exception
  }
  
  public static b a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new b(u.a(), aic.a(), and.a(), aus.a(), f.a(), aat.a(), com.whatsapp.a.c.a(), atu.a(), atv.a());
      }
      return c;
    }
    finally {}
  }
  
  private static String a(List<Pair<String, byte[]>> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    int k = 0;
    while (paramList.hasNext())
    {
      Pair localPair = (Pair)paramList.next();
      int m;
      if (k == 0)
      {
        localStringBuilder.append('?');
        localStringBuilder.append((String)localPair.first);
        localStringBuilder.append('=');
        m = 0;
        label70:
        if (m >= ((byte[])localPair.second).length) {
          break label258;
        }
        if (((((byte[])localPair.second)[m] < 48) || (((byte[])localPair.second)[m] > 57)) && ((((byte[])localPair.second)[m] < 65) || (((byte[])localPair.second)[m] > 90)) && ((((byte[])localPair.second)[m] < 97) || (((byte[])localPair.second)[m] > 122))) {
          break label206;
        }
        localStringBuilder.append((char)((byte[])localPair.second)[m]);
      }
      for (;;)
      {
        m += 1;
        break label70;
        localStringBuilder.append('&');
        break;
        label206:
        localStringBuilder.append('%');
        String str = Integer.toHexString(((byte[])localPair.second)[m] & 0xFF);
        if (str.length() == 1) {
          localStringBuilder.append('0');
        }
        localStringBuilder.append(str);
      }
      label258:
      k += 1;
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  private static JSONObject a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 399	java/io/BufferedReader
    //   3: dup
    //   4: new 267	java/io/InputStreamReader
    //   7: dup
    //   8: aload_0
    //   9: ldc_w 401
    //   12: invokespecial 404	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   15: invokespecial 407	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   18: astore_3
    //   19: new 228	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   26: astore_1
    //   27: aload_3
    //   28: invokevirtual 410	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: astore_0
    //   32: aload_0
    //   33: ifnull +17 -> 50
    //   36: aload_1
    //   37: aload_0
    //   38: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_3
    //   43: invokevirtual 410	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: astore_0
    //   47: goto -15 -> 32
    //   50: new 301	org/json/JSONObject
    //   53: dup
    //   54: aload_1
    //   55: invokevirtual 238	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokespecial 302	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   61: astore_0
    //   62: aload_3
    //   63: invokevirtual 411	java/io/BufferedReader:close	()V
    //   66: aload_0
    //   67: areturn
    //   68: astore_0
    //   69: aload_0
    //   70: athrow
    //   71: astore_1
    //   72: aload_0
    //   73: astore_2
    //   74: aload_1
    //   75: astore_0
    //   76: aload_2
    //   77: ifnull +16 -> 93
    //   80: aload_3
    //   81: invokevirtual 411	java/io/BufferedReader:close	()V
    //   84: aload_0
    //   85: athrow
    //   86: astore_0
    //   87: aload_0
    //   88: invokestatic 414	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   91: aconst_null
    //   92: areturn
    //   93: aload_3
    //   94: invokevirtual 411	java/io/BufferedReader:close	()V
    //   97: goto -13 -> 84
    //   100: astore_0
    //   101: goto -14 -> 87
    //   104: astore_1
    //   105: goto -21 -> 84
    //   108: astore_0
    //   109: aconst_null
    //   110: astore_2
    //   111: goto -35 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramInputStream	java.io.InputStream
    //   26	29	1	localStringBuilder	StringBuilder
    //   71	4	1	localObject	Object
    //   104	1	1	localThrowable	Throwable
    //   73	38	2	localInputStream	java.io.InputStream
    //   18	76	3	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   19	32	68	java/lang/Throwable
    //   36	47	68	java/lang/Throwable
    //   50	62	68	java/lang/Throwable
    //   69	71	71	finally
    //   0	19	86	java/io/IOException
    //   62	66	86	java/io/IOException
    //   80	84	86	java/io/IOException
    //   84	86	86	java/io/IOException
    //   93	97	86	java/io/IOException
    //   0	19	100	org/json/JSONException
    //   62	66	100	org/json/JSONException
    //   80	84	100	org/json/JSONException
    //   84	86	100	org/json/JSONException
    //   93	97	100	org/json/JSONException
    //   80	84	104	java/lang/Throwable
    //   19	32	108	finally
    //   36	47	108	finally
    //   50	62	108	finally
  }
  
  public static HashMap<String, Boolean> b()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = new HttpGet(aut.f);
    Object localObject2 = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout((HttpParams)localObject2, 15000);
    HttpConnectionParams.setSoTimeout((HttpParams)localObject2, 30000);
    HttpProtocolParams.setUserAgent((HttpParams)localObject2, ape.a());
    localObject2 = new DefaultHttpClient((HttpParams)localObject2);
    ((DefaultHttpClient)localObject2).removeRequestInterceptorByClass(RequestExpectContinue.class);
    localObject2 = ((DefaultHttpClient)localObject2).execute((HttpUriRequest)localObject1);
    int k = ((HttpResponse)localObject2).getStatusLine().getStatusCode();
    if (k != 200)
    {
      Log.e("http/serverstatus/error status=" + k);
      return localHashMap;
    }
    localObject1 = new StringBuilder();
    localObject2 = new InputStreamReader(((HttpResponse)localObject2).getEntity().getContent(), "UTF-8");
    Object localObject3 = new char['က'];
    for (;;)
    {
      k = ((Reader)localObject2).read((char[])localObject3);
      if (k < 0) {
        break;
      }
      ((StringBuilder)localObject1).append((char[])localObject3, 0, k);
    }
    ((Reader)localObject2).close();
    localObject1 = ((StringBuilder)localObject1).toString();
    for (;;)
    {
      String str;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        localObject2 = ((JSONObject)localObject1).keys();
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localObject3 = (String)((Iterator)localObject2).next();
        str = ((JSONObject)localObject1).getJSONObject((String)localObject3).getString("available");
        if ("false".equals(str))
        {
          localHashMap.put(localObject3, Boolean.FALSE);
          continue;
        }
        if (!"true".equals(str)) {
          break label287;
        }
      }
      catch (JSONException localJSONException)
      {
        throw new IOException("error parsing json", localJSONException);
      }
      localJSONException.put(localObject3, Boolean.TRUE);
      continue;
      label287:
      Log.e("http/serverstatus/error " + (String)localObject3 + "=" + str);
    }
    return localJSONException;
  }
  
  private void b(List<Pair<String, byte[]>> paramList)
  {
    try
    {
      com.whatsapp.a.c.a.submit(c.a(this, paramList)).get();
      return;
    }
    catch (InterruptedException paramList)
    {
      throw new AssertionError(paramList);
    }
    catch (ExecutionException paramList)
    {
      for (;;) {}
    }
  }
  
  private void c(List<Pair<String, byte[]>> paramList)
  {
    paramList.add(Pair.create("network_radio_type", String.valueOf(pb.a(this.e)).getBytes()));
    Object localObject = bc.a(this.e, this.i);
    int k;
    if ((localObject != null) && (((String)localObject).length() >= 6))
    {
      k = 1;
      if (k == 0) {
        break label180;
      }
      localObject = "1";
      label61:
      paramList.add(Pair.create("simnum", ((String)localObject).getBytes()));
      String str = bc.a(this.e, this.i);
      if (av.f())
      {
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        paramList.add(Pair.create("s", ((String)localObject).getBytes()));
      }
      if (!r.k()) {
        break label187;
      }
    }
    label180:
    label187:
    for (localObject = "1";; localObject = "0")
    {
      paramList.add(Pair.create("hasinrc", ((String)localObject).getBytes()));
      paramList.add(Pair.create("pid", String.valueOf(Process.myPid()).getBytes()));
      return;
      k = 0;
      break;
      localObject = "0";
      break label61;
    }
  }
  
  public final c a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, String paramString, byte[] paramArrayOfByte4)
  {
    String str1 = this.f.d();
    String str2 = this.f.c();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("cc", paramArrayOfByte1));
    localArrayList.add(Pair.create("in", paramArrayOfByte2));
    localArrayList.add(Pair.create("lg", str1.getBytes()));
    localArrayList.add(Pair.create("lc", str2.getBytes()));
    localArrayList.add(Pair.create("id", paramArrayOfByte3));
    localArrayList.add(Pair.create("token", paramString.getBytes()));
    localArrayList.add(Pair.create("mistyped", paramArrayOfByte4));
    b(localArrayList);
    c(localArrayList);
    paramArrayOfByte1 = a(localArrayList);
    paramArrayOfByte1 = d.b(this.h, aut.b + paramArrayOfByte1);
    if (paramArrayOfByte1 == null) {
      throw new IOException("no response");
    }
    int k = paramArrayOfByte1.getStatusLine().getStatusCode();
    if (k != 200)
    {
      Log.e("http/checkreinstall/error status=" + k);
      throw new IOException("bad http status code: " + k);
    }
    paramArrayOfByte2 = a(paramArrayOfByte1.getEntity().getContent());
    if (paramArrayOfByte2 == null) {
      throw new JSONException("cannot parse JSON from server");
    }
    paramArrayOfByte1 = paramArrayOfByte2.getString("status");
    if (paramArrayOfByte1 == null)
    {
      Log.e("http/checkreinstall/status/error-no-status");
      throw new IOException("no status");
    }
    if (paramArrayOfByte1.equals("ok"))
    {
      paramArrayOfByte1 = paramArrayOfByte2.getString("login");
      boolean bool = "new".equals(paramArrayOfByte2.optString("type"));
      if (paramArrayOfByte1 == null)
      {
        Log.e("http/checkreinstall/status/error-status-ok-missing-data");
        throw new IOException("ok status but missing data");
      }
      return new c(d.a, paramArrayOfByte1, bool);
    }
    if ("fail".equals(paramArrayOfByte1))
    {
      paramArrayOfByte1 = paramArrayOfByte2.getString("reason");
      if ("blocked".equals(paramArrayOfByte1)) {
        paramArrayOfByte1 = new c(d.b, b.b);
      }
      for (;;)
      {
        paramArrayOfByte1.f = paramArrayOfByte2.optInt("voice_length");
        paramArrayOfByte1.g = paramArrayOfByte2.optInt("sms_length");
        return paramArrayOfByte1;
        if ("incorrect".equals(paramArrayOfByte1))
        {
          paramArrayOfByte1 = new c(d.b, b.a);
          paramArrayOfByte1.h = paramArrayOfByte2.optString("sms_wait", null);
          paramArrayOfByte1.i = paramArrayOfByte2.optString("voice_wait", null);
          paramArrayOfByte1.o = paramArrayOfByte2.optBoolean("business", false);
        }
        else if ("length_long".equals(paramArrayOfByte1))
        {
          paramArrayOfByte1 = new c(d.b, b.c);
        }
        else if ("length_short".equals(paramArrayOfByte1))
        {
          paramArrayOfByte1 = new c(d.b, b.d);
        }
        else if ("format_wrong".equals(paramArrayOfByte1))
        {
          paramArrayOfByte1 = new c(d.b, b.e);
        }
        else if ("temporarily_unavailable".equals(paramArrayOfByte1))
        {
          paramArrayOfByte1 = new c(d.b, b.f);
          paramArrayOfByte1.e = paramArrayOfByte2.optString("retry_after", null);
        }
        else if ("old_version".equals(paramArrayOfByte1))
        {
          paramArrayOfByte1 = new c(d.b, b.g);
        }
        else if ("bad_token".equals(paramArrayOfByte1))
        {
          paramArrayOfByte1 = new c(d.b, b.h);
        }
        else if ("invalid_skey".equals(paramArrayOfByte1))
        {
          paramArrayOfByte1 = new c(d.b, b.i);
        }
        else
        {
          if (!"security_code".equals(paramArrayOfByte1)) {
            break;
          }
          paramArrayOfByte1 = new c(d.b, b.j);
          paramArrayOfByte1.j = paramArrayOfByte2.optLong("server_time");
          paramArrayOfByte1.k = paramArrayOfByte2.optString("wipe_type", null);
          paramArrayOfByte1.l = paramArrayOfByte2.optString("wipe_token", null);
          paramArrayOfByte1.m = paramArrayOfByte2.optLong("wipe_wait");
          paramArrayOfByte1.n = paramArrayOfByte2.optLong("min_poll");
        }
      }
      Log.e("http/checkreinstall/fail/reason: unknown reason: " + paramArrayOfByte1);
      throw new IOException("fail, unknown reason");
    }
    Log.e("http/checkreinstall/result/error/unknown-status " + paramArrayOfByte1);
    throw new IOException("unknown status");
  }
  
  public final f a(String paramString1, String paramString2, String paramString3, ad paramad1, ad paramad2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    String str1 = this.f.c();
    String str2 = this.f.d();
    if ((!paramString4.equals("sms")) && (!paramString4.equals("voice")) && (!paramString4.equals("self")))
    {
      Log.e("http/requestcode/method/illegal " + paramString4);
      throw new IllegalArgumentException("method");
    }
    String str3 = bc.a(paramString2);
    Object localObject = r.c(str3);
    paramString2 = (String)localObject;
    if (localObject == null)
    {
      paramString2 = r.i();
      r.a(paramString2, str3);
    }
    localObject = new ArrayList();
    if (paramString7 != null) {
      ((List)localObject).add(Pair.create("mistyped", paramString7.getBytes()));
    }
    ((List)localObject).add(Pair.create("cc", paramString1.getBytes()));
    ((List)localObject).add(Pair.create("in", paramString3.getBytes()));
    ((List)localObject).add(Pair.create("id", paramString2));
    ((List)localObject).add(Pair.create("lg", str2.getBytes()));
    ((List)localObject).add(Pair.create("lc", str1.getBytes()));
    ((List)localObject).add(Pair.create("mcc", paramad1.a.getBytes()));
    ((List)localObject).add(Pair.create("mnc", paramad1.b.getBytes()));
    ((List)localObject).add(Pair.create("sim_mcc", paramad2.a.getBytes()));
    ((List)localObject).add(Pair.create("sim_mnc", paramad2.b.getBytes()));
    ((List)localObject).add(Pair.create("method", paramString4.getBytes()));
    ((List)localObject).add(Pair.create("reason", paramString5.getBytes()));
    ((List)localObject).add(Pair.create("token", paramString6.getBytes()));
    b((List)localObject);
    c((List)localObject);
    paramString1 = a((List)localObject);
    paramString1 = d.b(this.h, aut.c + paramString1);
    if (paramString1 == null) {
      throw new IOException("no response");
    }
    int k = paramString1.getStatusLine().getStatusCode();
    if (k != 200)
    {
      Log.e("http/requestcode/error status=" + k);
      paramString1 = new f(g.d);
    }
    do
    {
      return paramString1;
      paramString3 = a(paramString1.getEntity().getContent());
      if (paramString3 == null) {
        throw new JSONException("cannot parse JSON from server");
      }
      paramString2 = new f(g.d);
      paramString1 = paramString3.getString("status");
      if (paramString1 == null)
      {
        Log.e("http/requestcode/status/error-no-status");
        return paramString2;
      }
      if (paramString1.equals("ok"))
      {
        paramString1 = paramString3.getString("login");
        boolean bool = "new".equals(paramString3.optString("type"));
        if (paramString1 == null)
        {
          Log.e("http/checkreinstall/status/error-status-ok-no-login");
          throw new IOException("ok status but login is null");
        }
        paramString2.a = g.c;
        paramString2.b = paramString1;
        paramString2.f = bool;
        return paramString2;
      }
      if (paramString1.equals("sent")) {
        try
        {
          paramString2.d = paramString3.getInt("length");
          paramString2.c = paramString3.optString("retry_after", null);
          paramString2.h = paramString3.optString("sms_wait", null);
          paramString2.i = paramString3.optString("voice_wait", null);
          paramString2.a = g.a;
          return paramString2;
        }
        catch (JSONException paramString1)
        {
          Log.w("http/requestcode/success/length-or-time-not-found");
          paramString2.a = g.d;
          return paramString2;
        }
      }
      if (paramString1.equals("attached"))
      {
        paramString2.h = paramString3.optString("sms_wait", null);
        paramString2.i = paramString3.optString("voice_wait", null);
        paramString1 = paramString3.getString("code");
        if (paramString1 == null)
        {
          Log.w("http/request/code/attached/no-code-found");
          paramString2.a = g.d;
          return paramString2;
        }
        paramString2.a = g.b;
        paramString2.e = paramString1;
        paramString2.c = paramString3.optString("retry_after", null);
        return paramString2;
      }
      if (!paramString1.equals("fail")) {
        break;
      }
      paramad1 = paramString3.getString("reason");
      paramString2.c = paramString3.optString("retry_after", null);
      paramString2.g = paramString3.optString("param", null);
      paramString2.h = paramString3.optString("sms_wait", null);
      paramString2.i = paramString3.optString("voice_wait", null);
      if (paramad1 == null)
      {
        Log.w("http/requestcode/fail/no-reason-given");
        paramString2.a = g.d;
        return paramString2;
      }
      if (paramad1.equals("too_recent"))
      {
        paramString2.a = g.f;
        return paramString2;
      }
      if (paramad1.equals("too_many"))
      {
        paramString2.a = g.g;
        return paramString2;
      }
      if (paramad1.equals("old_version"))
      {
        paramString2.a = g.h;
        return paramString2;
      }
      if (paramad1.equals("temporarily_unavailable"))
      {
        paramString2.a = g.i;
        return paramString2;
      }
      if (paramad1.equals("next_method"))
      {
        paramString2.a = g.j;
        return paramString2;
      }
      if (paramad1.equals("too_many_guesses"))
      {
        paramString2.a = g.k;
        return paramString2;
      }
      if (paramad1.equals("blocked"))
      {
        Log.e("http/requestcode/result/error/blocked");
        paramString2.a = g.l;
        return paramString2;
      }
      if (paramad1.equals("bad_param"))
      {
        Log.e("http/requestcode/result/error/badparam/" + paramString2.g);
        paramString2.a = g.m;
        return paramString2;
      }
      if (paramad1.equals("missing_param"))
      {
        Log.e("http/requestcode/result/error/missing-param/" + paramString2.g);
        paramString2.a = g.n;
        return paramString2;
      }
      if (paramad1.equals("provider_timeout"))
      {
        Log.e("http/requestcode/result/error/provider-timeout");
        paramString2.a = g.o;
        return paramString2;
      }
      if (paramad1.equals("provider_unroutable"))
      {
        Log.e("http/requestcode/result/error/provider-unroutable");
        paramString2.a = g.p;
        return paramString2;
      }
      if (paramad1.equals("bad_token"))
      {
        Log.e("http/requestcode/result/error/bad-token");
        paramString2.a = g.q;
        return paramString2;
      }
      if (paramad1.equals("too_many_all_methods"))
      {
        Log.e("http/requestcode/result/error/too-many-all-methods");
        paramString2.a = g.r;
        return paramString2;
      }
      if (paramad1.equals("no_routes"))
      {
        Log.e("http/requestcode/result/error/no-routes");
        paramString2.a = g.s;
        return paramString2;
      }
      if (paramad1.equals("invalid_skey"))
      {
        Log.e("http/requestcode/result/error/invalid-skey");
        paramString2.a = g.t;
        return paramString2;
      }
      paramString1 = paramString2;
    } while (!paramad1.equals("security_code"));
    paramString2.a = g.u;
    paramString2.j = paramString3.optString("wipe_type", null);
    paramString2.k = paramString3.optString("wipe_token", null);
    paramString2.l = paramString3.optLong("wipe_wait");
    return paramString2;
    Log.e("http/requestcode/result/error/unknown-status " + paramString1);
    return paramString2;
  }
  
  public final h a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return a(paramString1, paramString2, null, paramString3, paramString4);
  }
  
  public final h a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    String str1 = this.f.c();
    String str2 = this.f.d();
    String str3 = bc.a(paramString1 + paramString2);
    Object localObject2 = r.c(str3);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = r.i();
      r.a((byte[])localObject1, str3);
    }
    localObject2 = new ArrayList();
    ((List)localObject2).add(Pair.create("cc", paramString1.getBytes()));
    ((List)localObject2).add(Pair.create("in", paramString2.getBytes()));
    ((List)localObject2).add(Pair.create("lg", str2.getBytes()));
    ((List)localObject2).add(Pair.create("lc", str1.getBytes()));
    ((List)localObject2).add(Pair.create("id", localObject1));
    if (paramString3 != null) {
      ((List)localObject2).add(Pair.create("code", paramString3.getBytes()));
    }
    if (paramString4 != null)
    {
      ((List)localObject2).add(Pair.create("reset", paramString4.getBytes()));
      if ("wipe".equals(paramString4))
      {
        if (TextUtils.isEmpty(paramString5)) {
          break label334;
        }
        ((List)localObject2).add(Pair.create("wipe_token", paramString5.getBytes()));
      }
    }
    b((List)localObject2);
    c((List)localObject2);
    paramString1 = a((List)localObject2);
    try
    {
      paramString1 = aut.e + paramString1;
      paramString1 = d.b(this.h, paramString1);
      if (paramString1 == null) {
        throw new IOException("no response");
      }
    }
    catch (HttpException paramString1)
    {
      Log.e("http/verifysecuritycode/httperror");
      paramString1 = new h(i.b);
    }
    label334:
    label569:
    do
    {
      do
      {
        return paramString1;
        Log.w("http/verifysecuritycode attempting to wipe account without a valid wipe token");
        break;
        int k = paramString1.getStatusLine().getStatusCode();
        if (k != 200)
        {
          Log.e("http/verifysecuritycode/error status=" + k);
          return new h(i.b);
        }
        paramString1 = a(paramString1.getEntity().getContent());
        if (paramString1 == null) {
          throw new JSONException("cannot parse JSON from server");
        }
        paramString2 = new h(i.b);
        paramString3 = paramString1.getString("status");
        if (paramString3 == null)
        {
          Log.e("http/verifysecuritycode/status/error-no-status");
          return paramString2;
        }
        if (!paramString3.equals("ok")) {
          break label569;
        }
        paramString3 = paramString1.getString("login");
        if (paramString3 == null)
        {
          Log.e("http/verifysecuritycode/status/error status ok but missing info. login=null");
          throw new IOException("ok status but required data missing");
        }
        paramString2.a = i.a;
        paramString2.b = paramString3;
        paramString2.j = "new".equals(paramString1.optString("type"));
        paramString2.k = paramString1.optBoolean("security_code_set", false);
        paramString3 = paramString1.optString("cert", null);
        paramString1 = paramString2;
      } while (paramString3 == null);
      Log.i("http/verifysecuritycode/has-cert");
      paramString2.l = Base64.decode(paramString3, 0);
      return paramString2;
      if (!paramString3.equals("fail")) {
        break label795;
      }
      paramString2.e = paramString1.optString("wipe_type", null);
      paramString2.f = paramString1.optString("wipe_token", null);
      paramString2.g = paramString1.optLong("wipe_wait");
      paramString3 = paramString1.getString("reason");
      paramString1 = paramString1.optString("guess_wait", null);
      if ("incorrect".equals(paramString3))
      {
        paramString2.a = i.d;
        return paramString2;
      }
      if ("mismatch".equals(paramString3))
      {
        paramString2.a = i.e;
        paramString2.c = paramString1;
        return paramString2;
      }
      if ("too_many_guesses".equals(paramString3))
      {
        paramString2.a = i.f;
        return paramString2;
      }
      if ("guessed_too_fast".equals(paramString3))
      {
        paramString2.a = i.g;
        paramString2.c = paramString1;
        return paramString2;
      }
      if ("reset_too_soon".equals(paramString3))
      {
        paramString2.a = i.h;
        return paramString2;
      }
      if ("stale".equals(paramString3))
      {
        paramString2.a = i.i;
        return paramString2;
      }
      if ("temporarily_unavailable".equals(paramString3))
      {
        paramString2.a = i.j;
        return paramString2;
      }
      paramString1 = paramString2;
    } while (!"blocked".equals(paramString3));
    paramString2.a = i.k;
    return paramString2;
    label795:
    if (paramString3.equals("sent"))
    {
      paramString2.a = i.a;
      paramString2.d = paramString1.optLong("server_time");
      paramString2.e = paramString1.optString("wipe_type");
      paramString2.f = paramString1.optString("wipe_token");
      paramString2.g = paramString1.optLong("wipe_wait");
      paramString2.h = paramString1.optLong("wipe_expiry_time");
      paramString2.i = paramString1.optLong("min_poll");
      return paramString2;
    }
    Log.e("http/verifysecuritycode/result/error/unknown-status " + paramString3);
    return paramString2;
  }
  
  public final j a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    String str1 = this.f.c();
    String str2 = this.f.d();
    String str3 = bc.a(paramString1 + paramString2);
    Object localObject2 = r.c(str3);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = r.i();
      r.a((byte[])localObject1, str3);
    }
    localObject2 = new ArrayList();
    if (paramString4 != null) {
      ((List)localObject2).add(Pair.create("mistyped", paramString4.getBytes()));
    }
    ((List)localObject2).add(Pair.create("cc", paramString1.getBytes()));
    ((List)localObject2).add(Pair.create("in", paramString2.getBytes()));
    ((List)localObject2).add(Pair.create("lg", str2.getBytes()));
    ((List)localObject2).add(Pair.create("lc", str1.getBytes()));
    ((List)localObject2).add(Pair.create("id", localObject1));
    ((List)localObject2).add(Pair.create("code", paramString3.getBytes()));
    switch (1.a[(paramInt - 1)])
    {
    default: 
      Log.w("http/entrymethod/unknown");
      paramInt = 0;
      ((List)localObject2).add(Pair.create("entered", String.valueOf(paramInt).getBytes()));
      b((List)localObject2);
      c((List)localObject2);
      paramString1 = a((List)localObject2);
    }
    label386:
    do
    {
      for (;;)
      {
        try
        {
          paramString1 = aut.d + paramString1;
          paramString1 = d.b(this.h, paramString1);
          if (paramString1 != null) {
            break label386;
          }
          throw new IOException("no response");
        }
        catch (HttpException paramString1)
        {
          Log.e("http/verifycode/httperror");
          paramString1 = new j(k.b);
          return paramString1;
        }
        paramInt = 1;
        break;
        paramInt = 2;
        break;
        paramInt = 3;
        break;
        paramInt = 4;
        break;
        paramInt = paramString1.getStatusLine().getStatusCode();
        if (paramInt != 200)
        {
          Log.e("http/verifycode/error status=" + paramInt);
          return new j(k.b);
        }
        paramString3 = a(paramString1.getEntity().getContent());
        if (paramString3 == null) {
          throw new JSONException("cannot parse JSON from server");
        }
        paramString2 = new j(k.b);
        paramString1 = paramString3.getString("status");
        if (paramString1 == null)
        {
          Log.e("http/verifycode/status/error-no-status");
          return paramString2;
        }
        if (paramString1.equals("ok"))
        {
          paramString1 = paramString3.getString("login");
          boolean bool = "new".equals(paramString3.optString("type"));
          if (paramString1 == null)
          {
            Log.e("http/verifycode/status/error-status-ok-no-login");
            throw new IOException("ok status but login is null");
          }
          paramString2.a = k.a;
          paramString2.b = paramString1;
          paramString2.h = bool;
          paramString1 = paramString3.optString("cert", null);
          if (paramString1 != null)
          {
            Log.i("http/verifycode/has-cert");
            paramString2.g = Base64.decode(paramString1, 0);
          }
          paramString4 = paramString3.optString("chat_dns_domain", null);
          paramString1 = paramString3.optString("edge_routing_info", null);
          bool = TextUtils.isEmpty(paramString1);
          if (!bool) {}
          try
          {
            this.g.a(Base64.decode(paramString1, 3));
            paramString1 = paramString2;
            if (!TextUtils.isEmpty(paramString4))
            {
              this.j.d(paramString4);
              return paramString2;
            }
          }
          catch (IllegalArgumentException paramString1)
          {
            for (;;)
            {
              Log.d("routing_info_helper/update_routing_info the routing info wasn't saved.", paramString1);
            }
          }
        }
      }
      if (!paramString1.equals("fail")) {
        break label933;
      }
      paramString4 = paramString3.getString("reason");
      paramString1 = paramString3.optString("retry_after", null);
      if ("blocked".equals(paramString4))
      {
        paramString2.a = k.j;
        return paramString2;
      }
      if ("mismatch".equals(paramString4))
      {
        if (paramString1 == null) {}
        for (paramString2.a = k.e;; paramString2.a = k.d)
        {
          paramString2.c = paramString1;
          return paramString2;
        }
      }
      if ("missing".equals(paramString4))
      {
        paramString2.a = k.g;
        return paramString2;
      }
      if ("too_many_guesses".equals(paramString4))
      {
        paramString2.a = k.e;
        paramString2.c = paramString1;
        return paramString2;
      }
      if ("guessed_too_fast".equals(paramString4))
      {
        paramString2.a = k.f;
        paramString2.c = paramString1;
        return paramString2;
      }
      if ("stale".equals(paramString4))
      {
        paramString2.a = k.h;
        return paramString2;
      }
      if ("temporarily_unavailable".equals(paramString4))
      {
        paramString2.a = k.i;
        paramString2.c = paramString1;
        return paramString2;
      }
      paramString1 = paramString2;
    } while (!"security_code".equals(paramString4));
    paramString2.a = k.k;
    paramString2.d = paramString3.optString("wipe_type", null);
    paramString2.e = paramString3.optString("wipe_token", null);
    paramString2.f = paramString3.optLong("wipe_wait");
    return paramString2;
    label933:
    Log.e("http/verifycode/result/error/unknown-status " + paramString1);
    return paramString2;
  }
  
  public static enum a
  {
    public static int[] a()
    {
      return (int[])e.clone();
    }
  }
  
  public static enum b {}
  
  public static final class c
  {
    public final int a;
    public final int b;
    public final String c;
    public final boolean d;
    public String e;
    public int f;
    public int g;
    public String h;
    public String i;
    public long j;
    public String k;
    public String l;
    public long m;
    public long n;
    public boolean o;
    
    c(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = null;
      this.d = false;
    }
    
    c(int paramInt, String paramString, boolean paramBoolean)
    {
      this.a = paramInt;
      this.b = 0;
      this.c = paramString;
      this.d = paramBoolean;
    }
  }
  
  public static enum d {}
  
  public static final class e
  {
    public final int a = 200;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    
    e(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this.b = paramString1;
      this.c = paramString2;
      this.d = paramString3;
      this.e = paramString4;
      this.f = paramString5;
      this.g = paramString6;
    }
  }
  
  public static final class f
  {
    public b.g a;
    public String b;
    public String c;
    public int d = 0;
    public String e;
    public boolean f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public long l;
    
    f(b.g paramg)
    {
      this.a = paramg;
    }
  }
  
  public static enum g
  {
    private g() {}
  }
  
  public static final class h
  {
    public b.i a;
    public String b;
    public String c;
    public long d;
    public String e;
    public String f;
    public long g;
    public long h;
    public long i;
    public boolean j;
    public boolean k;
    public byte[] l;
    
    h(b.i parami)
    {
      this.a = parami;
    }
  }
  
  public static enum i
  {
    private i() {}
  }
  
  public static final class j
  {
    public b.k a;
    public String b;
    public String c;
    public String d;
    public String e;
    public long f;
    public byte[] g;
    public boolean h;
    
    j(b.k paramk)
    {
      this.a = paramk;
    }
  }
  
  public static enum k
  {
    private k() {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/i/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */