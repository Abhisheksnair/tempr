package com.whatsapp.videoplayback;

import android.content.Context;
import android.view.View;

final class w
  extends o
{
  private final VideoSurfaceView a;
  
  w(Context paramContext, String paramString)
  {
    this.a = new VideoSurfaceView(paramContext)
    {
      public final void start()
      {
        if (b()) {
          w.this.w();
        }
        super.start();
      }
    };
    this.a.setVideoPath(paramString);
    this.a.setOnErrorListener(x.a(this));
    this.a.setOnCompletionListener(y.a(this));
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
    this.a.a();
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
    return this.a.getCurrentPosition() > 50;
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


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/videoplayback/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */