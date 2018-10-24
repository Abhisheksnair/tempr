package com.whatsapp;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.LayerDrawable;
import android.os.SystemClock;

public final class anz
  extends LayerDrawable
  implements Drawable.Callback
{
  public int a = 2;
  public int b;
  public int c;
  private long d;
  
  public anz(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(new Drawable[] { paramDrawable1, paramDrawable2 });
  }
  
  private anz(Drawable[] paramArrayOfDrawable)
  {
    super(paramArrayOfDrawable);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    float f;
    switch (this.a)
    {
    default: 
      f = 0.0F;
    }
    for (;;)
    {
      if (f < 1.0F) {
        break label95;
      }
      getDrawable(1).draw(paramCanvas);
      return;
      this.d = SystemClock.uptimeMillis();
      this.a = 1;
      f = 0.0F;
      continue;
      if (this.d < 0L) {
        break;
      }
      f = Math.min((float)(SystemClock.uptimeMillis() - this.d) / this.b, 1.0F);
    }
    label95:
    if (this.c == 0) {}
    for (int i = getBounds().height();; i = this.c)
    {
      int j = paramCanvas.getSaveCount();
      paramCanvas.save();
      paramCanvas.translate(0.0F, f * i);
      getDrawable(0).draw(paramCanvas);
      paramCanvas.translate(0.0F, -i);
      getDrawable(1).draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      invalidateSelf();
      return;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/anz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */