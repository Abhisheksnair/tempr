package com.whatsapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import com.whatsapp.util.a.c;
import com.whatsapp.util.bk;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;

@TargetApi(16)
public final class aqg
{
  private static final float[] c = { 0.25F, 0.25F, 0.25F, 0.25F, 0.75F, 0.75F, 0.75F, 0.75F };
  private static final float[] d = { 0.25F, 0.3F, 0.75F, 0.8F, 0.25F, 0.3F, 0.75F, 0.8F };
  private static final int[] e = { 14557250, 14687296, 3292341, 3292341, 1423676, 1423676, 15990016, 15990016 };
  private static final int[] f = { 4408575, 4408575, 10296875, 10296875, 4696576, 4696576, 3014647, 3014647 };
  final c a;
  final atv b;
  private final vv g;
  
  aqg(c paramc, vv paramvv, atv paramatv)
  {
    this.a = paramc;
    this.g = paramvv;
    this.b = paramatv;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return Math.max(Math.max(Math.abs(Color.red(paramInt1) - Color.red(paramInt2)), Math.abs(Color.green(paramInt1) - Color.green(paramInt2))), Color.blue(paramInt1) - Color.blue(paramInt2));
  }
  
  private static int a(int paramInt, int[] paramArrayOfInt)
  {
    return Math.max(Math.max(Math.abs(Color.red(paramInt) - paramArrayOfInt[0]), Math.abs(Color.green(paramInt) - paramArrayOfInt[1])), Color.blue(paramInt) - paramArrayOfInt[2]);
  }
  
  private File a(String paramString)
  {
    byte[] arrayOfByte = null;
    Object localObject1 = null;
    try
    {
      File localFile = this.g.c.a(paramString);
      localFileOutputStream = new FileOutputStream(localFile);
      paramString = arrayOfByte;
      int i;
      if (localFileOutputStream == null) {
        break label133;
      }
    }
    finally
    {
      try
      {
        localObject1 = u.a().getResources().openRawResource(2131165191);
        paramString = (String)localObject1;
        arrayOfByte = new byte[' '];
        paramString = (String)localObject1;
        for (i = ((InputStream)localObject1).read(arrayOfByte, 0, 8192); i >= 0; i = ((InputStream)localObject1).read(arrayOfByte, 0, 8192))
        {
          paramString = (String)localObject1;
          localFileOutputStream.write(arrayOfByte, 0, i);
          paramString = (String)localObject1;
        }
        localFileOutputStream.close();
        if (localObject1 != null) {
          ((InputStream)localObject1).close();
        }
        return localFile;
      }
      finally
      {
        FileOutputStream localFileOutputStream;
        for (;;) {}
      }
      localObject3 = finally;
      localFileOutputStream = null;
      paramString = (String)localObject1;
      localObject1 = localObject3;
    }
    localFileOutputStream.close();
    label133:
    if (paramString != null) {
      paramString.close();
    }
    throw ((Throwable)localObject1);
  }
  
  static Integer a(int paramInt, Set<Integer> paramSet)
  {
    Object localObject = Integer.valueOf(paramInt);
    Integer localInteger;
    do
    {
      switch (((Integer)localObject).intValue())
      {
      default: 
        localInteger = null;
      }
      while (localInteger == null)
      {
        return null;
        localInteger = Integer.valueOf(2);
        continue;
        localInteger = Integer.valueOf(3);
        continue;
        localInteger = Integer.valueOf(4);
        continue;
        localInteger = Integer.valueOf(1);
      }
      if (localInteger.intValue() == paramInt) {
        return null;
      }
      localObject = localInteger;
    } while (paramSet.contains(localInteger));
    return localInteger;
  }
  
  private static String a(int paramInt)
  {
    return Integer.toHexString(paramInt) + " (" + Color.red(paramInt) + "," + Color.green(paramInt) + "," + Color.blue(paramInt) + ")";
  }
  
  private static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "COLOR_NOT_FOUND_id=" + paramInt;
    case 19: 
      return "COLOR_FormatYUV420Planar";
    case 20: 
      return "COLOR_FormatYUV420PackedPlanar";
    case 21: 
      return "COLOR_FormatYUV420SemiPlanar";
    case 39: 
      return "COLOR_FormatYUV420PackedSemiPlanar";
    }
    return "COLOR_TI_FormatYUV420PackedSemiPlanar";
  }
  
  /* Error */
  final a a(com.whatsapp.fieldstats.events.i parami, aqh paramaqh)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 29
    //   3: invokestatic 204	com/whatsapp/aqe:e	()Landroid/media/MediaCodecInfo;
    //   6: astore 31
    //   8: aload 31
    //   10: ifnonnull +29 -> 39
    //   13: ldc -50
    //   15: invokestatic 211	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   18: aload_1
    //   19: ldc -43
    //   21: putfield 219	com/whatsapp/fieldstats/events/i:n	Ljava/lang/String;
    //   24: new 8	com/whatsapp/aqg$a
    //   27: dup
    //   28: getstatic 222	com/whatsapp/aqg$b:d	Lcom/whatsapp/aqg$b;
    //   31: aconst_null
    //   32: iconst_0
    //   33: invokespecial 225	com/whatsapp/aqg$a:<init>	(Lcom/whatsapp/aqg$b;Ljava/io/File;B)V
    //   36: astore_1
    //   37: aload_1
    //   38: areturn
    //   39: aload_1
    //   40: aload 31
    //   42: invokevirtual 230	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   45: putfield 232	com/whatsapp/fieldstats/events/i:a	Ljava/lang/String;
    //   48: aload_0
    //   49: ldc -22
    //   51: invokespecial 235	com/whatsapp/aqg:a	(Ljava/lang/String;)Ljava/io/File;
    //   54: astore 28
    //   56: aload 28
    //   58: astore 29
    //   60: aload 29
    //   62: astore 30
    //   64: aload 29
    //   66: invokevirtual 241	java/io/File:exists	()Z
    //   69: ifne +64 -> 133
    //   72: aload 29
    //   74: astore 30
    //   76: aload_1
    //   77: ldc -13
    //   79: putfield 219	com/whatsapp/fieldstats/events/i:n	Ljava/lang/String;
    //   82: aload 29
    //   84: astore 30
    //   86: ldc -11
    //   88: invokestatic 211	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   91: aload 29
    //   93: astore 30
    //   95: new 8	com/whatsapp/aqg$a
    //   98: dup
    //   99: getstatic 222	com/whatsapp/aqg$b:d	Lcom/whatsapp/aqg$b;
    //   102: aconst_null
    //   103: iconst_0
    //   104: invokespecial 225	com/whatsapp/aqg$a:<init>	(Lcom/whatsapp/aqg$b;Ljava/io/File;B)V
    //   107: astore_2
    //   108: aload_2
    //   109: astore_1
    //   110: aload 29
    //   112: ifnull -75 -> 37
    //   115: aload_2
    //   116: astore_1
    //   117: aload 29
    //   119: invokevirtual 241	java/io/File:exists	()Z
    //   122: ifeq -85 -> 37
    //   125: aload 29
    //   127: invokevirtual 248	java/io/File:delete	()Z
    //   130: pop
    //   131: aload_2
    //   132: areturn
    //   133: aload 29
    //   135: astore 30
    //   137: new 250	com/whatsapp/util/MediaFileUtils$f
    //   140: dup
    //   141: aload 29
    //   143: invokespecial 251	com/whatsapp/util/MediaFileUtils$f:<init>	(Ljava/io/File;)V
    //   146: astore 28
    //   148: aload 29
    //   150: astore 30
    //   152: aload 28
    //   154: getfield 254	com/whatsapp/util/MediaFileUtils$f:a	I
    //   157: istore 9
    //   159: aload 29
    //   161: astore 30
    //   163: aload 28
    //   165: getfield 256	com/whatsapp/util/MediaFileUtils$f:b	I
    //   168: istore 10
    //   170: aload 29
    //   172: astore 30
    //   174: aload 31
    //   176: invokestatic 259	com/whatsapp/aqe:a	(Landroid/media/MediaCodecInfo;)I
    //   179: istore 11
    //   181: aload 29
    //   183: astore 30
    //   185: aload 31
    //   187: invokevirtual 230	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   190: iload 11
    //   192: iload 9
    //   194: iload 10
    //   196: aload 31
    //   198: invokevirtual 230	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   201: invokestatic 262	com/whatsapp/aqe:b	(Ljava/lang/String;)I
    //   204: iconst_0
    //   205: iconst_0
    //   206: aload_2
    //   207: invokestatic 265	com/whatsapp/aqe:a	(Ljava/lang/String;IIIIIILcom/whatsapp/aqh;)Lcom/whatsapp/aqe$a;
    //   210: astore 32
    //   212: aload 29
    //   214: astore 30
    //   216: aload_1
    //   217: aload 32
    //   219: getfield 268	com/whatsapp/aqe$a:a	I
    //   222: invokestatic 270	com/whatsapp/aqg:b	(I)Ljava/lang/String;
    //   225: putfield 272	com/whatsapp/fieldstats/events/i:b	Ljava/lang/String;
    //   228: aload 29
    //   230: astore 30
    //   232: aload_1
    //   233: aload 32
    //   235: getfield 275	com/whatsapp/aqe$a:k	I
    //   238: i2l
    //   239: invokestatic 280	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   242: putfield 283	com/whatsapp/fieldstats/events/i:c	Ljava/lang/Long;
    //   245: aload 29
    //   247: astore 30
    //   249: aload_0
    //   250: getfield 57	com/whatsapp/aqg:g	Lcom/whatsapp/vv;
    //   253: invokevirtual 286	com/whatsapp/vv:b	()Ljava/io/File;
    //   256: astore 28
    //   258: aload 29
    //   260: astore 30
    //   262: new 201	com/whatsapp/aqe
    //   265: dup
    //   266: aload_0
    //   267: getfield 55	com/whatsapp/aqg:a	Lcom/whatsapp/util/a/c;
    //   270: aload 29
    //   272: aload 28
    //   274: lconst_0
    //   275: ldc2_w 287
    //   278: invokespecial 291	com/whatsapp/aqe:<init>	(Lcom/whatsapp/util/a/c;Ljava/io/File;Ljava/io/File;JJ)V
    //   281: astore 34
    //   283: aload 29
    //   285: astore 30
    //   287: aload 34
    //   289: aload_2
    //   290: putfield 294	com/whatsapp/aqe:g	Lcom/whatsapp/aqh;
    //   293: aload 29
    //   295: astore 30
    //   297: aload 34
    //   299: invokevirtual 296	com/whatsapp/aqe:d	()V
    //   302: aload 29
    //   304: astore 30
    //   306: aload 28
    //   308: invokevirtual 241	java/io/File:exists	()Z
    //   311: ifne +55 -> 366
    //   314: aload 29
    //   316: astore 30
    //   318: ldc_w 298
    //   321: invokestatic 211	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   324: aload 29
    //   326: astore 30
    //   328: new 8	com/whatsapp/aqg$a
    //   331: dup
    //   332: getstatic 222	com/whatsapp/aqg$b:d	Lcom/whatsapp/aqg$b;
    //   335: aconst_null
    //   336: iconst_0
    //   337: invokespecial 225	com/whatsapp/aqg$a:<init>	(Lcom/whatsapp/aqg$b;Ljava/io/File;B)V
    //   340: astore_2
    //   341: aload_2
    //   342: astore_1
    //   343: aload 29
    //   345: ifnull -308 -> 37
    //   348: aload_2
    //   349: astore_1
    //   350: aload 29
    //   352: invokevirtual 241	java/io/File:exists	()Z
    //   355: ifeq -318 -> 37
    //   358: aload 29
    //   360: invokevirtual 248	java/io/File:delete	()Z
    //   363: pop
    //   364: aload_2
    //   365: areturn
    //   366: aload 29
    //   368: astore 30
    //   370: new 300	android/media/MediaMetadataRetriever
    //   373: dup
    //   374: invokespecial 301	android/media/MediaMetadataRetriever:<init>	()V
    //   377: astore_2
    //   378: aload 29
    //   380: astore 30
    //   382: aload_2
    //   383: aload 28
    //   385: invokevirtual 304	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   388: invokevirtual 307	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   391: aload 29
    //   393: astore 30
    //   395: aload_2
    //   396: invokevirtual 311	android/media/MediaMetadataRetriever:getFrameAtTime	()Landroid/graphics/Bitmap;
    //   399: astore 35
    //   401: aload 29
    //   403: astore 30
    //   405: aload_2
    //   406: invokevirtual 314	android/media/MediaMetadataRetriever:release	()V
    //   409: aload 29
    //   411: astore 30
    //   413: new 152	java/lang/StringBuilder
    //   416: dup
    //   417: ldc_w 316
    //   420: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   423: aload 35
    //   425: invokevirtual 321	android/graphics/Bitmap:getHeight	()I
    //   428: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   431: ldc_w 323
    //   434: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload 35
    //   439: invokevirtual 326	android/graphics/Bitmap:getWidth	()I
    //   442: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   445: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 328	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   451: aload 29
    //   453: astore 30
    //   455: new 152	java/lang/StringBuilder
    //   458: dup
    //   459: ldc_w 330
    //   462: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   465: astore 36
    //   467: iconst_0
    //   468: istore 11
    //   470: iconst_0
    //   471: istore 10
    //   473: iconst_0
    //   474: istore 9
    //   476: aload 29
    //   478: astore 30
    //   480: aload_1
    //   481: iconst_0
    //   482: invokestatic 335	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   485: putfield 339	com/whatsapp/fieldstats/events/i:j	Ljava/lang/Boolean;
    //   488: aload 29
    //   490: astore 30
    //   492: aload 34
    //   494: getfield 343	com/whatsapp/aqe:h	Lcom/whatsapp/aqe$a;
    //   497: astore 33
    //   499: aload 33
    //   501: ifnull +1480 -> 1981
    //   504: aload 29
    //   506: astore 30
    //   508: aload_1
    //   509: aload 33
    //   511: getfield 345	com/whatsapp/aqe$a:j	Ljava/lang/String;
    //   514: putfield 347	com/whatsapp/fieldstats/events/i:d	Ljava/lang/String;
    //   517: aload 29
    //   519: astore 30
    //   521: aload_1
    //   522: aload 33
    //   524: getfield 268	com/whatsapp/aqe$a:a	I
    //   527: invokestatic 270	com/whatsapp/aqg:b	(I)Ljava/lang/String;
    //   530: putfield 349	com/whatsapp/fieldstats/events/i:e	Ljava/lang/String;
    //   533: aload 29
    //   535: astore 30
    //   537: aload_1
    //   538: aload 33
    //   540: getfield 275	com/whatsapp/aqe$a:k	I
    //   543: i2l
    //   544: invokestatic 280	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   547: putfield 351	com/whatsapp/fieldstats/events/i:f	Ljava/lang/Long;
    //   550: goto +1431 -> 1981
    //   553: iload 16
    //   555: bipush 8
    //   557: if_icmpge +855 -> 1412
    //   560: aload 29
    //   562: astore 30
    //   564: getstatic 31	com/whatsapp/aqg:c	[F
    //   567: iload 16
    //   569: faload
    //   570: aload 35
    //   572: invokevirtual 326	android/graphics/Bitmap:getWidth	()I
    //   575: i2f
    //   576: fmul
    //   577: f2i
    //   578: istore 23
    //   580: aload 29
    //   582: astore 30
    //   584: getstatic 35	com/whatsapp/aqg:d	[F
    //   587: iload 16
    //   589: faload
    //   590: aload 35
    //   592: invokevirtual 321	android/graphics/Bitmap:getHeight	()I
    //   595: i2f
    //   596: fmul
    //   597: f2i
    //   598: istore 24
    //   600: aload 29
    //   602: astore 30
    //   604: aload 35
    //   606: iload 23
    //   608: iload 24
    //   610: invokevirtual 354	android/graphics/Bitmap:getPixel	(II)I
    //   613: istore 19
    //   615: aload 29
    //   617: astore 30
    //   619: getstatic 42	com/whatsapp/aqg:e	[I
    //   622: iload 16
    //   624: iaload
    //   625: iload 19
    //   627: invokestatic 356	com/whatsapp/aqg:a	(II)I
    //   630: istore 20
    //   632: iload 20
    //   634: iload 12
    //   636: if_icmple +1342 -> 1978
    //   639: iload 20
    //   641: istore 12
    //   643: aload 29
    //   645: astore 30
    //   647: getstatic 48	com/whatsapp/aqg:f	[I
    //   650: iload 16
    //   652: iaload
    //   653: iload 19
    //   655: invokestatic 356	com/whatsapp/aqg:a	(II)I
    //   658: istore 14
    //   660: iload 14
    //   662: iload 13
    //   664: if_icmple +1311 -> 1975
    //   667: iload 14
    //   669: istore 13
    //   671: aload 29
    //   673: astore 30
    //   675: aload 34
    //   677: getfield 360	com/whatsapp/aqe:i	[B
    //   680: ifnull +1290 -> 1970
    //   683: aload 29
    //   685: astore 30
    //   687: aload 34
    //   689: getfield 360	com/whatsapp/aqe:i	[B
    //   692: astore_2
    //   693: aload 29
    //   695: astore 30
    //   697: aload 33
    //   699: getfield 275	com/whatsapp/aqe$a:k	I
    //   702: istore 22
    //   704: aload 29
    //   706: astore 30
    //   708: aload 33
    //   710: getfield 362	com/whatsapp/aqe$a:d	I
    //   713: istore 25
    //   715: aload 29
    //   717: astore 30
    //   719: aload 33
    //   721: getfield 364	com/whatsapp/aqe$a:e	I
    //   724: istore 14
    //   726: aload 29
    //   728: astore 30
    //   730: aload 33
    //   732: getfield 366	com/whatsapp/aqe$a:f	I
    //   735: istore 18
    //   737: aload 29
    //   739: astore 30
    //   741: aload 33
    //   743: getfield 368	com/whatsapp/aqe$a:h	I
    //   746: istore 15
    //   748: iload 25
    //   750: iload 14
    //   752: imul
    //   753: istore 14
    //   755: aload 29
    //   757: astore 30
    //   759: iload 18
    //   761: iload 23
    //   763: iadd
    //   764: iconst_2
    //   765: idiv
    //   766: iconst_1
    //   767: ishl
    //   768: istore 26
    //   770: aload 29
    //   772: astore 30
    //   774: iload 15
    //   776: iload 24
    //   778: iadd
    //   779: iconst_2
    //   780: idiv
    //   781: iconst_1
    //   782: ishl
    //   783: istore 27
    //   785: iload 27
    //   787: iload 25
    //   789: imul
    //   790: iload 26
    //   792: iadd
    //   793: istore 21
    //   795: iload 22
    //   797: iconst_1
    //   798: if_icmpeq +1198 -> 1996
    //   801: iload 22
    //   803: iconst_2
    //   804: if_icmpne +1326 -> 2130
    //   807: goto +1189 -> 1996
    //   810: aload 29
    //   812: astore 30
    //   814: iload 21
    //   816: aload_2
    //   817: arraylength
    //   818: if_icmpge +1286 -> 2104
    //   821: aload 29
    //   823: astore 30
    //   825: iload 14
    //   827: aload_2
    //   828: arraylength
    //   829: if_icmpge +1275 -> 2104
    //   832: aload 29
    //   834: astore 30
    //   836: iload 15
    //   838: aload_2
    //   839: arraylength
    //   840: if_icmplt +1369 -> 2209
    //   843: goto +1261 -> 2104
    //   846: aload_2
    //   847: ifnull +461 -> 1308
    //   850: aload 29
    //   852: astore 30
    //   854: getstatic 42	com/whatsapp/aqg:e	[I
    //   857: iload 16
    //   859: iaload
    //   860: aload_2
    //   861: invokestatic 370	com/whatsapp/aqg:a	(I[I)I
    //   864: istore 15
    //   866: iload 10
    //   868: istore 14
    //   870: iload 15
    //   872: iload 10
    //   874: if_icmple +7 -> 881
    //   877: iload 15
    //   879: istore 14
    //   881: aload 29
    //   883: astore 30
    //   885: getstatic 48	com/whatsapp/aqg:f	[I
    //   888: iload 16
    //   890: iaload
    //   891: aload_2
    //   892: invokestatic 370	com/whatsapp/aqg:a	(I[I)I
    //   895: istore 10
    //   897: iload 10
    //   899: iload 14
    //   901: if_icmple +1063 -> 1964
    //   904: iload 10
    //   906: istore 9
    //   908: goto +1201 -> 2109
    //   911: aload 29
    //   913: astore 30
    //   915: new 152	java/lang/StringBuilder
    //   918: dup
    //   919: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   922: iload 20
    //   924: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   927: astore 37
    //   929: iload 16
    //   931: bipush 7
    //   933: if_icmpeq +418 -> 1351
    //   936: ldc -89
    //   938: astore 31
    //   940: aload 29
    //   942: astore 30
    //   944: aload 36
    //   946: aload 37
    //   948: aload 31
    //   950: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   956: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: pop
    //   960: iload 16
    //   962: iconst_2
    //   963: irem
    //   964: iconst_1
    //   965: if_icmpne +996 -> 1961
    //   968: aload 29
    //   970: astore 30
    //   972: iload 19
    //   974: iload 17
    //   976: invokestatic 356	com/whatsapp/aqg:a	(II)I
    //   979: bipush 24
    //   981: if_icmple +980 -> 1961
    //   984: aload 29
    //   986: astore 30
    //   988: aload_1
    //   989: iconst_1
    //   990: invokestatic 335	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   993: putfield 339	com/whatsapp/fieldstats/events/i:j	Ljava/lang/Boolean;
    //   996: iconst_1
    //   997: istore 11
    //   999: aload 29
    //   1001: astore 30
    //   1003: new 152	java/lang/StringBuilder
    //   1006: dup
    //   1007: ldc_w 372
    //   1010: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1013: iload 23
    //   1015: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1018: ldc_w 323
    //   1021: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1024: iload 24
    //   1026: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1029: ldc_w 374
    //   1032: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: getstatic 42	com/whatsapp/aqg:e	[I
    //   1038: iload 16
    //   1040: iaload
    //   1041: invokestatic 376	com/whatsapp/aqg:a	(I)Ljava/lang/String;
    //   1044: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: ldc_w 378
    //   1050: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: iload 19
    //   1055: invokestatic 376	com/whatsapp/aqg:a	(I)Ljava/lang/String;
    //   1058: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: ldc_w 380
    //   1064: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: astore 31
    //   1069: aload_2
    //   1070: ifnonnull +288 -> 1358
    //   1073: ldc_w 382
    //   1076: astore_2
    //   1077: aload 29
    //   1079: astore 30
    //   1081: aload 31
    //   1083: aload_2
    //   1084: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: ldc_w 384
    //   1090: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1093: iload 20
    //   1095: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1098: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1101: invokestatic 328	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   1104: iload 16
    //   1106: iconst_1
    //   1107: iadd
    //   1108: istore 16
    //   1110: iload 19
    //   1112: istore 17
    //   1114: goto -561 -> 553
    //   1117: iload 14
    //   1119: i2d
    //   1120: ldc2_w 385
    //   1123: iload 18
    //   1125: sipush 128
    //   1128: isub
    //   1129: i2d
    //   1130: dmul
    //   1131: dadd
    //   1132: d2i
    //   1133: istore 21
    //   1135: iload 14
    //   1137: i2d
    //   1138: ldc2_w 387
    //   1141: iload 15
    //   1143: sipush 128
    //   1146: isub
    //   1147: i2d
    //   1148: dmul
    //   1149: dsub
    //   1150: ldc2_w 389
    //   1153: iload 18
    //   1155: sipush 128
    //   1158: isub
    //   1159: i2d
    //   1160: dmul
    //   1161: dsub
    //   1162: d2i
    //   1163: istore 18
    //   1165: iload 14
    //   1167: i2d
    //   1168: ldc2_w 391
    //   1171: iload 15
    //   1173: sipush 128
    //   1176: isub
    //   1177: i2d
    //   1178: dmul
    //   1179: dadd
    //   1180: d2i
    //   1181: istore 14
    //   1183: aload 29
    //   1185: astore 30
    //   1187: iconst_3
    //   1188: newarray <illegal type>
    //   1190: astore_2
    //   1191: aload_2
    //   1192: iconst_0
    //   1193: iload 21
    //   1195: iastore
    //   1196: aload_2
    //   1197: iconst_1
    //   1198: iload 18
    //   1200: iastore
    //   1201: aload_2
    //   1202: iconst_2
    //   1203: iload 14
    //   1205: iastore
    //   1206: goto -360 -> 846
    //   1209: astore_2
    //   1210: aload 29
    //   1212: astore 30
    //   1214: aload_1
    //   1215: new 152	java/lang/StringBuilder
    //   1218: dup
    //   1219: ldc_w 394
    //   1222: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1225: aload_2
    //   1226: invokevirtual 398	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1229: invokevirtual 403	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   1232: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1235: ldc_w 405
    //   1238: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1241: aload_2
    //   1242: invokevirtual 410	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1245: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1251: putfield 219	com/whatsapp/fieldstats/events/i:n	Ljava/lang/String;
    //   1254: aload 29
    //   1256: astore 30
    //   1258: ldc_w 412
    //   1261: aload_2
    //   1262: invokestatic 415	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1265: aload 29
    //   1267: astore 30
    //   1269: new 8	com/whatsapp/aqg$a
    //   1272: dup
    //   1273: getstatic 222	com/whatsapp/aqg$b:d	Lcom/whatsapp/aqg$b;
    //   1276: aload 28
    //   1278: iconst_0
    //   1279: invokespecial 225	com/whatsapp/aqg$a:<init>	(Lcom/whatsapp/aqg$b;Ljava/io/File;B)V
    //   1282: astore_2
    //   1283: aload_2
    //   1284: astore_1
    //   1285: aload 29
    //   1287: ifnull -1250 -> 37
    //   1290: aload_2
    //   1291: astore_1
    //   1292: aload 29
    //   1294: invokevirtual 241	java/io/File:exists	()Z
    //   1297: ifeq -1260 -> 37
    //   1300: aload 29
    //   1302: invokevirtual 248	java/io/File:delete	()Z
    //   1305: pop
    //   1306: aload_2
    //   1307: areturn
    //   1308: aload 29
    //   1310: astore 30
    //   1312: new 8	com/whatsapp/aqg$a
    //   1315: dup
    //   1316: getstatic 417	com/whatsapp/aqg$b:a	Lcom/whatsapp/aqg$b;
    //   1319: aload 28
    //   1321: iconst_0
    //   1322: invokespecial 225	com/whatsapp/aqg$a:<init>	(Lcom/whatsapp/aqg$b;Ljava/io/File;B)V
    //   1325: astore_2
    //   1326: aload_2
    //   1327: astore_1
    //   1328: aload 29
    //   1330: ifnull -1293 -> 37
    //   1333: aload_2
    //   1334: astore_1
    //   1335: aload 29
    //   1337: invokevirtual 241	java/io/File:exists	()Z
    //   1340: ifeq -1303 -> 37
    //   1343: aload 29
    //   1345: invokevirtual 248	java/io/File:delete	()Z
    //   1348: pop
    //   1349: aload_2
    //   1350: areturn
    //   1351: ldc -87
    //   1353: astore 31
    //   1355: goto -415 -> 940
    //   1358: aload 29
    //   1360: astore 30
    //   1362: new 152	java/lang/StringBuilder
    //   1365: dup
    //   1366: ldc_w 330
    //   1369: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1372: aload_2
    //   1373: iconst_0
    //   1374: iaload
    //   1375: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1378: ldc -89
    //   1380: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1383: aload_2
    //   1384: iconst_1
    //   1385: iaload
    //   1386: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1389: ldc -89
    //   1391: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1394: aload_2
    //   1395: iconst_2
    //   1396: iaload
    //   1397: invokevirtual 165	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1400: ldc -87
    //   1402: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1405: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1408: astore_2
    //   1409: goto -332 -> 1077
    //   1412: aload 29
    //   1414: astore 30
    //   1416: aload_1
    //   1417: iload 12
    //   1419: i2l
    //   1420: invokestatic 280	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1423: putfield 419	com/whatsapp/fieldstats/events/i:h	Ljava/lang/Long;
    //   1426: aload 29
    //   1428: astore 30
    //   1430: aload_1
    //   1431: iload 10
    //   1433: i2l
    //   1434: invokestatic 280	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1437: putfield 421	com/whatsapp/fieldstats/events/i:i	Ljava/lang/Long;
    //   1440: aload 29
    //   1442: astore 30
    //   1444: aload_1
    //   1445: aload 36
    //   1447: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1450: putfield 423	com/whatsapp/fieldstats/events/i:g	Ljava/lang/String;
    //   1453: iload 10
    //   1455: bipush 46
    //   1457: if_icmple +190 -> 1647
    //   1460: aload 29
    //   1462: astore 30
    //   1464: aload_1
    //   1465: iconst_1
    //   1466: invokestatic 335	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1469: putfield 425	com/whatsapp/fieldstats/events/i:k	Ljava/lang/Boolean;
    //   1472: iload 9
    //   1474: bipush 46
    //   1476: if_icmpge +108 -> 1584
    //   1479: aload 29
    //   1481: astore 30
    //   1483: aload_1
    //   1484: iconst_1
    //   1485: invokestatic 335	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1488: putfield 428	com/whatsapp/fieldstats/events/i:l	Ljava/lang/Boolean;
    //   1491: aload 29
    //   1493: astore 30
    //   1495: getstatic 430	com/whatsapp/aqg$b:e	Lcom/whatsapp/aqg$b;
    //   1498: astore_2
    //   1499: aload 29
    //   1501: astore 30
    //   1503: new 152	java/lang/StringBuilder
    //   1506: dup
    //   1507: ldc_w 432
    //   1510: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1513: aload_1
    //   1514: getfield 232	com/whatsapp/fieldstats/events/i:a	Ljava/lang/String;
    //   1517: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1520: ldc_w 434
    //   1523: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1526: aload_1
    //   1527: getfield 272	com/whatsapp/fieldstats/events/i:b	Ljava/lang/String;
    //   1530: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1533: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1536: invokestatic 211	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1539: aload 29
    //   1541: astore 30
    //   1543: new 8	com/whatsapp/aqg$a
    //   1546: dup
    //   1547: aload_2
    //   1548: aload 28
    //   1550: aload 32
    //   1552: aload 33
    //   1554: iconst_0
    //   1555: invokespecial 437	com/whatsapp/aqg$a:<init>	(Lcom/whatsapp/aqg$b;Ljava/io/File;Lcom/whatsapp/aqe$a;Lcom/whatsapp/aqe$a;B)V
    //   1558: astore_2
    //   1559: aload_2
    //   1560: astore_1
    //   1561: aload 29
    //   1563: ifnull -1526 -> 37
    //   1566: aload_2
    //   1567: astore_1
    //   1568: aload 29
    //   1570: invokevirtual 241	java/io/File:exists	()Z
    //   1573: ifeq -1536 -> 37
    //   1576: aload 29
    //   1578: invokevirtual 248	java/io/File:delete	()Z
    //   1581: pop
    //   1582: aload_2
    //   1583: areturn
    //   1584: aload 29
    //   1586: astore 30
    //   1588: aload_1
    //   1589: iconst_0
    //   1590: invokestatic 335	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1593: putfield 428	com/whatsapp/fieldstats/events/i:l	Ljava/lang/Boolean;
    //   1596: aload 29
    //   1598: astore 30
    //   1600: getstatic 439	com/whatsapp/aqg$b:f	Lcom/whatsapp/aqg$b;
    //   1603: astore_2
    //   1604: aload 29
    //   1606: astore 30
    //   1608: new 152	java/lang/StringBuilder
    //   1611: dup
    //   1612: ldc_w 441
    //   1615: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1618: aload_1
    //   1619: getfield 232	com/whatsapp/fieldstats/events/i:a	Ljava/lang/String;
    //   1622: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1625: ldc_w 434
    //   1628: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1631: aload_1
    //   1632: getfield 272	com/whatsapp/fieldstats/events/i:b	Ljava/lang/String;
    //   1635: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1638: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1641: invokestatic 211	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1644: goto -105 -> 1539
    //   1647: aload 29
    //   1649: astore 30
    //   1651: aload_1
    //   1652: iconst_0
    //   1653: invokestatic 335	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1656: putfield 425	com/whatsapp/fieldstats/events/i:k	Ljava/lang/Boolean;
    //   1659: iload 12
    //   1661: bipush 46
    //   1663: if_icmpgt +8 -> 1671
    //   1666: iload 11
    //   1668: ifeq +159 -> 1827
    //   1671: iload 13
    //   1673: bipush 46
    //   1675: if_icmpge +101 -> 1776
    //   1678: iload 11
    //   1680: ifne +96 -> 1776
    //   1683: aload 29
    //   1685: astore 30
    //   1687: new 152	java/lang/StringBuilder
    //   1690: dup
    //   1691: ldc_w 443
    //   1694: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1697: aload_1
    //   1698: getfield 232	com/whatsapp/fieldstats/events/i:a	Ljava/lang/String;
    //   1701: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1704: ldc_w 434
    //   1707: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1710: aload_1
    //   1711: getfield 272	com/whatsapp/fieldstats/events/i:b	Ljava/lang/String;
    //   1714: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1717: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1720: invokestatic 211	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1723: aload 29
    //   1725: astore 30
    //   1727: getstatic 445	com/whatsapp/aqg$b:b	Lcom/whatsapp/aqg$b;
    //   1730: astore_2
    //   1731: aload 29
    //   1733: astore 30
    //   1735: new 8	com/whatsapp/aqg$a
    //   1738: dup
    //   1739: aload_2
    //   1740: aload 28
    //   1742: aload 32
    //   1744: aload 33
    //   1746: iconst_0
    //   1747: invokespecial 437	com/whatsapp/aqg$a:<init>	(Lcom/whatsapp/aqg$b;Ljava/io/File;Lcom/whatsapp/aqe$a;Lcom/whatsapp/aqe$a;B)V
    //   1750: astore_2
    //   1751: aload_2
    //   1752: astore_1
    //   1753: aload 29
    //   1755: ifnull -1718 -> 37
    //   1758: aload_2
    //   1759: astore_1
    //   1760: aload 29
    //   1762: invokevirtual 241	java/io/File:exists	()Z
    //   1765: ifeq -1728 -> 37
    //   1768: aload 29
    //   1770: invokevirtual 248	java/io/File:delete	()Z
    //   1773: pop
    //   1774: aload_2
    //   1775: areturn
    //   1776: aload 29
    //   1778: astore 30
    //   1780: new 152	java/lang/StringBuilder
    //   1783: dup
    //   1784: ldc_w 447
    //   1787: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1790: aload_1
    //   1791: getfield 232	com/whatsapp/fieldstats/events/i:a	Ljava/lang/String;
    //   1794: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1797: ldc_w 434
    //   1800: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1803: aload_1
    //   1804: getfield 272	com/whatsapp/fieldstats/events/i:b	Ljava/lang/String;
    //   1807: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1810: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1813: invokestatic 211	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1816: aload 29
    //   1818: astore 30
    //   1820: getstatic 449	com/whatsapp/aqg$b:c	Lcom/whatsapp/aqg$b;
    //   1823: astore_2
    //   1824: goto -93 -> 1731
    //   1827: aload 29
    //   1829: astore 30
    //   1831: getstatic 417	com/whatsapp/aqg$b:a	Lcom/whatsapp/aqg$b;
    //   1834: astore_2
    //   1835: goto -104 -> 1731
    //   1838: astore_1
    //   1839: aconst_null
    //   1840: astore 30
    //   1842: aload 30
    //   1844: ifnull +17 -> 1861
    //   1847: aload 30
    //   1849: invokevirtual 241	java/io/File:exists	()Z
    //   1852: ifeq +9 -> 1861
    //   1855: aload 30
    //   1857: invokevirtual 248	java/io/File:delete	()Z
    //   1860: pop
    //   1861: aload_1
    //   1862: athrow
    //   1863: astore_2
    //   1864: aconst_null
    //   1865: astore 28
    //   1867: goto -657 -> 1210
    //   1870: astore_1
    //   1871: goto -29 -> 1842
    //   1874: astore_2
    //   1875: aconst_null
    //   1876: astore 29
    //   1878: aconst_null
    //   1879: astore 28
    //   1881: goto -671 -> 1210
    //   1884: astore_2
    //   1885: aconst_null
    //   1886: astore 28
    //   1888: goto -678 -> 1210
    //   1891: astore_2
    //   1892: aconst_null
    //   1893: astore 29
    //   1895: aconst_null
    //   1896: astore 28
    //   1898: goto -688 -> 1210
    //   1901: astore_2
    //   1902: aconst_null
    //   1903: astore 28
    //   1905: goto -695 -> 1210
    //   1908: astore_2
    //   1909: goto -699 -> 1210
    //   1912: astore_2
    //   1913: aconst_null
    //   1914: astore 29
    //   1916: aconst_null
    //   1917: astore 28
    //   1919: goto -709 -> 1210
    //   1922: astore_2
    //   1923: aconst_null
    //   1924: astore 28
    //   1926: goto -716 -> 1210
    //   1929: astore_2
    //   1930: goto -720 -> 1210
    //   1933: astore_2
    //   1934: aconst_null
    //   1935: astore 29
    //   1937: aconst_null
    //   1938: astore 28
    //   1940: goto -730 -> 1210
    //   1943: astore_2
    //   1944: aconst_null
    //   1945: astore 28
    //   1947: goto -737 -> 1210
    //   1950: astore_2
    //   1951: aconst_null
    //   1952: astore 28
    //   1954: goto -87 -> 1867
    //   1957: astore_2
    //   1958: goto -91 -> 1867
    //   1961: goto -962 -> 999
    //   1964: goto +145 -> 2109
    //   1967: goto -1157 -> 810
    //   1970: aconst_null
    //   1971: astore_2
    //   1972: goto -1061 -> 911
    //   1975: goto -1304 -> 671
    //   1978: goto -1335 -> 643
    //   1981: iconst_0
    //   1982: istore 16
    //   1984: iconst_m1
    //   1985: istore 17
    //   1987: iconst_0
    //   1988: istore 13
    //   1990: iconst_0
    //   1991: istore 12
    //   1993: goto -1440 -> 553
    //   1996: ldc2_w 450
    //   1999: iload 14
    //   2001: i2d
    //   2002: dmul
    //   2003: d2i
    //   2004: iload 14
    //   2006: iadd
    //   2007: istore 15
    //   2009: iload 27
    //   2011: i2d
    //   2012: dstore_3
    //   2013: iload 25
    //   2015: i2d
    //   2016: dstore 5
    //   2018: iload 26
    //   2020: i2d
    //   2021: dstore 7
    //   2023: iload 22
    //   2025: iconst_1
    //   2026: if_icmpne +90 -> 2116
    //   2029: iload 14
    //   2031: istore 18
    //   2033: ldc2_w 450
    //   2036: dload_3
    //   2037: dmul
    //   2038: dload 5
    //   2040: dmul
    //   2041: ldc2_w 452
    //   2044: dload 7
    //   2046: dmul
    //   2047: dadd
    //   2048: iload 18
    //   2050: i2d
    //   2051: dadd
    //   2052: d2i
    //   2053: istore 18
    //   2055: iload 27
    //   2057: i2d
    //   2058: dstore_3
    //   2059: iload 25
    //   2061: i2d
    //   2062: dstore 5
    //   2064: iload 26
    //   2066: i2d
    //   2067: dstore 7
    //   2069: iload 22
    //   2071: iconst_1
    //   2072: if_icmpne +51 -> 2123
    //   2075: dload 7
    //   2077: ldc2_w 452
    //   2080: dmul
    //   2081: ldc2_w 450
    //   2084: dload_3
    //   2085: dmul
    //   2086: dload 5
    //   2088: dmul
    //   2089: dadd
    //   2090: iload 15
    //   2092: i2d
    //   2093: dadd
    //   2094: d2i
    //   2095: istore 15
    //   2097: iload 18
    //   2099: istore 14
    //   2101: goto -1291 -> 810
    //   2104: aconst_null
    //   2105: astore_2
    //   2106: goto -1260 -> 846
    //   2109: iload 14
    //   2111: istore 10
    //   2113: goto -1202 -> 911
    //   2116: iload 15
    //   2118: istore 18
    //   2120: goto -87 -> 2033
    //   2123: iload 14
    //   2125: istore 15
    //   2127: goto -52 -> 2075
    //   2130: iload 22
    //   2132: iconst_3
    //   2133: if_icmpeq +9 -> 2142
    //   2136: iload 22
    //   2138: iconst_4
    //   2139: if_icmpne +65 -> 2204
    //   2142: iload 27
    //   2144: i2d
    //   2145: dstore_3
    //   2146: iload 25
    //   2148: i2d
    //   2149: dstore 5
    //   2151: iload 14
    //   2153: iload 26
    //   2155: i2d
    //   2156: ldc2_w 452
    //   2159: dmul
    //   2160: d2i
    //   2161: iconst_1
    //   2162: ishl
    //   2163: i2d
    //   2164: ldc2_w 452
    //   2167: dload_3
    //   2168: dmul
    //   2169: dload 5
    //   2171: dmul
    //   2172: dadd
    //   2173: d2i
    //   2174: iadd
    //   2175: istore 14
    //   2177: iload 14
    //   2179: iconst_1
    //   2180: iadd
    //   2181: istore 15
    //   2183: iload 22
    //   2185: iconst_4
    //   2186: if_icmpne -219 -> 1967
    //   2189: iload 14
    //   2191: istore 18
    //   2193: iload 15
    //   2195: istore 14
    //   2197: iload 18
    //   2199: istore 15
    //   2201: goto -1391 -> 810
    //   2204: aconst_null
    //   2205: astore_2
    //   2206: goto -1360 -> 846
    //   2209: aload_2
    //   2210: iload 21
    //   2212: baload
    //   2213: istore 22
    //   2215: aload_2
    //   2216: iload 14
    //   2218: baload
    //   2219: istore 18
    //   2221: aload_2
    //   2222: iload 15
    //   2224: baload
    //   2225: istore 21
    //   2227: iload 22
    //   2229: istore 14
    //   2231: iload 22
    //   2233: ifge +11 -> 2244
    //   2236: iload 22
    //   2238: sipush 256
    //   2241: iadd
    //   2242: istore 14
    //   2244: iload 18
    //   2246: istore 15
    //   2248: iload 18
    //   2250: ifge +11 -> 2261
    //   2253: iload 18
    //   2255: sipush 256
    //   2258: iadd
    //   2259: istore 15
    //   2261: iload 21
    //   2263: istore 18
    //   2265: iload 21
    //   2267: ifge -1150 -> 1117
    //   2270: iload 21
    //   2272: sipush 256
    //   2275: iadd
    //   2276: istore 18
    //   2278: goto -1161 -> 1117
    //   2281: astore_2
    //   2282: goto -1072 -> 1210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2285	0	this	aqg
    //   0	2285	1	parami	com.whatsapp.fieldstats.events.i
    //   0	2285	2	paramaqh	aqh
    //   2012	156	3	d1	double
    //   2016	154	5	d2	double
    //   2021	55	7	d3	double
    //   157	1320	9	i	int
    //   168	1944	10	j	int
    //   179	1500	11	k	int
    //   634	1358	12	m	int
    //   662	1327	13	n	int
    //   658	1585	14	i1	int
    //   746	1514	15	i2	int
    //   553	1430	16	i3	int
    //   974	1012	17	i4	int
    //   735	1542	18	i5	int
    //   613	498	19	i6	int
    //   630	464	20	i7	int
    //   793	1483	21	i8	int
    //   702	1540	22	i9	int
    //   578	436	23	i10	int
    //   598	427	24	i11	int
    //   713	1434	25	i12	int
    //   768	1386	26	i13	int
    //   783	1360	27	i14	int
    //   54	1899	28	localObject1	Object
    //   1	1935	29	localObject2	Object
    //   62	1794	30	localObject3	Object
    //   6	1348	31	localObject4	Object
    //   210	1533	32	locala1	aqe.a
    //   497	1248	33	locala2	aqe.a
    //   281	407	34	localaqe	aqe
    //   399	206	35	localBitmap	android.graphics.Bitmap
    //   465	981	36	localStringBuilder1	StringBuilder
    //   927	20	37	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   262	283	1209	com/whatsapp/util/MediaFileUtils$c
    //   287	293	1209	com/whatsapp/util/MediaFileUtils$c
    //   297	302	1209	com/whatsapp/util/MediaFileUtils$c
    //   306	314	1209	com/whatsapp/util/MediaFileUtils$c
    //   318	324	1209	com/whatsapp/util/MediaFileUtils$c
    //   328	341	1209	com/whatsapp/util/MediaFileUtils$c
    //   370	378	1209	com/whatsapp/util/MediaFileUtils$c
    //   382	391	1209	com/whatsapp/util/MediaFileUtils$c
    //   395	401	1209	com/whatsapp/util/MediaFileUtils$c
    //   405	409	1209	com/whatsapp/util/MediaFileUtils$c
    //   413	451	1209	com/whatsapp/util/MediaFileUtils$c
    //   455	467	1209	com/whatsapp/util/MediaFileUtils$c
    //   480	488	1209	com/whatsapp/util/MediaFileUtils$c
    //   492	499	1209	com/whatsapp/util/MediaFileUtils$c
    //   508	517	1209	com/whatsapp/util/MediaFileUtils$c
    //   521	533	1209	com/whatsapp/util/MediaFileUtils$c
    //   537	550	1209	com/whatsapp/util/MediaFileUtils$c
    //   564	580	1209	com/whatsapp/util/MediaFileUtils$c
    //   584	600	1209	com/whatsapp/util/MediaFileUtils$c
    //   604	615	1209	com/whatsapp/util/MediaFileUtils$c
    //   619	632	1209	com/whatsapp/util/MediaFileUtils$c
    //   647	660	1209	com/whatsapp/util/MediaFileUtils$c
    //   675	683	1209	com/whatsapp/util/MediaFileUtils$c
    //   687	693	1209	com/whatsapp/util/MediaFileUtils$c
    //   697	704	1209	com/whatsapp/util/MediaFileUtils$c
    //   708	715	1209	com/whatsapp/util/MediaFileUtils$c
    //   719	726	1209	com/whatsapp/util/MediaFileUtils$c
    //   730	737	1209	com/whatsapp/util/MediaFileUtils$c
    //   741	748	1209	com/whatsapp/util/MediaFileUtils$c
    //   759	770	1209	com/whatsapp/util/MediaFileUtils$c
    //   774	785	1209	com/whatsapp/util/MediaFileUtils$c
    //   814	821	1209	com/whatsapp/util/MediaFileUtils$c
    //   825	832	1209	com/whatsapp/util/MediaFileUtils$c
    //   836	843	1209	com/whatsapp/util/MediaFileUtils$c
    //   854	866	1209	com/whatsapp/util/MediaFileUtils$c
    //   885	897	1209	com/whatsapp/util/MediaFileUtils$c
    //   915	929	1209	com/whatsapp/util/MediaFileUtils$c
    //   944	960	1209	com/whatsapp/util/MediaFileUtils$c
    //   972	984	1209	com/whatsapp/util/MediaFileUtils$c
    //   988	996	1209	com/whatsapp/util/MediaFileUtils$c
    //   1003	1069	1209	com/whatsapp/util/MediaFileUtils$c
    //   1081	1104	1209	com/whatsapp/util/MediaFileUtils$c
    //   1187	1191	1209	com/whatsapp/util/MediaFileUtils$c
    //   1312	1326	1209	com/whatsapp/util/MediaFileUtils$c
    //   1362	1409	1209	com/whatsapp/util/MediaFileUtils$c
    //   1416	1426	1209	com/whatsapp/util/MediaFileUtils$c
    //   1430	1440	1209	com/whatsapp/util/MediaFileUtils$c
    //   1444	1453	1209	com/whatsapp/util/MediaFileUtils$c
    //   1464	1472	1209	com/whatsapp/util/MediaFileUtils$c
    //   1483	1491	1209	com/whatsapp/util/MediaFileUtils$c
    //   1495	1499	1209	com/whatsapp/util/MediaFileUtils$c
    //   1503	1539	1209	com/whatsapp/util/MediaFileUtils$c
    //   1543	1559	1209	com/whatsapp/util/MediaFileUtils$c
    //   1588	1596	1209	com/whatsapp/util/MediaFileUtils$c
    //   1600	1604	1209	com/whatsapp/util/MediaFileUtils$c
    //   1608	1644	1209	com/whatsapp/util/MediaFileUtils$c
    //   1651	1659	1209	com/whatsapp/util/MediaFileUtils$c
    //   1687	1723	1209	com/whatsapp/util/MediaFileUtils$c
    //   1727	1731	1209	com/whatsapp/util/MediaFileUtils$c
    //   1735	1751	1209	com/whatsapp/util/MediaFileUtils$c
    //   1780	1816	1209	com/whatsapp/util/MediaFileUtils$c
    //   1820	1824	1209	com/whatsapp/util/MediaFileUtils$c
    //   1831	1835	1209	com/whatsapp/util/MediaFileUtils$c
    //   48	56	1838	finally
    //   48	56	1863	com/whatsapp/Mp4Ops$a
    //   64	72	1870	finally
    //   76	82	1870	finally
    //   86	91	1870	finally
    //   95	108	1870	finally
    //   137	148	1870	finally
    //   152	159	1870	finally
    //   163	170	1870	finally
    //   174	181	1870	finally
    //   185	212	1870	finally
    //   216	228	1870	finally
    //   232	245	1870	finally
    //   249	258	1870	finally
    //   262	283	1870	finally
    //   287	293	1870	finally
    //   297	302	1870	finally
    //   306	314	1870	finally
    //   318	324	1870	finally
    //   328	341	1870	finally
    //   370	378	1870	finally
    //   382	391	1870	finally
    //   395	401	1870	finally
    //   405	409	1870	finally
    //   413	451	1870	finally
    //   455	467	1870	finally
    //   480	488	1870	finally
    //   492	499	1870	finally
    //   508	517	1870	finally
    //   521	533	1870	finally
    //   537	550	1870	finally
    //   564	580	1870	finally
    //   584	600	1870	finally
    //   604	615	1870	finally
    //   619	632	1870	finally
    //   647	660	1870	finally
    //   675	683	1870	finally
    //   687	693	1870	finally
    //   697	704	1870	finally
    //   708	715	1870	finally
    //   719	726	1870	finally
    //   730	737	1870	finally
    //   741	748	1870	finally
    //   759	770	1870	finally
    //   774	785	1870	finally
    //   814	821	1870	finally
    //   825	832	1870	finally
    //   836	843	1870	finally
    //   854	866	1870	finally
    //   885	897	1870	finally
    //   915	929	1870	finally
    //   944	960	1870	finally
    //   972	984	1870	finally
    //   988	996	1870	finally
    //   1003	1069	1870	finally
    //   1081	1104	1870	finally
    //   1187	1191	1870	finally
    //   1214	1254	1870	finally
    //   1258	1265	1870	finally
    //   1269	1283	1870	finally
    //   1312	1326	1870	finally
    //   1362	1409	1870	finally
    //   1416	1426	1870	finally
    //   1430	1440	1870	finally
    //   1444	1453	1870	finally
    //   1464	1472	1870	finally
    //   1483	1491	1870	finally
    //   1495	1499	1870	finally
    //   1503	1539	1870	finally
    //   1543	1559	1870	finally
    //   1588	1596	1870	finally
    //   1600	1604	1870	finally
    //   1608	1644	1870	finally
    //   1651	1659	1870	finally
    //   1687	1723	1870	finally
    //   1727	1731	1870	finally
    //   1735	1751	1870	finally
    //   1780	1816	1870	finally
    //   1820	1824	1870	finally
    //   1831	1835	1870	finally
    //   48	56	1874	com/whatsapp/util/MediaFileUtils$c
    //   64	72	1884	com/whatsapp/util/MediaFileUtils$c
    //   76	82	1884	com/whatsapp/util/MediaFileUtils$c
    //   86	91	1884	com/whatsapp/util/MediaFileUtils$c
    //   95	108	1884	com/whatsapp/util/MediaFileUtils$c
    //   137	148	1884	com/whatsapp/util/MediaFileUtils$c
    //   152	159	1884	com/whatsapp/util/MediaFileUtils$c
    //   163	170	1884	com/whatsapp/util/MediaFileUtils$c
    //   174	181	1884	com/whatsapp/util/MediaFileUtils$c
    //   185	212	1884	com/whatsapp/util/MediaFileUtils$c
    //   216	228	1884	com/whatsapp/util/MediaFileUtils$c
    //   232	245	1884	com/whatsapp/util/MediaFileUtils$c
    //   249	258	1884	com/whatsapp/util/MediaFileUtils$c
    //   48	56	1891	java/lang/IllegalStateException
    //   64	72	1901	java/lang/IllegalStateException
    //   76	82	1901	java/lang/IllegalStateException
    //   86	91	1901	java/lang/IllegalStateException
    //   95	108	1901	java/lang/IllegalStateException
    //   137	148	1901	java/lang/IllegalStateException
    //   152	159	1901	java/lang/IllegalStateException
    //   163	170	1901	java/lang/IllegalStateException
    //   174	181	1901	java/lang/IllegalStateException
    //   185	212	1901	java/lang/IllegalStateException
    //   216	228	1901	java/lang/IllegalStateException
    //   232	245	1901	java/lang/IllegalStateException
    //   249	258	1901	java/lang/IllegalStateException
    //   262	283	1908	java/lang/IllegalStateException
    //   287	293	1908	java/lang/IllegalStateException
    //   297	302	1908	java/lang/IllegalStateException
    //   306	314	1908	java/lang/IllegalStateException
    //   318	324	1908	java/lang/IllegalStateException
    //   328	341	1908	java/lang/IllegalStateException
    //   370	378	1908	java/lang/IllegalStateException
    //   382	391	1908	java/lang/IllegalStateException
    //   395	401	1908	java/lang/IllegalStateException
    //   405	409	1908	java/lang/IllegalStateException
    //   413	451	1908	java/lang/IllegalStateException
    //   455	467	1908	java/lang/IllegalStateException
    //   480	488	1908	java/lang/IllegalStateException
    //   492	499	1908	java/lang/IllegalStateException
    //   508	517	1908	java/lang/IllegalStateException
    //   521	533	1908	java/lang/IllegalStateException
    //   537	550	1908	java/lang/IllegalStateException
    //   564	580	1908	java/lang/IllegalStateException
    //   584	600	1908	java/lang/IllegalStateException
    //   604	615	1908	java/lang/IllegalStateException
    //   619	632	1908	java/lang/IllegalStateException
    //   647	660	1908	java/lang/IllegalStateException
    //   675	683	1908	java/lang/IllegalStateException
    //   687	693	1908	java/lang/IllegalStateException
    //   697	704	1908	java/lang/IllegalStateException
    //   708	715	1908	java/lang/IllegalStateException
    //   719	726	1908	java/lang/IllegalStateException
    //   730	737	1908	java/lang/IllegalStateException
    //   741	748	1908	java/lang/IllegalStateException
    //   759	770	1908	java/lang/IllegalStateException
    //   774	785	1908	java/lang/IllegalStateException
    //   814	821	1908	java/lang/IllegalStateException
    //   825	832	1908	java/lang/IllegalStateException
    //   836	843	1908	java/lang/IllegalStateException
    //   854	866	1908	java/lang/IllegalStateException
    //   885	897	1908	java/lang/IllegalStateException
    //   915	929	1908	java/lang/IllegalStateException
    //   944	960	1908	java/lang/IllegalStateException
    //   972	984	1908	java/lang/IllegalStateException
    //   988	996	1908	java/lang/IllegalStateException
    //   1003	1069	1908	java/lang/IllegalStateException
    //   1081	1104	1908	java/lang/IllegalStateException
    //   1187	1191	1908	java/lang/IllegalStateException
    //   1312	1326	1908	java/lang/IllegalStateException
    //   1362	1409	1908	java/lang/IllegalStateException
    //   1416	1426	1908	java/lang/IllegalStateException
    //   1430	1440	1908	java/lang/IllegalStateException
    //   1444	1453	1908	java/lang/IllegalStateException
    //   1464	1472	1908	java/lang/IllegalStateException
    //   1483	1491	1908	java/lang/IllegalStateException
    //   1495	1499	1908	java/lang/IllegalStateException
    //   1503	1539	1908	java/lang/IllegalStateException
    //   1543	1559	1908	java/lang/IllegalStateException
    //   1588	1596	1908	java/lang/IllegalStateException
    //   1600	1604	1908	java/lang/IllegalStateException
    //   1608	1644	1908	java/lang/IllegalStateException
    //   1651	1659	1908	java/lang/IllegalStateException
    //   1687	1723	1908	java/lang/IllegalStateException
    //   1727	1731	1908	java/lang/IllegalStateException
    //   1735	1751	1908	java/lang/IllegalStateException
    //   1780	1816	1908	java/lang/IllegalStateException
    //   1820	1824	1908	java/lang/IllegalStateException
    //   1831	1835	1908	java/lang/IllegalStateException
    //   48	56	1912	java/lang/ArrayIndexOutOfBoundsException
    //   64	72	1922	java/lang/ArrayIndexOutOfBoundsException
    //   76	82	1922	java/lang/ArrayIndexOutOfBoundsException
    //   86	91	1922	java/lang/ArrayIndexOutOfBoundsException
    //   95	108	1922	java/lang/ArrayIndexOutOfBoundsException
    //   137	148	1922	java/lang/ArrayIndexOutOfBoundsException
    //   152	159	1922	java/lang/ArrayIndexOutOfBoundsException
    //   163	170	1922	java/lang/ArrayIndexOutOfBoundsException
    //   174	181	1922	java/lang/ArrayIndexOutOfBoundsException
    //   185	212	1922	java/lang/ArrayIndexOutOfBoundsException
    //   216	228	1922	java/lang/ArrayIndexOutOfBoundsException
    //   232	245	1922	java/lang/ArrayIndexOutOfBoundsException
    //   249	258	1922	java/lang/ArrayIndexOutOfBoundsException
    //   262	283	1929	java/lang/ArrayIndexOutOfBoundsException
    //   287	293	1929	java/lang/ArrayIndexOutOfBoundsException
    //   297	302	1929	java/lang/ArrayIndexOutOfBoundsException
    //   306	314	1929	java/lang/ArrayIndexOutOfBoundsException
    //   318	324	1929	java/lang/ArrayIndexOutOfBoundsException
    //   328	341	1929	java/lang/ArrayIndexOutOfBoundsException
    //   370	378	1929	java/lang/ArrayIndexOutOfBoundsException
    //   382	391	1929	java/lang/ArrayIndexOutOfBoundsException
    //   395	401	1929	java/lang/ArrayIndexOutOfBoundsException
    //   405	409	1929	java/lang/ArrayIndexOutOfBoundsException
    //   413	451	1929	java/lang/ArrayIndexOutOfBoundsException
    //   455	467	1929	java/lang/ArrayIndexOutOfBoundsException
    //   480	488	1929	java/lang/ArrayIndexOutOfBoundsException
    //   492	499	1929	java/lang/ArrayIndexOutOfBoundsException
    //   508	517	1929	java/lang/ArrayIndexOutOfBoundsException
    //   521	533	1929	java/lang/ArrayIndexOutOfBoundsException
    //   537	550	1929	java/lang/ArrayIndexOutOfBoundsException
    //   564	580	1929	java/lang/ArrayIndexOutOfBoundsException
    //   584	600	1929	java/lang/ArrayIndexOutOfBoundsException
    //   604	615	1929	java/lang/ArrayIndexOutOfBoundsException
    //   619	632	1929	java/lang/ArrayIndexOutOfBoundsException
    //   647	660	1929	java/lang/ArrayIndexOutOfBoundsException
    //   675	683	1929	java/lang/ArrayIndexOutOfBoundsException
    //   687	693	1929	java/lang/ArrayIndexOutOfBoundsException
    //   697	704	1929	java/lang/ArrayIndexOutOfBoundsException
    //   708	715	1929	java/lang/ArrayIndexOutOfBoundsException
    //   719	726	1929	java/lang/ArrayIndexOutOfBoundsException
    //   730	737	1929	java/lang/ArrayIndexOutOfBoundsException
    //   741	748	1929	java/lang/ArrayIndexOutOfBoundsException
    //   759	770	1929	java/lang/ArrayIndexOutOfBoundsException
    //   774	785	1929	java/lang/ArrayIndexOutOfBoundsException
    //   814	821	1929	java/lang/ArrayIndexOutOfBoundsException
    //   825	832	1929	java/lang/ArrayIndexOutOfBoundsException
    //   836	843	1929	java/lang/ArrayIndexOutOfBoundsException
    //   854	866	1929	java/lang/ArrayIndexOutOfBoundsException
    //   885	897	1929	java/lang/ArrayIndexOutOfBoundsException
    //   915	929	1929	java/lang/ArrayIndexOutOfBoundsException
    //   944	960	1929	java/lang/ArrayIndexOutOfBoundsException
    //   972	984	1929	java/lang/ArrayIndexOutOfBoundsException
    //   988	996	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1003	1069	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1081	1104	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1187	1191	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1312	1326	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1362	1409	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1416	1426	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1430	1440	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1444	1453	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1464	1472	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1483	1491	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1495	1499	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1503	1539	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1543	1559	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1588	1596	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1600	1604	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1608	1644	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1651	1659	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1687	1723	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1727	1731	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1735	1751	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1780	1816	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1820	1824	1929	java/lang/ArrayIndexOutOfBoundsException
    //   1831	1835	1929	java/lang/ArrayIndexOutOfBoundsException
    //   48	56	1933	java/io/IOException
    //   64	72	1943	java/io/IOException
    //   76	82	1943	java/io/IOException
    //   86	91	1943	java/io/IOException
    //   95	108	1943	java/io/IOException
    //   137	148	1943	java/io/IOException
    //   152	159	1943	java/io/IOException
    //   163	170	1943	java/io/IOException
    //   174	181	1943	java/io/IOException
    //   185	212	1943	java/io/IOException
    //   216	228	1943	java/io/IOException
    //   232	245	1943	java/io/IOException
    //   249	258	1943	java/io/IOException
    //   64	72	1950	com/whatsapp/Mp4Ops$a
    //   76	82	1950	com/whatsapp/Mp4Ops$a
    //   86	91	1950	com/whatsapp/Mp4Ops$a
    //   95	108	1950	com/whatsapp/Mp4Ops$a
    //   137	148	1950	com/whatsapp/Mp4Ops$a
    //   152	159	1950	com/whatsapp/Mp4Ops$a
    //   163	170	1950	com/whatsapp/Mp4Ops$a
    //   174	181	1950	com/whatsapp/Mp4Ops$a
    //   185	212	1950	com/whatsapp/Mp4Ops$a
    //   216	228	1950	com/whatsapp/Mp4Ops$a
    //   232	245	1950	com/whatsapp/Mp4Ops$a
    //   249	258	1950	com/whatsapp/Mp4Ops$a
    //   262	283	1957	com/whatsapp/Mp4Ops$a
    //   287	293	1957	com/whatsapp/Mp4Ops$a
    //   297	302	1957	com/whatsapp/Mp4Ops$a
    //   306	314	1957	com/whatsapp/Mp4Ops$a
    //   318	324	1957	com/whatsapp/Mp4Ops$a
    //   328	341	1957	com/whatsapp/Mp4Ops$a
    //   370	378	1957	com/whatsapp/Mp4Ops$a
    //   382	391	1957	com/whatsapp/Mp4Ops$a
    //   395	401	1957	com/whatsapp/Mp4Ops$a
    //   405	409	1957	com/whatsapp/Mp4Ops$a
    //   413	451	1957	com/whatsapp/Mp4Ops$a
    //   455	467	1957	com/whatsapp/Mp4Ops$a
    //   480	488	1957	com/whatsapp/Mp4Ops$a
    //   492	499	1957	com/whatsapp/Mp4Ops$a
    //   508	517	1957	com/whatsapp/Mp4Ops$a
    //   521	533	1957	com/whatsapp/Mp4Ops$a
    //   537	550	1957	com/whatsapp/Mp4Ops$a
    //   564	580	1957	com/whatsapp/Mp4Ops$a
    //   584	600	1957	com/whatsapp/Mp4Ops$a
    //   604	615	1957	com/whatsapp/Mp4Ops$a
    //   619	632	1957	com/whatsapp/Mp4Ops$a
    //   647	660	1957	com/whatsapp/Mp4Ops$a
    //   675	683	1957	com/whatsapp/Mp4Ops$a
    //   687	693	1957	com/whatsapp/Mp4Ops$a
    //   697	704	1957	com/whatsapp/Mp4Ops$a
    //   708	715	1957	com/whatsapp/Mp4Ops$a
    //   719	726	1957	com/whatsapp/Mp4Ops$a
    //   730	737	1957	com/whatsapp/Mp4Ops$a
    //   741	748	1957	com/whatsapp/Mp4Ops$a
    //   759	770	1957	com/whatsapp/Mp4Ops$a
    //   774	785	1957	com/whatsapp/Mp4Ops$a
    //   814	821	1957	com/whatsapp/Mp4Ops$a
    //   825	832	1957	com/whatsapp/Mp4Ops$a
    //   836	843	1957	com/whatsapp/Mp4Ops$a
    //   854	866	1957	com/whatsapp/Mp4Ops$a
    //   885	897	1957	com/whatsapp/Mp4Ops$a
    //   915	929	1957	com/whatsapp/Mp4Ops$a
    //   944	960	1957	com/whatsapp/Mp4Ops$a
    //   972	984	1957	com/whatsapp/Mp4Ops$a
    //   988	996	1957	com/whatsapp/Mp4Ops$a
    //   1003	1069	1957	com/whatsapp/Mp4Ops$a
    //   1081	1104	1957	com/whatsapp/Mp4Ops$a
    //   1187	1191	1957	com/whatsapp/Mp4Ops$a
    //   1312	1326	1957	com/whatsapp/Mp4Ops$a
    //   1362	1409	1957	com/whatsapp/Mp4Ops$a
    //   1416	1426	1957	com/whatsapp/Mp4Ops$a
    //   1430	1440	1957	com/whatsapp/Mp4Ops$a
    //   1444	1453	1957	com/whatsapp/Mp4Ops$a
    //   1464	1472	1957	com/whatsapp/Mp4Ops$a
    //   1483	1491	1957	com/whatsapp/Mp4Ops$a
    //   1495	1499	1957	com/whatsapp/Mp4Ops$a
    //   1503	1539	1957	com/whatsapp/Mp4Ops$a
    //   1543	1559	1957	com/whatsapp/Mp4Ops$a
    //   1588	1596	1957	com/whatsapp/Mp4Ops$a
    //   1600	1604	1957	com/whatsapp/Mp4Ops$a
    //   1608	1644	1957	com/whatsapp/Mp4Ops$a
    //   1651	1659	1957	com/whatsapp/Mp4Ops$a
    //   1687	1723	1957	com/whatsapp/Mp4Ops$a
    //   1727	1731	1957	com/whatsapp/Mp4Ops$a
    //   1735	1751	1957	com/whatsapp/Mp4Ops$a
    //   1780	1816	1957	com/whatsapp/Mp4Ops$a
    //   1820	1824	1957	com/whatsapp/Mp4Ops$a
    //   1831	1835	1957	com/whatsapp/Mp4Ops$a
    //   262	283	2281	java/io/IOException
    //   287	293	2281	java/io/IOException
    //   297	302	2281	java/io/IOException
    //   306	314	2281	java/io/IOException
    //   318	324	2281	java/io/IOException
    //   328	341	2281	java/io/IOException
    //   370	378	2281	java/io/IOException
    //   382	391	2281	java/io/IOException
    //   395	401	2281	java/io/IOException
    //   405	409	2281	java/io/IOException
    //   413	451	2281	java/io/IOException
    //   455	467	2281	java/io/IOException
    //   480	488	2281	java/io/IOException
    //   492	499	2281	java/io/IOException
    //   508	517	2281	java/io/IOException
    //   521	533	2281	java/io/IOException
    //   537	550	2281	java/io/IOException
    //   564	580	2281	java/io/IOException
    //   584	600	2281	java/io/IOException
    //   604	615	2281	java/io/IOException
    //   619	632	2281	java/io/IOException
    //   647	660	2281	java/io/IOException
    //   675	683	2281	java/io/IOException
    //   687	693	2281	java/io/IOException
    //   697	704	2281	java/io/IOException
    //   708	715	2281	java/io/IOException
    //   719	726	2281	java/io/IOException
    //   730	737	2281	java/io/IOException
    //   741	748	2281	java/io/IOException
    //   759	770	2281	java/io/IOException
    //   774	785	2281	java/io/IOException
    //   814	821	2281	java/io/IOException
    //   825	832	2281	java/io/IOException
    //   836	843	2281	java/io/IOException
    //   854	866	2281	java/io/IOException
    //   885	897	2281	java/io/IOException
    //   915	929	2281	java/io/IOException
    //   944	960	2281	java/io/IOException
    //   972	984	2281	java/io/IOException
    //   988	996	2281	java/io/IOException
    //   1003	1069	2281	java/io/IOException
    //   1081	1104	2281	java/io/IOException
    //   1187	1191	2281	java/io/IOException
    //   1312	1326	2281	java/io/IOException
    //   1362	1409	2281	java/io/IOException
    //   1416	1426	2281	java/io/IOException
    //   1430	1440	2281	java/io/IOException
    //   1444	1453	2281	java/io/IOException
    //   1464	1472	2281	java/io/IOException
    //   1483	1491	2281	java/io/IOException
    //   1495	1499	2281	java/io/IOException
    //   1503	1539	2281	java/io/IOException
    //   1543	1559	2281	java/io/IOException
    //   1588	1596	2281	java/io/IOException
    //   1600	1604	2281	java/io/IOException
    //   1608	1644	2281	java/io/IOException
    //   1651	1659	2281	java/io/IOException
    //   1687	1723	2281	java/io/IOException
    //   1727	1731	2281	java/io/IOException
    //   1735	1751	2281	java/io/IOException
    //   1780	1816	2281	java/io/IOException
    //   1820	1824	2281	java/io/IOException
    //   1831	1835	2281	java/io/IOException
  }
  
  static final class a
  {
    aqg.b a;
    File b;
    public final String c;
    public final String d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;
    
    private a(aqg.b paramb, File paramFile)
    {
      this.a = paramb;
      this.b = paramFile;
      this.c = null;
      this.d = null;
      this.e = -1;
      this.f = -1;
      this.g = -1;
      this.h = -1;
    }
    
    private a(aqg.b paramb, File paramFile, aqe.a parama1, aqe.a parama2)
    {
      this.a = paramb;
      this.b = paramFile;
      this.c = parama1.j;
      this.f = parama1.a;
      this.g = parama1.k;
      this.d = parama2.j;
      this.e = parama2.a;
      this.h = parama2.k;
    }
  }
  
  static enum b
  {
    private b() {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aqg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */