package com.whatsapp.gcm;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import b.a.a.c;
import com.whatsapp.aic;
import com.whatsapp.atv;
import com.whatsapp.av;
import com.whatsapp.fieldstats.events.bg;
import com.whatsapp.fieldstats.l;
import com.whatsapp.g.i;
import com.whatsapp.g.j;
import com.whatsapp.gcm.a.e;
import com.whatsapp.gcm.a.h;
import com.whatsapp.messaging.k;
import com.whatsapp.messaging.m;
import com.whatsapp.ph;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import java.io.IOException;

public class GcmListenerService
  extends com.google.android.gms.c.a
{
  private final m a = m.a();
  private final ph b = ph.a();
  private final atv c = atv.a();
  private final k d = k.a();
  private final com.whatsapp.l.f e = com.whatsapp.l.f.a();
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean)
  {
    Log.i("GCM push received; id=" + paramString1 + "; ip=" + paramString2 + "; ts=" + paramString3 + "; sessionId = " + paramString4 + "; mmsOverride=" + paramString5 + "; fbips=" + paramString6 + "; notifyOnFailure=" + paramBoolean + "; routingInfo=" + paramString8 + "; dnsDomain=" + paramString9);
    this.c.a(0);
    this.b.a = true;
    this.b.b = SystemClock.elapsedRealtime();
    if (!TextUtils.isEmpty(paramString3)) {}
    try
    {
      l1 = Long.parseLong(paramString3);
      j localj = (j)c.a().a(j.class);
      com.whatsapp.g.f localf = (com.whatsapp.g.f)c.a().a(com.whatsapp.g.f.class);
      i locali = (i)c.a().a(i.class);
      bg localbg = new bg();
      l2 = localj.a();
      localbg.b = Double.valueOf(l2 - l1 * 1000L);
      localbg.c = Double.valueOf(l2 - localf.d);
      localbg.a = Boolean.valueOf(locali.a);
      l.a(paramContext, localbg);
    }
    catch (NumberFormatException paramContext)
    {
      try
      {
        for (;;)
        {
          long l1;
          long l2;
          i = Integer.parseInt(paramString7);
          paramString7 = this.c;
          if ((!av.k()) || (paramString1 == null)) {
            break label347;
          }
          try
          {
            l2 = Long.parseLong(paramString3);
            l1 = ((j)c.a().a(j.class)).a();
            l2 = l1 - l2 * 1000L;
            if (l2 <= 60000L) {
              break label492;
            }
            bu.a(e.a(l2, paramString1, l1, paramContext, paramString3, paramString7, i));
            if (!"CLEAR".equalsIgnoreCase(paramString5)) {
              break label503;
            }
            this.c.a(null, 0L);
            if ((TextUtils.isEmpty(paramString8)) || (TextUtils.isEmpty(paramString9))) {
              break label403;
            }
          }
          catch (NumberFormatException paramContext)
          {
            try
            {
              for (;;)
              {
                this.e.a(org.whispersystems.a.i.a.a(paramString8));
                this.c.d(paramString9);
                if (paramString6 == null) {
                  break label632;
                }
                paramContext = paramString6.split(",");
                boolean bool = aic.X;
                this.a.a(true, true, paramBoolean, paramString2, paramString4, paramContext, k.a(paramContext), bool);
                return;
                localNumberFormatException = localNumberFormatException;
                Log.e("invalid timestamp received in c2dm push: " + paramString3);
                break;
                paramContext = paramContext;
                Log.e("invalid timestamp received in c2dm push: " + paramString3);
                continue;
                h.a(paramContext, l2, i);
                continue;
                if (!TextUtils.isEmpty(paramString5))
                {
                  paramContext = paramString5.split("\\|", 3);
                  if (paramContext.length != 3) {
                    break label588;
                  }
                  try
                  {
                    l1 = Long.parseLong(paramContext[1]);
                    l2 = Long.parseLong(paramContext[2]);
                    this.c.a(paramContext[0], (l1 + l2) * 1000L);
                  }
                  catch (NumberFormatException paramContext)
                  {
                    Log.w("c2dm/mms_override/invalid_numbers:" + paramString5);
                  }
                }
              }
              Log.w("c2dm/mms_override/invalid_override:" + paramString5);
            }
            catch (IOException paramContext)
            {
              for (;;)
              {
                Log.w("GcmListenerService/handleGcmPush/routingInfo/failed to parse edgeRoutingRoutingInfo");
              }
            }
            catch (IllegalArgumentException paramContext)
            {
              for (;;)
              {
                Log.w("GcmListenerService/handleGcmPush/routingInfo/failed to save edgeRoutingRoutingInfo, routing info is too big");
                continue;
                paramContext = null;
              }
            }
          }
        }
      }
      catch (NumberFormatException paramString7)
      {
        for (;;)
        {
          int j;
          int i = j;
        }
      }
    }
    j = 0;
    i = j;
    if (TextUtils.isEmpty(paramString7)) {}
  }
  
  public final void a()
  {
    a(this, null, null, null, null, null, null, null, null, null, false);
  }
  
  public final void a(Bundle paramBundle)
  {
    a(this, paramBundle.getString("id"), paramBundle.getString("ip"), paramBundle.getString("ts"), paramBundle.getString("cl_sess"), paramBundle.getString("mmsov"), paramBundle.getString("fbips"), paramBundle.getString("new_s"), paramBundle.getString("er_ri"), paramBundle.getString("er_dd"), "1".equals(paramBundle.getString("notify")));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gcm/GcmListenerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */