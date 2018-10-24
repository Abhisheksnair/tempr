package com.whatsapp.notification.a;

import android.content.Context;
import android.content.Intent;
import com.whatsapp.u;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

final class h
  extends f
{
  public final List<String> a()
  {
    return Arrays.asList(new String[] { "com.miui.miuilite", "com.miui.miuihome", "com.miui.miuihome2" });
  }
  
  public final void a(int paramInt)
  {
    Object localObject3;
    try
    {
      Object localObject1 = Class.forName("android.app.MiuiNotification").newInstance();
      localObject3 = localObject1.getClass().getDeclaredField("messageCount");
      ((Field)localObject3).setAccessible(true);
      ((Field)localObject3).set(localObject1, Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException)
    {
      localObject3 = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
      ((Intent)localObject3).putExtra("android.intent.extra.update_application_component_name", u.a().getPackageName() + "/com.whatsapp.Main");
      if (paramInt != 0) {}
    }
    for (Object localObject2 = "";; localObject2 = Integer.valueOf(paramInt))
    {
      ((Intent)localObject3).putExtra("android.intent.extra.update_application_message_text", String.valueOf(localObject2));
      u.a().sendBroadcast((Intent)localObject3);
      return;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/notification/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */