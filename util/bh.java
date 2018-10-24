package com.whatsapp.util;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import java.lang.ref.WeakReference;

public class bh
  extends ImageSpan
{
  private WeakReference<Drawable> a;
  
  public bh(Drawable paramDrawable)
  {
    super(paramDrawable);
  }
  
  public static CharSequence a(CharSequence paramCharSequence, Drawable paramDrawable, Paint paramPaint)
  {
    int i = TextUtils.indexOf(paramCharSequence, "%s");
    return a(paramCharSequence, paramDrawable, paramPaint, i, "%s".length() + i);
  }
  
  public static CharSequence a(CharSequence paramCharSequence, Drawable paramDrawable, Paint paramPaint, int paramInt1, int paramInt2)
  {
    paramCharSequence = new SpannableStringBuilder(paramCharSequence);
    int i = (int)paramPaint.getTextSize();
    paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth() * i / paramDrawable.getIntrinsicHeight(), i);
    paramCharSequence.setSpan(new bh(paramDrawable), paramInt1, paramInt2, 33);
    return paramCharSequence;
  }
  
  public static CharSequence b(CharSequence paramCharSequence, Drawable paramDrawable, Paint paramPaint)
  {
    return a("  " + paramCharSequence, paramDrawable, paramPaint, 0, 1);
  }
  
  public final Drawable a()
  {
    Object localObject = this.a;
    Drawable localDrawable = null;
    if (localObject != null) {
      localDrawable = (Drawable)((WeakReference)localObject).get();
    }
    localObject = localDrawable;
    if (localDrawable == null)
    {
      localObject = getDrawable();
      this.a = new WeakReference(localObject);
    }
    return (Drawable)localObject;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = a();
    paramCanvas.save();
    Rect localRect = paramCharSequence.getBounds();
    paramPaint = paramPaint.getFontMetrics();
    float f1 = paramInt4;
    float f2 = paramPaint.ascent;
    paramCanvas.translate(paramFloat, (paramPaint.descent + f2 - localRect.height()) / 2.0F + f1);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */