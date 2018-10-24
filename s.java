package com.whatsapp;

import android.database.ContentObserver;
import com.whatsapp.contact.sync.i;

public final class s
  extends ContentObserver
{
  private final va a;
  private final pc b;
  private final i c;
  
  public s(va paramva, pc parampc, i parami)
  {
    super(null);
    this.a = paramva;
    this.b = parampc;
    this.c = parami;
  }
  
  /* Error */
  private void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 19	com/whatsapp/s:b	Lcom/whatsapp/pc;
    //   6: invokevirtual 29	com/whatsapp/pc:e	()Z
    //   9: ifeq +43 -> 52
    //   12: getstatic 34	com/whatsapp/contact/sync/w:c	Lcom/whatsapp/contact/sync/w;
    //   15: astore_1
    //   16: new 36	com/whatsapp/contact/sync/t$a
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 39	com/whatsapp/contact/sync/t$a:<init>	(Lcom/whatsapp/contact/sync/w;)V
    //   24: astore_1
    //   25: aload_1
    //   26: iconst_1
    //   27: putfield 42	com/whatsapp/contact/sync/t$a:c	Z
    //   30: aload_1
    //   31: iconst_1
    //   32: putfield 45	com/whatsapp/contact/sync/t$a:d	Z
    //   35: aload_1
    //   36: invokevirtual 48	com/whatsapp/contact/sync/t$a:a	()Lcom/whatsapp/contact/sync/t;
    //   39: astore_1
    //   40: aload_0
    //   41: getfield 21	com/whatsapp/s:c	Lcom/whatsapp/contact/sync/i;
    //   44: aload_1
    //   45: invokevirtual 53	com/whatsapp/contact/sync/i:b	(Lcom/whatsapp/contact/sync/t;)Lcom/whatsapp/util/n;
    //   48: pop
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: getstatic 55	com/whatsapp/contact/sync/w:e	Lcom/whatsapp/contact/sync/w;
    //   55: astore_1
    //   56: goto -40 -> 16
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	s
    //   15	41	1	localObject1	Object
    //   59	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	59	finally
    //   16	49	59	finally
    //   52	56	59	finally
  }
  
  public final void onChange(boolean paramBoolean)
  {
    if (this.a.b != null) {
      a();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */