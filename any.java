package com.whatsapp;

import android.os.SystemClock;
import com.whatsapp.fieldstats.events.d;
import com.whatsapp.fieldstats.l;
import com.whatsapp.k.h;
import com.whatsapp.util.MediaFileUtils.f;

public final class any
{
  private static final h a = new h(20, 200);
  private static final h b = new h(1, 10);
  private final d c = new d();
  private final long d = SystemClock.uptimeMillis();
  
  public final any a()
  {
    this.c.n = "trim";
    return this;
  }
  
  public final any a(int paramInt)
  {
    this.c.c = Long.valueOf(paramInt);
    return this;
  }
  
  public final any a(int paramInt1, int paramInt2)
  {
    this.c.h = Long.valueOf(paramInt1);
    this.c.i = Long.valueOf(paramInt2);
    return this;
  }
  
  public final any a(long paramLong)
  {
    this.c.g = Long.valueOf(paramLong);
    return this;
  }
  
  public final any a(MediaFileUtils.f paramf)
  {
    this.c.b = Long.valueOf(paramf.a);
    this.c.d = Long.valueOf(paramf.b);
    this.c.e = Long.valueOf(paramf.a() / 1000);
    this.c.f = Long.valueOf(paramf.c / 1000L);
    return this;
  }
  
  public final any a(String paramString)
  {
    this.c.o = paramString;
    return this;
  }
  
  public final any a(boolean paramBoolean)
  {
    this.c.a = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public final any b()
  {
    this.c.n = "transcode";
    return this;
  }
  
  public final any b(int paramInt)
  {
    this.c.k = Long.valueOf(paramInt);
    return this;
  }
  
  public final any b(long paramLong)
  {
    this.c.l = Long.valueOf(paramLong);
    return this;
  }
  
  public final any b(boolean paramBoolean)
  {
    this.c.m = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public final any c()
  {
    this.c.n = "checkAndRepair";
    return this;
  }
  
  public final void d()
  {
    if (a.a(1))
    {
      this.c.p = Boolean.valueOf(true);
      this.c.q = Double.valueOf(SystemClock.uptimeMillis() - this.d);
      l.a(u.a(), this.c, a.b(1));
    }
  }
  
  public final void e()
  {
    if (b.a(1))
    {
      this.c.p = Boolean.valueOf(false);
      this.c.q = Double.valueOf(SystemClock.uptimeMillis() - this.d);
      l.a(u.a(), this.c, b.b(1));
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/any.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */