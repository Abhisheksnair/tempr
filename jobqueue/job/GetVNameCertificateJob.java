package com.whatsapp.jobqueue.job;

import a.a.a.a.a.a.d;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.whatsapp.att;
import com.whatsapp.data.cs;
import com.whatsapp.jobqueue.requirement.AxolotlSessionRequirement;
import com.whatsapp.jobqueue.requirement.ChatConnectionRequirement;
import com.whatsapp.messaging.m;
import com.whatsapp.qz;
import com.whatsapp.util.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import org.whispersystems.jobqueue.Job;
import org.whispersystems.jobqueue.JobParameters;
import org.whispersystems.jobqueue.JobParameters.a;
import org.whispersystems.jobqueue.a.b;
import org.whispersystems.jobqueue.requirements.Requirement;

public class GetVNameCertificateJob
  extends Job
  implements b
{
  private static final ConcurrentHashMap<String, Boolean> certificatesBeingRequested = new ConcurrentHashMap();
  private static final long serialVersionUID = 1L;
  private transient att a;
  private transient m b;
  private final String jid;
  
  public GetVNameCertificateJob(String paramString)
  {
    super(JobParameters.a().a(paramString).a().a(new ChatConnectionRequirement()).a(new AxolotlSessionRequirement(paramString)).b());
    this.jid = ((String)a.d.a(paramString));
    if ((qz.e(paramString)) || (cs.e(paramString))) {
      throw new IllegalArgumentException("jid must be an individual jid; jid=" + paramString);
    }
  }
  
  public static boolean a(String paramString)
  {
    return certificatesBeingRequested.containsKey(paramString);
  }
  
  private String g()
  {
    return "; jid=" + this.jid + "; persistentId=" + f();
  }
  
  public final void a()
  {
    Log.i("get vname certificate job added" + g());
    certificatesBeingRequested.put(this.jid, Boolean.TRUE);
    Iterator localIterator = e().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Requirement)localIterator.next();
      if ((localObject instanceof AxolotlSessionRequirement))
      {
        localObject = (AxolotlSessionRequirement)localObject;
        if (!((AxolotlSessionRequirement)localObject).a()) {
          this.a.a(new GetPreKeyJob(((AxolotlSessionRequirement)localObject).jid, null));
        }
      }
    }
  }
  
  public final void a(Context paramContext)
  {
    this.a = att.a();
    this.b = m.a();
  }
  
  public final boolean a(Exception paramException)
  {
    Log.c("exception while running get vname certificate job" + g(), paramException);
    return true;
  }
  
  public final void b()
  {
    int j = 0;
    int i = j;
    try
    {
      Log.i("starting get vname certificate job" + g());
      i = j;
      String str1 = this.b.f();
      i = j;
      m localm = this.b;
      i = j;
      String str2 = this.jid;
      i = j;
      Message localMessage = Message.obtain(null, 0, 118, 0);
      i = j;
      Bundle localBundle = localMessage.getData();
      i = j;
      localBundle.putString("id", str1);
      i = j;
      localBundle.putString("jid", str2);
      i = j;
      localm.a(str1, localMessage, false).get();
      certificatesBeingRequested.remove(this.jid);
      return;
    }
    catch (Exception localException)
    {
      i = 1;
      throw localException;
    }
    finally
    {
      if (i == 0) {
        certificatesBeingRequested.remove(this.jid);
      }
    }
  }
  
  public final void c()
  {
    Log.w("canceled get vname certificate job" + g());
    certificatesBeingRequested.remove(this.jid);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/job/GetVNameCertificateJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */