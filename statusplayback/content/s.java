package com.whatsapp.statusplayback.content;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.v4.content.b;
import android.text.TextUtils;
import android.view.View;
import com.whatsapp.TextData;
import com.whatsapp.TextEmojiLabel;
import com.whatsapp.protocol.j;

final class s
  extends c
{
  final a b;
  private final TextEmojiLabel c = new z(a());
  
  s(i parami)
  {
    super(parami);
    this.c.setTextColor(b.c(a(), 2131624135));
    this.c.setGravity(17);
    this.c.setTextSize(0, a().getResources().getDimensionPixelSize(2131362099));
    int i = a().getResources().getDimensionPixelSize(2131362098);
    int k = a().getResources().getDimensionPixelSize(2131362100);
    this.c.setPadding(i, k, i, k);
    parami = this.a.k.N;
    if ((parami instanceof TextData))
    {
      parami = (TextData)parami;
      if (parami.textColor != 0) {
        this.c.setTextColor(parami.textColor);
      }
      if (parami.backgroundColor != 0) {
        this.c.setBackgroundColor(parami.backgroundColor);
      }
    }
    switch (parami.fontStyle)
    {
    default: 
      this.c.setTypeface(Typeface.SANS_SERIF);
      parami = this.a.k.e();
      if (!TextUtils.isEmpty(parami)) {
        break;
      }
    }
    for (i = 0;; i = com.whatsapp.emoji.c.c(parami))
    {
      int m = parami.length();
      while ((j < m) && (i > 0))
      {
        int n = parami.codePointAt(j);
        k = i;
        if (Character.isWhitespace(n)) {
          k = i - 1;
        }
        j += Character.charCount(n);
        i = k;
      }
      this.c.setTypeface(Typeface.SERIF);
      break;
    }
    this.b = new a(2000L + Math.min(i, 1000) * 60);
  }
  
  final void a(Rect paramRect)
  {
    int i = a().getResources().getDimensionPixelSize(2131362098);
    int j = a().getResources().getDimensionPixelSize(2131362100);
    this.c.setPadding(paramRect.left + i, paramRect.top + j, i + paramRect.right, j + paramRect.bottom);
  }
  
  final void i()
  {
    this.b.a(0L);
    this.b.a();
    a(new t(this));
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
    this.c.b(this.a.k.e());
  }
  
  final void n() {}
  
  final View o()
  {
    return this.c;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/content/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */