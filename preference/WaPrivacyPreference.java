package com.whatsapp.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;

public class WaPrivacyPreference
  extends WaListPreference
{
  private boolean a;
  private ProgressBar b;
  
  public WaPrivacyPreference(Context paramContext)
  {
    super(paramContext);
  }
  
  public WaPrivacyPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    ProgressBar localProgressBar;
    if (this.b != null)
    {
      localProgressBar = this.b;
      if (!this.a) {
        break label32;
      }
    }
    label32:
    for (int i = 0;; i = 8)
    {
      localProgressBar.setVisibility(i);
      return;
    }
  }
  
  protected void onBindView(View paramView)
  {
    super.onBindView(paramView);
    this.b = ((ProgressBar)paramView.findViewById(2131756027));
    paramView = this.b;
    if (this.a) {}
    for (int i = 0;; i = 8)
    {
      paramView.setVisibility(i);
      return;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/preference/WaPrivacyPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */