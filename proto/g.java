package com.whatsapp.proto;

import android.support.design.widget.f.a;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.GeneratedMessageLite.a;
import com.google.protobuf.ae;
import com.google.protobuf.am;
import com.google.protobuf.c;
import com.google.protobuf.e;
import com.google.protobuf.p.a;
import com.google.protobuf.w;

public final class g
  extends GeneratedMessageLite
  implements f.a
{
  public static ae<g> a = new c() {};
  private static final g p;
  int b;
  public Protocol.MessageKey c;
  public E2E.Message d;
  public long e;
  b f;
  boolean g;
  boolean h;
  boolean i;
  e j;
  public boolean k;
  public boolean l;
  public boolean m;
  c n;
  boolean o;
  private final e q;
  private Object r;
  private Object s;
  private byte t = -1;
  private int u = -1;
  
  static
  {
    g localg = new g();
    p = localg;
    localg.k();
  }
  
  private g()
  {
    this.q = e.b;
  }
  
  private g(GeneratedMessageLite.a parama)
  {
    super((byte)0);
    this.q = parama.a;
  }
  
  /* Error */
  private g(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 66	com/google/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 68	com/whatsapp/proto/g:t	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 70	com/whatsapp/proto/g:u	I
    //   14: aload_0
    //   15: invokespecial 64	com/whatsapp/proto/g:k	()V
    //   18: invokestatic 95	com/google/protobuf/e:h	()Lcom/google/protobuf/e$c;
    //   21: astore 7
    //   23: aload 7
    //   25: sipush 4096
    //   28: invokestatic 100	com/google/protobuf/g:a	(Ljava/io/OutputStream;I)Lcom/google/protobuf/g;
    //   31: astore 8
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +718 -> 754
    //   39: aload_1
    //   40: invokevirtual 105	com/google/protobuf/f:a	()I
    //   43: istore 4
    //   45: iload 4
    //   47: lookupswitch	default:+782->829, 0:+785->832, 10:+153->200, 18:+249->296, 24:+340->387, 32:+361->408, 42:+416->463, 128:+442->489, 136:+464->511, 144:+486->533, 154:+509->556, 162:+536->583, 168:+559->606, 176:+582->629, 184:+605->652, 192:+628->675, 200:+684->731
    //   184: aload_1
    //   185: iload 4
    //   187: aload 8
    //   189: invokevirtual 108	com/google/protobuf/f:a	(ILcom/google/protobuf/g;)Z
    //   192: ifne -157 -> 35
    //   195: iconst_1
    //   196: istore_3
    //   197: goto -162 -> 35
    //   200: aload_0
    //   201: getfield 110	com/whatsapp/proto/g:b	I
    //   204: iconst_1
    //   205: iand
    //   206: iconst_1
    //   207: if_icmpne +616 -> 823
    //   210: aload_0
    //   211: getfield 112	com/whatsapp/proto/g:c	Lcom/whatsapp/proto/Protocol$MessageKey;
    //   214: invokevirtual 118	com/whatsapp/proto/Protocol$MessageKey:toBuilder	()Lcom/whatsapp/proto/Protocol$MessageKey$a;
    //   217: astore 6
    //   219: aload_0
    //   220: aload_1
    //   221: getstatic 121	com/whatsapp/proto/Protocol$MessageKey:PARSER	Lcom/google/protobuf/ae;
    //   224: aload_2
    //   225: invokevirtual 124	com/google/protobuf/f:a	(Lcom/google/protobuf/ae;Lcom/google/protobuf/m;)Lcom/google/protobuf/x;
    //   228: checkcast 114	com/whatsapp/proto/Protocol$MessageKey
    //   231: putfield 112	com/whatsapp/proto/g:c	Lcom/whatsapp/proto/Protocol$MessageKey;
    //   234: aload 6
    //   236: ifnull +22 -> 258
    //   239: aload 6
    //   241: aload_0
    //   242: getfield 112	com/whatsapp/proto/g:c	Lcom/whatsapp/proto/Protocol$MessageKey;
    //   245: invokevirtual 130	com/whatsapp/proto/Protocol$MessageKey$a:mergeFrom	(Lcom/google/protobuf/w;)Lcom/google/protobuf/a$a;
    //   248: pop
    //   249: aload_0
    //   250: aload 6
    //   252: invokevirtual 134	com/whatsapp/proto/Protocol$MessageKey$a:buildPartial	()Lcom/whatsapp/proto/Protocol$MessageKey;
    //   255: putfield 112	com/whatsapp/proto/g:c	Lcom/whatsapp/proto/Protocol$MessageKey;
    //   258: aload_0
    //   259: aload_0
    //   260: getfield 110	com/whatsapp/proto/g:b	I
    //   263: iconst_1
    //   264: ior
    //   265: putfield 110	com/whatsapp/proto/g:b	I
    //   268: goto -233 -> 35
    //   271: astore_1
    //   272: aload_1
    //   273: aload_0
    //   274: putfield 137	com/google/protobuf/q:a	Lcom/google/protobuf/x;
    //   277: aload_1
    //   278: athrow
    //   279: astore_1
    //   280: aload 8
    //   282: invokevirtual 139	com/google/protobuf/g:a	()V
    //   285: aload_0
    //   286: aload 7
    //   288: invokevirtual 144	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   291: putfield 76	com/whatsapp/proto/g:q	Lcom/google/protobuf/e;
    //   294: aload_1
    //   295: athrow
    //   296: aload_0
    //   297: getfield 110	com/whatsapp/proto/g:b	I
    //   300: iconst_2
    //   301: iand
    //   302: iconst_2
    //   303: if_icmpne +514 -> 817
    //   306: aload_0
    //   307: getfield 146	com/whatsapp/proto/g:d	Lcom/whatsapp/proto/E2E$Message;
    //   310: invokevirtual 151	com/whatsapp/proto/E2E$Message:toBuilder	()Lcom/whatsapp/proto/E2E$Message$a;
    //   313: astore 6
    //   315: aload_0
    //   316: aload_1
    //   317: getstatic 152	com/whatsapp/proto/E2E$Message:PARSER	Lcom/google/protobuf/ae;
    //   320: aload_2
    //   321: invokevirtual 124	com/google/protobuf/f:a	(Lcom/google/protobuf/ae;Lcom/google/protobuf/m;)Lcom/google/protobuf/x;
    //   324: checkcast 148	com/whatsapp/proto/E2E$Message
    //   327: putfield 146	com/whatsapp/proto/g:d	Lcom/whatsapp/proto/E2E$Message;
    //   330: aload 6
    //   332: ifnull +22 -> 354
    //   335: aload 6
    //   337: aload_0
    //   338: getfield 146	com/whatsapp/proto/g:d	Lcom/whatsapp/proto/E2E$Message;
    //   341: invokevirtual 155	com/whatsapp/proto/E2E$Message$a:mergeFrom	(Lcom/google/protobuf/w;)Lcom/google/protobuf/a$a;
    //   344: pop
    //   345: aload_0
    //   346: aload 6
    //   348: invokevirtual 158	com/whatsapp/proto/E2E$Message$a:buildPartial	()Lcom/whatsapp/proto/E2E$Message;
    //   351: putfield 146	com/whatsapp/proto/g:d	Lcom/whatsapp/proto/E2E$Message;
    //   354: aload_0
    //   355: aload_0
    //   356: getfield 110	com/whatsapp/proto/g:b	I
    //   359: iconst_2
    //   360: ior
    //   361: putfield 110	com/whatsapp/proto/g:b	I
    //   364: goto -329 -> 35
    //   367: astore_1
    //   368: new 90	com/google/protobuf/q
    //   371: dup
    //   372: aload_1
    //   373: invokevirtual 162	java/io/IOException:getMessage	()Ljava/lang/String;
    //   376: invokespecial 165	com/google/protobuf/q:<init>	(Ljava/lang/String;)V
    //   379: astore_1
    //   380: aload_1
    //   381: aload_0
    //   382: putfield 137	com/google/protobuf/q:a	Lcom/google/protobuf/x;
    //   385: aload_1
    //   386: athrow
    //   387: aload_0
    //   388: aload_0
    //   389: getfield 110	com/whatsapp/proto/g:b	I
    //   392: iconst_4
    //   393: ior
    //   394: putfield 110	com/whatsapp/proto/g:b	I
    //   397: aload_0
    //   398: aload_1
    //   399: invokevirtual 168	com/google/protobuf/f:g	()J
    //   402: putfield 170	com/whatsapp/proto/g:e	J
    //   405: goto -370 -> 35
    //   408: aload_1
    //   409: invokevirtual 172	com/google/protobuf/f:f	()I
    //   412: istore 5
    //   414: iload 5
    //   416: invokestatic 175	com/whatsapp/proto/g$b:a	(I)Lcom/whatsapp/proto/g$b;
    //   419: astore 6
    //   421: aload 6
    //   423: ifnonnull +20 -> 443
    //   426: aload 8
    //   428: iload 4
    //   430: invokevirtual 178	com/google/protobuf/g:e	(I)V
    //   433: aload 8
    //   435: iload 5
    //   437: invokevirtual 178	com/google/protobuf/g:e	(I)V
    //   440: goto -405 -> 35
    //   443: aload_0
    //   444: aload_0
    //   445: getfield 110	com/whatsapp/proto/g:b	I
    //   448: bipush 8
    //   450: ior
    //   451: putfield 110	com/whatsapp/proto/g:b	I
    //   454: aload_0
    //   455: aload 6
    //   457: putfield 180	com/whatsapp/proto/g:f	Lcom/whatsapp/proto/g$b;
    //   460: goto -425 -> 35
    //   463: aload_1
    //   464: invokevirtual 182	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
    //   467: astore 6
    //   469: aload_0
    //   470: aload_0
    //   471: getfield 110	com/whatsapp/proto/g:b	I
    //   474: bipush 16
    //   476: ior
    //   477: putfield 110	com/whatsapp/proto/g:b	I
    //   480: aload_0
    //   481: aload 6
    //   483: putfield 184	com/whatsapp/proto/g:r	Ljava/lang/Object;
    //   486: goto -451 -> 35
    //   489: aload_0
    //   490: aload_0
    //   491: getfield 110	com/whatsapp/proto/g:b	I
    //   494: bipush 32
    //   496: ior
    //   497: putfield 110	com/whatsapp/proto/g:b	I
    //   500: aload_0
    //   501: aload_1
    //   502: invokevirtual 187	com/google/protobuf/f:c	()Z
    //   505: putfield 189	com/whatsapp/proto/g:g	Z
    //   508: goto -473 -> 35
    //   511: aload_0
    //   512: aload_0
    //   513: getfield 110	com/whatsapp/proto/g:b	I
    //   516: bipush 64
    //   518: ior
    //   519: putfield 110	com/whatsapp/proto/g:b	I
    //   522: aload_0
    //   523: aload_1
    //   524: invokevirtual 187	com/google/protobuf/f:c	()Z
    //   527: putfield 191	com/whatsapp/proto/g:h	Z
    //   530: goto -495 -> 35
    //   533: aload_0
    //   534: aload_0
    //   535: getfield 110	com/whatsapp/proto/g:b	I
    //   538: sipush 128
    //   541: ior
    //   542: putfield 110	com/whatsapp/proto/g:b	I
    //   545: aload_0
    //   546: aload_1
    //   547: invokevirtual 187	com/google/protobuf/f:c	()Z
    //   550: putfield 193	com/whatsapp/proto/g:i	Z
    //   553: goto -518 -> 35
    //   556: aload_1
    //   557: invokevirtual 182	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
    //   560: astore 6
    //   562: aload_0
    //   563: aload_0
    //   564: getfield 110	com/whatsapp/proto/g:b	I
    //   567: sipush 256
    //   570: ior
    //   571: putfield 110	com/whatsapp/proto/g:b	I
    //   574: aload_0
    //   575: aload 6
    //   577: putfield 195	com/whatsapp/proto/g:s	Ljava/lang/Object;
    //   580: goto -545 -> 35
    //   583: aload_0
    //   584: aload_0
    //   585: getfield 110	com/whatsapp/proto/g:b	I
    //   588: sipush 512
    //   591: ior
    //   592: putfield 110	com/whatsapp/proto/g:b	I
    //   595: aload_0
    //   596: aload_1
    //   597: invokevirtual 182	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
    //   600: putfield 197	com/whatsapp/proto/g:j	Lcom/google/protobuf/e;
    //   603: goto -568 -> 35
    //   606: aload_0
    //   607: aload_0
    //   608: getfield 110	com/whatsapp/proto/g:b	I
    //   611: sipush 1024
    //   614: ior
    //   615: putfield 110	com/whatsapp/proto/g:b	I
    //   618: aload_0
    //   619: aload_1
    //   620: invokevirtual 187	com/google/protobuf/f:c	()Z
    //   623: putfield 199	com/whatsapp/proto/g:k	Z
    //   626: goto -591 -> 35
    //   629: aload_0
    //   630: aload_0
    //   631: getfield 110	com/whatsapp/proto/g:b	I
    //   634: sipush 2048
    //   637: ior
    //   638: putfield 110	com/whatsapp/proto/g:b	I
    //   641: aload_0
    //   642: aload_1
    //   643: invokevirtual 187	com/google/protobuf/f:c	()Z
    //   646: putfield 201	com/whatsapp/proto/g:l	Z
    //   649: goto -614 -> 35
    //   652: aload_0
    //   653: aload_0
    //   654: getfield 110	com/whatsapp/proto/g:b	I
    //   657: sipush 4096
    //   660: ior
    //   661: putfield 110	com/whatsapp/proto/g:b	I
    //   664: aload_0
    //   665: aload_1
    //   666: invokevirtual 187	com/google/protobuf/f:c	()Z
    //   669: putfield 203	com/whatsapp/proto/g:m	Z
    //   672: goto -637 -> 35
    //   675: aload_1
    //   676: invokevirtual 172	com/google/protobuf/f:f	()I
    //   679: istore 5
    //   681: iload 5
    //   683: invokestatic 206	com/whatsapp/proto/g$c:a	(I)Lcom/whatsapp/proto/g$c;
    //   686: astore 6
    //   688: aload 6
    //   690: ifnonnull +20 -> 710
    //   693: aload 8
    //   695: iload 4
    //   697: invokevirtual 178	com/google/protobuf/g:e	(I)V
    //   700: aload 8
    //   702: iload 5
    //   704: invokevirtual 178	com/google/protobuf/g:e	(I)V
    //   707: goto -672 -> 35
    //   710: aload_0
    //   711: aload_0
    //   712: getfield 110	com/whatsapp/proto/g:b	I
    //   715: sipush 8192
    //   718: ior
    //   719: putfield 110	com/whatsapp/proto/g:b	I
    //   722: aload_0
    //   723: aload 6
    //   725: putfield 208	com/whatsapp/proto/g:n	Lcom/whatsapp/proto/g$c;
    //   728: goto -693 -> 35
    //   731: aload_0
    //   732: aload_0
    //   733: getfield 110	com/whatsapp/proto/g:b	I
    //   736: sipush 16384
    //   739: ior
    //   740: putfield 110	com/whatsapp/proto/g:b	I
    //   743: aload_0
    //   744: aload_1
    //   745: invokevirtual 187	com/google/protobuf/f:c	()Z
    //   748: putfield 210	com/whatsapp/proto/g:o	Z
    //   751: goto -716 -> 35
    //   754: aload 8
    //   756: invokevirtual 139	com/google/protobuf/g:a	()V
    //   759: aload_0
    //   760: aload 7
    //   762: invokevirtual 144	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   765: putfield 76	com/whatsapp/proto/g:q	Lcom/google/protobuf/e;
    //   768: return
    //   769: astore_1
    //   770: aload_0
    //   771: aload 7
    //   773: invokevirtual 144	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   776: putfield 76	com/whatsapp/proto/g:q	Lcom/google/protobuf/e;
    //   779: return
    //   780: astore_1
    //   781: aload_0
    //   782: aload 7
    //   784: invokevirtual 144	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   787: putfield 76	com/whatsapp/proto/g:q	Lcom/google/protobuf/e;
    //   790: aload_1
    //   791: athrow
    //   792: astore_2
    //   793: aload_0
    //   794: aload 7
    //   796: invokevirtual 144	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   799: putfield 76	com/whatsapp/proto/g:q	Lcom/google/protobuf/e;
    //   802: goto -508 -> 294
    //   805: astore_1
    //   806: aload_0
    //   807: aload 7
    //   809: invokevirtual 144	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   812: putfield 76	com/whatsapp/proto/g:q	Lcom/google/protobuf/e;
    //   815: aload_1
    //   816: athrow
    //   817: aconst_null
    //   818: astore 6
    //   820: goto -505 -> 315
    //   823: aconst_null
    //   824: astore 6
    //   826: goto -607 -> 219
    //   829: goto -645 -> 184
    //   832: iconst_1
    //   833: istore_3
    //   834: goto -799 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	837	0	this	g
    //   0	837	1	paramf	com.google.protobuf.f
    //   0	837	2	paramm	com.google.protobuf.m
    //   34	800	3	i1	int
    //   43	653	4	i2	int
    //   412	291	5	i3	int
    //   217	608	6	localObject	Object
    //   21	787	7	localc	com.google.protobuf.e.c
    //   31	724	8	localg	com.google.protobuf.g
    // Exception table:
    //   from	to	target	type
    //   39	45	271	com/google/protobuf/q
    //   184	195	271	com/google/protobuf/q
    //   200	219	271	com/google/protobuf/q
    //   219	234	271	com/google/protobuf/q
    //   239	258	271	com/google/protobuf/q
    //   258	268	271	com/google/protobuf/q
    //   296	315	271	com/google/protobuf/q
    //   315	330	271	com/google/protobuf/q
    //   335	354	271	com/google/protobuf/q
    //   354	364	271	com/google/protobuf/q
    //   387	405	271	com/google/protobuf/q
    //   408	421	271	com/google/protobuf/q
    //   426	440	271	com/google/protobuf/q
    //   443	460	271	com/google/protobuf/q
    //   463	486	271	com/google/protobuf/q
    //   489	508	271	com/google/protobuf/q
    //   511	530	271	com/google/protobuf/q
    //   533	553	271	com/google/protobuf/q
    //   556	580	271	com/google/protobuf/q
    //   583	603	271	com/google/protobuf/q
    //   606	626	271	com/google/protobuf/q
    //   629	649	271	com/google/protobuf/q
    //   652	672	271	com/google/protobuf/q
    //   675	688	271	com/google/protobuf/q
    //   693	707	271	com/google/protobuf/q
    //   710	728	271	com/google/protobuf/q
    //   731	751	271	com/google/protobuf/q
    //   39	45	279	finally
    //   184	195	279	finally
    //   200	219	279	finally
    //   219	234	279	finally
    //   239	258	279	finally
    //   258	268	279	finally
    //   272	279	279	finally
    //   296	315	279	finally
    //   315	330	279	finally
    //   335	354	279	finally
    //   354	364	279	finally
    //   368	387	279	finally
    //   387	405	279	finally
    //   408	421	279	finally
    //   426	440	279	finally
    //   443	460	279	finally
    //   463	486	279	finally
    //   489	508	279	finally
    //   511	530	279	finally
    //   533	553	279	finally
    //   556	580	279	finally
    //   583	603	279	finally
    //   606	626	279	finally
    //   629	649	279	finally
    //   652	672	279	finally
    //   675	688	279	finally
    //   693	707	279	finally
    //   710	728	279	finally
    //   731	751	279	finally
    //   39	45	367	java/io/IOException
    //   184	195	367	java/io/IOException
    //   200	219	367	java/io/IOException
    //   219	234	367	java/io/IOException
    //   239	258	367	java/io/IOException
    //   258	268	367	java/io/IOException
    //   296	315	367	java/io/IOException
    //   315	330	367	java/io/IOException
    //   335	354	367	java/io/IOException
    //   354	364	367	java/io/IOException
    //   387	405	367	java/io/IOException
    //   408	421	367	java/io/IOException
    //   426	440	367	java/io/IOException
    //   443	460	367	java/io/IOException
    //   463	486	367	java/io/IOException
    //   489	508	367	java/io/IOException
    //   511	530	367	java/io/IOException
    //   533	553	367	java/io/IOException
    //   556	580	367	java/io/IOException
    //   583	603	367	java/io/IOException
    //   606	626	367	java/io/IOException
    //   629	649	367	java/io/IOException
    //   652	672	367	java/io/IOException
    //   675	688	367	java/io/IOException
    //   693	707	367	java/io/IOException
    //   710	728	367	java/io/IOException
    //   731	751	367	java/io/IOException
    //   754	759	769	java/io/IOException
    //   754	759	780	finally
    //   280	285	792	java/io/IOException
    //   280	285	805	finally
  }
  
  public static g a()
  {
    return p;
  }
  
  public static g a(byte[] paramArrayOfByte)
  {
    return (g)a.a(paramArrayOfByte);
  }
  
  public static a h()
  {
    return a.c();
  }
  
  private e i()
  {
    Object localObject = this.r;
    if ((localObject instanceof String))
    {
      localObject = e.a((String)localObject);
      this.r = localObject;
      return (e)localObject;
    }
    return (e)localObject;
  }
  
  private e j()
  {
    Object localObject = this.s;
    if ((localObject instanceof String))
    {
      localObject = e.a((String)localObject);
      this.s = localObject;
      return (e)localObject;
    }
    return (e)localObject;
  }
  
  private void k()
  {
    this.c = Protocol.MessageKey.getDefaultInstance();
    this.d = E2E.Message.getDefaultInstance();
    this.e = 0L;
    this.f = b.b;
    this.r = "";
    this.g = false;
    this.h = false;
    this.i = false;
    this.s = "";
    this.j = e.b;
    this.k = false;
    this.l = false;
    this.m = false;
    this.n = c.a;
    this.o = false;
  }
  
  public final boolean b()
  {
    return (this.b & 0x1) == 1;
  }
  
  public final boolean c()
  {
    return (this.b & 0x2) == 2;
  }
  
  public final boolean d()
  {
    return (this.b & 0x4) == 4;
  }
  
  public final boolean e()
  {
    return (this.b & 0x400) == 1024;
  }
  
  public final boolean f()
  {
    return (this.b & 0x800) == 2048;
  }
  
  public final boolean g()
  {
    return (this.b & 0x1000) == 4096;
  }
  
  public final ae<g> getParserForType()
  {
    return a;
  }
  
  public final int getSerializedSize()
  {
    int i1 = this.u;
    if (i1 != -1) {
      return i1;
    }
    int i2 = 0;
    if ((this.b & 0x1) == 1) {
      i2 = com.google.protobuf.g.d(1, this.c) + 0;
    }
    i1 = i2;
    if ((this.b & 0x2) == 2) {
      i1 = i2 + com.google.protobuf.g.d(2, this.d);
    }
    i2 = i1;
    if ((this.b & 0x4) == 4) {
      i2 = i1 + com.google.protobuf.g.c(3, this.e);
    }
    i1 = i2;
    if ((this.b & 0x8) == 8) {
      i1 = i2 + com.google.protobuf.g.f(4, this.f.getNumber());
    }
    i2 = i1;
    if ((this.b & 0x10) == 16) {
      i2 = i1 + com.google.protobuf.g.c(5, i());
    }
    i1 = i2;
    if ((this.b & 0x20) == 32) {
      i1 = i2 + (com.google.protobuf.g.d(16) + 1);
    }
    i2 = i1;
    if ((this.b & 0x40) == 64) {
      i2 = i1 + (com.google.protobuf.g.d(17) + 1);
    }
    i1 = i2;
    if ((this.b & 0x80) == 128) {
      i1 = i2 + (com.google.protobuf.g.d(18) + 1);
    }
    i2 = i1;
    if ((this.b & 0x100) == 256) {
      i2 = i1 + com.google.protobuf.g.c(19, j());
    }
    i1 = i2;
    if ((this.b & 0x200) == 512) {
      i1 = i2 + com.google.protobuf.g.c(20, this.j);
    }
    i2 = i1;
    if ((this.b & 0x400) == 1024) {
      i2 = i1 + (com.google.protobuf.g.d(21) + 1);
    }
    i1 = i2;
    if ((this.b & 0x800) == 2048) {
      i1 = i2 + (com.google.protobuf.g.d(22) + 1);
    }
    i2 = i1;
    if ((this.b & 0x1000) == 4096) {
      i2 = i1 + (com.google.protobuf.g.d(23) + 1);
    }
    i1 = i2;
    if ((this.b & 0x2000) == 8192) {
      i1 = i2 + com.google.protobuf.g.f(24, this.n.getNumber());
    }
    i2 = i1;
    if ((this.b & 0x4000) == 16384) {
      i2 = i1 + (com.google.protobuf.g.d(25) + 1);
    }
    i1 = i2 + this.q.a();
    this.u = i1;
    return i1;
  }
  
  public final boolean isInitialized()
  {
    int i1 = this.t;
    if (i1 == 1) {
      return true;
    }
    if (i1 == 0) {
      return false;
    }
    if (!b())
    {
      this.t = 0;
      return false;
    }
    this.t = 1;
    return true;
  }
  
  public final void writeTo(com.google.protobuf.g paramg)
  {
    getSerializedSize();
    if ((this.b & 0x1) == 1) {
      paramg.b(1, this.c);
    }
    if ((this.b & 0x2) == 2) {
      paramg.b(2, this.d);
    }
    if ((this.b & 0x4) == 4) {
      paramg.a(3, this.e);
    }
    if ((this.b & 0x8) == 8) {
      paramg.c(4, this.f.getNumber());
    }
    if ((this.b & 0x10) == 16) {
      paramg.a(5, i());
    }
    if ((this.b & 0x20) == 32) {
      paramg.a(16, this.g);
    }
    if ((this.b & 0x40) == 64) {
      paramg.a(17, this.h);
    }
    if ((this.b & 0x80) == 128) {
      paramg.a(18, this.i);
    }
    if ((this.b & 0x100) == 256) {
      paramg.a(19, j());
    }
    if ((this.b & 0x200) == 512) {
      paramg.a(20, this.j);
    }
    if ((this.b & 0x400) == 1024) {
      paramg.a(21, this.k);
    }
    if ((this.b & 0x800) == 2048) {
      paramg.a(22, this.l);
    }
    if ((this.b & 0x1000) == 4096) {
      paramg.a(23, this.m);
    }
    if ((this.b & 0x2000) == 8192) {
      paramg.c(24, this.n.getNumber());
    }
    if ((this.b & 0x4000) == 16384) {
      paramg.a(25, this.o);
    }
    paramg.c(this.q);
  }
  
  public static final class a
    extends GeneratedMessageLite.a<g, a>
    implements f.a
  {
    private int b;
    private Protocol.MessageKey c = Protocol.MessageKey.getDefaultInstance();
    private E2E.Message d = E2E.Message.getDefaultInstance();
    private long e;
    private g.b f = g.b.b;
    private Object g = "";
    private boolean h;
    private boolean i;
    private boolean j;
    private Object k = "";
    private e l = e.b;
    private boolean m;
    private boolean n;
    private boolean o;
    private g.c p = g.c.a;
    private boolean q;
    
    /* Error */
    private a a(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
    {
      // Byte code:
      //   0: getstatic 85	com/whatsapp/proto/g:a	Lcom/google/protobuf/ae;
      //   3: aload_1
      //   4: aload_2
      //   5: invokeinterface 90 3 0
      //   10: checkcast 9	com/whatsapp/proto/g
      //   13: astore_1
      //   14: aload_1
      //   15: ifnull +9 -> 24
      //   18: aload_0
      //   19: aload_1
      //   20: invokevirtual 93	com/whatsapp/proto/g$a:a	(Lcom/whatsapp/proto/g;)Lcom/whatsapp/proto/g$a;
      //   23: pop
      //   24: aload_0
      //   25: areturn
      //   26: astore_2
      //   27: aload_2
      //   28: getfield 96	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   31: checkcast 9	com/whatsapp/proto/g
      //   34: astore_1
      //   35: aload_2
      //   36: athrow
      //   37: astore_2
      //   38: aload_1
      //   39: ifnull +9 -> 48
      //   42: aload_0
      //   43: aload_1
      //   44: invokevirtual 93	com/whatsapp/proto/g$a:a	(Lcom/whatsapp/proto/g;)Lcom/whatsapp/proto/g$a;
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
    
    private g e()
    {
      int i2 = 1;
      g localg = new g(this, (byte)0);
      int i3 = this.b;
      if ((i3 & 0x1) == 1) {}
      for (;;)
      {
        g.a(localg, this.c);
        int i1 = i2;
        if ((i3 & 0x2) == 2) {
          i1 = i2 | 0x2;
        }
        g.a(localg, this.d);
        i2 = i1;
        if ((i3 & 0x4) == 4) {
          i2 = i1 | 0x4;
        }
        g.a(localg, this.e);
        i1 = i2;
        if ((i3 & 0x8) == 8) {
          i1 = i2 | 0x8;
        }
        g.a(localg, this.f);
        i2 = i1;
        if ((i3 & 0x10) == 16) {
          i2 = i1 | 0x10;
        }
        g.a(localg, this.g);
        i1 = i2;
        if ((i3 & 0x20) == 32) {
          i1 = i2 | 0x20;
        }
        g.a(localg, this.h);
        i2 = i1;
        if ((i3 & 0x40) == 64) {
          i2 = i1 | 0x40;
        }
        g.b(localg, this.i);
        i1 = i2;
        if ((i3 & 0x80) == 128) {
          i1 = i2 | 0x80;
        }
        g.c(localg, this.j);
        i2 = i1;
        if ((i3 & 0x100) == 256) {
          i2 = i1 | 0x100;
        }
        g.b(localg, this.k);
        i1 = i2;
        if ((i3 & 0x200) == 512) {
          i1 = i2 | 0x200;
        }
        g.a(localg, this.l);
        i2 = i1;
        if ((i3 & 0x400) == 1024) {
          i2 = i1 | 0x400;
        }
        g.d(localg, this.m);
        i1 = i2;
        if ((i3 & 0x800) == 2048) {
          i1 = i2 | 0x800;
        }
        g.e(localg, this.n);
        i2 = i1;
        if ((i3 & 0x1000) == 4096) {
          i2 = i1 | 0x1000;
        }
        g.f(localg, this.o);
        i1 = i2;
        if ((i3 & 0x2000) == 8192) {
          i1 = i2 | 0x2000;
        }
        g.a(localg, this.p);
        i2 = i1;
        if ((i3 & 0x4000) == 16384) {
          i2 = i1 | 0x4000;
        }
        g.g(localg, this.q);
        g.a(localg, i2);
        return localg;
        i2 = 0;
      }
    }
    
    public final a a(long paramLong)
    {
      this.b |= 0x4;
      this.e = paramLong;
      return this;
    }
    
    public final a a(E2E.Message paramMessage)
    {
      if (paramMessage == null) {
        throw new NullPointerException();
      }
      this.d = paramMessage;
      this.b |= 0x2;
      return this;
    }
    
    public final a a(Protocol.MessageKey paramMessageKey)
    {
      if (paramMessageKey == null) {
        throw new NullPointerException();
      }
      this.c = paramMessageKey;
      this.b |= 0x1;
      return this;
    }
    
    public final a a(g.b paramb)
    {
      if (paramb == null) {
        throw new NullPointerException();
      }
      this.b |= 0x8;
      this.f = paramb;
      return this;
    }
    
    public final a a(g.c paramc)
    {
      if (paramc == null) {
        throw new NullPointerException();
      }
      this.b |= 0x2000;
      this.p = paramc;
      return this;
    }
    
    public final a a(g paramg)
    {
      if (paramg == g.a()) {
        return this;
      }
      Object localObject;
      if (paramg.b())
      {
        localObject = paramg.c;
        if (((this.b & 0x1) == 1) && (this.c != Protocol.MessageKey.getDefaultInstance()))
        {
          this.c = ((Protocol.MessageKey.a)Protocol.MessageKey.newBuilder(this.c).mergeFrom((w)localObject)).buildPartial();
          this.b |= 0x1;
        }
      }
      else
      {
        if (paramg.c())
        {
          localObject = paramg.d;
          if (((this.b & 0x2) != 2) || (this.d == E2E.Message.getDefaultInstance())) {
            break label390;
          }
          this.d = ((E2E.Message.a)E2E.Message.newBuilder(this.d).mergeFrom((w)localObject)).buildPartial();
          label129:
          this.b |= 0x2;
        }
        if (paramg.d()) {
          a(paramg.e);
        }
        if ((paramg.b & 0x8) != 8) {
          break label399;
        }
        i1 = 1;
        label169:
        if (i1 != 0) {
          a(paramg.f);
        }
        if ((paramg.b & 0x10) != 16) {
          break label404;
        }
        i1 = 1;
        label196:
        if (i1 != 0)
        {
          this.b |= 0x10;
          this.g = g.a(paramg);
        }
        if ((paramg.b & 0x20) != 32) {
          break label409;
        }
        i1 = 1;
        label233:
        if (i1 != 0) {
          a(paramg.g);
        }
        if ((paramg.b & 0x40) != 64) {
          break label414;
        }
        i1 = 1;
        label260:
        if (i1 != 0) {
          b(paramg.h);
        }
        if ((paramg.b & 0x80) != 128) {
          break label419;
        }
        i1 = 1;
        label289:
        if (i1 != 0) {
          c(paramg.i);
        }
        if ((paramg.b & 0x100) != 256) {
          break label424;
        }
        i1 = 1;
        label318:
        if (i1 != 0)
        {
          this.b |= 0x100;
          this.k = g.b(paramg);
        }
        if ((paramg.b & 0x200) != 512) {
          break label429;
        }
        i1 = 1;
      }
      for (;;)
      {
        if (i1 != 0)
        {
          localObject = paramg.j;
          if (localObject == null)
          {
            throw new NullPointerException();
            this.c = ((Protocol.MessageKey)localObject);
            break;
            label390:
            this.d = ((E2E.Message)localObject);
            break label129;
            label399:
            i1 = 0;
            break label169;
            label404:
            i1 = 0;
            break label196;
            label409:
            i1 = 0;
            break label233;
            label414:
            i1 = 0;
            break label260;
            label419:
            i1 = 0;
            break label289;
            label424:
            i1 = 0;
            break label318;
            label429:
            i1 = 0;
            continue;
          }
          this.b |= 0x200;
          this.l = ((e)localObject);
        }
      }
      boolean bool;
      if (paramg.e())
      {
        bool = paramg.k;
        this.b |= 0x400;
        this.m = bool;
      }
      if (paramg.f())
      {
        bool = paramg.l;
        this.b |= 0x800;
        this.n = bool;
      }
      if (paramg.g())
      {
        bool = paramg.m;
        this.b |= 0x1000;
        this.o = bool;
      }
      if ((paramg.b & 0x2000) == 8192)
      {
        i1 = 1;
        if (i1 != 0) {
          a(paramg.n);
        }
        if ((paramg.b & 0x4000) != 16384) {
          break label632;
        }
      }
      label632:
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 != 0)
        {
          bool = paramg.o;
          this.b |= 0x4000;
          this.q = bool;
        }
        this.a = this.a.a(g.c(paramg));
        return this;
        i1 = 0;
        break;
      }
    }
    
    public final a a(String paramString)
    {
      if (paramString == null) {
        throw new NullPointerException();
      }
      this.b |= 0x10;
      this.g = paramString;
      return this;
    }
    
    public final a a(boolean paramBoolean)
    {
      this.b |= 0x20;
      this.h = paramBoolean;
      return this;
    }
    
    public final a b(boolean paramBoolean)
    {
      this.b |= 0x40;
      this.i = paramBoolean;
      return this;
    }
    
    public final g b()
    {
      g localg = e();
      if (!localg.isInitialized()) {
        throw new am();
      }
      return localg;
    }
    
    public final a c(boolean paramBoolean)
    {
      this.b |= 0x80;
      this.j = paramBoolean;
      return this;
    }
    
    public final boolean isInitialized()
    {
      if ((this.b & 0x1) == 1) {}
      for (int i1 = 1; i1 == 0; i1 = 0) {
        return false;
      }
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
  
  public static enum c
    implements p.a
  {
    private static f.a<c> e = new f.a() {};
    private final int f;
    
    private c(int paramInt1, int paramInt2)
    {
      this.f = paramInt1;
    }
    
    public static c a(int paramInt)
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
      }
      return d;
    }
    
    public final int getNumber()
    {
      return this.f;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/proto/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */