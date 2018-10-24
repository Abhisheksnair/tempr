package com.whatsapp.twofactor;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.m;
import android.support.v7.app.b.a;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.whatsapp.registration.bc;
import com.whatsapp.util.at;

public class e
  extends Fragment
{
  TwoFactorAuthActivity a;
  private Button b;
  private TextView c;
  private EditText d;
  private TextWatcher e = new TextWatcher()
  {
    public final void afterTextChanged(Editable paramAnonymousEditable)
    {
      paramAnonymousEditable = paramAnonymousEditable.toString().trim();
      switch (e.a(e.this))
      {
      }
      for (;;)
      {
        e.d(e.this);
        return;
        e.b(e.this).r = paramAnonymousEditable;
        continue;
        e.c(e.this).setText("");
        e.b(e.this).s = paramAnonymousEditable;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    
    public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
  };
  private int f;
  
  private void a()
  {
    Button localButton;
    if (this.b != null)
    {
      localButton = this.b;
      String str = this.d.getText().toString().trim();
      int i = str.indexOf('@');
      if ((i <= 0) || (i >= str.length() - 1) || (i != str.lastIndexOf('@'))) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
  
  public static e d(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt);
    e locale = new e();
    locale.f(localBundle);
    return locale;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2130903230, paramViewGroup, false);
  }
  
  public final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.f = i().getInt("type", 1);
  }
  
  public final void a(View paramView, Bundle paramBundle)
  {
    int j = 1;
    this.a = ((TwoFactorAuthActivity)l());
    this.b = ((Button)paramView.findViewById(2131755379));
    this.b.setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        e.e(e.this);
      }
    });
    this.d = ((EditText)paramView.findViewById(2131755778));
    this.c = ((TextView)paramView.findViewById(2131755226));
    paramBundle = (TextView)paramView.findViewById(2131755322);
    int i;
    switch (this.f)
    {
    default: 
      i = 0;
      paramBundle = this.a;
      if ((this.a.b(this)) && (this.a.n.length != 1)) {
        i = j;
      }
      break;
    }
    for (;;)
    {
      paramBundle.a(paramView, i);
      return;
      if (this.a.n[0] != 2)
      {
        i = 1;
        label159:
        if (i == 0) {
          break label208;
        }
        paramBundle.setText(bc.a(a(2131298021), "skip", f.a(this)));
        paramBundle.setMovementMethod(LinkMovementMethod.getInstance());
      }
      for (;;)
      {
        this.b.setText(2131297280);
        i = 0;
        break;
        i = 0;
        break label159;
        label208:
        paramBundle.setText(2131298020);
      }
      paramBundle.setText(2131298018);
      this.b.setText(2131298039);
      i = 1;
      break;
    }
  }
  
  public final void g()
  {
    this.c = null;
    this.d = null;
    this.b = null;
    this.a = null;
    super.g();
  }
  
  public final void y()
  {
    super.y();
    this.d.removeTextChangedListener(this.e);
    EditText localEditText = this.d;
    if (this.f == 1) {}
    for (String str = this.a.r;; str = this.a.s)
    {
      localEditText.setText(str);
      this.d.addTextChangedListener(this.e);
      a();
      this.d.requestFocus();
      return;
    }
  }
  
  public static class a
    extends m
  {
    public static a a(e parame)
    {
      a locala = new a();
      locala.a(parame);
      return locala;
    }
    
    public final Dialog c(Bundle paramBundle)
    {
      return new b.a(k()).b(a(2131298023)).a(2131297331, g.a(this)).b(2131296398, null).a();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/twofactor/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */