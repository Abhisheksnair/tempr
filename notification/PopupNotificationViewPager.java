package com.whatsapp.notification;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v4.view.w;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.whatsapp.tb;

public class PopupNotificationViewPager
  extends ViewPager
{
  boolean g = true;
  Integer h = null;
  
  public PopupNotificationViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public PopupNotificationViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int getCurrentOffsetBlocks()
  {
    int j = 0;
    int i = j;
    if (getAdapter().b() > 0)
    {
      i = j;
      if ((getAdapter() instanceof tb)) {
        i = super.getCurrentItem() / ((tb)getAdapter()).a.b();
      }
    }
    return i;
  }
  
  private int getDefaultOffsetBlocks()
  {
    int j = 0;
    int i = j;
    if (getAdapter().b() > 0)
    {
      i = j;
      if ((getAdapter() instanceof tb)) {
        i = 1000;
      }
    }
    return i;
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramInt, paramBoolean, bool);
      return;
    }
  }
  
  public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramInt;
    boolean bool = paramBoolean1;
    int j;
    if (getAdapter().b() > 0)
    {
      i = paramInt;
      bool = paramBoolean1;
      if ((getAdapter() instanceof tb))
      {
        j = ((tb)getAdapter()).a.b();
        if (paramInt < 0) {
          i = -1;
        }
      }
    }
    for (;;)
    {
      if (paramInt < 0)
      {
        paramInt += j;
        continue;
        if (paramInt >= j) {
          i = 1;
        }
      }
      else
      {
        int k = paramInt % j;
        if (paramBoolean2)
        {
          i = k + getDefaultOffsetBlocks() * j;
          bool = paramBoolean1;
          super.a(i, bool);
          return;
        }
        paramInt = getCurrentOffsetBlocks() + i;
        i = getAdapter().b() / ((tb)getAdapter()).a.b();
        if ((paramInt < 0) || (paramInt >= i))
        {
          paramInt = getDefaultOffsetBlocks();
          paramBoolean1 = false;
        }
        for (;;)
        {
          i = k + paramInt * j;
          bool = paramBoolean1;
          break;
        }
      }
      i = 0;
    }
  }
  
  final void c()
  {
    if ((!this.g) && (this.h != null))
    {
      a(this.h.intValue(), true);
      this.h = null;
    }
  }
  
  public int getCurrentItem()
  {
    if ((getAdapter().b() > 0) && ((getAdapter() instanceof tb))) {
      return super.getCurrentItem() % ((tb)getAdapter()).a.b();
    }
    return super.getCurrentItem();
  }
  
  protected void onAttachedToWindow()
  {
    this.g = true;
    super.onAttachedToWindow();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((getAdapter() instanceof tb)) && (((tb)getAdapter()).a.b() <= 1)) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.g = false;
    c();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((getAdapter() instanceof tb)) && (((tb)getAdapter()).a.b() <= 1)) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setAdapter(w paramw)
  {
    this.g = true;
    super.setAdapter(paramw);
  }
  
  public void setCurrentItem(int paramInt)
  {
    a(paramInt, false);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/notification/PopupNotificationViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */