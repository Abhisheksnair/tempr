package com.whatsapp.protocol;

public final class f
{
  public final int a;
  public final int b;
  public final byte[] c;
  
  public f(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramArrayOfByte;
  }
  
  public static f a(ak paramak)
  {
    String str = paramak.a("v", null);
    if (("1".equals(str)) || ("2".equals(str)))
    {
      int j = Integer.parseInt(str);
      str = paramak.a("type", null);
      int i;
      if ("msg".equals(str)) {
        i = 0;
      }
      for (;;)
      {
        return new f(j, i, paramak.d);
        if ("pkmsg".equals(str))
        {
          i = 1;
        }
        else if ("skmsg".equals(str))
        {
          i = 2;
        }
        else
        {
          if (!"frskmsg".equals(str)) {
            break;
          }
          i = 3;
        }
      }
      throw new c("invalid encrypted node type provided: " + str);
    }
    throw new c("invalid encrypted node version provided: " + str);
  }
  
  public static f a(byte[] paramArrayOfByte)
  {
    int j = 0;
    int i = 8;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 8)) {
      return null;
    }
    int k = paramArrayOfByte[0];
    int m = paramArrayOfByte[1];
    int n = paramArrayOfByte[2];
    int i1 = paramArrayOfByte[3];
    int i2 = paramArrayOfByte[4];
    int i3 = paramArrayOfByte[5];
    int i4 = paramArrayOfByte[6];
    int i5 = paramArrayOfByte[7];
    if (paramArrayOfByte.length == 8) {}
    for (byte[] arrayOfByte = null; arrayOfByte != null; arrayOfByte = new byte[paramArrayOfByte.length - 8]) {
      while (j < arrayOfByte.length)
      {
        arrayOfByte[j] = paramArrayOfByte[i];
        j += 1;
        i += 1;
      }
    }
    return new f(i1 & 0xFF | (k & 0xFF) << 24 | (m & 0xFF) << 16 | (n & 0xFF) << 8, i5 & 0xFF | (i2 & 0xFF) << 24 | (i3 & 0xFF) << 16 | (i4 & 0xFF) << 8, arrayOfByte);
  }
  
  public static byte[] a(f paramf)
  {
    int j = 8;
    if (paramf == null) {
      return null;
    }
    if (paramf.c == null) {}
    byte[] arrayOfByte;
    for (int i = 8;; i = paramf.c.length + 8)
    {
      arrayOfByte = new byte[i];
      arrayOfByte[0] = (paramf.a >> 24);
      arrayOfByte[1] = ((byte)(paramf.a >> 16));
      arrayOfByte[2] = ((byte)(paramf.a >> 8));
      arrayOfByte[3] = ((byte)paramf.a);
      arrayOfByte[4] = (paramf.b >> 24);
      arrayOfByte[5] = ((byte)(paramf.b >> 16));
      arrayOfByte[6] = ((byte)(paramf.b >> 8));
      arrayOfByte[7] = ((byte)paramf.b);
      if (paramf.c == null) {
        break;
      }
      int k = 0;
      i = j;
      j = k;
      while (j < paramf.c.length)
      {
        arrayOfByte[i] = paramf.c[j];
        j += 1;
        i += 1;
      }
    }
    return arrayOfByte;
  }
  
  public final String toString()
  {
    return "EncryptedMessage{ciphertextVersion=" + this.a + ", ciphertextType=" + this.b + '}';
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */