package com.whatsapp.jobqueue.job;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.whatsapp.auj;
import com.whatsapp.jobqueue.requirement.ChatConnectionRequirement;
import com.whatsapp.messaging.m;
import com.whatsapp.protocol.ak;
import com.whatsapp.protocol.y;
import com.whatsapp.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import org.whispersystems.jobqueue.Job;
import org.whispersystems.jobqueue.JobParameters;
import org.whispersystems.jobqueue.JobParameters.a;
import org.whispersystems.jobqueue.a.b;

public class SendStatusPrivacyJob
  extends Job
  implements b
{
  private static volatile long lastJobId = 0L;
  private static final long serialVersionUID = 1L;
  private transient m a;
  private final Collection<String> jids;
  private final int statusDistribution;
  private final String webId;
  
  public SendStatusPrivacyJob(int paramInt, Collection<String> paramCollection)
  {
    this(paramInt, paramCollection, null);
  }
  
  public SendStatusPrivacyJob(int paramInt, Collection<String> paramCollection, String paramString)
  {
    super(JobParameters.a().a("SendStatusPrivacyJob").a().a(new ChatConnectionRequirement()).b());
    this.statusDistribution = paramInt;
    this.jids = paramCollection;
    this.webId = paramString;
  }
  
  private String g()
  {
    StringBuilder localStringBuilder = new StringBuilder("; statusDistribution=").append(this.statusDistribution).append("; jids=");
    if (this.jids == null) {}
    for (String str = "null";; str = Arrays.toString(this.jids.toArray())) {
      return str + "; persistentId=" + f();
    }
  }
  
  public final void a() {}
  
  public final void a(long paramLong)
  {
    super.a(paramLong);
    lastJobId = paramLong;
    Log.i("set persistent id for send status privacy job" + g());
  }
  
  public final void a(Context paramContext)
  {
    this.a = m.a();
  }
  
  public final boolean a(Exception paramException)
  {
    Log.c("exception while running send status privacy job" + g(), paramException);
    return true;
  }
  
  public final void b()
  {
    if (lastJobId != f()) {
      Log.i("skip send status privacy job" + g() + "; lastJobId=" + lastJobId);
    }
    int i;
    do
    {
      return;
      Log.i("run send status privacy job" + g());
      final AtomicInteger localAtomicInteger = new AtomicInteger();
      if (this.webId != null) {}
      for (String str = this.webId;; str = this.a.f())
      {
        m localm = this.a;
        i = this.statusDistribution;
        Collection localCollection = this.jids;
        Message localMessage = Message.obtain(null, 0, 120, 0, new y()
        {
          public final void a(int paramAnonymousInt)
          {
            localAtomicInteger.set(paramAnonymousInt);
            if (SendStatusPrivacyJob.a(SendStatusPrivacyJob.this) != null) {
              auj.b(SendStatusPrivacyJob.a(SendStatusPrivacyJob.this), paramAnonymousInt);
            }
          }
          
          public final void a(ak paramAnonymousak, String paramAnonymousString)
          {
            if (SendStatusPrivacyJob.a(SendStatusPrivacyJob.this) != null) {
              auj.b(SendStatusPrivacyJob.a(SendStatusPrivacyJob.this), 200);
            }
          }
        });
        Bundle localBundle = localMessage.getData();
        localBundle.putString("id", str);
        localBundle.putInt("statusDistributionMode", i);
        if (localCollection != null) {
          localBundle.putStringArray("jids", (String[])localCollection.toArray(new String[localCollection.size()]));
        }
        localm.a(str, localMessage, false).get();
        i = localAtomicInteger.get();
        if (i != 500) {
          break;
        }
        throw new Exception("server 500 error during send status privacy job" + g());
      }
    } while (i == 0);
    Log.w("server error code returned during send status privacy job; errorCode=" + i + g());
  }
  
  public final void c()
  {
    Log.w("canceled send status privacy job" + g());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/job/SendStatusPrivacyJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */