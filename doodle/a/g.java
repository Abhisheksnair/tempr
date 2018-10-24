package com.whatsapp.doodle.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

public final class g
  extends e
{
  private final Path a = new Path();
  private final Paint b = new Paint(1);
  private final RectF c = new RectF();
  private final PointF[] j = { new PointF(), new PointF(), new PointF(), new PointF(), new PointF(), new PointF(), new PointF() };
  private final RectF k = new RectF();
  private final PointF l = new PointF();
  private final PointF m = new PointF();
  
  public g()
  {
    this.e = 110.0F;
    this.b.setStyle(Paint.Style.FILL);
    this.b.setColor(i.a);
    this.f.setStyle(Paint.Style.STROKE);
  }
  
  private RectF b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.k.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    return this.k;
  }
  
  public final String a()
  {
    return "speech-bubble-rect";
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
    this.a.reset();
    float f1 = this.d.centerX() + (float)(Math.cos(Math.toRadians(this.e)) * this.d.width() * 0.8999999761581421D);
    float f2 = this.d.centerY() + (float)(Math.sin(Math.toRadians(this.e)) * this.d.height() * 0.8999999761581421D);
    this.c.set(this.d);
    Path localPath = this.a;
    RectF localRectF = this.c;
    float f3 = f1 - localRectF.left - localRectF.width() / 2.0F;
    float f4 = f2 - localRectF.top - localRectF.height() / 2.0F;
    float f5 = localRectF.height() / localRectF.width();
    float f6 = Math.min(localRectF.width() / 6.0F, localRectF.height() / 6.0F);
    float f7 = 2.0F * f6;
    this.j[0].x = f1;
    this.j[0].y = f2;
    if ((f3 < 0.0F) && (f4 >= 0.0F)) {
      if (-f3 * f5 < f4)
      {
        this.j[1].x = (localRectF.left + 2.0F * localRectF.width() / 6.0F);
        this.j[1].y = (localRectF.top + localRectF.height());
        this.j[2].x = localRectF.left;
        this.j[2].y = (localRectF.top + localRectF.height());
        this.j[3].x = localRectF.left;
        this.j[3].y = localRectF.top;
        this.j[4].x = (localRectF.left + localRectF.width());
        this.j[4].y = localRectF.top;
        this.j[5].x = (localRectF.left + localRectF.width());
        this.j[5].y = (localRectF.top + localRectF.height());
        this.j[6].x = (localRectF.left + 3.0F * localRectF.width() / 6.0F);
        this.j[6].y = (localRectF.top + localRectF.height());
      }
    }
    for (;;)
    {
      localPath.moveTo(this.j[0].x, this.j[0].y);
      int i = 0;
      while (i < 7)
      {
        this.l.set(this.j[i].x, this.j[i].y);
        this.m.set(this.j[((i + 1) % 7)].x, this.j[((i + 1) % 7)].y);
        PointF localPointF;
        if ((this.l.x == localRectF.left) && (this.l.y == localRectF.top))
        {
          localPath.arcTo(b(this.l.x, this.l.y, this.l.x + f7, this.l.y + f7), 180.0F, 90.0F, false);
          localPointF = this.l;
          localPointF.x += f6;
        }
        if ((this.m.x == localRectF.left) && (this.m.y == localRectF.top))
        {
          localPointF = this.m;
          localPointF.y += f6;
        }
        if ((this.l.x == localRectF.left + localRectF.width()) && (this.l.y == localRectF.top))
        {
          localPath.arcTo(b(this.l.x - f7, this.l.y, this.l.x, this.l.y + f7), -90.0F, 90.0F, false);
          localPointF = this.l;
          localPointF.y += f6;
        }
        if ((this.m.x == localRectF.left + localRectF.width()) && (this.m.y == localRectF.top))
        {
          localPointF = this.m;
          localPointF.x -= f6;
        }
        if ((this.l.x == localRectF.left + localRectF.width()) && (this.l.y == localRectF.top + localRectF.height()))
        {
          localPath.arcTo(b(this.l.x - f7, this.l.y - f7, this.l.x, this.l.y), 0.0F, 90.0F, false);
          localPointF = this.l;
          localPointF.x -= f6;
        }
        if ((this.m.x == localRectF.left + localRectF.width()) && (this.m.y == localRectF.top + localRectF.height()))
        {
          localPointF = this.m;
          localPointF.y -= f6;
        }
        if ((this.l.x == localRectF.left) && (this.l.y == localRectF.top + localRectF.height()))
        {
          localPath.arcTo(b(this.l.x, this.l.y - f7, this.l.x + f7, this.l.y), 90.0F, 90.0F, false);
          localPointF = this.l;
          localPointF.y -= f6;
        }
        if ((this.m.x == localRectF.left) && (this.m.y == localRectF.top + localRectF.height()))
        {
          localPointF = this.m;
          localPointF.x += f6;
        }
        localPath.lineTo(this.m.x, this.m.y);
        i += 1;
      }
      this.j[1].x = localRectF.left;
      this.j[1].y = (localRectF.top + 3.0F * localRectF.height() / 6.0F);
      this.j[2].x = localRectF.left;
      this.j[2].y = localRectF.top;
      this.j[3].x = (localRectF.left + localRectF.width());
      this.j[3].y = localRectF.top;
      this.j[4].x = (localRectF.left + localRectF.width());
      this.j[4].y = (localRectF.top + localRectF.height());
      this.j[5].x = localRectF.left;
      this.j[5].y = (localRectF.top + localRectF.height());
      this.j[6].x = localRectF.left;
      this.j[6].y = (localRectF.top + 4.0F * localRectF.height() / 6.0F);
      continue;
      if ((f3 >= 0.0F) && (f4 >= 0.0F))
      {
        if (f3 * f5 < f4)
        {
          this.j[1].x = (localRectF.left + 3.0F * localRectF.width() / 6.0F);
          this.j[1].y = (localRectF.top + localRectF.height());
          this.j[2].x = localRectF.left;
          this.j[2].y = (localRectF.top + localRectF.height());
          this.j[3].x = localRectF.left;
          this.j[3].y = localRectF.top;
          this.j[4].x = (localRectF.left + localRectF.width());
          this.j[4].y = localRectF.top;
          this.j[5].x = (localRectF.left + localRectF.width());
          this.j[5].y = (localRectF.top + localRectF.height());
          this.j[6].x = (localRectF.left + 4.0F * localRectF.width() / 6.0F);
          this.j[6].y = (localRectF.top + localRectF.height());
        }
        else
        {
          this.j[1].x = (localRectF.left + localRectF.width());
          this.j[1].y = (localRectF.top + 4.0F * localRectF.height() / 6.0F);
          this.j[2].x = (localRectF.left + localRectF.width());
          this.j[2].y = (localRectF.top + localRectF.height());
          this.j[3].x = localRectF.left;
          this.j[3].y = (localRectF.top + localRectF.height());
          this.j[4].x = localRectF.left;
          this.j[4].y = localRectF.top;
          this.j[5].x = (localRectF.left + localRectF.width());
          this.j[5].y = localRectF.top;
          this.j[6].x = (localRectF.left + localRectF.width());
          this.j[6].y = (localRectF.top + 3.0F * localRectF.height() / 6.0F);
        }
      }
      else if ((f3 < 0.0F) && (f4 < 0.0F))
      {
        if (f3 * f5 >= f4)
        {
          this.j[1].x = (localRectF.left + 3.0F * localRectF.width() / 6.0F);
          this.j[1].y = localRectF.top;
          this.j[2].x = (localRectF.left + localRectF.width());
          this.j[2].y = localRectF.top;
          this.j[3].x = (localRectF.left + localRectF.width());
          this.j[3].y = (localRectF.top + localRectF.height());
          this.j[4].x = localRectF.left;
          this.j[4].y = (localRectF.top + localRectF.height());
          this.j[5].x = localRectF.left;
          this.j[5].y = localRectF.top;
          this.j[6].x = (localRectF.left + 2.0F * localRectF.width() / 6.0F);
          this.j[6].y = localRectF.top;
        }
        else
        {
          this.j[1].x = localRectF.left;
          this.j[1].y = (localRectF.top + 2.0F * localRectF.height() / 6.0F);
          this.j[2].x = localRectF.left;
          this.j[2].y = localRectF.top;
          this.j[3].x = (localRectF.left + localRectF.width());
          this.j[3].y = localRectF.top;
          this.j[4].x = (localRectF.left + localRectF.width());
          this.j[4].y = (localRectF.top + localRectF.height());
          this.j[5].x = localRectF.left;
          this.j[5].y = (localRectF.top + localRectF.height());
          this.j[6].x = localRectF.left;
          this.j[6].y = (localRectF.top + 3.0F * localRectF.height() / 6.0F);
        }
      }
      else if ((f3 >= 0.0F) && (f4 < 0.0F))
      {
        if (-f3 * f5 >= f4)
        {
          this.j[1].x = (localRectF.left + 4.0F * localRectF.width() / 6.0F);
          this.j[1].y = localRectF.top;
          this.j[2].x = (localRectF.left + localRectF.width());
          this.j[2].y = localRectF.top;
          this.j[3].x = (localRectF.left + localRectF.width());
          this.j[3].y = (localRectF.top + localRectF.height());
          this.j[4].x = localRectF.left;
          this.j[4].y = (localRectF.top + localRectF.height());
          this.j[5].x = localRectF.left;
          this.j[5].y = localRectF.top;
          this.j[6].x = (localRectF.left + 3.0F * localRectF.width() / 6.0F);
          this.j[6].y = localRectF.top;
        }
        else
        {
          this.j[1].x = (localRectF.left + localRectF.width());
          this.j[1].y = (localRectF.top + 3.0F * localRectF.height() / 6.0F);
          this.j[2].x = (localRectF.left + localRectF.width());
          this.j[2].y = (localRectF.top + localRectF.height());
          this.j[3].x = localRectF.left;
          this.j[3].y = (localRectF.top + localRectF.height());
          this.j[4].x = localRectF.left;
          this.j[4].y = localRectF.top;
          this.j[5].x = (localRectF.left + localRectF.width());
          this.j[5].y = localRectF.top;
          this.j[6].x = (localRectF.left + localRectF.width());
          this.j[6].y = (localRectF.top + 2.0F * localRectF.height() / 6.0F);
        }
      }
      else
      {
        this.j[1].x = localRectF.left;
        this.j[1].y = localRectF.top;
        this.j[2].x = (localRectF.left + localRectF.width());
        this.j[2].y = localRectF.top;
        this.j[3].x = (localRectF.left + localRectF.width());
        this.j[3].y = (localRectF.top + localRectF.height());
        this.j[4].x = localRectF.left;
        this.j[4].y = (localRectF.top + localRectF.height());
        this.j[5].x = localRectF.left;
        this.j[5].y = localRectF.top;
        this.j[6].x = localRectF.left;
        this.j[6].y = localRectF.top;
      }
    }
    paramCanvas.drawPath(this.a, this.b);
    paramCanvas.drawPath(this.a, this.f);
  }
  
  public final void b(float paramFloat1, float paramFloat2)
  {
    int i;
    float f1;
    float f2;
    if (Math.abs(paramFloat2) < 1.0F)
    {
      i = 1;
      f1 = this.d.centerX();
      f2 = this.d.centerY();
      if (i == 0) {
        break label117;
      }
    }
    label117:
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
  
  public final float f()
  {
    return super.f() * 3.0F / 2.0F;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */