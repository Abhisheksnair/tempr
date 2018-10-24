package com.whatsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.f;
import android.support.v4.view.w;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.util.Locale;

public class PagerSlidingTabStrip
  extends HorizontalScrollView
{
  private static final int[] b = { 16842901, 16842904 };
  private int A = 1;
  private int B = 0;
  private int C = 2130837636;
  private Locale D;
  public ViewPager.f a;
  private LinearLayout.LayoutParams c;
  private LinearLayout.LayoutParams d;
  private final b e = new b((byte)0);
  private LinearLayout f;
  private ViewPager g;
  private int h;
  private int i = 0;
  private float j = 0.0F;
  private Paint k;
  private Paint l;
  private int m = -10066330;
  private int n = 436207616;
  private int o = 436207616;
  private boolean p = false;
  private boolean q = true;
  private int r = 52;
  private int s = 8;
  private int t = 2;
  private int u = 12;
  private int v = 24;
  private int w = 1;
  private int x = 12;
  private int y = -10066330;
  private Typeface z = null;
  
  public PagerSlidingTabStrip(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PagerSlidingTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PagerSlidingTabStrip(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFillViewport(true);
    setWillNotDraw(false);
    this.f = a(paramContext);
    this.f.setOrientation(0);
    this.f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    addView(this.f);
    Object localObject = getResources().getDisplayMetrics();
    this.r = ((int)TypedValue.applyDimension(1, this.r, (DisplayMetrics)localObject));
    this.s = ((int)TypedValue.applyDimension(1, this.s, (DisplayMetrics)localObject));
    this.t = ((int)TypedValue.applyDimension(1, this.t, (DisplayMetrics)localObject));
    this.u = ((int)TypedValue.applyDimension(1, this.u, (DisplayMetrics)localObject));
    this.v = ((int)TypedValue.applyDimension(1, this.v, (DisplayMetrics)localObject));
    this.w = ((int)TypedValue.applyDimension(1, this.w, (DisplayMetrics)localObject));
    this.x = ((int)TypedValue.applyDimension(2, this.x, (DisplayMetrics)localObject));
    localObject = paramContext.obtainStyledAttributes(paramAttributeSet, b);
    this.x = ((TypedArray)localObject).getDimensionPixelSize(0, this.x);
    this.y = ((TypedArray)localObject).getColor(1, this.y);
    ((TypedArray)localObject).recycle();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, adn.PagerSlidingTabStrip);
    this.m = paramContext.getColor(0, this.m);
    this.n = paramContext.getColor(1, this.n);
    this.o = paramContext.getColor(2, this.o);
    this.s = paramContext.getDimensionPixelSize(3, this.s);
    this.t = paramContext.getDimensionPixelSize(4, this.t);
    this.u = paramContext.getDimensionPixelSize(5, this.u);
    this.v = paramContext.getDimensionPixelSize(6, this.v);
    this.C = paramContext.getResourceId(8, this.C);
    this.p = paramContext.getBoolean(9, this.p);
    this.r = paramContext.getDimensionPixelSize(7, this.r);
    this.q = paramContext.getBoolean(10, this.q);
    paramContext.recycle();
    this.k = new Paint();
    this.k.setAntiAlias(true);
    this.k.setStyle(Paint.Style.FILL);
    this.l = new Paint();
    this.l.setAntiAlias(true);
    this.l.setStrokeWidth(this.w);
    this.c = new LinearLayout.LayoutParams(-2, -1);
    this.d = new LinearLayout.LayoutParams(0, -1, 1.0F);
    if (this.D == null) {
      this.D = getResources().getConfiguration().locale;
    }
  }
  
  private void a()
  {
    this.f.removeAllViews();
    this.h = this.g.getAdapter().b();
    int i1 = 0;
    if (i1 < this.h)
    {
      if ((this.g.getAdapter() instanceof c)) {
        a(i1, ((c)this.g.getAdapter()).f(i1));
      }
      for (;;)
      {
        i1 += 1;
        break;
        Object localObject;
        if ((this.g.getAdapter() instanceof a))
        {
          int i2 = ((a)this.g.getAdapter()).a();
          localObject = new ImageButton(getContext());
          ((ImageButton)localObject).setImageResource(i2);
          a(i1, (View)localObject);
        }
        else
        {
          localObject = this.g.getAdapter().c(i1).toString();
          TextView localTextView = new TextView(getContext());
          localTextView.setText((CharSequence)localObject);
          localTextView.setGravity(17);
          localTextView.setSingleLine();
          a(i1, localTextView);
        }
      }
    }
    b();
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      @SuppressLint({"NewApi"})
      public final void onGlobalLayout()
      {
        if (Build.VERSION.SDK_INT < 16) {
          PagerSlidingTabStrip.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
        for (;;)
        {
          PagerSlidingTabStrip.a(PagerSlidingTabStrip.this, PagerSlidingTabStrip.a(PagerSlidingTabStrip.this).getCurrentItem());
          PagerSlidingTabStrip.a(PagerSlidingTabStrip.this, PagerSlidingTabStrip.b(PagerSlidingTabStrip.this), 0);
          return;
          PagerSlidingTabStrip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
      }
    });
  }
  
  private void b()
  {
    int i1 = 0;
    if (i1 < this.h)
    {
      Object localObject = this.f.getChildAt(i1);
      ((View)localObject).setBackgroundResource(this.C);
      if ((localObject instanceof TextView))
      {
        localObject = (TextView)localObject;
        ((TextView)localObject).setTextSize(0, this.x);
        ((TextView)localObject).setTypeface(this.z, this.A);
        ((TextView)localObject).setTextColor(this.y);
        if (this.q)
        {
          if (Build.VERSION.SDK_INT < 14) {
            break label96;
          }
          ((TextView)localObject).setAllCaps(true);
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        label96:
        ((TextView)localObject).setText(((TextView)localObject).getText().toString().toUpperCase(this.D));
      }
    }
  }
  
  public LinearLayout a(Context paramContext)
  {
    return new LinearLayout(paramContext);
  }
  
  public void a(final int paramInt, View paramView)
  {
    paramView.setFocusable(true);
    paramView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        PagerSlidingTabStrip.a(PagerSlidingTabStrip.this).setCurrentItem(paramInt);
      }
    });
    paramView.setPadding(this.v, 0, this.v, 0);
    LinearLayout localLinearLayout = this.f;
    if (this.p) {}
    for (LinearLayout.LayoutParams localLayoutParams = this.d;; localLayoutParams = this.c)
    {
      localLinearLayout.addView(paramView, paramInt, localLayoutParams);
      return;
    }
  }
  
  public int getDividerColor()
  {
    return this.o;
  }
  
  public int getDividerPadding()
  {
    return this.u;
  }
  
  public int getIndicatorColor()
  {
    return this.m;
  }
  
  public int getIndicatorHeight()
  {
    return this.s;
  }
  
  public int getScrollOffset()
  {
    return this.r;
  }
  
  public boolean getShouldExpand()
  {
    return this.p;
  }
  
  public int getTabBackground()
  {
    return this.C;
  }
  
  public int getTabPaddingLeftRight()
  {
    return this.v;
  }
  
  public int getTextColor()
  {
    return this.y;
  }
  
  public int getTextSize()
  {
    return this.x;
  }
  
  public int getUnderlineColor()
  {
    return this.n;
  }
  
  public int getUnderlineHeight()
  {
    return this.t;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((isInEditMode()) || (this.h == 0)) {}
    for (;;)
    {
      return;
      int i2 = getHeight();
      this.k.setColor(this.m);
      View localView = this.f.getChildAt(this.i);
      float f4 = localView.getLeft();
      float f3 = localView.getRight();
      float f2 = f4;
      float f1 = f3;
      if (this.j > 0.0F)
      {
        f2 = f4;
        f1 = f3;
        if (this.i < this.h - 1)
        {
          localView = this.f.getChildAt(this.i + 1);
          f2 = localView.getLeft();
          f1 = localView.getRight();
          float f5 = this.j;
          f2 = f4 * (1.0F - this.j) + f2 * f5;
          f1 = f1 * this.j + (1.0F - this.j) * f3;
        }
      }
      paramCanvas.drawRect(f2, i2 - this.s, f1, i2, this.k);
      this.k.setColor(this.n);
      paramCanvas.drawRect(0.0F, i2 - this.t, this.f.getWidth(), i2, this.k);
      this.l.setColor(this.o);
      int i1 = 0;
      while (i1 < this.h - 1)
      {
        localView = this.f.getChildAt(i1);
        paramCanvas.drawLine(localView.getRight(), this.u, localView.getRight(), i2 - this.u, this.l);
        i1 += 1;
      }
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.i = paramParcelable.a;
    requestLayout();
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.a = this.i;
    return localSavedState;
  }
  
  public void setAllCaps(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void setDividerColor(int paramInt)
  {
    this.o = paramInt;
    invalidate();
  }
  
  public void setDividerColorResource(int paramInt)
  {
    this.o = getResources().getColor(paramInt);
    invalidate();
  }
  
  public void setDividerPadding(int paramInt)
  {
    this.u = paramInt;
    invalidate();
  }
  
  public void setIndicatorColor(int paramInt)
  {
    this.m = paramInt;
    invalidate();
  }
  
  public void setIndicatorColorResource(int paramInt)
  {
    this.m = getResources().getColor(paramInt);
    invalidate();
  }
  
  public void setIndicatorHeight(int paramInt)
  {
    this.s = paramInt;
    invalidate();
  }
  
  public void setOnPageChangeListener(ViewPager.f paramf)
  {
    this.a = paramf;
  }
  
  public void setScrollOffset(int paramInt)
  {
    this.r = paramInt;
    invalidate();
  }
  
  public void setShouldExpand(boolean paramBoolean)
  {
    this.p = paramBoolean;
    requestLayout();
  }
  
  public void setTabBackground(int paramInt)
  {
    this.C = paramInt;
  }
  
  public void setTabPaddingLeftRight(int paramInt)
  {
    this.v = paramInt;
    b();
  }
  
  public void setTextColor(int paramInt)
  {
    this.y = paramInt;
    b();
  }
  
  public void setTextColorResource(int paramInt)
  {
    this.y = getResources().getColor(paramInt);
    b();
  }
  
  public void setTextSize(int paramInt)
  {
    this.x = paramInt;
    b();
  }
  
  public void setUnderlineColor(int paramInt)
  {
    this.n = paramInt;
    invalidate();
  }
  
  public void setUnderlineColorResource(int paramInt)
  {
    this.n = getResources().getColor(paramInt);
    invalidate();
  }
  
  public void setUnderlineHeight(int paramInt)
  {
    this.t = paramInt;
    invalidate();
  }
  
  public void setViewPager(ViewPager paramViewPager)
  {
    this.g = paramViewPager;
    if (paramViewPager.getAdapter() == null) {
      throw new IllegalStateException("ViewPager does not have adapter instance.");
    }
    paramViewPager.setOnPageChangeListener(this.e);
    a();
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    int a;
    
    private SavedState(Parcel paramParcel)
    {
      super();
      this.a = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.a);
    }
  }
  
  public static abstract interface a
  {
    public abstract int a();
  }
  
  final class b
    implements ViewPager.f
  {
    private b() {}
    
    public final void a(int paramInt)
    {
      if (paramInt == 0) {
        PagerSlidingTabStrip.a(PagerSlidingTabStrip.this, PagerSlidingTabStrip.a(PagerSlidingTabStrip.this).getCurrentItem(), 0);
      }
      if (PagerSlidingTabStrip.this.a != null) {
        PagerSlidingTabStrip.this.a.a(paramInt);
      }
    }
    
    public final void a(int paramInt1, float paramFloat, int paramInt2)
    {
      PagerSlidingTabStrip.a(PagerSlidingTabStrip.this, paramInt1);
      PagerSlidingTabStrip.a(PagerSlidingTabStrip.this, paramFloat);
      PagerSlidingTabStrip.a(PagerSlidingTabStrip.this, paramInt1, (int)(PagerSlidingTabStrip.c(PagerSlidingTabStrip.this).getChildAt(paramInt1).getWidth() * paramFloat));
      PagerSlidingTabStrip.this.invalidate();
      if (PagerSlidingTabStrip.this.a != null) {
        PagerSlidingTabStrip.this.a.a(paramInt1, paramFloat, paramInt2);
      }
    }
    
    public final void b(int paramInt)
    {
      if (PagerSlidingTabStrip.this.a != null) {
        PagerSlidingTabStrip.this.a.b(paramInt);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract View f(int paramInt);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/PagerSlidingTabStrip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */