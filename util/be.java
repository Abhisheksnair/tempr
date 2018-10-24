package com.whatsapp.util;

import a.a.a.a.d;
import android.content.Context;
import android.graphics.Paint;
import android.text.Editable;
import android.text.ParcelableSpan;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import com.whatsapp.MentionableEntry.MentionAnnotationSpan;
import com.whatsapp.MentionableEntry.MentionSpan;
import com.whatsapp.and;
import com.whatsapp.data.q;
import com.whatsapp.emoji.c;
import com.whatsapp.ti;
import java.text.BreakIterator;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class be
{
  public static final Pattern a = Pattern.compile("[\\p{ASCII}&&[^\\p{Alnum}]]");
  private static final ThreadLocal<BreakIterator> b = new ThreadLocal() {};
  private static final ThreadLocal<Collator> c = new ThreadLocal() {};
  
  private static int a(Context paramContext, and paramand)
  {
    if (d.b(paramContext, paramand) < 2011) {
      return 512;
    }
    return 1024;
  }
  
  public static CharSequence a(Context paramContext, and paramand, CharSequence paramCharSequence)
  {
    return a(paramContext, paramand, paramCharSequence, false, -16777216);
  }
  
  private static CharSequence a(Context paramContext, and paramand, CharSequence paramCharSequence, boolean paramBoolean, int paramInt)
  {
    if (paramCharSequence == null)
    {
      paramCharSequence = null;
      return paramCharSequence;
    }
    int i2 = paramCharSequence.length();
    int i = 32;
    int m = 32;
    int k = -1;
    Object localObject3 = null;
    Object localObject2 = null;
    int n = 0;
    Object localObject1 = null;
    Object localObject4;
    if (n < i2)
    {
      int j = paramCharSequence.charAt(n);
      label125:
      Object localObject5;
      if ((j == 42) || (j == 95) || (j == 126))
      {
        if (localObject3 == null)
        {
          localObject4 = new int[3];
          m = 0;
          for (;;)
          {
            localObject3 = localObject4;
            if (m >= 3) {
              break;
            }
            localObject4[m] = -1;
            m += 1;
          }
        }
        if (j == 42)
        {
          m = 0;
          if ((localObject3[m] >= 0) || (i == j) || ((!Character.isWhitespace(i)) && (i != 95) && (i != 126) && (i != 42))) {
            break label279;
          }
          localObject5 = localObject1;
          localObject4 = localObject2;
          if (n + 1 >= i2) {
            break label543;
          }
          localObject5 = localObject1;
          localObject4 = localObject2;
          if (Character.isWhitespace(paramCharSequence.charAt(n + 1))) {
            break label543;
          }
          localObject3[m] = (n + 1);
          localObject4 = localObject1;
          localObject1 = localObject3;
          localObject3 = localObject4;
        }
      }
      for (;;)
      {
        label231:
        n += 1;
        localObject4 = localObject1;
        localObject1 = localObject3;
        m = i;
        i = j;
        localObject3 = localObject4;
        break;
        if (j == 95)
        {
          m = 1;
          break label125;
        }
        m = 2;
        break label125;
        label279:
        localObject5 = localObject1;
        localObject4 = localObject2;
        if (localObject3[m] >= 0)
        {
          localObject5 = localObject1;
          localObject4 = localObject2;
          if (!Character.isWhitespace(i))
          {
            if (localObject3[m] >= n) {
              break label1159;
            }
            if (localObject1 != null) {
              break label1156;
            }
            label339:
            label353:
            int i1;
            if ((paramCharSequence instanceof Editable))
            {
              localObject1 = (Editable)paramCharSequence;
              if (localObject2 != null) {
                break label1153;
              }
              localObject2 = new ArrayList();
              i1 = localObject3[m];
              switch (j)
              {
              default: 
                localObject4 = null;
              }
            }
            for (;;)
            {
              ((ArrayList)localObject2).add(new a(i1, n, 1, (ParcelableSpan)localObject4));
              if (((ArrayList)localObject2).size() >= a(paramContext, paramand)) {
                break label1165;
              }
              label432:
              i1 = 0;
              while (i1 < localObject3.length)
              {
                if ((i1 != m) && (localObject3[m] < localObject3[i1])) {
                  localObject3[i1] = -1;
                }
                i1 += 1;
              }
              localObject1 = new SpannableStringBuilder(paramCharSequence);
              break;
              localObject4 = new StyleSpan(1);
              continue;
              localObject4 = new StyleSpan(2);
              continue;
              localObject4 = new StrikethroughSpan();
            }
            localObject3[m] = -1;
            localObject4 = localObject2;
            localObject5 = localObject1;
          }
        }
        label543:
        localObject1 = localObject3;
        localObject2 = localObject4;
        localObject3 = localObject5;
        continue;
        if ((j != 96) || (i != 96) || (m != 96)) {
          break label850;
        }
        if (k < 0)
        {
          k = n + 1;
          localObject4 = localObject1;
          localObject1 = localObject3;
          localObject3 = localObject4;
        }
        else
        {
          if (k >= n - 2) {
            break label1131;
          }
          if (localObject1 != null) {
            break label1146;
          }
          if ((paramCharSequence instanceof Editable)) {}
          for (localObject4 = (Editable)paramCharSequence;; localObject4 = new SpannableStringBuilder(paramCharSequence))
          {
            label632:
            localObject5 = localObject2;
            if (localObject2 == null) {
              localObject5 = new ArrayList();
            }
            ((ArrayList)localObject5).add(new a(k, n - 2, 3, new TypefaceSpan("monospace")));
            a((Editable)localObject4, k - 3, n + 1, ti.class);
            localObject1 = new ArrayList();
            localObject2 = ((ArrayList)localObject5).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              a locala = (a)((Iterator)localObject2).next();
              if ((locala.a > k - 1) && (locala.b < n - 2)) {
                ((ArrayList)localObject1).add(locala);
              }
            }
          }
          ((ArrayList)localObject5).removeAll((Collection)localObject1);
          if (localObject3 != null)
          {
            k = 0;
            while (k < localObject3.length)
            {
              localObject3[k] = -1;
              k += 1;
            }
          }
          if (((ArrayList)localObject5).size() >= a(paramContext, paramand)) {
            break label888;
          }
          k = -1;
          localObject1 = localObject3;
          localObject2 = localObject5;
          localObject3 = localObject4;
        }
      }
      label850:
      if ((j == 10) && (localObject3 != null))
      {
        m = 0;
        while (m < localObject3.length)
        {
          localObject3[m] = -1;
          m += 1;
        }
        label888:
        localObject1 = localObject4;
        localObject2 = localObject5;
      }
    }
    label1131:
    label1146:
    label1153:
    label1156:
    label1159:
    label1165:
    for (;;)
    {
      if ((localObject1 != null) && (localObject2 != null))
      {
        paramContext = ((ArrayList)localObject2).iterator();
        if (paramContext.hasNext())
        {
          paramand = (a)paramContext.next();
          if (paramBoolean)
          {
            ((Editable)localObject1).setSpan(new ForegroundColorSpan(0x33000000 | 0xFFFFFF & paramInt), paramand.a - paramand.c, paramand.a, 18);
            ((Editable)localObject1).setSpan(new ForegroundColorSpan(0x33000000 | 0xFFFFFF & paramInt), paramand.b, paramand.b + paramand.c, 18);
          }
          for (;;)
          {
            ((Editable)localObject1).setSpan(paramand.d, paramand.a, paramand.b, 18);
            break;
            k = paramand.a;
            while (k > paramand.a - paramand.c)
            {
              ((Editable)localObject1).replace(k - 1, k, "​");
              k -= 1;
            }
            k = paramand.b;
            while (k < paramand.b + paramand.c)
            {
              ((Editable)localObject1).replace(k, k + 1, "​");
              k += 1;
            }
          }
        }
      }
      if (localObject1 == null) {
        break;
      }
      return (CharSequence)localObject1;
      localObject4 = localObject1;
      localObject1 = localObject3;
      localObject3 = localObject4;
      break label231;
      localObject4 = localObject1;
      break label632;
      break label353;
      break label339;
      break label432;
    }
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    if (paramLong < 0L) {
      return Formatter.formatShortFileSize(paramContext, paramLong);
    }
    if (paramLong == 0L) {
      return paramContext.getString(2131298217);
    }
    if (paramLong < 1024L) {
      return paramContext.getString(2131297247, new Object[] { Double.valueOf(paramLong / 1024.0D) });
    }
    return Formatter.formatShortFileSize(paramContext, paramLong);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length << 1);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      localStringBuilder.append(Character.forDigit(k >> 4 & 0xF, 16));
      localStringBuilder.append(Character.forDigit(k & 0xF, 16));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static BreakIterator a()
  {
    return (BreakIterator)b.get();
  }
  
  public static <T> ArrayList<T> a(Spannable paramSpannable, Class<T> paramClass)
  {
    int j = 0;
    paramClass = paramSpannable.getSpans(0, paramSpannable.length(), paramClass);
    if ((paramClass == null) || (paramClass.length == 0)) {
      paramClass = null;
    }
    ArrayList localArrayList;
    int k;
    do
    {
      return paramClass;
      localArrayList = new ArrayList(Arrays.asList(paramClass));
      Collections.sort(localArrayList, new Comparator()
      {
        public final int compare(Object paramAnonymousObject1, Object paramAnonymousObject2)
        {
          if (this.a.getSpanStart(paramAnonymousObject1) < this.a.getSpanStart(paramAnonymousObject2)) {}
          do
          {
            return -1;
            if (this.a.getSpanStart(paramAnonymousObject1) > this.a.getSpanStart(paramAnonymousObject2)) {
              return 1;
            }
            if (this.a.getSpanEnd(paramAnonymousObject1) < this.a.getSpanEnd(paramAnonymousObject2)) {
              return 1;
            }
          } while (this.a.getSpanEnd(paramAnonymousObject1) > this.a.getSpanEnd(paramAnonymousObject2));
          return 0;
        }
      });
      k = localArrayList.size();
      paramClass = localArrayList;
    } while (j >= k - 1);
    paramClass = localArrayList.get(j);
    Object localObject = localArrayList.get(j + 1);
    int i = paramSpannable.getSpanStart(paramClass);
    int m = paramSpannable.getSpanEnd(paramClass);
    int n = paramSpannable.getSpanStart(localObject);
    int i1 = paramSpannable.getSpanEnd(localObject);
    if ((i <= n) && (m > n)) {
      if (i1 <= m)
      {
        i = j + 1;
        paramSpannable.removeSpan(localObject);
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        localArrayList.remove(i);
        k -= 1;
        break;
        if (m - i > i1 - n)
        {
          i = j + 1;
          paramSpannable.removeSpan(localObject);
          continue;
        }
        if (m - i >= i1 - n) {
          break label239;
        }
        paramSpannable.removeSpan(paramClass);
        i = j;
        continue;
      }
      j += 1;
      break;
      label239:
      i = -1;
    }
  }
  
  public static void a(Context paramContext, and paramand, Editable paramEditable, Paint paramPaint)
  {
    c.a(paramEditable, paramContext, paramPaint);
    ForegroundColorSpan[] arrayOfForegroundColorSpan = (ForegroundColorSpan[])paramEditable.getSpans(0, paramEditable.length(), ForegroundColorSpan.class);
    int j = arrayOfForegroundColorSpan.length;
    int i = 0;
    while (i < j)
    {
      ForegroundColorSpan localForegroundColorSpan = arrayOfForegroundColorSpan[i];
      if ((!(localForegroundColorSpan instanceof MentionableEntry.MentionAnnotationSpan)) && (!(localForegroundColorSpan instanceof MentionableEntry.MentionSpan))) {
        paramEditable.removeSpan(localForegroundColorSpan);
      }
      i += 1;
    }
    a(paramEditable, 0, paramEditable.length(), StyleSpan.class);
    a(paramEditable, 0, paramEditable.length(), StrikethroughSpan.class);
    a(paramEditable, 0, paramEditable.length(), TypefaceSpan.class);
    a(paramContext, paramand, paramEditable, true, paramPaint.getColor());
  }
  
  private static <T> void a(Editable paramEditable, int paramInt1, int paramInt2, Class<T> paramClass)
  {
    paramClass = paramEditable.getSpans(paramInt1, paramInt2, paramClass);
    if (paramClass != null)
    {
      paramInt2 = paramClass.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramEditable.removeSpan(paramClass[paramInt1]);
        paramInt1 += 1;
      }
    }
  }
  
  public static boolean a(CharSequence paramCharSequence)
  {
    boolean bool2 = false;
    int j;
    boolean bool1;
    if (paramCharSequence != null)
    {
      j = paramCharSequence.length();
      if (j != 0) {}
    }
    else
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label64;
      }
      char c1 = paramCharSequence.charAt(i);
      if (c1 != '​')
      {
        bool1 = bool2;
        if (!Character.isWhitespace(c1)) {
          break;
        }
      }
      i += 1;
    }
    label64:
    return true;
  }
  
  public static boolean a(String paramString, List<String> paramList)
  {
    if (paramString == null) {
      return false;
    }
    paramString = a.matcher(paramString).replaceAll(" ");
    paramList = paramList.iterator();
    BreakIterator localBreakIterator;
    int j;
    int i;
    if (paramList.hasNext())
    {
      String str = (String)paramList.next();
      localBreakIterator = a();
      localBreakIterator.setText(paramString);
      j = localBreakIterator.first();
      i = localBreakIterator.next();
      label70:
      if (i != -1) {
        if (q.a(paramString.substring(j, i)).startsWith(str))
        {
          i = 1;
          label94:
          if (i != 0) {
            break label122;
          }
        }
      }
    }
    for (boolean bool = false;; bool = true)
    {
      return bool;
      int k = localBreakIterator.next();
      j = i;
      i = k;
      break label70;
      i = 0;
      break label94;
      label122:
      break;
    }
  }
  
  public static byte[] a(String paramString)
  {
    int k = paramString.length();
    if (k % 2 != 0) {
      throw new IllegalArgumentException("even length input string required; length=" + k);
    }
    byte[] arrayOfByte = new byte[k / 2];
    int i = 0;
    if (i < k)
    {
      char c1 = paramString.charAt(i);
      int m = Character.digit(c1, 16);
      if (m == -1) {
        throw new IllegalArgumentException("invalid character; char=" + c1);
      }
      int n = i / 2;
      int i1 = arrayOfByte[(i / 2)];
      if (i % 2 == 0) {}
      for (int j = 4;; j = 0)
      {
        arrayOfByte[n] = ((byte)(m << j | i1));
        i += 1;
        break;
      }
    }
    return arrayOfByte;
  }
  
  public static String b(String paramString)
  {
    if ((paramString == null) || (paramString.codePointCount(0, paramString.length()) <= 65536)) {
      return paramString;
    }
    return paramString.substring(0, paramString.offsetByCodePoints(0, 65536));
  }
  
  public static Collator b()
  {
    return (Collator)c.get();
  }
  
  public static boolean b(Context paramContext, and paramand, CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {}
    while (a(a(paramContext, paramand, paramCharSequence))) {
      return false;
    }
    return true;
  }
  
  public static ArrayList<String> c(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return localArrayList;
      paramString = a.matcher(paramString).replaceAll(" ");
      BreakIterator localBreakIterator = a();
      localBreakIterator.setText(paramString);
      int j = localBreakIterator.first();
      int k;
      for (int i = localBreakIterator.next(); i != -1; i = k)
      {
        String str = q.a(paramString.substring(j, i));
        if ((!TextUtils.isEmpty(str)) && (!Character.isSpaceChar(str.codePointAt(0)))) {
          localArrayList.add(str);
        }
        k = localBreakIterator.next();
        j = i;
      }
    }
  }
  
  public static String d(String paramString)
  {
    return paramString.replace('+', '-').replace('/', '_');
  }
  
  static final class a
  {
    final int a;
    final int b;
    final int c;
    final ParcelableSpan d;
    
    a(int paramInt1, int paramInt2, int paramInt3, ParcelableSpan paramParcelableSpan)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramParcelableSpan;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */