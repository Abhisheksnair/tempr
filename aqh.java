package com.whatsapp;

public final class aqh
{
  public final String a;
  public final String b;
  public final int c;
  public final int d;
  public final int e;
  public final int f;
  
  public aqh()
  {
    this(null, null, -1, -1, -1, -1);
  }
  
  public aqh(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramString1;
    this.c = paramInt1;
    this.e = paramInt3;
    this.b = paramString2;
    this.d = paramInt2;
    this.f = paramInt4;
  }
  
  public static aqh a(aqh paramaqh, String paramString, int paramInt1, int paramInt2)
  {
    return new aqh(paramString, paramaqh.b, paramInt1, paramaqh.d, paramInt2, paramaqh.f);
  }
  
  public static aqh b(aqh paramaqh, String paramString, int paramInt1, int paramInt2)
  {
    return new aqh(paramaqh.a, paramString, paramaqh.c, paramInt1, paramaqh.e, paramInt2);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aqh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */