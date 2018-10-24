package com.whatsapp;

import a.a.a.a.d;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Parcelable;
import com.whatsapp.crop.CropImage;
import com.whatsapp.data.cs;
import com.whatsapp.j.a.a;
import com.whatsapp.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class acw
{
  private static final String a = au.b() + ".intent.action.SEARCH_PHOTO";
  private static final String b = au.b() + ".intent.action.RESET_GROUP_PHOTO";
  private static final String c = au.b() + ".intent.action.RESET_PROFILE_PHOTO";
  private static final String d = au.b() + ".intent.action.PICK_PHOTO";
  private static final String e = au.b() + ".intent.action.CAPTURE_PHOTO";
  private static volatile acw f;
  private final pv g;
  private final oz h;
  private final and i;
  private final aat j;
  private final acm k;
  private final rh l;
  
  private acw(pv parampv, oz paramoz, and paramand, aat paramaat, acm paramacm, rh paramrh)
  {
    this.g = parampv;
    this.h = paramoz;
    this.i = paramand;
    this.j = paramaat;
    this.k = paramacm;
    this.l = paramrh;
  }
  
  public static acw a()
  {
    if (f == null) {}
    try
    {
      if (f == null) {
        f = new acw(pv.a(), oz.a(), and.a(), aat.a(), acm.a(), rh.a());
      }
      return f;
    }
    finally {}
  }
  
  private File d()
  {
    return this.h.a("tmpt");
  }
  
  public final void a(Activity paramActivity, cs paramcs, int paramInt)
  {
    b().delete();
    Intent localIntent2 = new Intent(a).putExtra("output", Uri.fromFile(b())).putExtra("query", paramcs.e);
    Intent localIntent1;
    String str;
    ArrayList localArrayList;
    if (paramcs.d())
    {
      localIntent1 = new Intent(b, null);
      str = paramActivity.getString(2131297011);
      localArrayList = new ArrayList();
      localArrayList.add(new Intent(d, null));
      localArrayList.add(new Intent(e, null));
      if (!paramcs.c().exists()) {
        break label207;
      }
      if (!paramcs.d()) {
        break label294;
      }
      localArrayList.add(localIntent2);
    }
    label137:
    label207:
    label294:
    for (;;)
    {
      Log.i("profile/photo/updater/run chooser");
      d.a(localArrayList, localIntent1);
      paramcs = localArrayList.iterator();
      for (;;)
      {
        if (paramcs.hasNext())
        {
          ((Intent)paramcs.next()).setPackage(au.b());
          continue;
          localIntent1 = new Intent(c, null);
          str = paramActivity.getString(2131297490);
          break;
          localIntent1 = localIntent2;
          if (paramcs.d()) {
            break label137;
          }
          localIntent1 = (Intent)localArrayList.get(0);
          localArrayList.remove(0);
          break label137;
        }
      }
      localIntent1.setPackage(au.b());
      paramcs = Intent.createChooser(localIntent1, str);
      if (!localArrayList.isEmpty()) {
        paramcs.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])localArrayList.toArray(new Intent[localArrayList.size()]));
      }
      paramActivity.startActivityForResult(paramcs, paramInt);
      return;
    }
  }
  
  public final void a(cs paramcs)
  {
    this.k.a(this.k.a(this.l, paramcs.t, null, null));
  }
  
  public final void a(ng paramng, Intent paramIntent)
  {
    CropImage.a(this.g, paramIntent, paramng);
  }
  
  public final void a(nh paramnh, int paramInt, Intent paramIntent)
  {
    BitmapFactory.Options localOptions = null;
    Object localObject1;
    Object localObject2;
    if (paramIntent != null)
    {
      localObject1 = paramIntent.getData();
      localObject2 = paramIntent.getStringExtra("webImageSource");
      paramIntent = (Intent)localObject1;
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = paramIntent;
      if (paramIntent == null)
      {
        localObject2 = paramIntent;
        if (b().exists()) {
          localObject2 = Uri.fromFile(b());
        }
      }
      c().delete();
      if (localObject2 != null)
      {
        try
        {
          paramIntent = this.i.f;
          if (paramIntent == null)
          {
            Log.w("profileinfo/cropphoto contentResolver=null");
            paramIntent = localOptions;
          }
          while (paramIntent != null)
          {
            localOptions = new BitmapFactory.Options();
            localOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(paramIntent, null, localOptions);
            paramIntent.close();
            if ((localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
            {
              Log.e("profileinfo/cropphoto/not-an-image " + localObject2);
              paramnh.b_(2131296734);
              return;
              paramIntent = paramIntent.openInputStream((Uri)localObject2);
            }
            else
            {
              if ((localOptions.outWidth >= 192) && (localOptions.outHeight >= 192)) {
                break label293;
              }
              paramnh.d(String.format(u.a.a(2131230744, 192), new Object[] { Integer.valueOf(192) }));
              return;
            }
          }
        }
        catch (IOException paramIntent)
        {
          Log.d("profileinfo/cropphoto/ " + localObject2, paramIntent);
          paramnh.b_(2131296737);
          return;
        }
        Log.e("profileinfo/cropphoto/no-input-stream " + localObject2);
        paramnh.b_(2131296737);
        return;
        label293:
        paramIntent = new Intent(paramnh, CropImage.class);
        paramIntent.putExtra("outputX", 640);
        paramIntent.putExtra("outputY", 640);
        paramIntent.putExtra("minCrop", 192);
        paramIntent.putExtra("aspectX", 1);
        paramIntent.putExtra("aspectY", 1);
        paramIntent.putExtra("scale", true);
        paramIntent.putExtra("scaleUpIfNeeded", false);
        paramIntent.putExtra("cropByOutputSize", false);
        paramIntent.setData((Uri)localObject2);
        paramIntent.putExtra("output", Uri.fromFile(c()));
        paramIntent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        paramIntent.putExtra("webImageSource", (String)localObject1);
        paramnh.startActivityForResult(paramIntent, paramInt);
        return;
      }
      Log.e("profileinfo/cropphoto/no-data");
      paramnh.b_(2131296734);
      return;
      localObject1 = null;
      paramIntent = null;
    }
  }
  
  /* Error */
  public final boolean a(Activity paramActivity, cs paramcs)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 74	com/whatsapp/acw:j	Lcom/whatsapp/aat;
    //   4: invokevirtual 404	com/whatsapp/aat:b	()Z
    //   7: ifne +16 -> 23
    //   10: aload_1
    //   11: invokevirtual 408	android/app/Activity:getBaseContext	()Landroid/content/Context;
    //   14: ldc_w 409
    //   17: iconst_0
    //   18: invokestatic 412	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_0
    //   24: invokevirtual 269	com/whatsapp/acw:c	()Ljava/io/File;
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 416	java/io/File:length	()J
    //   32: l2i
    //   33: newarray <illegal type>
    //   35: astore 6
    //   37: new 418	java/io/FileInputStream
    //   40: dup
    //   41: aload_3
    //   42: invokespecial 421	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: astore 4
    //   47: aconst_null
    //   48: astore_3
    //   49: aload 4
    //   51: aload 6
    //   53: invokevirtual 425	java/io/FileInputStream:read	([B)I
    //   56: pop
    //   57: aload 4
    //   59: invokevirtual 426	java/io/FileInputStream:close	()V
    //   62: new 279	android/graphics/BitmapFactory$Options
    //   65: dup
    //   66: invokespecial 280	android/graphics/BitmapFactory$Options:<init>	()V
    //   69: astore_3
    //   70: aload_3
    //   71: iconst_1
    //   72: putfield 284	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   75: aload 6
    //   77: iconst_0
    //   78: aload 6
    //   80: arraylength
    //   81: aload_3
    //   82: invokestatic 430	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   85: pop
    //   86: aload_3
    //   87: aload_3
    //   88: getfield 299	android/graphics/BitmapFactory$Options:outWidth	I
    //   91: aload_3
    //   92: getfield 302	android/graphics/BitmapFactory$Options:outHeight	I
    //   95: invokestatic 436	java/lang/Math:min	(II)I
    //   98: bipush 96
    //   100: idiv
    //   101: putfield 439	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   104: aload_3
    //   105: iconst_0
    //   106: putfield 284	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   109: aload_3
    //   110: iconst_0
    //   111: putfield 442	android/graphics/BitmapFactory$Options:inScaled	Z
    //   114: aload_3
    //   115: iconst_1
    //   116: putfield 445	android/graphics/BitmapFactory$Options:inDither	Z
    //   119: aload_3
    //   120: iconst_1
    //   121: putfield 448	android/graphics/BitmapFactory$Options:inPreferQualityOverSpeed	Z
    //   124: aload 6
    //   126: iconst_0
    //   127: aload 6
    //   129: arraylength
    //   130: aload_3
    //   131: invokestatic 430	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   134: astore 5
    //   136: aload 5
    //   138: ifnull +342 -> 480
    //   141: aload 5
    //   143: invokevirtual 454	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   146: astore 4
    //   148: aload 4
    //   150: astore_3
    //   151: aload 4
    //   153: ifnonnull +7 -> 160
    //   156: getstatic 460	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   159: astore_3
    //   160: bipush 96
    //   162: bipush 96
    //   164: aload_3
    //   165: invokestatic 464	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   168: astore 7
    //   170: new 466	android/graphics/Canvas
    //   173: dup
    //   174: aload 7
    //   176: invokespecial 469	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   179: astore_3
    //   180: new 471	android/graphics/Paint
    //   183: dup
    //   184: invokespecial 472	android/graphics/Paint:<init>	()V
    //   187: astore 4
    //   189: aload 4
    //   191: iconst_1
    //   192: invokevirtual 476	android/graphics/Paint:setAntiAlias	(Z)V
    //   195: aload 4
    //   197: iconst_1
    //   198: invokevirtual 479	android/graphics/Paint:setFilterBitmap	(Z)V
    //   201: aload 4
    //   203: iconst_1
    //   204: invokevirtual 482	android/graphics/Paint:setDither	(Z)V
    //   207: aload_3
    //   208: aload 5
    //   210: new 484	android/graphics/Rect
    //   213: dup
    //   214: iconst_0
    //   215: iconst_0
    //   216: aload 5
    //   218: invokevirtual 487	android/graphics/Bitmap:getWidth	()I
    //   221: aload 5
    //   223: invokevirtual 490	android/graphics/Bitmap:getHeight	()I
    //   226: invokespecial 493	android/graphics/Rect:<init>	(IIII)V
    //   229: new 484	android/graphics/Rect
    //   232: dup
    //   233: iconst_0
    //   234: iconst_0
    //   235: bipush 96
    //   237: bipush 96
    //   239: invokespecial 493	android/graphics/Rect:<init>	(IIII)V
    //   242: aload 4
    //   244: invokevirtual 497	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   247: aload 5
    //   249: invokevirtual 500	android/graphics/Bitmap:recycle	()V
    //   252: new 502	java/io/FileOutputStream
    //   255: dup
    //   256: aload_0
    //   257: invokespecial 504	com/whatsapp/acw:d	()Ljava/io/File;
    //   260: invokespecial 505	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   263: astore 4
    //   265: aload 4
    //   267: astore_3
    //   268: aload 7
    //   270: getstatic 393	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   273: bipush 75
    //   275: aload 4
    //   277: invokevirtual 509	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   280: pop
    //   281: aload 4
    //   283: invokestatic 514	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   286: aload 7
    //   288: invokevirtual 500	android/graphics/Bitmap:recycle	()V
    //   291: aload_0
    //   292: invokespecial 504	com/whatsapp/acw:d	()Ljava/io/File;
    //   295: astore_3
    //   296: aload_3
    //   297: invokevirtual 416	java/io/File:length	()J
    //   300: l2i
    //   301: newarray <illegal type>
    //   303: astore 5
    //   305: new 418	java/io/FileInputStream
    //   308: dup
    //   309: aload_3
    //   310: invokespecial 421	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   313: astore 4
    //   315: aconst_null
    //   316: astore_3
    //   317: aload 4
    //   319: aload 5
    //   321: invokevirtual 425	java/io/FileInputStream:read	([B)I
    //   324: pop
    //   325: aload 4
    //   327: invokevirtual 426	java/io/FileInputStream:close	()V
    //   330: aload_0
    //   331: getfield 76	com/whatsapp/acw:k	Lcom/whatsapp/acm;
    //   334: aload_0
    //   335: getfield 76	com/whatsapp/acw:k	Lcom/whatsapp/acm;
    //   338: aload_0
    //   339: getfield 78	com/whatsapp/acw:l	Lcom/whatsapp/rh;
    //   342: aload_2
    //   343: getfield 243	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   346: aload 6
    //   348: aload 5
    //   350: invokevirtual 246	com/whatsapp/acm:a	(Lcom/whatsapp/rh;Ljava/lang/String;[B[B)Lcom/whatsapp/ach;
    //   353: invokevirtual 249	com/whatsapp/acm:a	(Lcom/whatsapp/ach;)V
    //   356: iconst_1
    //   357: ireturn
    //   358: astore_2
    //   359: aload_2
    //   360: astore_3
    //   361: aload_2
    //   362: athrow
    //   363: astore_2
    //   364: aload_3
    //   365: ifnull +31 -> 396
    //   368: aload 4
    //   370: invokevirtual 426	java/io/FileInputStream:close	()V
    //   373: aload_2
    //   374: athrow
    //   375: astore_2
    //   376: aload_1
    //   377: invokevirtual 408	android/app/Activity:getBaseContext	()Landroid/content/Context;
    //   380: ldc_w 354
    //   383: iconst_0
    //   384: invokestatic 412	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   387: ldc_w 516
    //   390: aload_2
    //   391: invokestatic 353	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   394: iconst_0
    //   395: ireturn
    //   396: aload 4
    //   398: invokevirtual 426	java/io/FileInputStream:close	()V
    //   401: goto -28 -> 373
    //   404: astore_2
    //   405: aload_1
    //   406: invokevirtual 408	android/app/Activity:getBaseContext	()Landroid/content/Context;
    //   409: ldc_w 354
    //   412: iconst_0
    //   413: invokestatic 412	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   416: ldc_w 516
    //   419: aload_2
    //   420: invokestatic 353	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   423: iconst_0
    //   424: ireturn
    //   425: astore 5
    //   427: aconst_null
    //   428: astore 4
    //   430: aload 4
    //   432: astore_3
    //   433: ldc_w 518
    //   436: aload 5
    //   438: invokestatic 353	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   441: aload 4
    //   443: invokestatic 514	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   446: goto -160 -> 286
    //   449: aload_3
    //   450: invokestatic 514	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   453: aload_2
    //   454: athrow
    //   455: astore_2
    //   456: aload_2
    //   457: astore_3
    //   458: aload_2
    //   459: athrow
    //   460: astore_2
    //   461: aload_3
    //   462: ifnull +10 -> 472
    //   465: aload 4
    //   467: invokevirtual 426	java/io/FileInputStream:close	()V
    //   470: aload_2
    //   471: athrow
    //   472: aload 4
    //   474: invokevirtual 426	java/io/FileInputStream:close	()V
    //   477: goto -7 -> 470
    //   480: aload_1
    //   481: invokevirtual 408	android/app/Activity:getBaseContext	()Landroid/content/Context;
    //   484: ldc_w 354
    //   487: iconst_0
    //   488: invokestatic 412	com/whatsapp/pv:a	(Landroid/content/Context;II)V
    //   491: ldc_w 520
    //   494: invokestatic 310	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   497: iconst_0
    //   498: ireturn
    //   499: astore_3
    //   500: goto -127 -> 373
    //   503: astore_3
    //   504: goto -34 -> 470
    //   507: astore_2
    //   508: goto -59 -> 449
    //   511: astore 5
    //   513: goto -83 -> 430
    //   516: astore_2
    //   517: aconst_null
    //   518: astore_3
    //   519: goto -70 -> 449
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	522	0	this	acw
    //   0	522	1	paramActivity	Activity
    //   0	522	2	paramcs	cs
    //   27	435	3	localObject1	Object
    //   499	1	3	localThrowable1	Throwable
    //   503	1	3	localThrowable2	Throwable
    //   518	1	3	localObject2	Object
    //   45	428	4	localObject3	Object
    //   134	215	5	localObject4	Object
    //   425	12	5	localIOException1	IOException
    //   511	1	5	localIOException2	IOException
    //   35	312	6	arrayOfByte	byte[]
    //   168	119	7	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   49	57	358	java/lang/Throwable
    //   49	57	363	finally
    //   361	363	363	finally
    //   23	47	375	java/io/FileNotFoundException
    //   57	136	375	java/io/FileNotFoundException
    //   141	148	375	java/io/FileNotFoundException
    //   156	160	375	java/io/FileNotFoundException
    //   160	252	375	java/io/FileNotFoundException
    //   281	286	375	java/io/FileNotFoundException
    //   286	315	375	java/io/FileNotFoundException
    //   325	356	375	java/io/FileNotFoundException
    //   368	373	375	java/io/FileNotFoundException
    //   373	375	375	java/io/FileNotFoundException
    //   396	401	375	java/io/FileNotFoundException
    //   441	446	375	java/io/FileNotFoundException
    //   449	455	375	java/io/FileNotFoundException
    //   465	470	375	java/io/FileNotFoundException
    //   470	472	375	java/io/FileNotFoundException
    //   472	477	375	java/io/FileNotFoundException
    //   480	497	375	java/io/FileNotFoundException
    //   23	47	404	java/io/IOException
    //   57	136	404	java/io/IOException
    //   141	148	404	java/io/IOException
    //   156	160	404	java/io/IOException
    //   160	252	404	java/io/IOException
    //   281	286	404	java/io/IOException
    //   286	315	404	java/io/IOException
    //   325	356	404	java/io/IOException
    //   368	373	404	java/io/IOException
    //   373	375	404	java/io/IOException
    //   396	401	404	java/io/IOException
    //   441	446	404	java/io/IOException
    //   449	455	404	java/io/IOException
    //   465	470	404	java/io/IOException
    //   470	472	404	java/io/IOException
    //   472	477	404	java/io/IOException
    //   480	497	404	java/io/IOException
    //   252	265	425	java/io/IOException
    //   317	325	455	java/lang/Throwable
    //   317	325	460	finally
    //   458	460	460	finally
    //   368	373	499	java/lang/Throwable
    //   465	470	503	java/lang/Throwable
    //   268	281	507	finally
    //   433	441	507	finally
    //   268	281	511	java/io/IOException
    //   252	265	516	finally
  }
  
  public final File b()
  {
    return this.h.a("tmpi");
  }
  
  final File c()
  {
    return this.h.a("tmpp");
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/acw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */