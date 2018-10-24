package com.whatsapp.camera;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;

public final class az
  extends View
{
  boolean a;
  private Paint b = new Paint(1);
  
  public az(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    if (this.a)
    {
      this.b.setStrokeWidth(getContext().getResources().getDimension(2131361898) * 8.0F);
      this.b.setStyle(Paint.Style.STROKE);
      this.b.setColor(-1);
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.b);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/camera/az.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */