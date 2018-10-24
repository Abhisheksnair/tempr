package com.whatsapp.notification.a;

import android.content.Context;
import android.content.Intent;
import com.whatsapp.u;
import java.util.Arrays;
import java.util.List;

final class a
  extends f
{
  public final List<String> a()
  {
    return Arrays.asList(new String[] { "com.asus.launcher", "com.lge.launcher", "com.lge.launcher2", "com.lge.launcher3" });
  }
  
  public final void a(int paramInt)
  {
    Intent localIntent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
    localIntent.putExtra("badge_count", paramInt);
    localIntent.putExtra("badge_count_package_name", u.a().getPackageName());
    localIntent.putExtra("badge_count_class_name", "com.whatsapp.Main");
    u.a().sendBroadcast(localIntent);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/notification/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */