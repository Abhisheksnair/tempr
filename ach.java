package com.whatsapp;

import a.a.a.a.d;
import android.content.Context;
import android.os.SystemClock;
import com.whatsapp.data.ProfilePhotoChange;
import com.whatsapp.data.ad;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.fieldstats.events.be;
import com.whatsapp.fieldstats.l;
import com.whatsapp.protocol.am;
import com.whatsapp.protocol.aw;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.x;
import com.whatsapp.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

public final class ach
  implements am, x
{
  private static HashMap<String, ach> m = new HashMap();
  public String a;
  public byte[] b;
  public byte[] c;
  public aw d;
  public boolean e;
  public boolean f;
  final va g;
  final acm h;
  private boolean i;
  private Long j;
  private a k;
  private long l;
  private final ant n;
  private final pv o;
  private final ad p;
  private final e q;
  private final dh r;
  private final rh s;
  
  ach(ant paramant, pv parampv, va paramva, ad paramad, e parame, dh paramdh, acm paramacm, rh paramrh, String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, aw paramaw)
  {
    this.n = paramant;
    this.o = parampv;
    this.g = paramva;
    this.p = paramad;
    this.q = parame;
    this.r = paramdh;
    this.h = paramacm;
    this.s = paramrh;
    this.a = paramString;
    this.b = paramArrayOfByte1;
    this.c = paramArrayOfByte2;
    this.d = paramaw;
    this.j = Long.valueOf(System.currentTimeMillis());
    m.put(this.j.toString(), this);
    this.l = SystemClock.elapsedRealtime();
    this.k = new a((byte)0);
    new Timer().schedule(this.k, 32000L);
  }
  
  private void b(int paramInt)
  {
    int i2 = 0;
    be localbe = new be();
    int i1;
    if (this.b == null)
    {
      i1 = 0;
      if (this.c != null) {
        break label83;
      }
    }
    for (;;)
    {
      localbe.d = Double.valueOf(i1 + i2);
      localbe.c = Double.valueOf(SystemClock.elapsedRealtime() - this.l);
      localbe.a = Integer.valueOf(paramInt);
      l.a(u.a(), localbe);
      return;
      i1 = this.b.length;
      break;
      label83:
      i2 = this.c.length;
    }
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Iterator localIterator = m.values().iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals(((ach)localIterator.next()).a)) {
        return true;
      }
    }
    return false;
  }
  
  public final void a(int paramInt)
  {
    Log.i("profilephotohandler/request failed : " + paramInt + " | " + this.a);
    this.i = true;
    this.k.cancel();
    m.remove(this.j.toString());
    b(3);
    if (!this.f)
    {
      cs localcs = this.q.d(this.a);
      if ((paramInt != 401) || (!localcs.d()) || (this.s.b(localcs.t))) {
        break label141;
      }
      this.o.a(acj.a(this, paramInt));
    }
    for (;;)
    {
      if (this.d != null) {
        auj.b(this.d.a, paramInt);
      }
      return;
      label141:
      this.o.a(ack.a(this, paramInt));
    }
  }
  
  public final void a(String paramString)
  {
    File localFile = null;
    Log.i("profilephotohandler/request success : " + paramString + " | " + this.a);
    this.i = true;
    this.k.cancel();
    m.remove(this.j.toString());
    b(1);
    cs localcs = this.q.d(this.a);
    int i1;
    if (paramString == null) {
      i1 = -1;
    }
    try
    {
      localcs.a(i1, i1);
      for (;;)
      {
        j localj;
        if (!this.f) {
          if (localcs.d())
          {
            localj = new j(this.g, this.a, null);
            if (i1 != -1) {
              break label353;
            }
            paramString = localFile;
            localj.e(paramString);
            localj.d = 6;
            localj.t = 6L;
            localj.f = this.g.c().t;
            localj.n = this.n.b();
            localFile = localcs.c();
            if (localFile.exists()) {
              paramString = new ProfilePhotoChange();
            }
          }
        }
        try
        {
          paramString.oldPhoto = d.b(localFile);
          paramString.newPhoto = this.c;
          paramString.newPhotoId = i1;
          localj.N = paramString;
          paramString = this.p.r(this.a);
          if ((paramString == null) || (paramString.d != 6) || (paramString.t != 11L) || (!localj.f.equals(paramString.f))) {
            this.p.b(localj, -1);
          }
          if ((this.b == null) && (this.c == null))
          {
            localcs.l();
            localcs.m();
            this.o.a(aci.a(this));
            if (this.d != null) {
              auj.b(this.d.a, 200);
            }
            return;
          }
          try
          {
            i1 = Integer.parseInt(paramString);
          }
          catch (NumberFormatException paramString)
          {
            label353:
            i1 = -1;
          }
          paramString = Integer.toString(i1);
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            Log.c("profilephotohandler/", localIOException);
            continue;
            localcs.a(this.b, this.c);
          }
        }
      }
    }
    catch (NumberFormatException paramString)
    {
      for (;;) {}
    }
  }
  
  final void a(String paramString, int paramInt)
  {
    c(paramString);
    this.h.a(paramString, paramInt);
    Context localContext1 = u.a().getApplicationContext();
    Context localContext2 = u.a();
    if (qz.e(paramString)) {}
    for (paramInt = 2131296790;; paramInt = 2131296792)
    {
      pv.a(localContext1, localContext2.getString(paramInt), 0);
      return;
    }
  }
  
  final void c(String paramString)
  {
    this.q.d(paramString).m();
    this.r.b(paramString);
  }
  
  final class a
    extends TimerTask
  {
    private a() {}
    
    public final void run()
    {
      if (ach.a(ach.this)) {}
      do
      {
        return;
        ach.this.e = true;
        ach.a().remove(ach.b(ach.this).toString());
        if (!ach.this.f) {
          ach.c(ach.this).a(new acl(this));
        }
        ach.d(ach.this);
      } while (ach.this.d == null);
      auj.b(ach.this.d.a, 500);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ach.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */