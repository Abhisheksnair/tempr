package com.whatsapp;

import a.a.a.a.a.a.d;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.util.Pair;
import com.whatsapp.b.a;
import com.whatsapp.contact.sync.ContactSyncManager;
import com.whatsapp.contact.sync.ContactSyncManager.ParcelableSyncUser;
import com.whatsapp.contact.sync.ContactSyncManager.c;
import com.whatsapp.data.ad;
import com.whatsapp.data.ch;
import com.whatsapp.data.ci;
import com.whatsapp.data.ck;
import com.whatsapp.data.cm;
import com.whatsapp.data.co;
import com.whatsapp.data.l;
import com.whatsapp.data.s;
import com.whatsapp.data.y;
import com.whatsapp.messaging.ParcelablePreKey;
import com.whatsapp.messaging.ParcelableStanzaKey;
import com.whatsapp.messaging.ag;
import com.whatsapp.messaging.aj;
import com.whatsapp.messaging.ax;
import com.whatsapp.messaging.ba;
import com.whatsapp.messaging.be;
import com.whatsapp.messaging.bf;
import com.whatsapp.messaging.bg;
import com.whatsapp.messaging.bh;
import com.whatsapp.messaging.bi;
import com.whatsapp.messaging.bj;
import com.whatsapp.messaging.bk;
import com.whatsapp.messaging.bl;
import com.whatsapp.messaging.bm;
import com.whatsapp.messaging.bn;
import com.whatsapp.messaging.bo;
import com.whatsapp.messaging.bq;
import com.whatsapp.messaging.bt;
import com.whatsapp.messaging.m.c;
import com.whatsapp.protocol.ab;
import com.whatsapp.protocol.ac;
import com.whatsapp.protocol.af;
import com.whatsapp.protocol.al;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.registration.x;
import com.whatsapp.twofactor.q;
import com.whatsapp.util.Log;
import com.whatsapp.util.b;
import com.whatsapp.util.bd;
import com.whatsapp.util.bu;
import com.whatsapp.util.w.a;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class za
  implements m.c
{
  private static volatile za g;
  private final auu A;
  private final ane B;
  private final us C;
  private final com.whatsapp.notification.f D;
  private final abv E;
  private final atv F;
  private final q G;
  private final vs H;
  private final pd I;
  final Context a;
  final va b;
  final ad c;
  final att d;
  final com.whatsapp.messaging.m e;
  final aus f;
  private final aed h;
  private final afa i;
  private final afj j;
  private final ax k = new ax(this);
  private final bj l;
  private final bd m = new bd(true);
  private final LinkedHashMap<String, Message> n = new LinkedHashMap();
  private final pv o;
  private final anv p;
  private final com.whatsapp.messaging.w q;
  private final x r;
  private final com.whatsapp.data.e s;
  private final abp t;
  private final aob u;
  private final pc v;
  private final ph w;
  private final abu x;
  private final com.whatsapp.util.w y;
  private final sr z;
  
  private za(Context paramContext, ant paramant, pv parampv, aaq paramaaq, com.whatsapp.util.a.c paramc, va paramva, ahx paramahx, anv paramanv, com.whatsapp.data.d paramd, oz paramoz, od paramod, com.whatsapp.messaging.w paramw, aic paramaic, cm paramcm, aoj paramaoj, x paramx, vp paramvp, ad paramad, adp paramadp, att paramatt, mg parammg, com.whatsapp.l.e parame, com.whatsapp.data.e parame1, s params, com.whatsapp.messaging.m paramm, abp paramabp, aob paramaob, aj paramaj, aus paramaus, mf parammf, pc parampc, ph paramph, abu paramabu, b paramb, aq paramaq, dh paramdh, com.whatsapp.contact.sync.i parami, l paraml, com.whatsapp.util.w paramw1, qz paramqz, sr paramsr, auu paramauu, cc paramcc, rk paramrk, y paramy, vv paramvv, af paramaf, ane paramane, ContactSyncManager paramContactSyncManager, co paramco, ai paramai, a parama, us paramus, com.whatsapp.notification.f paramf, aat paramaat, abv paramabv, acm paramacm, com.whatsapp.a.c paramc1, atu paramatu, atv paramatv, lt paramlt, ck paramck, q paramq, hx paramhx, vs paramvs, ag paramag, com.whatsapp.messaging.i parami1, com.whatsapp.data.m paramm1, pd parampd, com.whatsapp.location.bp parambp, ka paramka, ci paramci, rh paramrh)
  {
    this.a = paramContext;
    this.o = parampv;
    this.b = paramva;
    this.p = paramanv;
    this.q = paramw;
    this.r = paramx;
    this.c = paramad;
    this.d = paramatt;
    this.s = parame1;
    this.e = paramm;
    this.t = paramabp;
    this.u = paramaob;
    this.f = paramaus;
    this.v = parampc;
    this.w = paramph;
    this.x = paramabu;
    this.y = paramw1;
    this.z = paramsr;
    this.A = paramauu;
    this.B = paramane;
    this.C = paramus;
    this.D = paramf;
    this.E = paramabv;
    this.F = paramatv;
    this.G = paramq;
    this.H = paramvs;
    this.I = parampd;
    this.h = new aed(paramContext, paramant, parampv, paramaaq, paramc, paramva, paramanv, paramd, paramoz, paramod, paramw, paramaic, paramad, paramadp, paramatt, parammg, parame, parame1, params, paramm, paramabp, paramaob, paramaus, parammf, parampc, paramabu, paramb, paramaq, paraml, paramdh, parami, paramw1, paramqz, paramsr, paramrk, paramy, paramvv, paramaf, paramContactSyncManager, paramco, paramai, parama, paramaat, paramacm, paramc1, paramatv, paramck, paramq, parami1, paramm1, paramci, paramrh);
    this.i = new afa(paramw, paramad, paramatt, paramabp, paramaob, paramc1, paramatv);
    this.j = new afj(paramant, parampv, paramaaq, paramva, paramahx, paramd, paramw, paramcm, paramaoj, paramvp, paramad, paramadp, paramatt, parame1, paramaj, paramaus, paramabu, paramaq, paraml, paramqz, paramcc, paramrk, paramco, paramf, paramaat, paramabv, paramacm, paramc1, paramatu, paramatv, paramlt, paramck, paramhx, paramag, paramka, paramrh);
    this.l = new bj(paramw, paramatt, paramc1, parambp);
  }
  
  public static za a()
  {
    if (g == null) {}
    try
    {
      if (g == null) {
        g = new za(u.a(), ant.a(), pv.a(), aaq.a(), com.whatsapp.util.a.c.a(), va.a(), ahx.a(), anv.a(), com.whatsapp.data.d.a(), oz.a(), od.a(), com.whatsapp.messaging.w.a(), aic.a(), cm.a(), aoj.a(), x.a(), vp.a(), ad.a(), adp.a(), att.a(), mg.a(), com.whatsapp.l.e.a(), com.whatsapp.data.e.a(), s.a(), com.whatsapp.messaging.m.a(), abp.a(), aob.a(), aj.a(), aus.a(), mf.a(), pc.a(), ph.a(), abu.a(), b.a(), aq.a(), dh.a(), com.whatsapp.contact.sync.i.a(), l.a(), com.whatsapp.util.w.a(), qz.a(), sr.a(), auu.a(), cc.a(), rk.a(), y.a(), vv.a(), af.a(), ane.a(), ContactSyncManager.a(), co.a(), ai.a(), a.a(), us.a(), com.whatsapp.notification.f.a(), aat.a(), abv.a(), acm.a(), com.whatsapp.a.c.a(), atu.a(), atv.a(), lt.a(), ck.a(), q.a(), hx.a(), vs.a(), ag.a(), com.whatsapp.messaging.i.a(), com.whatsapp.data.m.a(), pd.a(), com.whatsapp.location.bp.a(), ka.a(), ci.a(), rh.a());
      }
      return g;
    }
    finally {}
  }
  
  private void h()
  {
    long l2 = -1L;
    if (this.A.a)
    {
      this.o.a("server connected");
      this.F.a(false, 0L);
    }
    boolean bool;
    do
    {
      return;
      if (this.A.b)
      {
        this.o.a("server connecting");
        SpamWarningActivity.c(true);
        return;
      }
      this.o.a("server disconnected");
      SpamWarningActivity.c(false);
      bool = this.F.a.getBoolean("spam_banned", false);
      Log.d("wa-shared-prefs/getspambanned " + bool);
    } while (!bool);
    Intent localIntent = new Intent(null, null, this.a, SpamWarningActivity.class);
    localIntent.setFlags(268435456);
    long l3 = this.F.a.getLong("spam_banned_expiry_timestamp", -1L);
    Log.d("wa-shared-prefs/getspambanned " + l3);
    long l1 = l3;
    if (l3 != -1L) {
      l1 = (l3 - System.currentTimeMillis()) / 1000L;
    }
    if (l1 <= 0L) {
      l1 = l2;
    }
    for (;;)
    {
      localIntent.putExtra("expiry_in_seconds", (int)l1);
      this.a.startActivity(localIntent);
      return;
    }
  }
  
  public final void a(Message paramMessage)
  {
    Object localObject1 = null;
    Object localObject2 = this.h;
    Voip.c();
    afa localafa = this.i;
    Object localObject3 = this.j;
    ??? = this.k;
    Object localObject4 = this.l;
    int i2 = paramMessage.arg1;
    label142:
    Object localObject5;
    switch (i2)
    {
    default: 
      i1 = 0;
      if ((i1 != 0) && (??? != null))
      {
        localObject5 = (Bundle)paramMessage.obj;
        ((Bundle)localObject5).setClassLoader(ParcelableStanzaKey.class.getClassLoader());
        localObject5 = ((Bundle)localObject5).getString("id");
        if (localObject5 != null) {
          break label1226;
        }
        a.d.a(false, "stanza id must be present for ack message " + paramMessage);
      }
      break;
    }
    for (;;)
    {
      switch (i2)
      {
      default: 
        return;
        i1 = 1;
        break label142;
        label1226:
        za localza = ((ax)???).a;
        if (localObject5 == null)
        {
          a.d.a(false, "message acked with null id");
        }
        else
        {
          a.d.b();
          synchronized (localza.n)
          {
            localza.n.remove(localObject5);
          }
        }
        break;
      }
    }
    ((bm)localObject2).a((j)paramMessage.obj);
    return;
    paramMessage = (ba)paramMessage.obj;
    ((bm)localObject2).a(paramMessage.a, paramMessage.b, paramMessage.c, paramMessage.d);
    return;
    paramMessage = (bo)paramMessage.obj;
    ((bm)localObject2).a(paramMessage.a, paramMessage.b, paramMessage.c, paramMessage.d, paramMessage.e, paramMessage.g, paramMessage.h, paramMessage.i, paramMessage.j);
    return;
    localObject1 = (com.whatsapp.messaging.bc)paramMessage.obj;
    ((bm)localObject2).a(((com.whatsapp.messaging.bc)localObject1).a, ((com.whatsapp.messaging.bc)localObject1).b, paramMessage.getData().getIntArray("unknownTags"));
    return;
    ((bm)localObject2).a(new j.b(paramMessage.getData().getString("remote_jid"), true, paramMessage.getData().getString("msgid")), paramMessage.getData().getString("participant"), paramMessage.getData().getString("serverParticipantHash"), paramMessage.getData().getInt("count"), paramMessage.getData().getLong("timestamp"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bm)localObject2).a(new j.b(paramMessage.getString("remote_jid"), true, paramMessage.getString("msgid")), paramMessage.getString("played_jid"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    new j.b(paramMessage.getString("remote_jid"), false, paramMessage.getString("msgid"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bm)localObject2).a(paramMessage.getString("jid"), paramMessage.getString("pushName"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bm)localObject2).a(paramMessage.getString("jid"), paramMessage.getString("pushName"), paramMessage.getLong("lastSeen"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bm)localObject2).b(paramMessage.getString("jid"), paramMessage.getString("pushName"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bm)localObject2).c(paramMessage.getString("platform"), paramMessage.getString("push_id"));
    return;
    ((bm)localObject2).a(paramMessage.arg2);
    return;
    ((bm)localObject2).a(((Boolean)paramMessage.obj).booleanValue());
    return;
    ((bm)localObject2).a((String)paramMessage.obj);
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bm)localObject2).a(paramMessage.getString("jid"), paramMessage.getString("author"), paramMessage.getInt("media"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bm)localObject2).d(paramMessage.getString("jid"), paramMessage.getString("author"));
    return;
    ((bm)localObject2).b((String)paramMessage.obj);
    return;
    ((bm)localObject2).a();
    return;
    ((bm)localObject2).b();
    return;
    ((bm)localObject2).a((Map)paramMessage.obj);
    return;
    ((bm)localObject2).a((ace)paramMessage.obj);
    return;
    localObject1 = (Bundle)paramMessage.obj;
    ((bm)localObject2).a(((Bundle)localObject1).getString("msgid"), ((Bundle)localObject1).getString("jid"), ((Bundle)localObject1).getString("jid_changed_by"), paramMessage.arg2, ((Bundle)localObject1).getInt("timestamp"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bm)localObject2).e(paramMessage.getString("msgid"), paramMessage.getString("jid"));
    return;
    ((bm)localObject2).a((String)paramMessage.obj, paramMessage.arg2);
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bm)localObject2).a(paramMessage.getString("msgId"), paramMessage.getString("jid"), paramMessage.getLong("timestamp"), paramMessage.getString("status"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bm)localObject2).f(paramMessage.getString("msgId"), paramMessage.getString("jid"));
    return;
    ((bm)localObject2).c();
    return;
    paramMessage = (be)paramMessage.obj;
    ((bm)localObject2).a(paramMessage.a, paramMessage.b, paramMessage.c, paramMessage.d, paramMessage.e, paramMessage.f);
    return;
    paramMessage = (bf)paramMessage.obj;
    ((bm)localObject2).a(paramMessage.a, paramMessage.b, paramMessage.c.a, paramMessage.c.b, paramMessage.c.c, paramMessage.c.d);
    return;
    paramMessage = (bl)paramMessage.obj;
    ((bm)localObject2).a(paramMessage.a, paramMessage.c);
    return;
    ((bm)localObject2).b(paramMessage.arg1);
    return;
    ((bm)localObject2).a((Bundle)paramMessage.obj);
    return;
    ((bm)localObject2).a(((ParcelableStanzaKey)paramMessage.getData().getParcelable("stanzaKey")).a, paramMessage.getData().getLong("before"), paramMessage.getData().getLong("after"));
    return;
    localObject1 = paramMessage.getData();
    ((bm)localObject2).a(((Bundle)localObject1).getString("sid"), ((Bundle)localObject1).getInt("index"), ((Bundle)localObject1).getString("version"), (ContactSyncManager.ParcelableSyncUser[])((Bundle)localObject1).getParcelableArray("users"), (Map)paramMessage.obj, ((Bundle)localObject1).getLong("contact_refresh"), ((Bundle)localObject1).getLong("status_refresh"), ((Bundle)localObject1).getLong("feature_refresh"));
    return;
    localObject1 = paramMessage.getData();
    ((bm)localObject2).a(((Bundle)localObject1).getString("sid"), ((Bundle)localObject1).getInt("index"), (ContactSyncManager.c)paramMessage.obj);
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bm)localObject2).a(paramMessage.getString("sid"), paramMessage.getInt("index"), paramMessage.getInt("code"), paramMessage.getLong("backoff"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bm)localObject2).b(paramMessage.getString("sid"), paramMessage.getInt("index"), paramMessage.getInt("code"), paramMessage.getLong("backoff"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bm)localObject2).c(paramMessage.getString("sid"), paramMessage.getInt("index"), paramMessage.getInt("code"), paramMessage.getLong("backoff"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bm)localObject2).a(((ParcelableStanzaKey)paramMessage.getParcelable("stanzaKey")).a, paramMessage.getByteArray("jidHash"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bm)localObject2).a(paramMessage.getString("from"), paramMessage.getString("msgId"), paramMessage.getString("jid"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bm)localObject2).b(paramMessage.getString("from"), paramMessage.getString("msgId"), paramMessage.getString("jid"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bq)localObject3).a(paramMessage.getString("ref"), paramMessage.getString("secret"), paramMessage.getString("browserId"), paramMessage.getString("loginToken"), paramMessage.getString("os"), paramMessage.getString("browserType"), paramMessage.getBoolean("timeout"), paramMessage.getBoolean("fservice"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bq)localObject3).a(paramMessage.getString("ref"), paramMessage.getInt("code"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bq)localObject3).a(paramMessage.getString("from"), paramMessage.getString("id"), paramMessage.getString("ref"));
    return;
    paramMessage = (com.whatsapp.messaging.bp)paramMessage.obj;
    ((bq)localObject3).a(paramMessage.a, paramMessage.b, paramMessage.e, paramMessage.f);
    return;
    paramMessage = (com.whatsapp.messaging.bp)paramMessage.obj;
    ((bq)localObject3).a(paramMessage.a, paramMessage.b, paramMessage.f);
    return;
    paramMessage = (com.whatsapp.messaging.bp)paramMessage.obj;
    ((bq)localObject3).a(paramMessage.a, paramMessage.b, paramMessage.h);
    return;
    paramMessage = (com.whatsapp.messaging.bp)paramMessage.obj;
    ((bq)localObject3).a(paramMessage.a, paramMessage.b, paramMessage.l, paramMessage.c, paramMessage.m);
    return;
    paramMessage = (com.whatsapp.messaging.bp)paramMessage.obj;
    ((bq)localObject3).a(paramMessage.a, paramMessage.b, paramMessage.i);
    return;
    paramMessage = (com.whatsapp.messaging.bp)paramMessage.obj;
    ((bq)localObject3).a(paramMessage.a, paramMessage.b, paramMessage.j);
    return;
    paramMessage = (com.whatsapp.messaging.bp)paramMessage.obj;
    ((bq)localObject3).b(paramMessage.a, paramMessage.b, paramMessage.l);
    return;
    paramMessage = (com.whatsapp.messaging.bp)paramMessage.obj;
    ((bq)localObject3).a(paramMessage.a, paramMessage.b, paramMessage.d, paramMessage.c);
    return;
    paramMessage = (com.whatsapp.messaging.bp)paramMessage.obj;
    ((bq)localObject3).a(paramMessage.a, paramMessage.b, paramMessage.k);
    return;
    paramMessage = (com.whatsapp.messaging.bp)paramMessage.obj;
    ((bq)localObject3).a(paramMessage.a, paramMessage.b, paramMessage.g);
    return;
    paramMessage = (com.whatsapp.messaging.bp)paramMessage.obj;
    ((bq)localObject3).c(paramMessage.a, paramMessage.b, paramMessage.l);
    return;
    paramMessage = (com.whatsapp.messaging.bp)paramMessage.obj;
    ((bq)localObject3).d(paramMessage.a, paramMessage.b, paramMessage.l);
    return;
    paramMessage = (Bundle)paramMessage.obj;
    localObject1 = paramMessage.getString("from");
    localObject2 = paramMessage.getString("id");
    paramMessage.getInt("op");
    paramMessage.getString("vcard");
    ((bq)localObject3).a((String)localObject1, (String)localObject2);
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bq)localObject3).a(paramMessage.getString("from"), paramMessage.getString("id"), paramMessage.getString("jid"), paramMessage.getBoolean("mute"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bq)localObject3).a(paramMessage.getString("from"), paramMessage.getString("id"), paramMessage.getStringArrayList("jids"), paramMessage.getString("type"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bq)localObject3).a(paramMessage.getString("from"), paramMessage.getString("id"), paramMessage.getString("ref"), paramMessage.getString("browserId"), paramMessage.getString("token"), paramMessage.getString("type"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bq)localObject3).a(paramMessage.getString("from"), paramMessage.getString("id"), paramMessage.getBoolean("clearTokens"), paramMessage.getString("ref"), paramMessage.getString("browserId"), paramMessage.getLong("ts"), paramMessage.getString("hmac"));
    return;
    ((bq)localObject3).a((String)paramMessage.obj);
    return;
    Log.d("voip/onReceiveCallMessage/" + paramMessage.arg1);
    localObject1 = new Intent("receive_message", null, u.a(), VoiceService.class);
    if (paramMessage.obj != null) {}
    try
    {
      localObject2 = (Parcelable)paramMessage.obj;
      paramMessage.obj = null;
      ((Intent)localObject1).putExtra("extra_receive_message_obj", (Parcelable)localObject2);
      ((Intent)localObject1).putExtra("extra_receive_message", paramMessage);
      u.a().startService((Intent)localObject1);
      return;
    }
    catch (ClassCastException paramMessage)
    {
      throw new RuntimeException("obj in Call Message is not Parcelable");
    }
    ((bm)localObject2).b((Map)paramMessage.obj);
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bm)localObject2).a(paramMessage.getLong("timeAccepted"), paramMessage.getInt("optOut"));
    return;
    ((bm)localObject2).a(((ParcelableStanzaKey)((Bundle)paramMessage.obj).getParcelable("stanzaKey")).a);
    return;
    ((bm)localObject2).b(((ParcelableStanzaKey)((Bundle)paramMessage.obj).getParcelable("stanzaKey")).a);
    return;
    paramMessage = (Bundle)paramMessage.obj;
    localafa.a(paramMessage.getString("jid"), paramMessage.getByteArray("identity"), paramMessage.getByteArray("registration"), paramMessage.getByte("type"), ((ParcelablePreKey)paramMessage.getParcelable("preKey")).a, ((ParcelablePreKey)paramMessage.getParcelable("signedPreKey")).a);
    return;
    localafa.a(((Bundle)paramMessage.obj).getString("jid"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    localafa.a(paramMessage.getString("jid"), paramMessage.getInt("errorCode"));
    return;
    localafa.a();
    return;
    localafa.a(((Bundle)paramMessage.obj).getInt("errorCode"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    localafa.a(((ParcelableStanzaKey)paramMessage.getParcelable("stanzaKey")).a, paramMessage.getInt("remainingPreKeys"));
    return;
    localafa.a(((ParcelableStanzaKey)paramMessage.getData().getParcelable("stanzaKey")).a);
    return;
    localafa.b(((ParcelableStanzaKey)paramMessage.getData().getParcelable("stanzaKey")).a);
    return;
    paramMessage = (Bundle)paramMessage.obj;
    localafa.a(paramMessage.getByteArray("registration"), paramMessage.getByte("type"), paramMessage.getByteArray("signedKeyId"), a.a.a.a.d.a(paramMessage, "keyIds"), paramMessage.getByteArray("hash"));
    return;
    localafa.b();
    return;
    localafa.c();
    return;
    ((bm)localObject2).c(((ParcelableStanzaKey)((Bundle)paramMessage.obj).getParcelable("stanzaKey")).a);
    return;
    ((bm)localObject2).c((Map)paramMessage.obj);
    return;
    ((bm)localObject2).c(paramMessage.arg2);
    return;
    ((bm)localObject2).a((Exception)paramMessage.obj);
    return;
    paramMessage = (Pair)paramMessage.obj;
    ((bm)localObject2).a((al)paramMessage.first, (List)paramMessage.second);
    return;
    ((bm)localObject2).d((al)paramMessage.obj);
    return;
    ((bm)localObject2).e((al)paramMessage.obj);
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bm)localObject2).g(paramMessage.getString("code"), paramMessage.getString("email"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bm)localObject2).a(paramMessage.getBoolean("code"), paramMessage.getBoolean("email"));
    return;
    paramMessage = (Bundle)paramMessage.obj;
    ((bm)localObject2).a(paramMessage.getString("code"), paramMessage.getString("email"), paramMessage.getInt("errorCode"), paramMessage.getString("errorMessage"));
    return;
    ((bm)localObject2).b((j)paramMessage.obj);
    return;
    paramMessage = paramMessage.getData();
    ((bm)localObject2).a((Locale[])paramMessage.getSerializable("requestLocales"), (Locale)paramMessage.getSerializable("locale"), paramMessage.getString("hash"), paramMessage.getString("ns"), paramMessage.getByteArray("blob"));
    return;
    localObject3 = paramMessage.getData();
    localObject4 = (Locale[])((Bundle)localObject3).getSerializable("requestLocales");
    paramMessage = (Message)localObject1;
    if (((Bundle)localObject3).containsKey("haveHashes")) {
      paramMessage = (String[])((Bundle)localObject3).getStringArray("haveHashes");
    }
    ((bm)localObject2).a((Locale[])localObject4, paramMessage, ((Bundle)localObject3).getString("ns"), ((Bundle)localObject3).getInt("errorCode"));
    return;
    paramMessage = paramMessage.getData();
    ((bm)localObject2).a(paramMessage.getString("jid"), paramMessage.getByteArray("certBlob"));
    return;
    paramMessage = paramMessage.getData();
    ((bm)localObject2).b(paramMessage.getString("jid"), paramMessage.getInt("errorCode"));
    return;
    ((bm)localObject2).c((String)paramMessage.obj);
    return;
    ((bm)localObject2).d(paramMessage.arg2);
    return;
    localObject2 = (bh)paramMessage.obj;
    paramMessage = ((bh)localObject2).a;
    localObject1 = ((bh)localObject2).b;
    int i1 = ((bh)localObject2).c;
    Log.i("recvlocationmessagelistener/on-location-key-notification; stanzaKey=" + paramMessage + "; retryCount=" + i1);
    localObject2 = paramMessage.e;
    if (((com.whatsapp.protocol.f)localObject1).a != 2)
    {
      Log.w("recvlocationmessagelistener/invalid ciphertext version; ciphertextVersion=" + ((com.whatsapp.protocol.f)localObject1).a);
      ((bj)localObject4).b.a(paramMessage);
      return;
    }
    com.whatsapp.a.c.a.execute(adx.a((bj)localObject4, (String)localObject2, i1, paramMessage, (com.whatsapp.protocol.f)localObject1));
    ((bj)localObject4).b.a(paramMessage);
    return;
    paramMessage = (bg)paramMessage.obj;
    localObject1 = paramMessage.a;
    long l1 = paramMessage.b;
    Log.i("recvlocationmessagelistener/on-location-disabled-notification; stanzaKey=" + localObject1 + "; sequenceNumber=" + l1);
    ((bj)localObject4).e.a(((al)localObject1).a, ((al)localObject1).e, l1);
    ((bj)localObject4).b.a((al)localObject1);
    return;
    localObject1 = (bi)paramMessage.obj;
    paramMessage = ((bi)localObject1).a;
    localObject2 = ((bi)localObject1).b;
    i1 = ((bi)localObject1).c;
    Log.i("recvlocationmessagelistener/on-location-key-retry-notification; stanzaKey=" + paramMessage + "; retryCount=" + i1);
    if ((qz.e(paramMessage.a)) || (j.b(paramMessage.a)))
    {
      Log.w("axolotl received location key retry notification sent to a group or broadcast");
      ((bj)localObject4).b.a(paramMessage);
      return;
    }
    localObject1 = paramMessage.a;
    i2 = a.a.a.a.d.f((byte[])localObject2);
    Log.i("axolotl got location retry request " + i1 + " for " + (String)localObject1 + " with " + i2);
    if (i1 > 4)
    {
      Log.w("axolotl skipping retry; reached max retry; jid=" + (String)localObject1);
      ((bj)localObject4).b.a(paramMessage);
      return;
    }
    if (!((bj)localObject4).e.h((String)localObject1))
    {
      Log.w("axolotl skipping retry; user should not get location key; jid=" + (String)localObject1);
      localObject2 = ((bj)localObject4).b;
      if (((com.whatsapp.messaging.w)localObject2).b.d)
      {
        localObject2 = ((com.whatsapp.messaging.w)localObject2).b;
        localObject3 = Message.obtain(null, 0, 126, 0);
        ((Message)localObject3).getData().putString("jid", (String)localObject1);
        ((com.whatsapp.messaging.m)localObject2).a((Message)localObject3);
      }
      ((bj)localObject4).b.a(paramMessage);
      return;
    }
    if (!((bj)localObject4).e.a((String)localObject1, i1))
    {
      Log.w("axolotl skipping retry; retry too soon; jid=" + (String)localObject1);
      ((bj)localObject4).b.a(paramMessage);
      return;
    }
    com.whatsapp.a.c.a.execute(ady.a((bj)localObject4, (String)localObject1, i2, i1));
    ((bj)localObject4).b.a(paramMessage);
    return;
    paramMessage = (al)paramMessage.obj;
    Log.i("recvlocationmessagelistener/on-location-key-deny-notification; stanzaKey=" + paramMessage);
    if ((qz.e(paramMessage.a)) || (j.b(paramMessage.a)))
    {
      Log.w("axolotl received location key deny notification sent to a group or broadcast");
      ((bj)localObject4).b.a(paramMessage);
      return;
    }
    ((bj)localObject4).e.c(paramMessage.a);
    ((bj)localObject4).b.a(paramMessage);
    return;
    localObject1 = (bk)paramMessage.obj;
    paramMessage = ((bk)localObject1).a;
    l1 = ((bk)localObject1).b;
    localObject1 = ((bk)localObject1).c;
    Log.i("recvlocationmessagelistener/on-location-update; jid=" + paramMessage + "; elapsed=" + l1);
    if (((com.whatsapp.protocol.f)localObject1).a != 2)
    {
      Log.w("recvlocationmessagelistener/invalid ciphertext version; ciphertextVersion=" + ((com.whatsapp.protocol.f)localObject1).a);
      return;
    }
    if (((com.whatsapp.protocol.f)localObject1).b != 3)
    {
      Log.w("recvlocationmessagelistener/invalid ciphertext type; ciphertextType=" + ((com.whatsapp.protocol.f)localObject1).b);
      return;
    }
    com.whatsapp.a.c.a.execute(adz.a((bj)localObject4, paramMessage, (com.whatsapp.protocol.f)localObject1, l1));
  }
  
  public final void a(Message paramMessage, String paramString)
  {
    boolean bool = true;
    int i2 = paramMessage.arg1;
    switch (i2)
    {
    }
    for (int i1 = 0;; i1 = 1)
    {
      if (i1 != 0)
      {
        if (paramString != null) {
          break;
        }
        a.d.a(false, "must have stanza id for message type " + i2);
      }
      return;
    }
    for (;;)
    {
      synchronized (this.n)
      {
        if (!this.n.containsKey(paramString))
        {
          a.d.a(bool, " the message " + paramString + " already in unacked message list");
          this.n.put(paramString, paramMessage);
          return;
        }
      }
      bool = false;
    }
  }
  
  public final void a(ab paramab)
  {
    if (paramab.a == 0)
    {
      this.r.a(true);
      this.o.f();
      return;
    }
    if (paramab.a == 2)
    {
      Intent localIntent = new Intent(null, null, this.a, SpamWarningActivity.class);
      localIntent.setFlags(268435456);
      localIntent.putExtra("spam_warning_reason_key", paramab.b);
      localIntent.putExtra("expiry_in_seconds", paramab.c);
      this.F.a(true, System.currentTimeMillis() + paramab.c * 1000);
      this.a.startActivity(localIntent);
      return;
    }
    Log.e("message-handler-callback/login-failed LoginFailureException type: " + paramab.a);
  }
  
  public final void b()
  {
    Log.i("message-handler-callback/ready");
    long l1 = this.a.getSharedPreferences("com.whatsapp_preferences", 0).getLong("groups_server_props_last_refresh_time", 0L);
    if ((86400000L + l1 < System.currentTimeMillis()) || (System.currentTimeMillis() < l1)) {
      this.q.h();
    }
    boolean bool = this.F.a.getBoolean("refresh_broadcast_lists", false);
    Log.d("app/getshouldrefreshbroadcastlists " + bool);
    if (bool) {
      this.q.g();
    }
    this.z.b(new zb(this));
  }
  
  public final void c()
  {
    auu localauu = this.A;
    localauu.b = true;
    localauu.c += 1;
    localauu.d = false;
    h();
  }
  
  public final void d()
  {
    a.d.b();
    this.m.a();
    ??? = this.A;
    ((auu)???).b = false;
    ((auu)???).a = true;
    this.C.f = false;
    this.w.c = false;
    this.C.a = false;
    this.z.c.clear();
    ??? = this.t;
    ((abp)???).c.clear();
    ((abp)???).a = false;
    h();
    ??? = com.whatsapp.registration.bc.a(this.b.b());
    Object localObject4;
    Object localObject2;
    if (!r.b((String)???))
    {
      localObject4 = this.q;
      localObject2 = r.i();
      if (((com.whatsapp.messaging.w)localObject4).b.d)
      {
        localObject4 = ((com.whatsapp.messaging.w)localObject4).b;
        Log.d("encode/send-set-recovery-token");
        Message localMessage = Message.obtain(null, 0, 35, 0);
        localMessage.getData().putByteArray("rc", (byte[])localObject2);
        localMessage.getData().putString("rcJid", (String)???);
        ((com.whatsapp.messaging.m)localObject4).a(localMessage);
      }
    }
    if (this.c.z.e)
    {
      this.H.b();
      xg.i();
      this.u.b();
    }
    synchronized (this.n)
    {
      localObject2 = new LinkedHashMap(this.n);
      Log.i("sendUnackedMessages: " + ((LinkedHashMap)localObject2).size());
      this.n.clear();
      ??? = ((LinkedHashMap)localObject2).entrySet().iterator();
      if (((Iterator)???).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)???).next();
        this.e.a((Message)((Map.Entry)localObject2).getValue(), (String)((Map.Entry)localObject2).getKey());
      }
    }
    this.z.a(new zc(this));
    if (this.v.e())
    {
      ??? = Conversation.l();
      if (((Conversation.l)???).b) {
        this.x.a(((Conversation.l)???).a().W);
      }
    }
    if (this.A.d != this.v.e())
    {
      if (this.v.e()) {
        this.E.b();
      }
    }
    else
    {
      this.q.b();
      if (this.F.a.getBoolean("client_version_upgraded", false))
      {
        Log.i("message-handler-callback/handlerconnected running connected upgrade script");
        Log.i("message-handler-callback/handlerconnectedrequesting server properties");
        this.q.h();
        Log.i("message-handler-callback/handlerconnected requesting callability on all contacts");
        this.q.a(this.s.f());
        Log.i("message-handler-callback/handlerconnected completed connected upgrade script");
        bu.a(zf.a(this));
        this.F.c().remove("client_version_upgraded").apply();
      }
      this.p.m();
      ??? = this.G;
      Log.d("twofactorauthmanager/on-connected");
      String str = ((q)???).e.getString("two_factor_auth_new_code", null);
      localObject4 = ((q)???).e.getString("two_factor_auth_new_email", null);
      if ((str == null) && (localObject4 == null)) {
        break label598;
      }
      Log.i("twofactorauthmanager/on-connected resending");
      ((q)???).a(str, (String)localObject4);
    }
    for (;;)
    {
      b.a.a.c.a().c(new com.whatsapp.g.i(true));
      return;
      if (!this.v.b()) {
        break;
      }
      this.E.d();
      break;
      label598:
      if (((q)???).f() == 0)
      {
        Log.i("twofactorauthmanager/on-connected asking for status");
        ??? = ((q)???).d;
        if (((com.whatsapp.messaging.w)???).b.d)
        {
          Log.i("sendmethods/send-get-two-factor-auth");
          ((com.whatsapp.messaging.w)???).b.a(Message.obtain(null, 0, 114, 0));
        }
      }
    }
  }
  
  public final void e()
  {
    Object localObject1 = this.A;
    boolean bool = ((auu)localObject1).a;
    ((auu)localObject1).b = false;
    ((auu)localObject1).a = false;
    this.E.b = false;
    this.w.a = false;
    this.w.b = 0L;
    h();
    this.B.b();
    this.x.b();
    if (bool)
    {
      this.y.a.a();
      Object localObject2 = this.y;
      localObject1 = new zd(this);
      localObject2 = ((com.whatsapp.util.w)localObject2).b.b().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ac)localObject1).a((Long)((Iterator)localObject2).next());
      }
      this.y.b.a();
      localObject2 = this.y;
      localObject1 = new ze(this);
      localObject2 = ((com.whatsapp.util.w)localObject2).c.b().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ac)localObject1).a((Long)((Iterator)localObject2).next());
      }
      this.y.c.a();
    }
    if (this.v.c()) {
      this.I.c();
    }
    for (;;)
    {
      b.a.a.c.a().c(new com.whatsapp.g.i(false));
      return;
      if ((this.v.d()) && (bool)) {
        this.E.b();
      }
    }
  }
  
  public final void f()
  {
    Log.i("message-handler-callback/handlerconnected/handleclockwrong");
    if ((this.o.e == null) || (!this.o.e.f()))
    {
      Log.w("message-handler-callback/handlerconnected/displayclockwrong/notification " + new Date().toString() + " " + System.currentTimeMillis());
      a.a.a.a.d.a(this.a, this.a.getString(2131296439), 11);
      this.D.c = true;
    }
  }
  
  public final void g()
  {
    Log.i("message-handler-callback/handlerconnected/handlesoftwareexpired");
    if ((this.o.e == null) || (!this.o.e.g()))
    {
      Log.w("message-handler-callback/handlerconnected/displaysoftwareexpired/notification " + new Date().toString() + " " + System.currentTimeMillis());
      if (!av.g()) {
        break label107;
      }
    }
    label107:
    for (int i1 = 2131297872;; i1 = 2131297870)
    {
      a.a.a.a.d.a(this.a, this.a.getString(i1), 2);
      this.D.c = true;
      return;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/za.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */