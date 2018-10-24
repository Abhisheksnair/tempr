package com.whatsapp.o;

import android.os.Build;
import android.os.Build.VERSION;
import java.io.File;

public abstract class a
{
  protected File a;
  protected int b;
  
  public static a a(String paramString1, String paramString2)
  {
    if ("audio/ogg; codecs=opus".equals(paramString2)) {
      return new e(paramString1 + ".opus");
    }
    if ((Build.VERSION.SDK_INT >= 16) && (Build.MANUFACTURER.equals("Sony")) && (!Build.MODEL.equals("C2104")) && (!Build.MODEL.equals("C2105")) && (!Build.MODEL.equals("C2305")))
    {
      paramString1 = new b(paramString1);
      paramString1.c = 5;
      return paramString1;
    }
    if ((Build.VERSION.SDK_INT >= 16) && (Build.MANUFACTURER.equals("samsung")) && (Build.MODEL.contains("SM-N900")) && (!Build.MODEL.equals("SM-N900")) && (!Build.MODEL.equals("SM-N9000"))) {
      return new b(paramString1);
    }
    return new c(paramString1, paramString2);
  }
  
  public abstract void a();
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public final File e()
  {
    return this.a;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/o/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */