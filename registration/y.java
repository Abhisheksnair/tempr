package com.whatsapp.registration;

import a.a.a.a.d;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import com.whatsapp.atv;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class y
  extends BroadcastReceiver
{
  private static final Pattern a = Pattern.compile("WhatsApp.*?([0-9]{3})-([0-9]{3})");
  private boolean b;
  private final VerifySms c;
  
  y(VerifySms paramVerifySms)
  {
    this.c = paramVerifySms;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    atv localatv = atv.a();
    Log.i("receivedtextreceiver/text/intent");
    if (this.b) {
      Log.i("receivedtextreceiver/already received");
    }
    Object[] arrayOfObject;
    int k;
    int i;
    do
    {
      return;
      if (d.a(this.c))
      {
        Log.i("receivedtextreceiver/destroyed");
        return;
      }
      paramContext = paramIntent.getExtras();
      if (paramContext == null)
      {
        Log.i("receivedtextreceiver/bundle-null");
        return;
      }
      arrayOfObject = (Object[])paramContext.get("pdus");
      if (arrayOfObject == null)
      {
        Log.i("receivedtextreceiver/pdus-null");
        return;
      }
      Log.i("receivedtextreceiver/pdus-length/" + arrayOfObject.length);
      k = arrayOfObject.length;
      i = 0;
    } while (i >= k);
    paramContext = arrayOfObject[i];
    for (;;)
    {
      try
      {
        paramIntent = SmsMessage.createFromPdu((byte[])paramContext);
        if (paramIntent == null) {}
      }
      catch (OutOfMemoryError paramContext)
      {
        try
        {
          paramContext = paramIntent.getMessageBody();
        }
        catch (NullPointerException paramIntent)
        {
          paramContext = null;
        }
        try
        {
          Log.i("verifysms/getMessageBody " + paramContext);
          Log.i("verifysms/displayMessageBody " + paramIntent.getDisplayMessageBody());
          Log.i("verifysms/displayOriginatingAddress " + paramIntent.getDisplayOriginatingAddress());
          Log.i("verifysms/emailBody " + paramIntent.getEmailBody());
          Log.i("verifysms/emailFrom " + paramIntent.getEmailFrom());
          Log.i("verifysms/getOriginatingAddress " + paramIntent.getOriginatingAddress());
          Log.i("verifysms/getPseudoSubject " + paramIntent.getPseudoSubject());
          Log.i("verifysms/getServiceCenterAddress " + paramIntent.getServiceCenterAddress());
          if (paramContext != null) {
            break label361;
          }
          Log.i("receivedtextreceiver/message-null");
          i += 1;
        }
        catch (NullPointerException paramIntent)
        {
          for (;;) {}
        }
        paramContext = paramContext;
        Log.e("verifysms/text/out-of-memory " + paramContext.toString());
        paramIntent = null;
        continue;
      }
      Log.d("verifysms", paramIntent);
      continue;
      label361:
      Log.i("verifysms/text-receiver/" + paramContext);
      paramContext = a.matcher(paramContext);
      if (!paramContext.find())
      {
        Log.w("verifysms/text-receiver/not_sms_verification");
      }
      else
      {
        paramContext = paramContext.group(1) + paramContext.group(2);
        try
        {
          j = Integer.parseInt(paramContext);
          if (j != -1)
          {
            this.b = true;
            abortBroadcast();
            paramIntent = this.c;
            paramIntent.a(paramContext);
            paramIntent.r = 0;
            paramIntent = this.c;
            paramIntent.getClass();
            bu.a(new VerifySms.d(paramIntent), new String[] { paramContext, "auto" });
          }
        }
        catch (Exception paramIntent)
        {
          for (;;)
          {
            Log.w("verifysms/text-receiver/error " + paramIntent + " code=" + paramContext);
            int j = -1;
          }
          Log.w("verifysms/text-receiver/no-code");
          bc.a(localatv, "server-send-mismatch-empty");
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/registration/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */