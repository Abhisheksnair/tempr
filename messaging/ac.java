package com.whatsapp.messaging;

import a.a.a.a.d;
import com.whatsapp.a.c;
import com.whatsapp.att;
import com.whatsapp.data.ad;
import com.whatsapp.data.ad.b;
import com.whatsapp.data.bl;
import com.whatsapp.jobqueue.job.SendRetryReceiptJob;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;

public final class ac
  implements Runnable
{
  private final w a;
  private final att b;
  private final ad c;
  private final j d;
  private final int e;
  private final boolean f;
  
  public ac(w paramw, att paramatt, ad paramad, c paramc, j paramj, boolean paramBoolean)
  {
    this.a = paramw;
    this.b = paramatt;
    this.c = paramad;
    this.d = paramj;
    this.e = paramc.i();
    this.f = paramBoolean;
  }
  
  public final void run()
  {
    Log.i("need to send retry receipt; message.key=" + this.d.e);
    byte[] arrayOfByte = d.g(this.e);
    if (this.d.l > 1) {
      this.a.e();
    }
    Object localObject1;
    Object localObject2;
    if (this.d.ab == 0)
    {
      Log.i("recording local placeholder for retry receipt; message.key=" + this.d.e);
      localObject1 = this.c;
      localObject2 = this.d;
      ((ad)localObject1).d.post(new bl((ad)localObject1, (j)localObject2));
    }
    Log.i("axolotl sending retry receipt; message.key=" + this.d.e + "; localRegistrationId=" + this.e);
    if (!this.f)
    {
      localObject1 = this.a;
      localObject2 = this.d.e;
      String str = this.d.f;
      long l = this.d.n;
      int i = this.d.l;
      int j = this.d.ab;
      if (((w)localObject1).b.d) {
        ((w)localObject1).b.a(d.a((j.b)localObject2, str, l, i + 1, arrayOfByte, j));
      }
      return;
    }
    this.b.a(new SendRetryReceiptJob(this.d, this.e));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */