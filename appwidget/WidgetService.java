package com.whatsapp.appwidget;

import android.annotation.TargetApi;
import android.content.Intent;
import android.widget.RemoteViewsService;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import com.whatsapp.ant;
import com.whatsapp.data.e;
import com.whatsapp.notification.m;

@TargetApi(11)
public class WidgetService
  extends RemoteViewsService
{
  private final ant a = ant.a();
  private final e b = e.a();
  private final m c = m.a();
  
  public RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent paramIntent)
  {
    return new c(getApplicationContext(), this.a, this.b, this.c);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/appwidget/WidgetService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */