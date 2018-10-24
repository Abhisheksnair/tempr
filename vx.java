package com.whatsapp;

import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.whatsapp.data.ad;
import com.whatsapp.fieldstats.events.r;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.a.c;
import com.whatsapp.util.ag;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class vx
{
  private static volatile vx j;
  final pv a;
  final oz b;
  final vp c;
  final ad d;
  final and e;
  final vv f;
  final ag g;
  final ArrayList<aoi> h = new ArrayList();
  aoi i;
  private final c k;
  private final atv l;
  private a m;
  private PowerManager.WakeLock n;
  
  private vx(pv parampv, c paramc, oz paramoz, vp paramvp, ad paramad, and paramand, vv paramvv, ag paramag, atv paramatv)
  {
    this.a = parampv;
    this.k = paramc;
    this.b = paramoz;
    this.c = paramvp;
    this.d = paramad;
    this.e = paramand;
    this.f = paramvv;
    this.g = paramag;
    this.l = paramatv;
  }
  
  public static vx a()
  {
    try
    {
      if (j == null) {
        j = new vx(pv.a(), c.a(), oz.a(), vp.a(), ad.a(), and.a(), vv.a(), ag.a(), atv.a());
      }
      vx localvx = j;
      return localvx;
    }
    finally {}
  }
  
  private void a(aoi paramaoi, File paramFile, byte[] paramArrayOfByte, int paramInt)
  {
    paramaoi.a(new wr(paramFile, paramInt));
    if (paramArrayOfByte != null) {
      com.whatsapp.protocol.l.a(paramaoi.o(), paramArrayOfByte);
    }
    paramaoi.a(new ws(this, paramArrayOfByte));
    b(paramaoi);
  }
  
  public static void a(Exception paramException)
  {
    r localr = new r();
    localr.a = "AudioTranscodingError";
    localr.b = paramException.toString();
    com.whatsapp.fieldstats.l.a(u.a(), localr);
  }
  
  private static void b(Exception paramException)
  {
    r localr = new r();
    localr.a = "VideoTranscodingError";
    localr.b = paramException.toString();
    com.whatsapp.fieldstats.l.a(u.a(), localr);
  }
  
  public final void a(aoi paramaoi)
  {
    paramaoi.a(new ahi(this.d));
    synchronized (this.h)
    {
      if (paramaoi.h() != null) {
        Log.i("mediatranscodequeue/queue " + paramaoi.j() + " " + paramaoi.h().getAbsolutePath());
      }
      this.h.add(paramaoi);
      this.h.notifyAll();
      if (this.m == null)
      {
        this.m = new a((byte)0);
        this.m.setPriority(1);
        this.m.start();
      }
      return;
    }
  }
  
  public final void a(j paramj)
  {
    for (;;)
    {
      synchronized (this.h)
      {
        if (paramj.d != 1) {
          return;
        }
        Object localObject1 = this.h.iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label330;
        }
        Object localObject2 = (aoi)((Iterator)localObject1).next();
        if (!((aoi)localObject2).a(paramj.e)) {
          continue;
        }
        Log.i("mediatranscodequeue/cancel pending " + paramj.e.c);
        if (((aoi)localObject2).g())
        {
          Log.i("mediatranscodequeue/cancel pending and remove from queue " + paramj.e.c);
          this.h.remove(localObject2);
          i1 = 1;
          localObject1 = paramj.b();
          i2 = i1;
          if (this.i != null)
          {
            i2 = i1;
            if (this.i.a(paramj.e))
            {
              Log.i("mediatranscodequeue/cancel current " + paramj.e.c);
              if (!this.i.g()) {
                break label335;
              }
              Log.i("mediatranscodequeue/cancel current transcoding " + paramj.e.c);
              localObject2 = ((MediaData)localObject1).transcoder;
              if (localObject2 == null) {
                break label335;
              }
              ((xf)localObject2).b();
              break label335;
            }
          }
          if (i2 != 0)
          {
            Log.i("mediatranscodequeue/cancel " + paramj.e.c);
            paramj.d = 0;
            ((MediaData)localObject1).transferring = false;
            ((MediaData)localObject1).progress = 0L;
            paramj.b().autodownloadRetryEnabled = false;
            this.d.e(paramj, -1);
          }
          return;
        }
      }
      int i1 = 1;
      continue;
      label330:
      i1 = 0;
      continue;
      label335:
      int i2 = 1;
    }
  }
  
  final PowerManager.WakeLock b()
  {
    PowerManager localPowerManager;
    if (this.n == null)
    {
      localPowerManager = this.e.a;
      if (localPowerManager != null) {
        break label30;
      }
      Log.w("media-transcode-queue/get-transcode-wakelock pm=null");
    }
    for (;;)
    {
      return this.n;
      label30:
      this.n = localPowerManager.newWakeLock(1, "mediatranscode");
    }
  }
  
  final void b(aoi paramaoi)
  {
    this.a.a(wt.a(this, paramaoi));
  }
  
  final void c(aoi paramaoi)
  {
    Log.i("mediatranscodequeue/failed-to-transcode-or-cancelled");
    paramaoi.a(new ahh(this.d));
  }
  
  final class a
    extends Thread
  {
    private a() {}
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 32
      //   2: invokestatic 38	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   5: aload_0
      //   6: getfield 12	com/whatsapp/vx$a:a	Lcom/whatsapp/vx;
      //   9: getfield 42	com/whatsapp/vx:h	Ljava/util/ArrayList;
      //   12: invokevirtual 48	java/util/ArrayList:size	()I
      //   15: ifne +33 -> 48
      //   18: ldc 50
      //   20: invokestatic 38	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   23: aload_0
      //   24: getfield 12	com/whatsapp/vx$a:a	Lcom/whatsapp/vx;
      //   27: getfield 42	com/whatsapp/vx:h	Ljava/util/ArrayList;
      //   30: astore 4
      //   32: aload 4
      //   34: monitorenter
      //   35: aload_0
      //   36: getfield 12	com/whatsapp/vx$a:a	Lcom/whatsapp/vx;
      //   39: getfield 42	com/whatsapp/vx:h	Ljava/util/ArrayList;
      //   42: invokevirtual 55	java/lang/Object:wait	()V
      //   45: aload 4
      //   47: monitorexit
      //   48: aload_0
      //   49: getfield 12	com/whatsapp/vx$a:a	Lcom/whatsapp/vx;
      //   52: getfield 42	com/whatsapp/vx:h	Ljava/util/ArrayList;
      //   55: invokevirtual 48	java/util/ArrayList:size	()I
      //   58: ifeq +118 -> 176
      //   61: aload_0
      //   62: getfield 12	com/whatsapp/vx$a:a	Lcom/whatsapp/vx;
      //   65: getfield 42	com/whatsapp/vx:h	Ljava/util/ArrayList;
      //   68: astore 4
      //   70: aload 4
      //   72: monitorenter
      //   73: aload_0
      //   74: getfield 12	com/whatsapp/vx$a:a	Lcom/whatsapp/vx;
      //   77: getfield 42	com/whatsapp/vx:h	Ljava/util/ArrayList;
      //   80: iconst_0
      //   81: invokevirtual 59	java/util/ArrayList:remove	(I)Ljava/lang/Object;
      //   84: checkcast 61	com/whatsapp/aoi
      //   87: astore 6
      //   89: aload_0
      //   90: getfield 12	com/whatsapp/vx$a:a	Lcom/whatsapp/vx;
      //   93: aload 6
      //   95: putfield 64	com/whatsapp/vx:i	Lcom/whatsapp/aoi;
      //   98: new 66	java/lang/StringBuilder
      //   101: dup
      //   102: ldc 68
      //   104: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   107: aload 6
      //   109: invokevirtual 74	com/whatsapp/aoi:j	()Ljava/lang/String;
      //   112: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   115: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   118: invokestatic 38	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   121: aload 4
      //   123: monitorexit
      //   124: aload 6
      //   126: invokevirtual 85	com/whatsapp/aoi:n	()Lcom/whatsapp/protocol/j;
      //   129: getfield 91	com/whatsapp/protocol/j:s	B
      //   132: lookupswitch	default:+907->1039, 1:+186->318, 2:+174->306, 3:+162->294, 13:+150->282
      //   176: aload_0
      //   177: getfield 12	com/whatsapp/vx$a:a	Lcom/whatsapp/vx;
      //   180: getfield 42	com/whatsapp/vx:h	Ljava/util/ArrayList;
      //   183: astore 4
      //   185: aload 4
      //   187: monitorenter
      //   188: aload_0
      //   189: getfield 12	com/whatsapp/vx$a:a	Lcom/whatsapp/vx;
      //   192: aconst_null
      //   193: putfield 64	com/whatsapp/vx:i	Lcom/whatsapp/aoi;
      //   196: aload 4
      //   198: monitorexit
      //   199: invokestatic 95	java/lang/Thread:interrupted	()Z
      //   202: istore_3
      //   203: iload_3
      //   204: ifeq -199 -> 5
      //   207: return
      //   208: astore 5
      //   210: aload 4
      //   212: monitorexit
      //   213: aload 5
      //   215: athrow
      //   216: astore 4
      //   218: aload_0
      //   219: getfield 12	com/whatsapp/vx$a:a	Lcom/whatsapp/vx;
      //   222: getfield 42	com/whatsapp/vx:h	Ljava/util/ArrayList;
      //   225: astore 4
      //   227: aload 4
      //   229: monitorenter
      //   230: aload_0
      //   231: getfield 12	com/whatsapp/vx$a:a	Lcom/whatsapp/vx;
      //   234: getfield 42	com/whatsapp/vx:h	Ljava/util/ArrayList;
      //   237: invokevirtual 98	java/util/ArrayList:isEmpty	()Z
      //   240: ifne +762 -> 1002
      //   243: aload_0
      //   244: getfield 12	com/whatsapp/vx$a:a	Lcom/whatsapp/vx;
      //   247: getfield 42	com/whatsapp/vx:h	Ljava/util/ArrayList;
      //   250: iconst_0
      //   251: invokevirtual 59	java/util/ArrayList:remove	(I)Ljava/lang/Object;
      //   254: checkcast 61	com/whatsapp/aoi
      //   257: invokestatic 103	com/whatsapp/ahj:a	()Lcom/whatsapp/util/au;
      //   260: invokevirtual 106	com/whatsapp/aoi:a	(Lcom/whatsapp/util/au;)V
      //   263: goto -33 -> 230
      //   266: astore 5
      //   268: aload 4
      //   270: monitorexit
      //   271: aload 5
      //   273: athrow
      //   274: astore 5
      //   276: aload 4
      //   278: monitorexit
      //   279: aload 5
      //   281: athrow
      //   282: aload_0
      //   283: getfield 12	com/whatsapp/vx$a:a	Lcom/whatsapp/vx;
      //   286: aload 6
      //   288: invokestatic 109	com/whatsapp/vx:a	(Lcom/whatsapp/vx;Lcom/whatsapp/aoi;)V
      //   291: goto -115 -> 176
      //   294: aload_0
      //   295: getfield 12	com/whatsapp/vx$a:a	Lcom/whatsapp/vx;
      //   298: aload 6
      //   300: invokestatic 112	com/whatsapp/vx:b	(Lcom/whatsapp/vx;Lcom/whatsapp/aoi;)V
      //   303: goto -127 -> 176
      //   306: aload_0
      //   307: getfield 12	com/whatsapp/vx$a:a	Lcom/whatsapp/vx;
      //   310: aload 6
      //   312: invokestatic 115	com/whatsapp/vx:c	(Lcom/whatsapp/vx;Lcom/whatsapp/aoi;)V
      //   315: goto -139 -> 176
      //   318: aload_0
      //   319: getfield 12	com/whatsapp/vx$a:a	Lcom/whatsapp/vx;
      //   322: astore 8
      //   324: new 117	com/whatsapp/any
      //   327: dup
      //   328: invokespecial 118	com/whatsapp/any:<init>	()V
      //   331: aload 6
      //   333: invokevirtual 85	com/whatsapp/aoi:n	()Lcom/whatsapp/protocol/j;
      //   336: getfield 91	com/whatsapp/protocol/j:s	B
      //   339: invokevirtual 121	com/whatsapp/any:a	(I)Lcom/whatsapp/any;
      //   342: astore 9
      //   344: aload 8
      //   346: invokevirtual 124	com/whatsapp/vx:b	()Landroid/os/PowerManager$WakeLock;
      //   349: astore 7
      //   351: aload 7
      //   353: ifnull +8 -> 361
      //   356: aload 7
      //   358: invokevirtual 129	android/os/PowerManager$WakeLock:acquire	()V
      //   361: aload 6
      //   363: invokevirtual 85	com/whatsapp/aoi:n	()Lcom/whatsapp/protocol/j;
      //   366: getfield 133	com/whatsapp/protocol/j:y	Ljava/lang/String;
      //   369: invokestatic 139	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   372: astore 5
      //   374: aload 9
      //   376: new 141	java/io/File
      //   379: dup
      //   380: aload 5
      //   382: invokevirtual 144	android/net/Uri:getPath	()Ljava/lang/String;
      //   385: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
      //   388: invokevirtual 149	java/io/File:length	()J
      //   391: invokevirtual 152	com/whatsapp/any:a	(J)Lcom/whatsapp/any;
      //   394: pop
      //   395: new 154	com/whatsapp/MediaData
      //   398: dup
      //   399: invokespecial 155	com/whatsapp/MediaData:<init>	()V
      //   402: astore 4
      //   404: aload 6
      //   406: invokevirtual 158	com/whatsapp/aoi:q	()Z
      //   409: istore_3
      //   410: invokestatic 163	com/whatsapp/u:a	()Landroid/content/Context;
      //   413: astore 10
      //   415: aload 8
      //   417: getfield 166	com/whatsapp/vx:b	Lcom/whatsapp/oz;
      //   420: astore 11
      //   422: aload 8
      //   424: getfield 170	com/whatsapp/vx:e	Lcom/whatsapp/and;
      //   427: astore 12
      //   429: iload_3
      //   430: ifeq +129 -> 559
      //   433: getstatic 176	com/whatsapp/aic:Q	I
      //   436: istore_1
      //   437: iload_3
      //   438: ifeq +128 -> 566
      //   441: getstatic 179	com/whatsapp/aic:R	I
      //   444: istore_2
      //   445: aload 10
      //   447: aload 11
      //   449: aload 12
      //   451: aload 5
      //   453: aload 4
      //   455: iload_1
      //   456: iload_2
      //   457: invokestatic 184	com/whatsapp/util/MediaFileUtils:a	(Landroid/content/Context;Lcom/whatsapp/oz;Lcom/whatsapp/and;Landroid/net/Uri;Lcom/whatsapp/MediaData;II)[B
      //   460: astore 10
      //   462: aload 4
      //   464: getfield 188	com/whatsapp/MediaData:file	Ljava/io/File;
      //   467: astore 5
      //   469: aload 5
      //   471: aload 4
      //   473: invokestatic 191	com/whatsapp/util/MediaFileUtils:b	(Ljava/io/File;Lcom/whatsapp/MediaData;)V
      //   476: aload 6
      //   478: new 193	com/whatsapp/wm
      //   481: dup
      //   482: aload 8
      //   484: aload 10
      //   486: aload 4
      //   488: invokespecial 196	com/whatsapp/wm:<init>	(Lcom/whatsapp/vx;[BLcom/whatsapp/MediaData;)V
      //   491: invokevirtual 106	com/whatsapp/aoi:a	(Lcom/whatsapp/util/au;)V
      //   494: iconst_1
      //   495: istore_2
      //   496: iload_2
      //   497: istore_1
      //   498: aload 5
      //   500: astore 4
      //   502: aload 7
      //   504: ifnull +28 -> 532
      //   507: iload_2
      //   508: istore_1
      //   509: aload 5
      //   511: astore 4
      //   513: aload 7
      //   515: invokevirtual 199	android/os/PowerManager$WakeLock:isHeld	()Z
      //   518: ifeq +14 -> 532
      //   521: aload 7
      //   523: invokevirtual 202	android/os/PowerManager$WakeLock:release	()V
      //   526: aload 5
      //   528: astore 4
      //   530: iload_2
      //   531: istore_1
      //   532: iload_1
      //   533: ifeq +446 -> 979
      //   536: aload 9
      //   538: aload 4
      //   540: invokevirtual 149	java/io/File:length	()J
      //   543: invokevirtual 204	com/whatsapp/any:b	(J)Lcom/whatsapp/any;
      //   546: invokevirtual 207	com/whatsapp/any:d	()V
      //   549: aload 8
      //   551: aload 6
      //   553: invokevirtual 210	com/whatsapp/vx:b	(Lcom/whatsapp/aoi;)V
      //   556: goto -380 -> 176
      //   559: getstatic 213	com/whatsapp/aic:w	I
      //   562: istore_1
      //   563: goto -126 -> 437
      //   566: getstatic 216	com/whatsapp/aic:x	I
      //   569: istore_2
      //   570: goto -125 -> 445
      //   573: astore 4
      //   575: aconst_null
      //   576: astore 5
      //   578: new 66	java/lang/StringBuilder
      //   581: dup
      //   582: ldc -38
      //   584: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   587: aload 4
      //   589: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   592: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   595: invokestatic 223	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
      //   598: aload 9
      //   600: ldc -31
      //   602: invokevirtual 228	com/whatsapp/any:a	(Ljava/lang/String;)Lcom/whatsapp/any;
      //   605: pop
      //   606: aload 5
      //   608: astore 4
      //   610: aload 7
      //   612: ifnull +422 -> 1034
      //   615: aload 5
      //   617: astore 4
      //   619: aload 7
      //   621: invokevirtual 199	android/os/PowerManager$WakeLock:isHeld	()Z
      //   624: ifeq +410 -> 1034
      //   627: aload 7
      //   629: invokevirtual 202	android/os/PowerManager$WakeLock:release	()V
      //   632: iconst_0
      //   633: istore_1
      //   634: aload 5
      //   636: astore 4
      //   638: goto -106 -> 532
      //   641: astore 4
      //   643: aconst_null
      //   644: astore 5
      //   646: new 66	java/lang/StringBuilder
      //   649: dup
      //   650: ldc -26
      //   652: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   655: aload 4
      //   657: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   660: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   663: invokestatic 223	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
      //   666: aload 4
      //   668: invokevirtual 233	java/io/IOException:getMessage	()Ljava/lang/String;
      //   671: ifnull +91 -> 762
      //   674: aload 4
      //   676: invokevirtual 233	java/io/IOException:getMessage	()Ljava/lang/String;
      //   679: ldc -21
      //   681: invokevirtual 241	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   684: ifeq +78 -> 762
      //   687: aload 8
      //   689: getfield 244	com/whatsapp/vx:a	Lcom/whatsapp/pv;
      //   692: new 246	com/whatsapp/wn
      //   695: dup
      //   696: aload 8
      //   698: invokespecial 247	com/whatsapp/wn:<init>	(Lcom/whatsapp/vx;)V
      //   701: invokevirtual 252	com/whatsapp/pv:a	(Ljava/lang/Runnable;)V
      //   704: aload 9
      //   706: new 66	java/lang/StringBuilder
      //   709: dup
      //   710: ldc -2
      //   712: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   715: aload 4
      //   717: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   720: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   723: invokevirtual 228	com/whatsapp/any:a	(Ljava/lang/String;)Lcom/whatsapp/any;
      //   726: pop
      //   727: aload 5
      //   729: astore 4
      //   731: aload 7
      //   733: ifnull +301 -> 1034
      //   736: aload 5
      //   738: astore 4
      //   740: aload 7
      //   742: invokevirtual 199	android/os/PowerManager$WakeLock:isHeld	()Z
      //   745: ifeq +289 -> 1034
      //   748: aload 7
      //   750: invokevirtual 202	android/os/PowerManager$WakeLock:release	()V
      //   753: iconst_0
      //   754: istore_1
      //   755: aload 5
      //   757: astore 4
      //   759: goto -227 -> 532
      //   762: aload 8
      //   764: getfield 244	com/whatsapp/vx:a	Lcom/whatsapp/pv;
      //   767: new 256	com/whatsapp/wo
      //   770: dup
      //   771: aload 8
      //   773: invokespecial 257	com/whatsapp/wo:<init>	(Lcom/whatsapp/vx;)V
      //   776: invokevirtual 252	com/whatsapp/pv:a	(Ljava/lang/Runnable;)V
      //   779: goto -75 -> 704
      //   782: astore 4
      //   784: aload 7
      //   786: ifnull +16 -> 802
      //   789: aload 7
      //   791: invokevirtual 199	android/os/PowerManager$WakeLock:isHeld	()Z
      //   794: ifeq +8 -> 802
      //   797: aload 7
      //   799: invokevirtual 202	android/os/PowerManager$WakeLock:release	()V
      //   802: aload 4
      //   804: athrow
      //   805: astore 4
      //   807: aconst_null
      //   808: astore 5
      //   810: new 66	java/lang/StringBuilder
      //   813: dup
      //   814: ldc_w 259
      //   817: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   820: aload 4
      //   822: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   825: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   828: invokestatic 223	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
      //   831: aload 9
      //   833: ldc_w 261
      //   836: invokevirtual 228	com/whatsapp/any:a	(Ljava/lang/String;)Lcom/whatsapp/any;
      //   839: pop
      //   840: aload 8
      //   842: getfield 244	com/whatsapp/vx:a	Lcom/whatsapp/pv;
      //   845: new 263	com/whatsapp/wp
      //   848: dup
      //   849: aload 8
      //   851: invokespecial 264	com/whatsapp/wp:<init>	(Lcom/whatsapp/vx;)V
      //   854: invokevirtual 252	com/whatsapp/pv:a	(Ljava/lang/Runnable;)V
      //   857: aload 5
      //   859: astore 4
      //   861: aload 7
      //   863: ifnull +171 -> 1034
      //   866: aload 5
      //   868: astore 4
      //   870: aload 7
      //   872: invokevirtual 199	android/os/PowerManager$WakeLock:isHeld	()Z
      //   875: ifeq +159 -> 1034
      //   878: aload 7
      //   880: invokevirtual 202	android/os/PowerManager$WakeLock:release	()V
      //   883: iconst_0
      //   884: istore_1
      //   885: aload 5
      //   887: astore 4
      //   889: goto -357 -> 532
      //   892: astore 4
      //   894: aconst_null
      //   895: astore 5
      //   897: new 66	java/lang/StringBuilder
      //   900: dup
      //   901: ldc_w 266
      //   904: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   907: aload 4
      //   909: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   912: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   915: invokestatic 223	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
      //   918: aload 9
      //   920: ldc_w 268
      //   923: invokevirtual 228	com/whatsapp/any:a	(Ljava/lang/String;)Lcom/whatsapp/any;
      //   926: pop
      //   927: aload 8
      //   929: getfield 244	com/whatsapp/vx:a	Lcom/whatsapp/pv;
      //   932: new 270	com/whatsapp/wq
      //   935: dup
      //   936: aload 8
      //   938: invokespecial 271	com/whatsapp/wq:<init>	(Lcom/whatsapp/vx;)V
      //   941: invokevirtual 252	com/whatsapp/pv:a	(Ljava/lang/Runnable;)V
      //   944: aload 5
      //   946: astore 4
      //   948: aload 7
      //   950: ifnull +84 -> 1034
      //   953: aload 5
      //   955: astore 4
      //   957: aload 7
      //   959: invokevirtual 199	android/os/PowerManager$WakeLock:isHeld	()Z
      //   962: ifeq +72 -> 1034
      //   965: aload 7
      //   967: invokevirtual 202	android/os/PowerManager$WakeLock:release	()V
      //   970: iconst_0
      //   971: istore_1
      //   972: aload 5
      //   974: astore 4
      //   976: goto -444 -> 532
      //   979: aload 9
      //   981: invokevirtual 273	com/whatsapp/any:e	()V
      //   984: aload 8
      //   986: aload 6
      //   988: invokevirtual 275	com/whatsapp/vx:c	(Lcom/whatsapp/aoi;)V
      //   991: goto -815 -> 176
      //   994: astore 5
      //   996: aload 4
      //   998: monitorexit
      //   999: aload 5
      //   1001: athrow
      //   1002: aload_0
      //   1003: getfield 12	com/whatsapp/vx$a:a	Lcom/whatsapp/vx;
      //   1006: aconst_null
      //   1007: putfield 64	com/whatsapp/vx:i	Lcom/whatsapp/aoi;
      //   1010: aload 4
      //   1012: monitorexit
      //   1013: return
      //   1014: astore 4
      //   1016: goto -119 -> 897
      //   1019: astore 4
      //   1021: goto -211 -> 810
      //   1024: astore 4
      //   1026: goto -380 -> 646
      //   1029: astore 4
      //   1031: goto -453 -> 578
      //   1034: iconst_0
      //   1035: istore_1
      //   1036: goto -504 -> 532
      //   1039: goto -863 -> 176
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1042	0	this	a
      //   436	600	1	i	int
      //   444	126	2	j	int
      //   202	236	3	bool	boolean
      //   30	181	4	localArrayList	ArrayList
      //   216	1	4	localInterruptedException	InterruptedException
      //   225	314	4	localObject1	Object
      //   573	15	4	locale1	com.whatsapp.util.MediaFileUtils.e
      //   608	29	4	localObject2	Object
      //   641	75	4	localIOException1	java.io.IOException
      //   729	29	4	localObject3	Object
      //   782	21	4	localObject4	Object
      //   805	16	4	localOutOfMemoryError1	OutOfMemoryError
      //   859	29	4	localObject5	Object
      //   892	16	4	localSecurityException1	SecurityException
      //   946	65	4	localObject6	Object
      //   1014	1	4	localSecurityException2	SecurityException
      //   1019	1	4	localOutOfMemoryError2	OutOfMemoryError
      //   1024	1	4	localIOException2	java.io.IOException
      //   1029	1	4	locale2	com.whatsapp.util.MediaFileUtils.e
      //   208	6	5	localObject7	Object
      //   266	6	5	localObject8	Object
      //   274	6	5	localObject9	Object
      //   372	601	5	localObject10	Object
      //   994	6	5	localObject11	Object
      //   87	900	6	localaoi	aoi
      //   349	617	7	localWakeLock	PowerManager.WakeLock
      //   322	663	8	localvx	vx
      //   342	638	9	localany	any
      //   413	72	10	localObject12	Object
      //   420	28	11	localoz	oz
      //   427	23	12	localand	and
      // Exception table:
      //   from	to	target	type
      //   35	48	208	finally
      //   210	213	208	finally
      //   0	5	216	java/lang/InterruptedException
      //   5	35	216	java/lang/InterruptedException
      //   48	73	216	java/lang/InterruptedException
      //   124	176	216	java/lang/InterruptedException
      //   176	188	216	java/lang/InterruptedException
      //   199	203	216	java/lang/InterruptedException
      //   213	216	216	java/lang/InterruptedException
      //   279	282	216	java/lang/InterruptedException
      //   282	291	216	java/lang/InterruptedException
      //   294	303	216	java/lang/InterruptedException
      //   306	315	216	java/lang/InterruptedException
      //   318	351	216	java/lang/InterruptedException
      //   513	526	216	java/lang/InterruptedException
      //   536	556	216	java/lang/InterruptedException
      //   619	632	216	java/lang/InterruptedException
      //   740	753	216	java/lang/InterruptedException
      //   789	802	216	java/lang/InterruptedException
      //   802	805	216	java/lang/InterruptedException
      //   870	883	216	java/lang/InterruptedException
      //   957	970	216	java/lang/InterruptedException
      //   979	991	216	java/lang/InterruptedException
      //   999	1002	216	java/lang/InterruptedException
      //   230	263	266	finally
      //   268	271	266	finally
      //   1002	1013	266	finally
      //   73	124	274	finally
      //   276	279	274	finally
      //   356	361	573	com/whatsapp/util/MediaFileUtils$e
      //   361	429	573	com/whatsapp/util/MediaFileUtils$e
      //   433	437	573	com/whatsapp/util/MediaFileUtils$e
      //   441	445	573	com/whatsapp/util/MediaFileUtils$e
      //   445	469	573	com/whatsapp/util/MediaFileUtils$e
      //   559	563	573	com/whatsapp/util/MediaFileUtils$e
      //   566	570	573	com/whatsapp/util/MediaFileUtils$e
      //   356	361	641	java/io/IOException
      //   361	429	641	java/io/IOException
      //   433	437	641	java/io/IOException
      //   441	445	641	java/io/IOException
      //   445	469	641	java/io/IOException
      //   559	563	641	java/io/IOException
      //   566	570	641	java/io/IOException
      //   356	361	782	finally
      //   361	429	782	finally
      //   433	437	782	finally
      //   441	445	782	finally
      //   445	469	782	finally
      //   469	494	782	finally
      //   559	563	782	finally
      //   566	570	782	finally
      //   578	606	782	finally
      //   646	704	782	finally
      //   704	727	782	finally
      //   762	779	782	finally
      //   810	857	782	finally
      //   897	944	782	finally
      //   356	361	805	java/lang/OutOfMemoryError
      //   361	429	805	java/lang/OutOfMemoryError
      //   433	437	805	java/lang/OutOfMemoryError
      //   441	445	805	java/lang/OutOfMemoryError
      //   445	469	805	java/lang/OutOfMemoryError
      //   559	563	805	java/lang/OutOfMemoryError
      //   566	570	805	java/lang/OutOfMemoryError
      //   356	361	892	java/lang/SecurityException
      //   361	429	892	java/lang/SecurityException
      //   433	437	892	java/lang/SecurityException
      //   441	445	892	java/lang/SecurityException
      //   445	469	892	java/lang/SecurityException
      //   559	563	892	java/lang/SecurityException
      //   566	570	892	java/lang/SecurityException
      //   188	199	994	finally
      //   996	999	994	finally
      //   469	494	1014	java/lang/SecurityException
      //   469	494	1019	java/lang/OutOfMemoryError
      //   469	494	1024	java/io/IOException
      //   469	494	1029	com/whatsapp/util/MediaFileUtils$e
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/vx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */