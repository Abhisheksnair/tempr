package com.whatsapp.fieldstats;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.Adler32;
import java.util.zip.Checksum;

final class h
{
  public static final long c = new Adler32().getValue();
  int a;
  final ByteBuffer b;
  private final RandomAccessFile d;
  private final int e;
  private final Checksum f;
  private int g;
  
  public h(RandomAccessFile paramRandomAccessFile, int paramInt)
  {
    this.d = paramRandomAccessFile;
    this.e = paramInt;
    this.a = 0;
    this.b = ByteBuffer.allocate(65536);
    this.b.order(ByteOrder.LITTLE_ENDIAN);
    this.f = new Adler32();
    this.g = 0;
  }
  
  private void b(long paramLong)
  {
    try
    {
      this.d.seek(paramLong);
      return;
    }
    catch (IOException localIOException)
    {
      k.a().i = Boolean.valueOf(true);
      throw localIOException;
    }
  }
  
  public final long a()
  {
    this.f.update(this.b.array(), this.g, this.b.position() - this.g);
    this.g = this.b.position();
    return this.f.getValue();
  }
  
  public final h a(int paramInt)
  {
    this.b.putInt(paramInt);
    return this;
  }
  
  public final h a(long paramLong)
  {
    if ((paramLong < 0L) || (paramLong > 4294967295L)) {
      throw new IllegalArgumentException("Value is not an unsigned integer");
    }
    this.b.putInt((int)paramLong);
    return this;
  }
  
  public final h a(ByteBuffer paramByteBuffer)
  {
    this.b.put(paramByteBuffer);
    return this;
  }
  
  public final h a(byte[] paramArrayOfByte)
  {
    this.b.put(paramArrayOfByte);
    return this;
  }
  
  public final h b(int paramInt)
  {
    b(this.e);
    try
    {
      this.d.readFully(this.b.array(), 0, paramInt);
      this.b.position(paramInt);
      this.a = paramInt;
      this.f.reset();
      this.g = 0;
      return this;
    }
    catch (EOFException localEOFException)
    {
      k.a().h = Boolean.valueOf(true);
      throw localEOFException;
    }
    catch (IOException localIOException)
    {
      k.a().g = Boolean.valueOf(true);
      throw localIOException;
    }
  }
  
  public final ByteBuffer b()
  {
    ByteBuffer localByteBuffer = this.b.asReadOnlyBuffer();
    localByteBuffer.flip();
    return localByteBuffer;
  }
  
  public final h c()
  {
    this.b.clear();
    this.a = 0;
    this.f.reset();
    this.g = 0;
    return this;
  }
  
  public final h d()
  {
    if (this.d != null) {
      if (this.b.position() == this.a) {
        break label29;
      }
    }
    label29:
    for (int i = 1; i == 0; i = 0) {
      return this;
    }
    b(this.e + this.a);
    try
    {
      this.d.write(this.b.array(), this.a, this.b.position() - this.a);
      this.a = this.b.position();
      return this;
    }
    catch (IOException localIOException)
    {
      k.a().b();
      throw localIOException;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */