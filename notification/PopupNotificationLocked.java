package com.whatsapp.notification;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;

public class PopupNotificationLocked
  extends PopupNotification
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setBackgroundDrawable(new ColorDrawable(-16777216));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/notification/PopupNotificationLocked.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */