package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.b.a;
import com.whatsapp.contact.sync.i;
import com.whatsapp.data.a;
import com.whatsapp.data.ad;
import com.whatsapp.data.cb;
import com.whatsapp.data.cb.c;
import com.whatsapp.data.ch.a;
import com.whatsapp.data.ci;
import com.whatsapp.data.co;
import com.whatsapp.gdrive.GoogleDriveActivity;
import com.whatsapp.messaging.m;
import com.whatsapp.messaging.w;
import com.whatsapp.registration.RegisterPhone;
import com.whatsapp.registration.aw;
import com.whatsapp.registration.bb;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import com.whatsapp.wallpaper.g;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract class apg
{
  protected static acy b = null;
  private static final AtomicReference<ch.a> f = new AtomicReference(null);
  private final AtomicBoolean a = new AtomicBoolean(false);
  protected boolean c = false;
  final Activity d;
  final b e;
  private final vv.a g = new vv.a()
  {
    public final void a()
    {
      throw new IllegalStateException("must not be called");
    }
    
    public final void b()
    {
      d.a(apg.a(apg.this), 107);
    }
    
    public final void c()
    {
      RequestPermissionActivity.a(apg.a(apg.this), 2131297441, 2131297440, 200);
    }
    
    public final void d()
    {
      throw new IllegalStateException("must not be called");
    }
  };
  private final va h;
  private final w i;
  private final ad j;
  private final att k;
  private final m l;
  private final a m;
  private final i n;
  private final qz o;
  private final g p;
  private final cc q;
  private final vv r;
  private final co s;
  private final aw t;
  private final atv u;
  private final ci v;
  private final rh w;
  private final bb x;
  
  public apg(Activity paramActivity, va paramva, w paramw, ad paramad, att paramatt, m paramm, a parama, i parami, qz paramqz, g paramg, cc paramcc, vv paramvv, co paramco, aw paramaw, atv paramatv, ci paramci, rh paramrh, bb parambb)
  {
    this.d = paramActivity;
    this.h = paramva;
    this.i = paramw;
    this.j = paramad;
    this.k = paramatt;
    this.l = paramm;
    this.m = parama;
    this.n = parami;
    this.o = paramqz;
    this.p = paramg;
    this.q = paramcc;
    this.r = paramvv;
    this.s = paramco;
    this.t = paramaw;
    this.u = paramatv;
    this.v = paramci;
    this.w = paramrh;
    this.x = parambb;
    this.e = new b(Looper.getMainLooper(), new WeakReference(paramActivity), (byte)0);
  }
  
  private Dialog a(int paramInt1, int paramInt2)
  {
    return new b.a(this.d).b(paramInt2).a(false).a(2131297619, api.a(this, paramInt1)).b(2131297210, apj.a(this, paramInt1)).a();
  }
  
  protected abstract void a();
  
  protected abstract void a(int paramInt);
  
  protected abstract void a(ch.a parama);
  
  protected final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = new StringBuilder("verifymsgstore/preparemsgstore isregname=").append(this.c).append(" restorefrombackup=").append(paramBoolean1).append(" skipdialog=");
    if (paramBoolean2) {}
    for (Object localObject1 = "true";; localObject1 = "false")
    {
      Log.i((String)localObject1);
      if ((!paramBoolean2) && (!this.d.isFinishing()) && ((!this.c) || (paramBoolean1))) {
        d.a(this.d, 100);
      }
      localObject1 = this.t.d();
      ((Me)localObject1).jabber_id = this.u.af();
      if (((Me)localObject1).jabber_id != null) {
        break;
      }
      Log.e("registername/messagestoreverified/missing-params bounce to regphone");
      this.x.a(1);
      this.d.startActivity(new Intent(this.d, RegisterPhone.class));
      this.d.finish();
      return;
    }
    this.h.b = ((Me)localObject1);
    this.l.g = false;
    Log.i("verifymsgstore/preparemsgstore/set-connection/passive");
    this.t.f();
    this.l.c();
    int i1;
    if (paramBoolean1)
    {
      localObject1 = apk.a(this);
      localObject2 = apl.a(this);
      localObject1 = com.whatsapp.data.cc.a(this.j.c, (Runnable)localObject2, (Runnable)localObject1);
      i1 = this.m.a((Runnable)localObject1);
      Log.d("verifymsgstore/preparemsgstore/backup-keys-count " + i1);
    }
    for (;;)
    {
      if (i1 == 0)
      {
        Log.d("verifymsgstore/preparemsgstore/no-keys-to-request/continue");
        bu.a(new a(paramBoolean1), new Object[0]);
        return;
      }
      Log.d("verifymsgstore/preparemsgstore/have-keys/continue");
      this.e.sendEmptyMessageDelayed(1, 32000L);
      return;
      i1 = 0;
    }
  }
  
  protected final Dialog b(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      Log.i("verifymsgstore/dialog/setup");
      localObject = new acy(this.d);
      b = (acy)localObject;
      ((acy)localObject).setTitle(this.d.getString(2131297217));
      b.setMessage(this.d.getString(2131297216));
      b.setIndeterminate(false);
      b.setCancelable(false);
      b.setProgressStyle(1);
      return b;
    case 101: 
      Log.i("verifymsgstore/dialog/msgstoreerror");
      return new b.a(this.d).a(2131296307).b(this.d.getString(2131297211)).a(2131297331, aph.a(this)).a();
    case 107: 
      Log.i("verifymsgstore/dialog/restorefrombackupduetoerrorcardnotfoundaskretry");
      localObject = new StringBuilder().append(this.d.getString(2131297213)).append(" ");
      Activity localActivity = this.d;
      if (vv.i()) {}
      for (paramInt = 2131297214;; paramInt = 2131297215)
      {
        localObject = localActivity.getString(paramInt);
        return new b.a(this.d).a(2131296307).b((CharSequence)localObject).a(2131297619, apo.a(this)).b(2131297856, app.a(this)).a(false).a();
      }
    case 103: 
      Log.i("verifymsgstore/dialog/restore");
      return new b.a(this.d).a(2131297200).b(this.d.getString(2131297208)).a(2131298213, apq.a(this)).b(2131297281, apr.a(this)).a(false).a();
    case 105: 
      Log.i("verifymsgstore/dialog/restoreduetoerror");
      localObject = this.d.getString(2131297213) + " " + this.d.getString(2131297209);
      return new b.a(this.d).a(2131297201).b((CharSequence)localObject).a(2131297218, aps.a(this)).b(2131297210, apt.a(this)).a(false).a();
    case 106: 
      return new b.a(this.d).a(2131297207).b(this.d.getString(2131296688)).a(2131297210, apu.a(this)).b(2131296398, apv.a(this)).a(false).a();
    case 108: 
      Log.i("verifymsgstore/dialog/msgstorenotrestored");
      return new b.a(this.d).a(2131296307).b(this.d.getString(2131297212)).a(2131297331, null).a();
    case 104: 
      Log.i("verifymsgstore/dialog/groupsync");
      localObject = new acy(this.d);
      ((acy)localObject).setTitle(this.d.getString(2131297593));
      ((acy)localObject).setMessage(this.d.getString(2131297592));
      ((acy)localObject).setIndeterminate(true);
      ((acy)localObject).setCancelable(false);
      return (Dialog)localObject;
    case 201: 
      Log.i("verifymsgstore/dialog/keyserviceunavailable");
      return a(201, 2131297220);
    }
    Log.i("verifymsgstore/dialog/cannot-connect");
    return a(200, 2131297219);
  }
  
  protected final void b()
  {
    this.c = true;
  }
  
  protected final void c()
  {
    int i1 = this.j.c.d();
    Log.i("verifymsgstore/usehistoryifexists/backupfilesfound " + i1);
    if (i1 > 0)
    {
      d.a(this.d, 103);
      return;
    }
    a(false, true);
  }
  
  public final boolean d()
  {
    return this.r.b(this.g);
  }
  
  public final class a
    extends AsyncTask<Object, Integer, ch.a>
  {
    private final boolean b;
    private final boolean c;
    
    public a(boolean paramBoolean)
    {
      this.b = paramBoolean;
      if ((!paramBoolean) || (!(apg.a(apg.this) instanceof GoogleDriveActivity))) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.c = paramBoolean;
        return;
      }
    }
    
    private ch.a a()
    {
      Object localObject1 = ch.a.a;
      Object localObject2 = new cb.c(this);
      try
      {
        long l = System.currentTimeMillis();
        localObject2 = apg.b(apg.this).a(this.b, this.c, (cb.c)localObject2);
        localObject1 = localObject2;
        Log.e(localIOException1);
      }
      catch (IOException localIOException1)
      {
        try
        {
          publishProgress(new Integer[] { Integer.valueOf(100) });
          l = 3000L - (System.currentTimeMillis() - l);
          if ((this.b) && (l > 0L)) {
            SystemClock.sleep(l);
          }
          return (ch.a)localObject1;
        }
        catch (IOException localIOException2)
        {
          for (;;) {}
        }
        localIOException1 = localIOException1;
      }
      return (ch.a)localObject1;
    }
  }
  
  static final class b
    extends Handler
  {
    private final WeakReference<Activity> a;
    
    private b(Looper paramLooper, WeakReference<Activity> paramWeakReference)
    {
      super();
      this.a = paramWeakReference;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      Activity localActivity = (Activity)this.a.get();
      if (localActivity == null)
      {
        removeMessages(1);
        return;
      }
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      Log.e("verifymsgstorehelper/timeout");
      removeMessages(1);
      d.a(localActivity, 200);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/apg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */