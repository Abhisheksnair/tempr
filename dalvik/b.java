package com.whatsapp.dalvik;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
{
  private final List<a> a;
  
  private b(List<a> paramList)
  {
    this.a = paramList;
  }
  
  /* Error */
  public static b a(java.io.File paramFile)
  {
    // Byte code:
    //   0: new 24	java/io/FileReader
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 27	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   8: astore_3
    //   9: new 29	java/io/BufferedReader
    //   12: dup
    //   13: aload_3
    //   14: invokespecial 32	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   17: astore 4
    //   19: aconst_null
    //   20: astore_2
    //   21: new 34	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 35	java/util/ArrayList:<init>	()V
    //   28: astore_0
    //   29: aload 4
    //   31: invokevirtual 39	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: astore_1
    //   35: aload_1
    //   36: ifnull +40 -> 76
    //   39: aload_0
    //   40: aload_1
    //   41: invokeinterface 45 2 0
    //   46: pop
    //   47: goto -18 -> 29
    //   50: astore_0
    //   51: aload_0
    //   52: athrow
    //   53: astore_1
    //   54: aload_0
    //   55: astore_2
    //   56: aload_1
    //   57: astore_0
    //   58: aload_2
    //   59: ifnull +33 -> 92
    //   62: aload 4
    //   64: invokevirtual 48	java/io/BufferedReader:close	()V
    //   67: aload_0
    //   68: athrow
    //   69: astore_0
    //   70: aload_3
    //   71: invokevirtual 51	java/io/Reader:close	()V
    //   74: aload_0
    //   75: athrow
    //   76: aload_0
    //   77: invokestatic 54	com/whatsapp/dalvik/b:a	(Ljava/util/List;)Lcom/whatsapp/dalvik/b;
    //   80: astore_0
    //   81: aload 4
    //   83: invokevirtual 48	java/io/BufferedReader:close	()V
    //   86: aload_3
    //   87: invokevirtual 51	java/io/Reader:close	()V
    //   90: aload_0
    //   91: areturn
    //   92: aload 4
    //   94: invokevirtual 48	java/io/BufferedReader:close	()V
    //   97: goto -30 -> 67
    //   100: astore_1
    //   101: goto -34 -> 67
    //   104: astore_0
    //   105: goto -47 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	paramFile	java.io.File
    //   34	7	1	str	String
    //   53	4	1	localObject	Object
    //   100	1	1	localThrowable	Throwable
    //   20	39	2	localFile	java.io.File
    //   8	79	3	localFileReader	java.io.FileReader
    //   17	76	4	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   21	29	50	java/lang/Throwable
    //   29	35	50	java/lang/Throwable
    //   39	47	50	java/lang/Throwable
    //   76	81	50	java/lang/Throwable
    //   51	53	53	finally
    //   9	19	69	finally
    //   62	67	69	finally
    //   67	69	69	finally
    //   81	86	69	finally
    //   92	97	69	finally
    //   62	67	100	java/lang/Throwable
    //   21	29	104	finally
    //   29	35	104	finally
    //   39	47	104	finally
    //   76	81	104	finally
  }
  
  private static b a(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(b((String)paramList.next()));
    }
    return new b(localArrayList);
  }
  
  private static boolean a(char paramChar1, char paramChar2, String paramString)
  {
    if (paramChar1 == paramChar2) {
      return true;
    }
    if (paramChar1 == '-') {
      return false;
    }
    throw c(paramString);
  }
  
  private static a b(String paramString)
  {
    boolean bool1 = true;
    String[] arrayOfString1 = paramString.split(" +", 6);
    if (arrayOfString1.length != 6) {
      throw c(paramString);
    }
    String[] arrayOfString2 = arrayOfString1[0].split("-");
    if (arrayOfString2.length != 2) {
      throw c(paramString);
    }
    long l1;
    long l2;
    try
    {
      l1 = Long.parseLong(arrayOfString2[0], 16);
      l2 = Long.parseLong(arrayOfString2[1], 16);
      if (arrayOfString1[1].length() != 4) {
        throw c(paramString);
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw c(paramString);
    }
    boolean bool2 = a(localNumberFormatException[1].charAt(0), 'r', paramString);
    boolean bool3 = a(localNumberFormatException[1].charAt(1), 'w', paramString);
    if (localNumberFormatException[1].charAt(3) == 'p') {}
    for (;;)
    {
      return new a(l1, l2, bool2, bool3, bool1, localNumberFormatException[5]);
      bool1 = false;
    }
  }
  
  private static IllegalArgumentException c(String paramString)
  {
    return new IllegalArgumentException("Invalid /proc/self/maps line: '" + paramString + "'");
  }
  
  public final a a(String paramString)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.d.contains(paramString)) {
        return locala;
      }
    }
    return null;
  }
  
  public final b a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.c) {
        localArrayList.add(locala);
      }
    }
    return new b(localArrayList);
  }
  
  public final long[] b()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.a.iterator();
    long l1 = -1L;
    long l2 = -1L;
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      if (l2 == -1L)
      {
        l2 = locala.a;
        l1 = locala.b;
      }
      else if (locala.a == l1)
      {
        l1 = locala.b;
      }
      else
      {
        localArrayList.add(Long.valueOf(l2));
        localArrayList.add(Long.valueOf(l1));
        l2 = locala.a;
        l1 = locala.b;
      }
    }
    if (l2 != -1L)
    {
      localArrayList.add(Long.valueOf(l2));
      localArrayList.add(Long.valueOf(l1));
    }
    localObject = new long[localArrayList.size()];
    int i = 0;
    while (i < localArrayList.size())
    {
      localObject[i] = ((Long)localArrayList.get(i)).longValue();
      i += 1;
    }
    return (long[])localObject;
  }
  
  public static final class a
  {
    final long a;
    final long b;
    final boolean c;
    final String d;
    private final boolean e;
    private final boolean f;
    
    a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
    {
      this.a = paramLong1;
      this.b = paramLong2;
      this.c = paramBoolean1;
      this.e = paramBoolean2;
      this.f = paramBoolean3;
      this.d = paramString;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/dalvik/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */