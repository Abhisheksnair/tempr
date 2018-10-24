package com.whatsapp.statusplayback.content;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

public class StatusCoordinatorLayout
  extends CoordinatorLayout
{
  public StatusCoordinatorLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public StatusCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public StatusCoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2)
  {
    return ((paramView != null) && (paramView.getId() == 2131755402)) || (super.a(paramView, paramInt1, paramInt2));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/content/StatusCoordinatorLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */