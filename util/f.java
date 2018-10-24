package com.whatsapp.util;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.io.IOException;

public abstract class f
{
  public static f a(File paramFile, int paramInt)
  {
    if (paramFile.getAbsolutePath().endsWith(".opus")) {
      return new b(paramFile, paramInt);
    }
    return new a(paramFile, paramInt);
  }
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(MediaPlayer.OnErrorListener paramOnErrorListener);
  
  public abstract void a(MediaPlayer.OnPreparedListener paramOnPreparedListener);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract boolean e();
  
  public abstract int f();
  
  public abstract int g();
  
  public abstract void h();
  
  static final class a
    extends f
  {
    final MediaPlayer a;
    private final Handler b;
    
    private a(int paramInt)
    {
      Looper localLooper = Looper.myLooper();
      if (localLooper != null) {}
      for (;;)
      {
        this.b = new Handler(localLooper);
        this.a = new MediaPlayer();
        this.a.setAudioStreamType(paramInt);
        return;
        localLooper = Looper.getMainLooper();
      }
    }
    
    public a(Context paramContext, Uri paramUri, int paramInt)
    {
      this(paramInt);
      this.a.setDataSource(paramContext, paramUri);
    }
    
    public a(File paramFile, int paramInt)
    {
      this(paramInt);
      this.a.setDataSource(paramFile.getAbsolutePath());
    }
    
    public final void a()
    {
      this.a.prepare();
    }
    
    public final void a(int paramInt)
    {
      this.a.seekTo(paramInt);
    }
    
    public final void a(MediaPlayer.OnErrorListener paramOnErrorListener)
    {
      this.a.setOnErrorListener(paramOnErrorListener);
    }
    
    public final void a(MediaPlayer.OnPreparedListener paramOnPreparedListener)
    {
      this.a.setOnPreparedListener(paramOnPreparedListener);
    }
    
    public final void b()
    {
      this.a.start();
    }
    
    public final void c()
    {
      this.a.stop();
    }
    
    public final void d()
    {
      this.a.pause();
    }
    
    public final boolean e()
    {
      return this.a.isPlaying();
    }
    
    public final int f()
    {
      return this.a.getCurrentPosition();
    }
    
    public final int g()
    {
      return this.a.getDuration();
    }
    
    public final void h()
    {
      this.b.postDelayed(g.a(this), 100L);
    }
  }
  
  static final class b
    extends f
  {
    private final OpusPlayer a;
    
    public b(File paramFile, int paramInt)
    {
      this.a = new OpusPlayer(paramFile.getAbsolutePath(), paramInt);
    }
    
    public final void a()
    {
      this.a.prepare();
    }
    
    public final void a(int paramInt)
    {
      this.a.seek(paramInt);
    }
    
    public final void a(MediaPlayer.OnErrorListener paramOnErrorListener) {}
    
    public final void a(MediaPlayer.OnPreparedListener paramOnPreparedListener) {}
    
    public final void b()
    {
      this.a.start();
    }
    
    public final void c()
    {
      try
      {
        this.a.stop();
        return;
      }
      catch (IOException localIOException)
      {
        Log.e(localIOException);
      }
    }
    
    public final void d()
    {
      try
      {
        this.a.pause();
        return;
      }
      catch (IOException localIOException)
      {
        Log.e(localIOException);
      }
    }
    
    public final boolean e()
    {
      try
      {
        boolean bool = this.a.isPlaying();
        return bool;
      }
      catch (IOException localIOException)
      {
        Log.e(localIOException);
      }
      return false;
    }
    
    public final int f()
    {
      try
      {
        long l = this.a.getCurrentPosition();
        return (int)l;
      }
      catch (IOException localIOException)
      {
        Log.e(localIOException);
      }
      return 0;
    }
    
    public final int g()
    {
      try
      {
        long l = this.a.getLength();
        return (int)l;
      }
      catch (IOException localIOException)
      {
        Log.e(localIOException);
      }
      return 0;
    }
    
    public final void h()
    {
      this.a.close();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */