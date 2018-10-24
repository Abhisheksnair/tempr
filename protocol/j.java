package com.whatsapp.protocol;

import android.text.TextUtils;
import com.whatsapp.MediaData;
import com.whatsapp.TextData;
import com.whatsapp.data.cq;
import com.whatsapp.va;
import java.util.ArrayList;
import java.util.List;

public class j
{
  public static final int[] c = { 14, 0, 1, 2, 3, 4, 5, 11, 12, 13, 8, 9, 10, 7, 6 };
  public boolean A;
  public double B;
  public double C;
  public String D;
  public boolean E;
  public int F;
  public long G;
  public String H;
  public long I;
  public long J;
  public long K;
  public long L;
  public c M = c.a;
  public Object N;
  public byte[] O;
  public List<String> P;
  public volatile long Q = -1L;
  public Integer R = null;
  public int S = 0;
  public boolean T;
  public long U;
  public j V;
  public String W;
  public int X;
  public Long Y;
  public byte[] Z;
  private String a;
  public boolean aa;
  public int ab;
  public String ac;
  public String ad;
  public int ae;
  public boolean af;
  private l ag;
  private k ah;
  private byte[] b;
  public int d;
  public b e;
  public String f;
  public String g;
  public String[] h;
  public f i;
  public f j;
  public boolean k;
  public int l;
  public int m;
  public long n;
  public int o;
  public String p;
  public String q;
  public String r;
  public byte s;
  public long t;
  public String u;
  public String v;
  public int w;
  public int x;
  public String y;
  public String z;
  
  public j(b paramb)
  {
    this.e = paramb;
  }
  
  public j(j paramj)
  {
    c(paramj);
  }
  
  public j(va paramva, String paramString)
  {
    this.e = a(paramva, paramString, true);
  }
  
  public j(va paramva, String paramString, Object paramObject)
  {
    this(paramva, paramString);
    this.N = paramObject;
    this.n = m.a();
  }
  
  public j(va paramva, String paramString1, String paramString2)
  {
    this(paramva, paramString1, null);
    this.a = paramString2;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("unrecognized ciphertext message type; type=" + paramInt);
    case 2: 
      return 0;
    case 3: 
      return 1;
    }
    return 2;
  }
  
  public static b a(va paramva, String paramString, boolean paramBoolean)
  {
    paramva = m.a(paramva);
    if (paramva == null) {
      throw new IllegalStateException("message id could not be created");
    }
    return new b(paramString, paramBoolean, m.b(paramva));
  }
  
  public static String a(byte paramByte)
  {
    if (paramByte == 0) {}
    do
    {
      return null;
      if (paramByte == 7) {
        return "system";
      }
      if (paramByte == 1) {
        return "image";
      }
      if (paramByte == 2) {
        return "audio";
      }
      if (paramByte == 3) {
        return "video";
      }
      if (paramByte == 13) {
        return "gif";
      }
      if (paramByte == 4) {
        return "vcard";
      }
      if (paramByte == 5) {
        return "location";
      }
      if (paramByte == 16) {
        return "livelocation";
      }
    } while (paramByte != 9);
    return "document";
  }
  
  private static void a(j paramj1, j paramj2, boolean paramBoolean)
  {
    for (;;)
    {
      if ((paramj1.f() != null) && (paramj2.f() != null) && (paramj1.f().a())) {
        paramj2.f().a(paramj1.f().b(), paramBoolean);
      }
      if ((paramj1.V == null) || (paramj2.V == null)) {
        break;
      }
      paramj1 = paramj1.V;
      paramj2 = paramj2.V;
      paramBoolean = true;
    }
  }
  
  public static boolean a(String paramString)
  {
    return "broadcast".equals(paramString);
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt == 10) || (paramInt == 9) || (paramInt == 8);
  }
  
  public static boolean b(j paramj)
  {
    return (paramj != null) && (paramj.s == 16);
  }
  
  public static boolean b(String paramString)
  {
    return (paramString != null) && (paramString.endsWith("@broadcast"));
  }
  
  private void c(j paramj)
  {
    this.e = paramj.e;
    this.f = paramj.f;
    this.g = paramj.g;
    this.a = paramj.a;
    this.b = paramj.b;
    this.i = paramj.i;
    this.j = paramj.j;
    this.m = paramj.m;
    this.n = paramj.n;
    this.o = paramj.o;
    this.p = paramj.p;
    this.q = paramj.q;
    this.r = paramj.r;
    this.s = paramj.s;
    this.t = paramj.t;
    this.u = paramj.u;
    this.v = paramj.v;
    this.w = paramj.w;
    this.x = paramj.x;
    this.y = paramj.y;
    this.z = paramj.z;
    this.A = paramj.A;
    this.B = paramj.B;
    this.C = paramj.C;
    this.D = paramj.D;
    this.E = paramj.E;
    this.F = paramj.F;
    this.G = paramj.G;
    this.H = paramj.H;
    this.J = paramj.J;
    this.K = paramj.K;
    this.L = paramj.L;
    this.M = paramj.M;
    this.N = paramj.N;
    this.Q = paramj.Q;
    this.R = paramj.R;
    this.S = paramj.S;
    this.U = paramj.U;
    this.V = paramj.V;
    if (paramj.P == null) {}
    for (ArrayList localArrayList = null;; localArrayList = new ArrayList(paramj.P))
    {
      this.P = localArrayList;
      this.W = paramj.W;
      this.Y = paramj.Y;
      this.ab = paramj.ab;
      a(paramj, this, false);
      if ((paramj.g() != null) && (g() != null) && (paramj.g().c())) {
        g().a(paramj.g().a());
      }
      return;
    }
  }
  
  public static boolean c(String paramString)
  {
    return "status@broadcast".equals(paramString);
  }
  
  public static byte d(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return 0;
      if (paramString.equalsIgnoreCase("system")) {
        return 7;
      }
      if (paramString.equalsIgnoreCase("image")) {
        return 1;
      }
      if (paramString.equalsIgnoreCase("audio")) {
        return 2;
      }
      if (paramString.equalsIgnoreCase("video")) {
        return 3;
      }
      if (paramString.equalsIgnoreCase("vcard")) {
        return 4;
      }
      if (paramString.equalsIgnoreCase("location")) {
        return 5;
      }
      if (paramString.equalsIgnoreCase("livelocation")) {
        return 16;
      }
    } while (!paramString.equalsIgnoreCase("document"));
    return 9;
  }
  
  public final void a(j paramj)
  {
    c(paramj);
    this.d = paramj.d;
    this.h = paramj.h;
    this.k = paramj.k;
    this.l = paramj.l;
    this.O = paramj.O;
    this.T = paramj.T;
  }
  
  public final void a(j paramj, cq paramcq)
  {
    if (paramj == null) {}
    for (j localj = null;; localj = new j(paramj))
    {
      this.V = localj;
      if ((this.V != null) && (this.V.f() != null) && (paramj.f() != null) && (paramj.f().c()))
      {
        paramj.f().a(paramcq);
        this.V.f().a(paramj.f().b(), true);
      }
      return;
    }
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i3 = 0;
    int i1;
    if (paramBoolean1)
    {
      i1 = 4;
      if (!paramBoolean2) {
        break label46;
      }
    }
    label46:
    for (int i2 = 2;; i2 = 0)
    {
      if (!TextUtils.isEmpty(this.W)) {
        i3 = 1;
      }
      this.X = (i2 | i1 | i3);
      return;
      i1 = 0;
      break;
    }
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    try
    {
      this.b = paramArrayOfByte;
      this.a = null;
      this.m = 1;
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public final boolean a()
  {
    return "status@broadcast".equals(this.e.a);
  }
  
  public final boolean a(va paramva)
  {
    return (this.e.b) && (this.d != 6) && ((paramva.b() + "@s.whatsapp.net").equals(this.e.a));
  }
  
  public final MediaData b()
  {
    if ((this.N instanceof MediaData)) {
      return (MediaData)this.N;
    }
    return null;
  }
  
  public final TextData c()
  {
    if ((this.N instanceof TextData)) {
      return (TextData)this.N;
    }
    return null;
  }
  
  /* Error */
  public final boolean d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 134	com/whatsapp/protocol/j:a	Ljava/lang/String;
    //   6: ifnonnull +12 -> 18
    //   9: aload_0
    //   10: getfield 228	com/whatsapp/protocol/j:b	[B
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +9 -> 24
    //   18: iconst_1
    //   19: istore_1
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: iconst_0
    //   25: istore_1
    //   26: goto -6 -> 20
    //   29: astore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_2
    //   33: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	34	0	this	j
    //   19	7	1	bool	boolean
    //   13	2	2	arrayOfByte	byte[]
    //   29	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	29	finally
  }
  
  public final String e()
  {
    try
    {
      if (this.m == 1) {
        throw new RuntimeException("trying to get data as text on raw message");
      }
    }
    finally {}
    if ((this.a == null) && (this.b != null)) {
      this.a = s.a(this.b);
    }
    String str = this.a;
    return str;
  }
  
  public final void e(String paramString)
  {
    try
    {
      this.a = paramString;
      this.b = null;
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final l f()
  {
    try
    {
      if ((this.ag == null) && (l.a(this.s))) {
        this.ag = new l(this);
      }
      l locall = this.ag;
      return locall;
    }
    finally {}
  }
  
  public final k g()
  {
    try
    {
      if ((this.ah == null) && (k.a(this.s))) {
        this.ah = new k(this);
      }
      k localk = this.ah;
      return localk;
    }
    finally {}
  }
  
  public final byte[] h()
  {
    try
    {
      if ((this.b == null) && (this.a != null)) {
        this.b = s.a(this.a);
      }
      byte[] arrayOfByte = this.b;
      return arrayOfByte;
    }
    finally {}
  }
  
  public final int i()
  {
    int i2 = this.X;
    if (this.W == null) {}
    for (int i1 = 0;; i1 = 1) {
      return i1 | i2;
    }
  }
  
  public final void j()
  {
    for (j localj = this; localj != null; localj = localj.V)
    {
      if (localj.f() != null) {
        localj.f().b = true;
      }
      if (localj.g() != null) {
        localj.g().b = true;
      }
    }
  }
  
  public static final class a
  {
    private Integer A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private Double G;
    private Double H;
    private j.c I;
    private Object J;
    private List<String> K;
    private Long L;
    public String a;
    public String b;
    public String c;
    public String d;
    byte[] e;
    Integer f;
    f g;
    f h;
    public Integer i;
    Integer j;
    Integer k;
    Boolean l;
    String m;
    Boolean n;
    byte[] o;
    byte[] p;
    Integer q;
    Integer r;
    private j s;
    private Boolean t;
    private Long u;
    private Integer v;
    private Byte w;
    private Long x;
    private String y;
    private String z;
    
    public final a a()
    {
      this.t = Boolean.FALSE;
      return this;
    }
    
    public final a a(long paramLong)
    {
      this.u = Long.valueOf(paramLong);
      return this;
    }
    
    public final a b()
    {
      if ((this.a == null) || (this.t == null) || (this.c == null)) {
        throw new UnsupportedOperationException("missing required property before instantiating new incoming message");
      }
      this.s = new j(new j.b(this.a, this.t.booleanValue(), this.c));
      return this;
    }
    
    public final a b(long paramLong)
    {
      this.L = Long.valueOf(paramLong);
      return this;
    }
    
    public final j c()
    {
      if (this.s == null) {
        return null;
      }
      if ((this.a != null) && (this.t != null) && (this.c != null)) {
        this.s.e = new j.b(this.a, this.t.booleanValue(), this.c);
      }
      if (this.b != null) {
        this.s.f = this.b;
      }
      if (this.d != null) {
        this.s.e(this.d);
      }
      if (this.e != null) {
        this.s.a(this.e);
      }
      if (this.g != null) {
        this.s.i = this.g;
      }
      if (this.h != null) {
        this.s.j = this.h;
      }
      if (this.f != null) {
        this.s.l = this.f.intValue();
      }
      if (this.i != null) {
        this.s.m = this.i.intValue();
      }
      if (this.v != null) {
        this.s.o = this.v.intValue();
      }
      if (this.u != null) {
        this.s.n = this.u.longValue();
      }
      if (this.j != null) {
        this.s.R = this.j;
      }
      if (this.w != null) {
        this.s.s = this.w.byteValue();
      }
      if (this.x != null) {
        this.s.t = this.x.longValue();
      }
      if (this.y != null) {
        this.s.u = this.y;
      }
      if (this.z != null) {
        this.s.v = this.z;
      }
      if (this.k != null) {
        this.s.w = this.k.intValue();
      }
      if (this.A != null) {
        this.s.x = this.A.intValue();
      }
      if (this.B != null) {
        this.s.p = this.B;
      }
      if (this.C != null) {
        this.s.q = this.C;
      }
      if (this.D != null) {
        this.s.r = this.D;
      }
      if (this.E != null) {
        this.s.y = this.E;
      }
      if (this.F != null) {
        this.s.z = this.F;
      }
      if (this.l != null) {
        this.s.A = this.l.booleanValue();
      }
      if (this.G != null) {
        this.s.B = this.G.doubleValue();
      }
      if (this.H != null) {
        this.s.C = this.H.doubleValue();
      }
      if (this.m != null) {
        this.s.D = this.m;
      }
      if (this.n != null) {
        this.s.E = this.n.booleanValue();
      }
      if (this.I != null) {
        this.s.M = this.I;
      }
      if (this.J != null) {
        j.a(this.s, this.J);
      }
      if (this.o != null) {
        this.s.O = this.o;
      }
      if (this.K != null) {
        this.s.P = this.K;
      }
      if (this.L != null) {
        this.s.Y = this.L;
      }
      if (this.p != null) {
        this.s.Z = this.p;
      }
      if (this.r != null) {
        this.s.ab = this.r.intValue();
      }
      if (this.q != null) {
        this.s.X = this.q.intValue();
      }
      return this.s;
    }
  }
  
  public static final class b
  {
    public final String a;
    public final boolean b;
    public final String c;
    
    public b(String paramString1, boolean paramBoolean, String paramString2)
    {
      this.a = paramString1;
      this.b = paramBoolean;
      this.c = paramString2;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        do
        {
          return true;
          if (paramObject == null) {
            return false;
          }
          if (getClass() != paramObject.getClass()) {
            return false;
          }
          paramObject = (b)paramObject;
          if (this.b != ((b)paramObject).b) {
            return false;
          }
          if (this.c == null)
          {
            if (((b)paramObject).c != null) {
              return false;
            }
          }
          else if (!this.c.equals(((b)paramObject).c)) {
            return false;
          }
          if (this.a != null) {
            break;
          }
        } while (((b)paramObject).a == null);
        return false;
      } while (this.a.equals(((b)paramObject).a));
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      int i;
      int j;
      if (this.b)
      {
        i = 1231;
        if (this.c != null) {
          break label51;
        }
        j = 0;
        label22:
        if (this.a != null) {
          break label62;
        }
      }
      for (;;)
      {
        return (j + (i + 31) * 31) * 31 + k;
        i = 1237;
        break;
        label51:
        j = this.c.hashCode();
        break label22;
        label62:
        k = this.a.hashCode();
      }
    }
    
    public final String toString()
    {
      return "Key[id=" + this.c + ", from_me=" + this.b + ", remote_jid=" + this.a + "]";
    }
  }
  
  public static enum c
  {
    private c() {}
    
    public final boolean a()
    {
      return (this == c) || (this == d);
    }
    
    public final String b()
    {
      switch (j.1.a[ordinal()])
      {
      default: 
        return "none";
      case 1: 
        return "invis";
      }
      return "relay";
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/protocol/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */