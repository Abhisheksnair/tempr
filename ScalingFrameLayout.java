package com.whatsapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public class ScalingFrameLayout
  extends FrameLayout
{
  private float a = 1.0F;
  private final pv b;
  
  public ScalingFrameLayout(Context paramContext)
  {
    super(paramContext);
    if (isInEditMode()) {}
    for (paramContext = null;; paramContext = pv.a())
    {
      this.b = paramContext;
      return;
    }
  }
  
  public ScalingFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {}
    for (paramContext = null;; paramContext = pv.a())
    {
      this.b = paramContext;
      return;
    }
  }
  
  public ScalingFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode()) {}
    for (paramContext = null;; paramContext = pv.a())
    {
      this.b = paramContext;
      return;
    }
  }
  
  @TargetApi(21)
  public ScalingFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    if (isInEditMode()) {}
    for (paramContext = null;; paramContext = pv.a())
    {
      this.b = paramContext;
      return;
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    if (this.b.a) {
      paramCanvas.translate(getWidth(), 0.0F);
    }
    paramCanvas.scale(this.a, this.a);
    if (this.b.a) {
      paramCanvas.translate(-getWidth(), 0.0F);
    }
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    super.onMeasure(View.MeasureSpec.makeMeasureSpec((int)(paramInt1 / this.a), i), View.MeasureSpec.makeMeasureSpec((int)(paramInt2 / this.a), j));
    setMeasuredDimension((int)(getMeasuredWidth() * this.a), (int)(getMeasuredHeight() * this.a));
  }
  
  public void setScale(float paramFloat)
  {
    this.a = paramFloat;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ScalingFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */