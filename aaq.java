package com.whatsapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Messenger;
import com.whatsapp.messaging.w;

public class aaq
{
  private static volatile aaq f;
  boolean a;
  final Context b;
  final va c;
  final dh d;
  public final Handler e = new Handler(aar.a());
  private String g;
  private final pv h;
  private final w i;
  private final atv j;
  
  private aaq(Context paramContext, pv parampv, va paramva, w paramw, dh paramdh, atv paramatv)
  {
    this.b = paramContext;
    this.h = parampv;
    this.c = paramva;
    this.i = paramw;
    this.d = paramdh;
    this.j = paramatv;
  }
  
  public static aaq a()
  {
    if (f == null) {}
    try
    {
      if (f == null) {
        f = new aaq(u.a(), pv.a(), va.a(), w.a(), dh.a(), atv.a());
      }
      return f;
    }
    finally {}
  }
  
  public final void a(String paramString)
  {
    this.g = paramString;
    this.a = false;
    this.j.b(this.g);
    this.d.e(this.c.b() + "@s.whatsapp.net");
  }
  
  public final void b()
  {
    this.a = false;
    this.g = null;
    this.j.b(null);
  }
  
  public final String c()
  {
    if (this.g == null)
    {
      if (!this.a)
      {
        this.i.a(this.c.b() + "@s.whatsapp.net", 0L, new Messenger(new Handler(aas.a(this))));
        this.a = true;
      }
      String str = this.j.a.getString("my_current_status", null);
      if (str != null) {
        return str;
      }
      return this.b.getString(2131297046);
    }
    return this.g;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aaq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */