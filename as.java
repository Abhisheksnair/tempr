package com.whatsapp;

import android.app.Activity;
import android.content.Context;
import com.whatsapp.protocol.aw;
import com.whatsapp.protocol.x;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public final class as
  implements x, Runnable
{
  public static HashMap<String, as> a = new HashMap();
  private static Timer j = new Timer();
  public String b;
  public Activity c;
  public Long d;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  public Map<String, String> h;
  public aw i;
  private a k;
  private final pv l;
  private final aq m;
  private final dh n;
  private Runnable o = new Runnable()
  {
    public final void run()
    {
      if (as.this.i == null)
      {
        as.a(as.this).d((ng)as.this.c);
        pv localpv;
        Context localContext;
        if (!as.this.c.isFinishing())
        {
          localpv = as.a(as.this);
          localContext = u.a();
          if (!as.this.e) {
            break label79;
          }
        }
        label79:
        for (int i = 2131296355;; i = 2131298058)
        {
          localpv.a(null, localContext.getString(i));
          return;
        }
      }
      auj.b(as.this.i.a, 500);
    }
  };
  private Runnable p = new Runnable()
  {
    public final void run()
    {
      if (as.this.i == null) {
        as.a(as.this).d((ng)as.this.c);
      }
      if (as.this.g)
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add(as.this.b);
        as.b(as.this).a((Collection)localObject);
      }
      while (as.this.i != null) {
        return;
      }
      Object localObject = as.a(as.this);
      Context localContext = u.a();
      if (as.this.e) {}
      for (int i = 2131296355;; i = 2131298058)
      {
        ((pv)localObject).a(null, localContext.getString(i));
        return;
      }
    }
  };
  
  public as(Activity paramActivity, pv parampv, aq paramaq, dh paramdh, String paramString, Map<String, String> paramMap, boolean paramBoolean, aw paramaw)
  {
    this.c = paramActivity;
    this.l = parampv;
    this.m = paramaq;
    this.n = paramdh;
    this.b = paramString;
    this.e = paramBoolean;
    this.h = paramMap;
    this.i = paramaw;
    if (paramString == null)
    {
      this.d = Long.valueOf(System.currentTimeMillis());
      a.put(this.d, this);
    }
    for (;;)
    {
      this.k = new a(this, parampv);
      j.schedule(this.k, 20000L);
      return;
      a.put(paramString, this);
    }
  }
  
  private void a()
  {
    if (this.b == null) {}
    for (as localas = (as)a.remove(this.d);; localas = (as)a.remove(this.b))
    {
      if (localas != null) {
        localas.k.cancel();
      }
      return;
    }
  }
  
  public final void a(int paramInt)
  {
    Log.i("general_request_failed : " + paramInt + " | " + this.b);
    a();
    this.l.a(this.p);
    if (this.i != null) {
      auj.b(this.i.a, paramInt);
    }
  }
  
  public final void run()
  {
    Log.i("general_request_success/");
    this.g = true;
    if (this.e) {
      this.m.b(this.b);
    }
    for (;;)
    {
      a();
      this.l.a(this.p);
      if (this.i != null) {
        auj.b(this.i.a, 200);
      }
      return;
      this.m.c(this.b);
    }
  }
  
  static final class a
    extends TimerTask
  {
    private final as a;
    private final pv b;
    
    public a(as paramas, pv parampv)
    {
      this.a = paramas;
      this.b = parampv;
    }
    
    public final void run()
    {
      if (this.a.g) {
        return;
      }
      Log.i("general_request_timeout/type:");
      this.a.f = true;
      this.b.a(as.c(this.a));
      as.a.remove(this.a.b);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */