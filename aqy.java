package com.whatsapp;

import a.a.a.a.a.a.d;
import android.util.Base64;
import com.whatsapp.data.ad;
import com.whatsapp.l.e;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.ae.a;
import com.whatsapp.util.af;
import java.io.File;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collections;

public final class aqy
  extends xg
{
  private static final ae.a w = new ae.a(4, 5);
  public boolean r = true;
  final j s;
  private final aoj t;
  private boolean u;
  private String v;
  
  public aqy(pv parampv, va paramva, oz paramoz, aic paramaic, aoj paramaoj, ad paramad, e parame, com.whatsapp.data.y paramy, vv paramvv, atv paramatv, rh paramrh, vs paramvs, j paramj)
  {
    super(parampv, paramva, paramoz, paramaic, paramad, parame, paramy, paramvv, paramatv, paramrh, paramvs, new aoi(Collections.singletonList(paramj)), false, true);
    this.t = paramaoj;
    this.s = paramj;
  }
  
  private static String l()
  {
    try
    {
      Object localObject = new byte[32];
      SecureRandom.getInstance("SHA1PRNG").nextBytes((byte[])localObject);
      localObject = Base64.encodeToString((byte[])localObject, 2);
      return (String)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      throw new RuntimeException(localNoSuchAlgorithmException);
    }
  }
  
  protected final String a()
  {
    return l();
  }
  
  public final void a(xg.c paramc)
  {
    File localFile;
    MediaData localMediaData;
    if (paramc == xg.c.a)
    {
      localFile = MediaFileUtils.a(u.a(), this.c, this.s.b().file, (byte)2, 1);
      localMediaData = this.s.b();
      if (!localMediaData.file.renameTo(localFile)) {
        break label60;
      }
      localMediaData.file = localFile;
    }
    for (;;)
    {
      super.a(paramc);
      return;
      label60:
      Log.e("failed to rename " + localMediaData.file + " to " + localFile);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    Log.i("voicenote/mediaupload/onrecordingstopped " + paramBoolean);
    this.u = true;
    if (paramBoolean)
    {
      MediaData localMediaData = this.s.b();
      this.s.t = localMediaData.file.length();
      if (isCancelled())
      {
        this.t.a(this.s);
        return;
      }
      this.e.b(this.s, 1);
      return;
    }
    b(this.s);
  }
  
  protected final String b()
  {
    a.d.a(this.u, "Cannot calculate final hash before recording finished");
    if (this.v == null) {
      this.v = super.a();
    }
    return this.v;
  }
  
  protected final InputStream c()
  {
    Log.i("voicenote/mediaupload/getinputstream");
    new com.whatsapp.util.y(this.s.b().file)
    {
      public final boolean a()
      {
        return !aqy.a(aqy.this);
      }
    };
  }
  
  protected final boolean d()
  {
    return this.r;
  }
  
  protected final String e()
  {
    return af.a(w);
  }
  
  protected final boolean f()
  {
    return true;
  }
  
  protected final String g()
  {
    return l();
  }
  
  protected final long h()
  {
    return 65536L;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aqy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */