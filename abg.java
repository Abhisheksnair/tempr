package com.whatsapp;

import android.os.AsyncTask;
import com.whatsapp.gif_search.h.d;
import java.io.File;

public final class abg
  extends AsyncTask<String, String, File>
{
  private final String a;
  private final String b;
  private final h.d c;
  private final va d;
  private final oz e;
  
  public abg(va paramva, oz paramoz, String paramString1, String paramString2, h.d paramd)
  {
    this.d = paramva;
    this.e = paramoz;
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramd;
  }
  
  /* Error */
  private File a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 37	java/net/URL
    //   5: dup
    //   6: aload_0
    //   7: getfield 25	com/whatsapp/abg:a	Ljava/lang/String;
    //   10: invokespecial 40	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: invokevirtual 44	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   18: invokevirtual 49	java/net/URLConnection:connect	()V
    //   21: new 51	java/io/BufferedInputStream
    //   24: dup
    //   25: aload_2
    //   26: invokevirtual 55	java/net/URL:openStream	()Ljava/io/InputStream;
    //   29: invokespecial 58	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   32: astore 5
    //   34: aload_0
    //   35: getfield 23	com/whatsapp/abg:e	Lcom/whatsapp/oz;
    //   38: astore_3
    //   39: new 60	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   46: aload_0
    //   47: getfield 21	com/whatsapp/abg:d	Lcom/whatsapp/va;
    //   50: invokestatic 66	com/whatsapp/util/MediaFileUtils:a	(Lcom/whatsapp/va;)Ljava/lang/String;
    //   53: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: astore 4
    //   58: aload_0
    //   59: getfield 27	com/whatsapp/abg:b	Ljava/lang/String;
    //   62: astore_2
    //   63: aload_2
    //   64: invokevirtual 76	java/lang/String:hashCode	()I
    //   67: lookupswitch	default:+246->313, -879267568:+94->161, 1331848029:+82->149
    //   92: new 78	java/lang/IllegalStateException
    //   95: dup
    //   96: new 60	java/lang/StringBuilder
    //   99: dup
    //   100: ldc 80
    //   102: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: aload_2
    //   106: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 83
    //   111: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokespecial 88	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   120: athrow
    //   121: astore_2
    //   122: aload_2
    //   123: athrow
    //   124: astore_3
    //   125: aload_2
    //   126: astore 4
    //   128: aload_3
    //   129: astore_2
    //   130: aload 4
    //   132: ifnull +158 -> 290
    //   135: aload 5
    //   137: invokevirtual 93	java/io/InputStream:close	()V
    //   140: aload_2
    //   141: athrow
    //   142: astore_2
    //   143: aload_2
    //   144: invokestatic 98	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   147: aconst_null
    //   148: areturn
    //   149: aload_2
    //   150: ldc 100
    //   152: invokevirtual 104	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   155: ifeq +158 -> 313
    //   158: goto +157 -> 315
    //   161: aload_2
    //   162: ldc 106
    //   164: invokevirtual 104	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   167: ifeq +146 -> 313
    //   170: iconst_1
    //   171: istore_1
    //   172: goto +143 -> 315
    //   175: aload_3
    //   176: aload 4
    //   178: aload_2
    //   179: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokevirtual 111	com/whatsapp/oz:a	(Ljava/lang/String;)Ljava/io/File;
    //   188: astore_2
    //   189: new 113	java/io/FileOutputStream
    //   192: dup
    //   193: aload_2
    //   194: invokevirtual 118	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   197: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   200: astore 6
    //   202: sipush 1024
    //   205: newarray <illegal type>
    //   207: astore_3
    //   208: aload 5
    //   210: aload_3
    //   211: invokevirtual 123	java/io/InputStream:read	([B)I
    //   214: istore_1
    //   215: iload_1
    //   216: iconst_m1
    //   217: if_icmpeq +27 -> 244
    //   220: aload 6
    //   222: aload_3
    //   223: iconst_0
    //   224: iload_1
    //   225: invokevirtual 129	java/io/OutputStream:write	([BII)V
    //   228: aload 5
    //   230: aload_3
    //   231: invokevirtual 123	java/io/InputStream:read	([B)I
    //   234: istore_1
    //   235: goto -20 -> 215
    //   238: ldc -125
    //   240: astore_2
    //   241: goto -66 -> 175
    //   244: aload 6
    //   246: invokevirtual 134	java/io/OutputStream:flush	()V
    //   249: aload 6
    //   251: invokevirtual 135	java/io/OutputStream:close	()V
    //   254: aload 5
    //   256: invokevirtual 93	java/io/InputStream:close	()V
    //   259: aload_2
    //   260: areturn
    //   261: astore_2
    //   262: aload_2
    //   263: athrow
    //   264: astore_3
    //   265: aload_2
    //   266: astore 4
    //   268: aload_3
    //   269: astore_2
    //   270: aload 4
    //   272: ifnull +10 -> 282
    //   275: aload 6
    //   277: invokevirtual 135	java/io/OutputStream:close	()V
    //   280: aload_2
    //   281: athrow
    //   282: aload 6
    //   284: invokevirtual 135	java/io/OutputStream:close	()V
    //   287: goto -7 -> 280
    //   290: aload 5
    //   292: invokevirtual 93	java/io/InputStream:close	()V
    //   295: goto -155 -> 140
    //   298: astore_3
    //   299: goto -19 -> 280
    //   302: astore_3
    //   303: goto -163 -> 140
    //   306: astore_2
    //   307: aconst_null
    //   308: astore 4
    //   310: goto -40 -> 270
    //   313: iconst_m1
    //   314: istore_1
    //   315: iload_1
    //   316: tableswitch	default:+24->340, 0:+27->343, 1:+-78->238
    //   340: goto -248 -> 92
    //   343: ldc -119
    //   345: astore_2
    //   346: goto -171 -> 175
    //   349: astore_2
    //   350: aconst_null
    //   351: astore 4
    //   353: goto -223 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	this	abg
    //   1	315	1	i	int
    //   13	93	2	localObject1	Object
    //   121	5	2	localThrowable1	Throwable
    //   129	12	2	localObject2	Object
    //   142	37	2	localIOException	java.io.IOException
    //   188	72	2	localObject3	Object
    //   261	5	2	localThrowable2	Throwable
    //   269	12	2	localObject4	Object
    //   306	1	2	localObject5	Object
    //   345	1	2	str	String
    //   349	1	2	localObject6	Object
    //   38	1	3	localoz	oz
    //   124	52	3	localObject7	Object
    //   207	24	3	arrayOfByte	byte[]
    //   264	5	3	localObject8	Object
    //   298	1	3	localThrowable3	Throwable
    //   302	1	3	localThrowable4	Throwable
    //   56	296	4	localObject9	Object
    //   32	259	5	localBufferedInputStream	java.io.BufferedInputStream
    //   200	83	6	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   34	92	121	java/lang/Throwable
    //   92	121	121	java/lang/Throwable
    //   149	158	121	java/lang/Throwable
    //   161	170	121	java/lang/Throwable
    //   175	202	121	java/lang/Throwable
    //   249	254	121	java/lang/Throwable
    //   280	282	121	java/lang/Throwable
    //   282	287	121	java/lang/Throwable
    //   122	124	124	finally
    //   2	34	142	java/io/IOException
    //   135	140	142	java/io/IOException
    //   140	142	142	java/io/IOException
    //   254	259	142	java/io/IOException
    //   290	295	142	java/io/IOException
    //   202	215	261	java/lang/Throwable
    //   220	235	261	java/lang/Throwable
    //   244	249	261	java/lang/Throwable
    //   262	264	264	finally
    //   275	280	298	java/lang/Throwable
    //   135	140	302	java/lang/Throwable
    //   202	215	306	finally
    //   220	235	306	finally
    //   244	249	306	finally
    //   34	92	349	finally
    //   92	121	349	finally
    //   149	158	349	finally
    //   161	170	349	finally
    //   175	202	349	finally
    //   249	254	349	finally
    //   275	280	349	finally
    //   280	282	349	finally
    //   282	287	349	finally
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/abg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */