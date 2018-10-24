package com.whatsapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.Map;

public class ContactStatusThumbnail
  extends ThumbnailButton
{
  final Map<Integer, Integer> a = new HashMap();
  private int k;
  private int l;
  private int m;
  private int n;
  private final RectF o = new RectF();
  
  public ContactStatusThumbnail(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public ContactStatusThumbnail(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public ContactStatusThumbnail(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, adn.ContactStatusThumbnail);
      this.m = paramContext.getInteger(0, 0);
      this.n = paramContext.getInteger(1, 0);
      paramContext.recycle();
    }
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.k = paramInt1;
    this.l = paramInt2;
    invalidate();
  }
  
  protected final void a(Canvas paramCanvas)
  {
    if (this.l > 0)
    {
      this.h.setStrokeWidth(this.e);
      this.h.setStyle(Paint.Style.STROKE);
      this.h.setStrokeCap(Paint.Cap.ROUND);
      this.o.set(0.0F, 0.0F, getWidth(), getHeight());
      this.o.inset(this.e / 2.0F, this.e / 2.0F);
      this.h.setColor(-1);
      paramCanvas.drawOval(this.o, this.h);
      float f3 = 360.0F / this.l;
      float f1;
      int j;
      float f2;
      label135:
      Paint localPaint;
      int i;
      if (this.l == 1)
      {
        f1 = 0.0F;
        this.h.setStrokeWidth(this.e - 1.0F);
        j = 0;
        f2 = -90.0F;
        if (j >= this.l) {
          return;
        }
        localPaint = this.h;
        if (!this.a.containsKey(Integer.valueOf(j))) {
          break label254;
        }
        i = ((Integer)this.a.get(Integer.valueOf(j))).intValue();
      }
      for (;;)
      {
        localPaint.setColor(i);
        paramCanvas.drawArc(this.o, f2 + f1 / 2.0F, f3 - f1, false, this.h);
        j += 1;
        f2 += f3;
        break label135;
        if (f3 <= 24.0F)
        {
          f1 = f3 / 2.0F;
          break;
        }
        f1 = 12.0F;
        break;
        label254:
        if (j < this.k) {
          i = this.n;
        } else {
          i = this.m;
        }
      }
    }
  }
  
  public final void b(int paramInt1, int paramInt2)
  {
    this.a.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ContactStatusThumbnail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */