package com.whatsapp.registration;

import android.content.Context;
import com.whatsapp.u;

public class x
{
  private static volatile x b;
  public boolean a;
  private final Context c;
  
  private x(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public static x a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new x(u.a());
      }
      return b;
    }
    finally {}
  }
  
  /* Error */
  public final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	com/whatsapp/registration/x:a	Z
    //   4: iload_1
    //   5: if_icmpeq +44 -> 49
    //   8: aload_0
    //   9: iload_1
    //   10: putfield 35	com/whatsapp/registration/x:a	Z
    //   13: new 37	java/io/DataOutputStream
    //   16: dup
    //   17: aload_0
    //   18: getfield 17	com/whatsapp/registration/x:c	Landroid/content/Context;
    //   21: ldc 39
    //   23: iconst_0
    //   24: invokevirtual 45	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   27: invokespecial 48	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: astore 5
    //   32: aconst_null
    //   33: astore 4
    //   35: aload 5
    //   37: aload_0
    //   38: getfield 35	com/whatsapp/registration/x:a	Z
    //   41: invokevirtual 51	java/io/DataOutputStream:writeBoolean	(Z)V
    //   44: aload 5
    //   46: invokevirtual 54	java/io/DataOutputStream:close	()V
    //   49: return
    //   50: astore_2
    //   51: aload_2
    //   52: athrow
    //   53: astore_3
    //   54: aload_2
    //   55: astore 4
    //   57: aload_3
    //   58: astore_2
    //   59: aload 4
    //   61: ifnull +18 -> 79
    //   64: aload 5
    //   66: invokevirtual 54	java/io/DataOutputStream:close	()V
    //   69: aload_2
    //   70: athrow
    //   71: astore_2
    //   72: ldc 56
    //   74: aload_2
    //   75: invokestatic 61	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   78: return
    //   79: aload 5
    //   81: invokevirtual 54	java/io/DataOutputStream:close	()V
    //   84: goto -15 -> 69
    //   87: astore_3
    //   88: goto -19 -> 69
    //   91: astore_2
    //   92: goto -33 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	x
    //   0	95	1	paramBoolean	boolean
    //   50	5	2	localThrowable1	Throwable
    //   58	12	2	localObject1	Object
    //   71	4	2	localIOException	java.io.IOException
    //   91	1	2	localObject2	Object
    //   53	5	3	localObject3	Object
    //   87	1	3	localThrowable2	Throwable
    //   33	27	4	localObject4	Object
    //   30	50	5	localDataOutputStream	java.io.DataOutputStream
    // Exception table:
    //   from	to	target	type
    //   35	44	50	java/lang/Throwable
    //   51	53	53	finally
    //   13	32	71	java/io/IOException
    //   44	49	71	java/io/IOException
    //   64	69	71	java/io/IOException
    //   69	71	71	java/io/IOException
    //   79	84	71	java/io/IOException
    //   64	69	87	java/lang/Throwable
    //   35	44	91	finally
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: new 64	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 17	com/whatsapp/registration/x:c	Landroid/content/Context;
    //   8: invokevirtual 68	android/content/Context:getFilesDir	()Ljava/io/File;
    //   11: ldc 39
    //   13: invokespecial 71	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   16: invokevirtual 74	java/io/File:exists	()Z
    //   19: ifeq +83 -> 102
    //   22: new 76	java/io/DataInputStream
    //   25: dup
    //   26: aload_0
    //   27: getfield 17	com/whatsapp/registration/x:c	Landroid/content/Context;
    //   30: ldc 39
    //   32: invokevirtual 80	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   35: invokespecial 83	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: astore 4
    //   40: aconst_null
    //   41: astore_3
    //   42: aload_0
    //   43: aload 4
    //   45: invokevirtual 86	java/io/DataInputStream:readBoolean	()Z
    //   48: putfield 35	com/whatsapp/registration/x:a	Z
    //   51: aload 4
    //   53: invokevirtual 87	java/io/DataInputStream:close	()V
    //   56: aload_0
    //   57: getfield 35	com/whatsapp/registration/x:a	Z
    //   60: ireturn
    //   61: astore_1
    //   62: aload_1
    //   63: athrow
    //   64: astore_2
    //   65: aload_1
    //   66: astore_3
    //   67: aload_2
    //   68: astore_1
    //   69: aload_3
    //   70: ifnull +24 -> 94
    //   73: aload 4
    //   75: invokevirtual 87	java/io/DataInputStream:close	()V
    //   78: aload_1
    //   79: athrow
    //   80: astore_1
    //   81: ldc 89
    //   83: invokestatic 93	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 35	com/whatsapp/registration/x:a	Z
    //   91: goto -35 -> 56
    //   94: aload 4
    //   96: invokevirtual 87	java/io/DataInputStream:close	()V
    //   99: goto -21 -> 78
    //   102: ldc 95
    //   104: invokestatic 98	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   107: aload_0
    //   108: iconst_0
    //   109: putfield 35	com/whatsapp/registration/x:a	Z
    //   112: goto -56 -> 56
    //   115: astore_2
    //   116: goto -38 -> 78
    //   119: astore_1
    //   120: goto -51 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	x
    //   61	5	1	localThrowable1	Throwable
    //   68	11	1	localObject1	Object
    //   80	1	1	localIOException	java.io.IOException
    //   119	1	1	localObject2	Object
    //   64	4	2	localObject3	Object
    //   115	1	2	localThrowable2	Throwable
    //   41	29	3	localObject4	Object
    //   38	57	4	localDataInputStream	java.io.DataInputStream
    // Exception table:
    //   from	to	target	type
    //   42	51	61	java/lang/Throwable
    //   62	64	64	finally
    //   22	40	80	java/io/IOException
    //   51	56	80	java/io/IOException
    //   73	78	80	java/io/IOException
    //   78	80	80	java/io/IOException
    //   94	99	80	java/io/IOException
    //   73	78	115	java/lang/Throwable
    //   42	51	119	finally
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/registration/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */