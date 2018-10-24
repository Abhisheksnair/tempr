package com.whatsapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class CircularProgressBar
  extends ProgressBar
{
  private final RectF a = new RectF();
  private final Paint b = new Paint();
  private int c = -13388315;
  private int d = -1711276033;
  private int e;
  private float f;
  private String g = null;
  private float h;
  private float i = 5.0F;
  private boolean j = false;
  private int k;
  private float l;
  private float m;
  private float n;
  private float o;
  private long p;
  private Rect q = new Rect();
  
  public CircularProgressBar(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public CircularProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public CircularProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, adn.CircularProgressBar);
      this.c = paramContext.getInteger(0, this.c);
      this.d = paramContext.getInteger(1, this.d);
      this.e = paramContext.getInteger(2, this.e);
      this.i = paramContext.getFloat(3, this.i);
      this.k = paramContext.getInteger(4, this.k);
      this.l = paramContext.getDimension(5, this.l);
      paramContext.recycle();
    }
  }
  
  public String getCenterText()
  {
    return this.g;
  }
  
  public boolean getKnobEnabled()
  {
    return this.j;
  }
  
  public float getPaintStrokeFactor()
  {
    return this.i;
  }
  
  public int getProgressBarBackgroundColor()
  {
    return this.d;
  }
  
  public int getProgressBarColor()
  {
    return this.c;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.b.setAntiAlias(true);
    if (this.e != 0)
    {
      this.b.setStyle(Paint.Style.FILL);
      this.b.setColor(this.e);
      paramCanvas.drawArc(this.a, 0.0F, 360.0F, true, this.b);
    }
    this.b.setStrokeCap(Paint.Cap.ROUND);
    float f1;
    if (isIndeterminate())
    {
      long l1 = SystemClock.uptimeMillis();
      if (this.p == 0L) {
        this.p = l1;
      }
      f1 = (float)((l1 - this.p) % 1333L) / 1333.0F;
      if (f1 < 0.5F)
      {
        f1 = (float)Math.sin(f1 * 3.141592653589793D);
        f1 = f1 * (f1 * f1 * f1) / 2.0F;
        if (f1 >= 0.5F) {
          break label405;
        }
        this.m = (f1 * 2.0F * 280.0F);
        this.o = -1.0F;
        label153:
        paramCanvas.rotate((float)((l1 - this.p) % 2200L) / 2200.0F * 360.0F, getWidth() / 2, getHeight() / 2);
        this.b.setAntiAlias(true);
        if (this.d != 0)
        {
          this.b.setColor(this.d);
          this.b.setStyle(Paint.Style.STROKE);
          paramCanvas.drawArc(this.a, 0.0F, 360.0F, false, this.b);
        }
        if (this.k != 0)
        {
          this.b.setColor(this.k);
          this.b.setStyle(Paint.Style.STROKE);
          this.b.setStrokeWidth(this.f / this.i + this.l * 2.0F);
          paramCanvas.drawArc(this.a, this.n, this.m, false, this.b);
        }
        this.b.setColor(this.c);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setStrokeWidth(this.f / this.i);
        paramCanvas.drawArc(this.a, this.n, this.m, false, this.b);
        invalidate();
      }
    }
    label405:
    do
    {
      return;
      f1 = (float)Math.sin((f1 - 0.5F) * 3.141592653589793D);
      f1 = f1 * (f1 * f1 * f1) / 2.0F + 0.5F;
      break;
      if (this.o < 0.0F) {
        this.o = this.n;
      }
      this.m = ((1.0F - f1) * 2.0F * 280.0F);
      this.n = ((f1 - 0.5F) * 2.0F * 280.0F + this.o);
      break label153;
      this.b.setStyle(Paint.Style.STROKE);
      if (this.d != 0)
      {
        this.b.setStrokeWidth(this.f / this.i);
        this.b.setColor(this.d);
        paramCanvas.drawArc(this.a, 270.0F + getProgress() * 360.0F / getMax(), 360.0F - getProgress() * 360.0F / getMax(), false, this.b);
      }
      if (this.k != 0)
      {
        this.b.setColor(this.k);
        this.b.setStrokeWidth(this.f / this.i + this.l * 2.0F);
        paramCanvas.drawArc(this.a, -90.0F, getProgress() * 360.0F / getMax(), false, this.b);
      }
      this.b.setStrokeWidth(this.f / this.i);
      this.b.setColor(this.c);
      paramCanvas.drawArc(this.a, -90.0F, getProgress() * 360.0F / getMax(), false, this.b);
      if (this.j)
      {
        this.b.setColor(this.d);
        this.b.setStyle(Paint.Style.FILL);
        f1 = getProgress() * (float)(6.283185307179586D / getMax());
        paramCanvas.drawCircle((float)(this.a.centerX() + this.f * Math.sin(f1)), (float)(this.a.centerY() - this.f * Math.cos(f1)), 10.0F, this.b);
      }
    } while (this.g == null);
    this.b.setColor(-9408400);
    this.b.setTextSize(this.h);
    this.b.setTextAlign(Paint.Align.CENTER);
    this.b.setTypeface(Typeface.create("sans-serif-light", 0));
    this.b.getTextBounds(this.g, 0, this.g.length(), this.q);
    this.b.setStyle(Paint.Style.FILL);
    paramCanvas.drawText(this.g, 0, this.g.length(), this.a.centerX(), this.a.centerY() + this.q.height() * 0.5F, this.b);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.f = (Math.min(paramInt1 - getPaddingLeft() - getPaddingRight(), paramInt2 - getPaddingTop() - getPaddingBottom()) / 2.0F);
    this.f -= 0.3F * this.f;
    this.a.set(paramInt1 / 2 - this.f, paramInt2 / 2 - this.f, paramInt1 / 2 + this.f, paramInt2 / 2 + this.f);
  }
  
  public void setCenterText(String paramString)
  {
    this.g = paramString;
    this.h = (30.0F * aoa.a().a);
  }
  
  public void setKnobEnabled(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public void setPaintStrokeFactor(float paramFloat)
  {
    this.i = paramFloat;
  }
  
  public void setProgressBarBackgroundColor(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setProgressBarColor(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/CircularProgressBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */