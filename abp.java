package com.whatsapp;

import a.a.a.a.a.a.d;
import android.os.Bundle;
import android.os.Message;
import com.whatsapp.a.c;
import com.whatsapp.messaging.ParcelablePreKey;
import com.whatsapp.messaging.m;
import com.whatsapp.protocol.aj;
import java.util.HashSet;
import java.util.Set;
import org.whispersystems.a.h.i;

public class abp
{
  private static volatile abp h;
  boolean a;
  aj[] b;
  final Set<String> c = new HashSet();
  final pv d;
  final va e;
  final m f;
  final c g;
  
  private abp(pv parampv, va paramva, m paramm, c paramc)
  {
    this.d = parampv;
    this.e = paramva;
    this.f = paramm;
    this.g = paramc;
  }
  
  public static abp a()
  {
    if (h == null) {}
    try
    {
      if (h == null) {
        h = new abp(pv.a(), va.a(), m.a(), c.a());
      }
      return h;
    }
    finally {}
  }
  
  public final void a(String paramString)
  {
    this.c.remove(paramString);
  }
  
  public final void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, aj[] paramArrayOfaj, aj paramaj)
  {
    a.d.b();
    aj[] arrayOfaj = paramArrayOfaj;
    if (paramArrayOfaj != null)
    {
      arrayOfaj = paramArrayOfaj;
      if (paramArrayOfaj.length > aic.J)
      {
        arrayOfaj = new aj[aic.J];
        System.arraycopy(paramArrayOfaj, 0, arrayOfaj, 0, arrayOfaj.length);
      }
    }
    if (this.f.d)
    {
      paramArrayOfaj = this.e.b() + "@s.whatsapp.net";
      if (!this.c.contains(paramArrayOfaj))
      {
        this.c.add(paramArrayOfaj);
        this.a = true;
        this.b = arrayOfaj;
        paramArrayOfaj = this.f;
        Bundle localBundle = new Bundle();
        localBundle.putByteArray("identity", paramArrayOfByte1);
        localBundle.putByteArray("registration", paramArrayOfByte2);
        localBundle.putByte("type", (byte)5);
        localBundle.putParcelableArray("preKeys", ParcelablePreKey.a(arrayOfaj));
        localBundle.putParcelable("signedPreKey", new ParcelablePreKey(paramaj));
        paramArrayOfaj.a(Message.obtain(null, 0, 85, 0, localBundle));
      }
    }
  }
  
  public final void b()
  {
    a.d.c();
    int i = this.g.i();
    byte[] arrayOfByte = this.g.g();
    aj[] arrayOfaj = this.g.j();
    aj localaj = this.g.e.a();
    this.d.a(abq.a(this, arrayOfByte, i, arrayOfaj, localaj));
  }
  
  public final void c()
  {
    this.g.f();
    b();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/abp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */