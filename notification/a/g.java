package com.whatsapp.notification.a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import java.util.Collections;
import java.util.List;

final class g
  extends f
{
  public final List<String> a()
  {
    return Collections.singletonList("com.sonyericsson.home");
  }
  
  public final void a(int paramInt)
  {
    boolean bool = false;
    if (u.a().getPackageManager().resolveContentProvider("com.sonymobile.home.resourceprovider", 0) == null)
    {
      localObject = new Intent("com.sonyericsson.home.action.UPDATE_BADGE");
      ((Intent)localObject).putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", u.a().getPackageName());
      ((Intent)localObject).putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", "com.whatsapp.Main");
      if (paramInt > 0) {
        bool = true;
      }
      ((Intent)localObject).putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", bool);
      ((Intent)localObject).putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(paramInt));
      u.a().sendBroadcast((Intent)localObject);
      return;
    }
    Object localObject = new ContentValues();
    ((ContentValues)localObject).put("badge_count", Integer.valueOf(paramInt));
    ((ContentValues)localObject).put("package_name", u.a().getPackageName());
    ((ContentValues)localObject).put("activity_name", "com.whatsapp.Main");
    ContentResolver localContentResolver = u.a().getContentResolver();
    try
    {
      localContentResolver.insert(Uri.parse("content://com.sonymobile.home.resourceprovider/badge"), (ContentValues)localObject);
      return;
    }
    catch (Exception localException)
    {
      Log.d("badger/sony/updatebadge", localException);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/notification/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */