package com.whatsapp.messaging;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

final class t
  extends FilterOutputStream
{
  private final ByteBuffer a;
  private boolean b;
  
  public t(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
    if (paramOutputStream == null) {
      throw new NullPointerException("out may not be null");
    }
    this.a = ByteBuffer.allocate(8192);
  }
  
  /* Error */
  public final void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_1
    //   4: aload_0
    //   5: invokevirtual 37	com/whatsapp/messaging/t:flush	()V
    //   8: aload_0
    //   9: getfield 41	com/whatsapp/messaging/t:out	Ljava/io/OutputStream;
    //   12: ldc 43
    //   14: ldc 45
    //   16: invokevirtual 51	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   19: invokevirtual 57	java/io/OutputStream:write	([B)V
    //   22: aload_0
    //   23: invokespecial 59	java/io/FilterOutputStream:close	()V
    //   26: aload_1
    //   27: astore_2
    //   28: aload_2
    //   29: ifnull +10 -> 39
    //   32: invokestatic 65	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   35: aload_2
    //   36: invokevirtual 69	java/lang/Thread:stop	(Ljava/lang/Throwable;)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: astore_1
    //   43: new 71	java/lang/Error
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 73	java/lang/Error:<init>	(Ljava/lang/Throwable;)V
    //   51: athrow
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    //   57: astore_3
    //   58: aload_1
    //   59: astore_2
    //   60: aload_1
    //   61: ifnonnull -33 -> 28
    //   64: aload_3
    //   65: astore_2
    //   66: goto -38 -> 28
    //   69: astore_1
    //   70: goto -48 -> 22
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	t
    //   3	24	1	localObject1	Object
    //   42	6	1	localUnsupportedCharsetException	java.nio.charset.UnsupportedCharsetException
    //   52	9	1	localObject2	Object
    //   69	1	1	localThrowable1	Throwable
    //   27	39	2	localObject3	Object
    //   57	8	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   4	22	42	java/nio/charset/UnsupportedCharsetException
    //   4	22	52	finally
    //   22	26	52	finally
    //   32	39	52	finally
    //   43	52	52	finally
    //   22	26	57	java/lang/Throwable
    //   4	22	69	java/lang/Throwable
  }
  
  public final void flush()
  {
    try
    {
      if (!this.b)
      {
        this.out.write("POST /chat HTTP/1.1\r\nHost: c.whatsapp.net\r\nUser-Agent: Mozilla/5.0 (compatible; WAChat/1.2; +http://www.whatsapp.com/contact)\r\nTransfer-Encoding: chunked\r\n\r\n".getBytes("UTF-8"));
        this.b = true;
      }
      if (this.a.position() > 0)
      {
        this.out.write(Integer.toHexString(this.a.position()).getBytes("UTF-8"));
        this.out.write(13);
        this.out.write(10);
        this.out.write(this.a.array(), 0, this.a.position());
        this.out.write(13);
        this.out.write(10);
        this.a.clear();
      }
      super.flush();
      return;
    }
    finally {}
  }
  
  public final void write(int paramInt)
  {
    try
    {
      if (!this.a.hasRemaining()) {
        flush();
      }
      this.a.put((byte)paramInt);
      return;
    }
    finally {}
  }
  
  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      while (paramInt2 > this.a.remaining())
      {
        int i = this.a.remaining();
        this.a.put(paramArrayOfByte, paramInt1, i);
        flush();
        paramInt1 += i;
        paramInt2 -= i;
      }
      this.a.put(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    finally {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */