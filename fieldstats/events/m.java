package com.whatsapp.fieldstats.events;

import com.whatsapp.fieldstats.d;
import com.whatsapp.fieldstats.e;
import com.whatsapp.fieldstats.g;

public final class m
  extends e
{
  public Boolean a;
  public Long b;
  public Boolean c;
  public Boolean d;
  public Boolean e;
  public Boolean f;
  public Boolean g;
  public Boolean h;
  public Boolean i;
  public Long j;
  
  public m()
  {
    super(932);
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
      paramg.a(10, this.j);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/events/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */