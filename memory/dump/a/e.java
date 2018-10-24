package com.whatsapp.memory.dump.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class e
  extends c
{
  private final b d;
  
  public e(com.whatsapp.memory.dump.a.a.b paramb, b paramb1)
  {
    super(paramb);
    this.d = paramb1;
  }
  
  private void a(f paramf)
  {
    ((com.whatsapp.memory.dump.a.a.b)this.a).b(new byte[paramf.k]);
  }
  
  protected final int e()
  {
    int k = 0;
    b();
    this.a.c();
    b();
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
    if (j < m)
    {
      b();
      f localf = f.a(this.a.a());
      if (localf == f.a) {
        b();
      }
      for (;;)
      {
        int n = this.b;
        i += this.c.a(localf) + (n + 1);
        j += 1;
        break;
        a(localf);
      }
    }
    m = d();
    j = i + 2;
    i = k;
    while (i < m)
    {
      b();
      c();
      j += this.b + 1;
      i += 1;
    }
    return j;
  }
  
  protected final int f()
  {
    b();
    this.a.c();
    long l = b();
    int j = this.a.c();
    Object localObject2 = this.d;
    Object localObject3 = new ArrayList();
    Object localObject1 = (a)((b)localObject2).a.get(Long.valueOf(l));
    ((List)localObject3).add(localObject1);
    if (((a)localObject1).b != 0L) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label131;
      }
      localObject1 = (a)((b)localObject2).a.get(Long.valueOf(((a)localObject1).b));
      ((List)localObject3).add(localObject1);
      break;
    }
    label131:
    localObject1 = ((List)localObject3).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((a)((Iterator)localObject1).next()).c.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (f)((Iterator)localObject2).next();
        if (localObject3 == f.a) {
          b();
        } else {
          a((f)localObject3);
        }
      }
    }
    return this.b + 4 + this.b + 4 + j;
  }
  
  protected final int g()
  {
    b();
    this.a.c();
    int i = this.a.c();
    Object localObject = f.a(c());
    i = this.c.a((f)localObject) * i;
    localObject = new byte[i];
    ((com.whatsapp.memory.dump.a.a.b)this.a).b((byte[])localObject);
    return this.b + 4 + 4 + 1 + i;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/memory/dump/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */