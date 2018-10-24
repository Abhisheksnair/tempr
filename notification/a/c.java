package com.whatsapp.notification.a;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import java.util.Collections;
import java.util.List;

final class c
  extends f
{
  private static int b()
  {
    try
    {
      int i = u.a().getPackageManager().getPackageInfo("com.huawei.android.launcher", 0).versionCode;
      return i;
    }
    catch (Exception localException)
    {
      Log.w(localException);
    }
    return -1;
  }
  
  public final List<String> a()
  {
    return Collections.singletonList("com.huawei.android.launcher");
  }
  
  @SuppressLint({"NewApi"})
  public final void a(int paramInt)
  {
    if ((Build.VERSION.SDK_INT < 11) || (b() <= 63006)) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("package", u.a().getPackageName());
    localBundle.putString("class", "com.whatsapp.Main");
    localBundle.putInt("badgenumber", paramInt);
    try
    {
      u.a().getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", null, localBundle);
      return;
    }
    catch (Exception localException)
    {
      Log.d("Unexpected exception, launcher version = " + b(), localException);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/notification/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */