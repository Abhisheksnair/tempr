package com.whatsapp.gif_search;

import android.content.Context;
import android.os.Looper;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b
{
  public final q<String, GifCacheItemSerializable> a;
  private final String b;
  private final String c;
  private ThreadPoolExecutor d;
  private boolean e;
  private final Context f;
  private File g;
  
  public b(int paramInt, Context paramContext, String paramString1, String paramString2)
  {
    this.f = paramContext;
    this.b = paramString1;
    this.c = paramString2;
    this.a = new q(paramInt);
    paramContext = new q.a(this);
    this.a.a = new WeakReference(paramContext);
  }
  
  private File d()
  {
    if ((this.g != null) && (this.g.exists())) {
      return this.g;
    }
    File localFile = this.f.getExternalCacheDir();
    if ((localFile != null) && (localFile.exists()))
    {
      localFile = new File(localFile, this.b);
      if ((!localFile.exists()) && (!localFile.mkdirs()))
      {
        Log.e("diskbackedgifcache/getmappingfile/disk cache dir doesn't exit");
        return null;
      }
      this.g = new File(localFile, this.c);
      return this.g;
    }
    Log.e("diskbackedgifcache/getmappingfile/external cache dir doesn't exit");
    return null;
  }
  
  public final GifCacheItemSerializable a(String paramString)
  {
    a();
    GifCacheItemSerializable localGifCacheItemSerializable2 = (GifCacheItemSerializable)this.a.a(paramString);
    GifCacheItemSerializable localGifCacheItemSerializable1 = localGifCacheItemSerializable2;
    if (localGifCacheItemSerializable2 != null)
    {
      if (localGifCacheItemSerializable2.getFile().exists()) {
        break label56;
      }
      this.a.b(paramString);
      c().execute(c.a(this));
      localGifCacheItemSerializable1 = null;
    }
    label56:
    do
    {
      do
      {
        return localGifCacheItemSerializable1;
        localGifCacheItemSerializable1 = localGifCacheItemSerializable2;
      } while (localGifCacheItemSerializable2.thumbnail != null);
      localGifCacheItemSerializable1 = localGifCacheItemSerializable2;
    } while (Looper.myLooper() == Looper.getMainLooper());
    paramString = com.whatsapp.k.c.a("diskbackedgifcache/get/generating thumbnail");
    paramString.a();
    localGifCacheItemSerializable2.thumbnail = MediaFileUtils.a(localGifCacheItemSerializable2.getFile().getAbsolutePath(), 0L);
    paramString.b();
    return localGifCacheItemSerializable2;
  }
  
  /* Error */
  final void a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: invokestatic 116	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   8: invokestatic 119	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   11: if_acmpeq +190 -> 201
    //   14: aload_0
    //   15: getfield 148	com/whatsapp/gif_search/b:e	Z
    //   18: ifne +183 -> 201
    //   21: aload_0
    //   22: invokevirtual 95	com/whatsapp/gif_search/b:c	()Ljava/util/concurrent/ThreadPoolExecutor;
    //   25: pop
    //   26: aload_0
    //   27: invokespecial 150	com/whatsapp/gif_search/b:d	()Ljava/io/File;
    //   30: astore_2
    //   31: aload_2
    //   32: ifnull +164 -> 196
    //   35: aload_2
    //   36: invokevirtual 59	java/io/File:exists	()Z
    //   39: istore_1
    //   40: iload_1
    //   41: ifeq +155 -> 196
    //   44: new 152	java/io/FileInputStream
    //   47: dup
    //   48: aload_2
    //   49: invokespecial 155	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   52: astore 6
    //   54: new 157	java/io/ObjectInputStream
    //   57: dup
    //   58: aload 6
    //   60: invokespecial 160	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   63: astore 7
    //   65: ldc -94
    //   67: invokestatic 126	com/whatsapp/k/c:a	(Ljava/lang/String;)Lcom/whatsapp/k/d;
    //   70: astore_2
    //   71: aload_2
    //   72: invokeinterface 129 1 0
    //   77: new 164	java/util/ArrayList
    //   80: dup
    //   81: aload 7
    //   83: invokevirtual 168	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   86: checkcast 170	java/util/List
    //   89: invokespecial 173	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   92: invokeinterface 177 1 0
    //   97: astore_3
    //   98: aload_3
    //   99: invokeinterface 182 1 0
    //   104: ifeq +100 -> 204
    //   107: aload_3
    //   108: invokeinterface 185 1 0
    //   113: checkcast 87	com/whatsapp/gif_search/GifCacheItemSerializable
    //   116: astore 4
    //   118: aload 4
    //   120: invokevirtual 90	com/whatsapp/gif_search/GifCacheItemSerializable:getFile	()Ljava/io/File;
    //   123: invokevirtual 59	java/io/File:exists	()Z
    //   126: ifeq -28 -> 98
    //   129: aload_0
    //   130: getfield 36	com/whatsapp/gif_search/b:a	Lcom/whatsapp/gif_search/q;
    //   133: aload 4
    //   135: getfield 188	com/whatsapp/gif_search/GifCacheItemSerializable:url	Ljava/lang/String;
    //   138: aload 4
    //   140: invokevirtual 191	com/whatsapp/gif_search/q:a	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   143: pop
    //   144: goto -46 -> 98
    //   147: astore_2
    //   148: aload_2
    //   149: athrow
    //   150: astore_3
    //   151: aload_2
    //   152: astore 4
    //   154: aload_3
    //   155: astore_2
    //   156: aload 4
    //   158: ifnull +69 -> 227
    //   161: aload 7
    //   163: invokevirtual 194	java/io/ObjectInputStream:close	()V
    //   166: aload_2
    //   167: athrow
    //   168: astore_2
    //   169: aload_2
    //   170: athrow
    //   171: astore_3
    //   172: aload_2
    //   173: astore 4
    //   175: aload_3
    //   176: astore_2
    //   177: aload 4
    //   179: ifnull +64 -> 243
    //   182: aload 6
    //   184: invokevirtual 195	java/io/FileInputStream:close	()V
    //   187: aload_2
    //   188: athrow
    //   189: astore_2
    //   190: ldc -59
    //   192: aload_2
    //   193: invokestatic 200	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   196: aload_0
    //   197: iconst_1
    //   198: putfield 148	com/whatsapp/gif_search/b:e	Z
    //   201: aload_0
    //   202: monitorexit
    //   203: return
    //   204: aload_2
    //   205: invokeinterface 140 1 0
    //   210: aload 7
    //   212: invokevirtual 194	java/io/ObjectInputStream:close	()V
    //   215: aload 6
    //   217: invokevirtual 195	java/io/FileInputStream:close	()V
    //   220: goto -24 -> 196
    //   223: astore_2
    //   224: goto -34 -> 190
    //   227: aload 7
    //   229: invokevirtual 194	java/io/ObjectInputStream:close	()V
    //   232: goto -66 -> 166
    //   235: astore_2
    //   236: aload 5
    //   238: astore 4
    //   240: goto -63 -> 177
    //   243: aload 6
    //   245: invokevirtual 195	java/io/FileInputStream:close	()V
    //   248: goto -61 -> 187
    //   251: astore_2
    //   252: aload_0
    //   253: monitorexit
    //   254: aload_2
    //   255: athrow
    //   256: astore_3
    //   257: goto -91 -> 166
    //   260: astore_3
    //   261: goto -74 -> 187
    //   264: astore_2
    //   265: aconst_null
    //   266: astore 4
    //   268: goto -112 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	b
    //   39	2	1	bool	boolean
    //   30	42	2	localObject1	Object
    //   147	5	2	localThrowable1	Throwable
    //   155	12	2	localObject2	Object
    //   168	5	2	localThrowable2	Throwable
    //   176	12	2	localObject3	Object
    //   189	16	2	localIOException	java.io.IOException
    //   223	1	2	localClassNotFoundException	ClassNotFoundException
    //   235	1	2	localObject4	Object
    //   251	4	2	localObject5	Object
    //   264	1	2	localObject6	Object
    //   97	11	3	localIterator	java.util.Iterator
    //   150	5	3	localObject7	Object
    //   171	5	3	localObject8	Object
    //   256	1	3	localThrowable3	Throwable
    //   260	1	3	localThrowable4	Throwable
    //   116	151	4	localObject9	Object
    //   1	236	5	localObject10	Object
    //   52	192	6	localFileInputStream	java.io.FileInputStream
    //   63	165	7	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   65	98	147	java/lang/Throwable
    //   98	144	147	java/lang/Throwable
    //   204	210	147	java/lang/Throwable
    //   148	150	150	finally
    //   54	65	168	java/lang/Throwable
    //   166	168	168	java/lang/Throwable
    //   210	215	168	java/lang/Throwable
    //   227	232	168	java/lang/Throwable
    //   169	171	171	finally
    //   44	54	189	java/io/IOException
    //   182	187	189	java/io/IOException
    //   187	189	189	java/io/IOException
    //   215	220	189	java/io/IOException
    //   243	248	189	java/io/IOException
    //   44	54	223	java/lang/ClassNotFoundException
    //   182	187	223	java/lang/ClassNotFoundException
    //   187	189	223	java/lang/ClassNotFoundException
    //   215	220	223	java/lang/ClassNotFoundException
    //   243	248	223	java/lang/ClassNotFoundException
    //   54	65	235	finally
    //   161	166	235	finally
    //   166	168	235	finally
    //   210	215	235	finally
    //   227	232	235	finally
    //   5	31	251	finally
    //   35	40	251	finally
    //   44	54	251	finally
    //   182	187	251	finally
    //   187	189	251	finally
    //   190	196	251	finally
    //   196	201	251	finally
    //   215	220	251	finally
    //   243	248	251	finally
    //   161	166	256	java/lang/Throwable
    //   182	187	260	java/lang/Throwable
    //   65	98	264	finally
    //   98	144	264	finally
    //   204	210	264	finally
  }
  
  /* Error */
  final void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 204	a/a/a/a/a/a$d:c	()V
    //   6: aload_0
    //   7: invokespecial 150	com/whatsapp/gif_search/b:d	()Ljava/io/File;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +4 -> 16
    //   15: return
    //   16: ldc -50
    //   18: invokestatic 126	com/whatsapp/k/c:a	(Ljava/lang/String;)Lcom/whatsapp/k/d;
    //   21: astore 5
    //   23: aload 5
    //   25: invokeinterface 129 1 0
    //   30: new 208	java/io/FileOutputStream
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 209	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   38: astore 6
    //   40: new 211	java/io/ObjectOutputStream
    //   43: dup
    //   44: aload 6
    //   46: invokespecial 214	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   49: astore 7
    //   51: aload 7
    //   53: new 164	java/util/ArrayList
    //   56: dup
    //   57: aload_0
    //   58: getfield 36	com/whatsapp/gif_search/b:a	Lcom/whatsapp/gif_search/q;
    //   61: invokevirtual 217	com/whatsapp/gif_search/q:d	()Ljava/util/Map;
    //   64: invokeinterface 223 1 0
    //   69: invokespecial 173	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   72: invokevirtual 226	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   75: aload 7
    //   77: invokevirtual 227	java/io/ObjectOutputStream:close	()V
    //   80: aload 6
    //   82: invokevirtual 228	java/io/FileOutputStream:close	()V
    //   85: aload 5
    //   87: invokeinterface 140 1 0
    //   92: return
    //   93: astore_1
    //   94: aload_1
    //   95: athrow
    //   96: astore_2
    //   97: aload_1
    //   98: astore_3
    //   99: aload_2
    //   100: astore_1
    //   101: aload_3
    //   102: ifnull +39 -> 141
    //   105: aload 7
    //   107: invokevirtual 227	java/io/ObjectOutputStream:close	()V
    //   110: aload_1
    //   111: athrow
    //   112: astore_1
    //   113: aload_1
    //   114: athrow
    //   115: astore_2
    //   116: aload_1
    //   117: astore_3
    //   118: aload_2
    //   119: astore_1
    //   120: aload_3
    //   121: ifnull +35 -> 156
    //   124: aload 6
    //   126: invokevirtual 228	java/io/FileOutputStream:close	()V
    //   129: aload_1
    //   130: athrow
    //   131: astore_1
    //   132: ldc -26
    //   134: aload_1
    //   135: invokestatic 200	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   138: goto -53 -> 85
    //   141: aload 7
    //   143: invokevirtual 227	java/io/ObjectOutputStream:close	()V
    //   146: goto -36 -> 110
    //   149: astore_1
    //   150: aload 4
    //   152: astore_3
    //   153: goto -33 -> 120
    //   156: aload 6
    //   158: invokevirtual 228	java/io/FileOutputStream:close	()V
    //   161: goto -32 -> 129
    //   164: astore_2
    //   165: goto -55 -> 110
    //   168: astore_2
    //   169: goto -40 -> 129
    //   172: astore_1
    //   173: aconst_null
    //   174: astore_3
    //   175: goto -74 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	b
    //   10	25	1	localFile	File
    //   93	5	1	localThrowable1	Throwable
    //   100	11	1	localObject1	Object
    //   112	5	1	localThrowable2	Throwable
    //   119	11	1	localObject2	Object
    //   131	4	1	localIOException	java.io.IOException
    //   149	1	1	localObject3	Object
    //   172	1	1	localObject4	Object
    //   96	4	2	localObject5	Object
    //   115	4	2	localObject6	Object
    //   164	1	2	localThrowable3	Throwable
    //   168	1	2	localThrowable4	Throwable
    //   98	77	3	localObject7	Object
    //   1	150	4	localObject8	Object
    //   21	65	5	locald	com.whatsapp.k.d
    //   38	119	6	localFileOutputStream	java.io.FileOutputStream
    //   49	93	7	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   51	75	93	java/lang/Throwable
    //   94	96	96	finally
    //   40	51	112	java/lang/Throwable
    //   75	80	112	java/lang/Throwable
    //   110	112	112	java/lang/Throwable
    //   141	146	112	java/lang/Throwable
    //   113	115	115	finally
    //   30	40	131	java/io/IOException
    //   80	85	131	java/io/IOException
    //   124	129	131	java/io/IOException
    //   129	131	131	java/io/IOException
    //   156	161	131	java/io/IOException
    //   40	51	149	finally
    //   75	80	149	finally
    //   105	110	149	finally
    //   110	112	149	finally
    //   141	146	149	finally
    //   105	110	164	java/lang/Throwable
    //   124	129	168	java/lang/Throwable
    //   51	75	172	finally
  }
  
  final ThreadPoolExecutor c()
  {
    try
    {
      if (this.d == null) {
        this.d = a.a.a.a.d.a(0, 1, TimeUnit.SECONDS, "Disk backed Gif Cache Worker#");
      }
      ThreadPoolExecutor localThreadPoolExecutor = this.d;
      return localThreadPoolExecutor;
    }
    finally {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gif_search/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */