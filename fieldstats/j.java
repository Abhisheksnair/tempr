package com.whatsapp.fieldstats;

import com.whatsapp.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class j
{
  private static final byte[] d = { 87, 65, 77, 3 };
  private static final byte[] e = { 87, 65, 77, 3 };
  boolean a = true;
  boolean b = false;
  final d c = new d((byte)0);
  private final File f;
  private final RandomAccessFile g;
  private final b h;
  private final a[] i = new a[2];
  
  public j(File paramFile)
  {
    Log.d("wambuffer/wambuffer: " + paramFile.getAbsolutePath());
    boolean bool = paramFile.isFile();
    try
    {
      RandomAccessFile localRandomAccessFile1 = new RandomAccessFile(paramFile, "rwd");
      this.a = true;
      this.f = paramFile;
      this.g = localRandomAccessFile1;
      this.h = new b(localRandomAccessFile1, this.c);
      while (j < this.i.length)
      {
        this.i[j] = new a(localRandomAccessFile1, j, this.c);
        j += 1;
      }
    }
    catch (IOException localIOException)
    {
      RandomAccessFile localRandomAccessFile2;
      for (;;)
      {
        localRandomAccessFile2 = null;
        k.a().j = Boolean.valueOf(true);
        if (!bool) {
          k.a().c();
        }
        Log.e("wambuffer/newwamfile: cannot open or create persistent WAM file; running in volatile mode");
        j();
      }
      if (localRandomAccessFile2 == null) {
        return;
      }
      if (bool) {
        try
        {
          i();
          return;
        }
        catch (c paramFile)
        {
          try
          {
            k();
            Log.e("wambuffer/wambuffer: error while opening WAM file (" + paramFile + ")");
            k.a().m = Boolean.valueOf(true);
            a(localRandomAccessFile2);
            return;
          }
          catch (c paramFile)
          {
            Log.e("wambuffer/wambuffer: failed to initialize with new file (" + paramFile + ")");
            j();
            k.a().c();
            if (this.g == null) {}
          }
        }
      }
      try
      {
        this.g.close();
        if (this.f.delete())
        {
          Log.i("wambuffer/removefile: successfully removed WAM file");
          return;
          Log.i("wambuffer/wambuffer: no WAM file found; creating a new one");
          a(localRandomAccessFile2);
          return;
        }
      }
      catch (IOException paramFile)
      {
        for (;;)
        {
          k.a().k = Boolean.valueOf(true);
          Log.e("wambuffer/closefile: cannot close WAM file");
        }
        k.a().l = Boolean.valueOf(true);
        Log.e("wambuffer/removefile: cannot remove WAM file");
      }
    }
  }
  
  /* Error */
  private void a(RandomAccessFile paramRandomAccessFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc2_w 176
    //   4: invokevirtual 181	java/io/RandomAccessFile:setLength	(J)V
    //   7: aload_0
    //   8: getfield 106	com/whatsapp/fieldstats/j:h	Lcom/whatsapp/fieldstats/j$b;
    //   11: invokevirtual 183	com/whatsapp/fieldstats/j$b:a	()V
    //   14: ldc -71
    //   16: invokestatic 164	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   19: return
    //   20: astore_1
    //   21: invokestatic 114	com/whatsapp/fieldstats/k:a	()Lcom/whatsapp/fieldstats/k;
    //   24: invokevirtual 187	com/whatsapp/fieldstats/k:b	()V
    //   27: new 16	com/whatsapp/fieldstats/j$c
    //   30: dup
    //   31: new 64	java/lang/StringBuilder
    //   34: dup
    //   35: ldc -67
    //   37: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload_1
    //   41: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokespecial 190	com/whatsapp/fieldstats/j$c:<init>	(Ljava/lang/String;)V
    //   50: athrow
    //   51: astore_1
    //   52: new 16	com/whatsapp/fieldstats/j$c
    //   55: dup
    //   56: aload_1
    //   57: invokevirtual 191	java/io/IOException:toString	()Ljava/lang/String;
    //   60: invokespecial 190	com/whatsapp/fieldstats/j$c:<init>	(Ljava/lang/String;)V
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	j
    //   0	64	1	paramRandomAccessFile	RandomAccessFile
    // Exception table:
    //   from	to	target	type
    //   0	7	20	java/io/IOException
    //   7	14	51	java/io/IOException
  }
  
  /* Error */
  private void i()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 106	com/whatsapp/fieldstats/j:h	Lcom/whatsapp/fieldstats/j$b;
    //   4: astore 6
    //   6: aload 6
    //   8: getfield 195	com/whatsapp/fieldstats/j$b:f	Lcom/whatsapp/fieldstats/h;
    //   11: aload 6
    //   13: getfield 198	com/whatsapp/fieldstats/j$b:g	I
    //   16: invokevirtual 203	com/whatsapp/fieldstats/h:b	(I)Lcom/whatsapp/fieldstats/h;
    //   19: pop
    //   20: aload 6
    //   22: getfield 195	com/whatsapp/fieldstats/j$b:f	Lcom/whatsapp/fieldstats/h;
    //   25: invokevirtual 206	com/whatsapp/fieldstats/h:b	()Ljava/nio/ByteBuffer;
    //   28: astore 7
    //   30: aload 6
    //   32: getstatic 42	com/whatsapp/fieldstats/j:d	[B
    //   35: arraylength
    //   36: newarray <illegal type>
    //   38: putfield 208	com/whatsapp/fieldstats/j$b:a	[B
    //   41: aload 7
    //   43: aload 6
    //   45: getfield 208	com/whatsapp/fieldstats/j$b:a	[B
    //   48: invokevirtual 214	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   51: pop
    //   52: aload 6
    //   54: aload 7
    //   56: invokestatic 217	com/whatsapp/fieldstats/j$b:a	(Ljava/nio/ByteBuffer;)I
    //   59: putfield 219	com/whatsapp/fieldstats/j$b:b	I
    //   62: aload 6
    //   64: aload 7
    //   66: invokestatic 217	com/whatsapp/fieldstats/j$b:a	(Ljava/nio/ByteBuffer;)I
    //   69: putfield 221	com/whatsapp/fieldstats/j$b:c	I
    //   72: aload 6
    //   74: getfield 223	com/whatsapp/fieldstats/j$b:d	Lcom/whatsapp/fieldstats/j$d;
    //   77: aload 7
    //   79: invokestatic 217	com/whatsapp/fieldstats/j$b:a	(Ljava/nio/ByteBuffer;)I
    //   82: putfield 225	com/whatsapp/fieldstats/j$d:a	I
    //   85: aload 6
    //   87: getfield 223	com/whatsapp/fieldstats/j$b:d	Lcom/whatsapp/fieldstats/j$d;
    //   90: getfield 228	com/whatsapp/fieldstats/j$d:b	[Lcom/whatsapp/fieldstats/j$d$a;
    //   93: astore 8
    //   95: aload 8
    //   97: arraylength
    //   98: istore_2
    //   99: iconst_0
    //   100: istore_1
    //   101: iload_1
    //   102: iload_2
    //   103: if_icmpge +76 -> 179
    //   106: aload 8
    //   108: iload_1
    //   109: aaload
    //   110: astore 9
    //   112: aload 9
    //   114: aload 7
    //   116: invokestatic 217	com/whatsapp/fieldstats/j$b:a	(Ljava/nio/ByteBuffer;)I
    //   119: putfield 229	com/whatsapp/fieldstats/j$d$a:a	I
    //   122: aload 9
    //   124: aload 7
    //   126: invokestatic 232	com/whatsapp/fieldstats/j$b:b	(Ljava/nio/ByteBuffer;)J
    //   129: putfield 235	com/whatsapp/fieldstats/j$d$a:b	J
    //   132: aload 9
    //   134: aload 7
    //   136: invokestatic 232	com/whatsapp/fieldstats/j$b:b	(Ljava/nio/ByteBuffer;)J
    //   139: putfield 237	com/whatsapp/fieldstats/j$d$a:c	J
    //   142: iload_1
    //   143: iconst_1
    //   144: iadd
    //   145: istore_1
    //   146: goto -45 -> 101
    //   149: astore 6
    //   151: new 14	com/whatsapp/fieldstats/j$b$a
    //   154: dup
    //   155: aload 6
    //   157: invokevirtual 191	java/io/IOException:toString	()Ljava/lang/String;
    //   160: invokespecial 238	com/whatsapp/fieldstats/j$b$a:<init>	(Ljava/lang/String;)V
    //   163: athrow
    //   164: astore 6
    //   166: new 16	com/whatsapp/fieldstats/j$c
    //   169: dup
    //   170: aload 6
    //   172: invokevirtual 239	com/whatsapp/fieldstats/j$b$a:toString	()Ljava/lang/String;
    //   175: invokespecial 190	com/whatsapp/fieldstats/j$c:<init>	(Ljava/lang/String;)V
    //   178: athrow
    //   179: aload 6
    //   181: aload 7
    //   183: invokestatic 232	com/whatsapp/fieldstats/j$b:b	(Ljava/nio/ByteBuffer;)J
    //   186: putfield 241	com/whatsapp/fieldstats/j$b:e	J
    //   189: aload 6
    //   191: getfield 195	com/whatsapp/fieldstats/j$b:f	Lcom/whatsapp/fieldstats/h;
    //   194: astore 7
    //   196: aload 6
    //   198: getfield 198	com/whatsapp/fieldstats/j$b:g	I
    //   201: iconst_4
    //   202: isub
    //   203: istore_1
    //   204: iload_1
    //   205: aload 7
    //   207: getfield 244	com/whatsapp/fieldstats/h:b	Ljava/nio/ByteBuffer;
    //   210: invokevirtual 248	java/nio/ByteBuffer:position	()I
    //   213: if_icmple +13 -> 226
    //   216: new 250	java/lang/IllegalArgumentException
    //   219: dup
    //   220: ldc -4
    //   222: invokespecial 253	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   225: athrow
    //   226: new 255	java/util/zip/Adler32
    //   229: dup
    //   230: invokespecial 256	java/util/zip/Adler32:<init>	()V
    //   233: astore 8
    //   235: aload 8
    //   237: aload 7
    //   239: getfield 244	com/whatsapp/fieldstats/h:b	Ljava/nio/ByteBuffer;
    //   242: invokevirtual 259	java/nio/ByteBuffer:array	()[B
    //   245: iconst_0
    //   246: iload_1
    //   247: invokeinterface 265 4 0
    //   252: aload 8
    //   254: invokeinterface 269 1 0
    //   259: lstore_3
    //   260: aload 6
    //   262: getfield 241	com/whatsapp/fieldstats/j$b:e	J
    //   265: lload_3
    //   266: lcmp
    //   267: ifeq +24 -> 291
    //   270: invokestatic 114	com/whatsapp/fieldstats/k:a	()Lcom/whatsapp/fieldstats/k;
    //   273: iconst_1
    //   274: invokestatic 120	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   277: putfield 272	com/whatsapp/fieldstats/events/bw:q	Ljava/lang/Boolean;
    //   280: new 14	com/whatsapp/fieldstats/j$b$a
    //   283: dup
    //   284: ldc_w 274
    //   287: invokespecial 238	com/whatsapp/fieldstats/j$b$a:<init>	(Ljava/lang/String;)V
    //   290: athrow
    //   291: aload 6
    //   293: invokevirtual 275	com/whatsapp/fieldstats/j$b:b	()V
    //   296: iconst_0
    //   297: istore_1
    //   298: iload_1
    //   299: aload_0
    //   300: getfield 57	com/whatsapp/fieldstats/j:i	[Lcom/whatsapp/fieldstats/j$a;
    //   303: arraylength
    //   304: if_icmpge +292 -> 596
    //   307: aload_0
    //   308: getfield 62	com/whatsapp/fieldstats/j:c	Lcom/whatsapp/fieldstats/j$d;
    //   311: getfield 228	com/whatsapp/fieldstats/j$d:b	[Lcom/whatsapp/fieldstats/j$d$a;
    //   314: iload_1
    //   315: aaload
    //   316: astore 6
    //   318: aload_0
    //   319: getfield 57	com/whatsapp/fieldstats/j:i	[Lcom/whatsapp/fieldstats/j$a;
    //   322: iload_1
    //   323: aaload
    //   324: astore 7
    //   326: aload 7
    //   328: getfield 277	com/whatsapp/fieldstats/j$a:a	Lcom/whatsapp/fieldstats/h;
    //   331: aload 7
    //   333: invokevirtual 280	com/whatsapp/fieldstats/j$a:b	()Lcom/whatsapp/fieldstats/j$d$a;
    //   336: getfield 229	com/whatsapp/fieldstats/j$d$a:a	I
    //   339: invokevirtual 203	com/whatsapp/fieldstats/h:b	(I)Lcom/whatsapp/fieldstats/h;
    //   342: pop
    //   343: aload 7
    //   345: getfield 277	com/whatsapp/fieldstats/j$a:a	Lcom/whatsapp/fieldstats/h;
    //   348: getfield 244	com/whatsapp/fieldstats/h:b	Ljava/nio/ByteBuffer;
    //   351: invokevirtual 248	java/nio/ByteBuffer:position	()I
    //   354: aload 7
    //   356: invokevirtual 280	com/whatsapp/fieldstats/j$a:b	()Lcom/whatsapp/fieldstats/j$d$a;
    //   359: getfield 229	com/whatsapp/fieldstats/j$d$a:a	I
    //   362: if_icmpne +407 -> 769
    //   365: iconst_1
    //   366: istore 5
    //   368: iload 5
    //   370: invokestatic 283	com/whatsapp/util/Log:a	(Z)V
    //   373: aload 7
    //   375: getfield 277	com/whatsapp/fieldstats/j$a:a	Lcom/whatsapp/fieldstats/h;
    //   378: getfield 284	com/whatsapp/fieldstats/h:a	I
    //   381: aload 7
    //   383: invokevirtual 280	com/whatsapp/fieldstats/j$a:b	()Lcom/whatsapp/fieldstats/j$d$a;
    //   386: getfield 229	com/whatsapp/fieldstats/j$d$a:a	I
    //   389: if_icmpne +386 -> 775
    //   392: iconst_1
    //   393: istore 5
    //   395: iload 5
    //   397: invokestatic 283	com/whatsapp/util/Log:a	(Z)V
    //   400: aload 7
    //   402: getfield 277	com/whatsapp/fieldstats/j$a:a	Lcom/whatsapp/fieldstats/h;
    //   405: invokevirtual 286	com/whatsapp/fieldstats/h:a	()J
    //   408: aload 7
    //   410: invokevirtual 280	com/whatsapp/fieldstats/j$a:b	()Lcom/whatsapp/fieldstats/j$d$a;
    //   413: getfield 237	com/whatsapp/fieldstats/j$d$a:c	J
    //   416: lcmp
    //   417: ifeq +90 -> 507
    //   420: aload 7
    //   422: invokevirtual 288	com/whatsapp/fieldstats/j$a:a	()Z
    //   425: ifeq +69 -> 494
    //   428: invokestatic 114	com/whatsapp/fieldstats/k:a	()Lcom/whatsapp/fieldstats/k;
    //   431: iconst_1
    //   432: invokestatic 120	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   435: putfield 291	com/whatsapp/fieldstats/events/bw:r	Ljava/lang/Boolean;
    //   438: new 9	com/whatsapp/fieldstats/j$a$a
    //   441: dup
    //   442: ldc_w 274
    //   445: invokespecial 292	com/whatsapp/fieldstats/j$a$a:<init>	(Ljava/lang/String;)V
    //   448: athrow
    //   449: astore 6
    //   451: new 16	com/whatsapp/fieldstats/j$c
    //   454: dup
    //   455: aload 6
    //   457: invokevirtual 293	com/whatsapp/fieldstats/j$a$a:toString	()Ljava/lang/String;
    //   460: invokespecial 190	com/whatsapp/fieldstats/j$c:<init>	(Ljava/lang/String;)V
    //   463: athrow
    //   464: astore 6
    //   466: invokestatic 114	com/whatsapp/fieldstats/k:a	()Lcom/whatsapp/fieldstats/k;
    //   469: iconst_1
    //   470: invokestatic 120	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   473: putfield 296	com/whatsapp/fieldstats/events/bw:o	Ljava/lang/Boolean;
    //   476: aload 6
    //   478: athrow
    //   479: astore 6
    //   481: new 9	com/whatsapp/fieldstats/j$a$a
    //   484: dup
    //   485: aload 6
    //   487: invokevirtual 191	java/io/IOException:toString	()Ljava/lang/String;
    //   490: invokespecial 292	com/whatsapp/fieldstats/j$a$a:<init>	(Ljava/lang/String;)V
    //   493: athrow
    //   494: invokestatic 114	com/whatsapp/fieldstats/k:a	()Lcom/whatsapp/fieldstats/k;
    //   497: iconst_1
    //   498: invokestatic 120	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   501: putfield 299	com/whatsapp/fieldstats/events/bw:s	Ljava/lang/Boolean;
    //   504: goto -66 -> 438
    //   507: aload 7
    //   509: invokevirtual 288	com/whatsapp/fieldstats/j$a:a	()Z
    //   512: ifeq +8 -> 520
    //   515: aload 7
    //   517: invokevirtual 301	com/whatsapp/fieldstats/j$a:g	()V
    //   520: getstatic 307	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   523: invokestatic 312	java/lang/System:currentTimeMillis	()J
    //   526: invokevirtual 316	java/util/concurrent/TimeUnit:toSeconds	(J)J
    //   529: lstore_3
    //   530: iload_1
    //   531: aload_0
    //   532: getfield 62	com/whatsapp/fieldstats/j:c	Lcom/whatsapp/fieldstats/j$d;
    //   535: getfield 225	com/whatsapp/fieldstats/j$d:a	I
    //   538: if_icmpne +51 -> 589
    //   541: aload 6
    //   543: getfield 235	com/whatsapp/fieldstats/j$d$a:b	J
    //   546: lload_3
    //   547: lcmp
    //   548: ifle +41 -> 589
    //   551: new 64	java/lang/StringBuilder
    //   554: dup
    //   555: ldc_w 318
    //   558: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   561: aload 6
    //   563: getfield 235	com/whatsapp/fieldstats/j$d$a:b	J
    //   566: lload_3
    //   567: lsub
    //   568: invokevirtual 321	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   571: ldc_w 323
    //   574: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   580: invokestatic 326	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   583: aload 6
    //   585: lload_3
    //   586: putfield 235	com/whatsapp/fieldstats/j$d$a:b	J
    //   589: iload_1
    //   590: iconst_1
    //   591: iadd
    //   592: istore_1
    //   593: goto -295 -> 298
    //   596: getstatic 332	java/util/Locale:US	Ljava/util/Locale;
    //   599: astore 6
    //   601: aload_0
    //   602: invokevirtual 335	com/whatsapp/fieldstats/j:e	()Lcom/whatsapp/fieldstats/j$a;
    //   605: astore 7
    //   607: aload 7
    //   609: invokevirtual 288	com/whatsapp/fieldstats/j$a:a	()Z
    //   612: ifne +14 -> 626
    //   615: new 337	java/lang/UnsupportedOperationException
    //   618: dup
    //   619: ldc_w 339
    //   622: invokespecial 340	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   625: athrow
    //   626: aload 7
    //   628: getfield 342	com/whatsapp/fieldstats/j$a:d	I
    //   631: istore_1
    //   632: aload_0
    //   633: invokevirtual 335	com/whatsapp/fieldstats/j:e	()Lcom/whatsapp/fieldstats/j$a;
    //   636: invokevirtual 344	com/whatsapp/fieldstats/j$a:c	()I
    //   639: istore_2
    //   640: aload_0
    //   641: invokevirtual 335	com/whatsapp/fieldstats/j:e	()Lcom/whatsapp/fieldstats/j$a;
    //   644: astore 7
    //   646: aload 7
    //   648: invokevirtual 288	com/whatsapp/fieldstats/j$a:a	()Z
    //   651: ifne +14 -> 665
    //   654: new 337	java/lang/UnsupportedOperationException
    //   657: dup
    //   658: ldc_w 346
    //   661: invokespecial 340	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   664: athrow
    //   665: aload 6
    //   667: ldc_w 348
    //   670: bipush 6
    //   672: anewarray 4	java/lang/Object
    //   675: dup
    //   676: iconst_0
    //   677: iload_1
    //   678: invokestatic 353	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   681: aastore
    //   682: dup
    //   683: iconst_1
    //   684: iload_2
    //   685: invokestatic 353	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   688: aastore
    //   689: dup
    //   690: iconst_2
    //   691: aload 7
    //   693: getfield 356	com/whatsapp/fieldstats/j$a:f	Lcom/whatsapp/fieldstats/b;
    //   696: getfield 361	com/whatsapp/fieldstats/b:a	Ljava/util/Map;
    //   699: invokeinterface 366 1 0
    //   704: invokestatic 353	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   707: aastore
    //   708: dup
    //   709: iconst_3
    //   710: aload_0
    //   711: invokevirtual 335	com/whatsapp/fieldstats/j:e	()Lcom/whatsapp/fieldstats/j$a;
    //   714: getfield 277	com/whatsapp/fieldstats/j$a:a	Lcom/whatsapp/fieldstats/h;
    //   717: getfield 244	com/whatsapp/fieldstats/h:b	Ljava/nio/ByteBuffer;
    //   720: invokevirtual 248	java/nio/ByteBuffer:position	()I
    //   723: invokestatic 353	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   726: aastore
    //   727: dup
    //   728: iconst_4
    //   729: aload_0
    //   730: invokevirtual 335	com/whatsapp/fieldstats/j:e	()Lcom/whatsapp/fieldstats/j$a;
    //   733: invokevirtual 280	com/whatsapp/fieldstats/j$a:b	()Lcom/whatsapp/fieldstats/j$d$a;
    //   736: getfield 235	com/whatsapp/fieldstats/j$d$a:b	J
    //   739: invokestatic 371	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   742: aastore
    //   743: dup
    //   744: iconst_5
    //   745: aload_0
    //   746: invokevirtual 373	com/whatsapp/fieldstats/j:f	()Lcom/whatsapp/fieldstats/j$a;
    //   749: getfield 277	com/whatsapp/fieldstats/j$a:a	Lcom/whatsapp/fieldstats/h;
    //   752: getfield 244	com/whatsapp/fieldstats/h:b	Ljava/nio/ByteBuffer;
    //   755: invokevirtual 248	java/nio/ByteBuffer:position	()I
    //   758: invokestatic 353	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   761: aastore
    //   762: invokestatic 379	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   765: invokestatic 164	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   768: return
    //   769: iconst_0
    //   770: istore 5
    //   772: goto -404 -> 368
    //   775: iconst_0
    //   776: istore 5
    //   778: goto -383 -> 395
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	781	0	this	j
    //   100	578	1	j	int
    //   98	587	2	k	int
    //   259	327	3	l	long
    //   366	411	5	bool	boolean
    //   4	82	6	localb	b
    //   149	7	6	localIOException1	IOException
    //   164	128	6	locala1	j.b.a
    //   316	1	6	locala	j.d.a
    //   449	7	6	locala2	j.a.a
    //   464	13	6	locala3	j.b.a
    //   479	105	6	localIOException2	IOException
    //   599	67	6	localLocale	java.util.Locale
    //   28	664	7	localObject1	Object
    //   93	160	8	localObject2	Object
    //   110	23	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   6	20	149	java/io/IOException
    //   0	6	164	com/whatsapp/fieldstats/j$b$a
    //   6	20	164	com/whatsapp/fieldstats/j$b$a
    //   20	99	164	com/whatsapp/fieldstats/j$b$a
    //   112	142	164	com/whatsapp/fieldstats/j$b$a
    //   151	164	164	com/whatsapp/fieldstats/j$b$a
    //   179	226	164	com/whatsapp/fieldstats/j$b$a
    //   226	291	164	com/whatsapp/fieldstats/j$b$a
    //   466	479	164	com/whatsapp/fieldstats/j$b$a
    //   318	326	449	com/whatsapp/fieldstats/j$a$a
    //   326	343	449	com/whatsapp/fieldstats/j$a$a
    //   343	365	449	com/whatsapp/fieldstats/j$a$a
    //   368	392	449	com/whatsapp/fieldstats/j$a$a
    //   395	438	449	com/whatsapp/fieldstats/j$a$a
    //   438	449	449	com/whatsapp/fieldstats/j$a$a
    //   481	494	449	com/whatsapp/fieldstats/j$a$a
    //   494	504	449	com/whatsapp/fieldstats/j$a$a
    //   507	520	449	com/whatsapp/fieldstats/j$a$a
    //   291	296	464	com/whatsapp/fieldstats/j$b$a
    //   326	343	479	java/io/IOException
  }
  
  private void j()
  {
    Log.e("wambuffer: PERSISTENCE TURNED OFF");
    this.a = false;
  }
  
  private void k()
  {
    int j = 0;
    this.c.a = 0;
    a[] arrayOfa = this.i;
    int k = arrayOfa.length;
    while (j < k)
    {
      arrayOfa[j].f();
      j += 1;
    }
  }
  
  public final long a()
  {
    return e().b().b;
  }
  
  public final boolean b()
  {
    return !f().d();
  }
  
  public final byte[] c()
  {
    if (this.b) {
      d();
    }
    h localh = f().a;
    return Arrays.copyOf(localh.b.array(), localh.b.position());
  }
  
  public final void d()
  {
    if (!this.a) {
      return;
    }
    try
    {
      a[] arrayOfa = this.i;
      int k = arrayOfa.length;
      int j = 0;
      for (;;)
      {
        if (j < k)
        {
          a locala = arrayOfa[j];
          try
          {
            locala.a.d();
            locala.b().a = locala.a.a;
            locala.b().c = locala.a.a();
            j += 1;
          }
          catch (IOException localIOException1)
          {
            k.a().f = Boolean.valueOf(true);
            Log.e("eventbuffer/flush: cannot write event buffer");
            throw localIOException1;
          }
        }
      }
      try
      {
        this.h.a();
        this.b = false;
        Log.d("wambuffer/flush");
        return;
      }
      catch (IOException localIOException3)
      {
        k.a().e = Boolean.valueOf(true);
        Log.e("wambuffer/flush: cannot write header");
        j();
      }
    }
    catch (IOException localIOException2)
    {
      j();
      return;
    }
  }
  
  final a e()
  {
    return this.i[this.c.a];
  }
  
  final a f()
  {
    return this.i[(1 - this.c.a)];
  }
  
  static final class a
  {
    final h a;
    int b;
    final j.d c;
    int d = 0;
    int e = 0;
    final b f = new b();
    
    a(RandomAccessFile paramRandomAccessFile, int paramInt, j.d paramd)
    {
      this.a = new h(paramRandomAccessFile, 65536 + (paramInt << 16));
      this.b = paramInt;
      this.c = paramd;
    }
    
    final boolean a()
    {
      return this.b == this.c.a;
    }
    
    final j.d.a b()
    {
      return this.c.b[this.b];
    }
    
    final int c()
    {
      if (!a()) {
        throw new UnsupportedOperationException("No event count available for rotated buffer");
      }
      return this.e;
    }
    
    final boolean d()
    {
      return this.a.b.position() == 0;
    }
    
    final int e()
    {
      return this.a.b.remaining();
    }
    
    public final void f()
    {
      this.a.c();
      b().a = this.a.a;
      b().b = 0L;
      b().c = this.a.a();
      this.d = 0;
      this.e = 0;
      this.f.a();
    }
    
    /* Error */
    final void g()
    {
      // Byte code:
      //   0: aload_0
      //   1: iconst_0
      //   2: putfield 25	com/whatsapp/fieldstats/j$a:d	I
      //   5: aload_0
      //   6: iconst_0
      //   7: putfield 27	com/whatsapp/fieldstats/j$a:e	I
      //   10: aload_0
      //   11: getfield 32	com/whatsapp/fieldstats/j$a:f	Lcom/whatsapp/fieldstats/b;
      //   14: invokevirtual 94	com/whatsapp/fieldstats/b:a	()V
      //   17: aload_0
      //   18: getfield 40	com/whatsapp/fieldstats/j$a:a	Lcom/whatsapp/fieldstats/h;
      //   21: invokevirtual 102	com/whatsapp/fieldstats/h:b	()Ljava/nio/ByteBuffer;
      //   24: astore_1
      //   25: aload_1
      //   26: invokevirtual 105	java/nio/ByteBuffer:limit	()I
      //   29: ifne +4 -> 33
      //   32: return
      //   33: invokestatic 109	com/whatsapp/fieldstats/j:h	()[B
      //   36: arraylength
      //   37: newarray <illegal type>
      //   39: astore_2
      //   40: aload_1
      //   41: aload_2
      //   42: invokevirtual 113	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
      //   45: pop
      //   46: aload_2
      //   47: invokestatic 109	com/whatsapp/fieldstats/j:h	()[B
      //   50: invokestatic 119	java/util/Arrays:equals	([B[B)Z
      //   53: ifne +24 -> 77
      //   56: new 9	com/whatsapp/fieldstats/j$a$a
      //   59: dup
      //   60: ldc 121
      //   62: invokespecial 122	com/whatsapp/fieldstats/j$a$a:<init>	(Ljava/lang/String;)V
      //   65: athrow
      //   66: astore_1
      //   67: new 9	com/whatsapp/fieldstats/j$a$a
      //   70: dup
      //   71: ldc 124
      //   73: invokespecial 122	com/whatsapp/fieldstats/j$a$a:<init>	(Ljava/lang/String;)V
      //   76: athrow
      //   77: aload_1
      //   78: invokevirtual 72	java/nio/ByteBuffer:position	()I
      //   81: aload_1
      //   82: invokevirtual 105	java/nio/ByteBuffer:limit	()I
      //   85: if_icmpge -53 -> 32
      //   88: aload_1
      //   89: invokestatic 129	com/whatsapp/fieldstats/i:a	(Ljava/nio/ByteBuffer;)Lcom/whatsapp/fieldstats/i$c;
      //   92: astore_2
      //   93: aload_0
      //   94: aload_0
      //   95: getfield 25	com/whatsapp/fieldstats/j$a:d	I
      //   98: iconst_1
      //   99: iadd
      //   100: putfield 25	com/whatsapp/fieldstats/j$a:d	I
      //   103: aload_2
      //   104: getfield 132	com/whatsapp/fieldstats/i$c:a	I
      //   107: iconst_1
      //   108: if_icmpne +13 -> 121
      //   111: aload_0
      //   112: aload_0
      //   113: getfield 27	com/whatsapp/fieldstats/j$a:e	I
      //   116: iconst_1
      //   117: iadd
      //   118: putfield 27	com/whatsapp/fieldstats/j$a:e	I
      //   121: aload_2
      //   122: getfield 132	com/whatsapp/fieldstats/i$c:a	I
      //   125: ifne -48 -> 77
      //   128: aload_0
      //   129: getfield 32	com/whatsapp/fieldstats/j$a:f	Lcom/whatsapp/fieldstats/b;
      //   132: aload_2
      //   133: getfield 133	com/whatsapp/fieldstats/i$c:b	I
      //   136: aload_2
      //   137: getfield 136	com/whatsapp/fieldstats/i$c:c	Ljava/lang/Object;
      //   140: invokevirtual 139	com/whatsapp/fieldstats/b:a	(ILjava/lang/Object;)V
      //   143: goto -66 -> 77
      //   146: astore_1
      //   147: new 9	com/whatsapp/fieldstats/j$a$a
      //   150: dup
      //   151: aload_1
      //   152: invokevirtual 143	com/whatsapp/fieldstats/i$b:toString	()Ljava/lang/String;
      //   155: invokespecial 122	com/whatsapp/fieldstats/j$a$a:<init>	(Ljava/lang/String;)V
      //   158: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	159	0	this	a
      //   24	17	1	localByteBuffer	ByteBuffer
      //   66	23	1	localBufferUnderflowException	java.nio.BufferUnderflowException
      //   146	6	1	localb	i.b
      //   39	98	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   40	46	66	java/nio/BufferUnderflowException
      //   77	121	146	com/whatsapp/fieldstats/i$b
      //   121	143	146	com/whatsapp/fieldstats/i$b
    }
    
    static final class a
      extends Exception
    {
      a(String paramString)
      {
        super();
      }
    }
  }
  
  static final class b
  {
    byte[] a = j.g();
    int b = 65536;
    int c = 65536;
    final j.d d;
    long e;
    final h f;
    final int g;
    private final int h = 4;
    
    b(RandomAccessFile paramRandomAccessFile, j.d paramd)
    {
      this.d = paramd;
      this.f = new h(paramRandomAccessFile, 0);
      c();
      this.g = this.f.b.position();
    }
    
    static int a(ByteBuffer paramByteBuffer)
    {
      paramByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      return paramByteBuffer.getInt();
    }
    
    static long b(ByteBuffer paramByteBuffer)
    {
      long l = a(paramByteBuffer);
      if (0L <= l) {
        return l;
      }
      return l + 4294967296L;
    }
    
    private void c()
    {
      this.f.c();
      this.f.a(this.a);
      this.f.a(this.b);
      this.f.a(this.c);
      this.f.a(this.d.a);
      j.d.a[] arrayOfa = this.d.b;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        j.d.a locala = arrayOfa[i];
        this.f.a(locala.a);
        this.f.a(locala.b);
        this.f.a(locala.c);
        i += 1;
      }
      this.e = this.f.a();
      this.f.a(this.e);
    }
    
    final void a()
    {
      c();
      this.f.d();
    }
    
    final void b()
    {
      if (!Arrays.equals(this.a, j.g())) {
        throw new a("Invalid WAM file magic or version");
      }
      if (this.b != 65536) {
        throw new a("Invalid max metadata size");
      }
      if (this.c != 65536) {
        throw new a("Invalid max event buffer size");
      }
      if ((this.d.a != 0) && (this.d.a != 1)) {
        throw new a("Invalid current event buffer");
      }
      j.d.a[] arrayOfa = this.d.b;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        if (arrayOfa[i].a > this.c) {
          throw new a("Invalid event buffer size");
        }
        i += 1;
      }
    }
    
    static final class a
      extends Exception
    {
      a(String paramString)
      {
        super();
      }
    }
  }
  
  static final class c
    extends Exception
  {
    c(String paramString)
    {
      super();
    }
  }
  
  static final class d
  {
    int a = 0;
    final a[] b = { new a(), new a() };
    
    static final class a
    {
      int a = 0;
      long b = 0L;
      long c = h.c;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */