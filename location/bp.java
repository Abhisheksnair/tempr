package com.whatsapp.location;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.f.h;
import android.text.TextUtils;
import com.whatsapp.ant;
import com.whatsapp.att;
import com.whatsapp.atv;
import com.whatsapp.data.ab;
import com.whatsapp.data.ac;
import com.whatsapp.data.ad;
import com.whatsapp.data.cs;
import com.whatsapp.data.l;
import com.whatsapp.fieldstats.events.an;
import com.whatsapp.g.a;
import com.whatsapp.hx;
import com.whatsapp.jobqueue.job.SendDisableLiveLocationJob;
import com.whatsapp.jobqueue.job.SendLiveLocationKeyJob;
import com.whatsapp.messaging.w;
import com.whatsapp.protocol.ap;
import com.whatsapp.protocol.j.b;
import com.whatsapp.pv;
import com.whatsapp.qz;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.va;
import com.whatsapp.va.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class bp
{
  private static final Random j = new Random();
  private static volatile bp k;
  private final l A;
  private final atv B;
  private ap C;
  private an D;
  final Object a = new Object();
  public final Object b = new Object();
  final List<c> c = new ArrayList();
  public final pv d;
  final va e;
  final ad f;
  final com.whatsapp.a.c g;
  public final cb h;
  final hx i;
  private Map<String, Map<String, b>> l;
  private final Map<String, ap> m = new HashMap();
  private Map<String, a> n;
  private final Map<String, h<Long, Integer>> o = new HashMap();
  private final Map<String, h<Long, Integer>> p = new HashMap();
  private final Map<String, e> q = new HashMap();
  private final Map<h<String, String>, Long> r = new HashMap();
  private final HashSet<String> s = new HashSet();
  private final List<d> t = new ArrayList();
  private final Runnable u = bs.a(this);
  private final Runnable v = bt.a(this);
  private final ant w;
  private final w x;
  private final att y;
  private final com.whatsapp.data.e z;
  
  private bp(ant paramant, pv parampv, va paramva, w paramw, ad paramad, att paramatt, com.whatsapp.data.e parame, final l paraml, ac paramac, com.whatsapp.a.c paramc, atv paramatv, hx paramhx, cb paramcb)
  {
    this.w = paramant;
    this.d = parampv;
    this.e = paramva;
    this.x = paramw;
    this.f = paramad;
    this.y = paramatt;
    this.z = parame;
    this.A = paraml;
    this.g = paramc;
    this.B = paramatv;
    this.i = paramhx;
    this.h = paramcb;
    paramac.registerObserver(new ab()
    {
      public final void a(Collection<com.whatsapp.protocol.j> paramAnonymousCollection, Map<String, Integer> arg2)
      {
        Object localObject2;
        Object localObject3;
        synchronized (bp.a(bp.this))
        {
          ??? = bp.b(bp.this);
          localObject2 = paramAnonymousCollection.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (com.whatsapp.protocol.j)((Iterator)localObject2).next();
            if ((((com.whatsapp.protocol.j)localObject3).e.b) && (com.whatsapp.protocol.m.d((com.whatsapp.protocol.j)localObject3)) && (((Map)???).containsKey(((com.whatsapp.protocol.j)localObject3).e.a)) && (((bp.a)((Map)???).get(((com.whatsapp.protocol.j)localObject3).e.a)).a.equals(((com.whatsapp.protocol.j)localObject3).e))) {
              bp.this.g(((com.whatsapp.protocol.j)localObject3).e.a);
            }
          }
        }
        for (;;)
        {
          com.whatsapp.protocol.j localj;
          synchronized (bp.c(bp.this))
          {
            localObject2 = bp.d(bp.this);
            localObject3 = paramAnonymousCollection.iterator();
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localj = (com.whatsapp.protocol.j)((Iterator)localObject3).next();
            ??? = localj.e.a;
            if ((localj.e.b) || (!com.whatsapp.protocol.m.d(localj)) || (!((Map)localObject2).containsKey(???))) {
              continue;
            }
            if (TextUtils.isEmpty(localj.f))
            {
              paramAnonymousCollection = ???;
              bp.b localb = (bp.b)((Map)((Map)localObject2).get(???)).get(paramAnonymousCollection);
              if ((localb == null) || (!localb.c.equals(localj.e))) {
                continue;
              }
              bp.a(bp.this, ???, paramAnonymousCollection);
            }
          }
          paramAnonymousCollection = localj.f;
        }
      }
      
      public final void b(String paramAnonymousString)
      {
        synchronized (bp.a(bp.this))
        {
          Object localObject2 = (bp.a)bp.b(bp.this).get(paramAnonymousString);
          if ((localObject2 != null) && (paraml.a(((bp.a)localObject2).a) == null)) {
            bp.this.g(paramAnonymousString);
          }
          synchronized (bp.c(bp.this))
          {
            localObject2 = bp.d(bp.this);
            if (((Map)localObject2).containsKey(paramAnonymousString))
            {
              localObject2 = ((Map)((Map)localObject2).get(paramAnonymousString)).values().iterator();
              while (((Iterator)localObject2).hasNext())
              {
                bp.b localb = (bp.b)((Iterator)localObject2).next();
                if (paraml.a(localb.c) == null) {
                  bp.a(bp.this, paramAnonymousString, localb.a);
                }
              }
            }
          }
        }
      }
    });
  }
  
  public static bp a()
  {
    if (k == null) {}
    try
    {
      if (k == null) {
        k = new bp(ant.a(), pv.a(), va.a(), w.a(), ad.a(), att.a(), com.whatsapp.data.e.a(), l.a(), ac.a(), com.whatsapp.a.c.a(), atv.a(), hx.a(), new cb(u.a()));
      }
      return k;
    }
    finally {}
  }
  
  private void a(b paramb)
  {
    if (paramb != null)
    {
      paramb = this.A.a(paramb.c);
      if (paramb != null) {
        c(paramb);
      }
    }
  }
  
  private void a(Map<String, Map<String, b>> paramMap)
  {
    HashSet localHashSet = new HashSet(this.m.keySet());
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      Iterator localIterator = ((Map)paramMap.next()).values().iterator();
      while (localIterator.hasNext()) {
        localHashSet.remove(((b)localIterator.next()).a);
      }
    }
    if (!localHashSet.isEmpty()) {
      this.h.a(localHashSet);
    }
  }
  
  public static void b()
  {
    Log.i("LocationSharingManager/onStopLocationReporting");
    Intent localIntent = new Intent(u.a(), LocationSharingService.class);
    localIntent.setAction("com.whatsapp.ShareLocationService.STOP");
    u.a().startService(localIntent);
  }
  
  private void c(com.whatsapp.protocol.j paramj)
  {
    int i1 = (int)(((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a() - paramj.n) / 1000;
    if (i1 < paramj.w)
    {
      paramj.w = i1;
      this.f.e(paramj, -1);
    }
  }
  
  private Set<String> n()
  {
    Object localObject = h();
    HashSet localHashSet = new HashSet();
    long l1 = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
    localObject = ((Map)localObject).values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if ((locala.c == 0L) || (locala.c > l1)) {
        localHashSet.addAll(locala.b);
      }
    }
    return localHashSet;
  }
  
  private void o()
  {
    Log.i("LocationSharingManager/removeMyLocationSenderKey");
    Object localObject2 = com.whatsapp.a.c.a(this.e.c().t);
    synchronized (this.b)
    {
      this.g.f.b(new org.whispersystems.a.c.e("location@broadcast", (org.whispersystems.a.m)localObject2));
      this.s.clear();
      this.q.clear();
      localObject2 = this.h.a().getWritableDatabase();
      try
      {
        int i1 = ((SQLiteDatabase)localObject2).delete("location_key_distribution", null, null);
        Log.i("LocationSharingStore/deleteAllLocationReceiverHasKey/deleted " + i1 + " rows");
        b.a.a.c.a().b(new a("location@broadcast"));
        return;
      }
      catch (Exception localException)
      {
        Log.d("LocationSharingStore/deleteAllLocationReceiverHasKey/delete failed", localException);
        throw new RuntimeException(localException);
      }
    }
  }
  
  public final int a(String paramString)
  {
    for (;;)
    {
      int i1;
      synchronized (this.a)
      {
        paramString = (Map)c().get(paramString);
        long l1 = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
        if (paramString == null) {
          break label125;
        }
        paramString = paramString.values().iterator();
        i1 = 0;
        i2 = i1;
        if (paramString.hasNext())
        {
          b localb = (b)paramString.next();
          if (localb.b == 0L) {
            break label118;
          }
          if (localb.b > l1) {
            break label118;
          }
        }
        else
        {
          return i2;
        }
      }
      break label122;
      label118:
      i1 += 1;
      label122:
      continue;
      label125:
      int i2 = 0;
    }
  }
  
  public final long a(com.whatsapp.protocol.j paramj)
  {
    synchronized (this.a)
    {
      Map localMap = (Map)c().get(paramj.e.a);
      if (localMap != null)
      {
        if (qz.e(paramj.e.a)) {}
        for (Object localObject1 = paramj.f;; localObject1 = paramj.e.a)
        {
          localObject1 = (b)localMap.get(localObject1);
          if ((localObject1 == null) || (!paramj.e.equals(((b)localObject1).c))) {
            break;
          }
          long l1 = ((b)localObject1).b;
          return l1;
        }
      }
      return -1L;
    }
  }
  
  public final List<String> a(List<String> paramList)
  {
    ArrayList localArrayList;
    synchronized (this.b)
    {
      localArrayList = new ArrayList();
      List localList = k();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if ((localList.contains(str)) && (this.q.get(str) != e.b))
        {
          localArrayList.add(str);
          this.q.put(str, e.b);
        }
      }
    }
    return localArrayList;
  }
  
  final void a(Location paramLocation, Integer paramInteger)
  {
    ap localap = new ap();
    localap.a = this.e.c().t;
    localap.b = (Math.round(paramLocation.getLatitude() * 1000000.0D) / 1000000.0D);
    localap.c = (Math.round(paramLocation.getLongitude() * 1000000.0D) / 1000000.0D);
    if (paramLocation.hasAccuracy()) {
      localap.d = ((int)paramLocation.getAccuracy());
    }
    if (paramLocation.hasSpeed()) {
      localap.e = ((int)(paramLocation.getSpeed() * 100.0F) / 100.0F);
    }
    if (paramLocation.hasBearing()) {
      localap.f = ((int)paramLocation.getBearing());
    }
    localap.g = paramLocation.getTime();
    if (localap.g > this.w.b()) {
      localap.g = this.w.b();
    }
    try
    {
      if ((this.C == null) || (localap.g > this.C.g))
      {
        if (this.D == null) {
          this.D = new an();
        }
        this.D.a = Long.valueOf(localap.d);
        if (this.C != null)
        {
          if (this.D.b == null) {
            this.D.b = Double.valueOf(0.0D);
          }
          paramLocation = this.D;
          paramLocation.b = Double.valueOf(paramLocation.b.doubleValue() + (localap.g - this.C.g));
        }
        this.D.e = paramInteger;
        this.C = localap;
      }
      return;
    }
    finally {}
  }
  
  public final void a(a parama)
  {
    parama = this.A.a(parama.a);
    if (parama != null) {
      c(parama);
    }
  }
  
  public final void a(c paramc)
  {
    if (!this.c.contains(paramc)) {
      this.c.add(paramc);
    }
  }
  
  public final void a(d paramd)
  {
    if (!this.t.contains(paramd)) {
      this.t.add(paramd);
    }
  }
  
  public final void a(ap paramap)
  {
    Log.i("LocationSharingManager/onReceiveLocation; location.jid=" + paramap.a);
    for (;;)
    {
      synchronized (this.a)
      {
        Object localObject2 = c().values().iterator();
        if (!((Iterator)localObject2).hasNext()) {
          break label269;
        }
        if ((b)((Map)((Iterator)localObject2).next()).get(paramap.a) == null) {
          continue;
        }
        if (this.m.containsKey(paramap.a))
        {
          localObject2 = (ap)this.m.get(paramap.a);
          ((ap)localObject2).g = paramap.g;
          ((ap)localObject2).b = paramap.b;
          ((ap)localObject2).c = paramap.c;
          ((ap)localObject2).d = paramap.d;
          ((ap)localObject2).f = paramap.f;
          ((ap)localObject2).e = paramap.e;
          this.h.a(paramap);
          i1 = 1;
          if (i1 != 0)
          {
            ??? = this.t.iterator();
            if (!((Iterator)???).hasNext()) {
              break label268;
            }
            ((d)((Iterator)???).next()).a(paramap);
            continue;
          }
        }
        else
        {
          this.m.put(paramap.a, paramap);
        }
      }
      Log.w("LocationSharingManager/onReceiveLocation/sharer not in any group; remote_resource=" + paramap.a);
      label268:
      return;
      label269:
      int i1 = 0;
    }
  }
  
  public final void a(com.whatsapp.protocol.j paramj, long paramLong)
  {
    Log.i("LocationSharingManager/onReceiveSharing; message.key.remote_jid=" + paramj.e.a + "; message.remote_resource=" + paramj.f + "; expiration=" + paramLong + "; message.sequenceNumber=" + paramj.t);
    String str2 = paramj.e.a;
    String str1;
    if (TextUtils.isEmpty(paramj.f)) {
      str1 = paramj.e.a;
    }
    synchronized (this.a)
    {
      Object localObject2 = c();
      if (!((Map)localObject2).containsKey(str2)) {
        ((Map)localObject2).put(str2, new HashMap());
      }
      a((b)((Map)((Map)localObject2).get(str2)).get(str1));
      ((Map)((Map)localObject2).get(str2)).put(str1, new b(str1, paramLong, paramj.e));
      if (!this.m.containsKey(str1))
      {
        localObject2 = new ap();
        ((ap)localObject2).a = str1;
        this.m.put(str1, localObject2);
      }
      localObject2 = (ap)this.m.get(str1);
      if (((ap)localObject2).g < paramj.n)
      {
        ((ap)localObject2).b = paramj.B;
        ((ap)localObject2).c = paramj.C;
        ((ap)localObject2).g = paramj.n;
        this.h.a((ap)localObject2);
      }
      this.h.a(Collections.singletonList(new cb.c(str2, str1, paramLong, new j.b(str2, false, paramj.e.c), (byte)0)));
      paramj = this.t.iterator();
      while (paramj.hasNext())
      {
        ((d)paramj.next()).a(str2);
        continue;
        str1 = paramj.f;
      }
    }
    j();
    this.d.a(bw.a(this, str2));
  }
  
  final void a(String paramString1, String paramString2)
  {
    Log.i("LocationSharingManager/onReceiveStopSharing; jid=" + paramString1 + "; participant=" + paramString2);
    synchronized (this.a)
    {
      Map localMap1 = c();
      Map localMap2 = (Map)localMap1.get(paramString1);
      if (localMap2 != null)
      {
        if (!TextUtils.isEmpty(paramString2)) {
          break label162;
        }
        localObject1 = paramString1;
        a((b)localMap2.remove(localObject1));
        this.h.a(paramString1, paramString2);
        if (localMap2.isEmpty()) {
          localMap1.remove(paramString1);
        }
      }
      a(localMap1);
      Object localObject1 = this.t.iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((d)((Iterator)localObject1).next()).a(paramString1, paramString2);
      }
      label162:
      localObject1 = paramString2;
    }
    j();
    this.d.a(bu.a(this, paramString1));
  }
  
  public final void a(String paramString1, String paramString2, long paramLong)
  {
    Log.i("LocationSharingManager/onReceiveStopSharing; jid=" + paramString1 + "; participant=" + paramString2 + "; sequenceNumber=" + paramLong);
    for (;;)
    {
      synchronized (this.a)
      {
        Map localMap1 = c();
        Map localMap2 = (Map)localMap1.get(paramString1);
        if (localMap2 != null)
        {
          if (!TextUtils.isEmpty(paramString2)) {
            continue;
          }
          localObject1 = paramString1;
          if (localMap2.containsKey(localObject1))
          {
            Object localObject3 = (b)localMap2.get(localObject1);
            localObject3 = this.A.a(((b)localObject3).c);
            localObject1 = h.a(paramString1, localObject1);
            if ((localObject3 == null) || (((com.whatsapp.protocol.j)localObject3).t <= paramLong)) {
              continue;
            }
            Log.i("LocationSharingManager/onReceiveStopSharing; received old sequence number; skip stopping");
            this.r.remove(localObject1);
          }
        }
        localObject1 = this.t.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        ((d)((Iterator)localObject1).next()).a(paramString1, paramString2);
        continue;
        localObject1 = paramString2;
        continue;
        if ((!this.r.containsKey(localObject1)) || (((Long)this.r.get(localObject1)).longValue() < paramLong)) {
          this.r.put(localObject1, Long.valueOf(paramLong));
        }
        if (TextUtils.isEmpty(paramString2))
        {
          localObject1 = paramString1;
          a((b)localMap2.remove(localObject1));
          this.h.a(paramString1, paramString2);
          if (localMap2.isEmpty()) {
            localMap1.remove(paramString1);
          }
          a(localMap1);
        }
      }
      Object localObject1 = paramString2;
    }
    j();
    this.d.a(bv.a(this, paramString1));
  }
  
  public final void a(String paramString, List<String> paramList)
  {
    Log.i("LocationSharingManager/onReceiveServerSharingList; jid=" + paramString + "; participants.size=" + paramList.size());
    HashSet localHashSet = new HashSet();
    Object localObject2;
    Map localMap;
    synchronized (this.a)
    {
      localObject2 = c();
      localMap = (Map)((Map)localObject2).get(paramString);
      if (localMap == null) {
        break label190;
      }
      localHashSet.addAll(localMap.keySet());
      localHashSet.removeAll(paramList);
      paramList = localHashSet.iterator();
      if (paramList.hasNext()) {
        a((b)localMap.remove((String)paramList.next()));
      }
    }
    this.h.a(false, paramString, localHashSet);
    if (localMap.isEmpty()) {
      ((Map)localObject2).remove(paramString);
    }
    if (!localHashSet.isEmpty()) {
      a((Map)localObject2);
    }
    label190:
    paramList = localHashSet.iterator();
    while (paramList.hasNext())
    {
      ??? = (String)paramList.next();
      localObject2 = this.t.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((d)((Iterator)localObject2).next()).a(paramString, (String)???);
      }
    }
    if (!localHashSet.isEmpty()) {
      j();
    }
  }
  
  public final void a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramInt > 4) {
      Log.w("LocationSharingManager/sendLocationKeyRetryRequest/reached max retry; remote_resource=" + paramString + "; retryCount=" + paramInt);
    }
    do
    {
      return;
      long l1;
      synchronized (this.o)
      {
        l1 = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
        if (this.o.containsKey(paramString))
        {
          long l2 = l1 - ((Long)((h)this.o.get(paramString)).a).longValue();
          if ((l2 < 60000L) && (((Integer)((h)this.o.get(paramString)).b).intValue() >= paramInt))
          {
            Log.i("LocationSharingManager/sendLocationKeyRetryRequest/retry too soon; remote_resource=" + paramString + "; timeElapsed=" + l2);
            return;
          }
        }
      }
      Log.i("LocationSharingManager/sendLocationKeyRetryRequest/send; remote_resource=" + paramString + "; retryCount=" + paramInt);
      this.o.put(paramString, h.a(Long.valueOf(l1), Integer.valueOf(paramInt)));
      ??? = this.x;
    } while (!((w)???).b.d);
    ??? = ((w)???).b;
    Message localMessage = Message.obtain(null, 0, 125, 0);
    localMessage.getData().putString("jid", paramString);
    localMessage.getData().putByteArray("registrationId", paramArrayOfByte);
    localMessage.getData().putInt("retryCount", paramInt);
    ((com.whatsapp.messaging.m)???).a(localMessage);
  }
  
  public final void a(Collection<String> paramCollection)
  {
    Log.i("LocationSharingManager/markSentLocationKey; jids.size=" + paramCollection.size());
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    synchronized (this.b)
    {
      h();
      localObject2 = paramCollection.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if ((!this.e.a(str)) && (!this.s.contains(str)) && (this.q.get(str) == e.b))
        {
          this.s.add(str);
          localArrayList.add(str);
          this.q.remove(str);
        }
      }
    }
    if (this.D != null)
    {
      localObject2 = this.D;
      if (this.D.f != null) {
        break label241;
      }
    }
    label241:
    int i1;
    for (long l1 = paramCollection.size();; l1 += i1)
    {
      ((an)localObject2).f = Long.valueOf(l1);
      this.h.a(localArrayList, true);
      if (d()) {
        g();
      }
      b.a.a.c.a().b(new a("location@broadcast"));
      return;
      l1 = this.D.f.longValue();
      i1 = paramCollection.size();
    }
  }
  
  public final boolean a(String paramString, int paramInt)
  {
    if (paramInt > 4)
    {
      Log.w("LocationSharingManager/shouldUserGetLocationKeyRetry/reached max retry; remote_resource=" + paramString + "; retryCount=" + paramInt);
      return false;
    }
    synchronized (this.b)
    {
      if (!h(paramString)) {
        return false;
      }
      long l1 = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
      if (this.p.containsKey(paramString))
      {
        l1 -= ((Long)((h)this.p.get(paramString)).a).longValue();
        if ((l1 < 60000L) && (((Integer)((h)this.p.get(paramString)).b).intValue() >= paramInt))
        {
          Log.i("LocationSharingManager/shouldUserGetLocationKeyRetry/retry too soon; remote_resource=" + paramString + "; timeElapsed=" + l1);
          return false;
        }
      }
      return true;
    }
  }
  
  public final long b(com.whatsapp.protocol.j paramj)
  {
    synchronized (this.b)
    {
      Map localMap = h();
      if ((localMap.containsKey(paramj.e.a)) && (((a)localMap.get(paramj.e.a)).a.equals(paramj.e)))
      {
        long l1 = ((a)localMap.get(paramj.e.a)).c;
        return l1;
      }
      return -1L;
    }
  }
  
  final ArrayList<ap> b(String paramString)
  {
    synchronized (this.a)
    {
      Object localObject2 = (Map)c().get(paramString);
      long l1 = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
      paramString = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((Map)localObject2).values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (b)((Iterator)localObject2).next();
          if ((((b)localObject3).b == 0L) || (((b)localObject3).b > l1))
          {
            localObject3 = (ap)this.m.get(((b)localObject3).a);
            if (localObject3 != null) {
              paramString.add(localObject3);
            }
          }
        }
      }
    }
    return paramString;
  }
  
  public final List<String> b(String paramString, int paramInt)
  {
    ArrayList localArrayList;
    synchronized (this.b)
    {
      if (!a(paramString, paramInt))
      {
        paramString = Collections.emptyList();
        return paramString;
      }
      Object localObject3 = Collections.singletonList(paramString);
      Log.i("LocationSharingManager/markParticipantsAsNeedSenderKey; jids.size" + ((Collection)localObject3).size());
      localArrayList = new ArrayList();
      synchronized (this.b)
      {
        h();
        localObject3 = ((Collection)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          if ((!this.e.a(str)) && (this.s.contains(str)))
          {
            this.s.remove(str);
            localArrayList.add(str);
          }
        }
      }
    }
    this.h.a(localArrayList, false);
    b.a.a.c.a().b(new a("location@broadcast"));
    Log.i("LocationSharingManager/markSendingLocationKeyRetry/marking; remote_resource=" + paramString + "; retryCount=" + paramInt);
    long l1 = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
    this.p.put(paramString, h.a(Long.valueOf(l1), Integer.valueOf(paramInt)));
    paramString = Collections.singletonList(paramString);
    return paramString;
  }
  
  public final void b(c paramc)
  {
    this.c.remove(paramc);
  }
  
  public final void b(d paramd)
  {
    this.t.remove(paramd);
  }
  
  public final void b(String paramString, List<String> paramList)
  {
    Log.i("LocationSharingManager/onParticipantsLeftGroup; gjid=" + paramString + "; participants.size=" + paramList.size());
    int i1 = 0;
    int i2 = 0;
    for (;;)
    {
      synchronized (this.b)
      {
        Map localMap = h();
        if (localMap.containsKey(paramString))
        {
          Iterator localIterator = paramList.iterator();
          i1 = i2;
          if (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            if (((a)localMap.get(paramString)).b.contains(str))
            {
              ((a)localMap.get(paramString)).b.remove(str);
              i1 = 1;
            }
          }
          else
          {
            if (((a)localMap.get(paramString)).b.isEmpty()) {
              a((a)localMap.remove(paramString));
            }
            this.h.a(paramString, paramList);
            f();
          }
        }
        else
        {
          if (i1 != 0)
          {
            i();
            this.d.a(br.a(this, paramString));
          }
          return;
        }
      }
    }
  }
  
  public final void b(List<String> paramList)
  {
    synchronized (this.b)
    {
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        String str = (String)paramList.next();
        this.q.remove(str);
      }
    }
  }
  
  final boolean b(String paramString1, String paramString2)
  {
    synchronized (this.a)
    {
      Map localMap = c();
      if (localMap.containsKey(paramString1))
      {
        localMap = (Map)localMap.get(paramString1);
        if (paramString2 == null) {}
        for (paramString1 = (b)localMap.get(paramString1); paramString1 != null; paramString1 = (b)localMap.get(paramString2))
        {
          long l1 = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
          if ((paramString1.b != 0L) && (paramString1.b <= l1)) {
            break;
          }
          return true;
        }
      }
      return false;
    }
  }
  
  final Map<String, Map<String, b>> c()
  {
    HashSet localHashSet2;
    for (;;)
    {
      String str1;
      synchronized (this.a)
      {
        if (this.l != null) {
          break label346;
        }
        this.m.putAll(this.h.e());
        HashSet localHashSet1 = new HashSet(this.m.keySet());
        this.l = new HashMap();
        long l1 = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
        this.h.a(false, l1);
        Map localMap2 = this.h.c();
        localHashSet2 = new HashSet();
        Iterator localIterator1 = localMap2.keySet().iterator();
        if (!localIterator1.hasNext()) {
          break;
        }
        str1 = (String)localIterator1.next();
        if (this.z.e(str1) != null)
        {
          if (!this.l.containsKey(str1)) {
            this.l.put(str1, new HashMap());
          }
          Iterator localIterator2 = ((Map)localMap2.get(str1)).keySet().iterator();
          if (!localIterator2.hasNext()) {
            continue;
          }
          String str2 = (String)localIterator2.next();
          ((Map)this.l.get(str1)).put(str2, ((Map)localMap2.get(str1)).get(str2));
          localHashSet1.remove(str2);
        }
      }
      localHashSet2.add(str1);
    }
    if (!localHashSet2.isEmpty()) {
      this.h.a(false, localHashSet2);
    }
    if (!localCollection.isEmpty()) {
      this.h.a(localCollection);
    }
    i();
    label346:
    Map localMap1 = this.l;
    return localMap1;
  }
  
  public final void c(String paramString)
  {
    Log.i("LocationSharingManager/onReceiveDenySharing; jid=" + paramString);
    HashSet localHashSet = new HashSet();
    synchronized (this.a)
    {
      Iterator localIterator1 = c().entrySet().iterator();
      Map.Entry localEntry;
      Iterator localIterator2;
      do
      {
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localEntry = (Map.Entry)localIterator1.next();
          localIterator2 = ((Map)localEntry.getValue()).keySet().iterator();
        }
      } while (!paramString.equals((String)localIterator2.next()));
      localHashSet.add(localEntry.getKey());
    }
    ??? = localHashSet.iterator();
    while (((Iterator)???).hasNext()) {
      a((String)((Iterator)???).next(), paramString);
    }
  }
  
  public final void d(String paramString)
  {
    Log.i("LocationSharingManager/onMeLeftGroup; gjid=" + paramString);
    g(paramString);
    synchronized (this.a)
    {
      Map localMap = (Map)c().remove(paramString);
      if (localMap != null)
      {
        ??? = localMap.values().iterator();
        if (((Iterator)???).hasNext()) {
          a(paramString, ((b)((Iterator)???).next()).a);
        }
      }
    }
  }
  
  public final boolean d()
  {
    synchronized (this.b)
    {
      Object localObject2 = h();
      long l1 = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
      localObject2 = ((Map)localObject2).values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        long l2 = ((a)((Iterator)localObject2).next()).c;
        if ((l2 == 0L) || (l2 > l1)) {
          return true;
        }
      }
      return false;
    }
  }
  
  final long e()
  {
    synchronized (this.b)
    {
      long l2 = this.B.a.getLong("live_location_sequence_number", -1L);
      long l1 = l2;
      if (this.w.a * 1000L > l2)
      {
        l1 = this.w.a * 1000L;
        Log.i("LocationSharingManager/getNextSequenceNumber; got a new sequence number; currentSequenceNumber=" + l1);
      }
      l1 += 1L;
      this.B.c().putLong("live_location_sequence_number", l1).apply();
      return l1;
    }
  }
  
  public final long e(String paramString)
  {
    synchronized (this.b)
    {
      Map localMap = h();
      if (localMap.containsKey(paramString))
      {
        long l1 = ((a)localMap.get(paramString)).c;
        return l1;
      }
      return -1L;
    }
  }
  
  public final void f()
  {
    synchronized (this.b)
    {
      Set localSet = n();
      HashSet localHashSet = new HashSet(this.s);
      localHashSet.removeAll(localSet);
      if (!localHashSet.isEmpty()) {
        o();
      }
      return;
    }
  }
  
  public final boolean f(String paramString)
  {
    synchronized (this.b)
    {
      Map localMap = h();
      if (localMap.containsKey(paramString))
      {
        long l1 = ((a)localMap.get(paramString)).c;
        long l2 = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
        if ((l1 == 0L) || (l1 > l2)) {
          return true;
        }
        g(paramString);
      }
      return false;
    }
  }
  
  /* Error */
  final void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 555	com/whatsapp/location/bp:C	Lcom/whatsapp/protocol/ap;
    //   6: astore_3
    //   7: aload_0
    //   8: getfield 557	com/whatsapp/location/bp:D	Lcom/whatsapp/fieldstats/events/an;
    //   11: astore 4
    //   13: aload_0
    //   14: aconst_null
    //   15: putfield 557	com/whatsapp/location/bp:D	Lcom/whatsapp/fieldstats/events/an;
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_3
    //   21: ifnull +247 -> 268
    //   24: aload 4
    //   26: ifnull +20 -> 46
    //   29: aload 4
    //   31: iconst_1
    //   32: invokestatic 730	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   35: putfield 903	com/whatsapp/fieldstats/events/an:c	Ljava/lang/Integer;
    //   38: invokestatic 230	com/whatsapp/u:a	()Landroid/content/Context;
    //   41: aload 4
    //   43: invokestatic 908	com/whatsapp/fieldstats/l:b	(Landroid/content/Context;Lcom/whatsapp/fieldstats/e;)V
    //   46: invokestatic 914	com/whatsapp/proto/E2E$Message:newBuilder	()Lcom/whatsapp/proto/E2E$Message$a;
    //   49: astore 4
    //   51: aload 4
    //   53: invokevirtual 920	com/whatsapp/proto/E2E$Message$a:getLiveLocationMessageBuilder	()Lcom/whatsapp/proto/E2E$Message$LiveLocationMessage$a;
    //   56: astore 5
    //   58: aload 5
    //   60: aload_3
    //   61: getfield 514	com/whatsapp/protocol/ap:b	D
    //   64: invokevirtual 926	com/whatsapp/proto/E2E$Message$LiveLocationMessage$a:setDegreesLatitude	(D)Lcom/whatsapp/proto/E2E$Message$LiveLocationMessage$a;
    //   67: pop
    //   68: aload 5
    //   70: aload_3
    //   71: getfield 519	com/whatsapp/protocol/ap:c	D
    //   74: invokevirtual 929	com/whatsapp/proto/E2E$Message$LiveLocationMessage$a:setDegreesLongitude	(D)Lcom/whatsapp/proto/E2E$Message$LiveLocationMessage$a;
    //   77: pop
    //   78: aload_3
    //   79: getfield 528	com/whatsapp/protocol/ap:d	I
    //   82: getstatic 931	com/whatsapp/protocol/ap:h	I
    //   85: if_icmpeq +13 -> 98
    //   88: aload 5
    //   90: aload_3
    //   91: getfield 528	com/whatsapp/protocol/ap:d	I
    //   94: invokevirtual 935	com/whatsapp/proto/E2E$Message$LiveLocationMessage$a:setAccuracyInMeters	(I)Lcom/whatsapp/proto/E2E$Message$LiveLocationMessage$a;
    //   97: pop
    //   98: aload_3
    //   99: getfield 538	com/whatsapp/protocol/ap:e	F
    //   102: getstatic 937	com/whatsapp/protocol/ap:i	F
    //   105: fcmpl
    //   106: ifeq +13 -> 119
    //   109: aload 5
    //   111: aload_3
    //   112: getfield 538	com/whatsapp/protocol/ap:e	F
    //   115: invokevirtual 941	com/whatsapp/proto/E2E$Message$LiveLocationMessage$a:setSpeedInMps	(F)Lcom/whatsapp/proto/E2E$Message$LiveLocationMessage$a;
    //   118: pop
    //   119: aload_3
    //   120: getfield 546	com/whatsapp/protocol/ap:f	I
    //   123: getstatic 943	com/whatsapp/protocol/ap:j	I
    //   126: if_icmpeq +13 -> 139
    //   129: aload 5
    //   131: aload_3
    //   132: getfield 546	com/whatsapp/protocol/ap:f	I
    //   135: invokevirtual 946	com/whatsapp/proto/E2E$Message$LiveLocationMessage$a:setDegreesClockwiseFromMagneticNorth	(I)Lcom/whatsapp/proto/E2E$Message$LiveLocationMessage$a;
    //   138: pop
    //   139: aload 4
    //   141: invokevirtual 950	com/whatsapp/proto/E2E$Message$a:build	()Lcom/whatsapp/proto/E2E$Message;
    //   144: getstatic 85	com/whatsapp/location/bp:j	Ljava/util/Random;
    //   147: invokestatic 955	a/a/a/a/d:a	(Lcom/whatsapp/proto/E2E$Message;Ljava/util/Random;)[B
    //   150: astore 4
    //   152: aload_0
    //   153: getfield 131	com/whatsapp/location/bp:w	Lcom/whatsapp/ant;
    //   156: invokevirtual 553	com/whatsapp/ant:b	()J
    //   159: aload_3
    //   160: getfield 551	com/whatsapp/protocol/ap:g	J
    //   163: lsub
    //   164: ldc2_w 877
    //   167: ldiv
    //   168: lstore_1
    //   169: getstatic 958	com/whatsapp/a/c:a	Ljava/util/concurrent/ExecutorService;
    //   172: aload_0
    //   173: aload 4
    //   175: invokestatic 963	com/whatsapp/location/bq:a	(Lcom/whatsapp/location/bp;[B)Ljava/util/concurrent/Callable;
    //   178: invokeinterface 969 2 0
    //   183: invokeinterface 973 1 0
    //   188: checkcast 975	com/whatsapp/protocol/f
    //   191: astore_3
    //   192: aload_0
    //   193: getfield 137	com/whatsapp/location/bp:x	Lcom/whatsapp/messaging/w;
    //   196: astore 4
    //   198: aload 4
    //   200: getfield 733	com/whatsapp/messaging/w:b	Lcom/whatsapp/messaging/m;
    //   203: getfield 738	com/whatsapp/messaging/m:d	Z
    //   206: ifeq +47 -> 253
    //   209: new 413	java/lang/StringBuilder
    //   212: dup
    //   213: ldc_w 977
    //   216: invokespecial 417	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   219: lload_1
    //   220: invokevirtual 611	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: invokevirtual 430	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 307	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   229: aload 4
    //   231: getfield 733	com/whatsapp/messaging/w:b	Lcom/whatsapp/messaging/m;
    //   234: aconst_null
    //   235: iconst_0
    //   236: bipush 84
    //   238: iconst_0
    //   239: lload_1
    //   240: invokestatic 566	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   243: aload_3
    //   244: invokestatic 983	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   247: invokestatic 986	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
    //   250: invokevirtual 770	com/whatsapp/messaging/m:a	(Landroid/os/Message;)V
    //   253: return
    //   254: astore_3
    //   255: aload_0
    //   256: monitorexit
    //   257: aload_3
    //   258: athrow
    //   259: astore_3
    //   260: ldc_w 988
    //   263: aload_3
    //   264: invokestatic 440	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   267: return
    //   268: ldc_w 990
    //   271: invokestatic 601	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   274: return
    //   275: astore_3
    //   276: goto -16 -> 260
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	bp
    //   168	72	1	l1	long
    //   6	238	3	localObject1	Object
    //   254	4	3	localObject2	Object
    //   259	5	3	localInterruptedException	InterruptedException
    //   275	1	3	localExecutionException	java.util.concurrent.ExecutionException
    //   11	219	4	localObject3	Object
    //   56	74	5	locala	com.whatsapp.proto.E2E.Message.LiveLocationMessage.a
    // Exception table:
    //   from	to	target	type
    //   2	20	254	finally
    //   255	257	254	finally
    //   169	253	259	java/lang/InterruptedException
    //   169	253	275	java/util/concurrent/ExecutionException
  }
  
  public final boolean g(String paramString)
  {
    Log.i("LocationSharingManager/cancelShareLocation; jid=" + paramString);
    long l1;
    synchronized (this.b)
    {
      Object localObject2 = (a)h().remove(paramString);
      if (localObject2 == null) {
        return false;
      }
      a((a)localObject2);
      this.h.a(Collections.singletonList(paramString));
      Set localSet = n();
      localObject2 = ((a)localObject2).b.iterator();
      while (((Iterator)localObject2).hasNext()) {
        if (!localSet.contains((String)((Iterator)localObject2).next())) {
          o();
        }
      }
      l1 = e();
      ??? = this.c.iterator();
      if (((Iterator)???).hasNext()) {
        ((c)((Iterator)???).next()).b(paramString);
      }
    }
    i();
    this.d.a(by.a(this, paramString));
    if (!d()) {
      b();
    }
    this.y.a(new SendDisableLiveLocationJob(paramString, l1));
    return true;
  }
  
  public final Map<String, a> h()
  {
    HashSet localHashSet;
    for (;;)
    {
      String str;
      synchronized (this.b)
      {
        if (this.n != null) {
          break label237;
        }
        this.n = new HashMap();
        long l1 = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
        this.h.a(true, l1);
        Map localMap = this.h.b();
        localHashSet = new HashSet();
        Iterator localIterator = localMap.keySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
        if (this.z.e(str) != null) {
          this.n.put(str, localMap.get(str));
        }
      }
      localHashSet.add(str);
    }
    if (!localHashSet.isEmpty()) {
      this.h.a(localHashSet);
    }
    this.s.addAll(this.h.d());
    Object localObject3 = new HashSet(this.s);
    ((Set)localObject3).removeAll(n());
    if (!((Set)localObject3).isEmpty()) {
      o();
    }
    i();
    label237:
    localObject3 = this.n;
    return (Map<String, a>)localObject3;
  }
  
  public final boolean h(String paramString)
  {
    synchronized (this.b)
    {
      boolean bool = n().contains(paramString);
      return bool;
    }
  }
  
  public final void i()
  {
    this.d.b(this.u);
    Long localLong = null;
    for (;;)
    {
      synchronized (this.b)
      {
        Iterator localIterator = h().values().iterator();
        if (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if ((localLong == null) || (locala.c < localLong.longValue())) {
            localLong = Long.valueOf(locala.c);
          }
        }
        else
        {
          if (localLong != null)
          {
            long l1 = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
            if (localLong.longValue() > l1) {
              this.d.a(this.u, localLong.longValue() - l1);
            }
          }
          return;
        }
      }
    }
  }
  
  final void j()
  {
    this.d.b(this.v);
    Object localObject3 = null;
    for (;;)
    {
      synchronized (this.a)
      {
        Iterator localIterator1 = c().values().iterator();
        if (localIterator1.hasNext())
        {
          Iterator localIterator2 = ((Map)localIterator1.next()).values().iterator();
          Object localObject1 = localObject3;
          localObject3 = localObject1;
          if (localIterator2.hasNext())
          {
            localObject3 = (b)localIterator2.next();
            if ((localObject1 == null) || (((b)localObject3).b < ((Long)localObject1).longValue())) {
              localObject1 = Long.valueOf(((b)localObject3).b);
            }
          }
        }
        else
        {
          if (localObject3 != null)
          {
            long l1 = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
            if (((Long)localObject3).longValue() > l1) {
              this.d.a(this.v, ((Long)localObject3).longValue() - l1);
            }
          }
          return;
        }
      }
    }
  }
  
  public final List<String> k()
  {
    synchronized (this.b)
    {
      h();
      Object localObject2 = n();
      ((Set)localObject2).removeAll(this.s);
      Log.i("LocationSharingManager/getJidsNeedingSenderKey; jids.size=" + ((Set)localObject2).size());
      localObject2 = new ArrayList((Collection)localObject2);
      return (List<String>)localObject2;
    }
  }
  
  public final List<cs> l()
  {
    synchronized (this.b)
    {
      Object localObject2 = h();
      ArrayList localArrayList = new ArrayList(((Map)localObject2).size());
      long l1 = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
      localObject2 = ((Map)localObject2).values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        a locala = (a)((Iterator)localObject2).next();
        if ((locala.c == 0L) || (locala.c > l1)) {
          localArrayList.add(this.z.c(locala.a.a));
        }
      }
    }
    return localList;
  }
  
  public final boolean m()
  {
    synchronized (this.b)
    {
      List localList1 = k();
      localList1.removeAll(this.q.keySet());
      Iterator localIterator = localList1.iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.q.put(str, e.a);
      }
    }
    if (!localList2.isEmpty())
    {
      this.y.a(new SendLiveLocationKeyJob(localList2));
      return true;
    }
    return false;
  }
  
  public static final class a
  {
    public final j.b a;
    public final List<String> b = new ArrayList();
    public final long c;
    
    a(long paramLong, List<String> paramList, j.b paramb)
    {
      this.a = paramb;
      this.c = paramLong;
      if (paramList != null) {
        this.b.addAll(paramList);
      }
    }
  }
  
  static final class b
  {
    public final String a;
    public final long b;
    public final j.b c;
    
    b(String paramString, long paramLong, j.b paramb)
    {
      this.a = paramString;
      this.b = paramLong;
      this.c = paramb;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(String paramString);
    
    public abstract void b(String paramString);
  }
  
  public static abstract interface d
  {
    public abstract void a(ap paramap);
    
    public abstract void a(String paramString);
    
    public abstract void a(String paramString1, String paramString2);
  }
  
  static enum e
  {
    private e() {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/location/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */