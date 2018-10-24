package com.whatsapp.statusplayback.content;

import android.content.Context;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.widget.TextView.BufferType;
import com.whatsapp.TextEmojiLabel;
import com.whatsapp.emoji.g;

public final class z
  extends TextEmojiLabel
{
  private float a;
  
  public z(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    if (this.a == 0.0F) {
      this.a = getPaint().getTextSize();
    }
    int i = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    int j = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    if ((i <= 0) || (j <= 0)) {
      return;
    }
    TextPaint localTextPaint = new TextPaint(getPaint());
    localTextPaint.setTextSize(this.a);
    CharSequence localCharSequence2 = getText();
    TransformationMethod localTransformationMethod = getTransformationMethod();
    CharSequence localCharSequence1 = localCharSequence2;
    if (localTransformationMethod != null) {
      localCharSequence1 = localTransformationMethod.getTransformation(localCharSequence2, this);
    }
    while (localTextPaint.getTextSize() > 2.0F)
    {
      g.a(localCharSequence1, localTextPaint);
      if (new StaticLayout(localCharSequence1, localTextPaint, i, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, true).getHeight() <= j) {
        break;
      }
      localTextPaint.setTextSize(localTextPaint.getTextSize() - 1.0F);
    }
    super.setTextSize(0, localTextPaint.getTextSize());
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      a();
    }
  }
  
  protected final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    a();
  }
  
  public final void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    super.setText(paramCharSequence, paramBufferType);
    a();
  }
  
  public final void setTextSize(int paramInt, float paramFloat)
  {
    super.setTextSize(paramInt, paramFloat);
    this.a = getPaint().getTextSize();
    a();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/content/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */