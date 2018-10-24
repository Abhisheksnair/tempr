package com.whatsapp.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import com.whatsapp.atv;
import com.whatsapp.auj;
import com.whatsapp.util.Log;

public class MessageNotificationDismissedReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getStringExtra("notification_hash");
    atv.a().c().putString("notification_hash", paramContext).apply();
    Log.i("notification/dismiss " + paramContext);
    auj.m();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/notification/MessageNotificationDismissedReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */