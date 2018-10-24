package com.whatsapp.jobqueue.job;

import a.a.a.a.a.a.d;
import android.content.Context;
import com.whatsapp.att;
import com.whatsapp.data.l;
import com.whatsapp.jobqueue.requirement.ChatConnectionRequirement;
import com.whatsapp.proto.E2E.Message;
import com.whatsapp.protocol.j.b;
import com.whatsapp.qz;
import com.whatsapp.rg;
import com.whatsapp.rh;
import com.whatsapp.util.Log;
import com.whatsapp.va;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.whispersystems.jobqueue.Job;
import org.whispersystems.jobqueue.JobParameters;
import org.whispersystems.jobqueue.JobParameters.a;
import org.whispersystems.jobqueue.a.b;

public final class SendSenderKeyJob
  extends Job
  implements b
{
  private static final long serialVersionUID = 1L;
  transient va a;
  transient com.whatsapp.a.c b;
  private final long expireTimeMs;
  private transient att f;
  private transient l g;
  final String groupJid;
  private final String groupMessageId;
  private transient rh h;
  private final int retryCount;
  
  public SendSenderKeyJob(String paramString1, String paramString2, long paramLong)
  {
    super(JobParameters.a().a(paramString1).a().a(new ChatConnectionRequirement()).b());
    this.groupJid = ((String)a.d.a(paramString1));
    this.groupMessageId = ((String)a.d.a(paramString2));
    this.retryCount = 0;
    this.expireTimeMs = paramLong;
    if (!qz.e(paramString1)) {
      throw new IllegalArgumentException("groupJid must be a group jid" + g());
    }
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("expireTimeMs must be non-negative" + g());
    }
  }
  
  private String g()
  {
    return "groupJid=" + this.groupJid + "; groupMessageId=" + this.groupMessageId + "; retryCount=" + this.retryCount + "; persistentId=" + f();
  }
  
  public final void a() {}
  
  public final void a(Context paramContext)
  {
    this.a = va.a();
    this.f = att.a();
    this.g = l.a();
    this.b = com.whatsapp.a.c.a();
    this.h = rh.a();
  }
  
  public final boolean a(Exception paramException)
  {
    Log.c("exception while sending sender key" + g(), paramException);
    return true;
  }
  
  public final void b()
  {
    Log.i("starting send sender key job" + g());
    Object localObject1 = this.g.a(new j.b(this.groupJid, true, this.groupMessageId));
    rg localrg = this.h.a(this.groupJid);
    boolean bool;
    Object localObject2;
    if ((localObject1 != null) && (((com.whatsapp.protocol.j)localObject1).s == 0) && (localrg.d.equals(((com.whatsapp.protocol.j)localObject1).g)))
    {
      bool = true;
      localObject1 = (E2E.Message)com.whatsapp.a.c.a.submit(j.a(this, bool, (com.whatsapp.protocol.j)localObject1)).get();
      localObject2 = localrg.a(this.a);
      if (this.expireTimeMs <= 0L) {
        break label220;
      }
    }
    label220:
    for (long l = this.expireTimeMs;; l = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a() + 86400000L)
    {
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        this.f.a(new SendE2EMessageJob((E2E.Message)localObject1, this.groupMessageId, this.groupJid, str, this.retryCount, null, null, null, false, l, 0L, 0, 0, null, false));
      }
      bool = false;
      break;
    }
    this.h.a(localrg);
  }
  
  public final void c() {}
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/job/SendSenderKeyJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */