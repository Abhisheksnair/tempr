package com.whatsapp.gcm;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.c.b;
import com.whatsapp.util.Log;

public class GcmReceiver
  extends b
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      super.onReceive(paramContext, paramIntent);
      return;
    }
    catch (SecurityException paramContext)
    {
      Log.d("some permissions related nonsense happened while receiving a gcm broadcast", paramContext);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gcm/GcmReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */