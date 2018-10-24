package com.whatsapp.o;

import a.a.a.a.a.a.d;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.whatsapp.aic;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import com.whatsapp.util.y;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class c
  extends a
{
  private static boolean g;
  MediaRecorder c;
  String d;
  b e;
  private String f;
  private a h;
  
  public c(String paramString1, String paramString2)
  {
    this.d = paramString1;
    this.f = paramString2;
  }
  
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte1 = new byte[7];
    byte[] arrayOfByte2 = new byte[' '];
    int k = 0;
    int i = 0;
    while (paramInputStream.read(arrayOfByte1) == 7)
    {
      int m = arrayOfByte1[3];
      int n = arrayOfByte1[4];
      int i1 = arrayOfByte1[5];
      int j = i;
      if ((arrayOfByte1[2] & 0xC0) != 64)
      {
        j = i;
        if (i == 0)
        {
          j = 1;
          Log.w("voicerecorder/fixaac/bad mpeg-4 audio object type:" + ((arrayOfByte1[2] & 0xC0) >> 6));
        }
        arrayOfByte1[2] = ((byte)(arrayOfByte1[2] & 0x3C | 0x40));
      }
      i = ((m & 0x3) << 11 | (n & 0xFF) << 3 | (i1 & 0xE0) >> 5) - 7;
      if (i > 0)
      {
        paramOutputStream.write(arrayOfByte1);
        paramInputStream.read(arrayOfByte2, 0, i);
        paramOutputStream.write(arrayOfByte2, 0, i);
        i = j;
      }
      else
      {
        k += 1;
        i = j;
      }
    }
    if (k > 0) {
      Log.w("voicerecorder/fixaac/empty: " + k);
    }
  }
  
  public final void a()
  {
    this.c = new MediaRecorder();
    this.c.setAudioSource(1);
    File localFile = null;
    if ("audio/3gpp".equals(this.f))
    {
      this.a = new File(this.d + ".3gp");
      this.b = 12200;
      this.c.setOutputFormat(1);
      this.c.setAudioEncoder(1);
    }
    label617:
    label636:
    for (;;)
    {
      if (localFile != null) {
        this.c.setOutputFile(localFile.getAbsolutePath());
      }
      for (;;)
      {
        this.c.setMaxFileSize(aic.s * 1048576L);
        try
        {
          this.c.prepare();
          return;
        }
        catch (Exception localException1)
        {
          Log.d("voicerecorder/prepare", localException1);
          if (g) {
            break label617;
          }
          try
          {
            this.c.release();
            g = true;
            this.c = new MediaRecorder();
            this.c.setAudioSource(1);
            this.a = new File(this.d + ".amr");
            this.b = 12200;
            this.c.setOutputFormat(3);
            this.c.setAudioEncoder(1);
            this.c.setOutputFile(this.a.getAbsolutePath());
            this.c.setMaxFileSize(aic.s * 1048576L);
            this.c.prepare();
            return;
          }
          catch (RuntimeException localRuntimeException)
          {
            for (;;)
            {
              Log.d("voicerecorder/preparefailed/release", localRuntimeException);
            }
          }
          throw new IOException(localRuntimeException.toString());
        }
        if (g)
        {
          this.a = new File(this.d + ".amr");
          this.b = 12200;
          this.c.setOutputFormat(3);
          this.c.setAudioEncoder(1);
          break;
        }
        try
        {
          if ((Build.VERSION.SDK_INT >= 14) && (AudioRecord.getMinBufferSize(22050, 1, 2) > 0))
          {
            this.a = new File(this.d + ".aac");
            this.b = 32000;
            this.c.setOutputFormat(6);
            this.c.setAudioEncoder(3);
            this.c.setAudioSamplingRate(22050);
            this.c.setAudioEncodingBitRate(32000);
            localFile = new File(this.d + ".1.aac");
          }
          try
          {
            this.h = new a(Looper.getMainLooper());
            this.h.sendEmptyMessageDelayed(0, 50L);
          }
          catch (Exception localException3)
          {
            break label636;
          }
          this.a = new File(this.d + ".amr");
          if (AudioRecord.getMinBufferSize(16000, 1, 2) > 0)
          {
            this.b = 12650;
            this.c.setOutputFormat(4);
            this.c.setAudioEncoder(2);
            this.c.setAudioSamplingRate(16000);
            break;
          }
          this.b = 12200;
          this.c.setOutputFormat(3);
          this.c.setAudioEncoder(1);
        }
        catch (Exception localException2)
        {
          Object localObject = null;
        }
        this.c.setOutputFile(this.a.getAbsolutePath());
      }
    }
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 81	com/whatsapp/o/c:c	Landroid/media/MediaRecorder;
    //   4: invokevirtual 193	android/media/MediaRecorder:start	()V
    //   7: return
    //   8: astore_1
    //   9: ldc -61
    //   11: aload_1
    //   12: invokestatic 181	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   15: getstatic 136	com/whatsapp/o/c:g	Z
    //   18: ifne +161 -> 179
    //   21: aload_0
    //   22: getfield 81	com/whatsapp/o/c:c	Landroid/media/MediaRecorder;
    //   25: invokevirtual 184	android/media/MediaRecorder:release	()V
    //   28: aload_0
    //   29: new 78	android/media/MediaRecorder
    //   32: dup
    //   33: invokespecial 79	android/media/MediaRecorder:<init>	()V
    //   36: putfield 81	com/whatsapp/o/c:c	Landroid/media/MediaRecorder;
    //   39: aload_0
    //   40: getfield 81	com/whatsapp/o/c:c	Landroid/media/MediaRecorder;
    //   43: iconst_1
    //   44: invokevirtual 85	android/media/MediaRecorder:setAudioSource	(I)V
    //   47: aload_0
    //   48: getfield 81	com/whatsapp/o/c:c	Landroid/media/MediaRecorder;
    //   51: iconst_3
    //   52: invokevirtual 111	android/media/MediaRecorder:setOutputFormat	(I)V
    //   55: aload_0
    //   56: getfield 81	com/whatsapp/o/c:c	Landroid/media/MediaRecorder;
    //   59: iconst_1
    //   60: invokevirtual 114	android/media/MediaRecorder:setAudioEncoder	(I)V
    //   63: aload_0
    //   64: new 95	java/io/File
    //   67: dup
    //   68: new 40	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 96	java/lang/StringBuilder:<init>	()V
    //   75: aload_0
    //   76: getfield 28	com/whatsapp/o/c:d	Ljava/lang/String;
    //   79: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc -118
    //   84: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   93: putfield 105	com/whatsapp/o/c:a	Ljava/io/File;
    //   96: aload_0
    //   97: sipush 12200
    //   100: putfield 108	com/whatsapp/o/c:b	I
    //   103: aload_0
    //   104: getfield 81	com/whatsapp/o/c:c	Landroid/media/MediaRecorder;
    //   107: aload_0
    //   108: getfield 105	com/whatsapp/o/c:a	Ljava/io/File;
    //   111: invokevirtual 117	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   114: invokevirtual 120	android/media/MediaRecorder:setOutputFile	(Ljava/lang/String;)V
    //   117: aload_0
    //   118: getfield 81	com/whatsapp/o/c:c	Landroid/media/MediaRecorder;
    //   121: getstatic 125	com/whatsapp/aic:s	I
    //   124: i2l
    //   125: ldc2_w 126
    //   128: lmul
    //   129: invokevirtual 131	android/media/MediaRecorder:setMaxFileSize	(J)V
    //   132: aload_0
    //   133: getfield 81	com/whatsapp/o/c:c	Landroid/media/MediaRecorder;
    //   136: invokevirtual 134	android/media/MediaRecorder:prepare	()V
    //   139: aload_0
    //   140: getfield 81	com/whatsapp/o/c:c	Landroid/media/MediaRecorder;
    //   143: invokevirtual 193	android/media/MediaRecorder:start	()V
    //   146: iconst_1
    //   147: putstatic 136	com/whatsapp/o/c:g	Z
    //   150: return
    //   151: astore_1
    //   152: ldc -59
    //   154: aload_1
    //   155: invokestatic 181	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   158: aload_1
    //   159: athrow
    //   160: astore_1
    //   161: ldc -57
    //   163: aload_1
    //   164: invokestatic 181	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   167: aload_1
    //   168: athrow
    //   169: astore_1
    //   170: ldc -55
    //   172: aload_1
    //   173: invokestatic 181	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   176: goto -148 -> 28
    //   179: aload_1
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	c
    //   8	4	1	localRuntimeException1	RuntimeException
    //   151	8	1	localRuntimeException2	RuntimeException
    //   160	8	1	localIOException	IOException
    //   169	11	1	localRuntimeException3	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   0	7	8	java/lang/RuntimeException
    //   139	150	151	java/lang/RuntimeException
    //   132	139	160	java/io/IOException
    //   139	150	160	java/io/IOException
    //   152	160	160	java/io/IOException
    //   21	28	169	java/lang/RuntimeException
  }
  
  public final void c()
  {
    if (this.c != null) {
      this.c.stop();
    }
    if (this.h != null) {
      this.h.removeMessages(0);
    }
    if (this.e != null) {
      this.e.a = true;
    }
  }
  
  public final void d()
  {
    if (this.c != null)
    {
      this.c.release();
      this.c = null;
    }
  }
  
  final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if (c.this.c != null)
      {
        paramMessage = new File(c.this.d + ".1.aac");
        if (paramMessage.length() > 0L) {
          bu.a(d.a(this, paramMessage));
        }
      }
      else
      {
        return;
      }
      sendEmptyMessageDelayed(0, 50L);
    }
  }
  
  static final class b
    extends y
  {
    boolean a;
    
    public b(File paramFile)
    {
      super();
    }
    
    public final boolean a()
    {
      return !this.a;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/o/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */