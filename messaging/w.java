package com.whatsapp.messaging;

import a.a.a.a.d;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.whatsapp.a.c;
import com.whatsapp.adp;
import com.whatsapp.att;
import com.whatsapp.auu;
import com.whatsapp.cg;
import com.whatsapp.contact.sync.ContactSyncManager.ParcelableSyncUserRequest;
import com.whatsapp.contact.sync.q;
import com.whatsapp.contact.sync.r;
import com.whatsapp.data.cs;
import com.whatsapp.fieldstats.l;
import com.whatsapp.fieldstats.o;
import com.whatsapp.fieldstats.p;
import com.whatsapp.location.bn;
import com.whatsapp.protocol.af;
import com.whatsapp.protocol.al;
import com.whatsapp.protocol.am;
import com.whatsapp.protocol.aw;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.t;
import com.whatsapp.rj;
import com.whatsapp.rk;
import com.whatsapp.sr;
import com.whatsapp.util.Log;
import com.whatsapp.util.w.a;
import com.whatsapp.va;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class w
{
  @SuppressLint({"StaticFieldLeak"})
  private static volatile w c;
  final Context a;
  public final m b;
  private final va d;
  private final adp e;
  private final att f;
  private final com.whatsapp.util.w g;
  private final sr h;
  private final auu i;
  private final rk j;
  private final af k;
  private final i l;
  
  private w(Context paramContext, va paramva, adp paramadp, att paramatt, m paramm, com.whatsapp.util.w paramw, sr paramsr, auu paramauu, rk paramrk, af paramaf, i parami)
  {
    this.a = paramContext;
    this.d = paramva;
    this.e = paramadp;
    this.f = paramatt;
    this.b = paramm;
    this.g = paramw;
    this.h = paramsr;
    this.i = paramauu;
    this.j = paramrk;
    this.k = paramaf;
    this.l = parami;
  }
  
  public static w a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new w(com.whatsapp.u.a(), va.a(), adp.a(), att.a(), m.a(), com.whatsapp.util.w.a(), sr.a(), auu.a(), rk.a(), af.a(), i.a());
      }
      return c;
    }
    finally {}
  }
  
  public final Future<Void> a(com.whatsapp.contact.sync.w paramw, String paramString, ArrayList<ContactSyncManager.ParcelableSyncUserRequest> paramArrayList, String[] paramArrayOfString)
  {
    if ((!this.b.d) || (!this.i.a)) {
      return null;
    }
    String str = this.b.f();
    try
    {
      m localm = this.b;
      Bundle localBundle = new Bundle();
      localBundle.putString("mode", paramw.i.d);
      localBundle.putString("sid", paramString);
      localBundle.putString("context", paramw.h.e);
      localBundle.putParcelableArrayList("requests", paramArrayList);
      localBundle.putStringArray("capabilities", paramArrayOfString);
      localBundle.putString("id", str);
      paramw = localm.a(str, Message.obtain(null, 0, 102, 0, localBundle), false);
      return paramw;
    }
    catch (m.b paramw) {}
    return null;
  }
  
  public final Future<Void> a(String paramString, am paramam, com.whatsapp.protocol.x paramx)
  {
    if ((!this.b.d) || (!this.i.a)) {
      return null;
    }
    String str = this.b.f();
    try
    {
      paramString = this.b.a(str, Message.obtain(null, 0, 105, 0, new bx(str, paramString, paramam, paramx)), false);
      return paramString;
    }
    catch (m.b paramString) {}
    return null;
  }
  
  public final Future<Void> a(String paramString, t paramt)
  {
    if ((!this.b.d) || (!this.i.a)) {
      return null;
    }
    String str = this.b.f();
    try
    {
      paramString = this.b.a(str, Message.obtain(null, 0, 107, 0, new bu(str, paramString, paramt)), false);
      return paramString;
    }
    catch (m.b paramString) {}
    return null;
  }
  
  public final Future<Void> a(String paramString1, String paramString2, com.whatsapp.protocol.u paramu)
  {
    if ((!this.b.d) || (!this.i.a)) {
      return null;
    }
    String str = this.b.f();
    try
    {
      paramString1 = this.b.a(str, Message.obtain(null, 0, 112, 0, new bv(str, paramString1, paramString2, paramu)), false);
      return paramString1;
    }
    catch (m.b paramString1) {}
    return null;
  }
  
  public final Future<Void> a(byte[] paramArrayOfByte)
  {
    Log.i("sendmethods/send-set-biz-vname-cert");
    if ((!this.b.d) || (!this.i.a)) {
      return null;
    }
    String str = this.b.f();
    try
    {
      m localm = this.b;
      Message localMessage = Message.obtain(null, 0, 119, 0);
      Bundle localBundle = localMessage.getData();
      localBundle.putString("id", str);
      localBundle.putSerializable("certificate", paramArrayOfByte);
      paramArrayOfByte = localm.a(str, localMessage, false);
      return paramArrayOfByte;
    }
    catch (m.b paramArrayOfByte) {}
    return null;
  }
  
  public final void a(int paramInt)
  {
    if (this.b.d)
    {
      Log.i("sendmethods/tosupdate/stage " + paramInt);
      Runnable localRunnable = x.a(paramInt);
      y localy = new y(paramInt);
      this.b.a(Message.obtain(null, 0, 99, 0, new ch(paramInt, localRunnable, localy)));
    }
  }
  
  public final void a(bn parambn)
  {
    if (this.b.d)
    {
      Log.i("sendmethods/sendSubscribeLocations/" + parambn.b + "/" + parambn.c);
      this.b.a(Message.obtain(null, 0, 82, 0, parambn));
    }
  }
  
  public final void a(al paramal)
  {
    if (this.b.d)
    {
      if ((!"receipt".equals(paramal.b)) || (!"read".equals(paramal.d))) {
        break label107;
      }
      if (this.e.a(paramal.a)) {
        break label102;
      }
    }
    label102:
    for (boolean bool = true;; bool = false)
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("stanzaKey", new ParcelableStanzaKey(paramal));
      localBundle.putBoolean("disable", bool);
      paramal = Message.obtain(null, 0, 96, 0, localBundle);
      this.b.a(paramal);
      return;
    }
    label107:
    this.b.a(d.b(paramal));
  }
  
  public final void a(j paramj)
  {
    if (this.b.d) {
      this.b.a(Message.obtain(null, 0, 38, 0, paramj));
    }
  }
  
  public final void a(j paramj, boolean paramBoolean, long paramLong)
  {
    Object localObject = this.l.a(paramj.e.a);
    if ((paramj.s != 15) && (localObject != null) && (!this.l.a((h)localObject)))
    {
      paramj.ad = ((h)localObject).b;
      paramj.ac = ((h)localObject).c;
      paramj.ae = ((int)((System.currentTimeMillis() - ((h)localObject).d) / 1000L));
      ((h)localObject).d = System.currentTimeMillis();
      this.l.b((h)localObject);
    }
    localObject = this.j;
    ((rk)localObject).b.removeMessages(0);
    ((rk)localObject).b.removeMessages(1);
    ((rk)localObject).b.removeMessages(2);
    if (this.b.d)
    {
      localObject = this.h;
      j.b localb = paramj.e;
      if ((!((sr)localObject).c.contains(localb)) && (!paramj.a(this.d)))
      {
        localObject = this.h;
        localb = paramj.e;
        ((sr)localObject).c.add(localb);
        c.a.execute(new v(this.d, this.f, this.k, paramj, paramBoolean, paramLong));
      }
    }
  }
  
  public final void a(rj paramrj)
  {
    if (this.b.d)
    {
      Log.i("sendmethods/sendCreateGroupChat");
      this.b.a(Message.obtain(null, 0, 14, 0, paramrj));
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (this.b.d)
    {
      Log.i("sendmethods/sendsetprivacysettings " + paramString1 + " " + paramString2);
      this.b.a(Message.obtain(null, 0, 69, 0, new cc(paramString1, paramString2)));
    }
  }
  
  public final void a(Collection<cs> paramCollection)
  {
    String[] arrayOfString = new String[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int m = 0;
    while (paramCollection.hasNext())
    {
      arrayOfString[m] = ((cs)paramCollection.next()).t;
      m += 1;
    }
    a(arrayOfString);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.b.d)
    {
      Log.i("sendmethods/tosupdate/accept " + paramBoolean);
      Runnable localRunnable = z.a(paramBoolean);
      aa localaa = new aa(paramBoolean);
      this.b.a(d.a(null, paramBoolean, localRunnable, localaa));
    }
  }
  
  public final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, Runnable paramRunnable)
  {
    if (this.b.d)
    {
      Log.i("sendmethods/sendcreatecipherkey");
      this.b.a(d.a(paramArrayOfByte1, paramArrayOfByte2, paramRunnable));
    }
  }
  
  public final void a(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      Log.w("empty jids list in requested capability query; skipping");
    }
    while ((!this.b.d) || (cg.a.length == 0)) {
      return;
    }
    m localm = this.b;
    String[] arrayOfString = cg.a;
    Message localMessage = Message.obtain(null, 0, 95, 0);
    localMessage.getData().putStringArray("jids", paramArrayOfString);
    localMessage.getData().putStringArray("capabilities", arrayOfString);
    localm.a(localMessage);
  }
  
  public final boolean a(String paramString, long paramLong, Messenger paramMessenger)
  {
    if (!this.b.d) {
      return false;
    }
    m localm = this.b;
    Bundle localBundle = new Bundle();
    localBundle.putString("jid", paramString);
    localBundle.putLong("timestamp", paramLong);
    localBundle.putParcelable("callbackMessenger", paramMessenger);
    localm.a(Message.obtain(null, 0, 41, 0, localBundle));
    return true;
  }
  
  public final boolean a(String paramString, am paramam, com.whatsapp.protocol.x paramx, com.whatsapp.protocol.i parami, aw paramaw)
  {
    if (this.b.d)
    {
      this.b.a(Message.obtain(null, 0, 29, 0, new cf(paramString, paramam, paramx, parami, paramaw)));
      return true;
    }
    return false;
  }
  
  public final Future<Void> b(String paramString, am paramam, com.whatsapp.protocol.x paramx)
  {
    if ((!this.b.d) || (!this.i.a)) {
      return null;
    }
    String str = this.b.f();
    try
    {
      paramString = this.b.a(str, Message.obtain(null, 0, 106, 0, new bx(str, paramString, paramam, paramx)), false);
      return paramString;
    }
    catch (m.b paramString) {}
    return null;
  }
  
  public final void b()
  {
    l locall = l.a(this.a);
    locall.b.post(o.a(locall));
  }
  
  public final void b(j paramj)
  {
    if (this.b.d) {
      this.b.a(Message.obtain(null, 0, 77, 0, paramj));
    }
  }
  
  public final void b(rj paramrj)
  {
    if (this.b.d)
    {
      Log.i("sendmethods/sendAddParticipants");
      this.b.a(Message.obtain(null, 0, 15, 0, paramrj));
    }
  }
  
  public final boolean b(String paramString1, String paramString2)
  {
    boolean bool = false;
    if (this.b.d)
    {
      this.b.a(Message.obtain(null, 0, 36, 0, new az(paramString1, paramString2)));
      bool = true;
    }
    return bool;
  }
  
  public final Future<Void> c(String paramString, am paramam, com.whatsapp.protocol.x paramx)
  {
    if ((!this.b.d) || (!this.i.a)) {
      return null;
    }
    String str = this.b.f();
    try
    {
      paramString = this.b.a(str, Message.obtain(null, 0, 108, 0, new by(str, paramString, paramam, paramx)), false);
      return paramString;
    }
    catch (m.b paramString) {}
    return null;
  }
  
  public final Future<Void> c(String paramString1, String paramString2)
  {
    if ((!this.b.d) || (!this.i.a)) {
      return null;
    }
    String str = this.b.f();
    try
    {
      m localm = this.b;
      Bundle localBundle = new Bundle();
      localBundle.putString("mode", r.c.d);
      localBundle.putString("sid", paramString1);
      localBundle.putString("context", com.whatsapp.contact.sync.w.g.h.e);
      localBundle.putString("phonenumber", paramString2);
      localBundle.putString("id", str);
      paramString1 = localm.a(str, Message.obtain(null, 0, 113, 0, localBundle), false);
      return paramString1;
    }
    catch (m.b paramString1) {}
    return null;
  }
  
  public final void c()
  {
    l.a(this.a).b.post(p.a());
    b();
  }
  
  public final void c(rj paramrj)
  {
    if (this.b.d)
    {
      Log.i("sendmethods/sendRemoveParticipants");
      this.b.a(Message.obtain(null, 0, 30, 0, paramrj));
    }
  }
  
  public final void d()
  {
    if (this.b.d)
    {
      Log.i("sendmethods/sendgetprivacysettings");
      this.b.a(Message.obtain(null, 0, 70, 0));
    }
  }
  
  public final void d(rj paramrj)
  {
    if (this.b.d)
    {
      Log.i("sendmethods/sendAddAdmins");
      this.b.a(Message.obtain(null, 0, 91, 0, paramrj));
    }
  }
  
  public final void d(String paramString1, String paramString2)
  {
    if (this.b.d)
    {
      if (!this.g.a.a(paramString1)) {
        Log.w("sendmethods/skip sendGetGroupInfo");
      }
    }
    else {
      return;
    }
    Log.w("sendmethods/sendGetGroupInfo");
    m localm = this.b;
    Message localMessage = Message.obtain(null, 0, 20, 0);
    localMessage.getData().putString("gid", paramString1);
    localMessage.getData().putString("context", paramString2);
    localm.a(localMessage);
  }
  
  public final void e()
  {
    if (this.b.d) {
      this.b.a(Message.obtain(null, 0, 88, 0));
    }
  }
  
  public final void e(rj paramrj)
  {
    if (this.b.d)
    {
      Log.i("sendmethods/sendLeaveGroup");
      this.b.a(Message.obtain(null, 0, 16, 0, paramrj));
    }
  }
  
  public final void f()
  {
    this.b.g = true;
    this.b.a(d.j(), null);
  }
  
  public final void f(rj paramrj)
  {
    if (this.b.d)
    {
      Log.i("sendmethods/sendSetGroupSubject");
      this.b.a(Message.obtain(null, 0, 17, 0, paramrj));
    }
  }
  
  public final void g()
  {
    if (this.b.d)
    {
      Log.i("sendmethods/sendGetBroadcastLists");
      this.b.a(Message.obtain(null, 0, 59, 0));
    }
  }
  
  public final void g(rj paramrj)
  {
    if (this.b.d)
    {
      Log.i("sendmethods/sendDeleteBroadcastLists");
      this.b.a(Message.obtain(null, 0, 60, 0, paramrj));
    }
  }
  
  public final void h()
  {
    if (this.b.d)
    {
      Log.i("sendmethods/sendGetServerProps");
      this.b.a(Message.obtain(null, 0, 21, 0));
    }
  }
  
  public final boolean i()
  {
    boolean bool = false;
    Message localMessage = Message.obtain(null, 0, 124, 0);
    if (this.b.d)
    {
      Log.i("app/sendgetmediaroutinginfo");
      this.b.a(localMessage);
      bool = true;
    }
    return bool;
  }
  
  public final void j()
  {
    if (this.b.d) {
      this.b.a(d.i());
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */