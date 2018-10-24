package com.whatsapp;

import android.animation.LayoutTransition;
import android.animation.LayoutTransition.TransitionListener;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class HomePagerSlidingTabStrip
  extends PagerSlidingTabStrip
{
  public HomePagerSlidingTabStrip(Context paramContext)
  {
    super(paramContext);
  }
  
  public HomePagerSlidingTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HomePagerSlidingTabStrip(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final LinearLayout a(Context paramContext)
  {
    return new a(paramContext);
  }
  
  public final void a(int paramInt, View paramView)
  {
    super.a(paramInt, paramView);
    if ((Build.VERSION.SDK_INT >= 11) && ((paramView instanceof ViewGroup)))
    {
      paramView = ((ViewGroup)paramView).getChildAt(0);
      if ((paramView instanceof ViewGroup))
      {
        paramView = ((ViewGroup)paramView).getLayoutTransition();
        if (paramView != null) {
          paramView.addTransitionListener(new LayoutTransition.TransitionListener()
          {
            public final void endTransition(LayoutTransition paramAnonymousLayoutTransition, ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt)
            {
              HomePagerSlidingTabStrip.this.invalidate();
            }
            
            public final void startTransition(LayoutTransition paramAnonymousLayoutTransition, ViewGroup paramAnonymousViewGroup, View paramAnonymousView, int paramAnonymousInt) {}
          });
        }
      }
    }
  }
  
  public static final class a
    extends LinearLayout
  {
    private int[] a = new int[4];
    
    public a(Context paramContext)
    {
      super();
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      int n = 1;
      int j = 0;
      int i = View.MeasureSpec.getSize(paramInt1);
      int i1 = getChildCount();
      if (this.a.length < i1) {
        this.a = new int[i1];
      }
      int k;
      if ((i1 > 1) && (i > 0))
      {
        View localView = getChildAt(0);
        localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), paramInt2);
        i = localView.getMeasuredWidth();
        int m = View.MeasureSpec.getSize(paramInt1) - i;
        k = 1;
        i = 0;
        j = 0;
        while (k < i1)
        {
          localView = getChildAt(k);
          localView.measure(View.MeasureSpec.makeMeasureSpec(m, 0), paramInt2);
          this.a[k] = localView.getMeasuredWidth();
          int i2 = this.a[k];
          if (localView.getMeasuredWidth() > m / (i1 - 1)) {
            j = 1;
          }
          k += 1;
          i = i2 + i;
        }
        k = j;
        j = i;
        i = m;
      }
      for (;;)
      {
        if (k != 0)
        {
          k = n;
          while (k < i1)
          {
            getChildAt(k).measure(View.MeasureSpec.makeMeasureSpec(this.a[k] * i / j, 1073741824), paramInt2);
            k += 1;
          }
          setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
          return;
        }
        super.onMeasure(paramInt1, paramInt2);
        return;
        i = 0;
        k = 0;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/HomePagerSlidingTabStrip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */