package com.whatsapp.fieldstats.events;

import com.whatsapp.fieldstats.d;
import com.whatsapp.fieldstats.e;
import com.whatsapp.fieldstats.g;

public final class bm
  extends e
{
  public Long a;
  public Integer b;
  public Long c;
  public Integer d;
  public Integer e;
  
  public bm()
  {
    super(1176);
  }
  
  public final void serialize(d paramd, g paramg)
  {
    if (paramg != null)
    {
      paramg.a(1, this.a);
      paramg.a(2, this.b);
      paramg.a(5, this.c);
      paramg.a(3, this.d);
      paramg.a(4, this.e);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/events/bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */