package com.whatsapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.whatsapp.emoji.c;
import com.whatsapp.emoji.h;
import com.whatsapp.emoji.search.i;
import com.whatsapp.emoji.search.i.c;

public final class oe
  extends pf
{
  final a a;
  final int b;
  String c;
  boolean d = true;
  EditText e;
  os f;
  i g;
  final Activity h;
  final EmojiPicker.c i = new EmojiPicker.c()
  {
    public final void a()
    {
      oe.a(oe.this).dispatchKeyEvent(new KeyEvent(0, 67));
    }
    
    public final void a(int paramAnonymousInt)
    {
      int j = oe.a(oe.this).getSelectionStart();
      int k = oe.a(oe.this).getSelectionEnd();
      int i;
      if (j > k) {
        i = k;
      }
      for (;;)
      {
        StringBuilder localStringBuilder = new StringBuilder(oe.a(oe.this).getText().toString());
        localStringBuilder.replace(i, j, c.b(paramAnonymousInt));
        if ((oe.b(oe.this) > 0) && (c.c(localStringBuilder) > oe.b(oe.this))) {}
        do
        {
          return;
          oe.a(oe.this).setText(localStringBuilder);
          paramAnonymousInt = c.a(paramAnonymousInt);
        } while (i > oe.a(oe.this).length() - paramAnonymousInt);
        oe.a(oe.this).setSelection(paramAnonymousInt + i);
        return;
        i = j;
        j = k;
      }
    }
  };
  private final int k;
  private final int l;
  private final int m;
  private final int n;
  private final String o;
  private final Context p;
  private final h q = h.a();
  private final and r = and.a();
  private final atv s = atv.a();
  
  public oe(Activity paramActivity, int paramInt1, String paramString, a parama, int paramInt2, int paramInt3, int paramInt4)
  {
    this(paramActivity, paramInt1, paramString, parama, paramInt2, paramInt3, paramInt4, 16385);
  }
  
  public oe(Activity paramActivity, int paramInt1, String paramString, a parama, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramActivity);
    this.n = paramInt5;
    this.p = paramActivity.getBaseContext();
    this.h = paramActivity;
    this.a = parama;
    this.k = paramInt1;
    this.l = paramInt2;
    this.m = paramInt3;
    this.b = paramInt4;
    this.o = paramString;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ((TextView)findViewById(2131755723)).setText(this.k);
    setTitle(this.k);
    ((Button)findViewById(2131755679)).setOnClickListener(of.a(this));
    ((Button)findViewById(2131755642)).setOnClickListener(og.a(this));
    paramBundle = (TextView)findViewById(2131755726);
    this.e = ((EditText)findViewById(2131755725));
    al.a(this.j, this.e);
    if (this.l > 0)
    {
      paramBundle.setVisibility(0);
      this.e.setFilters(new InputFilter[] { new px(this.l) });
    }
    this.e.addTextChangedListener(new tg(this.j, this.r, this.e, paramBundle, this.l));
    this.e.setInputType(this.n);
    al.b(this.j, this.e);
    paramBundle = getWindow().getAttributes();
    paramBundle.width = -1;
    paramBundle.gravity = 48;
    getWindow().setAttributes(paramBundle);
    this.f = new os(getWindow().getDecorView(), this.h, this.j, this.q, this.s);
    this.f.setOnDismissListener(oh.a(this));
    this.g = new i(this.f, this.h, getWindow().getDecorView(), true);
    this.g.a(new oi(this));
    this.g.e = new i.c()
    {
      public final void m() {}
      
      public final void n()
      {
        ((InputMethodManager)oe.c(oe.this).getSystemService("input_method")).hideSoftInputFromWindow(oe.a(oe.this).getWindowToken(), 0);
      }
    };
    this.f.a(this.i);
    this.f.t = true;
    paramBundle = (ImageButton)findViewById(2131755724);
    paramBundle.setOnClickListener(oj.a(this, paramBundle));
    setOnCancelListener(ok.a(this));
    getWindow().setSoftInputMode(5);
  }
  
  public final void onStart()
  {
    super.onStart();
    if (this.c != null) {}
    for (String str = this.c;; str = this.o)
    {
      if (this.m != 0) {
        this.e.setHint(this.m);
      }
      this.e.setText(c.a(str, this.p));
      if (str != null) {
        this.e.selectAll();
      }
      return;
    }
  }
  
  public final void onStop()
  {
    super.onStop();
    if (this.d) {
      this.c = this.e.getText().toString();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/oe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */