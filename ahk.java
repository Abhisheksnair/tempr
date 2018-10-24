package com.whatsapp;

import a.a.a.a.a.a.d;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.PowerManager;
import b.a.a.c;
import com.whatsapp.g.l;
import com.whatsapp.util.Log;
import com.whatsapp.util.a;

public final class ahk
  extends BroadcastReceiver
{
  private static ahk a = new ahk();
  private static boolean b;
  
  public static void a(Context paramContext, and paramand)
  {
    if (!c(paramContext, paramand)) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      c.a().c(new l(b));
      paramand = new IntentFilter();
      paramand.addAction("android.intent.action.SCREEN_OFF");
      paramand.addAction("android.intent.action.SCREEN_ON");
      paramand.addAction("android.intent.action.USER_PRESENT");
      paramContext.registerReceiver(a, paramand);
      return;
    }
  }
  
  public static void b(Context paramContext, and paramand)
  {
    
    if (!b) {
      return;
    }
    if (!c(paramContext, paramand)) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      Log.i("ScreenLockReceiver manual check; locked=" + b);
      if (b) {
        break;
      }
      c.a().c(new l(b));
      return;
    }
  }
  
  private static boolean c(Context paramContext, and paramand)
  {
    paramand = paramand.a;
    paramContext = (KeyguardManager)paramContext.getSystemService("keyguard");
    return (paramand != null) && (paramand.isScreenOn()) && ((a.c()) || ((!r.s()) && (Build.VERSION.SDK_INT >= 16) && (!paramContext.isKeyguardLocked())) || (!paramContext.inKeyguardRestrictedInputMode()));
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool1 = true;
    and localand = and.a();
    boolean bool2 = b;
    String str2 = paramIntent.getAction();
    String str1 = "unknown";
    paramIntent = str1;
    int i;
    if (str2 != null) {
      i = -1;
    }
    switch (str2.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        paramIntent = str1;
        label103:
        if (c(paramContext, localand)) {}
        break;
      }
      break;
    }
    for (;;)
    {
      b = bool1;
      Log.i("ScreenLockReceiver; tag=" + paramIntent + "; locked=" + b + "; oldLocked=" + bool2);
      if (b != bool2) {
        c.a().c(new l(b));
      }
      return;
      if (!str2.equals("android.intent.action.SCREEN_ON")) {
        break;
      }
      i = 0;
      break;
      if (!str2.equals("android.intent.action.SCREEN_OFF")) {
        break;
      }
      i = 1;
      break;
      if (!str2.equals("android.intent.action.USER_PRESENT")) {
        break;
      }
      i = 2;
      break;
      paramIntent = "on";
      break label103;
      paramIntent = "off";
      break label103;
      paramIntent = "unlock";
      break label103;
      bool1 = false;
    }
  }
  
  public final String toString()
  {
    return "ScreenLockReceiver{locked=" + b + '}';
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ahk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */