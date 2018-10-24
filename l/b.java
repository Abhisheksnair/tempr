package com.whatsapp.l;

import java.util.Random;

public final class b
{
  public final Object a = new Object();
  public final Random b = new Random();
  public long c = 0L;
  public long d = 1000L;
  
  public final long a()
  {
    synchronized (this.a)
    {
      if (this.c > 987000L) {
        return 987000L;
      }
      this.d += this.c;
      this.c = (this.d - this.c);
      long l1 = this.d;
      long l2 = this.c;
      return l1 - l2;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/l/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */