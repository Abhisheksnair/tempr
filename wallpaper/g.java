package com.whatsapp.wallpaper;

import a.a.a.a.d;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.view.Display;
import android.view.WindowManager;
import com.whatsapp.and;
import com.whatsapp.aoa;
import com.whatsapp.atu;
import com.whatsapp.au;
import com.whatsapp.ox;
import com.whatsapp.oz;
import com.whatsapp.pv;
import com.whatsapp.r;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.va;
import com.whatsapp.vv;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class g
{
  public static final String a = au.b() + ".intent.action.RESET_WALLPAPER";
  private static final String d = au.b() + ".intent.action.PICK_PHOTO";
  private static final String e = au.b() + ".intent.action.SOLID_COLOR_WALLPAPER";
  private static final String f = au.b() + ".intent.action.SET_WALLPAPER";
  private static final String g = au.b() + ".intent.action.DEFAULT_WALLPAPER";
  private static final g h = new g(pv.a(), va.a(), oz.a(), ox.a(), and.a(), vv.a(), atu.a());
  public boolean b;
  public final ox c;
  private Drawable i;
  private final pv j;
  private final va k;
  private final oz l;
  private final and m;
  private final vv n;
  private final atu o;
  
  private g(pv parampv, va paramva, oz paramoz, ox paramox, and paramand, vv paramvv, atu paramatu)
  {
    this.j = parampv;
    this.k = paramva;
    this.l = paramoz;
    this.c = paramox;
    this.m = paramand;
    this.n = paramvv;
    this.o = paramatu;
  }
  
  private static Bitmap a(InputStream paramInputStream)
  {
    paramInputStream = d.a(paramInputStream);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    localOptions.inDither = false;
    localOptions.inInputShareable = true;
    localOptions.inPurgeable = true;
    return BitmapFactory.decodeByteArray(paramInputStream, 0, paramInputStream.length, localOptions);
  }
  
  public static g a()
  {
    return h;
  }
  
  public static File a(Context paramContext)
  {
    return new File(paramContext.getFilesDir(), "wallpaper.jpg");
  }
  
  public static void a(Context paramContext, String paramString, int paramInt1, boolean paramBoolean, int paramInt2, Uri paramUri)
  {
    Log.i("wallpaper/setWallPaper:[" + paramString + " | " + paramInt2 + " | " + paramUri + " | " + paramInt1 + "]");
    if (paramBoolean) {
      paramUri = "0@" + paramInt2;
    }
    for (;;)
    {
      paramContext.getSharedPreferences("com.whatsapp_preferences", 0).edit().putString("wallpaper-" + paramString, paramUri).apply();
      return;
      if (paramUri != null) {
        paramUri = "1@" + paramUri;
      } else {
        paramUri = "2@" + paramInt1;
      }
    }
  }
  
  static void a(BitmapFactory.Options paramOptions, int paramInt)
  {
    paramOptions.inSampleSize = 1;
    int i2 = paramOptions.outWidth;
    int i1 = paramOptions.outHeight;
    while (i2 > paramInt << 1)
    {
      i2 /= 2;
      i1 /= 2;
      paramOptions.inSampleSize <<= 1;
    }
    long l1 = Runtime.getRuntime().maxMemory();
    while (i2 * i1 << 1 > l1 / 16L)
    {
      i2 /= 2;
      i1 /= 2;
      paramOptions.inSampleSize <<= 1;
    }
    paramOptions.inJustDecodeBounds = false;
    paramOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    paramOptions.inDither = true;
    paramOptions.inPurgeable = true;
    paramOptions.inInputShareable = true;
  }
  
  public static Point f(Context paramContext)
  {
    Point localPoint = new Point();
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 13) {
      localDisplay.getSize(localPoint);
    }
    for (;;)
    {
      if (paramContext.getResources().getConfiguration().orientation == 2)
      {
        int i1 = localPoint.y;
        localPoint.y = localPoint.x;
        localPoint.x = i1;
      }
      localPoint.y -= (int)paramContext.getResources().getDimension(2131361793) + aoa.b();
      return localPoint;
      localPoint.x = localDisplay.getWidth();
      localPoint.y = localDisplay.getHeight();
    }
  }
  
  public static Intent g(Context paramContext)
  {
    Intent localIntent1 = new Intent(d, null);
    localIntent1.setPackage(au.b());
    Intent localIntent2 = new Intent(e, null);
    localIntent2.setPackage(au.b());
    Intent localIntent3 = new Intent(f, null);
    localIntent3.putExtra("orientation", paramContext.getResources().getConfiguration().orientation);
    localIntent3.setPackage(au.b());
    Intent localIntent4 = new Intent(g, null);
    localIntent4.setPackage(au.b());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localIntent1);
    localArrayList.add(localIntent2);
    localArrayList.add(localIntent3);
    localArrayList.add(localIntent4);
    localIntent1 = new Intent(a, null);
    localIntent1.setPackage(au.b());
    d.a(localArrayList, localIntent1);
    paramContext = Intent.createChooser(localIntent1, paramContext.getString(2131297469));
    paramContext.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])localArrayList.toArray(new Intent[localArrayList.size()]));
    return paramContext;
  }
  
  public final Drawable a(Context paramContext, String paramString)
  {
    String str = paramContext.getSharedPreferences("com.whatsapp_preferences", 0).getString("wallpaper-" + paramString, "");
    Log.i("wallpaper/getWallPaper:[" + paramString + "]");
    paramString = str.split("@");
    if (paramString.length < 2) {
      return null;
    }
    if (paramString[0].equalsIgnoreCase("0")) {
      try
      {
        paramContext = paramContext.getPackageManager().getResourcesForApplication("com.whatsapp.wallpaper").getDrawable(Integer.parseInt(paramString[1]));
        return paramContext;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.e(paramContext.toString());
        return null;
      }
    }
    if (paramString[0].equalsIgnoreCase("1"))
    {
      paramString = Uri.parse(paramString[1]);
      try
      {
        paramString = a(MediaFileUtils.a(this.m, paramString));
        paramContext = new BitmapDrawable(paramContext.getResources(), paramString);
        return paramContext;
      }
      catch (IOException paramContext)
      {
        Log.e(paramContext.toString());
        return null;
      }
    }
    try
    {
      int i1 = Integer.parseInt(paramString[1]);
      paramString = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
      paramString.setPixel(0, 0, i1);
      paramContext = new BitmapDrawable(paramContext.getResources(), paramString);
      return paramContext;
    }
    catch (NumberFormatException paramContext)
    {
      Log.e(paramContext.toString());
    }
    return null;
  }
  
  /* Error */
  public final Drawable a(Context paramContext, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2, Uri paramUri, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: new 34	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 456
    //   7: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: iload 4
    //   12: invokevirtual 459	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   15: ldc_w 461
    //   18: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: iload 7
    //   23: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   26: ldc_w 462
    //   29: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: iload 8
    //   34: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokestatic 193	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   43: aload_0
    //   44: aconst_null
    //   45: putfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   48: iload_2
    //   49: ifeq +98 -> 147
    //   52: iconst_1
    //   53: iconst_1
    //   54: getstatic 140	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   57: invokestatic 442	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   60: astore 6
    //   62: aload 6
    //   64: iconst_0
    //   65: iconst_0
    //   66: iload_3
    //   67: invokevirtual 446	android/graphics/Bitmap:setPixel	(III)V
    //   70: aload_0
    //   71: new 432	android/graphics/drawable/BitmapDrawable
    //   74: dup
    //   75: aload_1
    //   76: invokevirtual 279	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   79: aload 6
    //   81: invokespecial 435	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   84: putfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   87: aload_0
    //   88: getfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   91: ifnull +51 -> 142
    //   94: aload_1
    //   95: ldc -86
    //   97: iconst_0
    //   98: invokevirtual 468	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   101: astore 13
    //   103: aconst_null
    //   104: astore 12
    //   106: aload_0
    //   107: getfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   110: checkcast 432	android/graphics/drawable/BitmapDrawable
    //   113: invokevirtual 472	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   116: getstatic 478	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   119: bipush 90
    //   121: aload 13
    //   123: invokevirtual 482	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   126: pop
    //   127: aload 13
    //   129: ifnull +8 -> 137
    //   132: aload 13
    //   134: invokevirtual 487	java/io/FileOutputStream:close	()V
    //   137: aload_0
    //   138: aload_1
    //   139: invokevirtual 490	com/whatsapp/wallpaper/g:e	(Landroid/content/Context;)V
    //   142: aload_0
    //   143: getfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   146: areturn
    //   147: iload 4
    //   149: ifeq +337 -> 486
    //   152: aload_0
    //   153: aload_1
    //   154: invokevirtual 394	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   157: ldc_w 396
    //   160: invokevirtual 402	android/content/pm/PackageManager:getResourcesForApplication	(Ljava/lang/String;)Landroid/content/res/Resources;
    //   163: iload 5
    //   165: invokevirtual 412	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   168: putfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   171: aload_0
    //   172: getfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   175: checkcast 432	android/graphics/drawable/BitmapDrawable
    //   178: invokevirtual 472	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   181: astore 11
    //   183: aload 11
    //   185: ifnonnull +56 -> 241
    //   188: aconst_null
    //   189: astore 6
    //   191: aload 6
    //   193: ifnull +274 -> 467
    //   196: aload_0
    //   197: new 432	android/graphics/drawable/BitmapDrawable
    //   200: dup
    //   201: aload 6
    //   203: invokespecial 493	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/graphics/Bitmap;)V
    //   206: putfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   209: goto -122 -> 87
    //   212: astore 6
    //   214: ldc_w 495
    //   217: aload 6
    //   219: invokestatic 498	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   222: aload_0
    //   223: getfield 113	com/whatsapp/wallpaper/g:j	Lcom/whatsapp/pv;
    //   226: aload_1
    //   227: aload_1
    //   228: ldc_w 499
    //   231: invokevirtual 344	android/content/Context:getString	(I)Ljava/lang/String;
    //   234: iconst_0
    //   235: invokevirtual 502	com/whatsapp/pv:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   238: goto -151 -> 87
    //   241: aload 11
    //   243: invokevirtual 503	android/graphics/Bitmap:getWidth	()I
    //   246: i2f
    //   247: iload 7
    //   249: i2f
    //   250: fdiv
    //   251: fstore 9
    //   253: aload 11
    //   255: invokevirtual 504	android/graphics/Bitmap:getHeight	()I
    //   258: i2f
    //   259: iload 8
    //   261: i2f
    //   262: fdiv
    //   263: fstore 10
    //   265: fload 9
    //   267: fload 10
    //   269: fcmpl
    //   270: ifle +96 -> 366
    //   273: aload 11
    //   275: invokevirtual 503	android/graphics/Bitmap:getWidth	()I
    //   278: i2f
    //   279: fload 10
    //   281: fdiv
    //   282: f2i
    //   283: istore_3
    //   284: aload 11
    //   286: astore 6
    //   288: iload_3
    //   289: ifle -98 -> 191
    //   292: aload 11
    //   294: astore 6
    //   296: iload 8
    //   298: ifle -107 -> 191
    //   301: aload 11
    //   303: astore 6
    //   305: iload 7
    //   307: ifle -116 -> 191
    //   310: aload 11
    //   312: iload_3
    //   313: iload 8
    //   315: iconst_1
    //   316: invokestatic 508	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   319: astore 12
    //   321: aload 12
    //   323: aload 12
    //   325: invokevirtual 503	android/graphics/Bitmap:getWidth	()I
    //   328: iload 7
    //   330: isub
    //   331: iconst_2
    //   332: idiv
    //   333: iconst_0
    //   334: iload 7
    //   336: iload 8
    //   338: invokestatic 511	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   341: astore 11
    //   343: aload 11
    //   345: astore 6
    //   347: aload 11
    //   349: aload 12
    //   351: if_acmpeq -160 -> 191
    //   354: aload 12
    //   356: invokevirtual 514	android/graphics/Bitmap:recycle	()V
    //   359: aload 11
    //   361: astore 6
    //   363: goto -172 -> 191
    //   366: aload 11
    //   368: invokevirtual 504	android/graphics/Bitmap:getHeight	()I
    //   371: i2f
    //   372: iload 7
    //   374: i2f
    //   375: fmul
    //   376: aload 11
    //   378: invokevirtual 503	android/graphics/Bitmap:getWidth	()I
    //   381: i2f
    //   382: fdiv
    //   383: f2i
    //   384: istore_3
    //   385: aload 11
    //   387: astore 6
    //   389: iload_3
    //   390: ifle -199 -> 191
    //   393: aload 11
    //   395: astore 6
    //   397: iload 8
    //   399: ifle -208 -> 191
    //   402: aload 11
    //   404: astore 6
    //   406: iload 7
    //   408: ifle -217 -> 191
    //   411: aload 11
    //   413: iload 7
    //   415: iload_3
    //   416: iconst_1
    //   417: invokestatic 508	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   420: astore 12
    //   422: aload 12
    //   424: iconst_0
    //   425: aload 12
    //   427: invokevirtual 504	android/graphics/Bitmap:getHeight	()I
    //   430: iload 8
    //   432: isub
    //   433: iconst_2
    //   434: idiv
    //   435: iload 7
    //   437: iload 8
    //   439: invokestatic 511	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   442: astore 11
    //   444: aload 11
    //   446: astore 6
    //   448: aload 11
    //   450: aload 12
    //   452: if_acmpeq -261 -> 191
    //   455: aload 12
    //   457: invokevirtual 514	android/graphics/Bitmap:recycle	()V
    //   460: aload 11
    //   462: astore 6
    //   464: goto -273 -> 191
    //   467: aload_0
    //   468: getfield 113	com/whatsapp/wallpaper/g:j	Lcom/whatsapp/pv;
    //   471: aload_1
    //   472: aload_1
    //   473: ldc_w 499
    //   476: invokevirtual 344	android/content/Context:getString	(I)Ljava/lang/String;
    //   479: iconst_0
    //   480: invokevirtual 502	com/whatsapp/pv:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   483: goto -396 -> 87
    //   486: aload_0
    //   487: getfield 121	com/whatsapp/wallpaper/g:m	Lcom/whatsapp/and;
    //   490: aload 6
    //   492: invokestatic 428	com/whatsapp/util/MediaFileUtils:a	(Lcom/whatsapp/and;Landroid/net/Uri;)Ljava/io/InputStream;
    //   495: astore 13
    //   497: aconst_null
    //   498: astore 12
    //   500: aload 13
    //   502: invokestatic 430	com/whatsapp/wallpaper/g:a	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   505: astore 6
    //   507: aload 6
    //   509: ifnull +51 -> 560
    //   512: aload_0
    //   513: new 432	android/graphics/drawable/BitmapDrawable
    //   516: dup
    //   517: aload_1
    //   518: invokevirtual 279	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   521: aload 6
    //   523: invokespecial 435	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   526: putfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   529: aload_0
    //   530: iconst_1
    //   531: putfield 516	com/whatsapp/wallpaper/g:b	Z
    //   534: aload 13
    //   536: ifnull -449 -> 87
    //   539: aload 13
    //   541: invokevirtual 519	java/io/InputStream:close	()V
    //   544: goto -457 -> 87
    //   547: astore 6
    //   549: aload 6
    //   551: invokevirtual 436	java/io/IOException:toString	()Ljava/lang/String;
    //   554: invokestatic 415	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   557: goto -470 -> 87
    //   560: aload_0
    //   561: getfield 113	com/whatsapp/wallpaper/g:j	Lcom/whatsapp/pv;
    //   564: aload_1
    //   565: aload_1
    //   566: ldc_w 499
    //   569: invokevirtual 344	android/content/Context:getString	(I)Ljava/lang/String;
    //   572: iconst_0
    //   573: invokevirtual 502	com/whatsapp/pv:b	(Landroid/content/Context;Ljava/lang/String;I)V
    //   576: goto -47 -> 529
    //   579: astore 6
    //   581: aload 6
    //   583: athrow
    //   584: astore 11
    //   586: aload 6
    //   588: astore 12
    //   590: aload 11
    //   592: astore 6
    //   594: aload 13
    //   596: ifnull +13 -> 609
    //   599: aload 12
    //   601: ifnull +11 -> 612
    //   604: aload 13
    //   606: invokevirtual 519	java/io/InputStream:close	()V
    //   609: aload 6
    //   611: athrow
    //   612: aload 13
    //   614: invokevirtual 519	java/io/InputStream:close	()V
    //   617: goto -8 -> 609
    //   620: astore 6
    //   622: aload 6
    //   624: athrow
    //   625: astore 11
    //   627: aload 6
    //   629: astore 12
    //   631: aload 11
    //   633: astore 6
    //   635: aload 13
    //   637: ifnull +13 -> 650
    //   640: aload 12
    //   642: ifnull +24 -> 666
    //   645: aload 13
    //   647: invokevirtual 487	java/io/FileOutputStream:close	()V
    //   650: aload 6
    //   652: athrow
    //   653: astore 6
    //   655: aload 6
    //   657: invokevirtual 436	java/io/IOException:toString	()Ljava/lang/String;
    //   660: invokestatic 415	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   663: goto -526 -> 137
    //   666: aload 13
    //   668: invokevirtual 487	java/io/FileOutputStream:close	()V
    //   671: goto -21 -> 650
    //   674: astore 11
    //   676: goto -67 -> 609
    //   679: astore 11
    //   681: goto -31 -> 650
    //   684: astore 6
    //   686: goto -51 -> 635
    //   689: astore 6
    //   691: goto -97 -> 594
    //   694: astore 6
    //   696: goto -482 -> 214
    //   699: astore 6
    //   701: goto -487 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	704	0	this	g
    //   0	704	1	paramContext	Context
    //   0	704	2	paramBoolean1	boolean
    //   0	704	3	paramInt1	int
    //   0	704	4	paramBoolean2	boolean
    //   0	704	5	paramInt2	int
    //   0	704	6	paramUri	Uri
    //   0	704	7	paramInt3	int
    //   0	704	8	paramInt4	int
    //   251	15	9	f1	float
    //   263	17	10	f2	float
    //   181	280	11	localBitmap	Bitmap
    //   584	7	11	localObject1	Object
    //   625	7	11	localObject2	Object
    //   674	1	11	localThrowable1	Throwable
    //   679	1	11	localThrowable2	Throwable
    //   104	537	12	localObject3	Object
    //   101	566	13	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   152	183	212	android/content/pm/PackageManager$NameNotFoundException
    //   196	209	212	android/content/pm/PackageManager$NameNotFoundException
    //   241	265	212	android/content/pm/PackageManager$NameNotFoundException
    //   273	284	212	android/content/pm/PackageManager$NameNotFoundException
    //   310	343	212	android/content/pm/PackageManager$NameNotFoundException
    //   354	359	212	android/content/pm/PackageManager$NameNotFoundException
    //   366	385	212	android/content/pm/PackageManager$NameNotFoundException
    //   411	444	212	android/content/pm/PackageManager$NameNotFoundException
    //   455	460	212	android/content/pm/PackageManager$NameNotFoundException
    //   467	483	212	android/content/pm/PackageManager$NameNotFoundException
    //   486	497	547	java/io/IOException
    //   539	544	547	java/io/IOException
    //   604	609	547	java/io/IOException
    //   609	612	547	java/io/IOException
    //   612	617	547	java/io/IOException
    //   500	507	579	java/lang/Throwable
    //   512	529	579	java/lang/Throwable
    //   529	534	579	java/lang/Throwable
    //   560	576	579	java/lang/Throwable
    //   581	584	584	finally
    //   106	127	620	java/lang/Throwable
    //   622	625	625	finally
    //   94	103	653	java/io/IOException
    //   132	137	653	java/io/IOException
    //   645	650	653	java/io/IOException
    //   650	653	653	java/io/IOException
    //   666	671	653	java/io/IOException
    //   604	609	674	java/lang/Throwable
    //   645	650	679	java/lang/Throwable
    //   106	127	684	finally
    //   500	507	689	finally
    //   512	529	689	finally
    //   529	534	689	finally
    //   560	576	689	finally
    //   152	183	694	java/lang/RuntimeException
    //   196	209	694	java/lang/RuntimeException
    //   241	265	694	java/lang/RuntimeException
    //   273	284	694	java/lang/RuntimeException
    //   310	343	694	java/lang/RuntimeException
    //   354	359	694	java/lang/RuntimeException
    //   366	385	694	java/lang/RuntimeException
    //   411	444	694	java/lang/RuntimeException
    //   455	460	694	java/lang/RuntimeException
    //   467	483	694	java/lang/RuntimeException
    //   152	183	699	java/lang/OutOfMemoryError
    //   196	209	699	java/lang/OutOfMemoryError
    //   241	265	699	java/lang/OutOfMemoryError
    //   273	284	699	java/lang/OutOfMemoryError
    //   310	343	699	java/lang/OutOfMemoryError
    //   354	359	699	java/lang/OutOfMemoryError
    //   366	385	699	java/lang/OutOfMemoryError
    //   411	444	699	java/lang/OutOfMemoryError
    //   455	460	699	java/lang/OutOfMemoryError
    //   467	483	699	java/lang/OutOfMemoryError
  }
  
  public final Uri b()
  {
    String str = r.a(new StringBuilder().append(this.k.b()).append(System.currentTimeMillis()).toString()) + ".jpg";
    return Uri.fromFile(new File(this.l.e(), str));
  }
  
  /* Error */
  public final void b(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 544
    //   6: invokestatic 193	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   14: aload_1
    //   15: ldc -86
    //   17: iconst_0
    //   18: invokevirtual 468	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   21: astore 5
    //   23: aload 5
    //   25: iconst_3
    //   26: invokevirtual 548	java/io/FileOutputStream:write	(I)V
    //   29: aload 5
    //   31: invokevirtual 551	java/io/FileOutputStream:flush	()V
    //   34: aload 5
    //   36: ifnull +8 -> 44
    //   39: aload 5
    //   41: invokevirtual 487	java/io/FileOutputStream:close	()V
    //   44: aload_0
    //   45: aload_1
    //   46: invokevirtual 490	com/whatsapp/wallpaper/g:e	(Landroid/content/Context;)V
    //   49: return
    //   50: astore_2
    //   51: aload_2
    //   52: athrow
    //   53: astore_3
    //   54: aload_2
    //   55: astore 4
    //   57: aload_3
    //   58: astore_2
    //   59: aload 5
    //   61: ifnull +13 -> 74
    //   64: aload 4
    //   66: ifnull +21 -> 87
    //   69: aload 5
    //   71: invokevirtual 487	java/io/FileOutputStream:close	()V
    //   74: aload_2
    //   75: athrow
    //   76: astore_2
    //   77: aload_2
    //   78: invokevirtual 436	java/io/IOException:toString	()Ljava/lang/String;
    //   81: invokestatic 415	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   84: goto -40 -> 44
    //   87: aload 5
    //   89: invokevirtual 487	java/io/FileOutputStream:close	()V
    //   92: goto -18 -> 74
    //   95: astore_3
    //   96: goto -22 -> 74
    //   99: astore_2
    //   100: goto -41 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	g
    //   0	103	1	paramContext	Context
    //   50	5	2	localThrowable1	Throwable
    //   58	17	2	localObject1	Object
    //   76	2	2	localIOException	IOException
    //   99	1	2	localObject2	Object
    //   53	5	3	localObject3	Object
    //   95	1	3	localThrowable2	Throwable
    //   1	64	4	localObject4	Object
    //   21	67	5	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   23	34	50	java/lang/Throwable
    //   51	53	53	finally
    //   14	23	76	java/io/IOException
    //   39	44	76	java/io/IOException
    //   69	74	76	java/io/IOException
    //   74	76	76	java/io/IOException
    //   87	92	76	java/io/IOException
    //   69	74	95	java/lang/Throwable
    //   23	34	99	finally
  }
  
  /* Error */
  public final void c(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc_w 553
    //   6: invokestatic 193	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   14: aload_1
    //   15: ldc -86
    //   17: iconst_0
    //   18: invokevirtual 468	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   21: astore 5
    //   23: aload 5
    //   25: iconst_2
    //   26: invokevirtual 548	java/io/FileOutputStream:write	(I)V
    //   29: aload 5
    //   31: invokevirtual 551	java/io/FileOutputStream:flush	()V
    //   34: aload 5
    //   36: ifnull +8 -> 44
    //   39: aload 5
    //   41: invokevirtual 487	java/io/FileOutputStream:close	()V
    //   44: aload_0
    //   45: aload_0
    //   46: aload_1
    //   47: invokevirtual 556	com/whatsapp/wallpaper/g:d	(Landroid/content/Context;)Landroid/graphics/drawable/Drawable;
    //   50: putfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 490	com/whatsapp/wallpaper/g:e	(Landroid/content/Context;)V
    //   58: return
    //   59: astore_2
    //   60: aload_2
    //   61: athrow
    //   62: astore_3
    //   63: aload_2
    //   64: astore 4
    //   66: aload_3
    //   67: astore_2
    //   68: aload 5
    //   70: ifnull +13 -> 83
    //   73: aload 4
    //   75: ifnull +21 -> 96
    //   78: aload 5
    //   80: invokevirtual 487	java/io/FileOutputStream:close	()V
    //   83: aload_2
    //   84: athrow
    //   85: astore_2
    //   86: aload_2
    //   87: invokevirtual 436	java/io/IOException:toString	()Ljava/lang/String;
    //   90: invokestatic 415	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   93: goto -49 -> 44
    //   96: aload 5
    //   98: invokevirtual 487	java/io/FileOutputStream:close	()V
    //   101: goto -18 -> 83
    //   104: astore_3
    //   105: goto -22 -> 83
    //   108: astore_2
    //   109: goto -41 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	g
    //   0	112	1	paramContext	Context
    //   59	5	2	localThrowable1	Throwable
    //   67	17	2	localObject1	Object
    //   85	2	2	localIOException	IOException
    //   108	1	2	localObject2	Object
    //   62	5	3	localObject3	Object
    //   104	1	3	localThrowable2	Throwable
    //   1	73	4	localObject4	Object
    //   21	76	5	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   23	34	59	java/lang/Throwable
    //   60	62	62	finally
    //   14	23	85	java/io/IOException
    //   39	44	85	java/io/IOException
    //   78	83	85	java/io/IOException
    //   83	85	85	java/io/IOException
    //   96	101	85	java/io/IOException
    //   78	83	104	java/lang/Throwable
    //   23	34	108	finally
  }
  
  /* Error */
  public final Drawable d(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   4: ifnonnull +607 -> 611
    //   7: aload_1
    //   8: invokevirtual 279	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   11: astore 8
    //   13: ldc_w 558
    //   16: invokestatic 563	com/whatsapp/k/c:a	(Ljava/lang/String;)Lcom/whatsapp/k/d;
    //   19: astore 9
    //   21: aload 9
    //   23: invokeinterface 567 1 0
    //   28: ldc_w 569
    //   31: invokestatic 571	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   34: aload_1
    //   35: invokestatic 573	com/whatsapp/wallpaper/g:a	(Landroid/content/Context;)Ljava/io/File;
    //   38: astore 7
    //   40: aload 7
    //   42: invokevirtual 577	java/io/File:exists	()Z
    //   45: ifeq +97 -> 142
    //   48: aload_1
    //   49: invokestatic 579	com/whatsapp/wallpaper/g:f	(Landroid/content/Context;)Landroid/graphics/Point;
    //   52: astore 10
    //   54: new 133	android/graphics/BitmapFactory$Options
    //   57: dup
    //   58: invokespecial 134	android/graphics/BitmapFactory$Options:<init>	()V
    //   61: astore 6
    //   63: aload 6
    //   65: iconst_0
    //   66: putfield 582	android/graphics/BitmapFactory$Options:inScaled	Z
    //   69: aload 6
    //   71: iconst_1
    //   72: putfield 248	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   75: aload 7
    //   77: invokevirtual 585	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   80: aload 6
    //   82: invokestatic 589	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   85: pop
    //   86: aload 6
    //   88: aload 10
    //   90: getfield 296	android/graphics/Point:x	I
    //   93: invokestatic 591	com/whatsapp/wallpaper/g:a	(Landroid/graphics/BitmapFactory$Options;I)V
    //   96: aload 7
    //   98: invokestatic 594	a/a/a/a/d:b	(Ljava/io/File;)[B
    //   101: astore 7
    //   103: aload 7
    //   105: iconst_0
    //   106: aload 7
    //   108: arraylength
    //   109: aload 6
    //   111: invokestatic 158	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   114: astore 6
    //   116: aload 6
    //   118: ifnull +180 -> 298
    //   121: ldc_w 596
    //   124: invokestatic 571	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   127: aload_0
    //   128: new 432	android/graphics/drawable/BitmapDrawable
    //   131: dup
    //   132: aload 8
    //   134: aload 6
    //   136: invokespecial 435	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   139: putfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   142: aload_0
    //   143: getfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   146: ifnonnull +387 -> 533
    //   149: aload_1
    //   150: ldc -86
    //   152: invokevirtual 600	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   155: astore 10
    //   157: aconst_null
    //   158: astore 6
    //   160: aload 10
    //   162: invokevirtual 605	java/io/FileInputStream:read	()I
    //   165: istore_2
    //   166: iload_2
    //   167: istore_3
    //   168: aload 10
    //   170: ifnull +10 -> 180
    //   173: aload 10
    //   175: invokevirtual 606	java/io/FileInputStream:close	()V
    //   178: iload_2
    //   179: istore_3
    //   180: new 34	java/lang/StringBuilder
    //   183: dup
    //   184: ldc_w 608
    //   187: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   190: iload_3
    //   191: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   194: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 571	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   200: iload_3
    //   201: iconst_2
    //   202: if_icmpeq +8 -> 210
    //   205: iload_3
    //   206: iconst_1
    //   207: if_icmpne +326 -> 533
    //   210: aload_1
    //   211: invokestatic 579	com/whatsapp/wallpaper/g:f	(Landroid/content/Context;)Landroid/graphics/Point;
    //   214: astore_1
    //   215: new 133	android/graphics/BitmapFactory$Options
    //   218: dup
    //   219: invokespecial 134	android/graphics/BitmapFactory$Options:<init>	()V
    //   222: astore 6
    //   224: aload 6
    //   226: iconst_0
    //   227: putfield 582	android/graphics/BitmapFactory$Options:inScaled	Z
    //   230: aload 6
    //   232: iconst_1
    //   233: putfield 248	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   236: aload 8
    //   238: ldc_w 609
    //   241: aload 6
    //   243: invokestatic 613	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;ILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   246: pop
    //   247: aload 6
    //   249: iconst_1
    //   250: putfield 227	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   253: aload 6
    //   255: getfield 230	android/graphics/BitmapFactory$Options:outWidth	I
    //   258: istore_3
    //   259: aload 6
    //   261: getfield 233	android/graphics/BitmapFactory$Options:outHeight	I
    //   264: istore_2
    //   265: iload_3
    //   266: aload_1
    //   267: getfield 296	android/graphics/Point:x	I
    //   270: iconst_1
    //   271: ishl
    //   272: if_icmple +118 -> 390
    //   275: iload_3
    //   276: iconst_2
    //   277: idiv
    //   278: istore_3
    //   279: iload_2
    //   280: iconst_2
    //   281: idiv
    //   282: istore_2
    //   283: aload 6
    //   285: aload 6
    //   287: getfield 227	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   290: iconst_1
    //   291: ishl
    //   292: putfield 227	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   295: goto -30 -> 265
    //   298: ldc_w 615
    //   301: invokestatic 571	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   304: aload_0
    //   305: aconst_null
    //   306: putfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   309: goto -167 -> 142
    //   312: astore 6
    //   314: aload 6
    //   316: invokestatic 618	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   319: goto -177 -> 142
    //   322: astore 7
    //   324: aload 7
    //   326: astore 6
    //   328: aload 7
    //   330: athrow
    //   331: astore 7
    //   333: aload 10
    //   335: ifnull +13 -> 348
    //   338: aload 6
    //   340: ifnull +28 -> 368
    //   343: aload 10
    //   345: invokevirtual 606	java/io/FileInputStream:close	()V
    //   348: aload 7
    //   350: athrow
    //   351: astore 6
    //   353: iconst_2
    //   354: istore_2
    //   355: aload 6
    //   357: invokevirtual 436	java/io/IOException:toString	()Ljava/lang/String;
    //   360: invokestatic 571	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   363: iload_2
    //   364: istore_3
    //   365: goto -185 -> 180
    //   368: aload 10
    //   370: invokevirtual 606	java/io/FileInputStream:close	()V
    //   373: goto -25 -> 348
    //   376: astore 6
    //   378: iconst_2
    //   379: istore_2
    //   380: aload 6
    //   382: invokestatic 620	com/whatsapp/util/Log:i	(Ljava/lang/Throwable;)V
    //   385: iload_2
    //   386: istore_3
    //   387: goto -207 -> 180
    //   390: invokestatic 239	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   393: invokevirtual 243	java/lang/Runtime:maxMemory	()J
    //   396: lstore 4
    //   398: iload_3
    //   399: iload_2
    //   400: imul
    //   401: iconst_1
    //   402: ishl
    //   403: i2l
    //   404: lload 4
    //   406: ldc2_w 244
    //   409: ldiv
    //   410: lcmp
    //   411: ifle +26 -> 437
    //   414: iload_3
    //   415: iconst_2
    //   416: idiv
    //   417: istore_3
    //   418: iload_2
    //   419: iconst_2
    //   420: idiv
    //   421: istore_2
    //   422: aload 6
    //   424: aload 6
    //   426: getfield 227	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   429: iconst_1
    //   430: ishl
    //   431: putfield 227	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   434: goto -36 -> 398
    //   437: aload 6
    //   439: iconst_0
    //   440: putfield 248	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   443: aload 6
    //   445: getstatic 140	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   448: putfield 143	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   451: aload 6
    //   453: iconst_1
    //   454: putfield 146	android/graphics/BitmapFactory$Options:inDither	Z
    //   457: aload 6
    //   459: iconst_1
    //   460: putfield 149	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   463: aload 6
    //   465: iconst_1
    //   466: putfield 152	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   469: aload 8
    //   471: ldc_w 609
    //   474: invokevirtual 624	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   477: astore 7
    //   479: aconst_null
    //   480: astore_1
    //   481: aload 7
    //   483: invokestatic 131	a/a/a/a/d:a	(Ljava/io/InputStream;)[B
    //   486: astore 10
    //   488: aload 7
    //   490: ifnull +8 -> 498
    //   493: aload 7
    //   495: invokevirtual 519	java/io/InputStream:close	()V
    //   498: aload 10
    //   500: iconst_0
    //   501: aload 10
    //   503: arraylength
    //   504: aload 6
    //   506: invokestatic 158	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   509: astore_1
    //   510: aload_1
    //   511: ifnull +156 -> 667
    //   514: aload_1
    //   515: iconst_0
    //   516: invokevirtual 627	android/graphics/Bitmap:setDensity	(I)V
    //   519: aload_0
    //   520: new 432	android/graphics/drawable/BitmapDrawable
    //   523: dup
    //   524: aload 8
    //   526: aload_1
    //   527: invokespecial 435	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   530: putfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   533: aload_0
    //   534: getfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   537: ifnull +139 -> 676
    //   540: new 34	java/lang/StringBuilder
    //   543: dup
    //   544: ldc_w 629
    //   547: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   550: aload_0
    //   551: getfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   554: invokevirtual 634	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   557: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   560: ldc_w 462
    //   563: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: aload_0
    //   567: getfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   570: invokevirtual 637	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   573: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   576: ldc_w 461
    //   579: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: aload_0
    //   583: getfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   586: checkcast 432	android/graphics/drawable/BitmapDrawable
    //   589: invokevirtual 472	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   592: invokestatic 642	a/a/a/a/a/a$d:a	(Landroid/graphics/Bitmap;)I
    //   595: invokevirtual 184	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   598: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 193	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   604: aload 9
    //   606: invokeinterface 644 1 0
    //   611: aload_0
    //   612: getfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   615: areturn
    //   616: astore 6
    //   618: aload 6
    //   620: astore_1
    //   621: aload 6
    //   623: athrow
    //   624: astore 6
    //   626: aload 7
    //   628: ifnull +12 -> 640
    //   631: aload_1
    //   632: ifnull +27 -> 659
    //   635: aload 7
    //   637: invokevirtual 519	java/io/InputStream:close	()V
    //   640: aload 6
    //   642: athrow
    //   643: astore_1
    //   644: ldc_w 646
    //   647: invokestatic 649	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   650: aload_1
    //   651: invokestatic 618	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   654: aload_0
    //   655: getfield 464	com/whatsapp/wallpaper/g:i	Landroid/graphics/drawable/Drawable;
    //   658: areturn
    //   659: aload 7
    //   661: invokevirtual 519	java/io/InputStream:close	()V
    //   664: goto -24 -> 640
    //   667: ldc_w 646
    //   670: invokestatic 649	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   673: goto -140 -> 533
    //   676: ldc_w 651
    //   679: invokestatic 193	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   682: goto -78 -> 604
    //   685: astore 6
    //   687: goto -339 -> 348
    //   690: astore_1
    //   691: goto -51 -> 640
    //   694: astore 6
    //   696: goto -316 -> 380
    //   699: astore 6
    //   701: goto -346 -> 355
    //   704: astore 6
    //   706: goto -392 -> 314
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	709	0	this	g
    //   0	709	1	paramContext	Context
    //   165	257	2	i1	int
    //   167	251	3	i2	int
    //   396	9	4	l1	long
    //   61	225	6	localObject1	Object
    //   312	3	6	localOutOfMemoryError1	OutOfMemoryError
    //   326	13	6	localThrowable1	Throwable
    //   351	5	6	localIOException1	IOException
    //   376	129	6	localOutOfMemoryError2	OutOfMemoryError
    //   616	6	6	localThrowable2	Throwable
    //   624	17	6	localObject2	Object
    //   685	1	6	localThrowable3	Throwable
    //   694	1	6	localOutOfMemoryError3	OutOfMemoryError
    //   699	1	6	localIOException2	IOException
    //   704	1	6	localIOException3	IOException
    //   38	69	7	localObject3	Object
    //   322	7	7	localThrowable4	Throwable
    //   331	18	7	localObject4	Object
    //   477	183	7	localInputStream	InputStream
    //   11	514	8	localResources	Resources
    //   19	586	9	locald	com.whatsapp.k.d
    //   52	450	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   48	116	312	java/lang/OutOfMemoryError
    //   121	142	312	java/lang/OutOfMemoryError
    //   298	309	312	java/lang/OutOfMemoryError
    //   160	166	322	java/lang/Throwable
    //   160	166	331	finally
    //   328	331	331	finally
    //   149	157	351	java/io/IOException
    //   343	348	351	java/io/IOException
    //   348	351	351	java/io/IOException
    //   368	373	351	java/io/IOException
    //   149	157	376	java/lang/OutOfMemoryError
    //   343	348	376	java/lang/OutOfMemoryError
    //   348	351	376	java/lang/OutOfMemoryError
    //   368	373	376	java/lang/OutOfMemoryError
    //   481	488	616	java/lang/Throwable
    //   481	488	624	finally
    //   621	624	624	finally
    //   469	479	643	java/io/IOException
    //   493	498	643	java/io/IOException
    //   635	640	643	java/io/IOException
    //   640	643	643	java/io/IOException
    //   659	664	643	java/io/IOException
    //   343	348	685	java/lang/Throwable
    //   635	640	690	java/lang/Throwable
    //   173	178	694	java/lang/OutOfMemoryError
    //   173	178	699	java/io/IOException
    //   48	116	704	java/io/IOException
    //   121	142	704	java/io/IOException
    //   298	309	704	java/io/IOException
  }
  
  /* Error */
  public final void e(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 162	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: getfield 119	com/whatsapp/wallpaper/g:c	Lcom/whatsapp/ox;
    //   11: ldc_w 655
    //   14: invokevirtual 658	com/whatsapp/ox:a	(Ljava/lang/String;)Ljava/io/File;
    //   17: ldc_w 660
    //   20: invokespecial 173	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   23: astore_2
    //   24: aload_1
    //   25: invokestatic 573	com/whatsapp/wallpaper/g:a	(Landroid/content/Context;)Ljava/io/File;
    //   28: astore_1
    //   29: aload_1
    //   30: invokevirtual 577	java/io/File:exists	()Z
    //   33: ifne +4 -> 37
    //   36: return
    //   37: aload_2
    //   38: invokevirtual 663	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   41: astore_3
    //   42: aload_3
    //   43: invokevirtual 577	java/io/File:exists	()Z
    //   46: ifne +8 -> 54
    //   49: aload_3
    //   50: invokevirtual 666	java/io/File:mkdirs	()Z
    //   53: pop
    //   54: aload_0
    //   55: getfield 125	com/whatsapp/wallpaper/g:o	Lcom/whatsapp/atu;
    //   58: invokestatic 671	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   61: invokevirtual 673	com/whatsapp/atu:b	(Ljava/lang/String;)Z
    //   64: ifeq +189 -> 253
    //   67: new 602	java/io/FileInputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 676	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   75: invokevirtual 680	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   78: astore 5
    //   80: new 682	com/whatsapp/util/e
    //   83: dup
    //   84: aload_0
    //   85: getfield 123	com/whatsapp/wallpaper/g:n	Lcom/whatsapp/vv;
    //   88: getfield 685	com/whatsapp/vv:c	Lcom/whatsapp/util/bk;
    //   91: aload_2
    //   92: invokespecial 688	com/whatsapp/util/e:<init>	(Lcom/whatsapp/util/bk;Ljava/io/File;)V
    //   95: invokestatic 694	java/nio/channels/Channels:newChannel	(Ljava/io/OutputStream;)Ljava/nio/channels/WritableByteChannel;
    //   98: astore 6
    //   100: new 34	java/lang/StringBuilder
    //   103: dup
    //   104: ldc_w 696
    //   107: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   110: aload_1
    //   111: invokevirtual 699	java/io/File:length	()J
    //   114: invokevirtual 529	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   117: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 193	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   123: aload 5
    //   125: aload 6
    //   127: invokestatic 702	a/a/a/a/d:a	(Ljava/nio/channels/FileChannel;Ljava/nio/channels/WritableByteChannel;)V
    //   130: aload 6
    //   132: ifnull +10 -> 142
    //   135: aload 6
    //   137: invokeinterface 705 1 0
    //   142: aload 5
    //   144: ifnull -108 -> 36
    //   147: aload 5
    //   149: invokevirtual 708	java/nio/channels/FileChannel:close	()V
    //   152: return
    //   153: astore_1
    //   154: new 34	java/lang/StringBuilder
    //   157: dup
    //   158: ldc_w 710
    //   161: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   164: aload_1
    //   165: invokevirtual 711	java/lang/Exception:toString	()Ljava/lang/String;
    //   168: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 649	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   177: return
    //   178: astore_1
    //   179: aload_1
    //   180: athrow
    //   181: astore_2
    //   182: aload_1
    //   183: astore_3
    //   184: aload_2
    //   185: astore_1
    //   186: aload 6
    //   188: ifnull +14 -> 202
    //   191: aload_3
    //   192: ifnull +36 -> 228
    //   195: aload 6
    //   197: invokeinterface 705 1 0
    //   202: aload_1
    //   203: athrow
    //   204: astore_1
    //   205: aload_1
    //   206: athrow
    //   207: astore_2
    //   208: aload_1
    //   209: astore_3
    //   210: aload_2
    //   211: astore_1
    //   212: aload 5
    //   214: ifnull +12 -> 226
    //   217: aload_3
    //   218: ifnull +27 -> 245
    //   221: aload 5
    //   223: invokevirtual 708	java/nio/channels/FileChannel:close	()V
    //   226: aload_1
    //   227: athrow
    //   228: aload 6
    //   230: invokeinterface 705 1 0
    //   235: goto -33 -> 202
    //   238: astore_1
    //   239: aload 4
    //   241: astore_3
    //   242: goto -30 -> 212
    //   245: aload 5
    //   247: invokevirtual 708	java/nio/channels/FileChannel:close	()V
    //   250: goto -24 -> 226
    //   253: new 34	java/lang/StringBuilder
    //   256: dup
    //   257: ldc_w 713
    //   260: invokespecial 179	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   263: invokestatic 671	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   266: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 193	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   275: return
    //   276: astore_2
    //   277: goto -75 -> 202
    //   280: astore_2
    //   281: goto -55 -> 226
    //   284: astore_1
    //   285: aconst_null
    //   286: astore_3
    //   287: goto -101 -> 186
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	g
    //   0	290	1	paramContext	Context
    //   23	69	2	localFile	File
    //   181	4	2	localObject1	Object
    //   207	4	2	localObject2	Object
    //   276	1	2	localThrowable1	Throwable
    //   280	1	2	localThrowable2	Throwable
    //   41	246	3	localObject3	Object
    //   1	239	4	localObject4	Object
    //   78	168	5	localFileChannel	java.nio.channels.FileChannel
    //   98	131	6	localWritableByteChannel	java.nio.channels.WritableByteChannel
    // Exception table:
    //   from	to	target	type
    //   67	80	153	java/lang/Exception
    //   147	152	153	java/lang/Exception
    //   221	226	153	java/lang/Exception
    //   226	228	153	java/lang/Exception
    //   245	250	153	java/lang/Exception
    //   100	130	178	java/lang/Throwable
    //   179	181	181	finally
    //   80	100	204	java/lang/Throwable
    //   135	142	204	java/lang/Throwable
    //   202	204	204	java/lang/Throwable
    //   228	235	204	java/lang/Throwable
    //   205	207	207	finally
    //   80	100	238	finally
    //   135	142	238	finally
    //   195	202	238	finally
    //   202	204	238	finally
    //   228	235	238	finally
    //   195	202	276	java/lang/Throwable
    //   221	226	280	java/lang/Throwable
    //   100	130	284	finally
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/wallpaper/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */