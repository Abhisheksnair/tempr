package com.whatsapp.wallpaper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.b;
import android.support.v7.app.a;
import android.support.v7.app.c;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Button;
import com.whatsapp.aus;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;
import com.whatsapp.util.az;
import com.whatsapp.va;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WallpaperPreview
  extends c
{
  private float A;
  private final va B = va.a();
  private final aus C = aus.a();
  ArrayList<Integer> n;
  MarginCorrectedViewPager o;
  private ArrayList<Integer> p;
  private View q;
  private View r;
  private View s;
  private View t;
  private Resources u = null;
  private final Map<Integer, a> v = new HashMap();
  private boolean w;
  private int x;
  private int y;
  private float z;
  
  private void c(boolean paramBoolean)
  {
    this.w = paramBoolean;
    MarginCorrectedViewPager localMarginCorrectedViewPager = this.o;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localMarginCorrectedViewPager.setScrollEnabled(paramBoolean);
      return;
    }
  }
  
  @TargetApi(12)
  final void c(int paramInt)
  {
    if (Build.VERSION.SDK_INT < 12)
    {
      finish();
      return;
    }
    c(true);
    View localView = this.o.findViewWithTag("chatlayout-" + paramInt);
    final DecelerateInterpolator localDecelerateInterpolator = new DecelerateInterpolator();
    int i;
    if (paramInt != getIntent().getIntExtra("wallpaper_preview_intent_starting_pos", -1))
    {
      this.x = 0;
      this.y = 0;
      i = this.o.getWidth() / 2;
      paramInt = this.o.getWidth() / 2;
    }
    for (;;)
    {
      this.o.setPivotX(i);
      this.o.setPivotY(paramInt);
      paramInt = (int)(20.0F * getResources().getDisplayMetrics().density);
      this.q.setBackgroundColor(0);
      if (localView != null) {
        localView.animate().setDuration(250L).alpha(0.0F).translationY(paramInt).setInterpolator(localDecelerateInterpolator);
      }
      this.t.animate().setDuration(250L).alpha(0.0F).setInterpolator(localDecelerateInterpolator).setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          super.onAnimationCancel(paramAnonymousAnimator);
          WallpaperPreview.j(WallpaperPreview.this).animate().setDuration(250L).alpha(0.0F).setInterpolator(localDecelerateInterpolator);
          WallpaperPreview.e(WallpaperPreview.this).animate().setDuration(250L).alpha(0.0F).scaleX(WallpaperPreview.f(WallpaperPreview.this)).scaleY(WallpaperPreview.g(WallpaperPreview.this)).translationX(WallpaperPreview.h(WallpaperPreview.this)).translationY(WallpaperPreview.i(WallpaperPreview.this)).setInterpolator(localDecelerateInterpolator).setListener(new AnimatorListenerAdapter()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator)
            {
              super.onAnimationCancel(paramAnonymous2Animator);
              WallpaperPreview.this.finish();
            }
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              super.onAnimationEnd(paramAnonymous2Animator);
              WallpaperPreview.this.finish();
            }
          });
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          super.onAnimationEnd(paramAnonymousAnimator);
          WallpaperPreview.j(WallpaperPreview.this).animate().setDuration(250L).alpha(0.0F).setInterpolator(localDecelerateInterpolator);
          WallpaperPreview.e(WallpaperPreview.this).animate().setDuration(250L).alpha(0.0F).scaleX(WallpaperPreview.f(WallpaperPreview.this)).scaleY(WallpaperPreview.g(WallpaperPreview.this)).translationX(WallpaperPreview.h(WallpaperPreview.this)).translationY(WallpaperPreview.i(WallpaperPreview.this)).setInterpolator(localDecelerateInterpolator).setListener(new AnimatorListenerAdapter()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator)
            {
              super.onAnimationCancel(paramAnonymous2Animator);
              WallpaperPreview.this.finish();
            }
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              super.onAnimationEnd(paramAnonymous2Animator);
              WallpaperPreview.this.finish();
            }
          });
        }
      });
      return;
      paramInt = 0;
      i = 0;
    }
  }
  
  public void finish()
  {
    super.finish();
    if ((Build.VERSION.SDK_INT >= 12) && (this.w)) {
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
    this.C.e();
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.C.e();
    super.onCreate(paramBundle);
    setContentView(2130903406);
    this.q = findViewById(2131756255);
    this.r = findViewById(2131755784);
    a((Toolbar)findViewById(2131755412));
    paramBundle = i();
    paramBundle.a(true);
    paramBundle.b(new az(b.a(this, 2130840097)));
    if (Build.VERSION.SDK_INT >= 21) {
      findViewById(2131755785).setVisibility(8);
    }
    this.s = findViewById(2131756256);
    this.n = getIntent().getIntegerArrayListExtra("wallpaper_preview_intent_image_res_ids");
    this.p = getIntent().getIntegerArrayListExtra("wallpaper_preview_intent_thumb_res_ids");
    this.o = ((MarginCorrectedViewPager)findViewById(2131756257));
    paramBundle = new b(this);
    this.o.setAdapter(paramBundle);
    this.o.setPageMargin((int)(15.0F * getResources().getDisplayMetrics().density));
    this.t = findViewById(2131755788);
    ((Button)findViewById(2131755789)).setOnClickListener(o.a(this));
    ((Button)findViewById(2131755790)).setOnClickListener(p.a(this));
    final int i = getIntent().getIntExtra("wallpaper_preview_intent_starting_pos", 0);
    this.o.setCurrentItem(i);
    try
    {
      this.u = getPackageManager().getResourcesForApplication("com.whatsapp.wallpaper");
      this.w = false;
      if (Build.VERSION.SDK_INT >= 12)
      {
        overridePendingTransition(0, 0);
        paramBundle = getIntent();
        c(true);
        i = paramBundle.getIntExtra("wallpaper_preview_intent_extra_x", 0);
        final int j = paramBundle.getIntExtra("wallpaper_preview_intent_extra_y", 0);
        final int k = paramBundle.getIntExtra("wallpaper_preview_intent_extra_width", 0);
        final int m = paramBundle.getIntExtra("wallpaper_preview_intent_extra_height", 0);
        this.s.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            WallpaperPreview.d(WallpaperPreview.this).getViewTreeObserver().removeOnPreDrawListener(this);
            final View localView = WallpaperPreview.this.findViewById(2131755098);
            final Object localObject = new int[2];
            WallpaperPreview.e(WallpaperPreview.this).getLocationOnScreen((int[])localObject);
            WallpaperPreview.a(WallpaperPreview.this, i - localObject[0]);
            WallpaperPreview.b(WallpaperPreview.this, j - localObject[1]);
            WallpaperPreview.a(WallpaperPreview.this, k / WallpaperPreview.e(WallpaperPreview.this).getWidth());
            WallpaperPreview.b(WallpaperPreview.this, m / WallpaperPreview.e(WallpaperPreview.this).getHeight());
            int i = (int)(20.0F * WallpaperPreview.this.getResources().getDisplayMetrics().density);
            WallpaperPreview.e(WallpaperPreview.this).setPivotX(0.0F);
            WallpaperPreview.e(WallpaperPreview.this).setPivotY(0.0F);
            WallpaperPreview.e(WallpaperPreview.this).setScaleX(WallpaperPreview.f(WallpaperPreview.this));
            WallpaperPreview.e(WallpaperPreview.this).setScaleY(WallpaperPreview.g(WallpaperPreview.this));
            WallpaperPreview.e(WallpaperPreview.this).setTranslationX(WallpaperPreview.h(WallpaperPreview.this));
            WallpaperPreview.e(WallpaperPreview.this).setTranslationY(WallpaperPreview.i(WallpaperPreview.this));
            WallpaperPreview.j(WallpaperPreview.this).setAlpha(0.0F);
            WallpaperPreview.k(WallpaperPreview.this).setAlpha(0.0F);
            if (localView != null)
            {
              localView.setAlpha(0.0F);
              localView.setTranslationY(i);
            }
            localObject = new DecelerateInterpolator();
            WallpaperPreview.l(WallpaperPreview.this).setBackgroundColor(0);
            WallpaperPreview.j(WallpaperPreview.this).animate().setDuration(250L).alpha(1.0F).setInterpolator((TimeInterpolator)localObject);
            WallpaperPreview.e(WallpaperPreview.this).animate().setDuration(250L).scaleX(1.0F).scaleY(1.0F).translationX(0.0F).translationY(0.0F).setInterpolator((TimeInterpolator)localObject).setListener(new AnimatorListenerAdapter()
            {
              public final void onAnimationCancel(Animator paramAnonymous2Animator)
              {
                super.onAnimationCancel(paramAnonymous2Animator);
                WallpaperPreview.l(WallpaperPreview.this).setBackgroundColor(WallpaperPreview.this.getResources().getColor(2131624135));
                WallpaperPreview.m(WallpaperPreview.this);
              }
              
              public final void onAnimationEnd(Animator paramAnonymous2Animator)
              {
                super.onAnimationEnd(paramAnonymous2Animator);
                WallpaperPreview.l(WallpaperPreview.this).setBackgroundColor(WallpaperPreview.this.getResources().getColor(2131624135));
                if (localView != null) {
                  localView.animate().setDuration(250L).alpha(1.0F).translationY(0.0F).setInterpolator(localObject);
                }
                WallpaperPreview.k(WallpaperPreview.this).animate().setDuration(250L).alpha(1.0F).setInterpolator(localObject).setListener(new AnimatorListenerAdapter()
                {
                  public final void onAnimationCancel(Animator paramAnonymous3Animator)
                  {
                    super.onAnimationCancel(paramAnonymous3Animator);
                    WallpaperPreview.m(WallpaperPreview.this);
                  }
                  
                  public final void onAnimationEnd(Animator paramAnonymous3Animator)
                  {
                    super.onAnimationEnd(paramAnonymous3Animator);
                    WallpaperPreview.m(WallpaperPreview.this);
                  }
                });
              }
            });
            return true;
          }
        });
        return;
      }
    }
    catch (PackageManager.NameNotFoundException paramBundle)
    {
      for (;;)
      {
        Log.d("wallpaperpreview/com.whatsapp.wallpaper could not be found.", paramBundle);
      }
      this.q.setBackgroundColor(getResources().getColor(2131624135));
    }
  }
  
  protected void onDestroy()
  {
    Iterator localIterator = this.v.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((a)((Map.Entry)localIterator.next()).getValue()).cancel(true);
    }
    super.onDestroy();
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
    extends AsyncTask<Void, Void, Bitmap>
  {
    h a;
    h b;
    int c;
    
    public a(h paramh1, h paramh2, int paramInt)
    {
      this.a = paramh1;
      this.b = paramh2;
      this.c = paramInt;
    }
    
    private Bitmap a()
    {
      try
      {
        Object localObject = g.f(WallpaperPreview.this);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inScaled = false;
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(WallpaperPreview.o(WallpaperPreview.this), ((Integer)WallpaperPreview.c(WallpaperPreview.this).get(this.c)).intValue(), localOptions);
        g.a(localOptions, ((Point)localObject).x);
        localObject = BitmapFactory.decodeResource(WallpaperPreview.o(WallpaperPreview.this), ((Integer)WallpaperPreview.c(WallpaperPreview.this).get(this.c)).intValue(), localOptions);
        return (Bitmap)localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Log.d("wallpaperpreview/oom when loading wallpaper resource", localOutOfMemoryError);
      }
      return null;
    }
    
    protected final void onPreExecute()
    {
      this.a.setImageDrawable(WallpaperPreview.o(WallpaperPreview.this).getDrawable(((Integer)WallpaperPreview.n(WallpaperPreview.this).get(this.c)).intValue()));
      this.a.setVisibility(0);
    }
  }
  
  final class b
    extends q
  {
    public b(Context paramContext)
    {
      super(WallpaperPreview.a(WallpaperPreview.this));
    }
    
    public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      super.a(paramViewGroup, paramInt, paramObject);
      paramViewGroup = (WallpaperPreview.a)WallpaperPreview.b(WallpaperPreview.this).remove(Integer.valueOf(paramInt));
      if (paramViewGroup != null) {
        paramViewGroup.cancel(true);
      }
    }
    
    public final void a(j paramj1, j paramj2, int paramInt)
    {
      int j = 2131297084;
      Resources localResources = WallpaperPreview.this.getResources();
      int i;
      if (paramInt == b() - 1)
      {
        i = 2131297085;
        paramj1.e(localResources.getString(i));
        paramj1 = WallpaperPreview.this.getResources();
        if (paramInt != 0) {
          break label70;
        }
      }
      label70:
      for (paramInt = j;; paramInt = 2131297085)
      {
        paramj2.e(paramj1.getString(paramInt));
        return;
        i = 2131297084;
        break;
      }
    }
    
    public final void a(h paramh1, h paramh2, int paramInt)
    {
      paramh1 = new WallpaperPreview.a(WallpaperPreview.this, paramh1, paramh2, paramInt);
      paramh2 = (WallpaperPreview.a)WallpaperPreview.b(WallpaperPreview.this).put(Integer.valueOf(paramInt), paramh1);
      if (paramh2 != null) {
        paramh2.cancel(true);
      }
      paramh1.execute(new Void[0]);
    }
    
    public final boolean a(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public final int b()
    {
      if (WallpaperPreview.c(WallpaperPreview.this) == null) {
        return 0;
      }
      return WallpaperPreview.c(WallpaperPreview.this).size();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/wallpaper/WallpaperPreview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */