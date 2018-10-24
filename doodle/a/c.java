package com.whatsapp.doodle.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;

public final class c
  extends e
{
  public c()
  {
    this.f.setStyle(Paint.Style.STROKE);
  }
  
  public final String a()
  {
    return "oval";
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat3 - paramFloat1;
    float f2 = paramFloat4 - paramFloat2;
    float f3 = Math.min(f1, f2);
    this.d.set((f1 - f3) / 2.0F + paramFloat1, (f2 - f3) / 2.0F + paramFloat2, paramFloat3 - (f1 - f3) / 2.0F, paramFloat4 - (f2 - f3) / 2.0F);
    this.d.sort();
  }
  
  public final void a(Canvas paramCanvas)
  {
    this.d.sort();
    paramCanvas.save();
    paramCanvas.rotate(this.e, this.d.centerX(), this.d.centerY());
    paramCanvas.drawOval(this.d, this.f);
    paramCanvas.restore();
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(-this.e, this.d.centerX(), this.d.centerY());
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    localMatrix.mapPoints(arrayOfFloat);
    return this.d.contains(arrayOfFloat[0], arrayOfFloat[1]);
  }
  
  public final void b(float paramFloat1, float paramFloat2)
  {
    int i;
    float f1;
    float f2;
    if (Math.abs(Math.tan(Math.atan(paramFloat2) - Math.toRadians(this.e))) < 1.0D)
    {
      i = 1;
      f1 = this.d.centerX();
      f2 = this.d.centerY();
      if (i == 0) {
        break label133;
      }
    }
    label133:
    for (paramFloat2 = paramFloat1;; paramFloat2 = 1.0F)
    {
      if (i != 0) {
        paramFloat1 = 1.0F;
      }
      this.d.set(f1 - (f1 - this.d.left) * paramFloat2, f2 - (f2 - this.d.top) * paramFloat1, f1 - paramFloat2 * (f1 - this.d.right), f2 - (f2 - this.d.bottom) * paramFloat1);
      g();
      return;
      i = 0;
      break;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */