package com.whatsapp.protocol;

import java.io.Writer;

public final class e
  implements ao
{
  private final Writer a;
  private final ao b;
  private final ao c;
  private final ao d;
  private final String e;
  
  public e(ao paramao1, ao paramao2, Writer paramWriter, String paramString)
  {
    this.c = paramao1;
    this.d = paramao2;
    this.a = paramWriter;
    this.b = new ay(this.a);
    this.e = paramString;
  }
  
  public final void a()
  {
    this.c.a();
    this.a.write(this.e);
    this.b.a();
  }
  
  public final void a(ak paramak)
  {
    this.c.a(paramak);
    try
    {
      this.a.write(this.e);
      this.b.a(paramak);
      return;
    }
    catch (Exception paramak) {}
  }
  
  public final void a(ak paramak, int paramInt)
  {
    this.c.a(paramak, paramInt);
    try
    {
      this.a.write(this.e);
      this.b.a(paramak);
      return;
    }
    catch (Exception paramak) {}
  }
  
  public final byte[] b(ak paramak)
  {
    try
    {
      this.a.write(this.e);
      this.b.a(paramak);
      return this.d.b(paramak);
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */