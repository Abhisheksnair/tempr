package com.whatsapp.protocol;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import com.whatsapp.MediaData;
import com.whatsapp.data.cq;
import java.util.Iterator;
import java.util.List;

public final class l
{
  public final j a;
  boolean b;
  public Float c;
  private byte[] d;
  private boolean e;
  
  l(j paramj)
  {
    if (!a(paramj.s)) {
      throw new IllegalStateException("this message should not have a thumbnail");
    }
    this.a = paramj;
  }
  
  public static void a(List<l> paramList, byte[] paramArrayOfByte)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((l)paramList.next()).a(paramArrayOfByte);
    }
  }
  
  public static boolean a(byte paramByte)
  {
    return (paramByte == 1) || (paramByte == 3) || (paramByte == 13) || (paramByte == 9) || (paramByte == 5) || (paramByte == 16);
  }
  
  public static float b(byte[] paramArrayOfByte)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    if ((localOptions.outWidth > 0) && (localOptions.outHeight > 0)) {
      return localOptions.outHeight / localOptions.outWidth;
    }
    return -1.0F;
  }
  
  /* Error */
  private boolean c(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 83	com/whatsapp/protocol/l:b	Z
    //   8: ifne +17 -> 25
    //   11: aload_0
    //   12: aload_1
    //   13: putfield 85	com/whatsapp/protocol/l:d	[B
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield 83	com/whatsapp/protocol/l:b	Z
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_2
    //   24: ireturn
    //   25: iconst_0
    //   26: istore_2
    //   27: goto -6 -> 21
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	l
    //   0	35	1	paramArrayOfByte	byte[]
    //   1	26	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	21	30	finally
  }
  
  public final void a(cq paramcq)
  {
    Object localObject;
    if (!this.b)
    {
      if (this.a.m == 0)
      {
        localObject = this.a.e();
        if ((localObject != null) && (((String)localObject).length() > 0)) {
          c(Base64.decode(this.a.e(), 0));
        }
      }
    }
    else {
      return;
    }
    if (this.a.m == 1)
    {
      localObject = this.a.h();
      if ((localObject != null) && (localObject.length > 0))
      {
        c((byte[])localObject);
        return;
      }
    }
    c(paramcq.a(this.a.e));
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    try
    {
      a(paramArrayOfByte, false);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public final void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        MediaData localMediaData = this.a.b();
        if (paramBoolean)
        {
          this.a.a(paramArrayOfByte);
          localMediaData.thumbnailHeightWidthRatio = -1.0F;
          this.c = null;
          this.b = true;
          this.d = paramArrayOfByte;
          return;
        }
        if (paramArrayOfByte != null)
        {
          localMediaData.thumbnailHeightWidthRatio = b(paramArrayOfByte);
          this.a.a(null);
          this.e = true;
        }
        else
        {
          localMediaData.thumbnailHeightWidthRatio = -1.0F;
        }
      }
      finally {}
    }
  }
  
  public final boolean a()
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
  
  public final byte[] b()
  {
    try
    {
      if (!this.b) {
        throw new IllegalStateException("thumbnail not loaded, key=" + this.a.e);
      }
    }
    finally {}
    byte[] arrayOfByte = this.d;
    return arrayOfByte;
  }
  
  /* Error */
  public final boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/whatsapp/protocol/l:a	Lcom/whatsapp/protocol/j;
    //   6: invokevirtual 124	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   9: getfield 131	com/whatsapp/MediaData:thumbnailHeightWidthRatio	F
    //   12: fstore_1
    //   13: fload_1
    //   14: fconst_0
    //   15: fcmpl
    //   16: ifle +9 -> 25
    //   19: iconst_1
    //   20: istore_2
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_2
    //   24: ireturn
    //   25: iconst_0
    //   26: istore_2
    //   27: goto -6 -> 21
    //   30: astore_3
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_3
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	l
    //   12	2	1	f	float
    //   20	7	2	bool	boolean
    //   30	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	30	finally
  }
  
  /* Error */
  public final boolean d()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 36	com/whatsapp/protocol/l:a	Lcom/whatsapp/protocol/j;
    //   9: getfield 89	com/whatsapp/protocol/j:m	I
    //   12: ifne +35 -> 47
    //   15: aload_0
    //   16: getfield 36	com/whatsapp/protocol/l:a	Lcom/whatsapp/protocol/j;
    //   19: invokevirtual 92	com/whatsapp/protocol/j:e	()Ljava/lang/String;
    //   22: ifnull +25 -> 47
    //   25: aload_0
    //   26: getfield 36	com/whatsapp/protocol/l:a	Lcom/whatsapp/protocol/j;
    //   29: invokevirtual 92	com/whatsapp/protocol/j:e	()Ljava/lang/String;
    //   32: invokevirtual 98	java/lang/String:length	()I
    //   35: istore_2
    //   36: iload_2
    //   37: ifle +10 -> 47
    //   40: iload 4
    //   42: istore_3
    //   43: aload_0
    //   44: monitorexit
    //   45: iload_3
    //   46: ireturn
    //   47: aload_0
    //   48: getfield 36	com/whatsapp/protocol/l:a	Lcom/whatsapp/protocol/j;
    //   51: invokevirtual 110	com/whatsapp/protocol/j:h	()[B
    //   54: ifnull +17 -> 71
    //   57: iload 4
    //   59: istore_3
    //   60: aload_0
    //   61: getfield 36	com/whatsapp/protocol/l:a	Lcom/whatsapp/protocol/j;
    //   64: invokevirtual 110	com/whatsapp/protocol/j:h	()[B
    //   67: arraylength
    //   68: ifgt -25 -> 43
    //   71: aload_0
    //   72: getfield 36	com/whatsapp/protocol/l:a	Lcom/whatsapp/protocol/j;
    //   75: invokevirtual 124	com/whatsapp/protocol/j:b	()Lcom/whatsapp/MediaData;
    //   78: getfield 131	com/whatsapp/MediaData:thumbnailHeightWidthRatio	F
    //   81: fstore_1
    //   82: iload 4
    //   84: istore_3
    //   85: fload_1
    //   86: fconst_0
    //   87: fcmpl
    //   88: ifgt -45 -> 43
    //   91: iconst_0
    //   92: istore_3
    //   93: goto -50 -> 43
    //   96: astore 5
    //   98: aload_0
    //   99: monitorexit
    //   100: aload 5
    //   102: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	this	l
    //   81	5	1	f	float
    //   35	2	2	i	int
    //   42	51	3	bool1	boolean
    //   1	82	4	bool2	boolean
    //   96	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	36	96	finally
    //   47	57	96	finally
    //   60	71	96	finally
    //   71	82	96	finally
  }
  
  public final boolean e()
  {
    try
    {
      boolean bool = this.e;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void f()
  {
    try
    {
      this.e = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */