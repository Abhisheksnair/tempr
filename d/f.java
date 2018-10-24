package com.whatsapp.d;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class f
  extends FilterInputStream
{
  public long a;
  private final MessageDigest b;
  private final byte[] c;
  private byte[] d;
  
  public f(InputStream paramInputStream)
  {
    super(paramInputStream);
    try
    {
      this.b = MessageDigest.getInstance("SHA-256");
      this.c = new byte[' '];
      return;
    }
    catch (NoSuchAlgorithmException paramInputStream)
    {
      throw new AssertionError(paramInputStream);
    }
  }
  
  public final byte[] a()
  {
    if (this.d == null) {
      this.d = this.b.digest();
    }
    return this.d;
  }
  
  public final int read()
  {
    byte[] arrayOfByte = new byte[1];
    for (;;)
    {
      int i = read(arrayOfByte, 0, 1);
      if (i == -1) {
        return -1;
      }
      if (i != 0) {
        return arrayOfByte[0];
      }
      Thread.yield();
    }
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > 0)
    {
      this.b.update(paramArrayOfByte, paramInt1, paramInt2);
      this.a += paramInt2;
    }
    return paramInt2;
  }
  
  public final long skip(long paramLong)
  {
    return read(this.c, 0, (int)Math.min(this.c.length, paramLong));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */