package com.whatsapp.m;

import com.whatsapp.Mp4Ops;
import com.whatsapp.Mp4Ops.a;
import com.whatsapp.util.Log;
import com.whatsapp.util.a.c;
import java.io.File;
import java.io.InputStream;

public final class d
{
  private static final byte[] b = { 102, 116, 121, 112 };
  private static final byte[] c = { 109, 111, 111, 118 };
  private static final byte[] d = { 109, 100, 97, 116 };
  a a;
  private final File e;
  private final long f;
  private final c g;
  
  public d(c paramc, File paramFile, long paramLong)
  {
    this.g = paramc;
    this.e = paramFile;
    this.f = paramLong;
  }
  
  private static int a(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    return (paramByte1 & 0xFF) << 24 | (paramByte2 & 0xFF) << 16 | (paramByte3 & 0xFF) << 8 | paramByte4 & 0xFF;
  }
  
  private a a(boolean paramBoolean)
  {
    try
    {
      Mp4Ops.a(this.e, paramBoolean, this.f);
      Mp4Ops.a("streamCheck", "stream check on download");
      a locala = a.a;
      return locala;
    }
    catch (Mp4Ops.a locala1)
    {
      Log.d("Mp4StreamCheck/failed/exception", locala1);
      Mp4Ops.a(this.g, this.e, locala1, "stream check on download");
      Mp4Ops.a("streamCheck", "stream check on download");
    }
    return a.b;
  }
  
  private boolean a(InputStream paramInputStream, long paramLong)
  {
    int j = 0;
    int m = 0;
    long l2 = 0L;
    byte[] arrayOfByte = new byte[8];
    if (paramInputStream.read(arrayOfByte, 0, 8) != 8) {
      return true;
    }
    if (!a(arrayOfByte, b))
    {
      this.a = a.b;
      return false;
    }
    int i = a(arrayOfByte[0], arrayOfByte[1], arrayOfByte[2], arrayOfByte[3]) - 8;
    if (i + 8 > paramLong) {
      return true;
    }
    paramInputStream.skip(i);
    i += 8;
    long l1;
    int k;
    for (;;)
    {
      l1 = l2;
      k = m;
      if (i + 8 < paramLong)
      {
        k = paramInputStream.read(arrayOfByte, 0, 8);
        i += k;
        if (k != 8) {
          return true;
        }
        if (a(arrayOfByte, c))
        {
          j = 1;
          k = a(arrayOfByte[0], arrayOfByte[1], arrayOfByte[2], arrayOfByte[3]) - 8;
          if (i + k > paramLong) {
            return true;
          }
          paramInputStream.skip(k);
          i += k;
          continue;
        }
        if (!a(arrayOfByte, d)) {
          break label318;
        }
        k = a(arrayOfByte[0], arrayOfByte[1], arrayOfByte[2], arrayOfByte[3]);
        if (i + 8 >= paramLong) {
          break label316;
        }
        l1 = k - 8 + i;
        k = 1;
      }
      label316:
      label318:
      int n;
      do
      {
        if ((j == 0) || (k == 0)) {
          break label415;
        }
        if (l1 <= this.f) {
          break;
        }
        this.g.a("LibMp4Operations stream check failed: mdat stretches outside", false, null, -1);
        this.a = a.b;
        return false;
        return true;
        n = a(arrayOfByte[0], arrayOfByte[1], arrayOfByte[2], arrayOfByte[3]) - 8;
        paramInputStream.skip(n);
        l1 = l2;
        k = m;
      } while (i + n > paramLong);
      i += n;
    }
    if (l1 > this.f - 1024L)
    {
      this.a = a(true);
      return false;
    }
    this.a = a(false);
    return false;
    label415:
    if (k != 0)
    {
      Log.e("Mp4StreamCheck/mdat before moov, failing check");
      this.a = a.b;
      this.g.a("LibMp4Operations stream check failed: no moov box", false, null, -1);
      return false;
    }
    return true;
  }
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i;
    if (4 >= paramArrayOfByte2.length) {
      i = 0;
    }
    while (i < paramArrayOfByte2.length)
    {
      if (paramArrayOfByte1[(i + 4)] != paramArrayOfByte2[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final boolean a()
  {
    return this.a != null;
  }
  
  /* Error */
  public final boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 117	com/whatsapp/m/d:a	()Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: new 119	java/io/FileInputStream
    //   12: dup
    //   13: aload_0
    //   14: getfield 44	com/whatsapp/m/d:e	Ljava/io/File;
    //   17: invokespecial 122	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: astore 5
    //   22: aload_0
    //   23: aload 5
    //   25: lload_1
    //   26: invokespecial 124	com/whatsapp/m/d:a	(Ljava/io/InputStream;J)Z
    //   29: istore_3
    //   30: iload_3
    //   31: ifeq +19 -> 50
    //   34: ldc 126
    //   36: invokestatic 129	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   39: aload 5
    //   41: invokevirtual 132	java/io/FileInputStream:close	()V
    //   44: iload_3
    //   45: ireturn
    //   46: astore 4
    //   48: iload_3
    //   49: ireturn
    //   50: new 134	java/lang/StringBuilder
    //   53: dup
    //   54: ldc -120
    //   56: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   59: aload_0
    //   60: getfield 87	com/whatsapp/m/d:a	Lcom/whatsapp/m/d$a;
    //   63: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 129	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   72: goto -33 -> 39
    //   75: astore 4
    //   77: aload 5
    //   79: ifnull +8 -> 87
    //   82: aload 5
    //   84: invokevirtual 132	java/io/FileInputStream:close	()V
    //   87: aload 4
    //   89: athrow
    //   90: astore 5
    //   92: goto -5 -> 87
    //   95: astore 4
    //   97: aconst_null
    //   98: astore 5
    //   100: goto -23 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	d
    //   0	103	1	paramLong	long
    //   29	20	3	bool	boolean
    //   46	1	4	localIOException1	java.io.IOException
    //   75	13	4	localObject1	Object
    //   95	1	4	localObject2	Object
    //   20	63	5	localFileInputStream	java.io.FileInputStream
    //   90	1	5	localIOException2	java.io.IOException
    //   98	1	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   39	44	46	java/io/IOException
    //   22	30	75	finally
    //   34	39	75	finally
    //   50	72	75	finally
    //   82	87	90	java/io/IOException
    //   9	22	95	finally
  }
  
  static enum a
  {
    private a() {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/m/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */