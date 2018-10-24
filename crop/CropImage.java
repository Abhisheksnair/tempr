package com.whatsapp.crop;

import a.a.a.a.a.a.d;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.Display;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.whatsapp.al;
import com.whatsapp.and;
import com.whatsapp.ane;
import com.whatsapp.anf;
import com.whatsapp.aus;
import com.whatsapp.j;
import com.whatsapp.ng;
import com.whatsapp.pv;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.bu;
import com.whatsapp.vv;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONException;

public class CropImage
  extends Activity
{
  private final pv A = pv.a();
  private final aus B = aus.a();
  private final vv C = vv.a();
  private final ane D = ane.a();
  boolean a;
  int b;
  int c;
  int d;
  boolean e;
  boolean f = true;
  boolean g;
  boolean h;
  public boolean i;
  CropImageView j;
  Bitmap k;
  int l = 1;
  Matrix m;
  Matrix n;
  int o;
  d p;
  final and q = and.a();
  private Bitmap.CompressFormat r = Bitmap.CompressFormat.JPEG;
  private Uri s;
  private int t;
  private int u;
  private int v;
  private int w;
  private Rect x;
  private String y;
  private int z;
  
  private SpannableString a(String paramString1, String paramString2, String paramString3)
  {
    int i1 = 0;
    paramString1 = new SpannableString(Html.fromHtml(paramString1));
    URLSpan[] arrayOfURLSpan = (URLSpan[])paramString1.getSpans(0, paramString1.length(), URLSpan.class);
    if (arrayOfURLSpan != null)
    {
      int i2 = arrayOfURLSpan.length;
      while (i1 < i2)
      {
        URLSpan localURLSpan = arrayOfURLSpan[i1];
        if (paramString2.equals(localURLSpan.getURL()))
        {
          i1 = paramString1.getSpanStart(localURLSpan);
          i2 = paramString1.getSpanEnd(localURLSpan);
          int i3 = paramString1.getSpanFlags(localURLSpan);
          paramString1.removeSpan(localURLSpan);
          paramString1.setSpan(new j(new Intent("android.intent.action.VIEW", Uri.parse(paramString3)))
          {
            public final void updateDrawState(TextPaint paramAnonymousTextPaint)
            {
              paramAnonymousTextPaint.setColor(android.support.v4.content.b.c(CropImage.this, 2131624044));
            }
          }, i1, i2, i3);
          return paramString1;
        }
        i1 += 1;
      }
    }
    return null;
  }
  
  public static void a(pv parampv, Intent paramIntent, ng paramng)
  {
    if (paramIntent.getBooleanExtra("error-oom", false))
    {
      Log.e("profileinfo/activityres/oom-error");
      parampv.a(paramng, u.a().getString(2131296746));
    }
    do
    {
      return;
      if (paramIntent.getBooleanExtra("no-space", false))
      {
        Log.e("profileinfo/activityres/no-space");
        parampv.a(paramng, u.a().getString(2131296742));
        return;
      }
      if (paramIntent.getBooleanExtra("io-error", false))
      {
        Log.e("profileinfo/activityres/fail/load-image");
        parampv.a(paramng, u.a().getString(2131296737));
        return;
      }
    } while (!paramIntent.getBooleanExtra("not-a-image", false));
    Log.e("profileinfo/activityres/fail/not-a-image");
    parampv.a(paramng, u.a().getString(2131296734));
  }
  
  final f a()
  {
    f localf = new f(this.k);
    Matrix localMatrix = new Matrix();
    localMatrix.set(this.m);
    localMatrix.postConcat(this.n);
    localf.b = localMatrix;
    return localf;
  }
  
  /* Error */
  final void a(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 250	com/whatsapp/crop/CropImage:p	Lcom/whatsapp/crop/d;
    //   7: invokevirtual 255	com/whatsapp/crop/d:a	()Landroid/graphics/Rect;
    //   10: astore 10
    //   12: aload_0
    //   13: getfield 68	com/whatsapp/crop/CropImage:l	I
    //   16: iconst_1
    //   17: if_icmple +63 -> 80
    //   20: aload 10
    //   22: aload 10
    //   24: getfield 260	android/graphics/Rect:left	I
    //   27: aload_0
    //   28: getfield 68	com/whatsapp/crop/CropImage:l	I
    //   31: imul
    //   32: putfield 260	android/graphics/Rect:left	I
    //   35: aload 10
    //   37: aload 10
    //   39: getfield 263	android/graphics/Rect:right	I
    //   42: aload_0
    //   43: getfield 68	com/whatsapp/crop/CropImage:l	I
    //   46: imul
    //   47: putfield 263	android/graphics/Rect:right	I
    //   50: aload 10
    //   52: aload 10
    //   54: getfield 266	android/graphics/Rect:top	I
    //   57: aload_0
    //   58: getfield 68	com/whatsapp/crop/CropImage:l	I
    //   61: imul
    //   62: putfield 266	android/graphics/Rect:top	I
    //   65: aload 10
    //   67: aload 10
    //   69: getfield 269	android/graphics/Rect:bottom	I
    //   72: aload_0
    //   73: getfield 68	com/whatsapp/crop/CropImage:l	I
    //   76: imul
    //   77: putfield 269	android/graphics/Rect:bottom	I
    //   80: aload_0
    //   81: getfield 271	com/whatsapp/crop/CropImage:s	Landroid/net/Uri;
    //   84: ifnull +501 -> 585
    //   87: new 273	java/io/File
    //   90: dup
    //   91: aload_0
    //   92: getfield 271	com/whatsapp/crop/CropImage:s	Landroid/net/Uri;
    //   95: invokevirtual 276	android/net/Uri:getPath	()Ljava/lang/String;
    //   98: invokespecial 278	java/io/File:<init>	(Ljava/lang/String;)V
    //   101: astore 11
    //   103: bipush 75
    //   105: istore_2
    //   106: aconst_null
    //   107: astore 8
    //   109: aconst_null
    //   110: astore 9
    //   112: aconst_null
    //   113: astore 5
    //   115: aload 8
    //   117: astore 7
    //   119: aload 9
    //   121: astore 6
    //   123: aload_0
    //   124: getfield 82	com/whatsapp/crop/CropImage:q	Lcom/whatsapp/and;
    //   127: getfield 281	com/whatsapp/and:f	Landroid/content/ContentResolver;
    //   130: astore 12
    //   132: aload 12
    //   134: ifnonnull +254 -> 388
    //   137: aload 8
    //   139: astore 7
    //   141: aload 9
    //   143: astore 6
    //   145: ldc_w 283
    //   148: invokestatic 285	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   151: aload 5
    //   153: ifnull +23 -> 176
    //   156: aload 5
    //   158: astore 7
    //   160: aload 5
    //   162: astore 6
    //   164: aload_1
    //   165: aload_0
    //   166: getfield 64	com/whatsapp/crop/CropImage:r	Landroid/graphics/Bitmap$CompressFormat;
    //   169: iload_2
    //   170: aload 5
    //   172: invokevirtual 291	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   175: pop
    //   176: iload_2
    //   177: bipush 10
    //   179: isub
    //   180: istore_2
    //   181: aload 5
    //   183: invokestatic 296	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   186: aload_0
    //   187: getfield 298	com/whatsapp/crop/CropImage:w	I
    //   190: ifeq +29 -> 219
    //   193: iload_2
    //   194: ifle +25 -> 219
    //   197: aload 11
    //   199: invokevirtual 302	java/io/File:exists	()Z
    //   202: ifeq +17 -> 219
    //   205: aload 11
    //   207: invokevirtual 305	java/io/File:length	()J
    //   210: aload_0
    //   211: getfield 298	com/whatsapp/crop/CropImage:w	I
    //   214: i2l
    //   215: lcmp
    //   216: ifgt -110 -> 106
    //   219: iconst_0
    //   220: istore_3
    //   221: iload_3
    //   222: istore_2
    //   223: aload 11
    //   225: invokevirtual 305	java/io/File:length	()J
    //   228: lconst_0
    //   229: lcmp
    //   230: ifne +39 -> 269
    //   233: iload_3
    //   234: istore_2
    //   235: invokestatic 307	com/whatsapp/vv:f	()J
    //   238: lconst_0
    //   239: lcmp
    //   240: ifne +29 -> 269
    //   243: ldc_w 309
    //   246: invokestatic 189	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   249: aload_0
    //   250: iconst_0
    //   251: new 154	android/content/Intent
    //   254: dup
    //   255: invokespecial 310	android/content/Intent:<init>	()V
    //   258: ldc -50
    //   260: iconst_1
    //   261: invokevirtual 314	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   264: invokevirtual 318	com/whatsapp/crop/CropImage:setResult	(ILandroid/content/Intent;)V
    //   267: iconst_1
    //   268: istore_2
    //   269: iload_2
    //   270: ifne +358 -> 628
    //   273: aload_0
    //   274: getfield 320	com/whatsapp/crop/CropImage:h	Z
    //   277: ifne +351 -> 628
    //   280: aload_0
    //   281: getfield 322	com/whatsapp/crop/CropImage:z	I
    //   284: iconst_1
    //   285: if_icmpeq +343 -> 628
    //   288: aload_0
    //   289: getfield 322	com/whatsapp/crop/CropImage:z	I
    //   292: ifeq +336 -> 628
    //   295: new 324	android/media/ExifInterface
    //   298: dup
    //   299: aload 11
    //   301: invokevirtual 327	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   304: invokespecial 328	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   307: astore 5
    //   309: aload 5
    //   311: ldc_w 330
    //   314: aload_0
    //   315: getfield 322	com/whatsapp/crop/CropImage:z	I
    //   318: invokestatic 335	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   321: invokevirtual 339	android/media/ExifInterface:setAttribute	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: aload 5
    //   326: invokevirtual 342	android/media/ExifInterface:saveAttributes	()V
    //   329: iload_2
    //   330: ifne +53 -> 383
    //   333: new 154	android/content/Intent
    //   336: dup
    //   337: invokespecial 310	android/content/Intent:<init>	()V
    //   340: astore 5
    //   342: aload 5
    //   344: aload_0
    //   345: getfield 271	com/whatsapp/crop/CropImage:s	Landroid/net/Uri;
    //   348: invokevirtual 346	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   351: pop
    //   352: aload 5
    //   354: ldc_w 348
    //   357: aload 10
    //   359: invokevirtual 351	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   362: pop
    //   363: aload 5
    //   365: ldc_w 353
    //   368: aload_0
    //   369: getfield 355	com/whatsapp/crop/CropImage:o	I
    //   372: invokevirtual 358	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   375: pop
    //   376: aload_0
    //   377: iconst_m1
    //   378: aload 5
    //   380: invokevirtual 318	com/whatsapp/crop/CropImage:setResult	(ILandroid/content/Intent;)V
    //   383: aload_1
    //   384: invokevirtual 361	android/graphics/Bitmap:recycle	()V
    //   387: return
    //   388: aload 8
    //   390: astore 7
    //   392: aload 9
    //   394: astore 6
    //   396: aload 12
    //   398: aload_0
    //   399: getfield 271	com/whatsapp/crop/CropImage:s	Landroid/net/Uri;
    //   402: invokevirtual 367	android/content/ContentResolver:openOutputStream	(Landroid/net/Uri;)Ljava/io/OutputStream;
    //   405: astore 5
    //   407: goto -256 -> 151
    //   410: astore 5
    //   412: aload 7
    //   414: astore 6
    //   416: new 369	java/lang/StringBuilder
    //   419: dup
    //   420: ldc_w 371
    //   423: invokespecial 372	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   426: aload_0
    //   427: getfield 271	com/whatsapp/crop/CropImage:s	Landroid/net/Uri;
    //   430: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 378	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: aload 5
    //   438: invokestatic 381	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   441: aload 7
    //   443: astore 6
    //   445: aload 5
    //   447: invokevirtual 384	java/io/IOException:getMessage	()Ljava/lang/String;
    //   450: ifnull +53 -> 503
    //   453: aload 7
    //   455: astore 6
    //   457: aload 5
    //   459: invokevirtual 384	java/io/IOException:getMessage	()Ljava/lang/String;
    //   462: ldc_w 386
    //   465: invokevirtual 390	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   468: ifeq +35 -> 503
    //   471: aload 7
    //   473: astore 6
    //   475: aload_0
    //   476: iconst_0
    //   477: new 154	android/content/Intent
    //   480: dup
    //   481: invokespecial 310	android/content/Intent:<init>	()V
    //   484: ldc -50
    //   486: iconst_1
    //   487: invokevirtual 314	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   490: invokevirtual 318	com/whatsapp/crop/CropImage:setResult	(ILandroid/content/Intent;)V
    //   493: aload 7
    //   495: invokestatic 296	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   498: iconst_1
    //   499: istore_3
    //   500: goto -279 -> 221
    //   503: aload 7
    //   505: astore 6
    //   507: aload_0
    //   508: iconst_0
    //   509: new 154	android/content/Intent
    //   512: dup
    //   513: invokespecial 310	android/content/Intent:<init>	()V
    //   516: ldc -45
    //   518: iconst_1
    //   519: invokevirtual 314	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   522: invokevirtual 318	com/whatsapp/crop/CropImage:setResult	(ILandroid/content/Intent;)V
    //   525: goto -32 -> 493
    //   528: astore_1
    //   529: aload 6
    //   531: invokestatic 296	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   534: aload_1
    //   535: athrow
    //   536: astore 5
    //   538: ldc_w 392
    //   541: aload 5
    //   543: invokestatic 381	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   546: iload 4
    //   548: istore_2
    //   549: goto -220 -> 329
    //   552: astore 5
    //   554: new 369	java/lang/StringBuilder
    //   557: dup
    //   558: ldc_w 394
    //   561: invokespecial 372	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   564: aload_0
    //   565: getfield 271	com/whatsapp/crop/CropImage:s	Landroid/net/Uri;
    //   568: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   571: invokevirtual 378	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: aload 5
    //   576: invokestatic 381	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   579: iload 4
    //   581: istore_2
    //   582: goto -253 -> 329
    //   585: new 154	android/content/Intent
    //   588: dup
    //   589: invokespecial 310	android/content/Intent:<init>	()V
    //   592: astore 5
    //   594: aload 5
    //   596: ldc_w 348
    //   599: aload 10
    //   601: invokevirtual 351	android/content/Intent:putExtra	(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;
    //   604: pop
    //   605: aload 5
    //   607: ldc_w 353
    //   610: aload_0
    //   611: getfield 355	com/whatsapp/crop/CropImage:o	I
    //   614: invokevirtual 358	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   617: pop
    //   618: aload_0
    //   619: iconst_m1
    //   620: aload 5
    //   622: invokevirtual 318	com/whatsapp/crop/CropImage:setResult	(ILandroid/content/Intent;)V
    //   625: goto -242 -> 383
    //   628: goto -299 -> 329
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	631	0	this	CropImage
    //   0	631	1	paramBitmap	Bitmap
    //   105	477	2	i1	int
    //   220	280	3	i2	int
    //   1	579	4	i3	int
    //   113	293	5	localObject1	Object
    //   410	48	5	localIOException1	IOException
    //   536	6	5	localNoClassDefFoundError	NoClassDefFoundError
    //   552	23	5	localIOException2	IOException
    //   592	29	5	localIntent	Intent
    //   121	409	6	localObject2	Object
    //   117	387	7	localObject3	Object
    //   107	282	8	localObject4	Object
    //   110	283	9	localObject5	Object
    //   10	590	10	localRect	Rect
    //   101	199	11	localFile	java.io.File
    //   130	267	12	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   123	132	410	java/io/IOException
    //   145	151	410	java/io/IOException
    //   164	176	410	java/io/IOException
    //   396	407	410	java/io/IOException
    //   123	132	528	finally
    //   145	151	528	finally
    //   164	176	528	finally
    //   396	407	528	finally
    //   416	441	528	finally
    //   445	453	528	finally
    //   457	471	528	finally
    //   475	493	528	finally
    //   507	525	528	finally
    //   295	329	536	java/lang/NoClassDefFoundError
    //   295	329	552	java/io/IOException
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.B.e();
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool2 = true;
    Log.i("crop/oncreate");
    this.B.e();
    super.onCreate(paramBundle);
    bu.a(anf.a(this.D));
    getWindow().addFlags(1024);
    requestWindowFeature(1);
    setContentView(al.a(this.A, getLayoutInflater(), 2130903187));
    this.j = ((CropImageView)findViewById(2131755173));
    Object localObject1 = getIntent();
    Object localObject2 = ((Intent)localObject1).getExtras();
    Object localObject3;
    if (localObject2 != null)
    {
      if (((Bundle)localObject2).getString("circleCrop") != null)
      {
        this.a = true;
        this.t = 1;
        this.u = 1;
      }
      this.s = ((Uri)((Bundle)localObject2).getParcelable("output"));
      if (this.s != null)
      {
        localObject3 = ((Bundle)localObject2).getString("outputFormat");
        if (localObject3 != null) {
          this.r = Bitmap.CompressFormat.valueOf((String)localObject3);
        }
      }
      this.t = ((Bundle)localObject2).getInt("aspectX");
      this.u = ((Bundle)localObject2).getInt("aspectY");
      this.c = ((Bundle)localObject2).getInt("outputX");
      this.d = ((Bundle)localObject2).getInt("outputY");
      this.v = ((Bundle)localObject2).getInt("minCrop");
      this.b = ((Bundle)localObject2).getInt("maxCrop");
      this.x = ((Rect)((Bundle)localObject2).getParcelable("initialRect"));
      this.g = ((Bundle)localObject2).getBoolean("cropByOutputSize", true);
      this.e = ((Bundle)localObject2).getBoolean("scale", true);
      this.f = ((Bundle)localObject2).getBoolean("scaleUpIfNeeded", true);
      this.w = ((Bundle)localObject2).getInt("maxFileSize");
      this.h = ((Bundle)localObject2).getBoolean("flattenRotation", true);
      this.y = ((Bundle)localObject2).getString("webImageSource");
    }
    boolean bool1;
    label382:
    label498:
    label658:
    int i1;
    int i2;
    boolean bool3;
    for (;;)
    {
      if (paramBundle != null)
      {
        this.o = paramBundle.getInt("rotate");
        this.x = ((Rect)paramBundle.getParcelable("initialRect"));
      }
      paramBundle = new StringBuilder("crop/oncreate/ bitmap:");
      if (this.k == null)
      {
        bool1 = true;
        localObject2 = paramBundle.append(bool1).append(" aspectX:").append(this.t).append(" aspectY:").append(this.u).append(" outputX:").append(this.c).append(" outputY:").append(this.d).append(" minCrop:").append(this.v).append(" maxCrop:").append(this.b).append(" cropByOutputSize:").append(this.g).append(" initialRect:");
        if (this.x != null) {
          break label658;
        }
        paramBundle = "null";
        Log.i(paramBundle + " scale:" + this.e + " scaleUp:" + this.f + " flattenRotation:" + this.h);
        localObject2 = ((Intent)localObject1).getData();
      }
      try
      {
        this.z = MediaFileUtils.c(this.q, (Uri)localObject2);
        this.m = MediaFileUtils.a(this.z);
        if (this.m == null) {
          this.m = new Matrix();
        }
        localObject3 = MediaFileUtils.a(this.q, (Uri)localObject2);
        if (localObject3 == null)
        {
          Log.e("cropimage/bitmapStream is null");
          setResult(0, new Intent().putExtra("io-error", true));
          finish();
          return;
          Log.i("crop/oncreate/no-extras");
          continue;
          bool1 = false;
          break label382;
          paramBundle = this.x.left + "," + this.x.top + "," + this.x.right + "," + this.x.bottom;
          break label498;
        }
        else
        {
          paramBundle = new BitmapFactory.Options();
          paramBundle.inJustDecodeBounds = true;
          BitmapFactory.decodeStream((InputStream)localObject3, null, paramBundle);
          ((InputStream)localObject3).close();
          if ((paramBundle.outWidth <= 0) || (paramBundle.outHeight <= 0))
          {
            Log.e("cropimage/not-a-image");
            setResult(0, new Intent().putExtra("not-a-image", true));
            finish();
            return;
          }
        }
      }
      catch (IOException paramBundle)
      {
        if ((paramBundle.getMessage() != null) && (paramBundle.getMessage().contains("No space"))) {
          setResult(0, new Intent().putExtra("no-space", true));
        }
        for (;;)
        {
          Log.d("cropimage", paramBundle);
          finish();
          return;
          paramBundle.inSampleSize = 1;
          i1 = Math.max(paramBundle.outWidth, paramBundle.outHeight);
          i2 = Math.max(getWindowManager().getDefaultDisplay().getWidth(), getWindowManager().getDefaultDisplay().getHeight());
          while (i1 > i2)
          {
            i1 /= 2;
            paramBundle.inSampleSize <<= 1;
          }
          paramBundle.inDither = true;
          paramBundle.inJustDecodeBounds = false;
          paramBundle.inScaled = false;
          this.l = paramBundle.inSampleSize;
          Log.i("crop/oncreate/bitmap orientation:" + this.z + " " + paramBundle.outWidth + "x" + paramBundle.outHeight + " sample:" + this.l + " uri:" + localObject2);
          if (this.x != null)
          {
            localObject3 = this.x;
            ((Rect)localObject3).left /= this.l;
            localObject3 = this.x;
            ((Rect)localObject3).top /= this.l;
            localObject3 = this.x;
            ((Rect)localObject3).right /= this.l;
            localObject3 = this.x;
            ((Rect)localObject3).bottom /= this.l;
          }
          localObject2 = MediaFileUtils.a(this.q, (Uri)localObject2);
          try
          {
            this.k = BitmapFactory.decodeStream((InputStream)localObject2, null, paramBundle);
            localObject3 = new StringBuilder("crop/oncreate/bitmap:");
            if (this.k == null) {}
            for (paramBundle = "null";; paramBundle = this.k.getWidth() + "x" + this.k.getHeight())
            {
              Log.i(paramBundle);
              a.d.a((Closeable)localObject2);
              if ((this.k != null) && (this.k.getWidth() != 0) && (this.k.getHeight() != 0)) {
                break;
              }
              Log.e("cropimage/not-a-image");
              setResult(0, new Intent().putExtra("not-a-image", true));
              finish();
              return;
            }
            setResult(0, new Intent().putExtra("io-error", true));
          }
          catch (OutOfMemoryError paramBundle)
          {
            Log.e("cropimage/oom");
            setResult(0, new Intent().putExtra("error-oom", true));
            finish();
            return;
          }
          finally
          {
            a.d.a((Closeable)localObject2);
          }
        }
        i1 = ((Intent)localObject1).getIntExtra("rotation", 0);
        bool1 = ((Intent)localObject1).getBooleanExtra("flipH", false);
        bool3 = ((Intent)localObject1).getBooleanExtra("flipV", false);
        Log.i("crop/oncreate/bitmap add-rotation:" + i1 + " flip-h:" + bool1 + " flip-v:" + bool3);
        this.n = new Matrix();
        if (i1 != 0) {
          this.n.postRotate(i1);
        }
        if (bool1)
        {
          paramBundle = new Matrix();
          paramBundle.setValues(new float[] { -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F });
          this.n.postConcat(paramBundle);
        }
        if (bool3)
        {
          paramBundle = new Matrix();
          paramBundle.setValues(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F });
          this.n.postConcat(paramBundle);
        }
        this.n.postRotate(this.o);
        paramBundle = a();
        localObject2 = ((Intent)localObject1).getStringExtra("doodle");
        if (localObject2 == null) {}
      }
    }
    int i3;
    int i8;
    for (;;)
    {
      try
      {
        localObject1 = new com.whatsapp.doodle.a.b();
        ((com.whatsapp.doodle.a.b)localObject1).a((String)localObject2, this);
        if (!this.k.isMutable())
        {
          this.k = this.k.copy(Bitmap.Config.ARGB_8888, true);
          paramBundle.a = this.k;
        }
        localObject2 = this.k;
        i2 = ((com.whatsapp.doodle.a.b)localObject1).d;
        if (paramBundle.b == null) {
          continue;
        }
        localObject3 = new float[2];
        Object tmp1679_1677 = localObject3;
        tmp1679_1677[0] = 0.0F;
        Object tmp1683_1679 = tmp1679_1677;
        tmp1683_1679[1] = 1.0F;
        tmp1683_1679;
        paramBundle.b.mapVectors((float[])localObject3);
        if (localObject3[0] == 0.0F) {
          continue;
        }
        if (localObject3[0] <= 0.0F) {
          continue;
        }
        i1 = 90;
        ((com.whatsapp.doodle.a.b)localObject1).a((Bitmap)localObject2, (i1 + i2) % 360);
      }
      catch (JSONException localJSONException)
      {
        label1838:
        boolean bool4;
        label1913:
        Log.d("crop/cannot-read-doodle", localJSONException);
        continue;
      }
      this.j.a(paramBundle, true);
      i3 = this.k.getWidth();
      i8 = this.k.getHeight();
      localObject1 = new Rect(0, 0, i3, i8);
      if (this.x == null) {
        break;
      }
      paramBundle = new RectF(this.x);
      localObject2 = new d(this.j);
      localObject3 = this.j.getImageMatrix();
      bool3 = this.a;
      if ((this.t == 0) || (this.u == 0)) {
        break label2800;
      }
      i1 = 1;
      bool4 = this.g;
      i2 = this.v / this.l;
      if (bool3) {
        i1 = 1;
      }
      ((d)localObject2).f = new Matrix((Matrix)localObject3);
      ((d)localObject2).e = paramBundle;
      ((d)localObject2).d = new RectF((Rect)localObject1);
      bool1 = bool2;
      if (i1 == 0)
      {
        if (!bool4) {
          break label2805;
        }
        bool1 = bool2;
      }
      ((d)localObject2).g = bool1;
      ((d)localObject2).i = bool3;
      ((d)localObject2).j = i2;
      ((d)localObject2).h = (((d)localObject2).e.width() / ((d)localObject2).e.height());
      ((d)localObject2).c = ((d)localObject2).b();
      ((d)localObject2).k.setARGB(128, 0, 0, 0);
      ((d)localObject2).l.setARGB(128, 0, 0, 0);
      ((d)localObject2).m.setStyle(Paint.Style.STROKE);
      ((d)localObject2).m.setAntiAlias(false);
      ((d)localObject2).b = d.a.a;
      paramBundle = this.j;
      paramBundle.a.add(localObject2);
      paramBundle.invalidate();
      this.p = ((d)localObject2);
      findViewById(2131755642).setOnClickListener(a.a(this));
      findViewById(2131755679).setOnClickListener(b.a(this));
      paramBundle = findViewById(2131755678);
      paramBundle.setOnClickListener(c.a(this));
      if (this.g) {
        paramBundle.setVisibility(8);
      }
      if (this.y != null)
      {
        paramBundle = a(getString(2131296597), "terms-and-privacy-policy", "https://www.whatsapp.com/legal/");
        if (paramBundle != null)
        {
          localObject1 = (TextView)findViewById(2131755677);
          ((TextView)localObject1).setVisibility(0);
          ((TextView)localObject1).setMovementMethod(new LinkMovementMethod());
          ((TextView)localObject1).setText(paramBundle);
          ((TextView)localObject1).setShadowLayer(1.5F, 0.0F, 1.5F, -10066330);
        }
        paramBundle = a("<a href=\"" + this.y + "\">" + Uri.parse(this.y).getHost() + "</a>", this.y, this.y);
        if (paramBundle != null)
        {
          localObject1 = (TextView)findViewById(2131755676);
          ((TextView)localObject1).setVisibility(0);
          ((TextView)localObject1).setMovementMethod(new LinkMovementMethod());
          ((TextView)localObject1).setText(paramBundle);
          ((TextView)localObject1).setShadowLayer(1.5F, 0.0F, 1.5F, -10066330);
        }
      }
      findViewById(2131755675).setTouchDelegate(new TouchDelegate(new Rect(), this.j)
      {
        public final boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent)
        {
          float f2 = 0.0F;
          float f3 = paramAnonymousMotionEvent.getX();
          float f1;
          if (f3 < CropImage.a(CropImage.this).getLeft())
          {
            f1 = 0.0F;
            f3 = paramAnonymousMotionEvent.getY();
            if (f3 >= CropImage.a(CropImage.this).getTop()) {
              break label105;
            }
          }
          for (;;)
          {
            paramAnonymousMotionEvent.setLocation(f1, f2);
            CropImage.a(CropImage.this).dispatchTouchEvent(paramAnonymousMotionEvent);
            return true;
            f1 = f3;
            if (f3 <= CropImage.a(CropImage.this).getRight()) {
              break;
            }
            f1 = CropImage.a(CropImage.this).getWidth();
            break;
            label105:
            if (f3 > CropImage.a(CropImage.this).getBottom()) {
              f2 = CropImage.a(CropImage.this).getHeight();
            } else {
              f2 = f3;
            }
          }
        }
      });
      Log.i("crop/oncreate/end");
      bu.a(anf.a(this.D));
      return;
      i1 = 270;
      continue;
      if (localObject3[1] <= 0.0F) {
        i1 = 180;
      } else {
        i1 = 0;
      }
    }
    if (this.g) {
      if ((this.c < i3) && (this.d < i3))
      {
        i1 = (int)(i3 * this.d / this.c);
        i2 = i3;
      }
    }
    for (;;)
    {
      label2430:
      int i4 = i1;
      int i5 = i2;
      if (this.t != 0)
      {
        i4 = i1;
        i5 = i2;
        if (this.u != 0)
        {
          if (this.t <= this.u) {
            break label2781;
          }
          i4 = this.u * i2 / this.t;
          i5 = i2;
        }
      }
      for (;;)
      {
        int i7 = i4;
        int i6 = i5;
        float f1;
        if (i4 > i8)
        {
          f1 = i4 / i8;
          i6 = (int)(i5 / f1);
          i7 = i8;
        }
        i1 = i7;
        i2 = i6;
        if (i6 > i3)
        {
          f1 = i6 / i3;
          i1 = (int)(i7 / f1);
          i2 = i3;
        }
        i5 = i1;
        i6 = i2;
        if (this.v > 0)
        {
          i7 = i1;
          i4 = i2;
          if (i2 < this.v / this.l)
          {
            i2 = this.v / this.l;
            i7 = i1;
            i4 = i2;
            if (this.t != 0)
            {
              i7 = i1;
              i4 = i2;
              if (this.u != 0)
              {
                i7 = this.u * i2 / this.t;
                i4 = i2;
              }
            }
          }
          i5 = i7;
          i6 = i4;
          if (i7 < this.v / this.l)
          {
            i1 = this.v / this.l;
            i5 = i1;
            i6 = i4;
            if (this.t != 0)
            {
              i5 = i1;
              i6 = i4;
              if (this.u != 0)
              {
                i6 = this.t * i1 / this.u;
                i5 = i1;
              }
            }
          }
        }
        i1 = (i3 - i6) / 2;
        i2 = (i8 - i5) / 2;
        paramBundle = new RectF(i1, i2, i6 + i1, i5 + i2);
        break;
        i2 = this.c;
        i1 = this.d;
        break label2430;
        label2781:
        i5 = this.t * i1 / this.u;
        i4 = i1;
      }
      label2800:
      i1 = 0;
      break label1838;
      label2805:
      bool1 = false;
      break label1913;
      i1 = i8;
      i2 = i3;
    }
  }
  
  protected void onDestroy()
  {
    Log.i("crop/ondestroy");
    super.onDestroy();
    if ((this.k != null) && (!this.k.isRecycled()))
    {
      this.j.b = true;
      this.k.recycle();
      this.k = null;
    }
    bu.a(anf.a(this.D));
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("rotate", this.o);
    Rect localRect = this.p.a();
    localRect.left *= this.l;
    localRect.right *= this.l;
    localRect.top *= this.l;
    localRect.bottom *= this.l;
    paramBundle.putParcelable("initialRect", localRect);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/crop/CropImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */