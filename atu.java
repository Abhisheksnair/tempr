package com.whatsapp;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.content.b;
import com.whatsapp.util.Log;

public class atu
{
  @SuppressLint({"StaticFieldLeak"})
  private static volatile atu a;
  private final Context b;
  private final atv c;
  
  private atu(Context paramContext, atv paramatv)
  {
    this.b = paramContext;
    this.c = paramatv;
  }
  
  public static atu a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new atu(u.a(), atv.a());
      }
      return a;
    }
    finally {}
  }
  
  public final int a(String paramString)
  {
    int i;
    if (Build.VERSION.SDK_INT < 23) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      j = b.a(this.b, paramString);
      Log.d("wa-permission-helper/set-check " + paramString + " " + j);
      i = j;
    } while (j != 0);
    this.c.a(paramString);
    return j;
  }
  
  @TargetApi(16)
  public final boolean b()
  {
    return (a("android.permission.WRITE_EXTERNAL_STORAGE") == 0) && (a("android.permission.READ_EXTERNAL_STORAGE") == 0);
  }
  
  public final boolean b(String paramString)
  {
    return ("mounted".equals(paramString)) && (a("android.permission.WRITE_EXTERNAL_STORAGE") == 0);
  }
  
  public final boolean c()
  {
    return (a("android.permission.ACCESS_COARSE_LOCATION") == 0) || (a("android.permission.ACCESS_FINE_LOCATION") == 0);
  }
  
  public final boolean d()
  {
    return (a("android.permission.READ_CONTACTS") == 0) && (a("android.permission.WRITE_CONTACTS") == 0);
  }
  
  public final boolean e()
  {
    return this.b.checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") == 0;
  }
  
  public final boolean f()
  {
    return this.b.checkCallingOrSelfPermission("android.permission.CAMERA") == 0;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/atu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */