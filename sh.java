package com.whatsapp;

import a.a.a.a.d;
import android.content.SharedPreferences;
import com.whatsapp.data.ad;
import com.whatsapp.data.ci;
import com.whatsapp.data.e;
import com.whatsapp.g.m;
import com.whatsapp.jobqueue.job.GetVNameCertificateJob;
import com.whatsapp.location.bp;
import com.whatsapp.location.bp.a;
import com.whatsapp.location.bz;
import com.whatsapp.location.cb;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class sh
{
  public static volatile sh a;
  private final ant b;
  private final va c;
  private final ad d;
  private final att e;
  private final e f;
  private final atv g;
  private final lt h;
  private final bp i;
  private final ci j;
  private final rh k;
  
  private sh(ant paramant, va paramva, ad paramad, att paramatt, e parame, atv paramatv, lt paramlt, bp parambp, ci paramci, rh paramrh)
  {
    this.b = paramant;
    this.c = paramva;
    this.d = paramad;
    this.e = paramatt;
    this.f = parame;
    this.g = paramatv;
    this.h = paramlt;
    this.i = parambp;
    this.j = paramci;
    this.k = paramrh;
  }
  
  public static sh a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new sh(ant.a(), va.a(), ad.a(), att.a(), e.a(), atv.a(), lt.a(), bp.a(), ci.a(), rh.a());
      }
      return a;
    }
    finally {}
  }
  
  public void onEvent(m paramm)
  {
    boolean bool = this.g.a.getBoolean("security_notifications", false);
    if (paramm.b != null)
    {
      this.j.b(paramm.a);
      Object localObject1 = this.i;
      Object localObject3 = paramm.a;
      Log.i("LocationSharingManager/onUserIdentityChange; jid=" + (String)localObject3);
      Object localObject4 = new ArrayList();
      synchronized (((bp)localObject1).b)
      {
        Map localMap = ((bp)localObject1).h();
        Iterator localIterator = localMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject5 = (Map.Entry)localIterator.next();
          String str = (String)((Map.Entry)localObject5).getKey();
          localObject5 = (bp.a)((Map.Entry)localObject5).getValue();
          if (((bp.a)localObject5).b.contains(localObject3))
          {
            ((bp.a)localObject5).b.remove(localObject3);
            ((bp)localObject1).h.a(str, Collections.singletonList(localObject3));
            if (((bp.a)localObject5).b.isEmpty()) {
              ((bp)localObject1).a((bp.a)localMap.remove(str));
            }
            ((List)localObject4).add(str);
          }
        }
      }
      ((bp)localObject1).f();
      if (!((List)localObject4).isEmpty())
      {
        ((bp)localObject1).i();
        ??? = ((List)localObject4).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (String)((Iterator)???).next();
          ((bp)localObject1).d.a(bz.a((bp)localObject1, (String)localObject3));
        }
      }
      if (bool) {
        this.d.b(d.a(this.b, this.c, paramm.a, null), -1);
      }
      localObject1 = this.h.h().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        ??? = (String)((Iterator)localObject1).next();
        localObject3 = this.k.a((String)???);
        localObject4 = ((rg)localObject3).a(paramm.a);
        if (localObject4 != null) {
          ((rf)localObject4).d = false;
        }
        if (bool)
        {
          localObject3 = ((rg)localObject3).a();
          if ((((Set)localObject3).contains(paramm.a)) && ((((Set)localObject3).contains(this.c.c().t)) || (j.b((String)???)))) {
            this.d.b(d.a(this.b, this.c, (String)???, paramm.a), -1);
          }
        }
      }
      if (this.f.j(paramm.a) != null)
      {
        Log.i("refreshing verified name due to identity change; jid=" + paramm.a);
        this.f.i(paramm.a);
        this.f.k(paramm.a);
        this.e.a(new GetVNameCertificateJob(paramm.a));
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/sh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */