package com.whatsapp.g;

import android.os.SystemClock;

public final class j
{
  private final long a;
  
  public j()
  {
    this(System.currentTimeMillis() - SystemClock.elapsedRealtime());
  }
  
  public j(long paramLong)
  {
    this.a = paramLong;
  }
  
  public final long a()
  {
    return SystemClock.elapsedRealtime() + this.a;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/g/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */