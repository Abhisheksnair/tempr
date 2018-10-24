package com.whatsapp.util;

import a.a.a.a.d;
import android.content.Context;
import android.os.Process;
import b.a.a.c;
import com.whatsapp.au;
import com.whatsapp.av;
import com.whatsapp.g.f;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.pv;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.GZIPOutputStream;

public class Log
{
  private static final int a = 1;
  private static AtomicReference<Context> b = new AtomicReference();
  private static AtomicReference<String> c = new AtomicReference("D")
  {
    public final void onEvent(f paramAnonymousf)
    {
      if (paramAnonymousf.a) {
        switch (paramAnonymousf.c)
        {
        default: 
          paramAnonymousf = Integer.toString(paramAnonymousf.c);
        }
      }
      for (;;)
      {
        set(paramAnonymousf);
        return;
        paramAnonymousf = "D";
        continue;
        paramAnonymousf = "M";
        continue;
        paramAnonymousf = "W";
        continue;
        paramAnonymousf = "D";
      }
    }
  };
  private static File d;
  private static File e;
  private static int f = 5;
  private static String g;
  private static boolean h;
  private static FileChannel i;
  private static final Lock j = new ReentrantLock(true);
  private static final Object k = new Object();
  private static final Object l = new Object();
  private static final CharsetEncoder m = Charset.defaultCharset().newEncoder();
  private static final ByteBuffer n = ByteBuffer.allocate(16384);
  private static final a o = a.a();
  
  /* Error */
  private static File a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 109	java/io/File:exists	()Z
    //   4: ifeq +346 -> 350
    //   7: aload_0
    //   8: new 111	java/util/Date
    //   11: dup
    //   12: invokespecial 112	java/util/Date:<init>	()V
    //   15: ldc 114
    //   17: invokestatic 119	a/a/a/a/d:a	(Ljava/io/File;Ljava/util/Date;Ljava/lang/String;)Ljava/lang/String;
    //   20: astore_2
    //   21: new 105	java/io/File
    //   24: dup
    //   25: aload_0
    //   26: invokevirtual 123	java/io/File:getParentFile	()Ljava/io/File;
    //   29: aload_2
    //   30: invokespecial 126	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   33: astore_3
    //   34: new 105	java/io/File
    //   37: dup
    //   38: aload_0
    //   39: invokevirtual 123	java/io/File:getParentFile	()Ljava/io/File;
    //   42: new 128	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   49: aload_2
    //   50: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc -121
    //   55: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokespecial 126	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   64: astore 4
    //   66: new 141	java/util/zip/GZIPOutputStream
    //   69: dup
    //   70: new 143	java/io/FileOutputStream
    //   73: dup
    //   74: aload 4
    //   76: iconst_0
    //   77: invokespecial 146	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   80: invokespecial 149	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   83: astore 5
    //   85: ldc -106
    //   87: newarray <illegal type>
    //   89: astore_0
    //   90: aload_3
    //   91: invokevirtual 154	java/io/File:length	()J
    //   94: lconst_0
    //   95: lcmp
    //   96: ifle +37 -> 133
    //   99: new 156	java/io/BufferedInputStream
    //   102: dup
    //   103: new 158	java/util/zip/GZIPInputStream
    //   106: dup
    //   107: new 160	java/io/FileInputStream
    //   110: dup
    //   111: aload_3
    //   112: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   115: invokespecial 166	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   118: invokespecial 167	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   121: astore_2
    //   122: aload 5
    //   124: aload_2
    //   125: aload_0
    //   126: invokestatic 170	com/whatsapp/util/Log:a	(Ljava/util/zip/GZIPOutputStream;Ljava/io/BufferedInputStream;[B)V
    //   129: aload_2
    //   130: invokevirtual 173	java/io/BufferedInputStream:close	()V
    //   133: new 156	java/io/BufferedInputStream
    //   136: dup
    //   137: new 160	java/io/FileInputStream
    //   140: dup
    //   141: aload_1
    //   142: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   145: invokespecial 167	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   148: astore_2
    //   149: aload 5
    //   151: aload_2
    //   152: aload_0
    //   153: invokestatic 170	com/whatsapp/util/Log:a	(Ljava/util/zip/GZIPOutputStream;Ljava/io/BufferedInputStream;[B)V
    //   156: aload_2
    //   157: invokevirtual 173	java/io/BufferedInputStream:close	()V
    //   160: aload 5
    //   162: invokevirtual 174	java/util/zip/GZIPOutputStream:close	()V
    //   165: aload 4
    //   167: aload_3
    //   168: invokevirtual 178	java/io/File:renameTo	(Ljava/io/File;)Z
    //   171: pop
    //   172: aload 4
    //   174: invokevirtual 109	java/io/File:exists	()Z
    //   177: ifeq +24 -> 201
    //   180: aload 4
    //   182: invokevirtual 181	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   185: aload_3
    //   186: invokevirtual 181	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   189: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   192: ifne +9 -> 201
    //   195: aload 4
    //   197: invokevirtual 190	java/io/File:delete	()Z
    //   200: pop
    //   201: aload_3
    //   202: invokevirtual 109	java/io/File:exists	()Z
    //   205: ifeq +145 -> 350
    //   208: aload_3
    //   209: areturn
    //   210: astore_1
    //   211: aload_1
    //   212: athrow
    //   213: astore_0
    //   214: aload_1
    //   215: ifnull +61 -> 276
    //   218: aload_2
    //   219: invokevirtual 173	java/io/BufferedInputStream:close	()V
    //   222: aload_0
    //   223: athrow
    //   224: astore_0
    //   225: aload_0
    //   226: athrow
    //   227: astore_1
    //   228: aload_0
    //   229: astore_2
    //   230: aload_1
    //   231: astore_0
    //   232: aload_2
    //   233: ifnull +77 -> 310
    //   236: aload 5
    //   238: invokevirtual 174	java/util/zip/GZIPOutputStream:close	()V
    //   241: aload_0
    //   242: athrow
    //   243: astore_0
    //   244: aload 4
    //   246: invokevirtual 109	java/io/File:exists	()Z
    //   249: ifeq -48 -> 201
    //   252: aload 4
    //   254: invokevirtual 181	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   257: aload_3
    //   258: invokevirtual 181	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   261: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   264: ifne -63 -> 201
    //   267: aload 4
    //   269: invokevirtual 190	java/io/File:delete	()Z
    //   272: pop
    //   273: goto -72 -> 201
    //   276: aload_2
    //   277: invokevirtual 173	java/io/BufferedInputStream:close	()V
    //   280: goto -58 -> 222
    //   283: astore_0
    //   284: aconst_null
    //   285: astore_2
    //   286: goto -54 -> 232
    //   289: astore_1
    //   290: aload_1
    //   291: athrow
    //   292: astore_0
    //   293: aload_1
    //   294: ifnull +9 -> 303
    //   297: aload_2
    //   298: invokevirtual 173	java/io/BufferedInputStream:close	()V
    //   301: aload_0
    //   302: athrow
    //   303: aload_2
    //   304: invokevirtual 173	java/io/BufferedInputStream:close	()V
    //   307: goto -6 -> 301
    //   310: aload 5
    //   312: invokevirtual 174	java/util/zip/GZIPOutputStream:close	()V
    //   315: goto -74 -> 241
    //   318: astore_0
    //   319: aload 4
    //   321: invokevirtual 109	java/io/File:exists	()Z
    //   324: ifeq +24 -> 348
    //   327: aload 4
    //   329: invokevirtual 181	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   332: aload_3
    //   333: invokevirtual 181	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   336: invokevirtual 187	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   339: ifne +9 -> 348
    //   342: aload 4
    //   344: invokevirtual 190	java/io/File:delete	()Z
    //   347: pop
    //   348: aload_0
    //   349: athrow
    //   350: aconst_null
    //   351: areturn
    //   352: astore_1
    //   353: goto -131 -> 222
    //   356: astore_1
    //   357: goto -56 -> 301
    //   360: astore_1
    //   361: goto -120 -> 241
    //   364: astore_0
    //   365: aconst_null
    //   366: astore_1
    //   367: goto -74 -> 293
    //   370: astore_0
    //   371: aconst_null
    //   372: astore_1
    //   373: goto -159 -> 214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	paramFile1	File
    //   0	376	1	paramFile2	File
    //   20	284	2	localObject	Object
    //   33	300	3	localFile1	File
    //   64	279	4	localFile2	File
    //   83	228	5	localGZIPOutputStream	GZIPOutputStream
    // Exception table:
    //   from	to	target	type
    //   122	129	210	java/lang/Throwable
    //   211	213	213	finally
    //   85	122	224	java/lang/Throwable
    //   129	133	224	java/lang/Throwable
    //   133	149	224	java/lang/Throwable
    //   156	160	224	java/lang/Throwable
    //   222	224	224	java/lang/Throwable
    //   276	280	224	java/lang/Throwable
    //   301	303	224	java/lang/Throwable
    //   303	307	224	java/lang/Throwable
    //   225	227	227	finally
    //   66	85	243	java/io/FileNotFoundException
    //   160	172	243	java/io/FileNotFoundException
    //   236	241	243	java/io/FileNotFoundException
    //   241	243	243	java/io/FileNotFoundException
    //   310	315	243	java/io/FileNotFoundException
    //   85	122	283	finally
    //   129	133	283	finally
    //   133	149	283	finally
    //   156	160	283	finally
    //   218	222	283	finally
    //   222	224	283	finally
    //   276	280	283	finally
    //   297	301	283	finally
    //   301	303	283	finally
    //   303	307	283	finally
    //   149	156	289	java/lang/Throwable
    //   290	292	292	finally
    //   66	85	318	finally
    //   160	172	318	finally
    //   236	241	318	finally
    //   241	243	318	finally
    //   310	315	318	finally
    //   218	222	352	java/lang/Throwable
    //   297	301	356	java/lang/Throwable
    //   236	241	360	java/lang/Throwable
    //   149	156	364	finally
    //   122	129	370	finally
  }
  
  public static String a()
  {
    return "### begin stack trace " + au.a();
  }
  
  public static String a(j paramj)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fmsg/status:").append(paramj.d).append("/type:").append(paramj.s);
    if (paramj.e.a.contains("-")) {
      localStringBuilder.append("/grp_action:").append(paramj.t);
    }
    localStringBuilder.append("/rmt-src:").append(paramj.f).append(" ").append(paramj.e.toString());
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    return a(a(paramString1, new StringBuilder(paramString2.length() + a + paramString3.length()).append(paramString2).append("\n").append(paramString3)), false);
  }
  
  private static String a(String paramString, StringBuilder paramStringBuilder)
  {
    long l1 = Thread.currentThread().getId();
    String str3 = Thread.currentThread().getName();
    String str4 = paramString + (String)c.get() + " ";
    if (f < 5) {
      return str4.length() + 20 + str3.length() + paramStringBuilder.length() + 4 + str4 + '[' + l1 + ':' + str3 + "] " + paramStringBuilder;
    }
    paramString = "";
    String str1 = "";
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int i1 = 5;
    Object localObject = str1;
    String str2 = paramString;
    if (i1 < arrayOfStackTraceElement.length)
    {
      localObject = arrayOfStackTraceElement[i1];
      if (((StackTraceElement)localObject).isNativeMethod()) {
        if (i1 == 5) {
          paramString = ((StackTraceElement)localObject).getFileName();
        }
      }
      for (str1 = "native";; str1 = String.valueOf(((StackTraceElement)localObject).getLineNumber()))
      {
        i1 += 1;
        break;
        if (((StackTraceElement)localObject).getFileName() != null) {
          break label216;
        }
        paramString = "(null)";
      }
      label216:
      str2 = ((StackTraceElement)localObject).getFileName();
      localObject = String.valueOf(((StackTraceElement)localObject).getLineNumber());
    }
    return str4.length() + 1 + 20 + 1 + str3.length() + 1 + str2.length() + 1 + ((String)localObject).length() + 1 + paramStringBuilder.length() + str4 + '[' + l1 + ':' + str3 + ']' + str2 + ':' + (String)localObject + ' ' + paramStringBuilder;
  }
  
  private static String a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) || (Thread.currentThread() == o))
    {
      f(paramString);
      return paramString;
    }
    a locala = o;
    if (Thread.currentThread() == locala)
    {
      b(2, "postLog called on the logging thread. Next log will be out of order.");
      f(paramString);
      return paramString;
    }
    locala.a(paramString);
    return paramString;
  }
  
  private static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    localPrintWriter.println(a());
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.println("### end stack trace");
    return localStringWriter.toString();
  }
  
  public static ArrayList<File> a(int paramInt)
  {
    return d.a(d, paramInt, ".gz");
  }
  
  public static void a(int paramInt, String paramString)
  {
    if (paramInt <= f)
    {
      paramString = b(b(paramInt), paramString);
      if (f == 5) {
        c(paramInt, paramString);
      }
    }
  }
  
  public static void a(Context paramContext)
  {
    if (!b.compareAndSet(null, paramContext)) {
      throw new IllegalStateException("log application context already assigned");
    }
  }
  
  public static void a(String paramString)
  {
    b("LL_A ", paramString);
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    paramString = paramString + "; exception=" + paramThrowable;
    if (f == 5) {
      c(4, a("LL_D ", paramString, a(paramThrowable)));
    }
    while (f < 4) {
      return;
    }
    a("LL_D ", paramString, a(paramThrowable));
  }
  
  private static void a(FileChannel paramFileChannel, CharsetEncoder paramCharsetEncoder, ByteBuffer paramByteBuffer, CharSequence paramCharSequence)
  {
    CharBuffer localCharBuffer = CharBuffer.wrap(paramCharSequence);
    paramCharsetEncoder.reset();
    paramCharsetEncoder.onMalformedInput(CodingErrorAction.REPLACE);
    paramCharsetEncoder.onUnmappableCharacter(CodingErrorAction.REPLACE);
    paramByteBuffer.clear();
    paramCharSequence = CoderResult.OVERFLOW;
    while (paramCharSequence.isOverflow())
    {
      paramCharSequence = paramCharsetEncoder.encode(localCharBuffer, paramByteBuffer, true);
      paramByteBuffer.flip();
      if (paramCharSequence.isError()) {
        paramCharSequence.throwException();
      }
      paramFileChannel.write(paramByteBuffer);
      paramByteBuffer.clear();
    }
  }
  
  private static void a(GZIPOutputStream paramGZIPOutputStream, BufferedInputStream paramBufferedInputStream, byte[] paramArrayOfByte)
  {
    for (int i1 = paramBufferedInputStream.read(paramArrayOfByte, 0, 32768); i1 != -1; i1 = paramBufferedInputStream.read(paramArrayOfByte, 0, 32768)) {
      paramGZIPOutputStream.write(paramArrayOfByte, 0, i1);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      b("LL_A ", "Assertion Failed");
    }
  }
  
  public static String b()
  {
    return "### end stack trace";
  }
  
  private static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Invalid log level " + paramInt);
    case 0: 
      return "LL_A ";
    case 1: 
      return "LL_E ";
    case 2: 
      return "LL_W ";
    case 3: 
      return "LL_I ";
    case 4: 
      return "LL_D ";
    }
    return "LL_V ";
  }
  
  private static String b(String paramString1, String paramString2)
  {
    return a(a(paramString1, new StringBuilder(paramString2)), false);
  }
  
  public static void b(int paramInt, String paramString)
  {
    if (paramInt <= f)
    {
      paramString = c(b(paramInt), paramString);
      if (f == 5) {
        c(paramInt, paramString);
      }
    }
  }
  
  public static void b(String paramString, Throwable paramThrowable)
  {
    paramString = paramString + "; exception=" + paramThrowable;
    if (f == 5) {
      c(3, a("LL_I ", paramString, a(paramThrowable)));
    }
    while (f < 3) {
      return;
    }
    a("LL_I ", paramString, a(paramThrowable));
  }
  
  private static String c(String paramString1, String paramString2)
  {
    return a(a(paramString1, new StringBuilder(paramString2)), true);
  }
  
  public static void c()
  {
    f = av.a();
    b("LL_I ", "==== logfile version=" + au.d() + " level=" + f + " tz=" + g + " ====");
  }
  
  private static void c(int paramInt, String paramString)
  {
    while (paramString.length() > 4000)
    {
      String str = paramString.substring(0, 3997);
      paramString = "..." + paramString.substring(3997);
      d(paramInt, str + "...");
    }
    d(paramInt, paramString);
  }
  
  public static void c(String paramString, Throwable paramThrowable)
  {
    paramString = paramString + "; exception=" + paramThrowable;
    if (f == 5) {
      c(2, a("LL_W ", paramString, a(paramThrowable)));
    }
    while (f < 2) {
      return;
    }
    a("LL_W ", paramString, a(paramThrowable));
  }
  
  private static void d(int paramInt, String paramString)
  {
    if ((paramInt == 0) || (paramInt == 5)) {
      android.util.Log.v("WhatsApp", paramString);
    }
    do
    {
      do
      {
        return;
        if (paramInt == 4)
        {
          android.util.Log.d("WhatsApp", paramString);
          return;
        }
        if (paramInt == 3)
        {
          android.util.Log.i("WhatsApp", paramString);
          return;
        }
        if (paramInt == 2)
        {
          android.util.Log.w("WhatsApp", paramString);
          return;
        }
      } while (paramInt != 1);
      android.util.Log.e("WhatsApp", paramString);
    } while (!av.d());
    pv localpv = pv.a();
    StringBuilder localStringBuilder = new StringBuilder("Error: ");
    if (paramString.length() <= 50) {}
    for (;;)
    {
      localpv.a(paramString);
      return;
      paramString = paramString.substring(0, 47) + "…";
    }
  }
  
  public static void d(String paramString)
  {
    if (f == 5) {
      c(4, b("LL_D ", paramString));
    }
    while (f < 4) {
      return;
    }
    b("LL_D ", paramString);
  }
  
  public static void d(String paramString, Throwable paramThrowable)
  {
    paramString = paramString + "; exception=" + paramThrowable;
    if (f == 5) {
      c(1, a("LL_E ", paramString, a(paramThrowable)));
    }
    while (f <= 0) {
      return;
    }
    a("LL_E ", paramString, a(paramThrowable));
  }
  
  public static void d(Throwable paramThrowable)
  {
    if (f == 5) {
      c(4, b("LL_D ", a(paramThrowable)));
    }
    while (f < 4) {
      return;
    }
    b("LL_D ", a(paramThrowable));
  }
  
  public static boolean d()
  {
    if (j())
    {
      synchronized (k)
      {
        j.lock();
      }
      try
      {
        i.close();
        boolean bool = d.a(d, e);
        h = false;
        j();
        j.unlock();
        return bool;
      }
      catch (IOException localIOException)
      {
        j.unlock();
        return false;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      finally
      {
        j.unlock();
      }
    }
    return false;
  }
  
  /* Error */
  public static File e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_0
    //   2: invokestatic 518	com/whatsapp/util/Log:j	()Z
    //   5: ifeq +123 -> 128
    //   8: new 128	java/lang/StringBuilder
    //   11: dup
    //   12: ldc_w 540
    //   15: invokespecial 193	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: new 111	java/util/Date
    //   21: dup
    //   22: invokespecial 112	java/util/Date:<init>	()V
    //   25: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 542	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   34: getstatic 72	com/whatsapp/util/Log:l	Ljava/lang/Object;
    //   37: astore_3
    //   38: aload_3
    //   39: monitorenter
    //   40: getstatic 70	com/whatsapp/util/Log:k	Ljava/lang/Object;
    //   43: astore 4
    //   45: aload 4
    //   47: monitorenter
    //   48: invokestatic 545	com/whatsapp/util/Log:k	()Ljava/util/ArrayList;
    //   51: invokevirtual 551	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   54: astore 5
    //   56: aconst_null
    //   57: astore_0
    //   58: aload_0
    //   59: astore_2
    //   60: aload_0
    //   61: astore_1
    //   62: aload 5
    //   64: invokeinterface 556 1 0
    //   69: ifeq +61 -> 130
    //   72: aload_0
    //   73: astore_2
    //   74: aload_0
    //   75: astore_1
    //   76: aload 5
    //   78: invokeinterface 559 1 0
    //   83: checkcast 105	java/io/File
    //   86: astore 6
    //   88: aload_0
    //   89: astore_2
    //   90: aload_0
    //   91: astore_1
    //   92: getstatic 343	com/whatsapp/util/Log:d	Ljava/io/File;
    //   95: aload 6
    //   97: invokestatic 561	com/whatsapp/util/Log:a	(Ljava/io/File;Ljava/io/File;)Ljava/io/File;
    //   100: astore_0
    //   101: aload_0
    //   102: astore_2
    //   103: aload_0
    //   104: astore_1
    //   105: aload 6
    //   107: invokevirtual 190	java/io/File:delete	()Z
    //   110: pop
    //   111: goto -53 -> 58
    //   114: astore_0
    //   115: aload_0
    //   116: astore_1
    //   117: aload_2
    //   118: astore_0
    //   119: aload_1
    //   120: invokestatic 563	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   123: aload 4
    //   125: monitorexit
    //   126: aload_3
    //   127: monitorexit
    //   128: aload_0
    //   129: areturn
    //   130: goto -7 -> 123
    //   133: astore_0
    //   134: aload 4
    //   136: monitorexit
    //   137: aload_0
    //   138: athrow
    //   139: astore_0
    //   140: aload_3
    //   141: monitorexit
    //   142: aload_0
    //   143: athrow
    //   144: astore_0
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_0
    //   148: astore_2
    //   149: aload_1
    //   150: astore_0
    //   151: aload_2
    //   152: astore_1
    //   153: goto -34 -> 119
    //   156: astore_0
    //   157: aconst_null
    //   158: astore_2
    //   159: goto -44 -> 115
    //   162: astore_0
    //   163: goto -16 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	103	0	localFile1	File
    //   114	2	0	localIOException1	IOException
    //   118	11	0	localObject1	Object
    //   133	5	0	localObject2	Object
    //   139	4	0	localObject3	Object
    //   144	4	0	localSecurityException1	SecurityException
    //   150	1	0	localObject4	Object
    //   156	1	0	localIOException2	IOException
    //   162	1	0	localSecurityException2	SecurityException
    //   61	92	1	localObject5	Object
    //   59	100	2	localObject6	Object
    //   37	104	3	localObject7	Object
    //   54	23	5	localIterator	java.util.Iterator
    //   86	20	6	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   62	72	114	java/io/IOException
    //   76	88	114	java/io/IOException
    //   92	101	114	java/io/IOException
    //   105	111	114	java/io/IOException
    //   48	56	133	finally
    //   62	72	133	finally
    //   76	88	133	finally
    //   92	101	133	finally
    //   105	111	133	finally
    //   119	123	133	finally
    //   123	126	133	finally
    //   134	137	133	finally
    //   40	48	139	finally
    //   126	128	139	finally
    //   137	139	139	finally
    //   140	142	139	finally
    //   48	56	144	java/lang/SecurityException
    //   48	56	156	java/io/IOException
    //   62	72	162	java/lang/SecurityException
    //   76	88	162	java/lang/SecurityException
    //   92	101	162	java/lang/SecurityException
    //   105	111	162	java/lang/SecurityException
  }
  
  public static void e(String paramString)
  {
    if (f == 5) {
      c(1, b("LL_E ", paramString));
    }
    while (f <= 0) {
      return;
    }
    b("LL_E ", paramString);
  }
  
  public static void e(Throwable paramThrowable)
  {
    if (f == 5) {
      c(1, b("LL_E ", a(paramThrowable)));
    }
    while (f <= 0) {
      return;
    }
    b("LL_E ", a(paramThrowable));
  }
  
  public static void f()
  {
    d.a(d, 3, ".gz", true);
  }
  
  private static void f(String paramString)
  {
    StringBuilder localStringBuilder;
    if (j())
    {
      localStringBuilder = new StringBuilder();
      localObject1 = Calendar.getInstance();
      localStringBuilder.append(((Calendar)localObject1).get(1)).append('-');
      if (((Calendar)localObject1).get(2) < 9) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(((Calendar)localObject1).get(2) + 1).append('-');
      if (((Calendar)localObject1).get(5) < 10) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(((Calendar)localObject1).get(5)).append(' ');
      if (((Calendar)localObject1).get(11) < 10) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(((Calendar)localObject1).get(11)).append(':');
      if (((Calendar)localObject1).get(12) < 10) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(((Calendar)localObject1).get(12)).append(':');
      if (((Calendar)localObject1).get(13) < 10) {
        localStringBuilder.append('0');
      }
      localStringBuilder.append(((Calendar)localObject1).get(13)).append('.');
      if (((Calendar)localObject1).get(14) >= 10) {
        break label331;
      }
      localStringBuilder.append("00");
    }
    for (;;)
    {
      localStringBuilder.append(((Calendar)localObject1).get(14)).append(' ');
      j.lock();
      localObject1 = null;
      try
      {
        localFileLock = i.lock();
        localObject1 = localFileLock;
        i.position(i.size());
        localObject1 = localFileLock;
        a(i, m, n, localStringBuilder);
        localObject1 = localFileLock;
        a(i, m, n, paramString);
        localObject1 = localFileLock;
        a(i, m, n, "\n");
        if (localFileLock == null) {}
      }
      finally
      {
        FileLock localFileLock;
        label331:
        if (localObject1 != null) {
          ((FileLock)localObject1).release();
        }
      }
      try
      {
        localFileLock.release();
        return;
      }
      catch (IOException localIOException)
      {
        android.util.Log.e("WhatsApp", "IOException on " + paramString, localIOException);
        return;
      }
      finally
      {
        j.unlock();
      }
      if (((Calendar)localObject1).get(14) < 100) {
        localStringBuilder.append('0');
      }
    }
  }
  
  public static File g()
  {
    return d.b(d, ".gz");
  }
  
  /* Error */
  public static void h()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iconst_5
    //   3: ldc_w 608
    //   6: invokestatic 317	com/whatsapp/util/Log:b	(ILjava/lang/String;)V
    //   9: getstatic 97	com/whatsapp/util/Log:o	Lcom/whatsapp/util/Log$a;
    //   12: astore 5
    //   14: invokestatic 266	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   17: aload 5
    //   19: if_acmpne +33 -> 52
    //   22: aload 5
    //   24: getfield 611	com/whatsapp/util/Log$a:b	Ljava/util/concurrent/BlockingQueue;
    //   27: invokeinterface 615 1 0
    //   32: istore_1
    //   33: iconst_0
    //   34: istore_0
    //   35: iload_0
    //   36: iload_1
    //   37: if_icmpge +59 -> 96
    //   40: aload 5
    //   42: invokevirtual 617	com/whatsapp/util/Log$a:b	()V
    //   45: iload_0
    //   46: iconst_1
    //   47: iadd
    //   48: istore_0
    //   49: goto -14 -> 35
    //   52: new 619	java/util/concurrent/FutureTask
    //   55: dup
    //   56: getstatic 622	com/whatsapp/util/Log$a:a	Ljava/lang/Runnable;
    //   59: aconst_null
    //   60: invokespecial 625	java/util/concurrent/FutureTask:<init>	(Ljava/lang/Runnable;Ljava/lang/Object;)V
    //   63: astore 4
    //   65: aload 5
    //   67: aload 4
    //   69: invokevirtual 320	com/whatsapp/util/Log$a:a	(Ljava/lang/Object;)V
    //   72: aload 4
    //   74: invokevirtual 628	java/util/concurrent/FutureTask:isDone	()Z
    //   77: istore_2
    //   78: iload_2
    //   79: ifne +17 -> 96
    //   82: aload 4
    //   84: invokevirtual 629	java/util/concurrent/FutureTask:get	()Ljava/lang/Object;
    //   87: pop
    //   88: goto -16 -> 72
    //   91: astore 5
    //   93: goto -21 -> 72
    //   96: iconst_5
    //   97: ldc_w 631
    //   100: invokestatic 317	com/whatsapp/util/Log:b	(ILjava/lang/String;)V
    //   103: iconst_5
    //   104: ldc_w 633
    //   107: invokestatic 317	com/whatsapp/util/Log:b	(ILjava/lang/String;)V
    //   110: getstatic 67	com/whatsapp/util/Log:j	Ljava/util/concurrent/locks/Lock;
    //   113: invokeinterface 523 1 0
    //   118: getstatic 533	com/whatsapp/util/Log:h	Z
    //   121: istore_2
    //   122: iload_2
    //   123: ifeq +31 -> 154
    //   126: getstatic 525	com/whatsapp/util/Log:i	Ljava/nio/channels/FileChannel;
    //   129: invokevirtual 580	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   132: astore 4
    //   134: aload 4
    //   136: astore_3
    //   137: getstatic 525	com/whatsapp/util/Log:i	Ljava/nio/channels/FileChannel;
    //   140: iconst_1
    //   141: invokevirtual 636	java/nio/channels/FileChannel:force	(Z)V
    //   144: aload 4
    //   146: ifnull +8 -> 154
    //   149: aload 4
    //   151: invokevirtual 594	java/nio/channels/FileLock:release	()V
    //   154: getstatic 67	com/whatsapp/util/Log:j	Ljava/util/concurrent/locks/Lock;
    //   157: invokeinterface 536 1 0
    //   162: iconst_5
    //   163: ldc_w 638
    //   166: invokestatic 317	com/whatsapp/util/Log:b	(ILjava/lang/String;)V
    //   169: return
    //   170: astore 4
    //   172: aload_3
    //   173: ifnull +7 -> 180
    //   176: aload_3
    //   177: invokevirtual 594	java/nio/channels/FileLock:release	()V
    //   180: aload 4
    //   182: athrow
    //   183: astore_3
    //   184: getstatic 67	com/whatsapp/util/Log:j	Ljava/util/concurrent/locks/Lock;
    //   187: invokeinterface 536 1 0
    //   192: aload_3
    //   193: athrow
    //   194: astore 5
    //   196: getstatic 60	com/whatsapp/util/Log:f	I
    //   199: ifle -30 -> 169
    //   202: iconst_1
    //   203: invokestatic 350	com/whatsapp/util/Log:b	(I)Ljava/lang/String;
    //   206: astore_3
    //   207: new 128	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   214: ldc_w 640
    //   217: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: ldc_w 367
    //   223: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload 5
    //   228: invokevirtual 370	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: astore 4
    //   236: aload 5
    //   238: invokestatic 374	com/whatsapp/util/Log:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   241: astore 5
    //   243: aload_3
    //   244: new 128	java/lang/StringBuilder
    //   247: dup
    //   248: aload 4
    //   250: invokevirtual 249	java/lang/String:length	()I
    //   253: getstatic 44	com/whatsapp/util/Log:a	I
    //   256: iadd
    //   257: aload 5
    //   259: invokevirtual 249	java/lang/String:length	()I
    //   262: iadd
    //   263: invokespecial 252	java/lang/StringBuilder:<init>	(I)V
    //   266: aload 4
    //   268: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: ldc -2
    //   273: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   276: aload 5
    //   278: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: invokestatic 257	com/whatsapp/util/Log:a	(Ljava/lang/String;Ljava/lang/StringBuilder;)Ljava/lang/String;
    //   284: iconst_1
    //   285: invokestatic 260	com/whatsapp/util/Log:a	(Ljava/lang/String;Z)Ljava/lang/String;
    //   288: astore_3
    //   289: getstatic 60	com/whatsapp/util/Log:f	I
    //   292: iconst_5
    //   293: if_icmpne -124 -> 169
    //   296: iconst_1
    //   297: aload_3
    //   298: invokestatic 352	com/whatsapp/util/Log:c	(ILjava/lang/String;)V
    //   301: return
    //   302: astore 5
    //   304: goto -232 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	15	0	i1	int
    //   32	6	1	i2	int
    //   77	46	2	bool	boolean
    //   1	176	3	localObject1	Object
    //   183	10	3	localObject2	Object
    //   206	92	3	str1	String
    //   63	87	4	localObject3	Object
    //   170	11	4	localObject4	Object
    //   234	33	4	str2	String
    //   12	54	5	locala	a
    //   91	1	5	localInterruptedException	InterruptedException
    //   194	43	5	localIOException	IOException
    //   241	36	5	str3	String
    //   302	1	5	localExecutionException	java.util.concurrent.ExecutionException
    // Exception table:
    //   from	to	target	type
    //   82	88	91	java/lang/InterruptedException
    //   126	134	170	finally
    //   137	144	170	finally
    //   118	122	183	finally
    //   149	154	183	finally
    //   176	180	183	finally
    //   180	183	183	finally
    //   2	33	194	java/io/IOException
    //   40	45	194	java/io/IOException
    //   52	72	194	java/io/IOException
    //   72	78	194	java/io/IOException
    //   82	88	194	java/io/IOException
    //   96	118	194	java/io/IOException
    //   154	169	194	java/io/IOException
    //   184	194	194	java/io/IOException
    //   82	88	302	java/util/concurrent/ExecutionException
  }
  
  public static void i(String paramString)
  {
    if (f == 5) {
      c(3, b("LL_I ", paramString));
    }
    while (f < 3) {
      return;
    }
    b("LL_I ", paramString);
  }
  
  public static void i(Throwable paramThrowable)
  {
    if (f == 5) {
      c(3, b("LL_I ", a(paramThrowable)));
    }
    while (f < 3) {
      return;
    }
    b("LL_I ", a(paramThrowable));
  }
  
  /* Error */
  private static boolean j()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: getstatic 533	com/whatsapp/util/Log:h	Z
    //   5: ifeq +18 -> 23
    //   8: getstatic 525	com/whatsapp/util/Log:i	Ljava/nio/channels/FileChannel;
    //   11: ifnull +12 -> 23
    //   14: getstatic 525	com/whatsapp/util/Log:i	Ljava/nio/channels/FileChannel;
    //   17: invokevirtual 643	java/nio/channels/FileChannel:isOpen	()Z
    //   20: ifne +421 -> 441
    //   23: getstatic 67	com/whatsapp/util/Log:j	Ljava/util/concurrent/locks/Lock;
    //   26: invokeinterface 523 1 0
    //   31: getstatic 533	com/whatsapp/util/Log:h	Z
    //   34: ifeq +35 -> 69
    //   37: getstatic 525	com/whatsapp/util/Log:i	Ljava/nio/channels/FileChannel;
    //   40: ifnull +29 -> 69
    //   43: getstatic 525	com/whatsapp/util/Log:i	Ljava/nio/channels/FileChannel;
    //   46: invokevirtual 643	java/nio/channels/FileChannel:isOpen	()Z
    //   49: ifeq +20 -> 69
    //   52: iconst_5
    //   53: ldc_w 645
    //   56: invokestatic 317	com/whatsapp/util/Log:b	(ILjava/lang/String;)V
    //   59: getstatic 67	com/whatsapp/util/Log:j	Ljava/util/concurrent/locks/Lock;
    //   62: invokeinterface 536 1 0
    //   67: iconst_1
    //   68: ireturn
    //   69: getstatic 51	com/whatsapp/util/Log:b	Ljava/util/concurrent/atomic/AtomicReference;
    //   72: invokevirtual 276	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   75: checkcast 647	android/content/Context
    //   78: astore 5
    //   80: aload 5
    //   82: ifnonnull +13 -> 95
    //   85: getstatic 67	com/whatsapp/util/Log:j	Ljava/util/concurrent/locks/Lock;
    //   88: invokeinterface 536 1 0
    //   93: iconst_0
    //   94: ireturn
    //   95: new 105	java/io/File
    //   98: dup
    //   99: aload 5
    //   101: invokevirtual 650	android/content/Context:getFilesDir	()Ljava/io/File;
    //   104: ldc_w 652
    //   107: invokespecial 126	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   110: astore 5
    //   112: aload 5
    //   114: invokevirtual 109	java/io/File:exists	()Z
    //   117: ifne +25 -> 142
    //   120: aload 5
    //   122: invokevirtual 655	java/io/File:mkdirs	()Z
    //   125: istore 4
    //   127: iload 4
    //   129: ifne +13 -> 142
    //   132: getstatic 67	com/whatsapp/util/Log:j	Ljava/util/concurrent/locks/Lock;
    //   135: invokeinterface 536 1 0
    //   140: iconst_0
    //   141: ireturn
    //   142: new 105	java/io/File
    //   145: dup
    //   146: aload 5
    //   148: ldc_w 657
    //   151: invokespecial 126	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   154: putstatic 343	com/whatsapp/util/Log:d	Ljava/io/File;
    //   157: new 105	java/io/File
    //   160: dup
    //   161: aload 5
    //   163: ldc_w 659
    //   166: invokespecial 126	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   169: putstatic 528	com/whatsapp/util/Log:e	Ljava/io/File;
    //   172: new 143	java/io/FileOutputStream
    //   175: dup
    //   176: getstatic 343	com/whatsapp/util/Log:d	Ljava/io/File;
    //   179: iconst_1
    //   180: invokespecial 146	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   183: invokevirtual 663	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   186: putstatic 525	com/whatsapp/util/Log:i	Ljava/nio/channels/FileChannel;
    //   189: new 665	java/io/PrintStream
    //   192: dup
    //   193: new 11	com/whatsapp/util/Log$b
    //   196: dup
    //   197: getstatic 671	java/lang/System:err	Ljava/io/PrintStream;
    //   200: getstatic 525	com/whatsapp/util/Log:i	Ljava/nio/channels/FileChannel;
    //   203: invokestatic 677	java/nio/channels/Channels:newOutputStream	(Ljava/nio/channels/WritableByteChannel;)Ljava/io/OutputStream;
    //   206: invokespecial 680	com/whatsapp/util/Log$b:<init>	(Ljava/io/OutputStream;Ljava/io/OutputStream;)V
    //   209: iconst_1
    //   210: invokespecial 683	java/io/PrintStream:<init>	(Ljava/io/OutputStream;Z)V
    //   213: invokestatic 687	java/lang/System:setErr	(Ljava/io/PrintStream;)V
    //   216: iconst_1
    //   217: putstatic 533	com/whatsapp/util/Log:h	Z
    //   220: invokestatic 572	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   223: astore 5
    //   225: aload 5
    //   227: bipush 15
    //   229: invokevirtual 575	java/util/Calendar:get	(I)I
    //   232: istore_1
    //   233: aload 5
    //   235: bipush 16
    //   237: invokevirtual 575	java/util/Calendar:get	(I)I
    //   240: iload_1
    //   241: iadd
    //   242: ldc_w 688
    //   245: idiv
    //   246: istore_1
    //   247: iload_1
    //   248: bipush 60
    //   250: idiv
    //   251: istore_2
    //   252: getstatic 694	java/util/Locale:US	Ljava/util/Locale;
    //   255: astore 5
    //   257: iload_2
    //   258: ifge +197 -> 455
    //   261: bipush 45
    //   263: istore_0
    //   264: aload 5
    //   266: ldc_w 696
    //   269: iconst_3
    //   270: anewarray 4	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: iload_0
    //   276: invokestatic 701	java/lang/Character:valueOf	(C)Ljava/lang/Character;
    //   279: aastore
    //   280: dup
    //   281: iconst_1
    //   282: iload_2
    //   283: invokestatic 706	java/lang/Math:abs	(I)I
    //   286: invokestatic 711	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   289: aastore
    //   290: dup
    //   291: iconst_2
    //   292: iload_1
    //   293: bipush 60
    //   295: irem
    //   296: invokestatic 706	java/lang/Math:abs	(I)I
    //   299: invokestatic 711	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   302: aastore
    //   303: invokestatic 715	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   306: putstatic 471	com/whatsapp/util/Log:g	Ljava/lang/String;
    //   309: ldc_w 453
    //   312: new 128	java/lang/StringBuilder
    //   315: dup
    //   316: ldc_w 717
    //   319: invokespecial 193	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   322: getstatic 60	com/whatsapp/util/Log:f	I
    //   325: invokevirtual 207	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   328: ldc_w 469
    //   331: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: getstatic 471	com/whatsapp/util/Log:g	Ljava/lang/String;
    //   337: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: ldc_w 473
    //   343: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 457	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   352: pop
    //   353: new 128	java/lang/StringBuilder
    //   356: dup
    //   357: ldc_w 719
    //   360: invokespecial 193	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   363: getstatic 723	com/whatsapp/AppShell:b	Z
    //   366: invokevirtual 726	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   369: ldc_w 728
    //   372: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: getstatic 730	com/whatsapp/AppShell:c	Z
    //   378: invokevirtual 726	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   381: ldc_w 732
    //   384: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: getstatic 734	com/whatsapp/AppShell:a	Z
    //   390: invokevirtual 726	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   393: ldc_w 736
    //   396: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: astore 5
    //   401: ldc -61
    //   403: invokevirtual 741	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   406: ldc_w 743
    //   409: invokevirtual 746	java/lang/String:contentEquals	(Ljava/lang/CharSequence;)Z
    //   412: ifne +5 -> 417
    //   415: iconst_1
    //   416: istore_3
    //   417: ldc_w 453
    //   420: aload 5
    //   422: iload_3
    //   423: invokevirtual 726	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   426: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 457	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   432: pop
    //   433: getstatic 67	com/whatsapp/util/Log:j	Ljava/util/concurrent/locks/Lock;
    //   436: invokeinterface 536 1 0
    //   441: iconst_1
    //   442: ireturn
    //   443: astore 5
    //   445: getstatic 67	com/whatsapp/util/Log:j	Ljava/util/concurrent/locks/Lock;
    //   448: invokeinterface 536 1 0
    //   453: iconst_0
    //   454: ireturn
    //   455: bipush 43
    //   457: istore_0
    //   458: goto -194 -> 264
    //   461: astore 5
    //   463: getstatic 67	com/whatsapp/util/Log:j	Ljava/util/concurrent/locks/Lock;
    //   466: invokeinterface 536 1 0
    //   471: aload 5
    //   473: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   263	195	0	c1	char
    //   232	64	1	i1	int
    //   251	32	2	i2	int
    //   1	422	3	bool1	boolean
    //   125	3	4	bool2	boolean
    //   78	343	5	localObject1	Object
    //   443	1	5	localFileNotFoundException	java.io.FileNotFoundException
    //   461	11	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   172	189	443	java/io/FileNotFoundException
    //   31	59	461	finally
    //   69	80	461	finally
    //   95	127	461	finally
    //   142	172	461	finally
    //   172	189	461	finally
    //   189	257	461	finally
    //   264	401	461	finally
    //   401	415	461	finally
    //   417	433	461	finally
  }
  
  private static ArrayList<File> k()
  {
    Object localObject = d;
    File localFile1 = e;
    ArrayList localArrayList = new ArrayList();
    int i2 = d.b((File)localObject, localFile1);
    localObject = ((File)localObject).getParent();
    int i1 = 1;
    while (i1 <= i2)
    {
      File localFile2 = new File((String)localObject, localFile1.getName() + "." + i1);
      if (localFile2.exists()) {
        localArrayList.add(localFile2);
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  public static void v(String paramString)
  {
    if (f >= 5) {
      c(5, b("LL_V ", paramString));
    }
  }
  
  public static void v(Throwable paramThrowable)
  {
    if (f >= 5) {
      c(5, b("LL_V ", a(paramThrowable)));
    }
  }
  
  public static void w(String paramString)
  {
    if (f == 5) {
      c(2, b("LL_W ", paramString));
    }
    while (f < 2) {
      return;
    }
    b("LL_W ", paramString);
  }
  
  public static void w(Throwable paramThrowable)
  {
    if (f == 5) {
      c(2, b("LL_W ", a(paramThrowable)));
    }
    while (f < 2) {
      return;
    }
    b("LL_W ", a(paramThrowable));
  }
  
  static final class a
    extends Thread
  {
    static final Runnable a = ;
    final BlockingQueue<Object> b = new ArrayBlockingQueue(2048, true);
    
    private a()
    {
      super();
    }
    
    public static a a()
    {
      a locala = new a();
      locala.start();
      return locala;
    }
    
    final void a(Object paramObject)
    {
      if (Thread.currentThread() == this)
      {
        Log.b(1, "Cannot add a log item from the logging thread. Attempting to crash.");
        throw new AssertionError("Cannot add a log item from the logging thread.");
      }
      int i = 0;
      for (;;)
      {
        try
        {
          this.b.put(paramObject);
          if (i != 0) {
            Thread.currentThread().interrupt();
          }
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          i = 1;
        }
      }
    }
    
    final void b()
    {
      Object localObject1 = null;
      for (;;)
      {
        if (localObject1 == null) {}
        try
        {
          Object localObject2 = this.b.take();
          localObject1 = localObject2;
        }
        catch (InterruptedException localInterruptedException) {}
        if ((localObject1 instanceof String))
        {
          Log.c((String)localObject1);
          return;
        }
        if ((localObject1 instanceof FutureTask))
        {
          ((FutureTask)localObject1).run();
          return;
        }
        throw new IllegalStateException("Invalid log item type");
      }
    }
    
    public final void run()
    {
      Process.setThreadPriority(10);
      for (;;)
      {
        b();
      }
    }
  }
  
  static final class b
    extends OutputStream
  {
    final OutputStream a;
    final OutputStream b;
    
    public b(OutputStream paramOutputStream1, OutputStream paramOutputStream2)
    {
      this.a = paramOutputStream1;
      this.b = paramOutputStream2;
    }
    
    public final void close()
    {
      this.a.close();
      this.b.close();
    }
    
    public final void flush()
    {
      this.a.flush();
      this.b.flush();
    }
    
    public final void write(int paramInt)
    {
      this.a.write(paramInt);
      this.b.write(paramInt);
    }
    
    public final void write(byte[] paramArrayOfByte)
    {
      this.a.write(paramArrayOfByte);
      this.b.write(paramArrayOfByte);
    }
    
    public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      this.a.write(paramArrayOfByte, paramInt1, paramInt2);
      this.b.write(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public static final class c
    extends Writer
  {
    StringBuilder a = new StringBuilder(16384);
    
    public final void close()
    {
      this.a = null;
    }
    
    public final void flush()
    {
      if (Log.i() >= 4)
      {
        if (this.a.length() >= 262144) {
          this.a.append("...");
        }
        Log.b(Log.a("LL_D ", this.a.toString()));
        this.a = new StringBuilder();
      }
    }
    
    public final void write(int paramInt)
    {
      if ((Log.i() >= 4) && (this.a.length() < 262144)) {
        this.a.append((char)paramInt);
      }
    }
    
    public final void write(String paramString, int paramInt1, int paramInt2)
    {
      if ((Log.i() >= 4) && (this.a.length() < 262144)) {
        this.a.append(paramString, paramInt1, paramInt2);
      }
    }
    
    public final void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    {
      if ((Log.i() >= 4) && (this.a.length() < 262144)) {
        this.a.append(paramArrayOfChar, paramInt1, paramInt2);
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */