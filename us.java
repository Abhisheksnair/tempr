package com.whatsapp;

import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.whatsapp.data.ab;
import com.whatsapp.data.ad;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.gcm.RegistrationIntentService;
import com.whatsapp.jobqueue.job.SendWebForwardJob;
import com.whatsapp.location.bp;
import com.whatsapp.messaging.ag;
import com.whatsapp.messaging.aj;
import com.whatsapp.messaging.w;
import com.whatsapp.notification.f;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.j.c;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.b;
import com.whatsapp.util.bu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class us
  extends ab
{
  private static volatile us g;
  boolean a;
  final e b;
  final aj c;
  final ag d;
  final com.whatsapp.data.m e;
  boolean f;
  private final va h;
  private final w i;
  private final ad j;
  private final adp k;
  private final com.whatsapp.messaging.m l;
  private final mf m;
  private final ph n;
  private final abu o;
  private final b p;
  private final dh q;
  private final ane r;
  private final ai s;
  private final f t;
  private final atv u;
  private final vs v;
  private final bp w;
  
  private us(va paramva, w paramw, ad paramad, adp paramadp, e parame, com.whatsapp.messaging.m paramm, aj paramaj, mf parammf, ph paramph, abu paramabu, b paramb, dh paramdh, ane paramane, ai paramai, f paramf, atv paramatv, vs paramvs, ag paramag, com.whatsapp.data.m paramm1, bp parambp)
  {
    this.h = paramva;
    this.i = paramw;
    this.j = paramad;
    this.k = paramadp;
    this.b = parame;
    this.l = paramm;
    this.c = paramaj;
    this.m = parammf;
    this.n = paramph;
    this.o = paramabu;
    this.p = paramb;
    this.q = paramdh;
    this.r = paramane;
    this.s = paramai;
    this.t = paramf;
    this.u = paramatv;
    this.v = paramvs;
    this.d = paramag;
    this.e = paramm1;
    this.w = parambp;
  }
  
  public static us a()
  {
    if (g == null) {}
    try
    {
      if (g == null) {
        g = new us(va.a(), w.a(), ad.a(), adp.a(), e.a(), com.whatsapp.messaging.m.a(), aj.a(), mf.a(), ph.a(), abu.a(), b.a(), dh.a(), ane.a(), ai.a(), f.a(), atv.a(), vs.a(), ag.a(), com.whatsapp.data.m.a(), bp.a());
      }
      return g;
    }
    finally {}
  }
  
  private void a(long paramLong)
  {
    if ((!this.n.c) && (paramLong > 900000L) && (this.l.j()))
    {
      RegistrationIntentService.a(u.a());
      this.r.a("com.google.process.gapps");
      this.n.c = true;
    }
  }
  
  private void a(String paramString, j paramj)
  {
    Log.i(paramString + paramj.e.c + " " + this.h.b() + " " + paramj.e.a + " " + paramj.f);
  }
  
  public final void a(j paramj)
  {
    if (paramj != null)
    {
      a("app/message/received/duplicate ", paramj);
      if (paramj.e.b) {
        break label35;
      }
      this.k.a(this.j, paramj);
    }
    label35:
    do
    {
      do
      {
        return;
        if (paramj.d != 6) {
          break;
        }
        if ((paramj instanceof qz.a))
        {
          this.i.a(((qz.a)paramj).a);
          return;
        }
      } while (paramj.t != 6L);
      this.k.a(paramj.e.c, paramj.e.a, "picture");
      return;
    } while (!paramj.M.a());
    this.c.a(paramj.e.c, 200);
    this.k.a(paramj.e.c, this.h.c().t, "web");
  }
  
  public final void a(j paramj, int paramInt)
  {
    boolean bool2 = false;
    switch (paramInt)
    {
    case 0: 
    case 2: 
    case 7: 
    default: 
      Log.w("app/messagechanged unknown type " + paramInt);
    case 8: 
    case 1: 
    case 4: 
    case 3: 
    case 5: 
    case 6: 
    case -1: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                Object localObject2;
                do
                {
                  return;
                  Log.d("app/msgchanged/locationormediaupload/send " + paramj.e.c);
                  if (com.whatsapp.protocol.m.a(paramj.s))
                  {
                    this.v.a(paramj.e.a).b(paramj);
                    return;
                  }
                  this.i.a(paramj, false, 0L);
                  bu.a(ut.a(this, paramj));
                  return;
                  localObject2 = paramj.b();
                } while ((localObject2 == null) || (!((MediaData)localObject2).transferred));
                if (((MediaData)localObject2).refKey == null)
                {
                  Object localObject3 = this.i;
                  localObject1 = paramj.p;
                  bool1 = ((MediaData)localObject2).dedupeDownload;
                  if (((w)localObject3).b.d)
                  {
                    localObject2 = ((w)localObject3).b;
                    localObject3 = Message.obtain(null, 0, 33, 0);
                    ((Message)localObject3).getData().putString("url", (String)localObject1);
                    ((Message)localObject3).getData().putBoolean("dedupe", bool1);
                    ((com.whatsapp.messaging.m)localObject2).a((Message)localObject3);
                  }
                }
              } while (paramj.a());
              MediaFileUtils.a(u.a(), paramj);
              if ((paramj.s != 2) || (paramj.o != 1)) {
                break;
              }
              Object localObject1 = this.t;
              boolean bool1 = bool2;
              if (paramj.R != null)
              {
                bool1 = bool2;
                if (this.f) {
                  bool1 = true;
                }
              }
              ((f)localObject1).a(paramj, bool1);
            } while (paramj.R == null);
            this.f = true;
            return;
          } while ((Build.VERSION.SDK_INT < 16) || (Conversation.l().a(paramj.e.a)));
          this.t.b();
          return;
          this.t.a(paramj, false);
          return;
          Log.d("app/msgchanged/futureproofreplaced " + paramj.e.c);
          return;
        } while ((!paramj.e.b) || (paramj.d != 0));
        if (paramj.M == j.c.d)
        {
          paramj.M = j.c.a;
          this.c.a(paramj.e.c, 408);
          return;
        }
      } while (paramj.M == j.c.c);
      this.c.a(paramj.e, paramj.d);
      return;
    }
    Log.d("app/msgchanged/edit " + paramj.e);
  }
  
  public final void a(j paramj, boolean paramBoolean)
  {
    if (paramj != null)
    {
      a("app/message/received/newurl ", paramj);
      Log.i("app/message/received/newurl " + paramBoolean);
      this.k.a(this.j, paramj);
      if ((!paramj.e.b) && (paramBoolean) && (this.s.a(paramj)) && (this.s.b(paramj))) {
        vc.a().a(paramj);
      }
    }
  }
  
  public final void a(Collection<j> paramCollection, String paramString, Map<String, Integer> paramMap, boolean paramBoolean)
  {
    if (paramMap != null)
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        paramString = (Collection)localHashMap.get(localj.e.a);
        paramCollection = paramString;
        if (paramString == null)
        {
          paramCollection = new ArrayList();
          localHashMap.put(localj.e.a, paramCollection);
        }
        paramCollection.add(localj);
      }
      bu.a(uy.a(this, localHashMap, paramMap, paramBoolean));
    }
  }
  
  public final void a(Collection<j> paramCollection, Map<String, Integer> paramMap)
  {
    if (paramMap != null)
    {
      Object localObject2 = new HashMap();
      Object localObject3 = paramCollection.iterator();
      Object localObject4;
      Object localObject1;
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (j)((Iterator)localObject3).next();
        localObject1 = (Collection)((HashMap)localObject2).get(((j)localObject4).e.a);
        paramCollection = (Collection<j>)localObject1;
        if (localObject1 == null)
        {
          paramCollection = new ArrayList();
          ((HashMap)localObject2).put(((j)localObject4).e.a, paramCollection);
        }
        paramCollection.add(localObject4);
      }
      paramCollection = ((HashMap)localObject2).entrySet().iterator();
      if (paramCollection.hasNext())
      {
        localObject4 = (Map.Entry)paramCollection.next();
        localObject1 = (Integer)paramMap.get(((Map.Entry)localObject4).getKey());
        localObject2 = this.c;
        localObject3 = (String)((Map.Entry)localObject4).getKey();
        localObject4 = (Collection)((Map.Entry)localObject4).getValue();
        if (localObject1 == null) {}
        for (int i1 = 0;; i1 = ((Integer)localObject1).intValue())
        {
          ((aj)localObject2).a((String)localObject3, (Collection)localObject4, i1);
          break;
        }
      }
    }
  }
  
  public final void b()
  {
    if (this.e.b())
    {
      w localw = this.i;
      Runnable localRunnable = uz.a(this);
      localw.b.a(Message.obtain(null, 0, 22, 0, localRunnable));
    }
  }
  
  public final void b(j paramj, int paramInt)
  {
    if ((paramj.R != null) && (!this.a) && (paramj.s != 8) && (paramj.s != 10) && (System.currentTimeMillis() - paramj.n > 900000L))
    {
      this.a = true;
      if (this.l.j())
      {
        this.u.a(this.u.d() + 1);
        Log.d("app/msg/offline/logincount " + this.u.d());
        if (!this.l.j()) {
          this.l.b();
        }
      }
    }
  }
  
  public final void c(j paramj, int paramInt)
  {
    long l1;
    String str;
    Object localObject2;
    Object localObject1;
    if ((paramj != null) && (paramj.s != 8) && (paramj.s != 10) && (paramj.s != 15)) {
      if (!paramj.e.b)
      {
        l1 = System.currentTimeMillis() - paramj.n;
        str = paramj.e.a;
        localObject2 = this.b.a(str);
        Log.d("msgadded/recvdelay=" + l1 + " offline=" + paramj.R + " notified_off=" + this.f + " jid=" + str + " refresh_reqtd=" + this.n.c);
        if (this.o.a(str, paramj.f) >= 0)
        {
          this.o.b(str, paramj.f);
          this.q.d(str);
        }
        if ((((cs)localObject2).d()) || (paramj.a())) {
          if (paramj.f != null)
          {
            localObject1 = this.b.d(paramj.f);
            if (TextUtils.isEmpty(paramj.D)) {
              Log.w("msgadded/from_name is empty  jid:" + str + " message:" + paramj.e.toString());
            }
            if ((localObject1 != null) && (!TextUtils.isEmpty(paramj.D)) && (!paramj.D.equals(((cs)localObject1).q)))
            {
              ((cs)localObject1).q = paramj.D;
              this.m.a(uu.a(this, (cs)localObject1));
            }
            if ((this.s.a(paramj, (cs)localObject2, (cs)localObject1)) && (this.s.b(paramj))) {
              vc.a().a(paramj);
            }
            if (com.whatsapp.protocol.m.d(paramj))
            {
              long l2 = paramj.n;
              long l3 = paramj.w * 1000;
              this.w.a(paramj, l2 + l3);
            }
            if (!paramj.aa) {
              break label496;
            }
            if (paramj.R == null) {
              break label425;
            }
            a(l1);
            if (!this.f) {
              break label425;
            }
          }
        }
      }
    }
    label425:
    label496:
    label800:
    label1139:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            localObject1 = null;
            break;
            localObject1 = localObject2;
            break;
            this.f = true;
            this.t.c();
            Log.d("msgadded/statusbar/cancel");
            if (Conversation.w) {
              this.p.a(Uri.parse("android.resource://com.whatsapp/2131165187"));
            }
            if (auj.c()) {
              paramj.M = j.c.b;
            }
            do
            {
              bu.a(uv.a(this, paramj));
              this.k.a(this.j, paramj);
              return;
              if (Build.VERSION.SDK_INT >= 16) {
                this.t.a(str, paramj);
              }
            } while ((paramj.s == 11) || ((paramj.s == 2) && (paramj.o == 1)));
            localObject1 = this.t;
            if ((paramj.R != null) && (this.f)) {}
            for (bool = true;; bool = false)
            {
              ((f)localObject1).a(paramj, bool);
              if (paramj.R == null) {
                break;
              }
              this.f = true;
              a(l1);
              break;
            }
            if (paramj.M.a())
            {
              localObject1 = this.h.c().t;
              if (((String)localObject1).equals(paramj.e.a))
              {
                this.c.a(paramj.e.c, 200);
                this.k.a(paramj.e.c, (String)localObject1, "web");
                return;
              }
              if ((paramj.s == 5) && (paramj.b() != null) && ((paramj.N instanceof MediaData))) {
                paramj.b().transferred = true;
              }
              for (;;)
              {
                this.i.a(paramj, false, 0L);
                break;
                if (com.whatsapp.protocol.m.a(paramj.s)) {
                  vc.a().a(paramj, vk.a.b);
                }
              }
            }
            if (!(this.h.b() + "@s.whatsapp.net").equals(paramj.e.a)) {
              break label800;
            }
            Log.d("ignore message sent to self");
          } while (paramj.a());
          bu.a(uw.a(this, paramj));
          return;
          if (!paramj.a()) {
            bu.a(ux.a(this, paramj));
          }
          if (((paramInt == -1) || (paramInt == 7)) && (paramj.d != 6)) {
            this.i.a(paramj, false, 0L);
          }
          if ((qz.a(paramj)) && (!paramj.aa))
          {
            if (Build.VERSION.SDK_INT >= 16) {
              this.t.a(paramj.e.a, paramj);
            }
            this.t.a(paramj, false);
          }
          if ((paramj.d == 6) && ((paramj instanceof qz.a))) {
            this.i.a(((qz.a)paramj).a);
          }
        } while ((paramj.d != 6) || (paramj.t != 6L));
        this.k.a(paramj.e.c, paramj.e.a, "picture");
        return;
        if (paramj.s != 10) {
          break label1139;
        }
        localObject2 = this.c;
      } while ((!auj.c()) || (paramj == null) || (paramj.n == 0L));
      localObject1 = paramj.e.c;
      localObject2 = ((aj)localObject2).c;
      str = paramj.e.a;
      l1 = paramj.n / 1000L;
      boolean bool = paramj.e.b;
      paramj = paramj.z;
      Bundle localBundle = new Bundle();
      localBundle.putString("id", (String)localObject1);
      localBundle.putString("jid", str);
      localBundle.putBoolean("owner", bool);
      localBundle.putLong("timestamp", l1);
      localBundle.putString("participant", null);
      localBundle.putString("kind", paramj);
      ((att)localObject2).a(new SendWebForwardJob((String)localObject1, Message.obtain(null, 0, 110, 0, localBundle)));
      return;
    } while (paramj.s != 15);
    if (!paramj.e.b)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.t.a(paramj.e.a, paramj);
      }
      this.t.a(paramj, true);
      this.c.a(paramj);
      return;
    }
    if (paramj.M.a())
    {
      if (this.h.a(paramj.e.a)) {
        this.c.a(paramj.e.c, 200);
      }
      for (;;)
      {
        this.k.a(paramj.e.c, this.h.c().t, "web");
        return;
        this.i.a(paramj, false, 0L);
      }
    }
    if (this.h.a(paramj.e.a))
    {
      Log.d("ignore revoke sent to self");
      this.c.a(paramj);
      return;
    }
    this.i.a(paramj, false, 0L);
    this.c.a(paramj);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/us.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */