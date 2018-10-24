package com.whatsapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.whatsapp.util.Log;

public class IconTextAndDateLayout
  extends FrameLayout
{
  private final pv a;
  
  public IconTextAndDateLayout(Context paramContext)
  {
    super(paramContext);
    if (isInEditMode()) {}
    for (paramContext = null;; paramContext = pv.a())
    {
      this.a = paramContext;
      return;
    }
  }
  
  public IconTextAndDateLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {}
    for (paramContext = null;; paramContext = pv.a())
    {
      this.a = paramContext;
      return;
    }
  }
  
  public IconTextAndDateLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
  public IconTextAndDateLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    if (isInEditMode()) {}
    for (paramContext = null;; paramContext = pv.a())
    {
      this.a = paramContext;
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject = (LinearLayout)getChildAt(0);
    View localView = getChildAt(1);
    super.onMeasure(paramInt1, paramInt2);
    ImageView localImageView = (ImageView)((LinearLayout)localObject).getChildAt(0);
    TextView localTextView = (TextView)((LinearLayout)localObject).getChildAt(1);
    int i;
    if (localTextView.getLayout() == null)
    {
      i = 1;
      if (View.MeasureSpec.getMode(paramInt2) != 1073741824) {
        break label70;
      }
    }
    label70:
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
      Log.e("IconTextAndDateLayout/onMeasure/error getting textView layout");
      return;
    }
    paramInt1 = ((LinearLayout)localObject).getMeasuredWidth();
    int j;
    int k;
    if (localLayout.getLineCount() > 1)
    {
      j = localLayout.getLineStart(localLayout.getLineCount() - 1);
      k = localLayout.getLineEnd(localLayout.getLineCount() - 1);
      j = (int)Layout.getDesiredWidth(localTextView.getText().subSequence(j, k), localTextView.getPaint());
      k = localImageView.getMeasuredWidth();
      if ((i != 0) || (localTextView.getText() == null) || (TextUtils.indexOf(localTextView.getText(), '\n') < 0)) {
        break label512;
      }
      paramInt1 = Math.min(paramInt1, (int)Math.ceil(Layout.getDesiredWidth(localTextView.getText(), localTextView.getPaint())) + localTextView.getPaddingRight() + localTextView.getPaddingLeft());
    }
    label409:
    label431:
    label434:
    label512:
    for (;;)
    {
      if (paramInt2 - getPaddingLeft() - getPaddingRight() >= localView.getMeasuredWidth() + paramInt1)
      {
        setMeasuredDimension(localView.getMeasuredWidth() + paramInt1 + getPaddingLeft() + getPaddingRight(), getMeasuredHeight());
        return;
      }
      if (paramInt1 - ((LinearLayout)localObject).getPaddingLeft() - ((LinearLayout)localObject).getPaddingRight() >= localView.getMeasuredWidth() + (j + k))
      {
        if ((isInEditMode()) || (localTextView == null)) {
          break label431;
        }
        if (!al.a(this.a)) {
          break label409;
        }
        localObject = localTextView.getLayout();
        paramInt1 = ((Layout)localObject).getParagraphDirection(((Layout)localObject).getLineCount() - 1);
        if (((paramInt1 != -1) || (!this.a.d())) && ((paramInt1 != 1) || (this.a.d()))) {
          break label431;
        }
      }
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 == 0) {
          break label434;
        }
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight() + localView.getMeasuredHeight());
        return;
        if ((localTextView.getGravity() & 0x7) == 5)
        {
          paramInt1 = -1;
          break;
        }
        paramInt1 = 1;
        break;
      }
      break;
      if (paramInt2 - getPaddingLeft() - getPaddingRight() >= localView.getMeasuredWidth() + paramInt1)
      {
        paramInt1 = localView.getMeasuredWidth() + paramInt1 + getPaddingLeft() + getPaddingRight();
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


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/IconTextAndDateLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */