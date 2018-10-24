package com.whatsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.GetChars;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.text.style.MetricAffectingSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.whatsapp.data.cs;
import com.whatsapp.emoji.c;
import com.whatsapp.util.Log;
import com.whatsapp.util.be;
import com.whatsapp.util.bg;
import java.util.List;

public class TextEmojiLabel
  extends TextView
{
  private static boolean e = false;
  private static final Spannable.Factory h;
  private CharSequence a;
  private TextView.BufferType b;
  private int c;
  private th d;
  private final pv f;
  private final and g;
  
  static
  {
    try
    {
      Layout.class.getDeclaredMethod("processToSupportEmoji", new Class[] { CharSequence.class, Integer.TYPE, Integer.TYPE });
      e = true;
      h = new Spannable.Factory()
      {
        public final Spannable newSpannable(CharSequence paramAnonymousCharSequence)
        {
          return new TextEmojiLabel.a(new SpannableString(paramAnonymousCharSequence));
        }
      };
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    catch (SecurityException localSecurityException)
    {
      for (;;) {}
    }
  }
  
  public TextEmojiLabel(Context paramContext)
  {
    super(paramContext);
    if (isInEditMode())
    {
      paramContext = null;
      this.f = paramContext;
      if (!isInEditMode()) {
        break label64;
      }
    }
    label64:
    for (paramContext = (Context)localObject;; paramContext = and.a())
    {
      this.g = paramContext;
      if ((Build.VERSION.SDK_INT >= 11) || (e)) {
        setSpannableFactory(h);
      }
      return;
      paramContext = pv.a();
      break;
    }
  }
  
  public TextEmojiLabel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode())
    {
      paramContext = null;
      this.f = paramContext;
      if (!isInEditMode()) {
        break label65;
      }
    }
    label65:
    for (paramContext = (Context)localObject;; paramContext = and.a())
    {
      this.g = paramContext;
      if ((Build.VERSION.SDK_INT >= 11) || (e)) {
        setSpannableFactory(h);
      }
      return;
      paramContext = pv.a();
      break;
    }
  }
  
  public TextEmojiLabel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode())
    {
      paramContext = null;
      this.f = paramContext;
      if (!isInEditMode()) {
        break label68;
      }
    }
    label68:
    for (paramContext = (Context)localObject;; paramContext = and.a())
    {
      this.g = paramContext;
      if ((Build.VERSION.SDK_INT >= 11) || (e)) {
        setSpannableFactory(h);
      }
      return;
      paramContext = pv.a();
      break;
    }
  }
  
  @SuppressLint({"WrongCall"})
  private void a(int paramInt1, int paramInt2)
  {
    SpannableStringBuilder localSpannableStringBuilder1 = new SpannableStringBuilder(this.a);
    for (int i = localSpannableStringBuilder1.nextSpanTransition(0, localSpannableStringBuilder1.length(), MetricAffectingSpan.class); (i >= 0) && (i < localSpannableStringBuilder1.length()); i = localSpannableStringBuilder1.nextSpanTransition(i + 1, localSpannableStringBuilder1.length(), MetricAffectingSpan.class)) {
      localSpannableStringBuilder1.insert(i, " ");
    }
    try
    {
      this.a = localSpannableStringBuilder1;
      super.setText(localSpannableStringBuilder1);
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      Log.e("textemojilabel/measure1 " + localArrayIndexOutOfBoundsException.toString());
      SpannableStringBuilder localSpannableStringBuilder2 = new SpannableStringBuilder(this.a);
      for (i = TextUtils.indexOf(localSpannableStringBuilder2, '\n', 0); i >= 0; i = TextUtils.indexOf(localSpannableStringBuilder2, '\n', i + 1)) {
        localSpannableStringBuilder2 = localSpannableStringBuilder2.replace(i, i + 1, " ");
      }
      this.a = localSpannableStringBuilder2;
      super.setText(localSpannableStringBuilder2);
      super.onMeasure(paramInt1, paramInt2);
    }
  }
  
  private static String c(CharSequence paramCharSequence)
  {
    String str = "";
    int i = 0;
    while (i < paramCharSequence.length())
    {
      int j = paramCharSequence.charAt(i);
      str = str + "0x" + Integer.toHexString(j) + ", ";
      i += 1;
    }
    return str;
  }
  
  public final void a(cs paramcs, List<String> paramList)
  {
    a(paramcs.a(getContext()), paramList);
    setVerified(paramcs.f());
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    setText(c.a(paramCharSequence, getContext(), getPaint()));
  }
  
  public final void a(CharSequence paramCharSequence, List<String> paramList, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      paramCharSequence = be.a(getContext(), this.g, paramCharSequence);
      localObject = paramCharSequence;
      if (paramInt > 0)
      {
        localObject = paramCharSequence;
        if (paramCharSequence.length() > paramInt)
        {
          paramInt += Character.charCount(Character.codePointAt(paramCharSequence, paramInt - 1)) - 1;
          if (!(paramCharSequence instanceof Editable)) {
            break label114;
          }
        }
      }
    }
    label114:
    for (Object localObject = ((Editable)paramCharSequence).delete(paramInt, paramCharSequence.length());; localObject = TextUtils.substring(paramCharSequence, 0, paramInt))
    {
      paramCharSequence = c.a((CharSequence)localObject, getContext(), getPaint());
      setText(bg.a(getContext(), paramCharSequence, paramList));
      return;
      break;
    }
  }
  
  public final void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    int i = 2131362095;
    if (TextUtils.isEmpty(paramCharSequence))
    {
      setVisibility(8);
      return;
    }
    int j = c.b(paramCharSequence);
    float f1;
    Object localObject;
    if ((j > 0) && (j <= 3))
    {
      f1 = getContext().getResources().getDimensionPixelSize(2131362095);
      float f2 = Math.max(f1, 1.5F * Math.min(f1, getContext().getResources().getDisplayMetrics().density * f1 / getContext().getResources().getDisplayMetrics().scaledDensity));
      f1 += (4 - j) * (f2 - f1) / 3.0F;
      localObject = paramCharSequence;
      if (paramCharSequence.length() >= 96) {
        break label292;
      }
      setGravity(17);
    }
    for (;;)
    {
      setTextSize(0, f1);
      b((CharSequence)localObject);
      setVisibility(0);
      return;
      localObject = getContext().getResources();
      if (paramCharSequence.length() < 96) {}
      for (;;)
      {
        f1 = ((Resources)localObject).getDimensionPixelSize(i);
        if ((paramCharSequence.length() > 144) && (!paramBoolean)) {
          break label206;
        }
        localObject = paramCharSequence;
        break;
        i = 2131362096;
      }
      label206:
      localObject = new SpannableStringBuilder(paramCharSequence, 0, Character.charCount(Character.codePointAt(paramCharSequence, 127)) + 128 - 1);
      ((SpannableStringBuilder)localObject).append("... ");
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(getContext().getString(2131297501));
      localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, localSpannableStringBuilder.length(), 18);
      ((SpannableStringBuilder)localObject).append(localSpannableStringBuilder);
      break;
      label292:
      if (al.a(this.f)) {
        setGravity(8388611);
      } else {
        al.b(this.f, this);
      }
    }
  }
  
  public final void a(String paramString, List<String> paramList)
  {
    a(paramString, paramList, false, 0);
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    a(paramCharSequence, null, true, 0);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    try
    {
      super.onDraw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas)
    {
      Log.e(paramCanvas);
      Log.e("measuredwidth: " + getMeasuredWidth());
      CharSequence localCharSequence = getText();
      Log.e("text: " + c(localCharSequence));
      Layout localLayout = getLayout();
      Log.e("line_count: " + localLayout.getLineCount());
      int i = 0;
      if (i < localLayout.getLineCount())
      {
        int k = localLayout.getLineStart(i);
        int j;
        if (i == localLayout.getLineCount() - 1)
        {
          j = localCharSequence.length();
          label132:
          if (k > j) {
            break label220;
          }
          Log.e("line " + i + " (" + k + "-" + j + "): " + c(localCharSequence.subSequence(k, j)));
        }
        for (;;)
        {
          i += 1;
          break;
          j = localLayout.getLineStart(i + 1);
          break label132;
          label220:
          Log.e("line " + i + " (" + k + "-" + j + ")");
        }
      }
      throw new RuntimeException(paramCanvas);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if ((Build.VERSION.SDK_INT == 16) || (Build.VERSION.SDK_INT == 17)) {}
    for (;;)
    {
      try
      {
        super.onMeasure(paramInt1, paramInt2);
        paramInt1 = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
        if ((this.c != paramInt1) && ((this.a instanceof Spanned)) && (getEllipsize() != null) && ((getTransformationMethod() instanceof SingleLineTransformationMethod)))
        {
          this.c = paramInt1;
          if (getTransformationMethod() == null) {
            break label215;
          }
          CharSequence localCharSequence1 = getTransformationMethod().getTransformation(this.a, this);
          CharSequence localCharSequence3 = TextUtils.ellipsize(localCharSequence1, getPaint(), paramInt1, getEllipsize());
          if ((localCharSequence3 != null) && (!localCharSequence3.equals(localCharSequence1))) {
            super.setText(localCharSequence3, this.b);
          }
        }
        return;
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        Log.e("textemojilabel/measure " + localArrayIndexOutOfBoundsException.toString());
        a(paramInt1, paramInt2);
        continue;
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        Log.e("textemojilabel/measure " + localIndexOutOfBoundsException.toString());
        a(paramInt1, paramInt2);
        continue;
      }
      super.onMeasure(paramInt1, paramInt2);
      continue;
      label215:
      CharSequence localCharSequence2 = this.a;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (this.d != null)
    {
      CharSequence localCharSequence = getText();
      if (((localCharSequence instanceof Spannable)) && (getLayout() != null)) {
        return this.d.onTouchEvent(this, (Spannable)localCharSequence, paramMotionEvent) | bool;
      }
    }
    return bool;
  }
  
  public void setContact(cs paramcs)
  {
    a(paramcs.a(getContext()));
    setVerified(paramcs.f());
  }
  
  public void setLinkHandler(th paramth)
  {
    this.d = paramth;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    Object localObject2 = paramCharSequence;
    if (e)
    {
      localObject2 = paramCharSequence;
      if (paramCharSequence != null)
      {
        Object localObject1 = null;
        int i = 0;
        while (i < paramCharSequence.length())
        {
          int j = paramCharSequence.charAt(i);
          localObject2 = localObject1;
          if (j >= 55296)
          {
            localObject2 = localObject1;
            if (j <= 57343)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                localObject2 = new SpannableStringBuilder(paramCharSequence);
              }
              ((SpannableStringBuilder)localObject2).replace(i, i + 1, "□");
            }
          }
          i += 1;
          localObject1 = localObject2;
        }
        localObject2 = paramCharSequence;
        if (localObject1 != null) {
          localObject2 = localObject1;
        }
      }
    }
    this.a = ((CharSequence)localObject2);
    this.b = paramBufferType;
    this.c = 0;
    if (((Build.VERSION.SDK_INT >= 11) || (e)) && ((localObject2 instanceof Spanned)))
    {
      super.setText((CharSequence)localObject2, TextView.BufferType.SPANNABLE);
      return;
    }
    super.setText((CharSequence)localObject2, paramBufferType);
  }
  
  public void setVerified(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      al.a(this.f, this, 2130840264);
      setCompoundDrawablePadding(getResources().getDimensionPixelSize(2131362112));
      return;
    }
    setCompoundDrawables(null, null, null, null);
  }
  
  public static final class a
    implements GetChars, Spannable, CharSequence
  {
    private SpannableString a;
    
    public a(CharSequence paramCharSequence)
    {
      this.a = new SpannableString(paramCharSequence);
    }
    
    public final char charAt(int paramInt)
    {
      if (paramInt < 0) {}
      while (paramInt >= length()) {
        return ' ';
      }
      return this.a.charAt(paramInt);
    }
    
    public final void getChars(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
    {
      if (paramInt2 < paramInt1) {}
      int i;
      do
      {
        return;
        i = length();
      } while ((paramInt1 > i) || (paramInt2 > i) || (paramInt1 < 0) || (paramInt2 < 0));
      this.a.getChars(paramInt1, paramInt2, paramArrayOfChar, paramInt3);
    }
    
    public final int getSpanEnd(Object paramObject)
    {
      return this.a.getSpanEnd(paramObject);
    }
    
    public final int getSpanFlags(Object paramObject)
    {
      return this.a.getSpanFlags(paramObject);
    }
    
    public final int getSpanStart(Object paramObject)
    {
      return this.a.getSpanStart(paramObject);
    }
    
    public final <T> T[] getSpans(int paramInt1, int paramInt2, Class<T> paramClass)
    {
      return this.a.getSpans(paramInt1, paramInt2, paramClass);
    }
    
    public final int length()
    {
      return this.a.length();
    }
    
    public final int nextSpanTransition(int paramInt1, int paramInt2, Class paramClass)
    {
      return this.a.nextSpanTransition(paramInt1, paramInt2, paramClass);
    }
    
    public final void removeSpan(Object paramObject)
    {
      this.a.removeSpan(paramObject);
    }
    
    public final void setSpan(Object paramObject, int paramInt1, int paramInt2, int paramInt3)
    {
      this.a.setSpan(paramObject, paramInt1, paramInt2, paramInt3);
    }
    
    public final CharSequence subSequence(int paramInt1, int paramInt2)
    {
      return this.a.subSequence(paramInt1, paramInt2);
    }
    
    public final String toString()
    {
      return this.a.toString();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/TextEmojiLabel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */