package com.whatsapp;

import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.whatsapp.messaging.f.d;
import com.whatsapp.messaging.m;
import com.whatsapp.util.Log;

public class abv
{
  public static volatile abv a;
  boolean b;
  private final m c;
  private final and d;
  private final abu e;
  
  private abv(m paramm, and paramand, abu paramabu)
  {
    this.c = paramm;
    this.d = paramand;
    this.e = paramabu;
  }
  
  public static abv a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new abv(m.a(), and.a(), abu.a());
      }
      return a;
    }
    finally {}
  }
  
  final void b()
  {
    this.b = true;
    c();
  }
  
  final void c()
  {
    Log.d("app/send/active device: " + this.b + " web: " + auj.j());
    if (((this.c.d) && (this.b) && (!auj.j())) || ((auj.j()) && (!this.b)))
    {
      m localm = this.c;
      localm.i.a("session active");
      localm.a.b();
      localm.i();
      localm.g();
      localm.a(true, false, false, false, null, null, null, null);
      localm.a.e();
    }
  }
  
  final void d()
  {
    this.b = false;
    e();
  }
  
  final void e()
  {
    Log.d("app/send/inactive device: " + this.b + " web: " + auj.j());
    Object localObject;
    if ((this.c.d) && (!this.b) && (!auj.j()))
    {
      localObject = this.d.a;
      if (localObject != null) {
        break label104;
      }
      Log.w("app/send/inactive pm=null");
    }
    for (;;)
    {
      localObject = this.c;
      ((m)localObject).i.a("session inactive");
      ((m)localObject).a.a();
      this.e.b();
      return;
      label104:
      localObject = ((PowerManager)localObject).newWakeLock(1, "sendinactive");
      if (localObject != null)
      {
        ((PowerManager.WakeLock)localObject).acquire(3000L);
        Log.i("app/sendinactive/wl");
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/abv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */