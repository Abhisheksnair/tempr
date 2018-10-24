package com.whatsapp.service;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.b;
import android.support.v7.app.n.b;
import com.whatsapp.WebSessionsActivity;

public final class WebClientService
  extends Service
{
  public final IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramIntent = new n.b(this);
    paramIntent.a(2130840423);
    paramIntent.c(getString(2131297329));
    paramIntent.a(getString(2131297329));
    paramIntent.b(getString(2131297325));
    paramIntent.a(PendingIntent.getActivity(this, 0, new Intent(this, WebSessionsActivity.class), 0));
    paramIntent.d(-2);
    paramIntent.e(b.c(this, 2131624091));
    startForeground(12, paramIntent.e());
    return 1;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/service/WebClientService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */