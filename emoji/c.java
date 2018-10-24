package com.whatsapp.emoji;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import com.whatsapp.aoa;

public final class c
{
  private static final boolean a;
  private static boolean b;
  
  static
  {
    if ((Build.MANUFACTURER.startsWith("Sony")) && (Build.VERSION.SDK_INT < 19)) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public static int a(int paramInt)
  {
    if (a) {
      return 1;
    }
    return Character.charCount(paramInt);
  }
  
  public static int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramCharSequence == null) {
      throw new NullPointerException("str == null");
    }
    int i = paramCharSequence.length();
    if ((paramInt1 < 0) || (paramInt2 > i) || (paramInt1 > paramInt2)) {
      throw new IndexOutOfBoundsException();
    }
    paramCharSequence = new b(paramCharSequence);
    int j = 0;
    i = paramInt1;
    paramInt1 = j;
    while (i < paramInt2)
    {
      paramCharSequence.a = i;
      i += paramCharSequence.a(i, a.a.a.a.d.a(paramCharSequence));
      paramInt1 += 1;
    }
    return paramInt1;
  }
  
  public static SpannableStringBuilder a(CharSequence paramCharSequence, Context paramContext, Paint paramPaint, float paramFloat, c paramc)
  {
    if (paramPaint == null) {}
    for (paramPaint = f.a();; paramPaint = new g(paramPaint, paramFloat)) {
      return a(paramCharSequence, paramContext, paramPaint, paramc);
    }
  }
  
  private static SpannableStringBuilder a(CharSequence paramCharSequence, Context paramContext, Paint paramPaint, c paramc)
  {
    return a(paramCharSequence, paramContext, paramPaint, 1.0F, paramc);
  }
  
  private static SpannableStringBuilder a(CharSequence paramCharSequence, Context paramContext, e parame, c paramc)
  {
    Object localObject2;
    if (paramCharSequence == null) {
      localObject2 = null;
    }
    label144:
    label201:
    label305:
    label307:
    label334:
    do
    {
      int j;
      int i;
      int n;
      Object localObject1;
      do
      {
        return (SpannableStringBuilder)localObject2;
        b localb = new b(paramCharSequence);
        int m = paramCharSequence.length();
        j = 0;
        i = 0;
        localObject2 = null;
        if (j >= m) {
          break label334;
        }
        localb.a = j;
        int k = a.a.a.a.d.a(localb);
        n = localb.a(j, k);
        if (k == -1) {
          break label307;
        }
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          if ((paramCharSequence instanceof SpannableStringBuilder)) {
            localObject1 = (SpannableStringBuilder)paramCharSequence;
          }
        }
        else
        {
          localObject3 = d.a(paramContext, k);
          if (localObject3 == null) {
            break label305;
          }
          localObject2 = parame.a((Drawable)localObject3);
          if (localObject2 != null) {
            break label201;
          }
          localObject2 = new ImageSpan(parame.a((Drawable)localObject3, paramContext), 0);
        }
        for (;;)
        {
          if (a)
          {
            localObject3 = new StringBuilder(n);
            k = 0;
            for (;;)
            {
              if (k < n)
              {
                ((StringBuilder)localObject3).append(65535);
                k += 1;
                continue;
                localObject1 = new SpannableStringBuilder(paramCharSequence);
                break;
                if ((localObject2 instanceof j)) {
                  ((j)localObject2).b = i;
                }
                break label144;
              }
            }
            ((SpannableStringBuilder)localObject1).replace(i, i + n, (CharSequence)localObject3, 0, n);
          }
        }
        ((SpannableStringBuilder)localObject1).setSpan(localObject2, i, i + n, 33);
        localObject3 = localObject1;
        if (paramc == null) {
          break;
        }
        localObject2 = localObject1;
      } while (!paramc.a(true, j));
      Object localObject3 = localObject1;
      do
      {
        do
        {
          j += n;
          i += n;
          localObject2 = localObject3;
          break;
          return null;
          localObject3 = localObject2;
        } while (paramc == null);
        localObject3 = localObject2;
      } while (paramc.a(false, j));
      return (SpannableStringBuilder)localObject2;
    } while (!(paramCharSequence instanceof SpannableStringBuilder));
    return (SpannableStringBuilder)paramCharSequence;
  }
  
  public static CharSequence a(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence == null) {
      throw new NullPointerException("str == null");
    }
    int i = paramCharSequence.length();
    if ((paramInt1 < 0) || (paramInt2 > i) || (paramInt1 > paramInt2)) {
      throw new IndexOutOfBoundsException();
    }
    b localb = new b(paramCharSequence);
    i = 0;
    int j = paramInt1;
    while (j < paramInt2)
    {
      localb.a = j;
      int k = j + localb.a(j, a.a.a.a.d.a(localb));
      int m = i + 1;
      j = k;
      i = m;
      if (m >= paramInt3) {
        return paramCharSequence.subSequence(paramInt1, k);
      }
    }
    return null;
  }
  
  public static CharSequence a(CharSequence paramCharSequence, Context paramContext)
  {
    paramContext = a(paramCharSequence, paramContext, f.a(), null);
    if (paramContext == null) {
      return paramCharSequence;
    }
    return paramContext;
  }
  
  public static CharSequence a(CharSequence paramCharSequence, Context paramContext, Paint paramPaint)
  {
    paramContext = a(paramCharSequence, paramContext, paramPaint, null);
    if (paramContext == null) {
      return paramCharSequence;
    }
    return paramContext;
  }
  
  public static CharSequence a(CharSequence paramCharSequence, Context paramContext, Paint paramPaint, float paramFloat)
  {
    paramContext = a(paramCharSequence, paramContext, paramPaint, paramFloat, null);
    if (paramContext == null) {
      return paramCharSequence;
    }
    return paramContext;
  }
  
  public static CharSequence a(String paramString, Context paramContext, Paint paramPaint)
  {
    a locala = new a();
    paramPaint = a(paramString, paramContext, paramPaint, locala);
    if (paramPaint == null) {
      return paramString;
    }
    int i = locala.c;
    paramContext = paramPaint;
    if (i > 0)
    {
      paramContext = paramPaint.delete(i + (Character.charCount(paramString.codePointAt(i - 1)) - 1), paramPaint.length());
      paramContext.append("…");
    }
    return paramContext;
  }
  
  public static String a(CharSequence paramCharSequence)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    b localb = new b(paramCharSequence);
    int k = paramCharSequence.length();
    int i = 0;
    while (i < k)
    {
      localb.a = i;
      int m = a.a.a.a.d.a(localb);
      int n = localb.a(i, m);
      if (m != -1)
      {
        int j = 0;
        while (j < m >>> 24)
        {
          localStringBuilder.append(' ');
          j += 1;
        }
      }
      localStringBuilder.append(paramCharSequence.subSequence(i, i + n));
      i += n;
    }
    return localStringBuilder.toString();
  }
  
  public static String a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    if (paramCharSequence == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    b localb = new b(paramCharSequence);
    int k = paramCharSequence.length();
    int i = 0;
    if (i < k)
    {
      localb.a = i;
      int j = a.a.a.a.d.a(localb);
      int m = localb.a(i, j);
      if (j != -1) {
        if ((Build.VERSION.SDK_INT < 16) || (paramBoolean)) {
          localStringBuilder.append('□');
        }
      }
      for (;;)
      {
        i += m;
        break;
        if (j >>> 24 == 1)
        {
          localb.a = i;
          int n = localb.a();
          switch (n)
          {
          }
          for (j = 1;; j = 0)
          {
            if ((j == 0) && (Build.VERSION.SDK_INT < 19)) {
              break label1569;
            }
            localStringBuilder.append(Character.toChars(n));
            break;
          }
          label1569:
          localStringBuilder.append('□');
        }
        else if (Build.VERSION.SDK_INT >= 23)
        {
          localStringBuilder.append(paramCharSequence.subSequence(i, i + m));
        }
        else
        {
          localStringBuilder.append('□');
          continue;
          localStringBuilder.append(paramCharSequence.subSequence(i, i + m));
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    return a(paramString, false);
  }
  
  public static void a(Editable paramEditable, Context paramContext, Paint paramPaint)
  {
    if (b) {
      return;
    }
    b = true;
    Object localObject1 = paramEditable.toString();
    Object localObject2 = (ImageSpan[])paramEditable.getSpans(0, ((String)localObject1).length(), ImageSpan.class);
    int j = localObject2.length;
    int i = 0;
    while (i < j)
    {
      paramEditable.removeSpan(localObject2[i]);
      i += 1;
    }
    int m;
    int k;
    if (a)
    {
      m = ((String)localObject1).length();
      j = 0;
      int n;
      for (i = 0; j < m; i = k + n)
      {
        int i1 = ((String)localObject1).codePointAt(j);
        n = Character.charCount(i1);
        k = i;
        if (n > 1)
        {
          k = i;
          if (d(i1))
          {
            paramEditable.replace(i, i + n, b(i1));
            k = i - (n - 1);
          }
        }
        j += n;
      }
      localObject1 = paramEditable.toString();
    }
    for (;;)
    {
      localObject2 = new b((CharSequence)localObject1);
      j = ((String)localObject1).length();
      i = 0;
      Drawable localDrawable;
      if (i < j)
      {
        ((b)localObject2).a = i;
        m = a.a.a.a.d.a((b)localObject2);
        k = ((b)localObject2).a(i, m);
        if (m != -1)
        {
          localDrawable = d.a(paramContext, m);
          if (localDrawable != null) {
            if (paramPaint == null) {
              break label354;
            }
          }
        }
      }
      label354:
      for (localObject1 = paramPaint.getFontMetricsInt();; localObject1 = null)
      {
        if (localObject1 != null)
        {
          m = (int)(paramPaint.getTextSize() * 1.3F + 0.5F);
          localDrawable.setBounds(0, 0, m, m);
        }
        for (localObject1 = new j(localDrawable, (Paint.FontMetricsInt)localObject1);; localObject1 = new ImageSpan(localDrawable, 0))
        {
          paramEditable.setSpan(localObject1, i, i + k, 33);
          i += k;
          break;
          localDrawable.setBounds(0, 0, (int)aoa.b(paramContext), (int)aoa.b(paramContext));
        }
        b = false;
        return;
      }
    }
  }
  
  public static int b(CharSequence paramCharSequence)
  {
    b localb = new b(paramCharSequence);
    int j = 0;
    int i = 0;
    while (j < paramCharSequence.length())
    {
      localb.a = j;
      int k = a.a.a.a.d.a(localb);
      if (k == -1) {
        return 0;
      }
      j += localb.a(j, k);
      k = i + 1;
      i = k;
      if (k > 3) {
        return 0;
      }
    }
    return i;
  }
  
  public static String b(int paramInt)
  {
    if ((a) && (d(paramInt))) {
      return new String(Character.toChars(0xFFFF & paramInt));
    }
    return new String(Character.toChars(paramInt));
  }
  
  public static String b(String paramString)
  {
    if (!a) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = 0;
    if (j < paramString.length())
    {
      int i = paramString.charAt(j);
      if (d(i | 0x10000)) {
        localStringBuilder.append(Character.toChars(i | 0x10000));
      }
      for (;;)
      {
        j += 1;
        break;
        localStringBuilder.append(i);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static int c(CharSequence paramCharSequence)
  {
    return a(paramCharSequence, 0, paramCharSequence.length());
  }
  
  private static boolean d(int paramInt)
  {
    return (paramInt >= 126980) && (paramInt <= 129472);
  }
  
  static final class a
    implements c.c
  {
    final int a = 128;
    int b = 0;
    int c = 0;
    
    public final boolean a(boolean paramBoolean, int paramInt)
    {
      if (paramBoolean) {
        this.b += 1;
      }
      if (this.b >= this.a)
      {
        this.c = paramInt;
        return false;
      }
      return true;
    }
  }
  
  static final class b
    implements b
  {
    int a;
    private final CharSequence b;
    
    b(CharSequence paramCharSequence)
    {
      this.b = paramCharSequence;
    }
    
    public final int a()
    {
      while (this.a < this.b.length())
      {
        int j = Character.codePointAt(this.b, this.a);
        this.a += Character.charCount(j);
        if ((j != 65039) && (j != 65038))
        {
          int i = j;
          if (c.a())
          {
            i = j;
            if (c.c(j | 0x10000)) {
              i = j | 0x10000;
            }
          }
          return i;
        }
      }
      return 0;
    }
    
    final int a(int paramInt1, int paramInt2)
    {
      int i = 0;
      int j;
      if (paramInt2 != -1)
      {
        int k;
        for (j = 0; i < paramInt2 >>> 24; j = k)
        {
          int m = Character.codePointAt(this.b, paramInt1 + j);
          k = j + Character.charCount(m);
          if (m != 65039)
          {
            j = i;
            if (m != 65038) {}
          }
          else
          {
            j = i - 1;
          }
          i = j + 1;
        }
        if (paramInt1 + j < this.b.length())
        {
          paramInt1 = Character.codePointAt(this.b, paramInt1 + j);
          if ((paramInt1 == 65039) || (paramInt1 == 65038)) {
            return Character.charCount(paramInt1) + j;
          }
        }
      }
      else
      {
        return Character.charCount(Character.codePointAt(this.b, paramInt1));
      }
      return j;
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean a(boolean paramBoolean, int paramInt);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/emoji/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */