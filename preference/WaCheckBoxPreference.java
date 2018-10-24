package com.whatsapp.preference;

import android.content.Context;
import android.preference.CheckBoxPreference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.whatsapp.pv;

public class WaCheckBoxPreference
  extends CheckBoxPreference
{
  private final pv a = pv.a();
  private boolean b;
  private View c;
  private ProgressBar d;
  
  public WaCheckBoxPreference(Context paramContext)
  {
    super(paramContext);
  }
  
  public WaCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WaCheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    int j = 0;
    Object localObject;
    if (this.c != null)
    {
      localObject = this.c;
      if (this.b)
      {
        i = 8;
        ((View)localObject).setVisibility(i);
      }
    }
    else if (this.d != null)
    {
      localObject = this.d;
      if (!this.b) {
        break label61;
      }
    }
    label61:
    for (int i = j;; i = 8)
    {
      ((ProgressBar)localObject).setVisibility(i);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    a();
  }
  
  protected void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.c = paramView.findViewById(16908289);
    this.d = ((ProgressBar)paramView.findViewById(2131756027));
    a();
  }
  
  public View onCreateView(ViewGroup paramViewGroup)
  {
    return WaPreference.a(WaPreference.a(this.a, super.onCreateView(paramViewGroup)));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/preference/WaCheckBoxPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */