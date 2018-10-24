package com.whatsapp.notification;

import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.support.v4.app.an.a;
import android.support.v4.app.an.d;
import android.support.v4.app.an.g;
import android.support.v4.app.an.s;
import android.support.v4.app.aw;
import android.text.TextUtils;
import b.a.a.c;
import com.whatsapp.Conversation;
import com.whatsapp.HomeActivity;
import com.whatsapp.Main;
import com.whatsapp.Voip;
import com.whatsapp.VoipActivity;
import com.whatsapp.VoipActivityV2;
import com.whatsapp.aic;
import com.whatsapp.al;
import com.whatsapp.and;
import com.whatsapp.anv;
import com.whatsapp.appwidget.WidgetProvider;
import com.whatsapp.aus;
import com.whatsapp.bb;
import com.whatsapp.bb.a;
import com.whatsapp.cc;
import com.whatsapp.cc.a;
import com.whatsapp.data.ad;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.g.o;
import com.whatsapp.hx;
import com.whatsapp.j.a.a;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.pv;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.b;
import com.whatsapp.util.bu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class k
{
  private static volatile k b;
  ConcurrentLinkedQueue<j> a;
  private final pv c;
  private final anv d;
  private final ad e;
  private final e f;
  private final and g;
  private final aus h;
  private final b i;
  private final cc j;
  private final hx k;
  
  private k(pv parampv, anv paramanv, ad paramad, bb parambb, e parame, and paramand, aus paramaus, b paramb, cc paramcc, hx paramhx)
  {
    this.c = parampv;
    this.d = paramanv;
    this.e = paramad;
    this.f = parame;
    this.g = paramand;
    this.h = paramaus;
    this.i = paramb;
    this.j = paramcc;
    this.k = paramhx;
    parambb.registerObserver(new bb.a()
    {
      public final void c(j paramAnonymousj)
      {
        k localk = k.this;
        Context localContext = u.a();
        boolean bool = Voip.d(paramAnonymousj);
        localk.d();
        if (localk.a.isEmpty()) {
          u.a().getSharedPreferences("com.whatsapp_preferences", 0).edit().putLong("first_missed_call", paramAnonymousj.n).apply();
        }
        localk.a.add(paramAnonymousj);
        bu.a(new k.2(localk, localContext, bool), new Void[0]);
      }
    });
  }
  
  public static k a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new k(pv.a(), anv.a(), ad.a(), bb.a(), e.a(), and.a(), aus.a(), b.a(), cc.a(), hx.a());
      }
      return b;
    }
    finally {}
  }
  
  public final void a(Context paramContext, aus paramaus, boolean paramBoolean)
  {
    d();
    if (this.a.isEmpty())
    {
      Log.i("missedcallnotification/update cancel " + paramBoolean);
      aw.a(paramContext).a(7);
      return;
    }
    Object localObject3 = new HashSet();
    ArrayList localArrayList = new ArrayList(this.a.size());
    localArrayList.addAll(this.a);
    Object localObject1 = localArrayList.iterator();
    boolean bool = true;
    int m = 1;
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (j)((Iterator)localObject1).next();
      ((HashSet)localObject3).add(((j)localObject2).e.a);
      if ((bool) && (Voip.b((j)localObject2)))
      {
        bool = true;
        label143:
        if ((m == 0) || (Voip.b((j)localObject2))) {
          break label168;
        }
      }
      label168:
      for (m = 1;; m = 0)
      {
        break;
        bool = false;
        break label143;
      }
    }
    if ((!bool) && (m == 0)) {}
    for (int n = 1;; n = 0)
    {
      localObject2 = new an.d(paramContext);
      ((an.d)localObject2).a("call");
      ((an.d)localObject2).d(1);
      ((an.d)localObject2).a(2130840421);
      ((an.d)localObject2).e(paramContext.getResources().getColor(2131624091));
      ((an.d)localObject2).c(true);
      localObject1 = this.g.f;
      if (localObject1 == null) {
        Log.w("missedcallnotification/update cr == null");
      }
      localObject4 = ((HashSet)localObject3).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Object localObject5 = (String)((Iterator)localObject4).next();
        localObject5 = this.f.d((String)localObject5);
        if (localObject1 != null)
        {
          localObject5 = ((cs)localObject5).b((ContentResolver)localObject1);
          if (localObject5 != null) {
            ((an.d)localObject2).b(((Uri)localObject5).toString());
          }
        }
      }
    }
    Object localObject4 = this.j.a(((j)localArrayList.get(localArrayList.size() - 1)).e.a);
    if (!paramBoolean)
    {
      localObject1 = null;
      if (Voip.e()) {
        localObject1 = ((cc.a)localObject4).d();
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = Uri.parse((String)localObject1);
        if (localObject1 != null)
        {
          if ((Build.VERSION.SDK_INT < 21) || ((!Settings.System.DEFAULT_NOTIFICATION_URI.equals(localObject1)) && (!ag.a(this.g, (Uri)localObject1)))) {
            break label1385;
          }
          if (!((o)c.a().a(o.class)).a) {
            ((an.d)localObject2).a((Uri)localObject1);
          }
        }
      }
      label467:
      Log.i("missedcallnotification/update count:" + localArrayList.size() + " contects:" + ((HashSet)localObject3).size() + " quiet:" + paramBoolean);
      if (((HashSet)localObject3).size() == 1)
      {
        localObject3 = (String)((HashSet)localObject3).iterator().next();
        localObject1 = this.f.d((String)localObject3);
        if (localArrayList.size() == 1) {
          if (bool)
          {
            m = 2131298114;
            label569:
            ((an.d)localObject2).a(paramContext.getString(m));
            if (Build.VERSION.SDK_INT >= 11)
            {
              paramaus = ((cs)localObject1).c(paramContext.getResources().getDimensionPixelSize(17104901), paramContext.getResources().getDimensionPixelSize(17104902));
              if (paramaus != null) {
                ((an.d)localObject2).a(paramaus);
              }
            }
            if (!bool) {
              break label1486;
            }
            m = 2131298116;
            label636:
            ((an.d)localObject2).c(paramContext.getString(m, new Object[] { ((cs)localObject1).a(paramContext) }));
            ((an.d)localObject2).b(((cs)localObject1).a(paramContext));
            paramBoolean = this.d.e();
            if (aic.h()) {
              break label1494;
            }
            paramaus = new Intent(paramContext, VoipActivity.class);
            paramaus.putExtra("jid", (String)localObject3);
            paramaus.putExtra("fromCallNotification", true);
            label718:
            paramaus.setFlags(268435456);
            paramaus.putExtra("video_call", bool);
            paramaus = PendingIntent.getActivity(paramContext, 0, paramaus, 268435456);
            localObject3 = Conversation.a((cs)localObject1);
            ((Intent)localObject3).putExtra("fromCallNotification", true);
            ((Intent)localObject3).setAction("com.whatsapp.intent.action.MESSAGE");
            localObject3 = PendingIntent.getActivity(paramContext, 0, (Intent)localObject3, 268435456);
            if (paramBoolean)
            {
              if (!bool) {
                break label1528;
              }
              m = 2130840085;
              label798:
              ((an.d)localObject2).a(m, paramContext.getText(2131297184), paramaus);
              ((an.d)localObject2).a(2130840065, paramContext.getText(2131297186), (PendingIntent)localObject3);
            }
            if (AndroidWear.a())
            {
              localObject1 = ((cs)localObject1).c(400, 400);
              if (localObject1 != null)
              {
                localObject4 = new an.s();
                ((an.s)localObject4).b().a((Bitmap)localObject1);
                if (paramBoolean)
                {
                  ((an.s)localObject4).a(new an.a(2130840164, paramContext.getText(2131297184), paramaus));
                  ((an.s)localObject4).a(new an.a(2130840166, paramContext.getText(2131297186), (PendingIntent)localObject3));
                }
                ((an.d)localObject2).a((an.g)localObject4);
              }
            }
            if (Build.VERSION.SDK_INT >= 21)
            {
              paramContext = new an.d(u.a());
              paramContext.a("call");
              paramContext.d(1);
              paramContext.a(2130840421);
              paramContext.a(u.a().getString(2131298233));
              paramContext.b(String.format(u.a.a(2131230766, localArrayList.size()), new Object[] { Integer.valueOf(localArrayList.size()) }));
              paramContext.e(u.a().getResources().getColor(2131624091));
              ((an.d)localObject2).a(paramContext.e());
            }
            paramContext = new Intent(u.a(), MissedCallNotificationDismissedReceiver.class);
            ((an.d)localObject2).b(PendingIntent.getBroadcast(u.a(), 7, paramContext, 134217728));
            paramContext = new Intent(u.a(), Main.n());
            paramContext.setAction(HomeActivity.u);
            ((an.d)localObject2).a(PendingIntent.getActivity(u.a(), 0, paramContext, 268435456));
            paramContext = ((an.d)localObject2).e();
          }
        }
      }
      try
      {
        aw.a(u.a()).a(7, paramContext);
        WidgetProvider.a(u.a());
        return;
        localObject4 = ((cc.a)localObject4).i();
        m = -1;
        switch (((String)localObject4).hashCode())
        {
        }
        for (;;)
        {
          switch (m)
          {
          default: 
            break;
          case 0: 
            ((an.d)localObject2).c(2);
            break;
            if (((String)localObject4).equals("1"))
            {
              m = 0;
              continue;
              if (((String)localObject4).equals("2"))
              {
                m = 1;
                continue;
                if (((String)localObject4).equals("3"))
                {
                  m = 2;
                  continue;
                  if (((String)localObject4).equals("0")) {
                    m = 3;
                  }
                }
              }
            }
            break;
          }
        }
        ((an.d)localObject2).a(new long[] { 0L, 300L, 200L, 300L, 200L });
        continue;
        ((an.d)localObject2).a(new long[] { 0L, 750L, 250L, 750L, 250L });
        continue;
        label1385:
        this.i.a((Uri)localObject1);
        break label467;
        ((an.d)localObject2).c(4);
        break label467;
        m = 2131297187;
        break label569;
        if (n != 0) {
          m = 2131230766;
        }
        for (;;)
        {
          ((an.d)localObject2).a(String.format(u.a.a(m, localArrayList.size()), new Object[] { Integer.valueOf(localArrayList.size()) }));
          break;
          if (bool) {
            m = 2131230814;
          } else {
            m = 2131230767;
          }
        }
        label1486:
        m = 2131297185;
        break label636;
        label1494:
        paramaus = new Intent(paramContext, VoipActivityV2.class);
        paramaus.putExtra("jid", (String)localObject3);
        paramaus.putExtra("fromCallNotification", true);
        break label718;
        label1528:
        m = 2130840052;
        break label798;
        if (n != 0) {
          m = 2131230766;
        }
        for (;;)
        {
          ((an.d)localObject2).a(String.format(u.a.a(m, localArrayList.size()), new Object[] { Integer.valueOf(localArrayList.size()) }));
          localObject1 = new HashSet();
          localObject3 = new StringBuilder();
          char c1 = al.a(paramaus);
          m = localArrayList.size() - 1;
          while (m >= 0)
          {
            paramaus = (j)localArrayList.get(m);
            if (((HashSet)localObject1).add(paramaus.e.a))
            {
              if (((StringBuilder)localObject3).length() > 0)
              {
                ((StringBuilder)localObject3).append(c1);
                ((StringBuilder)localObject3).append(' ');
              }
              ((StringBuilder)localObject3).append(this.f.d(paramaus.e.a).a(paramContext));
            }
            m -= 1;
          }
          if (bool) {
            m = 2131230814;
          } else {
            m = 2131230767;
          }
        }
        ((an.d)localObject2).b(((StringBuilder)localObject3).toString());
      }
      catch (SecurityException paramContext)
      {
        while (paramContext.toString().contains("android.permission.UPDATE_APP_OPS_STATS")) {}
        throw paramContext;
      }
    }
  }
  
  public final void b()
  {
    d();
    if (!this.a.isEmpty())
    {
      Log.i("missedcallnotification/clear " + this.a.size());
      u.a().getSharedPreferences("com.whatsapp_preferences", 0).edit().remove("first_missed_call").apply();
      this.a.clear();
      aw.a(u.a()).a(7);
      pv localpv = this.c;
      hx localhx = this.k;
      localhx.getClass();
      localpv.a(l.a(localhx));
      WidgetProvider.a(u.a());
    }
  }
  
  public final ConcurrentLinkedQueue<j> c()
  {
    d();
    return this.a;
  }
  
  /* Error */
  final void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 126	com/whatsapp/notification/k:a	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   6: ifnonnull +77 -> 83
    //   9: invokestatic 455	com/whatsapp/u:a	()Landroid/content/Context;
    //   12: ldc_w 569
    //   15: iconst_0
    //   16: invokevirtual 573	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   19: ldc_w 581
    //   22: lconst_0
    //   23: invokeinterface 611 4 0
    //   28: lstore_1
    //   29: lload_1
    //   30: lconst_0
    //   31: lcmp
    //   32: ifle +54 -> 86
    //   35: aload_0
    //   36: aload_0
    //   37: getfield 42	com/whatsapp/notification/k:e	Lcom/whatsapp/data/ad;
    //   40: lload_1
    //   41: invokevirtual 614	com/whatsapp/data/ad:b	(J)Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   44: putfield 126	com/whatsapp/notification/k:a	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   47: new 134	java/lang/StringBuilder
    //   50: dup
    //   51: ldc_w 616
    //   54: invokespecial 139	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: aload_0
    //   58: getfield 126	com/whatsapp/notification/k:a	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   61: invokevirtual 168	java/util/concurrent/ConcurrentLinkedQueue:size	()I
    //   64: invokevirtual 328	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   67: ldc_w 618
    //   70: invokevirtual 333	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: lload_1
    //   74: invokevirtual 621	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   77: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 151	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   83: aload_0
    //   84: monitorexit
    //   85: return
    //   86: aload_0
    //   87: new 128	java/util/concurrent/ConcurrentLinkedQueue
    //   90: dup
    //   91: invokespecial 622	java/util/concurrent/ConcurrentLinkedQueue:<init>	()V
    //   94: putfield 126	com/whatsapp/notification/k:a	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   97: goto -50 -> 47
    //   100: astore_3
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_3
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	k
    //   28	46	1	l	long
    //   100	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	29	100	finally
    //   35	47	100	finally
    //   47	83	100	finally
    //   86	97	100	finally
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/notification/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */