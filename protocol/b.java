package com.whatsapp.protocol;

import a.a.a.a.a.a.d;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.whatsapp.acm;
import com.whatsapp.aic;
import com.whatsapp.ant;
import com.whatsapp.anv;
import com.whatsapp.atv;
import com.whatsapp.contact.sync.ContactSyncManager.ParcelableSyncUserRequest;
import com.whatsapp.contact.sync.ContactSyncManager.c;
import com.whatsapp.data.cs;
import com.whatsapp.data.ct;
import com.whatsapp.l.e.b;
import com.whatsapp.location.LocationSharingService;
import com.whatsapp.lt;
import com.whatsapp.lt.a;
import com.whatsapp.messaging.ParcelablePreKey;
import com.whatsapp.messaging.ParcelableStanzaKey;
import com.whatsapp.messaging.ParcelableVoipOptions;
import com.whatsapp.messaging.ba;
import com.whatsapp.messaging.bc;
import com.whatsapp.messaging.be;
import com.whatsapp.messaging.bk;
import com.whatsapp.messaging.bl;
import com.whatsapp.messaging.bo;
import com.whatsapp.messaging.k;
import com.whatsapp.messaging.u.a;
import com.whatsapp.proto.E2E.Message;
import com.whatsapp.proto.E2E.Message.AudioMessage;
import com.whatsapp.proto.E2E.Message.DocumentMessage;
import com.whatsapp.proto.E2E.Message.ImageMessage;
import com.whatsapp.proto.E2E.Message.VideoMessage;
import com.whatsapp.proto.E2E.Message.a;
import com.whatsapp.proto.Protocol.MessageKey;
import com.whatsapp.proto.Protocol.MessageKey.a;
import com.whatsapp.proto.g.a;
import com.whatsapp.proto.g.b;
import com.whatsapp.proto.g.c;
import com.whatsapp.qz;
import com.whatsapp.rc;
import com.whatsapp.registration.aw.a;
import com.whatsapp.registration.ay;
import com.whatsapp.registration.az;
import com.whatsapp.rf;
import com.whatsapp.rg;
import com.whatsapp.rh;
import com.whatsapp.tf;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import com.whatsapp.util.w.a;
import com.whatsapp.va;
import com.whatsapp.va.a;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  final Context a;
  public final ao b;
  final aa c;
  public final Map<String, y> d = new ConcurrentHashMap();
  public final va e;
  final com.whatsapp.l.e f;
  public final qz g;
  final com.whatsapp.registration.aw h;
  final com.whatsapp.location.bp i;
  public int j;
  public long k;
  public long l;
  private final an m;
  private final ax n;
  private final LinkedHashMap<String, ak> o = new LinkedHashMap();
  private final Map<String, String> p = new HashMap();
  private final an q;
  private final ao r;
  private final k s;
  private final com.whatsapp.l.f t;
  private final atv u;
  
  public b(Context paramContext, va paramva, com.whatsapp.l.e parame, k paramk, qz paramqz, com.whatsapp.l.f paramf, com.whatsapp.registration.aw paramaw, atv paramatv, com.whatsapp.location.bp parambp, aa paramaa, an paraman1, ao paramao1, ax paramax, an paraman2, ao paramao2)
  {
    this.a = paramContext;
    this.e = ((va)a.d.a(paramva));
    this.f = ((com.whatsapp.l.e)a.d.a(parame));
    this.s = ((k)a.d.a(paramk));
    this.g = ((qz)a.d.a(paramqz));
    this.t = ((com.whatsapp.l.f)a.d.a(paramf));
    this.h = ((com.whatsapp.registration.aw)a.d.a(paramaw));
    this.u = ((atv)a.d.a(paramatv));
    this.i = ((com.whatsapp.location.bp)a.d.a(parambp));
    this.c = ((aa)a.d.a(paramaa));
    this.q = ((an)a.d.a(paraman1));
    this.r = ((ao)a.d.a(paramao1));
    this.n = ((ax)a.d.a(paramax));
    this.m = ((an)a.d.a(paraman2));
    this.b = ((ao)a.d.a(paramao2));
  }
  
  private int a(ak paramak, al paramal, long paramLong)
  {
    int i2 = 0;
    Object localObject3 = paramak.a("type", null);
    Object localObject1 = paramak.a("epoch", null);
    Object localObject5;
    if (localObject1 != null)
    {
      localObject5 = this.c;
      Log.i("xmpp/reader/read/on-qr-epoch");
      ((aa)localObject5).a.a(Message.obtain(null, 0, 51, 0, localObject1));
    }
    int i1;
    if (ak.b(paramak, "query"))
    {
      localObject1 = null;
      i2 = -1;
      if ("chat".equals(localObject3))
      {
        localObject3 = paramak.a("jid", null);
        if (localObject3 != null)
        {
          i1 = 18;
          localObject1 = new av();
          ((av)localObject1).d = ((String)localObject3);
        }
      }
    }
    for (;;)
    {
      label195:
      label348:
      label376:
      Object localObject2;
      Object localObject6;
      Object localObject7;
      Object localObject8;
      Object localObject9;
      boolean bool1;
      if (i1 != -1)
      {
        paramak = this.c;
        Log.i("xmpp/reader/read/on-qr-query-conversations " + paramal.c);
        paramak.a.a(Message.obtain(null, 0, 36, 0, new com.whatsapp.messaging.bp(paramal.a, paramal.c, i1, (av)localObject1)));
        i1 = 1;
        if (i1 == 0) {
          break label5253;
        }
        return 0;
        if ("retry".equals(paramak.a("kind", null)))
        {
          i1 = 1;
          continue;
        }
        i1 = 0;
        continue;
        if ("contacts".equals(localObject3))
        {
          if ("retry".equals(paramak.a("kind", null)))
          {
            i1 = 3;
            continue;
          }
          i1 = 2;
          continue;
        }
        if (("message".equals(localObject3)) || ("media_message".equals(localObject3)) || ("star".equals(localObject3)))
        {
          i1 = -1;
          switch (((String)localObject3).hashCode())
          {
          default: 
            switch (i1)
            {
            default: 
              localObject3 = new av();
              ((av)localObject3).e = paramak.a("chat", null);
              ((av)localObject3).d = paramak.a("jid", null);
              ((av)localObject3).g = paramak.a("index", null);
              ((av)localObject3).p = "true".equals(paramak.a("owner", null));
              ((av)localObject3).f = paramak.a("participant", null);
              localObject1 = paramak.a("count", null);
              ((av)localObject3).o = "after".equals(paramak.a("kind", null));
            }
            break;
          }
          try
          {
            ((av)localObject3).j = Integer.parseInt((String)localObject1);
            ((av)localObject3).x = paramak.a("media", null);
            i1 = i2;
            localObject1 = localObject3;
            if (TextUtils.isEmpty(((av)localObject3).x)) {
              continue;
            }
            i1 = i2;
            localObject1 = localObject3;
            if (i2 != 20) {
              continue;
            }
            return 501;
            if (!((String)localObject3).equals("message")) {
              break label348;
            }
            i1 = 0;
            break label348;
            if (!((String)localObject3).equals("media_message")) {
              break label348;
            }
            i1 = 1;
            break label348;
            if (!((String)localObject3).equals("star")) {
              break label348;
            }
            i1 = 2;
            break label348;
            i2 = 4;
            break label376;
            i2 = 23;
            break label376;
            i2 = 20;
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            for (;;)
            {
              ((av)localObject3).j = 20;
            }
          }
        }
        if ("media".equals(localObject3))
        {
          i1 = 5;
          localObject2 = new av();
          ((av)localObject2).d = paramak.a("jid", null);
          ((av)localObject2).g = paramak.a("index", null);
          ((av)localObject2).p = "true".equals(paramak.a("owner", null));
          ((av)localObject2).f = paramak.a("participant", null);
          continue;
        }
        if ("resume".equals(localObject3))
        {
          localObject3 = paramak.f("last");
          localObject2 = new av();
          ((av)localObject2).t = new ArrayList(((List)localObject3).size());
          i1 = 0;
          for (;;)
          {
            if (i1 < ((List)localObject3).size())
            {
              paramak = (ak)((List)localObject3).get(i1);
              localObject5 = paramak.b("jid");
              localObject6 = paramak.b("index");
              localObject7 = paramak.b("owner");
              localObject8 = paramak.b("archive");
              localObject9 = paramak.b("read_only");
              String str1 = paramak.b("active");
              if ((localObject5 != null) && (localObject8 != null)) {}
              try
              {
                String str2 = paramak.b("mute");
                if (str2 != null)
                {
                  paramLong = Long.parseLong(str2);
                  paramLong *= 1000L;
                }
              }
              catch (NumberFormatException localNumberFormatException7)
              {
                try
                {
                  i2 = Integer.parseInt(paramak.b("modify_tag"));
                }
                catch (NumberFormatException localNumberFormatException7)
                {
                  try
                  {
                    i3 = Integer.parseInt(paramak.b("count"));
                  }
                  catch (NumberFormatException localNumberFormatException7)
                  {
                    try
                    {
                      for (;;)
                      {
                        l1 = Long.parseLong(paramak.a("pin", "0"));
                        bool1 = "true".equals(localObject8);
                        bool2 = "false".equals(paramak.b("spam"));
                        if ((localObject6 == null) || (localObject7 == null)) {
                          break label1064;
                        }
                        paramak = new av.b(new j.b((String)localObject5, "true".equals(localObject7), (String)localObject6), bool1, "true".equals(str1), paramLong, "true".equals(localObject9), i2, i3, bool2, l1);
                        ((av)localObject2).t.add(paramak);
                        i1 += 1;
                        break;
                        paramLong = 0L;
                        continue;
                        localNumberFormatException5 = localNumberFormatException5;
                        paramLong = 0L;
                        continue;
                        localNumberFormatException6 = localNumberFormatException6;
                        i2 = 0;
                        continue;
                        localNumberFormatException7 = localNumberFormatException7;
                        int i3 = 0;
                      }
                    }
                    catch (NumberFormatException localNumberFormatException8)
                    {
                      for (;;)
                      {
                        boolean bool2;
                        long l1 = 0L;
                        continue;
                        label1064:
                        paramak = new av.b((String)localObject5, bool1, "true".equals(str1), paramLong, "true".equals(localObject9), i2, bool2, l1);
                      }
                    }
                  }
                }
              }
            }
          }
          i1 = 6;
          continue;
        }
        if ("receipt".equals(localObject3))
        {
          paramak = paramak.f("last");
          localObject2 = new av();
          ((av)localObject2).t = new ArrayList(paramak.size());
          i1 = 0;
          label1158:
          if (i1 < paramak.size())
          {
            localObject8 = (ak)paramak.get(i1);
            localObject3 = ((ak)localObject8).b("jid");
            localObject5 = ((ak)localObject8).b("index");
            localObject6 = ((ak)localObject8).b("t");
            localObject7 = ((ak)localObject8).b("owner");
            localObject8 = ((ak)localObject8).b("participant");
            if ((localObject3 == null) || (localObject5 == null) || (localObject6 == null) || (localObject7 == null)) {}
          }
        }
      }
      try
      {
        localObject9 = new av();
        ((av)localObject9).d = ((String)localObject3);
        ((av)localObject9).g = ((String)localObject5);
        ((av)localObject9).p = "true".equals(localObject7);
        ((av)localObject9).f = ((String)localObject8);
        ((av)localObject9).l = (Long.parseLong((String)localObject6) * 1000L);
        ((av)localObject2).t.add(localObject9);
        i1 += 1;
        break label1158;
        i1 = 11;
        continue;
        if ("group".equals(localObject3))
        {
          i1 = 12;
          localObject2 = new av();
          ((av)localObject2).d = paramak.b("jid");
          continue;
        }
        if ("preview".equals(localObject3))
        {
          i1 = 13;
          localObject2 = new av();
          ((av)localObject2).d = paramak.b("jid");
          ((av)localObject2).c = paramak.b("id");
          continue;
        }
        if ("action".equals(localObject3))
        {
          localObject2 = new av();
          paramak = paramak.f("item");
          ((av)localObject2).t = new ArrayList(paramak.size());
          i1 = 0;
          while (i1 < paramak.size())
          {
            localObject3 = ((ak)paramak.get(i1)).b("id");
            if (localObject3 != null) {
              ((av)localObject2).t.add(localObject3);
            }
            i1 += 1;
          }
          i1 = 14;
          continue;
        }
        if ("emoji".equals(localObject3))
        {
          localObject2 = new av();
          paramak = paramak.f("item");
          ((av)localObject2).t = new ArrayList(paramak.size());
          i1 = 0;
          label1590:
          if (i1 < paramak.size())
          {
            localObject3 = ((ak)paramak.get(i1)).b("code");
            localObject5 = ((ak)paramak.get(i1)).b("value");
            if ((localObject3 == null) || (localObject5 == null)) {}
          }
        }
        try
        {
          localObject6 = new av();
          ((av)localObject6).c = ((String)localObject3);
          ((av)localObject6).v = Float.parseFloat((String)localObject5);
          if (!Float.isNaN(((av)localObject6).v)) {
            ((av)localObject2).t.add(localObject6);
          }
          i1 += 1;
          break label1590;
          i1 = 16;
          continue;
          if ("message_info".equals(localObject3))
          {
            i1 = 17;
            localObject2 = new av();
            ((av)localObject2).d = paramak.b("jid");
            ((av)localObject2).g = paramak.b("index");
            continue;
          }
          if ("search".equals(localObject3))
          {
            localObject3 = paramak.b("search");
            i1 = i2;
            if (localObject3 == null) {
              continue;
            }
            i1 = 19;
            localObject2 = new av();
            ((av)localObject2).a = ((String)localObject3);
            ((av)localObject2).d = paramak.b("jid");
            try
            {
              ((av)localObject2).j = Integer.parseInt(paramak.b("count"));
              ((av)localObject2).i = Integer.parseInt(paramak.b("page"));
            }
            catch (NumberFormatException paramak)
            {
              ((av)localObject2).j = 50;
              ((av)localObject2).i = 1;
            }
            continue;
          }
          if ("identity".equals(localObject3))
          {
            i1 = 21;
            localObject2 = new av();
            ((av)localObject2).d = paramak.b("jid");
            continue;
          }
          if ("url".equals(localObject3))
          {
            i1 = 22;
            localObject2 = new av();
            ((av)localObject2).h = paramak.b("url");
            continue;
          }
          if ("vcard".equals(localObject3))
          {
            new av().d = paramak.b("jid");
            return 501;
          }
          i1 = i2;
          if (!"status".equals(localObject3)) {
            continue;
          }
          i1 = 27;
          localObject2 = new av();
          ((av)localObject2).d = paramak.b("jid");
          ((av)localObject2).p = Boolean.valueOf(paramak.a("owner", "false")).booleanValue();
          ((av)localObject2).g = paramak.b("index");
          ((av)localObject2).f = paramak.b("chat");
          ((av)localObject2).j = paramak.a("count", 0);
          ((av)localObject2).a = paramak.b("kind");
          continue;
          i1 = 0;
          break label195;
          i1 = i2;
          if (!ak.b(paramak, "action")) {
            break label195;
          }
          if ("relay".equals(localObject3))
          {
            paramak = paramak.a();
            if (ak.b(paramak, "message"))
            {
              paramak = paramak.d;
              if (paramak == null)
              {
                Log.w("invalid data in web message node: missing data");
                return 400;
              }
              localObject2 = com.whatsapp.proto.g.a(paramak);
              localObject3 = ((com.whatsapp.proto.g)localObject2).c;
              if (!((com.whatsapp.proto.g)localObject2).c())
              {
                Log.w("invalid data in web message node: missing Message proto");
                return 400;
              }
              paramak = ((com.whatsapp.proto.g)localObject2).d;
              if ((!((Protocol.MessageKey)localObject3).hasRemoteJid()) || (!((Protocol.MessageKey)localObject3).hasId()) || (!((Protocol.MessageKey)localObject3).hasFromMe()))
              {
                Log.w("invalid data in web message node: key is malformed");
                return 400;
              }
              localObject3 = new j(new j.b(((Protocol.MessageKey)localObject3).getRemoteJid(), ((Protocol.MessageKey)localObject3).getFromMe(), ((Protocol.MessageKey)localObject3).getId()));
              a.a.a.a.d.a(this.e, paramak, (j)localObject3, true, true, false);
              if (((com.whatsapp.proto.g)localObject2).d()) {
                ((j)localObject3).n = (((com.whatsapp.proto.g)localObject2).e * 1000L);
              }
              ((j)localObject3).X = 0;
              if ((((com.whatsapp.proto.g)localObject2).e()) && (((com.whatsapp.proto.g)localObject2).k)) {
                ((j)localObject3).X |= 0x1;
              }
              if ((((com.whatsapp.proto.g)localObject2).g()) && (((com.whatsapp.proto.g)localObject2).m)) {
                ((j)localObject3).X |= 0x4;
              }
              if ((((com.whatsapp.proto.g)localObject2).f()) && (((com.whatsapp.proto.g)localObject2).l)) {
                ((j)localObject3).X |= 0x2;
              }
              ((j)localObject3).M = j.c.c;
              localObject2 = new av();
              ((av)localObject2).s = ((j)localObject3);
              if ((paramak.hasImageMessage()) && (paramak.getImageMessage().hasMediaKey())) {
                ((av)localObject2).w = paramak.getImageMessage().getMediaKey().d();
              }
              for (;;)
              {
                paramak = this.c;
                Log.i("xmpp/reader/read/on-qr-action-relay-message");
                paramak.a.a(Message.obtain(null, 0, 37, 0, new com.whatsapp.messaging.bp(paramal.a, paramal.c, (av)localObject2)));
                i1 = 1;
                break;
                if ((paramak.hasDocumentMessage()) && (paramak.getDocumentMessage().hasMediaKey())) {
                  ((av)localObject2).w = paramak.getDocumentMessage().getMediaKey().d();
                } else if ((paramak.hasAudioMessage()) && (paramak.getAudioMessage().hasMediaKey())) {
                  ((av)localObject2).w = paramak.getAudioMessage().getMediaKey().d();
                } else if ((paramak.hasVideoMessage()) && (paramak.getVideoMessage().hasMediaKey())) {
                  ((av)localObject2).w = paramak.getVideoMessage().getMediaKey().d();
                }
              }
            }
          }
          else
          {
            i1 = i2;
            if (!"set".equals(localObject3)) {
              break label195;
            }
            localObject3 = paramak.a();
            if (ak.b((ak)localObject3, "group"))
            {
              paramak = new as();
              paramak.a = ((ak)localObject3).b("id");
              paramak.b = ((ak)localObject3).b("jid");
              paramak.c = ((ak)localObject3).b("type");
              paramak.d = ((ak)localObject3).b("author");
              paramak.f = ((ak)localObject3).b("subject");
              paramak.e = new ArrayList();
              localObject2 = ((ak)localObject3).f("participant");
              i2 = ((List)localObject2).size();
              i1 = 0;
              while (i1 < i2)
              {
                localObject3 = ((ak)((List)localObject2).get(i1)).b("jid");
                paramak.e.add(localObject3);
                i1 += 1;
              }
              localObject2 = this.c;
              Log.i("xmpp/reader/read/on-qr-action-set-group");
              ((aa)localObject2).a.a(Message.obtain(null, 0, 38, 0, new com.whatsapp.messaging.bp(paramal.a, paramal.c, paramak)));
              i1 = 1;
              break label195;
            }
            if (ak.b((ak)localObject3, "read"))
            {
              localObject2 = ((ak)localObject3).b("jid");
              paramak = ((ak)localObject3).b("index");
              bool1 = "true".equals(((ak)localObject3).b("owner"));
              try
              {
                i1 = Integer.parseInt(((ak)localObject3).b("count"));
                if (paramak != null)
                {
                  paramak = new j.b((String)localObject2, bool1, paramak);
                  localObject3 = this.c;
                  Log.i("xmpp/reader/read/on-qr-action-set-read");
                  ((aa)localObject3).a.a(Message.obtain(null, 0, 39, 0, new com.whatsapp.messaging.bp(paramal.a, paramal.c, (String)localObject2, paramak, i1)));
                  i1 = 1;
                }
              }
              catch (NumberFormatException localNumberFormatException2)
              {
                for (;;)
                {
                  i1 = 0;
                  continue;
                  paramak = null;
                }
              }
            }
            if (ak.b(localNumberFormatException2, "picture"))
            {
              paramak = new at();
              paramak.a = localNumberFormatException2.b("id");
              paramak.b = localNumberFormatException2.b("jid");
              paramak.c = localNumberFormatException2.b("type");
              if ("set".equals(paramak.c))
              {
                localObject2 = localNumberFormatException2.e("preview");
                localObject4 = localNumberFormatException2.e("image");
                i1 = i2;
                if (localObject2 == null) {
                  break label195;
                }
                i1 = i2;
                if (localObject4 == null) {
                  break label195;
                }
                paramak.d = ((ak)localObject2).d;
                paramak.e = ((ak)localObject4).d;
                this.c.a(paramal, paramak);
                i1 = 1;
                break label195;
              }
              i1 = i2;
              if (!"delete".equals(paramak.c)) {
                break label195;
              }
              this.c.a(paramal, paramak);
              i1 = 1;
              break label195;
            }
            if (ak.b((ak)localObject4, "presence"))
            {
              paramak = new au();
              paramak.a = ((ak)localObject4).b("type");
              paramak.d = (1000L * paramLong);
              if (("available".equals(paramak.a)) || ("unavailable".equals(paramak.a)))
              {
                this.c.a(paramal, paramak);
                i1 = 1;
                break label195;
              }
              if ("subscribe".equals(paramak.a))
              {
                paramak.b = ((ak)localObject4).b("to");
                this.c.a(paramal, paramak);
                i1 = 1;
                break label195;
              }
              if ((!"composing".equals(paramak.a)) && (!"paused".equals(paramak.a)))
              {
                i1 = i2;
                if (!"recording".equals(paramak.a)) {
                  break label195;
                }
              }
              paramak.b = ((ak)localObject4).b("to");
              paramak.c = ((ak)localObject4).b("jid");
              this.c.a(paramal, paramak);
              i1 = 1;
              break label195;
            }
            if (ak.b((ak)localObject4, "status"))
            {
              paramak = ((ak)localObject4).b();
              if (paramak != null)
              {
                localObject2 = this.c;
                Log.i("xmpp/reader/read/on-qr-action-set-sts");
                ((aa)localObject2).a.a(Message.obtain(null, 0, 43, 0, new com.whatsapp.messaging.bp(paramal.a, paramal.c, paramak)));
                i1 = 1;
                break label195;
              }
              paramak = ((ak)localObject4).b("jid");
              localObject2 = ((ak)localObject4).a("mute", "false");
              localObject4 = this.c;
              bool1 = Boolean.getBoolean((String)localObject2);
              Log.i("xmpp/reader/read/on-qr-action-set-status-mute");
              localObject2 = ((aa)localObject4).a;
              localObject4 = paramal.a;
              paramal = paramal.c;
              localObject5 = new Bundle();
              ((Bundle)localObject5).putString("from", (String)localObject4);
              ((Bundle)localObject5).putString("id", paramal);
              ((Bundle)localObject5).putString("jid", paramak);
              ((Bundle)localObject5).putBoolean("mute", bool1);
              ((u.a)localObject2).a(Message.obtain(null, 0, 128, 0, localObject5));
              i1 = i2;
              break label195;
            }
            if (ak.b((ak)localObject4, "received"))
            {
              paramak = ((ak)localObject4).b("type");
              localObject2 = new j.b(((ak)localObject4).b("from"), false, ((ak)localObject4).b("index"));
              localObject4 = this.c;
              Log.i("xmpp/reader/read/on-qr-action-set-recv");
              ((aa)localObject4).a.a(Message.obtain(null, 0, 44, 0, new com.whatsapp.messaging.bp(paramal.a, paramal.c, paramak, (j.b)localObject2)));
              i1 = 1;
              break label195;
            }
            if (ak.b((ak)localObject4, "chat"))
            {
              localObject6 = ((ak)localObject4).b("type");
              localObject5 = ((ak)localObject4).b("jid");
              paramak = ((ak)localObject4).b("index");
              bool1 = "true".equals(((ak)localObject4).b("owner"));
              if (paramak != null) {
                paramak = new j.b((String)localObject5, bool1, paramak);
              }
              while (("clear".equals(localObject6)) && (localObject5 != null))
              {
                localObject6 = ((ak)localObject4).f("item");
                i2 = ((List)localObject6).size();
                localObject2 = null;
                if (i2 > 0)
                {
                  localObject2 = new j.b[i2];
                  i1 = 0;
                  for (;;)
                  {
                    if (i1 < i2)
                    {
                      localObject7 = (ak)((List)localObject6).get(i1);
                      localObject2[i1] = new j.b((String)localObject5, "true".equals(((ak)localObject7).b("owner")), ((ak)localObject7).b("index"));
                      i1 += 1;
                      continue;
                      paramak = null;
                      break;
                    }
                  }
                }
                for (bool1 = "true".equals(((ak)localObject4).b("media"));; bool1 = "true".equals(((ak)localObject4).b("star")))
                {
                  this.c.a(paramal, new ar((String)localObject5, 1, paramak, (j.b[])localObject2, bool1));
                  i1 = 1;
                  break;
                }
              }
              if ((("star".equals(localObject6)) || ("unstar".equals(localObject6))) && (localObject5 != null))
              {
                localObject4 = ((ak)localObject4).f("item");
                i2 = ((List)localObject4).size();
                paramak = null;
                if (i2 > 0)
                {
                  localObject2 = new j.b[i2];
                  i1 = 0;
                  for (;;)
                  {
                    paramak = (ak)localObject2;
                    if (i1 >= i2) {
                      break;
                    }
                    paramak = (ak)((List)localObject4).get(i1);
                    localObject2[i1] = new j.b((String)localObject5, "true".equals(paramak.b("owner")), paramak.b("index"));
                    i1 += 1;
                  }
                }
                if ("star".equals(localObject6)) {}
                for (i1 = 7;; i1 = 8)
                {
                  this.c.a(paramal, new ar((String)localObject5, i1, null, paramak, false));
                  i1 = 1;
                  break;
                }
              }
              if (("unstar".equals(localObject6)) && (localObject5 == null))
              {
                this.c.a(paramal, new ar(null, 8, paramak));
                i1 = 1;
                break label195;
              }
              if (("delete".equals(localObject6)) && (localObject5 != null))
              {
                this.c.a(paramal, new ar((String)localObject5, 2, paramak));
                i1 = 1;
                break label195;
              }
              if (("archive".equals(localObject6)) && (localObject5 != null))
              {
                this.c.a(paramal, new ar((String)localObject5, 3, paramak));
                i1 = 1;
                break label195;
              }
              if (("unarchive".equals(localObject6)) && (localObject5 != null))
              {
                this.c.a(paramal, new ar((String)localObject5, 4, paramak));
                i1 = 1;
                break label195;
              }
              if (("mute".equals(localObject6)) && (localObject5 != null))
              {
                paramak = ((ak)localObject4).b("mute");
                localObject2 = ((ak)localObject4).b("previous");
                if (paramak != null) {}
              }
            }
            try
            {
              paramLong = Long.parseLong((String)localObject2) * 1000L;
              i1 = i2;
              if (paramLong == 0L) {
                break label195;
              }
              this.c.a(paramal, new ar((String)localObject5, 6, 0L, paramLong));
              i1 = 1;
            }
            catch (NumberFormatException paramak)
            {
              label4581:
              i1 = i2;
            }
            try
            {
              paramLong = Long.parseLong(paramak) * 1000L;
              i1 = i2;
              if (paramLong == 0L) {
                break label195;
              }
              i1 = i2;
              if (localObject2 != null) {
                break label195;
              }
              this.c.a(paramal, new ar((String)localObject5, 5, paramLong, 0L));
              i1 = 1;
            }
            catch (NumberFormatException paramak)
            {
              i1 = i2;
            }
            if (("spam".equals(localObject6)) && (localObject5 != null) && ("false".equals(((ak)localObject4).b("spam"))))
            {
              this.c.a(paramal, new ar((String)localObject5, 9, null));
              i1 = 1;
              break label195;
            }
            i1 = i2;
            if (!"pin".equals(localObject6)) {
              break label195;
            }
            i1 = i2;
            if (localObject5 == null) {
              break label195;
            }
            paramak = ((ak)localObject4).b("pin");
            localObject2 = ((ak)localObject4).b("previous");
            if (TextUtils.isEmpty(paramak)) {}
            for (i1 = 12;; i1 = 11)
            {
              localObject4 = new ar((String)localObject5, i1);
              if (i1 != 11) {
                break label4581;
              }
              try
              {
                paramLong = Long.parseLong(paramak);
                i1 = i2;
                if (paramLong == 0L) {
                  break;
                }
                ((ar)localObject4).i = paramLong;
                this.c.a(paramal, (ar)localObject4);
                i1 = 1;
              }
              catch (NumberFormatException paramak)
              {
                i1 = i2;
              }
            }
            try
            {
              paramLong = Long.parseLong((String)localObject2);
              i1 = i2;
              if (paramLong == 0L) {
                break label195;
              }
              ((ar)localObject4).i = paramLong;
              this.c.a(paramal, (ar)localObject4);
              i1 = 1;
            }
            catch (NumberFormatException paramak)
            {
              i1 = i2;
            }
            if (ak.b((ak)localObject4, "block"))
            {
              bool1 = "add".equals(((ak)localObject4).b("type"));
              paramak = ((ak)localObject4).e("user");
              i1 = i2;
              if (paramak == null) {
                break label195;
              }
              localObject2 = paramak.b("jid");
              i1 = i2;
              if (localObject2 == null) {
                break label195;
              }
              paramak = this.c;
              localObject2 = new aq((String)localObject2, bool1);
              Log.i("xmpp/reader/read/on-qr-action-set-block");
              paramak.a.a(Message.obtain(null, 0, 46, 0, new com.whatsapp.messaging.bp(paramal.a, paramal.c, (aq)localObject2)));
              i1 = 1;
              break label195;
            }
            if (ak.b((ak)localObject4, "spam"))
            {
              paramak = ((ak)localObject4).b("jid");
              i1 = i2;
              if (paramak == null) {
                break label195;
              }
              localObject2 = this.c;
              Log.i("xmpp/reader/read/on-qr-action-spam-report");
              ((aa)localObject2).a.a(Message.obtain(null, 0, 47, 0, new com.whatsapp.messaging.bp(paramal.a, paramal.c, paramak)));
              i1 = 1;
              break label195;
            }
            if (ak.b((ak)localObject4, "profile"))
            {
              paramak = ((ak)localObject4).b("name");
              i1 = i2;
              if (TextUtils.isEmpty(paramak)) {
                break label195;
              }
              localObject2 = this.c;
              Log.i("xmpp/reader/read/on-qr-action-set-push-name");
              ((aa)localObject2).a.a(Message.obtain(null, 0, 48, 0, new com.whatsapp.messaging.bp(paramal.a, paramal.c, paramak)));
              i1 = 1;
              break label195;
            }
            if (ak.b((ak)localObject4, "contacts"))
            {
              localObject2 = ((ak)localObject4).b("type");
              paramak = s.a(((ak)localObject4).d);
              i1 = i2;
              if (!TextUtils.equals((CharSequence)localObject2, "add")) {
                break label195;
              }
              i1 = i2;
              if (paramak == null) {
                break label195;
              }
              localObject2 = this.c;
              Log.i("xmpp/reader/read/on-qr-action-set-contact");
              localObject2 = ((aa)localObject2).a;
              localObject4 = paramal.a;
              paramal = paramal.c;
              localObject5 = new Bundle();
              ((Bundle)localObject5).putString("from", (String)localObject4);
              ((Bundle)localObject5).putString("id", paramal);
              ((Bundle)localObject5).putInt("op", 1);
              ((Bundle)localObject5).putString("vcard", paramak);
              ((u.a)localObject2).a(Message.obtain(null, 0, 49, 0, localObject5));
              i1 = 1;
              break label195;
            }
            i1 = i2;
            if (!ak.b((ak)localObject4, "privacy")) {
              break label195;
            }
            paramak = ((ak)localObject4).b("type");
            localObject2 = new ArrayList();
            Object localObject4 = ((ak)localObject4).f("user").iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = ((ak)((Iterator)localObject4).next()).b("jid");
              if (localObject5 != null) {
                ((ArrayList)localObject2).add(localObject5);
              }
            }
            localObject4 = this.c;
            Log.i("xmpp/reader/read/on-qr-action-set-status-privacy");
            localObject4 = ((aa)localObject4).a;
            localObject5 = paramal.a;
            paramal = paramal.c;
            localObject6 = new Bundle();
            ((Bundle)localObject6).putString("from", (String)localObject5);
            ((Bundle)localObject6).putString("id", paramal);
            ((Bundle)localObject6).putStringArrayList("jids", (ArrayList)localObject2);
            ((Bundle)localObject6).putString("type", paramak);
            ((u.a)localObject4).a(Message.obtain(null, 0, 129, 0, localObject6));
            i1 = 1;
            break label195;
            label5253:
            return 501;
            break label195;
            break label195;
            break label195;
          }
        }
        catch (NumberFormatException localNumberFormatException3)
        {
          for (;;) {}
        }
      }
      catch (NumberFormatException localNumberFormatException4)
      {
        for (;;)
        {
          continue;
          i1 = 0;
        }
      }
    }
  }
  
  public static ak a(ar paramar)
  {
    switch (paramar.c)
    {
    case 7: 
    default: 
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    String str;
    if (paramar.a == null)
    {
      str = "s.whatsapp.net";
      localArrayList.add(new z("jid", str));
      switch (paramar.c)
      {
      }
    }
    for (;;)
    {
      if (paramar.b != 0L) {
        localArrayList.add(new z("t", Long.toString(paramar.b / 1000L)));
      }
      if ((paramar.d != 0L) && (paramar.c == 1)) {
        localArrayList.add(new z("before", Long.toString(paramar.d / 1000L)));
      }
      if (((paramar.c == 1) || (paramar.c == 2) || (paramar.c == 10)) && (paramar.e > 0) && (paramar.e < 1000000)) {
        localArrayList.add(new z("modify_tag", Integer.toString(paramar.e)));
      }
      if (paramar.j) {
        localArrayList.add(new z("star", "true"));
      }
      return new ak("chat", (z[])localArrayList.toArray(new z[localArrayList.size()]));
      str = paramar.a;
      break;
      localArrayList.add(new z("type", "clear"));
      continue;
      localArrayList.add(new z("type", "delete"));
      continue;
      localArrayList.add(new z("type", "archive"));
      continue;
      localArrayList.add(new z("type", "unarchive"));
      continue;
      localArrayList.add(new z("type", "mute"));
      localArrayList.add(new z("mute", Long.toString(paramar.d / 1000L)));
      continue;
      localArrayList.add(new z("type", "mute"));
      continue;
      localArrayList.add(new z("type", "unstar"));
      continue;
      localArrayList.add(new z("type", "spam"));
      localArrayList.add(new z("spam", "false"));
      continue;
      localArrayList.add(new z("type", "modify_tag"));
      continue;
      localArrayList.add(new z("type", "pin"));
      localArrayList.add(new z("pin", String.valueOf(paramar.i / 1000L)));
      continue;
      localArrayList.add(new z("type", "pin"));
    }
  }
  
  private ak a(av paramav)
  {
    return a(paramav, false);
  }
  
  private ak a(av paramav, boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = paramav.s;
    if (localObject1 != null)
    {
      paramav = com.whatsapp.proto.g.h();
      localObject2 = Protocol.MessageKey.newBuilder();
      ((Protocol.MessageKey.a)localObject2).setRemoteJid(((j)localObject1).e.a);
      ((Protocol.MessageKey.a)localObject2).setFromMe(((j)localObject1).e.b);
      ((Protocol.MessageKey.a)localObject2).setId(((j)localObject1).e.c);
      paramav.a(((Protocol.MessageKey.a)localObject2).build());
      paramav.a(((j)localObject1).n / 1000L);
      if ((!TextUtils.isEmpty(((j)localObject1).f)) && ((((j)localObject1).e.a.endsWith("@g.us")) || (((j)localObject1).a()))) {
        paramav.a(((j)localObject1).f);
      }
      switch (((j)localObject1).d)
      {
      case 1: 
      case 2: 
      case 3: 
      case 6: 
      case 11: 
      case 12: 
      default: 
        paramav.a(g.b.b);
        if (paramBoolean) {
          paramav.a(paramBoolean);
        }
        if (((j)localObject1).T) {
          paramav.b(((j)localObject1).T);
        }
        if (((j)localObject1).E) {
          paramav.c(((j)localObject1).E);
        }
        if (((j)localObject1).s == 11) {
          paramav.a(g.c.c);
        }
        break;
      }
      for (;;)
      {
        return new ak("message", null, paramav.b().toByteArray());
        paramav.a(g.b.a);
        break;
        paramav.a(g.b.c);
        break;
        paramav.a(g.b.d);
        break;
        paramav.a(g.b.e);
        break;
        paramav.a(g.b.f);
        break;
        if (((j)localObject1).s == 15)
        {
          paramav.a(g.c.b);
        }
        else if (((j)localObject1).s == 12)
        {
          paramav.a(g.c.d);
        }
        else
        {
          localObject2 = E2E.Message.newBuilder();
          a.a.a.a.d.a(this.e, (j)localObject1, (E2E.Message.a)localObject2, false, true, false);
          paramav.a(((E2E.Message.a)localObject2).build());
        }
      }
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new z("id", paramav.c));
    if (paramav.p) {}
    for (localObject1 = "true";; localObject1 = "false")
    {
      localArrayList.add(new z("owner", (String)localObject1));
      localArrayList.add(new z("t", Long.toString(paramav.l / 1000L)));
      if (paramBoolean) {
        localArrayList.add(new z("web", "invis"));
      }
      switch (paramav.i)
      {
      default: 
        return null;
      case 0: 
        localArrayList.add(new z("jid", paramav.d));
        return new ak("notification", (z[])localArrayList.toArray(new z[localArrayList.size()]), paramav.a);
      }
    }
    localArrayList.add(new z("jid", paramav.e));
    if (paramav.d != null) {
      localArrayList.add(new z("author", paramav.d));
    }
    switch (paramav.i)
    {
    }
    while ((paramav.t != null) && (paramav.t.size() > 0))
    {
      localObject1 = new ArrayList(paramav.t.size());
      paramav = paramav.t.iterator();
      for (;;)
      {
        if (paramav.hasNext())
        {
          localObject2 = (String)paramav.next();
          if (localObject2 != null)
          {
            ((List)localObject1).add(new ak("participant", new z[] { new z("jid", (String)localObject2) }));
            continue;
            localArrayList.add(new z("type", "create"));
            localArrayList.add(new z("subject", paramav.a));
            break;
            localArrayList.add(new z("type", "delete"));
            break;
            localArrayList.add(new z("type", "add"));
            break;
            localArrayList.add(new z("type", "invite"));
            break;
            localArrayList.add(new z("type", "remove"));
            break;
            localArrayList.add(new z("type", "promote"));
            break;
            localArrayList.add(new z("type", "demote"));
            break;
            localArrayList.add(new z("type", "leave"));
            break;
            localArrayList.add(new z("type", "picture"));
            if (paramav.a == null) {}
            for (localObject1 = "remove";; localObject1 = paramav.a)
            {
              localArrayList.add(new z("picture", (String)localObject1));
              break;
            }
            localArrayList.add(new z("type", "modify"));
            break;
            localArrayList.add(new z("type", "subject"));
            localArrayList.add(new z("subject", paramav.a));
            break;
            localArrayList.add(new z("type", "revoke_invite"));
            break;
          }
        }
      }
      if (((List)localObject1).size() <= 0) {
        break;
      }
    }
    for (paramav = (ak[])((List)localObject1).toArray(new ak[((List)localObject1).size()]);; paramav = null)
    {
      return new ak("groups_v2", (z[])localArrayList.toArray(new z[localArrayList.size()]), paramav);
      localArrayList.add(new z("jid", paramav.e));
      switch (paramav.i)
      {
      default: 
        paramav = (av)localObject2;
      }
      for (;;)
      {
        return new ak("broadcast", (z[])localArrayList.toArray(new z[localArrayList.size()]), paramav);
        localArrayList.add(new z("type", "create"));
        localArrayList.add(new z("count", Integer.toString(paramav.j)));
        paramav = (av)localObject2;
        continue;
        localArrayList.add(new z("type", "add"));
        paramav = new ak("participant", new z[] { new z("jid", paramav.d) });
        continue;
        localArrayList.add(new z("type", "remove"));
        paramav = new ak("participant", new z[] { new z("jid", paramav.d) });
      }
      localArrayList.add(new z("jid", paramav.e));
      switch (paramav.i)
      {
      default: 
        paramav = (av)localObject3;
      }
      for (;;)
      {
        return new ak("security", (z[])localArrayList.toArray(new z[localArrayList.size()]), paramav);
        localArrayList.add(new z("type", "identity"));
        paramav = new ak("participant", new z[] { new z("jid", paramav.d) });
        continue;
        localArrayList.add(new z("type", "encrypt"));
        paramav = (av)localObject3;
      }
      localArrayList.add(new z("type", "miss"));
      localArrayList.add(new z("id", paramav.c));
      localArrayList.add(new z("jid", paramav.d));
      localArrayList.add(new z("t", Long.toString(paramav.l)));
      localArrayList.add(new z("owner", Boolean.toString(paramav.p)));
      if (paramav.a != null) {
        localArrayList.add(new z("kind", paramav.a));
      }
      if (paramav.f != null) {
        localArrayList.add(new z("participant", paramav.f));
      }
      return new ak("call_log", (z[])localArrayList.toArray(new z[localArrayList.size()]));
    }
  }
  
  public static ak a(f paramf, int paramInt, String paramString1, String paramString2, Integer paramInteger)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new z("v", Integer.toString(paramf.a)));
    int i1 = paramf.b;
    String str;
    switch (i1)
    {
    default: 
      throw new IllegalArgumentException("Unsupported ciphertext type " + i1);
    case 0: 
      str = "msg";
    }
    for (;;)
    {
      localArrayList.add(new z("type", str));
      if (paramInt != 0) {
        localArrayList.add(new z("count", String.valueOf(paramInt)));
      }
      if (paramString1 != null)
      {
        localArrayList.add(new z("mediatype", paramString1));
        if (paramString2 != null) {
          localArrayList.add(new z("mediareason", paramString2));
        }
      }
      if ((paramInteger != null) && (paramInteger.intValue() > 0)) {
        localArrayList.add(new z("duration", String.valueOf(paramInteger)));
      }
      return new ak("enc", (z[])localArrayList.toArray(new z[localArrayList.size()]), paramf.c);
      str = "pkmsg";
      continue;
      str = "skmsg";
      continue;
      str = "frskmsg";
    }
  }
  
  public static ak a(String paramString1, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    z localz = new z("call-id", paramString3);
    if (paramBoolean) {}
    for (paramString3 = "end";; paramString3 = "begin")
    {
      paramString3 = new ak(paramString4, new z[] { localz, new z("state", paramString3) });
      return new ak("call", new z[] { new z("to", paramString2), new z("id", paramString1) }, paramString3);
    }
  }
  
  public static a a(String paramString1, String paramString2, String paramString3, String paramString4, ArrayList<ContactSyncManager.ParcelableSyncUserRequest> paramArrayList, String[] paramArrayOfString)
  {
    ak[] arrayOfak1 = new ak[paramArrayList.size()];
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    int i1 = 0;
    int i2;
    if (i1 < paramArrayList.size())
    {
      Object localObject = (ContactSyncManager.ParcelableSyncUserRequest)paramArrayList.get(i1);
      label55:
      label76:
      ak[] arrayOfak2;
      label139:
      boolean bool4;
      if (((ContactSyncManager.ParcelableSyncUserRequest)localObject).e)
      {
        i2 = 1;
        if ((!((ContactSyncManager.ParcelableSyncUserRequest)localObject).f) || (((ContactSyncManager.ParcelableSyncUserRequest)localObject).d <= 0L)) {
          break label318;
        }
        i3 = 1;
        arrayOfak2 = new ak[i2 + i3];
        i2 = 0;
        if (((ContactSyncManager.ParcelableSyncUserRequest)localObject).e)
        {
          if (!((ContactSyncManager.ParcelableSyncUserRequest)localObject).c) {
            break label324;
          }
          arrayOfak2[0] = new ak("contact", new z[] { new z("type", "delete") });
          bool2 = true;
          i2 = 1;
        }
        if (((ContactSyncManager.ParcelableSyncUserRequest)localObject).f)
        {
          bool4 = true;
          bool3 = bool4;
          if (((ContactSyncManager.ParcelableSyncUserRequest)localObject).d > 0L)
          {
            arrayOfak2[i2] = new ak("status", new z[] { new z("t", String.valueOf(((ContactSyncManager.ParcelableSyncUserRequest)localObject).d)) });
            bool3 = bool4;
          }
        }
        bool4 = bool1;
        if (((ContactSyncManager.ParcelableSyncUserRequest)localObject).g)
        {
          bool4 = bool1;
          if (paramArrayOfString != null)
          {
            bool4 = bool1;
            if (paramArrayOfString.length != 0) {
              bool4 = true;
            }
          }
        }
        if (((ContactSyncManager.ParcelableSyncUserRequest)localObject).a == null) {
          break label347;
        }
      }
      label318:
      label324:
      label347:
      for (localObject = new z[] { new z("jid", ((ContactSyncManager.ParcelableSyncUserRequest)localObject).a) };; localObject = null)
      {
        arrayOfak1[i1] = new ak("user", (z[])localObject, arrayOfak2);
        i1 += 1;
        bool1 = bool4;
        break;
        i2 = 0;
        break label55;
        i3 = 0;
        break label76;
        arrayOfak2[0] = new ak("contact", null, ((ContactSyncManager.ParcelableSyncUserRequest)localObject).b);
        break label139;
      }
    }
    paramString2 = new z("mode", paramString2);
    paramArrayList = new z("context", paramString3);
    int i4 = 0;
    if (bool2)
    {
      i1 = 1;
      if (!bool3) {
        break label540;
      }
      i2 = 1;
      label397:
      if (!bool1) {
        break label546;
      }
    }
    label540:
    label546:
    for (int i3 = 1;; i3 = 0)
    {
      paramString3 = new ak[i3 + (i1 + i2)];
      i1 = i4;
      if (bool2)
      {
        i1 = 1;
        paramString3[0] = new ak("contact", new z[] { paramString2, paramArrayList });
      }
      i2 = i1;
      if (bool3)
      {
        paramString3[i1] = new ak("status", null);
        i2 = i1 + 1;
      }
      if (!bool1) {
        break label568;
      }
      paramString2 = new ak[paramArrayOfString.length];
      i1 = 0;
      while (i1 < paramArrayOfString.length)
      {
        paramString2[i1] = new ak(paramArrayOfString[i1], null);
        i1 += 1;
      }
      i1 = 0;
      break;
      i2 = 0;
      break label397;
    }
    paramString3[i2] = new ak("feature", null, paramString2);
    label568:
    paramString2 = new ak("query", null, paramString3);
    paramString3 = new ak("list", null, arrayOfak1);
    paramString2 = new ak("usync", new z[] { new z("sid", paramString4), new z("index", "0"), new z("last", "true") }, new ak[] { paramString2, paramString3 });
    return new a(new ak("iq", new z[] { new z("xmlns", "usync"), new z("id", paramString1), new z("type", "get") }, paramString2), bool2, bool3, bool1);
  }
  
  private static g a(List<ak> paramList)
  {
    g localg = new g();
    if (paramList == null) {
      return localg;
    }
    byte[][] arrayOfByte = new byte[paramList.size()][];
    int[] arrayOfInt = new int[paramList.size()];
    int i1 = 0;
    while (i1 < paramList.size())
    {
      Object localObject = (ak)paramList.get(i1);
      arrayOfByte[i1] = ((ak)localObject).d;
      localObject = ((ak)localObject).a("latency");
      try
      {
        arrayOfInt[i1] = Integer.parseInt((String)localObject);
        i1 += 1;
      }
      catch (NumberFormatException paramList)
      {
        throw new c("invalid latency parameter: " + (String)localObject);
      }
    }
    localg.a = arrayOfByte;
    localg.b = arrayOfInt;
    return localg;
  }
  
  private static h a(ak paramak, boolean paramBoolean)
  {
    List localList = paramak.f("te");
    if ((paramBoolean) && (localList.isEmpty())) {
      throw new c("no te elements on node: " + paramak.a);
    }
    return b(localList);
  }
  
  private static j.a a(j.a parama, ak paramak)
  {
    Object localObject = f.a(paramak);
    if (((f)localObject).b == 2) {
      parama.h = ((f)localObject);
    }
    int i1;
    for (;;)
    {
      localObject = paramak.a("count", "0");
      try
      {
        i1 = Integer.parseInt((String)localObject);
        localObject = parama.f;
        if ((localObject == null) || (((Integer)localObject).intValue() == i1)) {
          break;
        }
        throw new c("retry count may not mismatch between two enc nodes in the same message");
      }
      catch (NumberFormatException parama)
      {
        throw new c("invalid retry count provided: " + (String)localObject);
      }
      parama.g = ((f)localObject);
    }
    parama.f = Integer.valueOf(i1);
    localObject = paramak.b("mediareason");
    if (localObject != null)
    {
      if (((String)localObject).equals("retry"))
      {
        localObject = parama.l;
        if ((localObject != null) && (!((Boolean)localObject).booleanValue())) {
          throw new c("mediareason retry may not mismatch between two enc nodes in the same message");
        }
        parama.l = Boolean.TRUE;
      }
    }
    else
    {
      i1 = paramak.a("duration", -1);
      if (i1 >= 0) {
        parama.k = Integer.valueOf(i1);
      }
      if ((parama.h == null) || (parama.g == null) || (parama.h.a == parama.g.a)) {
        break label248;
      }
      throw new c("ciphertext version may not mismatch between two enc nodes in the same message");
    }
    throw new c("unknown mediareason " + (String)localObject);
    label248:
    return parama.b();
  }
  
  private void a(ak paramak)
  {
    Object localObject2 = paramak.a("participant", null);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = new al();
    ((al)localObject2).a = paramak.a("from", null);
    ((al)localObject2).b = "notification";
    ((al)localObject2).c = paramak.a("id", null);
    ((al)localObject2).d = paramak.a("type", null);
    ((al)localObject2).e = ((String)localObject1);
    a((al)localObject2);
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new z("to", paramString2));
    localArrayList.add(new z("id", paramString1));
    if (paramString3 != null) {
      localArrayList.add(new z("participant", paramString3));
    }
    if (paramInt == 0) {
      localArrayList.add(new z("type", "result"));
    }
    for (paramString1 = null;; paramString1 = new ak("error", new z[] { new z("code", Integer.toString(paramInt)) }))
    {
      this.b.a(new ak("iq", (z[])localArrayList.toArray(new z[localArrayList.size()]), paramString1));
      return;
      localArrayList.add(new z("type", "error"));
    }
  }
  
  public static void a(List<av> paramList, List<ak> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      av localav = (av)paramList.next();
      boolean bool = localav.d.endsWith("@s.whatsapp.net");
      localArrayList.clear();
      localArrayList.add(new z("jid", localav.d));
      if (!TextUtils.isEmpty(localav.f)) {
        localArrayList.add(new z("notify", localav.f));
      }
      if (localav.a != null)
      {
        localArrayList.add(new z("name", localav.a));
        if ((!localav.p) && (bool)) {
          localArrayList.add(new z("type", "out"));
        }
        if (localav.b != null) {
          localArrayList.add(new z("short", localav.b));
        }
        if (localav.r) {
          localArrayList.add(new z("verify", "true"));
        }
        if (localav.q) {
          localArrayList.add(new z("status_mute", "true"));
        }
      }
      paramList1.add(new ak("user", (z[])localArrayList.toArray(new z[localArrayList.size()])));
    }
  }
  
  private boolean a(ak paramak, al paramal)
  {
    boolean bool1 = false;
    Object localObject1 = paramal.e;
    paramak.a("notify", null);
    Object localObject2 = paramak.a();
    if (ak.b((ak)localObject2, "add"))
    {
      paramak = new HashMap();
      b((ak)localObject2, paramak);
      if (paramak.size() > 0)
      {
        this.g.a(paramal, paramak, ((ak)localObject2).b("reason"));
        bool1 = true;
      }
    }
    label1086:
    label1092:
    label1104:
    label1205:
    label1211:
    label1531:
    label1561:
    label1584:
    label1734:
    label1740:
    label1746:
    label1752:
    do
    {
      Object localObject3;
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
                return bool1;
                if (!ak.b((ak)localObject2, "create")) {
                  break;
                }
                paramak = ((ak)localObject2).a();
                ((ak)localObject2).b("type");
                ((ak)localObject2).b("key");
                localObject2 = ((ak)localObject2).b("reason");
              } while (!ak.b(paramak, "group"));
              localObject3 = b(paramak.b("id"));
              localObject4 = paramak.b("creator");
              localObject1 = paramak.b("creation");
              try
              {
                l1 = Long.parseLong((String)localObject1);
                l1 *= 1000L;
              }
              catch (NumberFormatException localNumberFormatException1)
              {
                synchronized (((lt)localObject9).a)
                {
                  for (;;)
                  {
                    localObject1 = ((lt)localObject9).b(paramak);
                    paramak = (ak)localObject1;
                    if (localObject1 == null)
                    {
                      paramak = new lt.a((byte)0);
                      paramak.a = ((String)localObject3);
                    }
                    ((lt)localObject9).a.remove(paramak);
                    paramak.a = ((String)localObject3);
                    ((lt)localObject9).a.add(0, paramak);
                    paramak = ((qz)localObject5).p.a((String)localObject3);
                    Log.i("groupmgr/onGroupNewGroup oldparticipants:" + paramak.a());
                    bool4 = paramak.b(((qz)localObject5).e);
                    ((qz)localObject5).a(paramak, (Map)localObject7, false);
                    ((qz)localObject5).p.d((String)localObject3);
                    if (bool1) {
                      qz.a(0, ((qz)localObject5).a(paramal, (String)localObject3, (String)localObject6, (String)localObject4, l2));
                    }
                    if ((!((Map)localObject7).containsKey(((qz)localObject5).e.c().t)) || (bool2) || (bool4) || (bool3)) {
                      break label1211;
                    }
                    Log.i("groupmgr/onGroupNewGroup/" + ((qz)localObject5).e.c().t);
                    localObject1 = new ArrayList(1);
                    ((List)localObject1).add(((qz)localObject5).e.c().t);
                    if (!bool1) {
                      break;
                    }
                    paramak = null;
                    if (!"invite".equals(localObject2)) {
                      break label1205;
                    }
                    i1 = 20;
                    qz.a(1, ((qz)localObject5).a(i1, paramak, (String)localObject3, paramal.e, (List)localObject1, null));
                    return true;
                    localNumberFormatException1 = localNumberFormatException1;
                    long l1 = 0L;
                    continue;
                    bool1 = false;
                    continue;
                    bool2 = false;
                  }
                  bool3 = false;
                }
              }
              localObject6 = paramak.b("subject");
              localObject1 = paramak.b("s_t");
              long l2 = 0L;
              try
              {
                long l3 = Long.parseLong((String)localObject1);
                l2 = 1000L * l3;
              }
              catch (NumberFormatException localNumberFormatException2)
              {
                Object localObject7;
                Object localObject5;
                boolean bool2;
                boolean bool3;
                Object localObject9;
                ContentValues localContentValues;
                int i1;
                String str;
                for (;;) {}
              }
              localObject1 = paramak.b("s_o");
              ??? = paramak.b("type");
              localObject7 = new HashMap();
              b(paramak, (Map)localObject7);
              localObject5 = this.g;
              Log.i("groupmgr/onGroupNewGroup/" + paramal + "/" + (String)localObject4 + "/" + l1 + "/" + (String)localObject6 + "/" + l2 + "/" + (String)localObject1 + "/" + (String)??? + "/" + (String)localObject2);
              Log.i("groupmgr/onGroupNewGroup/" + localObject7);
              if (!((qz)localObject5).f.a((String)localObject3))
              {
                bool1 = true;
                if ((!((qz)localObject5).e.a((String)localObject4)) || (!((qz)localObject5).e.a(paramal.e))) {
                  break label1086;
                }
                bool2 = true;
                if ((TextUtils.isEmpty(paramal.e)) || (((Map)localObject7).containsKey(paramal.e))) {
                  break label1092;
                }
                bool3 = true;
                Log.i("groupmgr/onGroupNewGroup/ new:" + bool1 + " mecreator:" + bool2 + " numberchange:" + bool3);
                if (!bool2) {
                  break label1104;
                }
                paramak = ((qz)localObject5).f((String)localObject6);
                if (((qz)localObject5).f.a(paramak))
                {
                  ((qz)localObject5).p.b.remove(paramak);
                  ((qz)localObject5).h.b(paramak, (String)localObject3);
                  qz.q.post(rc.a((qz)localObject5, (String)localObject3));
                  localObject1 = ((qz)localObject5).i;
                  ??? = ((qz)localObject5).i.d(paramak);
                  localObject9 = ((com.whatsapp.data.e)localObject1).b;
                  l1 = System.currentTimeMillis();
                  localContentValues = new ContentValues(3);
                  localContentValues.put("jid", (String)localObject3);
                  localContentValues.put("display_name", (String)localObject6);
                  localContentValues.put("phone_label", Long.toString(l2));
                  ((ct)localObject9).a(localContentValues, ((cs)???).t);
                  Log.i("updated temp group subject=" + (String)localObject6 + " creationTime=" + l2 + " oldJid=" + ((cs)???).t + " newJid=" + (String)localObject3 + " | time: " + (System.currentTimeMillis() - l1));
                  ((com.whatsapp.data.e)localObject1).f(((cs)???).t);
                  ((com.whatsapp.data.e)localObject1).f((String)localObject3);
                  ((com.whatsapp.data.e)localObject1).d((String)localObject3);
                  localObject9 = ((qz)localObject5).n;
                  Log.i("conversationsmgr/replacecontact:" + paramak + " -> " + (String)localObject3);
                }
              }
              for (;;)
              {
                boolean bool4;
                paramak = ((qz)localObject5).i.c((String)localObject3);
                if (paramak == null)
                {
                  ((qz)localObject5).i.a((String)localObject3, (String)localObject6, l2);
                }
                else
                {
                  ((qz)localObject5).k.a((String)localObject3, paramak.m, 2);
                  if (!paramak.a(com.whatsapp.u.a()).equals(localObject6))
                  {
                    Log.i("groupmgr/onGroupNewGroup/changed");
                    ((qz)localObject5).i.a((String)localObject3, (String)localObject6);
                    ((qz)localObject5).h.a((String)localObject3, (String)localObject6);
                    continue;
                    paramak = paramal;
                    continue;
                    i1 = 12;
                    continue;
                    if (!bool1) {
                      ((qz)localObject5).g.a(paramal);
                    }
                  }
                }
              }
              if (ak.b((ak)localObject2, "delete"))
              {
                this.g.a(paramal);
                return true;
              }
              if (!ak.b((ak)localObject2, "demote")) {
                break;
              }
              paramak = new ArrayList();
              b((ak)localObject2, paramak, "participant", "jid");
            } while (paramak.isEmpty());
            this.g.b(paramal, paramak);
            return true;
            if (!ak.b((ak)localObject2, "modify")) {
              break;
            }
            localObject3 = new ArrayList();
            b((ak)localObject2, (List)localObject3, "participant", "jid");
          } while (((List)localObject3).isEmpty());
          paramak = this.g;
          localObject2 = (String)((List)localObject3).get(0);
          Log.i("groupmgr/onGroupUserChangedNumber/" + paramal + "/oldjid:" + localNumberFormatException1 + "/newjid:" + (String)localObject2);
          localObject3 = paramal.a;
          Object localObject4 = paramak.i.e((String)localObject3);
          Object localObject6 = paramak.p.a((String)localObject3);
          localObject5 = ((rg)localObject6).a(localNumberFormatException1);
          ((rg)localObject6).b(localNumberFormatException1);
          if ((localObject5 != null) && (((rf)localObject5).b))
          {
            bool1 = true;
            ((rg)localObject6).a((String)localObject2, bool1, false);
            paramak.o.b((String)localObject3, Collections.singletonList(localNumberFormatException1));
            if ((localObject4 == null) || (!((rg)localObject6).b(paramak.e)) || (localObject5 == null))
            {
              localObject7 = new StringBuilder("groupmgr/onGroupUserChangedNumber/sendgetgroupinfo/");
              if (localObject4 != null) {
                break label1734;
              }
              bool1 = true;
              localObject7 = ((StringBuilder)localObject7).append(bool1).append("/");
              if (((rg)localObject6).b(paramak.e)) {
                break label1740;
              }
              bool1 = true;
              localObject6 = ((StringBuilder)localObject7).append(bool1).append("/");
              if (localObject5 != null) {
                break label1746;
              }
              bool1 = true;
              Log.i(bool1);
              paramak.g.d((String)localObject3, null);
              localObject5 = paramak.k;
              if (localObject4 != null) {
                break label1752;
              }
            }
          }
          for (i1 = 0;; i1 = ((cs)localObject4).m)
          {
            ((acm)localObject5).a((String)localObject3, i1, 2);
            paramak.g.a(paramak.a(new String[] { localObject2 }));
            localObject3 = paramak.d;
            localObject4 = new j(paramak.e, paramal.a, null);
            ((j)localObject4).d = 6;
            ((j)localObject4).t = 10L;
            ((j)localObject4).f = localNumberFormatException1;
            ((j)localObject4).N = localObject2;
            ((j)localObject4).n = ((ant)localObject3).b();
            qz.a(1, localObject4);
            paramak.g.a(paramal);
            return true;
            bool1 = false;
            break;
            bool1 = false;
            break label1531;
            bool1 = false;
            break label1561;
            bool1 = false;
            break label1584;
          }
          if (!ak.b((ak)localObject2, "promote")) {
            break;
          }
          paramak = new ArrayList();
          b((ak)localObject2, paramak, "participant", "jid");
        } while (paramak.isEmpty());
        this.g.a(paramal, paramak);
        return true;
        if (!ak.b((ak)localObject2, "remove")) {
          break;
        }
        paramak = ((ak)localObject2).b("subject");
        localObject3 = new ArrayList();
        b((ak)localObject2, (List)localObject3, "participant", "jid");
      } while (((List)localObject3).isEmpty());
      this.g.a(paramal, (List)localObject3, localNumberFormatException1, paramak);
      return true;
      if (ak.b((ak)localObject2, "subject"))
      {
        paramak = ((ak)localObject2).b("subject");
        str = ((ak)localObject2).b("s_t");
        localObject2 = ((ak)localObject2).b("s_o");
        this.g.a(paramal, paramak, (String)localObject2, Integer.parseInt(str));
        return true;
      }
    } while (!ak.b((ak)localObject2, "invite"));
    paramak = ((ak)localObject2).b("code");
    this.g.a(paramal, paramak);
    return true;
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (paramString.endsWith("broadcast")) && (!j.c(paramString));
  }
  
  public static z[] a(j.b paramb, String paramString1, j.c paramc, String paramString2, String paramString3, Integer paramInteger)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new z("to", paramString2));
    localArrayList.add(new z("id", paramb.c));
    if (paramString1 != null) {
      localArrayList.add(new z("type", paramString1));
    }
    if ((paramString3 != null) && (paramString3.length() > 0)) {
      localArrayList.add(new z("participant", paramString3));
    }
    if ((paramc != null) && (paramc.a())) {
      localArrayList.add(new z("web", paramc.b()));
    }
    if ((paramInteger != null) && (paramInteger.intValue() != 0)) {
      localArrayList.add(new z("edit", paramInteger.toString()));
    }
    return (z[])localArrayList.toArray(new z[localArrayList.size()]);
  }
  
  private static String[] a(String paramString, ak[] paramArrayOfak)
  {
    int i2 = 0;
    if ((paramArrayOfak == null) || (paramArrayOfak.length != 1)) {
      return new String[] { paramString };
    }
    paramArrayOfak = paramArrayOfak[0];
    ak.a(paramArrayOfak, "list");
    paramArrayOfak = paramArrayOfak.c;
    if (paramArrayOfak != null) {}
    String[] arrayOfString;
    for (int i1 = paramArrayOfak.length;; i1 = 0)
    {
      arrayOfString = new String[i1 + 1];
      arrayOfString[0] = paramString;
      while (i2 < i1)
      {
        paramString = paramArrayOfak[i2];
        ak.a(paramString, "item");
        arrayOfString[(i2 + 1)] = paramString.a("id", null);
        i2 += 1;
      }
    }
    return arrayOfString;
  }
  
  /* Error */
  private static h b(List<ak> paramList)
  {
    // Byte code:
    //   0: new 1646	com/whatsapp/protocol/h
    //   3: dup
    //   4: invokespecial 1647	com/whatsapp/protocol/h:<init>	()V
    //   7: astore_3
    //   8: aload_0
    //   9: ifnonnull +5 -> 14
    //   12: aload_3
    //   13: areturn
    //   14: aload_0
    //   15: invokeinterface 424 1 0
    //   20: anewarray 1209	[B
    //   23: astore 4
    //   25: aload_0
    //   26: invokeinterface 424 1 0
    //   31: newarray <illegal type>
    //   33: astore 5
    //   35: aload_0
    //   36: invokeinterface 424 1 0
    //   41: newarray <illegal type>
    //   43: astore 6
    //   45: iconst_0
    //   46: istore_1
    //   47: iload_1
    //   48: aload_0
    //   49: invokeinterface 424 1 0
    //   54: if_icmpge +140 -> 194
    //   57: aload_0
    //   58: iload_1
    //   59: invokeinterface 434 2 0
    //   64: checkcast 280	com/whatsapp/protocol/ak
    //   67: astore 8
    //   69: aload 4
    //   71: iload_1
    //   72: aload 8
    //   74: getfield 555	com/whatsapp/protocol/ak:d	[B
    //   77: aastore
    //   78: aload 8
    //   80: ldc_w 1649
    //   83: ldc_w 459
    //   86: invokevirtual 283	com/whatsapp/protocol/ak:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 7
    //   91: aload 5
    //   93: iload_1
    //   94: aload 7
    //   96: invokestatic 397	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   99: iastore
    //   100: aload 8
    //   102: ldc_w 1651
    //   105: ldc_w 459
    //   108: invokevirtual 283	com/whatsapp/protocol/ak:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   111: astore 7
    //   113: aload 7
    //   115: invokestatic 397	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   118: ifeq +44 -> 162
    //   121: iconst_1
    //   122: istore_2
    //   123: aload 6
    //   125: iload_1
    //   126: iload_2
    //   127: bastore
    //   128: iload_1
    //   129: iconst_1
    //   130: iadd
    //   131: istore_1
    //   132: goto -85 -> 47
    //   135: astore_0
    //   136: new 1215	com/whatsapp/protocol/c
    //   139: dup
    //   140: new 329	java/lang/StringBuilder
    //   143: dup
    //   144: ldc_w 1653
    //   147: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   150: aload 7
    //   152: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokespecial 1218	com/whatsapp/protocol/c:<init>	(Ljava/lang/String;)V
    //   161: athrow
    //   162: iconst_0
    //   163: istore_2
    //   164: goto -41 -> 123
    //   167: astore_0
    //   168: new 1215	com/whatsapp/protocol/c
    //   171: dup
    //   172: new 329	java/lang/StringBuilder
    //   175: dup
    //   176: ldc_w 1655
    //   179: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   182: aload 7
    //   184: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokespecial 1218	com/whatsapp/protocol/c:<init>	(Ljava/lang/String;)V
    //   193: athrow
    //   194: aload_3
    //   195: aload 4
    //   197: putfield 1656	com/whatsapp/protocol/h:a	[[B
    //   200: aload_3
    //   201: aload 5
    //   203: putfield 1657	com/whatsapp/protocol/h:b	[I
    //   206: aload_3
    //   207: aload 6
    //   209: putfield 1660	com/whatsapp/protocol/h:c	[Z
    //   212: aload_3
    //   213: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	paramList	List<ak>
    //   46	86	1	i1	int
    //   122	42	2	i2	int
    //   7	206	3	localh	h
    //   23	173	4	arrayOfByte	byte[][]
    //   33	169	5	arrayOfInt	int[]
    //   43	165	6	arrayOfBoolean	boolean[]
    //   89	94	7	str	String
    //   67	34	8	localak	ak
    // Exception table:
    //   from	to	target	type
    //   91	100	135	java/lang/NumberFormatException
    //   113	121	167	java/lang/NumberFormatException
  }
  
  static String b(String paramString)
  {
    return paramString + "@g.us";
  }
  
  private void b(ak paramak)
  {
    Object localObject1 = paramak.a("e", null);
    int i3;
    long l1;
    label48:
    Object localObject5;
    String str1;
    String str2;
    Object localObject9;
    al localal;
    int i1;
    Object localObject10;
    Object localObject12;
    if (localObject1 != null)
    {
      i3 = Integer.parseInt((String)localObject1);
      localObject1 = paramak.a("t", null);
      if (localObject1 == null) {
        break label249;
      }
      l1 = Long.parseLong((String)localObject1) * 1000L;
      localObject1 = paramak.a("from");
      localObject5 = paramak.a("id");
      str1 = paramak.a("platform", null);
      str2 = paramak.a("version", null);
      localObject9 = paramak.a();
      localal = new al();
      localal.a = ((String)localObject1);
      localal.b = "call";
      localal.c = ((String)localObject5);
      i1 = 0;
      if (!ak.b((ak)localObject9, "offer")) {
        break label1643;
      }
      localal.d = "offer";
      localObject10 = ((ak)localObject9).a("call-id");
      localObject12 = a((ak)localObject9, false);
      paramak = ((ak)localObject9).e("net");
      if (paramak == null) {
        break label5018;
      }
    }
    label249:
    label1631:
    label1637:
    label1643:
    label2138:
    label5018:
    for (int i4 = paramak.c("medium");; i4 = 3)
    {
      paramak = ((ak)localObject9).e("capability");
      int i5;
      if (paramak != null) {
        i5 = paramak.c("ver");
      }
      for (paramak = paramak.d;; paramak = null)
      {
        localObject1 = ((ak)localObject9).f("audio");
        if (((List)localObject1).isEmpty())
        {
          throw new c("no audio nodes present in received call offer");
          i3 = -1;
          break;
          l1 = -1L;
          break label48;
        }
        Object localObject11 = new String[((List)localObject1).size()];
        int[] arrayOfInt = new int[((List)localObject1).size()];
        i1 = 0;
        while (i1 < ((List)localObject1).size())
        {
          localObject5 = (ak)((List)localObject1).get(i1);
          localObject11[i1] = ((ak)localObject5).a("enc");
          localObject5 = ((ak)localObject5).a("rate");
          try
          {
            i2 = Integer.parseInt((String)localObject5);
            arrayOfInt[i1] = i2;
            i1 += 1;
          }
          catch (NumberFormatException paramak)
          {
            throw new c("invalid rate received on audio node in call offer: " + (String)localObject5);
          }
        }
        byte b1 = 0;
        int i2 = 0;
        i1 = 0;
        localObject5 = ((ak)localObject9).f("video");
        int i6;
        Object localObject6;
        if ((localObject5 != null) && (((List)localObject5).size() > 0))
        {
          localObject1 = new String[((List)localObject5).size()];
          i6 = 0;
          while (i6 < ((List)localObject5).size())
          {
            localObject6 = (ak)((List)localObject5).get(i6);
            localObject1[i6] = ((ak)localObject6).a("enc");
            b1 = (byte)((ak)localObject6).c("orientation");
            i2 = ((ak)localObject6).a("screen_width", 0);
            i1 = ((ak)localObject6).a("screen_height", 0);
            i6 += 1;
          }
        }
        for (;;)
        {
          localObject5 = ((ak)localObject9).e("relay");
          if (localObject5 == null) {
            throw new c("missing required relay element in call offer");
          }
          Object localObject13 = a((ak)localObject5, true);
          localObject5 = ((ak)localObject5).f("token");
          if (((List)localObject5).isEmpty()) {
            throw new c("missing required relay token element in call offer");
          }
          if ((((List)localObject5).size() != 1) && (((List)localObject5).size() != ((h)localObject13).a.length)) {
            throw new c("relay token element should appear 1 time or " + ((h)localObject13).a.length + " times, not " + ((List)localObject5).size() + " times");
          }
          byte[][] arrayOfByte = new byte[((List)localObject5).size()][];
          i6 = 0;
          while (i6 < ((List)localObject5).size())
          {
            arrayOfByte[i6] = ((ak)((List)localObject5).get(i6)).d;
            i6 += 1;
          }
          localObject5 = ((ak)localObject9).f("enc");
          i6 = 0;
          if (i6 < ((List)localObject5).size())
          {
            localObject6 = f.a((ak)((List)localObject5).get(i6));
            if (2 == ((f)localObject6).a) {
              localObject5 = ((ak)((List)localObject5).get(i6)).a("count", "0");
            }
          }
          for (;;)
          {
            Object localObject7;
            Object localObject8;
            byte b2;
            try
            {
              i6 = Integer.parseInt((String)localObject5);
              localObject5 = null;
              localObject7 = ((ak)localObject9).e("rte");
              if (localObject7 != null) {
                localObject5 = ((ak)localObject7).d;
              }
              if (((ak)localObject9).e("userrate") == null) {
                break label1631;
              }
              bool1 = true;
              if (((ak)localObject9).e("dontuploadfieldstat") != null) {
                break label1637;
              }
              bool2 = true;
              Object localObject14 = ((ak)localObject9).e("registration");
              localObject8 = null;
              localObject7 = localObject8;
              if (localObject14 != null)
              {
                localObject7 = localObject8;
                if (((ak)localObject14).d != null)
                {
                  localObject7 = localObject8;
                  if (((ak)localObject14).d.length == 4) {
                    localObject7 = ((ak)localObject14).d;
                  }
                }
              }
              b2 = 1;
              localObject8 = ((ak)localObject9).e("encopt");
              if (localObject8 != null) {
                b2 = (byte)((ak)localObject8).c("keygen");
              }
              Object localObject15 = this.c;
              localObject8 = ((h)localObject12).a;
              localObject14 = ((h)localObject12).b;
              localObject12 = ((h)localObject12).c;
              localObject13 = ((h)localObject13).a;
              localObject6 = f.a((f)localObject6);
              localObject9 = VoipOptions.fromProtocolTreeNode((ak)localObject9, false);
              Log.i("xmpp/reader/on-call-offer stanzaKey=" + localal + " callId=" + (String)localObject10 + " epochTimeMillis=" + l1 + " elapsedTime=" + i3 + " audioEncodings=" + Arrays.toString((Object[])localObject11) + " rates=" + Arrays.toString(arrayOfInt) + " videoEncoding=" + Arrays.toString((Object[])localObject1) + " videoOrientation=" + b1 + " endpoints=" + Arrays.deepToString((Object[])localObject8) + " endpointPriorities=" + Arrays.toString((int[])localObject14) + " endpointEnablePortPredicting=" + Arrays.toString((boolean[])localObject12) + " netMedium=" + i4 + " relayToken=" + Arrays.deepToString(arrayOfByte) + " relayEndpoints=" + Arrays.deepToString((Object[])localObject13) + " rte=" + Arrays.toString((byte[])localObject5) + " voipOptions=" + localObject9 + " userRate=" + bool1 + " uploadFieldStat=" + bool2 + " peerPlatform=" + str1 + " peerAppVersion=" + str2 + " retryCount=" + i6 + " serverReg=" + Arrays.toString((byte[])localObject7));
              localObject15 = ((aa)localObject15).a;
              Bundle localBundle = new Bundle();
              localBundle.putParcelable("stanzaKey", new ParcelableStanzaKey(localal));
              localBundle.putString("callId", (String)localObject10);
              localBundle.putLong("epochTimeMillis", l1);
              localBundle.putInt("elapsedTime", i3);
              localBundle.putStringArray("encodings", (String[])localObject11);
              localBundle.putIntArray("rates", arrayOfInt);
              localBundle.putSerializable("endpoints", (Serializable)localObject8);
              localBundle.putIntArray("endpointPriorities", (int[])localObject14);
              localBundle.putBooleanArray("endpointEnablePortPredicting", (boolean[])localObject12);
              localBundle.putInt("netMedium", i4);
              localBundle.putSerializable("relayTokens", arrayOfByte);
              localBundle.putSerializable("relayEndpoints", (Serializable)localObject13);
              localBundle.putByteArray("e2e", (byte[])localObject6);
              localBundle.putByte("e2eKeyGenVersion", b2);
              localBundle.putByteArray("rte", (byte[])localObject5);
              localBundle.putParcelable("voipOptions", new ParcelableVoipOptions((VoipOptions)localObject9));
              localBundle.putBoolean("userrate", bool1);
              localBundle.putBoolean("uploadfieldstat", bool2);
              localBundle.putString("peerPlatform", str1);
              localBundle.putString("peerAppVersion", str2);
              localBundle.putStringArray("videoEncoding", (String[])localObject1);
              localBundle.putByte("videoOrientation", b1);
              localBundle.putInt("retryCount", i6);
              localBundle.putInt("screenWidth", i2);
              localBundle.putInt("screenHeight", i1);
              localBundle.putByteArray("serverReg", (byte[])localObject7);
              localBundle.putInt("capabilityVer", i5);
              localBundle.putByteArray("capabilityBitMask", paramak);
              ((u.a)localObject15).a(Message.obtain(null, 0, 52, 0, localBundle));
              i1 = 1;
              if (i1 == 0) {
                a(localal);
              }
              return;
            }
            catch (NumberFormatException paramak)
            {
              throw new c("invalid retry count provided in call offer: " + (String)localObject5);
            }
            i6 += 1;
            break;
            boolean bool1 = false;
            continue;
            boolean bool2 = false;
            continue;
            if (ak.b((ak)localObject9, "relaylatency"))
            {
              i1 = 1;
              localal.d = "relaylatency";
              paramak = ((ak)localObject9).a("call-id");
              localObject5 = e((ak)localObject9);
              localObject6 = this.c;
              localObject1 = ((g)localObject5).a;
              localObject5 = ((g)localObject5).b;
              Log.i("xmpp/reader/on-call-relay-latency stanzaKey=" + localal + " callId=" + paramak + " epochTimeMillis=" + l1 + " endpoints=" + Arrays.deepToString((Object[])localObject1) + " latencies=" + Arrays.toString((int[])localObject5));
              localObject6 = ((aa)localObject6).a;
              localObject7 = new Bundle();
              ((Bundle)localObject7).putParcelable("stanzaKey", new ParcelableStanzaKey(localal));
              ((Bundle)localObject7).putString("callId", paramak);
              ((Bundle)localObject7).putLong("epochTimeMillis", l1);
              ((Bundle)localObject7).putSerializable("endpoints", (Serializable)localObject1);
              ((Bundle)localObject7).putIntArray("latencies", (int[])localObject5);
              ((u.a)localObject6).a(Message.obtain(null, 0, 65, 0, localObject7));
            }
            else
            {
              Object localObject2;
              if (ak.b((ak)localObject9, "accept"))
              {
                localal.d = "accept";
                localObject5 = ((ak)localObject9).a("call-id");
                paramak = ((ak)localObject9).e("audio");
                if (paramak == null) {
                  throw new c("missing required audio child of accept");
                }
                localObject6 = paramak.a("enc");
                paramak = paramak.a("rate");
                try
                {
                  i3 = Integer.parseInt(paramak);
                  paramak = null;
                  b1 = 0;
                  localObject1 = ((ak)localObject9).e("video");
                  if (localObject1 != null)
                  {
                    paramak = ((ak)localObject1).a("enc");
                    b1 = (byte)((ak)localObject1).c("orientation");
                  }
                  b2 = 1;
                  localObject1 = ((ak)localObject9).e("encopt");
                  if (localObject1 != null) {
                    b2 = (byte)((ak)localObject1).c("keygen");
                  }
                  localObject7 = a((ak)localObject9, false);
                  localObject1 = ((ak)localObject9).e("net");
                  i1 = 3;
                  if (localObject1 != null) {
                    i1 = ((ak)localObject1).c("medium");
                  }
                  localObject8 = ((ak)localObject9).e("relayelection");
                  i2 = 0;
                  localObject1 = null;
                  if (localObject8 == null) {
                    break label2138;
                  }
                  localObject1 = ((ak)localObject8).e("te");
                  if (localObject1 == null) {
                    throw new c("relay election node missing te element");
                  }
                }
                catch (NumberFormatException localNumberFormatException1)
                {
                  throw new c("rate attribute on call offer accept not a valid integer: " + paramak);
                }
                localObject8 = localNumberFormatException1.a("latency");
                try
                {
                  i2 = Integer.parseInt((String)localObject8);
                  localObject2 = localNumberFormatException1.d;
                  localObject10 = this.c;
                  localObject8 = ((h)localObject7).a;
                  localObject9 = ((h)localObject7).b;
                  localObject7 = ((h)localObject7).c;
                  Log.i("xmpp/reader/on-call-offer-accept stanzaKey=" + localal + " callId=" + (String)localObject5 + " epochTimeMillis=" + l1 + " audioEncoding=" + (String)localObject6 + " rate=" + i3 + " videoEncoding=" + paramak + " videoOrientation=" + b1 + " endpoints=" + Arrays.deepToString((Object[])localObject8) + " endpointPriorities=" + Arrays.toString((int[])localObject9) + " relayEndpoint=" + Arrays.toString((byte[])localObject2) + " relayLatency=" + i2 + " peerPlatform=" + str1 + " peerAppVersion=" + str2);
                  localObject10 = ((aa)localObject10).a;
                  localObject11 = new Bundle();
                  ((Bundle)localObject11).putParcelable("stanzaKey", new ParcelableStanzaKey(localal));
                  ((Bundle)localObject11).putString("callId", (String)localObject5);
                  ((Bundle)localObject11).putLong("epochTimeMillis", l1);
                  ((Bundle)localObject11).putString("encoding", (String)localObject6);
                  ((Bundle)localObject11).putInt("rate", i3);
                  ((Bundle)localObject11).putSerializable("endpoints", (Serializable)localObject8);
                  ((Bundle)localObject11).putIntArray("endpointPriorities", (int[])localObject9);
                  ((Bundle)localObject11).putBooleanArray("endpointEnablePortPredicting", (boolean[])localObject7);
                  ((Bundle)localObject11).putInt("netMedium", i1);
                  ((Bundle)localObject11).putByteArray("relayEndpoint", (byte[])localObject2);
                  ((Bundle)localObject11).putInt("relayLatency", i2);
                  ((Bundle)localObject11).putString("peerPlatform", str1);
                  ((Bundle)localObject11).putString("peerAppVersion", str2);
                  ((Bundle)localObject11).putString("videoEncoding", paramak);
                  ((Bundle)localObject11).putByte("videoOrientation", b1);
                  ((Bundle)localObject11).putByte("e2eKeyGenVersion", b2);
                  ((u.a)localObject10).a(Message.obtain(null, 0, 55, 0, localObject11));
                  i1 = 1;
                }
                catch (NumberFormatException paramak)
                {
                  throw new c("invalid latency");
                }
              }
              else if (ak.b((ak)localObject9, "preaccept"))
              {
                localal.d = "preaccept";
                localObject5 = ((ak)localObject9).a("call-id");
                paramak = ((ak)localObject9).e("audio");
                if (paramak == null) {
                  throw new c("missing required audio child of preaccept");
                }
                localObject6 = paramak.a("enc");
                paramak = paramak.a("rate");
                try
                {
                  i4 = Integer.parseInt(paramak);
                  paramak = null;
                  b1 = 0;
                  i2 = 0;
                  i1 = 0;
                  localObject2 = ((ak)localObject9).e("video");
                  if (localObject2 != null)
                  {
                    paramak = ((ak)localObject2).a("enc");
                    b1 = (byte)((ak)localObject2).c("orientation");
                    i2 = ((ak)localObject2).a("screen_width", 0);
                    i1 = ((ak)localObject2).a("screen_height", 0);
                  }
                  b2 = 1;
                  localObject2 = ((ak)localObject9).e("encopt");
                  if (localObject2 != null) {
                    b2 = (byte)((ak)localObject2).c("keygen");
                  }
                  i3 = -1;
                  localObject2 = null;
                  localObject7 = ((ak)localObject9).e("capability");
                  if (localObject7 != null)
                  {
                    i3 = ((ak)localObject7).c("ver");
                    localObject2 = ((ak)localObject7).d;
                  }
                  localObject7 = this.c;
                  Log.i("xmpp/reader/on-call-offer-pre-accept stanzaKey=" + localal + " callId=" + (String)localObject5 + " epochTimeMillis=" + l1 + " encoding=" + (String)localObject6 + " rate=" + i4 + " videoEncoding=" + paramak + " videoOrientation=" + b1);
                  localObject7 = ((aa)localObject7).a;
                  localObject8 = new Bundle();
                  ((Bundle)localObject8).putParcelable("stanzaKey", new ParcelableStanzaKey(localal));
                  ((Bundle)localObject8).putString("callId", (String)localObject5);
                  ((Bundle)localObject8).putLong("epochTimeMillis", l1);
                  ((Bundle)localObject8).putString("encoding", (String)localObject6);
                  ((Bundle)localObject8).putInt("rate", i4);
                  ((Bundle)localObject8).putString("videoEncoding", paramak);
                  ((Bundle)localObject8).putByte("videoOrientation", b1);
                  ((Bundle)localObject8).putInt("screenWidth", i2);
                  ((Bundle)localObject8).putInt("screenHeight", i1);
                  ((Bundle)localObject8).putByte("e2eKeyGenVersion", b2);
                  ((Bundle)localObject8).putInt("capabilityVer", i3);
                  ((Bundle)localObject8).putByteArray("capabilityBitMask", (byte[])localObject2);
                  ((u.a)localObject7).a(Message.obtain(null, 0, 102, 0, localObject8));
                  i1 = 1;
                }
                catch (NumberFormatException localNumberFormatException2)
                {
                  throw new c("rate attribute on call offer preaccept not a valid integer: " + paramak);
                }
              }
              else
              {
                Object localObject3;
                if (ak.b((ak)localObject9, "video"))
                {
                  i1 = 1;
                  localal.d = "video";
                  paramak = ((ak)localObject9).a("call-id");
                  b1 = (byte)((ak)localObject9).c("state");
                  b2 = (byte)((ak)localObject9).c("orientation");
                  localObject3 = ((ak)localObject9).b("enc");
                  localObject5 = this.c;
                  Log.i("xmpp/reader/on-call-video-changed stanzaKey=" + localal + " callId=" + paramak + " epochTimeMillis=" + l1 + " enabled=" + b1 + " videoOrientation=" + b2 + " codecType=" + (String)localObject3);
                  localObject5 = ((aa)localObject5).a;
                  localObject6 = new Bundle();
                  ((Bundle)localObject6).putParcelable("stanzaKey", new ParcelableStanzaKey(localal));
                  ((Bundle)localObject6).putString("callId", paramak);
                  ((Bundle)localObject6).putLong("epochTimeMillis", l1);
                  ((Bundle)localObject6).putByte("videoEnabled", b1);
                  ((Bundle)localObject6).putByte("videoOrientation", b2);
                  ((Bundle)localObject6).putString("codecType", (String)localObject3);
                  ((u.a)localObject5).a(Message.obtain(null, 0, 108, 0, localObject6));
                }
                else if (ak.b((ak)localObject9, "relayelection"))
                {
                  i1 = 1;
                  localal.d = "relayelection";
                  paramak = ((ak)localObject9).a("call-id");
                  localObject5 = e((ak)localObject9);
                  if ((((g)localObject5).a == null) || (((g)localObject5).a.length != 1) || (((g)localObject5).b == null) || (((g)localObject5).b.length != 1)) {
                    throw new c("there must only be one endpoint elected");
                  }
                  localObject6 = this.c;
                  localObject3 = localObject5.a[0];
                  i2 = localObject5.b[0];
                  Log.i("xmpp/reader/on-call-relay-election stanzaKey=" + localal + " callId=" + paramak + " epochTimeMillis=" + l1 + " endpoint=" + Arrays.toString((byte[])localObject3) + " latenciy=" + i2);
                  localObject5 = ((aa)localObject6).a;
                  localObject6 = new Bundle();
                  ((Bundle)localObject6).putParcelable("stanzaKey", new ParcelableStanzaKey(localal));
                  ((Bundle)localObject6).putString("callId", paramak);
                  ((Bundle)localObject6).putLong("epochTimeMillis", l1);
                  ((Bundle)localObject6).putByteArray("endpoint", (byte[])localObject3);
                  ((Bundle)localObject6).putInt("latency", i2);
                  ((u.a)localObject5).a(Message.obtain(null, 0, 67, 0, localObject6));
                }
                else if (ak.b((ak)localObject9, "reject"))
                {
                  localal.d = "reject";
                  localObject3 = ((ak)localObject9).a("call-id");
                  localObject5 = ((ak)localObject9).b("reason");
                  paramak = ((ak)localObject9).b("count");
                  i2 = 0;
                  i1 = i2;
                  if (paramak != null)
                  {
                    i1 = i2;
                    if (paramak.length() <= 0) {}
                  }
                  for (;;)
                  {
                    try
                    {
                      i1 = Integer.parseInt(paramak);
                      paramak = ((ak)localObject9).e("registration");
                      if (paramak == null)
                      {
                        paramak = null;
                        if ((paramak == null) || (paramak.length == 4)) {
                          break;
                        }
                        throw new c("invalid registration node");
                      }
                    }
                    catch (NumberFormatException localNumberFormatException3)
                    {
                      throw new c("invalid retry count provided: " + paramak);
                    }
                    paramak = paramak.d;
                  }
                  localObject6 = this.c;
                  Log.i("xmpp/reader/on-call-offer-reject stanzaKey=" + localal + " callId=" + localNumberFormatException3 + " epochTimeMillis=" + l1 + " reason=" + (String)localObject5 + " registration=" + Arrays.toString(paramak) + " retryCount=" + i1);
                  localObject6 = ((aa)localObject6).a;
                  localObject7 = new Bundle();
                  ((Bundle)localObject7).putParcelable("stanzaKey", new ParcelableStanzaKey(localal));
                  ((Bundle)localObject7).putString("callId", localNumberFormatException3);
                  ((Bundle)localObject7).putLong("epochTimeMillis", l1);
                  ((Bundle)localObject7).putString("reason", (String)localObject5);
                  ((Bundle)localObject7).putByteArray("registration", paramak);
                  ((Bundle)localObject7).putInt("retryCount", i1);
                  ((u.a)localObject6).a(Message.obtain(null, 0, 58, 0, localObject7));
                  i1 = 1;
                }
                else if (ak.b((ak)localObject9, "terminate"))
                {
                  i1 = 1;
                  localal.d = "terminate";
                  paramak = ((ak)localObject9).a("call-id");
                  localObject4 = ((ak)localObject9).b("reason");
                  long l2 = ((ak)localObject9).b("duration", -1);
                  localObject5 = this.c;
                  Log.i("xmpp/reader/on-call-terminate stanzaKey=" + localal + " callId=" + paramak + " epochTimeMillis=" + l1 + " reason=" + (String)localObject4 + " duration=" + l2);
                  localObject5 = ((aa)localObject5).a;
                  localObject6 = new Bundle();
                  ((Bundle)localObject6).putParcelable("stanzaKey", new ParcelableStanzaKey(localal));
                  ((Bundle)localObject6).putString("callId", paramak);
                  ((Bundle)localObject6).putLong("epochTimeMillis", l1);
                  ((Bundle)localObject6).putString("reason", (String)localObject4);
                  ((Bundle)localObject6).putLong("duration", l2);
                  ((u.a)localObject5).a(Message.obtain(null, 0, 61, 0, localObject6));
                }
                else if (ak.b((ak)localObject9, "transport"))
                {
                  localal.d = "transport";
                  localObject4 = ((ak)localObject9).a("call-id");
                  localObject5 = a((ak)localObject9, true);
                  paramak = ((ak)localObject9).e("net");
                  i1 = 3;
                  if (paramak != null) {
                    i1 = paramak.c("medium");
                  }
                  i2 = -1;
                  paramak = null;
                  localObject6 = ((ak)localObject9).e("capability");
                  if (localObject6 != null)
                  {
                    i2 = ((ak)localObject6).c("ver");
                    paramak = ((ak)localObject6).d;
                  }
                  localObject8 = this.c;
                  localObject6 = ((h)localObject5).a;
                  localObject7 = ((h)localObject5).b;
                  localObject5 = ((h)localObject5).c;
                  Log.i("xmpp/reader/on-call-transport stanzaKey=" + localal + " callId=" + (String)localObject4 + " epochTimeMillis=" + l1 + " endpoints=" + Arrays.deepToString((Object[])localObject6) + " endpointPriorities=" + Arrays.toString((int[])localObject7) + " endpointEnablePortPredicting=" + Arrays.toString((boolean[])localObject5) + " netMedium=" + i1);
                  localObject8 = ((aa)localObject8).a;
                  localObject9 = new Bundle();
                  ((Bundle)localObject9).putParcelable("stanzaKey", new ParcelableStanzaKey(localal));
                  ((Bundle)localObject9).putString("callId", (String)localObject4);
                  ((Bundle)localObject9).putLong("epochTimeMillis", l1);
                  ((Bundle)localObject9).putSerializable("endpoints", (Serializable)localObject6);
                  ((Bundle)localObject9).putIntArray("endpointPriorities", (int[])localObject7);
                  ((Bundle)localObject9).putBooleanArray("endpointEnablePortPredicting", (boolean[])localObject5);
                  ((Bundle)localObject9).putInt("netMedium", i1);
                  ((Bundle)localObject9).putInt("capabilityVer", i2);
                  ((Bundle)localObject9).putByteArray("capabilityBitMask", paramak);
                  ((u.a)localObject8).a(Message.obtain(null, 0, 63, 0, localObject9));
                  i1 = 1;
                }
                else if (ak.b((ak)localObject9, "interruption"))
                {
                  i1 = 1;
                  localal.d = "interruption";
                  paramak = ((ak)localObject9).a("call-id");
                  localObject4 = ((ak)localObject9).a("state");
                  localObject5 = this.c;
                  bool1 = "end".equals(localObject4);
                  Log.i("xmpp/reader/on-call-interruption stanzaKey=" + localal + " callId=" + paramak + " epochTimeMillis=" + l1 + " end=" + bool1);
                  localObject4 = ((aa)localObject5).a;
                  localObject5 = new Bundle();
                  ((Bundle)localObject5).putParcelable("stanzaKey", new ParcelableStanzaKey(localal));
                  ((Bundle)localObject5).putString("callId", paramak);
                  ((Bundle)localObject5).putLong("epochTimeMillis", l1);
                  ((Bundle)localObject5).putBoolean("end", bool1);
                  ((u.a)localObject4).a(Message.obtain(null, 0, 77, 0, localObject5));
                }
                else if (ak.b((ak)localObject9, "mute"))
                {
                  i1 = 1;
                  localal.d = "mute";
                  paramak = ((ak)localObject9).a("call-id");
                  localObject4 = ((ak)localObject9).a("state");
                  localObject5 = this.c;
                  bool1 = "end".equals(localObject4);
                  Log.i("xmpp/reader/on-call-mute stanzaKey=" + localal + " callId=" + paramak + " epochTimeMillis=" + l1 + " end=" + bool1);
                  localObject4 = ((aa)localObject5).a;
                  localObject5 = new Bundle();
                  ((Bundle)localObject5).putParcelable("stanzaKey", new ParcelableStanzaKey(localal));
                  ((Bundle)localObject5).putString("callId", paramak);
                  ((Bundle)localObject5).putLong("epochTimeMillis", l1);
                  ((Bundle)localObject5).putBoolean("end", bool1);
                  ((u.a)localObject4).a(Message.obtain(null, 0, 79, 0, localObject5));
                }
                else if (ak.b((ak)localObject9, "notify"))
                {
                  i1 = 1;
                  localal.d = "notify";
                  paramak = ((ak)localObject9).a("call-id");
                  i2 = ((ak)localObject9).c("batterystate");
                  localObject4 = this.c;
                  Log.i("xmpp/reader/on-call-notify-message stanzaKey=" + localal + " callId=" + paramak + " batteryState=" + i2);
                  localObject4 = ((aa)localObject4).a;
                  localObject5 = new Bundle();
                  ((Bundle)localObject5).putParcelable("stanzaKey", new ParcelableStanzaKey(localal));
                  ((Bundle)localObject5).putString("callId", paramak);
                  ((Bundle)localObject5).putInt("batteryState", i2);
                  ((u.a)localObject4).a(Message.obtain(null, 0, 121, 0, localObject5));
                  continue;
                  i6 = 0;
                  localObject6 = null;
                }
              }
            }
          }
          b1 = 0;
          i1 = 0;
          Object localObject4 = null;
          i2 = 0;
        }
        i5 = -1;
      }
    }
  }
  
  private static void b(ak paramak, List<String> paramList, String paramString1, String paramString2)
  {
    paramak = paramak.f(paramString1).iterator();
    while (paramak.hasNext()) {
      paramList.add(((ak)paramak.next()).a(paramString2, null));
    }
  }
  
  private static void b(ak paramak, Map<String, String> paramMap)
  {
    paramak = paramak.f("participant").iterator();
    while (paramak.hasNext())
    {
      ak localak = (ak)paramak.next();
      paramMap.put(localak.a("jid", null), localak.a("type", ""));
    }
  }
  
  private void c(ak paramak)
  {
    long l1 = 0L;
    int i3 = 1;
    Object localObject2 = paramak.a("from", null);
    Object localObject1 = paramak.a("id", null);
    Object localObject3 = paramak.a("type", "delivery");
    Object localObject4 = paramak.a("participant", null);
    String str = paramak.a("edit", null);
    al localal = new al();
    localal.a = ((String)localObject2);
    localal.b = "receipt";
    localal.c = ((String)localObject1);
    localal.d = ((String)localObject3);
    localal.e = ((String)localObject4);
    localal.f = str;
    boolean bool;
    if ("delivery".equals(localObject3))
    {
      localObject3 = paramak.a();
      if (ak.b((ak)localObject3, "offer"))
      {
        paramak = ((ak)localObject3).e("client");
        if (paramak == null) {
          break label1355;
        }
        if (paramak.a("callee_bad_asn", 0) != 0) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      localObject4 = this.c;
      paramak = ((ak)localObject3).a("call-id");
      Log.i("xmpp/reader/on-call-offer-receipt from=" + (String)localObject2 + " id=" + (String)localObject1 + " callId=" + paramak + " calleeBadASN=" + bool);
      localObject3 = ((aa)localObject4).a;
      localObject4 = new Bundle();
      ((Bundle)localObject4).putString("from", (String)localObject2);
      ((Bundle)localObject4).putString("id", (String)localObject1);
      ((Bundle)localObject4).putString("callId", paramak);
      ((Bundle)localObject4).putBoolean("calleeBadASN", bool);
      ((u.a)localObject3).a(Message.obtain(null, 0, 54, 0, localObject4));
      int i1 = 0;
      for (;;)
      {
        if (i1 == 0) {
          a(localal);
        }
        return;
        bool = false;
        break;
        if (ak.b((ak)localObject3, "accept"))
        {
          localObject4 = this.c;
          paramak = ((ak)localObject3).a("call-id");
          Log.i("xmpp/reader/on-call-offer-accept-receipt from=" + (String)localObject2 + " id=" + (String)localObject1 + " callId=" + paramak);
          localObject3 = ((aa)localObject4).a;
          localObject4 = new Bundle();
          ((Bundle)localObject4).putString("from", (String)localObject2);
          ((Bundle)localObject4).putString("id", (String)localObject1);
          ((Bundle)localObject4).putString("callId", paramak);
          ((u.a)localObject3).a(Message.obtain(null, 0, 57, 0, localObject4));
          i1 = 0;
        }
        else if (ak.b((ak)localObject3, "reject"))
        {
          localObject4 = this.c;
          paramak = ((ak)localObject3).a("call-id");
          Log.i("xmpp/reader/on-call-offer-reject-receipt from=" + (String)localObject2 + " id=" + (String)localObject1 + " callId=" + paramak);
          localObject3 = ((aa)localObject4).a;
          localObject4 = new Bundle();
          ((Bundle)localObject4).putString("from", (String)localObject2);
          ((Bundle)localObject4).putString("id", (String)localObject1);
          ((Bundle)localObject4).putString("callId", paramak);
          ((u.a)localObject3).a(Message.obtain(null, 0, 60, 0, localObject4));
          i1 = 0;
        }
        else
        {
          localObject1 = a((String)localObject1, paramak.c);
          paramak = paramak.a("t", null);
          if (paramak == null) {}
          for (;;)
          {
            l1 *= 1000L;
            label626:
            this.c.a(localal, (String[])localObject1, 5, l1);
            i1 = i3;
            break;
            long l2;
            try
            {
              l2 = Long.parseLong(paramak);
              l1 = l2;
            }
            catch (NumberFormatException paramak) {}
          }
          if ("played".equals(localObject3))
          {
            localObject1 = a((String)localObject1, paramak.c);
            paramak = paramak.a("t", null);
            if (paramak != null) {}
          }
          for (;;)
          {
            l1 *= 1000L;
            label702:
            this.c.a(localal, (String[])localObject1, 8, l1);
            i1 = i3;
            break;
            try
            {
              l2 = Long.parseLong(paramak);
              l1 = l2;
            }
            catch (NumberFormatException paramak) {}
          }
          if ("read".equals(localObject3))
          {
            localObject1 = a((String)localObject1, paramak.c);
            paramak = paramak.a("t", null);
            if (paramak == null) {
              l1 *= 1000L;
            }
          }
          for (;;)
          {
            this.c.a(localal, (String[])localObject1, 13, l1);
            i1 = i3;
            break;
            try
            {
              l2 = Long.parseLong(paramak);
              l1 = l2;
            }
            catch (NumberFormatException paramak) {}
            if ("server-error".equals(localObject3))
            {
              paramak = a((String)localObject1, paramak.c);
              this.c.a(localal, paramak);
              i1 = i3;
              break;
            }
            if ("retry".equals(localObject3))
            {
              localObject1 = ak.a(paramak.e("retry"));
              paramak = ak.a(paramak.e("registration")).d;
              if ((paramak == null) || (paramak.length != 4)) {
                throw new c("invalid registration node");
              }
              if (!"1".equals(((ak)localObject1).a("v", "1"))) {
                break label1350;
              }
              localObject2 = ((ak)localObject1).a("count", "1");
              try
              {
                i1 = Integer.parseInt((String)localObject2);
                localObject2 = ((ak)localObject1).a("t");
              }
              catch (NumberFormatException paramak)
              {
                try
                {
                  l1 = Long.parseLong((String)localObject2);
                  localObject2 = ((ak)localObject1).a("id");
                  localObject2 = new j.b(localal.a, true, (String)localObject2);
                  bool = "retry".equals(((ak)localObject1).b("mediareason"));
                  localObject1 = this.c;
                  Log.i("xmpp/reader/on-message-retry-by-target");
                  ((aa)localObject1).a.a(Message.obtain(null, 0, 2, 0, new bo(localal, (j.b)localObject2, paramak, i1, l1 * 1000L, bool)));
                  i1 = i3;
                }
                catch (NumberFormatException paramak)
                {
                  throw new c("invalid timestamp on retry receipt: " + (String)localObject2);
                }
                paramak = paramak;
                throw new c("invalid count on retry receipt: " + (String)localObject2);
              }
            }
            if (!"error".equals(localObject3)) {
              break label1350;
            }
            localObject2 = ak.a(paramak.e("error"));
            if (!"enc-v2-unknown-tags".equals(((ak)localObject2).a("type"))) {
              break label1350;
            }
            if (((ak)localObject2).c == null)
            {
              i1 = 0;
              if (i1 <= 0) {
                break label1215;
              }
            }
            int i2;
            label1215:
            for (paramak = new int[i1];; paramak = null)
            {
              i2 = 0;
              while (i2 < i1) {
                try
                {
                  paramak[i2] = Integer.parseInt(localObject2.c[i2].b());
                  i2 += 1;
                }
                catch (NumberFormatException paramak)
                {
                  throw new c("invalid tag number: " + localObject2.c[i2].b());
                }
              }
              i1 = ((ak)localObject2).c.length;
              break;
            }
            localObject2 = this.c;
            localObject1 = new j.b(localal.a, true, (String)localObject1);
            Log.i("xmpp/reader/on-message-enc-v2-unknown-tags-receipt");
            localObject2 = ((aa)localObject2).a;
            localObject1 = Message.obtain(null, 0, 5, 0, new bc(localal, (j.b)localObject1));
            ((Message)localObject1).getData().putIntArray("unknownTags", paramak);
            ((u.a)localObject2).a((Message)localObject1);
            i1 = i3;
            break;
            break label626;
            break label702;
          }
          label1350:
          i1 = 0;
        }
      }
      label1355:
      bool = false;
    }
  }
  
  private void d(ak paramak)
  {
    al localal = new al();
    localal.a = paramak.a("from", null);
    localal.e = paramak.a("participant", null);
    localal.c = paramak.a("id", null);
    localal.b = paramak.a("class", null);
    localal.d = paramak.a("type", null);
    localal.f = paramak.a("edit", null);
    Object localObject1;
    Object localObject3;
    Object localObject4;
    Object localObject2;
    int i2;
    int i1;
    if ("message".equals(localal.b))
    {
      localObject1 = new j.b(localal.a, true, localal.c);
      localObject3 = paramak.a("error", null);
      localObject4 = paramak.a("count", null);
      localObject2 = paramak.a("phash", null);
      i2 = 0;
      i1 = i2;
      if (localObject4 == null) {}
    }
    label190:
    label432:
    label717:
    label1228:
    boolean bool1;
    boolean bool2;
    try
    {
      i1 = Integer.parseInt((String)localObject4);
      paramak = paramak.a("t", null);
      long l1;
      if (paramak == null)
      {
        l1 = 0L;
        l1 *= 1000L;
        if (localObject3 != null) {
          break label432;
        }
        localObject3 = this.c;
        paramak = localal.e;
        Log.i("xmpp/reader/read/message-received-by-server; key=" + localObject1 + "; participant=" + paramak + "; serverParticipantHash=" + (String)localObject2 + "; recipientCount=" + i1 + "; timestamp=" + l1);
        localObject3 = ((aa)localObject3).a;
        localObject4 = Message.obtain(null, 0, 22, 0);
        ((Message)localObject4).getData().putString("msgid", ((j.b)localObject1).c);
        ((Message)localObject4).getData().putString("remote_jid", ((j.b)localObject1).a);
        ((Message)localObject4).getData().putString("participant", paramak);
        ((Message)localObject4).getData().putString("serverParticipantHash", (String)localObject2);
        ((Message)localObject4).getData().putInt("count", i1);
        ((Message)localObject4).getData().putLong("timestamp", l1);
        ((u.a)localObject3).a((Message)localObject4);
      }
      for (;;)
      {
        paramak = this.c;
        Log.i("xmpp/reader/on-ack; stanzaKey=" + localal);
        paramak.a.a(localal);
        return;
        try
        {
          l1 = Long.parseLong(paramak);
        }
        catch (NumberFormatException paramak)
        {
          l1 = 0L;
        }
        break label190;
        i1 = 0;
        try
        {
          i2 = Integer.parseInt((String)localObject3);
          i1 = i2;
        }
        catch (NumberFormatException paramak)
        {
          Object localObject6;
          for (;;) {}
        }
        paramak = this.c;
        localObject3 = localal.e;
        Log.i("xmpp/reader/read/message-error; key=" + localObject1 + "; participant=" + (String)localObject3 + "; code=" + i1 + "; phash=" + (String)localObject2);
        paramak.a.a(Message.obtain(null, 0, 19, 0, new bl((j.b)localObject1, (String)localObject3, i1, (String)localObject2)));
        continue;
        if ("receipt".equals(localal.b))
        {
          if (("played".equals(localal.d)) || ("server-error".equals(localal.d)) || ("read".equals(localal.d)))
          {
            if (a(localal.a)) {}
            for (paramak = new j.b(localal.e, false, localal.c);; paramak = new j.b(localal.a, false, localal.c))
            {
              if (!"played".equals(localal.d)) {
                break label717;
              }
              localObject1 = this.c;
              Log.i("xmpp/reader/read/playback-received-by-server " + paramak);
              ((aa)localObject1).a.a(a.a.a.a.d.a(new ba(paramak, null, 10, 0L)));
              break;
            }
            if ("server-error".equals(localal.d))
            {
              localObject1 = this.c;
              Log.i("xmpp/reader/read/server-error-received-by-server " + paramak);
              ((aa)localObject1).a.a(a.a.a.a.d.a(new ba(paramak, null, 12, 0L)));
            }
            else if ("read".equals(localal.d))
            {
              localObject1 = this.c;
              localObject2 = localal.e;
              Log.i("xmpp/reader/read/read-receipt-received-by-server " + paramak + " " + (String)localObject2);
              localObject1 = ((aa)localObject1).a;
              localObject2 = new Bundle();
              ((Bundle)localObject2).putString("msgid", paramak.c);
              ((Bundle)localObject2).putString("remote_jid", paramak.a);
              ((u.a)localObject1).a(Message.obtain(null, 0, 93, 0, localObject2));
            }
          }
        }
        else if ("call".equals(localal.b)) {
          if ("transport".equals(localal.d))
          {
            localObject2 = this.c;
            paramak = localal.a;
            localObject1 = localal.c;
            Log.i("xmpp/reader/on-call-transport-ack from=" + paramak + " id=" + (String)localObject1);
            localObject2 = ((aa)localObject2).a;
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("from", paramak);
            ((Bundle)localObject3).putString("id", (String)localObject1);
            ((u.a)localObject2).a(Message.obtain(null, 0, 64, 0, localObject3));
          }
          else
          {
            if ("offer".equals(localal.d))
            {
              for (;;)
              {
                try
                {
                  localObject1 = paramak.a("error", null);
                  if (localObject1 == null) {
                    break label1228;
                  }
                  localObject4 = this.c;
                }
                catch (c paramak)
                {
                  try
                  {
                    i1 = Integer.parseInt((String)localObject1);
                    localObject3 = paramak.e("relay");
                    if (localObject3 != null) {
                      break;
                    }
                    throw new c("missing required relay child element in call offer ack");
                  }
                  catch (NumberFormatException paramak)
                  {
                    throw new c("error code was set, but not an integer in call offer ack");
                  }
                  paramak = paramak;
                  localObject1 = null;
                }
                localObject2 = localal.a;
                localObject3 = localal.c;
                Log.i("xmpp/reader/on-call-offer-ack-corrupt from=" + (String)localObject2 + " id=" + (String)localObject3 + " callId=" + (String)localObject1);
                localObject4 = ((aa)localObject4).a;
                localObject6 = new Bundle();
                ((Bundle)localObject6).putString("from", (String)localObject2);
                ((Bundle)localObject6).putString("id", (String)localObject3);
                ((Bundle)localObject6).putString("callId", (String)localObject1);
                ((u.a)localObject4).a(Message.obtain(null, 0, 103, 0, localObject6));
                throw paramak;
                i1 = 0;
              }
              localObject6 = ((ak)localObject3).a("call-id");
              localObject1 = null;
              if (i1 == 0) {}
              for (;;)
              {
                try
                {
                  localObject2 = a((ak)localObject3, true).a;
                  localObject4 = ((ak)localObject3).f("token");
                  if (((List)localObject4).isEmpty()) {
                    throw new c("missing required token child element in call offer ack");
                  }
                  if ((((List)localObject4).size() != 1) && (((List)localObject4).size() != localObject2.length)) {
                    throw new c("token should appear 1 time or " + localObject2.length + " times, not " + ((List)localObject4).size() + " times");
                  }
                  localObject3 = new byte[((List)localObject4).size()][];
                  i2 = 0;
                  if (i2 < ((List)localObject4).size())
                  {
                    localObject3[i2] = ((ak)((List)localObject4).get(i2)).d;
                    i2 += 1;
                    continue;
                  }
                  localObject4 = paramak.e("rte");
                  if (localObject4 != null) {
                    localObject1 = ((ak)localObject4).d;
                  }
                  localObject4 = VoipOptions.fromProtocolTreeNode(paramak, true);
                  if (paramak.e("userrate") == null) {
                    break label2797;
                  }
                  bool1 = true;
                  if (paramak.e("dontuploadfieldstat") != null) {
                    break label2803;
                  }
                  bool2 = true;
                }
                catch (c paramak)
                {
                  label1484:
                  Object localObject7;
                  String str;
                  Bundle localBundle;
                  localObject1 = localObject6;
                }
                localObject7 = this.c;
                localObject4 = localal.a;
                str = localal.c;
                Log.i("xmpp/reader/read/on-call-offer-ack from=" + (String)localObject4 + " id=" + str + " callId=" + (String)localObject6 + " error= " + i1 + " relayToken=" + Arrays.deepToString((Object[])localObject2) + " relayEndpoints=" + Arrays.deepToString((Object[])localObject1) + " rte=" + Arrays.toString((byte[])localObject3) + " voipOptions=" + paramak + " userRate=" + bool1 + " uploadFieldStat=" + bool2);
                localObject7 = ((aa)localObject7).a;
                localBundle = new Bundle();
                localBundle.putString("from", (String)localObject4);
                localBundle.putString("id", str);
                localBundle.putString("callId", (String)localObject6);
                localBundle.putInt("error", i1);
                localBundle.putByteArray("rte", (byte[])localObject3);
                localBundle.putSerializable("relayTokens", (Serializable)localObject2);
                localBundle.putSerializable("relayEndpoints", (Serializable)localObject1);
                localBundle.putParcelable("voipOptions", new ParcelableVoipOptions(paramak));
                localBundle.putBoolean("userrate", bool1);
                localBundle.putBoolean("uploadfieldstat", bool2);
                ((u.a)localObject7).a(Message.obtain(null, 0, 53, 0, localBundle));
                break;
                localObject2 = new byte[0][];
                localObject1 = new byte[0][];
                paramak = new VoipOptions();
                bool1 = false;
                bool2 = false;
                localObject3 = null;
              }
            }
            if ("accept".equals(localal.d))
            {
              localObject2 = this.c;
              paramak = localal.a;
              localObject1 = localal.c;
              Log.i("xmpp/reader/on-call-offer-accept-ack from=" + paramak + " id=" + (String)localObject1);
              localObject2 = ((aa)localObject2).a;
              localObject3 = new Bundle();
              ((Bundle)localObject3).putString("from", paramak);
              ((Bundle)localObject3).putString("id", (String)localObject1);
              ((u.a)localObject2).a(Message.obtain(null, 0, 56, 0, localObject3));
            }
            else if ("preaccept".equals(localal.d))
            {
              localObject2 = this.c;
              paramak = localal.a;
              localObject1 = localal.c;
              Log.i("xmpp/reader/on-call-offer-preaccept-ack from=" + paramak + " id=" + (String)localObject1);
              localObject2 = ((aa)localObject2).a;
              localObject3 = new Bundle();
              ((Bundle)localObject3).putString("from", paramak);
              ((Bundle)localObject3).putString("id", (String)localObject1);
              ((u.a)localObject2).a(Message.obtain(null, 0, 101, 0, localObject3));
            }
            else if ("reject".equals(localal.d))
            {
              localObject2 = this.c;
              paramak = localal.a;
              localObject1 = localal.c;
              Log.i("xmpp/reader/on-call-offer-reject-ack from=" + paramak + " id=" + (String)localObject1);
              localObject2 = ((aa)localObject2).a;
              localObject3 = new Bundle();
              ((Bundle)localObject3).putString("from", paramak);
              ((Bundle)localObject3).putString("id", (String)localObject1);
              ((u.a)localObject2).a(Message.obtain(null, 0, 59, 0, localObject3));
            }
            else if ("terminate".equals(localal.d))
            {
              localObject2 = this.c;
              paramak = localal.a;
              localObject1 = localal.c;
              Log.i("xmpp/reader/on-call-terminate-ack from=" + paramak + " id=" + (String)localObject1);
              localObject2 = ((aa)localObject2).a;
              localObject3 = new Bundle();
              ((Bundle)localObject3).putString("from", paramak);
              ((Bundle)localObject3).putString("id", (String)localObject1);
              ((u.a)localObject2).a(Message.obtain(null, 0, 62, 0, localObject3));
            }
            else if ("relaylatency".equals(localal.d))
            {
              localObject2 = this.c;
              paramak = localal.a;
              localObject1 = localal.c;
              Log.i("xmpp/reader/on-call-relay-latency-ack from=" + paramak + " id=" + (String)localObject1);
              localObject2 = ((aa)localObject2).a;
              localObject3 = new Bundle();
              ((Bundle)localObject3).putString("from", paramak);
              ((Bundle)localObject3).putString("id", (String)localObject1);
              ((u.a)localObject2).a(Message.obtain(null, 0, 66, 0, localObject3));
            }
            else if ("relayelection".equals(localal.d))
            {
              localObject2 = this.c;
              paramak = localal.a;
              localObject1 = localal.c;
              Log.i("xmpp/reader/on-call-relay-election-ack from=" + paramak + " id=" + (String)localObject1);
              localObject2 = ((aa)localObject2).a;
              localObject3 = new Bundle();
              ((Bundle)localObject3).putString("from", paramak);
              ((Bundle)localObject3).putString("id", (String)localObject1);
              ((u.a)localObject2).a(Message.obtain(null, 0, 68, 0, localObject3));
            }
            else if ("interruption".equals(localal.d))
            {
              localObject2 = this.c;
              paramak = localal.a;
              localObject1 = localal.c;
              Log.i("xmpp/reader/on-call-interruption-ack from=" + paramak + " id=" + (String)localObject1);
              localObject2 = ((aa)localObject2).a;
              localObject3 = new Bundle();
              ((Bundle)localObject3).putString("from", paramak);
              ((Bundle)localObject3).putString("id", (String)localObject1);
              ((u.a)localObject2).a(Message.obtain(null, 0, 78, 0, localObject3));
            }
            else if ("mute".equals(localal.d))
            {
              localObject2 = this.c;
              paramak = localal.a;
              localObject1 = localal.c;
              Log.i("xmpp/reader/on-call-mute-ack from=" + paramak + " id=" + (String)localObject1);
              localObject2 = ((aa)localObject2).a;
              localObject3 = new Bundle();
              ((Bundle)localObject3).putString("from", paramak);
              ((Bundle)localObject3).putString("id", (String)localObject1);
              ((u.a)localObject2).a(Message.obtain(null, 0, 80, 0, localObject3));
            }
          }
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        i1 = i2;
      }
    }
    for (;;)
    {
      paramak = localNumberFormatException;
      Object localObject5 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      localObject3 = localObject5;
      break label1484;
      label2797:
      bool1 = false;
      break;
      label2803:
      bool2 = false;
    }
  }
  
  private static g e(ak paramak)
  {
    List localList = paramak.f("te");
    if (localList.isEmpty()) {
      throw new c("no te elements on node: " + paramak.a);
    }
    return a(localList);
  }
  
  private void e()
  {
    Iterator localIterator = this.o.values().iterator();
    if (localIterator.hasNext())
    {
      ak localak = (ak)localIterator.next();
      if (localak.b != null)
      {
        localObject = new ArrayList(localak.b.length);
        z[] arrayOfz = localak.b;
        int i2 = arrayOfz.length;
        int i1 = 0;
        while (i1 < i2)
        {
          z localz = arrayOfz[i1];
          if (!TextUtils.equals("offline", localz.a)) {
            ((List)localObject).add(localz);
          }
          i1 += 1;
        }
      }
      for (Object localObject = (z[])((List)localObject).toArray(new z[((List)localObject).size()]);; localObject = null)
      {
        g(new ak(localak.a, (z[])localObject, localak.c));
        break;
      }
    }
    this.p.clear();
    this.o.clear();
  }
  
  private void f(ak paramak)
  {
    j.a locala = new j.a();
    String str1 = paramak.a("id", null);
    String str7 = paramak.a("t", null);
    Object localObject3 = paramak.a("from", null);
    String str6 = paramak.a("offline", null);
    String str5 = paramak.a("notify", null);
    String str2 = paramak.a("verified_name", null);
    String str3 = paramak.a("edit", null);
    boolean bool = a((String)localObject3);
    Object localObject1;
    String str4;
    if (bool)
    {
      localObject1 = paramak.a("participant", null);
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      str4 = paramak.a("type", null);
      if ((!"text".equals(str4)) && (!"media".equals(str4))) {}
    }
    label500:
    label508:
    label514:
    label521:
    label727:
    do
    {
      int i1;
      for (;;)
      {
        try
        {
          l1 = Long.parseLong(str7);
          l1 *= 1000L;
          locala.a(l1);
          if (str6 == null) {}
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          try
          {
            locala.j = Integer.valueOf(str6);
            if (bool)
            {
              localObject3 = Boolean.TRUE;
              locala.n = ((Boolean)localObject3);
              locala.m = str5;
              locala.c = str1;
              locala.a();
              locala.a = ((String)localObject1);
              locala.b = ((String)localObject2);
              if (str2 == null) {}
            }
            try
            {
              locala.b(Long.parseLong(str2));
              if (paramak.c != null) {
                break label500;
              }
              paramak = new ak[0];
              int i2 = paramak.length;
              i1 = 0;
              localObject3 = locala;
              if (i1 >= i2) {
                break label727;
              }
              locala = paramak[i1];
              if (((!ak.b(locala, "body")) && (!ak.b(locala, "media"))) || (str1 == null)) {
                break label521;
              }
              localObject3 = new al();
              if (!bool) {
                break label508;
              }
              paramak = (ak)localObject2;
              ((al)localObject3).a = paramak;
              ((al)localObject3).b = "message";
              ((al)localObject3).c = str1;
              ((al)localObject3).d = str4;
              if (!bool) {
                break label514;
              }
              ((al)localObject3).e = ((String)localObject1);
              ((al)localObject3).a("error", "406");
              a((al)localObject3);
              Log.e("connection/handleMessage: received plaintext message");
              return;
            }
            catch (NumberFormatException paramak)
            {
              throw new c("verified name serial number value '" + str2 + "' is not numeric");
            }
            localObject2 = paramak.a("participant", null);
            localObject1 = localObject3;
            localObject3 = localObject2;
            break;
            localNumberFormatException1 = localNumberFormatException1;
            l1 = System.currentTimeMillis();
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            Log.e("connection/handleMessage: got bad offline=" + str6 + " " + localNumberFormatException2);
            continue;
            localObject4 = Boolean.FALSE;
            continue;
          }
        }
        paramak = paramak.c;
        continue;
        paramak = (ak)localObject1;
        continue;
        localObject1 = localObject2;
      }
      if ((ak.b(locala, "enc")) && (str1 != null)) {
        localObject4 = a((j.a)localObject4, locala);
      }
      for (;;)
      {
        i1 += 1;
        break;
        if ((ak.b(locala, "registration")) && (str1 != null) && (locala.d != null) && (locala.d.length == 4))
        {
          ((j.a)localObject4).o = locala.d;
        }
        else if ((ak.b(locala, "verified_name")) && (str1 != null) && (str2 != null))
        {
          str5 = locala.b("v");
          if (("1".equals(str5)) && (locala.d != null)) {
            ((j.a)localObject4).p = locala.d;
          } else {
            Log.w("unknown vname cert payload version: " + str5);
          }
        }
        else if ((ak.b(locala, "multicast")) && (str1 != null))
        {
          ((j.a)localObject4).q = Integer.valueOf(1);
        }
        else
        {
          ak.b(locala, "keys");
        }
      }
      if (!TextUtils.isEmpty(str3)) {
        ((j.a)localObject4).r = Integer.valueOf(str3);
      }
      localObject1 = ((j.a)localObject4).c();
    } while (localObject1 == null);
    Object localObject2 = this.c;
    long l1 = System.currentTimeMillis();
    long l2 = ((j)localObject1).n;
    Object localObject4 = new StringBuilder("xmpp/reader/read/message ").append(((j)localObject1).e.a).append(" ").append(((j)localObject1).e.c).append(" ");
    if ("".equals(((j)localObject1).f)) {}
    for (paramak = "none";; paramak = ((j)localObject1).f)
    {
      Log.i(paramak + " " + (l1 - l2) + " " + ((j)localObject1).R);
      ((aa)localObject2).a.a(Message.obtain(null, 0, 0, 0, localObject1));
      return;
    }
  }
  
  /* Error */
  private void g(ak paramak)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore_3
    //   5: iconst_0
    //   6: istore 4
    //   8: aload_1
    //   9: ldc_w 798
    //   12: aconst_null
    //   13: invokevirtual 283	com/whatsapp/protocol/ak:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   16: astore 17
    //   18: aload_1
    //   19: ldc_w 490
    //   22: aconst_null
    //   23: invokevirtual 283	com/whatsapp/protocol/ak:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   26: astore 18
    //   28: aload_1
    //   29: ldc_w 383
    //   32: aconst_null
    //   33: invokevirtual 283	com/whatsapp/protocol/ak:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   36: astore 15
    //   38: aload 15
    //   40: astore 14
    //   42: aload 15
    //   44: ifnonnull +8 -> 52
    //   47: ldc_w 1277
    //   50: astore 14
    //   52: aload_1
    //   53: ldc_w 482
    //   56: aconst_null
    //   57: invokevirtual 283	com/whatsapp/protocol/ak:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   60: astore 16
    //   62: aload_1
    //   63: ldc_w 278
    //   66: aconst_null
    //   67: invokevirtual 283	com/whatsapp/protocol/ak:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 19
    //   72: new 335	com/whatsapp/protocol/al
    //   75: dup
    //   76: invokespecial 1278	com/whatsapp/protocol/al:<init>	()V
    //   79: astore 15
    //   81: aload 15
    //   83: aload 17
    //   85: putfield 349	com/whatsapp/protocol/al:a	Ljava/lang/String;
    //   88: aload 15
    //   90: ldc_w 1069
    //   93: putfield 1279	com/whatsapp/protocol/al:b	Ljava/lang/String;
    //   96: aload 15
    //   98: aload 18
    //   100: putfield 337	com/whatsapp/protocol/al:c	Ljava/lang/String;
    //   103: aload 15
    //   105: aload 19
    //   107: putfield 1280	com/whatsapp/protocol/al:d	Ljava/lang/String;
    //   110: aload 15
    //   112: aload 14
    //   114: putfield 1281	com/whatsapp/protocol/al:e	Ljava/lang/String;
    //   117: ldc_w 734
    //   120: aload 19
    //   122: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   125: ifeq +228 -> 353
    //   128: aload_1
    //   129: invokevirtual 552	com/whatsapp/protocol/ak:a	()Lcom/whatsapp/protocol/ak;
    //   132: astore_1
    //   133: aload_1
    //   134: ifnull +3868 -> 4002
    //   137: aload_1
    //   138: ldc_w 704
    //   141: invokestatic 311	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   144: ifeq +54 -> 198
    //   147: aload_0
    //   148: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   151: aload 15
    //   153: aload_1
    //   154: ldc_w 321
    //   157: aconst_null
    //   158: invokevirtual 283	com/whatsapp/protocol/ak:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   161: aload_1
    //   162: ldc_w 713
    //   165: aconst_null
    //   166: invokevirtual 283	com/whatsapp/protocol/ak:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   169: aload_1
    //   170: ldc_w 490
    //   173: aconst_null
    //   174: invokevirtual 283	com/whatsapp/protocol/ak:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   177: aload 16
    //   179: invokestatic 397	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   182: invokevirtual 2238	com/whatsapp/protocol/aa:a	(Lcom/whatsapp/protocol/al;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   185: iconst_1
    //   186: istore_3
    //   187: iload_3
    //   188: ifne +9 -> 197
    //   191: aload_0
    //   192: aload 15
    //   194: invokevirtual 1284	com/whatsapp/protocol/b:a	(Lcom/whatsapp/protocol/al;)V
    //   197: return
    //   198: aload_1
    //   199: ldc_w 753
    //   202: invokestatic 311	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   205: ifeq +39 -> 244
    //   208: aload_0
    //   209: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   212: aload 15
    //   214: aload_1
    //   215: ldc_w 321
    //   218: aconst_null
    //   219: invokevirtual 283	com/whatsapp/protocol/ak:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   222: aload_1
    //   223: ldc_w 713
    //   226: aconst_null
    //   227: invokevirtual 283	com/whatsapp/protocol/ak:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   230: aconst_null
    //   231: aload 16
    //   233: invokestatic 397	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   236: invokevirtual 2238	com/whatsapp/protocol/aa:a	(Lcom/whatsapp/protocol/al;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   239: iconst_1
    //   240: istore_3
    //   241: goto -54 -> 187
    //   244: aload_1
    //   245: ldc_w 2240
    //   248: invokestatic 311	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   251: ifeq +3751 -> 4002
    //   254: iconst_1
    //   255: istore_3
    //   256: aload_0
    //   257: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   260: astore 14
    //   262: aload_1
    //   263: ldc_w 321
    //   266: aconst_null
    //   267: invokevirtual 283	com/whatsapp/protocol/ak:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   270: astore_1
    //   271: new 329	java/lang/StringBuilder
    //   274: dup
    //   275: ldc_w 2242
    //   278: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   281: aload_1
    //   282: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 292	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   291: aload 14
    //   293: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   296: astore 14
    //   298: aload 15
    //   300: getfield 337	com/whatsapp/protocol/al:c	Ljava/lang/String;
    //   303: astore 16
    //   305: new 795	android/os/Bundle
    //   308: dup
    //   309: invokespecial 796	android/os/Bundle:<init>	()V
    //   312: astore 17
    //   314: aload 17
    //   316: ldc_w 2080
    //   319: aload 16
    //   321: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: aload 17
    //   326: ldc_w 321
    //   329: aload_1
    //   330: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload 14
    //   335: aconst_null
    //   336: iconst_0
    //   337: bipush 20
    //   339: iconst_0
    //   340: aload 17
    //   342: invokestatic 301	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   345: invokeinterface 306 2 0
    //   350: goto -163 -> 187
    //   353: ldc_w 716
    //   356: aload 19
    //   358: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   361: ifeq +47 -> 408
    //   364: aload_1
    //   365: ldc_w 2191
    //   368: invokevirtual 743	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   371: astore_1
    //   372: aload_1
    //   373: ifnonnull +27 -> 400
    //   376: aconst_null
    //   377: astore_1
    //   378: aload_0
    //   379: getfield 236	com/whatsapp/protocol/b:g	Lcom/whatsapp/qz;
    //   382: aload 15
    //   384: aload_1
    //   385: aload 14
    //   387: aload 16
    //   389: invokestatic 397	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   392: invokevirtual 1623	com/whatsapp/qz:a	(Lcom/whatsapp/protocol/al;Ljava/lang/String;Ljava/lang/String;I)V
    //   395: iconst_1
    //   396: istore_3
    //   397: goto -210 -> 187
    //   400: aload_1
    //   401: invokevirtual 782	com/whatsapp/protocol/ak:b	()Ljava/lang/String;
    //   404: astore_1
    //   405: goto -27 -> 378
    //   408: ldc_w 2244
    //   411: aload 19
    //   413: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   416: ifeq +14 -> 430
    //   419: aload_0
    //   420: aload_1
    //   421: aload 15
    //   423: invokespecial 2246	com/whatsapp/protocol/b:a	(Lcom/whatsapp/protocol/ak;Lcom/whatsapp/protocol/al;)Z
    //   426: istore_3
    //   427: goto -240 -> 187
    //   430: ldc_w 534
    //   433: aload 19
    //   435: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   438: ifeq +264 -> 702
    //   441: aload_1
    //   442: invokevirtual 552	com/whatsapp/protocol/ak:a	()Lcom/whatsapp/protocol/ak;
    //   445: astore_1
    //   446: iload 4
    //   448: istore_3
    //   449: aload_1
    //   450: ifnull -263 -> 187
    //   453: aload_1
    //   454: ldc_w 704
    //   457: invokestatic 311	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   460: ifeq +141 -> 601
    //   463: iconst_1
    //   464: istore_3
    //   465: aload_1
    //   466: invokevirtual 782	com/whatsapp/protocol/ak:b	()Ljava/lang/String;
    //   469: astore_1
    //   470: aload 16
    //   472: invokestatic 451	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   475: ldc2_w 452
    //   478: lmul
    //   479: lstore 6
    //   481: aload_0
    //   482: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   485: astore 14
    //   487: new 329	java/lang/StringBuilder
    //   490: dup
    //   491: ldc_w 2248
    //   494: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   497: aload 17
    //   499: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: ldc_w 2250
    //   505: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: lload 6
    //   510: invokevirtual 1359	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   513: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 292	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   519: aload 14
    //   521: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   524: astore 14
    //   526: aload 15
    //   528: getfield 337	com/whatsapp/protocol/al:c	Ljava/lang/String;
    //   531: astore 16
    //   533: new 795	android/os/Bundle
    //   536: dup
    //   537: invokespecial 796	android/os/Bundle:<init>	()V
    //   540: astore 18
    //   542: aload 18
    //   544: ldc_w 2252
    //   547: aload 16
    //   549: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   552: aload 18
    //   554: ldc_w 321
    //   557: aload 17
    //   559: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   562: aload 18
    //   564: ldc_w 534
    //   567: aload_1
    //   568: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   571: aload 18
    //   573: ldc_w 2086
    //   576: lload 6
    //   578: invokevirtual 1810	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   581: aload 14
    //   583: aconst_null
    //   584: iconst_0
    //   585: bipush 16
    //   587: iconst_0
    //   588: aload 18
    //   590: invokestatic 301	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   593: invokeinterface 306 2 0
    //   598: goto -411 -> 187
    //   601: iload 4
    //   603: istore_3
    //   604: aload_1
    //   605: ldc_w 753
    //   608: invokestatic 311	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   611: ifeq -424 -> 187
    //   614: iconst_1
    //   615: istore_3
    //   616: aload_0
    //   617: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   620: astore_1
    //   621: new 329	java/lang/StringBuilder
    //   624: dup
    //   625: ldc_w 2254
    //   628: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   631: aload 17
    //   633: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   639: invokestatic 292	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   642: aload_1
    //   643: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   646: astore_1
    //   647: aload 15
    //   649: getfield 337	com/whatsapp/protocol/al:c	Ljava/lang/String;
    //   652: astore 14
    //   654: new 795	android/os/Bundle
    //   657: dup
    //   658: invokespecial 796	android/os/Bundle:<init>	()V
    //   661: astore 16
    //   663: aload 16
    //   665: ldc_w 2252
    //   668: aload 14
    //   670: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   673: aload 16
    //   675: ldc_w 321
    //   678: aload 17
    //   680: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   683: aload_1
    //   684: aconst_null
    //   685: iconst_0
    //   686: bipush 17
    //   688: iconst_0
    //   689: aload 16
    //   691: invokestatic 301	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   694: invokeinterface 306 2 0
    //   699: goto -512 -> 187
    //   702: ldc_w 358
    //   705: aload 19
    //   707: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   710: ifeq +573 -> 1283
    //   713: aload_1
    //   714: invokevirtual 552	com/whatsapp/protocol/ak:a	()Lcom/whatsapp/protocol/ak;
    //   717: astore_1
    //   718: iload 4
    //   720: istore_3
    //   721: aload_1
    //   722: ifnull -535 -> 187
    //   725: aload_1
    //   726: ldc_w 843
    //   729: invokestatic 311	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   732: ifeq +112 -> 844
    //   735: iconst_1
    //   736: istore_3
    //   737: aload_1
    //   738: getfield 555	com/whatsapp/protocol/ak:d	[B
    //   741: astore_1
    //   742: aload_0
    //   743: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   746: astore 14
    //   748: new 329	java/lang/StringBuilder
    //   751: dup
    //   752: ldc_w 2256
    //   755: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   758: aload 15
    //   760: invokevirtual 1354	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   763: ldc_w 2258
    //   766: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: aload_1
    //   770: invokestatic 1778	java/util/Arrays:toString	([B)Ljava/lang/String;
    //   773: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: invokestatic 292	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   782: aload 14
    //   784: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   787: astore 14
    //   789: new 795	android/os/Bundle
    //   792: dup
    //   793: invokespecial 796	android/os/Bundle:<init>	()V
    //   796: astore 16
    //   798: aload 16
    //   800: ldc_w 1794
    //   803: new 1796	com/whatsapp/messaging/ParcelableStanzaKey
    //   806: dup
    //   807: aload 15
    //   809: invokespecial 1798	com/whatsapp/messaging/ParcelableStanzaKey:<init>	(Lcom/whatsapp/protocol/al;)V
    //   812: invokevirtual 1802	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   815: aload 16
    //   817: ldc_w 2260
    //   820: aload_1
    //   821: invokevirtual 1850	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   824: aload 14
    //   826: aconst_null
    //   827: iconst_0
    //   828: bipush 31
    //   830: iconst_0
    //   831: aload 16
    //   833: invokestatic 301	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   836: invokeinterface 306 2 0
    //   841: goto -654 -> 187
    //   844: aload_1
    //   845: ldc_w 1078
    //   848: invokestatic 311	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   851: ifeq +119 -> 970
    //   854: iconst_1
    //   855: istore_3
    //   856: aload_1
    //   857: ldc_w 321
    //   860: aconst_null
    //   861: invokevirtual 283	com/whatsapp/protocol/ak:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   864: astore_1
    //   865: aload_0
    //   866: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   869: astore 14
    //   871: new 329	java/lang/StringBuilder
    //   874: dup
    //   875: ldc_w 2262
    //   878: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   881: aload_1
    //   882: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   888: invokestatic 292	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   891: aload 14
    //   893: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   896: astore 14
    //   898: aload 15
    //   900: getfield 349	com/whatsapp/protocol/al:a	Ljava/lang/String;
    //   903: astore 16
    //   905: aload 15
    //   907: getfield 337	com/whatsapp/protocol/al:c	Ljava/lang/String;
    //   910: astore 17
    //   912: new 795	android/os/Bundle
    //   915: dup
    //   916: invokespecial 796	android/os/Bundle:<init>	()V
    //   919: astore 18
    //   921: aload 18
    //   923: ldc_w 798
    //   926: aload 16
    //   928: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   931: aload 18
    //   933: ldc_w 2252
    //   936: aload 17
    //   938: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   941: aload 18
    //   943: ldc_w 321
    //   946: aload_1
    //   947: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   950: aload 14
    //   952: aconst_null
    //   953: iconst_0
    //   954: bipush 32
    //   956: iconst_0
    //   957: aload 18
    //   959: invokestatic 301	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   962: invokeinterface 306 2 0
    //   967: goto -780 -> 187
    //   970: aload_1
    //   971: ldc_w 2264
    //   974: invokestatic 311	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   977: ifeq +119 -> 1096
    //   980: iconst_1
    //   981: istore_3
    //   982: aload_1
    //   983: ldc_w 321
    //   986: aconst_null
    //   987: invokevirtual 283	com/whatsapp/protocol/ak:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   990: astore_1
    //   991: aload_0
    //   992: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   995: astore 14
    //   997: new 329	java/lang/StringBuilder
    //   1000: dup
    //   1001: ldc_w 2266
    //   1004: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1007: aload_1
    //   1008: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1014: invokestatic 292	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1017: aload 14
    //   1019: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   1022: astore 14
    //   1024: aload 15
    //   1026: getfield 349	com/whatsapp/protocol/al:a	Ljava/lang/String;
    //   1029: astore 16
    //   1031: aload 15
    //   1033: getfield 337	com/whatsapp/protocol/al:c	Ljava/lang/String;
    //   1036: astore 17
    //   1038: new 795	android/os/Bundle
    //   1041: dup
    //   1042: invokespecial 796	android/os/Bundle:<init>	()V
    //   1045: astore 18
    //   1047: aload 18
    //   1049: ldc_w 798
    //   1052: aload 16
    //   1054: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1057: aload 18
    //   1059: ldc_w 2252
    //   1062: aload 17
    //   1064: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1067: aload 18
    //   1069: ldc_w 321
    //   1072: aload_1
    //   1073: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1076: aload 14
    //   1078: aconst_null
    //   1079: iconst_0
    //   1080: bipush 71
    //   1082: iconst_0
    //   1083: aload 18
    //   1085: invokestatic 301	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   1088: invokeinterface 306 2 0
    //   1093: goto -906 -> 187
    //   1096: iload 4
    //   1098: istore_3
    //   1099: aload_1
    //   1100: ldc_w 2268
    //   1103: invokestatic 311	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   1106: ifeq -919 -> 187
    //   1109: aload_1
    //   1110: ldc_w 389
    //   1113: aconst_null
    //   1114: invokevirtual 283	com/whatsapp/protocol/ak:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1117: astore_1
    //   1118: lconst_0
    //   1119: lstore 6
    //   1121: lconst_0
    //   1122: lstore 10
    //   1124: aload_1
    //   1125: invokestatic 451	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1128: ldc2_w 452
    //   1131: lmul
    //   1132: lstore 8
    //   1134: lload 8
    //   1136: lstore 6
    //   1138: aload 16
    //   1140: invokestatic 451	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1143: lstore 12
    //   1145: lload 12
    //   1147: ldc2_w 452
    //   1150: lmul
    //   1151: lstore 10
    //   1153: lload 8
    //   1155: lstore 6
    //   1157: lload 10
    //   1159: lstore 8
    //   1161: aload_0
    //   1162: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   1165: astore_1
    //   1166: new 329	java/lang/StringBuilder
    //   1169: dup
    //   1170: ldc_w 2270
    //   1173: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1176: aload 15
    //   1178: invokevirtual 1354	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1181: ldc_w 2272
    //   1184: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1187: lload 8
    //   1189: invokevirtual 1359	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1192: ldc_w 2274
    //   1195: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: lload 6
    //   1200: invokevirtual 1359	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1203: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1206: invokestatic 292	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1209: aload_1
    //   1210: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   1213: astore_1
    //   1214: aconst_null
    //   1215: iconst_0
    //   1216: bipush 25
    //   1218: iconst_0
    //   1219: invokestatic 2078	android/os/Message:obtain	(Landroid/os/Handler;III)Landroid/os/Message;
    //   1222: astore 14
    //   1224: aload 14
    //   1226: invokevirtual 2059	android/os/Message:getData	()Landroid/os/Bundle;
    //   1229: ldc_w 919
    //   1232: lload 8
    //   1234: invokevirtual 1810	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1237: aload 14
    //   1239: invokevirtual 2059	android/os/Message:getData	()Landroid/os/Bundle;
    //   1242: ldc_w 389
    //   1245: lload 6
    //   1247: invokevirtual 1810	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1250: aload 14
    //   1252: invokevirtual 2059	android/os/Message:getData	()Landroid/os/Bundle;
    //   1255: ldc_w 1794
    //   1258: new 1796	com/whatsapp/messaging/ParcelableStanzaKey
    //   1261: dup
    //   1262: aload 15
    //   1264: invokespecial 1798	com/whatsapp/messaging/ParcelableStanzaKey:<init>	(Lcom/whatsapp/protocol/al;)V
    //   1267: invokevirtual 1802	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   1270: aload_1
    //   1271: aload 14
    //   1273: invokeinterface 306 2 0
    //   1278: iconst_1
    //   1279: istore_3
    //   1280: goto -1093 -> 187
    //   1283: ldc_w 2276
    //   1286: aload 19
    //   1288: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1291: ifeq +165 -> 1456
    //   1294: aload_1
    //   1295: invokevirtual 552	com/whatsapp/protocol/ak:a	()Lcom/whatsapp/protocol/ak;
    //   1298: astore_1
    //   1299: iload 4
    //   1301: istore_3
    //   1302: aload_1
    //   1303: ifnull -1116 -> 187
    //   1306: aload_1
    //   1307: ldc_w 2278
    //   1310: invokestatic 311	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   1313: ifeq +66 -> 1379
    //   1316: aload_0
    //   1317: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   1320: astore_1
    //   1321: ldc_w 2280
    //   1324: invokestatic 292	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1327: aload_1
    //   1328: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   1331: astore_1
    //   1332: new 795	android/os/Bundle
    //   1335: dup
    //   1336: invokespecial 796	android/os/Bundle:<init>	()V
    //   1339: astore 14
    //   1341: aload 14
    //   1343: ldc_w 1794
    //   1346: new 1796	com/whatsapp/messaging/ParcelableStanzaKey
    //   1349: dup
    //   1350: aload 15
    //   1352: invokespecial 1798	com/whatsapp/messaging/ParcelableStanzaKey:<init>	(Lcom/whatsapp/protocol/al;)V
    //   1355: invokevirtual 1802	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   1358: aload_1
    //   1359: aconst_null
    //   1360: iconst_0
    //   1361: bipush 75
    //   1363: iconst_0
    //   1364: aload 14
    //   1366: invokestatic 301	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   1369: invokeinterface 306 2 0
    //   1374: iconst_1
    //   1375: istore_3
    //   1376: goto -1189 -> 187
    //   1379: iload 4
    //   1381: istore_3
    //   1382: aload_1
    //   1383: ldc_w 2282
    //   1386: invokestatic 311	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   1389: ifeq -1202 -> 187
    //   1392: aload_0
    //   1393: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   1396: astore_1
    //   1397: ldc_w 2284
    //   1400: invokestatic 292	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1403: aload_1
    //   1404: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   1407: astore_1
    //   1408: new 795	android/os/Bundle
    //   1411: dup
    //   1412: invokespecial 796	android/os/Bundle:<init>	()V
    //   1415: astore 14
    //   1417: aload 14
    //   1419: ldc_w 1794
    //   1422: new 1796	com/whatsapp/messaging/ParcelableStanzaKey
    //   1425: dup
    //   1426: aload 15
    //   1428: invokespecial 1798	com/whatsapp/messaging/ParcelableStanzaKey:<init>	(Lcom/whatsapp/protocol/al;)V
    //   1431: invokevirtual 1802	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   1434: aload_1
    //   1435: aconst_null
    //   1436: iconst_0
    //   1437: sipush 131
    //   1440: iconst_0
    //   1441: aload 14
    //   1443: invokestatic 301	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   1446: invokeinterface 306 2 0
    //   1451: iconst_1
    //   1452: istore_3
    //   1453: goto -1266 -> 187
    //   1456: ldc_w 2286
    //   1459: aload 19
    //   1461: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1464: ifeq +165 -> 1629
    //   1467: aload_1
    //   1468: invokevirtual 552	com/whatsapp/protocol/ak:a	()Lcom/whatsapp/protocol/ak;
    //   1471: astore 14
    //   1473: iload 4
    //   1475: istore_3
    //   1476: aload 14
    //   1478: ifnull -1291 -> 187
    //   1481: iload 4
    //   1483: istore_3
    //   1484: aload 14
    //   1486: ldc_w 1188
    //   1489: invokestatic 311	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   1492: ifeq -1305 -> 187
    //   1495: iload 4
    //   1497: istore_3
    //   1498: aload 14
    //   1500: getfield 1644	com/whatsapp/protocol/ak:c	[Lcom/whatsapp/protocol/ak;
    //   1503: ifnull -1316 -> 187
    //   1506: iload 4
    //   1508: istore_3
    //   1509: aload 14
    //   1511: getfield 1644	com/whatsapp/protocol/ak:c	[Lcom/whatsapp/protocol/ak;
    //   1514: arraylength
    //   1515: ifle -1328 -> 187
    //   1518: new 419	java/util/ArrayList
    //   1521: dup
    //   1522: aload 14
    //   1524: getfield 1644	com/whatsapp/protocol/ak:c	[Lcom/whatsapp/protocol/ak;
    //   1527: arraylength
    //   1528: invokespecial 427	java/util/ArrayList:<init>	(I)V
    //   1531: astore_1
    //   1532: iconst_0
    //   1533: istore_2
    //   1534: iload_2
    //   1535: aload 14
    //   1537: getfield 1644	com/whatsapp/protocol/ak:c	[Lcom/whatsapp/protocol/ak;
    //   1540: arraylength
    //   1541: if_icmpge +47 -> 1588
    //   1544: aload_1
    //   1545: new 909	com/whatsapp/protocol/z
    //   1548: dup
    //   1549: aload 14
    //   1551: getfield 1644	com/whatsapp/protocol/ak:c	[Lcom/whatsapp/protocol/ak;
    //   1554: iload_2
    //   1555: aaload
    //   1556: getfield 1233	com/whatsapp/protocol/ak:a	Ljava/lang/String;
    //   1559: aload 14
    //   1561: getfield 1644	com/whatsapp/protocol/ak:c	[Lcom/whatsapp/protocol/ak;
    //   1564: iload_2
    //   1565: aaload
    //   1566: ldc_w 501
    //   1569: invokevirtual 1213	com/whatsapp/protocol/ak:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1572: invokespecial 911	com/whatsapp/protocol/z:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1575: invokeinterface 476 2 0
    //   1580: pop
    //   1581: iload_2
    //   1582: iconst_1
    //   1583: iadd
    //   1584: istore_2
    //   1585: goto -51 -> 1534
    //   1588: aload_0
    //   1589: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   1592: astore 14
    //   1594: ldc_w 2288
    //   1597: invokestatic 292	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1600: aload 14
    //   1602: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   1605: aconst_null
    //   1606: iconst_0
    //   1607: bipush 100
    //   1609: iconst_0
    //   1610: aload 15
    //   1612: aload_1
    //   1613: invokestatic 2293	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   1616: invokestatic 301	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   1619: invokeinterface 306 2 0
    //   1624: iconst_1
    //   1625: istore_3
    //   1626: goto -1439 -> 187
    //   1629: ldc_w 1104
    //   1632: aload 19
    //   1634: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1637: ifeq +285 -> 1922
    //   1640: aload_1
    //   1641: invokevirtual 552	com/whatsapp/protocol/ak:a	()Lcom/whatsapp/protocol/ak;
    //   1644: astore_1
    //   1645: iload 4
    //   1647: istore_3
    //   1648: aload_1
    //   1649: ifnull -1462 -> 187
    //   1652: aload_1
    //   1653: ldc_w 387
    //   1656: invokestatic 311	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   1659: ifeq +121 -> 1780
    //   1662: aload_1
    //   1663: ldc_w 501
    //   1666: invokevirtual 1213	com/whatsapp/protocol/ak:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1669: astore_1
    //   1670: aload_1
    //   1671: invokestatic 397	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1674: istore_2
    //   1675: aload_0
    //   1676: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   1679: astore_1
    //   1680: ldc_w 2295
    //   1683: invokestatic 292	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1686: aload_1
    //   1687: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   1690: astore_1
    //   1691: new 795	android/os/Bundle
    //   1694: dup
    //   1695: invokespecial 796	android/os/Bundle:<init>	()V
    //   1698: astore 14
    //   1700: aload 14
    //   1702: ldc_w 1794
    //   1705: new 1796	com/whatsapp/messaging/ParcelableStanzaKey
    //   1708: dup
    //   1709: aload 15
    //   1711: invokespecial 1798	com/whatsapp/messaging/ParcelableStanzaKey:<init>	(Lcom/whatsapp/protocol/al;)V
    //   1714: invokevirtual 1802	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   1717: aload 14
    //   1719: ldc_w 2297
    //   1722: iload_2
    //   1723: invokevirtual 877	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1726: aload_1
    //   1727: aconst_null
    //   1728: iconst_0
    //   1729: bipush 86
    //   1731: iconst_0
    //   1732: aload 14
    //   1734: invokestatic 301	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   1737: invokeinterface 306 2 0
    //   1742: iconst_1
    //   1743: istore_3
    //   1744: goto -1557 -> 187
    //   1747: astore 14
    //   1749: new 1215	com/whatsapp/protocol/c
    //   1752: dup
    //   1753: new 329	java/lang/StringBuilder
    //   1756: dup
    //   1757: ldc_w 2299
    //   1760: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1763: aload_1
    //   1764: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1767: ldc_w 2207
    //   1770: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1773: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1776: invokespecial 1218	com/whatsapp/protocol/c:<init>	(Ljava/lang/String;)V
    //   1779: athrow
    //   1780: aload_1
    //   1781: ldc_w 526
    //   1784: invokestatic 311	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   1787: ifeq +62 -> 1849
    //   1790: aload_0
    //   1791: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   1794: astore_1
    //   1795: ldc_w 2301
    //   1798: invokestatic 292	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1801: aload_1
    //   1802: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   1805: astore_1
    //   1806: aconst_null
    //   1807: iconst_0
    //   1808: bipush 87
    //   1810: iconst_0
    //   1811: invokestatic 2078	android/os/Message:obtain	(Landroid/os/Handler;III)Landroid/os/Message;
    //   1814: astore 14
    //   1816: aload 14
    //   1818: invokevirtual 2059	android/os/Message:getData	()Landroid/os/Bundle;
    //   1821: ldc_w 1794
    //   1824: new 1796	com/whatsapp/messaging/ParcelableStanzaKey
    //   1827: dup
    //   1828: aload 15
    //   1830: invokespecial 1798	com/whatsapp/messaging/ParcelableStanzaKey:<init>	(Lcom/whatsapp/protocol/al;)V
    //   1833: invokevirtual 1802	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   1836: aload_1
    //   1837: aload 14
    //   1839: invokeinterface 306 2 0
    //   1844: iconst_1
    //   1845: istore_3
    //   1846: goto -1659 -> 187
    //   1849: iload 4
    //   1851: istore_3
    //   1852: aload_1
    //   1853: ldc_w 2303
    //   1856: invokestatic 311	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   1859: ifeq -1672 -> 187
    //   1862: aload_0
    //   1863: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   1866: astore_1
    //   1867: ldc_w 2305
    //   1870: invokestatic 292	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1873: aload_1
    //   1874: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   1877: astore_1
    //   1878: aconst_null
    //   1879: iconst_0
    //   1880: sipush 23890
    //   1883: iconst_0
    //   1884: invokestatic 2078	android/os/Message:obtain	(Landroid/os/Handler;III)Landroid/os/Message;
    //   1887: astore 14
    //   1889: aload 14
    //   1891: invokevirtual 2059	android/os/Message:getData	()Landroid/os/Bundle;
    //   1894: ldc_w 1794
    //   1897: new 1796	com/whatsapp/messaging/ParcelableStanzaKey
    //   1900: dup
    //   1901: aload 15
    //   1903: invokespecial 1798	com/whatsapp/messaging/ParcelableStanzaKey:<init>	(Lcom/whatsapp/protocol/al;)V
    //   1906: invokevirtual 1802	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   1909: aload_1
    //   1910: aload 14
    //   1912: invokeinterface 306 2 0
    //   1917: iconst_1
    //   1918: istore_3
    //   1919: goto -1732 -> 187
    //   1922: ldc_w 1065
    //   1925: aload 19
    //   1927: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1930: ifeq +1013 -> 2943
    //   1933: aload_1
    //   1934: invokevirtual 552	com/whatsapp/protocol/ak:a	()Lcom/whatsapp/protocol/ak;
    //   1937: astore 14
    //   1939: aload 14
    //   1941: ifnull +2045 -> 3986
    //   1944: aload 14
    //   1946: ldc_w 278
    //   1949: invokevirtual 437	com/whatsapp/protocol/ak:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1952: astore 17
    //   1954: iload 5
    //   1956: istore 4
    //   1958: aload_1
    //   1959: ldc_w 2163
    //   1962: invokevirtual 437	com/whatsapp/protocol/ak:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1965: ifnull +78 -> 2043
    //   1968: iload 5
    //   1970: istore 4
    //   1972: aload 14
    //   1974: ldc_w 493
    //   1977: invokestatic 311	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   1980: ifeq +63 -> 2043
    //   1983: ldc_w 2268
    //   1986: aload 17
    //   1988: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1991: ifeq +318 -> 2309
    //   1994: aload_0
    //   1995: getfield 208	com/whatsapp/protocol/b:o	Ljava/util/LinkedHashMap;
    //   1998: aload 18
    //   2000: aload_1
    //   2001: invokevirtual 2306	java/util/LinkedHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2004: pop
    //   2005: aload 14
    //   2007: ldc_w 2268
    //   2010: invokevirtual 743	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   2013: astore_1
    //   2014: aload_1
    //   2015: ifnull +25 -> 2040
    //   2018: aload_1
    //   2019: invokevirtual 782	com/whatsapp/protocol/ak:b	()Ljava/lang/String;
    //   2022: astore_1
    //   2023: aload_1
    //   2024: ifnull +16 -> 2040
    //   2027: aload_0
    //   2028: getfield 213	com/whatsapp/protocol/b:p	Ljava/util/Map;
    //   2031: aload_1
    //   2032: aload 18
    //   2034: invokeinterface 1301 3 0
    //   2039: pop
    //   2040: iconst_1
    //   2041: istore 4
    //   2043: iload 4
    //   2045: istore_3
    //   2046: iload 4
    //   2048: ifne +1938 -> 3986
    //   2051: aload 14
    //   2053: ldc_w 493
    //   2056: invokestatic 311	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   2059: ifeq +573 -> 2632
    //   2062: ldc_w 753
    //   2065: aload 17
    //   2067: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2070: ifeq +331 -> 2401
    //   2073: ldc_w 815
    //   2076: aload 14
    //   2078: ldc_w 1086
    //   2081: invokevirtual 437	com/whatsapp/protocol/ak:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2084: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2087: istore_3
    //   2088: aload 14
    //   2090: ldc_w 860
    //   2093: invokevirtual 437	com/whatsapp/protocol/ak:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2096: astore_1
    //   2097: aload 14
    //   2099: ldc_w 499
    //   2102: invokevirtual 437	com/whatsapp/protocol/ak:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2105: astore 16
    //   2107: aload 14
    //   2109: invokevirtual 782	com/whatsapp/protocol/ak:b	()Ljava/lang/String;
    //   2112: astore 17
    //   2114: lconst_0
    //   2115: lstore 8
    //   2117: aload 14
    //   2119: ldc_w 482
    //   2122: invokevirtual 437	com/whatsapp/protocol/ak:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2125: astore 14
    //   2127: lload 8
    //   2129: lstore 6
    //   2131: aload 14
    //   2133: ifnull +18 -> 2151
    //   2136: aload 14
    //   2138: invokestatic 451	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2141: lstore 6
    //   2143: lload 6
    //   2145: ldc2_w 452
    //   2148: lmul
    //   2149: lstore 6
    //   2151: aload_0
    //   2152: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   2155: astore 14
    //   2157: ldc_w 2308
    //   2160: invokestatic 292	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2163: aload 14
    //   2165: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   2168: astore 14
    //   2170: aload 15
    //   2172: getfield 349	com/whatsapp/protocol/al:a	Ljava/lang/String;
    //   2175: astore 18
    //   2177: aload 15
    //   2179: getfield 337	com/whatsapp/protocol/al:c	Ljava/lang/String;
    //   2182: astore 19
    //   2184: new 795	android/os/Bundle
    //   2187: dup
    //   2188: invokespecial 796	android/os/Bundle:<init>	()V
    //   2191: astore 20
    //   2193: aload 20
    //   2195: ldc_w 798
    //   2198: aload 18
    //   2200: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2203: aload 20
    //   2205: ldc_w 490
    //   2208: aload 19
    //   2210: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2213: aload 20
    //   2215: ldc_w 2310
    //   2218: iload_3
    //   2219: invokevirtual 806	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2222: aload 20
    //   2224: ldc_w 2312
    //   2227: aload 17
    //   2229: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2232: aload 20
    //   2234: ldc_w 2314
    //   2237: aload_1
    //   2238: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2241: aload 20
    //   2243: ldc_w 2316
    //   2246: lload 6
    //   2248: invokevirtual 1810	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   2251: aload 20
    //   2253: ldc_w 2318
    //   2256: aload 16
    //   2258: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2261: aload 14
    //   2263: aconst_null
    //   2264: iconst_0
    //   2265: bipush 50
    //   2267: iconst_0
    //   2268: aload 20
    //   2270: invokestatic 301	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   2273: invokeinterface 306 2 0
    //   2278: iconst_1
    //   2279: istore 4
    //   2281: sipush 501
    //   2284: istore_2
    //   2285: iload 4
    //   2287: istore_3
    //   2288: iload 4
    //   2290: ifne -2103 -> 187
    //   2293: aload_0
    //   2294: aload 15
    //   2296: getfield 337	com/whatsapp/protocol/al:c	Ljava/lang/String;
    //   2299: iload_2
    //   2300: invokevirtual 2320	com/whatsapp/protocol/b:a	(Ljava/lang/String;I)V
    //   2303: iload 4
    //   2305: istore_3
    //   2306: goto -2119 -> 187
    //   2309: iload 5
    //   2311: istore 4
    //   2313: ldc_w 753
    //   2316: aload 17
    //   2318: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2321: ifeq -278 -> 2043
    //   2324: aload 14
    //   2326: invokevirtual 782	com/whatsapp/protocol/ak:b	()Ljava/lang/String;
    //   2329: astore 18
    //   2331: iload 5
    //   2333: istore 4
    //   2335: aload 18
    //   2337: ifnull -294 -> 2043
    //   2340: aload_0
    //   2341: getfield 213	com/whatsapp/protocol/b:p	Ljava/util/Map;
    //   2344: aload 18
    //   2346: invokeinterface 2322 2 0
    //   2351: checkcast 315	java/lang/String
    //   2354: astore 18
    //   2356: iload 5
    //   2358: istore 4
    //   2360: aload 18
    //   2362: ifnull -319 -> 2043
    //   2365: aload_0
    //   2366: getfield 208	com/whatsapp/protocol/b:o	Ljava/util/LinkedHashMap;
    //   2369: aload 18
    //   2371: invokevirtual 2323	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2374: checkcast 280	com/whatsapp/protocol/ak
    //   2377: astore 18
    //   2379: aload 18
    //   2381: ifnull +9 -> 2390
    //   2384: aload_0
    //   2385: aload 18
    //   2387: invokespecial 2324	com/whatsapp/protocol/b:a	(Lcom/whatsapp/protocol/ak;)V
    //   2390: aload_0
    //   2391: aload_1
    //   2392: invokespecial 2324	com/whatsapp/protocol/b:a	(Lcom/whatsapp/protocol/ak;)V
    //   2395: iconst_1
    //   2396: istore 4
    //   2398: goto -355 -> 2043
    //   2401: iload 4
    //   2403: istore_3
    //   2404: ldc_w 2268
    //   2407: aload 17
    //   2409: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2412: ifeq +1574 -> 3986
    //   2415: aload 14
    //   2417: ldc_w 2268
    //   2420: invokevirtual 743	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   2423: astore 17
    //   2425: aload 14
    //   2427: ldc_w 499
    //   2430: invokevirtual 743	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   2433: astore_1
    //   2434: aload 14
    //   2436: ldc_w 860
    //   2439: invokevirtual 743	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   2442: astore 18
    //   2444: aload 17
    //   2446: ifnull +1550 -> 3996
    //   2449: aload_1
    //   2450: ifnull +1546 -> 3996
    //   2453: aload 17
    //   2455: invokevirtual 782	com/whatsapp/protocol/ak:b	()Ljava/lang/String;
    //   2458: astore 14
    //   2460: aload_1
    //   2461: invokevirtual 782	com/whatsapp/protocol/ak:b	()Ljava/lang/String;
    //   2464: astore 16
    //   2466: aload 18
    //   2468: ifnull +159 -> 2627
    //   2471: aload 18
    //   2473: invokevirtual 782	com/whatsapp/protocol/ak:b	()Ljava/lang/String;
    //   2476: astore_1
    //   2477: aload 17
    //   2479: ldc_w 278
    //   2482: invokevirtual 437	com/whatsapp/protocol/ak:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2485: astore 17
    //   2487: aload 14
    //   2489: ifnull +1507 -> 3996
    //   2492: aload 16
    //   2494: ifnull +1502 -> 3996
    //   2497: aload_0
    //   2498: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   2501: astore 18
    //   2503: ldc_w 2326
    //   2506: invokestatic 292	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2509: aload 18
    //   2511: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   2514: astore 18
    //   2516: aload 15
    //   2518: getfield 349	com/whatsapp/protocol/al:a	Ljava/lang/String;
    //   2521: astore 19
    //   2523: aload 15
    //   2525: getfield 337	com/whatsapp/protocol/al:c	Ljava/lang/String;
    //   2528: astore 20
    //   2530: new 795	android/os/Bundle
    //   2533: dup
    //   2534: invokespecial 796	android/os/Bundle:<init>	()V
    //   2537: astore 21
    //   2539: aload 21
    //   2541: ldc_w 798
    //   2544: aload 19
    //   2546: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2549: aload 21
    //   2551: ldc_w 490
    //   2554: aload 20
    //   2556: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2559: aload 21
    //   2561: ldc_w 2312
    //   2564: aload 14
    //   2566: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2569: aload 21
    //   2571: ldc_w 2314
    //   2574: aload_1
    //   2575: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2578: aload 21
    //   2580: ldc_w 1703
    //   2583: aload 16
    //   2585: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2588: aload 21
    //   2590: ldc_w 278
    //   2593: aload 17
    //   2595: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2598: aload 18
    //   2600: aconst_null
    //   2601: iconst_0
    //   2602: bipush 42
    //   2604: iconst_0
    //   2605: aload 21
    //   2607: invokestatic 301	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   2610: invokeinterface 306 2 0
    //   2615: iconst_1
    //   2616: istore_3
    //   2617: sipush 501
    //   2620: istore_2
    //   2621: iload_3
    //   2622: istore 4
    //   2624: goto -339 -> 2285
    //   2627: aconst_null
    //   2628: astore_1
    //   2629: goto -152 -> 2477
    //   2632: aload 14
    //   2634: ldc_w 308
    //   2637: invokestatic 311	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   2640: ifeq +160 -> 2800
    //   2643: iload 4
    //   2645: istore_3
    //   2646: ldc_w 2268
    //   2649: aload 17
    //   2651: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2654: ifeq +1332 -> 3986
    //   2657: aload 14
    //   2659: ldc_w 2268
    //   2662: invokevirtual 743	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   2665: astore_1
    //   2666: aload_1
    //   2667: ifnull +126 -> 2793
    //   2670: iconst_1
    //   2671: istore 4
    //   2673: aload_0
    //   2674: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   2677: astore 14
    //   2679: aload_1
    //   2680: invokevirtual 782	com/whatsapp/protocol/ak:b	()Ljava/lang/String;
    //   2683: astore_1
    //   2684: new 329	java/lang/StringBuilder
    //   2687: dup
    //   2688: ldc_w 2328
    //   2691: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2694: aload 15
    //   2696: getfield 337	com/whatsapp/protocol/al:c	Ljava/lang/String;
    //   2699: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2702: bipush 32
    //   2704: invokevirtual 2331	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   2707: aload_1
    //   2708: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2711: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2714: invokestatic 292	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2717: aload 14
    //   2719: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   2722: astore 14
    //   2724: aload 15
    //   2726: getfield 349	com/whatsapp/protocol/al:a	Ljava/lang/String;
    //   2729: astore 16
    //   2731: aload 15
    //   2733: getfield 337	com/whatsapp/protocol/al:c	Ljava/lang/String;
    //   2736: astore 17
    //   2738: new 795	android/os/Bundle
    //   2741: dup
    //   2742: invokespecial 796	android/os/Bundle:<init>	()V
    //   2745: astore 18
    //   2747: aload 18
    //   2749: ldc_w 798
    //   2752: aload 16
    //   2754: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2757: aload 18
    //   2759: ldc_w 490
    //   2762: aload 17
    //   2764: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2767: aload 18
    //   2769: ldc_w 2312
    //   2772: aload_1
    //   2773: invokevirtual 802	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2776: aload 14
    //   2778: aconst_null
    //   2779: iconst_0
    //   2780: bipush 96
    //   2782: iconst_0
    //   2783: aload 18
    //   2785: invokestatic 301	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   2788: invokeinterface 306 2 0
    //   2793: sipush 501
    //   2796: istore_2
    //   2797: goto -512 -> 2285
    //   2800: iload 4
    //   2802: istore_3
    //   2803: aload 14
    //   2805: ldc_w 1145
    //   2808: invokestatic 311	com/whatsapp/protocol/ak:b	(Lcom/whatsapp/protocol/ak;Ljava/lang/String;)Z
    //   2811: ifeq +1175 -> 3986
    //   2814: aload_0
    //   2815: getfield 268	com/whatsapp/protocol/b:n	Lcom/whatsapp/protocol/ax;
    //   2818: aload 14
    //   2820: getfield 555	com/whatsapp/protocol/ak:d	[B
    //   2823: invokeinterface 2334 2 0
    //   2828: astore_1
    //   2829: aload_1
    //   2830: ifnull +106 -> 2936
    //   2833: aload_0
    //   2834: getfield 260	com/whatsapp/protocol/b:q	Lcom/whatsapp/protocol/an;
    //   2837: aload_1
    //   2838: invokeinterface 2337 2 0
    //   2843: astore_1
    //   2844: aload_1
    //   2845: ifnull +84 -> 2929
    //   2848: lconst_0
    //   2849: lstore 6
    //   2851: aload 16
    //   2853: invokestatic 451	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2856: lstore 8
    //   2858: lload 8
    //   2860: lstore 6
    //   2862: aload_0
    //   2863: aload_1
    //   2864: aload 15
    //   2866: lload 6
    //   2868: invokespecial 2339	com/whatsapp/protocol/b:a	(Lcom/whatsapp/protocol/ak;Lcom/whatsapp/protocol/al;J)I
    //   2871: istore_2
    //   2872: iload_2
    //   2873: ifne +19 -> 2892
    //   2876: iconst_1
    //   2877: istore 4
    //   2879: sipush 501
    //   2882: istore_2
    //   2883: goto -598 -> 2285
    //   2886: astore_1
    //   2887: aconst_null
    //   2888: astore_1
    //   2889: goto -45 -> 2844
    //   2892: iconst_0
    //   2893: istore 4
    //   2895: goto -610 -> 2285
    //   2898: astore_1
    //   2899: iconst_0
    //   2900: istore 4
    //   2902: sipush 400
    //   2905: istore_2
    //   2906: new 329	java/lang/StringBuilder
    //   2909: dup
    //   2910: ldc_w 2341
    //   2913: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2916: aload_1
    //   2917: invokevirtual 1354	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2920: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2923: invokestatic 2198	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   2926: goto -641 -> 2285
    //   2929: sipush 401
    //   2932: istore_2
    //   2933: goto -648 -> 2285
    //   2936: sipush 401
    //   2939: istore_2
    //   2940: goto -655 -> 2285
    //   2943: ldc_w 2343
    //   2946: aload 19
    //   2948: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2951: ifeq +53 -> 3004
    //   2954: aload_0
    //   2955: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   2958: astore_1
    //   2959: new 329	java/lang/StringBuilder
    //   2962: dup
    //   2963: ldc_w 2345
    //   2966: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2969: aload 15
    //   2971: invokevirtual 1354	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2974: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2977: invokestatic 292	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2980: aload_1
    //   2981: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   2984: aconst_null
    //   2985: iconst_0
    //   2986: bipush 105
    //   2988: iconst_0
    //   2989: aload 15
    //   2991: invokestatic 301	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   2994: invokeinterface 306 2 0
    //   2999: iconst_1
    //   3000: istore_3
    //   3001: goto -2814 -> 187
    //   3004: ldc_w 2347
    //   3007: aload 19
    //   3009: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3012: ifeq +53 -> 3065
    //   3015: aload_0
    //   3016: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   3019: astore_1
    //   3020: new 329	java/lang/StringBuilder
    //   3023: dup
    //   3024: ldc_w 2349
    //   3027: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3030: aload 15
    //   3032: invokevirtual 1354	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3035: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3038: invokestatic 292	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3041: aload_1
    //   3042: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   3045: aconst_null
    //   3046: iconst_0
    //   3047: bipush 107
    //   3049: iconst_0
    //   3050: aload 15
    //   3052: invokestatic 301	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   3055: invokeinterface 306 2 0
    //   3060: iconst_1
    //   3061: istore_3
    //   3062: goto -61 -> 3001
    //   3065: ldc_w 2351
    //   3068: aload 19
    //   3070: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3073: ifeq +340 -> 3413
    //   3076: aload_1
    //   3077: ldc_w 482
    //   3080: invokevirtual 1213	com/whatsapp/protocol/ak:a	(Ljava/lang/String;)Ljava/lang/String;
    //   3083: invokestatic 451	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   3086: lstore 6
    //   3088: aload_1
    //   3089: ldc_w 1184
    //   3092: invokevirtual 437	com/whatsapp/protocol/ak:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3095: astore 14
    //   3097: ldc_w 2353
    //   3100: aload 14
    //   3102: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3105: ifne +19 -> 3124
    //   3108: ldc_w 2355
    //   3111: aload 14
    //   3113: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3116: ifne +8 -> 3124
    //   3119: aload 14
    //   3121: ifnonnull +128 -> 3249
    //   3124: aload_1
    //   3125: invokevirtual 552	com/whatsapp/protocol/ak:a	()Lcom/whatsapp/protocol/ak;
    //   3128: astore_1
    //   3129: iload 4
    //   3131: istore_3
    //   3132: aload_1
    //   3133: ifnull -2946 -> 187
    //   3136: new 1242	com/whatsapp/protocol/j$a
    //   3139: dup
    //   3140: invokespecial 2169	com/whatsapp/protocol/j$a:<init>	()V
    //   3143: astore 16
    //   3145: aload_1
    //   3146: ldc_w 490
    //   3149: invokevirtual 437	com/whatsapp/protocol/ak:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3152: astore 17
    //   3154: aload 16
    //   3156: ldc_w 2357
    //   3159: putfield 2186	com/whatsapp/protocol/j$a:a	Ljava/lang/String;
    //   3162: aload 16
    //   3164: aload 17
    //   3166: putfield 2183	com/whatsapp/protocol/j$a:c	Ljava/lang/String;
    //   3169: aload 16
    //   3171: invokevirtual 2185	com/whatsapp/protocol/j$a:a	()Lcom/whatsapp/protocol/j$a;
    //   3174: pop
    //   3175: aload 16
    //   3177: aload_1
    //   3178: getfield 555	com/whatsapp/protocol/ak:d	[B
    //   3181: putfield 2358	com/whatsapp/protocol/j$a:e	[B
    //   3184: aload 16
    //   3186: lload 6
    //   3188: ldc2_w 452
    //   3191: lmul
    //   3192: invokevirtual 2176	com/whatsapp/protocol/j$a:a	(J)Lcom/whatsapp/protocol/j$a;
    //   3195: pop
    //   3196: aload 16
    //   3198: invokevirtual 1274	com/whatsapp/protocol/j$a:b	()Lcom/whatsapp/protocol/j$a;
    //   3201: pop
    //   3202: aload 16
    //   3204: invokevirtual 2226	com/whatsapp/protocol/j$a:c	()Lcom/whatsapp/protocol/j;
    //   3207: astore_1
    //   3208: iload 4
    //   3210: istore_3
    //   3211: aload_1
    //   3212: ifnull -3025 -> 187
    //   3215: aload 14
    //   3217: ifnull +14 -> 3231
    //   3220: ldc_w 2353
    //   3223: aload 14
    //   3225: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3228: ifeq +8 -> 3236
    //   3231: aload_1
    //   3232: iconst_5
    //   3233: putfield 994	com/whatsapp/protocol/j:d	I
    //   3236: aload_0
    //   3237: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   3240: aload_1
    //   3241: invokevirtual 2361	com/whatsapp/protocol/aa:a	(Lcom/whatsapp/protocol/j;)V
    //   3244: iconst_1
    //   3245: istore_3
    //   3246: goto -3059 -> 187
    //   3249: ldc_w 534
    //   3252: aload 14
    //   3254: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3257: ifeq +129 -> 3386
    //   3260: aload_1
    //   3261: ldc_w 360
    //   3264: invokevirtual 417	com/whatsapp/protocol/ak:f	(Ljava/lang/String;)Ljava/util/List;
    //   3267: invokeinterface 883 1 0
    //   3272: astore_1
    //   3273: aload_1
    //   3274: invokeinterface 888 1 0
    //   3279: ifeq +102 -> 3381
    //   3282: aload_1
    //   3283: invokeinterface 892 1 0
    //   3288: checkcast 280	com/whatsapp/protocol/ak
    //   3291: astore 16
    //   3293: aload 16
    //   3295: ldc_w 2363
    //   3298: iconst_0
    //   3299: invokevirtual 1971	com/whatsapp/protocol/ak:b	(Ljava/lang/String;I)J
    //   3302: lstore 6
    //   3304: aload 16
    //   3306: ldc_w 490
    //   3309: invokevirtual 437	com/whatsapp/protocol/ak:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3312: astore 14
    //   3314: aload 16
    //   3316: invokevirtual 552	com/whatsapp/protocol/ak:a	()Lcom/whatsapp/protocol/ak;
    //   3319: astore 16
    //   3321: aload 16
    //   3323: ifnull -50 -> 3273
    //   3326: new 590	com/whatsapp/protocol/j
    //   3329: dup
    //   3330: new 467	com/whatsapp/protocol/j$b
    //   3333: dup
    //   3334: ldc_w 2365
    //   3337: iconst_0
    //   3338: aload 14
    //   3340: invokespecial 470	com/whatsapp/protocol/j$b:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   3343: invokespecial 602	com/whatsapp/protocol/j:<init>	(Lcom/whatsapp/protocol/j$b;)V
    //   3346: astore 14
    //   3348: aload 14
    //   3350: aload 16
    //   3352: getfield 555	com/whatsapp/protocol/ak:d	[B
    //   3355: invokevirtual 2368	com/whatsapp/protocol/j:a	([B)V
    //   3358: aload 14
    //   3360: lload 6
    //   3362: ldc2_w 452
    //   3365: lmul
    //   3366: putfield 613	com/whatsapp/protocol/j:n	J
    //   3369: aload_0
    //   3370: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   3373: aload 14
    //   3375: invokevirtual 2361	com/whatsapp/protocol/aa:a	(Lcom/whatsapp/protocol/j;)V
    //   3378: goto -105 -> 3273
    //   3381: iconst_1
    //   3382: istore_3
    //   3383: goto -382 -> 3001
    //   3386: new 329	java/lang/StringBuilder
    //   3389: dup
    //   3390: ldc_w 2370
    //   3393: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3396: aload 14
    //   3398: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3401: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3404: invokestatic 2198	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   3407: iload 4
    //   3409: istore_3
    //   3410: goto -3223 -> 187
    //   3413: iload 4
    //   3415: istore_3
    //   3416: ldc_w 2372
    //   3419: aload 19
    //   3421: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3424: ifeq -3237 -> 187
    //   3427: aload 15
    //   3429: getfield 1281	com/whatsapp/protocol/al:e	Ljava/lang/String;
    //   3432: astore 14
    //   3434: aload_1
    //   3435: invokevirtual 552	com/whatsapp/protocol/ak:a	()Lcom/whatsapp/protocol/ak;
    //   3438: astore 16
    //   3440: aload 16
    //   3442: ifnonnull +14 -> 3456
    //   3445: new 1215	com/whatsapp/protocol/c
    //   3448: dup
    //   3449: ldc_w 2374
    //   3452: invokespecial 1218	com/whatsapp/protocol/c:<init>	(Ljava/lang/String;)V
    //   3455: athrow
    //   3456: aload_1
    //   3457: ldc_w 482
    //   3460: invokevirtual 437	com/whatsapp/protocol/ak:b	(Ljava/lang/String;)Ljava/lang/String;
    //   3463: astore_1
    //   3464: ldc_w 1104
    //   3467: aload 16
    //   3469: getfield 1233	com/whatsapp/protocol/ak:a	Ljava/lang/String;
    //   3472: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3475: ifeq +252 -> 3727
    //   3478: aload 16
    //   3480: ldc_w 2240
    //   3483: invokevirtual 743	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   3486: astore_1
    //   3487: aload 16
    //   3489: ldc_w 2376
    //   3492: invokevirtual 743	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   3495: astore 17
    //   3497: aload_1
    //   3498: ifnull +19 -> 3517
    //   3501: aload 17
    //   3503: ifnull +14 -> 3517
    //   3506: ldc_w 2378
    //   3509: invokestatic 2198	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   3512: iconst_0
    //   3513: istore_3
    //   3514: goto -513 -> 3001
    //   3517: aload_1
    //   3518: ifnull +154 -> 3672
    //   3521: aload_1
    //   3522: ldc_w 354
    //   3525: iconst_0
    //   3526: invokevirtual 547	com/whatsapp/protocol/ak:a	(Ljava/lang/String;I)I
    //   3529: istore_2
    //   3530: aload 16
    //   3532: ldc_w 1719
    //   3535: invokevirtual 743	com/whatsapp/protocol/ak:e	(Ljava/lang/String;)Lcom/whatsapp/protocol/ak;
    //   3538: astore_1
    //   3539: aload_1
    //   3540: ifnull +121 -> 3661
    //   3543: aload_1
    //   3544: getfield 555	com/whatsapp/protocol/ak:d	[B
    //   3547: astore_1
    //   3548: aload_1
    //   3549: ifnull +9 -> 3558
    //   3552: aload_1
    //   3553: arraylength
    //   3554: iconst_4
    //   3555: if_icmpeq +14 -> 3569
    //   3558: new 1215	com/whatsapp/protocol/c
    //   3561: dup
    //   3562: ldc_w 1960
    //   3565: invokespecial 1218	com/whatsapp/protocol/c:<init>	(Ljava/lang/String;)V
    //   3568: athrow
    //   3569: new 329	java/lang/StringBuilder
    //   3572: dup
    //   3573: ldc_w 2380
    //   3576: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3579: aload 14
    //   3581: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3584: ldc_w 2382
    //   3587: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3590: iload_2
    //   3591: invokevirtual 1126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3594: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3597: invokestatic 292	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3600: aload_0
    //   3601: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   3604: astore 14
    //   3606: new 329	java/lang/StringBuilder
    //   3609: dup
    //   3610: ldc_w 2384
    //   3613: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3616: aload 15
    //   3618: invokevirtual 1354	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3621: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3624: invokestatic 560	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   3627: aload 14
    //   3629: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   3632: aconst_null
    //   3633: iconst_0
    //   3634: bipush 125
    //   3636: iconst_0
    //   3637: new 2386	com/whatsapp/messaging/bi
    //   3640: dup
    //   3641: aload 15
    //   3643: aload_1
    //   3644: iload_2
    //   3645: invokespecial 2389	com/whatsapp/messaging/bi:<init>	(Lcom/whatsapp/protocol/al;[BI)V
    //   3648: invokestatic 301	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   3651: invokeinterface 306 2 0
    //   3656: iconst_1
    //   3657: istore_3
    //   3658: goto -657 -> 3001
    //   3661: new 1215	com/whatsapp/protocol/c
    //   3664: dup
    //   3665: ldc_w 1960
    //   3668: invokespecial 1218	com/whatsapp/protocol/c:<init>	(Ljava/lang/String;)V
    //   3671: athrow
    //   3672: aload 17
    //   3674: ifnull -162 -> 3512
    //   3677: aload_0
    //   3678: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   3681: astore_1
    //   3682: new 329	java/lang/StringBuilder
    //   3685: dup
    //   3686: ldc_w 2391
    //   3689: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3692: aload 15
    //   3694: invokevirtual 1354	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3697: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3700: invokestatic 560	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   3703: aload_1
    //   3704: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   3707: aconst_null
    //   3708: iconst_0
    //   3709: bipush 126
    //   3711: iconst_0
    //   3712: aload 15
    //   3714: invokestatic 301	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   3717: invokeinterface 306 2 0
    //   3722: iconst_1
    //   3723: istore_3
    //   3724: goto -723 -> 3001
    //   3727: ldc_w 1145
    //   3730: aload 16
    //   3732: getfield 1233	com/whatsapp/protocol/ak:a	Ljava/lang/String;
    //   3735: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3738: ifeq +130 -> 3868
    //   3741: aload 16
    //   3743: ldc_w 387
    //   3746: iconst_0
    //   3747: invokevirtual 547	com/whatsapp/protocol/ak:a	(Ljava/lang/String;I)I
    //   3750: istore_2
    //   3751: aload 16
    //   3753: invokestatic 1240	com/whatsapp/protocol/f:a	(Lcom/whatsapp/protocol/ak;)Lcom/whatsapp/protocol/f;
    //   3756: astore 16
    //   3758: new 329	java/lang/StringBuilder
    //   3761: dup
    //   3762: ldc_w 2393
    //   3765: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3768: aload 14
    //   3770: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3773: bipush 32
    //   3775: invokevirtual 2331	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3778: aload_1
    //   3779: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3782: bipush 32
    //   3784: invokevirtual 2331	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3787: invokestatic 1431	java/lang/System:currentTimeMillis	()J
    //   3790: invokevirtual 1359	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3793: bipush 32
    //   3795: invokevirtual 2331	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   3798: iload_2
    //   3799: invokevirtual 1126	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3802: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3805: invokestatic 292	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3808: aload_0
    //   3809: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   3812: astore_1
    //   3813: new 329	java/lang/StringBuilder
    //   3816: dup
    //   3817: ldc_w 2395
    //   3820: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3823: aload 15
    //   3825: invokevirtual 1354	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3828: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3831: invokestatic 560	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   3834: aload_1
    //   3835: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   3838: aconst_null
    //   3839: iconst_0
    //   3840: bipush 124
    //   3842: iconst_0
    //   3843: new 2397	com/whatsapp/messaging/bh
    //   3846: dup
    //   3847: aload 15
    //   3849: aload 16
    //   3851: iload_2
    //   3852: invokespecial 2400	com/whatsapp/messaging/bh:<init>	(Lcom/whatsapp/protocol/al;Lcom/whatsapp/protocol/f;I)V
    //   3855: invokestatic 301	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   3858: invokeinterface 306 2 0
    //   3863: iconst_1
    //   3864: istore_3
    //   3865: goto -864 -> 3001
    //   3868: ldc_w 2402
    //   3871: aload 16
    //   3873: getfield 1233	com/whatsapp/protocol/ak:a	Ljava/lang/String;
    //   3876: invokevirtual 319	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3879: ifeq -367 -> 3512
    //   3882: aload 16
    //   3884: ldc_w 490
    //   3887: iconst_m1
    //   3888: invokevirtual 1971	com/whatsapp/protocol/ak:b	(Ljava/lang/String;I)J
    //   3891: lstore 6
    //   3893: aload_0
    //   3894: getfield 256	com/whatsapp/protocol/b:c	Lcom/whatsapp/protocol/aa;
    //   3897: astore_1
    //   3898: new 329	java/lang/StringBuilder
    //   3901: dup
    //   3902: ldc_w 2404
    //   3905: invokespecial 333	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3908: aload 15
    //   3910: invokevirtual 1354	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3913: ldc_w 2406
    //   3916: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3919: lload 6
    //   3921: invokevirtual 1359	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3924: invokevirtual 345	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3927: invokestatic 560	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   3930: aload_1
    //   3931: getfield 295	com/whatsapp/protocol/aa:a	Lcom/whatsapp/messaging/u$a;
    //   3934: aconst_null
    //   3935: iconst_0
    //   3936: sipush 130
    //   3939: iconst_0
    //   3940: new 2408	com/whatsapp/messaging/bg
    //   3943: dup
    //   3944: aload 15
    //   3946: lload 6
    //   3948: invokespecial 2411	com/whatsapp/messaging/bg:<init>	(Lcom/whatsapp/protocol/al;J)V
    //   3951: invokestatic 301	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   3954: invokeinterface 306 2 0
    //   3959: iconst_1
    //   3960: istore_3
    //   3961: goto -960 -> 3001
    //   3964: astore 14
    //   3966: lload 8
    //   3968: lstore 6
    //   3970: goto -1819 -> 2151
    //   3973: astore 14
    //   3975: goto -1113 -> 2862
    //   3978: astore_1
    //   3979: lload 10
    //   3981: lstore 8
    //   3983: goto -2822 -> 1161
    //   3986: sipush 501
    //   3989: istore_2
    //   3990: iload_3
    //   3991: istore 4
    //   3993: goto -1708 -> 2285
    //   3996: iload 4
    //   3998: istore_3
    //   3999: goto -1382 -> 2617
    //   4002: iconst_0
    //   4003: istore_3
    //   4004: goto -3654 -> 350
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4007	0	this	b
    //   0	4007	1	paramak	ak
    //   1533	2457	2	i1	int
    //   4	4000	3	bool1	boolean
    //   6	3991	4	bool2	boolean
    //   1	2356	5	bool3	boolean
    //   479	3490	6	l1	long
    //   1132	2850	8	l2	long
    //   1122	2858	10	l3	long
    //   1143	3	12	l4	long
    //   40	1693	14	localObject1	Object
    //   1747	1	14	localNumberFormatException1	NumberFormatException
    //   1814	1955	14	localObject2	Object
    //   3964	1	14	localNumberFormatException2	NumberFormatException
    //   3973	1	14	localNumberFormatException3	NumberFormatException
    //   36	3909	15	localObject3	Object
    //   60	3823	16	localObject4	Object
    //   16	3657	17	localObject5	Object
    //   26	2758	18	localObject6	Object
    //   70	3350	19	str	String
    //   2191	364	20	localObject7	Object
    //   2537	69	21	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   1670	1675	1747	java/lang/NumberFormatException
    //   2833	2844	2886	java/lang/Exception
    //   2862	2872	2898	com/whatsapp/util/ar
    //   2136	2143	3964	java/lang/NumberFormatException
    //   2851	2858	3973	java/lang/NumberFormatException
    //   1124	1134	3978	java/lang/NumberFormatException
    //   1138	1145	3978	java/lang/NumberFormatException
  }
  
  private static Map<String, String> h(ak paramak)
  {
    HashMap localHashMap = new HashMap();
    if (paramak.c != null)
    {
      int i1 = 0;
      while (i1 < paramak.c.length)
      {
        ak localak = paramak.c[i1];
        if (ak.b(localak, "dirty")) {
          localHashMap.put(localak.b("type"), localak.b("timestamp"));
        }
        i1 += 1;
      }
    }
    return localHashMap;
  }
  
  public final void a()
  {
    int i1 = this.j + 1;
    this.j = i1;
    Object localObject = Integer.toHexString(i1);
    this.d.put(localObject, new y()
    {
      public final void a(ak paramAnonymousak, String paramAnonymousString)
      {
        paramAnonymousString = paramAnonymousak.e("props");
        Object localObject1;
        com.whatsapp.messaging.w localw;
        Object localObject3;
        long l;
        if (paramAnonymousString != null)
        {
          paramAnonymousak = paramAnonymousString.a("version", null);
          try
          {
            i = Integer.parseInt(paramAnonymousak);
            paramAnonymousak = new HashMap();
            paramAnonymousString = paramAnonymousString.f("prop").iterator();
            while (paramAnonymousString.hasNext())
            {
              localObject1 = (ak)paramAnonymousString.next();
              paramAnonymousak.put(((ak)localObject1).b("name"), ((ak)localObject1).b("value"));
            }
          }
          catch (NumberFormatException paramAnonymousak)
          {
            int i;
            for (;;)
            {
              i = 0;
            }
            paramAnonymousString = b.this.c;
            Log.i("xmpp/reader/read/server-props");
            localObject1 = paramAnonymousString.b;
            localw = paramAnonymousString.c;
            localObject3 = paramAnonymousString.e;
            l = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
            Object localObject2 = com.whatsapp.u.a().getSharedPreferences("com.whatsapp_preferences", 0);
            paramAnonymousString = ((SharedPreferences)localObject2).edit();
            aic.n = i;
            paramAnonymousString.putInt("server_props:last_version", i);
            aic.o = aic.a("participants_size_limit", 50, (String)paramAnonymousak.get("max_participants"), paramAnonymousString) - 1;
            aic.q = aic.a("subject_length_limit", 25, (String)paramAnonymousak.get("max_subject"), paramAnonymousString);
            aic.p = aic.a("group_number_limit", 9999, (String)paramAnonymousak.get("max_groups"), paramAnonymousString);
            aic.s = aic.a("media_limit_mb", 16, (String)paramAnonymousak.get("media"), paramAnonymousString);
            aic.t = aic.a("media_limit_auto_download_mb", 32, (String)paramAnonymousak.get("media_max_autodownload"), paramAnonymousString);
            aic.r = aic.a("broadcast_list_size_limit", 256, (String)paramAnonymousak.get("max_list_recipients"), paramAnonymousString);
            aic.u = aic.a("location_enabled", false, (String)paramAnonymousak.get("location"), paramAnonymousString);
            aic.v = aic.a("image_max_kbytes", 1024, (String)paramAnonymousak.get("image_max_kbytes"), paramAnonymousString);
            aic.w = aic.a("image_quality", 80, (String)paramAnonymousak.get("image_quality"), paramAnonymousString);
            aic.x = aic.a("image_max_edge", 1600, (String)paramAnonymousak.get("image_max_edge"), paramAnonymousString);
            aic.C = aic.a("document_limit_mb", 64, (String)paramAnonymousak.get("file_max_size"), paramAnonymousString);
            aic.y = aic.a("force_long_connect", false, (String)paramAnonymousak.get("force_long_connect"), paramAnonymousString);
            aic.z = aic.a("places_source", -1, (String)paramAnonymousak.get("source"), paramAnonymousString);
            aic.D = aic.a("gdrive_max_concurrent_reads", 4, (String)paramAnonymousak.get("transport"), paramAnonymousString);
            aic.F = aic.a("heartbeat_interval_seconds", 1209600, (String)paramAnonymousak.get("heartbeat_interval"), paramAnonymousString);
            aic.H = aic.a("gif_search", aic.b, (String)paramAnonymousak.get("gif_search"), paramAnonymousString);
            aic.G = aic.a("emoji_search", aic.a, (String)paramAnonymousak.get("emoji_search"), paramAnonymousString);
            aic.I = aic.a("gif_provider", -1, (String)paramAnonymousak.get("gif_provider"), paramAnonymousString);
            aic.J = aic.a("max_keys", 812, (String)paramAnonymousak.get("max_keys"), paramAnonymousString);
            aic.K = aic.a("ping_timeout_s", 32, (String)paramAnonymousak.get("ping_timeout_s"), paramAnonymousString);
            aic.L = aic.a("video_max_bitrate", 5000, (String)paramAnonymousak.get("video_max_bitrate"), paramAnonymousString);
            aic.M = aic.a("contact_array_enabled", true, (String)paramAnonymousak.get("contact_array_enabled"), paramAnonymousString);
            aic.N = aic.a("contact_indexing_enabled", true, (String)paramAnonymousak.get("contact_indexing_enabled"), paramAnonymousString);
            aic.O = aic.a("contact_indexing_ui_enabled", false, (String)paramAnonymousak.get("contact_indexing_ui_enabled"), paramAnonymousString);
            aic.P = aic.a("edit", aic.c, (String)paramAnonymousak.get("edit"), paramAnonymousString);
            aic.Q = aic.a("status_image_quality", 50, (String)paramAnonymousak.get("status_image_quality"), paramAnonymousString);
            aic.R = aic.a("status_image_max_edge", 1280, (String)paramAnonymousak.get("status_image_max_edge"), paramAnonymousString);
            aic.S = aic.a("status_video_max_duration", 45, (String)paramAnonymousak.get("status_video_max_duration"), paramAnonymousString);
            aic.T = aic.a("media_view_exoplayer", aic.d, (String)paramAnonymousak.get("media_view_exoplayer"), paramAnonymousString);
            aic.U = aic.a("media_view_streaming", aic.e, (String)paramAnonymousak.get("media_view_streaming"), paramAnonymousString);
            aic.V = aic.a("network_stack_to_use", aic.f, (String)paramAnonymousak.get("network_stack_to_use"), paramAnonymousString);
            aic.W = aic.a("p2p_pay", aic.g, (String)paramAnonymousak.get("p2p_pay"), paramAnonymousString);
            aic.X = aic.a("gcm_fg_service", aic.h, (String)paramAnonymousak.get("gcm_fg_service"), paramAnonymousString);
            aic.Y = aic.a("voip_redesign", aic.i, (String)paramAnonymousak.get("voip_redesign"), paramAnonymousString);
            aic.Z = aic.a("mms4_image", false, (String)paramAnonymousak.get("mms4_image"), paramAnonymousString);
            aic.aa = aic.a("mms4_audio", false, (String)paramAnonymousak.get("mms4_audio"), paramAnonymousString);
            aic.ab = aic.a("mms4_ptt", false, (String)paramAnonymousak.get("mms4_ptt"), paramAnonymousString);
            aic.ac = aic.a("mms4_video", false, (String)paramAnonymousak.get("mms4_video"), paramAnonymousString);
            aic.ad = aic.a("mms4_gif", aic.j, (String)paramAnonymousak.get("mms4_gif"), paramAnonymousString);
            aic.ae = aic.a("mms4_doc", aic.k, (String)paramAnonymousak.get("mms4_doc"), paramAnonymousString);
            aic.af = aic.a("fieldstats_sis", 86400, (String)paramAnonymousak.get("fieldstats_send_interval_seconds"), paramAnonymousString);
            aic.ag = aic.a("status_v3_text", aic.l, (String)paramAnonymousak.get("status_v3_text"), paramAnonymousString);
            aic.ah = aic.a("media_order", aic.m, (String)paramAnonymousak.get("media_order"), paramAnonymousString);
            String str = (String)paramAnonymousak.get("doc_types");
            if ((str != null) && (!TextUtils.equals(str, aic.A)))
            {
              if (TextUtils.isEmpty(aic.A))
              {
                i = ((atv)localObject3).a.getInt("autodownload_wifi_mask", 0);
                if (i != 0) {
                  ((atv)localObject3).a(1, i | 0x8);
                }
              }
              aic.A = str;
              paramAnonymousString.putString("documents", aic.A);
              aic.B.clear();
              if (!TextUtils.isEmpty(aic.A)) {
                aic.B.addAll(Arrays.asList(aic.A.split(",")));
              }
            }
            localObject3 = (String)paramAnonymousak.get("tos");
            localObject2 = ((SharedPreferences)localObject2).getString("tos_update", null);
            if (!TextUtils.equals((CharSequence)localObject3, (CharSequence)localObject2))
            {
              Log.i("tosupdate/changed from " + (String)localObject2 + " to " + (String)localObject3);
              aic.E.clear();
              if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!"off".equals(localObject3))) {
                break label1511;
              }
              paramAnonymousString.remove("tos_update");
              ((anv)localObject1).k();
            }
          }
        }
        for (;;)
        {
          if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!"off".equals(localObject3)) && (((anv)localObject1).h())) {
            localw.a(((anv)localObject1).i());
          }
          if (com.whatsapp.av.i())
          {
            localObject1 = com.whatsapp.u.a();
            paramAnonymousak = (String)paramAnonymousak.get("debug_chat_host");
            if (com.whatsapp.av.i()) {
              a.a.a.a.d.a(a.a.a.a.d.f((Context)localObject1), paramAnonymousak);
            }
          }
          paramAnonymousString.putLong("groups_server_props_last_refresh_time", l);
          paramAnonymousString.apply();
          return;
          label1511:
          paramAnonymousString.putString("tos_update", (String)localObject3);
          aic.E = aic.b((String)localObject3);
        }
      }
    });
    ak localak = new ak("props", null);
    localObject = new ak("iq", new z[] { new z("id", (String)localObject), new z("xmlns", "w"), new z("type", "get"), new z("to", "s.whatsapp.net") }, localak);
    this.b.a((ak)localObject);
  }
  
  public final void a(al paramal)
  {
    a(paramal, paramal.a());
  }
  
  public final void a(al paramal, ak paramak)
  {
    Object localObject2 = null;
    ao localao = this.b;
    String str1 = paramal.a;
    String str2 = paramal.b;
    Object localObject1;
    if (("receipt".equals(str2)) && ("delivery".equals(paramal.d)))
    {
      localObject1 = null;
      String str3 = paramal.c;
      String str4 = paramal.e;
      ArrayList localArrayList = new ArrayList();
      if (str3 == null) {
        break label296;
      }
      localArrayList.add(new z("id", str3));
      label91:
      if (str1 == null) {
        break label306;
      }
      localArrayList.add(new z("to", str1));
      label114:
      if (str2 == null) {
        break label316;
      }
      localArrayList.add(new z("class", str2));
      label137:
      if (localObject1 != null) {
        localArrayList.add(new z("type", (String)localObject1));
      }
      if (!TextUtils.isEmpty(str4)) {
        localArrayList.add(new z("participant", str4));
      }
      if ((!TextUtils.isEmpty(paramal.f)) && (!"0".equals(paramal.f))) {
        localArrayList.add(new z("edit", paramal.f));
      }
      if (paramal.g != null) {
        localArrayList.addAll(paramal.g);
      }
      localObject1 = (z[])localArrayList.toArray(new z[localArrayList.size()]);
      if (paramak != null) {
        break label326;
      }
      paramal = (al)localObject2;
    }
    for (;;)
    {
      localao.a(new ak("ack", (z[])localObject1, paramal));
      return;
      localObject1 = paramal.d;
      break;
      label296:
      a.d.a(false, "received stanza with null id");
      break label91;
      label306:
      a.d.a(false, "received stanza with null to");
      break label114;
      label316:
      a.d.a(false, "received stanza with null class");
      break label137;
      label326:
      paramal = new ak[1];
      paramal[0] = paramak;
    }
  }
  
  public final void a(j.b paramb, long paramLong, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, j.c paramc, f paramf, Map<String, f> paramMap, List<String> paramList, int paramInt2, int paramInt3, Integer paramInteger)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramInt2 & 0x1) != 0) {
      localArrayList.add(new ak("multicast", null));
    }
    if ((paramInt2 & 0x4) != 0) {
      localArrayList.add(new ak("url_number", null));
    }
    if ((paramInt2 & 0x2) != 0) {
      localArrayList.add(new ak("url_text", null));
    }
    label127:
    int i1;
    if (paramf != null)
    {
      localArrayList.add(a(paramf, paramInt1, paramString3, paramString4, paramInteger));
      if (paramMap == null) {
        break label437;
      }
      paramInt2 = paramMap.size();
      if (paramList == null) {
        break label443;
      }
      i1 = paramList.size();
    }
    for (;;)
    {
      label141:
      if ((paramInt2 > 0) || (i1 > 0))
      {
        paramf = new ak[paramInt2 + i1];
        if (paramInt2 > 0)
        {
          paramMap = paramMap.entrySet().iterator();
          int i2 = 0;
          for (;;)
          {
            if (paramMap.hasNext())
            {
              Object localObject = (Map.Entry)paramMap.next();
              paramInteger = (String)((Map.Entry)localObject).getKey();
              localObject = (f)((Map.Entry)localObject).getValue();
              paramInteger = new z("jid", paramInteger);
              localObject = a((f)localObject, paramInt1, paramString3, paramString4, null);
              paramf[i2] = new ak("to", new z[] { paramInteger }, (ak)localObject);
              i2 += 1;
              continue;
              paramf = new ArrayList();
              paramf.add(new z("v", "2"));
              paramf.add(new z("type", "none"));
              if (paramInt1 != 0) {
                paramf.add(new z("count", String.valueOf(paramInt1)));
              }
              if (paramString3 != null) {
                paramf.add(new z("mediatype", paramString3));
              }
              localArrayList.add(new ak("enc", (z[])paramf.toArray(new z[paramf.size()])));
              break;
              label437:
              paramInt2 = 0;
              break label127;
              label443:
              i1 = 0;
              break label141;
            }
          }
        }
        if (i1 > 0)
        {
          paramInt1 = 0;
          while (paramInt1 < i1)
          {
            paramf[(paramInt1 + paramInt2)] = new ak("to", new z[] { new z("jid", (String)paramList.get(paramInt1)) });
            paramInt1 += 1;
          }
        }
        if (paramString5 != null) {
          break label893;
        }
        paramString4 = null;
        localArrayList.add(new ak("participants", paramString4, paramf));
      }
    }
    paramString5 = new ArrayList();
    if (paramLong != 0L) {
      paramString5.add(new z("t", String.valueOf(paramLong / 1000L)));
    }
    if (paramb.b)
    {
      paramString4 = "to";
      label603:
      paramString5.add(new z(paramString4, paramb.a));
      if (paramString3 == null) {
        break label926;
      }
      paramString3 = "media";
      label634:
      paramString5.add(new z("type", paramString3));
      paramString5.add(new z("id", paramb.c));
      if (this.h.j()) {
        paramString5.add(new z("verified_name", this.u.ag()));
      }
      if (paramString2 != null) {
        paramString5.add(new z("phash", paramString2));
      }
      if (paramString1 != null) {
        paramString5.add(new z("participant", paramString1));
      }
      if (paramc != null) {
        if (paramc == j.c.a) {
          break label934;
        }
      }
    }
    label893:
    label926:
    label934:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        paramString5.add(new z("web", paramc.b()));
      }
      if (paramInt3 != 0) {
        paramString5.add(new z("edit", Integer.toString(paramInt3)));
      }
      this.b.a(new ak("message", (z[])paramString5.toArray(new z[paramString5.size()]), (ak[])localArrayList.toArray(new ak[localArrayList.size()])));
      return;
      paramString4 = new z[1];
      paramString4[0] = new z("name", paramString5);
      break;
      paramString4 = "from";
      break label603;
      paramString3 = "text";
      break label634;
    }
  }
  
  public final void a(j.b paramb, String paramString1, String paramString2, String[] paramArrayOfString, j.c paramc, Integer paramInteger)
  {
    boolean bool = a(paramString2);
    String str;
    if (bool)
    {
      str = paramString2;
      if (!bool) {
        break label103;
      }
      paramString2 = paramb.a;
    }
    ak[] arrayOfak;
    label103:
    for (;;)
    {
      if (paramArrayOfString == null) {
        break label164;
      }
      arrayOfak = new ak[paramArrayOfString.length];
      int i1 = 0;
      while (i1 < paramArrayOfString.length)
      {
        arrayOfak[i1] = new ak("item", new z[] { new z("id", paramArrayOfString[i1]) });
        i1 += 1;
      }
      str = paramb.a;
      break;
    }
    label164:
    for (paramArrayOfString = new ak[] { new ak("list", null, arrayOfak) };; paramArrayOfString = null)
    {
      paramb = new ak("receipt", a(paramb, paramString1, paramc, str, paramString2, paramInteger), paramArrayOfString);
      this.b.a(paramb);
      return;
    }
  }
  
  public final void a(j.b paramb, String paramString, int[] paramArrayOfInt)
  {
    boolean bool = a(paramString);
    String str;
    if (bool)
    {
      str = paramString;
      if (!bool) {
        break label82;
      }
      paramString = paramb.a;
    }
    ak[] arrayOfak;
    label82:
    for (;;)
    {
      arrayOfak = new ak[paramArrayOfInt.length];
      int i1 = 0;
      while (i1 < paramArrayOfInt.length)
      {
        arrayOfak[i1] = new ak("tag", null, String.valueOf(paramArrayOfInt[i1]));
        i1 += 1;
      }
      str = paramb.a;
      break;
    }
    paramArrayOfInt = new ak("error", new z[] { new z("type", "enc-v2-unknown-tags") }, arrayOfak);
    paramb = new ak("receipt", a(paramb, "error", null, str, paramString, null), paramArrayOfInt);
    this.b.a(paramb);
  }
  
  public final void a(String paramString, int paramInt)
  {
    ak localak = new ak("error", new z[] { new z("code", Integer.toString(paramInt)) });
    paramString = new ak("iq", new z[] { new z("id", paramString), new z("xmlns", "w:web"), new z("type", "set") }, localak);
    this.b.a(paramString);
  }
  
  public final void a(String paramString, int paramInt, List<av> paramList, final x paramx, final i parami)
  {
    String str = paramString;
    if (paramString == null)
    {
      int i1 = this.j + 1;
      this.j = i1;
      str = Integer.toHexString(i1);
    }
    this.d.put(str, new y()
    {
      public final void a(int paramAnonymousInt)
      {
        if (paramx != null) {
          paramx.a(paramAnonymousInt);
        }
      }
      
      public final void a(ak paramAnonymousak, String paramAnonymousString)
      {
        if (this.a != null) {
          this.a.run();
        }
      }
      
      public final void a(Exception paramAnonymousException)
      {
        if (parami != null) {
          parami.a(paramAnonymousException);
        }
      }
    });
    paramx = new ArrayList();
    paramString = null;
    paramList = paramList.iterator();
    boolean bool;
    if (paramList.hasNext())
    {
      parami = (av)paramList.next();
      if ((3 == paramInt) && (parami.s != null) && (parami.s.M == j.c.b))
      {
        bool = true;
        label120:
        ak localak = a(parami, bool);
        if (localak == null) {
          break label664;
        }
        paramx.add(localak);
        if (!parami.o) {
          break label664;
        }
        if (parami.s == null) {
          break label179;
        }
        paramString = parami.s.e;
      }
    }
    label179:
    label664:
    for (;;)
    {
      break;
      bool = false;
      break label120;
      paramString = new j.b(parami.e, parami.p, parami.c);
      continue;
      if ((!paramx.isEmpty()) || (paramInt == 0))
      {
        parami = new ArrayList();
        paramList = "8";
      }
      switch (paramInt)
      {
      default: 
        paramString = paramList;
      case 1: 
      case 2: 
      case 6: 
      case 0: 
      case 3: 
      case 4: 
        for (;;)
        {
          a(str, paramString, new ak("action", (z[])parami.toArray(new z[parami.size()]), (ak[])paramx.toArray(new ak[paramx.size()])));
          return;
          parami.add(new z("add", "before"));
          parami.add(new z("last", "true"));
          paramString = paramList;
          continue;
          parami.add(new z("add", "after"));
          parami.add(new z("last", "true"));
          paramString = paramList;
          continue;
          parami.add(new z("resume", "true"));
          parami.add(new z("add", "last"));
          paramString = paramList;
          continue;
          parami.add(new z("add", "relay"));
          paramString = "7";
          continue;
          parami.add(new z("add", "update"));
          paramString = "7";
        }
      case 7: 
        parami.add(new z("resume", "true"));
      }
      parami.add(new z("add", "unread"));
      parami.add(new z("index", paramString.c));
      if (paramString.b) {}
      for (paramString = "true";; paramString = "false")
      {
        parami.add(new z("owner", paramString));
        parami.add(new z("last", "true"));
        paramString = paramList;
        break;
      }
    }
  }
  
  final void a(String paramString, ak paramak)
  {
    if (paramak == null) {
      throw new c("Missing location node");
    }
    Object localObject = paramak.a();
    if ((localObject == null) || (!"enc".equals(((ak)localObject).a))) {
      throw new c("invalid location node");
    }
    localObject = f.a((ak)localObject);
    paramak = paramak.a("elapsed", null);
    long l1 = 0L;
    if (paramak != null) {
      l1 = Integer.parseInt(paramak);
    }
    paramak = this.c;
    Log.w("xmpp/reader/on-location-update jid: " + paramString);
    paramak.a.a(Message.obtain(null, 0, 127, 0, new bk(paramString, l1, (f)localObject)));
  }
  
  public final void a(String paramString1, String paramString2, ak paramak)
  {
    paramak = this.r.b(paramak);
    paramak = this.n.a(paramak);
    if (paramak != null)
    {
      z localz2 = new z("type", paramString2);
      paramString2 = new z("type", "set");
      z localz1 = new z("xmlns", "w:web");
      paramString1 = new z("id", paramString1);
      paramak = new ak("enc", new z[] { localz2 }, paramak);
      paramString1 = new ak("iq", new z[] { paramString2, localz1, paramString1 }, paramak);
      this.b.a(paramString1);
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, Integer paramInteger, List<j.b> paramList, List<av> paramList1, final x paramx, final i parami)
  {
    String str = paramString2;
    int i1;
    if (paramString2 == null)
    {
      i1 = this.j + 1;
      this.j = i1;
      str = Integer.toHexString(i1);
    }
    this.d.put(str, new y()
    {
      public final void a(int paramAnonymousInt)
      {
        if (paramx != null) {
          paramx.a(paramAnonymousInt);
        }
      }
      
      public final void a(ak paramAnonymousak, String paramAnonymousString)
      {
        if (this.a != null) {
          this.a.run();
        }
      }
      
      public final void a(Exception paramAnonymousException)
      {
        if (parami != null) {
          parami.a(paramAnonymousException);
        }
      }
    });
    paramString2 = null;
    int i2;
    if (paramList != null)
    {
      i2 = paramList.size();
      paramx = new ak[i2];
      i1 = 0;
      if (i1 < i2)
      {
        paramString2 = (j.b)paramList.get(i1);
        parami = new z("index", paramString2.c);
        if (paramString2.b) {}
        for (paramString2 = "true";; paramString2 = "false")
        {
          paramx[i1] = new ak("item", new z[] { parami, new z("owner", paramString2) });
          i1 += 1;
          break;
        }
      }
      paramString2 = paramx;
    }
    if (paramList1 != null)
    {
      i2 = paramList1.size();
      paramString2 = new ArrayList();
      i1 = 0;
      while (i1 < i2)
      {
        paramList = a((av)paramList1.get(i1));
        if (paramList != null) {
          paramString2.add(paramList);
        }
        i1 += 1;
      }
      paramString2 = (ak[])paramString2.toArray(new ak[paramString2.size()]);
    }
    for (;;)
    {
      paramList = new ArrayList();
      paramList.add(new z("type", paramString1));
      paramList.add(new z("jid", paramString3));
      if ((paramInteger != null) && (paramInteger.intValue() > 0) && (paramInteger.intValue() < 1000000)) {
        paramList.add(new z("modify_tag", paramInteger.toString()));
      }
      paramString2 = new ak("action", null, new ak("chat", (z[])paramList.toArray(new z[paramList.size()]), paramString2));
      if ("clear".equals(paramString1)) {}
      for (paramString1 = "f";; paramString1 = "m")
      {
        a(str, paramString1, paramString2);
        return;
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramString3 = new ak(paramString4, new z[] { new z("call-id", paramString3) });
    paramString1 = new z("to", paramString1);
    paramString2 = new z("id", paramString2);
    this.b.a(new ak("receipt", new z[] { paramString1, paramString2 }, new ak[] { paramString3 }));
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, byte[][] paramArrayOfByte, int[] paramArrayOfInt, boolean[] paramArrayOfBoolean, int paramInt2, byte[] paramArrayOfByte1, int paramInt3, String paramString5, byte paramByte1, byte paramByte2)
  {
    byte b2;
    if (paramArrayOfByte != null)
    {
      b2 = paramArrayOfByte.length;
      if (paramArrayOfInt == null) {
        break label61;
      }
      b1 = paramArrayOfInt.length;
      label20:
      if (paramArrayOfBoolean == null) {
        break label67;
      }
    }
    label61:
    label67:
    for (byte b3 = paramArrayOfBoolean.length;; b3 = 0)
    {
      if ((b2 == b1) && (b2 == b3)) {
        break label73;
      }
      throw new IllegalArgumentException("endpoints, endpointPriorities and endpointEnablePortPredictingLength must be the same length");
      b2 = 0;
      break;
      b1 = 0;
      break label20;
    }
    label73:
    byte b1 = 4;
    if (paramArrayOfByte1 == null) {
      b1 = 3;
    }
    b3 = b1;
    if (paramString5 == null) {
      b3 = b1 - 1;
    }
    ak[] arrayOfak = new ak[b3 + b2 + 1];
    b1 = 1;
    arrayOfak[0] = new ak("audio", new z[] { new z("enc", paramString4), new z("rate", String.valueOf(paramInt1)) });
    paramInt1 = b1;
    if (paramString5 != null)
    {
      paramInt1 = 2;
      arrayOfak[1] = new ak("video", new z[] { new z("enc", paramString5), new z("orientation", String.valueOf(paramByte1)) });
    }
    paramByte1 = 0;
    if (paramByte1 < b2)
    {
      if (paramArrayOfBoolean[paramByte1] != 0)
      {
        paramString5 = new z[2];
        paramString5[0] = new z("priority", String.valueOf(paramArrayOfInt[paramByte1]));
        if (paramArrayOfBoolean[paramByte1] != 0)
        {
          paramString4 = "1";
          label287:
          paramString5[1] = new z("portpredicting", paramString4);
          paramString4 = paramString5;
        }
      }
      for (;;)
      {
        arrayOfak[paramInt1] = new ak("te", paramString4, paramArrayOfByte[paramByte1]);
        paramInt1 += 1;
        paramByte1 += 1;
        break;
        paramString4 = "0";
        break label287;
        paramString4 = new z[1];
        paramString4[0] = new z("priority", String.valueOf(paramArrayOfInt[paramByte1]));
      }
    }
    paramString4 = new z("medium", String.valueOf(paramInt2));
    paramInt2 = paramInt1 + 1;
    arrayOfak[paramInt1] = new ak("net", new z[] { paramString4 });
    if (paramArrayOfByte1 != null)
    {
      paramInt1 = paramInt2 + 1;
      arrayOfak[paramInt2] = new ak("relayelection", null, new ak("te", new z[] { new z("latency", String.valueOf(paramInt3)) }, paramArrayOfByte1));
    }
    for (;;)
    {
      arrayOfak[paramInt1] = new ak("encopt", new z[] { new z("keygen", String.valueOf(paramByte2)) });
      paramString3 = new ak("accept", new z[] { new z("call-id", paramString3) }, arrayOfak);
      paramString1 = new ak("call", new z[] { new z("to", paramString2), new z("id", paramString1) }, paramString3);
      this.b.a(paramString1);
      return;
      paramInt1 = paramInt2;
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString1, int[] paramArrayOfInt1, byte[][] paramArrayOfByte, int[] paramArrayOfInt2, boolean[] paramArrayOfBoolean, int paramInt1, byte[] paramArrayOfByte1, byte paramByte1, String[] paramArrayOfString2, byte paramByte2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfString1.length != paramArrayOfInt1.length) {
      throw new IllegalArgumentException("rates and encodings must be the same length");
    }
    if (paramArrayOfString1.length == 0) {
      throw new IllegalArgumentException("rates and encodings must be non-empty");
    }
    int i3;
    int i1;
    if (paramArrayOfByte != null)
    {
      i3 = paramArrayOfByte.length;
      if (paramArrayOfInt2 == null) {
        break label98;
      }
      i1 = paramArrayOfInt2.length;
      label57:
      if (paramArrayOfBoolean == null) {
        break label104;
      }
    }
    label98:
    label104:
    for (int i2 = paramArrayOfBoolean.length;; i2 = 0)
    {
      if ((i3 == i1) && (i3 == i2)) {
        break label110;
      }
      throw new IllegalArgumentException("endpoints, endpointPriorities and endpointEnablePortPredictingLength must be the same length");
      i3 = 0;
      break;
      i1 = 0;
      break label57;
    }
    label110:
    int i5 = paramArrayOfString1.length;
    if (paramArrayOfByte1 != null)
    {
      i1 = 2;
      if (paramArrayOfString2 == null) {
        break label266;
      }
      i2 = paramArrayOfString2.length;
      label133:
      if ((paramInt5 <= 0) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length <= 0)) {
        break label272;
      }
    }
    ak[] arrayOfak;
    label266:
    label272:
    for (int i4 = 1;; i4 = 0)
    {
      arrayOfak = new ak[i4 + (i2 + (i5 + i3 + i1) + 1)];
      i1 = 0;
      i2 = 0;
      while (i2 < paramArrayOfString1.length)
      {
        arrayOfak[i1] = new ak("audio", new z[] { new z("enc", paramArrayOfString1[i2]), new z("rate", String.valueOf(paramArrayOfInt1[i2])) });
        i2 += 1;
        i1 += 1;
      }
      i1 = 0;
      break;
      i2 = 0;
      break label133;
    }
    i2 = i1;
    if (paramArrayOfString2 != null)
    {
      i4 = 0;
      for (;;)
      {
        i2 = i1;
        if (i4 >= paramArrayOfString2.length) {
          break;
        }
        arrayOfak[i1] = new ak("video", new z[] { new z("enc", paramArrayOfString2[i4]), new z("orientation", String.valueOf(paramByte2)), new z("screen_width", String.valueOf(paramInt2)), new z("screen_height", String.valueOf(paramInt3)) });
        i4 += 1;
        i1 += 1;
      }
    }
    paramInt2 = 0;
    paramByte2 = i2;
    if (paramInt2 < i3)
    {
      if (paramArrayOfBoolean[paramInt2] != 0)
      {
        paramArrayOfInt1 = new z[2];
        paramArrayOfInt1[0] = new z("priority", String.valueOf(paramArrayOfInt2[paramInt2]));
        if (paramArrayOfBoolean[paramInt2] != 0)
        {
          paramArrayOfString1 = "1";
          label471:
          paramArrayOfInt1[1] = new z("portpredicting", paramArrayOfString1);
          paramArrayOfString1 = paramArrayOfInt1;
        }
      }
      for (;;)
      {
        arrayOfak[paramByte2] = new ak("te", paramArrayOfString1, paramArrayOfByte[paramInt2]);
        paramInt2 += 1;
        paramByte2 += 1;
        break;
        paramArrayOfString1 = "0";
        break label471;
        paramArrayOfString1 = new z[1];
        paramArrayOfString1[0] = new z("priority", String.valueOf(paramArrayOfInt2[paramInt2]));
      }
    }
    paramArrayOfString1 = new z("medium", String.valueOf(paramInt1));
    paramInt1 = paramByte2 + 1;
    arrayOfak[paramByte2] = new ak("net", new z[] { paramArrayOfString1 });
    if ((paramInt5 > 0) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length > 0))
    {
      paramArrayOfString1 = new ak("capability", new z[] { new z("ver", String.valueOf(paramInt5)) }, paramArrayOfByte2);
      paramByte2 = paramInt1 + 1;
      arrayOfak[paramInt1] = paramArrayOfString1;
      paramInt1 = paramByte2;
    }
    for (;;)
    {
      if (paramArrayOfByte1 != null)
      {
        arrayOfak[paramInt1] = a(f.a(paramArrayOfByte1), paramInt4, null, null, null);
        arrayOfak[(paramInt1 + 1)] = new ak("encopt", new z[] { new z("keygen", String.valueOf(paramByte1)) });
      }
      paramString3 = new ak("offer", new z[] { new z("call-id", paramString3) }, arrayOfak);
      paramString1 = new ak("call", new z[] { new z("to", paramString2), new z("id", paramString1) }, paramString3);
      this.b.a(paramString1);
      return;
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, byte[][] paramArrayOfByte, int[] paramArrayOfInt)
  {
    int i1;
    if (paramArrayOfByte != null)
    {
      i1 = paramArrayOfByte.length;
      if (paramArrayOfInt == null) {
        break label44;
      }
    }
    label44:
    for (int i2 = paramArrayOfInt.length;; i2 = 0)
    {
      if (i1 == i2) {
        break label50;
      }
      throw new IllegalArgumentException("endpoints and latencies must be the same length");
      i1 = 0;
      break;
    }
    label50:
    ak[] arrayOfak = new ak[i1];
    i2 = 0;
    while (i2 < i1)
    {
      z localz = new z("latency", String.valueOf(paramArrayOfInt[i2]));
      byte[] arrayOfByte = paramArrayOfByte[i2];
      arrayOfak[i2] = new ak("te", new z[] { localz }, arrayOfByte);
      i2 += 1;
    }
    paramString3 = new ak("relaylatency", new z[] { new z("call-id", paramString3) }, arrayOfak);
    paramString1 = new ak("call", new z[] { new z("to", paramString2), new z("id", paramString1) }, paramString3);
    this.b.a(paramString1);
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, byte[][] paramArrayOfByte, int[] paramArrayOfInt, boolean[] paramArrayOfBoolean, int paramInt1, int paramInt2, byte[] paramArrayOfByte1)
  {
    int i1;
    int i2;
    if (paramArrayOfByte != null)
    {
      i1 = paramArrayOfByte.length;
      if (paramArrayOfInt == null) {
        break label61;
      }
      i2 = paramArrayOfInt.length;
      label20:
      if (paramArrayOfBoolean == null) {
        break label67;
      }
    }
    label61:
    label67:
    for (int i3 = paramArrayOfBoolean.length;; i3 = 0)
    {
      if ((i1 == i2) && (i1 == i3)) {
        break label73;
      }
      throw new IllegalArgumentException("endpoints, endpointPriorities and endpointEnablePortPredictingLength must be the same length");
      i1 = 0;
      break;
      i2 = 0;
      break label20;
    }
    label73:
    ak[] arrayOfak;
    label107:
    Object localObject;
    if ((paramInt2 > 0) && (paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0))
    {
      i2 = 1;
      arrayOfak = new ak[i2 + (i1 + 1)];
      i2 = 0;
      if (i2 >= i1) {
        break label257;
      }
      if (paramArrayOfBoolean[i2] == 0) {
        break label226;
      }
      z localz = new z("priority", String.valueOf(paramArrayOfInt[i2]));
      if (paramArrayOfBoolean[i2] == 0) {
        break label218;
      }
      localObject = "1";
      label155:
      localObject = new z[] { localz, new z("portpredicting", (String)localObject) };
    }
    for (;;)
    {
      arrayOfak[i2] = new ak("te", (z[])localObject, paramArrayOfByte[i2]);
      i2 += 1;
      break label107;
      i2 = 0;
      break;
      label218:
      localObject = "0";
      break label155;
      label226:
      localObject = new z[1];
      localObject[0] = new z("priority", String.valueOf(paramArrayOfInt[i2]));
    }
    label257:
    arrayOfak[i2] = new ak("net", new z[] { new z("medium", String.valueOf(paramInt1)) });
    if ((paramInt2 > 0) && (paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 0)) {
      arrayOfak[(i2 + 1)] = new ak("capability", new z[] { new z("ver", String.valueOf(paramInt2)) }, paramArrayOfByte1);
    }
    paramString3 = new ak("transport", new z[] { new z("call-id", paramString3) }, arrayOfak);
    paramString1 = new ak("call", new z[] { new z("to", paramString2), new z("id", paramString1) }, paramString3);
    this.b.a(paramString1);
  }
  
  public final void a(String paramString1, String paramString2, List<String> paramList, final x paramx, final i parami)
  {
    String str = paramString1;
    if (paramString1 == null)
    {
      i1 = this.j + 1;
      this.j = i1;
      str = Integer.toHexString(i1);
    }
    this.d.put(str, new y()
    {
      public final void a(int paramAnonymousInt)
      {
        if (paramx != null) {
          paramx.a(paramAnonymousInt);
        }
      }
      
      public final void a(ak paramAnonymousak, String paramAnonymousString)
      {
        if (this.a != null) {
          this.a.run();
        }
      }
      
      public final void a(Exception paramAnonymousException)
      {
        if (parami != null) {
          parami.a(paramAnonymousException);
        }
      }
    });
    paramString1 = new ak[paramList.size()];
    int i1 = 0;
    while (i1 < paramList.size())
    {
      paramString1[i1] = new ak("recipient", new z[] { new z("jid", (String)paramList.get(i1)) });
      i1 += 1;
    }
    a(str, "e", new ak("action", null, new ak("broadcast", new z[] { new z("jid", paramString2), new z("type", "modify") }, paramString1)));
  }
  
  public final void a(String paramString1, List<av> paramList, int paramInt, String paramString2, HashMap<String, String> paramHashMap, final x paramx, final i parami)
  {
    switch (paramInt)
    {
    }
    Object localObject1;
    int i1;
    for (String str = paramString1;; str = str)
    {
      this.d.put(str, new y()
      {
        public final void a(int paramAnonymousInt)
        {
          if (paramx != null) {
            paramx.a(paramAnonymousInt);
          }
        }
        
        public final void a(ak paramAnonymousak, String paramAnonymousString)
        {
          if (this.a != null) {
            this.a.run();
          }
        }
        
        public final void a(Exception paramAnonymousException)
        {
          if (parami != null) {
            parami.a(paramAnonymousException);
          }
        }
      });
      paramx = new ArrayList();
      parami = new ArrayList();
      if (paramHashMap == null) {
        break;
      }
      paramString1 = paramHashMap.keySet().iterator();
      while (paramString1.hasNext())
      {
        localObject1 = (String)paramString1.next();
        parami.add(new z((String)localObject1, (String)paramHashMap.get(localObject1)));
      }
      localObject1 = new StringBuilder("preempt-");
      str = paramString1;
      if (paramString1 == null)
      {
        i1 = this.j + 1;
        this.j = i1;
        str = Integer.toHexString(i1);
      }
    }
    switch (paramInt)
    {
    case 1: 
    case 3: 
    case 25: 
    case 26: 
    default: 
      label320:
      paramString1 = null;
      switch (paramInt)
      {
      case 1: 
      case 3: 
      case 18: 
      case 25: 
      case 26: 
      default: 
        label322:
        paramList = "0";
        label456:
        if (paramString1 != null) {}
        break;
      }
      break;
    }
    for (paramString1 = new ak("response", (z[])parami.toArray(new z[parami.size()]), (ak[])paramx.toArray(new ak[paramx.size()]));; paramString1 = new ak("response", (z[])parami.toArray(new z[parami.size()]), paramString1))
    {
      a(str, paramList, paramString1);
      return;
      paramString1 = paramList.iterator();
      if (paramString1.hasNext())
      {
        paramList = (av)paramString1.next();
        paramHashMap = new ArrayList();
        paramHashMap.add(new z("jid", paramList.d));
        paramHashMap.add(new z("count", Integer.toString(paramList.j)));
        if (paramList.a != null) {
          paramHashMap.add(new z("name", paramList.a));
        }
        if (paramList.l != 0L) {
          paramHashMap.add(new z("t", Long.toString(paramList.l / 1000L)));
        }
        if (paramList.m != 0L) {
          paramHashMap.add(new z("mute", Long.toString(paramList.m / 1000L)));
        }
        if (paramList.p) {
          paramHashMap.add(new z("archive", "true"));
        }
        if (paramList.o) {
          paramHashMap.add(new z("read_only", "true"));
        }
        if (paramList.q) {
          paramHashMap.add(new z("message", "true"));
        }
        if ((paramList.k > 0) && (paramList.k < 1000000)) {
          paramHashMap.add(new z("modify_tag", Integer.toString(paramList.k)));
        }
        if (paramList.r) {
          paramHashMap.add(new z("spam", "false"));
        }
        if (paramList.n > 0L) {
          paramHashMap.add(new z("pin", String.valueOf(paramList.n / 1000L)));
        }
        switch (paramList.i)
        {
        }
        for (;;)
        {
          paramx.add(new ak("chat", (z[])paramHashMap.toArray(new z[paramHashMap.size()])));
          break;
          paramHashMap.add(new z("type", "clear"));
          continue;
          paramHashMap.add(new z("type", "delete"));
          continue;
          paramHashMap.add(new z("type", "ahead"));
        }
      }
      if (6 == paramInt) {}
      for (paramString1 = "resume";; paramString1 = "chat")
      {
        parami.add(new z("type", paramString1));
        if ((paramString2 == null) || (6 != paramInt)) {
          break;
        }
        parami.add(new z("checksum", paramString2));
        paramString1 = null;
        break label322;
      }
      parami.add(new z("type", "chat"));
      parami.add(new z("duplicate", "true"));
      paramString1 = null;
      break label322;
      a(paramList, paramx);
      parami.add(new z("type", "contacts"));
      if (paramString2 == null) {
        break;
      }
      parami.add(new z("checksum", paramString2));
      paramString1 = null;
      break label322;
      parami.add(new z("type", "contacts"));
      parami.add(new z("duplicate", "true"));
      paramString1 = null;
      break label322;
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramList = a((av)paramString1.next());
        if (paramList != null) {
          paramx.add(paramList);
        }
      }
      switch (paramInt)
      {
      case 21: 
      case 22: 
      default: 
        paramString1 = "message";
      }
      for (;;)
      {
        parami.add(new z("type", paramString1));
        paramString1 = null;
        break;
        parami.add(new z("last", "true"));
        paramString1 = "search";
        continue;
        paramString1 = "star";
        continue;
        paramString1 = "media_message";
      }
      parami.add(new z("type", "media"));
      if (paramList.size() != 1) {
        break;
      }
      paramString1 = (av)paramList.get(0);
      switch (paramString1.i)
      {
      default: 
        parami.add(new z("code", "404"));
        paramString1 = null;
        break;
      case 200: 
        if (paramString1.h != null) {
          parami.add(new z("url", paramString1.h));
        }
        if (paramString1.w != null) {
          parami.add(new z("media_key", m.a(paramString1.w)));
        }
      case 400: 
      case 404: 
      case 502: 
        parami.add(new z("code", Integer.toString(paramString1.i)));
        paramString1 = null;
        break;
        paramList = paramList.iterator();
        int i2;
        Object localObject2;
        while (paramList.hasNext())
        {
          paramString2 = (av)paramList.next();
          i2 = paramString2.t.size();
          paramHashMap = new ak[i2];
          i1 = 0;
          if (i1 < i2)
          {
            localObject1 = (av.a)paramString2.t.get(i1);
            localObject2 = new z("index", ((av.a)localObject1).a);
            if (((av.a)localObject1).d) {}
            for (paramString1 = "true";; paramString1 = "false")
            {
              paramHashMap[i1] = new ak("item", new z[] { localObject2, new z("owner", paramString1), new z("status", Integer.toString(((av.a)localObject1).b)) });
              i1 += 1;
              break;
            }
          }
          paramx.add(new ak("receipt", new z[] { new z("jid", paramString2.d), new z("t", Long.toString(paramString2.l / 1000L)) }, paramHashMap));
        }
        parami.add(new z("type", "receipt"));
        paramString1 = null;
        break;
        parami.add(new z("type", "group"));
        if (paramList.size() != 1) {
          break label320;
        }
        paramString1 = (av)paramList.get(0);
        if ((paramString1.d == null) && (paramString1.l == 0L) && ((paramString1.t == null) || (paramString1.t.size() == 0)))
        {
          paramString1 = new ak("group", new z[] { new z("type", "missing") });
          paramx.add(paramString1);
          paramString1 = null;
          break;
        }
        if (paramString1.t == null)
        {
          i1 = 0;
          paramList = new ArrayList();
          i2 = 0;
          label2041:
          if (i2 >= i1) {
            break label2174;
          }
          paramString2 = (av)paramString1.t.get(i2);
          if (!paramString2.p) {
            break label2168;
          }
        }
        label2168:
        for (int i3 = 2;; i3 = 1)
        {
          paramHashMap = new z[i3];
          paramHashMap[0] = new z("jid", paramString2.d);
          if (paramString2.p) {
            paramHashMap[1] = new z("type", "admin");
          }
          paramList.add(new ak("participant", paramHashMap));
          i2 += 1;
          break label2041;
          i1 = paramString1.t.size();
          break;
        }
        label2174:
        if (paramString1.d != null)
        {
          i1 = 1;
          label2184:
          if (paramString1.l == 0L) {
            break label2316;
          }
          i2 = 1;
          label2196:
          paramString2 = new z[i1 + i2];
          if (paramString1.d != null) {
            paramString2[0] = new z("creator", paramString1.d);
          }
          if (paramString1.l != 0L) {
            if (paramString1.d == null) {
              break label2322;
            }
          }
        }
        label2316:
        label2322:
        for (i1 = 1;; i1 = 0)
        {
          paramString2[i1] = new z("create", Long.toString(paramString1.l / 1000L));
          paramString1 = new ak("group", paramString2, (ak[])paramList.toArray(new ak[paramList.size()]));
          break;
          i1 = 0;
          break label2184;
          i2 = 0;
          break label2196;
        }
        parami.add(new z("type", "preview"));
        if (paramList.size() != 1) {
          break label320;
        }
        paramList = (av)paramList.get(0);
        if (paramList.c == null)
        {
          paramString1 = new z[1];
          paramString1[0] = new z("type", "missing");
          label2398:
          if (paramList.c != null) {
            break label2457;
          }
        }
        label2457:
        for (paramList = null;; paramList = paramList.u)
        {
          paramx.add(new ak("preview", paramString1, paramList));
          paramString1 = null;
          break;
          paramString1 = new z[1];
          paramString1[0] = new z("id", paramList.c);
          break label2398;
        }
        parami.add(new z("type", "action"));
        paramString1 = paramList.iterator();
        while (paramString1.hasNext())
        {
          paramList = (av)paramString1.next();
          paramx.add(new ak("item", new z[] { new z("id", paramList.c), new z("code", Integer.toString(paramList.i)) }));
        }
        paramString1 = null;
        break;
        parami.add(new z("type", "action"));
        parami.add(new z("replaced", "true"));
        paramString1 = null;
        break;
        parami.add(new z("type", "emoji"));
        paramString1 = paramList.iterator();
        while (paramString1.hasNext())
        {
          paramList = (av)paramString1.next();
          paramx.add(new ak("item", new z[] { new z("code", paramList.c), new z("value", Float.toString(paramList.v)) }));
        }
        paramString1 = null;
        break;
        parami.add(new z("type", "message_info"));
        if (paramList.size() != 1) {
          break label320;
        }
        paramString1 = (av)paramList.get(0);
        parami.add(new z("count", Integer.toString(paramString1.j)));
        paramList = new ArrayList();
        paramString2 = new ArrayList();
        paramHashMap = new ArrayList();
        i1 = 0;
        if (i1 < paramString1.t.size())
        {
          localObject1 = (av.a)paramString1.t.get(i1);
          localObject2 = new ak("item", new z[] { new z("jid", ((av.a)localObject1).a), new z("t", Long.toString(((av.a)localObject1).c / 1000L)) });
          switch (((av.a)localObject1).b)
          {
          }
          for (;;)
          {
            i1 += 1;
            break;
            paramList.add(localObject2);
            continue;
            paramString2.add(localObject2);
            continue;
            paramHashMap.add(localObject2);
          }
        }
        if (!paramList.isEmpty()) {
          paramx.add(new ak("delivery", null, (ak[])paramList.toArray(new ak[paramList.size()])));
        }
        if (!paramString2.isEmpty()) {
          paramx.add(new ak("read", null, (ak[])paramString2.toArray(new ak[paramString2.size()])));
        }
        if (!paramHashMap.isEmpty()) {
          paramx.add(new ak("played", null, (ak[])paramHashMap.toArray(new ak[paramHashMap.size()])));
        }
        paramString1 = null;
        break;
        if (paramList.size() != 1) {
          break label320;
        }
        parami.add(new z("type", "identity"));
        paramString1 = (av)paramList.get(0);
        paramx.add(new ak("raw", null, paramString1.u));
        paramx.add(new ak("text", null, paramString1.a));
        paramString1 = null;
        break;
        if (paramList.size() != 1) {
          break label320;
        }
        parami.add(new z("type", "url"));
        paramString1 = (av)paramList.get(0);
        if (paramString1.b != null) {
          parami.add(new z("title", paramString1.b));
        }
        if (paramString1.a != null) {
          parami.add(new z("description", paramString1.a));
        }
        if (paramString1.h != null) {
          parami.add(new z("canonical-url", paramString1.h));
        }
        if (paramString1.g != null) {
          parami.add(new z("matched-text", paramString1.g));
        }
        paramString1 = paramString1.u;
        break;
        parami.add(new z("type", "status"));
        parami.add(new z("checksum", paramString2));
        paramString1 = paramList.iterator();
        while (paramString1.hasNext())
        {
          paramHashMap = (av)paramString1.next();
          paramList = new ArrayList();
          paramList.add(new z("jid", paramHashMap.d));
          paramList.add(new z("unread", String.valueOf(paramHashMap.i)));
          paramList.add(new z("count", String.valueOf(paramHashMap.j)));
          paramList.add(new z("t", String.valueOf(paramHashMap.l)));
          paramString2 = new ArrayList();
          if ((paramHashMap.u != null) && (paramHashMap.u.length > 0)) {
            paramString2.add(new ak("picture", null, paramHashMap.u));
          }
          if (paramHashMap.y != null)
          {
            paramHashMap = paramHashMap.y.iterator();
            while (paramHashMap.hasNext()) {
              paramString2.add(a((av)paramHashMap.next()));
            }
          }
          paramx.add(new ak("status", (z[])paramList.toArray(new z[paramList.size()]), (ak[])paramString2.toArray(new ak[paramString2.size()])));
        }
        paramString1 = null;
        break;
        parami.add(new z("type", "status"));
        paramString1 = paramList.iterator();
        while (paramString1.hasNext()) {
          paramx.add(a((av)paramString1.next()));
        }
        paramList = "4";
        break label456;
        paramList = "5";
        break label456;
        paramList = "2";
        break label456;
        paramList = "3";
        break label456;
        paramList = "1";
        break label456;
        paramList = "6";
        break label456;
        paramList = "h";
        break label456;
        paramList = "i";
        break label456;
        paramList = "j";
        break label456;
        paramList = "k";
        break label456;
        paramList = "l";
        break label456;
        paramList = "n";
        break label456;
        paramList = "o";
        break label456;
        paramList = "p";
        break label456;
        paramList = "q";
        break label456;
        paramList = "u";
        break label456;
      }
    }
  }
  
  public final void a(String paramString, List<String> paramList, final am paramam, final x paramx, aw paramaw)
  {
    if (paramaw != null) {}
    for (String str = paramaw.a;; str = Integer.toHexString(i1))
    {
      this.d.put(str, new y()
      {
        public final void a(int paramAnonymousInt, String paramAnonymousString)
        {
          if (paramx != null)
          {
            int i = paramAnonymousInt;
            if (paramAnonymousInt == 500)
            {
              i = paramAnonymousInt;
              if (paramAnonymousString != null)
              {
                i = paramAnonymousInt;
                if (paramAnonymousString.equals("internal-server-error")) {
                  i = 65036;
                }
              }
            }
            paramx.a(i);
          }
        }
        
        public final void a(ak paramAnonymousak, String paramAnonymousString)
        {
          Object localObject = paramAnonymousak.a();
          ak.a((ak)localObject, "group");
          paramAnonymousString = b.b(((ak)localObject).a("id", null));
          String str1 = ((ak)localObject).a("creator", null);
          String str2 = ((ak)localObject).a("creation", null);
          long l1 = 0L;
          try
          {
            l2 = Long.parseLong(str2);
            l1 = l2 * 1000L;
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            long l2;
            String str3;
            for (;;) {}
          }
          str2 = ((ak)localObject).a("subject", null);
          str3 = ((ak)localObject).a("s_t", null);
          l2 = 0L;
          try
          {
            long l3 = Long.parseLong(str3);
            l2 = l3 * 1000L;
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            HashMap localHashMap1;
            HashMap localHashMap2;
            for (;;) {}
          }
          str3 = ((ak)localObject).a("s_o", null);
          localObject = ((ak)localObject).a("type", null);
          localHashMap1 = new HashMap();
          localHashMap2 = new HashMap();
          b.a(paramAnonymousak, localHashMap1, localHashMap2, "group");
          Log.i("groupmgr/onGroupCreated/" + paramAnonymousString + "/" + str1 + "/" + l1 + "/" + str2 + "/" + str3 + "/" + l2 + "/" + (String)localObject + "/" + localHashMap1.keySet());
          if (!localHashMap2.isEmpty()) {
            qz.a(36, localHashMap2);
          }
          if (paramam != null) {
            paramam.a(paramAnonymousString);
          }
        }
      });
      paramam = null;
      if (paramList.size() <= 0) {
        break;
      }
      paramam = new ak[paramList.size()];
      i1 = 0;
      while (i1 < paramam.length)
      {
        paramam[i1] = new ak("participant", new z[] { new z("jid", (String)paramList.get(i1)) });
        i1 += 1;
      }
      i1 = this.j + 1;
      this.j = i1;
    }
    boolean bool1 = TextUtils.isEmpty(null);
    boolean bool2 = TextUtils.isEmpty(null);
    int i2;
    if (bool1)
    {
      i1 = 0;
      if (!bool2) {
        break label387;
      }
      i2 = 0;
      label169:
      paramList = new z[i2 + (i1 + 1)];
      paramList[0] = new z("subject", paramString);
      if (!bool1) {
        paramList[1] = new z("type", null);
      }
      if (!bool2)
      {
        if (!bool1) {
          break label393;
        }
        i1 = 1;
        label226:
        paramList[i1] = new z("key", null);
      }
      if (paramam != null) {
        break label399;
      }
      paramString = new ak("create", paramList);
      label257:
      if (paramaw != null) {
        break label415;
      }
    }
    label387:
    label393:
    label399:
    label415:
    for (int i1 = 4;; i1 = 5)
    {
      paramList = new z[i1];
      paramList[0] = new z("xmlns", "w:g2");
      paramList[1] = new z("id", str);
      paramList[2] = new z("type", "set");
      paramList[3] = new z("to", "g.us");
      if (paramaw != null) {
        paramList[4] = new z("web", paramaw.b);
      }
      paramString = new ak("iq", paramList, paramString);
      this.b.a(paramString);
      return;
      i1 = 1;
      break;
      i2 = 1;
      break label169;
      i1 = 2;
      break label226;
      paramString = new ak("create", paramList, paramam);
      break label257;
    }
  }
  
  public final void a(String paramString1, List<String> paramList, String paramString2, String paramString3, aw paramaw)
  {
    int i2 = paramList.size();
    ak[] arrayOfak = new ak[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfak[i1] = new ak("participant", new z[] { new z("jid", (String)paramList.get(i1)) });
      i1 += 1;
    }
    paramList = new ak(paramString3, null, arrayOfak);
    if (paramaw == null) {}
    for (i1 = 4;; i1 = 5)
    {
      paramString3 = new z[i1];
      paramString3[0] = new z("id", paramString2);
      paramString3[1] = new z("xmlns", "w:g2");
      paramString3[2] = new z("type", "set");
      paramString3[3] = new z("to", paramString1);
      if (paramaw != null) {
        paramString3[4] = new z("web", paramaw.b);
      }
      paramString1 = new ak("iq", paramString3, paramList);
      this.b.a(paramString1);
      return;
    }
  }
  
  public final void a(String paramString, ak[] paramArrayOfak, final x paramx, final i parami)
  {
    String str = paramString;
    if (paramString == null)
    {
      int i1 = this.j + 1;
      this.j = i1;
      str = Integer.toHexString(i1);
    }
    this.d.put(str, new y()
    {
      public final void a(int paramAnonymousInt)
      {
        if (paramx != null) {
          paramx.a(paramAnonymousInt);
        }
      }
      
      public final void a(ak paramAnonymousak, String paramAnonymousString)
      {
        if (this.a != null) {
          this.a.run();
        }
      }
      
      public final void a(Exception paramAnonymousException)
      {
        if (parami != null) {
          parami.a(paramAnonymousException);
        }
      }
    });
    a(str, "a", new ak("action", null, paramArrayOfak));
  }
  
  public final void a(String paramString, final String[] paramArrayOfString)
  {
    Object localObject = paramString;
    if (paramString == null)
    {
      i1 = this.j + 1;
      this.j = i1;
      localObject = Integer.toHexString(i1);
    }
    this.d.put(localObject, new y()
    {
      public final void a(ak paramAnonymousak, String paramAnonymousString)
      {
        ak localak1 = ak.a(paramAnonymousak.e("list"));
        paramAnonymousString = new HashSet(paramArrayOfString.length);
        HashMap localHashMap = new HashMap(paramArrayOfString.length);
        Object localObject1;
        Object localObject2;
        if (localak1.c != null)
        {
          i = 0;
          Object localObject5;
          for (;;)
          {
            if (i >= localak1.c.length) {
              break label517;
            }
            localObject5 = localak1.c[i];
            localObject1 = ((ak)localObject5).b("jid");
            if (localObject1 == null) {
              throw new c("missing jid on user node");
            }
            paramAnonymousak = ((ak)localObject5).e("error");
            if (paramAnonymousak != null)
            {
              paramAnonymousak = paramAnonymousak.a("code");
              try
              {
                localObject2 = Integer.valueOf(paramAnonymousak);
                paramAnonymousString.add(localObject1);
                localHashMap.put(localObject1, localObject2);
                i += 1;
              }
              catch (NumberFormatException paramAnonymousString)
              {
                throw new c("error node should have numeric code attribute: " + paramAnonymousak);
              }
            }
          }
          Object localObject4 = ak.a(((ak)localObject5).e("identity"));
          Object localObject3 = ak.a(((ak)localObject5).e("registration"));
          localObject2 = ak.a(((ak)localObject5).e("type"));
          if ((((ak)localObject2).d == null) || (((ak)localObject2).d.length != 1)) {
            throw new c("type node should contain exactly 1 byte");
          }
          Object localObject6 = ((ak)localObject5).e("key");
          if (localObject6 != null)
          {
            paramAnonymousak = ak.a(((ak)localObject6).e("id"));
            localObject6 = ak.a(((ak)localObject6).e("value"));
          }
          for (paramAnonymousak = new aj(paramAnonymousak.d, ((ak)localObject6).d, null);; paramAnonymousak = null)
          {
            Object localObject7 = ak.a(((ak)localObject5).e("skey"));
            localObject5 = ak.a(((ak)localObject7).e("id"));
            localObject6 = ak.a(((ak)localObject7).e("value"));
            ak localak2 = ak.a(((ak)localObject7).e("signature"));
            localObject7 = b.this.c;
            localObject4 = ((ak)localObject4).d;
            localObject3 = ((ak)localObject3).d;
            byte b1 = localObject2.d[0];
            localObject2 = new aj(((ak)localObject5).d, ((ak)localObject6).d, localak2.d);
            Log.i("xmpp/reader/on-get-pre-key-success");
            localObject5 = ((aa)localObject7).a;
            localObject6 = new Bundle();
            ((Bundle)localObject6).putString("jid", (String)localObject1);
            ((Bundle)localObject6).putByteArray("identity", (byte[])localObject4);
            ((Bundle)localObject6).putByteArray("registration", (byte[])localObject3);
            ((Bundle)localObject6).putByte("type", b1);
            ((Bundle)localObject6).putParcelable("preKey", new ParcelablePreKey(paramAnonymousak));
            ((Bundle)localObject6).putParcelable("signedPreKey", new ParcelablePreKey((aj)localObject2));
            ((u.a)localObject5).a(Message.obtain(null, 0, 81, 0, localObject6));
            paramAnonymousString.add(localObject1);
            break;
          }
        }
        label517:
        paramAnonymousak = paramArrayOfString;
        int j = paramAnonymousak.length;
        int i = 0;
        while (i < j)
        {
          localak1 = paramAnonymousak[i];
          if (!paramAnonymousString.contains(localak1))
          {
            localObject1 = b.this.c;
            Log.i("xmpp/reader/on-get-pre-key-none");
            localObject1 = ((aa)localObject1).a;
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("jid", localak1);
            ((u.a)localObject1).a(Message.obtain(null, 0, 82, 0, localObject2));
          }
          if (localHashMap.containsKey(localak1))
          {
            localObject1 = b.this.c;
            int k = ((Integer)localHashMap.get(localak1)).intValue();
            Log.i("xmpp/reader/on-get-pre-key-error");
            localObject1 = ((aa)localObject1).a;
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("jid", localak1);
            ((Bundle)localObject2).putInt("errorCode", k);
            ((u.a)localObject1).a(Message.obtain(null, 0, 83, 0, localObject2));
          }
          i += 1;
        }
      }
    });
    paramString = new ak[paramArrayOfString.length];
    int i1 = 0;
    while (i1 < paramArrayOfString.length)
    {
      paramString[i1] = new ak("user", new z[] { new z("jid", paramArrayOfString[i1]) });
      i1 += 1;
    }
    paramArrayOfString = new z("id", (String)localObject);
    localObject = new z("xmlns", "encrypt");
    z localz1 = new z("type", "get");
    z localz2 = new z("to", "s.whatsapp.net");
    paramString = new ak("key", null, paramString);
    paramString = new ak("iq", new z[] { paramArrayOfString, localObject, localz1, localz2 }, paramString);
    this.b.a(paramString);
  }
  
  public final void a(Map<String, Long> paramMap, y paramy)
  {
    int i1 = this.j + 1;
    this.j = i1;
    String str1 = Integer.toHexString(i1);
    this.d.put(str1, paramy);
    paramy = new ArrayList();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      String str2 = (String)localEntry.getKey();
      long l1 = ((Long)localEntry.getValue()).longValue() / 1000L;
      if (l1 == 0L) {
        paramy.add(new ak("user", new z[] { new z("jid", str2) }));
      } else {
        paramy.add(new ak("user", new z[] { new z("jid", str2), new z("t", Long.toString(l1)) }));
      }
    }
    paramMap = new ak("status", null, (ak[])paramy.toArray(new ak[paramy.size()]));
    paramMap = new ak("iq", new z[] { new z("id", str1), new z("xmlns", "status"), new z("type", "get"), new z("to", "s.whatsapp.net") }, paramMap);
    this.b.a(paramMap);
  }
  
  public final void a(String[] paramArrayOfString, final Runnable paramRunnable, final x paramx)
  {
    int i1 = this.j + 1;
    this.j = i1;
    String str = Integer.toHexString(i1);
    this.d.put(str, new y()
    {
      public final void a(int paramAnonymousInt)
      {
        if (paramx != null) {
          paramx.a(paramAnonymousInt);
        }
      }
      
      public final void a(ak paramAnonymousak, String paramAnonymousString)
      {
        if (paramRunnable != null) {
          paramRunnable.run();
        }
      }
    });
    paramRunnable = new ak[1];
    i1 = 0;
    while (i1 <= 0)
    {
      paramRunnable[0] = new ak("list", new z[] { new z("id", paramArrayOfString[0]) });
      i1 += 1;
    }
    paramArrayOfString = new ak("delete", null, paramRunnable);
    paramArrayOfString = new ak("iq", new z[] { new z("id", str), new z("xmlns", "w:b"), new z("type", "set"), new z("to", "s.whatsapp.net") }, paramArrayOfString);
    this.b.a(paramArrayOfString);
  }
  
  public final void b()
  {
    try
    {
      int i1 = this.j + 1;
      this.j = i1;
      Object localObject1 = Integer.toHexString(i1);
      this.d.put(localObject1, new y()
      {
        public final void a(int paramAnonymousInt)
        {
          if (this.b != null) {
            this.b.a(paramAnonymousInt);
          }
        }
        
        public final void a(ak paramAnonymousak, String paramAnonymousString)
        {
          paramAnonymousak = paramAnonymousak.e("lists");
          if (paramAnonymousak != null)
          {
            paramAnonymousak = paramAnonymousak.f("list").iterator();
            label364:
            while (paramAnonymousak.hasNext())
            {
              Object localObject1 = (ak)paramAnonymousak.next();
              paramAnonymousString = ((ak)localObject1).a("id", null);
              String str = ((ak)localObject1).a("name", null);
              Object localObject2 = ((ak)localObject1).f("recipient");
              localObject1 = new String[((List)localObject2).size()];
              localObject2 = ((List)localObject2).iterator();
              int i = 0;
              while (((Iterator)localObject2).hasNext())
              {
                localObject1[i] = ((ak)((Iterator)localObject2).next()).a("jid", null);
                i += 1;
              }
              localObject2 = b.this.g;
              Log.i("groupmgr/onParticipatingList/jid:" + paramAnonymousString + "/name:" + str + "/recipients:" + Arrays.deepToString((Object[])localObject1));
              if (!j.c(paramAnonymousString))
              {
                if ((!((qz)localObject2).f.a(paramAnonymousString)) && (!((qz)localObject2).p.e(paramAnonymousString)))
                {
                  localObject1 = new ArrayList(Arrays.asList((Object[])localObject1));
                  ((qz)localObject2).a(paramAnonymousString, (Iterable)localObject1);
                  j localj = new j(((qz)localObject2).e, paramAnonymousString, str);
                  localj.n = ((qz)localObject2).d.b();
                  localj.d = 6;
                  localj.t = 9L;
                  localj.N = localObject1;
                  localj.f = ((qz)localObject2).e.c().t;
                  qz.a(0, localj);
                }
                for (;;)
                {
                  if (((qz)localObject2).i.c(paramAnonymousString) != null) {
                    break label364;
                  }
                  ((qz)localObject2).i.a(paramAnonymousString, str, System.currentTimeMillis());
                  break;
                  Log.i("groupmgr/onParticipatingList/jid:" + paramAnonymousString + " already exists");
                }
              }
            }
          }
          paramAnonymousak = b.this.g;
          Log.i("groupmgr/onParticipatingList/onParticipatingListsComplete");
          paramAnonymousak.m.b(false);
          if (this.a != null) {
            this.a.run();
          }
        }
      });
      ak localak = new ak("lists", null);
      localObject1 = new ak("iq", new z[] { new z("id", (String)localObject1), new z("xmlns", "w:b"), new z("type", "get"), new z("to", "s.whatsapp.net") }, localak);
      this.b.a((ak)localObject1);
      return;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  public final void c()
  {
    ak localak = new ak("presence", new z[] { new z("type", "available") });
    this.b.a(localak);
  }
  
  public final boolean d()
  {
    long l1 = 0L;
    int i2 = 0;
    int i3 = 0;
    int i1 = 0;
    for (;;)
    {
      try
      {
        localObject3 = this.m.a();
        if (localObject3 == null) {
          return false;
        }
      }
      catch (IOException localIOException)
      {
        Log.d("xmpp/reader/read/next-tree", localIOException);
        localObject3 = this.d.entrySet().iterator();
        if (((Iterator)localObject3).hasNext())
        {
          ((y)((Map.Entry)((Iterator)localObject3).next()).getValue()).a(localIOException);
          continue;
        }
        this.d.clear();
        throw localIOException;
      }
      catch (r localr)
      {
        Log.d("xmpp/reader/read/next-tree", localr);
        throw localr;
      }
      catch (Throwable localThrowable)
      {
        Log.d("xmpp/reader/read/next-tree", localThrowable);
        throw new r(localThrowable, this.m.b());
        try
        {
          if (!ak.b((ak)localObject3, "iq")) {
            continue;
          }
          localObject6 = ((ak)localObject3).a("type", null);
          String str = ((ak)localObject3).a("id", null);
          localObject4 = ((ak)localObject3).a("from", null);
          localObject5 = ((ak)localObject3).a("xmlns", null);
          if (localObject6 == null) {
            throw new c("missing 'type' attribute in iq stanza", this.m.b());
          }
        }
        catch (RuntimeException localRuntimeException)
        {
          Log.d("xmpp/reader/read/handle-tree", localRuntimeException);
          throw new r(localRuntimeException, this.m.b());
        }
        if (((String)localObject6).equals("result"))
        {
          localObject5 = (y)this.d.remove(localRuntimeException);
          if (localObject5 != null) {
            ((y)localObject5).a((ak)localObject3, (String)localObject4);
          }
          if (localRuntimeException != null)
          {
            localObject3 = this.c;
            Log.i("xmpp/reader/on-iq-response; id=" + localRuntimeException);
            ((aa)localObject3).a.a(localRuntimeException);
          }
        }
        else
        {
          if (((String)localObject6).equals("error"))
          {
            localObject4 = (y)this.d.remove(localRuntimeException);
            if (localObject4 == null) {
              continue;
            }
            ((y)localObject4).a((ak)localObject3);
            continue;
          }
          if (((String)localObject6).equals("get"))
          {
            localObject6 = ((ak)localObject3).a();
            if ("urn:xmpp:ping".equals(localObject5))
            {
              localObject3 = ((ak)localObject3).a("t", null);
              l2 = l1;
              if (localObject3 == null) {}
            }
          }
        }
      }
      catch (c localNumberFormatException3)
      {
        try
        {
          Object localObject6;
          Object localObject5;
          l2 = Long.parseLong((String)localObject3);
          localObject3 = this.c;
          Log.i("xmpp/reader/read/ping");
          localObject3 = ((aa)localObject3).a;
          localObject4 = Message.obtain(null, 0, 6, 0);
          ((Message)localObject4).getData().putLong("timestamp", l2);
          ((u.a)localObject3).a((Message)localObject4);
          continue;
          if ((!ak.b((ak)localObject6, "relay")) || (localObject4 == null)) {
            continue;
          }
          localObject4 = ((ak)localObject6).a("pin", null);
          localObject3 = ((ak)localObject6).a("timeout", null);
          ((ak)localObject6).a("ip", null);
          if (localObject3 != null) {}
          try
          {
            Integer.parseInt((String)localObject3);
            if (localObject4 == null) {
              continue;
            }
            Log.e("onRelayRequest");
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            throw new c("relay-iq exception parsing timeout attribute: " + (String)localObject3, this.m.b());
          }
          if (((String)localObject6).equals("set"))
          {
            localObject6 = ((ak)localObject3).a();
            if (!"location".equals(localObject5)) {
              continue;
            }
            localObject3 = ((ak)localObject3).b("participant");
            if (ak.b((ak)localObject6, "start"))
            {
              localObject5 = ((ak)localObject6).b("duration");
              if (localObject5 != null) {
                l1 = Long.parseLong((String)localObject5);
              }
              localObject5 = this.i;
              l1 *= 1000L;
              Log.i("LocationSharingManager/onStartLocationReporting; jid=" + (String)localObject4 + "; duration=" + l1);
              if (((com.whatsapp.location.bp)localObject5).f((String)localObject4))
              {
                localObject5 = new Intent(com.whatsapp.u.a(), LocationSharingService.class);
                ((Intent)localObject5).setAction("com.whatsapp.ShareLocationService.START");
                ((Intent)localObject5).putExtra("duration", l1);
                com.whatsapp.u.a().startService((Intent)localObject5);
                a(localNumberFormatException1, (String)localObject4, (String)localObject3, i1);
                continue;
              }
              Log.w("LocationSharingManager/onStartLocationReporting/sharing not enabled; jid=" + (String)localObject4);
              i1 = 401;
              continue;
            }
            if (ak.b((ak)localObject6, "stop"))
            {
              com.whatsapp.location.bp.b();
              a(localNumberFormatException1, (String)localObject4, (String)localObject3, 0);
              continue;
            }
            if (ak.b((ak)localObject6, "enable"))
            {
              a(localNumberFormatException1, (String)localObject4, (String)localObject3, 0);
              continue;
            }
            a(localNumberFormatException1, (String)localObject4, (String)localObject3, 501);
            continue;
          }
          throw new c("unknown iq type attribute: " + (String)localObject6, this.m.b());
          if (ak.b((ak)localObject3, "ack"))
          {
            d((ak)localObject3);
          }
          else if (ak.b((ak)localObject3, "receipt"))
          {
            c((ak)localObject3);
          }
          else if (ak.b((ak)localObject3, "chatstate"))
          {
            localObject4 = ((ak)localObject3).a();
            localObject1 = ((ak)localObject3).b("from");
            localObject3 = ((ak)localObject3).b("participant");
            if (ak.b((ak)localObject4, "composing"))
            {
              localObject4 = ((ak)localObject4).b("media");
              localObject5 = this.c;
              Log.i("xmpp/reader/read/compose/composing " + (String)localObject1 + " " + (String)localObject3 + " " + (String)localObject4);
              localObject5 = ((aa)localObject5).a;
              i1 = i2;
              if ("audio".equals(localObject4)) {
                i1 = 1;
              }
              localObject4 = new Bundle();
              ((Bundle)localObject4).putString("jid", (String)localObject1);
              ((Bundle)localObject4).putString("author", (String)localObject3);
              ((Bundle)localObject4).putInt("media", i1);
              ((u.a)localObject5).a(Message.obtain(null, 0, 23, 0, localObject4));
            }
            else if (ak.b((ak)localObject4, "paused"))
            {
              localObject4 = this.c;
              Log.i("xmpp/reader/read/compose/paused " + (String)localObject1 + " " + (String)localObject3);
              localObject4 = ((aa)localObject4).a;
              localObject5 = new Bundle();
              ((Bundle)localObject5).putString("jid", (String)localObject1);
              ((Bundle)localObject5).putString("author", (String)localObject3);
              ((u.a)localObject4).a(Message.obtain(null, 0, 24, 0, localObject5));
            }
          }
          else if (ak.b((ak)localObject3, "notification"))
          {
            g((ak)localObject3);
          }
          else if (ak.b((ak)localObject3, "presence"))
          {
            localObject1 = ((ak)localObject3).b("from");
            if (localObject1 != null)
            {
              localObject5 = ((ak)localObject3).b("type");
              localObject4 = ((ak)localObject3).b("name");
              if ("unavailable".equals(localObject5))
              {
                localObject3 = ((ak)localObject3).b("last");
                if (localObject3 == null)
                {
                  l1 = System.currentTimeMillis();
                  localObject3 = this.c;
                  Log.i("xmpp/reader/read/presence/unavailable " + (String)localObject1 + " " + (String)localObject4 + " " + l1);
                  localObject3 = ((aa)localObject3).a;
                  localObject5 = new Bundle();
                  ((Bundle)localObject5).putString("jid", (String)localObject1);
                  ((Bundle)localObject5).putString("pushName", (String)localObject4);
                  ((Bundle)localObject5).putLong("lastSeen", l1);
                  ((u.a)localObject3).a(Message.obtain(null, 0, 70, 0, localObject5));
                }
                else
                {
                  if (("deny".equals(localObject3)) || ("error".equals(localObject3)) || ("none".equals(localObject3))) {
                    break label2400;
                  }
                  l1 = Long.parseLong((String)localObject3) * 1000L;
                  continue;
                }
              }
              else if ("unsubscribe".equals(localObject5))
              {
                localObject3 = this.c;
                Log.i("xmpp/reader/read/presence/unsubscribe " + (String)localObject1 + " " + (String)localObject4);
                localObject3 = ((aa)localObject3).a;
                localObject5 = new Bundle();
                ((Bundle)localObject5).putString("jid", (String)localObject1);
                ((Bundle)localObject5).putString("pushName", (String)localObject4);
                ((u.a)localObject3).a(Message.obtain(null, 0, 95, 0, localObject5));
              }
              else if ((localObject5 == null) || ("available".equals(localObject5)))
              {
                localObject3 = this.c;
                Log.i("xmpp/reader/read/presence/available " + (String)localObject1 + " " + (String)localObject4);
                localObject3 = ((aa)localObject3).a;
                localObject5 = new Bundle();
                ((Bundle)localObject5).putString("jid", (String)localObject1);
                ((Bundle)localObject5).putString("pushName", (String)localObject4);
                ((u.a)localObject3).a(Message.obtain(null, 0, 7, 0, localObject5));
              }
            }
          }
          else if (ak.b((ak)localObject3, "message"))
          {
            f((ak)localObject3);
          }
          else if (ak.b((ak)localObject3, "ib"))
          {
            localObject1 = ((ak)localObject3).a();
            if (ak.b((ak)localObject1, "offline"))
            {
              localObject1 = ((ak)localObject1).b("count");
              if (localObject1 == null) {
                break label2398;
              }
            }
          }
        }
        catch (NumberFormatException localNumberFormatException3)
        {
          try
          {
            Object localObject4;
            long l2;
            Object localObject1;
            Object localObject3 = this.c;
            i1 = Integer.parseInt((String)localObject1);
            Log.i("xmpp/reader/read/offline-complete count=" + i1);
            ((aa)localObject3).a.a(Message.obtain(null, 0, 18, i1));
            e();
            break label2398;
            if (ak.b((ak)localObject1, "dirty"))
            {
              localObject1 = this.c;
              localObject3 = h((ak)localObject3);
              Log.i("onDirty/table size:" + ((Map)localObject3).size());
              ((aa)localObject1).a.a(Message.obtain(null, 0, 11, 0, localObject3));
            }
            else if (ak.b((ak)localObject1, "streamdebug"))
            {
              localObject3 = ((ak)localObject1).b("ip");
              localObject4 = ((ak)localObject1).b("reconnect");
              localObject1 = ((ak)localObject1).b("stanzalogcount");
              if (localObject1 == null)
              {
                i1 = i3;
                boolean bool = "1".equals(localObject4);
                Log.i("xmpp/reader/read/stream/debug host=" + (String)localObject3 + " reconnect=" + bool + " size=" + i1);
              }
              else
              {
                i1 = Integer.parseInt((String)localObject1);
                continue;
              }
            }
            else if (ak.b((ak)localObject1, "location"))
            {
              a(((ak)localObject3).b("from"), (ak)localObject1);
            }
            else if (ak.b((ak)localObject1, "sonar"))
            {
              localObject1 = ((ak)localObject1).a("url");
              localObject3 = this.c;
              Log.i("xmpp/reader/read/sonar/url = " + (String)localObject1);
              ((aa)localObject3).a.a(Message.obtain(null, 0, 109, 0, localObject1));
            }
            else if (ak.b((ak)localObject1, "edge_routing"))
            {
              localObject3 = ((ak)localObject1).e("routing_info");
              localObject1 = ((ak)localObject1).e("dns_domain");
              if ((localObject3 != null) && (!TextUtils.isEmpty(((ak)localObject3).b()))) {
                this.t.a(((ak)localObject3).d);
              }
              if ((localObject1 != null) && (!TextUtils.isEmpty(((ak)localObject1).b()))) {
                this.u.d(((ak)localObject1).b());
              }
            }
            else if (ak.b((ak)localObject1, "fbip"))
            {
              localObject1 = ((ak)localObject1).b();
              if (localObject1 == null) {
                break label2406;
              }
              localObject1 = ((String)localObject1).split(",");
              k.a(this.a, (String[])localObject1, k.a((String[])localObject1));
              break label2398;
              if (ak.b((ak)localObject3, "call"))
              {
                b((ak)localObject3);
              }
              else if (ak.b((ak)localObject3, "stream:error"))
              {
                localObject1 = ((ak)localObject3).c;
                if ((localObject1 != null) && (localObject1.length > 0))
                {
                  Log.i("xmpp/reader/read/stream/error " + localObject1[0].a + " " + Arrays.toString(localObject1[0].d));
                }
                else
                {
                  Log.i("xmpp/reader/read/stream/error");
                  break label2398;
                  localc = localc;
                  continue;
                  localNumberFormatException3 = localNumberFormatException3;
                  l2 = l1;
                }
              }
            }
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            continue;
          }
        }
      }
      label2398:
      return true;
      label2400:
      l1 = 0L;
      continue;
      label2406:
      Object localObject2 = null;
    }
  }
  
  public static final class a
  {
    public ak a;
    public boolean b;
    public boolean c;
    public boolean d;
    
    a(ak paramak, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      this.a = paramak;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      this.d = paramBoolean3;
    }
  }
  
  public final class b
    extends y
  {
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private String f;
    
    public b(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      this.b = paramBoolean1;
      this.c = paramBoolean2;
      this.d = paramBoolean3;
      this.e = paramBoolean4;
      this.f = paramString;
    }
    
    private static int b(ak paramak, String paramString)
    {
      String str = paramak.a("text", null);
      int i = paramak.a("code", -1);
      long l = paramak.b("backoff", -1);
      Log.w("connection/unisynciq/parse/" + paramString + "/error/error_text= " + str + ", code: " + i + ", backoff:" + l);
      return i;
    }
    
    private static ContactSyncManager.c b(ak paramak)
    {
      ContactSyncManager.c localc = new ContactSyncManager.c();
      localc.a = paramak.a("jid", null);
      Object localObject1 = paramak.f("contact");
      Object localObject2;
      if (!((List)localObject1).isEmpty())
      {
        localc.b = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ak)((Iterator)localObject1).next();
          String str = ((ak)localObject2).a("type");
          int i = -1;
          switch (str.hashCode())
          {
          }
          for (;;)
          {
            switch (i)
            {
            default: 
              throw new c("Invalid contact type=" + str);
              if (str.equals("in"))
              {
                i = 0;
                continue;
                if (str.equals("out"))
                {
                  i = 1;
                  continue;
                  if (str.equals("invalid")) {
                    i = 2;
                  }
                }
              }
              break;
            }
          }
          i = 1;
          for (;;)
          {
            localc.c = i;
            localc.b.add(((ak)localObject2).b());
            break;
            i = 2;
            continue;
            i = 3;
          }
        }
      }
      long l;
      if (paramak.e("status") != null)
      {
        localObject2 = ak.a(paramak.e("status"));
        l = ((ak)localObject2).b("t", 0);
        paramak = ((ak)localObject2).b("code");
        localObject1 = ((ak)localObject2).b("type");
        localObject2 = ((ak)localObject2).b();
        if ((localObject1 == null) || (!((String)localObject1).equals("fail"))) {
          break label380;
        }
        if (("401".equals(paramak)) || ("403".equals(paramak)) || ("404".equals(paramak))) {
          localc.d = 2;
        }
      }
      else
      {
        return localc;
      }
      localc.d = 0;
      return localc;
      label380:
      localc.d = 1;
      localc.e = (1000L * l);
      localc.f = ((String)localObject2);
      return localc;
    }
    
    private static List<z> c(ak paramak)
    {
      ArrayList localArrayList = new ArrayList();
      paramak = ak.a(paramak.e("feature"));
      if ((paramak.c == null) || (paramak.c.length == 0)) {}
      for (;;)
      {
        return localArrayList;
        paramak = paramak.c;
        int j = paramak.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = paramak[i];
          localArrayList.add(new z(((ak)localObject).a, ((ak)localObject).a("value")));
          i += 1;
        }
      }
    }
    
    public final void a(int paramInt)
    {
      if (!this.e)
      {
        b.this.c.a(this.f, paramInt, 0L);
        b.this.c.b(this.f, paramInt, 0L);
      }
    }
    
    public final void a(ak paramak)
    {
      paramak = paramak.e("error");
      int j = 0;
      int i = 0;
      long l;
      if (paramak != null)
      {
        String str = paramak.a("code", null);
        if (str != null) {
          i = Integer.parseInt(str);
        }
        paramak = paramak.a("backoff", null);
        j = i;
        if (paramak != null) {
          l = Long.parseLong(paramak);
        }
      }
      for (l *= 1000L;; l = -1L)
      {
        if (!this.e)
        {
          b.this.c.a(this.f, i, l);
          b.this.c.b(this.f, i, l);
        }
        return;
        i = j;
      }
    }
    
    public final void a(ak paramak, String paramString)
    {
      Object localObject1 = paramak.e("usync");
      if (localObject1 == null) {
        return;
      }
      Object localObject2 = ak.a(((ak)localObject1).e("result"));
      long l1 = -1L;
      paramak = null;
      long l3 = l1;
      long l2;
      if (this.b)
      {
        paramak = ak.a(((ak)localObject2).e("contact"));
        if (paramak.e("error") != null)
        {
          paramString = ak.a(paramak.e("error"));
          l2 = paramString.b("backoff", -1);
          if (!this.e) {
            b.this.c.a(this.f, b(paramString, "contact"), l2 * 1000L);
          }
        }
        paramString = paramak.a("version", null);
        localObject3 = paramak.a("refresh", null);
        paramak = paramString;
        l3 = l1;
        if (localObject3 != null)
        {
          l3 = Long.parseLong((String)localObject3) * 1000L;
          paramak = paramString;
        }
      }
      if (this.c)
      {
        paramString = ak.a(((ak)localObject2).e("status"));
        if (paramString.e("error") != null)
        {
          localObject3 = ak.a(paramString.e("error"));
          l1 = ((ak)localObject3).b("backoff", -1);
          if (!this.e) {
            b.this.c.b(this.f, b((ak)localObject3, "status"), l1 * 1000L);
          }
        }
        paramString = paramString.a("refresh", null);
        if (paramString != null)
        {
          l1 = Long.parseLong(paramString) * 1000L;
          if (!this.d) {
            break label620;
          }
          paramString = ak.a(((ak)localObject2).e("feature"));
          if (paramString.e("error") != null)
          {
            localObject3 = ak.a(paramString.e("error"));
            l2 = ((ak)localObject3).b("backoff", -1);
            if (!this.e)
            {
              Object localObject4 = b.this.c;
              localObject2 = this.f;
              i = b((ak)localObject3, "feature");
              l2 *= 1000L;
              Log.i("xmpp/reader/read/sync-feature-error sid=" + (String)localObject2 + " index=0 code=" + i + " backoff=" + l2);
              localObject3 = ((aa)localObject4).a;
              localObject4 = new Bundle();
              ((Bundle)localObject4).putString("sid", (String)localObject2);
              ((Bundle)localObject4).putInt("index", 0);
              ((Bundle)localObject4).putInt("code", i);
              ((Bundle)localObject4).putLong("backoff", l2);
              ((u.a)localObject3).a(Message.obtain(null, 0, 123, 0, localObject4));
            }
          }
          paramString = paramString.a("refresh", null);
          if (paramString == null) {
            break label612;
          }
          l2 = 1000L * Long.parseLong(paramString);
          label476:
          localObject2 = ak.a(((ak)localObject1).e("list"));
          if (((ak)localObject2).c == null) {
            break label628;
          }
        }
      }
      label612:
      label620:
      label628:
      for (int i = ((ak)localObject2).c.length;; i = 0)
      {
        localObject1 = new HashMap(i);
        paramString = new ContactSyncManager.c[i];
        int j = 0;
        while (j < i)
        {
          localObject3 = localObject2.c[j];
          paramString[j] = b((ak)localObject3);
          if ((paramString[j].a != null) && (((ak)localObject3).e("feature") != null)) {
            ((Map)localObject1).put(paramString[j].a, c((ak)localObject3));
          }
          j += 1;
        }
        l1 = -1L;
        break;
        l1 = -1L;
        break;
        l2 = -1L;
        break label476;
        l2 = -1L;
        break label476;
      }
      if (this.e)
      {
        localObject2 = b.this.c;
        localObject1 = this.f;
        if (paramString.length > 0) {}
        for (paramak = paramString[0];; paramak = null)
        {
          Log.i("xmpp/reader/read/query-sync-result sid=" + (String)localObject1 + " index=0");
          paramString = ((aa)localObject2).a;
          paramak = Message.obtain(null, 0, 113, 0, paramak);
          localObject2 = paramak.getData();
          ((Bundle)localObject2).putString("sid", (String)localObject1);
          ((Bundle)localObject2).putInt("index", 0);
          paramString.a(paramak);
          return;
        }
      }
      localObject2 = b.this.c;
      Object localObject3 = this.f;
      Log.i("xmpp/reader/read/uni-sync-result sid=" + (String)localObject3 + " index=0");
      ((aa)localObject2).a.a(a.a.a.a.d.a((String)localObject3, paramak, paramString, (Map)localObject1, l3, l1, l2));
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */