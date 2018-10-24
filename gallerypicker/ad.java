package com.whatsapp.gallerypicker;

import android.database.ContentObserver;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public final class ad
  implements r
{
  private final r[] a;
  private final PriorityQueue<c> b;
  private long[] c;
  private int d;
  private int[] e;
  private int f;
  
  public ad(r[] paramArrayOfr, int paramInt)
  {
    this.a = ((r[])paramArrayOfr.clone());
    if (paramInt == 1) {}
    for (paramArrayOfr = new a((byte)0);; paramArrayOfr = new b((byte)0))
    {
      this.b = new PriorityQueue(4, paramArrayOfr);
      this.c = new long[16];
      this.d = 0;
      this.e = new int[this.a.length];
      this.f = -1;
      this.b.clear();
      int i = this.a.length;
      paramInt = 0;
      while (paramInt < i)
      {
        paramArrayOfr = new c(this.a[paramInt], paramInt);
        if (paramArrayOfr.a()) {
          this.b.add(paramArrayOfr);
        }
        paramInt += 1;
      }
    }
  }
  
  public final HashMap<String, String> a()
  {
    HashMap localHashMap = new HashMap();
    r[] arrayOfr = this.a;
    int j = arrayOfr.length;
    int i = 0;
    while (i < j)
    {
      localHashMap.putAll(arrayOfr[i].a());
      i += 1;
    }
    return localHashMap;
  }
  
  public final void a(ContentObserver paramContentObserver)
  {
    r[] arrayOfr = this.a;
    int j = arrayOfr.length;
    int i = 0;
    while (i < j)
    {
      arrayOfr[i].a(paramContentObserver);
      i += 1;
    }
  }
  
  public final int b()
  {
    int i = 0;
    r[] arrayOfr = this.a;
    int k = arrayOfr.length;
    int j = 0;
    while (i < k)
    {
      j += arrayOfr[i].b();
      i += 1;
    }
    return j;
  }
  
  public final q b(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > b())) {
      throw new IndexOutOfBoundsException("index " + paramInt + " out of range max is " + b());
    }
    Arrays.fill(this.e, 0);
    int k = this.d;
    int j = 0;
    int i = 0;
    Object localObject1;
    label162:
    Object localObject2;
    while (j < k)
    {
      long l = this.c[j];
      int m = (int)l;
      int n = (int)(l >> 32);
      if (i + m > paramInt)
      {
        j = this.e[n];
        localObject1 = this.a[n].b(paramInt - i + j);
        return (q)localObject1;
      }
      localObject1 = this.e;
      localObject1[n] += m;
      j += 1;
      i += m;
      continue;
      if (((c)localObject2).a()) {
        this.b.add(localObject2);
      }
      i += 1;
    }
    for (;;)
    {
      localObject2 = (c)this.b.poll();
      if (localObject2 == null)
      {
        localObject2 = null;
        if (localObject2 == null) {
          return null;
        }
      }
      else
      {
        if (((c)localObject2).a == this.f)
        {
          j = this.d - 1;
          localObject1 = this.c;
          localObject1[j] += 1L;
        }
        for (;;)
        {
          break;
          this.f = ((c)localObject2).a;
          if (this.c.length == this.d)
          {
            localObject1 = new long[this.d << 1];
            System.arraycopy(this.c, 0, localObject1, 0, this.d);
            this.c = ((long[])localObject1);
          }
          localObject1 = this.c;
          j = this.d;
          this.d = (j + 1);
          localObject1[j] = (this.f << 32 | 1L);
        }
      }
      if (i != paramInt) {
        break label162;
      }
      q localq = ((c)localObject2).c;
      localObject1 = localq;
      if (!((c)localObject2).a()) {
        break;
      }
      this.b.add(localObject2);
      return localq;
    }
  }
  
  public final void b(ContentObserver paramContentObserver)
  {
    r[] arrayOfr = this.a;
    int j = arrayOfr.length;
    int i = 0;
    while (i < j)
    {
      arrayOfr[i].b(paramContentObserver);
      i += 1;
    }
  }
  
  public final boolean c()
  {
    r[] arrayOfr = this.a;
    int j = arrayOfr.length;
    int i = 0;
    while (i < j)
    {
      if (!arrayOfr[i].c()) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public final void d()
  {
    int i = 0;
    int j = this.a.length;
    while (i < j)
    {
      this.a[i].d();
      i += 1;
    }
  }
  
  public final void e()
  {
    r[] arrayOfr = this.a;
    int j = arrayOfr.length;
    int i = 0;
    while (i < j)
    {
      arrayOfr[i].e();
      i += 1;
    }
  }
  
  static final class a
    implements Comparator<ad.c>
  {}
  
  static final class b
    implements Comparator<ad.c>
  {}
  
  static final class c
  {
    int a;
    long b;
    q c;
    private int d = -1;
    private final r e;
    
    public c(r paramr, int paramInt)
    {
      this.e = paramr;
      this.a = paramInt;
    }
    
    public final boolean a()
    {
      if (this.d >= this.e.b() - 1) {
        return false;
      }
      r localr = this.e;
      int i = this.d + 1;
      this.d = i;
      this.c = localr.b(i);
      this.b = this.c.c();
      return true;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */