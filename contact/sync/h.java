package com.whatsapp.contact.sync;

import com.whatsapp.fieldstats.events.o;
import com.whatsapp.fieldstats.l;
import com.whatsapp.u;

public final class h
{
  private static final com.whatsapp.k.h a = new com.whatsapp.k.h(20, 100);
  
  public static o a(t paramt)
  {
    o localo = new o();
    localo.a = paramt.a.toString();
    localo.b = Boolean.valueOf(paramt.a.a());
    if (paramt.a.h == q.c) {}
    for (boolean bool = true;; bool = false)
    {
      localo.c = Boolean.valueOf(bool);
      localo.d = Long.valueOf(paramt.a.j);
      localo.f = Boolean.valueOf(paramt.b);
      localo.g = Boolean.valueOf(paramt.e);
      localo.h = Long.valueOf(paramt.j);
      localo.i = Boolean.valueOf(paramt.b());
      return localo;
    }
  }
  
  public static void a(o paramo)
  {
    if (a.a(1))
    {
      paramo.j = Boolean.valueOf(true);
      l.a(u.a(), paramo, a.b(1));
    }
  }
  
  public static void b(o paramo)
  {
    if (a.a(10))
    {
      paramo.j = Boolean.valueOf(true);
      paramo.e = Boolean.valueOf(true);
      l.a(u.a(), paramo, a.b(10));
    }
  }
  
  public static void c(o paramo)
  {
    if (a.a(1))
    {
      paramo.j = Boolean.valueOf(false);
      l.a(u.a(), paramo, a.b(1));
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/contact/sync/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */