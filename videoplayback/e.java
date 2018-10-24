package com.whatsapp.videoplayback;

import android.content.Context;
import android.view.View;
import java.io.File;
import pl.droidsonroids.gif.GifImageView;
import pl.droidsonroids.gif.a;

public final class e
  extends o
{
  private final a a;
  private final GifImageView b;
  
  public e(Context paramContext, File paramFile)
  {
    this.a = new a(paramFile);
    this.b = new GifImageView(paramContext);
    this.b.setImageDrawable(this.a);
  }
  
  public final View a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.a.seekTo(paramInt);
  }
  
  public final void a(boolean paramBoolean) {}
  
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
    this.a.stop();
  }
  
  public final void e() {}
  
  public final boolean f()
  {
    return this.a.isPlaying();
  }
  
  public final boolean g()
  {
    return true;
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


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/videoplayback/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */