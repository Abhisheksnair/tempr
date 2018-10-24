package com.whatsapp.location;

import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.whatsapp.aoa;

final class cd
  extends Drawable
{
  int a = 18;
  private int b = 16842921;
  private float c = 3.0F;
  private Paint d = new Paint(1);
  
  public final void draw(Canvas paramCanvas)
  {
    this.d.setARGB(255, 0, 0, 0);
    Object localObject = getBounds();
    int i = ((Rect)localObject).width();
    int j = ((Rect)localObject).height();
    float f1 = i - this.c * 2.0F;
    float f2 = j - this.c * 2.0F;
    localObject = new Path();
    i = (int)(aoa.a().a * 2.0F);
    ((Path)localObject).moveTo(f1 / 2.0F - this.a * 2 / 3, f2 - this.a);
    ((Path)localObject).lineTo(f1 / 2.0F, f2);
    ((Path)localObject).lineTo(f1 / 2.0F + this.a * 2 / 3, f2 - this.a);
    ((Path)localObject).lineTo(f1 - i, f2 - this.a);
    ((Path)localObject).arcTo(new RectF(f1 - i * 2, f2 - this.a - i * 2, f1, f2 - this.a), 90.0F, -90.0F);
    ((Path)localObject).lineTo(f1, i);
    ((Path)localObject).arcTo(new RectF(f1 - i * 2, 0.0F, f1, i * 2), 0.0F, -90.0F);
    ((Path)localObject).lineTo(i, 0.0F);
    ((Path)localObject).arcTo(new RectF(0.0F, 0.0F, i * 2, i * 2), -90.0F, -90.0F);
    ((Path)localObject).lineTo(0.0F, f2 - this.a - i);
    ((Path)localObject).arcTo(new RectF(0.0F, f2 - this.a - i * 2, i * 2, f2 - this.a), -180.0F, -90.0F);
    ((Path)localObject).close();
    ((Path)localObject).setFillType(Path.FillType.WINDING);
    BlurMaskFilter localBlurMaskFilter = new BlurMaskFilter(this.c, BlurMaskFilter.Blur.NORMAL);
    this.d.setColor(-1724697805);
    this.d.setStyle(Paint.Style.FILL);
    this.d.setMaskFilter(localBlurMaskFilter);
    paramCanvas.translate(this.c, this.c * 1.5F);
    paramCanvas.drawPath((Path)localObject, this.d);
    paramCanvas.translate(-this.c, -this.c * 1.5F);
    paramCanvas.translate(this.c, this.c);
    if (this.b == 16842919) {
      this.d.setColor(-13388315);
    }
    for (;;)
    {
      this.d.setMaskFilter(null);
      paramCanvas.drawPath((Path)localObject, this.d);
      if (this.b == 16842913)
      {
        this.d.setStrokeWidth(this.c);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setColor(-13388315);
        paramCanvas.drawPath((Path)localObject, this.d);
      }
      paramCanvas.translate(-this.c, -this.c);
      return;
      this.d.setColor(-1);
    }
  }
  
  public final int getOpacity()
  {
    return 0;
  }
  
  public final boolean getPadding(Rect paramRect)
  {
    paramRect.top = ((int)this.c);
    paramRect.bottom = (this.a + (int)this.c);
    paramRect.left = ((int)this.c);
    paramRect.right = ((int)this.c);
    return true;
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
    int j = this.b;
    this.b = 16842921;
    int k = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      int m;
      if (i < k)
      {
        m = paramArrayOfInt[i];
        if (m != 16842919) {
          break label62;
        }
      }
      for (this.b = 16842919;; this.b = 16842913)
      {
        if (j != this.b)
        {
          invalidateSelf();
          bool = true;
        }
        return bool;
        label62:
        if (m != 16842913) {
          break;
        }
      }
      if (m == 16842908) {
        this.b = 16842908;
      }
      i += 1;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/location/cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */