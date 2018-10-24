package com.whatsapp.util;

import java.io.InputStream;
import java.util.Locale;

public final class k
  extends InputStream
{
  private final long a;
  private long b;
  private final InputStream c;
  
  public k(InputStream paramInputStream, long paramLong)
  {
    Log.i("bounded-input-stream/construct/" + paramLong);
    this.c = paramInputStream;
    this.a = paramLong;
  }
  
  public final int available()
  {
    if (this.b < this.a) {
      return this.c.available();
    }
    Log.i(String.format(Locale.ENGLISH, "bounded-input-stream/available size-limit:%d already-read:%d, returning 0", new Object[] { Long.valueOf(this.a), Long.valueOf(this.b) }));
    return 0;
  }
  
  public final void close()
  {
    this.c.close();
  }
  
  public final void mark(int paramInt)
  {
    this.c.mark(paramInt);
  }
  
  public final boolean markSupported()
  {
    return this.c.markSupported();
  }
  
  public final int read()
  {
    int i;
    if (this.b >= this.a)
    {
      Log.i(String.format(Locale.ENGLISH, "bounded-input-stream/read size-limit:%d already-read:%d, returning -1", new Object[] { Long.valueOf(this.a), Long.valueOf(this.b) }));
      i = -1;
    }
    int j;
    do
    {
      return i;
      j = this.c.read();
      i = j;
    } while (j < 0);
    this.b += 1L;
    return j;
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (paramInt2 + this.b > this.a)
    {
      Log.i(String.format(Locale.ENGLISH, "bounded-input-stream/read/bytes-truncated-from-%d-to-%d", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(this.a - this.b) }));
      i = (int)(this.a - this.b);
    }
    if (i <= 0) {
      paramInt1 = -1;
    }
    do
    {
      return paramInt1;
      paramInt2 = this.c.read(paramArrayOfByte, paramInt1, i);
      paramInt1 = paramInt2;
    } while (paramInt2 <= 0);
    this.b += paramInt2;
    return paramInt2;
  }
  
  public final void reset()
  {
    this.c.reset();
  }
  
  public final long skip(long paramLong)
  {
    long l = paramLong;
    if (this.b + paramLong > this.a)
    {
      Log.i(String.format(Locale.ENGLISH, "bounded-input-stream/skip/bytes-truncated-from-%d-to-%d", new Object[] { Long.valueOf(paramLong), Long.valueOf(this.a - this.b) }));
      l = Math.max(this.a - this.b, 0L);
    }
    return super.skip(l);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */