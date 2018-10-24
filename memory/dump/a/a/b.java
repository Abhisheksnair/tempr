package com.whatsapp.memory.dump.a.a;

import java.io.DataOutputStream;

public final class b
  implements a
{
  private final a a;
  private final DataOutputStream b;
  
  public b(a parama, DataOutputStream paramDataOutputStream)
  {
    this.a = parama;
    this.b = paramDataOutputStream;
  }
  
  public final byte a()
  {
    byte b1 = this.a.a();
    this.b.write(b1);
    return b1;
  }
  
  public final void a(long paramLong)
  {
    a(new byte[(int)(paramLong - this.a.e())]);
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    this.a.a(paramArrayOfByte);
    this.b.write(paramArrayOfByte);
  }
  
  public final short b()
  {
    short s = this.a.b();
    this.b.writeShort(s);
    return s;
  }
  
  public final void b(byte[] paramArrayOfByte)
  {
    this.a.a(paramArrayOfByte);
    paramArrayOfByte = new byte[paramArrayOfByte.length];
    this.b.write(paramArrayOfByte);
  }
  
  public final int c()
  {
    int i = this.a.c();
    this.b.writeInt(i);
    return i;
  }
  
  public final long d()
  {
    long l = this.a.d();
    this.b.writeLong(l);
    return l;
  }
  
  public final long e()
  {
    return this.a.e();
  }
  
  public final boolean f()
  {
    return this.a.f();
  }
  
  public final long g()
  {
    return this.a.g();
  }
  
  public final void h()
  {
    this.a.h();
    this.b.close();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/memory/dump/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */