package com.whatsapp;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.whatsapp.doodle.a.b;
import com.whatsapp.k.d;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils.a;
import com.whatsapp.util.MediaFileUtils.c;
import com.whatsapp.util.MediaFileUtils.f;
import com.whatsapp.util.af;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.util.Arrays;

@TargetApi(16)
public final class aqe
  implements xf
{
  public static final int[] j;
  private static int k;
  private static String l;
  private static final int t;
  private static final byte[] u;
  float a = 3.0F;
  File b;
  protected File c;
  b d;
  xf.a e;
  boolean f;
  aqh g;
  a h;
  byte[] i;
  private int m = 640;
  private File n;
  private File o;
  private long p;
  private long q;
  private long r;
  private long s;
  private final com.whatsapp.util.a.c v;
  
  static
  {
    if (av.k()) {}
    for (int i1 = 5;; i1 = 0)
    {
      t = i1;
      u = new byte[] { 102, 116, 121, 112 };
      j = new int[] { 19, 20, 21, 39, 2141391872, 2130706688, 25, 2141391876, 2130706433, 2141391875, 2141391873, 11, 2130706944 };
      return;
    }
  }
  
  public aqe(com.whatsapp.util.a.c paramc, File paramFile1, File paramFile2, long paramLong1, long paramLong2)
  {
    this.v = paramc;
    this.b = paramFile1;
    this.c = paramFile2;
    this.p = paramLong1;
    this.q = paramLong2;
    if ((paramLong1 >= 0L) && (paramLong2 > 0L) && (paramLong1 == paramLong2)) {
      throw new IllegalArgumentException("timeFrom:" + paramLong1 + " timeTo:" + paramLong2);
    }
  }
  
  public static int a()
  {
    for (;;)
    {
      Object localObject4;
      int i2;
      int i3;
      try
      {
        if (k == 0)
        {
          if (Build.VERSION.SDK_INT < 16) {
            break label284;
          }
          if (!g())
          {
            i1 = 1;
            localObject4 = null;
            localObject1 = null;
            if (i1 == 0) {
              continue;
            }
            i1 = c.c;
            Log.w("videotranscoder/istranscodesupported/unsupported model " + Build.MANUFACTURER + "-" + Build.MODEL);
            f((String)localObject1);
            k = i1;
          }
        }
        else
        {
          i1 = k;
          return i1;
        }
        i1 = 0;
        continue;
        int i4 = MediaCodecList.getCodecCount();
        Log.i("videotranscoder/istranscodesupported/number of codecs: " + i4);
        i2 = 0;
        i1 = 0;
        Object localObject1 = localObject4;
        if ((i2 < i4) && (i1 == 0))
        {
          MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i2);
          i3 = i1;
          localObject4 = localObject1;
          if (!localMediaCodecInfo.isEncoder()) {
            break label298;
          }
          i3 = i1;
          localObject4 = localObject1;
          if (!a(localMediaCodecInfo.getName())) {
            break label298;
          }
          localObject4 = localMediaCodecInfo.getSupportedTypes();
          i3 = 0;
          if ((i3 < localObject4.length) && (i1 == 0))
          {
            if (!localObject4[i3].equals("video/avc")) {
              break label291;
            }
            i1 = 1;
            break label291;
          }
          i3 = i1;
          localObject4 = localObject1;
          if (i1 == 0) {
            break label298;
          }
          localObject4 = localMediaCodecInfo.getName();
          Log.i("videotranscoder/istranscodesupported/found " + localMediaCodecInfo.getName());
          i3 = i1;
          break label298;
        }
        if (i1 != 0)
        {
          i1 = c.a;
          continue;
        }
        i1 = c.d;
        Log.w("videotranscoder/istranscodesupported/no encoder found");
        continue;
        i1 = c.b;
      }
      finally {}
      label284:
      continue;
      label291:
      i3 += 1;
      continue;
      label298:
      i2 += 1;
      int i1 = i3;
      Object localObject3 = localObject4;
    }
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 1: 
      return 2;
    case 2: 
      return 1;
    case 3: 
      return 4;
    }
    return 3;
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt2 / 2 + paramInt1 - 1 & (paramInt2 - 1 ^ 0xFFFFFFFF);
  }
  
  public static int a(MediaCodecInfo paramMediaCodecInfo)
  {
    int i1 = 0;
    MediaCodecInfo.CodecCapabilities localCodecCapabilities = paramMediaCodecInfo.getCapabilitiesForType("video/avc");
    Log.i("videotranscoder/transcode/color formats: " + localCodecCapabilities.colorFormats.length);
    int i2 = 0;
    if ((i1 < localCodecCapabilities.colorFormats.length) && (i2 == 0))
    {
      int i3 = localCodecCapabilities.colorFormats[i1];
      switch (i3)
      {
      default: 
        Log.i("videotranscoder/transcode/skipping unsupported color format " + i3);
      }
      for (;;)
      {
        i1 += 1;
        break;
        if ((!"OMX.SEC.avc.enc".equals(paramMediaCodecInfo.getName())) || (i3 != 19)) {
          i2 = i3;
        } else {
          Log.i("videotranscoder/transcode/skipping " + i3 + " for OMX.SEC.avc.enc");
        }
      }
    }
    return i2;
  }
  
  public static a a(MediaFormat paramMediaFormat, String paramString)
  {
    return a(paramMediaFormat, paramString, null);
  }
  
  private static a a(MediaFormat paramMediaFormat, String paramString, aqh paramaqh)
  {
    Log.i("videotranscoder/transcode/getDecoderFormat output format has changed to " + paramMediaFormat);
    a locala = new a();
    locala.j = paramString;
    locala.a = paramMediaFormat.getInteger("color-format");
    locala.b = paramMediaFormat.getInteger("width");
    locala.c = paramMediaFormat.getInteger("height");
    try
    {
      locala.f = paramMediaFormat.getInteger("crop-left");
      try
      {
        locala.g = paramMediaFormat.getInteger("crop-right");
        try
        {
          locala.h = paramMediaFormat.getInteger("crop-top");
          try
          {
            locala.i = paramMediaFormat.getInteger("crop-bottom");
            try
            {
              locala.e = paramMediaFormat.getInteger("slice-height");
              if (paramString.startsWith("OMX.Nvidia.")) {
                locala.e = b(locala.c, 16);
              }
              try
              {
                locala.d = paramMediaFormat.getInteger("stride");
                if ((Build.VERSION.SDK_INT < 21) && (locala.i == 1079) && (locala.c == 1088) && (c(paramString)))
                {
                  Log.i("videotranscoder/transcode/decoder workaround samsung incorrect height");
                  locala.c = 1080;
                }
                f(paramString);
                int i1;
                if (paramaqh != null)
                {
                  i1 = locala.a;
                  if ((paramaqh.b != null) && (paramString != null) && (i1 > 0) && (paramaqh.d > 0) && (paramaqh.d > 0) && (paramaqh.b.equals(paramString)) && (paramaqh.d == i1))
                  {
                    i1 = 1;
                    label277:
                    if (i1 == 0) {
                      break label354;
                    }
                    Log.i("videotranscoder/parseDecoderFormat/forcing frame convert color id=" + paramaqh.f);
                    locala.k = paramaqh.f;
                  }
                }
                label354:
                do
                {
                  return locala;
                  if (!paramString.equalsIgnoreCase("OMX.SEC.avc.dec")) {
                    break;
                  }
                  locala.e = locala.c;
                  locala.d = locala.b;
                  break;
                  i1 = 0;
                  break label277;
                  locala.k = b(locala.a);
                  if ((locala.a == 25) && (d(paramString)))
                  {
                    Log.i("videotranscoder/transcode/decoder color format for Huaiwei is VideoFrameConverter.FRAMECONV_COLOR_FORMAT_NV12");
                    locala.k = 3;
                    return locala;
                  }
                  if (locala.a == 2141391876)
                  {
                    locala.k = 3;
                    return locala;
                  }
                } while ((locala.a != 2130706433) || ((l != null) && (l.toLowerCase().startsWith("mt6589"))));
                locala.k = 1;
                return locala;
              }
              catch (Exception paramMediaFormat)
              {
                for (;;) {}
              }
            }
            catch (Exception localException1)
            {
              for (;;) {}
            }
          }
          catch (Exception localException2)
          {
            for (;;) {}
          }
        }
        catch (Exception localException3)
        {
          for (;;) {}
        }
      }
      catch (Exception localException4)
      {
        for (;;) {}
      }
    }
    catch (Exception localException5)
    {
      for (;;) {}
    }
  }
  
  public static a a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return a(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, null);
  }
  
  public static a a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, aqh paramaqh)
  {
    a locala = new a(paramInt1, paramInt2, paramInt3);
    locala.j = paramString;
    paramInt6 = b(paramInt6, paramInt4);
    paramInt5 = b(paramInt5, paramInt4);
    float f1 = paramInt2 / (paramInt3 + 0.0F);
    b localb;
    int i1;
    if ((locala.b >= paramInt5) && (locala.c >= paramInt6))
    {
      localb = b.a;
      if (localb != b.a)
      {
        if (localb != b.c) {
          break label668;
        }
        i1 = locala.c;
        locala.c = paramInt6;
        locala.b = ((int)(locala.b + f1 * (paramInt6 - i1)));
        locala.b = a(locala.b, paramInt4);
        locala.b = Math.max(locala.b, paramInt5);
        label152:
        Log.i("videotranscoder/transcode/encoder parseEncoderFormat expand direction is " + localb + ", input size: " + paramInt2 + "x" + paramInt3 + ", after expansion: " + locala.b + "x" + locala.c);
      }
      locala.c = a(locala.c, paramInt4);
      locala.b = a(locala.b, paramInt4);
      if ((paramString.equals("OMX.MTK.VIDEO.ENCODER.AVC")) && (Build.MANUFACTURER.equals("motorola")) && (Build.VERSION.SDK_INT < 18) && (locala.b * locala.c > 306176))
      {
        paramInt2 = locala.b;
        paramInt3 = locala.c;
        locala.b = ((int)(Math.sqrt(306176.0D / (paramInt2 * paramInt3)) * paramInt2));
        double d1 = Math.sqrt(306176.0D / (paramInt2 * paramInt3));
        locala.c = ((int)(paramInt3 * d1));
        locala.b &= 0xFFFFFFF0;
        locala.c &= 0xFFFFFFF8;
        Log.i("videotranscoder/transcode/force frame dimensions for motorola to " + locala.b + "x" + locala.c);
      }
      locala.d = locala.b;
      locala.e = locala.c;
      if (paramString.startsWith("OMX.Nvidia."))
      {
        locala.d = ((locala.d + 15) / 16 << 4);
        locala.e = ((locala.e + 15) / 16 << 4);
      }
      f(paramString);
      if (paramaqh == null) {
        break label742;
      }
      if ((paramaqh.a == null) || (paramString == null) || (paramInt1 <= 0) || (paramaqh.c <= 0) || (paramaqh.c <= 0) || (!paramaqh.a.equals(paramString)) || (paramaqh.c != paramInt1)) {
        break label737;
      }
      paramInt2 = 1;
      label548:
      if (paramInt2 == 0) {
        break label742;
      }
      Log.i("videotranscoder/parseEncoderFormat/forcing frame conver color id=" + paramaqh.e);
      locala.k = paramaqh.e;
    }
    label668:
    label737:
    label742:
    do
    {
      return locala;
      if ((locala.b >= paramInt5) || (locala.c < paramInt6))
      {
        if ((locala.b >= paramInt5) && (locala.c < paramInt6))
        {
          localb = b.c;
          break;
        }
        if (f1 > paramInt5 / (paramInt6 + 0.0F))
        {
          localb = b.c;
          break;
        }
      }
      localb = b.b;
      break;
      i1 = locala.b;
      locala.b = paramInt5;
      locala.c = ((int)(locala.c + (paramInt5 - i1) / f1));
      locala.c = a(locala.c, paramInt4);
      locala.c = Math.max(locala.c, paramInt6);
      break label152;
      paramInt2 = 0;
      break label548;
      locala.k = b(paramInt1);
      if ((Build.VERSION.SDK_INT == 16) && (locala.a == 21) && (!Build.MODEL.equals("GT-N7000")) && (!Build.MODEL.equals("SAMSUNG-SGH-I777")) && (!Build.MODEL.startsWith("GT-I9100")) && (!Build.MODEL.startsWith("SHV-E210")) && ("OMX.SEC.avc.enc".equals(paramString)))
      {
        locala.k = 4;
        Log.i("videotranscoder/transcode/encoder workaround wrong color format for samsung to FRAMECONV_COLOR_FORMAT_NV21");
        return locala;
      }
      if (((Build.VERSION.SDK_INT == 16) || (Build.VERSION.SDK_INT == 17)) && (paramInt1 == 21) && (d(paramString)))
      {
        locala.k = 4;
        Log.i("videotranscoder/transcode/encoder workaround wrong color format for huawei to FRAMECONV_COLOR_FORMAT_NV21");
        return locala;
      }
    } while ((l == null) || (!l.toLowerCase().startsWith("mt6572")));
    locala.k = 2;
    Log.i("workaround wrong color format for mt6572 to FRAMECONV_COLOR_FORMAT_YV12");
    return locala;
  }
  
  private void a(MediaCodec paramMediaCodec, ByteBuffer[] paramArrayOfByteBuffer, VideoFrameConverter paramVideoFrameConverter, pi parampi, ByteBuffer paramByteBuffer, int paramInt1, long paramLong, int paramInt2)
  {
    Log.i("videotranscoder/handleLastFrame/" + paramInt1);
    int i2 = paramMediaCodec.dequeueInputBuffer(1000000L);
    paramArrayOfByteBuffer = paramArrayOfByteBuffer[i2];
    paramArrayOfByteBuffer.clear();
    paramVideoFrameConverter.a(paramByteBuffer, paramArrayOfByteBuffer);
    int i1 = parampi.a(paramInt1);
    paramInt1 = i1;
    if (i1 < 70) {
      paramInt1 = 70;
    }
    paramLong += paramInt1 * 1000;
    paramMediaCodec.queueInputBuffer(i2, 0, paramInt2, paramLong, 4);
    this.s += 1L;
    this.r = (paramLong - this.p * 1000L);
  }
  
  public static void a(vv paramvv, File paramFile)
  {
    try
    {
      Mp4Ops.a(paramvv, paramFile);
      Mp4Ops.a("checkAndRepair", "repair");
      return;
    }
    catch (Mp4Ops.a paramvv)
    {
      Mp4Ops.a("checkAndRepair", "repair", paramvv);
      throw paramvv;
    }
    catch (IOException paramvv)
    {
      Log.d("videotranscoder/repair/io-exception/", paramvv);
      throw paramvv;
    }
  }
  
  public static boolean a(File paramFile)
  {
    return (b(paramFile)) || (a() == c.a);
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    while ((paramString.equals("OMX.google.h264.encoder")) || (paramString.equals("OMX.ST.VFM.H264Enc")) || (paramString.equals("OMX.Exynos.avc.enc")) || ((paramString.equals("OMX.MARVELL.VIDEO.HW.CODA7542ENCODER")) && (Build.VERSION.SDK_INT < 21)) || (paramString.equals("OMX.MARVELL.VIDEO.H264ENCODER"))) {
      return false;
    }
    if ((paramString.equals("OMX.MTK.VIDEO.ENCODER.AVC")) && ("QMobile".equalsIgnoreCase(Build.MANUFACTURER)))
    {
      Log.i("videotranscoder/ OMX.MTK.VIDEO.ENCODER.AVC on QMobile is not supported");
      return false;
    }
    if ((paramString.equals("OMX.allwinner.video.encoder.avc")) || (paramString.equals("AVCEncoder")))
    {
      Log.i("videotranscoder/ " + paramString + " not supported");
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString, String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {}
    for (;;)
    {
      return false;
      paramString = paramString.toLowerCase();
      int i2 = paramArrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        if (paramString.startsWith(paramArrayOfString[i1].toLowerCase())) {
          return true;
        }
        i1 += 1;
      }
    }
  }
  
  public static int[] a(String paramString, int paramInt)
  {
    int i1 = paramInt;
    if (paramInt <= 0) {
      if (!paramString.equals("OMX.MTK.VIDEO.ENCODER.AVC"))
      {
        i1 = paramInt;
        if (!paramString.equals("OMX.MTK.VIDEO.DECODER.AVC")) {}
      }
      else
      {
        i1 = 2130706944;
      }
    }
    if (i1 <= 0) {
      return j;
    }
    paramString = new int[j.length];
    paramString[0] = i1;
    paramInt = 1;
    while (paramInt < paramString.length)
    {
      paramString[paramInt] = j[(paramInt - 1)];
      if (paramString[paramInt] == i1) {
        paramString[paramInt] = 0;
      }
      paramInt += 1;
    }
    return paramString;
  }
  
  private static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 19: 
    case 20: 
    default: 
      return 1;
    case 11: 
      return 7;
    case 21: 
    case 39: 
    case 2130706688: 
    case 2141391873: 
    case 2141391876: 
      return 3;
    case 2141391872: 
      return 4;
    case 2141391875: 
      return 5;
    case 2130706433: 
      return 6;
    }
    return 2;
  }
  
  private static int b(int paramInt1, int paramInt2)
  {
    return paramInt1 + paramInt2 - 1 & (paramInt2 - 1 ^ 0xFFFFFFFF);
  }
  
  public static int b(String paramString)
  {
    if (paramString.equals("OMX.qcom.video.encoder.avc")) {
      return 32;
    }
    return 16;
  }
  
  private static boolean b(File paramFile)
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      byte[] arrayOfByte = new byte[4];
      localFileInputStream.skip(4L);
      localFileInputStream.read(arrayOfByte);
      localFileInputStream.close();
      if (!Arrays.equals(arrayOfByte, u))
      {
        Log.w("videotranscoder/isisomedia/" + paramFile.getAbsolutePath() + " is not iso base media container");
        return false;
      }
      return true;
    }
    catch (IOException paramFile)
    {
      Log.w("videotranscoder/isisomedia/" + paramFile.toString());
    }
    return false;
  }
  
  private static boolean c(String paramString)
  {
    return ("OMX.SEC.avc.enc".equals(paramString)) || ("OMX.SEC.avc.dec".equals(paramString)) || ("OMX.Exynos.AVC.Encoder".equals(paramString)) || ("OMX.Exynos.AVC.Decoder".equals(paramString));
  }
  
  private static boolean d(String paramString)
  {
    return ("OMX.k3.video.encoder.avc".equals(paramString)) || ("OMX.k3.video.decoder.avc".equals(paramString));
  }
  
  public static MediaCodecInfo e()
  {
    int i4 = MediaCodecList.getCodecCount();
    Object localObject = null;
    Log.i("videotranscoder/transcode/number of codecs: " + i4);
    int i1 = 0;
    if ((i1 < i4) && (localObject == null))
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i1);
      if ((!localMediaCodecInfo.isEncoder()) || (!a(localMediaCodecInfo.getName()))) {
        break label125;
      }
      String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
      int i2 = 0;
      int i3 = 0;
      while ((i2 < arrayOfString.length) && (i3 == 0))
      {
        if (arrayOfString[i2].equals("video/avc")) {
          i3 = 1;
        }
        i2 += 1;
      }
      if (i3 == 0) {
        break label125;
      }
      localObject = localMediaCodecInfo;
    }
    label125:
    for (;;)
    {
      i1 += 1;
      break;
      return (MediaCodecInfo)localObject;
    }
  }
  
  private static String e(String paramString)
  {
    try
    {
      Process localProcess = new ProcessBuilder(new String[] { "/system/bin/getprop", paramString }).redirectErrorStream(true).start();
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
      paramString = "";
      String str;
      Log.w("getsystemproperty/" + localIOException1);
    }
    catch (IOException localIOException1)
    {
      try
      {
        for (;;)
        {
          str = localBufferedReader.readLine();
          if (str == null) {
            break;
          }
          paramString = str;
        }
        localBufferedReader.close();
        localProcess.destroy();
        return paramString;
      }
      catch (IOException localIOException2)
      {
        for (;;) {}
      }
      localIOException1 = localIOException1;
      paramString = "";
    }
    return paramString;
  }
  
  private static void f(String paramString)
  {
    if ((l == null) && ("OMX.MTK.VIDEO.ENCODER.AVC".equals(paramString)))
    {
      paramString = e("ro.board.platform");
      l = paramString;
      if (TextUtils.isEmpty(paramString)) {
        l = e("ro.mediatek.platform");
      }
      Log.i("videotranscoder/setHwBoardPlatform/board/" + l);
    }
  }
  
  public static boolean g()
  {
    if ((Build.VERSION.SDK_INT == 16) && (Build.MANUFACTURER.equals("samsung")) && ((Build.MODEL.equals("GT-P3100")) || (Build.MODEL.equals("GT-P3110")) || (Build.MODEL.equals("GT-P3113")) || (Build.MODEL.equals("GT-P5100")) || (Build.MODEL.equals("GT-P5110")) || (Build.MODEL.equals("GT-P5113")) || (Build.MODEL.equals("GT-I9100G")) || (Build.MODEL.startsWith("GT-I8550")) || (Build.MODEL.startsWith("GT-I8552")) || (Build.MODEL.startsWith("GT-I8262")) || (Build.MODEL.startsWith("GT-I8260")) || (Build.MODEL.startsWith("GT-S6310")) || (Build.MODEL.startsWith("GT-S6312")) || (Build.MODEL.startsWith("GT-S6313")))) {}
    while (((Build.VERSION.SDK_INT == 17) && (Build.MANUFACTURER.equals("samsung")) && ((Build.MODEL.startsWith("GT-S7270")) || (Build.MODEL.startsWith("GT-S7272")) || (Build.MODEL.startsWith("GT-S7273")) || (Build.MODEL.startsWith("GT-S7275")))) || ((Build.MANUFACTURER.equals("bq")) && (Build.DEVICE.startsWith("bq_Aquaris5"))) || ((Build.MANUFACTURER.equals("samsung")) && (Build.MODEL.equals("SM-G386F"))) || ((Build.MANUFACTURER.equals("Fly")) && (Build.MODEL.equals("FS504")))) {
      return false;
    }
    return true;
  }
  
  /* Error */
  private void h()
  {
    // Byte code:
    //   0: ldc_w 620
    //   3: invokestatic 625	com/whatsapp/k/c:a	(Ljava/lang/String;)Lcom/whatsapp/k/d;
    //   6: astore 24
    //   8: aload 24
    //   10: invokeinterface 629 1 0
    //   15: aload_0
    //   16: lconst_0
    //   17: putfield 409	com/whatsapp/aqe:r	J
    //   20: aload_0
    //   21: lconst_0
    //   22: putfield 405	com/whatsapp/aqe:s	J
    //   25: new 397	com/whatsapp/pi
    //   28: dup
    //   29: aload_0
    //   30: getfield 88	com/whatsapp/aqe:b	Ljava/io/File;
    //   33: invokevirtual 496	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   36: invokespecial 630	com/whatsapp/pi:<init>	(Ljava/lang/String;)V
    //   39: astore 26
    //   41: ldc_w 632
    //   44: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   47: aload 26
    //   49: getfield 635	com/whatsapp/pi:a	Lpl/droidsonroids/gif/a;
    //   52: invokevirtual 640	pl/droidsonroids/gif/a:getMinimumWidth	()I
    //   55: istore 5
    //   57: aload 26
    //   59: getfield 635	com/whatsapp/pi:a	Lpl/droidsonroids/gif/a;
    //   62: invokevirtual 643	pl/droidsonroids/gif/a:getMinimumHeight	()I
    //   65: istore 6
    //   67: new 98	java/lang/StringBuilder
    //   70: dup
    //   71: ldc_w 645
    //   74: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   77: iload 5
    //   79: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: ldc_w 334
    //   85: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: iload 6
    //   90: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   99: iload 6
    //   101: istore_3
    //   102: iload 5
    //   104: istore 4
    //   106: iload 4
    //   108: sipush 128
    //   111: if_icmplt +10 -> 121
    //   114: iload_3
    //   115: sipush 128
    //   118: if_icmpge +16 -> 134
    //   121: iload 4
    //   123: iconst_1
    //   124: ishl
    //   125: istore 4
    //   127: iload_3
    //   128: iconst_1
    //   129: ishl
    //   130: istore_3
    //   131: goto -25 -> 106
    //   134: new 98	java/lang/StringBuilder
    //   137: dup
    //   138: ldc_w 647
    //   141: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   144: iload 4
    //   146: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: ldc_w 334
    //   152: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: iload_3
    //   156: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   159: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   165: iload 4
    //   167: iload_3
    //   168: if_icmple +87 -> 255
    //   171: iload 4
    //   173: istore_1
    //   174: iload_3
    //   175: istore_2
    //   176: iload 4
    //   178: aload_0
    //   179: getfield 81	com/whatsapp/aqe:m	I
    //   182: if_icmple +16 -> 198
    //   185: aload_0
    //   186: getfield 81	com/whatsapp/aqe:m	I
    //   189: istore_1
    //   190: iload 6
    //   192: iload_1
    //   193: imul
    //   194: iload 5
    //   196: idiv
    //   197: istore_2
    //   198: new 98	java/lang/StringBuilder
    //   201: dup
    //   202: ldc_w 647
    //   205: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   208: iload_1
    //   209: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: ldc_w 334
    //   215: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: iload_2
    //   219: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   228: invokestatic 649	com/whatsapp/aqe:e	()Landroid/media/MediaCodecInfo;
    //   231: astore 16
    //   233: aload 16
    //   235: ifnonnull +49 -> 284
    //   238: ldc_w 651
    //   241: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   244: new 653	java/io/FileNotFoundException
    //   247: dup
    //   248: ldc_w 655
    //   251: invokespecial 656	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   254: athrow
    //   255: iload 4
    //   257: istore_1
    //   258: iload_3
    //   259: istore_2
    //   260: iload_3
    //   261: aload_0
    //   262: getfield 81	com/whatsapp/aqe:m	I
    //   265: if_icmple -67 -> 198
    //   268: aload_0
    //   269: getfield 81	com/whatsapp/aqe:m	I
    //   272: istore_2
    //   273: iload 5
    //   275: iload_2
    //   276: imul
    //   277: iload 6
    //   279: idiv
    //   280: istore_1
    //   281: goto -83 -> 198
    //   284: new 98	java/lang/StringBuilder
    //   287: dup
    //   288: ldc_w 658
    //   291: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   294: aload 16
    //   296: invokevirtual 172	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   299: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: ldc_w 660
    //   305: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   314: aload 16
    //   316: invokestatic 662	com/whatsapp/aqe:a	(Landroid/media/MediaCodecInfo;)I
    //   319: istore_3
    //   320: iload_3
    //   321: ifne +20 -> 341
    //   324: ldc_w 664
    //   327: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   330: new 653	java/io/FileNotFoundException
    //   333: dup
    //   334: ldc_w 666
    //   337: invokespecial 656	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   340: athrow
    //   341: aload 16
    //   343: invokevirtual 172	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   346: iload_3
    //   347: iload_1
    //   348: iload_2
    //   349: aload 16
    //   351: invokevirtual 172	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   354: invokestatic 668	com/whatsapp/aqe:b	(Ljava/lang/String;)I
    //   357: iconst_0
    //   358: iconst_0
    //   359: aload_0
    //   360: getfield 670	com/whatsapp/aqe:g	Lcom/whatsapp/aqh;
    //   363: invokestatic 313	com/whatsapp/aqe:a	(Ljava/lang/String;IIIIIILcom/whatsapp/aqh;)Lcom/whatsapp/aqe$a;
    //   366: astore 15
    //   368: aload 15
    //   370: getfield 242	com/whatsapp/aqe$a:a	I
    //   373: istore_3
    //   374: aload 15
    //   376: getfield 245	com/whatsapp/aqe$a:b	I
    //   379: istore 4
    //   381: aload 15
    //   383: getfield 248	com/whatsapp/aqe$a:c	I
    //   386: istore 8
    //   388: new 98	java/lang/StringBuilder
    //   391: dup
    //   392: ldc_w 647
    //   395: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   398: iload 4
    //   400: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   403: ldc_w 334
    //   406: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: iload 8
    //   411: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   414: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   420: aload 15
    //   422: getfield 278	com/whatsapp/aqe$a:d	I
    //   425: iconst_2
    //   426: idiv
    //   427: istore 7
    //   429: aload 15
    //   431: getfield 278	com/whatsapp/aqe$a:d	I
    //   434: aload 15
    //   436: getfield 268	com/whatsapp/aqe$a:e	I
    //   439: imul
    //   440: iload 7
    //   442: aload 15
    //   444: getfield 268	com/whatsapp/aqe$a:e	I
    //   447: imul
    //   448: iadd
    //   449: istore 7
    //   451: aload 16
    //   453: invokevirtual 172	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   456: invokestatic 674	android/media/MediaCodec:createByCodecName	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   459: astore 20
    //   461: ldc_w 676
    //   464: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   467: ldc -75
    //   469: iload 4
    //   471: iload 8
    //   473: invokestatic 680	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   476: astore 16
    //   478: aload 16
    //   480: ldc_w 682
    //   483: iload_1
    //   484: iload_2
    //   485: imul
    //   486: iconst_1
    //   487: ishl
    //   488: invokevirtual 686	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   491: aload 16
    //   493: ldc_w 688
    //   496: bipush 15
    //   498: invokevirtual 686	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   501: aload 16
    //   503: ldc -21
    //   505: iload_3
    //   506: invokevirtual 686	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   509: aload 16
    //   511: ldc_w 690
    //   514: bipush 10
    //   516: invokevirtual 686	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   519: aload 16
    //   521: ldc_w 277
    //   524: aload 15
    //   526: getfield 278	com/whatsapp/aqe$a:d	I
    //   529: invokevirtual 686	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   532: aload 16
    //   534: ldc_w 266
    //   537: aload 15
    //   539: getfield 268	com/whatsapp/aqe$a:e	I
    //   542: invokevirtual 686	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   545: new 98	java/lang/StringBuilder
    //   548: dup
    //   549: ldc_w 692
    //   552: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   555: aload 16
    //   557: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   560: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   566: aload 20
    //   568: aload 16
    //   570: aconst_null
    //   571: aconst_null
    //   572: iconst_1
    //   573: invokevirtual 696	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   576: ldc_w 698
    //   579: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   582: aload 20
    //   584: invokevirtual 700	android/media/MediaCodec:start	()V
    //   587: ldc_w 702
    //   590: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   593: aload 15
    //   595: getfield 291	com/whatsapp/aqe$a:k	I
    //   598: istore_1
    //   599: aload 20
    //   601: invokevirtual 706	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   604: astore 27
    //   606: aload 20
    //   608: invokevirtual 709	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   611: astore 15
    //   613: new 711	java/io/FileOutputStream
    //   616: dup
    //   617: aload_0
    //   618: getfield 713	com/whatsapp/aqe:n	Ljava/io/File;
    //   621: invokespecial 714	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   624: astore 25
    //   626: aload 25
    //   628: invokevirtual 718	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   631: astore 21
    //   633: new 720	android/media/MediaCodec$BufferInfo
    //   636: dup
    //   637: invokespecial 721	android/media/MediaCodec$BufferInfo:<init>	()V
    //   640: astore 22
    //   642: iconst_0
    //   643: istore_2
    //   644: new 392	com/whatsapp/VideoFrameConverter
    //   647: dup
    //   648: invokespecial 722	com/whatsapp/VideoFrameConverter:<init>	()V
    //   651: astore 23
    //   653: aload_0
    //   654: getfield 724	com/whatsapp/aqe:d	Lcom/whatsapp/doodle/a/b;
    //   657: ifnull +2016 -> 2673
    //   660: aload_0
    //   661: getfield 724	com/whatsapp/aqe:d	Lcom/whatsapp/doodle/a/b;
    //   664: invokevirtual 728	com/whatsapp/doodle/a/b:f	()Z
    //   667: istore 9
    //   669: iload 4
    //   671: iload 8
    //   673: getstatic 734	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   676: invokestatic 740	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   679: astore 19
    //   681: aload_0
    //   682: getfield 724	com/whatsapp/aqe:d	Lcom/whatsapp/doodle/a/b;
    //   685: aload 19
    //   687: iconst_0
    //   688: invokevirtual 743	com/whatsapp/doodle/a/b:a	(Landroid/graphics/Bitmap;I)V
    //   691: aload 19
    //   693: invokevirtual 746	android/graphics/Bitmap:getWidth	()I
    //   696: aload 19
    //   698: invokevirtual 749	android/graphics/Bitmap:getHeight	()I
    //   701: imul
    //   702: iconst_2
    //   703: ishl
    //   704: invokestatic 753	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   707: astore 18
    //   709: aload 19
    //   711: aload 18
    //   713: invokevirtual 757	android/graphics/Bitmap:copyPixelsToBuffer	(Ljava/nio/Buffer;)V
    //   716: aload 23
    //   718: aload 18
    //   720: aload 19
    //   722: invokevirtual 746	android/graphics/Bitmap:getWidth	()I
    //   725: aload 19
    //   727: invokevirtual 749	android/graphics/Bitmap:getHeight	()I
    //   730: invokevirtual 760	com/whatsapp/VideoFrameConverter:a	(Ljava/nio/ByteBuffer;II)V
    //   733: aload 23
    //   735: bipush 7
    //   737: iload 5
    //   739: iload 6
    //   741: iconst_0
    //   742: iconst_0
    //   743: iload 5
    //   745: iconst_1
    //   746: isub
    //   747: iload 6
    //   749: iconst_1
    //   750: isub
    //   751: iload_1
    //   752: iload 4
    //   754: iload 8
    //   756: invokevirtual 763	com/whatsapp/VideoFrameConverter:a	(IIIIIIIIII)V
    //   759: new 98	java/lang/StringBuilder
    //   762: dup
    //   763: ldc_w 765
    //   766: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   769: iload 5
    //   771: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   774: ldc_w 767
    //   777: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: iload 6
    //   782: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   785: ldc_w 769
    //   788: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: iload 5
    //   793: iconst_1
    //   794: isub
    //   795: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   798: ldc_w 767
    //   801: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: iload 6
    //   806: iconst_1
    //   807: isub
    //   808: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   811: ldc_w 771
    //   814: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: iload_3
    //   818: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   821: ldc_w 773
    //   824: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: iload_1
    //   828: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   831: ldc_w 775
    //   834: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: iload 4
    //   839: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   842: ldc_w 767
    //   845: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: iload 8
    //   850: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   853: ldc_w 777
    //   856: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   862: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   865: aload 15
    //   867: astore 17
    //   869: aload 15
    //   871: astore 16
    //   873: aload 26
    //   875: getfield 635	com/whatsapp/pi:a	Lpl/droidsonroids/gif/a;
    //   878: invokevirtual 779	pl/droidsonroids/gif/a:b	()I
    //   881: istore 8
    //   883: aload 15
    //   885: astore 17
    //   887: aload 15
    //   889: astore 16
    //   891: new 98	java/lang/StringBuilder
    //   894: dup
    //   895: ldc_w 781
    //   898: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   901: iload 8
    //   903: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   906: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   909: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   912: lconst_0
    //   913: lstore 11
    //   915: iconst_0
    //   916: istore_1
    //   917: aload 15
    //   919: astore 17
    //   921: aload 15
    //   923: astore 16
    //   925: iload 5
    //   927: iconst_3
    //   928: imul
    //   929: iload 6
    //   931: imul
    //   932: invokestatic 753	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   935: astore 28
    //   937: iconst_0
    //   938: istore_3
    //   939: iload_3
    //   940: iload 8
    //   942: if_icmpge +1066 -> 2008
    //   945: aload 15
    //   947: astore 17
    //   949: aload 15
    //   951: astore 16
    //   953: aload 26
    //   955: iload_3
    //   956: invokevirtual 399	com/whatsapp/pi:a	(I)I
    //   959: istore 4
    //   961: iload_3
    //   962: ifle +63 -> 1025
    //   965: iload_1
    //   966: iload 4
    //   968: iadd
    //   969: bipush 70
    //   971: if_icmpgt +54 -> 1025
    //   974: iload 4
    //   976: iload_1
    //   977: iadd
    //   978: istore_1
    //   979: iload_3
    //   980: iload 8
    //   982: iconst_1
    //   983: isub
    //   984: if_icmpne +1666 -> 2650
    //   987: aload 15
    //   989: astore 17
    //   991: aload 15
    //   993: astore 16
    //   995: aload_0
    //   996: aload 20
    //   998: aload 27
    //   1000: aload 23
    //   1002: aload 26
    //   1004: aload 28
    //   1006: iload_3
    //   1007: lload 11
    //   1009: iload 7
    //   1011: invokespecial 783	com/whatsapp/aqe:a	(Landroid/media/MediaCodec;[Ljava/nio/ByteBuffer;Lcom/whatsapp/VideoFrameConverter;Lcom/whatsapp/pi;Ljava/nio/ByteBuffer;IJI)V
    //   1014: iload_1
    //   1015: istore 4
    //   1017: iload_2
    //   1018: istore_1
    //   1019: iload 4
    //   1021: istore_2
    //   1022: goto +1636 -> 2658
    //   1025: aload 15
    //   1027: astore 17
    //   1029: aload 15
    //   1031: astore 16
    //   1033: aload 26
    //   1035: aload 28
    //   1037: iload_3
    //   1038: iload 5
    //   1040: iload 6
    //   1042: invokevirtual 786	com/whatsapp/pi:a	(Ljava/nio/ByteBuffer;III)V
    //   1045: iload_3
    //   1046: ifne +1656 -> 2702
    //   1049: lconst_0
    //   1050: lstore 13
    //   1052: lload 13
    //   1054: lstore 11
    //   1056: iload 4
    //   1058: istore_1
    //   1059: iload 4
    //   1061: bipush 70
    //   1063: if_icmpge +10 -> 1073
    //   1066: bipush 70
    //   1068: istore_1
    //   1069: lload 13
    //   1071: lstore 11
    //   1073: aload 15
    //   1075: astore 17
    //   1077: aload 15
    //   1079: astore 16
    //   1081: iload_3
    //   1082: getstatic 59	com/whatsapp/aqe:t	I
    //   1085: if_icmpge +31 -> 1116
    //   1088: aload 15
    //   1090: astore 17
    //   1092: aload 15
    //   1094: astore 16
    //   1096: new 98	java/lang/StringBuilder
    //   1099: dup
    //   1100: ldc_w 788
    //   1103: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1106: iload_3
    //   1107: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1110: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1113: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1116: aload 15
    //   1118: astore 17
    //   1120: aload 15
    //   1122: astore 16
    //   1124: aload 20
    //   1126: ldc2_w 377
    //   1129: invokevirtual 384	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   1132: istore 4
    //   1134: aload 15
    //   1136: astore 17
    //   1138: aload 15
    //   1140: astore 16
    //   1142: iload_3
    //   1143: getstatic 59	com/whatsapp/aqe:t	I
    //   1146: if_icmpge +32 -> 1178
    //   1149: aload 15
    //   1151: astore 17
    //   1153: aload 15
    //   1155: astore 16
    //   1157: new 98	java/lang/StringBuilder
    //   1160: dup
    //   1161: ldc_w 790
    //   1164: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1167: iload 4
    //   1169: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1172: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1175: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1178: iload 4
    //   1180: iflt +1461 -> 2641
    //   1183: aload 27
    //   1185: iload 4
    //   1187: aaload
    //   1188: astore 29
    //   1190: aload 15
    //   1192: astore 17
    //   1194: aload 15
    //   1196: astore 16
    //   1198: aload 29
    //   1200: invokevirtual 390	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1203: pop
    //   1204: aload 15
    //   1206: astore 17
    //   1208: aload 15
    //   1210: astore 16
    //   1212: aload_0
    //   1213: getfield 724	com/whatsapp/aqe:d	Lcom/whatsapp/doodle/a/b;
    //   1216: ifnull +115 -> 1331
    //   1219: iload 9
    //   1221: ifeq +110 -> 1331
    //   1224: aload 15
    //   1226: astore 17
    //   1228: aload 15
    //   1230: astore 16
    //   1232: aload_0
    //   1233: getfield 724	com/whatsapp/aqe:d	Lcom/whatsapp/doodle/a/b;
    //   1236: lload 11
    //   1238: ldc2_w 406
    //   1241: ldiv
    //   1242: invokevirtual 793	com/whatsapp/doodle/a/b:a	(J)V
    //   1245: aload 15
    //   1247: astore 17
    //   1249: aload 15
    //   1251: astore 16
    //   1253: aload 19
    //   1255: iconst_0
    //   1256: invokevirtual 797	android/graphics/Bitmap:eraseColor	(I)V
    //   1259: aload 15
    //   1261: astore 17
    //   1263: aload 15
    //   1265: astore 16
    //   1267: aload_0
    //   1268: getfield 724	com/whatsapp/aqe:d	Lcom/whatsapp/doodle/a/b;
    //   1271: aload 19
    //   1273: iconst_0
    //   1274: invokevirtual 743	com/whatsapp/doodle/a/b:a	(Landroid/graphics/Bitmap;I)V
    //   1277: aload 15
    //   1279: astore 17
    //   1281: aload 15
    //   1283: astore 16
    //   1285: aload 18
    //   1287: invokevirtual 800	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1290: pop
    //   1291: aload 15
    //   1293: astore 17
    //   1295: aload 15
    //   1297: astore 16
    //   1299: aload 19
    //   1301: aload 18
    //   1303: invokevirtual 757	android/graphics/Bitmap:copyPixelsToBuffer	(Ljava/nio/Buffer;)V
    //   1306: aload 15
    //   1308: astore 17
    //   1310: aload 15
    //   1312: astore 16
    //   1314: aload 23
    //   1316: aload 18
    //   1318: aload 19
    //   1320: invokevirtual 746	android/graphics/Bitmap:getWidth	()I
    //   1323: aload 19
    //   1325: invokevirtual 749	android/graphics/Bitmap:getHeight	()I
    //   1328: invokevirtual 760	com/whatsapp/VideoFrameConverter:a	(Ljava/nio/ByteBuffer;II)V
    //   1331: aload 15
    //   1333: astore 17
    //   1335: aload 15
    //   1337: astore 16
    //   1339: aload 23
    //   1341: aload 28
    //   1343: aload 29
    //   1345: invokevirtual 395	com/whatsapp/VideoFrameConverter:a	(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;)V
    //   1348: aload 15
    //   1350: astore 17
    //   1352: aload 15
    //   1354: astore 16
    //   1356: aload_0
    //   1357: getfield 405	com/whatsapp/aqe:s	J
    //   1360: lconst_0
    //   1361: lcmp
    //   1362: ifeq +18 -> 1380
    //   1365: aload 15
    //   1367: astore 17
    //   1369: aload 15
    //   1371: astore 16
    //   1373: iload_3
    //   1374: getstatic 59	com/whatsapp/aqe:t	I
    //   1377: if_icmpge +17 -> 1394
    //   1380: aload 15
    //   1382: astore 17
    //   1384: aload 15
    //   1386: astore 16
    //   1388: ldc_w 802
    //   1391: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1394: aload 15
    //   1396: astore 17
    //   1398: aload 15
    //   1400: astore 16
    //   1402: aload 20
    //   1404: iload 4
    //   1406: iconst_0
    //   1407: iload 7
    //   1409: lload 11
    //   1411: iconst_0
    //   1412: invokevirtual 403	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   1415: aload 15
    //   1417: astore 17
    //   1419: aload 15
    //   1421: astore 16
    //   1423: aload_0
    //   1424: getfield 405	com/whatsapp/aqe:s	J
    //   1427: lconst_0
    //   1428: lcmp
    //   1429: ifeq +18 -> 1447
    //   1432: aload 15
    //   1434: astore 17
    //   1436: aload 15
    //   1438: astore 16
    //   1440: iload_3
    //   1441: getstatic 59	com/whatsapp/aqe:t	I
    //   1444: if_icmpge +17 -> 1461
    //   1447: aload 15
    //   1449: astore 17
    //   1451: aload 15
    //   1453: astore 16
    //   1455: ldc_w 804
    //   1458: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1461: aload 15
    //   1463: astore 17
    //   1465: aload 15
    //   1467: astore 16
    //   1469: aload_0
    //   1470: aload_0
    //   1471: getfield 405	com/whatsapp/aqe:s	J
    //   1474: lconst_1
    //   1475: ladd
    //   1476: putfield 405	com/whatsapp/aqe:s	J
    //   1479: aload 15
    //   1481: astore 17
    //   1483: aload 15
    //   1485: astore 16
    //   1487: aload_0
    //   1488: lload 11
    //   1490: aload_0
    //   1491: getfield 92	com/whatsapp/aqe:p	J
    //   1494: ldc2_w 406
    //   1497: lmul
    //   1498: lsub
    //   1499: putfield 409	com/whatsapp/aqe:r	J
    //   1502: aload 15
    //   1504: astore 17
    //   1506: aload 15
    //   1508: astore 16
    //   1510: ldc2_w 805
    //   1513: iload_3
    //   1514: i2d
    //   1515: iload 8
    //   1517: i2d
    //   1518: ddiv
    //   1519: dmul
    //   1520: d2i
    //   1521: istore 4
    //   1523: iload 4
    //   1525: iload_2
    //   1526: if_icmpeq +1115 -> 2641
    //   1529: aload 15
    //   1531: astore 17
    //   1533: aload 15
    //   1535: astore 16
    //   1537: aload_0
    //   1538: getfield 808	com/whatsapp/aqe:e	Lcom/whatsapp/xf$a;
    //   1541: ifnull +1100 -> 2641
    //   1544: aload 15
    //   1546: astore 17
    //   1548: aload 15
    //   1550: astore 16
    //   1552: aload_0
    //   1553: getfield 810	com/whatsapp/aqe:f	Z
    //   1556: ifne +1129 -> 2685
    //   1559: aload 15
    //   1561: astore 17
    //   1563: aload 15
    //   1565: astore 16
    //   1567: aload_0
    //   1568: getfield 808	com/whatsapp/aqe:e	Lcom/whatsapp/xf$a;
    //   1571: iload 4
    //   1573: invokeinterface 815 2 0
    //   1578: ifeq +1175 -> 2753
    //   1581: goto +1104 -> 2685
    //   1584: aload 15
    //   1586: astore 17
    //   1588: aload 15
    //   1590: astore 16
    //   1592: aload_0
    //   1593: iload 10
    //   1595: putfield 810	com/whatsapp/aqe:f	Z
    //   1598: iload 4
    //   1600: iconst_5
    //   1601: if_icmplt +13 -> 1614
    //   1604: iload 4
    //   1606: istore_2
    //   1607: iload 4
    //   1609: iconst_5
    //   1610: irem
    //   1611: ifne +61 -> 1672
    //   1614: aload 15
    //   1616: astore 17
    //   1618: aload 15
    //   1620: astore 16
    //   1622: new 98	java/lang/StringBuilder
    //   1625: dup
    //   1626: ldc_w 817
    //   1629: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1632: iload 4
    //   1634: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1637: ldc_w 819
    //   1640: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1643: aload_0
    //   1644: getfield 405	com/whatsapp/aqe:s	J
    //   1647: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1650: ldc_w 821
    //   1653: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1656: aload_0
    //   1657: getfield 409	com/whatsapp/aqe:r	J
    //   1660: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1663: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1666: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1669: iload 4
    //   1671: istore_2
    //   1672: iload_3
    //   1673: iload 8
    //   1675: iconst_1
    //   1676: isub
    //   1677: if_icmpne +30 -> 1707
    //   1680: aload 15
    //   1682: astore 17
    //   1684: aload 15
    //   1686: astore 16
    //   1688: aload_0
    //   1689: aload 20
    //   1691: aload 27
    //   1693: aload 23
    //   1695: aload 26
    //   1697: aload 28
    //   1699: iload_3
    //   1700: lload 11
    //   1702: iload 7
    //   1704: invokespecial 783	com/whatsapp/aqe:a	(Landroid/media/MediaCodec;[Ljava/nio/ByteBuffer;Lcom/whatsapp/VideoFrameConverter;Lcom/whatsapp/pi;Ljava/nio/ByteBuffer;IJI)V
    //   1707: aload 15
    //   1709: astore 17
    //   1711: aload 15
    //   1713: astore 16
    //   1715: aload 20
    //   1717: aload 22
    //   1719: ldc2_w 377
    //   1722: invokevirtual 825	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   1725: istore 4
    //   1727: aload 15
    //   1729: astore 17
    //   1731: aload 15
    //   1733: astore 16
    //   1735: iload_3
    //   1736: getstatic 59	com/whatsapp/aqe:t	I
    //   1739: if_icmpge +32 -> 1771
    //   1742: aload 15
    //   1744: astore 17
    //   1746: aload 15
    //   1748: astore 16
    //   1750: new 98	java/lang/StringBuilder
    //   1753: dup
    //   1754: ldc_w 827
    //   1757: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1760: iload 4
    //   1762: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1765: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1768: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1771: iload 4
    //   1773: iflt +134 -> 1907
    //   1776: aload 15
    //   1778: iload 4
    //   1780: aaload
    //   1781: astore 29
    //   1783: aload 15
    //   1785: astore 17
    //   1787: aload 15
    //   1789: astore 16
    //   1791: aload 29
    //   1793: aload 22
    //   1795: getfield 830	android/media/MediaCodec$BufferInfo:offset	I
    //   1798: invokevirtual 834	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1801: pop
    //   1802: aload 15
    //   1804: astore 17
    //   1806: aload 15
    //   1808: astore 16
    //   1810: aload 29
    //   1812: aload 22
    //   1814: getfield 830	android/media/MediaCodec$BufferInfo:offset	I
    //   1817: aload 22
    //   1819: getfield 837	android/media/MediaCodec$BufferInfo:size	I
    //   1822: iadd
    //   1823: invokevirtual 840	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   1826: pop
    //   1827: aload 15
    //   1829: astore 17
    //   1831: aload 15
    //   1833: astore 16
    //   1835: aload 21
    //   1837: aload 29
    //   1839: invokeinterface 846 2 0
    //   1844: pop
    //   1845: aload 15
    //   1847: astore 17
    //   1849: aload 15
    //   1851: astore 16
    //   1853: aload 29
    //   1855: invokevirtual 390	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1858: pop
    //   1859: aload 15
    //   1861: astore 17
    //   1863: aload 15
    //   1865: astore 16
    //   1867: aload 20
    //   1869: iload 4
    //   1871: iconst_0
    //   1872: invokevirtual 850	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   1875: aload 15
    //   1877: astore 17
    //   1879: aload 15
    //   1881: astore 16
    //   1883: iload_3
    //   1884: getstatic 59	com/whatsapp/aqe:t	I
    //   1887: if_icmpge +804 -> 2691
    //   1890: aload 15
    //   1892: astore 17
    //   1894: aload 15
    //   1896: astore 16
    //   1898: ldc_w 852
    //   1901: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1904: goto +787 -> 2691
    //   1907: iload 4
    //   1909: bipush -3
    //   1911: if_icmpne +35 -> 1946
    //   1914: aload 15
    //   1916: astore 17
    //   1918: aload 15
    //   1920: astore 16
    //   1922: aload 20
    //   1924: invokevirtual 709	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   1927: astore 15
    //   1929: ldc_w 854
    //   1932: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1935: iload_1
    //   1936: istore 4
    //   1938: iload_2
    //   1939: istore_1
    //   1940: iload 4
    //   1942: istore_2
    //   1943: goto +715 -> 2658
    //   1946: iload 4
    //   1948: bipush -2
    //   1950: if_icmpne +47 -> 1997
    //   1953: aload 15
    //   1955: astore 17
    //   1957: aload 15
    //   1959: astore 16
    //   1961: aload 20
    //   1963: invokevirtual 858	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   1966: astore 29
    //   1968: aload 15
    //   1970: astore 17
    //   1972: aload 15
    //   1974: astore 16
    //   1976: new 98	java/lang/StringBuilder
    //   1979: dup
    //   1980: ldc_w 860
    //   1983: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1986: aload 29
    //   1988: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1991: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1994: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1997: iload_1
    //   1998: istore 4
    //   2000: iload_2
    //   2001: istore_1
    //   2002: iload 4
    //   2004: istore_2
    //   2005: goto +653 -> 2658
    //   2008: aload 20
    //   2010: aload 22
    //   2012: ldc2_w 377
    //   2015: invokevirtual 825	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   2018: istore_1
    //   2019: iload_1
    //   2020: iflt +94 -> 2114
    //   2023: new 98	java/lang/StringBuilder
    //   2026: dup
    //   2027: ldc_w 862
    //   2030: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2033: iload_1
    //   2034: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2037: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2040: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2043: aload 15
    //   2045: iload_1
    //   2046: aaload
    //   2047: astore 16
    //   2049: aload 16
    //   2051: aload 22
    //   2053: getfield 830	android/media/MediaCodec$BufferInfo:offset	I
    //   2056: invokevirtual 834	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   2059: pop
    //   2060: aload 16
    //   2062: aload 22
    //   2064: getfield 830	android/media/MediaCodec$BufferInfo:offset	I
    //   2067: aload 22
    //   2069: getfield 837	android/media/MediaCodec$BufferInfo:size	I
    //   2072: iadd
    //   2073: invokevirtual 840	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   2076: pop
    //   2077: aload 21
    //   2079: aload 16
    //   2081: invokeinterface 846 2 0
    //   2086: pop
    //   2087: aload 16
    //   2089: invokevirtual 390	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   2092: pop
    //   2093: aload 20
    //   2095: iload_1
    //   2096: iconst_0
    //   2097: invokevirtual 850	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   2100: aload 20
    //   2102: aload 22
    //   2104: ldc2_w 377
    //   2107: invokevirtual 825	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   2110: istore_1
    //   2111: goto -92 -> 2019
    //   2114: ldc_w 864
    //   2117: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2120: aload 20
    //   2122: invokevirtual 867	android/media/MediaCodec:stop	()V
    //   2125: ldc_w 869
    //   2128: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2131: aload 20
    //   2133: invokevirtual 872	android/media/MediaCodec:release	()V
    //   2136: ldc_w 874
    //   2139: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2142: aload 23
    //   2144: getfield 875	com/whatsapp/VideoFrameConverter:a	I
    //   2147: invokestatic 877	com/whatsapp/VideoFrameConverter:release	(I)V
    //   2150: aload 21
    //   2152: invokeinterface 878 1 0
    //   2157: aload 25
    //   2159: invokevirtual 879	java/io/FileOutputStream:close	()V
    //   2162: new 98	java/lang/StringBuilder
    //   2165: dup
    //   2166: ldc_w 881
    //   2169: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2172: aload_0
    //   2173: getfield 810	com/whatsapp/aqe:f	Z
    //   2176: invokevirtual 884	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2179: ldc_w 819
    //   2182: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2185: aload_0
    //   2186: getfield 405	com/whatsapp/aqe:s	J
    //   2189: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2192: ldc_w 886
    //   2195: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2198: aload_0
    //   2199: getfield 713	com/whatsapp/aqe:n	Ljava/io/File;
    //   2202: invokevirtual 890	java/io/File:length	()J
    //   2205: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2208: ldc_w 821
    //   2211: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2214: aload_0
    //   2215: getfield 409	com/whatsapp/aqe:r	J
    //   2218: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2221: ldc_w 892
    //   2224: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2227: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2230: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2233: aload_0
    //   2234: getfield 713	com/whatsapp/aqe:n	Ljava/io/File;
    //   2237: invokevirtual 890	java/io/File:length	()J
    //   2240: lconst_0
    //   2241: lcmp
    //   2242: ifeq +12 -> 2254
    //   2245: aload_0
    //   2246: getfield 409	com/whatsapp/aqe:r	J
    //   2249: lconst_0
    //   2250: lcmp
    //   2251: ifne +330 -> 2581
    //   2254: new 894	com/whatsapp/util/MediaFileUtils$c
    //   2257: dup
    //   2258: invokespecial 895	com/whatsapp/util/MediaFileUtils$c:<init>	()V
    //   2261: athrow
    //   2262: astore 15
    //   2264: aload 17
    //   2266: astore 16
    //   2268: ldc_w 897
    //   2271: aload 15
    //   2273: invokestatic 433	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2276: aload 20
    //   2278: aload 22
    //   2280: ldc2_w 377
    //   2283: invokevirtual 825	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   2286: istore_1
    //   2287: iload_1
    //   2288: iflt +94 -> 2382
    //   2291: new 98	java/lang/StringBuilder
    //   2294: dup
    //   2295: ldc_w 862
    //   2298: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2301: iload_1
    //   2302: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2305: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2308: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2311: aload 17
    //   2313: iload_1
    //   2314: aaload
    //   2315: astore 15
    //   2317: aload 15
    //   2319: aload 22
    //   2321: getfield 830	android/media/MediaCodec$BufferInfo:offset	I
    //   2324: invokevirtual 834	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   2327: pop
    //   2328: aload 15
    //   2330: aload 22
    //   2332: getfield 830	android/media/MediaCodec$BufferInfo:offset	I
    //   2335: aload 22
    //   2337: getfield 837	android/media/MediaCodec$BufferInfo:size	I
    //   2340: iadd
    //   2341: invokevirtual 840	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   2344: pop
    //   2345: aload 21
    //   2347: aload 15
    //   2349: invokeinterface 846 2 0
    //   2354: pop
    //   2355: aload 15
    //   2357: invokevirtual 390	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   2360: pop
    //   2361: aload 20
    //   2363: iload_1
    //   2364: iconst_0
    //   2365: invokevirtual 850	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   2368: aload 20
    //   2370: aload 22
    //   2372: ldc2_w 377
    //   2375: invokevirtual 825	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   2378: istore_1
    //   2379: goto -92 -> 2287
    //   2382: ldc_w 864
    //   2385: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2388: aload 20
    //   2390: invokevirtual 867	android/media/MediaCodec:stop	()V
    //   2393: ldc_w 869
    //   2396: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2399: aload 20
    //   2401: invokevirtual 872	android/media/MediaCodec:release	()V
    //   2404: ldc_w 874
    //   2407: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2410: aload 23
    //   2412: getfield 875	com/whatsapp/VideoFrameConverter:a	I
    //   2415: invokestatic 877	com/whatsapp/VideoFrameConverter:release	(I)V
    //   2418: goto -268 -> 2150
    //   2421: astore 15
    //   2423: aload 20
    //   2425: aload 22
    //   2427: ldc2_w 377
    //   2430: invokevirtual 825	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   2433: istore_1
    //   2434: iload_1
    //   2435: iflt +94 -> 2529
    //   2438: new 98	java/lang/StringBuilder
    //   2441: dup
    //   2442: ldc_w 862
    //   2445: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2448: iload_1
    //   2449: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2452: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2455: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2458: aload 16
    //   2460: iload_1
    //   2461: aaload
    //   2462: astore 17
    //   2464: aload 17
    //   2466: aload 22
    //   2468: getfield 830	android/media/MediaCodec$BufferInfo:offset	I
    //   2471: invokevirtual 834	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   2474: pop
    //   2475: aload 17
    //   2477: aload 22
    //   2479: getfield 830	android/media/MediaCodec$BufferInfo:offset	I
    //   2482: aload 22
    //   2484: getfield 837	android/media/MediaCodec$BufferInfo:size	I
    //   2487: iadd
    //   2488: invokevirtual 840	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   2491: pop
    //   2492: aload 21
    //   2494: aload 17
    //   2496: invokeinterface 846 2 0
    //   2501: pop
    //   2502: aload 17
    //   2504: invokevirtual 390	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   2507: pop
    //   2508: aload 20
    //   2510: iload_1
    //   2511: iconst_0
    //   2512: invokevirtual 850	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   2515: aload 20
    //   2517: aload 22
    //   2519: ldc2_w 377
    //   2522: invokevirtual 825	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   2525: istore_1
    //   2526: goto -92 -> 2434
    //   2529: ldc_w 864
    //   2532: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2535: aload 20
    //   2537: invokevirtual 867	android/media/MediaCodec:stop	()V
    //   2540: ldc_w 869
    //   2543: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2546: aload 20
    //   2548: invokevirtual 872	android/media/MediaCodec:release	()V
    //   2551: ldc_w 874
    //   2554: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2557: aload 23
    //   2559: getfield 875	com/whatsapp/VideoFrameConverter:a	I
    //   2562: invokestatic 877	com/whatsapp/VideoFrameConverter:release	(I)V
    //   2565: aload 15
    //   2567: athrow
    //   2568: astore 15
    //   2570: ldc_w 899
    //   2573: aload 15
    //   2575: invokestatic 433	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2578: goto -416 -> 2162
    //   2581: aload 24
    //   2583: invokeinterface 901 1 0
    //   2588: new 98	java/lang/StringBuilder
    //   2591: dup
    //   2592: ldc_w 903
    //   2595: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2598: aload_0
    //   2599: getfield 713	com/whatsapp/aqe:n	Ljava/io/File;
    //   2602: invokevirtual 890	java/io/File:length	()J
    //   2605: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2608: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2611: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2614: return
    //   2615: astore 17
    //   2617: aload 15
    //   2619: astore 16
    //   2621: aload 17
    //   2623: astore 15
    //   2625: goto -202 -> 2423
    //   2628: astore 16
    //   2630: aload 15
    //   2632: astore 17
    //   2634: aload 16
    //   2636: astore 15
    //   2638: goto -374 -> 2264
    //   2641: goto -969 -> 1672
    //   2644: iload 4
    //   2646: istore_1
    //   2647: goto -1574 -> 1073
    //   2650: iload_2
    //   2651: istore 4
    //   2653: iload_1
    //   2654: istore_2
    //   2655: iload 4
    //   2657: istore_1
    //   2658: iload_3
    //   2659: iconst_1
    //   2660: iadd
    //   2661: istore_3
    //   2662: iload_1
    //   2663: istore 4
    //   2665: iload_2
    //   2666: istore_1
    //   2667: iload 4
    //   2669: istore_2
    //   2670: goto -1731 -> 939
    //   2673: iconst_0
    //   2674: istore 9
    //   2676: aconst_null
    //   2677: astore 18
    //   2679: aconst_null
    //   2680: astore 19
    //   2682: goto -1949 -> 733
    //   2685: iconst_1
    //   2686: istore 10
    //   2688: goto -1104 -> 1584
    //   2691: iload_1
    //   2692: istore 4
    //   2694: iload_2
    //   2695: istore_1
    //   2696: iload 4
    //   2698: istore_2
    //   2699: goto -41 -> 2658
    //   2702: iload_1
    //   2703: bipush 70
    //   2705: if_icmplt +20 -> 2725
    //   2708: lload 11
    //   2710: iload_1
    //   2711: sipush 1000
    //   2714: imul
    //   2715: i2l
    //   2716: ladd
    //   2717: lstore 11
    //   2719: iload 4
    //   2721: istore_1
    //   2722: goto -1649 -> 1073
    //   2725: iload_1
    //   2726: iload 4
    //   2728: iadd
    //   2729: bipush 70
    //   2731: if_icmple -87 -> 2644
    //   2734: iload 4
    //   2736: bipush 70
    //   2738: iload_1
    //   2739: isub
    //   2740: isub
    //   2741: istore_1
    //   2742: lload 11
    //   2744: ldc2_w 904
    //   2747: ladd
    //   2748: lstore 11
    //   2750: goto -1677 -> 1073
    //   2753: iconst_0
    //   2754: istore 10
    //   2756: goto -1172 -> 1584
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2759	0	this	aqe
    //   173	2569	1	i1	int
    //   175	2524	2	i2	int
    //   101	2561	3	i3	int
    //   104	2637	4	i4	int
    //   55	984	5	i5	int
    //   65	976	6	i6	int
    //   427	1276	7	i7	int
    //   386	1291	8	i8	int
    //   667	2008	9	bool1	boolean
    //   1593	1162	10	bool2	boolean
    //   913	1836	11	l1	long
    //   1050	20	13	l2	long
    //   366	1678	15	localObject1	Object
    //   2262	10	15	localException1	Exception
    //   2315	41	15	localByteBuffer1	ByteBuffer
    //   2421	145	15	localObject2	Object
    //   2568	50	15	localIOException	IOException
    //   2623	14	15	localObject3	Object
    //   231	2389	16	localObject4	Object
    //   2628	7	16	localException2	Exception
    //   867	1636	17	localObject5	Object
    //   2615	7	17	localObject6	Object
    //   2632	1	17	localObject7	Object
    //   707	1971	18	localByteBuffer2	ByteBuffer
    //   679	2002	19	localBitmap	android.graphics.Bitmap
    //   459	2088	20	localMediaCodec	MediaCodec
    //   631	1862	21	localFileChannel	java.nio.channels.FileChannel
    //   640	1878	22	localBufferInfo	android.media.MediaCodec.BufferInfo
    //   651	1907	23	localVideoFrameConverter	VideoFrameConverter
    //   6	2576	24	locald	d
    //   624	1534	25	localFileOutputStream	java.io.FileOutputStream
    //   39	1657	26	localpi	pi
    //   604	1088	27	arrayOfByteBuffer	ByteBuffer[]
    //   935	763	28	localByteBuffer3	ByteBuffer
    //   1188	799	29	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   873	883	2262	java/lang/Exception
    //   891	912	2262	java/lang/Exception
    //   925	937	2262	java/lang/Exception
    //   953	961	2262	java/lang/Exception
    //   995	1014	2262	java/lang/Exception
    //   1033	1045	2262	java/lang/Exception
    //   1081	1088	2262	java/lang/Exception
    //   1096	1116	2262	java/lang/Exception
    //   1124	1134	2262	java/lang/Exception
    //   1142	1149	2262	java/lang/Exception
    //   1157	1178	2262	java/lang/Exception
    //   1198	1204	2262	java/lang/Exception
    //   1212	1219	2262	java/lang/Exception
    //   1232	1245	2262	java/lang/Exception
    //   1253	1259	2262	java/lang/Exception
    //   1267	1277	2262	java/lang/Exception
    //   1285	1291	2262	java/lang/Exception
    //   1299	1306	2262	java/lang/Exception
    //   1314	1331	2262	java/lang/Exception
    //   1339	1348	2262	java/lang/Exception
    //   1356	1365	2262	java/lang/Exception
    //   1373	1380	2262	java/lang/Exception
    //   1388	1394	2262	java/lang/Exception
    //   1402	1415	2262	java/lang/Exception
    //   1423	1432	2262	java/lang/Exception
    //   1440	1447	2262	java/lang/Exception
    //   1455	1461	2262	java/lang/Exception
    //   1469	1479	2262	java/lang/Exception
    //   1487	1502	2262	java/lang/Exception
    //   1510	1523	2262	java/lang/Exception
    //   1537	1544	2262	java/lang/Exception
    //   1552	1559	2262	java/lang/Exception
    //   1567	1581	2262	java/lang/Exception
    //   1592	1598	2262	java/lang/Exception
    //   1622	1669	2262	java/lang/Exception
    //   1688	1707	2262	java/lang/Exception
    //   1715	1727	2262	java/lang/Exception
    //   1735	1742	2262	java/lang/Exception
    //   1750	1771	2262	java/lang/Exception
    //   1791	1802	2262	java/lang/Exception
    //   1810	1827	2262	java/lang/Exception
    //   1835	1845	2262	java/lang/Exception
    //   1853	1859	2262	java/lang/Exception
    //   1867	1875	2262	java/lang/Exception
    //   1883	1890	2262	java/lang/Exception
    //   1898	1904	2262	java/lang/Exception
    //   1922	1929	2262	java/lang/Exception
    //   1961	1968	2262	java/lang/Exception
    //   1976	1997	2262	java/lang/Exception
    //   873	883	2421	finally
    //   891	912	2421	finally
    //   925	937	2421	finally
    //   953	961	2421	finally
    //   995	1014	2421	finally
    //   1033	1045	2421	finally
    //   1081	1088	2421	finally
    //   1096	1116	2421	finally
    //   1124	1134	2421	finally
    //   1142	1149	2421	finally
    //   1157	1178	2421	finally
    //   1198	1204	2421	finally
    //   1212	1219	2421	finally
    //   1232	1245	2421	finally
    //   1253	1259	2421	finally
    //   1267	1277	2421	finally
    //   1285	1291	2421	finally
    //   1299	1306	2421	finally
    //   1314	1331	2421	finally
    //   1339	1348	2421	finally
    //   1356	1365	2421	finally
    //   1373	1380	2421	finally
    //   1388	1394	2421	finally
    //   1402	1415	2421	finally
    //   1423	1432	2421	finally
    //   1440	1447	2421	finally
    //   1455	1461	2421	finally
    //   1469	1479	2421	finally
    //   1487	1502	2421	finally
    //   1510	1523	2421	finally
    //   1537	1544	2421	finally
    //   1552	1559	2421	finally
    //   1567	1581	2421	finally
    //   1592	1598	2421	finally
    //   1622	1669	2421	finally
    //   1688	1707	2421	finally
    //   1715	1727	2421	finally
    //   1735	1742	2421	finally
    //   1750	1771	2421	finally
    //   1791	1802	2421	finally
    //   1810	1827	2421	finally
    //   1835	1845	2421	finally
    //   1853	1859	2421	finally
    //   1867	1875	2421	finally
    //   1883	1890	2421	finally
    //   1898	1904	2421	finally
    //   1922	1929	2421	finally
    //   1961	1968	2421	finally
    //   1976	1997	2421	finally
    //   2268	2276	2421	finally
    //   2150	2162	2568	java/io/IOException
    //   1929	1935	2615	finally
    //   1929	1935	2628	java/lang/Exception
  }
  
  /* Error */
  private void i()
  {
    // Byte code:
    //   0: ldc_w 909
    //   3: invokestatic 625	com/whatsapp/k/c:a	(Ljava/lang/String;)Lcom/whatsapp/k/d;
    //   6: astore 43
    //   8: aload 43
    //   10: invokeinterface 629 1 0
    //   15: aload_0
    //   16: lconst_0
    //   17: putfield 409	com/whatsapp/aqe:r	J
    //   20: aload_0
    //   21: lconst_0
    //   22: putfield 405	com/whatsapp/aqe:s	J
    //   25: new 911	com/whatsapp/util/MediaFileUtils$f
    //   28: dup
    //   29: aload_0
    //   30: getfield 88	com/whatsapp/aqe:b	Ljava/io/File;
    //   33: invokespecial 912	com/whatsapp/util/MediaFileUtils$f:<init>	(Ljava/io/File;)V
    //   36: astore 30
    //   38: aload 30
    //   40: getfield 913	com/whatsapp/util/MediaFileUtils$f:a	I
    //   43: istore_1
    //   44: aload 30
    //   46: getfield 914	com/whatsapp/util/MediaFileUtils$f:b	I
    //   49: istore_2
    //   50: aload 30
    //   52: invokevirtual 915	com/whatsapp/util/MediaFileUtils$f:a	()I
    //   55: istore_3
    //   56: aload 30
    //   58: getfield 916	com/whatsapp/util/MediaFileUtils$f:d	I
    //   61: istore 11
    //   63: new 98	java/lang/StringBuilder
    //   66: dup
    //   67: ldc_w 918
    //   70: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: aload_0
    //   74: getfield 88	com/whatsapp/aqe:b	Ljava/io/File;
    //   77: invokevirtual 496	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   80: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 886
    //   86: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_0
    //   90: getfield 88	com/whatsapp/aqe:b	Ljava/io/File;
    //   93: invokevirtual 890	java/io/File:length	()J
    //   96: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   99: ldc_w 920
    //   102: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: iload_3
    //   106: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: ldc_w 922
    //   112: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: iload_1
    //   116: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   119: ldc_w 334
    //   122: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: iload_2
    //   126: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: ldc_w 924
    //   132: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: iload 11
    //   137: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: ldc_w 926
    //   143: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_0
    //   147: getfield 92	com/whatsapp/aqe:p	J
    //   150: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   153: ldc_w 928
    //   156: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_0
    //   160: getfield 94	com/whatsapp/aqe:q	J
    //   163: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   166: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   172: iload_1
    //   173: iload_2
    //   174: if_icmple +67 -> 241
    //   177: iload_1
    //   178: aload_0
    //   179: getfield 81	com/whatsapp/aqe:m	I
    //   182: if_icmple +5522 -> 5704
    //   185: aload_0
    //   186: getfield 81	com/whatsapp/aqe:m	I
    //   189: istore_3
    //   190: iload_2
    //   191: iload_3
    //   192: imul
    //   193: iload_1
    //   194: idiv
    //   195: istore_2
    //   196: iload_3
    //   197: istore_1
    //   198: iload_1
    //   199: iload_2
    //   200: imul
    //   201: i2f
    //   202: aload_0
    //   203: getfield 84	com/whatsapp/aqe:a	F
    //   206: fmul
    //   207: f2i
    //   208: istore_3
    //   209: invokestatic 153	android/media/MediaCodecList:getCodecCount	()I
    //   212: istore 4
    //   214: invokestatic 649	com/whatsapp/aqe:e	()Landroid/media/MediaCodecInfo;
    //   217: astore 44
    //   219: aload 44
    //   221: ifnonnull +44 -> 265
    //   224: ldc_w 651
    //   227: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   230: new 653	java/io/FileNotFoundException
    //   233: dup
    //   234: ldc_w 655
    //   237: invokespecial 656	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   240: athrow
    //   241: iload_2
    //   242: aload_0
    //   243: getfield 81	com/whatsapp/aqe:m	I
    //   246: if_icmple +5458 -> 5704
    //   249: aload_0
    //   250: getfield 81	com/whatsapp/aqe:m	I
    //   253: istore_3
    //   254: iload_1
    //   255: iload_3
    //   256: imul
    //   257: iload_2
    //   258: idiv
    //   259: istore_1
    //   260: iload_3
    //   261: istore_2
    //   262: goto -64 -> 198
    //   265: new 98	java/lang/StringBuilder
    //   268: dup
    //   269: ldc_w 658
    //   272: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   275: aload 44
    //   277: invokevirtual 172	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   280: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: ldc_w 660
    //   286: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   295: aload 44
    //   297: invokestatic 662	com/whatsapp/aqe:a	(Landroid/media/MediaCodecInfo;)I
    //   300: istore 5
    //   302: iload 5
    //   304: ifne +20 -> 324
    //   307: ldc_w 664
    //   310: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   313: new 653	java/io/FileNotFoundException
    //   316: dup
    //   317: ldc_w 666
    //   320: invokespecial 656	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   323: athrow
    //   324: aload 44
    //   326: invokevirtual 172	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   329: iload 5
    //   331: iload_1
    //   332: iload_2
    //   333: aload 44
    //   335: invokevirtual 172	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   338: invokestatic 668	com/whatsapp/aqe:b	(Ljava/lang/String;)I
    //   341: iconst_0
    //   342: iconst_0
    //   343: aload_0
    //   344: getfield 670	com/whatsapp/aqe:g	Lcom/whatsapp/aqh;
    //   347: invokestatic 313	com/whatsapp/aqe:a	(Ljava/lang/String;IIIIIILcom/whatsapp/aqh;)Lcom/whatsapp/aqe$a;
    //   350: astore 30
    //   352: aload 30
    //   354: getfield 242	com/whatsapp/aqe$a:a	I
    //   357: istore 12
    //   359: aload 30
    //   361: getfield 245	com/whatsapp/aqe$a:b	I
    //   364: istore 13
    //   366: aload 30
    //   368: getfield 248	com/whatsapp/aqe$a:c	I
    //   371: istore 14
    //   373: aload 30
    //   375: getfield 278	com/whatsapp/aqe$a:d	I
    //   378: iconst_2
    //   379: idiv
    //   380: istore_1
    //   381: aload 30
    //   383: getfield 278	com/whatsapp/aqe$a:d	I
    //   386: aload 30
    //   388: getfield 268	com/whatsapp/aqe$a:e	I
    //   391: imul
    //   392: iload_1
    //   393: aload 30
    //   395: getfield 268	com/whatsapp/aqe$a:e	I
    //   398: imul
    //   399: iadd
    //   400: istore 15
    //   402: aload 44
    //   404: invokevirtual 172	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   407: invokestatic 674	android/media/MediaCodec:createByCodecName	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   410: astore 40
    //   412: ldc_w 676
    //   415: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   418: ldc -75
    //   420: iload 13
    //   422: iload 14
    //   424: invokestatic 680	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   427: astore 31
    //   429: aload 31
    //   431: ldc_w 682
    //   434: iload_3
    //   435: invokevirtual 686	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   438: aload 31
    //   440: ldc_w 688
    //   443: bipush 30
    //   445: invokevirtual 686	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   448: aload 31
    //   450: ldc -21
    //   452: iload 12
    //   454: invokevirtual 686	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   457: aload 31
    //   459: ldc_w 690
    //   462: bipush 10
    //   464: invokevirtual 686	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   467: aload 31
    //   469: ldc_w 277
    //   472: aload 30
    //   474: getfield 278	com/whatsapp/aqe$a:d	I
    //   477: invokevirtual 686	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   480: aload 31
    //   482: ldc_w 266
    //   485: aload 30
    //   487: getfield 268	com/whatsapp/aqe$a:e	I
    //   490: invokevirtual 686	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   493: new 98	java/lang/StringBuilder
    //   496: dup
    //   497: ldc_w 692
    //   500: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   503: aload 31
    //   505: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   514: aload 40
    //   516: aload 31
    //   518: aconst_null
    //   519: aconst_null
    //   520: iconst_1
    //   521: invokevirtual 696	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   524: ldc_w 698
    //   527: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   530: aload 40
    //   532: invokevirtual 700	android/media/MediaCodec:start	()V
    //   535: ldc_w 702
    //   538: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   541: aload 30
    //   543: getfield 291	com/whatsapp/aqe$a:k	I
    //   546: istore 16
    //   548: aload 40
    //   550: invokevirtual 706	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   553: astore 46
    //   555: aload 40
    //   557: invokevirtual 709	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   560: astore 30
    //   562: new 711	java/io/FileOutputStream
    //   565: dup
    //   566: aload_0
    //   567: getfield 713	com/whatsapp/aqe:n	Ljava/io/File;
    //   570: invokespecial 714	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   573: astore 45
    //   575: aload 45
    //   577: invokevirtual 718	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   580: astore 41
    //   582: new 930	android/media/MediaExtractor
    //   585: dup
    //   586: invokespecial 931	android/media/MediaExtractor:<init>	()V
    //   589: astore 42
    //   591: aload 42
    //   593: aload_0
    //   594: getfield 88	com/whatsapp/aqe:b	Ljava/io/File;
    //   597: invokevirtual 496	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   600: invokevirtual 934	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   603: aload 42
    //   605: invokevirtual 937	android/media/MediaExtractor:getTrackCount	()I
    //   608: istore_2
    //   609: new 98	java/lang/StringBuilder
    //   612: dup
    //   613: ldc_w 939
    //   616: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   619: iload_2
    //   620: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   623: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   629: iconst_0
    //   630: istore_1
    //   631: iload_1
    //   632: iload_2
    //   633: if_icmpge +5066 -> 5699
    //   636: aload 42
    //   638: iload_1
    //   639: invokevirtual 943	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   642: astore 31
    //   644: aload 31
    //   646: ldc_w 945
    //   649: invokevirtual 948	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   652: astore 32
    //   654: new 98	java/lang/StringBuilder
    //   657: dup
    //   658: ldc_w 950
    //   661: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   664: iload_1
    //   665: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   668: ldc_w 952
    //   671: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: aload 32
    //   676: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: ldc_w 954
    //   682: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: aload 31
    //   687: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   690: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   696: aload 32
    //   698: ldc_w 956
    //   701: invokevirtual 273	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   704: ifeq +21 -> 725
    //   707: iload_1
    //   708: ifge +24 -> 732
    //   711: ldc_w 958
    //   714: invokestatic 960	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   717: new 894	com/whatsapp/util/MediaFileUtils$c
    //   720: dup
    //   721: invokespecial 895	com/whatsapp/util/MediaFileUtils$c:<init>	()V
    //   724: athrow
    //   725: iload_1
    //   726: iconst_1
    //   727: iadd
    //   728: istore_1
    //   729: goto -98 -> 631
    //   732: aload 42
    //   734: iload_1
    //   735: invokevirtual 943	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   738: astore 34
    //   740: aload 34
    //   742: ldc_w 945
    //   745: invokevirtual 948	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   748: astore 33
    //   750: ldc_w 962
    //   753: aload 33
    //   755: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   758: ifeq +32 -> 790
    //   761: new 98	java/lang/StringBuilder
    //   764: dup
    //   765: ldc_w 964
    //   768: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   771: aload 33
    //   773: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: invokestatic 960	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   782: new 894	com/whatsapp/util/MediaFileUtils$c
    //   785: dup
    //   786: invokespecial 895	com/whatsapp/util/MediaFileUtils$c:<init>	()V
    //   789: athrow
    //   790: aload 42
    //   792: iload_1
    //   793: invokevirtual 967	android/media/MediaExtractor:selectTrack	(I)V
    //   796: aload 34
    //   798: ldc_w 969
    //   801: invokevirtual 973	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   804: lstore 26
    //   806: new 98	java/lang/StringBuilder
    //   809: dup
    //   810: ldc_w 975
    //   813: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   816: aload 34
    //   818: invokevirtual 976	android/media/MediaFormat:toString	()Ljava/lang/String;
    //   821: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: ldc_w 821
    //   827: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: lload 26
    //   832: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   835: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   838: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   841: aload 33
    //   843: invokestatic 979	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   846: astore 31
    //   848: aload 31
    //   850: ifnonnull +74 -> 924
    //   853: new 98	java/lang/StringBuilder
    //   856: dup
    //   857: ldc_w 981
    //   860: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   863: aload 33
    //   865: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   871: invokestatic 960	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   874: new 894	com/whatsapp/util/MediaFileUtils$c
    //   877: dup
    //   878: invokespecial 895	com/whatsapp/util/MediaFileUtils$c:<init>	()V
    //   881: athrow
    //   882: astore 30
    //   884: new 98	java/lang/StringBuilder
    //   887: dup
    //   888: ldc_w 981
    //   891: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   894: aload 33
    //   896: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   899: ldc_w 767
    //   902: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: aload 30
    //   907: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   910: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   913: invokestatic 960	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   916: new 894	com/whatsapp/util/MediaFileUtils$c
    //   919: dup
    //   920: invokespecial 895	com/whatsapp/util/MediaFileUtils$c:<init>	()V
    //   923: athrow
    //   924: ldc_w 983
    //   927: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   930: getstatic 125	android/os/Build$VERSION:SDK_INT	I
    //   933: bipush 17
    //   935: if_icmpne +4758 -> 5693
    //   938: getstatic 136	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   941: ldc_w 985
    //   944: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   947: ifeq +667 -> 1614
    //   950: getstatic 141	android/os/Build:MODEL	Ljava/lang/String;
    //   953: ldc_w 987
    //   956: invokevirtual 273	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   959: ifne +39 -> 998
    //   962: getstatic 141	android/os/Build:MODEL	Ljava/lang/String;
    //   965: ldc_w 989
    //   968: invokevirtual 273	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   971: ifne +27 -> 998
    //   974: getstatic 141	android/os/Build:MODEL	Ljava/lang/String;
    //   977: ldc_w 991
    //   980: invokevirtual 273	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   983: ifne +15 -> 998
    //   986: getstatic 141	android/os/Build:MODEL	Ljava/lang/String;
    //   989: ldc_w 993
    //   992: invokevirtual 273	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   995: ifeq +4698 -> 5693
    //   998: new 995	com/whatsapp/aqc
    //   1001: dup
    //   1002: iload 13
    //   1004: iload 14
    //   1006: invokespecial 998	com/whatsapp/aqc:<init>	(II)V
    //   1009: astore 35
    //   1011: ldc_w 1000
    //   1014: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1017: aload 35
    //   1019: ifnonnull +635 -> 1654
    //   1022: aconst_null
    //   1023: astore 32
    //   1025: aload 31
    //   1027: aload 34
    //   1029: aload 32
    //   1031: aconst_null
    //   1032: iconst_0
    //   1033: invokevirtual 696	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   1036: ldc_w 1002
    //   1039: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1042: aload 31
    //   1044: astore 36
    //   1046: aload 36
    //   1048: invokevirtual 700	android/media/MediaCodec:start	()V
    //   1051: ldc_w 1004
    //   1054: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1057: aload 36
    //   1059: invokevirtual 706	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   1062: astore 49
    //   1064: aload 36
    //   1066: invokevirtual 709	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   1069: astore 31
    //   1071: new 720	android/media/MediaCodec$BufferInfo
    //   1074: dup
    //   1075: invokespecial 721	android/media/MediaCodec$BufferInfo:<init>	()V
    //   1078: astore 50
    //   1080: new 720	android/media/MediaCodec$BufferInfo
    //   1083: dup
    //   1084: invokespecial 721	android/media/MediaCodec$BufferInfo:<init>	()V
    //   1087: astore 47
    //   1089: aload_0
    //   1090: getfield 92	com/whatsapp/aqe:p	J
    //   1093: lconst_0
    //   1094: lcmp
    //   1095: ifle +58 -> 1153
    //   1098: aload 42
    //   1100: aload_0
    //   1101: getfield 92	com/whatsapp/aqe:p	J
    //   1104: ldc2_w 406
    //   1107: lmul
    //   1108: iconst_0
    //   1109: invokevirtual 1008	android/media/MediaExtractor:seekTo	(JI)V
    //   1112: new 98	java/lang/StringBuilder
    //   1115: dup
    //   1116: ldc_w 1010
    //   1119: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1122: aload_0
    //   1123: getfield 92	com/whatsapp/aqe:p	J
    //   1126: ldc2_w 406
    //   1129: lmul
    //   1130: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1133: ldc_w 1012
    //   1136: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1139: aload 42
    //   1141: invokevirtual 1015	android/media/MediaExtractor:getSampleTime	()J
    //   1144: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1147: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1150: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1153: new 392	com/whatsapp/VideoFrameConverter
    //   1156: dup
    //   1157: invokespecial 722	com/whatsapp/VideoFrameConverter:<init>	()V
    //   1160: astore 48
    //   1162: aload_0
    //   1163: getfield 724	com/whatsapp/aqe:d	Lcom/whatsapp/doodle/a/b;
    //   1166: ifnull +920 -> 2086
    //   1169: aload_0
    //   1170: getfield 724	com/whatsapp/aqe:d	Lcom/whatsapp/doodle/a/b;
    //   1173: invokevirtual 728	com/whatsapp/doodle/a/b:f	()Z
    //   1176: istore 28
    //   1178: iload 13
    //   1180: iload 14
    //   1182: getstatic 734	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   1185: invokestatic 740	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   1188: astore 37
    //   1190: aload_0
    //   1191: getfield 724	com/whatsapp/aqe:d	Lcom/whatsapp/doodle/a/b;
    //   1194: aload 37
    //   1196: sipush 360
    //   1199: iload 11
    //   1201: isub
    //   1202: sipush 360
    //   1205: irem
    //   1206: invokevirtual 743	com/whatsapp/doodle/a/b:a	(Landroid/graphics/Bitmap;I)V
    //   1209: aload 37
    //   1211: invokevirtual 746	android/graphics/Bitmap:getWidth	()I
    //   1214: aload 37
    //   1216: invokevirtual 749	android/graphics/Bitmap:getHeight	()I
    //   1219: imul
    //   1220: iconst_2
    //   1221: ishl
    //   1222: invokestatic 753	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   1225: astore 38
    //   1227: aload 37
    //   1229: aload 38
    //   1231: invokevirtual 757	android/graphics/Bitmap:copyPixelsToBuffer	(Ljava/nio/Buffer;)V
    //   1234: aload 48
    //   1236: aload 38
    //   1238: aload 37
    //   1240: invokevirtual 746	android/graphics/Bitmap:getWidth	()I
    //   1243: aload 37
    //   1245: invokevirtual 749	android/graphics/Bitmap:getHeight	()I
    //   1248: invokevirtual 760	com/whatsapp/VideoFrameConverter:a	(Ljava/nio/ByteBuffer;II)V
    //   1251: aconst_null
    //   1252: astore 39
    //   1254: aload 35
    //   1256: ifnull +42 -> 1298
    //   1259: iload 13
    //   1261: iconst_4
    //   1262: imul
    //   1263: iload 14
    //   1265: imul
    //   1266: invokestatic 753	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   1269: astore 39
    //   1271: aload 48
    //   1273: bipush 7
    //   1275: iload 13
    //   1277: iload 14
    //   1279: iconst_0
    //   1280: iconst_0
    //   1281: iload 13
    //   1283: iconst_1
    //   1284: isub
    //   1285: iload 14
    //   1287: iconst_1
    //   1288: isub
    //   1289: iload 16
    //   1291: iload 13
    //   1293: iload 14
    //   1295: invokevirtual 763	com/whatsapp/VideoFrameConverter:a	(IIIIIIIIII)V
    //   1298: iconst_0
    //   1299: istore 7
    //   1301: iconst_0
    //   1302: istore_3
    //   1303: iconst_0
    //   1304: istore_1
    //   1305: iconst_0
    //   1306: istore 4
    //   1308: iconst_0
    //   1309: istore_2
    //   1310: iload_2
    //   1311: ifne +175 -> 1486
    //   1314: aload 30
    //   1316: astore 34
    //   1318: aload 30
    //   1320: astore 33
    //   1322: aload_0
    //   1323: getfield 810	com/whatsapp/aqe:f	Z
    //   1326: ifne +160 -> 1486
    //   1329: iload 7
    //   1331: iconst_1
    //   1332: iadd
    //   1333: istore 9
    //   1335: aload 30
    //   1337: astore 34
    //   1339: aload 30
    //   1341: astore 33
    //   1343: iload 9
    //   1345: getstatic 59	com/whatsapp/aqe:t	I
    //   1348: if_icmpge +32 -> 1380
    //   1351: aload 30
    //   1353: astore 34
    //   1355: aload 30
    //   1357: astore 33
    //   1359: new 98	java/lang/StringBuilder
    //   1362: dup
    //   1363: ldc_w 788
    //   1366: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1369: iload 9
    //   1371: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1374: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1377: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1380: iload 4
    //   1382: istore 8
    //   1384: iload 4
    //   1386: ifne +774 -> 2160
    //   1389: aload 30
    //   1391: astore 34
    //   1393: aload 30
    //   1395: astore 33
    //   1397: aload 36
    //   1399: ldc2_w 377
    //   1402: invokevirtual 384	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   1405: istore 5
    //   1407: aload 30
    //   1409: astore 34
    //   1411: aload 30
    //   1413: astore 33
    //   1415: iload 9
    //   1417: getstatic 59	com/whatsapp/aqe:t	I
    //   1420: if_icmpge +32 -> 1452
    //   1423: aload 30
    //   1425: astore 34
    //   1427: aload 30
    //   1429: astore 33
    //   1431: new 98	java/lang/StringBuilder
    //   1434: dup
    //   1435: ldc_w 1017
    //   1438: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1441: iload 5
    //   1443: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1446: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1449: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1452: iload 5
    //   1454: ifge +644 -> 2098
    //   1457: aload 30
    //   1459: astore 34
    //   1461: aload 30
    //   1463: astore 33
    //   1465: new 98	java/lang/StringBuilder
    //   1468: dup
    //   1469: ldc_w 1019
    //   1472: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1475: iload 5
    //   1477: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1480: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1483: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1486: aload 36
    //   1488: invokevirtual 867	android/media/MediaCodec:stop	()V
    //   1491: ldc_w 1021
    //   1494: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1497: aload 36
    //   1499: invokevirtual 872	android/media/MediaCodec:release	()V
    //   1502: ldc_w 1023
    //   1505: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1508: aload 40
    //   1510: aload 47
    //   1512: ldc2_w 377
    //   1515: invokevirtual 825	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   1518: istore_1
    //   1519: iload_1
    //   1520: iflt +3789 -> 5309
    //   1523: new 98	java/lang/StringBuilder
    //   1526: dup
    //   1527: ldc_w 862
    //   1530: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1533: iload_1
    //   1534: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1537: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1540: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1543: aload 30
    //   1545: iload_1
    //   1546: aaload
    //   1547: astore 31
    //   1549: aload 31
    //   1551: aload 47
    //   1553: getfield 830	android/media/MediaCodec$BufferInfo:offset	I
    //   1556: invokevirtual 834	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   1559: pop
    //   1560: aload 31
    //   1562: aload 47
    //   1564: getfield 830	android/media/MediaCodec$BufferInfo:offset	I
    //   1567: aload 47
    //   1569: getfield 837	android/media/MediaCodec$BufferInfo:size	I
    //   1572: iadd
    //   1573: invokevirtual 840	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   1576: pop
    //   1577: aload 41
    //   1579: aload 31
    //   1581: invokeinterface 846 2 0
    //   1586: pop
    //   1587: aload 31
    //   1589: invokevirtual 390	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1592: pop
    //   1593: aload 40
    //   1595: iload_1
    //   1596: iconst_0
    //   1597: invokevirtual 850	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   1600: aload 40
    //   1602: aload 47
    //   1604: ldc2_w 377
    //   1607: invokevirtual 825	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   1610: istore_1
    //   1611: goto -92 -> 1519
    //   1614: getstatic 136	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   1617: ldc_w 1025
    //   1620: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1623: ifeq +4070 -> 5693
    //   1626: getstatic 141	android/os/Build:MODEL	Ljava/lang/String;
    //   1629: ldc_w 1027
    //   1632: invokevirtual 273	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1635: ifeq +4058 -> 5693
    //   1638: new 995	com/whatsapp/aqc
    //   1641: dup
    //   1642: iload 13
    //   1644: iload 14
    //   1646: invokespecial 998	com/whatsapp/aqc:<init>	(II)V
    //   1649: astore 35
    //   1651: goto -634 -> 1017
    //   1654: aload 35
    //   1656: getfield 1030	com/whatsapp/aqc:b	Landroid/view/Surface;
    //   1659: astore 32
    //   1661: goto -636 -> 1025
    //   1664: astore 32
    //   1666: new 98	java/lang/StringBuilder
    //   1669: dup
    //   1670: ldc_w 1032
    //   1673: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1676: aload 32
    //   1678: invokevirtual 1033	java/lang/IllegalStateException:toString	()Ljava/lang/String;
    //   1681: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1684: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1687: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1690: aload 31
    //   1692: invokevirtual 872	android/media/MediaCodec:release	()V
    //   1695: new 1035	java/util/ArrayList
    //   1698: dup
    //   1699: invokespecial 1036	java/util/ArrayList:<init>	()V
    //   1702: astore 36
    //   1704: iconst_0
    //   1705: istore_1
    //   1706: iload_1
    //   1707: iload 4
    //   1709: if_icmpge +117 -> 1826
    //   1712: iload_1
    //   1713: invokestatic 164	android/media/MediaCodecList:getCodecInfoAt	(I)Landroid/media/MediaCodecInfo;
    //   1716: astore 37
    //   1718: aload 37
    //   1720: invokevirtual 169	android/media/MediaCodecInfo:isEncoder	()Z
    //   1723: ifne +96 -> 1819
    //   1726: aload 37
    //   1728: invokevirtual 179	android/media/MediaCodecInfo:getSupportedTypes	()[Ljava/lang/String;
    //   1731: astore 38
    //   1733: iconst_0
    //   1734: istore_3
    //   1735: iconst_0
    //   1736: istore_2
    //   1737: iload_2
    //   1738: aload 38
    //   1740: arraylength
    //   1741: if_icmpge +28 -> 1769
    //   1744: iload_3
    //   1745: ifne +24 -> 1769
    //   1748: aload 38
    //   1750: iload_2
    //   1751: aaload
    //   1752: aload 33
    //   1754: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1757: ifeq +5 -> 1762
    //   1760: iconst_1
    //   1761: istore_3
    //   1762: iload_2
    //   1763: iconst_1
    //   1764: iadd
    //   1765: istore_2
    //   1766: goto -29 -> 1737
    //   1769: iload_3
    //   1770: ifeq +49 -> 1819
    //   1773: new 98	java/lang/StringBuilder
    //   1776: dup
    //   1777: ldc_w 1038
    //   1780: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1783: aload 37
    //   1785: invokevirtual 172	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   1788: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1791: ldc_w 1040
    //   1794: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1797: aload 38
    //   1799: invokestatic 1044	java/util/Arrays:deepToString	([Ljava/lang/Object;)Ljava/lang/String;
    //   1802: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1805: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1808: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1811: aload 36
    //   1813: aload 37
    //   1815: invokevirtual 1047	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1818: pop
    //   1819: iload_1
    //   1820: iconst_1
    //   1821: iadd
    //   1822: istore_1
    //   1823: goto -117 -> 1706
    //   1826: aload 36
    //   1828: invokevirtual 1049	java/util/ArrayList:isEmpty	()Z
    //   1831: ifeq +16 -> 1847
    //   1834: new 907	java/lang/IllegalStateException
    //   1837: dup
    //   1838: ldc_w 1051
    //   1841: aload 32
    //   1843: invokespecial 1053	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1846: athrow
    //   1847: aload 36
    //   1849: invokevirtual 1057	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1852: astore 32
    //   1854: aload 32
    //   1856: invokeinterface 1062 1 0
    //   1861: ifeq +3829 -> 5690
    //   1864: aload 32
    //   1866: invokeinterface 1066 1 0
    //   1871: checkcast 166	android/media/MediaCodecInfo
    //   1874: astore 36
    //   1876: new 98	java/lang/StringBuilder
    //   1879: dup
    //   1880: ldc_w 1068
    //   1883: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1886: aload 36
    //   1888: invokevirtual 172	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   1891: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1894: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1897: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1900: ldc_w 1070
    //   1903: aload 36
    //   1905: invokevirtual 172	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   1908: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1911: ifeq +30 -> 1941
    //   1914: new 98	java/lang/StringBuilder
    //   1917: dup
    //   1918: ldc_w 1072
    //   1921: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1924: aload 36
    //   1926: invokevirtual 172	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   1929: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1932: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1935: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1938: goto -84 -> 1854
    //   1941: aload 36
    //   1943: invokevirtual 172	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   1946: invokestatic 674	android/media/MediaCodec:createByCodecName	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   1949: astore 31
    //   1951: new 98	java/lang/StringBuilder
    //   1954: dup
    //   1955: ldc_w 1038
    //   1958: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1961: aload 36
    //   1963: invokevirtual 172	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   1966: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1969: ldc_w 1074
    //   1972: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1975: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1978: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1981: aload 31
    //   1983: aload 34
    //   1985: aconst_null
    //   1986: aconst_null
    //   1987: iconst_0
    //   1988: invokevirtual 696	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   1991: new 98	java/lang/StringBuilder
    //   1994: dup
    //   1995: ldc_w 1038
    //   1998: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2001: aload 36
    //   2003: invokevirtual 172	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   2006: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2009: ldc_w 1076
    //   2012: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2015: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2018: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2021: aload 31
    //   2023: ifnonnull +3660 -> 5683
    //   2026: new 98	java/lang/StringBuilder
    //   2029: dup
    //   2030: ldc_w 981
    //   2033: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2036: aload 33
    //   2038: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2041: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2044: invokestatic 960	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   2047: new 653	java/io/FileNotFoundException
    //   2050: dup
    //   2051: new 98	java/lang/StringBuilder
    //   2054: dup
    //   2055: ldc_w 1078
    //   2058: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2061: aload 33
    //   2063: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2066: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2069: invokespecial 656	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   2072: athrow
    //   2073: astore 36
    //   2075: aload 31
    //   2077: invokevirtual 872	android/media/MediaCodec:release	()V
    //   2080: aconst_null
    //   2081: astore 31
    //   2083: goto -229 -> 1854
    //   2086: aconst_null
    //   2087: astore 37
    //   2089: iconst_0
    //   2090: istore 28
    //   2092: aconst_null
    //   2093: astore 38
    //   2095: goto -844 -> 1251
    //   2098: aload 30
    //   2100: astore 34
    //   2102: aload 30
    //   2104: astore 33
    //   2106: aload 42
    //   2108: aload 49
    //   2110: iload 5
    //   2112: aaload
    //   2113: iconst_0
    //   2114: invokevirtual 1082	android/media/MediaExtractor:readSampleData	(Ljava/nio/ByteBuffer;I)I
    //   2117: istore 6
    //   2119: iload 6
    //   2121: ifge +1709 -> 3830
    //   2124: aload 30
    //   2126: astore 34
    //   2128: aload 30
    //   2130: astore 33
    //   2132: ldc_w 1084
    //   2135: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2138: aload 30
    //   2140: astore 34
    //   2142: aload 30
    //   2144: astore 33
    //   2146: aload 36
    //   2148: iload 5
    //   2150: iconst_0
    //   2151: iconst_0
    //   2152: lconst_0
    //   2153: iconst_4
    //   2154: invokevirtual 403	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   2157: iconst_1
    //   2158: istore 8
    //   2160: aload 30
    //   2162: astore 34
    //   2164: aload 30
    //   2166: astore 33
    //   2168: aload 36
    //   2170: aload 50
    //   2172: ldc2_w 377
    //   2175: invokevirtual 825	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   2178: istore 17
    //   2180: aload 30
    //   2182: astore 34
    //   2184: aload 30
    //   2186: astore 33
    //   2188: iload 9
    //   2190: getstatic 59	com/whatsapp/aqe:t	I
    //   2193: if_icmpge +32 -> 2225
    //   2196: aload 30
    //   2198: astore 34
    //   2200: aload 30
    //   2202: astore 33
    //   2204: new 98	java/lang/StringBuilder
    //   2207: dup
    //   2208: ldc_w 1086
    //   2211: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2214: iload 17
    //   2216: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2219: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2222: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2225: iload 17
    //   2227: iflt +2491 -> 4718
    //   2230: iconst_0
    //   2231: istore 7
    //   2233: iconst_0
    //   2234: istore 4
    //   2236: iconst_0
    //   2237: istore 5
    //   2239: aload 30
    //   2241: astore 34
    //   2243: aload 30
    //   2245: astore 33
    //   2247: aload 50
    //   2249: getfield 1089	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   2252: aload_0
    //   2253: getfield 92	com/whatsapp/aqe:p	J
    //   2256: ldc2_w 406
    //   2259: lmul
    //   2260: lcmp
    //   2261: iflt +2370 -> 4631
    //   2264: aload 30
    //   2266: astore 34
    //   2268: aload 30
    //   2270: astore 33
    //   2272: aload 40
    //   2274: ldc2_w 377
    //   2277: invokevirtual 384	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   2280: istore 10
    //   2282: aload 30
    //   2284: astore 34
    //   2286: aload 30
    //   2288: astore 33
    //   2290: iload 9
    //   2292: getstatic 59	com/whatsapp/aqe:t	I
    //   2295: if_icmpge +32 -> 2327
    //   2298: aload 30
    //   2300: astore 34
    //   2302: aload 30
    //   2304: astore 33
    //   2306: new 98	java/lang/StringBuilder
    //   2309: dup
    //   2310: ldc_w 790
    //   2313: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2316: iload 10
    //   2318: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2321: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2324: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2327: iload_2
    //   2328: istore 6
    //   2330: iload 4
    //   2332: istore 7
    //   2334: iload 10
    //   2336: iflt +3337 -> 5673
    //   2339: aload 46
    //   2341: iload 10
    //   2343: aaload
    //   2344: astore 32
    //   2346: aload 30
    //   2348: astore 34
    //   2350: aload 30
    //   2352: astore 33
    //   2354: aload 32
    //   2356: invokevirtual 390	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   2359: pop
    //   2360: aload 30
    //   2362: astore 34
    //   2364: aload 30
    //   2366: astore 33
    //   2368: aload_0
    //   2369: getfield 724	com/whatsapp/aqe:d	Lcom/whatsapp/doodle/a/b;
    //   2372: ifnull +127 -> 2499
    //   2375: iload 28
    //   2377: ifeq +122 -> 2499
    //   2380: aload 30
    //   2382: astore 34
    //   2384: aload 30
    //   2386: astore 33
    //   2388: aload_0
    //   2389: getfield 724	com/whatsapp/aqe:d	Lcom/whatsapp/doodle/a/b;
    //   2392: aload 50
    //   2394: getfield 1089	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   2397: ldc2_w 406
    //   2400: ldiv
    //   2401: invokevirtual 793	com/whatsapp/doodle/a/b:a	(J)V
    //   2404: aload 30
    //   2406: astore 34
    //   2408: aload 30
    //   2410: astore 33
    //   2412: aload 37
    //   2414: iconst_0
    //   2415: invokevirtual 797	android/graphics/Bitmap:eraseColor	(I)V
    //   2418: aload 30
    //   2420: astore 34
    //   2422: aload 30
    //   2424: astore 33
    //   2426: aload_0
    //   2427: getfield 724	com/whatsapp/aqe:d	Lcom/whatsapp/doodle/a/b;
    //   2430: aload 37
    //   2432: sipush 360
    //   2435: iload 11
    //   2437: isub
    //   2438: sipush 360
    //   2441: irem
    //   2442: invokevirtual 743	com/whatsapp/doodle/a/b:a	(Landroid/graphics/Bitmap;I)V
    //   2445: aload 30
    //   2447: astore 34
    //   2449: aload 30
    //   2451: astore 33
    //   2453: aload 38
    //   2455: invokevirtual 800	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   2458: pop
    //   2459: aload 30
    //   2461: astore 34
    //   2463: aload 30
    //   2465: astore 33
    //   2467: aload 37
    //   2469: aload 38
    //   2471: invokevirtual 757	android/graphics/Bitmap:copyPixelsToBuffer	(Ljava/nio/Buffer;)V
    //   2474: aload 30
    //   2476: astore 34
    //   2478: aload 30
    //   2480: astore 33
    //   2482: aload 48
    //   2484: aload 38
    //   2486: aload 37
    //   2488: invokevirtual 746	android/graphics/Bitmap:getWidth	()I
    //   2491: aload 37
    //   2493: invokevirtual 749	android/graphics/Bitmap:getHeight	()I
    //   2496: invokevirtual 760	com/whatsapp/VideoFrameConverter:a	(Ljava/nio/ByteBuffer;II)V
    //   2499: aload 35
    //   2501: ifnull +1683 -> 4184
    //   2504: aload 30
    //   2506: astore 34
    //   2508: aload 30
    //   2510: astore 33
    //   2512: aload 35
    //   2514: invokevirtual 1090	com/whatsapp/aqc:a	()V
    //   2517: aload 30
    //   2519: astore 34
    //   2521: aload 30
    //   2523: astore 33
    //   2525: aload 36
    //   2527: iload 17
    //   2529: iconst_1
    //   2530: invokevirtual 850	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   2533: aload 30
    //   2535: astore 34
    //   2537: aload 30
    //   2539: astore 33
    //   2541: aload 35
    //   2543: invokevirtual 1091	com/whatsapp/aqc:b	()V
    //   2546: aload 30
    //   2548: astore 34
    //   2550: aload 30
    //   2552: astore 33
    //   2554: aload 35
    //   2556: getfield 1094	com/whatsapp/aqc:c	Lcom/whatsapp/aqd;
    //   2559: astore 51
    //   2561: aload 30
    //   2563: astore 34
    //   2565: aload 30
    //   2567: astore 33
    //   2569: aload 35
    //   2571: getfield 1097	com/whatsapp/aqc:a	Landroid/graphics/SurfaceTexture;
    //   2574: astore 52
    //   2576: aload 30
    //   2578: astore 34
    //   2580: aload 30
    //   2582: astore 33
    //   2584: ldc_w 1099
    //   2587: invokestatic 1103	com/whatsapp/aqd:a	(Ljava/lang/String;)V
    //   2590: aload 30
    //   2592: astore 34
    //   2594: aload 30
    //   2596: astore 33
    //   2598: aload 52
    //   2600: aload 51
    //   2602: getfield 1106	com/whatsapp/aqd:c	[F
    //   2605: invokevirtual 1112	android/graphics/SurfaceTexture:getTransformMatrix	([F)V
    //   2608: aload 30
    //   2610: astore 34
    //   2612: aload 30
    //   2614: astore 33
    //   2616: fconst_0
    //   2617: fconst_1
    //   2618: fconst_0
    //   2619: fconst_1
    //   2620: invokestatic 1118	android/opengl/GLES20:glClearColor	(FFFF)V
    //   2623: aload 30
    //   2625: astore 34
    //   2627: aload 30
    //   2629: astore 33
    //   2631: sipush 16640
    //   2634: invokestatic 1121	android/opengl/GLES20:glClear	(I)V
    //   2637: aload 30
    //   2639: astore 34
    //   2641: aload 30
    //   2643: astore 33
    //   2645: aload 51
    //   2647: getfield 1122	com/whatsapp/aqd:d	I
    //   2650: invokestatic 1125	android/opengl/GLES20:glUseProgram	(I)V
    //   2653: aload 30
    //   2655: astore 34
    //   2657: aload 30
    //   2659: astore 33
    //   2661: ldc_w 1126
    //   2664: invokestatic 1103	com/whatsapp/aqd:a	(Ljava/lang/String;)V
    //   2667: aload 30
    //   2669: astore 34
    //   2671: aload 30
    //   2673: astore 33
    //   2675: ldc_w 1127
    //   2678: invokestatic 1130	android/opengl/GLES20:glActiveTexture	(I)V
    //   2681: aload 30
    //   2683: astore 34
    //   2685: aload 30
    //   2687: astore 33
    //   2689: ldc_w 1131
    //   2692: aload 51
    //   2694: getfield 1132	com/whatsapp/aqd:e	I
    //   2697: invokestatic 1135	android/opengl/GLES20:glBindTexture	(II)V
    //   2700: aload 30
    //   2702: astore 34
    //   2704: aload 30
    //   2706: astore 33
    //   2708: aload 51
    //   2710: getfield 1138	com/whatsapp/aqd:a	Ljava/nio/FloatBuffer;
    //   2713: iconst_0
    //   2714: invokevirtual 1141	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   2717: pop
    //   2718: aload 30
    //   2720: astore 34
    //   2722: aload 30
    //   2724: astore 33
    //   2726: aload 51
    //   2728: getfield 1142	com/whatsapp/aqd:h	I
    //   2731: iconst_3
    //   2732: sipush 5126
    //   2735: iconst_0
    //   2736: bipush 20
    //   2738: aload 51
    //   2740: getfield 1138	com/whatsapp/aqd:a	Ljava/nio/FloatBuffer;
    //   2743: invokestatic 1146	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   2746: aload 30
    //   2748: astore 34
    //   2750: aload 30
    //   2752: astore 33
    //   2754: ldc_w 1148
    //   2757: invokestatic 1103	com/whatsapp/aqd:a	(Ljava/lang/String;)V
    //   2760: aload 30
    //   2762: astore 34
    //   2764: aload 30
    //   2766: astore 33
    //   2768: aload 51
    //   2770: getfield 1142	com/whatsapp/aqd:h	I
    //   2773: invokestatic 1151	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   2776: aload 30
    //   2778: astore 34
    //   2780: aload 30
    //   2782: astore 33
    //   2784: ldc_w 1153
    //   2787: invokestatic 1103	com/whatsapp/aqd:a	(Ljava/lang/String;)V
    //   2790: aload 30
    //   2792: astore 34
    //   2794: aload 30
    //   2796: astore 33
    //   2798: aload 51
    //   2800: getfield 1138	com/whatsapp/aqd:a	Ljava/nio/FloatBuffer;
    //   2803: iconst_3
    //   2804: invokevirtual 1141	java/nio/FloatBuffer:position	(I)Ljava/nio/Buffer;
    //   2807: pop
    //   2808: aload 30
    //   2810: astore 34
    //   2812: aload 30
    //   2814: astore 33
    //   2816: aload 51
    //   2818: getfield 1154	com/whatsapp/aqd:i	I
    //   2821: iconst_2
    //   2822: sipush 5126
    //   2825: iconst_0
    //   2826: bipush 20
    //   2828: aload 51
    //   2830: getfield 1138	com/whatsapp/aqd:a	Ljava/nio/FloatBuffer;
    //   2833: invokestatic 1146	android/opengl/GLES20:glVertexAttribPointer	(IIIZILjava/nio/Buffer;)V
    //   2836: aload 30
    //   2838: astore 34
    //   2840: aload 30
    //   2842: astore 33
    //   2844: ldc_w 1156
    //   2847: invokestatic 1103	com/whatsapp/aqd:a	(Ljava/lang/String;)V
    //   2850: aload 30
    //   2852: astore 34
    //   2854: aload 30
    //   2856: astore 33
    //   2858: aload 51
    //   2860: getfield 1154	com/whatsapp/aqd:i	I
    //   2863: invokestatic 1151	android/opengl/GLES20:glEnableVertexAttribArray	(I)V
    //   2866: aload 30
    //   2868: astore 34
    //   2870: aload 30
    //   2872: astore 33
    //   2874: ldc_w 1158
    //   2877: invokestatic 1103	com/whatsapp/aqd:a	(Ljava/lang/String;)V
    //   2880: aload 30
    //   2882: astore 34
    //   2884: aload 30
    //   2886: astore 33
    //   2888: aload 51
    //   2890: getfield 1160	com/whatsapp/aqd:b	[F
    //   2893: iconst_0
    //   2894: invokestatic 1166	android/opengl/Matrix:setIdentityM	([FI)V
    //   2897: aload 30
    //   2899: astore 34
    //   2901: aload 30
    //   2903: astore 33
    //   2905: aload 51
    //   2907: getfield 1167	com/whatsapp/aqd:f	I
    //   2910: iconst_1
    //   2911: iconst_0
    //   2912: aload 51
    //   2914: getfield 1160	com/whatsapp/aqd:b	[F
    //   2917: iconst_0
    //   2918: invokestatic 1171	android/opengl/GLES20:glUniformMatrix4fv	(IIZ[FI)V
    //   2921: aload 30
    //   2923: astore 34
    //   2925: aload 30
    //   2927: astore 33
    //   2929: aload 51
    //   2931: getfield 1172	com/whatsapp/aqd:g	I
    //   2934: iconst_1
    //   2935: iconst_0
    //   2936: aload 51
    //   2938: getfield 1106	com/whatsapp/aqd:c	[F
    //   2941: iconst_0
    //   2942: invokestatic 1171	android/opengl/GLES20:glUniformMatrix4fv	(IIZ[FI)V
    //   2945: aload 30
    //   2947: astore 34
    //   2949: aload 30
    //   2951: astore 33
    //   2953: iconst_5
    //   2954: iconst_0
    //   2955: iconst_4
    //   2956: invokestatic 1175	android/opengl/GLES20:glDrawArrays	(III)V
    //   2959: aload 30
    //   2961: astore 34
    //   2963: aload 30
    //   2965: astore 33
    //   2967: ldc_w 1176
    //   2970: invokestatic 1103	com/whatsapp/aqd:a	(Ljava/lang/String;)V
    //   2973: aload 30
    //   2975: astore 34
    //   2977: aload 30
    //   2979: astore 33
    //   2981: invokestatic 1179	android/opengl/GLES20:glFinish	()V
    //   2984: aload 30
    //   2986: astore 34
    //   2988: aload 30
    //   2990: astore 33
    //   2992: iconst_0
    //   2993: iconst_0
    //   2994: iload 13
    //   2996: iload 14
    //   2998: sipush 6407
    //   3001: sipush 5121
    //   3004: aload 39
    //   3006: invokestatic 1183	android/opengl/GLES20:glReadPixels	(IIIIIILjava/nio/Buffer;)V
    //   3009: aload 30
    //   3011: astore 34
    //   3013: aload 30
    //   3015: astore 33
    //   3017: aload 39
    //   3019: iconst_0
    //   3020: invokevirtual 834	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   3023: pop
    //   3024: aload 30
    //   3026: astore 34
    //   3028: aload 30
    //   3030: astore 33
    //   3032: aload 48
    //   3034: aload 39
    //   3036: aload 32
    //   3038: invokevirtual 395	com/whatsapp/VideoFrameConverter:a	(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;)V
    //   3041: iconst_1
    //   3042: istore 4
    //   3044: aload 30
    //   3046: astore 34
    //   3048: aload 30
    //   3050: astore 33
    //   3052: aload 40
    //   3054: iload 10
    //   3056: iconst_0
    //   3057: iload 15
    //   3059: aload 50
    //   3061: getfield 1089	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   3064: aload 50
    //   3066: getfield 1186	android/media/MediaCodec$BufferInfo:flags	I
    //   3069: invokevirtual 403	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   3072: aload 30
    //   3074: astore 34
    //   3076: aload 30
    //   3078: astore 33
    //   3080: aload_0
    //   3081: getfield 405	com/whatsapp/aqe:s	J
    //   3084: lconst_0
    //   3085: lcmp
    //   3086: ifeq +19 -> 3105
    //   3089: aload 30
    //   3091: astore 34
    //   3093: aload 30
    //   3095: astore 33
    //   3097: iload 9
    //   3099: getstatic 59	com/whatsapp/aqe:t	I
    //   3102: if_icmpge +17 -> 3119
    //   3105: aload 30
    //   3107: astore 34
    //   3109: aload 30
    //   3111: astore 33
    //   3113: ldc_w 804
    //   3116: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3119: aload 30
    //   3121: astore 34
    //   3123: aload 30
    //   3125: astore 33
    //   3127: aload_0
    //   3128: aload_0
    //   3129: getfield 405	com/whatsapp/aqe:s	J
    //   3132: lconst_1
    //   3133: ladd
    //   3134: putfield 405	com/whatsapp/aqe:s	J
    //   3137: aload 30
    //   3139: astore 34
    //   3141: aload 30
    //   3143: astore 33
    //   3145: aload 50
    //   3147: getfield 1089	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   3150: lconst_0
    //   3151: lcmp
    //   3152: ifle +29 -> 3181
    //   3155: aload 30
    //   3157: astore 34
    //   3159: aload 30
    //   3161: astore 33
    //   3163: aload_0
    //   3164: aload 50
    //   3166: getfield 1089	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   3169: aload_0
    //   3170: getfield 92	com/whatsapp/aqe:p	J
    //   3173: ldc2_w 406
    //   3176: lmul
    //   3177: lsub
    //   3178: putfield 409	com/whatsapp/aqe:r	J
    //   3181: iload_2
    //   3182: istore 5
    //   3184: aload 30
    //   3186: astore 34
    //   3188: aload 30
    //   3190: astore 33
    //   3192: aload_0
    //   3193: getfield 94	com/whatsapp/aqe:q	J
    //   3196: lconst_0
    //   3197: lcmp
    //   3198: ifle +83 -> 3281
    //   3201: iload_2
    //   3202: istore 5
    //   3204: aload 30
    //   3206: astore 34
    //   3208: aload 30
    //   3210: astore 33
    //   3212: aload 50
    //   3214: getfield 1089	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   3217: aload_0
    //   3218: getfield 94	com/whatsapp/aqe:q	J
    //   3221: ldc2_w 406
    //   3224: lmul
    //   3225: lcmp
    //   3226: ifle +55 -> 3281
    //   3229: aload 30
    //   3231: astore 34
    //   3233: aload 30
    //   3235: astore 33
    //   3237: new 98	java/lang/StringBuilder
    //   3240: dup
    //   3241: ldc_w 1188
    //   3244: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3247: aload 50
    //   3249: getfield 1089	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   3252: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3255: ldc_w 767
    //   3258: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3261: aload_0
    //   3262: getfield 94	com/whatsapp/aqe:q	J
    //   3265: ldc2_w 406
    //   3268: lmul
    //   3269: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3272: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3275: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3278: iconst_1
    //   3279: istore 5
    //   3281: iload 5
    //   3283: istore 6
    //   3285: iload 4
    //   3287: istore 7
    //   3289: lload 26
    //   3291: lconst_0
    //   3292: lcmp
    //   3293: ifeq +2380 -> 5673
    //   3296: aload 30
    //   3298: astore 34
    //   3300: aload 30
    //   3302: astore 33
    //   3304: aload_0
    //   3305: getfield 92	com/whatsapp/aqe:p	J
    //   3308: lconst_0
    //   3309: lcmp
    //   3310: ifgt +1180 -> 4490
    //   3313: lconst_0
    //   3314: lstore 22
    //   3316: aload 30
    //   3318: astore 34
    //   3320: aload 30
    //   3322: astore 33
    //   3324: aload_0
    //   3325: getfield 94	com/whatsapp/aqe:q	J
    //   3328: lconst_0
    //   3329: lcmp
    //   3330: ifgt +1181 -> 4511
    //   3333: lload 26
    //   3335: lstore 24
    //   3337: aload 30
    //   3339: astore 34
    //   3341: aload 30
    //   3343: astore 33
    //   3345: ldc2_w 1189
    //   3348: aload 50
    //   3350: getfield 1089	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   3353: lload 22
    //   3355: lsub
    //   3356: lmul
    //   3357: lload 24
    //   3359: lload 22
    //   3361: lsub
    //   3362: ldiv
    //   3363: l2i
    //   3364: istore_2
    //   3365: iload 5
    //   3367: istore 6
    //   3369: iload 4
    //   3371: istore 7
    //   3373: iload_2
    //   3374: iload_1
    //   3375: if_icmpeq +2298 -> 5673
    //   3378: aload 30
    //   3380: astore 34
    //   3382: iload 5
    //   3384: istore 6
    //   3386: iload 4
    //   3388: istore 7
    //   3390: aload 30
    //   3392: astore 33
    //   3394: aload_0
    //   3395: getfield 808	com/whatsapp/aqe:e	Lcom/whatsapp/xf$a;
    //   3398: ifnull +2275 -> 5673
    //   3401: aload 30
    //   3403: astore 34
    //   3405: aload 30
    //   3407: astore 33
    //   3409: aload_0
    //   3410: getfield 810	com/whatsapp/aqe:f	Z
    //   3413: ifne +2294 -> 5707
    //   3416: aload 30
    //   3418: astore 34
    //   3420: aload 30
    //   3422: astore 33
    //   3424: aload_0
    //   3425: getfield 808	com/whatsapp/aqe:e	Lcom/whatsapp/xf$a;
    //   3428: iload_2
    //   3429: invokeinterface 815 2 0
    //   3434: ifeq +2309 -> 5743
    //   3437: goto +2270 -> 5707
    //   3440: aload 30
    //   3442: astore 34
    //   3444: aload 30
    //   3446: astore 33
    //   3448: aload_0
    //   3449: iload 29
    //   3451: putfield 810	com/whatsapp/aqe:f	Z
    //   3454: iload_2
    //   3455: iconst_5
    //   3456: if_icmplt +9 -> 3465
    //   3459: iload_2
    //   3460: iconst_5
    //   3461: irem
    //   3462: ifne +2251 -> 5713
    //   3465: aload 30
    //   3467: astore 34
    //   3469: aload 30
    //   3471: astore 33
    //   3473: new 98	java/lang/StringBuilder
    //   3476: dup
    //   3477: ldc_w 817
    //   3480: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3483: iload_2
    //   3484: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3487: ldc_w 819
    //   3490: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3493: aload_0
    //   3494: getfield 405	com/whatsapp/aqe:s	J
    //   3497: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3500: ldc_w 821
    //   3503: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3506: aload_0
    //   3507: getfield 409	com/whatsapp/aqe:r	J
    //   3510: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3513: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3516: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3519: goto +2194 -> 5713
    //   3522: aload 30
    //   3524: astore 34
    //   3526: aload 30
    //   3528: astore 33
    //   3530: aload 40
    //   3532: aload 47
    //   3534: ldc2_w 377
    //   3537: invokevirtual 825	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   3540: istore 5
    //   3542: aload 30
    //   3544: astore 34
    //   3546: aload 30
    //   3548: astore 33
    //   3550: iload 9
    //   3552: getstatic 59	com/whatsapp/aqe:t	I
    //   3555: if_icmpge +32 -> 3587
    //   3558: aload 30
    //   3560: astore 34
    //   3562: aload 30
    //   3564: astore 33
    //   3566: new 98	java/lang/StringBuilder
    //   3569: dup
    //   3570: ldc_w 827
    //   3573: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3576: iload 5
    //   3578: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3581: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3584: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3587: iload 5
    //   3589: iflt +943 -> 4532
    //   3592: aload 30
    //   3594: iload 5
    //   3596: aaload
    //   3597: astore 32
    //   3599: aload 30
    //   3601: astore 34
    //   3603: aload 30
    //   3605: astore 33
    //   3607: aload 32
    //   3609: aload 47
    //   3611: getfield 830	android/media/MediaCodec$BufferInfo:offset	I
    //   3614: invokevirtual 834	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   3617: pop
    //   3618: aload 30
    //   3620: astore 34
    //   3622: aload 30
    //   3624: astore 33
    //   3626: aload 32
    //   3628: aload 47
    //   3630: getfield 830	android/media/MediaCodec$BufferInfo:offset	I
    //   3633: aload 47
    //   3635: getfield 837	android/media/MediaCodec$BufferInfo:size	I
    //   3638: iadd
    //   3639: invokevirtual 840	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   3642: pop
    //   3643: aload 30
    //   3645: astore 34
    //   3647: aload 30
    //   3649: astore 33
    //   3651: aload 41
    //   3653: aload 32
    //   3655: invokeinterface 846 2 0
    //   3660: pop
    //   3661: aload 30
    //   3663: astore 34
    //   3665: aload 30
    //   3667: astore 33
    //   3669: aload 32
    //   3671: invokevirtual 390	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   3674: pop
    //   3675: aload 30
    //   3677: astore 34
    //   3679: aload 30
    //   3681: astore 33
    //   3683: aload 40
    //   3685: iload 5
    //   3687: iconst_0
    //   3688: invokevirtual 850	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   3691: aload 30
    //   3693: astore 34
    //   3695: aload 30
    //   3697: astore 33
    //   3699: iload 9
    //   3701: getstatic 59	com/whatsapp/aqe:t	I
    //   3704: if_icmpge +2021 -> 5725
    //   3707: aload 30
    //   3709: astore 34
    //   3711: aload 30
    //   3713: astore 33
    //   3715: ldc_w 852
    //   3718: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3721: goto +2004 -> 5725
    //   3724: iload 5
    //   3726: ifne +19 -> 3745
    //   3729: aload 32
    //   3731: astore 34
    //   3733: aload 32
    //   3735: astore 33
    //   3737: aload 36
    //   3739: iload 17
    //   3741: iconst_0
    //   3742: invokevirtual 850	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   3745: aload 32
    //   3747: astore 34
    //   3749: aload 32
    //   3751: astore 33
    //   3753: iload 9
    //   3755: getstatic 59	com/whatsapp/aqe:t	I
    //   3758: if_icmpge +17 -> 3775
    //   3761: aload 32
    //   3763: astore 34
    //   3765: aload 32
    //   3767: astore 33
    //   3769: ldc_w 1192
    //   3772: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3775: iload_3
    //   3776: istore_2
    //   3777: iload 6
    //   3779: istore_3
    //   3780: aload 32
    //   3782: astore 30
    //   3784: iload 4
    //   3786: istore_1
    //   3787: aload 50
    //   3789: getfield 1186	android/media/MediaCodec$BufferInfo:flags	I
    //   3792: iconst_4
    //   3793: iand
    //   3794: ifeq +11 -> 3805
    //   3797: ldc_w 1194
    //   3800: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3803: iconst_1
    //   3804: istore_1
    //   3805: iload_2
    //   3806: istore 5
    //   3808: iload_3
    //   3809: istore 6
    //   3811: iload_1
    //   3812: istore_2
    //   3813: iload 8
    //   3815: istore 4
    //   3817: iload 9
    //   3819: istore 7
    //   3821: iload 5
    //   3823: istore_3
    //   3824: iload 6
    //   3826: istore_1
    //   3827: goto -2517 -> 1310
    //   3830: aload 30
    //   3832: astore 34
    //   3834: aload 30
    //   3836: astore 33
    //   3838: iload 9
    //   3840: getstatic 59	com/whatsapp/aqe:t	I
    //   3843: if_icmpge +46 -> 3889
    //   3846: aload 30
    //   3848: astore 34
    //   3850: aload 30
    //   3852: astore 33
    //   3854: new 98	java/lang/StringBuilder
    //   3857: dup
    //   3858: ldc_w 1196
    //   3861: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3864: iload 6
    //   3866: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3869: ldc_w 1198
    //   3872: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3875: aload 42
    //   3877: invokevirtual 1015	android/media/MediaExtractor:getSampleTime	()J
    //   3880: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3883: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3886: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3889: aload 30
    //   3891: astore 34
    //   3893: aload 30
    //   3895: astore 33
    //   3897: aload 36
    //   3899: iload 5
    //   3901: iconst_0
    //   3902: iload 6
    //   3904: aload 42
    //   3906: invokevirtual 1015	android/media/MediaExtractor:getSampleTime	()J
    //   3909: iconst_0
    //   3910: invokevirtual 403	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   3913: aload 30
    //   3915: astore 34
    //   3917: aload 30
    //   3919: astore 33
    //   3921: iload 9
    //   3923: getstatic 59	com/whatsapp/aqe:t	I
    //   3926: if_icmpge +32 -> 3958
    //   3929: aload 30
    //   3931: astore 34
    //   3933: aload 30
    //   3935: astore 33
    //   3937: new 98	java/lang/StringBuilder
    //   3940: dup
    //   3941: ldc_w 1200
    //   3944: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3947: iload 5
    //   3949: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3952: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3955: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3958: aload 30
    //   3960: astore 34
    //   3962: aload 30
    //   3964: astore 33
    //   3966: aload 42
    //   3968: invokevirtual 1203	android/media/MediaExtractor:advance	()Z
    //   3971: istore 29
    //   3973: iload 4
    //   3975: istore 8
    //   3977: aload 30
    //   3979: astore 34
    //   3981: aload 30
    //   3983: astore 33
    //   3985: iload 9
    //   3987: getstatic 59	com/whatsapp/aqe:t	I
    //   3990: if_icmpge -1830 -> 2160
    //   3993: aload 30
    //   3995: astore 34
    //   3997: aload 30
    //   3999: astore 33
    //   4001: new 98	java/lang/StringBuilder
    //   4004: dup
    //   4005: ldc_w 1205
    //   4008: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4011: iload 29
    //   4013: invokevirtual 884	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   4016: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4019: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   4022: iload 4
    //   4024: istore 8
    //   4026: goto -1866 -> 2160
    //   4029: astore 31
    //   4031: aload 34
    //   4033: astore 30
    //   4035: ldc_w 897
    //   4038: aload 31
    //   4040: invokestatic 433	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4043: aload 31
    //   4045: athrow
    //   4046: astore 31
    //   4048: aload 30
    //   4050: astore 33
    //   4052: aload 31
    //   4054: astore 30
    //   4056: aload 36
    //   4058: invokevirtual 867	android/media/MediaCodec:stop	()V
    //   4061: ldc_w 1021
    //   4064: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   4067: aload 36
    //   4069: invokevirtual 872	android/media/MediaCodec:release	()V
    //   4072: ldc_w 1023
    //   4075: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   4078: aload 40
    //   4080: aload 47
    //   4082: ldc2_w 377
    //   4085: invokevirtual 825	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   4088: istore_1
    //   4089: iload_1
    //   4090: iflt +1410 -> 5500
    //   4093: new 98	java/lang/StringBuilder
    //   4096: dup
    //   4097: ldc_w 862
    //   4100: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4103: iload_1
    //   4104: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4107: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4110: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   4113: aload 33
    //   4115: iload_1
    //   4116: aaload
    //   4117: astore 31
    //   4119: aload 31
    //   4121: aload 47
    //   4123: getfield 830	android/media/MediaCodec$BufferInfo:offset	I
    //   4126: invokevirtual 834	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   4129: pop
    //   4130: aload 31
    //   4132: aload 47
    //   4134: getfield 830	android/media/MediaCodec$BufferInfo:offset	I
    //   4137: aload 47
    //   4139: getfield 837	android/media/MediaCodec$BufferInfo:size	I
    //   4142: iadd
    //   4143: invokevirtual 840	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   4146: pop
    //   4147: aload 41
    //   4149: aload 31
    //   4151: invokeinterface 846 2 0
    //   4156: pop
    //   4157: aload 31
    //   4159: invokevirtual 390	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   4162: pop
    //   4163: aload 40
    //   4165: iload_1
    //   4166: iconst_0
    //   4167: invokevirtual 850	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   4170: aload 40
    //   4172: aload 47
    //   4174: ldc2_w 377
    //   4177: invokevirtual 825	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   4180: istore_1
    //   4181: goto -92 -> 4089
    //   4184: aload 31
    //   4186: iload 17
    //   4188: aaload
    //   4189: astore 51
    //   4191: aload 30
    //   4193: astore 34
    //   4195: aload 30
    //   4197: astore 33
    //   4199: aload 51
    //   4201: aload 50
    //   4203: getfield 830	android/media/MediaCodec$BufferInfo:offset	I
    //   4206: invokevirtual 834	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   4209: pop
    //   4210: aload 30
    //   4212: astore 34
    //   4214: aload 30
    //   4216: astore 33
    //   4218: aload 51
    //   4220: aload 50
    //   4222: getfield 830	android/media/MediaCodec$BufferInfo:offset	I
    //   4225: aload 50
    //   4227: getfield 837	android/media/MediaCodec$BufferInfo:size	I
    //   4230: iadd
    //   4231: invokevirtual 840	java/nio/ByteBuffer:limit	(I)Ljava/nio/Buffer;
    //   4234: pop
    //   4235: aload 30
    //   4237: astore 34
    //   4239: aload 30
    //   4241: astore 33
    //   4243: aload_0
    //   4244: getfield 405	com/whatsapp/aqe:s	J
    //   4247: lconst_0
    //   4248: lcmp
    //   4249: ifeq +19 -> 4268
    //   4252: aload 30
    //   4254: astore 34
    //   4256: aload 30
    //   4258: astore 33
    //   4260: iload 9
    //   4262: getstatic 59	com/whatsapp/aqe:t	I
    //   4265: if_icmpge +88 -> 4353
    //   4268: aload 30
    //   4270: astore 34
    //   4272: aload 30
    //   4274: astore 33
    //   4276: new 98	java/lang/StringBuilder
    //   4279: dup
    //   4280: ldc_w 1207
    //   4283: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4286: aload 50
    //   4288: getfield 830	android/media/MediaCodec$BufferInfo:offset	I
    //   4291: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4294: ldc_w 1209
    //   4297: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4300: aload 50
    //   4302: getfield 837	android/media/MediaCodec$BufferInfo:size	I
    //   4305: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4308: ldc_w 1211
    //   4311: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4314: aload 50
    //   4316: getfield 1089	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   4319: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4322: ldc_w 1213
    //   4325: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4328: aload 50
    //   4330: getfield 1186	android/media/MediaCodec$BufferInfo:flags	I
    //   4333: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4336: ldc_w 1215
    //   4339: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4342: iload 15
    //   4344: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4347: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4350: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   4353: aload 30
    //   4355: astore 34
    //   4357: aload 30
    //   4359: astore 33
    //   4361: aload_0
    //   4362: getfield 1217	com/whatsapp/aqe:i	[B
    //   4365: ifnonnull +50 -> 4415
    //   4368: aload 30
    //   4370: astore 34
    //   4372: aload 30
    //   4374: astore 33
    //   4376: aload 51
    //   4378: invokevirtual 1220	java/nio/ByteBuffer:remaining	()I
    //   4381: newarray <illegal type>
    //   4383: astore 52
    //   4385: aload 30
    //   4387: astore 34
    //   4389: aload 30
    //   4391: astore 33
    //   4393: aload 51
    //   4395: aload 52
    //   4397: invokevirtual 1224	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   4400: pop
    //   4401: aload 30
    //   4403: astore 34
    //   4405: aload 30
    //   4407: astore 33
    //   4409: aload_0
    //   4410: aload 52
    //   4412: putfield 1217	com/whatsapp/aqe:i	[B
    //   4415: aload 30
    //   4417: astore 34
    //   4419: aload 30
    //   4421: astore 33
    //   4423: aload 48
    //   4425: aload 51
    //   4427: aload 32
    //   4429: invokevirtual 395	com/whatsapp/VideoFrameConverter:a	(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;)V
    //   4432: aload 30
    //   4434: astore 34
    //   4436: aload 30
    //   4438: astore 33
    //   4440: aload_0
    //   4441: getfield 405	com/whatsapp/aqe:s	J
    //   4444: lconst_0
    //   4445: lcmp
    //   4446: ifeq +23 -> 4469
    //   4449: iload 5
    //   4451: istore 4
    //   4453: aload 30
    //   4455: astore 34
    //   4457: aload 30
    //   4459: astore 33
    //   4461: iload 9
    //   4463: getstatic 59	com/whatsapp/aqe:t	I
    //   4466: if_icmpge -1422 -> 3044
    //   4469: aload 30
    //   4471: astore 34
    //   4473: aload 30
    //   4475: astore 33
    //   4477: ldc_w 802
    //   4480: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   4483: iload 5
    //   4485: istore 4
    //   4487: goto -1443 -> 3044
    //   4490: aload 30
    //   4492: astore 34
    //   4494: aload 30
    //   4496: astore 33
    //   4498: aload_0
    //   4499: getfield 92	com/whatsapp/aqe:p	J
    //   4502: ldc2_w 406
    //   4505: lmul
    //   4506: lstore 22
    //   4508: goto -1192 -> 3316
    //   4511: aload 30
    //   4513: astore 34
    //   4515: aload 30
    //   4517: astore 33
    //   4519: aload_0
    //   4520: getfield 94	com/whatsapp/aqe:q	J
    //   4523: ldc2_w 406
    //   4526: lmul
    //   4527: lstore 24
    //   4529: goto -1192 -> 3337
    //   4532: iload 5
    //   4534: bipush -3
    //   4536: if_icmpne +41 -> 4577
    //   4539: aload 30
    //   4541: astore 34
    //   4543: aload 30
    //   4545: astore 33
    //   4547: aload 40
    //   4549: invokevirtual 709	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   4552: astore 32
    //   4554: aload 32
    //   4556: astore 34
    //   4558: aload 32
    //   4560: astore 33
    //   4562: ldc_w 854
    //   4565: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   4568: iload_2
    //   4569: istore 5
    //   4571: iload_1
    //   4572: istore 6
    //   4574: goto -850 -> 3724
    //   4577: iload 5
    //   4579: bipush -2
    //   4581: if_icmpne +1168 -> 5749
    //   4584: aload 30
    //   4586: astore 34
    //   4588: aload 30
    //   4590: astore 33
    //   4592: aload 40
    //   4594: invokevirtual 858	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   4597: astore 32
    //   4599: aload 30
    //   4601: astore 34
    //   4603: aload 30
    //   4605: astore 33
    //   4607: new 98	java/lang/StringBuilder
    //   4610: dup
    //   4611: ldc_w 860
    //   4614: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4617: aload 32
    //   4619: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4622: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4625: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   4628: goto +1121 -> 5749
    //   4631: iload_3
    //   4632: iconst_1
    //   4633: iadd
    //   4634: istore 10
    //   4636: aload 30
    //   4638: astore 32
    //   4640: iload_2
    //   4641: istore 4
    //   4643: iload 7
    //   4645: istore 5
    //   4647: iload 10
    //   4649: istore_3
    //   4650: iload_1
    //   4651: istore 6
    //   4653: aload 30
    //   4655: astore 34
    //   4657: aload 30
    //   4659: astore 33
    //   4661: iload 9
    //   4663: getstatic 59	com/whatsapp/aqe:t	I
    //   4666: if_icmpge -942 -> 3724
    //   4669: aload 30
    //   4671: astore 34
    //   4673: aload 30
    //   4675: astore 33
    //   4677: new 98	java/lang/StringBuilder
    //   4680: dup
    //   4681: ldc_w 1226
    //   4684: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4687: iload 10
    //   4689: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4692: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4695: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   4698: aload 30
    //   4700: astore 32
    //   4702: iload_2
    //   4703: istore 4
    //   4705: iload 7
    //   4707: istore 5
    //   4709: iload 10
    //   4711: istore_3
    //   4712: iload_1
    //   4713: istore 6
    //   4715: goto -991 -> 3724
    //   4718: iload 17
    //   4720: bipush -3
    //   4722: if_icmpne +45 -> 4767
    //   4725: aload 30
    //   4727: astore 34
    //   4729: aload 30
    //   4731: astore 33
    //   4733: aload 36
    //   4735: invokevirtual 709	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   4738: astore 31
    //   4740: aload 30
    //   4742: astore 34
    //   4744: aload 30
    //   4746: astore 33
    //   4748: ldc_w 1228
    //   4751: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   4754: iload_1
    //   4755: istore 4
    //   4757: iload_2
    //   4758: istore_1
    //   4759: iload_3
    //   4760: istore_2
    //   4761: iload 4
    //   4763: istore_3
    //   4764: goto -977 -> 3787
    //   4767: iload 17
    //   4769: bipush -2
    //   4771: if_icmpne +486 -> 5257
    //   4774: aload 30
    //   4776: astore 34
    //   4778: aload 30
    //   4780: astore 33
    //   4782: aload 36
    //   4784: invokevirtual 858	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   4787: aload 44
    //   4789: invokevirtual 172	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   4792: aload_0
    //   4793: getfield 670	com/whatsapp/aqe:g	Lcom/whatsapp/aqh;
    //   4796: invokestatic 223	com/whatsapp/aqe:a	(Landroid/media/MediaFormat;Ljava/lang/String;Lcom/whatsapp/aqh;)Lcom/whatsapp/aqe$a;
    //   4799: astore 32
    //   4801: aload 30
    //   4803: astore 34
    //   4805: aload 30
    //   4807: astore 33
    //   4809: aload_0
    //   4810: aload 32
    //   4812: putfield 1230	com/whatsapp/aqe:h	Lcom/whatsapp/aqe$a;
    //   4815: aload 30
    //   4817: astore 34
    //   4819: aload 30
    //   4821: astore 33
    //   4823: aload 32
    //   4825: getfield 242	com/whatsapp/aqe$a:a	I
    //   4828: istore 17
    //   4830: aload 30
    //   4832: astore 34
    //   4834: aload 30
    //   4836: astore 33
    //   4838: aload 32
    //   4840: getfield 245	com/whatsapp/aqe$a:b	I
    //   4843: istore 7
    //   4845: aload 30
    //   4847: astore 34
    //   4849: aload 30
    //   4851: astore 33
    //   4853: aload 32
    //   4855: getfield 248	com/whatsapp/aqe$a:c	I
    //   4858: istore 10
    //   4860: aload 30
    //   4862: astore 34
    //   4864: aload 30
    //   4866: astore 33
    //   4868: aload 32
    //   4870: getfield 252	com/whatsapp/aqe$a:f	I
    //   4873: istore 18
    //   4875: aload 30
    //   4877: astore 34
    //   4879: aload 30
    //   4881: astore 33
    //   4883: aload 32
    //   4885: getfield 256	com/whatsapp/aqe$a:g	I
    //   4888: istore 19
    //   4890: aload 30
    //   4892: astore 34
    //   4894: aload 30
    //   4896: astore 33
    //   4898: aload 32
    //   4900: getfield 260	com/whatsapp/aqe$a:h	I
    //   4903: istore 20
    //   4905: aload 30
    //   4907: astore 34
    //   4909: aload 30
    //   4911: astore 33
    //   4913: aload 32
    //   4915: getfield 264	com/whatsapp/aqe$a:i	I
    //   4918: istore 21
    //   4920: aload 30
    //   4922: astore 34
    //   4924: aload 30
    //   4926: astore 33
    //   4928: aload 44
    //   4930: invokevirtual 172	android/media/MediaCodecInfo:getName	()Ljava/lang/String;
    //   4933: astore 51
    //   4935: aload 30
    //   4937: astore 34
    //   4939: aload 30
    //   4941: astore 33
    //   4943: aload 51
    //   4945: invokestatic 280	com/whatsapp/aqe:c	(Ljava/lang/String;)Z
    //   4948: ifne +814 -> 5762
    //   4951: aload 30
    //   4953: astore 34
    //   4955: aload 30
    //   4957: astore 33
    //   4959: ldc_w 1232
    //   4962: aload 51
    //   4964: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4967: ifne +795 -> 5762
    //   4970: aload 30
    //   4972: astore 34
    //   4974: aload 30
    //   4976: astore 33
    //   4978: ldc_w 1234
    //   4981: aload 51
    //   4983: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4986: ifeq +795 -> 5781
    //   4989: goto +773 -> 5762
    //   4992: iload 7
    //   4994: istore 5
    //   4996: iload 10
    //   4998: istore 4
    //   5000: iload 6
    //   5002: ifne +43 -> 5045
    //   5005: aload 30
    //   5007: astore 34
    //   5009: aload 30
    //   5011: astore 33
    //   5013: aload 32
    //   5015: getfield 268	com/whatsapp/aqe$a:e	I
    //   5018: iload 10
    //   5020: invokestatic 328	java/lang/Math:max	(II)I
    //   5023: istore 4
    //   5025: aload 30
    //   5027: astore 34
    //   5029: aload 30
    //   5031: astore 33
    //   5033: aload 32
    //   5035: getfield 278	com/whatsapp/aqe$a:d	I
    //   5038: iload 7
    //   5040: invokestatic 328	java/lang/Math:max	(II)I
    //   5043: istore 5
    //   5045: aload 35
    //   5047: ifnonnull +721 -> 5768
    //   5050: aload 30
    //   5052: astore 34
    //   5054: aload 30
    //   5056: astore 33
    //   5058: aload 32
    //   5060: getfield 291	com/whatsapp/aqe$a:k	I
    //   5063: istore 6
    //   5065: aload 30
    //   5067: astore 34
    //   5069: aload 30
    //   5071: astore 33
    //   5073: aload 48
    //   5075: iload 6
    //   5077: iload 5
    //   5079: iload 4
    //   5081: iload 18
    //   5083: iload 20
    //   5085: iload 19
    //   5087: iload 21
    //   5089: iload 16
    //   5091: iload 13
    //   5093: iload 14
    //   5095: invokevirtual 763	com/whatsapp/VideoFrameConverter:a	(IIIIIIIIII)V
    //   5098: aload 30
    //   5100: astore 34
    //   5102: aload 30
    //   5104: astore 33
    //   5106: new 98	java/lang/StringBuilder
    //   5109: dup
    //   5110: ldc_w 1236
    //   5113: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5116: iload 17
    //   5118: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5121: ldc_w 773
    //   5124: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5127: iload 6
    //   5129: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5132: ldc_w 775
    //   5135: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5138: iload 5
    //   5140: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5143: ldc_w 767
    //   5146: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5149: iload 4
    //   5151: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5154: ldc_w 767
    //   5157: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5160: iload 18
    //   5162: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5165: ldc_w 767
    //   5168: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5171: iload 20
    //   5173: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5176: ldc_w 767
    //   5179: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5182: iload 19
    //   5184: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5187: ldc_w 767
    //   5190: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5193: iload 21
    //   5195: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5198: ldc_w 771
    //   5201: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5204: iload 12
    //   5206: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5209: ldc_w 773
    //   5212: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5215: iload 16
    //   5217: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5220: ldc_w 775
    //   5223: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5226: iload 13
    //   5228: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5231: ldc_w 767
    //   5234: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5237: iload 14
    //   5239: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5242: ldc_w 777
    //   5245: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5248: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5251: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   5254: goto +514 -> 5768
    //   5257: iload 17
    //   5259: iconst_m1
    //   5260: if_icmpne +400 -> 5660
    //   5263: iload 8
    //   5265: ifeq +395 -> 5660
    //   5268: aload 30
    //   5270: astore 34
    //   5272: aload 30
    //   5274: astore 33
    //   5276: aload 50
    //   5278: getfield 1186	android/media/MediaCodec$BufferInfo:flags	I
    //   5281: iconst_4
    //   5282: iand
    //   5283: ifne +17 -> 5300
    //   5286: aload 30
    //   5288: astore 34
    //   5290: aload 30
    //   5292: astore 33
    //   5294: ldc_w 1238
    //   5297: invokestatic 146	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   5300: iload_3
    //   5301: istore_2
    //   5302: iload_1
    //   5303: istore_3
    //   5304: iconst_1
    //   5305: istore_1
    //   5306: goto -1519 -> 3787
    //   5309: ldc_w 864
    //   5312: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   5315: aload 40
    //   5317: invokevirtual 867	android/media/MediaCodec:stop	()V
    //   5320: ldc_w 869
    //   5323: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   5326: aload 40
    //   5328: invokevirtual 872	android/media/MediaCodec:release	()V
    //   5331: ldc_w 874
    //   5334: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   5337: aload 42
    //   5339: invokevirtual 1239	android/media/MediaExtractor:release	()V
    //   5342: ldc_w 1241
    //   5345: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   5348: aload 48
    //   5350: getfield 875	com/whatsapp/VideoFrameConverter:a	I
    //   5353: invokestatic 877	com/whatsapp/VideoFrameConverter:release	(I)V
    //   5356: new 98	java/lang/StringBuilder
    //   5359: dup
    //   5360: ldc_w 881
    //   5363: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5366: aload_0
    //   5367: getfield 810	com/whatsapp/aqe:f	Z
    //   5370: invokevirtual 884	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5373: ldc_w 819
    //   5376: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5379: aload_0
    //   5380: getfield 405	com/whatsapp/aqe:s	J
    //   5383: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5386: ldc_w 886
    //   5389: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5392: aload_0
    //   5393: getfield 713	com/whatsapp/aqe:n	Ljava/io/File;
    //   5396: invokevirtual 890	java/io/File:length	()J
    //   5399: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5402: ldc_w 821
    //   5405: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5408: aload_0
    //   5409: getfield 409	com/whatsapp/aqe:r	J
    //   5412: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5415: ldc_w 1243
    //   5418: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5421: iload_3
    //   5422: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5425: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5428: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   5431: aload 41
    //   5433: invokeinterface 878 1 0
    //   5438: aload 45
    //   5440: invokevirtual 879	java/io/FileOutputStream:close	()V
    //   5443: aload_0
    //   5444: getfield 810	com/whatsapp/aqe:f	Z
    //   5447: ifne +116 -> 5563
    //   5450: aload_0
    //   5451: getfield 713	com/whatsapp/aqe:n	Ljava/io/File;
    //   5454: invokevirtual 890	java/io/File:length	()J
    //   5457: lconst_0
    //   5458: lcmp
    //   5459: ifeq +12 -> 5471
    //   5462: aload_0
    //   5463: getfield 405	com/whatsapp/aqe:s	J
    //   5466: lconst_0
    //   5467: lcmp
    //   5468: ifne +95 -> 5563
    //   5471: aload_0
    //   5472: getfield 86	com/whatsapp/aqe:v	Lcom/whatsapp/util/a/c;
    //   5475: aload_0
    //   5476: getfield 88	com/whatsapp/aqe:b	Ljava/io/File;
    //   5479: new 894	com/whatsapp/util/MediaFileUtils$c
    //   5482: dup
    //   5483: invokespecial 895	com/whatsapp/util/MediaFileUtils$c:<init>	()V
    //   5486: ldc_w 1245
    //   5489: invokestatic 1248	com/whatsapp/Mp4Ops:a	(Lcom/whatsapp/util/a/c;Ljava/io/File;Ljava/lang/Exception;Ljava/lang/String;)V
    //   5492: new 894	com/whatsapp/util/MediaFileUtils$c
    //   5495: dup
    //   5496: invokespecial 895	com/whatsapp/util/MediaFileUtils$c:<init>	()V
    //   5499: athrow
    //   5500: ldc_w 864
    //   5503: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   5506: aload 40
    //   5508: invokevirtual 867	android/media/MediaCodec:stop	()V
    //   5511: ldc_w 869
    //   5514: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   5517: aload 40
    //   5519: invokevirtual 872	android/media/MediaCodec:release	()V
    //   5522: ldc_w 874
    //   5525: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   5528: aload 42
    //   5530: invokevirtual 1239	android/media/MediaExtractor:release	()V
    //   5533: ldc_w 1241
    //   5536: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   5539: aload 48
    //   5541: getfield 875	com/whatsapp/VideoFrameConverter:a	I
    //   5544: invokestatic 877	com/whatsapp/VideoFrameConverter:release	(I)V
    //   5547: aload 30
    //   5549: athrow
    //   5550: astore 30
    //   5552: ldc_w 899
    //   5555: aload 30
    //   5557: invokestatic 433	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5560: goto -117 -> 5443
    //   5563: aload_0
    //   5564: getfield 409	com/whatsapp/aqe:r	J
    //   5567: lconst_0
    //   5568: lcmp
    //   5569: ifne +21 -> 5590
    //   5572: aload_0
    //   5573: getstatic 1254	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   5576: aload_0
    //   5577: getfield 405	com/whatsapp/aqe:s	J
    //   5580: invokevirtual 1257	java/util/concurrent/TimeUnit:toMicros	(J)J
    //   5583: ldc2_w 1258
    //   5586: ldiv
    //   5587: putfield 409	com/whatsapp/aqe:r	J
    //   5590: aload 43
    //   5592: invokeinterface 901 1 0
    //   5597: new 98	java/lang/StringBuilder
    //   5600: dup
    //   5601: ldc_w 903
    //   5604: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5607: aload_0
    //   5608: getfield 713	com/whatsapp/aqe:n	Ljava/io/File;
    //   5611: invokevirtual 890	java/io/File:length	()J
    //   5614: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5617: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5620: invokestatic 160	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   5623: return
    //   5624: astore 31
    //   5626: aload 30
    //   5628: astore 33
    //   5630: aload 31
    //   5632: astore 30
    //   5634: goto -1578 -> 4056
    //   5637: astore 31
    //   5639: aload 30
    //   5641: astore 33
    //   5643: aload 31
    //   5645: astore 30
    //   5647: goto -1591 -> 4056
    //   5650: astore 31
    //   5652: goto -1617 -> 4035
    //   5655: astore 31
    //   5657: goto -1622 -> 4035
    //   5660: iload_1
    //   5661: istore 4
    //   5663: iload_2
    //   5664: istore_1
    //   5665: iload_3
    //   5666: istore_2
    //   5667: iload 4
    //   5669: istore_3
    //   5670: goto -1883 -> 3787
    //   5673: iload 6
    //   5675: istore 4
    //   5677: iload 7
    //   5679: istore_2
    //   5680: goto -2158 -> 3522
    //   5683: aload 31
    //   5685: astore 36
    //   5687: goto -4641 -> 1046
    //   5690: goto -3669 -> 2021
    //   5693: aconst_null
    //   5694: astore 35
    //   5696: goto -4679 -> 1017
    //   5699: iconst_m1
    //   5700: istore_1
    //   5701: goto -4994 -> 707
    //   5704: goto -5506 -> 198
    //   5707: iconst_1
    //   5708: istore 29
    //   5710: goto -2270 -> 3440
    //   5713: iload_2
    //   5714: istore_1
    //   5715: iload 4
    //   5717: istore_2
    //   5718: iload 5
    //   5720: istore 4
    //   5722: goto -2200 -> 3522
    //   5725: aload 30
    //   5727: astore 32
    //   5729: iload_2
    //   5730: istore 5
    //   5732: iload_1
    //   5733: istore 6
    //   5735: goto -2011 -> 3724
    //   5738: astore 30
    //   5740: goto -1684 -> 4056
    //   5743: iconst_0
    //   5744: istore 29
    //   5746: goto -2306 -> 3440
    //   5749: aload 30
    //   5751: astore 32
    //   5753: iload_2
    //   5754: istore 5
    //   5756: iload_1
    //   5757: istore 6
    //   5759: goto -2035 -> 3724
    //   5762: iconst_1
    //   5763: istore 6
    //   5765: goto -773 -> 4992
    //   5768: iload_1
    //   5769: istore 4
    //   5771: iload_2
    //   5772: istore_1
    //   5773: iload_3
    //   5774: istore_2
    //   5775: iload 4
    //   5777: istore_3
    //   5778: goto -1991 -> 3787
    //   5781: iconst_0
    //   5782: istore 6
    //   5784: goto -792 -> 4992
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5787	0	this	aqe
    //   43	5730	1	i1	int
    //   49	5726	2	i2	int
    //   55	5723	3	i3	int
    //   212	5564	4	i4	int
    //   300	5455	5	i5	int
    //   2117	3666	6	i6	int
    //   1299	4379	7	i7	int
    //   1382	3882	8	i8	int
    //   1333	3334	9	i9	int
    //   2280	2739	10	i10	int
    //   61	2377	11	i11	int
    //   357	4848	12	i12	int
    //   364	4863	13	i13	int
    //   371	4867	14	i14	int
    //   400	3943	15	i15	int
    //   546	4670	16	i16	int
    //   2178	3083	17	i17	int
    //   4873	288	18	i18	int
    //   4888	295	19	i19	int
    //   4903	269	20	i20	int
    //   4918	276	21	i21	int
    //   3314	1193	22	l1	long
    //   3335	1193	24	l2	long
    //   804	2530	26	l3	long
    //   1176	1200	28	bool1	boolean
    //   3449	2296	29	bool2	boolean
    //   36	525	30	localObject1	Object
    //   882	2830	30	localIllegalArgumentException	IllegalArgumentException
    //   3782	1766	30	localObject2	Object
    //   5550	77	30	localIOException	IOException
    //   5632	94	30	localObject3	Object
    //   5738	12	30	localObject4	Object
    //   427	1655	31	localObject5	Object
    //   4029	15	31	localException1	Exception
    //   4046	7	31	localObject6	Object
    //   4117	622	31	localObject7	Object
    //   5624	7	31	localObject8	Object
    //   5637	7	31	localObject9	Object
    //   5650	1	31	localException2	Exception
    //   5655	29	31	localException3	Exception
    //   652	1008	32	localObject10	Object
    //   1664	178	32	localIllegalStateException	IllegalStateException
    //   1852	3900	32	localObject11	Object
    //   748	4894	33	localObject12	Object
    //   738	4551	34	localObject13	Object
    //   1009	4686	35	localaqc	aqc
    //   1044	958	36	localObject14	Object
    //   2073	2710	36	localException4	Exception
    //   5685	1	36	localException5	Exception
    //   1188	1304	37	localObject15	Object
    //   1225	1260	38	localObject16	Object
    //   1252	1783	39	localByteBuffer	ByteBuffer
    //   410	5108	40	localMediaCodec	MediaCodec
    //   580	4852	41	localFileChannel	java.nio.channels.FileChannel
    //   589	4940	42	localMediaExtractor	android.media.MediaExtractor
    //   6	5585	43	locald	d
    //   217	4712	44	localMediaCodecInfo	MediaCodecInfo
    //   573	4866	45	localFileOutputStream	java.io.FileOutputStream
    //   553	1787	46	arrayOfByteBuffer1	ByteBuffer[]
    //   1087	3086	47	localBufferInfo1	android.media.MediaCodec.BufferInfo
    //   1160	4380	48	localVideoFrameConverter	VideoFrameConverter
    //   1062	1047	49	arrayOfByteBuffer2	ByteBuffer[]
    //   1078	4199	50	localBufferInfo2	android.media.MediaCodec.BufferInfo
    //   2559	2423	51	localObject17	Object
    //   2574	1837	52	localObject18	Object
    // Exception table:
    //   from	to	target	type
    //   841	848	882	java/lang/IllegalArgumentException
    //   1025	1042	1664	java/lang/IllegalStateException
    //   1654	1661	1664	java/lang/IllegalStateException
    //   1981	2021	2073	java/lang/Exception
    //   1322	1329	4029	java/lang/Exception
    //   1343	1351	4029	java/lang/Exception
    //   1359	1380	4029	java/lang/Exception
    //   1397	1407	4029	java/lang/Exception
    //   1415	1423	4029	java/lang/Exception
    //   1431	1452	4029	java/lang/Exception
    //   1465	1486	4029	java/lang/Exception
    //   2106	2119	4029	java/lang/Exception
    //   2132	2138	4029	java/lang/Exception
    //   2146	2157	4029	java/lang/Exception
    //   2168	2180	4029	java/lang/Exception
    //   2188	2196	4029	java/lang/Exception
    //   2204	2225	4029	java/lang/Exception
    //   2247	2264	4029	java/lang/Exception
    //   2272	2282	4029	java/lang/Exception
    //   2290	2298	4029	java/lang/Exception
    //   2306	2327	4029	java/lang/Exception
    //   2354	2360	4029	java/lang/Exception
    //   2368	2375	4029	java/lang/Exception
    //   2388	2404	4029	java/lang/Exception
    //   2412	2418	4029	java/lang/Exception
    //   2426	2445	4029	java/lang/Exception
    //   2453	2459	4029	java/lang/Exception
    //   2467	2474	4029	java/lang/Exception
    //   2482	2499	4029	java/lang/Exception
    //   2512	2517	4029	java/lang/Exception
    //   2525	2533	4029	java/lang/Exception
    //   2541	2546	4029	java/lang/Exception
    //   2554	2561	4029	java/lang/Exception
    //   2569	2576	4029	java/lang/Exception
    //   2584	2590	4029	java/lang/Exception
    //   2598	2608	4029	java/lang/Exception
    //   2616	2623	4029	java/lang/Exception
    //   2631	2637	4029	java/lang/Exception
    //   2645	2653	4029	java/lang/Exception
    //   2661	2667	4029	java/lang/Exception
    //   2675	2681	4029	java/lang/Exception
    //   2689	2700	4029	java/lang/Exception
    //   2708	2718	4029	java/lang/Exception
    //   2726	2746	4029	java/lang/Exception
    //   2754	2760	4029	java/lang/Exception
    //   2768	2776	4029	java/lang/Exception
    //   2784	2790	4029	java/lang/Exception
    //   2798	2808	4029	java/lang/Exception
    //   2816	2836	4029	java/lang/Exception
    //   2844	2850	4029	java/lang/Exception
    //   2858	2866	4029	java/lang/Exception
    //   2874	2880	4029	java/lang/Exception
    //   2888	2897	4029	java/lang/Exception
    //   2905	2921	4029	java/lang/Exception
    //   2929	2945	4029	java/lang/Exception
    //   2953	2959	4029	java/lang/Exception
    //   2967	2973	4029	java/lang/Exception
    //   2981	2984	4029	java/lang/Exception
    //   2992	3009	4029	java/lang/Exception
    //   3017	3024	4029	java/lang/Exception
    //   3032	3041	4029	java/lang/Exception
    //   3052	3072	4029	java/lang/Exception
    //   3080	3089	4029	java/lang/Exception
    //   3097	3105	4029	java/lang/Exception
    //   3113	3119	4029	java/lang/Exception
    //   3127	3137	4029	java/lang/Exception
    //   3145	3155	4029	java/lang/Exception
    //   3163	3181	4029	java/lang/Exception
    //   3192	3201	4029	java/lang/Exception
    //   3212	3229	4029	java/lang/Exception
    //   3237	3278	4029	java/lang/Exception
    //   3304	3313	4029	java/lang/Exception
    //   3324	3333	4029	java/lang/Exception
    //   3345	3365	4029	java/lang/Exception
    //   3394	3401	4029	java/lang/Exception
    //   3409	3416	4029	java/lang/Exception
    //   3424	3437	4029	java/lang/Exception
    //   3448	3454	4029	java/lang/Exception
    //   3473	3519	4029	java/lang/Exception
    //   3530	3542	4029	java/lang/Exception
    //   3550	3558	4029	java/lang/Exception
    //   3566	3587	4029	java/lang/Exception
    //   3607	3618	4029	java/lang/Exception
    //   3626	3643	4029	java/lang/Exception
    //   3651	3661	4029	java/lang/Exception
    //   3669	3675	4029	java/lang/Exception
    //   3683	3691	4029	java/lang/Exception
    //   3699	3707	4029	java/lang/Exception
    //   3715	3721	4029	java/lang/Exception
    //   3737	3745	4029	java/lang/Exception
    //   3753	3761	4029	java/lang/Exception
    //   3769	3775	4029	java/lang/Exception
    //   3838	3846	4029	java/lang/Exception
    //   3854	3889	4029	java/lang/Exception
    //   3897	3913	4029	java/lang/Exception
    //   3921	3929	4029	java/lang/Exception
    //   3937	3958	4029	java/lang/Exception
    //   3966	3973	4029	java/lang/Exception
    //   3985	3993	4029	java/lang/Exception
    //   4001	4022	4029	java/lang/Exception
    //   4199	4210	4029	java/lang/Exception
    //   4218	4235	4029	java/lang/Exception
    //   4243	4252	4029	java/lang/Exception
    //   4260	4268	4029	java/lang/Exception
    //   4276	4353	4029	java/lang/Exception
    //   4361	4368	4029	java/lang/Exception
    //   4376	4385	4029	java/lang/Exception
    //   4393	4401	4029	java/lang/Exception
    //   4409	4415	4029	java/lang/Exception
    //   4423	4432	4029	java/lang/Exception
    //   4440	4449	4029	java/lang/Exception
    //   4461	4469	4029	java/lang/Exception
    //   4477	4483	4029	java/lang/Exception
    //   4498	4508	4029	java/lang/Exception
    //   4519	4529	4029	java/lang/Exception
    //   4547	4554	4029	java/lang/Exception
    //   4562	4568	4029	java/lang/Exception
    //   4592	4599	4029	java/lang/Exception
    //   4607	4628	4029	java/lang/Exception
    //   4661	4669	4029	java/lang/Exception
    //   4677	4698	4029	java/lang/Exception
    //   4733	4740	4029	java/lang/Exception
    //   4748	4754	4029	java/lang/Exception
    //   4782	4801	4029	java/lang/Exception
    //   4809	4815	4029	java/lang/Exception
    //   4823	4830	4029	java/lang/Exception
    //   4838	4845	4029	java/lang/Exception
    //   4853	4860	4029	java/lang/Exception
    //   4868	4875	4029	java/lang/Exception
    //   4883	4890	4029	java/lang/Exception
    //   4898	4905	4029	java/lang/Exception
    //   4913	4920	4029	java/lang/Exception
    //   4928	4935	4029	java/lang/Exception
    //   4943	4951	4029	java/lang/Exception
    //   4959	4970	4029	java/lang/Exception
    //   4978	4989	4029	java/lang/Exception
    //   5013	5025	4029	java/lang/Exception
    //   5033	5045	4029	java/lang/Exception
    //   5058	5065	4029	java/lang/Exception
    //   5073	5098	4029	java/lang/Exception
    //   5106	5254	4029	java/lang/Exception
    //   5276	5286	4029	java/lang/Exception
    //   5294	5300	4029	java/lang/Exception
    //   4035	4046	4046	finally
    //   5431	5443	5550	java/io/IOException
    //   1259	1298	5624	finally
    //   3787	3803	5637	finally
    //   1259	1298	5650	java/lang/Exception
    //   3787	3803	5655	java/lang/Exception
    //   1322	1329	5738	finally
    //   1343	1351	5738	finally
    //   1359	1380	5738	finally
    //   1397	1407	5738	finally
    //   1415	1423	5738	finally
    //   1431	1452	5738	finally
    //   1465	1486	5738	finally
    //   2106	2119	5738	finally
    //   2132	2138	5738	finally
    //   2146	2157	5738	finally
    //   2168	2180	5738	finally
    //   2188	2196	5738	finally
    //   2204	2225	5738	finally
    //   2247	2264	5738	finally
    //   2272	2282	5738	finally
    //   2290	2298	5738	finally
    //   2306	2327	5738	finally
    //   2354	2360	5738	finally
    //   2368	2375	5738	finally
    //   2388	2404	5738	finally
    //   2412	2418	5738	finally
    //   2426	2445	5738	finally
    //   2453	2459	5738	finally
    //   2467	2474	5738	finally
    //   2482	2499	5738	finally
    //   2512	2517	5738	finally
    //   2525	2533	5738	finally
    //   2541	2546	5738	finally
    //   2554	2561	5738	finally
    //   2569	2576	5738	finally
    //   2584	2590	5738	finally
    //   2598	2608	5738	finally
    //   2616	2623	5738	finally
    //   2631	2637	5738	finally
    //   2645	2653	5738	finally
    //   2661	2667	5738	finally
    //   2675	2681	5738	finally
    //   2689	2700	5738	finally
    //   2708	2718	5738	finally
    //   2726	2746	5738	finally
    //   2754	2760	5738	finally
    //   2768	2776	5738	finally
    //   2784	2790	5738	finally
    //   2798	2808	5738	finally
    //   2816	2836	5738	finally
    //   2844	2850	5738	finally
    //   2858	2866	5738	finally
    //   2874	2880	5738	finally
    //   2888	2897	5738	finally
    //   2905	2921	5738	finally
    //   2929	2945	5738	finally
    //   2953	2959	5738	finally
    //   2967	2973	5738	finally
    //   2981	2984	5738	finally
    //   2992	3009	5738	finally
    //   3017	3024	5738	finally
    //   3032	3041	5738	finally
    //   3052	3072	5738	finally
    //   3080	3089	5738	finally
    //   3097	3105	5738	finally
    //   3113	3119	5738	finally
    //   3127	3137	5738	finally
    //   3145	3155	5738	finally
    //   3163	3181	5738	finally
    //   3192	3201	5738	finally
    //   3212	3229	5738	finally
    //   3237	3278	5738	finally
    //   3304	3313	5738	finally
    //   3324	3333	5738	finally
    //   3345	3365	5738	finally
    //   3394	3401	5738	finally
    //   3409	3416	5738	finally
    //   3424	3437	5738	finally
    //   3448	3454	5738	finally
    //   3473	3519	5738	finally
    //   3530	3542	5738	finally
    //   3550	3558	5738	finally
    //   3566	3587	5738	finally
    //   3607	3618	5738	finally
    //   3626	3643	5738	finally
    //   3651	3661	5738	finally
    //   3669	3675	5738	finally
    //   3683	3691	5738	finally
    //   3699	3707	5738	finally
    //   3715	3721	5738	finally
    //   3737	3745	5738	finally
    //   3753	3761	5738	finally
    //   3769	3775	5738	finally
    //   3838	3846	5738	finally
    //   3854	3889	5738	finally
    //   3897	3913	5738	finally
    //   3921	3929	5738	finally
    //   3937	3958	5738	finally
    //   3966	3973	5738	finally
    //   3985	3993	5738	finally
    //   4001	4022	5738	finally
    //   4199	4210	5738	finally
    //   4218	4235	5738	finally
    //   4243	4252	5738	finally
    //   4260	4268	5738	finally
    //   4276	4353	5738	finally
    //   4361	4368	5738	finally
    //   4376	4385	5738	finally
    //   4393	4401	5738	finally
    //   4409	4415	5738	finally
    //   4423	4432	5738	finally
    //   4440	4449	5738	finally
    //   4461	4469	5738	finally
    //   4477	4483	5738	finally
    //   4498	4508	5738	finally
    //   4519	4529	5738	finally
    //   4547	4554	5738	finally
    //   4562	4568	5738	finally
    //   4592	4599	5738	finally
    //   4607	4628	5738	finally
    //   4661	4669	5738	finally
    //   4677	4698	5738	finally
    //   4733	4740	5738	finally
    //   4748	4754	5738	finally
    //   4782	4801	5738	finally
    //   4809	4815	5738	finally
    //   4823	4830	5738	finally
    //   4838	4845	5738	finally
    //   4853	4860	5738	finally
    //   4868	4875	5738	finally
    //   4883	4890	5738	finally
    //   4898	4905	5738	finally
    //   4913	4920	5738	finally
    //   4928	4935	5738	finally
    //   4943	4951	5738	finally
    //   4959	4970	5738	finally
    //   4978	4989	5738	finally
    //   5013	5025	5738	finally
    //   5033	5045	5738	finally
    //   5058	5065	5738	finally
    //   5073	5098	5738	finally
    //   5106	5254	5738	finally
    //   5276	5286	5738	finally
    //   5294	5300	5738	finally
  }
  
  public final void b()
  {
    this.f = true;
  }
  
  public final boolean c()
  {
    return this.n != null;
  }
  
  public final void d()
  {
    long l3 = 0L;
    Object localObject1 = null;
    Object localObject4 = com.whatsapp.k.c.a("VideoTranscoder_transcode");
    ((d)localObject4).a();
    this.n = new File(this.c.getAbsoluteFile() + ".h264");
    boolean bool1;
    long l1;
    try
    {
      if (pj.b(this.b))
      {
        h();
        bool1 = this.f;
        if (!bool1) {
          l1 = 30000L;
        }
        try
        {
          if (this.r > 0L) {
            l1 = 1000000000L * this.s / this.r;
          }
          Mp4Ops.a(this.c, null, this.n, 0, 0L, l1, this.r / 1000L);
          Mp4Ops.a(this.c, true);
          Mp4Ops.a("mux", null);
          this.n.delete();
          if (this.o != null) {
            this.o.delete();
          }
          if (!this.f) {
            break label834;
          }
          this.c.delete();
          return;
        }
        catch (Mp4Ops.a locala1)
        {
          Log.d("videotranscodequeue/libmp4muxexception", locala1);
          Mp4Ops.a(this.v, this.b, locala1, "mux");
          Mp4Ops.a("mux", null, locala1);
          throw locala1;
        }
      }
      i();
    }
    finally
    {
      this.n.delete();
      if (this.o != null) {
        this.o.delete();
      }
    }
    Object localObject3;
    Object localObject5;
    if (!this.b.exists())
    {
      localObject3 = new StringBuilder("videotranscoder/transcode/input file disappeared, ");
      localObject4 = this.b;
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("file_path=" + ((File)localObject4).getAbsolutePath() + ", ");
      bool1 = ((File)localObject4).exists();
      boolean bool2 = ((File)localObject4).canRead();
      boolean bool3 = ((File)localObject4).canWrite();
      ((StringBuilder)localObject5).append("exists=" + bool1 + ", ");
      ((StringBuilder)localObject5).append("canRead=" + bool2 + ", ");
      ((StringBuilder)localObject5).append("canWrite=" + bool3 + ", ");
      if (bool1) {
        ((StringBuilder)localObject5).append("length=" + ((File)localObject4).length() + ", ");
      }
      Log.e(((StringBuilder)localObject5).toString());
      this.v.a("input file missing after transcode", false, null, 3);
      throw new FileNotFoundException("input file missing after transcode");
    }
    if (!this.f)
    {
      bool1 = af.e(this.b);
      if (bool1) {}
    }
    for (;;)
    {
      try
      {
        this.o = new File(this.c.getAbsoluteFile() + ".aac");
        localObject5 = new ah.a(this.b, this.o);
        ((ah.a)localObject5).b = this.p;
        ((ah.a)localObject5).c = this.q;
        ((ah.a)localObject5).e = 96000;
        localObject5 = ((ah.a)localObject5).a();
        ((ah)localObject5).e = new aqf(this);
        ((ah)localObject5).a();
        bool1 = this.f;
        if (bool1) {
          break;
        }
        l1 = 30000L;
        try
        {
          if (this.r > 0L) {
            l1 = 1000000000L * this.s / this.r;
          }
          if (this.o != null)
          {
            l2 = l3;
            if (this.o.exists())
            {
              localObject3 = this.o;
              l2 = l3;
            }
            int i1 = new MediaFileUtils.f(this.b).d;
            Mp4Ops.a(this.c, (File)localObject3, this.n, i1, l2, l1, this.r / 1000L);
            Mp4Ops.a(this.c, true);
            Mp4Ops.a("mux", null);
          }
        }
        catch (Mp4Ops.a locala2)
        {
          Log.d("videotranscodequeue/libmp4muxexception", locala2);
          Mp4Ops.a(this.v, this.b, locala2, "mux");
          Mp4Ops.a("mux", null, locala2);
          throw locala2;
        }
        File localFile = this.b;
      }
      catch (MediaFileUtils.a locala)
      {
        throw new MediaFileUtils.c();
      }
      long l2 = this.p;
    }
    label834:
    ((d)localObject4).b();
  }
  
  public final void f()
  {
    try
    {
      Mp4Ops.a(this.b, this.c, this.p, this.q);
      Mp4Ops.a(this.c, true);
      Mp4Ops.a("trim", null);
      return;
    }
    catch (Mp4Ops.a locala)
    {
      Log.d("videotranscodequeue/libmp4muxexception", locala);
      Mp4Ops.a(this.v, this.b, locala, "trim");
      Mp4Ops.a("trim", null, locala);
      throw locala;
    }
  }
  
  public static final class a
  {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public String j;
    public int k;
    
    public a() {}
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
    }
  }
  
  static enum b
  {
    private b() {}
  }
  
  public static enum c
  {
    public static int[] a()
    {
      return (int[])e.clone();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aqe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */