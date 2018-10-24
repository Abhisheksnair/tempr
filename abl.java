package com.whatsapp;

import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import com.google.b.a.a;
import com.google.b.a.f;

public class abl
  implements TextWatcher
{
  private int a;
  private boolean b = false;
  private boolean c;
  private a d;
  
  public abl(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException();
    }
    f.a();
    this.d = f.f(paramString);
  }
  
  private String a(char paramChar, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      locala = this.d;
      locala.a = locala.a(paramChar, true);
      return locala.a;
    }
    a locala = this.d;
    locala.a = locala.a(paramChar, false);
    return locala.a;
  }
  
  private void a()
  {
    this.c = true;
    this.d.a();
  }
  
  private static boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    while (i < paramInt1 + paramInt2)
    {
      if (!PhoneNumberUtils.isNonSeparator(paramCharSequence.charAt(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    boolean bool1 = true;
    int j = 0;
    for (;;)
    {
      int k;
      int m;
      char c2;
      boolean bool2;
      a locala;
      try
      {
        if (this.c)
        {
          if (paramEditable.length() != 0)
          {
            this.c = bool1;
            return;
          }
          bool1 = false;
          continue;
        }
        if (this.b) {
          continue;
        }
        k = Selection.getSelectionEnd(paramEditable);
        String str = null;
        this.d.a();
        m = paramEditable.length();
        i = 0;
        bool1 = false;
        c1 = '\000';
        if (i < m)
        {
          c2 = paramEditable.charAt(i);
          if (!PhoneNumberUtils.isNonSeparator(c2)) {
            break label315;
          }
          bool2 = bool1;
          if (c1 == 0) {
            break label318;
          }
          str = a(c1, bool1);
          bool2 = false;
          break label318;
        }
        if (c1 == 0) {
          break label312;
        }
        str = a(c1, bool1);
        if (str == null) {
          continue;
        }
        locala = this.d;
        if (!locala.c)
        {
          i = locala.d;
          this.b = true;
          paramEditable.replace(0, paramEditable.length(), str, 0, str.length());
          if (str.equals(paramEditable.toString())) {
            Selection.setSelection(paramEditable, i);
          }
          this.b = false;
          continue;
        }
        k = 0;
      }
      finally {}
      int i = j;
      for (j = k; (j < locala.e) && (i < locala.a.length()); j = k)
      {
        m = locala.b.charAt(j);
        int n = locala.a.charAt(i);
        k = j;
        if (m == n) {
          k = j + 1;
        }
        i += 1;
      }
      continue;
      label312:
      continue;
      label315:
      break label324;
      label318:
      char c1 = c2;
      bool1 = bool2;
      label324:
      if (i == k - 1) {
        bool1 = true;
      }
      i += 1;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.b) || (this.c)) {
      return;
    }
    if ((paramInt2 == 0) && (paramCharSequence.length() == paramInt1))
    {
      this.a = 1;
      return;
    }
    if ((paramInt3 == 0) && (paramInt1 + paramInt2 == paramCharSequence.length()) && (paramInt2 > 0))
    {
      this.a = 0;
      return;
    }
    if ((paramInt2 > 0) && (!a(paramCharSequence, paramInt1, paramInt2)))
    {
      this.a = 2;
      return;
    }
    this.a = 3;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.b) || (this.c)) {}
    do
    {
      return;
      if ((this.a == 3) && (paramInt3 > 0) && (!a(paramCharSequence, paramInt1, paramInt3))) {
        this.a = 2;
      }
      if ((this.a == 1) && (paramInt3 > 0) && (a(paramCharSequence, paramInt1, paramInt3)))
      {
        a();
        return;
      }
    } while (this.a != 3);
    a();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/abl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */