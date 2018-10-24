package com.whatsapp;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.content.f;
import com.whatsapp.util.Log;

public class AlarmBroadcastReceiver
  extends f
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = new Intent(paramIntent).setClass(paramContext, AlarmService.class);
    Log.i("AlarmBroadcastReceiver dispatching to AlarmService; intent=" + paramIntent + "; elapsedRealtime=" + SystemClock.elapsedRealtime());
    a_(paramContext, localIntent);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/AlarmBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */