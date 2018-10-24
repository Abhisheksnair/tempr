package com.whatsapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.whatsapp.gcm.RegistrationIntentService;
import com.whatsapp.util.Log;

public class UpdatedAnyAppReceiver
  extends BroadcastReceiver
{
  public static void a(va paramva, atv paramatv)
  {
    Log.i("received broadcast that com.whatsapp was updated");
    paramatv.J();
    if (paramva.b != null)
    {
      Log.i("updatedappreceiver/request-refresh");
      RegistrationIntentService.a(u.a());
      return;
    }
    Log.i("updateappreceiver/skip-refresh");
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    va localva = va.a();
    atv localatv = atv.a();
    if (paramIntent.getData().getSchemeSpecificPart().equals(paramContext.getPackageName())) {
      a(localva, localatv);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/UpdatedAnyAppReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */