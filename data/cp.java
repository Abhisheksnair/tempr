package com.whatsapp.data;

import java.util.List;
import java.util.Map;

public final class cp
{
  public final List<Long> a;
  public final Map<Long, Integer> b;
  
  private cp(List<Long> paramList, Map<Long, Integer> paramMap)
  {
    this.a = paramList;
    this.b = paramMap;
  }
  
  public final boolean a()
  {
    return (!this.a.isEmpty()) || (!this.b.isEmpty());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/cp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */