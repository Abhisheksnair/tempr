package com.whatsapp.m;

import com.whatsapp.util.Log;
import java.io.EOFException;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class a
{
  public final c a = new c();
  private b b;
  private a c;
  private long d;
  private long e;
  private long f;
  private long g;
  private File h;
  private File i;
  private b j;
  private boolean k = false;
  private String l;
  private boolean m = true;
  private final List<c> n = new CopyOnWriteArrayList();
  
  public final void a(long paramLong)
  {
    try
    {
      this.g = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void a(a parama)
  {
    try
    {
      if (this.c != parama)
      {
        this.c = parama;
        Iterator localIterator = this.n.iterator();
        while (localIterator.hasNext()) {
          ((c)localIterator.next()).a(parama);
        }
      }
    }
    finally {}
  }
  
  public final void a(b paramb)
  {
    try
    {
      if (this.b != paramb)
      {
        this.b = paramb;
        paramb = this.n.iterator();
        while (paramb.hasNext()) {
          ((c)paramb.next()).a(this);
        }
      }
    }
    finally {}
  }
  
  public final void a(c paramc)
  {
    try
    {
      this.n.add(paramc);
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public final void a(File paramFile)
  {
    try
    {
      this.h = paramFile;
      paramFile = this.n.iterator();
      while (paramFile.hasNext()) {
        ((c)paramFile.next()).x_();
      }
    }
    finally {}
  }
  
  public final void a(File paramFile, b paramb)
  {
    try
    {
      this.i = paramFile;
      this.d = paramb.a;
      this.j = paramb;
      return;
    }
    finally
    {
      paramFile = finally;
      throw paramFile;
    }
  }
  
  public final void a(boolean paramBoolean, String paramString)
  {
    try
    {
      this.k = paramBoolean;
      this.l = paramString;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final boolean a()
  {
    try
    {
      boolean bool = this.m;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void b()
  {
    try
    {
      this.m = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void b(long paramLong)
  {
    try
    {
      this.f = paramLong;
      Iterator localIterator = this.n.iterator();
      while (localIterator.hasNext()) {
        ((c)localIterator.next()).b(this);
      }
    }
    finally {}
  }
  
  public final void b(c paramc)
  {
    try
    {
      this.n.remove(paramc);
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public final void c()
  {
    try
    {
      if (this.i != null)
      {
        if (!this.i.delete()) {
          Log.w("DownloadContext/unable to delete chunkstore file");
        }
        this.i = null;
      }
      return;
    }
    finally {}
  }
  
  public final void c(long paramLong)
  {
    try
    {
      this.e = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final b d()
  {
    try
    {
      b localb = this.b;
      return localb;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean d(long paramLong)
  {
    for (;;)
    {
      try
      {
        b localb1 = this.b;
        b localb2 = b.c;
        if (localb1 == localb2)
        {
          bool = true;
          return bool;
        }
        if (this.j == null)
        {
          bool = false;
          continue;
        }
        if (paramLong > i()) {
          throw new EOFException();
        }
      }
      finally {}
      int i1 = this.j.d(paramLong);
      boolean bool = this.j.a(i1);
    }
  }
  
  public final long e(long paramLong)
  {
    for (;;)
    {
      try
      {
        if (this.b == b.c)
        {
          l1 = this.e;
          paramLong = l1 - paramLong;
          return paramLong;
        }
        if (!d(paramLong))
        {
          paramLong = 0L;
          continue;
        }
        if (paramLong > i()) {
          throw new EOFException();
        }
      }
      finally {}
      long l1 = this.j.b(paramLong);
      if (l1 == -1L)
      {
        l1 = i();
        paramLong = l1 - paramLong;
      }
      else
      {
        paramLong = l1 - paramLong;
      }
    }
  }
  
  public final a e()
  {
    try
    {
      a locala = this.c;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final boolean f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 80	com/whatsapp/m/a:b	Lcom/whatsapp/m/a$b;
    //   6: astore_2
    //   7: getstatic 156	com/whatsapp/m/a$b:d	Lcom/whatsapp/m/a$b;
    //   10: astore_3
    //   11: aload_2
    //   12: aload_3
    //   13: if_acmpne +9 -> 22
    //   16: iconst_1
    //   17: istore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: iconst_0
    //   23: istore_1
    //   24: goto -6 -> 18
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	a
    //   17	7	1	bool	boolean
    //   6	6	2	localb1	b
    //   27	4	2	localObject	Object
    //   10	3	3	localb2	b
    // Exception table:
    //   from	to	target	type
    //   2	11	27	finally
  }
  
  public final File g()
  {
    try
    {
      File localFile = this.h;
      return localFile;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long h()
  {
    try
    {
      long l1 = this.g;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final long i()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 130	com/whatsapp/m/a:e	J
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne +12 -> 20
    //   11: aload_0
    //   12: getfield 103	com/whatsapp/m/a:d	J
    //   15: lstore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: lload_1
    //   19: lreturn
    //   20: aload_0
    //   21: getfield 130	com/whatsapp/m/a:e	J
    //   24: lstore_1
    //   25: goto -9 -> 16
    //   28: astore_3
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_3
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	a
    //   15	10	1	l1	long
    //   28	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	28	finally
    //   20	25	28	finally
  }
  
  /* Error */
  public final long j()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 103	com/whatsapp/m/a:d	J
    //   8: lstore_3
    //   9: lload_3
    //   10: lconst_0
    //   11: lcmp
    //   12: ifne +7 -> 19
    //   15: aload_0
    //   16: monitorexit
    //   17: lload_1
    //   18: lreturn
    //   19: aload_0
    //   20: getfield 110	com/whatsapp/m/a:f	J
    //   23: ldc2_w 158
    //   26: lmul
    //   27: aload_0
    //   28: getfield 103	com/whatsapp/m/a:d	J
    //   31: ldiv
    //   32: lstore_1
    //   33: goto -18 -> 15
    //   36: astore 5
    //   38: aload_0
    //   39: monitorexit
    //   40: aload 5
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	a
    //   1	32	1	l1	long
    //   8	2	3	l2	long
    //   36	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	36	finally
    //   19	33	36	finally
  }
  
  public final long k()
  {
    try
    {
      long l1 = this.f;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean l()
  {
    try
    {
      boolean bool = this.k;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final String m()
  {
    try
    {
      String str = this.l;
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void n()
  {
    try
    {
      this.n.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static enum b
  {
    private b() {}
  }
  
  public static abstract interface c
  {
    public abstract void a(a.a parama);
    
    public abstract void a(a parama);
    
    public abstract void b(a parama);
    
    public abstract void x_();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/m/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */