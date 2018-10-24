package com.whatsapp;

import android.os.SystemClock;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import android.view.MotionEvent;
import android.view.View;

public abstract class anx
  extends CharacterStyle
  implements UpdateAppearance
{
  private long a;
  boolean b;
  private int c;
  private int d;
  private int e;
  
  public anx(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = -65536;
    this.e = paramInt2;
  }
  
  public abstract void a(View paramView);
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (paramMotionEvent.getAction() == 1)
    {
      long l = SystemClock.elapsedRealtime();
      if (l - this.a > 1000L)
      {
        this.a = l;
        a(paramView);
      }
    }
    if (paramMotionEvent.getAction() == 0) {}
    for (;;)
    {
      this.b = bool;
      paramView.invalidate();
      return false;
      bool = false;
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    if (this.b)
    {
      paramTextPaint.setColor(this.d);
      paramTextPaint.bgColor = this.e;
      return;
    }
    if (this.c == 0) {
      paramTextPaint.setColor(paramTextPaint.linkColor);
    }
    for (;;)
    {
      paramTextPaint.bgColor = 0;
      return;
      paramTextPaint.setColor(this.c);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/anx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */