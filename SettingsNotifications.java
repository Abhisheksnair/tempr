package com.whatsapp;

import a.a.a.a.d;
import android.app.Dialog;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.support.v4.view.o;
import android.support.v7.app.b.a;
import android.view.Menu;
import android.view.MenuItem;
import com.whatsapp.notification.m;
import com.whatsapp.preference.WaRingtonePreference;

public class SettingsNotifications
  extends nn
{
  final cc n = cc.a();
  private Preference.OnPreferenceChangeListener o = ala.a(this);
  private Preference.OnPreferenceChangeListener p = alb.a(this);
  private Preference.OnPreferenceChangeListener q = alc.a(this);
  private Preference.OnPreferenceChangeListener r = ald.a(this);
  
  final void b()
  {
    addPreferencesFromResource(2131099662);
    Object localObject1 = this.n.e();
    cc.a locala = this.n.d();
    Object localObject2 = (WaRingtonePreference)findPreference("notify_ringtone");
    ((WaRingtonePreference)localObject2).a = ((cc.a)localObject1).d();
    ((WaRingtonePreference)localObject2).setSummary(m.a(this, ((cc.a)localObject1).d()));
    ((WaRingtonePreference)localObject2).setOnPreferenceChangeListener(this.r);
    localObject2 = (WaRingtonePreference)findPreference("group_notify_tone");
    ((WaRingtonePreference)localObject2).a = locala.d();
    ((WaRingtonePreference)localObject2).setSummary(m.a(this, locala.d()));
    ((WaRingtonePreference)localObject2).setOnPreferenceChangeListener(this.r);
    localObject2 = (WaRingtonePreference)findPreference("call_ringtone");
    ((WaRingtonePreference)localObject2).a = ((cc.a)localObject1).h();
    ((WaRingtonePreference)localObject2).setSummary(m.a(this, ((cc.a)localObject1).h()));
    ((WaRingtonePreference)localObject2).setOnPreferenceChangeListener(this.r);
    localObject2 = (ListPreference)findPreference("notify_light_color");
    ((ListPreference)localObject2).setValue(((cc.a)localObject1).f());
    ((ListPreference)localObject2).setSummary(((ListPreference)localObject2).getEntry());
    ((ListPreference)localObject2).setOnPreferenceChangeListener(this.o);
    localObject2 = (ListPreference)findPreference("group_notify_light_color");
    ((ListPreference)localObject2).setValue(locala.f());
    ((ListPreference)localObject2).setSummary(((ListPreference)localObject2).getEntry());
    ((ListPreference)localObject2).setOnPreferenceChangeListener(this.o);
    localObject2 = (ListPreference)findPreference("notify_vibrate_length");
    ((ListPreference)localObject2).setValue(((cc.a)localObject1).e());
    ((ListPreference)localObject2).setSummary(((ListPreference)localObject2).getEntry());
    ((ListPreference)localObject2).setOnPreferenceChangeListener(this.p);
    localObject2 = (ListPreference)findPreference("group_notify_vibrate_length");
    ((ListPreference)localObject2).setValue(locala.e());
    ((ListPreference)localObject2).setSummary(((ListPreference)localObject2).getEntry());
    ((ListPreference)localObject2).setOnPreferenceChangeListener(this.p);
    localObject2 = (ListPreference)findPreference("call_vibrate_length");
    ((ListPreference)localObject2).setValue(((cc.a)localObject1).i());
    ((ListPreference)localObject2).setSummary(((ListPreference)localObject2).getEntry());
    ((ListPreference)localObject2).setOnPreferenceChangeListener(this.p);
    localObject2 = (ListPreference)findPreference("notify_popup_mode");
    ((ListPreference)localObject2).setValue(((cc.a)localObject1).g());
    ((ListPreference)localObject2).setSummary(((ListPreference)localObject2).getEntry());
    ((ListPreference)localObject2).setOnPreferenceChangeListener(this.q);
    localObject1 = (ListPreference)findPreference("group_notify_popup_mode");
    ((ListPreference)localObject1).setValue(locala.g());
    ((ListPreference)localObject1).setSummary(((ListPreference)localObject1).getEntry());
    ((ListPreference)localObject1).setOnPreferenceChangeListener(this.q);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    b();
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 7: 
      return new b.a(this).b(getString(2131297083)).a(2131297331, null).a();
    }
    return new b.a(this).b(2131297795).a(2131297617, ale.a(this)).b(2131296398, null).a();
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
      d.a(this, 8);
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/SettingsNotifications.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */