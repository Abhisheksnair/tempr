package com.whatsapp;

import android.content.Context;
import com.whatsapp.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class aud
{
  private static final File f = new File(u.a().getCacheDir(), "Bing");
  public int a;
  public ArrayList<aty> b;
  public int c = 50;
  int d;
  String e;
  private final List<String> g = Arrays.asList(new String[] { "es-AR", "en-AU", "de-AT", "nl-BE", "fr-BE", "pt-BR", "en-CA", "fr-CA", "es-CL", "da-DK", "fi-FI", "fr-FR", "de-DE", "zh-HK", "en-IN", "en-ID", "en-IE", "it-IT", "ja-JP", "ko-KR", "en-MY", "es-MX", "nl-NL", "en-NZ", "no-NO", "zh-CN", "pl-PL", "pt-PT", "en-PH", "ru-RU", "ar-SA", "en-ZA", "es-ES", "sv-SE", "fr-CH", "de-CH", "zh-TW", "tr-TR", "en-GB", "en-US", "es-US" });
  
  private aud(String paramString)
  {
    this.e = paramString;
    f.mkdirs();
  }
  
  public aud(String paramString, byte paramByte)
  {
    this(paramString);
  }
  
  public static void a()
  {
    File[] arrayOfFile = f.listFiles();
    if (arrayOfFile != null)
    {
      Arrays.sort(arrayOfFile, new Comparator() {});
      int i = 0;
      while (i < arrayOfFile.length)
      {
        File localFile = arrayOfFile[i];
        if ((i <= arrayOfFile.length - 16) || (localFile.lastModified() + 86400000L <= System.currentTimeMillis())) {
          localFile.delete();
        }
        i += 1;
      }
    }
  }
  
  private void a(JSONObject paramJSONObject)
  {
    int i = 0;
    Object localObject1 = null;
    Object localObject2;
    try
    {
      localObject2 = paramJSONObject.getJSONArray("value");
      localObject1 = localObject2;
      this.a = paramJSONObject.getInt("totalEstimatedMatches");
      localObject1 = localObject2;
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        this.a = 0;
      }
      Log.i("results.length() = " + ((JSONArray)localObject1).length() + ", total:" + this.a);
    }
    if (localObject1 == null) {
      return;
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject1).length()) {
        try
        {
          paramJSONObject = new aty();
          localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          paramJSONObject.b = ((JSONObject)localObject2).getString("contentUrl");
          paramJSONObject.c = ((JSONObject)localObject2).getString("hostPageUrl");
          Object localObject3 = new Scanner(((JSONObject)localObject2).getString("contentSize"));
          paramJSONObject.d = ((Scanner)localObject3).nextInt();
          localObject3 = ((Scanner)localObject3).next();
          if (((String)localObject3).equals("KB")) {
            paramJSONObject.d *= 1000;
          }
          for (;;)
          {
            paramJSONObject.e = ((JSONObject)localObject2).getInt("width");
            paramJSONObject.f = ((JSONObject)localObject2).getInt("height");
            paramJSONObject.a = ((JSONObject)localObject2).getString("thumbnailUrl");
            if ((paramJSONObject.e < 300) || (paramJSONObject.f < 300) || (paramJSONObject.d > 512000)) {
              break;
            }
            this.b.add(paramJSONObject);
            break;
            if (((String)localObject3).equals("MB")) {
              paramJSONObject.d *= 1000000;
            }
          }
          this.d += ((JSONArray)localObject1).length();
        }
        catch (JSONException paramJSONObject) {}
      }
      Log.i(this.b.size() + " images");
      return;
      i += 1;
    }
  }
  
  /* Error */
  public final List<aty> b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 5
    //   11: aload_0
    //   12: new 276	java/util/ArrayList
    //   15: dup
    //   16: invokespecial 297	java/util/ArrayList:<init>	()V
    //   19: putfield 274	com/whatsapp/aud:b	Ljava/util/ArrayList;
    //   22: new 276	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 297	java/util/ArrayList:<init>	()V
    //   29: astore 8
    //   31: getstatic 302	com/whatsapp/aut:n	Ljava/lang/String;
    //   34: astore 9
    //   36: aload 8
    //   38: new 304	org/apache/http/message/BasicNameValuePair
    //   41: dup
    //   42: ldc_w 306
    //   45: aload_0
    //   46: getfield 143	com/whatsapp/aud:e	Ljava/lang/String;
    //   49: invokevirtual 309	java/lang/String:trim	()Ljava/lang/String;
    //   52: invokespecial 312	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   55: invokeinterface 315 2 0
    //   60: pop
    //   61: invokestatic 321	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   64: invokevirtual 324	java/util/Locale:getLanguage	()Ljava/lang/String;
    //   67: astore_2
    //   68: invokestatic 321	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   71: invokevirtual 327	java/util/Locale:getCountry	()Ljava/lang/String;
    //   74: astore 4
    //   76: new 194	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   83: aload_2
    //   84: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 329
    //   90: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload 4
    //   95: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: astore 4
    //   103: aload 4
    //   105: astore_2
    //   106: aload_0
    //   107: getfield 139	com/whatsapp/aud:g	Ljava/util/List;
    //   110: aload 4
    //   112: invokeinterface 332 2 0
    //   117: ifne +6 -> 123
    //   120: ldc -127
    //   122: astore_2
    //   123: aload 8
    //   125: new 304	org/apache/http/message/BasicNameValuePair
    //   128: dup
    //   129: ldc_w 334
    //   132: aload_2
    //   133: invokespecial 312	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: invokeinterface 315 2 0
    //   141: pop
    //   142: aload 8
    //   144: new 304	org/apache/http/message/BasicNameValuePair
    //   147: dup
    //   148: ldc_w 336
    //   151: aload_0
    //   152: getfield 283	com/whatsapp/aud:d	I
    //   155: invokestatic 341	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   158: invokespecial 312	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: invokeinterface 315 2 0
    //   166: pop
    //   167: aload 8
    //   169: new 304	org/apache/http/message/BasicNameValuePair
    //   172: dup
    //   173: ldc_w 343
    //   176: aload_0
    //   177: getfield 141	com/whatsapp/aud:c	I
    //   180: invokestatic 341	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   183: invokespecial 312	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: invokeinterface 315 2 0
    //   191: pop
    //   192: new 194	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 284	java/lang/StringBuilder:<init>	()V
    //   199: aload 9
    //   201: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: aload 8
    //   206: ldc_w 345
    //   209: invokestatic 351	org/apache/http/client/utils/URLEncodedUtils:format	(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;
    //   212: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: astore_2
    //   219: aload_2
    //   220: invokestatic 355	com/whatsapp/r:a	(Ljava/lang/String;)Ljava/lang/String;
    //   223: astore 4
    //   225: new 24	java/io/File
    //   228: dup
    //   229: getstatic 43	com/whatsapp/aud:f	Ljava/io/File;
    //   232: aload 4
    //   234: invokevirtual 356	java/lang/String:toString	()Ljava/lang/String;
    //   237: invokespecial 41	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   240: astore 4
    //   242: aload 4
    //   244: invokevirtual 359	java/io/File:exists	()Z
    //   247: ifeq +165 -> 412
    //   250: aload 4
    //   252: invokevirtual 163	java/io/File:lastModified	()J
    //   255: ldc2_w 164
    //   258: ladd
    //   259: invokestatic 170	java/lang/System:currentTimeMillis	()J
    //   262: lcmp
    //   263: ifle +149 -> 412
    //   266: new 361	java/io/ObjectInputStream
    //   269: dup
    //   270: new 363	java/io/FileInputStream
    //   273: dup
    //   274: aload 4
    //   276: invokespecial 366	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   279: invokespecial 369	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   282: astore_3
    //   283: aload_3
    //   284: astore_2
    //   285: aload_3
    //   286: invokevirtual 373	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   289: checkcast 49	java/lang/String
    //   292: astore 4
    //   294: aload_3
    //   295: invokevirtual 376	java/io/ObjectInputStream:close	()V
    //   298: aload 4
    //   300: astore_2
    //   301: aload_2
    //   302: ifnull +15 -> 317
    //   305: aload_0
    //   306: new 180	org/json/JSONObject
    //   309: dup
    //   310: aload_2
    //   311: invokespecial 377	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   314: invokespecial 379	com/whatsapp/aud:a	(Lorg/json/JSONObject;)V
    //   317: aload_0
    //   318: getfield 274	com/whatsapp/aud:b	Ljava/util/ArrayList;
    //   321: areturn
    //   322: astore_2
    //   323: aload 4
    //   325: astore_2
    //   326: goto -25 -> 301
    //   329: astore 4
    //   331: aconst_null
    //   332: astore_3
    //   333: aload_3
    //   334: astore_2
    //   335: aload 4
    //   337: invokestatic 382	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   340: aload 5
    //   342: astore_2
    //   343: aload_3
    //   344: ifnull -43 -> 301
    //   347: aload_3
    //   348: invokevirtual 376	java/io/ObjectInputStream:close	()V
    //   351: aload 5
    //   353: astore_2
    //   354: goto -53 -> 301
    //   357: astore_2
    //   358: aload 5
    //   360: astore_2
    //   361: goto -60 -> 301
    //   364: astore 4
    //   366: aconst_null
    //   367: astore_3
    //   368: aload_3
    //   369: astore_2
    //   370: aload 4
    //   372: invokestatic 382	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   375: aload 5
    //   377: astore_2
    //   378: aload_3
    //   379: ifnull -78 -> 301
    //   382: aload_3
    //   383: invokevirtual 376	java/io/ObjectInputStream:close	()V
    //   386: aload 5
    //   388: astore_2
    //   389: goto -88 -> 301
    //   392: astore_2
    //   393: aload 5
    //   395: astore_2
    //   396: goto -95 -> 301
    //   399: astore_3
    //   400: aconst_null
    //   401: astore_2
    //   402: aload_2
    //   403: ifnull +7 -> 410
    //   406: aload_2
    //   407: invokevirtual 376	java/io/ObjectInputStream:close	()V
    //   410: aload_3
    //   411: athrow
    //   412: aload 4
    //   414: invokevirtual 173	java/io/File:delete	()Z
    //   417: pop
    //   418: new 384	org/apache/http/client/methods/HttpGet
    //   421: dup
    //   422: aload_2
    //   423: invokespecial 385	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   426: astore_2
    //   427: new 387	org/apache/http/params/BasicHttpParams
    //   430: dup
    //   431: invokespecial 388	org/apache/http/params/BasicHttpParams:<init>	()V
    //   434: astore 5
    //   436: aload 5
    //   438: sipush 15000
    //   441: invokestatic 394	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   444: aload 5
    //   446: sipush 30000
    //   449: invokestatic 397	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   452: aload 5
    //   454: invokestatic 401	com/whatsapp/ape:a	()Ljava/lang/String;
    //   457: invokestatic 407	org/apache/http/params/HttpProtocolParams:setUserAgent	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   460: new 409	org/apache/http/impl/client/DefaultHttpClient
    //   463: dup
    //   464: aload 5
    //   466: invokespecial 412	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   469: aload_2
    //   470: invokevirtual 416	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   473: astore_2
    //   474: aload_2
    //   475: invokeinterface 422 1 0
    //   480: invokeinterface 427 1 0
    //   485: istore_1
    //   486: iload_1
    //   487: sipush 200
    //   490: if_icmpne +125 -> 615
    //   493: aload_2
    //   494: invokeinterface 431 1 0
    //   499: invokestatic 436	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   502: astore_2
    //   503: new 438	java/io/ObjectOutputStream
    //   506: dup
    //   507: new 440	java/io/FileOutputStream
    //   510: dup
    //   511: aload 4
    //   513: invokespecial 441	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   516: invokespecial 444	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   519: astore 4
    //   521: aload 4
    //   523: aload_2
    //   524: invokevirtual 448	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   527: aload 4
    //   529: invokevirtual 449	java/io/ObjectOutputStream:close	()V
    //   532: goto -231 -> 301
    //   535: astore_3
    //   536: goto -235 -> 301
    //   539: astore 5
    //   541: aload 6
    //   543: astore 4
    //   545: aload 4
    //   547: astore_3
    //   548: aload 5
    //   550: invokestatic 382	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   553: aload 4
    //   555: ifnull +57 -> 612
    //   558: aload 4
    //   560: invokevirtual 449	java/io/ObjectOutputStream:close	()V
    //   563: goto -262 -> 301
    //   566: astore_3
    //   567: goto -266 -> 301
    //   570: astore 5
    //   572: aload 7
    //   574: astore 4
    //   576: aload 4
    //   578: astore_3
    //   579: aload 5
    //   581: invokestatic 382	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   584: aload 4
    //   586: ifnull +26 -> 612
    //   589: aload 4
    //   591: invokevirtual 449	java/io/ObjectOutputStream:close	()V
    //   594: goto -293 -> 301
    //   597: astore_3
    //   598: goto -297 -> 301
    //   601: astore_2
    //   602: aload_3
    //   603: ifnull +7 -> 610
    //   606: aload_3
    //   607: invokevirtual 449	java/io/ObjectOutputStream:close	()V
    //   610: aload_2
    //   611: athrow
    //   612: goto -311 -> 301
    //   615: new 292	java/io/IOException
    //   618: dup
    //   619: new 194	java/lang/StringBuilder
    //   622: dup
    //   623: ldc_w 451
    //   626: invokespecial 197	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   629: iload_1
    //   630: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   633: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   636: invokespecial 452	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   639: athrow
    //   640: astore_2
    //   641: goto -231 -> 410
    //   644: astore_3
    //   645: goto -35 -> 610
    //   648: astore_2
    //   649: aload 4
    //   651: astore_3
    //   652: goto -50 -> 602
    //   655: astore 5
    //   657: goto -81 -> 576
    //   660: astore 5
    //   662: goto -117 -> 545
    //   665: astore_3
    //   666: goto -264 -> 402
    //   669: astore 4
    //   671: goto -303 -> 368
    //   674: astore 4
    //   676: goto -343 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	679	0	this	aud
    //   485	145	1	i	int
    //   67	244	2	localObject1	Object
    //   322	1	2	localIOException1	java.io.IOException
    //   325	29	2	localObject2	Object
    //   357	1	2	localIOException2	java.io.IOException
    //   360	29	2	localObject3	Object
    //   392	1	2	localIOException3	java.io.IOException
    //   395	129	2	localObject4	Object
    //   601	10	2	localObject5	Object
    //   640	1	2	localIOException4	java.io.IOException
    //   648	1	2	localObject6	Object
    //   7	376	3	localObjectInputStream	java.io.ObjectInputStream
    //   399	12	3	localObject7	Object
    //   535	1	3	localIOException5	java.io.IOException
    //   547	1	3	localObject8	Object
    //   566	1	3	localIOException6	java.io.IOException
    //   578	1	3	localObject9	Object
    //   597	10	3	localIOException7	java.io.IOException
    //   644	1	3	localIOException8	java.io.IOException
    //   651	1	3	localObject10	Object
    //   665	1	3	localObject11	Object
    //   74	250	4	localObject12	Object
    //   329	7	4	localIOException9	java.io.IOException
    //   364	148	4	localClassNotFoundException1	ClassNotFoundException
    //   519	131	4	localObject13	Object
    //   669	1	4	localClassNotFoundException2	ClassNotFoundException
    //   674	1	4	localIOException10	java.io.IOException
    //   9	456	5	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   539	10	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   570	10	5	localIOException11	java.io.IOException
    //   655	1	5	localIOException12	java.io.IOException
    //   660	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   1	541	6	localObject14	Object
    //   4	569	7	localObject15	Object
    //   29	176	8	localArrayList	ArrayList
    //   34	166	9	str	String
    // Exception table:
    //   from	to	target	type
    //   294	298	322	java/io/IOException
    //   266	283	329	java/io/IOException
    //   347	351	357	java/io/IOException
    //   266	283	364	java/lang/ClassNotFoundException
    //   382	386	392	java/io/IOException
    //   266	283	399	finally
    //   527	532	535	java/io/IOException
    //   503	521	539	java/io/FileNotFoundException
    //   558	563	566	java/io/IOException
    //   503	521	570	java/io/IOException
    //   589	594	597	java/io/IOException
    //   503	521	601	finally
    //   548	553	601	finally
    //   579	584	601	finally
    //   406	410	640	java/io/IOException
    //   606	610	644	java/io/IOException
    //   521	527	648	finally
    //   521	527	655	java/io/IOException
    //   521	527	660	java/io/FileNotFoundException
    //   285	294	665	finally
    //   335	340	665	finally
    //   370	375	665	finally
    //   285	294	669	java/lang/ClassNotFoundException
    //   285	294	674	java/io/IOException
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */