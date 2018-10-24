package com.whatsapp.fieldstats.events;

import com.whatsapp.fieldstats.d;
import com.whatsapp.fieldstats.e;
import com.whatsapp.fieldstats.g;

public final class o
  extends e
{
  public String a;
  public Boolean b;
  public Boolean c;
  public Long d;
  public Boolean e;
  public Boolean f;
  public Boolean g;
  public Long h;
  public Boolean i;
  public Boolean j;
  public Long k;
  public Long l;
  
  public o()
  {
    super(1006);
  }
  
  public final void serialize(d paramd, g paramg)
  {
    if (paramg != null)
    {
      paramg.a(1, this.a);
      paramg.a(2, this.b);
      paramg.a(3, this.c);
      paramg.a(4, this.d);
      paramg.a(12, this.e);
      paramg.a(5, this.f);
      paramg.a(6, this.g);
      paramg.a(7, this.h);
      paramg.a(8, this.i);
      paramg.a(9, this.j);
      paramg.a(10, this.k);
      paramg.a(11, this.l);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/events/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */