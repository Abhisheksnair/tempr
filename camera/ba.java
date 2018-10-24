package com.whatsapp.camera;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.text.TextPaint;
import android.view.View;

public final class ba
  extends View
{
  float a;
  float b;
  Runnable c = new Runnable()
  {
    public final void run()
    {
      ba.this.setVisibility(8);
    }
  };
  private RectF d = new RectF();
  private Paint e = new Paint(1);
  private TextPaint f = new TextPaint(1);
  
  public ba(Context paramContext)
  {
    super(paramContext);
  }
  
  public final float getMaxScale()
  {
    return Math.min(getWidth() / 2, getHeight() / 2) * 0.9F / this.f.measureText("x00.0");
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    this.e.setStrokeWidth(getContext().getResources().getDimension(2131361898));
    this.e.setStyle(Paint.Style.STROKE);
    this.e.setColor(-1711276033);
    int i = getWidth() / 2;
    int j = getHeight() / 2;
    float f1 = Math.min(i, j) * 0.9F;
    this.d.set(i - f1, j - f1, i + f1, j + f1);
    paramCanvas.drawOval(this.d, this.e);
    float f2 = getResources().getDimension(2131361796);
    this.f.setTextSize(f2);
    this.f.setColor(-1711276033);
    this.f.setTextAlign(Paint.Align.CENTER);
    this.f.setFakeBoldText(true);
    String str = "x" + String.format("%.1f", new Object[] { Float.valueOf(this.b) });
    float f3 = i;
    float f4 = j;
    paramCanvas.drawText(str, f3, f2 / 2.0F + f4, this.f);
    f2 = this.f.measureText("x00.0");
    this.d.set(i - f2, j - f2, i + f2, j + f2);
    paramCanvas.drawOval(this.d, this.e);
    f2 *= this.a;
    if (f2 > f1) {}
    for (;;)
    {
      this.e.setColor(-13388315);
      this.d.set(i - f1, j - f1, i + f1, f1 + j);
      paramCanvas.drawOval(this.d, this.e);
      return;
      f1 = f2;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/camera/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */