package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.content.Context;
import android.os.SystemClock;
import com.whatsapp.fieldstats.e;
import com.whatsapp.fieldstats.events.bm;
import com.whatsapp.fieldstats.events.bn;
import com.whatsapp.fieldstats.events.bq;
import com.whatsapp.fieldstats.l;
import com.whatsapp.protocol.j;
import java.util.Random;

public class amt
{
  private static volatile amt d;
  private static final Random e = new Random();
  final ant a;
  public final Context b;
  public a c;
  
  private amt(Context paramContext, ant paramant)
  {
    this.a = paramant;
    this.b = paramContext;
  }
  
  public static amt a()
  {
    if (d == null) {}
    try
    {
      if (d == null) {
        d = new amt(u.a(), ant.a());
      }
      return d;
    }
    finally {}
  }
  
  public static int c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 3;
    case 1: 
    case 3: 
      return 1;
    }
    return 2;
  }
  
  public final void a(int paramInt)
  {
    a.d.a(b(), "Report tab open only once per session");
    bq localbq = new bq();
    localbq.a = Long.valueOf(c());
    localbq.b = Long.valueOf(paramInt);
    l.a(this.b, localbq);
    this.c.c = true;
  }
  
  public final void a(j paramj, int paramInt1, int paramInt2)
  {
    bm localbm = new bm();
    localbm.a = Long.valueOf(c());
    localbm.b = Integer.valueOf(d.a(paramj));
    localbm.c = Long.valueOf(paramInt1);
    switch (paramj.o)
    {
    default: 
      paramInt1 = 4;
    }
    for (;;)
    {
      localbm.e = Integer.valueOf(paramInt1);
      localbm.d = Integer.valueOf(paramInt2);
      l.a(this.b, localbm);
      return;
      paramInt1 = 2;
      continue;
      paramInt1 = 1;
      continue;
      paramInt1 = 3;
    }
  }
  
  public final void b(int paramInt)
  {
    Object localObject = new bn();
    ((bn)localObject).a = Long.valueOf(c());
    ((bn)localObject).b = Integer.valueOf(paramInt);
    l.a(this.b, (e)localObject);
    if (this.c != null)
    {
      localObject = this.c;
      ((a)localObject).e += 1;
    }
  }
  
  public final boolean b()
  {
    return (this.c != null) && (!this.c.c);
  }
  
  public final long c()
  {
    if (this.c == null) {
      return 0L;
    }
    return this.c.a;
  }
  
  public static final class a
  {
    final long a = amt.d().nextLong();
    final long b = SystemClock.elapsedRealtime();
    boolean c;
    public int d;
    int e;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/amt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */