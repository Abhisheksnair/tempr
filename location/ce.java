package com.whatsapp.location;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import com.whatsapp.MediaData;
import com.whatsapp.atu;
import com.whatsapp.data.ad;
import com.whatsapp.data.ci;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.l;
import com.whatsapp.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ce
  extends AsyncTask<Void, Void, Boolean>
{
  public static int f = 15;
  private final MediaData a;
  private final ad b;
  private final LocationManager c;
  public final j d;
  public int e = f;
  private final atu g;
  private final bp h;
  private final ci i;
  private Location j;
  private LocationListener k;
  private LocationListener l;
  private int m = 0;
  private Location n = null;
  private Location o = null;
  private boolean p;
  
  public ce(Context paramContext, ad paramad, atu paramatu, bp parambp, ci paramci, j paramj)
  {
    this.d = paramj;
    this.a = paramj.b();
    this.b = paramad;
    this.g = paramatu;
    this.h = parambp;
    this.i = paramci;
    this.c = ((LocationManager)paramContext.getSystemService("location"));
    if ((paramj.B != 0.0D) && (paramj.C != 0.0D))
    {
      this.j = new Location("");
      this.j.setLatitude(paramj.B);
      this.j.setLongitude(paramj.C);
      this.j.setTime(paramj.n);
      this.p = true;
    }
  }
  
  public static byte[] a(double paramDouble1, double paramDouble2)
  {
    return a(paramDouble1, paramDouble2, f);
  }
  
  private static byte[] a(double paramDouble1, double paramDouble2, int paramInt)
  {
    byte[] arrayOfByte = null;
    Bitmap localBitmap = b(paramDouble1, paramDouble2, paramInt);
    ByteArrayOutputStream localByteArrayOutputStream;
    if (localBitmap != null)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      localBitmap.compress(Bitmap.CompressFormat.JPEG, 80, localByteArrayOutputStream);
      arrayOfByte = localByteArrayOutputStream.toByteArray();
    }
    try
    {
      localByteArrayOutputStream.close();
      localBitmap.recycle();
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  private static Bitmap b(double paramDouble1, double paramDouble2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: iconst_0
    //   4: istore 6
    //   6: iconst_0
    //   7: istore 5
    //   9: new 152	org/apache/http/params/BasicHttpParams
    //   12: dup
    //   13: invokespecial 153	org/apache/http/params/BasicHttpParams:<init>	()V
    //   16: astore 8
    //   18: aload 8
    //   20: sipush 15000
    //   23: invokestatic 159	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   26: aload 8
    //   28: sipush 30000
    //   31: invokestatic 162	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   34: new 164	org/apache/http/impl/client/DefaultHttpClient
    //   37: dup
    //   38: aload 8
    //   40: invokespecial 167	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   43: astore 13
    //   45: aload 13
    //   47: new 169	org/apache/http/client/methods/HttpGet
    //   50: dup
    //   51: new 171	java/lang/StringBuilder
    //   54: dup
    //   55: ldc -83
    //   57: invokespecial 174	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: dload_0
    //   61: invokevirtual 178	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   64: ldc -76
    //   66: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: dload_2
    //   70: invokevirtual 178	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   73: ldc -71
    //   75: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: bipush 21
    //   80: iconst_1
    //   81: iload 4
    //   83: invokestatic 191	java/lang/Math:max	(II)I
    //   86: invokestatic 194	java/lang/Math:min	(II)I
    //   89: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: ldc -57
    //   94: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: dload_0
    //   98: invokevirtual 178	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   101: ldc -76
    //   103: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: dload_2
    //   107: invokevirtual 178	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   110: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokespecial 204	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   116: invokevirtual 208	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   119: invokeinterface 214 1 0
    //   124: invokeinterface 220 1 0
    //   129: astore 8
    //   131: aload 8
    //   133: aconst_null
    //   134: getstatic 225	com/whatsapp/util/MediaFileUtils:b	Landroid/graphics/BitmapFactory$Options;
    //   137: invokestatic 231	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   140: astore 9
    //   142: aload 9
    //   144: ifnull +29 -> 173
    //   147: aload 9
    //   149: invokevirtual 235	android/graphics/Bitmap:getWidth	()I
    //   152: sipush 170
    //   155: if_icmpne +18 -> 173
    //   158: aload 9
    //   160: invokevirtual 238	android/graphics/Bitmap:getHeight	()I
    //   163: istore 7
    //   165: iload 7
    //   167: sipush 170
    //   170: if_icmpeq +347 -> 517
    //   173: new 122	java/io/IOException
    //   176: dup
    //   177: ldc -16
    //   179: invokespecial 241	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   182: athrow
    //   183: astore 10
    //   185: iconst_1
    //   186: istore 5
    //   188: new 171	java/lang/StringBuilder
    //   191: dup
    //   192: ldc -13
    //   194: invokespecial 174	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   197: aload 10
    //   199: invokevirtual 244	java/io/IOException:toString	()Ljava/lang/String;
    //   202: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 249	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   211: aload 9
    //   213: ifnull +13 -> 226
    //   216: aload 9
    //   218: ifnull +8 -> 226
    //   221: aload 9
    //   223: invokevirtual 150	android/graphics/Bitmap:recycle	()V
    //   226: aload 8
    //   228: ifnull +8 -> 236
    //   231: aload 8
    //   233: invokevirtual 252	java/io/InputStream:close	()V
    //   236: aconst_null
    //   237: astore 10
    //   239: aload 8
    //   241: astore 9
    //   243: aload 10
    //   245: astore 8
    //   247: aload 8
    //   249: astore 12
    //   251: aload 8
    //   253: ifnonnull +261 -> 514
    //   256: aload 8
    //   258: astore 12
    //   260: iload 5
    //   262: ifeq +252 -> 514
    //   265: aload 8
    //   267: astore 10
    //   269: aload 9
    //   271: astore 11
    //   273: aload 13
    //   275: new 169	org/apache/http/client/methods/HttpGet
    //   278: dup
    //   279: new 171	java/lang/StringBuilder
    //   282: dup
    //   283: ldc -2
    //   285: invokespecial 174	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   288: dload_0
    //   289: invokevirtual 178	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   292: ldc -76
    //   294: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: dload_2
    //   298: invokevirtual 178	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   301: ldc_w 256
    //   304: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: bipush 21
    //   309: iconst_1
    //   310: iload 4
    //   312: invokestatic 191	java/lang/Math:max	(II)I
    //   315: invokestatic 194	java/lang/Math:min	(II)I
    //   318: invokevirtual 197	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   321: ldc_w 258
    //   324: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: dload_0
    //   328: invokevirtual 178	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   331: ldc -76
    //   333: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: dload_2
    //   337: invokevirtual 178	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   340: ldc_w 260
    //   343: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: getstatic 265	com/whatsapp/aut:o	Ljava/lang/String;
    //   349: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokespecial 204	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   358: invokevirtual 208	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   361: invokeinterface 214 1 0
    //   366: invokeinterface 220 1 0
    //   371: astore 13
    //   373: aload 8
    //   375: astore 10
    //   377: aload 13
    //   379: astore 11
    //   381: aload 13
    //   383: astore 9
    //   385: aload 13
    //   387: aconst_null
    //   388: getstatic 225	com/whatsapp/util/MediaFileUtils:b	Landroid/graphics/BitmapFactory$Options;
    //   391: invokestatic 231	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   394: astore 8
    //   396: aload 8
    //   398: ifnull +47 -> 445
    //   401: aload 8
    //   403: astore 10
    //   405: aload 13
    //   407: astore 11
    //   409: aload 13
    //   411: astore 9
    //   413: aload 8
    //   415: invokevirtual 235	android/graphics/Bitmap:getWidth	()I
    //   418: bipush 100
    //   420: if_icmpne +25 -> 445
    //   423: aload 8
    //   425: astore 10
    //   427: aload 13
    //   429: astore 11
    //   431: aload 13
    //   433: astore 9
    //   435: aload 8
    //   437: invokevirtual 238	android/graphics/Bitmap:getHeight	()I
    //   440: bipush 100
    //   442: if_icmpeq +198 -> 640
    //   445: aload 8
    //   447: astore 10
    //   449: aload 13
    //   451: astore 11
    //   453: aload 13
    //   455: astore 9
    //   457: new 122	java/io/IOException
    //   460: dup
    //   461: ldc -16
    //   463: invokespecial 241	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   466: athrow
    //   467: astore 8
    //   469: aload 11
    //   471: astore 9
    //   473: new 171	java/lang/StringBuilder
    //   476: dup
    //   477: ldc -13
    //   479: invokespecial 174	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   482: aload 8
    //   484: invokevirtual 244	java/io/IOException:toString	()Ljava/lang/String;
    //   487: invokevirtual 183	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 203	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 249	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   496: aload 10
    //   498: astore 12
    //   500: aload 11
    //   502: ifnull +12 -> 514
    //   505: aload 11
    //   507: invokevirtual 252	java/io/InputStream:close	()V
    //   510: aload 10
    //   512: astore 12
    //   514: aload 12
    //   516: areturn
    //   517: aload 9
    //   519: bipush 35
    //   521: bipush 35
    //   523: bipush 100
    //   525: bipush 100
    //   527: invokestatic 269	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIII)Landroid/graphics/Bitmap;
    //   530: astore 10
    //   532: aload 9
    //   534: ifnull +15 -> 549
    //   537: aload 9
    //   539: aload 10
    //   541: if_acmpeq +8 -> 549
    //   544: aload 9
    //   546: invokevirtual 150	android/graphics/Bitmap:recycle	()V
    //   549: aload 8
    //   551: ifnull +8 -> 559
    //   554: aload 8
    //   556: invokevirtual 252	java/io/InputStream:close	()V
    //   559: aload 8
    //   561: astore 9
    //   563: aload 10
    //   565: astore 8
    //   567: iload 6
    //   569: istore 5
    //   571: goto -324 -> 247
    //   574: astore 9
    //   576: aload 8
    //   578: astore 9
    //   580: aload 10
    //   582: astore 8
    //   584: iload 6
    //   586: istore 5
    //   588: goto -341 -> 247
    //   591: astore 9
    //   593: aconst_null
    //   594: astore 10
    //   596: aload 8
    //   598: astore 9
    //   600: aload 10
    //   602: astore 8
    //   604: goto -357 -> 247
    //   607: astore 9
    //   609: aconst_null
    //   610: astore 8
    //   612: aload 10
    //   614: ifnull +13 -> 627
    //   617: aload 10
    //   619: ifnull +8 -> 627
    //   622: aload 10
    //   624: invokevirtual 150	android/graphics/Bitmap:recycle	()V
    //   627: aload 8
    //   629: ifnull +8 -> 637
    //   632: aload 8
    //   634: invokevirtual 252	java/io/InputStream:close	()V
    //   637: aload 9
    //   639: athrow
    //   640: aload 8
    //   642: astore 12
    //   644: aload 13
    //   646: ifnull -132 -> 514
    //   649: aload 13
    //   651: invokevirtual 252	java/io/InputStream:close	()V
    //   654: aload 8
    //   656: areturn
    //   657: astore 9
    //   659: aload 8
    //   661: areturn
    //   662: astore 8
    //   664: aload 9
    //   666: ifnull +8 -> 674
    //   669: aload 9
    //   671: invokevirtual 252	java/io/InputStream:close	()V
    //   674: aload 8
    //   676: athrow
    //   677: astore 8
    //   679: goto -42 -> 637
    //   682: astore 8
    //   684: aload 10
    //   686: areturn
    //   687: astore 9
    //   689: goto -15 -> 674
    //   692: astore 9
    //   694: goto -82 -> 612
    //   697: astore 11
    //   699: aload 9
    //   701: astore 10
    //   703: aload 11
    //   705: astore 9
    //   707: goto -95 -> 612
    //   710: astore 11
    //   712: aload 9
    //   714: astore 10
    //   716: aload 11
    //   718: astore 9
    //   720: goto -108 -> 612
    //   723: astore 10
    //   725: aconst_null
    //   726: astore 9
    //   728: aconst_null
    //   729: astore 8
    //   731: goto -543 -> 188
    //   734: astore 10
    //   736: aconst_null
    //   737: astore 9
    //   739: goto -551 -> 188
    //   742: astore 10
    //   744: goto -556 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	747	0	paramDouble1	double
    //   0	747	2	paramDouble2	double
    //   0	747	4	paramInt	int
    //   7	580	5	i1	int
    //   4	581	6	i2	int
    //   163	8	7	i3	int
    //   16	430	8	localObject1	Object
    //   467	93	8	localIOException1	IOException
    //   565	95	8	localObject2	Object
    //   662	13	8	localObject3	Object
    //   677	1	8	localIOException2	IOException
    //   682	1	8	localIOException3	IOException
    //   729	1	8	localObject4	Object
    //   140	422	9	localObject5	Object
    //   574	1	9	localIOException4	IOException
    //   578	1	9	localObject6	Object
    //   591	1	9	localIOException5	IOException
    //   598	1	9	localObject7	Object
    //   607	31	9	localObject8	Object
    //   657	13	9	localIOException6	IOException
    //   687	1	9	localIOException7	IOException
    //   692	8	9	localObject9	Object
    //   705	33	9	localObject10	Object
    //   1	1	10	localObject11	Object
    //   183	15	10	localIOException8	IOException
    //   237	478	10	localObject12	Object
    //   723	1	10	localIOException9	IOException
    //   734	1	10	localIOException10	IOException
    //   742	1	10	localIOException11	IOException
    //   271	235	11	localObject13	Object
    //   697	7	11	localObject14	Object
    //   710	7	11	localObject15	Object
    //   249	394	12	localObject16	Object
    //   43	607	13	localObject17	Object
    // Exception table:
    //   from	to	target	type
    //   173	183	183	java/io/IOException
    //   273	373	467	java/io/IOException
    //   385	396	467	java/io/IOException
    //   413	423	467	java/io/IOException
    //   435	445	467	java/io/IOException
    //   457	467	467	java/io/IOException
    //   554	559	574	java/io/IOException
    //   231	236	591	java/io/IOException
    //   45	131	607	finally
    //   649	654	657	java/io/IOException
    //   273	373	662	finally
    //   385	396	662	finally
    //   413	423	662	finally
    //   435	445	662	finally
    //   457	467	662	finally
    //   473	496	662	finally
    //   632	637	677	java/io/IOException
    //   505	510	682	java/io/IOException
    //   669	674	687	java/io/IOException
    //   131	142	692	finally
    //   147	165	697	finally
    //   173	183	697	finally
    //   517	532	697	finally
    //   188	211	710	finally
    //   45	131	723	java/io/IOException
    //   131	142	734	java/io/IOException
    //   147	165	742	java/io/IOException
    //   517	532	742	java/io/IOException
  }
  
  public Boolean a(Void... paramVarArgs)
  {
    int i1;
    if (this.j == null) {
      i1 = 0;
    }
    for (;;)
    {
      if ((!this.p) && (i1 < 40)) {}
      try
      {
        Thread.sleep(250L);
        i1 += 1;
        continue;
        if (this.p) {}
        for (this.j = this.n;; this.j = this.o)
        {
          paramVarArgs = a(this.j.getLatitude(), this.j.getLongitude(), this.e);
          this.d.f().a(paramVarArgs);
          return Boolean.valueOf(true);
          if (this.o == null) {
            break;
          }
          Log.i("mapdownload/coarseLocation " + this.o.toString());
        }
        Log.i("mapdownload/failed/retry");
        return Boolean.valueOf(false);
      }
      catch (InterruptedException paramVarArgs)
      {
        for (;;) {}
      }
    }
  }
  
  public void onPreExecute()
  {
    if (this.k == null) {
      this.k = new LocationListener()
      {
        public final void onLocationChanged(Location paramAnonymousLocation)
        {
          Log.d("mapdownload/fine listener called. time diff:" + (System.currentTimeMillis() - paramAnonymousLocation.getTime()) / 1000L + " accuracy:" + paramAnonymousLocation.getAccuracy());
          ce.a(ce.this);
          ce.a(ce.this, paramAnonymousLocation);
          if ((ce.b(ce.this) >= 2) || (paramAnonymousLocation.getAccuracy() < 200.0F))
          {
            Log.d("mapdownload/fine/location_ready");
            ce.c(ce.this);
            ce.d(ce.this);
          }
        }
        
        public final void onProviderDisabled(String paramAnonymousString)
        {
          Log.d("mapdownload/fine/disabled");
        }
        
        public final void onProviderEnabled(String paramAnonymousString)
        {
          Log.d("mapdownload/fine/enabled");
        }
        
        public final void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          Log.d("mapdownload/fine/changed/status " + paramAnonymousInt + " provider=" + paramAnonymousString);
        }
      };
    }
    if (this.l == null) {
      this.l = new LocationListener()
      {
        public final void onLocationChanged(Location paramAnonymousLocation)
        {
          Log.d("mapdownload/coarse listener called. time diff:" + (System.currentTimeMillis() - paramAnonymousLocation.getTime()) / 1000L + " accuracy:" + paramAnonymousLocation.getAccuracy());
          ce.b(ce.this, paramAnonymousLocation);
        }
        
        public final void onProviderDisabled(String paramAnonymousString) {}
        
        public final void onProviderEnabled(String paramAnonymousString) {}
        
        public final void onStatusChanged(String paramAnonymousString, int paramAnonymousInt, Bundle paramAnonymousBundle) {}
      };
    }
    try
    {
      if (this.g.a("android.permission.ACCESS_FINE_LOCATION") == 0) {
        this.c.requestLocationUpdates("gps", 1000L, 1.0F, this.k);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      try
      {
        for (;;)
        {
          if (this.g.a("android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.c.requestLocationUpdates("network", 1000L, 1.0F, this.l);
          }
          this.a.transferring = true;
          this.b.f(this.d, -1);
          return;
          localIllegalArgumentException1 = localIllegalArgumentException1;
          Log.w("mapdownload/fine/error " + localIllegalArgumentException1.toString());
          this.k = null;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        for (;;)
        {
          Log.w("mapdownload/coarse/error " + localIllegalArgumentException2.toString());
          this.l = null;
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/location/ce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */