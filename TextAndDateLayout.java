package com.whatsapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.whatsapp.util.Log;

public class TextAndDateLayout
  extends FrameLayout
{
  private final pv a;
  
  public TextAndDateLayout(Context paramContext)
  {
    super(paramContext);
    if (isInEditMode()) {}
    for (paramContext = null;; paramContext = pv.a())
    {
      this.a = paramContext;
      return;
    }
  }
  
  public TextAndDateLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {}
    for (paramContext = null;; paramContext = pv.a())
    {
      this.a = paramContext;
      return;
    }
  }
  
  public TextAndDateLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode()) {}
    for (paramContext = null;; paramContext = pv.a())
    {
      this.a = paramContext;
      return;
    }
  }
  
  @TargetApi(21)
  public TextAndDateLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    if (isInEditMode()) {}
    for (paramContext = null;; paramContext = pv.a())
    {
      this.a = paramContext;
      return;
    }
  }
  
  private int getLastParagraphDirection()
  {
    Object localObject = (TextView)getChildAt(0);
    if (al.a(this.a))
    {
      localObject = ((TextView)localObject).getLayout();
      return ((Layout)localObject).getParagraphDirection(((Layout)localObject).getLineCount() - 1);
    }
    if ((((TextView)localObject).getGravity() & 0x7) == 5) {
      return -1;
    }
    return 1;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 1;
    TextView localTextView = (TextView)getChildAt(0);
    View localView = getChildAt(1);
    int i;
    if (localTextView.getLayout() == null)
    {
      i = 1;
      super.onMeasure(paramInt1, paramInt2);
      if (View.MeasureSpec.getMode(paramInt2) != 1073741824) {
        break label51;
      }
    }
    label51:
    while (localTextView.getVisibility() == 8)
    {
      return;
      i = 0;
      break;
    }
    paramInt2 = View.MeasureSpec.getSize(paramInt1);
    Layout localLayout = localTextView.getLayout();
    if (localLayout == null)
    {
      Log.e("TextAndDateLayout/onMeasure/error getting textView layout");
      return;
    }
    int k;
    if (localLayout.getLineCount() > 1)
    {
      paramInt1 = localLayout.getLineStart(localLayout.getLineCount() - 1);
      k = localLayout.getLineEnd(localLayout.getLineCount() - 1);
      k = (int)Layout.getDesiredWidth(localTextView.getText().subSequence(paramInt1, k), localTextView.getPaint());
      paramInt1 = localTextView.getMeasuredWidth();
      if ((i != 0) || (localTextView.getText() == null) || (TextUtils.indexOf(localTextView.getText(), '\n') < 0)) {
        break label441;
      }
      paramInt1 = Math.min(paramInt1, (int)Math.ceil(Layout.getDesiredWidth(localTextView.getText(), localTextView.getPaint())) + localTextView.getPaddingRight() + localTextView.getPaddingLeft());
    }
    label352:
    label441:
    for (;;)
    {
      if (paramInt2 - getPaddingLeft() - getPaddingRight() >= localView.getMeasuredWidth() + paramInt1)
      {
        setMeasuredDimension(localView.getMeasuredWidth() + paramInt1 + getPaddingLeft() + getPaddingRight(), getMeasuredHeight());
        return;
      }
      if (paramInt1 - localTextView.getPaddingLeft() - localTextView.getPaddingRight() >= localView.getMeasuredWidth() + k)
      {
        if (isInEditMode()) {
          break label352;
        }
        paramInt2 = getLastParagraphDirection();
        if (paramInt2 == -1)
        {
          paramInt1 = j;
          if (this.a.d()) {}
        }
        else
        {
          if ((paramInt2 != 1) || (this.a.d())) {
            break label352;
          }
        }
      }
      for (paramInt1 = j; paramInt1 != 0; paramInt1 = 0)
      {
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() + localView.getMeasuredHeight());
        return;
      }
      break;
      if (paramInt2 - getPaddingLeft() - getPaddingRight() >= localTextView.getMeasuredWidth() + localView.getMeasuredWidth())
      {
        paramInt1 = localTextView.getMeasuredWidth() + localView.getMeasuredWidth() + getPaddingLeft() + getPaddingRight();
        if (paramInt1 <= getMeasuredWidth()) {
          break;
        }
        setMeasuredDimension(paramInt1, getMeasuredHeight());
        return;
      }
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() + localView.getMeasuredHeight());
      return;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/TextAndDateLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */