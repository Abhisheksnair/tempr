package com.whatsapp.gif_search.b;

import android.os.AsyncTask;
import android.support.v4.f.h;
import android.text.TextUtils;
import com.whatsapp.ant;
import com.whatsapp.aus;
import com.whatsapp.fieldstats.events.ab;
import com.whatsapp.gif_search.j;
import com.whatsapp.gif_search.j.a;
import com.whatsapp.gif_search.p;
import com.whatsapp.gif_search.r;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends p
{
  public a(ant paramant, aus paramaus)
  {
    super(paramant, paramaus);
  }
  
  /* Error */
  static h<String, List<j>> a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 25	java/lang/StringBuilder
    //   6: dup
    //   7: ldc 27
    //   9: invokespecial 30	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   19: invokestatic 43	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   22: invokestatic 49	java/lang/System:currentTimeMillis	()J
    //   25: lstore 4
    //   27: new 51	java/net/URL
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 52	java/net/URL:<init>	(Ljava/lang/String;)V
    //   35: invokevirtual 56	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   38: checkcast 58	javax/net/ssl/HttpsURLConnection
    //   41: astore 7
    //   43: aload 7
    //   45: ldc 60
    //   47: invokestatic 64	com/whatsapp/ape:a	()Ljava/lang/String;
    //   50: invokevirtual 68	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload 7
    //   55: sipush 15000
    //   58: invokevirtual 72	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   61: aload 7
    //   63: sipush 30000
    //   66: invokevirtual 75	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   69: aload 7
    //   71: ldc 77
    //   73: invokevirtual 80	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   76: aload 7
    //   78: invokevirtual 84	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   81: istore_1
    //   82: iload_1
    //   83: sipush 200
    //   86: if_icmpeq +67 -> 153
    //   89: new 25	java/lang/StringBuilder
    //   92: dup
    //   93: ldc 86
    //   95: invokespecial 30	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   98: iload_1
    //   99: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokestatic 92	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   108: aload 7
    //   110: ifnull +8 -> 118
    //   113: aload 7
    //   115: invokevirtual 96	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   118: new 25	java/lang/StringBuilder
    //   121: dup
    //   122: ldc 98
    //   124: invokespecial 30	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: aload_0
    //   128: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: ldc 100
    //   133: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokestatic 49	java/lang/System:currentTimeMillis	()J
    //   139: lload 4
    //   141: lsub
    //   142: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   145: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 43	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   151: aconst_null
    //   152: areturn
    //   153: new 25	java/lang/StringBuilder
    //   156: dup
    //   157: ldc 98
    //   159: invokespecial 30	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   162: aload_0
    //   163: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: ldc 105
    //   168: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokestatic 49	java/lang/System:currentTimeMillis	()J
    //   174: lload 4
    //   176: lsub
    //   177: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   180: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 43	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   186: new 107	com/google/a/b/a
    //   189: dup
    //   190: new 109	java/io/InputStreamReader
    //   193: dup
    //   194: aload 7
    //   196: invokevirtual 113	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   199: invokespecial 116	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   202: invokespecial 119	com/google/a/b/a:<init>	(Ljava/io/Reader;)V
    //   205: astore 10
    //   207: aload 10
    //   209: invokevirtual 122	com/google/a/b/a:c	()V
    //   212: aconst_null
    //   213: astore 8
    //   215: ldc2_w 123
    //   218: lstore_2
    //   219: aconst_null
    //   220: astore 9
    //   222: aconst_null
    //   223: astore 6
    //   225: aload 10
    //   227: invokevirtual 127	com/google/a/b/a:e	()Z
    //   230: ifeq +312 -> 542
    //   233: aload 9
    //   235: ifnonnull +307 -> 542
    //   238: aload 10
    //   240: invokevirtual 130	com/google/a/b/a:f	()Ljava/lang/String;
    //   243: astore 11
    //   245: iconst_m1
    //   246: istore_1
    //   247: aload 11
    //   249: invokevirtual 135	java/lang/String:hashCode	()I
    //   252: lookupswitch	default:+562->814, -791787109:+228->480, 3059181:+183->435, 3377907:+198->450, 96784904:+168->420, 1097546742:+213->465
    //   304: new 25	java/lang/StringBuilder
    //   307: dup
    //   308: ldc -119
    //   310: invokespecial 30	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   313: aload 11
    //   315: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 140	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   324: aload 10
    //   326: invokevirtual 143	com/google/a/b/a:j	()V
    //   329: goto -104 -> 225
    //   332: astore 6
    //   334: aload 6
    //   336: athrow
    //   337: astore 8
    //   339: aload 6
    //   341: astore 9
    //   343: aload 8
    //   345: astore 6
    //   347: aload 9
    //   349: ifnull +287 -> 636
    //   352: aload 10
    //   354: invokevirtual 146	com/google/a/b/a:close	()V
    //   357: aload 6
    //   359: athrow
    //   360: astore 8
    //   362: aload 7
    //   364: astore 6
    //   366: aload 8
    //   368: astore 7
    //   370: aload 7
    //   372: invokestatic 149	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   375: aload 6
    //   377: ifnull +8 -> 385
    //   380: aload 6
    //   382: invokevirtual 96	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   385: new 25	java/lang/StringBuilder
    //   388: dup
    //   389: ldc 98
    //   391: invokespecial 30	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   394: aload_0
    //   395: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: ldc 100
    //   400: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokestatic 49	java/lang/System:currentTimeMillis	()J
    //   406: lload 4
    //   408: lsub
    //   409: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   412: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 43	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   418: aconst_null
    //   419: areturn
    //   420: aload 11
    //   422: ldc -105
    //   424: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   427: ifeq +387 -> 814
    //   430: iconst_0
    //   431: istore_1
    //   432: goto +382 -> 814
    //   435: aload 11
    //   437: ldc -99
    //   439: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   442: ifeq +372 -> 814
    //   445: iconst_1
    //   446: istore_1
    //   447: goto +367 -> 814
    //   450: aload 11
    //   452: ldc -97
    //   454: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   457: ifeq +357 -> 814
    //   460: iconst_2
    //   461: istore_1
    //   462: goto +352 -> 814
    //   465: aload 11
    //   467: ldc -95
    //   469: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   472: ifeq +342 -> 814
    //   475: iconst_3
    //   476: istore_1
    //   477: goto +337 -> 814
    //   480: aload 11
    //   482: ldc -93
    //   484: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   487: ifeq +327 -> 814
    //   490: iconst_4
    //   491: istore_1
    //   492: goto +322 -> 814
    //   495: aload 10
    //   497: invokevirtual 166	com/google/a/b/a:g	()Ljava/lang/String;
    //   500: astore 9
    //   502: goto -277 -> 225
    //   505: aload 10
    //   507: invokevirtual 169	com/google/a/b/a:h	()J
    //   510: lstore_2
    //   511: goto -286 -> 225
    //   514: aload 10
    //   516: invokevirtual 166	com/google/a/b/a:g	()Ljava/lang/String;
    //   519: astore 6
    //   521: goto -296 -> 225
    //   524: aload 10
    //   526: invokestatic 172	com/whatsapp/gif_search/b/a:a	(Lcom/google/a/b/a;)Ljava/util/List;
    //   529: astore 8
    //   531: goto -306 -> 225
    //   534: aload 10
    //   536: invokevirtual 143	com/google/a/b/a:j	()V
    //   539: goto -314 -> 225
    //   542: aload 10
    //   544: invokevirtual 174	com/google/a/b/a:d	()V
    //   547: aload 10
    //   549: invokevirtual 146	com/google/a/b/a:close	()V
    //   552: aload 9
    //   554: ifnull +138 -> 692
    //   557: new 25	java/lang/StringBuilder
    //   560: dup
    //   561: ldc -80
    //   563: invokespecial 30	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   566: lload_2
    //   567: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   570: ldc -78
    //   572: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: aload 9
    //   577: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: ldc -76
    //   582: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokestatic 140	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   591: aload 7
    //   593: ifnull +8 -> 601
    //   596: aload 7
    //   598: invokevirtual 96	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   601: new 25	java/lang/StringBuilder
    //   604: dup
    //   605: ldc 98
    //   607: invokespecial 30	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   610: aload_0
    //   611: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: ldc 100
    //   616: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: invokestatic 49	java/lang/System:currentTimeMillis	()J
    //   622: lload 4
    //   624: lsub
    //   625: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   628: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: invokestatic 43	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   634: aconst_null
    //   635: areturn
    //   636: aload 10
    //   638: invokevirtual 146	com/google/a/b/a:close	()V
    //   641: goto -284 -> 357
    //   644: astore 6
    //   646: aload 7
    //   648: ifnull +8 -> 656
    //   651: aload 7
    //   653: invokevirtual 96	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   656: new 25	java/lang/StringBuilder
    //   659: dup
    //   660: ldc 98
    //   662: invokespecial 30	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   665: aload_0
    //   666: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: ldc 100
    //   671: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: invokestatic 49	java/lang/System:currentTimeMillis	()J
    //   677: lload 4
    //   679: lsub
    //   680: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   683: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   686: invokestatic 43	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   689: aload 6
    //   691: athrow
    //   692: aload 6
    //   694: astore 9
    //   696: ldc -74
    //   698: aload 6
    //   700: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   703: ifeq +6 -> 709
    //   706: aconst_null
    //   707: astore 9
    //   709: aload 8
    //   711: ifnonnull +56 -> 767
    //   714: aconst_null
    //   715: aconst_null
    //   716: invokestatic 187	android/support/v4/f/h:a	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/support/v4/f/h;
    //   719: astore 6
    //   721: aload 7
    //   723: ifnull +8 -> 731
    //   726: aload 7
    //   728: invokevirtual 96	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   731: new 25	java/lang/StringBuilder
    //   734: dup
    //   735: ldc 98
    //   737: invokespecial 30	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   740: aload_0
    //   741: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: ldc 100
    //   746: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: invokestatic 49	java/lang/System:currentTimeMillis	()J
    //   752: lload 4
    //   754: lsub
    //   755: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   758: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   761: invokestatic 43	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   764: aload 6
    //   766: areturn
    //   767: aload 9
    //   769: aload 8
    //   771: invokestatic 187	android/support/v4/f/h:a	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/support/v4/f/h;
    //   774: astore 6
    //   776: goto -55 -> 721
    //   779: astore 8
    //   781: goto -424 -> 357
    //   784: astore 6
    //   786: aload 8
    //   788: astore 7
    //   790: goto -144 -> 646
    //   793: astore 8
    //   795: aload 6
    //   797: astore 7
    //   799: aload 8
    //   801: astore 6
    //   803: goto -157 -> 646
    //   806: astore 7
    //   808: aconst_null
    //   809: astore 6
    //   811: goto -441 -> 370
    //   814: iload_1
    //   815: tableswitch	default:+33->848, 0:+-320->495, 1:+-310->505, 2:+-301->514, 3:+-291->524, 4:+-281->534
    //   848: goto -544 -> 304
    //   851: astore 6
    //   853: aconst_null
    //   854: astore 9
    //   856: goto -509 -> 347
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	859	0	paramString	String
    //   81	734	1	i	int
    //   218	349	2	l1	long
    //   25	728	4	l2	long
    //   223	1	6	localObject1	Object
    //   332	8	6	localThrowable1	Throwable
    //   345	175	6	localObject2	Object
    //   644	55	6	localObject3	Object
    //   719	56	6	localh	h
    //   784	12	6	localObject4	Object
    //   801	9	6	localObject5	Object
    //   851	1	6	localObject6	Object
    //   41	757	7	localObject7	Object
    //   806	1	7	localIOException1	java.io.IOException
    //   1	213	8	localObject8	Object
    //   337	7	8	localObject9	Object
    //   360	7	8	localIOException2	java.io.IOException
    //   529	241	8	localList	List
    //   779	8	8	localThrowable2	Throwable
    //   793	7	8	localObject10	Object
    //   220	635	9	localObject11	Object
    //   205	432	10	locala	com.google.a.b.a
    //   243	238	11	str	String
    // Exception table:
    //   from	to	target	type
    //   207	212	332	java/lang/Throwable
    //   225	233	332	java/lang/Throwable
    //   238	245	332	java/lang/Throwable
    //   247	304	332	java/lang/Throwable
    //   304	329	332	java/lang/Throwable
    //   420	430	332	java/lang/Throwable
    //   435	445	332	java/lang/Throwable
    //   450	460	332	java/lang/Throwable
    //   465	475	332	java/lang/Throwable
    //   480	490	332	java/lang/Throwable
    //   495	502	332	java/lang/Throwable
    //   505	511	332	java/lang/Throwable
    //   514	521	332	java/lang/Throwable
    //   524	531	332	java/lang/Throwable
    //   534	539	332	java/lang/Throwable
    //   542	547	332	java/lang/Throwable
    //   334	337	337	finally
    //   43	82	360	java/io/IOException
    //   89	108	360	java/io/IOException
    //   153	207	360	java/io/IOException
    //   352	357	360	java/io/IOException
    //   357	360	360	java/io/IOException
    //   547	552	360	java/io/IOException
    //   557	591	360	java/io/IOException
    //   636	641	360	java/io/IOException
    //   696	706	360	java/io/IOException
    //   714	721	360	java/io/IOException
    //   767	776	360	java/io/IOException
    //   43	82	644	finally
    //   89	108	644	finally
    //   153	207	644	finally
    //   352	357	644	finally
    //   357	360	644	finally
    //   547	552	644	finally
    //   557	591	644	finally
    //   636	641	644	finally
    //   696	706	644	finally
    //   714	721	644	finally
    //   767	776	644	finally
    //   352	357	779	java/lang/Throwable
    //   27	43	784	finally
    //   370	375	793	finally
    //   27	43	806	java/io/IOException
    //   207	212	851	finally
    //   225	233	851	finally
    //   238	245	851	finally
    //   247	304	851	finally
    //   304	329	851	finally
    //   420	430	851	finally
    //   435	445	851	finally
    //   450	460	851	finally
    //   465	475	851	finally
    //   480	490	851	finally
    //   495	502	851	finally
    //   505	511	851	finally
    //   514	521	851	finally
    //   524	531	851	finally
    //   534	539	851	finally
    //   542	547	851	finally
  }
  
  private static List<j> a(com.google.a.b.a parama)
  {
    ArrayList localArrayList = new ArrayList();
    parama.a();
    while (parama.e())
    {
      j localj = b(parama);
      if (localj != null) {
        localArrayList.add(localj);
      }
    }
    parama.b();
    return localArrayList;
  }
  
  private static j b(com.google.a.b.a parama)
  {
    parama.c();
    j.a locala1 = null;
    Object localObject = null;
    j.a locala2 = null;
    String str1 = null;
    label14:
    while (parama.e())
    {
      String str2 = parama.f();
      label60:
      int i;
      switch (str2.hashCode())
      {
      default: 
        i = -1;
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          parama.j();
          break label14;
          if (!str2.equals("id")) {
            break label60;
          }
          i = 0;
          continue;
          if (!str2.equals("media")) {
            break label60;
          }
          i = 1;
        }
      }
      str1 = parama.g();
      continue;
      parama.a();
      parama.c();
      label137:
      while (parama.e())
      {
        str2 = parama.f();
        switch (str2.hashCode())
        {
        default: 
          label180:
          i = -1;
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            parama.j();
            break label137;
            if (!str2.equals("tinymp4")) {
              break label180;
            }
            i = 0;
            continue;
            if (!str2.equals("previewgif")) {
              break label180;
            }
            i = 1;
          }
        }
        locala1 = (j.a)c(parama).a;
        continue;
        localObject = c(parama);
        locala2 = (j.a)((h)localObject).a;
        localObject = (j.a)((h)localObject).b;
      }
      parama.d();
      while (parama.e()) {
        parama.j();
      }
      parama.b();
    }
    parama.d();
    if ((str1 != null) && (locala2 != null) && (localObject != null) && (locala1 != null)) {
      return new j(str1, locala2, (j.a)localObject, locala1, 2);
    }
    return null;
  }
  
  private static h<j.a, j.a> c(com.google.a.b.a parama)
  {
    int[] arrayOfInt = new int[2];
    parama.c();
    String str2 = null;
    String str1 = null;
    label13:
    while (parama.e())
    {
      String str3 = parama.f();
      int i = -1;
      switch (str3.hashCode())
      {
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          parama.j();
          break label13;
          if (str3.equals("url"))
          {
            i = 0;
            continue;
            if (str3.equals("preview"))
            {
              i = 1;
              continue;
              if (str3.equals("dims")) {
                i = 2;
              }
            }
          }
          break;
        }
      }
      str1 = parama.g();
      continue;
      str2 = parama.g();
      continue;
      parama.a();
      i = 0;
      while (parama.e()) {
        if (i < 2)
        {
          arrayOfInt[i] = parama.i();
          i += 1;
        }
        else
        {
          parama.j();
        }
      }
      parama.b();
    }
    parama.d();
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2))) {
      return h.a(new j.a(str1, arrayOfInt[0], arrayOfInt[1]), new j.a(str2, arrayOfInt[0], arrayOfInt[1]));
    }
    return h.a(null, null);
  }
  
  public final r a(final CharSequence paramCharSequence)
  {
    new r()
    {
      private void a(final String paramAnonymousString, final ab paramAnonymousab)
      {
        Log.d("gif/search/tenor/loading next search page \"" + paramAnonymousString + "\"");
        bu.a(new AsyncTask() {}, new Void[0]);
      }
      
      protected final boolean a(String paramAnonymousString)
      {
        if (paramAnonymousString == null) {
          return false;
        }
        a(paramAnonymousString, null);
        return true;
      }
    };
  }
  
  protected final r c()
  {
    new r()
    {
      private void b(final String paramAnonymousString)
      {
        Log.d("gif/search/tenor/loading next trending page \"" + paramAnonymousString + "\"");
        bu.a(new AsyncTask() {}, new Void[0]);
      }
      
      protected final boolean a(String paramAnonymousString)
      {
        if (paramAnonymousString == null) {
          return false;
        }
        b(paramAnonymousString);
        return true;
      }
    };
  }
  
  public final String d()
  {
    return "Tenor";
  }
  
  public final int e()
  {
    return 1;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gif_search/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */