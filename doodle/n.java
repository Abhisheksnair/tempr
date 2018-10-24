package com.whatsapp.doodle;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;

public final class n
  extends ScaleGestureDetector
{
  float a;
  
  public n(Context paramContext, ScaleGestureDetector.OnScaleGestureListener paramOnScaleGestureListener)
  {
    super(paramContext, paramOnScaleGestureListener);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f;
    if (paramMotionEvent.getPointerCount() == 2)
    {
      f = paramMotionEvent.getX(0) - paramMotionEvent.getX(1);
      if (f != 0.0F) {
        break label46;
      }
      f = Float.MAX_VALUE;
      this.a = Float.MAX_VALUE;
    }
    for (;;)
    {
      this.a = f;
      return super.onTouchEvent(paramMotionEvent);
      label46:
      f = (paramMotionEvent.getY(0) - paramMotionEvent.getY(1)) / f;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */