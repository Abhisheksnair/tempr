package com.whatsapp.statusplayback;

import android.os.AsyncTask;
import com.whatsapp.MediaData;
import com.whatsapp.Voip;
import com.whatsapp.data.ad;
import com.whatsapp.l.e;
import com.whatsapp.oz;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import com.whatsapp.util.z;
import com.whatsapp.vk;
import com.whatsapp.vk.a;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

public class k
{
  private static volatile k e;
  public vk a;
  public final z<j.b, j> b = new z(4);
  public final oz c;
  public final ad d;
  private final e f;
  
  private k(oz paramoz, ad paramad, e parame)
  {
    this.c = paramoz;
    this.d = paramad;
    this.f = parame;
  }
  
  /* Error */
  public static k a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 41	com/whatsapp/statusplayback/k:e	Lcom/whatsapp/statusplayback/k;
    //   6: ifnonnull +34 -> 40
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 41	com/whatsapp/statusplayback/k:e	Lcom/whatsapp/statusplayback/k;
    //   15: ifnonnull +22 -> 37
    //   18: new 2	com/whatsapp/statusplayback/k
    //   21: dup
    //   22: invokestatic 46	com/whatsapp/oz:a	()Lcom/whatsapp/oz;
    //   25: invokestatic 51	com/whatsapp/data/ad:a	()Lcom/whatsapp/data/ad;
    //   28: invokestatic 56	com/whatsapp/l/e:a	()Lcom/whatsapp/l/e;
    //   31: invokespecial 58	com/whatsapp/statusplayback/k:<init>	(Lcom/whatsapp/oz;Lcom/whatsapp/data/ad;Lcom/whatsapp/l/e;)V
    //   34: putstatic 41	com/whatsapp/statusplayback/k:e	Lcom/whatsapp/statusplayback/k;
    //   37: ldc 2
    //   39: monitorexit
    //   40: getstatic 41	com/whatsapp/statusplayback/k:e	Lcom/whatsapp/statusplayback/k;
    //   43: astore_0
    //   44: ldc 2
    //   46: monitorexit
    //   47: aload_0
    //   48: areturn
    //   49: astore_0
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   43	5	0	localk	k
    //   49	5	0	localObject1	Object
    //   55	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	37	49	finally
    //   37	40	49	finally
    //   50	53	49	finally
    //   3	12	55	finally
    //   40	44	55	finally
    //   53	55	55	finally
  }
  
  private void a(final vk paramvk)
  {
    this.a = paramvk;
    if (paramvk == null)
    {
      Log.i("statusdownload/set-active-donwloader null");
      return;
    }
    bu.a(new AsyncTask()
    {
      private Void a()
      {
        try
        {
          paramvk.get();
          return null;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
        }
        catch (ExecutionException localExecutionException)
        {
          for (;;) {}
        }
        catch (CancellationException localCancellationException)
        {
          for (;;) {}
        }
      }
    }, new Void[0]);
  }
  
  public final void a(oz paramoz, ad paramad, j paramj)
  {
    j localj = vk.a(paramj.e);
    vk localvk1;
    if (localj != null)
    {
      vk localvk2 = localj.b().downloader;
      localObject = localvk2;
      if (localvk2 != null)
      {
        vk.a locala = localvk2.f;
        if (locala != vk.a.c)
        {
          localvk1 = localvk2;
          if (locala != vk.a.a)
          {
            localvk1 = localvk2;
            if (!Voip.e()) {}
          }
        }
        else
        {
          localvk2.b();
          localvk1 = null;
        }
        localObject = localvk1;
        if (localvk1 != null)
        {
          Log.i("statusdownload/will-reuse-downloader " + paramj.e.c + " " + paramj.f + " " + locala);
          a(localj.b().downloader);
        }
      }
    }
    for (Object localObject = localvk1;; localObject = null)
    {
      if (localObject == null)
      {
        Log.i("statusdownload/will-start-downloader " + paramj.e.c + " " + paramj.f);
        paramoz = vk.a(paramoz, paramad, this.f, paramj, vk.a.a, null);
        if (paramoz != null)
        {
          bu.a(paramoz, new Void[0]);
          a(paramoz);
        }
      }
      else
      {
        return;
      }
      Log.w("statusdownload/did-not-create-downloader " + paramj.e.c + " " + paramj.f);
      return;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */