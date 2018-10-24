package com.whatsapp.fieldstats.events;

import com.whatsapp.fieldstats.d;
import com.whatsapp.fieldstats.e;
import com.whatsapp.fieldstats.g;

public final class v
  extends e
{
  public Long a;
  
  public v()
  {
    super(1136);
  }
  
  public final void serialize(d paramd, g paramg)
  {
    if (paramg != null) {
      paramg.a(1, this.a);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/events/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */