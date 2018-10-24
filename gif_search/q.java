package com.whatsapp.gif_search;

import android.support.v4.f.f;
import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadPoolExecutor;

public final class q<K, V>
  extends f<K, V>
{
  WeakReference<a> a;
  
  public q(int paramInt)
  {
    super(paramInt);
  }
  
  protected final void a(boolean paramBoolean, K paramK, V paramV1, V paramV2)
  {
    super.a(paramBoolean, paramK, paramV1, paramV2);
    if (this.a != null)
    {
      paramK = (a)this.a.get();
      if (paramK != null)
      {
        paramK = paramK.a;
        paramV1 = (GifCacheItemSerializable)paramV1;
        if (paramV1 != null) {
          paramK.c().execute(e.a(paramV1));
        }
      }
    }
  }
  
  static final class a<K, V>
  {
    final b a;
    
    a(b paramb)
    {
      this.a = paramb;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gif_search/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */