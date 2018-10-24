package com.whatsapp.fieldstats.events;

import com.whatsapp.fieldstats.d;
import com.whatsapp.fieldstats.e;
import com.whatsapp.fieldstats.g;

public final class bi
  extends e
{
  public Integer a;
  public Boolean b;
  public Long c;
  public Long d;
  public Boolean e;
  public Double f;
  public Double g;
  public Double h;
  public Double i;
  public Double j;
  public Double k;
  public Double l;
  public Double m;
  public Long n;
  public Double o;
  public Integer p = a.c;
  public Integer q = a.c;
  
  public bi()
  {
    super(486);
  }
  
  public final void serialize(d paramd, g paramg)
  {
    if (paramd != null)
    {
      if (!a.a(this.p, a.c)) {
        break label198;
      }
      paramd.a(647);
      if (!a.a(this.q, a.c)) {
        break label214;
      }
      paramd.a(345);
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
      }
      return;
      label198:
      paramd.a(647, this.p);
      break;
      label214:
      paramd.a(345, this.q);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/events/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */