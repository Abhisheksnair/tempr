package com.whatsapp;

import android.os.Message;
import com.whatsapp.data.ad;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.messaging.m;
import com.whatsapp.protocol.aw;
import com.whatsapp.util.Log;
import com.whatsapp.util.w;
import com.whatsapp.util.w.a;

public class acm
{
  private static volatile acm g;
  final pv a;
  final e b;
  final m c;
  final dh d;
  final w e;
  final sr f;
  private long h;
  private final ant i;
  private final va j;
  private final ad k;
  private final mf l;
  
  private acm(ant paramant, pv parampv, va paramva, ad paramad, e parame, m paramm, mf parammf, dh paramdh, w paramw, sr paramsr)
  {
    this.i = paramant;
    this.a = parampv;
    this.j = paramva;
    this.k = paramad;
    this.b = parame;
    this.c = paramm;
    this.l = parammf;
    this.d = paramdh;
    this.e = paramw;
    this.f = paramsr;
  }
  
  public static acm a()
  {
    if (g == null) {}
    try
    {
      if (g == null) {
        g = new acm(ant.a(), pv.a(), va.a(), ad.a(), e.a(), m.a(), mf.a(), dh.a(), w.a(), sr.a());
      }
      return g;
    }
    finally {}
  }
  
  private boolean b()
  {
    return this.h < System.currentTimeMillis();
  }
  
  public final ach a(rh paramrh, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new ach(this.i, this.a, this.j, this.k, this.b, this.d, this, paramrh, paramString, paramArrayOfByte1, paramArrayOfByte2, null);
  }
  
  public final ach a(rh paramrh, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, aw paramaw)
  {
    return new ach(this.i, this.a, this.j, this.k, this.b, this.d, this, paramrh, paramString, paramArrayOfByte1, paramArrayOfByte2, paramaw);
  }
  
  public final void a(ach paramach)
  {
    if ((this.c.d) && (b()))
    {
      Log.w("app/sendSetProfilePhoto");
      this.c.a(Message.obtain(null, 0, 25, 0, paramach));
    }
  }
  
  public final void a(String paramString)
  {
    this.l.a(acn.a(this, paramString));
  }
  
  public final void a(String paramString, int paramInt)
  {
    if ((paramInt == 500) || (paramInt == 501) || (paramInt == 503)) {
      this.h = (System.currentTimeMillis() + 3600000L);
    }
    while ((paramInt != 401) || (paramString == null) || (qz.e(paramString))) {
      return;
    }
    a(paramString);
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2)
  {
    int m = 1;
    if (cs.e(paramString)) {}
    for (;;)
    {
      return;
      if (paramString == null)
      {
        if (av.f()) {
          throw new NullPointerException("jid must not be null");
        }
      }
      else if ((paramString.length() == 0) || ("@s.whatsapp.net".equals(paramString)))
      {
        if (av.f()) {
          throw new IllegalArgumentException("jid must not be empty");
        }
      }
      else if (b())
      {
        w localw = this.e;
        if (((paramInt2 & 0x1) != 0) && (localw.b.a(paramString))) {}
        while (m != 0)
        {
          this.a.a(aco.a(this, paramInt1, paramInt2, paramString));
          return;
          if (((paramInt2 & 0x2) == 0) || (!localw.c.a(paramString))) {
            m = 0;
          }
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/acm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */