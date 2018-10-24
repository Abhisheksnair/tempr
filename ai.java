package com.whatsapp;

import android.text.TextUtils;
import com.whatsapp.data.ad.n;
import com.whatsapp.data.co;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.m;
import com.whatsapp.util.Log;

public class ai
{
  private static volatile ai b;
  public final aat a;
  private final va c;
  private final e d;
  private final qz e;
  private final co f;
  private final atv g;
  
  private ai(va paramva, e parame, qz paramqz, co paramco, aat paramaat, atv paramatv)
  {
    this.c = paramva;
    this.d = parame;
    this.e = paramqz;
    this.f = paramco;
    this.a = paramaat;
    this.g = paramatv;
  }
  
  public static ai a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new ai(va.a(), e.a(), qz.a(), co.a(), aat.a(), atv.a());
      }
      return b;
    }
    finally {}
  }
  
  public final boolean a(int paramInt, j paramj)
  {
    return (b(paramInt, paramj)) || (c(paramInt, paramj));
  }
  
  final boolean a(j paramj)
  {
    Object localObject = paramj.e.a;
    cs localcs = this.d.a((String)localObject);
    if ((localcs.d()) || (paramj.a())) {
      if (paramj.f != null) {
        localObject = this.d.d(paramj.f);
      }
    }
    for (;;)
    {
      return a(paramj, localcs, (cs)localObject);
      localObject = null;
      continue;
      localObject = localcs;
    }
  }
  
  final boolean a(j paramj, cs paramcs1, cs paramcs2)
  {
    Object localObject;
    if (paramj.a())
    {
      localObject = this.f.a(paramj.f);
      if (localObject == null)
      {
        paramcs1 = new StringBuilder("no status for ");
        if (TextUtils.isEmpty(paramj.f)) {}
        for (paramj = " me";; paramj = paramj.f)
        {
          Log.e(paramj);
          return false;
        }
      }
      if (this.f.b(paramj)) {
        return false;
      }
      if (e.b(paramj.f)) {
        return true;
      }
      if ((!((ad.n)localObject).e(paramj)) || ((paramcs2 != null) && (paramcs2.C))) {
        return false;
      }
    }
    if (((paramj.N instanceof MediaData)) && (paramj.b().suspiciousContent == MediaData.SUSPICIOUS_CONTENT_YES)) {
      return false;
    }
    if ((paramj.s == 2) && (paramj.o == 1)) {
      return true;
    }
    if (m.a(paramj.s))
    {
      if (paramj.a()) {
        return (paramcs2 != null) && (paramcs2.d != null);
      }
      if (paramcs1.d())
      {
        localObject = this.d.d(paramcs1.q());
        if (this.c.b != null) {}
        for (paramj = this.c.b() + "@s.whatsapp.net"; (this.e.a(paramcs1.t)) || (((cs)localObject).d != null) || (paramj.equals(((cs)localObject).t)) || ((paramcs2 != null) && (paramcs2.d != null)); paramj = "") {
          return true;
        }
        return false;
      }
      return paramcs1.d != null;
    }
    return false;
  }
  
  public final boolean b(int paramInt, j paramj)
  {
    if ((paramInt != 1) && (paramj.t > aic.t * 1048576L)) {}
    do
    {
      int i;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return false;
                if ((paramj.a()) && (e.b(paramj.f)) && ((paramInt == 1) || (paramInt == 2))) {
                  return true;
                }
                i = this.g.b(paramInt);
                switch (paramj.s)
                {
                case 4: 
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 10: 
                case 11: 
                case 12: 
                default: 
                  return false;
                }
              } while ((i & 0x1) == 0);
              return true;
              if (paramj.t > 524288L) {
                break;
              }
            } while ((i & 0x1) == 0);
            return true;
          } while ((i & 0x4) == 0);
          return true;
        } while ((i & 0x4) == 0);
        return true;
      } while ((i & 0x8) == 0);
      return true;
      if ((i & 0x2) != 0) {
        return true;
      }
    } while ((paramj.o != 1) || ((paramj.t > 524288L) && (paramInt != 1)));
    return true;
  }
  
  public final boolean b(j paramj)
  {
    return a(this.a.a(true), paramj);
  }
  
  public final boolean c(int paramInt, j paramj)
  {
    if (!vk.a(paramj)) {}
    while ((paramj.b().cachedDownloadedBytes >= 262144L) || ((paramInt != 1) && (paramj.t > aic.t * 1048576L)) || ((this.g.b(paramInt) & 0x1) == 0)) {
      return false;
    }
    return true;
  }
  
  public final boolean c(j paramj)
  {
    return b(this.a.a(false), paramj);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */