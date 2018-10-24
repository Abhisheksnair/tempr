package com.whatsapp;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.whatsapp.messaging.CaptivePortalActivity.a;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import java.util.List;

public class pd
{
  @SuppressLint({"StaticFieldLeak"})
  public static volatile pd a;
  final Context b;
  final aj c;
  public final Handler d = new Handler(Looper.getMainLooper(), pe.a(this));
  private final and e;
  private final pc f;
  private final auu g;
  private final abv h;
  
  private pd(Context paramContext, and paramand, pc parampc, auu paramauu, abv paramabv)
  {
    this.b = paramContext;
    this.e = paramand;
    this.f = parampc;
    this.g = paramauu;
    this.h = paramabv;
    this.c = new aj();
  }
  
  public static pd a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new pd(u.a(), and.a(), pc.a(), auu.a(), abv.a());
      }
      return a;
    }
    finally {}
  }
  
  public final void a(boolean paramBoolean)
  {
    ahk.b(this.b, this.e);
    if (!this.f.d())
    {
      if (!this.f.c()) {
        break label78;
      }
      aj.a(this.b);
      this.f.b = 1;
    }
    for (;;)
    {
      Log.i("foregroundstatemanager/setinforeground/foreground " + this.f + " always:" + paramBoolean);
      return;
      label78:
      if (paramBoolean)
      {
        this.f.b = 1;
        if (!this.g.b) {
          this.h.b();
        }
        if (!this.g.a) {
          bu.a(new CaptivePortalActivity.a(this.b), new Void[0]);
        }
      }
    }
  }
  
  public final void b()
  {
    Object localObject;
    long l;
    PendingIntent localPendingIntent;
    if (this.f.d())
    {
      this.f.b = 2;
      localObject = this.b;
      l = SystemClock.elapsedRealtime() + 15000L;
      localPendingIntent = PendingIntent.getBroadcast((Context)localObject, 0, aj.a(), 0);
      localObject = (AlarmManager)((Context)localObject).getSystemService("alarm");
      if (Build.VERSION.SDK_INT < 23) {
        break label94;
      }
      ((AlarmManager)localObject).setExactAndAllowWhileIdle(2, l, localPendingIntent);
    }
    for (;;)
    {
      Log.i("foregroundstatemanager/setinbackground/foreground " + this.f);
      return;
      label94:
      if (Build.VERSION.SDK_INT >= 19) {
        ((AlarmManager)localObject).setExact(2, l, localPendingIntent);
      } else {
        ((AlarmManager)localObject).set(2, l, localPendingIntent);
      }
    }
  }
  
  public final void c()
  {
    aj.a(this.b);
    Log.i("foregroundstatemanager/set-in-background foreground: " + this.f);
    this.f.b = 3;
  }
  
  public final boolean d()
  {
    Object localObject = this.e.b;
    if (localObject == null)
    {
      Log.d("foregroundstatemanager/is_app_in_foreground activity manager is null");
      return false;
    }
    try
    {
      localObject = ((ActivityManager)localObject).getRunningTasks(1);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        Log.d("foregroundstatemanager/is_app_in_foreground list is " + localObject + " baseActivity: " + ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).baseActivity + " foregroundState: " + this.f);
        boolean bool = ((ActivityManager.RunningTaskInfo)((List)localObject).get(0)).baseActivity.toString().contains("com.whatsapp");
        return bool;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      Log.d("foregroundstatemanager/is_app_in_foreground " + localNullPointerException);
      Log.d(localNullPointerException);
    }
    return this.f.d();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/pd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */