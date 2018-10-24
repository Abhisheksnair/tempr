package com.whatsapp.jobqueue.requirement;

import android.content.Context;
import com.whatsapp.location.bp;
import com.whatsapp.va;
import java.util.List;
import org.whispersystems.a.c.b.a;
import org.whispersystems.a.c.e;
import org.whispersystems.a.m;
import org.whispersystems.jobqueue.a.b;
import org.whispersystems.jobqueue.requirements.Requirement;

public final class AxolotlFastRatchetSenderKeyRequirement
  implements b, Requirement
{
  private static final long serialVersionUID = 1L;
  private transient va a;
  private transient com.whatsapp.a.c b;
  private transient bp c;
  private final String groupJid;
  
  public AxolotlFastRatchetSenderKeyRequirement(String paramString)
  {
    this.groupJid = paramString;
    if (!"location@broadcast".equals(paramString)) {
      throw new IllegalArgumentException("groupJid is not location Jid, only location Jid supported for now; groupJid=" + paramString);
    }
  }
  
  public final void a(Context paramContext)
  {
    this.a = va.a();
    this.b = com.whatsapp.a.c.a();
    this.c = bp.a();
  }
  
  public final boolean a()
  {
    if (!this.c.d()) {}
    m localm;
    do
    {
      return true;
      if (!this.c.k().isEmpty())
      {
        this.c.m();
        return false;
      }
      localm = com.whatsapp.a.c.a(this.a.b() + "@s.whatsapp.net");
    } while (!this.b.f.a(new e("location@broadcast", localm)).a());
    return false;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/requirement/AxolotlFastRatchetSenderKeyRequirement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */