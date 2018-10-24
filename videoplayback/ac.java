package com.whatsapp.videoplayback;

import a.a.a.a.a.a.d;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.MediaController.MediaPlayerControl;
import com.whatsapp.util.Log;
import java.io.IOException;

@TargetApi(14)
public class ac
  extends TextureView
  implements MediaController.MediaPlayerControl
{
  private String a;
  MediaPlayer b;
  boolean c;
  boolean d;
  boolean e;
  int f;
  int g;
  int h = -1;
  boolean i;
  boolean j;
  boolean k;
  int l = 0;
  int m = 0;
  MediaPlayer.OnPreparedListener n;
  MediaPlayer.OnErrorListener o;
  MediaPlayer.OnCompletionListener p;
  private Surface q;
  private int r = o.d.a;
  private final Matrix s = new Matrix();
  
  public ac(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  private void b()
  {
    this.b = new MediaPlayer();
    this.b.setOnVideoSizeChangedListener(ad.a(this));
    this.b.setOnErrorListener(ae.a(this));
    this.b.setOnPreparedListener(af.a(this));
    this.b.setOnCompletionListener(ag.a(this));
    setSurfaceTextureListener(new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        if (ac.a(ac.this) == null) {}
        do
        {
          return;
          ac.a(ac.this, new Surface(paramAnonymousSurfaceTexture));
          ac.a(ac.this).setSurface(ac.b(ac.this));
        } while (ac.c(ac.this) != 0);
        try
        {
          ac.a(ac.this).setDataSource(ac.d(ac.this));
          ac.a(ac.this).prepareAsync();
          ac.a(ac.this, 1);
          return;
        }
        catch (IOException paramAnonymousSurfaceTexture)
        {
          ac.a(ac.this, -1);
          ac.e(ac.this);
          if (ac.f(ac.this) != null) {
            ac.this.post(ah.a(this));
          }
          Log.d("mediaview/unable-to-play", paramAnonymousSurfaceTexture);
        }
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        if (ac.a(ac.this) != null) {
          ac.a(ac.this).setSurface(null);
        }
        if (ac.b(ac.this) != null)
        {
          ac.b(ac.this).release();
          ac.a(ac.this, null);
        }
        ac.a(ac.this, false);
        return false;
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        ac localac;
        if (!ac.g(ac.this))
        {
          localac = ac.this;
          if (paramAnonymousSurfaceTexture.getTimestamp() <= 0L) {
            break label33;
          }
        }
        label33:
        for (boolean bool = true;; bool = false)
        {
          ac.a(localac, bool);
          return;
        }
      }
    });
  }
  
  public final boolean a()
  {
    return (this.b != null) && (this.l != -1) && (this.l != 0) && (this.l != 1);
  }
  
  public boolean canPause()
  {
    return this.c;
  }
  
  public boolean canSeekBackward()
  {
    return this.d;
  }
  
  public boolean canSeekForward()
  {
    return this.e;
  }
  
  public int getAudioSessionId()
  {
    a.d.a(false, "Not implemented");
    return 0;
  }
  
  public int getBufferPercentage()
  {
    a.d.a(false, "Not implemented");
    return 0;
  }
  
  public int getCurrentPosition()
  {
    if (a()) {
      return this.b.getCurrentPosition();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (a()) {
      return this.b.getDuration();
    }
    return -1;
  }
  
  public boolean isPlaying()
  {
    return (a()) && (this.b.isPlaying());
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.b != null) && (this.l == 4)) {
      this.b.start();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.b != null) && (this.l == 3)) {
      this.b.pause();
    }
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    if ((this.b != null) && (this.l == 4)) {
      this.b.start();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    float f1 = 1.0F;
    super.onMeasure(paramInt1, paramInt2);
    if ((this.f != 0) && (this.g != 0)) {
      switch (2.a[(this.r - 1)])
      {
      default: 
        paramInt2 = getMeasuredWidth();
        paramInt1 = getMeasuredHeight();
        if (this.f * paramInt1 > this.g * paramInt2) {
          paramInt1 = this.g * paramInt2 / this.f;
        }
        break;
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      paramInt1 = getMeasuredWidth();
      paramInt2 = getMeasuredHeight();
      this.s.reset();
      if (this.f * paramInt2 > this.g * paramInt1) {}
      for (float f2 = this.f * paramInt2 / (this.g * paramInt1);; f2 = 1.0F)
      {
        this.s.setScale(f2, f1, paramInt1 / 2, paramInt2 / 2);
        setTransform(this.s);
        return;
        f1 = this.g * paramInt1 / (this.f * paramInt2);
      }
      paramInt2 = this.f * paramInt1 / this.g;
    }
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if ((this.b != null) && (this.l == 3)) {
      this.b.pause();
    }
  }
  
  public void pause()
  {
    if ((a()) && (this.b.isPlaying()))
    {
      this.b.pause();
      this.l = 4;
    }
    this.m = 4;
  }
  
  public void seekTo(int paramInt)
  {
    if (a())
    {
      this.b.seekTo(paramInt);
      this.h = -1;
      return;
    }
    this.h = paramInt;
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.j = paramBoolean;
    if (this.b != null) {
      this.b.setLooping(paramBoolean);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if (this.b != null) {
      if (!paramBoolean) {
        break label28;
      }
    }
    label28:
    for (float f1 = 0.0F;; f1 = 1.0F)
    {
      this.b.setVolume(f1, f1);
      return;
    }
  }
  
  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.p = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.o = paramOnErrorListener;
  }
  
  public void setOnPreparedListener(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.n = paramOnPreparedListener;
  }
  
  public void setScaleType$62fbf70(int paramInt)
  {
    int i1 = this.r;
    if (paramInt != 0) {}
    for (;;)
    {
      this.r = paramInt;
      if (i1 != this.r) {
        requestLayout();
      }
      return;
      paramInt = o.d.a;
    }
  }
  
  public void setVideoPath(String paramString)
  {
    this.a = paramString;
  }
  
  public void start()
  {
    if (a())
    {
      this.b.start();
      this.l = 3;
    }
    for (;;)
    {
      this.m = 3;
      return;
      if (this.b == null) {
        b();
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/videoplayback/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */