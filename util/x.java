package com.whatsapp.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.whatsapp.aus;
import com.whatsapp.data.ad.d;
import com.whatsapp.data.d;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class x
{
  private static a a;
  private static final a b = new b((byte)0);
  
  public static double a(aus paramaus, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0.0D;
    }
    return b(paramaus).a(paramString);
  }
  
  public static String a(Context paramContext, d paramd, aus paramaus, String paramString, int paramInt, Object... paramVarArgs)
  {
    if ((!a(paramaus)) || (paramString == null)) {
      return paramContext.getResources().getString(paramInt, paramVarArgs);
    }
    paramaus = b(paramaus);
    paramd = (ad.d)paramd.a.get(paramString);
    if (paramd == null) {}
    for (double d = 0.0D;; d = paramd.h)
    {
      paramd = paramaus.a(d, paramContext.getResources().getString(paramInt));
      return String.format(paramContext.getResources().getConfiguration().locale, paramd, paramVarArgs);
    }
  }
  
  public static void a()
  {
    try
    {
      a = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static boolean a(aus paramaus)
  {
    return b(paramaus) != b;
  }
  
  /* Error */
  private static a b(aus paramaus)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 95	com/whatsapp/util/x:a	Lcom/whatsapp/util/x$a;
    //   6: ifnonnull +26 -> 32
    //   9: ldc 97
    //   11: aload_0
    //   12: invokevirtual 103	com/whatsapp/aus:d	()Ljava/lang/String;
    //   15: invokevirtual 107	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifeq +23 -> 41
    //   21: new 12	com/whatsapp/util/x$c
    //   24: dup
    //   25: iconst_0
    //   26: invokespecial 108	com/whatsapp/util/x$c:<init>	(B)V
    //   29: putstatic 95	com/whatsapp/util/x:a	Lcom/whatsapp/util/x$a;
    //   32: getstatic 95	com/whatsapp/util/x:a	Lcom/whatsapp/util/x$a;
    //   35: astore_0
    //   36: ldc 2
    //   38: monitorexit
    //   39: aload_0
    //   40: areturn
    //   41: getstatic 24	com/whatsapp/util/x:b	Lcom/whatsapp/util/x$a;
    //   44: putstatic 95	com/whatsapp/util/x:a	Lcom/whatsapp/util/x$a;
    //   47: goto -15 -> 32
    //   50: astore_0
    //   51: ldc 2
    //   53: monitorexit
    //   54: aload_0
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	paramaus	aus
    // Exception table:
    //   from	to	target	type
    //   3	32	50	finally
    //   32	36	50	finally
    //   41	47	50	finally
  }
  
  static abstract interface a
  {
    public abstract double a(String paramString);
    
    public abstract String a(double paramDouble, String paramString);
  }
  
  static final class b
    implements x.a
  {
    public final double a(String paramString)
    {
      return 0.0D;
    }
    
    public final String a(double paramDouble, String paramString)
    {
      return paramString;
    }
  }
  
  static final class c
    implements x.a
  {
    private static a[] a = { new a(Pattern.compile("\\bя\\s+\\S*ла\\b", 2), 1.0D), new a(Pattern.compile("\\bя\\s+\\S*лась\\b", 2), 1.5D), new a(Pattern.compile("\\bя\\s+\\S*л\\b", 2), -1.0D), new a(Pattern.compile("\\bя\\s+\\S*лся\\b", 2), -1.5D) };
    private static Pattern b = Pattern.compile("\\(-?а\\)");
    
    public final double a(String paramString)
    {
      a[] arrayOfa = a;
      int j = arrayOfa.length;
      int i = 0;
      a locala;
      if (i < j)
      {
        locala = arrayOfa[i];
        if (!locala.a.matcher(paramString).find()) {}
      }
      for (double d1 = locala.b;; d1 = 0.0D)
      {
        double d2 = d1;
        if (d1 != 0.0D) {
          if (paramString.indexOf('"') < 0)
          {
            d2 = d1;
            if (paramString.indexOf(':') < 0) {}
          }
          else
          {
            d2 = 0.0D;
          }
        }
        return d2;
        i += 1;
        break;
      }
    }
    
    public final String a(double paramDouble, String paramString)
    {
      String str;
      if (paramDouble > 8.0D) {
        str = b.matcher(paramString).replaceAll("а");
      }
      do
      {
        return str;
        str = paramString;
      } while (paramDouble >= -8.0D);
      return b.matcher(paramString).replaceAll("");
    }
    
    static final class a
    {
      Pattern a;
      double b;
      
      a(Pattern paramPattern, double paramDouble)
      {
        this.a = paramPattern;
        this.b = paramDouble;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */