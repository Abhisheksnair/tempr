package com.whatsapp.util;

import android.content.Context;
import android.support.v4.content.b;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import java.text.BreakIterator;
import java.text.CollationKey;
import java.text.Collator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class bg
{
  public static final bg a = new bg()
  {
    final void a(Context paramAnonymousContext, Spannable paramAnonymousSpannable, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      paramAnonymousSpannable.setSpan(new ForegroundColorSpan(b.c(paramAnonymousContext, 2131624109)), paramAnonymousInt1, paramAnonymousInt2, 33);
    }
  };
  public static final bg b = new bg()
  {
    final void a(Context paramAnonymousContext, Spannable paramAnonymousSpannable, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      paramAnonymousSpannable.setSpan(new BackgroundColorSpan(65280), paramAnonymousInt1, paramAnonymousInt2, 33);
    }
  };
  
  public static CharSequence a(Context paramContext, CharSequence paramCharSequence, List<String> paramList)
  {
    return a(paramContext, paramCharSequence, paramList, a);
  }
  
  public static CharSequence a(Context paramContext, CharSequence paramCharSequence, List<String> paramList, bg parambg)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    BreakIterator localBreakIterator;
    int k;
    int j;
    Collator localCollator;
    int i;
    String str2;
    Object localObject3;
    int m;
    if (paramList != null)
    {
      localObject1 = localObject2;
      if (!paramList.isEmpty())
      {
        String str1 = be.a.matcher(paramCharSequence).replaceAll(" ");
        localBreakIterator = be.a();
        localBreakIterator.setText(str1);
        k = localBreakIterator.first();
        j = localBreakIterator.next();
        localObject1 = null;
        localObject2 = null;
        localCollator = null;
        i = -1;
        if (j != -1)
        {
          str2 = str1.substring(k, j);
          if (localCollator != null) {
            break label356;
          }
          localCollator = be.b();
          localObject3 = new CollationKey[paramList.size()];
          m = paramList.size() - 1;
          while (m >= 0)
          {
            localObject2 = (String)paramList.get(m);
            localObject3[m] = localCollator.getCollationKey((String)paramList.get(m));
            i = Math.max(i, ((String)localObject2).length());
            m -= 1;
          }
        }
      }
    }
    for (;;)
    {
      int i1 = Math.min(str2.length(), i);
      m = 1;
      while (m <= i1)
      {
        CollationKey localCollationKey = localCollator.getCollationKey(str2.substring(0, m));
        int i2 = localObject3.length;
        int n = 0;
        if (n < i2)
        {
          localObject2 = localObject1;
          if (localCollationKey.compareTo(localObject3[n]) == 0)
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              if (!(paramCharSequence instanceof Spannable)) {
                break label302;
              }
            }
          }
          label302:
          for (localObject2 = (Spannable)paramCharSequence;; localObject2 = new SpannableStringBuilder(paramCharSequence))
          {
            parambg.a(paramContext, (Spannable)localObject2, k, k + m);
            n += 1;
            localObject1 = localObject2;
            break;
          }
        }
        m += 1;
      }
      m = localBreakIterator.next();
      k = j;
      j = m;
      localObject2 = localObject3;
      break;
      if (localObject1 == null) {
        return paramCharSequence;
      }
      return (CharSequence)localObject1;
      label356:
      localObject3 = localObject2;
    }
  }
  
  public static CharSequence b(Context paramContext, CharSequence paramCharSequence, List<String> paramList)
  {
    return a(paramContext, paramCharSequence, paramList, b);
  }
  
  abstract void a(Context paramContext, Spannable paramSpannable, int paramInt1, int paramInt2);
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/bg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */