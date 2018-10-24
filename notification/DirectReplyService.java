package com.whatsapp.notification;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.an.a;
import android.support.v4.app.an.a.a;
import android.support.v4.app.ay;
import android.support.v4.app.ay.a;
import com.whatsapp.and;
import com.whatsapp.anv;
import com.whatsapp.aoj;
import com.whatsapp.data.ad;
import com.whatsapp.data.cs;
import com.whatsapp.ka;
import com.whatsapp.lt;
import com.whatsapp.pv;
import com.whatsapp.util.Log;
import com.whatsapp.util.be;

public class DirectReplyService
  extends IntentService
{
  final aoj a = aoj.a();
  final ad b = ad.a();
  final f c = f.a();
  final ka d = ka.a();
  private final pv e = pv.a();
  private final anv f = anv.a();
  private final com.whatsapp.data.e g = com.whatsapp.data.e.a();
  private final and h = and.a();
  private final lt i = lt.a();
  
  public DirectReplyService()
  {
    super("DirectReply");
  }
  
  public static an.a a(Context paramContext, cs paramcs)
  {
    Object localObject = paramContext.getString(2131297610, new Object[] { paramcs.a(paramContext) });
    localObject = new ay.a("direct_reply_input").a((CharSequence)localObject).a();
    paramContext = PendingIntent.getService(paramContext, 0, new Intent(null, paramcs.o(), paramContext, DirectReplyService.class), 0);
    return new an.a.a(2130840071, ((ay)localObject).b(), paramContext).a((ay)localObject).a();
  }
  
  public static boolean a()
  {
    return (Build.VERSION.SDK_INT > 23) || ((Build.VERSION.SDK_INT == 23) && (Build.VERSION.PREVIEW_SDK_INT > 0));
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      Log.i("directreplyservice/null intent");
      return;
    }
    if (!this.f.e())
    {
      Log.i("directreplyservice/tos update does not allow messaging");
      return;
    }
    Object localObject = ay.a(paramIntent);
    if (localObject == null)
    {
      Log.i("directreplyservice/could not find remote input");
      return;
    }
    paramIntent = this.g.a(paramIntent.getData());
    if (paramIntent == null)
    {
      Log.i("directreplyservice/contact could not be found");
      return;
    }
    localObject = ((Bundle)localObject).getString("direct_reply_input");
    if (localObject == null)
    {
      Log.i("directreplyservice/no message found in reply intent");
      return;
    }
    if (!be.b(this, this.h, (CharSequence)localObject))
    {
      Log.i("directreplyservice/message is empty");
      this.e.a(d.a(this));
      return;
    }
    this.e.a(e.a(this, paramIntent, (String)localObject));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/notification/DirectReplyService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */