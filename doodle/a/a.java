package com.whatsapp.doodle.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;

public final class a
  extends e
{
  public a()
  {
    this.f.setStyle(Paint.Style.STROKE);
  }
  
  public final String a()
  {
    return "arrow";
  }
  
  public final void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.rotate(this.e, this.d.centerX(), this.d.centerY());
    float f2 = this.d.left;
    float f1 = this.d.bottom;
    float f3 = this.d.right;
    float f4 = this.d.top;
    paramCanvas.drawLine(f2, f1, f3, f4, this.f);
    if (f3 == f2)
    {
      f1 = 90.0F;
      paramCanvas.save();
      paramCanvas.translate(f3, f4);
      if (f2 <= f3) {
        break label208;
      }
      i = 30;
      label109:
      paramCanvas.rotate(f1 + i);
      paramCanvas.drawLine(0.0F, 0.0F, this.f.getStrokeWidth() * 5.0F, 0.0F, this.f);
      if (f2 <= f3) {
        break label216;
      }
    }
    label208:
    label216:
    for (int i = -60;; i = 60)
    {
      paramCanvas.rotate(i);
      paramCanvas.drawLine(0.0F, 0.0F, this.f.getStrokeWidth() * 5.0F, 0.0F, this.f);
      paramCanvas.restore();
      paramCanvas.restore();
      return;
      f1 = (float)Math.toDegrees(Math.atan((f4 - f1) / (f3 - f2)));
      break;
      i = 150;
      break label109;
    }
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(-this.e, this.d.centerX(), this.d.centerY());
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    localMatrix.mapPoints(arrayOfFloat);
    paramFloat1 = arrayOfFloat[0];
    paramFloat2 = arrayOfFloat[1];
    if (!this.d.contains(paramFloat1, paramFloat2)) {}
    float f1;
    float f2;
    float f3;
    float f4;
    do
    {
      return false;
      f1 = this.d.left;
      f2 = this.d.bottom;
      f3 = this.d.right;
      f4 = this.d.top;
    } while (Math.abs(paramFloat1 * (f4 - f2) - paramFloat2 * (f3 - f1) + f3 * f2 - f4 * f1) / Math.sqrt((f3 - f1) * (f3 - f1) + (f4 - f2) * (f4 - f2)) >= i.g);
    return true;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */