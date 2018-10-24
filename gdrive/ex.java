package com.whatsapp.gdrive;

import android.content.Context;
import com.whatsapp.fieldstats.events.as;
import com.whatsapp.fieldstats.l;

final class ex
{
  private static final int[] a = { 0, 10749, 20160, 31502, 47894, 70482, 95632, 123443, 157025, 220063 };
  private final as[] b = new as[a.length];
  
  public ex()
  {
    int i = 0;
    long l = 10L;
    while (i < this.b.length)
    {
      as localas = new as();
      localas.a = Long.valueOf(l);
      localas.b = Long.valueOf(0L);
      localas.c = Long.valueOf(0L);
      this.b[i] = localas;
      l += 10L;
      i += 1;
    }
  }
  
  public final void a(long paramLong)
  {
    int i = a.length - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (a[i] <= paramLong)
        {
          as localas = this.b[i];
          localas.b = Long.valueOf(localas.b.longValue() + 1L);
        }
      }
      else {
        return;
      }
      i -= 1;
    }
  }
  
  public final void a(Context paramContext)
  {
    as[] arrayOfas = this.b;
    int j = arrayOfas.length;
    int i = 0;
    while (i < j)
    {
      as localas = arrayOfas[i];
      if (localas.c.longValue() != 0L) {
        l.a(paramContext, localas);
      }
      i += 1;
    }
  }
  
  public final void b(long paramLong)
  {
    int i = a.length - 1;
    for (;;)
    {
      if (i >= 0)
      {
        if (a[i] <= paramLong)
        {
          as localas = this.b[i];
          localas.c = Long.valueOf(localas.c.longValue() + 1L);
        }
      }
      else {
        return;
      }
      i -= 1;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gdrive/ex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */