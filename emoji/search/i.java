package com.whatsapp.emoji.search;

import android.app.Activity;
import android.view.View;
import com.whatsapp.emoji.a;
import com.whatsapp.os;
import com.whatsapp.pv;

public class i
{
  final pv a = pv.a();
  public final EmojiSearchContainer b;
  final n c;
  protected a d;
  public c e;
  private final os f;
  
  public i(EmojiSearchContainer paramEmojiSearchContainer, os paramos, Activity paramActivity)
  {
    this.b = paramEmojiSearchContainer;
    this.c = null;
    this.f = paramos;
    paramos.s = new k(this, paramEmojiSearchContainer, paramActivity, paramos);
  }
  
  public i(os paramos, Activity paramActivity, View paramView, boolean paramBoolean)
  {
    this.f = paramos;
    this.c = new n(paramActivity, this.a);
    this.b = this.c.c;
    paramos.s = new j(this, paramView, paramBoolean, paramos);
  }
  
  public final void a(a parama)
  {
    this.d = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b.getVisibility() == 0)
    {
      this.b.a();
      if ((this.c != null) && (this.c.isShowing())) {
        this.c.dismiss();
      }
    }
    os localos = this.f;
    localos.q = false;
    if (localos.p != null) {
      localos.p.setVisibility(8);
    }
  }
  
  public boolean a()
  {
    return this.b.getVisibility() == 0;
  }
  
  public boolean b()
  {
    if (this.b.getVisibility() == 0)
    {
      a(true);
      if (this.e != null) {
        this.e.n();
      }
      return true;
    }
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
  }
  
  public static abstract interface b
  {
    public abstract void a(q paramq);
  }
  
  public static abstract interface c
  {
    public abstract void m();
    
    public abstract void n();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/emoji/search/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */