package com.whatsapp.videoplayback;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;

final class z
  extends o
{
  private final ac a;
  
  z(Context paramContext, String paramString)
  {
    this.a = new ac(paramContext)
    {
      public final void start()
      {
        if (a()) {
          z.this.w();
        }
        super.start();
      }
    };
    this.a.setVideoPath(paramString);
    this.a.setOnErrorListener(aa.a(this));
    this.a.setOnCompletionListener(ab.a(this));
  }
  
  public final View a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    this.a.seekTo(paramInt);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a.setMute(paramBoolean);
  }
  
  public final void b()
  {
    this.a.start();
  }
  
  public final void c()
  {
    this.a.pause();
  }
  
  public final void d()
  {
    ac localac = this.a;
    if (localac.b != null)
    {
      localac.b.reset();
      localac.b.release();
      localac.b = null;
      localac.k = false;
      localac.l = 0;
      localac.m = 0;
    }
  }
  
  public final void e()
  {
    this.a.setLooping(true);
  }
  
  public final boolean f()
  {
    return this.a.isPlaying();
  }
  
  public final boolean g()
  {
    return this.a.k;
  }
  
  public final int h()
  {
    return this.a.getDuration();
  }
  
  public final int i()
  {
    return this.a.getCurrentPosition();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/videoplayback/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */