package com.whatsapp.util;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.whatsapp.pv;
import com.whatsapp.u;

public class h
{
  private static volatile h a;
  private AudioManager.OnAudioFocusChangeListener b;
  private long c;
  private final Context d;
  private final pv e;
  
  private h(Context paramContext, pv parampv)
  {
    this.d = paramContext;
    this.e = parampv;
  }
  
  public static h a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new h(u.a(), pv.a());
      }
      return a;
    }
    finally {}
  }
  
  private AudioManager.OnAudioFocusChangeListener c()
  {
    if (this.b == null) {
      this.b = i.a();
    }
    return this.b;
  }
  
  public final void a(Context paramContext)
  {
    ((AudioManager)paramContext.getSystemService("audio")).requestAudioFocus(c(), 3, 2);
  }
  
  public final void b(Context paramContext)
  {
    ((AudioManager)paramContext.getSystemService("audio")).abandonAudioFocus(c());
  }
  
  public final boolean b()
  {
    if (((AudioManager)this.d.getSystemService("audio")).getStreamVolume(3) == 0)
    {
      if (System.currentTimeMillis() - this.c > 2000L)
      {
        this.c = System.currentTimeMillis();
        pv.a(this.d, 2131297475, 0);
      }
      return false;
    }
    return true;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */