package com.whatsapp;

import a.a.a.a.d;
import android.app.Activity;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.whatsapp.emoji.c;
import com.whatsapp.emoji.h;
import com.whatsapp.emoji.search.EmojiSearchContainer;
import com.whatsapp.emoji.search.i;
import com.whatsapp.emoji.search.i.c;

public final class ui
{
  public final View a;
  final View b;
  final hw c;
  final i d;
  final ImageButton e;
  public final MentionableEntry f;
  final EmojiPicker.c g = new EmojiPicker.c()
  {
    public final void a()
    {
      ui.this.f.dispatchKeyEvent(new KeyEvent(0, 67));
    }
    
    public final void a(int paramAnonymousInt)
    {
      int i = ui.this.f.getSelectionStart();
      int j = ui.this.f.getSelectionEnd();
      int k;
      if (i > j)
      {
        k = j;
        j = i;
      }
      for (;;)
      {
        StringBuilder localStringBuilder = new StringBuilder(ui.this.f.getText().toString());
        localStringBuilder.replace(k, j, c.b(paramAnonymousInt));
        if (c.c(localStringBuilder) > 1024) {
          return;
        }
        ui.this.f.getText().replace(k, j, c.b(paramAnonymousInt));
        ui.this.f.setSelection(k + c.a(paramAnonymousInt));
        return;
        k = i;
      }
    }
  };
  public final ViewTreeObserver.OnGlobalLayoutListener h = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      Rect localRect = new Rect();
      ui.this.a.getWindowVisibleDisplayFrame(localRect);
      int i;
      if (ui.this.a.getRootView().getHeight() - (localRect.bottom - localRect.top) > 128.0F * aoa.a().a)
      {
        i = 1;
        if ((i == 0) || (ui.this.b.getVisibility() != 8)) {
          break label108;
        }
        ui.this.b.startAnimation(ui.a(true));
        ui.this.b.setVisibility(0);
      }
      label108:
      while ((i != 0) || (ui.this.b.getVisibility() != 0))
      {
        return;
        i = 0;
        break;
      }
      ui.this.b.startAnimation(ui.a(false));
      ui.this.b.setVisibility(8);
      ui.this.c.dismiss();
    }
  };
  
  public ui(final Activity paramActivity, pv parampv, h paramh, atv paramatv, and paramand, final View paramView, String paramString)
  {
    this.a = paramView;
    this.b = paramView.findViewById(2131755861);
    this.f = ((MentionableEntry)paramView.findViewById(2131755863));
    this.f.setInputEnterDone(true);
    this.f.setFilters(new InputFilter[] { new px(1024) });
    this.f.setOnEditorActionListener(uj.a(this, paramActivity));
    this.f.addTextChangedListener(new tg(parampv, paramand, this.f, (TextView)paramView.findViewById(2131755862), 1024, 30, true));
    if ((paramString != null) && (qz.e(paramString))) {
      this.f.a((FrameLayout)paramView.findViewById(2131755447), paramString, false, true);
    }
    this.c = new hw(paramActivity, parampv, paramh, paramand, paramatv);
    this.c.b = true;
    this.d = new i((EmojiSearchContainer)paramView.findViewById(2131755563), this.c, paramActivity);
    this.d.e = new i.c()
    {
      public final void m()
      {
        if (ui.this.c.isShowing()) {
          ui.this.c.dismiss();
        }
      }
      
      public final void n()
      {
        ui.this.c.a(paramView.findViewById(2131755549), ui.this.e, ui.this.f);
        d.a(paramActivity.getApplicationContext(), false);
      }
    };
    this.d.a(new uk(this));
    this.c.a(this.g);
    this.e = ((ImageButton)paramView.findViewById(2131755556));
    this.e.setOnClickListener(ul.a(this, paramView));
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(this.h);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */