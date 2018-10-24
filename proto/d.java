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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class d
  extends GeneratedMessageLite
  implements f.a
{
  public static ae<d> a = new c() {};
  private static final d i;
  int b;
  long c;
  boolean d;
  c e;
  public d f;
  int g;
  boolean h;
  private final e j;
  private List<b> k;
  private Object l;
  private byte m = -1;
  private int n = -1;
  
  static
  {
    d locald = new d();
    i = locald;
    locald.d();
  }
  
  private d()
  {
    this.j = e.b;
  }
  
  private d(GeneratedMessageLite.a parama)
  {
    super((byte)0);
    this.j = parama.a;
  }
  
  /* Error */
  private d(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 87	com/google/protobuf/GeneratedMessageLite:<init>	()V
    //   4: aload_0
    //   5: iconst_m1
    //   6: putfield 89	com/whatsapp/proto/d:m	B
    //   9: aload_0
    //   10: iconst_m1
    //   11: putfield 91	com/whatsapp/proto/d:n	I
    //   14: aload_0
    //   15: invokespecial 85	com/whatsapp/proto/d:d	()V
    //   18: invokestatic 116	com/google/protobuf/e:h	()Lcom/google/protobuf/e$c;
    //   21: astore 12
    //   23: aload 12
    //   25: sipush 4096
    //   28: invokestatic 121	com/google/protobuf/g:a	(Ljava/io/OutputStream;I)Lcom/google/protobuf/g;
    //   31: astore 13
    //   33: iconst_0
    //   34: istore 8
    //   36: iconst_0
    //   37: istore 4
    //   39: iload 8
    //   41: ifne +1084 -> 1125
    //   44: iload 4
    //   46: istore 5
    //   48: iload 4
    //   50: istore_3
    //   51: iload 4
    //   53: istore 6
    //   55: aload_1
    //   56: invokevirtual 126	com/google/protobuf/f:a	()I
    //   59: istore 9
    //   61: iload 9
    //   63: lookupswitch	default:+1156->1219, 0:+1159->1222, 8:+117->180, 24:+209->272, 32:+281->344, 34:+430->493, 42:+638->701, 50:+775->838, 58:+915->978, 77:+974->1037, 80:+1018->1081
    //   152: iload 4
    //   154: istore 5
    //   156: iload 4
    //   158: istore_3
    //   159: iload 4
    //   161: istore 6
    //   163: aload_1
    //   164: iload 9
    //   166: aload 13
    //   168: invokevirtual 129	com/google/protobuf/f:a	(ILcom/google/protobuf/g;)Z
    //   171: ifne -132 -> 39
    //   174: iconst_1
    //   175: istore 8
    //   177: goto -138 -> 39
    //   180: iload 4
    //   182: istore 5
    //   184: iload 4
    //   186: istore_3
    //   187: iload 4
    //   189: istore 6
    //   191: aload_0
    //   192: aload_0
    //   193: getfield 131	com/whatsapp/proto/d:b	I
    //   196: iconst_1
    //   197: ior
    //   198: putfield 131	com/whatsapp/proto/d:b	I
    //   201: iload 4
    //   203: istore 5
    //   205: iload 4
    //   207: istore_3
    //   208: iload 4
    //   210: istore 6
    //   212: aload_0
    //   213: aload_1
    //   214: invokevirtual 134	com/google/protobuf/f:g	()J
    //   217: putfield 136	com/whatsapp/proto/d:c	J
    //   220: goto -181 -> 39
    //   223: astore_1
    //   224: iload 5
    //   226: istore_3
    //   227: aload_1
    //   228: aload_0
    //   229: putfield 139	com/google/protobuf/q:a	Lcom/google/protobuf/x;
    //   232: iload 5
    //   234: istore_3
    //   235: aload_1
    //   236: athrow
    //   237: astore_1
    //   238: iload_3
    //   239: iconst_4
    //   240: iand
    //   241: iconst_4
    //   242: if_icmpne +14 -> 256
    //   245: aload_0
    //   246: aload_0
    //   247: getfield 141	com/whatsapp/proto/d:k	Ljava/util/List;
    //   250: invokestatic 147	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   253: putfield 141	com/whatsapp/proto/d:k	Ljava/util/List;
    //   256: aload 13
    //   258: invokevirtual 149	com/google/protobuf/g:a	()V
    //   261: aload_0
    //   262: aload 12
    //   264: invokevirtual 154	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   267: putfield 97	com/whatsapp/proto/d:j	Lcom/google/protobuf/e;
    //   270: aload_1
    //   271: athrow
    //   272: iload 4
    //   274: istore 5
    //   276: iload 4
    //   278: istore_3
    //   279: iload 4
    //   281: istore 6
    //   283: aload_0
    //   284: aload_0
    //   285: getfield 131	com/whatsapp/proto/d:b	I
    //   288: iconst_2
    //   289: ior
    //   290: putfield 131	com/whatsapp/proto/d:b	I
    //   293: iload 4
    //   295: istore 5
    //   297: iload 4
    //   299: istore_3
    //   300: iload 4
    //   302: istore 6
    //   304: aload_0
    //   305: aload_1
    //   306: invokevirtual 157	com/google/protobuf/f:c	()Z
    //   309: putfield 159	com/whatsapp/proto/d:d	Z
    //   312: goto -273 -> 39
    //   315: astore_1
    //   316: iload 6
    //   318: istore_3
    //   319: new 111	com/google/protobuf/q
    //   322: dup
    //   323: aload_1
    //   324: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   327: invokespecial 166	com/google/protobuf/q:<init>	(Ljava/lang/String;)V
    //   330: astore_1
    //   331: iload 6
    //   333: istore_3
    //   334: aload_1
    //   335: aload_0
    //   336: putfield 139	com/google/protobuf/q:a	Lcom/google/protobuf/x;
    //   339: iload 6
    //   341: istore_3
    //   342: aload_1
    //   343: athrow
    //   344: iload 4
    //   346: istore 5
    //   348: iload 4
    //   350: istore_3
    //   351: iload 4
    //   353: istore 6
    //   355: aload_1
    //   356: invokevirtual 168	com/google/protobuf/f:f	()I
    //   359: istore 7
    //   361: iload 4
    //   363: istore 5
    //   365: iload 4
    //   367: istore_3
    //   368: iload 4
    //   370: istore 6
    //   372: iload 7
    //   374: invokestatic 171	com/whatsapp/proto/d$b:a	(I)Lcom/whatsapp/proto/d$b;
    //   377: astore 11
    //   379: aload 11
    //   381: ifnonnull +42 -> 423
    //   384: iload 4
    //   386: istore 5
    //   388: iload 4
    //   390: istore_3
    //   391: iload 4
    //   393: istore 6
    //   395: aload 13
    //   397: iload 9
    //   399: invokevirtual 174	com/google/protobuf/g:e	(I)V
    //   402: iload 4
    //   404: istore 5
    //   406: iload 4
    //   408: istore_3
    //   409: iload 4
    //   411: istore 6
    //   413: aload 13
    //   415: iload 7
    //   417: invokevirtual 174	com/google/protobuf/g:e	(I)V
    //   420: goto -381 -> 39
    //   423: iload 4
    //   425: istore 7
    //   427: iload 4
    //   429: iconst_4
    //   430: iand
    //   431: iconst_4
    //   432: if_icmpeq +31 -> 463
    //   435: iload 4
    //   437: istore 5
    //   439: iload 4
    //   441: istore_3
    //   442: iload 4
    //   444: istore 6
    //   446: aload_0
    //   447: new 176	java/util/ArrayList
    //   450: dup
    //   451: invokespecial 177	java/util/ArrayList:<init>	()V
    //   454: putfield 141	com/whatsapp/proto/d:k	Ljava/util/List;
    //   457: iload 4
    //   459: iconst_4
    //   460: ior
    //   461: istore 7
    //   463: iload 7
    //   465: istore 5
    //   467: iload 7
    //   469: istore_3
    //   470: iload 7
    //   472: istore 6
    //   474: aload_0
    //   475: getfield 141	com/whatsapp/proto/d:k	Ljava/util/List;
    //   478: aload 11
    //   480: invokeinterface 183 2 0
    //   485: pop
    //   486: iload 7
    //   488: istore 4
    //   490: goto -451 -> 39
    //   493: iload 4
    //   495: istore 5
    //   497: iload 4
    //   499: istore_3
    //   500: iload 4
    //   502: istore 6
    //   504: aload_1
    //   505: aload_1
    //   506: invokevirtual 168	com/google/protobuf/f:f	()I
    //   509: invokevirtual 186	com/google/protobuf/f:c	(I)I
    //   512: istore 10
    //   514: iload 4
    //   516: istore 5
    //   518: iload 4
    //   520: istore_3
    //   521: iload 4
    //   523: istore 6
    //   525: aload_1
    //   526: invokevirtual 188	com/google/protobuf/f:j	()I
    //   529: ifle +152 -> 681
    //   532: iload 4
    //   534: istore 5
    //   536: iload 4
    //   538: istore_3
    //   539: iload 4
    //   541: istore 6
    //   543: aload_1
    //   544: invokevirtual 168	com/google/protobuf/f:f	()I
    //   547: istore 7
    //   549: iload 4
    //   551: istore 5
    //   553: iload 4
    //   555: istore_3
    //   556: iload 4
    //   558: istore 6
    //   560: iload 7
    //   562: invokestatic 171	com/whatsapp/proto/d$b:a	(I)Lcom/whatsapp/proto/d$b;
    //   565: astore 11
    //   567: aload 11
    //   569: ifnonnull +42 -> 611
    //   572: iload 4
    //   574: istore 5
    //   576: iload 4
    //   578: istore_3
    //   579: iload 4
    //   581: istore 6
    //   583: aload 13
    //   585: iload 9
    //   587: invokevirtual 174	com/google/protobuf/g:e	(I)V
    //   590: iload 4
    //   592: istore 5
    //   594: iload 4
    //   596: istore_3
    //   597: iload 4
    //   599: istore 6
    //   601: aload 13
    //   603: iload 7
    //   605: invokevirtual 174	com/google/protobuf/g:e	(I)V
    //   608: goto -94 -> 514
    //   611: iload 4
    //   613: istore 7
    //   615: iload 4
    //   617: iconst_4
    //   618: iand
    //   619: iconst_4
    //   620: if_icmpeq +31 -> 651
    //   623: iload 4
    //   625: istore 5
    //   627: iload 4
    //   629: istore_3
    //   630: iload 4
    //   632: istore 6
    //   634: aload_0
    //   635: new 176	java/util/ArrayList
    //   638: dup
    //   639: invokespecial 177	java/util/ArrayList:<init>	()V
    //   642: putfield 141	com/whatsapp/proto/d:k	Ljava/util/List;
    //   645: iload 4
    //   647: iconst_4
    //   648: ior
    //   649: istore 7
    //   651: iload 7
    //   653: istore 5
    //   655: iload 7
    //   657: istore_3
    //   658: iload 7
    //   660: istore 6
    //   662: aload_0
    //   663: getfield 141	com/whatsapp/proto/d:k	Ljava/util/List;
    //   666: aload 11
    //   668: invokeinterface 183 2 0
    //   673: pop
    //   674: iload 7
    //   676: istore 4
    //   678: goto -164 -> 514
    //   681: iload 4
    //   683: istore 5
    //   685: iload 4
    //   687: istore_3
    //   688: iload 4
    //   690: istore 6
    //   692: aload_1
    //   693: iload 10
    //   695: invokevirtual 190	com/google/protobuf/f:d	(I)V
    //   698: goto -659 -> 39
    //   701: iload 4
    //   703: istore 5
    //   705: iload 4
    //   707: istore_3
    //   708: iload 4
    //   710: istore 6
    //   712: aload_0
    //   713: getfield 131	com/whatsapp/proto/d:b	I
    //   716: iconst_4
    //   717: iand
    //   718: iconst_4
    //   719: if_icmpne +494 -> 1213
    //   722: iload 4
    //   724: istore 5
    //   726: iload 4
    //   728: istore_3
    //   729: iload 4
    //   731: istore 6
    //   733: aload_0
    //   734: getfield 192	com/whatsapp/proto/d:e	Lcom/whatsapp/proto/d$c;
    //   737: invokestatic 195	com/whatsapp/proto/d$c:a	(Lcom/whatsapp/proto/d$c;)Lcom/whatsapp/proto/d$c$b;
    //   740: astore 11
    //   742: iload 4
    //   744: istore 5
    //   746: iload 4
    //   748: istore_3
    //   749: iload 4
    //   751: istore 6
    //   753: aload_0
    //   754: aload_1
    //   755: getstatic 196	com/whatsapp/proto/d$c:a	Lcom/google/protobuf/ae;
    //   758: aload_2
    //   759: invokevirtual 199	com/google/protobuf/f:a	(Lcom/google/protobuf/ae;Lcom/google/protobuf/m;)Lcom/google/protobuf/x;
    //   762: checkcast 18	com/whatsapp/proto/d$c
    //   765: putfield 192	com/whatsapp/proto/d:e	Lcom/whatsapp/proto/d$c;
    //   768: aload 11
    //   770: ifnull +44 -> 814
    //   773: iload 4
    //   775: istore 5
    //   777: iload 4
    //   779: istore_3
    //   780: iload 4
    //   782: istore 6
    //   784: aload 11
    //   786: aload_0
    //   787: getfield 192	com/whatsapp/proto/d:e	Lcom/whatsapp/proto/d$c;
    //   790: invokevirtual 200	com/whatsapp/proto/d$c$b:a	(Lcom/whatsapp/proto/d$c;)Lcom/whatsapp/proto/d$c$b;
    //   793: pop
    //   794: iload 4
    //   796: istore 5
    //   798: iload 4
    //   800: istore_3
    //   801: iload 4
    //   803: istore 6
    //   805: aload_0
    //   806: aload 11
    //   808: invokevirtual 203	com/whatsapp/proto/d$c$b:c	()Lcom/whatsapp/proto/d$c;
    //   811: putfield 192	com/whatsapp/proto/d:e	Lcom/whatsapp/proto/d$c;
    //   814: iload 4
    //   816: istore 5
    //   818: iload 4
    //   820: istore_3
    //   821: iload 4
    //   823: istore 6
    //   825: aload_0
    //   826: aload_0
    //   827: getfield 131	com/whatsapp/proto/d:b	I
    //   830: iconst_4
    //   831: ior
    //   832: putfield 131	com/whatsapp/proto/d:b	I
    //   835: goto -796 -> 39
    //   838: iload 4
    //   840: istore 5
    //   842: iload 4
    //   844: istore_3
    //   845: iload 4
    //   847: istore 6
    //   849: aload_0
    //   850: getfield 131	com/whatsapp/proto/d:b	I
    //   853: bipush 8
    //   855: iand
    //   856: bipush 8
    //   858: if_icmpne +349 -> 1207
    //   861: iload 4
    //   863: istore 5
    //   865: iload 4
    //   867: istore_3
    //   868: iload 4
    //   870: istore 6
    //   872: aload_0
    //   873: getfield 205	com/whatsapp/proto/d:f	Lcom/whatsapp/proto/d$d;
    //   876: invokestatic 208	com/whatsapp/proto/d$d:a	(Lcom/whatsapp/proto/d$d;)Lcom/whatsapp/proto/d$d$a;
    //   879: astore 11
    //   881: iload 4
    //   883: istore 5
    //   885: iload 4
    //   887: istore_3
    //   888: iload 4
    //   890: istore 6
    //   892: aload_0
    //   893: aload_1
    //   894: getstatic 209	com/whatsapp/proto/d$d:a	Lcom/google/protobuf/ae;
    //   897: aload_2
    //   898: invokevirtual 199	com/google/protobuf/f:a	(Lcom/google/protobuf/ae;Lcom/google/protobuf/m;)Lcom/google/protobuf/x;
    //   901: checkcast 40	com/whatsapp/proto/d$d
    //   904: putfield 205	com/whatsapp/proto/d:f	Lcom/whatsapp/proto/d$d;
    //   907: aload 11
    //   909: ifnull +44 -> 953
    //   912: iload 4
    //   914: istore 5
    //   916: iload 4
    //   918: istore_3
    //   919: iload 4
    //   921: istore 6
    //   923: aload 11
    //   925: aload_0
    //   926: getfield 205	com/whatsapp/proto/d:f	Lcom/whatsapp/proto/d$d;
    //   929: invokevirtual 210	com/whatsapp/proto/d$d$a:a	(Lcom/whatsapp/proto/d$d;)Lcom/whatsapp/proto/d$d$a;
    //   932: pop
    //   933: iload 4
    //   935: istore 5
    //   937: iload 4
    //   939: istore_3
    //   940: iload 4
    //   942: istore 6
    //   944: aload_0
    //   945: aload 11
    //   947: invokevirtual 213	com/whatsapp/proto/d$d$a:c	()Lcom/whatsapp/proto/d$d;
    //   950: putfield 205	com/whatsapp/proto/d:f	Lcom/whatsapp/proto/d$d;
    //   953: iload 4
    //   955: istore 5
    //   957: iload 4
    //   959: istore_3
    //   960: iload 4
    //   962: istore 6
    //   964: aload_0
    //   965: aload_0
    //   966: getfield 131	com/whatsapp/proto/d:b	I
    //   969: bipush 8
    //   971: ior
    //   972: putfield 131	com/whatsapp/proto/d:b	I
    //   975: goto -936 -> 39
    //   978: iload 4
    //   980: istore 5
    //   982: iload 4
    //   984: istore_3
    //   985: iload 4
    //   987: istore 6
    //   989: aload_1
    //   990: invokevirtual 215	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
    //   993: astore 11
    //   995: iload 4
    //   997: istore 5
    //   999: iload 4
    //   1001: istore_3
    //   1002: iload 4
    //   1004: istore 6
    //   1006: aload_0
    //   1007: aload_0
    //   1008: getfield 131	com/whatsapp/proto/d:b	I
    //   1011: bipush 16
    //   1013: ior
    //   1014: putfield 131	com/whatsapp/proto/d:b	I
    //   1017: iload 4
    //   1019: istore 5
    //   1021: iload 4
    //   1023: istore_3
    //   1024: iload 4
    //   1026: istore 6
    //   1028: aload_0
    //   1029: aload 11
    //   1031: putfield 217	com/whatsapp/proto/d:l	Ljava/lang/Object;
    //   1034: goto -995 -> 39
    //   1037: iload 4
    //   1039: istore 5
    //   1041: iload 4
    //   1043: istore_3
    //   1044: iload 4
    //   1046: istore 6
    //   1048: aload_0
    //   1049: aload_0
    //   1050: getfield 131	com/whatsapp/proto/d:b	I
    //   1053: bipush 32
    //   1055: ior
    //   1056: putfield 131	com/whatsapp/proto/d:b	I
    //   1059: iload 4
    //   1061: istore 5
    //   1063: iload 4
    //   1065: istore_3
    //   1066: iload 4
    //   1068: istore 6
    //   1070: aload_0
    //   1071: aload_1
    //   1072: invokevirtual 219	com/google/protobuf/f:h	()I
    //   1075: putfield 221	com/whatsapp/proto/d:g	I
    //   1078: goto -1039 -> 39
    //   1081: iload 4
    //   1083: istore 5
    //   1085: iload 4
    //   1087: istore_3
    //   1088: iload 4
    //   1090: istore 6
    //   1092: aload_0
    //   1093: aload_0
    //   1094: getfield 131	com/whatsapp/proto/d:b	I
    //   1097: bipush 64
    //   1099: ior
    //   1100: putfield 131	com/whatsapp/proto/d:b	I
    //   1103: iload 4
    //   1105: istore 5
    //   1107: iload 4
    //   1109: istore_3
    //   1110: iload 4
    //   1112: istore 6
    //   1114: aload_0
    //   1115: aload_1
    //   1116: invokevirtual 157	com/google/protobuf/f:c	()Z
    //   1119: putfield 223	com/whatsapp/proto/d:h	Z
    //   1122: goto -1083 -> 39
    //   1125: iload 4
    //   1127: iconst_4
    //   1128: iand
    //   1129: iconst_4
    //   1130: if_icmpne +14 -> 1144
    //   1133: aload_0
    //   1134: aload_0
    //   1135: getfield 141	com/whatsapp/proto/d:k	Ljava/util/List;
    //   1138: invokestatic 147	java/util/Collections:unmodifiableList	(Ljava/util/List;)Ljava/util/List;
    //   1141: putfield 141	com/whatsapp/proto/d:k	Ljava/util/List;
    //   1144: aload 13
    //   1146: invokevirtual 149	com/google/protobuf/g:a	()V
    //   1149: aload_0
    //   1150: aload 12
    //   1152: invokevirtual 154	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   1155: putfield 97	com/whatsapp/proto/d:j	Lcom/google/protobuf/e;
    //   1158: return
    //   1159: astore_1
    //   1160: aload_0
    //   1161: aload 12
    //   1163: invokevirtual 154	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   1166: putfield 97	com/whatsapp/proto/d:j	Lcom/google/protobuf/e;
    //   1169: return
    //   1170: astore_1
    //   1171: aload_0
    //   1172: aload 12
    //   1174: invokevirtual 154	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   1177: putfield 97	com/whatsapp/proto/d:j	Lcom/google/protobuf/e;
    //   1180: aload_1
    //   1181: athrow
    //   1182: astore_2
    //   1183: aload_0
    //   1184: aload 12
    //   1186: invokevirtual 154	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   1189: putfield 97	com/whatsapp/proto/d:j	Lcom/google/protobuf/e;
    //   1192: goto -922 -> 270
    //   1195: astore_1
    //   1196: aload_0
    //   1197: aload 12
    //   1199: invokevirtual 154	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
    //   1202: putfield 97	com/whatsapp/proto/d:j	Lcom/google/protobuf/e;
    //   1205: aload_1
    //   1206: athrow
    //   1207: aconst_null
    //   1208: astore 11
    //   1210: goto -329 -> 881
    //   1213: aconst_null
    //   1214: astore 11
    //   1216: goto -474 -> 742
    //   1219: goto -1067 -> 152
    //   1222: iconst_1
    //   1223: istore 8
    //   1225: goto -1186 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1228	0	this	d
    //   0	1228	1	paramf	com.google.protobuf.f
    //   0	1228	2	paramm	com.google.protobuf.m
    //   50	1060	3	i1	int
    //   37	1092	4	i2	int
    //   46	1060	5	i3	int
    //   53	1060	6	i4	int
    //   359	316	7	i5	int
    //   34	1190	8	i6	int
    //   59	527	9	i7	int
    //   512	182	10	i8	int
    //   377	838	11	localObject	Object
    //   21	1177	12	localc	com.google.protobuf.e.c
    //   31	1114	13	localg	g
    // Exception table:
    //   from	to	target	type
    //   55	61	223	com/google/protobuf/q
    //   163	174	223	com/google/protobuf/q
    //   191	201	223	com/google/protobuf/q
    //   212	220	223	com/google/protobuf/q
    //   283	293	223	com/google/protobuf/q
    //   304	312	223	com/google/protobuf/q
    //   355	361	223	com/google/protobuf/q
    //   372	379	223	com/google/protobuf/q
    //   395	402	223	com/google/protobuf/q
    //   413	420	223	com/google/protobuf/q
    //   446	457	223	com/google/protobuf/q
    //   474	486	223	com/google/protobuf/q
    //   504	514	223	com/google/protobuf/q
    //   525	532	223	com/google/protobuf/q
    //   543	549	223	com/google/protobuf/q
    //   560	567	223	com/google/protobuf/q
    //   583	590	223	com/google/protobuf/q
    //   601	608	223	com/google/protobuf/q
    //   634	645	223	com/google/protobuf/q
    //   662	674	223	com/google/protobuf/q
    //   692	698	223	com/google/protobuf/q
    //   712	722	223	com/google/protobuf/q
    //   733	742	223	com/google/protobuf/q
    //   753	768	223	com/google/protobuf/q
    //   784	794	223	com/google/protobuf/q
    //   805	814	223	com/google/protobuf/q
    //   825	835	223	com/google/protobuf/q
    //   849	861	223	com/google/protobuf/q
    //   872	881	223	com/google/protobuf/q
    //   892	907	223	com/google/protobuf/q
    //   923	933	223	com/google/protobuf/q
    //   944	953	223	com/google/protobuf/q
    //   964	975	223	com/google/protobuf/q
    //   989	995	223	com/google/protobuf/q
    //   1006	1017	223	com/google/protobuf/q
    //   1028	1034	223	com/google/protobuf/q
    //   1048	1059	223	com/google/protobuf/q
    //   1070	1078	223	com/google/protobuf/q
    //   1092	1103	223	com/google/protobuf/q
    //   1114	1122	223	com/google/protobuf/q
    //   55	61	237	finally
    //   163	174	237	finally
    //   191	201	237	finally
    //   212	220	237	finally
    //   227	232	237	finally
    //   235	237	237	finally
    //   283	293	237	finally
    //   304	312	237	finally
    //   319	331	237	finally
    //   334	339	237	finally
    //   342	344	237	finally
    //   355	361	237	finally
    //   372	379	237	finally
    //   395	402	237	finally
    //   413	420	237	finally
    //   446	457	237	finally
    //   474	486	237	finally
    //   504	514	237	finally
    //   525	532	237	finally
    //   543	549	237	finally
    //   560	567	237	finally
    //   583	590	237	finally
    //   601	608	237	finally
    //   634	645	237	finally
    //   662	674	237	finally
    //   692	698	237	finally
    //   712	722	237	finally
    //   733	742	237	finally
    //   753	768	237	finally
    //   784	794	237	finally
    //   805	814	237	finally
    //   825	835	237	finally
    //   849	861	237	finally
    //   872	881	237	finally
    //   892	907	237	finally
    //   923	933	237	finally
    //   944	953	237	finally
    //   964	975	237	finally
    //   989	995	237	finally
    //   1006	1017	237	finally
    //   1028	1034	237	finally
    //   1048	1059	237	finally
    //   1070	1078	237	finally
    //   1092	1103	237	finally
    //   1114	1122	237	finally
    //   55	61	315	java/io/IOException
    //   163	174	315	java/io/IOException
    //   191	201	315	java/io/IOException
    //   212	220	315	java/io/IOException
    //   283	293	315	java/io/IOException
    //   304	312	315	java/io/IOException
    //   355	361	315	java/io/IOException
    //   372	379	315	java/io/IOException
    //   395	402	315	java/io/IOException
    //   413	420	315	java/io/IOException
    //   446	457	315	java/io/IOException
    //   474	486	315	java/io/IOException
    //   504	514	315	java/io/IOException
    //   525	532	315	java/io/IOException
    //   543	549	315	java/io/IOException
    //   560	567	315	java/io/IOException
    //   583	590	315	java/io/IOException
    //   601	608	315	java/io/IOException
    //   634	645	315	java/io/IOException
    //   662	674	315	java/io/IOException
    //   692	698	315	java/io/IOException
    //   712	722	315	java/io/IOException
    //   733	742	315	java/io/IOException
    //   753	768	315	java/io/IOException
    //   784	794	315	java/io/IOException
    //   805	814	315	java/io/IOException
    //   825	835	315	java/io/IOException
    //   849	861	315	java/io/IOException
    //   872	881	315	java/io/IOException
    //   892	907	315	java/io/IOException
    //   923	933	315	java/io/IOException
    //   944	953	315	java/io/IOException
    //   964	975	315	java/io/IOException
    //   989	995	315	java/io/IOException
    //   1006	1017	315	java/io/IOException
    //   1028	1034	315	java/io/IOException
    //   1048	1059	315	java/io/IOException
    //   1070	1078	315	java/io/IOException
    //   1092	1103	315	java/io/IOException
    //   1114	1122	315	java/io/IOException
    //   1144	1149	1159	java/io/IOException
    //   1144	1149	1170	finally
    //   256	261	1182	java/io/IOException
    //   256	261	1195	finally
  }
  
  public static d a()
  {
    return i;
  }
  
  public static a b()
  {
    return a.c();
  }
  
  private e c()
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
  
  private void d()
  {
    this.c = 0L;
    this.d = false;
    this.k = Collections.emptyList();
    this.e = c.a();
    this.f = d.a();
    this.l = "";
    this.g = 0;
    this.h = false;
  }
  
  public final ae<d> getParserForType()
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
    for (i1 = g.c(1, this.c) + 0;; i1 = 0)
    {
      if ((this.b & 0x2) == 2) {
        i1 += g.d(3) + 1;
      }
      for (;;)
      {
        int i4;
        for (int i2 = 0; i3 < this.k.size(); i2 = i4 + i2)
        {
          i4 = g.c(((b)this.k.get(i3)).getNumber());
          i3 += 1;
        }
        i2 = i1 + i2 + this.k.size() * 1;
        i1 = i2;
        if ((this.b & 0x4) == 4) {
          i1 = i2 + g.d(5, this.e);
        }
        i2 = i1;
        if ((this.b & 0x8) == 8) {
          i2 = i1 + g.d(6, this.f);
        }
        i1 = i2;
        if ((this.b & 0x10) == 16) {
          i1 = i2 + g.c(7, c());
        }
        i2 = i1;
        if ((this.b & 0x20) == 32) {
          i2 = i1 + (g.d(9) + 4);
        }
        i1 = i2;
        if ((this.b & 0x40) == 64) {
          i1 = i2 + (g.d(10) + 1);
        }
        i1 += this.j.a();
        this.n = i1;
        return i1;
      }
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
      paramg.a(3, this.d);
    }
    int i1 = 0;
    while (i1 < this.k.size())
    {
      paramg.c(4, ((b)this.k.get(i1)).getNumber());
      i1 += 1;
    }
    if ((this.b & 0x4) == 4) {
      paramg.b(5, this.e);
    }
    if ((this.b & 0x8) == 8) {
      paramg.b(6, this.f);
    }
    if ((this.b & 0x10) == 16) {
      paramg.a(7, c());
    }
    if ((this.b & 0x20) == 32)
    {
      i1 = this.g;
      paramg.g(9, 5);
      paramg.g(i1);
    }
    if ((this.b & 0x40) == 64) {
      paramg.a(10, this.h);
    }
    paramg.c(this.j);
  }
  
  public static final class a
    extends GeneratedMessageLite.a<d, a>
    implements f.a
  {
    public int b;
    public d.c c = d.c.a();
    public d.d d = d.d.a();
    public Object e = "";
    private long f;
    private boolean g;
    private List<d.b> h = Collections.emptyList();
    private int i;
    private boolean j;
    
    /* Error */
    private a a(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
    {
      // Byte code:
      //   0: getstatic 64	com/whatsapp/proto/d:a	Lcom/google/protobuf/ae;
      //   3: aload_1
      //   4: aload_2
      //   5: invokeinterface 69 3 0
      //   10: checkcast 9	com/whatsapp/proto/d
      //   13: astore_1
      //   14: aload_1
      //   15: ifnull +9 -> 24
      //   18: aload_0
      //   19: aload_1
      //   20: invokevirtual 72	com/whatsapp/proto/d$a:a	(Lcom/whatsapp/proto/d;)Lcom/whatsapp/proto/d$a;
      //   23: pop
      //   24: aload_0
      //   25: areturn
      //   26: astore_2
      //   27: aload_2
      //   28: getfield 75	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   31: checkcast 9	com/whatsapp/proto/d
      //   34: astore_1
      //   35: aload_2
      //   36: athrow
      //   37: astore_2
      //   38: aload_1
      //   39: ifnull +9 -> 48
      //   42: aload_0
      //   43: aload_1
      //   44: invokevirtual 72	com/whatsapp/proto/d$a:a	(Lcom/whatsapp/proto/d;)Lcom/whatsapp/proto/d$a;
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
    
    private d e()
    {
      int m = 1;
      d locald = new d(this, (byte)0);
      int n = this.b;
      if ((n & 0x1) == 1) {}
      for (;;)
      {
        d.a(locald, this.f);
        int k = m;
        if ((n & 0x2) == 2) {
          k = m | 0x2;
        }
        d.a(locald, this.g);
        if ((this.b & 0x4) == 4)
        {
          this.h = Collections.unmodifiableList(this.h);
          this.b &= 0xFFFFFFFB;
        }
        d.a(locald, this.h);
        m = k;
        if ((n & 0x8) == 8) {
          m = k | 0x4;
        }
        d.a(locald, this.c);
        k = m;
        if ((n & 0x10) == 16) {
          k = m | 0x8;
        }
        d.a(locald, this.d);
        m = k;
        if ((n & 0x20) == 32) {
          m = k | 0x10;
        }
        d.a(locald, this.e);
        k = m;
        if ((n & 0x40) == 64) {
          k = m | 0x20;
        }
        d.a(locald, this.i);
        m = k;
        if ((n & 0x80) == 128) {
          m = k | 0x40;
        }
        d.b(locald, this.j);
        d.b(locald, m);
        return locald;
        m = 0;
      }
    }
    
    public final a a(int paramInt)
    {
      this.b |= 0x40;
      this.i = paramInt;
      return this;
    }
    
    public final a a(long paramLong)
    {
      this.b |= 0x1;
      this.f = paramLong;
      return this;
    }
    
    public final a a(d paramd)
    {
      int m = 1;
      if (paramd == d.a()) {
        return this;
      }
      label48:
      label104:
      label116:
      Object localObject;
      if ((paramd.b & 0x1) == 1)
      {
        k = 1;
        if (k != 0) {
          a(paramd.c);
        }
        if ((paramd.b & 0x2) != 2) {
          break label367;
        }
        k = 1;
        if (k != 0) {
          a(paramd.d);
        }
        if (!d.a(paramd).isEmpty())
        {
          if (!this.h.isEmpty()) {
            break label372;
          }
          this.h = d.a(paramd);
          this.b &= 0xFFFFFFFB;
        }
        if ((paramd.b & 0x4) != 4) {
          break label424;
        }
        k = 1;
        if (k != 0)
        {
          localObject = paramd.e;
          if (((this.b & 0x8) != 8) || (this.c == d.c.a())) {
            break label429;
          }
          this.c = d.c.a(this.c).a((d.c)localObject).c();
          label167:
          this.b |= 0x8;
        }
        if ((paramd.b & 0x8) != 8) {
          break label438;
        }
        k = 1;
        label192:
        if (k != 0)
        {
          localObject = paramd.f;
          if (((this.b & 0x10) != 16) || (this.d == d.d.a())) {
            break label443;
          }
          this.d = d.d.a(this.d).a((d.d)localObject).c();
          label243:
          this.b |= 0x10;
        }
        if ((paramd.b & 0x10) != 16) {
          break label452;
        }
        k = 1;
        label268:
        if (k != 0)
        {
          this.b |= 0x20;
          this.e = d.b(paramd);
        }
        if ((paramd.b & 0x20) != 32) {
          break label457;
        }
        k = 1;
        label305:
        if (k != 0) {
          a(paramd.g);
        }
        if ((paramd.b & 0x40) != 64) {
          break label462;
        }
      }
      label367:
      label372:
      label424:
      label429:
      label438:
      label443:
      label452:
      label457:
      label462:
      for (int k = m;; k = 0)
      {
        if (k != 0) {
          b(paramd.h);
        }
        this.a = this.a.a(d.c(paramd));
        return this;
        k = 0;
        break;
        k = 0;
        break label48;
        if ((this.b & 0x4) != 4)
        {
          this.h = new ArrayList(this.h);
          this.b |= 0x4;
        }
        this.h.addAll(d.a(paramd));
        break label104;
        k = 0;
        break label116;
        this.c = ((d.c)localObject);
        break label167;
        k = 0;
        break label192;
        this.d = ((d.d)localObject);
        break label243;
        k = 0;
        break label268;
        k = 0;
        break label305;
      }
    }
    
    public final a a(boolean paramBoolean)
    {
      this.b |= 0x2;
      this.g = paramBoolean;
      return this;
    }
    
    public final a b(boolean paramBoolean)
    {
      this.b |= 0x80;
      this.j = paramBoolean;
      return this;
    }
    
    public final d b()
    {
      d locald = e();
      if (!locald.isInitialized()) {
        throw new am();
      }
      return locald;
    }
    
    public final boolean isInitialized()
    {
      return true;
    }
  }
  
  public static enum b
    implements p.a
  {
    private static f.a<b> b = new f.a() {};
    private final int c = 0;
    
    private b(int paramInt) {}
    
    public static b a(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      }
      return a;
    }
    
    public final int getNumber()
    {
      return this.c;
    }
  }
  
  public static final class c
    extends GeneratedMessageLite
    implements f.a
  {
    public static ae<c> a = new c() {};
    private static final c f;
    int b;
    c c;
    a d;
    d e;
    private final e g;
    private Object h;
    private Object i;
    private Object j;
    private Object k;
    private Object l;
    private Object m;
    private Object n;
    private Object o;
    private Object p;
    private byte q = -1;
    private int r = -1;
    
    static
    {
      c localc = new c();
      f = localc;
      localc.k();
    }
    
    private c()
    {
      this.g = e.b;
    }
    
    private c(GeneratedMessageLite.a parama)
    {
      super();
      this.g = parama.a;
    }
    
    /* Error */
    private c(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 68	com/google/protobuf/GeneratedMessageLite:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 70	com/whatsapp/proto/d$c:q	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 72	com/whatsapp/proto/d$c:r	I
      //   14: aload_0
      //   15: invokespecial 66	com/whatsapp/proto/d$c:k	()V
      //   18: invokestatic 97	com/google/protobuf/e:h	()Lcom/google/protobuf/e$c;
      //   21: astore 7
      //   23: aload 7
      //   25: sipush 4096
      //   28: invokestatic 102	com/google/protobuf/g:a	(Ljava/io/OutputStream;I)Lcom/google/protobuf/g;
      //   31: astore 8
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +603 -> 639
      //   39: aload_1
      //   40: invokevirtual 107	com/google/protobuf/f:a	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+661->708, 0:+664->711, 8:+129->176, 18:+228->275, 26:+299->346, 34:+324->371, 42:+350->397, 50:+376->423, 58:+402->449, 66:+428->475, 74:+455->502, 80:+482->529, 90:+538->585, 98:+565->612
      //   160: aload_1
      //   161: iload 4
      //   163: aload 8
      //   165: invokevirtual 110	com/google/protobuf/f:a	(ILcom/google/protobuf/g;)Z
      //   168: ifne -133 -> 35
      //   171: iconst_1
      //   172: istore_3
      //   173: goto -138 -> 35
      //   176: aload_1
      //   177: invokevirtual 112	com/google/protobuf/f:f	()I
      //   180: istore 5
      //   182: iload 5
      //   184: invokestatic 115	com/whatsapp/proto/d$c$c:a	(I)Lcom/whatsapp/proto/d$c$c;
      //   187: astore 6
      //   189: aload 6
      //   191: ifnonnull +45 -> 236
      //   194: aload 8
      //   196: iload 4
      //   198: invokevirtual 118	com/google/protobuf/g:e	(I)V
      //   201: aload 8
      //   203: iload 5
      //   205: invokevirtual 118	com/google/protobuf/g:e	(I)V
      //   208: goto -173 -> 35
      //   211: astore_1
      //   212: aload_1
      //   213: aload_0
      //   214: putfield 121	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   217: aload_1
      //   218: athrow
      //   219: astore_1
      //   220: aload 8
      //   222: invokevirtual 123	com/google/protobuf/g:a	()V
      //   225: aload_0
      //   226: aload 7
      //   228: invokevirtual 128	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   231: putfield 78	com/whatsapp/proto/d$c:g	Lcom/google/protobuf/e;
      //   234: aload_1
      //   235: athrow
      //   236: aload_0
      //   237: aload_0
      //   238: getfield 130	com/whatsapp/proto/d$c:b	I
      //   241: iconst_1
      //   242: ior
      //   243: putfield 130	com/whatsapp/proto/d$c:b	I
      //   246: aload_0
      //   247: aload 6
      //   249: putfield 132	com/whatsapp/proto/d$c:c	Lcom/whatsapp/proto/d$c$c;
      //   252: goto -217 -> 35
      //   255: astore_1
      //   256: new 92	com/google/protobuf/q
      //   259: dup
      //   260: aload_1
      //   261: invokevirtual 136	java/io/IOException:getMessage	()Ljava/lang/String;
      //   264: invokespecial 139	com/google/protobuf/q:<init>	(Ljava/lang/String;)V
      //   267: astore_1
      //   268: aload_1
      //   269: aload_0
      //   270: putfield 121	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   273: aload_1
      //   274: athrow
      //   275: aload_0
      //   276: getfield 130	com/whatsapp/proto/d$c:b	I
      //   279: iconst_2
      //   280: iand
      //   281: iconst_2
      //   282: if_icmpne +420 -> 702
      //   285: aload_0
      //   286: getfield 141	com/whatsapp/proto/d$c:d	Lcom/whatsapp/proto/d$c$a;
      //   289: invokestatic 144	com/whatsapp/proto/d$c$a:a	(Lcom/whatsapp/proto/d$c$a;)Lcom/whatsapp/proto/d$c$a$a;
      //   292: astore 6
      //   294: aload_0
      //   295: aload_1
      //   296: getstatic 145	com/whatsapp/proto/d$c$a:a	Lcom/google/protobuf/ae;
      //   299: aload_2
      //   300: invokevirtual 148	com/google/protobuf/f:a	(Lcom/google/protobuf/ae;Lcom/google/protobuf/m;)Lcom/google/protobuf/x;
      //   303: checkcast 13	com/whatsapp/proto/d$c$a
      //   306: putfield 141	com/whatsapp/proto/d$c:d	Lcom/whatsapp/proto/d$c$a;
      //   309: aload 6
      //   311: ifnull +22 -> 333
      //   314: aload 6
      //   316: aload_0
      //   317: getfield 141	com/whatsapp/proto/d$c:d	Lcom/whatsapp/proto/d$c$a;
      //   320: invokevirtual 149	com/whatsapp/proto/d$c$a$a:a	(Lcom/whatsapp/proto/d$c$a;)Lcom/whatsapp/proto/d$c$a$a;
      //   323: pop
      //   324: aload_0
      //   325: aload 6
      //   327: invokevirtual 152	com/whatsapp/proto/d$c$a$a:c	()Lcom/whatsapp/proto/d$c$a;
      //   330: putfield 141	com/whatsapp/proto/d$c:d	Lcom/whatsapp/proto/d$c$a;
      //   333: aload_0
      //   334: aload_0
      //   335: getfield 130	com/whatsapp/proto/d$c:b	I
      //   338: iconst_2
      //   339: ior
      //   340: putfield 130	com/whatsapp/proto/d$c:b	I
      //   343: goto -308 -> 35
      //   346: aload_1
      //   347: invokevirtual 154	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   350: astore 6
      //   352: aload_0
      //   353: aload_0
      //   354: getfield 130	com/whatsapp/proto/d$c:b	I
      //   357: iconst_4
      //   358: ior
      //   359: putfield 130	com/whatsapp/proto/d$c:b	I
      //   362: aload_0
      //   363: aload 6
      //   365: putfield 156	com/whatsapp/proto/d$c:h	Ljava/lang/Object;
      //   368: goto -333 -> 35
      //   371: aload_1
      //   372: invokevirtual 154	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   375: astore 6
      //   377: aload_0
      //   378: aload_0
      //   379: getfield 130	com/whatsapp/proto/d$c:b	I
      //   382: bipush 8
      //   384: ior
      //   385: putfield 130	com/whatsapp/proto/d$c:b	I
      //   388: aload_0
      //   389: aload 6
      //   391: putfield 158	com/whatsapp/proto/d$c:i	Ljava/lang/Object;
      //   394: goto -359 -> 35
      //   397: aload_1
      //   398: invokevirtual 154	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   401: astore 6
      //   403: aload_0
      //   404: aload_0
      //   405: getfield 130	com/whatsapp/proto/d$c:b	I
      //   408: bipush 16
      //   410: ior
      //   411: putfield 130	com/whatsapp/proto/d$c:b	I
      //   414: aload_0
      //   415: aload 6
      //   417: putfield 160	com/whatsapp/proto/d$c:j	Ljava/lang/Object;
      //   420: goto -385 -> 35
      //   423: aload_1
      //   424: invokevirtual 154	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   427: astore 6
      //   429: aload_0
      //   430: aload_0
      //   431: getfield 130	com/whatsapp/proto/d$c:b	I
      //   434: bipush 32
      //   436: ior
      //   437: putfield 130	com/whatsapp/proto/d$c:b	I
      //   440: aload_0
      //   441: aload 6
      //   443: putfield 162	com/whatsapp/proto/d$c:k	Ljava/lang/Object;
      //   446: goto -411 -> 35
      //   449: aload_1
      //   450: invokevirtual 154	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   453: astore 6
      //   455: aload_0
      //   456: aload_0
      //   457: getfield 130	com/whatsapp/proto/d$c:b	I
      //   460: bipush 64
      //   462: ior
      //   463: putfield 130	com/whatsapp/proto/d$c:b	I
      //   466: aload_0
      //   467: aload 6
      //   469: putfield 164	com/whatsapp/proto/d$c:l	Ljava/lang/Object;
      //   472: goto -437 -> 35
      //   475: aload_1
      //   476: invokevirtual 154	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   479: astore 6
      //   481: aload_0
      //   482: aload_0
      //   483: getfield 130	com/whatsapp/proto/d$c:b	I
      //   486: sipush 128
      //   489: ior
      //   490: putfield 130	com/whatsapp/proto/d$c:b	I
      //   493: aload_0
      //   494: aload 6
      //   496: putfield 166	com/whatsapp/proto/d$c:m	Ljava/lang/Object;
      //   499: goto -464 -> 35
      //   502: aload_1
      //   503: invokevirtual 154	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   506: astore 6
      //   508: aload_0
      //   509: aload_0
      //   510: getfield 130	com/whatsapp/proto/d$c:b	I
      //   513: sipush 256
      //   516: ior
      //   517: putfield 130	com/whatsapp/proto/d$c:b	I
      //   520: aload_0
      //   521: aload 6
      //   523: putfield 168	com/whatsapp/proto/d$c:n	Ljava/lang/Object;
      //   526: goto -491 -> 35
      //   529: aload_1
      //   530: invokevirtual 112	com/google/protobuf/f:f	()I
      //   533: istore 5
      //   535: iload 5
      //   537: invokestatic 171	com/whatsapp/proto/d$c$d:a	(I)Lcom/whatsapp/proto/d$c$d;
      //   540: astore 6
      //   542: aload 6
      //   544: ifnonnull +20 -> 564
      //   547: aload 8
      //   549: iload 4
      //   551: invokevirtual 118	com/google/protobuf/g:e	(I)V
      //   554: aload 8
      //   556: iload 5
      //   558: invokevirtual 118	com/google/protobuf/g:e	(I)V
      //   561: goto -526 -> 35
      //   564: aload_0
      //   565: aload_0
      //   566: getfield 130	com/whatsapp/proto/d$c:b	I
      //   569: sipush 512
      //   572: ior
      //   573: putfield 130	com/whatsapp/proto/d$c:b	I
      //   576: aload_0
      //   577: aload 6
      //   579: putfield 173	com/whatsapp/proto/d$c:e	Lcom/whatsapp/proto/d$c$d;
      //   582: goto -547 -> 35
      //   585: aload_1
      //   586: invokevirtual 154	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   589: astore 6
      //   591: aload_0
      //   592: aload_0
      //   593: getfield 130	com/whatsapp/proto/d$c:b	I
      //   596: sipush 1024
      //   599: ior
      //   600: putfield 130	com/whatsapp/proto/d$c:b	I
      //   603: aload_0
      //   604: aload 6
      //   606: putfield 175	com/whatsapp/proto/d$c:o	Ljava/lang/Object;
      //   609: goto -574 -> 35
      //   612: aload_1
      //   613: invokevirtual 154	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   616: astore 6
      //   618: aload_0
      //   619: aload_0
      //   620: getfield 130	com/whatsapp/proto/d$c:b	I
      //   623: sipush 2048
      //   626: ior
      //   627: putfield 130	com/whatsapp/proto/d$c:b	I
      //   630: aload_0
      //   631: aload 6
      //   633: putfield 177	com/whatsapp/proto/d$c:p	Ljava/lang/Object;
      //   636: goto -601 -> 35
      //   639: aload 8
      //   641: invokevirtual 123	com/google/protobuf/g:a	()V
      //   644: aload_0
      //   645: aload 7
      //   647: invokevirtual 128	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   650: putfield 78	com/whatsapp/proto/d$c:g	Lcom/google/protobuf/e;
      //   653: return
      //   654: astore_1
      //   655: aload_0
      //   656: aload 7
      //   658: invokevirtual 128	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   661: putfield 78	com/whatsapp/proto/d$c:g	Lcom/google/protobuf/e;
      //   664: return
      //   665: astore_1
      //   666: aload_0
      //   667: aload 7
      //   669: invokevirtual 128	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   672: putfield 78	com/whatsapp/proto/d$c:g	Lcom/google/protobuf/e;
      //   675: aload_1
      //   676: athrow
      //   677: astore_2
      //   678: aload_0
      //   679: aload 7
      //   681: invokevirtual 128	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   684: putfield 78	com/whatsapp/proto/d$c:g	Lcom/google/protobuf/e;
      //   687: goto -453 -> 234
      //   690: astore_1
      //   691: aload_0
      //   692: aload 7
      //   694: invokevirtual 128	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   697: putfield 78	com/whatsapp/proto/d$c:g	Lcom/google/protobuf/e;
      //   700: aload_1
      //   701: athrow
      //   702: aconst_null
      //   703: astore 6
      //   705: goto -411 -> 294
      //   708: goto -548 -> 160
      //   711: iconst_1
      //   712: istore_3
      //   713: goto -678 -> 35
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	716	0	this	c
      //   0	716	1	paramf	com.google.protobuf.f
      //   0	716	2	paramm	com.google.protobuf.m
      //   34	679	3	i1	int
      //   43	507	4	i2	int
      //   180	377	5	i3	int
      //   187	517	6	localObject	Object
      //   21	672	7	localc	com.google.protobuf.e.c
      //   31	609	8	localg	g
      // Exception table:
      //   from	to	target	type
      //   39	45	211	com/google/protobuf/q
      //   160	171	211	com/google/protobuf/q
      //   176	189	211	com/google/protobuf/q
      //   194	208	211	com/google/protobuf/q
      //   236	252	211	com/google/protobuf/q
      //   275	294	211	com/google/protobuf/q
      //   294	309	211	com/google/protobuf/q
      //   314	333	211	com/google/protobuf/q
      //   333	343	211	com/google/protobuf/q
      //   346	368	211	com/google/protobuf/q
      //   371	394	211	com/google/protobuf/q
      //   397	420	211	com/google/protobuf/q
      //   423	446	211	com/google/protobuf/q
      //   449	472	211	com/google/protobuf/q
      //   475	499	211	com/google/protobuf/q
      //   502	526	211	com/google/protobuf/q
      //   529	542	211	com/google/protobuf/q
      //   547	561	211	com/google/protobuf/q
      //   564	582	211	com/google/protobuf/q
      //   585	609	211	com/google/protobuf/q
      //   612	636	211	com/google/protobuf/q
      //   39	45	219	finally
      //   160	171	219	finally
      //   176	189	219	finally
      //   194	208	219	finally
      //   212	219	219	finally
      //   236	252	219	finally
      //   256	275	219	finally
      //   275	294	219	finally
      //   294	309	219	finally
      //   314	333	219	finally
      //   333	343	219	finally
      //   346	368	219	finally
      //   371	394	219	finally
      //   397	420	219	finally
      //   423	446	219	finally
      //   449	472	219	finally
      //   475	499	219	finally
      //   502	526	219	finally
      //   529	542	219	finally
      //   547	561	219	finally
      //   564	582	219	finally
      //   585	609	219	finally
      //   612	636	219	finally
      //   39	45	255	java/io/IOException
      //   160	171	255	java/io/IOException
      //   176	189	255	java/io/IOException
      //   194	208	255	java/io/IOException
      //   236	252	255	java/io/IOException
      //   275	294	255	java/io/IOException
      //   294	309	255	java/io/IOException
      //   314	333	255	java/io/IOException
      //   333	343	255	java/io/IOException
      //   346	368	255	java/io/IOException
      //   371	394	255	java/io/IOException
      //   397	420	255	java/io/IOException
      //   423	446	255	java/io/IOException
      //   449	472	255	java/io/IOException
      //   475	499	255	java/io/IOException
      //   502	526	255	java/io/IOException
      //   529	542	255	java/io/IOException
      //   547	561	255	java/io/IOException
      //   564	582	255	java/io/IOException
      //   585	609	255	java/io/IOException
      //   612	636	255	java/io/IOException
      //   639	644	654	java/io/IOException
      //   639	644	665	finally
      //   220	225	677	java/io/IOException
      //   220	225	690	finally
    }
    
    public static b a(c paramc)
    {
      return b.d().a(paramc);
    }
    
    public static c a()
    {
      return f;
    }
    
    private e b()
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
    
    private e c()
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
    
    private e d()
    {
      Object localObject = this.j;
      if ((localObject instanceof String))
      {
        localObject = e.a((String)localObject);
        this.j = localObject;
        return (e)localObject;
      }
      return (e)localObject;
    }
    
    private e e()
    {
      Object localObject = this.k;
      if ((localObject instanceof String))
      {
        localObject = e.a((String)localObject);
        this.k = localObject;
        return (e)localObject;
      }
      return (e)localObject;
    }
    
    private e f()
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
    
    private e g()
    {
      Object localObject = this.m;
      if ((localObject instanceof String))
      {
        localObject = e.a((String)localObject);
        this.m = localObject;
        return (e)localObject;
      }
      return (e)localObject;
    }
    
    private e h()
    {
      Object localObject = this.n;
      if ((localObject instanceof String))
      {
        localObject = e.a((String)localObject);
        this.n = localObject;
        return (e)localObject;
      }
      return (e)localObject;
    }
    
    private e i()
    {
      Object localObject = this.o;
      if ((localObject instanceof String))
      {
        localObject = e.a((String)localObject);
        this.o = localObject;
        return (e)localObject;
      }
      return (e)localObject;
    }
    
    private e j()
    {
      Object localObject = this.p;
      if ((localObject instanceof String))
      {
        localObject = e.a((String)localObject);
        this.p = localObject;
        return (e)localObject;
      }
      return (e)localObject;
    }
    
    private void k()
    {
      this.c = c.a;
      this.d = a.a();
      this.h = "";
      this.i = "";
      this.j = "";
      this.k = "";
      this.l = "";
      this.m = "";
      this.n = "";
      this.e = d.a;
      this.o = "";
      this.p = "";
    }
    
    public final ae<c> getParserForType()
    {
      return a;
    }
    
    public final int getSerializedSize()
    {
      int i1 = this.r;
      if (i1 != -1) {
        return i1;
      }
      int i2 = 0;
      if ((this.b & 0x1) == 1) {
        i2 = g.f(1, this.c.getNumber()) + 0;
      }
      i1 = i2;
      if ((this.b & 0x2) == 2) {
        i1 = i2 + g.d(2, this.d);
      }
      i2 = i1;
      if ((this.b & 0x4) == 4) {
        i2 = i1 + g.c(3, b());
      }
      i1 = i2;
      if ((this.b & 0x8) == 8) {
        i1 = i2 + g.c(4, c());
      }
      i2 = i1;
      if ((this.b & 0x10) == 16) {
        i2 = i1 + g.c(5, d());
      }
      i1 = i2;
      if ((this.b & 0x20) == 32) {
        i1 = i2 + g.c(6, e());
      }
      i2 = i1;
      if ((this.b & 0x40) == 64) {
        i2 = i1 + g.c(7, f());
      }
      i1 = i2;
      if ((this.b & 0x80) == 128) {
        i1 = i2 + g.c(8, g());
      }
      i2 = i1;
      if ((this.b & 0x100) == 256) {
        i2 = i1 + g.c(9, h());
      }
      i1 = i2;
      if ((this.b & 0x200) == 512) {
        i1 = i2 + g.f(10, this.e.getNumber());
      }
      i2 = i1;
      if ((this.b & 0x400) == 1024) {
        i2 = i1 + g.c(11, i());
      }
      i1 = i2;
      if ((this.b & 0x800) == 2048) {
        i1 = i2 + g.c(12, j());
      }
      i1 += this.g.a();
      this.r = i1;
      return i1;
    }
    
    public final boolean isInitialized()
    {
      int i1 = this.q;
      if (i1 == 1) {
        return true;
      }
      if (i1 == 0) {
        return false;
      }
      this.q = 1;
      return true;
    }
    
    public final void writeTo(g paramg)
    {
      getSerializedSize();
      if ((this.b & 0x1) == 1) {
        paramg.c(1, this.c.getNumber());
      }
      if ((this.b & 0x2) == 2) {
        paramg.b(2, this.d);
      }
      if ((this.b & 0x4) == 4) {
        paramg.a(3, b());
      }
      if ((this.b & 0x8) == 8) {
        paramg.a(4, c());
      }
      if ((this.b & 0x10) == 16) {
        paramg.a(5, d());
      }
      if ((this.b & 0x20) == 32) {
        paramg.a(6, e());
      }
      if ((this.b & 0x40) == 64) {
        paramg.a(7, f());
      }
      if ((this.b & 0x80) == 128) {
        paramg.a(8, g());
      }
      if ((this.b & 0x100) == 256) {
        paramg.a(9, h());
      }
      if ((this.b & 0x200) == 512) {
        paramg.c(10, this.e.getNumber());
      }
      if ((this.b & 0x400) == 1024) {
        paramg.a(11, i());
      }
      if ((this.b & 0x800) == 2048) {
        paramg.a(12, j());
      }
      paramg.c(this.g);
    }
    
    public static final class a
      extends GeneratedMessageLite
      implements f.a
    {
      public static ae<a> a = new c() {};
      private static final a g;
      int b;
      int c;
      int d;
      int e;
      int f;
      private final e h;
      private byte i = -1;
      private int j = -1;
      
      static
      {
        a locala = new a();
        g = locala;
        locala.b();
      }
      
      private a()
      {
        this.h = e.b;
      }
      
      private a(GeneratedMessageLite.a parama)
      {
        super();
        this.h = parama.a;
      }
      
      /* Error */
      private a(com.google.protobuf.f paramf)
      {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 44	com/google/protobuf/GeneratedMessageLite:<init>	()V
        //   4: aload_0
        //   5: iconst_m1
        //   6: putfield 46	com/whatsapp/proto/d$c$a:i	B
        //   9: aload_0
        //   10: iconst_m1
        //   11: putfield 48	com/whatsapp/proto/d$c$a:j	I
        //   14: aload_0
        //   15: invokespecial 42	com/whatsapp/proto/d$c$a:b	()V
        //   18: invokestatic 73	com/google/protobuf/e:h	()Lcom/google/protobuf/e$c;
        //   21: astore 4
        //   23: aload 4
        //   25: sipush 4096
        //   28: invokestatic 78	com/google/protobuf/g:a	(Ljava/io/OutputStream;I)Lcom/google/protobuf/g;
        //   31: astore 5
        //   33: iconst_0
        //   34: istore_2
        //   35: iload_2
        //   36: ifne +205 -> 241
        //   39: aload_1
        //   40: invokevirtual 83	com/google/protobuf/f:a	()I
        //   43: istore_3
        //   44: iload_3
        //   45: lookupswitch	default:+260->305, 0:+263->308, 8:+66->111, 16:+112->157, 24:+153->198, 32:+174->219
        //   96: aload_1
        //   97: iload_3
        //   98: aload 5
        //   100: invokevirtual 86	com/google/protobuf/f:a	(ILcom/google/protobuf/g;)Z
        //   103: ifne -68 -> 35
        //   106: iconst_1
        //   107: istore_2
        //   108: goto -73 -> 35
        //   111: aload_0
        //   112: aload_0
        //   113: getfield 88	com/whatsapp/proto/d$c$a:b	I
        //   116: iconst_1
        //   117: ior
        //   118: putfield 88	com/whatsapp/proto/d$c$a:b	I
        //   121: aload_0
        //   122: aload_1
        //   123: invokevirtual 90	com/google/protobuf/f:f	()I
        //   126: putfield 92	com/whatsapp/proto/d$c$a:c	I
        //   129: goto -94 -> 35
        //   132: astore_1
        //   133: aload_1
        //   134: aload_0
        //   135: putfield 95	com/google/protobuf/q:a	Lcom/google/protobuf/x;
        //   138: aload_1
        //   139: athrow
        //   140: astore_1
        //   141: aload 5
        //   143: invokevirtual 97	com/google/protobuf/g:a	()V
        //   146: aload_0
        //   147: aload 4
        //   149: invokevirtual 102	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   152: putfield 54	com/whatsapp/proto/d$c$a:h	Lcom/google/protobuf/e;
        //   155: aload_1
        //   156: athrow
        //   157: aload_0
        //   158: aload_0
        //   159: getfield 88	com/whatsapp/proto/d$c$a:b	I
        //   162: iconst_2
        //   163: ior
        //   164: putfield 88	com/whatsapp/proto/d$c$a:b	I
        //   167: aload_0
        //   168: aload_1
        //   169: invokevirtual 90	com/google/protobuf/f:f	()I
        //   172: putfield 104	com/whatsapp/proto/d$c$a:d	I
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
        //   193: putfield 95	com/google/protobuf/q:a	Lcom/google/protobuf/x;
        //   196: aload_1
        //   197: athrow
        //   198: aload_0
        //   199: aload_0
        //   200: getfield 88	com/whatsapp/proto/d$c$a:b	I
        //   203: iconst_4
        //   204: ior
        //   205: putfield 88	com/whatsapp/proto/d$c$a:b	I
        //   208: aload_0
        //   209: aload_1
        //   210: invokevirtual 90	com/google/protobuf/f:f	()I
        //   213: putfield 113	com/whatsapp/proto/d$c$a:e	I
        //   216: goto -181 -> 35
        //   219: aload_0
        //   220: aload_0
        //   221: getfield 88	com/whatsapp/proto/d$c$a:b	I
        //   224: bipush 8
        //   226: ior
        //   227: putfield 88	com/whatsapp/proto/d$c$a:b	I
        //   230: aload_0
        //   231: aload_1
        //   232: invokevirtual 90	com/google/protobuf/f:f	()I
        //   235: putfield 115	com/whatsapp/proto/d$c$a:f	I
        //   238: goto -203 -> 35
        //   241: aload 5
        //   243: invokevirtual 97	com/google/protobuf/g:a	()V
        //   246: aload_0
        //   247: aload 4
        //   249: invokevirtual 102	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   252: putfield 54	com/whatsapp/proto/d$c$a:h	Lcom/google/protobuf/e;
        //   255: return
        //   256: astore_1
        //   257: aload_0
        //   258: aload 4
        //   260: invokevirtual 102	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   263: putfield 54	com/whatsapp/proto/d$c$a:h	Lcom/google/protobuf/e;
        //   266: return
        //   267: astore_1
        //   268: aload_0
        //   269: aload 4
        //   271: invokevirtual 102	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   274: putfield 54	com/whatsapp/proto/d$c$a:h	Lcom/google/protobuf/e;
        //   277: aload_1
        //   278: athrow
        //   279: astore 5
        //   281: aload_0
        //   282: aload 4
        //   284: invokevirtual 102	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   287: putfield 54	com/whatsapp/proto/d$c$a:h	Lcom/google/protobuf/e;
        //   290: goto -135 -> 155
        //   293: astore_1
        //   294: aload_0
        //   295: aload 4
        //   297: invokevirtual 102	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   300: putfield 54	com/whatsapp/proto/d$c$a:h	Lcom/google/protobuf/e;
        //   303: aload_1
        //   304: athrow
        //   305: goto -209 -> 96
        //   308: iconst_1
        //   309: istore_2
        //   310: goto -275 -> 35
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	313	0	this	a
        //   0	313	1	paramf	com.google.protobuf.f
        //   34	276	2	k	int
        //   43	55	3	m	int
        //   21	275	4	localc	com.google.protobuf.e.c
        //   31	211	5	localg	g
        //   279	1	5	localIOException	java.io.IOException
        // Exception table:
        //   from	to	target	type
        //   39	44	132	com/google/protobuf/q
        //   96	106	132	com/google/protobuf/q
        //   111	129	132	com/google/protobuf/q
        //   157	175	132	com/google/protobuf/q
        //   198	216	132	com/google/protobuf/q
        //   219	238	132	com/google/protobuf/q
        //   39	44	140	finally
        //   96	106	140	finally
        //   111	129	140	finally
        //   133	140	140	finally
        //   157	175	140	finally
        //   179	198	140	finally
        //   198	216	140	finally
        //   219	238	140	finally
        //   39	44	178	java/io/IOException
        //   96	106	178	java/io/IOException
        //   111	129	178	java/io/IOException
        //   157	175	178	java/io/IOException
        //   198	216	178	java/io/IOException
        //   219	238	178	java/io/IOException
        //   241	246	256	java/io/IOException
        //   241	246	267	finally
        //   141	146	279	java/io/IOException
        //   141	146	293	finally
      }
      
      public static a a(a parama)
      {
        return a.d().a(parama);
      }
      
      public static a a()
      {
        return g;
      }
      
      private void b()
      {
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
      }
      
      public final ae<a> getParserForType()
      {
        return a;
      }
      
      public final int getSerializedSize()
      {
        int k = this.j;
        if (k != -1) {
          return k;
        }
        int m = 0;
        if ((this.b & 0x1) == 1) {
          m = g.e(1, this.c) + 0;
        }
        k = m;
        if ((this.b & 0x2) == 2) {
          k = m + g.e(2, this.d);
        }
        m = k;
        if ((this.b & 0x4) == 4) {
          m = k + g.e(3, this.e);
        }
        k = m;
        if ((this.b & 0x8) == 8) {
          k = m + g.e(4, this.f);
        }
        k += this.h.a();
        this.j = k;
        return k;
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
          paramg.b(2, this.d);
        }
        if ((this.b & 0x4) == 4) {
          paramg.b(3, this.e);
        }
        if ((this.b & 0x8) == 8) {
          paramg.b(4, this.f);
        }
        paramg.c(this.h);
      }
      
      public static final class a
        extends GeneratedMessageLite.a<d.c.a, a>
        implements f.a
      {
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        
        /* Error */
        private a a(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
        {
          // Byte code:
          //   0: getstatic 31	com/whatsapp/proto/d$c$a:a	Lcom/google/protobuf/ae;
          //   3: aload_1
          //   4: aload_2
          //   5: invokeinterface 36 3 0
          //   10: checkcast 14	com/whatsapp/proto/d$c$a
          //   13: astore_1
          //   14: aload_1
          //   15: ifnull +9 -> 24
          //   18: aload_0
          //   19: aload_1
          //   20: invokevirtual 39	com/whatsapp/proto/d$c$a$a:a	(Lcom/whatsapp/proto/d$c$a;)Lcom/whatsapp/proto/d$c$a$a;
          //   23: pop
          //   24: aload_0
          //   25: areturn
          //   26: astore_2
          //   27: aload_2
          //   28: getfield 42	com/google/protobuf/q:a	Lcom/google/protobuf/x;
          //   31: checkcast 14	com/whatsapp/proto/d$c$a
          //   34: astore_1
          //   35: aload_2
          //   36: athrow
          //   37: astore_2
          //   38: aload_1
          //   39: ifnull +9 -> 48
          //   42: aload_0
          //   43: aload_1
          //   44: invokevirtual 39	com/whatsapp/proto/d$c$a$a:a	(Lcom/whatsapp/proto/d$c$a;)Lcom/whatsapp/proto/d$c$a$a;
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
        
        private a e()
        {
          return new a().a(c());
        }
        
        public final a a(int paramInt)
        {
          this.b |= 0x1;
          this.c = paramInt;
          return this;
        }
        
        public final a a(d.c.a parama)
        {
          int j = 1;
          if (parama == d.c.a.a()) {
            return this;
          }
          if ((parama.b & 0x1) == 1)
          {
            i = 1;
            if (i != 0) {
              a(parama.c);
            }
            if ((parama.b & 0x2) != 2) {
              break label147;
            }
            i = 1;
            label48:
            if (i != 0) {
              b(parama.d);
            }
            if ((parama.b & 0x4) != 4) {
              break label152;
            }
            i = 1;
            label73:
            if (i != 0) {
              c(parama.e);
            }
            if ((parama.b & 0x8) != 8) {
              break label157;
            }
          }
          label147:
          label152:
          label157:
          for (int i = j;; i = 0)
          {
            if (i != 0)
            {
              i = parama.f;
              this.b |= 0x8;
              this.f = i;
            }
            this.a = this.a.a(d.c.a.b(parama));
            return this;
            i = 0;
            break;
            i = 0;
            break label48;
            i = 0;
            break label73;
          }
        }
        
        public final a b(int paramInt)
        {
          this.b |= 0x2;
          this.d = paramInt;
          return this;
        }
        
        public final d.c.a b()
        {
          d.c.a locala = c();
          if (!locala.isInitialized()) {
            throw new am();
          }
          return locala;
        }
        
        public final a c(int paramInt)
        {
          this.b |= 0x4;
          this.e = paramInt;
          return this;
        }
        
        public final d.c.a c()
        {
          int j = 1;
          d.c.a locala = new d.c.a(this, (byte)0);
          int k = this.b;
          if ((k & 0x1) == 1) {}
          for (;;)
          {
            d.c.a.a(locala, this.c);
            int i = j;
            if ((k & 0x2) == 2) {
              i = j | 0x2;
            }
            d.c.a.b(locala, this.d);
            j = i;
            if ((k & 0x4) == 4) {
              j = i | 0x4;
            }
            d.c.a.c(locala, this.e);
            i = j;
            if ((k & 0x8) == 8) {
              i = j | 0x8;
            }
            d.c.a.d(locala, this.f);
            d.c.a.e(locala, i);
            return locala;
            j = 0;
          }
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
      }
    }
    
    public static final class b
      extends GeneratedMessageLite.a<d.c, b>
      implements f.a
    {
      public int b;
      public d.c.a c = d.c.a.a();
      public Object d = "";
      public Object e = "";
      public Object f = "";
      public Object g = "";
      public Object h = "";
      public Object i = "";
      public Object j = "";
      public Object k = "";
      public Object l = "";
      private d.c.c m = d.c.c.a;
      private d.c.d n = d.c.d.a;
      
      /* Error */
      private b a(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
      {
        // Byte code:
        //   0: getstatic 80	com/whatsapp/proto/d$c:a	Lcom/google/protobuf/ae;
        //   3: aload_1
        //   4: aload_2
        //   5: invokeinterface 85 3 0
        //   10: checkcast 9	com/whatsapp/proto/d$c
        //   13: astore_1
        //   14: aload_1
        //   15: ifnull +9 -> 24
        //   18: aload_0
        //   19: aload_1
        //   20: invokevirtual 88	com/whatsapp/proto/d$c$b:a	(Lcom/whatsapp/proto/d$c;)Lcom/whatsapp/proto/d$c$b;
        //   23: pop
        //   24: aload_0
        //   25: areturn
        //   26: astore_2
        //   27: aload_2
        //   28: getfield 91	com/google/protobuf/q:a	Lcom/google/protobuf/x;
        //   31: checkcast 9	com/whatsapp/proto/d$c
        //   34: astore_1
        //   35: aload_2
        //   36: athrow
        //   37: astore_2
        //   38: aload_1
        //   39: ifnull +9 -> 48
        //   42: aload_0
        //   43: aload_1
        //   44: invokevirtual 88	com/whatsapp/proto/d$c$b:a	(Lcom/whatsapp/proto/d$c;)Lcom/whatsapp/proto/d$c$b;
        //   47: pop
        //   48: aload_2
        //   49: athrow
        //   50: astore_2
        //   51: aconst_null
        //   52: astore_1
        //   53: goto -15 -> 38
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	56	0	this	b
        //   0	56	1	paramf	com.google.protobuf.f
        //   0	56	2	paramm	com.google.protobuf.m
        // Exception table:
        //   from	to	target	type
        //   0	14	26	com/google/protobuf/q
        //   35	37	37	finally
        //   0	14	50	finally
        //   27	35	50	finally
      }
      
      private b e()
      {
        return new b().a(c());
      }
      
      public final b a(d.c.c paramc)
      {
        if (paramc == null) {
          throw new NullPointerException();
        }
        this.b |= 0x1;
        this.m = paramc;
        return this;
      }
      
      public final b a(d.c.d paramd)
      {
        if (paramd == null) {
          throw new NullPointerException();
        }
        this.b |= 0x200;
        this.n = paramd;
        return this;
      }
      
      public final b a(d.c paramc)
      {
        int i2 = 1;
        if (paramc == d.c.a()) {
          return this;
        }
        label48:
        d.c.a locala;
        if ((paramc.b & 0x1) == 1)
        {
          i1 = 1;
          if (i1 != 0) {
            a(paramc.c);
          }
          if ((paramc.b & 0x2) != 2) {
            break label500;
          }
          i1 = 1;
          if (i1 != 0)
          {
            locala = paramc.d;
            if (((this.b & 0x2) != 2) || (this.c == d.c.a.a())) {
              break label505;
            }
            this.c = d.c.a.a(this.c).a(locala).c();
            label97:
            this.b |= 0x2;
          }
          if ((paramc.b & 0x4) != 4) {
            break label514;
          }
          i1 = 1;
          label119:
          if (i1 != 0)
          {
            this.b |= 0x4;
            this.d = d.c.b(paramc);
          }
          if ((paramc.b & 0x8) != 8) {
            break label519;
          }
          i1 = 1;
          label155:
          if (i1 != 0)
          {
            this.b |= 0x8;
            this.e = d.c.c(paramc);
          }
          if ((paramc.b & 0x10) != 16) {
            break label524;
          }
          i1 = 1;
          label192:
          if (i1 != 0)
          {
            this.b |= 0x10;
            this.f = d.c.d(paramc);
          }
          if ((paramc.b & 0x20) != 32) {
            break label529;
          }
          i1 = 1;
          label229:
          if (i1 != 0)
          {
            this.b |= 0x20;
            this.g = d.c.e(paramc);
          }
          if ((paramc.b & 0x40) != 64) {
            break label534;
          }
          i1 = 1;
          label266:
          if (i1 != 0)
          {
            this.b |= 0x40;
            this.h = d.c.f(paramc);
          }
          if ((paramc.b & 0x80) != 128) {
            break label539;
          }
          i1 = 1;
          label305:
          if (i1 != 0)
          {
            this.b |= 0x80;
            this.i = d.c.g(paramc);
          }
          if ((paramc.b & 0x100) != 256) {
            break label544;
          }
          i1 = 1;
          label345:
          if (i1 != 0)
          {
            this.b |= 0x100;
            this.j = d.c.h(paramc);
          }
          if ((paramc.b & 0x200) != 512) {
            break label549;
          }
          i1 = 1;
          label385:
          if (i1 != 0) {
            a(paramc.e);
          }
          if ((paramc.b & 0x400) != 1024) {
            break label554;
          }
          i1 = 1;
          label414:
          if (i1 != 0)
          {
            this.b |= 0x400;
            this.k = d.c.i(paramc);
          }
          if ((paramc.b & 0x800) != 2048) {
            break label559;
          }
        }
        label500:
        label505:
        label514:
        label519:
        label524:
        label529:
        label534:
        label539:
        label544:
        label549:
        label554:
        label559:
        for (int i1 = i2;; i1 = 0)
        {
          if (i1 != 0)
          {
            this.b |= 0x800;
            this.l = d.c.j(paramc);
          }
          this.a = this.a.a(d.c.k(paramc));
          return this;
          i1 = 0;
          break;
          i1 = 0;
          break label48;
          this.c = locala;
          break label97;
          i1 = 0;
          break label119;
          i1 = 0;
          break label155;
          i1 = 0;
          break label192;
          i1 = 0;
          break label229;
          i1 = 0;
          break label266;
          i1 = 0;
          break label305;
          i1 = 0;
          break label345;
          i1 = 0;
          break label385;
          i1 = 0;
          break label414;
        }
      }
      
      public final d.c b()
      {
        d.c localc = c();
        if (!localc.isInitialized()) {
          throw new am();
        }
        return localc;
      }
      
      public final d.c c()
      {
        int i2 = 1;
        d.c localc = new d.c(this, (byte)0);
        int i3 = this.b;
        if ((i3 & 0x1) == 1) {}
        for (;;)
        {
          d.c.a(localc, this.m);
          int i1 = i2;
          if ((i3 & 0x2) == 2) {
            i1 = i2 | 0x2;
          }
          d.c.a(localc, this.c);
          i2 = i1;
          if ((i3 & 0x4) == 4) {
            i2 = i1 | 0x4;
          }
          d.c.a(localc, this.d);
          i1 = i2;
          if ((i3 & 0x8) == 8) {
            i1 = i2 | 0x8;
          }
          d.c.b(localc, this.e);
          i2 = i1;
          if ((i3 & 0x10) == 16) {
            i2 = i1 | 0x10;
          }
          d.c.c(localc, this.f);
          i1 = i2;
          if ((i3 & 0x20) == 32) {
            i1 = i2 | 0x20;
          }
          d.c.d(localc, this.g);
          i2 = i1;
          if ((i3 & 0x40) == 64) {
            i2 = i1 | 0x40;
          }
          d.c.e(localc, this.h);
          i1 = i2;
          if ((i3 & 0x80) == 128) {
            i1 = i2 | 0x80;
          }
          d.c.f(localc, this.i);
          i2 = i1;
          if ((i3 & 0x100) == 256) {
            i2 = i1 | 0x100;
          }
          d.c.g(localc, this.j);
          i1 = i2;
          if ((i3 & 0x200) == 512) {
            i1 = i2 | 0x200;
          }
          d.c.a(localc, this.n);
          i2 = i1;
          if ((i3 & 0x400) == 1024) {
            i2 = i1 | 0x400;
          }
          d.c.h(localc, this.k);
          i1 = i2;
          if ((i3 & 0x800) == 2048) {
            i1 = i2 | 0x800;
          }
          d.c.i(localc, this.l);
          d.c.a(localc, i1);
          return localc;
          i2 = 0;
        }
      }
      
      public final boolean isInitialized()
      {
        return true;
      }
    }
    
    public static enum c
      implements p.a
    {
      private static f.a<c> l = new f.a() {};
      private final int m;
      
      private c(int paramInt1, int paramInt2)
      {
        this.m = paramInt1;
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
        case 3: 
          return d;
        case 4: 
          return e;
        case 5: 
          return f;
        case 6: 
          return g;
        case 7: 
          return h;
        case 8: 
          return i;
        case 9: 
          return j;
        }
        return k;
      }
      
      public final int getNumber()
      {
        return this.m;
      }
    }
    
    public static enum d
      implements p.a
    {
      private static f.a<d> e = new f.a() {};
      private final int f;
      
      private d(int paramInt1, int paramInt2)
      {
        this.f = paramInt1;
      }
      
      public static d a(int paramInt)
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
  
  public static final class d
    extends GeneratedMessageLite
    implements f.a
  {
    public static ae<d> a = new c() {};
    private static final d e;
    int b;
    public Object c;
    b d;
    private final e f;
    private Object g;
    private byte h = -1;
    private int i = -1;
    
    static
    {
      d locald = new d();
      e = locald;
      locald.e();
    }
    
    private d()
    {
      this.f = e.b;
    }
    
    private d(GeneratedMessageLite.a parama)
    {
      super();
      this.f = parama.a;
    }
    
    /* Error */
    private d(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 49	com/google/protobuf/GeneratedMessageLite:<init>	()V
      //   4: aload_0
      //   5: iconst_m1
      //   6: putfield 51	com/whatsapp/proto/d$d:h	B
      //   9: aload_0
      //   10: iconst_m1
      //   11: putfield 53	com/whatsapp/proto/d$d:i	I
      //   14: aload_0
      //   15: invokespecial 47	com/whatsapp/proto/d$d:e	()V
      //   18: invokestatic 78	com/google/protobuf/e:h	()Lcom/google/protobuf/e$c;
      //   21: astore 6
      //   23: aload 6
      //   25: sipush 4096
      //   28: invokestatic 83	com/google/protobuf/g:a	(Ljava/io/OutputStream;I)Lcom/google/protobuf/g;
      //   31: astore 7
      //   33: iconst_0
      //   34: istore_3
      //   35: iload_3
      //   36: ifne +234 -> 270
      //   39: aload_1
      //   40: invokevirtual 88	com/google/protobuf/f:a	()I
      //   43: istore 4
      //   45: iload 4
      //   47: lookupswitch	default:+292->339, 0:+295->342, 10:+57->104, 18:+107->154, 26:+152->199
      //   88: aload_1
      //   89: iload 4
      //   91: aload 7
      //   93: invokevirtual 91	com/google/protobuf/f:a	(ILcom/google/protobuf/g;)Z
      //   96: ifne -61 -> 35
      //   99: iconst_1
      //   100: istore_3
      //   101: goto -66 -> 35
      //   104: aload_1
      //   105: invokevirtual 94	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   108: astore 5
      //   110: aload_0
      //   111: aload_0
      //   112: getfield 96	com/whatsapp/proto/d$d:b	I
      //   115: iconst_1
      //   116: ior
      //   117: putfield 96	com/whatsapp/proto/d$d:b	I
      //   120: aload_0
      //   121: aload 5
      //   123: putfield 98	com/whatsapp/proto/d$d:c	Ljava/lang/Object;
      //   126: goto -91 -> 35
      //   129: astore_1
      //   130: aload_1
      //   131: aload_0
      //   132: putfield 101	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   135: aload_1
      //   136: athrow
      //   137: astore_1
      //   138: aload 7
      //   140: invokevirtual 103	com/google/protobuf/g:a	()V
      //   143: aload_0
      //   144: aload 6
      //   146: invokevirtual 107	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   149: putfield 59	com/whatsapp/proto/d$d:f	Lcom/google/protobuf/e;
      //   152: aload_1
      //   153: athrow
      //   154: aload_1
      //   155: invokevirtual 94	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
      //   158: astore 5
      //   160: aload_0
      //   161: aload_0
      //   162: getfield 96	com/whatsapp/proto/d$d:b	I
      //   165: iconst_2
      //   166: ior
      //   167: putfield 96	com/whatsapp/proto/d$d:b	I
      //   170: aload_0
      //   171: aload 5
      //   173: putfield 109	com/whatsapp/proto/d$d:g	Ljava/lang/Object;
      //   176: goto -141 -> 35
      //   179: astore_1
      //   180: new 73	com/google/protobuf/q
      //   183: dup
      //   184: aload_1
      //   185: invokevirtual 113	java/io/IOException:getMessage	()Ljava/lang/String;
      //   188: invokespecial 116	com/google/protobuf/q:<init>	(Ljava/lang/String;)V
      //   191: astore_1
      //   192: aload_1
      //   193: aload_0
      //   194: putfield 101	com/google/protobuf/q:a	Lcom/google/protobuf/x;
      //   197: aload_1
      //   198: athrow
      //   199: aload_0
      //   200: getfield 96	com/whatsapp/proto/d$d:b	I
      //   203: iconst_4
      //   204: iand
      //   205: iconst_4
      //   206: if_icmpne +127 -> 333
      //   209: aload_0
      //   210: getfield 118	com/whatsapp/proto/d$d:d	Lcom/whatsapp/proto/d$d$b;
      //   213: invokestatic 121	com/whatsapp/proto/d$d$b:a	(Lcom/whatsapp/proto/d$d$b;)Lcom/whatsapp/proto/d$d$b$a;
      //   216: astore 5
      //   218: aload_0
      //   219: aload_1
      //   220: getstatic 122	com/whatsapp/proto/d$d$b:a	Lcom/google/protobuf/ae;
      //   223: aload_2
      //   224: invokevirtual 125	com/google/protobuf/f:a	(Lcom/google/protobuf/ae;Lcom/google/protobuf/m;)Lcom/google/protobuf/x;
      //   227: checkcast 16	com/whatsapp/proto/d$d$b
      //   230: putfield 118	com/whatsapp/proto/d$d:d	Lcom/whatsapp/proto/d$d$b;
      //   233: aload 5
      //   235: ifnull +22 -> 257
      //   238: aload 5
      //   240: aload_0
      //   241: getfield 118	com/whatsapp/proto/d$d:d	Lcom/whatsapp/proto/d$d$b;
      //   244: invokevirtual 126	com/whatsapp/proto/d$d$b$a:a	(Lcom/whatsapp/proto/d$d$b;)Lcom/whatsapp/proto/d$d$b$a;
      //   247: pop
      //   248: aload_0
      //   249: aload 5
      //   251: invokevirtual 129	com/whatsapp/proto/d$d$b$a:c	()Lcom/whatsapp/proto/d$d$b;
      //   254: putfield 118	com/whatsapp/proto/d$d:d	Lcom/whatsapp/proto/d$d$b;
      //   257: aload_0
      //   258: aload_0
      //   259: getfield 96	com/whatsapp/proto/d$d:b	I
      //   262: iconst_4
      //   263: ior
      //   264: putfield 96	com/whatsapp/proto/d$d:b	I
      //   267: goto -232 -> 35
      //   270: aload 7
      //   272: invokevirtual 103	com/google/protobuf/g:a	()V
      //   275: aload_0
      //   276: aload 6
      //   278: invokevirtual 107	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   281: putfield 59	com/whatsapp/proto/d$d:f	Lcom/google/protobuf/e;
      //   284: return
      //   285: astore_1
      //   286: aload_0
      //   287: aload 6
      //   289: invokevirtual 107	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   292: putfield 59	com/whatsapp/proto/d$d:f	Lcom/google/protobuf/e;
      //   295: return
      //   296: astore_1
      //   297: aload_0
      //   298: aload 6
      //   300: invokevirtual 107	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   303: putfield 59	com/whatsapp/proto/d$d:f	Lcom/google/protobuf/e;
      //   306: aload_1
      //   307: athrow
      //   308: astore_2
      //   309: aload_0
      //   310: aload 6
      //   312: invokevirtual 107	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   315: putfield 59	com/whatsapp/proto/d$d:f	Lcom/google/protobuf/e;
      //   318: goto -166 -> 152
      //   321: astore_1
      //   322: aload_0
      //   323: aload 6
      //   325: invokevirtual 107	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
      //   328: putfield 59	com/whatsapp/proto/d$d:f	Lcom/google/protobuf/e;
      //   331: aload_1
      //   332: athrow
      //   333: aconst_null
      //   334: astore 5
      //   336: goto -118 -> 218
      //   339: goto -251 -> 88
      //   342: iconst_1
      //   343: istore_3
      //   344: goto -309 -> 35
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	347	0	this	d
      //   0	347	1	paramf	com.google.protobuf.f
      //   0	347	2	paramm	com.google.protobuf.m
      //   34	310	3	j	int
      //   43	47	4	k	int
      //   108	227	5	localObject	Object
      //   21	303	6	localc	com.google.protobuf.e.c
      //   31	240	7	localg	g
      // Exception table:
      //   from	to	target	type
      //   39	45	129	com/google/protobuf/q
      //   88	99	129	com/google/protobuf/q
      //   104	126	129	com/google/protobuf/q
      //   154	176	129	com/google/protobuf/q
      //   199	218	129	com/google/protobuf/q
      //   218	233	129	com/google/protobuf/q
      //   238	257	129	com/google/protobuf/q
      //   257	267	129	com/google/protobuf/q
      //   39	45	137	finally
      //   88	99	137	finally
      //   104	126	137	finally
      //   130	137	137	finally
      //   154	176	137	finally
      //   180	199	137	finally
      //   199	218	137	finally
      //   218	233	137	finally
      //   238	257	137	finally
      //   257	267	137	finally
      //   39	45	179	java/io/IOException
      //   88	99	179	java/io/IOException
      //   104	126	179	java/io/IOException
      //   154	176	179	java/io/IOException
      //   199	218	179	java/io/IOException
      //   218	233	179	java/io/IOException
      //   238	257	179	java/io/IOException
      //   257	267	179	java/io/IOException
      //   270	275	285	java/io/IOException
      //   270	275	296	finally
      //   138	143	308	java/io/IOException
      //   138	143	321	finally
    }
    
    public static a a(d paramd)
    {
      return a.d().a(paramd);
    }
    
    public static d a()
    {
      return e;
    }
    
    private e c()
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
    
    private e d()
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
    
    private void e()
    {
      this.c = "";
      this.g = "";
      this.d = b.a();
    }
    
    public final boolean b()
    {
      return (this.b & 0x1) == 1;
    }
    
    public final ae<d> getParserForType()
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
        k = j + g.d(3, this.d);
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
      extends GeneratedMessageLite.a<d.d, a>
      implements f.a
    {
      public int b;
      public Object c = "";
      public Object d = "";
      public d.d.b e = d.d.b.a();
      
      /* Error */
      private a a(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
      {
        // Byte code:
        //   0: getstatic 43	com/whatsapp/proto/d$d:a	Lcom/google/protobuf/ae;
        //   3: aload_1
        //   4: aload_2
        //   5: invokeinterface 48 3 0
        //   10: checkcast 9	com/whatsapp/proto/d$d
        //   13: astore_1
        //   14: aload_1
        //   15: ifnull +9 -> 24
        //   18: aload_0
        //   19: aload_1
        //   20: invokevirtual 51	com/whatsapp/proto/d$d$a:a	(Lcom/whatsapp/proto/d$d;)Lcom/whatsapp/proto/d$d$a;
        //   23: pop
        //   24: aload_0
        //   25: areturn
        //   26: astore_2
        //   27: aload_2
        //   28: getfield 54	com/google/protobuf/q:a	Lcom/google/protobuf/x;
        //   31: checkcast 9	com/whatsapp/proto/d$d
        //   34: astore_1
        //   35: aload_2
        //   36: athrow
        //   37: astore_2
        //   38: aload_1
        //   39: ifnull +9 -> 48
        //   42: aload_0
        //   43: aload_1
        //   44: invokevirtual 51	com/whatsapp/proto/d$d$a:a	(Lcom/whatsapp/proto/d$d;)Lcom/whatsapp/proto/d$d$a;
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
      
      private a e()
      {
        return new a().a(c());
      }
      
      public final a a(d.d paramd)
      {
        int j = 1;
        if (paramd == d.d.a()) {
          return this;
        }
        if (paramd.b())
        {
          this.b |= 0x1;
          this.c = d.d.b(paramd);
        }
        int i;
        label82:
        d.d.b localb;
        if ((paramd.b & 0x2) == 2)
        {
          i = 1;
          if (i != 0)
          {
            this.b |= 0x2;
            this.d = d.d.c(paramd);
          }
          if ((paramd.b & 0x4) != 4) {
            break label163;
          }
          i = j;
          if (i != 0)
          {
            localb = paramd.d;
            if (((this.b & 0x4) != 4) || (this.e == d.d.b.a())) {
              break label168;
            }
          }
        }
        label163:
        label168:
        for (this.e = d.d.b.a(this.e).a(localb).c();; this.e = localb)
        {
          this.b |= 0x4;
          this.a = this.a.a(d.d.d(paramd));
          return this;
          i = 0;
          break;
          i = 0;
          break label82;
        }
      }
      
      public final d.d b()
      {
        d.d locald = c();
        if (!locald.isInitialized()) {
          throw new am();
        }
        return locald;
      }
      
      public final d.d c()
      {
        int j = 1;
        d.d locald = new d.d(this, (byte)0);
        int k = this.b;
        if ((k & 0x1) == 1) {}
        for (;;)
        {
          d.d.a(locald, this.c);
          int i = j;
          if ((k & 0x2) == 2) {
            i = j | 0x2;
          }
          d.d.b(locald, this.d);
          j = i;
          if ((k & 0x4) == 4) {
            j = i | 0x4;
          }
          d.d.a(locald, this.e);
          d.d.a(locald, j);
          return locald;
          j = 0;
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
      private static final b l;
      int b;
      boolean c;
      boolean d;
      boolean e;
      boolean f;
      boolean g;
      boolean h;
      boolean i;
      boolean j;
      boolean k;
      private final e m;
      private Object n;
      private byte o = -1;
      private int p = -1;
      
      static
      {
        b localb = new b();
        l = localb;
        localb.c();
      }
      
      private b()
      {
        this.m = e.b;
      }
      
      private b(GeneratedMessageLite.a parama)
      {
        super();
        this.m = parama.a;
      }
      
      /* Error */
      private b(com.google.protobuf.f paramf)
      {
        // Byte code:
        //   0: aload_0
        //   1: invokespecial 52	com/google/protobuf/GeneratedMessageLite:<init>	()V
        //   4: aload_0
        //   5: iconst_m1
        //   6: putfield 54	com/whatsapp/proto/d$d$b:o	B
        //   9: aload_0
        //   10: iconst_m1
        //   11: putfield 56	com/whatsapp/proto/d$d$b:p	I
        //   14: aload_0
        //   15: invokespecial 50	com/whatsapp/proto/d$d$b:c	()V
        //   18: invokestatic 81	com/google/protobuf/e:h	()Lcom/google/protobuf/e$c;
        //   21: astore 4
        //   23: aload 4
        //   25: sipush 4096
        //   28: invokestatic 86	com/google/protobuf/g:a	(Ljava/io/OutputStream;I)Lcom/google/protobuf/g;
        //   31: astore 5
        //   33: iconst_0
        //   34: istore_2
        //   35: iload_2
        //   36: ifne +392 -> 428
        //   39: aload_1
        //   40: invokevirtual 91	com/google/protobuf/f:a	()I
        //   43: istore_3
        //   44: iload_3
        //   45: lookupswitch	default:+447->492, 0:+450->495, 8:+114->159, 16:+160->205, 24:+201->246, 32:+222->267, 40:+244->289, 48:+266->311, 56:+288->333, 64:+310->355, 72:+333->378, 82:+356->401
        //   144: aload_1
        //   145: iload_3
        //   146: aload 5
        //   148: invokevirtual 94	com/google/protobuf/f:a	(ILcom/google/protobuf/g;)Z
        //   151: ifne -116 -> 35
        //   154: iconst_1
        //   155: istore_2
        //   156: goto -121 -> 35
        //   159: aload_0
        //   160: aload_0
        //   161: getfield 96	com/whatsapp/proto/d$d$b:b	I
        //   164: iconst_1
        //   165: ior
        //   166: putfield 96	com/whatsapp/proto/d$d$b:b	I
        //   169: aload_0
        //   170: aload_1
        //   171: invokevirtual 99	com/google/protobuf/f:c	()Z
        //   174: putfield 101	com/whatsapp/proto/d$d$b:c	Z
        //   177: goto -142 -> 35
        //   180: astore_1
        //   181: aload_1
        //   182: aload_0
        //   183: putfield 104	com/google/protobuf/q:a	Lcom/google/protobuf/x;
        //   186: aload_1
        //   187: athrow
        //   188: astore_1
        //   189: aload 5
        //   191: invokevirtual 106	com/google/protobuf/g:a	()V
        //   194: aload_0
        //   195: aload 4
        //   197: invokevirtual 111	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   200: putfield 62	com/whatsapp/proto/d$d$b:m	Lcom/google/protobuf/e;
        //   203: aload_1
        //   204: athrow
        //   205: aload_0
        //   206: aload_0
        //   207: getfield 96	com/whatsapp/proto/d$d$b:b	I
        //   210: iconst_2
        //   211: ior
        //   212: putfield 96	com/whatsapp/proto/d$d$b:b	I
        //   215: aload_0
        //   216: aload_1
        //   217: invokevirtual 99	com/google/protobuf/f:c	()Z
        //   220: putfield 113	com/whatsapp/proto/d$d$b:d	Z
        //   223: goto -188 -> 35
        //   226: astore_1
        //   227: new 76	com/google/protobuf/q
        //   230: dup
        //   231: aload_1
        //   232: invokevirtual 117	java/io/IOException:getMessage	()Ljava/lang/String;
        //   235: invokespecial 120	com/google/protobuf/q:<init>	(Ljava/lang/String;)V
        //   238: astore_1
        //   239: aload_1
        //   240: aload_0
        //   241: putfield 104	com/google/protobuf/q:a	Lcom/google/protobuf/x;
        //   244: aload_1
        //   245: athrow
        //   246: aload_0
        //   247: aload_0
        //   248: getfield 96	com/whatsapp/proto/d$d$b:b	I
        //   251: iconst_4
        //   252: ior
        //   253: putfield 96	com/whatsapp/proto/d$d$b:b	I
        //   256: aload_0
        //   257: aload_1
        //   258: invokevirtual 99	com/google/protobuf/f:c	()Z
        //   261: putfield 122	com/whatsapp/proto/d$d$b:e	Z
        //   264: goto -229 -> 35
        //   267: aload_0
        //   268: aload_0
        //   269: getfield 96	com/whatsapp/proto/d$d$b:b	I
        //   272: bipush 8
        //   274: ior
        //   275: putfield 96	com/whatsapp/proto/d$d$b:b	I
        //   278: aload_0
        //   279: aload_1
        //   280: invokevirtual 99	com/google/protobuf/f:c	()Z
        //   283: putfield 124	com/whatsapp/proto/d$d$b:f	Z
        //   286: goto -251 -> 35
        //   289: aload_0
        //   290: aload_0
        //   291: getfield 96	com/whatsapp/proto/d$d$b:b	I
        //   294: bipush 16
        //   296: ior
        //   297: putfield 96	com/whatsapp/proto/d$d$b:b	I
        //   300: aload_0
        //   301: aload_1
        //   302: invokevirtual 99	com/google/protobuf/f:c	()Z
        //   305: putfield 126	com/whatsapp/proto/d$d$b:g	Z
        //   308: goto -273 -> 35
        //   311: aload_0
        //   312: aload_0
        //   313: getfield 96	com/whatsapp/proto/d$d$b:b	I
        //   316: bipush 32
        //   318: ior
        //   319: putfield 96	com/whatsapp/proto/d$d$b:b	I
        //   322: aload_0
        //   323: aload_1
        //   324: invokevirtual 99	com/google/protobuf/f:c	()Z
        //   327: putfield 128	com/whatsapp/proto/d$d$b:h	Z
        //   330: goto -295 -> 35
        //   333: aload_0
        //   334: aload_0
        //   335: getfield 96	com/whatsapp/proto/d$d$b:b	I
        //   338: bipush 64
        //   340: ior
        //   341: putfield 96	com/whatsapp/proto/d$d$b:b	I
        //   344: aload_0
        //   345: aload_1
        //   346: invokevirtual 99	com/google/protobuf/f:c	()Z
        //   349: putfield 130	com/whatsapp/proto/d$d$b:i	Z
        //   352: goto -317 -> 35
        //   355: aload_0
        //   356: aload_0
        //   357: getfield 96	com/whatsapp/proto/d$d$b:b	I
        //   360: sipush 128
        //   363: ior
        //   364: putfield 96	com/whatsapp/proto/d$d$b:b	I
        //   367: aload_0
        //   368: aload_1
        //   369: invokevirtual 99	com/google/protobuf/f:c	()Z
        //   372: putfield 132	com/whatsapp/proto/d$d$b:j	Z
        //   375: goto -340 -> 35
        //   378: aload_0
        //   379: aload_0
        //   380: getfield 96	com/whatsapp/proto/d$d$b:b	I
        //   383: sipush 256
        //   386: ior
        //   387: putfield 96	com/whatsapp/proto/d$d$b:b	I
        //   390: aload_0
        //   391: aload_1
        //   392: invokevirtual 99	com/google/protobuf/f:c	()Z
        //   395: putfield 134	com/whatsapp/proto/d$d$b:k	Z
        //   398: goto -363 -> 35
        //   401: aload_1
        //   402: invokevirtual 136	com/google/protobuf/f:d	()Lcom/google/protobuf/e;
        //   405: astore 6
        //   407: aload_0
        //   408: aload_0
        //   409: getfield 96	com/whatsapp/proto/d$d$b:b	I
        //   412: sipush 512
        //   415: ior
        //   416: putfield 96	com/whatsapp/proto/d$d$b:b	I
        //   419: aload_0
        //   420: aload 6
        //   422: putfield 138	com/whatsapp/proto/d$d$b:n	Ljava/lang/Object;
        //   425: goto -390 -> 35
        //   428: aload 5
        //   430: invokevirtual 106	com/google/protobuf/g:a	()V
        //   433: aload_0
        //   434: aload 4
        //   436: invokevirtual 111	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   439: putfield 62	com/whatsapp/proto/d$d$b:m	Lcom/google/protobuf/e;
        //   442: return
        //   443: astore_1
        //   444: aload_0
        //   445: aload 4
        //   447: invokevirtual 111	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   450: putfield 62	com/whatsapp/proto/d$d$b:m	Lcom/google/protobuf/e;
        //   453: return
        //   454: astore_1
        //   455: aload_0
        //   456: aload 4
        //   458: invokevirtual 111	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   461: putfield 62	com/whatsapp/proto/d$d$b:m	Lcom/google/protobuf/e;
        //   464: aload_1
        //   465: athrow
        //   466: astore 5
        //   468: aload_0
        //   469: aload 4
        //   471: invokevirtual 111	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   474: putfield 62	com/whatsapp/proto/d$d$b:m	Lcom/google/protobuf/e;
        //   477: goto -274 -> 203
        //   480: astore_1
        //   481: aload_0
        //   482: aload 4
        //   484: invokevirtual 111	com/google/protobuf/e$c:a	()Lcom/google/protobuf/e;
        //   487: putfield 62	com/whatsapp/proto/d$d$b:m	Lcom/google/protobuf/e;
        //   490: aload_1
        //   491: athrow
        //   492: goto -348 -> 144
        //   495: iconst_1
        //   496: istore_2
        //   497: goto -462 -> 35
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	500	0	this	b
        //   0	500	1	paramf	com.google.protobuf.f
        //   34	463	2	i1	int
        //   43	103	3	i2	int
        //   21	462	4	localc	com.google.protobuf.e.c
        //   31	398	5	localg	g
        //   466	1	5	localIOException	java.io.IOException
        //   405	16	6	locale	e
        // Exception table:
        //   from	to	target	type
        //   39	44	180	com/google/protobuf/q
        //   144	154	180	com/google/protobuf/q
        //   159	177	180	com/google/protobuf/q
        //   205	223	180	com/google/protobuf/q
        //   246	264	180	com/google/protobuf/q
        //   267	286	180	com/google/protobuf/q
        //   289	308	180	com/google/protobuf/q
        //   311	330	180	com/google/protobuf/q
        //   333	352	180	com/google/protobuf/q
        //   355	375	180	com/google/protobuf/q
        //   378	398	180	com/google/protobuf/q
        //   401	425	180	com/google/protobuf/q
        //   39	44	188	finally
        //   144	154	188	finally
        //   159	177	188	finally
        //   181	188	188	finally
        //   205	223	188	finally
        //   227	246	188	finally
        //   246	264	188	finally
        //   267	286	188	finally
        //   289	308	188	finally
        //   311	330	188	finally
        //   333	352	188	finally
        //   355	375	188	finally
        //   378	398	188	finally
        //   401	425	188	finally
        //   39	44	226	java/io/IOException
        //   144	154	226	java/io/IOException
        //   159	177	226	java/io/IOException
        //   205	223	226	java/io/IOException
        //   246	264	226	java/io/IOException
        //   267	286	226	java/io/IOException
        //   289	308	226	java/io/IOException
        //   311	330	226	java/io/IOException
        //   333	352	226	java/io/IOException
        //   355	375	226	java/io/IOException
        //   378	398	226	java/io/IOException
        //   401	425	226	java/io/IOException
        //   428	433	443	java/io/IOException
        //   428	433	454	finally
        //   189	194	466	java/io/IOException
        //   189	194	480	finally
      }
      
      public static a a(b paramb)
      {
        return a.d().a(paramb);
      }
      
      public static b a()
      {
        return l;
      }
      
      private e b()
      {
        Object localObject = this.n;
        if ((localObject instanceof String))
        {
          localObject = e.a((String)localObject);
          this.n = localObject;
          return (e)localObject;
        }
        return (e)localObject;
      }
      
      private void c()
      {
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.n = "";
      }
      
      public final ae<b> getParserForType()
      {
        return a;
      }
      
      public final int getSerializedSize()
      {
        int i1 = this.p;
        if (i1 != -1) {
          return i1;
        }
        int i2 = 0;
        if ((this.b & 0x1) == 1) {
          i2 = g.d(1) + 1 + 0;
        }
        i1 = i2;
        if ((this.b & 0x2) == 2) {
          i1 = i2 + (g.d(2) + 1);
        }
        i2 = i1;
        if ((this.b & 0x4) == 4) {
          i2 = i1 + (g.d(3) + 1);
        }
        i1 = i2;
        if ((this.b & 0x8) == 8) {
          i1 = i2 + (g.d(4) + 1);
        }
        i2 = i1;
        if ((this.b & 0x10) == 16) {
          i2 = i1 + (g.d(5) + 1);
        }
        i1 = i2;
        if ((this.b & 0x20) == 32) {
          i1 = i2 + (g.d(6) + 1);
        }
        i2 = i1;
        if ((this.b & 0x40) == 64) {
          i2 = i1 + (g.d(7) + 1);
        }
        i1 = i2;
        if ((this.b & 0x80) == 128) {
          i1 = i2 + (g.d(8) + 1);
        }
        i2 = i1;
        if ((this.b & 0x100) == 256) {
          i2 = i1 + (g.d(9) + 1);
        }
        i1 = i2;
        if ((this.b & 0x200) == 512) {
          i1 = i2 + g.c(10, b());
        }
        i1 += this.m.a();
        this.p = i1;
        return i1;
      }
      
      public final boolean isInitialized()
      {
        int i1 = this.o;
        if (i1 == 1) {
          return true;
        }
        if (i1 == 0) {
          return false;
        }
        this.o = 1;
        return true;
      }
      
      public final void writeTo(g paramg)
      {
        getSerializedSize();
        if ((this.b & 0x1) == 1) {
          paramg.a(1, this.c);
        }
        if ((this.b & 0x2) == 2) {
          paramg.a(2, this.d);
        }
        if ((this.b & 0x4) == 4) {
          paramg.a(3, this.e);
        }
        if ((this.b & 0x8) == 8) {
          paramg.a(4, this.f);
        }
        if ((this.b & 0x10) == 16) {
          paramg.a(5, this.g);
        }
        if ((this.b & 0x20) == 32) {
          paramg.a(6, this.h);
        }
        if ((this.b & 0x40) == 64) {
          paramg.a(7, this.i);
        }
        if ((this.b & 0x80) == 128) {
          paramg.a(8, this.j);
        }
        if ((this.b & 0x100) == 256) {
          paramg.a(9, this.k);
        }
        if ((this.b & 0x200) == 512) {
          paramg.a(10, b());
        }
        paramg.c(this.m);
      }
      
      public static final class a
        extends GeneratedMessageLite.a<d.d.b, a>
        implements f.a
      {
        private int b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        private boolean h;
        private boolean i;
        private boolean j;
        private boolean k;
        private Object l = "";
        
        /* Error */
        private a a(com.google.protobuf.f paramf, com.google.protobuf.m paramm)
        {
          // Byte code:
          //   0: getstatic 43	com/whatsapp/proto/d$d$b:a	Lcom/google/protobuf/ae;
          //   3: aload_1
          //   4: aload_2
          //   5: invokeinterface 48 3 0
          //   10: checkcast 14	com/whatsapp/proto/d$d$b
          //   13: astore_1
          //   14: aload_1
          //   15: ifnull +9 -> 24
          //   18: aload_0
          //   19: aload_1
          //   20: invokevirtual 51	com/whatsapp/proto/d$d$b$a:a	(Lcom/whatsapp/proto/d$d$b;)Lcom/whatsapp/proto/d$d$b$a;
          //   23: pop
          //   24: aload_0
          //   25: areturn
          //   26: astore_2
          //   27: aload_2
          //   28: getfield 54	com/google/protobuf/q:a	Lcom/google/protobuf/x;
          //   31: checkcast 14	com/whatsapp/proto/d$d$b
          //   34: astore_1
          //   35: aload_2
          //   36: athrow
          //   37: astore_2
          //   38: aload_1
          //   39: ifnull +9 -> 48
          //   42: aload_0
          //   43: aload_1
          //   44: invokevirtual 51	com/whatsapp/proto/d$d$b$a:a	(Lcom/whatsapp/proto/d$d$b;)Lcom/whatsapp/proto/d$d$b$a;
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
        
        private a e()
        {
          return new a().a(c());
        }
        
        public final a a(d.d.b paramb)
        {
          int n = 1;
          if (paramb == d.d.b.a()) {
            return this;
          }
          if ((paramb.b & 0x1) == 1)
          {
            m = 1;
            boolean bool;
            if (m != 0)
            {
              bool = paramb.c;
              this.b |= 0x1;
              this.c = bool;
            }
            if ((paramb.b & 0x2) != 2) {
              break label425;
            }
            m = 1;
            label61:
            if (m != 0)
            {
              bool = paramb.d;
              this.b |= 0x2;
              this.d = bool;
            }
            if ((paramb.b & 0x4) != 4) {
              break label430;
            }
            m = 1;
            label99:
            if (m != 0)
            {
              bool = paramb.e;
              this.b |= 0x4;
              this.e = bool;
            }
            if ((paramb.b & 0x8) != 8) {
              break label435;
            }
            m = 1;
            label139:
            if (m != 0) {
              a(paramb.f);
            }
            if ((paramb.b & 0x10) != 16) {
              break label440;
            }
            m = 1;
            label166:
            if (m != 0)
            {
              bool = paramb.g;
              this.b |= 0x10;
              this.g = bool;
            }
            if ((paramb.b & 0x20) != 32) {
              break label445;
            }
            m = 1;
            label207:
            if (m != 0)
            {
              bool = paramb.h;
              this.b |= 0x20;
              this.h = bool;
            }
            if ((paramb.b & 0x40) != 64) {
              break label450;
            }
            m = 1;
            label248:
            if (m != 0)
            {
              bool = paramb.i;
              this.b |= 0x40;
              this.i = bool;
            }
            if ((paramb.b & 0x80) != 128) {
              break label455;
            }
            m = 1;
            label291:
            if (m != 0)
            {
              bool = paramb.j;
              this.b |= 0x80;
              this.j = bool;
            }
            if ((paramb.b & 0x100) != 256) {
              break label460;
            }
            m = 1;
            label335:
            if (m != 0)
            {
              bool = paramb.k;
              this.b |= 0x100;
              this.k = bool;
            }
            if ((paramb.b & 0x200) != 512) {
              break label465;
            }
          }
          label425:
          label430:
          label435:
          label440:
          label445:
          label450:
          label455:
          label460:
          label465:
          for (int m = n;; m = 0)
          {
            if (m != 0)
            {
              this.b |= 0x200;
              this.l = d.d.b.b(paramb);
            }
            this.a = this.a.a(d.d.b.c(paramb));
            return this;
            m = 0;
            break;
            m = 0;
            break label61;
            m = 0;
            break label99;
            m = 0;
            break label139;
            m = 0;
            break label166;
            m = 0;
            break label207;
            m = 0;
            break label248;
            m = 0;
            break label291;
            m = 0;
            break label335;
          }
        }
        
        public final a a(boolean paramBoolean)
        {
          this.b |= 0x8;
          this.f = paramBoolean;
          return this;
        }
        
        public final d.d.b b()
        {
          d.d.b localb = c();
          if (!localb.isInitialized()) {
            throw new am();
          }
          return localb;
        }
        
        public final d.d.b c()
        {
          int n = 1;
          d.d.b localb = new d.d.b(this, (byte)0);
          int i1 = this.b;
          if ((i1 & 0x1) == 1) {}
          for (;;)
          {
            d.d.b.a(localb, this.c);
            int m = n;
            if ((i1 & 0x2) == 2) {
              m = n | 0x2;
            }
            d.d.b.b(localb, this.d);
            n = m;
            if ((i1 & 0x4) == 4) {
              n = m | 0x4;
            }
            d.d.b.c(localb, this.e);
            m = n;
            if ((i1 & 0x8) == 8) {
              m = n | 0x8;
            }
            d.d.b.d(localb, this.f);
            n = m;
            if ((i1 & 0x10) == 16) {
              n = m | 0x10;
            }
            d.d.b.e(localb, this.g);
            m = n;
            if ((i1 & 0x20) == 32) {
              m = n | 0x20;
            }
            d.d.b.f(localb, this.h);
            n = m;
            if ((i1 & 0x40) == 64) {
              n = m | 0x40;
            }
            d.d.b.g(localb, this.i);
            m = n;
            if ((i1 & 0x80) == 128) {
              m = n | 0x80;
            }
            d.d.b.h(localb, this.j);
            n = m;
            if ((i1 & 0x100) == 256) {
              n = m | 0x100;
            }
            d.d.b.i(localb, this.k);
            m = n;
            if ((i1 & 0x200) == 512) {
              m = n | 0x200;
            }
            d.d.b.a(localb, this.l);
            d.d.b.a(localb, m);
            return localb;
            n = 0;
          }
        }
        
        public final boolean isInitialized()
        {
          return true;
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/proto/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */