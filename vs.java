package com.whatsapp;

import com.whatsapp.messaging.ag;
import com.whatsapp.messaging.w;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class vs
{
  private static volatile vs a;
  private final w b;
  private final ag c;
  private final Map<String, a> d = new HashMap();
  
  private vs(w paramw, ag paramag)
  {
    this.b = paramw;
    this.c = paramag;
  }
  
  public static vs a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new vs(w.a(), ag.a());
      }
      return a;
    }
    finally {}
  }
  
  final a a(String paramString)
  {
    try
    {
      a locala2 = (a)this.d.get(paramString);
      a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new a((byte)0);
        this.d.put(paramString, locala1);
      }
      return locala1;
    }
    finally {}
  }
  
  public final void a(j paramj)
  {
    a(paramj.e.a).c(paramj);
  }
  
  public final void b()
  {
    try
    {
      this.d.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final class a
  {
    private final LinkedHashMap<j.b, j> b = new LinkedHashMap();
    private final HashSet<j.b> c = new HashSet();
    
    private a() {}
    
    private void a()
    {
      try
      {
        Iterator localIterator = this.b.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (!this.c.contains(localEntry.getKey())) {
            break;
          }
          j localj = (j)localEntry.getValue();
          localIterator.remove();
          this.c.remove(localEntry.getKey());
          vs.a(vs.this).a(localj, false, 0L);
          bu.a(vu.a(this, localj));
          Log.d("media-message-send-queue/send " + localj.e);
        }
      }
      finally {}
    }
    
    final void a(j paramj)
    {
      try
      {
        if (aic.ah)
        {
          this.b.put(paramj.e, paramj);
          Log.d("media-message-send-queue/add " + paramj.e + " " + toString());
        }
        return;
      }
      finally
      {
        paramj = finally;
        throw paramj;
      }
    }
    
    /* Error */
    final void b(j paramj)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 26	com/whatsapp/vs$a:b	Ljava/util/LinkedHashMap;
      //   6: aload_1
      //   7: getfield 103	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
      //   10: invokevirtual 138	java/util/LinkedHashMap:containsKey	(Ljava/lang/Object;)Z
      //   13: ifne +61 -> 74
      //   16: new 94	java/lang/StringBuilder
      //   19: dup
      //   20: ldc -116
      //   22: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   25: aload_1
      //   26: getfield 103	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
      //   29: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   32: ldc -125
      //   34: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   37: aload_0
      //   38: invokevirtual 135	com/whatsapp/vs$a:toString	()Ljava/lang/String;
      //   41: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   44: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   47: invokestatic 116	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
      //   50: aload_0
      //   51: getfield 18	com/whatsapp/vs$a:a	Lcom/whatsapp/vs;
      //   54: invokestatic 77	com/whatsapp/vs:a	(Lcom/whatsapp/vs;)Lcom/whatsapp/messaging/w;
      //   57: aload_1
      //   58: iconst_0
      //   59: lconst_0
      //   60: invokevirtual 82	com/whatsapp/messaging/w:a	(Lcom/whatsapp/protocol/j;ZJ)V
      //   63: aload_0
      //   64: aload_1
      //   65: invokestatic 143	com/whatsapp/vt:a	(Lcom/whatsapp/vs$a;Lcom/whatsapp/protocol/j;)Ljava/lang/Runnable;
      //   68: invokestatic 92	com/whatsapp/util/bu:a	(Ljava/lang/Runnable;)V
      //   71: aload_0
      //   72: monitorexit
      //   73: return
      //   74: new 94	java/lang/StringBuilder
      //   77: dup
      //   78: ldc -111
      //   80: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   83: aload_1
      //   84: getfield 103	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
      //   87: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   90: ldc -125
      //   92: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   95: aload_0
      //   96: invokevirtual 135	com/whatsapp/vs$a:toString	()Ljava/lang/String;
      //   99: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   102: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   105: invokestatic 116	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
      //   108: aload_0
      //   109: getfield 31	com/whatsapp/vs$a:c	Ljava/util/HashSet;
      //   112: aload_1
      //   113: getfield 103	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
      //   116: invokevirtual 148	java/util/HashSet:add	(Ljava/lang/Object;)Z
      //   119: pop
      //   120: aload_0
      //   121: invokespecial 150	com/whatsapp/vs$a:a	()V
      //   124: goto -53 -> 71
      //   127: astore_1
      //   128: aload_0
      //   129: monitorexit
      //   130: aload_1
      //   131: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	132	0	this	a
      //   0	132	1	paramj	j
      // Exception table:
      //   from	to	target	type
      //   2	71	127	finally
      //   74	124	127	finally
    }
    
    /* Error */
    final void c(j paramj)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 26	com/whatsapp/vs$a:b	Ljava/util/LinkedHashMap;
      //   6: aload_1
      //   7: getfield 103	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
      //   10: invokevirtual 153	java/util/LinkedHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   13: ifnull +80 -> 93
      //   16: iconst_1
      //   17: istore_2
      //   18: aload_0
      //   19: getfield 31	com/whatsapp/vs$a:c	Ljava/util/HashSet;
      //   22: aload_1
      //   23: getfield 103	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
      //   26: invokevirtual 74	java/util/HashSet:remove	(Ljava/lang/Object;)Z
      //   29: istore_3
      //   30: new 94	java/lang/StringBuilder
      //   33: dup
      //   34: ldc -101
      //   36: invokespecial 99	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   39: aload_1
      //   40: getfield 103	com/whatsapp/protocol/j:e	Lcom/whatsapp/protocol/j$b;
      //   43: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   46: ldc -125
      //   48: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   51: aload_0
      //   52: invokevirtual 135	com/whatsapp/vs$a:toString	()Ljava/lang/String;
      //   55: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   58: ldc -99
      //   60: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   63: iload_2
      //   64: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   67: ldc -94
      //   69: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   72: iload_3
      //   73: invokevirtual 160	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   76: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   79: invokestatic 116	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
      //   82: iload_2
      //   83: ifeq +7 -> 90
      //   86: aload_0
      //   87: invokespecial 150	com/whatsapp/vs$a:a	()V
      //   90: aload_0
      //   91: monitorexit
      //   92: return
      //   93: iconst_0
      //   94: istore_2
      //   95: goto -77 -> 18
      //   98: astore_1
      //   99: aload_0
      //   100: monitorexit
      //   101: aload_1
      //   102: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	103	0	this	a
      //   0	103	1	paramj	j
      //   17	78	2	bool1	boolean
      //   29	44	3	bool2	boolean
      // Exception table:
      //   from	to	target	type
      //   2	16	98	finally
      //   18	82	98	finally
      //   86	90	98	finally
    }
    
    public final String toString()
    {
      try
      {
        String str = "[pending:" + this.b.size() + " ready:" + this.c.size() + "]";
        return str;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/vs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */