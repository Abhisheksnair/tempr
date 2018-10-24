package com.whatsapp.jobqueue.requirement;

import b.a.a.c;
import org.whispersystems.jobqueue.requirements.b;

public final class a
  implements b
{
  private org.whispersystems.jobqueue.requirements.a a;
  
  public a()
  {
    c.a().a(this, false);
  }
  
  public final void a(org.whispersystems.jobqueue.requirements.a parama)
  {
    this.a = parama;
  }
  
  public final void onEvent(com.whatsapp.g.a parama)
  {
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/requirement/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */