package com.whatsapp;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;
import pl.droidsonroids.gif.a;

public final class pi
{
  public a a;
  
  public pi(String paramString)
  {
    this.a = new a(paramString);
  }
  
  public final int a(int paramInt)
  {
    return this.a.b(paramInt);
  }
  
  public final void a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject2 = this.a.a(paramInt1);
    Object localObject1 = new int[paramInt2 * paramInt3];
    ((Bitmap)localObject2).getPixels((int[])localObject1, 0, paramInt2, 0, 0, paramInt2, paramInt3);
    localObject2 = new byte[localObject1.length * 3];
    paramInt1 = 0;
    while (paramInt1 < localObject1.length)
    {
      int m = localObject1[paramInt1];
      int i = (byte)(m >> 16);
      int j = (byte)(m >> 8);
      int k = (byte)m;
      m = paramInt1 * 3;
      localObject2[m] = i;
      localObject2[(m + 1)] = j;
      localObject2[(m + 2)] = k;
      paramInt1 += 1;
    }
    localObject1 = new byte[paramInt2 * 3 * paramInt3];
    paramInt1 = paramInt3 - 1;
    paramInt3 = 0;
    while (paramInt1 >= 0)
    {
      System.arraycopy(localObject2, paramInt1 * 3 * paramInt2, localObject1, paramInt3, paramInt2 * 3);
      paramInt3 += paramInt2 * 3;
      paramInt1 -= 1;
    }
    paramByteBuffer.put((byte[])localObject1);
    paramByteBuffer.position(0);
  }
  
  public static final class a
  {
    public final int a;
    public final int b;
    
    public a(int paramInt1, int paramInt2)
    {
      this.a = paramInt1;
      this.b = paramInt2;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/pi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */