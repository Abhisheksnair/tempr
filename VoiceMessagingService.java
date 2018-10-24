package com.whatsapp;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.search.verification.client.SearchActionVerificationClientService;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import java.io.IOException;

public class VoiceMessagingService
  extends SearchActionVerificationClientService
{
  final aoj a = aoj.a();
  final vp b = vp.a();
  private final Handler c = new Handler(Looper.getMainLooper());
  private final va d = va.a();
  private final anv e = anv.a();
  private final oz f = oz.a();
  private final and g = and.a();
  
  private boolean a(Uri paramUri, String paramString)
  {
    try
    {
      MediaData localMediaData = new MediaData();
      localMediaData.file = MediaFileUtils.a(this.d, this.f, this.g, paramUri);
      if (localMediaData.file == null)
      {
        Log.w("null audio file provided to voice messaging; itemUri=" + paramUri);
        return false;
      }
      Log.i("sending verified voice message (voice); jid=" + paramString);
      this.c.post(aqq.a(this, paramString, localMediaData));
      return true;
    }
    catch (IOException paramUri)
    {
      Log.c("IO Exception while trying to send voice message", paramUri);
    }
    return false;
  }
  
  public boolean performAction(Intent paramIntent, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean)
    {
      Log.w("ignoring unverified voice message");
      return false;
    }
    if (!this.e.e())
    {
      Log.i("ignoring voice message due to ToS update state");
      return false;
    }
    String str = paramIntent.getStringExtra("com.google.android.voicesearch.extra.RECIPIENT_CONTACT_CHAT_ID");
    if (TextUtils.isEmpty(str))
    {
      Log.w("ignoring voice message with empty jid; jid=" + str);
      return false;
    }
    if (!str.endsWith("@s.whatsapp.net"))
    {
      Log.w("ignoring voice message directed at invalid jid; jid=" + str);
      return false;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramBundle = paramIntent.getClipData();
      if ((paramBundle != null) && (paramBundle.getItemCount() == 1))
      {
        paramBundle = paramBundle.getItemAt(0);
        if (paramBundle != null) {
          paramBundle = paramBundle.getUri();
        }
      }
      while (paramBundle != null)
      {
        return a(paramBundle, str);
        paramBundle = null;
        continue;
        if ((paramBundle != null) && ((paramBundle.getItemCount() > 1) || (paramBundle.getItemCount() < 0)))
        {
          Log.w("ignoring voice message with unexpected item count; itemCount=" + paramBundle.getItemCount());
          return false;
        }
      }
    }
    paramIntent = paramIntent.getStringExtra("android.intent.extra.TEXT");
    if (TextUtils.isEmpty(paramIntent))
    {
      Log.w("ignoring voice message with empty contents; jid=" + str + "; text=" + paramIntent);
      return false;
    }
    Log.i("sending verified voice message (text); jid=" + str);
    this.c.post(aqr.a(this, str, paramIntent));
    return true;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/VoiceMessagingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */