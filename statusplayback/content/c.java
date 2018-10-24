package com.whatsapp.statusplayback.content;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import com.whatsapp.pv;
import com.whatsapp.statusplayback.StatusPlaybackProgressView;
import com.whatsapp.statusplayback.StatusPlaybackProgressView.a;

public abstract class c
{
  final i a;
  
  c(i parami)
  {
    this.a = parami;
  }
  
  final Context a()
  {
    return this.a.e.getContext();
  }
  
  void a(Rect paramRect) {}
  
  final void a(StatusPlaybackProgressView.a parama)
  {
    this.a.j.setProgressProvider(parama);
  }
  
  void a(boolean paramBoolean) {}
  
  final pv b()
  {
    return this.a.t;
  }
  
  public final void c()
  {
    i locali = this.a;
    locali.m = true;
    locali.f.a();
  }
  
  final void d()
  {
    a(null);
    i locali = this.a;
    if (!locali.n) {
      locali.r.post(m.a(locali));
    }
  }
  
  void e()
  {
    i locali = this.a;
    locali.f.a(locali);
  }
  
  void f()
  {
    i locali = this.a;
    locali.f.b(locali);
  }
  
  final boolean g()
  {
    return i.a(this.a.k);
  }
  
  boolean h()
  {
    return false;
  }
  
  abstract void i();
  
  abstract void j();
  
  abstract void k();
  
  abstract void l();
  
  abstract void m();
  
  abstract void n();
  
  public abstract View o();
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/content/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */