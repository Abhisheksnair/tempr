package com.whatsapp.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public final class w
{
  private static final w d = new w();
  public final a<String> a = new a();
  public final a<String> b = new a();
  public final a<String> c = new a();
  
  public static w a()
  {
    return d;
  }
  
  public final void a(String paramString)
  {
    this.b.b(paramString);
    this.c.b(paramString);
  }
  
  public final Long b(String paramString)
  {
    return this.b.b(paramString);
  }
  
  public final Long c(String paramString)
  {
    return this.c.b(paramString);
  }
  
  public static final class a<E>
  {
    private final HashMap<E, Long> a = new HashMap();
    private final long b = 60000L;
    
    public final void a()
    {
      try
      {
        this.a.clear();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    /* Error */
    public final boolean a(E paramE)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 21	com/whatsapp/util/w$a:a	Ljava/util/HashMap;
      //   6: aload_1
      //   7: invokevirtual 34	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   10: checkcast 36	java/lang/Long
      //   13: astore 9
      //   15: aload 9
      //   17: ifnull +38 -> 55
      //   20: aload 9
      //   22: invokevirtual 40	java/lang/Long:longValue	()J
      //   25: lstore_2
      //   26: aload_0
      //   27: getfield 25	com/whatsapp/util/w$a:b	J
      //   30: lstore 4
      //   32: invokestatic 45	android/os/SystemClock:elapsedRealtime	()J
      //   35: lstore 6
      //   37: lload_2
      //   38: lload 4
      //   40: ladd
      //   41: lload 6
      //   43: lcmp
      //   44: ifle +11 -> 55
      //   47: iconst_0
      //   48: istore 8
      //   50: aload_0
      //   51: monitorexit
      //   52: iload 8
      //   54: ireturn
      //   55: aload_0
      //   56: getfield 21	com/whatsapp/util/w$a:a	Ljava/util/HashMap;
      //   59: aload_1
      //   60: invokestatic 45	android/os/SystemClock:elapsedRealtime	()J
      //   63: invokestatic 49	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   66: invokevirtual 53	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   69: pop
      //   70: iconst_1
      //   71: istore 8
      //   73: goto -23 -> 50
      //   76: astore_1
      //   77: aload_0
      //   78: monitorexit
      //   79: aload_1
      //   80: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	81	0	this	a
      //   0	81	1	paramE	E
      //   25	13	2	l1	long
      //   30	9	4	l2	long
      //   35	7	6	l3	long
      //   48	24	8	bool	boolean
      //   13	8	9	localLong	Long
      // Exception table:
      //   from	to	target	type
      //   2	15	76	finally
      //   20	37	76	finally
      //   55	70	76	finally
    }
    
    public final Long b(E paramE)
    {
      try
      {
        Long localLong = (Long)this.a.remove(paramE);
        paramE = localLong;
        if (localLong == null) {
          paramE = null;
        }
        return paramE;
      }
      finally
      {
        paramE = finally;
        throw paramE;
      }
    }
    
    public final Collection<Long> b()
    {
      try
      {
        ArrayList localArrayList = new ArrayList(this.a.values());
        return localArrayList;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public final boolean c()
    {
      try
      {
        boolean bool = this.a.isEmpty();
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */