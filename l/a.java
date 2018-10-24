package com.whatsapp.l;

public final class a
{
  /* Error */
  static int a(String paramString1, String paramString2, String paramString3, java.util.concurrent.atomic.AtomicLong paramAtomicLong)
  {
    // Byte code:
    //   0: new 19	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 21
    //   6: invokespecial 24	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: aload_2
    //   10: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: ldc 30
    //   15: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 39	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   28: new 41	android/net/Uri$Builder
    //   31: dup
    //   32: invokespecial 42	android/net/Uri$Builder:<init>	()V
    //   35: astore 7
    //   37: aload 7
    //   39: ldc 44
    //   41: invokevirtual 48	android/net/Uri$Builder:scheme	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   44: aload_0
    //   45: invokevirtual 51	android/net/Uri$Builder:encodedAuthority	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   48: ldc 53
    //   50: invokevirtual 56	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   53: ldc 58
    //   55: aload_2
    //   56: invokevirtual 62	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   59: pop
    //   60: new 64	java/net/URL
    //   63: dup
    //   64: aload 7
    //   66: invokevirtual 68	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   69: invokevirtual 71	android/net/Uri:toString	()Ljava/lang/String;
    //   72: invokespecial 72	java/net/URL:<init>	(Ljava/lang/String;)V
    //   75: astore_0
    //   76: invokestatic 78	android/os/SystemClock:elapsedRealtime	()J
    //   79: lstore 5
    //   81: invokestatic 83	com/whatsapp/i/a:a	()Lcom/whatsapp/i/a;
    //   84: pop
    //   85: aload_0
    //   86: aload_1
    //   87: ldc 85
    //   89: invokestatic 88	com/whatsapp/i/a:a	(Ljava/net/URL;Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/i/a$a;
    //   92: astore 7
    //   94: aconst_null
    //   95: astore_2
    //   96: aload_3
    //   97: invokestatic 78	android/os/SystemClock:elapsedRealtime	()J
    //   100: lload 5
    //   102: lsub
    //   103: invokevirtual 94	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   106: aload 7
    //   108: getfield 99	com/whatsapp/i/a$a:a	Ljavax/net/ssl/HttpsURLConnection;
    //   111: invokevirtual 105	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   114: istore 4
    //   116: aload 7
    //   118: invokevirtual 108	com/whatsapp/i/a$a:close	()V
    //   121: iload 4
    //   123: ireturn
    //   124: astore_0
    //   125: aload_0
    //   126: athrow
    //   127: astore_1
    //   128: aload_0
    //   129: astore_2
    //   130: aload_1
    //   131: astore_0
    //   132: aload_2
    //   133: ifnull +23 -> 156
    //   136: aload 7
    //   138: invokevirtual 108	com/whatsapp/i/a$a:close	()V
    //   141: aload_0
    //   142: athrow
    //   143: astore_0
    //   144: iconst_m1
    //   145: istore 4
    //   147: ldc 110
    //   149: aload_0
    //   150: invokestatic 114	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   153: iload 4
    //   155: ireturn
    //   156: aload 7
    //   158: invokevirtual 108	com/whatsapp/i/a$a:close	()V
    //   161: goto -20 -> 141
    //   164: astore_0
    //   165: iconst_m1
    //   166: istore 4
    //   168: ldc 116
    //   170: aload_0
    //   171: invokestatic 119	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   174: iload 4
    //   176: ireturn
    //   177: astore_1
    //   178: goto -37 -> 141
    //   181: astore_0
    //   182: goto -14 -> 168
    //   185: astore_0
    //   186: goto -39 -> 147
    //   189: astore_0
    //   190: goto -58 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramString1	String
    //   0	193	1	paramString2	String
    //   0	193	2	paramString3	String
    //   0	193	3	paramAtomicLong	java.util.concurrent.atomic.AtomicLong
    //   114	61	4	i	int
    //   79	22	5	l	long
    //   35	122	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   96	116	124	java/lang/Throwable
    //   125	127	127	finally
    //   28	94	143	java/net/MalformedURLException
    //   136	141	143	java/net/MalformedURLException
    //   141	143	143	java/net/MalformedURLException
    //   156	161	143	java/net/MalformedURLException
    //   28	94	164	java/io/IOException
    //   136	141	164	java/io/IOException
    //   141	143	164	java/io/IOException
    //   156	161	164	java/io/IOException
    //   136	141	177	java/lang/Throwable
    //   116	121	181	java/io/IOException
    //   116	121	185	java/net/MalformedURLException
    //   96	116	189	finally
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/l/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */