package com.whatsapp;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.whatsapp.data.cs;
import com.whatsapp.data.ct;
import com.whatsapp.data.e;
import com.whatsapp.util.Log;

public class br
{
  private static volatile br a;
  private final Context b;
  private final pv c;
  private final e d;
  private final and e;
  private final aq f;
  private final aat g;
  private final atu h;
  
  private br(Context paramContext, pv parampv, e parame, and paramand, aq paramaq, aat paramaat, atu paramatu)
  {
    this.b = paramContext;
    this.c = parampv;
    this.d = parame;
    this.e = paramand;
    this.f = paramaq;
    this.g = paramaat;
    this.h = paramatu;
  }
  
  private static Intent a(Intent paramIntent, String paramString, Integer paramInteger, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramIntent.putExtra("jid", paramString);
    if (paramInteger != null) {
      paramIntent.putExtra("call_from", paramInteger);
    }
    paramIntent.putExtra("video_call", paramBoolean2);
    paramIntent.putExtra("smaller_call_btn", paramBoolean1);
    return paramIntent;
  }
  
  public static br a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new br(u.a(), pv.a(), e.a(), and.a(), aq.a(), aat.a(), atu.a());
      }
      return a;
    }
    finally {}
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  public final boolean a(cs paramcs, Activity paramActivity, Integer paramInteger, boolean paramBoolean)
  {
    return a(paramcs, paramActivity, paramInteger, paramBoolean, false);
  }
  
  public final boolean a(cs paramcs, Activity paramActivity, Integer paramInteger, boolean paramBoolean1, boolean paramBoolean2)
  {
    Log.w("app/startOutgoingCall/from " + paramInteger + " video call:" + paramBoolean2 + ", smallerBtn: " + paramBoolean1);
    Object localObject = this.e.c;
    if (localObject == null) {
      Log.w("app/startOutgoingCall tm=null");
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0) {
        break label106;
      }
      Log.w("app/startOutgoingCall/failed_no_cellular_call_in_progress");
      this.c.b(paramActivity, 2131296396, 1);
      paramcs = paramcs.t;
      VoiceService.l();
      return false;
      if (((TelephonyManager)localObject).getCallState() == 0) {
        break;
      }
    }
    label106:
    if (this.g.a(true) == 0)
    {
      if (aat.a(paramActivity))
      {
        Log.w("app/startOutgoingCall/failed_airplane_mode_is_on");
        this.c.b(paramActivity, 2131296395, 1);
        paramcs = paramcs.t;
        VoiceService.l();
        return false;
      }
      Log.w("app/startOutgoingCall/failed_no_network");
      this.c.b(paramActivity, 2131298146, 1);
      paramcs = paramcs.t;
      VoiceService.l();
      return false;
    }
    if ((paramcs.h) && (this.f.a(paramcs.t)))
    {
      Log.w("app/startOutgoingCall/failed_contact_blocked");
      paramInteger = paramActivity.getString(2131298139, new Object[] { paramcs.a(paramActivity) });
      if (this.c.e != null)
      {
        this.c.e.b(paramInteger, paramcs.t);
        return false;
      }
      pv.a(paramActivity, paramInteger, 0);
      return false;
    }
    if ((paramBoolean2) && (!b()))
    {
      paramInteger = new Intent(paramActivity, VoipNotAllowedActivity.class);
      paramInteger.putExtra("jid", paramcs.t);
      paramInteger.putExtra("reason", 7);
      paramActivity.startActivity(paramInteger);
      Log.w("app/startOutgoingCall/failed_not_allowed 7");
      return false;
    }
    if (paramcs.h)
    {
      this.d.b.c(paramcs);
      localObject = this.h;
      int j;
      if (((Build.VERSION.SDK_INT < 23) && (!((atu)localObject).e())) || ((Build.VERSION.SDK_INT >= 23) && (((atu)localObject).a("android.permission.RECORD_AUDIO") != 0)))
      {
        i = 1;
        if ((!paramBoolean2) || (((Build.VERSION.SDK_INT >= 23) || (((atu)localObject).f())) && ((Build.VERSION.SDK_INT < 23) || (((atu)localObject).a("android.permission.CAMERA") == 0)))) {
          break label483;
        }
        j = 1;
        label416:
        if ((i != 0) || (j != 0)) {
          break label489;
        }
      }
      label483:
      label489:
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label495;
        }
        Log.w("app/startOutgoingCall/failed_no_record_audio_permission");
        localObject = new Intent(this.b, VoipPermissionsActivity.class);
        a((Intent)localObject, paramcs.t, paramInteger, paramBoolean1, paramBoolean2);
        paramActivity.startActivity((Intent)localObject);
        return false;
        i = 0;
        break;
        j = 0;
        break label416;
      }
      label495:
      if (Voip.e())
      {
        if (paramcs.t.equals(Voip.getPeerJid()))
        {
          if (!aic.h())
          {
            paramInteger = new Intent(paramActivity, VoipActivity.class);
            paramInteger.putExtra("jid", paramcs.t);
          }
          for (paramcs = paramInteger;; paramcs = paramInteger)
          {
            paramActivity.startActivity(paramcs);
            return true;
            paramInteger = new Intent(paramActivity, VoipActivityV2.class);
            paramInteger.putExtra("jid", paramcs.t);
          }
        }
        Log.w("app/startOutgoingCall/ try to start outgoing call from active voip call");
        pv.a(paramActivity, 2131296731, 0);
        return false;
      }
      localObject = new Intent("start_call", null, this.b, VoiceService.class);
      a((Intent)localObject, paramcs.t, paramInteger, paramBoolean1, paramBoolean2);
      paramActivity.startService((Intent)localObject);
      return true;
    }
    try
    {
      paramActivity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + cs.b(paramcs.t))));
      return true;
    }
    catch (ActivityNotFoundException paramcs)
    {
      for (;;)
      {
        Log.w("dial dialer app not found");
        this.c.c();
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/br.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */