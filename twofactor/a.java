package com.whatsapp.twofactor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public final class a
  extends Fragment
{
  private final q a = q.a();
  
  public static a a()
  {
    return new a();
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2130903229, paramViewGroup, false);
  }
  
  public final void a(View paramView, Bundle paramBundle)
  {
    boolean bool = this.a.e();
    paramBundle = (ImageView)paramView.findViewById(2131755220);
    if (bool) {}
    for (int i = 2130840148;; i = 2130840147)
    {
      paramBundle.setImageResource(i);
      paramView.findViewById(2131755777).setOnClickListener(b.a(this));
      paramBundle = (TwoFactorAuthActivity)l();
      paramBundle.a(paramView, paramBundle.n.length);
      return;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/twofactor/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */