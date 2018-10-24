package com.whatsapp.doodle;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import com.whatsapp.adn;
import com.whatsapp.pv;

public class ColorPickerView
  extends View
{
  boolean a;
  private final Paint b = new Paint();
  private final Paint c = new Paint(1);
  private int[] d;
  private int e;
  private int f;
  private Bitmap g;
  private int h;
  private int i;
  private int j;
  private int k = -65536;
  private float l;
  private int m = 1;
  private a n;
  private final pv o;
  
  public ColorPickerView(Context paramContext)
  {
    super(paramContext);
    if (isInEditMode()) {}
    for (pv localpv = null;; localpv = pv.a())
    {
      this.o = localpv;
      a(paramContext, null);
      return;
    }
  }
  
  public ColorPickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {}
    for (pv localpv = null;; localpv = pv.a())
    {
      this.o = localpv;
      a(paramContext, paramAttributeSet);
      return;
    }
  }
  
  public ColorPickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode()) {}
    for (pv localpv = null;; localpv = pv.a())
    {
      this.o = localpv;
      a(paramContext, paramAttributeSet);
      return;
    }
  }
  
  @TargetApi(21)
  public ColorPickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    if (isInEditMode()) {}
    for (pv localpv = null;; localpv = pv.a())
    {
      this.o = localpv;
      a(paramContext, paramAttributeSet);
      return;
    }
  }
  
  private void a()
  {
    int i5;
    int i4;
    int i7;
    int i6;
    if (this.m == 3)
    {
      i2 = this.e / 5 + 1;
      i1 = 0;
      while (i1 < this.e)
      {
        i5 = i1 / i2;
        i3 = i1 % i2;
        i4 = com.whatsapp.doodle.a.h.c[i5];
        i7 = com.whatsapp.doodle.a.h.c[(i5 + 1)];
        i5 = (int)(Color.red(i4) * 1.0F * (i2 - i3) / i2 + Color.red(i7) * 1.0F * i3 / i2);
        i6 = (int)(Color.green(i4) * 1.0F * (i2 - i3) / i2 + Color.green(i7) * 1.0F * i3 / i2);
        float f1 = Color.blue(i4) * 1.0F * (i2 - i3) / i2;
        i3 = (int)(Color.blue(i7) * 1.0F * i3 / i2 + f1);
        this.d[i1] = Color.argb(255, i5, i6, i3);
        i1 += 1;
      }
    }
    int i3 = this.e / 10;
    int i2 = this.e;
    label244:
    label263:
    int i8;
    if (this.m == 2)
    {
      i1 = 50;
      i4 = i2 / i1;
      i5 = this.e / 10;
      if (this.m != 2) {
        break label395;
      }
      i1 = this.e / 4;
      i6 = this.e - i5 - i4 - i3 - i1;
      i2 = 0;
      if (i2 >= i3) {
        break label426;
      }
      i7 = i2 * 255 / i3;
      if (this.m != 2) {
        break label400;
      }
      i7 = (i3 - i2) * 255 / i3;
      i8 = i2 * 255 / i3;
      int i9 = (i3 - i2) * 204 / i3;
      int i10 = i2 * 255 / i3;
      int i11 = (i3 - i2) * 77 / i3;
      int i12 = i2 * 255 / i3;
      this.d[i2] = Color.argb(255, i7 + i8, i9 + i10, i11 + i12);
    }
    for (;;)
    {
      i2 += 1;
      break label263;
      i1 = 30;
      break;
      label395:
      i1 = 0;
      break label244;
      label400:
      this.d[i2] = (i7 | 0xFF000000 | i7 << 16 | i7 << 8);
    }
    label426:
    i2 = 0;
    while (i2 < i4)
    {
      this.d[(i3 + i2)] = -1;
      i2 += 1;
    }
    Object localObject = new float[3];
    localObject[0] = 0.0F;
    localObject[2] = 1.0F;
    i2 = 0;
    while (i2 < i5)
    {
      localObject[1] = (i2 / i5);
      this.d[(i3 + i4 + i2)] = Color.HSVToColor((float[])localObject);
      i2 += 1;
    }
    localObject[1] = 0.8F;
    localObject[2] = 1.0F;
    i2 = 0;
    while (i2 < i6)
    {
      localObject[0] = (i2 * 360.0F / i6);
      this.d[(i3 + i4 + i5 + i2)] = Color.HSVToColor((float[])localObject);
      i2 += 1;
    }
    i2 = 0;
    while (i2 < i1)
    {
      i7 = i2 * 204 / i1;
      i8 = i2 * 77 / i1;
      this.d[(i3 + i4 + i5 + i6 + i2)] = Color.argb(255, 255, i7, i8);
      i2 += 1;
    }
    localObject = new Path();
    ((Path)localObject).setFillType(Path.FillType.WINDING);
    ((Path)localObject).addRoundRect(new RectF(1.0F, 1.0F, this.f - 1, this.e - 1), this.f / 3, this.f / 3, Path.Direction.CW);
    if ((this.g == null) || (this.g.getWidth() != this.f) || (this.g.getHeight() != this.e)) {
      this.g = Bitmap.createBitmap(this.f, this.e, Bitmap.Config.ARGB_8888);
    }
    Canvas localCanvas = new Canvas(this.g);
    this.b.setStyle(Paint.Style.STROKE);
    localCanvas.clipPath((Path)localObject);
    this.b.setStrokeWidth(1.0F);
    int i1 = 0;
    while (i1 < this.e)
    {
      this.b.setColor(this.d[i1]);
      localCanvas.drawLine(0.0F, i1, this.f, i1, this.b);
      i1 += 1;
    }
    localCanvas.clipRect(new Rect(0, 0, this.f, this.e), Region.Op.REPLACE);
    this.c.setColor(-1716868438);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setStrokeWidth(1.0F);
    localCanvas.drawPath((Path)localObject, this.c);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, adn.ColorPicker);
      this.f = ((int)paramContext.getDimension(0, 1.0F));
      this.h = ((int)paramContext.getDimension(1, 1.0F));
      this.i = ((int)paramContext.getDimension(2, 1.0F));
      this.l = this.h;
      paramContext.recycle();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Bitmap localBitmap = this.g;
    if (this.o.d()) {}
    for (float f1 = getWidth() - getPaddingRight() - this.f;; f1 = getPaddingLeft())
    {
      paramCanvas.drawBitmap(localBitmap, f1, getPaddingTop(), this.b);
      return;
    }
  }
  
  public int getColor()
  {
    return this.k;
  }
  
  public float getMinSize()
  {
    return this.h;
  }
  
  public float getSize()
  {
    return this.l;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.j != 0) && (getMeasuredHeight() > this.j)) {
      setMeasuredDimension(getMeasuredWidth(), this.j);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    this.k = SavedState.a(paramParcelable);
    this.l = SavedState.b(paramParcelable);
    super.onRestoreInstanceState(paramParcelable.getSuperState());
  }
  
  public Parcelable onSaveInstanceState()
  {
    return new SavedState(super.onSaveInstanceState(), this.k, this.l, (byte)0);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.e = Math.max(1, paramInt2 - getPaddingTop() - getPaddingBottom());
    if ((this.d == null) || (this.d.length < this.e)) {
      this.d = new int[this.e];
    }
    a();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i3 = paramMotionEvent.getActionMasked();
    if (paramMotionEvent.getPointerCount() > 1) {}
    while (((i3 == 5) || (i3 == 0)) && (((paramMotionEvent.getX() < getWidth() - getPaddingRight() - this.f * 2) && (this.o.d())) || ((paramMotionEvent.getX() > getPaddingLeft() + this.f * 2) && (!this.o.d())))) {
      return false;
    }
    switch (i3)
    {
    }
    for (;;)
    {
      invalidate();
      return true;
      if (this.n != null)
      {
        int i2 = (int)paramMotionEvent.getY() - getPaddingTop();
        int i1 = i2;
        if (i2 < 0) {
          i1 = 0;
        }
        i2 = i1;
        if (i1 >= this.e) {
          i2 = this.e - 1;
        }
        if (this.d[i2] != this.k)
        {
          this.k = this.d[i2];
          if (!this.o.d()) {
            break label350;
          }
        }
        label350:
        for (float f1 = getWidth() - paramMotionEvent.getX();; f1 = paramMotionEvent.getX())
        {
          float f2 = this.f + getPaddingLeft() + getPaddingRight();
          if (f1 > f2)
          {
            float f3 = this.h;
            this.l = ((f1 - f2) * (this.i - this.h) / (getWidth() - f2) + f3);
          }
          this.a = true;
          this.n.a(this.l, this.k);
          if ((i3 != 6) && (i3 != 1)) {
            break;
          }
          this.a = false;
          this.n.a();
          break;
        }
        this.a = false;
        this.n.a();
      }
    }
  }
  
  public void setColor(int paramInt)
  {
    this.k = paramInt;
    invalidate();
  }
  
  public void setColorPalette(int paramInt)
  {
    this.m = paramInt;
    a();
    invalidate();
  }
  
  public void setListener(a parama)
  {
    this.n = parama;
  }
  
  public void setMaxHeight(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setSize(float paramFloat)
  {
    this.l = paramFloat;
    invalidate();
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    private final int a;
    private final float b;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.a = paramParcel.readInt();
      this.b = paramParcel.readFloat();
    }
    
    private SavedState(Parcelable paramParcelable, int paramInt, float paramFloat)
    {
      super();
      this.a = paramInt;
      this.b = paramFloat;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.a);
      paramParcel.writeFloat(this.b);
    }
  }
  
  static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(float paramFloat, int paramInt);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/ColorPickerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */