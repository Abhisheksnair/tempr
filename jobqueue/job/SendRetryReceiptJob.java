package com.whatsapp.jobqueue.job;

import a.a.a.a.a.f;
import a.a.a.a.d;
import android.content.Context;
import android.text.TextUtils;
import com.whatsapp.jobqueue.requirement.ChatConnectionRequirement;
import com.whatsapp.messaging.m;
import com.whatsapp.protocol.al;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import java.util.concurrent.Future;
import org.whispersystems.jobqueue.Job;
import org.whispersystems.jobqueue.JobParameters;
import org.whispersystems.jobqueue.JobParameters.a;
import org.whispersystems.jobqueue.a.b;

public final class SendRetryReceiptJob
  extends Job
  implements b
{
  private static final long serialVersionUID = 1L;
  private transient m a;
  private final int editVersion;
  private final String id;
  private final String jid;
  private final int localRegistrationId;
  private final String participant;
  private final int retryCount;
  private final long timestamp;
  
  public SendRetryReceiptJob(j paramj, int paramInt)
  {
    super(JobParameters.a().a("retry-receipt-" + paramj.e.a).a().a(new ChatConnectionRequirement()).b());
    this.jid = ((String)f.a(paramj.e.a));
    this.id = ((String)f.a(paramj.e.c));
    if (TextUtils.isEmpty(paramj.f)) {}
    for (String str = null;; str = paramj.f)
    {
      this.participant = str;
      this.timestamp = paramj.n;
      this.retryCount = paramj.l;
      this.localRegistrationId = paramInt;
      this.editVersion = paramj.ab;
      return;
    }
  }
  
  private String g()
  {
    return "; jid=" + this.jid + "; id=" + this.id + "; participant=" + this.participant + "; retryCount=" + this.retryCount + "; editVersion=" + this.editVersion;
  }
  
  public final void a() {}
  
  public final void a(Context paramContext)
  {
    this.a = m.a();
  }
  
  public final boolean a(Exception paramException)
  {
    Log.c("exception while running sent persistent retry job" + g(), paramException);
    return true;
  }
  
  public final void b()
  {
    j.b localb = new j.b(this.jid, false, this.id);
    byte[] arrayOfByte = d.g(this.localRegistrationId);
    al localal = new al();
    String str1;
    boolean bool;
    if (TextUtils.isEmpty(this.participant))
    {
      str1 = null;
      bool = j.b(str1);
      if (!bool) {
        break label171;
      }
    }
    label171:
    for (String str2 = str1;; str2 = this.jid)
    {
      localal.a = str2;
      localal.b = "receipt";
      localal.d = "retry";
      localal.c = this.id;
      if (this.editVersion != 0) {
        localal.f = String.valueOf(this.editVersion);
      }
      if (bool) {
        str1 = this.jid;
      }
      localal.e = str1;
      this.a.a(localal, d.a(localb, this.participant, this.timestamp, this.retryCount + 1, arrayOfByte, this.editVersion)).get();
      return;
      str1 = this.participant;
      break;
    }
  }
  
  public final void c()
  {
    Log.w("canceled sent read receipts job" + g());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/job/SendRetryReceiptJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */