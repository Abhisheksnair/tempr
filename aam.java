package com.whatsapp;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.m;
import android.support.v4.app.n;
import android.view.View;
import android.widget.CheckBox;
import com.whatsapp.fieldstats.events.ak;
import com.whatsapp.fieldstats.l;
import java.util.ArrayList;

public final class aam
  extends m
{
  final atv aa = atv.a();
  final hx ab = hx.a();
  private final pv ac = pv.a();
  private final cc ad = cc.a();
  private final rh ae = rh.a();
  
  public static aam a(String paramString)
  {
    aam localaam = new aam();
    Bundle localBundle = new Bundle();
    localBundle.putString("jid", paramString);
    localaam.f(localBundle);
    return localaam;
  }
  
  public static aam a(ArrayList<String> paramArrayList)
  {
    aam localaam = new aam();
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("jids", paramArrayList);
    localaam.f(localBundle);
    return localaam;
  }
  
  final void a(String paramString, long paramLong, boolean paramBoolean)
  {
    if ((qz.e(paramString)) && (this.ae.b(paramString)))
    {
      ak localak = new ak();
      localak.b = Double.valueOf(paramLong);
      localak.a = Long.valueOf(this.ae.a(paramString).c());
      l.a(l(), localak);
    }
    this.ad.a(paramString, System.currentTimeMillis() + paramLong, paramBoolean, true);
  }
  
  public final Dialog c(Bundle paramBundle)
  {
    paramBundle = i().getString("jid");
    ArrayList localArrayList = i().getStringArrayList("jids");
    String[] arrayOfString = m().getStringArray(2131689490);
    int[] arrayOfInt1 = m().getIntArray(2131689491);
    int[] arrayOfInt2 = new int[1];
    arrayOfInt2[0] = this.aa.a.getInt("last_mute_selection", 0);
    if (arrayOfInt2[0] >= arrayOfString.length) {
      arrayOfInt2[0] = 0;
    }
    View localView = al.a(this.ac, l().getLayoutInflater(), 2130903308, null, false);
    CheckBox localCheckBox = (CheckBox)localView.findViewById(2131755971);
    if ((paramBundle != null) && (this.ad.b(paramBundle))) {
      localCheckBox.setChecked(this.ad.a(paramBundle).d);
    }
    for (;;)
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(l());
      localBuilder.setTitle(2131297225);
      localBuilder.setSingleChoiceItems(arrayOfString, arrayOfInt2[0], aan.a(arrayOfInt2)).setPositiveButton(2131297331, aao.a(this, arrayOfInt1, arrayOfInt2, localCheckBox, localArrayList, paramBundle));
      localBuilder.setNegativeButton(2131296398, aap.a(this, localArrayList));
      localBuilder.setView(localView);
      return localBuilder.create();
      localCheckBox.setChecked(this.aa.a.getBoolean("last_mute_show_notifications", true));
    }
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (i().getString("jids") == null) {
      this.ab.a(i().getString("jid"));
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */