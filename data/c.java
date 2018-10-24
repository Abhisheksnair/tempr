package com.whatsapp.data;

import android.database.sqlite.SQLiteStatement;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.yr;

public class c
{
  private static volatile c b;
  final cq a;
  
  private c(cq paramcq)
  {
    this.a = paramcq;
  }
  
  public static c a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new c(cq.a());
      }
      return b;
    }
    finally {}
  }
  
  /* Error */
  static void a(j paramj, SQLiteStatement paramSQLiteStatement, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/whatsapp/protocol/j:s	B
    //   4: iconst_1
    //   5: if_icmpeq +72 -> 77
    //   8: aload_0
    //   9: getfield 39	com/whatsapp/protocol/j:s	B
    //   12: iconst_5
    //   13: if_icmpeq +64 -> 77
    //   16: aload_0
    //   17: getfield 39	com/whatsapp/protocol/j:s	B
    //   20: iconst_3
    //   21: if_icmpeq +56 -> 77
    //   24: aload_0
    //   25: getfield 39	com/whatsapp/protocol/j:s	B
    //   28: iconst_2
    //   29: if_icmpeq +48 -> 77
    //   32: aload_0
    //   33: getfield 39	com/whatsapp/protocol/j:s	B
    //   36: bipush 9
    //   38: if_icmpeq +39 -> 77
    //   41: aload_0
    //   42: getfield 39	com/whatsapp/protocol/j:s	B
    //   45: bipush 13
    //   47: if_icmpeq +30 -> 77
    //   50: aload_0
    //   51: getfield 39	com/whatsapp/protocol/j:s	B
    //   54: bipush 14
    //   56: if_icmpeq +21 -> 77
    //   59: aload_0
    //   60: getfield 39	com/whatsapp/protocol/j:s	B
    //   63: bipush 12
    //   65: if_icmpeq +12 -> 77
    //   68: aload_0
    //   69: getfield 39	com/whatsapp/protocol/j:s	B
    //   72: bipush 16
    //   74: if_icmpne +165 -> 239
    //   77: aload_0
    //   78: getfield 43	com/whatsapp/protocol/j:m	I
    //   81: ifne +149 -> 230
    //   84: aload_0
    //   85: invokevirtual 47	com/whatsapp/protocol/j:e	()Ljava/lang/String;
    //   88: ifnull +142 -> 230
    //   91: aload_0
    //   92: invokevirtual 47	com/whatsapp/protocol/j:e	()Ljava/lang/String;
    //   95: invokevirtual 53	java/lang/String:length	()I
    //   98: ifeq +188 -> 286
    //   101: aload_0
    //   102: invokevirtual 47	com/whatsapp/protocol/j:e	()Ljava/lang/String;
    //   105: iconst_0
    //   106: invokestatic 59	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   109: astore 5
    //   111: aload_0
    //   112: aconst_null
    //   113: invokevirtual 62	com/whatsapp/protocol/j:e	(Ljava/lang/String;)V
    //   116: aload_0
    //   117: aload 5
    //   119: invokevirtual 65	com/whatsapp/protocol/j:a	([B)V
    //   122: aload_0
    //   123: iconst_1
    //   124: putfield 43	com/whatsapp/protocol/j:m	I
    //   127: iload_2
    //   128: aload 5
    //   130: aload_1
    //   131: invokestatic 70	com/whatsapp/data/n:a	(I[BLandroid/database/sqlite/SQLiteStatement;)V
    //   134: iload_3
    //   135: aconst_null
    //   136: aload_1
    //   137: invokestatic 70	com/whatsapp/data/n:a	(I[BLandroid/database/sqlite/SQLiteStatement;)V
    //   140: return
    //   141: astore 4
    //   143: aconst_null
    //   144: astore 5
    //   146: new 72	java/lang/StringBuilder
    //   149: dup
    //   150: ldc 74
    //   152: invokespecial 76	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: aload_0
    //   156: getfield 43	com/whatsapp/protocol/j:m	I
    //   159: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   162: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 86	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   168: aload_0
    //   169: getfield 43	com/whatsapp/protocol/j:m	I
    //   172: ifne +48 -> 220
    //   175: aload_0
    //   176: invokevirtual 47	com/whatsapp/protocol/j:e	()Ljava/lang/String;
    //   179: ifnull +41 -> 220
    //   182: new 72	java/lang/StringBuilder
    //   185: dup
    //   186: ldc 88
    //   188: invokespecial 76	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   191: aload_0
    //   192: invokevirtual 47	com/whatsapp/protocol/j:e	()Ljava/lang/String;
    //   195: iconst_0
    //   196: bipush 100
    //   198: aload_0
    //   199: invokevirtual 47	com/whatsapp/protocol/j:e	()Ljava/lang/String;
    //   202: invokevirtual 53	java/lang/String:length	()I
    //   205: invokestatic 94	java/lang/Math:min	(II)I
    //   208: invokevirtual 98	java/lang/String:substring	(II)Ljava/lang/String;
    //   211: invokevirtual 101	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 86	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   220: ldc 103
    //   222: aload 4
    //   224: invokestatic 107	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   227: goto -100 -> 127
    //   230: aload_0
    //   231: invokevirtual 111	com/whatsapp/protocol/j:h	()[B
    //   234: astore 5
    //   236: goto -109 -> 127
    //   239: iload_3
    //   240: aload_0
    //   241: invokevirtual 47	com/whatsapp/protocol/j:e	()Ljava/lang/String;
    //   244: aload_1
    //   245: invokestatic 114	com/whatsapp/data/n:a	(ILjava/lang/String;Landroid/database/sqlite/SQLiteStatement;)V
    //   248: iload_2
    //   249: aconst_null
    //   250: aload_1
    //   251: invokestatic 70	com/whatsapp/data/n:a	(I[BLandroid/database/sqlite/SQLiteStatement;)V
    //   254: return
    //   255: astore 4
    //   257: goto -111 -> 146
    //   260: astore 4
    //   262: aconst_null
    //   263: astore 5
    //   265: goto -119 -> 146
    //   268: astore 4
    //   270: goto -124 -> 146
    //   273: astore 4
    //   275: aconst_null
    //   276: astore 5
    //   278: goto -132 -> 146
    //   281: astore 4
    //   283: goto -137 -> 146
    //   286: aconst_null
    //   287: astore 5
    //   289: goto -178 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	paramj	j
    //   0	292	1	paramSQLiteStatement	SQLiteStatement
    //   0	292	2	paramInt1	int
    //   0	292	3	paramInt2	int
    //   141	82	4	localArrayIndexOutOfBoundsException1	ArrayIndexOutOfBoundsException
    //   255	1	4	localArrayIndexOutOfBoundsException2	ArrayIndexOutOfBoundsException
    //   260	1	4	localIllegalArgumentException1	IllegalArgumentException
    //   268	1	4	localIllegalArgumentException2	IllegalArgumentException
    //   273	1	4	localStringIndexOutOfBoundsException1	StringIndexOutOfBoundsException
    //   281	1	4	localStringIndexOutOfBoundsException2	StringIndexOutOfBoundsException
    //   109	179	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   91	111	141	java/lang/ArrayIndexOutOfBoundsException
    //   111	127	255	java/lang/ArrayIndexOutOfBoundsException
    //   91	111	260	java/lang/IllegalArgumentException
    //   111	127	268	java/lang/IllegalArgumentException
    //   91	111	273	java/lang/StringIndexOutOfBoundsException
    //   111	127	281	java/lang/StringIndexOutOfBoundsException
  }
  
  final void a(j paramj, SQLiteStatement paramSQLiteStatement)
  {
    long l2 = 0L;
    paramSQLiteStatement.bindString(1, paramj.e.a);
    if (paramj.e.b)
    {
      l1 = 1L;
      paramSQLiteStatement.bindLong(2, l1);
      paramSQLiteStatement.bindString(3, paramj.e.c);
      paramSQLiteStatement.bindLong(4, paramj.d);
      l1 = l2;
      if (paramj.E) {
        l1 = 2L;
      }
      paramSQLiteStatement.bindLong(5, l1);
      a(paramj, paramSQLiteStatement, 22, 6);
      paramSQLiteStatement.bindLong(7, paramj.n);
      n.a(8, paramj.p, paramSQLiteStatement);
      n.a(9, paramj.r, paramSQLiteStatement);
      paramSQLiteStatement.bindLong(10, paramj.s);
      paramSQLiteStatement.bindLong(11, paramj.t);
      n.a(12, paramj.y, paramSQLiteStatement);
      n.a(13, paramj.z, paramSQLiteStatement);
      n.a(14, paramj.u, paramSQLiteStatement);
      if (paramj.s != 9) {
        break label335;
      }
    }
    label335:
    for (long l1 = paramj.x;; l1 = paramj.w)
    {
      paramSQLiteStatement.bindLong(15, l1);
      paramSQLiteStatement.bindLong(16, paramj.o);
      paramSQLiteStatement.bindDouble(17, paramj.B);
      paramSQLiteStatement.bindDouble(18, paramj.C);
      n.a(19, this.a.a(paramj.N), paramSQLiteStatement);
      n.a(20, paramj.f, paramSQLiteStatement);
      paramSQLiteStatement.bindLong(21, System.currentTimeMillis());
      n.a(23, paramj.g, paramSQLiteStatement);
      paramSQLiteStatement.bindLong(24, paramj.F);
      paramSQLiteStatement.bindLong(25, paramj.U);
      n.a(26, yr.a(paramj.P), paramSQLiteStatement);
      n.a(27, paramj.W, paramSQLiteStatement);
      paramSQLiteStatement.bindLong(28, paramj.ab);
      n.a(29, paramj.v, paramSQLiteStatement);
      return;
      l1 = 0L;
      break;
    }
  }
  
  final void b(j paramj, SQLiteStatement paramSQLiteStatement)
  {
    long l2 = 0L;
    paramSQLiteStatement.bindLong(1, paramj.d);
    if (paramj.E)
    {
      l1 = 2L;
      paramSQLiteStatement.bindLong(2, l1);
      a(paramj, paramSQLiteStatement, 4, 3);
      paramSQLiteStatement.bindLong(5, paramj.n);
      n.a(6, paramj.p, paramSQLiteStatement);
      n.a(7, paramj.r, paramSQLiteStatement);
      paramSQLiteStatement.bindLong(8, paramj.s);
      paramSQLiteStatement.bindLong(9, paramj.t);
      n.a(10, paramj.y, paramSQLiteStatement);
      n.a(11, paramj.z, paramSQLiteStatement);
      n.a(12, paramj.u, paramSQLiteStatement);
      if (paramj.s != 9) {
        break label275;
      }
    }
    label275:
    for (long l1 = paramj.x;; l1 = paramj.w)
    {
      paramSQLiteStatement.bindLong(13, l1);
      paramSQLiteStatement.bindLong(14, paramj.o);
      paramSQLiteStatement.bindDouble(15, paramj.B);
      paramSQLiteStatement.bindDouble(16, paramj.C);
      n.a(17, yr.a(paramj.P), paramSQLiteStatement);
      n.a(18, this.a.a(paramj.N), paramSQLiteStatement);
      paramSQLiteStatement.bindLong(19, paramj.ab);
      n.a(20, paramj.v, paramSQLiteStatement);
      paramSQLiteStatement.bindString(21, paramj.e.a);
      l1 = l2;
      if (paramj.e.b) {
        l1 = 1L;
      }
      paramSQLiteStatement.bindLong(22, l1);
      paramSQLiteStatement.bindString(23, paramj.e.c);
      return;
      l1 = 0L;
      break;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */