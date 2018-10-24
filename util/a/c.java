package com.whatsapp.util.a;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings.Secure;
import com.whatsapp.Me;
import com.whatsapp.ahc;
import com.whatsapp.and;
import com.whatsapp.aog;
import com.whatsapp.atv;
import com.whatsapp.av;
import com.whatsapp.g.f;
import com.whatsapp.i.a;
import com.whatsapp.mb;
import com.whatsapp.md;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import com.whatsapp.va;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.UUID;

public class c
{
  public static final Object g = new Object();
  private static volatile c h;
  Object a;
  final Object b = new Object();
  public File c;
  public File d;
  public boolean e;
  public final aog f;
  private final va i;
  private final ahc j;
  private final and k;
  private final atv l;
  
  private c(aog paramaog, va paramva, ahc paramahc, and paramand, atv paramatv)
  {
    this.f = paramaog;
    this.i = paramva;
    this.j = paramahc;
    this.k = paramand;
    this.l = paramatv;
  }
  
  /* Error */
  static a a(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 61	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 64	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: astore_2
    //   11: new 66	java/io/ObjectInputStream
    //   14: dup
    //   15: aload_2
    //   16: invokespecial 69	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: astore_1
    //   20: aload_1
    //   21: astore 4
    //   23: aload_2
    //   24: astore_3
    //   25: aload_1
    //   26: invokevirtual 73	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   29: checkcast 10	com/whatsapp/util/a/c$a
    //   32: astore_0
    //   33: aload_2
    //   34: invokevirtual 76	java/io/FileInputStream:close	()V
    //   37: aload_1
    //   38: invokevirtual 77	java/io/ObjectInputStream:close	()V
    //   41: aload_0
    //   42: areturn
    //   43: astore_1
    //   44: ldc 79
    //   46: aload_1
    //   47: invokestatic 84	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: aconst_null
    //   54: astore_1
    //   55: aconst_null
    //   56: astore_2
    //   57: aload_1
    //   58: astore 4
    //   60: aload_2
    //   61: astore_3
    //   62: ldc 86
    //   64: aload_0
    //   65: invokestatic 84	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   68: aload_2
    //   69: ifnull +7 -> 76
    //   72: aload_2
    //   73: invokevirtual 76	java/io/FileInputStream:close	()V
    //   76: aload_1
    //   77: ifnull +7 -> 84
    //   80: aload_1
    //   81: invokevirtual 77	java/io/ObjectInputStream:close	()V
    //   84: aconst_null
    //   85: areturn
    //   86: astore_0
    //   87: ldc 79
    //   89: aload_0
    //   90: invokestatic 84	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   93: aconst_null
    //   94: areturn
    //   95: astore_0
    //   96: aconst_null
    //   97: astore_2
    //   98: aload_3
    //   99: astore_1
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 76	java/io/FileInputStream:close	()V
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 77	java/io/ObjectInputStream:close	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_1
    //   119: ldc 79
    //   121: aload_1
    //   122: invokestatic 84	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   125: goto -9 -> 116
    //   128: astore_0
    //   129: aload_3
    //   130: astore_1
    //   131: goto -31 -> 100
    //   134: astore_0
    //   135: aload 4
    //   137: astore_1
    //   138: aload_3
    //   139: astore_2
    //   140: goto -40 -> 100
    //   143: astore_0
    //   144: aconst_null
    //   145: astore_1
    //   146: goto -89 -> 57
    //   149: astore_0
    //   150: goto -93 -> 57
    //   153: astore_0
    //   154: aconst_null
    //   155: astore_1
    //   156: aconst_null
    //   157: astore_2
    //   158: goto -101 -> 57
    //   161: astore_0
    //   162: aconst_null
    //   163: astore_1
    //   164: goto -107 -> 57
    //   167: astore_0
    //   168: goto -111 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramFile	File
    //   19	19	1	localObjectInputStream	java.io.ObjectInputStream
    //   43	4	1	localIOException1	IOException
    //   54	59	1	localObject1	Object
    //   118	4	1	localIOException2	IOException
    //   130	34	1	localObject2	Object
    //   10	148	2	localObject3	Object
    //   1	138	3	localObject4	Object
    //   21	115	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   33	41	43	java/io/IOException
    //   2	11	52	java/lang/ClassNotFoundException
    //   72	76	86	java/io/IOException
    //   80	84	86	java/io/IOException
    //   2	11	95	finally
    //   104	108	118	java/io/IOException
    //   112	116	118	java/io/IOException
    //   11	20	128	finally
    //   25	33	134	finally
    //   62	68	134	finally
    //   11	20	143	java/lang/ClassNotFoundException
    //   25	33	149	java/lang/ClassNotFoundException
    //   2	11	153	java/io/IOException
    //   11	20	161	java/io/IOException
    //   25	33	167	java/io/IOException
  }
  
  public static c a()
  {
    if (h == null) {}
    try
    {
      if (h == null) {
        h = new c(aog.a(), va.a(), ahc.a(), and.a(), atv.a());
      }
      return h;
    }
    finally {}
  }
  
  private static File a(File paramFile, long paramLong)
  {
    return a(paramFile, new File(e(), Long.toString(paramLong) + ".log"));
  }
  
  /* Error */
  private static File a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: new 61	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 64	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_3
    //   9: new 148	java/io/FileOutputStream
    //   12: dup
    //   13: aload_1
    //   14: invokespecial 149	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   17: astore_0
    //   18: aload_0
    //   19: astore 5
    //   21: aload_3
    //   22: astore 4
    //   24: sipush 1024
    //   27: newarray <illegal type>
    //   29: astore 6
    //   31: aload_0
    //   32: astore 5
    //   34: aload_3
    //   35: astore 4
    //   37: aload_3
    //   38: aload 6
    //   40: invokevirtual 155	java/io/InputStream:read	([B)I
    //   43: istore_2
    //   44: iload_2
    //   45: ifle +51 -> 96
    //   48: aload_0
    //   49: astore 5
    //   51: aload_3
    //   52: astore 4
    //   54: aload_0
    //   55: aload 6
    //   57: iconst_0
    //   58: iload_2
    //   59: invokevirtual 161	java/io/OutputStream:write	([BII)V
    //   62: goto -31 -> 31
    //   65: astore_1
    //   66: aload_0
    //   67: astore 5
    //   69: aload_3
    //   70: astore 4
    //   72: ldc -93
    //   74: aload_1
    //   75: invokestatic 84	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   78: aload_3
    //   79: ifnull +7 -> 86
    //   82: aload_3
    //   83: invokevirtual 164	java/io/InputStream:close	()V
    //   86: aload_0
    //   87: ifnull +7 -> 94
    //   90: aload_0
    //   91: invokevirtual 165	java/io/OutputStream:close	()V
    //   94: aconst_null
    //   95: areturn
    //   96: aload_3
    //   97: invokevirtual 164	java/io/InputStream:close	()V
    //   100: aload_0
    //   101: invokevirtual 165	java/io/OutputStream:close	()V
    //   104: aload_1
    //   105: areturn
    //   106: astore_0
    //   107: ldc -89
    //   109: aload_0
    //   110: invokestatic 84	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: aload_1
    //   114: areturn
    //   115: astore_0
    //   116: ldc -89
    //   118: aload_0
    //   119: invokestatic 84	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   122: goto -28 -> 94
    //   125: astore_0
    //   126: aconst_null
    //   127: astore 5
    //   129: aconst_null
    //   130: astore_3
    //   131: aload_3
    //   132: ifnull +7 -> 139
    //   135: aload_3
    //   136: invokevirtual 164	java/io/InputStream:close	()V
    //   139: aload 5
    //   141: ifnull +8 -> 149
    //   144: aload 5
    //   146: invokevirtual 165	java/io/OutputStream:close	()V
    //   149: aload_0
    //   150: athrow
    //   151: astore_1
    //   152: ldc -89
    //   154: aload_1
    //   155: invokestatic 84	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   158: goto -9 -> 149
    //   161: astore_0
    //   162: aconst_null
    //   163: astore 5
    //   165: goto -34 -> 131
    //   168: astore_0
    //   169: aload 4
    //   171: astore_3
    //   172: goto -41 -> 131
    //   175: astore_1
    //   176: aconst_null
    //   177: astore_0
    //   178: aconst_null
    //   179: astore_3
    //   180: goto -114 -> 66
    //   183: astore_1
    //   184: aconst_null
    //   185: astore_0
    //   186: goto -120 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	paramFile1	File
    //   0	189	1	paramFile2	File
    //   43	16	2	m	int
    //   8	172	3	localObject1	Object
    //   22	148	4	localObject2	Object
    //   19	145	5	localFile	File
    //   29	27	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   24	31	65	java/io/IOException
    //   37	44	65	java/io/IOException
    //   54	62	65	java/io/IOException
    //   96	104	106	java/io/IOException
    //   82	86	115	java/io/IOException
    //   90	94	115	java/io/IOException
    //   0	9	125	finally
    //   135	139	151	java/io/IOException
    //   144	149	151	java/io/IOException
    //   9	18	161	finally
    //   24	31	168	finally
    //   37	44	168	finally
    //   54	62	168	finally
    //   72	78	168	finally
    //   0	9	175	java/io/IOException
    //   9	18	183	java/io/IOException
  }
  
  private static String a(EnumSet<b> paramEnumSet)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramEnumSet != null) && (!paramEnumSet.isEmpty()))
    {
      paramEnumSet = paramEnumSet.iterator();
      while (paramEnumSet.hasNext()) {
        localStringBuilder.append(((b)paramEnumSet.next()).c).append(',');
      }
      localStringBuilder.setLength(localStringBuilder.length() - 1);
    }
    return localStringBuilder.toString();
  }
  
  /* Error */
  private static void a(a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 148	java/io/FileOutputStream
    //   7: dup
    //   8: new 119	java/io/File
    //   11: dup
    //   12: invokestatic 122	com/whatsapp/util/a/c:e	()Ljava/io/File;
    //   15: new 124	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   22: aload_0
    //   23: getfield 206	com/whatsapp/util/a/c$a:h	J
    //   26: invokestatic 131	java/lang/Long:toString	(J)Ljava/lang/String;
    //   29: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc -48
    //   34: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokespecial 143	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   43: iconst_0
    //   44: invokespecial 211	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   47: astore_1
    //   48: new 213	java/io/ObjectOutputStream
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 216	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   56: astore_2
    //   57: aload_2
    //   58: aload_0
    //   59: invokevirtual 220	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   62: aload_1
    //   63: invokevirtual 221	java/io/FileOutputStream:close	()V
    //   66: aload_2
    //   67: invokevirtual 222	java/io/ObjectOutputStream:close	()V
    //   70: return
    //   71: astore_0
    //   72: ldc -32
    //   74: aload_0
    //   75: invokestatic 84	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   78: return
    //   79: astore_3
    //   80: aconst_null
    //   81: astore_1
    //   82: new 124	java/lang/StringBuilder
    //   85: dup
    //   86: ldc -30
    //   88: invokespecial 229	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: aload_0
    //   92: getfield 206	com/whatsapp/util/a/c$a:h	J
    //   95: invokevirtual 232	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   98: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: aload_3
    //   102: invokestatic 84	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   105: aload_2
    //   106: ifnull +7 -> 113
    //   109: aload_2
    //   110: invokevirtual 221	java/io/FileOutputStream:close	()V
    //   113: aload_1
    //   114: ifnull -44 -> 70
    //   117: aload_1
    //   118: invokevirtual 222	java/io/ObjectOutputStream:close	()V
    //   121: return
    //   122: astore_0
    //   123: ldc -32
    //   125: aload_0
    //   126: invokestatic 84	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: return
    //   130: astore_0
    //   131: aconst_null
    //   132: astore_1
    //   133: aload_3
    //   134: astore_2
    //   135: aload_1
    //   136: ifnull +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 221	java/io/FileOutputStream:close	()V
    //   143: aload_2
    //   144: ifnull +7 -> 151
    //   147: aload_2
    //   148: invokevirtual 222	java/io/ObjectOutputStream:close	()V
    //   151: aload_0
    //   152: athrow
    //   153: astore_1
    //   154: ldc -32
    //   156: aload_1
    //   157: invokestatic 84	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   160: goto -9 -> 151
    //   163: astore_0
    //   164: aload_3
    //   165: astore_2
    //   166: goto -31 -> 135
    //   169: astore_0
    //   170: goto -35 -> 135
    //   173: astore_0
    //   174: aload_2
    //   175: astore_3
    //   176: aload_1
    //   177: astore_2
    //   178: aload_3
    //   179: astore_1
    //   180: goto -45 -> 135
    //   183: astore_3
    //   184: aconst_null
    //   185: astore 4
    //   187: aload_1
    //   188: astore_2
    //   189: aload 4
    //   191: astore_1
    //   192: goto -110 -> 82
    //   195: astore_3
    //   196: aload_1
    //   197: astore 4
    //   199: aload_2
    //   200: astore_1
    //   201: aload 4
    //   203: astore_2
    //   204: goto -122 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	parama	a
    //   47	93	1	localFileOutputStream	java.io.FileOutputStream
    //   153	24	1	localIOException1	IOException
    //   179	22	1	localObject1	Object
    //   3	201	2	localObject2	Object
    //   1	1	3	localObject3	Object
    //   79	86	3	localIOException2	IOException
    //   175	4	3	localObject4	Object
    //   183	1	3	localIOException3	IOException
    //   195	1	3	localIOException4	IOException
    //   185	17	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   62	70	71	java/io/IOException
    //   4	48	79	java/io/IOException
    //   109	113	122	java/io/IOException
    //   117	121	122	java/io/IOException
    //   4	48	130	finally
    //   139	143	153	java/io/IOException
    //   147	151	153	java/io/IOException
    //   48	57	163	finally
    //   57	62	169	finally
    //   82	105	173	finally
    //   48	57	183	java/io/IOException
    //   57	62	195	java/io/IOException
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool = false;
    Log.d("CrashLogs/Checking fb upload server status");
    a.a();
    com.whatsapp.i.d locald = a.a("https://crashlogs.whatsapp.net/wa_fls_upload_check", null, false);
    locald.b("access_token", "1063127757113399|745146ffa34413f9dbb5469f5370b7af");
    locald.b("from", paramString1);
    locald.b("type", paramString2);
    int m = locald.a(null);
    switch (m)
    {
    default: 
      throw new IOException("Unknown response code " + m + " from crash upload server");
    case 200: 
      bool = true;
    case 403: 
      return bool;
    }
    throw new IOException("Response 500 received from server");
  }
  
  static boolean a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4, String paramString5)
  {
    try
    {
      if (av.d())
      {
        Log.d("app/CrashLogs/uploadCrashData: Not uploading as we are in a debug build");
        return false;
      }
      if ((!paramBoolean1) && (!a(paramString3, "crashlog"))) {
        return false;
      }
      a.a();
      com.whatsapp.i.d locald = a.a("https://crashlogs.whatsapp.net/wa_clb_data", null, false);
      locald.b("access_token", "1063127757113399|745146ffa34413f9dbb5469f5370b7af");
      paramString1 = new File(paramString1);
      locald.a(new FileInputStream(paramString1), "file", paramString1.getName(), 0L);
      if (!paramString2.isEmpty())
      {
        paramString1 = new File(paramString2);
        locald.a(new FileInputStream(paramString1), paramString5, paramString1.getName(), 0L);
      }
      locald.a("from", paramString3);
      if (!paramString4.isEmpty()) {
        locald.a("tags", paramString4);
      }
      if (paramBoolean1) {
        locald.a("forced", "true");
      }
      if (paramBoolean2) {
        locald.a("detailed", "true");
      }
      int m = locald.a(null);
      return (m > 0) && (m < 400);
    }
    catch (IOException paramString1)
    {
      Log.c("app/CrashLogs/uploadCrashData: could not upload crash data", paramString1);
    }
    return false;
  }
  
  private static File b(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    try
    {
      paramFile = a(paramFile, new File(f(), paramFile.getName()));
      return paramFile;
    }
    catch (IOException paramFile) {}
    return null;
  }
  
  static File e()
  {
    File localFile = new File(u.a().getCacheDir(), "Crashes");
    localFile.mkdirs();
    return localFile;
  }
  
  private static File f()
  {
    int m = 0;
    File localFile = new File(e(), UUID.randomUUID().toString());
    int n;
    for (;;)
    {
      n = m + 1;
      if ((m >= 10) || (localFile.mkdirs())) {
        break;
      }
      localFile = new File(e(), UUID.randomUUID().toString());
      m = n;
    }
    if (n > 10) {
      throw new IOException("max retries reached while creating attachment temp directory");
    }
    return localFile;
  }
  
  private void g()
  {
    synchronized (this.b)
    {
      if (this.a != null) {
        return;
      }
      this.a = new Object()
      {
        public final void onEventAsync(f paramAnonymousf)
        {
          if (paramAnonymousf.a) {
            bu.a(e.a(c.this));
          }
        }
      };
      return;
    }
  }
  
  public final void a(String paramString, boolean paramBoolean, EnumSet<b> paramEnumSet, int paramInt)
  {
    if (((!av.e()) && (av.g())) || ((av.f()) && (!av.d()) && ((paramInt == -1) || (md.a(this.j) <= paramInt))))
    {
      Log.d("UNCAUGHT EXCEPTION", new mb(paramString));
      a(false, paramBoolean, true, false, paramEnumSet, null, null);
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, EnumSet<b> paramEnumSet, File paramFile, String paramString)
  {
    NetworkInfo localNetworkInfo = null;
    ConnectivityManager localConnectivityManager = this.k.e;
    if (localConnectivityManager == null) {
      Log.w("crashlogs/upload cm=null");
    }
    while ((localNetworkInfo != null) && (localNetworkInfo.isRoaming()) && (!paramBoolean2))
    {
      Log.i("crashlogs/upload/roaming/skip");
      return;
      localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
    }
    try
    {
      bu.a(d.a(this, paramBoolean4, d(), paramBoolean1, paramBoolean2, paramBoolean3, paramEnumSet, paramFile, paramString));
      return;
    }
    catch (Exception paramEnumSet)
    {
      Log.d("crashlogs/upload/failed", paramEnumSet);
    }
  }
  
  /* Error */
  final boolean a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, EnumSet<b> paramEnumSet, File paramFile, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 407	com/whatsapp/util/Log:d	()Z
    //   3: ifne +11 -> 14
    //   6: ldc_w 409
    //   9: invokestatic 375	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   12: iconst_0
    //   13: ireturn
    //   14: iconst_0
    //   15: istore 9
    //   17: iconst_0
    //   18: istore 11
    //   20: iconst_0
    //   21: istore 12
    //   23: iconst_0
    //   24: istore 8
    //   26: invokestatic 410	com/whatsapp/util/Log:e	()Ljava/io/File;
    //   29: astore 15
    //   31: invokestatic 415	com/whatsapp/vv:a	()Lcom/whatsapp/vv;
    //   34: aload 15
    //   36: invokestatic 420	a/a/a/a/d:a	(Lcom/whatsapp/vv;Ljava/io/File;)Ljava/io/File;
    //   39: astore 16
    //   41: aload 16
    //   43: ifnull +75 -> 118
    //   46: ldc_w 422
    //   49: astore 19
    //   51: aload 6
    //   53: ifnull +26 -> 79
    //   56: iload 11
    //   58: istore 9
    //   60: aload 16
    //   62: astore 18
    //   64: aload 15
    //   66: astore 17
    //   68: iload 12
    //   70: istore 10
    //   72: aload 6
    //   74: invokevirtual 425	java/io/File:getPath	()Ljava/lang/String;
    //   77: astore 19
    //   79: iload 11
    //   81: istore 9
    //   83: aload 16
    //   85: astore 18
    //   87: aload 15
    //   89: astore 17
    //   91: iload 12
    //   93: istore 10
    //   95: aload 16
    //   97: invokevirtual 425	java/io/File:getPath	()Ljava/lang/String;
    //   100: aload 19
    //   102: aload_1
    //   103: iload_3
    //   104: iload 4
    //   106: aload 5
    //   108: invokestatic 427	com/whatsapp/util/a/c:a	(Ljava/util/EnumSet;)Ljava/lang/String;
    //   111: aload 7
    //   113: invokestatic 429	com/whatsapp/util/a/c:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;)Z
    //   116: istore 8
    //   118: iload_2
    //   119: ifeq +23 -> 142
    //   122: iload 8
    //   124: istore 9
    //   126: aload 16
    //   128: astore 18
    //   130: aload 15
    //   132: astore 17
    //   134: iload 8
    //   136: istore 10
    //   138: invokestatic 431	com/whatsapp/util/Log:g	()Ljava/io/File;
    //   141: pop
    //   142: aload 16
    //   144: ifnull +85 -> 229
    //   147: iload 8
    //   149: ifne +80 -> 229
    //   152: invokestatic 437	java/lang/System:currentTimeMillis	()J
    //   155: lstore 13
    //   157: aload 16
    //   159: lload 13
    //   161: invokestatic 439	com/whatsapp/util/a/c:a	(Ljava/io/File;J)Ljava/io/File;
    //   164: astore 17
    //   166: aload 6
    //   168: invokestatic 441	com/whatsapp/util/a/c:b	(Ljava/io/File;)Ljava/io/File;
    //   171: astore 18
    //   173: ldc_w 422
    //   176: astore 6
    //   178: aload 17
    //   180: ifnull +49 -> 229
    //   183: aload 18
    //   185: ifnull +10 -> 195
    //   188: aload 18
    //   190: invokevirtual 425	java/io/File:getPath	()Ljava/lang/String;
    //   193: astore 6
    //   195: new 10	com/whatsapp/util/a/c$a
    //   198: dup
    //   199: aload 17
    //   201: invokevirtual 425	java/io/File:getPath	()Ljava/lang/String;
    //   204: aload 6
    //   206: aload_1
    //   207: iload_3
    //   208: iload 4
    //   210: aload 5
    //   212: invokestatic 427	com/whatsapp/util/a/c:a	(Ljava/util/EnumSet;)Ljava/lang/String;
    //   215: aload 7
    //   217: lload 13
    //   219: invokespecial 444	com/whatsapp/util/a/c$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;J)V
    //   222: invokestatic 446	com/whatsapp/util/a/c:a	(Lcom/whatsapp/util/a/c$a;)V
    //   225: aload_0
    //   226: invokespecial 448	com/whatsapp/util/a/c:g	()V
    //   229: iload 8
    //   231: istore_3
    //   232: aload 16
    //   234: ifnull +320 -> 554
    //   237: iload 8
    //   239: istore_3
    //   240: aload 16
    //   242: aload 15
    //   244: if_acmpeq +310 -> 554
    //   247: aload 16
    //   249: invokevirtual 451	java/io/File:delete	()Z
    //   252: pop
    //   253: iload 8
    //   255: ireturn
    //   256: astore 19
    //   258: aconst_null
    //   259: astore 16
    //   261: aconst_null
    //   262: astore 15
    //   264: iload 9
    //   266: istore_2
    //   267: iload_2
    //   268: istore 9
    //   270: aload 16
    //   272: astore 18
    //   274: aload 15
    //   276: astore 17
    //   278: ldc_w 453
    //   281: aload 19
    //   283: invokestatic 361	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   286: aload 16
    //   288: ifnull +84 -> 372
    //   291: iload_2
    //   292: ifne +80 -> 372
    //   295: invokestatic 437	java/lang/System:currentTimeMillis	()J
    //   298: lstore 13
    //   300: aload 16
    //   302: lload 13
    //   304: invokestatic 439	com/whatsapp/util/a/c:a	(Ljava/io/File;J)Ljava/io/File;
    //   307: astore 17
    //   309: aload 6
    //   311: invokestatic 441	com/whatsapp/util/a/c:b	(Ljava/io/File;)Ljava/io/File;
    //   314: astore 18
    //   316: ldc_w 422
    //   319: astore 6
    //   321: aload 17
    //   323: ifnull +49 -> 372
    //   326: aload 18
    //   328: ifnull +10 -> 338
    //   331: aload 18
    //   333: invokevirtual 425	java/io/File:getPath	()Ljava/lang/String;
    //   336: astore 6
    //   338: new 10	com/whatsapp/util/a/c$a
    //   341: dup
    //   342: aload 17
    //   344: invokevirtual 425	java/io/File:getPath	()Ljava/lang/String;
    //   347: aload 6
    //   349: aload_1
    //   350: iload_3
    //   351: iload 4
    //   353: aload 5
    //   355: invokestatic 427	com/whatsapp/util/a/c:a	(Ljava/util/EnumSet;)Ljava/lang/String;
    //   358: aload 7
    //   360: lload 13
    //   362: invokespecial 444	com/whatsapp/util/a/c$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;J)V
    //   365: invokestatic 446	com/whatsapp/util/a/c:a	(Lcom/whatsapp/util/a/c$a;)V
    //   368: aload_0
    //   369: invokespecial 448	com/whatsapp/util/a/c:g	()V
    //   372: iload_2
    //   373: istore_3
    //   374: aload 16
    //   376: ifnull +178 -> 554
    //   379: iload_2
    //   380: istore_3
    //   381: aload 16
    //   383: aload 15
    //   385: if_acmpeq +169 -> 554
    //   388: aload 16
    //   390: invokevirtual 451	java/io/File:delete	()Z
    //   393: pop
    //   394: iload_2
    //   395: ireturn
    //   396: astore 16
    //   398: aconst_null
    //   399: astore 18
    //   401: aconst_null
    //   402: astore 15
    //   404: iconst_0
    //   405: istore_2
    //   406: aload 18
    //   408: ifnull +84 -> 492
    //   411: iload_2
    //   412: ifne +80 -> 492
    //   415: invokestatic 437	java/lang/System:currentTimeMillis	()J
    //   418: lstore 13
    //   420: aload 18
    //   422: lload 13
    //   424: invokestatic 439	com/whatsapp/util/a/c:a	(Ljava/io/File;J)Ljava/io/File;
    //   427: astore 17
    //   429: aload 6
    //   431: invokestatic 441	com/whatsapp/util/a/c:b	(Ljava/io/File;)Ljava/io/File;
    //   434: astore 19
    //   436: ldc_w 422
    //   439: astore 6
    //   441: aload 17
    //   443: ifnull +49 -> 492
    //   446: aload 19
    //   448: ifnull +10 -> 458
    //   451: aload 19
    //   453: invokevirtual 425	java/io/File:getPath	()Ljava/lang/String;
    //   456: astore 6
    //   458: new 10	com/whatsapp/util/a/c$a
    //   461: dup
    //   462: aload 17
    //   464: invokevirtual 425	java/io/File:getPath	()Ljava/lang/String;
    //   467: aload 6
    //   469: aload_1
    //   470: iload_3
    //   471: iload 4
    //   473: aload 5
    //   475: invokestatic 427	com/whatsapp/util/a/c:a	(Ljava/util/EnumSet;)Ljava/lang/String;
    //   478: aload 7
    //   480: lload 13
    //   482: invokespecial 444	com/whatsapp/util/a/c$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;J)V
    //   485: invokestatic 446	com/whatsapp/util/a/c:a	(Lcom/whatsapp/util/a/c$a;)V
    //   488: aload_0
    //   489: invokespecial 448	com/whatsapp/util/a/c:g	()V
    //   492: aload 18
    //   494: ifnull +16 -> 510
    //   497: aload 18
    //   499: aload 15
    //   501: if_acmpeq +9 -> 510
    //   504: aload 18
    //   506: invokevirtual 451	java/io/File:delete	()Z
    //   509: pop
    //   510: aload 16
    //   512: athrow
    //   513: astore 16
    //   515: aconst_null
    //   516: astore 18
    //   518: iconst_0
    //   519: istore_2
    //   520: goto -114 -> 406
    //   523: astore 16
    //   525: iload 9
    //   527: istore_2
    //   528: aload 17
    //   530: astore 15
    //   532: goto -126 -> 406
    //   535: astore 19
    //   537: aconst_null
    //   538: astore 16
    //   540: iload 9
    //   542: istore_2
    //   543: goto -276 -> 267
    //   546: astore 19
    //   548: iload 10
    //   550: istore_2
    //   551: goto -284 -> 267
    //   554: iload_3
    //   555: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	556	0	this	c
    //   0	556	1	paramString1	String
    //   0	556	2	paramBoolean1	boolean
    //   0	556	3	paramBoolean2	boolean
    //   0	556	4	paramBoolean3	boolean
    //   0	556	5	paramEnumSet	EnumSet<b>
    //   0	556	6	paramFile	File
    //   0	556	7	paramString2	String
    //   24	230	8	bool1	boolean
    //   15	526	9	bool2	boolean
    //   70	479	10	bool3	boolean
    //   18	62	11	bool4	boolean
    //   21	71	12	bool5	boolean
    //   155	326	13	l1	long
    //   29	502	15	localObject1	Object
    //   39	350	16	localFile1	File
    //   396	115	16	localObject2	Object
    //   513	1	16	localObject3	Object
    //   523	1	16	localObject4	Object
    //   538	1	16	localObject5	Object
    //   66	463	17	localObject6	Object
    //   62	455	18	localFile2	File
    //   49	52	19	str	String
    //   256	26	19	localException1	Exception
    //   434	18	19	localFile3	File
    //   535	1	19	localException2	Exception
    //   546	1	19	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   26	31	256	java/lang/Exception
    //   26	31	396	finally
    //   31	41	513	finally
    //   72	79	523	finally
    //   95	118	523	finally
    //   138	142	523	finally
    //   278	286	523	finally
    //   31	41	535	java/lang/Exception
    //   72	79	546	java/lang/Exception
    //   95	118	546	java/lang/Exception
    //   138	142	546	java/lang/Exception
  }
  
  public final void b()
  {
    if ((this.d.exists()) && (!this.d.delete())) {
      Log.w("crashlogs/failed-delete-crash-sentinel-file");
    }
  }
  
  public final File c()
  {
    if (!this.d.createNewFile()) {
      Log.w("mediatranscodequeue/failed-to-create/" + this.d.getAbsolutePath());
    }
    return this.d;
  }
  
  public final String d()
  {
    Object localObject = this.i.b;
    if (localObject != null) {
      localObject = ((Me)localObject).jabber_id;
    }
    do
    {
      return (String)localObject;
      str = this.l.l().toLowerCase().replaceAll("\\W", "-");
      localObject = str;
    } while (!str.equals(""));
    localObject = this.k.f;
    if (localObject == null)
    {
      Log.w("crashlogs/get-from-parameter cr=null");
      return str;
    }
    String str = Settings.Secure.getString((ContentResolver)localObject, "android_id");
    if (str != null)
    {
      localObject = str;
      if (str.length() >= 6) {}
    }
    else
    {
      localObject = "123456";
    }
    return "new-" + ((String)localObject).substring(((String)localObject).length() - 6, ((String)localObject).length());
  }
  
  static final class a
    implements Serializable
  {
    String a;
    String b;
    String c;
    boolean d;
    boolean e;
    String f;
    String g;
    long h;
    
    public a(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4, String paramString5, long paramLong)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.d = paramBoolean1;
      this.e = paramBoolean2;
      this.f = paramString4;
      this.g = paramString5;
      this.h = paramLong;
    }
  }
  
  public static enum b
  {
    final String c;
    
    private b(String paramString)
    {
      this.c = paramString;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */