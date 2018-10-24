package com.whatsapp.contact.sync;

import a.a.a.a.a.a.d;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.whatsapp.Voip;
import com.whatsapp.aat;
import com.whatsapp.and;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.auu;
import com.whatsapp.data.cp;
import com.whatsapp.data.ct;
import com.whatsapp.dh;
import com.whatsapp.di;
import com.whatsapp.fieldstats.events.o;
import com.whatsapp.k.d.b;
import com.whatsapp.pv;
import com.whatsapp.registration.bb;
import com.whatsapp.rh;
import com.whatsapp.util.Log;
import com.whatsapp.util.m;
import com.whatsapp.va;
import com.whatsapp.vv;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
{
  @SuppressLint({"StaticFieldLeak"})
  private static volatile a e;
  final Handler a;
  final s b;
  final u c;
  public final AtomicBoolean d = new AtomicBoolean(false);
  private final Context f;
  private final Handler g;
  private boolean h = true;
  private final Runnable i;
  private final pv j;
  private final com.whatsapp.util.a.c k;
  private final va l;
  private final com.whatsapp.data.e m;
  private final and n;
  private final dh o;
  private final auu p;
  private final vv q;
  private final ContactSyncManager r;
  private final aat s;
  private final atu t;
  private final atv u;
  private final rh v;
  private final bb w;
  
  private a(Context paramContext, pv parampv, com.whatsapp.util.a.c paramc, va paramva, di paramdi, com.whatsapp.data.e parame, and paramand, dh paramdh, auu paramauu, vv paramvv, ContactSyncManager paramContactSyncManager, aat paramaat, atu paramatu, atv paramatv, rh paramrh, bb parambb)
  {
    this.f = paramContext;
    this.j = parampv;
    this.k = paramc;
    this.l = paramva;
    this.m = parame;
    this.n = paramand;
    this.o = paramdh;
    this.p = paramauu;
    this.q = paramvv;
    this.r = paramContactSyncManager;
    this.s = paramaat;
    this.t = paramatu;
    this.u = paramatv;
    this.v = paramrh;
    this.w = parambb;
    this.i = b.a(paramdi);
    paramContext = new HandlerThread("sync", 10);
    paramContext.start();
    this.a = new Handler(paramContext.getLooper());
    paramContext = new HandlerThread("sync-queue", 10);
    paramContext.start();
    this.g = new Handler(paramContext.getLooper());
    this.c = new u();
    this.b = new s();
    Log.i("ContactsSyncAdapter/created");
    this.g.post(c.a(this));
  }
  
  public static a a()
  {
    if (e == null) {}
    try
    {
      if (e == null)
      {
        e = new a(com.whatsapp.u.a(), pv.a(), com.whatsapp.util.a.c.a(), va.a(), di.a(), com.whatsapp.data.e.a(), and.a(), dh.a(), auu.a(), vv.a(), ContactSyncManager.a(), aat.a(), atu.a(), atv.a(), rh.a(), bb.a());
        b.a.a.c.a().a(e, false);
      }
      return e;
    }
    finally {}
  }
  
  public final void a(t paramt)
  {
    this.g.post(e.a(this, paramt));
  }
  
  final void b(t paramt)
  {
    boolean bool2 = false;
    Log.i("ContactsSyncAdapter/queueRequest " + paramt);
    t localt;
    synchronized (this.d)
    {
      Iterator localIterator = this.c.b().iterator();
      do
      {
        localObject = paramt;
        if (!localIterator.hasNext()) {
          break;
        }
        localt = (t)localIterator.next();
      } while (!localt.a(paramt));
      Log.i("ContactsSyncAdapter/combineRequests");
      this.a.removeCallbacks(this.c.c(localt));
      if (!paramt.a(localt)) {
        throw new IllegalStateException("these requests cannot be combined " + paramt + " and " + localt);
      }
    }
    Object localObject = new t.a(w.a(paramt.a, localt.a));
    boolean bool1;
    if (!paramt.b)
    {
      if (!localt.b) {
        break label552;
      }
      break label527;
      ((t.a)localObject).b = bool1;
      if ((!paramt.c) || (!localt.c)) {
        break label557;
      }
      bool1 = true;
      label214:
      ((t.a)localObject).c = bool1;
      if ((!paramt.d) || (!localt.d)) {
        break label562;
      }
      bool1 = true;
      label237:
      ((t.a)localObject).d = bool1;
      if (paramt.e) {
        break label532;
      }
      if (!localt.e) {
        break label567;
      }
      break label532;
      label261:
      ((t.a)localObject).e = bool1;
      localObject = t.a.a(t.a.a((t.a)localObject, paramt.k), localt.k);
      if (paramt.g) {
        break label537;
      }
      if (!localt.g) {
        break label572;
      }
      break label537;
      label304:
      localObject = ((t.a)localObject).a(bool1);
      if (paramt.i) {
        break label542;
      }
      if (!localt.i) {
        break label577;
      }
      break label542;
    }
    for (;;)
    {
      label330:
      localObject = ((t.a)localObject).b(bool1);
      if (!paramt.h)
      {
        bool1 = bool2;
        if (localt.h) {}
      }
      for (;;)
      {
        localObject = ((t.a)localObject).c(bool1).a();
        ((t)localObject).j = Math.max(paramt.j, localt.j);
        ((t)localObject).a(paramt.f);
        ((t)localObject).a(localt.f);
        paramt = new a((t)localObject);
        this.c.a((t)localObject, paramt);
        if ((this.p.a) || (((t)localObject).b))
        {
          long l1 = c((t)localObject);
          this.a.postDelayed(paramt, l1);
          if (l1 > 0L) {
            Log.i("ContactsSyncAdapter/delay " + l1);
          }
          if (this.h) {
            this.h = false;
          }
        }
        for (;;)
        {
          return;
          this.b.b = true;
          continue;
          Log.i("ContactsSyncAdapter/freeze until connection returns");
        }
        label527:
        bool1 = true;
        break;
        label532:
        bool1 = true;
        break label261;
        label537:
        bool1 = true;
        break label304;
        label542:
        bool1 = true;
        break label330;
        bool1 = true;
      }
      label552:
      bool1 = false;
      break;
      label557:
      bool1 = false;
      break label214;
      label562:
      bool1 = false;
      break label237;
      label567:
      bool1 = false;
      break label261;
      label572:
      bool1 = false;
      break label304;
      label577:
      bool1 = false;
    }
  }
  
  final long c(t paramt)
  {
    if (paramt.b) {
      return 0L;
    }
    paramt = this.b;
    long l1 = paramt.c;
    return Math.max(paramt.a + l1 - SystemClock.elapsedRealtime(), 0L);
  }
  
  public void onEventAsync(com.whatsapp.g.i parami)
  {
    if (parami.a) {
      this.g.post(d.a(this));
    }
  }
  
  final class a
    implements Runnable
  {
    private final t b;
    private final i c = (i)a.d.a(i.a());
    
    public a(t paramt)
    {
      this.b = paramt;
    }
    
    private static void a(t.b paramb, v paramv)
    {
      paramb = g.a().a(paramb.a);
      if (paramb != null) {
        paramb.a(paramv);
      }
    }
    
    private void a(v paramv)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.b.f.iterator();
      while (localIterator.hasNext())
      {
        t.b localb = (t.b)localIterator.next();
        if (!localb.b)
        {
          localArrayList.add(localb);
          a(localb, paramv);
        }
      }
      this.b.f.removeAll(localArrayList);
      if (!this.b.f.isEmpty())
      {
        this.b.b = false;
        a.c(a.this, this.b);
      }
    }
    
    private void b(v paramv)
    {
      Iterator localIterator = this.b.f.iterator();
      while (localIterator.hasNext()) {
        a((t.b)localIterator.next(), paramv);
      }
    }
    
    public final void run()
    {
      a.a(a.this, this.b);
      boolean bool4 = this.b.g;
      boolean bool5 = this.b.i;
      boolean bool6 = this.b.h;
      if ((this.b.d) && ((a.a(a.this).b == null) || (!a.b(a.this).b())))
      {
        Log.i("ContactsSyncAdapter/registration not complete");
        b(v.d);
      }
      label261:
      label423:
      o localo;
      for (;;)
      {
        a.b(a.this, this.b);
        return;
        if (!a.c(a.this).b())
        {
          Log.i("ContactsSyncAdapter/no-network");
          a(v.a);
        }
        else if (Voip.e())
        {
          Log.i("ContactsSyncAdapter/voip-active-delay");
          a(v.e);
        }
        else
        {
          boolean bool1 = bool4;
          boolean bool2 = bool5;
          boolean bool3 = bool6;
          if (this.b.a.a())
          {
            if ((!bool4) || (a.d(a.this).h() <= System.currentTimeMillis())) {
              break label261;
            }
            Log.i("ContactsSyncAdapter/contact backoff for another " + (a.d(a.this).h() - System.currentTimeMillis()) + "ms");
            bool1 = false;
            bool3 = bool6;
            bool2 = bool5;
          }
          for (;;)
          {
            if ((bool1) || (bool2) || (bool3)) {
              break label423;
            }
            b(v.e);
            break;
            if ((bool5) && (a.d(a.this).i() > System.currentTimeMillis()))
            {
              Log.i("ContactsSyncAdapter/status backoff for another " + (a.d(a.this).i() - System.currentTimeMillis()) + "ms");
              bool2 = false;
              bool1 = bool4;
              bool3 = bool6;
            }
            else
            {
              bool1 = bool4;
              bool2 = bool5;
              bool3 = bool6;
              if (bool6)
              {
                bool1 = bool4;
                bool2 = bool5;
                bool3 = bool6;
                if (a.d(a.this).j() > System.currentTimeMillis())
                {
                  Log.i("ContactsSyncAdapter/feature backoff for another " + (a.d(a.this).j() - System.currentTimeMillis()) + "ms");
                  bool3 = false;
                  bool1 = bool4;
                  bool2 = bool5;
                }
              }
            }
          }
          localo = h.a(this.b);
          long l1 = vv.e();
          localObject3 = a.e(a.this);
          Object localObject4 = a.f(a.this);
          Object localObject5 = a.g(a.this);
          Object localObject1 = com.whatsapp.k.c.a("SystemContactsQuery_getUpdatedRows");
          ((com.whatsapp.k.d)localObject1).a();
          localObject4 = a.a.a.a.d.a((and)localObject4, (atu)localObject5);
          if (localObject4 == null) {}
          for (localObject3 = new cp(Collections.emptyList(), Collections.emptyMap(), (byte)0);; localObject3 = new cp((List)localObject3, (Map)localObject4, (byte)0))
          {
            localo.k = Long.valueOf(((cp)localObject3).b.size() + ((cp)localObject3).a.size());
            if ((((cp)localObject3).a()) || (!this.b.c)) {
              break label707;
            }
            Log.i("ContactsSyncAdapter/no_change");
            b(v.c);
            h.b(localo);
            break;
            ((com.whatsapp.k.d)localObject1).a(d.b.b, ((Map)localObject4).size());
            Log.i("system-contacts-query/all/" + ((Map)localObject4).size());
            localObject3 = ((com.whatsapp.data.e)localObject3).b.a((Map)localObject4);
            ((com.whatsapp.k.d)localObject1).a(d.b.c, ((Map)localObject4).size() + ((List)localObject3).size());
            ((com.whatsapp.k.d)localObject1).b();
            Log.i("system-contacts-query/updated/" + ((Map)localObject4).size());
          }
          label707:
          localObject1 = a.h(a.this).a(this.b.a, bool1, bool2, bool3, this.b.k, localo);
          if (((v)localObject1).a())
          {
            Log.i("ContactsSyncAdapter/success");
            int i;
            if (localObject1 == v.b)
            {
              i = 1;
              if (i == 0)
              {
                a.j(a.this).a(a.i(a.this));
                a.j(a.this).a(new f(this));
              }
              b(v.c);
              if (!this.b.e) {}
            }
            try
            {
              a.a.a.a.d.a(a.k(a.this), a.g(a.this));
              if (this.b.a.a())
              {
                if (bool1)
                {
                  localObject1 = a.d(a.this);
                  l2 = System.currentTimeMillis();
                  localObject1 = ((atv)localObject1).c();
                  ((SharedPreferences.Editor)localObject1).putLong("last_contact_full_sync", l2);
                  ((SharedPreferences.Editor)localObject1).apply();
                }
                if (bool2)
                {
                  localObject1 = a.d(a.this);
                  l2 = System.currentTimeMillis();
                  localObject1 = ((atv)localObject1).c();
                  ((SharedPreferences.Editor)localObject1).putLong("last_status_full_sync", l2);
                  ((SharedPreferences.Editor)localObject1).apply();
                }
                if (bool3)
                {
                  localObject1 = a.d(a.this);
                  l2 = System.currentTimeMillis();
                  localObject1 = ((atv)localObject1).c();
                  ((SharedPreferences.Editor)localObject1).putLong("last_feature_full_sync", l2);
                  ((SharedPreferences.Editor)localObject1).apply();
                }
              }
              try
              {
                localObject5 = this.c;
                localContext = a.k(a.this);
                localAccountManager = AccountManager.get(localContext);
                localObject1 = localAccountManager.getAccountsByType("com.whatsapp");
                if (localObject1.length != 0) {
                  break label1308;
                }
                localObject4 = ((i)localObject5).a(localContext, localAccountManager);
                localObject1 = localObject4;
                if (localObject4 != null) {
                  break label1373;
                }
                localObject1 = null;
                if ((a.a.a.a.d.d(a.k(a.this)) != 2) && (!a.a.a.a.d.a(a.k(a.this), a.e(a.this), (Account)localObject1, a.a.a.a.d.d(a.k(a.this))))) {
                  continue;
                }
                a.a.a.a.d.a(a.k(a.this), a.e(a.this), a.g(a.this), a.d(a.this), (Account)localObject1, ((cp)localObject3).b.keySet());
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  Context localContext;
                  AccountManager localAccountManager;
                  Object localObject2;
                  Log.e(localException2);
                }
              }
              localObject1 = a.e(a.this);
              localObject4 = a.d(a.this);
              if (((cp)localObject3).a()) {
                ((com.whatsapp.data.e)localObject1).b.a((cp)localObject3);
              }
              i = ((atv)localObject4).u() + 1;
              Log.i("wa-shared-preferences/setversion=" + i);
              ((atv)localObject4).c().putInt("contact_version", i).apply();
              h.a(localo);
              long l2 = vv.e();
              if (l1 - l2 > 1073741824L)
              {
                Log.w("ContactSyncAdapter/excessive internal storage used before: " + l1 + " now" + l2);
                a.l(a.this).a("sync consumed excessive storage space", false, null, 3);
                continue;
                i = 0;
              }
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                b(v.d);
                continue;
                label1308:
                localObject4 = localException1[0];
                localObject2 = localObject4;
                if (!TextUtils.equals(localContext.getString(2131298233), ((Account)localObject4).name))
                {
                  localAccountManager.removeAccount((Account)localObject4, null, null);
                  localObject4 = ((i)localObject5).a(localContext, localAccountManager);
                  localObject2 = localObject4;
                  if (localObject4 == null)
                  {
                    localObject2 = null;
                    continue;
                  }
                }
                label1373:
                if (!ContentResolver.getSyncAutomatically((Account)localObject2, "com.android.contacts")) {
                  ContentResolver.setSyncAutomatically((Account)localObject2, "com.android.contacts", true);
                }
                ContentResolver.addPeriodicSync((Account)localObject2, "com.android.contacts", new Bundle(), 3600L);
              }
            }
          }
        }
      }
      Log.i("ContactsSyncAdapter/failure");
      Object localObject3 = this.b;
      ((t)localObject3).j += 1;
      if (((t)localObject3).j >= 100)
      {
        a.l(a.this).a("Contact sync retry exceeds 100", false, null, -1);
        b(v.d);
      }
      for (;;)
      {
        h.c(localo);
        break;
        a(localException2);
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/contact/sync/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */