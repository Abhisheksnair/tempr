package com.whatsapp.contact.sync;

import com.whatsapp.util.m;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class g
{
  private static volatile g a;
  private final AtomicInteger b = new AtomicInteger();
  private final Map<String, m<v>> c = new HashMap();
  
  static g a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new g();
      }
      return a;
    }
    finally {}
  }
  
  final m<v> a(String paramString)
  {
    try
    {
      paramString = (m)this.c.remove(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  final void a(String paramString, m<v> paramm)
  {
    try
    {
      this.c.put(paramString, paramm);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  final String b()
  {
    return Integer.toHexString(this.b.getAndIncrement());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/contact/sync/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */