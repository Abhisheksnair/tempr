package com.whatsapp.jobqueue.job;

import a.a.a.a.a.a.d;
import android.content.Context;
import android.os.Message;
import com.whatsapp.att;
import com.whatsapp.auj;
import com.whatsapp.jobqueue.requirement.ChatConnectionRequirement;
import com.whatsapp.messaging.m;
import com.whatsapp.messaging.m.b;
import com.whatsapp.util.Log;
import java.util.concurrent.Future;
import org.whispersystems.jobqueue.Job;
import org.whispersystems.jobqueue.JobParameters;
import org.whispersystems.jobqueue.JobParameters.a;
import org.whispersystems.jobqueue.a.b;

public final class SendWebForwardJob
  extends Job
  implements b
{
  private static final String GROUP_ID = "webSend";
  private static final long serialVersionUID = 1L;
  private final transient String a;
  private final transient String b;
  private final transient Message f;
  private transient att g;
  private transient m h;
  
  public SendWebForwardJob(String paramString, Message paramMessage)
  {
    super(JobParameters.a().a("webSend").a(new ChatConnectionRequirement()).b());
    this.a = ((String)a.d.a(paramString));
    this.f = ((Message)a.d.a(paramMessage));
    this.b = auj.a;
  }
  
  public final void a()
  {
    Log.d("job/sendWebForward/onAdded id=" + this.a);
  }
  
  public final void a(Context paramContext)
  {
    this.g = att.a();
    this.h = m.a();
  }
  
  public final boolean a(Exception paramException)
  {
    Log.c("job/sendWebForward exception; id=" + this.a + "; ref=" + this.b, paramException);
    if ((paramException instanceof m.b)) {}
    while ((this.b != null) && (!auj.a(this.b))) {
      return false;
    }
    return true;
  }
  
  public final void b()
  {
    Log.i("job/sendWebForward/onRun id=" + this.a + "; ref=" + this.b);
    Future localFuture = this.h.a(this.a, this.f, true);
    this.g.a(new AckWebForwardJob(this.a, this.b, this.f, localFuture));
  }
  
  public final void c() {}
  
  final class AckWebForwardJob
    extends Job
    implements b
  {
    private static final String GROUP_ID = "webAck";
    private static final long serialVersionUID = 1L;
    private final transient String a;
    private final transient String b;
    private final transient Message f;
    private final transient Future<Void> g;
    private transient att h;
    
    public AckWebForwardJob(String paramString, Message paramMessage, Future<Void> paramFuture)
    {
      super();
      this.a = paramString;
      this.f = paramFuture;
      this.b = paramMessage;
      Future localFuture;
      this.g = localFuture;
    }
    
    public final void a()
    {
      Log.d("job/ackWebFwd/onAdd id=" + this.a + "; ref=" + this.b);
    }
    
    public final void a(Context paramContext)
    {
      this.h = att.a();
    }
    
    public final boolean a(Exception paramException)
    {
      return false;
    }
    
    public final void b()
    {
      Log.d("job/ackWebFwd/onRun/block id=" + this.a + "; ref=" + this.b);
      this.g.get();
      Log.d("job/ackWebFwd/onRun/unblock id=" + this.a + "; ref=" + this.b);
    }
    
    public final void c()
    {
      if ((this.b == null) || (auj.a(this.b)))
      {
        Log.d("job/ackWebFwd/cancel/retry id=" + this.a + "; ref=" + this.b);
        this.h.a(new SendWebForwardJob(this.a, this.f));
        return;
      }
      Log.d("job/ackWebFwd/cancel/drop id=" + this.a + "; oldRef=" + this.b + "; currRef=" + auj.a);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/job/SendWebForwardJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */