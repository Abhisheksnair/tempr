package com.whatsapp.protocol;

import a.a.a.a.d;
import android.os.Bundle;
import android.os.Message;
import com.whatsapp.ace;
import com.whatsapp.aic;
import com.whatsapp.anv;
import com.whatsapp.atv;
import com.whatsapp.messaging.ba;
import com.whatsapp.messaging.bf;
import com.whatsapp.messaging.bp;
import com.whatsapp.messaging.u.a;
import com.whatsapp.messaging.w;
import com.whatsapp.util.Log;
import java.net.URL;

public final class aa
{
  public final u.a a;
  public final anv b;
  public final w c;
  public final aic d;
  public final atv e;
  
  public aa(anv paramanv, w paramw, aic paramaic, atv paramatv, u.a parama)
  {
    this.b = paramanv;
    this.c = paramw;
    this.d = paramaic;
    this.e = paramatv;
    this.a = parama;
  }
  
  public final void a()
  {
    Log.i("xmpp/reader/read/blocklist/clear");
    this.a.a(Message.obtain(null, 0, 10, 0));
  }
  
  public final void a(int paramInt)
  {
    Log.i("xmpp/reader/on-capability-error");
    this.a.a(Message.obtain(null, 0, 98, paramInt));
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte1, String paramString, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, Runnable paramRunnable)
  {
    Log.i("xmpp/reader/read/get-cipher-key");
    this.a.a(Message.obtain(null, 0, 74, 0, new bf(paramInt, paramArrayOfByte1, paramString, paramArrayOfByte2, paramArrayOfByte3, paramRunnable)));
  }
  
  public final void a(long paramLong)
  {
    Log.i("xmpp/reader/read/ping_response; timestamp=" + paramLong);
    this.a.a(paramLong);
  }
  
  public final void a(al paramal, ar paramar)
  {
    Log.i("xmpp/reader/read/on-qr-action-set-chat");
    this.a.a(Message.obtain(null, 0, 45, 0, new bp(paramal.a, paramal.c, paramar)));
  }
  
  public final void a(al paramal, at paramat)
  {
    Log.i("xmpp/reader/read/on-qr-action-set-pic");
    this.a.a(Message.obtain(null, 0, 40, 0, new bp(paramal.a, paramal.c, paramat)));
  }
  
  public final void a(al paramal, au paramau)
  {
    Log.i("xmpp/reader/read/on-qr-action-set-prs");
    this.a.a(Message.obtain(null, 0, 41, 0, new bp(paramal.a, paramal.c, paramau)));
  }
  
  public final void a(al paramal, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    Log.i("xmpp/reader/read/profilephotochange " + paramString1 + " jid_changed_by:" + paramString2 + " photo_id_string:" + paramString3);
    int i;
    if (paramString3 == null) {
      i = -1;
    }
    for (;;)
    {
      paramString3 = this.a;
      paramal = paramal.c;
      Bundle localBundle = new Bundle();
      localBundle.putString("msgid", paramal);
      localBundle.putString("jid", paramString1);
      localBundle.putString("jid_changed_by", paramString2);
      localBundle.putInt("timestamp", paramInt);
      paramString3.a(Message.obtain(null, 0, 13, i, localBundle));
      return;
      try
      {
        i = Integer.parseInt(paramString3);
      }
      catch (NumberFormatException paramal) {}
    }
  }
  
  public final void a(al paramal, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfString[i];
      localObject = new j.b(paramal.a, true, (String)localObject);
      String str = paramal.e;
      Log.i("xmpp/reader/read/server-error-for-target " + localObject + " " + str);
      u.a locala = this.a;
      Bundle localBundle = new Bundle();
      localBundle.putString("played_jid", str);
      localBundle.putString("msgid", ((j.b)localObject).c);
      localBundle.putString("remote_jid", ((j.b)localObject).a);
      locala.a(Message.obtain(null, 0, 76, 0, localBundle));
      i += 1;
    }
    this.a.a(d.a(paramal));
  }
  
  public final void a(al paramal, String[] paramArrayOfString, int paramInt, long paramLong)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayOfString[i];
      localObject = new j.b(paramal.a, true, (String)localObject);
      String str = paramal.e;
      Log.i("xmpp/reader/read/status-update-from-target " + localObject + " " + str + " " + paramInt + " " + paramLong);
      this.a.a(d.a(new ba((j.b)localObject, str, paramInt, paramLong)));
      i += 1;
    }
    this.a.a(d.a(paramal));
  }
  
  public final void a(j paramj)
  {
    this.a.a(Message.obtain(null, 0, 112, 0, paramj));
  }
  
  public final void a(String paramString, int paramInt)
  {
    Log.i("xmpp/reader/read/on-qr-sync-error " + paramInt);
    u.a locala = this.a;
    Bundle localBundle = new Bundle();
    localBundle.putString("ref", paramString);
    localBundle.putInt("code", paramInt);
    locala.a(Message.obtain(null, 0, 35, 0, localBundle));
  }
  
  public final void a(String paramString, int paramInt, long paramLong)
  {
    Log.i("xmpp/reader/read/sync-contact-error sid=" + paramString + " index=0 code=" + paramInt + " backoff=" + paramLong);
    u.a locala = this.a;
    Bundle localBundle = new Bundle();
    localBundle.putString("sid", paramString);
    localBundle.putInt("index", 0);
    localBundle.putInt("code", paramInt);
    localBundle.putLong("backoff", paramLong);
    locala.a(Message.obtain(null, 0, 27, 0, localBundle));
  }
  
  public final void a(String paramString1, String paramString2)
  {
    Log.i("xmpp/reader/read/client_config");
    u.a locala = this.a;
    Bundle localBundle = new Bundle();
    localBundle.putString("platform", paramString1);
    localBundle.putString("push_id", paramString2);
    locala.a(Message.obtain(null, 0, 8, 0, localBundle));
  }
  
  public final void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    Log.w("xmpp/reader/on-set-two-factor-auth-error errorCode: " + paramInt + " errorMessage: " + paramString3);
    u.a locala = this.a;
    Bundle localBundle = new Bundle();
    localBundle.putString("code", paramString1);
    localBundle.putString("email", paramString2);
    localBundle.putInt("errorCode", paramInt);
    localBundle.putString("errorMessage", paramString3);
    locala.a(Message.obtain(null, 0, 111, 0, localBundle));
  }
  
  public final void a(String paramString1, String paramString2, URL paramURL, byte[] paramArrayOfByte, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder("xmpp/reader/read/profilephotoreceived ").append(paramString1).append(" id:").append(paramString2).append(" type:").append(paramString3).append("has_url:");
    boolean bool;
    label68:
    int i;
    if (paramURL != null)
    {
      bool = true;
      localStringBuilder = localStringBuilder.append(bool).append(" has_data:");
      if (paramArrayOfByte == null) {
        break label142;
      }
      bool = true;
      Log.i(bool);
      if (paramString2 != null) {
        break label148;
      }
      i = -1;
      paramString2 = this.a;
      if (!"preview".equals(paramString3)) {
        break label157;
      }
    }
    for (int j = 2;; j = 1)
    {
      paramString2.a(Message.obtain(null, 0, 12, 0, new ace(paramString1, paramArrayOfByte, paramURL, i, j)));
      return;
      bool = false;
      break;
      label142:
      bool = false;
      break label68;
      label148:
      label157:
      try
      {
        i = Integer.parseInt(paramString2);
      }
      catch (NumberFormatException paramString1) {}
    }
  }
  
  public final void b()
  {
    Log.i("xmpp/reader/read/blocklist/finished");
    this.a.a(Message.obtain(null, 0, 92, 0));
  }
  
  public final void b(String paramString, int paramInt, long paramLong)
  {
    Log.i("xmpp/reader/read/sync-status-error sid=" + paramString + " index=0 code=" + paramInt + " backoff=" + paramLong);
    u.a locala = this.a;
    Bundle localBundle = new Bundle();
    localBundle.putString("sid", paramString);
    localBundle.putInt("index", 0);
    localBundle.putInt("code", paramInt);
    localBundle.putLong("backoff", paramLong);
    locala.a(Message.obtain(null, 0, 122, 0, localBundle));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */