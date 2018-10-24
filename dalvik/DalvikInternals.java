package com.whatsapp.dalvik;

import android.os.Build.VERSION;
import java.io.File;

public class DalvikInternals
{
  private static boolean a = false;
  
  static
  {
    try
    {
      System.loadLibrary("wa_dalvik");
      a = true;
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError) {}
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public static long b()
  {
    Object localObject = b.a(new File("/proc/self/maps"));
    long[] arrayOfLong = ((b)localObject).a().b();
    int i;
    switch (Build.VERSION.SDK_INT)
    {
    default: 
      i = 0;
    }
    b.a locala;
    for (;;)
    {
      locala = ((b)localObject).a("LinearAlloc");
      if (locala != null) {
        break;
      }
      throw new IllegalStateException("Could not find LinearAlloc memory mapping.");
      i = 20;
      continue;
      i = 24;
    }
    long l3 = 0L;
    long l4 = 0L;
    localObject = ((b)localObject).a("[heap]");
    long l2 = l3;
    long l1 = l4;
    if (localObject != null)
    {
      l2 = l3;
      l1 = l4;
      if (((b.a)localObject).c)
      {
        l2 = ((b.a)localObject).a;
        l1 = ((b.a)localObject).b;
      }
    }
    return nativeFindLinearAllocHeader(arrayOfLong, 704, 1480, i, 3, 524288, 16777216, l2, l1, 5242880, 16777216, 4100, locala.a);
  }
  
  public static native int getLinearAllocSize(long paramLong);
  
  public static native int getLinearAllocUsage(long paramLong);
  
  private static native long nativeFindLinearAllocHeader(long[] paramArrayOfLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2, int paramInt7, int paramInt8, int paramInt9, long paramLong3);
  
  public static native void replaceLinearAllocBuffer(long paramLong, int paramInt1, int paramInt2);
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/dalvik/DalvikInternals.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */