package com.whatsapp.appwidget;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.widget.RemoteViews;
import com.whatsapp.Conversation;
import com.whatsapp.Main;
import com.whatsapp.data.ad;
import com.whatsapp.lt;
import com.whatsapp.notification.a.f;
import com.whatsapp.notification.k;
import com.whatsapp.protocol.j;
import com.whatsapp.pv;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(11)
public class WidgetProvider
  extends AppWidgetProvider
{
  private static ArrayList<j> a;
  private static Handler b;
  private static Runnable c;
  private b d;
  
  public static ArrayList<j> a()
  {
    return a;
  }
  
  public static void a(Context paramContext)
  {
    Object localObject1;
    if (paramContext.getResources().getBoolean(2131492865)) {
      localObject1 = AppWidgetManager.getInstance(paramContext);
    }
    try
    {
      localObject1 = ((AppWidgetManager)localObject1).getAppWidgetIds(new ComponentName(paramContext, WidgetProvider.class));
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        Intent localIntent = new Intent(paramContext, WidgetProvider.class);
        localIntent.setAction("android.appwidget.action.APPWIDGET_UPDATE");
        localIntent.putExtra("appWidgetIds", (int[])localObject1);
        paramContext.sendBroadcast(localIntent);
      }
      paramContext = f.a(paramContext);
      if (f.a(paramContext))
      {
        if (c == null) {
          c = new a(paramContext);
        }
        b().removeCallbacks(c);
        b().post(c);
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      for (;;)
      {
        Log.e("widgetprovider/getAppWidgetIds failed" + localRuntimeException.toString());
        Object localObject2 = null;
      }
    }
  }
  
  private static Handler b()
  {
    if (b == null)
    {
      HandlerThread localHandlerThread = new HandlerThread("update_widget", 10);
      localHandlerThread.start();
      b = new Handler(localHandlerThread.getLooper());
    }
    return b;
  }
  
  private static RemoteViews b(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    if (b(paramInt2, paramInt3))
    {
      RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2130903414);
      localObject = "";
      if (a != null)
      {
        if (a.size() <= 0) {
          break label213;
        }
        localObject = String.format(u.a.a(2131230812, a.size()), new Object[] { Integer.valueOf(a.size()) });
        localRemoteViews.setViewVisibility(2131756268, 0);
      }
      for (;;)
      {
        localRemoteViews.setTextViewText(2131756268, (CharSequence)localObject);
        localObject = new Intent(paramContext, WidgetService.class);
        ((Intent)localObject).putExtra("appWidgetId", paramInt1);
        ((Intent)localObject).setData(Uri.parse(((Intent)localObject).toUri(1)));
        localRemoteViews.setRemoteAdapter(paramInt1, 2131756269, (Intent)localObject);
        localObject = new Intent(paramContext, Conversation.class);
        ((Intent)localObject).setAction("android.intent.action.VIEW");
        localRemoteViews.setPendingIntentTemplate(2131756269, PendingIntent.getActivity(paramContext, 0, (Intent)localObject, 134217728));
        localRemoteViews.setOnClickPendingIntent(2131755386, PendingIntent.getActivity(paramContext, 0, new Intent(paramContext, Main.n()), 134217728));
        localRemoteViews.setEmptyView(2131756269, 2131756097);
        return localRemoteViews;
        label213:
        localObject = paramContext.getString(2131297307);
        localRemoteViews.setViewVisibility(2131756268, 8);
      }
    }
    Object localObject = new RemoteViews(paramContext.getPackageName(), 2130903416);
    float f2;
    float f1;
    if (a != null)
    {
      paramInt1 = a.size();
      ((RemoteViews)localObject).setTextViewText(2131755398, Integer.toString(paramInt1));
      f2 = 30.0F;
      f1 = f2;
      if (paramInt2 < 100)
      {
        if (paramInt1 <= 99) {
          break label342;
        }
        f1 = 14.0F;
      }
    }
    for (;;)
    {
      ((RemoteViews)localObject).setFloat(2131755398, "setTextSize", f1);
      ((RemoteViews)localObject).setOnClickPendingIntent(2131755386, PendingIntent.getActivity(paramContext, 0, new Intent(paramContext, Main.n()), 134217728));
      return (RemoteViews)localObject;
      label342:
      f1 = f2;
      if (paramInt1 > 9) {
        f1 = 20.0F;
      }
    }
  }
  
  private static boolean b(int paramInt1, int paramInt2)
  {
    return (paramInt1 > 100) && (paramInt2 > 100);
  }
  
  public void onAppWidgetOptionsChanged(Context paramContext, AppWidgetManager paramAppWidgetManager, int paramInt, Bundle paramBundle)
  {
    int j = Integer.MAX_VALUE;
    int k;
    int i;
    if (Build.VERSION.SDK_INT >= 16)
    {
      if (paramBundle == null) {
        break label107;
      }
      k = paramBundle.getInt("appWidgetMinWidth");
      i = paramBundle.getInt("appWidgetMinHeight");
      Log.i("widgetprovider/onappwidgetoptionschanged " + k + "x" + i);
      if ((k != 0) && (i != 0)) {
        break label100;
      }
      i = Integer.MAX_VALUE;
    }
    for (;;)
    {
      paramAppWidgetManager.updateAppWidget(paramInt, b(paramContext, paramInt, j, i));
      return;
      label100:
      j = k;
      continue;
      label107:
      i = Integer.MAX_VALUE;
    }
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    Log.i("widgetprovider/update " + paramArrayOfInt.length);
    if (this.d != null)
    {
      this.d.d.set(true);
      b().removeCallbacks(this.d);
    }
    this.d = new b(paramContext, paramAppWidgetManager, paramArrayOfInt);
    b().post(this.d);
    super.onUpdate(paramContext, paramAppWidgetManager, paramArrayOfInt);
  }
  
  static final class a
    implements Runnable
  {
    private final f a;
    private final ad b = ad.a();
    private final lt c = lt.a();
    private final k d = k.a();
    
    public a(f paramf)
    {
      this.a = paramf;
    }
    
    public final void run()
    {
      Iterator localIterator = this.c.c().iterator();
      int i = 0;
      int j;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        j = this.b.o(str);
        if (j <= 0) {
          break label76;
        }
        i = j + i;
      }
      label76:
      for (;;)
      {
        break;
        j = this.d.c().size();
        this.a.a(j + i);
        return;
      }
    }
  }
  
  static final class b
    implements Runnable
  {
    final Context a;
    final AppWidgetManager b;
    final int[] c;
    final AtomicBoolean d = new AtomicBoolean();
    private final pv e = pv.a();
    private final ad f = ad.a();
    private final lt g = lt.a();
    
    public b(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
    {
      this.a = paramContext;
      this.b = paramAppWidgetManager;
      this.c = paramArrayOfInt;
    }
    
    public final void run()
    {
      ArrayList localArrayList;
      if (this.d.get()) {
        localArrayList = null;
      }
      for (;;)
      {
        if (localArrayList != null) {
          this.e.a(new a(this, localArrayList));
        }
        return;
        Object localObject = this.g.c();
        localArrayList = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        for (;;)
        {
          if (!((Iterator)localObject).hasNext()) {
            break label126;
          }
          String str = (String)((Iterator)localObject).next();
          if (this.d.get())
          {
            localArrayList = null;
            break;
          }
          int i = this.f.o(str);
          if (i > 0) {
            localArrayList.addAll(this.f.b(str, Math.min(i, 100)));
          }
        }
        label126:
        Collections.sort(localArrayList, b.a());
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/appwidget/WidgetProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */