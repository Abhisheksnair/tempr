package com.whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.support.v4.view.o;
import android.view.Menu;
import android.view.MenuItem;
import com.whatsapp.notification.m;
import com.whatsapp.preference.WaRingtonePreference;

public class SettingsJidNotificationActivity
  extends nn
{
  private final cc n = cc.a();
  private String o;
  
  private void b()
  {
    cc.a locala = this.n.a(this.o);
    addPreferencesFromResource(2131099660);
    Object localObject = (WaRingtonePreference)findPreference("jid_message_tone");
    ((WaRingtonePreference)localObject).a = locala.d();
    ((WaRingtonePreference)localObject).setSummary(m.a(this, locala.d()));
    ((WaRingtonePreference)localObject).setOnPreferenceChangeListener(akr.a(this, (WaRingtonePreference)localObject));
    localObject = (ListPreference)findPreference("jid_message_vibrate");
    ((ListPreference)localObject).setValue(locala.e());
    ((ListPreference)localObject).setSummary(((ListPreference)localObject).getEntry());
    ((ListPreference)localObject).setOnPreferenceChangeListener(aks.a(this));
    localObject = (ListPreference)findPreference("jid_message_popup");
    ((ListPreference)localObject).setValue(locala.g());
    ((ListPreference)localObject).setSummary(((ListPreference)localObject).getEntry());
    ((ListPreference)localObject).setOnPreferenceChangeListener(akt.a(this));
    localObject = (ListPreference)findPreference("jid_message_light");
    ((ListPreference)localObject).setValue(locala.f());
    ((ListPreference)localObject).setSummary(((ListPreference)localObject).getEntry());
    ((ListPreference)localObject).setOnPreferenceChangeListener(aku.a(this));
    if (qz.e(this.o))
    {
      localObject = (PreferenceCategory)findPreference("jid_call");
      if (localObject != null) {
        getPreferenceScreen().removePreference((Preference)localObject);
      }
    }
    for (;;)
    {
      localObject = (CheckBoxPreference)findPreference("jid_use_custom");
      ((CheckBoxPreference)localObject).setChecked(locala.e);
      ((CheckBoxPreference)localObject).setOnPreferenceChangeListener(akx.a(this));
      c();
      return;
      localObject = (WaRingtonePreference)findPreference("jid_call_ringtone");
      ((WaRingtonePreference)localObject).a = locala.h();
      ((WaRingtonePreference)localObject).setSummary(m.a(this, locala.h()));
      ((WaRingtonePreference)localObject).setOnPreferenceChangeListener(akv.a(this, (WaRingtonePreference)localObject));
      localObject = (ListPreference)findPreference("jid_call_vibrate");
      ((ListPreference)localObject).setValue(locala.i());
      ((ListPreference)localObject).setSummary(((ListPreference)localObject).getEntry());
      ((ListPreference)localObject).setOnPreferenceChangeListener(akw.a(this));
    }
  }
  
  private void c()
  {
    boolean bool = this.n.a(this.o).e;
    findPreference("jid_message_tone").setEnabled(bool);
    findPreference("jid_message_vibrate").setEnabled(bool);
    findPreference("jid_message_popup").setEnabled(bool);
    findPreference("jid_message_light").setEnabled(bool);
    if (!qz.e(this.o))
    {
      findPreference("jid_call_ringtone").setEnabled(bool);
      findPreference("jid_call_vibrate").setEnabled(bool);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.o = getIntent().getStringExtra("jid");
    b();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    o.a(paramMenu.add(0, 2131755069, 0, 2131297794), 0);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131755069)
    {
      paramMenuItem = this.n;
      cc.a locala1 = paramMenuItem.a(this.o);
      cc.a locala2 = locala1.j();
      locala1.f = locala2.d();
      locala1.g = locala2.e();
      locala1.h = locala2.g();
      locala1.i = locala2.f();
      locala1.j = locala2.h();
      locala1.k = locala2.i();
      locala1.e = false;
      paramMenuItem.a(locala1);
      getPreferenceScreen().removeAll();
      b();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/SettingsJidNotificationActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */