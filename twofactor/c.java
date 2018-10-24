package com.whatsapp.twofactor;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.whatsapp.registration.CodeInputField;
import com.whatsapp.registration.CodeInputField.a;
import com.whatsapp.util.at;

public final class c
  extends Fragment
{
  CodeInputField a;
  private int b;
  private Button c;
  private TextView d;
  private TwoFactorAuthActivity e;
  private final q f = q.a();
  
  private void a()
  {
    boolean bool = true;
    if (this.c != null)
    {
      if (this.b != 1) {
        break label46;
      }
      if (this.a.getCode().length() != 6) {
        break label41;
      }
    }
    for (;;)
    {
      this.c.setEnabled(bool);
      return;
      label41:
      bool = false;
      continue;
      label46:
      bool = b();
    }
  }
  
  private boolean a(CharSequence paramCharSequence)
  {
    this.d.setText("");
    if (paramCharSequence.length() != 6) {
      return false;
    }
    switch (this.b)
    {
    }
    for (;;)
    {
      this.a.requestFocus();
      return false;
      return true;
      if (b()) {
        return true;
      }
      this.d.setText(a(2131298009));
      continue;
      paramCharSequence = this.f.b();
      if ((paramCharSequence != null) && (paramCharSequence.contentEquals(this.a.getCode()))) {}
      for (int i = 1; i != 0; i = 0) {
        return true;
      }
      this.d.setText(a(2131298013));
    }
  }
  
  private boolean b()
  {
    String str = this.e.p;
    return (str != null) && (str.contentEquals(this.a.getCode()));
  }
  
  public static c d(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("type", paramInt);
    c localc = new c();
    localc.f(localBundle);
    return localc;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2130903228, paramViewGroup, false);
  }
  
  public final void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.b = i().getInt("type", 1);
  }
  
  public final void a(View paramView, Bundle paramBundle)
  {
    this.e = ((TwoFactorAuthActivity)l());
    this.c = ((Button)paramView.findViewById(2131755379));
    this.c.setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        c.a(c.this);
      }
    });
    this.d = ((TextView)paramView.findViewById(2131755226));
    this.a = ((CodeInputField)paramView.findViewById(2131755323));
    paramBundle = new d(this);
    this.a.a(new CodeInputField.a()
    {
      public final void a(String paramAnonymousString)
      {
        if (!c.this.p()) {}
        for (;;)
        {
          return;
          c.b(c.this);
          if (c.c(c.this) == 1) {
            c.d(c.this).p = paramAnonymousString;
          }
          while ((c.a(c.this, paramAnonymousString)) && ((c.c(c.this) != 2) || (!c.d(c.this).b(c.this))))
          {
            c.a(c.this);
            return;
            if (c.c(c.this) == 2) {
              c.d(c.this).q = paramAnonymousString;
            }
          }
        }
      }
      
      public final void b(String paramAnonymousString)
      {
        if (!c.this.p()) {
          return;
        }
        if (c.c(c.this) == 1) {
          c.d(c.this).p = paramAnonymousString;
        }
        for (;;)
        {
          c.e(c.this).setText("");
          c.b(c.this);
          return;
          if (c.c(c.this) == 2) {
            c.d(c.this).q = paramAnonymousString;
          }
        }
      }
    }, '*', '*', paramBundle);
    int j;
    int i;
    switch (this.b)
    {
    default: 
      j = 2131298042;
      i = 0;
      ((TextView)paramView.findViewById(2131755776)).setText(j);
      paramBundle = this.e;
      if (this.e.n.length != 1) {
        break;
      }
    }
    for (;;)
    {
      paramBundle.a(paramView, i);
      return;
      j = 2131298008;
      i = 0;
      break;
      j = 2131298014;
      i = 1;
      break;
      i = 0;
    }
  }
  
  public final void g()
  {
    super.g();
    this.e = null;
    this.c = null;
    this.a = null;
    this.d = null;
  }
  
  public final void y()
  {
    super.y();
    Object localObject;
    if ((this.b == 2) && (this.e.b(this)))
    {
      i = 1;
      localObject = this.c;
      if (i == 0) {
        break label100;
      }
    }
    label100:
    for (int i = 2131298039;; i = 2131297280)
    {
      ((Button)localObject).setText(i);
      if (this.b == 2)
      {
        localObject = this.e.q;
        if (localObject != null)
        {
          this.a.setCode((String)localObject);
          a(this.a.getCode());
        }
      }
      a();
      this.a.requestFocus();
      return;
      i = 0;
      break;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/twofactor/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */