package com.whatsapp.memory.dump.a;

import java.util.Arrays;

public class g
{
  private int[] b;
  
  static
  {
    if (!g.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public final int a(f paramf)
  {
    return this.b[paramf.j];
  }
  
  public final void a(int paramInt)
  {
    int k = 0;
    int i = 0;
    int j = -1;
    while (i < f.values().length)
    {
      j = Math.max(f.values()[i].j, j);
      i += 1;
    }
    if ((!a) && ((j <= 0) || (j > f.i.j))) {
      throw new AssertionError();
    }
    this.b = new int[j + 1];
    Arrays.fill(this.b, -1);
    i = k;
    while (i < f.values().length)
    {
      this.b[f.values()[i].j] = f.values()[i].k;
      i += 1;
    }
    this.b[f.a.j] = paramInt;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/memory/dump/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */