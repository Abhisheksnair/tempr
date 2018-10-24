package com.whatsapp.util;

import android.text.TextUtils;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ad
{
  private static final Pattern c = Pattern.compile("(\\d{3})(\\d{2,3})");
  public final String a;
  public final String b;
  
  private ad(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public static ad a(String paramString)
  {
    return a(paramString, "000", "000");
  }
  
  private static ad a(String paramString1, String paramString2, String paramString3)
  {
    if (paramString1 == null) {
      return new ad(paramString2, paramString3);
    }
    Matcher localMatcher = c.matcher(paramString1);
    if (!localMatcher.matches()) {
      return new ad(paramString2, paramString3);
    }
    paramString2 = localMatcher.group(1);
    try
    {
      paramString1 = String.format(Locale.US, "%03d", new Object[] { Integer.valueOf(Integer.valueOf(localMatcher.group(2)).intValue()) });
      return new ad(paramString2, paramString1);
    }
    catch (NumberFormatException paramString1)
    {
      for (;;)
      {
        Log.e("mccmnc/parse mnc not parseable as integer: " + localMatcher.group(2));
        paramString1 = paramString3;
      }
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {}
    do
    {
      return paramString2;
      paramString1 = c.matcher(paramString1);
    } while (!paramString1.matches());
    paramString2 = paramString1.group(1);
    paramString1 = paramString1.group(2);
    return paramString2 + "-" + paramString1;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (ad)paramObject;
    } while ((TextUtils.equals(this.a, ((ad)paramObject).a)) && (TextUtils.equals(this.b, ((ad)paramObject).b)));
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    int i;
    if (this.a == null)
    {
      i = 0;
      if (this.b != null) {
        break label36;
      }
    }
    for (;;)
    {
      return i * 31 + j;
      i = this.a.hashCode();
      break;
      label36:
      j = this.b.hashCode();
    }
  }
  
  public final String toString()
  {
    return "MccMnc<" + this.a + "," + this.b + ">";
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */