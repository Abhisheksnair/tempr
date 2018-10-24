package com.whatsapp.protocol;

import android.os.Looper;
import com.whatsapp.util.Log;

public class af
{
  private static volatile af a;
  private final ah b;
  private final ag c;
  
  private af(ah paramah, ag paramag)
  {
    this.b = paramah;
    this.c = paramag;
  }
  
  public static af a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new af(ah.a(), ag.a());
      }
      return a;
    }
    finally {}
  }
  
  public final void a(j paramj)
  {
    if (paramj == null) {}
    do
    {
      return;
      if (Looper.myLooper() == Looper.getMainLooper()) {
        Log.c("message is lazy loaded on ui thread", new Throwable());
      }
      this.b.a(paramj);
      this.c.a(paramj);
    } while (m.c(paramj));
    throw new IllegalStateException("ensureCompletelyLoaded failed");
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */