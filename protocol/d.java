package com.whatsapp.protocol;

import java.io.Writer;

public final class d
  implements an
{
  private final an a;
  private final an b;
  private final Writer c;
  private final ao d;
  private final String e;
  
  public d(an paraman1, an paraman2, Writer paramWriter, String paramString)
  {
    this.a = paraman1;
    this.b = paraman2;
    this.c = paramWriter;
    this.d = new ay(this.c);
    this.e = paramString;
  }
  
  public final ak a()
  {
    ak localak = this.a.a();
    try
    {
      this.c.write(this.e);
      this.d.a(localak);
      return localak;
    }
    catch (Exception localException) {}
    return localak;
  }
  
  public final ak a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = this.b.a(paramArrayOfByte);
    try
    {
      this.c.write(this.e);
      this.d.a(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception localException) {}
    return paramArrayOfByte;
  }
  
  public final String b()
  {
    return this.a.b();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */