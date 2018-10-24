package com.whatsapp.jobqueue.job;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.whatsapp.data.ad;
import com.whatsapp.data.cj;
import com.whatsapp.data.co;
import com.whatsapp.jobqueue.requirement.ChatConnectionRequirement;
import com.whatsapp.messaging.bw;
import com.whatsapp.messaging.m;
import com.whatsapp.protocol.v;
import com.whatsapp.util.Log;
import java.util.Collection;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import org.whispersystems.jobqueue.Job;
import org.whispersystems.jobqueue.JobParameters;
import org.whispersystems.jobqueue.JobParameters.a;
import org.whispersystems.jobqueue.a.b;

public class GetStatusPrivacyJob
  extends Job
  implements b
{
  private transient ad a;
  private transient m b;
  private transient co f;
  
  public GetStatusPrivacyJob()
  {
    super(JobParameters.a().a("GetStatusPrivacyJob").a().a(new ChatConnectionRequirement()).b());
  }
  
  private String g()
  {
    return "; persistentId=" + f();
  }
  
  public final void a() {}
  
  public final void a(Context paramContext)
  {
    this.a = ad.a();
    this.b = m.a();
    this.f = co.a();
  }
  
  public final boolean a(Exception paramException)
  {
    Log.c("exception while running get status privacy job" + g(), paramException);
    return true;
  }
  
  public final void b()
  {
    final AtomicInteger localAtomicInteger = new AtomicInteger();
    String str = this.b.f();
    this.b.a(str, Message.obtain(null, 0, 121, 0, new bw(str, new v()
    {
      public final void a(int paramAnonymousInt)
      {
        if (paramAnonymousInt != 404) {
          Log.e("error in response while running get status privacy job" + GetStatusPrivacyJob.b(GetStatusPrivacyJob.this) + "; code=" + paramAnonymousInt);
        }
        for (;;)
        {
          localAtomicInteger.set(paramAnonymousInt);
          return;
          Log.i("get status privacy job response is 'no settings found on server'" + GetStatusPrivacyJob.b(GetStatusPrivacyJob.this));
        }
      }
      
      public final void a(int paramAnonymousInt, Collection<String> paramAnonymousCollection1, Collection<String> paramAnonymousCollection2)
      {
        Object localObject2 = new StringBuilder("get status privacy job response statusDistributionMode=").append(paramAnonymousInt).append("; whiteList=");
        Object localObject1;
        if (paramAnonymousCollection1 == null)
        {
          localObject1 = "null";
          localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append("; blackList=");
          if (paramAnonymousCollection2 != null) {
            break label155;
          }
          localObject1 = "null";
          label50:
          Log.i((String)localObject1);
          if (!GetStatusPrivacyJob.a(GetStatusPrivacyJob.this).b())
          {
            Log.i("save status privacy");
            localObject1 = GetStatusPrivacyJob.a(GetStatusPrivacyJob.this);
            ((co)localObject1).b.a("status_distribution", paramAnonymousInt);
            localObject2 = ((co)localObject1).b;
            if (paramAnonymousCollection2 != null) {
              break label166;
            }
            paramAnonymousCollection2 = "";
            label115:
            ((cj)localObject2).a("status_black_list", paramAnonymousCollection2);
            paramAnonymousCollection2 = ((co)localObject1).b;
            if (paramAnonymousCollection1 != null) {
              break label176;
            }
          }
        }
        label155:
        label166:
        label176:
        for (paramAnonymousCollection1 = "";; paramAnonymousCollection1 = TextUtils.join(",", paramAnonymousCollection1))
        {
          paramAnonymousCollection2.a("status_white_list", paramAnonymousCollection1);
          return;
          localObject1 = TextUtils.join(",", paramAnonymousCollection1);
          break;
          localObject1 = TextUtils.join(",", paramAnonymousCollection2);
          break label50;
          paramAnonymousCollection2 = TextUtils.join(",", paramAnonymousCollection2);
          break label115;
        }
      }
    })), false).get();
    if (localAtomicInteger.get() == 500) {
      throw new Exception("server 500 error during get status privacy job" + g());
    }
  }
  
  public final void c()
  {
    Log.w("canceled get status privacy job" + g());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/job/GetStatusPrivacyJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */