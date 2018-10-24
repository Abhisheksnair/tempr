package com.whatsapp;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.preference.Preference;
import android.support.v7.app.b.a;

public class SettingsHelp
  extends nn
{
  private final aat n = aat.a();
  private final atv o = atv.a();
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addPreferencesFromResource(2131099659);
    findPreference("help").setOnPreferenceClickListener(akl.a(this));
    findPreference("contact_us").setOnPreferenceClickListener(akm.a(this));
    findPreference("terms_and_privacy_policy").setOnPreferenceClickListener(akn.a(this));
    findPreference("about").setOnPreferenceClickListener(ako.a(this));
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 122: 
      localObject = new ProgressDialog(this);
      ((ProgressDialog)localObject).setMessage(getString(2131297530));
      ((ProgressDialog)localObject).setIndeterminate(true);
      ((ProgressDialog)localObject).setCancelable(false);
      return (Dialog)localObject;
    case 123: 
      return new b.a(this).b(2131297786).a(2131297333, akp.a(this)).a();
    case 101: 
      localObject = new acy(this);
      ((acy)localObject).setTitle(getString(2131297593));
      ((acy)localObject).setMessage(getString(2131297592));
      ((acy)localObject).setIndeterminate(true);
      ((acy)localObject).setCancelable(false);
      return (Dialog)localObject;
    }
    return new b.a(this).a(2131297293).b(getString(2131297543, new Object[] { getString(2131296506) })).a(2131297331, akq.a(this)).a();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/SettingsHelp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */