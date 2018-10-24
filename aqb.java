package com.whatsapp;

import a.a.a.a.d;
import android.os.SystemClock;
import com.whatsapp.fieldstats.events.bv;
import com.whatsapp.fieldstats.events.h;
import com.whatsapp.k.i;
import com.whatsapp.m.a;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import java.io.File;
import java.net.URL;

public final class aqb
{
  private final vo a;
  private final j b;
  private final a c;
  private long d;
  private final i e = new i();
  private final i f = new i();
  private long g;
  private long h;
  private long i;
  private final i j = new i();
  private final i k = new i();
  private vo.a l;
  private vo.a m;
  private vo.a n;
  private int o;
  private int p;
  private boolean q;
  private boolean r;
  private boolean s;
  private int t;
  private a u;
  
  public aqb(j paramj, a parama, vo paramvo)
  {
    this.b = paramj;
    this.a = paramvo;
    this.c = parama;
    this.u = a.a;
  }
  
  private static Integer a(vo.a parama)
  {
    if (parama == null) {
      return null;
    }
    switch (1.a[parama.ordinal()])
    {
    default: 
      return Integer.valueOf(5);
    case 1: 
      return Integer.valueOf(1);
    case 2: 
      return Integer.valueOf(2);
    case 3: 
      return Integer.valueOf(3);
    case 4: 
      return Integer.valueOf(1);
    }
    return Integer.valueOf(5);
  }
  
  public final bv a(int paramInt1, int paramInt2)
  {
    bv localbv = new bv();
    localbv.e = Integer.valueOf(2);
    localbv.h = Integer.valueOf(paramInt1);
    localbv.i = Integer.valueOf(paramInt2);
    localbv.c = Long.valueOf(this.j.a / 1000L);
    localbv.f = Double.valueOf(this.e.a);
    if ((this.c != null) && (this.n == vo.a.e)) {}
    for (localbv.d = Long.valueOf((System.currentTimeMillis() - this.c.g().lastModified()) / 1000L);; localbv.d = Long.valueOf(0L))
    {
      if (this.b != null)
      {
        localbv.a = Long.valueOf(this.b.w);
        localbv.b = Double.valueOf(this.b.t);
      }
      Log.d("VideoDownloadStreamStat/" + pb.a(localbv));
      return localbv;
    }
  }
  
  public final void a()
  {
    Long localLong = this.a.f;
    if (localLong != null) {}
    for (long l1 = SystemClock.elapsedRealtime() - localLong.longValue();; l1 = 0L)
    {
      this.d = l1;
      this.g = this.a.k;
      this.l = this.a.o;
      this.e.a();
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.e.b)
    {
      this.e.b();
      this.h = this.a.k;
      this.m = this.a.o;
      this.r = true;
    }
    if (paramBoolean)
    {
      this.j.a();
      this.k.b();
    }
    for (this.u = a.b;; this.u = a.c)
    {
      this.f.b();
      return;
      this.j.b();
      this.k.a();
    }
  }
  
  public final void b()
  {
    this.j.b();
    if ((this.r) && (!this.f.b))
    {
      this.f.a();
      this.o += 1;
    }
    this.k.b();
    this.u = a.d;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.p += 1;
    this.q = paramBoolean;
    this.f.b();
  }
  
  public final void c()
  {
    this.j.b();
    this.s = true;
    this.f.b();
    this.k.b();
    this.u = a.f;
  }
  
  public final void d()
  {
    if (!this.r) {
      this.e.a();
    }
  }
  
  public final void e()
  {
    this.j.b();
    this.k.b();
    this.e.b();
    this.f.b();
    this.t += 1;
    this.u = a.e;
  }
  
  public final void f()
  {
    this.j.b();
    this.k.b();
    this.e.b();
    this.f.b();
    this.i = this.a.k;
    this.n = this.a.o;
  }
  
  public final h g()
  {
    Object localObject3 = null;
    h localh = new h();
    localh.F = Double.valueOf(this.k.a / 1000.0D);
    localh.M = Long.valueOf(this.j.a / 1000L);
    localh.z = Double.valueOf(this.e.a);
    Object localObject4;
    Object localObject2;
    label437:
    label452:
    long l1;
    label613:
    StringBuilder localStringBuilder;
    if ((this.c != null) && (this.n == vo.a.e))
    {
      localh.N = Long.valueOf((System.currentTimeMillis() - this.c.g().lastModified()) / 1000L);
      if (this.b == null) {
        break label1480;
      }
      localh.K = Long.valueOf(this.b.w);
      localh.L = Double.valueOf(this.b.t);
      localh.G = Double.valueOf(this.f.a);
      localh.H = Long.valueOf(this.o);
      localh.y = Double.valueOf(this.d);
      localObject4 = this.a.j;
      if (localObject4 != null) {
        localh.A = Double.valueOf(((Long)localObject4).longValue());
      }
      localh.s = Double.valueOf(this.g);
      localh.t = Double.valueOf(this.h);
      localh.u = Double.valueOf(this.i);
      localh.v = a(this.l);
      localh.w = a(this.m);
      localh.x = a(this.n);
      localh.B = Long.valueOf(this.p);
      localh.C = Boolean.valueOf(this.q);
      localh.D = Boolean.valueOf(this.r);
      localh.E = Boolean.valueOf(this.s);
      localh.J = Long.valueOf(this.t);
      localObject1 = this.u;
      if (localObject1 != null) {
        break label1483;
      }
      localObject1 = null;
      localh.I = ((Integer)localObject1);
      localh.a = Integer.valueOf(d.a(this.b));
      localh.j = Double.valueOf(this.a.k().longValue());
      localObject2 = this.b.b();
      if (this.a.h == null) {
        break label1573;
      }
      localObject1 = this.a.h.a;
      if (localObject1 == null) {
        break label1578;
      }
      localObject2 = Integer.valueOf(d.a((vk.d)localObject1, (MediaData)localObject2));
      localh.b = ((Integer)localObject2);
      localh.r = Integer.valueOf(d.a(this.a.a));
      localh.d = Boolean.valueOf(this.a.n());
      localh.h = Long.valueOf(this.a.f());
      localh.o = Double.valueOf(this.a.g());
      localh.m = Double.valueOf(this.a.h());
      localh.q = Double.valueOf(this.a.i());
      localh.p = Double.valueOf(this.a.j());
      localh.c = Double.valueOf(this.a.k);
      localh.e = this.a.o();
      if (!this.a.e) {
        break label1584;
      }
      l1 = 4L;
      localh.i = Long.valueOf(l1);
      if (av.k())
      {
        localObject2 = new StringBuilder("videodownloadstream/event/");
        localObject4 = ((StringBuilder)localObject2).append("mode=" + this.a.a).append(", initialBufferingTime=" + this.e).append(", vidoePlayTime=" + this.j.a).append(", vidoePauseTime=" + this.k.a).append(", totalRebufferingT=" + this.f + " (" + this.o + ")").append(", videoAge=" + localh.N + "s").append(", duration=" + localh.K + "s").append(", readyToPlay=" + this.r).append(", reachedEnd=" + this.s).append(", downloadStatus=" + localObject1).append(", playbackState=" + this.u).append(", playbackExitCount=" + this.t).append(", timeSinceDownloadStartT=" + this.d).append(", playbackErrorCount=" + this.p + " (fatal=" + this.q + ")").append(", timeSinceDownloadStartT=" + this.d).append(", timeSincePreviousFetchT=" + localObject4).append(", downloadedBytesAt{Start,Playback,Finish}={" + this.g + "," + this.h + "," + this.i + "}").append(", downloadedStageAt{Start,Playback,Finish}={" + this.l + "," + this.m + "," + this.n + "}").append(", totalDownloadTime=" + this.a.k()).append(", networkDownloadTime=" + this.a.g()).append(", connectTime=" + this.a.h()).append(", size=" + this.b.t).append(", downloadResumePoint=" + this.a.f()).append(", bytesTransferred=" + this.a.k).append(", timeToFirstByteTime=" + this.a.i()).append(", fileValidationTime=" + this.a.j());
        localStringBuilder = new StringBuilder(", url=");
        localObject1 = this.a;
        if (((vo)localObject1).d != null) {
          break label1591;
        }
      }
    }
    label1480:
    label1483:
    label1573:
    label1578:
    label1584:
    label1591:
    for (Object localObject1 = localObject3;; localObject1 = ((vo)localObject1).d.toString())
    {
      ((StringBuilder)localObject4).append(MediaFileUtils.a((String)localObject1)).append(" " + this.b.e);
      Log.d(((StringBuilder)localObject2).toString());
      return localh;
      localh.N = Long.valueOf(0L);
      break;
      return localh;
      switch (1.b[localObject1.ordinal()])
      {
      default: 
        localObject1 = Integer.valueOf(1);
        break;
      case 1: 
        localObject1 = Integer.valueOf(1);
        break;
      case 2: 
        localObject1 = Integer.valueOf(2);
        break;
      case 3: 
        localObject1 = Integer.valueOf(3);
        break;
      case 4: 
        localObject1 = Integer.valueOf(4);
        break;
      case 5: 
        localObject1 = Integer.valueOf(6);
        break;
        localObject1 = null;
        break label437;
        localObject2 = null;
        break label452;
        l1 = 3L;
        break label613;
      }
    }
  }
  
  static enum a
  {
    private a() {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aqb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */