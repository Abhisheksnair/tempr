package com.whatsapp;

import android.os.Handler;
import android.os.Looper;
import com.whatsapp.data.ad;
import com.whatsapp.l.e;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

public class vc
{
  private static volatile vc b;
  boolean a;
  private final Stack<j> c = new Stack();
  private Handler d = new Handler(Looper.getMainLooper());
  private Runnable e = vd.a(this);
  private final pv f;
  private final oz g;
  private final ad h;
  private final e i;
  private final vv j;
  private final ai k;
  private final aat l;
  
  private vc(pv parampv, oz paramoz, ad paramad, e parame, vv paramvv, ai paramai, aat paramaat)
  {
    this.f = parampv;
    this.g = paramoz;
    this.h = paramad;
    this.i = parame;
    this.j = paramvv;
    this.k = paramai;
    this.l = paramaat;
    parampv = new a((byte)0);
    parampv.setPriority(1);
    parampv.start();
  }
  
  public static vc a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new vc(pv.a(), oz.a(), ad.a(), e.a(), vv.a(), ai.a(), aat.a());
      }
      return b;
    }
    finally {}
  }
  
  public final void a(j paramj)
  {
    if (this.k.c(paramj))
    {
      a(paramj, vk.a.b);
      return;
    }
    a(paramj, vk.a.c);
  }
  
  public final void a(j paramj, vk.a arg2)
  {
    if ((paramj.s != 0) && (vk.a(this.g, this.h, this.i, paramj, ???, null) == null)) {
      return;
    }
    synchronized (this.c)
    {
      Log.i("mediaautodownload/queue " + MediaFileUtils.a(paramj.p));
      this.c.add(paramj);
      if (!this.a) {
        this.c.notifyAll();
      }
      return;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    synchronized (this.c)
    {
      Log.i("mediaautodownload/updatestate " + this.a + " " + paramBoolean);
      this.d.removeCallbacks(this.e);
      if (paramBoolean) {
        this.d.postDelayed(this.e, 15000L);
      }
      while (!this.a)
      {
        this.a = paramBoolean;
        return;
      }
      this.c.notifyAll();
    }
  }
  
  public final void b()
  {
    for (;;)
    {
      int m;
      j localj;
      vk localvk;
      synchronized (this.c)
      {
        Log.i("mediaautodownload/updatequeue " + this.c.size());
        m = this.l.a(true);
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = this.c.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localj = (j)localIterator.next();
        localvk = localj.b().downloader;
        if (localvk.f == vk.a.a) {
          continue;
        }
        if (this.k.b(m, localj)) {
          localvk.f = vk.a.b;
        }
      }
      if (this.k.c(m, localj)) {
        localvk.f = vk.a.c;
      } else {
        localCollection.add(localj);
      }
    }
    this.c.removeAll(localCollection);
  }
  
  public final void b(j paramj)
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        if (paramj.e.equals(localj.e))
        {
          Log.i("mediaautodownload/cancel " + MediaFileUtils.a(paramj.p));
          this.c.remove(localj);
        }
      }
      return;
    }
  }
  
  final class a
    extends Thread
  {
    private a()
    {
      super();
    }
    
    public final void run()
    {
      for (;;)
      {
        long l2;
        long l3;
        long l1;
        try
        {
          if (vc.a(vc.this).isEmpty()) {}
          synchronized (vc.a(vc.this))
          {
            if (vc.a(vc.this).isEmpty()) {
              vc.a(vc.this).wait();
            }
            Thread.sleep(1000L);
            Voip.g();
            if (vc.a(vc.this).isEmpty()) {}
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          synchronized (vc.a(vc.this))
          {
            Object localObject2 = (j)vc.a(vc.this).pop();
            Log.i("mediaautodownload/download " + MediaFileUtils.a(((j)localObject2).p));
            if (((j)localObject2).s != 0)
            {
              l2 = vv.f();
              l3 = vv.g();
              if ((((j)localObject2).s != 3) && (((j)localObject2).s != 13) && ((((j)localObject2).s != 2) || (((j)localObject2).o == 1))) {
                break label388;
              }
              l1 = Math.max(aic.s << 10 << 10, Math.min(134217728L, l3 / 10L));
              if (l2 <= l1) {
                break label426;
              }
              ??? = ((j)localObject2).b();
              localObject2 = ((MediaData)???).downloader;
              if ((!((vk)localObject2).isCancelled()) && (((vk)localObject2).d))
              {
                vk.c localc = ((vk)localObject2).c();
                if ((!((vk)localObject2).isCancelled()) && (localObject2 == ((MediaData)???).downloader)) {
                  vc.b(vc.this).a(new ve((vk)localObject2, (MediaData)???, localc));
                }
              }
            }
            boolean bool = Thread.interrupted();
            if (!bool) {
              continue;
            }
            return;
            localObject3 = finally;
            throw ((Throwable)localObject3);
            localInterruptedException = localInterruptedException;
            synchronized (vc.a(vc.this))
            {
              if (vc.a(vc.this).isEmpty()) {
                break label478;
              }
              MediaData localMediaData = ((j)vc.a(vc.this).pop()).b();
              localMediaData.transferring = false;
              localMediaData.progress = 0L;
            }
          }
        }
        label388:
        if (((j)localObject5).s == 1)
        {
          l1 = Math.max(aic.s << 9 << 10, Math.min(33554432L, l3 / 20L));
          continue;
          label426:
          Log.e("mediaautodownload/nospace total:" + l3 + " free:" + l2 + " need:" + l1);
          ((j)localObject5).b().downloader.b();
        }
        else
        {
          label478:
          l1 = 0L;
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/vc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */