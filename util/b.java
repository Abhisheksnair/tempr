package com.whatsapp.util;

import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.whatsapp.g.o;
import com.whatsapp.rl;
import com.whatsapp.u;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class b
{
  public static volatile b a;
  private static final Uri e = Uri.parse("");
  f b;
  private final Context c;
  private final rl d;
  private final ExecutorService f = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private final Handler g = new Handler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      b.this.b();
    }
  };
  
  private b(Context paramContext, rl paramrl)
  {
    this.c = paramContext;
    this.d = paramrl;
  }
  
  public static b a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new b(u.a(), rl.a());
      }
      return a;
    }
    finally {}
  }
  
  private void a(Context paramContext, Uri paramUri, int paramInt)
  {
    this.f.submit(c.a(this, paramContext, paramUri, paramInt));
  }
  
  public final void a(Uri paramUri)
  {
    if (paramUri.compareTo(e) == 0) {}
    AudioManager localAudioManager;
    do
    {
      do
      {
        return;
        this.g.removeMessages(99);
        this.g.sendEmptyMessageDelayed(99, 10000L);
        b();
      } while (((o)b.a.a.c.a().a(o.class)).a);
      if (!this.d.c) {
        break;
      }
      localAudioManager = (AudioManager)this.c.getSystemService("audio");
    } while ((localAudioManager != null) && (localAudioManager.getStreamVolume(5) <= 0));
    a(this.c, paramUri, 3);
    return;
    a(this.c, paramUri, 5);
  }
  
  public final void b()
  {
    this.f.submit(d.a(this));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */