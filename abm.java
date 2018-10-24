package com.whatsapp;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public final class abm
  extends Drawable
{
  private final Paint a = new Paint(1);
  private final Path b = new Path();
  private final RectF c = new RectF();
  private int d;
  
  public abm(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int i = localRect.width();
    int j = localRect.height();
    this.b.rewind();
    if (i > j)
    {
      this.b.moveTo(j / 2, 0.0F);
      this.b.lineTo(i - j / 2, 0.0F);
      this.c.set(i - j, 0.0F, i, j);
      this.b.arcTo(this.c, -90.0F, 180.0F);
      this.b.lineTo(j / 2, j);
      this.c.set(0.0F, 0.0F, j, j);
      this.b.arcTo(this.c, 90.0F, 180.0F);
    }
    for (;;)
    {
      this.b.close();
      this.b.setFillType(Path.FillType.WINDING);
      this.a.setColor(this.d);
      this.a.setStyle(Paint.Style.FILL);
      paramCanvas.translate(localRect.left, localRect.top);
      paramCanvas.drawPath(this.b, this.a);
      paramCanvas.translate(-localRect.left, -localRect.top);
      return;
      if (i < j)
      {
        this.b.moveTo(0.0F, i / 2);
        this.b.lineTo(0.0F, j - i / 2);
        this.c.set(0.0F, j - i, i, j);
        this.b.arcTo(this.c, -180.0F, -180.0F);
        this.b.lineTo(i, i / 2);
        this.c.set(0.0F, 0.0F, i, i);
        this.b.arcTo(this.c, 0.0F, -180.0F);
      }
      else
      {
        this.c.set(0.0F, 0.0F, i, j);
        this.b.addOval(this.c, Path.Direction.CW);
      }
    }
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/abm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */