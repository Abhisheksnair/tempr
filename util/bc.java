package com.whatsapp.util;

import android.content.res.Resources;
import android.util.Pair;
import java.lang.reflect.Field;

public final class bc
{
  private static boolean a;
  private static int b;
  private static int c;
  private static int d;
  private static int e;
  private static int f;
  private static int g;
  
  static
  {
    try
    {
      b = a("byteShort");
      c = a("kilobyteShort");
      d = a("megabyteShort");
      e = a("gigabyteShort");
      f = a("terabyteShort");
      g = a("petabyteShort");
      a = true;
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      a = false;
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      a = false;
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      a = false;
    }
  }
  
  private static int a(String paramString)
  {
    return Class.forName("com.android.internal.R$string").getDeclaredField(paramString).getInt(null);
  }
  
  public static long a(long paramLong)
  {
    float f2 = (float)paramLong;
    paramLong = 1L;
    float f1 = f2;
    if (f2 > 900.0F)
    {
      paramLong = 1024L;
      f1 = f2 / 1024.0F;
    }
    f2 = f1;
    if (f1 > 900.0F)
    {
      paramLong = 1048576L;
      f2 = f1 / 1024.0F;
    }
    f1 = f2;
    if (f2 > 900.0F)
    {
      paramLong = 1073741824L;
      f1 = f2 / 1024.0F;
    }
    f2 = f1;
    if (f1 > 900.0F)
    {
      paramLong = 1099511627776L;
      f2 = f1 / 1024.0F;
    }
    if (f2 > 900.0F) {
      paramLong = 1125899906842624L;
    }
    return paramLong;
  }
  
  public static Pair<Float, String> a(long paramLong1, long paramLong2)
  {
    float f1 = (float)paramLong1 / (float)paramLong2;
    String str;
    if (f1 < 1.0F) {
      str = "%.2f";
    }
    for (;;)
    {
      return new Pair(Float.valueOf(f1), String.format(str, new Object[] { Float.valueOf(f1) }));
      if (f1 < 10.0F) {
        str = "%.1f";
      } else {
        str = "%.0f";
      }
    }
  }
  
  public static a a(Resources paramResources, long paramLong)
  {
    if (!a) {
      return null;
    }
    float f2 = (float)paramLong;
    int i = b;
    float f1 = f2;
    if (f2 > 900.0F)
    {
      i = c;
      f1 = f2 / 1024.0F;
    }
    f2 = f1;
    if (f1 > 900.0F)
    {
      i = d;
      f2 = f1 / 1024.0F;
    }
    f1 = f2;
    if (f2 > 900.0F)
    {
      i = e;
      f1 = f2 / 1024.0F;
    }
    f2 = f1;
    if (f1 > 900.0F)
    {
      i = f;
      f2 = f1 / 1024.0F;
    }
    if (f2 > 900.0F) {
      i = g;
    }
    for (f1 = f2 / 1024.0F;; f1 = f2)
    {
      String str;
      if (f1 < 1.0F) {
        str = "%.2f";
      }
      for (;;)
      {
        return new a(String.format(str, new Object[] { Float.valueOf(f1) }), paramResources.getString(i));
        if (f1 < 10.0F) {
          str = "%.1f";
        } else {
          str = "%.0f";
        }
      }
    }
  }
  
  public static final class a
  {
    public final String a;
    public final String b;
    public final long c;
    
    public a(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = 0L;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */