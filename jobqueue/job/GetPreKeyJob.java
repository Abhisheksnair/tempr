package com.whatsapp.jobqueue.job;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.content.Context;
import com.whatsapp.a.c;
import com.whatsapp.data.cs;
import com.whatsapp.jobqueue.requirement.ChatConnectionRequirement;
import com.whatsapp.qz;
import com.whatsapp.util.Log;
import java.util.Arrays;
import java.util.concurrent.Future;
import org.whispersystems.a.h.e;
import org.whispersystems.a.h.f;
import org.whispersystems.jobqueue.Job;
import org.whispersystems.jobqueue.JobParameters;
import org.whispersystems.jobqueue.JobParameters.a;
import org.whispersystems.jobqueue.a.b;

public final class GetPreKeyJob
  extends Job
  implements b
{
  private static final long serialVersionUID = 1L;
  private transient com.whatsapp.messaging.m a;
  private transient c b;
  private final String jid;
  private final byte[] oldAliceBaseKey;
  
  public GetPreKeyJob(String paramString, byte[] paramArrayOfByte)
  {
    super(JobParameters.a().a(paramString).a().a(new ChatConnectionRequirement()).b());
    this.jid = ((String)a.d.a(paramString));
    this.oldAliceBaseKey = paramArrayOfByte;
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length == 0)) {
      throw new IllegalArgumentException("oldAliceBaseKey must either be null or non-empty");
    }
    if ((qz.e(paramString)) || (cs.e(paramString))) {
      throw new IllegalArgumentException("jid must be an individual jid; jid=" + paramString);
    }
  }
  
  private String g()
  {
    StringBuilder localStringBuilder = new StringBuilder("; jid=").append(this.jid).append("; oldAliceBaseKey.nil?=");
    if (this.oldAliceBaseKey == null) {}
    for (boolean bool = true;; bool = false) {
      return bool + "; persistentId=" + f();
    }
  }
  
  public final void a()
  {
    Log.i("get pre key job added" + g());
  }
  
  public final void a(Context paramContext)
  {
    this.a = com.whatsapp.messaging.m.a();
    this.b = c.a();
  }
  
  public final boolean a(Exception paramException)
  {
    Log.c("exception while running get pre key job" + g(), paramException);
    return true;
  }
  
  public final void b()
  {
    Log.i("starting get pre key job" + g());
    if (this.oldAliceBaseKey != null)
    {
      localObject = c.a(this.jid);
      if (!Arrays.equals(this.b.c((org.whispersystems.a.m)localObject).a().a(), this.oldAliceBaseKey))
      {
        Log.i("exiting get pre key job early becase old alice base key has already changed" + g());
        return;
      }
    }
    Object localObject = this.a.f();
    this.a.a((String)localObject, d.a((String)localObject, new String[] { this.jid }), false).get();
  }
  
  public final void c()
  {
    Log.w("canceled get pre key job" + g());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/job/GetPreKeyJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */