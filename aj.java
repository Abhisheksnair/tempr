package com.whatsapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.whatsapp.util.Log;

final class aj
  extends BroadcastReceiver
{
  static Intent a()
  {
    return new Intent("com.whatsapp.alarm.AVAILABLE_TIMEOUT").setPackage(au.b());
  }
  
  static void a(Context paramContext)
  {
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, a(), 536870912);
    if (localPendingIntent != null) {
      ((AlarmManager)paramContext.getSystemService("alarm")).cancel(localPendingIntent);
    }
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = pc.a();
    paramIntent = abv.a();
    pd localpd = pd.a();
    if (!paramContext.d())
    {
      localpd.c();
      paramIntent.d();
    }
    for (;;)
    {
      Log.i("app/presenceavailable/timeout/foreground " + paramContext.b);
      return;
      Log.d("app/presenceavailable/timeout/still-foreground");
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */