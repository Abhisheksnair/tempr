package com.whatsapp.m;

import android.os.Handler;
import android.os.Looper;

public final class c
{
  public final Handler a = new Handler(Looper.getMainLooper());
  public a b;
  private long c = -1L;
  
  final void a(long paramLong)
  {
    try
    {
      this.c = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	com/whatsapp/m/c:c	J
    //   6: lstore_1
    //   7: lload_1
    //   8: ldc2_w 17
    //   11: lcmp
    //   12: ifeq +9 -> 21
    //   15: iconst_1
    //   16: istore_3
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_3
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_3
    //   23: goto -6 -> 17
    //   26: astore 4
    //   28: aload_0
    //   29: monitorexit
    //   30: aload 4
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	c
    //   6	2	1	l	long
    //   16	7	3	bool	boolean
    //   26	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
  }
  
  public final long b()
  {
    try
    {
      if (this.c == -1L) {
        throw new IllegalStateException("error in getting request");
      }
    }
    finally {}
    long l = this.c;
    this.c = -1L;
    return l;
  }
  
  public final class a
    implements Runnable
  {
    private final long b;
    
    public a(long paramLong)
    {
      this.b = paramLong;
    }
    
    public final void run()
    {
      c.this.a(this.b);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/m/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */