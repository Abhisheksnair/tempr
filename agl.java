package com.whatsapp;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.whatsapp.util.Log;

public final class agl
  implements View.OnTouchListener
{
  private float a;
  private float b;
  private float c;
  private float d;
  
  public agl(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Log.i("ReducedAreaOnTouchListener/ignored_ratio -- left: " + paramFloat1 + ", right: " + paramFloat3 + ", top: " + paramFloat2 + ", bottom: " + paramFloat4);
    if ((paramFloat1 < 0.0F) || (paramFloat1 > 1.0F) || (paramFloat3 < 0.0F) || (paramFloat3 > 1.0F) || (paramFloat2 < 0.0F) || (paramFloat2 > 1.0F) || (paramFloat4 < 0.0F) || (paramFloat4 > 1.0F)) {
      throw new RuntimeException("invalid input parameters");
    }
    this.a = paramFloat1;
    this.b = paramFloat3;
    this.c = paramFloat2;
    this.d = paramFloat4;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 1)) {
      Log.i("ReducedAreaOnTouchListener/onTouch " + paramMotionEvent + ", view width:" + i + ", view height:" + j + ", pointer count: " + paramMotionEvent.getPointerCount());
    }
    if (paramMotionEvent.getAction() == 0)
    {
      if ((paramMotionEvent.getX() >= this.a * i) && (paramMotionEvent.getY() >= this.c * j))
      {
        float f1 = paramMotionEvent.getX();
        float f2 = this.b;
        if (f1 <= i * (1.0F - f2))
        {
          f1 = paramMotionEvent.getY();
          f2 = this.d;
          if (f1 <= j * (1.0F - f2)) {
            break label172;
          }
        }
      }
      Log.i("ReducedAreaOnTouchListener/ignore this touch event");
      return true;
    }
    label172:
    return false;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/agl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */