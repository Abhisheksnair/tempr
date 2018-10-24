package com.whatsapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.whatsapp.util.Log;

public final class rl
{
  public static final rl a = new rl();
  final a b = new a();
  public boolean c;
  
  public static rl a()
  {
    return a;
  }
  
  public static final class a
    extends BroadcastReceiver
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      boolean bool = false;
      paramContext = rl.a();
      int i = paramIntent.getIntExtra("state", 0);
      if ((paramContext.c) && (i <= 0)) {
        yx.j();
      }
      if (i > 0) {
        bool = true;
      }
      paramContext.c = bool;
      Log.i("headserplugbroadcastReceiver/headset " + i);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/rl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */