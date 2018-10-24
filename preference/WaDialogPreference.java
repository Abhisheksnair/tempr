package com.whatsapp.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.whatsapp.pv;

public class WaDialogPreference
  extends DialogPreference
{
  public DialogInterface.OnClickListener a;
  private final pv b = pv.a();
  
  public WaDialogPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.onClick(paramDialogInterface, paramInt);
    }
    super.onClick(paramDialogInterface, paramInt);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    return WaPreference.a(WaPreference.a(this.b, super.onCreateView(paramViewGroup)));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/preference/WaDialogPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */