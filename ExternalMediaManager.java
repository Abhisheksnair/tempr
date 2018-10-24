package com.whatsapp;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.bu;

public class ExternalMediaManager
  extends Service
{
  final atv a = atv.a();
  private final vv b = vv.a();
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramIntent = Environment.getExternalStorageState();
    paramInt1 = -1;
    vv localvv;
    switch (paramIntent.hashCode())
    {
    default: 
      switch (paramInt1)
      {
      default: 
        localvv = this.b;
        if (!localvv.a)
        {
          localvv.a = true;
          localvv.b = true;
          Log.i("media-state-manager/external/unavailable " + Environment.getExternalStorageState());
        }
        break;
      }
      break;
    }
    for (;;)
    {
      bu.a(oy.a(this, paramIntent));
      return 2;
      if (!paramIntent.equals("mounted")) {
        break;
      }
      paramInt1 = 0;
      break;
      if (!paramIntent.equals("mounted_ro")) {
        break;
      }
      paramInt1 = 1;
      break;
      localvv = this.b;
      if ((localvv.a) || (localvv.b))
      {
        localvv.a = false;
        localvv.b = false;
        Log.i("media-state-manager/external/available");
        localvv.d();
      }
      MediaFileUtils.a();
      continue;
      localvv = this.b;
      if ((localvv.a) || (!localvv.b))
      {
        localvv.a = false;
        localvv.b = true;
        Log.i("media-state-manager/read-only");
        localvv.d();
      }
      MediaFileUtils.a();
    }
  }
  
  public static class ExternalMediaStateReceiver
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext.startService(paramIntent.setClass(paramContext, ExternalMediaManager.class));
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ExternalMediaManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */