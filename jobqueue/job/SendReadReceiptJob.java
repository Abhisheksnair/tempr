package com.whatsapp.jobqueue.job;

import a.a.a.a.a.a.d;
import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.whatsapp.ado;
import com.whatsapp.adp;
import com.whatsapp.ant;
import com.whatsapp.jobqueue.requirement.ChatConnectionRequirement;
import com.whatsapp.messaging.m;
import com.whatsapp.protocol.al;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import java.util.Arrays;
import java.util.concurrent.Future;
import org.whispersystems.jobqueue.Job;
import org.whispersystems.jobqueue.JobParameters;
import org.whispersystems.jobqueue.JobParameters.a;
import org.whispersystems.jobqueue.a.b;

public final class SendReadReceiptJob
  extends Job
  implements b
{
  private static final long serialVersionUID = 1L;
  private transient ant a;
  private transient adp b;
  private transient m f;
  private final String jid;
  private final String[] messageIds;
  private final long originalMessageTimestamp;
  private final String participant;
  
  public SendReadReceiptJob(String paramString1, String paramString2, String[] paramArrayOfString, long paramLong)
  {
    super(JobParameters.a().a("read-receipt-" + paramString1).a().a(new ChatConnectionRequirement()).b());
    this.jid = ((String)a.d.a(paramString1));
    paramString1 = paramString2;
    if (TextUtils.isEmpty(paramString2)) {
      paramString1 = null;
    }
    this.participant = paramString1;
    this.messageIds = ((String[])a.d.a(paramArrayOfString));
    this.originalMessageTimestamp = paramLong;
  }
  
  private String g()
  {
    return "; jid=" + this.jid + "; participant=" + this.participant + "; ids:" + Arrays.deepToString(this.messageIds);
  }
  
  public final void a() {}
  
  public final void a(Context paramContext)
  {
    this.a = ant.a();
    this.b = adp.a();
    this.f = m.a();
  }
  
  public final boolean a(Exception paramException)
  {
    Log.c("exception while running sent read receipts job" + g(), paramException);
    return true;
  }
  
  public final void b()
  {
    if (!this.b.a(this.jid)) {}
    while ((j.c(this.jid)) && (this.originalMessageTimestamp > 0L) && (this.originalMessageTimestamp + 86400000L < this.a.b())) {
      return;
    }
    ado localado = new ado();
    localado.a = new j.b(this.jid, false, this.messageIds[0]);
    localado.b = this.participant;
    if (j.c(this.participant))
    {
      Log.w("send-read-job/malformed participant flipping");
      localado.a = new j.b(this.participant, false, this.messageIds[0]);
      localado.b = this.jid;
    }
    if (this.messageIds.length > 1)
    {
      localado.c = new String[this.messageIds.length - 1];
      System.arraycopy(this.messageIds, 1, localado.c, 0, localado.c.length);
    }
    al localal = new al();
    String str1;
    int i;
    if (TextUtils.isEmpty(localado.b))
    {
      str1 = null;
      if ((!j.b(str1)) || (j.c(str1))) {
        break label310;
      }
      i = 1;
      label223:
      if (i == 0) {
        break label315;
      }
    }
    label310:
    label315:
    for (String str2 = str1;; str2 = this.jid)
    {
      localal.a = str2;
      localal.b = "receipt";
      localal.d = "read";
      localal.c = this.messageIds[0];
      if (i != 0) {
        str1 = this.jid;
      }
      localal.e = str1;
      this.f.a(localal, Message.obtain(null, 0, 89, 0, localado)).get();
      return;
      str1 = localado.b;
      break;
      i = 0;
      break label223;
    }
  }
  
  public final void c()
  {
    Log.w("canceled sent read receipts job" + g());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/job/SendReadReceiptJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */