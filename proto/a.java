package com.whatsapp.proto;

import android.support.design.widget.f.a;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.a;
import com.google.protobuf.ae;
import com.google.protobuf.am;
import com.google.protobuf.c;
import com.google.protobuf.e;
import com.google.protobuf.g;
import com.google.protobuf.p.a;
import com.google.protobuf.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a
  extends GeneratedMessageLite
  implements f.a
{
  public static ae<a> a = new c() {};
  private static final a e;
  int b;
  int c;
  public List<b> d;
  private final e f;
  private Object g;
  private Object h;
  private Object i;
  private byte j = -1;
  private int k = -1;
  
  static
  {
    a locala = new a();
    e = locala;
    locala.k();
  }
  
  private a()
  {
    this.f = e.b;
  }
  
  private a(GeneratedMessageLite.a parama)
  {
    super((byte)0);
    this.f = parama.a;
  }
  
  /* Error */
  private a(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: invokespecial 66	com/google/protobuf/GeneratedMessageLite:<init>	()V
    //   6: aload_0
    //   7: iconst_m1
    //   8: putfield 68	com/whatsapp/proto/a:j	B
    //   11: aload_0
    //   12: iconst_m1
    //   13: putfield 70	com/whatsapp/proto/a:k	I
    //   16: aload_0
    //   17: invokespecial 64	com/whatsapp/proto/a:k	()V
    //   20: invokestatic 95	com/google/protobuf/e:h	()Lcom/google/protobuf/e$c;
    //   23: astore 9
    //   25: aload 9
    //   27: sipush 4096
    //   30: invokestatic 100	com/google/protobuf/g:a	(Ljava/io/OutputStream;I)Lcom/google/protobuf/g;
    //   33: astore 10
    //   35: iconst_0
    //   36: istore 5
    //   38: iload 5
    //   40: ifne +456 -> 496
    //   43: iload_3
    //   44: istore 6
    //   46: iload_3
    //   47: istore 7
    //   49: iload_3
    //   50: istore 8
    //   52: aload_1
    //   53: invokevirtual 105	com/google/protobuf/f:a	()I
    //   56: istore 4
    //   58: iload 4
    //   60: lookupswitch	default:+519->579, 0:+522->582, 10:+86->146, 18:+189->249, 26:+270->330, 32:+322->382, 42:+362->422
    //   120: iload_3
    //   121: istore 6
    //   123: iload_3
    //   124: istore 7
    //   126: iload_3
    //   127: istore 8
    //   129: aload_1
    //   130: iload 4
    //   132: aload 10
    //   134: invokevirtual 108	com/google/protobuf/f:a	(ILcom/google/protobuf/g;)Z
    //   137: ifne -99 -> 38
    //   140: iconst_1
    //   141: istore 5
    //   143: goto -105 -> 38
    //   146: iload_3
    //   147: istore 6
    //   149: iload_3
    //   150: istore 7
    //   152: iload_3
    //   153: istore 8
    //   155: aload_1
    //   156: invokevirtual 111	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
    //   159: astore 11
    //   161: iload_3
    //   162: istore 6
    //   164: iload_3
    //   165: istore 7
    //   167: iload_3
    //   168: istore 8
    //   170: aload_0
    //   171: aload_0
    //   172: getfield 113	com/whatsapp/proto/a:b	I
    //   175: iconst_1
    //   176: ior
    //   177: putfield 113	com/whatsapp/proto/a:b	I
    //   180: iload_3
    //   181: istore 6
    //   183: iload_3
    //   184: istore 7
    //   186: iload_3
    //   187: istore 8
    //   189: aload_0
    //   190: aload 11
    //   192: putfield 115	com/whatsapp/proto/a:g	Ljava/lang/Object;
    //   195: goto -157 -> 38
    //   198: astore_1
    //   199: iload 6
    //   201: istore_3
    //   202: aload_1
    //   203: aload_0
    //   204: putfield 118	com/google/protobuf/q:a	Lcom/google/protobuf/x;
    //   207: iload 6
    //   209: istore_3
    //   210: aload_1
    //   211: athrow
    //   212: astore_1
    //   213: iload_3
    //   214: bipush 16
    //   216: iand
    //   217: bipush 16
    //   219: if_icmpne +14 -> 233
    //   222: aload_0
    //   223: aload_0
    //   224: getfield 120	com/whatsapp/proto/a:d	Ljava/util/List;
    //   227: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   230: putfield 120	com/whatsapp/proto/a:d	Ljava/util/List;
    //   233: aload 10
    //   235: invokevirtual 128	com/google/protobuf/g:a	()V
    //   238: aload_0
    //   239: aload 9
    //   241: invokevirtual 132	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   244: putfield 76	com/whatsapp/proto/a:f	Lcom/google/protobuf/e;
    //   247: aload_1
    //   248: athrow
    //   249: iload_3
    //   250: istore 6
    //   252: iload_3
    //   253: istore 7
    //   255: iload_3
    //   256: istore 8
    //   258: aload_1
    //   259: invokevirtual 111	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
    //   262: astore 11
    //   264: iload_3
    //   265: istore 6
    //   267: iload_3
    //   268: istore 7
    //   270: iload_3
    //   271: istore 8
    //   273: aload_0
    //   274: aload_0
    //   275: getfield 113	com/whatsapp/proto/a:b	I
    //   278: iconst_2
    //   279: ior
    //   280: putfield 113	com/whatsapp/proto/a:b	I
    //   283: iload_3
    //   284: istore 6
    //   286: iload_3
    //   287: istore 7
    //   289: iload_3
    //   290: istore 8
    //   292: aload_0
    //   293: aload 11
    //   295: putfield 134	com/whatsapp/proto/a:h	Ljava/lang/Object;
    //   298: goto -260 -> 38
    //   301: astore_1
    //   302: iload 7
    //   304: istore_3
    //   305: new 90	com/google/protobuf/q
    //   308: dup
    //   309: aload_1
    //   310: invokevirtual 138	java/io/IOException:getMessage	()Ljava/lang/String;
    //   313: invokespecial 141	com/google/protobuf/q:<init>	(Ljava/lang/String;)V
    //   316: astore_1
    //   317: iload 7
    //   319: istore_3
    //   320: aload_1
    //   321: aload_0
    //   322: putfield 118	com/google/protobuf/q:a	Lcom/google/protobuf/x;
    //   325: iload 7
    //   327: istore_3
    //   328: aload_1
    //   329: athrow
    //   330: iload_3
    //   331: istore 6
    //   333: iload_3
    //   334: istore 7
    //   336: iload_3
    //   337: istore 8
    //   339: aload_1
    //   340: invokevirtual 111	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
    //   343: astore 11
    //   345: iload_3
    //   346: istore 6
    //   348: iload_3
    //   349: istore 7
    //   351: iload_3
    //   352: istore 8
    //   354: aload_0
    //   355: aload_0
    //   356: getfield 113	com/whatsapp/proto/a:b	I
    //   359: iconst_4
    //   360: ior
    //   361: putfield 113	com/whatsapp/proto/a:b	I
    //   364: iload_3
    //   365: istore 6
    //   367: iload_3
    //   368: istore 7
    //   370: iload_3
    //   371: istore 8
    //   373: aload_0
    //   374: aload 11
    //   376: putfield 143	com/whatsapp/proto/a:i	Ljava/lang/Object;
    //   379: goto -341 -> 38
    //   382: iload_3
    //   383: istore 6
    //   385: iload_3
    //   386: istore 7
    //   388: iload_3
    //   389: istore 8
    //   391: aload_0
    //   392: aload_0
    //   393: getfield 113	com/whatsapp/proto/a:b	I
    //   396: bipush 8
    //   398: ior
    //   399: putfield 113	com/whatsapp/proto/a:b	I
    //   402: iload_3
    //   403: istore 6
    //   405: iload_3
    //   406: istore 7
    //   408: iload_3
    //   409: istore 8
    //   411: aload_0
    //   412: aload_1
    //   413: invokevirtual 145	com/google/protobuf/f:f	()I
    //   416: putfield 147	com/whatsapp/proto/a:c	I
    //   419: goto -381 -> 38
    //   422: iload_3
    //   423: istore 4
    //   425: iload_3
    //   426: bipush 16
    //   428: iand
    //   429: bipush 16
    //   431: if_icmpeq +29 -> 460
    //   434: iload_3
    //   435: istore 6
    //   437: iload_3
    //   438: istore 7
    //   440: iload_3
    //   441: istore 8
    //   443: aload_0
    //   444: new 149	java/util/ArrayList
    //   447: dup
    //   448: invokespecial 150	java/util/ArrayList:<init>	()V
    //   451: putfield 120	com/whatsapp/proto/a:d	Ljava/util/List;
    //   454: iload_3
    //   455: bipush 16
    //   457: ior
    //   458: istore 4
    //   460: iload 4
    //   462: istore 6
    //   464: iload 4
    //   466: istore 7
    //   468: iload 4
    //   470: istore 8
    //   472: aload_0
    //   473: getfield 120	com/whatsapp/proto/a:d	Ljava/util/List;
    //   476: aload_1
    //   477: getstatic 151	com/whatsapp/proto/a$b:a	Lcom/google/protobuf/ae;
    //   480: aload_2
    //   481: invokevirtual 154	com/google/protobuf/f:a	(Lcom/google/protobuf/ae;Lcom/google/protobuf/m;)Lcom/google/protobuf/x;
    //   484: invokeinterface 160 2 0
    //   489: pop
    //   490: iload 4
    //   492: istore_3
    //   493: goto -455 -> 38
    //   496: iload_3
    //   497: bipush 16
    //   499: iand
    //   500: bipush 16
    //   502: if_icmpne +14 -> 516
    //   505: aload_0
    //   506: aload_0
    //   507: getfield 120	com/whatsapp/proto/a:d	Ljava/util/List;
    //   510: invokestatic 126	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   513: putfield 120	com/whatsapp/proto/a:d	Ljava/util/List;
    //   516: aload 10
    //   518: invokevirtual 128	com/google/protobuf/g:a	()V
    //   521: aload_0
    //   522: aload 9
    //   524: invokevirtual 132	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   527: putfield 76	com/whatsapp/proto/a:f	Lcom/google/protobuf/e;
    //   530: return
    //   531: astore_1
    //   532: aload_0
    //   533: aload 9
    //   535: invokevirtual 132	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   538: putfield 76	com/whatsapp/proto/a:f	Lcom/google/protobuf/e;
    //   541: return
    //   542: astore_1
    //   543: aload_0
    //   544: aload 9
    //   546: invokevirtual 132	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   549: putfield 76	com/whatsapp/proto/a:f	Lcom/google/protobuf/e;
    //   552: aload_1
    //   553: athrow
    //   554: astore_2
    //   555: aload_0
    //   556: aload 9
    //   558: invokevirtual 132	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   561: putfield 76	com/whatsapp/proto/a:f	Lcom/google/protobuf/e;
    //   564: goto -317 -> 247
    //   567: astore_1
    //   568: aload_0
    //   569: aload 9
    //   571: invokevirtual 132	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   574: putfield 76	com/whatsapp/proto/a:f	Lcom/google/protobuf/e;
    //   577: aload_1
    //   578: athrow
    //   579: goto -459 -> 120
    //   582: iconst_1
    //   583: istore 5
    //   585: goto -547 -> 38
    //   588: astore_1
    //   589: iload 8
    //   591: istore_3
    //   592: goto -379 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	595	0	this	a
    //   0	595	1	paramf	com.google.protobuf.f
    //   0	595	2	paramm	com.google.protobuf.m
    //   1	591	3	m	int
    //   56	435	4	n	int
    //   36	548	5	i1	int
    //   44	419	6	i2	int
    //   47	420	7	i3	int
    //   50	540	8	i4	int
    //   23	547	9	localc	com.google.protobuf.e.c
    //   33	484	10	localg	g
    //   159	216	11	locale	e
    // Exception table:
    //   from	to	target	type
    //   52	58	198	com/google/protobuf/q
    //   129	140	198	com/google/protobuf/q
    //   155	161	198	com/google/protobuf/q
    //   170	180	198	com/google/protobuf/q
    //   189	195	198	com/google/protobuf/q
    //   258	264	198	com/google/protobuf/q
    //   273	283	198	com/google/protobuf/q
    //   292	298	198	com/google/protobuf/q
    //   339	345	198	com/google/protobuf/q
    //   354	364	198	com/google/protobuf/q
    //   373	379	198	com/google/protobuf/q
    //   391	402	198	com/google/protobuf/q
    //   411	419	198	com/google/protobuf/q
    //   443	454	198	com/google/protobuf/q
    //   472	490	198	com/google/protobuf/q
    //   202	207	212	finally
    //   210	212	212	finally
    //   305	317	212	finally
    //   320	325	212	finally
    //   328	330	212	finally
    //   52	58	301	java/io/IOException
    //   129	140	301	java/io/IOException
    //   155	161	301	java/io/IOException
    //   170	180	301	java/io/IOException
    //   189	195	301	java/io/IOException
    //   258	264	301	java/io/IOException
    //   273	283	301	java/io/IOException
    //   292	298	301	java/io/IOException
    //   339	345	301	java/io/IOException
    //   354	364	301	java/io/IOException
    //   373	379	301	java/io/IOException
    //   391	402	301	java/io/IOException
    //   411	419	301	java/io/IOException
    //   443	454	301	java/io/IOException
    //   472	490	301	java/io/IOException
    //   516	521	531	java/io/IOException
    //   516	521	542	finally
    //   233	238	554	java/io/IOException
    //   233	238	567	finally
    //   52	58	588	finally
    //   129	140	588	finally
    //   155	161	588	finally
    //   170	180	588	finally
    //   189	195	588	finally
    //   258	264	588	finally
    //   273	283	588	finally
    //   292	298	588	finally
    //   339	345	588	finally
    //   354	364	588	finally
    //   373	379	588	finally
    //   391	402	588	finally
    //   411	419	588	finally
    //   443	454	588	finally
    //   472	490	588	finally
  }
  
  public static a a()
  {
    return e;
  }
  
  public static a a(byte[] paramArrayOfByte)
  {
    return (a)a.a(paramArrayOfByte);
  }
  
  public static a g()
  {
    return a.c();
  }
  
  private e h()
  {
    Object localObject = this.g;
    if ((localObject instanceof String))
    {
      localObject = e.a((String)localObject);
      this.g = localObject;
      return (e)localObject;
    }
    return (e)localObject;
  }
  
  private e i()
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
  
  private e j()
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
  
  private void k()
  {
    this.g = "";
    this.h = "";
    this.i = "";
    this.c = 0;
    this.d = Collections.emptyList();
  }
  
  public final boolean b()
  {
    return (this.b & 0x1) == 1;
  }
  
  public final String c()
  {
    Object localObject = this.g;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (e)localObject;
    String str = ((e)localObject).e();
    if (((e)localObject).f()) {
      this.g = str;
    }
    return str;
  }
  
  public final String d()
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
  
  public final String e()
  {
    Object localObject = this.i;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (e)localObject;
    String str = ((e)localObject).e();
    if (((e)localObject).f()) {
      this.i = str;
    }
    return str;
  }
  
  public final int f()
  {
    return this.d.size();
  }
  
  public final ae<a> getParserForType()
  {
    return a;
  }
  
  public final int getSerializedSize()
  {
    int i1 = 0;
    int m = this.k;
    if (m != -1) {
      return m;
    }
    if ((this.b & 0x1) == 1) {}
    for (int n = g.c(1, h()) + 0;; n = 0)
    {
      m = n;
      if ((this.b & 0x2) == 2) {
        m = n + g.c(2, i());
      }
      n = m;
      if ((this.b & 0x4) == 4) {
        n = m + g.c(3, j());
      }
      m = n;
      if ((this.b & 0x8) == 8) {
        m = n + g.e(4, this.c);
      }
      n = i1;
      while (n < this.d.size())
      {
        i1 = g.d(5, (x)this.d.get(n));
        n += 1;
        m = i1 + m;
      }
      m = this.f.a() + m;
      this.k = m;
      return m;
    }
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
      paramg.a(1, h());
    }
    if ((this.b & 0x2) == 2) {
      paramg.a(2, i());
    }
    if ((this.b & 0x4) == 4) {
      paramg.a(3, j());
    }
    if ((this.b & 0x8) == 8) {
      paramg.b(4, this.c);
    }
    int m = 0;
    while (m < this.d.size())
    {
      paramg.b(5, (x)this.d.get(m));
      m += 1;
    }
    paramg.c(this.f);
  }
  
  public static final class a
    extends GeneratedMessageLite.a<a, a>
    implements f.a
  {
    private int b;
    private Object c = "";
    private Object d = "";
    private Object e = "";
    private int f;
    private List<a.b> g = Collections.emptyList();
    
    /* Error */
    private a a(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
    {
      // Byte code:
      //   0: getstatic 47	com/whatsapp/proto/a:a	Lcom/google/protobuf/ae;
      //   3: aload_1
      //   4: aload_2
      //   5: invokeinterface 52 3 0
      //   10: checkcast 9	com/whatsapp/proto/a
      //   13: astore_1
      //   14: aload_1
      //   15: ifnull +9 -> 24
      //   18: aload_0
      //   19: aload_1
      //   20: invokevirtual 55	com/whatsapp/proto/a$a:a	(Lcom/whatsapp/proto/a;)Lcom/whatsapp/proto/a$a;
      //   23: pop
      //   24: aload_0
      //   25: areturn
      //   26: astore_2
      //   27: aload_2
      //   28: getfield 58	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   31: checkcast 9	com/whatsapp/proto/a
      //   34: astore_1
      //   35: aload_2
      //   36: athrow
      //   37: astore_2
      //   38: aload_1
      //   39: ifnull +9 -> 48
      //   42: aload_0
      //   43: aload_1
      //   44: invokevirtual 55	com/whatsapp/proto/a$a:a	(Lcom/whatsapp/proto/a;)Lcom/whatsapp/proto/a$a;
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
    
    private a e()
    {
      int j = 1;
      a locala = new a(this, (byte)0);
      int k = this.b;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        a.a(locala, this.c);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        a.b(locala, this.d);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        a.c(locala, this.e);
        i = j;
        if ((k & 0x8) == 8) {
          i = j | 0x8;
        }
        a.a(locala, this.f);
        if ((this.b & 0x10) == 16)
        {
          this.g = Collections.unmodifiableList(this.g);
          this.b &= 0xFFFFFFEF;
        }
        a.a(locala, this.g);
        a.b(locala, i);
        return locala;
        j = 0;
      }
    }
    
    public final a a(a parama)
    {
      int j = 1;
      if (parama == a.a()) {
        return this;
      }
      if (parama.b())
      {
        this.b |= 0x1;
        this.c = a.a(parama);
      }
      int i;
      if ((parama.b & 0x2) == 2)
      {
        i = 1;
        if (i != 0)
        {
          this.b |= 0x2;
          this.d = a.b(parama);
        }
        if ((parama.b & 0x4) != 4) {
          break label208;
        }
        i = 1;
        label82:
        if (i != 0)
        {
          this.b |= 0x4;
          this.e = a.c(parama);
        }
        if ((parama.b & 0x8) != 8) {
          break label213;
        }
        i = j;
        label118:
        if (i != 0)
        {
          i = parama.c;
          this.b |= 0x8;
          this.f = i;
        }
        if (!a.d(parama).isEmpty())
        {
          if (!this.g.isEmpty()) {
            break label218;
          }
          this.g = a.d(parama);
          this.b &= 0xFFFFFFEF;
        }
      }
      for (;;)
      {
        this.a = this.a.a(a.e(parama));
        return this;
        i = 0;
        break;
        label208:
        i = 0;
        break label82;
        label213:
        i = 0;
        break label118;
        label218:
        if ((this.b & 0x10) != 16)
        {
          this.g = new ArrayList(this.g);
          this.b |= 0x10;
        }
        this.g.addAll(a.d(parama));
      }
    }
    
    public final a a(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.b |= 0x1;
      this.c = paramString;
      return this;
    }
    
    public final a b()
    {
      a locala = e();
      if (!locala.isInitialized()) {
        throw new am();
      }
      return locala;
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
    private static final b g;
    int b;
    public b c;
    public Object d;
    public int e;
    public List<c> f;
    private final e h;
    private byte i = -1;
    private int j = -1;
    
    static
    {
      b localb = new b();
      g = localb;
      localb.e();
    }
    
    private b()
    {
      this.h = e.b;
    }
    
    private b(GeneratedMessageLite.a parama)
    {
      super();
      this.h = parama.a;
    }
    
    /* Error */
    private b(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 62	com/google/protobuf/GeneratedMessageLite:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 64	com/whatsapp/proto/a$b:i	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 66	com/whatsapp/proto/a$b:j	I
      //   14: aload_0
      //   15: invokespecial 60	com/whatsapp/proto/a$b:e	()V
      //   18: invokestatic 91	com/google/protobuf/e:h	()Lcom/google/protobuf/e$c;
      //   21: astore 8
      //   23: aload 8
      //   25: sipush 4096
      //   28: invokestatic 96	com/google/protobuf/g:a	(Ljava/io/OutputStream;I)Lcom/google/protobuf/g;
      //   31: astore 9
      //   33: iconst_0
      //   34: istore 5
      //   36: iconst_0
      //   37: istore_3
      //   38: iload 5
      //   40: ifne +364 -> 404
      //   43: iload_3
      //   44: istore 4
      //   46: aload_1
      //   47: invokevirtual 101	com/google/protobuf/f:a	()I
      //   50: istore 6
      //   52: iload 6
      //   54: lookupswitch	default:+460->514, 0:+463->517, 10:+70->124, 18:+211->265, 24:+274->328, 34:+301->355
      //   104: iload_3
      //   105: istore 4
      //   107: aload_1
      //   108: iload 6
      //   110: aload 9
      //   112: invokevirtual 104	com/google/protobuf/f:a	(ILcom/google/protobuf/g;)Z
      //   115: ifne +396 -> 511
      //   118: iconst_1
      //   119: istore 5
      //   121: goto -83 -> 38
      //   124: iload_3
      //   125: istore 4
      //   127: aload_0
      //   128: getfield 106	com/whatsapp/proto/a$b:b	I
      //   131: iconst_1
      //   132: iand
      //   133: iconst_1
      //   134: if_icmpne +371 -> 505
      //   137: iload_3
      //   138: istore 4
      //   140: aload_0
      //   141: getfield 108	com/whatsapp/proto/a$b:c	Lcom/whatsapp/proto/a$b$b;
      //   144: invokestatic 111	com/whatsapp/proto/a$b$b:a	(Lcom/whatsapp/proto/a$b$b;)Lcom/whatsapp/proto/a$b$b$a;
      //   147: astore 7
      //   149: iload_3
      //   150: istore 4
      //   152: aload_0
      //   153: aload_1
      //   154: getstatic 112	com/whatsapp/proto/a$b$b:a	Lcom/google/protobuf/ae;
      //   157: aload_2
      //   158: invokevirtual 115	com/google/protobuf/f:a	(Lcom/google/protobuf/ae;Lcom/google/protobuf/m;)Lcom/google/protobuf/x;
      //   161: checkcast 16	com/whatsapp/proto/a$b$b
      //   164: putfield 108	com/whatsapp/proto/a$b:c	Lcom/whatsapp/proto/a$b$b;
      //   167: aload 7
      //   169: ifnull +28 -> 197
      //   172: iload_3
      //   173: istore 4
      //   175: aload 7
      //   177: aload_0
      //   178: getfield 108	com/whatsapp/proto/a$b:c	Lcom/whatsapp/proto/a$b$b;
      //   181: invokevirtual 116	com/whatsapp/proto/a$b$b$a:a	(Lcom/whatsapp/proto/a$b$b;)Lcom/whatsapp/proto/a$b$b$a;
      //   184: pop
      //   185: iload_3
      //   186: istore 4
      //   188: aload_0
      //   189: aload 7
      //   191: invokevirtual 119	com/whatsapp/proto/a$b$b$a:b	()Lcom/whatsapp/proto/a$b$b;
      //   194: putfield 108	com/whatsapp/proto/a$b:c	Lcom/whatsapp/proto/a$b$b;
      //   197: iload_3
      //   198: istore 4
      //   200: aload_0
      //   201: aload_0
      //   202: getfield 106	com/whatsapp/proto/a$b:b	I
      //   205: iconst_1
      //   206: ior
      //   207: putfield 106	com/whatsapp/proto/a$b:b	I
      //   210: goto -172 -> 38
      //   213: astore_1
      //   214: iload_3
      //   215: istore 4
      //   217: aload_1
      //   218: aload_0
      //   219: putfield 122	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   222: iload_3
      //   223: istore 4
      //   225: aload_1
      //   226: athrow
      //   227: astore_1
      //   228: iload 4
      //   230: bipush 8
      //   232: iand
      //   233: bipush 8
      //   235: if_icmpne +14 -> 249
      //   238: aload_0
      //   239: aload_0
      //   240: getfield 124	com/whatsapp/proto/a$b:f	Ljava/util/List;
      //   243: invokestatic 130	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   246: putfield 124	com/whatsapp/proto/a$b:f	Ljava/util/List;
      //   249: aload 9
      //   251: invokevirtual 132	com/google/protobuf/g:a	()V
      //   254: aload_0
      //   255: aload 8
      //   257: invokevirtual 137	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   260: putfield 72	com/whatsapp/proto/a$b:h	Lcom/google/protobuf/e;
      //   263: aload_1
      //   264: athrow
      //   265: iload_3
      //   266: istore 4
      //   268: aload_1
      //   269: invokevirtual 139	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   272: astore 7
      //   274: iload_3
      //   275: istore 4
      //   277: aload_0
      //   278: aload_0
      //   279: getfield 106	com/whatsapp/proto/a$b:b	I
      //   282: iconst_2
      //   283: ior
      //   284: putfield 106	com/whatsapp/proto/a$b:b	I
      //   287: iload_3
      //   288: istore 4
      //   290: aload_0
      //   291: aload 7
      //   293: putfield 141	com/whatsapp/proto/a$b:d	Ljava/lang/Object;
      //   296: goto -258 -> 38
      //   299: astore_1
      //   300: iload_3
      //   301: istore 4
      //   303: new 86	com/google/protobuf/q
      //   306: dup
      //   307: aload_1
      //   308: invokevirtual 145	java/io/IOException:getMessage	()Ljava/lang/String;
      //   311: invokespecial 148	com/google/protobuf/q:<init>	(Ljava/lang/String;)V
      //   314: astore_1
      //   315: iload_3
      //   316: istore 4
      //   318: aload_1
      //   319: aload_0
      //   320: putfield 122	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   323: iload_3
      //   324: istore 4
      //   326: aload_1
      //   327: athrow
      //   328: iload_3
      //   329: istore 4
      //   331: aload_0
      //   332: aload_0
      //   333: getfield 106	com/whatsapp/proto/a$b:b	I
      //   336: iconst_4
      //   337: ior
      //   338: putfield 106	com/whatsapp/proto/a$b:b	I
      //   341: iload_3
      //   342: istore 4
      //   344: aload_0
      //   345: aload_1
      //   346: invokevirtual 150	com/google/protobuf/f:f	()I
      //   349: putfield 152	com/whatsapp/proto/a$b:e	I
      //   352: goto -314 -> 38
      //   355: iload_3
      //   356: bipush 8
      //   358: iand
      //   359: bipush 8
      //   361: if_icmpeq +141 -> 502
      //   364: iload_3
      //   365: istore 4
      //   367: aload_0
      //   368: new 154	java/util/ArrayList
      //   371: dup
      //   372: invokespecial 155	java/util/ArrayList:<init>	()V
      //   375: putfield 124	com/whatsapp/proto/a$b:f	Ljava/util/List;
      //   378: iload_3
      //   379: bipush 8
      //   381: ior
      //   382: istore_3
      //   383: aload_0
      //   384: getfield 124	com/whatsapp/proto/a$b:f	Ljava/util/List;
      //   387: aload_1
      //   388: getstatic 156	com/whatsapp/proto/a$b$c:a	Lcom/google/protobuf/ae;
      //   391: aload_2
      //   392: invokevirtual 115	com/google/protobuf/f:a	(Lcom/google/protobuf/ae;Lcom/google/protobuf/m;)Lcom/google/protobuf/x;
      //   395: invokeinterface 162 2 0
      //   400: pop
      //   401: goto -363 -> 38
      //   404: iload_3
      //   405: bipush 8
      //   407: iand
      //   408: bipush 8
      //   410: if_icmpne +14 -> 424
      //   413: aload_0
      //   414: aload_0
      //   415: getfield 124	com/whatsapp/proto/a$b:f	Ljava/util/List;
      //   418: invokestatic 130	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   421: putfield 124	com/whatsapp/proto/a$b:f	Ljava/util/List;
      //   424: aload 9
      //   426: invokevirtual 132	com/google/protobuf/g:a	()V
      //   429: aload_0
      //   430: aload 8
      //   432: invokevirtual 137	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   435: putfield 72	com/whatsapp/proto/a$b:h	Lcom/google/protobuf/e;
      //   438: return
      //   439: astore_1
      //   440: aload_0
      //   441: aload 8
      //   443: invokevirtual 137	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   446: putfield 72	com/whatsapp/proto/a$b:h	Lcom/google/protobuf/e;
      //   449: return
      //   450: astore_1
      //   451: aload_0
      //   452: aload 8
      //   454: invokevirtual 137	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   457: putfield 72	com/whatsapp/proto/a$b:h	Lcom/google/protobuf/e;
      //   460: aload_1
      //   461: athrow
      //   462: astore_2
      //   463: aload_0
      //   464: aload 8
      //   466: invokevirtual 137	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   469: putfield 72	com/whatsapp/proto/a$b:h	Lcom/google/protobuf/e;
      //   472: goto -209 -> 263
      //   475: astore_1
      //   476: aload_0
      //   477: aload 8
      //   479: invokevirtual 137	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   482: putfield 72	com/whatsapp/proto/a$b:h	Lcom/google/protobuf/e;
      //   485: aload_1
      //   486: athrow
      //   487: astore_1
      //   488: iload_3
      //   489: istore 4
      //   491: goto -263 -> 228
      //   494: astore_1
      //   495: goto -195 -> 300
      //   498: astore_1
      //   499: goto -285 -> 214
      //   502: goto -119 -> 383
      //   505: aconst_null
      //   506: astore 7
      //   508: goto -359 -> 149
      //   511: goto -110 -> 401
      //   514: goto -410 -> 104
      //   517: iconst_1
      //   518: istore 5
      //   520: goto -482 -> 38
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	523	0	this	b
      //   0	523	1	paramf	com.google.protobuf.f
      //   0	523	2	paramm	com.google.protobuf.m
      //   37	452	3	k	int
      //   44	446	4	m	int
      //   34	485	5	n	int
      //   50	59	6	i1	int
      //   147	360	7	localObject	Object
      //   21	457	8	localc	com.google.protobuf.e.c
      //   31	394	9	localg	g
      // Exception table:
      //   from	to	target	type
      //   46	52	213	com/google/protobuf/q
      //   107	118	213	com/google/protobuf/q
      //   127	137	213	com/google/protobuf/q
      //   140	149	213	com/google/protobuf/q
      //   152	167	213	com/google/protobuf/q
      //   175	185	213	com/google/protobuf/q
      //   188	197	213	com/google/protobuf/q
      //   200	210	213	com/google/protobuf/q
      //   268	274	213	com/google/protobuf/q
      //   277	287	213	com/google/protobuf/q
      //   290	296	213	com/google/protobuf/q
      //   331	341	213	com/google/protobuf/q
      //   344	352	213	com/google/protobuf/q
      //   367	378	213	com/google/protobuf/q
      //   46	52	227	finally
      //   107	118	227	finally
      //   127	137	227	finally
      //   140	149	227	finally
      //   152	167	227	finally
      //   175	185	227	finally
      //   188	197	227	finally
      //   200	210	227	finally
      //   217	222	227	finally
      //   225	227	227	finally
      //   268	274	227	finally
      //   277	287	227	finally
      //   290	296	227	finally
      //   303	315	227	finally
      //   318	323	227	finally
      //   326	328	227	finally
      //   331	341	227	finally
      //   344	352	227	finally
      //   367	378	227	finally
      //   46	52	299	java/io/IOException
      //   107	118	299	java/io/IOException
      //   127	137	299	java/io/IOException
      //   140	149	299	java/io/IOException
      //   152	167	299	java/io/IOException
      //   175	185	299	java/io/IOException
      //   188	197	299	java/io/IOException
      //   200	210	299	java/io/IOException
      //   268	274	299	java/io/IOException
      //   277	287	299	java/io/IOException
      //   290	296	299	java/io/IOException
      //   331	341	299	java/io/IOException
      //   344	352	299	java/io/IOException
      //   367	378	299	java/io/IOException
      //   424	429	439	java/io/IOException
      //   424	429	450	finally
      //   249	254	462	java/io/IOException
      //   249	254	475	finally
      //   383	401	487	finally
      //   383	401	494	java/io/IOException
      //   383	401	498	com/google/protobuf/q
    }
    
    public static b a()
    {
      return g;
    }
    
    private e d()
    {
      Object localObject = this.d;
      if ((localObject instanceof String))
      {
        localObject = e.a((String)localObject);
        this.d = localObject;
        return (e)localObject;
      }
      return (e)localObject;
    }
    
    private void e()
    {
      this.c = b.a();
      this.d = "";
      this.e = 0;
      this.f = Collections.emptyList();
    }
    
    public final boolean b()
    {
      return (this.b & 0x1) == 1;
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
      int n = 0;
      int k = this.j;
      if (k != -1) {
        return k;
      }
      if ((this.b & 0x1) == 1) {}
      for (int m = g.d(1, this.c) + 0;; m = 0)
      {
        k = m;
        if ((this.b & 0x2) == 2) {
          k = m + g.c(2, d());
        }
        m = k;
        if ((this.b & 0x4) == 4) {
          m = k + g.e(3, this.e);
        }
        k = m;
        m = n;
        while (m < this.f.size())
        {
          n = g.d(4, (x)this.f.get(m));
          m += 1;
          k = n + k;
        }
        k = this.h.a() + k;
        this.j = k;
        return k;
      }
    }
    
    public final boolean isInitialized()
    {
      int k = this.i;
      if (k == 1) {
        return true;
      }
      if (k == 0) {
        return false;
      }
      this.i = 1;
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
        paramg.b(3, this.e);
      }
      int k = 0;
      while (k < this.f.size())
      {
        paramg.b(4, (x)this.f.get(k));
        k += 1;
      }
      paramg.c(this.h);
    }
    
    public static final class a
      extends GeneratedMessageLite.a<a.b, a>
      implements f.a
    {
      private int b;
      private a.b.b c = a.b.b.a();
      private Object d = "";
      private int e;
      private List<a.b.c> f = Collections.emptyList();
      
      /* Error */
      private a a(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
      {
        // Byte code:
        //   0: getstatic 52	com/whatsapp/proto/a$b:a	Lcom/google/protobuf/ae;
        //   3: aload_1
        //   4: aload_2
        //   5: invokeinterface 57 3 0
        //   10: checkcast 9	com/whatsapp/proto/a$b
        //   13: astore_1
        //   14: aload_1
        //   15: ifnull +9 -> 24
        //   18: aload_0
        //   19: aload_1
        //   20: invokevirtual 60	com/whatsapp/proto/a$b$a:a	(Lcom/whatsapp/proto/a$b;)Lcom/whatsapp/proto/a$b$a;
        //   23: pop
        //   24: aload_0
        //   25: areturn
        //   26: astore_2
        //   27: aload_2
        //   28: getfield 63	com/google/protobuf/q:a	Lcom/google/protobuf/x;
        //   31: checkcast 9	com/whatsapp/proto/a$b
        //   34: astore_1
        //   35: aload_2
        //   36: athrow
        //   37: astore_2
        //   38: aload_1
        //   39: ifnull +9 -> 48
        //   42: aload_0
        //   43: aload_1
        //   44: invokevirtual 60	com/whatsapp/proto/a$b$a:a	(Lcom/whatsapp/proto/a$b;)Lcom/whatsapp/proto/a$b$a;
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
      
      private a.b d()
      {
        int j = 1;
        a.b localb = new a.b(this, (byte)0);
        int k = this.b;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          a.b.a(localb, this.c);
          int i = j;
          if ((k & 0x2) == 2) {
            i = j | 0x2;
          }
          a.b.a(localb, this.d);
          j = i;
          if ((k & 0x4) == 4) {
            j = i | 0x4;
          }
          a.b.a(localb, this.e);
          if ((this.b & 0x8) == 8)
          {
            this.f = Collections.unmodifiableList(this.f);
            this.b &= 0xFFFFFFF7;
          }
          a.b.a(localb, this.f);
          a.b.b(localb, j);
          return localb;
          j = 0;
        }
      }
      
      public final a a(a.b paramb)
      {
        int i = 1;
        if (paramb == a.b.a()) {
          return this;
        }
        a.b.b localb;
        if (paramb.b())
        {
          localb = paramb.c;
          if (((this.b & 0x1) == 1) && (this.c != a.b.b.a()))
          {
            this.c = a.b.b.a(this.c).a(localb).b();
            this.b |= 0x1;
          }
        }
        else
        {
          if ((paramb.b & 0x2) != 2) {
            break label198;
          }
          label81:
          if (i != 0)
          {
            this.b |= 0x2;
            this.d = a.b.a(paramb);
          }
          if (paramb.c())
          {
            i = paramb.e;
            this.b |= 0x4;
            this.e = i;
          }
          if (!a.b.b(paramb).isEmpty())
          {
            if (!this.f.isEmpty()) {
              break label203;
            }
            this.f = a.b.b(paramb);
            this.b &= 0xFFFFFFF7;
          }
        }
        for (;;)
        {
          this.a = this.a.a(a.b.c(paramb));
          return this;
          this.c = localb;
          break;
          label198:
          i = 0;
          break label81;
          label203:
          if ((this.b & 0x8) != 8)
          {
            this.f = new ArrayList(this.f);
            this.b |= 0x8;
          }
          this.f.addAll(a.b.b(paramb));
        }
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
      public Object c;
      int d;
      private final e f;
      private Object g;
      private byte h = -1;
      private int i = -1;
      
      static
      {
        b localb = new b();
        e = localb;
        localb.e();
      }
      
      private b()
      {
        this.f = e.b;
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
        //   1: invokespecial 44	com/google/protobuf/GeneratedMessageLite:<init>	()V
        //   4: aload_0
        //   5: iconst_m1
        //   6: putfield 46	com/whatsapp/proto/a$b$b:h	B
        //   9: aload_0
        //   10: iconst_m1
        //   11: putfield 48	com/whatsapp/proto/a$b$b:i	I
        //   14: aload_0
        //   15: invokespecial 42	com/whatsapp/proto/a$b$b:e	()V
        //   18: invokestatic 73	com/google/protobuf/e:h	()Lcom/google/protobuf/e$c;
        //   21: astore 4
        //   23: aload 4
        //   25: sipush 4096
        //   28: invokestatic 78	com/google/protobuf/g:a	(Ljava/io/OutputStream;I)Lcom/google/protobuf/g;
        //   31: astore 5
        //   33: iconst_0
        //   34: istore_2
        //   35: iload_2
        //   36: ifne +183 -> 219
        //   39: aload_1
        //   40: invokevirtual 83	com/google/protobuf/f:a	()I
        //   43: istore_3
        //   44: iload_3
        //   45: lookupswitch	default:+238->283, 0:+241->286, 10:+58->103, 18:+108->153, 24:+153->198
        //   88: aload_1
        //   89: iload_3
        //   90: aload 5
        //   92: invokevirtual 86	com/google/protobuf/f:a	(ILcom/google/protobuf/g;)Z
        //   95: ifne -60 -> 35
        //   98: iconst_1
        //   99: istore_2
        //   100: goto -65 -> 35
        //   103: aload_1
        //   104: invokevirtual 89	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
        //   107: astore 6
        //   109: aload_0
        //   110: aload_0
        //   111: getfield 91	com/whatsapp/proto/a$b$b:b	I
        //   114: iconst_1
        //   115: ior
        //   116: putfield 91	com/whatsapp/proto/a$b$b:b	I
        //   119: aload_0
        //   120: aload 6
        //   122: putfield 93	com/whatsapp/proto/a$b$b:g	Ljava/lang/Object;
        //   125: goto -90 -> 35
        //   128: astore_1
        //   129: aload_1
        //   130: aload_0
        //   131: putfield 96	com/google/protobuf/q:a	Lcom/google/protobuf/x;
        //   134: aload_1
        //   135: athrow
        //   136: astore_1
        //   137: aload 5
        //   139: invokevirtual 98	com/google/protobuf/g:a	()V
        //   142: aload_0
        //   143: aload 4
        //   145: invokevirtual 102	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   148: putfield 54	com/whatsapp/proto/a$b$b:f	Lcom/google/protobuf/e;
        //   151: aload_1
        //   152: athrow
        //   153: aload_1
        //   154: invokevirtual 89	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
        //   157: astore 6
        //   159: aload_0
        //   160: aload_0
        //   161: getfield 91	com/whatsapp/proto/a$b$b:b	I
        //   164: iconst_2
        //   165: ior
        //   166: putfield 91	com/whatsapp/proto/a$b$b:b	I
        //   169: aload_0
        //   170: aload 6
        //   172: putfield 104	com/whatsapp/proto/a$b$b:c	Ljava/lang/Object;
        //   175: goto -140 -> 35
        //   178: astore_1
        //   179: new 68	com/google/protobuf/q
        //   182: dup
        //   183: aload_1
        //   184: invokevirtual 108	java/io/IOException:getMessage	()Ljava/lang/String;
        //   187: invokespecial 111	com/google/protobuf/q:<init>	(Ljava/lang/String;)V
        //   190: astore_1
        //   191: aload_1
        //   192: aload_0
        //   193: putfield 96	com/google/protobuf/q:a	Lcom/google/protobuf/x;
        //   196: aload_1
        //   197: athrow
        //   198: aload_0
        //   199: aload_0
        //   200: getfield 91	com/whatsapp/proto/a$b$b:b	I
        //   203: iconst_4
        //   204: ior
        //   205: putfield 91	com/whatsapp/proto/a$b$b:b	I
        //   208: aload_0
        //   209: aload_1
        //   210: invokevirtual 113	com/google/protobuf/f:f	()I
        //   213: putfield 115	com/whatsapp/proto/a$b$b:d	I
        //   216: goto -181 -> 35
        //   219: aload 5
        //   221: invokevirtual 98	com/google/protobuf/g:a	()V
        //   224: aload_0
        //   225: aload 4
        //   227: invokevirtual 102	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   230: putfield 54	com/whatsapp/proto/a$b$b:f	Lcom/google/protobuf/e;
        //   233: return
        //   234: astore_1
        //   235: aload_0
        //   236: aload 4
        //   238: invokevirtual 102	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   241: putfield 54	com/whatsapp/proto/a$b$b:f	Lcom/google/protobuf/e;
        //   244: return
        //   245: astore_1
        //   246: aload_0
        //   247: aload 4
        //   249: invokevirtual 102	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   252: putfield 54	com/whatsapp/proto/a$b$b:f	Lcom/google/protobuf/e;
        //   255: aload_1
        //   256: athrow
        //   257: astore 5
        //   259: aload_0
        //   260: aload 4
        //   262: invokevirtual 102	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   265: putfield 54	com/whatsapp/proto/a$b$b:f	Lcom/google/protobuf/e;
        //   268: goto -117 -> 151
        //   271: astore_1
        //   272: aload_0
        //   273: aload 4
        //   275: invokevirtual 102	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   278: putfield 54	com/whatsapp/proto/a$b$b:f	Lcom/google/protobuf/e;
        //   281: aload_1
        //   282: athrow
        //   283: goto -195 -> 88
        //   286: iconst_1
        //   287: istore_2
        //   288: goto -253 -> 35
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	291	0	this	b
        //   0	291	1	paramf	com.google.protobuf.f
        //   34	254	2	j	int
        //   43	47	3	k	int
        //   21	253	4	localc	com.google.protobuf.e.c
        //   31	189	5	localg	g
        //   257	1	5	localIOException	java.io.IOException
        //   107	64	6	locale	e
        // Exception table:
        //   from	to	target	type
        //   39	44	128	com/google/protobuf/q
        //   88	98	128	com/google/protobuf/q
        //   103	125	128	com/google/protobuf/q
        //   153	175	128	com/google/protobuf/q
        //   198	216	128	com/google/protobuf/q
        //   39	44	136	finally
        //   88	98	136	finally
        //   103	125	136	finally
        //   129	136	136	finally
        //   153	175	136	finally
        //   179	198	136	finally
        //   198	216	136	finally
        //   39	44	178	java/io/IOException
        //   88	98	178	java/io/IOException
        //   103	125	178	java/io/IOException
        //   153	175	178	java/io/IOException
        //   198	216	178	java/io/IOException
        //   219	224	234	java/io/IOException
        //   219	224	245	finally
        //   137	142	257	java/io/IOException
        //   137	142	271	finally
      }
      
      public static a a(b paramb)
      {
        return a.c().a(paramb);
      }
      
      public static b a()
      {
        return e;
      }
      
      @Deprecated
      private e c()
      {
        Object localObject = this.g;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.g = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      private e d()
      {
        Object localObject = this.c;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.c = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      private void e()
      {
        this.g = "";
        this.c = "";
        this.d = 0;
      }
      
      public final boolean b()
      {
        return (this.b & 0x2) == 2;
      }
      
      public final ae<b> getParserForType()
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
          k = g.c(1, c()) + 0;
        }
        j = k;
        if ((this.b & 0x2) == 2) {
          j = k + g.c(2, d());
        }
        k = j;
        if ((this.b & 0x4) == 4) {
          k = j + g.e(3, this.d);
        }
        j = k + this.f.a();
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
          paramg.a(1, c());
        }
        if ((this.b & 0x2) == 2) {
          paramg.a(2, d());
        }
        if ((this.b & 0x4) == 4) {
          paramg.b(3, this.d);
        }
        paramg.c(this.f);
      }
      
      public static final class a
        extends GeneratedMessageLite.a<a.b.b, a>
        implements f.a
      {
        private int b;
        private Object c = "";
        private Object d = "";
        private int e;
        
        /* Error */
        private a a(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
        {
          // Byte code:
          //   0: getstatic 37	com/whatsapp/proto/a$b$b:a	Lcom/google/protobuf/ae;
          //   3: aload_1
          //   4: aload_2
          //   5: invokeinterface 42 3 0
          //   10: checkcast 14	com/whatsapp/proto/a$b$b
          //   13: astore_1
          //   14: aload_1
          //   15: ifnull +9 -> 24
          //   18: aload_0
          //   19: aload_1
          //   20: invokevirtual 45	com/whatsapp/proto/a$b$b$a:a	(Lcom/whatsapp/proto/a$b$b;)Lcom/whatsapp/proto/a$b$b$a;
          //   23: pop
          //   24: aload_0
          //   25: areturn
          //   26: astore_2
          //   27: aload_2
          //   28: getfield 48	com/google/protobuf/q:a	Lcom/google/protobuf/x;
          //   31: checkcast 14	com/whatsapp/proto/a$b$b
          //   34: astore_1
          //   35: aload_2
          //   36: athrow
          //   37: astore_2
          //   38: aload_1
          //   39: ifnull +9 -> 48
          //   42: aload_0
          //   43: aload_1
          //   44: invokevirtual 45	com/whatsapp/proto/a$b$b$a:a	(Lcom/whatsapp/proto/a$b$b;)Lcom/whatsapp/proto/a$b$b$a;
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
        
        public final a a(a.b.b paramb)
        {
          int j = 1;
          if (paramb == a.b.b.a()) {
            return this;
          }
          if ((paramb.b & 0x1) == 1)
          {
            i = 1;
            if (i != 0)
            {
              this.b |= 0x1;
              this.c = a.b.b.b(paramb);
            }
            if (paramb.b())
            {
              this.b |= 0x2;
              this.d = a.b.b.c(paramb);
            }
            if ((paramb.b & 0x4) != 4) {
              break label128;
            }
          }
          label128:
          for (int i = j;; i = 0)
          {
            if (i != 0)
            {
              i = paramb.d;
              this.b |= 0x4;
              this.e = i;
            }
            this.a = this.a.a(a.b.b.d(paramb));
            return this;
            i = 0;
            break;
          }
        }
        
        public final a.b.b b()
        {
          int j = 1;
          a.b.b localb = new a.b.b(this, (byte)0);
          int k = this.b;
          if ((k & 0x1) == 1) {}
          for (;;)
          {
            a.b.b.a(localb, this.c);
            int i = j;
            if ((k & 0x2) == 2) {
              i = j | 0x2;
            }
            a.b.b.b(localb, this.d);
            j = i;
            if ((k & 0x4) == 4) {
              j = i | 0x4;
            }
            a.b.b.a(localb, this.e);
            a.b.b.b(localb, j);
            return localb;
            j = 0;
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
      private static final c e;
      int b;
      public b c;
      public Object d;
      private final e f;
      private byte g = -1;
      private int h = -1;
      
      static
      {
        c localc = new c();
        e = localc;
        localc.c();
      }
      
      private c()
      {
        this.f = e.b;
      }
      
      private c(GeneratedMessageLite.a parama)
      {
        super();
        this.f = parama.a;
      }
      
      /* Error */
      private c(com.google.protobuf.f paramf)
      {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 48	com/google/protobuf/GeneratedMessageLite:<init>	()V
        //   4: aload_0
        //   5: iconst_m1
        //   6: putfield 50	com/whatsapp/proto/a$b$c:g	B
        //   9: aload_0
        //   10: iconst_m1
        //   11: putfield 52	com/whatsapp/proto/a$b$c:h	I
        //   14: aload_0
        //   15: invokespecial 46	com/whatsapp/proto/a$b$c:c	()V
        //   18: invokestatic 77	com/google/protobuf/e:h	()Lcom/google/protobuf/e$c;
        //   21: astore 5
        //   23: aload 5
        //   25: sipush 4096
        //   28: invokestatic 82	com/google/protobuf/g:a	(Ljava/io/OutputStream;I)Lcom/google/protobuf/g;
        //   31: astore 6
        //   33: iconst_0
        //   34: istore_2
        //   35: iload_2
        //   36: ifne +182 -> 218
        //   39: aload_1
        //   40: invokevirtual 87	com/google/protobuf/f:a	()I
        //   43: istore_3
        //   44: iload_3
        //   45: lookupswitch	default:+237->282, 0:+240->285, 8:+50->95, 18:+148->193
        //   80: aload_1
        //   81: iload_3
        //   82: aload 6
        //   84: invokevirtual 90	com/google/protobuf/f:a	(ILcom/google/protobuf/g;)Z
        //   87: ifne -52 -> 35
        //   90: iconst_1
        //   91: istore_2
        //   92: goto -57 -> 35
        //   95: aload_1
        //   96: invokevirtual 92	com/google/protobuf/f:f	()I
        //   99: istore 4
        //   101: iload 4
        //   103: invokestatic 95	com/whatsapp/proto/a$b$c$b:a	(I)Lcom/whatsapp/proto/a$b$c$b;
        //   106: astore 7
        //   108: aload 7
        //   110: ifnonnull +44 -> 154
        //   113: aload 6
        //   115: iload_3
        //   116: invokevirtual 98	com/google/protobuf/g:e	(I)V
        //   119: aload 6
        //   121: iload 4
        //   123: invokevirtual 98	com/google/protobuf/g:e	(I)V
        //   126: goto -91 -> 35
        //   129: astore_1
        //   130: aload_1
        //   131: aload_0
        //   132: putfield 101	com/google/protobuf/q:a	Lcom/google/protobuf/x;
        //   135: aload_1
        //   136: athrow
        //   137: astore_1
        //   138: aload 6
        //   140: invokevirtual 103	com/google/protobuf/g:a	()V
        //   143: aload_0
        //   144: aload 5
        //   146: invokevirtual 108	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   149: putfield 58	com/whatsapp/proto/a$b$c:f	Lcom/google/protobuf/e;
        //   152: aload_1
        //   153: athrow
        //   154: aload_0
        //   155: aload_0
        //   156: getfield 110	com/whatsapp/proto/a$b$c:b	I
        //   159: iconst_1
        //   160: ior
        //   161: putfield 110	com/whatsapp/proto/a$b$c:b	I
        //   164: aload_0
        //   165: aload 7
        //   167: putfield 112	com/whatsapp/proto/a$b$c:c	Lcom/whatsapp/proto/a$b$c$b;
        //   170: goto -135 -> 35
        //   173: astore_1
        //   174: new 72	com/google/protobuf/q
        //   177: dup
        //   178: aload_1
        //   179: invokevirtual 116	java/io/IOException:getMessage	()Ljava/lang/String;
        //   182: invokespecial 119	com/google/protobuf/q:<init>	(Ljava/lang/String;)V
        //   185: astore_1
        //   186: aload_1
        //   187: aload_0
        //   188: putfield 101	com/google/protobuf/q:a	Lcom/google/protobuf/x;
        //   191: aload_1
        //   192: athrow
        //   193: aload_1
        //   194: invokevirtual 121	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
        //   197: astore 7
        //   199: aload_0
        //   200: aload_0
        //   201: getfield 110	com/whatsapp/proto/a$b$c:b	I
        //   204: iconst_2
        //   205: ior
        //   206: putfield 110	com/whatsapp/proto/a$b$c:b	I
        //   209: aload_0
        //   210: aload 7
        //   212: putfield 123	com/whatsapp/proto/a$b$c:d	Ljava/lang/Object;
        //   215: goto -180 -> 35
        //   218: aload 6
        //   220: invokevirtual 103	com/google/protobuf/g:a	()V
        //   223: aload_0
        //   224: aload 5
        //   226: invokevirtual 108	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   229: putfield 58	com/whatsapp/proto/a$b$c:f	Lcom/google/protobuf/e;
        //   232: return
        //   233: astore_1
        //   234: aload_0
        //   235: aload 5
        //   237: invokevirtual 108	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   240: putfield 58	com/whatsapp/proto/a$b$c:f	Lcom/google/protobuf/e;
        //   243: return
        //   244: astore_1
        //   245: aload_0
        //   246: aload 5
        //   248: invokevirtual 108	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   251: putfield 58	com/whatsapp/proto/a$b$c:f	Lcom/google/protobuf/e;
        //   254: aload_1
        //   255: athrow
        //   256: astore 6
        //   258: aload_0
        //   259: aload 5
        //   261: invokevirtual 108	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   264: putfield 58	com/whatsapp/proto/a$b$c:f	Lcom/google/protobuf/e;
        //   267: goto -115 -> 152
        //   270: astore_1
        //   271: aload_0
        //   272: aload 5
        //   274: invokevirtual 108	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   277: putfield 58	com/whatsapp/proto/a$b$c:f	Lcom/google/protobuf/e;
        //   280: aload_1
        //   281: athrow
        //   282: goto -202 -> 80
        //   285: iconst_1
        //   286: istore_2
        //   287: goto -252 -> 35
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	290	0	this	c
        //   0	290	1	paramf	com.google.protobuf.f
        //   34	253	2	i	int
        //   43	73	3	j	int
        //   99	23	4	k	int
        //   21	252	5	localc	com.google.protobuf.e.c
        //   31	188	6	localg	g
        //   256	1	6	localIOException	java.io.IOException
        //   106	105	7	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   39	44	129	com/google/protobuf/q
        //   80	90	129	com/google/protobuf/q
        //   95	108	129	com/google/protobuf/q
        //   113	126	129	com/google/protobuf/q
        //   154	170	129	com/google/protobuf/q
        //   193	215	129	com/google/protobuf/q
        //   39	44	137	finally
        //   80	90	137	finally
        //   95	108	137	finally
        //   113	126	137	finally
        //   130	137	137	finally
        //   154	170	137	finally
        //   174	193	137	finally
        //   193	215	137	finally
        //   39	44	173	java/io/IOException
        //   80	90	173	java/io/IOException
        //   95	108	173	java/io/IOException
        //   113	126	173	java/io/IOException
        //   154	170	173	java/io/IOException
        //   193	215	173	java/io/IOException
        //   218	223	233	java/io/IOException
        //   218	223	244	finally
        //   138	143	256	java/io/IOException
        //   138	143	270	finally
      }
      
      public static c a()
      {
        return e;
      }
      
      private e b()
      {
        Object localObject = this.d;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.d = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      private void c()
      {
        this.c = b.a;
        this.d = "";
      }
      
      public final ae<c> getParserForType()
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
          i = g.f(1, this.c.getNumber()) + 0;
        }
        int j = i;
        if ((this.b & 0x2) == 2) {
          j = i + g.c(2, b());
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
          paramg.c(1, this.c.getNumber());
        }
        if ((this.b & 0x2) == 2) {
          paramg.a(2, b());
        }
        paramg.c(this.f);
      }
      
      public static final class a
        extends GeneratedMessageLite.a<a.b.c, a>
        implements f.a
      {
        private int b;
        private a.b.c.b c = a.b.c.b.a;
        private Object d = "";
        
        /* Error */
        private a a(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
        {
          // Byte code:
          //   0: getstatic 41	com/whatsapp/proto/a$b$c:a	Lcom/google/protobuf/ae;
          //   3: aload_1
          //   4: aload_2
          //   5: invokeinterface 46 3 0
          //   10: checkcast 14	com/whatsapp/proto/a$b$c
          //   13: astore_1
          //   14: aload_1
          //   15: ifnull +9 -> 24
          //   18: aload_0
          //   19: aload_1
          //   20: invokevirtual 49	com/whatsapp/proto/a$b$c$a:a	(Lcom/whatsapp/proto/a$b$c;)Lcom/whatsapp/proto/a$b$c$a;
          //   23: pop
          //   24: aload_0
          //   25: areturn
          //   26: astore_2
          //   27: aload_2
          //   28: getfield 52	com/google/protobuf/q:a	Lcom/google/protobuf/x;
          //   31: checkcast 14	com/whatsapp/proto/a$b$c
          //   34: astore_1
          //   35: aload_2
          //   36: athrow
          //   37: astore_2
          //   38: aload_1
          //   39: ifnull +9 -> 48
          //   42: aload_0
          //   43: aload_1
          //   44: invokevirtual 49	com/whatsapp/proto/a$b$c$a:a	(Lcom/whatsapp/proto/a$b$c;)Lcom/whatsapp/proto/a$b$c$a;
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
        
        private a.b.c d()
        {
          int i = 1;
          a.b.c localc = new a.b.c(this, (byte)0);
          int k = this.b;
          if ((k & 0x1) == 1) {}
          for (;;)
          {
            a.b.c.a(localc, this.c);
            int j = i;
            if ((k & 0x2) == 2) {
              j = i | 0x2;
            }
            a.b.c.a(localc, this.d);
            a.b.c.a(localc, j);
            return localc;
            i = 0;
          }
        }
        
        public final a a(a.b.c paramc)
        {
          int j = 1;
          if (paramc == a.b.c.a()) {
            return this;
          }
          if ((paramc.b & 0x1) == 1) {
            i = 1;
          }
          while (i != 0)
          {
            a.b.c.b localb = paramc.c;
            if (localb == null)
            {
              throw new NullPointerException();
              i = 0;
            }
            else
            {
              this.b |= 0x1;
              this.c = localb;
            }
          }
          if ((paramc.b & 0x2) == 2) {}
          for (int i = j;; i = 0)
          {
            if (i != 0)
            {
              this.b |= 0x2;
              this.d = a.b.c.a(paramc);
            }
            this.a = this.a.a(a.b.c.b(paramc));
            return this;
          }
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
      }
      
      public static enum b
        implements p.a
      {
        private static f.a<b> g = new f.a() {};
        private final int h;
        
        private b(int paramInt1, int paramInt2)
        {
          this.h = paramInt1;
        }
        
        public static b a(int paramInt)
        {
          switch (paramInt)
          {
          default: 
            return null;
          case 0: 
            return a;
          case 1: 
            return b;
          case 2: 
            return c;
          case 3: 
            return d;
          case 4: 
            return e;
          }
          return f;
        }
        
        public final int getNumber()
        {
          return this.h;
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/proto/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */