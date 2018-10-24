package com.whatsapp.notification;

import android.content.Context;
import android.content.Intent;
import b.a.a.c;
import com.whatsapp.g.l;
import com.whatsapp.pd;
import com.whatsapp.util.Log;

public final class af
  implements Runnable
{
  private final Context a;
  private final int b;
  private final String c;
  private final pd d;
  
  public af(Context paramContext, pd parampd, int paramInt, String paramString)
  {
    this.a = paramContext;
    this.d = parampd;
    this.b = paramInt;
    this.c = paramString;
  }
  
  public final void run()
  {
    boolean bool = ((l)c.a().a(l.class)).a;
    Intent localIntent;
    if ((!this.d.d()) || (bool))
    {
      Log.i("messagenotification/popupnotification/background");
      if ((bool) && ((this.b == 2) || (this.b == 3)))
      {
        if ((PopupNotification.n != null) && (!(PopupNotification.n instanceof PopupNotificationLocked)))
        {
          PopupNotification.n.finish();
          PopupNotification.n = null;
        }
        localIntent = new Intent(this.a, PopupNotificationLocked.class);
      }
    }
    for (;;)
    {
      if ((PopupNotification.n != null) && (PopupNotification.n.o))
      {
        PopupNotification.n.b(this.c);
        PopupNotification.n.j();
      }
      do
      {
        do
        {
          return;
          if ((this.d.d()) || (this.b == 3)) {
            break label253;
          }
          if ((PopupNotification.n != null) && ((PopupNotification.n instanceof PopupNotificationLocked)))
          {
            PopupNotification.n.finish();
            PopupNotification.n = null;
          }
          localIntent = new Intent(this.a, PopupNotification.class);
          break;
        } while (localIntent == null);
        localIntent.setFlags(268697600);
        localIntent.putExtra("popup_notification_extra_quick_reply_jid", this.c);
        this.a.startActivity(localIntent);
        return;
      } while ((PopupNotification.n == null) || (!PopupNotification.n.o));
      Log.i("messagenotification/popupnotification/foreground");
      PopupNotification.n.b(this.c);
      PopupNotification.n.j();
      return;
      label253:
      localIntent = null;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/notification/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */