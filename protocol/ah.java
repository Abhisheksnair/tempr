package com.whatsapp.protocol;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.whatsapp.data.cq;
import com.whatsapp.util.Log;

public class ah
{
  private static volatile ah a;
  private final Handler b;
  private final cq c;
  
  private ah(cq paramcq)
  {
    HandlerThread localHandlerThread = new HandlerThread("MessageThumbnailAsyncLoader thread");
    localHandlerThread.start();
    this.b = new Handler(localHandlerThread.getLooper());
    this.c = paramcq;
  }
  
  public static ah a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ah(cq.a());
      }
      return a;
    }
    finally {}
  }
  
  final void a(j paramj)
  {
    j localj = paramj;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      Log.c("thumbs are loaded on ui thread", new Throwable());
    }
    for (localj = paramj; localj != null; localj = localj.V) {
      if (localj.f() != null) {
        localj.f().a(this.c);
      }
    }
  }
  
  public final void a(l paraml)
  {
    paraml.a(this.c);
  }
  
  public final void a(l paraml, Runnable paramRunnable)
  {
    if (paraml.a())
    {
      paramRunnable.run();
      return;
    }
    this.b.post(ai.a(this, paraml, paramRunnable));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */