package com.whatsapp.d;

import a.a.a.a.a.a.d;
import android.support.design.widget.AppBarLayout.Behavior.a;
import com.whatsapp.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;

public final class e
{
  private final RandomAccessFile a;
  private final RandomAccessFile b;
  private final d c;
  private final byte[] d;
  private final long e;
  
  public e(File paramFile1, File paramFile2, byte[] paramArrayOfByte, d paramd, long paramLong)
  {
    this.a = new RandomAccessFile(paramFile1, "r");
    this.b = new RandomAccessFile(paramFile2, "rw");
    this.c = paramd;
    this.d = paramArrayOfByte;
    this.e = (paramLong - 10L);
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = this.a.read(paramArrayOfByte, i, paramInt - i);
      if (j == -1) {
        throw new IOException("Stream unexpectedly closed!");
      }
      i += j;
    }
  }
  
  public final long a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.b.seek(paramLong1);
    Mac localMac;
    Object localObject;
    if (paramLong1 == 0L)
    {
      localMac = AppBarLayout.Behavior.a.b(this.c.c, this.c.b);
      localObject = AppBarLayout.Behavior.a.a(this.c.c, this.c.a);
      this.a.seek(0L);
    }
    long l1;
    int i;
    for (;;)
    {
      byte[] arrayOfByte1 = new byte[' '];
      long l2 = paramLong2;
      l1 = 0L;
      for (;;)
      {
        if (l2 <= 0L) {
          break label354;
        }
        int j = (int)Math.min(l2, 8192L);
        long l3 = l2 - j;
        a(arrayOfByte1, j);
        localMac.update(arrayOfByte1, 0, j);
        i = j;
        if (paramLong2 - l3 + paramLong1 > this.e) {
          i = (int)(j - (paramLong2 - l3 + paramLong1 - this.e));
        }
        l2 = l3;
        if (i > 0)
        {
          a.d.a(localObject, "cipher should not be null");
          byte[] arrayOfByte2 = ((Cipher)localObject).update(arrayOfByte1, 0, i);
          if (arrayOfByte2 == null) {
            break;
          }
          l2 = arrayOfByte2.length;
          this.b.write(arrayOfByte2, 0, arrayOfByte2.length);
          l1 = l2 + l1;
          l2 = l3;
        }
      }
      localObject = new byte[16];
      this.a.seek(paramLong1 - 16L);
      if (this.a.read((byte[])localObject, 0, 16) == 16) {}
      for (boolean bool = true;; bool = false)
      {
        a.d.a(bool);
        localMac = AppBarLayout.Behavior.a.b((byte[])localObject, this.c.b);
        if (paramLong1 < this.e) {
          break label298;
        }
        localObject = null;
        break;
      }
      label298:
      if (paramLong1 + paramLong2 > this.e) {
        localObject = AppBarLayout.Behavior.a.a((byte[])localObject, this.c.a, 2);
      } else {
        localObject = AppBarLayout.Behavior.a.a((byte[])localObject, this.c.a);
      }
    }
    throw new IOException("decryption failed");
    label354:
    if ((paramBoolean) && (localObject != null)) {}
    try
    {
      localObject = ((Cipher)localObject).doFinal();
      this.b.write((byte[])localObject);
      this.b.getFD().sync();
      localObject = a.a.a.a.d.b(localMac.doFinal(), 10);
      i = (int)(10L * paramLong1 / 65536L);
      if (!MessageDigest.isEqual(Arrays.copyOfRange(this.d, i, i + 10), (byte[])localObject))
      {
        Log.e("RandomAccessCipherDecrypter/match failed at byte_offset=" + paramLong1 + ", end_of_file=" + paramBoolean);
        throw new a();
      }
    }
    catch (IllegalBlockSizeException localIllegalBlockSizeException)
    {
      Log.w(localIllegalBlockSizeException);
      throw new IOException("Bad block size!");
    }
    catch (BadPaddingException localBadPaddingException)
    {
      Log.w(localBadPaddingException);
      throw new IOException("Bad padding!");
    }
    return l1;
  }
  
  public final void a()
  {
    long l = this.a.length() - 10L;
    byte[] arrayOfByte = new byte[' '];
    Object localObject = AppBarLayout.Behavior.a.b(this.c.c, this.c.b);
    this.a.seek(0L);
    while (l > 0L)
    {
      int i = (int)Math.min(l, 8192L);
      a(arrayOfByte, i);
      ((Mac)localObject).update(arrayOfByte, 0, i);
      l -= i;
    }
    arrayOfByte = a.a.a.a.d.b(((Mac)localObject).doFinal(), 10);
    localObject = new byte[10];
    a((byte[])localObject, 10);
    if (!MessageDigest.isEqual(arrayOfByte, (byte[])localObject))
    {
      Log.e("RandomAccessCipherDecrypter/full file validation failed");
      throw new a();
    }
  }
  
  public final void b()
  {
    if (this.a != null) {}
    try
    {
      this.a.close();
      if (this.b == null) {}
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        try
        {
          this.b.close();
          return;
        }
        catch (IOException localIOException2)
        {
          Log.w("RandomAccessCipherDecrypter/chunk aware decrypter output close failed");
        }
        localIOException1 = localIOException1;
        Log.w("RandomAccessCipherDecrypter/chunk aware decrypter input close failed");
      }
    }
  }
  
  public static final class a
    extends Exception
  {}
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */