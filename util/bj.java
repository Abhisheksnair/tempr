package com.whatsapp.util;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public final class bj
{
  private int a;
  private ViewConfiguration b;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private boolean i;
  private boolean j;
  private float k;
  private float l;
  private boolean m;
  private boolean n;
  private boolean o;
  private float p = 0.0F;
  
  public bj()
  {
    this.a = 8;
  }
  
  public bj(Context paramContext)
  {
    this.b = ViewConfiguration.get(paramContext);
    this.a = this.b.getScaledTouchSlop();
  }
  
  private void a()
  {
    this.i = false;
    this.j = false;
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    int i1;
    MotionEvent localMotionEvent;
    if (!this.o)
    {
      i1 = 1;
      localMotionEvent = paramMotionEvent;
      if (i1 != 0)
      {
        localMotionEvent = paramMotionEvent;
        if (paramMotionEvent.getAction() != 0)
        {
          localMotionEvent = MotionEvent.obtain(paramMotionEvent);
          localMotionEvent.setAction(0);
        }
      }
      switch (localMotionEvent.getAction() & 0xFF)
      {
      }
    }
    for (;;)
    {
      if ((this.i) || (this.j)) {
        bool = true;
      }
      return bool;
      i1 = 0;
      break;
      this.o = true;
      this.c = localMotionEvent.getX();
      this.d = localMotionEvent.getY();
      this.g = this.c;
      this.h = this.d;
      a();
      continue;
      this.e = localMotionEvent.getX();
      this.f = localMotionEvent.getY();
      float f1 = this.e;
      float f2 = this.f;
      if ((Math.abs(this.g - f1) > 0.0F) || (Math.abs(this.h - f2) > 0.0F))
      {
        this.g = f1;
        this.h = f2;
      }
      for (i1 = 1;; i1 = 0)
      {
        if (i1 != 0) {
          break label255;
        }
        a();
        break;
      }
      label255:
      this.k = (this.c - this.e);
      this.l = (this.d - this.f);
      f1 = this.k;
      f2 = this.l;
      if (this.m)
      {
        this.j = false;
        this.i = true;
      }
      else if (this.n)
      {
        this.j = true;
        this.i = false;
      }
      else
      {
        if (f1 > this.a) {
          this.i = true;
        }
        if (f2 > this.a)
        {
          this.j = true;
          continue;
          this.o = false;
          a();
          continue;
          this.c = localMotionEvent.getX();
          this.d = localMotionEvent.getY();
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */