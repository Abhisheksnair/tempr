package com.whatsapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Process;
import com.whatsapp.registration.bb;
import com.whatsapp.util.Log;

public class BootReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = false;
    Object localObject = and.a();
    paramContext = atv.a();
    paramIntent = bb.a();
    Log.i("boot complete");
    paramContext.a(0);
    localObject = ((and)localObject).e;
    if (localObject == null) {
      Log.w("bootreceiver cm=null");
    }
    for (boolean bool1 = false;; bool1 = ((ConnectivityManager)localObject).getBackgroundDataSetting())
    {
      if (!bool1) {
        bool2 = true;
      }
      paramContext.c(bool2);
      if (!paramIntent.b())
      {
        Log.d("Killing the app since user is not registered (or has deleted the account).");
        Process.killProcess(Process.myPid());
      }
      return;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/BootReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */