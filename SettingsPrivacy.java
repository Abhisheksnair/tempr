package com.whatsapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceCategory;
import b.a.a.c;
import com.whatsapp.data.ad;
import com.whatsapp.data.co;
import com.whatsapp.g.e;
import com.whatsapp.j.a.a;
import com.whatsapp.location.bp;
import com.whatsapp.location.bp.c;
import com.whatsapp.messaging.w;
import com.whatsapp.preference.WaCheckBoxPreference;
import com.whatsapp.preference.WaPrivacyPreference;
import com.whatsapp.util.Log;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SettingsPrivacy
  extends nn
{
  static int n = 0;
  static HashMap<String, a> o = new HashMap();
  private static SettingsPrivacy s;
  private final dh.a A = new dh.a()
  {
    public final void a(Collection<String> paramAnonymousCollection)
    {
      SettingsPrivacy.a(SettingsPrivacy.this);
    }
  };
  private final Handler B = new Handler(Looper.getMainLooper());
  private final Runnable C = alf.a(this);
  private final bp.c D = new bp.c()
  {
    public final void a(String paramAnonymousString)
    {
      SettingsPrivacy.b(SettingsPrivacy.this);
    }
    
    public final void b(String paramAnonymousString)
    {
      SettingsPrivacy.b(SettingsPrivacy.this);
    }
  };
  private Preference.OnPreferenceChangeListener E = alg.a(this);
  final ad p = ad.a();
  final att q = att.a();
  Preference.OnPreferenceChangeListener r = alh.a(this);
  private final pv t = pv.a();
  private final w u = w.a();
  private final aq v = aq.a();
  private final dh w = dh.a();
  private final co x = co.a();
  private final aat y = aat.a();
  private final bp z = bp.a();
  
  private static int a(String paramString)
  {
    if ("all".equals(paramString)) {
      return 0;
    }
    if ("contacts".equals(paramString)) {
      return 1;
    }
    if ("none".equals(paramString)) {
      return 2;
    }
    return -1;
  }
  
  protected static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "all";
    case 0: 
      return "all";
    case 1: 
      return "contacts";
    }
    return "none";
  }
  
  private static String a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return "all";
    }
    return "none";
  }
  
  private void a(SharedPreferences paramSharedPreferences, String[] paramArrayOfString, String paramString1, String paramString2)
  {
    boolean bool2 = true;
    WaPrivacyPreference localWaPrivacyPreference = (WaPrivacyPreference)findPreference(paramString1);
    paramString2 = (a)o.get(paramString2);
    boolean bool1;
    if (paramString2 == null)
    {
      bool1 = true;
      localWaPrivacyPreference.setEnabled(bool1);
      if (paramString2 == null) {
        break label103;
      }
      bool1 = bool2;
      label50:
      localWaPrivacyPreference.a(bool1);
      if (paramString2 != null) {
        break label109;
      }
    }
    label103:
    label109:
    for (int i = paramSharedPreferences.getInt(paramString1, 0);; i = a(paramString2.b))
    {
      i = Math.max(0, i);
      localWaPrivacyPreference.setValueIndex(i);
      localWaPrivacyPreference.setSummary(paramArrayOfString[i]);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label50;
    }
  }
  
  public static void a(w paramw, abu paramabu, Map<String, String> paramMap)
  {
    SharedPreferences localSharedPreferences = u.a().getSharedPreferences("com.whatsapp_preferences", 0);
    SharedPreferences.Editor localEditor = localSharedPreferences.edit();
    paramMap = paramMap.entrySet().iterator();
    int i = 0;
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      Log.i("settingsprivacy/received " + str + ":" + (String)localObject);
      int j = a((String)localObject);
      if (j < 0)
      {
        i = 1;
      }
      else
      {
        a locala = (a)o.get(str);
        if ((locala == null) || (locala.b.equals(localObject)))
        {
          o.remove(str);
          if ("last".equals(str))
          {
            int k = localSharedPreferences.getInt("privacy_last_seen", 0);
            localEditor.putInt("privacy_last_seen", j);
            if (k != j) {
              paramabu.b();
            }
          }
          else if ("profile".equals(str))
          {
            localEditor.putInt("privacy_profile_photo", j);
          }
          else if ("status".equals(str))
          {
            localEditor.putInt("privacy_status", j);
          }
          else if ("readreceipts".equals(str))
          {
            if (locala != null) {}
            for (j = 1;; j = 0)
            {
              boolean bool3 = localSharedPreferences.getBoolean("read_receipts_enabled", true);
              boolean bool2 = "all".contentEquals((CharSequence)localObject);
              boolean bool1 = bool2;
              if (j == 0)
              {
                bool1 = bool2;
                if (!bool3)
                {
                  bool1 = bool2;
                  if (bool2)
                  {
                    paramw.a(str, a(false));
                    bool1 = false;
                  }
                }
              }
              localEditor.putBoolean("read_receipts_enabled", bool1);
              break;
            }
          }
        }
      }
    }
    localEditor.apply();
    if (i != 0) {
      pv.a(u.a().getApplicationContext(), 2131296789, 1);
    }
    if (s != null) {
      s.c();
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    o.put(paramString1, new a(paramString1, paramString2));
    this.k.a(true);
    this.u.a(paramString1, paramString2);
    this.B.removeCallbacks(this.C);
    this.B.postDelayed(this.C, 20000L);
    return true;
  }
  
  private static String b(String paramString)
  {
    if ("privacy_last_seen".equals(paramString)) {
      return "last";
    }
    if ("privacy_profile_photo".equals(paramString)) {
      return "profile";
    }
    if ("privacy_status".equals(paramString)) {
      return "status";
    }
    if ("read_receipts_enabled".equals(paramString)) {
      return "readreceipts";
    }
    throw new IllegalArgumentException("Unrecognized preference: " + paramString);
  }
  
  private void b()
  {
    Preference localPreference = findPreference("block_list");
    String str;
    if (this.v.d())
    {
      int i = this.v.f();
      if (i > 0) {
        str = getString(2131297706, new Object[] { NumberFormat.getInstance().format(i) });
      }
    }
    for (;;)
    {
      localPreference.setTitle(str);
      return;
      str = getString(2131297706, new Object[] { getString(2131298264) });
      continue;
      str = getString(2131296353);
    }
  }
  
  private void c()
  {
    boolean bool2 = false;
    SharedPreferences localSharedPreferences = getSharedPreferences("com.whatsapp_preferences", 0);
    Object localObject1 = getResources().getStringArray(2131689495);
    h();
    a(localSharedPreferences, (String[])localObject1, "privacy_last_seen", "last");
    a(localSharedPreferences, (String[])localObject1, "privacy_profile_photo", "profile");
    a(localSharedPreferences, (String[])localObject1, "privacy_status", "status");
    localObject1 = (WaCheckBoxPreference)findPreference("read_receipts_enabled");
    Object localObject2 = (a)o.get("readreceipts");
    if (localObject2 == null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ((WaCheckBoxPreference)localObject1).setEnabled(bool1);
      bool1 = bool2;
      if (localObject2 != null) {
        bool1 = true;
      }
      ((WaCheckBoxPreference)localObject1).a(bool1);
      localObject2 = ((WaCheckBoxPreference)localObject1).getOnPreferenceChangeListener();
      ((WaCheckBoxPreference)localObject1).setOnPreferenceChangeListener(null);
      ((WaCheckBoxPreference)localObject1).setChecked(localSharedPreferences.getBoolean("read_receipts_enabled", true));
      ((WaCheckBoxPreference)localObject1).setOnPreferenceChangeListener((Preference.OnPreferenceChangeListener)localObject2);
      return;
    }
  }
  
  private void h()
  {
    Object localObject;
    switch (this.x.f())
    {
    default: 
      throw new IllegalStateException("unknown status distribution mode");
    case 0: 
      localObject = getString(2131297483);
    }
    for (;;)
    {
      findPreference("privacy_status_v3").setSummary((CharSequence)localObject);
      return;
      localObject = this.x.h();
      if (localObject.length == 0)
      {
        localObject = getString(2131297483);
      }
      else
      {
        localObject = u.a.a(2131230807, localObject.length, new Object[] { Integer.valueOf(localObject.length) });
        continue;
        localObject = this.x.g();
        if (localObject.length == 0) {
          localObject = getString(2131297285);
        } else {
          localObject = u.a.a(2131230808, localObject.length, new Object[] { Integer.valueOf(localObject.length) });
        }
      }
    }
  }
  
  private void i()
  {
    Object localObject = this.z.l();
    if (((List)localObject).size() > 0) {}
    for (localObject = u.a.a(2131230757, ((List)localObject).size(), new Object[] { Integer.valueOf(((List)localObject).size()) });; localObject = getString(2131297311))
    {
      Preference localPreference = findPreference("privacy_live_location");
      if (localPreference != null) {
        localPreference.setSummary((CharSequence)localObject);
      }
      return;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == n) {
      h();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("settingsprivacy/create");
    s = this;
    addPreferencesFromResource(2131099663);
    ((WaPrivacyPreference)findPreference("privacy_last_seen")).setOnPreferenceChangeListener(this.E);
    ((WaPrivacyPreference)findPreference("privacy_profile_photo")).setOnPreferenceChangeListener(this.E);
    paramBundle = findPreference("privacy_status");
    findPreference("privacy_status_v3").setOnPreferenceClickListener(ali.a(this));
    paramBundle.setOnPreferenceChangeListener(this.E);
    paramBundle = findPreference("privacy_live_location");
    paramBundle.setOnPreferenceClickListener(alj.a(this));
    if (!aic.u) {
      ((PreferenceCategory)findPreference("personal_info_visibility")).removePreference(paramBundle);
    }
    ((WaCheckBoxPreference)findPreference("read_receipts_enabled")).setOnPreferenceChangeListener(alk.a(this));
    findPreference("block_list").setOnPreferenceClickListener(all.a(this));
    c();
    b();
    this.u.d();
    c.a().a(this, false);
    this.w.registerObserver(this.A);
    this.z.a(this.D);
  }
  
  public void onDestroy()
  {
    Log.i("settingsprivacy/destroy");
    super.onDestroy();
    this.z.b(this.D);
    this.w.unregisterObserver(this.A);
    c.a().a(this);
    s = null;
  }
  
  public void onEvent(e parame)
  {
    b();
  }
  
  protected void onResume()
  {
    super.onResume();
    i();
  }
  
  public static final class a
  {
    String a;
    String b;
    long c;
    
    a(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = System.currentTimeMillis();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/SettingsPrivacy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */