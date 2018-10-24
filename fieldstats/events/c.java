package com.whatsapp.fieldstats.events;

import com.whatsapp.fieldstats.d;
import com.whatsapp.fieldstats.e;
import com.whatsapp.fieldstats.g;

public final class c
  extends e
{
  public Double a;
  public Boolean b;
  public Boolean c;
  public Boolean d;
  public Double e;
  public Boolean f;
  public Long g;
  public Long h;
  public Long i;
  public Boolean j;
  public Boolean k;
  public Double l;
  public String m;
  public String n;
  public String o;
  
  public c()
  {
    super(980);
  }
  
  public final void serialize(d paramd, g paramg)
  {
    if (paramg != null)
    {
      paramg.a(1, this.a);
      paramg.a(2, this.b);
      paramg.a(3, this.c);
      paramg.a(4, this.d);
      paramg.a(5, this.e);
      paramg.a(6, this.f);
      paramg.a(7, this.g);
      paramg.a(8, this.h);
      paramg.a(15, this.i);
      paramg.a(9, this.j);
      paramg.a(10, this.k);
      paramg.a(11, this.l);
      paramg.a(12, this.m);
      paramg.a(13, this.n);
      paramg.a(14, this.o);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/events/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */