package com.whatsapp.proto;

import android.support.design.widget.f.a;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.a;
import com.google.protobuf.ae;
import com.google.protobuf.am;
import com.google.protobuf.e;
import com.google.protobuf.g;
import com.google.protobuf.x;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c
  extends GeneratedMessageLite
  implements f.a
{
  public static ae<c> a = new com.google.protobuf.c() {};
  private static final c d;
  public e b;
  public e c;
  private final e e;
  private int f;
  private byte g = -1;
  private int h = -1;
  
  static
  {
    c localc = new c();
    d = localc;
    localc.d();
  }
  
  private c()
  {
    this.e = e.b;
  }
  
  private c(GeneratedMessageLite.a parama)
  {
    super((byte)0);
    this.e = parama.a;
  }
  
  /* Error */
  private c(com.google.protobuf.f paramf)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 44	com/google/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 46	com/whatsapp/proto/c:g	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 48	com/whatsapp/proto/c:h	I
    //   14: aload_0
    //   15: invokespecial 42	com/whatsapp/proto/c:d	()V
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
    //   97: getfield 88	com/whatsapp/proto/c:f	I
    //   100: iconst_1
    //   101: ior
    //   102: putfield 88	com/whatsapp/proto/c:f	I
    //   105: aload_0
    //   106: aload_1
    //   107: invokevirtual 91	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
    //   110: putfield 92	com/whatsapp/proto/c:b	Lcom/google/protobuf/e;
    //   113: goto -78 -> 35
    //   116: astore_1
    //   117: aload_1
    //   118: aload_0
    //   119: putfield 95	com/google/protobuf/q:a	Lcom/google/protobuf/x;
    //   122: aload_1
    //   123: athrow
    //   124: astore_1
    //   125: aload 5
    //   127: invokevirtual 97	com/google/protobuf/g:a	()V
    //   130: aload_0
    //   131: aload 4
    //   133: invokevirtual 101	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   136: putfield 54	com/whatsapp/proto/c:e	Lcom/google/protobuf/e;
    //   139: aload_1
    //   140: athrow
    //   141: aload_0
    //   142: aload_0
    //   143: getfield 88	com/whatsapp/proto/c:f	I
    //   146: iconst_2
    //   147: ior
    //   148: putfield 88	com/whatsapp/proto/c:f	I
    //   151: aload_0
    //   152: aload_1
    //   153: invokevirtual 91	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
    //   156: putfield 103	com/whatsapp/proto/c:c	Lcom/google/protobuf/e;
    //   159: goto -124 -> 35
    //   162: astore_1
    //   163: new 68	com/google/protobuf/q
    //   166: dup
    //   167: aload_1
    //   168: invokevirtual 107	java/io/IOException:getMessage	()Ljava/lang/String;
    //   171: invokespecial 110	com/google/protobuf/q:<init>	(Ljava/lang/String;)V
    //   174: astore_1
    //   175: aload_1
    //   176: aload_0
    //   177: putfield 95	com/google/protobuf/q:a	Lcom/google/protobuf/x;
    //   180: aload_1
    //   181: athrow
    //   182: aload 5
    //   184: invokevirtual 97	com/google/protobuf/g:a	()V
    //   187: aload_0
    //   188: aload 4
    //   190: invokevirtual 101	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   193: putfield 54	com/whatsapp/proto/c:e	Lcom/google/protobuf/e;
    //   196: return
    //   197: astore_1
    //   198: aload_0
    //   199: aload 4
    //   201: invokevirtual 101	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   204: putfield 54	com/whatsapp/proto/c:e	Lcom/google/protobuf/e;
    //   207: return
    //   208: astore_1
    //   209: aload_0
    //   210: aload 4
    //   212: invokevirtual 101	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   215: putfield 54	com/whatsapp/proto/c:e	Lcom/google/protobuf/e;
    //   218: aload_1
    //   219: athrow
    //   220: astore 5
    //   222: aload_0
    //   223: aload 4
    //   225: invokevirtual 101	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   228: putfield 54	com/whatsapp/proto/c:e	Lcom/google/protobuf/e;
    //   231: goto -92 -> 139
    //   234: astore_1
    //   235: aload_0
    //   236: aload 4
    //   238: invokevirtual 101	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   241: putfield 54	com/whatsapp/proto/c:e	Lcom/google/protobuf/e;
    //   244: aload_1
    //   245: athrow
    //   246: goto -166 -> 80
    //   249: iconst_1
    //   250: istore_2
    //   251: goto -216 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	c
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
  
  public static a a(c paramc)
  {
    return a.c().a(paramc);
  }
  
  public static c a()
  {
    return d;
  }
  
  public static c a(InputStream paramInputStream)
  {
    return (c)a.b(paramInputStream);
  }
  
  public static c a(byte[] paramArrayOfByte)
  {
    return (c)a.a(paramArrayOfByte);
  }
  
  private void d()
  {
    this.b = e.b;
    this.c = e.b;
  }
  
  public final boolean b()
  {
    return (this.f & 0x1) == 1;
  }
  
  public final boolean c()
  {
    return (this.f & 0x2) == 2;
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
    if ((this.f & 0x1) == 1) {
      i = g.c(1, this.b) + 0;
    }
    int j = i;
    if ((this.f & 0x2) == 2) {
      j = i + g.c(2, this.c);
    }
    i = j + this.e.a();
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
    if ((this.f & 0x1) == 1) {
      paramg.a(1, this.b);
    }
    if ((this.f & 0x2) == 2) {
      paramg.a(2, this.c);
    }
    paramg.c(this.e);
  }
  
  public static final class a
    extends GeneratedMessageLite.a<c, a>
    implements f.a
  {
    private int b;
    private e c = e.b;
    private e d = e.b;
    
    /* Error */
    private a a(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
    {
      // Byte code:
      //   0: getstatic 34	com/whatsapp/proto/c:a	Lcom/google/protobuf/ae;
      //   3: aload_1
      //   4: aload_2
      //   5: invokeinterface 39 3 0
      //   10: checkcast 9	com/whatsapp/proto/c
      //   13: astore_1
      //   14: aload_1
      //   15: ifnull +9 -> 24
      //   18: aload_0
      //   19: aload_1
      //   20: invokevirtual 42	com/whatsapp/proto/c$a:a	(Lcom/whatsapp/proto/c;)Lcom/whatsapp/proto/c$a;
      //   23: pop
      //   24: aload_0
      //   25: areturn
      //   26: astore_2
      //   27: aload_2
      //   28: getfield 45	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   31: checkcast 9	com/whatsapp/proto/c
      //   34: astore_1
      //   35: aload_2
      //   36: athrow
      //   37: astore_2
      //   38: aload_1
      //   39: ifnull +9 -> 48
      //   42: aload_0
      //   43: aload_1
      //   44: invokevirtual 42	com/whatsapp/proto/c$a:a	(Lcom/whatsapp/proto/c;)Lcom/whatsapp/proto/c$a;
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
    
    private c e()
    {
      int i = 1;
      c localc = new c(this, (byte)0);
      int k = this.b;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        c.a(localc, this.c);
        int j = i;
        if ((k & 0x2) == 2) {
          j = i | 0x2;
        }
        c.b(localc, this.d);
        c.a(localc, j);
        return localc;
        i = 0;
      }
    }
    
    public final a a(e parame)
    {
      if (parame == null) {
        throw new NullPointerException();
      }
      this.b |= 0x2;
      this.d = parame;
      return this;
    }
    
    public final a a(c paramc)
    {
      if (paramc == c.a()) {
        return this;
      }
      if (paramc.b())
      {
        e locale = paramc.b;
        if (locale == null) {
          throw new NullPointerException();
        }
        this.b |= 0x1;
        this.c = locale;
      }
      if (paramc.c()) {
        a(paramc.c);
      }
      this.a = this.a.a(c.b(paramc));
      return this;
    }
    
    public final c b()
    {
      c localc = e();
      if (!localc.isInitialized()) {
        throw new am();
      }
      return localc;
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
    public static ae<b> a = new com.google.protobuf.c() {};
    private static final b j;
    int b;
    public long c;
    public Object d;
    public long e;
    public Object f;
    public Object g;
    public Object h;
    public List<b> i;
    private final e k;
    private Object l;
    private byte m = -1;
    private int n = -1;
    
    static
    {
      b localb = new b();
      j = localb;
      localb.h();
    }
    
    private b()
    {
      this.k = e.b;
    }
    
    private b(GeneratedMessageLite.a parama)
    {
      super();
      this.k = parama.a;
    }
    
    /* Error */
    private b(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: invokespecial 50	com/google/protobuf/GeneratedMessageLite:<init>	()V
      //   6: aload_0
      //   7: iconst_m1
      //   8: putfield 52	com/whatsapp/proto/c$b:m	B
      //   11: aload_0
      //   12: iconst_m1
      //   13: putfield 54	com/whatsapp/proto/c$b:n	I
      //   16: aload_0
      //   17: invokespecial 48	com/whatsapp/proto/c$b:h	()V
      //   20: invokestatic 79	com/google/protobuf/e:h	()Lcom/google/protobuf/e$c;
      //   23: astore 9
      //   25: aload 9
      //   27: sipush 4096
      //   30: invokestatic 84	com/google/protobuf/g:a	(Ljava/io/OutputStream;I)Lcom/google/protobuf/g;
      //   33: astore 10
      //   35: iconst_0
      //   36: istore 5
      //   38: iload 5
      //   40: ifne +631 -> 671
      //   43: iload_3
      //   44: istore 6
      //   46: iload_3
      //   47: istore 7
      //   49: iload_3
      //   50: istore 8
      //   52: aload_1
      //   53: invokevirtual 89	com/google/protobuf/f:a	()I
      //   56: istore 4
      //   58: iload 4
      //   60: lookupswitch	default:+696->756, 0:+699->759, 8:+110->170, 18:+202->262, 24:+283->343, 34:+322->382, 42:+375->435, 50:+428->488, 58:+481->541, 66:+534->594
      //   144: iload_3
      //   145: istore 6
      //   147: iload_3
      //   148: istore 7
      //   150: iload_3
      //   151: istore 8
      //   153: aload_1
      //   154: iload 4
      //   156: aload 10
      //   158: invokevirtual 92	com/google/protobuf/f:a	(ILcom/google/protobuf/g;)Z
      //   161: ifne -123 -> 38
      //   164: iconst_1
      //   165: istore 5
      //   167: goto -129 -> 38
      //   170: iload_3
      //   171: istore 6
      //   173: iload_3
      //   174: istore 7
      //   176: iload_3
      //   177: istore 8
      //   179: aload_0
      //   180: aload_0
      //   181: getfield 94	com/whatsapp/proto/c$b:b	I
      //   184: iconst_1
      //   185: ior
      //   186: putfield 94	com/whatsapp/proto/c$b:b	I
      //   189: iload_3
      //   190: istore 6
      //   192: iload_3
      //   193: istore 7
      //   195: iload_3
      //   196: istore 8
      //   198: aload_0
      //   199: aload_1
      //   200: invokevirtual 97	com/google/protobuf/f:g	()J
      //   203: putfield 99	com/whatsapp/proto/c$b:c	J
      //   206: goto -168 -> 38
      //   209: astore_1
      //   210: iload 6
      //   212: istore_3
      //   213: aload_1
      //   214: aload_0
      //   215: putfield 102	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   218: iload 6
      //   220: istore_3
      //   221: aload_1
      //   222: athrow
      //   223: astore_1
      //   224: iload_3
      //   225: sipush 128
      //   228: iand
      //   229: sipush 128
      //   232: if_icmpne +14 -> 246
      //   235: aload_0
      //   236: aload_0
      //   237: getfield 104	com/whatsapp/proto/c$b:i	Ljava/util/List;
      //   240: invokestatic 110	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   243: putfield 104	com/whatsapp/proto/c$b:i	Ljava/util/List;
      //   246: aload 10
      //   248: invokevirtual 112	com/google/protobuf/g:a	()V
      //   251: aload_0
      //   252: aload 9
      //   254: invokevirtual 117	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   257: putfield 60	com/whatsapp/proto/c$b:k	Lcom/google/protobuf/e;
      //   260: aload_1
      //   261: athrow
      //   262: iload_3
      //   263: istore 6
      //   265: iload_3
      //   266: istore 7
      //   268: iload_3
      //   269: istore 8
      //   271: aload_1
      //   272: invokevirtual 119	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   275: astore 11
      //   277: iload_3
      //   278: istore 6
      //   280: iload_3
      //   281: istore 7
      //   283: iload_3
      //   284: istore 8
      //   286: aload_0
      //   287: aload_0
      //   288: getfield 94	com/whatsapp/proto/c$b:b	I
      //   291: iconst_2
      //   292: ior
      //   293: putfield 94	com/whatsapp/proto/c$b:b	I
      //   296: iload_3
      //   297: istore 6
      //   299: iload_3
      //   300: istore 7
      //   302: iload_3
      //   303: istore 8
      //   305: aload_0
      //   306: aload 11
      //   308: putfield 121	com/whatsapp/proto/c$b:d	Ljava/lang/Object;
      //   311: goto -273 -> 38
      //   314: astore_1
      //   315: iload 7
      //   317: istore_3
      //   318: new 74	com/google/protobuf/q
      //   321: dup
      //   322: aload_1
      //   323: invokevirtual 125	java/io/IOException:getMessage	()Ljava/lang/String;
      //   326: invokespecial 128	com/google/protobuf/q:<init>	(Ljava/lang/String;)V
      //   329: astore_1
      //   330: iload 7
      //   332: istore_3
      //   333: aload_1
      //   334: aload_0
      //   335: putfield 102	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   338: iload 7
      //   340: istore_3
      //   341: aload_1
      //   342: athrow
      //   343: iload_3
      //   344: istore 6
      //   346: iload_3
      //   347: istore 7
      //   349: iload_3
      //   350: istore 8
      //   352: aload_0
      //   353: aload_0
      //   354: getfield 94	com/whatsapp/proto/c$b:b	I
      //   357: iconst_4
      //   358: ior
      //   359: putfield 94	com/whatsapp/proto/c$b:b	I
      //   362: iload_3
      //   363: istore 6
      //   365: iload_3
      //   366: istore 7
      //   368: iload_3
      //   369: istore 8
      //   371: aload_0
      //   372: aload_1
      //   373: invokevirtual 97	com/google/protobuf/f:g	()J
      //   376: putfield 130	com/whatsapp/proto/c$b:e	J
      //   379: goto -341 -> 38
      //   382: iload_3
      //   383: istore 6
      //   385: iload_3
      //   386: istore 7
      //   388: iload_3
      //   389: istore 8
      //   391: aload_1
      //   392: invokevirtual 119	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   395: astore 11
      //   397: iload_3
      //   398: istore 6
      //   400: iload_3
      //   401: istore 7
      //   403: iload_3
      //   404: istore 8
      //   406: aload_0
      //   407: aload_0
      //   408: getfield 94	com/whatsapp/proto/c$b:b	I
      //   411: bipush 8
      //   413: ior
      //   414: putfield 94	com/whatsapp/proto/c$b:b	I
      //   417: iload_3
      //   418: istore 6
      //   420: iload_3
      //   421: istore 7
      //   423: iload_3
      //   424: istore 8
      //   426: aload_0
      //   427: aload 11
      //   429: putfield 132	com/whatsapp/proto/c$b:l	Ljava/lang/Object;
      //   432: goto -394 -> 38
      //   435: iload_3
      //   436: istore 6
      //   438: iload_3
      //   439: istore 7
      //   441: iload_3
      //   442: istore 8
      //   444: aload_1
      //   445: invokevirtual 119	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   448: astore 11
      //   450: iload_3
      //   451: istore 6
      //   453: iload_3
      //   454: istore 7
      //   456: iload_3
      //   457: istore 8
      //   459: aload_0
      //   460: aload_0
      //   461: getfield 94	com/whatsapp/proto/c$b:b	I
      //   464: bipush 16
      //   466: ior
      //   467: putfield 94	com/whatsapp/proto/c$b:b	I
      //   470: iload_3
      //   471: istore 6
      //   473: iload_3
      //   474: istore 7
      //   476: iload_3
      //   477: istore 8
      //   479: aload_0
      //   480: aload 11
      //   482: putfield 134	com/whatsapp/proto/c$b:f	Ljava/lang/Object;
      //   485: goto -447 -> 38
      //   488: iload_3
      //   489: istore 6
      //   491: iload_3
      //   492: istore 7
      //   494: iload_3
      //   495: istore 8
      //   497: aload_1
      //   498: invokevirtual 119	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   501: astore 11
      //   503: iload_3
      //   504: istore 6
      //   506: iload_3
      //   507: istore 7
      //   509: iload_3
      //   510: istore 8
      //   512: aload_0
      //   513: aload_0
      //   514: getfield 94	com/whatsapp/proto/c$b:b	I
      //   517: bipush 32
      //   519: ior
      //   520: putfield 94	com/whatsapp/proto/c$b:b	I
      //   523: iload_3
      //   524: istore 6
      //   526: iload_3
      //   527: istore 7
      //   529: iload_3
      //   530: istore 8
      //   532: aload_0
      //   533: aload 11
      //   535: putfield 136	com/whatsapp/proto/c$b:g	Ljava/lang/Object;
      //   538: goto -500 -> 38
      //   541: iload_3
      //   542: istore 6
      //   544: iload_3
      //   545: istore 7
      //   547: iload_3
      //   548: istore 8
      //   550: aload_1
      //   551: invokevirtual 119	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   554: astore 11
      //   556: iload_3
      //   557: istore 6
      //   559: iload_3
      //   560: istore 7
      //   562: iload_3
      //   563: istore 8
      //   565: aload_0
      //   566: aload_0
      //   567: getfield 94	com/whatsapp/proto/c$b:b	I
      //   570: bipush 64
      //   572: ior
      //   573: putfield 94	com/whatsapp/proto/c$b:b	I
      //   576: iload_3
      //   577: istore 6
      //   579: iload_3
      //   580: istore 7
      //   582: iload_3
      //   583: istore 8
      //   585: aload_0
      //   586: aload 11
      //   588: putfield 138	com/whatsapp/proto/c$b:h	Ljava/lang/Object;
      //   591: goto -553 -> 38
      //   594: iload_3
      //   595: istore 4
      //   597: iload_3
      //   598: sipush 128
      //   601: iand
      //   602: sipush 128
      //   605: if_icmpeq +30 -> 635
      //   608: iload_3
      //   609: istore 6
      //   611: iload_3
      //   612: istore 7
      //   614: iload_3
      //   615: istore 8
      //   617: aload_0
      //   618: new 140	java/util/ArrayList
      //   621: dup
      //   622: invokespecial 141	java/util/ArrayList:<init>	()V
      //   625: putfield 104	com/whatsapp/proto/c$b:i	Ljava/util/List;
      //   628: iload_3
      //   629: sipush 128
      //   632: ior
      //   633: istore 4
      //   635: iload 4
      //   637: istore 6
      //   639: iload 4
      //   641: istore 7
      //   643: iload 4
      //   645: istore 8
      //   647: aload_0
      //   648: getfield 104	com/whatsapp/proto/c$b:i	Ljava/util/List;
      //   651: aload_1
      //   652: getstatic 144	com/whatsapp/proto/b:a	Lcom/google/protobuf/ae;
      //   655: aload_2
      //   656: invokevirtual 147	com/google/protobuf/f:a	(Lcom/google/protobuf/ae;Lcom/google/protobuf/m;)Lcom/google/protobuf/x;
      //   659: invokeinterface 153 2 0
      //   664: pop
      //   665: iload 4
      //   667: istore_3
      //   668: goto -630 -> 38
      //   671: iload_3
      //   672: sipush 128
      //   675: iand
      //   676: sipush 128
      //   679: if_icmpne +14 -> 693
      //   682: aload_0
      //   683: aload_0
      //   684: getfield 104	com/whatsapp/proto/c$b:i	Ljava/util/List;
      //   687: invokestatic 110	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
      //   690: putfield 104	com/whatsapp/proto/c$b:i	Ljava/util/List;
      //   693: aload 10
      //   695: invokevirtual 112	com/google/protobuf/g:a	()V
      //   698: aload_0
      //   699: aload 9
      //   701: invokevirtual 117	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   704: putfield 60	com/whatsapp/proto/c$b:k	Lcom/google/protobuf/e;
      //   707: return
      //   708: astore_1
      //   709: aload_0
      //   710: aload 9
      //   712: invokevirtual 117	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   715: putfield 60	com/whatsapp/proto/c$b:k	Lcom/google/protobuf/e;
      //   718: return
      //   719: astore_1
      //   720: aload_0
      //   721: aload 9
      //   723: invokevirtual 117	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   726: putfield 60	com/whatsapp/proto/c$b:k	Lcom/google/protobuf/e;
      //   729: aload_1
      //   730: athrow
      //   731: astore_2
      //   732: aload_0
      //   733: aload 9
      //   735: invokevirtual 117	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   738: putfield 60	com/whatsapp/proto/c$b:k	Lcom/google/protobuf/e;
      //   741: goto -481 -> 260
      //   744: astore_1
      //   745: aload_0
      //   746: aload 9
      //   748: invokevirtual 117	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   751: putfield 60	com/whatsapp/proto/c$b:k	Lcom/google/protobuf/e;
      //   754: aload_1
      //   755: athrow
      //   756: goto -612 -> 144
      //   759: iconst_1
      //   760: istore 5
      //   762: goto -724 -> 38
      //   765: astore_1
      //   766: iload 8
      //   768: istore_3
      //   769: goto -545 -> 224
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	772	0	this	b
      //   0	772	1	paramf	com.google.protobuf.f
      //   0	772	2	paramm	com.google.protobuf.m
      //   1	768	3	i1	int
      //   56	610	4	i2	int
      //   36	725	5	i3	int
      //   44	594	6	i4	int
      //   47	595	7	i5	int
      //   50	717	8	i6	int
      //   23	724	9	localc	com.google.protobuf.e.c
      //   33	661	10	localg	g
      //   275	312	11	locale	e
      // Exception table:
      //   from	to	target	type
      //   52	58	209	com/google/protobuf/q
      //   153	164	209	com/google/protobuf/q
      //   179	189	209	com/google/protobuf/q
      //   198	206	209	com/google/protobuf/q
      //   271	277	209	com/google/protobuf/q
      //   286	296	209	com/google/protobuf/q
      //   305	311	209	com/google/protobuf/q
      //   352	362	209	com/google/protobuf/q
      //   371	379	209	com/google/protobuf/q
      //   391	397	209	com/google/protobuf/q
      //   406	417	209	com/google/protobuf/q
      //   426	432	209	com/google/protobuf/q
      //   444	450	209	com/google/protobuf/q
      //   459	470	209	com/google/protobuf/q
      //   479	485	209	com/google/protobuf/q
      //   497	503	209	com/google/protobuf/q
      //   512	523	209	com/google/protobuf/q
      //   532	538	209	com/google/protobuf/q
      //   550	556	209	com/google/protobuf/q
      //   565	576	209	com/google/protobuf/q
      //   585	591	209	com/google/protobuf/q
      //   617	628	209	com/google/protobuf/q
      //   647	665	209	com/google/protobuf/q
      //   213	218	223	finally
      //   221	223	223	finally
      //   318	330	223	finally
      //   333	338	223	finally
      //   341	343	223	finally
      //   52	58	314	java/io/IOException
      //   153	164	314	java/io/IOException
      //   179	189	314	java/io/IOException
      //   198	206	314	java/io/IOException
      //   271	277	314	java/io/IOException
      //   286	296	314	java/io/IOException
      //   305	311	314	java/io/IOException
      //   352	362	314	java/io/IOException
      //   371	379	314	java/io/IOException
      //   391	397	314	java/io/IOException
      //   406	417	314	java/io/IOException
      //   426	432	314	java/io/IOException
      //   444	450	314	java/io/IOException
      //   459	470	314	java/io/IOException
      //   479	485	314	java/io/IOException
      //   497	503	314	java/io/IOException
      //   512	523	314	java/io/IOException
      //   532	538	314	java/io/IOException
      //   550	556	314	java/io/IOException
      //   565	576	314	java/io/IOException
      //   585	591	314	java/io/IOException
      //   617	628	314	java/io/IOException
      //   647	665	314	java/io/IOException
      //   693	698	708	java/io/IOException
      //   693	698	719	finally
      //   246	251	731	java/io/IOException
      //   246	251	744	finally
      //   52	58	765	finally
      //   153	164	765	finally
      //   179	189	765	finally
      //   198	206	765	finally
      //   271	277	765	finally
      //   286	296	765	finally
      //   305	311	765	finally
      //   352	362	765	finally
      //   371	379	765	finally
      //   391	397	765	finally
      //   406	417	765	finally
      //   426	432	765	finally
      //   444	450	765	finally
      //   459	470	765	finally
      //   479	485	765	finally
      //   497	503	765	finally
      //   512	523	765	finally
      //   532	538	765	finally
      //   550	556	765	finally
      //   565	576	765	finally
      //   585	591	765	finally
      //   617	628	765	finally
      //   647	665	765	finally
    }
    
    public static b a()
    {
      return j;
    }
    
    public static b a(e parame)
    {
      return (b)a.a(parame);
    }
    
    public static b a(byte[] paramArrayOfByte)
    {
      return (b)a.a(paramArrayOfByte);
    }
    
    private e c()
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
    
    private e d()
    {
      Object localObject = this.l;
      if ((localObject instanceof String))
      {
        localObject = e.a((String)localObject);
        this.l = localObject;
        return (e)localObject;
      }
      return (e)localObject;
    }
    
    private e e()
    {
      Object localObject = this.f;
      if ((localObject instanceof String))
      {
        localObject = e.a((String)localObject);
        this.f = localObject;
        return (e)localObject;
      }
      return (e)localObject;
    }
    
    private e f()
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
    
    private e g()
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
    
    private void h()
    {
      this.c = 0L;
      this.d = "";
      this.e = 0L;
      this.l = "";
      this.f = "";
      this.g = "";
      this.h = "";
      this.i = Collections.emptyList();
    }
    
    public final String b()
    {
      Object localObject = this.l;
      if ((localObject instanceof String)) {
        return (String)localObject;
      }
      localObject = (e)localObject;
      String str = ((e)localObject).e();
      if (((e)localObject).f()) {
        this.l = str;
      }
      return str;
    }
    
    public final ae<b> getParserForType()
    {
      return a;
    }
    
    public final int getSerializedSize()
    {
      int i3 = 0;
      int i1 = this.n;
      if (i1 != -1) {
        return i1;
      }
      if ((this.b & 0x1) == 1) {}
      for (int i2 = g.c(1, this.c) + 0;; i2 = 0)
      {
        i1 = i2;
        if ((this.b & 0x2) == 2) {
          i1 = i2 + g.c(2, c());
        }
        i2 = i1;
        if ((this.b & 0x4) == 4) {
          i2 = i1 + g.c(3, this.e);
        }
        i1 = i2;
        if ((this.b & 0x8) == 8) {
          i1 = i2 + g.c(4, d());
        }
        i2 = i1;
        if ((this.b & 0x10) == 16) {
          i2 = i1 + g.c(5, e());
        }
        i1 = i2;
        if ((this.b & 0x20) == 32) {
          i1 = i2 + g.c(6, f());
        }
        i2 = i1;
        if ((this.b & 0x40) == 64) {
          i2 = i1 + g.c(7, g());
        }
        i1 = i2;
        i2 = i3;
        while (i2 < this.i.size())
        {
          i3 = g.d(8, (x)this.i.get(i2));
          i2 += 1;
          i1 = i3 + i1;
        }
        i1 = this.k.a() + i1;
        this.n = i1;
        return i1;
      }
    }
    
    public final boolean isInitialized()
    {
      int i1 = this.m;
      if (i1 == 1) {
        return true;
      }
      if (i1 == 0) {
        return false;
      }
      this.m = 1;
      return true;
    }
    
    public final void writeTo(g paramg)
    {
      getSerializedSize();
      if ((this.b & 0x1) == 1) {
        paramg.a(1, this.c);
      }
      if ((this.b & 0x2) == 2) {
        paramg.a(2, c());
      }
      if ((this.b & 0x4) == 4) {
        paramg.a(3, this.e);
      }
      if ((this.b & 0x8) == 8) {
        paramg.a(4, d());
      }
      if ((this.b & 0x10) == 16) {
        paramg.a(5, e());
      }
      if ((this.b & 0x20) == 32) {
        paramg.a(6, f());
      }
      if ((this.b & 0x40) == 64) {
        paramg.a(7, g());
      }
      int i1 = 0;
      while (i1 < this.i.size())
      {
        paramg.b(8, (x)this.i.get(i1));
        i1 += 1;
      }
      paramg.c(this.k);
    }
    
    public static final class a
      extends GeneratedMessageLite.a<c.b, a>
      implements f.a
    {
      private int b;
      private long c;
      private Object d = "";
      private long e;
      private Object f = "";
      private Object g = "";
      private Object h = "";
      private Object i = "";
      private List<b> j = Collections.emptyList();
      
      /* Error */
      private a a(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
      {
        // Byte code:
        //   0: getstatic 57	com/whatsapp/proto/c$b:a	Lcom/google/protobuf/ae;
        //   3: aload_1
        //   4: aload_2
        //   5: invokeinterface 62 3 0
        //   10: checkcast 9	com/whatsapp/proto/c$b
        //   13: astore_1
        //   14: aload_1
        //   15: ifnull +9 -> 24
        //   18: aload_0
        //   19: aload_1
        //   20: invokevirtual 65	com/whatsapp/proto/c$b$a:a	(Lcom/whatsapp/proto/c$b;)Lcom/whatsapp/proto/c$b$a;
        //   23: pop
        //   24: aload_0
        //   25: areturn
        //   26: astore_2
        //   27: aload_2
        //   28: getfield 68	com/google/protobuf/q:a	Lcom/google/protobuf/x;
        //   31: checkcast 9	com/whatsapp/proto/c$b
        //   34: astore_1
        //   35: aload_2
        //   36: athrow
        //   37: astore_2
        //   38: aload_1
        //   39: ifnull +9 -> 48
        //   42: aload_0
        //   43: aload_1
        //   44: invokevirtual 65	com/whatsapp/proto/c$b$a:a	(Lcom/whatsapp/proto/c$b;)Lcom/whatsapp/proto/c$b$a;
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
      
      private c.b d()
      {
        int m = 1;
        c.b localb = new c.b(this, (byte)0);
        int n = this.b;
        if ((n & 0x1) == 1) {}
        for (;;)
        {
          c.b.a(localb, this.c);
          int k = m;
          if ((n & 0x2) == 2) {
            k = m | 0x2;
          }
          c.b.a(localb, this.d);
          m = k;
          if ((n & 0x4) == 4) {
            m = k | 0x4;
          }
          c.b.b(localb, this.e);
          k = m;
          if ((n & 0x8) == 8) {
            k = m | 0x8;
          }
          c.b.b(localb, this.f);
          m = k;
          if ((n & 0x10) == 16) {
            m = k | 0x10;
          }
          c.b.c(localb, this.g);
          k = m;
          if ((n & 0x20) == 32) {
            k = m | 0x20;
          }
          c.b.d(localb, this.h);
          m = k;
          if ((n & 0x40) == 64) {
            m = k | 0x40;
          }
          c.b.e(localb, this.i);
          if ((this.b & 0x80) == 128)
          {
            this.j = Collections.unmodifiableList(this.j);
            this.b &= 0xFF7F;
          }
          c.b.a(localb, this.j);
          c.b.a(localb, m);
          return localb;
          m = 0;
        }
      }
      
      public final a a(c.b paramb)
      {
        int m = 1;
        if (paramb == c.b.a()) {
          return this;
        }
        int k;
        if ((paramb.b & 0x1) == 1)
        {
          k = 1;
          long l;
          if (k != 0)
          {
            l = paramb.c;
            this.b |= 0x1;
            this.c = l;
          }
          if ((paramb.b & 0x2) != 2) {
            break label335;
          }
          k = 1;
          label61:
          if (k != 0)
          {
            this.b |= 0x2;
            this.d = c.b.a(paramb);
          }
          if ((paramb.b & 0x4) != 4) {
            break label340;
          }
          k = 1;
          label95:
          if (k != 0)
          {
            l = paramb.e;
            this.b |= 0x4;
            this.e = l;
          }
          if ((paramb.b & 0x8) != 8) {
            break label345;
          }
          k = 1;
          label135:
          if (k != 0)
          {
            this.b |= 0x8;
            this.f = c.b.b(paramb);
          }
          if ((paramb.b & 0x10) != 16) {
            break label350;
          }
          k = 1;
          label172:
          if (k != 0)
          {
            this.b |= 0x10;
            this.g = c.b.c(paramb);
          }
          if ((paramb.b & 0x20) != 32) {
            break label355;
          }
          k = 1;
          label209:
          if (k != 0)
          {
            this.b |= 0x20;
            this.h = c.b.d(paramb);
          }
          if ((paramb.b & 0x40) != 64) {
            break label360;
          }
          k = m;
          label246:
          if (k != 0)
          {
            this.b |= 0x40;
            this.i = c.b.e(paramb);
          }
          if (!c.b.f(paramb).isEmpty())
          {
            if (!this.j.isEmpty()) {
              break label365;
            }
            this.j = c.b.f(paramb);
            this.b &= 0xFF7F;
          }
        }
        for (;;)
        {
          this.a = this.a.a(c.b.g(paramb));
          return this;
          k = 0;
          break;
          label335:
          k = 0;
          break label61;
          label340:
          k = 0;
          break label95;
          label345:
          k = 0;
          break label135;
          label350:
          k = 0;
          break label172;
          label355:
          k = 0;
          break label209;
          label360:
          k = 0;
          break label246;
          label365:
          if ((this.b & 0x80) != 128)
          {
            this.j = new ArrayList(this.j);
            this.b |= 0x80;
          }
          this.j.addAll(c.b.f(paramb));
        }
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/proto/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */