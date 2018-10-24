package com.whatsapp;

import android.app.Activity;
import android.os.Message;
import b.a.a.c;
import com.whatsapp.g.e;
import com.whatsapp.messaging.m;
import com.whatsapp.protocol.aw;
import com.whatsapp.util.bu;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class aq
{
  private static volatile aq a;
  private long b = -1L;
  private final Hashtable<String, String> c = new Hashtable();
  private final pv d;
  private final m e;
  private final dh f;
  private final aat g;
  
  private aq(pv parampv, m paramm, dh paramdh, aat paramaat)
  {
    this.d = parampv;
    this.e = paramm;
    this.f = paramdh;
    this.g = paramaat;
  }
  
  public static aq a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aq(pv.a(), m.a(), dh.a(), aat.a());
      }
      return a;
    }
    finally {}
  }
  
  public final void a(Activity paramActivity, boolean paramBoolean, String paramString, aw paramaw)
  {
    Map localMap;
    if ((this.e.d) && (d()))
    {
      localMap = e();
      if (!paramBoolean) {
        break label75;
      }
      localMap.put(paramString, paramString);
    }
    for (;;)
    {
      this.e.a(Message.obtain(null, 0, 2, 0, new as(paramActivity, this.d, this, this.f, paramString, localMap, paramBoolean, paramaw)));
      return;
      label75:
      localMap.remove(paramString);
    }
  }
  
  public final boolean a(Activity paramActivity, boolean paramBoolean, String paramString)
  {
    if (!this.g.b())
    {
      int i;
      if (aat.a(paramActivity)) {
        if (paramBoolean) {
          i = 2131297296;
        }
      }
      for (;;)
      {
        pv.a(paramActivity, i, 0);
        return false;
        i = 2131297299;
        continue;
        if (paramBoolean) {
          i = 2131297295;
        } else {
          i = 2131297298;
        }
      }
    }
    this.d.c((ng)paramActivity);
    bu.a(ar.a(this, paramActivity, paramBoolean, paramString));
    return true;
  }
  
  public final boolean a(String paramString)
  {
    try
    {
      boolean bool = this.c.contains(paramString);
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void b(Activity paramActivity, boolean paramBoolean, String paramString)
  {
    a(paramActivity, paramBoolean, paramString, null);
  }
  
  public final void b(String paramString)
  {
    try
    {
      this.c.put(paramString, paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	com/whatsapp/aq:b	J
    //   6: ldc2_w 25
    //   9: lcmp
    //   10: ifeq +22 -> 32
    //   13: invokestatic 145	java/lang/System:currentTimeMillis	()J
    //   16: lstore_1
    //   17: aload_0
    //   18: getfield 28	com/whatsapp/aq:b	J
    //   21: lstore_3
    //   22: lload_1
    //   23: lload_3
    //   24: lsub
    //   25: ldc2_w 146
    //   28: lcmp
    //   29: iflt +11 -> 40
    //   32: iconst_1
    //   33: istore 5
    //   35: aload_0
    //   36: monitorexit
    //   37: iload 5
    //   39: ireturn
    //   40: iconst_0
    //   41: istore 5
    //   43: goto -8 -> 35
    //   46: astore 6
    //   48: aload_0
    //   49: monitorexit
    //   50: aload 6
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	aq
    //   16	7	1	l1	long
    //   21	3	3	l2	long
    //   33	9	5	bool	boolean
    //   46	5	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	22	46	finally
  }
  
  public final void c()
  {
    try
    {
      this.b = -1L;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void c(String paramString)
  {
    try
    {
      this.c.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void d(String paramString)
  {
    try
    {
      this.c.put(paramString, paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public final boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 28	com/whatsapp/aq:b	J
    //   6: lstore_1
    //   7: lload_1
    //   8: ldc2_w 25
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
    //   0	33	0	this	aq
    //   6	2	1	l	long
    //   16	7	3	bool	boolean
    //   26	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	26	finally
  }
  
  public final Map<String, String> e()
  {
    try
    {
      HashMap localHashMap = new HashMap(this.c);
      return localHashMap;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int f()
  {
    try
    {
      int i = this.c.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void g()
  {
    try
    {
      this.c.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void h()
  {
    try
    {
      if (!this.c.isEmpty()) {
        this.f.a(this.c.values());
      }
      this.b = System.currentTimeMillis();
      c.a().b(new e());
      return;
    }
    finally {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */