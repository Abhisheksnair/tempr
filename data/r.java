package com.whatsapp.data;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class r
{
  private static volatile r a;
  private final n b;
  private final ReentrantReadWriteLock.ReadLock c;
  
  private r(ch paramch)
  {
    this.b = paramch.a;
    this.c = paramch.b.readLock();
  }
  
  public static r a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new r(ch.a());
      }
      return a;
    }
    finally {}
  }
  
  /* Error */
  final boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: getfield 32	com/whatsapp/data/r:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   6: invokevirtual 47	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:lock	()V
    //   9: aload_0
    //   10: getfield 21	com/whatsapp/data/r:b	Lcom/whatsapp/data/n;
    //   13: invokevirtual 53	com/whatsapp/data/n:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: ldc 55
    //   18: iconst_1
    //   19: anewarray 57	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: aload_1
    //   25: aastore
    //   26: invokevirtual 63	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   29: astore_1
    //   30: aload_1
    //   31: ifnull +56 -> 87
    //   34: aload_1
    //   35: invokeinterface 69 1 0
    //   40: istore_2
    //   41: iload_2
    //   42: iconst_1
    //   43: if_icmpne +18 -> 61
    //   46: aload_1
    //   47: invokeinterface 72 1 0
    //   52: aload_0
    //   53: getfield 32	com/whatsapp/data/r:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   56: invokevirtual 75	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   59: iload_3
    //   60: ireturn
    //   61: iconst_0
    //   62: istore_3
    //   63: goto -17 -> 46
    //   66: astore 4
    //   68: aload_1
    //   69: invokeinterface 72 1 0
    //   74: aload 4
    //   76: athrow
    //   77: astore_1
    //   78: aload_0
    //   79: getfield 32	com/whatsapp/data/r:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   82: invokevirtual 75	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   85: aload_1
    //   86: athrow
    //   87: aload_0
    //   88: getfield 32	com/whatsapp/data/r:c	Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
    //   91: invokevirtual 75	java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock:unlock	()V
    //   94: iconst_0
    //   95: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	r
    //   0	96	1	paramString	String
    //   40	4	2	i	int
    //   1	62	3	bool	boolean
    //   66	9	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   34	41	66	finally
    //   9	30	77	finally
    //   46	52	77	finally
    //   68	77	77	finally
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */