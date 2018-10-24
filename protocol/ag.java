package com.whatsapp.protocol;

import com.whatsapp.data.cl;

public class ag
{
  private static volatile ag a;
  private final cl b;
  
  private ag(cl paramcl)
  {
    this.b = paramcl;
  }
  
  public static ag a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ag(cl.a());
      }
      return a;
    }
    finally {}
  }
  
  public final void a(j paramj)
  {
    try
    {
      if (paramj.g() != null) {
        a(paramj.g());
      }
      for (paramj = paramj.V; paramj != null; paramj = paramj.V) {
        if (paramj.g() != null) {
          paramj.g().b = true;
        }
      }
      return;
    }
    finally {}
  }
  
  public final void a(k paramk)
  {
    try
    {
      j localj = paramk.a;
      if (!paramk.b) {
        paramk.b(this.b.a(localj.e));
      }
      return;
    }
    finally
    {
      paramk = finally;
      throw paramk;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */