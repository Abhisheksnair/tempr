package com.whatsapp;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;

public final class th
  extends LinkMovementMethod
{
  anx a;
  
  public final boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 1) || (i == 0))
    {
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = paramTextView.getTotalPaddingLeft();
      int n = paramTextView.getTotalPaddingTop();
      int i1 = paramTextView.getScrollX();
      int i2 = paramTextView.getScrollY();
      Layout localLayout = paramTextView.getLayout();
      j = localLayout.getOffsetForHorizontal(localLayout.getLineForVertical(k - n + i2), j - m + i1);
      paramSpannable = (anx[])paramSpannable.getSpans(j, j, anx.class);
      if (paramSpannable.length != 0)
      {
        this.a = paramSpannable[0];
        if (i == 1) {
          this.a.a(paramTextView, paramMotionEvent);
        }
        for (;;)
        {
          return true;
          if (i == 0) {
            this.a.a(paramTextView, paramMotionEvent);
          }
        }
      }
    }
    else if ((i == 3) && (this.a != null))
    {
      this.a.a(paramTextView, paramMotionEvent);
    }
    return false;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/th.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */