package com.whatsapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class ConversationContentLayout
  extends RelativeLayout
{
  private hw a;
  
  public ConversationContentLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ConversationContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ConversationContentLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public ConversationContentLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public final void a()
  {
    if (this.a != null)
    {
      this.a = null;
      requestLayout();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.a != null)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt2 + getMeasuredHeight());
      return;
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j;
    int i;
    if (this.a != null)
    {
      j = View.MeasureSpec.getMode(paramInt2);
      i = View.MeasureSpec.getSize(paramInt2);
      if (j == 0) {
        break label145;
      }
      Rect localRect = new Rect();
      getWindowVisibleDisplayFrame(localRect);
      if (((Activity)getContext()).getWindowManager().getDefaultDisplay().getHeight() - (localRect.bottom - localRect.top) > 128.0F * aoa.a().a)
      {
        paramInt2 = 1;
        if (paramInt2 != 0) {
          break label145;
        }
        paramInt2 = this.a.c();
        if (paramInt2 != 0) {
          break label125;
        }
        paramInt2 = i / 2;
      }
    }
    label104:
    label125:
    label145:
    for (paramInt2 = i - paramInt2;; paramInt2 = i)
    {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt2, j));
      return;
      paramInt2 = 0;
      break;
      paramInt2 = Math.min(paramInt2, i * 3 / 4);
      break label104;
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
  }
  
  public void setEmojiPopup(hw paramhw)
  {
    if (paramhw != this.a)
    {
      this.a = paramhw;
      requestLayout();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ConversationContentLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */