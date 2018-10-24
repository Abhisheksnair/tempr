package com.whatsapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import com.whatsapp.util.Log;

final class alt
  extends BroadcastReceiver
{
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.i("app/shutdown/external_media/state/" + Environment.getExternalStorageState());
    paramContext = atv.a();
    paramContext.a(0);
    paramContext.c(false);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/alt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */