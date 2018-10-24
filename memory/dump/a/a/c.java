package com.whatsapp.memory.dump.a.a;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public final class c
  implements a
{
  private final long a;
  private final DataInputStream b;
  private long c = 0L;
  
  public c(File paramFile)
  {
    this.a = paramFile.length();
    this.b = new DataInputStream(new BufferedInputStream(new FileInputStream(paramFile)));
  }
  
  public final byte a()
  {
    byte b1 = this.b.readByte();
    this.c += 1L;
    return b1;
  }
  
  public final void a(long paramLong)
  {
    a(new byte[(int)(paramLong - this.c)]);
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    this.b.read(paramArrayOfByte);
    this.c += paramArrayOfByte.length;
  }
  
  public final short b()
  {
    short s = this.b.readShort();
    this.c += 2L;
    return s;
  }
  
  public final int c()
  {
    int i = this.b.readInt();
    this.c += 4L;
    return i;
  }
  
  public final long d()
  {
    this.c += 8L;
    return this.b.readLong();
  }
  
  public final long e()
  {
    return this.c;
  }
  
  public final boolean f()
  {
    return this.c < this.a;
  }
  
  public final long g()
  {
    return this.a - this.c;
  }
  
  public final void h()
  {
    this.b.close();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/memory/dump/a/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */