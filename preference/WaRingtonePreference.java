package com.whatsapp.preference;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.preference.RingtonePreference;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.whatsapp.pv;

public class WaRingtonePreference
  extends RingtonePreference
{
  public String a;
  private final pv b = pv.a();
  
  public WaRingtonePreference(Context paramContext)
  {
    super(paramContext);
  }
  
  public WaRingtonePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WaRingtonePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected View onCreateView(ViewGroup paramViewGroup)
  {
    return WaPreference.a(WaPreference.a(this.b, super.onCreateView(paramViewGroup)));
  }
  
  protected void onPrepareRingtonePickerIntent(Intent paramIntent)
  {
    super.onPrepareRingtonePickerIntent(paramIntent);
    if ((getShowDefault()) && ((getRingtoneType() & 0x1) != 0) && ((getRingtoneType() & 0x2) != 0)) {
      paramIntent.putExtra("android.intent.extra.ringtone.DEFAULT_URI", Settings.System.DEFAULT_NOTIFICATION_URI);
    }
    if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
      paramIntent.putExtra("android.intent.extra.ringtone.TYPE", 2);
    }
  }
  
  protected Uri onRestoreRingtone()
  {
    if (TextUtils.isEmpty(this.a)) {
      return super.onRestoreRingtone();
    }
    return Uri.parse(this.a);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/preference/WaRingtonePreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */