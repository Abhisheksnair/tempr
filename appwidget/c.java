package com.whatsapp.appwidget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService.RemoteViewsFactory;
import com.whatsapp.ant;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.notification.m;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.l;
import java.util.ArrayList;
import java.util.Iterator;

@TargetApi(11)
public final class c
  implements RemoteViewsService.RemoteViewsFactory
{
  private final Context a;
  private final ant b;
  private final e c;
  private final m d;
  private ArrayList<a> e = new ArrayList();
  
  public c(Context paramContext, ant paramant, e parame, m paramm)
  {
    this.a = paramContext;
    this.b = paramant;
    this.c = parame;
    this.d = paramm;
  }
  
  public final int getCount()
  {
    return this.e.size();
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final RemoteViews getLoadingView()
  {
    return null;
  }
  
  public final RemoteViews getViewAt(int paramInt)
  {
    if (paramInt >= this.e.size()) {
      return null;
    }
    RemoteViews localRemoteViews = new RemoteViews(this.a.getPackageName(), 2130903415);
    a locala = (a)this.e.get(paramInt);
    localRemoteViews.setTextViewText(2131756271, locala.b);
    localRemoteViews.setTextViewText(2131755340, locala.c);
    localRemoteViews.setTextViewText(2131755328, locala.d);
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("jid", locala.a);
    localIntent.putExtras(localBundle);
    localRemoteViews.setOnClickFillInIntent(2131756270, localIntent);
    return localRemoteViews;
  }
  
  public final int getViewTypeCount()
  {
    return 1;
  }
  
  public final boolean hasStableIds()
  {
    return true;
  }
  
  public final void onCreate()
  {
    Log.i("widgetviewsfactory/oncreate");
    onDataSetChanged();
  }
  
  public final void onDataSetChanged()
  {
    Log.i("widgetviewsfactory/ondatasetchanged");
    long l = Binder.clearCallingIdentity();
    try
    {
      Object localObject1 = WidgetProvider.a();
      this.e.clear();
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          j localj = (j)((Iterator)localObject1).next();
          a locala = new a((byte)0);
          cs localcs = this.c.d(localj.e.a);
          locala.a = localcs.t;
          locala.b = com.whatsapp.emoji.c.a(localcs.a(this.a));
          locala.c = this.d.a(localj, localcs, false, false);
          locala.d = l.b(this.a, this.b.a(localj));
          this.e.add(locala);
        }
      }
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
  }
  
  public final void onDestroy()
  {
    Log.i("widgetviewsfactory/ondestroy");
  }
  
  static final class a
  {
    String a;
    CharSequence b;
    CharSequence c;
    String d;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/appwidget/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */