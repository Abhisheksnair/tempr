package com.whatsapp.location;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ConfigurationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.whatsapp.and;
import com.whatsapp.gdrive.ch;
import com.whatsapp.u;
import com.whatsapp.util.Log;

public class cc
{
  private static volatile cc b;
  public boolean a;
  private final and c;
  private int d = -1;
  
  private cc(and paramand)
  {
    this.c = paramand;
  }
  
  public static cc a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new cc(and.a());
      }
      return b;
    }
    finally {}
  }
  
  public static boolean b()
  {
    try
    {
      Class.forName("com.google.android.maps.MapActivity");
      return true;
    }
    catch (Exception localException)
    {
      Log.d("Unable to resolve com.google.android.maps.MapActivity - Google Maps V1 is not present on the device.");
    }
    return false;
  }
  
  public final void a(Activity paramActivity, String paramString)
  {
    Object localObject = null;
    if (c()) {
      localObject = LocationPicker2.class;
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = new Intent(paramActivity, (Class)localObject);
        ((Intent)localObject).putExtra("jid", paramString);
        ((Intent)localObject).putExtra("live_location_mode", true);
        paramActivity.startActivityForResult((Intent)localObject, 100);
      }
      return;
      if (b()) {
        localObject = LocationPicker.class;
      }
    }
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    if (c()) {
      localObject = GroupChatLiveLocationsActivity2.class;
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = new Intent(paramContext, (Class)localObject);
        ((Intent)localObject).putExtra("jid", paramString1);
        ((Intent)localObject).putExtra("target", paramString2);
        paramContext.startActivity((Intent)localObject);
      }
      return;
      if (b()) {
        localObject = GroupChatLiveLocationsActivity.class;
      }
    }
  }
  
  public final boolean c()
  {
    if (!ch.c()) {}
    ActivityManager localActivityManager;
    do
    {
      return false;
      localActivityManager = this.c.b;
      if (localActivityManager == null)
      {
        Log.w("app/has-google-maps-v2 am=false");
        return false;
      }
    } while (localActivityManager.getDeviceConfigurationInfo().reqGlEsVersion < 131072);
    return true;
  }
  
  public final int d()
  {
    if (this.d < 0) {}
    try
    {
      this.d = u.a().getPackageManager().getPackageInfo("com.google.android.apps.maps", 128).versionCode;
      return this.d;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        this.d = 0;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/location/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */