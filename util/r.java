package com.whatsapp.util;

import android.annotation.SuppressLint;
import android.util.Base64;
import android.util.SparseArray;
import com.whatsapp.aut;
import com.whatsapp.data.cb.c;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class r
{
  private static r y = null;
  private Cipher a;
  private Cipher b;
  private Cipher c;
  private Cipher d;
  private Cipher e;
  private Cipher f;
  private Cipher g;
  private Cipher h;
  private Cipher i;
  private Cipher j;
  private Cipher k;
  private Cipher l;
  private Cipher m;
  private Cipher n;
  private Cipher o;
  private Cipher p;
  private Cipher q;
  private Cipher r;
  private Cipher s;
  private Cipher t;
  private Cipher u;
  private Cipher v;
  private Cipher w;
  private Cipher x;
  
  @SuppressLint({"GetInstance"})
  private r()
  {
    SecretKeySpec localSecretKeySpec1 = new SecretKeySpec(aut.g.getBytes("ASCII"), "AES");
    SecretKeySpec localSecretKeySpec2 = new SecretKeySpec(Base64.decode("JpPRVPJ6lXESFBh1IgfvDlOysvpURFOL", 0), "AES");
    SecretKeySpec localSecretKeySpec3 = new SecretKeySpec(com.whatsapp.r.b(Base64.decode("jUsVXMn/geXL9vp4GTZqPsYhplZBbNeT", 0)), "AES");
    IvParameterSpec localIvParameterSpec = new IvParameterSpec(Base64.decode("HjnzaekNszqnO0Qru7awuQ==", 0));
    this.a = Cipher.getInstance("AES");
    this.b = Cipher.getInstance("AES");
    this.c = Cipher.getInstance("AES");
    this.d = Cipher.getInstance("AES/CTR/NoPadding");
    this.e = Cipher.getInstance("AES/CBC/PKCS5Padding");
    this.f = Cipher.getInstance("AES/CBC/PKCS5Padding");
    this.g = Cipher.getInstance("AES/CBC/PKCS5Padding");
    this.h = Cipher.getInstance("AES/CBC/PKCS5Padding");
    this.i = Cipher.getInstance("AES/GCM/NoPadding");
    this.j = Cipher.getInstance("AES/GCM/NoPadding");
    this.k = Cipher.getInstance("AES/GCM/NoPadding");
    this.l = Cipher.getInstance("AES/GCM/NoPadding");
    this.m = Cipher.getInstance("AES");
    this.n = Cipher.getInstance("AES");
    this.o = Cipher.getInstance("AES");
    this.p = Cipher.getInstance("AES/CTR/NoPadding");
    this.q = Cipher.getInstance("AES/CBC/PKCS5Padding");
    this.r = Cipher.getInstance("AES/CBC/PKCS5Padding");
    this.s = Cipher.getInstance("AES/CBC/PKCS5Padding");
    this.t = Cipher.getInstance("AES/CBC/PKCS5Padding");
    this.u = Cipher.getInstance("AES/GCM/NoPadding");
    this.v = Cipher.getInstance("AES/GCM/NoPadding");
    this.w = Cipher.getInstance("AES/GCM/NoPadding");
    this.x = Cipher.getInstance("AES/GCM/NoPadding");
    this.a.init(1, localSecretKeySpec1);
    this.b.init(1, localSecretKeySpec2);
    this.c.init(1, localSecretKeySpec3);
    this.d.init(1, localSecretKeySpec3, localIvParameterSpec);
    this.e.init(1, localSecretKeySpec3, localIvParameterSpec);
    this.m.init(2, localSecretKeySpec1);
    this.n.init(2, localSecretKeySpec2);
    this.o.init(2, localSecretKeySpec3);
    this.p.init(2, localSecretKeySpec3, localIvParameterSpec);
    this.q.init(2, localSecretKeySpec3, localIvParameterSpec);
  }
  
  public static r a()
  {
    if (y == null) {
      y = new r();
    }
    return y;
  }
  
  private static InputStream a(InputStream paramInputStream, Cipher paramCipher, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramCipher.init(2, new SecretKeySpec(paramArrayOfByte1, "AES"), new IvParameterSpec(paramArrayOfByte2));
    return new CipherInputStream(paramInputStream, paramCipher);
  }
  
  private static InputStream a(InputStream paramInputStream, Cipher paramCipher, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, AtomicLong paramAtomicLong)
  {
    paramCipher.init(2, new SecretKeySpec(paramArrayOfByte1, "AES"), new IvParameterSpec(paramArrayOfByte2));
    return new GZIPInputStream(new a(paramInputStream, paramCipher, paramAtomicLong));
  }
  
  private static OutputStream a(OutputStream paramOutputStream, Cipher paramCipher, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte2 = new IvParameterSpec(paramArrayOfByte2);
    paramCipher.init(1, new SecretKeySpec(paramArrayOfByte1, "AES"), paramArrayOfByte2);
    return new CipherOutputStream(paramOutputStream, paramCipher);
  }
  
  private static void a(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, long paramLong, cb.c paramc, AtomicLong paramAtomicLong)
  {
    byte[] arrayOfByte = new byte[131072];
    long l1 = 0L;
    for (;;)
    {
      int i1 = paramInputStream.read(arrayOfByte);
      if (i1 >= 0)
      {
        paramOutputStream.write(arrayOfByte, 0, i1);
        l1 += i1;
        if ((paramc != null) && (paramInt2 > 0))
        {
          if (paramAtomicLong != null) {}
          for (long l2 = paramAtomicLong.get();; l2 = l1)
          {
            paramc.a(l2, paramLong, paramInt1, paramInt2);
            break;
          }
        }
      }
      else
      {
        return;
      }
    }
  }
  
  private static OutputStream b(OutputStream paramOutputStream, Cipher paramCipher, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte2 = new IvParameterSpec(paramArrayOfByte2);
    paramCipher.init(1, new SecretKeySpec(paramArrayOfByte1, "AES"), paramArrayOfByte2);
    return new GZIPOutputStream(new CipherOutputStream(paramOutputStream, paramCipher));
  }
  
  private static OutputStream c(OutputStream paramOutputStream, Cipher paramCipher, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte2 = new IvParameterSpec(paramArrayOfByte2);
    paramArrayOfByte1 = new SecretKeySpec(paramArrayOfByte1, "AES");
    try
    {
      paramCipher.init(1, paramArrayOfByte1, paramArrayOfByte2);
      paramCipher = new DeflaterOutputStream(new CipherOutputStream(paramOutputStream, paramCipher), new Deflater(1, false));
      return paramCipher;
    }
    catch (InvalidKeyException paramCipher)
    {
      Log.c("encrypter/encrypt/invalidkey", paramCipher);
      return paramOutputStream;
    }
    catch (InvalidAlgorithmParameterException paramCipher)
    {
      Log.c("encrypter/encrypt/invalidalgparam", paramCipher);
    }
    return paramOutputStream;
  }
  
  public final OutputStream a(OutputStream paramOutputStream, b paramb, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    switch (1.a[paramb.ordinal()])
    {
    default: 
      return paramOutputStream;
    case 1: 
      return new CipherOutputStream(paramOutputStream, this.a);
    case 2: 
      return new CipherOutputStream(paramOutputStream, this.b);
    case 3: 
      return new CipherOutputStream(paramOutputStream, this.c);
    case 4: 
      return new CipherOutputStream(paramOutputStream, this.d);
    case 5: 
      return new CipherOutputStream(paramOutputStream, this.e);
    case 6: 
      return a(paramOutputStream, this.f, paramArrayOfByte1, paramArrayOfByte2);
    case 7: 
      return a(paramOutputStream, this.g, paramArrayOfByte1, paramArrayOfByte2);
    case 8: 
      return b(paramOutputStream, this.h, paramArrayOfByte1, paramArrayOfByte2);
    case 9: 
      return b(paramOutputStream, this.i, paramArrayOfByte1, paramArrayOfByte2);
    case 10: 
      return b(paramOutputStream, this.j, paramArrayOfByte1, paramArrayOfByte2);
    case 11: 
      return b(paramOutputStream, this.k, paramArrayOfByte1, paramArrayOfByte2);
    }
    return c(paramOutputStream, this.l, paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public final void a(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt1, int paramInt2, long paramLong, cb.c paramc, b paramb, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    Cipher localCipher = null;
    switch (1.a[paramb.ordinal()])
    {
    default: 
      paramb = localCipher;
    }
    for (;;)
    {
      a(paramInputStream, paramOutputStream, paramInt1, paramInt2, paramLong, paramc, paramb);
      return;
      paramInputStream = new CipherInputStream(paramInputStream, this.m);
      paramb = localCipher;
      continue;
      paramInputStream = new CipherInputStream(paramInputStream, this.n);
      paramb = localCipher;
      continue;
      paramInputStream = new CipherInputStream(paramInputStream, this.o);
      paramb = localCipher;
      continue;
      paramInputStream = new CipherInputStream(paramInputStream, this.p);
      paramb = localCipher;
      continue;
      paramInputStream = new CipherInputStream(paramInputStream, this.q);
      paramb = localCipher;
      continue;
      paramInputStream = a(paramInputStream, this.r, paramArrayOfByte1, paramArrayOfByte2);
      paramb = localCipher;
      continue;
      paramInputStream = a(paramInputStream, this.s, paramArrayOfByte1, paramArrayOfByte2);
      paramb = localCipher;
      continue;
      paramb = new AtomicLong();
      paramInputStream = a(paramInputStream, this.t, paramArrayOfByte1, paramArrayOfByte2, paramb);
      continue;
      paramb = new AtomicLong();
      paramInputStream = a(paramInputStream, this.u, paramArrayOfByte1, paramArrayOfByte2, paramb);
      continue;
      paramb = new AtomicLong();
      paramInputStream = a(paramInputStream, this.v, paramArrayOfByte1, paramArrayOfByte2, paramb);
      continue;
      paramb = new AtomicLong();
      paramInputStream = a(paramInputStream, this.w, paramArrayOfByte1, paramArrayOfByte2, paramb);
      continue;
      paramb = new AtomicLong();
      localCipher = this.x;
      localCipher.init(2, new SecretKeySpec(paramArrayOfByte1, "AES"), new IvParameterSpec(paramArrayOfByte2));
      paramInputStream = new InflaterInputStream(new a(paramInputStream, localCipher, paramb), new Inflater(false));
    }
  }
  
  static final class a
    extends CipherInputStream
  {
    private final AtomicLong a;
    
    public a(InputStream paramInputStream, Cipher paramCipher, AtomicLong paramAtomicLong)
    {
      super(paramCipher);
      this.a = paramAtomicLong;
    }
    
    public final int read()
    {
      int i = super.read();
      if (i >= 0) {
        this.a.incrementAndGet();
      }
      return i;
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 > 0) {
        this.a.addAndGet(paramInt1);
      }
      return paramInt1;
    }
  }
  
  public static enum b
  {
    private static b n = null;
    private static SparseArray<b> o = null;
    public final int m;
    
    private b(int paramInt)
    {
      this.m = paramInt;
    }
    
    public static b a()
    {
      Object localObject;
      int i1;
      if (n == null)
      {
        localObject = a;
        b[] arrayOfb = values();
        int i2 = arrayOfb.length;
        i1 = 0;
        if (i1 < i2)
        {
          b localb = arrayOfb[i1];
          if (localb.m <= ((b)localObject).m) {
            break label59;
          }
          localObject = localb;
        }
      }
      label59:
      for (;;)
      {
        i1 += 1;
        break;
        n = (b)localObject;
        return n;
      }
    }
    
    public static b a(int paramInt)
    {
      if (o == null) {
        b();
      }
      return (b)o.get(paramInt);
    }
    
    public static b[] a(b paramb1, b paramb2)
    {
      if (o == null) {
        b();
      }
      ArrayList localArrayList = new ArrayList();
      int i1 = 0;
      while (i1 < o.size())
      {
        int i2 = o.keyAt(i1);
        if ((i2 >= paramb1.m) && (i2 <= paramb2.m)) {
          localArrayList.add(o.get(i2));
        }
        i1 += 1;
      }
      Collections.sort(localArrayList, s.a());
      return (b[])localArrayList.toArray(new b[localArrayList.size()]);
    }
    
    private static void b()
    {
      o = new SparseArray(values().length);
      b[] arrayOfb = values();
      int i2 = arrayOfb.length;
      int i1 = 0;
      while (i1 < i2)
      {
        b localb = arrayOfb[i1];
        o.append(localb.m, localb);
        i1 += 1;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */