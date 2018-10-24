package com.whatsapp.fieldstats;

import android.annotation.SuppressLint;
import java.util.HashMap;
import java.util.Map;

final class b
{
  private static final a b = new a(null);
  @SuppressLint({"UseSparseArrays"})
  final Map<Integer, a> a = new HashMap();
  
  final a a(int paramInt)
  {
    if (!this.a.containsKey(Integer.valueOf(paramInt))) {
      return b;
    }
    return (a)this.a.get(Integer.valueOf(paramInt));
  }
  
  public final void a()
  {
    this.a.clear();
  }
  
  final void a(int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      this.a.remove(Integer.valueOf(paramInt));
    }
    do
    {
      return;
      paramObject = new a(paramObject);
    } while ((this.a.containsKey(Integer.valueOf(paramInt))) && (((a)this.a.get(Integer.valueOf(paramInt))).equals(paramObject)));
    this.a.put(Integer.valueOf(paramInt), paramObject);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */