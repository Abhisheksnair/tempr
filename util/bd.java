package com.whatsapp.util;

import android.os.SystemClock;

public final class bd
{
  private final boolean a;
  private boolean b = false;
  private String c = null;
  private long d = 0L;
  
  public bd()
  {
    this(false);
  }
  
  public bd(String paramString)
  {
    this(false);
    a(paramString);
  }
  
  public bd(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  private long d()
  {
    if (this.a) {
      return SystemClock.elapsedRealtime();
    }
    return SystemClock.uptimeMillis();
  }
  
  public final void a()
  {
    if (this.b)
    {
      if (this.c == null) {
        break label48;
      }
      Log.d(this.c + "/timer/start");
    }
    for (;;)
    {
      this.d = d();
      return;
      label48:
      Log.d("timer/start");
    }
  }
  
  public final void a(String paramString)
  {
    this.c = paramString;
    this.b = true;
    a();
  }
  
  public final long b()
  {
    if (this.d == 0L) {
      return 0L;
    }
    long l = d() - this.d;
    if (this.b)
    {
      if (this.c == null) {
        break label81;
      }
      Log.i(this.c + "/timer/stop: " + l);
    }
    for (;;)
    {
      this.d = 0L;
      this.b = false;
      this.c = null;
      return l;
      label81:
      Log.i("timer/stop: " + l);
    }
  }
  
  public final long c()
  {
    long l = d() - this.d;
    if (this.b)
    {
      if (this.c != null) {
        Log.i(this.c + "/timer/elapsed: " + l);
      }
    }
    else {
      return l;
    }
    Log.i("timer/elapsed: " + l);
    return l;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */