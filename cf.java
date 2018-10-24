package com.whatsapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import b.a.a.c;
import com.whatsapp.fieldstats.l;
import com.whatsapp.g.f;

public final class cf
  extends BroadcastReceiver
{
  static void a(Context paramContext, NetworkInfo paramNetworkInfo)
  {
    boolean bool2 = true;
    if ((paramNetworkInfo != null) && (paramNetworkInfo.isRoaming()))
    {
      bool1 = true;
      l.a(paramContext, 37, Boolean.valueOf(bool1));
      if ((paramNetworkInfo == null) || (paramNetworkInfo.getType() != 1)) {
        break label65;
      }
    }
    label65:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      l.a(paramContext, 23, Boolean.valueOf(bool1));
      l.a(paramContext, 105, pb.a(paramNetworkInfo));
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    c.a().c(f.a(paramIntent));
    a(paramContext, paramIntent);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */