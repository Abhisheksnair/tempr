package com.whatsapp.jobqueue.job;

import android.annotation.TargetApi;
import android.content.Context;
import android.icu.text.DateTimePatternGenerator;
import android.icu.util.ULocale;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import b.a.a.c;
import com.google.protobuf.e;
import com.whatsapp.att;
import com.whatsapp.aus;
import com.whatsapp.av;
import com.whatsapp.data.ad;
import com.whatsapp.jobqueue.requirement.HsmMessagePackRequirement;
import com.whatsapp.jobqueue.requirement.VNameCertificateRequirement;
import com.whatsapp.messaging.m;
import com.whatsapp.proto.E2E.Message;
import com.whatsapp.proto.E2E.Message.HighlyStructuredMessage;
import com.whatsapp.proto.E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter;
import com.whatsapp.proto.E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency;
import com.whatsapp.proto.E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime;
import com.whatsapp.proto.E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent;
import com.whatsapp.proto.E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.b;
import com.whatsapp.proto.E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch;
import com.whatsapp.proto.a.b;
import com.whatsapp.proto.a.b.c;
import com.whatsapp.proto.a.b.c.b;
import com.whatsapp.protocol.j.a;
import com.whatsapp.util.Log;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.whispersystems.jobqueue.Job;
import org.whispersystems.jobqueue.JobParameters.a;
import org.whispersystems.jobqueue.requirements.Requirement;

public final class RehydrateHsmJob
  extends Job
  implements org.whispersystems.jobqueue.a.b
{
  private static final Pattern REPLACEMENT_PATTERN = Pattern.compile("\\{\\{[1-9]+[0-9]*\\}\\}");
  private static final long serialVersionUID = 1L;
  private transient ad a;
  private transient att b;
  private final Long existingMessageRowId;
  private final long expireTimeMs;
  private transient m f;
  private transient com.whatsapp.data.l g;
  private transient com.whatsapp.b.a h;
  private final String id;
  private final String jid;
  private final Locale[] locales;
  private final E2E.Message message;
  private final String participant;
  private final long timestamp;
  private final Long verifiedSender;
  
  public RehydrateHsmJob(aus paramaus, E2E.Message paramMessage, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, Long paramLong3, Long paramLong4) {}
  
  private Pair<Integer, Integer> a(E2E.Message.HighlyStructuredMessage paramHighlyStructuredMessage, a.b paramb)
  {
    int i;
    if ((paramb.c()) && (paramb.e > 0))
    {
      i = paramb.e - 1;
      if (i > paramHighlyStructuredMessage.getLocalizableParamsCount()) {
        break label69;
      }
      paramHighlyStructuredMessage = paramHighlyStructuredMessage.getLocalizableParams(i).getDefault();
    }
    for (;;)
    {
      if (TextUtils.isEmpty(paramHighlyStructuredMessage))
      {
        Log.w("message does not contain parameter at plural index" + i());
        return null;
        label69:
        if (i <= paramHighlyStructuredMessage.getParamsCount()) {
          paramHighlyStructuredMessage = paramHighlyStructuredMessage.getParams(i);
        }
      }
      else
      {
        try
        {
          int j = Integer.parseInt(paramHighlyStructuredMessage);
          return Pair.create(Integer.valueOf(i), Integer.valueOf(j));
        }
        catch (NumberFormatException paramHighlyStructuredMessage)
        {
          Log.w("message parameter at plural index is not an integer" + i());
          return null;
        }
      }
      paramHighlyStructuredMessage = null;
    }
  }
  
  private static a.b.c a(a.b paramb, int paramInt)
  {
    Object localObject = paramb.f.iterator();
    while (((Iterator)localObject).hasNext())
    {
      a.b.c localc = (a.b.c)((Iterator)localObject).next();
      if ((localc.c == a.b.c.b.a) && (paramInt == 1)) {}
      while (((localc.c == a.b.c.b.b) && (paramInt == 2)) || ((localc.c == a.b.c.b.c) && (paramInt == 4)) || ((localc.c == a.b.c.b.d) && (paramInt == 8)) || ((localc.c == a.b.c.b.e) && (paramInt == 16))) {
        return localc;
      }
      if ((localc.c == a.b.c.b.f) && (paramInt == 0)) {
        return localc;
      }
    }
    paramb = paramb.f.iterator();
    while (paramb.hasNext())
    {
      localObject = (a.b.c)paramb.next();
      if (((a.b.c)localObject).c == a.b.c.b.f)
      {
        Log.w("using fallback OTHER plural exception");
        return (a.b.c)localObject;
      }
    }
    return null;
  }
  
  private String a(E2E.Message.HighlyStructuredMessage paramHighlyStructuredMessage, Locale paramLocale, String paramString, Pair<Integer, Integer> paramPair)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramString.length());
    Matcher localMatcher = REPLACEMENT_PATTERN.matcher(paramString);
    if (localMatcher.find())
    {
      int i = localMatcher.start() + 2;
      int j = localMatcher.end() - 2;
      if (j - i > 0) {}
      for (;;)
      {
        try
        {
          i = Integer.parseInt(paramString.substring(i, j));
          if ((paramPair == null) || (((Integer)paramPair.first).intValue() != i - 1)) {
            break label178;
          }
          i = ((Integer)paramPair.second).intValue();
          if (Build.VERSION.SDK_INT < 24) {
            break label163;
          }
          localObject3 = android.icu.text.NumberFormat.getIntegerInstance(paramLocale).format(i);
          Object localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          localMatcher.appendReplacement(localStringBuffer, Matcher.quoteReplacement((String)localObject1));
        }
        catch (NumberFormatException localNumberFormatException) {}
        i = -1;
        continue;
        label163:
        Object localObject3 = java.text.NumberFormat.getIntegerInstance(paramLocale).format(i);
        continue;
        label178:
        if ((i > 0) && (i <= paramHighlyStructuredMessage.getLocalizableParamsCount()))
        {
          E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter localHSMLocalizableParameter = paramHighlyStructuredMessage.getLocalizableParams(i - 1);
          Object localObject2 = null;
          switch (1.b[localHSMLocalizableParameter.getParamOneofCase().ordinal()])
          {
          default: 
            localObject2 = localHSMLocalizableParameter.getDefault();
          }
          for (;;)
          {
            label247:
            localObject3 = localObject2;
            if (localObject2 != null) {
              break;
            }
            if (!av.d()) {
              break label2046;
            }
            localObject3 = "[" + localHSMLocalizableParameter.getDefault() + ']';
            break;
            localObject2 = localHSMLocalizableParameter.getCurrency();
            if ((!((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency)localObject2).hasCurrencyCode()) || (!((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency)localObject2).hasAmount1000()))
            {
              Log.w("localized currency param missing fields");
              localObject2 = null;
            }
            else
            {
              localObject3 = ((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency)localObject2).getCurrencyCode();
              double d = ((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMCurrency)localObject2).getAmount1000() / 1000.0D;
              if (Build.VERSION.SDK_INT >= 24)
              {
                localObject2 = a((String)localObject3, d, paramLocale);
              }
              else
              {
                localObject2 = b((String)localObject3, d, paramLocale);
                continue;
                Object localObject4;
                switch (1.a[localHSMLocalizableParameter.getDateTime().getDatetimeOneofCase().ordinal()])
                {
                default: 
                  break;
                case 1: 
                  localObject2 = localHSMLocalizableParameter.getDateTime().getComponent();
                  StringBuilder localStringBuilder;
                  if ((!((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasCalendar()) || (((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).getCalendar() == E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.b.a))
                  {
                    localObject3 = new GregorianCalendar();
                    ((java.util.Calendar)localObject3).clear();
                    localObject4 = new StringBuilder();
                    j = 0;
                    if (((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasYear())
                    {
                      ((java.util.Calendar)localObject3).set(1, ((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).getYear());
                      ((StringBuilder)localObject4).append("yyyy");
                    }
                    if (((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasMonth())
                    {
                      ((java.util.Calendar)localObject3).set(2, ((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).getMonth() - 1);
                      ((StringBuilder)localObject4).append("MMMM");
                    }
                    if (((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasDayOfMonth())
                    {
                      ((java.util.Calendar)localObject3).set(5, ((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).getDayOfMonth());
                      ((StringBuilder)localObject4).append("d");
                    }
                    if (((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasDayOfWeek()) {
                      ((StringBuilder)localObject4).append("EEEE");
                    }
                    if (((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasHour())
                    {
                      ((java.util.Calendar)localObject3).set(11, ((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).getHour());
                      if (!((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasMinute()) {
                        break label724;
                      }
                      ((java.util.Calendar)localObject3).set(12, ((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).getMinute());
                    }
                    for (;;)
                    {
                      j = 1;
                      if ((!((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasDayOfWeek()) || (((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasYear()) || (((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasMonth()) || (((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasDayOfMonth())) {
                        break label743;
                      }
                      switch (1.c[localObject2.getDayOfWeek().ordinal()])
                      {
                      default: 
                        Log.w("localized component time had invalid day-of-week");
                        localObject2 = null;
                        break label247;
                        ((java.util.Calendar)localObject3).set(12, 0);
                      }
                    }
                    ((java.util.Calendar)localObject3).set(7, 1);
                    localObject2 = ((StringBuilder)localObject4).toString();
                    localObject3 = ((java.util.Calendar)localObject3).getTime();
                    if (Build.VERSION.SDK_INT >= 24)
                    {
                      localObject4 = DateTimePatternGenerator.getInstance(paramLocale);
                      localStringBuilder = new StringBuilder().append((String)localObject2);
                      if (j != 0) {}
                      for (localObject2 = "jjmm";; localObject2 = "")
                      {
                        localObject2 = new android.icu.text.SimpleDateFormat(((DateTimePatternGenerator)localObject4).getBestPattern((String)localObject2), paramLocale).format((Date)localObject3);
                        break;
                        ((java.util.Calendar)localObject3).set(7, 2);
                        break label743;
                        ((java.util.Calendar)localObject3).set(7, 3);
                        break label743;
                        ((java.util.Calendar)localObject3).set(7, 4);
                        break label743;
                        ((java.util.Calendar)localObject3).set(7, 5);
                        break label743;
                        ((java.util.Calendar)localObject3).set(7, 6);
                        break label743;
                        ((java.util.Calendar)localObject3).set(7, 7);
                        break label743;
                      }
                    }
                    if (Build.VERSION.SDK_INT >= 18)
                    {
                      localObject4 = new StringBuilder().append((String)localObject2);
                      if (j != 0) {}
                      for (localObject2 = "jjmm";; localObject2 = "")
                      {
                        localObject2 = new java.text.SimpleDateFormat(android.text.format.DateFormat.getBestDateTimePattern(paramLocale, (String)localObject2), paramLocale).format((Date)localObject3);
                        break;
                      }
                    }
                    if ((((String)localObject2).equals("yyyy")) || (((String)localObject2).equals("MMMM")) || (((String)localObject2).equals("EEEE")))
                    {
                      localObject4 = new java.text.SimpleDateFormat((String)localObject2, paramLocale);
                      localObject2 = new StringBuilder();
                      ((StringBuilder)localObject2).append(((java.text.SimpleDateFormat)localObject4).format((Date)localObject3));
                      if (j != 0)
                      {
                        localObject4 = java.text.DateFormat.getTimeInstance(3, paramLocale);
                        ((StringBuilder)localObject2).append(' ');
                        ((StringBuilder)localObject2).append(((java.text.DateFormat)localObject4).format((Date)localObject3));
                      }
                      localObject2 = ((StringBuilder)localObject2).toString();
                    }
                    else
                    {
                      i = -1;
                      switch (((String)localObject2).hashCode())
                      {
                      default: 
                        switch (i)
                        {
                        default: 
                          localObject2 = null;
                        }
                        break;
                      }
                      for (;;)
                      {
                        if (localObject2 != null)
                        {
                          localObject2 = ((java.text.DateFormat)localObject2).format((Date)localObject3);
                          break;
                          if (!((String)localObject2).equals("yyyyMMMMd")) {
                            break label1136;
                          }
                          i = 0;
                          break label1136;
                          if (!((String)localObject2).equals("yyyyMMMMdEEEE")) {
                            break label1136;
                          }
                          i = 1;
                          break label1136;
                          if (!((String)localObject2).equals("MMMMd")) {
                            break label1136;
                          }
                          i = 2;
                          break label1136;
                          if (!((String)localObject2).equals("MMMMdEEEE")) {
                            break label1136;
                          }
                          i = 3;
                          break label1136;
                          if (j != 0)
                          {
                            localObject2 = java.text.DateFormat.getDateTimeInstance(1, 3, paramLocale);
                          }
                          else
                          {
                            localObject2 = java.text.DateFormat.getDateInstance(1, paramLocale);
                            continue;
                            if (j != 0)
                            {
                              localObject2 = java.text.DateFormat.getDateTimeInstance(0, 3, paramLocale);
                            }
                            else
                            {
                              localObject2 = java.text.DateFormat.getDateInstance(0, paramLocale);
                              continue;
                              if (j != 0) {}
                              for (localObject2 = java.text.DateFormat.getDateTimeInstance(1, 3, paramLocale);; localObject2 = java.text.DateFormat.getDateInstance(1, paramLocale))
                              {
                                com.whatsapp.util.l.a((java.text.DateFormat)localObject2);
                                break;
                              }
                              if (j != 0) {}
                              for (localObject2 = java.text.DateFormat.getDateTimeInstance(0, 3, paramLocale);; localObject2 = java.text.DateFormat.getDateInstance(0, paramLocale))
                              {
                                com.whatsapp.util.l.a((java.text.DateFormat)localObject2);
                                break;
                              }
                            }
                          }
                        }
                      }
                      localObject2 = null;
                    }
                  }
                  else if (((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).getCalendar() == E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent.b.b)
                  {
                    if (Build.VERSION.SDK_INT >= 24)
                    {
                      localObject3 = new ULocale(paramLocale + "@calendar=persian");
                      localObject4 = android.icu.util.Calendar.getInstance((ULocale)localObject3);
                      ((android.icu.util.Calendar)localObject4).clear();
                      localStringBuilder = new StringBuilder();
                      if (((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasYear())
                      {
                        ((android.icu.util.Calendar)localObject4).set(1, ((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).getYear());
                        localStringBuilder.append("yyyy");
                      }
                      if (((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasMonth())
                      {
                        ((android.icu.util.Calendar)localObject4).set(2, ((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).getMonth() - 1);
                        localStringBuilder.append("MMMM");
                      }
                      if (((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasDayOfMonth())
                      {
                        ((android.icu.util.Calendar)localObject4).set(5, ((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).getDayOfMonth());
                        localStringBuilder.append("d");
                      }
                      if (((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasDayOfWeek()) {
                        localStringBuilder.append("EEEE");
                      }
                      if (((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasHour())
                      {
                        localStringBuilder.append("jjmm");
                        ((android.icu.util.Calendar)localObject4).set(10, ((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).getHour());
                        if (!((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasMinute()) {
                          break label1704;
                        }
                        ((android.icu.util.Calendar)localObject4).set(12, ((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).getMinute());
                      }
                      for (;;)
                      {
                        if ((((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasDayOfWeek()) && (!((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasYear()) && (!((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasMonth()) && (!((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasDayOfMonth()) && (!((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeComponent)localObject2).hasHour())) {
                          switch (1.c[localObject2.getDayOfWeek().ordinal()])
                          {
                          default: 
                            Log.w("localized component time had invalid day-of-week");
                            localObject2 = null;
                            break;
                            ((android.icu.util.Calendar)localObject4).set(12, 0);
                            break;
                          case 1: 
                            ((android.icu.util.Calendar)localObject4).set(7, 1);
                          }
                        }
                      }
                      for (;;)
                      {
                        localObject2 = localStringBuilder.toString();
                        localObject4 = ((android.icu.util.Calendar)localObject4).getTime();
                        localObject2 = new android.icu.text.SimpleDateFormat(DateTimePatternGenerator.getInstance((ULocale)localObject3).getBestPattern((String)localObject2).replaceAll("([^\\p{Alpha}']|('[\\p{Alpha}]+'))*G+([^\\p{Alpha}']|('[\\p{Alpha}]+'))*", ""), (ULocale)localObject3).format((Date)localObject4);
                        break;
                        ((android.icu.util.Calendar)localObject4).set(7, 2);
                        continue;
                        ((android.icu.util.Calendar)localObject4).set(7, 3);
                        continue;
                        ((android.icu.util.Calendar)localObject4).set(7, 4);
                        continue;
                        ((android.icu.util.Calendar)localObject4).set(7, 5);
                        continue;
                        ((android.icu.util.Calendar)localObject4).set(7, 6);
                        continue;
                        ((android.icu.util.Calendar)localObject4).set(7, 7);
                      }
                    }
                    Log.w("Solar Hijri calendar not supported");
                    localObject2 = null;
                  }
                  else
                  {
                    Log.w("localized component time could not be constructed");
                    localObject2 = null;
                  }
                  break;
                case 2: 
                  label724:
                  label743:
                  label1136:
                  label1704:
                  localObject2 = localHSMLocalizableParameter.getDateTime().getUnixEpoch();
                  if (!((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch)localObject2).hasTimestamp())
                  {
                    Log.w("localized unix epoch time param missing fields");
                    localObject2 = null;
                  }
                  else
                  {
                    localObject2 = new Date(((E2E.Message.HighlyStructuredMessage.HSMLocalizableParameter.HSMDateTime.HSMDateTimeUnixEpoch)localObject2).getTimestamp() * 1000L);
                    if (Build.VERSION.SDK_INT >= 24)
                    {
                      localObject2 = new android.icu.text.SimpleDateFormat(DateTimePatternGenerator.getInstance(paramLocale).getBestPattern("yyyyMMMMdEEEEjjmmz"), paramLocale).format((Date)localObject2);
                    }
                    else if (Build.VERSION.SDK_INT >= 18)
                    {
                      localObject2 = new java.text.SimpleDateFormat(android.text.format.DateFormat.getBestDateTimePattern(paramLocale, "yyyyMMMMdEEEEjjmmz"), paramLocale).format((Date)localObject2);
                    }
                    else
                    {
                      localObject3 = java.text.DateFormat.getDateTimeInstance(1, 3, paramLocale);
                      localObject4 = ((java.text.DateFormat)localObject3).getTimeZone();
                      localObject2 = ((java.text.DateFormat)localObject3).format((Date)localObject2) + ' ' + ((TimeZone)localObject4).getDisplayName(((TimeZone)localObject4).inDaylightTime((Date)localObject2), 0, paramLocale);
                    }
                  }
                  break;
                }
              }
            }
          }
          label2046:
          localObject3 = localHSMLocalizableParameter.getDefault();
        }
        else
        {
          if ((i <= 0) || (i > paramHighlyStructuredMessage.getParamsCount())) {
            break label2083;
          }
          localObject3 = paramHighlyStructuredMessage.getParams(i - 1);
        }
      }
      label2083:
      paramLocale = paramString.substring(localMatcher.start(), localMatcher.end());
      Log.w("unexpected parameter index: replacement=\"" + paramLocale + "\" paramIndex=" + i + " paramsCount=" + paramHighlyStructuredMessage.getLocalizableParamsCount() + i());
      return null;
    }
    localMatcher.appendTail(localStringBuffer);
    return localStringBuffer.toString();
  }
  
  @TargetApi(24)
  private static String a(String paramString, double paramDouble, Locale paramLocale)
  {
    paramLocale = android.icu.text.NumberFormat.getCurrencyInstance(paramLocale);
    try
    {
      android.icu.util.Currency localCurrency = android.icu.util.Currency.getInstance(paramString);
      paramLocale.setCurrency(localCurrency);
      return paramLocale.format(paramDouble);
    }
    catch (IllegalArgumentException paramLocale)
    {
      Log.c("invalid ISO 4217 code; currencyCode=" + paramString, paramLocale);
    }
    return null;
  }
  
  private static String b(String paramString, double paramDouble, Locale paramLocale)
  {
    paramLocale = java.text.NumberFormat.getCurrencyInstance(paramLocale);
    for (;;)
    {
      try
      {
        java.util.Currency localCurrency = java.util.Currency.getInstance(paramString);
        paramLocale.setCurrency(localCurrency);
        if ((paramString.equalsIgnoreCase("BIF")) || (paramString.equalsIgnoreCase("CLP")) || (paramString.equalsIgnoreCase("DJF")) || (paramString.equalsIgnoreCase("GNF")) || (paramString.equalsIgnoreCase("ISK")) || (paramString.equalsIgnoreCase("JPY")) || (paramString.equalsIgnoreCase("KMF")) || (paramString.equalsIgnoreCase("KRW")) || (paramString.equalsIgnoreCase("PYG")) || (paramString.equalsIgnoreCase("RWF")) || (paramString.equalsIgnoreCase("UGX")) || (paramString.equalsIgnoreCase("UYI")) || (paramString.equalsIgnoreCase("VND")) || (paramString.equalsIgnoreCase("VUV")) || (paramString.equalsIgnoreCase("XAF")) || (paramString.equalsIgnoreCase("XOF")) || (paramString.equalsIgnoreCase("XPF")))
        {
          paramLocale.setMinimumFractionDigits(0);
          paramLocale.setMaximumFractionDigits(0);
          return paramLocale.format(paramDouble);
        }
      }
      catch (IllegalArgumentException paramLocale)
      {
        Log.c("invalid ISO 4217 code; currencyCode=" + paramString, paramLocale);
        return null;
      }
      if ((paramString.equalsIgnoreCase("BHD")) || (paramString.equalsIgnoreCase("IQD")) || (paramString.equalsIgnoreCase("JOD")) || (paramString.equalsIgnoreCase("KWD")) || (paramString.equalsIgnoreCase("LYD")) || (paramString.equalsIgnoreCase("OMR")) || (paramString.equalsIgnoreCase("TND")))
      {
        paramLocale.setMinimumFractionDigits(3);
        paramLocale.setMaximumFractionDigits(3);
      }
      else if (paramString.equalsIgnoreCase("CLF"))
      {
        paramLocale.setMinimumFractionDigits(4);
        paramLocale.setMaximumFractionDigits(4);
      }
      else
      {
        paramLocale.setMinimumFractionDigits(2);
        paramLocale.setMaximumFractionDigits(2);
      }
    }
  }
  
  private void g()
  {
    Object localObject = new j.a();
    ((j.a)localObject).c = this.id;
    ((j.a)localObject).a().a = this.jid;
    ((j.a)localObject).b = this.participant;
    ((j.a)localObject).a(this.timestamp);
    ((j.a)localObject).b();
    localObject = ((j.a)localObject).c();
    this.f.a(Message.obtain(null, 0, 117, 0, localObject));
  }
  
  private boolean h()
  {
    return ((com.whatsapp.g.j)c.a().a(com.whatsapp.g.j.class)).a() >= this.expireTimeMs;
  }
  
  private String i()
  {
    return "; id=" + this.id + "; jid=" + this.jid + "; participant=" + this.participant + "; persistentId=" + f();
  }
  
  public final void a()
  {
    Log.i("hsm rehydrate job added" + i());
    Iterator localIterator = e().iterator();
    while (localIterator.hasNext())
    {
      ??? = (Requirement)localIterator.next();
      if ((??? instanceof VNameCertificateRequirement))
      {
        ??? = (VNameCertificateRequirement)???;
        if ((!((VNameCertificateRequirement)???).b()) && (!GetVNameCertificateJob.a(((VNameCertificateRequirement)???).jid))) {
          this.b.a(new GetVNameCertificateJob(((VNameCertificateRequirement)???).jid));
        }
      }
      else if ((??? instanceof HsmMessagePackRequirement))
      {
        HsmMessagePackRequirement localHsmMessagePackRequirement = (HsmMessagePackRequirement)???;
        com.whatsapp.b.a locala = this.h;
        Locale[] arrayOfLocale = localHsmMessagePackRequirement.locales;
        String str = localHsmMessagePackRequirement.namespace;
        synchronized (locala.b)
        {
          locala.d.remove(Pair.create(arrayOfLocale, str));
          if ((!localHsmMessagePackRequirement.b()) && (!GetHsmMessagePackJob.a(this.locales, localHsmMessagePackRequirement.namespace, localHsmMessagePackRequirement.elementName))) {
            this.b.a(new GetHsmMessagePackJob(localHsmMessagePackRequirement.locales, localHsmMessagePackRequirement.namespace, localHsmMessagePackRequirement.elementName));
          }
        }
      }
    }
  }
  
  public final void a(Context paramContext)
  {
    this.a = ad.a();
    this.b = att.a();
    this.f = m.a();
    this.g = com.whatsapp.data.l.a();
    this.h = com.whatsapp.b.a.a();
  }
  
  public final boolean a(Exception paramException)
  {
    Log.c("exception while rehydrating hsm message" + i(), paramException);
    return false;
  }
  
  public final void b()
  {
    Log.i("starting hsm rehydrate job" + i());
    if (h())
    {
      Log.i("hsm rehydrate job expired" + i());
      g();
      return;
    }
    Object localObject2 = this.message.getHighlyStructuredMessage();
    if ((!((E2E.Message.HighlyStructuredMessage)localObject2).hasNamespace()) || (TextUtils.isEmpty(((E2E.Message.HighlyStructuredMessage)localObject2).getNamespace())))
    {
      Log.w("hsm missing namespace" + i());
      g();
      return;
    }
    if ((!((E2E.Message.HighlyStructuredMessage)localObject2).hasElementName()) || (TextUtils.isEmpty(((E2E.Message.HighlyStructuredMessage)localObject2).getElementName())))
    {
      Log.w("hsm missing element" + i());
      g();
      return;
    }
    com.whatsapp.proto.a locala = this.h.a(this.locales, ((E2E.Message.HighlyStructuredMessage)localObject2).getNamespace());
    if (locala == null)
    {
      Log.w("missing hsm pack after requirements satisfied" + i());
      g();
      return;
    }
    if (locala.f() == 0)
    {
      Log.w("server had no hsm pack for namespace" + i());
      g();
      return;
    }
    Locale localLocale = new Locale(locala.d(), locala.e());
    Object localObject3 = com.whatsapp.b.a.a(locala, ((E2E.Message.HighlyStructuredMessage)localObject2).getElementName());
    if (localObject3 == null)
    {
      Log.w("hsm pack does not contain translation element" + i());
      g();
      return;
    }
    Pair localPair = a((E2E.Message.HighlyStructuredMessage)localObject2, (a.b)localObject3);
    if (localPair != null)
    {
      localObject1 = com.whatsapp.j.a.b.a(localLocale);
      if (localObject1 == null)
      {
        Log.w("cannot find plural rules for loc=" + localLocale + i());
        localObject1 = null;
      }
    }
    while (TextUtils.isEmpty((CharSequence)localObject1))
    {
      g();
      return;
      localObject3 = a((a.b)localObject3, ((com.whatsapp.j.a.b)localObject1).a(((Integer)localPair.second).intValue()));
      if (localObject3 == null)
      {
        Log.w("cannot find plural exception for loc=" + localLocale + i());
        localObject1 = null;
      }
      else
      {
        localObject1 = ((a.b.c)localObject3).d;
        if ((localObject1 instanceof String))
        {
          localObject1 = (String)localObject1;
        }
        else
        {
          e locale = (e)localObject1;
          localObject1 = locale.e();
          if (locale.f()) {
            ((a.b.c)localObject3).d = localObject1;
          }
          continue;
          localObject1 = ((a.b)localObject3).d;
          if ((localObject1 instanceof String))
          {
            localObject1 = (String)localObject1;
          }
          else
          {
            locale = (e)localObject1;
            localObject1 = locale.e();
            if (locale.f()) {
              ((a.b)localObject3).d = localObject1;
            }
          }
        }
      }
    }
    Object localObject1 = a((E2E.Message.HighlyStructuredMessage)localObject2, localLocale, (String)localObject1, localPair);
    if (localObject1 == null)
    {
      g();
      return;
    }
    localObject2 = new j.a();
    ((j.a)localObject2).c = this.id;
    ((j.a)localObject2).a().a = this.jid;
    ((j.a)localObject2).b = this.participant;
    ((j.a)localObject2).a(this.timestamp);
    ((j.a)localObject2).i = Integer.valueOf(0);
    ((j.a)localObject2).d = ((String)localObject1);
    if (this.verifiedSender != null) {
      ((j.a)localObject2).b(this.verifiedSender.longValue());
    }
    ((j.a)localObject2).b();
    localObject1 = ((j.a)localObject2).c();
    ((com.whatsapp.protocol.j)localObject1).X |= 0x8;
    if (this.existingMessageRowId != null)
    {
      ((com.whatsapp.protocol.j)localObject1).Q = this.existingMessageRowId.longValue();
      localObject2 = this.g.a(((com.whatsapp.protocol.j)localObject1).e);
      if (localObject2 != null)
      {
        ((com.whatsapp.protocol.j)localObject2).a((com.whatsapp.protocol.j)localObject1);
        localObject1 = localObject2;
        this.a.e((com.whatsapp.protocol.j)localObject1, 6);
      }
    }
    for (;;)
    {
      localObject1 = this.h;
      localObject2 = locala.c();
      ((com.whatsapp.b.a)localObject1).a.a(localLocale, (String)localObject2);
      return;
      break;
      this.a.a((com.whatsapp.protocol.j)localObject1);
    }
  }
  
  public final void c()
  {
    Log.w("canceled rehydrate hsm job" + i());
  }
  
  public final boolean d()
  {
    return (h()) || (super.d());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jobqueue/job/RehydrateHsmJob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */