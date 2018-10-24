package com.whatsapp;

import com.whatsapp.data.ad;
import com.whatsapp.data.ad.b;
import com.whatsapp.data.ad.d;
import com.whatsapp.data.ad.o;
import com.whatsapp.data.by;
import com.whatsapp.data.bz;
import com.whatsapp.data.d;
import com.whatsapp.data.l;
import com.whatsapp.messaging.aj;
import com.whatsapp.notification.f;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import java.util.concurrent.ConcurrentHashMap;

public class ka
{
  private static volatile ka b;
  final hx a;
  private final pv c;
  private final aj d;
  private final l e;
  
  private ka(pv parampv, aj paramaj, l paraml, hx paramhx)
  {
    this.c = parampv;
    this.d = paramaj;
    this.e = paraml;
    this.a = paramhx;
  }
  
  public static ka a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new ka(pv.a(), aj.a(), l.a(), hx.a());
      }
      return b;
    }
    finally {}
  }
  
  public final void a(ad paramad, f paramf, String paramString)
  {
    a(paramad, paramf, paramString, true, null, null);
  }
  
  public final void a(ad paramad, f paramf, String paramString, boolean paramBoolean, j.b paramb, Integer paramInteger)
  {
    Object localObject = null;
    StringBuilder localStringBuilder = null;
    ad.o localo = paramad.p(paramString);
    int i;
    if ((localo.a != 0) || (localo.b != 0))
    {
      if (paramInteger != null) {
        break label160;
      }
      paramb = null;
      i = 0;
      if (i == 0) {
        paramf.a(paramString);
      }
      if (i != 0) {
        break label366;
      }
    }
    label160:
    label322:
    label366:
    for (paramInteger = null;; paramInteger = paramb)
    {
      paramf.b(paramString, paramInteger);
      paramInteger = (ad.d)paramad.n.a.get(paramString);
      if (paramInteger != null) {
        break label373;
      }
      paramf = new StringBuilder("msgstore/setchatseen/nochat/").append(paramString).append("/");
      paramad = localStringBuilder;
      if (paramb != null) {
        paramad = paramb.e;
      }
      Log.i(paramad);
      this.c.a(kb.a(this, paramString), 300L);
      if (paramBoolean) {
        this.d.a(paramString, true);
      }
      do
      {
        return;
        localj = paramad.r(paramString);
        if (((localj != null) && (localj.e.equals(paramb))) || ((localo.a == -1) && (paramInteger.intValue() == -1)))
        {
          paramb = null;
          i = 0;
          break;
        }
        if (localo.a <= 0) {
          break label322;
        }
      } while (paramInteger.intValue() == -1);
      j localj = this.e.a(paramb);
      if ((localj != null) && (localo.a >= paramInteger.intValue()))
      {
        i = localo.a - paramInteger.intValue();
        paramb = localj;
        break;
      }
      Log.e("app/setConversationSeen/qr/invalid  " + paramb + " local=" + localo.a + " req=" + paramInteger);
      return;
      Log.e("app/setConversationSeen/qr/invalid  " + paramb + " local=" + localo.a + " req=" + paramInteger);
      return;
    }
    label373:
    localStringBuilder = new StringBuilder("msgstore/setchatseen/").append(paramString).append("/").append(paramInteger.b()).append("/");
    paramf = (f)localObject;
    if (paramb != null) {
      paramf = paramb.e;
    }
    Log.i(paramf + "/" + i);
    if (paramb == null) {}
    for (int j = 0;; j = paramad.c(paramb.e.a, paramb.Q))
    {
      boolean bool = paramInteger.a(i, 0, j);
      long l2 = ad.e(paramb);
      long l3 = paramInteger.c;
      long l1 = l2;
      if (l2 == 1L) {
        l1 = Math.max(paramInteger.q, paramInteger.a);
      }
      if ((l3 >= l1) && (!bool) && (paramInteger.q != 0L)) {
        break;
      }
      paramInteger.c = l1;
      paramad.d.post(bz.a(paramad, l1, paramInteger, paramString));
      break;
    }
  }
  
  public final void a(ad paramad, String paramString, boolean paramBoolean)
  {
    ad.d locald = (ad.d)paramad.n.a.get(paramString);
    if (locald == null) {
      Log.i("msgstore/setchatunseen/nochat/" + paramString);
    }
    for (;;)
    {
      this.a.a(paramString);
      if (paramBoolean) {
        this.d.a(paramString, false);
      }
      return;
      Log.i("msgstore/setchatunseen/" + paramString + "/" + locald.b());
      locald.a(-1, 0, 0);
      paramad.d.post(by.a(paramad, locald, paramString));
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */