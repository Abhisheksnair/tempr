package com.whatsapp.proto;

import android.support.design.widget.f.a;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.a;
import com.google.protobuf.ae;
import com.google.protobuf.c;
import com.google.protobuf.e;
import com.google.protobuf.g;

public final class b
  extends GeneratedMessageLite
  implements f.a
{
  public static ae<b> a = new c() {};
  private static final b d;
  int b;
  public Object c;
  private final e e;
  private Object f;
  private Object g;
  private byte h = -1;
  private int i = -1;
  
  static
  {
    b localb = new b();
    d = localb;
    localb.g();
  }
  
  private b()
  {
    this.e = e.b;
  }
  
  private b(GeneratedMessageLite.a parama)
  {
    super((byte)0);
    this.e = parama.a;
  }
  
  /* Error */
  private b(com.google.protobuf.f paramf)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 40	com/google/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 42	com/whatsapp/proto/b:h	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 44	com/whatsapp/proto/b:i	I
    //   14: aload_0
    //   15: invokespecial 38	com/whatsapp/proto/b:g	()V
    //   18: invokestatic 69	com/google/protobuf/e:h	()Lcom/google/protobuf/e$c;
    //   21: astore 4
    //   23: aload 4
    //   25: sipush 4096
    //   28: invokestatic 74	com/google/protobuf/g:a	(Ljava/io/OutputStream;I)Lcom/google/protobuf/g;
    //   31: astore 5
    //   33: iconst_0
    //   34: istore_2
    //   35: iload_2
    //   36: ifne +187 -> 223
    //   39: aload_1
    //   40: invokevirtual 79	com/google/protobuf/f:a	()I
    //   43: istore_3
    //   44: iload_3
    //   45: lookupswitch	default:+242->287, 0:+245->290, 10:+58->103, 18:+108->153, 26:+153->198
    //   88: aload_1
    //   89: iload_3
    //   90: aload 5
    //   92: invokevirtual 82	com/google/protobuf/f:a	(ILcom/google/protobuf/g;)Z
    //   95: ifne -60 -> 35
    //   98: iconst_1
    //   99: istore_2
    //   100: goto -65 -> 35
    //   103: aload_1
    //   104: invokevirtual 85	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
    //   107: astore 6
    //   109: aload_0
    //   110: aload_0
    //   111: getfield 87	com/whatsapp/proto/b:b	I
    //   114: iconst_1
    //   115: ior
    //   116: putfield 87	com/whatsapp/proto/b:b	I
    //   119: aload_0
    //   120: aload 6
    //   122: putfield 89	com/whatsapp/proto/b:f	Ljava/lang/Object;
    //   125: goto -90 -> 35
    //   128: astore_1
    //   129: aload_1
    //   130: aload_0
    //   131: putfield 92	com/google/protobuf/q:a	Lcom/google/protobuf/x;
    //   134: aload_1
    //   135: athrow
    //   136: astore_1
    //   137: aload 5
    //   139: invokevirtual 94	com/google/protobuf/g:a	()V
    //   142: aload_0
    //   143: aload 4
    //   145: invokevirtual 98	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   148: putfield 50	com/whatsapp/proto/b:e	Lcom/google/protobuf/e;
    //   151: aload_1
    //   152: athrow
    //   153: aload_1
    //   154: invokevirtual 85	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
    //   157: astore 6
    //   159: aload_0
    //   160: aload_0
    //   161: getfield 87	com/whatsapp/proto/b:b	I
    //   164: iconst_2
    //   165: ior
    //   166: putfield 87	com/whatsapp/proto/b:b	I
    //   169: aload_0
    //   170: aload 6
    //   172: putfield 100	com/whatsapp/proto/b:g	Ljava/lang/Object;
    //   175: goto -140 -> 35
    //   178: astore_1
    //   179: new 64	com/google/protobuf/q
    //   182: dup
    //   183: aload_1
    //   184: invokevirtual 104	java/io/IOException:getMessage	()Ljava/lang/String;
    //   187: invokespecial 107	com/google/protobuf/q:<init>	(Ljava/lang/String;)V
    //   190: astore_1
    //   191: aload_1
    //   192: aload_0
    //   193: putfield 92	com/google/protobuf/q:a	Lcom/google/protobuf/x;
    //   196: aload_1
    //   197: athrow
    //   198: aload_1
    //   199: invokevirtual 85	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
    //   202: astore 6
    //   204: aload_0
    //   205: aload_0
    //   206: getfield 87	com/whatsapp/proto/b:b	I
    //   209: iconst_4
    //   210: ior
    //   211: putfield 87	com/whatsapp/proto/b:b	I
    //   214: aload_0
    //   215: aload 6
    //   217: putfield 109	com/whatsapp/proto/b:c	Ljava/lang/Object;
    //   220: goto -185 -> 35
    //   223: aload 5
    //   225: invokevirtual 94	com/google/protobuf/g:a	()V
    //   228: aload_0
    //   229: aload 4
    //   231: invokevirtual 98	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   234: putfield 50	com/whatsapp/proto/b:e	Lcom/google/protobuf/e;
    //   237: return
    //   238: astore_1
    //   239: aload_0
    //   240: aload 4
    //   242: invokevirtual 98	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   245: putfield 50	com/whatsapp/proto/b:e	Lcom/google/protobuf/e;
    //   248: return
    //   249: astore_1
    //   250: aload_0
    //   251: aload 4
    //   253: invokevirtual 98	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   256: putfield 50	com/whatsapp/proto/b:e	Lcom/google/protobuf/e;
    //   259: aload_1
    //   260: athrow
    //   261: astore 5
    //   263: aload_0
    //   264: aload 4
    //   266: invokevirtual 98	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   269: putfield 50	com/whatsapp/proto/b:e	Lcom/google/protobuf/e;
    //   272: goto -121 -> 151
    //   275: astore_1
    //   276: aload_0
    //   277: aload 4
    //   279: invokevirtual 98	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   282: putfield 50	com/whatsapp/proto/b:e	Lcom/google/protobuf/e;
    //   285: aload_1
    //   286: athrow
    //   287: goto -199 -> 88
    //   290: iconst_1
    //   291: istore_2
    //   292: goto -257 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	b
    //   0	295	1	paramf	com.google.protobuf.f
    //   34	258	2	j	int
    //   43	47	3	k	int
    //   21	257	4	localc	com.google.protobuf.e.c
    //   31	193	5	localg	g
    //   261	1	5	localIOException	java.io.IOException
    //   107	109	6	locale	e
    // Exception table:
    //   from	to	target	type
    //   39	44	128	com/google/protobuf/q
    //   88	98	128	com/google/protobuf/q
    //   103	125	128	com/google/protobuf/q
    //   153	175	128	com/google/protobuf/q
    //   198	220	128	com/google/protobuf/q
    //   39	44	136	finally
    //   88	98	136	finally
    //   103	125	136	finally
    //   129	136	136	finally
    //   153	175	136	finally
    //   179	198	136	finally
    //   198	220	136	finally
    //   39	44	178	java/io/IOException
    //   88	98	178	java/io/IOException
    //   103	125	178	java/io/IOException
    //   153	175	178	java/io/IOException
    //   198	220	178	java/io/IOException
    //   223	228	238	java/io/IOException
    //   223	228	249	finally
    //   137	142	261	java/io/IOException
    //   137	142	275	finally
  }
  
  public static b a()
  {
    return d;
  }
  
  private e d()
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
  
  private e e()
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
  
  private e f()
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
  
  private void g()
  {
    this.f = "";
    this.g = "";
    this.c = "";
  }
  
  public final String b()
  {
    Object localObject = this.f;
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    localObject = (e)localObject;
    String str = ((e)localObject).e();
    if (((e)localObject).f()) {
      this.f = str;
    }
    return str;
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
      k = g.c(1, d()) + 0;
    }
    j = k;
    if ((this.b & 0x2) == 2) {
      j = k + g.c(2, e());
    }
    k = j;
    if ((this.b & 0x4) == 4) {
      k = j + g.c(3, f());
    }
    j = k + this.e.a();
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
      paramg.a(1, d());
    }
    if ((this.b & 0x2) == 2) {
      paramg.a(2, e());
    }
    if ((this.b & 0x4) == 4) {
      paramg.a(3, f());
    }
    paramg.c(this.e);
  }
  
  public static final class a
    extends GeneratedMessageLite.a<b, a>
    implements f.a
  {
    private int b;
    private Object c = "";
    private Object d = "";
    private Object e = "";
    
    /* Error */
    private a a(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
    {
      // Byte code:
      //   0: getstatic 35	com/whatsapp/proto/b:a	Lcom/google/protobuf/ae;
      //   3: aload_1
      //   4: aload_2
      //   5: invokeinterface 40 3 0
      //   10: checkcast 9	com/whatsapp/proto/b
      //   13: astore_1
      //   14: aload_1
      //   15: ifnull +9 -> 24
      //   18: aload_0
      //   19: aload_1
      //   20: invokevirtual 43	com/whatsapp/proto/b$a:a	(Lcom/whatsapp/proto/b;)Lcom/whatsapp/proto/b$a;
      //   23: pop
      //   24: aload_0
      //   25: areturn
      //   26: astore_2
      //   27: aload_2
      //   28: getfield 46	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   31: checkcast 9	com/whatsapp/proto/b
      //   34: astore_1
      //   35: aload_2
      //   36: athrow
      //   37: astore_2
      //   38: aload_1
      //   39: ifnull +9 -> 48
      //   42: aload_0
      //   43: aload_1
      //   44: invokevirtual 43	com/whatsapp/proto/b$a:a	(Lcom/whatsapp/proto/b;)Lcom/whatsapp/proto/b$a;
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
    
    private b d()
    {
      int j = 1;
      b localb = new b(this, (byte)0);
      int k = this.b;
      if ((k & 0x1) == 1) {}
      for (;;)
      {
        b.a(localb, this.c);
        int i = j;
        if ((k & 0x2) == 2) {
          i = j | 0x2;
        }
        b.b(localb, this.d);
        j = i;
        if ((k & 0x4) == 4) {
          j = i | 0x4;
        }
        b.c(localb, this.e);
        b.a(localb, j);
        return localb;
        j = 0;
      }
    }
    
    public final a a(b paramb)
    {
      int j = 1;
      if (paramb == b.a()) {
        return this;
      }
      if ((paramb.b & 0x1) == 1)
      {
        i = 1;
        if (i != 0)
        {
          this.b |= 0x1;
          this.c = b.a(paramb);
        }
        if ((paramb.b & 0x2) != 2) {
          break label135;
        }
        i = 1;
        label57:
        if (i != 0)
        {
          this.b |= 0x2;
          this.d = b.b(paramb);
        }
        if ((paramb.b & 0x4) != 4) {
          break label140;
        }
      }
      label135:
      label140:
      for (int i = j;; i = 0)
      {
        if (i != 0)
        {
          this.b |= 0x4;
          this.e = b.c(paramb);
        }
        this.a = this.a.a(b.d(paramb));
        return this;
        i = 0;
        break;
        i = 0;
        break label57;
      }
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/proto/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */