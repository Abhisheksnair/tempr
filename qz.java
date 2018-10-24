package com.whatsapp;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.whatsapp.data.ad;
import com.whatsapp.data.ad.b;
import com.whatsapp.data.ad.g;
import com.whatsapp.data.ad.m;
import com.whatsapp.data.bg;
import com.whatsapp.data.ci;
import com.whatsapp.data.cs;
import com.whatsapp.data.ct;
import com.whatsapp.data.e;
import com.whatsapp.g.g;
import com.whatsapp.location.bp;
import com.whatsapp.messaging.m;
import com.whatsapp.protocol.al;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

public class qz
{
  public static Handler q;
  private static volatile qz r;
  public boolean a = false;
  public boolean b = false;
  final Map<String, String> c = new ConcurrentHashMap();
  public final ant d;
  public final va e;
  public final com.whatsapp.data.d f;
  public final com.whatsapp.messaging.w g;
  public final ad h;
  public final e i;
  public final com.whatsapp.util.w j;
  public final acm k;
  final com.whatsapp.a.c l;
  public final atv m;
  public final lt n;
  public final bp o;
  public final rh p;
  private final Set<String> s = Collections.newSetFromMap(new ConcurrentHashMap());
  private final pv t;
  private final m u;
  private final dh v;
  private final sr w;
  
  private qz(ant paramant, pv parampv, va paramva, com.whatsapp.data.d paramd, com.whatsapp.messaging.w paramw, ad paramad, e parame, m paramm, dh paramdh, com.whatsapp.util.w paramw1, sr paramsr, acm paramacm, com.whatsapp.a.c paramc, atv paramatv, lt paramlt, bp parambp, rh paramrh)
  {
    this.d = paramant;
    this.t = parampv;
    this.e = paramva;
    this.f = paramd;
    this.g = paramw;
    this.h = paramad;
    this.i = parame;
    this.u = paramm;
    this.v = paramdh;
    this.j = paramw1;
    this.w = paramsr;
    this.k = paramacm;
    this.l = paramc;
    this.m = paramatv;
    this.n = paramlt;
    this.o = parambp;
    this.p = paramrh;
    q = new b(parampv, paramad, parame);
  }
  
  private j a(int paramInt, al paramal, String paramString1, String paramString2)
  {
    Log.i("groupmgr/getParticipantStatusMessage/" + paramInt + "/" + paramal + "/" + paramString1);
    if (paramal != null) {}
    for (paramal = new a(paramal);; paramal = new j(this.e, paramString1, null))
    {
      paramal.d = 6;
      paramal.t = paramInt;
      paramal.f = paramString2;
      paramal.n = this.d.b();
      if ((paramInt == 4) && (paramString2 != null) && (paramString2.equals(this.e.c().t))) {
        paramal.w = 1;
      }
      return paramal;
    }
  }
  
  public static qz a()
  {
    if (r == null) {}
    try
    {
      if (r == null) {
        r = new qz(ant.a(), pv.a(), va.a(), com.whatsapp.data.d.a(), com.whatsapp.messaging.w.a(), ad.a(), e.a(), m.a(), dh.a(), com.whatsapp.util.w.a(), sr.a(), acm.a(), com.whatsapp.a.c.a(), atv.a(), lt.a(), bp.a(), rh.a());
      }
      return r;
    }
    finally {}
  }
  
  public static void a(int paramInt, Object paramObject)
  {
    q.obtainMessage(paramInt, paramObject).sendToTarget();
  }
  
  public static boolean a(j paramj)
  {
    try
    {
      if (paramj.d == 6) {
        if ((paramj.t != 4L) || (paramj.w != 1))
        {
          if (paramj.t == 12L)
          {
            int i1 = paramj.w;
            if (i1 != 1) {}
          }
        }
        else {
          return true;
        }
      }
      return false;
    }
    catch (NullPointerException localNullPointerException)
    {
      Log.e("groupmgr/importantmsg/null " + Log.a(paramj));
      throw localNullPointerException;
    }
  }
  
  public static String b(j paramj)
  {
    if (paramj.e.a.contains("-"))
    {
      if ((paramj.e.b) && (paramj.d == 6) && (paramj.t == 10L)) {
        return (String)paramj.N;
      }
      return paramj.f;
    }
    return paramj.e.a;
  }
  
  public static boolean e(String paramString)
  {
    return paramString.contains("-");
  }
  
  public static boolean g(String paramString)
  {
    return paramString.endsWith("@temp");
  }
  
  public final int a(rg paramrg, Map<String, String> paramMap, boolean paramBoolean)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1 = paramMap.keySet().iterator();
    Object localObject3;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      boolean bool = "admin".equals(paramMap.get(localObject2));
      localObject3 = paramrg.a((String)localObject2);
      if (localObject3 == null)
      {
        Log.i("groupmgr/sync-add-participant: " + (String)localObject2);
        localArrayList1.add(localObject2);
      }
      for (;;)
      {
        paramrg.a((String)localObject2, bool, false);
        break;
        if (((rf)localObject3).b != bool)
        {
          Log.i("groupmgr/sync-change-admin-participant: " + (String)localObject2 + " was " + ((rf)localObject3).b);
          localArrayList2.add(localObject3);
        }
      }
    }
    localObject1 = new ArrayList();
    Object localObject2 = paramMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (!paramMap.containsKey(localObject3))
      {
        Log.i("groupmgr/sync-remove-participant:" + (String)localObject3);
        ((List)localObject1).add(localObject3);
      }
    }
    paramMap = ((List)localObject1).iterator();
    while (paramMap.hasNext()) {
      paramrg.b((String)paramMap.next());
    }
    if (paramBoolean)
    {
      paramMap = paramrg.e();
      if (!localArrayList1.isEmpty())
      {
        localObject2 = paramrg.b;
        if (paramMap.size() != 1) {
          break label442;
        }
      }
      label442:
      for (paramMap = ((rf)paramMap.get(0)).a;; paramMap = null)
      {
        a(1, a(12, null, (String)localObject2, paramMap, localArrayList1, paramrg));
        if (!((List)localObject1).isEmpty()) {
          a(1, a(13, null, paramrg.b, null, (List)localObject1, null));
        }
        paramMap = localArrayList2.iterator();
        while (paramMap.hasNext())
        {
          localObject2 = (rf)paramMap.next();
          this.h.a(paramrg.b, (rf)localObject2);
        }
      }
    }
    this.p.e.a(paramrg);
    if (!localArrayList1.isEmpty()) {
      this.g.a(a((String[])localArrayList1.toArray(new String[localArrayList1.size()])));
    }
    int i1 = 0;
    if ((!localArrayList1.isEmpty()) || (!((List)localObject1).isEmpty()))
    {
      i1 = 1;
      paramrg.f();
    }
    int i2 = i1;
    if (!localArrayList2.isEmpty()) {
      i2 = i1 | 0x2;
    }
    return i2;
  }
  
  public final j a(int paramInt, al paramal, String paramString1, String paramString2, List<String> paramList, rg paramrg)
  {
    Log.i("groupmgr/getParticipantsStatusMessage/" + paramInt + "/" + paramal + "/" + paramString1 + "/" + paramString2 + "/" + paramList);
    if (paramal != null) {}
    for (paramal = new a(paramal, paramrg);; paramal = new j(this.e, paramString1, null))
    {
      paramal.d = 6;
      paramal.t = paramInt;
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = null;
      }
      paramal.f = paramString1;
      paramal.N = paramList;
      paramal.n = this.d.b();
      if (((paramInt == 12) || (paramInt == 20)) && (paramList.contains(this.e.c().t))) {
        paramal.w = 1;
      }
      return paramal;
    }
  }
  
  public final j a(al paramal, String paramString1, String paramString2, String paramString3, long paramLong)
  {
    if (paramal != null) {}
    for (paramal = new a(paramal);; paramal = new j(this.e, paramString1, null))
    {
      paramal.e(paramString2);
      paramal.d = 6;
      paramal.t = 11L;
      paramal.f = paramString3;
      paramal.n = paramLong;
      return paramal;
    }
  }
  
  public final void a(al paramal)
  {
    Log.i("groupmgr/onGroupDelete/" + paramal);
    if (this.p.e(paramal.a))
    {
      Object localObject = this.p.a(paramal.a);
      ((rg)localObject).b(this.e.c().t);
      localObject = ((rg)localObject).b().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((rf)((Iterator)localObject).next()).b = false;
      }
      this.o.d(paramal.a);
      a(1, a(17, paramal, paramal.a, paramal.e));
      return;
    }
    this.g.a(paramal);
  }
  
  public final void a(al paramal, String paramString)
  {
    c(paramal.a, paramString);
    b.a.a.c.a().b(new g(paramal.a, paramString));
    Log.i("groupmgr/getInviteLinkRevokedMessage/" + paramal);
    paramString = new a(paramal);
    paramString.d = 6;
    paramString.t = 21L;
    paramString.f = paramal.e;
    paramString.n = this.d.b();
    a(1, paramString);
  }
  
  public final void a(al paramal, String paramString1, String paramString2, int paramInt)
  {
    Log.i("groupmgr/onGroupNewSubject/" + paramal + "/" + paramString1 + "/" + paramString2 + "/" + paramInt * 1000L);
    String str = paramal.a;
    Object localObject = this.i.e(str);
    if (localObject != null)
    {
      localObject = ((cs)localObject).a(u.a());
      if (!((String)localObject).equals(paramString1))
      {
        Log.i("groupmgr/onGroupNewSubject/changed");
        this.i.a(str, paramString1);
        long l1 = paramInt;
        if (paramal != null) {}
        for (paramal = new a(paramal);; paramal = new j(this.e, str, null))
        {
          paramal.e(paramString1);
          paramal.N = localObject;
          paramal.d = 6;
          paramal.t = 1L;
          paramal.f = paramString2;
          paramal.n = (l1 * 1000L);
          a(3, paramal);
          return;
        }
      }
      Log.i("groupmgr/onGroupNewSubject/did not change");
      this.g.a(paramal);
      return;
    }
    Log.i("groupmgr/onGroupNewSubject/new group");
    localObject = new rg(str);
    this.i.a(str, paramString1, paramInt * 1000L);
    ((rg)localObject).a(str.substring(0, str.indexOf("-")) + "@s.whatsapp.net", true, false);
    this.p.b.put(str, localObject);
    a(0, a(paramal, str, paramString1, paramString2, 1000L * paramInt));
    this.g.d(str, null);
  }
  
  public final void a(al paramal, List<String> paramList)
  {
    Log.i("groupmgr/onGroupPromoteUsers/" + paramal + "/" + paramList);
    String str1 = paramal.a;
    rg localrg = this.p.a(str1);
    Iterator localIterator = paramList.iterator();
    int i1 = 0;
    rf localrf;
    if (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      localrf = localrg.a(str2);
      if (localrf == null)
      {
        localrf = localrg.a(str2, true, false);
        label103:
        if (!this.e.a(localrf.a)) {
          break label182;
        }
        i1 = 1;
      }
    }
    label182:
    for (;;)
    {
      this.h.a(str1, localrf);
      break;
      localrf.b = true;
      break label103;
      if (i1 != 0)
      {
        a(1, a(15, paramal, str1, paramal.e, paramList, null));
        return;
      }
      this.g.a(paramal);
      a(4, str1);
      return;
    }
  }
  
  public final void a(al paramal, List<String> paramList, String paramString1, String paramString2)
  {
    int i3 = 0;
    int i2 = 1;
    Log.i("groupmgr/onGroupRemoveUsers/" + paramal + "jids:" + Arrays.deepToString(paramList.toArray()) + "/removedBy:" + paramString1);
    String str1 = paramal.a;
    this.p.d(str1);
    String str2 = this.e.c().t;
    com.whatsapp.a.c.a.submit(rb.a(this, str2, str1));
    cs localcs = this.i.e(str1);
    if (((paramString1 == null) || (paramString1.equals(str2))) && (paramList.size() == 1) && (((String)paramList.get(0)).equals(str2)))
    {
      Log.i("groupmgr/onGroupRemoveUsers/me leaving");
      this.g.a(paramal);
    }
    label471:
    label516:
    for (;;)
    {
      if ((localcs != null) && (!TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(localcs.e)))
      {
        Log.i("groupmgr/onGroupRemoveUsers/subjectchanged");
        this.i.a(str1, paramString2);
        this.h.a(str1, paramString2);
      }
      return;
      if ((localcs == null) || (!this.p.b(str1)))
      {
        Log.i("groupmgr/onGroupRemoveUsers/requerygroupinfo");
        this.g.d(str1, null);
        paramList = this.k;
        if (localcs == null) {}
        for (i1 = 0;; i1 = localcs.m)
        {
          paramList.a(str1, i1, 2);
          this.g.a(paramal);
          break;
        }
      }
      rg localrg = this.p.a(str1);
      this.p.b(localrg);
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str3 = (String)paramList.next();
        if (localrg.b(str3) != null) {
          localArrayList.add(str3);
        }
        if (str2.equals(str3)) {
          this.o.d(localcs.t);
        }
      }
      int i1 = i3;
      if (paramString1 != null)
      {
        i1 = i3;
        if (localArrayList.contains(paramString1))
        {
          localArrayList.remove(paramString1);
          a(1, a(5, paramal, str1, paramString1));
          i1 = 1;
        }
      }
      if (!localArrayList.isEmpty())
      {
        this.o.b(str1, localArrayList);
        if (paramString1 == null)
        {
          i1 = 13;
          a(1, a(i1, paramal, str1, paramString1, localArrayList, null));
          i1 = i2;
        }
      }
      for (;;)
      {
        if (i1 != 0) {
          break label516;
        }
        this.g.a(paramal);
        break;
        i1 = 14;
        break label471;
      }
    }
  }
  
  public final void a(al paramal, Map<String, String> paramMap, String paramString)
  {
    Log.i("groupmgr/onGroupAddUsers/" + paramal + "/" + paramMap.values());
    String str1 = paramal.a;
    this.p.d(str1);
    String str2 = this.e.c().t;
    Object localObject1 = this.i.e(str1);
    rg localrg = this.p.a(str1);
    if ((localObject1 == null) || ((!localrg.b(this.e)) && (!paramMap.containsKey(str2))))
    {
      Log.i("groupmgr/onGroupAddUsers/requerygroupinfo");
      this.g.d(str1, null);
      paramMap = this.k;
      if (localObject1 == null) {}
      for (i1 = 0;; i1 = ((cs)localObject1).m)
      {
        paramMap.a(str1, i1, 2);
        this.g.a(paramal);
        return;
      }
    }
    localObject1 = new ArrayList();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject2 = (Map.Entry)paramMap.next();
      str2 = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (String)((Map.Entry)localObject2).getValue();
      ((List)localObject1).add(str2);
      localrg.a(str2, "admin".equals(localObject2), false);
    }
    this.g.a(a((String[])((List)localObject1).toArray(new String[((List)localObject1).size()])));
    if ("invite".equals(paramString)) {}
    for (int i1 = 20;; i1 = 12)
    {
      a(1, a(i1, paramal, str1, paramal.e, (List)localObject1, localrg));
      return;
    }
  }
  
  public final void a(String paramString, Iterable<String> paramIterable)
  {
    paramString = this.p.a(paramString);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      paramString.a((String)paramIterable.next(), false, true);
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    this.p.a(paramString1).a(paramString2, false, false);
    this.p.d(paramString1);
    a(1, a(4, null, paramString1, paramString2));
  }
  
  public final void a(String paramString1, String paramString2, long paramLong1, String paramString3, long paramLong2, Map<String, String> paramMap)
  {
    int i1;
    Object localObject;
    if (!this.f.a(paramString1))
    {
      i1 = 1;
      if (i1 == 0) {
        break label269;
      }
      a(0, a(null, paramString1, paramString3, paramString2, paramLong2));
      if (!this.e.a(paramString2))
      {
        localObject = new j(this.e, paramString1, null);
        ((j)localObject).d = 6;
        ((j)localObject).t = 4L;
        ((j)localObject).f = this.e.c().t;
        ((j)localObject).n = paramLong2;
        a(1, localObject);
      }
      label103:
      localObject = this.p.a(paramString1);
      if (i1 != 0) {
        break label357;
      }
    }
    label269:
    label357:
    for (boolean bool = true;; bool = false)
    {
      i1 = a((rg)localObject, paramMap, bool);
      if ((i1 & 0x1) != 0) {
        this.p.d(paramString1);
      }
      paramMap = this.i.d(paramString1);
      if ((!TextUtils.equals(paramMap.e, paramString3)) || (!TextUtils.equals(paramMap.g, Long.toString(paramLong1))) || (!TextUtils.equals(paramMap.j, paramString2)))
      {
        paramMap.e = paramString3;
        paramMap.g = Long.toString(paramLong1);
        paramMap.j = paramString2;
        this.i.d(paramMap);
      }
      if (!this.p.e(paramString1)) {
        this.k.a(paramString1, 0, 2);
      }
      if ((i1 & 0x2) != 0) {
        a(4, paramString1);
      }
      return;
      i1 = 0;
      break;
      localObject = this.h;
      Log.i("msgstore/updategroupchat/" + paramString1 + " creation=" + paramLong1);
      ad.g localg = new ad.g((byte)0);
      localg.a = paramString1;
      localg.b = paramString3;
      localg.c = Long.valueOf(paramLong1);
      Message.obtain(((ad)localObject).d, 10, 0, 0, localg).sendToTarget();
      break label103;
    }
  }
  
  public final void a(List<String> paramList)
  {
    Log.i("groupmgr/onLeaveGroup/" + Arrays.deepToString(paramList.toArray()));
    String str1 = this.e.c().t;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str2 = (String)paramList.next();
      this.p.d(str2);
      this.p.a(str2).b(str1);
      this.o.d(str2);
      if (this.f.a(str2)) {
        a(1, a(5, null, str2, str1));
      }
    }
  }
  
  public final void a(Set<String> paramSet)
  {
    Log.i("groupmgr/onparticipatinggroups/" + paramSet);
    Iterator localIterator = this.n.j().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if ((str1.contains("-")) && (!paramSet.contains(str1)))
      {
        this.p.a(str1).b(this.e.c().t);
        localObject1 = this.h;
        Object localObject2 = this.e.c().t;
        Log.i("msgstore/removeGroupParticipants/" + str1 + " " + (String)localObject2);
        ((ad)localObject1).d.post(bg.a((ad)localObject1, str1, (String)localObject2));
        if (this.i.e(str1) == null)
        {
          localObject1 = new cs(str1);
          this.i.a((cs)localObject1);
        }
        localObject1 = this.h.h(str1);
        if ((((ad.m)localObject1).a != null) && (((ad.m)localObject1).b != null))
        {
          e locale = this.i;
          String str2 = ((ad.m)localObject1).a;
          long l1 = ((ad.m)localObject1).b.longValue();
          localObject2 = locale.b.a(str1);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new cs(str1);
            locale.b.a((cs)localObject1);
          }
          ((cs)localObject1).e = str2;
          ((cs)localObject1).g = Long.toString(l1);
          ((cs)localObject1).j = null;
          locale.b.b((cs)localObject1);
          locale.f((cs)localObject1);
        }
        this.o.d(str1);
      }
    }
    this.b = false;
    this.m.h(false);
    if (this.a)
    {
      this.a = false;
      paramSet = this.g;
      if (paramSet.b.d)
      {
        Log.i("sendmethods/sendClearDirty");
        paramSet.b.a(Message.obtain(null, 0, 18, 0, "groups"));
      }
    }
    paramSet = this.t;
    Object localObject1 = this.v;
    localObject1.getClass();
    paramSet.a(rd.a((dh)localObject1));
  }
  
  public final boolean a(String paramString)
  {
    paramString = this.p.a(paramString).e().iterator();
    while (paramString.hasNext())
    {
      Object localObject = (rf)paramString.next();
      if (!this.e.a(((rf)localObject).a))
      {
        localObject = this.i.c(((rf)localObject).a);
        if ((localObject != null) && (((cs)localObject).d != null)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public final String[] a(String... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    int i2 = paramVarArgs.length;
    int i1 = 0;
    while (i1 < i2)
    {
      String str = paramVarArgs[i1];
      if (this.i.c(str) == null) {
        localArrayList.add(str);
      }
      i1 += 1;
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public final void b()
  {
    try
    {
      this.a = true;
      if (!this.b) {
        bu.a(re.a(this));
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void b(al paramal, List<String> paramList)
  {
    Log.i("groupmgr/onGroupDemoteUsers/" + paramal + "/" + paramList);
    String str1 = paramal.a;
    rg localrg = this.p.a(str1);
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      String str2 = (String)localIterator.next();
      paramList = localrg.a(str2);
      if (paramList == null) {
        paramList = localrg.a(str2, false, false);
      }
      for (;;)
      {
        this.h.a(str1, paramList);
        break;
        paramList.b = false;
      }
    }
    this.g.a(paramal);
    a(4, str1);
  }
  
  public final void b(String paramString)
  {
    this.s.add(paramString);
  }
  
  public final void b(String paramString1, String paramString2)
  {
    rg localrg = this.p.a(paramString1);
    localrg.b(paramString2);
    this.o.b(paramString1, Collections.singletonList(paramString2));
    if (j.b(paramString1)) {
      com.whatsapp.a.c.a.submit(ra.a(this, localrg, paramString1));
    }
    this.p.d(paramString1);
    a(1, a(7, null, paramString1, paramString2));
  }
  
  public final void c()
  {
    Message localMessage = a.a.a.a.d.h();
    if (!this.b)
    {
      this.b = true;
      if (this.u.d)
      {
        Log.i("groupmgr/sendgetgroups");
        this.u.a(localMessage);
      }
    }
    else
    {
      return;
    }
    Log.i("groupmgr/sendgetgroups/ms-not-ready");
    this.w.a(null, localMessage);
  }
  
  public final void c(String paramString)
  {
    this.s.remove(paramString);
  }
  
  public final void c(String paramString1, String paramString2)
  {
    this.c.put(paramString1, paramString2);
  }
  
  public final void d()
  {
    Log.i("groupmgr/groupSyncFailedOrTimeout");
    this.b = false;
    this.m.h(true);
  }
  
  public final boolean d(String paramString)
  {
    return this.s.contains(paramString);
  }
  
  public final String f(String paramString)
  {
    return this.e.b() + "-" + paramString + "@temp";
  }
  
  public static final class a
    extends j
  {
    public al a;
    public rg b;
    
    public a(al paramal)
    {
      this(paramal, null);
    }
    
    public a(al paramal, rg paramrg)
    {
      super();
      this.a = paramal;
      this.b = paramrg;
    }
  }
  
  static final class b
    extends Handler
  {
    private final pv a;
    private final ad b;
    private final e c;
    
    public b(pv parampv, ad paramad, e parame)
    {
      super();
      this.a = parampv;
      this.b = paramad;
      this.c = parame;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      Object localObject;
      String str;
      int i;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        Log.i("groupmgr/handle-init-group-chat");
        this.b.b((j)paramMessage.obj, -1);
        return;
      case 1: 
        Log.i("groupmgr/handle_add_groupchat_msg");
        paramMessage = (j)paramMessage.obj;
        this.b.b(paramMessage, -1);
        GroupChatInfo.a(paramMessage.e.a);
        return;
      case 2: 
        GroupChatInfo.a((String)paramMessage.obj);
        Log.i("groupmgr/conversations/leave group");
        return;
      case 3: 
        Log.i("groupmgr/handle_groupchat_subject_change");
        paramMessage = (j)paramMessage.obj;
        this.b.b(paramMessage, -1);
        GroupChatInfo.a(paramMessage.e.a);
        return;
      case 4: 
        GroupChatInfo.a((String)paramMessage.obj);
        return;
      case 5: 
        paramMessage = (String)paramMessage.obj;
        pv.a(u.a(), u.a().getString(2131296787, new Object[] { this.c.e(paramMessage).e }), 0);
        return;
      case 8: 
        paramMessage = (String)paramMessage.obj;
        pv.a(u.a(), u.a().getString(2131296787, new Object[] { this.c.e(paramMessage).e }), 0);
        return;
      case 6: 
        GroupChatInfo.a((String)paramMessage.obj);
        pv.a(u.a(), u.a().getString(2131296960), 0);
        return;
      case 7: 
        GroupChatInfo.a((String)paramMessage.obj);
        pv.a(u.a(), u.a().getString(2131296975), 0);
        return;
      case 9: 
        GroupChatInfo.a((String)paramMessage.obj);
        pv.a(u.a(), u.a().getString(2131296964), 0);
        return;
      case 10: 
        GroupChatInfo.a((String)paramMessage.obj);
        pv.a(u.a(), u.a().getString(2131296964), 0);
        return;
      case 11: 
        GroupChatInfo.a((String)paramMessage.obj);
        pv.a(u.a(), u.a().getString(2131296979), 0);
        return;
      case 12: 
        this.a.b(u.a(), u.a().getResources().getString(2131296968, new Object[] { (String)paramMessage.obj }), 0);
        return;
      case 13: 
        this.a.b(u.a(), u.a().getResources().getString(2131296970, new Object[] { (String)paramMessage.obj }), 0);
        return;
      case 14: 
        this.a.b(u.a(), u.a().getResources().getString(2131296969, new Object[] { (String)paramMessage.obj }), 0);
        return;
      case 15: 
        this.a.b(u.a(), u.a().getResources().getString(2131296979), 0);
        return;
      case 16: 
        this.a.b(u.a(), u.a().getResources().getString(2131296981), 0);
        return;
      case 17: 
        this.a.b(u.a(), u.a().getResources().getString(2131296982), 0);
        return;
      case 18: 
        this.a.b(u.a(), u.a().getResources().getString(2131296980), 0);
        return;
      case 19: 
        this.a.b(u.a(), u.a().getResources().getString(2131296983, new Object[] { (String)paramMessage.obj }), 0);
        return;
      case 20: 
        this.a.b(u.a(), u.a().getResources().getString(2131296960), 0);
        return;
      case 21: 
        this.a.b(u.a(), u.a().getResources().getString(2131296962), 0);
        return;
      case 22: 
        this.a.b(u.a(), u.a().getResources().getString(2131296963), 0);
        return;
      case 23: 
        this.a.b(u.a(), u.a().getResources().getString(2131296961), 0);
        return;
      case 24: 
        this.a.b(u.a(), u.a().getResources().getString(2131296975), 0);
        return;
      case 25: 
        this.a.b(u.a(), u.a().getResources().getString(2131296977), 0);
        return;
      case 26: 
        this.a.b(u.a(), u.a().getResources().getString(2131296978), 0);
        return;
      case 27: 
        this.a.b(u.a(), u.a().getResources().getString(2131296976), 0);
        return;
      case 28: 
        this.a.b(u.a(), u.a().getResources().getString(2131296964), 0);
        return;
      case 29: 
        this.a.b(u.a(), u.a().getResources().getString(2131296966), 0);
        return;
      case 30: 
        this.a.b(u.a(), u.a().getResources().getString(2131296967), 0);
        return;
      case 31: 
        this.a.b(u.a(), u.a().getResources().getString(2131296965), 0);
        return;
      case 32: 
        this.a.b(u.a(), u.a().getResources().getString(2131296972), 0);
        return;
      case 33: 
        this.a.b(u.a(), u.a().getResources().getString(2131296974), 0);
        return;
      case 34: 
        this.a.b(u.a(), u.a().getResources().getString(2131296973), 0);
        return;
      case 35: 
        this.a.b(u.a(), u.a().getResources().getString(2131296971), 0);
        return;
      case 36: 
        localStringBuilder = new StringBuilder();
        paramMessage = ((Map)paramMessage.obj).entrySet().iterator();
        while (paramMessage.hasNext())
        {
          localObject = (Map.Entry)paramMessage.next();
          str = (String)((Map.Entry)localObject).getKey();
          Log.e("groupmgr/add-participant/error/" + str + "/" + ((Map.Entry)localObject).getValue());
          i = ((Integer)((Map.Entry)localObject).getValue()).intValue();
          localObject = this.c.d(str);
          switch (i)
          {
          case 409: 
          default: 
            localStringBuilder.append(u.a().getString(2131296725, new Object[] { ((cs)localObject).a(u.a()) })).append("\n");
            break;
          case 401: 
            localStringBuilder.append(u.a().getString(2131296726, new Object[] { ((cs)localObject).a(u.a()) })).append("\n");
            break;
          case 500: 
            localStringBuilder.append(u.a().getString(2131296727, new Object[] { ((cs)localObject).a(u.a()) })).append("\n");
          }
        }
        this.a.b(u.a(), localStringBuilder.toString(), 0);
        return;
      case 37: 
        localStringBuilder = new StringBuilder();
        paramMessage = ((Map)paramMessage.obj).entrySet().iterator();
        while (paramMessage.hasNext())
        {
          localObject = (Map.Entry)paramMessage.next();
          str = (String)((Map.Entry)localObject).getKey();
          Log.e("groupmgr/remove-participant/error/" + str + "/" + ((Map.Entry)localObject).getValue());
          i = ((Integer)((Map.Entry)localObject).getValue()).intValue();
          localObject = this.c.d(str);
          switch (i)
          {
          }
          localStringBuilder.append(u.a().getString(2131296752, new Object[] { ((cs)localObject).a(u.a()) })).append("\n");
        }
        this.a.b(u.a(), localStringBuilder.toString(), 0);
        return;
      case 38: 
        localStringBuilder = new StringBuilder();
        paramMessage = ((Map)paramMessage.obj).entrySet().iterator();
        while (paramMessage.hasNext())
        {
          localObject = (Map.Entry)paramMessage.next();
          str = (String)((Map.Entry)localObject).getKey();
          Log.e("groupmgr/add-admins/error/" + str + "/" + ((Map.Entry)localObject).getValue());
          i = ((Integer)((Map.Entry)localObject).getValue()).intValue();
          localObject = this.c.d(str);
          switch (i)
          {
          default: 
            localStringBuilder.append(u.a().getString(2131296725, new Object[] { ((cs)localObject).a(u.a()) })).append("\n");
            break;
          case 404: 
            localStringBuilder.append(u.a().getString(2131296725, new Object[] { ((cs)localObject).a(u.a()) })).append("\n");
          }
        }
        this.a.b(u.a(), localStringBuilder.toString(), 0);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      paramMessage = ((Map)paramMessage.obj).entrySet().iterator();
      while (paramMessage.hasNext())
      {
        localObject = (Map.Entry)paramMessage.next();
        str = (String)((Map.Entry)localObject).getKey();
        Log.e("groupmgr/remove-admins/error/" + str + "/" + ((Map.Entry)localObject).getValue());
        i = ((Integer)((Map.Entry)localObject).getValue()).intValue();
        localObject = this.c.d(str);
        switch (i)
        {
        default: 
          localStringBuilder.append(u.a().getString(2131296752, new Object[] { ((cs)localObject).a(u.a()) })).append("\n");
          break;
        case 404: 
          localStringBuilder.append(u.a().getString(2131296752, new Object[] { ((cs)localObject).a(u.a()) })).append("\n");
        }
      }
      this.a.b(u.a(), localStringBuilder.toString(), 0);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/qz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */