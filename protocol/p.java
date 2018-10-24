package com.whatsapp.protocol;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;

public final class p
  implements an
{
  private final n a;
  private final az b;
  private byte[] c;
  private final String[] d;
  private final String[] e;
  
  public p(n paramn, az paramaz, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.a = paramn;
    this.b = paramaz;
    this.d = paramArrayOfString1;
    this.e = paramArrayOfString2;
  }
  
  private ak a(InputStream paramInputStream)
  {
    int j = 1;
    int k = c(paramInputStream, paramInputStream.read());
    int i = paramInputStream.read();
    if (i == 2) {
      return null;
    }
    String str = a(paramInputStream, i);
    if ((k == 0) || (str == null)) {
      throw new c("nextTree sees 0 list or null tag", b());
    }
    int m = (k - 2 + k % 2) / 2;
    z[] arrayOfz = new z[m];
    i = 0;
    while (i < m)
    {
      arrayOfz[i] = new z(a(paramInputStream, paramInputStream.read()), a(paramInputStream, paramInputStream.read()));
      i += 1;
    }
    if (k % 2 == 1) {
      return new ak(str, arrayOfz);
    }
    k = paramInputStream.read();
    i = j;
    switch (k)
    {
    default: 
      i = 0;
    }
    if (i != 0) {
      return new ak(str, arrayOfz, b(paramInputStream, k));
    }
    byte[] arrayOfByte;
    if (k == 252)
    {
      arrayOfByte = new byte[paramInputStream.read()];
      a(paramInputStream, arrayOfByte);
      return new ak(str, arrayOfz, arrayOfByte);
    }
    if (k == 253)
    {
      arrayOfByte = new byte[b(paramInputStream)];
      a(paramInputStream, arrayOfByte);
      return new ak(str, arrayOfz, arrayOfByte);
    }
    if (k == 254)
    {
      arrayOfByte = new byte[c(paramInputStream)];
      a(paramInputStream, arrayOfByte);
      return new ak(str, arrayOfz, arrayOfByte);
    }
    if ((k == 255) || (k == 251)) {
      return new ak(str, arrayOfz, d(paramInputStream, k));
    }
    return new ak(str, arrayOfz, a(paramInputStream, k));
  }
  
  private String a(InputStream paramInputStream, int paramInt)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = null;
    if (paramInt == -1) {
      throw new c("-1 token in readString", b());
    }
    if ((paramInt > 2) && (paramInt < 236))
    {
      paramInputStream = (InputStream)localObject1;
      if (paramInt >= 0)
      {
        paramInputStream = (InputStream)localObject1;
        if (paramInt < this.d.length) {
          paramInputStream = this.d[paramInt];
        }
      }
      localObject1 = paramInputStream;
      if (paramInputStream == null) {
        throw new c("invalid token/length in getToken", b());
      }
    }
    else
    {
      localObject1 = localObject3;
      switch (paramInt)
      {
      default: 
        throw new c("readString couldn't match token", b());
      case 236: 
      case 237: 
      case 238: 
      case 239: 
        paramInt = paramInputStream.read() + (paramInt - 236 << 8);
        paramInputStream = (InputStream)localObject2;
        if (paramInt >= 0)
        {
          paramInputStream = (InputStream)localObject2;
          if (paramInt < this.e.length) {
            paramInputStream = this.e[paramInt];
          }
        }
        localObject1 = paramInputStream;
        if (paramInputStream == null) {
          throw new c("invalid token/length in extended getToken", b());
        }
        break;
      case 252: 
        localObject1 = new byte[paramInputStream.read()];
        a(paramInputStream, (byte[])localObject1);
        localObject1 = s.a((byte[])localObject1);
      }
    }
    do
    {
      return (String)localObject1;
      localObject1 = new byte[b(paramInputStream)];
      a(paramInputStream, (byte[])localObject1);
      return s.a((byte[])localObject1);
      localObject1 = new byte[c(paramInputStream)];
      a(paramInputStream, (byte[])localObject1);
      return s.a((byte[])localObject1);
      return s.a(d(paramInputStream, paramInt));
      localObject1 = a(paramInputStream, paramInputStream.read());
      paramInputStream = a(paramInputStream, paramInputStream.read());
      if ((localObject1 != null) && (paramInputStream != null)) {
        return (String)localObject1 + "@" + paramInputStream;
      }
      localObject1 = paramInputStream;
    } while (paramInputStream != null);
    throw new c("readString couldn't reconstruct jid", b());
  }
  
  private static void a(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramInputStream.read(paramArrayOfByte, i, j - i);
      if (k == -1) {
        throw new IOException("ran out of bytes while reading into buffer");
      }
      i += k;
    }
  }
  
  private static int b(InputStream paramInputStream)
  {
    return ((paramInputStream.read() & 0xF) << 16) + (paramInputStream.read() << 8) + paramInputStream.read();
  }
  
  private ak[] b(InputStream paramInputStream, int paramInt)
  {
    int i = c(paramInputStream, paramInt);
    ak[] arrayOfak = new ak[i];
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfak[paramInt] = a(paramInputStream);
      paramInt += 1;
    }
    return arrayOfak;
  }
  
  private static int c(InputStream paramInputStream)
  {
    return (paramInputStream.read() & 0x7F) << 24 | paramInputStream.read() << 16 | paramInputStream.read() << 8 | paramInputStream.read();
  }
  
  private int c(InputStream paramInputStream, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new c("invalid list size in readListSize: token " + paramInt, b());
    case 0: 
      return 0;
    case 248: 
      return paramInputStream.read();
    }
    return (paramInputStream.read() << 8) + paramInputStream.read();
  }
  
  private static byte[] d(InputStream paramInputStream, int paramInt)
  {
    int k = 1;
    int j = 0;
    int m = paramInputStream.read();
    label22:
    byte[] arrayOfByte;
    if ((m & 0x80) != 0)
    {
      i = 1;
      m &= 0x7F;
      arrayOfByte = new byte[m];
      a(paramInputStream, arrayOfByte);
      if (i == 0) {
        break label145;
      }
    }
    label145:
    for (int i = k;; i = 0)
    {
      k = (m << 1) - i;
      paramInputStream = new byte[k];
      if (j >= k) {
        return paramInputStream;
      }
      i = (1 - j % 2) * 4;
      i = (arrayOfByte[(j / 2)] & 15 << i) >> i;
      switch (paramInt)
      {
      default: 
        throw new c("bad packed type " + paramInt);
        i = 0;
        break label22;
      }
    }
    switch (i)
    {
    default: 
      throw new c("bad nibble " + i);
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      i += 48;
    }
    for (;;)
    {
      paramInputStream[j] = ((byte)i);
      j += 1;
      break;
      i = i - 10 + 45;
      continue;
      switch (i)
      {
      default: 
        throw new c("bad hex " + i);
      case 0: 
      case 1: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
        i += 48;
        break;
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
        i = i - 10 + 65;
      }
    }
    return paramInputStream;
  }
  
  public final ak a()
  {
    Object localObject2;
    do
    {
      localObject2 = this.a.a();
    } while (localObject2.length == 0);
    if (localObject2.length == 1) {
      throw new c("header only frame received");
    }
    int i = localObject2[0];
    Object localObject1 = localObject2;
    if ((s.a & i) != 0)
    {
      localObject1 = new InflaterInputStream(new ByteArrayInputStream((byte[])localObject2, 1, localObject2.length - 1));
      localObject2 = new ByteArrayOutputStream(8192);
      ((ByteArrayOutputStream)localObject2).write(new byte[] { i });
      byte[] arrayOfByte = new byte[' '];
      for (int j = ((InflaterInputStream)localObject1).read(arrayOfByte); j >= 0; j = ((InflaterInputStream)localObject1).read(arrayOfByte)) {
        ((ByteArrayOutputStream)localObject2).write(arrayOfByte, 0, j);
      }
      ((InflaterInputStream)localObject1).close();
      ((ByteArrayOutputStream)localObject2).close();
      localObject1 = ((ByteArrayOutputStream)localObject2).toByteArray();
    }
    this.c = ((byte[])localObject1);
    localObject1 = new ByteArrayInputStream((byte[])localObject1);
    if (((byte)((ByteArrayInputStream)localObject1).read() & s.b) != 0) {
      throw new c("server to client stanza fragmentation not supported");
    }
    return a((InputStream)localObject1);
  }
  
  public final ak a(byte[] paramArrayOfByte)
  {
    return a(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public final String b()
  {
    if (this.c == null) {
      return "null";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("size = ").append(Integer.toString(this.c.length)).append('<');
    int i = 0;
    while (i < this.c.length)
    {
      if (i > 0) {
        localStringBuffer.append(", ");
      }
      localStringBuffer.append(Integer.toString(this.c[i] & 0xFF));
      if (localStringBuffer.length() >= 262144L) {
        break;
      }
      i += 1;
    }
    if (localStringBuffer.length() < 262144L) {
      localStringBuffer.append('>');
    }
    for (;;)
    {
      return localStringBuffer.toString();
      localStringBuffer.append("...");
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */