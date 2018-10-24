package com.whatsapp;

import com.whatsapp.data.y;
import com.whatsapp.l.e;
import com.whatsapp.messaging.aj;
import com.whatsapp.protocol.av;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public final class aue
  extends xg
{
  private final String r;
  private final j s;
  private final j t;
  private final aj u;
  
  public aue(pv parampv, va paramva, oz paramoz, aic paramaic, com.whatsapp.data.ad paramad, e parame, aj paramaj, y paramy, vv paramvv, atv paramatv, rh paramrh, j paramj1, j paramj2, String paramString)
  {
    super(parampv, paramva, paramoz, paramaic, paramad, parame, paramy, paramvv, paramatv, paramrh, null, new aoi(Collections.singletonList(paramj2)), true, true);
    this.u = paramaj;
    this.r = paramString;
    this.s = paramj1;
    this.t = paramj2;
    this.m = true;
  }
  
  public final void a(xg.c paramc)
  {
    Log.i("webmediareupload/end " + this.t.e + "current:" + p.size() + " pending:" + q.size() + " result:" + paramc);
    super.a(paramc);
    av localav = new av();
    if ((paramc == xg.c.a) && (this.n)) {
      try
      {
        paramc = new URL(this.o.c);
        if ((paramc.getHost() == null) || (paramc.getHost().length() == 0))
        {
          Log.e("webmediareupload/url/no-host");
          localav.i = 502;
          this.u.a(this.r, localav, 5);
          return;
        }
      }
      catch (Exception paramc)
      {
        Log.w("webmediareupload/url/error " + paramc.toString());
        if (this.o.c == null)
        {
          Log.e("webmediareupload/results/missing keys in upload result");
          localav.i = 502;
          this.u.a(this.r, localav, 5);
          return;
        }
        Log.i("webmediareupload/success " + this.t.e + " " + this.o.c);
        localav.i = 200;
        localav.h = this.o.c;
        paramc = this.s.b();
        MediaData localMediaData = this.t.b();
        if ((paramc == null) || (paramc.mediaKey == null)) {
          localav.w = localMediaData.mediaKey;
        }
        this.s.p = this.o.c;
        this.s.N = localMediaData;
        this.u.a(this.r, localav, 5);
        this.e.e(this.s, -1);
        return;
      }
    }
    localav.i = 502;
    this.u.a(this.r, localav, 5);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */