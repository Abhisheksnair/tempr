package com.whatsapp.jobqueue.requirement;

import b.a.a.c;
import com.whatsapp.g.i;
import org.whispersystems.jobqueue.requirements.a;
import org.whispersystems.jobqueue.requirements.b;

public final class d
  implements b
{
  private a a;
  
  public d()
  {
    c.a().a(this, false);
  }
  
  public final void a(a parama)
  {
    this.a = parama;
  }
  
  public final void onEvent(i parami)
  {
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/requirement/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */