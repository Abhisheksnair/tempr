package com.whatsapp.jobqueue.job;

import a.a.a.a.a.a.d;
import android.content.Context;
import android.os.Message;
import com.whatsapp.a.c;
import com.whatsapp.att;
import com.whatsapp.jobqueue.requirement.AxolotlDifferentAliceBaseKeyRequirement;
import com.whatsapp.jobqueue.requirement.AxolotlSessionRequirement;
import com.whatsapp.jobqueue.requirement.ChatConnectionRequirement;
import com.whatsapp.location.bp;
import com.whatsapp.messaging.bz;
import com.whatsapp.messaging.m;
import com.whatsapp.proto.E2E.Message;
import com.whatsapp.protocol.al;
import com.whatsapp.protocol.f;
import com.whatsapp.util.Log;
import com.whatsapp.va;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.whispersystems.jobqueue.Job;
import org.whispersystems.jobqueue.JobParameters;
import org.whispersystems.jobqueue.JobParameters.a;
import org.whispersystems.jobqueue.a.b;
import org.whispersystems.jobqueue.requirements.Requirement;

public final class SendLiveLocationKeyJob
  extends Job
  implements b
{
  private static final Random random = new Random();
  private static final long serialVersionUID = 1L;
  transient va a;
  transient c b;
  private transient att f;
  private transient m g;
  private transient bp h;
  private final ArrayList<String> jids;
  private final Integer retryCount;
  
  public SendLiveLocationKeyJob(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    super(locala.a("SendLiveLocationKeyJob").a().a(new ChatConnectionRequirement()).b());
    a.d.a(paramString);
    if (paramInt < 0) {
      throw new IllegalArgumentException("retryCount cannot be negative" + g());
    }
    this.jids = new ArrayList();
    this.jids.add(paramString);
    this.retryCount = Integer.valueOf(paramInt);
  }
  
  public SendLiveLocationKeyJob(List<String> paramList)
  {
    super(a(paramList));
    a.d.a(paramList);
    this.jids = new ArrayList(paramList);
    this.retryCount = null;
  }
  
  private static JobParameters a(List<String> paramList)
  {
    JobParameters.a locala = JobParameters.a();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      locala.a(new AxolotlSessionRequirement((String)paramList.next()));
    }
    return locala.a("SendLiveLocationKeyJob").a().a(new ChatConnectionRequirement()).b();
  }
  
  private String g()
  {
    return "; persistentId=" + f() + "; jids.size()=" + this.jids.size() + "; retryCount=" + this.retryCount;
  }
  
  public final void a()
  {
    Log.i("live location key notification send job added" + g());
    Object localObject2 = new HashSet();
    Iterator localIterator = e().iterator();
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      Object localObject3 = (Requirement)localIterator.next();
      if ((localObject3 instanceof AxolotlSessionRequirement))
      {
        localObject3 = (AxolotlSessionRequirement)localObject3;
        if (!((AxolotlSessionRequirement)localObject3).a()) {
          ((Set)localObject2).add(((AxolotlSessionRequirement)localObject3).jid);
        }
      }
      else
      {
        if (!(localObject3 instanceof AxolotlDifferentAliceBaseKeyRequirement)) {
          break label232;
        }
        localObject3 = (AxolotlDifferentAliceBaseKeyRequirement)localObject3;
        if (((AxolotlDifferentAliceBaseKeyRequirement)localObject3).a()) {
          break label232;
        }
        localObject1 = ((AxolotlDifferentAliceBaseKeyRequirement)localObject3).jid;
        localObject3 = ((AxolotlDifferentAliceBaseKeyRequirement)localObject3).oldAliceBaseKey;
        ((Set)localObject2).add(localObject1);
        localObject1 = android.support.v4.f.h.a(localObject1, localObject3);
      }
    }
    label232:
    for (;;)
    {
      break;
      if (localObject1 != null) {
        this.f.a(new GetPreKeyJob((String)((android.support.v4.f.h)localObject1).a, (byte[])((android.support.v4.f.h)localObject1).b));
      }
      for (;;)
      {
        return;
        localObject1 = ((Set)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          this.f.a(new GetPreKeyJob((String)localObject2, null));
        }
      }
    }
  }
  
  public final void a(Context paramContext)
  {
    this.a = va.a();
    this.f = att.a();
    this.g = m.a();
    this.b = c.a();
    this.h = bp.a();
  }
  
  public final boolean a(Exception paramException)
  {
    Log.c("exception while running send live location key job" + g(), paramException);
    return true;
  }
  
  public final void b()
  {
    if (this.retryCount != null) {}
    for (List localList = this.h.b((String)this.jids.get(0), this.retryCount.intValue()); localList.isEmpty(); localList = this.h.a(this.jids))
    {
      Log.i("skip send live location key job; no one to send" + g());
      return;
    }
    Log.i("run send live location key job" + g());
    Object localObject2;
    try
    {
      Object localObject1 = ((E2E.Message)c.a.submit(h.a(this)).get()).toByteArray();
      i = random.nextInt(16) + 1;
      localObject2 = new byte[localObject1.length + i];
      System.arraycopy(localObject1, 0, localObject2, 0, localObject1.length);
      Arrays.fill((byte[])localObject2, localObject1.length, localObject2.length, (byte)i);
      localObject1 = new HashMap();
      localObject3 = localList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        ((Map)localObject1).put(localObject4, (f)c.a.submit(i.a(this, (String)localObject4, (byte[])localObject2)).get());
      }
      localObject2 = this.g.f();
    }
    catch (Exception localException)
    {
      this.h.b(localList);
      throw localException;
    }
    Object localObject3 = new al();
    ((al)localObject3).b = "notification";
    ((al)localObject3).d = "location";
    ((al)localObject3).a = "location@broadcast";
    ((al)localObject3).c = ((String)localObject2);
    Object localObject4 = this.g;
    if (this.retryCount == null) {}
    for (int i = 0;; i = this.retryCount.intValue())
    {
      ((m)localObject4).a((al)localObject3, Message.obtain(null, 0, 123, 0, new bz((String)localObject2, localException, i))).get();
      Log.i("sent location key distribution notifications" + g());
      this.h.a(localList);
      return;
    }
  }
  
  public final void c()
  {
    Log.w("canceled send live location key job" + g());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/job/SendLiveLocationKeyJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */