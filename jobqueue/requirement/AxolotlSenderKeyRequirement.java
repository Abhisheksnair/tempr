package com.whatsapp.jobqueue.requirement;

import a.a.a.a.a.a.d;
import android.content.Context;
import com.whatsapp.a.c;
import com.whatsapp.qz;
import com.whatsapp.rg;
import com.whatsapp.rh;
import com.whatsapp.va;
import java.util.Set;
import org.whispersystems.a.c.b.d;
import org.whispersystems.a.c.b.f;
import org.whispersystems.a.c.e;
import org.whispersystems.a.m;
import org.whispersystems.jobqueue.a.b;
import org.whispersystems.jobqueue.requirements.Requirement;

public final class AxolotlSenderKeyRequirement
  implements b, Requirement
{
  private static final long serialVersionUID = 1L;
  private transient va a;
  private transient c b;
  private transient rh c;
  private final String groupJid;
  
  public AxolotlSenderKeyRequirement(String paramString)
  {
    this.groupJid = ((String)a.d.a(paramString));
    if (!qz.e(paramString)) {
      throw new IllegalArgumentException("groupJid is not a group jid; groupJid=" + paramString);
    }
  }
  
  public final void a(Context paramContext)
  {
    this.a = va.a();
    this.b = c.a();
    this.c = rh.a();
  }
  
  public final boolean a()
  {
    f localf = this.b.d;
    m localm = c.a(this.a.b() + "@s.whatsapp.net");
    return (!localf.a(new e(this.groupJid, localm)).a()) && (this.c.a(this.groupJid).a(this.a).isEmpty());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/requirement/AxolotlSenderKeyRequirement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */