package com.whatsapp.l;

import android.os.SystemClock;
import com.whatsapp.aic;
import com.whatsapp.fieldstats.events.bk;
import com.whatsapp.fieldstats.l;
import com.whatsapp.messaging.w;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class e
{
  private static volatile e g;
  public g a;
  public final Object b = new Object();
  h c;
  public b d;
  public volatile boolean e = false;
  public final b f;
  private final Object h = new Object();
  private long i;
  private AtomicLong j = new AtomicLong();
  private final w k;
  private final a l;
  
  private e(w paramw, a parama, b paramb)
  {
    this.l = parama;
    this.k = paramw;
    this.f = paramb;
  }
  
  public static e a()
  {
    if (g == null) {}
    try
    {
      if (g == null) {
        g = new e(w.a(), new a(), new b());
      }
      return g;
    }
    finally {}
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String paramString4)
  {
    Log.i("routeselector/selectroute/selecting authority " + paramString3);
    for (;;)
    {
      synchronized (this.h)
      {
        this.c = new h(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramString4);
        paramString2 = this.c;
        this.h.notifyAll();
        if (paramString2.a != null)
        {
          paramString1 = paramString2.a.split("\\.")[0];
          paramString3 = new bk();
          paramString3.a = paramString1;
          paramString3.b = paramString2.b;
          paramString3.e = Long.valueOf(paramString2.d);
          if (paramString2.e >= 0) {
            paramString3.f = Long.valueOf(paramString2.e);
          }
          paramString3.c = Double.valueOf(SystemClock.elapsedRealtime() - this.i);
          paramString3.d = Double.valueOf(this.j.get());
          l.a(u.a(), paramString3);
          return;
        }
      }
      paramString1 = null;
    }
  }
  
  private boolean a(g paramg, AtomicBoolean paramAtomicBoolean)
  {
    int m = 0;
    boolean bool1 = false;
    for (;;)
    {
      int n;
      try
      {
        if ((m >= paramg.c.size()) || (bool1) || (paramAtomicBoolean.get())) {
          break label275;
        }
        locald = (d)paramg.c.get(m);
        str1 = locald.a;
        if (str1.endsWith(".whatsapp.net")) {
          break label269;
        }
        Log.w("routeselector/performrouteselectioninternal rejecting non-conforming route class hostname " + str1);
      }
      catch (a paramg)
      {
        d locald;
        String str1;
        String str2;
        boolean bool2;
        Log.w("routeselector/performrouteselectioninternal/restarting route selection");
        d();
        return false;
      }
      if ((n < locald.b.size()) && (!bool1) && (!paramAtomicBoolean.get()))
      {
        str2 = (String)locald.b.get(n);
        bool1 = a(str2, locald.a, paramg.a);
        if ((bool1) && (!paramAtomicBoolean.get()))
        {
          a(str1, str2, str2, m, n, paramg.a);
          return true;
        }
      }
      else
      {
        if ((!bool1) && (!paramAtomicBoolean.get()))
        {
          str2 = locald.a;
          bool2 = a(str2, locald.a, paramg.a);
          bool1 = bool2;
          if (bool2)
          {
            bool1 = bool2;
            if (!paramAtomicBoolean.get())
            {
              a(str1, null, str2, m, -1, paramg.a);
              return true;
            }
          }
        }
        m += 1;
        continue;
        label269:
        n = 0;
        continue;
        label275:
        return bool1;
      }
      n += 1;
    }
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    int m = a.a(paramString1, paramString2, paramString3, this.j);
    Log.i("routeselector/checkauth/got responseCode=" + m + " for authority " + paramString1);
    switch (m)
    {
    default: 
      return false;
    case 200: 
      return true;
    }
    throw new a((byte)0);
  }
  
  private h e()
  {
    Log.i("routeselector/getroutewithoutrunningrouteselection");
    synchronized (this.h)
    {
      if (this.c != null)
      {
        Log.i("routeselector/getroutewithoutrunningrouteselection/have a route ready");
        h localh = this.c;
        return localh;
      }
      ??? = f();
      if (??? == null) {
        return null;
      }
    }
    if (((g)???).c.isEmpty())
    {
      Log.w("routeselector/getroutewithoutrunningrouteselection/no routes provided in routing response");
      return new h("mms.whatsapp.net", null, "mms.whatsapp.net", 0, -1, ((g)???).a);
    }
    d locald = (d)((g)???).c.get(0);
    Log.d("routeselector/getroutewithoutrunningrouteselection/got first route class from routing response");
    return new h(locald.a, null, locald.a, 0, -1, ((g)???).a);
  }
  
  private g f()
  {
    Log.d("routeselector/waitforroutingresponse");
    long l1 = SystemClock.uptimeMillis();
    for (;;)
    {
      synchronized (this.b)
      {
        if (!g())
        {
          g localg = this.a;
          return localg;
        }
      }
      try
      {
        this.b.wait(1000L);
        if (g()) {
          Log.w("routeselector/waitforroutingresponse/routing response still not available");
        }
        if (20000L + l1 < SystemClock.uptimeMillis())
        {
          Log.w("routeselector/waitforroutingresponse/waited too long for routing response!");
          return null;
          localObject2 = finally;
          throw ((Throwable)localObject2);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Log.c("routeselector/waitforroutingresponse/interrupted while waiting on route selection", localInterruptedException);
        }
      }
    }
  }
  
  private boolean g()
  {
    return (this.a == null) || (this.a.b <= SystemClock.elapsedRealtime());
  }
  
  public final void a(int paramInt)
  {
    Log.i("routeselector/onmediatransfererrororresponsecode/code " + paramInt);
    if ((paramInt == 401) || (paramInt == 403)) {
      d();
    }
  }
  
  public final h b()
  {
    Log.i("routeselector/getselectedroute");
    c();
    return e();
  }
  
  public final void c()
  {
    Log.i("routeselector/requestroutinginfoifalmostexpired");
    int m;
    if ((this.a == null) || (this.a.b <= SystemClock.elapsedRealtime() + 60000L)) {
      m = 1;
    }
    for (;;)
    {
      if (m != 0) {}
      synchronized (this.h)
      {
        if (g())
        {
          Log.i("routeselector/requestroutinginfoifexpired/nullifying expired route");
          this.c = null;
        }
        d();
        return;
        m = 0;
      }
    }
  }
  
  public final void d()
  {
    Log.i("routeselector/requestupdatedroutinginfo");
    if ((aic.i()) && (!this.e))
    {
      this.i = SystemClock.elapsedRealtime();
      this.e = this.k.i();
      return;
    }
    Log.w("routeselector/requestupdatedroutinginfo/not sending request; MMS4_ENABLED=" + aic.i() + " isGetMediaRoutingInfoRequestInFlight=" + this.e);
  }
  
  static final class a
    extends Exception
  {}
  
  public final class b
    implements Runnable
  {
    private g b;
    private AtomicBoolean c = new AtomicBoolean(false);
    
    private b(g paramg)
    {
      this.b = paramg;
    }
    
    public final void run()
    {
      e.a(e.this, this.b, this.c);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/l/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */