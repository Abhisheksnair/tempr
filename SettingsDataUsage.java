package com.whatsapp;

import android.app.Dialog;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.support.v7.app.b.a;
import com.whatsapp.preference.WaMultiSelectListPreference;
import java.util.ArrayList;

public class SettingsDataUsage
  extends nn
{
  private final atv n = atv.a();
  
  private static int a(CharSequence[] paramArrayOfCharSequence)
  {
    int i = 0;
    int k = paramArrayOfCharSequence.length;
    int j = 0;
    while (i < k)
    {
      j |= 1 << Integer.parseInt(paramArrayOfCharSequence[i].toString());
      i += 1;
    }
    return j;
  }
  
  private static CharSequence[] a(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (i != 0)
    {
      if ((i & 0x1) != 0) {
        localArrayList.add(Integer.toString(paramInt));
      }
      i >>= 1;
      paramInt += 1;
    }
    return (CharSequence[])localArrayList.toArray(new CharSequence[0]);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addPreferencesFromResource(2131099658);
    findPreference("network_usage").setOnPreferenceClickListener(akf.a(this));
    paramBundle = (CheckBoxPreference)findPreference("voip_low_data_usage");
    paramBundle.setOnPreferenceClickListener(akg.a(paramBundle));
    paramBundle = (WaMultiSelectListPreference)findPreference("autodownload_cellular");
    paramBundle.a = getString(2131297698);
    paramBundle.b = getString(2131297692);
    paramBundle.a(a(this.n.b(2)));
    paramBundle.setOnPreferenceChangeListener(akh.a(this));
    paramBundle = (WaMultiSelectListPreference)findPreference("autodownload_wifi");
    paramBundle.a = getString(2131297698);
    paramBundle.b = getString(2131297692);
    paramBundle.a(a(this.n.b(1)));
    paramBundle.setOnPreferenceChangeListener(aki.a(this));
    paramBundle = (WaMultiSelectListPreference)findPreference("autodownload_roaming");
    paramBundle.a = getString(2131297698);
    paramBundle.b = getString(2131297692);
    paramBundle.a(a(this.n.b(3)));
    paramBundle.setOnPreferenceChangeListener(akj.a(this));
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    return new b.a(this).b(getString(2131297700)).a(2131297331, akk.a()).a();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/SettingsDataUsage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */