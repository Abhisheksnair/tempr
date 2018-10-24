package com.whatsapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.g;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class PhotoViewPager
  extends ViewPager
{
  private float g;
  private int h;
  private float i;
  private float j;
  private b k;
  
  public PhotoViewPager(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public PhotoViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  private void c()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      a(true, new ViewPager.g()
      {
        @TargetApi(11)
        public final void a(View paramAnonymousView, float paramAnonymousFloat)
        {
          if ((paramAnonymousFloat < 0.0F) || (paramAnonymousFloat >= 1.0F))
          {
            paramAnonymousView.setTranslationX(0.0F);
            paramAnonymousView.setAlpha(1.0F);
            paramAnonymousView.setScaleX(1.0F);
            paramAnonymousView.setScaleY(1.0F);
            return;
          }
          paramAnonymousView.setTranslationX(-paramAnonymousFloat * paramAnonymousView.getWidth());
          paramAnonymousView.setAlpha(Math.max(0.0F, 1.0F - paramAnonymousFloat));
          paramAnonymousFloat = Math.max(0.0F, 1.0F - 0.3F * paramAnonymousFloat);
          paramAnonymousView.setScaleX(paramAnonymousFloat);
          paramAnonymousView.setScaleY(paramAnonymousFloat);
        }
      });
      return;
    }
    setPageMargin(getResources().getDimensionPixelSize(2131362066));
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = 1;
    int n;
    if (this.k != null)
    {
      n = this.k.a(this.i, this.j);
      int i2 = q.c(paramMotionEvent);
      if ((n != a.d) && (n != a.b) && (i2 <= 1)) {
        break label162;
      }
      m = 1;
      label59:
      if ((n != a.d) && (n != a.c) && (i2 <= 1)) {
        break label167;
      }
      n = 1;
      label84:
      i2 = paramMotionEvent.getAction() & 0xFF;
      if ((i2 == 3) || (i2 == 1)) {
        this.h = -1;
      }
      switch (i2)
      {
      }
    }
    label162:
    label167:
    do
    {
      for (;;)
      {
        return super.onInterceptTouchEvent(paramMotionEvent);
        n = a.a;
        break;
        m = 0;
        break label59;
        n = 0;
        break label84;
        if ((m != 0) || (n != 0))
        {
          i1 = this.h;
          if (i1 != -1)
          {
            float f = q.c(paramMotionEvent, q.a(paramMotionEvent, i1));
            if ((m != 0) && (n != 0))
            {
              this.g = f;
              return false;
            }
            if ((m != 0) && (f > this.g))
            {
              this.g = f;
              return false;
            }
            if ((n != 0) && (f < this.g))
            {
              this.g = f;
              return false;
              this.g = paramMotionEvent.getX();
              this.i = paramMotionEvent.getRawX();
              this.j = paramMotionEvent.getRawY();
              this.h = q.b(paramMotionEvent, 0);
            }
          }
        }
      }
      m = q.b(paramMotionEvent);
    } while (q.b(paramMotionEvent, m) != this.h);
    if (m == 0) {}
    for (int m = i1;; m = 0)
    {
      this.g = q.c(paramMotionEvent, m);
      this.h = q.b(paramMotionEvent, m);
      break;
    }
  }
  
  public void setOnInterceptTouchListener(b paramb)
  {
    this.k = paramb;
  }
  
  public static enum a {}
  
  public static abstract interface b
  {
    public abstract int a(float paramFloat1, float paramFloat2);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/PhotoViewPager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */