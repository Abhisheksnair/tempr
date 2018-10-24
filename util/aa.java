package com.whatsapp.util;

import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.URLSpan;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class aa
{
  public static final Pattern a = Pattern.compile("((?:[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯](?:[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯\\-]{0,61}[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯]){0,1}\\.)+([a-zA-Z -퟿豈-﷏ﷰ-￯]{2,63})|" + d + ")");
  public static final Pattern b = Pattern.compile("((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯](?:[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯\\-]{0,61}[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯]){0,1}\\.)+([a-zA-Z -퟿豈-﷏ﷰ-￯]{2,63}))(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_\\$])|(?:\\%[a-fA-F0-9]{2}))*)?");
  public static final Pattern c = Pattern.compile("^((?:(http|https|Http|Https|rtsp|Rtsp):\\/\\/(?:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,64}(?:\\:(?:[a-zA-Z0-9\\$\\-\\_\\.\\+\\!\\*\\'\\(\\)\\,\\;\\?\\&\\=]|(?:\\%[a-fA-F0-9]{2})){1,25})?\\@)?)?((?:(?:[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯][a-zA-Z0-9 -퟿豈-﷏ﷰ-￯\\-]{0,64}\\.)+(?:(?:aero|arpa|asia|a[cdefgilmnoqrstuwxz])|(?:biz|b[abdefghijmnorstvwyz])|(?:cat|com|coop|c[acdfghiklmnoruvxyz])|d[ejkmoz]|(?:edu|e[cegrstu])|f[ijkmor]|(?:gov|g[abdefghilmnpqrstuwy])|h[kmnrtu]|(?:info|int|i[delmnoqrst])|(?:jobs|j[emop])|k[eghimnprwyz]|l[abcikrstuvy]|(?:mil|mobi|museum|m[acdeghklmnopqrstuvwxyz])|(?:name|net|n[acefgilopruz])|(?:org|om)|(?:pro|p[aefghklmnrstwy])|qa|r[eosuw]|s[abcdeghijklmnortuvyz]|(?:tel|travel|t[cdfghjklmnoprtvwz])|u[agksyz]|v[aceginu]|w[fs]|(?:δοκιμή|испытание|рф|срб|טעסט|آزمایشی|إختبار|الاردن|الجزائر|السعودية|المغرب|امارات|بھارت|تونس|سورية|فلسطين|قطر|مصر|परीक्षा|भारत|ভারত|ਭਾਰਤ|ભારત|இந்தியா|இலங்கை|சிங்கப்பூர்|பரிட்சை|భారత్|ලංකා|ไทย|テスト|中国|中國|台湾|台灣|新加坡|测试|測試|香港|테스트|한국|xn\\-\\-0zwm56d|xn\\-\\-11b5bs3a9aj6g|xn\\-\\-3e0b707e|xn\\-\\-45brj9c|xn\\-\\-80akhbyknj4f|xn\\-\\-90a3ac|xn\\-\\-9t4b11yi5a|xn\\-\\-clchc0ea0b2g2a9gcd|xn\\-\\-deba0ad|xn\\-\\-fiqs8s|xn\\-\\-fiqz9s|xn\\-\\-fpcrj9c3d|xn\\-\\-fzc2c9e2c|xn\\-\\-g6w251d|xn\\-\\-gecrj9c|xn\\-\\-h2brj9c|xn\\-\\-hgbk6aj7f53bba|xn\\-\\-hlcj6aya9esc7a|xn\\-\\-j6w193g|xn\\-\\-jxalpdlp|xn\\-\\-kgbechtv|xn\\-\\-kprw13d|xn\\-\\-kpry57d|xn\\-\\-lgbbat1ad8j|xn\\-\\-mgbaam7a8h|xn\\-\\-mgbayh7gpa|xn\\-\\-mgbbh1a71e|xn\\-\\-mgbc0a9azcg|xn\\-\\-mgberp4a5d4ar|xn\\-\\-o3cw4h|xn\\-\\-ogbpf8fl|xn\\-\\-p1ai|xn\\-\\-pgbs0dh|xn\\-\\-s9brj9c|xn\\-\\-wgbh1c|xn\\-\\-wgbl6a|xn\\-\\-xkc2al3hye2a|xn\\-\\-xkc2dl3a5ee0h|xn\\-\\-yfro4i67o|xn\\-\\-ygbi2ammx|xn\\-\\-zckzah|xxx)|y[et]|z[amw])))(?:\\:\\d{1,5})?)(\\/(?:(?:[a-zA-Z0-9 -퟿豈-﷏ﷰ-￯\\;\\/\\?\\:\\@\\&\\=\\#\\~\\-\\.\\+\\!\\*\\'\\(\\)\\,\\_\\$])|(?:\\%[a-fA-F0-9]{2}))*)?(?:\\b|$)");
  private static final Pattern d = Pattern.compile("(((25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1][0-9]{2}|[1-9][0-9]|[0-9]))|([0-9a-fA-F]{0,4}­:){2,7}(­:|[0-9a-fA-F]{1,4}))");
  private static final String[] e = { "http://", "https://", "rtsp://" };
  private static final Pattern[] f = new Pattern[0];
  
  private static final String a(String paramString, String[] paramArrayOfString)
  {
    int j = 1;
    int i = 0;
    if (i < paramArrayOfString.length) {
      if (paramString.regionMatches(true, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length()))
      {
        if (paramString.regionMatches(false, 0, paramArrayOfString[i], 0, paramArrayOfString[i].length())) {
          break label119;
        }
        paramString = paramArrayOfString[i] + paramString.substring(paramArrayOfString[i].length());
        i = j;
      }
    }
    for (;;)
    {
      String str = paramString;
      if (i == 0) {
        str = paramArrayOfString[0] + paramString;
      }
      return str;
      i += 1;
      break;
      label119:
      i = j;
      continue;
      i = 0;
    }
  }
  
  public static ArrayList<String> a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString))
    {
      localObject2 = localObject1;
      return (ArrayList<String>)localObject2;
    }
    Object localObject3 = b;
    if (paramString.length() > 4096)
    {
      localObject1 = paramString.substring(0, 4096);
      localObject3 = ((Pattern)localObject3).matcher((CharSequence)localObject1);
      localObject1 = localObject2;
    }
    label49:
    label109:
    label198:
    for (;;)
    {
      localObject2 = localObject1;
      if (!((Matcher)localObject3).find()) {
        break;
      }
      int i = ((Matcher)localObject3).start();
      if (((i == 0) || (paramString.charAt(i - 1) != '@')) && (!e(((Matcher)localObject3).group(3))))
      {
        localObject2 = ((Matcher)localObject3).group(0);
        if (f((String)localObject2))
        {
          i = 0;
          if (i < e.length) {
            if (!((String)localObject2).regionMatches(true, 0, e[i], 0, e[i].length())) {}
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label198;
            }
            if (localObject1 == null) {
              localObject1 = new ArrayList();
            }
            for (;;)
            {
              localObject2 = d((String)localObject2);
              if (!((ArrayList)localObject1).contains(localObject2)) {
                ((ArrayList)localObject1).add(localObject2);
              }
              break label49;
              localObject1 = paramString;
              break;
              i += 1;
              break label109;
            }
          }
        }
      }
    }
  }
  
  public static boolean a(Spannable paramSpannable)
  {
    Object localObject2 = b;
    Object localObject1;
    boolean bool;
    label40:
    int j;
    int i;
    if (paramSpannable.length() > 4096)
    {
      localObject1 = paramSpannable.subSequence(0, 4096);
      localObject1 = ((Pattern)localObject2).matcher((CharSequence)localObject1);
      bool = false;
      while (((Matcher)localObject1).find())
      {
        j = ((Matcher)localObject1).start();
        i = ((Matcher)localObject1).end();
        if (((j == 0) || (paramSpannable.charAt(j - 1) != '@')) && (!e(((Matcher)localObject1).group(3))))
        {
          localObject2 = ((Matcher)localObject1).group(0);
          if (f((String)localObject2))
          {
            if ((paramSpannable.length() <= i) || (paramSpannable.charAt(i) != '/')) {
              break label170;
            }
            i += 1;
          }
        }
      }
    }
    label170:
    for (;;)
    {
      paramSpannable.setSpan(new URLSpan(a((String)localObject2, e)), j, i, 33);
      bool = true;
      break label40;
      localObject1 = paramSpannable;
      break;
      return bool;
    }
  }
  
  public static boolean a(CharSequence paramCharSequence)
  {
    boolean bool2 = false;
    Pattern localPattern = b;
    CharSequence localCharSequence = paramCharSequence;
    if (paramCharSequence.length() > 4096) {
      localCharSequence = paramCharSequence.subSequence(0, 4096);
    }
    paramCharSequence = localPattern.matcher(localCharSequence);
    do
    {
      bool1 = bool2;
      if (!paramCharSequence.find()) {
        break;
      }
    } while (!e(paramCharSequence.group(3)));
    boolean bool1 = true;
    return bool1;
  }
  
  public static String b(String paramString)
  {
    Object localObject2 = b;
    Object localObject1;
    if (paramString.length() > 4096)
    {
      localObject1 = paramString.substring(0, 4096);
      localObject1 = ((Pattern)localObject2).matcher((CharSequence)localObject1);
    }
    label126:
    for (;;)
    {
      if (!((Matcher)localObject1).find()) {
        break label128;
      }
      int i = ((Matcher)localObject1).start();
      if (((i == 0) || (paramString.charAt(i - 1) != '@')) && (!e(((Matcher)localObject1).group(3))))
      {
        localObject2 = ((Matcher)localObject1).group(0);
        if (f((String)localObject2))
        {
          i = 0;
          for (;;)
          {
            if (i >= e.length) {
              break label126;
            }
            if (((String)localObject2).regionMatches(true, 0, e[i], 0, e[i].length()))
            {
              return (String)localObject2;
              localObject1 = paramString;
              break;
            }
            i += 1;
          }
        }
      }
    }
    label128:
    return null;
  }
  
  public static String c(String paramString)
  {
    paramString = b(paramString);
    if (paramString != null) {
      return a(paramString, e);
    }
    return null;
  }
  
  public static final String d(String paramString)
  {
    return a(paramString, e);
  }
  
  private static boolean e(String paramString)
  {
    if ((paramString == null) || (paramString.length() > 4096)) {
      return true;
    }
    Pattern[] arrayOfPattern = f;
    int j = arrayOfPattern.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label50;
      }
      if (arrayOfPattern[i].matcher(paramString).find()) {
        break;
      }
      i += 1;
    }
    label50:
    return false;
  }
  
  private static boolean f(String paramString)
  {
    int i;
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")) || (paramString.startsWith("Http://")) || (paramString.startsWith("Https://")) || (paramString.startsWith("www.")) || (paramString.startsWith("Www.")))
    {
      i = 1;
      if (i == 0) {
        break label67;
      }
    }
    label67:
    while ((paramString.length() < 4096) && (c.matcher(paramString).find()))
    {
      return true;
      i = 0;
      break;
    }
    return false;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */