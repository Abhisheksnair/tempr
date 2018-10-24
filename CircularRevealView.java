package com.whatsapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;

public class CircularRevealView
  extends FrameLayout
{
  int a = 300;
  int b;
  int c;
  a d;
  private int e = -1;
  private Paint f = new Paint(1);
  private Path g = new Path();
  private RectF h = new RectF();
  private float i;
  
  public CircularRevealView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CircularRevealView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CircularRevealView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public CircularRevealView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public final void a()
  {
    if (Build.VERSION.SDK_INT < 21)
    {
      clearAnimation();
      this.d = new a(true);
      this.d.setDuration(this.a);
      startAnimation(this.d);
      return;
    }
    int j = Math.max(getWidth(), getHeight());
    Animator localAnimator = ViewAnimationUtils.createCircularReveal(this, this.b, this.c, j, 0.0F);
    localAnimator.setDuration(this.a);
    localAnimator.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        super.onAnimationEnd(paramAnonymousAnimator);
        CircularRevealView.this.setVisibility(4);
      }
    });
    localAnimator.start();
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public final void a(Animation paramAnimation)
  {
    clearAnimation();
    setBackgroundColor(0);
    paramAnimation.setDuration(this.a);
    startAnimation(paramAnimation);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (Build.VERSION.SDK_INT < 21) {
      clearAnimation();
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((Build.VERSION.SDK_INT < 21) && (this.e != -1))
    {
      f1 = (float)(Math.sqrt(getWidth() * getWidth() + getHeight() * getHeight()) * this.i);
      this.h.set(-f1, -f1, f1, f1);
      this.h.offset(this.b, this.c);
      this.f.setColor(this.e);
      this.f.setStyle(Paint.Style.FILL);
      paramCanvas.drawArc(this.h, 0.0F, 360.0F, true, this.f);
    }
    while ((Build.VERSION.SDK_INT >= 21) || (Build.VERSION.SDK_INT < 18)) {
      return;
    }
    float f1 = (float)(Math.sqrt(getWidth() * getWidth() + getHeight() * getHeight()) * this.i);
    this.h.set(-f1, -f1, f1, f1);
    this.h.offset(this.b, this.c);
    this.f.setColor(this.e);
    this.f.setStyle(Paint.Style.FILL);
    this.g.reset();
    this.g.addArc(this.h, 0.0F, 360.0F);
    paramCanvas.clipPath(this.g);
  }
  
  public void setColor(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setDuration(int paramInt)
  {
    this.a = paramInt;
  }
  
  final class a
    extends Animation
  {
    boolean a;
    
    a(boolean paramBoolean)
    {
      this.a = paramBoolean;
    }
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      paramTransformation = CircularRevealView.this;
      float f = paramFloat;
      if (this.a) {
        f = 1.0F - paramFloat;
      }
      CircularRevealView.a(paramTransformation, f);
      CircularRevealView.this.invalidate();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/CircularRevealView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */