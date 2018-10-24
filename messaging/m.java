package com.whatsapp.messaging;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import b.a.a.c;
import com.whatsapp.Voip;
import com.whatsapp.aat;
import com.whatsapp.ahc;
import com.whatsapp.aic;
import com.whatsapp.and;
import com.whatsapp.ane;
import com.whatsapp.atv;
import com.whatsapp.au;
import com.whatsapp.auj;
import com.whatsapp.auu;
import com.whatsapp.g.i;
import com.whatsapp.pc;
import com.whatsapp.protocol.ab;
import com.whatsapp.protocol.al;
import com.whatsapp.pv;
import com.whatsapp.registration.x;
import com.whatsapp.service.GcmFGService;
import com.whatsapp.sr;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.dns.DnsCacheEntrySerializable;
import com.whatsapp.va;
import com.whatsapp.za;
import com.whatsapp.zg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class m
{
  private static final AtomicBoolean X = new AtomicBoolean();
  private static CountDownLatch Y = new CountDownLatch(1);
  private static volatile m j;
  private static final String k = m.class.getCanonicalName() + ".CONNECTIVITY_RETRY_ACTION";
  private static final String l = m.class.getCanonicalName() + ".LOGOUT_ACTION";
  private static final String m = m.class.getCanonicalName() + ".RECONNECT_ACTION";
  private static final String n = m.class.getCanonicalName() + ".CLIENT_PINGER_ACTION";
  private final Object A = new Object();
  private final l B = new l("message_handler/logged_flag/must_reconnect", true);
  private final l C = new l("message_handler/logged_flag/must_ignore_network_once", false);
  private final l D = new l("message_handler/logged_flag/disconnected", true);
  private final Map<String, com.whatsapp.util.m<Void>> E = new HashMap();
  private final Map<al, com.whatsapp.util.m<Void>> F = new HashMap();
  private boolean G;
  private boolean H;
  private boolean I = false;
  private final va J;
  private final ahc K;
  private final x L;
  private final and M;
  private final pc N;
  private final sr O;
  private final auu P;
  private final ane Q;
  private final aat R;
  private final atv S;
  private HandlerThread T;
  private Handler U;
  private final BroadcastReceiver V = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramAnonymousIntent.getAction())) {
        if (!m.j(m.this).post(p.a(this))) {
          Log.w("failed to post checkNetworkState runnable: " + paramAnonymousIntent);
        }
      }
      do
      {
        return;
        if (!m.m().equals(paramAnonymousIntent.getAction())) {
          break;
        }
      } while (m.j(m.this).post(q.a(this)));
      Log.w("failed to post checkNetworkState runnable: " + paramAnonymousIntent);
      return;
      Log.w("unknown intent received in connectivity receiver " + paramAnonymousIntent);
    }
  };
  private final Handler W = new Handler(n.a(this));
  private final BroadcastReceiver Z = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (m.n().equals(paramAnonymousIntent.getAction()))
      {
        Log.i("xmpp/handler/logout-timer/timeout");
        if (!m.this.j())
        {
          Log.d("xmpp/handler/logout-timer/removetimer");
          m.k(m.this);
          m.i(m.this);
          return;
        }
        if (Voip.e())
        {
          Log.d("voip call in prgress; reset logout timer");
          m.l(m.this);
          m.a(m.this).e();
          return;
        }
        if (m.a(m.this) != null)
        {
          m.a(m.this).a(false);
          return;
        }
        Log.i("xmpp/handler/logout-timer ignoring due to null sending channel");
        return;
      }
      Log.w("unknown intent received in logout receiver " + paramAnonymousIntent);
    }
  };
  public f.d a;
  public final d b;
  c c;
  public volatile boolean d;
  public volatile boolean e;
  public String f;
  public volatile boolean g = true;
  public final Context h;
  public final pv i;
  private final k o;
  private f p;
  private final a q = new a(Looper.getMainLooper());
  private volatile boolean r;
  private AtomicInteger s = new AtomicInteger();
  private int t;
  private boolean u = false;
  private int v = -1;
  private final Object w = new Object();
  private long x = 0L;
  private long y = 10000L;
  private final Random z = new Random();
  
  private m(Context paramContext, pv parampv, va paramva, ahc paramahc, x paramx, and paramand, pc parampc, sr paramsr, auu paramauu, ane paramane, aat paramaat, atv paramatv, k paramk)
  {
    this.h = paramContext;
    this.i = parampv;
    this.J = paramva;
    this.K = paramahc;
    this.L = paramx;
    this.M = paramand;
    this.N = parampc;
    this.O = paramsr;
    this.P = paramauu;
    this.Q = paramane;
    this.R = paramaat;
    this.S = paramatv;
    this.o = paramk;
    this.b = new d(Looper.getMainLooper());
    paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if (m.k().equals(paramAnonymousIntent.getAction()))
        {
          paramAnonymousContext = new StringBuilder("xmpp/handler/client-pinger-timer/fire; sendingChannel.nil?=");
          if (m.a(m.this) == null) {}
          for (boolean bool = true;; bool = false)
          {
            Log.i(bool);
            if (m.a(m.this) != null) {
              m.a(m.this).e();
            }
            return;
          }
        }
        Log.w("unknown intent received in client pinger receiver " + paramAnonymousIntent);
      }
    }, new IntentFilter(n), "com.whatsapp.permission.BROADCAST", null);
    paramContext.registerReceiver(this.Z, new IntentFilter(l), "com.whatsapp.permission.BROADCAST", null);
    paramContext.registerReceiver(new BroadcastReceiver()new IntentFilter
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if (m.l().equals(paramAnonymousIntent.getAction()))
        {
          Log.i("xmpp/handler/reconnect");
          m.this.d();
          return;
        }
        Log.w("unknown intent received in reconnect receiver " + paramAnonymousIntent);
      }
    }, new IntentFilter(m), "com.whatsapp.permission.BROADCAST", null);
  }
  
  public static m a()
  {
    if (j == null) {}
    try
    {
      if (j == null) {
        j = new m(u.a(), pv.a(), va.a(), ahc.a(), x.a(), and.a(), pc.a(), sr.a(), auu.a(), ane.a(), aat.a(), atv.a(), k.a());
      }
      return j;
    }
    finally {}
  }
  
  private boolean a(String paramString)
  {
    synchronized (this.E)
    {
      boolean bool = this.E.containsKey(paramString);
      return bool;
    }
  }
  
  static boolean h()
  {
    Log.i("awaiting captive wifi status");
    Y.await();
    boolean bool = X.get();
    Log.i("captive wifi status is " + bool);
    return bool;
  }
  
  private void o()
  {
    synchronized (this.E)
    {
      Iterator localIterator = this.E.entrySet().iterator();
      if (localIterator.hasNext()) {
        ((com.whatsapp.util.m)((Map.Entry)localIterator.next()).getValue()).a();
      }
    }
    this.E.clear();
  }
  
  private void p()
  {
    synchronized (this.F)
    {
      Iterator localIterator = this.F.entrySet().iterator();
      if (localIterator.hasNext()) {
        ((com.whatsapp.util.m)((Map.Entry)localIterator.next()).getValue()).a();
      }
    }
    this.F.clear();
  }
  
  private void q()
  {
    for (;;)
    {
      synchronized (this.A)
      {
        l locall = this.B;
        if (!j())
        {
          bool = true;
          locall.a(bool);
          return;
        }
      }
      boolean bool = false;
    }
  }
  
  private long r()
  {
    synchronized (this.w)
    {
      if (this.x > 172800000L) {
        return 172800000L;
      }
      this.y += this.x;
      this.x = (this.y - this.x);
      long l1 = this.y;
      long l2 = this.x;
      return l1 - l2;
    }
  }
  
  private static Intent s()
  {
    return new Intent(l).setPackage(au.b());
  }
  
  private boolean t()
  {
    boolean bool = false;
    synchronized (this.Z)
    {
      if (PendingIntent.getBroadcast(this.h, 0, s(), 1610612736) != null) {
        bool = true;
      }
      Log.i("xmpp/handler/logout-timer/has=" + bool);
      return bool;
    }
  }
  
  private void u()
  {
    synchronized (this.Z)
    {
      Log.i("xmpp/handler/logout-timer/cancel");
      PendingIntent localPendingIntent = PendingIntent.getBroadcast(this.h, 0, s(), 1610612736);
      if (localPendingIntent != null)
      {
        ((AlarmManager)this.h.getSystemService("alarm")).cancel(localPendingIntent);
        localPendingIntent.cancel();
      }
      return;
    }
  }
  
  private void v()
  {
    for (;;)
    {
      PendingIntent localPendingIntent;
      synchronized (this.Z)
      {
        Log.i("xmpp/handler/logout-timer/start");
        AlarmManager localAlarmManager = (AlarmManager)this.h.getSystemService("alarm");
        localPendingIntent = PendingIntent.getBroadcast(this.h, 0, s(), 1073741824);
        localAlarmManager.cancel(localPendingIntent);
        if (Build.VERSION.SDK_INT >= 23)
        {
          localAlarmManager.setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + 600000L, localPendingIntent);
          return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
          localAlarmManager.setExact(2, SystemClock.elapsedRealtime() + 600000L, localPendingIntent);
        }
      }
      ((AlarmManager)localObject).set(2, SystemClock.elapsedRealtime() + 600000L, localPendingIntent);
    }
  }
  
  public final Future<Void> a(al paramal, Message paramMessage)
  {
    com.whatsapp.util.n localn = new com.whatsapp.util.n();
    synchronized (this.F)
    {
      this.F.put(paramal, localn);
      a(paramMessage);
      return localn;
    }
  }
  
  public final Future<Void> a(String paramString, Message paramMessage, boolean paramBoolean)
  {
    if (paramString == null) {
      throw new NullPointerException("messageHandler/sendIq: id is null");
    }
    if ((paramBoolean) && (a(paramString))) {
      throw new b("messageHandler/sendIq: duplicate id: " + paramString);
    }
    com.whatsapp.util.n localn = new com.whatsapp.util.n();
    synchronized (this.E)
    {
      this.E.put(paramString, localn);
      a(paramMessage);
      return localn;
    }
  }
  
  public final void a(long paramLong)
  {
    if (!((i)c.a().a(i.class)).a)
    {
      Log.i("app/msghandler-not-connected/connecting-now");
      final ConditionVariable localConditionVariable = new ConditionVariable(false);
      final AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
      Object local6 = new Object()
      {
        public final void onEventAsync(i paramAnonymousi)
        {
          Log.i("app/msghandler-connected/" + paramAnonymousi.a);
          if (paramAnonymousi.a)
          {
            localAtomicBoolean.set(true);
            localConditionVariable.open();
          }
        }
      };
      try
      {
        a(false, false, false, null, null, null, null, false);
        Log.i("app/waiting-for-msghandler-to-be-connected");
        if (!localConditionVariable.block(paramLong))
        {
          Log.i("gdrive-service/backup-map/timeout-while-waiting-for-msghandler-to-be-connected/abort");
          throw new zg("Timeout while waiting for message service to connect");
        }
      }
      finally
      {
        c.a().a(local6);
      }
      if (!localAtomicBoolean.get())
      {
        Log.e("app/failed-to-connect-to-msgservice/abort");
        throw new zg("Message service failed to connect");
      }
      if (this.L.a)
      {
        Log.e("app/failed-to-login/abort");
        throw new zg("Failed to log into WhatsApp servers.");
      }
      c.a().a(local6);
    }
    Log.i("app/msghandler-connected/true");
  }
  
  public final void a(Message paramMessage)
  {
    Log.i("MessageHandler/sendXmpp; type=" + paramMessage.arg1);
    int i1;
    switch (paramMessage.arg1)
    {
    default: 
      i1 = 0;
      if (i1 != 0) {
        this.a.a(Message.obtain(paramMessage));
      }
      switch (paramMessage.arg1)
      {
      }
      break;
    }
    for (int i2 = 0;; i2 = 1)
    {
      if (i2 != 0)
      {
        i();
        g();
        a(true, false, false, false, null, null, null, null);
      }
      if (i1 == 0) {
        this.a.a(Message.obtain(paramMessage));
      }
      return;
      i1 = 1;
      break;
    }
  }
  
  public final void a(Message paramMessage, String paramString)
  {
    int i1 = paramMessage.arg1;
    if (this.d)
    {
      u.c.b.a(paramMessage, paramString);
      a(paramMessage);
      return;
    }
    Log.i("app/send-message/add-to-pending type: " + i1 + " id: " + paramString);
    this.O.a(paramString, paramMessage);
  }
  
  final void a(boolean paramBoolean)
  {
    Object localObject1 = this.M.e;
    if (localObject1 == null) {
      Log.w("xmpp/handler/network cm=null");
    }
    boolean bool2;
    for (localObject1 = null;; localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo())
    {
      Log.i("xmpp/handler/network/active " + localObject1 + " isRetry=" + paramBoolean);
      this.Q.b();
      if (localObject1 != null) {
        break;
      }
      this.W.sendMessage(Message.obtain(this.W, 0, -1, 0));
      bool2 = false;
      X.set(bool2);
      Y.countDown();
      return;
    }
    int i1;
    if (((NetworkInfo)localObject1).getState() == NetworkInfo.State.CONNECTED)
    {
      i1 = 1;
      if (i1 == 0) {
        break label393;
      }
    }
    label170:
    label282:
    label326:
    label393:
    for (boolean bool1 = CaptivePortalActivity.a(this.i, (NetworkInfo)localObject1);; bool1 = false)
    {
      Object localObject2 = this.W;
      Handler localHandler = this.W;
      int i3 = ((NetworkInfo)localObject1).getType();
      int i2;
      if ((i1 != 0) && (!bool1))
      {
        i2 = 1;
        ((Handler)localObject2).sendMessage(Message.obtain(localHandler, 0, i3, i2));
        if ((i1 == 0) || (!bool1)) {
          break label326;
        }
        bool2 = bool1;
        if (paramBoolean) {
          break;
        }
        localObject1 = new Intent(k);
        localObject1 = PendingIntent.getBroadcast(this.h, 0, (Intent)localObject1, 0);
        localObject2 = (AlarmManager)this.h.getSystemService("alarm");
        if (Build.VERSION.SDK_INT < 23) {
          break label282;
        }
        ((AlarmManager)localObject2).setExactAndAllowWhileIdle(2, SystemClock.elapsedRealtime() + 60000L, (PendingIntent)localObject1);
      }
      for (;;)
      {
        Log.i("connectivity retry alarm set for 60000ms from now");
        return;
        i1 = 0;
        break;
        i2 = 0;
        break label170;
        if (Build.VERSION.SDK_INT >= 19) {
          ((AlarmManager)localObject2).setExact(2, SystemClock.elapsedRealtime() + 60000L, (PendingIntent)localObject1);
        } else {
          ((AlarmManager)localObject2).set(2, SystemClock.elapsedRealtime() + 60000L, (PendingIntent)localObject1);
        }
      }
      localObject1 = new Intent(k);
      localObject1 = PendingIntent.getBroadcast(this.h, 0, (Intent)localObject1, 536870912);
      bool2 = bool1;
      if (localObject1 == null) {
        break;
      }
      Log.i("connectivity retry alarm canceled");
      ((AlarmManager)this.h.getSystemService("alarm")).cancel((PendingIntent)localObject1);
      bool2 = bool1;
      break;
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, String[] paramArrayOfString, ArrayList<DnsCacheEntrySerializable> paramArrayList, boolean paramBoolean4)
  {
    Message localMessage = Message.obtain(null, 0, 2, 0);
    localMessage.getData().putBoolean("force", true);
    localMessage.getData().putBoolean("reset", paramBoolean1);
    localMessage.getData().putBoolean("check_connection", paramBoolean2);
    localMessage.getData().putBoolean("notify_on_failure", paramBoolean3);
    localMessage.getData().putString("ip_address", paramString1);
    localMessage.getData().putString("cl_sess", paramString2);
    localMessage.getData().putStringArray("fallback_ips", paramArrayOfString);
    localMessage.getData().putSerializable("resolved_fallback_ips", paramArrayList);
    localMessage.getData().putBoolean("fgservice", paramBoolean4);
    this.b.sendMessage(localMessage);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String[] paramArrayOfString, ArrayList<DnsCacheEntrySerializable> paramArrayList, String paramString2)
  {
    for (;;)
    {
      synchronized (this.A)
      {
        paramArrayOfString = k.a(this.h, paramArrayOfString, paramArrayList);
        Log.d("xmpp/handler/reconnect/loaded_fallbacks " + paramArrayOfString);
        if (this.D.a) {
          break;
        }
        paramBoolean1 = TextUtils.isEmpty(paramString1);
        if (!paramBoolean1) {
          try
          {
            if (Integer.parseInt(paramString1) == this.t)
            {
              this.a.a(true);
              return;
            }
          }
          catch (NumberFormatException paramArrayOfString)
          {
            Log.w("xmpp/handler/reconnect invalid sessionId=" + paramString1);
          }
        }
        if (paramBoolean2)
        {
          Log.i("xmpp/handler/reconnect/not_disconnected/check_connectivity");
          this.a.e();
          if ((j()) && (!t())) {
            v();
          }
          return;
        }
      }
      Log.d("xmpp/handler/reconnect/not_disconnected");
    }
    if (paramBoolean1)
    {
      Log.d("xmpp/handler/reconnect/forced");
      this.B.a(true);
      this.C.a(true);
    }
    while (this.B.a)
    {
      if ((!this.u) || (this.v == -1))
      {
        if ((!this.B.a) || (!this.C.a)) {
          break;
        }
        this.C.a(false);
        Log.i("xmpp/handler/network/ignore (" + this.u + ',' + this.v + ')');
        this.Q.b();
      }
      if (this.r) {
        break label333;
      }
      Log.d("xmpp/handler/reconnect/handler_stopped");
      return;
    }
    Log.d("xmpp/handler/reconnect/unnecessary");
    return;
    Log.i("xmpp/handler/reconnect/network_unavailable");
    return;
    label333:
    if ((this.c == null) || (this.a == null) || (this.I))
    {
      Log.d("xmpp/handler/reconnect/not_ready");
      return;
    }
    this.H = paramBoolean3;
    if (paramBoolean4) {
      this.h.startService(new Intent(this.h, GcmFGService.class));
    }
    Log.d("xmpp/handler/reconnect");
    if (!this.N.e()) {
      if (auj.j()) {
        break label460;
      }
    }
    for (;;)
    {
      this.P.d = paramBoolean1;
      this.a.a(this.f, paramString2, paramBoolean1, this.g, paramArrayOfString);
      return;
      paramBoolean1 = false;
      continue;
      label460:
      paramBoolean1 = true;
    }
  }
  
  public final void b()
  {
    Log.d("xmpp/mustbelong");
    Object localObject = new Bundle();
    ((Bundle)localObject).putBoolean("long_connect", true);
    localObject = Message.obtain(null, 0, 3, 0, localObject);
    this.b.sendMessage((Message)localObject);
    a(false, false, false, null, null, null, null, false);
  }
  
  public final void c()
  {
    Message localMessage = Message.obtain(null, 0, 0, 0);
    localMessage.getData().putBoolean("should_register", true);
    this.b.sendMessage(localMessage);
  }
  
  public final void d()
  {
    Message localMessage = Message.obtain(null, 0, 2, 0);
    localMessage.getData().putBoolean("force", true);
    this.b.sendMessage(localMessage);
  }
  
  public final void e()
  {
    Log.i("xmpp/service/stop");
    this.d = false;
    Message localMessage = Message.obtain(null, 0, 1, 0);
    localMessage.getData().putBoolean("should_unregister", false);
    this.b.sendMessage(localMessage);
  }
  
  public final String f()
  {
    return "0" + Integer.toHexString(this.s.getAndIncrement());
  }
  
  public final void g()
  {
    synchronized (this.w)
    {
      Log.i("xmpp/handler/back_off/reset");
      this.x = 0L;
      this.y = 10000L;
      return;
    }
  }
  
  public final void i()
  {
    synchronized (this.Z)
    {
      Log.i("xmpp/handler/logout-timer/reset");
      if (t()) {
        v();
      }
      return;
    }
  }
  
  public final boolean j()
  {
    boolean bool1 = true;
    boolean bool2 = this.S.a.contains("c2dm_reg_id");
    boolean bool3 = this.S.a.getBoolean("has_had_background_data_disabled", false);
    Log.d("app/has-had-bkgnd-off " + bool3);
    if (!bool3) {}
    ConnectivityManager localConnectivityManager;
    for (int i1 = 1;; i1 = 0)
    {
      localConnectivityManager = this.M.e;
      if (localConnectivityManager != null) {
        break;
      }
      Log.w("xmpp/service/useshort cm=null");
      return false;
    }
    if ((!aic.y) && (bool2) && (localConnectivityManager.getBackgroundDataSetting()) && (this.S.d() < 3) && (i1 != 0)) {}
    for (;;)
    {
      Log.d("xmpp/service/useshort/" + bool1 + "/force_long_connect/" + aic.y);
      return bool1;
      bool1 = false;
    }
  }
  
  final class a
    extends Handler
    implements f.a
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void a()
    {
      Log.d("xmpp/handler/send/connecting");
      sendEmptyMessage(1);
    }
    
    public final void a(int paramInt)
    {
      Log.d("xmpp/handler/send/connected");
      obtainMessage(3, paramInt, 0).sendToTarget();
    }
    
    public final void a(Message paramMessage)
    {
      Log.d("xmpp/handler/send/xmpp_recv");
      paramMessage.what = 5;
      if (paramMessage.arg1 == 52)
      {
        sendMessageAtFrontOfQueue(paramMessage);
        return;
      }
      sendMessage(paramMessage);
    }
    
    public final void a(f.d paramd)
    {
      Log.d("xmpp/handler/send/sending_channel_ready");
      obtainMessage(0, paramd).sendToTarget();
    }
    
    public final void a(ab paramab)
    {
      Log.d("xmpp/handler/send/disconnected");
      obtainMessage(2, paramab).sendToTarget();
    }
    
    public final void a(al paramal)
    {
      Log.d("xmpp/handler/send/ack; stanzaKey=" + paramal);
      obtainMessage(9, paramal).sendToTarget();
    }
    
    public final void a(String paramString)
    {
      Log.d("xmpp/handler/send/iq-response; id=" + paramString);
      obtainMessage(8, paramString).sendToTarget();
    }
    
    public final void a(boolean paramBoolean)
    {
      Log.d("xmpp/handler/send/disconnected");
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        obtainMessage(4, i, 0).sendToTarget();
        return;
      }
    }
    
    public final void b()
    {
      Log.d("xmpp/handler/send/clock-wrong");
      sendEmptyMessage(6);
    }
    
    public final void c()
    {
      Log.d("xmpp/handler/send/software-expired");
      sendEmptyMessage(7);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      boolean bool = true;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        Log.d("xmpp/handler/recv/sending_channel_ready");
        m.a(m.this, (f.d)paramMessage.obj);
        return;
      case 1: 
        Log.d("xmpp/handler/recv/connecting");
        m.m(m.this);
        return;
      case 2: 
        Log.d("xmpp/handler/recv/login_failed");
        m.n(m.this);
        m.a(m.this, (ab)paramMessage.obj);
        return;
      case 3: 
        Log.d("xmpp/handler/recv/connected; sessionId=" + paramMessage.arg1);
        m.n(m.this);
        m.a(m.this, paramMessage.arg1);
        return;
      case 4: 
        Log.d("xmpp/handler/recv/disconnected");
        m localm = m.this;
        if (paramMessage.arg1 == 1) {}
        for (;;)
        {
          m.c(localm, bool);
          return;
          bool = false;
        }
      case 6: 
        Log.d("xmpp/handler/recv/clock-wrong");
        m.o(m.this).f();
        return;
      case 7: 
        Log.d("xmpp/handler/recv/software-expired");
        m.n(m.this);
        m.o(m.this).g();
        return;
      case 5: 
        Log.d("xmpp/handler/recv/xmpp_recv");
        m.a(m.this, paramMessage);
        return;
      case 8: 
        Log.d("xmpp/handler/recv/iq-response; id=" + paramMessage.obj);
        m.a(m.this, (String)paramMessage.obj);
        return;
      }
      Log.d("xmpp/handler/recv/ack; stanzaKey=" + paramMessage.obj);
      m.a(m.this, (al)paramMessage.obj);
    }
  }
  
  public static final class b
    extends Exception
  {
    public b(String paramString)
    {
      super();
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(Message paramMessage);
    
    public abstract void a(ab paramab);
    
    public abstract void b();
    
    public abstract void c();
    
    public abstract void d();
    
    public abstract void e();
    
    public abstract void f();
    
    public abstract void g();
  }
  
  public final class d
    extends Handler
  {
    public d(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      m.b(m.this);
      if (ahc.e()) {
        Log.w("xmpp/handler/unsupported");
      }
      do
      {
        do
        {
          do
          {
            return;
            switch (paramMessage.arg1)
            {
            default: 
              Log.d("xmpp/handler/recv/unknown (start)");
              m.c(m.this);
              return;
            case 0: 
              Log.d("xmpp/handler/recv/start");
              m.a(m.this, false);
              bool1 = paramMessage.getData().getBoolean("should_register", false);
              m.c(m.this);
            }
          } while (!bool1);
          paramMessage = m.this;
          str = m.d(m.this).b();
          localObject = u.c.b;
        } while (paramMessage.e);
        Log.i("xmpp/handler/registered");
        paramMessage.f = str;
        paramMessage.c = ((m.c)localObject);
        paramMessage.a(true, false, false, false, null, null, null, null);
        if (paramMessage.a != null) {
          ((m.c)localObject).b();
        }
        paramMessage.e = true;
        return;
        Log.d("xmpp/handler/recv/stop_no_restart");
        if (paramMessage.getData().getBoolean("should_unregister", false)) {
          m.e(m.this);
        }
        m.f(m.this);
        m.a(m.this, true);
        return;
        paramMessage = paramMessage.getData();
        Log.d("xmpp/handler/recv/reconnect");
        m.g(m.this);
        m.c(m.this);
        boolean bool1 = paramMessage.getBoolean("reset", false);
        boolean bool2 = paramMessage.getBoolean("force", false);
        boolean bool3 = paramMessage.getBoolean("check_connection", false);
        boolean bool4 = paramMessage.getBoolean("notify_on_failure", false);
        String str = paramMessage.getString("ip_address");
        Object localObject = paramMessage.getString("cl_sess");
        String[] arrayOfString = paramMessage.getStringArray("fallback_ips");
        ArrayList localArrayList = (ArrayList)paramMessage.getSerializable("resolved_fallback_ips");
        boolean bool5 = paramMessage.getBoolean("fgservice", false);
        if (bool1) {
          m.h(m.this);
        }
        m.a(m.this, bool2, bool3, bool4, bool5, (String)localObject, arrayOfString, localArrayList, str);
        return;
        paramMessage = paramMessage.getData();
        Log.d("xmpp/handler/recv/setconnectiontype");
        m.c(m.this);
      } while (!paramMessage.getBoolean("long_connect", false));
      m.i(m.this);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */