package com.whatsapp.emoji.search;

import android.app.Activity;
import android.support.v7.widget.RecyclerView.a;
import android.view.LayoutInflater;
import com.whatsapp.emoji.a;
import com.whatsapp.pv;
import java.util.List;

public class b
  extends RecyclerView.a<c>
  implements s.a
{
  private final LayoutInflater d;
  private s e;
  private final i.a f;
  private final int g;
  private final pv h;
  
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      return;
    }
  }
  
  public b(Activity paramActivity, pv parampv, i.a parama, int paramInt)
  {
    this.d = paramActivity.getLayoutInflater();
    this.h = parampv;
    this.f = parama;
    this.g = paramInt;
  }
  
  private void a(c paramc, int paramInt)
  {
    try
    {
      if ((!c) && (this.e == null)) {
        throw new AssertionError();
      }
    }
    finally {}
    if (paramInt < this.e.a()) {}
    for (a locala = (a)this.e.a.get(paramInt);; locala = null)
    {
      paramc.q = locala;
      return;
    }
  }
  
  /* Error */
  public final int a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	com/whatsapp/emoji/search/b:e	Lcom/whatsapp/emoji/search/s;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +9 -> 17
    //   11: iconst_0
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 52	com/whatsapp/emoji/search/b:e	Lcom/whatsapp/emoji/search/s;
    //   21: invokevirtual 60	com/whatsapp/emoji/search/s:a	()I
    //   24: istore_1
    //   25: goto -12 -> 13
    //   28: astore_2
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	b
    //   12	13	1	i	int
    //   6	2	2	locals	s
    //   28	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	28	finally
    //   17	25	28	finally
  }
  
  public final void a(s params)
  {
    try
    {
      if (this.e != null) {
        this.e.a(null);
      }
      this.e = params;
      if (params != null) {
        this.e.a(this);
      }
      c();
      return;
    }
    finally {}
  }
  
  public void b(s params)
  {
    if (params.equals(this.e)) {
      c();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/emoji/search/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */