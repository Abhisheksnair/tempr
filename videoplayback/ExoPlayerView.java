package com.whatsapp.videoplayback;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.exoplayer2.c.a;
import com.google.android.exoplayer2.f.k.a;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.m.b;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.SubtitleView;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;
import com.whatsapp.util.ag;
import java.util.List;

@TargetApi(16)
public final class ExoPlayerView
  extends FrameLayout
{
  ImageView a;
  boolean b = true;
  private final View c;
  private final View d;
  private final SubtitleView e;
  private final AspectRatioFrameLayout f;
  private final a g;
  private m h;
  private ExoPlaybackControlView i;
  private d j;
  private j k;
  private b l;
  private int m = -1;
  private boolean n = false;
  private String o;
  private final ag p = ag.a();
  
  public ExoPlayerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExoPlayerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExoPlayerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2130903404, this);
    this.g = new a((byte)0);
    this.f = ((AspectRatioFrameLayout)findViewById(2131756252));
    this.d = findViewById(2131755408);
    this.a = ((ImageView)findViewById(2131755587));
    this.e = ((SubtitleView)findViewById(2131756253));
    this.e.b();
    this.e.a();
    this.c = new n(paramContext);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    this.c.setLayoutParams(paramContext);
    this.f.addView(this.c, 0);
    this.l = new b((byte)0);
  }
  
  public final void a()
  {
    if (this.i != null) {
      this.i.setPlayer(null);
    }
  }
  
  public final void a(ExoPlaybackControlView paramExoPlaybackControlView, boolean paramBoolean)
  {
    Log.d("WAExoPlayerView/setController=");
    this.i = paramExoPlaybackControlView;
    if (this.i != null)
    {
      if (paramBoolean) {
        this.i.setVisibilityListener(this.l);
      }
      if (this.h != null) {
        this.i.setPlayer(this.h);
      }
    }
  }
  
  public final void a(boolean paramBoolean, String paramString)
  {
    this.o = paramString;
    if ((this.j != null) && (this.n != paramBoolean))
    {
      if ((!paramBoolean) || (this.m != 2)) {
        break label46;
      }
      this.j.a(paramString);
    }
    for (;;)
    {
      this.n = paramBoolean;
      return;
      label46:
      if ((!paramBoolean) && (this.m == 2)) {
        this.j.a();
      }
    }
  }
  
  public final void b()
  {
    this.h = null;
    this.a.setVisibility(8);
    if (this.j != null) {
      this.j.b();
    }
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (this.i != null) {
      return this.i.dispatchKeyEvent(paramKeyEvent);
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (this.i == null) {
      bool = false;
    }
    while (paramMotionEvent.getActionMasked() != 1) {
      return bool;
    }
    if (this.i.e())
    {
      this.i.d();
      return true;
    }
    this.i.a();
    this.i.a(3000);
    return true;
  }
  
  public final boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    if (this.i == null) {
      return false;
    }
    this.i.a();
    return true;
  }
  
  public final void setBackpressListener(ExoPlaybackControlView.a parama)
  {
    if (this.i != null) {
      this.i.setBackpressListener(parama);
    }
  }
  
  public final void setController(ExoPlaybackControlView paramExoPlaybackControlView)
  {
    a(paramExoPlaybackControlView, true);
  }
  
  public final void setExoPlayerErrorActionsController(d paramd)
  {
    this.j = paramd;
  }
  
  public final void setMessage(j paramj)
  {
    this.k = paramj;
  }
  
  public final void setPlayer(m paramm)
  {
    if (this.h != null)
    {
      this.h.a(null);
      this.h.a(null);
      this.h.b(this.g);
      this.h.j();
    }
    this.h = paramm;
    if (paramm != null) {
      if ((this.c instanceof TextureView))
      {
        paramm.a((TextureView)this.c);
        paramm.a(this.g);
        paramm.a(this.g);
        paramm.a(this.g);
        if (this.i != null) {
          this.i.setPlayer(paramm);
        }
      }
    }
    for (;;)
    {
      if ((this.k != null) && (this.b))
      {
        this.a.setVisibility(0);
        this.p.a(this.k, this.a, null);
      }
      this.n = false;
      return;
      if (!(this.c instanceof SurfaceView)) {
        break;
      }
      paramm.a((SurfaceView)this.c);
      break;
      this.d.setVisibility(0);
    }
  }
  
  final class a
    implements c.a, k.a, m.b
  {
    private a() {}
    
    public final void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat)
    {
      float f = 1.0F;
      if (paramInt3 != 0) {
        Log.i("WAExoPlayerView/onVideoSizeChanged/unappliedRotationDegrees=" + paramInt3);
      }
      if (((paramInt3 == 90) || (paramInt3 == 270)) && ((ExoPlayerView.d(ExoPlayerView.this) instanceof n)))
      {
        ((n)ExoPlayerView.d(ExoPlayerView.this)).setRotationAngle(paramInt3);
        localAspectRatioFrameLayout = ExoPlayerView.e(ExoPlayerView.this);
        if (paramInt2 == 0) {}
        for (paramFloat = 1.0F;; paramFloat = paramInt2 / (paramInt1 * paramFloat))
        {
          localAspectRatioFrameLayout.setAspectRatio(paramFloat);
          return;
        }
      }
      AspectRatioFrameLayout localAspectRatioFrameLayout = ExoPlayerView.e(ExoPlayerView.this);
      if (paramInt2 == 0) {}
      for (paramFloat = f;; paramFloat = paramInt1 * paramFloat / paramInt2)
      {
        localAspectRatioFrameLayout.setAspectRatio(paramFloat);
        return;
      }
    }
    
    public final void a(com.google.android.exoplayer2.b paramb) {}
    
    public final void a(List<com.google.android.exoplayer2.f.b> paramList)
    {
      ExoPlayerView.c(ExoPlayerView.this).a(paramList);
    }
    
    public final void a(boolean paramBoolean, int paramInt)
    {
      StringBuilder localStringBuilder = new StringBuilder("WAExoPlayerView/playbackstate=");
      String str;
      switch (paramInt)
      {
      default: 
        str = "STATE_INVALID";
        Log.d(str + ", playWhenReady=" + paramBoolean);
        ExoPlayerView.a(ExoPlayerView.this, paramInt);
        if (paramInt == 3)
        {
          ExoPlayerView.g(ExoPlayerView.this).setVisibility(8);
          if (ExoPlayerView.h(ExoPlayerView.this) != null) {
            ExoPlayerView.h(ExoPlayerView.this).b();
          }
        }
        break;
      }
      label274:
      do
      {
        do
        {
          return;
          str = "STATE_IDLE";
          break;
          str = "STATE_BUFFERING";
          break;
          str = "STATE_READY";
          break;
          str = "STATE_ENDED";
          break;
          if ((ExoPlayerView.i(ExoPlayerView.this) != null) && (paramInt == 4))
          {
            if (!ExoPlayerView.i(ExoPlayerView.this).e()) {
              ExoPlayerView.i(ExoPlayerView.this).a();
            }
            if (ExoPlayerView.h(ExoPlayerView.this) != null) {
              ExoPlayerView.h(ExoPlayerView.this).b();
            }
            ExoPlayerView.j(ExoPlayerView.this).a(0L);
            ExoPlayerView.j(ExoPlayerView.this).a(false);
            return;
          }
          if (paramInt != 2) {
            break label274;
          }
        } while (ExoPlayerView.h(ExoPlayerView.this) == null);
        if (ExoPlayerView.k(ExoPlayerView.this))
        {
          ExoPlayerView.h(ExoPlayerView.this).a(ExoPlayerView.l(ExoPlayerView.this));
          return;
        }
        ExoPlayerView.h(ExoPlayerView.this).a();
        return;
      } while (ExoPlayerView.h(ExoPlayerView.this) == null);
      ExoPlayerView.h(ExoPlayerView.this).b();
    }
    
    public final void c() {}
    
    public final void d()
    {
      ExoPlayerView.f(ExoPlayerView.this).setVisibility(8);
    }
    
    public final void m_() {}
    
    public final void n_() {}
  }
  
  final class b
    implements ExoPlaybackControlView.e
  {
    private b() {}
    
    public final void a(int paramInt)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        if (paramInt == 0) {
          ExoPlayerView.a(ExoPlayerView.this);
        }
      }
      else {
        return;
      }
      ExoPlayerView.b(ExoPlayerView.this);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/videoplayback/ExoPlayerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */