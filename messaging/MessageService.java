package com.whatsapp.messaging;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.whatsapp.ahc;
import com.whatsapp.util.Log;

public class MessageService
  extends Service
{
  private final ahc a = ahc.a();
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (ahc.e()) {
      Log.d("messageservice/unsupported");
    }
    do
    {
      return 1;
      if (paramIntent != null) {}
      for (paramIntent = paramIntent.getAction(); (paramIntent == null) || (paramIntent.equals("com.whatsapp.messaging.MessageService.START")); paramIntent = null)
      {
        Log.d("messageservice/start");
        return 1;
      }
    } while (!paramIntent.equals("com.whatsapp.messaging.MessageService.STOP"));
    Log.d("messageservice/stop");
    stopSelf();
    return 1;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/messaging/MessageService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */