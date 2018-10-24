package com.whatsapp.k;

import com.whatsapp.av;
import java.util.Random;

public final class h
{
  private final int a = 1;
  private final int b;
  private final int c;
  private final Random d;
  
  public h(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = new Random();
  }
  
  public final boolean a(int paramInt)
  {
    paramInt = b(paramInt);
    return this.d.nextInt(paramInt) == 0;
  }
  
  public final int b(int paramInt)
  {
    if (av.d()) {
      return 1;
    }
    if (av.h()) {
      return this.a * paramInt;
    }
    if ((av.i()) || (av.f())) {
      return this.b * paramInt;
    }
    return this.c * paramInt;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/k/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */