package com.whatsapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class ThumbnailButton
  extends ImageView
{
  private static int a;
  float b = 0.0F;
  int c = a;
  float d;
  float e;
  int f;
  boolean g;
  Paint h;
  final RectF i = new RectF();
  final Rect j = new Rect();
  
  static
  {
    if ((Build.VERSION.SDK_INT < 19) || ((Build.VERSION.SDK_INT < 21) && ("samsung".equalsIgnoreCase(Build.MANUFACTURER)))) {}
    for (int k = 1711315455;; k = 419430400)
    {
      a = k;
      return;
    }
  }
  
  public ThumbnailButton(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public ThumbnailButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public ThumbnailButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    setBackgroundDrawable(new a((byte)0));
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, adn.ThumbnailButton);
      this.b = paramContext.getDimension(1, this.b);
      this.d = paramContext.getFloat(4, this.d);
      this.c = paramContext.getInteger(0, this.c);
      this.e = paramContext.getDimension(2, this.e);
      this.f = paramContext.getInteger(3, this.f);
      this.g = paramContext.getBoolean(5, this.g);
      paramContext.recycle();
    }
    this.h = new Paint();
    this.h.setAntiAlias(true);
    this.h.setDither(true);
    this.h.setFilterBitmap(true);
    this.h.setColor(-1);
  }
  
  protected void a(Canvas paramCanvas)
  {
    if ((this.e > 0.0F) && (this.f != 0))
    {
      this.h.setColor(this.f);
      this.h.setStrokeWidth(this.e);
      this.h.setStyle(Paint.Style.STROKE);
      if (this.b >= 0.0F) {
        paramCanvas.drawRoundRect(this.i, this.b, this.b, this.h);
      }
    }
    else
    {
      return;
    }
    paramCanvas.drawArc(this.i, 0.0F, 360.0F, true, this.h);
  }
  
  public float getBorderSize()
  {
    return this.e;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int k = (int)((1.0F + this.e) / 2.0F);
    this.i.left = (getPaddingLeft() + k);
    this.i.right = (getWidth() - getPaddingRight() - k);
    this.i.top = (getPaddingTop() + k);
    this.i.bottom = (getHeight() - getPaddingBottom() - k);
    if ((this.g) || (!(getDrawable() instanceof BitmapDrawable))) {
      super.onDraw(paramCanvas);
    }
    while (getDrawable() == null)
    {
      a(paramCanvas);
      if ((isEnabled()) && ((isSelected()) || (isPressed())))
      {
        this.h.setStyle(Paint.Style.FILL);
        this.h.setColor(this.c);
        if (this.b < 0.0F) {
          break;
        }
        paramCanvas.drawRoundRect(this.i, this.b, this.b, this.h);
      }
      return;
    }
    Bitmap localBitmap = ((BitmapDrawable)getDrawable()).getBitmap();
    k = localBitmap.getWidth();
    int m = localBitmap.getHeight();
    float f1;
    float f2;
    if (getScaleType() == ImageView.ScaleType.FIT_CENTER)
    {
      this.j.set(0, 0, k, m);
      if (k * this.i.height() > m * this.i.width())
      {
        f1 = this.i.width();
        f1 = m * f1 / k;
        f2 = (this.i.top + this.i.bottom) / 2.0F;
        this.i.top = (f2 - f1 / 2.0F);
        this.i.bottom = (f1 + this.i.top);
        label326:
        this.h.setColor(-1);
        this.h.setStyle(Paint.Style.FILL);
        if (this.b == 0.0F) {
          break label878;
        }
        k = paramCanvas.saveLayer(this.i, null, 31);
        paramCanvas.drawARGB(0, 0, 0, 0);
        if (this.b < 0.0F) {
          break label842;
        }
        paramCanvas.drawRoundRect(this.i, this.b, this.b, this.h);
        label403:
        this.h.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      }
    }
    for (;;)
    {
      paramCanvas.drawBitmap(localBitmap, this.j, this.i, this.h);
      if (this.b == 0.0F) {
        break;
      }
      this.h.setXfermode(null);
      paramCanvas.restoreToCount(k);
      break;
      f1 = this.i.height();
      f1 = k * f1 / m;
      f2 = (this.i.left + this.i.right) / 2.0F;
      this.i.left = (f2 - f1 / 2.0F);
      this.i.right = (f1 + this.i.left);
      break label326;
      if (getScaleType() == ImageView.ScaleType.CENTER)
      {
        this.j.set(0, 0, k, m);
        this.i.left = (this.i.centerX() - k / 2);
        RectF localRectF = this.i;
        f1 = this.i.left;
        localRectF.right = (k + f1);
        this.i.top = (this.i.centerY() - m / 2);
        localRectF = this.i;
        f1 = this.i.top;
        localRectF.bottom = (m + f1);
        break label326;
      }
      this.j.set(0, 0, k, m);
      if (k * this.i.height() > m * this.i.width())
      {
        f1 = this.j.height() * this.i.width() / this.i.height();
        f2 = (this.j.left + this.j.right) / 2;
        this.j.left = ((int)(f2 - f1 / 2.0F));
        this.j.right = ((int)(f1 + this.j.left));
        break label326;
      }
      f1 = this.j.width() * this.i.height() / this.i.width();
      f2 = (this.j.top + this.j.bottom) / 2;
      this.j.top = ((int)(f2 - f1 / 2.0F));
      this.j.bottom = ((int)(f1 + this.j.top));
      break label326;
      label842:
      paramCanvas.drawArc(this.i, 0.0F, 360.0F, true, this.h);
      break label403;
      paramCanvas.drawArc(this.i, 0.0F, 360.0F, true, this.h);
      return;
      label878:
      k = 0;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.d == 1.0F)
    {
      paramInt1 = getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
      setMeasuredDimension(paramInt1, paramInt1);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setAspectRatio(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  public void setBorderColor(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setBorderSize(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  public void setRadius(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public void setSelectionColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  static final class a
    extends Drawable
  {
    private int a = 16842921;
    
    public final void draw(Canvas paramCanvas) {}
    
    public final int getOpacity()
    {
      return 0;
    }
    
    public final boolean isStateful()
    {
      return true;
    }
    
    public final void setAlpha(int paramInt) {}
    
    public final void setColorFilter(ColorFilter paramColorFilter) {}
    
    public final boolean setState(int[] paramArrayOfInt)
    {
      boolean bool = false;
      int j = this.a;
      this.a = 16842921;
      int k = paramArrayOfInt.length;
      int i = 0;
      for (;;)
      {
        int m;
        if (i < k)
        {
          m = paramArrayOfInt[i];
          if (m == 16842919) {
            this.a = 16842919;
          }
        }
        else
        {
          if (j != this.a)
          {
            invalidateSelf();
            bool = true;
          }
          return bool;
        }
        if (m == 16842908) {
          this.a = 16842908;
        }
        i += 1;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ThumbnailButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */