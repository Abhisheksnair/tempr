package com.whatsapp.protocol;

import java.io.Writer;

public final class ay
  implements ao
{
  private static final String[] a = { "body", "message" };
  private static final String[] b = { "name", "short" };
  private static final String[] c = { "user", "chat" };
  private final Writer d;
  
  public ay(Writer paramWriter)
  {
    this.d = paramWriter;
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    if (i < j)
    {
      int k = paramArrayOfByte[i];
      if ((k < 33) || (k == 37) || (k > 126))
      {
        localStringBuilder.append('%');
        String str = Integer.toHexString(k & 0xFF);
        if (str.length() == 1) {
          localStringBuilder.append('0');
        }
        localStringBuilder.append(str);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append((char)k);
      }
    }
    this.d.write(localStringBuilder.toString());
  }
  
  private void c(ak paramak)
  {
    int n = 0;
    int m = 0;
    this.d.write(60);
    this.d.write(paramak.a);
    String str;
    Object localObject;
    int j;
    label107:
    int k;
    if (paramak.b != null)
    {
      i = 0;
      if (i < paramak.b.length)
      {
        this.d.write(32);
        this.d.write(paramak.b[i].a);
        this.d.write("='");
        str = paramak.a;
        localObject = paramak.b[i].a;
        String[] arrayOfString1 = c;
        int i1 = arrayOfString1.length;
        j = 0;
        if (j < i1) {
          if (arrayOfString1[j].equals(str))
          {
            String[] arrayOfString2 = b;
            int i2 = arrayOfString2.length;
            k = 0;
            label138:
            if (k < i2) {
              if (arrayOfString2[k].equals(localObject))
              {
                j = 1;
                label160:
                if (j == 0) {
                  break label210;
                }
                this.d.write("{{CONTENTS ELIDED}}");
              }
            }
          }
        }
        for (;;)
        {
          this.d.write(39);
          i += 1;
          break;
          k += 1;
          break label138;
          j += 1;
          break label107;
          j = 0;
          break label160;
          label210:
          a(paramak.b[i].b.getBytes());
        }
      }
    }
    if ((paramak.d == null) && (paramak.c == null))
    {
      this.d.write("/>");
      return;
    }
    if (paramak.d != null)
    {
      this.d.write(62);
      str = paramak.a;
      localObject = a;
      k = localObject.length;
      i = 0;
      j = m;
      if (i < k)
      {
        if (localObject[i].equals(str)) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break label360;
        }
        this.d.write("{{CONTENTS ELIDED}}");
      }
      for (;;)
      {
        this.d.write("</");
        this.d.write(paramak.a);
        this.d.write(62);
        return;
        i += 1;
        break;
        label360:
        a(paramak.d);
      }
    }
    this.d.write(62);
    int i = n;
    while (i < paramak.c.length)
    {
      c(paramak.c[i]);
      i += 1;
    }
    this.d.write("</");
    this.d.write(paramak.a);
    this.d.write(62);
  }
  
  public final void a()
  {
    try
    {
      this.d.write("</stream:stream>");
      this.d.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(ak paramak)
  {
    try
    {
      a(paramak, 1);
      return;
    }
    finally
    {
      paramak = finally;
      throw paramak;
    }
  }
  
  public final void a(ak paramak, int paramInt)
  {
    if (paramak == null) {}
    for (;;)
    {
      try
      {
        this.d.write(32);
        if ((paramInt & 0x1) != 0) {
          this.d.flush();
        }
        return;
      }
      finally {}
      c(paramak);
    }
  }
  
  public final byte[] b(ak paramak)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */