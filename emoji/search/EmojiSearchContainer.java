package com.whatsapp.emoji.search;

import a.a.a.a.d;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.f;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.whatsapp.pv;
import com.whatsapp.util.InterceptingEditText;
import com.whatsapp.util.at;

public class EmojiSearchContainer
  extends FrameLayout
{
  private boolean a;
  private Activity b;
  private pv c;
  private i.a d;
  private b e;
  private InterceptingEditText f;
  private View g;
  private String h;
  private q i;
  private View j;
  private RecyclerView k;
  
  public EmojiSearchContainer(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmojiSearchContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EmojiSearchContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public EmojiSearchContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  private void a(String paramString)
  {
    if ((this.i == null) || (!this.i.b)) {
      return;
    }
    this.j.setVisibility(8);
    this.g.setVisibility(0);
    this.e.a(this.i.a(paramString));
    this.h = paramString;
  }
  
  public final void a()
  {
    setVisibility(8);
    this.i = null;
  }
  
  public final void a(final i parami, final pv parampv, Activity paramActivity, q paramq, i.a parama)
  {
    this.b = paramActivity;
    this.c = parampv;
    this.i = paramq;
    this.d = parama;
    if (!this.a)
    {
      this.a = true;
      paramActivity.getLayoutInflater().inflate(2130903217, this, true);
      this.j = findViewById(2131755760);
      this.k = ((RecyclerView)findViewById(2131755764));
      final int m = getResources().getDimensionPixelSize(2131362083);
      this.k.a(new RecyclerView.f()
      {
        public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView)
        {
          paramAnonymousRect.set(0, m, m, m);
        }
      });
      parampv = new LinearLayoutManager(paramActivity);
      parampv.b(0);
      this.k.setLayoutManager(parampv);
      this.g = findViewById(2131755761);
      this.f = ((InterceptingEditText)findViewById(2131755206));
      this.f.setHint(paramActivity.getString(2131296723));
      parampv = findViewById(2131755766);
      parampv.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          EmojiSearchContainer.a(EmojiSearchContainer.this).setText("");
        }
      });
      setOnTouchListener(e.a());
      this.f.setOnBackButtonListener(new f(parami));
      this.f.addTextChangedListener(new TextWatcher()
      {
        Runnable a;
        
        public final void afterTextChanged(Editable paramAnonymousEditable) {}
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          if (this.a != null) {
            EmojiSearchContainer.a(EmojiSearchContainer.this).removeCallbacks(this.a);
          }
          this.a = h.a(this, paramAnonymousCharSequence);
          EmojiSearchContainer.a(EmojiSearchContainer.this).postDelayed(this.a, 500L);
          View localView = parampv;
          if (TextUtils.isEmpty(paramAnonymousCharSequence)) {}
          for (paramAnonymousInt1 = 4;; paramAnonymousInt1 = 0)
          {
            localView.setVisibility(paramAnonymousInt1);
            return;
          }
        }
      });
      findViewById(2131755439).setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          parami.b();
        }
      });
    }
    setVisibility(0);
    this.j.setVisibility(0);
    this.g.setVisibility(8);
    parami = this.b;
    parampv = this.c;
    paramActivity = this.d;
    paramActivity.getClass();
    this.e = new b(parami, parampv, new g(paramActivity), getResources().getDimensionPixelSize(2131361991))
    {
      public final void b(s paramAnonymouss)
      {
        int i = 8;
        super.b(paramAnonymouss);
        EmojiSearchContainer.c(EmojiSearchContainer.this).setVisibility(8);
        paramAnonymouss = EmojiSearchContainer.e(EmojiSearchContainer.this);
        if (EmojiSearchContainer.d(EmojiSearchContainer.this).a() == 0) {
          i = 0;
        }
        paramAnonymouss.setVisibility(i);
      }
    };
    this.k.setAdapter(this.e);
    this.h = "";
    a("");
    this.f.setText("");
    this.f.requestFocus();
    d.a(getContext(), false);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/emoji/search/EmojiSearchContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */