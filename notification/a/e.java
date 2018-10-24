package com.whatsapp.notification.a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import java.util.Arrays;
import java.util.List;

final class e
  extends f
{
  public final List<String> a()
  {
    return Arrays.asList(new String[] { "com.sec.android.app.launcher", "com.sec.android.app.twlauncher", "com.sec.android.app.easylauncher", "com.sec.android.emergencylauncher" });
  }
  
  public final void a(int paramInt)
  {
    if (Build.VERSION.SDK_INT < 22)
    {
      String str = u.a().getPackageName();
      try
      {
        Uri localUri = Uri.parse("content://com.sec.badge/apps");
        ContentResolver localContentResolver = u.a().getContentResolver();
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("package", str);
        localContentValues.put("class", "com.whatsapp.Main");
        localContentValues.put("badgecount", Integer.valueOf(paramInt));
        if (localContentResolver.update(localUri, localContentValues, "package=? AND class=?", new String[] { str, "com.whatsapp.Main" }) == 0) {
          localContentResolver.insert(localUri, localContentValues);
        }
        return;
      }
      catch (Exception localException)
      {
        Log.d("widgetprovider/updatebadge", localException);
        return;
      }
    }
    Intent localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
    localIntent.putExtra("badge_count", paramInt);
    localIntent.putExtra("badge_count_package_name", u.a().getPackageName());
    localIntent.putExtra("badge_count_class_name", "com.whatsapp.Main");
    u.a().sendBroadcast(localIntent);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/notification/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */