package com.whatsapp.util;

import android.os.Process;
import com.whatsapp.util.a.c;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

public final class bx
{
  private final ThreadPoolExecutor a;
  private final BlockingQueue<Runnable> b;
  private final AtomicBoolean c = new AtomicBoolean();
  private final Map<Runnable, Long> d = new WeakHashMap();
  private final Map<Runnable, Long> e = new WeakHashMap();
  private final Map<Runnable, String> f = new WeakHashMap();
  
  public bx(ThreadPoolExecutor paramThreadPoolExecutor, BlockingQueue<Runnable> paramBlockingQueue)
  {
    this.a = paramThreadPoolExecutor;
    this.b = paramBlockingQueue;
  }
  
  private void a(c paramc)
  {
    StringBuilder localStringBuilder;
    Iterator localIterator;
    Runnable localRunnable;
    try
    {
      if (!this.c.compareAndSet(false, true)) {
        break label296;
      }
      localStringBuilder = new StringBuilder(Log.a()).append("\n");
      localStringBuilder.append(this.a.toString()).append("\n");
      localIterator = this.e.keySet().iterator();
      while (localIterator.hasNext())
      {
        localRunnable = (Runnable)localIterator.next();
        localStringBuilder.append("running task: (").append((String)this.f.get(localRunnable)).append(") ").append(localRunnable.getClass().getName()).append(" ").append(Process.getElapsedCpuTime() - ((Long)this.e.get(localRunnable)).longValue()).append("ms\n");
      }
      localIterator = this.b.iterator();
    }
    finally {}
    while (localIterator.hasNext())
    {
      localRunnable = (Runnable)localIterator.next();
      localStringBuilder.append("queued task: ").append(localRunnable.getClass().getName()).append(" ");
      if (this.d.containsKey(localRunnable)) {
        localStringBuilder.append(Process.getElapsedCpuTime() - ((Long)this.d.get(localRunnable)).longValue()).append("ms");
      }
      localStringBuilder.append('\n');
    }
    localStringBuilder.append(Log.b());
    Log.i(localStringBuilder.toString());
    paramc.a("WhatsAppWorkers queue wait > 5 mins", false, null, -1);
    label296:
  }
  
  public final void a(c paramc, Runnable paramRunnable)
  {
    try
    {
      this.d.put(paramRunnable, Long.valueOf(Process.getElapsedCpuTime()));
      paramRunnable = (Runnable)this.b.peek();
      if (paramRunnable != null)
      {
        paramRunnable = (Long)this.d.get(paramRunnable);
        if ((paramRunnable != null) && (Process.getElapsedCpuTime() - paramRunnable.longValue() > 300000L)) {
          a(paramc);
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void a(Runnable paramRunnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/whatsapp/util/bx:e	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 139 2 0
    //   12: istore_2
    //   13: iload_2
    //   14: ifne +6 -> 20
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: getfield 34	com/whatsapp/util/bx:e	Ljava/util/Map;
    //   24: aload_1
    //   25: invokeinterface 177 2 0
    //   30: pop
    //   31: aload_0
    //   32: getfield 36	com/whatsapp/util/bx:f	Ljava/util/Map;
    //   35: aload_1
    //   36: invokeinterface 177 2 0
    //   41: pop
    //   42: goto -25 -> 17
    //   45: astore_1
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_1
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	bx
    //   0	50	1	paramRunnable	Runnable
    //   12	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	13	45	finally
    //   20	42	45	finally
  }
  
  public final void a(Thread paramThread, Runnable paramRunnable)
  {
    try
    {
      if (!this.d.containsKey(paramRunnable)) {
        this.d.remove(paramRunnable);
      }
      this.e.put(paramRunnable, Long.valueOf(Process.getElapsedCpuTime()));
      this.f.put(paramRunnable, paramThread.getName());
      return;
    }
    finally {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */