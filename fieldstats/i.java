package com.whatsapp.fieldstats;

import com.whatsapp.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;

class i
{
  final a b = new a();
  int c = -1;
  int d = 0;
  
  private static int a(long paramLong, a parama)
  {
    if ((paramLong < 0L) || (paramLong > 4294967295L)) {
      throw new IllegalArgumentException("Value is not an unsigned integer");
    }
    parama.write((byte)(int)paramLong);
    if (paramLong <= 255L) {
      return 1;
    }
    parama.write((byte)(int)(paramLong >> 8));
    if (paramLong <= 65535L) {
      return 2;
    }
    parama.write((byte)(int)(paramLong >> 16));
    parama.write((byte)(int)(paramLong >> 24));
    return 4;
  }
  
  private static int a(String paramString, a parama)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      if (paramString.length > 1024) {
        Log.w(String.format(Locale.US, "wam/serialize: string length is limited to %d UTF-8 bytes", new Object[] { Integer.valueOf(1024) }));
      }
      int i = Math.min(paramString.length, 1024);
      int j = a(i, parama);
      parama.write(paramString, 0, i);
      switch (j)
      {
      case 3: 
      default: 
        throw new Error("Impossible");
      }
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new Error(paramString);
    }
    return 8;
    return 9;
    return 10;
  }
  
  static c a(ByteBuffer paramByteBuffer)
  {
    try
    {
      paramByteBuffer = b(paramByteBuffer);
      return paramByteBuffer;
    }
    catch (BufferUnderflowException paramByteBuffer)
    {
      throw new b("Incomplete buffer");
    }
  }
  
  private static String a(int paramInt, ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[paramInt];
    paramByteBuffer.get(arrayOfByte);
    try
    {
      paramByteBuffer = new String(arrayOfByte, "UTF-8");
      return paramByteBuffer;
    }
    catch (UnsupportedEncodingException paramByteBuffer)
    {
      throw new b("UnsupportedEncoding: " + paramByteBuffer);
    }
  }
  
  private static int b(long paramLong, a parama)
  {
    int i = 1;
    if (paramLong == 0L) {
      return 1;
    }
    if (paramLong == 1L) {
      return 2;
    }
    parama.write((byte)(int)paramLong);
    if ((-128L <= paramLong) && (paramLong <= 127L)) {}
    for (;;)
    {
      switch (i)
      {
      default: 
        return 3;
        parama.write((byte)(int)(paramLong >> 8));
        if ((-32768L <= paramLong) && (paramLong <= 32767L))
        {
          i = 2;
        }
        else
        {
          parama.write((byte)(int)(paramLong >> 16));
          parama.write((byte)(int)(paramLong >> 24));
          if ((-2147483648L <= paramLong) && (paramLong <= 2147483647L))
          {
            i = 4;
          }
          else
          {
            parama.write((byte)(int)(paramLong >> 32));
            parama.write((byte)(int)(paramLong >> 40));
            parama.write((byte)(int)(paramLong >> 48));
            parama.write((byte)(int)(paramLong >> 56));
            i = 8;
          }
        }
        break;
      }
    }
    return 4;
    return 5;
    return 6;
  }
  
  private static long b(int paramInt, ByteBuffer paramByteBuffer)
  {
    if ((paramInt <= 0) || (4 < paramInt)) {
      throw new IllegalArgumentException("Invalid number of bytes: " + paramInt);
    }
    long l = 0L;
    int i = 0;
    while (i < paramInt)
    {
      l |= (paramByteBuffer.get() & 0xFF) << (i << 3);
      i += 1;
    }
    return l;
  }
  
  private static c b(ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    int j = paramByteBuffer.position();
    byte b1 = paramByteBuffer.get();
    int k = b1 & 0x3;
    String str;
    if (k > 2) {
      try
      {
        throw new IllegalArgumentException("Invalid record type");
      }
      catch (IllegalArgumentException paramByteBuffer)
      {
        str = String.format("%02X ", new Object[] { Byte.valueOf(b1) });
        throw new b(paramByteBuffer + " at " + j + ", tag: " + str);
      }
    }
    int i;
    if ((b1 & 0x8) == 0)
    {
      i = 0;
      if (i != 0) {
        break label228;
      }
    }
    int m;
    label228:
    for (long l = b(1, paramByteBuffer);; l = b(2, paramByteBuffer))
    {
      i = (int)l;
      m = b1 >> 4 & 0xF;
      if (m <= 10) {
        break label238;
      }
      try
      {
        throw new IllegalArgumentException("Invalid value type " + m);
      }
      catch (IllegalArgumentException paramByteBuffer)
      {
        str = String.format("%02X ", new Object[] { Byte.valueOf(b1) });
        throw new b(paramByteBuffer + " at " + j + ", tag: " + str);
      }
      i = 1;
      break;
    }
    label238:
    paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    switch (m)
    {
    default: 
      throw new Error("Invalid value type");
    case 0: 
      paramByteBuffer = null;
    }
    for (;;)
    {
      return new c(k, i, paramByteBuffer);
      paramByteBuffer = Integer.valueOf(0);
      continue;
      paramByteBuffer = Integer.valueOf(1);
      continue;
      paramByteBuffer = Byte.valueOf(paramByteBuffer.get());
      continue;
      paramByteBuffer = Short.valueOf(paramByteBuffer.getShort());
      continue;
      paramByteBuffer = Integer.valueOf(paramByteBuffer.getInt());
      continue;
      paramByteBuffer = Long.valueOf(paramByteBuffer.getLong());
      continue;
      paramByteBuffer = Double.valueOf(paramByteBuffer.getDouble());
      continue;
      paramByteBuffer = a((int)b(1, paramByteBuffer), paramByteBuffer);
      continue;
      paramByteBuffer = a((int)b(2, paramByteBuffer), paramByteBuffer);
      continue;
      paramByteBuffer = a((int)b(4, paramByteBuffer), paramByteBuffer);
    }
  }
  
  public final i a(byte paramByte)
  {
    this.b.a()[this.c] = paramByte;
    return this;
  }
  
  public void a()
  {
    this.b.reset();
    this.c = -1;
    this.d = 0;
  }
  
  protected final void a(int paramInt1, int paramInt2, Object paramObject)
  {
    int j = 0;
    this.c = this.b.size();
    this.b.write(0);
    int i;
    a locala;
    switch (a(paramInt2, this.b))
    {
    default: 
      throw new Error("Id too big to fit in 2 bytes");
    case 1: 
      i = 0;
      locala = this.b;
      if (paramObject == null) {
        paramInt2 = j;
      }
      break;
    }
    for (;;)
    {
      a((byte)(i << 3 | paramInt2 << 4 | paramInt1));
      this.d += 1;
      return;
      i = 1;
      break;
      long l;
      if ((paramObject instanceof Boolean))
      {
        if (((Boolean)paramObject).booleanValue()) {}
        for (l = 1L;; l = 0L)
        {
          paramInt2 = b(l, locala);
          break;
        }
      }
      if ((paramObject instanceof Long))
      {
        paramInt2 = b(((Long)paramObject).longValue(), locala);
      }
      else if ((paramObject instanceof Number))
      {
        double d1 = ((Number)paramObject).doubleValue();
        if (d1 == d1)
        {
          paramInt2 = b(d1, locala);
        }
        else
        {
          l = Double.doubleToRawLongBits(d1);
          locala.write((byte)(int)l);
          locala.write((byte)(int)(l >> 8));
          locala.write((byte)(int)(l >> 16));
          locala.write((byte)(int)(l >> 24));
          locala.write((byte)(int)(l >> 32));
          locala.write((byte)(int)(l >> 40));
          locala.write((byte)(int)(l >> 48));
          locala.write((byte)(int)(l >> 56));
          paramInt2 = 7;
        }
      }
      else
      {
        if (!(paramObject instanceof String)) {
          break label335;
        }
        paramInt2 = a((String)paramObject, locala);
      }
    }
    label335:
    throw new IllegalArgumentException("Expected class Boolean, Number, or String, got " + paramObject.getClass().getName());
  }
  
  static final class a
    extends ByteArrayOutputStream
  {
    public final byte[] a()
    {
      return this.buf;
    }
    
    public final ByteBuffer b()
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(this.buf, 0, size());
      localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      return localByteBuffer.asReadOnlyBuffer();
    }
  }
  
  static final class b
    extends Exception
  {
    b(String paramString)
    {
      super();
    }
  }
  
  static final class c
  {
    final int a;
    final int b;
    final Object c;
    
    c(int paramInt1, int paramInt2, Object paramObject)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramObject;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */