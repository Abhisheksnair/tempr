package com.whatsapp.data;

import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  private static final d b = new d();
  public final ConcurrentHashMap<String, ad.d> a = new ConcurrentHashMap();
  
  public static d a()
  {
    return b;
  }
  
  public final boolean a(String paramString)
  {
    return this.a.containsKey(paramString);
  }
  
  public final long b(String paramString)
  {
    paramString = (ad.d)this.a.get(paramString);
    if (paramString == null) {
      return 0L;
    }
    return paramString.f;
  }
  
  public final int c(String paramString)
  {
    paramString = (ad.d)this.a.get(paramString);
    if (paramString == null) {
      return 0;
    }
    return paramString.g;
  }
  
  public final boolean d(String paramString)
  {
    paramString = (ad.d)this.a.get(paramString);
    return (paramString != null) && (paramString.e);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */