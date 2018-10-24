package com.whatsapp.fieldstats.events;

import com.whatsapp.fieldstats.d;
import com.whatsapp.fieldstats.e;
import com.whatsapp.fieldstats.g;

public final class k
  extends e
{
  public Integer a;
  public Boolean b;
  public Long c;
  public Long d;
  public Boolean e;
  public Long f;
  public Integer g;
  public Double h;
  public Double i;
  public Double j;
  public Double k;
  public Double l;
  public Double m;
  public Double n;
  public Double o;
  public Long p;
  public Integer q = a.c;
  public Integer r = a.c;
  
  public k()
  {
    super(484);
  }
  
  public final void serialize(d paramd, g paramg)
  {
    if (paramd != null)
    {
      if (!a.a(this.q, a.c)) {
        break label208;
      }
      paramd.a(647);
      if (!a.a(this.r, a.c)) {
        break label224;
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
        paramg.a(16, this.p);
      }
      return;
      label208:
      paramd.a(647, this.q);
      break;
      label224:
      paramd.a(345, this.r);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/events/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */