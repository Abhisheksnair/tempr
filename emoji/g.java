package com.whatsapp.emoji;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import android.text.style.ImageSpan;
import com.whatsapp.aoa;

public class g
  implements e
{
  private final Paint a;
  private float b = 1.0F;
  
  public g(Paint paramPaint)
  {
    this.a = paramPaint;
  }
  
  public g(Paint paramPaint, float paramFloat)
  {
    this.a = paramPaint;
    this.b = paramFloat;
  }
  
  private static int a(float paramFloat)
  {
    return (int)(1.1F * paramFloat + 0.5F);
  }
  
  public static void a(CharSequence paramCharSequence, Paint paramPaint)
  {
    if ((paramCharSequence instanceof Spanned))
    {
      Paint.FontMetricsInt localFontMetricsInt = paramPaint.getFontMetricsInt();
      int j = a(paramPaint.getTextSize());
      paramCharSequence = (j[])((Spanned)paramCharSequence).getSpans(0, paramCharSequence.length(), j.class);
      if (paramCharSequence != null)
      {
        int k = paramCharSequence.length;
        int i = 0;
        while (i < k)
        {
          paramPaint = paramCharSequence[i];
          paramPaint.a = localFontMetricsInt;
          paramPaint.a().setBounds(0, 0, j, j);
          i += 1;
        }
      }
    }
  }
  
  public final Drawable a(Drawable paramDrawable, Context paramContext)
  {
    if (this.a.getFontMetrics() != null) {}
    for (int i = (int)(this.b * this.a.getTextSize() * 1.1F + 0.5F);; i = (int)aoa.b(paramContext))
    {
      paramDrawable.setBounds(0, 0, i, i);
      return paramDrawable;
    }
  }
  
  public final ImageSpan a(Drawable paramDrawable)
  {
    j localj = null;
    if (this.a != null) {}
    for (Paint.FontMetricsInt localFontMetricsInt = this.a.getFontMetricsInt();; localFontMetricsInt = null)
    {
      if (localFontMetricsInt != null)
      {
        int i = a(this.b * this.a.getTextSize());
        paramDrawable.setBounds(0, 0, i, i);
        localj = new j(paramDrawable, localFontMetricsInt);
      }
      return localj;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/emoji/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */