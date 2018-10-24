package com.whatsapp.util;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;

public final class az
  extends InsetDrawable
{
  boolean a;
  
  public az(Drawable paramDrawable) {}
  
  private az(Drawable paramDrawable, boolean paramBoolean)
  {
    super(paramDrawable, 0);
    this.a = paramBoolean;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (!this.a)
    {
      super.draw(paramCanvas);
      return;
    }
    paramCanvas.save();
    paramCanvas.scale(-1.0F, 1.0F, getBounds().exactCenterX(), 0.0F);
    super.draw(paramCanvas);
    paramCanvas.restore();
  }
  
  public final boolean getPadding(Rect paramRect)
  {
    boolean bool = super.getPadding(paramRect);
    if (this.a)
    {
      int i = paramRect.right;
      paramRect.right = paramRect.left;
      paramRect.left = i;
    }
    return bool;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */