package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.b;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.UnderlineSpan;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.TextView;
import com.whatsapp.data.ad;
import com.whatsapp.emoji.c;
import com.whatsapp.emoji.h;
import com.whatsapp.emoji.search.EmojiSearchContainer;
import com.whatsapp.emoji.search.i.c;
import com.whatsapp.gif_search.GifSearchContainer;
import com.whatsapp.gif_search.a;
import com.whatsapp.gif_search.f;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;
import com.whatsapp.util.az;
import com.whatsapp.util.be;
import java.util.Random;

public class TextStatusComposerActivity
  extends nh
{
  static final Random s = new Random();
  static final int[] y = { -5886863, -7296959, -4087745, -8838856, -5339276, -1002704, -4803801, -3760180, -7640688, 35468, -11222427, -33941, -14236452, -11023873, -9148566, -8482653, -11102465, -9558658, -8729691, -14404032, -8219446 };
  private f A;
  private View B;
  private final aoj C = aoj.a();
  private final h D = h.a();
  private final aoa E = aoa.a();
  private final int[] F = new int[2];
  TextView n;
  MentionableEntry o;
  a p;
  ConversationContentLayout q;
  ImageButton r;
  int t;
  int u = -1;
  int v = 0;
  final EmojiPicker.c w = new EmojiPicker.c()
  {
    public final void a()
    {
      TextStatusComposerActivity.a(TextStatusComposerActivity.this).dispatchKeyEvent(new KeyEvent(0, 67));
    }
    
    public final void a(int paramAnonymousInt)
    {
      int i = TextStatusComposerActivity.a(TextStatusComposerActivity.this).getSelectionStart();
      int j = TextStatusComposerActivity.a(TextStatusComposerActivity.this).getSelectionEnd();
      int k;
      if (i > j)
      {
        k = j;
        j = i;
      }
      for (;;)
      {
        StringBuilder localStringBuilder = new StringBuilder(TextStatusComposerActivity.a(TextStatusComposerActivity.this).getText().toString());
        localStringBuilder.replace(k, j, c.b(paramAnonymousInt));
        TextStatusComposerActivity.a(TextStatusComposerActivity.this).setText(localStringBuilder);
        if (k <= TextStatusComposerActivity.a(TextStatusComposerActivity.this).length() - c.a(paramAnonymousInt)) {
          TextStatusComposerActivity.a(TextStatusComposerActivity.this).setSelection(k + c.a(paramAnonymousInt));
        }
        return;
        k = i;
      }
    }
  };
  final Runnable x = new Runnable()
  {
    public final void run()
    {
      TextStatusComposerActivity.b(TextStatusComposerActivity.this).a();
      TextStatusComposerActivity.b(TextStatusComposerActivity.this).requestLayout();
    }
  };
  private ImageButton z;
  
  public static int l()
  {
    return y[(Math.abs(s.nextInt()) % y.length)];
  }
  
  private void q()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.o.getWindowToken(), 0);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.A.a())
    {
      this.B.getLocationOnScreen(this.F);
      if ((paramMotionEvent.getRawY() >= this.F[1]) && (paramMotionEvent.getRawY() < this.F[1] + this.B.getHeight()))
      {
        this.A.a(true);
        q();
        return false;
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  final void m()
  {
    if (this.u < 0) {
      this.u = (Math.abs(s.nextInt()) % y.length);
    }
    this.u = ((this.u + 1) % y.length);
    this.t = y[this.u];
    getWindow().setBackgroundDrawable(new ColorDrawable(this.t));
  }
  
  final void n()
  {
    this.z.setEnabled(false);
    Object localObject = this.o.getText().toString().trim();
    if (!be.b(this, this.aE, (CharSequence)localObject))
    {
      pv.a(this, 2131296401, 1);
      return;
    }
    aoj localaoj = this.C;
    localObject = c.b((String)localObject);
    int i = this.t;
    int j = this.v;
    localObject = new j(localaoj.d, "status@broadcast", (String)localObject);
    ((j)localObject).n = localaoj.b.b();
    ((j)localObject).W = null;
    localaoj.d((j)localObject);
    TextData localTextData = new TextData();
    localTextData.backgroundColor = i;
    localTextData.textColor = -1;
    localTextData.fontStyle = j;
    ((j)localObject).N = localTextData;
    localaoj.f.b((j)localObject, -1);
    amt.a().a((j)localObject, 0, 1);
    pv.a(this, 2131297678, 0);
    finish();
  }
  
  final void o()
  {
    this.q.removeCallbacks(this.x);
    int i;
    if (!this.p.isShowing())
    {
      int[] arrayOfInt = new int[2];
      this.B.getLocationOnScreen(arrayOfInt);
      if (getWindow().getDecorView().getHeight() - (arrayOfInt[1] + this.B.getHeight()) > 128.0F * this.E.a)
      {
        i = 1;
        if (i == 0) {
          break label126;
        }
      }
    }
    label126:
    for (this.p.t = true;; this.p.t = false)
    {
      q();
      this.q.setEmojiPopup(this.p);
      this.p.a(this.B, this.r, this.o);
      return;
      i = 0;
      break;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    finish();
  }
  
  public void onBackPressed()
  {
    if (this.A.b()) {
      return;
    }
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("textstatus/create");
    if (Build.VERSION.SDK_INT >= 19) {
      getWindow().setFlags(67108864, 67108864);
    }
    super.onCreate(paramBundle);
    setContentView(2130903383);
    if (paramBundle == null)
    {
      m();
      this.z = ((ImageButton)a.d.a(findViewById(2131755437)));
      this.z.setImageDrawable(new az(b.a(this, 2130840323)));
      this.z.setOnClickListener(anj.a(this));
      paramBundle = findViewById(2131756130);
      paramBundle.setOnClickListener(ank.a(this));
      paramBundle.setOnLongClickListener(anl.a(this));
      this.n = ((TextView)findViewById(2131756129));
      this.n.setOnClickListener(anm.a(this));
      this.o = ((MentionableEntry)a.d.a(findViewById(2131755557)));
      paramBundle = new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          UnderlineSpan[] arrayOfUnderlineSpan = (UnderlineSpan[])paramAnonymousEditable.getSpans(0, paramAnonymousEditable.length(), UnderlineSpan.class);
          int j = arrayOfUnderlineSpan.length;
          int i = 0;
          while (i < j)
          {
            paramAnonymousEditable.removeSpan(arrayOfUnderlineSpan[i]);
            i += 1;
          }
          be.a(TextStatusComposerActivity.this, TextStatusComposerActivity.this.aE, paramAnonymousEditable, TextStatusComposerActivity.a(TextStatusComposerActivity.this).getPaint());
          if (TextUtils.getTrimmedLength(paramAnonymousEditable.toString()) > 0) {}
          for (boolean bool = true;; bool = false)
          {
            TextStatusComposerActivity.c(TextStatusComposerActivity.this).setEnabled(bool);
            return;
          }
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      };
      this.o.addTextChangedListener(paramBundle);
      this.o.setFilters(new InputFilter[] { new InputFilter()
      {
        private static int a(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          if (paramAnonymousCharSequence == null) {
            throw new NullPointerException("str == null");
          }
          int i = paramAnonymousCharSequence.length();
          if ((paramAnonymousInt1 < 0) || (paramAnonymousInt2 > i) || (paramAnonymousInt1 > paramAnonymousInt2)) {
            throw new IndexOutOfBoundsException();
          }
          int j;
          for (i = 0; paramAnonymousInt1 < paramAnonymousInt2; i = j)
          {
            j = i;
            if (paramAnonymousCharSequence.charAt(paramAnonymousInt1) == '\n') {
              j = i + 1;
            }
            paramAnonymousInt1 += 1;
          }
          return i;
        }
        
        public final CharSequence filter(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, Spanned paramAnonymousSpanned, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          int i = c.a(paramAnonymousSpanned, 0, paramAnonymousSpanned.length());
          int j = a(paramAnonymousSpanned, 0, paramAnonymousSpanned.length());
          int k = c.a(paramAnonymousSpanned, paramAnonymousInt3, paramAnonymousInt4);
          int m = a(paramAnonymousSpanned, paramAnonymousInt3, paramAnonymousInt4);
          paramAnonymousInt3 = c.a(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2);
          paramAnonymousInt4 = a(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2);
          i = 700 - (i + j * 49) + (k + m * 49);
          if (i <= 0) {
            return "";
          }
          if (i >= paramAnonymousInt3 + paramAnonymousInt4 * 49) {
            return null;
          }
          return c.a(paramAnonymousCharSequence, paramAnonymousInt1, paramAnonymousInt2, i);
        }
      } });
      paramBundle = getIntent().getStringExtra("android.intent.extra.TEXT");
      if ((paramBundle != null) && (TextUtils.getTrimmedLength(paramBundle) != 0)) {
        break label482;
      }
      this.z.setEnabled(false);
    }
    for (;;)
    {
      paramBundle = ann.a(this);
      this.o.setOnEditorActionListener(paramBundle);
      this.B = findViewById(2131755583);
      this.r = ((ImageButton)a.d.a(findViewById(2131755556)));
      this.p = new a(this.an, this, this.aq, this.D, this.aE, this.aQ);
      this.q = ((ConversationContentLayout)findViewById(2131755446));
      this.p.a(this.w);
      this.p.setOnDismissListener(ano.a(this));
      this.A = new f((GifSearchContainer)findViewById(2131755562), (EmojiSearchContainer)findViewById(2131755563), this.p, this);
      this.r.setOnClickListener(anp.a(this));
      this.A.a(new anq(this));
      this.A.h = new anr(this);
      this.A.e = new i.c()
      {
        public final void m()
        {
          TextStatusComposerActivity.d(TextStatusComposerActivity.this);
        }
        
        public final void n()
        {
          TextStatusComposerActivity.e(TextStatusComposerActivity.this);
        }
      };
      d.a(this, true);
      return;
      this.u = paramBundle.getInt("background_color_index");
      this.t = y[this.t];
      getWindow().setBackgroundDrawable(new ColorDrawable(this.t));
      break;
      label482:
      this.o.setText(paramBundle);
    }
  }
  
  public void onDestroy()
  {
    Log.i("textstatus/destroy");
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.isPrintingKey()) && (this.o.isShown()) && (!this.o.hasFocus()))
    {
      this.o.requestFocus();
      dispatchKeyEvent(paramKeyEvent);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (((paramInt == 82) || (paramInt == 4)) && (this.p.isShowing()))
    {
      this.p.t = false;
      this.p.dismiss();
      return false;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putLong("background_color_index", this.u);
  }
  
  final void p()
  {
    if (this.p.isShowing()) {
      this.p.dismiss();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/TextStatusComposerActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */