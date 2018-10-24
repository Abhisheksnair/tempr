package com.whatsapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.StaticLayout.Builder;
import android.text.TextPaint;
import android.text.TextUtils;
import com.whatsapp.emoji.c;
import com.whatsapp.emoji.g;
import com.whatsapp.util.be;

public final class ahd
  extends Drawable
{
  static final a b = new c((byte)0);
  public float a;
  private final CharSequence c;
  private final TextData d;
  private final Paint e = new Paint(1);
  private Layout f;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      b = new b((byte)0);
      return;
    }
  }
  
  public ahd(Context paramContext, and paramand, CharSequence paramCharSequence, TextData paramTextData)
  {
    this.c = be.a(paramContext, paramand, c.a(paramCharSequence, paramContext));
    this.d = paramTextData;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    Paint localPaint = this.e;
    if ((this.d != null) && (this.d.backgroundColor != 0)) {}
    for (int i = this.d.backgroundColor;; i = 1711276032)
    {
      localPaint.setColor(i);
      this.e.setStyle(Paint.Style.FILL);
      paramCanvas.drawCircle(localRect.centerX(), localRect.centerY(), localRect.width() / 2 - this.a, this.e);
      if (this.f != null)
      {
        paramCanvas.translate((localRect.width() - this.f.getWidth()) / 2, (localRect.height() - this.f.getHeight()) / 2);
        this.f.draw(paramCanvas);
      }
      return;
    }
  }
  
  public final int getOpacity()
  {
    return -3;
  }
  
  public final void setAlpha(int paramInt) {}
  
  public final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt3 = (int)((paramInt3 - paramInt1 - this.a * 2.0F) / Math.sqrt(2.0D));
    paramInt2 = (int)((paramInt4 - paramInt2 - this.a * 2.0F) / Math.sqrt(2.0D));
    TextPaint localTextPaint = new TextPaint(1);
    localTextPaint.setTextSize(paramInt2 / 2);
    Object localObject;
    if ((this.d != null) && (this.d.textColor != 0))
    {
      paramInt1 = this.d.textColor;
      localTextPaint.setColor(paramInt1);
      if ((this.d == null) || (this.d.fontStyle != 1)) {
        break label227;
      }
      localObject = Typeface.SERIF;
      label125:
      localTextPaint.setTypeface((Typeface)localObject);
      localObject = this.c;
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      g.a((CharSequence)localObject, localTextPaint);
      this.f = b.a((CharSequence)localObject, localTextPaint, paramInt3);
      if (this.f.getHeight() <= paramInt2) {
        return;
      }
      if (localTextPaint.getTextSize() < Math.max(2, paramInt2 / 8))
      {
        localObject = ((CharSequence)localObject).subSequence(0, ((CharSequence)localObject).length() / 2);
        continue;
        paramInt1 = -1;
        break;
        label227:
        localObject = Typeface.SANS_SERIF;
        break label125;
      }
      localTextPaint.setTextSize(localTextPaint.getTextSize() - 1.0F);
    }
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter) {}
  
  static abstract interface a
  {
    public abstract Layout a(CharSequence paramCharSequence, TextPaint paramTextPaint, int paramInt);
  }
  
  static final class b
    implements ahd.a
  {
    @TargetApi(23)
    public final Layout a(CharSequence paramCharSequence, TextPaint paramTextPaint, int paramInt)
    {
      return StaticLayout.Builder.obtain(paramCharSequence, 0, paramCharSequence.length(), paramTextPaint, paramInt).setAlignment(Layout.Alignment.ALIGN_CENTER).setBreakStrategy(1).build();
    }
  }
  
  static final class c
    implements ahd.a
  {
    public final Layout a(CharSequence paramCharSequence, TextPaint paramTextPaint, int paramInt)
    {
      return new StaticLayout(paramCharSequence, paramTextPaint, paramInt, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, true);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ahd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */