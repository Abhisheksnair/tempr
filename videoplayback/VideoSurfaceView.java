package com.whatsapp.videoplayback;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.MediaController.MediaPlayerControl;
import com.whatsapp.util.Log;
import java.io.IOException;
import java.util.Map;

public class VideoSurfaceView
  extends SurfaceView
  implements MediaController.MediaPlayerControl
{
  private MediaPlayer.OnErrorListener A = new MediaPlayer.OnErrorListener()
  {
    public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      Log.w("videoview/ Error: " + paramAnonymousInt1 + "," + paramAnonymousInt2);
      VideoSurfaceView.c(VideoSurfaceView.this, -1);
      VideoSurfaceView.d(VideoSurfaceView.this, -1);
      if ((VideoSurfaceView.k(VideoSurfaceView.this) != null) && (VideoSurfaceView.k(VideoSurfaceView.this).onError(VideoSurfaceView.e(VideoSurfaceView.this), paramAnonymousInt1, paramAnonymousInt2))) {}
      return true;
    }
  };
  private MediaPlayer.OnBufferingUpdateListener B = new MediaPlayer.OnBufferingUpdateListener()
  {
    public final void onBufferingUpdate(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt)
    {
      VideoSurfaceView.e(VideoSurfaceView.this, paramAnonymousInt);
    }
  };
  private Uri a;
  MediaPlayer.OnVideoSizeChangedListener b = new MediaPlayer.OnVideoSizeChangedListener()
  {
    public final void onVideoSizeChanged(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      VideoSurfaceView.a(VideoSurfaceView.this, paramAnonymousMediaPlayer.getVideoWidth());
      VideoSurfaceView.b(VideoSurfaceView.this, paramAnonymousMediaPlayer.getVideoHeight());
      Log.i("videoview/onVideoSizeChanged: " + VideoSurfaceView.a(VideoSurfaceView.this) + "x" + VideoSurfaceView.b(VideoSurfaceView.this));
      if ((VideoSurfaceView.a(VideoSurfaceView.this) != 0) && (VideoSurfaceView.b(VideoSurfaceView.this) != 0))
      {
        VideoSurfaceView.this.getHolder().setFixedSize(VideoSurfaceView.a(VideoSurfaceView.this), VideoSurfaceView.b(VideoSurfaceView.this));
        VideoSurfaceView.this.requestLayout();
      }
    }
  };
  MediaPlayer.OnPreparedListener c = new MediaPlayer.OnPreparedListener()
  {
    public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
    {
      VideoSurfaceView.c(VideoSurfaceView.this, 2);
      VideoSurfaceView.a(VideoSurfaceView.this, VideoSurfaceView.b(VideoSurfaceView.this, VideoSurfaceView.c(VideoSurfaceView.this)));
      if (VideoSurfaceView.d(VideoSurfaceView.this) != null) {
        VideoSurfaceView.d(VideoSurfaceView.this).onPrepared(VideoSurfaceView.e(VideoSurfaceView.this));
      }
      VideoSurfaceView.a(VideoSurfaceView.this, paramAnonymousMediaPlayer.getVideoWidth());
      VideoSurfaceView.b(VideoSurfaceView.this, paramAnonymousMediaPlayer.getVideoHeight());
      Log.i("videoview/onPrepare: " + VideoSurfaceView.a(VideoSurfaceView.this) + "x" + VideoSurfaceView.b(VideoSurfaceView.this));
      if (VideoSurfaceView.f(VideoSurfaceView.this) >= 0) {
        VideoSurfaceView.this.seekTo(VideoSurfaceView.f(VideoSurfaceView.this));
      }
      if ((VideoSurfaceView.a(VideoSurfaceView.this) != 0) && (VideoSurfaceView.b(VideoSurfaceView.this) != 0))
      {
        VideoSurfaceView.this.getHolder().setFixedSize(VideoSurfaceView.a(VideoSurfaceView.this), VideoSurfaceView.b(VideoSurfaceView.this));
        if ((VideoSurfaceView.g(VideoSurfaceView.this) == VideoSurfaceView.a(VideoSurfaceView.this)) && (VideoSurfaceView.h(VideoSurfaceView.this) == VideoSurfaceView.b(VideoSurfaceView.this)) && (VideoSurfaceView.i(VideoSurfaceView.this) == 3)) {
          VideoSurfaceView.this.start();
        }
      }
      while (VideoSurfaceView.i(VideoSurfaceView.this) != 3) {
        return;
      }
      VideoSurfaceView.this.start();
    }
  };
  SurfaceHolder.Callback d = new SurfaceHolder.Callback()
  {
    public final void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      Log.i("videoview/surfaceChanged: " + paramAnonymousInt2 + "x" + paramAnonymousInt3);
      VideoSurfaceView.f(VideoSurfaceView.this, paramAnonymousInt2);
      VideoSurfaceView.g(VideoSurfaceView.this, paramAnonymousInt3);
      if ((VideoSurfaceView.a(VideoSurfaceView.this) == paramAnonymousInt2) && (VideoSurfaceView.b(VideoSurfaceView.this) == paramAnonymousInt3)) {}
      for (paramAnonymousInt1 = 1;; paramAnonymousInt1 = 0)
      {
        if ((VideoSurfaceView.e(VideoSurfaceView.this) != null) && (paramAnonymousInt1 != 0))
        {
          if (VideoSurfaceView.f(VideoSurfaceView.this) >= 0) {
            VideoSurfaceView.this.seekTo(VideoSurfaceView.f(VideoSurfaceView.this));
          }
          if (VideoSurfaceView.i(VideoSurfaceView.this) == 3) {
            VideoSurfaceView.this.start();
          }
        }
        return;
      }
    }
    
    public final void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      VideoSurfaceView.a(VideoSurfaceView.this, paramAnonymousSurfaceHolder);
      VideoSurfaceView.l(VideoSurfaceView.this);
    }
    
    public final void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      VideoSurfaceView.h(VideoSurfaceView.this, VideoSurfaceView.this.getCurrentPosition());
      VideoSurfaceView.a(VideoSurfaceView.this, null);
      VideoSurfaceView.m(VideoSurfaceView.this);
    }
  };
  private Map<String, String> e;
  private int f = 0;
  private int g = 0;
  private SurfaceHolder h = null;
  private MediaPlayer i = null;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private MediaPlayer.OnCompletionListener o;
  private MediaPlayer.OnPreparedListener p;
  private int q;
  private MediaPlayer.OnErrorListener r;
  private MediaPlayer.OnInfoListener s;
  private int t = -1;
  private boolean u;
  private boolean v;
  private boolean w;
  private boolean x;
  private boolean y;
  private MediaPlayer.OnCompletionListener z = new MediaPlayer.OnCompletionListener()
  {
    public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
    {
      VideoSurfaceView.c(VideoSurfaceView.this, 5);
      VideoSurfaceView.d(VideoSurfaceView.this, 5);
      if (VideoSurfaceView.j(VideoSurfaceView.this) != null) {
        VideoSurfaceView.j(VideoSurfaceView.this).onCompletion(VideoSurfaceView.e(VideoSurfaceView.this));
      }
    }
  };
  
  public VideoSurfaceView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public VideoSurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    c();
  }
  
  public VideoSurfaceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void c()
  {
    this.k = 0;
    this.l = 0;
    getHolder().addCallback(this.d);
    getHolder().setType(3);
    setFocusable(true);
    setFocusableInTouchMode(true);
    requestFocus();
    this.f = 0;
    this.g = 0;
  }
  
  private void d()
  {
    if ((this.a == null) || (this.h == null)) {
      return;
    }
    Intent localIntent = new Intent("com.android.music.musicservicecommand");
    localIntent.putExtra("command", "pause");
    getContext().sendBroadcast(localIntent);
    a(false);
    try
    {
      this.i = new MediaPlayer();
      if (this.j != 0)
      {
        this.i.setAudioSessionId(this.j);
        if (this.x) {
          this.i.setVolume(0.0F, 0.0F);
        }
        if (this.y) {
          this.i.setLooping(true);
        }
        this.i.setOnPreparedListener(this.c);
        this.i.setOnVideoSizeChangedListener(this.b);
        this.i.setOnCompletionListener(this.z);
        this.i.setOnErrorListener(this.A);
        this.i.setOnInfoListener(this.s);
        this.i.setOnBufferingUpdateListener(this.B);
        this.q = 0;
        this.i.setDataSource(getContext(), this.a, this.e);
        this.i.setDisplay(this.h);
        this.i.setAudioStreamType(3);
        this.i.setScreenOnWhilePlaying(true);
        this.i.prepareAsync();
        this.f = 1;
        return;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.c("videoview/ Unable to open content: " + this.a, localIOException);
        this.f = -1;
        this.g = -1;
        this.A.onError(this.i, 1, 0);
        return;
        this.j = this.i.getAudioSessionId();
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
  }
  
  public final void a()
  {
    if (this.i != null)
    {
      this.i.reset();
      this.i.release();
      this.i = null;
      this.f = 0;
      this.g = 0;
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    Log.i("videoview/setVideoDimensions: " + paramInt1 + "x" + paramInt2);
    this.k = paramInt1;
    this.l = paramInt2;
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.i != null)
    {
      this.i.reset();
      this.i.release();
      this.i = null;
      this.f = 0;
      if (paramBoolean) {
        this.g = 0;
      }
    }
  }
  
  public final boolean b()
  {
    return (this.i != null) && (this.f != -1) && (this.f != 0) && (this.f != 1);
  }
  
  public boolean canPause()
  {
    return this.u;
  }
  
  public boolean canSeekBackward()
  {
    return this.v;
  }
  
  public boolean canSeekForward()
  {
    return this.w;
  }
  
  public int getAudioSessionId()
  {
    if (this.j == 0)
    {
      MediaPlayer localMediaPlayer = new MediaPlayer();
      this.j = localMediaPlayer.getAudioSessionId();
      localMediaPlayer.release();
    }
    return this.j;
  }
  
  public int getBufferPercentage()
  {
    if (this.i != null) {
      return this.q;
    }
    return 0;
  }
  
  public int getCurrentPosition()
  {
    if (b()) {
      return this.i.getCurrentPosition();
    }
    return 0;
  }
  
  public int getDuration()
  {
    if (b()) {
      return this.i.getDuration();
    }
    return -1;
  }
  
  public boolean isPlaying()
  {
    return (b()) && (this.i.isPlaying());
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(VideoSurfaceView.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(VideoSurfaceView.class.getName());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = getDefaultSize(this.k, paramInt1);
    int i4 = getDefaultSize(this.l, paramInt2);
    int i2 = i4;
    int i1 = i3;
    int i5;
    if (this.k > 0)
    {
      i2 = i4;
      i1 = i3;
      if (this.l > 0)
      {
        i4 = View.MeasureSpec.getMode(paramInt1);
        paramInt1 = View.MeasureSpec.getSize(paramInt1);
        i5 = View.MeasureSpec.getMode(paramInt2);
        paramInt2 = View.MeasureSpec.getSize(paramInt2);
        if ((i4 != 1073741824) || (i5 != 1073741824)) {
          break label200;
        }
        if (this.k * paramInt2 >= this.l * paramInt1) {
          break label161;
        }
        Log.d("videoview/ image too wide, correcting");
        i1 = this.k * paramInt2 / this.l;
        i2 = paramInt2;
      }
    }
    for (;;)
    {
      Log.i("videoview/setMeasuredDimension: " + i1 + "x" + i2);
      setMeasuredDimension(i1, i2);
      return;
      label161:
      if (this.k * paramInt2 > this.l * paramInt1)
      {
        Log.d("videoview/ image too tall, correcting");
        i2 = this.l * paramInt1 / this.k;
        i1 = paramInt1;
        continue;
        label200:
        if (i4 == 1073741824)
        {
          i2 = this.l * paramInt1 / this.k;
          if ((i5 == Integer.MIN_VALUE) && (i2 > paramInt2))
          {
            i2 = paramInt2;
            i1 = paramInt1;
          }
        }
        else
        {
          if (i5 == 1073741824)
          {
            i3 = this.k * paramInt2 / this.l;
            i2 = paramInt2;
            i1 = i3;
            if (i4 != Integer.MIN_VALUE) {
              continue;
            }
            i2 = paramInt2;
            i1 = i3;
            if (i3 <= paramInt1) {
              continue;
            }
            i2 = paramInt2;
            i1 = paramInt1;
            continue;
          }
          i3 = this.k;
          i1 = this.l;
          if ((i5 == Integer.MIN_VALUE) && (i1 > paramInt2)) {
            i3 = this.k * paramInt2 / this.l;
          }
          for (;;)
          {
            i2 = paramInt2;
            i1 = i3;
            if (i4 != Integer.MIN_VALUE) {
              break;
            }
            i2 = paramInt2;
            i1 = i3;
            if (i3 <= paramInt1) {
              break;
            }
            i2 = this.l * paramInt1 / this.k;
            i1 = paramInt1;
            break;
            paramInt2 = i1;
          }
        }
        i1 = paramInt1;
      }
      else
      {
        i2 = paramInt2;
        i1 = paramInt1;
      }
    }
  }
  
  public void pause()
  {
    if ((b()) && (this.i.isPlaying()))
    {
      this.i.pause();
      this.f = 4;
    }
    this.g = 4;
  }
  
  public void seekTo(int paramInt)
  {
    if (b())
    {
      this.i.seekTo(paramInt);
      this.t = -1;
      return;
    }
    this.t = paramInt;
  }
  
  public void setLooping(boolean paramBoolean)
  {
    this.y = paramBoolean;
    if (this.i != null) {
      this.i.setLooping(paramBoolean);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.x = paramBoolean;
    if (this.i != null) {
      if (!this.x) {
        break label31;
      }
    }
    label31:
    for (float f1 = 0.0F;; f1 = 1.0F)
    {
      this.i.setVolume(f1, f1);
      return;
    }
  }
  
  public void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener)
  {
    this.o = paramOnCompletionListener;
  }
  
  public void setOnErrorListener(MediaPlayer.OnErrorListener paramOnErrorListener)
  {
    this.r = paramOnErrorListener;
  }
  
  public void setOnInfoListener(MediaPlayer.OnInfoListener paramOnInfoListener)
  {
    this.s = paramOnInfoListener;
  }
  
  public void setOnPreparedListener(MediaPlayer.OnPreparedListener paramOnPreparedListener)
  {
    this.p = paramOnPreparedListener;
  }
  
  public void setVideoPath(String paramString)
  {
    setVideoURI(Uri.parse(paramString));
  }
  
  public void setVideoURI(Uri paramUri)
  {
    this.a = paramUri;
    this.e = null;
    this.t = -1;
    d();
    requestLayout();
    invalidate();
  }
  
  public void start()
  {
    if (b())
    {
      this.i.start();
      this.f = 3;
    }
    this.g = 3;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/videoplayback/VideoSurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */