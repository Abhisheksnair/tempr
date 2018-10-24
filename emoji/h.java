package com.whatsapp.emoji;

import a.a.a.a.a.a.d;
import com.whatsapp.EmojiPicker.EmojiWeight;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class h
{
  private static volatile h b;
  private static Comparator<EmojiPicker.EmojiWeight> c = ;
  public List<EmojiPicker.EmojiWeight> a;
  
  public static h a()
  {
    try
    {
      if (b == null) {
        b = new h();
      }
      h localh = b;
      return localh;
    }
    finally {}
  }
  
  private void f()
  {
    a.d.a(this.a);
    for (;;)
    {
      int i;
      synchronized (this.a)
      {
        i = this.a.size() - 1;
        if (i > 35)
        {
          if (((EmojiPicker.EmojiWeight)this.a.get(i)).weight < 0.1F) {
            this.a.remove(i);
          }
        }
        else {
          return;
        }
      }
      i -= 1;
    }
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/whatsapp/emoji/h:a	Ljava/util/List;
    //   4: invokestatic 50	a/a/a/a/a/a$d:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7: pop
    //   8: aload_0
    //   9: getfield 45	com/whatsapp/emoji/h:a	Ljava/util/List;
    //   12: astore 4
    //   14: aload 4
    //   16: monitorenter
    //   17: aconst_null
    //   18: astore_1
    //   19: new 69	java/io/ObjectOutputStream
    //   22: dup
    //   23: new 71	java/io/FileOutputStream
    //   26: dup
    //   27: new 73	java/io/File
    //   30: dup
    //   31: invokestatic 78	com/whatsapp/u:a	()Landroid/content/Context;
    //   34: invokevirtual 84	android/content/Context:getFilesDir	()Ljava/io/File;
    //   37: ldc 86
    //   39: invokespecial 89	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   42: invokespecial 92	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   45: invokespecial 95	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   48: astore_2
    //   49: aload_2
    //   50: astore_1
    //   51: aload_2
    //   52: aload_0
    //   53: getfield 45	com/whatsapp/emoji/h:a	Ljava/util/List;
    //   56: invokevirtual 99	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   59: aload_2
    //   60: invokestatic 102	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   63: aload 4
    //   65: monitorexit
    //   66: return
    //   67: astore_3
    //   68: aconst_null
    //   69: astore_2
    //   70: aload_2
    //   71: astore_1
    //   72: aload_3
    //   73: invokestatic 108	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
    //   76: aload_2
    //   77: invokestatic 102	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   80: goto -17 -> 63
    //   83: astore_1
    //   84: aload 4
    //   86: monitorexit
    //   87: aload_1
    //   88: athrow
    //   89: astore_3
    //   90: aload_1
    //   91: astore_2
    //   92: aload_3
    //   93: astore_1
    //   94: aload_2
    //   95: invokestatic 102	a/a/a/a/a/a$d:a	(Ljava/io/Closeable;)V
    //   98: aload_1
    //   99: athrow
    //   100: astore_3
    //   101: aload_1
    //   102: astore_2
    //   103: aload_3
    //   104: astore_1
    //   105: goto -11 -> 94
    //   108: astore_3
    //   109: goto -39 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	h
    //   18	54	1	localObject1	Object
    //   83	8	1	localObject2	Object
    //   93	12	1	localObject3	Object
    //   48	55	2	localObject4	Object
    //   67	6	3	localIOException1	java.io.IOException
    //   89	4	3	localObject5	Object
    //   100	4	3	localObject6	Object
    //   108	1	3	localIOException2	java.io.IOException
    //   12	73	4	localList	List
    // Exception table:
    //   from	to	target	type
    //   19	49	67	java/io/IOException
    //   59	63	83	finally
    //   63	66	83	finally
    //   76	80	83	finally
    //   84	87	83	finally
    //   94	100	83	finally
    //   19	49	89	finally
    //   51	59	100	finally
    //   72	76	100	finally
    //   51	59	108	java/io/IOException
  }
  
  public final void a(Map<String, Float> paramMap)
  {
    b();
    Object localObject1;
    Object localObject2;
    synchronized (this.a)
    {
      localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (EmojiPicker.EmojiWeight)localIterator.next();
        localObject2 = new String(((EmojiPicker.EmojiWeight)localObject1).emoji, 0, ((EmojiPicker.EmojiWeight)localObject1).emoji.length);
        Float localFloat = (Float)paramMap.get(localObject2);
        if (localFloat != null)
        {
          float f = ((EmojiPicker.EmojiWeight)localObject1).weight;
          ((EmojiPicker.EmojiWeight)localObject1).weight = ((localFloat.floatValue() + f) / 2.0F);
          paramMap.remove(localObject2);
        }
      }
    }
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (String)localIterator.next();
      localObject2 = new int[((String)localObject1).codePointCount(0, ((String)localObject1).length())];
      int k = ((String)localObject1).length();
      int j = 0;
      int i = 0;
      while (j < k)
      {
        int m = ((String)localObject1).codePointAt(j);
        localObject2[i] = m;
        j += Character.charCount(m);
        i += 1;
      }
      this.a.add(new EmojiPicker.EmojiWeight((int[])localObject2, ((Float)paramMap.get(localObject1)).floatValue()));
    }
    Collections.sort(this.a, c);
    f();
    g();
  }
  
  public final boolean a(int[] paramArrayOfInt)
  {
    b();
    boolean bool;
    for (;;)
    {
      EmojiPicker.EmojiWeight localEmojiWeight;
      synchronized (this.a)
      {
        Iterator localIterator = this.a.iterator();
        bool = false;
        if (!localIterator.hasNext()) {
          break;
        }
        localEmojiWeight = (EmojiPicker.EmojiWeight)localIterator.next();
        if (!localEmojiWeight.compareEmoji(paramArrayOfInt)) {
          localEmojiWeight.weight *= 0.9F;
        }
      }
      localEmojiWeight.weight += 1.0F;
      bool = true;
    }
    if (!bool) {
      this.a.add(new EmojiPicker.EmojiWeight(paramArrayOfInt, 1.0F));
    }
    Collections.sort(this.a, c);
    f();
    g();
    return bool;
  }
  
  /* Error */
  public final void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	com/whatsapp/emoji/h:a	Ljava/util/List;
    //   4: ifnonnull +390 -> 394
    //   7: new 73	java/io/File
    //   10: dup
    //   11: invokestatic 78	com/whatsapp/u:a	()Landroid/content/Context;
    //   14: invokevirtual 84	android/content/Context:getFilesDir	()Ljava/io/File;
    //   17: ldc 86
    //   19: invokespecial 89	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   22: astore 6
    //   24: aload 6
    //   26: invokevirtual 195	java/io/File:exists	()Z
    //   29: ifeq +344 -> 373
    //   32: new 197	java/io/ObjectInputStream
    //   35: dup
    //   36: new 199	java/io/FileInputStream
    //   39: dup
    //   40: aload 6
    //   42: invokespecial 200	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: invokespecial 203	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore 4
    //   50: aload_0
    //   51: new 205	java/util/ArrayList
    //   54: dup
    //   55: aload 4
    //   57: invokevirtual 208	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   60: checkcast 52	java/util/List
    //   63: invokespecial 211	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   66: invokestatic 215	java/util/Collections:synchronizedList	(Ljava/util/List;)Ljava/util/List;
    //   69: putfield 45	com/whatsapp/emoji/h:a	Ljava/util/List;
    //   72: aload_0
    //   73: getfield 45	com/whatsapp/emoji/h:a	Ljava/util/List;
    //   76: astore 7
    //   78: aload 7
    //   80: monitorenter
    //   81: new 205	java/util/ArrayList
    //   84: dup
    //   85: invokespecial 216	java/util/ArrayList:<init>	()V
    //   88: astore 8
    //   90: new 218	java/util/HashSet
    //   93: dup
    //   94: invokespecial 219	java/util/HashSet:<init>	()V
    //   97: astore 9
    //   99: aload_0
    //   100: getfield 45	com/whatsapp/emoji/h:a	Ljava/util/List;
    //   103: invokeinterface 115 1 0
    //   108: astore 10
    //   110: aload 10
    //   112: invokeinterface 121 1 0
    //   117: ifeq +1087 -> 1204
    //   120: aload 10
    //   122: invokeinterface 125 1 0
    //   127: checkcast 28	com/whatsapp/EmojiPicker$EmojiWeight
    //   130: astore 11
    //   132: aload 11
    //   134: getfield 130	com/whatsapp/EmojiPicker$EmojiWeight:emoji	[I
    //   137: ifnonnull +46 -> 183
    //   140: aload 11
    //   142: getfield 223	com/whatsapp/EmojiPicker$EmojiWeight:modifier	I
    //   145: ifeq +250 -> 395
    //   148: aload 11
    //   150: iconst_2
    //   151: newarray <illegal type>
    //   153: putfield 130	com/whatsapp/EmojiPicker$EmojiWeight:emoji	[I
    //   156: aload 11
    //   158: getfield 130	com/whatsapp/EmojiPicker$EmojiWeight:emoji	[I
    //   161: iconst_0
    //   162: aload 11
    //   164: getfield 226	com/whatsapp/EmojiPicker$EmojiWeight:code	I
    //   167: invokestatic 231	a/a/a/a/d:d	(I)I
    //   170: iastore
    //   171: aload 11
    //   173: getfield 130	com/whatsapp/EmojiPicker$EmojiWeight:emoji	[I
    //   176: iconst_1
    //   177: aload 11
    //   179: getfield 223	com/whatsapp/EmojiPicker$EmojiWeight:modifier	I
    //   182: iastore
    //   183: aload 11
    //   185: getfield 130	com/whatsapp/EmojiPicker$EmojiWeight:emoji	[I
    //   188: invokestatic 236	com/whatsapp/EmojiPicker:c	([I)I
    //   191: istore_1
    //   192: iload_1
    //   193: iconst_m1
    //   194: if_icmpne +11 -> 205
    //   197: aload 8
    //   199: aload 11
    //   201: invokevirtual 237	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   204: pop
    //   205: aload 11
    //   207: getfield 130	com/whatsapp/EmojiPicker$EmojiWeight:emoji	[I
    //   210: arraylength
    //   211: iconst_2
    //   212: if_icmpne +967 -> 1179
    //   215: aload 11
    //   217: getfield 130	com/whatsapp/EmojiPicker$EmojiWeight:emoji	[I
    //   220: iconst_1
    //   221: iaload
    //   222: ifne +957 -> 1179
    //   225: aload 11
    //   227: getfield 130	com/whatsapp/EmojiPicker$EmojiWeight:emoji	[I
    //   230: invokestatic 239	a/a/a/a/d:a	([I)Z
    //   233: ifeq +946 -> 1179
    //   236: aload 11
    //   238: getfield 130	com/whatsapp/EmojiPicker$EmojiWeight:emoji	[I
    //   241: iconst_0
    //   242: iaload
    //   243: istore_2
    //   244: aload 11
    //   246: iconst_1
    //   247: newarray <illegal type>
    //   249: putfield 130	com/whatsapp/EmojiPicker$EmojiWeight:emoji	[I
    //   252: aload 11
    //   254: getfield 130	com/whatsapp/EmojiPicker$EmojiWeight:emoji	[I
    //   257: iconst_0
    //   258: iload_2
    //   259: iastore
    //   260: aload_0
    //   261: getfield 45	com/whatsapp/emoji/h:a	Ljava/util/List;
    //   264: invokeinterface 115 1 0
    //   269: astore_3
    //   270: aload_3
    //   271: invokeinterface 121 1 0
    //   276: ifeq +903 -> 1179
    //   279: aload_3
    //   280: invokeinterface 125 1 0
    //   285: checkcast 28	com/whatsapp/EmojiPicker$EmojiWeight
    //   288: astore 5
    //   290: aload 5
    //   292: aload 11
    //   294: if_acmpeq +885 -> 1179
    //   297: aload 5
    //   299: aload 11
    //   301: getfield 130	com/whatsapp/EmojiPicker$EmojiWeight:emoji	[I
    //   304: invokevirtual 189	com/whatsapp/EmojiPicker$EmojiWeight:compareEmoji	([I)Z
    //   307: ifeq -37 -> 270
    //   310: aload 8
    //   312: aload 11
    //   314: invokevirtual 237	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   317: pop
    //   318: goto -48 -> 270
    //   321: astore_3
    //   322: aload 7
    //   324: monitorexit
    //   325: aload_3
    //   326: athrow
    //   327: astore 5
    //   329: aload 4
    //   331: astore_3
    //   332: aload 5
    //   334: astore 4
    //   336: new 241	java/lang/StringBuilder
    //   339: dup
    //   340: ldc -13
    //   342: invokespecial 246	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   345: aload 4
    //   347: invokevirtual 250	java/lang/Exception:toString	()Ljava/lang/String;
    //   350: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokestatic 257	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   359: aload 6
    //   361: invokevirtual 260	java/io/File:delete	()Z
    //   364: pop
    //   365: aload_3
    //   366: ifnull +7 -> 373
    //   369: aload_3
    //   370: invokevirtual 263	java/io/ObjectInputStream:close	()V
    //   373: aload_0
    //   374: getfield 45	com/whatsapp/emoji/h:a	Ljava/util/List;
    //   377: ifnonnull +17 -> 394
    //   380: aload_0
    //   381: new 205	java/util/ArrayList
    //   384: dup
    //   385: invokespecial 216	java/util/ArrayList:<init>	()V
    //   388: invokestatic 215	java/util/Collections:synchronizedList	(Ljava/util/List;)Ljava/util/List;
    //   391: putfield 45	com/whatsapp/emoji/h:a	Ljava/util/List;
    //   394: return
    //   395: aload 11
    //   397: getfield 226	com/whatsapp/EmojiPicker$EmojiWeight:code	I
    //   400: istore_1
    //   401: iload_1
    //   402: lookupswitch	default:+876->1278, 58635:+923->1325, 58636:+944->1346, 58637:+902->1304, 58638:+888->1290, 58639:+916->1318, 58640:+909->1311, 58641:+895->1297, 58642:+937->1339, 58643:+881->1283, 58644:+930->1332, 60417:+951->1353, 60418:+958->1360, 60419:+965->1367, 60420:+972->1374, 60421:+979->1381, 60422:+986->1388, 60423:+993->1395, 60424:+1000->1402, 60425:+1007->1409, 60426:+1014->1416, 60427:+1021->1423, 60428:+1028->1430, 60429:+1035->1437, 60430:+1042->1444, 60431:+1049->1451, 60432:+1056->1458, 60433:+1063->1465, 60434:+1070->1472, 60435:+1077->1479, 60436:+1084->1486, 60437:+1091->1493, 60438:+1098->1500, 60439:+1105->1507, 60440:+1112->1514, 60441:+1119->1521, 60442:+1126->1528, 60443:+1133->1535, 60444:+1140->1542, 60445:+1147->1549, 60446:+1154->1556, 60447:+1161->1563, 60448:+1168->1570, 60449:+1175->1577, 60450:+1182->1584, 60451:+1189->1591, 60452:+1196->1598, 60453:+1203->1605, 60454:+1210->1612, 60455:+1217->1619, 60456:+1224->1626, 60457:+1231->1633, 60458:+1238->1640, 60459:+1245->1647, 60460:+1252->1654, 60461:+1259->1661, 60462:+1266->1668, 60463:+1273->1675, 60464:+1280->1682
    //   876: aload_3
    //   877: ifnull +812 -> 1689
    //   880: iconst_2
    //   881: newarray <illegal type>
    //   883: astore 5
    //   885: aload 5
    //   887: iconst_0
    //   888: aload_3
    //   889: iconst_0
    //   890: invokevirtual 267	java/lang/String:charAt	(I)C
    //   893: ldc_w 268
    //   896: iadd
    //   897: bipush 65
    //   899: isub
    //   900: iastore
    //   901: aload 5
    //   903: iconst_1
    //   904: aload_3
    //   905: iconst_1
    //   906: invokevirtual 267	java/lang/String:charAt	(I)C
    //   909: ldc_w 268
    //   912: iadd
    //   913: bipush 65
    //   915: isub
    //   916: iastore
    //   917: aload 5
    //   919: astore_3
    //   920: aload_3
    //   921: ifnull +232 -> 1153
    //   924: aload 11
    //   926: aload_3
    //   927: putfield 130	com/whatsapp/EmojiPicker$EmojiWeight:emoji	[I
    //   930: goto -747 -> 183
    //   933: iconst_2
    //   934: newarray <illegal type>
    //   936: astore_3
    //   937: aload_3
    //   938: dup
    //   939: iconst_0
    //   940: bipush 35
    //   942: iastore
    //   943: dup
    //   944: iconst_1
    //   945: sipush 8419
    //   948: iastore
    //   949: pop
    //   950: goto -30 -> 920
    //   953: iconst_2
    //   954: newarray <illegal type>
    //   956: astore_3
    //   957: aload_3
    //   958: dup
    //   959: iconst_0
    //   960: bipush 49
    //   962: iastore
    //   963: dup
    //   964: iconst_1
    //   965: sipush 8419
    //   968: iastore
    //   969: pop
    //   970: goto -50 -> 920
    //   973: iconst_2
    //   974: newarray <illegal type>
    //   976: astore_3
    //   977: aload_3
    //   978: dup
    //   979: iconst_0
    //   980: bipush 50
    //   982: iastore
    //   983: dup
    //   984: iconst_1
    //   985: sipush 8419
    //   988: iastore
    //   989: pop
    //   990: goto -70 -> 920
    //   993: iconst_2
    //   994: newarray <illegal type>
    //   996: astore_3
    //   997: aload_3
    //   998: dup
    //   999: iconst_0
    //   1000: bipush 51
    //   1002: iastore
    //   1003: dup
    //   1004: iconst_1
    //   1005: sipush 8419
    //   1008: iastore
    //   1009: pop
    //   1010: goto -90 -> 920
    //   1013: iconst_2
    //   1014: newarray <illegal type>
    //   1016: astore_3
    //   1017: aload_3
    //   1018: dup
    //   1019: iconst_0
    //   1020: bipush 52
    //   1022: iastore
    //   1023: dup
    //   1024: iconst_1
    //   1025: sipush 8419
    //   1028: iastore
    //   1029: pop
    //   1030: goto -110 -> 920
    //   1033: iconst_2
    //   1034: newarray <illegal type>
    //   1036: astore_3
    //   1037: aload_3
    //   1038: dup
    //   1039: iconst_0
    //   1040: bipush 53
    //   1042: iastore
    //   1043: dup
    //   1044: iconst_1
    //   1045: sipush 8419
    //   1048: iastore
    //   1049: pop
    //   1050: goto -130 -> 920
    //   1053: iconst_2
    //   1054: newarray <illegal type>
    //   1056: astore_3
    //   1057: aload_3
    //   1058: dup
    //   1059: iconst_0
    //   1060: bipush 54
    //   1062: iastore
    //   1063: dup
    //   1064: iconst_1
    //   1065: sipush 8419
    //   1068: iastore
    //   1069: pop
    //   1070: goto -150 -> 920
    //   1073: iconst_2
    //   1074: newarray <illegal type>
    //   1076: astore_3
    //   1077: aload_3
    //   1078: dup
    //   1079: iconst_0
    //   1080: bipush 55
    //   1082: iastore
    //   1083: dup
    //   1084: iconst_1
    //   1085: sipush 8419
    //   1088: iastore
    //   1089: pop
    //   1090: goto -170 -> 920
    //   1093: iconst_2
    //   1094: newarray <illegal type>
    //   1096: astore_3
    //   1097: aload_3
    //   1098: dup
    //   1099: iconst_0
    //   1100: bipush 56
    //   1102: iastore
    //   1103: dup
    //   1104: iconst_1
    //   1105: sipush 8419
    //   1108: iastore
    //   1109: pop
    //   1110: goto -190 -> 920
    //   1113: iconst_2
    //   1114: newarray <illegal type>
    //   1116: astore_3
    //   1117: aload_3
    //   1118: dup
    //   1119: iconst_0
    //   1120: bipush 57
    //   1122: iastore
    //   1123: dup
    //   1124: iconst_1
    //   1125: sipush 8419
    //   1128: iastore
    //   1129: pop
    //   1130: goto -210 -> 920
    //   1133: iconst_2
    //   1134: newarray <illegal type>
    //   1136: astore_3
    //   1137: aload_3
    //   1138: dup
    //   1139: iconst_0
    //   1140: bipush 48
    //   1142: iastore
    //   1143: dup
    //   1144: iconst_1
    //   1145: sipush 8419
    //   1148: iastore
    //   1149: pop
    //   1150: goto -230 -> 920
    //   1153: aload 11
    //   1155: iconst_1
    //   1156: newarray <illegal type>
    //   1158: putfield 130	com/whatsapp/EmojiPicker$EmojiWeight:emoji	[I
    //   1161: aload 11
    //   1163: getfield 130	com/whatsapp/EmojiPicker$EmojiWeight:emoji	[I
    //   1166: iconst_0
    //   1167: aload 11
    //   1169: getfield 226	com/whatsapp/EmojiPicker$EmojiWeight:code	I
    //   1172: invokestatic 231	a/a/a/a/d:d	(I)I
    //   1175: iastore
    //   1176: goto -993 -> 183
    //   1179: aload 9
    //   1181: iload_1
    //   1182: invokestatic 274	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1185: invokeinterface 275 2 0
    //   1190: ifne -1080 -> 110
    //   1193: aload 8
    //   1195: aload 11
    //   1197: invokevirtual 237	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1200: pop
    //   1201: goto -1091 -> 110
    //   1204: aload_0
    //   1205: getfield 45	com/whatsapp/emoji/h:a	Ljava/util/List;
    //   1208: aload 8
    //   1210: invokeinterface 279 2 0
    //   1215: pop
    //   1216: aload 7
    //   1218: monitorexit
    //   1219: aload 4
    //   1221: invokevirtual 263	java/io/ObjectInputStream:close	()V
    //   1224: goto -851 -> 373
    //   1227: astore_3
    //   1228: goto -855 -> 373
    //   1231: astore_3
    //   1232: aconst_null
    //   1233: astore 4
    //   1235: aload 4
    //   1237: ifnull +8 -> 1245
    //   1240: aload 4
    //   1242: invokevirtual 263	java/io/ObjectInputStream:close	()V
    //   1245: aload_3
    //   1246: athrow
    //   1247: astore_3
    //   1248: goto -875 -> 373
    //   1251: astore 4
    //   1253: goto -8 -> 1245
    //   1256: astore_3
    //   1257: goto -22 -> 1235
    //   1260: astore 5
    //   1262: aload_3
    //   1263: astore 4
    //   1265: aload 5
    //   1267: astore_3
    //   1268: goto -33 -> 1235
    //   1271: astore 4
    //   1273: aconst_null
    //   1274: astore_3
    //   1275: goto -939 -> 336
    //   1278: aconst_null
    //   1279: astore_3
    //   1280: goto -404 -> 876
    //   1283: ldc_w 281
    //   1286: astore_3
    //   1287: goto -411 -> 876
    //   1290: ldc_w 283
    //   1293: astore_3
    //   1294: goto -418 -> 876
    //   1297: ldc_w 285
    //   1300: astore_3
    //   1301: goto -425 -> 876
    //   1304: ldc_w 287
    //   1307: astore_3
    //   1308: goto -432 -> 876
    //   1311: ldc_w 289
    //   1314: astore_3
    //   1315: goto -439 -> 876
    //   1318: ldc_w 291
    //   1321: astore_3
    //   1322: goto -446 -> 876
    //   1325: ldc_w 293
    //   1328: astore_3
    //   1329: goto -453 -> 876
    //   1332: ldc_w 295
    //   1335: astore_3
    //   1336: goto -460 -> 876
    //   1339: ldc_w 297
    //   1342: astore_3
    //   1343: goto -467 -> 876
    //   1346: ldc_w 299
    //   1349: astore_3
    //   1350: goto -474 -> 876
    //   1353: ldc_w 301
    //   1356: astore_3
    //   1357: goto -481 -> 876
    //   1360: ldc_w 303
    //   1363: astore_3
    //   1364: goto -488 -> 876
    //   1367: ldc_w 305
    //   1370: astore_3
    //   1371: goto -495 -> 876
    //   1374: ldc_w 307
    //   1377: astore_3
    //   1378: goto -502 -> 876
    //   1381: ldc_w 309
    //   1384: astore_3
    //   1385: goto -509 -> 876
    //   1388: ldc_w 311
    //   1391: astore_3
    //   1392: goto -516 -> 876
    //   1395: ldc_w 313
    //   1398: astore_3
    //   1399: goto -523 -> 876
    //   1402: ldc_w 315
    //   1405: astore_3
    //   1406: goto -530 -> 876
    //   1409: ldc_w 317
    //   1412: astore_3
    //   1413: goto -537 -> 876
    //   1416: ldc_w 319
    //   1419: astore_3
    //   1420: goto -544 -> 876
    //   1423: ldc_w 321
    //   1426: astore_3
    //   1427: goto -551 -> 876
    //   1430: ldc_w 323
    //   1433: astore_3
    //   1434: goto -558 -> 876
    //   1437: ldc_w 325
    //   1440: astore_3
    //   1441: goto -565 -> 876
    //   1444: ldc_w 327
    //   1447: astore_3
    //   1448: goto -572 -> 876
    //   1451: ldc_w 329
    //   1454: astore_3
    //   1455: goto -579 -> 876
    //   1458: ldc_w 331
    //   1461: astore_3
    //   1462: goto -586 -> 876
    //   1465: ldc_w 333
    //   1468: astore_3
    //   1469: goto -593 -> 876
    //   1472: ldc_w 335
    //   1475: astore_3
    //   1476: goto -600 -> 876
    //   1479: ldc_w 337
    //   1482: astore_3
    //   1483: goto -607 -> 876
    //   1486: ldc_w 339
    //   1489: astore_3
    //   1490: goto -614 -> 876
    //   1493: ldc_w 341
    //   1496: astore_3
    //   1497: goto -621 -> 876
    //   1500: ldc_w 343
    //   1503: astore_3
    //   1504: goto -628 -> 876
    //   1507: ldc_w 345
    //   1510: astore_3
    //   1511: goto -635 -> 876
    //   1514: ldc_w 347
    //   1517: astore_3
    //   1518: goto -642 -> 876
    //   1521: ldc_w 349
    //   1524: astore_3
    //   1525: goto -649 -> 876
    //   1528: ldc_w 351
    //   1531: astore_3
    //   1532: goto -656 -> 876
    //   1535: ldc_w 353
    //   1538: astore_3
    //   1539: goto -663 -> 876
    //   1542: ldc_w 355
    //   1545: astore_3
    //   1546: goto -670 -> 876
    //   1549: ldc_w 357
    //   1552: astore_3
    //   1553: goto -677 -> 876
    //   1556: ldc_w 359
    //   1559: astore_3
    //   1560: goto -684 -> 876
    //   1563: ldc_w 361
    //   1566: astore_3
    //   1567: goto -691 -> 876
    //   1570: ldc_w 363
    //   1573: astore_3
    //   1574: goto -698 -> 876
    //   1577: ldc_w 365
    //   1580: astore_3
    //   1581: goto -705 -> 876
    //   1584: ldc_w 367
    //   1587: astore_3
    //   1588: goto -712 -> 876
    //   1591: ldc_w 369
    //   1594: astore_3
    //   1595: goto -719 -> 876
    //   1598: ldc_w 371
    //   1601: astore_3
    //   1602: goto -726 -> 876
    //   1605: ldc_w 373
    //   1608: astore_3
    //   1609: goto -733 -> 876
    //   1612: ldc_w 375
    //   1615: astore_3
    //   1616: goto -740 -> 876
    //   1619: ldc_w 377
    //   1622: astore_3
    //   1623: goto -747 -> 876
    //   1626: ldc_w 379
    //   1629: astore_3
    //   1630: goto -754 -> 876
    //   1633: ldc_w 381
    //   1636: astore_3
    //   1637: goto -761 -> 876
    //   1640: ldc_w 383
    //   1643: astore_3
    //   1644: goto -768 -> 876
    //   1647: ldc_w 385
    //   1650: astore_3
    //   1651: goto -775 -> 876
    //   1654: ldc_w 387
    //   1657: astore_3
    //   1658: goto -782 -> 876
    //   1661: ldc_w 389
    //   1664: astore_3
    //   1665: goto -789 -> 876
    //   1668: ldc_w 391
    //   1671: astore_3
    //   1672: goto -796 -> 876
    //   1675: ldc_w 393
    //   1678: astore_3
    //   1679: goto -803 -> 876
    //   1682: ldc_w 395
    //   1685: astore_3
    //   1686: goto -810 -> 876
    //   1689: iload_1
    //   1690: tableswitch	default:+102->1792, 57872:+-757->933, 57873:+102->1792, 57874:+102->1792, 57875:+102->1792, 57876:+102->1792, 57877:+102->1792, 57878:+102->1792, 57879:+102->1792, 57880:+102->1792, 57881:+102->1792, 57882:+102->1792, 57883:+102->1792, 57884:+-737->953, 57885:+-717->973, 57886:+-697->993, 57887:+-677->1013, 57888:+-657->1033, 57889:+-637->1053, 57890:+-617->1073, 57891:+-597->1093, 57892:+-577->1113, 57893:+-557->1133
    //   1792: aconst_null
    //   1793: astore_3
    //   1794: goto -874 -> 920
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1797	0	this	h
    //   191	1499	1	i	int
    //   243	16	2	j	int
    //   269	11	3	localIterator1	Iterator
    //   321	5	3	localObject1	Object
    //   331	807	3	localObject2	Object
    //   1227	1	3	localIOException1	java.io.IOException
    //   1231	15	3	localObject3	Object
    //   1247	1	3	localIOException2	java.io.IOException
    //   1256	7	3	localObject4	Object
    //   1267	527	3	localObject5	Object
    //   48	1193	4	localObject6	Object
    //   1251	1	4	localIOException3	java.io.IOException
    //   1263	1	4	localObject7	Object
    //   1271	1	4	localException1	Exception
    //   288	10	5	localEmojiWeight1	EmojiPicker.EmojiWeight
    //   327	6	5	localException2	Exception
    //   883	35	5	arrayOfInt	int[]
    //   1260	6	5	localObject8	Object
    //   22	338	6	localFile	java.io.File
    //   76	1141	7	localList	List
    //   88	1121	8	localArrayList	ArrayList
    //   97	1083	9	localHashSet	java.util.HashSet
    //   108	13	10	localIterator2	Iterator
    //   130	1066	11	localEmojiWeight2	EmojiPicker.EmojiWeight
    // Exception table:
    //   from	to	target	type
    //   81	110	321	finally
    //   110	183	321	finally
    //   183	192	321	finally
    //   197	205	321	finally
    //   205	270	321	finally
    //   270	290	321	finally
    //   297	318	321	finally
    //   322	325	321	finally
    //   395	401	321	finally
    //   880	917	321	finally
    //   924	930	321	finally
    //   933	950	321	finally
    //   953	970	321	finally
    //   973	990	321	finally
    //   993	1010	321	finally
    //   1013	1030	321	finally
    //   1033	1050	321	finally
    //   1053	1070	321	finally
    //   1073	1090	321	finally
    //   1093	1110	321	finally
    //   1113	1130	321	finally
    //   1133	1150	321	finally
    //   1153	1176	321	finally
    //   1179	1201	321	finally
    //   1204	1219	321	finally
    //   50	81	327	java/lang/Exception
    //   325	327	327	java/lang/Exception
    //   1219	1224	1227	java/io/IOException
    //   32	50	1231	finally
    //   369	373	1247	java/io/IOException
    //   1240	1245	1251	java/io/IOException
    //   50	81	1256	finally
    //   325	327	1256	finally
    //   336	365	1260	finally
    //   32	50	1271	java/lang/Exception
  }
  
  public final List<int[]> c()
  {
    b();
    ArrayList localArrayList = new ArrayList();
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      if (localIterator.hasNext()) {
        localArrayList.add(((EmojiPicker.EmojiWeight)localIterator.next()).emoji);
      }
    }
    return localList1;
  }
  
  public final int d()
  {
    b();
    return Math.min(35, this.a.size());
  }
  
  public final Map<int[], Float> e()
  {
    b();
    synchronized (this.a)
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = this.a.iterator();
      if (localIterator.hasNext())
      {
        EmojiPicker.EmojiWeight localEmojiWeight = (EmojiPicker.EmojiWeight)localIterator.next();
        localHashMap.put(localEmojiWeight.emoji, Float.valueOf(localEmojiWeight.weight));
      }
    }
    return localMap;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/emoji/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */