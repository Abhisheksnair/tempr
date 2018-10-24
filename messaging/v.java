package com.whatsapp.messaging;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import b.a.a.c;
import com.whatsapp.att;
import com.whatsapp.data.cs;
import com.whatsapp.jobqueue.job.SendE2EMessageJob;
import com.whatsapp.proto.E2E.Message;
import com.whatsapp.proto.E2E.Message.a;
import com.whatsapp.protocol.af;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.j.c;
import com.whatsapp.protocol.m;
import com.whatsapp.qz;
import com.whatsapp.util.Log;
import com.whatsapp.va;

final class v
  implements Runnable
{
  private final com.whatsapp.protocol.j a;
  private final boolean b;
  private final long c;
  private final va d;
  private final att e;
  private final af f;
  
  public v(va paramva, att paramatt, af paramaf, com.whatsapp.protocol.j paramj, boolean paramBoolean, long paramLong)
  {
    this.d = paramva;
    this.e = paramatt;
    this.f = paramaf;
    this.a = ((com.whatsapp.protocol.j)a.d.a(paramj));
    a.d.a(paramj.e);
    this.b = paramBoolean;
    this.c = paramLong;
  }
  
  public final void run()
  {
    a.d.a(this.a.e.a);
    this.a.i = null;
    this.a.j = null;
    long l1 = ((com.whatsapp.g.j)c.a().a(com.whatsapp.g.j.class)).a();
    boolean bool1 = qz.e(this.a.e.a);
    boolean bool2 = cs.e(this.a.e.a);
    boolean bool3 = SendE2EMessageJob.a(this.a.e, this.a.ab);
    if ((this.b) && (bool3)) {
      return;
    }
    if (this.b) {
      Log.w("recreating e2e message job because it's not in the scheduled list; message.key=" + this.a.e + " edit=" + this.a.ab);
    }
    att localatt = null;
    Object localObject1 = localatt;
    if (m.d(this.a))
    {
      localObject1 = localatt;
      if (this.a.w > 0) {
        localObject1 = Integer.valueOf(this.a.w);
      }
    }
    Object localObject2 = E2E.Message.newBuilder();
    this.f.a(this.a);
    d.a(this.d, this.a, (E2E.Message.a)localObject2, false, false, false);
    localatt = this.e;
    localObject2 = ((E2E.Message.a)localObject2).build();
    String str1 = this.a.e.c;
    String str2 = this.a.e.a;
    int i = this.a.l;
    String str3 = this.a.g;
    j.c localc = this.a.M;
    long l2;
    int j;
    int k;
    if ((bool2) || (bool1))
    {
      bool1 = true;
      l2 = this.c;
      j = this.a.i();
      k = this.a.ab;
      if (this.a.s != 15) {
        break label391;
      }
    }
    label391:
    for (bool2 = true;; bool2 = false)
    {
      localatt.a(new SendE2EMessageJob((E2E.Message)localObject2, str1, str2, null, i, str3, localc, null, bool1, l1 + 86400000L, l2, j, k, (Integer)localObject1, bool2));
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */