package com.whatsapp.k;

import android.os.SystemClock;
import com.whatsapp.fieldstats.events.f;
import com.whatsapp.fieldstats.l;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.v;
import java.util.HashMap;
import java.util.Map;

public final class a
  implements d
{
  private final String a;
  private final int b;
  private Map<d.e, Long> c;
  private Map<d.e, Long> d;
  private Map<d.a, Boolean> e;
  private Map<d.b, Integer> f;
  private Map<d.d, String> g;
  private long h;
  private d.c i;
  private long j;
  
  a(String paramString)
  {
    this(paramString, 1);
  }
  
  a(String paramString, int paramInt)
  {
    this.a = paramString;
    this.c = new HashMap();
    this.d = new HashMap();
    this.e = new HashMap();
    this.f = new HashMap();
    this.g = new HashMap();
    this.i = d.c.a;
    this.b = paramInt;
  }
  
  private void d(long paramLong)
  {
    f localf = new f();
    localf.m = this.a;
    localf.a = Double.valueOf(paramLong);
    if (this.d.containsKey(d.e.a)) {
      localf.b = Double.valueOf(((Long)this.d.get(d.e.a)).longValue());
    }
    if (this.d.containsKey(d.e.b)) {
      localf.c = Double.valueOf(((Long)this.d.get(d.e.b)).longValue());
    }
    if (this.d.containsKey(d.e.c)) {
      localf.f = Double.valueOf(((Long)this.d.get(d.e.c)).longValue());
    }
    if (this.d.containsKey(d.e.d)) {
      localf.g = Double.valueOf(((Long)this.d.get(d.e.d)).longValue());
    }
    if (this.d.containsKey(d.e.e)) {
      localf.d = Double.valueOf(((Long)this.d.get(d.e.e)).longValue());
    }
    if (this.d.containsKey(d.e.f)) {
      localf.h = Double.valueOf(((Long)this.d.get(d.e.f)).longValue());
    }
    if (this.d.containsKey(d.e.g)) {
      localf.e = Double.valueOf(((Long)this.d.get(d.e.g)).longValue());
    }
    if (this.d.containsKey(d.e.h)) {
      localf.j = Double.valueOf(((Long)this.d.get(d.e.h)).longValue());
    }
    if (this.d.containsKey(d.e.i)) {
      localf.i = Double.valueOf(((Long)this.d.get(d.e.i)).longValue());
    }
    if (this.d.containsKey(d.e.j)) {
      localf.k = Double.valueOf(((Long)this.d.get(d.e.j)).longValue());
    }
    if (this.d.containsKey(d.e.k)) {
      localf.l = Double.valueOf(((Long)this.d.get(d.e.k)).longValue());
    }
    localf.p = Boolean.valueOf(v.a());
    if (this.e.containsKey(d.a.c)) {
      localf.n = ((Boolean)this.e.get(d.a.c));
    }
    if (this.e.containsKey(d.a.d)) {
      localf.o = ((Boolean)this.e.get(d.a.d));
    }
    if (this.e.containsKey(d.a.a)) {
      localf.q = ((Boolean)this.e.get(d.a.a));
    }
    if (this.f.containsKey(d.b.a)) {
      localf.s = Long.valueOf(((Integer)this.f.get(d.b.a)).intValue());
    }
    if (this.f.containsKey(d.b.b)) {
      localf.t = Long.valueOf(((Integer)this.f.get(d.b.b)).intValue());
    }
    if (this.f.containsKey(d.b.c)) {
      localf.u = Long.valueOf(((Integer)this.f.get(d.b.c)).intValue());
    }
    if (this.f.containsKey(d.b.d)) {
      localf.v = Long.valueOf(((Integer)this.f.get(d.b.d)).intValue());
    }
    localf.r = ((String)this.g.get(d.d.a));
    l.a(u.a(), localf, this.b);
  }
  
  public final void a()
  {
    a(SystemClock.elapsedRealtime());
  }
  
  public final void a(long paramLong)
  {
    if (this.i == d.c.c) {
      return;
    }
    if (this.i != d.c.a) {
      throw new AssertionError("perf logging has already initiated or ended, state:" + this.i.name());
    }
    Log.d("PerfMarker/begin/name: " + this.a);
    this.h = paramLong;
    this.i = d.c.b;
  }
  
  public final void a(d.a parama, boolean paramBoolean)
  {
    if (this.i == d.c.c) {
      return;
    }
    this.e.put(parama, Boolean.valueOf(paramBoolean));
  }
  
  public final void a(d.b paramb, int paramInt)
  {
    if (this.i == d.c.c) {
      return;
    }
    this.f.put(paramb, Integer.valueOf(paramInt));
  }
  
  public final void a(d.e parame)
  {
    a(parame, SystemClock.elapsedRealtime());
  }
  
  public final void a(d.e parame, long paramLong)
  {
    if (this.i == d.c.c) {
      return;
    }
    if (this.i != d.c.b) {
      throw new AssertionError("Perf logging is not running, state:" + this.i.name());
    }
    if (this.c.containsKey(parame)) {
      throw new AssertionError("This sub marker is already running");
    }
    if (this.d.containsKey(parame)) {
      throw new AssertionError("This sub marker has already been completed");
    }
    this.c.put(parame, Long.valueOf(paramLong));
  }
  
  public final void b()
  {
    b(SystemClock.elapsedRealtime());
  }
  
  public final void b(long paramLong)
  {
    if (this.i == d.c.c) {
      return;
    }
    if (this.i != d.c.b) {
      throw new AssertionError("Perf logging is not running, state:" + this.i.name());
    }
    if (!this.c.isEmpty()) {
      throw new AssertionError("Some sub perf markers have not finished, size:" + this.c.size());
    }
    paramLong -= this.h;
    Log.d("PerfMarker/end/name: " + this.a + ", duration: " + paramLong + "ms");
    this.i = d.c.c;
    this.j = paramLong;
    d(paramLong);
  }
  
  public final void b(d.e parame)
  {
    if (this.i == d.c.c) {
      return;
    }
    if (this.i != d.c.b) {
      throw new AssertionError("Perf logging is not running, state:" + this.i.name());
    }
    if (!this.c.containsKey(parame)) {
      throw new AssertionError("This sub marker is not running");
    }
    if (this.d.containsKey(parame)) {
      throw new AssertionError("This sub marker has already been completed");
    }
    long l1 = SystemClock.elapsedRealtime();
    long l2 = ((Long)this.c.get(parame)).longValue();
    this.c.remove(parame);
    this.d.put(parame, Long.valueOf(l1 - l2));
  }
  
  public final void c()
  {
    if (this.i == d.c.c) {
      return;
    }
    if (this.i != d.c.b) {
      throw new AssertionError("Perf logging is not running, state:" + this.i.name());
    }
    this.i = d.c.c;
  }
  
  public final void c(long paramLong)
  {
    if (this.i != d.c.a) {
      throw new AssertionError("Perf logging is already started, state:" + this.i.name());
    }
    this.i = d.c.c;
    this.j = paramLong;
    d(paramLong);
  }
  
  public final boolean d()
  {
    return this.i == d.c.b;
  }
  
  public final long e()
  {
    if (this.i != d.c.c) {
      throw new AssertionError("Perf logging is not finished, state:" + this.i.name());
    }
    return this.j;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/k/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */