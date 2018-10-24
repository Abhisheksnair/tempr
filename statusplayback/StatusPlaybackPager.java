package com.whatsapp.statusplayback;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class StatusPlaybackPager
  extends ViewPager
{
  public StatusPlaybackPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public StatusPlaybackPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((q.c(paramMotionEvent) > 1) && (q.a(paramMotionEvent) == 2)) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/StatusPlaybackPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */