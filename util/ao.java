package com.whatsapp.util;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.whatsapp.MediaData;
import com.whatsapp.oz;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import java.io.File;
import java.util.Iterator;
import java.util.Stack;

public final class ao
{
  final c a = new c((byte)0);
  Handler b = new Handler(Looper.getMainLooper());
  private d c;
  private final oz d;
  
  public ao(oz paramoz)
  {
    this.d = paramoz;
  }
  
  public static int a(j paramj, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and F\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:296)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  public final void a(j arg1, View paramView, ag.a parama, a parama1, Object paramObject)
  {
    Object localObject1;
    int i;
    for (;;)
    {
      try
      {
        localObject1 = this.a.a;
        if (paramView == null) {
          break;
        }
        try
        {
          localObject2 = this.a;
          i = 0;
          if (i >= ((c)localObject2).a.size()) {
            break;
          }
          if (((b)((c)localObject2).a.get(i)).b == paramView)
          {
            ((c)localObject2).a.remove(i);
            continue;
            ??? = finally;
          }
        }
        finally {}
        i += 1;
      }
      finally {}
    }
    Object localObject2 = this.a.a.iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (((b)((Iterator)localObject2).next()).a.e.equals(???.e))
      {
        i = 1;
        if (i == 0) {
          break label162;
        }
      }
    }
    for (;;)
    {
      return;
      i = 0;
      break;
      label162:
      localObject1 = ???.b();
      if ((localObject1 == null) || (((MediaData)localObject1).file == null) || (!((MediaData)localObject1).file.exists())) {
        continue;
      }
      paramView = new b(???, paramView, parama, parama1, paramObject);
      synchronized (this.a.a)
      {
        this.a.a.push(paramView);
        this.a.a.notifyAll();
        if (this.c != null) {
          continue;
        }
        this.c = new d(this.d);
        this.c.setPriority(4);
        this.c.start();
      }
    }
  }
  
  public static final class a
  {
    final ag a;
    final j b;
    final Object c;
    final View d;
    final ag.a e;
    
    a(ag paramag, j paramj, Object paramObject, View paramView, ag.a parama)
    {
      this.a = paramag;
      this.b = paramj;
      this.c = paramObject;
      this.d = paramView;
      this.e = parama;
    }
  }
  
  final class b
  {
    final j a;
    final View b;
    final ag.a c;
    final ao.a d;
    final Object e;
    
    b(j paramj, View paramView, ag.a parama, ao.a parama1, Object paramObject)
    {
      this.a = paramj;
      this.b = paramView;
      this.c = parama;
      this.d = parama1;
      this.e = paramObject;
    }
  }
  
  final class c
  {
    final Stack<ao.b> a = new Stack();
    
    private c() {}
  }
  
  final class d
    extends Thread
  {
    private final oz b;
    
    d(oz paramoz)
    {
      this.b = paramoz;
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 15	com/whatsapp/util/ao$d:a	Lcom/whatsapp/util/ao;
      //   4: getfield 82	com/whatsapp/util/ao:a	Lcom/whatsapp/util/ao$c;
      //   7: getfield 87	com/whatsapp/util/ao$c:a	Ljava/util/Stack;
      //   10: astore_3
      //   11: aload_3
      //   12: monitorenter
      //   13: aload_0
      //   14: getfield 15	com/whatsapp/util/ao$d:a	Lcom/whatsapp/util/ao;
      //   17: getfield 82	com/whatsapp/util/ao:a	Lcom/whatsapp/util/ao$c;
      //   20: getfield 87	com/whatsapp/util/ao$c:a	Ljava/util/Stack;
      //   23: invokevirtual 93	java/util/Stack:size	()I
      //   26: ifne +28 -> 54
      //   29: aload_0
      //   30: getfield 15	com/whatsapp/util/ao$d:a	Lcom/whatsapp/util/ao;
      //   33: getfield 82	com/whatsapp/util/ao:a	Lcom/whatsapp/util/ao$c;
      //   36: getfield 87	com/whatsapp/util/ao$c:a	Ljava/util/Stack;
      //   39: invokevirtual 96	java/lang/Object:wait	()V
      //   42: goto -29 -> 13
      //   45: astore 4
      //   47: aload_3
      //   48: monitorexit
      //   49: aload 4
      //   51: athrow
      //   52: astore_3
      //   53: return
      //   54: aload_0
      //   55: getfield 15	com/whatsapp/util/ao$d:a	Lcom/whatsapp/util/ao;
      //   58: getfield 82	com/whatsapp/util/ao:a	Lcom/whatsapp/util/ao$c;
      //   61: getfield 87	com/whatsapp/util/ao$c:a	Ljava/util/Stack;
      //   64: invokevirtual 99	java/util/Stack:pop	()Ljava/lang/Object;
      //   67: checkcast 24	com/whatsapp/util/ao$b
      //   70: astore 8
      //   72: aload_3
      //   73: monitorexit
      //   74: invokestatic 105	a/a/a/a/d:n	()Z
      //   77: ifeq +12 -> 89
      //   80: ldc2_w 106
      //   83: invokestatic 111	java/lang/Thread:sleep	(J)V
      //   86: goto -12 -> 74
      //   89: aconst_null
      //   90: astore 5
      //   92: aconst_null
      //   93: astore 6
      //   95: aconst_null
      //   96: astore 7
      //   98: aconst_null
      //   99: astore 4
      //   101: aload 8
      //   103: getfield 113	com/whatsapp/util/ao$b:b	Landroid/view/View;
      //   106: ifnull +25 -> 131
      //   109: aload 4
      //   111: astore_3
      //   112: aload 8
      //   114: getfield 115	com/whatsapp/util/ao$b:e	Ljava/lang/Object;
      //   117: aload 8
      //   119: getfield 113	com/whatsapp/util/ao$b:b	Landroid/view/View;
      //   122: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
      //   125: invokevirtual 63	java/lang/Object:equals	(Ljava/lang/Object;)Z
      //   128: ifeq +277 -> 405
      //   131: aload 8
      //   133: getfield 117	com/whatsapp/util/ao$b:a	Lcom/whatsapp/protocol/j;
      //   136: invokevirtual 122	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
      //   139: astore 9
      //   141: aload 4
      //   143: astore_3
      //   144: aload 9
      //   146: ifnull +259 -> 405
      //   149: aload 4
      //   151: astore_3
      //   152: aload 9
      //   154: getfield 128	com/whatsapp/MediaData:file	Ljava/io/File;
      //   157: ifnull +248 -> 405
      //   160: aload 4
      //   162: astore_3
      //   163: aload 9
      //   165: getfield 128	com/whatsapp/MediaData:file	Ljava/io/File;
      //   168: invokevirtual 133	java/io/File:exists	()Z
      //   171: ifeq +234 -> 405
      //   174: aload 8
      //   176: getfield 117	com/whatsapp/util/ao$b:a	Lcom/whatsapp/protocol/j;
      //   179: getfield 137	com/whatsapp/protocol/j:s	B
      //   182: iconst_1
      //   183: if_icmpne +318 -> 501
      //   186: new 139	android/graphics/BitmapFactory$Options
      //   189: dup
      //   190: invokespecial 140	android/graphics/BitmapFactory$Options:<init>	()V
      //   193: astore_3
      //   194: aload_3
      //   195: iconst_1
      //   196: putfield 144	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
      //   199: aload 9
      //   201: getfield 128	com/whatsapp/MediaData:file	Ljava/io/File;
      //   204: invokevirtual 148	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   207: aload_3
      //   208: invokestatic 154	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   211: pop
      //   212: aload 8
      //   214: getfield 156	com/whatsapp/util/ao$b:c	Lcom/whatsapp/util/ag$a;
      //   217: invokeinterface 158 1 0
      //   222: i2f
      //   223: invokestatic 163	com/whatsapp/aoa:a	()Lcom/whatsapp/aoa;
      //   226: getfield 166	com/whatsapp/aoa:a	F
      //   229: fdiv
      //   230: f2i
      //   231: istore_2
      //   232: aload_3
      //   233: iconst_1
      //   234: putfield 170	android/graphics/BitmapFactory$Options:inSampleSize	I
      //   237: aload_3
      //   238: getfield 173	android/graphics/BitmapFactory$Options:outWidth	I
      //   241: istore_1
      //   242: iload_1
      //   243: iconst_2
      //   244: idiv
      //   245: iload_2
      //   246: if_icmplt +20 -> 266
      //   249: iload_1
      //   250: iconst_2
      //   251: idiv
      //   252: istore_1
      //   253: aload_3
      //   254: aload_3
      //   255: getfield 170	android/graphics/BitmapFactory$Options:inSampleSize	I
      //   258: iconst_1
      //   259: ishl
      //   260: putfield 170	android/graphics/BitmapFactory$Options:inSampleSize	I
      //   263: goto -21 -> 242
      //   266: aload_3
      //   267: iconst_0
      //   268: putfield 144	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
      //   271: aload_3
      //   272: iconst_1
      //   273: putfield 176	android/graphics/BitmapFactory$Options:inInputShareable	Z
      //   276: aload_3
      //   277: iconst_1
      //   278: putfield 179	android/graphics/BitmapFactory$Options:inPurgeable	Z
      //   281: aload 9
      //   283: getfield 182	com/whatsapp/MediaData:height	I
      //   286: ifne +35 -> 321
      //   289: aload 9
      //   291: getfield 185	com/whatsapp/MediaData:width	I
      //   294: ifne +27 -> 321
      //   297: aload_3
      //   298: getfield 188	android/graphics/BitmapFactory$Options:outHeight	I
      //   301: ifeq +20 -> 321
      //   304: aload_3
      //   305: getfield 173	android/graphics/BitmapFactory$Options:outWidth	I
      //   308: ifeq +13 -> 321
      //   311: aload 9
      //   313: getfield 128	com/whatsapp/MediaData:file	Ljava/io/File;
      //   316: aload 9
      //   318: invokestatic 193	com/whatsapp/util/MediaFileUtils:b	(Ljava/io/File;Lcom/whatsapp/MediaData;)V
      //   321: aload 9
      //   323: getfield 128	com/whatsapp/MediaData:file	Ljava/io/File;
      //   326: invokestatic 196	a/a/a/a/d:b	(Ljava/io/File;)[B
      //   329: astore 4
      //   331: aload 4
      //   333: iconst_0
      //   334: aload 4
      //   336: arraylength
      //   337: aload_3
      //   338: invokestatic 200	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   341: astore_3
      //   342: aload_3
      //   343: astore 4
      //   345: aload_3
      //   346: ifnull +56 -> 402
      //   349: aload 9
      //   351: getfield 128	com/whatsapp/MediaData:file	Ljava/io/File;
      //   354: invokevirtual 148	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   357: invokestatic 203	com/whatsapp/util/MediaFileUtils:c	(Ljava/lang/String;)I
      //   360: invokestatic 206	com/whatsapp/util/MediaFileUtils:a	(I)Landroid/graphics/Matrix;
      //   363: astore 5
      //   365: aload_3
      //   366: astore 4
      //   368: aload 5
      //   370: ifnull +32 -> 402
      //   373: aload_3
      //   374: iconst_0
      //   375: iconst_0
      //   376: aload_3
      //   377: invokevirtual 211	android/graphics/Bitmap:getWidth	()I
      //   380: aload_3
      //   381: invokevirtual 214	android/graphics/Bitmap:getHeight	()I
      //   384: aload 5
      //   386: iconst_1
      //   387: invokestatic 218	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
      //   390: astore 4
      //   392: aload_3
      //   393: aload 4
      //   395: if_acmpeq +7 -> 402
      //   398: aload_3
      //   399: invokevirtual 221	android/graphics/Bitmap:recycle	()V
      //   402: aload 4
      //   404: astore_3
      //   405: aload_3
      //   406: ifnull +51 -> 457
      //   409: aload 8
      //   411: getfield 113	com/whatsapp/util/ao$b:b	Landroid/view/View;
      //   414: ifnull +22 -> 436
      //   417: aload 8
      //   419: getfield 115	com/whatsapp/util/ao$b:e	Ljava/lang/Object;
      //   422: aload 8
      //   424: getfield 113	com/whatsapp/util/ao$b:b	Landroid/view/View;
      //   427: invokevirtual 57	android/view/View:getTag	()Ljava/lang/Object;
      //   430: invokevirtual 63	java/lang/Object:equals	(Ljava/lang/Object;)Z
      //   433: ifeq +322 -> 755
      //   436: aload_0
      //   437: getfield 15	com/whatsapp/util/ao$d:a	Lcom/whatsapp/util/ao;
      //   440: getfield 224	com/whatsapp/util/ao:b	Landroid/os/Handler;
      //   443: new 226	com/whatsapp/util/ap
      //   446: dup
      //   447: aload 8
      //   449: aload_3
      //   450: invokespecial 228	com/whatsapp/util/ap:<init>	(Lcom/whatsapp/util/ao$b;Landroid/graphics/Bitmap;)V
      //   453: invokevirtual 234	android/os/Handler:post	(Ljava/lang/Runnable;)Z
      //   456: pop
      //   457: invokestatic 237	java/lang/Thread:interrupted	()Z
      //   460: ifeq -460 -> 0
      //   463: return
      //   464: ldc -17
      //   466: aload 4
      //   468: invokestatic 244	com/whatsapp/util/Log:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   471: goto -66 -> 405
      //   474: ldc -10
      //   476: aload 4
      //   478: invokestatic 244	com/whatsapp/util/Log:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   481: goto -76 -> 405
      //   484: invokestatic 250	com/whatsapp/memory/a:b	()Z
      //   487: ifne +11 -> 498
      //   490: ldc -4
      //   492: invokestatic 255	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
      //   495: goto -90 -> 405
      //   498: aload 4
      //   500: athrow
      //   501: aload 8
      //   503: getfield 117	com/whatsapp/util/ao$b:a	Lcom/whatsapp/protocol/j;
      //   506: getfield 137	com/whatsapp/protocol/j:s	B
      //   509: iconst_3
      //   510: if_icmpeq +16 -> 526
      //   513: aload 8
      //   515: getfield 117	com/whatsapp/util/ao$b:a	Lcom/whatsapp/protocol/j;
      //   518: getfield 137	com/whatsapp/protocol/j:s	B
      //   521: bipush 13
      //   523: if_icmpne +159 -> 682
      //   526: aload 9
      //   528: getfield 128	com/whatsapp/MediaData:file	Ljava/io/File;
      //   531: invokevirtual 148	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   534: invokestatic 259	com/whatsapp/util/MediaFileUtils:g	(Ljava/lang/String;)Landroid/graphics/Bitmap;
      //   537: astore_3
      //   538: aload_3
      //   539: ifnull +266 -> 805
      //   542: aload 8
      //   544: getfield 117	com/whatsapp/util/ao$b:a	Lcom/whatsapp/protocol/j;
      //   547: getfield 262	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
      //   550: getfield 266	com/whatsapp/protocol/j$b:b	Z
      //   553: ifeq +252 -> 805
      //   556: aload 9
      //   558: getfield 269	com/whatsapp/MediaData:transferred	Z
      //   561: ifne +244 -> 805
      //   564: aload 9
      //   566: getfield 272	com/whatsapp/MediaData:transcoded	Z
      //   569: ifne +236 -> 805
      //   572: aload 9
      //   574: getfield 276	com/whatsapp/MediaData:doodleId	Ljava/lang/String;
      //   577: ifnull +228 -> 805
      //   580: aload_0
      //   581: getfield 20	com/whatsapp/util/ao$d:b	Lcom/whatsapp/oz;
      //   584: aload 9
      //   586: getfield 276	com/whatsapp/MediaData:doodleId	Ljava/lang/String;
      //   589: invokestatic 279	com/whatsapp/util/MediaFileUtils:a	(Lcom/whatsapp/oz;Ljava/lang/String;)Ljava/io/File;
      //   592: astore 6
      //   594: aload_3
      //   595: astore 4
      //   597: aload 6
      //   599: invokevirtual 133	java/io/File:exists	()Z
      //   602: ifeq +230 -> 832
      //   605: new 281	com/whatsapp/doodle/a/b
      //   608: dup
      //   609: invokespecial 282	com/whatsapp/doodle/a/b:<init>	()V
      //   612: astore 5
      //   614: aload 5
      //   616: aload 6
      //   618: invokestatic 287	com/whatsapp/u:a	()Landroid/content/Context;
      //   621: invokevirtual 290	com/whatsapp/doodle/a/b:a	(Ljava/io/File;Landroid/content/Context;)V
      //   624: aload_3
      //   625: invokevirtual 293	android/graphics/Bitmap:isMutable	()Z
      //   628: ifne +174 -> 802
      //   631: aload_3
      //   632: getstatic 299	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
      //   635: iconst_1
      //   636: invokevirtual 303	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
      //   639: astore 4
      //   641: aload 4
      //   643: astore_3
      //   644: aload 5
      //   646: aload_3
      //   647: iconst_0
      //   648: invokevirtual 306	com/whatsapp/doodle/a/b:a	(Landroid/graphics/Bitmap;I)V
      //   651: goto -246 -> 405
      //   654: astore 5
      //   656: aload_3
      //   657: astore 4
      //   659: aload 5
      //   661: astore_3
      //   662: aload_3
      //   663: astore 5
      //   665: aload 4
      //   667: astore_3
      //   668: ldc_w 308
      //   671: aload 5
      //   673: invokestatic 310	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   676: aload_3
      //   677: astore 4
      //   679: goto +153 -> 832
      //   682: aload 4
      //   684: astore_3
      //   685: aload 8
      //   687: getfield 117	com/whatsapp/util/ao$b:a	Lcom/whatsapp/protocol/j;
      //   690: getfield 137	com/whatsapp/protocol/j:s	B
      //   693: bipush 9
      //   695: if_icmpne -290 -> 405
      //   698: aload 4
      //   700: astore_3
      //   701: ldc_w 312
      //   704: aload 8
      //   706: getfield 117	com/whatsapp/util/ao$b:a	Lcom/whatsapp/protocol/j;
      //   709: getfield 315	com/whatsapp/protocol/j:r	Ljava/lang/String;
      //   712: invokevirtual 318	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   715: ifeq -310 -> 405
      //   718: aload 9
      //   720: getfield 128	com/whatsapp/MediaData:file	Ljava/io/File;
      //   723: invokevirtual 148	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   726: aload 8
      //   728: getfield 156	com/whatsapp/util/ao$b:c	Lcom/whatsapp/util/ag$a;
      //   731: invokeinterface 158 1 0
      //   736: aload 8
      //   738: getfield 156	com/whatsapp/util/ao$b:c	Lcom/whatsapp/util/ag$a;
      //   741: invokeinterface 158 1 0
      //   746: iconst_3
      //   747: idiv
      //   748: invokestatic 323	com/whatsapp/util/p:a	(Ljava/lang/String;II)Landroid/graphics/Bitmap;
      //   751: astore_3
      //   752: goto -347 -> 405
      //   755: aload_3
      //   756: invokevirtual 221	android/graphics/Bitmap:recycle	()V
      //   759: goto -302 -> 457
      //   762: astore 4
      //   764: aload 4
      //   766: astore 5
      //   768: goto -100 -> 668
      //   771: astore 5
      //   773: aload_3
      //   774: astore 4
      //   776: aload 5
      //   778: astore_3
      //   779: goto -117 -> 662
      //   782: astore 4
      //   784: goto -20 -> 764
      //   787: astore 4
      //   789: goto -305 -> 484
      //   792: astore 4
      //   794: goto -320 -> 474
      //   797: astore 4
      //   799: goto -335 -> 464
      //   802: goto -158 -> 644
      //   805: goto -400 -> 405
      //   808: astore 4
      //   810: aload 5
      //   812: astore_3
      //   813: goto -349 -> 464
      //   816: astore 4
      //   818: aload 6
      //   820: astore_3
      //   821: goto -347 -> 474
      //   824: astore 4
      //   826: aload 7
      //   828: astore_3
      //   829: goto -345 -> 484
      //   832: aload 4
      //   834: astore_3
      //   835: goto -430 -> 405
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	838	0	this	d
      //   241	12	1	i	int
      //   231	16	2	j	int
      //   10	38	3	localStack	Stack
      //   52	21	3	localInterruptedException	InterruptedException
      //   111	724	3	localObject1	Object
      //   45	5	4	localObject2	Object
      //   99	600	4	localObject3	Object
      //   762	3	4	localIOException1	java.io.IOException
      //   774	1	4	localObject4	Object
      //   782	1	4	localIOException2	java.io.IOException
      //   787	1	4	localOutOfMemoryError1	OutOfMemoryError
      //   792	1	4	localNoClassDefFoundError1	NoClassDefFoundError
      //   797	1	4	localIOException3	java.io.IOException
      //   808	1	4	localIOException4	java.io.IOException
      //   816	1	4	localNoClassDefFoundError2	NoClassDefFoundError
      //   824	9	4	localOutOfMemoryError2	OutOfMemoryError
      //   90	555	5	localObject5	Object
      //   654	6	5	localJSONException1	org.json.JSONException
      //   663	104	5	localObject6	Object
      //   771	40	5	localJSONException2	org.json.JSONException
      //   93	726	6	localFile	File
      //   96	731	7	localObject7	Object
      //   70	667	8	localb	ao.b
      //   139	580	9	localMediaData	MediaData
      // Exception table:
      //   from	to	target	type
      //   13	42	45	finally
      //   47	49	45	finally
      //   54	74	45	finally
      //   0	13	52	java/lang/InterruptedException
      //   49	52	52	java/lang/InterruptedException
      //   74	86	52	java/lang/InterruptedException
      //   101	109	52	java/lang/InterruptedException
      //   112	131	52	java/lang/InterruptedException
      //   131	141	52	java/lang/InterruptedException
      //   152	160	52	java/lang/InterruptedException
      //   163	242	52	java/lang/InterruptedException
      //   242	263	52	java/lang/InterruptedException
      //   266	321	52	java/lang/InterruptedException
      //   321	342	52	java/lang/InterruptedException
      //   349	365	52	java/lang/InterruptedException
      //   373	392	52	java/lang/InterruptedException
      //   398	402	52	java/lang/InterruptedException
      //   409	436	52	java/lang/InterruptedException
      //   436	457	52	java/lang/InterruptedException
      //   457	463	52	java/lang/InterruptedException
      //   464	471	52	java/lang/InterruptedException
      //   474	481	52	java/lang/InterruptedException
      //   484	495	52	java/lang/InterruptedException
      //   498	501	52	java/lang/InterruptedException
      //   501	526	52	java/lang/InterruptedException
      //   526	538	52	java/lang/InterruptedException
      //   542	594	52	java/lang/InterruptedException
      //   597	614	52	java/lang/InterruptedException
      //   614	641	52	java/lang/InterruptedException
      //   644	651	52	java/lang/InterruptedException
      //   668	676	52	java/lang/InterruptedException
      //   685	698	52	java/lang/InterruptedException
      //   701	752	52	java/lang/InterruptedException
      //   755	759	52	java/lang/InterruptedException
      //   644	651	654	org/json/JSONException
      //   614	641	762	java/io/IOException
      //   614	641	771	org/json/JSONException
      //   644	651	782	java/io/IOException
      //   349	365	787	java/lang/OutOfMemoryError
      //   373	392	787	java/lang/OutOfMemoryError
      //   398	402	787	java/lang/OutOfMemoryError
      //   349	365	792	java/lang/NoClassDefFoundError
      //   373	392	792	java/lang/NoClassDefFoundError
      //   398	402	792	java/lang/NoClassDefFoundError
      //   349	365	797	java/io/IOException
      //   373	392	797	java/io/IOException
      //   398	402	797	java/io/IOException
      //   321	342	808	java/io/IOException
      //   321	342	816	java/lang/NoClassDefFoundError
      //   321	342	824	java/lang/OutOfMemoryError
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */