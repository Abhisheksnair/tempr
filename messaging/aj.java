package com.whatsapp.messaging;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.whatsapp.adp;
import com.whatsapp.att;
import com.whatsapp.atv;
import com.whatsapp.auj;
import com.whatsapp.auj.g;
import com.whatsapp.auj.j;
import com.whatsapp.auj.k;
import com.whatsapp.auj.l;
import com.whatsapp.auj.m;
import com.whatsapp.auj.p;
import com.whatsapp.auj.r;
import com.whatsapp.auj.t;
import com.whatsapp.cc;
import com.whatsapp.data.co;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.data.o;
import com.whatsapp.data.o.b;
import com.whatsapp.g.k;
import com.whatsapp.jobqueue.job.SendWebForwardJob;
import com.whatsapp.protocol.af;
import com.whatsapp.protocol.ar;
import com.whatsapp.protocol.av;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.rg;
import com.whatsapp.rh;
import com.whatsapp.rk;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import com.whatsapp.va;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class aj
{
  static o.b i = ;
  static o.b j = aq.a();
  @SuppressLint({"StaticFieldLeak"})
  private static volatile aj k;
  final va a;
  final adp b;
  public final att c;
  public final m d;
  final af e;
  final co f;
  final com.whatsapp.a.c g;
  final o h;
  private final rk l;
  private final atv m;
  
  private aj(va paramva, adp paramadp, att paramatt, m paramm, rk paramrk, af paramaf, co paramco, com.whatsapp.a.c paramc, atv paramatv, o paramo)
  {
    this.a = paramva;
    this.b = paramadp;
    this.c = paramatt;
    this.d = paramm;
    this.l = paramrk;
    this.e = paramaf;
    this.f = paramco;
    this.g = paramc;
    this.m = paramatv;
    this.h = paramo;
  }
  
  public static aj a()
  {
    if (k == null) {}
    try
    {
      if (k == null) {
        k = new aj(va.a(), adp.a(), att.a(), m.a(), rk.a(), af.a(), co.a(), com.whatsapp.a.c.a(), atv.a(), o.a());
      }
      return k;
    }
    finally {}
  }
  
  static List<av> a(List<cs> paramList, List<av> paramList1)
  {
    cc localcc = cc.a();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      cs localcs = (cs)localIterator.next();
      if (!TextUtils.isEmpty(localcs.t))
      {
        av localav = new av();
        localav.d = localcs.t;
        if (localcs.f())
        {
          localav.a = localcs.j();
          localav.r = true;
          if ((!TextUtils.isEmpty(localcs.o)) && (localcs.d != null)) {
            break label189;
          }
        }
        label189:
        for (paramList = null;; paramList = localcs.o)
        {
          localav.b = paramList;
          localav.p = localcs.h;
          localav.f = localcs.q;
          localav.q = localcc.f(localcs.t);
          paramList1.add(localav);
          break;
          if (TextUtils.isEmpty(localcs.e)) {}
          for (paramList = null;; paramList = localcs.e)
          {
            localav.a = paramList;
            break;
          }
        }
      }
    }
    return paramList1;
  }
  
  private void a(com.whatsapp.g.d paramd, k paramk)
  {
    if ((!this.d.d) || (!auj.c())) {}
    do
    {
      double d1;
      do
      {
        return;
        if (paramd == null)
        {
          Log.w("null battery change event; cannot send web battery update");
          return;
        }
        if (paramk == null)
        {
          Log.w("null power save mode event; cannot send web battery update");
          return;
        }
        d1 = paramd.a();
      } while (d1 == NaN.0D);
      paramd = auj.a((int)d1, paramd.b(), paramk.a);
    } while (paramd == null);
    this.d.a(Message.obtain(null, 0, 56, 0, paramd));
  }
  
  public final void a(int paramInt1, String paramString, long paramLong, int paramInt2)
  {
    a(new ar(paramString, paramInt1, paramLong), paramInt2);
  }
  
  public final void a(int paramInt, String paramString1, String paramString2)
  {
    if ((!this.d.d) || (paramString1 == null)) {
      return;
    }
    m localm = this.d;
    Bundle localBundle = new Bundle();
    localBundle.putString("ref", paramString1);
    localBundle.putString("challenge", paramString2);
    localBundle.putInt("reason", paramInt);
    localm.a(Message.obtain(null, 0, 49, 0, localBundle));
  }
  
  public final void a(cs paramcs)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramcs);
    a(localArrayList);
  }
  
  public final void a(e parame, String paramString)
  {
    if (!auj.c()) {}
    do
    {
      return;
      parame = parame.c(paramString);
    } while (parame == null);
    a(parame);
  }
  
  public final void a(ar paramar, int paramInt)
  {
    if (!auj.c()) {
      return;
    }
    paramar.e = paramInt;
    auj.m localm = new auj.m(new auj.k(this, paramar));
    String str = auj.p();
    this.c.a(new SendWebForwardJob(str, Message.obtain(null, 0, 52, 0, new ci(str, paramar, localm))));
  }
  
  public final void a(j.b paramb, int paramInt)
  {
    if (auj.c()) {}
    switch (paramInt)
    {
    default: 
      Log.e("app/xmpp/send/qr_msg_status invalid status");
      return;
    }
    auj.m localm = new auj.m(new auj.p(this, paramb, paramInt));
    String str = auj.p();
    this.c.a(new SendWebForwardJob(str, Message.obtain(null, 0, 47, 0, new ci(str, paramb, paramInt, localm))));
  }
  
  public final void a(j paramj)
  {
    if (!auj.c()) {
      return;
    }
    att localatt = this.c;
    String str1 = paramj.e.c;
    String str2 = paramj.e.c;
    String str3 = paramj.y;
    boolean bool = paramj.e.b;
    String str4 = paramj.e.a;
    paramj = paramj.f;
    Bundle localBundle = new Bundle();
    localBundle.putString("id", str2);
    localBundle.putString("jid", str4);
    localBundle.putBoolean("owner", bool);
    localBundle.putString("participant", paramj);
    localBundle.putString("revokedId", str3);
    localatt.a(new SendWebForwardJob(str1, Message.obtain(null, 0, 128, 0, localBundle)));
  }
  
  public final void a(j paramj, String paramString)
  {
    if ((paramj == null) || (paramString == null) || (!auj.c())) {
      return;
    }
    Object localObject = new auj.m(new auj.t(this, paramj, paramString));
    String str1 = auj.p();
    att localatt = this.c;
    String str2 = paramj.f;
    paramj = paramj.e;
    localObject = new ci(str1, str2, (auj.m)localObject);
    ((ci)localObject).d = paramj;
    ((ci)localObject).c = paramString;
    localatt.a(new SendWebForwardJob(str1, Message.obtain(null, 0, 127, 0, localObject)));
  }
  
  public final void a(rh paramrh, String paramString, boolean paramBoolean)
  {
    if (((!auj.c()) && (!paramBoolean)) || (paramString == null) || (!cs.e(paramString))) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramrh.a(paramString).a());
    paramrh = new auj.m(new auj.g(this, paramrh, paramString, paramBoolean));
    String str = auj.p();
    this.c.a(new SendWebForwardJob(str, Message.obtain(null, 0, 51, 0, new ci(str, paramString, localArrayList, paramrh))));
  }
  
  public final void a(String paramString)
  {
    if ((!this.d.d) || (!auj.c()) || (paramString == null)) {
      return;
    }
    bu.a(al.a(this, paramString));
  }
  
  public final void a(String paramString, int paramInt)
  {
    if ((!this.d.d) || (!auj.c()) || (paramString == null)) {
      return;
    }
    m localm = this.d;
    Bundle localBundle = new Bundle();
    localBundle.putString("id", paramString);
    localBundle.putInt("code", paramInt);
    localm.a(Message.obtain(null, 0, 57, 0, localBundle));
  }
  
  public final void a(String paramString, av paramav, int paramInt)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramav);
    a(paramString, localArrayList, paramInt);
  }
  
  public final void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, long paramLong, String paramString5)
  {
    Log.i("app/xmpp/recv/qr_terminate recv: " + paramString3 + " local: " + auj.a + " clear: " + paramBoolean);
    if ((auj.c()) && (auj.a.equals(paramString3)))
    {
      rk localrk = this.l;
      localrk.b.removeMessages(5);
      localrk.b.removeMessages(3);
      localrk.b.removeMessages(4);
      auj.a(paramBoolean, paramLong);
      if ((paramString3 == null) || (paramString3.equals(auj.a)) || (paramString4 == null) || (!paramBoolean)) {
        break label152;
      }
      auj.f(paramString4);
    }
    for (;;)
    {
      this.b.a(paramString2, paramString1, "web");
      return;
      auj.a(paramLong, paramString4);
      break;
      label152:
      if ((paramString3 == null) && (paramString5 != null) && (paramString4 != null) && (paramBoolean)) {
        auj.a(paramString4, paramString5);
      }
    }
  }
  
  public final void a(String paramString, Collection<j> paramCollection, int paramInt)
  {
    if ((!auj.c()) || (paramString == null) || (paramCollection == null) || (paramCollection.size() == 0)) {
      return;
    }
    Object localObject = new auj.m(new auj.l(this, paramString, paramCollection, paramInt));
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(((j)paramCollection.next()).e);
    }
    paramCollection = auj.p();
    att localatt = this.c;
    localObject = new ci(paramCollection, paramString, (auj.m)localObject, localArrayList);
    ((ci)localObject).j = new ar(paramString, 2, paramInt);
    localatt.a(new SendWebForwardJob(paramCollection, Message.obtain(null, 0, 54, 0, localObject)));
  }
  
  public final void a(String paramString, List<av> paramList, int paramInt)
  {
    a(paramString, paramList, paramInt, false, null);
  }
  
  public final void a(String paramString1, List<av> paramList, int paramInt, boolean paramBoolean, String paramString2)
  {
    auj.m localm;
    if ((auj.c()) || (paramBoolean))
    {
      localm = new auj.m(new auj.r(this, paramString1, paramList, paramInt, paramBoolean, paramString2));
      if (paramString1 != null) {
        break label105;
      }
      paramString1 = auj.p();
      if ((7 != paramInt) && (8 != paramInt)) {
        break label108;
      }
    }
    label105:
    label108:
    for (String str = "preempt-";; str = "")
    {
      this.c.a(new SendWebForwardJob(str + paramString1, a.a.a.a.d.a(paramString1, paramList, paramInt, paramString2, localm, null)));
      return;
      break;
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (!auj.c())) {
      return;
    }
    auj.m localm = new auj.m(new auj.j(this, paramString, paramBoolean));
    String str = auj.p();
    att localatt = this.c;
    paramString = new ci(str, paramString, localm);
    if (paramBoolean) {}
    for (int n = 1;; n = 0)
    {
      paramString.h = n;
      localatt.a(new SendWebForwardJob(str, Message.obtain(null, 0, 48, 0, paramString)));
      return;
    }
  }
  
  public final void a(List<cs> paramList)
  {
    if ((!auj.c()) || (paramList.size() == 0)) {
      return;
    }
    a(paramList, null);
  }
  
  public final void a(List<cs> paramList, String paramString)
  {
    bu.a(ak.a(this, paramList, paramString));
  }
  
  public final void a(boolean paramBoolean)
  {
    if ((this.d.d) && (auj.c()))
    {
      m localm = this.d;
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isLogout", paramBoolean);
      localm.a(Message.obtain(null, 0, 44, 0, localBundle));
      a(null, null, paramBoolean, auj.a, auj.f, 0L, null);
    }
  }
  
  public final String b()
  {
    return Integer.toString(this.m.u()) + this.m.a.getString("web_contact_checksum", "unset");
  }
  
  public final void b(e parame, String paramString)
  {
    if (paramString == null) {}
    for (boolean bool = true;; bool = false)
    {
      bu.a(am.a(this, parame, paramString, bool));
      return;
    }
  }
  
  public final void b(String paramString)
  {
    bu.a(an.a(this, paramString));
  }
  
  public final void b(List<cs> paramList)
  {
    if ((!this.d.d) || (!auj.c()) || (paramList.size() == 0)) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      ((cs)localIterator.next()).e = null;
    }
    a(paramList, null);
  }
  
  public final boolean c(String paramString)
  {
    Integer localInteger = (Integer)auj.j.get(paramString);
    if (localInteger == null)
    {
      auj.b(paramString, -1);
      return false;
    }
    if (localInteger.intValue() < 0)
    {
      Log.d("app/xmpp/web/handled/action/in_progress/" + paramString);
      return true;
    }
    a(paramString, localInteger.intValue());
    return true;
  }
  
  public final void onEvent(com.whatsapp.g.c paramc)
  {
    a(paramc.a);
  }
  
  public final void onEvent(com.whatsapp.g.d paramd)
  {
    a(paramd, (k)b.a.a.c.a().a(k.class));
  }
  
  public final void onEvent(k paramk)
  {
    a((com.whatsapp.g.d)b.a.a.c.a().a(com.whatsapp.g.d.class), paramk);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */