package com.whatsapp.statusplayback.content;

import com.whatsapp.statusplayback.StatusPlaybackProgressView.a;
import com.whatsapp.videoplayback.o;

final class d
  extends w
{
  int b;
  int c;
  int d;
  int e = 3;
  float f;
  
  d(i parami)
  {
    super(parami);
  }
  
  final int a(int paramInt)
  {
    int i = 3;
    if ((this.h instanceof w.a)) {
      i = 1;
    }
    while (paramInt == 0) {
      return i;
    }
    return Math.max(3, 6000 / paramInt);
  }
  
  final void a(boolean paramBoolean) {}
  
  final void e() {}
  
  final void f() {}
  
  final void i()
  {
    this.b = 0;
    this.c = 0;
    this.f = 0.0F;
    super.i();
    this.h.d = new e(this);
  }
  
  final void j()
  {
    if (this.h != null) {
      this.h.d = null;
    }
    super.j();
  }
  
  final StatusPlaybackProgressView.a p()
  {
    return new f(this);
  }
  
  final void q()
  {
    if (this.h != null) {
      this.h.a(true);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/content/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */