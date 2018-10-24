package com.whatsapp.memory.dump.a;

import java.util.Map;

public final class d
  extends c
{
  public final b d = new b();
  
  public d(com.whatsapp.memory.dump.a.a.a parama)
  {
    super(parama);
  }
  
  protected final int e()
  {
    int k = 0;
    long l1 = b();
    this.a.c();
    long l2 = b();
    b();
    b();
    b();
    b();
    b();
    this.a.c();
    int i = this.b;
    int m = d();
    i = i * 7 + 4 + 4 + 2;
    int j = 0;
    while (j < m)
    {
      d();
      i += h() + 2;
      j += 1;
    }
    m = d();
    i += 2;
    j = 0;
    while (j < m)
    {
      b();
      localObject = f.a(this.a.a());
      a(this.c.a((f)localObject));
      int n = this.b;
      int i1 = this.c.a((f)localObject);
      j += 1;
      i = i1 + (n + 1) + i;
    }
    m = d();
    Object localObject = new f[m];
    i += 2;
    j = k;
    while (j < m)
    {
      b();
      localObject[j] = f.a(c());
      k = this.b;
      j += 1;
      i = k + 1 + i;
    }
    localObject = new a(l1, l2, (f[])localObject);
    this.d.a.put(Long.valueOf(((a)localObject).a), localObject);
    return i;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/memory/dump/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */