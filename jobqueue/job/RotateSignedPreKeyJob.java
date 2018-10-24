package com.whatsapp.jobqueue.job;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.whatsapp.abp;
import com.whatsapp.jobqueue.requirement.ChatConnectionRequirement;
import com.whatsapp.messaging.ParcelablePreKey;
import com.whatsapp.messaging.m;
import com.whatsapp.protocol.aj;
import com.whatsapp.protocol.ak;
import com.whatsapp.protocol.y;
import com.whatsapp.util.Log;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.whispersystems.jobqueue.Job;
import org.whispersystems.jobqueue.JobParameters;
import org.whispersystems.jobqueue.JobParameters.a;

public final class RotateSignedPreKeyJob
  extends Job
  implements org.whispersystems.jobqueue.a.b
{
  private static final long serialVersionUID = 1L;
  transient abp a;
  transient com.whatsapp.a.c b;
  private final byte[] data;
  private transient m f;
  private final byte[] id;
  private final byte[] signature;
  
  public RotateSignedPreKeyJob(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    super(JobParameters.a().a("RotateSignedPreKeyJob").a().a(new ChatConnectionRequirement()).b());
    this.id = a.d.a(paramArrayOfByte1);
    this.data = a.d.a(paramArrayOfByte2);
    this.signature = a.d.a(paramArrayOfByte3);
    if (paramArrayOfByte1.length != 3) {
      throw new IllegalArgumentException("invalid signed pre-key id length: " + paramArrayOfByte1.length);
    }
    if (paramArrayOfByte2.length != 32) {
      throw new IllegalArgumentException("invalid signed pre-key length: " + paramArrayOfByte2.length);
    }
    if (paramArrayOfByte3.length != 64) {
      throw new IllegalArgumentException("invalid signed pre-key signature length: " + paramArrayOfByte3.length);
    }
  }
  
  private String g()
  {
    return "; signedPreKeyId=" + d.e(this.id) + "; persistentId=" + f();
  }
  
  public final void a()
  {
    Log.i("rotate signed pre key job added" + g());
  }
  
  public final void a(Context paramContext)
  {
    this.f = m.a();
    this.a = abp.a();
    this.b = com.whatsapp.a.c.a();
  }
  
  public final boolean a(Exception paramException)
  {
    Log.c("exception while running rotate signed pre key job" + g(), paramException);
    return true;
  }
  
  public final void b()
  {
    Log.i("starting rotate signed pre key job" + g());
    Object localObject = (aj)com.whatsapp.a.c.a.submit(a.a(this)).get();
    if (!Arrays.equals(this.id, ((aj)localObject).a)) {
      Log.w("aborting rotate signed pre key job due to id mismatch with latest" + g());
    }
    int i;
    do
    {
      do
      {
        return;
        localObject = this.f.f();
        final AtomicInteger localAtomicInteger = new AtomicInteger();
        final AtomicReference localAtomicReference = new AtomicReference();
        m localm = this.f;
        aj localaj = new aj(this.id, this.data, this.signature);
        Message localMessage = Message.obtain(null, 0, 86, 0, new y()
        {
          public final void a(ak paramAnonymousak)
          {
            paramAnonymousak = ak.a(paramAnonymousak.e("error"));
            int i = paramAnonymousak.a("code", 0);
            localAtomicInteger.set(i);
            paramAnonymousak = paramAnonymousak.e("identity");
            if (paramAnonymousak != null) {
              localAtomicReference.set(paramAnonymousak.d);
            }
          }
          
          public final void a(ak paramAnonymousak, String paramAnonymousString)
          {
            com.whatsapp.a.c.a.submit(c.a(this));
          }
        });
        localMessage.getData().putString("iqId", (String)localObject);
        localMessage.getData().putParcelable("signedPreKey", new ParcelablePreKey(localaj));
        localm.a((String)localObject, localMessage, false).get();
        i = localAtomicInteger.get();
        if (i == 503) {
          throw new Exception("server 503 error during rotate signed pre key job" + g());
        }
        if (i != 409) {
          break;
        }
        Log.w("server error code returned during rotate signed pre key job; errorCode=" + i + g());
        localObject = (byte[])localAtomicReference.get();
      } while (localObject == null);
      com.whatsapp.a.c.a.submit(b.a(this, (byte[])localObject));
      return;
    } while (i == 0);
    Log.w("server error code returned during rotate signed pre key job; errorCode=" + i + g());
  }
  
  public final void c()
  {
    Log.w("canceled rotate signed pre key job" + g());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/job/RotateSignedPreKeyJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */