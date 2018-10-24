package com.whatsapp.gdrive;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.whatsapp.aoa;

public class GoogleDriveRestoreAnimationView
  extends View
{
  a a;
  boolean b;
  private final DecelerateInterpolator c = new DecelerateInterpolator();
  private Drawable d;
  private Drawable e;
  private Drawable f;
  private Resources g;
  private Paint h;
  private float i;
  private boolean j;
  private boolean k;
  private int l;
  
  public GoogleDriveRestoreAnimationView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public GoogleDriveRestoreAnimationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public GoogleDriveRestoreAnimationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.g = paramContext.getResources();
    this.d = this.g.getDrawable(2130840281);
    if (this.d != null) {}
    for (int m = this.d.getIntrinsicWidth();; m = 0)
    {
      this.l = m;
      this.e = this.g.getDrawable(2130840280);
      this.h = new Paint();
      return;
    }
  }
  
  private void c()
  {
    this.a = new a((byte)0);
    this.a.setDuration(2000L);
    this.a.setRepeatCount(-1);
    this.a.setInterpolator(new LinearInterpolator());
    this.a.setFillAfter(true);
  }
  
  public final void a()
  {
    if (this.a == null) {
      c();
    }
    clearAnimation();
    this.d = this.g.getDrawable(2130840284);
    this.f = this.g.getDrawable(2130840285);
    this.a.setDuration(800L);
    startAnimation(this.a);
    this.j = true;
  }
  
  public final void b()
  {
    if (this.a == null) {
      c();
    }
    this.b = false;
    startAnimation(this.a);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.a = new a((byte)0);
    this.a.setDuration(2000L);
    this.a.setRepeatCount(-1);
    this.a.setInterpolator(new LinearInterpolator());
    this.a.setFillAfter(true);
    startAnimation(this.a);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    clearAnimation();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int m = getWidth();
    int n = getHeight();
    paramCanvas.translate(m / 2, n / 2);
    float f2 = 1.0F;
    n = (int)(1.0F * this.d.getIntrinsicWidth());
    float f1 = -m / 2 + n / 2;
    float f4 = 0.0F;
    float f3 = f4;
    int i1;
    if (this.j)
    {
      if (this.k) {
        break label400;
      }
      if (this.i < 0.6F)
      {
        f1 = this.c.getInterpolation(this.i / 0.6F);
        i1 = this.d.getIntrinsicWidth();
        f2 = this.l / this.d.getIntrinsicWidth();
        f2 = (i1 - this.l) * f1 / this.d.getIntrinsicWidth() + f2;
        f3 = n / 2 - m / 2;
        f1 = f1 * (m - this.d.getIntrinsicWidth() * f2) / 2.0F + f3;
        f3 = f4;
      }
    }
    else
    {
      n = (int)(this.d.getIntrinsicWidth() * f2);
      i1 = (int)(f2 * this.d.getIntrinsicHeight() / 2.0F);
      this.d.setBounds((int)(f1 - n / 2), -i1, (int)(f1 + n / 2), i1);
      this.d.draw(paramCanvas);
      if (f3 > 0.0D)
      {
        f1 = this.f.getIntrinsicWidth() * f3;
        f2 = f3 * this.f.getIntrinsicHeight();
        this.f.setBounds(-(int)f1, -(int)f2, (int)f1, (int)f2);
        this.f.draw(paramCanvas);
      }
      if (!this.j) {
        break label413;
      }
    }
    label400:
    label413:
    label618:
    label911:
    do
    {
      return;
      f4 = 1.0F;
      float f5 = 0.0F;
      float f6 = this.c.getInterpolation(this.i - 0.6F) * 0.5F;
      f3 = f6;
      f1 = f5;
      f2 = f4;
      if (this.i < 0.99F) {
        break;
      }
      this.k = true;
      f3 = f6;
      f1 = f5;
      f2 = f4;
      break;
      f2 = 1.0F;
      f1 = 0.0F;
      f3 = 0.5F;
      break;
      i1 = this.e.getIntrinsicWidth();
      int i2 = this.e.getIntrinsicHeight() / 2;
      this.e.setBounds(m / 2 - i1, -i2, m / 2, i2);
      this.e.draw(paramCanvas);
      double d2 = -m / 2.0F + n;
      double d3 = m / 2.0F - i1;
      double d1 = (float)Math.sqrt((d2 - d3) * (d2 - d3) + 0.0D) / (2.0D * Math.sin(0.325D));
      d2 = (d3 + d2) / 2.0D;
      d3 = Math.cos(0.325D);
      this.h.setAntiAlias(true);
      m = 0;
      if (m < 12)
      {
        double d4 = 0.65D * m / 12.0D;
        double d5 = 0.65D * (m + 1) / 12.0D;
        f2 = this.i;
        f3 = (float)(-0.32D + d4);
        f4 = (float)(-0.32D + d5);
        double d6;
        double d7;
        if (f2 <= 0.0F)
        {
          f1 = 0.0F;
          d5 = f1 * (f4 - f3) + f3;
          d4 = Math.sin(d5) * d1 + d2;
          d5 = d3 * d1 + 0.0D - Math.cos(d5) * d1;
          d6 = Math.sin(1.5707963267948966D * m / 12.0D);
          d7 = 1.5D * (this.i - 0.6F) / 0.3999999761581421D;
          if ((d6 > d7) || (d6 < d7 - 0.5D)) {
            break label911;
          }
        }
        for (n = 1;; n = 0)
        {
          this.h.setColor(getResources().getColor(2131624034));
          this.h.setStyle(Paint.Style.FILL);
          paramCanvas.drawCircle((float)d4, (float)d5, 2.67F * aoa.a().a, this.h);
          if ((this.i >= 0.6F) && (this.i < 1.0F) && (n != 0))
          {
            i1 = (int)((d6 - (d7 - 0.5D)) * 1024.0D + 64.0D);
            n = i1;
            if (i1 >= 255) {
              n = 255;
            }
            this.h.setColor(getResources().getColor(2131624035));
            this.h.setStyle(Paint.Style.FILL);
            this.h.setAlpha(n);
            paramCanvas.drawCircle((float)d4, (float)d5, 2.67F * aoa.a().a, this.h);
          }
          m += 1;
          break;
          f1 = f2;
          if (f2 < 1.0F) {
            break label618;
          }
          f1 = 1.0F;
          break label618;
        }
      }
    } while ((!this.b) || (this.a == null));
    this.a.cancel();
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (getVisibility() == 0)
    {
      if ((getAnimation() == null) && (this.a != null)) {
        startAnimation(this.a);
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
      GoogleDriveRestoreAnimationView.a(GoogleDriveRestoreAnimationView.this, paramFloat);
      GoogleDriveRestoreAnimationView.this.invalidate();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gdrive/GoogleDriveRestoreAnimationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */