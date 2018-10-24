package com.whatsapp;

import a.a.a.a.a.a.d;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.a;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;

public class SettingsSecurity
  extends nh
{
  private final aus n = aus.a();
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("settingssecurity/create");
    super.onCreate(paramBundle);
    ((a)a.d.a(i())).a(true);
    setContentView(2130903362);
    paramBundle = (SwitchCompat)findViewById(2131756076);
    paramBundle.setChecked(this.aQ.a.getBoolean("security_notifications", false));
    paramBundle.setOnCheckedChangeListener(aln.a(this));
    findViewById(2131756074).setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        paramAnonymousView = new Intent("android.intent.action.VIEW", Uri.parse("https://www.whatsapp.com/security?lg=" + SettingsSecurity.a(SettingsSecurity.this).d() + "&lc=" + SettingsSecurity.a(SettingsSecurity.this).c()));
        pv.a(SettingsSecurity.this, paramAnonymousView);
      }
    });
    findViewById(2131756075).setOnClickListener(alo.a(paramBundle));
  }
  
  public void onDestroy()
  {
    Log.i("settingssecurity/destroy");
    super.onDestroy();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/SettingsSecurity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */