package com.whatsapp;

import android.os.Handler;
import android.os.HandlerThread;

public final class mf
{
  private static final mf a = new mf();
  private Handler b;
  
  mf()
  {
    HandlerThread localHandlerThread = new HandlerThread("db_write (" + au.a() + ')', 10);
    localHandlerThread.start();
    this.b = new Handler(localHandlerThread.getLooper());
  }
  
  public static mf a()
  {
    return a;
  }
  
  public final void a(Runnable paramRunnable)
  {
    this.b.post(paramRunnable);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/mf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */