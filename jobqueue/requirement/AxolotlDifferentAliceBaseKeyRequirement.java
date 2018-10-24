package com.whatsapp.jobqueue.requirement;

import a.a.a.a.a.a.d;
import android.content.Context;
import com.whatsapp.a.c;
import com.whatsapp.data.cs;
import com.whatsapp.qz;
import java.util.Arrays;
import org.whispersystems.a.h.e;
import org.whispersystems.a.h.f;
import org.whispersystems.a.m;
import org.whispersystems.jobqueue.a.b;
import org.whispersystems.jobqueue.requirements.Requirement;

public final class AxolotlDifferentAliceBaseKeyRequirement
  implements b, Requirement
{
  private static final long serialVersionUID = 1L;
  private transient c a;
  public final String jid;
  public final byte[] oldAliceBaseKey;
  
  public AxolotlDifferentAliceBaseKeyRequirement(String paramString, byte[] paramArrayOfByte)
  {
    this.jid = ((String)a.d.a(paramString));
    this.oldAliceBaseKey = a.d.a(paramArrayOfByte);
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
    Object localObject = c.a(this.jid);
    localObject = this.a.c((m)localObject);
    return !Arrays.equals(this.oldAliceBaseKey, ((e)localObject).a().a());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/requirement/AxolotlDifferentAliceBaseKeyRequirement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */