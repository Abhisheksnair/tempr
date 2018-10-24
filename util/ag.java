package com.whatsapp.util;

import a.a.a.a.a.a.d;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.f.f;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import com.whatsapp.MediaData;
import com.whatsapp.aoa;
import com.whatsapp.oz;
import com.whatsapp.protocol.ah;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.l;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ag
{
  public static final BitmapFactory.Options a;
  private static volatile ag c;
  final ao b;
  private final ah d;
  private final List<Runnable> e = new ArrayList();
  private final HashMap<j.b, SoftReference<Bitmap>> f = new HashMap();
  private final Handler g = new Handler(Looper.getMainLooper());
  private f<j.b, Bitmap> h;
  private int i;
  private final a j = new b((byte)0);
  
  static
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    a = localOptions;
    localOptions.inInputShareable = true;
    a.inPurgeable = true;
    a.inDither = true;
  }
  
  private ag(oz paramoz, ah paramah)
  {
    this.d = paramah;
    this.b = new ao(paramoz);
    int k = (int)(Runtime.getRuntime().maxMemory() / 1024L / 8L);
    Log.i("messagethumbcache/construct " + k);
    this.h = new f(k) {};
  }
  
  public static int a(j paramj, int paramInt)
  {
    int k = ao.a(paramj, paramInt);
    if (k > 0) {
      return k;
    }
    Object localObject;
    if ((paramj.s == 0) && ((paramj.N instanceof byte[])))
    {
      paramj = (byte[])paramj.N;
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeByteArray(paramj, 0, paramj.length, (BitmapFactory.Options)localObject);
      if ((((BitmapFactory.Options)localObject).outWidth > 0) && (((BitmapFactory.Options)localObject).outHeight > 0)) {
        return ((BitmapFactory.Options)localObject).outHeight * paramInt / ((BitmapFactory.Options)localObject).outWidth;
      }
      return -1;
    }
    if (l.a(paramj.s))
    {
      paramj = paramj.f();
      float f1;
      if (paramj.c == null)
      {
        if ((!l.a(paramj.a.s)) || (paramj.a.m != 0) || (paramj.a.e() == null) || (paramj.a.e().length() <= 0)) {
          break label209;
        }
        f1 = l.b(Base64.decode(paramj.a.e(), 0));
      }
      for (;;)
      {
        paramj.c = Float.valueOf(f1);
        if (paramj.c.floatValue() < 0.0F) {
          break;
        }
        return (int)(paramInt * paramj.c.floatValue());
        label209:
        if ((paramj.a.h() != null) && (paramj.a.h().length > 0))
        {
          f1 = l.b(paramj.a.h());
        }
        else
        {
          localObject = paramj.a.b();
          if ((localObject != null) && (((MediaData)localObject).thumbnailHeightWidthRatio > 0.0F)) {
            f1 = ((MediaData)localObject).thumbnailHeightWidthRatio;
          } else {
            f1 = -1.0F;
          }
        }
      }
    }
    return -1;
  }
  
  public static ag a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new ag(oz.a(), ah.a());
      }
      return c;
    }
    finally {}
  }
  
  private Bitmap c(j paramj)
  {
    for (;;)
    {
      try
      {
        Object localObject2 = (Bitmap)this.h.a(paramj.e);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (!((Bitmap)localObject2).isRecycled()) {}
        }
        else
        {
          if ((localObject2 != null) && (((Bitmap)localObject2).isRecycled())) {
            Log.e("!! recycled message in hard cache");
          }
          localObject2 = (SoftReference)this.f.get(paramj.e);
          if (localObject2 == null) {
            break label115;
          }
          localObject1 = (Bitmap)((SoftReference)localObject2).get();
          if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled())) {
            break label112;
          }
          if (localObject2 != null) {
            this.f.remove(paramj.e);
          }
          localObject1 = null;
        }
        return (Bitmap)localObject1;
      }
      finally {}
      label112:
      continue;
      label115:
      Object localObject1 = null;
    }
  }
  
  /* Error */
  private Bitmap c(j paramj, View paramView, a parama, Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: invokestatic 281	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   8: invokestatic 73	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   11: if_acmpne +7 -> 18
    //   14: aload_0
    //   15: invokevirtual 283	com/whatsapp/util/ag:b	()V
    //   18: aload_1
    //   19: invokestatic 286	com/whatsapp/util/ag:d	(Lcom/whatsapp/protocol/j;)Z
    //   22: ifne +19 -> 41
    //   25: aload_3
    //   26: aload_2
    //   27: aconst_null
    //   28: aload_1
    //   29: invokeinterface 247 4 0
    //   34: aload 5
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: areturn
    //   41: aload_0
    //   42: aload_1
    //   43: invokespecial 288	com/whatsapp/util/ag:c	(Lcom/whatsapp/protocol/j;)Landroid/graphics/Bitmap;
    //   46: astore 5
    //   48: new 290	com/whatsapp/util/ao$a
    //   51: dup
    //   52: aload_0
    //   53: aload_1
    //   54: aload 4
    //   56: aload_2
    //   57: aload_3
    //   58: invokespecial 293	com/whatsapp/util/ao$a:<init>	(Lcom/whatsapp/util/ag;Lcom/whatsapp/protocol/j;Ljava/lang/Object;Landroid/view/View;Lcom/whatsapp/util/ag$a;)V
    //   61: astore 6
    //   63: aload 5
    //   65: ifnonnull +100 -> 165
    //   68: aload_0
    //   69: aload_1
    //   70: iconst_1
    //   71: invokevirtual 296	com/whatsapp/util/ag:a	(Lcom/whatsapp/protocol/j;Z)Landroid/graphics/Bitmap;
    //   74: astore 5
    //   76: aload_1
    //   77: invokevirtual 168	com/whatsapp/protocol/j:f	()Lcom/whatsapp/protocol/l;
    //   80: astore 7
    //   82: aload 5
    //   84: ifnonnull +51 -> 135
    //   87: aload 7
    //   89: ifnull +46 -> 135
    //   92: aload 7
    //   94: invokevirtual 298	com/whatsapp/protocol/l:a	()Z
    //   97: ifne +38 -> 135
    //   100: aload_0
    //   101: getfield 85	com/whatsapp/util/ag:d	Lcom/whatsapp/protocol/ah;
    //   104: aload 7
    //   106: aload_0
    //   107: aload 7
    //   109: aload_1
    //   110: aload 4
    //   112: aload_2
    //   113: aload_3
    //   114: aload 6
    //   116: invokestatic 303	com/whatsapp/util/ah:a	(Lcom/whatsapp/util/ag;Lcom/whatsapp/protocol/l;Lcom/whatsapp/protocol/j;Ljava/lang/Object;Landroid/view/View;Lcom/whatsapp/util/ag$a;Lcom/whatsapp/util/ao$a;)Ljava/lang/Runnable;
    //   119: invokevirtual 306	com/whatsapp/protocol/ah:a	(Lcom/whatsapp/protocol/l;Ljava/lang/Runnable;)V
    //   122: aload_3
    //   123: aload_2
    //   124: invokeinterface 309 2 0
    //   129: aload 5
    //   131: astore_1
    //   132: goto -95 -> 37
    //   135: aload_3
    //   136: aload_2
    //   137: aload 5
    //   139: aload_1
    //   140: invokeinterface 247 4 0
    //   145: aload_0
    //   146: getfield 92	com/whatsapp/util/ag:b	Lcom/whatsapp/util/ao;
    //   149: aload_1
    //   150: aload_2
    //   151: aload_3
    //   152: aload 6
    //   154: aload 4
    //   156: invokevirtual 312	com/whatsapp/util/ao:a	(Lcom/whatsapp/protocol/j;Landroid/view/View;Lcom/whatsapp/util/ag$a;Lcom/whatsapp/util/ao$a;Ljava/lang/Object;)V
    //   159: aload 5
    //   161: astore_1
    //   162: goto -125 -> 37
    //   165: aload_3
    //   166: invokeinterface 314 1 0
    //   171: i2f
    //   172: invokestatic 319	com/whatsapp/aoa:a	()Lcom/whatsapp/aoa;
    //   175: getfield 321	com/whatsapp/aoa:a	F
    //   178: fdiv
    //   179: f2i
    //   180: aload 5
    //   182: invokevirtual 324	android/graphics/Bitmap:getWidth	()I
    //   185: iconst_1
    //   186: ishl
    //   187: if_icmple +17 -> 204
    //   190: aload_0
    //   191: getfield 92	com/whatsapp/util/ag:b	Lcom/whatsapp/util/ao;
    //   194: aload_1
    //   195: aload_2
    //   196: aload_3
    //   197: aload 6
    //   199: aload 4
    //   201: invokevirtual 312	com/whatsapp/util/ao:a	(Lcom/whatsapp/protocol/j;Landroid/view/View;Lcom/whatsapp/util/ag$a;Lcom/whatsapp/util/ao$a;Ljava/lang/Object;)V
    //   204: aload_3
    //   205: aload_2
    //   206: aload 5
    //   208: aload_1
    //   209: invokeinterface 247 4 0
    //   214: aload 5
    //   216: astore_1
    //   217: goto -180 -> 37
    //   220: astore_1
    //   221: aload_0
    //   222: monitorexit
    //   223: aload_1
    //   224: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	ag
    //   0	225	1	paramj	j
    //   0	225	2	paramView	View
    //   0	225	3	parama	a
    //   0	225	4	paramObject	Object
    //   1	214	5	localBitmap	Bitmap
    //   61	137	6	locala	ao.a
    //   80	28	7	locall	l
    // Exception table:
    //   from	to	target	type
    //   5	18	220	finally
    //   18	34	220	finally
    //   41	63	220	finally
    //   68	82	220	finally
    //   92	129	220	finally
    //   135	159	220	finally
    //   165	204	220	finally
    //   204	214	220	finally
  }
  
  private static boolean d(j paramj)
  {
    return ((paramj.s == 0) && ((paramj.N instanceof byte[]))) || ((paramj.f() != null) && (paramj.f().d()));
  }
  
  /* Error */
  public final Bitmap a(j paramj)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 330	a/a/a/a/a/a$d:c	()V
    //   5: aload_0
    //   6: aload_1
    //   7: iconst_0
    //   8: invokevirtual 296	com/whatsapp/util/ag:a	(Lcom/whatsapp/protocol/j;Z)Landroid/graphics/Bitmap;
    //   11: astore_3
    //   12: aload_3
    //   13: astore_2
    //   14: aload_3
    //   15: ifnonnull +49 -> 64
    //   18: aload_1
    //   19: invokevirtual 168	com/whatsapp/protocol/j:f	()Lcom/whatsapp/protocol/l;
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull +44 -> 68
    //   27: aload_1
    //   28: invokevirtual 298	com/whatsapp/protocol/l:a	()Z
    //   31: ifne +37 -> 68
    //   34: aload_0
    //   35: getfield 85	com/whatsapp/util/ag:d	Lcom/whatsapp/protocol/ah;
    //   38: aload_1
    //   39: invokevirtual 333	com/whatsapp/protocol/ah:a	(Lcom/whatsapp/protocol/l;)V
    //   42: aload_1
    //   43: invokevirtual 335	com/whatsapp/protocol/l:b	()[B
    //   46: astore_1
    //   47: aload_3
    //   48: astore_2
    //   49: aload_1
    //   50: ifnull +14 -> 64
    //   53: aload_1
    //   54: iconst_0
    //   55: aload_1
    //   56: arraylength
    //   57: getstatic 42	com/whatsapp/util/ag:a	Landroid/graphics/BitmapFactory$Options;
    //   60: invokestatic 154	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   63: astore_2
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_2
    //   67: areturn
    //   68: aconst_null
    //   69: astore_2
    //   70: goto -6 -> 64
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	ag
    //   0	78	1	paramj	j
    //   13	57	2	localBitmap1	Bitmap
    //   11	37	3	localBitmap2	Bitmap
    // Exception table:
    //   from	to	target	type
    //   2	12	73	finally
    //   18	23	73	finally
    //   27	47	73	finally
    //   53	64	73	finally
  }
  
  /* Error */
  final Bitmap a(j paramj, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 7
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_1
    //   12: getfield 139	com/whatsapp/protocol/j:s	B
    //   15: ifne +205 -> 220
    //   18: aload_1
    //   19: getfield 143	com/whatsapp/protocol/j:N	Ljava/lang/Object;
    //   22: instanceof 145
    //   25: ifeq +195 -> 220
    //   28: aload_1
    //   29: getfield 143	com/whatsapp/protocol/j:N	Ljava/lang/Object;
    //   32: checkcast 145	[B
    //   35: astore 6
    //   37: aload 6
    //   39: ifnull +373 -> 412
    //   42: aload 6
    //   44: iconst_0
    //   45: aload 6
    //   47: arraylength
    //   48: getstatic 42	com/whatsapp/util/ag:a	Landroid/graphics/BitmapFactory$Options;
    //   51: invokestatic 154	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   54: astore 6
    //   56: aload 6
    //   58: astore 7
    //   60: aload 6
    //   62: ifnull +235 -> 297
    //   65: aload 6
    //   67: astore 7
    //   69: iload_2
    //   70: ifeq +227 -> 297
    //   73: aload_1
    //   74: invokevirtual 210	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   77: astore 8
    //   79: aload 6
    //   81: astore 7
    //   83: aload_1
    //   84: getfield 139	com/whatsapp/protocol/j:s	B
    //   87: bipush 9
    //   89: if_icmpeq +208 -> 297
    //   92: aload 8
    //   94: getfield 345	com/whatsapp/MediaData:file	Ljava/io/File;
    //   97: ifnull +18 -> 115
    //   100: aload 6
    //   102: astore 7
    //   104: aload 8
    //   106: getfield 345	com/whatsapp/MediaData:file	Ljava/io/File;
    //   109: invokevirtual 350	java/io/File:exists	()Z
    //   112: ifne +185 -> 297
    //   115: aload 6
    //   117: invokevirtual 324	android/graphics/Bitmap:getWidth	()I
    //   120: aload 6
    //   122: invokevirtual 353	android/graphics/Bitmap:getHeight	()I
    //   125: imul
    //   126: newarray <illegal type>
    //   128: astore 8
    //   130: aload 6
    //   132: aload 8
    //   134: iconst_0
    //   135: aload 6
    //   137: invokevirtual 324	android/graphics/Bitmap:getWidth	()I
    //   140: iconst_0
    //   141: iconst_0
    //   142: aload 6
    //   144: invokevirtual 324	android/graphics/Bitmap:getWidth	()I
    //   147: aload 6
    //   149: invokevirtual 353	android/graphics/Bitmap:getHeight	()I
    //   152: invokevirtual 357	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   155: aload 6
    //   157: invokevirtual 324	android/graphics/Bitmap:getWidth	()I
    //   160: aload 6
    //   162: invokevirtual 353	android/graphics/Bitmap:getHeight	()I
    //   165: imul
    //   166: newarray <illegal type>
    //   168: astore 7
    //   170: aload 6
    //   172: invokevirtual 324	android/graphics/Bitmap:getWidth	()I
    //   175: istore 4
    //   177: aload 6
    //   179: invokevirtual 353	android/graphics/Bitmap:getHeight	()I
    //   182: istore 5
    //   184: iconst_0
    //   185: istore_3
    //   186: iload_3
    //   187: iconst_2
    //   188: if_icmpge +61 -> 249
    //   191: aload 8
    //   193: aload 7
    //   195: iload 4
    //   197: iload 5
    //   199: invokestatic 362	a/a/a/a/d:a	([I[III)V
    //   202: aload 7
    //   204: aload 8
    //   206: iload 5
    //   208: iload 4
    //   210: invokestatic 362	a/a/a/a/d:a	([I[III)V
    //   213: iload_3
    //   214: iconst_1
    //   215: iadd
    //   216: istore_3
    //   217: goto -31 -> 186
    //   220: aload_1
    //   221: invokevirtual 168	com/whatsapp/protocol/j:f	()Lcom/whatsapp/protocol/l;
    //   224: ifnull +275 -> 499
    //   227: aload_1
    //   228: invokevirtual 168	com/whatsapp/protocol/j:f	()Lcom/whatsapp/protocol/l;
    //   231: invokevirtual 298	com/whatsapp/protocol/l:a	()Z
    //   234: ifeq +265 -> 499
    //   237: aload_1
    //   238: invokevirtual 168	com/whatsapp/protocol/j:f	()Lcom/whatsapp/protocol/l;
    //   241: invokevirtual 335	com/whatsapp/protocol/l:b	()[B
    //   244: astore 6
    //   246: goto -209 -> 37
    //   249: aload 6
    //   251: invokevirtual 324	android/graphics/Bitmap:getWidth	()I
    //   254: aload 6
    //   256: invokevirtual 353	android/graphics/Bitmap:getHeight	()I
    //   259: getstatic 368	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   262: invokestatic 372	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   265: astore 7
    //   267: aload 7
    //   269: aload 8
    //   271: iconst_0
    //   272: aload 6
    //   274: invokevirtual 324	android/graphics/Bitmap:getWidth	()I
    //   277: iconst_0
    //   278: iconst_0
    //   279: aload 6
    //   281: invokevirtual 324	android/graphics/Bitmap:getWidth	()I
    //   284: aload 6
    //   286: invokevirtual 353	android/graphics/Bitmap:getHeight	()I
    //   289: invokevirtual 375	android/graphics/Bitmap:setPixels	([IIIIIII)V
    //   292: aload 6
    //   294: invokevirtual 378	android/graphics/Bitmap:recycle	()V
    //   297: aload_0
    //   298: monitorexit
    //   299: aload 7
    //   301: areturn
    //   302: astore 6
    //   304: aload 7
    //   306: astore 8
    //   308: aload 6
    //   310: astore 7
    //   312: aload 8
    //   314: astore 6
    //   316: new 108	java/lang/StringBuilder
    //   319: dup
    //   320: ldc_w 380
    //   323: invokespecial 113	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   326: aload_1
    //   327: getfield 177	com/whatsapp/protocol/j:m	I
    //   330: invokevirtual 117	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   333: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   336: invokestatic 267	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   339: aload_1
    //   340: getfield 177	com/whatsapp/protocol/j:m	I
    //   343: ifne +49 -> 392
    //   346: aload_1
    //   347: invokevirtual 179	com/whatsapp/protocol/j:e	()Ljava/lang/String;
    //   350: ifnull +42 -> 392
    //   353: new 108	java/lang/StringBuilder
    //   356: dup
    //   357: ldc_w 382
    //   360: invokespecial 113	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   363: aload_1
    //   364: invokevirtual 179	com/whatsapp/protocol/j:e	()Ljava/lang/String;
    //   367: iconst_0
    //   368: bipush 100
    //   370: aload_1
    //   371: invokevirtual 179	com/whatsapp/protocol/j:e	()Ljava/lang/String;
    //   374: invokevirtual 185	java/lang/String:length	()I
    //   377: invokestatic 388	java/lang/Math:min	(II)I
    //   380: invokevirtual 392	java/lang/String:substring	(II)Ljava/lang/String;
    //   383: invokevirtual 395	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 121	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 267	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   392: ldc_w 397
    //   395: aload 7
    //   397: invokestatic 400	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   400: aload 6
    //   402: astore 7
    //   404: goto -107 -> 297
    //   407: astore_1
    //   408: aload_0
    //   409: monitorexit
    //   410: aload_1
    //   411: athrow
    //   412: aconst_null
    //   413: astore 7
    //   415: goto -118 -> 297
    //   418: astore 6
    //   420: aload 8
    //   422: astore 7
    //   424: aload 6
    //   426: astore 8
    //   428: aload 7
    //   430: astore 6
    //   432: aload 8
    //   434: astore 7
    //   436: goto -120 -> 316
    //   439: astore 6
    //   441: aload 9
    //   443: astore 7
    //   445: aload 6
    //   447: astore 8
    //   449: aload 7
    //   451: astore 6
    //   453: aload 8
    //   455: astore 7
    //   457: goto -141 -> 316
    //   460: astore 8
    //   462: aload 6
    //   464: astore 7
    //   466: aload 8
    //   468: astore 6
    //   470: goto -166 -> 304
    //   473: astore 8
    //   475: aload 6
    //   477: astore 7
    //   479: aload 8
    //   481: astore 6
    //   483: goto -38 -> 445
    //   486: astore 8
    //   488: aload 6
    //   490: astore 7
    //   492: aload 8
    //   494: astore 6
    //   496: goto -72 -> 424
    //   499: aconst_null
    //   500: astore 6
    //   502: goto -465 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	505	0	this	ag
    //   0	505	1	paramj	j
    //   0	505	2	paramBoolean	boolean
    //   185	32	3	k	int
    //   175	34	4	m	int
    //   182	25	5	n	int
    //   35	258	6	localObject1	Object
    //   302	7	6	localArrayIndexOutOfBoundsException1	ArrayIndexOutOfBoundsException
    //   314	87	6	localObject2	Object
    //   418	7	6	localStringIndexOutOfBoundsException1	StringIndexOutOfBoundsException
    //   430	1	6	localObject3	Object
    //   439	7	6	localIllegalArgumentException1	IllegalArgumentException
    //   451	50	6	localObject4	Object
    //   7	484	7	localObject5	Object
    //   1	453	8	localObject6	Object
    //   460	7	8	localArrayIndexOutOfBoundsException2	ArrayIndexOutOfBoundsException
    //   473	7	8	localIllegalArgumentException2	IllegalArgumentException
    //   486	7	8	localStringIndexOutOfBoundsException2	StringIndexOutOfBoundsException
    //   4	438	9	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   42	56	302	java/lang/ArrayIndexOutOfBoundsException
    //   11	37	407	finally
    //   42	56	407	finally
    //   73	79	407	finally
    //   83	100	407	finally
    //   104	115	407	finally
    //   115	184	407	finally
    //   191	213	407	finally
    //   220	246	407	finally
    //   249	297	407	finally
    //   316	392	407	finally
    //   392	400	407	finally
    //   42	56	418	java/lang/StringIndexOutOfBoundsException
    //   42	56	439	java/lang/IllegalArgumentException
    //   73	79	460	java/lang/ArrayIndexOutOfBoundsException
    //   83	100	460	java/lang/ArrayIndexOutOfBoundsException
    //   104	115	460	java/lang/ArrayIndexOutOfBoundsException
    //   115	184	460	java/lang/ArrayIndexOutOfBoundsException
    //   191	213	460	java/lang/ArrayIndexOutOfBoundsException
    //   249	297	460	java/lang/ArrayIndexOutOfBoundsException
    //   73	79	473	java/lang/IllegalArgumentException
    //   83	100	473	java/lang/IllegalArgumentException
    //   104	115	473	java/lang/IllegalArgumentException
    //   115	184	473	java/lang/IllegalArgumentException
    //   191	213	473	java/lang/IllegalArgumentException
    //   249	297	473	java/lang/IllegalArgumentException
    //   73	79	486	java/lang/StringIndexOutOfBoundsException
    //   83	100	486	java/lang/StringIndexOutOfBoundsException
    //   104	115	486	java/lang/StringIndexOutOfBoundsException
    //   115	184	486	java/lang/StringIndexOutOfBoundsException
    //   191	213	486	java/lang/StringIndexOutOfBoundsException
    //   249	297	486	java/lang/StringIndexOutOfBoundsException
  }
  
  final void a(j paramj, Bitmap paramBitmap)
  {
    try
    {
      this.f.remove(paramj.e);
      if (paramBitmap != null) {
        this.h.a(paramj.e, paramBitmap);
      }
      return;
    }
    finally {}
  }
  
  public final void a(j paramj, View paramView, a parama)
  {
    a locala = parama;
    if (parama == null) {
      locala = this.j;
    }
    a(paramj, paramView, locala, paramj.e);
  }
  
  public final void a(j paramj, View paramView, a parama, Object paramObject)
  {
    paramView.setTag(paramObject);
    a locala = parama;
    if (parama == null) {
      locala = this.j;
    }
    c(paramj, paramView, locala, paramObject);
  }
  
  final void a(Runnable paramRunnable)
  {
    synchronized (this.e)
    {
      this.e.add(paramRunnable);
      this.g.post(ai.a(this));
      return;
    }
  }
  
  public final void b()
  {
    
    synchronized (this.e)
    {
      Iterator localIterator = this.e.iterator();
      if (localIterator.hasNext()) {
        ((Runnable)localIterator.next()).run();
      }
    }
    this.e.clear();
  }
  
  public final void b(j paramj)
  {
    this.h.b(paramj.e);
    this.f.remove(paramj.e);
  }
  
  public final void b(j paramj, View paramView, a parama)
  {
    b(paramj, paramView, parama, paramj.e);
  }
  
  public final void b(j paramj, View paramView, a parama, Object paramObject)
  {
    paramView.setTag(paramObject);
    if (parama == null) {
      parama = this.j;
    }
    while (!d(paramj))
    {
      parama.a(paramView, null, paramj);
      return;
    }
    paramObject = paramView.getTag();
    Bitmap localBitmap = c(paramj);
    if (localBitmap == null)
    {
      localBitmap = a(paramj, false);
      l locall = paramj.f();
      if ((localBitmap == null) && (locall != null) && (!locall.a()))
      {
        this.d.a(locall, aj.a(this, locall, paramj, paramObject, paramView, parama));
        parama.a(paramView);
        return;
      }
      parama.a(paramView, localBitmap, paramj);
      return;
    }
    parama.a(paramView, localBitmap, paramj);
  }
  
  public final int c()
  {
    if (this.i == 0) {
      this.i = ((int)(88.0F * aoa.a().a));
    }
    return this.i;
  }
  
  public static abstract interface a
  {
    public abstract int a();
    
    public abstract void a(View paramView);
    
    public abstract void a(View paramView, Bitmap paramBitmap, j paramj);
  }
  
  final class b
    implements ag.a
  {
    private b() {}
    
    public final int a()
    {
      return ag.this.c();
    }
    
    public final void a(View paramView)
    {
      if ((paramView instanceof ImageView)) {
        ((ImageView)paramView).setImageDrawable(new ColorDrawable(-7829368));
      }
    }
    
    public final void a(View paramView, Bitmap paramBitmap, j paramj)
    {
      if ((paramBitmap != null) && ((paramView instanceof ImageView))) {
        ((ImageView)paramView).setImageBitmap(paramBitmap);
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */