package com.whatsapp.k;

import android.os.SystemClock;

public final class i
{
  public long a = 0L;
  public boolean b = false;
  private long c = 0L;
  
  public final void a()
  {
    this.c = SystemClock.elapsedRealtime();
    this.b = true;
  }
  
  public final void b()
  {
    if (this.b)
    {
      this.a += SystemClock.elapsedRealtime() - this.c;
      this.c = 0L;
      this.b = false;
    }
  }
  
  public final void c()
  {
    this.a = 0L;
    this.c = 0L;
    this.b = false;
  }
  
  public final String toString()
  {
    return String.valueOf(this.a);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/k/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */