package com.whatsapp.preference;

import android.content.Context;
import android.preference.PreferenceCategory;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.whatsapp.pv;

public class WaPreferenceCategory
  extends PreferenceCategory
{
  private final pv a = pv.a();
  
  public WaPreferenceCategory(Context paramContext)
  {
    super(paramContext);
  }
  
  public WaPreferenceCategory(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WaPreferenceCategory(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    return WaPreference.a(this.a, super.onCreateView(paramViewGroup));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/preference/WaPreferenceCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */