package com.whatsapp.gcm.a;

import android.content.Context;
import com.whatsapp.fieldstats.events.c;
import com.whatsapp.fieldstats.l;

public final class h
{
  private static final com.whatsapp.k.h a = new com.whatsapp.k.h(1, 100);
  private static final com.whatsapp.k.h b = new com.whatsapp.k.h(100, 1000);
  
  public static void a(Context paramContext, long paramLong, int paramInt)
  {
    if (b.a(1))
    {
      c localc = new c();
      localc.i = Long.valueOf(paramInt);
      localc.a = Double.valueOf(paramLong);
      localc.j = Boolean.valueOf(true);
      l.a(paramContext, localc, b.b(1));
    }
  }
  
  public static void a(Context paramContext, a.a parama, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (a.a(1))
    {
      c localc = new c();
      localc.j = Boolean.valueOf(true);
      localc.a = Double.valueOf(parama.a);
      localc.c = Boolean.valueOf(parama.c);
      localc.d = Boolean.valueOf(parama.d);
      localc.b = Boolean.valueOf(parama.b);
      localc.f = Boolean.valueOf(parama.f);
      localc.g = Long.valueOf(parama.g);
      localc.h = Long.valueOf(parama.h);
      localc.e = Double.valueOf(parama.e);
      localc.k = Boolean.valueOf(parama.i);
      localc.l = Double.valueOf(parama.j);
      localc.i = Long.valueOf(paramInt);
      localc.m = paramString1;
      localc.n = paramString2;
      localc.o = paramString3;
      l.a(paramContext, localc, a.b(1));
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gcm/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */