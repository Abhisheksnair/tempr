package com.whatsapp;

import android.os.AsyncTask;
import com.whatsapp.data.ad;
import com.whatsapp.messaging.w;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.m;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.bu;

public class aob
{
  private static volatile aob a;
  private AsyncTask<Void, Void, Void> b;
  private final pv c;
  private final ahx d;
  private final oz e;
  private final w f;
  private final aoj g;
  private final ad h;
  private final abp i;
  private final aat j;
  
  private aob(pv parampv, ahx paramahx, oz paramoz, w paramw, aoj paramaoj, ad paramad, abp paramabp, aat paramaat)
  {
    this.c = parampv;
    this.d = paramahx;
    this.e = paramoz;
    this.f = paramw;
    this.g = paramaoj;
    this.h = paramad;
    this.i = paramabp;
    this.j = paramaat;
  }
  
  public static aob a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aob(pv.a(), ahx.a(), oz.a(), w.a(), aoj.a(), ad.a(), abp.a(), aat.a());
      }
      return a;
    }
    finally {}
  }
  
  public final boolean a(j paramj)
  {
    if ((paramj.d == 7) && (paramj.e.a.contains("-"))) {
      return false;
    }
    switch (paramj.s)
    {
    }
    while ((m.a(paramj.s)) && (MediaFileUtils.a(this.e, paramj)))
    {
      Log.i("app/unsent/skip " + paramj.e.c + " " + paramj.s + " need transcode");
      return false;
      if ((paramj.B == 0.0D) && (paramj.C == 0.0D))
      {
        Log.i("app/unsent/skip/location " + paramj.e.c);
        return false;
        MediaData localMediaData = paramj.b();
        if ((localMediaData != null) && (!localMediaData.autodownloadRetryEnabled))
        {
          Log.i("app/unsent/skip " + paramj.e.c + " " + paramj.s + " autoretry disabled");
          return false;
          localMediaData = paramj.b();
          if ((localMediaData != null) && (!localMediaData.autodownloadRetryEnabled))
          {
            Log.i("app/unsent/skip " + paramj.e.c + " " + paramj.s + " autoretry disabled");
            return false;
            Log.i("app/unsent/skip/call " + paramj.e.c);
            return false;
            Log.i("app/unsent/skip/system " + paramj.e.c);
            return false;
          }
        }
      }
    }
    return true;
  }
  
  public final void b()
  {
    Log.d("app/sendunsent");
    if (this.b != null) {
      this.b.cancel(true);
    }
    this.b = new AsyncTask() {};
    bu.a(this.b, new Void[0]);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */