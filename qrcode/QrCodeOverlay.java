package com.whatsapp.qrcode;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.whatsapp.adn;

public class QrCodeOverlay
  extends View
{
  float a = 0.0F;
  float b = 0.01F;
  private Paint c = new Paint(1);
  private Paint d;
  private a e;
  private RectF f = new RectF();
  private boolean g;
  
  public QrCodeOverlay(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QrCodeOverlay(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QrCodeOverlay(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, adn.QrScannerOverlay);
    this.g = paramContext.getBoolean(0, false);
    paramContext.recycle();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.e = new a((byte)0);
    this.e.setDuration(2000L);
    this.e.setRepeatCount(-1);
    this.e.setRepeatMode(2);
    startAnimation(this.e);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    clearAnimation();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int m = getWidth() - getPaddingLeft() - getPaddingRight();
    int n = getHeight() - getPaddingTop() - getPaddingBottom();
    int i1 = Math.min(m, n) * 3 / 4;
    int i = (m - i1) / 2 + getPaddingLeft();
    int i2 = (n - i1) / 2 + getPaddingTop();
    int j = i + i1;
    int k = i2 + i1;
    if (this.g)
    {
      if (this.d == null)
      {
        this.d = new Paint();
        this.d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      }
      this.c.setARGB(125, 50, 50, 50);
      this.c.setStyle(Paint.Style.FILL);
      paramCanvas.drawColor(Color.argb(125, 50, 50, 50));
      this.f.set(i, i2, j, k);
      paramCanvas.drawArc(this.f, 0.0F, 360.0F, true, this.d);
      f1 = getContext().getResources().getDimension(2131361898);
      this.c.setStyle(Paint.Style.STROKE);
      this.c.setColor(-2147418368);
      this.c.setStrokeWidth(2.0F * f1);
      m = (int)(i2 + 2.0F * f1);
      k = (int)(k - f1 * 2.0F);
      if ((this.a > 1.0F) || (this.a < 0.0F)) {
        this.b = (-this.b);
      }
      this.a += this.b;
      f1 = (float)Math.sqrt(1.0F - (2.0F * this.a - 1.0F) * (2.0F * this.a - 1.0F));
      float f2 = (i + j) / 2;
      float f3 = (j - i) * f1 / 2.0F;
      float f4 = m;
      float f5 = k - m;
      float f6 = this.a;
      float f7 = (i + j) / 2;
      paramCanvas.drawLine(f2 - f3, f4 + f5 * f6, f1 * (j - i) / 2.0F + f7, m + (k - m) * this.a, this.c);
      return;
    }
    this.c.setARGB(125, 50, 50, 50);
    this.c.setStyle(Paint.Style.FILL);
    paramCanvas.drawRect(0.0F, 0.0F, m, i2, this.c);
    paramCanvas.drawRect(0.0F, i2, i, k, this.c);
    paramCanvas.drawRect(j, i2, m, k, this.c);
    paramCanvas.drawRect(0.0F, k, m, n, this.c);
    float f1 = getContext().getResources().getDimension(2131361898);
    this.c.setStrokeWidth(f1);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setColor(872415231);
    paramCanvas.drawRect(i, i2, j, k, this.c);
    paramCanvas.drawLine((i + j) / 2, i2 - i1 / 12, (i + j) / 2, i1 / 12 + i2, this.c);
    paramCanvas.drawLine((i + j) / 2, k - i1 / 12, (i + j) / 2, i1 / 12 + k, this.c);
    paramCanvas.drawLine(i - i1 / 12, (i2 + k) / 2, i1 / 12 + i, (i2 + k) / 2, this.c);
    paramCanvas.drawLine(j - i1 / 12, (i2 + k) / 2, i1 / 12 + j, (i2 + k) / 2, this.c);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setColor(-2147418368);
    this.c.setStrokeWidth(2.0F * f1);
    m = (int)(i2 + 2.0F * f1);
    k = (int)(k - 2.0F * f1);
    if ((this.a > 1.0F) || (this.a < 0.0F)) {
      this.b = (-this.b);
    }
    this.a += this.b;
    paramCanvas.drawLine(i, m + (k - m) * this.a, j, m + (k - m) * this.a, this.c);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (getVisibility() == 0)
    {
      if ((getAnimation() == null) && (this.e != null)) {
        startAnimation(this.e);
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
      int k = QrCodeOverlay.this.getWidth();
      int j = QrCodeOverlay.this.getHeight();
      int i = Math.min(k, j) * 3 / 4;
      k = (k - i) / 2;
      j = (j - i) / 2;
      QrCodeOverlay.this.invalidate(k, j, k + i, i + j);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/qrcode/QrCodeOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */