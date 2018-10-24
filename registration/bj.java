package com.whatsapp.registration;

import android.util.Base64;
import java.util.Arrays;

public final class bj
{
  private static final byte[] a = Base64.decode("PkTwKSZqUfAUyR0rPQ8hYJ0wNsQQ3dW1+3SCnyTXIfEAxxS75FwkDf47wNv/c8pP3p0GXKR6OOQmhyERwx74fw1RYSU10I4r1gyBVDbRJ40pidjM41G1I1oN", 0);
  private final byte[] b;
  private boolean c;
  private int d;
  
  private bj(byte[] paramArrayOfByte)
  {
    this.b = paramArrayOfByte;
  }
  
  /* Error */
  public static bj a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: invokestatic 45	com/whatsapp/av:j	()Z
    //   5: ifeq +15 -> 20
    //   8: new 2	com/whatsapp/registration/bj
    //   11: dup
    //   12: bipush 20
    //   14: newarray <illegal type>
    //   16: invokespecial 47	com/whatsapp/registration/bj:<init>	([B)V
    //   19: areturn
    //   20: new 49	java/io/ByteArrayOutputStream
    //   23: dup
    //   24: invokespecial 50	java/io/ByteArrayOutputStream:<init>	()V
    //   27: astore 7
    //   29: aload_0
    //   30: invokevirtual 56	android/content/Context:getPackageName	()Ljava/lang/String;
    //   33: astore 5
    //   35: aload 5
    //   37: ifnull +13 -> 50
    //   40: ldc 58
    //   42: aload 5
    //   44: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   47: ifne +11 -> 58
    //   50: new 66	java/lang/AssertionError
    //   53: dup
    //   54: invokespecial 67	java/lang/AssertionError:<init>	()V
    //   57: athrow
    //   58: aload 7
    //   60: aload 5
    //   62: ldc 69
    //   64: invokevirtual 73	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   67: invokevirtual 76	java/io/ByteArrayOutputStream:write	([B)V
    //   70: ldc 2
    //   72: ldc 78
    //   74: invokevirtual 84	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   77: astore 6
    //   79: aload 6
    //   81: astore 5
    //   83: aload 6
    //   85: ifnonnull +12 -> 97
    //   88: ldc 2
    //   90: ldc 86
    //   92: invokevirtual 84	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   95: astore 5
    //   97: aload 5
    //   99: astore 6
    //   101: aload 5
    //   103: ifnonnull +106 -> 209
    //   106: aload 5
    //   108: astore 6
    //   110: invokestatic 88	com/whatsapp/av:d	()Z
    //   113: ifne +96 -> 209
    //   116: aload_0
    //   117: invokevirtual 92	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   120: astore 5
    //   122: new 94	android/util/DisplayMetrics
    //   125: dup
    //   126: invokespecial 95	android/util/DisplayMetrics:<init>	()V
    //   129: astore 6
    //   131: aload 6
    //   133: invokevirtual 98	android/util/DisplayMetrics:setToDefaults	()V
    //   136: aload 6
    //   138: ldc 99
    //   140: putfield 103	android/util/DisplayMetrics:density	F
    //   143: aload 6
    //   145: sipush 240
    //   148: putfield 106	android/util/DisplayMetrics:densityDpi	I
    //   151: aload 6
    //   153: aload 6
    //   155: getfield 103	android/util/DisplayMetrics:density	F
    //   158: putfield 109	android/util/DisplayMetrics:scaledDensity	F
    //   161: aload 6
    //   163: aload 6
    //   165: getfield 106	android/util/DisplayMetrics:densityDpi	I
    //   168: i2f
    //   169: putfield 112	android/util/DisplayMetrics:xdpi	F
    //   172: aload 6
    //   174: aload 6
    //   176: getfield 106	android/util/DisplayMetrics:densityDpi	I
    //   179: i2f
    //   180: putfield 115	android/util/DisplayMetrics:ydpi	F
    //   183: new 117	android/content/res/Resources
    //   186: dup
    //   187: aload 5
    //   189: invokevirtual 121	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   192: aload 6
    //   194: aload 5
    //   196: invokevirtual 125	android/content/res/Resources:getConfiguration	()Landroid/content/res/Configuration;
    //   199: invokespecial 128	android/content/res/Resources:<init>	(Landroid/content/res/AssetManager;Landroid/util/DisplayMetrics;Landroid/content/res/Configuration;)V
    //   202: ldc -127
    //   204: invokevirtual 133	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   207: astore 6
    //   209: aload 6
    //   211: ifnonnull +295 -> 506
    //   214: invokestatic 88	com/whatsapp/av:d	()Z
    //   217: ifeq +289 -> 506
    //   220: aload_0
    //   221: invokevirtual 134	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   224: ldc -120
    //   226: invokevirtual 141	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   229: astore 5
    //   231: aload 5
    //   233: ifnonnull +31 -> 264
    //   236: new 66	java/lang/AssertionError
    //   239: dup
    //   240: invokespecial 67	java/lang/AssertionError:<init>	()V
    //   243: athrow
    //   244: astore_0
    //   245: new 143	java/lang/Error
    //   248: dup
    //   249: aload_0
    //   250: invokespecial 146	java/lang/Error:<init>	(Ljava/lang/Throwable;)V
    //   253: athrow
    //   254: astore_0
    //   255: new 66	java/lang/AssertionError
    //   258: dup
    //   259: aload_0
    //   260: invokespecial 149	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   263: athrow
    //   264: sipush 8192
    //   267: newarray <illegal type>
    //   269: astore 6
    //   271: aload 5
    //   273: aload 6
    //   275: invokevirtual 155	java/io/InputStream:read	([B)I
    //   278: istore_2
    //   279: iload_2
    //   280: iconst_m1
    //   281: if_icmpeq +23 -> 304
    //   284: aload 7
    //   286: aload 6
    //   288: iconst_0
    //   289: iload_2
    //   290: invokevirtual 158	java/io/ByteArrayOutputStream:write	([BII)V
    //   293: aload 5
    //   295: aload 6
    //   297: invokevirtual 155	java/io/InputStream:read	([B)I
    //   300: istore_2
    //   301: goto -22 -> 279
    //   304: aload 5
    //   306: invokevirtual 161	java/io/InputStream:close	()V
    //   309: aload 7
    //   311: invokevirtual 165	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   314: getstatic 23	com/whatsapp/registration/bj:a	[B
    //   317: sipush 128
    //   320: sipush 512
    //   323: invokestatic 170	com/whatsapp/r:a	([B[BII)Ljavax/crypto/SecretKey;
    //   326: astore 6
    //   328: ldc -84
    //   330: invokestatic 178	javax/crypto/Mac:getInstance	(Ljava/lang/String;)Ljavax/crypto/Mac;
    //   333: astore 5
    //   335: aload 5
    //   337: aload 6
    //   339: invokevirtual 182	javax/crypto/Mac:init	(Ljava/security/Key;)V
    //   342: aload_0
    //   343: invokestatic 187	a/a/a/a/d:j	(Landroid/content/Context;)[Landroid/content/pm/Signature;
    //   346: astore 6
    //   348: aload 6
    //   350: ifnull +9 -> 359
    //   353: aload 6
    //   355: arraylength
    //   356: ifne +48 -> 404
    //   359: new 66	java/lang/AssertionError
    //   362: dup
    //   363: invokespecial 67	java/lang/AssertionError:<init>	()V
    //   366: athrow
    //   367: astore_0
    //   368: new 66	java/lang/AssertionError
    //   371: dup
    //   372: invokespecial 67	java/lang/AssertionError:<init>	()V
    //   375: athrow
    //   376: astore_0
    //   377: aload 5
    //   379: invokevirtual 161	java/io/InputStream:close	()V
    //   382: aload_0
    //   383: athrow
    //   384: astore_0
    //   385: new 66	java/lang/AssertionError
    //   388: dup
    //   389: aload_0
    //   390: invokespecial 149	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   393: athrow
    //   394: astore_0
    //   395: new 66	java/lang/AssertionError
    //   398: dup
    //   399: aload_0
    //   400: invokespecial 149	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   403: athrow
    //   404: aload 6
    //   406: arraylength
    //   407: istore 4
    //   409: iload_3
    //   410: istore_2
    //   411: iload_2
    //   412: iload 4
    //   414: if_icmpge +22 -> 436
    //   417: aload 5
    //   419: aload 6
    //   421: iload_2
    //   422: aaload
    //   423: invokevirtual 190	android/content/pm/Signature:toByteArray	()[B
    //   426: invokevirtual 193	javax/crypto/Mac:update	([B)V
    //   429: iload_2
    //   430: iconst_1
    //   431: iadd
    //   432: istore_2
    //   433: goto -22 -> 411
    //   436: invokestatic 88	com/whatsapp/av:d	()Z
    //   439: ifeq +40 -> 479
    //   442: bipush 16
    //   444: newarray <illegal type>
    //   446: astore_0
    //   447: aload 5
    //   449: aload_0
    //   450: invokevirtual 193	javax/crypto/Mac:update	([B)V
    //   453: aload_1
    //   454: ldc 69
    //   456: invokevirtual 73	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   459: astore_0
    //   460: aload 5
    //   462: aload_0
    //   463: invokevirtual 193	javax/crypto/Mac:update	([B)V
    //   466: new 2	com/whatsapp/registration/bj
    //   469: dup
    //   470: aload 5
    //   472: invokevirtual 196	javax/crypto/Mac:doFinal	()[B
    //   475: invokespecial 47	com/whatsapp/registration/bj:<init>	([B)V
    //   478: areturn
    //   479: aload_0
    //   480: invokestatic 199	com/whatsapp/r:a	(Landroid/content/Context;)[B
    //   483: astore_0
    //   484: goto -37 -> 447
    //   487: astore_0
    //   488: new 66	java/lang/AssertionError
    //   491: dup
    //   492: aload_0
    //   493: invokespecial 149	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   496: athrow
    //   497: astore 5
    //   499: goto -190 -> 309
    //   502: astore_1
    //   503: goto -121 -> 382
    //   506: aload 6
    //   508: astore 5
    //   510: goto -279 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	513	0	paramContext	android.content.Context
    //   0	513	1	paramString	String
    //   278	155	2	i	int
    //   1	409	3	j	int
    //   407	8	4	k	int
    //   33	438	5	localObject1	Object
    //   497	1	5	localIOException	java.io.IOException
    //   508	1	5	localObject2	Object
    //   77	430	6	localObject3	Object
    //   27	283	7	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   58	70	244	java/io/IOException
    //   220	231	254	java/io/IOException
    //   271	279	367	java/io/IOException
    //   284	301	367	java/io/IOException
    //   271	279	376	finally
    //   284	301	376	finally
    //   368	376	376	finally
    //   328	335	384	java/security/NoSuchAlgorithmException
    //   335	342	394	java/security/InvalidKeyException
    //   453	460	487	java/io/UnsupportedEncodingException
    //   304	309	497	java/io/IOException
    //   377	382	502	java/io/IOException
  }
  
  public final boolean equals(Object paramObject)
  {
    return (this == paramObject) || ((paramObject != null) && (getClass().equals(paramObject.getClass())) && (Arrays.equals(this.b, ((bj)paramObject).b)));
  }
  
  public final int hashCode()
  {
    if (this.c) {
      return this.d;
    }
    this.d = Arrays.hashCode(this.b);
    this.c = true;
    return this.d;
  }
  
  public final String toString()
  {
    return Base64.encodeToString(this.b, 2);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/registration/bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */