package com.whatsapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;

public final class atw
  extends View
{
  private byte[] a = null;
  private float[] b;
  private Rect c = new Rect();
  private Paint d = new Paint();
  
  public atw(Context paramContext)
  {
    super(paramContext);
    this.d.setStrokeWidth(2.0F);
    this.d.setStyle(Paint.Style.STROKE);
    this.d.setStrokeJoin(Paint.Join.ROUND);
    this.d.setStrokeCap(Paint.Cap.ROUND);
    this.d.setAntiAlias(true);
    this.d.setColor(Color.rgb(0, 128, 255));
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
    invalidate();
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    super.onDraw(paramCanvas);
    if (this.a == null) {
      return;
    }
    if ((this.b == null) || (this.b.length < this.a.length << 2)) {
      this.b = new float[this.a.length << 2];
    }
    this.c.set(0, 0, getWidth(), getHeight());
    Object localObject = this.c;
    ((Rect)localObject).top += getPaddingTop();
    localObject = this.c;
    ((Rect)localObject).bottom -= getPaddingBottom();
    localObject = this.c;
    ((Rect)localObject).left += getPaddingLeft();
    localObject = this.c;
    ((Rect)localObject).right -= getPaddingRight();
    localObject = new Path();
    ((Path)localObject).moveTo(this.c.left, this.c.top + this.c.height() / 2 + (byte)(this.a[0] + 128) * (this.c.height() / 2) / 128);
    while (i < this.a.length - 1)
    {
      ((Path)localObject).lineTo(this.c.left + this.c.width() * i / (this.a.length - 1), this.c.top + this.c.height() / 2 + (byte)(this.a[i] + 128) * (this.c.height() / 2) / 128);
      i += 1;
    }
    paramCanvas.drawPath((Path)localObject, this.d);
  }
  
  public final void setColor(int paramInt)
  {
    this.d.setColor(paramInt);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/atw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */