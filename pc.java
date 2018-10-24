package com.whatsapp;

public final class pc
{
  public static final pc a = new pc();
  int b = 3;
  
  public static pc a()
  {
    return a;
  }
  
  public final boolean b()
  {
    return this.b == 3;
  }
  
  public final boolean c()
  {
    return this.b == 2;
  }
  
  public final boolean d()
  {
    return this.b == 1;
  }
  
  public final boolean e()
  {
    return this.b != 3;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/pc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */