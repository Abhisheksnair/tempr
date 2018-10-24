package com.whatsapp.notification.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import java.util.Collections;
import java.util.List;

public final class d
  extends f
{
  public final List<String> a()
  {
    return Collections.singletonList("com.oppo.launcher");
  }
  
  public final void a(int paramInt)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("app_badge_count", paramInt);
    localBundle.putString("app_badge_packageName", "com.whatsapp");
    try
    {
      u.a().getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", null, localBundle);
      return;
    }
    catch (Exception localException)
    {
      Log.d("cannot update badge", localException);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/notification/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */