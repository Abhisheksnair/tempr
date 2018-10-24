package com.whatsapp.preference;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.whatsapp.al;
import com.whatsapp.pv;

public class WaPreference
  extends Preference
{
  private int a;
  private final pv b = pv.a();
  
  public WaPreference(Context paramContext)
  {
    super(paramContext);
  }
  
  public WaPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if ((Build.VERSION.SDK_INT < 11) && (paramAttributeSet != null)) {
      this.a = paramAttributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "icon", 0);
    }
  }
  
  public WaPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if ((Build.VERSION.SDK_INT < 11) && (paramAttributeSet != null)) {
      this.a = paramAttributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "icon", 0);
    }
  }
  
  public static View a(View paramView)
  {
    View localView = paramView.findViewById(16908310);
    if ((localView instanceof TextView)) {
      ((TextView)localView).setTextColor(paramView.getContext().getResources().getColorStateList(2131624148));
    }
    return paramView;
  }
  
  public static View a(pv parampv, View paramView)
  {
    al.a(parampv, paramView);
    if (!parampv.d())
    {
      parampv = paramView.findViewById(16908310);
      if (parampv != null) {
        parampv.getLayoutParams().width = -1;
      }
      parampv = paramView.findViewById(16908304);
      if (parampv != null) {
        parampv.getLayoutParams().width = -1;
      }
    }
    return paramView;
  }
  
  protected void onBindView(View paramView)
  {
    super.onBindView(paramView);
    if (this.a != 0)
    {
      paramView = paramView.findViewById(16908310);
      if ((paramView != null) && ((paramView instanceof TextView)))
      {
        paramView = (TextView)paramView;
        if (!this.b.d()) {
          break label73;
        }
        paramView.setCompoundDrawablesWithIntrinsicBounds(this.a, 0, 0, 0);
      }
    }
    for (;;)
    {
      paramView.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelSize(2131362074));
      return;
      label73:
      paramView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.a, 0);
    }
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    return a(a(this.b, super.onCreateView(paramViewGroup)));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/preference/WaPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */