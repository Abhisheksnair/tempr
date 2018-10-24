package com.whatsapp.registration;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.whatsapp.and;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.au;
import com.whatsapp.util.Log;
import com.whatsapp.util.a.c;

public final class i
  extends BroadcastReceiver
{
  static void a(Context paramContext, long paramLong)
  {
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, new Intent("com.whatsapp.alarm.REGISTRATION_TAKING_TOO_LONG_TIMEOUT").setPackage(au.b()), 134217728);
    paramContext = (AlarmManager)paramContext.getSystemService("alarm");
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramContext.setExact(0, paramLong, localPendingIntent);
      return;
    }
    paramContext.set(0, paramLong, localPendingIntent);
  }
  
  public static void a(Context paramContext, atv paramatv)
  {
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(paramContext, 0, new Intent("com.whatsapp.alarm.REGISTRATION_TAKING_TOO_LONG_TIMEOUT").setPackage(au.b()), 536870912);
    if (localPendingIntent != null)
    {
      ((AlarmManager)paramContext.getSystemService("alarm")).cancel(localPendingIntent);
      paramatv.c().remove("registration_start_time").apply();
    }
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.i("app/regtoolong/timeout");
    paramIntent = c.a();
    Object localObject1 = and.a();
    atu localatu = atu.a();
    atv localatv = atv.a();
    Object localObject2 = bb.a();
    long l = localatv.t();
    if ((l > 0L) && (System.currentTimeMillis() - l > 43200000L))
    {
      a(paramContext, localatv);
      if (!((bb)localObject2).b())
      {
        paramContext = localatv.F();
        localObject2 = localatv.G();
        localObject1 = ((and)localObject1).c;
        localObject2 = new StringBuilder("app/registrationtakingtoolong/cc ").append(paramContext).append(" num=").append((String)localObject2).append(" sim=");
        if (localObject1 == null) {
          break label193;
        }
        paramContext = Integer.valueOf(((TelephonyManager)localObject1).getSimState());
        localObject2 = ((StringBuilder)localObject2).append(paramContext).append(" ");
        if (localatu.a("android.permission.READ_PHONE_STATE") != 0) {
          break label208;
        }
        if (localObject1 != null) {
          break label199;
        }
        paramContext = "tm_null";
      }
      for (;;)
      {
        Log.i(paramContext);
        paramIntent.a("verification >= 12 hrs (7d)", false, null, 7);
        localatv.e(-2L);
        return;
        label193:
        paramContext = "tm_null";
        break;
        label199:
        paramContext = ((TelephonyManager)localObject1).getLine1Number();
        continue;
        label208:
        paramContext = "<permission denied>";
      }
    }
    a(paramContext, l + 43200000L);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/registration/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */