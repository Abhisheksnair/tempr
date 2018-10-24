package com.whatsapp;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public final class yq
  extends MetricAffectingSpan
{
  private static void a(Paint paramPaint)
  {
    Typeface localTypeface = paramPaint.getTypeface();
    if (localTypeface == null) {}
    for (int i = 0;; i = localTypeface.getStyle())
    {
      localTypeface = aoa.d();
      i &= (localTypeface.getStyle() ^ 0xFFFFFFFF);
      if ((i & 0x1) != 0) {
        paramPaint.setFakeBoldText(true);
      }
      if ((i & 0x2) != 0) {
        paramPaint.setTextSkewX(-0.25F);
      }
      paramPaint.setTypeface(localTypeface);
      return;
    }
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    a(paramTextPaint);
  }
  
  public final void updateMeasureState(TextPaint paramTextPaint)
  {
    a(paramTextPaint);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/yq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */