package com.whatsapp.util;

import a.a.a.a.a.a.d;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.f.f;
import android.widget.ImageView;
import java.io.File;
import java.io.IOException;
import java.util.Stack;

public final class bi
{
  private static final Bitmap a = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
  private final f<String, Bitmap> b;
  private d[] c;
  private o d;
  private final Object e = new Object();
  private final File f;
  private final long g;
  private final e h = new e((byte)0);
  private final Drawable i;
  private final Drawable j;
  private final int k;
  private boolean l = false;
  private final Handler m = new Handler(Looper.getMainLooper());
  
  private bi(b paramb)
  {
    this.j = paramb.d;
    this.i = paramb.c;
    this.k = paramb.f;
    this.f = paramb.a;
    this.g = paramb.b;
    this.c = new d[paramb.e];
    int n = 0;
    while (n < paramb.e)
    {
      this.c[n] = new d(0);
      this.c[n].setPriority(4);
      n += 1;
    }
    this.b = new f((int)(Runtime.getRuntime().maxMemory() / 8192L)) {};
  }
  
  /* Error */
  private Bitmap a(c paramc)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 145	com/whatsapp/util/bi$c:a	Ljava/lang/String;
    //   4: invokestatic 150	com/whatsapp/r:a	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore 10
    //   9: aload_0
    //   10: getfield 65	com/whatsapp/util/bi:e	Ljava/lang/Object;
    //   13: astore 7
    //   15: aload 7
    //   17: monitorenter
    //   18: aload_0
    //   19: getfield 152	com/whatsapp/util/bi:d	Lcom/whatsapp/util/o;
    //   22: ifnull +13 -> 35
    //   25: aload_0
    //   26: getfield 152	com/whatsapp/util/bi:d	Lcom/whatsapp/util/o;
    //   29: invokevirtual 157	com/whatsapp/util/o:a	()Z
    //   32: ifeq +91 -> 123
    //   35: aload_0
    //   36: getfield 101	com/whatsapp/util/bi:f	Ljava/io/File;
    //   39: invokevirtual 162	java/io/File:exists	()Z
    //   42: ifne +45 -> 87
    //   45: aload_0
    //   46: getfield 101	com/whatsapp/util/bi:f	Ljava/io/File;
    //   49: invokevirtual 165	java/io/File:mkdirs	()Z
    //   52: ifne +35 -> 87
    //   55: aload_0
    //   56: getfield 101	com/whatsapp/util/bi:f	Ljava/io/File;
    //   59: invokevirtual 162	java/io/File:exists	()Z
    //   62: ifne +25 -> 87
    //   65: new 167	java/lang/StringBuilder
    //   68: dup
    //   69: ldc -87
    //   71: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   74: aload_0
    //   75: getfield 101	com/whatsapp/util/bi:f	Ljava/io/File;
    //   78: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 184	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   87: aload_0
    //   88: getfield 101	com/whatsapp/util/bi:f	Ljava/io/File;
    //   91: invokevirtual 187	java/io/File:getUsableSpace	()J
    //   94: lstore_3
    //   95: aload_0
    //   96: getfield 105	com/whatsapp/util/bi:g	J
    //   99: lstore 5
    //   101: lload_3
    //   102: lload 5
    //   104: lcmp
    //   105: ifle +18 -> 123
    //   108: aload_0
    //   109: aload_0
    //   110: getfield 101	com/whatsapp/util/bi:f	Ljava/io/File;
    //   113: aload_0
    //   114: getfield 105	com/whatsapp/util/bi:g	J
    //   117: invokestatic 190	com/whatsapp/util/o:a	(Ljava/io/File;J)Lcom/whatsapp/util/o;
    //   120: putfield 152	com/whatsapp/util/bi:d	Lcom/whatsapp/util/o;
    //   123: aload_0
    //   124: getfield 65	com/whatsapp/util/bi:e	Ljava/lang/Object;
    //   127: invokevirtual 193	java/lang/Object:notifyAll	()V
    //   130: aload 7
    //   132: monitorexit
    //   133: aload_0
    //   134: aload 10
    //   136: invokespecial 196	com/whatsapp/util/bi:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   139: astore 7
    //   141: aload 7
    //   143: ifnull +37 -> 180
    //   146: aload 7
    //   148: areturn
    //   149: astore 8
    //   151: new 167	java/lang/StringBuilder
    //   154: dup
    //   155: ldc -58
    //   157: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   160: aload 8
    //   162: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 184	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   171: goto -48 -> 123
    //   174: astore_1
    //   175: aload 7
    //   177: monitorexit
    //   178: aload_1
    //   179: athrow
    //   180: new 167	java/lang/StringBuilder
    //   183: dup
    //   184: ldc -56
    //   186: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   189: aload_1
    //   190: getfield 145	com/whatsapp/util/bi$c:a	Ljava/lang/String;
    //   193: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 205	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   202: new 207	org/apache/http/client/methods/HttpGet
    //   205: dup
    //   206: aload_1
    //   207: getfield 145	com/whatsapp/util/bi$c:a	Ljava/lang/String;
    //   210: invokespecial 208	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   213: astore 7
    //   215: new 210	org/apache/http/params/BasicHttpParams
    //   218: dup
    //   219: invokespecial 211	org/apache/http/params/BasicHttpParams:<init>	()V
    //   222: astore 8
    //   224: aload 8
    //   226: sipush 15000
    //   229: invokestatic 217	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   232: aload 8
    //   234: sipush 30000
    //   237: invokestatic 220	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   240: new 222	org/apache/http/impl/client/DefaultHttpClient
    //   243: dup
    //   244: aload 8
    //   246: invokespecial 225	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   249: aload 7
    //   251: invokevirtual 229	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   254: invokeinterface 235 1 0
    //   259: astore 7
    //   261: aload 7
    //   263: ifnull +139 -> 402
    //   266: aload 7
    //   268: invokeinterface 241 1 0
    //   273: astore 11
    //   275: aload_0
    //   276: getfield 65	com/whatsapp/util/bi:e	Ljava/lang/Object;
    //   279: astore 9
    //   281: aload 9
    //   283: monitorenter
    //   284: aload_0
    //   285: getfield 152	com/whatsapp/util/bi:d	Lcom/whatsapp/util/o;
    //   288: astore 7
    //   290: aload 7
    //   292: ifnull +107 -> 399
    //   295: aload 11
    //   297: ifnull +102 -> 399
    //   300: aload_0
    //   301: getfield 152	com/whatsapp/util/bi:d	Lcom/whatsapp/util/o;
    //   304: aload 10
    //   306: invokevirtual 244	com/whatsapp/util/o:a	(Ljava/lang/String;)Lcom/whatsapp/util/o$c;
    //   309: astore 7
    //   311: aload 7
    //   313: ifnonnull +258 -> 571
    //   316: aload_0
    //   317: getfield 152	com/whatsapp/util/bi:d	Lcom/whatsapp/util/o;
    //   320: aload 10
    //   322: invokevirtual 247	com/whatsapp/util/o:b	(Ljava/lang/String;)Lcom/whatsapp/util/o$a;
    //   325: astore 8
    //   327: aload 8
    //   329: ifnull +252 -> 581
    //   332: aload 8
    //   334: invokevirtual 252	com/whatsapp/util/o$a:a	()Ljava/io/OutputStream;
    //   337: astore 7
    //   339: sipush 1024
    //   342: newarray <illegal type>
    //   344: astore 12
    //   346: aload 11
    //   348: aload 12
    //   350: iconst_0
    //   351: sipush 1024
    //   354: invokevirtual 258	java/io/InputStream:read	([BII)I
    //   357: istore_2
    //   358: iload_2
    //   359: iconst_m1
    //   360: if_icmpeq +81 -> 441
    //   363: aload 7
    //   365: aload 12
    //   367: iconst_0
    //   368: iload_2
    //   369: invokevirtual 264	java/io/OutputStream:write	([BII)V
    //   372: goto -26 -> 346
    //   375: astore 8
    //   377: ldc -56
    //   379: aload 8
    //   381: invokestatic 267	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   384: aload 7
    //   386: ifnull +8 -> 394
    //   389: aload 7
    //   391: invokevirtual 270	java/io/OutputStream:close	()V
    //   394: aload 11
    //   396: invokevirtual 271	java/io/InputStream:close	()V
    //   399: aload 9
    //   401: monitorexit
    //   402: aload_0
    //   403: aload 10
    //   405: invokespecial 196	com/whatsapp/util/bi:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   408: astore 7
    //   410: aload 7
    //   412: ifnonnull +26 -> 438
    //   415: new 167	java/lang/StringBuilder
    //   418: dup
    //   419: ldc_w 273
    //   422: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   425: aload_1
    //   426: getfield 145	com/whatsapp/util/bi$c:a	Ljava/lang/String;
    //   429: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 184	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   438: aload 7
    //   440: areturn
    //   441: aload 8
    //   443: getfield 275	com/whatsapp/util/o$a:b	Z
    //   446: ifeq +54 -> 500
    //   449: aload 8
    //   451: getfield 277	com/whatsapp/util/o$a:c	Lcom/whatsapp/util/o;
    //   454: aload 8
    //   456: iconst_0
    //   457: invokestatic 280	com/whatsapp/util/o:a	(Lcom/whatsapp/util/o;Lcom/whatsapp/util/o$a;Z)V
    //   460: aload 8
    //   462: getfield 277	com/whatsapp/util/o$a:c	Lcom/whatsapp/util/o;
    //   465: aload 8
    //   467: getfield 283	com/whatsapp/util/o$a:a	Lcom/whatsapp/util/o$b;
    //   470: getfield 286	com/whatsapp/util/o$b:a	Ljava/lang/String;
    //   473: invokevirtual 289	com/whatsapp/util/o:c	(Ljava/lang/String;)Z
    //   476: pop
    //   477: aload 7
    //   479: ifnull +8 -> 487
    //   482: aload 7
    //   484: invokevirtual 270	java/io/OutputStream:close	()V
    //   487: aload 11
    //   489: invokevirtual 271	java/io/InputStream:close	()V
    //   492: goto -93 -> 399
    //   495: astore 7
    //   497: goto -98 -> 399
    //   500: aload 8
    //   502: getfield 277	com/whatsapp/util/o$a:c	Lcom/whatsapp/util/o;
    //   505: aload 8
    //   507: iconst_1
    //   508: invokestatic 280	com/whatsapp/util/o:a	(Lcom/whatsapp/util/o;Lcom/whatsapp/util/o$a;Z)V
    //   511: goto -34 -> 477
    //   514: astore 8
    //   516: aload 7
    //   518: ifnull +8 -> 526
    //   521: aload 7
    //   523: invokevirtual 270	java/io/OutputStream:close	()V
    //   526: aload 11
    //   528: invokevirtual 271	java/io/InputStream:close	()V
    //   531: aload 8
    //   533: athrow
    //   534: astore 7
    //   536: aload 9
    //   538: monitorexit
    //   539: aload 7
    //   541: athrow
    //   542: astore 7
    //   544: new 167	java/lang/StringBuilder
    //   547: dup
    //   548: ldc_w 291
    //   551: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   554: aload_1
    //   555: getfield 145	com/whatsapp/util/bi$c:a	Ljava/lang/String;
    //   558: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: aload 7
    //   566: invokestatic 267	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   569: aconst_null
    //   570: areturn
    //   571: aload 7
    //   573: getfield 296	com/whatsapp/util/o$c:a	[Ljava/io/InputStream;
    //   576: iconst_0
    //   577: aaload
    //   578: invokevirtual 271	java/io/InputStream:close	()V
    //   581: aconst_null
    //   582: astore 7
    //   584: goto -107 -> 477
    //   587: astore 7
    //   589: goto -58 -> 531
    //   592: astore 8
    //   594: aconst_null
    //   595: astore 7
    //   597: goto -81 -> 516
    //   600: astore 8
    //   602: goto -86 -> 516
    //   605: astore 7
    //   607: goto -208 -> 399
    //   610: astore 8
    //   612: aconst_null
    //   613: astore 7
    //   615: goto -238 -> 377
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	618	0	this	bi
    //   0	618	1	paramc	c
    //   357	12	2	n	int
    //   94	8	3	l1	long
    //   99	4	5	l2	long
    //   13	470	7	localObject1	Object
    //   495	27	7	localIOException1	IOException
    //   534	6	7	localObject2	Object
    //   542	30	7	localException1	Exception
    //   582	1	7	localObject3	Object
    //   587	1	7	localIOException2	IOException
    //   595	1	7	localObject4	Object
    //   605	1	7	localIOException3	IOException
    //   613	1	7	localObject5	Object
    //   149	12	8	localIOException4	IOException
    //   222	111	8	localObject6	Object
    //   375	131	8	localException2	Exception
    //   514	18	8	localObject7	Object
    //   592	1	8	localObject8	Object
    //   600	1	8	localObject9	Object
    //   610	1	8	localException3	Exception
    //   279	258	9	localObject10	Object
    //   7	397	10	str	String
    //   273	254	11	localInputStream	java.io.InputStream
    //   344	22	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   108	123	149	java/io/IOException
    //   18	35	174	finally
    //   35	87	174	finally
    //   87	101	174	finally
    //   108	123	174	finally
    //   123	133	174	finally
    //   151	171	174	finally
    //   175	178	174	finally
    //   339	346	375	java/lang/Exception
    //   346	358	375	java/lang/Exception
    //   363	372	375	java/lang/Exception
    //   441	477	375	java/lang/Exception
    //   500	511	375	java/lang/Exception
    //   482	487	495	java/io/IOException
    //   487	492	495	java/io/IOException
    //   339	346	514	finally
    //   346	358	514	finally
    //   363	372	514	finally
    //   441	477	514	finally
    //   500	511	514	finally
    //   284	290	534	finally
    //   389	394	534	finally
    //   394	399	534	finally
    //   399	402	534	finally
    //   482	487	534	finally
    //   487	492	534	finally
    //   521	526	534	finally
    //   526	531	534	finally
    //   531	534	534	finally
    //   536	539	534	finally
    //   180	261	542	java/lang/Exception
    //   266	284	542	java/lang/Exception
    //   402	410	542	java/lang/Exception
    //   415	438	542	java/lang/Exception
    //   539	542	542	java/lang/Exception
    //   521	526	587	java/io/IOException
    //   526	531	587	java/io/IOException
    //   300	311	592	finally
    //   316	327	592	finally
    //   332	339	592	finally
    //   571	581	592	finally
    //   377	384	600	finally
    //   389	394	605	java/io/IOException
    //   394	399	605	java/io/IOException
    //   300	311	610	java/lang/Exception
    //   316	327	610	java/lang/Exception
    //   332	339	610	java/lang/Exception
    //   571	581	610	java/lang/Exception
  }
  
  /* Error */
  private Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: getfield 65	com/whatsapp/util/bi:e	Ljava/lang/Object;
    //   10: astore 7
    //   12: aload 7
    //   14: monitorenter
    //   15: aload_0
    //   16: getfield 152	com/whatsapp/util/bi:d	Lcom/whatsapp/util/o;
    //   19: astore 6
    //   21: aload 6
    //   23: ifnull +214 -> 237
    //   26: aload_0
    //   27: getfield 152	com/whatsapp/util/bi:d	Lcom/whatsapp/util/o;
    //   30: aload_1
    //   31: invokevirtual 244	com/whatsapp/util/o:a	(Ljava/lang/String;)Lcom/whatsapp/util/o$c;
    //   34: astore_1
    //   35: aload_1
    //   36: ifnull +356 -> 392
    //   39: aload_1
    //   40: getfield 296	com/whatsapp/util/o$c:a	[Ljava/io/InputStream;
    //   43: iconst_0
    //   44: aaload
    //   45: astore_1
    //   46: aload_1
    //   47: astore 6
    //   49: aload_1
    //   50: ifnull +240 -> 290
    //   53: aload_1
    //   54: invokestatic 304	a/a/a/a/d:a	(Ljava/io/InputStream;)[B
    //   57: astore 4
    //   59: new 306	android/graphics/BitmapFactory$Options
    //   62: dup
    //   63: invokespecial 307	android/graphics/BitmapFactory$Options:<init>	()V
    //   66: astore 5
    //   68: aload 5
    //   70: iconst_1
    //   71: putfield 310	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   74: aload 4
    //   76: iconst_0
    //   77: aload 4
    //   79: arraylength
    //   80: aload 5
    //   82: invokestatic 316	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   85: pop
    //   86: aload 5
    //   88: getfield 319	android/graphics/BitmapFactory$Options:outWidth	I
    //   91: iflt +11 -> 102
    //   94: aload 5
    //   96: getfield 322	android/graphics/BitmapFactory$Options:outHeight	I
    //   99: ifge +36 -> 135
    //   102: ldc_w 324
    //   105: invokestatic 184	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   108: aconst_null
    //   109: astore 4
    //   111: aload 4
    //   113: ifnonnull +170 -> 283
    //   116: ldc_w 326
    //   119: invokestatic 184	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   122: aload_1
    //   123: ifnull +7 -> 130
    //   126: aload_1
    //   127: invokevirtual 271	java/io/InputStream:close	()V
    //   130: aload 7
    //   132: monitorexit
    //   133: aconst_null
    //   134: areturn
    //   135: aload 5
    //   137: getfield 319	android/graphics/BitmapFactory$Options:outWidth	I
    //   140: istore_3
    //   141: aload 5
    //   143: getfield 322	android/graphics/BitmapFactory$Options:outHeight	I
    //   146: istore_2
    //   147: aload 5
    //   149: iconst_1
    //   150: putfield 329	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   153: iload_3
    //   154: iconst_2
    //   155: idiv
    //   156: aload_0
    //   157: getfield 97	com/whatsapp/util/bi:k	I
    //   160: if_icmpge +13 -> 173
    //   163: iload_2
    //   164: iconst_2
    //   165: idiv
    //   166: aload_0
    //   167: getfield 97	com/whatsapp/util/bi:k	I
    //   170: if_icmplt +79 -> 249
    //   173: iload_3
    //   174: iconst_2
    //   175: idiv
    //   176: istore_3
    //   177: iload_2
    //   178: iconst_2
    //   179: idiv
    //   180: istore_2
    //   181: aload 5
    //   183: aload 5
    //   185: getfield 329	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   188: iconst_1
    //   189: iadd
    //   190: putfield 329	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   193: goto -40 -> 153
    //   196: astore 5
    //   198: aload_1
    //   199: astore 4
    //   201: aconst_null
    //   202: astore_1
    //   203: new 167	java/lang/StringBuilder
    //   206: dup
    //   207: ldc_w 331
    //   210: invokespecial 172	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   213: aload 5
    //   215: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 184	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   224: aload 4
    //   226: ifnull +8 -> 234
    //   229: aload 4
    //   231: invokevirtual 271	java/io/InputStream:close	()V
    //   234: aload_1
    //   235: astore 4
    //   237: aload 7
    //   239: monitorexit
    //   240: aload 4
    //   242: areturn
    //   243: astore_1
    //   244: aload 7
    //   246: monitorexit
    //   247: aload_1
    //   248: athrow
    //   249: aload 5
    //   251: iconst_0
    //   252: putfield 310	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   255: aload 5
    //   257: iconst_1
    //   258: putfield 334	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   261: aload 5
    //   263: iconst_1
    //   264: putfield 337	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   267: aload 4
    //   269: iconst_0
    //   270: aload 4
    //   272: arraylength
    //   273: aload 5
    //   275: invokestatic 316	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   278: astore 4
    //   280: goto -169 -> 111
    //   283: aload_1
    //   284: astore 6
    //   286: aload 4
    //   288: astore 5
    //   290: aload 5
    //   292: astore 4
    //   294: aload 6
    //   296: ifnull -59 -> 237
    //   299: aload 6
    //   301: invokevirtual 271	java/io/InputStream:close	()V
    //   304: aload 5
    //   306: astore 4
    //   308: goto -71 -> 237
    //   311: astore_1
    //   312: aload 5
    //   314: astore 4
    //   316: goto -79 -> 237
    //   319: astore 4
    //   321: aload_1
    //   322: astore 4
    //   324: goto -87 -> 237
    //   327: astore 4
    //   329: aconst_null
    //   330: astore_1
    //   331: aload_1
    //   332: ifnull +7 -> 339
    //   335: aload_1
    //   336: invokevirtual 271	java/io/InputStream:close	()V
    //   339: aload 4
    //   341: athrow
    //   342: astore_1
    //   343: goto -213 -> 130
    //   346: astore_1
    //   347: goto -8 -> 339
    //   350: astore 4
    //   352: goto -21 -> 331
    //   355: astore 5
    //   357: aload 4
    //   359: astore_1
    //   360: aload 5
    //   362: astore 4
    //   364: goto -33 -> 331
    //   367: astore 5
    //   369: aconst_null
    //   370: astore_1
    //   371: aconst_null
    //   372: astore 4
    //   374: goto -171 -> 203
    //   377: astore 5
    //   379: aload 4
    //   381: astore 6
    //   383: aload_1
    //   384: astore 4
    //   386: aload 6
    //   388: astore_1
    //   389: goto -186 -> 203
    //   392: aconst_null
    //   393: astore 6
    //   395: goto -105 -> 290
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	this	bi
    //   0	398	1	paramString	String
    //   146	35	2	n	int
    //   140	37	3	i1	int
    //   4	311	4	localObject1	Object
    //   319	1	4	localIOException1	IOException
    //   322	1	4	str	String
    //   327	13	4	localObject2	Object
    //   350	8	4	localObject3	Object
    //   362	23	4	localObject4	Object
    //   1	183	5	localOptions	android.graphics.BitmapFactory.Options
    //   196	78	5	localIOException2	IOException
    //   288	25	5	localObject5	Object
    //   355	6	5	localObject6	Object
    //   367	1	5	localIOException3	IOException
    //   377	1	5	localIOException4	IOException
    //   19	375	6	localObject7	Object
    //   10	235	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   53	102	196	java/io/IOException
    //   102	108	196	java/io/IOException
    //   135	153	196	java/io/IOException
    //   153	173	196	java/io/IOException
    //   173	193	196	java/io/IOException
    //   249	280	196	java/io/IOException
    //   15	21	243	finally
    //   126	130	243	finally
    //   130	133	243	finally
    //   229	234	243	finally
    //   237	240	243	finally
    //   244	247	243	finally
    //   299	304	243	finally
    //   335	339	243	finally
    //   339	342	243	finally
    //   299	304	311	java/io/IOException
    //   229	234	319	java/io/IOException
    //   26	35	327	finally
    //   39	46	327	finally
    //   126	130	342	java/io/IOException
    //   335	339	346	java/io/IOException
    //   53	102	350	finally
    //   102	108	350	finally
    //   116	122	350	finally
    //   135	153	350	finally
    //   153	173	350	finally
    //   173	193	350	finally
    //   249	280	350	finally
    //   203	224	355	finally
    //   26	35	367	java/io/IOException
    //   39	46	367	java/io/IOException
    //   116	122	377	java/io/IOException
  }
  
  public final void a(String arg1, ImageView paramImageView)
  {
    paramImageView.setTag(???);
    ??? = (Bitmap)this.b.a(???);
    if (??? != null) {
      if (??? != a) {
        paramImageView.setImageBitmap((Bitmap)???);
      }
    }
    for (;;)
    {
      return;
      paramImageView.setImageDrawable(this.j);
      return;
      paramImageView.setImageDrawable(this.i);
      a.d.b();
      Log.d("tumbloader/queue " + ???);
      synchronized (this.h.a)
      {
        this.h.a(paramImageView);
        paramImageView = new c(???, paramImageView);
      }
      synchronized (this.h.a)
      {
        this.h.a.add(0, paramImageView);
        this.h.a.notify();
        if (!this.l)
        {
          ??? = this.c;
          int i1 = ???.length;
          int n = 0;
          while (n < i1)
          {
            paramImageView = ???[n];
            if (paramImageView.getState() == Thread.State.NEW) {
              paramImageView.start();
            }
            n += 1;
            continue;
            ??? = finally;
            throw ???;
          }
        }
      }
    }
    this.l = true;
  }
  
  public final void a(boolean paramBoolean)
  {
    ??? = this.c;
    int i1 = ???.length;
    int n = 0;
    while (n < i1)
    {
      ???[n].interrupt();
      n += 1;
    }
    synchronized (this.b)
    {
      this.b.a(0);
    }
    synchronized (this.e)
    {
      o localo = this.d;
      if ((localo == null) || (paramBoolean)) {}
      try
      {
        this.d.b();
        if (!this.d.a()) {
          this.d.close();
        }
        this.d = null;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("tumbloader/close " + localIOException);
        }
      }
      this.l = false;
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  final class a
    implements Runnable
  {
    private Bitmap b;
    private ImageView c;
    private String d;
    
    public a(Bitmap paramBitmap, ImageView paramImageView, String paramString)
    {
      this.b = paramBitmap;
      this.c = paramImageView;
      this.d = paramString;
    }
    
    public final void run()
    {
      if ((this.c.getTag() != null) && (this.c.getTag().equals(this.d)))
      {
        if (this.b == null) {
          break label121;
        }
        if (this.c.getDrawable() == null)
        {
          TransitionDrawable localTransitionDrawable = new TransitionDrawable(new Drawable[] { new ColorDrawable(0), new BitmapDrawable(this.c.getResources(), this.b) });
          localTransitionDrawable.setCrossFadeEnabled(true);
          localTransitionDrawable.startTransition(200);
          this.c.setImageDrawable(localTransitionDrawable);
        }
      }
      else
      {
        return;
      }
      this.c.setImageBitmap(this.b);
      return;
      label121:
      this.c.setImageDrawable(bi.a(bi.this));
    }
  }
  
  public static final class b
  {
    final File a;
    long b = 1048576L;
    public Drawable c;
    public Drawable d;
    int e = 4;
    public int f;
    
    public b(File paramFile)
    {
      this.a = paramFile;
    }
    
    public final b a()
    {
      this.b = 4194304L;
      return this;
    }
    
    public final bi b()
    {
      return new bi(this, (byte)0);
    }
  }
  
  final class c
  {
    public String a;
    public ImageView b;
    
    public c(String paramString, ImageView paramImageView)
    {
      this.a = paramString;
      this.b = paramImageView;
    }
  }
  
  final class d
    extends Thread
  {
    private d() {}
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 13	com/whatsapp/util/bi$d:a	Lcom/whatsapp/util/bi;
      //   4: invokestatic 27	com/whatsapp/util/bi:b	(Lcom/whatsapp/util/bi;)Lcom/whatsapp/util/bi$e;
      //   7: getfield 32	com/whatsapp/util/bi$e:a	Ljava/util/Stack;
      //   10: invokevirtual 38	java/util/Stack:size	()I
      //   13: ifne +31 -> 44
      //   16: aload_0
      //   17: getfield 13	com/whatsapp/util/bi$d:a	Lcom/whatsapp/util/bi;
      //   20: invokestatic 27	com/whatsapp/util/bi:b	(Lcom/whatsapp/util/bi;)Lcom/whatsapp/util/bi$e;
      //   23: getfield 32	com/whatsapp/util/bi$e:a	Ljava/util/Stack;
      //   26: astore_2
      //   27: aload_2
      //   28: monitorenter
      //   29: aload_0
      //   30: getfield 13	com/whatsapp/util/bi$d:a	Lcom/whatsapp/util/bi;
      //   33: invokestatic 27	com/whatsapp/util/bi:b	(Lcom/whatsapp/util/bi;)Lcom/whatsapp/util/bi$e;
      //   36: getfield 32	com/whatsapp/util/bi$e:a	Ljava/util/Stack;
      //   39: invokevirtual 43	java/lang/Object:wait	()V
      //   42: aload_2
      //   43: monitorexit
      //   44: aload_0
      //   45: getfield 13	com/whatsapp/util/bi$d:a	Lcom/whatsapp/util/bi;
      //   48: invokestatic 27	com/whatsapp/util/bi:b	(Lcom/whatsapp/util/bi;)Lcom/whatsapp/util/bi$e;
      //   51: getfield 32	com/whatsapp/util/bi$e:a	Ljava/util/Stack;
      //   54: invokevirtual 38	java/util/Stack:size	()I
      //   57: ifeq +185 -> 242
      //   60: aload_0
      //   61: getfield 13	com/whatsapp/util/bi$d:a	Lcom/whatsapp/util/bi;
      //   64: invokestatic 27	com/whatsapp/util/bi:b	(Lcom/whatsapp/util/bi;)Lcom/whatsapp/util/bi$e;
      //   67: getfield 32	com/whatsapp/util/bi$e:a	Ljava/util/Stack;
      //   70: astore_3
      //   71: aload_3
      //   72: monitorenter
      //   73: aload_0
      //   74: getfield 13	com/whatsapp/util/bi$d:a	Lcom/whatsapp/util/bi;
      //   77: invokestatic 27	com/whatsapp/util/bi:b	(Lcom/whatsapp/util/bi;)Lcom/whatsapp/util/bi$e;
      //   80: getfield 32	com/whatsapp/util/bi$e:a	Ljava/util/Stack;
      //   83: invokevirtual 38	java/util/Stack:size	()I
      //   86: ifeq +190 -> 276
      //   89: aload_0
      //   90: getfield 13	com/whatsapp/util/bi$d:a	Lcom/whatsapp/util/bi;
      //   93: invokestatic 27	com/whatsapp/util/bi:b	(Lcom/whatsapp/util/bi;)Lcom/whatsapp/util/bi$e;
      //   96: getfield 32	com/whatsapp/util/bi$e:a	Ljava/util/Stack;
      //   99: invokevirtual 47	java/util/Stack:pop	()Ljava/lang/Object;
      //   102: checkcast 49	com/whatsapp/util/bi$c
      //   105: astore_2
      //   106: aload_3
      //   107: monitorexit
      //   108: aload_2
      //   109: ifnull +133 -> 242
      //   112: aload_0
      //   113: getfield 13	com/whatsapp/util/bi$d:a	Lcom/whatsapp/util/bi;
      //   116: aload_2
      //   117: invokestatic 52	com/whatsapp/util/bi:a	(Lcom/whatsapp/util/bi;Lcom/whatsapp/util/bi$c;)Landroid/graphics/Bitmap;
      //   120: astore 4
      //   122: aload_0
      //   123: getfield 13	com/whatsapp/util/bi$d:a	Lcom/whatsapp/util/bi;
      //   126: invokestatic 56	com/whatsapp/util/bi:c	(Lcom/whatsapp/util/bi;)Landroid/support/v4/f/f;
      //   129: astore 5
      //   131: aload 5
      //   133: monitorenter
      //   134: aload_0
      //   135: getfield 13	com/whatsapp/util/bi$d:a	Lcom/whatsapp/util/bi;
      //   138: invokestatic 56	com/whatsapp/util/bi:c	(Lcom/whatsapp/util/bi;)Landroid/support/v4/f/f;
      //   141: astore 6
      //   143: aload_2
      //   144: getfield 59	com/whatsapp/util/bi$c:a	Ljava/lang/String;
      //   147: astore 7
      //   149: aload 4
      //   151: ifnull +112 -> 263
      //   154: aload 4
      //   156: astore_3
      //   157: aload 6
      //   159: aload 7
      //   161: aload_3
      //   162: invokevirtual 64	android/support/v4/f/f:a	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   165: pop
      //   166: aload 5
      //   168: monitorexit
      //   169: aload_2
      //   170: getfield 67	com/whatsapp/util/bi$c:b	Landroid/widget/ImageView;
      //   173: invokevirtual 72	android/widget/ImageView:getTag	()Ljava/lang/Object;
      //   176: aload_2
      //   177: getfield 59	com/whatsapp/util/bi$c:a	Ljava/lang/String;
      //   180: invokevirtual 76	java/lang/Object:equals	(Ljava/lang/Object;)Z
      //   183: ifeq +59 -> 242
      //   186: new 78	com/whatsapp/util/bi$a
      //   189: dup
      //   190: aload_0
      //   191: getfield 13	com/whatsapp/util/bi$d:a	Lcom/whatsapp/util/bi;
      //   194: aload 4
      //   196: aload_2
      //   197: getfield 67	com/whatsapp/util/bi$c:b	Landroid/widget/ImageView;
      //   200: aload_2
      //   201: getfield 59	com/whatsapp/util/bi$c:a	Ljava/lang/String;
      //   204: invokespecial 81	com/whatsapp/util/bi$a:<init>	(Lcom/whatsapp/util/bi;Landroid/graphics/Bitmap;Landroid/widget/ImageView;Ljava/lang/String;)V
      //   207: astore_3
      //   208: new 83	java/lang/StringBuilder
      //   211: dup
      //   212: ldc 85
      //   214: invokespecial 88	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   217: aload_2
      //   218: getfield 59	com/whatsapp/util/bi$c:a	Ljava/lang/String;
      //   221: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   224: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   227: invokestatic 100	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
      //   230: aload_0
      //   231: getfield 13	com/whatsapp/util/bi$d:a	Lcom/whatsapp/util/bi;
      //   234: invokestatic 103	com/whatsapp/util/bi:d	(Lcom/whatsapp/util/bi;)Landroid/os/Handler;
      //   237: aload_3
      //   238: invokevirtual 109	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   241: pop
      //   242: invokestatic 113	java/lang/Thread:interrupted	()Z
      //   245: istore_1
      //   246: iload_1
      //   247: ifeq -247 -> 0
      //   250: return
      //   251: astore_3
      //   252: aload_2
      //   253: monitorexit
      //   254: aload_3
      //   255: athrow
      //   256: astore_2
      //   257: return
      //   258: astore_2
      //   259: aload_3
      //   260: monitorexit
      //   261: aload_2
      //   262: athrow
      //   263: invokestatic 116	com/whatsapp/util/bi:a	()Landroid/graphics/Bitmap;
      //   266: astore_3
      //   267: goto -110 -> 157
      //   270: astore_2
      //   271: aload 5
      //   273: monitorexit
      //   274: aload_2
      //   275: athrow
      //   276: aconst_null
      //   277: astore_2
      //   278: goto -172 -> 106
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	281	0	this	d
      //   245	2	1	bool	boolean
      //   256	1	2	localInterruptedException	InterruptedException
      //   258	4	2	localObject2	Object
      //   270	5	2	localObject3	Object
      //   277	1	2	localObject4	Object
      //   251	9	3	localObject6	Object
      //   266	1	3	localBitmap1	Bitmap
      //   120	75	4	localBitmap2	Bitmap
      //   141	17	6	localf2	f
      //   147	13	7	str	String
      // Exception table:
      //   from	to	target	type
      //   29	44	251	finally
      //   252	254	251	finally
      //   0	29	256	java/lang/InterruptedException
      //   44	73	256	java/lang/InterruptedException
      //   112	134	256	java/lang/InterruptedException
      //   169	242	256	java/lang/InterruptedException
      //   242	246	256	java/lang/InterruptedException
      //   254	256	256	java/lang/InterruptedException
      //   261	263	256	java/lang/InterruptedException
      //   274	276	256	java/lang/InterruptedException
      //   73	106	258	finally
      //   106	108	258	finally
      //   259	261	258	finally
      //   134	149	270	finally
      //   157	169	270	finally
      //   263	267	270	finally
      //   271	274	270	finally
    }
  }
  
  static final class e
  {
    final Stack<bi.c> a = new Stack();
    
    public final void a(ImageView paramImageView)
    {
      int i = 0;
      while (i < this.a.size()) {
        if (((bi.c)this.a.get(i)).b == paramImageView) {
          this.a.remove(i);
        } else {
          i += 1;
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */