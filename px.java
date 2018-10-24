package com.whatsapp;

import android.text.InputFilter;
import android.text.Spanned;
import com.whatsapp.emoji.c;

public final class px
  implements InputFilter
{
  private final int a;
  
  public px(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    int i = c.a(paramSpanned, 0, paramSpanned.length());
    paramInt4 = c.a(paramSpanned, paramInt3, paramInt4);
    paramInt3 = c.a(paramCharSequence, paramInt1, paramInt2);
    paramInt4 = this.a - i + paramInt4;
    if (paramInt4 <= 0) {
      return "";
    }
    if (paramInt4 >= paramInt3) {
      return null;
    }
    return c.a(paramCharSequence, paramInt1, paramInt2, paramInt4);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/px.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */