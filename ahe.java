package com.whatsapp;

import com.whatsapp.fieldstats.events.g;
import com.whatsapp.fieldstats.l;

public final class ahe
{
  public static final String a = System.getProperty("os.arch");
  
  public static void a(String paramString)
  {
    if (!av.i()) {
      return;
    }
    g localg = new g();
    localg.b = Integer.valueOf(0);
    localg.a = a;
    localg.c = paramString;
    l.a(u.a(), localg);
  }
  
  public static void b(String paramString)
  {
    if (!av.i()) {
      return;
    }
    g localg = new g();
    localg.b = Integer.valueOf(1);
    localg.a = a;
    localg.c = paramString;
    l.a(u.a(), localg);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ahe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */