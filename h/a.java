package com.whatsapp.h;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.h;
import com.google.android.exoplayer2.h.n.a;
import com.whatsapp.m.a.a;
import com.whatsapp.m.a.b;
import com.whatsapp.m.a.c;
import com.whatsapp.m.c;
import com.whatsapp.m.c.a;
import com.whatsapp.util.Log;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class a
  implements f, a.c
{
  private final com.whatsapp.m.a a;
  private RandomAccessFile b;
  private boolean c;
  private long d;
  private long e;
  
  public a(com.whatsapp.m.a parama)
  {
    this.a = parama;
  }
  
  /* Error */
  private boolean a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/whatsapp/h/a:c	Z
    //   4: ifeq +10 -> 14
    //   7: aload_0
    //   8: getfield 32	com/whatsapp/h/a:b	Ljava/io/RandomAccessFile;
    //   11: ifnonnull +5 -> 16
    //   14: iconst_1
    //   15: ireturn
    //   16: aload_0
    //   17: getfield 32	com/whatsapp/h/a:b	Ljava/io/RandomAccessFile;
    //   20: invokevirtual 38	java/io/RandomAccessFile:getFilePointer	()J
    //   23: lstore_2
    //   24: aload_0
    //   25: getfield 32	com/whatsapp/h/a:b	Ljava/io/RandomAccessFile;
    //   28: invokevirtual 41	java/io/RandomAccessFile:close	()V
    //   31: aload_0
    //   32: aconst_null
    //   33: putfield 32	com/whatsapp/h/a:b	Ljava/io/RandomAccessFile;
    //   36: aload_0
    //   37: new 34	java/io/RandomAccessFile
    //   40: dup
    //   41: aload_1
    //   42: ldc 43
    //   44: invokespecial 46	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   47: putfield 32	com/whatsapp/h/a:b	Ljava/io/RandomAccessFile;
    //   50: aload_0
    //   51: getfield 32	com/whatsapp/h/a:b	Ljava/io/RandomAccessFile;
    //   54: lload_2
    //   55: invokevirtual 50	java/io/RandomAccessFile:seek	(J)V
    //   58: iconst_1
    //   59: ireturn
    //   60: astore_1
    //   61: aload_1
    //   62: invokestatic 55	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   65: iconst_0
    //   66: ireturn
    //   67: astore_1
    //   68: aload_1
    //   69: invokestatic 55	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   72: iconst_0
    //   73: ireturn
    //   74: astore_1
    //   75: aload_1
    //   76: invokestatic 55	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 32	com/whatsapp/h/a:b	Ljava/io/RandomAccessFile;
    //   84: iconst_0
    //   85: ireturn
    //   86: astore_1
    //   87: aload_0
    //   88: aconst_null
    //   89: putfield 32	com/whatsapp/h/a:b	Ljava/io/RandomAccessFile;
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	a
    //   0	94	1	paramFile	java.io.File
    //   23	32	2	l	long
    // Exception table:
    //   from	to	target	type
    //   36	58	60	java/io/IOException
    //   16	24	67	java/io/IOException
    //   24	31	74	java/io/IOException
    //   24	31	86	finally
    //   75	79	86	finally
  }
  
  public final int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.a.d() == a.b.b) {}
    long l;
    do
    {
      do
      {
        return 0;
        paramInt2 = (int)Math.min(paramInt2, this.d - this.e);
        if (paramInt2 == 0) {
          return -1;
        }
      } while (!this.a.d(this.b.getFilePointer()));
      l = this.a.e(this.b.getFilePointer());
    } while (l == 0L);
    paramInt1 = this.b.read(paramArrayOfByte, paramInt1, (int)Math.min(paramInt2, l));
    if (paramInt1 == -1)
    {
      if (this.d != this.e) {
        throw new EOFException();
      }
      return -1;
    }
    this.e += paramInt1;
    return paramInt1;
  }
  
  public final long a(h paramh)
  {
    this.e = 0L;
    try
    {
      this.b = new RandomAccessFile(this.a.g(), "r");
      this.a.a(this);
      c localc = this.a.a;
      long l = paramh.d;
      localc.a.removeCallbacks(localc.b);
      localc.b = new c.a(localc, l);
      localc.a.postDelayed(localc.b, 200L);
      this.b.seek(paramh.d);
      this.c = true;
      this.d = (this.a.i() - paramh.d);
      return this.d;
    }
    catch (IOException paramh)
    {
      throw new n.a(paramh);
    }
  }
  
  public final Uri a()
  {
    return Uri.fromFile(this.a.g());
  }
  
  public final void a(a.a parama) {}
  
  public final void a(com.whatsapp.m.a parama) {}
  
  public final void b()
  {
    if (this.b != null) {}
    try
    {
      this.b.close();
      this.b = null;
      if (this.c) {
        this.c = false;
      }
      this.a.b(this);
      return;
    }
    catch (IOException localIOException)
    {
      throw new n.a(localIOException);
    }
    finally
    {
      this.b = null;
      if (this.c) {
        this.c = false;
      }
    }
  }
  
  public final void b(com.whatsapp.m.a parama) {}
  
  public final void x_()
  {
    if (!a(this.a.g())) {
      Log.e("WhatsappChunkAwareDataSource/hotswap failed");
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */