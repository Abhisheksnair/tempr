package com.whatsapp.j.a;

public final class l
  extends b
{
  public final int a(int paramInt)
  {
    int i = paramInt % 100;
    if (paramInt == 1) {
      return 2;
    }
    if ((paramInt == 0) || ((i >= 2) && (i <= 10))) {
      return 8;
    }
    if ((i >= 11) && (i <= 19)) {
      return 16;
    }
    return 0;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/j/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */