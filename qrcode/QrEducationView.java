package com.whatsapp.qrcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

public class QrEducationView
  extends View
{
  private Drawable a;
  private Drawable b;
  private Drawable c;
  private Drawable d;
  private Drawable e;
  private Drawable f;
  private final float g = 0.14F;
  private final float h = 0.2F;
  private final float i = 0.3F;
  private final float j = 0.35F;
  private final float k = 0.5F;
  private final float l = 0.55F;
  private final float m = 0.6F;
  private final float n = 0.9F;
  private int o;
  private long p;
  private Paint q = new Paint();
  private a r;
  private float s;
  
  public QrEducationView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public QrEducationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public QrEducationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    if (paramFloat3 <= paramFloat1) {
      paramFloat1 = 0.0F;
    }
    for (;;)
    {
      return paramFloat1 * (paramFloat5 - paramFloat4) + paramFloat4;
      if (paramFloat3 >= paramFloat2) {
        paramFloat1 = 1.0F;
      } else {
        paramFloat1 = (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
      }
    }
  }
  
  private void a(Context paramContext)
  {
    paramContext = paramContext.getResources();
    this.a = paramContext.getDrawable(2130837604);
    this.b = paramContext.getDrawable(2130837603);
    this.c = paramContext.getDrawable(2130837601);
    this.d = paramContext.getDrawable(2130837602);
    this.e = paramContext.getDrawable(2130837600);
    this.f = paramContext.getDrawable(2130837599);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.r = new a((byte)0);
    this.r.setDuration(8000L);
    this.r.setRepeatCount(-1);
    this.r.setInterpolator(new LinearInterpolator());
    startAnimation(this.r);
    this.o = 0;
    this.p = 0L;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    clearAnimation();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int i4 = getWidth();
    int i5 = getHeight();
    int i1 = Math.min(i4, i5);
    int i2 = (i4 - i1) / 2;
    int i3 = (i5 - i1) / 2;
    paramCanvas.clipRect(i2, i3, i2 + i1, i1 + i3);
    paramCanvas.translate(i4 / 2, i5 / 2);
    if (this.d.getIntrinsicHeight() + this.d.getIntrinsicWidth() / 3 > i5)
    {
      f1 = i5 / (this.d.getIntrinsicHeight() + this.d.getIntrinsicWidth() / 3);
      paramCanvas.scale(f1, f1);
    }
    float f1 = this.s;
    if (f1 < 0.14F) {
      f1 = f1 * f1 / 0.14F;
    }
    label164:
    label628:
    label750:
    label1088:
    label1100:
    label1202:
    label1226:
    label1236:
    for (;;)
    {
      float f2;
      if (f1 < 0.14F)
      {
        i1 = (int)(255.0F * f1 / 0.14F);
        f2 = 0.86F + f1;
      }
      for (;;)
      {
        i2 = i1;
        if (f1 > 0.9F) {
          i2 = (int)a(0.9F, 1.0F, f1, i1, 0.0F);
        }
        float f3 = a(0.2F, 0.3F, f1, 0.0F, this.c.getIntrinsicWidth() / 8);
        this.c.setAlpha(i2);
        float f4 = this.c.getIntrinsicWidth() * f2 / 2.0F;
        f2 = f2 * this.c.getIntrinsicHeight() / 2.0F;
        this.c.setBounds(-(int)(f4 + f3), -(int)f2, (int)(f4 - f3), (int)f2);
        this.c.draw(paramCanvas);
        float f5;
        if (f1 >= 0.2F)
        {
          f4 = this.d.getIntrinsicWidth() / 2;
          float f6 = this.d.getIntrinsicHeight() / 2;
          f5 = -f4 - a(0.2F, 0.3F, f1, i4 / 2, -f4 / 4.0F);
          f2 = 0.0F;
          f3 = f2;
          if (f1 > 0.35F)
          {
            f3 = f2;
            if (f1 < 0.5F) {
              f3 = (float)(0.0D + Math.sin(a(0.35F, 0.5F, f1, 0.0F, 3.1415927F)) * f4 / 3.0D);
            }
          }
          this.d.setBounds(-(int)f4 - (int)f5, -(int)f6 + (int)f3, (int)f4 - (int)f5, (int)f6 + (int)f3);
          i3 = (int)a(0.9F, 1.0F, f1, 255.0F, 0.0F);
          this.d.setAlpha(i3);
          this.d.draw(paramCanvas);
          i1 = this.d.getBounds().left;
          i2 = this.d.getBounds().right;
          int i6 = (i2 - i1) / 7;
          paramCanvas.clipRect(i1 + i6, this.d.getBounds().top, i2 - i6, this.d.getBounds().bottom);
          if (f1 > 0.2F)
          {
            f6 = this.a.getIntrinsicWidth() / 2;
            float f7 = this.a.getIntrinsicHeight() / 2;
            float f8 = -f4 + f4 / 4.0F - a(0.2F, 0.3F, this.s, f4 / 8.0F, 0.0F);
            f2 = -f4 / 3.0F;
            if ((f1 <= 0.35F) || (f1 >= 0.5F)) {
              break label1088;
            }
            f2 = (float)Math.sin(-a(0.35F, 0.5F, f1, 1.5707964F, 3.1415927F)) * f4 / 3.0F;
            this.a.setBounds(-(int)f6 - (int)f8, -(int)f7 + (int)f2, (int)f6 - (int)f8, (int)f7 + (int)f2);
            localDrawable = this.b;
            i1 = -(int)f6;
            i2 = (int)f8;
            i6 = -(int)f7;
            i7 = (int)f2;
            i8 = (int)f6;
            i9 = (int)f8;
            i10 = (int)f7;
            localDrawable.setBounds(i1 - i2, i6 + i7, i8 - i9, (int)f2 + i10);
            if (f1 <= 0.9F) {
              break label1100;
            }
            i2 = 0;
            i1 = Math.min(150, i3);
            this.a.setAlpha(i1);
            this.b.setAlpha(i2);
            this.a.draw(paramCanvas);
            this.b.draw(paramCanvas);
          }
          f2 = this.e.getIntrinsicWidth() / 2;
          f6 = this.e.getIntrinsicHeight() / 2;
          Drawable localDrawable = this.e;
          i1 = -(int)f2;
          i2 = (int)f5;
          i6 = -(int)f6;
          int i7 = (int)f3;
          int i8 = (int)f2;
          int i9 = (int)f5;
          int i10 = (int)f6;
          localDrawable.setBounds(i1 - i2, i6 + i7, i8 - i9, (int)f3 + i10);
          this.e.setAlpha(i3);
          this.e.draw(paramCanvas);
          if (f1 > 0.55F)
          {
            f3 = this.f.getIntrinsicWidth() / 2;
            f5 = this.f.getIntrinsicHeight() / 2;
            f4 = -f4 + f4 / 4.0F;
            i1 = 255;
            f2 = 1.0F;
            if (f1 <= 0.9F) {
              break label1202;
            }
            i1 = i3;
          }
        }
        for (f1 = f2;; f1 = 1.0F - (1.0F - f1) * (1.0F - f1))
        {
          this.f.setAlpha(i1);
          this.f.setBounds(-(int)(f3 * f1) - (int)f4, -(int)(f5 * f1), (int)(f3 * f1) - (int)f4, (int)(f1 * f5));
          this.f.draw(paramCanvas);
          paramCanvas.translate(-i4 / 2, -i5 / 2);
          return;
          if ((f1 < 0.2F) || (f1 >= 0.3F)) {
            break label1236;
          }
          f1 = (float)(Math.sqrt(f1 - 0.2F) * Math.sqrt(0.10000000894069672D)) + 0.2F;
          break;
          if (f1 < 0.2F) {
            break label1226;
          }
          i1 = (int)a(0.2F, 0.3F, f1, 255.0F, 150.0F);
          f2 = 1.0F;
          break label164;
          if (f1 < 0.5F) {
            break label628;
          }
          f2 = 0.0F;
          break label628;
          if (f1 > 0.55F)
          {
            i2 = 0;
            i1 = (int)a(0.55F, 0.6F, f1, 255.0F, 150.0F);
            break label750;
          }
          if (f1 > 0.2F)
          {
            if (f1 < 0.35F)
            {
              i1 = 0;
              i2 = (int)a(0.2F, 0.35F, f1, 0.0F, 255.0F);
              break label750;
            }
            i1 = (int)a(0.35F, 0.5F, f1, 0.0F, 255.0F);
            i2 = (int)a(0.35F, 0.5F, f1, 255.0F, 0.0F);
            break label750;
          }
          i2 = 0;
          i1 = 0;
          break label750;
          f1 = a(0.55F, 0.6F, f1, 0.0F, 1.0F);
        }
        i1 = 255;
        f2 = 1.0F;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = Math.min(getDefaultSize(getSuggestedMinimumWidth(), paramInt1), getDefaultSize(getSuggestedMinimumHeight(), paramInt2));
    setMeasuredDimension(paramInt1, paramInt1);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (getVisibility() == 0)
    {
      if ((getAnimation() == null) && (this.r != null)) {
        startAnimation(this.r);
      }
      return;
    }
    clearAnimation();
  }
  
  final class a
    extends Animation
  {
    private a() {}
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      QrEducationView.a(QrEducationView.this, paramFloat);
      QrEducationView.this.invalidate();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/qrcode/QrEducationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */