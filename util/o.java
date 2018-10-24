package com.whatsapp.util;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class o
  implements Closeable
{
  private static final Charset a = Charset.forName("UTF-8");
  private final File b;
  private final File c;
  private final File d;
  private final int e;
  private final long f;
  private final int g;
  private long h = 0L;
  private Writer i;
  private final LinkedHashMap<String, b> j = new LinkedHashMap(0, 0.75F, true);
  private int k;
  private long l = 0L;
  private final ExecutorService m = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private final Callable<Void> n = new Callable()
  {
    private Void a()
    {
      synchronized (o.this)
      {
        if (o.a(o.this) == null) {
          return null;
        }
        o.b(o.this);
        if (o.c(o.this))
        {
          o.d(o.this);
          o.e(o.this);
        }
        return null;
      }
    }
  };
  
  private o(File paramFile, long paramLong)
  {
    this.b = paramFile;
    this.e = 1;
    this.c = new File(paramFile, "journal");
    this.d = new File(paramFile, "journal.tmp");
    this.g = 1;
    this.f = paramLong;
  }
  
  public static o a(File paramFile, long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    o localo = new o(paramFile, paramLong);
    if (localo.c.exists()) {
      try
      {
        localo.c();
        localo.d();
        localo.i = new BufferedWriter(new FileWriter(localo.c, true), 8192);
        return localo;
      }
      catch (IOException localIOException)
      {
        localo.b();
      }
    }
    paramFile.mkdirs();
    paramFile = new o(paramFile, paramLong);
    paramFile.e();
    return paramFile;
  }
  
  private static String a(InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder(80);
    for (;;)
    {
      i1 = paramInputStream.read();
      if (i1 == -1) {
        throw new EOFException();
      }
      if (i1 == 10) {
        break;
      }
      localStringBuilder.append((char)i1);
    }
    int i1 = localStringBuilder.length();
    if ((i1 > 0) && (localStringBuilder.charAt(i1 - 1) == '\r')) {
      localStringBuilder.setLength(i1 - 1);
    }
    return localStringBuilder.toString();
  }
  
  private void a(a parama, boolean paramBoolean)
  {
    int i3 = 0;
    b localb;
    try
    {
      localb = parama.a;
      if (localb.d != parama) {
        throw new IllegalStateException();
      }
    }
    finally {}
    int i2 = i3;
    int i1;
    if (paramBoolean)
    {
      i2 = i3;
      if (!localb.c)
      {
        i1 = 0;
        i2 = i3;
        if (i1 < this.g)
        {
          if (localb.b(i1).exists()) {
            break label384;
          }
          parama.b();
          throw new IllegalStateException("edit didn't create file " + i1);
        }
      }
    }
    for (;;)
    {
      long l1;
      if (i2 < this.g)
      {
        parama = localb.b(i2);
        if (paramBoolean)
        {
          if (parama.exists())
          {
            File localFile = localb.a(i2);
            parama.renameTo(localFile);
            l1 = localb.b[i2];
            long l2 = localFile.length();
            localb.b[i2] = l2;
            this.h = (this.h - l1 + l2);
          }
        }
        else {
          b(parama);
        }
      }
      else
      {
        this.k += 1;
        localb.d = null;
        if ((localb.c | paramBoolean))
        {
          localb.c = true;
          this.i.write("CLEAN " + localb.a + localb.a() + '\n');
          if (paramBoolean)
          {
            l1 = this.l;
            this.l = (1L + l1);
            localb.e = l1;
          }
        }
        for (;;)
        {
          if ((this.h > this.f) || (f())) {
            this.m.submit(this.n);
          }
          return;
          this.j.remove(localb.a);
          this.i.write("REMOVE " + localb.a + '\n');
        }
        label384:
        i1 += 1;
        break;
      }
      i2 += 1;
    }
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
    }
    catch (Exception paramCloseable) {}
  }
  
  private static void a(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      throw new IllegalArgumentException("not a directory: " + paramFile);
    }
    int i2 = arrayOfFile.length;
    int i1 = 0;
    while (i1 < i2)
    {
      paramFile = arrayOfFile[i1];
      if (paramFile.isDirectory()) {
        a(paramFile);
      }
      if (!paramFile.delete()) {
        throw new IOException("failed to delete file: " + paramFile);
      }
      i1 += 1;
    }
  }
  
  private static void b(File paramFile)
  {
    if ((paramFile.exists()) && (!paramFile.delete())) {
      throw new IOException();
    }
  }
  
  private void c()
  {
    BufferedInputStream localBufferedInputStream = new BufferedInputStream(new FileInputStream(this.c), 8192);
    Object localObject3;
    label481:
    label501:
    label527:
    try
    {
      String str1 = a(localBufferedInputStream);
      localObject2 = a(localBufferedInputStream);
      localObject3 = a(localBufferedInputStream);
      str2 = a(localBufferedInputStream);
      String str3 = a(localBufferedInputStream);
      if ((!"libcore.io.DiskLruCache".equals(str1)) || (!"1".equals(localObject2)) || (!Integer.toString(this.e).equals(localObject3)) || (!Integer.toString(this.g).equals(str2)) || (!"".equals(str3))) {
        throw new IOException("unexpected journal header: [" + str1 + ", " + (String)localObject2 + ", " + str2 + ", " + str3 + "]");
      }
    }
    finally
    {
      Object localObject2;
      a(localBufferedInputStream);
      throw ((Throwable)localObject1);
      String str2 = localObject2[1];
      do
      {
        for (;;)
        {
          try
          {
            if ((localObject2[0].equals("REMOVE")) && (localObject2.length == 2))
            {
              this.j.remove(str2);
              localObject3 = a(localBufferedInputStream);
              localObject2 = ((String)localObject3).split(" ");
              if (localObject2.length >= 2) {
                break;
              }
              throw new IOException("unexpected journal line: " + (String)localObject3);
            }
          }
          catch (EOFException localEOFException)
          {
            a(localBufferedInputStream);
            return;
          }
          b localb = (b)this.j.get(str2);
          if (localb != null) {
            break label527;
          }
          localb = new b(str2, (byte)0);
          this.j.put(str2, localb);
          if ((localObject2[0].equals("CLEAN")) && (localObject2.length == this.g + 2))
          {
            localb.c = true;
            localb.d = null;
            int i2 = localObject2.length;
            int i1 = localObject2.length;
            if (2 > i2) {
              throw new IllegalArgumentException();
            }
            if (2 > i1) {
              throw new ArrayIndexOutOfBoundsException();
            }
            i2 -= 2;
            i1 = Math.min(i2, i1 - 2);
            localObject3 = (Object[])Array.newInstance(localObject2.getClass().getComponentType(), i2);
            System.arraycopy(localObject2, 2, localObject3, 0, i1);
            localb.a((String[])localObject3);
          }
          else
          {
            if ((!localObject2[0].equals("DIRTY")) || (localObject2.length != 2)) {
              break label481;
            }
            localb.d = new a(localb, (byte)0);
          }
        }
        if (!localObject2[0].equals("READ")) {
          break label501;
        }
      } while (localObject2.length == 2);
    }
  }
  
  private void d()
  {
    b(this.d);
    Iterator localIterator = this.j.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      int i1;
      if (localb.d == null)
      {
        i1 = 0;
        while (i1 < this.g)
        {
          this.h += localb.b[i1];
          i1 += 1;
        }
      }
      else
      {
        localb.d = null;
        i1 = 0;
        while (i1 < this.g)
        {
          b(localb.a(i1));
          b(localb.b(i1));
          i1 += 1;
        }
        localIterator.remove();
      }
    }
  }
  
  private static void d(String paramString)
  {
    if ((paramString.contains(" ")) || (paramString.contains("\n")) || (paramString.contains("\r"))) {
      throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + paramString + "\"");
    }
  }
  
  private void e()
  {
    for (;;)
    {
      try
      {
        if (this.i != null) {
          this.i.close();
        }
        BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(this.d), 8192);
        localBufferedWriter.write("libcore.io.DiskLruCache");
        localBufferedWriter.write("\n");
        localBufferedWriter.write("1");
        localBufferedWriter.write("\n");
        localBufferedWriter.write(Integer.toString(this.e));
        localBufferedWriter.write("\n");
        localBufferedWriter.write(Integer.toString(this.g));
        localBufferedWriter.write("\n");
        localBufferedWriter.write("\n");
        Iterator localIterator = this.j.values().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        b localb = (b)localIterator.next();
        if (localb.d != null) {
          localBufferedWriter.write("DIRTY " + localb.a + '\n');
        } else {
          ((Writer)localObject).write("CLEAN " + localb.a + localb.a() + '\n');
        }
      }
      finally {}
    }
    ((Writer)localObject).close();
    this.d.renameTo(this.c);
    this.i = new BufferedWriter(new FileWriter(this.c, true), 8192);
  }
  
  private boolean f()
  {
    return (this.k >= 2000) && (this.k >= this.j.size());
  }
  
  private void g()
  {
    if (this.i == null) {
      throw new IllegalStateException("cache is closed");
    }
  }
  
  private void h()
  {
    while (this.h > this.f) {
      c((String)((Map.Entry)this.j.entrySet().iterator().next()).getKey());
    }
  }
  
  /* Error */
  public final c a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: invokespecial 460	com/whatsapp/util/o:g	()V
    //   11: aload_1
    //   12: invokestatic 462	com/whatsapp/util/o:d	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 67	com/whatsapp/util/o:j	Ljava/util/LinkedHashMap;
    //   19: aload_1
    //   20: invokevirtual 341	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 15	com/whatsapp/util/o$b
    //   26: astore 5
    //   28: aload 5
    //   30: ifnonnull +10 -> 40
    //   33: aload 4
    //   35: astore_3
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_3
    //   39: areturn
    //   40: aload 4
    //   42: astore_3
    //   43: aload 5
    //   45: getfield 199	com/whatsapp/util/o$b:c	Z
    //   48: ifeq -12 -> 36
    //   51: aload_0
    //   52: getfield 111	com/whatsapp/util/o:g	I
    //   55: anewarray 161	java/io/InputStream
    //   58: astore_3
    //   59: iload_2
    //   60: aload_0
    //   61: getfield 111	com/whatsapp/util/o:g	I
    //   64: if_icmpge +26 -> 90
    //   67: aload_3
    //   68: iload_2
    //   69: new 296	java/io/FileInputStream
    //   72: dup
    //   73: aload 5
    //   75: iload_2
    //   76: invokevirtual 212	com/whatsapp/util/o$b:a	(I)Ljava/io/File;
    //   79: invokespecial 298	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   82: aastore
    //   83: iload_2
    //   84: iconst_1
    //   85: iadd
    //   86: istore_2
    //   87: goto -28 -> 59
    //   90: aload_0
    //   91: aload_0
    //   92: getfield 227	com/whatsapp/util/o:k	I
    //   95: iconst_1
    //   96: iadd
    //   97: putfield 227	com/whatsapp/util/o:k	I
    //   100: aload_0
    //   101: getfield 145	com/whatsapp/util/o:i	Ljava/io/Writer;
    //   104: new 156	java/lang/StringBuilder
    //   107: dup
    //   108: ldc_w 464
    //   111: invokespecial 206	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   114: aload_1
    //   115: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: bipush 10
    //   120: invokevirtual 172	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   123: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokevirtual 467	java/io/Writer:append	(Ljava/lang/CharSequence;)Ljava/io/Writer;
    //   129: pop
    //   130: aload_0
    //   131: invokespecial 246	com/whatsapp/util/o:f	()Z
    //   134: ifeq +17 -> 151
    //   137: aload_0
    //   138: getfield 87	com/whatsapp/util/o:m	Ljava/util/concurrent/ExecutorService;
    //   141: aload_0
    //   142: getfield 92	com/whatsapp/util/o:n	Ljava/util/concurrent/Callable;
    //   145: invokeinterface 252 2 0
    //   150: pop
    //   151: new 18	com/whatsapp/util/o$c
    //   154: dup
    //   155: aload_0
    //   156: aload_1
    //   157: aload 5
    //   159: getfield 244	com/whatsapp/util/o$b:e	J
    //   162: aload_3
    //   163: iconst_0
    //   164: invokespecial 470	com/whatsapp/util/o$c:<init>	(Lcom/whatsapp/util/o;Ljava/lang/String;J[Ljava/io/InputStream;B)V
    //   167: astore_3
    //   168: goto -132 -> 36
    //   171: astore_1
    //   172: aload_0
    //   173: monitorexit
    //   174: aload_1
    //   175: athrow
    //   176: astore_1
    //   177: aload 4
    //   179: astore_3
    //   180: goto -144 -> 36
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	o
    //   0	183	1	paramString	String
    //   1	86	2	i1	int
    //   35	145	3	localObject1	Object
    //   3	175	4	localObject2	Object
    //   26	132	5	localb	b
    // Exception table:
    //   from	to	target	type
    //   7	28	171	finally
    //   43	59	171	finally
    //   59	83	171	finally
    //   90	151	171	finally
    //   151	168	171	finally
    //   59	83	176	java/io/FileNotFoundException
  }
  
  public final boolean a()
  {
    return this.i == null;
  }
  
  final a b(String paramString)
  {
    for (;;)
    {
      a locala;
      try
      {
        g();
        d(paramString);
        b localb = (b)this.j.get(paramString);
        if (-1L != -1L) {
          if (localb != null)
          {
            long l1 = localb.e;
            if (l1 == -1L) {}
          }
          else
          {
            paramString = null;
            return paramString;
          }
        }
        if (localb == null)
        {
          localb = new b(paramString, (byte)0);
          this.j.put(paramString, localb);
          locala = new a(localb, (byte)0);
          localb.d = locala;
          this.i.write("DIRTY " + paramString + '\n');
          this.i.flush();
          paramString = locala;
          continue;
        }
        locala = localb.d;
      }
      finally {}
      if (locala != null) {
        paramString = null;
      }
    }
  }
  
  public final void b()
  {
    close();
    a(this.b);
  }
  
  public final boolean c(String paramString)
  {
    int i1 = 0;
    for (;;)
    {
      try
      {
        g();
        d(paramString);
        b localb = (b)this.j.get(paramString);
        Object localObject;
        if (localb != null)
        {
          localObject = localb.d;
          if (localObject == null) {}
        }
        else
        {
          bool = false;
          return bool;
          this.h -= localb.b[i1];
          localb.b[i1] = 0L;
          i1 += 1;
        }
        if (i1 < this.g)
        {
          localObject = localb.a(i1);
          if (((File)localObject).delete()) {
            continue;
          }
          throw new IOException("failed to delete " + localObject);
        }
      }
      finally {}
      this.k += 1;
      this.i.append("REMOVE " + paramString + '\n');
      this.j.remove(paramString);
      if (f()) {
        this.m.submit(this.n);
      }
      boolean bool = true;
    }
  }
  
  public final void close()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = this.i;
        if (localObject1 == null) {
          return;
        }
        localObject1 = new ArrayList(this.j.values()).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          b localb = (b)((Iterator)localObject1).next();
          if (localb.d == null) {
            continue;
          }
          localb.d.b();
          continue;
        }
        h();
      }
      finally {}
      this.i.close();
      this.i = null;
    }
  }
  
  public final class a
  {
    final o.b a;
    boolean b;
    
    private a(o.b paramb)
    {
      this.a = paramb;
    }
    
    public final OutputStream a()
    {
      synchronized (o.this)
      {
        if (this.a.d != this) {
          throw new IllegalStateException();
        }
      }
      a locala = new a(new FileOutputStream(this.a.b(0)), (byte)0);
      return locala;
    }
    
    public final void b()
    {
      o.a(o.this, this, false);
    }
    
    final class a
      extends FilterOutputStream
    {
      private a(OutputStream paramOutputStream)
      {
        super();
      }
      
      public final void close()
      {
        try
        {
          this.out.close();
          return;
        }
        catch (IOException localIOException)
        {
          o.a.this.b = true;
        }
      }
      
      public final void flush()
      {
        try
        {
          this.out.flush();
          return;
        }
        catch (IOException localIOException)
        {
          o.a.this.b = true;
        }
      }
      
      public final void write(int paramInt)
      {
        try
        {
          this.out.write(paramInt);
          return;
        }
        catch (IOException localIOException)
        {
          o.a.this.b = true;
        }
      }
      
      public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      {
        try
        {
          this.out.write(paramArrayOfByte, paramInt1, paramInt2);
          return;
        }
        catch (IOException paramArrayOfByte)
        {
          o.a.this.b = true;
        }
      }
    }
  }
  
  final class b
  {
    final String a;
    final long[] b;
    boolean c;
    o.a d;
    long e;
    
    private b(String paramString)
    {
      this.a = paramString;
      this.b = new long[o.f(o.this)];
    }
    
    private static IOException b(String[] paramArrayOfString)
    {
      throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
    }
    
    public final File a(int paramInt)
    {
      return new File(o.g(o.this), this.a + "." + paramInt);
    }
    
    public final String a()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      long[] arrayOfLong = this.b;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = arrayOfLong[i];
        localStringBuilder.append(' ').append(l);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    
    final void a(String[] paramArrayOfString)
    {
      if (paramArrayOfString.length != o.f(o.this)) {
        throw b(paramArrayOfString);
      }
      int i = 0;
      try
      {
        while (i < paramArrayOfString.length)
        {
          this.b[i] = Long.parseLong(paramArrayOfString[i]);
          i += 1;
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw b(paramArrayOfString);
      }
    }
    
    public final File b(int paramInt)
    {
      return new File(o.g(o.this), this.a + "." + paramInt + ".tmp");
    }
  }
  
  public final class c
    implements Closeable
  {
    final InputStream[] a;
    private final String c;
    private final long d;
    
    private c(String paramString, long paramLong, InputStream[] paramArrayOfInputStream)
    {
      this.c = paramString;
      this.d = paramLong;
      this.a = paramArrayOfInputStream;
    }
    
    public final void close()
    {
      InputStream[] arrayOfInputStream = this.a;
      int j = arrayOfInputStream.length;
      int i = 0;
      while (i < j)
      {
        o.a(arrayOfInputStream[i]);
        i += 1;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */