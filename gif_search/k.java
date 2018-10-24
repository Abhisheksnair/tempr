package com.whatsapp.gif_search;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.a;
import android.view.LayoutInflater;
import com.whatsapp.and;
import com.whatsapp.pv;
import java.util.List;

public class k
  extends RecyclerView.a<l>
  implements r.a
{
  private final LayoutInflater c;
  r d;
  private final f.a f;
  private final int g;
  private final boolean h;
  private final pv i;
  private final and j;
  
  static
  {
    if (!k.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      e = bool;
      return;
    }
  }
  
  public k(Activity paramActivity, pv parampv, and paramand, f.a parama, int paramInt, boolean paramBoolean)
  {
    this.c = paramActivity.getLayoutInflater();
    this.i = parampv;
    this.j = paramand;
    this.f = parama;
    this.g = paramInt;
    this.h = paramBoolean;
  }
  
  private void a(l paraml, int paramInt)
  {
    boolean bool = false;
    try
    {
      if ((!e) && (this.d == null)) {
        throw new AssertionError();
      }
    }
    finally {}
    Object localObject;
    int k;
    if (paramInt < this.d.a())
    {
      localObject = this.d;
      if (paramInt + 1 >= ((r)localObject).a() * 0.75D)
      {
        k = 1;
        if ((k != 0) && (!((r)localObject).c)) {
          if ((((r)localObject).d) || (((r)localObject).a(((r)localObject).b))) {
            break label147;
          }
        }
      }
    }
    for (;;)
    {
      ((r)localObject).c = bool;
      for (localObject = (j)((r)localObject).a.get(paramInt);; localObject = null)
      {
        paraml.t = ((j)localObject);
        return;
        k = 0;
        break;
      }
      label147:
      bool = true;
    }
  }
  
  /* Error */
  public final int a()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_1
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 59	com/whatsapp/gif_search/k:d	Lcom/whatsapp/gif_search/r;
    //   10: astore 4
    //   12: aload 4
    //   14: ifnonnull +7 -> 21
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: aload_0
    //   22: getfield 59	com/whatsapp/gif_search/k:d	Lcom/whatsapp/gif_search/r;
    //   25: invokevirtual 67	com/whatsapp/gif_search/r:a	()I
    //   28: istore_3
    //   29: aload_0
    //   30: getfield 59	com/whatsapp/gif_search/k:d	Lcom/whatsapp/gif_search/r;
    //   33: getfield 77	com/whatsapp/gif_search/r:b	Ljava/lang/String;
    //   36: astore 4
    //   38: aload 4
    //   40: ifnull +18 -> 58
    //   43: iconst_1
    //   44: istore_1
    //   45: iload_1
    //   46: ifeq +17 -> 63
    //   49: iload_2
    //   50: istore_1
    //   51: iload_3
    //   52: iload_1
    //   53: iadd
    //   54: istore_1
    //   55: goto -38 -> 17
    //   58: iconst_0
    //   59: istore_1
    //   60: goto -15 -> 45
    //   63: iconst_0
    //   64: istore_1
    //   65: goto -14 -> 51
    //   68: astore 4
    //   70: aload_0
    //   71: monitorexit
    //   72: aload 4
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	k
    //   3	62	1	k	int
    //   1	49	2	m	int
    //   28	26	3	n	int
    //   10	29	4	localObject1	Object
    //   68	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   6	12	68	finally
    //   21	38	68	finally
  }
  
  public void a(r paramr)
  {
    if (paramr.equals(this.d)) {
      c();
    }
  }
  
  public final void b(r paramr)
  {
    try
    {
      if (this.d != null) {
        this.d.a(null);
      }
      this.d = paramr;
      if (paramr != null) {
        this.d.a(this);
      }
      c();
      return;
    }
    finally {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gif_search/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */