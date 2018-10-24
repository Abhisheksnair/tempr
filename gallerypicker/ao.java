package com.whatsapp.gallerypicker;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Process;
import android.support.v4.f.f;
import com.whatsapp.c.a;
import com.whatsapp.util.Log;
import java.util.ArrayList;

public final class ao
{
  final ArrayList<c> a = new ArrayList();
  boolean b;
  final Handler c;
  final f<String, Bitmap> d;
  private Thread e;
  private final ContentResolver f;
  
  public ao(a parama, ContentResolver paramContentResolver, Handler paramHandler)
  {
    this.f = paramContentResolver;
    this.c = paramHandler;
    this.d = parama.a;
    b();
    Log.i("imageloader/cachesize:" + this.d.c());
  }
  
  private void b()
  {
    if (this.e != null) {
      return;
    }
    this.b = false;
    Thread localThread = new Thread(new d((byte)0));
    localThread.setName("image-loader");
    this.e = localThread;
    localThread.start();
  }
  
  public final void a()
  {
    synchronized (this.a)
    {
      this.b = true;
      this.a.notifyAll();
      if (this.e == null) {}
    }
  }
  
  public final void a(a parama, b paramb)
  {
    if (this.e == null) {
      b();
    }
    ??? = null;
    if (parama.b() != null) {
      ??? = (Bitmap)this.d.a(parama.b());
    }
    if (??? != null)
    {
      paramb.a((Bitmap)???, true);
      return;
    }
    paramb.a();
    synchronized (this.a)
    {
      parama = new c(parama, paramb);
      this.a.add(parama);
      this.a.notifyAll();
      return;
    }
  }
  
  public final boolean a(a parama)
  {
    if (parama == null) {
      return false;
    }
    ArrayList localArrayList = this.a;
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.a.size()) {
          break label77;
        }
        if (((c)this.a.get(i)).a == parama)
        {
          if (i < 0) {
            break label73;
          }
          this.a.remove(i);
          return true;
        }
      }
      finally {}
      i += 1;
      continue;
      label73:
      return false;
      label77:
      i = -1;
    }
  }
  
  public static abstract interface a
  {
    public abstract Bitmap a();
    
    public abstract String b();
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void a(Bitmap paramBitmap, boolean paramBoolean);
  }
  
  static final class c
  {
    final ao.a a;
    final ao.b b;
    
    c(ao.a parama, ao.b paramb)
    {
      this.a = parama;
      this.b = paramb;
    }
  }
  
  final class d
    implements Runnable
  {
    private d() {}
    
    public final void run()
    {
      Process.setThreadPriority(10);
      for (;;)
      {
        synchronized (ao.this.a)
        {
          if (ao.this.b) {
            return;
          }
          if (!ao.this.a.isEmpty())
          {
            Object localObject3 = (ao.c)ao.this.a.remove(0);
            ??? = ((ao.c)localObject3).a;
            Bitmap localBitmap = (Bitmap)ao.this.d.a(((ao.a)???).b());
            if (localBitmap != null) {
              break label171;
            }
            ??? = ((ao.c)localObject3).a.a();
            if (??? == null) {
              continue;
            }
            ao.this.d.a(((ao.c)localObject3).a.b(), ???);
            localObject3 = ((ao.c)localObject3).b;
            ao.this.c.post(new ap((ao.b)localObject3, (Bitmap)???, localBitmap));
          }
        }
        try
        {
          ao.this.a.wait();
          continue;
          localObject2 = finally;
          throw ((Throwable)localObject2);
          label171:
          ??? = localObject2;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */