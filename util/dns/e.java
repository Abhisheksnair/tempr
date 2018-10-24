package com.whatsapp.util.dns;

import a.a.a.a.d;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

final class e
{
  final String[] a;
  final short b;
  final int c;
  
  private e(String[] paramArrayOfString, short paramShort, int paramInt)
  {
    this.a = paramArrayOfString;
    this.b = paramShort;
    this.c = paramInt;
  }
  
  static e a(byte[] paramArrayOfByte, int paramInt)
  {
    short s = 0;
    if (paramArrayOfByte == null) {
      throw new NullPointerException("bytes may not be null");
    }
    if (paramArrayOfByte.length <= 0) {
      throw new IllegalArgumentException("insufficient data");
    }
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramInt;
    while ((paramArrayOfByte[i] != 0) && ((paramArrayOfByte[i] & 0xC0) == 0))
    {
      int j = (byte)(paramArrayOfByte[i] & 0x3F);
      int k = i + 1;
      if (paramArrayOfByte.length < k + j + 1) {
        throw new IllegalArgumentException("bytes is incomplete");
      }
      localStringBuilder.setLength(0);
      for (i = 0; i < j; i = (byte)(i + 1)) {
        localStringBuilder.append((char)paramArrayOfByte[(k + i)]);
      }
      i = k + j;
      localArrayList.add(localStringBuilder.toString());
    }
    if (paramArrayOfByte[i] == 0) {
      i += 1;
    }
    for (;;)
    {
      return new e((String[])localArrayList.toArray(new String[localArrayList.size()]), s, i - paramInt);
      s = d.a((byte)(paramArrayOfByte[i] & 0x3F), paramArrayOfByte[(i + 1)]);
      i += 2;
    }
  }
  
  static e a(String[] paramArrayOfString)
  {
    int k = paramArrayOfString.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      Object localObject = paramArrayOfString[i];
      try
      {
        localObject = ((String)localObject).getBytes("UTF-8");
        if (localObject.length > 63) {
          throw new IllegalStateException("token may not be longer than 63 bytes");
        }
      }
      catch (UnsupportedEncodingException paramArrayOfString)
      {
        throw new Error(paramArrayOfString);
      }
      j += localObject.length + 1;
      i += 1;
    }
    return new e(paramArrayOfString, (short)0, j + 1);
  }
  
  final void a(OutputStream paramOutputStream)
  {
    String[] arrayOfString = this.a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      byte[] arrayOfByte = arrayOfString[i].getBytes("UTF-8");
      if (arrayOfByte.length > 63) {
        throw new IllegalStateException("token may not be longer than 63 bytes");
      }
      paramOutputStream.write(arrayOfByte.length);
      paramOutputStream.write(arrayOfByte);
      i += 1;
    }
    if (this.b != 0)
    {
      paramOutputStream.write(this.b >>> 8 & 0x3F | 0xC0);
      paramOutputStream.write(this.b & 0xFF);
      return;
    }
    paramOutputStream.write(0);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/dns/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */