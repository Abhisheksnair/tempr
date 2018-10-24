package com.whatsapp.k;

import android.os.Process;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class g
{
  private static final String a = g.class.getSimpleName();
  private static final int[] b = { 4096 };
  private static volatile Method c = null;
  private static volatile boolean d = false;
  
  public static String a(String paramString)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = null;
    a(paramString, b, arrayOfString);
    return arrayOfString[0];
  }
  
  private static Method a()
  {
    try
    {
      Method localMethod = Process.class.getMethod("readProcFile", new Class[] { String.class, int[].class, String[].class, long[].class, float[].class });
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
    return null;
  }
  
  private static boolean a(String paramString, int[] paramArrayOfInt, String[] paramArrayOfString)
  {
    if (!d)
    {
      c = a();
      d = true;
    }
    Method localMethod = c;
    if (localMethod == null) {
      return false;
    }
    try
    {
      paramString = localMethod.invoke(null, new Object[] { paramString, paramArrayOfInt, paramArrayOfString, null, null });
      if (paramString == null) {
        return false;
      }
      boolean bool = ((Boolean)paramString).booleanValue();
      return bool;
    }
    catch (InvocationTargetException paramString)
    {
      return false;
    }
    catch (IllegalAccessException paramString)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/k/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */