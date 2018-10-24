package com.whatsapp.util;

import java.lang.ref.WeakReference;

public abstract class bs<T>
{
  private final ThreadLocal<WeakReference<T>> a = new ThreadLocal() {};
  
  protected abstract T a();
  
  public final T b()
  {
    try
    {
      Object localObject3 = ((WeakReference)this.a.get()).get();
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = a();
        this.a.set(new WeakReference(localObject1));
      }
      return (T)localObject1;
    }
    finally {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */