package com.whatsapp.d;

import a.a.a.a.a.a.d;
import android.support.design.widget.AppBarLayout.Behavior.a;
import com.whatsapp.util.Log;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Mac;

public final class a
  extends FilterInputStream
{
  public a a;
  private final d b;
  private final int c = 65536;
  private final int d = 10;
  private final List<byte[]> e;
  private Mac f;
  private final byte[] g;
  private final b h = new b();
  private boolean i = false;
  private int j = 0;
  
  public a(InputStream paramInputStream, d paramd)
  {
    super(paramInputStream);
    this.b = paramd;
    this.e = new ArrayList();
    this.f = AppBarLayout.Behavior.a.b(paramd.c, paramd.b);
    this.g = new byte[' '];
    this.a = new a();
  }
  
  private Mac a(byte[] paramArrayOfByte)
  {
    return AppBarLayout.Behavior.a.b(paramArrayOfByte, this.b.b);
  }
  
  private byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte1 = new byte[16];
    if (paramInt < 16)
    {
      b localb = this.h;
      int i1 = 16 - paramInt;
      if (i1 <= localb.d) {}
      byte[] arrayOfByte2;
      for (boolean bool = true;; bool = false)
      {
        a.d.a(bool);
        arrayOfByte2 = new byte[i1];
        int k = 0;
        while (k < i1)
        {
          int n = localb.c - i1 + k;
          int m = n;
          if (n < 0) {
            m = n + localb.b;
          }
          arrayOfByte2[k] = localb.a[m];
          k += 1;
        }
      }
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 16 - paramInt);
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 16 - paramInt, paramInt);
      return arrayOfByte1;
    }
    System.arraycopy(paramArrayOfByte, paramInt - 16, arrayOfByte1, 0, 16);
    return arrayOfByte1;
  }
  
  public final void close()
  {
    super.close();
    if (this.j > 0)
    {
      byte[] arrayOfByte = a.a.a.a.d.b(this.f.doFinal(), this.d);
      this.e.add(arrayOfByte);
    }
    this.i = true;
  }
  
  public final int read()
  {
    byte[] arrayOfByte = new byte[1];
    int k;
    do
    {
      k = read(arrayOfByte, 0, 1);
      if (k == -1) {
        return -1;
      }
    } while (k == 0);
    return arrayOfByte[0];
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt2 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    Object localObject;
    if (paramInt2 > 0)
    {
      if (this.j + paramInt2 > this.c) {
        break label204;
      }
      this.j += paramInt2;
      this.f.update(paramArrayOfByte, 0, paramInt2);
      if (this.j == this.c)
      {
        this.j = 0;
        localObject = a.a.a.a.d.b(this.f.doFinal(), this.d);
        this.e.add(localObject);
        this.f = a(a(paramArrayOfByte, paramInt2));
      }
    }
    for (;;)
    {
      paramInt1 = Math.max(0, paramInt2 - 16);
      while (paramInt1 < paramInt2)
      {
        localObject = this.h;
        int k = paramArrayOfByte[paramInt1];
        if (((b)localObject).c >= ((b)localObject).b) {
          ((b)localObject).c = 0;
        }
        ((b)localObject).a[localObject.c] = k;
        ((b)localObject).c += 1;
        if (((b)localObject).d < ((b)localObject).b) {
          ((b)localObject).d += 1;
        }
        paramInt1 += 1;
      }
      label204:
      if (this.j + paramInt2 > this.c)
      {
        this.f.update(paramArrayOfByte, 0, this.c - this.j);
        localObject = a.a.a.a.d.b(this.f.doFinal(), this.d);
        this.e.add(localObject);
        this.f = a(a(paramArrayOfByte, this.c - this.j));
        this.f.update(paramArrayOfByte, this.c - this.j, paramInt2 - (this.c - this.j));
        this.j = (this.j + paramInt2 - this.c);
      }
    }
    return paramInt2;
  }
  
  public final long skip(long paramLong)
  {
    return read(this.g, 0, (int)Math.min(this.g.length, paramLong));
  }
  
  public final class a
  {
    public a() {}
    
    public final byte[] a()
    {
      if (!a.a(a.this))
      {
        Log.i("CipherSidecarGeneratorStreamFilter/stream not closed");
        return null;
      }
      byte[] arrayOfByte = new byte[a.b(a.this).size() * a.c(a.this)];
      Iterator localIterator = a.b(a.this).iterator();
      for (int i = 0; localIterator.hasNext(); i = a.c(a.this) + i) {
        System.arraycopy((byte[])localIterator.next(), 0, arrayOfByte, i, a.c(a.this));
      }
      return arrayOfByte;
    }
  }
  
  static final class b
  {
    public byte[] a = null;
    int b = 0;
    int c = 0;
    int d = 0;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */