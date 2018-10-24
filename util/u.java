package com.whatsapp.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class u
  implements ThreadFactory
{
  private final AtomicInteger a = new AtomicInteger(0);
  private final String b;
  
  private u(String paramString)
  {
    this.b = paramString;
  }
  
  public final Thread newThread(Runnable paramRunnable)
  {
    return new Thread(v.a(paramRunnable), this.b + this.a.getAndIncrement());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */