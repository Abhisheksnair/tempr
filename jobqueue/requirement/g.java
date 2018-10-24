package com.whatsapp.jobqueue.requirement;

import b.a.a.c;
import com.whatsapp.g.n;
import org.whispersystems.jobqueue.requirements.a;
import org.whispersystems.jobqueue.requirements.b;

public final class g
  implements b
{
  private a a;
  
  public g()
  {
    c.a().a(this, false);
  }
  
  public final void a(a parama)
  {
    this.a = parama;
  }
  
  public final void onEvent(n paramn)
  {
    if (this.a != null) {
      this.a.a();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/requirement/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */