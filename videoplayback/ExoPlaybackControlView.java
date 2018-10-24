package com.whatsapp.videoplayback;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.google.android.exoplayer2.c.a;
import com.google.android.exoplayer2.n;
import com.google.android.exoplayer2.n.b;
import com.whatsapp.VideoDownloadStreamActivity;
import com.whatsapp.pv;
import java.util.Formatter;
import java.util.Locale;

@TargetApi(16)
public class ExoPlaybackControlView
  extends FrameLayout
{
  private final pv A;
  public final ImageView a;
  a b;
  final Runnable c = a.a(this);
  final Runnable d = b.a(this);
  private final b e;
  private final FrameLayout f;
  private final FrameLayout g;
  private final ImageButton h;
  private final TextView i;
  private final TextView j;
  private final SeekBar k;
  private final StringBuilder l;
  private final Formatter m;
  private final n.b n;
  private final LinearLayout o;
  private com.google.android.exoplayer2.c p;
  private c q;
  private d r;
  private e s;
  private AlphaAnimation t;
  private boolean u;
  private boolean v = true;
  private Long w;
  private boolean x = true;
  private int y = 5000;
  private int z = 15000;
  
  public ExoPlaybackControlView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExoPlaybackControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExoPlaybackControlView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode()) {}
    for (paramAttributeSet = null;; paramAttributeSet = pv.a())
    {
      this.A = paramAttributeSet;
      if (Build.VERSION.SDK_INT >= 16) {
        break;
      }
      throw new IllegalArgumentException("this playback view is not supported on version <16");
    }
    this.n = new n.b();
    this.l = new StringBuilder();
    this.m = new Formatter(this.l, Locale.getDefault());
    this.e = new b((byte)0);
    LayoutInflater.from(paramContext).inflate(2130903403, this);
    this.f = ((FrameLayout)findViewById(2131756248));
    this.i = ((TextView)findViewById(2131755988));
    this.j = ((TextView)findViewById(2131756250));
    this.k = ((SeekBar)findViewById(2131756251));
    this.a = ((ImageView)findViewById(2131755439));
    this.o = ((LinearLayout)findViewById(2131756249));
    this.k.setOnSeekBarChangeListener(this.e);
    this.k.setMax(1000);
    this.g = ((FrameLayout)findViewById(2131755579));
    this.h = ((ImageButton)findViewById(2131756170));
    this.g.setOnClickListener(this.e);
    f();
    if ((!isInEditMode()) && (this.A.a)) {
      this.a.setRotationY(180.0F);
    }
    this.a.setOnClickListener(c.a(this));
    onConfigurationChanged(getResources().getConfiguration());
  }
  
  private static float a(Context paramContext, float paramFloat)
  {
    return paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F;
  }
  
  private String a(long paramLong)
  {
    long l1 = paramLong;
    if (paramLong == -9223372036854775807L) {
      l1 = 0L;
    }
    long l2 = (500L + l1) / 1000L;
    paramLong = l2 % 60L;
    l1 = l2 / 60L % 60L;
    l2 /= 3600L;
    this.l.setLength(0);
    if (l2 > 0L) {
      return this.m.format("%d:%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
    }
    return this.m.format("%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
  }
  
  private int b(long paramLong)
  {
    long l1 = getDuration();
    if ((l1 == -9223372036854775807L) || (l1 == 0L)) {
      return 0;
    }
    return (int)(1000L * paramLong / l1);
  }
  
  private void f()
  {
    g();
    h();
    i();
  }
  
  private void g()
  {
    if (this.g.getVisibility() == 4) {
      return;
    }
    Object localObject;
    int i2;
    if ((this.p != null) && (this.p.b()))
    {
      i1 = 1;
      localObject = this.h;
      if (i1 == 0) {
        break label84;
      }
      i2 = 2130840267;
      label46:
      ((ImageButton)localObject).setImageResource(i2);
      localObject = getResources();
      if (i1 == 0) {
        break label91;
      }
    }
    label84:
    label91:
    for (int i1 = 2131296773;; i1 = 2131296774)
    {
      localObject = ((Resources)localObject).getString(i1);
      this.h.setContentDescription((CharSequence)localObject);
      return;
      i1 = 0;
      break;
      i2 = 2130840268;
      break label46;
    }
  }
  
  private void h()
  {
    int i1 = 1;
    boolean bool = false;
    if (!e()) {
      return;
    }
    if (this.w == null)
    {
      n localn;
      if (this.p != null)
      {
        localn = this.p.e();
        if ((localn == null) || (localn.a())) {
          break label91;
        }
      }
      for (;;)
      {
        if (i1 != 0)
        {
          localn.a(this.p.f(), this.n);
          bool = this.n.d;
        }
        this.k.setEnabled(bool);
        return;
        localn = null;
        break;
        label91:
        i1 = 0;
      }
    }
    this.k.setEnabled(true);
  }
  
  private void i()
  {
    long l2 = 0L;
    if (!e()) {
      return;
    }
    label27:
    label55:
    label67:
    label77:
    int i1;
    if (this.w == null)
    {
      if (this.p == null)
      {
        l1 = 0L;
        this.i.setText(a(l1));
      }
    }
    else
    {
      if (!this.v) {
        break label227;
      }
      if (this.p != null) {
        break label214;
      }
      l1 = 0L;
      this.k.setSecondaryProgress(b(l1));
      if (this.p != null) {
        break label240;
      }
      l1 = l2;
      if (!this.u) {
        this.j.setText(a(l1));
      }
      if (!this.u) {
        this.k.setProgress(b(l1));
      }
      removeCallbacks(this.c);
      if (this.p != null) {
        break label253;
      }
      i1 = 1;
      label133:
      if ((i1 == 1) || (i1 == 4)) {
        break label264;
      }
      if ((!this.p.b()) || (i1 != 3)) {
        break label266;
      }
      l2 = 1000L - l1 % 1000L;
      l1 = l2;
      if (l2 >= 200L) {}
    }
    label214:
    label227:
    label240:
    label253:
    label264:
    label266:
    for (long l1 = l2 + 1000L;; l1 = 1000L)
    {
      postDelayed(this.c, l1);
      return;
      l1 = this.p.g();
      break label27;
      l1 = this.p.i();
      break label55;
      this.k.setSecondaryProgress(1000);
      break label67;
      l1 = this.p.h();
      break label77;
      i1 = this.p.a();
      break label133;
      break;
    }
  }
  
  public final void a()
  {
    this.f.setVisibility(0);
    if (this.s != null) {
      this.s.a(this.f.getVisibility());
    }
    DecelerateInterpolator localDecelerateInterpolator = new DecelerateInterpolator(1.5F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, getAlpha());
    localAlphaAnimation.setDuration(250L);
    localAlphaAnimation.setInterpolator(localDecelerateInterpolator);
    Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), 2130968597);
    localAnimation1.setDuration(250L);
    localAnimation1.setInterpolator(localDecelerateInterpolator);
    Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), 2130968594);
    localAnimation2.setDuration(250L);
    localAnimation2.setInterpolator(localDecelerateInterpolator);
    if ((this.g.getVisibility() == 4) && (this.x))
    {
      this.g.setVisibility(0);
      this.g.startAnimation(localAlphaAnimation);
    }
    this.f.startAnimation(localAlphaAnimation);
    this.o.startAnimation(localAnimation1);
    this.a.startAnimation(localAnimation2);
    f();
  }
  
  public final void a(int paramInt)
  {
    removeCallbacks(this.d);
    if ((this.p != null) && (this.p.b())) {
      postDelayed(this.d, paramInt);
    }
    if (this.t != null)
    {
      clearAnimation();
      this.t = null;
    }
  }
  
  public final void b()
  {
    if (this.x) {
      this.g.setVisibility(0);
    }
    this.f.setVisibility(4);
    f();
  }
  
  public final void c()
  {
    this.f.setVisibility(0);
    if (this.x) {
      this.g.setVisibility(0);
    }
    f();
  }
  
  public final void d()
  {
    if (this.t != null) {}
    do
    {
      return;
      AccelerateInterpolator localAccelerateInterpolator = new AccelerateInterpolator(1.5F);
      this.t = new AlphaAnimation(getAlpha(), 0.0F);
      this.t.setDuration(250L);
      this.t.setInterpolator(localAccelerateInterpolator);
      this.t.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          ExoPlaybackControlView.this.setAlpha(1.0F);
          ExoPlaybackControlView.this.removeCallbacks(ExoPlaybackControlView.a(ExoPlaybackControlView.this));
          ExoPlaybackControlView.this.removeCallbacks(ExoPlaybackControlView.b(ExoPlaybackControlView.this));
          ExoPlaybackControlView.c(ExoPlaybackControlView.this);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      if (e())
      {
        this.f.setVisibility(4);
        if (this.s != null) {
          this.s.a(this.f.getVisibility());
        }
        Animation localAnimation1 = AnimationUtils.loadAnimation(getContext(), 2130968596);
        localAnimation1.setDuration(250L);
        localAnimation1.setInterpolator(localAccelerateInterpolator);
        Animation localAnimation2 = AnimationUtils.loadAnimation(getContext(), 2130968595);
        localAnimation2.setDuration(250L);
        localAnimation2.setInterpolator(localAccelerateInterpolator);
        this.a.startAnimation(localAnimation2);
        this.f.startAnimation(this.t);
        this.o.startAnimation(localAnimation1);
      }
    } while ((!this.x) || (this.g.getVisibility() != 0) || (this.p == null) || (!this.p.b()) || ((this.p.a() != 3) && (this.p.a() != 2)));
    this.g.setVisibility(4);
    this.g.startAnimation(this.t);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if ((this.p == null) || (paramKeyEvent.getAction() != 0)) {
      return super.dispatchKeyEvent(paramKeyEvent);
    }
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      return false;
    case 21: 
    case 89: 
      this.p.a(Math.max(this.p.h() - this.y, 0L));
    }
    for (;;)
    {
      a();
      return true;
      this.p.a(Math.min(this.p.h() + this.z, this.p.g()));
      continue;
      paramKeyEvent = this.p;
      if (!this.p.b()) {
        bool = true;
      }
      paramKeyEvent.a(bool);
      continue;
      this.p.a(true);
      continue;
      this.p.a(false);
      continue;
      paramKeyEvent = this.p.e();
      if (paramKeyEvent != null)
      {
        int i1 = this.p.f();
        if (i1 < paramKeyEvent.b() - 1)
        {
          this.p.a(i1 + 1);
        }
        else if (paramKeyEvent.b(i1, this.n).e)
        {
          this.p.c();
          continue;
          paramKeyEvent = this.p.e();
          if (paramKeyEvent != null)
          {
            i1 = this.p.f();
            paramKeyEvent.a(i1, this.n);
            if ((i1 > 0) && ((this.p.h() <= 3000L) || ((this.n.e) && (!this.n.d)))) {
              this.p.a(i1 - 1);
            } else {
              this.p.a(0L);
            }
          }
        }
      }
    }
  }
  
  public final boolean e()
  {
    return this.f.getVisibility() == 0;
  }
  
  public long getDuration()
  {
    if (this.w != null) {
      return this.w.longValue();
    }
    if (this.p == null) {
      return -9223372036854775807L;
    }
    return this.p.g();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (paramConfiguration.orientation == 2) {}
    for (int i1 = (int)a(getContext(), 20.0F);; i1 = (int)a(getContext(), 30.0F))
    {
      this.j.setPadding(this.j.getPaddingLeft(), i1, this.j.getPaddingRight(), i1);
      this.k.setPadding(this.k.getPaddingLeft(), i1, this.k.getPaddingRight(), i1);
      this.i.setPadding(this.i.getPaddingLeft(), i1, this.i.getPaddingRight(), i1);
      return;
    }
  }
  
  public void setBackpressListener(a parama)
  {
    this.b = parama;
  }
  
  public void setDuration(long paramLong)
  {
    this.w = Long.valueOf(paramLong);
    this.i.setText(a(this.w.longValue()));
    i();
    h();
  }
  
  public void setPlayButtonClickListener(c paramc)
  {
    this.q = paramc;
  }
  
  public void setPlayControlVisibility(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.x = bool;
      this.g.setVisibility(paramInt);
      return;
    }
  }
  
  public void setPlayer(com.google.android.exoplayer2.c paramc)
  {
    if (this.p != null) {
      this.p.b(this.e);
    }
    this.p = paramc;
    if (paramc != null) {
      paramc.a(this.e);
    }
    f();
  }
  
  public void setSeekbarStartTrackingTouchListener(d paramd)
  {
    this.r = paramd;
  }
  
  public void setStreaming(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public void setVisibilityListener(e parame)
  {
    this.s = parame;
  }
  
  public static final class a
  {
    public final VideoDownloadStreamActivity a;
    
    public a(VideoDownloadStreamActivity paramVideoDownloadStreamActivity)
    {
      this.a = paramVideoDownloadStreamActivity;
    }
  }
  
  final class b
    implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, c.a
  {
    private b() {}
    
    public final void a(com.google.android.exoplayer2.b paramb) {}
    
    public final void a(boolean paramBoolean, int paramInt)
    {
      ExoPlaybackControlView.g(ExoPlaybackControlView.this);
      ExoPlaybackControlView.h(ExoPlaybackControlView.this);
    }
    
    public final void c()
    {
      ExoPlaybackControlView.i(ExoPlaybackControlView.this);
      ExoPlaybackControlView.h(ExoPlaybackControlView.this);
    }
    
    public final void m_()
    {
      ExoPlaybackControlView.i(ExoPlaybackControlView.this);
      ExoPlaybackControlView.h(ExoPlaybackControlView.this);
    }
    
    public final void n_() {}
    
    public final void onClick(View paramView)
    {
      if (ExoPlaybackControlView.j(ExoPlaybackControlView.this) != null) {
        ExoPlaybackControlView.j(ExoPlaybackControlView.this).a();
      }
      if ((ExoPlaybackControlView.k(ExoPlaybackControlView.this) == paramView) && (ExoPlaybackControlView.f(ExoPlaybackControlView.this) != null))
      {
        if (ExoPlaybackControlView.f(ExoPlaybackControlView.this).a() == 4) {
          ExoPlaybackControlView.f(ExoPlaybackControlView.this).a(0L);
        }
      }
      else
      {
        ExoPlaybackControlView.this.a(300);
        return;
      }
      paramView = ExoPlaybackControlView.f(ExoPlaybackControlView.this);
      if (!ExoPlaybackControlView.f(ExoPlaybackControlView.this).b()) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.a(bool);
        break;
      }
    }
    
    public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
    {
      if (paramBoolean) {
        ExoPlaybackControlView.e(ExoPlaybackControlView.this).setText(ExoPlaybackControlView.a(ExoPlaybackControlView.this, ExoPlaybackControlView.a(ExoPlaybackControlView.this, paramInt)));
      }
    }
    
    public final void onStartTrackingTouch(SeekBar paramSeekBar)
    {
      ExoPlaybackControlView.this.removeCallbacks(ExoPlaybackControlView.b(ExoPlaybackControlView.this));
      if (ExoPlaybackControlView.d(ExoPlaybackControlView.this) != null) {
        ExoPlaybackControlView.d(ExoPlaybackControlView.this).a();
      }
      ExoPlaybackControlView.a(ExoPlaybackControlView.this, true);
    }
    
    public final void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      ExoPlaybackControlView.a(ExoPlaybackControlView.this, false);
      if (ExoPlaybackControlView.f(ExoPlaybackControlView.this) != null) {
        ExoPlaybackControlView.f(ExoPlaybackControlView.this).a(ExoPlaybackControlView.a(ExoPlaybackControlView.this, paramSeekBar.getProgress()));
      }
      ExoPlaybackControlView.this.a(3000);
    }
  }
  
  public static abstract interface c
  {
    public abstract void a();
  }
  
  public static abstract interface d
  {
    public abstract void a();
  }
  
  public static abstract interface e
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/videoplayback/ExoPlaybackControlView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */