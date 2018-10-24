package com.whatsapp.fieldstats.events;

import com.whatsapp.fieldstats.d;
import com.whatsapp.fieldstats.e;
import com.whatsapp.fieldstats.g;

public final class au
  extends e
{
  public String a;
  public Long b;
  public Long c;
  public Boolean d;
  public Long e;
  public Long f;
  public Boolean g;
  public Long h;
  public Long i;
  public Integer j;
  
  public au()
  {
    super(1140);
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


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/events/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */