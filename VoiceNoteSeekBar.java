package com.whatsapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class VoiceNoteSeekBar
  extends View
{
  private int a;
  private boolean b;
  private float c;
  private int d;
  private int e;
  private int f = 20;
  private int g = 10;
  private int h = 44319;
  private int i = 536870912;
  private final Paint j = new Paint(1);
  private final Rect k = new Rect();
  private SeekBar.OnSeekBarChangeListener l;
  private final pv m;
  
  public VoiceNoteSeekBar(Context paramContext)
  {
    super(paramContext);
    if (isInEditMode()) {}
    for (pv localpv = null;; localpv = pv.a())
    {
      this.m = localpv;
      a(paramContext, null);
      return;
    }
  }
  
  public VoiceNoteSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {}
    for (pv localpv = null;; localpv = pv.a())
    {
      this.m = localpv;
      a(paramContext, paramAttributeSet);
      return;
    }
  }
  
  public VoiceNoteSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode()) {}
    for (pv localpv = null;; localpv = pv.a())
    {
      this.m = localpv;
      a(paramContext, paramAttributeSet);
      return;
    }
  }
  
  private void a()
  {
    this.b = true;
    if (this.l != null) {
      this.l.onStartTrackingTouch(null);
    }
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.a = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, adn.VoiceNoteSeekBar);
      this.f = paramContext.getDimensionPixelSize(0, this.f);
      this.g = paramContext.getDimensionPixelSize(1, this.g);
      this.h = paramContext.getInteger(2, this.h);
      this.i = paramContext.getInteger(3, this.i);
      paramContext.recycle();
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    float f1 = 1.0F;
    int n = getWidth();
    int i1 = getPaddingLeft();
    int i2 = getPaddingRight();
    int i3 = n - i1 - i2;
    int i4 = (int)paramMotionEvent.getX();
    if (this.m.a) {
      if (i4 > n - i2) {
        f1 = 0.0F;
      }
    }
    for (;;)
    {
      setProgress((int)(f1 * getMax() + 0.0F));
      return;
      if (i4 >= i1)
      {
        f1 = (i3 - i4 + i1) / i3;
        continue;
        if (i4 < i1) {
          f1 = 0.0F;
        } else if (i4 <= n - i2) {
          f1 = (i4 - i1) / i3;
        }
      }
    }
  }
  
  private void b()
  {
    this.b = false;
    if (this.l != null) {
      this.l.onStopTrackingTouch(null);
    }
  }
  
  private void c()
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  public int getMax()
  {
    return this.e;
  }
  
  public int getProgress()
  {
    return this.d;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    for (;;)
    {
      int i2;
      int i4;
      try
      {
        i2 = getWidth();
        int i3 = getPaddingLeft();
        i4 = getPaddingRight();
        int n;
        int i5;
        if (isPressed())
        {
          n = this.f * 3 / 4;
          i1 = getMax();
          if (i1 <= 0) {
            break label331;
          }
          f1 = getProgress() / i1;
          i1 = (int)(f1 * (i2 - i3 - i4 - n * 2)) + n;
          if (isInEditMode()) {
            break label321;
          }
          if (!this.m.d()) {
            break label336;
          }
          break label321;
          i5 = getPaddingTop() + (getHeight() - getPaddingTop() - getPaddingBottom()) / 2;
          this.j.setColor(this.i);
          this.j.setStyle(Paint.Style.FILL);
          this.k.set(0, i5 - this.g / 2, getWidth(), this.g / 2 + i5);
          paramCanvas.drawRect(this.k, this.j);
          this.j.setColor(this.h);
          if ((isInEditMode()) || (this.m.d()))
          {
            this.k.set(i3, i5 - this.g / 2, i1, this.g / 2 + i5);
            paramCanvas.drawRect(this.k, this.j);
            paramCanvas.drawCircle(i1, i5, n, this.j);
          }
        }
        else
        {
          n = this.f / 2;
          continue;
        }
        this.k.set(i1, i5 - this.g / 2, i2 - i4, this.g / 2 + i5);
        continue;
        i1 += i3;
      }
      finally {}
      label321:
      continue;
      label331:
      float f1 = 0.0F;
      continue;
      label336:
      int i1 = i2 - i1 - i4;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = 0;
    if (!isEnabled()) {
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      int n;
      if (Build.VERSION.SDK_INT < 14)
      {
        n = 1;
        if (n != 0) {
          this.c = paramMotionEvent.getX();
        }
      }
      else
      {
        for (ViewParent localViewParent = getParent();; localViewParent = localViewParent.getParent())
        {
          n = i1;
          if (localViewParent == null) {
            break;
          }
          n = i1;
          if (!(localViewParent instanceof ViewGroup)) {
            break;
          }
          if (((ViewGroup)localViewParent).shouldDelayChildPressedState())
          {
            n = 1;
            break;
          }
        }
      }
      setPressed(true);
      invalidate();
      a();
      a(paramMotionEvent);
      c();
      continue;
      if (this.b)
      {
        a(paramMotionEvent);
      }
      else if (Math.abs(paramMotionEvent.getX() - this.c) > this.a)
      {
        setPressed(true);
        invalidate();
        a();
        a(paramMotionEvent);
        c();
        continue;
        if (this.b)
        {
          a(paramMotionEvent);
          b();
          setPressed(false);
        }
        for (;;)
        {
          invalidate();
          break;
          a();
          a(paramMotionEvent);
          b();
        }
        if (this.b)
        {
          b();
          setPressed(false);
        }
        invalidate();
      }
    }
  }
  
  public void setMax(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    this.l = paramOnSeekBarChangeListener;
  }
  
  public void setProgress(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      invalidate();
    }
  }
  
  public void setProgressColor(int paramInt)
  {
    this.h = paramInt;
    invalidate();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/VoiceNoteSeekBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */