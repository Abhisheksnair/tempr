package com.whatsapp;

import a.a.a.a.d;
import android.app.Activity;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.whatsapp.data.cs;
import com.whatsapp.emoji.a;
import com.whatsapp.emoji.c;
import com.whatsapp.emoji.h;
import com.whatsapp.emoji.search.EmojiSearchContainer;
import com.whatsapp.emoji.search.i;
import com.whatsapp.emoji.search.i.a;
import com.whatsapp.emoji.search.i.c;
import java.util.List;

public final class vg
{
  final View a;
  final hw b;
  final i c;
  final ImageButton d;
  final MentionableEntry e;
  final EmojiPicker.c f = new EmojiPicker.c()
  {
    public final void a()
    {
      vg.this.e.dispatchKeyEvent(new KeyEvent(0, 67));
    }
    
    public final void a(int paramAnonymousInt)
    {
      int i = vg.this.e.getSelectionStart();
      int j = vg.this.e.getSelectionEnd();
      int k;
      if (i > j)
      {
        k = j;
        j = i;
      }
      for (;;)
      {
        StringBuilder localStringBuilder = new StringBuilder(vg.this.e.getText().toString());
        localStringBuilder.replace(k, j, c.b(paramAnonymousInt));
        if (c.c(localStringBuilder) > 1024) {
          return;
        }
        vg.this.e.getText().replace(k, j, c.b(paramAnonymousInt));
        vg.this.e.setSelection(k + c.a(paramAnonymousInt));
        return;
        k = i;
      }
    }
  };
  final ViewTreeObserver.OnGlobalLayoutListener g = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      int k = 8;
      Object localObject = new Rect();
      vg.this.a.getWindowVisibleDisplayFrame((Rect)localObject);
      int i;
      if (vg.this.a.getRootView().getHeight() - (((Rect)localObject).bottom - ((Rect)localObject).top) > 128.0F * aoa.a().a)
      {
        i = 1;
        localObject = vg.this.a.findViewById(2131755861);
        if (i == 0) {
          break label137;
        }
        j = 0;
        label85:
        ((View)localObject).setVisibility(j);
        localObject = vg.this.a.findViewById(2131755915);
        if (i == 0) {
          break label143;
        }
      }
      label137:
      label143:
      for (int j = k;; j = 0)
      {
        ((View)localObject).setVisibility(j);
        if (i == 0) {
          vg.this.b.dismiss();
        }
        return;
        i = 0;
        break;
        j = 8;
        break label85;
      }
    }
  };
  
  public vg(final Activity paramActivity, pv parampv, h paramh, and paramand, atv paramatv, View paramView, cs paramcs, String paramString, List<String> paramList)
  {
    this.a = paramView;
    this.e = ((MentionableEntry)paramView.findViewById(2131755436));
    this.e.setInputEnterDone(true);
    this.e.setFilters(new InputFilter[] { new px(1024) });
    this.e.setOnEditorActionListener(vh.a(this, paramActivity));
    this.e.addTextChangedListener(new tg(parampv, paramand, this.e, (TextView)paramView.findViewById(2131755862), 1024, 30, true));
    if ((paramcs != null) && (paramcs.d())) {
      this.e.a((FrameLayout)paramView.findViewById(2131755447), paramcs.t, true, true);
    }
    if (!TextUtils.isEmpty(paramString)) {
      this.e.a(paramString, paramList);
    }
    this.b = new hw(paramActivity, parampv, paramh, paramand, paramatv)
    {
      public final void dismiss()
      {
        super.dismiss();
        vg.this.d.setImageResource(2130840318);
      }
    };
    this.b.b = true;
    this.c = new i((EmojiSearchContainer)paramView.findViewById(2131755563), this.b, paramActivity);
    this.c.e = new i.c()
    {
      public final void m()
      {
        if (vg.this.b.isShowing()) {
          vg.this.b.dismiss();
        }
      }
      
      public final void n()
      {
        vg.this.b.a(vg.this.d, vg.this.d, vg.this.e);
        vg.this.d.setImageResource(2130840320);
        d.a(paramActivity.getApplicationContext(), false);
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
          vg.this.f.a(k);
          i += 1;
        }
      }
    });
    this.b.a(this.f);
    this.d = ((ImageButton)paramView.findViewById(2131755556));
    this.d.setOnClickListener(vi.a(this));
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(this.g);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/vg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */