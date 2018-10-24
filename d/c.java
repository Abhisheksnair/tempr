package com.whatsapp.d;

import android.support.design.widget.AppBarLayout.Behavior.a;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;

public final class c
  extends InputStream
{
  private final InputStream a;
  private final Cipher b;
  private final Mac c;
  private boolean d;
  private ByteArrayInputStream e;
  
  public c(InputStream paramInputStream, d paramd)
  {
    this.a = paramInputStream;
    this.b = AppBarLayout.Behavior.a.a(paramd.c, paramd.a, 1);
    this.c = AppBarLayout.Behavior.a.b(paramd.c, paramd.b);
  }
  
  public final void close()
  {
    this.a.close();
  }
  
  public final int read()
  {
    byte[] arrayOfByte = new byte[1];
    for (;;)
    {
      int i = read(arrayOfByte, 0, 1);
      if (i == -1) {
        return -1;
      }
      if (i != 0) {
        return arrayOfByte[0];
      }
      Thread.yield();
    }
  }
  
  public final int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.e != null)
    {
      i = this.e.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i > 0) {
        return i;
      }
      this.e = null;
      if (this.d) {
        return -1;
      }
    }
    int i = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
    Object localObject;
    if (i == -1) {
      localObject = ByteBuffer.allocate(42);
    }
    try
    {
      byte[] arrayOfByte = this.b.doFinal();
      ((ByteBuffer)localObject).put(arrayOfByte);
      ((ByteBuffer)localObject).put(a.a.a.a.d.b(this.c.doFinal(arrayOfByte), 10));
      ((ByteBuffer)localObject).flip();
      arrayOfByte = new byte[((ByteBuffer)localObject).remaining()];
      ((ByteBuffer)localObject).get(arrayOfByte);
      this.e = new ByteArrayInputStream(arrayOfByte);
      this.d = true;
      return this.e.read(paramArrayOfByte, paramInt1, paramInt2);
    }
    catch (BadPaddingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
      if (i > 0)
      {
        localObject = this.b.update(paramArrayOfByte, paramInt1, i);
        if (localObject == null) {
          return 0;
        }
        this.c.update((byte[])localObject);
        if (localObject.length <= paramInt2)
        {
          System.arraycopy(localObject, 0, paramArrayOfByte, paramInt1, localObject.length);
          return localObject.length;
        }
        System.arraycopy(localObject, 0, paramArrayOfByte, paramInt1, paramInt2);
        this.e = new ByteArrayInputStream((byte[])localObject, paramInt2, localObject.length - paramInt2);
        return paramInt2;
      }
      return i;
    }
    catch (IllegalBlockSizeException paramArrayOfByte)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */