package com.whatsapp.protocol;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public final class q
  implements ao
{
  private final o a;
  private final az b;
  private final Map<String, Integer> c;
  
  public q(o paramo, az paramaz, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    this.a = paramo;
    this.b = paramaz;
    this.c = new HashMap(paramArrayOfString1.length + paramArrayOfString2.length);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= paramArrayOfString1.length) {
        break;
      }
      if (paramArrayOfString1[i] != null) {
        this.c.put(paramArrayOfString1[i], Integer.valueOf(i));
      }
      i += 1;
    }
    while (j < paramArrayOfString2.length)
    {
      if (paramArrayOfString2[j] != null) {
        this.c.put(paramArrayOfString2[j], Integer.valueOf(j + 256));
      }
      j += 1;
    }
  }
  
  private static void a(OutputStream paramOutputStream, int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 255)) {
      throw new IOException("invalid token");
    }
    paramOutputStream.write((byte)paramInt);
  }
  
  private void a(OutputStream paramOutputStream, ak paramak)
  {
    int k = 0;
    if ((paramak.c != null) && (paramak.c.length > 0)) {}
    for (int i = 1;; i = 0)
    {
      if (paramak.d != null) {
        i += 1;
      }
      for (;;)
      {
        if (i > 1) {
          throw new IOException("more than one source of inner data for node; countValues=2");
        }
        int j;
        if (paramak.b == null)
        {
          j = 0;
          b(paramOutputStream, j + 1 + i);
          a(paramOutputStream, paramak.a, false);
          a(paramOutputStream, paramak.b);
          if (paramak.d == null) {
            break label114;
          }
          a(paramOutputStream, paramak.d, false);
        }
        for (;;)
        {
          return;
          j = paramak.b.length << 1;
          break;
          label114:
          if ((paramak.c != null) && (paramak.c.length > 0))
          {
            b(paramOutputStream, paramak.c.length);
            i = k;
            while (i < paramak.c.length)
            {
              a(paramOutputStream, paramak.c[i]);
              i += 1;
            }
          }
        }
      }
    }
  }
  
  private void a(OutputStream paramOutputStream, String paramString, boolean paramBoolean)
  {
    Object localObject = (Integer)this.c.get(paramString);
    if (localObject == null)
    {
      i = paramString.indexOf('@');
      if (i <= 0)
      {
        a(paramOutputStream, s.a(paramString), paramBoolean);
        return;
      }
      localObject = paramString.substring(0, i);
      paramString = paramString.substring(i + 1);
      paramOutputStream.write(250);
      if (localObject != null) {
        a(paramOutputStream, (String)localObject, true);
      }
      for (;;)
      {
        paramBoolean = false;
        break;
        a(paramOutputStream, 0);
      }
    }
    int i = ((Integer)localObject).intValue();
    if (i < 256)
    {
      a(paramOutputStream, i);
      return;
    }
    int j = i - 256;
    switch (j / 256)
    {
    default: 
      throw new IllegalArgumentException("Double byte dictionary token out of range");
    case 0: 
      i = 236;
    }
    for (;;)
    {
      a(paramOutputStream, i);
      a(paramOutputStream, j % 256);
      return;
      i = 237;
      continue;
      i = 238;
      continue;
      i = 239;
    }
  }
  
  private static void a(OutputStream paramOutputStream, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i = paramArrayOfByte.length;
    if (i >= 1048576)
    {
      paramOutputStream.write(254);
      if (i < 0) {
        throw new IOException("value out of range; value=" + i);
      }
      paramOutputStream.write((0x7F000000 & i) >> 24);
      paramOutputStream.write(i >> 16 & 0xFF);
      paramOutputStream.write(i >> 8 & 0xFF);
      paramOutputStream.write(i & 0xFF);
    }
    for (;;)
    {
      paramOutputStream.write(paramArrayOfByte);
      return;
      if (i >= 256)
      {
        paramOutputStream.write(253);
        if ((i < 0) || (i >= 1048576)) {
          throw new IOException("value out of range; value=" + i);
        }
        paramOutputStream.write((0xF0000 & i) >> 16);
        paramOutputStream.write(i >> 8 & 0xFF);
        paramOutputStream.write(i & 0xFF);
      }
      else
      {
        Object localObject = null;
        if (paramBoolean)
        {
          localObject = a(255, paramArrayOfByte);
          if (localObject == null) {
            break label230;
          }
          paramOutputStream.write(255);
        }
        for (;;)
        {
          if (localObject == null) {
            break label262;
          }
          paramOutputStream.write((i & 0x1) << 7 | localObject.length);
          paramArrayOfByte = (byte[])localObject;
          break;
          label230:
          byte[] arrayOfByte = a(251, paramArrayOfByte);
          localObject = arrayOfByte;
          if (arrayOfByte != null)
          {
            paramOutputStream.write(251);
            localObject = arrayOfByte;
          }
        }
        label262:
        paramOutputStream.write(252);
        c(paramOutputStream, i);
      }
    }
  }
  
  private void a(OutputStream paramOutputStream, z[] paramArrayOfz)
  {
    if (paramArrayOfz != null)
    {
      int j = paramArrayOfz.length;
      int i = 0;
      while (i < j)
      {
        z localz = paramArrayOfz[i];
        a(paramOutputStream, localz.a, false);
        a(paramOutputStream, localz.b, true);
        i += 1;
      }
    }
  }
  
  private static byte[] a(int paramInt, byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    if (k >= 128) {
      return null;
    }
    byte[] arrayOfByte = new byte[(k + 1) / 2];
    int j = 0;
    label26:
    if (j < k)
    {
      int i = paramArrayOfByte[j];
      switch (paramInt)
      {
      default: 
        i = -1;
      }
      while (i != -1)
      {
        int m = j / 2;
        int n = arrayOfByte[m];
        arrayOfByte[m] = ((byte)((byte)(i << (1 - j % 2) * 4) | n));
        j += 1;
        break label26;
        switch (i)
        {
        case 47: 
        default: 
          i = -1;
          break;
        case 48: 
        case 49: 
        case 50: 
        case 51: 
        case 52: 
        case 53: 
        case 54: 
        case 55: 
        case 56: 
        case 57: 
          i -= 48;
          break;
        case 45: 
        case 46: 
          i = i - 45 + 10;
          continue;
          switch (i)
          {
          case 58: 
          case 59: 
          case 60: 
          case 61: 
          case 62: 
          case 63: 
          case 64: 
          default: 
            i = -1;
            break;
          case 48: 
          case 49: 
          case 50: 
          case 51: 
          case 52: 
          case 53: 
          case 54: 
          case 55: 
          case 56: 
          case 57: 
            i -= 48;
            break;
          case 65: 
          case 66: 
          case 67: 
          case 68: 
          case 69: 
          case 70: 
            i = i - 65 + 10;
          }
          break;
        }
      }
    }
    if (k % 2 == 1)
    {
      paramInt = arrayOfByte.length - 1;
      arrayOfByte[paramInt] = ((byte)(arrayOfByte[paramInt] | 0xF));
    }
    return arrayOfByte;
  }
  
  private static void b(OutputStream paramOutputStream, int paramInt)
  {
    if (paramInt == 0)
    {
      paramOutputStream.write(0);
      return;
    }
    if (paramInt < 256)
    {
      paramOutputStream.write(248);
      c(paramOutputStream, paramInt);
      return;
    }
    if (paramInt < 65536)
    {
      paramOutputStream.write(249);
      if ((paramInt < 0) || (paramInt >= 65536)) {
        throw new IOException("value out of range; value=" + paramInt);
      }
      paramOutputStream.write(paramInt >> 8 & 0xFF);
      paramOutputStream.write(paramInt & 0xFF);
      return;
    }
    throw new IOException("list too long; count=" + paramInt);
  }
  
  private static void c(OutputStream paramOutputStream, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= 256)) {
      throw new IOException("value out of range; value=" + paramInt);
    }
    paramOutputStream.write(paramInt & 0xFF);
  }
  
  public final void a()
  {
    Object localObject = new ByteArrayOutputStream();
    ((ByteArrayOutputStream)localObject).write(0);
    b((OutputStream)localObject, 1);
    ((ByteArrayOutputStream)localObject).write(2);
    localObject = ((ByteArrayOutputStream)localObject).toByteArray();
    this.a.a((byte[])localObject, localObject.length);
    this.a.a();
  }
  
  public final void a(ak paramak)
  {
    a(paramak, 1);
  }
  
  public final void a(ak paramak, int paramInt)
  {
    int i;
    if ((paramInt & 0x1) != 0)
    {
      i = 1;
      if ((paramInt & 0x2) == 0) {
        break label102;
      }
      paramInt = 1;
      label16:
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(8192);
      if (paramInt == 0) {
        localByteArrayOutputStream.write(0);
      }
      a(localByteArrayOutputStream, paramak);
      paramak = localByteArrayOutputStream.toByteArray();
      if (paramInt == 0) {
        break label107;
      }
      paramak = az.a(paramak, paramak.length, new byte[] { s.a });
    }
    label102:
    label107:
    for (;;)
    {
      this.a.a(paramak, paramak.length);
      if (i != 0) {
        this.a.a();
      }
      return;
      i = 0;
      break;
      paramInt = 0;
      break label16;
    }
  }
  
  public final byte[] b(ak paramak)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(8192);
    a(localByteArrayOutputStream, paramak);
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */