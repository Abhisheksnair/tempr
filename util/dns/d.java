package com.whatsapp.util.dns;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicInteger;

final class d
{
  private static final AtomicInteger c = new AtomicInteger();
  final c a;
  final a[] b;
  private final f[] d;
  private final int e;
  private byte[] f;
  private int g;
  
  private d(c paramc, f[] paramArrayOff, a[] paramArrayOfa, int paramInt)
  {
    this.a = paramc;
    this.d = paramArrayOff;
    this.b = paramArrayOfa;
    this.e = paramInt;
  }
  
  static d a(String paramString)
  {
    Object localObject = paramString.split("\\.");
    paramString = new c((short)c.getAndIncrement(), false, (byte)0, false, false, true, false, (short)0, (short)1, (short)0, (short)0, (short)0);
    f[] arrayOff = new f[1];
    localObject = e.a((String[])localObject);
    arrayOff[0] = new f((e)localObject, 1, 1, ((e)localObject).c + 4);
    int i = arrayOff[0].d;
    return new d(paramString, arrayOff, new a[0], i + 12);
  }
  
  static d a(byte[] paramArrayOfByte)
  {
    short s1 = a.a.a.a.d.a(paramArrayOfByte, 0);
    boolean bool1;
    boolean bool2;
    label40:
    boolean bool3;
    label51:
    boolean bool4;
    label62:
    boolean bool5;
    label75:
    int i;
    short s2;
    f[] arrayOff;
    if ((paramArrayOfByte[2] & 0x80) != 0)
    {
      bool1 = true;
      byte b1 = (byte)(paramArrayOfByte[2] >> 3 & 0xF);
      if ((paramArrayOfByte[2] & 0x4) == 0) {
        break label214;
      }
      bool2 = true;
      if ((paramArrayOfByte[2] & 0x2) == 0) {
        break label220;
      }
      bool3 = true;
      if ((paramArrayOfByte[2] & 0x1) == 0) {
        break label226;
      }
      bool4 = true;
      if ((paramArrayOfByte[3] & 0x80) == 0) {
        break label232;
      }
      bool5 = true;
      i = (byte)(paramArrayOfByte[3] & 0xF);
      s2 = a.a.a.a.d.a(paramArrayOfByte, 4);
      short s3 = a.a.a.a.d.a(paramArrayOfByte, 6);
      short s4 = a.a.a.a.d.a(paramArrayOfByte, 8);
      short s5 = a.a.a.a.d.a(paramArrayOfByte, 10);
      localObject1 = new c(s1, bool1, b1, bool2, bool3, bool4, bool5, (short)i, s2, s3, s4, s5);
      i = 12;
      arrayOff = new f[((c)localObject1).i];
      j = 0;
    }
    int k;
    for (;;)
    {
      if (j >= arrayOff.length) {
        break label295;
      }
      localObject2 = e.a(paramArrayOfByte, i);
      k = ((e)localObject2).c + i;
      if (512 < k + 4)
      {
        throw new IllegalArgumentException("insufficient data");
        bool1 = false;
        break;
        label214:
        bool2 = false;
        break label40;
        label220:
        bool3 = false;
        break label51;
        label226:
        bool4 = false;
        break label62;
        label232:
        bool5 = false;
        break label75;
      }
      arrayOff[j] = new f((e)localObject2, a.a.a.a.d.a(paramArrayOfByte, k), a.a.a.a.d.a(paramArrayOfByte, k + 2), ((e)localObject2).c + 4);
      i += arrayOff[j].d;
      j += 1;
    }
    label295:
    Object localObject2 = new a[((c)localObject1).j];
    int j = 0;
    while (j < localObject2.length)
    {
      e locale = e.a(paramArrayOfByte, i);
      int i1 = locale.c + i;
      if (512 < i1 + 10) {
        throw new IllegalArgumentException("insufficient data");
      }
      s1 = a.a.a.a.d.a(paramArrayOfByte, i1);
      s2 = a.a.a.a.d.a(paramArrayOfByte, i1 + 2);
      int i2 = i1 + 4;
      k = paramArrayOfByte[i2];
      int m = paramArrayOfByte[(i2 + 1)];
      int n = paramArrayOfByte[(i2 + 2)];
      i2 = paramArrayOfByte[(i2 + 3)];
      int i3 = a.a.a.a.d.a(paramArrayOfByte, i1 + 8);
      i1 += 10;
      if (512 < i1 + i3) {
        throw new IllegalArgumentException("insufficient data");
      }
      byte[] arrayOfByte = new byte[i3];
      System.arraycopy(paramArrayOfByte, i1, arrayOfByte, 0, i3);
      localObject2[j] = new a(locale, s1, s2, i2 & 0xFF | k << 24 & 0xFF000000 | m << 16 & 0xFF0000 | n << 8 & 0xFF00, arrayOfByte, i3 + (locale.c + 10));
      k = localObject2[j].f;
      j += 1;
      i += k;
    }
    Object localObject1 = new d((c)localObject1, arrayOff, (a[])localObject2, -1);
    ((d)localObject1).f = paramArrayOfByte;
    ((d)localObject1).g = 0;
    return (d)localObject1;
  }
  
  private void a(OutputStream paramOutputStream)
  {
    int k = 128;
    int j = 0;
    Object localObject = this.a;
    byte[] arrayOfByte = new byte[12];
    a.a.a.a.d.a(((c)localObject).a, arrayOfByte, 0);
    arrayOfByte[2] = 0;
    int m = arrayOfByte[2];
    if (((c)localObject).b)
    {
      i = 128;
      arrayOfByte[2] = ((byte)(i | m));
      arrayOfByte[2] = ((byte)(arrayOfByte[2] | (byte)((((c)localObject).c & 0xF) << 3)));
      m = arrayOfByte[2];
      if (!((c)localObject).d) {
        break label325;
      }
      i = 4;
      label99:
      arrayOfByte[2] = ((byte)(i | m));
      m = arrayOfByte[2];
      if (!((c)localObject).e) {
        break label330;
      }
      i = 2;
      label124:
      arrayOfByte[2] = ((byte)(i | m));
      m = arrayOfByte[2];
      if (!((c)localObject).f) {
        break label335;
      }
      i = 1;
      label149:
      arrayOfByte[2] = ((byte)(i | m));
      arrayOfByte[3] = 0;
      m = arrayOfByte[3];
      if (!((c)localObject).g) {
        break label340;
      }
    }
    label325:
    label330:
    label335:
    label340:
    for (int i = k;; i = 0)
    {
      arrayOfByte[3] = ((byte)(m | i));
      arrayOfByte[3] = ((byte)(arrayOfByte[3] | (byte)(((c)localObject).h & 0xF)));
      a.a.a.a.d.a(((c)localObject).i, arrayOfByte, 4);
      a.a.a.a.d.a(((c)localObject).j, arrayOfByte, 6);
      a.a.a.a.d.a(((c)localObject).k, arrayOfByte, 8);
      a.a.a.a.d.a(((c)localObject).l, arrayOfByte, 10);
      paramOutputStream.write(arrayOfByte);
      localObject = this.d;
      k = localObject.length;
      i = 0;
      while (i < k)
      {
        arrayOfByte = localObject[i];
        arrayOfByte.a.a(paramOutputStream);
        a.a.a.a.d.a(paramOutputStream, arrayOfByte.b);
        a.a.a.a.d.a(paramOutputStream, arrayOfByte.c);
        i += 1;
      }
      i = 0;
      break;
      i = 0;
      break label99;
      i = 0;
      break label124;
      i = 0;
      break label149;
    }
    localObject = this.b;
    k = localObject.length;
    i = j;
    while (i < k)
    {
      arrayOfByte = localObject[i];
      arrayOfByte.a.a(paramOutputStream);
      a.a.a.a.d.a(paramOutputStream, arrayOfByte.b);
      a.a.a.a.d.a(paramOutputStream, arrayOfByte.c);
      j = arrayOfByte.d;
      paramOutputStream.write(j >>> 24);
      paramOutputStream.write(j >>> 16 & 0xFF);
      paramOutputStream.write(j >>> 8 & 0xFF);
      paramOutputStream.write(j & 0xFF);
      a.a.a.a.d.a(paramOutputStream, (short)arrayOfByte.e.length);
      paramOutputStream.write(arrayOfByte.e);
      i += 1;
    }
  }
  
  final String a(e parame)
  {
    int j = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = parame.a;
    int k = arrayOfString.length;
    int i = 0;
    while (i < k)
    {
      localStringBuilder.append(arrayOfString[i]).append('.');
      i += 1;
    }
    if (parame.b != 0)
    {
      parame = e.a(this.f, this.g + parame.b).a;
      k = parame.length;
      i = j;
      while (i < k)
      {
        localStringBuilder.append(parame[i]).append('.');
        i += 1;
      }
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.setLength(localStringBuilder.length() - 1);
    }
    return localStringBuilder.toString();
  }
  
  final byte[] a()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      a(localByteArrayOutputStream);
      return localByteArrayOutputStream.toByteArray();
    }
    catch (IOException localIOException) {}
    return null;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/dns/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */