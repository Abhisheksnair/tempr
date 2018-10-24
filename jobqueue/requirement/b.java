package com.whatsapp.jobqueue.requirement;

import b.a.a.c;
import org.whispersystems.jobqueue.requirements.a;

public final class b
  implements org.whispersystems.jobqueue.requirements.b
{
  private a a;
  
  public b()
  {
    c.a().a(this, false);
  }
  
  public final void a(a parama)
  {
    this.a = parama;
  }
  
  public final void onEvent(com.whatsapp.g.b paramb)
  {
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/requirement/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */