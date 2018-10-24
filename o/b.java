package com.whatsapp.o;

import android.annotation.TargetApi;
import com.whatsapp.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@TargetApi(16)
final class b
  extends a
{
  private static final int[] h = { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000 };
  int c = 1;
  private boolean d;
  private Thread e;
  private CountDownLatch f;
  private Exception g;
  
  public b(String paramString)
  {
    this.a = new File(paramString + ".aac");
    this.b = 32000;
  }
  
  private static int f()
  {
    int i = 0;
    while (i < h.length)
    {
      if (22050 == h[i]) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  public final void a() {}
  
  public final void b()
  {
    if (this.e != null) {
      throw new IllegalStateException();
    }
    this.d = true;
    this.e = new Thread(new Runnable()
    {
      public final void run()
      {
        b.a(b.this, true);
        try
        {
          b.a(b.this);
          b.a(b.this, false);
          return;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          for (;;)
          {
            Log.d("voicerecorderaudiorecord", localIllegalStateException);
          }
        }
        catch (IOException localIOException)
        {
          for (;;) {}
        }
      }
    });
    this.f = new CountDownLatch(1);
    this.e.start();
    try
    {
      this.f.await();
      if (this.g != null) {
        throw new RuntimeException("start recording failed", this.g);
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      Log.d("voicerecorderaudiorecord", localInterruptedException);
    }
  }
  
  public final void c()
  {
    this.d = false;
    if (this.e != null) {}
    try
    {
      this.e.join();
      this.e = null;
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Log.d("voicerecorderaudiorecord", localInterruptedException);
    }
  }
  
  public final void d() {}
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/o/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */