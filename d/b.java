package com.whatsapp.d;

import android.support.design.widget.AppBarLayout.Behavior.a;
import com.whatsapp.util.Log;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;

public final class b
  extends InputStream
{
  private final a a;
  private final Cipher b;
  private final Mac c;
  private InputStream d = null;
  
  public b(InputStream paramInputStream, d paramd, long paramLong)
  {
    this.a = new a(paramInputStream, new b(paramLong), (byte)0);
    this.b = AppBarLayout.Behavior.a.a(paramd.c, paramd.a, 2);
    this.c = AppBarLayout.Behavior.a.b(paramd.c, paramd.b);
  }
  
  private int a()
  {
    try
    {
      arrayOfByte = new byte[10];
      locala = this.a;
      i = 0;
    }
    catch (IllegalBlockSizeException localIllegalBlockSizeException)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        a locala;
        int i;
        int j;
        Log.w(localIllegalBlockSizeException);
        throw new IOException("Bad block size!");
        i += j;
      }
      if (!MessageDigest.isEqual(localIllegalBlockSizeException, a.a.a.a.d.b(this.c.doFinal(), 10))) {
        break label107;
      }
      this.d = new ByteArrayInputStream(this.b.doFinal());
      return 0;
      throw new IOException("Bad MAC!");
    }
    catch (BadPaddingException localBadPaddingException)
    {
      label107:
      Log.w(localBadPaddingException);
      throw new IOException("Bad padding!");
    }
    if (i < 10)
    {
      j = locala.read(arrayOfByte, i, 10 - i);
      if (j == -1) {
        throw new IOException("Stream unexpectedly closed!");
      }
    }
  }
  
  public final void close()
  {
    this.a.close();
  }
  
  public final int read()
  {
    byte[] arrayOfByte = new byte[1];
    int i;
    do
    {
      i = read(arrayOfByte, 0, 1);
      if (i == -1) {
        return -1;
      }
    } while (i == 0);
    return arrayOfByte[0];
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.d != null) {}
    for (int i = this.d.read(paramArrayOfByte, paramInt1, paramInt2); i > 0; i = -1) {
      return i;
    }
    if (this.a.a() == b.b.a.a)
    {
      Object localObject = this.a;
      b localb = this.a.a;
      i = ((a)localObject).read(paramArrayOfByte, paramInt1, (int)Math.min(localb.a - 10L - localb.b, paramInt2));
      if (i == -1) {
        throw new IOException("Stream unexpectedly closed!");
      }
      this.c.update(paramArrayOfByte, paramInt1, i);
      localObject = this.b.update(paramArrayOfByte, paramInt1, i);
      if ((localObject != null) && (localObject.length > paramInt2))
      {
        localObject = a.a.a.a.d.c((byte[])localObject, paramInt2, localObject.length - paramInt2);
        System.arraycopy(localObject[0], 0, paramArrayOfByte, paramInt1, localObject[0].length);
        this.d = new ByteArrayInputStream(localObject[1]);
        return localObject[0].length;
      }
      if (localObject != null)
      {
        System.arraycopy(localObject, 0, paramArrayOfByte, paramInt1, localObject.length);
        return localObject.length;
      }
      return 0;
    }
    if (this.a.a() == b.b.a.b) {
      return a();
    }
    return -1;
  }
  
  static final class a
    extends InputStream
  {
    final b.b a;
    private final InputStream b;
    
    private a(InputStream paramInputStream, b.b paramb)
    {
      this.b = paramInputStream;
      this.a = paramb;
    }
    
    public final int a()
    {
      b.b localb = this.a;
      if (localb.b < localb.a - 10L) {
        return b.b.a.a;
      }
      if (localb.b == localb.a - 10L) {
        return b.b.a.b;
      }
      return b.b.a.c;
    }
    
    public final void close()
    {
      this.b.close();
    }
    
    public final int read()
    {
      throw new AssertionError("NYI");
    }
    
    public final int read(byte[] paramArrayOfByte)
    {
      return read(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      paramInt1 = this.b.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 > 0)
      {
        paramArrayOfByte = this.a;
        paramArrayOfByte.b = (paramInt1 + paramArrayOfByte.b);
      }
      return paramInt1;
    }
  }
  
  static final class b
  {
    final long a;
    long b;
    
    public b(long paramLong)
    {
      this.a = paramLong;
      this.b = 0L;
    }
    
    static enum a {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */