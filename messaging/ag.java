package com.whatsapp.messaging;

import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Pair;
import b.a.a.c;
import com.whatsapp.auj;
import com.whatsapp.aus;
import com.whatsapp.cc;
import com.whatsapp.data.ad;
import com.whatsapp.data.cm;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.g.k;
import com.whatsapp.lt;
import com.whatsapp.protocol.af;
import com.whatsapp.protocol.av;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.registration.aw;
import com.whatsapp.rh;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ag
{
  private static volatile ag f;
  final ad a;
  final aj b;
  public final af c;
  final rh d;
  public final ae e;
  private final com.whatsapp.data.d g;
  private final w h;
  private final cm i;
  private final e j;
  private final aus k;
  private final cc l;
  private final lt m;
  
  private ag(com.whatsapp.data.d paramd, w paramw, cm paramcm, ad paramad, e parame, aj paramaj, aus paramaus, cc paramcc, af paramaf, lt paramlt, rh paramrh, ae paramae)
  {
    this.g = paramd;
    this.h = paramw;
    this.i = paramcm;
    this.a = paramad;
    this.j = parame;
    this.b = paramaj;
    this.k = paramaus;
    this.l = paramcc;
    this.c = paramaf;
    this.m = paramlt;
    this.d = paramrh;
    this.e = paramae;
  }
  
  public static ag a()
  {
    if (f == null) {}
    try
    {
      if (f == null) {
        f = new ag(com.whatsapp.data.d.a(), w.a(), cm.a(), ad.a(), e.a(), aj.a(), aus.a(), cc.a(), af.a(), lt.a(), rh.a(), ae.a());
      }
      return f;
    }
    finally {}
  }
  
  public final void a(int paramInt, List<j> paramList, boolean paramBoolean1, boolean paramBoolean2, ConditionVariable paramConditionVariable1, ConditionVariable paramConditionVariable2, j.b paramb)
  {
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (j)((Iterator)localObject1).next();
      this.c.a((j)localObject2);
    }
    localObject1 = this.e;
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (!com.whatsapp.protocol.m.c((j)((Iterator)localObject2).next())) {
        throw new IllegalArgumentException("message thumb not loaded");
      }
    }
    ((ae)localObject1).a(null, paramList, paramInt, paramBoolean1, paramBoolean2, paramConditionVariable1, paramConditionVariable2, 4, paramb, null);
  }
  
  public final void a(j paramj)
  {
    this.c.a(paramj);
    ae localae = this.e;
    if (!com.whatsapp.protocol.m.c(paramj)) {
      throw new IllegalArgumentException("message thumb not loaded");
    }
    if (auj.c())
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramj);
      localae.a(null, localArrayList, 4, false, false, null, null, 4, null, null);
    }
  }
  
  public final void a(String paramString)
  {
    if (paramString == null) {}
    ConditionVariable localConditionVariable1;
    ConditionVariable localConditionVariable2;
    HashMap localHashMap;
    for (boolean bool = true;; bool = false)
    {
      localConditionVariable1 = new ConditionVariable();
      localConditionVariable2 = new ConditionVariable();
      localHashMap = new HashMap();
      Iterator localIterator = this.m.j().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localHashMap.put(str, this.a.r(str));
      }
    }
    try
    {
      bu.a(ah.a(this, localHashMap, bool, localConditionVariable1, localConditionVariable2));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          bu.a(ai.a(this, localHashMap, paramString, bool, localConditionVariable1, localConditionVariable2));
          return;
        }
        catch (Exception paramString)
        {
          Log.e("app/xmpp/send/qr_send_conv preempt:" + bool + " chats/before dispatch error " + paramString.toString());
          localConditionVariable1.open();
        }
        localException = localException;
        Log.e("app/xmpp/send/qr_send_conv preempt:" + bool + " recents dispatch error " + localException.toString());
        localConditionVariable2.open();
      }
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    String str1;
    String str2;
    Object localObject1;
    String str3;
    boolean bool2;
    Object localObject2;
    k localk;
    int n;
    if ((!auj.c()) && (paramString1 != null))
    {
      str1 = this.k.c();
      str2 = this.k.d();
      localObject1 = this.h;
      if (((w)localObject1).b.d)
      {
        str3 = auj.f();
        bool2 = DateFormat.is24HourFormat(((w)localObject1).a);
        localObject2 = (com.whatsapp.g.d)c.a().a(com.whatsapp.g.d.class);
        localk = (k)c.a().a(k.class);
        if (localObject2 == null) {
          break label333;
        }
        n = (int)((com.whatsapp.g.d)localObject2).a();
        if ((localObject2 == null) || (!((com.whatsapp.g.d)localObject2).b())) {
          break label339;
        }
      }
    }
    label333:
    label339:
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool3 = localk.a;
      boolean bool4 = aw.a().j();
      localObject1 = ((w)localObject1).b;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("ref", paramString1);
      ((Bundle)localObject2).putString("secret", paramString2);
      ((Bundle)localObject2).putString("encryptedSecret", paramString4);
      ((Bundle)localObject2).putString("browserId", paramString3);
      ((Bundle)localObject2).putString("token", str3);
      ((Bundle)localObject2).putInt("loginType", paramInt);
      ((Bundle)localObject2).putInt("batteryLevel", n);
      ((Bundle)localObject2).putBoolean("plugged", bool1);
      ((Bundle)localObject2).putBoolean("powerSaveMode", bool3);
      ((Bundle)localObject2).putString("lc", str1);
      ((Bundle)localObject2).putString("lg", str2);
      ((Bundle)localObject2).putBoolean("is24h", bool2);
      ((Bundle)localObject2).putBoolean("isBizClient", bool4);
      ((m)localObject1).a(Message.obtain(null, 0, 43, 0, localObject2));
      if ((paramInt == 0) || (paramInt == 1))
      {
        auj.e(paramString2);
        a(null);
        this.b.b(this.j, null);
        this.b.b(auj.p());
      }
      return;
      n = 0;
      break;
    }
  }
  
  public final void a(String paramString, List<j> paramList, int paramInt, HashMap<String, String> paramHashMap)
  {
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (j)((Iterator)localObject1).next();
      this.c.a((j)localObject2);
    }
    localObject1 = this.e;
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (!com.whatsapp.protocol.m.c((j)((Iterator)localObject2).next())) {
        throw new IllegalArgumentException("message thumb not loaded");
      }
    }
    ((ae)localObject1).a(paramString, paramList, -1, true, false, null, null, paramInt, null, paramHashMap);
  }
  
  public final av b(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    boolean bool2 = true;
    cs localcs = this.j.a(paramString);
    av localav;
    if (localcs != null)
    {
      localav = new av();
      localav.l = this.g.b(paramString);
      localav.k = this.g.c(paramString);
      localav.d = paramString;
      localav.m = this.l.e(paramString);
      localav.j = this.a.o(paramString);
      localav.p = this.g.d(paramString);
      if (!TextUtils.isEmpty(localcs.e)) {
        break label192;
      }
      localObject1 = localObject2;
      localav.a = ((String)localObject1);
      if (localcs.d())
      {
        if (this.d.b(paramString)) {
          break label202;
        }
        bool1 = true;
        label146:
        localav.o = bool1;
      }
      localav.n = this.l.d(paramString);
      if (this.i.a(paramString) == -1) {
        break label207;
      }
    }
    label192:
    label202:
    label207:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localav.r = bool1;
      localObject1 = localav;
      return (av)localObject1;
      localObject1 = localcs.e;
      break;
      bool1 = false;
      break label146;
    }
  }
  
  public final void b(j paramj)
  {
    this.c.a(paramj);
    ae localae = this.e;
    if (!com.whatsapp.protocol.m.c(paramj)) {
      throw new IllegalArgumentException("message thumb not loaded");
    }
    if (auj.c())
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramj);
      localae.a(null, localArrayList, 3, false, false, null, null, 4, null, null);
    }
  }
  
  public final Pair<j.b, List<j>> c(String paramString)
  {
    Object localObject2 = this.a;
    int n = ((ad)localObject2).o(paramString);
    if (n > 0)
    {
      localObject1 = ((ad)localObject2).a(paramString, n);
      if (localObject1 != null)
      {
        paramString = ((ad)localObject2).a(paramString, ((j)localObject1).e, Integer.valueOf(20), null);
        if (paramString != null)
        {
          paramString.add(0, localObject1);
          label58:
          if (paramString != null) {
            break label118;
          }
        }
      }
    }
    label118:
    for (Object localObject1 = null;; localObject1 = ((j)paramString.get(0)).e)
    {
      if (localObject1 != null)
      {
        localObject2 = this.a.a((j.b)localObject1, 20, null);
        if (localObject2 != null) {
          paramString.addAll(0, (Collection)localObject2);
        }
      }
      return Pair.create(localObject1, paramString);
      paramString = new ArrayList();
      break;
      paramString = null;
      break label58;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */