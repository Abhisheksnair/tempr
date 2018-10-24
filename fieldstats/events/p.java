package com.whatsapp.fieldstats.events;

import com.whatsapp.fieldstats.d;
import com.whatsapp.fieldstats.e;
import com.whatsapp.fieldstats.g;

public final class p
  extends e
{
  public Integer a;
  public Boolean b;
  public Boolean c;
  public Boolean d;
  public Boolean e;
  public Boolean f;
  public String g;
  public Long h;
  public Long i;
  public Long j;
  public Double k;
  public Double l;
  public Double m;
  public Double n;
  public Double o;
  public Double p;
  public Double q;
  public Double r;
  public Double s;
  public String t = a.b;
  
  public p()
  {
    super(470);
  }
  
  public final void serialize(d paramd, g paramg)
  {
    if (paramd != null)
    {
      if (!a.a(this.t, a.b)) {
        break label215;
      }
      paramd.a(7);
    }
    for (;;)
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
        paramg.a(9, this.i);
        paramg.a(10, this.j);
        paramg.a(11, this.k);
        paramg.a(12, this.l);
        paramg.a(13, this.m);
        paramg.a(14, this.n);
        paramg.a(15, this.o);
        paramg.a(16, this.p);
        paramg.a(17, this.q);
        paramg.a(18, this.r);
        paramg.a(19, this.s);
      }
      return;
      label215:
      paramd.a(7, this.t);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/events/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */