package com.whatsapp.protocol;

import com.whatsapp.MediaData;
import com.whatsapp.util.Log;

public final class k
{
  final j a;
  boolean b;
  byte[] c;
  boolean d;
  
  public k(j paramj)
  {
    if (!a(paramj.s)) {
      throw new IllegalStateException("this message should not have a sidecar");
    }
    this.a = paramj;
  }
  
  public static boolean a(byte paramByte)
  {
    return paramByte == 3;
  }
  
  /* Error */
  private void c(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +32 -> 35
    //   6: aload_1
    //   7: arraylength
    //   8: ifle +27 -> 35
    //   11: aload_0
    //   12: getfield 34	com/whatsapp/protocol/k:a	Lcom/whatsapp/protocol/j;
    //   15: invokevirtual 39	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   18: iconst_1
    //   19: putfield 44	com/whatsapp/MediaData:hasStreamingSidecar	Z
    //   22: aload_0
    //   23: aload_1
    //   24: putfield 46	com/whatsapp/protocol/k:c	[B
    //   27: aload_0
    //   28: iconst_1
    //   29: putfield 48	com/whatsapp/protocol/k:b	Z
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: aload_0
    //   36: getfield 34	com/whatsapp/protocol/k:a	Lcom/whatsapp/protocol/j;
    //   39: invokevirtual 39	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   42: iconst_0
    //   43: putfield 44	com/whatsapp/MediaData:hasStreamingSidecar	Z
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 46	com/whatsapp/protocol/k:c	[B
    //   51: goto -24 -> 27
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	k
    //   0	59	1	paramArrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   6	27	54	finally
    //   27	32	54	finally
    //   35	51	54	finally
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    try
    {
      c(paramArrayOfByte);
      this.d = true;
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public final byte[] a()
  {
    try
    {
      if (!this.b) {
        Log.d("sidecar not loaded", new Throwable());
      }
      byte[] arrayOfByte = this.c;
      return arrayOfByte;
    }
    finally {}
  }
  
  public final void b(byte[] paramArrayOfByte)
  {
    try
    {
      if (!this.b) {
        c(paramArrayOfByte);
      }
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public final boolean b()
  {
    return this.a.b().hasStreamingSidecar;
  }
  
  public final boolean c()
  {
    try
    {
      boolean bool = this.b;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean d()
  {
    try
    {
      boolean bool = this.d;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void e()
  {
    try
    {
      this.d = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */