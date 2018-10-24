package com.whatsapp;

import a.a.a.a.a.a.d;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.google.protobuf.an;
import com.whatsapp.contact.sync.ContactSyncManager;
import com.whatsapp.contact.sync.ContactSyncManager.ParcelableSyncUser;
import com.whatsapp.contact.sync.ContactSyncManager.a;
import com.whatsapp.contact.sync.ContactSyncManager.c;
import com.whatsapp.contact.sync.t.a;
import com.whatsapp.data.ProfilePhotoChange;
import com.whatsapp.data.ad;
import com.whatsapp.data.ad.b;
import com.whatsapp.data.ad.i;
import com.whatsapp.data.ak;
import com.whatsapp.data.bk;
import com.whatsapp.data.cb;
import com.whatsapp.data.cb.b;
import com.whatsapp.data.cb.d;
import com.whatsapp.data.ch;
import com.whatsapp.data.ci;
import com.whatsapp.data.ck;
import com.whatsapp.data.ck.a;
import com.whatsapp.data.cn;
import com.whatsapp.data.co;
import com.whatsapp.data.cs;
import com.whatsapp.data.cu;
import com.whatsapp.data.y;
import com.whatsapp.fieldstats.events.ax;
import com.whatsapp.fieldstats.events.bj;
import com.whatsapp.gcm.RegistrationIntentService;
import com.whatsapp.jobqueue.job.GetVNameCertificateJob;
import com.whatsapp.jobqueue.job.RehydrateHsmJob;
import com.whatsapp.jobqueue.job.SendE2EMessageJob;
import com.whatsapp.messaging.ac;
import com.whatsapp.messaging.bm;
import com.whatsapp.proto.E2E.Message;
import com.whatsapp.proto.E2E.Message.Chat;
import com.whatsapp.proto.E2E.Message.SenderKeyDistributionMessage;
import com.whatsapp.proto.E2E.Message.SenderKeyDistributionMessage.a;
import com.whatsapp.proto.E2E.Message.a;
import com.whatsapp.protocol.af;
import com.whatsapp.protocol.aj;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.z;
import com.whatsapp.service.GcmFGService;
import com.whatsapp.util.Log;
import com.whatsapp.util.ar;
import com.whatsapp.util.bu;
import com.whatsapp.util.w.a;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import org.whispersystems.a.g;

final class aed
  implements bm
{
  final ci A;
  final rh B;
  private final ant C;
  private final aaq D;
  private final anv E;
  private final oz F;
  private final od G;
  private final aic H;
  private final mg I;
  private final com.whatsapp.l.e J;
  private final com.whatsapp.data.s K;
  private final com.whatsapp.messaging.m L;
  private final aob M;
  private final mf N;
  private final pc O;
  private final abu P;
  private final aq Q;
  private final com.whatsapp.contact.sync.i R;
  private final sr S;
  private final rk T;
  private final y U;
  private final vv V;
  private final ContactSyncManager W;
  private final com.whatsapp.b.a X;
  private final atv Y;
  private final com.whatsapp.twofactor.q Z;
  final Handler a = new Handler(Looper.getMainLooper());
  private final com.whatsapp.data.m aa;
  private final Handler ab;
  final Context b;
  final pv c;
  final com.whatsapp.util.a.c d;
  final va e;
  final com.whatsapp.data.d f;
  final com.whatsapp.messaging.w g;
  final ad h;
  final adp i;
  final att j;
  final com.whatsapp.data.e k;
  final abp l;
  final aus m;
  final com.whatsapp.util.b n;
  final com.whatsapp.data.l o;
  final dh p;
  final com.whatsapp.util.w q;
  final qz r;
  final af s;
  final co t;
  final ai u;
  final aat v;
  final acm w;
  final com.whatsapp.a.c x;
  final ck y;
  final com.whatsapp.messaging.i z;
  
  aed(Context paramContext, ant paramant, pv parampv, aaq paramaaq, com.whatsapp.util.a.c paramc, va paramva, anv paramanv, com.whatsapp.data.d paramd, oz paramoz, od paramod, com.whatsapp.messaging.w paramw, aic paramaic, ad paramad, adp paramadp, att paramatt, mg parammg, com.whatsapp.l.e parame, com.whatsapp.data.e parame1, com.whatsapp.data.s params, com.whatsapp.messaging.m paramm, abp paramabp, aob paramaob, aus paramaus, mf parammf, pc parampc, abu paramabu, com.whatsapp.util.b paramb, aq paramaq, com.whatsapp.data.l paraml, dh paramdh, com.whatsapp.contact.sync.i parami, com.whatsapp.util.w paramw1, qz paramqz, sr paramsr, rk paramrk, y paramy, vv paramvv, af paramaf, ContactSyncManager paramContactSyncManager, co paramco, ai paramai, com.whatsapp.b.a parama, aat paramaat, acm paramacm, com.whatsapp.a.c paramc1, atv paramatv, ck paramck, com.whatsapp.twofactor.q paramq, com.whatsapp.messaging.i parami1, com.whatsapp.data.m paramm1, ci paramci, rh paramrh)
  {
    this.b = ((Context)a.d.a(paramContext));
    this.C = ((ant)a.d.a(paramant));
    this.c = ((pv)a.d.a(parampv));
    this.D = ((aaq)a.d.a(paramaaq));
    this.d = ((com.whatsapp.util.a.c)a.d.a(paramc));
    this.e = ((va)a.d.a(paramva));
    this.E = ((anv)a.d.a(paramanv));
    this.f = ((com.whatsapp.data.d)a.d.a(paramd));
    this.F = ((oz)a.d.a(paramoz));
    this.G = ((od)a.d.a(paramod));
    this.g = ((com.whatsapp.messaging.w)a.d.a(paramw));
    this.H = ((aic)a.d.a(paramaic));
    this.h = ((ad)a.d.a(paramad));
    this.i = ((adp)a.d.a(paramadp));
    this.j = ((att)a.d.a(paramatt));
    this.I = ((mg)a.d.a(parammg));
    this.J = ((com.whatsapp.l.e)a.d.a(parame));
    this.k = ((com.whatsapp.data.e)a.d.a(parame1));
    this.K = ((com.whatsapp.data.s)a.d.a(params));
    this.L = ((com.whatsapp.messaging.m)a.d.a(paramm));
    this.l = ((abp)a.d.a(paramabp));
    this.M = ((aob)a.d.a(paramaob));
    this.m = ((aus)a.d.a(paramaus));
    this.N = ((mf)a.d.a(parammf));
    this.O = ((pc)a.d.a(parampc));
    this.P = ((abu)a.d.a(paramabu));
    this.n = ((com.whatsapp.util.b)a.d.a(paramb));
    this.Q = ((aq)a.d.a(paramaq));
    this.o = ((com.whatsapp.data.l)a.d.a(paraml));
    this.p = ((dh)a.d.a(paramdh));
    this.R = ((com.whatsapp.contact.sync.i)a.d.a(parami));
    this.q = ((com.whatsapp.util.w)a.d.a(paramw1));
    this.r = ((qz)a.d.a(paramqz));
    this.S = ((sr)a.d.a(paramsr));
    this.T = ((rk)a.d.a(paramrk));
    this.U = ((y)a.d.a(paramy));
    this.V = ((vv)a.d.a(paramvv));
    this.s = ((af)a.d.a(paramaf));
    this.W = ((ContactSyncManager)a.d.a(paramContactSyncManager));
    this.t = ((co)a.d.a(paramco));
    this.u = ((ai)a.d.a(paramai));
    this.X = ((com.whatsapp.b.a)a.d.a(parama));
    this.v = ((aat)a.d.a(paramaat));
    this.w = ((acm)a.d.a(paramacm));
    this.x = ((com.whatsapp.a.c)a.d.a(paramc1));
    this.Y = ((atv)a.d.a(paramatv));
    this.y = ((ck)a.d.a(paramck));
    this.Z = ((com.whatsapp.twofactor.q)a.d.a(paramq));
    this.z = ((com.whatsapp.messaging.i)a.d.a(parami1));
    this.aa = ((com.whatsapp.data.m)a.d.a(paramm1));
    this.A = ((ci)a.d.a(paramci));
    this.B = ((rh)a.d.a(paramrh));
    this.ab = new Handler(Looper.getMainLooper(), aee.a(paramatv, parami, paramm));
  }
  
  public final void a()
  {
    this.Q.g();
  }
  
  public final void a(int paramInt)
  {
    Log.e("app/xmpp/recv/clientConfigError/" + paramInt);
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, Runnable paramRunnable)
  {
    if ((paramString != null) && (paramArrayOfByte2 != null))
    {
      cb localcb = this.h.c;
      paramArrayOfByte1 = new cb.b(paramInt, paramArrayOfByte1, paramArrayOfByte3);
      localcb.b.put(new cb.d(paramString, paramArrayOfByte2), paramArrayOfByte1);
    }
    for (;;)
    {
      if (paramRunnable != null) {
        paramRunnable.run();
      }
      return;
      Log.w("app/xmpp/recv/get-ck/file is null");
    }
  }
  
  public final void a(long paramLong, int paramInt)
  {
    boolean bool = true;
    anv localanv = this.E;
    if (paramInt == 1) {}
    for (;;)
    {
      localanv.a(paramLong, bool);
      b.a.a.c.a().b(new anv.a(paramLong, paramInt));
      return;
      bool = false;
    }
  }
  
  public final void a(Bundle paramBundle)
  {
    Log.d("app/xmpp/recv/service_pricing " + paramBundle);
  }
  
  public final void a(ace paramace)
  {
    int i1 = 2;
    if (paramace.d == -1)
    {
      Object localObject = this.q;
      Context localContext;
      if (paramace.c == 1)
      {
        localObject = ((com.whatsapp.util.w)localObject).c.b(paramace.a);
        if (localObject != null)
        {
          localContext = u.a();
          if (paramace.c != 1) {
            break label108;
          }
        }
      }
      for (;;)
      {
        pb.a(localContext, 3, i1, SystemClock.elapsedRealtime() - ((Long)localObject).longValue(), 0L);
        this.w.a(paramace.a);
        return;
        if (paramace.c == 2)
        {
          localObject = ((com.whatsapp.util.w)localObject).c.b(paramace.a);
          break;
        }
        localObject = null;
        break;
        label108:
        i1 = 1;
      }
    }
    if (paramace.e != null)
    {
      acx.a(paramace);
      return;
    }
    ace.a(this.c, this.h, this.k, this.N, this.p, this.q, paramace);
  }
  
  public final void a(com.whatsapp.protocol.al paramal)
  {
    Log.i(this.G.a(u.a(), "", null, null, true, -1L, -1L, "NotCalculated"));
    this.d.a(false, true, false, false, null, null, null);
    this.g.a(paramal);
  }
  
  public final void a(com.whatsapp.protocol.al paramal, long paramLong1, long paramLong2)
  {
    Log.d("app/xmpp/recv/sync_notify_do_full_sync; stanzaKey=" + paramal + "; beforeTimestamp=" + paramLong1 + "; afterTimestamp=" + paramLong2);
    if ((paramLong2 > paramLong1) && (paramLong1 > 0L) && (paramLong2 > 0L)) {
      this.ab.sendEmptyMessageDelayed(0, paramLong2 - paramLong1);
    }
    for (;;)
    {
      Message.obtain(this.ab, 1, paramal).sendToTarget();
      return;
      this.ab.sendEmptyMessage(0);
    }
  }
  
  public final void a(final com.whatsapp.protocol.al paramal, final j.b paramb, byte[] paramArrayOfByte1, final int paramInt, final long paramLong, final byte[] paramArrayOfByte2, final byte[] paramArrayOfByte3, final byte paramByte, final aj paramaj)
  {
    final int i1 = a.a.a.a.d.f(paramArrayOfByte1);
    Log.i("axolotl got retry request " + paramInt + " for " + paramb + " with " + i1 + " originally sent at " + paramLong);
    if (paramInt > 4)
    {
      Log.w("axolotl skipping retry for " + paramb);
      this.g.a(paramal);
      return;
    }
    com.whatsapp.a.c.a.execute(new Runnable()
    {
      public final void run()
      {
        boolean bool2 = qz.e(paramb.a);
        boolean bool3 = com.whatsapp.protocol.j.b(paramb.a);
        if ((!bool2) && (!bool3) && (paramArrayOfByte2 != null) && (paramArrayOfByte3 != null) && (paramaj != null)) {}
        try
        {
          aed.this.x.a(paramb.a, paramArrayOfByte2, paramByte, null, paramaj, paramArrayOfByte3);
          aed.this.a.post(new aex(paramb));
          localj = aed.this.o.a(paramb);
          aed.this.s.a(localj);
          localObject3 = aed.this.y.a(paramb).a;
          if ((bool2) || (bool3))
          {
            Object localObject1 = paramal.e;
            localObject1 = (ad.i)((ConcurrentHashMap)localObject3).get(localObject1);
            if ((localObject1 == null) || (((ad.i)localObject1).a(5) <= 0L)) {
              break label838;
            }
            bool1 = true;
            if ((!bool2) && (!bool3)) {
              break label1047;
            }
            localObject4 = paramal.a;
            str = paramal.e;
            Log.i("axolotl checking group/broadcast list membership due to retry receipt; key=" + paramb + "; aggregateJid=" + (String)localObject4 + "; individualJid=" + str);
            localObject1 = aed.this.B.a((String)localObject4);
            if (((rg)localObject1).a(str) == null) {
              break label844;
            }
            bool2 = true;
            if (localj != null) {
              break label850;
            }
            Log.w("original message has been deleted; message.key=" + paramb);
            bool1 = false;
            if ((bool2) || (bool1))
            {
              Log.i("axolotl resending group/broadcast list message; message.key=" + paramb + "; participant=" + str + "; isCurrentlyInGroup=" + bool2 + "; wasInGroupAtTimeOfMessage=" + bool1);
              localObject1 = E2E.Message.newBuilder();
              if (bool2)
              {
                localObject3 = new org.whispersystems.a.c.e((String)localObject4, com.whatsapp.a.c.a(aed.this.e.b() + "@s.whatsapp.net"));
                localObject3 = new org.whispersystems.a.c.d(aed.this.x.d).a((org.whispersystems.a.c.e)localObject3).a();
                ((E2E.Message.a)localObject1).getSenderKeyDistributionMessageBuilder().setGroupId((String)localObject4);
                ((E2E.Message.a)localObject1).getSenderKeyDistributionMessageBuilder().setAxolotlSenderKeyDistributionMessage(com.google.protobuf.e.a((byte[])localObject3));
              }
              if (bool1) {
                a.a.a.a.d.a(aed.this.e, localj, (E2E.Message.a)localObject1, false, false, false);
              }
              E2E.Message localMessage = ((E2E.Message.a)localObject1).build();
              localObject3 = null;
              Object localObject5 = com.whatsapp.a.c.a(str);
              localObject1 = localObject3;
              if (aed.this.x.d((org.whispersystems.a.m)localObject5))
              {
                Log.i("axolotl checking conditions for group retry to individual; message.key=" + paramb + "; individualJid=" + str);
                localObject5 = aed.this.x.c((org.whispersystems.a.m)localObject5);
                if (paramInt < 2)
                {
                  localObject1 = localObject3;
                  if (((org.whispersystems.a.h.e)localObject5).a().i() == i1) {}
                }
                else
                {
                  Log.i("axolotl requiring new session before resending; message.key=" + paramb + "; individualJid=" + str);
                  localObject1 = ((org.whispersystems.a.h.e)localObject5).a().a();
                }
              }
              long l1 = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
              localObject3 = aed.this.j;
              localObject5 = paramb.c;
              int n = paramInt;
              long l2 = paramLong;
              if (localj == null) {
                break label1031;
              }
              k = localj.i();
              if (localj == null) {
                break label1036;
              }
              m = localj.ab;
              if ((localj == null) || (localj.s != 15)) {
                break label1041;
              }
              bool1 = true;
              ((att)localObject3).a(new SendE2EMessageJob(localMessage, (String)localObject5, (String)localObject4, str, n, null, null, (byte[])localObject1, false, l1 + 86400000L, l2, k, m, null, bool1));
            }
            aed.this.g.a(paramal);
          }
        }
        catch (org.whispersystems.a.n localn)
        {
          final com.whatsapp.protocol.j localj;
          Object localObject3;
          boolean bool1;
          Object localObject4;
          for (;;)
          {
            String str;
            int k;
            int m;
            Log.e(localn);
            continue;
            localObject2 = paramal.a;
            continue;
            bool1 = false;
            continue;
            bool2 = false;
            continue;
            if (bool1)
            {
              Log.w("original message already marked delivered; message.key=" + paramb);
              bool1 = false;
              com.whatsapp.fieldstats.l.a(aed.this.b, new com.whatsapp.fieldstats.events.w());
            }
            else if (TextUtils.isEmpty(localj.g))
            {
              Log.w("axolotl found no participant hash; message.key=" + paramb);
              bool1 = false;
            }
            else if (TextUtils.equals(((rg)localObject2).d, localj.g))
            {
              bool1 = bool2;
            }
            else
            {
              localObject2 = aed.this.A.a((String)localObject4, localj.g);
              if (localObject2 == null)
              {
                Log.w("axolotl could not figure out historic group/broadcast membership; message.key=" + paramb);
                bool1 = false;
              }
              else
              {
                bool1 = ((Set)localObject2).contains(str);
                continue;
                k = 0;
                continue;
                m = 0;
                continue;
                bool1 = false;
              }
            }
          }
          Object localObject2 = com.whatsapp.a.c.a(paramb.a);
          Log.i("axolotl checking sessions for " + localObject2 + " due to retry receipt for " + paramb);
          if (aed.this.x.d((org.whispersystems.a.m)localObject2))
          {
            localObject3 = aed.this.x.c((org.whispersystems.a.m)localObject2);
            localObject4 = ((org.whispersystems.a.h.e)localObject3).a().a();
            if (((org.whispersystems.a.h.e)localObject3).a().i() != i1)
            {
              Log.i("axolotl deleting session due to registration id change for " + paramb);
              aed.this.x.e((org.whispersystems.a.m)localObject2);
              aed.this.x.b((org.whispersystems.a.m)localObject2);
              aed.this.a.post(new a(true, paramLong, (byte[])localObject4, bool1, localj));
              return;
            }
            if ((paramInt > 2) && (aed.this.x.a((org.whispersystems.a.m)localObject2, paramb)))
            {
              Log.i("axolotl will wait to send " + paramb + " until a new prekey has been fetched");
              aed.this.a.post(new a(true, paramLong, (byte[])localObject4, bool1, localj));
              return;
            }
            if (paramInt == 2)
            {
              Log.i("axolotl will record the base key used to send " + paramb);
              aed.this.x.a(paramb, (byte[])localObject4);
            }
          }
          aed.this.a.post(new a(false, paramLong, null, bool1, localj));
          return;
        }
        catch (org.whispersystems.a.e locale)
        {
          label838:
          label844:
          label850:
          label1031:
          label1036:
          label1041:
          label1047:
          for (;;) {}
        }
      }
      
      final class a
        implements Runnable
      {
        private final boolean d;
        private final long e;
        private final byte[] f;
        
        a(long paramLong, byte[] paramArrayOfByte)
        {
          this.d = paramLong;
          this.e = ???;
          byte[] arrayOfByte1;
          this.f = arrayOfByte1;
        }
        
        public final void run()
        {
          aed.this.g.a(aed.2.this.f);
          if (localj)
          {
            Log.w("original message already marked delivered; message.key=" + aed.2.this.a);
            com.whatsapp.fieldstats.l.a(aed.this.b, new com.whatsapp.fieldstats.events.w());
            return;
          }
          if (this.b != null)
          {
            Log.i("axolotl resending " + aed.2.this.a);
            this.b.l = aed.2.this.g;
            if (this.d)
            {
              Log.i("axolotl reinjecting send e2e job; originalMessageKey=" + aed.2.this.a);
              E2E.Message.a locala = E2E.Message.newBuilder();
              a.a.a.a.d.a(aed.this.e, this.b, locala, false, false, false);
              long l = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
              aed.this.j.a(new SendE2EMessageJob(locala.build(), aed.2.this.a.c, aed.2.this.a.a, null, aed.2.this.g, null, null, this.f, false, l + 86400000L, this.e, this.b.i(), this.b.ab, null, false));
              return;
            }
            Log.i("axolotl resending " + aed.2.this.a + " immediately");
            aed.this.g.a(this.b, false, this.e);
            return;
          }
          Log.i("axolotl unable to resend " + aed.2.this.a + "; message gone");
        }
      }
    });
  }
  
  public final void a(com.whatsapp.protocol.al paramal, j.b paramb, int[] paramArrayOfInt)
  {
    Log.i("axolotl got a server enc v2 unknown tags receipt; stanzaKey=" + paramal + "; originalMessageKey=" + paramb + "; unknownTags=" + Arrays.toString(paramArrayOfInt));
    this.g.a(paramal);
  }
  
  public final void a(com.whatsapp.protocol.al paramal, List<z> paramList)
  {
    Log.i("capability notification: " + paramal);
    bu.a(aeh.a(this, paramal, paramList));
  }
  
  public final void a(com.whatsapp.protocol.al paramal, byte[] paramArrayOfByte)
  {
    t.a locala = new t.a(com.whatsapp.contact.sync.w.f);
    locala.b = true;
    paramArrayOfByte = locala.a(paramArrayOfByte).a();
    this.R.b(paramArrayOfByte);
    this.g.a(paramal);
  }
  
  public final void a(j.b paramb, int paramInt)
  {
    this.S.a(paramb);
    boolean bool = qz.e(paramb.a);
    Object localObject2;
    Object localObject3;
    if ((bool) && (paramInt == 401))
    {
      localObject1 = this.h;
      localObject2 = this.C;
      localObject3 = new com.whatsapp.protocol.j(this.e, paramb.a, null);
      ((com.whatsapp.protocol.j)localObject3).n = ((ant)localObject2).b();
      ((com.whatsapp.protocol.j)localObject3).d = 6;
      ((com.whatsapp.protocol.j)localObject3).t = 8L;
      ((ad)localObject1).b((com.whatsapp.protocol.j)localObject3, -1);
      localObject1 = this.o.a(paramb);
      if (localObject1 != null)
      {
        ((com.whatsapp.protocol.j)localObject1).d = 7;
        this.h.e((com.whatsapp.protocol.j)localObject1, -1);
        if (this.B.b(paramb.a))
        {
          this.r.b(paramb.a, this.e.c().t);
          paramb = this.c;
          localObject1 = this.p;
          localObject1.getClass();
          paramb.a(aew.a((dh)localObject1));
        }
      }
    }
    label464:
    label810:
    label821:
    label856:
    label877:
    label925:
    label946:
    do
    {
      do
      {
        long l1;
        for (;;)
        {
          return;
          Log.w("app/xmpp/recv/messageerror/bounce unable to find message " + paramb);
          break;
          if ((!bool) || (paramInt != 409)) {
            break label877;
          }
          this.g.d(paramb.a, null);
          localObject1 = this.o.a(paramb);
          if (localObject1 == null) {
            break label856;
          }
          localObject2 = this.A.a(paramb.a, ((com.whatsapp.protocol.j)localObject1).g);
          if (localObject2 == null) {
            break label821;
          }
          Log.i("app/xmpp/recv/messageerror/phashmismatch found match for group participants for " + paramb + " at phash " + ((com.whatsapp.protocol.j)localObject1).g);
          paramb = this.e.c();
          if (paramb != null) {
            ((Set)localObject2).remove(paramb.t);
          }
          if (((com.whatsapp.protocol.j)localObject1).s != 0) {
            break label464;
          }
          Log.i("app/xmpp/recv/messageerror/phashmismatch all members capable of receiving encrypted group message, sending client 1-1 e2e fanout");
          l1 = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
          paramb = E2E.Message.newBuilder().setConversation(((com.whatsapp.protocol.j)localObject1).e()).build();
          localObject2 = ((Set)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            this.j.a(new SendE2EMessageJob(paramb, ((com.whatsapp.protocol.j)localObject1).e.c, ((com.whatsapp.protocol.j)localObject1).e.a, (String)localObject3, 0, null, null, null, false, 86400000L + l1, 0L, ((com.whatsapp.protocol.j)localObject1).i(), ((com.whatsapp.protocol.j)localObject1).ab, null, false));
          }
        }
        ((com.whatsapp.protocol.j)localObject1).d = 0;
        ((com.whatsapp.protocol.j)localObject1).h = ((String[])a.a.a.a.d.a((Collection)localObject2, new String[((Set)localObject2).size()]));
        localObject2 = this.h;
        ((ad)localObject2).i.lock();
        for (;;)
        {
          try
          {
            ((ad)localObject2).w.b();
            if ((((com.whatsapp.protocol.j)localObject1).d != 9) && (((com.whatsapp.protocol.j)localObject1).d != 10) && (((com.whatsapp.protocol.j)localObject1).d != 11) && (((com.whatsapp.protocol.j)localObject1).d != 12) && (((com.whatsapp.protocol.j)localObject1).d != 0)) {
              break label810;
            }
            if ((!((com.whatsapp.protocol.j)localObject1).e.b) && (((com.whatsapp.protocol.j)localObject1).s == 2) && (((com.whatsapp.protocol.j)localObject1).o == 1) && ((((com.whatsapp.protocol.j)localObject1).d == 9) || (((com.whatsapp.protocol.j)localObject1).d == 10)))
            {
              paramb = ((ad)localObject2).w.g;
              paramb.bindLong(1, ((com.whatsapp.protocol.j)localObject1).d);
              paramb.bindLong(2, System.currentTimeMillis());
              paramb.bindString(3, ((com.whatsapp.protocol.j)localObject1).e.a);
              if (((com.whatsapp.protocol.j)localObject1).e.b)
              {
                l1 = 1L;
                paramb.bindLong(4, l1);
                paramb.bindString(5, ((com.whatsapp.protocol.j)localObject1).e.c);
                paramb.execute();
                ((ad)localObject2).i.unlock();
                this.K.a((com.whatsapp.protocol.j)localObject1, -1);
                this.M.b();
                return;
              }
              l1 = 0L;
              continue;
            }
            paramb = ((ad)localObject2).w.f;
            paramb.bindLong(1, ((com.whatsapp.protocol.j)localObject1).d);
            paramb.bindString(2, ((com.whatsapp.protocol.j)localObject1).e.a);
            if (((com.whatsapp.protocol.j)localObject1).e.b)
            {
              l1 = 1L;
              paramb.bindLong(3, l1);
              paramb.bindString(4, ((com.whatsapp.protocol.j)localObject1).e.c);
              continue;
            }
            l1 = 0L;
          }
          finally
          {
            ((ad)localObject2).i.unlock();
          }
          continue;
          ((ad)localObject2).i.unlock();
        }
        Log.w("app/xmpp/recv/messageerror/phashmismatch unable to compute group participants for " + paramb + " at phash " + ((com.whatsapp.protocol.j)localObject1).g);
        return;
        Log.w("app/xmpp/recv/messageerror/phashmismatch unable to find message " + paramb);
        return;
        if (paramInt != 405) {
          break label946;
        }
        localObject1 = this.o.a(paramb);
        if (localObject1 == null) {
          break label925;
        }
      } while (!com.whatsapp.protocol.m.d((com.whatsapp.protocol.j)localObject1));
      ((com.whatsapp.protocol.j)localObject1).d = 7;
      this.h.e((com.whatsapp.protocol.j)localObject1, -1);
      return;
      Log.w("app/xmpp/recv/messageerror/bounce unable to find message " + paramb);
      return;
    } while ((bool) || (paramInt != 403));
    Object localObject1 = this.o.a(paramb);
    if (localObject1 != null)
    {
      ((com.whatsapp.protocol.j)localObject1).d = 7;
      this.h.e((com.whatsapp.protocol.j)localObject1, -1);
      return;
    }
    Log.w("app/xmpp/recv/messageerror/bounce unable to find message " + paramb);
  }
  
  public final void a(final j.b paramb, final String paramString)
  {
    Log.i("app/xmpp/recv/message/servererrorfortarget; id=" + paramb.c + "; participant=" + paramString);
    if ((paramb.a.endsWith("broadcast")) && (paramString != null) && (!paramb.a.equals("status@broadcast"))) {
      paramb = new j.b(paramString, paramb.b, paramb.c);
    }
    for (;;)
    {
      this.S.a(paramb);
      final com.whatsapp.protocol.j localj = this.o.a(paramb);
      if (localj == null)
      {
        Log.i("app/xmpp/recv/message/servererrorfortarget/messagemissing");
        return;
      }
      if (!com.whatsapp.protocol.m.a(localj.s))
      {
        Log.e("app/xmpp/recv/message/servererrorfortarget/wrongtype");
        return;
      }
      MediaData localMediaData = null;
      if ((localj.N instanceof MediaData)) {
        localMediaData = new MediaData(localj.b());
      }
      if ((localMediaData == null) || (localMediaData.file == null))
      {
        Log.e("app/xmpp/recv/message/servererrorfortarget/badmediadata; mediaData=" + localMediaData);
        return;
      }
      if (!localMediaData.file.exists())
      {
        Log.i("app/xmpp/recv/message/servererrorfortarget/filemissing");
        return;
      }
      if ((localMediaData.fileSize != 0L) && (localMediaData.fileSize != localMediaData.file.length()))
      {
        Log.i("app/xmpp/recv/message/servererrorfortarget/filereplaced; mediaData.fileSize=" + localMediaData.fileSize + "; mediaData.file.length=" + localMediaData.file.length());
        return;
      }
      int i1 = this.v.a(true);
      if ((!this.u.a(i1, localj)) && ((localj.s != 1) || (i1 == 0) || (i1 == 3)))
      {
        Log.i("app/xmpp/recv/message/servererrorfortarget/skipreupload; activeNetworkType=" + i1 + "; message.media_wa_type=" + localj.s + "; message.origin=" + localj.o + "; message.media_size=" + localj.t);
        return;
      }
      localMediaData.autodownloadRetryEnabled = true;
      localj = new com.whatsapp.protocol.j(localj);
      localj.N = localMediaData;
      localj.p = null;
      new xg(this.c, this.e, this.F, this.H, this.h, this.J, this.U, this.V, this.Y, this.B, new aoi(Collections.singletonList(localj)), localj, paramb, paramString)
      {
        public final void a(xg.c paramAnonymousc)
        {
          super.a(paramAnonymousc);
          if ((paramAnonymousc == xg.c.a) && (this.n))
          {
            k();
            localj.A = true;
            if (!this.k) {
              break label138;
            }
            Object localObject = aed.this.g;
            paramAnonymousc = paramb.c;
            String str1 = paramb.a;
            String str2 = paramString;
            if (((com.whatsapp.messaging.w)localObject).b.d)
            {
              localObject = ((com.whatsapp.messaging.w)localObject).b;
              Message localMessage = Message.obtain(null, 0, 34, 0);
              localMessage.getData().putString("id", paramAnonymousc);
              localMessage.getData().putString("jid", str1);
              localMessage.getData().putString("participant", str2);
              ((com.whatsapp.messaging.m)localObject).a(localMessage);
            }
          }
          return;
          label138:
          aed.this.g.a(localj, false, 0L);
        }
      }.j();
      return;
    }
  }
  
  public final void a(j.b paramb, String paramString, int paramInt, long paramLong)
  {
    int i1 = 5;
    if ((paramInt == 5) || (paramInt == 13) || (paramInt == 8))
    {
      if ((paramInt != 13) || (this.i.a(paramb.a))) {
        break label151;
      }
      paramInt = i1;
    }
    label151:
    for (;;)
    {
      ad localad = this.h;
      if (!paramb.b) {
        Log.e("msgstore/updatetargetstatus/error " + paramb.a + " " + paramb.c);
      }
      for (;;)
      {
        com.whatsapp.a.c.a.execute(aer.a(this, paramb));
        return;
        localad.g.remove(paramb);
        localad.d.post(com.whatsapp.data.al.a(localad, paramb, paramString, paramInt, paramLong));
      }
      this.h.a(paramb, paramInt, null);
      return;
    }
  }
  
  public final void a(j.b paramb, String paramString1, String paramString2, int paramInt, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      Log.i("message received by server ignored; key=" + paramb + "; participant=" + paramString1 + "; serverParticipantHash=" + paramString2 + "; recipientCount=" + paramInt + "; timestamp=" + paramLong);
    }
    do
    {
      return;
      this.S.a(paramb);
      if ((!TextUtils.isEmpty(paramString2)) && (qz.e(paramb.a)) && (!TextUtils.equals(this.B.a(paramb.a).d, paramString2))) {
        this.g.d(paramb.a, "phash");
      }
      paramString1 = this.h;
      paramString2 = aes.a(this, paramb);
      paramString1.g.remove(paramb);
      paramString1.d.post(ak.a(paramString1, paramb, paramInt, paramLong, paramString2));
      paramb = u.a();
    } while (Boolean.FALSE.equals(a.a.a.a.d.aL));
    a.a.a.a.d.aL = Boolean.FALSE;
    android.support.v4.app.aw.a(paramb).a(9);
  }
  
  public final void a(com.whatsapp.protocol.j paramj)
  {
    boolean bool = false;
    Log.i("app/xmpp/recv/message " + paramj.e.c + ' ' + paramj.n + ' ' + System.currentTimeMillis() + ' ' + paramj.l + ' ' + paramj.ab);
    if ((paramj.s != 0) && (paramj.N == null)) {
      paramj.N = new MediaData();
    }
    if ((com.whatsapp.protocol.m.a(paramj.s)) && (paramj.A)) {
      Message.obtain(this.h.d, 11, -1, 0, paramj).sendToTarget();
    }
    for (;;)
    {
      vc localvc = vc.a();
      if (paramj.R != null) {
        bool = true;
      }
      localvc.a(bool);
      return;
      if ((paramj.a()) && (paramj.n + 86400000L < this.C.b()) && (paramj.i == null)) {
        this.i.a(paramj, "status-old");
      } else {
        com.whatsapp.a.c.a.execute(new a(paramj));
      }
    }
  }
  
  public final void a(Exception paramException)
  {
    Log.w("capability read error: " + paramException);
  }
  
  public final void a(String paramString)
  {
    bu.a(aet.a(paramString));
  }
  
  public final void a(String paramString, int paramInt)
  {
    Long localLong = this.q.b(paramString);
    Context localContext;
    if (localLong != null)
    {
      localContext = u.a();
      if (paramInt == 401)
      {
        i1 = 5;
        pb.a(localContext, i1, 2, SystemClock.elapsedRealtime() - localLong.longValue(), 0L);
      }
    }
    else
    {
      localLong = this.q.c(paramString);
      if (localLong != null)
      {
        localContext = u.a();
        if (paramInt != 401) {
          break label108;
        }
      }
    }
    label108:
    for (int i1 = 5;; i1 = 6)
    {
      pb.a(localContext, i1, 1, SystemClock.elapsedRealtime() - localLong.longValue(), 0L);
      this.w.a(paramString, paramInt);
      return;
      i1 = 6;
      break;
    }
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    ContactSyncManager localContactSyncManager = this.W;
    Log.e("sync/contact/error sid=" + paramString + " index=" + paramInt1 + " code=" + paramInt2 + " backoff=" + paramLong);
    if (paramLong > 0L)
    {
      long l1 = System.currentTimeMillis();
      localContactSyncManager.a.a(l1 + paramLong);
    }
  }
  
  public final void a(String paramString, int paramInt, ContactSyncManager.c paramc)
  {
    Log.i("existencesync/result sid=" + paramString + " index=" + paramInt);
    if (paramc != null)
    {
      a.a.a.a.d.aH = paramc;
      StringBuilder localStringBuilder = new StringBuilder("existencesync/result/user jid=").append(paramc.a).append(" phone=");
      if (paramc.b.size() > 0)
      {
        paramString = (String)paramc.b.get(0);
        paramString = localStringBuilder.append(paramString).append(" wa=");
        if (paramc.c != 1) {
          break label146;
        }
      }
      label146:
      for (boolean bool = true;; bool = false)
      {
        Log.i(bool + " " + paramc.c);
        return;
        paramString = "";
        break;
      }
    }
    a.a.a.a.d.aH = null;
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, ContactSyncManager.ParcelableSyncUser[] paramArrayOfParcelableSyncUser, Map<String, List<z>> paramMap, long paramLong1, long paramLong2, long paramLong3)
  {
    ContactSyncManager localContactSyncManager = this.W;
    Log.i("sync/result sid=" + paramString1 + " index=" + paramInt + " users_count=" + paramArrayOfParcelableSyncUser.length + " version=" + paramString2 + " contactRefreshTime=" + paramLong1 + " statusRefreshTime=" + paramLong2 + " featureRefreshTime=" + paramLong3);
    if (paramLong1 > 0L)
    {
      paramString1 = localContactSyncManager.a;
      paramString2 = paramString1.c();
      paramString2.putLong("contact_full_sync_wait", paramLong1);
      paramString2.apply();
      paramString1.a.getLong("contact_full_sync_wait", -1L);
    }
    if (paramLong2 > 0L)
    {
      paramString1 = localContactSyncManager.a;
      paramString2 = paramString1.c();
      paramString2.putLong("status_full_sync_wait", paramLong2);
      paramString2.apply();
      paramString1.a.getLong("status_full_sync_wait", -1L);
    }
    if (paramLong3 > 0L)
    {
      paramString1 = localContactSyncManager.a;
      paramString2 = paramString1.c();
      paramString2.putLong("feature_full_sync_wait", paramLong3);
      paramString2.apply();
      paramString1.a.getLong("feature_full_sync_wait", -1L);
    }
    paramString1 = localContactSyncManager.b();
    int i1 = paramArrayOfParcelableSyncUser.length;
    paramInt = 0;
    if (paramInt < i1)
    {
      paramString2 = paramArrayOfParcelableSyncUser[paramInt].a;
      if (paramString2.c != 0)
      {
        if (paramString2.c == 3) {
          paramString1.addAll(paramString2.b);
        }
        Iterator localIterator = paramString2.b.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localContactSyncManager.b.put(str, paramString2);
        }
      }
      if (paramString2.d == 1) {
        localContactSyncManager.c.put(paramString2.a, new ContactSyncManager.a(paramString2.e, paramString2.f));
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if (paramString2.d == 2) {
          localContactSyncManager.c.put(paramString2.a, new ContactSyncManager.a(0L, null));
        }
      }
    }
    localContactSyncManager.a(paramString1);
    c(paramMap);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    Log.i("app/xmpp/recv/handle_available " + paramString1 + ' ' + paramString2);
    cs localcs = this.k.a(paramString1);
    boolean bool = this.P.b(paramString1);
    abu localabu = this.P;
    Object localObject = (abu.d)localabu.c.get(paramString1);
    paramString2 = (String)localObject;
    if (localObject == null)
    {
      paramString2 = new abu.d((byte)0);
      localabu.c.put(paramString1, paramString2);
    }
    paramString2.b = 1L;
    this.P.a(paramString1, true);
    if (!bool)
    {
      paramString2 = this.T;
      localObject = localcs.t;
      paramString2.b.removeMessages(2, paramString2.a((String)localObject));
    }
    this.p.d(paramString1);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt)
  {
    abu localabu = this.P;
    Object localObject1 = (abu.d)localabu.c.get(paramString1);
    if (localObject1 == null)
    {
      localObject1 = new abu.d((byte)0);
      localabu.c.put(paramString1, localObject1);
    }
    for (;;)
    {
      if ((paramString2 != null) && (qz.e(paramString1)))
      {
        if (((abu.d)localObject1).e == null) {
          ((abu.d)localObject1).e = new HashMap();
        }
        localObject3 = (abu.a)((abu.d)localObject1).e.get(paramString2);
        localObject2 = localObject3;
        if (localObject3 == null)
        {
          localObject2 = new abu.a((byte)0);
          ((abu.d)localObject1).e.put(paramString2, localObject2);
        }
        ((abu.a)localObject2).a = SystemClock.elapsedRealtime();
        ((abu.a)localObject2).b = paramInt;
      }
      ((abu.d)localObject1).c = SystemClock.elapsedRealtime();
      ((abu.d)localObject1).d = paramInt;
      Object localObject3 = paramString1 + paramString2;
      Object localObject2 = (abu.c)localabu.b.get(localObject3);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new abu.c(localabu, paramString1, paramString2);
        localabu.b.put(localObject3, localObject1);
      }
      localabu.a.removeCallbacks((Runnable)localObject1);
      localabu.a.postDelayed((Runnable)localObject1, 25000L);
      this.p.d(paramString1);
      return;
    }
  }
  
  public final void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    Log.w("recvmessagelistener/on-set-two-factor-auth-error errorCode: " + paramInt + " errorMessage: " + paramString3);
    this.Z.a(paramString1, paramString2, paramInt, paramString3);
  }
  
  public final void a(String paramString1, String paramString2, long paramLong)
  {
    Log.i("app/xmpp/recv/handle_unavailable " + paramString1 + ' ' + paramString2 + " last:" + paramLong);
    this.k.a(paramString1);
    paramString2 = this.P.a(paramString1, paramLong);
    this.P.a(paramString1, true);
    if (paramString2 != null) {
      this.p.d(paramString2);
    }
    this.p.d(paramString1);
  }
  
  public final void a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    this.N.a(aeu.a(this, paramString2, paramLong, paramString3, paramString1));
  }
  
  public final void a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = this.h;
    ((ad)localObject).d.post(bk.a((ad)localObject, paramString3));
    localObject = this.k.c(paramString3);
    if ((localObject != null) && (((cs)localObject).h))
    {
      ((cs)localObject).h = false;
      this.k.b((cs)localObject);
    }
    paramString3 = this.L;
    if (localObject != null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("msgId", paramString2);
      ((Bundle)localObject).putBoolean("isValid", bool);
      ((Bundle)localObject).putString("toJid", paramString1);
      paramString3.a(Message.obtain(null, 0, 42, 0, localObject));
      return;
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    Object localObject3 = this.k.d(paramString2);
    Object localObject1 = this.e.b();
    if (localObject1 == null) {
      throw new AssertionError("local JID unknown");
    }
    cs localcs;
    if ((paramString3 == null) || (!paramString3.startsWith((String)localObject1)))
    {
      localcs = this.k.d(paramString2);
      if ((localcs.l != paramInt1) || (localcs.m != paramInt1))
      {
        if (paramInt1 != -1) {
          break label293;
        }
        this.w.a(paramString2);
      }
    }
    while ((((cs)localObject3).d()) && (paramString3 != null) && (!paramString3.startsWith((String)localObject1)))
    {
      if (paramString1 != null)
      {
        localObject1 = new com.whatsapp.protocol.j(new j.b(paramString2, true, paramString1));
        label139:
        if (paramInt1 != -1) {
          break label329;
        }
        ((com.whatsapp.protocol.j)localObject1).e((String)localObject2);
        ((com.whatsapp.protocol.j)localObject1).d = 6;
        ((com.whatsapp.protocol.j)localObject1).t = 6L;
        ((com.whatsapp.protocol.j)localObject1).f = paramString3;
        ((com.whatsapp.protocol.j)localObject1).n = (paramInt2 * 1000L);
        localObject2 = ((cs)localObject3).c();
        if (!((File)localObject2).exists()) {}
      }
      try
      {
        localObject3 = new ProfilePhotoChange();
        ((ProfilePhotoChange)localObject3).oldPhoto = a.a.a.a.d.b((File)localObject2);
        ((ProfilePhotoChange)localObject3).newPhotoId = paramInt1;
        ((com.whatsapp.protocol.j)localObject1).N = localObject3;
        localObject2 = this.h.r(paramString2);
        if ((localObject2 == null) || (((com.whatsapp.protocol.j)localObject2).d != 6) || (((com.whatsapp.protocol.j)localObject2).t != 11L) || (!paramString3.equals(((com.whatsapp.protocol.j)localObject2).f)))
        {
          this.h.b((com.whatsapp.protocol.j)localObject1, -1);
          return;
          label293:
          this.N.a(aep.a(this, localcs, paramInt1));
          continue;
          localObject1 = new com.whatsapp.protocol.j(this.e, paramString2, null);
          break label139;
          label329:
          localObject2 = Integer.toString(paramInt1);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.c("app/xmpp/recv/handle_profile_photo_changed/", localIOException);
        }
        this.i.a(paramString1, paramString2, "picture");
        return;
      }
    }
    this.i.a(paramString1, paramString2, "picture");
  }
  
  public final void a(String paramString, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("recvmessagelistener/on-get-biz-vname-cert jid=").append(paramString).append(" certBlob=[");
    if (paramArrayOfByte != null) {}
    for (Object localObject = Integer.valueOf(paramArrayOfByte.length);; localObject = "null")
    {
      Log.i(localObject + "]");
      if (this.k.a(paramString, paramArrayOfByte)) {
        this.c.a(aei.a(this, paramString));
      }
      return;
    }
  }
  
  public final void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, Runnable paramRunnable)
  {
    r.a(paramString, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramArrayOfByte4);
    if (paramRunnable != null) {
      paramRunnable.run();
    }
  }
  
  public final void a(Map<String, String> paramMap)
  {
    if (this.h.z.e)
    {
      if (paramMap.containsKey("groups"))
      {
        Log.i("app/ondirty call refetchGroups");
        this.r.b();
      }
      return;
    }
    Log.i("app/ondirty/prevent-db-access/skip");
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.aa.d();
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Log.i("recvmessagelistener/on-get-two-factor-auth-response code=" + paramBoolean1 + " email=" + paramBoolean2);
    Object localObject = this.Z;
    Log.d("twofactorauthmanager/on-auth-settings-received code [" + paramBoolean1 + "] email [" + paramBoolean2 + "]");
    localObject = ((com.whatsapp.twofactor.q)localObject).e.edit();
    if (paramBoolean2) {}
    for (int i1 = 1;; i1 = 2)
    {
      ((SharedPreferences.Editor)localObject).putInt("two_factor_auth_email_set", i1).apply();
      return;
    }
  }
  
  public final void a(Locale[] paramArrayOfLocale, Locale paramLocale, String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    Log.i("recvmessagelistener/on-get-biz-language-pack locale=" + paramLocale + " hash=" + paramString1 + " ns=" + paramString2);
    this.X.a(paramArrayOfLocale, paramLocale, paramString1, paramString2, paramArrayOfByte);
  }
  
  public final void a(Locale[] paramArrayOfLocale, String[] paramArrayOfString, String paramString, int paramInt)
  {
    Log.i("recvmessagelistener/on-get-biz-language-pack-error requestLocales=" + Arrays.toString(paramArrayOfLocale) + " haveHashes=" + Arrays.toString(paramArrayOfString) + " ns=" + paramString + " errorCode=" + paramInt);
    this.X.a(paramArrayOfLocale, paramString, paramInt);
  }
  
  public final void b()
  {
    this.Q.h();
  }
  
  public final void b(int paramInt)
  {
    Log.d("app/xmpp/recv/offline_complete " + paramInt);
    final Object localObject = this.h;
    Log.i("msgstore/offline-complete");
    Message.obtain(((ad)localObject).d, 12).sendToTarget();
    if (this.Y.b(this.v.a(true)) != 0)
    {
      localObject = vc.a();
      ((vc)localObject).a(false);
      bu.a(new AsyncTask() {}, new Void[0]);
    }
    this.b.stopService(new Intent(this.b, GcmFGService.class));
  }
  
  public final void b(com.whatsapp.protocol.al paramal)
  {
    this.g.h();
    this.g.a(paramal);
  }
  
  public final void b(com.whatsapp.protocol.j paramj)
  {
    Log.i("recvmessagelistener/on-message-server-psa");
    Object localObject = paramj.h();
    try
    {
      localObject = E2E.Message.parseFrom((byte[])localObject);
      com.whatsapp.protocol.j localj = new com.whatsapp.protocol.j(paramj.e);
      if (localObject != null)
      {
        a.a.a.a.d.a(this.e, (E2E.Message)localObject, localj, false, false, false);
        if (!paramj.a()) {
          localj.d = paramj.d;
        }
        for (;;)
        {
          localj.D = this.b.getString(2131298233);
          localj.n = paramj.n;
          this.h.b(localj, -1);
          return;
          localj.f = "0@s.whatsapp.net";
        }
      }
      return;
    }
    catch (com.google.protobuf.q paramj)
    {
      Log.w("recvmessagelistener/on-message-server-psa/invalidproto:" + paramj);
      return;
    }
    catch (ar paramj)
    {
      Log.w("recvmessagelistener/on-message-server-psa/bade2e:" + paramj);
    }
  }
  
  public final void b(String paramString)
  {
    this.Q.d(paramString);
  }
  
  public final void b(String paramString, int paramInt)
  {
    Log.i("recvmessagelistener/on-get-biz-vname-cert-error jid=" + paramString + " errorCode=" + paramInt);
    this.k.c.put(paramString, Long.valueOf(System.currentTimeMillis()));
    b.a.a.c.a().b(new com.whatsapp.g.n(paramString));
  }
  
  public final void b(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    ContactSyncManager localContactSyncManager = this.W;
    Log.e("sync/status/error sid=" + paramString + " index=" + paramInt1 + " code=" + paramInt2 + " backoff=" + paramLong);
    if (paramLong > 0L)
    {
      long l1 = System.currentTimeMillis();
      localContactSyncManager.a.b(l1 + paramLong);
    }
  }
  
  public final void b(String paramString1, String paramString2)
  {
    Log.i("app/xmpp/recv/handle_unsubscribe" + paramString1 + ' ' + paramString2);
    paramString2 = this.k.a(paramString1);
    this.P.a(paramString2.t, false);
    this.p.d(paramString1);
  }
  
  public final void b(String paramString1, String paramString2, String paramString3)
  {
    cs localcs = this.k.c(paramString3);
    if (localcs != null)
    {
      this.N.a(aef.a(this, localcs));
      if (!this.P.b(paramString3))
      {
        this.P.a(paramString3, 0L);
        this.p.d(paramString3);
      }
      if ((Conversation.l().a(localcs.t)) && (!this.O.b())) {
        this.P.a(localcs);
      }
      this.g.a(localcs.t, localcs.v, new Messenger(this.D.e));
      this.g.a(new String[] { localcs.t });
    }
    this.i.a(paramString2, paramString1, "contacts");
  }
  
  public final void b(Map<String, String> paramMap)
  {
    SettingsPrivacy.a(this.g, this.P, paramMap);
  }
  
  public final void c()
  {
    Log.d("app/xmpp/recv/handle_remove_account");
    this.I.b();
  }
  
  public final void c(int paramInt)
  {
    Log.w("capability error response: " + paramInt);
  }
  
  public final void c(com.whatsapp.protocol.al paramal)
  {
    this.g.a(paramal);
  }
  
  public final void c(String paramString)
  {
    Log.i("recvmessagelistener/on-set-biz-vname-cert-success");
    this.Y.i(paramString);
  }
  
  public final void c(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    ContactSyncManager localContactSyncManager = this.W;
    Log.e("sync/feature/error sid=" + paramString + " index=" + paramInt1 + " code=" + paramInt2 + " backoff=" + paramLong);
    if (paramLong > 0L)
    {
      long l1 = System.currentTimeMillis();
      localContactSyncManager.a.c(l1 + paramLong);
    }
  }
  
  public final void c(String paramString1, String paramString2)
  {
    Log.d("received client config from server; platform=" + paramString1 + "; serverToken=" + paramString2);
    RegistrationIntentService.a(u.a(), paramString2);
  }
  
  public final void c(Map<String, List<z>> paramMap)
  {
    bu.a(aeg.a(this, paramMap));
  }
  
  public final void d(int paramInt)
  {
    Log.e("recvmessagelistener/on-set-biz-vname-cert-error/code/" + paramInt);
    this.Y.i(null);
  }
  
  public final void d(com.whatsapp.protocol.al paramal)
  {
    j.b localb = new j.b(paramal.a, false, paramal.c);
    Log.i("media retry notification received; stanzaKey=" + paramal + "; key=" + localb);
    com.whatsapp.protocol.j localj = this.o.a(localb);
    if ((localj != null) && ((localj.s == 1) || (localj.s == 2) || (localj.s == 13) || (localj.s == 3)))
    {
      MediaData localMediaData = localj.b();
      if (localMediaData == null) {
        break label187;
      }
      Log.i("media auto download re-enabled; stanzaKey=" + paramal + "; key=" + localb);
      localMediaData.autodownloadRetryEnabled = true;
      this.h.e(localj, -1);
      if ((this.u.a(localj)) && (this.u.b(localj))) {
        vc.a().a(localj);
      }
    }
    for (;;)
    {
      this.i.a(paramal);
      return;
      label187:
      Log.w("missing media data for media message; stanzaKey=" + paramal + "; key=" + localb);
    }
  }
  
  public final void d(String paramString1, String paramString2)
  {
    this.P.b(paramString1, paramString2);
    this.p.d(paramString1);
  }
  
  public final void e(com.whatsapp.protocol.al paramal)
  {
    Log.i("auth notification received; stanzaKey=" + paramal);
    com.whatsapp.messaging.w localw = this.g;
    org.b.a.a.a locala = org.b.a.a.a.a();
    if (localw.b.d)
    {
      Log.i("sending new auth key; stanzaKey=" + paramal + "; newClientStaticPublic=" + org.whispersystems.a.i.a.b(locala.a.a));
      localw.b.a(Message.obtain(null, 0, 103, 0, Pair.create(paramal, locala)));
    }
  }
  
  /* Error */
  public final void e(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 4
    //   9: aload_0
    //   10: getfield 210	com/whatsapp/aed:i	Lcom/whatsapp/adp;
    //   13: aload_1
    //   14: aload_2
    //   15: ldc_w 1375
    //   18: invokevirtual 1377	com/whatsapp/adp:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_2
    //   22: invokestatic 1665	com/whatsapp/ach:b	(Ljava/lang/String;)Z
    //   25: ifne +209 -> 234
    //   28: aload_0
    //   29: getfield 178	com/whatsapp/aed:e	Lcom/whatsapp/va;
    //   32: invokevirtual 664	com/whatsapp/va:c	()Lcom/whatsapp/va$a;
    //   35: astore_1
    //   36: aload_1
    //   37: ifnull +197 -> 234
    //   40: aload_2
    //   41: aload_1
    //   42: getfield 1213	com/whatsapp/data/cs:t	Ljava/lang/String;
    //   45: invokevirtual 845	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   48: ifeq +186 -> 234
    //   51: aload_1
    //   52: invokevirtual 1667	com/whatsapp/data/cs:b	()Ljava/io/File;
    //   55: astore 9
    //   57: aload_1
    //   58: invokevirtual 1340	com/whatsapp/data/cs:c	()Ljava/io/File;
    //   61: astore_1
    //   62: aload 9
    //   64: invokevirtual 877	java/io/File:exists	()Z
    //   67: ifeq +167 -> 234
    //   70: aload_1
    //   71: invokevirtual 877	java/io/File:exists	()Z
    //   74: ifeq +160 -> 234
    //   77: new 1669	java/io/FileInputStream
    //   80: dup
    //   81: aload_1
    //   82: invokespecial 1672	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   85: astore 6
    //   87: aload_1
    //   88: invokevirtual 885	java/io/File:length	()J
    //   91: l2i
    //   92: newarray <illegal type>
    //   94: astore 10
    //   96: iconst_0
    //   97: istore_3
    //   98: iload_3
    //   99: aload 10
    //   101: arraylength
    //   102: if_icmpge +32 -> 134
    //   105: aload 6
    //   107: aload 10
    //   109: iload_3
    //   110: aload 10
    //   112: arraylength
    //   113: iload_3
    //   114: isub
    //   115: invokevirtual 1676	java/io/FileInputStream:read	([BII)I
    //   118: istore 5
    //   120: iload 5
    //   122: iconst_m1
    //   123: if_icmpeq +11 -> 134
    //   126: iload_3
    //   127: iload 5
    //   129: iadd
    //   130: istore_3
    //   131: goto -33 -> 98
    //   134: new 1669	java/io/FileInputStream
    //   137: dup
    //   138: aload 9
    //   140: invokespecial 1672	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   143: astore_1
    //   144: aload 9
    //   146: invokevirtual 885	java/io/File:length	()J
    //   149: l2i
    //   150: newarray <illegal type>
    //   152: astore 7
    //   154: iload 4
    //   156: istore_3
    //   157: iload_3
    //   158: aload 7
    //   160: arraylength
    //   161: if_icmpge +31 -> 192
    //   164: aload_1
    //   165: aload 7
    //   167: iload_3
    //   168: aload 7
    //   170: arraylength
    //   171: iload_3
    //   172: isub
    //   173: invokevirtual 1676	java/io/FileInputStream:read	([BII)I
    //   176: istore 4
    //   178: iload 4
    //   180: iconst_m1
    //   181: if_icmpeq +11 -> 192
    //   184: iload_3
    //   185: iload 4
    //   187: iadd
    //   188: istore_3
    //   189: goto -32 -> 157
    //   192: aload_0
    //   193: getfield 330	com/whatsapp/aed:w	Lcom/whatsapp/acm;
    //   196: aload_0
    //   197: getfield 362	com/whatsapp/aed:B	Lcom/whatsapp/rh;
    //   200: aload_2
    //   201: aload 7
    //   203: aload 10
    //   205: invokevirtual 1679	com/whatsapp/acm:a	(Lcom/whatsapp/rh;Ljava/lang/String;[B[B)Lcom/whatsapp/ach;
    //   208: astore 7
    //   210: aload 7
    //   212: iconst_1
    //   213: putfield 1681	com/whatsapp/ach:f	Z
    //   216: aload_0
    //   217: getfield 330	com/whatsapp/aed:w	Lcom/whatsapp/acm;
    //   220: aload 7
    //   222: invokevirtual 1684	com/whatsapp/acm:a	(Lcom/whatsapp/ach;)V
    //   225: aload 6
    //   227: invokevirtual 1687	java/io/FileInputStream:close	()V
    //   230: aload_1
    //   231: invokevirtual 1687	java/io/FileInputStream:close	()V
    //   234: return
    //   235: astore 7
    //   237: aconst_null
    //   238: astore_1
    //   239: aload 8
    //   241: astore 6
    //   243: new 378	java/lang/StringBuilder
    //   246: dup
    //   247: ldc_w 1689
    //   250: invokespecial 383	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   253: aload_2
    //   254: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: ldc_w 1691
    //   260: invokevirtual 529	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 391	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: aload 7
    //   268: invokestatic 1693	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   271: aload_1
    //   272: ifnull +7 -> 279
    //   275: aload_1
    //   276: invokevirtual 1687	java/io/FileInputStream:close	()V
    //   279: aload 6
    //   281: ifnull -47 -> 234
    //   284: aload 6
    //   286: invokevirtual 1687	java/io/FileInputStream:close	()V
    //   289: return
    //   290: astore_1
    //   291: return
    //   292: astore_1
    //   293: aconst_null
    //   294: astore 6
    //   296: aload 7
    //   298: astore_2
    //   299: aload 6
    //   301: ifnull +8 -> 309
    //   304: aload 6
    //   306: invokevirtual 1687	java/io/FileInputStream:close	()V
    //   309: aload_2
    //   310: ifnull +7 -> 317
    //   313: aload_2
    //   314: invokevirtual 1687	java/io/FileInputStream:close	()V
    //   317: aload_1
    //   318: athrow
    //   319: astore_2
    //   320: goto -90 -> 230
    //   323: astore_1
    //   324: return
    //   325: astore_1
    //   326: goto -47 -> 279
    //   329: astore 6
    //   331: goto -22 -> 309
    //   334: astore_2
    //   335: goto -18 -> 317
    //   338: astore_1
    //   339: aload 7
    //   341: astore_2
    //   342: goto -43 -> 299
    //   345: astore 7
    //   347: aload_1
    //   348: astore_2
    //   349: aload 7
    //   351: astore_1
    //   352: goto -53 -> 299
    //   355: astore_2
    //   356: aload_1
    //   357: astore 7
    //   359: aload_2
    //   360: astore_1
    //   361: aload 6
    //   363: astore_2
    //   364: aload 7
    //   366: astore 6
    //   368: goto -69 -> 299
    //   371: astore 7
    //   373: aload 6
    //   375: astore_1
    //   376: aload 8
    //   378: astore 6
    //   380: goto -137 -> 243
    //   383: astore 7
    //   385: aload 6
    //   387: astore 8
    //   389: aload_1
    //   390: astore 6
    //   392: aload 8
    //   394: astore_1
    //   395: goto -152 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	this	aed
    //   0	398	1	paramString1	String
    //   0	398	2	paramString2	String
    //   97	92	3	i1	int
    //   7	181	4	i2	int
    //   118	12	5	i3	int
    //   85	220	6	localObject1	Object
    //   329	33	6	localIOException1	IOException
    //   366	25	6	localObject2	Object
    //   1	220	7	localObject3	Object
    //   235	105	7	localIOException2	IOException
    //   345	5	7	localObject4	Object
    //   357	8	7	str	String
    //   371	1	7	localIOException3	IOException
    //   383	1	7	localIOException4	IOException
    //   4	389	8	localObject5	Object
    //   55	90	9	localFile	File
    //   94	110	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   77	87	235	java/io/IOException
    //   284	289	290	java/io/IOException
    //   77	87	292	finally
    //   225	230	319	java/io/IOException
    //   230	234	323	java/io/IOException
    //   275	279	325	java/io/IOException
    //   304	309	329	java/io/IOException
    //   313	317	334	java/io/IOException
    //   87	96	338	finally
    //   98	120	338	finally
    //   134	144	338	finally
    //   144	154	345	finally
    //   157	178	345	finally
    //   192	225	345	finally
    //   243	271	355	finally
    //   87	96	371	java/io/IOException
    //   98	120	371	java/io/IOException
    //   134	144	371	java/io/IOException
    //   144	154	383	java/io/IOException
    //   157	178	383	java/io/IOException
    //   192	225	383	java/io/IOException
  }
  
  public final void f(String paramString1, String paramString2)
  {
    this.N.a(aev.a(this, paramString2, paramString1));
  }
  
  public final void g(String paramString1, String paramString2)
  {
    Log.i("recvmessagelistener/on-set-two-factor-auth-confirmation");
    this.Z.a(paramString1, paramString2, 0);
  }
  
  final class a
    implements Runnable
  {
    private final com.whatsapp.protocol.j b;
    
    a(com.whatsapp.protocol.j paramj)
    {
      this.b = paramj;
    }
    
    private org.whispersystems.a.a a(com.whatsapp.fieldstats.events.u paramu, org.whispersystems.a.m paramm, com.whatsapp.protocol.j paramj, boolean paramBoolean)
    {
      int i;
      if (paramj.j != null) {
        i = paramj.j.a;
      }
      while (i == 1) {
        if (!paramBoolean)
        {
          throw new IllegalStateException("receipt sending has been disabled for a v1 encrypted message");
          if (paramj.i != null) {
            i = paramj.i.a;
          } else {
            i = 0;
          }
        }
        else
        {
          paramu.f = Long.valueOf(1L);
          return new b(paramj);
        }
      }
      if (i == 2)
      {
        paramu.f = Long.valueOf(2L);
        return new c(paramj, paramm, paramu, paramBoolean);
      }
      return new a(paramj, paramu, paramBoolean, i);
    }
    
    private org.whispersystems.a.m a()
    {
      if ((qz.e(this.b.e.a)) || (com.whatsapp.protocol.j.b(this.b.e.a))) {}
      for (Object localObject = this.b.f;; localObject = this.b.e.a) {
        try
        {
          localObject = com.whatsapp.a.c.a((String)localObject);
          return (org.whispersystems.a.m)localObject;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          if (!this.b.k) {
            break;
          }
          aed.this.a.post(new ac(aed.this.g, aed.this.j, aed.this.h, aed.this.x, this.b, false));
        }
      }
      return null;
    }
    
    private void a(com.whatsapp.fieldstats.events.u paramu, org.whispersystems.a.m paramm, org.whispersystems.a.a parama, com.whatsapp.protocol.j paramj, com.whatsapp.protocol.f paramf)
    {
      Object localObject;
      if (paramf.b == 0)
      {
        paramu.e = Integer.valueOf(0);
        localObject = aed.this;
        try
        {
          new org.whispersystems.a.l(((aed)localObject).x, ((aed)localObject).x, ((aed)localObject).x.e, ((aed)localObject).x, paramm).a(new org.whispersystems.a.f.f(paramf.c), parama);
          return;
        }
        catch (org.whispersystems.a.j paramm)
        {
          Log.c("axolotl", paramm);
          paramj.k = true;
          paramu.a = Boolean.valueOf(false);
          paramu.b = Integer.valueOf(6);
          return;
        }
      }
      if (paramf.b == 1)
      {
        paramu.e = Integer.valueOf(1);
        localObject = aed.this;
        try
        {
          new org.whispersystems.a.l(((aed)localObject).x, ((aed)localObject).x, ((aed)localObject).x.e, ((aed)localObject).x, paramm).a(new org.whispersystems.a.f.c(paramf.c), parama);
          return;
        }
        catch (org.whispersystems.a.f paramm)
        {
          Log.c("axolotl", paramm);
          paramj.k = true;
          paramu.a = Boolean.valueOf(false);
          paramu.b = Integer.valueOf(3);
          return;
        }
        catch (org.whispersystems.a.n paramm)
        {
          Log.c("axolotl", paramm);
          paramu.a = Boolean.valueOf(false);
          paramu.b = Integer.valueOf(5);
          return;
        }
        catch (org.whispersystems.a.e paramm)
        {
          Log.c("axolotl", paramm);
          paramj.k = true;
          paramu.a = Boolean.valueOf(false);
          paramu.b = Integer.valueOf(4);
          return;
        }
      }
      if (paramf.b == 2)
      {
        paramu.e = Integer.valueOf(2);
        aed localaed = aed.this;
        for (;;)
        {
          try
          {
            if (!com.whatsapp.protocol.j.b(paramj.f)) {
              break label455;
            }
            localObject = paramj.f;
            paramm = new org.whispersystems.a.c.e((String)localObject, paramm);
            new org.whispersystems.a.c.c(localaed.x.d, paramm).a(paramf.c, parama);
            return;
          }
          catch (org.whispersystems.a.j paramm)
          {
            Log.c("axolotl", paramm);
            paramj.k = true;
            paramu.a = Boolean.valueOf(false);
            paramu.b = Integer.valueOf(6);
          }
          if ((!paramj.a()) || (paramj.ab != 7) || (localaed.t.a(paramj.f) == null)) {
            break;
          }
          paramu = localaed.k.c(paramj.f);
          if ((paramu != null) && (paramu.d != null)) {
            break;
          }
          Log.i("axolotl skciphertextDecrypt failed on status revoke with valid status and unknown contact");
          paramu = new bj();
          paramu.b = Boolean.valueOf(true);
          com.whatsapp.fieldstats.l.c(u.a(), paramu);
          return;
          label455:
          localObject = paramj.e.a;
        }
      }
      Log.w("axolotl unrecognized ciphertext type; message.key=" + paramj.e + " type=" + paramf.b);
      paramu.a = Boolean.valueOf(false);
      paramu.b = Integer.valueOf(8);
    }
    
    private boolean a(org.whispersystems.a.m paramm, com.whatsapp.fieldstats.events.u paramu)
    {
      for (;;)
      {
        try
        {
          paramu.a = Boolean.valueOf(true);
          Object localObject = this.b;
          if (this.b.j != null) {
            continue;
          }
          bool = true;
          localObject = a(paramu, paramm, (com.whatsapp.protocol.j)localObject, bool);
          org.whispersystems.a.a locala = a(paramu, paramm, this.b, true);
          com.whatsapp.protocol.j localj = this.b;
          if (localj.i != null) {
            a(paramu, paramm, (org.whispersystems.a.a)localObject, localj, localj.i);
          }
          if (localj.j != null) {
            a(paramu, paramm, locala, localj, localj.j);
          }
        }
        catch (g paramm)
        {
          boolean bool;
          Log.c("axolotl", paramm);
          this.b.k = true;
          paramu.a = Boolean.valueOf(false);
          paramu.b = Integer.valueOf(0);
          aed.this.i.a(aed.this.h, this.b);
          continue;
        }
        catch (org.whispersystems.a.b paramm)
        {
          Log.c("axolotl", paramm);
          aed.this.i.a(aed.this.h, this.b);
          return false;
        }
        catch (org.whispersystems.a.i paramm)
        {
          Log.c("axolotl", paramm);
          paramu.a = Boolean.valueOf(false);
          paramu.b = Integer.valueOf(1);
          aed.this.i.a(aed.this.h, this.b);
          continue;
        }
        catch (org.whispersystems.a.h paramm)
        {
          Log.c("axolotl", paramm);
          paramu.a = Boolean.valueOf(false);
          paramu.b = Integer.valueOf(2);
          aed.this.i.a(aed.this.h, this.b);
          continue;
        }
        return true;
        bool = false;
      }
    }
    
    public final void run()
    {
      Log.i("axolotl received a message; message.key=" + this.b.e + "; message.retryCount=" + this.b.l + "; message.remote_resource=" + this.b.f);
      int i;
      int j;
      if (this.b.O != null)
      {
        i = a.a.a.a.d.f(this.b.O);
        j = aed.this.x.i();
        Log.i("received a registration id with message; message.key=" + this.b.e + "; message.remote_resource=" + this.b.f + "; serverRegistrationId=" + i + "; localRegistrationId=" + j);
        if (i != j)
        {
          Log.i("registration id received with message did not match local; message.key=" + this.b.e + "; message.remote_resource=" + this.b.f + "; serverRegistrationId=" + i + "; localRegistrationId=" + j);
          if (aed.this.l.a) {
            break label388;
          }
          aed.this.x.f();
          aed.this.l.b();
        }
      }
      Object localObject1 = new com.whatsapp.fieldstats.events.u();
      ((com.whatsapp.fieldstats.events.u)localObject1).c = Long.valueOf(this.b.l);
      if (qz.e(this.b.e.a)) {
        ((com.whatsapp.fieldstats.events.u)localObject1).d = Integer.valueOf(1);
      }
      Object localObject2;
      for (;;)
      {
        localObject2 = aed.this.z.a(this.b.e.a);
        if ((localObject2 != null) && (!aed.this.z.a((com.whatsapp.messaging.h)localObject2)))
        {
          ((com.whatsapp.messaging.h)localObject2).d = System.currentTimeMillis();
          aed.this.z.b((com.whatsapp.messaging.h)localObject2);
        }
        localObject2 = a();
        if ((localObject2 != null) && (a((org.whispersystems.a.m)localObject2, (com.whatsapp.fieldstats.events.u)localObject1))) {
          break label518;
        }
        return;
        label388:
        Log.i("pre keys already sent on this connection; not sending at this time; message.key=" + this.b.e + "; message.remote_resource=" + this.b.f + "; serverRegistrationId=" + i + "; localRegistrationId=" + j);
        break;
        if (com.whatsapp.protocol.j.c(this.b.e.a)) {
          ((com.whatsapp.fieldstats.events.u)localObject1).d = Integer.valueOf(3);
        } else if (cs.e(this.b.f)) {
          ((com.whatsapp.fieldstats.events.u)localObject1).d = Integer.valueOf(2);
        } else {
          ((com.whatsapp.fieldstats.events.u)localObject1).d = Integer.valueOf(0);
        }
      }
      label518:
      label537:
      long l1;
      boolean bool;
      if (((com.whatsapp.fieldstats.events.u)localObject1).a.booleanValue())
      {
        com.whatsapp.fieldstats.l.b(u.a(), (com.whatsapp.fieldstats.e)localObject1);
        localObject1 = aed.this;
        localObject2 = this.b;
        if (((((com.whatsapp.protocol.j)localObject2).s == 5) || (((com.whatsapp.protocol.j)localObject2).s == 16)) && (!((com.whatsapp.protocol.j)localObject2).f().d()))
        {
          ((com.whatsapp.protocol.j)localObject2).b().transferring = true;
          localObject2 = new aed.1((aed)localObject1, (com.whatsapp.protocol.j)localObject2);
          ((aed)localObject1).a.post(new aeq((AsyncTask)localObject2));
        }
        localObject2 = aed.this;
        localObject1 = this.b;
        l1 = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
        long l2 = ((com.whatsapp.protocol.j)localObject1).n;
        Object localObject3 = ((aed)localObject2).e;
        if (localObject1 != null)
        {
          localObject2 = new ax();
          ((ax)localObject2).f = Double.valueOf(l1 - l2);
          ((ax)localObject2).b = Integer.valueOf(a.a.a.a.d.a((com.whatsapp.protocol.j)localObject1));
          ((ax)localObject2).a = Integer.valueOf(a.a.a.a.d.b((com.whatsapp.protocol.j)localObject1));
          if ((((ax)localObject2).a.intValue() == 1) || (((ax)localObject2).a.intValue() == 3))
          {
            localObject3 = a.a.a.a.d.a((va)localObject3, (com.whatsapp.protocol.j)localObject1);
            if (localObject3 != null) {
              ((ax)localObject2).d = ((Boolean)localObject3);
            }
          }
          if (((com.whatsapp.protocol.j)localObject1).R == null) {
            break label1106;
          }
          bool = true;
          label770:
          ((ax)localObject2).e = Boolean.valueOf(bool);
          com.whatsapp.fieldstats.l.b(u.a(), (com.whatsapp.fieldstats.e)localObject2);
        }
        Statistics.a((com.whatsapp.protocol.j)localObject1);
        if (com.whatsapp.gcm.a.a.a == null) {
          break label1112;
        }
        i = 1;
        label801:
        if ((i != 0) && (((com.whatsapp.protocol.j)localObject1).e != null) && (((com.whatsapp.protocol.j)localObject1).e.c != null)) {
          break label1117;
        }
      }
      for (;;)
      {
        localObject1 = aed.this.k.a(this.b.e.a);
        if (!((cs)localObject1).h)
        {
          ((cs)localObject1).h = true;
          bu.a(new aey(this, (cs)localObject1));
        }
        if ((((cs)localObject1).d()) && (!aed.this.B.b(((cs)localObject1).t)))
        {
          aed.this.r.a(((cs)localObject1).t, aed.this.e.c().t);
          aed.this.w.a(((cs)localObject1).t, 0, 2);
        }
        if (!this.b.k) {
          break;
        }
        if ((!this.b.a()) || (this.b.ab != 7)) {
          break label1250;
        }
        if (this.b.R == null) {
          break label1160;
        }
        localObject1 = aed.this.h;
        localObject2 = this.b;
        ((com.whatsapp.protocol.j)localObject2).s = 12;
        ((com.whatsapp.protocol.j)localObject2).w = ((com.whatsapp.protocol.j)localObject2).l;
        ((ad)localObject1).d.post(new com.whatsapp.data.aw((ad)localObject1, (com.whatsapp.protocol.j)localObject2));
        aed.this.i.a(this.b, "status-revoke-delay");
        return;
        if ((this.b.l == 4) && ((av.f()) || (av.k()))) {
          aed.this.d.a("failed to decrypt", false, null, -1);
        }
        com.whatsapp.fieldstats.l.c(u.a(), (com.whatsapp.fieldstats.e)localObject1);
        break label537;
        label1106:
        bool = false;
        break label770;
        label1112:
        i = 0;
        break label801;
        label1117:
        localObject2 = com.whatsapp.gcm.a.a.a;
        localObject1 = ((com.whatsapp.protocol.j)localObject1).e.c;
        l1 = com.whatsapp.gcm.a.a.b();
        ((com.whatsapp.gcm.a.a)localObject2).c.post(new com.whatsapp.gcm.a.d((com.whatsapp.gcm.a.a)localObject2, (String)localObject1, l1));
      }
      label1160:
      if (aed.this.t.a(this.b.f) != null)
      {
        aed.this.a.post(new ac(aed.this.g, aed.this.j, aed.this.h, aed.this.x, this.b, false));
        return;
      }
      aed.this.i.a(this.b, "status-revoke-drop");
      return;
      label1250:
      aed.this.a.post(new ac(aed.this.g, aed.this.j, aed.this.h, aed.this.x, this.b, false));
    }
    
    final class a
      implements org.whispersystems.a.a
    {
      private final com.whatsapp.protocol.j b;
      private final com.whatsapp.fieldstats.events.u c;
      private final boolean d;
      private final int e;
      
      a(com.whatsapp.protocol.j paramj, com.whatsapp.fieldstats.events.u paramu, boolean paramBoolean, int paramInt)
      {
        this.b = paramj;
        this.c = paramu;
        this.d = paramBoolean;
        this.e = paramInt;
      }
      
      public final void a(byte[] paramArrayOfByte)
      {
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
        {
          if (this.d) {
            aed.this.i.a(aed.this.h, this.b);
          }
          return;
        }
        this.c.a = Boolean.valueOf(true);
        this.c.g = Integer.valueOf(12);
        a.a.a.a.d.a(paramArrayOfByte, this.b, this.e);
        aed.this.h.a(this.b);
      }
    }
    
    final class b
      implements org.whispersystems.a.a
    {
      private final com.whatsapp.protocol.j b;
      
      b(com.whatsapp.protocol.j paramj)
      {
        this.b = paramj;
      }
      
      public final void a(byte[] paramArrayOfByte)
      {
        if (!this.b.d())
        {
          Log.i("axolotl message decryption had no data; ciphertext only");
          this.b.e(com.whatsapp.protocol.s.a(paramArrayOfByte));
        }
        aed.this.h.a(this.b);
      }
    }
    
    final class c
      implements org.whispersystems.a.a
    {
      private final com.whatsapp.protocol.j b;
      private final org.whispersystems.a.m c;
      private final com.whatsapp.fieldstats.events.u d;
      private final boolean e;
      
      c(com.whatsapp.protocol.j paramj, org.whispersystems.a.m paramm, com.whatsapp.fieldstats.events.u paramu, boolean paramBoolean)
      {
        this.b = paramj;
        this.c = paramm;
        this.d = paramu;
        this.e = paramBoolean;
      }
      
      public final void a(byte[] paramArrayOfByte)
      {
        byte[] arrayOfByte = a.a.a.a.d.a(paramArrayOfByte, this.d);
        if (arrayOfByte == null)
        {
          if (this.e) {
            aed.this.i.a(aed.this.h, this.b);
          }
          Log.w("axolotl derived invalid plaintext; message.key=" + this.b.e);
        }
        label376:
        label649:
        label738:
        label918:
        label1051:
        label1066:
        label1132:
        label1546:
        label1976:
        label1978:
        label1981:
        for (;;)
        {
          return;
          Object localObject2;
          int k;
          Object localObject1;
          int i;
          try
          {
            localObject2 = E2E.Message.parseFrom(arrayOfByte);
            k = a.a.a.a.d.a((E2E.Message)localObject2);
            localObject1 = ((E2E.Message)localObject2).getUnknownFields().a.keySet();
            if (((Set)localObject1).size() < 2) {
              break label376;
            }
            paramArrayOfByte = new int[((Set)localObject1).size()];
            localObject1 = ((Set)localObject1).iterator();
            i = 0;
            while (((Iterator)localObject1).hasNext())
            {
              paramArrayOfByte[i] = ((Integer)((Iterator)localObject1).next()).intValue();
              i += 1;
            }
            Log.w("axolotl received several unknown tags; message.key=" + this.b.e + " unknownTags=" + Arrays.toString(paramArrayOfByte));
          }
          catch (com.google.protobuf.q paramArrayOfByte)
          {
            Log.w("axolotl derived plaintext does not represent valid protocol buffer; message.key=" + this.b.e);
            if (this.e) {
              aed.this.i.a(aed.this.h, this.b);
            }
            this.d.a = Boolean.valueOf(false);
            this.d.b = Integer.valueOf(11);
            return;
          }
          if (this.e)
          {
            localObject2 = aed.this.g;
            localObject1 = this.b;
            localObject2 = ((com.whatsapp.messaging.w)localObject2).b;
            localObject1 = Message.obtain(null, 0, 10, 0, localObject1);
            ((Message)localObject1).getData().putIntArray("unknownTags", paramArrayOfByte);
            ((com.whatsapp.messaging.m)localObject2).a((Message)localObject1);
          }
          this.d.a = Boolean.valueOf(false);
          this.d.b = Integer.valueOf(18);
          return;
          if (!a.a.a.a.d.a((E2E.Message)localObject2, k))
          {
            Log.w("axolotl received an invalid protobuf; message.key=" + this.b.e + " messageTypes=" + k);
            if (this.e) {
              aed.this.i.a(aed.this.h, this.b);
            }
            this.d.a = Boolean.valueOf(false);
            this.d.b = Integer.valueOf(12);
            return;
          }
          Object localObject3;
          int j;
          if ((qz.e(this.b.e.a)) || (com.whatsapp.protocol.j.b(this.b.e.a)))
          {
            paramArrayOfByte = this.b.f;
            if (this.b.Y == null) {
              break label1066;
            }
            aed.this.k.i(paramArrayOfByte);
            localObject3 = aed.this.k.j(paramArrayOfByte);
            if ((localObject3 == null) || (((cu)localObject3).d == this.b.Y.longValue())) {
              break label1051;
            }
            Log.w("verified name serial changed; jid=" + paramArrayOfByte + " " + ((cu)localObject3).d + " -> " + this.b.Y);
            aed.this.k.k(paramArrayOfByte);
            i = 1;
            j = i;
            if (i != 0)
            {
              j = i;
              if (this.b.Z != null)
              {
                j = i;
                if (aed.this.k.a(paramArrayOfByte, this.b.Z))
                {
                  aed.this.c.a(aez.a(this, paramArrayOfByte));
                  j = 0;
                }
              }
            }
            if (j != 0) {
              aed.this.j.a(new GetVNameCertificateJob(paramArrayOfByte));
            }
            j = 1;
            if (!((E2E.Message)localObject2).hasChat()) {
              break label1132;
            }
            this.d.g = Integer.valueOf(7);
            paramArrayOfByte = null;
            if (((E2E.Message)localObject2).getChat().hasDisplayName()) {
              paramArrayOfByte = ((E2E.Message)localObject2).getChat().getDisplayName();
            }
            localObject1 = null;
            if (((E2E.Message)localObject2).getChat().hasId()) {
              localObject1 = ((E2E.Message)localObject2).getChat().getId();
            }
            aau.a(aed.this.b, aed.this.c, aed.this.f, aed.this.g, aed.this.h, aed.this.k, this.b.e.a, (String)localObject1, paramArrayOfByte);
            if (!this.e) {
              break label1978;
            }
            aed.this.i.a(aed.this.h, this.b);
            i = 0;
          }
          for (;;)
          {
            if (!((E2E.Message)localObject2).hasSenderKeyDistributionMessage()) {
              break label1981;
            }
            Log.i("axolotl received sender key distribution message; message.key=" + this.b.e);
            paramArrayOfByte = ((E2E.Message)localObject2).getSenderKeyDistributionMessage();
            if ((!paramArrayOfByte.hasGroupId()) || (!paramArrayOfByte.hasAxolotlSenderKeyDistributionMessage())) {
              Log.w("axolotl received incomplete sender key distribution message; message.key=" + this.b.e);
            }
            for (;;)
            {
              if ((!this.e) || (i == 0)) {
                break label1976;
              }
              aed.this.i.a(aed.this.h, this.b);
              return;
              paramArrayOfByte = this.b.e.a;
              break;
              if (localObject3 == null)
              {
                i = 1;
                break label649;
              }
              i = 0;
              break label649;
              localObject3 = aed.this.k.c(paramArrayOfByte);
              if ((localObject3 == null) || (!((cs)localObject3).f())) {
                break label738;
              }
              Log.w("verified name serial not present on message, clearing state; jid=" + paramArrayOfByte);
              aed.this.k.k(paramArrayOfByte);
              break label738;
              if ((k == 1) && (((E2E.Message)localObject2).hasHighlyStructuredMessage()))
              {
                try
                {
                  this.d.g = Integer.valueOf(1);
                  a.a.a.a.d.a((E2E.Message)localObject2, this.b);
                  long l = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
                  aed.this.j.a(new RehydrateHsmJob(aed.this.m, (E2E.Message)localObject2, this.b.e.c, this.b.e.a, this.b.f, this.b.n, l + 86400000L, this.b.Y, null));
                  i = 0;
                }
                catch (ar paramArrayOfByte)
                {
                  this.d.a = Boolean.valueOf(false);
                  this.d.b = paramArrayOfByte.a;
                  i = j;
                }
                if (!this.e) {
                  break label918;
                }
                aed.this.i.a(aed.this.h, this.b);
                i = 0;
                break label918;
              }
              i = j;
              if (k != 1) {
                break label918;
              }
              try
              {
                if ((((Set)localObject1).size() != 0) || (((E2E.Message)localObject2).hasHighlyStructuredMessage())) {
                  a.a.a.a.d.a(arrayOfByte, this.b, 2);
                }
                for (;;)
                {
                  if ((this.b.s != 15) || (this.b.ab != 7)) {
                    break label1546;
                  }
                  Log.d("/edit/revoked key=" + this.b.e + " edit=" + this.b.ab);
                  aed.this.h.a(this.b, true);
                  i = 0;
                  break;
                  a.a.a.a.d.a(aed.this.e, (E2E.Message)localObject2, this.b, true, false, false);
                }
                if (!this.e) {
                  break label918;
                }
              }
              catch (ar paramArrayOfByte)
              {
                this.d.a = Boolean.valueOf(false);
                this.d.b = paramArrayOfByte.a;
                i = j;
              }
              aed.this.i.a(aed.this.h, this.b);
              i = 0;
              break label918;
              if (this.b.s == 17)
              {
                paramArrayOfByte = new ArrayList(1);
                paramArrayOfByte.add(this.b);
                aed.this.h.b(paramArrayOfByte, true, true);
                i = j;
                if (!this.e) {
                  break label918;
                }
                aed.this.i.a(aed.this.h, this.b);
                i = 0;
                break label918;
              }
              if (this.b.ab == 0)
              {
                this.d.g = Integer.valueOf(a.a.a.a.d.a(this.b));
                aed.this.h.a(this.b);
                i = 0;
                break label918;
              }
              Log.e("msgrecv/invalid-edit-version edit=" + this.b.ab + ", type=" + this.b.s);
              this.d.a = Boolean.valueOf(false);
              this.d.b = Integer.valueOf(19);
              i = j;
              if (!this.e) {
                break label918;
              }
              aed.this.i.a(aed.this.h, this.b);
              i = 0;
              break label918;
              if ((qz.e(this.b.e.a)) && (!this.b.e.a.equals(paramArrayOfByte.getGroupId())))
              {
                Log.w("group id on message and group id in ciphertext do not match; message.key=" + this.b.e);
              }
              else
              {
                localObject1 = new org.whispersystems.a.c.d(aed.this.x.d);
                localObject2 = new org.whispersystems.a.c.e(paramArrayOfByte.getGroupId(), this.c);
                try
                {
                  ((org.whispersystems.a.c.d)localObject1).a((org.whispersystems.a.c.e)localObject2, new org.whispersystems.a.f.d(paramArrayOfByte.getAxolotlSenderKeyDistributionMessage().d()));
                }
                catch (g paramArrayOfByte)
                {
                  Log.c("axolotl received invalid sender key distribution message; message.key=" + this.b.e, paramArrayOfByte);
                }
                catch (org.whispersystems.a.i paramArrayOfByte)
                {
                  Log.c("axolotl received legacy sender key distribution message; message.key=" + this.b.e, paramArrayOfByte);
                }
              }
            }
            break;
            i = 1;
          }
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */