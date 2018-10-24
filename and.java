package com.whatsapp;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import android.telephony.TelephonyManager;

public class and
{
  private static volatile and g;
  public final PowerManager a;
  public final ActivityManager b;
  public final TelephonyManager c;
  public final WifiManager d;
  public final ConnectivityManager e;
  public final ContentResolver f;
  
  @SuppressLint({"WifiManagerPotentialLeak"})
  private and(Context paramContext)
  {
    this.a = ((PowerManager)paramContext.getSystemService("power"));
    this.d = ((WifiManager)paramContext.getSystemService("wifi"));
    this.b = ((ActivityManager)paramContext.getSystemService("activity"));
    this.c = ((TelephonyManager)paramContext.getSystemService("phone"));
    this.e = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
    this.f = paramContext.getContentResolver();
  }
  
  public static and a()
  {
    if (g == null) {}
    try
    {
      if (g == null) {
        g = new and(u.a());
      }
      return g;
    }
    finally {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/and.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */