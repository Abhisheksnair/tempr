package com.whatsapp.util;

import a.a.a.a.a.a.d;
import android.content.Context;
import android.text.format.Time;
import com.whatsapp.al;
import com.whatsapp.aus;
import com.whatsapp.j.a.a;
import com.whatsapp.u;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public final class l
{
  private static final bs<SimpleDateFormat> a = new bs() {};
  private static final bs<Calendar> b = new bs() {};
  private static final bs<Calendar> c = new bs() {};
  private static final bs<SimpleDateFormat> d = new bs() {};
  private static final bs<SimpleDateFormat> e = new bs() {};
  private static volatile java.text.DateFormat f;
  private static volatile java.text.DateFormat g;
  private static volatile java.text.DateFormat h;
  private static volatile java.text.DateFormat i;
  private static volatile SimpleDateFormat j;
  private static volatile SimpleDateFormat k;
  
  public static CharSequence a(Context paramContext, aus paramaus, long paramLong, boolean paramBoolean)
  {
    int m = b(System.currentTimeMillis(), paramLong);
    if (paramBoolean) {
      return paramContext.getString(2131298194);
    }
    if (m == 0) {
      return paramContext.getString(2131298197, new Object[] { c(paramContext, paramLong) });
    }
    if (m == 1) {
      return paramContext.getString(2131298198, new Object[] { c(paramContext, paramLong) });
    }
    if (c(System.currentTimeMillis(), paramLong)) {}
    for (String str = c(paramLong);; str = b(paramLong)) {
      return paramContext.getString(2131298196, new Object[] { str + al.a(paramaus) + " " + c(paramContext, paramLong) });
    }
  }
  
  public static String a()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("yyyyMMdd", Locale.US).format(localDate);
  }
  
  public static String a(long paramLong)
  {
    return ((SimpleDateFormat)a.b()).format(new Date(paramLong));
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    return c(paramContext, paramLong);
  }
  
  public static String a(Context paramContext, aus paramaus, long paramLong)
  {
    return f(paramContext, paramaus, paramLong);
  }
  
  private static String a(Context paramContext, String paramString, long paramLong)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    int m = ((Calendar)localObject).get(11);
    if (m != 1)
    {
      localObject = paramString;
      if (m == 13)
      {
        localObject = paramString;
        if (android.text.format.DateFormat.is24HourFormat(paramContext)) {}
      }
    }
    else
    {
      localObject = paramString.replace(" a las ", " a la ");
    }
    return (String)localObject;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      String str = ((SimpleDateFormat)e.b()).format(((SimpleDateFormat)d.b()).parse(paramString));
      return str;
    }
    catch (ParseException localParseException)
    {
      Log.e("Date string '" + paramString + "' not in format of <MMM dd, yyyy>");
    }
    return paramString;
  }
  
  public static void a(java.text.DateFormat paramDateFormat)
  {
    paramDateFormat = (SimpleDateFormat)paramDateFormat;
    paramDateFormat.applyPattern(paramDateFormat.toPattern().replaceAll("([^\\p{Alpha}']|('[\\p{Alpha}]+'))*y+([^\\p{Alpha}']|('[\\p{Alpha}]+'))*", ""));
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = (Calendar)b.b();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = (Calendar)c.b();
    localCalendar2.setTimeInMillis(paramLong2);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(2) == localCalendar2.get(2)) && (localCalendar1.get(5) == localCalendar2.get(5));
  }
  
  private static int b(long paramLong1, long paramLong2)
  {
    Time localTime = new Time();
    localTime.set(paramLong1);
    int m = (int)((localTime.gmtoff * 1000L + paramLong1) / 86400000L);
    localTime.set(paramLong2);
    return m - (int)((localTime.gmtoff * 1000L + paramLong2) / 86400000L);
  }
  
  public static CharSequence b(Context paramContext, aus paramaus, long paramLong)
  {
    int m = b(System.currentTimeMillis(), paramLong);
    if (m == 0)
    {
      m = (int)((System.currentTimeMillis() - paramLong) / 60000L);
      if (m <= 0) {
        return paramContext.getString(2131297081);
      }
      if (m < 60) {
        return String.format(u.a.a(2131230764, m), new Object[] { Integer.valueOf(m) });
      }
      return paramContext.getString(2131297987) + al.a(paramaus) + " " + c(paramContext, paramLong);
    }
    if (m == 1) {
      return paramContext.getString(2131298214) + al.a(paramaus) + " " + c(paramContext, paramLong);
    }
    if (c(System.currentTimeMillis(), paramLong)) {
      return c(paramLong) + al.a(paramaus) + " " + c(paramContext, paramLong);
    }
    return b(paramLong) + al.a(paramaus) + " " + c(paramContext, paramLong);
  }
  
  public static String b(long paramLong)
  {
    if (g == null) {
      g = java.text.DateFormat.getDateInstance(3, aus.a().b());
    }
    return ((java.text.DateFormat)g.clone()).format(new Date(paramLong));
  }
  
  public static String b(Context paramContext, long paramLong)
  {
    int m = b(System.currentTimeMillis(), paramLong);
    if (m == 0) {
      return c(paramContext, paramLong);
    }
    if (m == 1) {
      return paramContext.getString(2131298214);
    }
    return b(paramLong);
  }
  
  public static void b()
  {
    f = null;
    g = null;
    h = null;
    i = null;
    j = null;
    k = null;
  }
  
  public static CharSequence c(Context paramContext, aus paramaus, long paramLong)
  {
    int m = b(System.currentTimeMillis(), paramLong);
    if (m == 0) {
      return paramContext.getString(2131297232, new Object[] { c(paramContext, paramLong) });
    }
    if (m == -1) {
      return paramContext.getString(2131297233, new Object[] { c(paramContext, paramLong) });
    }
    if (m > -30) {
      paramaus = c(paramLong) + al.a(paramaus) + " " + c(paramContext, paramLong);
    }
    for (;;)
    {
      return paramContext.getString(2131297231, new Object[] { paramaus });
      if (c(System.currentTimeMillis(), paramLong)) {
        paramaus = c(paramLong);
      } else {
        paramaus = b(paramLong);
      }
    }
  }
  
  public static String c(long paramLong)
  {
    if (k == null)
    {
      SimpleDateFormat localSimpleDateFormat = (SimpleDateFormat)c();
      k = localSimpleDateFormat;
      a(localSimpleDateFormat);
    }
    return ((java.text.DateFormat)k.clone()).format(new Date(paramLong));
  }
  
  public static String c(Context paramContext, long paramLong)
  {
    if (f == null) {
      f = new SimpleDateFormat(((SimpleDateFormat)android.text.format.DateFormat.getTimeFormat(paramContext)).toPattern(), aus.a().b());
    }
    return ((java.text.DateFormat)f.clone()).format(new Date(paramLong));
  }
  
  private static java.text.DateFormat c()
  {
    if (i == null) {
      i = java.text.DateFormat.getDateInstance(1, aus.a().b());
    }
    return (java.text.DateFormat)i.clone();
  }
  
  private static boolean c(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = (Calendar)b.b();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = (Calendar)c.b();
    localCalendar2.setTimeInMillis(paramLong2);
    return localCalendar1.get(1) == localCalendar2.get(1);
  }
  
  public static String d(Context paramContext, long paramLong)
  {
    long l1 = paramLong / 3600000L;
    long l2 = (paramLong - 3600000L * l1) / 60000L;
    if (l1 == 0L)
    {
      if (l2 == 0L)
      {
        paramLong /= 1000L;
        return String.format(u.a.a(2131230793, (int)paramLong), new Object[] { Integer.valueOf((int)paramLong) });
      }
      return String.format(u.a.a(2131230763, (int)l2), new Object[] { Integer.valueOf((int)l2) });
    }
    if (l2 == 0L) {
      return String.format(u.a.a(2131230755, (int)l1), new Object[] { Integer.valueOf((int)l1) });
    }
    String str = String.format(u.a.a(2131230763, (int)l2), new Object[] { Integer.valueOf((int)l2) });
    return paramContext.getString(2131297025, new Object[] { String.format(u.a.a(2131230755, (int)l1), new Object[] { Integer.valueOf((int)l1) }), str });
  }
  
  public static String d(Context paramContext, aus paramaus, long paramLong)
  {
    int m = b(System.currentTimeMillis(), paramLong);
    String str = aus.a().d();
    if (m == 0) {
      paramaus = paramContext.getString(2131297988, new Object[] { c(paramContext, paramLong) });
    }
    for (;;)
    {
      Object localObject = paramaus;
      if ("es".equals(str)) {
        localObject = a(paramContext, paramaus, paramLong);
      }
      return (String)localObject;
      if (m == 1) {
        paramaus = paramContext.getString(2131298215, new Object[] { c(paramContext, paramLong) });
      } else if (("en".equals(str)) || ("de".equals(str)) || ("es".equals(str)))
      {
        if (m <= 6)
        {
          paramaus = new SimpleDateFormat("EEE");
          paramaus = paramContext.getString(2131296606, new Object[] { paramaus.format(new Date(paramLong)) + " " + c(paramContext, paramLong) });
        }
        else if (m <= 30)
        {
          localObject = new StringBuilder();
          if (j == null)
          {
            SimpleDateFormat localSimpleDateFormat = (SimpleDateFormat)c();
            j = localSimpleDateFormat;
            a(localSimpleDateFormat);
          }
          paramaus = paramContext.getString(2131297984, new Object[] { ((java.text.DateFormat)j.clone()).format(new Date(paramLong)) + al.a(paramaus) + " " + c(paramContext, paramLong) });
        }
        else
        {
          if (h == null) {
            h = java.text.DateFormat.getDateInstance(2, aus.a().b());
          }
          paramaus = paramContext.getString(2131296605, new Object[] { ((SimpleDateFormat)(java.text.DateFormat)h.clone()).format(new Date(paramLong)) });
        }
      }
      else if (m <= 30) {
        paramaus = paramContext.getString(2131297984, new Object[] { f(paramContext, paramaus, paramLong) });
      } else {
        paramaus = paramContext.getString(2131296605, new Object[] { b(paramLong) });
      }
    }
  }
  
  public static boolean d(long paramLong)
  {
    return b(System.currentTimeMillis(), paramLong) == 0;
  }
  
  public static long e(long paramLong)
  {
    long l1 = System.currentTimeMillis() - paramLong;
    if (l1 < 3600000L) {
      paramLong = l1 / 60000L * 60000L + paramLong + 60000L;
    }
    for (;;)
    {
      GregorianCalendar localGregorianCalendar = new GregorianCalendar();
      localGregorianCalendar.add(5, 1);
      localGregorianCalendar.set(11, 0);
      localGregorianCalendar.set(12, 0);
      localGregorianCalendar.set(13, 0);
      long l2 = localGregorianCalendar.getTimeInMillis();
      if (paramLong != 0L)
      {
        l1 = paramLong;
        if (paramLong <= l2) {}
      }
      else
      {
        l1 = l2;
      }
      return l1;
      if (l1 < 86400000L) {
        paramLong = l1 / 3600000L * 3600000L + paramLong + 3600000L;
      } else {
        paramLong = 0L;
      }
    }
  }
  
  public static String e(Context paramContext, long paramLong)
  {
    int m = b(System.currentTimeMillis(), paramLong);
    if (m == 0) {
      return paramContext.getString(2131297987);
    }
    if (m == 1) {
      return paramContext.getString(2131298214);
    }
    return c().format(new Date(paramLong));
  }
  
  public static String e(Context paramContext, aus paramaus, long paramLong)
  {
    int m = b(System.currentTimeMillis(), paramLong);
    if (m == 0) {
      paramaus = paramContext.getString(2131297988, new Object[] { c(paramContext, paramLong) });
    }
    for (;;)
    {
      Object localObject = paramaus;
      if ("es".equals(aus.a().d())) {
        localObject = a(paramContext, paramaus, paramLong);
      }
      return (String)localObject;
      if (m == 1) {
        paramaus = paramContext.getString(2131298215, new Object[] { c(paramContext, paramLong) });
      } else if (m <= 30) {
        paramaus = f(paramContext, paramaus, paramLong);
      } else {
        paramaus = b(paramLong);
      }
    }
  }
  
  public static String f(Context paramContext, long paramLong)
  {
    if (paramLong >= 0L) {}
    long l2;
    for (boolean bool = true;; bool = false)
    {
      a.d.a(bool);
      long l3 = paramLong / 3600000L;
      l2 = (paramLong - 3600000L * l3) / 60000L;
      long l1 = l2;
      if (paramLong - 3600000L * l3 - 60000L * l2 > 0L) {
        l1 = l2 + 1L;
      }
      l2 = l1;
      paramLong = l3;
      if (l1 == 60L)
      {
        paramLong = l3 + 1L;
        l2 = 0L;
      }
      if (paramLong != 0L) {
        break;
      }
      paramContext = String.format(u.a.a(2131230765, (int)l2), new Object[] { Integer.valueOf((int)l2) });
      return String.format(u.a.a(2131230810, (int)l2), new Object[] { paramContext });
    }
    String str = String.format(u.a.a(2131230765, (int)l2), new Object[] { Integer.valueOf((int)l2) });
    paramContext = paramContext.getString(2131297025, new Object[] { String.format(u.a.a(2131230756, (int)paramLong), new Object[] { Integer.valueOf((int)paramLong) }), str });
    return String.format(u.a.a(2131230810, (int)(l2 + paramLong)), new Object[] { paramContext });
  }
  
  public static String f(Context paramContext, aus paramaus, long paramLong)
  {
    return b(paramLong) + al.a(paramaus) + " " + c(paramContext, paramLong);
  }
  
  public static String g(Context paramContext, aus paramaus, long paramLong)
  {
    if (d(paramLong)) {
      return c(paramContext, paramLong);
    }
    return b(paramContext, paramaus, paramLong).toString();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */