package com.whatsapp.notification;

import a.a.a.a.a.a.d;
import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.an.a.a;
import android.support.v4.app.an.c;
import android.support.v4.app.an.d;
import android.support.v4.app.an.s;
import android.support.v4.app.ay;
import android.support.v4.app.ay.a;
import android.text.TextUtils;
import com.google.android.gms.common.api.b.a;
import com.google.android.gms.wearable.g;
import com.google.android.gms.wearable.g.a;
import com.google.android.gms.wearable.h;
import com.whatsapp.and;
import com.whatsapp.anv;
import com.whatsapp.aoj;
import com.whatsapp.data.ad;
import com.whatsapp.data.ad.e;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.data.l;
import com.whatsapp.gdrive.ch;
import com.whatsapp.ka;
import com.whatsapp.lt;
import com.whatsapp.protocol.j;
import com.whatsapp.pv;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.be;
import java.util.List;

public final class AndroidWear
  extends IntentService
{
  private static com.google.android.gms.common.api.b e = null;
  final aoj a = aoj.a();
  final ad b = ad.a();
  final f c = f.a();
  final ka d = ka.a();
  private final pv f = pv.a();
  private final anv g = anv.a();
  private final e h = e.a();
  private final and i = and.a();
  private final lt j = lt.a();
  
  public AndroidWear()
  {
    super("AndroidWear");
  }
  
  private static Notification a(Context paramContext, ad paramad, l paraml, m paramm, cs paramcs)
  {
    Object localObject1 = "";
    ad.e locale = paramad.a(paramcs.t, 1L, 20);
    Object localObject2 = localObject1;
    if (locale.b != null) {
      localObject2 = localObject1;
    }
    try
    {
      if (locale.b.moveToLast())
      {
        if (paramad.d(paramcs.t, locale.a)) {
          localObject1 = TextUtils.concat(new CharSequence[] { "", "…" });
        }
        boolean bool;
        do
        {
          localObject2 = paramm.a(paraml.a(locale.b, paramcs.t), paramcs, false, true);
          paramad = (ad)localObject1;
          if (localObject2 != "")
          {
            paramad = (ad)localObject1;
            if (localObject1 != "") {
              paramad = TextUtils.concat(new CharSequence[] { localObject1, "\n\n" });
            }
            paramad = TextUtils.concat(new CharSequence[] { paramad, localObject2 });
          }
          bool = locale.b.moveToPrevious();
          localObject1 = paramad;
        } while (bool);
        localObject2 = paramad;
      }
      return new an.d(paramContext).a(new an.c().b((CharSequence)localObject2)).a(new an.s().a()).e();
    }
    finally
    {
      locale.b.close();
    }
  }
  
  public static PendingIntent a(Context paramContext, cs paramcs)
  {
    return PendingIntent.getService(paramContext, 0, new Intent(null, paramcs.o(), paramContext, AndroidWear.class), 0);
  }
  
  public static an.s a(Context paramContext, ad paramad, l paraml, m paramm, cs paramcs, boolean paramBoolean1, j paramj, boolean paramBoolean2, Bitmap paramBitmap, boolean paramBoolean3)
  {
    an.s locals = new an.s();
    if ((paramBoolean1) && (paramj != null) && (paramj.s == 1) && (paramj.N != null)) {
      locals.a(new an.s().c().a(new an.d(paramContext)).e());
    }
    if (paramBoolean3) {
      locals.a(a(paramContext, paramad, paraml, paramm, paramcs));
    }
    paramad = b(paramContext, paramcs);
    paramContext = a(paramContext, paramcs);
    locals.a(new an.a.a(2130840167, paramad.b(), paramContext).a(paramad).a());
    if (paramBoolean2) {
      locals.a(paramBitmap);
    }
    return locals;
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 18;
  }
  
  public static ay b(Context paramContext, cs paramcs)
  {
    paramcs = paramContext.getString(2131297610, new Object[] { paramcs.a(paramContext) });
    paramContext = paramContext.getResources().getStringArray(2131689472);
    return new ay.a("android_wear_voice_input").a(paramcs).a(paramContext).a();
  }
  
  public static boolean b()
  {
    
    try
    {
      if (a())
      {
        if (!ch.c()) {
          return false;
        }
        if (e == null)
        {
          com.google.android.gms.common.api.b localb = new b.a(u.a()).a(h.l).b();
          e = localb;
          localb.e();
        }
        if ((e != null) && (e.i()))
        {
          int k = ((g.a)h.d.a(e).a()).b().size();
          if (k > 0) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      localException = localException;
      Log.d("androidwear/pairedcheck/failed", localException);
      return true;
    }
    finally {}
  }
  
  public static PendingIntent c(Context paramContext, cs paramcs)
  {
    return PendingIntent.getService(paramContext, 0, new Intent("MARK_READ", paramcs.o(), paramContext, AndroidWear.class), 0);
  }
  
  protected final void onHandleIntent(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      return;
      if (!this.g.e())
      {
        Log.i("androidwear/tosupdate/not allowed");
        return;
      }
      Bundle localBundle = ay.a(paramIntent);
      if (localBundle != null)
      {
        cs localcs = this.h.a(paramIntent.getData());
        paramIntent = localBundle.getCharSequence("android_wear_voice_input");
        if (paramIntent != null) {}
        for (paramIntent = paramIntent.toString().trim(); !be.b(this, this.i, paramIntent); paramIntent = null)
        {
          Log.i("androidwear/voiceinputfromandroidwear/message is empty");
          this.f.a(a.a(this));
          return;
        }
        this.f.a(b.a(this, localcs, paramIntent));
        return;
      }
    } while (!"MARK_READ".equals(paramIntent.getAction()));
    paramIntent = this.h.a(paramIntent.getData());
    this.f.a(c.a(this, paramIntent));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/notification/AndroidWear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */