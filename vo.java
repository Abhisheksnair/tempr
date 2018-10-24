package com.whatsapp;

import a.a.a.a.a.a.d;
import android.os.SystemClock;
import java.net.URL;

public final class vo
{
  public final vk.a a;
  final int b;
  public final int c;
  URL d;
  public boolean e;
  Long f;
  Long g;
  public vk.c h;
  Long i;
  Long j;
  public long k;
  public Long l;
  public String m;
  public String n;
  a o;
  private Long p;
  private Long q;
  private Long r;
  private Long s;
  private Long t;
  
  public vo(int paramInt, vk.a parama)
  {
    this.a = parama;
    this.b = paramInt;
    this.c = 0;
  }
  
  private boolean p()
  {
    return this.g != null;
  }
  
  final void a()
  {
    if (this.f != null) {}
    for (boolean bool = true;; bool = false)
    {
      a.d.a(bool);
      this.s = Long.valueOf(SystemClock.elapsedRealtime() - this.f.longValue());
      this.o = a.b;
      return;
    }
  }
  
  final void a(long paramLong)
  {
    this.q = Long.valueOf(paramLong);
  }
  
  public final void a(Exception paramException)
  {
    if ((paramException instanceof MediaDownloadConnection.ConnectionFailureException)) {
      this.n = ((MediaDownloadConnection.ConnectionFailureException)paramException).getException().getClass().getName();
    }
    while (paramException == null) {
      return;
    }
    this.n = paramException.getClass().getName();
  }
  
  final void b()
  {
    boolean bool2 = true;
    if (this.f != null)
    {
      bool1 = true;
      a.d.a(bool1);
      if (this.s == null) {
        break label59;
      }
    }
    label59:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a.d.a(bool1);
      this.i = Long.valueOf(SystemClock.elapsedRealtime() - this.f.longValue());
      this.o = a.c;
      return;
      bool1 = false;
      break;
    }
  }
  
  final void c()
  {
    if (this.f != null) {}
    for (boolean bool = true;; bool = false)
    {
      a.d.a(bool);
      this.r = Long.valueOf(SystemClock.elapsedRealtime() - this.f.longValue());
      return;
    }
  }
  
  final void d()
  {
    this.p = Long.valueOf(SystemClock.elapsedRealtime());
    this.o = a.d;
  }
  
  final void e()
  {
    if (this.p != null) {}
    for (boolean bool = true;; bool = false)
    {
      a.d.a(bool);
      this.t = Long.valueOf(SystemClock.elapsedRealtime() - this.p.longValue());
      return;
    }
  }
  
  public final long f()
  {
    if (this.q != null) {
      return this.q.longValue();
    }
    return 0L;
  }
  
  public final long g()
  {
    if (this.f == null) {}
    do
    {
      return 0L;
      if (this.r != null) {
        return this.r.longValue();
      }
    } while (p());
    return SystemClock.elapsedRealtime() - this.f.longValue();
  }
  
  public final long h()
  {
    if (this.f == null) {}
    do
    {
      return 0L;
      if (this.s != null) {
        return this.s.longValue();
      }
    } while (p());
    return SystemClock.elapsedRealtime() - this.f.longValue();
  }
  
  public final long i()
  {
    if (this.f == null) {}
    do
    {
      return 0L;
      if (this.i != null) {
        return this.i.longValue();
      }
    } while (p());
    return SystemClock.elapsedRealtime() - this.f.longValue();
  }
  
  public final long j()
  {
    if (this.p == null) {}
    do
    {
      return 0L;
      if (this.t != null) {
        return this.t.longValue();
      }
    } while (p());
    return SystemClock.elapsedRealtime() - this.p.longValue();
  }
  
  public final Long k()
  {
    if (this.f == null) {
      return Long.valueOf(0L);
    }
    if (this.g != null) {
      return Long.valueOf(this.g.longValue() - this.f.longValue());
    }
    return Long.valueOf(SystemClock.elapsedRealtime() - this.f.longValue());
  }
  
  final boolean l()
  {
    return this.r != null;
  }
  
  final boolean m()
  {
    return this.s != null;
  }
  
  public final boolean n()
  {
    return (this.d != null) && ((this.d.getHost().endsWith("mme.whatsapp.net")) || (this.d.getHost().endsWith(".cdn.whatsapp.net")));
  }
  
  public final String o()
  {
    if (this.d == null) {
      return null;
    }
    return this.d.getHost().split("\\.")[0];
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/vo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */