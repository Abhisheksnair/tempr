package com.whatsapp.messaging;

import a.a.a.a.d;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.whatsapp.Statistics;
import com.whatsapp.ace;
import com.whatsapp.ach;
import com.whatsapp.ado;
import com.whatsapp.auj.h;
import com.whatsapp.auj.m;
import com.whatsapp.contact.sync.ContactSyncManager.ParcelableSyncUserRequest;
import com.whatsapp.location.bn;
import com.whatsapp.location.bo;
import com.whatsapp.proto.E2E.Message;
import com.whatsapp.proto.E2E.Message.a;
import com.whatsapp.proto.Protocol.MessageKey;
import com.whatsapp.proto.Protocol.MessageKey.a;
import com.whatsapp.proto.g;
import com.whatsapp.proto.g.a;
import com.whatsapp.protocol.aj;
import com.whatsapp.protocol.ak;
import com.whatsapp.protocol.al;
import com.whatsapp.protocol.am;
import com.whatsapp.protocol.ao;
import com.whatsapp.protocol.ar;
import com.whatsapp.protocol.av;
import com.whatsapp.protocol.b;
import com.whatsapp.protocol.b.1;
import com.whatsapp.protocol.b.10;
import com.whatsapp.protocol.b.11;
import com.whatsapp.protocol.b.12;
import com.whatsapp.protocol.b.13;
import com.whatsapp.protocol.b.14;
import com.whatsapp.protocol.b.15;
import com.whatsapp.protocol.b.17;
import com.whatsapp.protocol.b.18;
import com.whatsapp.protocol.b.19;
import com.whatsapp.protocol.b.2;
import com.whatsapp.protocol.b.20;
import com.whatsapp.protocol.b.21;
import com.whatsapp.protocol.b.22;
import com.whatsapp.protocol.b.23;
import com.whatsapp.protocol.b.24;
import com.whatsapp.protocol.b.25;
import com.whatsapp.protocol.b.26;
import com.whatsapp.protocol.b.27;
import com.whatsapp.protocol.b.3;
import com.whatsapp.protocol.b.30;
import com.whatsapp.protocol.b.31;
import com.whatsapp.protocol.b.32;
import com.whatsapp.protocol.b.33;
import com.whatsapp.protocol.b.35;
import com.whatsapp.protocol.b.36;
import com.whatsapp.protocol.b.37;
import com.whatsapp.protocol.b.38;
import com.whatsapp.protocol.b.39;
import com.whatsapp.protocol.b.4;
import com.whatsapp.protocol.b.40;
import com.whatsapp.protocol.b.41;
import com.whatsapp.protocol.b.44;
import com.whatsapp.protocol.b.45;
import com.whatsapp.protocol.b.46;
import com.whatsapp.protocol.b.47;
import com.whatsapp.protocol.b.48;
import com.whatsapp.protocol.b.49;
import com.whatsapp.protocol.b.5;
import com.whatsapp.protocol.b.52;
import com.whatsapp.protocol.b.53;
import com.whatsapp.protocol.b.54;
import com.whatsapp.protocol.b.55;
import com.whatsapp.protocol.b.57;
import com.whatsapp.protocol.b.58;
import com.whatsapp.protocol.b.59;
import com.whatsapp.protocol.b.6;
import com.whatsapp.protocol.b.60;
import com.whatsapp.protocol.b.61;
import com.whatsapp.protocol.b.62;
import com.whatsapp.protocol.b.63;
import com.whatsapp.protocol.b.64;
import com.whatsapp.protocol.b.65;
import com.whatsapp.protocol.b.67;
import com.whatsapp.protocol.b.68;
import com.whatsapp.protocol.b.7;
import com.whatsapp.protocol.b.71;
import com.whatsapp.protocol.b.72;
import com.whatsapp.protocol.b.8;
import com.whatsapp.protocol.b.9;
import com.whatsapp.protocol.b.a;
import com.whatsapp.protocol.b.b;
import com.whatsapp.protocol.f;
import com.whatsapp.protocol.i;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.j.c;
import com.whatsapp.protocol.m;
import com.whatsapp.protocol.t;
import com.whatsapp.protocol.u;
import com.whatsapp.protocol.v;
import com.whatsapp.protocol.w;
import com.whatsapp.protocol.x;
import com.whatsapp.protocol.y;
import com.whatsapp.protocol.z;
import com.whatsapp.qz;
import com.whatsapp.rj;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.xg.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import org.b.a.a.c;

final class as
  extends HandlerThread
{
  private final a a;
  private final LinkedList<Message> b = new LinkedList();
  private final c c = new c((byte)0);
  private boolean d = true;
  private b e;
  
  public as(a parama)
  {
    super("WriterThread");
    this.a = parama;
  }
  
  private void a(Message paramMessage)
  {
    Log.d("xmpp/writer/handlexmppsend");
    cj.f(paramMessage);
    if (this.d)
    {
      switch (paramMessage.arg1)
      {
      }
      for (i = 0; i == 0; i = 1)
      {
        cj.b(paramMessage);
        this.b.add(Message.obtain(paramMessage));
        return;
      }
      cj.c(paramMessage);
      return;
    }
    c localc;
    for (;;)
    {
      label1140:
      label1186:
      String str;
      try
      {
        localc = this.c;
        if (!(paramMessage.obj instanceof Bundle)) {
          continue;
        }
        localBundle = (Bundle)paramMessage.obj;
        switch (paramMessage.arg1)
        {
        case 6: 
        case 7: 
        case 39: 
        case 40: 
        case 80: 
          Log.e("xmppmsg/send/unknown what=" + paramMessage.what + "argv1=" + paramMessage.arg1 + "object=" + paramMessage.obj);
        }
      }
      catch (com.whatsapp.protocol.a locala)
      {
        Bundle localBundle;
        Log.d("tried to write too large of a buffer to the chat connection", locala);
        cj.d(paramMessage);
        continue;
        localc.a(locala.getString("pushId"), locala.getString("platform"));
        continue;
      }
      catch (IOException localIOException)
      {
        Log.d("unknown I/O error writing to the chat connection", localIOException);
        cj.e(paramMessage);
        this.d = true;
        paramMessage.getTarget().sendMessageAtFrontOfQueue(Message.obtain(paramMessage));
        this.a.a(this.e);
        continue;
        localc.a((com.whatsapp.as)paramMessage.obj);
        continue;
        localc.a((ce)paramMessage.obj);
        continue;
        localc.a(localIOException.getString("callerJid"), localIOException.getString("calleeJid"), localIOException.getString("callId"), localIOException.getLong("callDuration"), localIOException.getString("terminatorJid"), localIOException.getString("terminationReason"), localIOException.getString("mediaType"));
        continue;
        localc.a((ach)paramMessage.obj);
        continue;
        localc.a((ace)paramMessage.obj);
        continue;
        localObject1 = (Pair)paramMessage.obj;
        localc.a((String)((Pair)localObject1).first, (com.whatsapp.protocol.aw)((Pair)localObject1).second);
        continue;
        localc.a((String)paramMessage.obj, paramMessage.arg2);
        continue;
        localc.a((String)paramMessage.obj);
        continue;
        localObject1 = (ca)paramMessage.obj;
        localc.a(((ca)localObject1).a, ((ca)localObject1).b, ((ca)localObject1).c, ((ca)localObject1).d, ((ca)localObject1).e, ((ca)localObject1).f, ((ca)localObject1).g, ((ca)localObject1).h, ((ca)localObject1).i, ((ca)localObject1).j, ((ca)localObject1).k, ((ca)localObject1).l, ((ca)localObject1).m, ((ca)localObject1).n, ((ca)localObject1).o);
        continue;
        localc.a((j)paramMessage.obj);
        continue;
        localc.a((j)paramMessage.obj, ((Bundle)localObject1).getIntArray("unknownTags"));
        continue;
        localc.b((j)paramMessage.obj);
        continue;
        localc.a((cd)paramMessage.obj);
        continue;
        localc.c((j)paramMessage.obj);
        continue;
        localc.a((ado)paramMessage.obj);
        continue;
        localc.d((j)paramMessage.obj);
        continue;
        localc.a((bb)paramMessage.obj);
        continue;
        localc.b((String)paramMessage.obj);
        continue;
        Log.i("xmppmsg/send/create_group");
        localc.a((rj)paramMessage.obj);
        continue;
        localc.b((rj)paramMessage.obj);
        continue;
        localc.c((rj)paramMessage.obj);
        continue;
        localc.d((rj)paramMessage.obj);
        continue;
        localc.e((rj)paramMessage.obj);
        continue;
        Log.i("xmppmsg/send/group/leave_group");
        localc.f((rj)paramMessage.obj);
        continue;
        Log.i("xmppmsg/send/group/end_group");
        localc.g((rj)paramMessage.obj);
        continue;
        Log.i("xmppmsg/send/group/set_subject");
        localc.h((rj)paramMessage.obj);
        continue;
        Log.i("xmppmsg/send/group/clear-dirty");
        localc.c((String)paramMessage.obj);
        continue;
        Log.i("xmppmsg/send/group/get-groups");
        localc.e();
        continue;
        Log.i("xmppmsg/send/mms4/get-routing-info");
        localc.f();
        continue;
        localc.b(paramMessage.getData().getString("gid"), paramMessage.getData().getString("context"));
        continue;
        localc.a(paramMessage.getData().getString("id"), paramMessage.getData().getString("jid"), paramMessage.getData().getLong("seq"));
        continue;
        localc.a((bn)paramMessage.obj);
        continue;
        localc.a((bo)paramMessage.obj);
        continue;
        localc.a((bz)paramMessage.obj);
        continue;
        localc.a(paramMessage.getData().getString("jid"), paramMessage.getData().getByteArray("registrationId"), paramMessage.getData().getInt("retryCount"));
        continue;
        localc.d(paramMessage.getData().getString("jid"));
        continue;
        localObject1 = (Pair)paramMessage.obj;
        localc.a(((Long)((Pair)localObject1).first).longValue(), (f)((Pair)localObject1).second);
        continue;
        localc.g();
        continue;
        localc.i((rj)paramMessage.obj);
        continue;
        localc.h();
        continue;
        localc.b();
        continue;
        localc.a((Runnable)paramMessage.obj);
        continue;
        localc.c();
        continue;
        localc.d();
        continue;
        localc.a(((Bundle)localObject1).getString("lg"), ((Bundle)localObject1).getString("lc"), ((Bundle)localObject1).getString("userFeedback"), ((Bundle)localObject1).getInt("deleteReason"));
        continue;
        localc.a((cf)paramMessage.obj);
        continue;
        localc.a((xg.a)paramMessage.obj);
        continue;
        localc.b((xg.a)paramMessage.obj);
        continue;
        localc.a(((Bundle)localObject1).getString("url"), ((Bundle)localObject1).getBoolean("dedupe"));
        continue;
        localc.a(((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("jid"), ((Bundle)localObject1).getString("participant"));
        continue;
        Log.i("xmppmsg/send/set-recovery-token");
        localc.a(paramMessage.getData().getByteArray("rc"), paramMessage.getData().getString("rcJid"));
        continue;
        Log.i("xmppmsg/send/get-normalized-jid");
        localc.a((az)paramMessage.obj);
        continue;
        localc.a(((Boolean)paramMessage.obj).booleanValue());
        continue;
        localc.a(((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("mode"), ((Bundle)localObject1).getString("context"), ((Bundle)localObject1).getString("sid"), ((Bundle)localObject1).getParcelableArrayList("requests"), ((Bundle)localObject1).getStringArray("capabilities"));
        continue;
        localc.a(((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("mode"), ((Bundle)localObject1).getString("context"), ((Bundle)localObject1).getString("sid"), ((Bundle)localObject1).getString("phonenumber"));
        continue;
        localc.a((bx)paramMessage.obj);
        continue;
        localc.b((bx)paramMessage.obj);
        continue;
        localc.a((bu)paramMessage.obj);
        continue;
        localc.a((bv)paramMessage.obj);
        continue;
        localc.a((by)paramMessage.obj);
        continue;
        localc.a((Bundle)localObject1);
        continue;
        localc.a(((Bundle)localObject1).getString("toJid"), ((Bundle)localObject1).getString("msgId"), ((Bundle)localObject1).getBoolean("isValid"));
        continue;
        i = ((Bundle)localObject1).getInt("loginType");
        localc.a(((Bundle)localObject1).getString("ref"), ((Bundle)localObject1).getString("secret"), ((Bundle)localObject1).getString("encryptedSecret"), ((Bundle)localObject1).getString("browserId"), ((Bundle)localObject1).getString("token"), i, ((Bundle)localObject1).getInt("batteryLevel"), ((Bundle)localObject1).getBoolean("plugged"), ((Bundle)localObject1).getBoolean("powerSaveMode"), ((Bundle)localObject1).getString("lc"), ((Bundle)localObject1).getString("lg"), ((Bundle)localObject1).getBoolean("is24h"), ((Bundle)localObject1).getBoolean("isBizClient"));
        continue;
        localc.b(((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("ref"), ((Bundle)localObject1).getBoolean("active"));
        continue;
        localc.b(((Bundle)localObject1).getBoolean("isLogout"));
        continue;
        localc.a((ci)paramMessage.obj);
        continue;
        localc.b((ci)paramMessage.obj);
        continue;
        localc.c((ci)paramMessage.obj);
        continue;
        localc.d((ci)paramMessage.obj);
        continue;
        localc.a(((Bundle)localObject1).getInt("reason"), ((Bundle)localObject1).getString("ref"), ((Bundle)localObject1).getString("challenge"));
        continue;
        localc.e((ci)paramMessage.obj);
        continue;
        localc.f((ci)paramMessage.obj);
        continue;
        localc.g((ci)paramMessage.obj);
        continue;
        localc.h((ci)paramMessage.obj);
        continue;
        localc.i((ci)paramMessage.obj);
        continue;
        localc.j((ci)paramMessage.obj);
        continue;
        localc.a((auj.h)paramMessage.obj);
        continue;
        localObject2 = ((Bundle)localObject1).getString("id");
        str = ((Bundle)localObject1).getString("jid");
        long l = ((Bundle)localObject1).getLong("timestamp");
        boolean bool = ((Bundle)localObject1).getBoolean("fromMe");
        ((Bundle)localObject1).getString("participant");
        localc.a((String)localObject2, str, l, bool, ((Bundle)localObject1).getString("kind"));
        continue;
        localc.b(((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getInt("code"));
        continue;
        localc.a((bs)paramMessage.obj);
        continue;
        Log.i("xmppmsg/send/changenumber");
        localc.a((aw)paramMessage.obj);
        continue;
        localc.a(((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("jid"), ((Bundle)localObject1).getString("callId"), ((Bundle)localObject1).getBoolean("end"));
        continue;
        localc.b(((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("jid"), ((Bundle)localObject1).getString("callId"), ((Bundle)localObject1).getBoolean("end"));
        continue;
        localc.a(((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("jid"), ((Bundle)localObject1).getString("call-id"), ((Bundle)localObject1).getStringArray("encodings"), ((Bundle)localObject1).getIntArray("rates"), (byte[][])((Bundle)localObject1).getSerializable("endpoints"), ((Bundle)localObject1).getIntArray("endpointPriorities"), ((Bundle)localObject1).getBooleanArray("endpointEnablePortPredicting"), ((Bundle)localObject1).getInt("netMedium"), ((Bundle)localObject1).getByteArray("e2e"), ((Bundle)localObject1).getByte("e2eKeyGenVersion"), ((Bundle)localObject1).getStringArray("videoEncoding"), ((Bundle)localObject1).getByte("videoOrientation"), ((Bundle)localObject1).getInt("screenWidth"), ((Bundle)localObject1).getInt("screenHeight"), ((Bundle)localObject1).getInt("retryCount"), ((Bundle)localObject1).getInt("capabilityVer"), ((Bundle)localObject1).getByteArray("capabilityBitMask"));
        continue;
        localc.a(((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("jid"), ((Bundle)localObject1).getString("callId"), ((Bundle)localObject1).getString("encoding"), ((Bundle)localObject1).getInt("rate"), (byte[][])((Bundle)localObject1).getSerializable("endpoints"), ((Bundle)localObject1).getIntArray("endpointPriorities"), ((Bundle)localObject1).getBooleanArray("endpointEnablePortPredicting"), ((Bundle)localObject1).getInt("netMedium"), ((Bundle)localObject1).getByteArray("relayEndpoint"), ((Bundle)localObject1).getInt("relayLatency"), ((Bundle)localObject1).getString("videoEncoding"), ((Bundle)localObject1).getByte("videoOrientation"), ((Bundle)localObject1).getByte("e2eKeyGenVersion"));
        continue;
        localc.a(((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("jid"), ((Bundle)localObject1).getString("callId"), ((Bundle)localObject1).getString("encoding"), ((Bundle)localObject1).getInt("rate"), ((Bundle)localObject1).getString("videoEncoding"), ((Bundle)localObject1).getByte("videoOrientation"), ((Bundle)localObject1).getInt("screenWidth"), ((Bundle)localObject1).getInt("screenHeight"), ((Bundle)localObject1).getByte("e2eKeyGenVersion"), ((Bundle)localObject1).getInt("capabilityVer"), ((Bundle)localObject1).getByteArray("capabilityBitMask"));
        continue;
        localc.a(((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("jid"), ((Bundle)localObject1).getString("callId"), ((Bundle)localObject1).getByte("videoEnabled"), ((Bundle)localObject1).getByte("videoOrientation"), ((Bundle)localObject1).getString("codecType"));
        continue;
        localc.a(((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("jid"), ((Bundle)localObject1).getString("callId"), ((Bundle)localObject1).getString("reason"), ((Bundle)localObject1).getByteArray("registration"), ((Bundle)localObject1).getInt("retryCount"));
        continue;
        localc.a(((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("jid"), ((Bundle)localObject1).getString("callId"), ((Bundle)localObject1).getString("reason"), ((Bundle)localObject1).getInt("videoState"), ((Bundle)localObject1).getLong("duration"));
        continue;
        localc.a(((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("jid"), ((Bundle)localObject1).getString("callId"), (byte[][])((Bundle)localObject1).getSerializable("endpoints"), ((Bundle)localObject1).getIntArray("endpointPriorities"), ((Bundle)localObject1).getBooleanArray("endpointEnablePortPredicting"), ((Bundle)localObject1).getInt("netMedium"), ((Bundle)localObject1).getInt("capabilityVer"), ((Bundle)localObject1).getByteArray("capabilityBitMask"));
        continue;
        localc.a(((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("jid"), ((Bundle)localObject1).getString("callId"), (byte[][])((Bundle)localObject1).getSerializable("endpoints"), ((Bundle)localObject1).getIntArray("latencies"));
        continue;
        localc.a(((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("jid"), ((Bundle)localObject1).getString("callId"), ((Bundle)localObject1).getByteArray("endpoint"), ((Bundle)localObject1).getInt("latency"));
        continue;
        localc.a((cc)paramMessage.obj);
        continue;
        localc.i();
        continue;
        localc.a((ch)paramMessage.obj);
        continue;
        localc.a((cg)paramMessage.obj);
        continue;
        localc.j();
        continue;
        localc.b(((Bundle)localObject1).getString("to"), ((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("callId"));
        continue;
        localc.c(((Bundle)localObject1).getString("to"), ((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("callId"));
        continue;
        localc.d(((Bundle)localObject1).getString("to"), ((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("callId"));
        continue;
        localc.b(((Bundle)localObject1).getString("to"), ((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("callId"), ((Bundle)localObject1).getInt("batteryState"));
        continue;
        localc.a((br)paramMessage.obj);
        continue;
        localc.a((bt)paramMessage.obj);
        continue;
        localc.a(((ParcelableStanzaKey)((Bundle)localObject1).getParcelable("stanzaKey")).a);
        continue;
        localc.a(((ParcelableStanzaKey)((Bundle)localObject1).getParcelable("stanzaKey")).a, ((Bundle)localObject1).getBoolean("disable"));
        continue;
        localc.a(((Bundle)localObject1).getByteArray("identity"), ((Bundle)localObject1).getByteArray("registration"), ((Bundle)localObject1).getByte("type"), ParcelablePreKey.a((ParcelablePreKey[])((Bundle)localObject1).getParcelableArray("preKeys")), ((ParcelablePreKey)((Bundle)localObject1).getParcelable("signedPreKey")).a);
        continue;
        localc.a(((Bundle)localObject1).getString("iqId"), ((ParcelablePreKey)((Bundle)localObject1).getParcelable("signedPreKey")).a, (y)paramMessage.obj);
        continue;
        localc.a(paramMessage.getData().getString("id"), paramMessage.getData().getStringArray("jids"));
        continue;
        localc.k();
        continue;
        localObject1 = ((List)paramMessage.obj).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        localObject2 = (j)((Iterator)localObject1).next();
        if (((j)localObject2).k) {
          continue;
        }
        localc.a((j)localObject2);
        continue;
        localc.a(paramMessage.getData().getStringArray("jids"), paramMessage.getData().getStringArray("capabilities"));
        continue;
        localObject1 = (Pair)paramMessage.obj;
        localc.a((al)((Pair)localObject1).first, (org.b.a.a.a)((Pair)localObject1).second);
        continue;
        localc.c(((Bundle)localObject1).getString("code"), ((Bundle)localObject1).getString("email"));
        continue;
        localc.l();
        continue;
        str = ((Bundle)localObject1).getString("id");
        arrayOfLocale = (Locale[])((Bundle)localObject1).getSerializable("locales");
        if (!((Bundle)localObject1).containsKey("haveHashes")) {
          break label5021;
        }
      }
      cj.a(paramMessage);
      return;
      if (paramMessage.peekData() == null) {
        break;
      }
      localBundle = paramMessage.getData();
      continue;
      localc.a();
      continue;
      Locale[] arrayOfLocale;
      localObject2 = (String[])((Bundle)localObject1).getStringArray("haveHashes");
      label4745:
      localc.a(str, arrayOfLocale, (String[])localObject2, ((Bundle)localObject1).getString("namespace"), ((Bundle)localObject1).getString("reason"));
      continue;
      localc.d(((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("jid"));
      continue;
      localc.a(((Bundle)localObject1).getString("id"), (byte[])((Bundle)localObject1).getSerializable("certificate"));
      continue;
      localc.k((ci)paramMessage.obj);
    }
    Object localObject2 = ((Bundle)localObject1).getString("id");
    int i = ((Bundle)localObject1).getInt("statusDistributionMode");
    if (((Bundle)localObject1).containsKey("jids")) {}
    for (Object localObject1 = ((Bundle)localObject1).getStringArray("jids");; localObject1 = null)
    {
      localc.a((String)localObject2, i, (String[])localObject1, (y)paramMessage.obj);
      break label1186;
      localc.a((bw)paramMessage.obj);
      break label1186;
      localc.l((ci)paramMessage.obj);
      break label1186;
      localc.a(((Bundle)localObject1).getString("id"), ((Bundle)localObject1).getString("revokedId"), ((Bundle)localObject1).getBoolean("owner"), ((Bundle)localObject1).getString("jid"), ((Bundle)localObject1).getString("participant"));
      break label1186;
      localc.b((bb)paramMessage.obj);
      break label1140;
      break label1140;
      localObject1 = null;
      break;
      label5021:
      localObject2 = null;
      break label4745;
    }
  }
  
  protected final void onLooperPrepared()
  {
    this.a.a(new b());
  }
  
  public static abstract interface a
  {
    public abstract void a(as.d paramd);
    
    public abstract void a(b paramb);
    
    public abstract void a(j.b paramb);
  }
  
  @SuppressLint({"HandlerLeak"})
  final class b
    extends Handler
    implements as.d
  {
    public b()
    {
      super();
    }
    
    public final void a()
    {
      Log.d("xmpp/writer/send/disconnected");
      sendEmptyMessage(1);
    }
    
    public final void a(Message paramMessage)
    {
      Log.d("xmpp/writer/send/xmpp_send");
      paramMessage.what = 2;
      sendMessage(paramMessage);
    }
    
    public final void a(b paramb)
    {
      Log.d("xmpp/writer/send/connected");
      obtainMessage(0, paramb).sendToTarget();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        Log.i("xmpp/writer/recv/connected");
        as.a(as.this, (b)paramMessage.obj);
        return;
      case 1: 
        Log.d("xmpp/writer/recv/disconnected");
        as.a(as.this);
        return;
      }
      Log.d("xmpp/writer/recv/xmpp_send");
      as.a(as.this, paramMessage);
    }
  }
  
  final class c
    implements cb
  {
    private c() {}
    
    public final void a()
    {
      Log.d("xmpp/writer/before/write/pong");
      b localb = as.b(as.this);
      ak localak = new ak("iq", new z[] { new z("type", "result"), new z("to", "s.whatsapp.net") });
      localb.b.a(localak);
      Log.i("xmpp/writer/write/pong");
    }
    
    public final void a(int paramInt, String paramString1, String paramString2)
    {
      Log.d("xmpp/writer/before/write/web-deny-reason; ref=" + paramString1 + "; challenge=" + paramString2 + "; reason=" + paramInt);
      b localb = as.b(as.this);
      z localz = null;
      Object localObject;
      label118:
      String str;
      switch (paramInt)
      {
      default: 
        Log.i("xmpp/writer/write/web-deny-reason; ref=" + paramString1 + "; challenge=" + paramString2 + "; reason=" + paramInt);
        return;
      case 0: 
        localObject = "conflict";
        i = localb.j + 1;
        localb.j = i;
        str = Integer.toHexString(i);
        localb.d.put(str, new b.64(localb, paramInt, paramString1));
        if (localz != null) {
          break;
        }
      }
      for (int i = 1;; i = 3)
      {
        z[] arrayOfz = new z[i];
        arrayOfz[0] = new z("reason", (String)localObject);
        if (localz != null)
        {
          arrayOfz[1] = new z("version", "0.14.8");
          arrayOfz[2] = localz;
        }
        localObject = new ak("deny", arrayOfz, paramString1);
        localObject = new ak("iq", new z[] { new z("type", "set"), new z("id", str), new z("xmlns", "w:web") }, (ak)localObject);
        localb.b.a((ak)localObject);
        break;
        localObject = "fail";
        break label118;
        localObject = "challenge";
        localz = new z("challenge", paramString2);
        break label118;
      }
    }
    
    public final void a(long paramLong, f paramf)
    {
      Log.d("xmpp/writer/before/write/send-location");
      b localb = as.b(as.this);
      ak localak = b.a(paramf, 0, null, null, null);
      if (paramLong != 0L)
      {
        paramf = new z[1];
        paramf[0] = new z("elapsed", Long.toString(paramLong));
      }
      for (;;)
      {
        paramf = new ak("ib", null, new ak("location", paramf, localak));
        localb.b.a(paramf);
        Log.i("xmpp/writer/write/send-location");
        return;
        paramf = new z[0];
      }
    }
    
    public final void a(final Bundle paramBundle)
    {
      String str = paramBundle.getString("jid");
      long l = paramBundle.getLong("timestamp");
      final Messenger localMessenger = (Messenger)paramBundle.getParcelable("callbackMessenger");
      Log.d("xmpp/writer/before/write/get-status; jid=" + str + "; timestamp=" + l);
      b localb = as.b(as.this);
      paramBundle = new w()
      {
        public final void a()
        {
          try
          {
            localMessenger.send(Message.obtain(null, 2, paramBundle));
            return;
          }
          catch (RemoteException localRemoteException)
          {
            Log.d("unable to send to callback message", localRemoteException);
          }
        }
        
        public final void a(int paramAnonymousInt)
        {
          try
          {
            localMessenger.send(Message.obtain(null, 0, paramAnonymousInt, 0, paramBundle));
            return;
          }
          catch (RemoteException localRemoteException)
          {
            Log.d("unable to send to callback message", localRemoteException);
          }
        }
        
        public final void a(long paramAnonymousLong, String paramAnonymousString)
        {
          try
          {
            paramBundle.putString("status", paramAnonymousString);
            paramBundle.putLong("timestamp", paramAnonymousLong);
            localMessenger.send(Message.obtain(null, 1, paramBundle));
            return;
          }
          catch (RemoteException paramAnonymousString)
          {
            Log.d("unable to send to callback message", paramAnonymousString);
          }
        }
        
        public final void b()
        {
          try
          {
            localMessenger.send(Message.obtain(null, 3, paramBundle));
            return;
          }
          catch (RemoteException localRemoteException)
          {
            Log.d("unable to send to callback message", localRemoteException);
          }
        }
      };
      localb.a(Collections.singletonMap(str, Long.valueOf(l)), new b.9(localb, paramBundle));
      Log.i("xmpp/writer/write/get-status; jid=" + str + "; timestamp=" + l);
    }
    
    public final void a(ace paramace)
    {
      Log.d("xmpp/writer/before/write/get-profile-photo");
      b localb = as.b(as.this);
      String str2 = paramace.a;
      String str1;
      if (paramace.d > 0)
      {
        str1 = Integer.toString(paramace.d);
        if ((paramace.c == 1) || (paramace.c != 2)) {
          break label76;
        }
      }
      label76:
      for (paramace = "preview";; paramace = "image")
      {
        if (str2 != null) {
          break label82;
        }
        throw new NullPointerException("jid must not be null");
        str1 = null;
        break;
      }
      label82:
      if ((str2.length() == 0) || ("@s.whatsapp.net".equals(str2))) {
        throw new IllegalArgumentException("jid must not be empty");
      }
      int i = localb.j + 1;
      localb.j = i;
      String str3 = Integer.toHexString(i);
      localb.d.put(str3, new b.25(localb, str1, paramace, str2));
      boolean bool = "image".equals(paramace);
      ArrayList localArrayList = new ArrayList();
      if (bool) {
        localArrayList.add(new z("query", "url"));
      }
      if (str1 == null) {
        localArrayList.add(new z("type", paramace));
      }
      for (;;)
      {
        paramace = new ak("picture", (z[])localArrayList.toArray(new z[localArrayList.size()]));
        paramace = new ak("iq", new z[] { new z("id", str3), new z("xmlns", "w:profile:picture"), new z("to", str2), new z("type", "get") }, paramace);
        localb.b.a(paramace);
        Log.i("xmpp/writer/write/get-profile-photo");
        return;
        localArrayList.add(new z("id", str1));
        localArrayList.add(new z("type", paramace));
      }
    }
    
    public final void a(ach paramach)
    {
      if (!paramach.e)
      {
        Log.d("xmpp/writer/before/write/set-profile-photo");
        b localb = as.b(as.this);
        String str2 = paramach.a;
        Object localObject = paramach.b;
        com.whatsapp.protocol.aw localaw = paramach.d;
        String str1;
        boolean bool;
        if (localaw != null)
        {
          str1 = localaw.a;
          if (localObject != null) {
            break label272;
          }
          bool = true;
          label59:
          localb.d.put(str1, new b.26(localb, paramach, bool, paramach));
          paramach = new ak("picture", new z[] { new z("type", "image") }, (byte[])localObject);
          if (localaw != null) {
            break label277;
          }
        }
        label272:
        label277:
        for (int i = 4;; i = 5)
        {
          localObject = new z[i];
          localObject[0] = new z("id", str1);
          localObject[1] = new z("xmlns", "w:profile:picture");
          localObject[2] = new z("to", str2);
          localObject[3] = new z("type", "set");
          if (localaw != null) {
            localObject[4] = new z("web", localaw.b);
          }
          localb.b.a(new ak("iq", (z[])localObject, new ak[] { paramach }));
          Log.i("xmpp/writer/write/set-profile-photo");
          return;
          i = localb.j + 1;
          localb.j = i;
          str1 = Integer.toHexString(i);
          break;
          bool = false;
          break label59;
        }
      }
      Log.e("xmpp/writer/write/set-profile-photo/timeout");
    }
    
    public final void a(ado paramado)
    {
      Log.d("xmpp/writer/before/write/messages-read; message.key=" + paramado.a);
      as.b(as.this).a(paramado.a, "read", paramado.b, paramado.c, null, Integer.valueOf(paramado.d));
      Log.i("xmpp/writer/write/messages-read; message.key=" + paramado.a + " participant=" + paramado.b + " extraIds=" + Arrays.deepToString(paramado.c));
    }
    
    public final void a(com.whatsapp.as paramas)
    {
      if (!paramas.f)
      {
        Log.d("xmpp/writer/before/write/block-list");
        b localb = as.b(as.this);
        Object localObject = paramas.h;
        com.whatsapp.protocol.aw localaw = paramas.i;
        if (localaw != null) {}
        for (String str1 = localaw.a;; str1 = Integer.toHexString(i))
        {
          localb.d.put(str1, new b.19(localb, paramas, paramas));
          paramas = new ak[((Map)localObject).size()];
          localObject = ((Map)localObject).values().iterator();
          i = 0;
          while (((Iterator)localObject).hasNext())
          {
            String str2 = (String)((Iterator)localObject).next();
            paramas[i] = new ak("item", new z[] { new z("type", "jid"), new z("value", str2), new z("action", "deny"), new z("order", Integer.toString(i)) });
            i += 1;
          }
          i = localb.j + 1;
          localb.j = i;
        }
        localObject = new z("name", "default");
        if (paramas.length == 0)
        {
          paramas = null;
          paramas = new ak("query", null, new ak("list", new z[] { localObject }, paramas));
          if (localaw != null) {
            break label394;
          }
        }
        label394:
        for (int i = 3;; i = 4)
        {
          localObject = new z[i];
          localObject[0] = new z("id", str1);
          localObject[1] = new z("xmlns", "jabber:iq:privacy");
          localObject[2] = new z("type", "set");
          if (localaw != null) {
            localObject[3] = new z("web", localaw.b);
          }
          paramas = new ak("iq", (z[])localObject, paramas);
          localb.b.a(paramas);
          Log.i("xmpp/writer/write/block-list");
          return;
          break;
        }
      }
      Log.e("xmpp/writer/write/block-list/timeout");
    }
    
    public final void a(auj.h paramh)
    {
      Log.d("xmpp/writer/before/write/web-battery-update");
      b localb = as.b(as.this);
      Integer localInteger = Integer.valueOf(paramh.a);
      Boolean localBoolean = Boolean.valueOf(paramh.b);
      paramh = Boolean.valueOf(paramh.c);
      if ((localInteger != null) || (localBoolean != null) || (paramh != null))
      {
        int i = localb.j + 1;
        localb.j = i;
        String str = Integer.toHexString(i);
        ArrayList localArrayList = new ArrayList();
        if (localInteger != null) {
          localArrayList.add(new z("value", localInteger.toString()));
        }
        if (localBoolean != null) {
          localArrayList.add(new z("live", localBoolean.toString()));
        }
        if (paramh != null) {
          localArrayList.add(new z("powersave", paramh.toString()));
        }
        localb.a(str, "c", new ak("action", null, new ak("battery", (z[])localArrayList.toArray(new z[localArrayList.size()]))));
      }
      Log.i("xmpp/writer/write/web-battery-update");
    }
    
    public final void a(bn parambn)
    {
      Log.d("xmpp/writer/before/write/subscribe-locations; groupId=" + parambn.b + "; needParticipants=" + parambn.c);
      b localb = as.b(as.this);
      String str1 = parambn.b;
      boolean bool = parambn.c;
      parambn.getClass();
      Object localObject = new at(parambn);
      parambn.getClass();
      au localau = new au(parambn);
      int i = localb.j + 1;
      localb.j = i;
      String str2 = Integer.toHexString(i);
      localb.d.put(str2, new b.40(localb, (x)localObject, str1, localau));
      if (bool)
      {
        localObject = new z[1];
        localObject[0] = new z("participants", "true");
      }
      for (;;)
      {
        localObject = new ak("subscribe", (z[])localObject);
        localObject = new ak("iq", new z[] { new z("id", str2), new z("xmlns", "location"), new z("type", "get"), new z("to", str1) }, (ak)localObject);
        localb.b.a((ak)localObject);
        Log.i("xmpp/writer/write/subscribe-locations; groupId=" + parambn.b + "; needParticipants=" + parambn.c);
        return;
        localObject = null;
      }
    }
    
    public final void a(bo parambo)
    {
      Log.d("xmpp/writer/before/write/unsubscribe-locations; groupId=" + parambo.a);
      b localb = as.b(as.this);
      Object localObject = parambo.a;
      int i = localb.j + 1;
      localb.j = i;
      String str = Integer.toHexString(i);
      localb.d.put(str, new b.41(localb, parambo, parambo));
      ak localak = new ak("unsubscribe", null);
      localObject = new ak("iq", new z[] { new z("id", str), new z("xmlns", "location"), new z("type", "get"), new z("to", (String)localObject) }, localak);
      localb.b.a((ak)localObject);
      Log.i("xmpp/writer/write/unsubscribe-locations; groupId=" + parambo.a);
    }
    
    public final void a(aw paramaw)
    {
      Log.d("xmpp/writer/before/write/change-number; oldChatUserId=" + paramaw.a);
      b localb = as.b(as.this);
      Object localObject2 = paramaw.a;
      int i = localb.j + 1;
      localb.j = i;
      Object localObject1 = Integer.toHexString(i);
      localb.d.put(localObject1, new b.3(localb));
      localObject2 = new ak("modify", null, new ak("username", null, (String)localObject2));
      localObject1 = new ak("iq", new z[] { new z("id", (String)localObject1), new z("xmlns", "urn:xmpp:whatsapp:account"), new z("type", "get"), new z("to", "c.us") }, (ak)localObject2);
      localb.b.a((ak)localObject1);
      Log.i("xmpp/writer/write/change-number; oldChatUserId=" + paramaw.a);
    }
    
    public final void a(az paramaz)
    {
      Log.d("xmpp/writer/before/write/get-normalized-jid; countryCode=" + paramaz.a + "; phoneNumber=" + paramaz.b);
      b localb = as.b(as.this);
      Object localObject2 = paramaz.a;
      String str = paramaz.b;
      int i = localb.j + 1;
      localb.j = i;
      Object localObject1 = Integer.toHexString(i);
      localb.d.put(localObject1, new b.2(localb));
      localObject2 = new ak("normalize", null, new ak[] { new ak("cc", null, (String)localObject2), new ak("in", null, str) });
      localObject1 = new ak("iq", new z[] { new z("to", "s.whatsapp.net"), new z("xmlns", "urn:xmpp:whatsapp:account"), new z("type", "get"), new z("id", (String)localObject1) }, (ak)localObject2);
      localb.b.a((ak)localObject1);
      Log.i("xmpp/writer/write/get-normalized-jid; countryCode=" + paramaz.a + "; phoneNumber=" + paramaz.b);
    }
    
    public final void a(bb parambb)
    {
      al localal = new al();
      localal.a = parambb.b;
      localal.e = parambb.c;
      localal.c = parambb.a;
      localal.d = parambb.d;
      localal.b = "notification";
      Log.d("xmpp/writer/before/write/notification-received; stanzaKey=" + localal);
      as.b(as.this).a(localal);
      Log.i("xmpp/writer/write/notification-received; stanzaKey=" + localal);
    }
    
    public final void a(br parambr)
    {
      Log.d("xmpp/writer/before/write/create-cipher-key");
      b localb = as.b(as.this);
      Object localObject1 = parambr.a;
      Object localObject2 = parambr.b;
      Runnable localRunnable = parambr.c;
      int i = localb.j + 1;
      localb.j = i;
      parambr = Integer.toHexString(i);
      localObject2 = new b.5(localb, (byte[])localObject1, (byte[])localObject2, localRunnable);
      localb.d.put(parambr, localObject2);
      localObject2 = new z("action", "create");
      localObject1 = new ak("google", null, (byte[])localObject1);
      localObject1 = new ak("crypto", new z[] { localObject2 }, new ak[] { localObject1 });
      parambr = new ak("iq", new z[] { new z("to", "s.whatsapp.net"), new z("xmlns", "urn:xmpp:whatsapp:account"), new z("type", "get"), new z("id", parambr) }, (ak)localObject1);
      localb.b.a(parambr);
      Log.i("xmpp/writer/write/create-cipher-key");
    }
    
    public final void a(bs parambs)
    {
      Log.d("xmpp/writer/before/write/field-stats; sendFieldStats=" + parambs);
      b localb = as.b(as.this);
      Object localObject1 = parambs.a;
      Object localObject2 = parambs.b;
      Runnable localRunnable = parambs.c;
      x localx = parambs.d;
      i locali = parambs.e;
      String str = Long.toString(System.currentTimeMillis() / 1000L);
      localb.d.put(localObject1, new b.7(localb, localRunnable, localx, locali));
      localObject2 = new ak("add", new z[] { new z("t", str) }, (byte[])localObject2);
      localObject1 = new ak("iq", new z[] { new z("id", (String)localObject1), new z("xmlns", "w:stats"), new z("type", "set"), new z("to", "s.whatsapp.net") }, (ak)localObject2);
      localb.b.a((ak)localObject1, 3);
      Log.i("xmpp/writer/write/field-stats; sendFieldStats=" + parambs);
    }
    
    public final void a(bt parambt)
    {
      Log.d("xmpp/writer/before/write/get-cipher-key");
      b localb = as.b(as.this);
      Object localObject3 = parambt.a;
      Object localObject1 = parambt.b;
      Object localObject2 = parambt.c;
      Object localObject4 = parambt.d;
      int i = localb.j + 1;
      localb.j = i;
      parambt = Integer.toHexString(i);
      localObject4 = new b.6(localb, (String)localObject3, (byte[])localObject1, (byte[])localObject2, (Runnable)localObject4);
      localb.d.put(parambt, localObject4);
      localObject4 = new z("action", "get");
      localObject3 = new z("version", (String)localObject3);
      localObject2 = new ak("google", null, (byte[])localObject2);
      localObject1 = new ak("code", null, (byte[])localObject1);
      localObject1 = new ak("crypto", new z[] { localObject4, localObject3 }, new ak[] { localObject2, localObject1 });
      parambt = new ak("iq", new z[] { new z("to", "s.whatsapp.net"), new z("xmlns", "urn:xmpp:whatsapp:account"), new z("type", "get"), new z("id", parambt) }, (ak)localObject1);
      localb.b.a(parambt);
      Log.i("xmpp/writer/write/get-cipher-key");
    }
    
    public final void a(bu parambu)
    {
      Log.d("xmpp/writer/before/write/get-group-info-by-code-iq; code=" + parambu.b);
      b localb = as.b(as.this);
      Object localObject1 = parambu.a;
      Object localObject2 = parambu.b;
      t localt = parambu.c;
      localb.d.put(localObject1, new b.13(localb, localt));
      localObject2 = new ak("invite", new z[] { new z("code", (String)localObject2) });
      localObject1 = new ak("iq", new z[] { new z("id", (String)localObject1), new z("xmlns", "w:g2"), new z("type", "get"), new z("to", "g.us") }, (ak)localObject2);
      localb.b.a((ak)localObject1);
      Log.i("xmpp/writer/write/get-group-info-by-code-iq; code=" + parambu.b);
    }
    
    public final void a(bv parambv)
    {
      Log.d("xmpp/writer/before/write/get-group-photo-by-code-iq; code=" + parambv.b);
      b localb = as.b(as.this);
      Object localObject1 = parambv.a;
      Object localObject2 = parambv.c;
      String str = parambv.b;
      u localu = parambv.d;
      localb.d.put(localObject1, new b.14(localb, localu, (String)localObject2));
      localObject2 = new ak("picture", new z[] { new z("to", "g.us"), new z("invite", str) });
      localObject1 = new ak("iq", new z[] { new z("id", (String)localObject1), new z("xmlns", "w:profile:picture"), new z("to", "g.us"), new z("type", "get") }, (ak)localObject2);
      localb.b.a((ak)localObject1);
      Log.i("xmpp/writer/write/get-group-photo-by-code-iq; code=" + parambv.b);
    }
    
    public final void a(bw parambw)
    {
      Log.d("xmpp/writer/before/write/send-get-status-privacy");
      b localb = as.b(as.this);
      Object localObject1 = parambw.a;
      Object localObject2 = parambw.b;
      parambw = (bw)localObject1;
      if (localObject1 == null)
      {
        int i = localb.j + 1;
        localb.j = i;
        parambw = Integer.toHexString(i);
      }
      localb.d.put(parambw, new b.61(localb, (v)localObject2));
      parambw = new z("id", parambw);
      localObject1 = new z("xmlns", "status");
      localObject2 = new z("type", "get");
      z localz = new z("to", "s.whatsapp.net");
      ak localak = new ak("privacy", null);
      parambw = new ak("iq", new z[] { parambw, localObject1, localObject2, localz }, localak);
      localb.b.a(parambw);
      Log.i("xmpp/writer/write/send-get-status-privacy");
    }
    
    public final void a(bx parambx)
    {
      Log.d("xmpp/writer/before/write/create-invite-link-iq; jid=" + parambx.b);
      b localb = as.b(as.this);
      Object localObject1 = parambx.a;
      String str = parambx.b;
      Object localObject2 = parambx.c;
      x localx = parambx.d;
      localb.d.put(localObject1, new b.10(localb, (am)localObject2, localx));
      localObject2 = new ak("invite", null);
      localObject1 = new ak("iq", new z[] { new z("id", (String)localObject1), new z("xmlns", "w:g2"), new z("type", "set"), new z("to", str) }, (ak)localObject2);
      localb.b.a((ak)localObject1);
      Log.i("xmpp/writer/write/create-invite-link-iq; jid=" + parambx.b);
    }
    
    public final void a(by paramby)
    {
      Log.d("xmpp/writer/before/write/join-group-iq; code=" + paramby.b);
      b localb = as.b(as.this);
      Object localObject1 = paramby.a;
      Object localObject2 = paramby.b;
      am localam = paramby.c;
      x localx = paramby.d;
      localb.d.put(localObject1, new b.15(localb, localam, localx));
      localObject2 = new ak("invite", new z[] { new z("code", (String)localObject2) });
      localObject1 = new ak("iq", new z[] { new z("id", (String)localObject1), new z("xmlns", "w:g2"), new z("type", "set"), new z("to", "g.us") }, (ak)localObject2);
      localb.b.a((ak)localObject1);
      Log.i("xmpp/writer/write/join-group-iq; code=" + paramby.b);
    }
    
    public final void a(bz parambz)
    {
      Log.d("xmpp/writer/before/write/send-location-key-distribution-notification");
      b localb = as.b(as.this);
      Object localObject1 = parambz.a;
      Object localObject3 = parambz.b;
      int j = parambz.c;
      parambz = new z("id", (String)localObject1);
      localObject1 = new z("to", "location@broadcast");
      z localz1 = new z("type", "location");
      Object localObject2 = new ak[((Map)localObject3).size()];
      localObject3 = ((Map)localObject3).entrySet().iterator();
      int i = 0;
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (Map.Entry)((Iterator)localObject3).next();
        z localz2 = new z("jid", (String)((Map.Entry)localObject4).getKey());
        localObject4 = b.a((f)((Map.Entry)localObject4).getValue(), j, null, null, null);
        localObject2[i] = new ak("to", new z[] { localz2 }, (ak)localObject4);
        i += 1;
      }
      localObject2 = new ak("participants", null, (ak[])localObject2);
      localb.b.a(new ak("notification", new z[] { parambz, localObject1, localz1 }, (ak)localObject2));
      Log.i("xmpp/writer/write/send-location-key-distribution-notification");
    }
    
    public final void a(cc paramcc)
    {
      String str = paramcc.a;
      paramcc = paramcc.b;
      Log.d("xmpp/writer/before/write/set-privacy-settings; category=" + str + "; setting=" + paramcc);
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      Object localObject = Integer.toHexString(i);
      localb.d.put(localObject, new b.18(localb));
      ak localak = new ak("privacy", null, new ak[] { new ak("category", new z[] { new z("name", str), new z("value", paramcc) }) });
      localObject = new ak("iq", new z[] { new z("to", "s.whatsapp.net"), new z("type", "set"), new z("id", (String)localObject), new z("xmlns", "privacy") }, localak);
      localb.b.a((ak)localObject);
      Log.i("xmpp/writer/write/set-privacy-settings; category=" + str + "; setting=" + paramcc);
    }
    
    public final void a(cd paramcd)
    {
      Log.d("xmpp/writer/before/write/message-retry; message.key=" + paramcd.a + "; retryCount=" + paramcd.d);
      b localb = as.b(as.this);
      j.b localb1 = paramcd.a;
      String str = paramcd.b;
      long l = paramcd.c;
      int i = paramcd.d;
      Object localObject2 = paramcd.e;
      int j = paramcd.f;
      boolean bool = b.a(str);
      if (bool) {}
      for (Object localObject1 = str;; localObject1 = localb1.a)
      {
        if (bool) {
          str = localb1.a;
        }
        Object localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(new z("v", "1"));
        ((ArrayList)localObject3).add(new z("count", String.valueOf(i)));
        ((ArrayList)localObject3).add(new z("id", localb1.c));
        ((ArrayList)localObject3).add(new z("t", String.valueOf(l / 1000L)));
        localObject3 = new ak("retry", (z[])((ArrayList)localObject3).toArray(new z[((ArrayList)localObject3).size()]));
        localObject2 = new ak("registration", null, (byte[])localObject2);
        localObject1 = b.a(localb1, "retry", null, (String)localObject1, str, Integer.valueOf(j));
        localb.b.a(new ak("receipt", (z[])localObject1, new ak[] { localObject3, localObject2 }));
        Log.i("xmpp/writer/write/message-retry; message.key=" + paramcd.a + "; retryCount=" + paramcd.d);
        return;
      }
    }
    
    public final void a(ce paramce)
    {
      Log.d("xmpp/writer/before/write/spam-report");
      b localb = as.b(as.this);
      Object localObject2 = paramce.a;
      Object localObject1 = paramce.b;
      String str1 = paramce.c;
      String str2 = paramce.d;
      String str3 = paramce.e;
      String str4 = paramce.f;
      com.whatsapp.protocol.aw localaw = paramce.g;
      ArrayList localArrayList1 = new ArrayList();
      label183:
      label219:
      int i;
      if (localObject2 != null)
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          j localj = (j)((Iterator)localObject2).next();
          if ((localj != null) && (localj.s != 7) && (localj.s != 8) && (localj.s != 10))
          {
            ArrayList localArrayList2 = new ArrayList();
            localArrayList2.add(new z("t", Long.toString(localj.n)));
            ArrayList localArrayList3;
            if (localj.e.b)
            {
              paramce = "to";
              localArrayList2.add(new z(paramce, localj.e.a));
              if (localj.s != 0) {
                break label462;
              }
              paramce = "text";
              localArrayList2.add(new z("type", paramce));
              localArrayList2.add(new z("id", localj.e.c));
              if (localj.f != null) {
                localArrayList2.add(new z("participant", localj.f));
              }
              localArrayList3 = new ArrayList();
              if (localj.s != 12) {
                break label493;
              }
              i = localj.w;
              if (i == 0) {
                break label469;
              }
              localArrayList3.add(new z("v", Integer.toString(i)));
              label344:
              paramce = localj.h();
              label350:
              paramce = new ak("raw", (z[])localArrayList3.toArray(new z[localArrayList3.size()]), paramce);
              if ((localj.i() & 0x1) == 0) {
                break label592;
              }
            }
            label462:
            label469:
            label493:
            label592:
            for (paramce = new ak("message", (z[])localArrayList2.toArray(new z[localArrayList2.size()]), new ak[] { new ak("multicast", null), paramce });; paramce = new ak("message", (z[])localArrayList2.toArray(new z[localArrayList2.size()]), paramce))
            {
              localArrayList1.add(paramce);
              break;
              paramce = "from";
              break label183;
              paramce = "media";
              break label219;
              localArrayList3.add(new z("v", "2"));
              break label344;
              if (localj.s == 11)
              {
                paramce = null;
                break label350;
              }
              localArrayList3.add(new z("v", "2"));
              paramce = E2E.Message.newBuilder();
              d.a(localb.e, localj, paramce, false, false, true);
              paramce = paramce.build().toByteArray();
              String str5 = j.a(localj.s);
              if (str5 != null) {
                localArrayList2.add(new z("mediatype", str5));
              }
              break label350;
            }
          }
        }
      }
      localObject2 = new ArrayList();
      if (localObject1 != null) {
        ((ArrayList)localObject2).add(new z("jid", (String)localObject1));
      }
      if (str1 != null) {
        ((ArrayList)localObject2).add(new z("creator", str1));
      }
      if (str2 != null) {
        ((ArrayList)localObject2).add(new z("source", str2));
      }
      if (str3 != null) {
        ((ArrayList)localObject2).add(new z("subject", str3));
      }
      if (str4 != null) {
        ((ArrayList)localObject2).add(new z("spam_flow", str4));
      }
      if (localaw == null)
      {
        i = 4;
        localObject1 = new z[i];
        localObject1[0] = new z("to", "s.whatsapp.net");
        localObject1[1] = new z("xmlns", "spam");
        localObject1[2] = new z("type", "set");
        if (localaw == null) {
          break label934;
        }
      }
      for (paramce = localaw.a;; paramce = Integer.toHexString(i))
      {
        localObject1[3] = new z("id", paramce);
        if (localaw != null) {
          localObject1[4] = new z("web", localaw.b);
        }
        paramce = new ak("iq", (z[])localObject1, new ak("spam_list", (z[])((ArrayList)localObject2).toArray(new z[((ArrayList)localObject2).size()]), (ak[])localArrayList1.toArray(new ak[localArrayList1.size()])));
        localb.b.a(paramce);
        Log.i("xmpp/writer/write/spam-report");
        return;
        i = 5;
        break;
        label934:
        i = localb.j + 1;
        localb.j = i;
      }
    }
    
    public final void a(cf paramcf)
    {
      Log.d("xmpp/writer/before/write/status-update");
      b localb = as.b(as.this);
      Object localObject1 = paramcf.a;
      Object localObject2 = paramcf.b;
      x localx = paramcf.c;
      i locali = paramcf.d;
      com.whatsapp.protocol.aw localaw = paramcf.e;
      if (localaw != null)
      {
        paramcf = localaw.a;
        localb.d.put(paramcf, new b.8(localb, (am)localObject2, (String)localObject1, localx, locali));
        localObject1 = new ak("status", null, (String)localObject1);
        if (localaw != null) {
          break label245;
        }
      }
      label245:
      for (int i = 4;; i = 5)
      {
        localObject2 = new z[i];
        localObject2[0] = new z("id", paramcf);
        localObject2[1] = new z("xmlns", "status");
        localObject2[2] = new z("type", "set");
        localObject2[3] = new z("to", "s.whatsapp.net");
        if (localaw != null) {
          localObject2[4] = new z("web", localaw.b);
        }
        paramcf = new ak("iq", (z[])localObject2, (ak)localObject1);
        localb.b.a(paramcf);
        Log.i("xmpp/writer/write/status-update");
        return;
        i = localb.j + 1;
        localb.j = i;
        paramcf = Integer.toHexString(i);
        break;
      }
    }
    
    public final void a(cg paramcg)
    {
      Log.d("xmpp/writer/before/write/accept-tos");
      b localb = as.b(as.this);
      Object localObject2 = paramcg.a;
      boolean bool = paramcg.b;
      Runnable localRunnable = paramcg.c;
      x localx = paramcg.d;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        int i = localb.j + 1;
        localb.j = i;
        localObject1 = Integer.toHexString(i);
      }
      localb.d.put(localObject1, new b.22(localb, localRunnable, localx));
      if (bool) {}
      for (localObject2 = "true";; localObject2 = "false")
      {
        localObject2 = new ak("accept", new z[] { new z("optout", (String)localObject2) });
        localObject1 = new ak("iq", new z[] { new z("to", "s.whatsapp.net"), new z("type", "set"), new z("id", (String)localObject1), new z("xmlns", "urn:xmpp:whatsapp:account") }, (ak)localObject2);
        localb.b.a((ak)localObject1);
        Log.i("xmpp/writer/write/accept-tos " + paramcg.b);
        return;
      }
    }
    
    public final void a(ch paramch)
    {
      Log.d("xmpp/writer/before/write/tos-stage");
      b localb = as.b(as.this);
      Object localObject2 = paramch.a;
      int i = paramch.b;
      Runnable localRunnable = paramch.c;
      x localx = paramch.d;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        int j = localb.j + 1;
        localb.j = j;
        localObject1 = Integer.toHexString(j);
      }
      localb.d.put(localObject1, new b.21(localb, localRunnable, localx));
      localObject2 = new ak("tos", new z[] { new z("stage", Integer.toString(i)) });
      localObject1 = new ak("iq", new z[] { new z("to", "s.whatsapp.net"), new z("type", "set"), new z("id", (String)localObject1), new z("xmlns", "urn:xmpp:whatsapp:account") }, (ak)localObject2);
      localb.b.a((ak)localObject1);
      Log.i("xmpp/writer/write/tos-stage " + paramch.b);
    }
    
    public final void a(ci paramci)
    {
      Log.d("xmpp/writer/before/write/web-response; id=" + paramci.a + "; webQueryType=" + paramci.h);
      as.b(as.this).a(paramci.a, paramci.e, paramci.h, paramci.c, paramci.l, paramci.k, paramci.k);
      Log.i("xmpp/writer/write/web-response; id=" + paramci.a + "; webQueryType=" + paramci.h);
    }
    
    public final void a(al paramal)
    {
      Log.d("xmpp/writer/before/write/send-stanza-received; stanzaKey=" + paramal);
      as.b(as.this).a(paramal);
      Log.i("xmpp/writer/write/send-stanza-received; stanzaKey=" + paramal);
    }
    
    public final void a(al paramal, org.b.a.a.a parama)
    {
      Log.d("xmpp/writer/before/write/send-set-auth-key; stanzaKey=" + paramal + "; newClientStaticPublic=" + org.whispersystems.a.i.a.b(parama.a.a));
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      Object localObject = Integer.toHexString(i);
      localb.d.put(localObject, new b.54(localb, paramal, parama));
      ak localak = new ak("key", null, parama.a.a);
      localObject = new ak("iq", new z[] { new z("id", (String)localObject), new z("type", "set"), new z("xmlns", "w:auth:key"), new z("to", "s.whatsapp.net") }, localak);
      localb.b.a((ak)localObject);
      Log.i("xmpp/writer/write/send-set-auth-key; stanzaKey=" + paramal + "; newClientStaticPublic=" + org.whispersystems.a.i.a.b(parama.a.a));
    }
    
    public final void a(al paramal, boolean paramBoolean)
    {
      Log.d("xmpp/writer/before/write/read-receipt-received; stanzaKey=" + paramal + "; disable=" + paramBoolean);
      b localb = as.b(as.this);
      if (paramBoolean) {}
      for (ak localak = new ak("features", new z[] { new z("readreceipts", "disable") }, null);; localak = null)
      {
        localb.a(paramal, localak);
        Log.i("xmpp/writer/write/read-receipt-received; stanzaKey=" + paramal + "; disable=" + paramBoolean);
        return;
      }
    }
    
    public final void a(j.b paramb, long paramLong, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, j.c paramc, f paramf, Map<String, f> paramMap, List<String> paramList, int paramInt2, int paramInt3, Integer paramInteger)
    {
      Log.d("xmpp/writer/before/write/message-encrypted; key=" + paramb + "; originalTimestamp=" + paramLong + "; retryCount=" + paramInt1 + "; participant=" + paramString1 + "; groupParticipantHash=" + paramString2 + "; broadcastListName=" + paramString5 + "; mediaType=" + paramString3 + "; mediaReason=" + paramString4 + "; webAttribute=" + paramc + "; encryptedMessage=" + paramf + "; participantEncryptedMessages=" + paramMap + "; additionalParticipants=" + paramList + "; origflags=" + paramInt2 + "; editVersion=" + paramInt3 + "; duration=" + paramInteger);
      as.c(as.this).a(paramb);
      as.b(as.this).a(paramb, paramLong, paramInt1, paramString1, paramString2, paramString3, paramString4, paramString5, paramc, paramf, paramMap, paramList, paramInt2, paramInt3, paramInteger);
      if (paramString3 != null) {
        paramInt2 = -1;
      }
      byte b;
      switch (paramString3.hashCode())
      {
      default: 
        switch (paramInt2)
        {
        default: 
          b = 0;
        }
        break;
      }
      for (;;)
      {
        if ((paramInt3 != 7) && (paramInt1 == 0)) {
          Statistics.a(paramb.a, b);
        }
        Log.i("xmpp/writer/write/message-encrypted; key=" + paramb + "; originalTimestamp=" + paramLong + "; participant=" + paramString1 + "; groupParticipantHash=" + paramString2 + "; mediaType=" + paramString3 + "; mediaReason=" + paramString4 + "; webAttribute=" + paramc + "; encryptedMessage=" + paramf + "; participantEncryptedMessages=" + paramMap);
        return;
        if (!paramString3.equals("image")) {
          break;
        }
        paramInt2 = 0;
        break;
        if (!paramString3.equals("video")) {
          break;
        }
        paramInt2 = 1;
        break;
        if (!paramString3.equals("gif")) {
          break;
        }
        paramInt2 = 2;
        break;
        if (!paramString3.equals("audio")) {
          break;
        }
        paramInt2 = 3;
        break;
        if (!paramString3.equals("contact")) {
          break;
        }
        paramInt2 = 4;
        break;
        if (!paramString3.equals("contact_array")) {
          break;
        }
        paramInt2 = 5;
        break;
        if (!paramString3.equals("location")) {
          break;
        }
        paramInt2 = 6;
        break;
        if (!paramString3.equals("livelocation")) {
          break;
        }
        paramInt2 = 7;
        break;
        if (!paramString3.equals("document")) {
          break;
        }
        paramInt2 = 8;
        break;
        b = 1;
        continue;
        b = 3;
        continue;
        b = 13;
        continue;
        b = 2;
        continue;
        b = 4;
        continue;
        b = 14;
        continue;
        b = 5;
        continue;
        b = 16;
        continue;
        b = 9;
      }
    }
    
    public final void a(j paramj)
    {
      Log.d("xmpp/writer/before/write/message-received; message.key=" + paramj.e);
      as.b(as.this).a(paramj.e, null, paramj.f, null, paramj.M, Integer.valueOf(paramj.ab));
      Log.i("xmpp/writer/write/message-received; message.key=" + paramj.e);
    }
    
    public final void a(j paramj, int[] paramArrayOfInt)
    {
      Log.d("xmpp/writer/before/write/message-received-with-unknown-tags; message.key=" + paramj.e);
      as.b(as.this).a(paramj.e, paramj.f, paramArrayOfInt);
      Log.i("xmpp/writer/write/message-received-with-unknown-tags; message.key=" + paramj.e);
    }
    
    public final void a(rj paramrj)
    {
      Log.d("xmpp/writer/before/write/create-group-chat; subject=" + paramrj.c);
      as.b(as.this).a(paramrj.c, paramrj.d, paramrj, paramrj, paramrj.g);
      Log.i("xmpp/writer/write/create-group-chat; subject=" + paramrj.c);
    }
    
    public final void a(xg.a parama)
    {
      String str1 = parama.a;
      String str2 = parama.b;
      String str3 = parama.c;
      String str4 = parama.d;
      long l = parama.e;
      Log.d("xmpp/writer/before/write/request-media-upload; jid=" + str1 + "; base64EncodedSha256OfMediaPlaintext=" + str2 + "; fileOrigHash=" + str3 + "; fileType=" + str4 + "; fileSize=" + l);
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      String str5 = Integer.toHexString(i);
      localb.d.put(str5, new b.44(localb, parama));
      if (str3 == null) {}
      for (parama = new ak("media", new z[] { new z("hash", str2), new z("type", str4), new z("size", Long.toString(l)) });; parama = new ak("media", new z[] { new z("hash", str2), new z("orighash", str3), new z("type", str4), new z("size", Long.toString(l)) }))
      {
        parama = new ak("iq", new z[] { new z("id", str5), new z("xmlns", "w:m"), new z("type", "set"), new z("to", "s.whatsapp.net") }, parama);
        localb.b.a(parama);
        Log.i("xmpp/writer/write/request-media-upload; jid=" + str1 + "; base64EncodedSha256OfMediaPlaintext=" + str2 + "; fileOrigHash=" + str3 + "; fileType=" + str4 + "; fileSize=" + l);
        return;
      }
    }
    
    public final void a(Runnable paramRunnable)
    {
      Log.d("xmpp/writer/before/write/client-ping");
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      String str = Integer.toHexString(i);
      localb.d.put(str, new b.71(localb, paramRunnable));
      paramRunnable = new ak("ping", null);
      paramRunnable = new ak("iq", new z[] { new z("id", str), new z("xmlns", "w:p"), new z("type", "get"), new z("to", "s.whatsapp.net") }, paramRunnable);
      localb.b.a(paramRunnable);
      Log.i("xmpp/writer/write/client-ping");
    }
    
    public final void a(String paramString)
    {
      Log.d("xmpp/writer/before/write/paused; toJid=" + paramString);
      b localb = as.b(as.this);
      ak localak = new ak("paused", null);
      localak = new ak("chatstate", new z[] { new z("to", paramString) }, localak);
      localb.b.a(localak);
      Log.i("xmpp/writer/write/paused; toJid=" + paramString);
    }
    
    public final void a(String paramString, int paramInt)
    {
      Object localObject2 = null;
      Log.d("xmpp/writer/before/write/composing; toJid=" + paramString + "; media=" + paramInt);
      b localb = as.b(as.this);
      if (paramInt == 1)
      {
        localObject1 = "audio";
        if (localObject1 != null) {
          break label176;
        }
      }
      for (Object localObject1 = localObject2;; localObject1 = localObject2)
      {
        localObject1 = new ak("composing", (z[])localObject1);
        localObject2 = new ArrayList();
        ((List)localObject2).add(new z("to", paramString));
        localObject1 = new ak("chatstate", (z[])((List)localObject2).toArray(new z[((List)localObject2).size()]), (ak)localObject1);
        localb.b.a((ak)localObject1);
        Log.i("xmpp/writer/write/composing; toJid=" + paramString + "; media=" + paramInt);
        return;
        localObject1 = null;
        break;
        label176:
        localObject2 = new z[1];
        localObject2[0] = new z("media", (String)localObject1);
      }
    }
    
    public final void a(String paramString, int paramInt, String[] paramArrayOfString, y paramy)
    {
      Log.d("xmpp/writer/before/write/send-set-status-privacy");
      b localb = as.b(as.this);
      String str = paramString;
      int i;
      if (paramString == null)
      {
        i = localb.j + 1;
        localb.j = i;
        str = Integer.toHexString(i);
      }
      localb.d.put(str, paramy);
      paramString = null;
      paramy = paramString;
      if (paramArrayOfString != null)
      {
        paramy = paramString;
        if (paramArrayOfString.length > 0)
        {
          paramy = new ak[paramArrayOfString.length];
          i = 0;
          while (i < paramArrayOfString.length)
          {
            paramy[i] = new ak("user", new z[] { new z("jid", paramArrayOfString[i]) });
            i += 1;
          }
        }
      }
      if (paramInt == 0) {
        paramString = "contacts";
      }
      for (;;)
      {
        paramString = new ak("privacy", null, new ak("list", new z[] { new z("type", paramString) }, paramy));
        paramString = new ak("iq", new z[] { new z("id", str), new z("xmlns", "status"), new z("type", "set"), new z("to", "s.whatsapp.net") }, paramString);
        localb.b.a(paramString);
        Log.i("xmpp/writer/write/send-set-status-privacy");
        return;
        if (paramInt == 1) {
          paramString = "whitelist";
        } else {
          paramString = "blacklist";
        }
      }
    }
    
    public final void a(String paramString, aj paramaj, y paramy)
    {
      Log.d("xmpp/writer/before/write/rotate-pre-key");
      Object localObject = as.b(as.this);
      ((b)localObject).d.put(paramString, paramy);
      paramy = ((b)localObject).b;
      localObject = new z("xmlns", "encrypt");
      z localz1 = new z("type", "set");
      z localz2 = new z("to", "s.whatsapp.net");
      paramString = new z("id", paramString);
      paramaj = new ak("rotate", null, new ak("skey", null, new ak[] { new ak("id", null, paramaj.a), new ak("value", null, paramaj.b), new ak("signature", null, paramaj.c) }));
      paramy.a(new ak("iq", new z[] { localObject, localz1, localz2, paramString }, paramaj));
      Log.i("xmpp/writer/write/rotate-pre-key");
    }
    
    public final void a(String paramString, com.whatsapp.protocol.aw paramaw)
    {
      Log.d("xmpp/writer/before/write/push-name; pushName=" + paramString);
      b localb = as.b(as.this);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new z("type", "available"));
      localArrayList.add(new z("name", paramString));
      if (paramaw != null)
      {
        localArrayList.add(new z("id", paramaw.a));
        localArrayList.add(new z("web", paramaw.b));
      }
      paramaw = new ak("presence", (z[])localArrayList.toArray(new z[localArrayList.size()]));
      localb.b.a(paramaw);
      Log.i("xmpp/writer/write/push-name; pushName=" + paramString);
    }
    
    public final void a(String paramString1, String paramString2)
    {
      Log.d("xmpp/writer/before/write/client-config; pushId=" + paramString1 + "; platform=" + paramString2);
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      Object localObject = Integer.toHexString(i);
      localb.d.put(localObject, new b.67(localb, paramString1, paramString2));
      ak localak = new ak("config", new z[] { new z("id", paramString1), new z("platform", paramString2) });
      localObject = new ak("iq", new z[] { new z("id", (String)localObject), new z("xmlns", "urn:xmpp:whatsapp:push"), new z("type", "set"), new z("to", "s.whatsapp.net") }, localak);
      localb.b.a((ak)localObject);
      Log.i("xmpp/writer/write/client-config; pushId=" + paramString1 + "; platform=" + paramString2);
    }
    
    public final void a(String paramString1, String paramString2, long paramLong)
    {
      Log.d("xmpp/write/before/write/disable-location-sharing; id=" + paramString1 + "; jid=" + paramString2 + "; sequenceNumber=" + paramLong);
      Object localObject2 = as.b(as.this);
      if (TextUtils.isEmpty(paramString2)) {
        throw new IllegalArgumentException("jid cannot be null or empty");
      }
      int i;
      if (paramString1 == null)
      {
        i = ((b)localObject2).j + 1;
        ((b)localObject2).j = i;
      }
      for (Object localObject1 = Integer.toHexString(i);; localObject1 = paramString1)
      {
        localObject2 = ((b)localObject2).b;
        localObject1 = new z("id", (String)localObject1);
        z localz1 = new z("type", "location");
        z localz2 = new z("to", paramString2);
        ak localak = new ak("disable", new z[] { new z("id", Long.toString(paramLong)) });
        ((ao)localObject2).a(new ak("notification", new z[] { localObject1, localz1, localz2 }, localak));
        Log.i("xmpp/write/write/disable-location-sharing; id=" + paramString1 + "; jid=" + paramString2 + "; sequenceNumber=" + paramLong);
        return;
      }
    }
    
    public final void a(String paramString1, String paramString2, long paramLong, boolean paramBoolean, String paramString3)
    {
      Log.d("xmpp/writer/before/write/web-missed-call-notif");
      b localb = as.b(as.this);
      Boolean localBoolean = new Boolean(paramBoolean);
      paramString1 = new ak("call_log", new z[] { new z("type", "miss"), new z("t", Long.toString(paramLong)), new z("id", paramString1), new z("jid", paramString2), new z("owner", localBoolean.toString()), new z("kind", paramString3) });
      int i = localb.j + 1;
      localb.j = i;
      localb.a(Integer.toHexString(i), "s", new ak("action", new z[] { new z("add", "relay") }, paramString1));
      Log.i("xmpp/writer/write/web-missed-call-notif");
    }
    
    public final void a(String paramString1, String paramString2, String paramString3)
    {
      Log.d("xmpp/writer/before/write/media-retry-notification; id=" + paramString1 + "; jid=" + paramString2 + "; participant=" + paramString3);
      b localb = as.b(as.this);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new z("id", paramString1));
      localArrayList.add(new z("to", paramString2));
      localArrayList.add(new z("type", "mediaretry"));
      if (paramString3 != null) {
        localArrayList.add(new z("participant", paramString3));
      }
      localb.b.a(new ak("notification", (z[])localArrayList.toArray(new z[localArrayList.size()])));
      Log.i("xmpp/writer/write/media-retry-notification; id=" + paramString1 + "; jid=" + paramString2 + "; participant=" + paramString3);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, byte paramByte1, byte paramByte2, String paramString4)
    {
      Log.d("xmpp/writer/before/write/call-video-changed; callId=" + paramString3);
      b localb = as.b(as.this);
      int i = 4;
      if (paramString4 == null) {
        i = 3;
      }
      z[] arrayOfz = new z[i];
      arrayOfz[0] = new z("call-id", paramString3);
      arrayOfz[1] = new z("state", String.valueOf(paramByte1));
      arrayOfz[2] = new z("orientation", String.valueOf(paramByte2));
      if (paramString4 != null) {
        arrayOfz[3] = new z("enc", paramString4);
      }
      paramString4 = new ak("video", arrayOfz);
      paramString1 = new ak("call", new z[] { new z("to", paramString2), new z("id", paramString1) }, paramString4);
      localb.b.a(paramString1);
      Log.i("xmpp/writer/write/call-video-changed; callId=" + paramString3);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, int paramInt)
    {
      Log.d("xmpp/writer/before/write/remove-account");
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      String str2 = Integer.toHexString(i);
      localb.d.put(str2, new b.4(localb));
      String str1;
      if (paramString3 != null)
      {
        str1 = paramString1;
        if (paramString1 == null) {
          str1 = "";
        }
        paramString1 = paramString2;
        if (paramString2 == null) {
          paramString1 = "";
        }
        if (paramInt >= 0) {
          paramString1 = new ak("body", new z[] { new z("lg", str1), new z("lc", paramString1), new z("reason", Integer.toString(paramInt)) }, paramString3);
        }
      }
      for (paramString1 = new ak[] { paramString1 };; paramString1 = null)
      {
        paramString1 = new ak("remove", null, paramString1);
        paramString1 = new ak("iq", new z[] { new z("to", "s.whatsapp.net"), new z("xmlns", "urn:xmpp:whatsapp:account"), new z("type", "get"), new z("id", str2) }, paramString1);
        localb.b.a(paramString1);
        Log.i("xmpp/writer/write/remove-account");
        return;
        paramString1 = new ak("body", new z[] { new z("lg", str1), new z("lc", paramString1) }, paramString3);
        break;
      }
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5, String paramString6)
    {
      Log.d("xmpp/writer/before/write/spam-call-report");
      b localb;
      z localz1;
      z localz2;
      z localz3;
      int i;
      z localz4;
      int j;
      label185:
      int k;
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (paramString4 != null) && (paramString5 != null) && (paramString6 != null))
      {
        localb = as.b(as.this);
        localz1 = new z("to", "s.whatsapp.net");
        localz2 = new z("xmlns", "spam");
        localz3 = new z("type", "set");
        i = localb.j + 1;
        localb.j = i;
        localz4 = new z("id", Integer.toHexString(i));
        if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
          break label416;
        }
        paramString1 = new z("from", paramString1);
        paramString2 = new z("to", paramString2);
        paramString3 = new z("id", paramString3);
        if (paramString4 == null) {
          break label398;
        }
        i = 1;
        if (paramString5 == null) {
          break label404;
        }
        j = 1;
        if (paramString6 == null) {
          break label410;
        }
        k = 1;
        label193:
        z[] arrayOfz = new z[k + (i + 1 + j)];
        arrayOfz[0] = new z("duration", Long.toString(paramLong));
        if (paramString4 != null) {
          arrayOfz[1] = new z("terminator", paramString4);
        }
        if (paramString5 != null) {
          arrayOfz[2] = new z("reason", paramString5);
        }
        if (paramString6 != null) {
          arrayOfz[3] = new z("mediatype", paramString6);
        }
        paramString4 = new ak("call_info", arrayOfz);
      }
      label398:
      label404:
      label410:
      label416:
      for (paramString1 = new ak("call", new z[] { paramString1, paramString2, paramString3 }, paramString4);; paramString1 = null)
      {
        paramString1 = new ak("spam_list", null, paramString1);
        paramString1 = new ak("iq", new z[] { localz1, localz2, localz3, localz4 }, paramString1);
        localb.b.a(paramString1);
        Log.d("xmpp/writer/write/spam-call-report");
        return;
        i = 0;
        break;
        j = 0;
        break label185;
        k = 0;
        break label193;
      }
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, long paramLong)
    {
      Log.d("xmpp/writer/before/write/call-terminate; callId=" + paramString3);
      b localb = as.b(as.this);
      int i;
      int j;
      label55:
      int k;
      if ((paramString4 != null) && (paramString4.length() > 0))
      {
        i = 1;
        if (paramLong <= 0L) {
          break label267;
        }
        j = 1;
        if (i == 0) {
          break label273;
        }
        k = 1;
        label63:
        if (j == 0) {
          break label279;
        }
      }
      label267:
      label273:
      label279:
      for (int m = 1;; m = 0)
      {
        z[] arrayOfz = new z[m + (k + 2)];
        arrayOfz[0] = new z("call-id", paramString3);
        k = 2;
        arrayOfz[1] = new z("videostate", String.valueOf(paramInt));
        paramInt = k;
        if (i != 0)
        {
          paramInt = 3;
          arrayOfz[2] = new z("reason", paramString4);
        }
        if (j != 0) {
          arrayOfz[paramInt] = new z("duration", String.valueOf(paramLong));
        }
        paramString4 = new ak("terminate", arrayOfz);
        paramString1 = new ak("call", new z[] { new z("to", paramString2), new z("id", paramString1) }, paramString4);
        localb.b.a(paramString1);
        Log.i("xmpp/writer/write/call-terminate; callId=" + paramString3);
        return;
        i = 0;
        break;
        j = 0;
        break label55;
        k = 0;
        break label63;
      }
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, String paramString5, byte paramByte1, int paramInt2, int paramInt3, byte paramByte2, int paramInt4, byte[] paramArrayOfByte)
    {
      Log.d("xmpp/writer/before/write/call-offer-pre-accept; callId=" + paramString3);
      b localb = as.b(as.this);
      if ((paramInt4 > 0) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {}
      for (int i = 1;; i = 0)
      {
        int j = i + 3;
        i = j;
        if (paramString5 == null) {
          i = j - 1;
        }
        ak[] arrayOfak = new ak[i];
        i = 1;
        arrayOfak[0] = new ak("audio", new z[] { new z("enc", paramString4), new z("rate", String.valueOf(paramInt1)) });
        paramInt1 = i;
        if (paramString5 != null)
        {
          paramInt1 = 2;
          arrayOfak[1] = new ak("video", new z[] { new z("enc", paramString5), new z("orientation", String.valueOf(paramByte1)), new z("screen_width", String.valueOf(paramInt2)), new z("screen_height", String.valueOf(paramInt3)) });
        }
        arrayOfak[paramInt1] = new ak("encopt", new z[] { new z("keygen", String.valueOf(paramByte2)) });
        if ((paramInt4 > 0) && (paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
          arrayOfak[(paramInt1 + 1)] = new ak("capability", new z[] { new z("ver", String.valueOf(paramInt4)) }, paramArrayOfByte);
        }
        paramString4 = new ak("preaccept", new z[] { new z("call-id", paramString3) }, arrayOfak);
        paramString1 = new ak("call", new z[] { new z("to", paramString2), new z("id", paramString1) }, paramString4);
        localb.b.a(paramString1);
        Log.i("xmpp/writer/write/call-offer-pre-accept; callId=" + paramString3);
        return;
      }
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, byte[][] paramArrayOfByte, int[] paramArrayOfInt, boolean[] paramArrayOfBoolean, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, String paramString5, byte paramByte1, byte paramByte2)
    {
      Log.d("xmpp/writer/before/write/call-offer-accept; callId=" + paramString3);
      as.b(as.this).a(paramString1, paramString2, paramString3, paramString4, paramInt1, paramArrayOfByte, paramArrayOfInt, paramArrayOfBoolean, paramInt2, paramArrayOfByte1, paramInt3, paramString5, paramByte1, paramByte2);
      Log.i("xmpp/writer/write/call-offer-accept; callId=" + paramString3);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      Log.d("xmpp/writer/before/write/sync-query-iq; mode=" + paramString2 + "; context=" + paramString3 + "; sid=" + paramString4 + ";");
      b localb = as.b(as.this);
      ArrayList localArrayList = new ArrayList();
      paramString5 = new ContactSyncManager.ParcelableSyncUserRequest(null, paramString5, 0L);
      paramString5.e = true;
      localArrayList.add(paramString5);
      paramString5 = b.a(paramString1, paramString2, paramString3, paramString4, localArrayList, null);
      localb.d.put(paramString1, new b.b(localb, paramString4, paramString5.b, paramString5.c, paramString5.d, true));
      localb.b.a(paramString5.a, 3);
      Log.i("xmpp/writer/write/sync-query-iq; mode=" + paramString2 + "; context=" + paramString3 + "; sid=" + paramString4 + ";");
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString6, String paramString7, boolean paramBoolean3, boolean paramBoolean4)
    {
      Log.d("xmpp/writer/before/write/web-sync; ref=" + paramString1 + "; browserId=" + paramString4 + "; loginToken=" + paramString5 + "; loginType=" + paramInt1 + "; batteryLevel=" + paramInt2 + "; plugged=" + paramBoolean1 + "; locale=" + paramString6 + "; language=" + paramString7 + "; is24h=" + paramBoolean3 + "; biz=" + paramBoolean4);
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      Object localObject1 = Integer.toHexString(i);
      localb.d.put(localObject1, new b.48(localb, paramString1, paramString2, paramString4, paramString5));
      paramString2 = new ArrayList();
      paramString2.add(new z("version", "0.14.8"));
      paramString2.add(new z("url", "true"));
      Object localObject2;
      z localz1;
      label318:
      z localz2;
      switch (paramInt1)
      {
      default: 
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(new ak("sync", (z[])paramString2.toArray(new z[paramString2.size()]), paramString1));
        localz1 = new z("value", Integer.toString(paramInt2));
        if (paramBoolean1)
        {
          paramString2 = "true";
          localz2 = new z("live", paramString2);
          if (!paramBoolean2) {
            break label830;
          }
        }
        break;
      }
      label830:
      for (paramString2 = "true";; paramString2 = "false")
      {
        ((ArrayList)localObject2).add(new ak("battery", new z[] { localz1, localz2, new z("powersave", paramString2) }));
        ((ArrayList)localObject2).add(new ak("code", null, paramString5));
        paramString2 = new ArrayList();
        if (paramString6 != null) {
          paramString2.add(new z("lc", paramString6));
        }
        if (paramString7 != null) {
          paramString2.add(new z("lg", paramString7));
        }
        if (paramBoolean3) {
          paramString2.add(new z("t", "24"));
        }
        ((ArrayList)localObject2).add(new ak("config", (z[])paramString2.toArray(new z[paramString2.size()])));
        if (paramString3 != null) {
          ((ArrayList)localObject2).add(new ak("password", null, paramString3));
        }
        if (paramBoolean4) {
          ((ArrayList)localObject2).add(new ak("biz", null));
        }
        paramString2 = new z("type", "set");
        paramString3 = new z("xmlns", "w:web");
        localObject1 = new z("id", (String)localObject1);
        localObject2 = (ak[])((ArrayList)localObject2).toArray(new ak[((ArrayList)localObject2).size()]);
        paramString2 = new ak("iq", new z[] { paramString2, paramString3, localObject1 }, (ak[])localObject2);
        localb.b.a(paramString2);
        Log.i("xmpp/writer/write/web-sync; ref=" + paramString1 + "; browserId=" + paramString4 + "; loginToken=" + paramString5 + "; loginType=" + paramInt1 + "; batteryLevel=" + paramInt2 + "; plugged=" + paramBoolean1 + "; locale=" + paramString6 + "; language=" + paramString7 + "; is24h=" + paramBoolean3 + "; biz=" + paramBoolean4);
        return;
        paramString2.add(new z("web", "response"));
        break;
        paramString2.add(new z("web", "resume"));
        break;
        paramString2 = "false";
        break label318;
      }
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, String paramString4, ArrayList<ContactSyncManager.ParcelableSyncUserRequest> paramArrayList, String[] paramArrayOfString)
    {
      Log.d("xmpp/writer/before/write/sync-iq; mode=" + paramString2 + "; context=" + paramString3 + "; sid=" + paramString4 + ";");
      b localb = as.b(as.this);
      paramArrayList = b.a(paramString1, paramString2, paramString3, paramString4, paramArrayList, paramArrayOfString);
      localb.d.put(paramString1, new b.b(localb, paramString4, paramArrayList.b, paramArrayList.c, paramArrayList.d, false));
      localb.b.a(paramArrayList.a, 3);
      Log.i("xmpp/writer/write/sync-iq; mode=" + paramString2 + "; context=" + paramString3 + "; sid=" + paramString4 + ";");
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, String paramString4, byte[] paramArrayOfByte, int paramInt)
    {
      Log.d("xmpp/writer/before/write/call-offer-reject; callId=" + paramString3);
      b localb = as.b(as.this);
      int i;
      z[] arrayOfz;
      if ((paramString4 != null) && (paramString4.length() > 0))
      {
        i = 3;
        arrayOfz = new z[i];
        arrayOfz[0] = new z("call-id", paramString3);
        arrayOfz[1] = new z("count", Integer.toString(paramInt));
        if (arrayOfz.length > 2) {
          arrayOfz[2] = new z("reason", paramString4);
        }
        if (paramArrayOfByte == null) {
          break label233;
        }
        paramString4 = new ak[1];
        paramString4[0] = new ak("registration", null, paramArrayOfByte);
      }
      for (;;)
      {
        paramString4 = new ak("reject", arrayOfz, paramString4);
        paramString1 = new ak("call", new z[] { new z("to", paramString2), new z("id", paramString1) }, paramString4);
        localb.b.a(paramString1);
        Log.i("xmpp/writer/write/call-offer-reject; callId=" + paramString3);
        return;
        i = 2;
        break;
        label233:
        paramString4 = null;
      }
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    {
      Log.d("xmpp/writer/before/write/call-interruption; callId=" + paramString3);
      as.b(as.this).b.a(b.a(paramString1, paramString2, paramString3, paramBoolean, "interruption"));
      Log.i("xmpp/writer/write/call-interruption; callId=" + paramString3);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, int paramInt)
    {
      Log.d("xmpp/writer/before/write/call-relay-election; callId=" + paramString3);
      b localb = as.b(as.this);
      paramArrayOfByte = new ak("te", new z[] { new z("latency", String.valueOf(paramInt)) }, paramArrayOfByte);
      paramArrayOfByte = new ak("relayelection", new z[] { new z("call-id", paramString3) }, paramArrayOfByte);
      paramString1 = new ak("call", new z[] { new z("to", paramString2), new z("id", paramString1) }, paramArrayOfByte);
      localb.b.a(paramString1);
      Log.i("xmpp/writer/write/call-relay-election; callId=" + paramString3);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString1, int[] paramArrayOfInt1, byte[][] paramArrayOfByte, int[] paramArrayOfInt2, boolean[] paramArrayOfBoolean, int paramInt1, byte[] paramArrayOfByte1, byte paramByte1, String[] paramArrayOfString2, byte paramByte2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte2)
    {
      Log.d("xmpp/writer/before/write/call-offer; callId=" + paramString3);
      as.b(as.this).a(paramString1, paramString2, paramString3, paramArrayOfString1, paramArrayOfInt1, paramArrayOfByte, paramArrayOfInt2, paramArrayOfBoolean, paramInt1, paramArrayOfByte1, paramByte1, paramArrayOfString2, paramByte2, paramInt2, paramInt3, paramInt4, paramInt5, paramArrayOfByte2);
      Log.i("xmpp/writer/write/call-offer; callId=" + paramString3);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, byte[][] paramArrayOfByte, int[] paramArrayOfInt)
    {
      Log.d("xmpp/writer/before/write/call-relay-latencies; callId=" + paramString3);
      as.b(as.this).a(paramString1, paramString2, paramString3, paramArrayOfByte, paramArrayOfInt);
      Log.i("xmpp/writer/write/call-relay-latencies; callId=" + paramString3);
    }
    
    public final void a(String paramString1, String paramString2, String paramString3, byte[][] paramArrayOfByte, int[] paramArrayOfInt, boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2, byte[] paramArrayOfByte1)
    {
      Log.d("xmpp/writer/before/write/call-transport; callId=" + paramString3);
      as.b(as.this).a(paramString1, paramString2, paramString3, paramArrayOfByte, paramArrayOfInt, paramArrayOfBoolean, paramInt1, paramInt2, paramArrayOfByte1);
      Log.i("xmpp/writer/write/call-transport; callId=" + paramString3);
    }
    
    public final void a(String paramString1, String paramString2, boolean paramBoolean)
    {
      al localal = new al();
      localal.a = paramString1;
      localal.c = paramString2;
      localal.d = "contacts";
      localal.b = "notification";
      Log.d("xmpp/writer/before/write/contact-ack; toJid=" + paramString1 + "; msgId=" + paramString2 + "; isValid=" + paramBoolean);
      b localb = as.b(as.this);
      if (paramBoolean) {}
      for (String str = "in";; str = "out")
      {
        localb.a(localal, new ak("sync", new z[] { new z("contacts", str) }, null));
        Log.i("xmpp/writer/write/contact-ack; toJid=" + paramString1 + "; msgId=" + paramString2 + "; isValid=" + paramBoolean);
        return;
      }
    }
    
    public final void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4)
    {
      Log.d("xmpp/writer/before/write/send-web-revoke-message-notif");
      b localb = as.b(as.this);
      g.a locala = g.h();
      Protocol.MessageKey.a locala1 = Protocol.MessageKey.newBuilder();
      locala1.setRemoteJid(paramString3);
      locala1.setFromMe(paramBoolean);
      locala1.setId(paramString1);
      locala.a(locala1.build());
      if (paramString4 != null) {
        locala.a(paramString4);
      }
      paramString3 = new j(new j.b(paramString3, paramBoolean, paramString1));
      paramString3.s = 15;
      paramString3.y = paramString2;
      paramString2 = E2E.Message.newBuilder();
      d.a(localb.e, paramString3, paramString2, false, true, false);
      locala.a(paramString2.build());
      paramString2 = new ak("message", null, locala.b().toByteArray());
      localb.a(paramString1, "v", new ak("action", new z[] { new z("add", "relay") }, paramString2));
      Log.i("xmpp/writer/write/send-web-revoke-message-notif");
    }
    
    public final void a(String paramString, boolean paramBoolean)
    {
      String str1 = MediaFileUtils.a(paramString);
      Log.d("xmpp/writer/before/write/media-received; url=" + str1 + "; dedupe=" + paramBoolean);
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      String str2 = Integer.toHexString(i);
      localb.d.put(str2, new b.12(localb));
      if (paramBoolean) {}
      for (paramString = new ak("ack", new z[] { new z("url", paramString), new z("source", "self") });; paramString = new ak("ack", new z[] { new z("url", paramString) }))
      {
        paramString = new ak("iq", new z[] { new z("id", str2), new z("xmlns", "w:m"), new z("type", "set"), new z("to", "s.whatsapp.net") }, paramString);
        localb.b.a(paramString);
        Log.i("xmpp/writer/write/media-received; url=" + str1 + "; dedupe=" + paramBoolean);
        return;
      }
    }
    
    public final void a(String paramString, byte[] paramArrayOfByte)
    {
      Log.d("xmpp/writer/before/write/set-biz-vname-cert");
      b localb = as.b(as.this);
      if (paramArrayOfByte.length == 0) {
        throw new IllegalArgumentException("signedCertificate cannot be null or empty");
      }
      String str = paramString;
      if (paramString == null)
      {
        int i = localb.j + 1;
        localb.j = i;
        str = Integer.toHexString(i);
      }
      localb.d.put(str, new b.60(localb));
      paramString = new ak("verified_name", new z[] { new z("v", "1") }, paramArrayOfByte);
      paramString = new ak("iq", new z[] { new z("id", str), new z("xmlns", "w:biz"), new z("type", "set"), new z("to", "s.whatsapp.net") }, paramString);
      localb.b.a(paramString);
      Log.i("xmpp/writer/write/set-biz-vname-cert");
    }
    
    public final void a(String paramString, byte[] paramArrayOfByte, int paramInt)
    {
      Log.d("xmpp/writer/before/write/send-location-key-retry-notification");
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      z localz1 = new z("id", Integer.toHexString(i));
      paramString = new z("to", paramString);
      z localz2 = new z("type", "location");
      paramArrayOfByte = new ak("encrypt", null, new ak[] { new ak("request", new z[] { new z("retry", String.valueOf(paramInt)) }), new ak("registration", null, paramArrayOfByte) });
      localb.b.a(new ak("notification", new z[] { localz1, paramString, localz2 }, paramArrayOfByte));
      Log.i("xmpp/writer/write/send-location-key-retry-notification");
    }
    
    public final void a(String paramString, String[] paramArrayOfString)
    {
      Log.d("xmpp/writer/before/write/get-pre-key-batch; id=" + paramString + "; jids=" + Arrays.toString(paramArrayOfString));
      as.b(as.this).a(paramString, paramArrayOfString);
      Log.i("xmpp/writer/write/get-pre-key-batch; id=" + paramString + "; jids=" + Arrays.toString(paramArrayOfString));
    }
    
    public final void a(String paramString1, Locale[] paramArrayOfLocale, String[] paramArrayOfString, String paramString2, String paramString3)
    {
      Log.d("xmpp/writer/before/write/get-biz-language-pack");
      b localb = as.b(as.this);
      if ((paramArrayOfLocale == null) || (paramArrayOfLocale.length == 0)) {
        throw new IllegalArgumentException("locales[] cannot be null or empty");
      }
      if ((paramArrayOfString != null) && (paramArrayOfLocale.length != paramArrayOfString.length)) {
        throw new IllegalArgumentException("locales[] and haveHashes[] must be the same length");
      }
      if (TextUtils.isEmpty(paramString2)) {
        throw new IllegalArgumentException("namespace cannot be null or empty");
      }
      String str1 = paramString1;
      if (paramString1 == null)
      {
        i = localb.j + 1;
        localb.j = i;
        str1 = Integer.toHexString(i);
      }
      localb.d.put(str1, new b.58(localb, paramString2, paramArrayOfLocale, paramArrayOfString));
      ak[] arrayOfak = new ak[paramArrayOfLocale.length];
      paramString1 = new ArrayList();
      int i = 0;
      while (i < arrayOfak.length)
      {
        paramString1.clear();
        String str2 = paramArrayOfLocale[i].getLanguage();
        String str3 = paramArrayOfLocale[i].getCountry();
        if (!TextUtils.isEmpty(str2)) {
          paramString1.add(new z("lg", str2));
        }
        if (!TextUtils.isEmpty(str3)) {
          paramString1.add(new z("lc", str3));
        }
        if ((paramArrayOfString != null) && (paramArrayOfString[i] != null)) {
          paramString1.add(new z("havehash", paramArrayOfString[i]));
        }
        arrayOfak[i] = new ak("item", (z[])paramString1.toArray(new z[paramString1.size()]));
        i += 1;
      }
      if (TextUtils.isEmpty(paramString3))
      {
        paramString1 = new z[1];
        paramString1[0] = new z("ns", paramString2);
      }
      for (;;)
      {
        paramString1 = new ak("languagepack", paramString1, arrayOfak);
        paramString1 = new ak("iq", new z[] { new z("id", str1), new z("xmlns", "w:biz"), new z("type", "get") }, paramString1);
        localb.b.a(paramString1);
        Log.i("xmpp/writer/write/get-biz-language-pack");
        return;
        paramString1 = new z[2];
        paramString1[0] = new z("ns", paramString2);
        paramString1[1] = new z("reason", paramString3);
      }
    }
    
    public final void a(boolean paramBoolean)
    {
      Log.d("xmpp/writer/before/write/set-connection-active; active=" + paramBoolean);
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      String str = Integer.toHexString(i);
      localb.d.put(str, new b.1(localb, paramBoolean));
      if (paramBoolean) {}
      for (Object localObject = "active";; localObject = "passive")
      {
        localObject = new ak((String)localObject, null);
        localObject = new ak("iq", new z[] { new z("id", str), new z("xmlns", "passive"), new z("type", "set"), new z("to", "s.whatsapp.net") }, (ak)localObject);
        localb.b.a((ak)localObject);
        Log.i("xmpp/writer/write/set-connection-active; active=" + paramBoolean);
        return;
      }
    }
    
    public final void a(byte[] paramArrayOfByte, String paramString)
    {
      Log.d("xmpp/writer/before/write/set-recovery-token");
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      String str = Integer.toHexString(i);
      localb.d.put(str, new b.72(localb, paramArrayOfByte, paramString));
      paramArrayOfByte = new ak("token", null, paramArrayOfByte);
      paramArrayOfByte = new ak("iq", new z[] { new z("id", str), new z("xmlns", "w:auth:token"), new z("type", "set"), new z("to", "s.whatsapp.net") }, paramArrayOfByte);
      localb.b.a(paramArrayOfByte);
      Log.i("xmpp/writer/write/set-recovery-token");
    }
    
    public final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte paramByte, aj[] paramArrayOfaj, aj paramaj)
    {
      Log.d("xmpp/writer/before/write/set-pre-key");
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      Object localObject2 = Integer.toHexString(i);
      localb.d.put(localObject2, new b.23(localb, paramArrayOfByte2));
      Object localObject1 = new ak[paramArrayOfaj.length];
      i = 0;
      while (i < paramArrayOfaj.length)
      {
        localObject1[i] = new ak("key", null, new ak[] { new ak("id", null, paramArrayOfaj[i].a), new ak("value", null, paramArrayOfaj[i].b) });
        i += 1;
      }
      paramArrayOfaj = new z("id", (String)localObject2);
      localObject2 = new z("xmlns", "encrypt");
      z localz1 = new z("type", "set");
      z localz2 = new z("to", "s.whatsapp.net");
      paramArrayOfByte1 = new ak("identity", null, paramArrayOfByte1);
      paramArrayOfByte2 = new ak("registration", null, paramArrayOfByte2);
      ak localak = new ak("type", null, new byte[] { paramByte });
      localObject1 = new ak("list", null, (ak[])localObject1);
      paramaj = new ak("skey", null, new ak[] { new ak("id", null, paramaj.a), new ak("value", null, paramaj.b), new ak("signature", null, paramaj.c) });
      paramArrayOfByte1 = new ak("iq", new z[] { paramArrayOfaj, localObject2, localz1, localz2 }, new ak[] { paramArrayOfByte1, paramArrayOfByte2, localak, localObject1, paramaj });
      localb.b.a(paramArrayOfByte1);
      Log.i("xmpp/writer/write/set-pre-key");
    }
    
    public final void a(String[] paramArrayOfString1, String[] paramArrayOfString2)
    {
      Log.d("xmpp/writer/before/write/capability-query");
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      String str = Integer.toHexString(i);
      localb.d.put(str, new b.53(localb));
      ak[] arrayOfak = new ak[paramArrayOfString1.length];
      i = 0;
      while (i < paramArrayOfString1.length)
      {
        arrayOfak[i] = new ak("user", new z[] { new z("jid", paramArrayOfString1[i]) });
        i += 1;
      }
      paramArrayOfString1 = new ak[paramArrayOfString2.length];
      i = 0;
      while (i < paramArrayOfString2.length)
      {
        paramArrayOfString1[i] = new ak(paramArrayOfString2[i], null);
        i += 1;
      }
      paramArrayOfString1 = new ak("query", null, new ak[] { new ak("feature", null, paramArrayOfString1) });
      paramArrayOfString2 = new ak("list", null, arrayOfak);
      paramArrayOfString1 = new ak("usync", new z[] { new z("sid", "get_features" + '_' + UUID.randomUUID().toString()), new z("index", "0"), new z("last", "true") }, new ak[] { paramArrayOfString1, paramArrayOfString2 });
      paramArrayOfString1 = new ak("iq", new z[] { new z("xmlns", "usync"), new z("id", str), new z("type", "get") }, paramArrayOfString1);
      localb.b.a(paramArrayOfString1);
      Log.i("xmpp/writer/write/capability-query");
    }
    
    public final void b()
    {
      Log.d("xmpp/writer/before/write/logout");
      b localb = as.b(as.this);
      ak localak = new ak("presence", new z[] { new z("type", "unavailable") });
      localb.b.a(localak);
      localb.b.a();
      as.a(as.this);
      Log.i("xmpp/writer/write/logout");
    }
    
    public final void b(bb parambb)
    {
      al localal = new al();
      localal.b = "message";
      localal.c = parambb.a;
      localal.a = parambb.b;
      localal.e = parambb.c;
      localal.d = parambb.d;
      if (!TextUtils.isEmpty(parambb.e)) {
        localal.a("error", parambb.e);
      }
      Log.d("xmpp/writer/before/write/send-message-ack");
      as.b(as.this).a(localal);
      Log.i("xmpp/writer/write/send-message-ack");
    }
    
    public final void b(bx parambx)
    {
      Log.d("xmpp/writer/before/write/get-invite-link-iq; jid=" + parambx.b);
      b localb = as.b(as.this);
      Object localObject1 = parambx.a;
      String str = parambx.b;
      Object localObject2 = parambx.c;
      x localx = parambx.d;
      localb.d.put(localObject1, new b.11(localb, (am)localObject2, localx));
      localObject2 = new ak("invite", null);
      localObject1 = new ak("iq", new z[] { new z("id", (String)localObject1), new z("xmlns", "w:g2"), new z("type", "get"), new z("to", str) }, (ak)localObject2);
      localb.b.a((ak)localObject1);
      Log.i("xmpp/writer/write/get-invite-link-iq; jid=" + parambx.b);
    }
    
    public final void b(ci paramci)
    {
      Log.d("xmpp/writer/before/write/web-messages; webQueryType=" + paramci.h);
      as.b(as.this).a(paramci.a, paramci.h, paramci.e, paramci.k, paramci.k);
      Log.i("xmpp/writer/write/web-messages; webQueryType=" + paramci.h);
    }
    
    public final void b(j paramj)
    {
      Log.d("xmpp/writer/before/write/message-received-structure-unavailable; message.key=" + paramj.e);
      b localb = as.b(as.this);
      j.b localb1 = paramj.e;
      String str = paramj.f;
      boolean bool = b.a(str);
      if (bool) {}
      for (Object localObject = str;; localObject = localb1.a)
      {
        if (bool) {
          str = localb1.a;
        }
        ak localak = new ak("error", new z[] { new z("type", "structure-unavailable") });
        localObject = new ak("receipt", b.a(localb1, "error", null, (String)localObject, str, null), localak);
        localb.b.a((ak)localObject);
        Log.i("xmpp/writer/write/message-received-structure-unavailable; message.key=" + paramj.e);
        return;
      }
    }
    
    public final void b(rj paramrj)
    {
      if (!paramrj.f)
      {
        Log.d("xmpp/writer/before/write/add-participants; groupId=" + paramrj.b + "; participants=" + paramrj.d);
        b localb = as.b(as.this);
        String str2 = paramrj.b;
        List localList = paramrj.d;
        com.whatsapp.protocol.aw localaw = paramrj.g;
        if (localaw != null) {}
        int i;
        for (String str1 = localaw.a;; str1 = Integer.toHexString(i))
        {
          localb.d.put(str1, new b.33(localb, paramrj, paramrj));
          localb.a(str2, localList, str1, "add", localaw);
          Log.i("xmpp/writer/write/add-participants; groupId=" + paramrj.b + "; participants=" + paramrj.d);
          return;
          i = localb.j + 1;
          localb.j = i;
        }
      }
      Log.e("xmpp/writer/write/add-participants/timeout; groupId=" + paramrj.b + "; participants=" + paramrj.d);
    }
    
    public final void b(xg.a parama)
    {
      String str = parama.d;
      byte[] arrayOfByte = parama.f;
      Log.d("xmpp/writer/before/write/request-encrypted-media-upload; fileType=" + str + "; uploadId=" + Arrays.toString(arrayOfByte));
      Object localObject2 = as.b(as.this);
      int i = ((b)localObject2).j + 1;
      ((b)localObject2).j = i;
      Object localObject1 = Integer.toHexString(i);
      ((b)localObject2).d.put(localObject1, new b.46((b)localObject2, parama));
      parama = ((b)localObject2).b;
      localObject1 = new z("id", (String)localObject1);
      localObject2 = new z("xmlns", "w:m");
      z localz1 = new z("type", "set");
      z localz2 = new z("to", "s.whatsapp.net");
      ak localak = new ak("encr_media", new z[] { new z("type", str), new z("hash", m.a(arrayOfByte)) });
      parama.a(new ak("iq", new z[] { localObject1, localObject2, localz1, localz2 }, localak));
      Log.i("xmpp/writer/write/request-encrypted-media-upload; fileType=" + str + "; uploadId=" + Arrays.toString(arrayOfByte));
    }
    
    public final void b(String paramString)
    {
      Log.d("xmpp/writer/before/write/subscription-request; jid=" + paramString);
      b localb = as.b(as.this);
      ak localak = new ak("presence", new z[] { new z("type", "subscribe"), new z("to", paramString) });
      localb.b.a(localak);
      Log.i("xmpp/writer/write/subscription-request; jid=" + paramString);
    }
    
    public final void b(String paramString, int paramInt)
    {
      Log.d("xmpp/writer/before/write/web-error; id=" + paramString + "; code=" + paramInt);
      as.b(as.this).a(paramString, paramInt);
      Log.i("xmpp/writer/write/web-error; id=" + paramString + "; code=" + paramInt);
    }
    
    public final void b(String paramString1, String paramString2)
    {
      Log.d("xmpp/writer/before/write/get-group-info; groupId=" + paramString1 + "; context=" + paramString2);
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      String str = Integer.toHexString(i);
      localb.d.put(str, new b.30(localb));
      Object localObject;
      if (paramString2 == null) {
        localObject = null;
      }
      for (;;)
      {
        localObject = new ak("query", (z[])localObject);
        localObject = new ak("iq", new z[] { new z("id", str), new z("xmlns", "w:g2"), new z("type", "get"), new z("to", paramString1) }, (ak)localObject);
        localb.b.a((ak)localObject);
        Log.i("xmpp/writer/write/get-group-info; groupId=" + paramString1 + "; context=" + paramString2);
        return;
        localObject = new z[1];
        localObject[0] = new z("request", paramString2);
      }
    }
    
    public final void b(String paramString1, String paramString2, String paramString3)
    {
      Log.d("xmpp/writer/before/write/call-offer-receipt; callId=" + paramString3);
      as.b(as.this).a(paramString1, paramString2, paramString3, "offer");
      Log.i("xmpp/writer/write/call-offer-receipt; callId=" + paramString3);
    }
    
    public final void b(String paramString1, String paramString2, String paramString3, int paramInt)
    {
      Log.d("xmpp/writer/before/write/call-notify-message; callId=" + paramString3);
      b localb = as.b(as.this);
      ak localak = new ak("notify", new z[] { new z("call-id", paramString3), new z("batterystate", Integer.toString(paramInt)) });
      paramString1 = new ak("call", new z[] { new z("to", paramString1), new z("id", paramString2) }, new ak[] { localak });
      localb.b.a(paramString1);
      Log.i("xmpp/writer/write/call-notify-message; callId=" + paramString3);
    }
    
    public final void b(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    {
      Log.d("xmpp/writer/before/write/call-mute; callId=" + paramString3);
      as.b(as.this).b.a(b.a(paramString1, paramString2, paramString3, paramBoolean, "mute"));
      Log.i("xmpp/writer/write/call-mute; callId=" + paramString3);
    }
    
    public final void b(String paramString1, String paramString2, boolean paramBoolean)
    {
      Log.d("xmpp/writer/before/write/web-pong; id=" + paramString1 + "; ref=" + paramString2 + "; active=" + paramBoolean);
      b localb = as.b(as.this);
      localb.d.put(paramString1, new b.47(localb));
      if (paramBoolean) {}
      for (Object localObject = "sync";; localObject = "deny")
      {
        localObject = new ak((String)localObject, new z[] { new z("web", "query") }, paramString2);
        localObject = new ak("iq", new z[] { new z("type", "set"), new z("xmlns", "w:web"), new z("id", paramString1) }, (ak)localObject);
        localb.b.a((ak)localObject);
        Log.i("xmpp/writer/write/web-pong; id=" + paramString1 + "; ref=" + paramString2 + "; active=" + paramBoolean);
        return;
      }
    }
    
    public final void b(boolean paramBoolean)
    {
      Log.d("xmpp/writer/before/write/web-disconnect; isLogout=" + paramBoolean);
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      String str = Integer.toHexString(i);
      localb.d.put(str, new b.49(localb));
      Object localObject;
      if (paramBoolean) {
        localObject = null;
      }
      for (;;)
      {
        localObject = new ak("delete", (z[])localObject);
        localObject = new ak("iq", new z[] { new z("id", str), new z("xmlns", "w:web"), new z("type", "set") }, (ak)localObject);
        localb.b.a((ak)localObject);
        Log.i("xmpp/writer/write/web-disconnet; isLogout=" + paramBoolean);
        return;
        localObject = new z[1];
        localObject[0] = new z("type", "Replaced by new connection");
      }
    }
    
    public final void c()
    {
      Log.d("xmpp/writer/before/write/inactive");
      b localb = as.b(as.this);
      ak localak = new ak("presence", new z[] { new z("type", "unavailable") });
      localb.b.a(localak);
      Log.i("xmpp/writer/write/inactive");
    }
    
    public final void c(ci paramci)
    {
      Log.d("xmpp/writer/before/write/web-message-status; key=" + paramci.d + "; webQueryType=" + paramci.h);
      b localb = as.b(as.this);
      String str1 = paramci.a;
      j.b localb1 = paramci.d;
      int i = paramci.h;
      auj.m localm1 = paramci.k;
      auj.m localm2 = paramci.k;
      String str2 = str1;
      if (str1 == null)
      {
        int j = localb.j + 1;
        localb.j = j;
        str2 = Integer.toHexString(j);
      }
      localb.d.put(str2, new b.62(localb, localm1, localm2));
      switch (i)
      {
      default: 
        str1 = "message";
      }
      for (;;)
      {
        localb.a(str2, "9", new ak("action", null, new ak("received", new z[] { new z("type", str1), new z("index", localb1.c), new z("owner", String.valueOf(localb1.b)), new z("jid", localb1.a) })));
        Log.d("xmpp/writer/write/web-message-status; key=" + paramci.d + "; webQueryType=" + paramci.h);
        return;
        str1 = "read";
        continue;
        str1 = "played";
        continue;
        str1 = "error";
      }
    }
    
    public final void c(j paramj)
    {
      Log.d("xmpp/writer/before/write/message-played; message.key=" + paramj.e);
      if ((qz.e(paramj.e.a)) || ((paramj.f != null) && (paramj.f.endsWith("broadcast")))) {}
      for (String str = paramj.f;; str = null)
      {
        as.b(as.this).a(paramj.e, "played", str, null, paramj.M, Integer.valueOf(paramj.ab));
        Log.i("xmpp/writer/write/message-played; message.key=" + paramj.e);
        return;
      }
    }
    
    public final void c(rj paramrj)
    {
      if (!paramrj.f)
      {
        Log.d("xmpp/writer/before/write/remove-participants; groupId=" + paramrj.b + "; participants=" + paramrj.d);
        b localb = as.b(as.this);
        String str2 = paramrj.b;
        List localList = paramrj.d;
        com.whatsapp.protocol.aw localaw = paramrj.g;
        if (localaw != null) {}
        int i;
        for (String str1 = localaw.a;; str1 = Integer.toHexString(i))
        {
          localb.d.put(str1, new b.35(localb, paramrj, paramrj));
          localb.a(str2, localList, str1, "remove", localaw);
          Log.i("xmpp/writer/write/remove-participants; groupId=" + paramrj.b + "; participants=" + paramrj.d);
          return;
          i = localb.j + 1;
          localb.j = i;
        }
      }
      Log.e("xmpp/writer/write/remove-participants/timeout; groupId=" + paramrj.b + "; participants=" + paramrj.d);
    }
    
    public final void c(String paramString)
    {
      Log.d("xmpp/writer/before/write/clear-dirty; category=" + paramString);
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      Object localObject = Integer.toHexString(i);
      localb.d.put(localObject, new b.27(localb));
      ak localak = new ak("clean", new z[] { new z("type", paramString) }, null);
      localObject = new ak("iq", new z[] { new z("id", (String)localObject), new z("xmlns", "urn:xmpp:whatsapp:dirty"), new z("type", "set"), new z("to", "s.whatsapp.net") }, localak);
      localb.b.a((ak)localObject);
      Log.i("xmpp/writer/write/clear-dirty; category=" + paramString);
    }
    
    public final void c(String paramString1, String paramString2)
    {
      Log.d("xmpp/writer/before/write/send-set-two-factor-auth");
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      String str = Integer.toHexString(i);
      localb.d.put(str, new b.55(localb, paramString1, paramString2));
      ArrayList localArrayList = new ArrayList(2);
      if (paramString1 != null) {
        localArrayList.add(new ak("code", null, paramString1));
      }
      if (paramString2 != null) {
        localArrayList.add(new ak("email", null, paramString2));
      }
      paramString1 = new ak("2fa", null, (ak[])localArrayList.toArray(new ak[localArrayList.size()]));
      paramString1 = new ak("iq", new z[] { new z("to", "s.whatsapp.net"), new z("id", str), new z("xmlns", "urn:xmpp:whatsapp:account"), new z("type", "set") }, paramString1);
      localb.b.a(paramString1);
      Log.d("xmpp/writer/write/send-set-two-factor-auth");
    }
    
    public final void c(String paramString1, String paramString2, String paramString3)
    {
      Log.d("xmpp/writer/before/write/call-accept-receipt; callId=" + paramString3);
      as.b(as.this).a(paramString1, paramString2, paramString3, "accept");
      Log.i("xmpp/writer/write/call-accept-receipt; callId=" + paramString3);
    }
    
    public final void d()
    {
      Log.d("xmpp/writer/before/write/active");
      as.b(as.this).c();
      Log.i("xmpp/writer/write/active");
    }
    
    public final void d(ci paramci)
    {
      Log.d("xmpp/writer/before/write/web-conversation-seen; jid=" + paramci.b);
      b localb = as.b(as.this);
      Object localObject2 = paramci.a;
      String str = paramci.b;
      int i;
      Object localObject1;
      if (paramci.h > 0)
      {
        i = 1;
        auj.m localm1 = paramci.k;
        auj.m localm2 = paramci.k;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          j = localb.j + 1;
          localb.j = j;
          localObject1 = Integer.toHexString(j);
        }
        localb.d.put(localObject1, new b.52(localb, localm1, str, localm2));
        if (i == 0) {
          break label231;
        }
      }
      label231:
      for (int j = 1;; j = 2)
      {
        localObject2 = new z[j];
        localObject2[0] = new z("jid", str);
        if (i == 0) {
          localObject2[1] = new z("type", "false");
        }
        localb.a((String)localObject1, "d", new ak("action", null, new ak("read", (z[])localObject2)));
        Log.i("xmpp/writer/write/web-conversation-seen; jid=" + paramci.b);
        return;
        i = 0;
        break;
      }
    }
    
    public final void d(j paramj)
    {
      Log.d("xmpp/writer/before/write/message-media-error; message.key=" + paramj.e);
      if ((qz.e(paramj.e.a)) || ((paramj.f != null) && (paramj.f.endsWith("broadcast"))) || ((paramj.f != null) && (paramj.e.a.equals("status@broadcast")))) {}
      for (String str = paramj.f;; str = null)
      {
        as.b(as.this).a(paramj.e, "server-error", str, null, null, null);
        Log.i("xmpp/writer/write/message-media-error; message.key=" + paramj.e);
        return;
      }
    }
    
    public final void d(rj paramrj)
    {
      if (!paramrj.f)
      {
        Log.d("xmpp/writer/before/write/add-admins; groupId=" + paramrj.b + "; participants=" + paramrj.d);
        b localb = as.b(as.this);
        String str2 = paramrj.b;
        List localList = paramrj.d;
        com.whatsapp.protocol.aw localaw = paramrj.g;
        if (localaw != null) {}
        int i;
        for (String str1 = localaw.a;; str1 = Integer.toHexString(i))
        {
          localb.d.put(str1, new b.36(localb, paramrj, paramrj));
          localb.a(str2, localList, str1, "promote", localaw);
          Log.i("xmpp/writer/write/add-admins; groupId=" + paramrj.b + "; participants=" + paramrj.d);
          return;
          i = localb.j + 1;
          localb.j = i;
        }
      }
      Log.e("xmpp/writer/write/add-admins/timeout; groupId=" + paramrj.b + "; participants=" + paramrj.d);
    }
    
    public final void d(String paramString)
    {
      Log.d("xmpp/writer/before/write/send-location-key-deny-notification");
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      z localz1 = new z("id", Integer.toHexString(i));
      paramString = new z("to", paramString);
      z localz2 = new z("type", "location");
      ak localak = new ak("encrypt", null, new ak("deny", null));
      localb.b.a(new ak("notification", new z[] { localz1, paramString, localz2 }, localak));
      Log.i("xmpp/writer/write/send-location-key-deny-notification");
    }
    
    public final void d(String paramString1, String paramString2)
    {
      Log.d("xmpp/writer/before/write/get-biz-vname-cert");
      b localb = as.b(as.this);
      if (TextUtils.isEmpty(paramString2)) {
        throw new IllegalArgumentException("jid cannot be null or empty");
      }
      String str = paramString1;
      if (paramString1 == null)
      {
        int i = localb.j + 1;
        localb.j = i;
        str = Integer.toHexString(i);
      }
      localb.d.put(str, new b.59(localb, paramString2));
      paramString1 = new ak("verified_name", new z[] { new z("jid", paramString2) });
      paramString1 = new ak("iq", new z[] { new z("id", str), new z("xmlns", "w:biz"), new z("type", "get") }, paramString1);
      localb.b.a(paramString1);
      Log.i("xmpp/writer/write/get-biz-vname-cert");
    }
    
    public final void d(String paramString1, String paramString2, String paramString3)
    {
      Log.d("xmpp/writer/before/write/call-reject-receipt; callId=" + paramString3);
      as.b(as.this).a(paramString1, paramString2, paramString3, "reject");
      Log.i("xmpp/writer/write/call-reject-receipt; callId=" + paramString3);
    }
    
    public final void e()
    {
      Log.d("xmpp/writer/before/write/get-groups");
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      Object localObject = Integer.toHexString(i);
      localb.d.put(localObject, new b.31(localb));
      ak localak = new ak("participating", null);
      localObject = new ak("iq", new z[] { new z("id", (String)localObject), new z("xmlns", "w:g2"), new z("type", "get"), new z("to", "g.us") }, localak);
      try
      {
        localb.b.a((ak)localObject);
        Log.i("xmpp/writer/write/get-groups");
        return;
      }
      catch (IOException localIOException)
      {
        Log.d("xmpp/writer/groupInitFailed", localIOException);
        localb.g.d();
        throw localIOException;
      }
    }
    
    public final void e(ci paramci)
    {
      Log.d("xmpp/writer/before/write/web-contact-updates");
      b localb = as.b(as.this);
      Object localObject1 = paramci.a;
      List localList = paramci.e;
      String str = paramci.c;
      Object localObject2 = paramci.k;
      auj.m localm = paramci.k;
      if (localObject1 == null)
      {
        int i = localb.j + 1;
        localb.j = i;
        paramci = Integer.toHexString(i);
        localb.d.put(paramci, new b.65(localb, (x)localObject2, localm));
        localObject2 = new ArrayList(localList.size());
        b.a(localList, (List)localObject2);
        if (!((List)localObject2).isEmpty()) {
          if (str != null) {
            break label184;
          }
        }
      }
      label184:
      for (localObject1 = null;; localObject1 = new z[] { new z("checksum", str) })
      {
        localb.a(paramci, "b", new ak("action", (z[])localObject1, (ak[])((List)localObject2).toArray(new ak[((List)localObject2).size()])));
        Log.i("xmpp/writer/write/web-contact-updates");
        return;
        paramci = (ci)localObject1;
        break;
      }
    }
    
    public final void e(rj paramrj)
    {
      if (!paramrj.f)
      {
        Log.d("xmpp/writer/before/write/remove-admins; groupId=" + paramrj.b + "; participants=" + paramrj.d);
        b localb = as.b(as.this);
        String str2 = paramrj.b;
        List localList = paramrj.d;
        com.whatsapp.protocol.aw localaw = paramrj.g;
        if (localaw != null) {}
        int i;
        for (String str1 = localaw.a;; str1 = Integer.toHexString(i))
        {
          localb.d.put(str1, new b.37(localb, paramrj, paramrj));
          localb.a(str2, localList, str1, "demote", localaw);
          Log.i("xmpp/writer/write/remove-admins; groupId=" + paramrj.b + "; participants=" + paramrj.d);
          return;
          i = localb.j + 1;
          localb.j = i;
        }
      }
      Log.e("xmpp/writer/write/remove-admins/timeout; groupId=" + paramrj.b + "; participants=" + paramrj.d);
    }
    
    public final void f()
    {
      Log.d("xmpp/writer/before/write/get-media-routing-info");
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      Object localObject = Integer.toHexString(i);
      localb.d.put(localObject, new b.20(localb));
      ak localak = new ak("media_conn", null);
      localObject = new ak("iq", new z[] { new z("to", "s.whatsapp.net"), new z("id", (String)localObject), new z("xmlns", "w:m"), new z("type", "set") }, localak);
      localb.b.a((ak)localObject);
      Log.i("xmpp/writer/write/get-media-routing-info");
    }
    
    public final void f(ci paramci)
    {
      Log.d("xmpp/writer/before/write/web-broadcast-list-recipients; jid=" + paramci.b);
      as.b(as.this).a(paramci.a, paramci.b, paramci.f, paramci.k, paramci.k);
      Log.i("xmpp/writer/write/web-broadcast-list-recipients; jid=" + paramci.b);
    }
    
    public final void f(rj paramrj)
    {
      if (!paramrj.f)
      {
        Log.d("xmpp/writer/before/write/leave-group; groupId=" + paramrj.b);
        b localb = as.b(as.this);
        Object localObject2 = paramrj.b;
        com.whatsapp.protocol.aw localaw = paramrj.g;
        Object localObject1;
        if (localaw != null)
        {
          localObject1 = localaw.a;
          localb.d.put(localObject1, new b.39(localb, paramrj, paramrj));
          localObject2 = new ak("leave", null, new ak[] { new ak("group", new z[] { new z("id", (String)localObject2) }) });
          if (localaw != null) {
            break label302;
          }
        }
        label302:
        for (int i = 4;; i = 5)
        {
          z[] arrayOfz = new z[i];
          arrayOfz[0] = new z("id", (String)localObject1);
          arrayOfz[1] = new z("xmlns", "w:g2");
          arrayOfz[2] = new z("type", "set");
          arrayOfz[3] = new z("to", "g.us");
          if (localaw != null) {
            arrayOfz[4] = new z("web", localaw.b);
          }
          localObject1 = new ak("iq", arrayOfz, (ak)localObject2);
          localb.b.a((ak)localObject1);
          Log.i("xmpp/writer/write/leave-group; groupId=" + paramrj.b);
          return;
          i = localb.j + 1;
          localb.j = i;
          localObject1 = Integer.toHexString(i);
          break;
        }
      }
      Log.e("xmpp/writer/write/leave-group/timeout; groupId=" + paramrj.b);
    }
    
    public final void g()
    {
      Log.d("xmpp/writer/before/write/get-broadcast-lists");
      as.b(as.this).b();
      Log.i("xmpp/writer/write/get-broadcast-lists");
    }
    
    public final void g(ci paramci)
    {
      Log.d("xmpp/writer/before/write/web-conversation-update");
      b localb;
      String str;
      Object localObject1;
      auj.m localm;
      if (paramci.j.a == null)
      {
        localb = as.b(as.this);
        str = paramci.a;
        localObject1 = paramci.j;
        localm = paramci.k;
        paramci = paramci.k;
        ((ar)localObject1).a = null;
        localObject1 = b.a((ar)localObject1);
        if (localObject1 != null) {
          localb.a(str, new ak[] { localObject1 }, localm, paramci);
        }
      }
      for (;;)
      {
        Log.i("xmpp/writer/write/web-conversation-update");
        return;
        localb = as.b(as.this);
        str = paramci.a;
        Object localObject2 = Collections.singletonList(paramci.j);
        localm = paramci.k;
        paramci = paramci.k;
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (ar)((Iterator)localObject2).next();
          if (((ar)localObject3).a != null)
          {
            localObject3 = b.a((ar)localObject3);
            if (localObject3 != null) {
              ((List)localObject1).add(localObject3);
            }
          }
        }
        if (!((List)localObject1).isEmpty()) {
          localb.a(str, (ak[])((List)localObject1).toArray(new ak[((List)localObject1).size()]), localm, paramci);
        }
      }
    }
    
    public final void g(rj paramrj)
    {
      if (!paramrj.f)
      {
        Log.d("xmpp/writer/before/write/end-group; groupId=" + paramrj.b);
        b localb = as.b(as.this);
        Object localObject2 = paramrj.b;
        int i = localb.j + 1;
        localb.j = i;
        Object localObject1 = Integer.toHexString(i);
        localb.d.put(localObject1, new b.38(localb, paramrj, paramrj));
        localObject2 = new ak("delete", null, new ak[] { new ak("group", new z[] { new z("id", (String)localObject2) }) });
        localObject1 = new ak("iq", new z[] { new z("id", (String)localObject1), new z("xmlns", "w:g2"), new z("type", "set"), new z("to", "g.us") }, (ak)localObject2);
        localb.b.a((ak)localObject1);
        Log.i("xmpp/writer/write/end-group; groupId=" + paramrj.b);
        return;
      }
      Log.e("xmpp/writer/write/end-group/timeout; groupId=" + paramrj.b);
    }
    
    public final void h()
    {
      Log.d("xmpp/writer/before/write/get-server-props");
      as.b(as.this).a();
      Log.i("xmpp/writer/write/get-server-props");
    }
    
    public final void h(ci paramci)
    {
      Log.d("xmpp/writer/before/write/web-identity-changed");
      b localb = as.b(as.this);
      String str = paramci.a;
      Object localObject3 = paramci.b;
      Object localObject2 = paramci.i;
      Object localObject1 = paramci.c;
      auj.m localm = paramci.k;
      localb.d.put(str, new b.68(localb, localm));
      localObject3 = new z("jid", (String)localObject3);
      localObject2 = new ak("raw", null, (byte[])localObject2);
      localObject1 = new ak("text", null, (String)localObject1);
      localb.a(str, "r", new ak("action", null, new ak("identity", new z[] { localObject3 }, new ak[] { localObject2, localObject1 })));
      Log.i("xmpp/writer/write/web-identity-changed/" + paramci.b);
    }
    
    public final void h(rj paramrj)
    {
      Log.d("xmpp/writer/before/set-subject; groupId=" + paramrj.b + "; subject=" + paramrj.c);
      b localb = as.b(as.this);
      String str = paramrj.b;
      Object localObject2 = paramrj.c;
      com.whatsapp.protocol.aw localaw = paramrj.g;
      Object localObject1;
      if (localaw != null)
      {
        localObject1 = localaw.a;
        localb.d.put(localObject1, new b.32(localb, paramrj, paramrj));
        localObject2 = new ak("subject", null, (String)localObject2);
        if (localaw != null) {
          break label293;
        }
      }
      label293:
      for (int i = 4;; i = 5)
      {
        z[] arrayOfz = new z[i];
        arrayOfz[0] = new z("id", (String)localObject1);
        arrayOfz[1] = new z("xmlns", "w:g2");
        arrayOfz[2] = new z("type", "set");
        arrayOfz[3] = new z("to", str);
        if (localaw != null) {
          arrayOfz[4] = new z("web", localaw.b);
        }
        localObject1 = new ak("iq", arrayOfz, (ak)localObject2);
        localb.b.a((ak)localObject1);
        Log.i("xmpp/writer/set-subject; groupId=" + paramrj.b + "; subject=" + paramrj.c);
        return;
        i = localb.j + 1;
        localb.j = i;
        localObject1 = Integer.toHexString(i);
        break;
      }
    }
    
    public final void i()
    {
      Log.d("xmpp/writer/before/write/get-privacy-settings");
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      Object localObject = Integer.toHexString(i);
      localb.d.put(localObject, new b.17(localb));
      ak localak = new ak("privacy", null);
      localObject = new ak("iq", new z[] { new z("to", "s.whatsapp.net"), new z("id", (String)localObject), new z("xmlns", "privacy"), new z("type", "get") }, localak);
      localb.b.a((ak)localObject);
      Log.i("xmpp/writer/write/get-privacy-settings");
    }
    
    public final void i(ci paramci)
    {
      Log.d("xmpp/writer/before/write/web-delete-messages");
      as.b(as.this).a("clear", paramci.a, paramci.b, Integer.valueOf(paramci.j.e), paramci.g, null, paramci.k, paramci.k);
      Log.i("xmpp/writer/write/web-delete-messages");
    }
    
    public final void i(rj paramrj)
    {
      if (!paramrj.f)
      {
        Log.d("xmpp/writer/before/write/delete-broadcast-lists; groupId=" + paramrj.b);
        as.b(as.this).a(new String[] { paramrj.b }, paramrj, paramrj);
        Log.i("xmpp/writer/write/delete-broadcast-lists; groupId=" + paramrj.b);
        return;
      }
      Log.e("xmpp/writer/write/delete-broadcast-lists/timeout; groupId=" + paramrj.b);
    }
    
    public final void j()
    {
      Log.d("xmpp/writer/before/write/get-tos-state");
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      Object localObject2 = Integer.toHexString(i);
      localb.d.put(localObject2, new b.24(localb));
      Object localObject1 = new z("to", "s.whatsapp.net");
      z localz1 = new z("type", "get");
      localObject2 = new z("id", (String)localObject2);
      z localz2 = new z("xmlns", "urn:xmpp:whatsapp:account");
      ak localak = new ak("accept", null);
      localObject1 = new ak("iq", new z[] { localObject1, localz1, localObject2, localz2 }, localak);
      localb.b.a((ak)localObject1);
      Log.i("xmpp/writer/write/get-tos-state");
    }
    
    public final void j(ci paramci)
    {
      Log.d("xmpp/writer/before/write/web-star-messages");
      b localb = as.b(as.this);
      String str1 = paramci.a;
      String str2 = paramci.b;
      int i;
      int j;
      List localList1;
      List localList2;
      auj.m localm1;
      auj.m localm2;
      if (paramci.j.c == 7)
      {
        i = 1;
        j = paramci.j.e;
        localList1 = paramci.g;
        localList2 = paramci.e;
        localm1 = paramci.k;
        localm2 = paramci.k;
        if (i == 0) {
          break label115;
        }
      }
      label115:
      for (paramci = "star";; paramci = "unstar")
      {
        localb.a(paramci, str1, str2, Integer.valueOf(j), localList1, localList2, localm1, localm2);
        Log.i("xmpp/writer/write/web-star-messages");
        return;
        i = 0;
        break;
      }
    }
    
    public final void k()
    {
      Log.d("xmpp/writer/before/write/get-pre-key-digest");
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      Object localObject = Integer.toHexString(i);
      localb.d.put(localObject, new b.45(localb));
      localObject = new z("id", (String)localObject);
      z localz1 = new z("xmlns", "encrypt");
      z localz2 = new z("type", "get");
      z localz3 = new z("to", "s.whatsapp.net");
      ak localak = new ak("digest", null);
      localObject = new ak("iq", new z[] { localObject, localz1, localz2, localz3 }, localak);
      localb.b.a((ak)localObject);
      Log.i("xmpp/writer/write/get-pre-key-digest");
    }
    
    public final void k(ci paramci)
    {
      Log.d("xmpp/writer/before/write/send-web-frequent-contacts");
      b localb = as.b(as.this);
      Object localObject1 = paramci.a;
      Object localObject2 = paramci.e;
      int i;
      if (localObject1 == null)
      {
        i = localb.j + 1;
        localb.j = i;
      }
      for (paramci = Integer.toHexString(i);; paramci = (ci)localObject1)
      {
        localObject1 = new ArrayList();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          av localav = (av)((Iterator)localObject2).next();
          ((ArrayList)localObject1).add(new ak(localav.a, new z[] { new z("jid", localav.d) }));
        }
      }
      localObject2 = new z("type", "frequent");
      localObject1 = (ak[])((ArrayList)localObject1).toArray(new ak[((ArrayList)localObject1).size()]);
      localb.a(paramci, "t", new ak("action", null, new ak("contacts", new z[] { localObject2 }, (ak[])localObject1)));
      Log.d("xmpp/writer/write/send-web-frequent-contacts");
    }
    
    public final void l()
    {
      Log.d("xmpp/writer/before/write/send-get-two-factor-auth");
      b localb = as.b(as.this);
      int i = localb.j + 1;
      localb.j = i;
      Object localObject = Integer.toHexString(i);
      localb.d.put(localObject, new b.57(localb));
      ak localak = new ak("2fa", null);
      localObject = new ak("iq", new z[] { new z("to", "s.whatsapp.net"), new z("id", (String)localObject), new z("xmlns", "urn:xmpp:whatsapp:account"), new z("type", "get") }, localak);
      localb.b.a((ak)localObject);
      Log.d("xmpp/writer/write/send-get-two-factor-auth");
    }
    
    public final void l(ci paramci)
    {
      Log.d("xmpp/writer/before/write/send-web-status-message-seen");
      b localb = as.b(as.this);
      Object localObject = paramci.a;
      j.b localb1 = paramci.d;
      String str1 = paramci.b;
      String str2 = paramci.c;
      auj.m localm1 = paramci.k;
      auj.m localm2 = paramci.k;
      int i;
      if (localObject == null)
      {
        i = localb.j + 1;
        localb.j = i;
      }
      for (paramci = Integer.toHexString(i);; paramci = (ci)localObject)
      {
        localb.d.put(paramci, new b.63(localb, localm1, localm2));
        localObject = new ArrayList();
        ((List)localObject).add(new z("kind", "status"));
        ((List)localObject).add(new z("jid", localb1.a));
        ((List)localObject).add(new z("index", localb1.c));
        ((List)localObject).add(new z("owner", String.valueOf(localb1.b)));
        ((List)localObject).add(new z("chat", str1));
        ((List)localObject).add(new z("checksum", str2));
        localb.a(paramci, "d", new ak("read", (z[])((List)localObject).toArray(new z[((List)localObject).size()])));
        Log.i("xmpp/writer/write/send-web-status-message-seen");
        return;
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void a();
    
    public abstract void a(Message paramMessage);
    
    public abstract void a(b paramb);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */