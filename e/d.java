package com.whatsapp.e;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.TrafficStats;
import com.whatsapp.aat;
import com.whatsapp.k.h;
import com.whatsapp.util.Log;

public final class d
{
  private static final h a = new h(5, 500);
  private final com.whatsapp.util.a.c b;
  private final c c;
  private final aat d;
  
  public d(com.whatsapp.util.a.c paramc, aat paramaat)
  {
    this.b = paramc;
    this.d = paramaat;
    this.c = new c();
  }
  
  private static a a(int paramInt)
  {
    return new a(TrafficStats.getUidRxBytes(paramInt), TrafficStats.getUidTxBytes(paramInt));
  }
  
  private void a()
  {
    String[] arrayOfString1 = b.b;
    int k = arrayOfString1.length;
    int i = 0;
    while (i < k)
    {
      String str1 = arrayOfString1[i];
      String[] arrayOfString2 = b.a;
      int m = arrayOfString2.length;
      int j = 0;
      while (j < m)
      {
        String str2 = arrayOfString2[j];
        this.c.a.edit().putLong(c.a("data_usage_received_accumulated", str2, str1), 0L).putLong(c.a("data_usage_sent_accumulated", str2, str1), 0L).commit();
        j += 1;
      }
      i += 1;
    }
  }
  
  private void a(SharedPreferences.Editor paramEditor, a parama, String paramString)
  {
    a locala2 = this.c.a(paramString);
    a locala1 = locala2;
    if (locala2 == null)
    {
      this.c.a(parama, paramString);
      locala1 = parama;
    }
    locala2 = parama.a(locala1);
    int i;
    if ((locala2.b < 0L) || (locala2.a < 0L))
    {
      i = 1;
      if (i == 0) {
        break label183;
      }
      Log.d("datausagesync/total/reset: type=" + paramString + ", prev_record= " + locala1 + ",  accum= " + this.c.a(paramString, "all") + ",  new_record= " + parama);
      locala1 = new a(0L, 0L);
      if (b()) {
        this.c.a(paramEditor, locala1, paramString, "mobile");
      }
      this.c.a(paramEditor, locala1, paramString, "all");
    }
    for (;;)
    {
      this.c.a(parama, paramString);
      return;
      i = 0;
      break;
      label183:
      locala1 = parama.a(locala1);
      if (b()) {
        this.c.a(paramEditor, locala1, paramString, "mobile");
      }
      this.c.a(paramEditor, locala1, paramString, "all");
    }
  }
  
  private boolean b()
  {
    boolean bool = false;
    if (this.d.a(false) == 2) {
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  public final void a(com.whatsapp.Statistics.Data paramData)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   6: getfield 60	com/whatsapp/e/c:a	Landroid/content/SharedPreferences;
    //   9: ldc -110
    //   11: aconst_null
    //   12: invokeinterface 150 3 0
    //   17: astore 5
    //   19: aload 5
    //   21: ifnull +1728 -> 1749
    //   24: aload 5
    //   26: new 152	java/util/Date
    //   29: dup
    //   30: invokespecial 153	java/util/Date:<init>	()V
    //   33: invokestatic 158	a/a/a/a/d:a	(Ljava/util/Date;)Ljava/lang/String;
    //   36: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   39: ifne +1710 -> 1749
    //   42: aload_0
    //   43: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   46: invokevirtual 165	com/whatsapp/e/c:b	()Z
    //   49: ifeq +1092 -> 1141
    //   52: new 167	com/whatsapp/fieldstats/events/b
    //   55: dup
    //   56: invokespecial 168	com/whatsapp/fieldstats/events/b:<init>	()V
    //   59: astore 5
    //   61: aload_0
    //   62: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   65: ldc -86
    //   67: ldc 118
    //   69: invokevirtual 121	com/whatsapp/e/c:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   72: astore 6
    //   74: aload_0
    //   75: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   78: ldc -86
    //   80: ldc -121
    //   82: invokevirtual 121	com/whatsapp/e/c:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   85: astore 7
    //   87: aload_0
    //   88: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   91: ldc -84
    //   93: ldc 118
    //   95: invokevirtual 121	com/whatsapp/e/c:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   98: astore 8
    //   100: aload_0
    //   101: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   104: ldc -84
    //   106: ldc -121
    //   108: invokevirtual 121	com/whatsapp/e/c:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   111: astore 9
    //   113: aload_0
    //   114: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   117: ldc -82
    //   119: ldc 118
    //   121: invokevirtual 121	com/whatsapp/e/c:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   124: astore 10
    //   126: aload_0
    //   127: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   130: ldc -82
    //   132: ldc -121
    //   134: invokevirtual 121	com/whatsapp/e/c:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   137: astore 11
    //   139: aload_0
    //   140: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   143: ldc -80
    //   145: ldc 118
    //   147: invokevirtual 121	com/whatsapp/e/c:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   150: astore 12
    //   152: aload_0
    //   153: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   156: ldc -80
    //   158: ldc -121
    //   160: invokevirtual 121	com/whatsapp/e/c:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   163: astore 13
    //   165: aload_0
    //   166: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   169: ldc -78
    //   171: ldc 118
    //   173: invokevirtual 121	com/whatsapp/e/c:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   176: astore 14
    //   178: aload_0
    //   179: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   182: ldc -78
    //   184: ldc -121
    //   186: invokevirtual 121	com/whatsapp/e/c:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   189: astore 15
    //   191: aload_0
    //   192: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   195: ldc -76
    //   197: ldc 118
    //   199: invokevirtual 121	com/whatsapp/e/c:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   202: astore 16
    //   204: aload_0
    //   205: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   208: ldc -76
    //   210: ldc -121
    //   212: invokevirtual 121	com/whatsapp/e/c:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   215: astore 17
    //   217: aload_0
    //   218: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   221: ldc -74
    //   223: ldc 118
    //   225: invokevirtual 121	com/whatsapp/e/c:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   228: astore 18
    //   230: aload_0
    //   231: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   234: ldc -74
    //   236: ldc -121
    //   238: invokevirtual 121	com/whatsapp/e/c:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   241: astore 19
    //   243: aload_0
    //   244: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   247: ldc -72
    //   249: ldc 118
    //   251: invokevirtual 121	com/whatsapp/e/c:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   254: astore 20
    //   256: aload_0
    //   257: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   260: ldc -72
    //   262: ldc -121
    //   264: invokevirtual 121	com/whatsapp/e/c:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   267: astore 21
    //   269: aload_0
    //   270: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   273: ldc -70
    //   275: ldc 118
    //   277: invokevirtual 121	com/whatsapp/e/c:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   280: astore 22
    //   282: aload_0
    //   283: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   286: ldc -70
    //   288: ldc -121
    //   290: invokevirtual 121	com/whatsapp/e/c:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   293: astore 23
    //   295: aload 5
    //   297: aload 6
    //   299: getfield 98	com/whatsapp/e/a:a	J
    //   302: l2d
    //   303: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   306: putfield 195	com/whatsapp/fieldstats/events/b:a	Ljava/lang/Double;
    //   309: aload 5
    //   311: aload 6
    //   313: getfield 96	com/whatsapp/e/a:b	J
    //   316: l2d
    //   317: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   320: putfield 198	com/whatsapp/fieldstats/events/b:m	Ljava/lang/Double;
    //   323: aload 5
    //   325: aload 7
    //   327: getfield 98	com/whatsapp/e/a:a	J
    //   330: l2d
    //   331: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   334: putfield 200	com/whatsapp/fieldstats/events/b:b	Ljava/lang/Double;
    //   337: aload 5
    //   339: aload 7
    //   341: getfield 96	com/whatsapp/e/a:b	J
    //   344: l2d
    //   345: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   348: putfield 203	com/whatsapp/fieldstats/events/b:n	Ljava/lang/Double;
    //   351: aload 5
    //   353: aload 8
    //   355: getfield 98	com/whatsapp/e/a:a	J
    //   358: l2d
    //   359: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   362: putfield 205	com/whatsapp/fieldstats/events/b:c	Ljava/lang/Double;
    //   365: aload 5
    //   367: aload 8
    //   369: getfield 96	com/whatsapp/e/a:b	J
    //   372: l2d
    //   373: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   376: putfield 208	com/whatsapp/fieldstats/events/b:o	Ljava/lang/Double;
    //   379: aload 5
    //   381: aload 9
    //   383: getfield 98	com/whatsapp/e/a:a	J
    //   386: l2d
    //   387: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   390: putfield 210	com/whatsapp/fieldstats/events/b:d	Ljava/lang/Double;
    //   393: aload 5
    //   395: aload 9
    //   397: getfield 96	com/whatsapp/e/a:b	J
    //   400: l2d
    //   401: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   404: putfield 213	com/whatsapp/fieldstats/events/b:p	Ljava/lang/Double;
    //   407: aload 5
    //   409: aload 10
    //   411: getfield 98	com/whatsapp/e/a:a	J
    //   414: l2d
    //   415: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   418: putfield 216	com/whatsapp/fieldstats/events/b:g	Ljava/lang/Double;
    //   421: aload 5
    //   423: aload 10
    //   425: getfield 96	com/whatsapp/e/a:b	J
    //   428: l2d
    //   429: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   432: putfield 219	com/whatsapp/fieldstats/events/b:s	Ljava/lang/Double;
    //   435: aload 5
    //   437: aload 11
    //   439: getfield 98	com/whatsapp/e/a:a	J
    //   442: l2d
    //   443: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   446: putfield 222	com/whatsapp/fieldstats/events/b:h	Ljava/lang/Double;
    //   449: aload 5
    //   451: aload 11
    //   453: getfield 96	com/whatsapp/e/a:b	J
    //   456: l2d
    //   457: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   460: putfield 225	com/whatsapp/fieldstats/events/b:t	Ljava/lang/Double;
    //   463: aload 5
    //   465: aload 12
    //   467: getfield 98	com/whatsapp/e/a:a	J
    //   470: l2d
    //   471: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   474: putfield 228	com/whatsapp/fieldstats/events/b:i	Ljava/lang/Double;
    //   477: aload 5
    //   479: aload 12
    //   481: getfield 96	com/whatsapp/e/a:b	J
    //   484: l2d
    //   485: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   488: putfield 231	com/whatsapp/fieldstats/events/b:u	Ljava/lang/Double;
    //   491: aload 5
    //   493: aload 13
    //   495: getfield 98	com/whatsapp/e/a:a	J
    //   498: l2d
    //   499: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   502: putfield 234	com/whatsapp/fieldstats/events/b:j	Ljava/lang/Double;
    //   505: aload 5
    //   507: aload 13
    //   509: getfield 96	com/whatsapp/e/a:b	J
    //   512: l2d
    //   513: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   516: putfield 237	com/whatsapp/fieldstats/events/b:v	Ljava/lang/Double;
    //   519: aload 5
    //   521: aload 14
    //   523: getfield 98	com/whatsapp/e/a:a	J
    //   526: l2d
    //   527: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   530: putfield 240	com/whatsapp/fieldstats/events/b:k	Ljava/lang/Double;
    //   533: aload 5
    //   535: aload 14
    //   537: getfield 96	com/whatsapp/e/a:b	J
    //   540: l2d
    //   541: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   544: putfield 243	com/whatsapp/fieldstats/events/b:w	Ljava/lang/Double;
    //   547: aload 5
    //   549: aload 15
    //   551: getfield 98	com/whatsapp/e/a:a	J
    //   554: l2d
    //   555: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   558: putfield 246	com/whatsapp/fieldstats/events/b:l	Ljava/lang/Double;
    //   561: aload 5
    //   563: aload 15
    //   565: getfield 96	com/whatsapp/e/a:b	J
    //   568: l2d
    //   569: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   572: putfield 249	com/whatsapp/fieldstats/events/b:x	Ljava/lang/Double;
    //   575: aload 5
    //   577: aload 16
    //   579: getfield 98	com/whatsapp/e/a:a	J
    //   582: l2d
    //   583: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   586: putfield 252	com/whatsapp/fieldstats/events/b:e	Ljava/lang/Double;
    //   589: aload 5
    //   591: aload 16
    //   593: getfield 96	com/whatsapp/e/a:b	J
    //   596: l2d
    //   597: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   600: putfield 255	com/whatsapp/fieldstats/events/b:q	Ljava/lang/Double;
    //   603: aload 5
    //   605: aload 17
    //   607: getfield 98	com/whatsapp/e/a:a	J
    //   610: l2d
    //   611: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   614: putfield 258	com/whatsapp/fieldstats/events/b:f	Ljava/lang/Double;
    //   617: aload 5
    //   619: aload 17
    //   621: getfield 96	com/whatsapp/e/a:b	J
    //   624: l2d
    //   625: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   628: putfield 261	com/whatsapp/fieldstats/events/b:r	Ljava/lang/Double;
    //   631: aload 5
    //   633: aload 18
    //   635: getfield 98	com/whatsapp/e/a:a	J
    //   638: l2d
    //   639: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   642: putfield 264	com/whatsapp/fieldstats/events/b:E	Ljava/lang/Double;
    //   645: aload 5
    //   647: aload 18
    //   649: getfield 96	com/whatsapp/e/a:b	J
    //   652: l2d
    //   653: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   656: putfield 267	com/whatsapp/fieldstats/events/b:y	Ljava/lang/Double;
    //   659: aload 5
    //   661: aload 19
    //   663: getfield 98	com/whatsapp/e/a:a	J
    //   666: l2d
    //   667: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   670: putfield 270	com/whatsapp/fieldstats/events/b:F	Ljava/lang/Double;
    //   673: aload 5
    //   675: aload 19
    //   677: getfield 96	com/whatsapp/e/a:b	J
    //   680: l2d
    //   681: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   684: putfield 273	com/whatsapp/fieldstats/events/b:z	Ljava/lang/Double;
    //   687: aload 5
    //   689: aload 20
    //   691: getfield 98	com/whatsapp/e/a:a	J
    //   694: l2d
    //   695: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   698: putfield 276	com/whatsapp/fieldstats/events/b:G	Ljava/lang/Double;
    //   701: aload 5
    //   703: aload 20
    //   705: getfield 96	com/whatsapp/e/a:b	J
    //   708: l2d
    //   709: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   712: putfield 279	com/whatsapp/fieldstats/events/b:A	Ljava/lang/Double;
    //   715: aload 5
    //   717: aload 21
    //   719: getfield 98	com/whatsapp/e/a:a	J
    //   722: l2d
    //   723: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   726: putfield 282	com/whatsapp/fieldstats/events/b:H	Ljava/lang/Double;
    //   729: aload 5
    //   731: aload 21
    //   733: getfield 96	com/whatsapp/e/a:b	J
    //   736: l2d
    //   737: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   740: putfield 285	com/whatsapp/fieldstats/events/b:B	Ljava/lang/Double;
    //   743: aload 5
    //   745: aload 22
    //   747: getfield 98	com/whatsapp/e/a:a	J
    //   750: l2d
    //   751: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   754: putfield 288	com/whatsapp/fieldstats/events/b:I	Ljava/lang/Double;
    //   757: aload 5
    //   759: aload 22
    //   761: getfield 96	com/whatsapp/e/a:b	J
    //   764: l2d
    //   765: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   768: putfield 291	com/whatsapp/fieldstats/events/b:C	Ljava/lang/Double;
    //   771: aload 5
    //   773: aload 23
    //   775: getfield 98	com/whatsapp/e/a:a	J
    //   778: l2d
    //   779: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   782: putfield 293	com/whatsapp/fieldstats/events/b:J	Ljava/lang/Double;
    //   785: aload 5
    //   787: aload 23
    //   789: getfield 96	com/whatsapp/e/a:b	J
    //   792: l2d
    //   793: invokestatic 192	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   796: putfield 296	com/whatsapp/fieldstats/events/b:D	Ljava/lang/Double;
    //   799: invokestatic 301	com/whatsapp/u:a	()Landroid/content/Context;
    //   802: aload 5
    //   804: getstatic 22	com/whatsapp/e/d:a	Lcom/whatsapp/k/h;
    //   807: iconst_1
    //   808: invokevirtual 304	com/whatsapp/k/h:b	(I)I
    //   811: invokestatic 309	com/whatsapp/fieldstats/l:a	(Landroid/content/Context;Lcom/whatsapp/fieldstats/e;I)V
    //   814: new 100	java/lang/StringBuilder
    //   817: dup
    //   818: ldc_w 311
    //   821: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   824: aload 6
    //   826: getfield 98	com/whatsapp/e/a:a	J
    //   829: invokevirtual 314	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   832: ldc_w 316
    //   835: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: aload 6
    //   840: getfield 96	com/whatsapp/e/a:b	J
    //   843: invokevirtual 314	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   846: ldc_w 318
    //   849: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: aload 8
    //   854: getfield 98	com/whatsapp/e/a:a	J
    //   857: invokevirtual 314	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   860: ldc_w 320
    //   863: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: aload 8
    //   868: getfield 96	com/whatsapp/e/a:b	J
    //   871: invokevirtual 314	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   874: ldc_w 322
    //   877: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: aload 10
    //   882: getfield 98	com/whatsapp/e/a:a	J
    //   885: invokevirtual 314	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   888: ldc_w 324
    //   891: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: aload 10
    //   896: getfield 96	com/whatsapp/e/a:b	J
    //   899: invokevirtual 314	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   902: ldc_w 326
    //   905: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   908: aload 12
    //   910: getfield 98	com/whatsapp/e/a:a	J
    //   913: invokevirtual 314	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   916: ldc_w 328
    //   919: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: aload 12
    //   924: getfield 96	com/whatsapp/e/a:b	J
    //   927: invokevirtual 314	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   930: ldc_w 330
    //   933: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: aload 14
    //   938: getfield 98	com/whatsapp/e/a:a	J
    //   941: invokevirtual 314	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   944: ldc_w 332
    //   947: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: aload 14
    //   952: getfield 96	com/whatsapp/e/a:b	J
    //   955: invokevirtual 314	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   958: ldc_w 334
    //   961: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: aload 16
    //   966: getfield 98	com/whatsapp/e/a:a	J
    //   969: invokevirtual 314	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   972: ldc_w 336
    //   975: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: aload 16
    //   980: getfield 96	com/whatsapp/e/a:b	J
    //   983: invokevirtual 314	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   986: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   989: invokestatic 338	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   992: aload 8
    //   994: getfield 98	com/whatsapp/e/a:a	J
    //   997: lstore_2
    //   998: aload 8
    //   1000: getfield 96	com/whatsapp/e/a:b	J
    //   1003: lload_2
    //   1004: ladd
    //   1005: ldc2_w 339
    //   1008: lcmp
    //   1009: ifle +16 -> 1025
    //   1012: aload_0
    //   1013: getfield 28	com/whatsapp/e/d:b	Lcom/whatsapp/util/a/c;
    //   1016: ldc_w 342
    //   1019: iconst_0
    //   1020: aconst_null
    //   1021: iconst_m1
    //   1022: invokevirtual 347	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   1025: aload 12
    //   1027: getfield 98	com/whatsapp/e/a:a	J
    //   1030: aload 12
    //   1032: getfield 96	com/whatsapp/e/a:b	J
    //   1035: ladd
    //   1036: ldc2_w 339
    //   1039: lcmp
    //   1040: ifle +16 -> 1056
    //   1043: aload_0
    //   1044: getfield 28	com/whatsapp/e/d:b	Lcom/whatsapp/util/a/c;
    //   1047: ldc_w 349
    //   1050: iconst_0
    //   1051: aconst_null
    //   1052: iconst_m1
    //   1053: invokevirtual 347	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   1056: aload 6
    //   1058: getfield 98	com/whatsapp/e/a:a	J
    //   1061: lstore_2
    //   1062: aload 6
    //   1064: getfield 96	com/whatsapp/e/a:b	J
    //   1067: lload_2
    //   1068: ladd
    //   1069: ldc2_w 350
    //   1072: lcmp
    //   1073: ifle +16 -> 1089
    //   1076: aload_0
    //   1077: getfield 28	com/whatsapp/e/d:b	Lcom/whatsapp/util/a/c;
    //   1080: ldc_w 353
    //   1083: iconst_0
    //   1084: aconst_null
    //   1085: iconst_m1
    //   1086: invokevirtual 347	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   1089: aload_0
    //   1090: invokespecial 355	com/whatsapp/e/d:a	()V
    //   1093: new 100	java/lang/StringBuilder
    //   1096: dup
    //   1097: ldc_w 357
    //   1100: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1103: aload_0
    //   1104: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   1107: ldc -86
    //   1109: invokevirtual 87	com/whatsapp/e/c:a	(Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   1112: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1115: ldc_w 359
    //   1118: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: aload_0
    //   1122: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   1125: ldc -86
    //   1127: ldc 118
    //   1129: invokevirtual 121	com/whatsapp/e/c:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   1132: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1135: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1138: invokestatic 131	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   1141: aload_0
    //   1142: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   1145: invokevirtual 360	com/whatsapp/e/c:a	()V
    //   1148: aload_0
    //   1149: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   1152: astore 5
    //   1154: getstatic 22	com/whatsapp/e/d:a	Lcom/whatsapp/k/h;
    //   1157: iconst_1
    //   1158: invokevirtual 363	com/whatsapp/k/h:a	(I)Z
    //   1161: istore 4
    //   1163: aload 5
    //   1165: getfield 60	com/whatsapp/e/c:a	Landroid/content/SharedPreferences;
    //   1168: invokeinterface 66 1 0
    //   1173: ldc_w 365
    //   1176: iload 4
    //   1178: invokeinterface 369 3 0
    //   1183: invokeinterface 83 1 0
    //   1188: pop
    //   1189: aload_0
    //   1190: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   1193: invokevirtual 165	com/whatsapp/e/c:b	()Z
    //   1196: ifeq +278 -> 1474
    //   1199: aload_0
    //   1200: invokespecial 355	com/whatsapp/e/d:a	()V
    //   1203: invokestatic 375	android/os/Process:myUid	()I
    //   1206: invokestatic 377	com/whatsapp/e/d:a	(I)Lcom/whatsapp/e/a;
    //   1209: astore 5
    //   1211: new 38	com/whatsapp/e/a
    //   1214: dup
    //   1215: aload_1
    //   1216: invokevirtual 383	com/whatsapp/Statistics$Data:getMediaBytesReceived	()J
    //   1219: aload_1
    //   1220: invokevirtual 386	com/whatsapp/Statistics$Data:getMediaBytesSent	()J
    //   1223: invokespecial 50	com/whatsapp/e/a:<init>	(JJ)V
    //   1226: astore 6
    //   1228: new 38	com/whatsapp/e/a
    //   1231: dup
    //   1232: aload_1
    //   1233: invokevirtual 389	com/whatsapp/Statistics$Data:getMessageBytesReceived	()J
    //   1236: aload_1
    //   1237: invokevirtual 392	com/whatsapp/Statistics$Data:getMessageBytesSent	()J
    //   1240: invokespecial 50	com/whatsapp/e/a:<init>	(JJ)V
    //   1243: astore 7
    //   1245: new 38	com/whatsapp/e/a
    //   1248: dup
    //   1249: aload_1
    //   1250: invokevirtual 395	com/whatsapp/Statistics$Data:getVoipBytesReceived	()J
    //   1253: aload_1
    //   1254: invokevirtual 398	com/whatsapp/Statistics$Data:getVoipBytesSent	()J
    //   1257: invokespecial 50	com/whatsapp/e/a:<init>	(JJ)V
    //   1260: astore 8
    //   1262: new 38	com/whatsapp/e/a
    //   1265: dup
    //   1266: aload_1
    //   1267: invokevirtual 401	com/whatsapp/Statistics$Data:getTotalBytesReceivedFromGoogleDrive	()J
    //   1270: aload_1
    //   1271: invokevirtual 404	com/whatsapp/Statistics$Data:getTotalBytesSentToGoogleDrive	()J
    //   1274: invokespecial 50	com/whatsapp/e/a:<init>	(JJ)V
    //   1277: astore 9
    //   1279: new 38	com/whatsapp/e/a
    //   1282: dup
    //   1283: aload_1
    //   1284: invokevirtual 407	com/whatsapp/Statistics$Data:getStatusBytesReceived	()J
    //   1287: aload_1
    //   1288: invokevirtual 410	com/whatsapp/Statistics$Data:getStatusBytesSent	()J
    //   1291: invokespecial 50	com/whatsapp/e/a:<init>	(JJ)V
    //   1294: astore 10
    //   1296: new 38	com/whatsapp/e/a
    //   1299: dup
    //   1300: aload_1
    //   1301: invokevirtual 413	com/whatsapp/Statistics$Data:getTotalTextMessagesReceived	()J
    //   1304: aload_1
    //   1305: invokevirtual 416	com/whatsapp/Statistics$Data:getTotalTextMessagesSent	()J
    //   1308: invokespecial 50	com/whatsapp/e/a:<init>	(JJ)V
    //   1311: astore 11
    //   1313: new 38	com/whatsapp/e/a
    //   1316: dup
    //   1317: aload_1
    //   1318: invokevirtual 419	com/whatsapp/Statistics$Data:getTotalMediaMessagesReceived	()J
    //   1321: aload_1
    //   1322: invokevirtual 422	com/whatsapp/Statistics$Data:getTotalMediaMessagesSent	()J
    //   1325: invokespecial 50	com/whatsapp/e/a:<init>	(JJ)V
    //   1328: astore 12
    //   1330: new 38	com/whatsapp/e/a
    //   1333: dup
    //   1334: aload_1
    //   1335: invokevirtual 425	com/whatsapp/Statistics$Data:getTotalStatusesReceived	()J
    //   1338: aload_1
    //   1339: invokevirtual 428	com/whatsapp/Statistics$Data:getTotalStatusesSent	()J
    //   1342: invokespecial 50	com/whatsapp/e/a:<init>	(JJ)V
    //   1345: astore 13
    //   1347: aload_0
    //   1348: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   1351: aload 5
    //   1353: ldc -86
    //   1355: invokevirtual 90	com/whatsapp/e/c:a	(Lcom/whatsapp/e/a;Ljava/lang/String;)V
    //   1358: aload_0
    //   1359: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   1362: aload 6
    //   1364: ldc -84
    //   1366: invokevirtual 90	com/whatsapp/e/c:a	(Lcom/whatsapp/e/a;Ljava/lang/String;)V
    //   1369: aload_0
    //   1370: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   1373: aload 7
    //   1375: ldc -82
    //   1377: invokevirtual 90	com/whatsapp/e/c:a	(Lcom/whatsapp/e/a;Ljava/lang/String;)V
    //   1380: aload_0
    //   1381: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   1384: aload 8
    //   1386: ldc -80
    //   1388: invokevirtual 90	com/whatsapp/e/c:a	(Lcom/whatsapp/e/a;Ljava/lang/String;)V
    //   1391: aload_0
    //   1392: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   1395: aload 9
    //   1397: ldc -78
    //   1399: invokevirtual 90	com/whatsapp/e/c:a	(Lcom/whatsapp/e/a;Ljava/lang/String;)V
    //   1402: aload_0
    //   1403: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   1406: aload 10
    //   1408: ldc -76
    //   1410: invokevirtual 90	com/whatsapp/e/c:a	(Lcom/whatsapp/e/a;Ljava/lang/String;)V
    //   1413: aload_0
    //   1414: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   1417: aload 11
    //   1419: ldc -74
    //   1421: invokevirtual 90	com/whatsapp/e/c:a	(Lcom/whatsapp/e/a;Ljava/lang/String;)V
    //   1424: aload_0
    //   1425: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   1428: aload 12
    //   1430: ldc -72
    //   1432: invokevirtual 90	com/whatsapp/e/c:a	(Lcom/whatsapp/e/a;Ljava/lang/String;)V
    //   1435: aload_0
    //   1436: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   1439: aload 13
    //   1441: ldc -70
    //   1443: invokevirtual 90	com/whatsapp/e/c:a	(Lcom/whatsapp/e/a;Ljava/lang/String;)V
    //   1446: new 100	java/lang/StringBuilder
    //   1449: dup
    //   1450: ldc_w 430
    //   1453: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1456: aload_0
    //   1457: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   1460: ldc -86
    //   1462: invokevirtual 87	com/whatsapp/e/c:a	(Ljava/lang/String;)Lcom/whatsapp/e/a;
    //   1465: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1468: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1471: invokestatic 131	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   1474: aload_0
    //   1475: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   1478: invokevirtual 165	com/whatsapp/e/c:b	()Z
    //   1481: ifeq +265 -> 1746
    //   1484: invokestatic 375	android/os/Process:myUid	()I
    //   1487: invokestatic 377	com/whatsapp/e/d:a	(I)Lcom/whatsapp/e/a;
    //   1490: astore 5
    //   1492: new 38	com/whatsapp/e/a
    //   1495: dup
    //   1496: aload_1
    //   1497: invokevirtual 383	com/whatsapp/Statistics$Data:getMediaBytesReceived	()J
    //   1500: aload_1
    //   1501: invokevirtual 386	com/whatsapp/Statistics$Data:getMediaBytesSent	()J
    //   1504: invokespecial 50	com/whatsapp/e/a:<init>	(JJ)V
    //   1507: astore 6
    //   1509: new 38	com/whatsapp/e/a
    //   1512: dup
    //   1513: aload_1
    //   1514: invokevirtual 389	com/whatsapp/Statistics$Data:getMessageBytesReceived	()J
    //   1517: aload_1
    //   1518: invokevirtual 392	com/whatsapp/Statistics$Data:getMessageBytesSent	()J
    //   1521: invokespecial 50	com/whatsapp/e/a:<init>	(JJ)V
    //   1524: astore 7
    //   1526: new 38	com/whatsapp/e/a
    //   1529: dup
    //   1530: aload_1
    //   1531: invokevirtual 395	com/whatsapp/Statistics$Data:getVoipBytesReceived	()J
    //   1534: aload_1
    //   1535: invokevirtual 398	com/whatsapp/Statistics$Data:getVoipBytesSent	()J
    //   1538: invokespecial 50	com/whatsapp/e/a:<init>	(JJ)V
    //   1541: astore 8
    //   1543: new 38	com/whatsapp/e/a
    //   1546: dup
    //   1547: aload_1
    //   1548: invokevirtual 401	com/whatsapp/Statistics$Data:getTotalBytesReceivedFromGoogleDrive	()J
    //   1551: aload_1
    //   1552: invokevirtual 404	com/whatsapp/Statistics$Data:getTotalBytesSentToGoogleDrive	()J
    //   1555: invokespecial 50	com/whatsapp/e/a:<init>	(JJ)V
    //   1558: astore 9
    //   1560: new 38	com/whatsapp/e/a
    //   1563: dup
    //   1564: aload_1
    //   1565: invokevirtual 407	com/whatsapp/Statistics$Data:getStatusBytesReceived	()J
    //   1568: aload_1
    //   1569: invokevirtual 410	com/whatsapp/Statistics$Data:getStatusBytesSent	()J
    //   1572: invokespecial 50	com/whatsapp/e/a:<init>	(JJ)V
    //   1575: astore 10
    //   1577: new 38	com/whatsapp/e/a
    //   1580: dup
    //   1581: aload_1
    //   1582: invokevirtual 413	com/whatsapp/Statistics$Data:getTotalTextMessagesReceived	()J
    //   1585: aload_1
    //   1586: invokevirtual 416	com/whatsapp/Statistics$Data:getTotalTextMessagesSent	()J
    //   1589: invokespecial 50	com/whatsapp/e/a:<init>	(JJ)V
    //   1592: astore 11
    //   1594: new 38	com/whatsapp/e/a
    //   1597: dup
    //   1598: aload_1
    //   1599: invokevirtual 419	com/whatsapp/Statistics$Data:getTotalMediaMessagesReceived	()J
    //   1602: aload_1
    //   1603: invokevirtual 422	com/whatsapp/Statistics$Data:getTotalMediaMessagesSent	()J
    //   1606: invokespecial 50	com/whatsapp/e/a:<init>	(JJ)V
    //   1609: astore 12
    //   1611: new 38	com/whatsapp/e/a
    //   1614: dup
    //   1615: aload_1
    //   1616: invokevirtual 425	com/whatsapp/Statistics$Data:getTotalStatusesReceived	()J
    //   1619: aload_1
    //   1620: invokevirtual 428	com/whatsapp/Statistics$Data:getTotalStatusesSent	()J
    //   1623: invokespecial 50	com/whatsapp/e/a:<init>	(JJ)V
    //   1626: astore_1
    //   1627: aload_0
    //   1628: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   1631: getfield 60	com/whatsapp/e/c:a	Landroid/content/SharedPreferences;
    //   1634: invokeinterface 66 1 0
    //   1639: astore 13
    //   1641: aload_0
    //   1642: aload 13
    //   1644: aload 5
    //   1646: ldc -86
    //   1648: invokespecial 432	com/whatsapp/e/d:a	(Landroid/content/SharedPreferences$Editor;Lcom/whatsapp/e/a;Ljava/lang/String;)V
    //   1651: aload_0
    //   1652: aload 13
    //   1654: aload 6
    //   1656: ldc -84
    //   1658: invokespecial 432	com/whatsapp/e/d:a	(Landroid/content/SharedPreferences$Editor;Lcom/whatsapp/e/a;Ljava/lang/String;)V
    //   1661: aload_0
    //   1662: aload 13
    //   1664: aload 7
    //   1666: ldc -82
    //   1668: invokespecial 432	com/whatsapp/e/d:a	(Landroid/content/SharedPreferences$Editor;Lcom/whatsapp/e/a;Ljava/lang/String;)V
    //   1671: aload_0
    //   1672: aload 13
    //   1674: aload 8
    //   1676: ldc -80
    //   1678: invokespecial 432	com/whatsapp/e/d:a	(Landroid/content/SharedPreferences$Editor;Lcom/whatsapp/e/a;Ljava/lang/String;)V
    //   1681: aload_0
    //   1682: aload 13
    //   1684: aload 9
    //   1686: ldc -78
    //   1688: invokespecial 432	com/whatsapp/e/d:a	(Landroid/content/SharedPreferences$Editor;Lcom/whatsapp/e/a;Ljava/lang/String;)V
    //   1691: aload_0
    //   1692: aload 13
    //   1694: aload 10
    //   1696: ldc -76
    //   1698: invokespecial 432	com/whatsapp/e/d:a	(Landroid/content/SharedPreferences$Editor;Lcom/whatsapp/e/a;Ljava/lang/String;)V
    //   1701: aload_0
    //   1702: aload 13
    //   1704: aload 11
    //   1706: ldc -74
    //   1708: invokespecial 432	com/whatsapp/e/d:a	(Landroid/content/SharedPreferences$Editor;Lcom/whatsapp/e/a;Ljava/lang/String;)V
    //   1711: aload_0
    //   1712: aload 13
    //   1714: aload 12
    //   1716: ldc -72
    //   1718: invokespecial 432	com/whatsapp/e/d:a	(Landroid/content/SharedPreferences$Editor;Lcom/whatsapp/e/a;Ljava/lang/String;)V
    //   1721: aload_0
    //   1722: aload 13
    //   1724: aload_1
    //   1725: ldc -70
    //   1727: invokespecial 432	com/whatsapp/e/d:a	(Landroid/content/SharedPreferences$Editor;Lcom/whatsapp/e/a;Ljava/lang/String;)V
    //   1730: aload 13
    //   1732: invokeinterface 83 1 0
    //   1737: ifne +9 -> 1746
    //   1740: ldc_w 434
    //   1743: invokestatic 436	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1746: aload_0
    //   1747: monitorexit
    //   1748: return
    //   1749: aload 5
    //   1751: ifnonnull -277 -> 1474
    //   1754: aload_0
    //   1755: getfield 35	com/whatsapp/e/d:c	Lcom/whatsapp/e/c;
    //   1758: invokevirtual 360	com/whatsapp/e/c:a	()V
    //   1761: goto -287 -> 1474
    //   1764: astore_1
    //   1765: aload_0
    //   1766: monitorexit
    //   1767: aload_1
    //   1768: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1769	0	this	d
    //   0	1769	1	paramData	com.whatsapp.Statistics.Data
    //   997	71	2	l	long
    //   1161	16	4	bool	boolean
    //   17	1733	5	localObject1	Object
    //   72	1583	6	locala1	a
    //   85	1580	7	locala2	a
    //   98	1577	8	locala3	a
    //   111	1574	9	locala4	a
    //   124	1571	10	locala5	a
    //   137	1568	11	locala6	a
    //   150	1565	12	locala7	a
    //   163	1568	13	localObject2	Object
    //   176	775	14	locala8	a
    //   189	375	15	locala9	a
    //   202	777	16	locala10	a
    //   215	405	17	locala11	a
    //   228	420	18	locala12	a
    //   241	435	19	locala13	a
    //   254	450	20	locala14	a
    //   267	465	21	locala15	a
    //   280	480	22	locala16	a
    //   293	495	23	locala17	a
    // Exception table:
    //   from	to	target	type
    //   2	19	1764	finally
    //   24	1025	1764	finally
    //   1025	1056	1764	finally
    //   1056	1089	1764	finally
    //   1089	1141	1764	finally
    //   1141	1474	1764	finally
    //   1474	1746	1764	finally
    //   1754	1761	1764	finally
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */