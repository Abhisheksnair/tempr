package com.whatsapp.util;

import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;

public final class ax
  extends RotateAnimation
{
  public boolean a;
  private long b;
  
  public ax()
  {
    super(360.0F, 0.0F, 1, 0.5F, 1, 0.5F);
  }
  
  public final void a()
  {
    this.b = 0L;
    this.a = true;
  }
  
  public final boolean getTransformation(long paramLong, Transformation paramTransformation)
  {
    if (this.a)
    {
      if (this.b == 0L) {
        this.b = (paramLong - getStartTime());
      }
      setStartTime(paramLong - this.b);
    }
    return super.getTransformation(paramLong, paramTransformation);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */