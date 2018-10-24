package com.whatsapp;

import com.whatsapp.proto.d.c.d;

public final class av
{
  private static final int a;
  private static final int b = 2;
  
  static
  {
    int j = -1;
    String str = au.c();
    label60:
    int i;
    switch (str.hashCode())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalStateException("Invalid build type");
        if (!str.equals("debug")) {
          break label60;
        }
        i = 0;
        continue;
        if (!str.equals("fast")) {
          break label60;
        }
        i = 1;
        continue;
        if (!str.equals("alpha")) {
          break label60;
        }
        i = 2;
        continue;
        if (!str.equals("beta")) {
          break label60;
        }
        i = 3;
        continue;
        if (!str.equals("release")) {
          break label60;
        }
        i = 4;
      }
    }
    a = 3;
    label180:
    str = au.e();
    switch (str.hashCode())
    {
    default: 
      i = j;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new IllegalStateException("Invalid distribution flavor");
        a = 2;
        break label180;
        a = 1;
        break label180;
        a = 0;
        break label180;
        i = j;
        if (str.equals("play"))
        {
          i = 0;
          continue;
          i = j;
          if (str.equals("lolli"))
          {
            i = 1;
            continue;
            i = j;
            if (str.equals("website"))
            {
              i = 2;
              continue;
              i = j;
              if (str.equals("automation")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    b = 0;
    return;
    b = 1;
    return;
  }
  
  public static int a()
  {
    switch (a)
    {
    default: 
      return 5;
    case 0: 
      return 3;
    }
    return 4;
  }
  
  public static d.c.d b()
  {
    switch (a)
    {
    default: 
      return null;
    case 2: 
      return d.c.d.c;
    case 1: 
      return d.c.d.b;
    }
    return d.c.d.d;
  }
  
  public static int[] c()
  {
    switch (a)
    {
    default: 
      return new int[] { 1, 2, 3 };
    case 0: 
      return new int[] { 1, 2, 3, 5, 14, 30 };
    }
    return new int[] { 1, 2, 3, 7 };
  }
  
  public static boolean d()
  {
    return a == 3;
  }
  
  public static boolean e()
  {
    return a == 0;
  }
  
  public static boolean f()
  {
    return b == 1;
  }
  
  public static boolean g()
  {
    return b == 0;
  }
  
  public static boolean h()
  {
    return a == 2;
  }
  
  public static boolean i()
  {
    return a == 1;
  }
  
  public static boolean j()
  {
    return b == 2;
  }
  
  public static boolean k()
  {
    return a > 0;
  }
  
  public static boolean l()
  {
    return a >= 2;
  }
  
  public static boolean m()
  {
    return a <= 2;
  }
  
  public static Integer n()
  {
    switch (a)
    {
    default: 
      return null;
    case 0: 
      return Integer.valueOf(4);
    case 1: 
      return Integer.valueOf(3);
    case 2: 
      return Integer.valueOf(2);
    }
    return Integer.valueOf(1);
  }
  
  public static Integer o()
  {
    switch (b)
    {
    default: 
      return null;
    case 0: 
      return Integer.valueOf(2);
    case 1: 
      return Integer.valueOf(1);
    }
    return Integer.valueOf(3);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/av.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */