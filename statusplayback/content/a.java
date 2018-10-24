package com.whatsapp.statusplayback.content;

import android.os.SystemClock;

final class a
{
  boolean a;
  final long b;
  private long c;
  private long d;
  
  a()
  {
    this(4500L);
  }
  
  a(long paramLong)
  {
    this.b = paramLong;
  }
  
  final void a()
  {
    if (!this.a) {
      this.d = SystemClock.elapsedRealtime();
    }
    this.a = true;
  }
  
  final void a(long paramLong)
  {
    this.c = paramLong;
    this.d = SystemClock.elapsedRealtime();
  }
  
  final void b()
  {
    if (this.a) {
      this.c += SystemClock.elapsedRealtime() - this.d;
    }
    this.a = false;
  }
  
  final long c()
  {
    long l2 = this.c;
    long l1 = l2;
    if (this.a) {
      l1 = l2 + (SystemClock.elapsedRealtime() - this.d);
    }
    return l1;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/content/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */