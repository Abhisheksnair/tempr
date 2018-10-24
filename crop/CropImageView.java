package com.whatsapp.crop;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

public class CropImageView
  extends e
{
  ArrayList<d> a = new ArrayList();
  boolean b;
  private d h = null;
  private float i;
  private float j;
  private int k;
  
  public CropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void b(final d paramd)
  {
    Object localObject = paramd.c;
    float f1 = ((Rect)localObject).width();
    float f2 = ((Rect)localObject).height();
    float f3 = getWidth();
    float f4 = getHeight();
    f3 = Math.max(1.0F, Math.min(f3 / f1 * 0.6F, f4 / f2 * 0.6F) * getScale());
    if (Math.abs(f3 - getScale()) / f3 > 0.1D)
    {
      localObject = new float[2];
      localObject[0] = paramd.e.centerX();
      localObject[1] = paramd.e.centerY();
      getImageMatrix().mapPoints((float[])localObject);
      f1 = localObject[0];
      f2 = localObject[1];
      paramd = new Runnable()
      {
        public final void run()
        {
          CropImageView.this.a(paramd);
        }
      };
      f3 = (f3 - getScale()) / 300.0F;
      f4 = getScale();
      long l = System.currentTimeMillis();
      this.g.post(new e.2(this, l, f4, f3, f1, f2, paramd));
    }
  }
  
  public final void a()
  {
    this.a.clear();
    super.a();
  }
  
  protected final void a(float paramFloat1, float paramFloat2)
  {
    super.a(paramFloat1, paramFloat2);
    int m = 0;
    while (m < this.a.size())
    {
      d locald = (d)this.a.get(m);
      locald.f.postTranslate(paramFloat1, paramFloat2);
      locald.c();
      m += 1;
    }
  }
  
  protected final void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super.a(paramFloat1, paramFloat2, paramFloat3);
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      locald.f.set(getImageMatrix());
      locald.c();
    }
  }
  
  public final void a(d paramd)
  {
    paramd = paramd.c;
    int m = Math.max(0, -paramd.left);
    int i2 = Math.min(0, getWidth() - paramd.right);
    int n = Math.max(0, -paramd.top);
    int i1 = Math.min(0, getHeight() - paramd.bottom);
    if (m != 0) {
      if (n == 0) {
        break label86;
      }
    }
    for (;;)
    {
      if ((m != 0) || (n != 0)) {
        b(m, n);
      }
      return;
      m = i2;
      break;
      label86:
      n = i1;
    }
  }
  
  public void clearFocus()
  {
    int m = 0;
    while (m < this.a.size())
    {
      d locald = (d)this.a.get(m);
      locald.n = false;
      locald.c();
      m += 1;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.b) {
      super.onDraw(paramCanvas);
    }
    int m = 0;
    while (m < this.a.size())
    {
      d locald = (d)this.a.get(m);
      Path localPath = new Path();
      float f1 = locald.a.getResources().getDisplayMetrics().density;
      locald.m.setStrokeWidth(0.5F + f1);
      Rect localRect2 = new Rect();
      locald.a.getDrawingRect(localRect2);
      int i3;
      int n;
      int i1;
      int i2;
      if (locald.i)
      {
        float f2 = locald.c.width();
        float f3 = locald.c.height();
        float f4 = locald.c.left;
        float f5 = f2 / 2.0F;
        float f6 = locald.c.top;
        localPath.addCircle(f4 + f5, f3 / 2.0F + f6, f2 / 2.0F, Path.Direction.CW);
        locald.m.setColor(-1112874);
        paramCanvas.drawPath(localPath, locald.m);
        i3 = Math.round(2.0F * f1);
        n = locald.c.left + i3;
        i1 = locald.c.right - i3;
        i2 = locald.c.top + i3;
        i3 = locald.c.bottom - i3;
        int i4 = Math.min((int)(24.0F * f1), locald.c.width() / 4);
        int i5 = Math.min((int)(24.0F * f1), locald.c.height() / 4);
        int i6 = locald.c.left + (locald.c.right - locald.c.left) / 2;
        int i7 = locald.c.top + (locald.c.bottom - locald.c.top) / 2;
        locald.m.setStrokeWidth(2.0F * f1);
        locald.m.setColor(-1);
        locald.m.setStrokeCap(Paint.Cap.SQUARE);
        paramCanvas.drawLine(i6 - i4 / 2, i2, i4 / 2 + i6, i2, locald.m);
        paramCanvas.drawLine(i6 - i4 / 2, i3, i4 / 2 + i6, i3, locald.m);
        paramCanvas.drawLine(n, i7 - i5 / 2, n, i5 / 2 + i7, locald.m);
        paramCanvas.drawLine(i1, i7 - i5 / 2, i1, i5 / 2 + i7, locald.m);
        paramCanvas.drawLine(n, i2, n + i4, i2, locald.m);
        paramCanvas.drawLine(n, i2, n, i2 + i5, locald.m);
        paramCanvas.drawLine(i1, i2, i1 - i4, i2, locald.m);
        paramCanvas.drawLine(i1, i2, i1, i2 + i5, locald.m);
        paramCanvas.drawLine(i1, i3, i1 - i4, i3, locald.m);
        paramCanvas.drawLine(i1, i3, i1, i3 - i5, locald.m);
        paramCanvas.drawLine(n, i3, n + i4, i3, locald.m);
        paramCanvas.drawLine(n, i3, n, i3 - i5, locald.m);
        m += 1;
      }
      else
      {
        localPath.addRect(new RectF(locald.c), Path.Direction.CW);
        locald.m.setColor(1728053247);
        Rect localRect1 = new Rect();
        localRect1.set(localRect2);
        localRect1.right = locald.c.left;
        if (locald.n)
        {
          localPaint = locald.k;
          label789:
          paramCanvas.drawRect(localRect1, localPaint);
          localRect1.set(localRect2);
          localRect1.right = locald.c.right;
          localRect1.left = locald.c.left;
          localRect1.bottom = locald.c.top;
          if (!locald.n) {
            break label1341;
          }
          localPaint = locald.k;
          label858:
          paramCanvas.drawRect(localRect1, localPaint);
          localRect1.set(localRect2);
          localRect1.right = locald.c.right;
          localRect1.left = locald.c.left;
          localRect1.top = locald.c.bottom;
          if (!locald.n) {
            break label1351;
          }
          localPaint = locald.k;
          label927:
          paramCanvas.drawRect(localRect1, localPaint);
          localRect1.set(localRect2);
          localRect1.left = locald.c.right;
          if (!locald.n) {
            break label1361;
          }
        }
        label1341:
        label1351:
        label1361:
        for (Paint localPaint = locald.k;; localPaint = locald.l)
        {
          paramCanvas.drawRect(localRect1, localPaint);
          i3 = Math.round(f1);
          n = locald.c.left + i3;
          i1 = locald.c.right - i3;
          i2 = locald.c.top + i3;
          i3 = locald.c.bottom - i3;
          paramCanvas.drawLine(n, locald.c.top + (locald.c.bottom - locald.c.top) / 3, i1, locald.c.top + (locald.c.bottom - locald.c.top) / 3, locald.m);
          paramCanvas.drawLine(n, locald.c.bottom - (locald.c.bottom - locald.c.top) / 3, i1, locald.c.bottom - (locald.c.bottom - locald.c.top) / 3, locald.m);
          paramCanvas.drawLine(locald.c.left + (locald.c.right - locald.c.left) / 3, i2, locald.c.left + (locald.c.right - locald.c.left) / 3, i3, locald.m);
          paramCanvas.drawLine(locald.c.right - (locald.c.right - locald.c.left) / 3, i2, locald.c.right - (locald.c.right - locald.c.left) / 3, i3, locald.m);
          break;
          localPaint = locald.l;
          break label789;
          localPaint = locald.l;
          break label858;
          localPaint = locald.l;
          break label927;
        }
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.c.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        locald.f.set(getImageMatrix());
        locald.c();
        if (locald.n) {
          b(locald);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = 0;
    if (((CropImage)getContext()).i) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    int m;
    d locald;
    int i1;
    label178:
    label270:
    float f2;
    float f4;
    for (;;)
    {
      switch (paramMotionEvent.getAction())
      {
      default: 
        return true;
        m = 0;
        while (m < this.a.size())
        {
          locald = (d)this.a.get(m);
          i1 = locald.a(paramMotionEvent.getX(), paramMotionEvent.getY());
          if (i1 != 1)
          {
            this.k = i1;
            this.h = locald;
            this.i = paramMotionEvent.getX();
            this.j = paramMotionEvent.getY();
            locald = this.h;
            if (i1 == 32)
            {
              m = d.a.b;
              locald.a(m);
              clearFocus();
              m = n;
            }
            for (;;)
            {
              if (m < this.a.size())
              {
                locald = (d)this.a.get(m);
                if (locald.a(paramMotionEvent.getX(), paramMotionEvent.getY()) == 1) {
                  break label270;
                }
                if (!locald.n)
                {
                  locald.n = true;
                  locald.c();
                }
              }
              invalidate();
              break;
              m = d.a.c;
              break label178;
              m += 1;
            }
          }
          m += 1;
        }
        if (this.h != null)
        {
          if (this.h.n)
          {
            this.h.n = false;
            this.h.c();
            invalidate();
          }
          b(this.h);
          this.h.a(d.a.a);
        }
        this.h = null;
        continue;
        if (this.h != null)
        {
          locald = this.h;
          i1 = this.k;
          f1 = paramMotionEvent.getX() - this.i;
          f2 = paramMotionEvent.getY() - this.j;
          localObject1 = locald.b();
          if (i1 != 1)
          {
            if (i1 != 32) {
              break label685;
            }
            localObject1 = new RectF((Rect)localObject1);
            ((RectF)localObject1).offset(f1, f2);
            localObject2 = new Matrix();
            if (locald.f.invert((Matrix)localObject2)) {
              ((Matrix)localObject2).mapRect((RectF)localObject1);
            }
            f1 = ((RectF)localObject1).left;
            f2 = locald.e.left;
            f3 = ((RectF)localObject1).top;
            f4 = locald.e.top;
            localObject1 = new Rect(locald.c);
            locald.e.offset(f1 - f2, f3 - f4);
            locald.e.offset(Math.max(0.0F, locald.d.left - locald.e.left), Math.max(0.0F, locald.d.top - locald.e.top));
            locald.e.offset(Math.min(0.0F, locald.d.right - locald.e.right), Math.min(0.0F, locald.d.bottom - locald.e.bottom));
            locald.c = locald.b();
            ((Rect)localObject1).union(locald.c);
            ((Rect)localObject1).inset(-10, -10);
            locald.a.invalidate((Rect)localObject1);
          }
          this.i = paramMotionEvent.getX();
          this.j = paramMotionEvent.getY();
          a(this.h);
        }
        break;
      }
    }
    label685:
    Object localObject2 = new float[2];
    localObject2[0] = f1;
    localObject2[1] = f2;
    Object localObject1 = new Matrix();
    if (locald.f.invert((Matrix)localObject1)) {
      ((Matrix)localObject1).mapVectors((float[])localObject2);
    }
    float f1 = localObject2[0];
    float f3 = localObject2[1];
    if ((i1 & 0x8) != 0)
    {
      localObject2 = new float[2];
      Object tmp755_753 = localObject2;
      tmp755_753[0] = 0.0F;
      Object tmp759_755 = tmp755_753;
      tmp759_755[1] = 1.0F;
      tmp759_755;
      ((Matrix)localObject1).mapVectors((float[])localObject2);
      if ((localObject2[0] > 0.0F) && (localObject2[1] == 0.0F)) {
        n = 3;
      }
    }
    for (;;)
    {
      label792:
      m = n;
      if ((i1 & 0x10) != 0)
      {
        localObject2 = new float[2];
        Object tmp811_809 = localObject2;
        tmp811_809[0] = 0.0F;
        Object tmp815_811 = tmp811_809;
        tmp815_811[1] = -1.0F;
        tmp815_811;
        ((Matrix)localObject1).mapVectors((float[])localObject2);
        if ((localObject2[0] > 0.0F) && (localObject2[1] == 0.0F)) {
          m = n | 0x2;
        }
      }
      else
      {
        label853:
        n = m;
        if ((i1 & 0x4) != 0)
        {
          localObject2 = new float[2];
          Object tmp871_869 = localObject2;
          tmp871_869[0] = 1.0F;
          Object tmp875_871 = tmp871_869;
          tmp875_871[1] = 0.0F;
          tmp875_871;
          ((Matrix)localObject1).mapVectors((float[])localObject2);
          if ((localObject2[0] != 0.0F) || (localObject2[1] >= 0.0F)) {
            break label1826;
          }
          n = m | 0x8;
        }
        label912:
        m = n;
        if ((i1 & 0x2) != 0)
        {
          localObject2 = new float[2];
          Object tmp930_928 = localObject2;
          tmp930_928[0] = -1.0F;
          Object tmp936_930 = tmp930_928;
          tmp936_930[1] = 0.0F;
          tmp936_930;
          ((Matrix)localObject1).mapVectors((float[])localObject2);
          if ((localObject2[0] != 0.0F) || (localObject2[1] >= 0.0F)) {
            break label1890;
          }
          m = n | 0x8;
        }
        label973:
        if ((m & 0x6) != 0) {
          break label2171;
        }
        f1 = 0.0F;
      }
      label1025:
      label1414:
      label1462:
      label1637:
      label1826:
      label1890:
      label1983:
      label2024:
      label2066:
      label2107:
      label2171:
      for (;;)
      {
        if ((m & 0x18) == 0) {
          f3 = 0.0F;
        }
        f2 = f3;
        f4 = f1;
        if (locald.g)
        {
          if (f1 != 0.0F)
          {
            f2 = f1 / locald.h;
            f4 = f1;
          }
        }
        else
        {
          localObject1 = new RectF(locald.e);
          f1 = f2;
          if (locald.g) {
            if ((m & 0x12) != 18)
            {
              f1 = f2;
              if ((m & 0xC) != 12) {}
            }
            else
            {
              f1 = -f2;
            }
          }
          if ((m & 0x2) != 0)
          {
            ((RectF)localObject1).left += f4;
            if ((locald.g) && ((m & 0x10) == 0) && ((m & 0x8) == 0))
            {
              ((RectF)localObject1).top += f1 / 2.0F;
              ((RectF)localObject1).bottom -= f1 - f1 / 2.0F;
            }
          }
          if ((m & 0x4) != 0)
          {
            ((RectF)localObject1).right += f4;
            if ((locald.g) && ((m & 0x10) == 0) && ((m & 0x8) == 0))
            {
              ((RectF)localObject1).top -= f1 - f1 / 2.0F;
              ((RectF)localObject1).bottom += f1 / 2.0F;
            }
          }
          if ((m & 0x8) != 0)
          {
            ((RectF)localObject1).top += f1;
            if ((locald.g) && ((m & 0x2) == 0) && ((m & 0x4) == 0))
            {
              ((RectF)localObject1).left += f4 / 2.0F;
              ((RectF)localObject1).right -= f4 - f4 / 2.0F;
            }
          }
          if ((m & 0x10) != 0)
          {
            ((RectF)localObject1).bottom = (f1 + ((RectF)localObject1).bottom);
            if ((locald.g) && ((m & 0x2) == 0) && ((m & 0x4) == 0))
            {
              ((RectF)localObject1).left -= f4 - f4 / 2.0F;
              ((RectF)localObject1).right += f4 / 2.0F;
            }
          }
          f2 = Math.max(25.0F, locald.j);
          if (((RectF)localObject1).width() < f2)
          {
            if ((m & 0x2) == 0) {
              break label1983;
            }
            ((RectF)localObject1).left = (((RectF)localObject1).right - f2);
          }
          f1 = f2;
          if (locald.g) {
            f1 = f2 / locald.h;
          }
          if (((RectF)localObject1).height() < f1)
          {
            if ((m & 0x8) == 0) {
              break label2024;
            }
            ((RectF)localObject1).top = (((RectF)localObject1).bottom - f1);
          }
          if (((RectF)localObject1).width() > locald.d.width())
          {
            ((RectF)localObject1).right = (((RectF)localObject1).left + locald.d.width());
            if (locald.g) {
              ((RectF)localObject1).bottom = (((RectF)localObject1).top + locald.d.width() / locald.h);
            }
          }
          if (((RectF)localObject1).height() > locald.d.height())
          {
            ((RectF)localObject1).bottom = (((RectF)localObject1).top + locald.d.height());
            if (locald.g) {
              ((RectF)localObject1).right = (((RectF)localObject1).left + locald.d.height() * locald.h);
            }
          }
          if (((RectF)localObject1).left >= locald.d.left) {
            break label2066;
          }
          ((RectF)localObject1).offset(locald.d.left - ((RectF)localObject1).left, 0.0F);
          if (((RectF)localObject1).top >= locald.d.top) {
            break label2107;
          }
          ((RectF)localObject1).offset(0.0F, locald.d.top - ((RectF)localObject1).top);
        }
        for (;;)
        {
          locald.e.set((RectF)localObject1);
          locald.c = locald.b();
          locald.a.invalidate();
          break;
          if ((localObject2[0] == 0.0F) && (localObject2[1] < 0.0F))
          {
            n = 17;
            break label792;
          }
          if ((localObject2[0] < 0.0F) && (localObject2[1] == 0.0F))
          {
            n = 5;
            break label792;
          }
          n = 9;
          break label792;
          if ((localObject2[0] == 0.0F) && (localObject2[1] > 0.0F))
          {
            m = n | 0x8;
            break label853;
          }
          if ((localObject2[0] < 0.0F) && (localObject2[1] == 0.0F))
          {
            m = n | 0x4;
            break label853;
          }
          m = n | 0x10;
          break label853;
          if ((localObject2[0] < 0.0F) && (localObject2[1] == 0.0F))
          {
            n = m | 0x2;
            break label912;
          }
          if ((localObject2[0] == 0.0F) && (localObject2[1] > 0.0F))
          {
            n = m | 0x10;
            break label912;
          }
          n = m | 0x4;
          break label912;
          if ((localObject2[0] > 0.0F) && (localObject2[1] == 0.0F))
          {
            m = n | 0x4;
            break label973;
          }
          if ((localObject2[0] == 0.0F) && (localObject2[1] > 0.0F))
          {
            m = n | 0x10;
            break label973;
          }
          m = n | 0x2;
          break label973;
          f2 = f3;
          f4 = f1;
          if (f3 == 0.0F) {
            break label1025;
          }
          f4 = locald.h * f3;
          f2 = f3;
          break label1025;
          if ((m & 0x4) != 0)
          {
            ((RectF)localObject1).right = (((RectF)localObject1).left + f2);
            break label1414;
          }
          ((RectF)localObject1).inset(-(f2 - ((RectF)localObject1).width()) / 2.0F, 0.0F);
          break label1414;
          if ((m & 0x10) != 0)
          {
            ((RectF)localObject1).bottom = (f1 + ((RectF)localObject1).top);
            break label1462;
          }
          ((RectF)localObject1).inset(0.0F, -(f1 - ((RectF)localObject1).height()) / 2.0F);
          break label1462;
          if (((RectF)localObject1).right <= locald.d.right) {
            break label1637;
          }
          ((RectF)localObject1).offset(-(((RectF)localObject1).right - locald.d.right), 0.0F);
          break label1637;
          if (((RectF)localObject1).bottom > locald.d.bottom) {
            ((RectF)localObject1).offset(0.0F, -(((RectF)localObject1).bottom - locald.d.bottom));
          }
        }
        b();
        break;
        if (getScale() != 1.0F) {
          break;
        }
        b();
        break;
      }
      n = 1;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/crop/CropImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */