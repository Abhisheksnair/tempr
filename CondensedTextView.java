package com.whatsapp;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class CondensedTextView
  extends TextView
{
  private TextPaint a;
  private float b = 0.8F;
  
  public CondensedTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CondensedTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CondensedTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(String paramString)
  {
    if ((this.a == null) || (this.a.getTextSize() != getPaint().getTextSize()))
    {
      this.a = new TextPaint(getPaint());
      this.a.setTextScaleX(1.0F);
    }
    float f1 = this.a.measureText(paramString);
    if (f1 > 0.0F)
    {
      int i = getMeasuredWidth() - getCompoundPaddingLeft() - getCompoundPaddingRight();
      if (i > 0)
      {
        f1 = i / f1;
        if (f1 >= 1.0F) {
          break label169;
        }
        f2 = Math.max(this.b, f1);
        setTextScaleX(f2);
        for (f1 = getPaint().measureText(paramString); (f1 > i) && (f2 > this.b); f1 = getPaint().measureText(paramString))
        {
          f2 *= 0.99F;
          setTextScaleX(f2);
        }
        setSingleLine(true);
        setHorizontallyScrolling(false);
      }
    }
    label169:
    while (getTextScaleX() == 1.0F)
    {
      float f2;
      return;
    }
    setTextScaleX(1.0F);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      a(getText().toString());
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    a(getText().toString());
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    super.setText(paramCharSequence, paramBufferType);
    a(paramCharSequence.toString());
  }
  
  public void setTextScaleLimit(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    super.setTextSize(paramInt, paramFloat);
    this.a.setTextSize(getPaint().getTextSize());
    a(getText().toString());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/CondensedTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */