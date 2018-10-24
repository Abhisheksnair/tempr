package com.whatsapp.emoji.search;

import android.os.AsyncTask;
import android.view.View;
import com.whatsapp.util.bu;

public final class q
{
  private static q d;
  public a a;
  public boolean b;
  boolean c;
  private final a e;
  
  private q(a parama)
  {
    this.e = parama;
    this.b = false;
  }
  
  public static q a()
  {
    try
    {
      if (d == null) {
        d = new q(a.a());
      }
      q localq = d;
      return localq;
    }
    finally {}
  }
  
  public final s a(String paramString)
  {
    for (;;)
    {
      a locala;
      try
      {
        s locals = new s();
        boolean bool = this.b;
        if (!bool) {
          return locals;
        }
        locala = this.e;
        localObject = new a.d(locals);
        a.a.a.a.a.a.d.b();
        if (locala.b != null) {
          locala.b.cancel(true);
        }
        if ((locala.a == null) || (!locala.a.f)) {
          throw new IllegalStateException("emoji dictionary is not prepared yet, state=" + locala.a);
        }
      }
      finally {}
      Object localObject = new a.2(locala, (a.d)localObject);
      locala.b = ((AsyncTask)localObject);
      bu.a((AsyncTask)localObject, new String[] { paramString });
    }
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 97	com/whatsapp/emoji/search/q:c	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 97	com/whatsapp/emoji/search/q:c	Z
    //   19: aload_0
    //   20: getfield 22	com/whatsapp/emoji/search/q:e	Lcom/whatsapp/emoji/search/a;
    //   23: astore_2
    //   24: new 99	com/whatsapp/emoji/search/a$a
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 102	com/whatsapp/emoji/search/a$a:<init>	(Lcom/whatsapp/emoji/search/q;)V
    //   32: astore_3
    //   33: invokestatic 48	a/a/a/a/a/a$d:b	()V
    //   36: ldc 104
    //   38: invokestatic 108	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   41: new 110	com/whatsapp/emoji/search/a$1
    //   44: dup
    //   45: aload_2
    //   46: aload_3
    //   47: invokespecial 113	com/whatsapp/emoji/search/a$1:<init>	(Lcom/whatsapp/emoji/search/a;Lcom/whatsapp/emoji/search/a$a;)V
    //   50: iconst_0
    //   51: anewarray 90	java/lang/String
    //   54: invokestatic 95	com/whatsapp/util/bu:a	(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   57: pop
    //   58: goto -47 -> 11
    //   61: astore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	q
    //   6	2	1	bool	boolean
    //   23	23	2	locala	a
    //   61	4	2	localObject	Object
    //   32	15	3	locala1	a.a
    // Exception table:
    //   from	to	target	type
    //   2	7	61	finally
    //   14	58	61	finally
  }
  
  public static final class a
  {
    public final View a;
    
    public a(View paramView)
    {
      this.a = paramView;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/emoji/search/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */