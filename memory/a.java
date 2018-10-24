package com.whatsapp.memory;

import android.app.ActivityManager;
import android.os.Build;
import com.whatsapp.and;
import com.whatsapp.util.Log;

public final class a
{
  private static final String[] a = { "GT-N7100", "GT-I9305" };
  private static Boolean b;
  private static int c = -1;
  
  public static int a()
  {
    return c;
  }
  
  public static int a(and paramand)
  {
    paramand = paramand.b;
    if (paramand == null)
    {
      Log.w("memoryclassprovider am=null");
      return 16;
    }
    c = paramand.getMemoryClass();
    return paramand.getMemoryClass();
  }
  
  public static boolean b()
  {
    boolean bool = true;
    if (b == null)
    {
      String[] arrayOfString = a;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (Build.MODEL.equals(str))
        {
          b = Boolean.valueOf(true);
          return true;
        }
        i += 1;
      }
      i = c;
      if (i < 0) {
        return false;
      }
      if (i > 48) {
        break label84;
      }
    }
    for (;;)
    {
      b = Boolean.valueOf(bool);
      return b.booleanValue();
      label84:
      bool = false;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/memory/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */