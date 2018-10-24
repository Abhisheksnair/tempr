package com.whatsapp.util.b;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public final class a
{
  public static final String[] a;
  public static final HashSet<String> b;
  public c[] c;
  
  static
  {
    int i = 0;
    a = new String[] { "moov", "trak", "udta", "tref", "imap", "mdia", "minf", "stbl", "edts", "mdra", "rmra", "imag", "vnrp", "dinf" };
    b = new HashSet();
    while (i < a.length)
    {
      b.add(a[i]);
      i += 1;
    }
  }
  
  public static int a(RandomAccessFile paramRandomAccessFile)
  {
    return paramRandomAccessFile.readByte();
  }
  
  public static b a(c[] paramArrayOfc)
  {
    int i = 0;
    while (i < paramArrayOfc.length)
    {
      Object localObject = paramArrayOfc[i];
      if ((localObject instanceof d))
      {
        localObject = a(((d)localObject).a());
        if (localObject != null) {
          return (b)localObject;
        }
      }
      else if ((localObject instanceof h))
      {
        e locale = (e)a(paramArrayOfc, e.class);
        if ((locale != null) && ("vide".equals(locale.e))) {
          return ((h)localObject).g;
        }
      }
      i += 1;
    }
    return null;
  }
  
  private static <T extends c> T a(c[] paramArrayOfc, Class<T> paramClass)
  {
    int i = 0;
    while (i < paramArrayOfc.length)
    {
      c localc2 = paramArrayOfc[i];
      c localc1;
      if ((localc2 instanceof d))
      {
        localc1 = a(((d)localc2).a(), paramClass);
        if (localc1 == null) {}
      }
      else
      {
        do
        {
          return localc1;
          localc1 = localc2;
        } while (localc2.getClass() == paramClass);
      }
      i += 1;
    }
    return null;
  }
  
  public static Date a(long paramLong)
  {
    return new Date((paramLong - 2082844800L) * 1000L);
  }
  
  public static c[] a(RandomAccessFile paramRandomAccessFile, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    long l;
    Object localObject;
    if (paramLong1 < paramLong2)
    {
      paramRandomAccessFile.seek(paramLong1);
      l = d(paramRandomAccessFile);
      if (paramRandomAccessFile.getFilePointer() != paramLong2)
      {
        localObject = new byte[4];
        if (paramRandomAccessFile.read((byte[])localObject, 0, 4) != 4) {
          throw new IOException("Couldn't read atom type");
        }
        localObject = new String((byte[])localObject);
        if (l != 1L) {
          break label322;
        }
        l = 0L + (d(paramRandomAccessFile) << 32) + d(paramRandomAccessFile);
      }
    }
    label296:
    label322:
    for (;;)
    {
      if ((l < 0L) || (paramLong1 + l > paramRandomAccessFile.length())) {
        throw new IOException("atom has invalid size: " + l);
      }
      if (b.contains(localObject)) {
        localObject = new d(l, (String)localObject, a(paramRandomAccessFile, paramRandomAccessFile.getFilePointer(), paramLong1 + l));
      }
      for (;;)
      {
        localArrayList.add(localObject);
        if (l != 0L) {
          break label296;
        }
        paramLong1 = paramRandomAccessFile.length();
        break;
        if ("hdlr".equals(localObject)) {
          localObject = new e(l, (String)localObject, paramRandomAccessFile);
        } else if ("mvhd".equals(localObject)) {
          localObject = new g(l, (String)localObject, paramRandomAccessFile);
        } else if ("tkhd".equals(localObject)) {
          localObject = new h(l, (String)localObject, paramRandomAccessFile);
        } else {
          localObject = new f(l, (String)localObject);
        }
      }
      paramLong1 += l;
      break;
      paramRandomAccessFile = new c[localArrayList.size()];
      localArrayList.toArray(paramRandomAccessFile);
      return paramRandomAccessFile;
    }
  }
  
  public static int b(RandomAccessFile paramRandomAccessFile)
  {
    return paramRandomAccessFile.readByte() << 8 | paramRandomAccessFile.readByte();
  }
  
  public static int c(RandomAccessFile paramRandomAccessFile)
  {
    byte[] arrayOfByte = new byte[3];
    paramRandomAccessFile.read(arrayOfByte, 0, 3);
    int i = arrayOfByte[0];
    int j = arrayOfByte[1];
    return arrayOfByte[2] & 0xFF | i << 16 & 0xFF0000 | 0x0 | j << 8 & 0xFF00;
  }
  
  public static long d(RandomAccessFile paramRandomAccessFile)
  {
    byte[] arrayOfByte = new byte[4];
    paramRandomAccessFile.read(arrayOfByte, 0, 4);
    int i = arrayOfByte[0];
    int j = arrayOfByte[1];
    int k = arrayOfByte[2];
    return arrayOfByte[3] & 0xFF | i << 24 & 0xFF000000 | 0x0 | j << 16 & 0xFF0000 | k << 8 & 0xFF00;
  }
  
  public static String e(RandomAccessFile paramRandomAccessFile)
  {
    byte[] arrayOfByte = new byte[4];
    paramRandomAccessFile.read(arrayOfByte, 0, 4);
    return new String(arrayOfByte);
  }
  
  public static double f(RandomAccessFile paramRandomAccessFile)
  {
    byte[] arrayOfByte = new byte[4];
    paramRandomAccessFile.read(arrayOfByte, 0, 4);
    int i = arrayOfByte[0];
    int j = arrayOfByte[1];
    int k = arrayOfByte[2];
    return (arrayOfByte[3] & 0xFF | i << 24 & 0xFF000000 | 0x0 | j << 16 & 0xFF0000 | k << 8 & 0xFF00) / 65536.0D;
  }
  
  public static double g(RandomAccessFile paramRandomAccessFile)
  {
    byte[] arrayOfByte = new byte[4];
    paramRandomAccessFile.read(arrayOfByte, 0, 4);
    int i = arrayOfByte[0];
    int j = arrayOfByte[1];
    int k = arrayOfByte[2];
    return (arrayOfByte[3] & 0xFF | i << 24 & 0xFF000000 | 0x0 | j << 16 & 0xFF0000 | k << 8 & 0xFF00) / 1.073741824E9D;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */