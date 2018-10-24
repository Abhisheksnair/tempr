package com.whatsapp.fieldstats.events;

import com.whatsapp.fieldstats.d;
import com.whatsapp.fieldstats.e;

public final class g
  extends e
{
  public String a;
  public Integer b;
  public String c;
  
  public g()
  {
    super(1020);
  }
  
  public final void serialize(d paramd, com.whatsapp.fieldstats.g paramg)
  {
    if (paramg != null)
    {
      paramg.a(1, this.a);
      paramg.a(2, this.b);
      paramg.a(3, this.c);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/events/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */