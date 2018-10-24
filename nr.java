package com.whatsapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.InsetDrawable;
import android.support.v4.content.b;
import android.text.TextPaint;
import android.text.TextUtils;

public final class nr
  extends InsetDrawable
{
  private TextPaint a = new TextPaint();
  private String b;
  private int c;
  
  public nr(Context paramContext, int paramInt, String paramString)
  {
    super(b.a(paramContext, paramInt), 0);
    this.b = paramString;
    this.a.setAntiAlias(true);
    this.a.setColor(b.c(paramContext, 17170443));
    this.a.setTextSize(paramContext.getResources().getDimensionPixelSize(2131362108));
    this.a.setTextAlign(Paint.Align.CENTER);
    this.a.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
  }
  
  public final void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (!TextUtils.isEmpty(this.b))
    {
      if (this.c != getBounds().width())
      {
        float f1 = getBounds().width() / this.b.length();
        this.c = getBounds().width();
        this.a.setTextSize(f1);
        float f2 = this.c * 17 / 24 / this.a.measureText(this.b);
        this.a.setTextSize(f1 * f2);
      }
      paramCanvas.drawText(this.b, getBounds().centerX(), getBounds().centerY() + 2.0F * this.a.getTextSize() / 3.0F, this.a);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/nr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */