package com.whatsapp.registration;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.CharacterStyle;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import com.whatsapp.aoa;
import com.whatsapp.u;

public final class CodeInputField
  extends EditText
{
  private static Typeface c;
  public char a;
  public char b;
  private int d;
  private e e;
  
  public CodeInputField(Context paramContext)
  {
    super(paramContext);
  }
  
  public CodeInputField(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CodeInputField(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(21)
  public CodeInputField(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public static b a(Context paramContext)
  {
    return new g(paramContext);
  }
  
  public static String a(CharSequence paramCharSequence)
  {
    return paramCharSequence.toString().replaceAll("[^0-9]", "");
  }
  
  public static String b(CharSequence paramCharSequence)
  {
    return paramCharSequence.toString().replaceAll("[^0-9, ]", "");
  }
  
  public final void a(a parama, char paramChar1, char paramChar2, b paramb)
  {
    this.d = 6;
    this.a = paramChar1;
    this.b = paramChar2;
    parama = new e(parama, this, paramb, (byte)0);
    this.e = parama;
    addTextChangedListener(parama);
    setCode("");
    if (c == null) {
      c = Typeface.createFromAsset(u.a().getAssets(), "fonts/RobotoMono-Regular.ttf");
    }
    setTypeface(c);
  }
  
  public final String getCode()
  {
    return a(getText());
  }
  
  protected final void onSelectionChanged(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2)
    {
      int i = getText().toString().indexOf(this.a);
      if ((i >= 0) && (paramInt1 > i)) {
        setSelection(i);
      }
    }
    super.onSelectionChanged(paramInt1, paramInt2);
  }
  
  public final void setCode(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    int i = paramString.length();
    while (i < this.d + 1)
    {
      localStringBuilder.append(this.a);
      i += 1;
    }
    localStringBuilder.insert(this.d / 2, ' ');
    e.a(this.e, true);
    setText(localStringBuilder);
    setSelection(paramString.length() + 1);
    e.a(this.e, false);
  }
  
  public final void setPasswordTransformationEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (c localc = new c(this);; localc = null)
    {
      setTransformationMethod(localc);
      return;
    }
  }
  
  public final void setRegistrationVoiceCodeLength(int paramInt)
  {
    this.d = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
    
    public abstract void b(String paramString);
  }
  
  public static abstract interface b
  {
    public abstract SpannableStringBuilder a(String paramString);
  }
  
  public static final class c
    extends PasswordTransformationMethod
  {
    int a = -1;
    final CodeInputField b;
    private Runnable c;
    private CodeInputField.d d;
    private String e = "";
    
    public c(CodeInputField paramCodeInputField)
    {
      this.b = paramCodeInputField;
    }
    
    final void a()
    {
      if ((this.b.getHandler() != null) && (this.c != null)) {
        this.b.getHandler().removeCallbacks(this.c);
      }
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      super.afterTextChanged(paramEditable);
      if (this.c == null) {
        this.c = h.a(this);
      }
      if (this.e.equals(CodeInputField.b(paramEditable))) {}
      do
      {
        return;
        this.e = CodeInputField.b(paramEditable);
        this.d.a(paramEditable);
      } while (this.b.getHandler() == null);
      this.b.getHandler().removeCallbacks(this.c);
      this.b.getHandler().postDelayed(this.c, 1500L);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      super.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      a();
    }
    
    public final CharSequence getTransformation(CharSequence paramCharSequence, View paramView)
    {
      this.d = new CodeInputField.d(paramCharSequence, this);
      return this.d;
    }
  }
  
  public static final class d
    implements Spannable, CharSequence
  {
    long[] a;
    private final CodeInputField.c b;
    private Spannable c;
    
    public d(CharSequence paramCharSequence, CodeInputField.c paramc)
    {
      this.b = paramc;
      this.c = ((Spannable)paramCharSequence);
      a(paramCharSequence);
    }
    
    public final void a(CharSequence paramCharSequence)
    {
      this.a = new long[paramCharSequence.length()];
      int i = 0;
      int j = -1;
      if (i < this.a.length)
      {
        if ((paramCharSequence.charAt(i) != CodeInputField.c.a(this.b).a) && (paramCharSequence.charAt(i) != ' '))
        {
          this.a[i] = System.currentTimeMillis();
          int n = i + 1;
          k = j;
          if (n < this.a.length)
          {
            int m = n;
            if (paramCharSequence.charAt(n) == ' ') {
              m = n + 1;
            }
            k = j;
            if (m < this.a.length)
            {
              k = j;
              if (paramCharSequence.charAt(m) != CodeInputField.c.a(this.b).a) {}
            }
          }
        }
        for (int k = i;; k = j)
        {
          i += 1;
          j = k;
          break;
          this.a[i] = -1L;
        }
      }
      if ((j != -1) && (((this.b.a != -1) && (this.b.a < j)) || ((j == 0) && (this.b.a == -1)))) {
        this.a[j] = -1L;
      }
      this.b.a = j;
    }
    
    public final char charAt(int paramInt)
    {
      if ((paramInt < this.a.length) && (this.a[paramInt] == -1L)) {
        this.a[paramInt] = (System.currentTimeMillis() + 1500L);
      }
      char c1 = this.c.charAt(paramInt);
      if ((paramInt < this.a.length) && (System.currentTimeMillis() < this.a[paramInt])) {}
      while ((c1 == CodeInputField.c.a(this.b).a) || (c1 == ' ')) {
        return c1;
      }
      return CodeInputField.c.a(this.b).b;
    }
    
    public final int getSpanEnd(Object paramObject)
    {
      return this.c.getSpanEnd(paramObject);
    }
    
    public final int getSpanFlags(Object paramObject)
    {
      return this.c.getSpanFlags(paramObject);
    }
    
    public final int getSpanStart(Object paramObject)
    {
      return this.c.getSpanStart(paramObject);
    }
    
    public final <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
    {
      return this.c.getSpans(paramInt1, paramInt2, paramClass);
    }
    
    public final int length()
    {
      return this.c.length();
    }
    
    public final int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
    {
      return this.c.nextSpanTransition(paramInt1, paramInt2, paramClass);
    }
    
    public final void removeSpan(Object paramObject)
    {
      this.c.removeSpan(paramObject);
    }
    
    public final void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
    {
      this.c.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
    }
    
    public final CharSequence subSequence(int paramInt1, int paramInt2)
    {
      return this.c.subSequence(paramInt1, paramInt2);
    }
  }
  
  static final class e
    implements TextWatcher
  {
    private final CodeInputField.a a;
    private final CodeInputField b;
    private final CodeInputField.b c;
    private String d = "";
    private boolean e;
    
    private e(CodeInputField.a parama, CodeInputField paramCodeInputField, CodeInputField.b paramb)
    {
      this.a = parama;
      this.b = paramCodeInputField;
      this.c = paramb;
    }
    
    private void a(Editable paramEditable, String paramString)
    {
      int j = 0;
      paramString = this.c.a(paramString);
      if (paramString.length() <= 0) {
        return;
      }
      InputFilter[] arrayOfInputFilter = paramEditable.getFilters();
      this.b.removeTextChangedListener(this);
      paramEditable.setFilters(new InputFilter[0]);
      Object[] arrayOfObject = paramEditable.getSpans(0, paramEditable.length(), CharacterStyle.class);
      int k = arrayOfObject.length;
      int i = 0;
      while (i < k)
      {
        paramEditable.removeSpan(arrayOfObject[i]);
        i += 1;
      }
      paramEditable.replace(0, paramEditable.length(), paramString.toString());
      arrayOfObject = paramString.getSpans(0, paramString.length(), CharacterStyle.class);
      k = arrayOfObject.length;
      i = j;
      while (i < k)
      {
        Object localObject = arrayOfObject[i];
        paramEditable.setSpan(localObject, paramString.getSpanStart(localObject), paramString.getSpanEnd(localObject), 18);
        i += 1;
      }
      paramEditable.setFilters(arrayOfInputFilter);
      this.b.addTextChangedListener(this);
    }
    
    public final void afterTextChanged(Editable paramEditable)
    {
      int j = this.b.getSelectionStart();
      String str2 = paramEditable.toString().replace(Character.toString(this.b.a), "");
      int m = CodeInputField.a(this.b) / 2;
      int i;
      if ((str2.length() > 0) && (this.d.startsWith(str2.substring(0, 1))) && (this.d.indexOf(' ') >= 0) && (str2.indexOf(' ') < 0))
      {
        str1 = str2.substring(0, str2.length() - 1);
        i = j - 1;
      }
      for (;;)
      {
        str2 = str1.replace(Character.toString(' '), "");
        int k = str2.length();
        j = k;
        str1 = str2;
        if (k > m) {
          j = k + 1;
        }
        for (str1 = str2; str1.length() < m; str1 = str1 + this.b.a) {}
        str1 = str2;
        i = j;
        if (str2.length() > j)
        {
          str1 = str2;
          i = j;
          if (str2.indexOf(' ') == j)
          {
            str1 = str2;
            i = j;
            if (j == m + 1)
            {
              i = j + 1;
              str1 = str2;
            }
          }
        }
      }
      for (String str1 = str1.substring(0, m) + ' ' + str1.substring(m, Math.min(CodeInputField.a(this.b), str1.length())); str1.length() < CodeInputField.a(this.b) + 1; str1 = str1 + this.b.a) {}
      a(paramEditable, str1);
      j = Math.min(j, str1.length());
      this.b.setSelection(Math.min(i, j));
      if (!this.e)
      {
        paramEditable = CodeInputField.a(str1);
        if (paramEditable.length() == CodeInputField.a(this.b)) {
          this.a.a(paramEditable);
        }
      }
      else
      {
        return;
      }
      this.a.b(paramEditable);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if (paramCharSequence != null) {
        this.d = paramCharSequence.toString();
      }
    }
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  public static final class f
    extends ReplacementSpan
  {
    private int a;
    
    public f(int paramInt)
    {
      this.a = paramInt;
    }
    
    public final void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
    {
      paramPaint.setColor(this.a);
      paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, (int)(getSize(paramPaint, paramCharSequence, paramInt1, paramInt2, null) / 2 + paramFloat - paramPaint.measureText(paramCharSequence, paramInt1, paramInt2) / 2.0F), paramInt4, paramPaint);
    }
    
    public final int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
    {
      return Math.round(paramPaint.measureText(paramCharSequence, paramCharSequence.length(), paramCharSequence.length()) + 2.0F * aoa.a().a * 10.0F);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/registration/CodeInputField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */