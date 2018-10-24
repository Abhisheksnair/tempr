package com.whatsapp.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import java.lang.reflect.Method;

public final class a
{
  public static final boolean a;
  
  static
  {
    if ((Build.VERSION.SDK_INT == 24) || (Build.VERSION.SDK_INT == 25)) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public static void a(Context paramContext)
  {
    if (("samsung".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT >= 19) && (Build.VERSION.SDK_INT <= 22)) {}
    try
    {
      Method localMethod = Class.forName("android.sec.clipboard.ClipboardUIManager").getDeclaredMethod("getInstance", new Class[] { Context.class });
      localMethod.setAccessible(true);
      localMethod.invoke(null, new Object[] { paramContext });
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT == 15;
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT < 11;
  }
  
  public static boolean c()
  {
    return "xiaomi".equalsIgnoreCase(Build.MANUFACTURER);
  }
  
  public static boolean d()
  {
    return Build.VERSION.SDK_INT == 23;
  }
  
  public static boolean e()
  {
    if ((Build.MANUFACTURER.equalsIgnoreCase("samsung")) && ((Build.BOARD.equalsIgnoreCase("MSM8960")) || (Build.BOARD.equalsIgnoreCase("universal7580")) || (Build.DEVICE.equalsIgnoreCase("xcover3lte")) || (Build.DEVICE.equalsIgnoreCase("ks01lte")))) {}
    while ((Build.BOARD.equalsIgnoreCase("7x27")) || (Build.DEVICE.startsWith("hwY")) || (Build.DEVICE.startsWith("hwG"))) {
      return true;
    }
    return false;
  }
  
  public static boolean f()
  {
    return (Build.VERSION.RELEASE.equals("5.0.1")) && ((Build.DEVICE.equalsIgnoreCase("jflte")) || (Build.DEVICE.equalsIgnoreCase("jfvelte")));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */