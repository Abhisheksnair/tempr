package com.whatsapp.memory.dump.a;

import com.whatsapp.memory.dump.a.a.a;
import java.io.EOFException;
import java.io.PrintStream;

public class c
{
  protected final a a;
  int b;
  g c;
  
  public c(a parama)
  {
    this.a = parama;
  }
  
  private void b(long paramLong)
  {
    while (paramLong > 0L)
    {
      int i = c();
      paramLong -= 1L;
      switch (i)
      {
      default: 
        throw new IllegalArgumentException("loadHeapDump loop with unknown tag " + i + " with " + this.a.g() + " bytes possibly remaining");
      case 1: 
        long l = i();
        b();
        paramLong = paramLong - l - this.b;
        break;
      case 2: 
      case 3: 
        a(this.b + 4 + 4);
        paramLong -= this.b + 4 + 4;
        break;
      case 4: 
        b();
        this.a.c();
        paramLong -= this.b + 4;
        break;
      case 6: 
        b();
        this.a.c();
        paramLong -= this.b + 4;
        break;
      case 8: 
        b();
        this.a.c();
        this.a.c();
        paramLong -= this.b + 4 + 4;
        break;
      case 32: 
        paramLong -= e();
        break;
      case 33: 
        paramLong -= f();
        break;
      case 34: 
        b();
        this.a.c();
        i = this.a.c();
        b();
        i *= this.b;
        a(i);
        paramLong -= i + (this.b + 4 + 4 + this.b);
        break;
      case 35: 
        paramLong -= g();
        break;
      case 195: 
        System.err.println("+--- PRIMITIVE ARRAY NODATA DUMP");
        g();
        throw new IllegalArgumentException("Don't know how to load a nodata array");
      case 254: 
        this.a.c();
        b();
        paramLong -= this.b + 4;
        break;
      case 5: 
      case 7: 
      case 137: 
      case 138: 
      case 139: 
      case 140: 
      case 141: 
      case 144: 
      case 255: 
        paramLong -= i();
        break;
      case 142: 
        b();
        this.a.c();
        this.a.c();
        paramLong -= this.b + 4 + 4;
      }
    }
  }
  
  private int i()
  {
    a(this.b);
    return this.b;
  }
  
  public final void a()
  {
    this.c = new g();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      for (int i = this.a.a(); i != 0; i = this.a.a()) {
        localStringBuilder.append((char)i);
      }
      this.b = this.a.c();
      this.c.a(this.b);
      this.a.d();
      if (this.a.f())
      {
        i = c();
        this.a.c();
        long l = this.a.c() & 0xFFFFFFFF;
        switch (i)
        {
        }
        for (;;)
        {
          a(l);
          break;
          b(l);
          break;
        }
      }
      return;
    }
    catch (EOFException localEOFException) {}
  }
  
  protected final void a(long paramLong)
  {
    this.a.a(this.a.e() + paramLong);
  }
  
  protected final long b()
  {
    switch (this.b)
    {
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    default: 
      throw new IllegalArgumentException("ID Length must be 1, 2, 4, or 8");
    case 1: 
      return this.a.a();
    case 2: 
      return this.a.b();
    case 4: 
      return this.a.c();
    }
    return this.a.d();
  }
  
  protected final int c()
  {
    return this.a.a() & 0xFF;
  }
  
  protected final int d()
  {
    return this.a.b() & 0xFFFF;
  }
  
  protected int e()
  {
    int k = 0;
    b();
    int i = this.b;
    this.a.c();
    b();
    int j = this.b;
    b();
    int n = this.b;
    b();
    int i1 = this.b;
    b();
    int i2 = this.b;
    b();
    int i3 = this.b;
    b();
    int i4 = this.b;
    this.a.c();
    int m = d();
    i = i + 4 + j + n + i1 + i2 + i3 + i4 + 4 + 2;
    j = 0;
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
      f localf = f.a(this.a.a());
      a(this.c.a(localf));
      n = this.b;
      i += this.c.a(localf) + (n + 1);
      j += 1;
    }
    m = d();
    j = i + 2;
    i = k;
    while (i < m)
    {
      b();
      f.a(c());
      j += this.b + 1;
      i += 1;
    }
    return j;
  }
  
  protected int f()
  {
    b();
    this.a.c();
    b();
    int i = this.a.c();
    a(i);
    return i + (this.b + 4 + this.b + 4);
  }
  
  protected int g()
  {
    b();
    this.a.c();
    int i = this.a.c();
    f localf = f.a(c());
    i *= this.c.a(localf);
    a(i);
    return i + (this.b + 4 + 4 + 1);
  }
  
  protected final int h()
  {
    f localf = f.a(c());
    int i = this.c.a(localf);
    a(i);
    return i + 1;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/memory/dump/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */