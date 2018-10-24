package com.whatsapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.aw;
import android.text.TextUtils;
import com.whatsapp.util.Log;
import java.util.Date;

public class ahc
{
  private static volatile ahc c;
  Date a;
  public boolean b;
  private final va d;
  
  private ahc(va paramva)
  {
    this.d = paramva;
  }
  
  public static ahc a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new ahc(va.a());
      }
      return c;
    }
    finally {}
  }
  
  public static boolean e()
  {
    return ("chromium".equals(Build.MANUFACTURER)) && ("chromium".equals(Build.BRAND));
  }
  
  public final boolean b()
  {
    boolean bool1 = true;
    if (this.a != null) {}
    Date localDate;
    boolean bool2;
    do
    {
      return bool1;
      localDate = new Date();
      if (localDate.before(new Date(1497369334871L)))
      {
        this.a = localDate;
        return true;
      }
      bool2 = localDate.after(new Date(d().getTime() + 31536000000L));
      bool1 = bool2;
    } while (!bool2);
    this.a = localDate;
    return bool2;
  }
  
  public final boolean c()
  {
    if (this.b) {
      return true;
    }
    this.b = new Date().after(d());
    return this.b;
  }
  
  public final Date d()
  {
    localObject = this.d.b;
    j = -1;
    i = j;
    if (localObject != null) {
      i = j;
    }
    try
    {
      if (!TextUtils.isEmpty(((Me)localObject).number))
      {
        l = Long.valueOf(((Me)localObject).number).longValue();
        i = (int)(l % 14L);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        Date localDate;
        StringBuilder localStringBuilder;
        Log.w("number format not valid: " + ((Me)localObject).number);
        i = j;
        continue;
        long l = 0L;
        continue;
        localObject = null;
      }
    }
    if ((av.e()) && (i >= 0) && (i <= 13))
    {
      l = i - 6;
      localDate = new Date((l + 45L) * 86400000L + 1497542134871L);
      localStringBuilder = new StringBuilder("software/expiration/date ").append(localDate).append(" bucket: ").append(i).append(" number: ");
      if (localObject == null) {
        break label187;
      }
      localObject = ((Me)localObject).number;
      Log.d((String)localObject);
      return localDate;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ahc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */