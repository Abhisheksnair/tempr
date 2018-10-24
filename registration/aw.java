package com.whatsapp.registration;

import a.a.a.a.a.a.d;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.whatsapp.Conversation;
import com.whatsapp.Me;
import com.whatsapp.aaq;
import com.whatsapp.anv;
import com.whatsapp.aq;
import com.whatsapp.atv;
import com.whatsapp.au;
import com.whatsapp.data.ad;
import com.whatsapp.data.ch;
import com.whatsapp.data.cs;
import com.whatsapp.data.v;
import com.whatsapp.gdrive.GoogleDriveService;
import com.whatsapp.gdrive.GoogleDriveService.f;
import com.whatsapp.messaging.m;
import com.whatsapp.messaging.m.d;
import com.whatsapp.messaging.w;
import com.whatsapp.proto.c;
import com.whatsapp.proto.c.b;
import com.whatsapp.pv;
import com.whatsapp.r;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.va;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class aw
{
  private static volatile aw i;
  public final Context a;
  final pv b;
  public final va c;
  public final w d;
  public final atv e;
  public final Handler f = new Handler(Looper.getMainLooper());
  public final List<a> g = new CopyOnWriteArrayList();
  GoogleDriveService h;
  private final aaq j;
  private final anv k;
  private final x l;
  private final m m;
  private final aq n;
  private final bb o;
  private i p;
  
  private aw(Context paramContext, pv parampv, aaq paramaaq, va paramva, anv paramanv, w paramw, x paramx, m paramm, aq paramaq, atv paramatv, bb parambb)
  {
    this.a = paramContext;
    this.b = parampv;
    this.j = paramaaq;
    this.c = paramva;
    this.k = paramanv;
    this.d = paramw;
    this.l = paramx;
    this.m = paramm;
    this.n = paramaq;
    this.e = paramatv;
    this.o = parambb;
  }
  
  public static aw a()
  {
    if (i == null) {}
    try
    {
      if (i == null) {
        i = new aw((Context)a.d.a(u.a(), "registrationmanager/get-instance creating with null context"), pv.a(), aaq.a(), va.a(), anv.a(), w.a(), x.a(), m.a(), aq.a(), atv.a(), bb.a());
      }
      return i;
    }
    finally {}
  }
  
  static File g()
  {
    return new File(u.a().getFilesDir(), "unsignedvname.cert");
  }
  
  public static c h()
  {
    try
    {
      c localc = c.a(new FileInputStream(g()));
      return localc;
    }
    catch (Exception localException)
    {
      Log.e("registrationmanager/getunsignedbizvnamecert/error " + localException);
    }
    return null;
  }
  
  public static String i()
  {
    if (!g().exists())
    {
      Log.w("registrationmanager/getunsignedbizvnamecertverifiedname/no-file");
      return null;
    }
    Object localObject = h();
    if (localObject != null) {
      try
      {
        localObject = c.b.a(((c)localObject).b).b();
        return (String)localObject;
      }
      catch (Exception localException)
      {
        Log.e("registrationmanager/getunsignedbizvnamecertverifiedname/get-details/error " + localException);
        return null;
      }
    }
    Log.e("registrationmanager/getunsignedbizvnamecertverifiedname/no-cert");
    return null;
  }
  
  public final Intent a(ad paramad)
  {
    l();
    this.j.b();
    this.n.g();
    this.m.e();
    Object localObject = this.c.c();
    if (localObject != null)
    {
      ((cs)localObject).l();
      ((cs)localObject).a(0, 0);
    }
    localObject = new File(this.a.getFilesDir(), "me");
    if (((File)localObject).exists())
    {
      boolean bool = ((File)localObject).delete();
      Log.d("registrationmanager/reregister/rm-me " + bool);
    }
    this.c.b = null;
    a(null, null, null);
    paramad.e();
    localObject = new Intent(this.a, RegisterPhone.class);
    ((Intent)localObject).putExtra("com.whatsapp.registration.RegisterPhone.resetstate", true);
    ((Intent)localObject).putExtra("com.whatsapp.registration.RegisterPhone.clear_phone_number", true);
    if (Build.VERSION.SDK_INT >= 11) {
      ((Intent)localObject).addFlags(32768);
    }
    k();
    this.o.a(1);
    this.k.j();
    paramad.z.e = false;
    v.a().a = true;
    r.m();
    this.e.ab();
    this.e.Z();
    this.n.c();
    this.e.e(true);
    this.l.a(false);
    Conversation.B();
    return (Intent)localObject;
  }
  
  public final void a(long paramLong)
  {
    if (paramLong < 60000L) {
      return;
    }
    Object localObject = new Intent("com.whatsapp.alarm.REGISTRATION_RETRY").setPackage(au.b());
    localObject = PendingIntent.getBroadcast(this.a, 0, (Intent)localObject, 0);
    AlarmManager localAlarmManager = (AlarmManager)this.a.getSystemService("alarm");
    if (Build.VERSION.SDK_INT >= 23)
    {
      localAlarmManager.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + paramLong, (PendingIntent)localObject);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      localAlarmManager.setExact(2, SystemClock.elapsedRealtime() + paramLong, (PendingIntent)localObject);
      return;
    }
    localAlarmManager.set(2, SystemClock.elapsedRealtime() + paramLong, (PendingIntent)localObject);
  }
  
  public final void a(a parama)
  {
    this.g.add(parama);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3)
  {
    this.e.a.edit().putString("registration_jid", paramString3).remove("registration_wipe_type").remove("registration_wipe_token").remove("registration_wipe_wait").remove("registration_wipe_expiry").remove("registration_wipe_server_time").remove("registration_wipe_info_timestamp").apply();
    this.e.a(paramString1, paramString2);
  }
  
  final boolean a(ad paramad, com.whatsapp.contact.sync.i parami)
  {
    this.d.j();
    this.m.e();
    Log.i("registrationmanager/complete-change-number");
    Me localMe = d();
    localMe.jabber_id = this.e.af();
    if (localMe.jabber_id != null)
    {
      bool = true;
      Log.a(bool);
      if (!this.c.a(localMe, "me")) {
        break label97;
      }
      this.c.b = localMe;
    }
    label97:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        break label102;
      }
      Log.i("registration-manager/complete-change-number/error-saving");
      return false;
      bool = false;
      break;
    }
    label102:
    boolean bool = paramad.z.d;
    if ((!bool) && (paramad.d()))
    {
      Log.i("registration-manager/complete-change-number/msgstoredb/healthy");
      paramad.c();
    }
    f();
    this.m.c();
    if (!bool) {
      parami.d();
    }
    this.o.a(3);
    v.a().a = true;
    r.m();
    Log.i("registration-manager/complete-change-number/changenumber/setregverified");
    parami.c();
    this.d.j();
    this.n.c();
    this.e.h(true);
    paramad = this.c.c();
    paramad.l();
    paramad.a(0, 0);
    this.j.b();
    this.m.a(false, false, false, null, null, null, null, false);
    return true;
  }
  
  public final i b()
  {
    if (this.p == null) {}
    try
    {
      if (this.p == null) {
        this.p = new i();
      }
      return this.p;
    }
    finally {}
  }
  
  public final void b(a parama)
  {
    this.g.remove(parama);
  }
  
  public final boolean b(ad paramad, com.whatsapp.contact.sync.i parami)
  {
    Log.i("registrationmanager/revert-to-old");
    Me localMe = this.c.e();
    if (!this.c.a(localMe, "me")) {
      return false;
    }
    this.c.b = localMe;
    this.e.g(false);
    this.c.d();
    if (paramad.d())
    {
      Log.i("registrationmanager/revert/msgstoredb/healthy");
      paramad.c();
      this.m.c();
      parami.d();
    }
    for (;;)
    {
      return true;
      paramad = this.m;
      parami = Message.obtain(null, 0, 0, 0);
      parami.getData().putBoolean("should_register", false);
      paramad.b.sendMessage(parami);
    }
  }
  
  public final void c()
  {
    b();
    i.a(this.a, this.e);
  }
  
  public final Me d()
  {
    return new Me(this.e.F(), this.e.G());
  }
  
  public final void e()
  {
    this.c.b = null;
    this.e.a.edit().remove("registration_wipe_type").remove("registration_wipe_token").remove("registration_wipe_wait").remove("registration_wipe_expiry").remove("registration_wipe_server_time").remove("registration_wipe_info_timestamp").apply();
    this.o.a(1);
  }
  
  public final void f()
  {
    if (this.c.b != null)
    {
      Log.i("xmpp/service/reset-registered/updateparams");
      String str = this.c.b();
      m localm = this.m;
      if (localm.e) {
        localm.f = str;
      }
    }
  }
  
  public final boolean j()
  {
    return !TextUtils.isEmpty(this.e.ag());
  }
  
  public final void k()
  {
    g().delete();
    this.e.m(false);
    this.e.i(null);
  }
  
  public final void l()
  {
    this.a.getSharedPreferences("RegisterPhone", 0).edit().clear().apply();
    this.a.getSharedPreferences("VerifySms", 0).edit().clear().apply();
  }
  
  public final boolean m()
  {
    return this.c.e() != null;
  }
  
  public final void n()
  {
    Me localMe = this.c.e();
    if (localMe != null)
    {
      this.c.d();
      this.f.post(ax.a(this, localMe));
      return;
    }
    Log.w("registrationmanager/response/ok already changed?");
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(String paramString);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/registration/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */