package com.whatsapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import com.whatsapp.util.Log;

public class AnswerCallView
  extends View
{
  private static final int t = u.a().getResources().getColor(2131624095);
  private static final int u = u.a().getResources().getColor(2131623985);
  private static final int v = u.a().getResources().getColor(2131623986);
  private static final int[] w = { 0, 70, 130 };
  boolean a;
  boolean b;
  private Paint c = new Paint(1);
  private Drawable d;
  private Drawable e;
  private Drawable f;
  private Drawable g;
  private boolean h;
  private boolean i;
  private float j;
  private float k;
  private Path l = new Path();
  private Path m = new Path();
  private Path n = new Path();
  private int o = -1;
  private int p = -1;
  private a q;
  private b r;
  private float s;
  
  public AnswerCallView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AnswerCallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = paramContext.getResources().getDrawable(2130840111);
    this.e = paramContext.getResources().getDrawable(2130840110);
    this.f = paramContext.getResources().getDrawable(2130840118);
    this.g = paramContext.getResources().getDrawable(2130840116);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    this.k = paramMotionEvent.getX(paramMotionEvent.getActionIndex());
    invalidate();
  }
  
  protected void onAttachedToWindow()
  {
    Log.i("voip/AnswerCallView/onAttachedToWindow visibility: " + getVisibility());
    super.onAttachedToWindow();
    if (getVisibility() == 0)
    {
      this.r = new b((byte)0);
      this.r.setDuration(800L);
      this.r.setRepeatCount(-1);
      this.r.setInterpolator(new DecelerateInterpolator());
      startAnimation(this.r);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    Log.i("voip/AnswerCallView/onDetachedFromWindow visibility: " + getVisibility());
    super.onDetachedFromWindow();
    clearAnimation();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(0);
    int i7 = getWidth();
    int i6 = getHeight();
    int i2;
    if (this.a) {
      i2 = i7 - i6;
    }
    for (;;)
    {
      int i1;
      if (this.b) {
        i1 = i7 - i6;
      }
      for (;;)
      {
        label48:
        int i8;
        int i3;
        int i4;
        int i5;
        if ((!this.i) && (!this.h) && (!this.a) && (!this.b))
        {
          paramCanvas.save();
          paramCanvas.translate(i6 - i6 / 4 + this.s * (i7 - i6 * 5 / 2), 0.0F);
          localObject = w;
          i8 = localObject.length;
          i3 = 0;
          for (;;)
          {
            if (i3 < i8)
            {
              i4 = localObject[i3];
              this.c.setColor(t);
              i5 = 255 - i4;
              i4 = i5;
              if (this.s > 0.8F) {
                i4 = (int)(i5 * 5 * (1.0F - this.s));
              }
              this.c.setAlpha(i4);
              paramCanvas.drawPath(this.n, this.c);
              paramCanvas.translate(i6 * -2 / 5, 0.0F);
              i3 += 1;
              continue;
              if (!this.h) {
                break label844;
              }
              i2 = Math.min((int)(this.k - this.j), i7 - i6);
              break;
              if (!this.i) {
                break label839;
              }
              i1 = Math.min((int)(this.j - this.k), i7 - i6);
              break label48;
            }
          }
          paramCanvas.restore();
          this.c.setAlpha(255);
        }
        if ((!this.i) && (!this.b))
        {
          if (this.o != i2)
          {
            this.o = i2;
            this.l.rewind();
            this.l.moveTo(0.0F, 0.0F);
            this.l.lineTo(i6 + i2, 0.0F);
            this.l.lineTo(i6 / 4 + i6 + i2, i6 / 2);
            this.l.lineTo(i6 + i2, i6);
            this.l.lineTo(0.0F, i6);
            this.l.lineTo(0.0F, 0.0F);
            this.l.close();
            this.l.setFillType(Path.FillType.WINDING);
          }
          if ((this.h) || (this.a))
          {
            this.c.setColor(u);
            localObject = this.e;
            this.c.setStyle(Paint.Style.FILL);
            paramCanvas.drawPath(this.l, this.c);
            i3 = ((Drawable)localObject).getIntrinsicHeight();
            i4 = ((Drawable)localObject).getIntrinsicWidth();
            i5 = (i6 - i4) / 2;
            i8 = (i6 - i3) / 2;
            ((Drawable)localObject).setBounds(i5 + i2, i8, i2 + (i4 + i5), i3 + i8);
            ((Drawable)localObject).draw(paramCanvas);
          }
        }
        else if ((!this.h) && (!this.a))
        {
          if (this.p != i1)
          {
            this.m.rewind();
            this.m.moveTo(i7, 0.0F);
            this.m.lineTo(i7 - i6 - i1, 0.0F);
            this.m.lineTo(i7 - i6 - i6 / 4 - i1, i6 / 2);
            this.m.lineTo(i7 - i6 - i1, i6);
            this.m.lineTo(i7, i6);
            this.m.lineTo(i7, 0.0F);
            this.m.close();
            this.m.setFillType(Path.FillType.WINDING);
            this.p = i1;
          }
          if ((!this.i) && (!this.b)) {
            break label820;
          }
          this.c.setColor(v);
        }
        for (Object localObject = this.g;; localObject = this.f)
        {
          this.c.setStyle(Paint.Style.FILL);
          paramCanvas.drawPath(this.m, this.c);
          i2 = ((Drawable)localObject).getIntrinsicHeight();
          i3 = ((Drawable)localObject).getIntrinsicWidth();
          i4 = i7 - (i6 + i3) / 2;
          i5 = (i6 - i2) / 2;
          ((Drawable)localObject).setBounds(i4 - i1, i5, i3 + i4 - i1, i2 + i5);
          ((Drawable)localObject).draw(paramCanvas);
          return;
          this.c.setColor(t);
          localObject = this.d;
          break;
          label820:
          this.c.setColor(t);
        }
        label839:
        i1 = 0;
      }
      label844:
      i2 = 0;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getHeight();
    this.n.rewind();
    this.n.moveTo(0.0F, 0.0F);
    this.n.lineTo(paramInt1 / 4, 0.0F);
    this.n.lineTo(paramInt1 / 2, paramInt1 / 2);
    this.n.lineTo(paramInt1 / 4, paramInt1);
    this.n.lineTo(0.0F, paramInt1);
    this.n.lineTo(paramInt1 / 4, paramInt1 / 2);
    this.n.close();
    this.n.setFillType(Path.FillType.WINDING);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i1;
    switch (paramMotionEvent.getActionMasked())
    {
    case 4: 
    default: 
      i1 = 0;
    }
    for (;;)
    {
      invalidate();
      if (i1 == 0)
      {
        bool1 = bool2;
        if (!super.onTouchEvent(paramMotionEvent)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      Log.i("voip/AnswerCallView/onTouchEvent/ACTION_DOWN");
      float f1 = paramMotionEvent.getX(paramMotionEvent.getActionIndex());
      if ((f1 > 0.0F) && (f1 < getHeight() * 5 / 4)) {
        this.h = true;
      }
      if ((f1 < getWidth()) && (f1 > getWidth() - getHeight() * 5 / 4)) {
        this.i = true;
      }
      this.j = f1;
      this.k = f1;
      a(paramMotionEvent);
      i1 = 1;
      continue;
      a(paramMotionEvent);
      i1 = 1;
      continue;
      Log.i("voip/AnswerCallView/onTouchEvent/ACTION_UP");
      a(paramMotionEvent);
      f1 = paramMotionEvent.getX(paramMotionEvent.getActionIndex());
      if (this.q != null)
      {
        if ((!this.h) || (f1 <= getWidth() / 2)) {
          break label262;
        }
        if (!this.a)
        {
          this.q.a();
          this.a = true;
        }
      }
      for (;;)
      {
        this.h = false;
        this.i = false;
        i1 = 1;
        break;
        label262:
        if ((!this.i) || (f1 >= getWidth() / 2)) {
          break label305;
        }
        if (!this.b)
        {
          this.q.b();
          this.b = true;
        }
      }
      label305:
      a locala = this.q;
      if (!this.i) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        locala.a(bool1);
        break;
      }
      a(paramMotionEvent);
      this.h = false;
      this.i = false;
      i1 = 1;
    }
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    Log.i("voip/AnswerCallView/onVisibilityChanged " + paramInt);
    if (getVisibility() != 0) {
      clearAnimation();
    }
    while ((getAnimation() != null) || (this.r == null)) {
      return;
    }
    startAnimation(this.r);
  }
  
  public void setAnswerCallListener(a parama)
  {
    this.q = parama;
  }
  
  static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(boolean paramBoolean);
    
    public abstract void b();
  }
  
  final class b
    extends Animation
  {
    private b() {}
    
    protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      AnswerCallView.a(AnswerCallView.this, paramFloat);
      AnswerCallView.this.invalidate();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/AnswerCallView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */