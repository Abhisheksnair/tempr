package com.whatsapp;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import b.a.a.c;
import com.whatsapp.g.d;
import com.whatsapp.g.k;
import com.whatsapp.util.Log;

final class ak
  extends BroadcastReceiver
{
  @TargetApi(21)
  static void a(and paramand)
  {
    paramand = paramand.a;
    if (paramand == null) {
      Log.w("battery-receiver/on-action-power-save-mode-changed pm=null");
    }
    for (boolean bool = true;; bool = paramand.isPowerSaveMode())
    {
      paramand = new k(bool);
      c.a().c(paramand);
      return;
    }
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    int i = -1;
    switch (paramContext.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("Unexpected action: " + paramIntent.getAction());
        if (paramContext.equals("android.intent.action.BATTERY_CHANGED"))
        {
          i = 0;
          continue;
          if (paramContext.equals("android.os.action.POWER_SAVE_MODE_CHANGED")) {
            i = 1;
          }
        }
        break;
      }
    }
    paramContext = new d(paramIntent);
    if (!paramContext.equals((d)c.a().a(d.class)))
    {
      c.a().c(paramContext);
      Log.i("battery changed; newEvent=" + paramContext);
    }
    return;
    a(and.a());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */