package com.whatsapp.j.a;

public final class j
  extends b
{
  public final int a(int paramInt)
  {
    int i = paramInt % 100;
    paramInt %= 10;
    if ((paramInt == 1) && ((i < 11) || (i > 19))) {
      return 2;
    }
    if ((paramInt >= 2) && (paramInt <= 9) && ((i < 11) || (i > 19))) {
      return 8;
    }
    return 0;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/j/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */