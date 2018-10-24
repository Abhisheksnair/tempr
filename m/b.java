package com.whatsapp.m;

import a.a.a.a.a.a.d;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  public final long a;
  public final long b;
  public final int c;
  public final int[] d;
  
  public b(long paramLong)
  {
    this.a = paramLong;
    this.b = 65536L;
    this.c = ((int)Math.ceil(paramLong / 65536.0D));
    this.d = new int[this.c];
  }
  
  private b(long paramLong1, long paramLong2, int[] paramArrayOfInt)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = ((int)Math.ceil(paramLong1 / paramLong2));
    this.d = paramArrayOfInt;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    try
    {
      this.d[paramInt1] = paramInt2;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public static b b(java.io.File paramFile)
  {
    // Byte code:
    //   0: new 42	java/io/DataInputStream
    //   3: dup
    //   4: new 44	java/io/BufferedInputStream
    //   7: dup
    //   8: new 46	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 49	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   16: invokespecial 52	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   19: invokespecial 53	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: astore 7
    //   24: aload 7
    //   26: invokevirtual 57	java/io/DataInputStream:readLong	()J
    //   29: lstore_3
    //   30: aload 7
    //   32: invokevirtual 57	java/io/DataInputStream:readLong	()J
    //   35: lstore 5
    //   37: aload 7
    //   39: invokevirtual 61	java/io/DataInputStream:readInt	()I
    //   42: istore_2
    //   43: iload_2
    //   44: lload_3
    //   45: l2d
    //   46: lload 5
    //   48: l2d
    //   49: ddiv
    //   50: invokestatic 30	java/lang/Math:ceil	(D)D
    //   53: d2i
    //   54: if_icmpeq +24 -> 78
    //   57: ldc 63
    //   59: invokestatic 69	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   62: aload 7
    //   64: invokevirtual 72	java/io/DataInputStream:close	()V
    //   67: aconst_null
    //   68: areturn
    //   69: astore_0
    //   70: ldc 74
    //   72: invokestatic 77	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   75: goto -8 -> 67
    //   78: iload_2
    //   79: newarray <illegal type>
    //   81: astore 8
    //   83: iconst_0
    //   84: istore_1
    //   85: iload_1
    //   86: iload_2
    //   87: if_icmpge +19 -> 106
    //   90: aload 8
    //   92: iload_1
    //   93: aload 7
    //   95: invokevirtual 61	java/io/DataInputStream:readInt	()I
    //   98: iastore
    //   99: iload_1
    //   100: iconst_1
    //   101: iadd
    //   102: istore_1
    //   103: goto -18 -> 85
    //   106: new 2	com/whatsapp/m/b
    //   109: dup
    //   110: lload_3
    //   111: lload 5
    //   113: aload 8
    //   115: invokespecial 79	com/whatsapp/m/b:<init>	(JJ[I)V
    //   118: astore 8
    //   120: aload 7
    //   122: invokevirtual 72	java/io/DataInputStream:close	()V
    //   125: aload 8
    //   127: areturn
    //   128: astore_0
    //   129: ldc 74
    //   131: invokestatic 77	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   134: aload 8
    //   136: areturn
    //   137: astore 8
    //   139: aconst_null
    //   140: astore 7
    //   142: new 81	java/lang/StringBuilder
    //   145: dup
    //   146: ldc 83
    //   148: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   151: aload_0
    //   152: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: aload 8
    //   160: invokestatic 96	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   163: aload 7
    //   165: ifnull +8 -> 173
    //   168: aload 7
    //   170: invokevirtual 72	java/io/DataInputStream:close	()V
    //   173: aconst_null
    //   174: areturn
    //   175: astore_0
    //   176: ldc 74
    //   178: invokestatic 77	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   181: goto -8 -> 173
    //   184: astore_0
    //   185: aconst_null
    //   186: astore 7
    //   188: aload 7
    //   190: ifnull +8 -> 198
    //   193: aload 7
    //   195: invokevirtual 72	java/io/DataInputStream:close	()V
    //   198: aload_0
    //   199: athrow
    //   200: astore 7
    //   202: ldc 74
    //   204: invokestatic 77	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   207: goto -9 -> 198
    //   210: astore_0
    //   211: goto -23 -> 188
    //   214: astore_0
    //   215: goto -27 -> 188
    //   218: astore 8
    //   220: goto -78 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	paramFile	java.io.File
    //   84	19	1	i	int
    //   42	46	2	j	int
    //   29	82	3	l1	long
    //   35	77	5	l2	long
    //   22	172	7	localDataInputStream	java.io.DataInputStream
    //   200	1	7	localIOException1	java.io.IOException
    //   81	54	8	localObject	Object
    //   137	22	8	localIOException2	java.io.IOException
    //   218	1	8	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   62	67	69	java/io/IOException
    //   120	125	128	java/io/IOException
    //   0	24	137	java/io/IOException
    //   168	173	175	java/io/IOException
    //   0	24	184	finally
    //   193	198	200	java/io/IOException
    //   24	62	210	finally
    //   78	83	210	finally
    //   90	99	210	finally
    //   106	120	210	finally
    //   142	163	214	finally
    //   24	62	218	java/io/IOException
    //   78	83	218	java/io/IOException
    //   90	99	218	java/io/IOException
    //   106	120	218	java/io/IOException
  }
  
  private long c(int paramInt)
  {
    try
    {
      paramInt = this.d[paramInt];
      long l = paramInt;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final long a()
  {
    long l2 = b(0L);
    long l1 = l2;
    if (l2 == -1L) {
      l1 = this.a;
    }
    return l1;
  }
  
  public final long a(long paramLong)
  {
    if (paramLong >= this.a) {
      return -1L;
    }
    int i = d(paramLong);
    while ((i < this.c) && (a(i))) {
      i += 1;
    }
    if (i == this.c) {
      return -1L;
    }
    paramLong = i;
    long l = this.b;
    return c(i) + paramLong * l;
  }
  
  public final List<Integer> a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramLong2 > 0L)
    {
      int i = d(paramLong1);
      long l1 = paramLong1 - i * this.b;
      if (l1 >= 0L)
      {
        bool = true;
        a.d.a(bool);
        if (l1 >= b(i)) {
          break label109;
        }
      }
      long l2;
      label109:
      for (boolean bool = true;; bool = false)
      {
        a.d.a(bool);
        i = d(paramLong1);
        l2 = c(i);
        if (l1 <= l2) {
          break label115;
        }
        throw new IllegalStateException("gap in downloaded chunk");
        bool = false;
        break;
      }
      label115:
      long l3 = l1 + paramLong2;
      int j = b(i);
      if (l3 > j)
      {
        if (paramBoolean) {
          a(i, j);
        }
        paramLong2 = l3 - j;
        if (i + 1 >= this.c) {
          throw new IllegalStateException("downloaded more bytes than chunks");
        }
        localArrayList.add(Integer.valueOf(i));
        paramLong1 = (i + 1) * this.b;
      }
      else
      {
        j = (int)Math.max(l1 + paramLong2, l2);
        if (paramBoolean) {
          a(i, j);
        }
        if (j == b(i)) {
          localArrayList.add(Integer.valueOf(i));
        }
        paramLong2 = 0L;
      }
    }
    return localArrayList;
  }
  
  /* Error */
  public final void a(java.io.File paramFile)
  {
    // Byte code:
    //   0: new 151	java/io/DataOutputStream
    //   3: dup
    //   4: new 153	java/io/BufferedOutputStream
    //   7: dup
    //   8: new 155	java/io/FileOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 156	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   16: invokespecial 159	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   19: invokespecial 160	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_3
    //   23: aload_3
    //   24: astore_1
    //   25: aload_3
    //   26: aload_0
    //   27: getfield 18	com/whatsapp/m/b:a	J
    //   30: invokevirtual 163	java/io/DataOutputStream:writeLong	(J)V
    //   33: aload_3
    //   34: astore_1
    //   35: aload_3
    //   36: aload_0
    //   37: getfield 22	com/whatsapp/m/b:b	J
    //   40: invokevirtual 163	java/io/DataOutputStream:writeLong	(J)V
    //   43: aload_3
    //   44: astore_1
    //   45: aload_3
    //   46: aload_0
    //   47: getfield 32	com/whatsapp/m/b:c	I
    //   50: invokevirtual 167	java/io/DataOutputStream:writeInt	(I)V
    //   53: iconst_0
    //   54: istore_2
    //   55: aload_3
    //   56: astore_1
    //   57: iload_2
    //   58: aload_0
    //   59: getfield 32	com/whatsapp/m/b:c	I
    //   62: if_icmpge +22 -> 84
    //   65: aload_3
    //   66: astore_1
    //   67: aload_3
    //   68: aload_0
    //   69: getfield 34	com/whatsapp/m/b:d	[I
    //   72: iload_2
    //   73: iaload
    //   74: invokevirtual 167	java/io/DataOutputStream:writeInt	(I)V
    //   77: iload_2
    //   78: iconst_1
    //   79: iadd
    //   80: istore_2
    //   81: goto -26 -> 55
    //   84: aload_3
    //   85: astore_1
    //   86: aload_3
    //   87: invokevirtual 170	java/io/DataOutputStream:flush	()V
    //   90: aload_3
    //   91: invokevirtual 171	java/io/DataOutputStream:close	()V
    //   94: return
    //   95: astore_1
    //   96: ldc -83
    //   98: invokestatic 77	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   101: return
    //   102: astore 4
    //   104: aconst_null
    //   105: astore_3
    //   106: aload_3
    //   107: astore_1
    //   108: ldc -81
    //   110: aload 4
    //   112: invokestatic 96	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: aload_3
    //   116: ifnull -22 -> 94
    //   119: aload_3
    //   120: invokevirtual 171	java/io/DataOutputStream:close	()V
    //   123: return
    //   124: astore_1
    //   125: ldc -83
    //   127: invokestatic 77	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   130: return
    //   131: astore_3
    //   132: aconst_null
    //   133: astore_1
    //   134: aload_1
    //   135: ifnull +7 -> 142
    //   138: aload_1
    //   139: invokevirtual 171	java/io/DataOutputStream:close	()V
    //   142: aload_3
    //   143: athrow
    //   144: astore_1
    //   145: ldc -83
    //   147: invokestatic 77	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   150: goto -8 -> 142
    //   153: astore_3
    //   154: goto -20 -> 134
    //   157: astore 4
    //   159: goto -53 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	b
    //   0	162	1	paramFile	java.io.File
    //   54	27	2	i	int
    //   22	98	3	localDataOutputStream	java.io.DataOutputStream
    //   131	12	3	localObject1	Object
    //   153	1	3	localObject2	Object
    //   102	9	4	localIOException1	java.io.IOException
    //   157	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   90	94	95	java/io/IOException
    //   0	23	102	java/io/IOException
    //   119	123	124	java/io/IOException
    //   0	23	131	finally
    //   138	142	144	java/io/IOException
    //   25	33	153	finally
    //   35	43	153	finally
    //   45	53	153	finally
    //   57	65	153	finally
    //   67	77	153	finally
    //   86	90	153	finally
    //   108	115	153	finally
    //   25	33	157	java/io/IOException
    //   35	43	157	java/io/IOException
    //   45	53	157	java/io/IOException
    //   57	65	157	java/io/IOException
    //   67	77	157	java/io/IOException
    //   86	90	157	java/io/IOException
  }
  
  /* Error */
  public final boolean a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/whatsapp/m/b:d	[I
    //   6: iload_1
    //   7: iaload
    //   8: istore_2
    //   9: aload_0
    //   10: iload_1
    //   11: invokevirtual 122	com/whatsapp/m/b:b	(I)I
    //   14: istore_1
    //   15: iload_2
    //   16: iload_1
    //   17: if_icmpne +9 -> 26
    //   20: iconst_1
    //   21: istore_3
    //   22: aload_0
    //   23: monitorexit
    //   24: iload_3
    //   25: ireturn
    //   26: iconst_0
    //   27: istore_3
    //   28: goto -6 -> 22
    //   31: astore 4
    //   33: aload_0
    //   34: monitorexit
    //   35: aload 4
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	b
    //   0	38	1	paramInt	int
    //   8	10	2	i	int
    //   21	7	3	bool	boolean
    //   31	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	31	finally
  }
  
  public final int b(int paramInt)
  {
    if (paramInt == this.c - 1) {
      return (int)(this.a - this.b * (this.c - 1));
    }
    return (int)this.b;
  }
  
  public final long b()
  {
    long l = 0L;
    int i = 0;
    while (i < this.c)
    {
      l += c(i);
      i += 1;
    }
    return l;
  }
  
  public final long b(long paramLong)
  {
    if (paramLong >= this.a) {
      return -1L;
    }
    int i = d(paramLong);
    while ((i < this.c) && (a(i))) {
      i += 1;
    }
    if (i == this.c) {
      return -1L;
    }
    return i * this.b;
  }
  
  public final long c(long paramLong)
  {
    if (paramLong >= this.a) {
      return -1L;
    }
    int i = d(paramLong) + 1;
    while ((i < this.c) && (c(i) == 0L)) {
      i += 1;
    }
    if (i == this.c) {
      return -1L;
    }
    return i * this.b;
  }
  
  public final int d(long paramLong)
  {
    boolean bool2 = true;
    if (paramLong >= 0L)
    {
      bool1 = true;
      a.d.a(bool1);
      if (paramLong >= this.a) {
        break label44;
      }
    }
    label44:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      a.d.a(bool1);
      return (int)(paramLong / this.b);
      bool1 = false;
      break;
    }
  }
  
  public final String toString()
  {
    for (;;)
    {
      int i;
      int k;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("totalBytes: " + this.a + ", ");
        localStringBuilder.append("chunkLength: " + this.b + ", ");
        localStringBuilder.append("chunkCount: " + this.c + ", ");
        i = 0;
        j = -1;
        if (i >= this.c) {
          break label277;
        }
        if (a(i))
        {
          k = j;
          if (j < 0)
          {
            localStringBuilder.append("[" + i);
            k = i;
          }
        }
        else
        {
          m = j;
          if (j >= 0)
          {
            if (i - 1 != j)
            {
              localStringBuilder.append("-" + (i - 1) + "]");
              break label343;
            }
          }
          else
          {
            k = m;
            if (this.d[i] <= 0) {
              break label334;
            }
            localStringBuilder.append("[" + i + "] " + this.d[i] + ", ");
            k = m;
          }
        }
      }
      finally {}
      ((StringBuilder)localObject).append("]");
      break label343;
      label277:
      if (j >= 0) {
        ((StringBuilder)localObject).append("[" + j + "-" + (this.c - 1) + "]");
      }
      String str = ((StringBuilder)localObject).toString();
      return str;
      label334:
      i += 1;
      int j = k;
      continue;
      label343:
      int m = -1;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/m/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */