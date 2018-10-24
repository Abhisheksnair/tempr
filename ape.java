package com.whatsapp;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.whatsapp.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ape
{
  private static final Pattern a = Pattern.compile("[^,\\.\\w\\-\\(\\)]");
  private static String b;
  
  public static String a()
  {
    return b;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    String str2 = paramString.replace(' ', '_');
    String str3 = "Android".replace(' ', '_');
    String str4 = paramContext.getString(2131298233).replace(' ', '_');
    paramContext = "unknown";
    paramString = "unknown";
    Object localObject = "unknown";
    try
    {
      str1 = a.matcher(Build.VERSION.RELEASE).replaceAll("_");
      paramContext = str1;
    }
    catch (NoSuchFieldError localNoSuchFieldError1)
    {
      for (;;)
      {
        String str1;
        label79:
        label96:
        Log.d("app/user-agent/release", localNoSuchFieldError1);
      }
    }
    try
    {
      str1 = a.matcher(Build.MANUFACTURER).replaceAll("_");
      paramString = str1;
    }
    catch (NoSuchFieldError localNoSuchFieldError2)
    {
      Log.d("app/user-agent/manufacturer", localNoSuchFieldError2);
      break label79;
    }
    try
    {
      str1 = a.matcher(Build.MODEL).replaceAll("_");
      localObject = str1;
    }
    catch (NoSuchFieldError localNoSuchFieldError3)
    {
      Log.d("app/user-agent/model", localNoSuchFieldError3);
      break label96;
    }
    return str4 + "/" + str2 + " " + str3 + "/" + paramContext + " Device/" + paramString + "-" + (String)localObject;
  }
  
  static void a(Context paramContext)
  {
    b = a(paramContext, au.d());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ape.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */