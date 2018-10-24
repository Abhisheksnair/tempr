package com.whatsapp.gif_search;

import a.a.a.a.a.a.d;
import com.whatsapp.aic;
import com.whatsapp.ant;
import com.whatsapp.aus;
import com.whatsapp.fieldstats.e;
import com.whatsapp.fieldstats.events.af;
import com.whatsapp.fieldstats.l;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public abstract class p
{
  private static p c;
  public final ant a;
  public final aus b;
  private long d = -1L;
  private WeakReference<r> e = null;
  
  public p(ant paramant, aus paramaus)
  {
    this.a = paramant;
    this.b = paramaus;
  }
  
  public static p a()
  {
    for (;;)
    {
      try
      {
        if (c == null) {}
        switch (aic.I)
        {
        case 1: 
          Log.e("Unexpected value of gif_provider server prop " + aic.I);
          c = new com.whatsapp.gif_search.b.a((ant)a.d.a(ant.a()), (aus)a.d.a(aus.a()));
          p localp = c;
          return localp;
        }
      }
      finally {}
      c = new com.whatsapp.gif_search.a.a((ant)a.d.a(ant.a()), (aus)a.d.a(aus.a()));
      continue;
      c = new com.whatsapp.gif_search.b.a((ant)a.d.a(ant.a()), (aus)a.d.a(aus.a()));
    }
  }
  
  public abstract r a(CharSequence paramCharSequence);
  
  public final r b()
  {
    a.d.b();
    Object localObject = new af();
    ((af)localObject).a = Integer.valueOf(e());
    l.a(u.a(), (e)localObject);
    if (this.e != null)
    {
      localObject = (r)this.e.get();
      if ((localObject != null) && (this.a.b() - this.d < TimeUnit.HOURS.toMillis(4L)) && (!((r)localObject).d)) {
        return (r)localObject;
      }
    }
    localObject = c();
    this.e = new WeakReference(localObject);
    this.d = this.a.b();
    return (r)localObject;
  }
  
  public abstract r c();
  
  public abstract String d();
  
  public abstract int e();
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gif_search/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */