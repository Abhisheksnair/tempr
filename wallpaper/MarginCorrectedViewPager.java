package com.whatsapp.wallpaper;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MarginCorrectedViewPager
  extends ViewPager
{
  private boolean g = true;
  
  public MarginCorrectedViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MarginCorrectedViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.g) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1 - getPageMargin(), paramInt2, paramInt3 - getPageMargin(), paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.g) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setScrollEnabled(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/wallpaper/MarginCorrectedViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */