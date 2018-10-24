package com.whatsapp.camera;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.view.View;

public final class a
  extends View
{
  RectF a;
  Boolean b;
  Runnable c = new Runnable()
  {
    public final void run()
    {
      a.this.setVisibility(8);
    }
  };
  private Paint d = new Paint(1);
  
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    this.d.setStrokeWidth(getContext().getResources().getDimension(2131361898));
    this.d.setStyle(Paint.Style.STROKE);
    if (this.b == null) {
      this.d.setColor(-1);
    }
    for (;;)
    {
      paramCanvas.drawRect(this.a, this.d);
      return;
      if (this.b == Boolean.TRUE) {
        this.d.setColor(-16711936);
      } else {
        this.d.setColor(-65536);
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/camera/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */