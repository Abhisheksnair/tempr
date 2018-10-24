package com.whatsapp.statusplayback;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import java.util.HashSet;
import java.util.Set;

public class StatusPlaybackProgressView
  extends View
{
  private int a;
  private int b;
  private float c;
  private a d;
  private final Set<Integer> e = new HashSet();
  private final RectF f = new RectF();
  private final Paint g = new Paint(1);
  
  public StatusPlaybackProgressView(Context paramContext)
  {
    super(paramContext);
  }
  
  public StatusPlaybackProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StatusPlaybackProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public StatusPlaybackProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    if (this.e.contains(Integer.valueOf(paramInt)))
    {
      if (paramBoolean) {
        return -376511;
      }
      return 1727676737;
    }
    if (paramBoolean) {
      return -1;
    }
    return 1728053247;
  }
  
  public final void a()
  {
    this.e.clear();
  }
  
  public final void a(int paramInt)
  {
    this.e.add(Integer.valueOf(paramInt));
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a == 0) {}
    do
    {
      return;
      int i = getWidth() - getPaddingLeft() - getPaddingRight();
      int j = getHeight() - getPaddingTop() - getPaddingBottom();
      float f1 = i * 1.0F / this.a;
      float f2 = Math.min(j * 2, f1 / 2.0F);
      float f3 = (i - (this.a - 1) * f2) * 1.0F / this.a;
      this.g.setStrokeCap(Paint.Cap.ROUND);
      this.g.setStyle(Paint.Style.FILL);
      paramCanvas.translate(getPaddingLeft(), getPaddingTop());
      i = 0;
      f1 = 0.0F;
      while (i < this.a) {
        if (i == this.b)
        {
          if (this.d != null) {
            this.c = this.d.a();
          }
          float f4 = this.c * f3 / 100.0F;
          this.g.setColor(a(i, false));
          this.f.set(f1, 0.0F, f1 + f3, j);
          paramCanvas.drawRoundRect(this.f, j / 2.0F, j / 2.0F, this.g);
          this.g.setColor(a(i, true));
          this.f.set(f1, 0.0F, f4 + f1, j);
          paramCanvas.drawRoundRect(this.f, j / 2.0F, j / 2.0F, this.g);
          f1 += f3 + f2;
          i += 1;
        }
        else
        {
          if (i < this.b) {
            this.g.setColor(a(i, true));
          }
          for (;;)
          {
            this.f.set(f1, 0.0F, f1 + f3, j);
            paramCanvas.drawRoundRect(this.f, j / 2.0F, j / 2.0F, this.g);
            break;
            this.g.setColor(a(i, false));
          }
        }
      }
    } while (this.d == null);
    invalidate();
  }
  
  public void setCount(int paramInt)
  {
    this.a = paramInt;
    invalidate();
  }
  
  public void setPosition(int paramInt)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      this.c = 0.0F;
      invalidate();
    }
  }
  
  public void setProgressProvider(a parama)
  {
    this.d = parama;
    invalidate();
  }
  
  public static abstract interface a
  {
    public abstract float a();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/StatusPlaybackProgressView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */