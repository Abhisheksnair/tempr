package com.whatsapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.whatsapp.util.Log;
import com.whatsapp.util.as;

public class aat
{
  private static volatile aat a;
  private final and b;
  
  private aat(and paramand)
  {
    this.b = paramand;
  }
  
  public static aat a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aat(and.a());
      }
      return a;
    }
    finally {}
  }
  
  public static boolean a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 17) {
      if (Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on", 0) == 0) {}
    }
    while (Settings.Global.getInt(paramContext.getContentResolver(), "airplane_mode_on", 0) != 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final int a(boolean paramBoolean)
  {
    Object localObject1 = this.b.c;
    Object localObject2 = this.b.e;
    if ((localObject2 == null) || (localObject1 == null)) {}
    do
    {
      do
      {
        return 0;
        localObject2 = ((ConnectivityManager)localObject2).getActiveNetworkInfo();
        if (paramBoolean) {
          Log.d("app/network-type network-info=" + localObject2);
        }
      } while (localObject2 == null);
      bool = ((NetworkInfo)localObject2).isConnected();
      if (paramBoolean) {
        Log.d("app/network-type network-connected=" + bool);
      }
    } while (!bool);
    if (((NetworkInfo)localObject2).getType() == 1) {
      return 1;
    }
    boolean bool = ((NetworkInfo)localObject2).isRoaming();
    if (paramBoolean) {
      Log.d("app/network-type network-roaming=" + bool);
    }
    if (bool) {
      return 3;
    }
    bool = ((TelephonyManager)localObject1).isNetworkRoaming();
    if (paramBoolean) {
      Log.d("app/network-type telephony-roaming=" + bool);
    }
    if (bool) {
      return 3;
    }
    String str1 = ((TelephonyManager)localObject1).getSimCountryIso();
    if (paramBoolean) {
      Log.d("app/network-type sim-iso=" + str1);
    }
    if (TextUtils.isEmpty(str1)) {
      return 3;
    }
    localObject2 = ((TelephonyManager)localObject1).getSimOperator();
    if (paramBoolean) {
      Log.d("app/network-type sim-operator=" + (String)localObject2);
    }
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      return 3;
    }
    if (((TelephonyManager)localObject1).getPhoneType() != 2)
    {
      String str2 = ((TelephonyManager)localObject1).getNetworkCountryIso();
      if (paramBoolean) {
        Log.d("app/network-type network-iso=" + str2);
      }
      if ((TextUtils.isEmpty(str2)) || (!str1.equals(str2))) {
        return 3;
      }
      localObject1 = ((TelephonyManager)localObject1).getNetworkOperator();
      if (paramBoolean) {
        Log.d("app/network-type network-operator=" + (String)localObject1);
      }
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return 3;
      }
      if ((!((String)localObject1).equals(localObject2)) && (!as.a((String)localObject1, (String)localObject2))) {
        return 3;
      }
    }
    return 2;
  }
  
  public final boolean b()
  {
    Object localObject = this.b.e;
    if (localObject == null) {}
    do
    {
      return false;
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    } while ((localObject == null) || (!((NetworkInfo)localObject).isConnected()));
    return true;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */