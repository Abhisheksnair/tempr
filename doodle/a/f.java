package com.whatsapp.doodle.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RectF;

public final class f
  extends e
{
  private final Path a = new Path();
  private final Paint b = new Paint(1);
  private final Matrix c = new Matrix();
  private final Path j = new Path();
  
  public f()
  {
    float f1 = (float)(Math.cos(Math.toRadians(35.0D)) * 1000.0D);
    float f2 = (float)(Math.sin(Math.toRadians(35.0D)) * 1000.0D);
    float f3 = (float)(Math.cos(Math.toRadians(55.0D)) * 1000.0D);
    float f4 = (float)(Math.sin(Math.toRadians(55.0D)) * 1000.0D);
    this.a.addArc(new RectF(-1000.0F, -1000.0F, 1000.0F, 1000.0F), 55.0F, 340.0F);
    this.a.moveTo(f1, f2);
    this.a.lineTo(1200.0F, 1200.0F);
    this.a.lineTo(f3, f4);
  }
  
  public final String a()
  {
    return "speech-bubble-oval";
  }
  
  public final void a(float paramFloat)
  {
    super.a(2.0F * paramFloat / 3.0F);
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f = (paramFloat3 - paramFloat1) * 2.0F / 3.0F;
    paramFloat2 = (paramFloat2 + paramFloat4) / 2.0F;
    super.a(paramFloat1, paramFloat2 - f / 2.0F, paramFloat3, f / 2.0F + paramFloat2);
  }
  
  public final void a(Canvas paramCanvas)
  {
    this.d.sort();
    this.f.setStyle(Paint.Style.STROKE);
    this.c.reset();
    this.c.setRotate(this.e, 0.0F, 0.0F);
    this.c.postScale(this.d.width() / 2000.0F, this.d.height() / 2000.0F);
    this.c.postTranslate(this.d.centerX(), this.d.centerY());
    this.j.reset();
    this.j.setFillType(Path.FillType.WINDING);
    this.a.transform(this.c, this.j);
    this.b.setStyle(Paint.Style.FILL);
    this.b.setColor(i.a);
    this.j.close();
    paramCanvas.drawPath(this.j, this.b);
    this.j.reset();
    this.j.setFillType(Path.FillType.WINDING);
    this.a.transform(this.c, this.j);
    paramCanvas.drawPath(this.j, this.f);
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    paramFloat1 -= this.d.centerX();
    paramFloat2 -= this.d.centerY();
    float f1 = this.d.width() / 2.0F;
    float f2 = this.d.height() / 2.0F;
    return paramFloat1 * paramFloat1 / (f1 * f1) + paramFloat2 * paramFloat2 / (f2 * f2) <= 1.0F;
  }
  
  public final float f()
  {
    return super.f() * 3.0F / 2.0F;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/a/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */