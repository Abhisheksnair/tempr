package com.whatsapp;

import a.a.a.a.d;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.Preference;
import android.support.v7.app.b;
import android.support.v7.app.b.a;
import android.view.View;
import android.widget.CheckBox;
import com.whatsapp.data.ad;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;

public class SettingsChatHistory
  extends nn
{
  final aoj n = aoj.a();
  final vv o = vv.a();
  final lt p = lt.a();
  private String q;
  private final od r = od.a();
  private final ad s = ad.a();
  private final e t = e.a();
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    this.q = paramIntent.getStringExtra("contact");
    d.a(this, 19);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    addPreferencesFromResource(2131099656);
    findPreference("email_chat_history").setOnPreferenceClickListener(ajp.a(this));
    findPreference("msgstore_delete_all_chats").setOnPreferenceClickListener(ajv.a(this));
    findPreference("msgstore_clear_all_chats").setOnPreferenceClickListener(ajw.a(this));
    paramBundle = findPreference("msgstore_archive_all_chats");
    int i = this.p.f();
    int j = this.p.i();
    if ((i > 0) || (j == 0)) {}
    for (i = 2131296325;; i = 2131298053)
    {
      paramBundle.setTitle(i);
      findPreference("msgstore_archive_all_chats").setOnPreferenceClickListener(ajx.a(this));
      return;
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject2;
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 3: 
      localObject1 = View.inflate(this, 2130903261, null);
      localObject2 = ajy.a(this, (CheckBox)((View)localObject1).findViewById(2131755194));
      localObject1 = new b.a(this).b(2131296432).a((View)localObject1).b(2131296398, ajz.a(this)).a(2131296430, (DialogInterface.OnClickListener)localObject2).a();
      ((b)localObject1).show();
      return (Dialog)localObject1;
    case 4: 
      localObject1 = aka.a(this);
      return new b.a(this).b(2131296635).a(2131297331, (DialogInterface.OnClickListener)localObject1).b(2131296398, null).a();
    case 5: 
      boolean bool;
      if (this.p.f() > 0)
      {
        bool = true;
        localObject1 = akb.a(this, bool);
        localObject2 = new b.a(this);
        if (!bool) {
          break label212;
        }
      }
      label212:
      for (paramInt = 2131296326;; paramInt = 2131298054)
      {
        return ((b.a)localObject2).b(paramInt).a(2131297331, (DialogInterface.OnClickListener)localObject1).b(2131296398, null).a();
        bool = false;
        break;
      }
    }
    if (this.q == null) {
      return super.onCreateDialog(paramInt);
    }
    Object localObject1 = this.t.d(this.q);
    return new b.a(this).b(2131296702).a(2131296337, akc.a(this, (cs)localObject1)).c(2131298211, ajq.a(this, (cs)localObject1)).a();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/SettingsChatHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */