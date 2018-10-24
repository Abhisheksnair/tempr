package com.whatsapp.l;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class g
{
  final String a;
  final long b;
  public final List<d> c;
  
  public g(String paramString, long paramLong, List<d> paramList)
  {
    this.a = paramString;
    this.b = (1000L * paramLong + SystemClock.elapsedRealtime());
    this.c = Collections.unmodifiableList(new ArrayList(paramList));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/l/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */