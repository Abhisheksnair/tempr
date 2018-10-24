package com.whatsapp.statusplayback.content;

import android.content.Context;
import android.net.Uri;
import android.support.v4.content.b;
import android.text.Html;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.whatsapp.TextEmojiLabel;
import com.whatsapp.aog;
import com.whatsapp.aus;
import com.whatsapp.hy;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.pv;
import com.whatsapp.ti;
import com.whatsapp.util.at;

final class u
  extends c
{
  final a b = new a();
  private final TextEmojiLabel c = new TextEmojiLabel(a());
  private final FrameLayout d;
  
  u(i parami, aus paramaus)
  {
    super(parami);
    this.c.setTextColor(b.c(a(), 2131624135));
    this.c.setGravity(17);
    this.c.setTextSize(hy.a(a().getResources(), paramaus));
    int i = (int)hy.a(a().getResources(), paramaus);
    this.c.setPadding(i, i, i, i);
    this.d = new FrameLayout(a());
    this.d.addView(this.c, new FrameLayout.LayoutParams(-2, -2, 17));
  }
  
  final void i()
  {
    this.b.a(0L);
    this.b.a();
    a(new v(this));
    c();
  }
  
  final void j()
  {
    this.b.b();
  }
  
  final void k()
  {
    this.b.b();
  }
  
  final void l()
  {
    this.b.a();
  }
  
  final void m()
  {
    final String str = aog.b().toString();
    if (this.a.k.e.b) {}
    Spannable localSpannable;
    for (int i = 2131296812;; i = 2131296811)
    {
      Object localObject1 = a().getString(i, new Object[] { str });
      localSpannable = Spannable.Factory.getInstance().newSpannable(Html.fromHtml((String)localObject1));
      localObject1 = (URLSpan[])localSpannable.getSpans(0, ((String)localObject1).length(), URLSpan.class);
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        int k = localSpannable.getSpanStart(localObject2);
        int m = localSpannable.getSpanEnd(localObject2);
        localSpannable.removeSpan(localObject2);
        localSpannable.setSpan(new ti(b(), ((URLSpan)localObject2).getURL(), -16733289), k, m, 0);
        i += 1;
      }
    }
    this.c.setText(localSpannable);
    this.c.setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        pv.a(paramAnonymousView.getContext(), Uri.parse(str));
      }
    });
  }
  
  final void n() {}
  
  final View o()
  {
    return this.d;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/content/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */