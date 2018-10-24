package com.whatsapp.util;

import android.text.TextUtils;
import com.whatsapp.vv;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class bk
{
  public final File a;
  File b;
  boolean c;
  final Lock d = new ReentrantLock();
  private final vv e;
  
  public bk(vv paramvv, File paramFile)
  {
    this.a = paramFile;
    this.e = paramvv;
  }
  
  public static boolean a(File paramFile)
  {
    if (paramFile.isDirectory()) {
      try
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile != null)
        {
          int j = arrayOfFile.length;
          int i = 0;
          while (i < j)
          {
            boolean bool = a(arrayOfFile[i]);
            if (!bool) {
              return false;
            }
            i += 1;
          }
        }
        return paramFile.delete();
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Log.e("trash/delete-recursive/out-of-memory " + paramFile.getAbsolutePath());
        return false;
      }
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 72	com/whatsapp/util/bk:a	()V
    //   6: aload_0
    //   7: getfield 74	com/whatsapp/util/bk:b	Ljava/io/File;
    //   10: ifnull +13 -> 23
    //   13: aload_0
    //   14: getfield 74	com/whatsapp/util/bk:b	Ljava/io/File;
    //   17: invokevirtual 77	java/io/File:exists	()Z
    //   20: ifne +298 -> 318
    //   23: iconst_0
    //   24: istore_1
    //   25: aload_0
    //   26: new 33	java/io/File
    //   29: dup
    //   30: aload_0
    //   31: getfield 25	com/whatsapp/util/bk:a	Ljava/io/File;
    //   34: invokestatic 83	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   37: invokevirtual 84	java/util/UUID:toString	()Ljava/lang/String;
    //   40: invokespecial 87	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   43: putfield 74	com/whatsapp/util/bk:b	Ljava/io/File;
    //   46: iload_1
    //   47: iconst_1
    //   48: iadd
    //   49: istore_2
    //   50: iload_1
    //   51: bipush 10
    //   53: if_icmpge +39 -> 92
    //   56: aload_0
    //   57: getfield 74	com/whatsapp/util/bk:b	Ljava/io/File;
    //   60: invokevirtual 90	java/io/File:mkdir	()Z
    //   63: ifne +29 -> 92
    //   66: aload_0
    //   67: new 33	java/io/File
    //   70: dup
    //   71: aload_0
    //   72: getfield 25	com/whatsapp/util/bk:a	Ljava/io/File;
    //   75: invokestatic 83	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   78: invokevirtual 84	java/util/UUID:toString	()Ljava/lang/String;
    //   81: invokespecial 87	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   84: putfield 74	com/whatsapp/util/bk:b	Ljava/io/File;
    //   87: iload_2
    //   88: istore_1
    //   89: goto -43 -> 46
    //   92: iload_2
    //   93: bipush 10
    //   95: if_icmple +223 -> 318
    //   98: new 45	java/lang/StringBuilder
    //   101: dup
    //   102: ldc 92
    //   104: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   107: aload_0
    //   108: getfield 74	com/whatsapp/util/bk:b	Ljava/io/File;
    //   111: invokevirtual 93	java/io/File:toString	()Ljava/lang/String;
    //   114: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 96	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   123: new 45	java/lang/StringBuilder
    //   126: dup
    //   127: ldc 98
    //   129: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   132: invokestatic 104	com/whatsapp/vv:g	()J
    //   135: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   138: ldc 109
    //   140: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokestatic 112	com/whatsapp/vv:f	()J
    //   146: invokevirtual 107	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   149: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 96	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   155: new 45	java/lang/StringBuilder
    //   158: dup
    //   159: ldc 114
    //   161: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   164: invokestatic 119	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   167: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 96	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   176: new 45	java/lang/StringBuilder
    //   179: dup
    //   180: ldc 121
    //   182: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   185: aload_0
    //   186: getfield 25	com/whatsapp/util/bk:a	Ljava/io/File;
    //   189: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   192: ldc 126
    //   194: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_0
    //   198: getfield 25	com/whatsapp/util/bk:a	Ljava/io/File;
    //   201: invokevirtual 77	java/io/File:exists	()Z
    //   204: invokevirtual 129	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   207: ldc -125
    //   209: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_0
    //   213: getfield 25	com/whatsapp/util/bk:a	Ljava/io/File;
    //   216: invokevirtual 134	java/io/File:canWrite	()Z
    //   219: invokevirtual 129	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   222: ldc -120
    //   224: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_0
    //   228: getfield 25	com/whatsapp/util/bk:a	Ljava/io/File;
    //   231: invokevirtual 37	java/io/File:isDirectory	()Z
    //   234: invokevirtual 129	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   237: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 96	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   243: aload_0
    //   244: getfield 25	com/whatsapp/util/bk:a	Ljava/io/File;
    //   247: invokevirtual 140	java/io/File:getCanonicalFile	()Ljava/io/File;
    //   250: astore_3
    //   251: new 45	java/lang/StringBuilder
    //   254: dup
    //   255: ldc -114
    //   257: invokespecial 50	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   260: aload_3
    //   261: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   264: ldc 126
    //   266: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload_3
    //   270: invokevirtual 77	java/io/File:exists	()Z
    //   273: invokevirtual 129	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   276: ldc -125
    //   278: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: aload_3
    //   282: invokevirtual 134	java/io/File:canWrite	()Z
    //   285: invokevirtual 129	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   288: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 96	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   294: new 70	java/io/IOException
    //   297: dup
    //   298: ldc -112
    //   300: invokespecial 145	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   303: athrow
    //   304: astore_3
    //   305: aload_0
    //   306: monitorexit
    //   307: aload_3
    //   308: athrow
    //   309: astore_3
    //   310: ldc -109
    //   312: invokestatic 96	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   315: goto -21 -> 294
    //   318: aload_0
    //   319: monitorexit
    //   320: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	321	0	this	bk
    //   24	65	1	i	int
    //   49	47	2	j	int
    //   250	32	3	localFile	File
    //   304	4	3	localObject	Object
    //   309	1	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   2	23	304	finally
    //   25	46	304	finally
    //   56	87	304	finally
    //   98	243	304	finally
    //   243	294	304	finally
    //   294	304	304	finally
    //   310	315	304	finally
    //   243	294	309	java/io/IOException
  }
  
  public final File a(String paramString)
  {
    c();
    File localFile = this.b;
    StringBuilder localStringBuilder = new StringBuilder().append(UUID.randomUUID().toString());
    int i;
    label62:
    int j;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = "";
      localObject = new File(localFile, (String)localObject);
      i = 0;
      j = i + 1;
      if ((i >= 10) || (((File)localObject).createNewFile())) {
        break label183;
      }
      localFile = this.b;
      localStringBuilder = new StringBuilder().append(UUID.randomUUID().toString());
      if (!TextUtils.isEmpty(paramString)) {
        break label162;
      }
    }
    label162:
    for (Object localObject = "";; localObject = "." + paramString)
    {
      localObject = new File(localFile, (String)localObject);
      i = j;
      break label62;
      localObject = "." + paramString;
      break;
    }
    label183:
    if (j > 10) {
      throw new IOException("max retries reached while creating temp file");
    }
    return (File)localObject;
  }
  
  public final void a()
  {
    if ((this.a.exists()) && (!this.a.isDirectory()))
    {
      Log.w("trash/create-trash-dir/removing " + this.a);
      if ((!this.a.delete()) && (this.a.exists())) {
        Log.e("trash/create-trash-dir/failed " + this.a + " is not a directory");
      }
    }
    if (!this.a.exists())
    {
      this.a.mkdirs();
      if ((!this.a.exists()) && (!this.a.mkdir())) {
        Log.w("trash/create-trash-dir/failed");
      }
    }
  }
  
  public final void b()
  {
    this.d.lock();
    if (!this.c)
    {
      this.d.unlock();
      bu.a(bl.a(this));
      return;
    }
    this.d.unlock();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */