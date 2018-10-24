package com.whatsapp.dalvik;

import android.util.Log;
import java.io.IOException;

public final class a
{
  private static String a = "";
  private static int b = 2;
  
  public static int a()
  {
    return b;
  }
  
  public static String b()
  {
    if (b == 1) {
      return a;
    }
    throw new IllegalStateException("No failure string is provided when the operation did not fail.");
  }
  
  public static void c()
  {
    if (b != 2)
    {
      Log.e("DalvikReplaceBuffer", "Multiple attempts to replace the buffer detected!");
      return;
    }
    if (!DalvikInternals.a())
    {
      b = 3;
      return;
    }
    long l;
    try
    {
      l = DalvikInternals.b();
      if (l == 0L) {
        throw new IOException("Failed to find LinearAllocHdr.");
      }
    }
    catch (IOException localIOException)
    {
      b = 1;
      a = localIOException.getMessage();
      Log.e("DalvikReplaceBuffer", "Failed to replace LinearAlloc buffer (at size 8388608). Continuing with standard buffer.", localIOException);
      return;
    }
    DalvikInternals.replaceLinearAllocBuffer(l, 8388608, 4096);
    b = 0;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/dalvik/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */