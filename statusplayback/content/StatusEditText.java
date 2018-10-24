package com.whatsapp.statusplayback.content;

import android.content.Context;
import android.text.Editable;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.whatsapp.MentionableEntry;
import com.whatsapp.emoji.g;

public class StatusEditText
  extends MentionableEntry
{
  private float e;
  
  public StatusEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public StatusEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StatusEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void b()
  {
    if (this.e == 0.0F) {
      this.e = getPaint().getTextSize();
    }
    int i = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    int j = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    if ((i <= 0) || (j <= 0)) {
      return;
    }
    TextPaint localTextPaint = new TextPaint(getPaint());
    localTextPaint.setTextSize(this.e);
    Editable localEditable = getText();
    TransformationMethod localTransformationMethod = getTransformationMethod();
    Object localObject = localEditable;
    if (localTransformationMethod != null) {
      localObject = localTransformationMethod.getTransformation(localEditable, this);
    }
    while (localTextPaint.getTextSize() > 2.0F)
    {
      g.a((CharSequence)localObject, localTextPaint);
      if (new StaticLayout((CharSequence)localObject, localTextPaint, i, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, true).getHeight() <= j) {
        break;
      }
      localTextPaint.setTextSize(localTextPaint.getTextSize() - 1.0F);
    }
    super.setTextSize(0, localTextPaint.getTextSize());
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))
    {
      b();
      paramInt1 = getSelectionStart();
      paramInt2 = getSelectionEnd();
      if ((paramInt1 >= 0) && (paramInt2 >= 0))
      {
        setSelection(0);
        post(b.a(this, paramInt1, paramInt2));
      }
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    b();
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    super.setText(paramCharSequence, paramBufferType);
    b();
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    super.setTextSize(paramInt, paramFloat);
    this.e = getPaint().getTextSize();
    b();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/content/StatusEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */