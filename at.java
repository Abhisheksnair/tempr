package com.whatsapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.whatsapp.location.cc;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;

public abstract class at
  extends ViewGroup
{
  static Rect i;
  static Rect j;
  static Rect k;
  private static final Drawable r = u.a().getResources().getDrawable(2130837648);
  private static final Drawable s = u.a().getResources().getDrawable(2130837649);
  private static final Drawable t = u.a().getResources().getDrawable(2130837640);
  private static final Drawable u = u.a().getResources().getDrawable(2130837641);
  private static final Drawable v = u.a().getResources().getDrawable(2130837637);
  j a;
  Rect b = new Rect();
  boolean c;
  boolean d;
  public int e = -1;
  float f;
  View g;
  View h;
  protected final pv l;
  protected final cc m;
  private int n;
  private int o;
  private Paint p;
  private boolean q;
  
  static
  {
    i = new Rect();
    j = new Rect();
    k = new Rect();
    r.getPadding(i);
    t.getPadding(j);
    t.getPadding(k);
  }
  
  public at(Context paramContext, j paramj)
  {
    super(paramContext);
    if (isInEditMode())
    {
      paramContext = null;
      this.l = paramContext;
      if (!isInEditMode()) {
        break label142;
      }
      paramContext = (Context)localObject;
      label48:
      this.m = paramContext;
      this.a = paramj;
      if (!paramj.e.b) {
        break label149;
      }
    }
    label142:
    label149:
    for (int i1 = getOutgoingLayoutId();; i1 = getIncomingLayoutId())
    {
      if (a()) {
        i1 = getCenteredLayoutId();
      }
      if (al.a(this.l, LayoutInflater.from(getContext()), i1, this, true) != null) {
        break label157;
      }
      throw new RuntimeException("rootview for conversationRow is null, rightLayout=" + paramj.e.b);
      paramContext = pv.a();
      break;
      paramContext = cc.a();
      break label48;
    }
    label157:
    this.g = getChildAt(0);
  }
  
  private float getBubbleWidth()
  {
    int i1;
    if (a()) {
      i1 = 0;
    }
    for (;;)
    {
      return i1 + this.g.getMeasuredWidth();
      if (this.a.e.b) {
        i1 = i.left + i.right;
      } else {
        i1 = j.left + j.right;
      }
    }
  }
  
  protected abstract boolean a();
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof ViewGroup.MarginLayoutParams;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new ViewGroup.MarginLayoutParams(paramLayoutParams);
  }
  
  protected int getBubbleAlpha()
  {
    return 255;
  }
  
  int getBubbleMarginStart()
  {
    return aoa.a().b;
  }
  
  protected abstract int getCenteredLayoutId();
  
  protected abstract int getIncomingLayoutId();
  
  int getMainChildMaxWidth()
  {
    return 0;
  }
  
  protected abstract int getOutgoingLayoutId();
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.d)
    {
      if (this.p == null) {
        this.p = new Paint(1);
      }
      this.p.setColor(570425344);
      this.p.setStrokeWidth(aoa.a().a * 2.0F);
      this.p.setStyle(Paint.Style.STROKE);
      paramCanvas.drawLine(0.0F, getHeight() - getPaddingBottom(), getWidth(), getHeight() - getPaddingBottom(), this.p);
      super.onDraw(paramCanvas);
      return;
    }
    int i1;
    if (this.f > 0.0F)
    {
      i1 = (int)(77.0F * this.f);
      if (this.p == null) {
        this.p = new Paint(1);
      }
      this.p.setColor(i1 << 24 | 0x33B5E5);
      paramCanvas.drawRect(0.0F, this.n - i.top - aoa.a().s, getWidth(), this.o + i.bottom + aoa.a().t, this.p);
    }
    int i2;
    int i3;
    Object localObject;
    if ((isSelected()) || (isPressed()) || (isFocused()) || (this.q))
    {
      i1 = 1;
      i2 = i1;
      if (this.c)
      {
        i2 = i1;
        if (i1 != 0)
        {
          if (this.p == null) {
            this.p = new Paint(1);
          }
          this.p.setColor(1295234533);
          paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.p);
          i2 = 0;
        }
      }
      if ((this.a.d == -1) || ((this.a.d == 6) && (this.a.s != 8))) {
        break label1105;
      }
      i1 = (int)getBubbleWidth();
      if (!a()) {
        break label522;
      }
      i3 = (getWidth() - i1) / 2;
      this.b.set(i3 - k.left, this.n - k.top, i3 + i1, this.o + k.bottom);
      if (i2 == 0) {
        break label505;
      }
      localObject = b.a(getContext(), 2130837638);
      label417:
      this.b.offset(getBubbleMarginStart(), 0);
      if (localObject != null)
      {
        ((Drawable)localObject).setDither(true);
        ((Drawable)localObject).setBounds(this.b);
        if (this.c != this.l.d()) {
          break label513;
        }
        paramCanvas.save();
        paramCanvas.scale(-1.0F, 1.0F, this.b.exactCenterX(), 0.0F);
        ((Drawable)localObject).draw(paramCanvas);
        paramCanvas.restore();
      }
    }
    for (;;)
    {
      super.onDraw(paramCanvas);
      return;
      i1 = 0;
      break;
      label505:
      localObject = v;
      break label417;
      label513:
      ((Drawable)localObject).draw(paramCanvas);
      continue;
      label522:
      label563:
      int i4;
      int i5;
      label664:
      Rect localRect;
      if (this.a.e.b)
      {
        localObject = this.b;
        if (this.l.d() != this.c)
        {
          i3 = getWidth() - i1;
          i4 = this.n;
          i5 = i.top;
          if (this.l.d() != this.c) {
            i1 = getWidth();
          }
          ((Rect)localObject).set(i3, i4 - i5, i1, this.o + i.bottom);
          switch (this.e)
          {
          default: 
            if (i2 != 0)
            {
              localObject = b.a(getContext(), 2130837650);
              localRect = this.b;
              if (this.l.d() == this.c) {
                break label806;
              }
            }
            break;
          }
        }
        label806:
        for (i1 = -getBubbleMarginStart();; i1 = getBubbleMarginStart())
        {
          localRect.offset(i1, 0);
          if (localObject == null) {
            break;
          }
          ((Drawable)localObject).setDither(true);
          ((Drawable)localObject).setBounds(this.b);
          if (this.c != this.l.d()) {
            break label814;
          }
          paramCanvas.save();
          paramCanvas.scale(-1.0F, 1.0F, this.b.exactCenterX(), 0.0F);
          ((Drawable)localObject).draw(paramCanvas);
          paramCanvas.restore();
          break;
          i3 = 0;
          break label563;
          if (i2 != 0)
          {
            localObject = b.a(getContext(), 2130837651);
            break label664;
          }
          localObject = s;
          break label664;
          localObject = r;
          break label664;
        }
        label814:
        ((Drawable)localObject).draw(paramCanvas);
      }
      else
      {
        localObject = this.b;
        if (this.l.d())
        {
          i3 = 0;
          label842:
          i4 = this.n;
          i5 = j.top;
          if (!this.l.d()) {
            break label1019;
          }
          label866:
          ((Rect)localObject).set(i3, i4 - i5, i1, this.o + j.bottom);
          switch (this.e)
          {
          default: 
            if (i2 != 0)
            {
              localObject = b.a(getContext(), 2130837642);
              label932:
              localRect = this.b;
              if (!this.l.d()) {
                break label1062;
              }
            }
            break;
          }
        }
        label1019:
        label1062:
        for (i1 = getBubbleMarginStart();; i1 = -getBubbleMarginStart())
        {
          localRect.offset(i1, 0);
          if (localObject == null) {
            break;
          }
          ((Drawable)localObject).setAlpha(getBubbleAlpha());
          ((Drawable)localObject).setBounds(this.b);
          ((Drawable)localObject).setDither(true);
          if (!this.l.d()) {
            break label1071;
          }
          ((Drawable)localObject).draw(paramCanvas);
          break;
          i3 = getWidth() - i1;
          break label842;
          i1 = getWidth();
          break label866;
          if (i2 != 0)
          {
            localObject = b.a(getContext(), 2130837643);
            break label932;
          }
          localObject = u;
          break label932;
          localObject = t;
          break label932;
        }
        label1071:
        paramCanvas.save();
        paramCanvas.scale(-1.0F, 1.0F, this.b.exactCenterX(), 0.0F);
        ((Drawable)localObject).draw(paramCanvas);
        paramCanvas.restore();
        continue;
        label1105:
        this.b.set(0, this.n - i.top, getWidth(), this.o + i.bottom);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getPaddingTop();
    paramInt1 = paramInt2;
    if (this.h != null)
    {
      paramInt1 = paramInt2;
      if (this.h.getVisibility() != 8)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.h.getLayoutParams();
        paramInt1 = paramInt2 + localMarginLayoutParams.topMargin;
        paramInt2 = this.h.getMeasuredWidth();
        paramInt3 = this.h.getMeasuredHeight();
        paramInt4 = (getMeasuredWidth() - paramInt2) / 2;
        this.h.layout(paramInt4, paramInt1, paramInt2 + paramInt4, paramInt1 + paramInt3);
        paramInt1 = localMarginLayoutParams.bottomMargin + paramInt3 + paramInt1;
      }
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.g.getLayoutParams();
    paramInt2 = paramInt1 + localMarginLayoutParams.topMargin;
    if ((this.a.d == 6) && (this.a.s != 8)) {
      paramInt1 = (getMeasuredWidth() - this.g.getMeasuredWidth()) / 2;
    }
    for (;;)
    {
      this.g.layout(paramInt1, paramInt2, this.g.getMeasuredWidth() + paramInt1, this.g.getMeasuredHeight() + paramInt2);
      this.n = this.g.getTop();
      this.o = this.g.getBottom();
      return;
      if (a())
      {
        paramInt1 = (getMeasuredWidth() - this.g.getMeasuredWidth()) / 2;
      }
      else if ((this.c) && (this.a.e.b))
      {
        if (this.l.d())
        {
          paramInt1 = getPaddingLeft();
          paramInt1 = localMarginLayoutParams.rightMargin + paramInt1;
        }
        else
        {
          paramInt1 = getMeasuredWidth() - getPaddingRight() - localMarginLayoutParams.leftMargin - this.g.getMeasuredWidth();
        }
      }
      else if (this.a.e.b == this.l.d())
      {
        paramInt1 = getMeasuredWidth() - getPaddingRight() - localMarginLayoutParams.rightMargin - this.g.getMeasuredWidth();
      }
      else
      {
        paramInt1 = getPaddingLeft();
        paramInt1 = localMarginLayoutParams.leftMargin + paramInt1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i7 = View.MeasureSpec.getMode(paramInt1);
    int i6 = View.MeasureSpec.getSize(paramInt1);
    int i8 = View.MeasureSpec.getMode(paramInt2);
    int i9 = View.MeasureSpec.getSize(paramInt2);
    int i4 = getPaddingLeft() + getPaddingRight();
    int i5 = getPaddingTop() + getPaddingBottom();
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int i1;
    if ((this.h != null) && (this.h.getVisibility() != 8))
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.h.getLayoutParams();
      if (localMarginLayoutParams.height >= 0)
      {
        i1 = localMarginLayoutParams.height;
        if (localMarginLayoutParams.width < 0) {
          break label341;
        }
        i2 = localMarginLayoutParams.width;
        label106:
        this.h.measure(i2, i1);
        i1 = this.h.getMeasuredHeight();
        i2 = localMarginLayoutParams.topMargin;
      }
    }
    for (int i2 = localMarginLayoutParams.bottomMargin + i2 + (i1 + i5);; i2 = i5)
    {
      localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.g.getLayoutParams();
      label178:
      label237:
      int i3;
      if (localMarginLayoutParams.height >= 0)
      {
        paramInt2 = View.MeasureSpec.makeMeasureSpec(localMarginLayoutParams.height, 1073741824);
        if (i7 == 0) {
          break label460;
        }
        i1 = i6 - i4 - localMarginLayoutParams.leftMargin - localMarginLayoutParams.rightMargin;
        paramInt1 = i1;
        if (localMarginLayoutParams.width >= 0)
        {
          paramInt1 = i1;
          if (localMarginLayoutParams.width < i1) {
            paramInt1 = localMarginLayoutParams.width;
          }
        }
        if (!this.d) {
          break label445;
        }
        i1 = 0;
        i3 = paramInt1;
        if (i1 != 0)
        {
          i3 = paramInt1;
          if (paramInt1 > i1) {
            i3 = i1;
          }
        }
        if (localMarginLayoutParams.width < 0) {
          break label453;
        }
        paramInt1 = 1073741824;
        label267:
        paramInt1 = View.MeasureSpec.makeMeasureSpec(i3, paramInt1);
      }
      for (;;)
      {
        this.g.measure(paramInt1, paramInt2);
        paramInt1 = this.g.getMeasuredHeight();
        paramInt2 = localMarginLayoutParams.topMargin;
        setMeasuredDimension(i6, localMarginLayoutParams.bottomMargin + (paramInt1 + paramInt2) + i2);
        return;
        if (i8 != 0)
        {
          i1 = View.MeasureSpec.makeMeasureSpec(i9 - i5, Integer.MIN_VALUE);
          break;
        }
        i1 = paramInt2;
        break;
        label341:
        if (i7 != 0)
        {
          label356:
          int i10;
          int i11;
          if (this.c)
          {
            i2 = 0;
            i10 = localMarginLayoutParams.leftMargin;
            i11 = localMarginLayoutParams.rightMargin;
            if (localMarginLayoutParams.width != -1) {
              break label412;
            }
          }
          label412:
          for (i3 = 1073741824;; i3 = Integer.MIN_VALUE)
          {
            i2 = View.MeasureSpec.makeMeasureSpec(i6 - i2 - i10 - i11, i3);
            break;
            i2 = i4;
            break label356;
          }
        }
        i2 = paramInt1;
        break label106;
        if (i8 == 0) {
          break label178;
        }
        paramInt2 = View.MeasureSpec.makeMeasureSpec(i9 - i2, i8);
        break label178;
        label445:
        i1 = getMainChildMaxWidth();
        break label237;
        label453:
        paramInt1 = Integer.MIN_VALUE;
        break label267;
        label460:
        if (localMarginLayoutParams.width >= 0) {
          paramInt1 = View.MeasureSpec.makeMeasureSpec(localMarginLayoutParams.width, 1073741824);
        }
      }
    }
  }
  
  public void setChildPressed(boolean paramBoolean)
  {
    if (this.q != paramBoolean)
    {
      this.q = paramBoolean;
      invalidate();
    }
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  final class a
    extends Animation
  {
    private a() {}
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      at.a(at.this, 1.0F - paramFloat);
      at.this.invalidate();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */