package com.whatsapp.fieldstats.events;

import com.whatsapp.fieldstats.d;
import com.whatsapp.fieldstats.e;
import com.whatsapp.fieldstats.g;

public final class bv
  extends e
{
  public Long a;
  public Double b;
  public Long c;
  public Long d;
  public Integer e;
  public Double f;
  public Integer g;
  public Integer h;
  public Integer i;
  
  public bv()
  {
    super(1012);
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
      paramg.a(9, this.i);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/events/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */