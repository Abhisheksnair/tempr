package com.whatsapp.proto;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.a;
import com.google.protobuf.ae;
import com.google.protobuf.c;
import com.google.protobuf.e;
import com.google.protobuf.g;

public final class f
  extends GeneratedMessageLite
  implements android.support.design.widget.f.a
{
  public static ae<f> a = new c() {};
  private static final f e;
  int b;
  public e c;
  public e d;
  private final e f;
  private byte g = -1;
  private int h = -1;
  
  static
  {
    f localf = new f();
    e = localf;
    localf.b();
  }
  
  private f()
  {
    this.f = e.b;
  }
  
  private f(GeneratedMessageLite.a parama)
  {
    super((byte)0);
    this.f = parama.a;
  }
  
  /* Error */
  private f(com.google.protobuf.f paramf)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 44	com/google/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 46	com/whatsapp/proto/f:g	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 48	com/whatsapp/proto/f:h	I
    //   14: aload_0
    //   15: invokespecial 42	com/whatsapp/proto/f:b	()V
    //   18: invokestatic 73	com/google/protobuf/e:h	()Lcom/google/protobuf/e$c;
    //   21: astore 4
    //   23: aload 4
    //   25: sipush 4096
    //   28: invokestatic 78	com/google/protobuf/g:a	(Ljava/io/OutputStream;I)Lcom/google/protobuf/g;
    //   31: astore 5
    //   33: iconst_0
    //   34: istore_2
    //   35: iload_2
    //   36: ifne +146 -> 182
    //   39: aload_1
    //   40: invokevirtual 83	com/google/protobuf/f:a	()I
    //   43: istore_3
    //   44: iload_3
    //   45: lookupswitch	default:+201->246, 0:+204->249, 10:+50->95, 18:+96->141
    //   80: aload_1
    //   81: iload_3
    //   82: aload 5
    //   84: invokevirtual 86	com/google/protobuf/f:a	(ILcom/google/protobuf/g;)Z
    //   87: ifne -52 -> 35
    //   90: iconst_1
    //   91: istore_2
    //   92: goto -57 -> 35
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 88	com/whatsapp/proto/f:b	I
    //   100: iconst_1
    //   101: ior
    //   102: putfield 88	com/whatsapp/proto/f:b	I
    //   105: aload_0
    //   106: aload_1
    //   107: invokevirtual 91	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
    //   110: putfield 93	com/whatsapp/proto/f:c	Lcom/google/protobuf/e;
    //   113: goto -78 -> 35
    //   116: astore_1
    //   117: aload_1
    //   118: aload_0
    //   119: putfield 96	com/google/protobuf/q:a	Lcom/google/protobuf/x;
    //   122: aload_1
    //   123: athrow
    //   124: astore_1
    //   125: aload 5
    //   127: invokevirtual 98	com/google/protobuf/g:a	()V
    //   130: aload_0
    //   131: aload 4
    //   133: invokevirtual 102	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   136: putfield 54	com/whatsapp/proto/f:f	Lcom/google/protobuf/e;
    //   139: aload_1
    //   140: athrow
    //   141: aload_0
    //   142: aload_0
    //   143: getfield 88	com/whatsapp/proto/f:b	I
    //   146: iconst_2
    //   147: ior
    //   148: putfield 88	com/whatsapp/proto/f:b	I
    //   151: aload_0
    //   152: aload_1
    //   153: invokevirtual 91	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
    //   156: putfield 104	com/whatsapp/proto/f:d	Lcom/google/protobuf/e;
    //   159: goto -124 -> 35
    //   162: astore_1
    //   163: new 68	com/google/protobuf/q
    //   166: dup
    //   167: aload_1
    //   168: invokevirtual 108	java/io/IOException:getMessage	()Ljava/lang/String;
    //   171: invokespecial 111	com/google/protobuf/q:<init>	(Ljava/lang/String;)V
    //   174: astore_1
    //   175: aload_1
    //   176: aload_0
    //   177: putfield 96	com/google/protobuf/q:a	Lcom/google/protobuf/x;
    //   180: aload_1
    //   181: athrow
    //   182: aload 5
    //   184: invokevirtual 98	com/google/protobuf/g:a	()V
    //   187: aload_0
    //   188: aload 4
    //   190: invokevirtual 102	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   193: putfield 54	com/whatsapp/proto/f:f	Lcom/google/protobuf/e;
    //   196: return
    //   197: astore_1
    //   198: aload_0
    //   199: aload 4
    //   201: invokevirtual 102	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   204: putfield 54	com/whatsapp/proto/f:f	Lcom/google/protobuf/e;
    //   207: return
    //   208: astore_1
    //   209: aload_0
    //   210: aload 4
    //   212: invokevirtual 102	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   215: putfield 54	com/whatsapp/proto/f:f	Lcom/google/protobuf/e;
    //   218: aload_1
    //   219: athrow
    //   220: astore 5
    //   222: aload_0
    //   223: aload 4
    //   225: invokevirtual 102	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   228: putfield 54	com/whatsapp/proto/f:f	Lcom/google/protobuf/e;
    //   231: goto -92 -> 139
    //   234: astore_1
    //   235: aload_0
    //   236: aload 4
    //   238: invokevirtual 102	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   241: putfield 54	com/whatsapp/proto/f:f	Lcom/google/protobuf/e;
    //   244: aload_1
    //   245: athrow
    //   246: goto -166 -> 80
    //   249: iconst_1
    //   250: istore_2
    //   251: goto -216 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	f
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
  
  public static f a()
  {
    return e;
  }
  
  public static f a(byte[] paramArrayOfByte)
  {
    return (f)a.a(paramArrayOfByte);
  }
  
  private void b()
  {
    this.c = e.b;
    this.d = e.b;
  }
  
  public final ae<f> getParserForType()
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
    extends GeneratedMessageLite.a<f, a>
    implements android.support.design.widget.f.a
  {
    private int b;
    private e c = e.b;
    private e d = e.b;
    
    /* Error */
    private a a(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
    {
      // Byte code:
      //   0: getstatic 34	com/whatsapp/proto/f:a	Lcom/google/protobuf/ae;
      //   3: aload_1
      //   4: aload_2
      //   5: invokeinterface 39 3 0
      //   10: checkcast 9	com/whatsapp/proto/f
      //   13: astore_1
      //   14: aload_1
      //   15: ifnull +9 -> 24
      //   18: aload_0
      //   19: aload_1
      //   20: invokevirtual 42	com/whatsapp/proto/f$a:a	(Lcom/whatsapp/proto/f;)Lcom/whatsapp/proto/f$a;
      //   23: pop
      //   24: aload_0
      //   25: areturn
      //   26: astore_2
      //   27: aload_2
      //   28: getfield 45	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   31: checkcast 9	com/whatsapp/proto/f
      //   34: astore_1
      //   35: aload_2
      //   36: athrow
      //   37: astore_2
      //   38: aload_1
      //   39: ifnull +9 -> 48
      //   42: aload_0
      //   43: aload_1
      //   44: invokevirtual 42	com/whatsapp/proto/f$a:a	(Lcom/whatsapp/proto/f;)Lcom/whatsapp/proto/f$a;
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
    
    private a c()
    {
      return new a().a(d());
    }
    
    private f d()
    {
      int i = 1;
      f localf = new f(this, (byte)0);
      int k = this.b;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        f.a(localf, this.c);
        int j = i;
        if ((k & 0x2) == 2) {
          j = i | 0x2;
        }
        f.b(localf, this.d);
        f.a(localf, j);
        return localf;
        i = 0;
      }
    }
    
    public final a a(f paramf)
    {
      int j = 1;
      if (paramf == f.a()) {
        return this;
      }
      int i;
      if ((paramf.b & 0x1) == 1) {
        i = 1;
      }
      e locale;
      while (i != 0)
      {
        locale = paramf.c;
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
      if ((paramf.b & 0x2) == 2) {
        i = j;
      }
      while (i != 0)
      {
        locale = paramf.d;
        if (locale == null)
        {
          throw new NullPointerException();
          i = 0;
        }
        else
        {
          this.b |= 0x2;
          this.d = locale;
        }
      }
      this.a = this.a.a(f.a(paramf));
      return this;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
  
  public static final class b
    extends GeneratedMessageLite
    implements android.support.design.widget.f.a
  {
    public static ae<b> a = new c() {};
    private static final b f;
    int b;
    int c;
    public long d;
    public e e;
    private final e g;
    private Object h;
    private Object i;
    private byte j = -1;
    private int k = -1;
    
    static
    {
      b localb = new b();
      f = localb;
      localb.f();
    }
    
    private b()
    {
      this.g = e.b;
    }
    
    private b(GeneratedMessageLite.a parama)
    {
      super();
      this.g = parama.a;
    }
    
    /* Error */
    private b(com.google.protobuf.f paramf)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 45	com/google/protobuf/GeneratedMessageLite:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 47	com/whatsapp/proto/f$b:j	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 49	com/whatsapp/proto/f$b:k	I
      //   14: aload_0
      //   15: invokespecial 43	com/whatsapp/proto/f$b:f	()V
      //   18: invokestatic 74	com/google/protobuf/e:h	()Lcom/google/protobuf/e$c;
      //   21: astore 4
      //   23: aload 4
      //   25: sipush 4096
      //   28: invokestatic 79	com/google/protobuf/g:a	(Ljava/io/OutputStream;I)Lcom/google/protobuf/g;
      //   31: astore 5
      //   33: iconst_0
      //   34: istore_2
      //   35: iload_2
      //   36: ifne +243 -> 279
      //   39: aload_1
      //   40: invokevirtual 84	com/google/protobuf/f:a	()I
      //   43: istore_3
      //   44: iload_3
      //   45: lookupswitch	default:+298->343, 0:+301->346, 8:+74->119, 18:+120->165, 24:+165->210, 34:+186->231, 42:+212->257
      //   104: aload_1
      //   105: iload_3
      //   106: aload 5
      //   108: invokevirtual 87	com/google/protobuf/f:a	(ILcom/google/protobuf/g;)Z
      //   111: ifne -76 -> 35
      //   114: iconst_1
      //   115: istore_2
      //   116: goto -81 -> 35
      //   119: aload_0
      //   120: aload_0
      //   121: getfield 89	com/whatsapp/proto/f$b:b	I
      //   124: iconst_1
      //   125: ior
      //   126: putfield 89	com/whatsapp/proto/f$b:b	I
      //   129: aload_0
      //   130: aload_1
      //   131: invokevirtual 91	com/google/protobuf/f:f	()I
      //   134: putfield 93	com/whatsapp/proto/f$b:c	I
      //   137: goto -102 -> 35
      //   140: astore_1
      //   141: aload_1
      //   142: aload_0
      //   143: putfield 96	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   146: aload_1
      //   147: athrow
      //   148: astore_1
      //   149: aload 5
      //   151: invokevirtual 98	com/google/protobuf/g:a	()V
      //   154: aload_0
      //   155: aload 4
      //   157: invokevirtual 103	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   160: putfield 55	com/whatsapp/proto/f$b:g	Lcom/google/protobuf/e;
      //   163: aload_1
      //   164: athrow
      //   165: aload_1
      //   166: invokevirtual 105	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   169: astore 6
      //   171: aload_0
      //   172: aload_0
      //   173: getfield 89	com/whatsapp/proto/f$b:b	I
      //   176: iconst_2
      //   177: ior
      //   178: putfield 89	com/whatsapp/proto/f$b:b	I
      //   181: aload_0
      //   182: aload 6
      //   184: putfield 107	com/whatsapp/proto/f$b:h	Ljava/lang/Object;
      //   187: goto -152 -> 35
      //   190: astore_1
      //   191: new 69	com/google/protobuf/q
      //   194: dup
      //   195: aload_1
      //   196: invokevirtual 111	java/io/IOException:getMessage	()Ljava/lang/String;
      //   199: invokespecial 114	com/google/protobuf/q:<init>	(Ljava/lang/String;)V
      //   202: astore_1
      //   203: aload_1
      //   204: aload_0
      //   205: putfield 96	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   208: aload_1
      //   209: athrow
      //   210: aload_0
      //   211: aload_0
      //   212: getfield 89	com/whatsapp/proto/f$b:b	I
      //   215: iconst_4
      //   216: ior
      //   217: putfield 89	com/whatsapp/proto/f$b:b	I
      //   220: aload_0
      //   221: aload_1
      //   222: invokevirtual 117	com/google/protobuf/f:g	()J
      //   225: putfield 119	com/whatsapp/proto/f$b:d	J
      //   228: goto -193 -> 35
      //   231: aload_1
      //   232: invokevirtual 105	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   235: astore 6
      //   237: aload_0
      //   238: aload_0
      //   239: getfield 89	com/whatsapp/proto/f$b:b	I
      //   242: bipush 8
      //   244: ior
      //   245: putfield 89	com/whatsapp/proto/f$b:b	I
      //   248: aload_0
      //   249: aload 6
      //   251: putfield 121	com/whatsapp/proto/f$b:i	Ljava/lang/Object;
      //   254: goto -219 -> 35
      //   257: aload_0
      //   258: aload_0
      //   259: getfield 89	com/whatsapp/proto/f$b:b	I
      //   262: bipush 16
      //   264: ior
      //   265: putfield 89	com/whatsapp/proto/f$b:b	I
      //   268: aload_0
      //   269: aload_1
      //   270: invokevirtual 105	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   273: putfield 123	com/whatsapp/proto/f$b:e	Lcom/google/protobuf/e;
      //   276: goto -241 -> 35
      //   279: aload 5
      //   281: invokevirtual 98	com/google/protobuf/g:a	()V
      //   284: aload_0
      //   285: aload 4
      //   287: invokevirtual 103	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   290: putfield 55	com/whatsapp/proto/f$b:g	Lcom/google/protobuf/e;
      //   293: return
      //   294: astore_1
      //   295: aload_0
      //   296: aload 4
      //   298: invokevirtual 103	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   301: putfield 55	com/whatsapp/proto/f$b:g	Lcom/google/protobuf/e;
      //   304: return
      //   305: astore_1
      //   306: aload_0
      //   307: aload 4
      //   309: invokevirtual 103	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   312: putfield 55	com/whatsapp/proto/f$b:g	Lcom/google/protobuf/e;
      //   315: aload_1
      //   316: athrow
      //   317: astore 5
      //   319: aload_0
      //   320: aload 4
      //   322: invokevirtual 103	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   325: putfield 55	com/whatsapp/proto/f$b:g	Lcom/google/protobuf/e;
      //   328: goto -165 -> 163
      //   331: astore_1
      //   332: aload_0
      //   333: aload 4
      //   335: invokevirtual 103	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   338: putfield 55	com/whatsapp/proto/f$b:g	Lcom/google/protobuf/e;
      //   341: aload_1
      //   342: athrow
      //   343: goto -239 -> 104
      //   346: iconst_1
      //   347: istore_2
      //   348: goto -313 -> 35
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	351	0	this	b
      //   0	351	1	paramf	com.google.protobuf.f
      //   34	314	2	m	int
      //   43	63	3	n	int
      //   21	313	4	localc	com.google.protobuf.e.c
      //   31	249	5	localg	g
      //   317	1	5	localIOException	java.io.IOException
      //   169	81	6	locale	e
      // Exception table:
      //   from	to	target	type
      //   39	44	140	com/google/protobuf/q
      //   104	114	140	com/google/protobuf/q
      //   119	137	140	com/google/protobuf/q
      //   165	187	140	com/google/protobuf/q
      //   210	228	140	com/google/protobuf/q
      //   231	254	140	com/google/protobuf/q
      //   257	276	140	com/google/protobuf/q
      //   39	44	148	finally
      //   104	114	148	finally
      //   119	137	148	finally
      //   141	148	148	finally
      //   165	187	148	finally
      //   191	210	148	finally
      //   210	228	148	finally
      //   231	254	148	finally
      //   257	276	148	finally
      //   39	44	190	java/io/IOException
      //   104	114	190	java/io/IOException
      //   119	137	190	java/io/IOException
      //   165	187	190	java/io/IOException
      //   210	228	190	java/io/IOException
      //   231	254	190	java/io/IOException
      //   257	276	190	java/io/IOException
      //   279	284	294	java/io/IOException
      //   279	284	305	finally
      //   149	154	317	java/io/IOException
      //   149	154	331	finally
    }
    
    public static b a()
    {
      return f;
    }
    
    public static b a(byte[] paramArrayOfByte)
    {
      return (b)a.a(paramArrayOfByte);
    }
    
    private e d()
    {
      Object localObject = this.h;
      if ((localObject instanceof String))
      {
        localObject = e.a((String)localObject);
        this.h = localObject;
        return (e)localObject;
      }
      return (e)localObject;
    }
    
    private e e()
    {
      Object localObject = this.i;
      if ((localObject instanceof String))
      {
        localObject = e.a((String)localObject);
        this.i = localObject;
        return (e)localObject;
      }
      return (e)localObject;
    }
    
    private void f()
    {
      this.c = 0;
      this.h = "";
      this.d = 0L;
      this.i = "";
      this.e = e.b;
    }
    
    public final String b()
    {
      Object localObject = this.h;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (e)localObject;
      String str = ((e)localObject).e();
      if (((e)localObject).f()) {
        this.h = str;
      }
      return str;
    }
    
    public final boolean c()
    {
      return (this.b & 0x4) == 4;
    }
    
    public final ae<b> getParserForType()
    {
      return a;
    }
    
    public final int getSerializedSize()
    {
      int m = this.k;
      if (m != -1) {
        return m;
      }
      int n = 0;
      if ((this.b & 0x1) == 1) {
        n = g.e(1, this.c) + 0;
      }
      m = n;
      if ((this.b & 0x2) == 2) {
        m = n + g.c(2, d());
      }
      n = m;
      if ((this.b & 0x4) == 4) {
        n = m + g.c(3, this.d);
      }
      m = n;
      if ((this.b & 0x8) == 8) {
        m = n + g.c(4, e());
      }
      n = m;
      if ((this.b & 0x10) == 16) {
        n = m + g.c(5, this.e);
      }
      m = n + this.g.a();
      this.k = m;
      return m;
    }
    
    public final boolean isInitialized()
    {
      int m = this.j;
      if (m == 1) {
        return true;
      }
      if (m == 0) {
        return false;
      }
      this.j = 1;
      return true;
    }
    
    public final void writeTo(g paramg)
    {
      getSerializedSize();
      if ((this.b & 0x1) == 1) {
        paramg.b(1, this.c);
      }
      if ((this.b & 0x2) == 2) {
        paramg.a(2, d());
      }
      if ((this.b & 0x4) == 4) {
        paramg.a(3, this.d);
      }
      if ((this.b & 0x8) == 8) {
        paramg.a(4, e());
      }
      if ((this.b & 0x10) == 16) {
        paramg.a(5, this.e);
      }
      paramg.c(this.g);
    }
    
    public static final class a
      extends GeneratedMessageLite.a<f.b, a>
      implements android.support.design.widget.f.a
    {
      private int b;
      private int c;
      private Object d = "";
      private long e;
      private Object f = "";
      private e g = e.b;
      
      /* Error */
      private a a(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
      {
        // Byte code:
        //   0: getstatic 45	com/whatsapp/proto/f$b:a	Lcom/google/protobuf/ae;
        //   3: aload_1
        //   4: aload_2
        //   5: invokeinterface 50 3 0
        //   10: checkcast 9	com/whatsapp/proto/f$b
        //   13: astore_1
        //   14: aload_1
        //   15: ifnull +9 -> 24
        //   18: aload_0
        //   19: aload_1
        //   20: invokevirtual 53	com/whatsapp/proto/f$b$a:a	(Lcom/whatsapp/proto/f$b;)Lcom/whatsapp/proto/f$b$a;
        //   23: pop
        //   24: aload_0
        //   25: areturn
        //   26: astore_2
        //   27: aload_2
        //   28: getfield 56	com/google/protobuf/q:a	Lcom/google/protobuf/x;
        //   31: checkcast 9	com/whatsapp/proto/f$b
        //   34: astore_1
        //   35: aload_2
        //   36: athrow
        //   37: astore_2
        //   38: aload_1
        //   39: ifnull +9 -> 48
        //   42: aload_0
        //   43: aload_1
        //   44: invokevirtual 53	com/whatsapp/proto/f$b$a:a	(Lcom/whatsapp/proto/f$b;)Lcom/whatsapp/proto/f$b$a;
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
      
      private a c()
      {
        return new a().a(d());
      }
      
      private f.b d()
      {
        int j = 1;
        f.b localb = new f.b(this, (byte)0);
        int k = this.b;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          f.b.a(localb, this.c);
          int i = j;
          if ((k & 0x2) == 2) {
            i = j | 0x2;
          }
          f.b.a(localb, this.d);
          j = i;
          if ((k & 0x4) == 4) {
            j = i | 0x4;
          }
          f.b.a(localb, this.e);
          i = j;
          if ((k & 0x8) == 8) {
            i = j | 0x8;
          }
          f.b.b(localb, this.f);
          j = i;
          if ((k & 0x10) == 16) {
            j = i | 0x10;
          }
          f.b.a(localb, this.g);
          f.b.b(localb, j);
          return localb;
          j = 0;
        }
      }
      
      public final a a(f.b paramb)
      {
        int j = 1;
        if (paramb == f.b.a()) {
          return this;
        }
        int i;
        if ((paramb.b & 0x1) == 1)
        {
          i = 1;
          if (i != 0)
          {
            i = paramb.c;
            this.b |= 0x1;
            this.c = i;
          }
          if ((paramb.b & 0x2) != 2) {
            break label189;
          }
          i = 1;
          label59:
          if (i != 0)
          {
            this.b |= 0x2;
            this.d = f.b.a(paramb);
          }
          if (paramb.c())
          {
            long l = paramb.d;
            this.b |= 0x4;
            this.e = l;
          }
          if ((paramb.b & 0x8) != 8) {
            break label194;
          }
          i = 1;
          label124:
          if (i != 0)
          {
            this.b |= 0x8;
            this.f = f.b.b(paramb);
          }
          if ((paramb.b & 0x10) != 16) {
            break label199;
          }
          i = j;
        }
        for (;;)
        {
          if (i != 0)
          {
            e locale = paramb.e;
            if (locale == null)
            {
              throw new NullPointerException();
              i = 0;
              break;
              label189:
              i = 0;
              break label59;
              label194:
              i = 0;
              break label124;
              label199:
              i = 0;
              continue;
            }
            this.b |= 0x10;
            this.g = locale;
          }
        }
        this.a = this.a.a(f.b.c(paramb));
        return this;
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/proto/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */