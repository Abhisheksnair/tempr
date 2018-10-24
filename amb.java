package com.whatsapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v7.app.b.a;
import com.whatsapp.j.a.a;
import com.whatsapp.util.Log;
import java.util.Date;

public final class amb
{
  private static final int[] a = ;
  
  private static int a(long paramLong, Date paramDate)
  {
    paramLong = paramDate.getTime() - paramLong;
    Log.d("software/expiration/ms " + paramLong);
    int i = (int)(paramLong / 86400000L) + 1;
    Log.d("software/expiration/days " + i);
    return i;
  }
  
  public static int a(ahc paramahc, atv paramatv)
  {
    long l1 = paramatv.a.getLong("software_expiration_last_warned", 0L);
    long l2 = System.currentTimeMillis();
    if (86400000L + l1 > l2) {
      Log.i("software/expiration/suppress/24h");
    }
    for (;;)
    {
      return -1;
      paramahc = paramahc.d();
      int j = a(l2, paramahc);
      int k = a(l1, paramahc);
      paramahc = a;
      int m = paramahc.length;
      int i = 0;
      while (i < m)
      {
        int n = paramahc[i];
        if ((j <= n) && (k > n))
        {
          paramatv.c().putLong("software_expiration_last_warned", l2).apply();
          return j;
        }
        i += 1;
      }
    }
  }
  
  public static Dialog a(Activity paramActivity, ahc paramahc)
  {
    int i = a(System.currentTimeMillis(), paramahc.d());
    return new b.a(paramActivity).a(2131297869).b(String.format(u.a.a(2131230806, i), new Object[] { Integer.valueOf(i) })).a(2131298072, amc.a(paramActivity)).b(2131296398, amd.a(paramActivity)).a();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/amb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */