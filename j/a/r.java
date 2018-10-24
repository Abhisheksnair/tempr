package com.whatsapp.j.a;

public final class r
  extends b
{
  public final int a(int paramInt)
  {
    paramInt %= 100;
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 2) {
      return 4;
    }
    if ((paramInt >= 3) && (paramInt <= 4)) {
      return 8;
    }
    return 0;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/j/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */