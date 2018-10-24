package com.whatsapp;

import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.whatsapp.messaging.ar;
import com.whatsapp.util.Log;
import com.whatsapp.util.be;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import javax.net.ssl.HttpsURLConnection;

public final class aog
{
  static URL a;
  static String b;
  private static volatile aog f;
  private static URL g;
  private static URL h;
  final atv c;
  boolean d;
  public int e;
  private final ox i;
  private final aat j;
  
  private aog(ox paramox, aat paramaat, atv paramatv)
  {
    this.i = paramox;
    this.j = paramaat;
    this.c = paramatv;
  }
  
  public static aog a()
  {
    if (f == null) {}
    try
    {
      if (f == null) {
        f = new aog(ox.a(), aat.a(), atv.a());
      }
      return f;
    }
    finally {}
  }
  
  /* Error */
  static String a(URL paramURL)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 62	com/whatsapp/aog:b	(Ljava/net/URL;)Ljavax/net/ssl/HttpsURLConnection;
    //   4: astore 4
    //   6: aload 4
    //   8: ifnonnull +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 64	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   20: astore_2
    //   21: sipush 4096
    //   24: newarray <illegal type>
    //   26: astore_3
    //   27: new 67	java/io/InputStreamReader
    //   30: dup
    //   31: aload 4
    //   33: invokevirtual 73	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   36: ldc 75
    //   38: invokespecial 78	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   41: astore 5
    //   43: aload 5
    //   45: aload_3
    //   46: invokevirtual 84	java/io/Reader:read	([C)I
    //   49: istore_1
    //   50: iload_1
    //   51: iflt +58 -> 109
    //   54: aload_2
    //   55: aload_3
    //   56: iconst_0
    //   57: iload_1
    //   58: invokevirtual 88	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: goto -19 -> 43
    //   65: astore_2
    //   66: aload_2
    //   67: athrow
    //   68: astore_3
    //   69: aload_2
    //   70: astore 4
    //   72: aload_3
    //   73: astore_2
    //   74: aload 4
    //   76: ifnull +46 -> 122
    //   79: aload 5
    //   81: invokevirtual 91	java/io/Reader:close	()V
    //   84: aload_2
    //   85: athrow
    //   86: astore_2
    //   87: new 64	java/lang/StringBuilder
    //   90: dup
    //   91: ldc 93
    //   93: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload_0
    //   97: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: aload_2
    //   104: invokestatic 108	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   107: aconst_null
    //   108: areturn
    //   109: aload 5
    //   111: invokevirtual 91	java/io/Reader:close	()V
    //   114: aload_2
    //   115: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokevirtual 113	java/lang/String:trim	()Ljava/lang/String;
    //   121: areturn
    //   122: aload 5
    //   124: invokevirtual 91	java/io/Reader:close	()V
    //   127: goto -43 -> 84
    //   130: astore_3
    //   131: goto -47 -> 84
    //   134: astore_2
    //   135: aconst_null
    //   136: astore 4
    //   138: goto -64 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramURL	URL
    //   49	9	1	k	int
    //   20	35	2	localStringBuilder	StringBuilder
    //   65	5	2	localThrowable1	Throwable
    //   73	12	2	localObject1	Object
    //   86	29	2	localIOException	IOException
    //   134	1	2	localObject2	Object
    //   26	30	3	arrayOfChar	char[]
    //   68	5	3	localObject3	Object
    //   130	1	3	localThrowable2	Throwable
    //   4	133	4	localObject4	Object
    //   41	82	5	localInputStreamReader	java.io.InputStreamReader
    // Exception table:
    //   from	to	target	type
    //   43	50	65	java/lang/Throwable
    //   54	62	65	java/lang/Throwable
    //   66	68	68	finally
    //   0	6	86	java/io/IOException
    //   13	43	86	java/io/IOException
    //   79	84	86	java/io/IOException
    //   84	86	86	java/io/IOException
    //   109	122	86	java/io/IOException
    //   122	127	86	java/io/IOException
    //   79	84	130	java/lang/Throwable
    //   43	50	134	finally
    //   54	62	134	finally
  }
  
  /* Error */
  private static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: ldc 118
    //   2: invokestatic 124	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_2
    //   6: new 126	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 129	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: astore 4
    //   16: sipush 8192
    //   19: newarray <illegal type>
    //   21: astore_0
    //   22: aload 4
    //   24: aload_0
    //   25: invokevirtual 132	java/io/FileInputStream:read	([B)I
    //   28: istore_1
    //   29: iload_1
    //   30: iflt +49 -> 79
    //   33: aload_2
    //   34: aload_0
    //   35: iconst_0
    //   36: iload_1
    //   37: invokevirtual 136	java/security/MessageDigest:update	([BII)V
    //   40: goto -18 -> 22
    //   43: astore_0
    //   44: aload_0
    //   45: athrow
    //   46: astore_2
    //   47: aload_0
    //   48: astore_3
    //   49: aload_2
    //   50: astore_0
    //   51: aload_3
    //   52: ifnull +39 -> 91
    //   55: aload 4
    //   57: invokevirtual 137	java/io/FileInputStream:close	()V
    //   60: aload_0
    //   61: athrow
    //   62: astore_0
    //   63: aload_0
    //   64: invokestatic 141	com/whatsapp/util/Log:w	(Ljava/lang/Throwable;)V
    //   67: aconst_null
    //   68: areturn
    //   69: astore_0
    //   70: new 143	java/lang/AssertionError
    //   73: dup
    //   74: aload_0
    //   75: invokespecial 146	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   78: athrow
    //   79: aload_2
    //   80: invokevirtual 150	java/security/MessageDigest:digest	()[B
    //   83: astore_0
    //   84: aload 4
    //   86: invokevirtual 137	java/io/FileInputStream:close	()V
    //   89: aload_0
    //   90: areturn
    //   91: aload 4
    //   93: invokevirtual 137	java/io/FileInputStream:close	()V
    //   96: goto -36 -> 60
    //   99: astore_2
    //   100: goto -40 -> 60
    //   103: astore_0
    //   104: aconst_null
    //   105: astore_3
    //   106: goto -55 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramFile	File
    //   28	9	1	k	int
    //   5	29	2	localMessageDigest	java.security.MessageDigest
    //   46	34	2	localObject	Object
    //   99	1	2	localThrowable	Throwable
    //   48	58	3	localFile	File
    //   14	78	4	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   16	22	43	java/lang/Throwable
    //   22	29	43	java/lang/Throwable
    //   33	40	43	java/lang/Throwable
    //   79	84	43	java/lang/Throwable
    //   44	46	46	finally
    //   6	16	62	java/io/IOException
    //   55	60	62	java/io/IOException
    //   60	62	62	java/io/IOException
    //   84	89	62	java/io/IOException
    //   91	96	62	java/io/IOException
    //   0	6	69	java/security/NoSuchAlgorithmException
    //   55	60	99	java/lang/Throwable
    //   16	22	103	finally
    //   22	29	103	finally
    //   33	40	103	finally
    //   79	84	103	finally
  }
  
  public static Uri b()
  {
    if (av.f())
    {
      if (g != null) {
        return Uri.parse(g.toString());
      }
      return Uri.parse("https://www.whatsapp.com/android/current/WhatsApp.apk");
    }
    return Uri.parse("market://details?id=com.whatsapp");
  }
  
  private static HttpsURLConnection b(URL paramURL)
  {
    Object localObject = paramURL.openConnection();
    if ((localObject instanceof HttpsURLConnection))
    {
      localObject = (HttpsURLConnection)localObject;
      if (localObject != null) {
        break label49;
      }
      Log.w("non https url provided to upgrade url fetch; url=" + paramURL);
      localObject = null;
    }
    label49:
    int k;
    do
    {
      return (HttpsURLConnection)localObject;
      localObject = null;
      break;
      ((HttpsURLConnection)localObject).setSSLSocketFactory(ar.a());
      ((HttpsURLConnection)localObject).setConnectTimeout(15000);
      ((HttpsURLConnection)localObject).setReadTimeout(30000);
      ((HttpsURLConnection)localObject).setRequestProperty("User-Agent", ape.a());
      ((HttpsURLConnection)localObject).setRequestProperty("Accept-Charset", "UTF-8");
      k = ((HttpsURLConnection)localObject).getResponseCode();
    } while (k == 200);
    Log.w("unexpected response code during upgrade url fetch; url=" + paramURL + "; responseCode=" + k);
    return null;
  }
  
  private static byte[] h()
  {
    String str = a(h);
    Log.d("upgrade SHA-256 fetch; sha256=" + str);
    if (str == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = be.a(str);
      return arrayOfByte;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Log.c("upgrade SHA-256 fetch failed; sha256=" + str, localIllegalArgumentException);
    }
    return null;
  }
  
  public final boolean a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString)) {
      bool = false;
    }
    while (this.d) {
      return bool;
    }
    paramString = "https://www.whatsapp.com/android/" + paramString.substring(paramString.length() - 1) + "/";
    Log.i("upgrade source initialized; path=" + paramString);
    b = paramString + "WhatsApp.html";
    try
    {
      g = new URL(paramString + "WhatsApp.apk");
      h = new URL(paramString + "WhatsApp.sha256");
      a = new URL(paramString + "WhatsApp.version");
      this.d = true;
      return true;
    }
    catch (MalformedURLException paramString)
    {
      throw new AssertionError(paramString);
    }
  }
  
  public final Uri c()
  {
    File localFile = this.i.a("WhatsApp.apk");
    byte[] arrayOfByte;
    Object localObject1;
    if ((this.i.a("WhatsApp.upgrade").delete()) && (localFile.exists()))
    {
      arrayOfByte = a(localFile);
      localObject1 = this.c.a.getString("last_upgrade_remote_sha256", null);
      if (localObject1 == null) {
        break label113;
      }
    }
    try
    {
      label113:
      for (localObject1 = be.a((String)localObject1); (arrayOfByte == null) || (!Arrays.equals(arrayOfByte, (byte[])localObject1)); localObject1 = null)
      {
        if (!localFile.delete())
        {
          this.c.p();
          Log.w("failed to delete file; file=" + localFile);
        }
        return null;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
    return Uri.fromFile(localFile);
  }
  
  public final void d()
  {
    File localFile = this.i.a("WhatsApp.upgrade");
    try
    {
      boolean bool = localFile.createNewFile();
      Log.i("upgrade sentinel file created; success=" + bool);
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("upgrade/sentinel/fail");
    }
  }
  
  /* Error */
  final void e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: getfield 29	com/whatsapp/aog:i	Lcom/whatsapp/ox;
    //   7: ldc_w 332
    //   10: invokevirtual 280	com/whatsapp/ox:a	(Ljava/lang/String;)Ljava/io/File;
    //   13: astore 6
    //   15: aload_0
    //   16: getfield 29	com/whatsapp/aog:i	Lcom/whatsapp/ox;
    //   19: ldc_w 270
    //   22: invokevirtual 280	com/whatsapp/ox:a	(Ljava/lang/String;)Ljava/io/File;
    //   25: astore 7
    //   27: invokestatic 334	com/whatsapp/aog:h	()[B
    //   30: astore 8
    //   32: aload 8
    //   34: ifnonnull +10 -> 44
    //   37: ldc_w 336
    //   40: invokestatic 179	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   43: return
    //   44: aload_0
    //   45: getfield 33	com/whatsapp/aog:c	Lcom/whatsapp/atv;
    //   48: astore_2
    //   49: aload 8
    //   51: invokestatic 339	com/whatsapp/util/be:a	([B)Ljava/lang/String;
    //   54: astore_3
    //   55: aload_2
    //   56: invokevirtual 342	com/whatsapp/atv:c	()Landroid/content/SharedPreferences$Editor;
    //   59: ldc_w 297
    //   62: aload_3
    //   63: invokeinterface 348 3 0
    //   68: invokeinterface 351 1 0
    //   73: aload 7
    //   75: invokevirtual 290	java/io/File:exists	()Z
    //   78: ifeq +57 -> 135
    //   81: aload 8
    //   83: aload 7
    //   85: invokestatic 292	com/whatsapp/aog:a	(Ljava/io/File;)[B
    //   88: invokestatic 309	java/util/Arrays:equals	([B[B)Z
    //   91: ifeq +30 -> 121
    //   94: aload 6
    //   96: invokevirtual 290	java/io/File:exists	()Z
    //   99: ifeq +17 -> 116
    //   102: aload 6
    //   104: invokevirtual 287	java/io/File:delete	()Z
    //   107: ifne +9 -> 116
    //   110: ldc_w 353
    //   113: invokestatic 179	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   116: aload_0
    //   117: invokevirtual 355	com/whatsapp/aog:d	()V
    //   120: return
    //   121: aload 7
    //   123: invokevirtual 287	java/io/File:delete	()Z
    //   126: ifne +9 -> 135
    //   129: ldc_w 357
    //   132: invokestatic 179	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   135: aload 6
    //   137: invokevirtual 290	java/io/File:exists	()Z
    //   140: ifeq +51 -> 191
    //   143: aload 8
    //   145: aload 6
    //   147: invokestatic 292	com/whatsapp/aog:a	(Ljava/io/File;)[B
    //   150: invokestatic 309	java/util/Arrays:equals	([B[B)Z
    //   153: ifeq +24 -> 177
    //   156: aload 6
    //   158: aload 7
    //   160: invokevirtual 361	java/io/File:renameTo	(Ljava/io/File;)Z
    //   163: ifne +9 -> 172
    //   166: ldc_w 363
    //   169: invokestatic 179	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   172: aload_0
    //   173: invokevirtual 355	com/whatsapp/aog:d	()V
    //   176: return
    //   177: aload 6
    //   179: invokevirtual 287	java/io/File:delete	()Z
    //   182: ifne +9 -> 191
    //   185: ldc_w 365
    //   188: invokestatic 179	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   191: aload_0
    //   192: invokevirtual 367	com/whatsapp/aog:g	()Z
    //   195: ifeq -152 -> 43
    //   198: getstatic 158	com/whatsapp/aog:g	Ljava/net/URL;
    //   201: astore 9
    //   203: aload 9
    //   205: invokestatic 62	com/whatsapp/aog:b	(Ljava/net/URL;)Ljavax/net/ssl/HttpsURLConnection;
    //   208: astore_2
    //   209: aload_2
    //   210: ifnonnull +45 -> 255
    //   213: aload 6
    //   215: invokevirtual 290	java/io/File:exists	()Z
    //   218: ifeq -175 -> 43
    //   221: aload 8
    //   223: aload 6
    //   225: invokestatic 292	com/whatsapp/aog:a	(Ljava/io/File;)[B
    //   228: invokestatic 309	java/util/Arrays:equals	([B[B)Z
    //   231: ifeq +195 -> 426
    //   234: aload 6
    //   236: aload 7
    //   238: invokevirtual 361	java/io/File:renameTo	(Ljava/io/File;)Z
    //   241: ifne +9 -> 250
    //   244: ldc_w 369
    //   247: invokestatic 179	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   250: aload_0
    //   251: invokevirtual 355	com/whatsapp/aog:d	()V
    //   254: return
    //   255: new 371	java/io/FileOutputStream
    //   258: dup
    //   259: aload 6
    //   261: invokespecial 372	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   264: astore 10
    //   266: aload_2
    //   267: invokevirtual 73	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   270: astore 11
    //   272: sipush 8192
    //   275: newarray <illegal type>
    //   277: astore_2
    //   278: aload 11
    //   280: aload_2
    //   281: invokevirtual 375	java/io/InputStream:read	([B)I
    //   284: istore_1
    //   285: iload_1
    //   286: iflt +98 -> 384
    //   289: aload 10
    //   291: aload_2
    //   292: iconst_0
    //   293: iload_1
    //   294: invokevirtual 378	java/io/FileOutputStream:write	([BII)V
    //   297: goto -19 -> 278
    //   300: astore_2
    //   301: aload_2
    //   302: athrow
    //   303: astore_3
    //   304: aload_2
    //   305: astore 4
    //   307: aload_3
    //   308: astore_2
    //   309: aload 11
    //   311: ifnull +13 -> 324
    //   314: aload 4
    //   316: ifnull +86 -> 402
    //   319: aload 11
    //   321: invokevirtual 379	java/io/InputStream:close	()V
    //   324: aload_2
    //   325: athrow
    //   326: astore_2
    //   327: aload_2
    //   328: athrow
    //   329: astore_3
    //   330: aload_2
    //   331: astore 4
    //   333: aload_3
    //   334: astore_2
    //   335: aload 4
    //   337: ifnull +81 -> 418
    //   340: aload 10
    //   342: invokevirtual 380	java/io/FileOutputStream:close	()V
    //   345: aload_2
    //   346: athrow
    //   347: astore_2
    //   348: new 64	java/lang/StringBuilder
    //   351: dup
    //   352: ldc_w 382
    //   355: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   358: aload 9
    //   360: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   363: ldc_w 384
    //   366: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: aload 6
    //   371: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: aload_2
    //   378: invokestatic 108	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   381: goto -168 -> 213
    //   384: aload 11
    //   386: ifnull +8 -> 394
    //   389: aload 11
    //   391: invokevirtual 379	java/io/InputStream:close	()V
    //   394: aload 10
    //   396: invokevirtual 380	java/io/FileOutputStream:close	()V
    //   399: goto -186 -> 213
    //   402: aload 11
    //   404: invokevirtual 379	java/io/InputStream:close	()V
    //   407: goto -83 -> 324
    //   410: astore_2
    //   411: aload 5
    //   413: astore 4
    //   415: goto -80 -> 335
    //   418: aload 10
    //   420: invokevirtual 380	java/io/FileOutputStream:close	()V
    //   423: goto -78 -> 345
    //   426: aload 6
    //   428: invokevirtual 287	java/io/File:delete	()Z
    //   431: ifne -388 -> 43
    //   434: ldc_w 386
    //   437: invokestatic 179	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   440: return
    //   441: astore_3
    //   442: goto -118 -> 324
    //   445: astore_3
    //   446: goto -101 -> 345
    //   449: astore_2
    //   450: aconst_null
    //   451: astore 4
    //   453: goto -144 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	aog
    //   284	10	1	k	int
    //   48	244	2	localObject1	Object
    //   300	5	2	localThrowable1	Throwable
    //   308	17	2	localObject2	Object
    //   326	5	2	localThrowable2	Throwable
    //   334	12	2	localObject3	Object
    //   347	31	2	localIOException	IOException
    //   410	1	2	localObject4	Object
    //   449	1	2	localObject5	Object
    //   54	9	3	str	String
    //   303	5	3	localObject6	Object
    //   329	5	3	localObject7	Object
    //   441	1	3	localThrowable3	Throwable
    //   445	1	3	localThrowable4	Throwable
    //   305	147	4	localObject8	Object
    //   1	411	5	localObject9	Object
    //   13	414	6	localFile1	File
    //   25	212	7	localFile2	File
    //   30	192	8	arrayOfByte	byte[]
    //   201	158	9	localURL	URL
    //   264	155	10	localFileOutputStream	java.io.FileOutputStream
    //   270	133	11	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   272	278	300	java/lang/Throwable
    //   278	285	300	java/lang/Throwable
    //   289	297	300	java/lang/Throwable
    //   301	303	303	finally
    //   266	272	326	java/lang/Throwable
    //   324	326	326	java/lang/Throwable
    //   389	394	326	java/lang/Throwable
    //   402	407	326	java/lang/Throwable
    //   327	329	329	finally
    //   203	209	347	java/io/IOException
    //   255	266	347	java/io/IOException
    //   340	345	347	java/io/IOException
    //   345	347	347	java/io/IOException
    //   394	399	347	java/io/IOException
    //   418	423	347	java/io/IOException
    //   266	272	410	finally
    //   319	324	410	finally
    //   324	326	410	finally
    //   389	394	410	finally
    //   402	407	410	finally
    //   319	324	441	java/lang/Throwable
    //   340	345	445	java/lang/Throwable
    //   272	278	449	finally
    //   278	285	449	finally
    //   289	297	449	finally
  }
  
  public final void f()
  {
    File localFile = this.i.a("WhatsApp.download");
    if (localFile.exists()) {
      Log.a(localFile.delete());
    }
    if (this.i.a("WhatsApp.upgrade").exists()) {
      return;
    }
    localFile = this.i.a("WhatsApp.apk");
    if (localFile.exists()) {
      Log.a(localFile.delete());
    }
    this.c.p();
  }
  
  final boolean g()
  {
    int k = this.j.a(true);
    return (k == 1) || ((this.c.b(k) & 0x4) != 0);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */