package com.whatsapp;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.whatsapp.emoji.c;
import com.whatsapp.util.be;
import java.text.NumberFormat;

public class tg
  implements TextWatcher
{
  private final EditText a;
  private final TextView b;
  private final int c;
  private final int d;
  private final boolean e;
  private int f;
  private final pv g;
  private final and h;
  
  public tg(pv parampv, and paramand, EditText paramEditText, TextView paramTextView, int paramInt)
  {
    this(parampv, paramand, paramEditText, paramTextView, paramInt, 0, false);
  }
  
  public tg(pv parampv, and paramand, EditText paramEditText, TextView paramTextView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.g = parampv;
    this.h = paramand;
    this.a = paramEditText;
    this.b = paramTextView;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramBoolean;
    if ((paramTextView != null) && (paramInt1 != 0) && (paramInt2 == 0)) {
      paramTextView.setText(NumberFormat.getInstance().format(paramInt1));
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int j;
    if (this.e)
    {
      be.a(this.a.getContext(), this.h, paramEditable, this.a.getPaint());
      if (this.c > 0)
      {
        paramEditable = paramEditable.toString();
        int i = c.c(paramEditable);
        if (this.b != null)
        {
          j = this.c - i;
          if (this.d <= 0) {
            break label172;
          }
          if (j < this.d) {
            break label191;
          }
          this.b.setVisibility(8);
        }
        label84:
        if ((i < this.c) || (this.f != 0)) {
          break label217;
        }
        this.f = this.a.getInputType();
        if (this.f != 0)
        {
          this.a.setInputType(this.f | 0x80000);
          this.a.setText(paramEditable);
          this.a.setSelection(paramEditable.length());
        }
      }
    }
    label172:
    label191:
    label217:
    while (this.f == 0)
    {
      return;
      c.a(paramEditable, this.a.getContext(), this.a.getPaint());
      break;
      if (j == this.c)
      {
        this.b.setVisibility(4);
        break label84;
      }
      this.b.setVisibility(0);
      this.b.setText(NumberFormat.getInstance().format(j));
      break label84;
    }
    this.a.setInputType(this.f);
    this.f = 0;
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    al.a(this.g, this.a, paramCharSequence);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/tg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */