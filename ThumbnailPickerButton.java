package com.whatsapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

public class ThumbnailPickerButton
  extends ThumbnailButton
{
  private Path a = new Path();
  
  public ThumbnailPickerButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public ThumbnailPickerButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ThumbnailPickerButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final void a(Canvas paramCanvas)
  {
    super.a(paramCanvas);
    if ((isEnabled()) && (this.b > 0.0F))
    {
      float f = 7.0F * this.b;
      this.a.reset();
      this.h.setStyle(Paint.Style.FILL);
      this.a.moveTo(this.i.right, this.i.bottom - f);
      this.a.lineTo(this.i.right, this.i.bottom - this.b);
      this.a.arcTo(new RectF(this.i.right - this.b * 2.0F, this.i.bottom - this.b * 2.0F, this.i.right, this.i.bottom), 0.0F, 90.0F);
      this.a.lineTo(this.i.right - f, this.i.bottom);
      this.a.lineTo(this.i.right, this.i.bottom - f);
      this.h.setColor(1409286144);
      paramCanvas.drawPath(this.a, this.h);
      this.a.reset();
      this.a.moveTo(this.i.right, this.i.bottom - f);
      this.a.lineTo(this.i.right - f, this.i.bottom);
      this.h.setStyle(Paint.Style.STROKE);
      this.h.setStrokeJoin(Paint.Join.ROUND);
      this.h.setStrokeCap(Paint.Cap.ROUND);
      this.h.setStrokeWidth(1.0F * aoa.a().a);
      this.h.setColor(-570425345);
      paramCanvas.drawPath(this.a, this.h);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ThumbnailPickerButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */