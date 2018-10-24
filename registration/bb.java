package com.whatsapp.registration;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.whatsapp.atv;
import com.whatsapp.util.Log;

public class bb
{
  private static volatile bb a;
  private final atv b;
  private final bk c;
  
  private bb(atv paramatv, bk parambk)
  {
    this.b = paramatv;
    this.c = parambk;
  }
  
  public static bb a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new bb(atv.a(), bk.a());
      }
      return a;
    }
    finally {}
  }
  
  public final void a(int paramInt)
  {
    if (this.b.j(-1) != paramInt)
    {
      bk localbk = this.c;
      localbk.a = null;
      localbk.b = false;
      localbk.c = false;
      localbk.d = false;
      localbk.e = false;
      localbk.f = false;
      localbk.g = false;
      localbk.h = true;
      this.b.a(null);
    }
    this.b.a.edit().putInt("registration_state", paramInt).apply();
    Log.d("registrationmanager/setregstate " + paramInt);
  }
  
  public final boolean b()
  {
    return c() == 3;
  }
  
  public final int c()
  {
    int i = this.b.j(0);
    Log.d("registrationmanager/getregstate " + i);
    return i;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/registration/bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */