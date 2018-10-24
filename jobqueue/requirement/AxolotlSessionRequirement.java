package com.whatsapp.jobqueue.requirement;

import a.a.a.a.a.a.d;
import android.content.Context;
import com.whatsapp.a.c;
import com.whatsapp.data.cs;
import com.whatsapp.qz;
import org.whispersystems.jobqueue.a.b;
import org.whispersystems.jobqueue.requirements.Requirement;

public final class AxolotlSessionRequirement
  implements b, Requirement
{
  private static final long serialVersionUID = 1L;
  private transient c a;
  public final String jid;
  
  public AxolotlSessionRequirement(String paramString)
  {
    this.jid = ((String)a.d.a(paramString));
    if ((qz.e(paramString)) || (cs.e(paramString))) {
      throw new IllegalArgumentException("jid must be an individual jid; jid=" + paramString);
    }
  }
  
  public final void a(Context paramContext)
  {
    this.a = c.a();
  }
  
  public final boolean a()
  {
    return this.a.d(c.a(this.jid));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/requirement/AxolotlSessionRequirement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */