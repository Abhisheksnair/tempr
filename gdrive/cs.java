package com.whatsapp.gdrive;

import com.whatsapp.util.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class cs
{
  private static final Set<Thread> a = new HashSet();
  
  public static <RETURN_TYPE, T1 extends Throwable, T2 extends Throwable, T3 extends Throwable, T4 extends Throwable, T5 extends Throwable, T6 extends Throwable> RETURN_TYPE a(ev paramev, cg<RETURN_TYPE, T1, T2, T3, T4, T5, T6> paramcg, String paramString)
  {
    return (RETURN_TYPE)a(paramev, paramcg, paramString, 14);
  }
  
  public static <RETURN_TYPE, T1 extends Throwable, T2 extends Throwable, T3 extends Throwable, T4 extends Throwable, T5 extends Throwable, T6 extends Throwable> RETURN_TYPE a(ev paramev, cg<RETURN_TYPE, T1, T2, T3, T4, T5, T6> paramcg, String paramString, int paramInt)
  {
    int i;
    int j;
    try
    {
      Thread localThread = Thread.currentThread();
      for (;;)
      {
        synchronized (a)
        {
          a.add(localThread);
          i = 0;
          j = 0;
          if ((paramev != null) && (!paramev.a()))
          {
            Log.i("gdrive-retry-task/condition-failed/" + paramev);
            return null;
          }
        }
        try
        {
          ??? = paramcg.a();
          if (??? != null)
          {
            if (j > 0) {
              Log.i("gdrive-retry-task/execute/attempt-" + j + "/success: " + paramString);
            }
            return (RETURN_TYPE)???;
          }
          Log.i("gdrive-retry-task/execute/attempt-" + j + "/failed: " + paramString);
          k = j + 1;
          j = e.a(paramInt).a;
          if (k < j)
          {
            j = 1;
            if (j == 0) {}
          }
        }
        catch (bg localbg)
        {
          for (;;)
          {
            try
            {
              e.b(k);
              j = k;
            }
            catch (InterruptedException paramev)
            {
              Log.b("gdrive-retry-task/interrupted", paramev);
              return null;
            }
            localbg = localbg;
            Log.d("gdrive-retry-task/execute", localbg);
            i += 1;
          }
        }
      }
    }
    finally
    {
      a(Thread.currentThread());
    }
    for (;;)
    {
      int k;
      if (i > 0) {
        throw new bl("Google Drive failures/total attempts: " + i + "/" + k);
      }
      a(Thread.currentThread());
      return null;
      j = 0;
    }
  }
  
  public static void a()
  {
    synchronized (a)
    {
      Iterator localIterator = a.iterator();
      if (localIterator.hasNext()) {
        ((Thread)localIterator.next()).interrupt();
      }
    }
    Log.i("gdrive-retry-task/interrupt-active-tasks/size/" + a.size());
  }
  
  private static void a(Thread paramThread)
  {
    synchronized (a)
    {
      a.remove(paramThread);
      return;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gdrive/cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */