package com.whatsapp.j.a;

public final class o
  extends b
{
  public final int a(int paramInt)
  {
    int i = paramInt % 100;
    int j = paramInt % 10;
    if (paramInt == 1) {
      return 2;
    }
    if ((j >= 2) && (j <= 4) && ((i < 12) || (i > 14)) && ((i < 22) || (i > 24))) {
      return 8;
    }
    return 0;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/j/a/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */