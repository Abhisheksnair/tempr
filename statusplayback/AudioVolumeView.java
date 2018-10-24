package com.whatsapp.statusplayback;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class AudioVolumeView
  extends View
{
  private final Paint a = new Paint(1);
  private final RectF b = new RectF();
  private final Path c = new Path();
  private final int d = 8;
  private final int e = 51;
  private final int f = 255;
  private float g;
  
  public AudioVolumeView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AudioVolumeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AudioVolumeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  @TargetApi(21)
  public AudioVolumeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a.setStrokeCap(Paint.Cap.ROUND);
    this.a.setStrokeJoin(Paint.Join.ROUND);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setColor(-1);
    this.a.setStrokeWidth(paramContext.getResources().getDimension(2131361895));
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    float f1 = getHeight() - getPaddingTop() - getPaddingBottom();
    float f2 = 1.5F * f1;
    this.b.set(0.0F, (f1 - f2) / 2.0F, f2, (f1 + f2) / 2.0F);
    paramCanvas.translate(getPaddingLeft(), getPaddingTop());
    f2 = this.a.getStrokeWidth();
    this.c.reset();
    this.c.moveTo(f2, f1 / 3.0F);
    this.c.lineTo(f1 / 3.0F, f1 / 3.0F);
    this.c.lineTo(f1 * 2.0F / 3.0F, f2 + 0.0F);
    this.c.lineTo(f1 * 2.0F / 3.0F, f1 - f2);
    this.c.lineTo(f1 / 3.0F, f1 * 2.0F / 3.0F);
    this.c.lineTo(f2, f1 * 2.0F / 3.0F);
    this.c.lineTo(f2, f1 / 3.0F);
    this.a.setColor(-1);
    paramCanvas.drawPath(this.c, this.a);
    paramCanvas.translate(-f1 / 2.0F + f2, 0.0F);
    int j = 0;
    if (j < 8)
    {
      int i;
      if (this.g < j * 1.0F / 8.0F) {
        i = 51;
      }
      for (;;)
      {
        this.a.setColor(i << 24 | 0xFFFFFF);
        paramCanvas.drawArc(this.b, -33.0F, 66.0F, false, this.a);
        paramCanvas.translate(this.a.getStrokeWidth() * 3.0F, 0.0F);
        j += 1;
        break;
        if (this.g > (j + 1) * 1.0F / 8.0F) {
          i = 255;
        } else {
          i = (int)((this.g - j * 1.0F / 8.0F) * 8.0F * 204.0F) + 51;
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension((int)(getMeasuredHeight() - getPaddingTop() - getPaddingBottom() + 8.0F * (this.a.getStrokeWidth() * 3.0F) + getPaddingLeft() + getPaddingRight()) + 1, getMeasuredHeight());
  }
  
  public void setVolume(float paramFloat)
  {
    this.g = paramFloat;
    invalidate();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/AudioVolumeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */