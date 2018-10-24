package com.whatsapp.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewAnimationUtils;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnDrawListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;

public class FloatingChildLayout
  extends FrameLayout
{
  public static boolean c;
  public View a;
  public int b;
  public int d = 0;
  public ValueAnimator e = null;
  public int f = 0;
  private int g;
  private Rect h = new Rect();
  private boolean i;
  private View.OnTouchListener j;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 12) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      return;
    }
  }
  
  public FloatingChildLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    this.g = paramContext.getDimensionPixelOffset(2131362076);
    this.b = paramContext.getInteger(17694720);
    if (c)
    {
      this.e = ValueAnimator.ofInt(new int[] { 0, 127 });
      this.e.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          FloatingChildLayout.this.setBackgroundColorAlpha(i);
        }
      });
    }
    super.setBackgroundDrawable(new ColorDrawable(0));
  }
  
  private static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 > paramInt3) {
      return (paramInt3 - paramInt2) / 2;
    }
    return Math.min(Math.max(paramInt1, 0), paramInt3 - paramInt2);
  }
  
  private static void a(View paramView, int paramInt1, int paramInt2)
  {
    paramView.layout(paramInt1, paramInt2, paramView.getMeasuredWidth() + paramInt1, paramView.getMeasuredHeight() + paramInt2);
  }
  
  public static void a(View paramView, final Runnable paramRunnable)
  {
    paramRunnable = new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        paramRunnable.run();
      }
    };
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(paramRunnable);
  }
  
  public static void b(View paramView, final Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramRunnable = new ViewTreeObserver.OnDrawListener()
      {
        public final void onDraw()
        {
          this.a.getViewTreeObserver().removeOnDrawListener(this);
          paramRunnable.run();
        }
      };
      paramView.getViewTreeObserver().addOnDrawListener(paramRunnable);
      return;
    }
    paramRunnable = new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        paramRunnable.run();
        return true;
      }
    };
    paramView.getViewTreeObserver().addOnPreDrawListener(paramRunnable);
  }
  
  private Rect getTargetInWindow()
  {
    Rect localRect1 = new Rect();
    getWindowVisibleDisplayFrame(localRect1);
    Rect localRect2 = new Rect(this.h);
    localRect2.offset(-localRect1.left, -localRect1.top);
    return localRect2;
  }
  
  public final void a(final boolean paramBoolean, final Runnable paramRunnable)
  {
    float f3 = 1.0F;
    float f1;
    float f2;
    label32:
    int k;
    label46:
    int m;
    int n;
    int i1;
    if (paramBoolean)
    {
      f1 = this.h.width() / this.a.getWidth();
      if (!paramBoolean) {
        break label346;
      }
      f2 = 1.0F;
      if (!c) {
        break label376;
      }
      if (!paramBoolean) {
        break label368;
      }
      k = 17563652;
      if ((this.i) && (Build.VERSION.SDK_INT >= 21))
      {
        m = (int)Math.sqrt(this.a.getWidth() * this.a.getWidth() + this.a.getHeight() * this.a.getHeight());
        n = (int)Math.sqrt(this.h.width() * this.h.width() + this.h.height() * this.h.height());
        if (!paramBoolean) {
          break label498;
        }
        i1 = n;
        n = m;
      }
    }
    for (;;)
    {
      Object localObject = ViewAnimationUtils.createCircularReveal(this.a, this.a.getWidth() / 2, this.a.getHeight() / 2, n, i1);
      ((Animator)localObject).setDuration(this.b);
      ((Animator)localObject).start();
      if (!paramBoolean)
      {
        this.a.setScaleX(f2);
        this.a.setScaleY(f2);
        this.a.setAlpha(0.0F);
      }
      this.a.setPivotX(this.h.left - this.a.getLeft());
      this.a.setPivotY(this.h.top - this.a.getTop());
      localObject = this.a.animate().setDuration(this.b).setInterpolator(AnimationUtils.loadInterpolator(getContext(), k)).scaleX(f1).scaleY(f1);
      f1 = f3;
      if (paramBoolean) {
        f1 = 0.0F;
      }
      ((ViewPropertyAnimator)localObject).alpha(f1).setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          FloatingChildLayout.c(FloatingChildLayout.this).setLayerType(0, null);
          if (paramBoolean) {
            if (FloatingChildLayout.d(FloatingChildLayout.this) == 3)
            {
              FloatingChildLayout.a(FloatingChildLayout.this, 4);
              if (paramRunnable != null) {
                paramRunnable.run();
              }
            }
          }
          do
          {
            do
            {
              return;
            } while (FloatingChildLayout.d(FloatingChildLayout.this) != 1);
            FloatingChildLayout.a(FloatingChildLayout.this, 2);
          } while (paramRunnable == null);
          paramRunnable.run();
        }
      });
      return;
      f1 = 1.0F;
      break;
      label346:
      f2 = this.h.width() / this.a.getWidth();
      break label32;
      label368:
      k = 17563653;
      break label46;
      label376:
      ScaleAnimation localScaleAnimation = new ScaleAnimation(f2, f1, f2, f1, 0, this.h.centerX() - this.a.getLeft(), 0, this.h.centerY() - this.a.getTop());
      localScaleAnimation.setDuration(this.b);
      localScaleAnimation.setFillAfter(true);
      if (paramBoolean) {}
      for (localObject = new AccelerateInterpolator();; localObject = new DecelerateInterpolator())
      {
        localScaleAnimation.setInterpolator((Interpolator)localObject);
        localScaleAnimation.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            if (paramBoolean) {
              if (FloatingChildLayout.d(FloatingChildLayout.this) == 3)
              {
                FloatingChildLayout.a(FloatingChildLayout.this, 4);
                if (paramRunnable != null) {
                  paramRunnable.run();
                }
              }
            }
            do
            {
              do
              {
                return;
              } while (FloatingChildLayout.d(FloatingChildLayout.this) != 1);
              FloatingChildLayout.a(FloatingChildLayout.this, 2);
            } while (paramRunnable == null);
            paramRunnable.run();
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        this.a.startAnimation(localScaleAnimation);
        return;
      }
      label498:
      i1 = m;
    }
  }
  
  public View getChild()
  {
    return this.a;
  }
  
  protected void onFinishInflate()
  {
    this.a = findViewById(16908290);
    this.a.setDuplicateParentStateEnabled(true);
    if (c)
    {
      this.a.setScaleX(0.5F);
      this.a.setScaleY(0.5F);
      this.a.setAlpha(0.0F);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = this.a;
    Rect localRect = getTargetInWindow();
    paramInt1 = localView.getMeasuredWidth();
    paramInt2 = localView.getMeasuredHeight();
    if (this.g != -1)
    {
      paramInt3 = (getWidth() - paramInt1) / 2;
      paramInt4 = this.g;
      a(localView, a(paramInt3, paramInt1, getWidth()), a(paramInt4, paramInt2, getHeight()));
      return;
    }
    paramInt3 = localRect.centerX();
    paramInt4 = paramInt1 / 2;
    int k = localRect.centerY();
    int m = Math.round(paramInt2 * 0.75F);
    a(localView, a(paramInt3 - paramInt4, paramInt1, getWidth()), a(k - m, paramInt2, getHeight()));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.j != null) {
      return this.j.onTouch(this, paramMotionEvent);
    }
    return false;
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    Log.e("don't setBackground(), it is managed internally");
  }
  
  public void setBackgroundColorAlpha(int paramInt)
  {
    setBackgroundColor(paramInt << 24);
  }
  
  public void setChildTargetScreen(Rect paramRect)
  {
    this.h = paramRect;
    requestLayout();
  }
  
  public void setCircularReveal(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if (Build.VERSION.SDK_INT >= 21) {
      this.b = getResources().getInteger(17694721);
    }
  }
  
  public void setOnOutsideTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.j = paramOnTouchListener;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/FloatingChildLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */