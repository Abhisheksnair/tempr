package com.whatsapp;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;

public final class anc
  extends View
{
  private static final int[] e = { 70, 130, 200 };
  private Paint a;
  private Path b;
  private a c;
  private float d;
  
  private a getGlowAnimation()
  {
    a locala = new a((byte)0);
    locala.setDuration(1000L);
    locala.setRepeatCount(-1);
    locala.setInterpolator(new DecelerateInterpolator());
    return locala;
  }
  
  final void a()
  {
    if (this.c == null) {
      this.c = getGlowAnimation();
    }
    startAnimation(this.c);
  }
  
  protected final void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a();
  }
  
  protected final void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    clearAnimation();
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0);
    int m = getWidth();
    int i = getHeight();
    paramCanvas.save();
    float f = -this.d;
    paramCanvas.translate(0.0F, (i - m * 3 / 2) * f);
    int[] arrayOfInt = e;
    int n = arrayOfInt.length;
    i = 0;
    while (i < n)
    {
      int k = 255 - arrayOfInt[i];
      int j = k;
      if (this.d > 0.8F) {
        j = (int)(k * 5 * (1.0F - this.d));
      }
      this.a.setAlpha(j);
      paramCanvas.drawPath(this.b, this.a);
      paramCanvas.translate(0.0F, m * -2 / 4);
      i += 1;
    }
    paramCanvas.restore();
    this.a.setAlpha(255);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    this.b.rewind();
    this.b.moveTo(0.0F, paramInt2);
    this.b.lineTo(paramInt1 / 2, paramInt2 - paramInt1 / 2);
    this.b.lineTo(paramInt1, paramInt2);
    this.b.setFillType(Path.FillType.WINDING);
  }
  
  protected final void onVisibilityChanged(View paramView, int paramInt)
  {
    if (getVisibility() != 0) {
      clearAnimation();
    }
    while ((getAnimation() != null) || (this.c == null)) {
      return;
    }
    startAnimation(this.c);
  }
  
  final class a
    extends Animation
  {
    private a() {}
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      anc.a(anc.this, paramFloat);
      anc.this.invalidate();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/anc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */