package com.whatsapp.emoji;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.whatsapp.aoa;
import com.whatsapp.util.bh;

public class j
  extends bh
{
  Paint.FontMetricsInt a;
  int b = -1;
  
  public j(Drawable paramDrawable, Paint.FontMetricsInt paramFontMetricsInt)
  {
    super(paramDrawable);
    this.a = paramFontMetricsInt;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4, paramInt5, paramPaint);
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramPaint = a().getBounds();
    if (paramFontMetricsInt != null)
    {
      paramInt1 = Math.max(0, paramPaint.height() - this.a.descent + this.a.ascent);
      paramFontMetricsInt.ascent = (this.a.ascent - paramInt1);
      paramFontMetricsInt.descent = (this.a.descent + paramInt1);
      paramFontMetricsInt.top = (this.a.top - paramInt1);
      paramFontMetricsInt.bottom = (paramInt1 + this.a.bottom);
    }
    return paramPaint.right + (int)aoa.a().a;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/emoji/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */