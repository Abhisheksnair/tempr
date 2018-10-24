package com.whatsapp.crop;

import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.view.View;

final class d
{
  View a;
  int b = a.a;
  Rect c;
  RectF d;
  RectF e;
  Matrix f;
  boolean g = false;
  float h;
  boolean i = false;
  int j;
  final Paint k = new Paint();
  final Paint l = new Paint();
  final Paint m = new Paint();
  boolean n;
  
  d(View paramView)
  {
    this.a = paramView;
  }
  
  public final int a(float paramFloat1, float paramFloat2)
  {
    int i1 = 0;
    int i2 = 1;
    Rect localRect = b();
    float f1 = 20.0F * this.a.getResources().getDisplayMetrics().density;
    int i3;
    int i4;
    if (this.i)
    {
      paramFloat1 -= localRect.centerX();
      paramFloat2 -= localRect.centerY();
      i3 = (int)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
      i4 = this.c.width() / 2;
      if (Math.abs(i3 - i4) <= f1) {
        if (Math.abs(paramFloat2) > Math.abs(paramFloat1)) {
          if (paramFloat2 < 0.0F) {
            i1 = 8;
          }
        }
      }
      do
      {
        return i1;
        return 16;
        if (paramFloat1 < 0.0F) {
          return 2;
        }
        return 4;
        i1 = i2;
      } while (i3 >= i4);
      return 32;
    }
    if ((paramFloat2 >= localRect.top - f1) && (paramFloat2 < localRect.bottom + f1))
    {
      i4 = 1;
      i3 = i1;
      if (paramFloat1 >= localRect.left - f1)
      {
        i3 = i1;
        if (paramFloat1 < localRect.right + f1) {
          i3 = 1;
        }
      }
      if ((Math.abs(localRect.left - paramFloat1) >= f1) || (i4 == 0)) {
        break label371;
      }
    }
    label371:
    for (i2 = 3;; i2 = 1)
    {
      i1 = i2;
      if (Math.abs(localRect.right - paramFloat1) < f1)
      {
        i1 = i2;
        if (i4 != 0) {
          i1 = i2 | 0x4;
        }
      }
      i2 = i1;
      if (Math.abs(localRect.top - paramFloat2) < f1)
      {
        i2 = i1;
        if (i3 != 0) {
          i2 = i1 | 0x8;
        }
      }
      if ((Math.abs(localRect.bottom - paramFloat2) < f1) && (i3 != 0)) {}
      for (i1 = i2 | 0x10;; i1 = i2)
      {
        if ((i1 == 1) && (localRect.contains((int)paramFloat1, (int)paramFloat2)))
        {
          return 32;
          i4 = 0;
          break;
        }
        return i1;
      }
    }
  }
  
  public final Rect a()
  {
    return new Rect((int)this.e.left, (int)this.e.top, (int)this.e.right, (int)this.e.bottom);
  }
  
  public final void a(int paramInt)
  {
    if (paramInt != this.b)
    {
      this.b = paramInt;
      this.a.invalidate();
    }
  }
  
  final Rect b()
  {
    RectF localRectF = new RectF(this.e.left, this.e.top, this.e.right, this.e.bottom);
    this.f.mapRect(localRectF);
    return new Rect(Math.round(localRectF.left), Math.round(localRectF.top), Math.round(localRectF.right), Math.round(localRectF.bottom));
  }
  
  public final void c()
  {
    this.c = b();
  }
  
  static enum a {}
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/crop/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */