package com.whatsapp.util;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class z<K, V>
  extends LinkedHashMap<K, V>
{
  private int a;
  
  public z(int paramInt)
  {
    super((int)Math.ceil(paramInt / 0.75F) + 1, 0.75F, true);
    this.a = paramInt;
  }
  
  protected final boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    return size() > this.a;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */