package com.whatsapp.util;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.media.FaceDetector;
import android.media.FaceDetector.Face;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.support.annotation.Keep;
import android.system.ErrnoException;
import android.system.Os;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.whatsapp.DocumentPickerActivity;
import com.whatsapp.GifHelper;
import com.whatsapp.MediaData;
import com.whatsapp.Voip;
import com.whatsapp.ah;
import com.whatsapp.aic;
import com.whatsapp.and;
import com.whatsapp.aqe;
import com.whatsapp.aqe.c;
import com.whatsapp.av;
import com.whatsapp.di;
import com.whatsapp.gallerypicker.GalleryPicker;
import com.whatsapp.ng;
import com.whatsapp.oz;
import com.whatsapp.pi;
import com.whatsapp.pi.a;
import com.whatsapp.pj;
import com.whatsapp.protocol.j;
import com.whatsapp.pv;
import com.whatsapp.r;
import com.whatsapp.u;
import com.whatsapp.va;
import com.whatsapp.vv;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import pl.droidsonroids.gif.a;

public final class MediaFileUtils
{
  public static final String[] a = { "application/pdf", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "application/msword", "application/vnd.ms-excel", "application/vnd.ms-powerpoint", "text/plain", "application/rtf", "text/rtf", "text/csv" };
  public static BitmapFactory.Options b;
  private static final DecimalFormat c = new DecimalFormat("0000", new DecimalFormatSymbols(Locale.US));
  private static final byte[] d = { 69, 120, 105, 102, 0 };
  private static final byte[] e = { 74, 70, 73, 70, 0 };
  private static final byte[] f = { 74, 70, 88, 88, 0 };
  private static final int[] g = { 0, 208, 209, 210, 211, 212, 213, 214, 215 };
  private static int h = -1;
  private static String i;
  private static File j;
  
  static
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    b = localOptions;
    localOptions.inDither = true;
    b.inInputShareable = true;
    b.inPurgeable = true;
  }
  
  public static float a(int paramInt1, int paramInt2, long paramLong)
  {
    return a(paramInt1, paramInt2, paramLong, 9);
  }
  
  public static float a(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return 3.0F;
    }
    float f1 = 8000.0F * (aic.s << 10 << 10) / (paramInt1 * paramInt2 * 3 + 96000);
    f1 = Math.max(0.0F, f1 - (float)paramLong) / f1;
    return 3.0F + f1 * ((paramInt3 - 3) * f1);
  }
  
  private static int a(oz paramoz, String paramString, byte paramByte, int paramInt, boolean paramBoolean)
  {
    int i1 = 0;
    int k = -1;
    paramoz = paramoz.a(paramByte, paramInt, paramBoolean);
    int n = i1;
    int m = k;
    String str1;
    String str2;
    if (paramoz.exists())
    {
      paramoz = paramoz.listFiles();
      if (paramoz == null) {
        break label260;
      }
      paramString = a(paramByte, paramInt) + "-" + paramString + "-WA";
      i1 = paramoz.length;
      int i2 = paramoz.length;
      m = 0;
      if (m < i2)
      {
        str1 = paramoz[m].getName();
        n = k;
        if (str1.startsWith(paramString))
        {
          n = k;
          if (str1.length() > 19) {
            str2 = str1.substring(15, 19);
          }
        }
      }
    }
    label260:
    label299:
    for (;;)
    {
      try
      {
        n = Integer.parseInt(str2);
        if (n <= k) {
          break label299;
        }
        k = n;
        n = k;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Log.i("mediafileutils/findlargestfileindex/nfe:" + str1);
        n = k;
        continue;
      }
      m += 1;
      k = n;
      break;
      n = i1;
      for (m = k;; m = k)
      {
        Log.i("mediafileutils/findlargestfileindex mediaType:" + paramByte + " origin:" + paramInt + " fileIndex:" + m + " total:" + n);
        return m;
        Log.i("mediafileutils/findlargestfileindex/no files for mediaType:" + paramByte + " origin:" + paramInt);
        n = i1;
      }
    }
  }
  
  private static int a(DataInputStream paramDataInputStream, BufferedOutputStream paramBufferedOutputStream)
  {
    long l = aic.v << 10;
    int i1 = 0;
    int i2 = 0;
    byte[] arrayOfByte1 = new byte[2];
    byte[] arrayOfByte3 = new byte[2];
    byte[] arrayOfByte4 = new byte[5];
    Log.i("mediafileutils/stripmetadata begin stripping metadata");
    int n;
    int i4;
    int i6;
    byte[] arrayOfByte5;
    int i3;
    try
    {
      paramDataInputStream.readFully(arrayOfByte1);
      if (!a(arrayOfByte1, new byte[] { -1, -40 }))
      {
        Log.i("mediafileutils/stripmetadata not a jpeg");
        return -1;
      }
      paramBufferedOutputStream.write(arrayOfByte1);
      paramDataInputStream.readFully(arrayOfByte1);
      n = 4;
    }
    catch (EOFException localEOFException)
    {
      for (;;)
      {
        Log.d("mediafileutils/stripmetadata stream ended unexpectedly", localEOFException);
        return -1;
        n += 2;
        continue;
        n += 1;
        continue;
        if (n != i4 - 1) {
          break label610;
        }
        k = arrayOfByte5[n];
        if (k != -1) {
          break label585;
        }
        m = paramDataInputStream.readByte();
        if (d.a(g, m & 0xFF)) {
          break;
        }
        paramBufferedOutputStream.write(arrayOfByte5, 0, n);
        localEOFException[0] = k;
        localEOFException[1] = m;
        n = i3;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.d("mediafileutils/stripmetadata IOException", localIOException);
        return -1;
        paramBufferedOutputStream.write(arrayOfByte5, 0, n);
        paramBufferedOutputStream.write(k);
        paramBufferedOutputStream.write(m);
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        Log.e(localNullPointerException);
        return -1;
        label585:
        paramBufferedOutputStream.write(arrayOfByte5, 0, i4);
      }
    }
    finally
    {
      a.d.a(paramDataInputStream);
      a.d.a(paramBufferedOutputStream);
    }
    if (n < l)
    {
      if (arrayOfByte1[0] != -1)
      {
        Log.i("mediafileutils/stripmetadata not a marker" + be.a(arrayOfByte1));
        a.d.a(paramDataInputStream);
        a.d.a(paramBufferedOutputStream);
        return -1;
      }
      if (arrayOfByte1[1] == -39)
      {
        paramBufferedOutputStream.write(arrayOfByte1);
        a.d.a(paramDataInputStream);
        a.d.a(paramBufferedOutputStream);
        return n;
      }
      paramDataInputStream.readFully(arrayOfByte3);
      i4 = n + 2;
      i6 = ((arrayOfByte3[0] & 0xFF) << 8 | arrayOfByte3[1] & 0xFF) - 2;
      if (i6 <= 0)
      {
        Log.i("mediafileutils/invalid size bytes on marker");
        a.d.a(paramDataInputStream);
        a.d.a(paramBufferedOutputStream);
        return -1;
      }
      if (arrayOfByte1[1] != -38) {
        break label1013;
      }
      if (i2 == 0)
      {
        Log.i("mediafileutils/stripmetadata missing valid application signature before image");
        a.d.a(paramDataInputStream);
        a.d.a(paramBufferedOutputStream);
        return -1;
      }
      paramBufferedOutputStream.write(arrayOfByte1);
      paramBufferedOutputStream.write(arrayOfByte3);
      arrayOfByte5 = new byte[i6];
      paramDataInputStream.readFully(arrayOfByte5);
      i3 = i4 + i6;
      paramBufferedOutputStream.write(arrayOfByte5);
      arrayOfByte5 = new byte[' '];
      for (;;)
      {
        n = i3;
        if (i3 >= l) {
          break;
        }
        i4 = a(paramDataInputStream, arrayOfByte5, 8192);
        if (i4 == 0)
        {
          Log.i("mediafileutils/stripmetadata file terminated before EOI");
          a.d.a(paramDataInputStream);
          a.d.a(paramBufferedOutputStream);
          return -1;
        }
        i3 += i4;
        n = 0;
        int k;
        int m;
        if (n < i4 - 1)
        {
          k = arrayOfByte5[n];
          if (k == -1)
          {
            m = arrayOfByte5[(n + 1)];
            if (!d.a(g, m & 0xFF))
            {
              paramBufferedOutputStream.write(arrayOfByte5, 0, n);
              arrayOfByte1[0] = k;
              arrayOfByte1[1] = m;
              n = i3;
              break;
            }
          }
        }
        label610:
        paramBufferedOutputStream.write(arrayOfByte5, 0, i4);
      }
    }
    for (;;)
    {
      Log.i("mediafileutils/stripmetadata invalid APP marker");
      a.d.a(paramDataInputStream);
      a.d.a(paramBufferedOutputStream);
      return -1;
      paramDataInputStream.readFully(arrayOfByte4);
      i3 = i4 + 5;
      n = i6 - 5;
      if (a(arrayOfByte4, e))
      {
        if (i2 == 0)
        {
          paramBufferedOutputStream.write(-1);
          paramBufferedOutputStream.write(-32);
          paramBufferedOutputStream.write(arrayOfByte3);
          paramBufferedOutputStream.write(e);
          arrayOfByte5 = new byte[n];
          paramDataInputStream.readFully(arrayOfByte5);
          paramBufferedOutputStream.write(arrayOfByte5);
          n = 1;
        }
        for (i2 = i3;; i2 = i3)
        {
          paramDataInputStream.readFully(arrayOfByte2);
          i3 = i2 + 2;
          i2 = n;
          n = i3;
          break;
          a(paramDataInputStream, n);
          i3 += n;
          n = i2;
        }
      }
      if (a(arrayOfByte4, f))
      {
        a(paramDataInputStream, n);
        n = i3 + n;
      }
      for (;;)
      {
        paramDataInputStream.readFully(arrayOfByte2);
        break;
        Log.i("mediafileutils/stripmetadata invalid APP0 signature: " + be.a(arrayOfByte4));
        a.d.a(paramDataInputStream);
        a.d.a(paramBufferedOutputStream);
        return -1;
        int i5 = i4;
        i3 = i1;
        n = i6;
        if (i1 == 0)
        {
          paramDataInputStream.readFully(arrayOfByte4);
          i5 = i4 + 5;
          if (!a(arrayOfByte4, d))
          {
            Log.i("mediafileutils/stripmetadata invalid APP1 signature: " + be.a(arrayOfByte4));
            a.d.a(paramDataInputStream);
            a.d.a(paramBufferedOutputStream);
            return -1;
          }
          i3 = 1;
          n = i6 - 5;
        }
        a(paramDataInputStream, n);
        n = i5 + n;
        i1 = i3;
        continue;
        a(paramDataInputStream, i6);
        n = i4 + i6;
      }
      label1013:
      do
      {
        arrayOfByte5 = new byte[i6];
        paramDataInputStream.readFully(arrayOfByte5);
        paramBufferedOutputStream.write(arrayOfByte2);
        paramBufferedOutputStream.write(arrayOfByte3);
        paramBufferedOutputStream.write(arrayOfByte5);
        paramDataInputStream.readFully(arrayOfByte2);
        n = i4;
        break;
        Log.i("mediafileutils/stripmetadata file too large");
        a.d.a(paramDataInputStream);
        a.d.a(paramBufferedOutputStream);
        return -1;
      } while ((arrayOfByte2[1] & 0xFFFFFFF0) != -32);
      switch (arrayOfByte2[1])
      {
      }
    }
  }
  
  public static int a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte['က'];
    int k = 0;
    for (;;)
    {
      int m = paramInputStream.read(arrayOfByte, 0, 4096);
      if (m < 0) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, m);
      k += m;
    }
    return k;
  }
  
  private static int a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt)
  {
    int k = Math.min(paramInt, paramArrayOfByte.length);
    paramInt = 0;
    for (;;)
    {
      int m;
      if (paramInt < k)
      {
        m = paramInputStream.read(paramArrayOfByte, paramInt, k - paramInt);
        if (m != -1) {}
      }
      else
      {
        return paramInt;
      }
      paramInt += m;
    }
  }
  
  public static long a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (paramFile.getName().endsWith(".opus"))) {}
    while (pj.b(paramFile)) {
      return 0L;
    }
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramFile.getAbsolutePath());
      long l = Long.parseLong(localMediaMetadataRetriever.extractMetadata(9));
      return l;
    }
    catch (Exception paramFile)
    {
      Log.d("getmediadurationseconds", paramFile);
      localMediaMetadataRetriever.release();
    }
    return 0L;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt, float paramFloat)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    RectF localRectF = new RectF(0.0F, 0.0F, paramInt, paramInt);
    paramInt = (paramBitmap.getWidth() - paramBitmap.getHeight()) / 2;
    Rect localRect;
    if (paramInt > 0)
    {
      localRect = new Rect(paramInt, 0, paramBitmap.getWidth() - paramInt, paramBitmap.getHeight());
      localPaint.setAntiAlias(true);
      localPaint.setDither(true);
      localPaint.setFilterBitmap(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-1);
      if (paramFloat < 0.0F) {
        break label198;
      }
      localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    }
    for (;;)
    {
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect, localRectF, localPaint);
      return localBitmap;
      localRect = new Rect(0, -paramInt, paramBitmap.getWidth(), paramInt + paramBitmap.getHeight());
      break;
      label198:
      localCanvas.drawArc(localRectF, 0.0F, 360.0F, true, localPaint);
    }
  }
  
  public static Bitmap a(and paramand, Uri paramUri, int paramInt1, int paramInt2)
  {
    if ((paramUri == null) || (TextUtils.isEmpty(paramUri.toString()))) {
      throw new FileNotFoundException("No file " + paramUri);
    }
    Log.i("sample_rotate_image/from uri:" + paramUri);
    localMatrix = b(paramand, paramUri);
    localOptions = a(paramand, paramUri, paramInt1);
    try
    {
      Bitmap localBitmap = a(paramand, paramUri, paramInt1, paramInt2, localOptions, localMatrix);
      paramand = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOptions.inSampleSize <<= 1;
        Log.i("sample_rotate_image/oom " + localOptions.inSampleSize);
        paramand = a(paramand, paramUri, paramInt1, paramInt2, localOptions, localMatrix);
      }
    }
    Log.i("sample_rotate_image/final_size:" + paramand.getWidth() + " | " + paramand.getHeight());
    return paramand;
  }
  
  /* Error */
  private static Bitmap a(and paramand, Uri paramUri, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, Matrix paramMatrix)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 485	com/whatsapp/util/MediaFileUtils:a	(Lcom/whatsapp/and;Landroid/net/Uri;)Ljava/io/InputStream;
    //   5: invokestatic 488	a/a/a/a/d:a	(Ljava/io/InputStream;)[B
    //   8: astore_0
    //   9: aload_0
    //   10: iconst_0
    //   11: aload_0
    //   12: arraylength
    //   13: aload 4
    //   15: invokestatic 494	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   18: astore 4
    //   20: aload 4
    //   22: ifnull +19 -> 41
    //   25: aload 4
    //   27: invokevirtual 390	android/graphics/Bitmap:getWidth	()I
    //   30: ifeq +11 -> 41
    //   33: aload 4
    //   35: invokevirtual 393	android/graphics/Bitmap:getHeight	()I
    //   38: ifne +31 -> 69
    //   41: new 162	java/lang/StringBuilder
    //   44: dup
    //   45: ldc_w 496
    //   48: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   51: aload_1
    //   52: invokevirtual 461	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 207	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   61: new 23	com/whatsapp/util/MediaFileUtils$e
    //   64: dup
    //   65: invokespecial 497	com/whatsapp/util/MediaFileUtils$e:<init>	()V
    //   68: athrow
    //   69: aload 4
    //   71: astore_0
    //   72: aload 5
    //   74: ifnull +41 -> 115
    //   77: ldc_w 499
    //   80: invokestatic 207	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   83: aload 4
    //   85: iconst_0
    //   86: iconst_0
    //   87: aload 4
    //   89: invokevirtual 390	android/graphics/Bitmap:getWidth	()I
    //   92: aload 4
    //   94: invokevirtual 393	android/graphics/Bitmap:getHeight	()I
    //   97: aload 5
    //   99: iconst_1
    //   100: invokestatic 502	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   103: astore_0
    //   104: aload 4
    //   106: aload_0
    //   107: if_acmpeq +8 -> 115
    //   110: aload 4
    //   112: invokevirtual 505	android/graphics/Bitmap:recycle	()V
    //   115: aload_0
    //   116: astore_1
    //   117: iload_3
    //   118: ifle +244 -> 362
    //   121: aload_0
    //   122: invokevirtual 390	android/graphics/Bitmap:getWidth	()I
    //   125: iload_3
    //   126: if_icmpgt +13 -> 139
    //   129: aload_0
    //   130: astore_1
    //   131: aload_0
    //   132: invokevirtual 393	android/graphics/Bitmap:getHeight	()I
    //   135: iload_3
    //   136: if_icmple +226 -> 362
    //   139: new 162	java/lang/StringBuilder
    //   142: dup
    //   143: ldc_w 507
    //   146: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   149: aload_0
    //   150: invokevirtual 390	android/graphics/Bitmap:getWidth	()I
    //   153: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: ldc_w 477
    //   159: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: invokevirtual 393	android/graphics/Bitmap:getHeight	()I
    //   166: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   169: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 207	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   175: aload_0
    //   176: invokevirtual 390	android/graphics/Bitmap:getWidth	()I
    //   179: i2f
    //   180: iload_2
    //   181: i2f
    //   182: fdiv
    //   183: aload_0
    //   184: invokevirtual 393	android/graphics/Bitmap:getHeight	()I
    //   187: i2f
    //   188: iload_2
    //   189: i2f
    //   190: fdiv
    //   191: invokestatic 142	java/lang/Math:max	(FF)F
    //   194: fstore 6
    //   196: new 395	android/graphics/Rect
    //   199: dup
    //   200: iconst_0
    //   201: iconst_0
    //   202: aload_0
    //   203: invokevirtual 390	android/graphics/Bitmap:getWidth	()I
    //   206: i2f
    //   207: fload 6
    //   209: fdiv
    //   210: f2i
    //   211: aload_0
    //   212: invokevirtual 393	android/graphics/Bitmap:getHeight	()I
    //   215: i2f
    //   216: fload 6
    //   218: fdiv
    //   219: f2i
    //   220: invokespecial 398	android/graphics/Rect:<init>	(IIII)V
    //   223: astore 5
    //   225: aload 5
    //   227: aload 5
    //   229: getfield 510	android/graphics/Rect:right	I
    //   232: iconst_1
    //   233: invokestatic 512	java/lang/Math:max	(II)I
    //   236: putfield 510	android/graphics/Rect:right	I
    //   239: aload 5
    //   241: aload 5
    //   243: getfield 515	android/graphics/Rect:bottom	I
    //   246: iconst_1
    //   247: invokestatic 512	java/lang/Math:max	(II)I
    //   250: putfield 515	android/graphics/Rect:bottom	I
    //   253: new 395	android/graphics/Rect
    //   256: dup
    //   257: iconst_0
    //   258: iconst_0
    //   259: aload_0
    //   260: invokevirtual 390	android/graphics/Bitmap:getWidth	()I
    //   263: aload_0
    //   264: invokevirtual 393	android/graphics/Bitmap:getHeight	()I
    //   267: invokespecial 398	android/graphics/Rect:<init>	(IIII)V
    //   270: astore 7
    //   272: aload_0
    //   273: invokevirtual 519	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   276: astore 4
    //   278: aload 5
    //   280: invokevirtual 522	android/graphics/Rect:width	()I
    //   283: istore_2
    //   284: aload 5
    //   286: invokevirtual 525	android/graphics/Rect:height	()I
    //   289: istore_3
    //   290: aload 4
    //   292: astore_1
    //   293: aload 4
    //   295: ifnonnull +7 -> 302
    //   298: getstatic 370	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   301: astore_1
    //   302: iload_2
    //   303: iload_3
    //   304: aload_1
    //   305: invokestatic 374	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   308: astore_1
    //   309: new 376	android/graphics/Canvas
    //   312: dup
    //   313: aload_1
    //   314: invokespecial 379	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   317: astore 4
    //   319: new 381	android/graphics/Paint
    //   322: dup
    //   323: invokespecial 382	android/graphics/Paint:<init>	()V
    //   326: astore 8
    //   328: aload 8
    //   330: iconst_1
    //   331: invokevirtual 402	android/graphics/Paint:setAntiAlias	(Z)V
    //   334: aload 8
    //   336: iconst_1
    //   337: invokevirtual 408	android/graphics/Paint:setFilterBitmap	(Z)V
    //   340: aload 8
    //   342: iconst_1
    //   343: invokevirtual 405	android/graphics/Paint:setDither	(Z)V
    //   346: aload 4
    //   348: aload_0
    //   349: aload 7
    //   351: aload 5
    //   353: aload 8
    //   355: invokevirtual 528	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   358: aload_0
    //   359: invokevirtual 505	android/graphics/Bitmap:recycle	()V
    //   362: aload_1
    //   363: areturn
    //   364: astore_0
    //   365: ldc_w 530
    //   368: invokestatic 532	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   371: aload 4
    //   373: invokevirtual 505	android/graphics/Bitmap:recycle	()V
    //   376: aload_0
    //   377: athrow
    //   378: astore_1
    //   379: ldc_w 534
    //   382: invokestatic 532	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   385: aload_0
    //   386: invokevirtual 505	android/graphics/Bitmap:recycle	()V
    //   389: aload_1
    //   390: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	paramand	and
    //   0	391	1	paramUri	Uri
    //   0	391	2	paramInt1	int
    //   0	391	3	paramInt2	int
    //   0	391	4	paramOptions	BitmapFactory.Options
    //   0	391	5	paramMatrix	Matrix
    //   194	23	6	f1	float
    //   270	80	7	localRect	Rect
    //   326	28	8	localPaint	Paint
    // Exception table:
    //   from	to	target	type
    //   83	104	364	java/lang/OutOfMemoryError
    //   278	290	378	java/lang/OutOfMemoryError
    //   298	302	378	java/lang/OutOfMemoryError
    //   302	309	378	java/lang/OutOfMemoryError
  }
  
  /* Error */
  private static Bitmap a(and paramand, Uri paramUri, File paramFile, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 539	java/io/File:getParentFile	()Ljava/io/File;
    //   4: astore 9
    //   6: aload 9
    //   8: ifnull +31 -> 39
    //   11: aload 9
    //   13: invokevirtual 542	java/io/File:mkdirs	()Z
    //   16: istore 6
    //   18: new 162	java/lang/StringBuilder
    //   21: dup
    //   22: ldc_w 544
    //   25: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: iload 6
    //   30: invokevirtual 547	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   33: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 549	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   39: aload_0
    //   40: aload_1
    //   41: invokestatic 467	com/whatsapp/util/MediaFileUtils:b	(Lcom/whatsapp/and;Landroid/net/Uri;)Landroid/graphics/Matrix;
    //   44: astore 11
    //   46: aload_0
    //   47: aload_1
    //   48: iload 4
    //   50: invokestatic 470	com/whatsapp/util/MediaFileUtils:a	(Lcom/whatsapp/and;Landroid/net/Uri;I)Landroid/graphics/BitmapFactory$Options;
    //   53: astore 12
    //   55: iconst_1
    //   56: istore 8
    //   58: iconst_1
    //   59: istore 7
    //   61: iload 8
    //   63: istore 6
    //   65: aload 11
    //   67: ifnonnull +204 -> 271
    //   70: iload 8
    //   72: istore 6
    //   74: aload 12
    //   76: getfield 552	android/graphics/BitmapFactory$Options:outWidth	I
    //   79: iload 4
    //   81: if_icmpgt +190 -> 271
    //   84: iload 8
    //   86: istore 6
    //   88: aload 12
    //   90: getfield 555	android/graphics/BitmapFactory$Options:outHeight	I
    //   93: iload 4
    //   95: if_icmpgt +176 -> 271
    //   98: new 162	java/lang/StringBuilder
    //   101: dup
    //   102: ldc_w 557
    //   105: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: aload_1
    //   109: invokevirtual 461	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   112: ldc_w 559
    //   115: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload 12
    //   120: getfield 552	android/graphics/BitmapFactory$Options:outWidth	I
    //   123: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: ldc_w 561
    //   129: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload 12
    //   134: getfield 555	android/graphics/BitmapFactory$Options:outHeight	I
    //   137: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 207	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   146: new 234	java/io/DataInputStream
    //   149: dup
    //   150: aload_0
    //   151: aload_1
    //   152: invokestatic 485	com/whatsapp/util/MediaFileUtils:a	(Lcom/whatsapp/and;Landroid/net/Uri;)Ljava/io/InputStream;
    //   155: invokespecial 564	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   158: astore 9
    //   160: new 252	java/io/BufferedOutputStream
    //   163: dup
    //   164: new 566	java/io/FileOutputStream
    //   167: dup
    //   168: aload_2
    //   169: invokespecial 569	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   172: sipush 8192
    //   175: invokespecial 572	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   178: astore 10
    //   180: aload 9
    //   182: aload 10
    //   184: invokestatic 574	com/whatsapp/util/MediaFileUtils:a	(Ljava/io/DataInputStream;Ljava/io/BufferedOutputStream;)I
    //   187: istore 5
    //   189: iload 5
    //   191: iconst_m1
    //   192: if_icmpeq +165 -> 357
    //   195: iload 5
    //   197: ifeq +289 -> 486
    //   200: iload 5
    //   202: i2l
    //   203: getstatic 230	com/whatsapp/aic:v	I
    //   206: i2l
    //   207: bipush 10
    //   209: lshl
    //   210: lcmp
    //   211: ifle +140 -> 351
    //   214: goto +272 -> 486
    //   217: new 162	java/lang/StringBuilder
    //   220: dup
    //   221: ldc_w 576
    //   224: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   227: iload 5
    //   229: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: ldc_w 578
    //   235: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: getstatic 230	com/whatsapp/aic:v	I
    //   241: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: ldc_w 580
    //   247: invokevirtual 170	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: iload 6
    //   252: invokevirtual 547	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   255: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 207	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   261: aload 9
    //   263: invokevirtual 583	java/io/DataInputStream:close	()V
    //   266: aload 10
    //   268: invokevirtual 584	java/io/BufferedOutputStream:close	()V
    //   271: iload 6
    //   273: ifeq +186 -> 459
    //   276: aload_0
    //   277: aload_1
    //   278: iload 4
    //   280: iload 4
    //   282: aload 12
    //   284: aload 11
    //   286: invokestatic 473	com/whatsapp/util/MediaFileUtils:a	(Lcom/whatsapp/and;Landroid/net/Uri;IILandroid/graphics/BitmapFactory$Options;Landroid/graphics/Matrix;)Landroid/graphics/Bitmap;
    //   289: astore 9
    //   291: new 566	java/io/FileOutputStream
    //   294: dup
    //   295: aload_2
    //   296: invokespecial 569	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   299: astore_2
    //   300: aload 9
    //   302: getstatic 590	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   305: iload_3
    //   306: aload_2
    //   307: invokevirtual 594	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   310: istore 6
    //   312: aload_2
    //   313: invokevirtual 595	java/io/OutputStream:close	()V
    //   316: aload 9
    //   318: invokevirtual 505	android/graphics/Bitmap:recycle	()V
    //   321: iload 6
    //   323: ifne +136 -> 459
    //   326: invokestatic 600	com/whatsapp/vv:f	()J
    //   329: getstatic 230	com/whatsapp/aic:v	I
    //   332: bipush 10
    //   334: ishl
    //   335: i2l
    //   336: lcmp
    //   337: ifge +114 -> 451
    //   340: new 225	java/io/IOException
    //   343: dup
    //   344: ldc_w 602
    //   347: invokespecial 603	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   350: athrow
    //   351: iconst_0
    //   352: istore 6
    //   354: goto -137 -> 217
    //   357: ldc_w 605
    //   360: invokestatic 207	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   363: iload 7
    //   365: istore 6
    //   367: goto -106 -> 261
    //   370: astore_0
    //   371: aload 9
    //   373: astore_2
    //   374: aload 10
    //   376: astore_1
    //   377: aload_2
    //   378: ifnull +7 -> 385
    //   381: aload_2
    //   382: invokevirtual 583	java/io/DataInputStream:close	()V
    //   385: aload_1
    //   386: ifnull +7 -> 393
    //   389: aload_1
    //   390: invokevirtual 584	java/io/BufferedOutputStream:close	()V
    //   393: aload_0
    //   394: athrow
    //   395: astore 9
    //   397: aload 12
    //   399: aload 12
    //   401: getfield 480	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   404: iconst_1
    //   405: ishl
    //   406: putfield 480	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   409: new 162	java/lang/StringBuilder
    //   412: dup
    //   413: ldc_w 607
    //   416: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   419: aload 12
    //   421: getfield 480	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   424: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   427: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 207	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   433: aload_0
    //   434: aload_1
    //   435: iload 4
    //   437: iload 4
    //   439: aload 12
    //   441: aload 11
    //   443: invokestatic 473	com/whatsapp/util/MediaFileUtils:a	(Lcom/whatsapp/and;Landroid/net/Uri;IILandroid/graphics/BitmapFactory$Options;Landroid/graphics/Matrix;)Landroid/graphics/Bitmap;
    //   446: astore 9
    //   448: goto -157 -> 291
    //   451: new 225	java/io/IOException
    //   454: dup
    //   455: invokespecial 608	java/io/IOException:<init>	()V
    //   458: athrow
    //   459: aload_0
    //   460: aload_1
    //   461: bipush 100
    //   463: bipush 100
    //   465: invokestatic 610	com/whatsapp/util/MediaFileUtils:a	(Lcom/whatsapp/and;Landroid/net/Uri;II)Landroid/graphics/Bitmap;
    //   468: areturn
    //   469: astore_0
    //   470: aconst_null
    //   471: astore_2
    //   472: aconst_null
    //   473: astore_1
    //   474: goto -97 -> 377
    //   477: astore_0
    //   478: aconst_null
    //   479: astore_1
    //   480: aload 9
    //   482: astore_2
    //   483: goto -106 -> 377
    //   486: iconst_1
    //   487: istore 6
    //   489: goto -272 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	492	0	paramand	and
    //   0	492	1	paramUri	Uri
    //   0	492	2	paramFile	File
    //   0	492	3	paramInt1	int
    //   0	492	4	paramInt2	int
    //   187	41	5	k	int
    //   16	472	6	bool1	boolean
    //   59	305	7	bool2	boolean
    //   56	29	8	bool3	boolean
    //   4	368	9	localObject	Object
    //   395	1	9	localOutOfMemoryError	OutOfMemoryError
    //   446	35	9	localBitmap	Bitmap
    //   178	197	10	localBufferedOutputStream	BufferedOutputStream
    //   44	398	11	localMatrix	Matrix
    //   53	387	12	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   180	189	370	finally
    //   200	214	370	finally
    //   217	261	370	finally
    //   357	363	370	finally
    //   276	291	395	java/lang/OutOfMemoryError
    //   146	160	469	finally
    //   160	180	477	finally
  }
  
  private static BitmapFactory.Options a(and paramand, Uri paramUri, int paramInt)
  {
    if ((paramUri == null) || (TextUtils.isEmpty(paramUri.toString()))) {
      throw new FileNotFoundException("No file " + paramUri);
    }
    paramand = a(paramand, paramUri);
    if (paramand == null)
    {
      Log.e("sample_rotate_image/can't load inputstream");
      throw new FileNotFoundException("Cannot load bitmap stream " + paramUri);
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramand, null, localOptions);
    paramand.close();
    if ((localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
    {
      Log.i("sample_rotate_image/not_a_image:" + paramUri);
      throw new e();
    }
    localOptions.inSampleSize = 1;
    int k = Math.max(localOptions.outWidth, localOptions.outHeight);
    while (k / 2 > (paramInt << 3) / 10)
    {
      k /= 2;
      localOptions.inSampleSize <<= 1;
    }
    localOptions.inDither = true;
    localOptions.inJustDecodeBounds = false;
    localOptions.inScaled = false;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    Log.i("sample_rotate_image/width=" + localOptions.outWidth + " | height=" + localOptions.outHeight + " | sample_size=" + localOptions.inSampleSize);
    localOptions.inPreferQualityOverSpeed = true;
    return localOptions;
  }
  
  public static Matrix a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 6: 
      localMatrix = new Matrix();
      localMatrix.setRotate(90.0F);
      return localMatrix;
    case 3: 
      localMatrix = new Matrix();
      localMatrix.setRotate(180.0F);
      return localMatrix;
    case 8: 
      localMatrix = new Matrix();
      localMatrix.setRotate(270.0F);
      return localMatrix;
    case 2: 
      localMatrix = new Matrix();
      localMatrix.setValues(new float[] { -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F });
      return localMatrix;
    case 4: 
      localMatrix = new Matrix();
      localMatrix.setValues(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F });
      return localMatrix;
    case 5: 
      localMatrix = new Matrix();
      localMatrix.setValues(new float[] { 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F });
      return localMatrix;
    }
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(new float[] { 0.0F, -1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F });
    return localMatrix;
  }
  
  public static File a(Context paramContext, oz paramoz, byte paramByte, String paramString)
  {
    j = a(paramContext, paramoz, paramString, paramByte, 0, false);
    paramContext = paramContext.getSharedPreferences("com.whatsapp_preferences", 0).edit();
    paramContext.putString("external_file_image", j.getAbsolutePath());
    if (!paramContext.commit()) {
      Log.e("mediautils/generateexternalimagefile/save_prefs_failed");
    }
    return j;
  }
  
  public static File a(Context paramContext, oz paramoz, File paramFile, byte paramByte, int paramInt)
  {
    return a(paramContext, paramoz, "." + d.l(paramFile.getAbsolutePath()), paramByte, paramInt, true);
  }
  
  public static File a(Context paramContext, oz paramoz, String paramString, byte paramByte, int paramInt, boolean paramBoolean)
  {
    File localFile1 = null;
    int k = 0;
    File localFile2;
    for (;;)
    {
      localFile2 = localFile1;
      if (k >= 100) {
        break;
      }
      localFile1 = paramoz.a(a(paramContext, paramoz, paramByte, paramInt) + paramString, paramByte, paramInt, paramBoolean);
      localFile2 = localFile1;
      if (!localFile1.exists()) {
        break;
      }
      k += 1;
    }
    return localFile2;
  }
  
  public static File a(Context paramContext, oz paramoz, String paramString1, String paramString2, byte paramByte, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      paramContext = a(paramContext, paramoz, paramString1, paramByte, paramInt, false);
      return paramContext;
    }
    paramContext = null;
    int k = 0;
    label26:
    Object localObject;
    if (k < 1000)
    {
      localObject = new StringBuilder().append(paramString2);
      if (k != 0) {
        break label103;
      }
    }
    label103:
    for (paramContext = "";; paramContext = "-" + k)
    {
      localObject = paramoz.a(paramContext + paramString1, paramByte, paramInt, false);
      paramContext = (Context)localObject;
      if (!((File)localObject).exists()) {
        break;
      }
      k += 1;
      paramContext = (Context)localObject;
      break label26;
      break;
    }
  }
  
  public static File a(oz paramoz, String paramString)
  {
    return paramoz.a(paramString + ".doodle");
  }
  
  /* Error */
  public static File a(va paramva, oz paramoz, and paramand, Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 8
    //   9: aload_3
    //   10: invokevirtual 715	android/net/Uri:getScheme	()Ljava/lang/String;
    //   13: ifnull +16 -> 29
    //   16: aload_3
    //   17: invokevirtual 715	android/net/Uri:getScheme	()Ljava/lang/String;
    //   20: ldc_w 717
    //   23: invokevirtual 721	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifeq +17 -> 43
    //   29: new 152	java/io/File
    //   32: dup
    //   33: aload_3
    //   34: invokevirtual 724	android/net/Uri:getPath	()Ljava/lang/String;
    //   37: invokespecial 725	java/io/File:<init>	(Ljava/lang/String;)V
    //   40: astore_0
    //   41: aload_0
    //   42: areturn
    //   43: aload_2
    //   44: getfield 730	com/whatsapp/and:f	Landroid/content/ContentResolver;
    //   47: astore 12
    //   49: aload 12
    //   51: ifnonnull +246 -> 297
    //   54: ldc_w 732
    //   57: invokestatic 735	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   60: aconst_null
    //   61: astore 7
    //   63: aload 7
    //   65: ifnull +371 -> 436
    //   68: aload 7
    //   70: invokeinterface 740 1 0
    //   75: ifle +353 -> 428
    //   78: aload 7
    //   80: invokeinterface 743 1 0
    //   85: ifeq +343 -> 428
    //   88: aload 7
    //   90: iconst_0
    //   91: invokeinterface 746 2 0
    //   96: astore_2
    //   97: aload_2
    //   98: ifnull +324 -> 422
    //   101: new 152	java/io/File
    //   104: dup
    //   105: aload_2
    //   106: invokespecial 725	java/io/File:<init>	(Ljava/lang/String;)V
    //   109: astore 11
    //   111: aload 11
    //   113: invokevirtual 156	java/io/File:exists	()Z
    //   116: istore 5
    //   118: aload 11
    //   120: astore 6
    //   122: iload 5
    //   124: ifne +9 -> 133
    //   127: aconst_null
    //   128: astore_2
    //   129: aload 11
    //   131: astore 6
    //   133: aload 7
    //   135: invokeinterface 747 1 0
    //   140: aload 12
    //   142: ifnull +277 -> 419
    //   145: aload_2
    //   146: ifnonnull +273 -> 419
    //   149: aload_1
    //   150: aload_0
    //   151: invokestatic 750	com/whatsapp/util/MediaFileUtils:a	(Lcom/whatsapp/va;)Ljava/lang/String;
    //   154: invokevirtual 705	com/whatsapp/oz:a	(Ljava/lang/String;)Ljava/io/File;
    //   157: astore 7
    //   159: aload 12
    //   161: aload_3
    //   162: invokevirtual 756	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   165: astore_0
    //   166: aload_0
    //   167: ifnull +244 -> 411
    //   170: aload_0
    //   171: astore_1
    //   172: aload 10
    //   174: astore_2
    //   175: aload_0
    //   176: instanceof 758
    //   179: ifeq +15 -> 194
    //   182: aload_0
    //   183: astore_1
    //   184: aload 10
    //   186: astore_2
    //   187: aload_0
    //   188: checkcast 758	java/io/FileInputStream
    //   191: invokestatic 761	com/whatsapp/util/MediaFileUtils:a	(Ljava/io/FileInputStream;)V
    //   194: aload_0
    //   195: astore_1
    //   196: aload 10
    //   198: astore_2
    //   199: new 566	java/io/FileOutputStream
    //   202: dup
    //   203: aload 7
    //   205: invokespecial 569	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   208: astore_3
    //   209: sipush 4096
    //   212: newarray <illegal type>
    //   214: astore_1
    //   215: aload_0
    //   216: aload_1
    //   217: iconst_0
    //   218: sipush 4096
    //   221: invokevirtual 314	java/io/InputStream:read	([BII)I
    //   224: istore 4
    //   226: iload 4
    //   228: iflt +123 -> 351
    //   231: aload_3
    //   232: aload_1
    //   233: iconst_0
    //   234: iload 4
    //   236: invokevirtual 317	java/io/OutputStream:write	([BII)V
    //   239: goto -24 -> 215
    //   242: astore_1
    //   243: aload_3
    //   244: astore 6
    //   246: aload_1
    //   247: astore_3
    //   248: aload_0
    //   249: astore_1
    //   250: aload 6
    //   252: astore_2
    //   253: ldc_w 763
    //   256: aload_3
    //   257: invokestatic 765	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   260: aload_0
    //   261: astore_1
    //   262: aload 6
    //   264: astore_2
    //   265: new 225	java/io/IOException
    //   268: dup
    //   269: aload_3
    //   270: invokespecial 767	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   273: athrow
    //   274: astore_3
    //   275: aload_1
    //   276: astore_0
    //   277: aload_3
    //   278: astore_1
    //   279: aload_0
    //   280: ifnull +7 -> 287
    //   283: aload_0
    //   284: invokevirtual 622	java/io/InputStream:close	()V
    //   287: aload_2
    //   288: ifnull +7 -> 295
    //   291: aload_2
    //   292: invokevirtual 595	java/io/OutputStream:close	()V
    //   295: aload_1
    //   296: athrow
    //   297: ldc_w 769
    //   300: aload_3
    //   301: invokevirtual 772	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   304: invokevirtual 721	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   307: ifeq +28 -> 335
    //   310: aload 12
    //   312: aload_3
    //   313: iconst_1
    //   314: anewarray 43	java/lang/String
    //   317: dup
    //   318: iconst_0
    //   319: ldc_w 774
    //   322: aastore
    //   323: aconst_null
    //   324: aconst_null
    //   325: aconst_null
    //   326: invokevirtual 778	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   329: astore 7
    //   331: goto -268 -> 63
    //   334: astore_2
    //   335: aconst_null
    //   336: astore 7
    //   338: goto -275 -> 63
    //   341: astore_0
    //   342: aload 7
    //   344: invokeinterface 747 1 0
    //   349: aload_0
    //   350: athrow
    //   351: aload 7
    //   353: astore_1
    //   354: aload_0
    //   355: ifnull +7 -> 362
    //   358: aload_0
    //   359: invokevirtual 622	java/io/InputStream:close	()V
    //   362: aload_1
    //   363: astore_0
    //   364: aload_3
    //   365: ifnull -324 -> 41
    //   368: aload_3
    //   369: invokevirtual 595	java/io/OutputStream:close	()V
    //   372: aload_1
    //   373: areturn
    //   374: astore_1
    //   375: aconst_null
    //   376: astore_0
    //   377: aload 9
    //   379: astore_2
    //   380: goto -101 -> 279
    //   383: astore_1
    //   384: aload_3
    //   385: astore_2
    //   386: goto -107 -> 279
    //   389: astore_3
    //   390: aconst_null
    //   391: astore_0
    //   392: aload 8
    //   394: astore 6
    //   396: goto -148 -> 248
    //   399: astore_3
    //   400: aload 8
    //   402: astore 6
    //   404: goto -156 -> 248
    //   407: astore_2
    //   408: goto -73 -> 335
    //   411: aload 6
    //   413: astore_1
    //   414: aconst_null
    //   415: astore_3
    //   416: goto -62 -> 354
    //   419: aload 6
    //   421: areturn
    //   422: aconst_null
    //   423: astore 6
    //   425: goto -292 -> 133
    //   428: aconst_null
    //   429: astore_2
    //   430: aconst_null
    //   431: astore 6
    //   433: goto -300 -> 133
    //   436: aconst_null
    //   437: astore_2
    //   438: aconst_null
    //   439: astore 6
    //   441: goto -301 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	paramva	va
    //   0	444	1	paramoz	oz
    //   0	444	2	paramand	and
    //   0	444	3	paramUri	Uri
    //   224	11	4	k	int
    //   116	7	5	bool	boolean
    //   120	320	6	localObject1	Object
    //   61	291	7	localObject2	Object
    //   7	394	8	localObject3	Object
    //   4	374	9	localObject4	Object
    //   1	196	10	localObject5	Object
    //   109	21	11	localFile	File
    //   47	264	12	localContentResolver	ContentResolver
    // Exception table:
    //   from	to	target	type
    //   209	215	242	java/lang/SecurityException
    //   215	226	242	java/lang/SecurityException
    //   231	239	242	java/lang/SecurityException
    //   175	182	274	finally
    //   187	194	274	finally
    //   199	209	274	finally
    //   253	260	274	finally
    //   265	274	274	finally
    //   310	331	334	java/lang/UnsupportedOperationException
    //   68	97	341	finally
    //   101	118	341	finally
    //   149	166	374	finally
    //   209	215	383	finally
    //   215	226	383	finally
    //   231	239	383	finally
    //   149	166	389	java/lang/SecurityException
    //   175	182	399	java/lang/SecurityException
    //   187	194	399	java/lang/SecurityException
    //   199	209	399	java/lang/SecurityException
    //   310	331	407	java/lang/IllegalArgumentException
  }
  
  public static InputStream a(and paramand, Uri paramUri)
  {
    paramUri = paramUri.buildUpon().query(null).build();
    if ((paramUri.getScheme() == null) || (paramUri.getScheme().equals("file"))) {}
    for (paramand = new FileInputStream(new File(paramUri.getPath()));; paramand = paramand.openInputStream(paramUri))
    {
      if ((paramand instanceof FileInputStream)) {
        a((FileInputStream)paramand);
      }
      return paramand;
      paramand = paramand.f;
      if (paramand == null)
      {
        Log.w("media-file-utils/get-bitmap-stream cr=null");
        return null;
      }
    }
  }
  
  private static String a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return null;
    case 2: 
      if (paramInt2 == 1) {
        return "PTT";
      }
      return "AUD";
    case 3: 
    case 13: 
      return "VID";
    case 1: 
      return "IMG";
    }
    return "DOC";
  }
  
  private static String a(Context paramContext, oz paramoz, int paramInt1, int paramInt2)
  {
    try
    {
      a(paramContext, paramoz);
      paramContext = paramContext.getSharedPreferences("com.whatsapp_preferences", 0).edit();
      paramoz = l.a();
      if (!paramoz.equals(i))
      {
        h = 0;
        i = paramoz;
        paramContext.putString("file_date", i);
      }
      paramoz = a(paramInt1, paramInt2) + "-" + i + "-WA" + c.format(h);
      h += 1;
      paramContext.putInt("file_index", h);
      if (!paramContext.commit()) {
        Log.e("mediafileutils/initfilecounter/save_prefs_failed");
      }
      Log.i("mediafileutils/readablefilename/" + paramoz);
      return paramoz;
    }
    finally {}
  }
  
  public static String a(Uri paramUri)
  {
    paramUri = paramUri.getLastPathSegment();
    if (paramUri == null) {
      return "";
    }
    int k = paramUri.lastIndexOf('.');
    if (k == -1) {
      return "";
    }
    return paramUri.substring(k + 1);
  }
  
  public static String a(va paramva)
  {
    return r.a(paramva.b() + System.currentTimeMillis());
  }
  
  public static String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (av.l());
    try
    {
      str = a(new URL(paramString));
      return str;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      Log.w("redactedversion/not-url");
      if (paramString.length() <= 25) {
        return "***";
      }
    }
    return paramString.substring(0, paramString.length() - 25) + "***";
  }
  
  public static String a(URL paramURL)
  {
    if (paramURL == null) {
      return null;
    }
    if (av.l()) {
      return paramURL.toString();
    }
    String str2 = paramURL.getPath();
    if ((str2 != null) && (str2.length() > 25)) {}
    for (String str1 = str2.substring(0, str2.length() - 25);; str1 = "")
    {
      Uri.Builder localBuilder = new Uri.Builder();
      localBuilder.scheme(paramURL.getProtocol()).authority(paramURL.getHost()).path(str1 + "***" + str2.substring(str2.length() - 4)).encodedQuery(paramURL.getQuery());
      return localBuilder.build().toString();
    }
  }
  
  public static void a() {}
  
  public static void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, DocumentPickerActivity.class);
    localIntent.putExtra("jid", paramString);
    paramActivity.startActivityForResult(localIntent, 6);
  }
  
  public static void a(Activity paramActivity, String paramString, long paramLong, boolean paramBoolean)
  {
    Intent localIntent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.INTERNAL_CONTENT_URI, paramActivity, GalleryPicker.class);
    localIntent.putExtra("max_items", 30);
    localIntent.putExtra("jid", paramString);
    localIntent.putExtra("quoted_message_row_id", paramLong);
    localIntent.putExtra("number_from_url", paramBoolean);
    localIntent.putExtra("send", true);
    localIntent.putExtra("picker_open_time", SystemClock.elapsedRealtime());
    paramActivity.startActivityForResult(localIntent, 22);
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      if (h > 0)
      {
        paramContext = paramContext.getSharedPreferences("com.whatsapp_preferences", 0).edit();
        h -= 1;
        paramContext.putInt("file_index", h);
        if (!paramContext.commit()) {
          Log.e("mediafileutils/initfilecounter/save_prefs_failed");
        }
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void a(Context paramContext, Uri paramUri)
  {
    paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE").setData(paramUri));
  }
  
  public static void a(Context paramContext, oz paramoz)
  {
    for (;;)
    {
      try
      {
        k = h;
        if (k >= 0) {
          return;
        }
        paramContext = paramContext.getSharedPreferences("com.whatsapp_preferences", 0);
        h = paramContext.getInt("file_index", -1);
        i = paramContext.getString("file_date", null);
        if ((h >= 0) && (!TextUtils.isEmpty(i)))
        {
          Log.i("mediafileutils/initfilecounter file_index:" + h + " | file_date:" + i);
          continue;
        }
        i = l.a();
      }
      finally {}
      long l = System.currentTimeMillis();
      h = -1;
      int k = Math.max(-1, a(paramoz, i, (byte)2, 0, true));
      h = k;
      k = Math.max(k, a(paramoz, i, (byte)2, 0, false));
      h = k;
      k = Math.max(k, a(paramoz, i, (byte)2, 1, true));
      h = k;
      k = Math.max(k, a(paramoz, i, (byte)2, 1, false));
      h = k;
      k = Math.max(k, a(paramoz, i, (byte)3, 0, true));
      h = k;
      k = Math.max(k, a(paramoz, i, (byte)3, 0, false));
      h = k;
      k = Math.max(k, a(paramoz, i, (byte)1, 0, true));
      h = k;
      k = Math.max(k, a(paramoz, i, (byte)1, 0, false));
      h = k;
      k = Math.max(k, a(paramoz, i, (byte)9, 0, true));
      h = k;
      k = Math.max(k, a(paramoz, i, (byte)9, 0, false));
      h = k;
      h = k + 1;
      paramContext = paramContext.edit();
      paramContext.putInt("file_index", h);
      paramContext.putString("file_date", i);
      if (!paramContext.commit()) {
        Log.e("mediafileutils/initfilecounter/save_prefs_failed");
      }
      Log.i("mediafileutils/initfilecounter file_index:" + h + " | file_date:" + i + " |  time:" + (System.currentTimeMillis() - l));
    }
  }
  
  public static void a(Context paramContext, j paramj)
  {
    if ((paramj.s == 2) && (paramj.o == 1)) {}
    do
    {
      return;
      paramj = paramj.b().file;
    } while ((paramj == null) || (!paramj.exists()));
    a(paramContext, Uri.fromFile(paramj));
  }
  
  public static void a(Context paramContext, File paramFile)
  {
    paramFile = paramFile.getCanonicalPath();
    paramContext = new File(paramContext.getApplicationInfo().dataDir).getCanonicalPath();
    if (paramFile.startsWith(paramContext)) {
      throw new IOException("file is not external to application data directory; canonicalFilePath=" + paramFile + "; canonicalInternalPath=" + paramContext);
    }
  }
  
  public static void a(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    StatResult localStatResult = StatResult.statOpenFile(NativeUtils.getFileDescriptorForFileDescriptor(paramParcelFileDescriptor.getFileDescriptor()));
    if (Process.myUid() == localStatResult.a) {
      throw new IOException("file is owned by our application; not permitting nefarious file share operation; parcelFileDescriptor=" + paramParcelFileDescriptor);
    }
  }
  
  public static void a(di paramdi)
  {
    Log.e("native heap size:" + Debug.getNativeHeapAllocatedSize() / 1024L + " kB");
    paramdi.c();
  }
  
  public static void a(oz paramoz, int paramInt, Activity paramActivity)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    switch (paramInt)
    {
    default: 
      localObject1 = null;
    }
    for (;;)
    {
      paramoz = (oz)localObject1;
      if (!localArrayList.isEmpty())
      {
        paramoz = Intent.createChooser((Intent)localObject1, null);
        paramoz.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[])localArrayList.toArray(new Intent[localArrayList.size()]));
      }
      try
      {
        paramActivity.startActivityForResult(paramoz, paramInt);
        return;
      }
      catch (ActivityNotFoundException paramoz)
      {
        Intent localIntent1;
        Log.e("mediafileutils/start-activity " + paramoz);
        pv.a(paramActivity, 2131296289, 0);
      }
      localObject1 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.INTERNAL_CONTENT_URI);
      ((Intent)localObject1).setType("image/*");
      continue;
      localObject1 = new Intent("android.intent.action.PICK", MediaStore.Images.Media.INTERNAL_CONTENT_URI, paramActivity, GalleryPicker.class);
      ((Intent)localObject1).putExtra("max_items", 30);
      continue;
      localObject1 = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", d.a(paramActivity, a(paramActivity, paramoz, (byte)1, ".jpg")));
      ((Intent)localObject1).setFlags(2);
      continue;
      localIntent1 = new Intent("android.media.action.VIDEO_CAPTURE");
      localObject1 = localIntent1;
      if (Build.VERSION.SDK_INT == 18)
      {
        localObject1 = localIntent1;
        if (Build.MODEL.contains("Nexus"))
        {
          localIntent1.putExtra("output", Uri.fromFile(a(paramActivity, paramoz, (byte)3, ".mp4")));
          localObject1 = localIntent1;
          continue;
          if (Voip.e())
          {
            localObject1 = new Intent("android.intent.action.PICK", MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
          }
          else
          {
            localObject1 = new ArrayList();
            ((ArrayList)localObject1).add(new Intent("android.intent.action.GET_CONTENT").setType("audio/*").putExtra("android.provider.MediaStore.extra.MAX_BYTES", aic.s * 1048576L));
            ((ArrayList)localObject1).add(new Intent("android.intent.action.PICK", MediaStore.Audio.Media.EXTERNAL_CONTENT_URI));
            paramoz = new HashSet();
            localObject1 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localIntent1 = (Intent)((Iterator)localObject1).next();
              Object localObject2 = paramActivity.getPackageManager().queryIntentActivities(localIntent1, 0);
              if (localObject2 != null)
              {
                localObject2 = ((List)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  ActivityInfo localActivityInfo = ((ResolveInfo)((Iterator)localObject2).next()).activityInfo;
                  String str = localActivityInfo.applicationInfo.packageName;
                  Log.i("mediafileutils/audio " + str + " | " + localActivityInfo.name);
                  if (((str.contains("soundrecorder")) || (str.contains("music")) || (str.contains("voicerecorder")) || (str.contains("motorola.cmp"))) && (!paramoz.contains(str)))
                  {
                    Intent localIntent2 = (Intent)localIntent1.clone();
                    localIntent2.setClassName(str, localActivityInfo.name);
                    localIntent2.setPackage(str);
                    localArrayList.add(localIntent2);
                    paramoz.add(str);
                  }
                }
              }
            }
            localObject1 = new Intent("com.whatsapp.action.WHATSAPP_RECORDING").setType("audio/*");
          }
        }
      }
    }
  }
  
  public static void a(final pv parampv, va paramva, final oz paramoz, final and paramand, final Uri paramUri, final ng paramng, final d paramd)
  {
    paramng.a(0, 2131297138);
    bu.a(new AsyncTask()
    {
      private Object a()
      {
        try
        {
          File localFile = MediaFileUtils.a(this.a, paramoz, paramand, paramUri);
          return localFile;
        }
        catch (IOException localIOException)
        {
          return localIOException;
        }
      }
      
      protected final void onPostExecute(Object paramAnonymousObject)
      {
        paramng.d();
        if ((paramAnonymousObject instanceof File))
        {
          paramd.a((File)paramAnonymousObject);
          return;
        }
        if ((paramAnonymousObject instanceof IOException))
        {
          paramAnonymousObject = (IOException)paramAnonymousObject;
          Log.e("mediafileutils/getfilefrommediastoreasync/ioerror " + paramAnonymousObject);
          if ((((IOException)paramAnonymousObject).getMessage() != null) && (((IOException)paramAnonymousObject).getMessage().contains("No space")))
          {
            parampv.a(paramng, u.a().getString(2131296742));
            return;
          }
          pv.a(u.a(), 2131297841, 0);
          return;
        }
        pv.a(u.a(), 2131297841, 0);
      }
    }, new Void[0]);
  }
  
  /* Error */
  public static void a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 758	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 792	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: astore_0
    //   11: aload_0
    //   12: invokestatic 761	com/whatsapp/util/MediaFileUtils:a	(Ljava/io/FileInputStream;)V
    //   15: aload_1
    //   16: invokevirtual 539	java/io/File:getParentFile	()Ljava/io/File;
    //   19: astore 4
    //   21: aload 4
    //   23: ifnull +29 -> 52
    //   26: aload 4
    //   28: invokevirtual 542	java/io/File:mkdirs	()Z
    //   31: istore_2
    //   32: new 162	java/lang/StringBuilder
    //   35: dup
    //   36: ldc_w 1255
    //   39: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: iload_2
    //   43: invokevirtual 547	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   46: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 549	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   52: new 566	java/io/FileOutputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 569	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   60: astore_1
    //   61: aload_0
    //   62: aload_1
    //   63: invokestatic 1257	com/whatsapp/util/MediaFileUtils:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   66: pop
    //   67: aload_0
    //   68: invokevirtual 1258	java/io/FileInputStream:close	()V
    //   71: aload_1
    //   72: invokevirtual 595	java/io/OutputStream:close	()V
    //   75: return
    //   76: astore_0
    //   77: aconst_null
    //   78: astore_1
    //   79: aload_1
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: invokevirtual 1258	java/io/FileInputStream:close	()V
    //   87: aload_3
    //   88: ifnull +7 -> 95
    //   91: aload_3
    //   92: invokevirtual 595	java/io/OutputStream:close	()V
    //   95: aload_0
    //   96: athrow
    //   97: astore 4
    //   99: aload_0
    //   100: astore_1
    //   101: aload 4
    //   103: astore_0
    //   104: goto -25 -> 79
    //   107: astore 4
    //   109: aload_1
    //   110: astore_3
    //   111: aload_0
    //   112: astore_1
    //   113: aload 4
    //   115: astore_0
    //   116: goto -37 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramFile1	File
    //   0	119	1	paramFile2	File
    //   31	12	2	bool	boolean
    //   1	110	3	localFile1	File
    //   19	8	4	localFile2	File
    //   97	5	4	localObject1	Object
    //   107	7	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	76	finally
    //   11	21	97	finally
    //   26	52	97	finally
    //   52	61	97	finally
    //   61	67	107	finally
  }
  
  public static void a(FileInputStream paramFileInputStream)
  {
    StatResult localStatResult = StatResult.statOpenFile(NativeUtils.getFileDescriptorForFileDescriptor(paramFileInputStream.getFD()));
    if (Process.myUid() == localStatResult.a) {
      throw new IOException("file is owned by our application; not permitting nefarious file share operation; fileInputStream=" + paramFileInputStream);
    }
  }
  
  private static void a(InputStream paramInputStream, int paramInt)
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    while (paramInt > 0)
    {
      if (a(paramInputStream, arrayOfByte, Math.min(1024, paramInt)) == -1) {
        throw new EOFException("Unexpected EOF skipping " + paramInt);
      }
      paramInt -= 1024;
    }
  }
  
  public static void a(byte[] paramArrayOfByte, File paramFile)
  {
    if (paramArrayOfByte != null) {}
    try
    {
      paramFile = new BufferedOutputStream(new FileOutputStream(paramFile));
      a.d.a(paramFile);
    }
    finally
    {
      try
      {
        paramFile.write(paramArrayOfByte);
        a.d.a(paramFile);
        return;
      }
      finally {}
      paramArrayOfByte = finally;
      paramFile = null;
    }
    throw paramArrayOfByte;
  }
  
  public static boolean a(byte paramByte, File paramFile)
  {
    if ((paramByte == 13) && ((pj.b(paramFile)) || (!GifHelper.a(paramFile)))) {}
    do
    {
      for (;;)
      {
        return true;
        if ((paramByte == 3) || (paramByte == 13))
        {
          if (paramFile.length() > aic.s * 1048576L) {
            continue;
          }
          if (aqe.a() == aqe.c.a) {}
          try
          {
            f localf = new f(paramFile);
            if (((paramFile.length() <= 262144L) || (localf.a() / 1000 <= aic.L)) && (af.c(paramFile))) {
              return false;
            }
          }
          catch (c paramFile)
          {
            Log.e("videopreview/bad video");
            return true;
          }
        }
      }
      if (paramByte != 2) {
        break;
      }
    } while (!af.b(paramFile));
    return false;
    return false;
  }
  
  public static boolean a(int paramInt, File paramFile)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    do
    {
      do
      {
        return bool;
      } while (af.g(paramFile).a != 0);
      return false;
    } while (af.g(paramFile).a == 2);
    return false;
  }
  
  public static boolean a(Context paramContext, pv parampv, boolean paramBoolean, File paramFile, byte paramByte)
  {
    Log.i("mediafileutils/checkmediafilesize src:" + paramFile.getAbsolutePath());
    if (paramByte == 9)
    {
      paramByte = aic.C;
      if (paramFile.length() <= paramByte * 1048576L) {
        break label139;
      }
      Log.w("mediafileutils/checkmediafilesize/too large:" + paramFile.length());
      if (!paramBoolean) {
        break label111;
      }
      pv.a(paramContext, paramContext.getString(2131296795, new Object[] { Integer.valueOf(paramByte) }), 1);
    }
    for (;;)
    {
      return false;
      paramByte = aic.s;
      break;
      label111:
      parampv.b(paramContext, paramContext.getString(2131296795, new Object[] { Integer.valueOf(paramByte) }), 1);
    }
    label139:
    return true;
  }
  
  public static boolean a(Bitmap paramBitmap, File paramFile, int paramInt)
  {
    paramFile = new FileOutputStream(paramFile);
    boolean bool = paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, paramFile);
    a.d.a(paramFile);
    return bool;
  }
  
  public static boolean a(oz paramoz, j paramj)
  {
    MediaData localMediaData = paramj.b();
    if ((paramj.p != null) && ((localMediaData == null) || (localMediaData.file == null))) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while (localMediaData.transcoded);
          if ((paramj.s == 13) && ((localMediaData.file == null) || (pj.b(localMediaData.file)))) {
            return true;
          }
          if (paramj.s != 1) {
            break;
          }
        } while (localMediaData.file != null);
        return true;
        if ((paramj.s != 3) && (paramj.s != 13)) {
          break;
        }
        if (paramj.t > aic.s * 1048576L) {
          return true;
        }
        if ((a(paramj)) && (paramj.t > 262144L))
        {
          if (paramj.w == 0) {}
          for (int k = 0; k > aic.L; k = (int)(8L * paramj.t / (paramj.w * 1000))) {
            return true;
          }
        }
        if ((localMediaData.doodleId != null) && (a(paramoz, localMediaData.doodleId).exists())) {
          return true;
        }
      } while (af.c(localMediaData.file));
      return true;
    } while ((paramj.s != 2) || (af.b(localMediaData.file)));
    return true;
  }
  
  public static boolean a(j paramj)
  {
    MediaData localMediaData = paramj.b();
    if ((paramj.s == 3) || (paramj.s == 13)) {
      if (aqe.a() != aqe.c.a) {}
    }
    do
    {
      return true;
      return false;
      if (paramj.s == 2) {
        return ah.a(localMediaData.file);
      }
    } while (paramj.s == 1);
    return false;
  }
  
  public static boolean a(vv paramvv, File paramFile1, File paramFile2)
  {
    paramvv = paramvv.b();
    if (paramFile2.renameTo(paramvv))
    {
      if (paramFile1.renameTo(paramFile2))
      {
        if (!paramvv.delete()) {
          Log.e("failed to delete " + paramvv.getAbsolutePath());
        }
        return true;
      }
      if (paramvv.renameTo(paramFile2)) {
        if (!paramFile1.delete()) {
          Log.e("failed to delete " + paramFile1.getAbsolutePath());
        }
      }
    }
    for (;;)
    {
      return false;
      if (!paramFile1.delete()) {
        Log.e("failed to delete " + paramFile1.getAbsolutePath());
      }
      if (!paramvv.delete()) {
        Log.e("failed to delete " + paramvv.getAbsolutePath());
      }
      Log.e("restore input file failed");
      continue;
      if (!paramvv.delete()) {
        Log.e("failed to delete " + paramvv.getAbsolutePath());
      }
    }
  }
  
  public static boolean a(File paramFile, MediaData paramMediaData)
  {
    Object localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramFile.getAbsolutePath(), (BitmapFactory.Options)localObject1);
    int k = ((BitmapFactory.Options)localObject1).outWidth;
    int m = ((BitmapFactory.Options)localObject1).outHeight;
    ((BitmapFactory.Options)localObject1).inSampleSize = Math.max(((BitmapFactory.Options)localObject1).outWidth / 400, ((BitmapFactory.Options)localObject1).outHeight / 400);
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
    ((BitmapFactory.Options)localObject1).inInputShareable = true;
    ((BitmapFactory.Options)localObject1).inPurgeable = true;
    ((BitmapFactory.Options)localObject1).inPreferredConfig = Bitmap.Config.RGB_565;
    try
    {
      paramFile = d.b(paramFile);
      localObject1 = BitmapFactory.decodeByteArray(paramFile, 0, paramFile.length, (BitmapFactory.Options)localObject1);
      if (localObject1 == null) {
        return false;
      }
    }
    catch (IOException paramFile)
    {
      return false;
    }
    Object localObject2;
    if ((((Bitmap)localObject1).getWidth() & 0x1) == 1)
    {
      localObject2 = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth() - 1, ((Bitmap)localObject1).getHeight());
      paramFile = (File)localObject2;
      if (localObject1 != localObject2) {
        ((Bitmap)localObject1).recycle();
      }
    }
    for (paramFile = (File)localObject2;; paramFile = (File)localObject1)
    {
      localObject2 = new FaceDetector(paramFile.getWidth(), paramFile.getHeight(), 1);
      localObject1 = new FaceDetector.Face[1];
      if ((((FaceDetector)localObject2).findFaces(paramFile, (FaceDetector.Face[])localObject1) > 0) && (localObject1[0].confidence() > 0.3F))
      {
        localObject2 = new PointF();
        localObject1[0].getMidPoint((PointF)localObject2);
        float f1 = ((PointF)localObject2).x;
        paramMediaData.faceX = ((int)(k * f1 / paramFile.getWidth()));
      }
      for (paramMediaData.faceY = ((int)(((PointF)localObject2).y * m / paramFile.getHeight()));; paramMediaData.faceY = -1)
      {
        paramFile.recycle();
        if ((paramMediaData.faceX <= 0) && (paramMediaData.faceY <= 0)) {
          break;
        }
        return true;
        paramMediaData.faceX = -1;
      }
      return false;
    }
  }
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length < paramArrayOfByte2.length) {
      return false;
    }
    int k = 0;
    for (;;)
    {
      if (k >= paramArrayOfByte2.length) {
        break label33;
      }
      if (paramArrayOfByte1[k] != paramArrayOfByte2[k]) {
        break;
      }
      k += 1;
    }
    label33:
    return true;
  }
  
  public static byte[] a(Context paramContext, oz paramoz, and paramand, Uri paramUri, MediaData paramMediaData, int paramInt1, int paramInt2)
  {
    paramoz = a(paramContext, paramoz, ".jpg", (byte)1, 0, true);
    try
    {
      paramContext = a(paramand, paramUri, paramoz, paramInt1, paramInt2);
      if (paramContext == null)
      {
        Log.e("mediafileutils/getimageandsend/thumb bitmap is null");
        throw new e();
      }
    }
    catch (SecurityException paramContext)
    {
      Log.e("mediafileutils/getimageandsend/securityexception" + paramContext.getMessage());
      throw paramContext;
    }
    paramMediaData.file = paramoz;
    Log.d("mediafileutils/getimageandsend/thumbnail width:" + paramContext.getWidth() + " height:" + paramContext.getHeight());
    paramoz = new ByteArrayOutputStream();
    paramContext.compress(Bitmap.CompressFormat.JPEG, 80, paramoz);
    paramoz = paramoz.toByteArray();
    try
    {
      if (paramContext.getHeight() > paramContext.getWidth()) {
        a(paramMediaData.file, paramMediaData);
      }
      paramContext.recycle();
      return paramoz;
    }
    catch (Exception paramand)
    {
      for (;;) {}
    }
    catch (OutOfMemoryError paramand)
    {
      for (;;) {}
    }
  }
  
  public static byte[] a(Bitmap paramBitmap)
  {
    Object localObject1 = null;
    Rect localRect1;
    Rect localRect2;
    Object localObject2;
    if (paramBitmap != null)
    {
      Log.i("orig_thumbnail/width:" + paramBitmap.getWidth() + "/height:" + paramBitmap.getHeight());
      if (paramBitmap.getWidth() <= 100)
      {
        localObject1 = paramBitmap;
        if (paramBitmap.getHeight() <= 100) {}
      }
      else
      {
        float f1 = Math.max(paramBitmap.getWidth() / 100.0F, paramBitmap.getHeight() / 100.0F);
        localRect1 = new Rect(0, 0, (int)(paramBitmap.getWidth() / f1), (int)(paramBitmap.getHeight() / f1));
        localRect1.right = Math.max(localRect1.right, 1);
        localRect1.bottom = Math.max(localRect1.bottom, 1);
        localRect2 = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
        localObject2 = paramBitmap.getConfig();
      }
    }
    try
    {
      int k = localRect1.width();
      int m = localRect1.height();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = Bitmap.Config.ARGB_8888;
      }
      localObject1 = Bitmap.createBitmap(k, m, (Bitmap.Config)localObject1);
      localObject2 = new Canvas((Bitmap)localObject1);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      localPaint.setFilterBitmap(true);
      localPaint.setDither(true);
      ((Canvas)localObject2).drawBitmap(paramBitmap, localRect2, localRect1, localPaint);
      paramBitmap.recycle();
      Log.i("rescaled_thumbnail/width:" + ((Bitmap)localObject1).getWidth() + "/height:" + ((Bitmap)localObject1).getHeight());
      paramBitmap = new ByteArrayOutputStream();
      ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 80, paramBitmap);
      paramBitmap = paramBitmap.toByteArray();
      ((Bitmap)localObject1).recycle();
      localObject1 = paramBitmap;
      return (byte[])localObject1;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Log.e("video-thumbnail/scale/out-of-memory");
      paramBitmap.recycle();
      throw localOutOfMemoryError;
    }
  }
  
  public static byte[] a(String paramString, long paramLong)
  {
    if (paramLong == 0L) {
      return a(g(paramString));
    }
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramString);
      paramString = a(localMediaMetadataRetriever.getFrameAtTime(paramLong));
      return paramString;
    }
    catch (Exception paramString)
    {
      localMediaMetadataRetriever.release();
      return null;
    }
    catch (NoSuchMethodError paramString)
    {
      for (;;) {}
    }
  }
  
  public static int b(File paramFile)
  {
    long l = a(paramFile);
    int m = (int)(l / 1000L);
    int k = m;
    if (m == 0)
    {
      k = m;
      if (l != 0L) {
        k = 1;
      }
    }
    return k;
  }
  
  public static Bitmap b(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    return BitmapFactory.decodeByteArray(paramBitmap, 0, paramBitmap.length, b);
  }
  
  public static Matrix b(and paramand, Uri paramUri)
  {
    if ((paramUri == null) || (TextUtils.isEmpty(paramUri.toString()))) {
      throw new FileNotFoundException("No file " + paramUri);
    }
    Object localObject = a(c(paramand, paramUri));
    if (paramUri.getQueryParameter("flip-h") != null)
    {
      paramand = new Matrix();
      paramand.setValues(new float[] { -1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F });
      if (localObject == null)
      {
        localObject = paramand;
        paramand = (and)localObject;
        if (paramUri.getQueryParameter("flip-v") != null)
        {
          paramand = new Matrix();
          paramand.setValues(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 1.0F });
          if (localObject != null) {
            break label251;
          }
        }
      }
    }
    for (;;)
    {
      localObject = paramUri.getQueryParameter("rotation");
      paramUri = paramand;
      if (localObject != null)
      {
        int k = Integer.parseInt((String)localObject);
        paramUri = paramand;
        if (k != 0)
        {
          paramUri = paramand;
          if (paramand == null) {
            paramUri = new Matrix();
          }
          paramUri.postRotate(k);
        }
      }
      return paramUri;
      ((Matrix)localObject).postConcat(paramand);
      break;
      label251:
      ((Matrix)localObject).postConcat(paramand);
      paramand = (and)localObject;
    }
  }
  
  public static File b(Context paramContext)
  {
    if (j == null)
    {
      paramContext = paramContext.getSharedPreferences("com.whatsapp_preferences", 0).getString("external_file_image", null);
      if (paramContext != null) {
        j = new File(paramContext);
      }
    }
    return j;
  }
  
  public static String b(String paramString)
  {
    Object localObject;
    if (paramString == null)
    {
      localObject = "";
      label8:
      return (String)localObject;
    }
    int k = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (k)
      {
      default: 
        String str = af.a(paramString, false);
        localObject = str;
        if (!TextUtils.isEmpty(str)) {
          break label8;
        }
        str = af.b(paramString, false);
        localObject = str;
        if (!TextUtils.isEmpty(str)) {
          break label8;
        }
        paramString = MimeTypeMap.getSingleton().getExtensionFromMimeType(paramString);
        localObject = paramString;
        if (paramString != null) {
          break label8;
        }
        return "";
        if (paramString.equals("image/jpeg"))
        {
          k = 0;
          continue;
          if (paramString.equals("image/png"))
          {
            k = 1;
            continue;
            if (paramString.equals("application/pdf"))
            {
              k = 2;
              continue;
              if (paramString.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document"))
              {
                k = 3;
                continue;
                if (paramString.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                {
                  k = 4;
                  continue;
                  if (paramString.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation"))
                  {
                    k = 5;
                    continue;
                    if (paramString.equals("application/msword"))
                    {
                      k = 6;
                      continue;
                      if (paramString.equals("application/vnd.ms-excel"))
                      {
                        k = 7;
                        continue;
                        if (paramString.equals("application/vnd.ms-powerpoint"))
                        {
                          k = 8;
                          continue;
                          if (paramString.equals("text/plain"))
                          {
                            k = 9;
                            continue;
                            if (paramString.equals("text/rtf"))
                            {
                              k = 10;
                              continue;
                              if (paramString.equals("application/rtf"))
                              {
                                k = 11;
                                continue;
                                if (paramString.equals("text/csv")) {
                                  k = 12;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return "jpg";
    return "png";
    return "pdf";
    return "docx";
    return "xlsx";
    return "pptx";
    return "doc";
    return "xls";
    return "ppt";
    return "txt";
    return "rtf";
    return "rtf";
    return "csv";
  }
  
  public static void b(File paramFile, MediaData paramMediaData)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramFile.getAbsolutePath(), localOptions);
    if (paramFile.exists()) {}
    for (;;)
    {
      try
      {
        k = c(paramFile.getAbsolutePath());
        if ((k != 6) && (k != 8)) {
          break;
        }
        paramMediaData.width = localOptions.outHeight;
        paramMediaData.height = localOptions.outWidth;
        return;
      }
      catch (IOException paramFile)
      {
        Log.d("failure retrieving exif, io exception", paramFile);
      }
      int k = 0;
    }
    paramMediaData.width = localOptions.outWidth;
    paramMediaData.height = localOptions.outHeight;
  }
  
  public static boolean b(byte paramByte, File paramFile)
  {
    if ((paramByte == 3) || (paramByte == 13)) {
      return aqe.a(paramFile);
    }
    if (paramByte == 2) {
      return ah.a(paramFile);
    }
    return false;
  }
  
  /* Error */
  public static int c(and paramand, Uri paramUri)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_1
    //   6: invokevirtual 715	android/net/Uri:getScheme	()Ljava/lang/String;
    //   9: ifnull +16 -> 25
    //   12: ldc_w 717
    //   15: aload_1
    //   16: invokevirtual 715	android/net/Uri:getScheme	()Ljava/lang/String;
    //   19: invokevirtual 721	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   22: ifeq +33 -> 55
    //   25: aload_1
    //   26: invokevirtual 724	android/net/Uri:getPath	()Ljava/lang/String;
    //   29: invokestatic 1544	com/whatsapp/util/MediaFileUtils:c	(Ljava/lang/String;)I
    //   32: istore_3
    //   33: new 162	java/lang/StringBuilder
    //   36: dup
    //   37: ldc_w 1553
    //   40: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: iload_3
    //   44: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 207	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   53: iload_3
    //   54: ireturn
    //   55: ldc_w 1555
    //   58: aload_1
    //   59: invokevirtual 715	android/net/Uri:getScheme	()Ljava/lang/String;
    //   62: invokevirtual 721	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   65: ifeq -32 -> 33
    //   68: aload_1
    //   69: invokevirtual 782	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
    //   72: aconst_null
    //   73: invokevirtual 787	android/net/Uri$Builder:query	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   76: invokevirtual 791	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   79: astore_1
    //   80: aload_0
    //   81: getfield 730	com/whatsapp/and:f	Landroid/content/ContentResolver;
    //   84: astore_0
    //   85: aload_0
    //   86: ifnull +101 -> 187
    //   89: aload_0
    //   90: aload_1
    //   91: iconst_2
    //   92: anewarray 43	java/lang/String
    //   95: dup
    //   96: iconst_0
    //   97: ldc_w 774
    //   100: aastore
    //   101: dup
    //   102: iconst_1
    //   103: ldc_w 1557
    //   106: aastore
    //   107: aconst_null
    //   108: aconst_null
    //   109: aconst_null
    //   110: invokevirtual 778	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   113: astore_0
    //   114: iload 4
    //   116: istore_2
    //   117: aload_0
    //   118: ifnull +39 -> 157
    //   121: aload_0
    //   122: invokeinterface 743 1 0
    //   127: ifeq +138 -> 265
    //   130: aload_0
    //   131: invokeinterface 740 1 0
    //   136: iconst_2
    //   137: if_icmpne +103 -> 240
    //   140: aload_0
    //   141: iconst_0
    //   142: invokeinterface 746 2 0
    //   147: astore_1
    //   148: aload_1
    //   149: ifnull +49 -> 198
    //   152: aload_1
    //   153: invokestatic 1544	com/whatsapp/util/MediaFileUtils:c	(Ljava/lang/String;)I
    //   156: istore_2
    //   157: iload_2
    //   158: istore_3
    //   159: aload_0
    //   160: ifnull -127 -> 33
    //   163: aload_0
    //   164: invokeinterface 747 1 0
    //   169: iload_2
    //   170: istore_3
    //   171: goto -138 -> 33
    //   174: astore_0
    //   175: ldc_w 1559
    //   178: aload_0
    //   179: invokestatic 765	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   182: aconst_null
    //   183: astore_0
    //   184: goto -70 -> 114
    //   187: ldc_w 1561
    //   190: invokestatic 735	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   193: aconst_null
    //   194: astore_0
    //   195: goto -81 -> 114
    //   198: aload_0
    //   199: iconst_1
    //   200: invokeinterface 1563 2 0
    //   205: lookupswitch	default:+72->277, 90:+77->282, 180:+83->288, 270:+88->293
    //   240: ldc_w 1565
    //   243: invokestatic 532	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   246: iload 4
    //   248: istore_2
    //   249: goto -92 -> 157
    //   252: astore_1
    //   253: aload_0
    //   254: ifnull +9 -> 263
    //   257: aload_0
    //   258: invokeinterface 747 1 0
    //   263: aload_1
    //   264: athrow
    //   265: ldc_w 1567
    //   268: invokestatic 532	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   271: iload 4
    //   273: istore_2
    //   274: goto -117 -> 157
    //   277: iconst_0
    //   278: istore_2
    //   279: goto -122 -> 157
    //   282: bipush 6
    //   284: istore_2
    //   285: goto -128 -> 157
    //   288: iconst_3
    //   289: istore_2
    //   290: goto -133 -> 157
    //   293: bipush 8
    //   295: istore_2
    //   296: goto -17 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	paramand	and
    //   0	299	1	paramUri	Uri
    //   116	180	2	k	int
    //   4	167	3	m	int
    //   1	271	4	n	int
    // Exception table:
    //   from	to	target	type
    //   89	114	174	java/lang/Exception
    //   121	148	252	finally
    //   152	157	252	finally
    //   198	240	252	finally
    //   240	246	252	finally
    //   265	271	252	finally
  }
  
  public static int c(String paramString)
  {
    try
    {
      int k = new ExifInterface(paramString).getAttributeInt("Orientation", 1);
      return k;
    }
    catch (NoClassDefFoundError paramString)
    {
      Log.d("failure retrieving exif, no class", paramString);
    }
    return 0;
  }
  
  /* Error */
  public static String c(File paramFile)
  {
    // Byte code:
    //   0: ldc_w 1584
    //   3: invokestatic 1590	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +37 -> 45
    //   11: ldc_w 1592
    //   14: invokestatic 532	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   17: aconst_null
    //   18: areturn
    //   19: astore_2
    //   20: new 162	java/lang/StringBuilder
    //   23: dup
    //   24: ldc_w 1594
    //   27: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: aload_2
    //   31: invokevirtual 461	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 532	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   40: aconst_null
    //   41: astore_2
    //   42: goto -35 -> 7
    //   45: sipush 8192
    //   48: newarray <illegal type>
    //   50: astore 4
    //   52: new 758	java/io/FileInputStream
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 792	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: astore_3
    //   61: aload_3
    //   62: astore_0
    //   63: aload_3
    //   64: aload 4
    //   66: invokevirtual 1597	java/io/InputStream:read	([B)I
    //   69: istore_1
    //   70: iload_1
    //   71: iflt +76 -> 147
    //   74: aload_3
    //   75: astore_0
    //   76: aload_2
    //   77: aload 4
    //   79: iconst_0
    //   80: iload_1
    //   81: invokevirtual 1600	java/security/MessageDigest:update	([BII)V
    //   84: goto -23 -> 61
    //   87: astore_0
    //   88: aload_3
    //   89: astore_2
    //   90: aload_0
    //   91: astore_3
    //   92: aload_2
    //   93: astore_0
    //   94: new 162	java/lang/StringBuilder
    //   97: dup
    //   98: ldc_w 1602
    //   101: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   104: aload_3
    //   105: invokevirtual 461	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 532	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   114: aload_2
    //   115: ifnull -98 -> 17
    //   118: aload_2
    //   119: invokevirtual 622	java/io/InputStream:close	()V
    //   122: aconst_null
    //   123: areturn
    //   124: astore_0
    //   125: new 162	java/lang/StringBuilder
    //   128: dup
    //   129: ldc_w 1604
    //   132: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: aload_0
    //   136: invokevirtual 461	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 532	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   145: aconst_null
    //   146: areturn
    //   147: aload_3
    //   148: invokevirtual 622	java/io/InputStream:close	()V
    //   151: aload_2
    //   152: invokevirtual 1607	java/security/MessageDigest:digest	()[B
    //   155: iconst_2
    //   156: invokestatic 1613	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   159: areturn
    //   160: astore_0
    //   161: new 162	java/lang/StringBuilder
    //   164: dup
    //   165: ldc_w 1604
    //   168: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   171: aload_0
    //   172: invokevirtual 461	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 532	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   181: goto -30 -> 151
    //   184: astore_2
    //   185: aconst_null
    //   186: astore_0
    //   187: aload_0
    //   188: ifnull +7 -> 195
    //   191: aload_0
    //   192: invokevirtual 622	java/io/InputStream:close	()V
    //   195: aload_2
    //   196: athrow
    //   197: astore_0
    //   198: new 162	java/lang/StringBuilder
    //   201: dup
    //   202: ldc_w 1604
    //   205: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   208: aload_0
    //   209: invokevirtual 461	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 532	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   218: goto -23 -> 195
    //   221: astore_2
    //   222: goto -35 -> 187
    //   225: astore_3
    //   226: aconst_null
    //   227: astore_2
    //   228: goto -136 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramFile	File
    //   69	12	1	k	int
    //   6	2	2	localMessageDigest	java.security.MessageDigest
    //   19	12	2	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   41	111	2	localObject1	Object
    //   184	12	2	localObject2	Object
    //   221	1	2	localObject3	Object
    //   227	1	2	localObject4	Object
    //   60	88	3	localObject5	Object
    //   225	1	3	localIOException	IOException
    //   50	28	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	7	19	java/security/NoSuchAlgorithmException
    //   63	70	87	java/io/IOException
    //   76	84	87	java/io/IOException
    //   118	122	124	java/io/IOException
    //   147	151	160	java/io/IOException
    //   52	61	184	finally
    //   191	195	197	java/io/IOException
    //   63	70	221	finally
    //   76	84	221	finally
    //   94	114	221	finally
    //   52	61	225	java/io/IOException
  }
  
  public static String d(and paramand, Uri paramUri)
  {
    paramand = paramand.f;
    if (paramand == null) {
      Log.w("media-file-utils/get-media-mime cr=null");
    }
    if (paramand != null) {}
    for (paramand = paramand.getType(paramUri); paramand != null; paramand = null) {
      return paramand;
    }
    return e(a(paramUri));
  }
  
  public static byte[] d(String paramString)
  {
    return a(g(paramString));
  }
  
  public static byte e(and paramand, Uri paramUri)
  {
    String str = d(paramand, paramUri);
    try
    {
      if (("image/gif".equals(str)) && (pj.b(paramand, paramUri)) && (Build.VERSION.SDK_INT >= 16))
      {
        boolean bool = pj.a(paramand, paramUri);
        if (bool) {
          return 1;
        }
        return 13;
      }
    }
    catch (FileNotFoundException paramand)
    {
      Log.d("Media file cannot be found", paramand);
    }
    return f(str);
  }
  
  public static String e(String paramString)
  {
    String str = paramString.toLowerCase();
    int k = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (k)
      {
      default: 
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString.toLowerCase());
        if (str.equals("pdf"))
        {
          k = 0;
          continue;
          if (str.equals("doc"))
          {
            k = 1;
            continue;
            if (str.equals("docx"))
            {
              k = 2;
              continue;
              if (str.equals("ppt"))
              {
                k = 3;
                continue;
                if (str.equals("pptx"))
                {
                  k = 4;
                  continue;
                  if (str.equals("xls"))
                  {
                    k = 5;
                    continue;
                    if (str.equals("xlsx"))
                    {
                      k = 6;
                      continue;
                      if (str.equals("txt"))
                      {
                        k = 7;
                        continue;
                        if (str.equals("rtf"))
                        {
                          k = 8;
                          continue;
                          if (str.equals("csv"))
                          {
                            k = 9;
                            continue;
                            if (str.equals("opus"))
                            {
                              k = 10;
                              continue;
                              if (str.equals("amr"))
                              {
                                k = 11;
                                continue;
                                if (str.equals("mp3"))
                                {
                                  k = 12;
                                  continue;
                                  if (str.equals("m4a"))
                                  {
                                    k = 13;
                                    continue;
                                    if (str.equals("aac"))
                                    {
                                      k = 14;
                                      continue;
                                      if (str.equals("wav"))
                                      {
                                        k = 15;
                                        continue;
                                        if (str.equals("wma")) {
                                          k = 16;
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return "application/pdf";
    return "application/msword";
    return "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
    return "application/vnd.ms-powerpoint";
    return "application/vnd.openxmlformats-officedocument.presentationml.presentation";
    return "application/vnd.ms-excel";
    return "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    return "text/plain";
    return "application/rtf";
    return "text/csv";
    return "audio/ogg; codecs=opus";
    return "audio/amr";
    return "audio/mpeg";
    return "audio/mp4";
    return "audio/aac";
    return "audio/x-wav";
    return "audio/x-ms-wma";
  }
  
  public static byte f(String paramString)
  {
    byte b2 = 9;
    if (paramString != null)
    {
      byte b1;
      if (paramString.startsWith("audio")) {
        b1 = 2;
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              return b1;
                              if (paramString.startsWith("video")) {
                                return 3;
                              }
                              if (paramString.startsWith("image")) {
                                return 1;
                              }
                              if (paramString.startsWith("text/x-vcard")) {
                                return 4;
                              }
                              if (paramString.startsWith("text")) {
                                return 0;
                              }
                              b1 = b2;
                            } while (paramString.startsWith("application/pdf"));
                            b1 = b2;
                          } while (paramString.startsWith("application/vnd.openxmlformats-officedocument.wordprocessingml.document"));
                          b1 = b2;
                        } while (paramString.startsWith("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
                        b1 = b2;
                      } while (paramString.startsWith("application/vnd.openxmlformats-officedocument.presentationml.presentation"));
                      b1 = b2;
                    } while (paramString.startsWith("application/msword"));
                    b1 = b2;
                  } while (paramString.startsWith("application/vnd.ms-excel"));
                  b1 = b2;
                } while (paramString.startsWith("application/vnd.ms-powerpoint"));
                b1 = b2;
              } while (paramString.startsWith("text/plain"));
              b1 = b2;
            } while (paramString.startsWith("text/rtf"));
            b1 = b2;
          } while (paramString.startsWith("application/rtf"));
          b1 = b2;
        } while (paramString.startsWith("text/csv"));
        b1 = b2;
      } while (aic.b());
    }
    return -1;
  }
  
  /* Error */
  public static Bitmap g(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokestatic 1693	com/whatsapp/pj:a	(Ljava/lang/String;)Z
    //   6: ifeq +43 -> 49
    //   9: new 1695	com/whatsapp/pi
    //   12: dup
    //   13: new 152	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 725	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: invokevirtual 340	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   24: invokespecial 1696	com/whatsapp/pi:<init>	(Ljava/lang/String;)V
    //   27: getfield 1699	com/whatsapp/pi:a	Lpl/droidsonroids/gif/a;
    //   30: iconst_0
    //   31: invokevirtual 1704	pl/droidsonroids/gif/a:a	(I)Landroid/graphics/Bitmap;
    //   34: astore 4
    //   36: aload 4
    //   38: areturn
    //   39: astore 4
    //   41: ldc_w 1706
    //   44: aload 4
    //   46: invokestatic 284	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   49: new 336	android/media/MediaMetadataRetriever
    //   52: dup
    //   53: invokespecial 337	android/media/MediaMetadataRetriever:<init>	()V
    //   56: astore 7
    //   58: aload 7
    //   60: aload_0
    //   61: invokevirtual 343	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   64: aload 7
    //   66: lconst_0
    //   67: invokevirtual 1464	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   70: astore 5
    //   72: aload 5
    //   74: astore 4
    //   76: aload 5
    //   78: ifnonnull +10 -> 88
    //   81: aload 7
    //   83: invokevirtual 1709	android/media/MediaMetadataRetriever:getFrameAtTime	()Landroid/graphics/Bitmap;
    //   86: astore 4
    //   88: aload 4
    //   90: astore 5
    //   92: aload 4
    //   94: ifnonnull +33 -> 127
    //   97: aload 7
    //   99: invokevirtual 1712	android/media/MediaMetadataRetriever:getEmbeddedPicture	()[B
    //   102: astore 6
    //   104: aload 4
    //   106: astore 5
    //   108: aload 6
    //   110: ifnull +17 -> 127
    //   113: aload 6
    //   115: iconst_0
    //   116: aload 6
    //   118: arraylength
    //   119: getstatic 113	com/whatsapp/util/MediaFileUtils:b	Landroid/graphics/BitmapFactory$Options;
    //   122: invokestatic 494	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   125: astore 5
    //   127: aload 5
    //   129: astore 4
    //   131: aload 5
    //   133: ifnull +46 -> 179
    //   136: new 1435	java/io/ByteArrayOutputStream
    //   139: dup
    //   140: invokespecial 1436	java/io/ByteArrayOutputStream:<init>	()V
    //   143: astore 4
    //   145: aload 5
    //   147: getstatic 590	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   150: bipush 80
    //   152: aload 4
    //   154: invokevirtual 594	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   157: pop
    //   158: aload 4
    //   160: invokevirtual 1440	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   163: astore 4
    //   165: aload 4
    //   167: iconst_0
    //   168: aload 4
    //   170: arraylength
    //   171: getstatic 113	com/whatsapp/util/MediaFileUtils:b	Landroid/graphics/BitmapFactory$Options;
    //   174: invokestatic 494	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   177: astore 4
    //   179: aload 4
    //   181: astore 5
    //   183: aload 4
    //   185: ifnull +177 -> 362
    //   188: aload 4
    //   190: astore 5
    //   192: getstatic 1124	android/os/Build$VERSION:SDK_INT	I
    //   195: bipush 11
    //   197: if_icmpge +165 -> 362
    //   200: aload 4
    //   202: invokevirtual 390	android/graphics/Bitmap:getWidth	()I
    //   205: istore_2
    //   206: aload 4
    //   208: invokevirtual 393	android/graphics/Bitmap:getHeight	()I
    //   211: istore_3
    //   212: aload 4
    //   214: astore 5
    //   216: iload_2
    //   217: iload_3
    //   218: if_icmple +144 -> 362
    //   221: new 1714	com/whatsapp/util/b/a
    //   224: dup
    //   225: invokespecial 1715	com/whatsapp/util/b/a:<init>	()V
    //   228: astore 5
    //   230: new 1717	java/io/RandomAccessFile
    //   233: dup
    //   234: new 152	java/io/File
    //   237: dup
    //   238: aload_0
    //   239: invokespecial 725	java/io/File:<init>	(Ljava/lang/String;)V
    //   242: ldc_w 1719
    //   245: invokespecial 1722	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   248: astore 8
    //   250: aload 5
    //   252: aload 8
    //   254: lconst_0
    //   255: aload 8
    //   257: invokevirtual 1723	java/io/RandomAccessFile:length	()J
    //   260: invokestatic 1726	com/whatsapp/util/b/a:a	(Ljava/io/RandomAccessFile;JJ)[Lcom/whatsapp/util/b/c;
    //   263: putfield 1729	com/whatsapp/util/b/a:c	[Lcom/whatsapp/util/b/c;
    //   266: aload 8
    //   268: invokevirtual 1730	java/io/RandomAccessFile:close	()V
    //   271: aload 5
    //   273: getfield 1729	com/whatsapp/util/b/a:c	[Lcom/whatsapp/util/b/c;
    //   276: invokestatic 1733	com/whatsapp/util/b/a:a	([Lcom/whatsapp/util/b/c;)Lcom/whatsapp/util/b/b;
    //   279: astore_0
    //   280: aload 4
    //   282: astore 5
    //   284: aload_0
    //   285: ifnull +77 -> 362
    //   288: aload 4
    //   290: astore 5
    //   292: aload_0
    //   293: invokevirtual 1736	com/whatsapp/util/b/b:a	()I
    //   296: ifle +66 -> 362
    //   299: aload_0
    //   300: getfield 1739	com/whatsapp/util/b/b:h	D
    //   303: dconst_0
    //   304: dcmpl
    //   305: ifne +149 -> 454
    //   308: aload_0
    //   309: getfield 1741	com/whatsapp/util/b/b:i	D
    //   312: dconst_0
    //   313: dcmpl
    //   314: ifeq +6 -> 320
    //   317: goto +137 -> 454
    //   320: aload 4
    //   322: astore 5
    //   324: iload_1
    //   325: ifeq +37 -> 362
    //   328: new 162	java/lang/StringBuilder
    //   331: dup
    //   332: ldc_w 1743
    //   335: invokespecial 203	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   338: aload_0
    //   339: invokevirtual 1736	com/whatsapp/util/b/b:a	()I
    //   342: invokevirtual 212	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   345: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 207	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   351: aload 4
    //   353: aload_0
    //   354: invokevirtual 1736	com/whatsapp/util/b/b:a	()I
    //   357: invokestatic 1746	a/a/a/a/a/a$d:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   360: astore 5
    //   362: aload 7
    //   364: invokevirtual 358	android/media/MediaMetadataRetriever:release	()V
    //   367: aload 5
    //   369: areturn
    //   370: astore_0
    //   371: aload_0
    //   372: athrow
    //   373: astore 5
    //   375: aload_0
    //   376: astore 6
    //   378: aload 5
    //   380: astore_0
    //   381: aload 6
    //   383: ifnull +30 -> 413
    //   386: aload 8
    //   388: invokevirtual 1730	java/io/RandomAccessFile:close	()V
    //   391: aload_0
    //   392: athrow
    //   393: astore_0
    //   394: aload_0
    //   395: invokestatic 296	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   398: aload 4
    //   400: astore 5
    //   402: goto -40 -> 362
    //   405: astore_0
    //   406: aload 7
    //   408: invokevirtual 358	android/media/MediaMetadataRetriever:release	()V
    //   411: aconst_null
    //   412: areturn
    //   413: aload 8
    //   415: invokevirtual 1730	java/io/RandomAccessFile:close	()V
    //   418: goto -27 -> 391
    //   421: astore_0
    //   422: aload_0
    //   423: invokestatic 296	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   426: aload 7
    //   428: invokevirtual 358	android/media/MediaMetadataRetriever:release	()V
    //   431: goto -20 -> 411
    //   434: astore_0
    //   435: aload 7
    //   437: invokevirtual 358	android/media/MediaMetadataRetriever:release	()V
    //   440: aload_0
    //   441: athrow
    //   442: astore 5
    //   444: goto -53 -> 391
    //   447: astore_0
    //   448: aconst_null
    //   449: astore 6
    //   451: goto -70 -> 381
    //   454: iconst_1
    //   455: istore_1
    //   456: goto -136 -> 320
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	paramString	String
    //   1	455	1	k	int
    //   205	14	2	m	int
    //   211	8	3	n	int
    //   34	3	4	localBitmap	Bitmap
    //   39	6	4	localIOException	IOException
    //   74	325	4	localObject1	Object
    //   70	298	5	localObject2	Object
    //   373	6	5	localObject3	Object
    //   400	1	5	localObject4	Object
    //   442	1	5	localThrowable	Throwable
    //   102	348	6	localObject5	Object
    //   56	380	7	localMediaMetadataRetriever	MediaMetadataRetriever
    //   248	166	8	localRandomAccessFile	java.io.RandomAccessFile
    // Exception table:
    //   from	to	target	type
    //   9	36	39	java/io/IOException
    //   250	266	370	java/lang/Throwable
    //   371	373	373	finally
    //   221	250	393	java/io/IOException
    //   266	280	393	java/io/IOException
    //   292	308	393	java/io/IOException
    //   308	317	393	java/io/IOException
    //   328	362	393	java/io/IOException
    //   386	391	393	java/io/IOException
    //   391	393	393	java/io/IOException
    //   413	418	393	java/io/IOException
    //   58	72	405	java/lang/RuntimeException
    //   81	88	405	java/lang/RuntimeException
    //   97	104	405	java/lang/RuntimeException
    //   113	127	405	java/lang/RuntimeException
    //   136	179	405	java/lang/RuntimeException
    //   192	212	405	java/lang/RuntimeException
    //   221	250	405	java/lang/RuntimeException
    //   266	280	405	java/lang/RuntimeException
    //   292	308	405	java/lang/RuntimeException
    //   308	317	405	java/lang/RuntimeException
    //   328	362	405	java/lang/RuntimeException
    //   386	391	405	java/lang/RuntimeException
    //   391	393	405	java/lang/RuntimeException
    //   394	398	405	java/lang/RuntimeException
    //   413	418	405	java/lang/RuntimeException
    //   58	72	421	java/lang/LinkageError
    //   81	88	421	java/lang/LinkageError
    //   97	104	421	java/lang/LinkageError
    //   113	127	421	java/lang/LinkageError
    //   136	179	421	java/lang/LinkageError
    //   192	212	421	java/lang/LinkageError
    //   221	250	421	java/lang/LinkageError
    //   266	280	421	java/lang/LinkageError
    //   292	308	421	java/lang/LinkageError
    //   308	317	421	java/lang/LinkageError
    //   328	362	421	java/lang/LinkageError
    //   386	391	421	java/lang/LinkageError
    //   391	393	421	java/lang/LinkageError
    //   394	398	421	java/lang/LinkageError
    //   413	418	421	java/lang/LinkageError
    //   58	72	434	finally
    //   81	88	434	finally
    //   97	104	434	finally
    //   113	127	434	finally
    //   136	179	434	finally
    //   192	212	434	finally
    //   221	250	434	finally
    //   266	280	434	finally
    //   292	308	434	finally
    //   308	317	434	finally
    //   328	362	434	finally
    //   386	391	434	finally
    //   391	393	434	finally
    //   394	398	434	finally
    //   413	418	434	finally
    //   422	426	434	finally
    //   386	391	442	java/lang/Throwable
    //   250	266	447	finally
  }
  
  @TargetApi(21)
  @Keep
  public static class OsRename
  {
    @TargetApi(21)
    public static int attempt(File paramFile1, File paramFile2)
    {
      try
      {
        Os.rename(paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath());
        return -1;
      }
      catch (ErrnoException paramFile1)
      {
        Log.e("MMS Os.rename also failed, errno=" + paramFile1.errno);
      }
      return paramFile1.errno;
    }
  }
  
  public static final class a
    extends MediaFileUtils.b
  {}
  
  public static class b
    extends Exception
  {}
  
  public static final class c
    extends MediaFileUtils.b
  {}
  
  public static abstract interface d
  {
    public abstract void a(File paramFile);
  }
  
  public static final class e
    extends Exception
  {}
  
  public static final class f
  {
    public int a;
    public int b;
    public long c;
    public int d;
    public final boolean e;
    private int f;
    private final File g;
    private final boolean h;
    
    public f(File paramFile)
    {
      this.g = paramFile;
      this.e = pj.b(paramFile);
      if (this.e) {
        try
        {
          paramFile = new pi(paramFile.getAbsolutePath());
          paramFile = new pi.a(paramFile.a.getMinimumWidth(), paramFile.a.getMinimumHeight());
          this.a = paramFile.a;
          this.b = paramFile.b;
          this.h = false;
          return;
        }
        catch (Exception paramFile)
        {
          for (;;)
          {
            Log.d("media_file not found", paramFile);
          }
        }
      }
      localMediaMetadataRetriever = new MediaMetadataRetriever();
      try
      {
        localMediaMetadataRetriever.setDataSource(paramFile.getAbsolutePath());
        this.h = GifHelper.a(paramFile);
        paramFile = localMediaMetadataRetriever.extractMetadata(9);
        String str1 = localMediaMetadataRetriever.extractMetadata(18);
        String str2 = localMediaMetadataRetriever.extractMetadata(19);
        try
        {
          this.a = Integer.parseInt(str1);
          this.b = Integer.parseInt(str2);
        }
        catch (Exception paramFile)
        {
          try
          {
            for (;;)
            {
              this.f = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(20));
              try
              {
                this.d = Integer.parseInt(localMediaMetadataRetriever.extractMetadata(24));
                localMediaMetadataRetriever.release();
                return;
                paramFile = paramFile;
                Log.w("videometa/cannot parse width (" + str1 + ") or height (" + str2 + ") " + this.g.getAbsolutePath() + " " + this.g.length());
                paramFile = null;
                try
                {
                  Bitmap localBitmap = localMediaMetadataRetriever.getFrameAtTime(0L);
                  paramFile = localBitmap;
                }
                catch (Exception localException2)
                {
                  for (;;) {}
                }
                catch (NoSuchMethodError localNoSuchMethodError)
                {
                  for (;;) {}
                }
                if (paramFile != null)
                {
                  this.a = paramFile.getWidth();
                  this.b = paramFile.getHeight();
                  if ((this.a != 0) && (this.b != 0)) {
                    continue;
                  }
                  Log.e("videometa/bad width (" + str1 + ") or height (" + str2 + ") " + this.g.getAbsolutePath() + " " + this.g.length());
                  localMediaMetadataRetriever.release();
                  throw new MediaFileUtils.c();
                }
                Log.e("videometa/cannot get frame" + this.g.getAbsolutePath() + " " + this.g.length());
                throw new MediaFileUtils.c();
              }
              catch (Exception paramFile)
              {
                for (;;) {}
              }
            }
          }
          catch (Exception paramFile)
          {
            for (;;) {}
          }
        }
      }
      catch (Exception paramFile)
      {
        try
        {
          this.c = Long.parseLong(paramFile);
          if (this.c != 0L) {
            break label346;
          }
          Log.e("videometa/no duration:" + paramFile + " " + this.g.getAbsolutePath() + " " + this.g.length());
          localMediaMetadataRetriever.release();
          throw new MediaFileUtils.c();
        }
        catch (Exception localException1)
        {
          Log.e("videometa/cannot parse duration:" + paramFile + " " + this.g.getAbsolutePath() + " " + this.g.length());
          localMediaMetadataRetriever.release();
          throw new MediaFileUtils.c();
        }
        paramFile = paramFile;
        Log.d("videometa/cannot process file:" + this.g.getAbsolutePath() + " " + this.g.length() + " " + this.g.exists(), paramFile);
        localMediaMetadataRetriever.release();
        throw new MediaFileUtils.c();
      }
    }
    
    public final int a()
    {
      if (this.f != 0) {
        return this.f;
      }
      if (this.c != 0L) {
        return (int)(8000L * this.g.length() / this.c);
      }
      return 0;
    }
    
    public final boolean a(byte paramByte)
    {
      byte b1 = 640;
      if (this.e) {
        return true;
      }
      if (paramByte == 13)
      {
        if (this.h) {
          return false;
        }
        if (this.g.length() > 262144L) {
          return a() / (this.a * this.b) > 2.2D;
        }
        return false;
      }
      if ((this.a <= 640) && (this.b <= 640))
      {
        b1 = this.a;
        paramByte = this.b;
      }
      for (;;)
      {
        float f1 = b1 * paramByte;
        if ((MediaFileUtils.a(b1, paramByte, this.c) * f1 * (float)(this.c / 1000L) / 8.0F + (float)(96000L * (this.c / 1000L) / 8L)) >= this.g.length()) {
          break;
        }
        return true;
        if (this.a < this.b)
        {
          byte b2 = this.a * 640 / this.b;
          paramByte = b1;
          b1 = b2;
        }
        else
        {
          paramByte = this.b * 640 / this.a;
          b1 = 640;
        }
      }
      return false;
    }
    
    public final boolean b()
    {
      return Math.abs(this.d % 180) == 90;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/MediaFileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */