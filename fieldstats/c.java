package com.whatsapp.fieldstats;

import android.annotation.SuppressLint;
import java.util.HashMap;
import java.util.Map;

final class c
  extends i
{
  @SuppressLint({"UseSparseArrays"})
  final Map<Integer, a> a = new HashMap();
  
  public final void a()
  {
    super.a();
    this.a.clear();
  }
  
  public final void a(int paramInt, a parama)
  {
    super.a(0, paramInt, parama.a);
    this.a.put(Integer.valueOf(paramInt), parama);
  }
  
  public final boolean a(int paramInt)
  {
    return this.a.containsKey(Integer.valueOf(paramInt));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */