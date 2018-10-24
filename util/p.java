package com.whatsapp.util;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.text.TextUtils;
import com.whatsapp.j.a.a;
import com.whatsapp.nr;
import com.whatsapp.protocol.j;
import com.whatsapp.u;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;

public final class p
{
  private static final Object a = new Object();
  
  /* Error */
  private static int a(java.util.zip.ZipFile paramZipFile, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: aload_0
    //   5: ldc 24
    //   7: invokevirtual 30	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   10: astore 4
    //   12: aload 4
    //   14: ifnull +99 -> 113
    //   17: new 32	java/lang/StringBuilder
    //   20: dup
    //   21: ldc 34
    //   23: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   26: aload_1
    //   27: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 43
    //   32: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: ldc 45
    //   41: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: bipush 34
    //   49: invokestatic 55	java/util/regex/Pattern:compile	(Ljava/lang/String;I)Ljava/util/regex/Pattern;
    //   52: astore 5
    //   54: aconst_null
    //   55: astore_1
    //   56: aload_0
    //   57: aload 4
    //   59: invokevirtual 59	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   62: astore_0
    //   63: aload_0
    //   64: astore_1
    //   65: aload 5
    //   67: aload_0
    //   68: invokestatic 62	com/whatsapp/util/p:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   71: invokevirtual 66	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   74: astore 4
    //   76: iload_3
    //   77: istore_2
    //   78: aload_0
    //   79: astore_1
    //   80: aload 4
    //   82: invokevirtual 72	java/util/regex/Matcher:find	()Z
    //   85: ifeq +24 -> 109
    //   88: aload_0
    //   89: astore_1
    //   90: aload 4
    //   92: iconst_1
    //   93: invokevirtual 76	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   96: invokevirtual 81	java/lang/String:trim	()Ljava/lang/String;
    //   99: astore 4
    //   101: aload_0
    //   102: astore_1
    //   103: aload 4
    //   105: invokestatic 87	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   108: istore_2
    //   109: aload_0
    //   110: invokestatic 92	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   113: iload_2
    //   114: ireturn
    //   115: astore 4
    //   117: aload_0
    //   118: astore_1
    //   119: ldc 94
    //   121: aload 4
    //   123: invokestatic 99	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   126: iload_3
    //   127: istore_2
    //   128: goto -19 -> 109
    //   131: astore_0
    //   132: aload_1
    //   133: invokestatic 92	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   136: aload_0
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramZipFile	java.util.zip.ZipFile
    //   0	138	1	paramString	String
    //   1	127	2	i	int
    //   3	124	3	j	int
    //   10	94	4	localObject	Object
    //   115	7	4	localNumberFormatException	NumberFormatException
    //   52	14	5	localPattern	java.util.regex.Pattern
    // Exception table:
    //   from	to	target	type
    //   103	109	115	java/lang/NumberFormatException
    //   56	63	131	finally
    //   65	76	131	finally
    //   80	88	131	finally
    //   90	101	131	finally
    //   103	109	131	finally
    //   119	126	131	finally
  }
  
  /* Error */
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: getstatic 110	android/os/Build$VERSION:SDK_INT	I
    //   6: bipush 21
    //   8: if_icmpge +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: getstatic 18	com/whatsapp/util/p:a	Ljava/lang/Object;
    //   16: astore 6
    //   18: aload 6
    //   20: monitorenter
    //   21: new 112	java/io/File
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 113	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: ldc 114
    //   31: invokestatic 120	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   34: astore_0
    //   35: aload_0
    //   36: ifnonnull +24 -> 60
    //   39: aload 6
    //   41: monitorexit
    //   42: aconst_null
    //   43: areturn
    //   44: astore_0
    //   45: aload 6
    //   47: monitorexit
    //   48: aload_0
    //   49: athrow
    //   50: astore_0
    //   51: aload_0
    //   52: invokestatic 124	com/whatsapp/util/Log:w	(Ljava/lang/Throwable;)V
    //   55: aconst_null
    //   56: astore_0
    //   57: goto -22 -> 35
    //   60: new 126	android/graphics/pdf/PdfRenderer
    //   63: dup
    //   64: aload_0
    //   65: invokespecial 129	android/graphics/pdf/PdfRenderer:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   68: astore 4
    //   70: aload 4
    //   72: ifnonnull +25 -> 97
    //   75: aload_0
    //   76: invokevirtual 132	android/os/ParcelFileDescriptor:close	()V
    //   79: aload 6
    //   81: monitorexit
    //   82: aconst_null
    //   83: areturn
    //   84: astore 4
    //   86: aload 4
    //   88: invokestatic 124	com/whatsapp/util/Log:w	(Ljava/lang/Throwable;)V
    //   91: aconst_null
    //   92: astore 4
    //   94: goto -24 -> 70
    //   97: aload 4
    //   99: invokevirtual 136	android/graphics/pdf/PdfRenderer:getPageCount	()I
    //   102: ifle +78 -> 180
    //   105: aload 4
    //   107: iconst_0
    //   108: invokevirtual 140	android/graphics/pdf/PdfRenderer:openPage	(I)Landroid/graphics/pdf/PdfRenderer$Page;
    //   111: astore 7
    //   113: iload_1
    //   114: iload_2
    //   115: getstatic 146	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   118: invokestatic 152	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   121: astore 5
    //   123: new 154	android/graphics/Canvas
    //   126: dup
    //   127: aload 5
    //   129: invokespecial 157	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   132: iconst_m1
    //   133: invokevirtual 161	android/graphics/Canvas:drawColor	(I)V
    //   136: aload 7
    //   138: invokevirtual 166	android/graphics/pdf/PdfRenderer$Page:getWidth	()I
    //   141: istore_2
    //   142: new 168	android/graphics/Matrix
    //   145: dup
    //   146: invokespecial 169	android/graphics/Matrix:<init>	()V
    //   149: astore 8
    //   151: iload_1
    //   152: i2f
    //   153: iload_2
    //   154: i2f
    //   155: fdiv
    //   156: fstore_3
    //   157: aload 8
    //   159: fload_3
    //   160: fload_3
    //   161: invokevirtual 173	android/graphics/Matrix:setScale	(FF)V
    //   164: aload 7
    //   166: aload 5
    //   168: aconst_null
    //   169: aload 8
    //   171: iconst_1
    //   172: invokevirtual 177	android/graphics/pdf/PdfRenderer$Page:render	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Matrix;I)V
    //   175: aload 7
    //   177: invokevirtual 178	android/graphics/pdf/PdfRenderer$Page:close	()V
    //   180: aload 4
    //   182: invokevirtual 179	android/graphics/pdf/PdfRenderer:close	()V
    //   185: aload_0
    //   186: invokevirtual 132	android/os/ParcelFileDescriptor:close	()V
    //   189: aload 6
    //   191: monitorexit
    //   192: aload 5
    //   194: areturn
    //   195: astore_0
    //   196: goto -117 -> 79
    //   199: astore_0
    //   200: goto -11 -> 189
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramString	String
    //   0	203	1	paramInt1	int
    //   0	203	2	paramInt2	int
    //   156	5	3	f	float
    //   68	3	4	localPdfRenderer	android.graphics.pdf.PdfRenderer
    //   84	3	4	localIOException	java.io.IOException
    //   92	89	4	localObject1	Object
    //   1	192	5	localBitmap	Bitmap
    //   16	174	6	localObject2	Object
    //   111	65	7	localPage	android.graphics.pdf.PdfRenderer.Page
    //   149	21	8	localMatrix	android.graphics.Matrix
    // Exception table:
    //   from	to	target	type
    //   21	35	44	finally
    //   39	42	44	finally
    //   45	48	44	finally
    //   51	55	44	finally
    //   60	70	44	finally
    //   75	79	44	finally
    //   79	82	44	finally
    //   86	91	44	finally
    //   97	180	44	finally
    //   180	185	44	finally
    //   185	189	44	finally
    //   189	192	44	finally
    //   21	35	50	java/io/FileNotFoundException
    //   60	70	84	java/io/IOException
    //   75	79	195	java/io/IOException
    //   185	189	199	java/io/IOException
  }
  
  public static Drawable a(Context paramContext, j paramj)
  {
    String str2 = MediaFileUtils.b(paramj.r).toUpperCase();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramj.y)) {
        str1 = d.l(paramj.y).toUpperCase();
      }
    }
    return a(paramContext, paramj.r, str1);
  }
  
  public static Drawable a(Context paramContext, File paramFile)
  {
    if (paramFile == null) {}
    for (paramFile = "";; paramFile = d.l(paramFile.getAbsolutePath())) {
      return a(paramContext, MediaFileUtils.e(paramFile), paramFile);
    }
  }
  
  public static Drawable a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, null);
  }
  
  private static Drawable a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1 == null)
    {
      if (TextUtils.isEmpty(paramString2)) {}
      for (paramString1 = "";; paramString1 = paramString2.toUpperCase()) {
        return new nr(paramContext, 2130840278, paramString1);
      }
    }
    int i = -1;
    switch (paramString1.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        if (!TextUtils.isEmpty(paramString2)) {}
        break;
      }
      break;
    }
    for (paramString1 = MediaFileUtils.b(paramString1).toUpperCase();; paramString1 = paramString2.toUpperCase())
    {
      return new nr(paramContext, 2130840278, paramString1);
      if (!paramString1.equals("application/pdf")) {
        break;
      }
      i = 0;
      break;
      if (!paramString1.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
        break;
      }
      i = 1;
      break;
      if (!paramString1.equals("application/msword")) {
        break;
      }
      i = 2;
      break;
      if (!paramString1.equals("text/rtf")) {
        break;
      }
      i = 3;
      break;
      if (!paramString1.equals("application/rtf")) {
        break;
      }
      i = 4;
      break;
      if (!paramString1.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
        break;
      }
      i = 5;
      break;
      if (!paramString1.equals("application/vnd.ms-excel")) {
        break;
      }
      i = 6;
      break;
      if (!paramString1.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation")) {
        break;
      }
      i = 7;
      break;
      if (!paramString1.equals("application/vnd.ms-powerpoint")) {
        break;
      }
      i = 8;
      break;
      return new nr(paramContext, 2130840276, MediaFileUtils.b(paramString1).toUpperCase());
      return b.a(paramContext, 2130840275);
      return b.a(paramContext, 2130840279);
      return b.a(paramContext, 2130840277);
    }
  }
  
  /* Error */
  public static android.util.Pair<com.whatsapp.aoi, byte[]> a(com.whatsapp.va paramva, com.whatsapp.oz paramoz, com.whatsapp.vp paramvp, com.whatsapp.and paramand, java.util.List<String> paramList, android.net.Uri paramUri, String paramString, j paramj, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_3
    //   3: aload 5
    //   5: invokestatic 271	com/whatsapp/util/MediaFileUtils:a	(Lcom/whatsapp/va;Lcom/whatsapp/oz;Lcom/whatsapp/and;Landroid/net/Uri;)Ljava/io/File;
    //   8: astore 10
    //   10: aload 10
    //   12: invokevirtual 275	java/io/File:length	()J
    //   15: getstatic 280	com/whatsapp/aic:C	I
    //   18: i2l
    //   19: ldc2_w 281
    //   22: lmul
    //   23: lcmp
    //   24: ifle +11 -> 35
    //   27: new 9	com/whatsapp/util/p$b
    //   30: dup
    //   31: invokespecial 283	com/whatsapp/util/p$b:<init>	()V
    //   34: athrow
    //   35: aload_3
    //   36: aload 5
    //   38: invokestatic 286	com/whatsapp/util/p:a	(Lcom/whatsapp/and;Landroid/net/Uri;)Ljava/lang/String;
    //   41: astore_3
    //   42: ldc_w 288
    //   45: aload 5
    //   47: invokevirtual 293	android/net/Uri:getScheme	()Ljava/lang/String;
    //   50: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifeq +205 -> 258
    //   56: aload 5
    //   58: invokevirtual 296	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   61: astore_0
    //   62: aload_3
    //   63: invokestatic 200	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   66: ifeq +368 -> 434
    //   69: aload_0
    //   70: astore_3
    //   71: iconst_0
    //   72: istore 9
    //   74: ldc -24
    //   76: aload 6
    //   78: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   81: ifeq +188 -> 269
    //   84: new 298	com/whatsapp/util/av
    //   87: dup
    //   88: aload 10
    //   90: invokespecial 301	com/whatsapp/util/av:<init>	(Ljava/io/File;)V
    //   93: astore 5
    //   95: aload 5
    //   97: invokevirtual 303	com/whatsapp/util/av:a	()V
    //   100: aload 5
    //   102: getfield 305	com/whatsapp/util/av:a	I
    //   105: istore 9
    //   107: aconst_null
    //   108: astore 5
    //   110: ldc -24
    //   112: aload 6
    //   114: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   117: ifeq +254 -> 371
    //   120: aload 10
    //   122: invokevirtual 220	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   125: invokestatic 308	com/whatsapp/util/p:b	(Ljava/lang/String;)[B
    //   128: astore 5
    //   130: new 32	java/lang/StringBuilder
    //   133: dup
    //   134: ldc_w 310
    //   137: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   140: aload 6
    //   142: invokestatic 191	com/whatsapp/util/MediaFileUtils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   145: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: astore 11
    //   153: aload_0
    //   154: ifnull +277 -> 431
    //   157: aload_0
    //   158: aload 11
    //   160: invokevirtual 314	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   163: ifeq +268 -> 431
    //   166: aload_0
    //   167: iconst_0
    //   168: aload_0
    //   169: invokevirtual 316	java/lang/String:length	()I
    //   172: aload 11
    //   174: invokevirtual 316	java/lang/String:length	()I
    //   177: isub
    //   178: invokevirtual 320	java/lang/String:substring	(II)Ljava/lang/String;
    //   181: astore_0
    //   182: invokestatic 325	com/whatsapp/u:a	()Landroid/content/Context;
    //   185: aload_1
    //   186: aload 11
    //   188: bipush 9
    //   190: iconst_0
    //   191: iconst_1
    //   192: invokestatic 328	com/whatsapp/util/MediaFileUtils:a	(Landroid/content/Context;Lcom/whatsapp/oz;Ljava/lang/String;BIZ)Ljava/io/File;
    //   195: astore_1
    //   196: aload 10
    //   198: aload_1
    //   199: invokestatic 331	com/whatsapp/util/MediaFileUtils:a	(Ljava/io/File;Ljava/io/File;)V
    //   202: new 333	com/whatsapp/MediaData
    //   205: dup
    //   206: invokespecial 334	com/whatsapp/MediaData:<init>	()V
    //   209: astore 10
    //   211: aload 10
    //   213: aload_1
    //   214: putfield 337	com/whatsapp/MediaData:file	Ljava/io/File;
    //   217: aload_2
    //   218: aload 4
    //   220: aload 10
    //   222: aload_0
    //   223: aload 7
    //   225: iload 8
    //   227: invokevirtual 342	com/whatsapp/vp:a	(Ljava/util/List;Lcom/whatsapp/MediaData;Ljava/lang/String;Lcom/whatsapp/protocol/j;Z)Lcom/whatsapp/aoi;
    //   230: astore_0
    //   231: aload_0
    //   232: new 344	com/whatsapp/util/q
    //   235: dup
    //   236: iload 9
    //   238: aload 6
    //   240: aload_3
    //   241: invokespecial 347	com/whatsapp/util/q:<init>	(ILjava/lang/String;Ljava/lang/String;)V
    //   244: invokevirtual 352	com/whatsapp/aoi:a	(Lcom/whatsapp/util/au;)V
    //   247: new 354	android/util/Pair
    //   250: dup
    //   251: aload_0
    //   252: aload 5
    //   254: invokespecial 357	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   257: areturn
    //   258: aconst_null
    //   259: astore 5
    //   261: aload_3
    //   262: astore_0
    //   263: aload 5
    //   265: astore_3
    //   266: goto -195 -> 71
    //   269: ldc -6
    //   271: aload 6
    //   273: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   276: ifeq +13 -> 289
    //   279: aload 10
    //   281: invokestatic 360	com/whatsapp/util/p:b	(Ljava/io/File;)I
    //   284: istore 9
    //   286: goto -179 -> 107
    //   289: ldc -10
    //   291: aload 6
    //   293: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   296: ifeq +13 -> 309
    //   299: aload 10
    //   301: invokestatic 363	com/whatsapp/util/p:c	(Ljava/io/File;)I
    //   304: istore 9
    //   306: goto -199 -> 107
    //   309: ldc -18
    //   311: aload 6
    //   313: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   316: ifeq +10 -> 326
    //   319: aload 10
    //   321: invokestatic 366	com/whatsapp/util/p:d	(Ljava/io/File;)I
    //   324: istore 9
    //   326: goto -219 -> 107
    //   329: astore_0
    //   330: ldc_w 368
    //   333: aload_0
    //   334: invokestatic 99	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   337: new 6	com/whatsapp/util/p$a
    //   340: dup
    //   341: invokespecial 369	com/whatsapp/util/p$a:<init>	()V
    //   344: athrow
    //   345: astore_0
    //   346: ldc_w 368
    //   349: aload_0
    //   350: invokestatic 99	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   353: aload_0
    //   354: athrow
    //   355: astore 5
    //   357: ldc_w 368
    //   360: aload 5
    //   362: invokestatic 99	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   365: iconst_0
    //   366: istore 9
    //   368: goto -261 -> 107
    //   371: ldc -6
    //   373: aload 6
    //   375: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   378: ifne +23 -> 401
    //   381: ldc -10
    //   383: aload 6
    //   385: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   388: ifne +13 -> 401
    //   391: ldc -18
    //   393: aload 6
    //   395: invokevirtual 236	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   398: ifeq +10 -> 408
    //   401: aload 10
    //   403: invokestatic 372	com/whatsapp/util/p:a	(Ljava/io/File;)[B
    //   406: astore 5
    //   408: goto -278 -> 130
    //   411: astore 5
    //   413: ldc_w 368
    //   416: aload 5
    //   418: invokestatic 99	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   421: aconst_null
    //   422: astore 5
    //   424: goto -294 -> 130
    //   427: astore_0
    //   428: goto -98 -> 330
    //   431: goto -249 -> 182
    //   434: aload_0
    //   435: astore 5
    //   437: aload_3
    //   438: astore_0
    //   439: aload 5
    //   441: astore_3
    //   442: goto -371 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	paramva	com.whatsapp.va
    //   0	445	1	paramoz	com.whatsapp.oz
    //   0	445	2	paramvp	com.whatsapp.vp
    //   0	445	3	paramand	com.whatsapp.and
    //   0	445	4	paramList	java.util.List<String>
    //   0	445	5	paramUri	android.net.Uri
    //   0	445	6	paramString	String
    //   0	445	7	paramj	j
    //   0	445	8	paramBoolean	boolean
    //   72	295	9	i	int
    //   8	394	10	localObject	Object
    //   151	36	11	str	String
    // Exception table:
    //   from	to	target	type
    //   74	107	329	com/whatsapp/util/av$c
    //   269	286	329	com/whatsapp/util/av$c
    //   289	306	329	com/whatsapp/util/av$c
    //   309	326	329	com/whatsapp/util/av$c
    //   74	107	345	com/whatsapp/util/p$a
    //   269	286	345	com/whatsapp/util/p$a
    //   289	306	345	com/whatsapp/util/p$a
    //   309	326	345	com/whatsapp/util/p$a
    //   74	107	355	java/lang/Exception
    //   269	286	355	java/lang/Exception
    //   289	306	355	java/lang/Exception
    //   309	326	355	java/lang/Exception
    //   110	130	411	java/lang/Exception
    //   371	391	411	java/lang/Exception
    //   391	401	411	java/lang/Exception
    //   401	408	411	java/lang/Exception
    //   74	107	427	java/util/zip/ZipException
    //   269	286	427	java/util/zip/ZipException
    //   289	306	427	java/util/zip/ZipException
    //   309	326	427	java/util/zip/ZipException
  }
  
  /* Error */
  public static String a(com.whatsapp.and paramand, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 384	com/whatsapp/and:f	Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: ifnonnull +49 -> 55
    //   9: ldc_w 386
    //   12: invokestatic 388	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   15: aconst_null
    //   16: astore_0
    //   17: aload_0
    //   18: ifnull +95 -> 113
    //   21: aload_0
    //   22: invokeinterface 393 1 0
    //   27: ifle +56 -> 83
    //   30: aload_0
    //   31: invokeinterface 396 1 0
    //   36: ifeq +47 -> 83
    //   39: aload_0
    //   40: iconst_0
    //   41: invokeinterface 399 2 0
    //   46: astore_1
    //   47: aload_0
    //   48: invokeinterface 400 1 0
    //   53: aload_1
    //   54: areturn
    //   55: aload_0
    //   56: aload_1
    //   57: iconst_2
    //   58: anewarray 78	java/lang/String
    //   61: dup
    //   62: iconst_0
    //   63: ldc_w 402
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: ldc_w 404
    //   72: aastore
    //   73: aconst_null
    //   74: aconst_null
    //   75: aconst_null
    //   76: invokevirtual 410	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   79: astore_0
    //   80: goto -63 -> 17
    //   83: aload_0
    //   84: invokeinterface 400 1 0
    //   89: goto +24 -> 113
    //   92: astore_1
    //   93: aload_0
    //   94: invokeinterface 400 1 0
    //   99: aload_1
    //   100: athrow
    //   101: astore_0
    //   102: aload_0
    //   103: invokestatic 413	com/whatsapp/util/Log:i	(Ljava/lang/Throwable;)V
    //   106: goto +7 -> 113
    //   109: astore_0
    //   110: goto -8 -> 102
    //   113: aconst_null
    //   114: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramand	com.whatsapp.and
    //   0	115	1	paramUri	android.net.Uri
    // Exception table:
    //   from	to	target	type
    //   21	47	92	finally
    //   0	5	101	java/lang/IllegalArgumentException
    //   9	15	101	java/lang/IllegalArgumentException
    //   47	53	101	java/lang/IllegalArgumentException
    //   55	80	101	java/lang/IllegalArgumentException
    //   83	89	101	java/lang/IllegalArgumentException
    //   93	101	101	java/lang/IllegalArgumentException
    //   0	5	109	java/lang/UnsupportedOperationException
    //   9	15	109	java/lang/UnsupportedOperationException
    //   47	53	109	java/lang/UnsupportedOperationException
    //   55	80	109	java/lang/UnsupportedOperationException
    //   83	89	109	java/lang/UnsupportedOperationException
    //   93	101	109	java/lang/UnsupportedOperationException
  }
  
  public static String a(j paramj)
  {
    if (paramj.s != 9) {
      return "";
    }
    return a(paramj.r, paramj.x);
  }
  
  private static String a(InputStream paramInputStream)
  {
    try
    {
      localInputStreamReader = new InputStreamReader(paramInputStream, "UTF-8");
      try
      {
        paramInputStream = new StringWriter();
        char[] arrayOfChar = new char['Ѐ'];
        for (;;)
        {
          int i = localInputStreamReader.read(arrayOfChar);
          if (i == -1) {
            break;
          }
          paramInputStream.write(arrayOfChar, 0, i);
        }
        a.d.a(localInputStreamReader);
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        InputStreamReader localInputStreamReader = null;
      }
    }
    throw paramInputStream;
    paramInputStream = paramInputStream.toString();
    a.d.a(localInputStreamReader);
    return paramInputStream;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((paramString == null) || (paramInt == 0)) {
      return "";
    }
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        i = 0;
      }
      break;
    }
    for (;;)
    {
      if (i != 0) {
        break label257;
      }
      return "";
      if (!paramString.equals("application/pdf")) {
        break;
      }
      i = 0;
      break;
      if (!paramString.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
        break;
      }
      i = 1;
      break;
      if (!paramString.equals("application/msword")) {
        break;
      }
      i = 2;
      break;
      if (!paramString.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
        break;
      }
      i = 3;
      break;
      if (!paramString.equals("application/vnd.ms-excel")) {
        break;
      }
      i = 4;
      break;
      if (!paramString.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation")) {
        break;
      }
      i = 5;
      break;
      if (!paramString.equals("application/vnd.ms-powerpoint")) {
        break;
      }
      i = 6;
      break;
      i = 2131230782;
      continue;
      i = 2131230784;
      continue;
      i = 2131230785;
    }
    label257:
    return String.format(u.a.a(i, paramInt), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static boolean a(String paramString)
  {
    return ("application/pdf".equals(paramString)) || ("application/vnd.openxmlformats-officedocument.wordprocessingml.document".equals(paramString)) || ("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet".equals(paramString)) || ("application/vnd.openxmlformats-officedocument.presentationml.presentation".equals(paramString)) || ("application/msword".equals(paramString)) || ("application/vnd.ms-excel".equals(paramString)) || ("application/vnd.ms-powerpoint".equals(paramString)) || ("text/plain".equals(paramString)) || ("text/rtf".equals(paramString)) || ("application/rtf".equals(paramString)) || ("text/csv".equals(paramString));
  }
  
  private static byte[] a(Bitmap paramBitmap)
  {
    int i = 80;
    Object localObject;
    int j;
    do
    {
      localObject = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, i, (OutputStream)localObject);
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      Log.i("mediafileutils/docthumb " + localObject.length + " " + i);
      j = i - 5;
      if (localObject.length <= 20480) {
        break;
      }
      i = j;
    } while (j > 0);
    return (byte[])localObject;
  }
  
  /* Error */
  private static byte[] a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 7
    //   12: new 26	java/util/zip/ZipFile
    //   15: dup
    //   16: aload_0
    //   17: invokevirtual 220	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   20: invokespecial 494	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   23: astore_3
    //   24: aload_3
    //   25: ldc_w 496
    //   28: invokevirtual 30	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   31: astore_0
    //   32: aload_0
    //   33: ifnull +394 -> 427
    //   36: aload_3
    //   37: aload_0
    //   38: invokevirtual 59	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   41: astore 6
    //   43: aload 5
    //   45: astore 4
    //   47: aload 6
    //   49: invokestatic 499	a/a/a/a/d:a	(Ljava/io/InputStream;)[B
    //   52: astore_0
    //   53: aload 5
    //   55: astore 4
    //   57: new 501	android/graphics/BitmapFactory$Options
    //   60: dup
    //   61: invokespecial 502	android/graphics/BitmapFactory$Options:<init>	()V
    //   64: astore 8
    //   66: aload 5
    //   68: astore 4
    //   70: aload 8
    //   72: iconst_1
    //   73: putfield 506	android/graphics/BitmapFactory$Options:inDither	Z
    //   76: aload 5
    //   78: astore 4
    //   80: aload 8
    //   82: iconst_1
    //   83: putfield 509	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   86: aload 5
    //   88: astore 4
    //   90: aload 8
    //   92: iconst_1
    //   93: putfield 512	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   96: aload 5
    //   98: astore 4
    //   100: aload_0
    //   101: iconst_0
    //   102: aload_0
    //   103: arraylength
    //   104: aload 8
    //   106: invokestatic 518	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   109: astore 8
    //   111: aload 7
    //   113: astore_0
    //   114: aload 8
    //   116: ifnull +162 -> 278
    //   119: aload 7
    //   121: astore_0
    //   122: aload 5
    //   124: astore 4
    //   126: aload 8
    //   128: invokevirtual 519	android/graphics/Bitmap:getWidth	()I
    //   131: ifeq +147 -> 278
    //   134: aload 7
    //   136: astore_0
    //   137: aload 5
    //   139: astore 4
    //   141: aload 8
    //   143: invokevirtual 522	android/graphics/Bitmap:getHeight	()I
    //   146: ifeq +132 -> 278
    //   149: aload 5
    //   151: astore 4
    //   153: aload 8
    //   155: invokevirtual 519	android/graphics/Bitmap:getWidth	()I
    //   158: aload 8
    //   160: invokevirtual 522	android/graphics/Bitmap:getHeight	()I
    //   163: invokestatic 528	java/lang/Math:max	(II)I
    //   166: istore_2
    //   167: aload 8
    //   169: astore_0
    //   170: iload_2
    //   171: sipush 480
    //   174: if_icmple +83 -> 257
    //   177: aload 5
    //   179: astore 4
    //   181: ldc_w 529
    //   184: iload_2
    //   185: i2f
    //   186: fdiv
    //   187: fstore_1
    //   188: aload 5
    //   190: astore 4
    //   192: new 168	android/graphics/Matrix
    //   195: dup
    //   196: invokespecial 169	android/graphics/Matrix:<init>	()V
    //   199: astore_0
    //   200: aload 5
    //   202: astore 4
    //   204: aload_0
    //   205: fload_1
    //   206: fload_1
    //   207: invokevirtual 173	android/graphics/Matrix:setScale	(FF)V
    //   210: aload 5
    //   212: astore 4
    //   214: aload 8
    //   216: iconst_0
    //   217: iconst_0
    //   218: aload 8
    //   220: invokevirtual 519	android/graphics/Bitmap:getWidth	()I
    //   223: aload 8
    //   225: invokevirtual 522	android/graphics/Bitmap:getHeight	()I
    //   228: aload_0
    //   229: iconst_1
    //   230: invokestatic 532	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   233: astore 7
    //   235: aload 8
    //   237: astore_0
    //   238: aload 7
    //   240: aload 8
    //   242: if_acmpeq +15 -> 257
    //   245: aload 5
    //   247: astore 4
    //   249: aload 8
    //   251: invokevirtual 535	android/graphics/Bitmap:recycle	()V
    //   254: aload 7
    //   256: astore_0
    //   257: aload 5
    //   259: astore 4
    //   261: aload_0
    //   262: invokestatic 537	com/whatsapp/util/p:a	(Landroid/graphics/Bitmap;)[B
    //   265: astore 5
    //   267: aload 5
    //   269: astore 4
    //   271: aload_0
    //   272: invokevirtual 535	android/graphics/Bitmap:recycle	()V
    //   275: aload 5
    //   277: astore_0
    //   278: aload_0
    //   279: astore 4
    //   281: aload 6
    //   283: invokestatic 92	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   286: aload_3
    //   287: invokevirtual 538	java/util/zip/ZipFile:close	()V
    //   290: aload_0
    //   291: astore 4
    //   293: aload 4
    //   295: areturn
    //   296: astore 5
    //   298: aconst_null
    //   299: astore 6
    //   301: aload 4
    //   303: astore_0
    //   304: aload_0
    //   305: astore 4
    //   307: aload 6
    //   309: invokestatic 92	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   312: aload_0
    //   313: astore 4
    //   315: aload 5
    //   317: athrow
    //   318: astore_0
    //   319: aload 4
    //   321: astore 5
    //   323: aload_0
    //   324: astore 4
    //   326: aload 5
    //   328: astore_0
    //   329: ldc_w 540
    //   332: aload 4
    //   334: invokestatic 99	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   337: aload_0
    //   338: astore 4
    //   340: aload_3
    //   341: ifnull -48 -> 293
    //   344: aload_3
    //   345: invokevirtual 538	java/util/zip/ZipFile:close	()V
    //   348: aload_0
    //   349: areturn
    //   350: astore_3
    //   351: ldc_w 542
    //   354: aload_3
    //   355: invokestatic 99	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   358: aload_0
    //   359: areturn
    //   360: astore_3
    //   361: ldc_w 542
    //   364: aload_3
    //   365: invokestatic 99	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   368: aload_0
    //   369: areturn
    //   370: astore_0
    //   371: aconst_null
    //   372: astore_3
    //   373: aload_3
    //   374: ifnull +7 -> 381
    //   377: aload_3
    //   378: invokevirtual 538	java/util/zip/ZipFile:close	()V
    //   381: aload_0
    //   382: athrow
    //   383: astore_3
    //   384: ldc_w 542
    //   387: aload_3
    //   388: invokestatic 99	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   391: goto -10 -> 381
    //   394: astore_0
    //   395: goto -22 -> 373
    //   398: astore_0
    //   399: goto -26 -> 373
    //   402: astore 4
    //   404: aconst_null
    //   405: astore_0
    //   406: aload 6
    //   408: astore_3
    //   409: goto -80 -> 329
    //   412: astore 4
    //   414: aconst_null
    //   415: astore_0
    //   416: goto -87 -> 329
    //   419: astore 5
    //   421: aload 4
    //   423: astore_0
    //   424: goto -120 -> 304
    //   427: aconst_null
    //   428: astore_0
    //   429: goto -143 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	paramFile	File
    //   187	20	1	f	float
    //   166	19	2	i	int
    //   23	322	3	localZipFile	java.util.zip.ZipFile
    //   350	5	3	localIOException1	java.io.IOException
    //   360	5	3	localIOException2	java.io.IOException
    //   372	6	3	localObject1	Object
    //   383	5	3	localIOException3	java.io.IOException
    //   408	1	3	localInputStream1	InputStream
    //   1	338	4	localObject2	Object
    //   402	1	4	localIOException4	java.io.IOException
    //   412	10	4	localIOException5	java.io.IOException
    //   7	269	5	arrayOfByte	byte[]
    //   296	20	5	localObject3	Object
    //   321	6	5	localObject4	Object
    //   419	1	5	localObject5	Object
    //   4	403	6	localInputStream2	InputStream
    //   10	245	7	localBitmap	Bitmap
    //   64	186	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   36	43	296	finally
    //   281	286	318	java/io/IOException
    //   307	312	318	java/io/IOException
    //   315	318	318	java/io/IOException
    //   344	348	350	java/io/IOException
    //   286	290	360	java/io/IOException
    //   12	24	370	finally
    //   377	381	383	java/io/IOException
    //   24	32	394	finally
    //   281	286	394	finally
    //   307	312	394	finally
    //   315	318	394	finally
    //   329	337	398	finally
    //   12	24	402	java/io/IOException
    //   24	32	412	java/io/IOException
    //   47	53	419	finally
    //   57	66	419	finally
    //   70	76	419	finally
    //   80	86	419	finally
    //   90	96	419	finally
    //   100	111	419	finally
    //   126	134	419	finally
    //   141	149	419	finally
    //   153	167	419	finally
    //   181	188	419	finally
    //   192	200	419	finally
    //   204	210	419	finally
    //   214	235	419	finally
    //   249	254	419	finally
    //   261	267	419	finally
    //   271	275	419	finally
  }
  
  /* Error */
  private static int b(File paramFile)
  {
    // Byte code:
    //   0: new 26	java/util/zip/ZipFile
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 220	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   8: invokespecial 494	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   11: astore 4
    //   13: aload 4
    //   15: astore_3
    //   16: aload 4
    //   18: ldc_w 544
    //   21: invokevirtual 30	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   24: ifnonnull +73 -> 97
    //   27: aload 4
    //   29: astore_3
    //   30: new 32	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 546
    //   37: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload_0
    //   41: invokevirtual 549	java/io/File:getName	()Ljava/lang/String;
    //   44: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 551	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   53: aload 4
    //   55: astore_3
    //   56: new 6	com/whatsapp/util/p$a
    //   59: dup
    //   60: invokespecial 369	com/whatsapp/util/p$a:<init>	()V
    //   63: athrow
    //   64: astore_3
    //   65: aload 4
    //   67: astore_0
    //   68: aload_3
    //   69: astore 4
    //   71: aload_0
    //   72: astore_3
    //   73: ldc_w 553
    //   76: aload 4
    //   78: invokestatic 99	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   81: aload_0
    //   82: astore_3
    //   83: aload 4
    //   85: athrow
    //   86: astore_0
    //   87: aload_3
    //   88: ifnull +7 -> 95
    //   91: aload_3
    //   92: invokevirtual 538	java/util/zip/ZipFile:close	()V
    //   95: aload_0
    //   96: athrow
    //   97: aload 4
    //   99: astore_3
    //   100: aload 4
    //   102: ldc_w 555
    //   105: invokestatic 557	com/whatsapp/util/p:a	(Ljava/util/zip/ZipFile;Ljava/lang/String;)I
    //   108: istore_1
    //   109: iload_1
    //   110: istore_2
    //   111: iload_1
    //   112: ifne +64 -> 176
    //   115: aload 4
    //   117: astore_3
    //   118: iload_1
    //   119: istore_2
    //   120: aload 4
    //   122: new 32	java/lang/StringBuilder
    //   125: dup
    //   126: ldc_w 559
    //   129: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: iload_1
    //   133: iconst_1
    //   134: iadd
    //   135: invokevirtual 489	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: ldc_w 561
    //   141: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokevirtual 30	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   150: ifnull +26 -> 176
    //   153: iload_1
    //   154: iconst_1
    //   155: iadd
    //   156: istore_1
    //   157: goto -42 -> 115
    //   160: astore_0
    //   161: aload 4
    //   163: astore_3
    //   164: ldc_w 553
    //   167: aload_0
    //   168: invokestatic 99	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   171: iconst_0
    //   172: istore_1
    //   173: goto -64 -> 109
    //   176: aload 4
    //   178: invokevirtual 538	java/util/zip/ZipFile:close	()V
    //   181: iload_2
    //   182: ireturn
    //   183: astore_0
    //   184: ldc_w 553
    //   187: aload_0
    //   188: invokestatic 99	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   191: iload_2
    //   192: ireturn
    //   193: astore_3
    //   194: ldc_w 553
    //   197: aload_3
    //   198: invokestatic 99	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   201: goto -106 -> 95
    //   204: astore_0
    //   205: aconst_null
    //   206: astore_3
    //   207: goto -120 -> 87
    //   210: astore 4
    //   212: aconst_null
    //   213: astore_0
    //   214: goto -143 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramFile	File
    //   108	65	1	i	int
    //   110	82	2	j	int
    //   15	41	3	localObject1	Object
    //   64	5	3	localIOException1	java.io.IOException
    //   72	92	3	localObject2	Object
    //   193	5	3	localIOException2	java.io.IOException
    //   206	1	3	localObject3	Object
    //   11	166	4	localObject4	Object
    //   210	1	4	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   16	27	64	java/io/IOException
    //   30	53	64	java/io/IOException
    //   56	64	64	java/io/IOException
    //   120	153	64	java/io/IOException
    //   164	171	64	java/io/IOException
    //   16	27	86	finally
    //   30	53	86	finally
    //   56	64	86	finally
    //   73	81	86	finally
    //   83	86	86	finally
    //   100	109	86	finally
    //   120	153	86	finally
    //   164	171	86	finally
    //   100	109	160	java/io/IOException
    //   176	181	183	java/io/IOException
    //   91	95	193	java/io/IOException
    //   0	13	204	finally
    //   0	13	210	java/io/IOException
  }
  
  /* Error */
  private static byte[] b(String paramString)
  {
    // Byte code:
    //   0: sipush 480
    //   3: istore_2
    //   4: aconst_null
    //   5: astore 6
    //   7: getstatic 110	android/os/Build$VERSION:SDK_INT	I
    //   10: bipush 21
    //   12: if_icmpge +5 -> 17
    //   15: aconst_null
    //   16: areturn
    //   17: getstatic 18	com/whatsapp/util/p:a	Ljava/lang/Object;
    //   20: astore 7
    //   22: aload 7
    //   24: monitorenter
    //   25: new 112	java/io/File
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 113	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: ldc 114
    //   35: invokestatic 120	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   38: astore_0
    //   39: aload_0
    //   40: ifnonnull +24 -> 64
    //   43: aload 7
    //   45: monitorexit
    //   46: aconst_null
    //   47: areturn
    //   48: astore_0
    //   49: aload 7
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    //   54: astore_0
    //   55: aload_0
    //   56: invokestatic 124	com/whatsapp/util/Log:w	(Ljava/lang/Throwable;)V
    //   59: aconst_null
    //   60: astore_0
    //   61: goto -22 -> 39
    //   64: new 126	android/graphics/pdf/PdfRenderer
    //   67: dup
    //   68: aload_0
    //   69: invokespecial 129	android/graphics/pdf/PdfRenderer:<init>	(Landroid/os/ParcelFileDescriptor;)V
    //   72: astore 5
    //   74: aload 5
    //   76: ifnonnull +25 -> 101
    //   79: aload_0
    //   80: invokevirtual 132	android/os/ParcelFileDescriptor:close	()V
    //   83: aload 7
    //   85: monitorexit
    //   86: aconst_null
    //   87: areturn
    //   88: astore 5
    //   90: aload 5
    //   92: invokestatic 124	com/whatsapp/util/Log:w	(Ljava/lang/Throwable;)V
    //   95: aconst_null
    //   96: astore 5
    //   98: goto -24 -> 74
    //   101: aload 5
    //   103: invokevirtual 136	android/graphics/pdf/PdfRenderer:getPageCount	()I
    //   106: ifle +140 -> 246
    //   109: aload 5
    //   111: iconst_0
    //   112: invokevirtual 140	android/graphics/pdf/PdfRenderer:openPage	(I)Landroid/graphics/pdf/PdfRenderer$Page;
    //   115: astore 8
    //   117: aload 8
    //   119: invokevirtual 166	android/graphics/pdf/PdfRenderer$Page:getWidth	()I
    //   122: istore_3
    //   123: aload 8
    //   125: invokevirtual 562	android/graphics/pdf/PdfRenderer$Page:getHeight	()I
    //   128: istore 4
    //   130: iload_3
    //   131: iload 4
    //   133: if_icmple +128 -> 261
    //   136: iload 4
    //   138: sipush 480
    //   141: imul
    //   142: iload_3
    //   143: idiv
    //   144: istore_1
    //   145: new 32	java/lang/StringBuilder
    //   148: dup
    //   149: ldc_w 564
    //   152: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: iload_3
    //   156: invokevirtual 489	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: ldc_w 565
    //   162: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: iload 4
    //   167: invokevirtual 489	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: ldc_w 567
    //   173: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: iload_2
    //   177: invokevirtual 489	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   180: ldc_w 565
    //   183: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: iload_1
    //   187: invokevirtual 489	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 493	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   196: iload_2
    //   197: iload_1
    //   198: getstatic 146	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   201: invokestatic 152	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   204: astore 9
    //   206: new 154	android/graphics/Canvas
    //   209: dup
    //   210: aload 9
    //   212: invokespecial 157	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   215: iconst_m1
    //   216: invokevirtual 161	android/graphics/Canvas:drawColor	(I)V
    //   219: aload 8
    //   221: aload 9
    //   223: aconst_null
    //   224: aconst_null
    //   225: iconst_1
    //   226: invokevirtual 177	android/graphics/pdf/PdfRenderer$Page:render	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Matrix;I)V
    //   229: aload 9
    //   231: invokestatic 537	com/whatsapp/util/p:a	(Landroid/graphics/Bitmap;)[B
    //   234: astore 6
    //   236: aload 9
    //   238: invokevirtual 535	android/graphics/Bitmap:recycle	()V
    //   241: aload 8
    //   243: invokevirtual 178	android/graphics/pdf/PdfRenderer$Page:close	()V
    //   246: aload 5
    //   248: invokevirtual 179	android/graphics/pdf/PdfRenderer:close	()V
    //   251: aload_0
    //   252: invokevirtual 132	android/os/ParcelFileDescriptor:close	()V
    //   255: aload 7
    //   257: monitorexit
    //   258: aload 6
    //   260: areturn
    //   261: iload_3
    //   262: sipush 480
    //   265: imul
    //   266: iload 4
    //   268: idiv
    //   269: istore_2
    //   270: sipush 480
    //   273: istore_1
    //   274: goto -129 -> 145
    //   277: astore_0
    //   278: goto -195 -> 83
    //   281: astore_0
    //   282: goto -27 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	paramString	String
    //   144	130	1	i	int
    //   3	267	2	j	int
    //   122	144	3	k	int
    //   128	141	4	m	int
    //   72	3	5	localPdfRenderer	android.graphics.pdf.PdfRenderer
    //   88	3	5	localIOException	java.io.IOException
    //   96	151	5	localObject1	Object
    //   5	254	6	arrayOfByte	byte[]
    //   20	236	7	localObject2	Object
    //   115	127	8	localPage	android.graphics.pdf.PdfRenderer.Page
    //   204	33	9	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   25	39	48	finally
    //   43	46	48	finally
    //   49	52	48	finally
    //   55	59	48	finally
    //   64	74	48	finally
    //   79	83	48	finally
    //   83	86	48	finally
    //   90	95	48	finally
    //   101	130	48	finally
    //   136	145	48	finally
    //   145	246	48	finally
    //   246	251	48	finally
    //   251	255	48	finally
    //   255	258	48	finally
    //   261	270	48	finally
    //   25	39	54	java/io/FileNotFoundException
    //   64	74	88	java/io/IOException
    //   79	83	277	java/io/IOException
    //   251	255	281	java/io/IOException
  }
  
  /* Error */
  private static int c(File paramFile)
  {
    // Byte code:
    //   0: new 26	java/util/zip/ZipFile
    //   3: dup
    //   4: aload_0
    //   5: invokevirtual 220	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   8: invokespecial 494	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: aload_3
    //   13: astore_2
    //   14: aload_3
    //   15: ldc_w 544
    //   18: invokevirtual 30	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   21: ifnonnull +67 -> 88
    //   24: aload_3
    //   25: astore_2
    //   26: new 32	java/lang/StringBuilder
    //   29: dup
    //   30: ldc_w 546
    //   33: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   36: aload_0
    //   37: invokevirtual 549	java/io/File:getName	()Ljava/lang/String;
    //   40: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 551	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   49: aload_3
    //   50: astore_2
    //   51: new 6	com/whatsapp/util/p$a
    //   54: dup
    //   55: invokespecial 369	com/whatsapp/util/p$a:<init>	()V
    //   58: athrow
    //   59: astore_2
    //   60: aload_3
    //   61: astore_0
    //   62: aload_2
    //   63: astore_3
    //   64: aload_0
    //   65: astore_2
    //   66: ldc_w 569
    //   69: aload_3
    //   70: invokestatic 99	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   73: aload_0
    //   74: astore_2
    //   75: aload_3
    //   76: athrow
    //   77: astore_0
    //   78: aload_2
    //   79: ifnull +7 -> 86
    //   82: aload_2
    //   83: invokevirtual 538	java/util/zip/ZipFile:close	()V
    //   86: aload_0
    //   87: athrow
    //   88: iconst_0
    //   89: istore_1
    //   90: aload_3
    //   91: astore_2
    //   92: aload_3
    //   93: new 32	java/lang/StringBuilder
    //   96: dup
    //   97: ldc_w 571
    //   100: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   103: iload_1
    //   104: iconst_1
    //   105: iadd
    //   106: invokevirtual 489	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: ldc_w 561
    //   112: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokevirtual 30	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   121: astore_0
    //   122: aload_0
    //   123: ifnull +10 -> 133
    //   126: iload_1
    //   127: iconst_1
    //   128: iadd
    //   129: istore_1
    //   130: goto -40 -> 90
    //   133: aload_3
    //   134: invokevirtual 538	java/util/zip/ZipFile:close	()V
    //   137: iload_1
    //   138: ireturn
    //   139: astore_0
    //   140: ldc_w 569
    //   143: aload_0
    //   144: invokestatic 99	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   147: iload_1
    //   148: ireturn
    //   149: astore_2
    //   150: ldc_w 569
    //   153: aload_2
    //   154: invokestatic 99	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   157: goto -71 -> 86
    //   160: astore_0
    //   161: aconst_null
    //   162: astore_2
    //   163: goto -85 -> 78
    //   166: astore_3
    //   167: aconst_null
    //   168: astore_0
    //   169: goto -105 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramFile	File
    //   89	59	1	i	int
    //   13	38	2	localObject1	Object
    //   59	4	2	localIOException1	java.io.IOException
    //   65	27	2	localObject2	Object
    //   149	5	2	localIOException2	java.io.IOException
    //   162	1	2	localObject3	Object
    //   11	123	3	localObject4	Object
    //   166	1	3	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   14	24	59	java/io/IOException
    //   26	49	59	java/io/IOException
    //   51	59	59	java/io/IOException
    //   92	122	59	java/io/IOException
    //   14	24	77	finally
    //   26	49	77	finally
    //   51	59	77	finally
    //   66	73	77	finally
    //   75	77	77	finally
    //   92	122	77	finally
    //   133	137	139	java/io/IOException
    //   82	86	149	java/io/IOException
    //   0	12	160	finally
    //   0	12	166	java/io/IOException
  }
  
  /* Error */
  private static int d(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 26	java/util/zip/ZipFile
    //   6: dup
    //   7: aload_0
    //   8: invokevirtual 220	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   11: invokespecial 494	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   14: astore_3
    //   15: aload_3
    //   16: ldc_w 544
    //   19: invokevirtual 30	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   22: ifnonnull +67 -> 89
    //   25: new 32	java/lang/StringBuilder
    //   28: dup
    //   29: ldc_w 546
    //   32: invokespecial 37	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   35: aload_0
    //   36: invokevirtual 549	java/io/File:getName	()Ljava/lang/String;
    //   39: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 551	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   48: new 6	com/whatsapp/util/p$a
    //   51: dup
    //   52: invokespecial 369	com/whatsapp/util/p$a:<init>	()V
    //   55: athrow
    //   56: astore 4
    //   58: aload_3
    //   59: astore_0
    //   60: aload 4
    //   62: astore_3
    //   63: ldc_w 553
    //   66: aload_3
    //   67: invokestatic 99	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   70: aload_3
    //   71: athrow
    //   72: astore 4
    //   74: aload_0
    //   75: astore_3
    //   76: aload 4
    //   78: astore_0
    //   79: aload_3
    //   80: ifnull +7 -> 87
    //   83: aload_3
    //   84: invokevirtual 538	java/util/zip/ZipFile:close	()V
    //   87: aload_0
    //   88: athrow
    //   89: iconst_0
    //   90: istore_1
    //   91: aload_3
    //   92: ldc_w 573
    //   95: invokestatic 557	com/whatsapp/util/p:a	(Ljava/util/zip/ZipFile;Ljava/lang/String;)I
    //   98: istore_2
    //   99: iload_2
    //   100: istore_1
    //   101: aload_3
    //   102: invokevirtual 538	java/util/zip/ZipFile:close	()V
    //   105: iload_1
    //   106: ireturn
    //   107: astore_0
    //   108: ldc_w 553
    //   111: aload_0
    //   112: invokestatic 99	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: goto -14 -> 101
    //   118: astore_0
    //   119: goto -40 -> 79
    //   122: astore_0
    //   123: ldc_w 553
    //   126: aload_0
    //   127: invokestatic 99	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   130: iload_1
    //   131: ireturn
    //   132: astore_3
    //   133: ldc_w 553
    //   136: aload_3
    //   137: invokestatic 99	com/whatsapp/util/Log:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   140: goto -53 -> 87
    //   143: astore_0
    //   144: aconst_null
    //   145: astore_3
    //   146: goto -67 -> 79
    //   149: astore_3
    //   150: aload 4
    //   152: astore_0
    //   153: goto -90 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	paramFile	File
    //   90	41	1	i	int
    //   98	2	2	j	int
    //   14	88	3	localObject1	Object
    //   132	5	3	localIOException1	java.io.IOException
    //   145	1	3	localObject2	Object
    //   149	1	3	localIOException2	java.io.IOException
    //   1	1	4	localObject3	Object
    //   56	5	4	localIOException3	java.io.IOException
    //   72	79	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   15	56	56	java/io/IOException
    //   108	115	56	java/io/IOException
    //   63	72	72	finally
    //   91	99	107	java/io/IOException
    //   15	56	118	finally
    //   91	99	118	finally
    //   108	115	118	finally
    //   101	105	122	java/io/IOException
    //   83	87	132	java/io/IOException
    //   3	15	143	finally
    //   3	15	149	java/io/IOException
  }
  
  public static final class a
    extends Exception
  {}
  
  public static final class b
    extends Exception
  {}
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */