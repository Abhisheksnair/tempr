package com.whatsapp.fieldstats.events;

import com.whatsapp.fieldstats.d;
import com.whatsapp.fieldstats.e;
import com.whatsapp.fieldstats.g;

public final class aw
  extends e
{
  public Double a;
  public Double b;
  public Double c;
  public Double d;
  public String e;
  public Double f;
  public Boolean g;
  public Double h;
  
  public aw()
  {
    super(1336);
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
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/events/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */