package com.whatsapp.jobqueue.requirement;

import a.a.a.a.a.a.d;
import android.content.Context;
import com.whatsapp.data.e;
import com.whatsapp.jobqueue.job.GetVNameCertificateJob;
import com.whatsapp.util.Log;
import java.util.Map;
import org.whispersystems.jobqueue.a.b;
import org.whispersystems.jobqueue.requirements.Requirement;

public final class VNameCertificateRequirement
  implements b, Requirement
{
  private static final long MAX_RESPONSE_AGE = 3600000L;
  private static final long serialVersionUID = 1L;
  private transient e a;
  public final String jid;
  
  public VNameCertificateRequirement(String paramString)
  {
    this.jid = ((String)a.d.a(paramString));
  }
  
  private String c()
  {
    return "; jid=" + this.jid;
  }
  
  public final void a(Context paramContext)
  {
    this.a = e.a();
  }
  
  public final boolean a()
  {
    Object localObject = this.a;
    String str = this.jid;
    localObject = (Long)((e)localObject).c.get(str);
    if (localObject != null) {}
    for (long l = ((Long)localObject).longValue(); (l > 0L) && (System.currentTimeMillis() - l < 3600000L); l = 0L)
    {
      Log.d("satisfying vname requirement due to recent response" + c());
      return true;
    }
    if (!GetVNameCertificateJob.a(this.jid))
    {
      Log.d("satisfying vname requirement because there is no scheduled job that could satisfy it" + c());
      return true;
    }
    return b();
  }
  
  public final boolean b()
  {
    return this.a.j(this.jid) != null;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/requirement/VNameCertificateRequirement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */