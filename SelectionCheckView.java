package com.whatsapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.content.b;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class SelectionCheckView
  extends FrameLayout
{
  private boolean a = false;
  private ScaleAnimation b;
  private ScaleAnimation c;
  private ScaleAnimation d;
  private ScaleAnimation e;
  private ScaleAnimation f;
  private ScaleAnimation g;
  private AnimationSet h;
  private AnimationSet i;
  private FrameLayout j;
  private View k;
  private ImageView l;
  private ShapeDrawable m;
  
  public SelectionCheckView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SelectionCheckView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    a(paramContext, paramAttributeSet);
  }
  
  public SelectionCheckView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  @TargetApi(21)
  public SelectionCheckView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext, paramAttributeSet);
  }
  
  private ScaleAnimation a(final View paramView)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(100L);
    localScaleAnimation.setInterpolator(new DecelerateInterpolator());
    localScaleAnimation.setRepeatCount(0);
    localScaleAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        paramView.setVisibility(0);
      }
    });
    return localScaleAnimation;
  }
  
  private void a()
  {
    this.b = a(this.j);
    this.b.setStartOffset(20L);
    this.d = a(this.k);
    this.f = a(this.l);
    this.f.setStartOffset(10L);
    this.h = new AnimationSet(false);
    this.h.addAnimation(this.b);
    this.h.addAnimation(this.d);
    this.h.addAnimation(this.f);
    this.c = b(this.j);
    this.e = b(this.k);
    this.e.setStartOffset(20L);
    this.g = b(this.l);
    this.g.setStartOffset(10L);
    this.i = new AnimationSet(false);
    this.i.addAnimation(this.c);
    this.i.addAnimation(this.e);
    this.i.addAnimation(this.g);
    this.a = true;
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i3 = 2130840139;
    this.a = false;
    int n = b.c(getContext(), 2131624115);
    int i1 = b.c(getContext(), 2131624041);
    int i2 = getResources().getDimensionPixelSize(2131362084);
    Object localObject;
    if (paramAttributeSet != null)
    {
      localObject = paramContext.obtainStyledAttributes(paramAttributeSet, adn.SelectionCheckView);
      i3 = ((TypedArray)localObject).getResourceId(3, 2130840139);
      paramAttributeSet = ((TypedArray)localObject).getString(4);
      n = ((TypedArray)localObject).getColor(0, n);
      i1 = ((TypedArray)localObject).getColor(2, i1);
      i2 = ((TypedArray)localObject).getDimensionPixelSize(1, i2);
      ((TypedArray)localObject).recycle();
    }
    for (;;)
    {
      localObject = paramAttributeSet;
      if (paramAttributeSet == null) {
        localObject = paramContext.getString(2131296429);
      }
      paramContext = new FrameLayout.LayoutParams(-1, -1);
      paramAttributeSet = new ShapeDrawable(new OvalShape());
      paramAttributeSet.getPaint().setColor(b.c(getContext(), 2131624135));
      this.m = new ShapeDrawable(new OvalShape());
      this.m.getPaint().setColor(i1);
      this.j = new FrameLayout(getContext());
      this.j.setLayoutParams(paramContext);
      this.j.setBackgroundDrawable(paramAttributeSet);
      this.j.setForeground(this.m);
      this.j.setVisibility(4);
      addView(this.j);
      paramAttributeSet = new ShapeDrawable(new OvalShape());
      paramAttributeSet.getPaint().setColor(n);
      this.k = new ImageView(getContext());
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
      localLayoutParams.setMargins(i2, i2, i2, i2);
      this.k.setLayoutParams(localLayoutParams);
      this.k.setBackgroundDrawable(paramAttributeSet);
      this.k.setVisibility(4);
      addView(this.k);
      this.l = new ImageView(getContext());
      this.l.setLayoutParams(paramContext);
      this.l.setImageDrawable(b.a(getContext(), i3));
      this.l.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      this.l.setVisibility(4);
      this.l.setContentDescription((CharSequence)localObject);
      addView(this.l);
      return;
      paramAttributeSet = null;
    }
  }
  
  private ScaleAnimation b(final View paramView)
  {
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(100L);
    localScaleAnimation.setInterpolator(new AccelerateInterpolator());
    localScaleAnimation.setRepeatCount(0);
    localScaleAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        paramView.setVisibility(4);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    return localScaleAnimation;
  }
  
  private void b()
  {
    this.j.clearAnimation();
    this.k.clearAnimation();
    this.l.clearAnimation();
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        if (!this.a) {
          a();
        }
        setVisibility(0);
        b();
        this.j.setAnimation(this.b);
        this.k.setAnimation(this.d);
        this.l.setAnimation(this.f);
        this.j.setForeground(this.m);
        this.h.start();
        return;
      }
      this.j.setVisibility(0);
      this.k.setVisibility(0);
      this.l.setVisibility(0);
      return;
    }
    if (paramBoolean2)
    {
      if (!this.a) {
        a();
      }
      b();
      this.j.setAnimation(this.c);
      this.k.setAnimation(this.e);
      this.l.setAnimation(this.g);
      this.j.setForeground(null);
      this.i.start();
      return;
    }
    this.j.setVisibility(4);
    this.k.setVisibility(4);
    this.l.setVisibility(4);
  }
  
  public void setIcon(int paramInt)
  {
    this.l.setImageDrawable(b.a(getContext(), paramInt));
  }
  
  public void setSelectionBackground(int paramInt)
  {
    this.k.setBackgroundResource(paramInt);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/SelectionCheckView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */