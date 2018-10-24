package com.whatsapp.camera;

import a.a.a.a.d;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.content.b;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannedString;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.whatsapp.EmojiPicker.c;
import com.whatsapp.MentionableEntry;
import com.whatsapp.al;
import com.whatsapp.and;
import com.whatsapp.atv;
import com.whatsapp.emoji.a;
import com.whatsapp.emoji.c;
import com.whatsapp.emoji.h;
import com.whatsapp.emoji.search.EmojiSearchContainer;
import com.whatsapp.emoji.search.i;
import com.whatsapp.emoji.search.i.a;
import com.whatsapp.emoji.search.i.c;
import com.whatsapp.hw;
import com.whatsapp.pv;
import com.whatsapp.px;
import com.whatsapp.qz;
import com.whatsapp.tg;
import com.whatsapp.util.az;
import java.util.ArrayList;

public final class ar
  extends Dialog
{
  ImageButton a;
  hw b;
  i c;
  public MentionableEntry d;
  public boolean e;
  public String f;
  public ArrayList<String> g;
  public CharSequence h;
  final Activity i;
  private final String j;
  private CharSequence k;
  private final pv l;
  private final h m;
  private final and n;
  private final atv o;
  private final EmojiPicker.c p = new EmojiPicker.c()
  {
    public final void a()
    {
      ar.this.d.dispatchKeyEvent(new KeyEvent(0, 67));
    }
    
    public final void a(int paramAnonymousInt)
    {
      int i = ar.this.d.getSelectionStart();
      int j = ar.this.d.getSelectionEnd();
      int k;
      if (i > j)
      {
        k = j;
        j = i;
      }
      for (;;)
      {
        StringBuilder localStringBuilder = new StringBuilder(ar.this.d.getText().toString());
        localStringBuilder.replace(k, j, c.b(paramAnonymousInt));
        if (c.c(localStringBuilder) > 1024) {
          return;
        }
        ar.this.d.getText().replace(k, j, c.b(paramAnonymousInt));
        ar.this.d.setSelection(k + c.a(paramAnonymousInt));
        return;
        k = i;
      }
    }
  };
  
  public ar(Activity paramActivity, pv parampv, h paramh, and paramand, atv paramatv, String paramString, CharSequence paramCharSequence)
  {
    super(paramActivity, 2131427568);
    this.j = paramString;
    this.k = paramCharSequence;
    this.i = paramActivity;
    this.l = parampv;
    this.m = paramh;
    this.n = paramand;
    this.o = paramatv;
  }
  
  public final void dismiss()
  {
    super.dismiss();
    if (this.b.isShowing()) {
      this.b.dismiss();
    }
    this.f = this.d.getStringText();
    this.g = this.d.getMentions();
    this.h = new SpannedString(this.d.getText());
    this.d.a();
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    al.a(getWindow());
    paramBundle = al.a(this.l, getLayoutInflater(), 2130903103, null, false);
    setContentView(paramBundle);
    getWindow().setLayout(-1, -1);
    if ((this.i.getWindow().getAttributes().flags & 0x400) != 0)
    {
      getWindow().setFlags(1024, 1024);
      getWindow().clearFlags(256);
    }
    getWindow().setSoftInputMode(5);
    findViewById(2131755446).setOnClickListener(new com.whatsapp.util.at()
    {
      public final void a(View paramAnonymousView)
      {
        ar.this.dismiss();
      }
    });
    Object localObject = (ImageButton)findViewById(2131755437);
    int i1;
    if (this.j != null)
    {
      ((ImageButton)localObject).setImageDrawable(new az(b.a(this.i, 2130840323)));
      ((ImageButton)localObject).setContentDescription(this.i.getString(2131297656));
      ((ImageButton)localObject).setOnClickListener(new com.whatsapp.util.at()
      {
        public final void a(View paramAnonymousView)
        {
          ar.this.e = true;
          ar.this.dismiss();
        }
      });
      this.d = ((MentionableEntry)findViewById(2131755436));
      this.d.setText(this.k);
      this.d.setSelection(this.k.length(), this.k.length());
      this.d.setInputEnterDone(true);
      this.d.setFilters(new InputFilter[] { new px(1024) });
      this.d.setOnEditorActionListener(as.a(this));
      this.d.addTextChangedListener(new tg(this.l, this.n, this.d, (TextView)findViewById(2131755862), 1024, 30, true));
      this.d.setOnEditorActionListener(at.a(this));
      this.d.setOnKeyPreImeListener(new au(this));
      localObject = (FrameLayout)findViewById(2131755447);
      if ((this.j != null) && (qz.e(this.j))) {
        this.d.a((ViewGroup)localObject, this.j, true, true);
      }
      this.b = new hw(paramBundle, this.i, this.l, this.m, this.n, this.o)
      {
        public final void dismiss()
        {
          super.dismiss();
          ar.a(ar.this).setImageResource(2130840318);
        }
      };
      this.b.b = true;
      this.c = new i((EmojiSearchContainer)findViewById(2131755563), this.b, this.i);
      this.c.e = new i.c()
      {
        public final void m()
        {
          if (ar.b(ar.this).isShowing()) {
            ar.b(ar.this).dismiss();
          }
        }
        
        public final void n()
        {
          ar.b(ar.this).a(ar.a(ar.this), ar.a(ar.this), ar.this.d);
          ar.a(ar.this).setImageResource(2130840320);
          d.a(ar.c(ar.this).getApplicationContext(), false);
        }
      };
      this.c.a(new i.a()
      {
        public final void a(a paramAnonymousa)
        {
          paramAnonymousa = paramAnonymousa.a;
          int j = paramAnonymousa.length;
          int i = 0;
          while (i < j)
          {
            int k = paramAnonymousa[i];
            ar.d(ar.this).a(k);
            i += 1;
          }
        }
      });
      this.b.a(this.p);
      findViewById(2131755861).setVisibility(0);
      findViewById(2131755915).setVisibility(8);
      this.a = ((ImageButton)findViewById(2131755556));
      this.a.setOnClickListener(av.a(this));
      this.a.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      i1 = -this.a.getMeasuredWidth() + getContext().getResources().getDimensionPixelSize(2131361907);
      if (!this.l.d()) {
        break label677;
      }
    }
    label677:
    for (float f1 = i1;; f1 = -i1)
    {
      paramBundle = new TranslateAnimation(f1, 0.0F, 0.0F, 0.0F);
      paramBundle.setDuration(220L);
      paramBundle.setInterpolator(new DecelerateInterpolator());
      findViewById(2131755861).startAnimation(paramBundle);
      findViewById(2131755436).startAnimation(paramBundle);
      d.a(getContext(), true);
      return;
      ((ImageButton)localObject).setImageResource(2130840145);
      ((ImageButton)localObject).setContentDescription(this.i.getString(2131296687));
      break;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/camera/ar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */