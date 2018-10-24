package com.whatsapp.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class ClippingLayout
  extends FrameLayout
{
  private Rect a;
  
  public ClippingLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ClippingLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ClippingLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    if (this.a != null) {
      paramCanvas.clipRect(this.a);
    }
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  public void setClipBounds(Rect paramRect)
  {
    if ((paramRect == this.a) || ((paramRect != null) && (paramRect.equals(this.a)))) {
      return;
    }
    if (paramRect != null) {
      if (this.a == null) {
        this.a = new Rect(paramRect);
      }
    }
    for (;;)
    {
      invalidate();
      return;
      this.a.set(paramRect);
      continue;
      this.a = null;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/ClippingLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */