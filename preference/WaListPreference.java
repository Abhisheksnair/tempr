package com.whatsapp.preference;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.whatsapp.pv;

public class WaListPreference
  extends ListPreference
{
  private final pv a = pv.a();
  
  public WaListPreference(Context paramContext)
  {
    super(paramContext);
  }
  
  public WaListPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    setNegativeButtonText(2131296398);
    return WaPreference.a(WaPreference.a(this.a, super.onCreateView(paramViewGroup)));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/preference/WaListPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */