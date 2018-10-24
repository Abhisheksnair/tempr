package com.whatsapp.j.a;

public final class d
  extends b
{
  public final int a(int paramInt)
  {
    int i = paramInt % 100;
    paramInt %= 10;
    if ((paramInt == 1) && (i != 11)) {
      return 2;
    }
    if ((paramInt >= 2) && (paramInt <= 4) && ((i < 12) || (i > 14))) {
      return 8;
    }
    return 0;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/j/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */