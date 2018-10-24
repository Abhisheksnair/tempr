package com.whatsapp.jobqueue.job;

import a.a.a.a.a.a.d;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.whatsapp.jobqueue.requirement.ChatConnectionRequirement;
import com.whatsapp.location.bp;
import com.whatsapp.messaging.m;
import com.whatsapp.protocol.al;
import com.whatsapp.util.Log;
import java.util.concurrent.Future;
import org.whispersystems.jobqueue.Job;
import org.whispersystems.jobqueue.JobParameters;
import org.whispersystems.jobqueue.JobParameters.a;
import org.whispersystems.jobqueue.a.b;

public class SendDisableLiveLocationJob
  extends Job
  implements b
{
  private static final long serialVersionUID = 1L;
  private transient m a;
  private transient bp b;
  private final String jid;
  private final long sequenceNumber;
  
  public SendDisableLiveLocationJob(String paramString, long paramLong)
  {
    super(JobParameters.a().a(paramString).a().a(new ChatConnectionRequirement()).b());
    this.jid = ((String)a.d.a(paramString));
    this.sequenceNumber = paramLong;
  }
  
  private String g()
  {
    return "; jid=" + this.jid + "; persistentId=" + f();
  }
  
  public final void a()
  {
    Log.i("disable live location job added" + g());
  }
  
  public final void a(Context paramContext)
  {
    this.a = m.a();
    this.b = bp.a();
  }
  
  public final boolean a(Exception paramException)
  {
    Log.c("exception while running disable live location job" + g(), paramException);
    return true;
  }
  
  public final void b()
  {
    if (this.b.f(this.jid))
    {
      Log.i("skip disable live location job; sharing is currently enabled" + g());
      return;
    }
    Log.i("starting disable live location job" + g());
    String str1 = this.a.f();
    al localal = new al();
    localal.a = this.jid;
    localal.b = "notification";
    localal.d = "location";
    localal.c = str1;
    m localm = this.a;
    String str2 = this.jid;
    long l = this.sequenceNumber;
    Message localMessage = Message.obtain(null, 0, 81, 0);
    localMessage.getData().putString("id", str1);
    localMessage.getData().putString("jid", str2);
    localMessage.getData().putLong("seq", l);
    localm.a(localal, localMessage).get();
    Log.i("done disable live location job" + g());
  }
  
  public final void c()
  {
    Log.w("canceled disable live location job" + g());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/job/SendDisableLiveLocationJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */