package com.whatsapp.j.a;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public abstract class b
{
  private static Map<String, b> a = new HashMap();
  
  static
  {
    Object localObject = new n();
    a(new String[] { "bem", "brx", "da", "de", "el", "en", "eo", "es", "et", "fi", "fo", "gl", "he", "iw", "it", "nb", "nl", "nn", "no", "sv", "af", "bg", "bn", "ca", "eu", "fur", "fy", "gu", "ha", "is", "ku", "lb", "ml", "mr", "nah", "ne", "om", "or", "pa", "pap", "ps", "so", "sq", "sw", "ta", "te", "tk", "ur", "zu", "mn", "gsw", "chr", "rm", "pt" }, (b)localObject);
    localObject = new f();
    a(new String[] { "cs", "sk" }, (b)localObject);
    localObject = new g();
    a(new String[] { "ff", "fr", "kab" }, (b)localObject);
    localObject = new q();
    a(new String[] { "ru", "uk", "be" }, (b)localObject);
    localObject = new d();
    a(new String[] { "hr", "sr", "bs", "sh" }, (b)localObject);
    localObject = new i();
    a(new String[] { "lv" }, (b)localObject);
    localObject = new j();
    a(new String[] { "lt" }, (b)localObject);
    localObject = new o();
    a(new String[] { "pl" }, (b)localObject);
    localObject = new p();
    a(new String[] { "ro", "mo" }, (b)localObject);
    localObject = new r();
    a(new String[] { "sl" }, (b)localObject);
    localObject = new c();
    a(new String[] { "ar" }, (b)localObject);
    localObject = new k();
    a(new String[] { "mk" }, (b)localObject);
    localObject = new u();
    a(new String[] { "cy" }, (b)localObject);
    localObject = new e();
    a(new String[] { "br" }, (b)localObject);
    localObject = new h();
    a(new String[] { "lag" }, (b)localObject);
    localObject = new s();
    a(new String[] { "shi" }, (b)localObject);
    localObject = new l();
    a(new String[] { "mt" }, (b)localObject);
    localObject = new t();
    a(new String[] { "ga", "se", "sma", "smi", "smj", "smn", "sms" }, (b)localObject);
    localObject = new v();
    a(new String[] { "ak", "am", "bh", "fil", "tl", "guw", "hi", "ln", "mg", "nso", "ti", "wa" }, (b)localObject);
    localObject = new m();
    a(new String[] { "az", "bm", "fa", "ig", "hu", "ja", "kde", "kea", "ko", "my", "ses", "sg", "to", "tr", "vi", "wo", "yo", "zh", "bo", "dz", "id", "in", "jv", "ka", "km", "kn", "ms", "th" }, (b)localObject);
  }
  
  public static final b a(Locale paramLocale)
  {
    return (b)a.get(paramLocale.getLanguage());
  }
  
  private static void a(String[] paramArrayOfString, b paramb)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      a.put(str, paramb);
      i += 1;
    }
  }
  
  static final int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 16777220;
    case 1: 
      return 16777221;
    case 2: 
      return 16777222;
    case 4: 
      return 16777223;
    case 8: 
      return 16777224;
    }
    return 16777225;
  }
  
  static final String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "other";
    case 1: 
      return "zero";
    case 2: 
      return "one";
    case 4: 
      return "two";
    case 8: 
      return "few";
    }
    return "many";
  }
  
  public abstract int a(int paramInt);
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/j/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */