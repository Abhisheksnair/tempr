package com.whatsapp.gdrive;

import android.os.Process;
import com.whatsapp.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

final class az
{
  private static final BlockingQueue<Runnable> a = new LinkedBlockingQueue(4);
  private static final ThreadFactory b = new ThreadFactory()
  {
    private final AtomicInteger a = new AtomicInteger(1);
    
    public final Thread newThread(final Runnable paramAnonymousRunnable)
    {
      new Thread(new Runnable()
      {
        public final void run()
        {
          Process.setThreadPriority(10);
          paramAnonymousRunnable.run();
        }
      }, "Google Drive Checksum Calculation Worker #" + this.a.getAndIncrement());
    }
  };
  private static final ThreadPoolExecutor c;
  
  static
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(0, 4, 1L, TimeUnit.SECONDS, a, b);
    c = localThreadPoolExecutor;
    localThreadPoolExecutor.setRejectedExecutionHandler(new RejectedExecutionHandler()
    {
      public final void rejectedExecution(Runnable paramAnonymousRunnable, ThreadPoolExecutor paramAnonymousThreadPoolExecutor)
      {
        try
        {
          paramAnonymousThreadPoolExecutor.getQueue().put(paramAnonymousRunnable);
          return;
        }
        catch (InterruptedException paramAnonymousRunnable)
        {
          Log.e(paramAnonymousRunnable);
        }
      }
    });
  }
  
  public static void a(Runnable paramRunnable)
  {
    c.execute(paramRunnable);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gdrive/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */