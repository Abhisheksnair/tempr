package com.whatsapp.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.util.DisplayMetrics;

final class t
  extends Drawable
{
  boolean a;
  private float b;
  private int c;
  private float d;
  private final Drawable e;
  private final Paint f = new Paint(1);
  private final Paint g = new Paint(1);
  
  public t(Context paramContext, int paramInt)
  {
    this.f.setStyle(Paint.Style.FILL);
    this.d = (paramContext.getResources().getDisplayMetrics().density * 3.0F / 4.0F);
    this.g.setColor(1073741824);
    this.g.setStyle(Paint.Style.FILL);
    this.g.setMaskFilter(new BlurMaskFilter(this.d, BlurMaskFilter.Blur.OUTER));
    this.e = b.a(paramContext, paramInt);
  }
  
  final void a(float paramFloat, int paramInt)
  {
    this.b = paramFloat;
    this.c = paramInt;
    invalidateSelf();
  }
  
  final void a(int paramInt)
  {
    this.c = paramInt;
    invalidateSelf();
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    float f1 = Math.min(localRect.width(), localRect.height()) * 7 / 16;
    if (this.a)
    {
      paramCanvas.drawCircle(localRect.centerX(), localRect.centerY(), this.d + f1, this.g);
      this.f.setStyle(Paint.Style.FILL);
      this.f.setColor(this.c);
      paramCanvas.drawCircle(localRect.centerX(), localRect.centerY(), f1, this.f);
      this.f.setStyle(Paint.Style.FILL);
      this.f.setColor(-1);
      paramCanvas.drawCircle(localRect.centerX(), localRect.centerY(), this.b * 1.2F / 2.0F, this.f);
      if ((Color.red(this.c) > 240) && (Color.green(this.c) > 240) && (Color.blue(this.c) > 240))
      {
        int i = Math.min(Math.min(Color.red(this.c), Color.green(this.c)), Color.blue(this.c)) - 240;
        this.f.setStyle(Paint.Style.STROKE);
        this.f.setStrokeWidth(this.d);
        this.f.setColor(Color.argb(255, 255 - i * 3, 255 - i * 3, 255 - i * 3));
        paramCanvas.drawCircle(localRect.centerX(), localRect.centerY(), this.b * 1.2F / 2.0F, this.f);
      }
      return;
    }
    if (this.c != 0)
    {
      paramCanvas.drawCircle(localRect.centerX(), localRect.centerY(), this.d + f1, this.g);
      this.f.setStyle(Paint.Style.FILL);
      this.f.setColor(this.c);
      paramCanvas.drawCircle(localRect.centerX(), localRect.centerY(), f1, this.f);
    }
    this.e.setBounds(localRect.centerX() - this.e.getIntrinsicWidth() / 2, localRect.centerY() - this.e.getIntrinsicHeight() / 2, localRect.centerX() + this.e.getIntrinsicWidth() / 2, localRect.centerY() + this.e.getIntrinsicHeight() / 2);
    this.e.draw(paramCanvas);
  }
  
  public final int getIntrinsicHeight()
  {
    return -1;
  }
  
  public final int getIntrinsicWidth()
  {
    return -1;
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */