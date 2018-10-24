package com.whatsapp;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.view.a;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;

public class BidiToolbar
  extends Toolbar
{
  private final pv t;
  
  public BidiToolbar(Context paramContext)
  {
    super(paramContext);
    if (isInEditMode()) {}
    for (paramContext = null;; paramContext = pv.a())
    {
      this.t = paramContext;
      h();
      return;
    }
  }
  
  public BidiToolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode()) {}
    for (paramContext = null;; paramContext = pv.a())
    {
      this.t = paramContext;
      h();
      return;
    }
  }
  
  public BidiToolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode()) {}
    for (paramContext = null;; paramContext = pv.a())
    {
      this.t = paramContext;
      h();
      return;
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    if (((paramView instanceof ViewGroup)) && (paramView.getId() != 2131755239))
    {
      paramView = (ViewGroup)paramView;
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = paramView.getChildAt(i);
        localView.layout(paramInt - localView.getRight(), localView.getTop(), paramInt - localView.getLeft(), localView.getBottom());
        a(localView, localView.getRight() - localView.getLeft());
        i += 1;
      }
    }
  }
  
  private void h()
  {
    if ((!isInEditMode()) && (this.t.a)) {
      setNavigationIcon(2130840095);
    }
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (((paramView instanceof ActionMenuView)) && (!a.a(getContext()).b()) && ((getResources().getConfiguration().screenLayout & 0xF) != 4))
    {
      final ActionMenuView localActionMenuView = (ActionMenuView)paramView;
      if ((localActionMenuView.getChildCount() > 0) && (localActionMenuView.getChildAt(0).getClass().getName().startsWith("android.support.v7.widget.ActionMenuPresenter"))) {
        localActionMenuView.removeViewAt(0);
      }
      localActionMenuView.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener()
      {
        public final void onChildViewAdded(View paramAnonymousView1, View paramAnonymousView2)
        {
          if (paramAnonymousView2.getClass().getName().startsWith("android.support.v7.widget.ActionMenuPresenter")) {
            localActionMenuView.removeView(paramAnonymousView2);
          }
        }
        
        public final void onChildViewRemoved(View paramAnonymousView1, View paramAnonymousView2) {}
      });
    }
    super.addView(paramView, paramLayoutParams);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((!isInEditMode()) && (this.t.a) && (!al.a)) {
      a(this, paramInt3 - paramInt1);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/BidiToolbar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */