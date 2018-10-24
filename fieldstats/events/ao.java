package com.whatsapp.fieldstats.events;

import com.whatsapp.fieldstats.d;
import com.whatsapp.fieldstats.e;
import com.whatsapp.fieldstats.g;

public final class ao
  extends e
{
  public Integer a;
  public Integer b;
  public Integer c;
  public Integer d;
  public String e;
  public Boolean f;
  public String g;
  public Double h;
  public Double i;
  public Double j;
  public Double k;
  
  public ao()
  {
    super(482);
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
      paramg.a(7, this.f);
      paramg.a(8, this.g);
      paramg.a(9, this.h);
      paramg.a(10, this.i);
      paramg.a(11, this.j);
      paramg.a(12, this.k);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/events/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */