package com.whatsapp.gallerypicker;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import java.io.FileDescriptor;
import java.util.WeakHashMap;

public final class a
{
  private static a b = null;
  private final WeakHashMap<Thread, b> a = new WeakHashMap();
  
  public static a a()
  {
    try
    {
      if (b == null) {
        b = new a();
      }
      a locala = b;
      return locala;
    }
    finally {}
  }
  
  private void a(Thread paramThread, BitmapFactory.Options paramOptions)
  {
    try
    {
      b(paramThread).b = paramOptions;
      return;
    }
    finally
    {
      paramThread = finally;
      throw paramThread;
    }
  }
  
  private b b(Thread paramThread)
  {
    try
    {
      b localb2 = (b)this.a.get(paramThread);
      b localb1 = localb2;
      if (localb2 == null)
      {
        localb1 = new b((byte)0);
        this.a.put(paramThread, localb1);
      }
      return localb1;
    }
    finally {}
  }
  
  private void c(Thread paramThread)
  {
    try
    {
      ((b)this.a.get(paramThread)).b = null;
      return;
    }
    finally
    {
      paramThread = finally;
      throw paramThread;
    }
  }
  
  /* Error */
  private boolean d(Thread paramThread)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 26	com/whatsapp/gallerypicker/a:a	Ljava/util/WeakHashMap;
    //   6: aload_1
    //   7: invokevirtual 39	java/util/WeakHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 9	com/whatsapp/gallerypicker/a$b
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +17 -> 32
    //   18: aload_1
    //   19: getfield 53	com/whatsapp/gallerypicker/a$b:a	I
    //   22: istore_2
    //   23: getstatic 54	com/whatsapp/gallerypicker/a$a:a	I
    //   26: istore_3
    //   27: iload_2
    //   28: iload_3
    //   29: if_icmpeq +11 -> 40
    //   32: iconst_1
    //   33: istore 4
    //   35: aload_0
    //   36: monitorexit
    //   37: iload 4
    //   39: ireturn
    //   40: iconst_0
    //   41: istore 4
    //   43: goto -8 -> 35
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	a
    //   0	51	1	paramThread	Thread
    //   22	8	2	i	int
    //   26	4	3	j	int
    //   33	9	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	14	46	finally
    //   18	27	46	finally
  }
  
  /* Error */
  public final Bitmap a(android.content.ContentResolver paramContentResolver, long paramLong, int paramInt, BitmapFactory.Options paramOptions, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 61	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3: astore 8
    //   5: aload_0
    //   6: aload 8
    //   8: invokespecial 32	com/whatsapp/gallerypicker/a:b	(Ljava/lang/Thread;)Lcom/whatsapp/gallerypicker/a$b;
    //   11: astore 7
    //   13: aload_0
    //   14: aload 8
    //   16: invokespecial 63	com/whatsapp/gallerypicker/a:d	(Ljava/lang/Thread;)Z
    //   19: ifne +33 -> 52
    //   22: ldc 65
    //   24: new 67	java/lang/StringBuilder
    //   27: dup
    //   28: ldc 69
    //   30: invokespecial 72	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: aload 8
    //   35: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   38: ldc 78
    //   40: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 90	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   49: pop
    //   50: aconst_null
    //   51: areturn
    //   52: aload 7
    //   54: monitorenter
    //   55: aload 7
    //   57: iconst_1
    //   58: putfield 93	com/whatsapp/gallerypicker/a$b:c	Z
    //   61: aload 7
    //   63: monitorexit
    //   64: iload 6
    //   66: ifeq +69 -> 135
    //   69: aload_1
    //   70: lload_2
    //   71: aload 8
    //   73: invokevirtual 97	java/lang/Thread:getId	()J
    //   76: iload 4
    //   78: aload 5
    //   80: invokestatic 103	android/provider/MediaStore$Video$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JJILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   83: astore_1
    //   84: aload 7
    //   86: monitorenter
    //   87: aload 7
    //   89: iconst_0
    //   90: putfield 93	com/whatsapp/gallerypicker/a$b:c	Z
    //   93: aload 7
    //   95: invokevirtual 106	java/lang/Object:notifyAll	()V
    //   98: aload 7
    //   100: monitorexit
    //   101: aload_1
    //   102: areturn
    //   103: astore_1
    //   104: aload 7
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    //   109: astore_1
    //   110: aload 7
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    //   115: astore_1
    //   116: aload 7
    //   118: monitorenter
    //   119: aload 7
    //   121: iconst_0
    //   122: putfield 93	com/whatsapp/gallerypicker/a$b:c	Z
    //   125: aload 7
    //   127: invokevirtual 106	java/lang/Object:notifyAll	()V
    //   130: aload 7
    //   132: monitorexit
    //   133: aload_1
    //   134: athrow
    //   135: aload_1
    //   136: lload_2
    //   137: aload 8
    //   139: invokevirtual 97	java/lang/Thread:getId	()J
    //   142: iload 4
    //   144: aload 5
    //   146: invokestatic 109	android/provider/MediaStore$Images$Thumbnails:getThumbnail	(Landroid/content/ContentResolver;JJILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   149: astore_1
    //   150: aload 7
    //   152: monitorenter
    //   153: aload 7
    //   155: iconst_0
    //   156: putfield 93	com/whatsapp/gallerypicker/a$b:c	Z
    //   159: aload 7
    //   161: invokevirtual 106	java/lang/Object:notifyAll	()V
    //   164: aload 7
    //   166: monitorexit
    //   167: aload_1
    //   168: areturn
    //   169: astore_1
    //   170: aload 7
    //   172: monitorexit
    //   173: aload_1
    //   174: athrow
    //   175: astore_1
    //   176: aload 7
    //   178: monitorexit
    //   179: aload_1
    //   180: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	a
    //   0	181	1	paramContentResolver	android.content.ContentResolver
    //   0	181	2	paramLong	long
    //   0	181	4	paramInt	int
    //   0	181	5	paramOptions	BitmapFactory.Options
    //   0	181	6	paramBoolean	boolean
    //   11	166	7	localb	b
    //   3	135	8	localThread	Thread
    // Exception table:
    //   from	to	target	type
    //   87	101	103	finally
    //   104	107	103	finally
    //   55	64	109	finally
    //   110	113	109	finally
    //   52	55	115	finally
    //   69	84	115	finally
    //   113	115	115	finally
    //   135	150	115	finally
    //   153	167	169	finally
    //   170	173	169	finally
    //   119	133	175	finally
    //   176	179	175	finally
  }
  
  public final Bitmap a(FileDescriptor paramFileDescriptor, BitmapFactory.Options paramOptions)
  {
    if (paramOptions.mCancel) {
      return null;
    }
    Thread localThread = Thread.currentThread();
    if (!d(localThread))
    {
      Log.d("BitmapManager", "Thread " + localThread + " is not allowed to decode.");
      return null;
    }
    a(localThread, paramOptions);
    paramFileDescriptor = BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, paramOptions);
    c(localThread);
    return paramFileDescriptor;
  }
  
  public final void a(Thread paramThread)
  {
    try
    {
      b(paramThread).a = a.b;
      return;
    }
    finally
    {
      paramThread = finally;
      throw paramThread;
    }
  }
  
  /* Error */
  public final void a(Thread paramThread, android.content.ContentResolver paramContentResolver)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokespecial 32	com/whatsapp/gallerypicker/a:b	(Ljava/lang/Thread;)Lcom/whatsapp/gallerypicker/a$b;
    //   7: astore_3
    //   8: aload_3
    //   9: getstatic 54	com/whatsapp/gallerypicker/a$a:a	I
    //   12: putfield 53	com/whatsapp/gallerypicker/a$b:a	I
    //   15: aload_3
    //   16: getfield 35	com/whatsapp/gallerypicker/a$b:b	Landroid/graphics/BitmapFactory$Options;
    //   19: ifnull +10 -> 29
    //   22: aload_3
    //   23: getfield 35	com/whatsapp/gallerypicker/a$b:b	Landroid/graphics/BitmapFactory$Options;
    //   26: invokevirtual 131	android/graphics/BitmapFactory$Options:requestCancelDecode	()V
    //   29: aload_0
    //   30: invokevirtual 106	java/lang/Object:notifyAll	()V
    //   33: aload_3
    //   34: monitorenter
    //   35: aload_3
    //   36: getfield 93	com/whatsapp/gallerypicker/a$b:c	Z
    //   39: ifeq +25 -> 64
    //   42: aload_2
    //   43: ldc2_w 132
    //   46: aload_1
    //   47: invokevirtual 97	java/lang/Thread:getId	()J
    //   50: invokestatic 137	android/provider/MediaStore$Images$Thumbnails:cancelThumbnailRequest	(Landroid/content/ContentResolver;JJ)V
    //   53: aload_2
    //   54: ldc2_w 132
    //   57: aload_1
    //   58: invokevirtual 97	java/lang/Thread:getId	()J
    //   61: invokestatic 138	android/provider/MediaStore$Video$Thumbnails:cancelThumbnailRequest	(Landroid/content/ContentResolver;JJ)V
    //   64: aload_3
    //   65: monitorexit
    //   66: aload_0
    //   67: monitorexit
    //   68: return
    //   69: astore_1
    //   70: aload_3
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    //   74: astore_1
    //   75: aload_0
    //   76: monitorexit
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	a
    //   0	79	1	paramThread	Thread
    //   0	79	2	paramContentResolver	android.content.ContentResolver
    //   7	64	3	localb	b
    // Exception table:
    //   from	to	target	type
    //   35	64	69	finally
    //   64	66	69	finally
    //   70	72	69	finally
    //   2	29	74	finally
    //   29	35	74	finally
    //   72	74	74	finally
  }
  
  static enum a {}
  
  static final class b
  {
    public int a = a.a.b;
    public BitmapFactory.Options b;
    public boolean c;
    
    public final String toString()
    {
      String str;
      if (this.a == a.a.a) {
        str = "Cancel";
      }
      for (;;)
      {
        return "thread state = " + str + ", options = " + this.b;
        if (this.a == a.a.b) {
          str = "Allow";
        } else {
          str = "?";
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */