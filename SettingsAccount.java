package com.whatsapp;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.support.v7.app.b.a;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b.a.a.c;
import com.whatsapp.messaging.m;
import com.whatsapp.messaging.w;
import com.whatsapp.preference.WaCheckBoxPreference;
import com.whatsapp.util.Log;

public class SettingsAccount
  extends nn
{
  private final w n = w.a();
  
  private void b()
  {
    WaCheckBoxPreference localWaCheckBoxPreference = (WaCheckBoxPreference)findPreference("privacy_opt_out");
    Preference localPreference = findPreference("privacy_opt_out_description");
    if (this.c.g())
    {
      localObject = localWaCheckBoxPreference;
      if (localWaCheckBoxPreference == null)
      {
        localObject = new WaCheckBoxPreference(this)
        {
          protected final View onCreateView(ViewGroup paramAnonymousViewGroup)
          {
            paramAnonymousViewGroup = super.onCreateView(paramAnonymousViewGroup);
            if (paramAnonymousViewGroup != null)
            {
              TextView localTextView = (TextView)paramAnonymousViewGroup.findViewById(16908304);
              if (localTextView != null)
              {
                localTextView.setLinksClickable(true);
                localTextView.setMovementMethod(LinkMovementMethod.getInstance());
              }
            }
            return paramAnonymousViewGroup;
          }
        };
        ((WaCheckBoxPreference)localObject).setKey("privacy_opt_out");
        ((WaCheckBoxPreference)localObject).setTitle(2131297998);
        ((WaCheckBoxPreference)localObject).setPersistent(false);
        getPreferenceScreen().addPreference((Preference)localObject);
      }
      ((WaCheckBoxPreference)localObject).setChecked(true);
      ((WaCheckBoxPreference)localObject).setOnPreferenceClickListener(aje.a(this));
      if (localPreference != null) {
        break label155;
      }
    }
    label155:
    for (Object localObject = new Preference(this)
        {
          protected final View onCreateView(ViewGroup paramAnonymousViewGroup)
          {
            paramAnonymousViewGroup = super.onCreateView(paramAnonymousViewGroup);
            TextView localTextView = (TextView)paramAnonymousViewGroup.findViewById(2131755322);
            localTextView.setLinksClickable(true);
            localTextView.setMovementMethod(LinkMovementMethod.getInstance());
            String str = aic.j().appendPath("general").appendPath("28030011").appendQueryParameter("lg", SettingsAccount.this.g.d()).appendQueryParameter("lc", SettingsAccount.this.g.c()).toString();
            localTextView.setText(Html.fromHtml(SettingsAccount.this.getString(2131297997, new Object[] { str })));
            return paramAnonymousViewGroup;
          }
        };; localObject = localPreference)
    {
      ((Preference)localObject).setKey("privacy_opt_out_description");
      ((Preference)localObject).setLayoutResource(2130903359);
      ((Preference)localObject).setPersistent(false);
      ((Preference)localObject).setSelectable(false);
      getPreferenceScreen().addPreference((Preference)localObject);
      do
      {
        return;
        if (localWaCheckBoxPreference != null) {
          getPreferenceScreen().removePreference(localWaCheckBoxPreference);
        }
      } while (localPreference == null);
      getPreferenceScreen().removePreference(localPreference);
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    pb.a(5);
    addPreferencesFromResource(2131099654);
    findPreference("change_number").setOnPreferenceClickListener(aiw.a(this));
    findPreference("delete_account").setOnPreferenceClickListener(aix.a(this));
    findPreference("privacy").setOnPreferenceClickListener(aiy.a(this));
    findPreference("two_factor_auth").setOnPreferenceClickListener(aiz.a(this));
    paramBundle = findPreference("security");
    if (paramBundle != null) {
      paramBundle.setOnPreferenceClickListener(aja.a(this));
    }
    b();
    paramBundle = this.n;
    if (paramBundle.b.d)
    {
      Log.i("sendmethods/sendgettosstate");
      paramBundle.b.a(Message.obtain(null, 0, 101, 0));
    }
    c.a().a(this, false);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    return new b.a(this).b(2131297337).a(2131297336, ajb.a(this)).b(2131296398, ajc.a(this)).a(ajd.a(this)).a();
  }
  
  public void onDestroy()
  {
    Log.i("settingsprivacy/destroy");
    super.onDestroy();
    c.a().a(this);
  }
  
  public void onEvent(anv.a parama)
  {
    b();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/SettingsAccount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */