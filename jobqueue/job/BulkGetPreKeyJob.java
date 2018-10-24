package com.whatsapp.jobqueue.job;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.content.Context;
import android.text.TextUtils;
import com.whatsapp.data.cs;
import com.whatsapp.jobqueue.requirement.ChatConnectionRequirement;
import com.whatsapp.messaging.m;
import com.whatsapp.qz;
import com.whatsapp.util.Log;
import java.util.Arrays;
import java.util.concurrent.Future;
import org.whispersystems.jobqueue.Job;
import org.whispersystems.jobqueue.JobParameters;
import org.whispersystems.jobqueue.JobParameters.a;
import org.whispersystems.jobqueue.a.b;

public final class BulkGetPreKeyJob
  extends Job
  implements b
{
  private static final long serialVersionUID = 1L;
  private transient m a;
  private final String groupJid;
  private final String[] jids;
  
  public BulkGetPreKeyJob(String paramString, String[] paramArrayOfString)
  {
    super(JobParameters.a().a(paramString).a().a(new ChatConnectionRequirement()).b());
    this.groupJid = ((String)a.d.a(paramString));
    this.jids = ((String[])a.d.a(paramArrayOfString));
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramArrayOfString[i];
      if (TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("an element of jids was empty");
      }
      if ((qz.e(paramString)) || (cs.e(paramString))) {
        throw new IllegalArgumentException("jid must be an individual jid; jid=" + paramString);
      }
      i += 1;
    }
  }
  
  private String g()
  {
    return "; groupJid=" + this.groupJid + "; jids=" + Arrays.toString(this.jids);
  }
  
  public final void a()
  {
    Log.i("bulk get pre key job added" + g());
  }
  
  public final void a(Context paramContext)
  {
    this.a = m.a();
  }
  
  public final boolean a(Exception paramException)
  {
    Log.c("exception while running bulk get pre key job" + g(), paramException);
    return true;
  }
  
  public final void b()
  {
    Log.i("starting bulk get pre key job" + g());
    String str = this.a.f();
    this.a.a(str, d.a(str, this.jids), false).get();
  }
  
  public final void c()
  {
    Log.w("canceled bulk get pre key job" + g());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/job/BulkGetPreKeyJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */