package com.whatsapp.doodle.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;

public final class j
  extends e
{
  private static final a[] a = { new a(68.0F, 47.0F, 309.0F, 266.0F, 164.0F, 156.0F), new a(246.0F, 17.0F, 419.0F, 142.0F, 196.0F, 124.0F), new a(390.0F, 0.0F, 546.0F, 155.0F, 195.0F, 128.0F), new a(507.0F, 1.0F, 686.0F, 179.0F, 208.0F, 146.0F), new a(575.0F, 64.0F, 750.0F, 235.0F, 284.0F, 122.0F), new a(530.0F, 141.0F, 769.0F, 357.0F, 324.0F, 118.0F), new a(459.0F, 261.0F, 664.0F, 449.0F, 300.0F, 180.0F), new a(275.0F, 316.0F, 510.0F, 512.0F, 0.0F, 164.0F), new a(97.0F, 286.0F, 346.0F, 482.0F, 56.0F, 100.0F), new a(17.0F, 279.0F, 174.0F, 419.0F, 67.0F, 152.0F), new a(0.0F, 171.0F, 157.0F, 311.0F, 91.0F, 170.0F) };
  private final Path b = j();
  private final Path c = k();
  private final Paint j = new Paint(1);
  private final Matrix k = new Matrix();
  private final RectF l = new RectF();
  private final Path m = new Path();
  private final RectF n = new RectF();
  
  public j()
  {
    this.b.setFillType(Path.FillType.WINDING);
    this.b.computeBounds(this.l, true);
    this.e = 120.0F;
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2)
  {
    float f2 = this.d.width() / this.l.width();
    float f1 = 60.0F * f2 * paramFloat2;
    paramFloat2 = f2 * 30.0F * paramFloat2;
    f2 = this.d.centerX() + (float)(Math.cos(Math.toRadians(this.e)) * this.d.width() / 2.0D) * paramFloat1;
    paramFloat1 = this.d.centerY() + (float)(Math.sin(Math.toRadians(this.e)) * this.d.height() / 2.0D) * paramFloat1;
    this.n.set(f2 - f1, paramFloat1 - paramFloat2, f1 + f2, paramFloat2 + paramFloat1);
    paramCanvas.drawOval(this.n, this.j);
    paramCanvas.drawOval(this.n, this.f);
  }
  
  private static Path j()
  {
    Path localPath = new Path();
    a[] arrayOfa = a;
    int i1 = arrayOfa.length;
    int i = 0;
    while (i < i1)
    {
      a locala = arrayOfa[i];
      localPath.addArc(new RectF(locala.a, locala.b, locala.c, locala.d), locala.e, locala.f);
      i += 1;
    }
    return localPath;
  }
  
  private static Path k()
  {
    Path localPath = new Path();
    a[] arrayOfa = a;
    int i1 = arrayOfa.length;
    int i = 0;
    while (i < i1)
    {
      a locala = arrayOfa[i];
      localPath.addArc(new RectF(locala.a, locala.b, locala.c, locala.d), locala.e, 360.0F);
      i += 1;
    }
    localPath.addRect(120.0F, 80.0F, 580.0F, 430.0F, Path.Direction.CW);
    return localPath;
  }
  
  public final String a()
  {
    return "thinking-bubble";
  }
  
  public final void a(float paramFloat)
  {
    super.a(3.0F * paramFloat / 5.0F);
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f2 = paramFloat3 - paramFloat1;
    float f1 = paramFloat4 - paramFloat2;
    if (f2 / f1 < this.l.width() / this.l.height()) {
      f1 = this.l.height() * f2 / this.l.width();
    }
    for (;;)
    {
      paramFloat1 = (paramFloat1 + paramFloat3) / 2.0F;
      paramFloat2 = (paramFloat2 + paramFloat4) / 2.0F;
      super.a(paramFloat1 - f2 / 2.0F, paramFloat2 - f1 / 2.0F, f2 / 2.0F + paramFloat1, f1 / 2.0F + paramFloat2);
      return;
      f2 = this.l.width() * f1 / this.l.height();
    }
  }
  
  public final void a(Canvas paramCanvas)
  {
    this.d.sort();
    paramCanvas.save();
    this.k.setRectToRect(new RectF(this.l.left, this.l.top, this.l.right, this.l.bottom), this.d, Matrix.ScaleToFit.CENTER);
    this.m.reset();
    this.m.setFillType(Path.FillType.WINDING);
    this.c.transform(this.k, this.m);
    this.j.setStyle(Paint.Style.FILL);
    this.j.setColor(i.a);
    this.m.close();
    paramCanvas.drawPath(this.m, this.j);
    this.m.reset();
    this.m.setFillType(Path.FillType.WINDING);
    this.b.transform(this.k, this.m);
    this.f.setStyle(Paint.Style.STROKE);
    paramCanvas.drawPath(this.m, this.f);
    paramCanvas.restore();
    a(paramCanvas, 1.3F, 1.0F);
    a(paramCanvas, 1.7F, 0.5F);
  }
  
  public final float f()
  {
    return super.f() * 5.0F / 3.0F;
  }
  
  static final class a
  {
    final float a;
    final float b;
    final float c;
    final float d;
    final float e;
    final float f;
    
    a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      this.a = paramFloat1;
      this.b = paramFloat2;
      this.c = paramFloat3;
      this.d = paramFloat4;
      this.e = paramFloat5;
      this.f = paramFloat6;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */