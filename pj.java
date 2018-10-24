package com.whatsapp;

import android.content.ContentResolver;
import android.net.Uri;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Vector;

public final class pj
  implements Closeable
{
  protected byte[] A = new byte['Ā'];
  protected int B = 0;
  protected int C = 0;
  protected int D = 0;
  protected boolean E = false;
  protected int F = 0;
  protected int G;
  protected short[] H;
  protected byte[] I;
  protected byte[] J;
  protected byte[] K;
  protected Vector<Integer> L;
  protected int M;
  protected long N = 0L;
  protected InputStream a;
  protected int b;
  protected int c;
  protected int d;
  protected boolean e;
  protected int f;
  protected int g = 1;
  protected int[] h;
  protected int[] i;
  protected int[] j;
  protected int k;
  protected int l;
  protected int m;
  protected int n;
  protected boolean o;
  protected boolean p;
  protected int q;
  protected int r;
  protected int s;
  protected int t;
  protected int u;
  protected int v;
  protected int w;
  protected int x;
  protected int y;
  protected byte[] z;
  
  private pj(and paramand, Uri paramUri)
  {
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject3 = null;
    Object localObject1 = localObject4;
    Object localObject2 = localObject5;
    for (;;)
    {
      try
      {
        if (paramUri.getScheme() != null)
        {
          localObject1 = localObject4;
          localObject2 = localObject5;
          if (!paramUri.getScheme().equals("file")) {
            continue;
          }
        }
        localObject1 = localObject4;
        localObject2 = localObject5;
        paramand = new FileInputStream(new File(paramUri.getPath()));
      }
      catch (FileNotFoundException paramand)
      {
        Log.d("Media file cannot be found", paramand);
        paramUri = (Uri)localObject1;
        continue;
        localObject1 = localObject4;
        localObject2 = localObject5;
        paramand = paramand.openInputStream(paramUri);
        continue;
      }
      catch (IOException paramand)
      {
        Log.d("Media file generated IOException", paramand);
        paramUri = (Uri)localObject2;
        continue;
        this.b = 2;
      }
      paramUri = paramand;
      localObject1 = paramand;
      localObject2 = paramand;
      if ((paramand instanceof FileInputStream))
      {
        localObject1 = paramand;
        localObject2 = paramand;
        MediaFileUtils.a((FileInputStream)paramand);
        paramUri = paramand;
      }
      d();
      if (paramUri == null) {
        continue;
      }
      this.a = paramUri;
      g();
      return;
      localObject1 = localObject4;
      localObject2 = localObject5;
      paramand = paramand.f;
      if (paramand != null) {
        continue;
      }
      localObject1 = localObject4;
      localObject2 = localObject5;
      Log.w("gif-utils cr=null");
      paramand = (and)localObject3;
    }
  }
  
  private pj(File paramFile)
  {
    paramFile = new FileInputStream(paramFile);
    d();
    this.a = paramFile;
    g();
  }
  
  private int a(int paramInt)
  {
    int i1 = paramInt / this.c;
    int i2 = this.c;
    return (this.d - 1 - i1) * this.c + paramInt % i2;
  }
  
  private static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramInt1 *= 3;
    int i1 = (byte)(paramInt2 >> 16);
    int i2 = (byte)(paramInt2 >> 8);
    int i3 = (byte)paramInt2;
    paramArrayOfByte[paramInt1] = i1;
    paramArrayOfByte[(paramInt1 + 1)] = i2;
    paramArrayOfByte[(paramInt1 + 2)] = i3;
  }
  
  private boolean a()
  {
    boolean bool2 = false;
    int i1 = 0;
    boolean bool1;
    if ((i1 == 0) && (!c())) {
      bool1 = bool2;
    }
    switch (e())
    {
    default: 
      this.b = 1;
    case 33: 
    case 59: 
      for (;;)
      {
        Log.i("switch ending");
        break;
        int i2;
        switch (e())
        {
        default: 
          j();
          break;
        case 249: 
          e();
          i2 = e();
          this.C = ((i2 & 0x1C) >> 2);
          if (this.C == 0) {
            this.C = 1;
          }
          if ((i2 & 0x1) != 0) {}
          for (bool1 = true;; bool1 = false)
          {
            this.E = bool1;
            this.F = (i() * 10);
            this.G = e();
            e();
            break;
          }
        case 255: 
          f();
          String str = "";
          i2 = 0;
          while (i2 < 11)
          {
            str = str + (char)this.A[i2];
            i2 += 1;
          }
          if (str.equals("NETSCAPE2.0")) {
            h();
          } else {
            j();
          }
          break;
        case 254: 
          j();
          break;
        case 1: 
          j();
          continue;
          i1 = 1;
        }
      }
      bool1 = true;
    }
    return bool1;
  }
  
  public static boolean a(and paramand, Uri paramUri)
  {
    pj localpj = new pj(paramand, paramUri);
    and localand = null;
    try
    {
      boolean bool = localpj.a();
      if (bool)
      {
        localpj.close();
        return true;
      }
      localpj.b();
      bool = localpj.a();
      localpj.close();
      return bool;
    }
    catch (Throwable paramand)
    {
      try
      {
        throw paramand;
      }
      finally
      {
        localand = paramand;
      }
      if (localand != null) {}
      try
      {
        localpj.close();
        throw paramand;
        localpj.close();
      }
      catch (Throwable paramUri) {}
    }
    finally
    {
      for (;;) {}
    }
  }
  
  public static boolean a(File paramFile)
  {
    pj localpj = new pj(paramFile);
    File localFile = null;
    try
    {
      boolean bool = localpj.a();
      if (bool)
      {
        localpj.close();
        return true;
      }
      localpj.b();
      bool = localpj.a();
      localpj.close();
      return bool;
    }
    catch (Throwable paramFile)
    {
      try
      {
        throw paramFile;
      }
      finally
      {
        localFile = paramFile;
      }
      if (localFile != null) {}
      try
      {
        localpj.close();
        throw paramFile;
        localpj.close();
      }
      catch (Throwable localThrowable) {}
    }
    finally
    {
      for (;;) {}
    }
  }
  
  public static boolean a(String paramString)
  {
    return (paramString != null) && (b(new File(paramString)));
  }
  
  /* Error */
  public static boolean b(and paramand, Uri paramUri)
  {
    // Byte code:
    //   0: new 2	com/whatsapp/pj
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: invokespecial 191	com/whatsapp/pj:<init>	(Lcom/whatsapp/and;Landroid/net/Uri;)V
    //   9: astore_3
    //   10: aconst_null
    //   11: astore_0
    //   12: aload_3
    //   13: invokespecial 152	com/whatsapp/pj:c	()Z
    //   16: istore_2
    //   17: iload_2
    //   18: ifne +11 -> 29
    //   21: iconst_1
    //   22: istore_2
    //   23: aload_3
    //   24: invokevirtual 196	com/whatsapp/pj:close	()V
    //   27: iload_2
    //   28: ireturn
    //   29: iconst_0
    //   30: istore_2
    //   31: goto -8 -> 23
    //   34: astore_1
    //   35: aload_1
    //   36: astore_0
    //   37: aload_1
    //   38: athrow
    //   39: astore_1
    //   40: aload_0
    //   41: ifnull +18 -> 59
    //   44: aload_3
    //   45: invokevirtual 196	com/whatsapp/pj:close	()V
    //   48: aload_1
    //   49: athrow
    //   50: astore_0
    //   51: ldc -50
    //   53: aload_0
    //   54: invokestatic 132	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   57: iconst_0
    //   58: ireturn
    //   59: aload_3
    //   60: invokevirtual 196	com/whatsapp/pj:close	()V
    //   63: goto -15 -> 48
    //   66: astore_0
    //   67: goto -19 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramand	and
    //   0	70	1	paramUri	Uri
    //   16	15	2	bool	boolean
    //   9	51	3	localpj	pj
    // Exception table:
    //   from	to	target	type
    //   12	17	34	java/lang/Throwable
    //   12	17	39	finally
    //   37	39	39	finally
    //   0	10	50	java/io/FileNotFoundException
    //   23	27	50	java/io/FileNotFoundException
    //   44	48	50	java/io/FileNotFoundException
    //   48	50	50	java/io/FileNotFoundException
    //   59	63	50	java/io/FileNotFoundException
    //   44	48	66	java/lang/Throwable
  }
  
  /* Error */
  public static boolean b(File paramFile)
  {
    // Byte code:
    //   0: new 2	com/whatsapp/pj
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 201	com/whatsapp/pj:<init>	(Ljava/io/File;)V
    //   8: astore_3
    //   9: aconst_null
    //   10: astore_0
    //   11: aload_3
    //   12: invokespecial 152	com/whatsapp/pj:c	()Z
    //   15: istore_1
    //   16: iload_1
    //   17: ifne +11 -> 28
    //   20: iconst_1
    //   21: istore_1
    //   22: aload_3
    //   23: invokevirtual 196	com/whatsapp/pj:close	()V
    //   26: iload_1
    //   27: ireturn
    //   28: iconst_0
    //   29: istore_1
    //   30: goto -8 -> 22
    //   33: astore_2
    //   34: aload_2
    //   35: astore_0
    //   36: aload_2
    //   37: athrow
    //   38: astore_2
    //   39: aload_0
    //   40: ifnull +18 -> 58
    //   43: aload_3
    //   44: invokevirtual 196	com/whatsapp/pj:close	()V
    //   47: aload_2
    //   48: athrow
    //   49: astore_0
    //   50: ldc -50
    //   52: aload_0
    //   53: invokestatic 132	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   56: iconst_0
    //   57: ireturn
    //   58: aload_3
    //   59: invokevirtual 196	com/whatsapp/pj:close	()V
    //   62: goto -15 -> 47
    //   65: astore_0
    //   66: goto -19 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	paramFile	File
    //   15	15	1	bool	boolean
    //   33	4	2	localThrowable	Throwable
    //   38	10	2	localObject	Object
    //   8	51	3	localpj	pj
    // Exception table:
    //   from	to	target	type
    //   11	16	33	java/lang/Throwable
    //   11	16	38	finally
    //   36	38	38	finally
    //   0	9	49	java/io/FileNotFoundException
    //   22	26	49	java/io/FileNotFoundException
    //   43	47	49	java/io/FileNotFoundException
    //   47	49	49	java/io/FileNotFoundException
    //   58	62	49	java/io/FileNotFoundException
    //   43	47	65	java/lang/Throwable
  }
  
  private byte[] b()
  {
    this.r = i();
    this.s = i();
    this.t = i();
    this.u = i();
    int i1 = e();
    boolean bool;
    if ((i1 & 0x80) != 0)
    {
      bool = true;
      this.o = bool;
      this.q = ((int)Math.pow(2.0D, (i1 & 0x7) + 1));
      if ((i1 & 0x40) == 0) {
        break label317;
      }
      bool = true;
      label82:
      this.p = bool;
      if (!this.o) {
        break label323;
      }
      this.i = b(this.q);
      this.j = this.i;
    }
    int i13;
    int i17;
    int i18;
    int i19;
    int i7;
    int i2;
    int i3;
    for (;;)
    {
      i13 = 0;
      if (this.E)
      {
        i13 = this.j[this.G];
        this.j[this.G] = 0;
      }
      if (this.j == null) {
        this.b = 1;
      }
      if (c()) {
        break label1397;
      }
      i17 = this.t * this.u;
      if ((this.K == null) || (this.K.length < i17)) {
        this.K = new byte[i17];
      }
      if (this.H == null) {
        this.H = new short['က'];
      }
      if (this.I == null) {
        this.I = new byte['က'];
      }
      if (this.J == null) {
        this.J = new byte['ခ'];
      }
      i18 = e();
      i19 = 1 << i18;
      i7 = i19 + 2;
      i5 = -1;
      i2 = i18 + 1;
      i3 = (1 << i2) - 1;
      i1 = 0;
      while (i1 < i19)
      {
        this.H[i1] = 0;
        this.I[i1] = ((byte)i1);
        i1 += 1;
      }
      bool = false;
      break;
      label317:
      bool = false;
      break label82;
      label323:
      this.j = this.h;
      if (this.k == this.G) {
        this.l = 0;
      }
    }
    int i10 = 0;
    int i4 = 0;
    int i8 = 0;
    int i9 = 0;
    int i11 = 0;
    int i6 = 0;
    int i14 = 0;
    int i12 = 0;
    i1 = i5;
    int i5 = i9;
    int i15;
    int i16;
    while (i14 < i17)
    {
      if (i4 != 0) {
        break label1417;
      }
      if (i6 < i2)
      {
        i9 = i11;
        if (i11 == 0)
        {
          i9 = f();
          if (i9 > 0) {
            i12 = 0;
          }
        }
        else
        {
          i5 += ((this.A[i12] & 0xFF) << i6);
          i6 += 8;
          i12 += 1;
          i11 = i9 - 1;
        }
      }
      else
      {
        i9 = i5 & i3;
        i15 = i5 >> i2;
        i6 -= i2;
        if ((i9 <= i7) && (i9 != i19 + 1)) {
          if (i9 == i19)
          {
            i2 = i18 + 1;
            i3 = (1 << i2) - 1;
            i7 = i19 + 2;
            i1 = -1;
            i5 = i15;
          }
          else if (i1 == -1)
          {
            this.J[i4] = this.I[i9];
            i4 += 1;
            i1 = i9;
            i8 = i9;
            i5 = i15;
          }
          else
          {
            if (i9 != i7) {
              break label1410;
            }
            byte[] arrayOfByte = this.J;
            i16 = i4 + 1;
            arrayOfByte[i4] = ((byte)i8);
            i5 = i1;
            i4 = i16;
            label603:
            while (i5 > i19)
            {
              this.J[i4] = this.I[i5];
              i5 = this.H[i5];
              i4 += 1;
            }
            i16 = this.I[i5] & 0xFF;
            if (i7 < 4096)
            {
              this.J[i4] = ((byte)i16);
              this.H[i7] = ((short)i1);
              this.I[i7] = ((byte)i16);
              i8 = i7 + 1;
              i1 = i2;
              i5 = i3;
              if ((i8 & i3) == 0)
              {
                i1 = i2;
                i5 = i3;
                if (i8 < 4096)
                {
                  i1 = i2 + 1;
                  i5 = i3 + i8;
                }
              }
              i2 = i9;
              i7 = i5;
              i5 = i16;
              i9 = i4 + 1;
              i3 = i8;
              i4 = i7;
              i7 = i1;
              i1 = i15;
            }
          }
        }
      }
    }
    for (;;)
    {
      i9 -= 1;
      this.K[i10] = this.J[i9];
      i14 += 1;
      i15 = i10 + 1;
      i8 = i7;
      i10 = i9;
      i7 = i3;
      i9 = i2;
      i2 = i8;
      i3 = i4;
      i4 = i10;
      i8 = i5;
      i5 = i1;
      i1 = i9;
      i10 = i15;
      break;
      while (i10 < i17)
      {
        this.K[i10] = 0;
        i10 += 1;
      }
      j();
      if (!c())
      {
        this.M += 1;
        if (this.z == null) {
          this.z = new byte[this.c * 3 * this.d];
        }
        if (this.D == 0)
        {
          Arrays.fill(this.z, (byte)0);
          i5 = 1;
          i4 = 8;
          i6 = 0;
          i3 = 0;
          label932:
          if (i3 >= this.u) {
            break label1297;
          }
          if (!this.p) {
            break label1402;
          }
          i1 = i6;
          i2 = i4;
          i7 = i5;
          if (i6 >= this.u) {
            i7 = i5 + 1;
          }
          switch (i7)
          {
          default: 
            i2 = i4;
            i1 = i6;
            label1006:
            i6 = i1 + i2;
            i5 = i7;
          }
        }
      }
      for (;;)
      {
        i1 += this.s;
        if (i1 < this.d)
        {
          i8 = this.c * i1;
          i7 = i8 + this.r;
          i4 = this.t + i7;
          i1 = i4;
          if (this.c + i8 < i4) {
            i1 = this.c + i8;
          }
          i4 = i3 * this.t;
          i8 = a(i7);
          for (;;)
          {
            if (i7 < i1)
            {
              i9 = this.K[i4];
              i9 = this.j[(i9 & 0xFF)];
              if (i9 != 0) {
                a(this.z, i8, i9);
              }
              i8 += 1;
              i7 += 1;
              i4 += 1;
              continue;
              if (this.D != 2) {
                break;
              }
              i1 = 0;
              if (!this.E) {
                i1 = this.m;
              }
              i2 = 0;
              while (i2 < this.y)
              {
                i5 = (this.w + i2) * this.c + this.v;
                i6 = this.x;
                i4 = a(i5);
                i3 = i4;
                while (i3 < i5 + i6 - i5 + i4)
                {
                  a(this.z, i3, i1);
                  i3 += 1;
                }
                i2 += 1;
              }
              i1 = 4;
              i2 = i4;
              break label1006;
              i1 = 2;
              i2 = 4;
              break label1006;
              i1 = 1;
              i2 = 2;
              break label1006;
            }
          }
        }
        i3 += 1;
        i4 = i2;
        break label932;
        label1297:
        this.L.addElement(Integer.valueOf(this.F));
        if (this.E) {
          this.j[this.G] = i13;
        }
        this.D = this.C;
        this.v = this.r;
        this.w = this.s;
        this.x = this.t;
        this.y = this.u;
        this.m = this.l;
        this.C = 0;
        this.E = false;
        this.F = 0;
        this.i = null;
        label1397:
        return this.z;
        label1402:
        i1 = i3;
        i2 = i4;
      }
      label1410:
      i5 = i9;
      break label603;
      label1417:
      i15 = i8;
      i8 = i2;
      i9 = i4;
      i4 = i5;
      i2 = i1;
      i16 = i7;
      i5 = i15;
      i1 = i4;
      i7 = i8;
      i4 = i3;
      i3 = i16;
    }
  }
  
  /* Error */
  private int[] b(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iload_1
    //   3: iconst_3
    //   4: imul
    //   5: istore 4
    //   7: aconst_null
    //   8: astore 7
    //   10: iload 4
    //   12: newarray <illegal type>
    //   14: astore 8
    //   16: aload_0
    //   17: getfield 114	com/whatsapp/pj:a	Ljava/io/InputStream;
    //   20: aload 8
    //   22: invokevirtual 295	java/io/InputStream:read	([B)I
    //   25: istore_2
    //   26: aload_0
    //   27: aload_0
    //   28: getfield 78	com/whatsapp/pj:N	J
    //   31: iload 4
    //   33: i2l
    //   34: ladd
    //   35: putfield 78	com/whatsapp/pj:N	J
    //   38: iload_2
    //   39: iload 4
    //   41: if_icmpge +27 -> 68
    //   44: aload_0
    //   45: iconst_1
    //   46: putfield 142	com/whatsapp/pj:b	I
    //   49: aload 7
    //   51: astore 6
    //   53: aload 6
    //   55: areturn
    //   56: astore 6
    //   58: iconst_0
    //   59: istore_2
    //   60: aload 6
    //   62: invokevirtual 298	java/lang/Exception:printStackTrace	()V
    //   65: goto -27 -> 38
    //   68: sipush 256
    //   71: newarray <illegal type>
    //   73: astore 7
    //   75: iconst_0
    //   76: istore 4
    //   78: iload_3
    //   79: istore_2
    //   80: iload 4
    //   82: istore_3
    //   83: aload 7
    //   85: astore 6
    //   87: iload_2
    //   88: iload_1
    //   89: if_icmpge -36 -> 53
    //   92: iload_3
    //   93: iconst_1
    //   94: iadd
    //   95: istore 4
    //   97: aload 8
    //   99: iload_3
    //   100: baload
    //   101: istore 5
    //   103: iload 4
    //   105: iconst_1
    //   106: iadd
    //   107: istore_3
    //   108: aload 7
    //   110: iload_2
    //   111: iload 5
    //   113: sipush 255
    //   116: iand
    //   117: bipush 16
    //   119: ishl
    //   120: ldc_w 299
    //   123: ior
    //   124: aload 8
    //   126: iload 4
    //   128: baload
    //   129: sipush 255
    //   132: iand
    //   133: bipush 8
    //   135: ishl
    //   136: ior
    //   137: aload 8
    //   139: iload_3
    //   140: baload
    //   141: sipush 255
    //   144: iand
    //   145: ior
    //   146: iastore
    //   147: iload_2
    //   148: iconst_1
    //   149: iadd
    //   150: istore_2
    //   151: iload_3
    //   152: iconst_1
    //   153: iadd
    //   154: istore_3
    //   155: goto -72 -> 83
    //   158: astore 6
    //   160: goto -100 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	pj
    //   0	163	1	paramInt	int
    //   25	126	2	i1	int
    //   1	154	3	i2	int
    //   5	122	4	i3	int
    //   101	16	5	i4	int
    //   51	3	6	arrayOfInt1	int[]
    //   56	5	6	localException1	Exception
    //   85	1	6	arrayOfInt2	int[]
    //   158	1	6	localException2	Exception
    //   8	101	7	arrayOfInt3	int[]
    //   14	124	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   16	26	56	java/lang/Exception
    //   26	38	158	java/lang/Exception
  }
  
  private boolean c()
  {
    return this.b != 0;
  }
  
  private void d()
  {
    this.b = 0;
    this.M = 0;
    this.L = new Vector();
    this.h = null;
    this.i = null;
  }
  
  private int e()
  {
    this.N += 1L;
    try
    {
      int i1 = this.a.read();
      return i1;
    }
    catch (Exception localException)
    {
      this.b = 1;
    }
    return 0;
  }
  
  private int f()
  {
    this.B = e();
    int i2 = 0;
    int i1 = 0;
    if (this.B > 0) {
      try
      {
        while (i1 < this.B)
        {
          i2 = this.a.read(this.A, i1, this.B - i1);
          if (i2 == -1) {
            break;
          }
          i1 += i2;
        }
        this.N += i2;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i2 = i1;
        if (i1 < this.B)
        {
          this.b = 1;
          i2 = i1;
        }
      }
    }
    return i2;
  }
  
  private void g()
  {
    boolean bool = true;
    String str = "";
    int i1 = 0;
    while (i1 < 6)
    {
      str = str + (char)e();
      i1 += 1;
    }
    if (!str.startsWith("GIF"))
    {
      this.b = 1;
      return;
    }
    this.c = i();
    this.d = i();
    i1 = e();
    if ((i1 & 0x80) != 0) {}
    for (;;)
    {
      this.e = bool;
      this.f = (2 << (i1 & 0x7));
      this.k = e();
      this.n = e();
      if ((!this.e) || (c())) {
        break;
      }
      this.h = b(this.f);
      this.l = this.h[this.k];
      return;
      bool = false;
    }
  }
  
  private void h()
  {
    do
    {
      f();
      if (this.A[0] == 1) {
        this.g = (this.A[1] & 0xFF | (this.A[2] & 0xFF) << 8);
      }
    } while ((this.B > 0) && (!c()));
  }
  
  private int i()
  {
    this.N += 2L;
    return e() | e() << 8;
  }
  
  private void j()
  {
    do
    {
      f();
    } while ((this.B > 0) && (!c()));
  }
  
  public final void close()
  {
    try
    {
      this.a.close();
      return;
    }
    catch (IOException localIOException)
    {
      Log.d("failed to close Gif stream", localIOException);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/pj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */