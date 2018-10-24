package com.whatsapp.wallpaper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.b;
import android.support.v7.app.a;
import android.support.v7.app.c;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Button;
import com.whatsapp.aus;
import com.whatsapp.protocol.j;
import com.whatsapp.util.az;
import com.whatsapp.va;

public class SolidColorWallpaperPreview
  extends c
{
  private final aus A = aus.a();
  int[] n;
  MarginCorrectedViewPager o;
  private View p;
  private View q;
  private View r;
  private View s;
  private boolean t = false;
  private boolean u = false;
  private int v;
  private int w;
  private float x;
  private float y;
  private final va z = va.a();
  
  @TargetApi(12)
  final void c(int paramInt)
  {
    DecelerateInterpolator localDecelerateInterpolator;
    int i;
    if (this.u)
    {
      this.t = true;
      this.o.setScrollEnabled(false);
      localDecelerateInterpolator = new DecelerateInterpolator();
      if (paramInt == getIntent().getIntExtra("scw_preview_color", -1)) {
        break label211;
      }
      this.v = 0;
      this.w = 0;
      i = this.o.getWidth() / 2;
      paramInt = this.o.getWidth() / 2;
    }
    for (;;)
    {
      this.o.setPivotX(i);
      this.o.setPivotY(paramInt);
      this.p.setBackgroundColor(0);
      this.o.animate().setDuration(250L).alpha(0.0F).scaleX(this.x).scaleY(this.y).translationX(this.v).translationY(this.w).setInterpolator(localDecelerateInterpolator).setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          super.onAnimationCancel(paramAnonymousAnimator);
          SolidColorWallpaperPreview.this.finish();
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          super.onAnimationEnd(paramAnonymousAnimator);
          SolidColorWallpaperPreview.this.finish();
        }
      });
      this.q.animate().setDuration(250L).alpha(0.0F).setInterpolator(localDecelerateInterpolator);
      this.s.animate().setDuration(250L).alpha(0.0F).setInterpolator(localDecelerateInterpolator);
      return;
      finish();
      return;
      label211:
      paramInt = 0;
      i = 0;
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((this.u) && (this.t)) {
      overridePendingTransition(0, 0);
    }
  }
  
  public void onBackPressed()
  {
    setResult(0, null);
    c(this.o.getCurrentItem());
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.A.e();
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.A.e();
    super.onCreate(paramBundle);
    setContentView(2130903406);
    this.p = findViewById(2131756255);
    this.q = findViewById(2131755784);
    a((Toolbar)findViewById(2131755412));
    paramBundle = i();
    paramBundle.a(true);
    paramBundle.b(new az(b.a(this, 2130840097)));
    if (Build.VERSION.SDK_INT >= 21) {
      findViewById(2131755785).setVisibility(8);
    }
    this.r = findViewById(2131756256);
    this.n = getResources().getIntArray(2131689499);
    this.o = ((MarginCorrectedViewPager)findViewById(2131756257));
    paramBundle = new a(this);
    this.o.setAdapter(paramBundle);
    this.o.setPageMargin((int)(15.0F * getResources().getDisplayMetrics().density));
    this.s = findViewById(2131755788);
    ((Button)findViewById(2131755789)).setOnClickListener(e.a(this));
    ((Button)findViewById(2131755790)).setOnClickListener(f.a(this));
    final int i = getIntent().getIntExtra("scw_preview_color", 0);
    this.o.setCurrentItem(i);
    this.t = false;
    if ((Build.VERSION.SDK_INT >= 12) && (getIntent().getBooleanExtra("wallpaper_preview_intent_extra_animate", false))) {}
    for (boolean bool = true;; bool = false)
    {
      this.u = bool;
      if (!this.u) {
        break;
      }
      overridePendingTransition(0, 0);
      paramBundle = getIntent();
      this.t = true;
      this.o.setScrollEnabled(false);
      i = paramBundle.getIntExtra("wallpaper_preview_intent_extra_x", 0);
      final int j = paramBundle.getIntExtra("wallpaper_preview_intent_extra_y", 0);
      final int k = paramBundle.getIntExtra("wallpaper_preview_intent_extra_width", 0);
      final int m = paramBundle.getIntExtra("wallpaper_preview_intent_extra_height", 0);
      this.r.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          SolidColorWallpaperPreview.c(SolidColorWallpaperPreview.this).getViewTreeObserver().removeOnPreDrawListener(this);
          final View localView = SolidColorWallpaperPreview.this.findViewById(2131755098);
          final Object localObject = new int[2];
          SolidColorWallpaperPreview.d(SolidColorWallpaperPreview.this).getLocationOnScreen((int[])localObject);
          SolidColorWallpaperPreview.a(SolidColorWallpaperPreview.this, i - localObject[0]);
          SolidColorWallpaperPreview.b(SolidColorWallpaperPreview.this, j - localObject[1]);
          SolidColorWallpaperPreview.a(SolidColorWallpaperPreview.this, k / SolidColorWallpaperPreview.d(SolidColorWallpaperPreview.this).getWidth());
          SolidColorWallpaperPreview.b(SolidColorWallpaperPreview.this, m / SolidColorWallpaperPreview.d(SolidColorWallpaperPreview.this).getHeight());
          int i = (int)(20.0F * SolidColorWallpaperPreview.this.getResources().getDisplayMetrics().density);
          SolidColorWallpaperPreview.d(SolidColorWallpaperPreview.this).setPivotX(0.0F);
          SolidColorWallpaperPreview.d(SolidColorWallpaperPreview.this).setPivotY(0.0F);
          SolidColorWallpaperPreview.d(SolidColorWallpaperPreview.this).setScaleX(SolidColorWallpaperPreview.e(SolidColorWallpaperPreview.this));
          SolidColorWallpaperPreview.d(SolidColorWallpaperPreview.this).setScaleY(SolidColorWallpaperPreview.f(SolidColorWallpaperPreview.this));
          SolidColorWallpaperPreview.d(SolidColorWallpaperPreview.this).setTranslationX(SolidColorWallpaperPreview.g(SolidColorWallpaperPreview.this));
          SolidColorWallpaperPreview.d(SolidColorWallpaperPreview.this).setTranslationY(SolidColorWallpaperPreview.h(SolidColorWallpaperPreview.this));
          SolidColorWallpaperPreview.i(SolidColorWallpaperPreview.this).setAlpha(0.0F);
          SolidColorWallpaperPreview.j(SolidColorWallpaperPreview.this).setAlpha(0.0F);
          localView.setAlpha(0.0F);
          localView.setTranslationY(i);
          localObject = new DecelerateInterpolator();
          SolidColorWallpaperPreview.k(SolidColorWallpaperPreview.this).setBackgroundColor(0);
          SolidColorWallpaperPreview.i(SolidColorWallpaperPreview.this).animate().setDuration(250L).alpha(1.0F).setInterpolator((TimeInterpolator)localObject);
          SolidColorWallpaperPreview.d(SolidColorWallpaperPreview.this).animate().setDuration(250L).scaleX(1.0F).scaleY(1.0F).translationX(0.0F).translationY(0.0F).setInterpolator((TimeInterpolator)localObject).setListener(new AnimatorListenerAdapter()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator)
            {
              super.onAnimationCancel(paramAnonymous2Animator);
              SolidColorWallpaperPreview.k(SolidColorWallpaperPreview.this).setBackgroundColor(SolidColorWallpaperPreview.this.getResources().getColor(2131624135));
              SolidColorWallpaperPreview.l(SolidColorWallpaperPreview.this);
              SolidColorWallpaperPreview.d(SolidColorWallpaperPreview.this).setScrollEnabled(true);
            }
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              super.onAnimationEnd(paramAnonymous2Animator);
              SolidColorWallpaperPreview.k(SolidColorWallpaperPreview.this).setBackgroundColor(SolidColorWallpaperPreview.this.getResources().getColor(2131624135));
              SolidColorWallpaperPreview.j(SolidColorWallpaperPreview.this).animate().setDuration(250L).alpha(1.0F).setInterpolator(localObject);
              localView.animate().setDuration(250L).alpha(1.0F).translationY(0.0F).setInterpolator(localObject).setListener(new AnimatorListenerAdapter()
              {
                public final void onAnimationCancel(Animator paramAnonymous3Animator)
                {
                  super.onAnimationCancel(paramAnonymous3Animator);
                  SolidColorWallpaperPreview.l(SolidColorWallpaperPreview.this);
                  SolidColorWallpaperPreview.d(SolidColorWallpaperPreview.this).setScrollEnabled(true);
                }
                
                public final void onAnimationEnd(Animator paramAnonymous3Animator)
                {
                  super.onAnimationEnd(paramAnonymous3Animator);
                  SolidColorWallpaperPreview.l(SolidColorWallpaperPreview.this);
                  SolidColorWallpaperPreview.d(SolidColorWallpaperPreview.this).setScrollEnabled(true);
                }
              });
            }
          });
          return true;
        }
      });
      return;
    }
    this.p.setBackgroundColor(getResources().getColor(2131624135));
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    setResult(0, null);
    c(this.o.getCurrentItem());
    return true;
  }
  
  final class a
    extends q
  {
    public a(Context paramContext)
    {
      super(SolidColorWallpaperPreview.a(SolidColorWallpaperPreview.this));
    }
    
    public final void a(j paramj1, j paramj2, int paramInt)
    {
      int j = 2131298185;
      Resources localResources = SolidColorWallpaperPreview.this.getResources();
      int i;
      if (paramInt == b() - 1)
      {
        i = 2131298186;
        paramj1.e(localResources.getString(i));
        paramj1 = SolidColorWallpaperPreview.this.getResources();
        if (paramInt != 0) {
          break label70;
        }
      }
      label70:
      for (paramInt = j;; paramInt = 2131298186)
      {
        paramj2.e(paramj1.getString(paramInt));
        return;
        i = 2131298185;
        break;
      }
    }
    
    public final void a(h paramh1, h paramh2, int paramInt)
    {
      paramh1.setVisibility(8);
      paramh2.setImageDrawable(null);
      paramh2.setBackgroundColor(SolidColorWallpaperPreview.b(SolidColorWallpaperPreview.this)[paramInt]);
    }
    
    public final boolean a(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public final int b()
    {
      return SolidColorWallpaperPreview.b(SolidColorWallpaperPreview.this).length;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/wallpaper/SolidColorWallpaperPreview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */