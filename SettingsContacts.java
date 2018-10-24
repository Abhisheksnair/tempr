package com.whatsapp;

import a.a.a.a.d;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import com.whatsapp.contact.sync.i;
import com.whatsapp.contact.sync.v;

public class SettingsContacts
  extends nn
{
  final ani n = ani.a();
  private CheckBoxPreference o;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addPreferencesFromResource(2131099657);
    findPreference("tell_a_friend").setOnPreferenceClickListener(akd.a(this));
    this.o = ((CheckBoxPreference)findPreference("show_all_contacts"));
    this.o.setOnPreferenceClickListener(ake.a(this));
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    ProgressDialog localProgressDialog = new ProgressDialog(this);
    localProgressDialog.setMessage(getString(2131297592));
    localProgressDialog.setIndeterminate(true);
    localProgressDialog.setCancelable(false);
    return localProgressDialog;
  }
  
  final class a
    extends AsyncTask<Void, Void, v>
  {
    private final i b = i.a();
    
    private a() {}
    
    private static void a(CheckBoxPreference paramCheckBoxPreference)
    {
      if (!paramCheckBoxPreference.isChecked()) {}
      for (boolean bool = true;; bool = false)
      {
        paramCheckBoxPreference.setChecked(bool);
        return;
      }
    }
    
    protected final void onPreExecute()
    {
      d.a(SettingsContacts.this, 16);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/SettingsContacts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */