package com.whatsapp;

import android.content.Context;
import android.os.SystemClock;
import android.text.format.DateUtils;
import com.whatsapp.util.Log;
import java.util.Date;

public final class ant
{
  private static final ant e = new ant();
  public long a;
  public long b;
  public long c;
  public long d;
  
  public static ant a()
  {
    return e;
  }
  
  public final long a(long paramLong)
  {
    return System.currentTimeMillis() + paramLong - b();
  }
  
  public final long a(Context paramContext, long paramLong1, long paramLong2)
  {
    Log.i("app/time server:" + paramLong1 + " client:" + paramLong2 + " current-client:" + DateUtils.formatDateTime(paramContext, System.currentTimeMillis(), 17) + " current-client:" + java.text.DateFormat.getDateTimeInstance().format(new Date(System.currentTimeMillis())) + " current-client:" + android.text.format.DateFormat.getDateFormat(paramContext).format(new Date(System.currentTimeMillis())) + " " + android.text.format.DateFormat.getTimeFormat(paramContext).format(new Date(System.currentTimeMillis())) + " current-server:" + DateUtils.formatDateTime(paramContext, a(b()), 17));
    this.a = paramLong1;
    this.b = paramLong2;
    this.d = (paramLong2 - paramLong1);
    this.c = SystemClock.elapsedRealtime();
    return this.d;
  }
  
  public final long a(com.whatsapp.protocol.j paramj)
  {
    return a(paramj.n);
  }
  
  public final long b()
  {
    if (this.a != 0L) {
      return this.a + (SystemClock.elapsedRealtime() - this.c);
    }
    return System.currentTimeMillis() - this.d;
  }
  
  public final void onEvent(com.whatsapp.g.j paramj)
  {
    long l1 = System.currentTimeMillis();
    long l2 = paramj.a();
    Log.i("ntp update processed; device time: " + new Date(l1) + " ntp time: " + new Date(l2));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */