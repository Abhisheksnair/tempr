package com.whatsapp;

import a.a.a.a.d;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.HandlerThread;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ab;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.whatsapp.emoji.h;
import com.whatsapp.emoji.search.i.b;
import com.whatsapp.emoji.search.q;
import com.whatsapp.emoji.search.q.a;
import com.whatsapp.util.a;
import com.whatsapp.util.at;

public class os
  extends PopupWindow
{
  private final View a;
  private EmojiPicker.c b;
  public final Activity c;
  public final pv d;
  protected final atv e;
  protected final h f;
  protected EmojiPicker g;
  protected ImageButton h;
  protected View i;
  public ViewGroup j;
  public View k;
  public int l;
  public int m;
  protected int n;
  protected int o;
  public View p;
  public boolean q;
  public q r;
  public i.b s;
  public boolean t;
  private final EmojiPicker.c u = new EmojiPicker.c()
  {
    public final void a()
    {
      os.this.h();
      if (os.a(os.this) != null) {
        os.a(os.this).a();
      }
    }
    
    public final void a(int paramAnonymousInt)
    {
      os.this.h();
      if (os.a(os.this) != null) {
        os.a(os.this).a(paramAnonymousInt);
      }
    }
  };
  private final AbsListView.OnScrollListener v = new AbsListView.OnScrollListener()
  {
    public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      paramAnonymousInt2 = os.this.k.getHeight();
      if (os.this.n >= paramAnonymousInt1) {
        if (os.this.n > paramAnonymousInt1) {
          paramAnonymousInt2 = 0;
        }
      }
      for (;;)
      {
        os.this.n = paramAnonymousInt1;
        if ((paramAnonymousInt2 >= 0) && (paramAnonymousInt2 != os.this.l))
        {
          paramAnonymousAbsListView = os.this.k.getAnimation();
          if ((!(paramAnonymousAbsListView instanceof os.a)) || (os.a.a((os.a)paramAnonymousAbsListView) != paramAnonymousInt2)) {}
        }
        else
        {
          return;
          paramAnonymousInt2 = -1;
          continue;
        }
        if (paramAnonymousAbsListView != null) {
          paramAnonymousAbsListView.cancel();
        }
        os.this.k.startAnimation(new os.a(os.this, paramAnonymousInt2));
        return;
      }
    }
    
    public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
  };
  private final ViewTreeObserver.OnGlobalLayoutListener w = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      int[] arrayOfInt = new int[2];
      os.this.i.getLocationInWindow(arrayOfInt);
      int i = (int)(os.this.o * os.this.c.getResources().getDisplayMetrics().density + 0.5F);
      if (a.a)
      {
        os.this.update(arrayOfInt[0], arrayOfInt[1] + os.this.i.getHeight() + i, -1, os.this.b() - i);
        return;
      }
      os.this.update(arrayOfInt[0], arrayOfInt[1] + os.this.i.getHeight() + i, -1, -1);
    }
  };
  
  public os(View paramView, Activity paramActivity, pv parampv, h paramh, atv paramatv)
  {
    super(paramActivity);
    this.a = paramView;
    this.c = paramActivity;
    this.d = parampv;
    this.f = paramh;
    this.e = paramatv;
  }
  
  public void a()
  {
    int i2 = 8;
    Object localObject = new RelativeLayout(this.c);
    al.a(this.d, this.c.getLayoutInflater(), 2130903216, (ViewGroup)localObject, true);
    this.j = ((ViewGroup)((RelativeLayout)localObject).findViewById(2131755727));
    this.j.getLayoutParams().height = -1;
    this.j.setVisibility(0);
    setContentView((View)localObject);
    if (al.a) {
      ((RelativeLayout)localObject).setLayoutDirection(3);
    }
    setWidth(-1);
    setHeight(-2);
    setBackgroundDrawable(new BitmapDrawable());
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(true);
    setInputMethodMode(2);
    setAnimationStyle(0);
    this.g = new EmojiPicker(this.c, this.d, this.f, this.e, this.j, f(), this.v);
    this.g.j = this.u;
    this.g.c = this.a;
    this.k = this.j.findViewById(2131755755);
    this.k.setClickable(true);
    this.p = ((RelativeLayout)localObject).findViewById(2131755763);
    this.p.setOnTouchListener(ot.a(this));
    localObject = this.p;
    if (this.q) {}
    for (int i1 = 0;; i1 = 8)
    {
      ((View)localObject).setVisibility(i1);
      this.j.getViewTreeObserver().addOnGlobalLayoutListener(ou.a(this));
      if (d())
      {
        this.g.b();
        localObject = (ImageView)this.j.findViewById(2131755757);
        ImageView localImageView = (ImageView)this.j.findViewById(2131755756);
        View localView = this.j.findViewById(2131755208);
        ((ImageView)localObject).setVisibility(8);
        localImageView.setVisibility(8);
        if (aic.G)
        {
          this.r = q.a();
          this.r.a = new q.a(localView);
          i1 = i2;
          if (this.r.b) {
            i1 = 0;
          }
          localView.setVisibility(i1);
          this.r.b();
          localView.setOnClickListener(new at()
          {
            public final void a(View paramAnonymousView)
            {
              os.this.h();
              if ((os.this.r != null) && (os.this.r.b) && (os.this.s != null)) {
                os.this.s.a(os.this.r);
              }
              d.a(os.this.c.getApplicationContext(), false);
            }
          });
        }
        this.j.findViewById(2131755758).setVisibility(0);
      }
      setTouchInterceptor(ov.a(this));
      return;
    }
  }
  
  public final void a(View paramView, ImageButton paramImageButton)
  {
    if (this.g == null) {
      a();
    }
    EmojiPicker localEmojiPicker = this.g;
    if (EmojiPicker.f == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("Emoji Thread");
      EmojiPicker.f = localHandlerThread;
      localHandlerThread.start();
      EmojiPicker.g = new EmojiPicker.f(EmojiPicker.f.getLooper(), (byte)0);
      EmojiPicker.h = new EmojiPicker.e(u.a().getMainLooper(), (byte)0);
    }
    localEmojiPicker.b.getViewTreeObserver().addOnGlobalLayoutListener(localEmojiPicker.l);
    this.i = paramView;
    this.h = paramImageButton;
    if (paramImageButton != null) {
      paramImageButton.setImageResource(2130840319);
    }
    paramImageButton = new int[2];
    paramView.getLocationInWindow(paramImageButton);
    int i1 = paramImageButton[1];
    int i2 = paramView.getHeight();
    int i3 = (int)(this.o * this.c.getResources().getDisplayMetrics().density + 0.5F);
    setHeight(b() - i3);
    setWidth(-1);
    if (a.a) {
      showAtLocation(paramView, 48, paramImageButton[0], i1 + i2 + i3);
    }
    for (;;)
    {
      paramView.getViewTreeObserver().addOnGlobalLayoutListener(this.w);
      h();
      return;
      showAsDropDown(paramView, 0, i3);
    }
  }
  
  public final void a(EmojiPicker.c paramc)
  {
    this.b = paramc;
    if (this.g != null) {
      this.g.j = this.u;
    }
  }
  
  protected int b()
  {
    int[] arrayOfInt = new int[2];
    this.i.getLocationOnScreen(arrayOfInt);
    int i1 = arrayOfInt[1];
    int i2 = this.i.getHeight();
    if (a.a)
    {
      arrayOfInt = new int[2];
      this.a.getLocationOnScreen(arrayOfInt);
      return this.a.getHeight() - (i1 + i2) + arrayOfInt[1];
    }
    return -2;
  }
  
  public boolean d()
  {
    return aic.G;
  }
  
  public void dismiss()
  {
    if (this.h != null) {
      this.h.setImageResource(2130840317);
    }
    if (this.i != null) {
      this.i.getViewTreeObserver().removeGlobalOnLayoutListener(this.w);
    }
    if (this.g != null)
    {
      EmojiPicker localEmojiPicker = this.g;
      localEmojiPicker.e.setVisibility(8);
      localEmojiPicker.b.getViewTreeObserver().removeGlobalOnLayoutListener(localEmojiPicker.l);
    }
    super.dismiss();
  }
  
  public final void e()
  {
    this.o = 12;
  }
  
  public int f()
  {
    if (d()) {
      return 2131755758;
    }
    return 2131755747;
  }
  
  public final void g()
  {
    int i1 = Math.max(Math.min(this.k.getHeight(), this.l), 0);
    ab.e(this.k, i1 - this.k.getTop());
    this.l = this.k.getTop();
  }
  
  public final void h()
  {
    if (!d()) {
      return;
    }
    if (this.k.getVisibility() != 0) {
      this.k.setVisibility(0);
    }
    Animation localAnimation = this.k.getAnimation();
    if ((localAnimation instanceof a)) {
      localAnimation.cancel();
    }
    this.l = 0;
    g();
  }
  
  public final class a
    extends Animation
  {
    private final int b;
    private final int c;
    
    public a(int paramInt)
    {
      this.c = paramInt;
      this.b = os.this.l;
      setDuration(Math.abs(this.b - paramInt) * 300 / os.this.k.getHeight());
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      os.this.l = ((int)(this.b + (this.c - this.b) * paramFloat));
      os.this.g();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/os.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */