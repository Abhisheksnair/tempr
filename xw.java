package com.whatsapp;

import android.os.SystemClock;

public final class xw
{
  long a;
  Long b;
  Long c;
  Long d;
  Long e;
  public long f;
  Long g;
  public Long h;
  public Long i;
  public boolean j;
  public String k;
  public String l;
  public boolean m;
  public final int n;
  private Long o;
  private Long p;
  private Long q;
  private Long r;
  
  public xw(boolean paramBoolean)
  {
    this.m = paramBoolean;
    this.n = 0;
  }
  
  public final void a()
  {
    this.r = Long.valueOf(SystemClock.uptimeMillis());
  }
  
  public final void a(long paramLong)
  {
    this.p = Long.valueOf(paramLong);
  }
  
  public final Double b()
  {
    if ((this.g != null) && (this.r != null) && (this.r.longValue() > this.g.longValue())) {
      return Double.valueOf(this.r.longValue() - this.g.longValue());
    }
    return null;
  }
  
  public final void b(long paramLong)
  {
    this.q = Long.valueOf(paramLong);
  }
  
  public final void c()
  {
    this.o = Long.valueOf(SystemClock.uptimeMillis());
  }
  
  public final Double d()
  {
    if ((this.c != null) && (this.o != null) && (this.o.longValue() > this.c.longValue())) {
      return Double.valueOf(this.o.longValue() - this.c.longValue());
    }
    return null;
  }
  
  public final Double e()
  {
    if ((this.p != null) && (this.p.longValue() >= 0L)) {
      return Double.valueOf(this.p.longValue());
    }
    return null;
  }
  
  public final Double f()
  {
    if ((this.q != null) && (this.q.longValue() >= 0L)) {
      return Double.valueOf(this.q.longValue());
    }
    return null;
  }
  
  public final long g()
  {
    if (this.a > 0L) {
      return SystemClock.uptimeMillis() - this.a;
    }
    return -1L;
  }
  
  public final long h()
  {
    return SystemClock.uptimeMillis() - this.b.longValue();
  }
  
  public final long i()
  {
    if ((this.d != null) && (this.e != null)) {
      return this.e.longValue() - this.d.longValue();
    }
    return -1L;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/xw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */