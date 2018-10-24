package com.whatsapp.doodle;

import android.graphics.PointF;
import android.view.MotionEvent;

public final class l
{
  a a;
  final PointF b = new PointF();
  final PointF c = new PointF();
  boolean d;
  
  public l(a parama)
  {
    this.a = parama;
  }
  
  static void a(PointF paramPointF, MotionEvent paramMotionEvent)
  {
    paramPointF.set(0.0F, 0.0F);
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    while (i < j)
    {
      paramPointF.x += paramMotionEvent.getX(i);
      paramPointF.y += paramMotionEvent.getY(i);
      i += 1;
    }
    paramPointF.x /= j;
    paramPointF.y /= j;
  }
  
  public static abstract interface a
  {
    public abstract boolean b(float paramFloat1, float paramFloat2);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */