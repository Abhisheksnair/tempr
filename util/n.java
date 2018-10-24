package com.whatsapp.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class n<V>
  implements m<V>, Future<V>
{
  private V a;
  private boolean b;
  private final CountDownLatch c = new CountDownLatch(1);
  
  private V b()
  {
    if (!this.b) {
      throw new ExecutionException(new Exception("delivery failed"));
    }
    return (V)this.a;
  }
  
  public final void a()
  {
    this.a = null;
    this.b = false;
    this.c.countDown();
  }
  
  public final void a(V paramV)
  {
    this.a = paramV;
    this.b = true;
    this.c.countDown();
  }
  
  public final boolean cancel(boolean paramBoolean)
  {
    return false;
  }
  
  public final V get()
  {
    this.c.await();
    return (V)b();
  }
  
  public final V get(long paramLong, TimeUnit paramTimeUnit)
  {
    if (!this.c.await(paramLong, paramTimeUnit)) {
      throw new TimeoutException();
    }
    return (V)b();
  }
  
  public final boolean isCancelled()
  {
    return false;
  }
  
  public final boolean isDone()
  {
    return this.c.getCount() == 0L;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */