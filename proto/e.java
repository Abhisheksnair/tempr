package com.whatsapp.proto;

import android.support.design.widget.f.a;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.a;
import com.google.protobuf.ae;
import com.google.protobuf.am;
import com.google.protobuf.c;
import com.google.protobuf.g;

public final class e
  extends GeneratedMessageLite
  implements f.a
{
  public static ae<e> a = new c() {};
  private static final e f;
  int b;
  c c;
  public d d;
  b e;
  private final com.google.protobuf.e g;
  private byte h = -1;
  private int i = -1;
  
  static
  {
    e locale = new e();
    f = locale;
    locale.d();
  }
  
  private e()
  {
    this.g = com.google.protobuf.e.b;
  }
  
  private e(GeneratedMessageLite.a parama)
  {
    super((byte)0);
    this.g = parama.a;
  }
  
  /* Error */
  private e(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 60	com/google/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 62	com/whatsapp/proto/e:h	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 64	com/whatsapp/proto/e:i	I
    //   14: aload_0
    //   15: invokespecial 58	com/whatsapp/proto/e:d	()V
    //   18: invokestatic 89	com/google/protobuf/e:h	()Lcom/google/protobuf/e$c;
    //   21: astore 6
    //   23: aload 6
    //   25: sipush 4096
    //   28: invokestatic 94	com/google/protobuf/g:a	(Ljava/io/OutputStream;I)Lcom/google/protobuf/g;
    //   31: astore 7
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +326 -> 362
    //   39: aload_1
    //   40: invokevirtual 99	com/google/protobuf/f:a	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+396->443, 0:+399->446, 18:+57->104, 26:+153->200, 34:+244->291
    //   88: aload_1
    //   89: iload 4
    //   91: aload 7
    //   93: invokevirtual 102	com/google/protobuf/f:a	(ILcom/google/protobuf/g;)Z
    //   96: ifne -61 -> 35
    //   99: iconst_1
    //   100: istore_3
    //   101: goto -66 -> 35
    //   104: aload_0
    //   105: getfield 104	com/whatsapp/proto/e:b	I
    //   108: iconst_1
    //   109: iand
    //   110: iconst_1
    //   111: if_icmpne +326 -> 437
    //   114: aload_0
    //   115: getfield 106	com/whatsapp/proto/e:c	Lcom/whatsapp/proto/e$c;
    //   118: invokestatic 109	com/whatsapp/proto/e$c:a	(Lcom/whatsapp/proto/e$c;)Lcom/whatsapp/proto/e$c$a;
    //   121: astore 5
    //   123: aload_0
    //   124: aload_1
    //   125: getstatic 110	com/whatsapp/proto/e$c:a	Lcom/google/protobuf/ae;
    //   128: aload_2
    //   129: invokevirtual 113	com/google/protobuf/f:a	(Lcom/google/protobuf/ae;Lcom/google/protobuf/m;)Lcom/google/protobuf/x;
    //   132: checkcast 20	com/whatsapp/proto/e$c
    //   135: putfield 106	com/whatsapp/proto/e:c	Lcom/whatsapp/proto/e$c;
    //   138: aload 5
    //   140: ifnull +22 -> 162
    //   143: aload 5
    //   145: aload_0
    //   146: getfield 106	com/whatsapp/proto/e:c	Lcom/whatsapp/proto/e$c;
    //   149: invokevirtual 114	com/whatsapp/proto/e$c$a:a	(Lcom/whatsapp/proto/e$c;)Lcom/whatsapp/proto/e$c$a;
    //   152: pop
    //   153: aload_0
    //   154: aload 5
    //   156: invokevirtual 117	com/whatsapp/proto/e$c$a:c	()Lcom/whatsapp/proto/e$c;
    //   159: putfield 106	com/whatsapp/proto/e:c	Lcom/whatsapp/proto/e$c;
    //   162: aload_0
    //   163: aload_0
    //   164: getfield 104	com/whatsapp/proto/e:b	I
    //   167: iconst_1
    //   168: ior
    //   169: putfield 104	com/whatsapp/proto/e:b	I
    //   172: goto -137 -> 35
    //   175: astore_1
    //   176: aload_1
    //   177: aload_0
    //   178: putfield 120	com/google/protobuf/q:a	Lcom/google/protobuf/x;
    //   181: aload_1
    //   182: athrow
    //   183: astore_1
    //   184: aload 7
    //   186: invokevirtual 122	com/google/protobuf/g:a	()V
    //   189: aload_0
    //   190: aload 6
    //   192: invokevirtual 127	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   195: putfield 70	com/whatsapp/proto/e:g	Lcom/google/protobuf/e;
    //   198: aload_1
    //   199: athrow
    //   200: aload_0
    //   201: getfield 104	com/whatsapp/proto/e:b	I
    //   204: iconst_2
    //   205: iand
    //   206: iconst_2
    //   207: if_icmpne +224 -> 431
    //   210: aload_0
    //   211: getfield 129	com/whatsapp/proto/e:d	Lcom/whatsapp/proto/e$d;
    //   214: invokestatic 132	com/whatsapp/proto/e$d:a	(Lcom/whatsapp/proto/e$d;)Lcom/whatsapp/proto/e$d$a;
    //   217: astore 5
    //   219: aload_0
    //   220: aload_1
    //   221: getstatic 133	com/whatsapp/proto/e$d:a	Lcom/google/protobuf/ae;
    //   224: aload_2
    //   225: invokevirtual 113	com/google/protobuf/f:a	(Lcom/google/protobuf/ae;Lcom/google/protobuf/m;)Lcom/google/protobuf/x;
    //   228: checkcast 27	com/whatsapp/proto/e$d
    //   231: putfield 129	com/whatsapp/proto/e:d	Lcom/whatsapp/proto/e$d;
    //   234: aload 5
    //   236: ifnull +22 -> 258
    //   239: aload 5
    //   241: aload_0
    //   242: getfield 129	com/whatsapp/proto/e:d	Lcom/whatsapp/proto/e$d;
    //   245: invokevirtual 134	com/whatsapp/proto/e$d$a:a	(Lcom/whatsapp/proto/e$d;)Lcom/whatsapp/proto/e$d$a;
    //   248: pop
    //   249: aload_0
    //   250: aload 5
    //   252: invokevirtual 137	com/whatsapp/proto/e$d$a:b	()Lcom/whatsapp/proto/e$d;
    //   255: putfield 129	com/whatsapp/proto/e:d	Lcom/whatsapp/proto/e$d;
    //   258: aload_0
    //   259: aload_0
    //   260: getfield 104	com/whatsapp/proto/e:b	I
    //   263: iconst_2
    //   264: ior
    //   265: putfield 104	com/whatsapp/proto/e:b	I
    //   268: goto -233 -> 35
    //   271: astore_1
    //   272: new 84	com/google/protobuf/q
    //   275: dup
    //   276: aload_1
    //   277: invokevirtual 141	java/io/IOException:getMessage	()Ljava/lang/String;
    //   280: invokespecial 144	com/google/protobuf/q:<init>	(Ljava/lang/String;)V
    //   283: astore_1
    //   284: aload_1
    //   285: aload_0
    //   286: putfield 120	com/google/protobuf/q:a	Lcom/google/protobuf/x;
    //   289: aload_1
    //   290: athrow
    //   291: aload_0
    //   292: getfield 104	com/whatsapp/proto/e:b	I
    //   295: iconst_4
    //   296: iand
    //   297: iconst_4
    //   298: if_icmpne +127 -> 425
    //   301: aload_0
    //   302: getfield 146	com/whatsapp/proto/e:e	Lcom/whatsapp/proto/e$b;
    //   305: invokestatic 149	com/whatsapp/proto/e$b:a	(Lcom/whatsapp/proto/e$b;)Lcom/whatsapp/proto/e$b$a;
    //   308: astore 5
    //   310: aload_0
    //   311: aload_1
    //   312: getstatic 150	com/whatsapp/proto/e$b:a	Lcom/google/protobuf/ae;
    //   315: aload_2
    //   316: invokevirtual 113	com/google/protobuf/f:a	(Lcom/google/protobuf/ae;Lcom/google/protobuf/m;)Lcom/google/protobuf/x;
    //   319: checkcast 13	com/whatsapp/proto/e$b
    //   322: putfield 146	com/whatsapp/proto/e:e	Lcom/whatsapp/proto/e$b;
    //   325: aload 5
    //   327: ifnull +22 -> 349
    //   330: aload 5
    //   332: aload_0
    //   333: getfield 146	com/whatsapp/proto/e:e	Lcom/whatsapp/proto/e$b;
    //   336: invokevirtual 151	com/whatsapp/proto/e$b$a:a	(Lcom/whatsapp/proto/e$b;)Lcom/whatsapp/proto/e$b$a;
    //   339: pop
    //   340: aload_0
    //   341: aload 5
    //   343: invokevirtual 154	com/whatsapp/proto/e$b$a:c	()Lcom/whatsapp/proto/e$b;
    //   346: putfield 146	com/whatsapp/proto/e:e	Lcom/whatsapp/proto/e$b;
    //   349: aload_0
    //   350: aload_0
    //   351: getfield 104	com/whatsapp/proto/e:b	I
    //   354: iconst_4
    //   355: ior
    //   356: putfield 104	com/whatsapp/proto/e:b	I
    //   359: goto -324 -> 35
    //   362: aload 7
    //   364: invokevirtual 122	com/google/protobuf/g:a	()V
    //   367: aload_0
    //   368: aload 6
    //   370: invokevirtual 127	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   373: putfield 70	com/whatsapp/proto/e:g	Lcom/google/protobuf/e;
    //   376: return
    //   377: astore_1
    //   378: aload_0
    //   379: aload 6
    //   381: invokevirtual 127	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   384: putfield 70	com/whatsapp/proto/e:g	Lcom/google/protobuf/e;
    //   387: return
    //   388: astore_1
    //   389: aload_0
    //   390: aload 6
    //   392: invokevirtual 127	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   395: putfield 70	com/whatsapp/proto/e:g	Lcom/google/protobuf/e;
    //   398: aload_1
    //   399: athrow
    //   400: astore_2
    //   401: aload_0
    //   402: aload 6
    //   404: invokevirtual 127	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   407: putfield 70	com/whatsapp/proto/e:g	Lcom/google/protobuf/e;
    //   410: goto -212 -> 198
    //   413: astore_1
    //   414: aload_0
    //   415: aload 6
    //   417: invokevirtual 127	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   420: putfield 70	com/whatsapp/proto/e:g	Lcom/google/protobuf/e;
    //   423: aload_1
    //   424: athrow
    //   425: aconst_null
    //   426: astore 5
    //   428: goto -118 -> 310
    //   431: aconst_null
    //   432: astore 5
    //   434: goto -215 -> 219
    //   437: aconst_null
    //   438: astore 5
    //   440: goto -317 -> 123
    //   443: goto -355 -> 88
    //   446: iconst_1
    //   447: istore_3
    //   448: goto -413 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	451	0	this	e
    //   0	451	1	paramf	com.google.protobuf.f
    //   0	451	2	paramm	com.google.protobuf.m
    //   34	414	3	j	int
    //   43	47	4	k	int
    //   121	318	5	localObject	Object
    //   21	395	6	localc	com.google.protobuf.e.c
    //   31	332	7	localg	g
    // Exception table:
    //   from	to	target	type
    //   39	45	175	com/google/protobuf/q
    //   88	99	175	com/google/protobuf/q
    //   104	123	175	com/google/protobuf/q
    //   123	138	175	com/google/protobuf/q
    //   143	162	175	com/google/protobuf/q
    //   162	172	175	com/google/protobuf/q
    //   200	219	175	com/google/protobuf/q
    //   219	234	175	com/google/protobuf/q
    //   239	258	175	com/google/protobuf/q
    //   258	268	175	com/google/protobuf/q
    //   291	310	175	com/google/protobuf/q
    //   310	325	175	com/google/protobuf/q
    //   330	349	175	com/google/protobuf/q
    //   349	359	175	com/google/protobuf/q
    //   39	45	183	finally
    //   88	99	183	finally
    //   104	123	183	finally
    //   123	138	183	finally
    //   143	162	183	finally
    //   162	172	183	finally
    //   176	183	183	finally
    //   200	219	183	finally
    //   219	234	183	finally
    //   239	258	183	finally
    //   258	268	183	finally
    //   272	291	183	finally
    //   291	310	183	finally
    //   310	325	183	finally
    //   330	349	183	finally
    //   349	359	183	finally
    //   39	45	271	java/io/IOException
    //   88	99	271	java/io/IOException
    //   104	123	271	java/io/IOException
    //   123	138	271	java/io/IOException
    //   143	162	271	java/io/IOException
    //   162	172	271	java/io/IOException
    //   200	219	271	java/io/IOException
    //   219	234	271	java/io/IOException
    //   239	258	271	java/io/IOException
    //   258	268	271	java/io/IOException
    //   291	310	271	java/io/IOException
    //   310	325	271	java/io/IOException
    //   330	349	271	java/io/IOException
    //   349	359	271	java/io/IOException
    //   362	367	377	java/io/IOException
    //   362	367	388	finally
    //   184	189	400	java/io/IOException
    //   184	189	413	finally
  }
  
  public static e a()
  {
    return f;
  }
  
  public static e a(byte[] paramArrayOfByte)
  {
    return (e)a.a(paramArrayOfByte);
  }
  
  public static a c()
  {
    return a.c();
  }
  
  private void d()
  {
    this.c = c.a();
    this.d = d.a();
    this.e = b.a();
  }
  
  public final boolean b()
  {
    return (this.b & 0x2) == 2;
  }
  
  public final ae<e> getParserForType()
  {
    return a;
  }
  
  public final int getSerializedSize()
  {
    int j = this.i;
    if (j != -1) {
      return j;
    }
    int k = 0;
    if ((this.b & 0x1) == 1) {
      k = g.d(2, this.c) + 0;
    }
    j = k;
    if ((this.b & 0x2) == 2) {
      j = k + g.d(3, this.d);
    }
    k = j;
    if ((this.b & 0x4) == 4) {
      k = j + g.d(4, this.e);
    }
    j = k + this.g.a();
    this.i = j;
    return j;
  }
  
  public final boolean isInitialized()
  {
    int j = this.h;
    if (j == 1) {
      return true;
    }
    if (j == 0) {
      return false;
    }
    this.h = 1;
    return true;
  }
  
  public final void writeTo(g paramg)
  {
    getSerializedSize();
    if ((this.b & 0x1) == 1) {
      paramg.b(2, this.c);
    }
    if ((this.b & 0x2) == 2) {
      paramg.b(3, this.d);
    }
    if ((this.b & 0x4) == 4) {
      paramg.b(4, this.e);
    }
    paramg.c(this.g);
  }
  
  public static final class a
    extends GeneratedMessageLite.a<e, a>
    implements f.a
  {
    public int b;
    public e.b c = e.b.a();
    private e.c d = e.c.a();
    private e.d e = e.d.a();
    
    /* Error */
    private a a(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
    {
      // Byte code:
      //   0: getstatic 50	com/whatsapp/proto/e:a	Lcom/google/protobuf/ae;
      //   3: aload_1
      //   4: aload_2
      //   5: invokeinterface 55 3 0
      //   10: checkcast 9	com/whatsapp/proto/e
      //   13: astore_1
      //   14: aload_1
      //   15: ifnull +9 -> 24
      //   18: aload_0
      //   19: aload_1
      //   20: invokevirtual 58	com/whatsapp/proto/e$a:a	(Lcom/whatsapp/proto/e;)Lcom/whatsapp/proto/e$a;
      //   23: pop
      //   24: aload_0
      //   25: areturn
      //   26: astore_2
      //   27: aload_2
      //   28: getfield 61	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   31: checkcast 9	com/whatsapp/proto/e
      //   34: astore_1
      //   35: aload_2
      //   36: athrow
      //   37: astore_2
      //   38: aload_1
      //   39: ifnull +9 -> 48
      //   42: aload_0
      //   43: aload_1
      //   44: invokevirtual 58	com/whatsapp/proto/e$a:a	(Lcom/whatsapp/proto/e;)Lcom/whatsapp/proto/e$a;
      //   47: pop
      //   48: aload_2
      //   49: athrow
      //   50: astore_2
      //   51: aconst_null
      //   52: astore_1
      //   53: goto -15 -> 38
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	56	0	this	a
      //   0	56	1	paramf	com.google.protobuf.f
      //   0	56	2	paramm	com.google.protobuf.m
      // Exception table:
      //   from	to	target	type
      //   0	14	26	com/google/protobuf/q
      //   35	37	37	finally
      //   0	14	50	finally
      //   27	35	50	finally
    }
    
    private a d()
    {
      return new a().a(e());
    }
    
    private e e()
    {
      int j = 1;
      e locale = new e(this, (byte)0);
      int k = this.b;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        e.a(locale, this.d);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        e.a(locale, this.e);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        e.a(locale, this.c);
        e.a(locale, j);
        return locale;
        j = 0;
      }
    }
    
    public final a a(e.c paramc)
    {
      if (paramc == null) {
        throw new NullPointerException();
      }
      this.d = paramc;
      this.b |= 0x1;
      return this;
    }
    
    public final a a(e parame)
    {
      int j = 1;
      if (parame == e.a()) {
        return this;
      }
      int i;
      Object localObject;
      if ((parame.b & 0x1) == 1)
      {
        i = 1;
        if (i != 0)
        {
          localObject = parame.c;
          if (((this.b & 0x1) != 1) || (this.d == e.c.a())) {
            break label237;
          }
          this.d = e.c.a(this.d).a((e.c)localObject).c();
          label72:
          this.b |= 0x1;
        }
        if (parame.b())
        {
          localObject = parame.d;
          if (((this.b & 0x2) != 2) || (this.e == e.d.a())) {
            break label246;
          }
          this.e = e.d.a(this.e).a((e.d)localObject).b();
          label134:
          this.b |= 0x2;
        }
        if ((parame.b & 0x4) != 4) {
          break label255;
        }
        i = j;
        label156:
        if (i != 0)
        {
          localObject = parame.e;
          if (((this.b & 0x4) != 4) || (this.c == e.b.a())) {
            break label260;
          }
        }
      }
      label237:
      label246:
      label255:
      label260:
      for (this.c = e.b.a(this.c).a((e.b)localObject).c();; this.c = ((e.b)localObject))
      {
        this.b |= 0x4;
        this.a = this.a.a(e.a(parame));
        return this;
        i = 0;
        break;
        this.d = ((e.c)localObject);
        break label72;
        this.e = ((e.d)localObject);
        break label134;
        i = 0;
        break label156;
      }
    }
    
    public final e b()
    {
      e locale = e();
      if (!locale.isInitialized()) {
        throw new am();
      }
      return locale;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
  
  public static final class b
    extends GeneratedMessageLite
    implements f.a
  {
    public static ae<b> a = new c() {};
    private static final b e;
    int b;
    com.google.protobuf.e c;
    com.google.protobuf.e d;
    private final com.google.protobuf.e f;
    private byte g = -1;
    private int h = -1;
    
    static
    {
      b localb = new b();
      e = localb;
      localb.c();
    }
    
    private b()
    {
      this.f = com.google.protobuf.e.b;
    }
    
    private b(GeneratedMessageLite.a parama)
    {
      super();
      this.f = parama.a;
    }
    
    /* Error */
    private b(com.google.protobuf.f paramf)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 40	com/google/protobuf/GeneratedMessageLite:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 42	com/whatsapp/proto/e$b:g	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 44	com/whatsapp/proto/e$b:h	I
      //   14: aload_0
      //   15: invokespecial 38	com/whatsapp/proto/e$b:c	()V
      //   18: invokestatic 69	com/google/protobuf/e:h	()Lcom/google/protobuf/e$c;
      //   21: astore 4
      //   23: aload 4
      //   25: sipush 4096
      //   28: invokestatic 74	com/google/protobuf/g:a	(Ljava/io/OutputStream;I)Lcom/google/protobuf/g;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_2
      //   35: iload_2
      //   36: ifne +146 -> 182
      //   39: aload_1
      //   40: invokevirtual 79	com/google/protobuf/f:a	()I
      //   43: istore_3
      //   44: iload_3
      //   45: lookupswitch	default:+201->246, 0:+204->249, 10:+50->95, 18:+96->141
      //   80: aload_1
      //   81: iload_3
      //   82: aload 5
      //   84: invokevirtual 82	com/google/protobuf/f:a	(ILcom/google/protobuf/g;)Z
      //   87: ifne -52 -> 35
      //   90: iconst_1
      //   91: istore_2
      //   92: goto -57 -> 35
      //   95: aload_0
      //   96: aload_0
      //   97: getfield 84	com/whatsapp/proto/e$b:b	I
      //   100: iconst_1
      //   101: ior
      //   102: putfield 84	com/whatsapp/proto/e$b:b	I
      //   105: aload_0
      //   106: aload_1
      //   107: invokevirtual 87	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   110: putfield 89	com/whatsapp/proto/e$b:c	Lcom/google/protobuf/e;
      //   113: goto -78 -> 35
      //   116: astore_1
      //   117: aload_1
      //   118: aload_0
      //   119: putfield 92	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   122: aload_1
      //   123: athrow
      //   124: astore_1
      //   125: aload 5
      //   127: invokevirtual 94	com/google/protobuf/g:a	()V
      //   130: aload_0
      //   131: aload 4
      //   133: invokevirtual 98	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   136: putfield 50	com/whatsapp/proto/e$b:f	Lcom/google/protobuf/e;
      //   139: aload_1
      //   140: athrow
      //   141: aload_0
      //   142: aload_0
      //   143: getfield 84	com/whatsapp/proto/e$b:b	I
      //   146: iconst_2
      //   147: ior
      //   148: putfield 84	com/whatsapp/proto/e$b:b	I
      //   151: aload_0
      //   152: aload_1
      //   153: invokevirtual 87	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   156: putfield 100	com/whatsapp/proto/e$b:d	Lcom/google/protobuf/e;
      //   159: goto -124 -> 35
      //   162: astore_1
      //   163: new 64	com/google/protobuf/q
      //   166: dup
      //   167: aload_1
      //   168: invokevirtual 104	java/io/IOException:getMessage	()Ljava/lang/String;
      //   171: invokespecial 107	com/google/protobuf/q:<init>	(Ljava/lang/String;)V
      //   174: astore_1
      //   175: aload_1
      //   176: aload_0
      //   177: putfield 92	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   180: aload_1
      //   181: athrow
      //   182: aload 5
      //   184: invokevirtual 94	com/google/protobuf/g:a	()V
      //   187: aload_0
      //   188: aload 4
      //   190: invokevirtual 98	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   193: putfield 50	com/whatsapp/proto/e$b:f	Lcom/google/protobuf/e;
      //   196: return
      //   197: astore_1
      //   198: aload_0
      //   199: aload 4
      //   201: invokevirtual 98	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   204: putfield 50	com/whatsapp/proto/e$b:f	Lcom/google/protobuf/e;
      //   207: return
      //   208: astore_1
      //   209: aload_0
      //   210: aload 4
      //   212: invokevirtual 98	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   215: putfield 50	com/whatsapp/proto/e$b:f	Lcom/google/protobuf/e;
      //   218: aload_1
      //   219: athrow
      //   220: astore 5
      //   222: aload_0
      //   223: aload 4
      //   225: invokevirtual 98	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   228: putfield 50	com/whatsapp/proto/e$b:f	Lcom/google/protobuf/e;
      //   231: goto -92 -> 139
      //   234: astore_1
      //   235: aload_0
      //   236: aload 4
      //   238: invokevirtual 98	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   241: putfield 50	com/whatsapp/proto/e$b:f	Lcom/google/protobuf/e;
      //   244: aload_1
      //   245: athrow
      //   246: goto -166 -> 80
      //   249: iconst_1
      //   250: istore_2
      //   251: goto -216 -> 35
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	254	0	this	b
      //   0	254	1	paramf	com.google.protobuf.f
      //   34	217	2	i	int
      //   43	39	3	j	int
      //   21	216	4	localc	com.google.protobuf.e.c
      //   31	152	5	localg	g
      //   220	1	5	localIOException	java.io.IOException
      // Exception table:
      //   from	to	target	type
      //   39	44	116	com/google/protobuf/q
      //   80	90	116	com/google/protobuf/q
      //   95	113	116	com/google/protobuf/q
      //   141	159	116	com/google/protobuf/q
      //   39	44	124	finally
      //   80	90	124	finally
      //   95	113	124	finally
      //   117	124	124	finally
      //   141	159	124	finally
      //   163	182	124	finally
      //   39	44	162	java/io/IOException
      //   80	90	162	java/io/IOException
      //   95	113	162	java/io/IOException
      //   141	159	162	java/io/IOException
      //   182	187	197	java/io/IOException
      //   182	187	208	finally
      //   125	130	220	java/io/IOException
      //   125	130	234	finally
    }
    
    public static a a(b paramb)
    {
      return a.d().a(paramb);
    }
    
    public static b a()
    {
      return e;
    }
    
    public static a b()
    {
      return a.d();
    }
    
    private void c()
    {
      this.c = com.google.protobuf.e.b;
      this.d = com.google.protobuf.e.b;
    }
    
    public final ae<b> getParserForType()
    {
      return a;
    }
    
    public final int getSerializedSize()
    {
      int i = this.h;
      if (i != -1) {
        return i;
      }
      i = 0;
      if ((this.b & 0x1) == 1) {
        i = g.c(1, this.c) + 0;
      }
      int j = i;
      if ((this.b & 0x2) == 2) {
        j = i + g.c(2, this.d);
      }
      i = j + this.f.a();
      this.h = i;
      return i;
    }
    
    public final boolean isInitialized()
    {
      int i = this.g;
      if (i == 1) {
        return true;
      }
      if (i == 0) {
        return false;
      }
      this.g = 1;
      return true;
    }
    
    public final void writeTo(g paramg)
    {
      getSerializedSize();
      if ((this.b & 0x1) == 1) {
        paramg.a(1, this.c);
      }
      if ((this.b & 0x2) == 2) {
        paramg.a(2, this.d);
      }
      paramg.c(this.f);
    }
    
    public static final class a
      extends GeneratedMessageLite.a<e.b, a>
      implements f.a
    {
      private int b;
      private com.google.protobuf.e c = com.google.protobuf.e.b;
      private com.google.protobuf.e d = com.google.protobuf.e.b;
      
      /* Error */
      private a a(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
      {
        // Byte code:
        //   0: getstatic 36	com/whatsapp/proto/e$b:a	Lcom/google/protobuf/ae;
        //   3: aload_1
        //   4: aload_2
        //   5: invokeinterface 41 3 0
        //   10: checkcast 9	com/whatsapp/proto/e$b
        //   13: astore_1
        //   14: aload_1
        //   15: ifnull +9 -> 24
        //   18: aload_0
        //   19: aload_1
        //   20: invokevirtual 44	com/whatsapp/proto/e$b$a:a	(Lcom/whatsapp/proto/e$b;)Lcom/whatsapp/proto/e$b$a;
        //   23: pop
        //   24: aload_0
        //   25: areturn
        //   26: astore_2
        //   27: aload_2
        //   28: getfield 47	com/google/protobuf/q:a	Lcom/google/protobuf/x;
        //   31: checkcast 9	com/whatsapp/proto/e$b
        //   34: astore_1
        //   35: aload_2
        //   36: athrow
        //   37: astore_2
        //   38: aload_1
        //   39: ifnull +9 -> 48
        //   42: aload_0
        //   43: aload_1
        //   44: invokevirtual 44	com/whatsapp/proto/e$b$a:a	(Lcom/whatsapp/proto/e$b;)Lcom/whatsapp/proto/e$b$a;
        //   47: pop
        //   48: aload_2
        //   49: athrow
        //   50: astore_2
        //   51: aconst_null
        //   52: astore_1
        //   53: goto -15 -> 38
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	56	0	this	a
        //   0	56	1	paramf	com.google.protobuf.f
        //   0	56	2	paramm	com.google.protobuf.m
        // Exception table:
        //   from	to	target	type
        //   0	14	26	com/google/protobuf/q
        //   35	37	37	finally
        //   0	14	50	finally
        //   27	35	50	finally
      }
      
      private a e()
      {
        return new a().a(c());
      }
      
      public final a a(com.google.protobuf.e parame)
      {
        if (parame == null) {
          throw new NullPointerException();
        }
        this.b |= 0x1;
        this.c = parame;
        return this;
      }
      
      public final a a(e.b paramb)
      {
        int j = 1;
        if (paramb == e.b.a()) {
          return this;
        }
        if ((paramb.b & 0x1) == 1)
        {
          i = 1;
          if (i != 0) {
            a(paramb.c);
          }
          if ((paramb.b & 0x2) != 2) {
            break label83;
          }
        }
        label83:
        for (int i = j;; i = 0)
        {
          if (i != 0) {
            b(paramb.d);
          }
          this.a = this.a.a(e.b.b(paramb));
          return this;
          i = 0;
          break;
        }
      }
      
      public final a b(com.google.protobuf.e parame)
      {
        if (parame == null) {
          throw new NullPointerException();
        }
        this.b |= 0x2;
        this.d = parame;
        return this;
      }
      
      public final e.b b()
      {
        e.b localb = c();
        if (!localb.isInitialized()) {
          throw new am();
        }
        return localb;
      }
      
      public final e.b c()
      {
        int i = 1;
        e.b localb = new e.b(this, (byte)0);
        int k = this.b;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          e.b.a(localb, this.c);
          int j = i;
          if ((k & 0x2) == 2) {
            j = i | 0x2;
          }
          e.b.b(localb, this.d);
          e.b.a(localb, j);
          return localb;
          i = 0;
        }
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
  
  public static final class c
    extends GeneratedMessageLite
    implements f.a
  {
    public static ae<c> a = new c() {};
    private static final c f;
    int b;
    com.google.protobuf.e c;
    com.google.protobuf.e d;
    com.google.protobuf.e e;
    private final com.google.protobuf.e g;
    private byte h = -1;
    private int i = -1;
    
    static
    {
      c localc = new c();
      f = localc;
      localc.c();
    }
    
    private c()
    {
      this.g = com.google.protobuf.e.b;
    }
    
    private c(GeneratedMessageLite.a parama)
    {
      super();
      this.g = parama.a;
    }
    
    /* Error */
    private c(com.google.protobuf.f paramf)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 41	com/google/protobuf/GeneratedMessageLite:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 43	com/whatsapp/proto/e$c:h	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 45	com/whatsapp/proto/e$c:i	I
      //   14: aload_0
      //   15: invokespecial 39	com/whatsapp/proto/e$c:c	()V
      //   18: invokestatic 70	com/google/protobuf/e:h	()Lcom/google/protobuf/e$c;
      //   21: astore 4
      //   23: aload 4
      //   25: sipush 4096
      //   28: invokestatic 75	com/google/protobuf/g:a	(Ljava/io/OutputStream;I)Lcom/google/protobuf/g;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_2
      //   35: iload_2
      //   36: ifne +175 -> 211
      //   39: aload_1
      //   40: invokevirtual 80	com/google/protobuf/f:a	()I
      //   43: istore_3
      //   44: iload_3
      //   45: lookupswitch	default:+230->275, 0:+233->278, 10:+58->103, 18:+104->149, 26:+145->190
      //   88: aload_1
      //   89: iload_3
      //   90: aload 5
      //   92: invokevirtual 83	com/google/protobuf/f:a	(ILcom/google/protobuf/g;)Z
      //   95: ifne -60 -> 35
      //   98: iconst_1
      //   99: istore_2
      //   100: goto -65 -> 35
      //   103: aload_0
      //   104: aload_0
      //   105: getfield 85	com/whatsapp/proto/e$c:b	I
      //   108: iconst_1
      //   109: ior
      //   110: putfield 85	com/whatsapp/proto/e$c:b	I
      //   113: aload_0
      //   114: aload_1
      //   115: invokevirtual 88	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   118: putfield 90	com/whatsapp/proto/e$c:c	Lcom/google/protobuf/e;
      //   121: goto -86 -> 35
      //   124: astore_1
      //   125: aload_1
      //   126: aload_0
      //   127: putfield 93	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   130: aload_1
      //   131: athrow
      //   132: astore_1
      //   133: aload 5
      //   135: invokevirtual 95	com/google/protobuf/g:a	()V
      //   138: aload_0
      //   139: aload 4
      //   141: invokevirtual 99	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   144: putfield 51	com/whatsapp/proto/e$c:g	Lcom/google/protobuf/e;
      //   147: aload_1
      //   148: athrow
      //   149: aload_0
      //   150: aload_0
      //   151: getfield 85	com/whatsapp/proto/e$c:b	I
      //   154: iconst_2
      //   155: ior
      //   156: putfield 85	com/whatsapp/proto/e$c:b	I
      //   159: aload_0
      //   160: aload_1
      //   161: invokevirtual 88	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   164: putfield 101	com/whatsapp/proto/e$c:d	Lcom/google/protobuf/e;
      //   167: goto -132 -> 35
      //   170: astore_1
      //   171: new 65	com/google/protobuf/q
      //   174: dup
      //   175: aload_1
      //   176: invokevirtual 105	java/io/IOException:getMessage	()Ljava/lang/String;
      //   179: invokespecial 108	com/google/protobuf/q:<init>	(Ljava/lang/String;)V
      //   182: astore_1
      //   183: aload_1
      //   184: aload_0
      //   185: putfield 93	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   188: aload_1
      //   189: athrow
      //   190: aload_0
      //   191: aload_0
      //   192: getfield 85	com/whatsapp/proto/e$c:b	I
      //   195: iconst_4
      //   196: ior
      //   197: putfield 85	com/whatsapp/proto/e$c:b	I
      //   200: aload_0
      //   201: aload_1
      //   202: invokevirtual 88	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   205: putfield 110	com/whatsapp/proto/e$c:e	Lcom/google/protobuf/e;
      //   208: goto -173 -> 35
      //   211: aload 5
      //   213: invokevirtual 95	com/google/protobuf/g:a	()V
      //   216: aload_0
      //   217: aload 4
      //   219: invokevirtual 99	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   222: putfield 51	com/whatsapp/proto/e$c:g	Lcom/google/protobuf/e;
      //   225: return
      //   226: astore_1
      //   227: aload_0
      //   228: aload 4
      //   230: invokevirtual 99	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   233: putfield 51	com/whatsapp/proto/e$c:g	Lcom/google/protobuf/e;
      //   236: return
      //   237: astore_1
      //   238: aload_0
      //   239: aload 4
      //   241: invokevirtual 99	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   244: putfield 51	com/whatsapp/proto/e$c:g	Lcom/google/protobuf/e;
      //   247: aload_1
      //   248: athrow
      //   249: astore 5
      //   251: aload_0
      //   252: aload 4
      //   254: invokevirtual 99	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   257: putfield 51	com/whatsapp/proto/e$c:g	Lcom/google/protobuf/e;
      //   260: goto -113 -> 147
      //   263: astore_1
      //   264: aload_0
      //   265: aload 4
      //   267: invokevirtual 99	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   270: putfield 51	com/whatsapp/proto/e$c:g	Lcom/google/protobuf/e;
      //   273: aload_1
      //   274: athrow
      //   275: goto -187 -> 88
      //   278: iconst_1
      //   279: istore_2
      //   280: goto -245 -> 35
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	283	0	this	c
      //   0	283	1	paramf	com.google.protobuf.f
      //   34	246	2	j	int
      //   43	47	3	k	int
      //   21	245	4	localc	com.google.protobuf.e.c
      //   31	181	5	localg	g
      //   249	1	5	localIOException	java.io.IOException
      // Exception table:
      //   from	to	target	type
      //   39	44	124	com/google/protobuf/q
      //   88	98	124	com/google/protobuf/q
      //   103	121	124	com/google/protobuf/q
      //   149	167	124	com/google/protobuf/q
      //   190	208	124	com/google/protobuf/q
      //   39	44	132	finally
      //   88	98	132	finally
      //   103	121	132	finally
      //   125	132	132	finally
      //   149	167	132	finally
      //   171	190	132	finally
      //   190	208	132	finally
      //   39	44	170	java/io/IOException
      //   88	98	170	java/io/IOException
      //   103	121	170	java/io/IOException
      //   149	167	170	java/io/IOException
      //   190	208	170	java/io/IOException
      //   211	216	226	java/io/IOException
      //   211	216	237	finally
      //   133	138	249	java/io/IOException
      //   133	138	263	finally
    }
    
    public static a a(c paramc)
    {
      return a.d().a(paramc);
    }
    
    public static c a()
    {
      return f;
    }
    
    public static a b()
    {
      return a.d();
    }
    
    private void c()
    {
      this.c = com.google.protobuf.e.b;
      this.d = com.google.protobuf.e.b;
      this.e = com.google.protobuf.e.b;
    }
    
    public final ae<c> getParserForType()
    {
      return a;
    }
    
    public final int getSerializedSize()
    {
      int j = this.i;
      if (j != -1) {
        return j;
      }
      int k = 0;
      if ((this.b & 0x1) == 1) {
        k = g.c(1, this.c) + 0;
      }
      j = k;
      if ((this.b & 0x2) == 2) {
        j = k + g.c(2, this.d);
      }
      k = j;
      if ((this.b & 0x4) == 4) {
        k = j + g.c(3, this.e);
      }
      j = k + this.g.a();
      this.i = j;
      return j;
    }
    
    public final boolean isInitialized()
    {
      int j = this.h;
      if (j == 1) {
        return true;
      }
      if (j == 0) {
        return false;
      }
      this.h = 1;
      return true;
    }
    
    public final void writeTo(g paramg)
    {
      getSerializedSize();
      if ((this.b & 0x1) == 1) {
        paramg.a(1, this.c);
      }
      if ((this.b & 0x2) == 2) {
        paramg.a(2, this.d);
      }
      if ((this.b & 0x4) == 4) {
        paramg.a(3, this.e);
      }
      paramg.c(this.g);
    }
    
    public static final class a
      extends GeneratedMessageLite.a<e.c, a>
      implements f.a
    {
      private int b;
      private com.google.protobuf.e c = com.google.protobuf.e.b;
      private com.google.protobuf.e d = com.google.protobuf.e.b;
      private com.google.protobuf.e e = com.google.protobuf.e.b;
      
      /* Error */
      private a a(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
      {
        // Byte code:
        //   0: getstatic 39	com/whatsapp/proto/e$c:a	Lcom/google/protobuf/ae;
        //   3: aload_1
        //   4: aload_2
        //   5: invokeinterface 44 3 0
        //   10: checkcast 9	com/whatsapp/proto/e$c
        //   13: astore_1
        //   14: aload_1
        //   15: ifnull +9 -> 24
        //   18: aload_0
        //   19: aload_1
        //   20: invokevirtual 47	com/whatsapp/proto/e$c$a:a	(Lcom/whatsapp/proto/e$c;)Lcom/whatsapp/proto/e$c$a;
        //   23: pop
        //   24: aload_0
        //   25: areturn
        //   26: astore_2
        //   27: aload_2
        //   28: getfield 50	com/google/protobuf/q:a	Lcom/google/protobuf/x;
        //   31: checkcast 9	com/whatsapp/proto/e$c
        //   34: astore_1
        //   35: aload_2
        //   36: athrow
        //   37: astore_2
        //   38: aload_1
        //   39: ifnull +9 -> 48
        //   42: aload_0
        //   43: aload_1
        //   44: invokevirtual 47	com/whatsapp/proto/e$c$a:a	(Lcom/whatsapp/proto/e$c;)Lcom/whatsapp/proto/e$c$a;
        //   47: pop
        //   48: aload_2
        //   49: athrow
        //   50: astore_2
        //   51: aconst_null
        //   52: astore_1
        //   53: goto -15 -> 38
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	56	0	this	a
        //   0	56	1	paramf	com.google.protobuf.f
        //   0	56	2	paramm	com.google.protobuf.m
        // Exception table:
        //   from	to	target	type
        //   0	14	26	com/google/protobuf/q
        //   35	37	37	finally
        //   0	14	50	finally
        //   27	35	50	finally
      }
      
      private a e()
      {
        return new a().a(c());
      }
      
      public final a a(com.google.protobuf.e parame)
      {
        if (parame == null) {
          throw new NullPointerException();
        }
        this.b |= 0x1;
        this.c = parame;
        return this;
      }
      
      public final a a(e.c paramc)
      {
        int j = 1;
        if (paramc == e.c.a()) {
          return this;
        }
        if ((paramc.b & 0x1) == 1)
        {
          i = 1;
          if (i != 0) {
            a(paramc.c);
          }
          if ((paramc.b & 0x2) != 2) {
            break label108;
          }
          i = 1;
          label48:
          if (i != 0) {
            b(paramc.d);
          }
          if ((paramc.b & 0x4) != 4) {
            break label113;
          }
        }
        label108:
        label113:
        for (int i = j;; i = 0)
        {
          if (i != 0) {
            c(paramc.e);
          }
          this.a = this.a.a(e.c.b(paramc));
          return this;
          i = 0;
          break;
          i = 0;
          break label48;
        }
      }
      
      public final a b(com.google.protobuf.e parame)
      {
        if (parame == null) {
          throw new NullPointerException();
        }
        this.b |= 0x2;
        this.d = parame;
        return this;
      }
      
      public final e.c b()
      {
        e.c localc = c();
        if (!localc.isInitialized()) {
          throw new am();
        }
        return localc;
      }
      
      public final a c(com.google.protobuf.e parame)
      {
        if (parame == null) {
          throw new NullPointerException();
        }
        this.b |= 0x4;
        this.e = parame;
        return this;
      }
      
      public final e.c c()
      {
        int j = 1;
        e.c localc = new e.c(this, (byte)0);
        int k = this.b;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          e.c.a(localc, this.c);
          int i = j;
          if ((k & 0x2) == 2) {
            i = j | 0x2;
          }
          e.c.b(localc, this.d);
          j = i;
          if ((k & 0x4) == 4) {
            j = i | 0x4;
          }
          e.c.c(localc, this.e);
          e.c.a(localc, j);
          return localc;
          j = 0;
        }
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
  
  public static final class d
    extends GeneratedMessageLite
    implements f.a
  {
    public static ae<d> a = new c() {};
    private static final d f;
    int b;
    public com.google.protobuf.e c;
    public com.google.protobuf.e d;
    public com.google.protobuf.e e;
    private final com.google.protobuf.e g;
    private byte h = -1;
    private int i = -1;
    
    static
    {
      d locald = new d();
      f = locald;
      locald.c();
    }
    
    private d()
    {
      this.g = com.google.protobuf.e.b;
    }
    
    private d(GeneratedMessageLite.a parama)
    {
      super();
      this.g = parama.a;
    }
    
    /* Error */
    private d(com.google.protobuf.f paramf)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 41	com/google/protobuf/GeneratedMessageLite:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 43	com/whatsapp/proto/e$d:h	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 45	com/whatsapp/proto/e$d:i	I
      //   14: aload_0
      //   15: invokespecial 39	com/whatsapp/proto/e$d:c	()V
      //   18: invokestatic 70	com/google/protobuf/e:h	()Lcom/google/protobuf/e$c;
      //   21: astore 4
      //   23: aload 4
      //   25: sipush 4096
      //   28: invokestatic 75	com/google/protobuf/g:a	(Ljava/io/OutputStream;I)Lcom/google/protobuf/g;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_2
      //   35: iload_2
      //   36: ifne +175 -> 211
      //   39: aload_1
      //   40: invokevirtual 80	com/google/protobuf/f:a	()I
      //   43: istore_3
      //   44: iload_3
      //   45: lookupswitch	default:+230->275, 0:+233->278, 10:+58->103, 18:+104->149, 26:+145->190
      //   88: aload_1
      //   89: iload_3
      //   90: aload 5
      //   92: invokevirtual 83	com/google/protobuf/f:a	(ILcom/google/protobuf/g;)Z
      //   95: ifne -60 -> 35
      //   98: iconst_1
      //   99: istore_2
      //   100: goto -65 -> 35
      //   103: aload_0
      //   104: aload_0
      //   105: getfield 85	com/whatsapp/proto/e$d:b	I
      //   108: iconst_1
      //   109: ior
      //   110: putfield 85	com/whatsapp/proto/e$d:b	I
      //   113: aload_0
      //   114: aload_1
      //   115: invokevirtual 88	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   118: putfield 90	com/whatsapp/proto/e$d:c	Lcom/google/protobuf/e;
      //   121: goto -86 -> 35
      //   124: astore_1
      //   125: aload_1
      //   126: aload_0
      //   127: putfield 93	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   130: aload_1
      //   131: athrow
      //   132: astore_1
      //   133: aload 5
      //   135: invokevirtual 95	com/google/protobuf/g:a	()V
      //   138: aload_0
      //   139: aload 4
      //   141: invokevirtual 99	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   144: putfield 51	com/whatsapp/proto/e$d:g	Lcom/google/protobuf/e;
      //   147: aload_1
      //   148: athrow
      //   149: aload_0
      //   150: aload_0
      //   151: getfield 85	com/whatsapp/proto/e$d:b	I
      //   154: iconst_2
      //   155: ior
      //   156: putfield 85	com/whatsapp/proto/e$d:b	I
      //   159: aload_0
      //   160: aload_1
      //   161: invokevirtual 88	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   164: putfield 101	com/whatsapp/proto/e$d:d	Lcom/google/protobuf/e;
      //   167: goto -132 -> 35
      //   170: astore_1
      //   171: new 65	com/google/protobuf/q
      //   174: dup
      //   175: aload_1
      //   176: invokevirtual 105	java/io/IOException:getMessage	()Ljava/lang/String;
      //   179: invokespecial 108	com/google/protobuf/q:<init>	(Ljava/lang/String;)V
      //   182: astore_1
      //   183: aload_1
      //   184: aload_0
      //   185: putfield 93	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   188: aload_1
      //   189: athrow
      //   190: aload_0
      //   191: aload_0
      //   192: getfield 85	com/whatsapp/proto/e$d:b	I
      //   195: iconst_4
      //   196: ior
      //   197: putfield 85	com/whatsapp/proto/e$d:b	I
      //   200: aload_0
      //   201: aload_1
      //   202: invokevirtual 88	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   205: putfield 110	com/whatsapp/proto/e$d:e	Lcom/google/protobuf/e;
      //   208: goto -173 -> 35
      //   211: aload 5
      //   213: invokevirtual 95	com/google/protobuf/g:a	()V
      //   216: aload_0
      //   217: aload 4
      //   219: invokevirtual 99	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   222: putfield 51	com/whatsapp/proto/e$d:g	Lcom/google/protobuf/e;
      //   225: return
      //   226: astore_1
      //   227: aload_0
      //   228: aload 4
      //   230: invokevirtual 99	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   233: putfield 51	com/whatsapp/proto/e$d:g	Lcom/google/protobuf/e;
      //   236: return
      //   237: astore_1
      //   238: aload_0
      //   239: aload 4
      //   241: invokevirtual 99	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   244: putfield 51	com/whatsapp/proto/e$d:g	Lcom/google/protobuf/e;
      //   247: aload_1
      //   248: athrow
      //   249: astore 5
      //   251: aload_0
      //   252: aload 4
      //   254: invokevirtual 99	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   257: putfield 51	com/whatsapp/proto/e$d:g	Lcom/google/protobuf/e;
      //   260: goto -113 -> 147
      //   263: astore_1
      //   264: aload_0
      //   265: aload 4
      //   267: invokevirtual 99	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   270: putfield 51	com/whatsapp/proto/e$d:g	Lcom/google/protobuf/e;
      //   273: aload_1
      //   274: athrow
      //   275: goto -187 -> 88
      //   278: iconst_1
      //   279: istore_2
      //   280: goto -245 -> 35
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	283	0	this	d
      //   0	283	1	paramf	com.google.protobuf.f
      //   34	246	2	j	int
      //   43	47	3	k	int
      //   21	245	4	localc	com.google.protobuf.e.c
      //   31	181	5	localg	g
      //   249	1	5	localIOException	java.io.IOException
      // Exception table:
      //   from	to	target	type
      //   39	44	124	com/google/protobuf/q
      //   88	98	124	com/google/protobuf/q
      //   103	121	124	com/google/protobuf/q
      //   149	167	124	com/google/protobuf/q
      //   190	208	124	com/google/protobuf/q
      //   39	44	132	finally
      //   88	98	132	finally
      //   103	121	132	finally
      //   125	132	132	finally
      //   149	167	132	finally
      //   171	190	132	finally
      //   190	208	132	finally
      //   39	44	170	java/io/IOException
      //   88	98	170	java/io/IOException
      //   103	121	170	java/io/IOException
      //   149	167	170	java/io/IOException
      //   190	208	170	java/io/IOException
      //   211	216	226	java/io/IOException
      //   211	216	237	finally
      //   133	138	249	java/io/IOException
      //   133	138	263	finally
    }
    
    public static a a(d paramd)
    {
      return a.c().a(paramd);
    }
    
    public static d a()
    {
      return f;
    }
    
    private void c()
    {
      this.c = com.google.protobuf.e.b;
      this.d = com.google.protobuf.e.b;
      this.e = com.google.protobuf.e.b;
    }
    
    public final boolean b()
    {
      return (this.b & 0x2) == 2;
    }
    
    public final ae<d> getParserForType()
    {
      return a;
    }
    
    public final int getSerializedSize()
    {
      int j = this.i;
      if (j != -1) {
        return j;
      }
      int k = 0;
      if ((this.b & 0x1) == 1) {
        k = g.c(1, this.c) + 0;
      }
      j = k;
      if ((this.b & 0x2) == 2) {
        j = k + g.c(2, this.d);
      }
      k = j;
      if ((this.b & 0x4) == 4) {
        k = j + g.c(3, this.e);
      }
      j = k + this.g.a();
      this.i = j;
      return j;
    }
    
    public final boolean isInitialized()
    {
      int j = this.h;
      if (j == 1) {
        return true;
      }
      if (j == 0) {
        return false;
      }
      this.h = 1;
      return true;
    }
    
    public final void writeTo(g paramg)
    {
      getSerializedSize();
      if ((this.b & 0x1) == 1) {
        paramg.a(1, this.c);
      }
      if ((this.b & 0x2) == 2) {
        paramg.a(2, this.d);
      }
      if ((this.b & 0x4) == 4) {
        paramg.a(3, this.e);
      }
      paramg.c(this.g);
    }
    
    public static final class a
      extends GeneratedMessageLite.a<e.d, a>
      implements f.a
    {
      private int b;
      private com.google.protobuf.e c = com.google.protobuf.e.b;
      private com.google.protobuf.e d = com.google.protobuf.e.b;
      private com.google.protobuf.e e = com.google.protobuf.e.b;
      
      /* Error */
      private a a(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
      {
        // Byte code:
        //   0: getstatic 39	com/whatsapp/proto/e$d:a	Lcom/google/protobuf/ae;
        //   3: aload_1
        //   4: aload_2
        //   5: invokeinterface 44 3 0
        //   10: checkcast 9	com/whatsapp/proto/e$d
        //   13: astore_1
        //   14: aload_1
        //   15: ifnull +9 -> 24
        //   18: aload_0
        //   19: aload_1
        //   20: invokevirtual 47	com/whatsapp/proto/e$d$a:a	(Lcom/whatsapp/proto/e$d;)Lcom/whatsapp/proto/e$d$a;
        //   23: pop
        //   24: aload_0
        //   25: areturn
        //   26: astore_2
        //   27: aload_2
        //   28: getfield 50	com/google/protobuf/q:a	Lcom/google/protobuf/x;
        //   31: checkcast 9	com/whatsapp/proto/e$d
        //   34: astore_1
        //   35: aload_2
        //   36: athrow
        //   37: astore_2
        //   38: aload_1
        //   39: ifnull +9 -> 48
        //   42: aload_0
        //   43: aload_1
        //   44: invokevirtual 47	com/whatsapp/proto/e$d$a:a	(Lcom/whatsapp/proto/e$d;)Lcom/whatsapp/proto/e$d$a;
        //   47: pop
        //   48: aload_2
        //   49: athrow
        //   50: astore_2
        //   51: aconst_null
        //   52: astore_1
        //   53: goto -15 -> 38
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	56	0	this	a
        //   0	56	1	paramf	com.google.protobuf.f
        //   0	56	2	paramm	com.google.protobuf.m
        // Exception table:
        //   from	to	target	type
        //   0	14	26	com/google/protobuf/q
        //   35	37	37	finally
        //   0	14	50	finally
        //   27	35	50	finally
      }
      
      private a d()
      {
        return new a().a(b());
      }
      
      public final a a(e.d paramd)
      {
        int j = 1;
        if (paramd == e.d.a()) {
          return this;
        }
        int i;
        if ((paramd.b & 0x1) == 1) {
          i = 1;
        }
        com.google.protobuf.e locale;
        while (i != 0)
        {
          locale = paramd.c;
          if (locale == null)
          {
            throw new NullPointerException();
            i = 0;
          }
          else
          {
            this.b |= 0x1;
            this.c = locale;
          }
        }
        if (paramd.b())
        {
          locale = paramd.d;
          if (locale == null) {
            throw new NullPointerException();
          }
          this.b |= 0x2;
          this.d = locale;
        }
        if ((paramd.b & 0x4) == 4) {
          i = j;
        }
        while (i != 0)
        {
          locale = paramd.e;
          if (locale == null)
          {
            throw new NullPointerException();
            i = 0;
          }
          else
          {
            this.b |= 0x4;
            this.e = locale;
          }
        }
        this.a = this.a.a(e.d.b(paramd));
        return this;
      }
      
      public final e.d b()
      {
        int j = 1;
        e.d locald = new e.d(this, (byte)0);
        int k = this.b;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          e.d.a(locald, this.c);
          int i = j;
          if ((k & 0x2) == 2) {
            i = j | 0x2;
          }
          e.d.b(locald, this.d);
          j = i;
          if ((k & 0x4) == 4) {
            j = i | 0x4;
          }
          e.d.c(locald, this.e);
          e.d.a(locald, j);
          return locald;
          j = 0;
        }
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/proto/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */