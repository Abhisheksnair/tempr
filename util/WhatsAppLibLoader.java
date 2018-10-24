package com.whatsapp.util;

import com.whatsapp.Voip;
import com.whatsapp.au;
import com.whatsapp.av;
import java.util.Arrays;

public class WhatsAppLibLoader
{
  private static String a = "UNKNOWN_VERSION";
  private static Boolean b = null;
  
  /* Error */
  private static java.util.List<java.io.File> a(android.content.Context paramContext, java.util.zip.ZipFile paramZipFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 22	java/util/ArrayList
    //   6: dup
    //   7: bipush 8
    //   9: invokespecial 26	java/util/ArrayList:<init>	(I)V
    //   12: astore 7
    //   14: new 28	java/lang/StringBuilder
    //   17: dup
    //   18: ldc 30
    //   20: invokespecial 33	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: aload_2
    //   24: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc 39
    //   29: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: astore_2
    //   36: sipush 8192
    //   39: newarray <illegal type>
    //   41: astore 8
    //   43: aload_1
    //   44: invokevirtual 49	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   47: astore 9
    //   49: aload 9
    //   51: invokeinterface 55 1 0
    //   56: ifeq +220 -> 276
    //   59: aload 9
    //   61: invokeinterface 59 1 0
    //   66: checkcast 61	java/util/zip/ZipEntry
    //   69: astore 5
    //   71: aload 5
    //   73: invokevirtual 64	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   76: astore 6
    //   78: aload 6
    //   80: aload_2
    //   81: invokevirtual 70	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   84: ifeq -35 -> 49
    //   87: aload 6
    //   89: ldc 72
    //   91: invokevirtual 75	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   94: ifeq -45 -> 49
    //   97: aload 6
    //   99: ldc 77
    //   101: invokevirtual 81	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   104: astore 6
    //   106: aload 6
    //   108: aload 6
    //   110: arraylength
    //   111: iconst_1
    //   112: isub
    //   113: aaload
    //   114: astore 6
    //   116: new 83	java/io/File
    //   119: dup
    //   120: aload_0
    //   121: invokevirtual 89	android/content/Context:getFilesDir	()Ljava/io/File;
    //   124: aload 6
    //   126: invokespecial 92	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   129: astore 10
    //   131: aload_1
    //   132: aload 5
    //   134: invokevirtual 96	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   137: astore 5
    //   139: new 98	java/io/FileOutputStream
    //   142: dup
    //   143: aload 10
    //   145: invokespecial 101	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   148: astore 6
    //   150: aload 5
    //   152: aload 8
    //   154: invokevirtual 107	java/io/InputStream:read	([B)I
    //   157: istore_3
    //   158: iload_3
    //   159: ifle +58 -> 217
    //   162: aload 6
    //   164: aload 8
    //   166: iconst_0
    //   167: iload_3
    //   168: invokevirtual 111	java/io/FileOutputStream:write	([BII)V
    //   171: goto -21 -> 150
    //   174: astore_0
    //   175: aload_0
    //   176: athrow
    //   177: astore_1
    //   178: aload_0
    //   179: astore_2
    //   180: aload_1
    //   181: astore_0
    //   182: aload_2
    //   183: ifnull +62 -> 245
    //   186: aload 6
    //   188: invokevirtual 114	java/io/FileOutputStream:close	()V
    //   191: aload_0
    //   192: athrow
    //   193: astore_0
    //   194: aload_0
    //   195: athrow
    //   196: astore_1
    //   197: aload_0
    //   198: astore_2
    //   199: aload_1
    //   200: astore_0
    //   201: aload 5
    //   203: ifnull +12 -> 215
    //   206: aload_2
    //   207: ifnull +53 -> 260
    //   210: aload 5
    //   212: invokevirtual 115	java/io/InputStream:close	()V
    //   215: aload_0
    //   216: athrow
    //   217: aload 6
    //   219: invokevirtual 114	java/io/FileOutputStream:close	()V
    //   222: aload 5
    //   224: ifnull +8 -> 232
    //   227: aload 5
    //   229: invokevirtual 115	java/io/InputStream:close	()V
    //   232: aload 7
    //   234: aload 10
    //   236: invokeinterface 121 2 0
    //   241: pop
    //   242: goto -193 -> 49
    //   245: aload 6
    //   247: invokevirtual 114	java/io/FileOutputStream:close	()V
    //   250: goto -59 -> 191
    //   253: astore_0
    //   254: aload 4
    //   256: astore_2
    //   257: goto -56 -> 201
    //   260: aload 5
    //   262: invokevirtual 115	java/io/InputStream:close	()V
    //   265: goto -50 -> 215
    //   268: astore_1
    //   269: goto -78 -> 191
    //   272: astore_1
    //   273: goto -58 -> 215
    //   276: aload 7
    //   278: areturn
    //   279: astore_0
    //   280: aconst_null
    //   281: astore_2
    //   282: goto -100 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	paramContext	android.content.Context
    //   0	285	1	paramZipFile	java.util.zip.ZipFile
    //   0	285	2	paramString	String
    //   157	11	3	i	int
    //   1	254	4	localObject1	Object
    //   69	192	5	localObject2	Object
    //   76	170	6	localObject3	Object
    //   12	265	7	localArrayList	java.util.ArrayList
    //   41	124	8	arrayOfByte	byte[]
    //   47	13	9	localEnumeration	java.util.Enumeration
    //   129	106	10	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   150	158	174	java/lang/Throwable
    //   162	171	174	java/lang/Throwable
    //   175	177	177	finally
    //   139	150	193	java/lang/Throwable
    //   191	193	193	java/lang/Throwable
    //   217	222	193	java/lang/Throwable
    //   245	250	193	java/lang/Throwable
    //   194	196	196	finally
    //   139	150	253	finally
    //   186	191	253	finally
    //   191	193	253	finally
    //   217	222	253	finally
    //   245	250	253	finally
    //   186	191	268	java/lang/Throwable
    //   210	215	272	java/lang/Throwable
    //   150	158	279	finally
    //   162	171	279	finally
  }
  
  private static boolean a()
  {
    byte[] arrayOfByte = new byte[3];
    try
    {
      testLibraryUsable(arrayOfByte);
      if (!Arrays.equals(new byte[] { 31, 41, 59 }, arrayOfByte))
      {
        Log.w("error: test array doesn't not match");
        return false;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
    {
      Log.c("error while testing library usability testLibraryUsable", localUnsatisfiedLinkError1);
      return false;
    }
    try
    {
      String str = getJNICodeVersion();
      Log.i("jniVersion: " + str);
      if ((!au.d().equals(str)) && (((!av.d()) && (!av.j())) || (!a.equals(str))))
      {
        Log.w("error: version does not match. JAVA version: " + au.d() + ", JNI version" + str);
        return false;
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
    {
      Log.c("error while testing library usability getJNICodeVersion", localUnsatisfiedLinkError2);
      return false;
    }
    try
    {
      Voip.getCallInfo();
      Log.i("isLibraryUsable: True");
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError3)
    {
      Log.c("error while testing library usability getCallInfo", localUnsatisfiedLinkError3);
    }
    return false;
  }
  
  /* Error */
  public static boolean a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 16	com/whatsapp/util/WhatsAppLibLoader:b	Ljava/lang/Boolean;
    //   6: ifnonnull +137 -> 143
    //   9: getstatic 195	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   12: putstatic 16	com/whatsapp/util/WhatsAppLibLoader:b	Ljava/lang/Boolean;
    //   15: ldc -59
    //   17: invokestatic 202	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   20: ldc -52
    //   22: invokestatic 202	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   25: ldc -50
    //   27: invokestatic 202	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   30: ldc -48
    //   32: invokestatic 202	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   35: ldc -46
    //   37: invokestatic 202	java/lang/System:loadLibrary	(Ljava/lang/String;)V
    //   40: getstatic 213	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   43: putstatic 16	com/whatsapp/util/WhatsAppLibLoader:b	Ljava/lang/Boolean;
    //   46: invokestatic 215	com/whatsapp/util/WhatsAppLibLoader:a	()Z
    //   49: ifne +111 -> 160
    //   52: ldc -39
    //   54: invokestatic 145	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   57: aload_0
    //   58: invokestatic 220	com/whatsapp/util/WhatsAppLibLoader:c	(Landroid/content/Context;)V
    //   61: ldc -34
    //   63: invokestatic 159	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   66: invokestatic 215	com/whatsapp/util/WhatsAppLibLoader:a	()Z
    //   69: ifne +91 -> 160
    //   72: ldc -32
    //   74: invokestatic 145	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   77: new 125	java/lang/UnsatisfiedLinkError
    //   80: dup
    //   81: ldc -30
    //   83: invokespecial 227	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   86: athrow
    //   87: astore_2
    //   88: ldc -27
    //   90: aload_2
    //   91: invokestatic 231	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   94: aload_0
    //   95: ifnull +21 -> 116
    //   98: new 233	android/os/Handler
    //   101: dup
    //   102: invokestatic 239	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   105: invokespecial 242	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   108: aload_0
    //   109: invokestatic 247	com/whatsapp/util/bt:a	(Landroid/content/Context;)Ljava/lang/Runnable;
    //   112: invokevirtual 251	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   115: pop
    //   116: iconst_0
    //   117: istore_1
    //   118: ldc 2
    //   120: monitorexit
    //   121: iload_1
    //   122: ireturn
    //   123: astore_2
    //   124: ldc -3
    //   126: aload_2
    //   127: invokestatic 151	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   130: aload_0
    //   131: invokestatic 220	com/whatsapp/util/WhatsAppLibLoader:c	(Landroid/content/Context;)V
    //   134: goto -94 -> 40
    //   137: astore_0
    //   138: ldc 2
    //   140: monitorexit
    //   141: aload_0
    //   142: athrow
    //   143: getstatic 16	com/whatsapp/util/WhatsAppLibLoader:b	Ljava/lang/Boolean;
    //   146: invokevirtual 256	java/lang/Boolean:booleanValue	()Z
    //   149: ifne +11 -> 160
    //   152: new 125	java/lang/UnsatisfiedLinkError
    //   155: dup
    //   156: invokespecial 258	java/lang/UnsatisfiedLinkError:<init>	()V
    //   159: athrow
    //   160: iconst_1
    //   161: istore_1
    //   162: goto -44 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	paramContext	android.content.Context
    //   117	45	1	bool	boolean
    //   87	4	2	localUnsatisfiedLinkError1	UnsatisfiedLinkError
    //   123	4	2	localUnsatisfiedLinkError2	UnsatisfiedLinkError
    // Exception table:
    //   from	to	target	type
    //   3	15	87	java/lang/UnsatisfiedLinkError
    //   40	87	87	java/lang/UnsatisfiedLinkError
    //   124	134	87	java/lang/UnsatisfiedLinkError
    //   143	160	87	java/lang/UnsatisfiedLinkError
    //   15	40	123	java/lang/UnsatisfiedLinkError
    //   3	15	137	finally
    //   15	40	137	finally
    //   40	87	137	finally
    //   88	94	137	finally
    //   98	116	137	finally
    //   124	134	137	finally
    //   143	160	137	finally
  }
  
  /* Error */
  @android.annotation.SuppressLint({"UnsafeDynamicallyLoadedCode"})
  private static void c(android.content.Context paramContext)
  {
    // Byte code:
    //   0: getstatic 284	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   3: ldc_w 286
    //   6: invokevirtual 70	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   9: ifeq +93 -> 102
    //   12: ldc_w 288
    //   15: astore_1
    //   16: new 45	java/util/zip/ZipFile
    //   19: dup
    //   20: new 290	android/content/ContextWrapper
    //   23: dup
    //   24: aload_0
    //   25: invokespecial 292	android/content/ContextWrapper:<init>	(Landroid/content/Context;)V
    //   28: invokevirtual 295	android/content/ContextWrapper:getPackageCodePath	()Ljava/lang/String;
    //   31: invokespecial 296	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   34: astore_3
    //   35: aconst_null
    //   36: astore_2
    //   37: aload_0
    //   38: aload_3
    //   39: aload_1
    //   40: invokestatic 298	com/whatsapp/util/WhatsAppLibLoader:a	(Landroid/content/Context;Ljava/util/zip/ZipFile;Ljava/lang/String;)Ljava/util/List;
    //   43: astore_0
    //   44: aload_0
    //   45: invokeinterface 302 1 0
    //   50: iconst_4
    //   51: if_icmpge +135 -> 186
    //   54: new 125	java/lang/UnsatisfiedLinkError
    //   57: dup
    //   58: ldc_w 304
    //   61: invokespecial 227	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   64: athrow
    //   65: astore_0
    //   66: aload_0
    //   67: athrow
    //   68: astore_1
    //   69: aload_0
    //   70: astore_2
    //   71: aload_1
    //   72: astore_0
    //   73: aload_2
    //   74: ifnull +155 -> 229
    //   77: aload_3
    //   78: invokevirtual 305	java/util/zip/ZipFile:close	()V
    //   81: aload_0
    //   82: athrow
    //   83: astore_0
    //   84: ldc_w 307
    //   87: aload_0
    //   88: invokestatic 231	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   91: new 125	java/lang/UnsatisfiedLinkError
    //   94: dup
    //   95: ldc_w 309
    //   98: invokespecial 227	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   101: athrow
    //   102: getstatic 284	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   105: ldc_w 311
    //   108: invokevirtual 70	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   111: ifeq +10 -> 121
    //   114: ldc_w 311
    //   117: astore_1
    //   118: goto -102 -> 16
    //   121: getstatic 284	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   124: ldc_w 313
    //   127: invokevirtual 70	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   130: ifeq +10 -> 140
    //   133: ldc_w 313
    //   136: astore_1
    //   137: goto -121 -> 16
    //   140: getstatic 284	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   143: ldc_w 315
    //   146: invokevirtual 70	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   149: ifeq +10 -> 159
    //   152: ldc_w 315
    //   155: astore_1
    //   156: goto -140 -> 16
    //   159: new 125	java/lang/UnsatisfiedLinkError
    //   162: dup
    //   163: new 28	java/lang/StringBuilder
    //   166: dup
    //   167: ldc_w 317
    //   170: invokespecial 33	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   173: getstatic 284	android/os/Build:CPU_ABI	Ljava/lang/String;
    //   176: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokespecial 227	java/lang/UnsatisfiedLinkError:<init>	(Ljava/lang/String;)V
    //   185: athrow
    //   186: aload_0
    //   187: invokeinterface 321 1 0
    //   192: astore_0
    //   193: aload_0
    //   194: invokeinterface 326 1 0
    //   199: ifeq +25 -> 224
    //   202: aload_0
    //   203: invokeinterface 329 1 0
    //   208: checkcast 83	java/io/File
    //   211: invokevirtual 332	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   214: invokestatic 335	java/lang/System:load	(Ljava/lang/String;)V
    //   217: goto -24 -> 193
    //   220: astore_0
    //   221: goto -148 -> 73
    //   224: aload_3
    //   225: invokevirtual 305	java/util/zip/ZipFile:close	()V
    //   228: return
    //   229: aload_3
    //   230: invokevirtual 305	java/util/zip/ZipFile:close	()V
    //   233: goto -152 -> 81
    //   236: astore_1
    //   237: goto -156 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramContext	android.content.Context
    //   15	25	1	str1	String
    //   68	4	1	localObject	Object
    //   117	39	1	str2	String
    //   236	1	1	localThrowable	Throwable
    //   36	38	2	localContext	android.content.Context
    //   34	196	3	localZipFile	java.util.zip.ZipFile
    // Exception table:
    //   from	to	target	type
    //   37	65	65	java/lang/Throwable
    //   186	193	65	java/lang/Throwable
    //   193	217	65	java/lang/Throwable
    //   66	68	68	finally
    //   16	35	83	java/io/IOException
    //   77	81	83	java/io/IOException
    //   81	83	83	java/io/IOException
    //   224	228	83	java/io/IOException
    //   229	233	83	java/io/IOException
    //   37	65	220	finally
    //   186	193	220	finally
    //   193	217	220	finally
    //   77	81	236	java/lang/Throwable
  }
  
  private static native String getJNICodeVersion();
  
  private static native void testLibraryUsable(byte[] paramArrayOfByte);
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/WhatsAppLibLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */