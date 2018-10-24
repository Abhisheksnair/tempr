package com.whatsapp;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;

public class ContactLiveLocationThumbnail
  extends ThumbnailButton
{
  private float a;
  private int k;
  private int l;
  private final RectF m = new RectF();
  
  public ContactLiveLocationThumbnail(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public ContactLiveLocationThumbnail(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public ContactLiveLocationThumbnail(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, adn.ContactLiveLocationThumbnail);
      this.a = paramContext.getDimension(0, this.a);
      this.k = paramContext.getInteger(1, this.k);
      this.l = paramContext.getInteger(2, this.l);
      paramContext.recycle();
    }
  }
  
  protected final void a(Canvas paramCanvas)
  {
    this.m.set(0.0F, 0.0F, getWidth(), getHeight());
    if ((this.a > 0.0F) && (this.k != 0))
    {
      this.m.inset(this.a / 2.0F, this.a / 2.0F);
      this.h.setColor(this.k);
      this.h.setStrokeWidth(this.a);
      this.h.setStyle(Paint.Style.STROKE);
      if (this.b >= 0.0F)
      {
        paramCanvas.drawRoundRect(this.m, this.b, this.b, this.h);
        this.m.inset(this.a / 2.0F, this.a / 2.0F);
      }
    }
    else
    {
      if ((this.e > 0.0F) && (this.f != 0))
      {
        this.m.inset(this.e / 2.0F, this.e / 2.0F);
        this.h.setColor(this.f);
        this.h.setStrokeWidth(this.e);
        this.h.setStyle(Paint.Style.STROKE);
        if (this.b < 0.0F) {
          break label417;
        }
        paramCanvas.drawRoundRect(this.m, this.b, this.b, this.h);
        label230:
        this.m.inset(this.e / 2.0F, this.e / 2.0F);
      }
      if (this.l > 1)
      {
        this.h.setColor(1291845632);
        this.h.setStyle(Paint.Style.FILL);
        if (this.b < 0.0F) {
          break label436;
        }
        paramCanvas.drawRoundRect(this.m, this.b, this.b, this.h);
      }
    }
    for (;;)
    {
      this.h.setTextAlign(Paint.Align.CENTER);
      this.h.setColor(-1);
      this.h.setTextSize(getResources().getDimensionPixelSize(2131362108));
      paramCanvas.drawText(this.l, this.m.centerX(), this.m.centerY() - (this.h.ascent() + this.h.descent()) / 2.0F, this.h);
      return;
      paramCanvas.drawArc(this.m, 0.0F, 360.0F, true, this.h);
      break;
      label417:
      paramCanvas.drawArc(this.m, 0.0F, 360.0F, true, this.h);
      break label230;
      label436:
      paramCanvas.drawArc(this.m, 0.0F, 360.0F, true, this.h);
    }
  }
  
  public void setGlowColor(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setGlowSize(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  public void setStackSize(int paramInt)
  {
    this.l = paramInt;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ContactLiveLocationThumbnail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */