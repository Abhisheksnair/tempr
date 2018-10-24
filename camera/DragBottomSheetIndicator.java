package com.whatsapp.camera;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class DragBottomSheetIndicator
  extends View
{
  private final Paint a = new Paint(1);
  private final Paint b = new Paint(1);
  private final Path c = new Path();
  private float d;
  private long e;
  private float f;
  private long g;
  private boolean h;
  
  public DragBottomSheetIndicator(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public DragBottomSheetIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public DragBottomSheetIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  @TargetApi(21)
  public DragBottomSheetIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeCap(Paint.Cap.SQUARE);
    this.a.setStrokeWidth(paramContext.getResources().getDisplayMetrics().density * 2.0F);
    this.a.setColor(-1);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeCap(Paint.Cap.ROUND);
    this.b.setStrokeJoin(Paint.Join.ROUND);
    this.b.setStrokeWidth(paramContext.getResources().getDisplayMetrics().density * 4.0F);
    this.b.setColor(855638016);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    float f1 = 1.0F;
    super.onDraw(paramCanvas);
    float f2 = 1000.0F * (this.d - this.f) / (float)(SystemClock.elapsedRealtime() - this.g);
    if (f2 > 1.0F) {}
    for (;;)
    {
      f2 = f1;
      if (f1 > 0.0F) {
        f2 = f1 / 2.0F;
      }
      int i = getPaddingLeft();
      int j = getPaddingTop();
      int k = getWidth() - getPaddingRight();
      int m = getHeight() - getPaddingBottom();
      paramCanvas.translate(0.0F, -getHeight());
      this.c.reset();
      this.c.moveTo(i, (m + j) / 2 + (m - j) * f2);
      this.c.lineTo((i + k) / 2, j);
      Path localPath = this.c;
      f1 = k;
      float f3 = (m + j) / 2;
      localPath.lineTo(f1, f2 * (m - j) + f3);
      paramCanvas.drawPath(this.c, this.b);
      paramCanvas.drawPath(this.c, this.a);
      paramCanvas.translate(0.0F, getHeight());
      if (this.h) {
        invalidate();
      }
      return;
      if (f2 < -1.0F) {
        f1 = -1.0F;
      } else {
        f1 = f2;
      }
    }
  }
  
  public void setOffset(float paramFloat)
  {
    this.g = this.e;
    this.f = this.d;
    this.e = SystemClock.elapsedRealtime();
    this.d = paramFloat;
    invalidate();
  }
  
  public void setUpdating(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (paramBoolean) {
      invalidate();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/camera/DragBottomSheetIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */