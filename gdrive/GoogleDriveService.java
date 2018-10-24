package com.whatsapp.gdrive;

import a.a.a.a.a.a.d;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.database.Observable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager.WifiLock;
import android.os.Binder;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Environment;
import android.os.IBinder;
import android.text.TextUtils;
import com.whatsapp.Me;
import com.whatsapp.aat;
import com.whatsapp.aic;
import com.whatsapp.and;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.aus;
import com.whatsapp.aut;
import com.whatsapp.av;
import com.whatsapp.data.ad;
import com.whatsapp.data.n;
import com.whatsapp.fieldstats.events.bi;
import com.whatsapp.fieldstats.events.k;
import com.whatsapp.messaging.CaptivePortalActivity;
import com.whatsapp.messaging.m;
import com.whatsapp.ox;
import com.whatsapp.oz;
import com.whatsapp.pv;
import com.whatsapp.registration.x;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.bd;
import com.whatsapp.util.l;
import com.whatsapp.util.r.b;
import com.whatsapp.va;
import com.whatsapp.wallpaper.g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class GoogleDriveService
  extends IntentService
{
  private static final ConditionVariable A;
  private static boolean B;
  private static boolean C;
  private static boolean D;
  private static final ConditionVariable E;
  private static final ConditionVariable F;
  private static final ConditionVariable G;
  private static final ConditionVariable H;
  private static boolean I;
  private static boolean J;
  private static boolean K;
  private static boolean L;
  private static int M;
  private static int N;
  private static int O;
  private static boolean P;
  private static boolean Q;
  private static final AtomicBoolean S;
  private static final AtomicBoolean T;
  private static final AtomicBoolean U;
  private static final AtomicBoolean V;
  private static final AtomicBoolean W;
  private static final Object aB;
  private static final Object aC;
  private static boolean ao;
  static final ev o;
  private static final Set<String> x;
  private static final ConditionVariable y;
  private static final ConditionVariable z;
  private final f R = new f();
  private final AtomicBoolean X = new AtomicBoolean(false);
  private Bundle Y;
  private long Z;
  final AtomicLong a = new AtomicLong(0L);
  private final File[] aA;
  private long aa;
  private final AtomicLong ab = new AtomicLong(0L);
  private final AtomicInteger ac = new AtomicInteger(0);
  private final AtomicLong ad = new AtomicLong(0L);
  private long ae;
  private String af;
  private String ag;
  private String ah;
  private List<bb> ai;
  private List<bb> aj;
  private k ak;
  private ex al;
  private Intent am;
  private WifiManager.WifiLock an;
  private final ev ap = new ev()
  {
    public final boolean a()
    {
      return GoogleDriveService.a(GoogleDriveService.this);
    }
    
    public final String toString()
    {
      return "suitable-condition";
    }
  };
  private final pv aq = pv.a();
  private final va ar = va.a();
  private final x as = x.a();
  private final ad at = ad.a();
  private final m au = m.a();
  private final and av = and.a();
  private final aus aw = aus.a();
  private final g ax = g.a();
  private final aat ay = aat.a();
  private final atu az = atu.a();
  final AtomicLong b = new AtomicLong(0L);
  final AtomicLong c = new AtomicLong(0L);
  long d;
  bb e;
  bb f;
  bi g;
  public bk h;
  List<bb> i;
  bc j;
  at k;
  boolean l;
  CountDownLatch m;
  final d n = new d((byte)0);
  final ev p = new ev()
  {
    public final boolean a()
    {
      return (GoogleDriveService.a()) && (GoogleDriveService.a(GoogleDriveService.this)) && (GoogleDriveService.a());
    }
    
    public final String toString()
    {
      return "backup-condition";
    }
  };
  final ev q = new ev()
  {
    public final boolean a()
    {
      return (GoogleDriveService.i()) && (GoogleDriveService.a(GoogleDriveService.this)) && (GoogleDriveService.i());
    }
    
    public final String toString()
    {
      return "media-restore-condition";
    }
  };
  final com.whatsapp.util.a.c r = com.whatsapp.util.a.c.a();
  final oz s = oz.a();
  final ox t = ox.a();
  final atv u = atv.a();
  final ch.a<Boolean, File> v = new bm(this);
  
  static
  {
    if (!GoogleDriveService.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      w = bool;
      x = new TreeSet(Arrays.asList(new String[] { "jpg", "gif", "png", "mp3", "amr", "caf", "qcp", "wma", "aac", "wav", "mp4", "mov", "3gp", "wmv", "3ga", "webm", "ogv", "opus", "oga", "flv", "avi", "mpg", "3gpp", "3g2", "m4a", "m4v", "mpga", "asf", "pdf", "docx", "pptx", "xlsx", "doc", "ppt", "xls", "txt", "rtf", "ogg", "jpeg", "mpeg" }));
      y = new ConditionVariable(false);
      z = new ConditionVariable(false);
      A = new ConditionVariable(false);
      B = false;
      C = false;
      D = false;
      E = new ConditionVariable(false);
      F = new ConditionVariable(false);
      G = new ConditionVariable(false);
      H = new ConditionVariable(false);
      I = false;
      J = false;
      K = false;
      L = false;
      M = 0;
      N = 0;
      P = false;
      Q = false;
      S = new AtomicBoolean(false);
      T = new AtomicBoolean(false);
      U = new AtomicBoolean(false);
      V = new AtomicBoolean(false);
      W = new AtomicBoolean(false);
      ao = true;
      o = new ev()
      {
        public final boolean a()
        {
          return GoogleDriveService.g();
        }
        
        public final String toString()
        {
          return "network-condition";
        }
      };
      aB = new Object()
      {
        public final void onEventAsync(com.whatsapp.g.f paramAnonymousf)
        {
          if (GoogleDriveService.c())
          {
            if ((GoogleDriveService.a()) || (GoogleDriveService.j()) || (GoogleDriveService.i())) {
              GoogleDriveService.h();
            }
          }
          else {
            return;
          }
          GoogleDriveService.h(atv.a());
        }
      };
      aC = new Object()
      {
        public final void onEventAsync(com.whatsapp.g.d paramAnonymousd)
        {
          GoogleDriveService.a(paramAnonymousd);
        }
      };
      return;
    }
  }
  
  public GoogleDriveService()
  {
    super(GoogleDriveService.class.getCanonicalName());
    Object localObject1 = this.s;
    if (!((oz)localObject1).l) {
      ((oz)localObject1).j();
    }
    localObject1 = ((oz)localObject1).a;
    Object localObject2 = this.s;
    if (!((oz)localObject2).l) {
      ((oz)localObject2).j();
    }
    localObject2 = ((oz)localObject2).b;
    File localFile = this.s.f();
    oz localoz = this.s;
    if (!localoz.l) {
      localoz.j();
    }
    this.aA = new File[] { localObject1, localObject2, localFile, localoz.c, this.s.b(), this.s.e(), this.s.g(), this.s.h() };
  }
  
  private void A()
  {
    if ((this.an != null) && (this.an.isHeld())) {
      this.an.release();
    }
  }
  
  /* Error */
  private int a(ArrayList<bb> paramArrayList, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 415	com/whatsapp/gdrive/GoogleDriveService:ap	Lcom/whatsapp/gdrive/ev;
    //   5: invokespecial 562	com/whatsapp/gdrive/GoogleDriveService:c	(Lcom/whatsapp/gdrive/ev;)Ljava/lang/String;
    //   8: astore 9
    //   10: aload_0
    //   11: aload_0
    //   12: getfield 412	com/whatsapp/gdrive/GoogleDriveService:q	Lcom/whatsapp/gdrive/ev;
    //   15: invokespecial 564	com/whatsapp/gdrive/GoogleDriveService:d	(Lcom/whatsapp/gdrive/ev;)Ljava/lang/String;
    //   18: astore 10
    //   20: aload 10
    //   22: ifnull +85 -> 107
    //   25: iconst_2
    //   26: anewarray 206	java/lang/String
    //   29: astore 8
    //   31: aload 8
    //   33: iconst_0
    //   34: aload 9
    //   36: aastore
    //   37: aload 8
    //   39: iconst_1
    //   40: aload 10
    //   42: aastore
    //   43: aload_0
    //   44: getfield 566	com/whatsapp/gdrive/GoogleDriveService:k	Lcom/whatsapp/gdrive/at;
    //   47: aload 8
    //   49: aload_0
    //   50: getfield 412	com/whatsapp/gdrive/GoogleDriveService:q	Lcom/whatsapp/gdrive/ev;
    //   53: invokevirtual 571	com/whatsapp/gdrive/at:a	([Ljava/lang/String;Lcom/whatsapp/gdrive/ev;)Ljava/util/List;
    //   56: astore 11
    //   58: aload 11
    //   60: ifnonnull +62 -> 122
    //   63: new 573	java/lang/StringBuilder
    //   66: dup
    //   67: ldc_w 575
    //   70: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   73: aload 9
    //   75: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc_w 582
    //   81: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 10
    //   86: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc_w 584
    //   92: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   101: iconst_0
    //   102: istore 4
    //   104: iload 4
    //   106: ireturn
    //   107: iconst_1
    //   108: anewarray 206	java/lang/String
    //   111: astore 8
    //   113: aload 8
    //   115: iconst_0
    //   116: aload 9
    //   118: aastore
    //   119: goto -76 -> 43
    //   122: aload 11
    //   124: getstatic 594	com/whatsapp/gdrive/at:b	Ljava/util/Comparator;
    //   127: invokestatic 600	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   130: new 602	java/util/HashSet
    //   133: dup
    //   134: invokespecial 603	java/util/HashSet:<init>	()V
    //   137: astore 8
    //   139: aload_1
    //   140: invokevirtual 609	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   143: astore_1
    //   144: aload_1
    //   145: invokeinterface 614 1 0
    //   150: ifeq +26 -> 176
    //   153: aload 8
    //   155: aload_1
    //   156: invokeinterface 618 1 0
    //   161: checkcast 620	com/whatsapp/gdrive/bb
    //   164: getfield 622	com/whatsapp/gdrive/bb:d	Ljava/lang/String;
    //   167: invokeinterface 628 2 0
    //   172: pop
    //   173: goto -29 -> 144
    //   176: aload 11
    //   178: invokeinterface 631 1 0
    //   183: astore 10
    //   185: iconst_0
    //   186: istore_3
    //   187: iload_3
    //   188: istore 4
    //   190: aload 10
    //   192: invokeinterface 614 1 0
    //   197: ifeq -93 -> 104
    //   200: aload 10
    //   202: invokeinterface 618 1 0
    //   207: checkcast 620	com/whatsapp/gdrive/bb
    //   210: astore 9
    //   212: aload_0
    //   213: getfield 429	com/whatsapp/gdrive/GoogleDriveService:r	Lcom/whatsapp/util/a/c;
    //   216: aload_0
    //   217: getfield 450	com/whatsapp/gdrive/GoogleDriveService:t	Lcom/whatsapp/ox;
    //   220: aload 9
    //   222: getfield 622	com/whatsapp/gdrive/bb:d	Ljava/lang/String;
    //   225: invokestatic 636	com/whatsapp/gdrive/ch:a	(Lcom/whatsapp/util/a/c;Lcom/whatsapp/ox;Ljava/lang/String;)Ljava/lang/String;
    //   228: astore_1
    //   229: aload 8
    //   231: aload 9
    //   233: getfield 622	com/whatsapp/gdrive/bb:d	Ljava/lang/String;
    //   236: invokeinterface 639 2 0
    //   241: ifeq -54 -> 187
    //   244: aload_1
    //   245: ifnonnull +30 -> 275
    //   248: new 573	java/lang/StringBuilder
    //   251: dup
    //   252: ldc_w 641
    //   255: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   258: aload 9
    //   260: getfield 622	com/whatsapp/gdrive/bb:d	Ljava/lang/String;
    //   263: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   272: goto -85 -> 187
    //   275: new 532	java/io/File
    //   278: dup
    //   279: aload_1
    //   280: invokespecial 644	java/io/File:<init>	(Ljava/lang/String;)V
    //   283: astore 11
    //   285: iconst_0
    //   286: istore 7
    //   288: iconst_0
    //   289: istore 6
    //   291: iload_3
    //   292: istore 4
    //   294: aload_0
    //   295: aload 11
    //   297: aload 9
    //   299: aload_0
    //   300: getfield 412	com/whatsapp/gdrive/GoogleDriveService:q	Lcom/whatsapp/gdrive/ev;
    //   303: invokevirtual 647	com/whatsapp/gdrive/GoogleDriveService:a	(Ljava/io/File;Lcom/whatsapp/gdrive/bb;Lcom/whatsapp/gdrive/ev;)Z
    //   306: istore 5
    //   308: iload_3
    //   309: iconst_1
    //   310: iadd
    //   311: istore_3
    //   312: iload 5
    //   314: istore 6
    //   316: iload_3
    //   317: istore 4
    //   319: iload 5
    //   321: istore 7
    //   323: aload_0
    //   324: getfield 386	com/whatsapp/gdrive/GoogleDriveService:a	Ljava/util/concurrent/atomic/AtomicLong;
    //   327: aload 9
    //   329: getfield 649	com/whatsapp/gdrive/bb:a	J
    //   332: invokevirtual 653	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
    //   335: pop2
    //   336: iload 5
    //   338: istore 6
    //   340: iload_3
    //   341: istore 4
    //   343: iload 5
    //   345: istore 7
    //   347: aload_0
    //   348: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   351: aload_0
    //   352: getfield 386	com/whatsapp/gdrive/GoogleDriveService:a	Ljava/util/concurrent/atomic/AtomicLong;
    //   355: invokevirtual 657	java/util/concurrent/atomic/AtomicLong:get	()J
    //   358: invokevirtual 659	com/whatsapp/atv:i	(J)V
    //   361: iload 5
    //   363: istore 6
    //   365: iload_3
    //   366: istore 4
    //   368: iload 5
    //   370: istore 7
    //   372: aload_0
    //   373: getfield 388	com/whatsapp/gdrive/GoogleDriveService:b	Ljava/util/concurrent/atomic/AtomicLong;
    //   376: ldc2_w 660
    //   379: aload 9
    //   381: getfield 649	com/whatsapp/gdrive/bb:a	J
    //   384: lmul
    //   385: invokevirtual 653	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
    //   388: pop2
    //   389: iload 5
    //   391: istore 6
    //   393: iload_3
    //   394: istore 4
    //   396: iload 5
    //   398: istore 7
    //   400: aload 8
    //   402: aload 9
    //   404: getfield 622	com/whatsapp/gdrive/bb:d	Ljava/lang/String;
    //   407: invokeinterface 664 2 0
    //   412: pop
    //   413: new 573	java/lang/StringBuilder
    //   416: dup
    //   417: ldc_w 666
    //   420: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   423: aload 9
    //   425: invokevirtual 669	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   428: ldc_w 671
    //   431: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload 8
    //   436: invokeinterface 675 1 0
    //   441: invokevirtual 678	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   444: ldc_w 680
    //   447: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: iload_2
    //   451: invokevirtual 678	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   454: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   460: goto -273 -> 187
    //   463: astore_1
    //   464: iconst_0
    //   465: istore 5
    //   467: iload 5
    //   469: istore 7
    //   471: iload 7
    //   473: istore 6
    //   475: new 573	java/lang/StringBuilder
    //   478: dup
    //   479: ldc_w 682
    //   482: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   485: aload 11
    //   487: invokevirtual 669	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: aload_1
    //   494: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   497: iload 7
    //   499: ifne +53 -> 552
    //   502: aload 11
    //   504: invokevirtual 688	java/io/File:exists	()Z
    //   507: ifeq +45 -> 552
    //   510: aload 11
    //   512: invokevirtual 691	java/io/File:length	()J
    //   515: lconst_0
    //   516: lcmp
    //   517: ifne +35 -> 552
    //   520: aload 11
    //   522: invokevirtual 694	java/io/File:delete	()Z
    //   525: ifne +27 -> 552
    //   528: new 573	java/lang/StringBuilder
    //   531: dup
    //   532: ldc_w 696
    //   535: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   538: aload 11
    //   540: invokevirtual 699	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   543: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokestatic 701	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   552: new 573	java/lang/StringBuilder
    //   555: dup
    //   556: ldc_w 666
    //   559: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   562: aload 9
    //   564: invokevirtual 669	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   567: ldc_w 671
    //   570: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: aload 8
    //   575: invokeinterface 675 1 0
    //   580: invokevirtual 678	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   583: ldc_w 680
    //   586: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: iload_2
    //   590: invokevirtual 678	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   593: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   599: goto -412 -> 187
    //   602: astore_1
    //   603: iload 6
    //   605: ifne +53 -> 658
    //   608: aload 11
    //   610: invokevirtual 688	java/io/File:exists	()Z
    //   613: ifeq +45 -> 658
    //   616: aload 11
    //   618: invokevirtual 691	java/io/File:length	()J
    //   621: lconst_0
    //   622: lcmp
    //   623: ifne +35 -> 658
    //   626: aload 11
    //   628: invokevirtual 694	java/io/File:delete	()Z
    //   631: ifne +27 -> 658
    //   634: new 573	java/lang/StringBuilder
    //   637: dup
    //   638: ldc_w 696
    //   641: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   644: aload 11
    //   646: invokevirtual 699	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   649: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   655: invokestatic 701	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   658: new 573	java/lang/StringBuilder
    //   661: dup
    //   662: ldc_w 666
    //   665: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   668: aload 9
    //   670: invokevirtual 669	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   673: ldc_w 671
    //   676: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: aload 8
    //   681: invokeinterface 675 1 0
    //   686: invokevirtual 678	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   689: ldc_w 680
    //   692: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: iload_2
    //   696: invokevirtual 678	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   699: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   702: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   705: aload_1
    //   706: athrow
    //   707: astore_1
    //   708: iload 4
    //   710: istore_3
    //   711: goto -240 -> 471
    //   714: astore_1
    //   715: goto -248 -> 467
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	718	0	this	GoogleDriveService
    //   0	718	1	paramArrayList	ArrayList<bb>
    //   0	718	2	paramInt	int
    //   186	525	3	i1	int
    //   102	607	4	i2	int
    //   306	162	5	bool	boolean
    //   289	315	6	i3	int
    //   286	212	7	i4	int
    //   29	651	8	localObject1	Object
    //   8	661	9	localObject2	Object
    //   18	183	10	localObject3	Object
    //   56	589	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   294	308	463	com/whatsapp/gdrive/be
    //   294	308	602	finally
    //   323	336	602	finally
    //   347	361	602	finally
    //   372	389	602	finally
    //   400	413	602	finally
    //   475	497	602	finally
    //   294	308	707	com/whatsapp/gdrive/a
    //   323	336	707	com/whatsapp/gdrive/a
    //   347	361	707	com/whatsapp/gdrive/a
    //   372	389	707	com/whatsapp/gdrive/a
    //   400	413	707	com/whatsapp/gdrive/a
    //   323	336	714	com/whatsapp/gdrive/be
    //   347	361	714	com/whatsapp/gdrive/be
    //   372	389	714	com/whatsapp/gdrive/be
    //   400	413	714	com/whatsapp/gdrive/be
  }
  
  static bb a(at paramat, final bb parambb, ev paramev)
  {
    parambb = parambb.b("secondary_base_folder_id");
    if (parambb == null) {
      return null;
    }
    try
    {
      paramat = (bb)cs.a(paramev, new cd() {}, "gdrive-service/get-secondary-base-folder/get-file");
      return paramat;
    }
    catch (be paramat)
    {
      Log.e("gdrive-service/get-secondary-base-folder/id-exists-but-folder-is-missing");
    }
    return null;
  }
  
  private bb a(String paramString, ev paramev)
  {
    int i2 = 1;
    if (!paramev.a()) {
      return null;
    }
    Object localObject1;
    if (paramString.equals("appDataFolder")) {
      localObject1 = this.ai;
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        if (paramString.equals("appDataFolder")) {}
        for (localObject1 = this.ag;; localObject1 = this.ah)
        {
          if (localObject1 != null) {
            break label94;
          }
          Log.e("gdrive-service/get-base-folder-id, base folder name is null, unexpected.");
          return null;
          if (!paramString.equals("appContent")) {
            break label526;
          }
          localObject1 = this.aj;
          break;
        }
        label94:
        localObject2 = this.k.a(paramString, (String)localObject1, paramString, paramev, true);
      }
      if (localObject2 == null)
      {
        Log.e("gdrive-service/get-base-folder/unable-to-fetch-the-list");
        return null;
      }
      if (((List)localObject2).isEmpty())
      {
        Log.i("gdrive-service/get-base-folder/none-found");
        localObject1 = null;
      }
      label141:
      int i1;
      Object localObject3;
      label291:
      List localList;
      for (;;)
      {
        if (localObject1 != null)
        {
          Log.d("gdrive-service/get-base-folder-id base folder exists (id: " + ((bb)localObject1).c + "), in " + paramString + ", it will not be created again.");
          if ((!paramString.equals("appContent")) || (c(paramev) == null)) {
            break label514;
          }
          try
          {
            paramString = b(paramev);
            if ((w) || (paramString != null)) {
              break label492;
            }
            throw new AssertionError();
          }
          catch (be paramString)
          {
            throw new ay(paramString);
          }
          if (((List)localObject2).size() == 1)
          {
            localObject1 = (bb)((List)localObject2).get(0);
          }
          else
          {
            Log.e("gdrive-service/get-base-folder/multiple-found");
            Log.i("gdrive-service/get-base-folder lets find the one with max number of files");
            i1 = -1;
            localObject3 = ((List)localObject2).iterator();
            localObject1 = null;
            if (!((Iterator)localObject3).hasNext()) {
              break label520;
            }
            localObject2 = (bb)((Iterator)localObject3).next();
            localList = this.k.a(((bb)localObject2).c, paramev);
            if (localList == null) {
              Log.e("gdrive-service/get-base-folder, listFiles on " + ((bb)localObject2).c + " returned null.");
            }
          }
        }
      }
      for (;;)
      {
        if (i2 != 0)
        {
          Log.e("gdrive-service/get-base-folder/failed-to-decide-best-base-folder");
          return null;
          int i3 = localList.size();
          Log.i("gdrive-service/get-base-folder num of files in " + ((bb)localObject2).c + " is " + i3);
          if (i3 <= i1) {
            break label517;
          }
          localObject1 = localObject2;
          i1 = i3;
        }
        label492:
        label514:
        label517:
        for (;;)
        {
          break label291;
          localObject3 = new StringBuilder("gdrive-service/get-base-folder final baseFolderId is ");
          if (localObject1 != null) {}
          for (localObject2 = ((bb)localObject1).c;; localObject2 = null)
          {
            Log.i((String)localObject2 + " with files " + i1);
            break label141;
            break;
          }
          if (a(paramString, (bb)localObject1, paramev)) {
            return (bb)localObject1;
          }
          Log.e("gdrive-service/get-base-folder/unable-to-associate-secondary-with-primary-base-folder");
          return null;
          return (bb)localObject1;
        }
        label520:
        i2 = 0;
      }
      label526:
      localObject1 = null;
    }
  }
  
  static String a(atv paramatv)
  {
    paramatv = paramatv.af();
    if (paramatv == null)
    {
      Log.e("gdrive-service/primary-base-folder-name-for-restore jid is null, fatal error.");
      return null;
    }
    return d(paramatv);
  }
  
  static Set<File> a(Context paramContext)
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(g.a(paramContext));
    localHashSet.add(com.whatsapp.cc.a(paramContext));
    Log.i("gdrive-service/get-internal-files-for-backup [" + TextUtils.join(", ", localHashSet) + "]");
    return localHashSet;
  }
  
  public static void a(String paramString, atv paramatv)
  {
    
    if ("mounted".equals(paramString))
    {
      E.open();
      if (!L)
      {
        L = true;
        if (c()) {
          h(paramatv);
        }
      }
      return;
    }
    E.close();
    Log.d("gdrive-service/can-use-sdcard/not-mounted");
    L = false;
  }
  
  static boolean a()
  {
    return T.get();
  }
  
  static boolean a(int paramInt, atv paramatv)
  {
    
    switch (paramInt)
    {
    default: 
      Log.e("gdrive-service/set-backup-network-setting/incorrect-value/" + paramInt);
      return false;
    }
    M = paramInt;
    e();
    paramatv = paramatv.a.edit();
    paramatv.putString("interface_gdrive_backup_network_setting", String.valueOf(paramInt));
    if (!paramatv.commit())
    {
      Log.w("wa-shared-preferences/set-backup-network-setting unable to commit");
      return false;
    }
    return true;
  }
  
  private boolean a(final Context paramContext, String paramString)
  {
    
    if (this.u.a.contains("gdrive_last_successful_backup_timestamp:" + paramString)) {
      return false;
    }
    paramContext = new at(paramContext, this.r, this.t, this.az, paramString, at.d.a);
    if (!a(paramContext, o, 14))
    {
      Log.i("gdrive-service/fetch-account-data/auth-failed/" + ch.a(paramString));
      return false;
    }
    Object localObject1 = s();
    if (localObject1 == null)
    {
      Log.i("gdrive-service/fetch-account-data/primary-base-folder-name-is-null");
      return false;
    }
    Object localObject2 = paramContext.a("appDataFolder", (String)localObject1, "appDataFolder", o, true);
    if ((localObject2 == null) || (((String)localObject1).length() == 0))
    {
      Log.i("gdrive-service/fetch-account-data/primary-base-folder-not-found/" + (String)localObject1);
      return false;
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (bb)((Iterator)localObject1).next();
      final Object localObject3 = ((bb)localObject2).b("gdrive_file_map_id");
      if (localObject3 == null)
      {
        Log.i("gdrive-service/fetch-account-data/primary-base-folder-found-but-property-missing/gdrive_file_map_id " + localObject2);
      }
      else
      {
        try
        {
          localObject3 = (bb)cs.a(o, new cd() {}, "fetch-gdrive-file-map");
          if (localObject3 != null) {
            break label314;
          }
          Log.i("gdrive-service/fetch-account-data/map-file-not-found/network-error/ " + localObject2);
        }
        catch (be localbe)
        {
          Log.i("gdrive-service/fetch-account-data/map-file-not-found/ " + localObject2);
        }
        continue;
        label314:
        paramContext = new bc(this.r, this.s, this.t, this.at, this.az, this.u, paramContext, ((bb)localObject2).c, null, localbe);
        Log.i("gdrive-service/fetch-account-data/setting-backup-data-for " + ch.a(paramString) + " data: " + localbe.toString());
        this.u.c(paramString, localbe.e);
        this.u.d(paramString, paramContext.b());
        this.u.e(paramString, paramContext.e());
        return true;
      }
    }
    this.u.c(paramString, 0L);
    return false;
  }
  
  static boolean a(at paramat, ev paramev, int paramInt)
  {
    paramat = (Boolean)cs.a(paramev, new cc() {}, "gdrive-service/fetch-token", paramInt);
    return (paramat != null) && (paramat.booleanValue());
  }
  
  private boolean a(final bb parambb1, final bb parambb2, ev paramev)
  {
    Log.i("gdrive-service/associate-secondary-with-primary/primary:" + parambb1.c + "/secondary:" + parambb2.c);
    try
    {
      Boolean localBoolean = (Boolean)cs.a(paramev, new ce() {}, "gdrive-service/associate-secondary-with-primary/failed");
      paramev = localBoolean;
      if (localBoolean == null) {
        paramev = Boolean.FALSE;
      }
      if (!paramev.booleanValue()) {
        Log.e("gdrive-service/associate-secondary-with-primary primary:" + parambb1.c + " secondary:" + parambb2.c + "/failed");
      }
      boolean bool = paramev.booleanValue();
      return bool;
    }
    catch (bf parambb1)
    {
      Log.e("gdrive-service/associate-secondary-with-primary/google-drive-is-full");
    }
    return false;
  }
  
  private boolean a(bc parambc)
  {
    int i1 = r.b.a().m;
    parambc = parambc.e.values().iterator();
    while (parambc.hasNext())
    {
      bb localbb = (bb)parambc.next();
      String str = ch.a(this.r, this.t, localbb.d);
      if ((str != null) && (com.whatsapp.data.cb.a(str) > i1))
      {
        Log.i("gdrive-service/contains-newer-backup/true " + localbb.d + " is newer than " + i1);
        return true;
      }
    }
    return false;
  }
  
  static boolean a(File paramFile, atv paramatv, oz paramoz)
  {
    boolean bool;
    try
    {
      bool = paramoz.b(paramFile);
      if ((!paramatv.ae()) && (bool)) {
        return false;
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.d("gdrive-service/should-backup/in-video-folder " + paramFile, localIOException);
        bool = false;
      }
      l3 = aic.s * 2;
      l1 = aic.C * 2 * 1048576L;
    }
    for (;;)
    {
      try
      {
        if (!paramoz.l) {
          paramoz.j();
        }
        if (paramFile == null) {
          continue;
        }
        bool = paramFile.getCanonicalPath().startsWith(paramoz.d.getCanonicalPath());
        if (!bool) {
          continue;
        }
        i1 = 1;
      }
      catch (IOException paramatv)
      {
        long l2;
        Log.d("gdrive-service/should-backup-in-document-folder " + paramFile, paramatv);
        int i1 = 0;
        continue;
        l1 = l3 * 1048576L;
        continue;
      }
      l2 = paramFile.length();
      if (i1 == 0) {
        continue;
      }
      if (l2 > l1) {
        break;
      }
      paramFile = paramFile.getName();
      i1 = paramFile.lastIndexOf(".");
      if ((i1 == -1) || (i1 == paramFile.length() - 1)) {
        break;
      }
      paramFile = paramFile.substring(i1 + 1);
      if (!x.contains(paramFile)) {
        break;
      }
      return true;
      i1 = 0;
    }
  }
  
  private boolean a(final String paramString1, final String paramString2)
  {
    try
    {
      if (!a(this.k, o, 14))
      {
        Log.i("gdrive-service/change-number/failed-to-fetch-auth-token");
        a(11);
        return false;
      }
      final String str1 = d(paramString1);
      final Object localObject = this.k.a("appDataFolder", str1, "appDataFolder", o, true);
      if (localObject == null)
      {
        Log.e("gdrive-service/change-number fetching list of files with name " + str1 + " returned null, unexpected.");
        return false;
      }
      if (((List)localObject).size() == 0)
      {
        Log.e("gdrive-service/change-number base folder not found for " + str1);
        return false;
      }
      localObject = (bb)((List)localObject).get(0);
      if (localObject == null)
      {
        Log.e("gdrive-service/change-number base folder's resId not found for " + str1);
        return false;
      }
      final String str2 = ((bb)localObject).c;
      localObject = a(this.k, (bb)localObject, o);
      if (localObject != null) {}
      for (localObject = ((bb)localObject).c;; localObject = null)
      {
        paramString1 = (Boolean)cs.a(o, new cc() {}, "gdrive-service/change-number");
        if (paramString1 == null) {
          break;
        }
        boolean bool = paramString1.booleanValue();
        if (!bool) {
          break;
        }
        return true;
      }
      return false;
    }
    catch (f paramString1)
    {
      a(12);
      Log.e(paramString1);
      return false;
    }
    catch (ax paramString1)
    {
      a(11);
      Log.e(paramString1);
      return false;
    }
    catch (bl paramString1)
    {
      a(19);
      Log.e(paramString1);
    }
    return false;
  }
  
  private boolean a(List<File> paramList, File paramFile)
  {
    ArrayList localArrayList = new ArrayList(1000);
    if (!this.az.b()) {
      throw new a();
    }
    if (!b(localArrayList, paramFile)) {
      return false;
    }
    AtomicReference localAtomicReference = new AtomicReference(null);
    CountDownLatch localCountDownLatch = new CountDownLatch(localArrayList.size());
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(true);
    if (localArrayList.size() > 100) {}
    int i2;
    for (int i1 = localArrayList.size() / 100;; i1 = 1)
    {
      i2 = 0;
      if (i2 >= localArrayList.size()) {
        break label295;
      }
      if (this.p.a()) {
        break;
      }
      return false;
    }
    File localFile = (File)localArrayList.get(i2);
    boolean bool1;
    label168:
    boolean bool3;
    if ((localFile.exists()) && (localFile.length() > 0L))
    {
      bool1 = true;
      boolean bool2 = bool1;
      if (ch.a(localFile, this.s)) {
        bool2 = bool1 & a(localFile, this.u, this.s);
      }
      if (!bool2) {
        break label252;
      }
      if (i2 % i1 != 0) {
        break label246;
      }
      bool3 = true;
      label216:
      az.a(bs.a(this, localFile, localAtomicReference, paramList, bool3, localCountDownLatch));
    }
    for (;;)
    {
      i2 += 1;
      break;
      bool1 = false;
      break label168;
      label246:
      bool3 = false;
      break label216;
      label252:
      Log.i("gdrive-service/get-files-to-be-uploaded/skipped " + localFile + " size:" + localFile.length());
      localCountDownLatch.countDown();
    }
    label295:
    Log.d("gdrive-service/get-files-for-upload waiting for all files to be processed in " + paramFile.getAbsolutePath());
    try
    {
      localCountDownLatch.await();
      paramList = (ba)localAtomicReference.get();
      if (paramList == null) {
        break label365;
      }
      if ((paramList instanceof a)) {
        throw ((a)paramList);
      }
    }
    catch (InterruptedException paramList)
    {
      for (;;)
      {
        Log.e(paramList);
      }
    }
    throw new IllegalStateException(paramList);
    label365:
    return localAtomicBoolean.get();
  }
  
  private boolean a(List<String> paramList, Set<String> paramSet, boolean paramBoolean)
  {
    AtomicReference localAtomicReference = new AtomicReference(null);
    Object localObject1 = this.j.e.keySet();
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(true);
    CountDownLatch localCountDownLatch = new CountDownLatch(((Set)localObject1).size());
    int i1 = 0;
    int i3 = ((Set)localObject1).size();
    if (!this.az.b()) {
      throw new a();
    }
    localObject1 = ((Set)localObject1).iterator();
    String str;
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      str = (String)((Iterator)localObject1).next();
      if (i1 % 100 == 0) {
        Log.i("gdrive-service/get-files-to-be-downloaded " + i1 + "/" + i3);
      }
      i1 += 1;
      if (!this.q.a()) {
        return false;
      }
      localObject2 = (ba)localAtomicReference.get();
      if (localObject2 != null)
      {
        if ((localObject2 instanceof a)) {
          throw ((a)localObject2);
        }
        throw new IllegalStateException((Throwable)localObject2);
      }
      this.n.m(i1, i3);
      localObject2 = this.j.a(str);
      localObject3 = ch.a(this.r, this.t, str);
      if (localObject3 == null)
      {
        Log.e("gdrive-service/get-files-to-be-downloaded/skipping-null-download-path relative path: " + str);
        localCountDownLatch.countDown();
      }
      else
      {
        localObject3 = new File((String)localObject3);
        Iterator localIterator = paramSet.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
        } while (!str.startsWith((String)localIterator.next()));
      }
    }
    for (int i2 = 1;; i2 = 0)
    {
      if (i2 == 0)
      {
        localCountDownLatch.countDown();
        break;
      }
      az.a(bt.a(this, localAtomicBoolean, paramBoolean, (File)localObject3, (bb)localObject2, str, paramList, localAtomicReference, localCountDownLatch));
      break;
      paramList = (ba)localAtomicReference.get();
      if (paramList != null)
      {
        if ((paramList instanceof a)) {
          throw ((a)paramList);
        }
        throw new IllegalStateException(paramList);
      }
      try
      {
        Log.i("gdrive-service/get-files-to-be-downloaded waiting for all files to be processed.");
        localCountDownLatch.await();
        return localAtomicBoolean.get();
      }
      catch (InterruptedException paramList)
      {
        Log.e(paramList);
        return false;
      }
    }
  }
  
  private boolean a(List<File> paramList, AtomicReference<ba> paramAtomicReference)
  {
    if (!T.get())
    {
      Log.i("gdrive-service/backup/cancelled.");
      return true;
    }
    paramAtomicReference = (ba)paramAtomicReference.get();
    if (paramAtomicReference != null)
    {
      Log.b("gdrive-service/backup", paramAtomicReference);
      if ((paramAtomicReference instanceof ax)) {
        throw ((ax)paramAtomicReference);
      }
      if ((paramAtomicReference instanceof f)) {
        throw ((f)paramAtomicReference);
      }
      if ((paramAtomicReference instanceof bf)) {
        throw ((bf)paramAtomicReference);
      }
      if ((paramAtomicReference instanceof ay)) {
        throw ((ay)paramAtomicReference);
      }
      if ((paramAtomicReference instanceof bl)) {
        throw ((bl)paramAtomicReference);
      }
      if ((paramAtomicReference instanceof a)) {
        throw ((a)paramAtomicReference);
      }
    }
    if ((this.aa > 0L) && (this.ad.get() * 100.0D / this.aa > 1.0D))
    {
      Log.i("gdrive-service/backup/too-many-failures/" + this.ad.get() * 100.0D / this.aa + "% bytes");
      return true;
    }
    if ((paramList.size() > 0) && (this.ac.get() * 100.0D / paramList.size() > 1.0D))
    {
      Log.i("gdrive-service/backup/too-many-failures/" + this.ac.get() * 100.0D / paramList.size() + "% files");
      return true;
    }
    return false;
  }
  
  private boolean a(Set<String> paramSet, boolean paramBoolean)
  {
    if (O == 2) {
      this.g.c = Long.valueOf(0L);
    }
    Log.d("gdrive-service/restore-files called with filePathPrefix [" + TextUtils.join(",", paramSet) + "]");
    if (this.j == null)
    {
      Log.e("gdrive-service/restore-files this state should have never happened.");
      throw new IllegalStateException("gdrive file map is null.");
    }
    List localList = Collections.synchronizedList(new ArrayList());
    Object localObject = new bd("gdrive-service/get-files-to-be-downloaded");
    if (!a(localList, paramSet, paramBoolean))
    {
      Log.e("gdrive-service/restore-files failed to get list of files to be restored.");
      ((bd)localObject).b();
      return false;
    }
    Log.i("gdrive-service/restore-files/num-files-to-be-downloaded/" + localList.size());
    ((bd)localObject).b();
    long l2 = this.u.a.getLong("gdrive_already_downloaded_bytes", 0L);
    this.Z = l2;
    paramSet = localList.iterator();
    if (paramSet.hasNext())
    {
      localObject = (String)paramSet.next();
      localObject = this.j.a((String)localObject);
      long l3 = this.Z;
      if (localObject != null) {}
      for (long l1 = ((bb)localObject).a;; l1 = 0L)
      {
        this.Z = (l1 + l3);
        break;
      }
    }
    Collections.sort(localList, new ck());
    int i1 = a.a.a.a.d.b(getApplicationContext(), this.av);
    Log.i("gdrive-service/calc-max-concurrent-reads/prop=" + aic.D + ", network_type=" + O + ", year class = " + i1);
    AtomicReference localAtomicReference;
    Executor localExecutor;
    Iterator localIterator;
    if ((O != 1) || (i1 < 2011))
    {
      i1 = Math.min(aic.D, 2);
      if (this.g != null)
      {
        this.g.l = Double.valueOf(localList.size());
        this.g.n = Long.valueOf(i1);
      }
      paramSet = new ArrayList();
      this.a.set(l2);
      this.b.set(0L);
      localObject = new CountDownLatch(localList.size());
      localAtomicReference = new AtomicReference(null);
      localExecutor = ch.f(i1);
      i1 = 0;
      localIterator = localList.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label589;
      }
      String str = (String)localIterator.next();
      i1 += 1;
      if (i1 % 100 == 0) {
        Log.i("gdrive-service/restore-files enqueuing download  " + i1 + "/" + localList.size() + ": " + str);
      }
      bb localbb = this.j.a(str);
      if (localbb != null)
      {
        localExecutor.execute(bu.a(this, localbb, str, localAtomicReference, paramSet, (CountDownLatch)localObject));
        continue;
        i1 = aic.D;
        break;
      }
      Log.e("gdrive-service/restore-files resId cannot be null, skipping.");
      ((CountDownLatch)localObject).countDown();
    }
    try
    {
      label589:
      Log.i("gdrive-service/restore-files waiting for all files to be restored.");
      ((CountDownLatch)localObject).await();
      localObject = (ba)localAtomicReference.get();
      if (localObject == null) {
        break label678;
      }
      if ((localObject instanceof ax)) {
        throw ((ax)localObject);
      }
    }
    catch (InterruptedException paramSet)
    {
      Log.e(paramSet);
      return false;
    }
    if ((localObject instanceof f)) {
      throw ((f)localObject);
    }
    if ((localObject instanceof cn)) {
      throw ((cn)localObject);
    }
    if ((localObject instanceof bl)) {
      throw ((bl)localObject);
    }
    label678:
    if (paramSet.size() > 0)
    {
      Log.i("gdrive-service/restore-files/failed-files/" + paramSet.size() + "/retrying-now");
      i1 = a(paramSet, localList.size());
      if (this.g != null) {
        this.g.o = Double.valueOf(i1);
      }
    }
    Log.i("gdrive-service/restore-files waiting for restore to finish: " + this.a.get() + "/" + this.Z + " (" + this.b.get() + " failed)");
    if ((this.a.get() > 0L) || (this.b.get() > 0L)) {
      d();
    }
    return true;
  }
  
  private boolean a(boolean paramBoolean, ev paramev)
  {
    final Object localObject1 = null;
    String str1 = c(paramev);
    if (str1 == null)
    {
      Log.i("gdrive-service/init-map/primary-base-folder-id-is-null");
      throw new ay("primary base folder does not exist");
    }
    if (paramBoolean)
    {
      Log.i("gdrive-service/init-map/incomplete-backup-found");
      this.j = null;
    }
    Object localObject2;
    while (this.k.a())
    {
      return false;
      localObject1 = b(paramev);
      if ((!w) && (localObject1 == null)) {
        throw new AssertionError();
      }
      localObject1 = ((bb)localObject1).b("gdrive_file_map_id");
      if (localObject1 != null) {}
      for (;;)
      {
        try
        {
          localObject1 = (bb)cs.a(paramev, new cd() {}, "gdrive-service/init-map/verify-gdrive-file-map-exists-on-server");
          if (localObject1 != null)
          {
            this.i = Collections.singletonList(localObject1);
            if (this.i != null) {
              break;
            }
            Log.e("gdrive-service/init-map/unable-to-fetch-gdrive-file-map-files");
            return false;
          }
          this.i = null;
          continue;
          this.i = this.k.a(str1, "gdrive_file_map", "appDataFolder", paramev, false);
        }
        catch (be localbe)
        {
          Log.d("gdrive-service/init-map/fetch-map-file", localbe);
        }
      }
      if (this.i.size() == 0)
      {
        Log.i("gdrive-service/init-map/no-gdrive-file-map-file-found");
        localObject2 = null;
      }
      else
      {
        localObject2 = (bb)this.i.get(0);
      }
    }
    if (this.j == null)
    {
      Log.i("gdrive-service/init-map reading gdrive_file_map");
      String str2 = d(paramev);
      if (str2 == null)
      {
        Log.i("gdrive-service/init-map/secondary-base-folder-id-is-null");
        return false;
      }
      localObject2 = new bc(this.r, this.s, this.t, this.at, this.az, this.u, this.k, str1, str2, (bb)localObject2);
      if (((bc)localObject2).e == null) {
        break label358;
      }
    }
    label358:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        break label363;
      }
      Log.i("gdrive-service/init-map init new gdrive_file_map");
      if (((bc)localObject2).a(paramBoolean, paramev)) {
        break label363;
      }
      Log.e("gdrive-service/init-map init gdrive_file_map failed.");
      return false;
      localObject2 = this.j;
      break;
    }
    label363:
    this.j = ((bc)localObject2);
    Log.i("gdrive-service/init-map/num_entries/" + this.j.e.size());
    Log.i("gdrive-service/init-map/success/true");
    return true;
  }
  
  private bb b(ev paramev)
  {
    if (this.e == null) {
      this.e = a("appDataFolder", paramev);
    }
    return this.e;
  }
  
  static void b(atv paramatv)
  {
    Q = true;
    b((com.whatsapp.g.d)b.a.a.c.a().a(com.whatsapp.g.d.class));
    com.whatsapp.util.bu.a(bv.a(paramatv));
  }
  
  private static void b(com.whatsapp.g.d paramd)
  {
    int i3 = 1;
    int i1 = 0;
    if ((paramd != null) && (paramd.a() != NaN.0D)) {}
    for (int i2 = (int)paramd.a();; i2 = 0)
    {
      H.open();
      K = true;
      if ((!Q) && ((paramd == null) || (!paramd.c()))) {
        break;
      }
      F.open();
      G.open();
      if ((!I) || (!J)) {
        i1 = 1;
      }
      I = true;
      J = true;
      if (i1 != 0)
      {
        Log.i("gdrive-service/can-use-battery/battery-level/" + i2);
        Log.i("gdrive-service/can-use-battery-for-backup/" + I);
        Log.i("gdrive-service/can-use-battery-for-media-restore/" + J);
        Log.i("gdrive-service/ignore-battery-status/" + Q);
      }
      return;
    }
    F.close();
    G.close();
    i1 = i3;
    if (!I) {
      if (!J) {
        break label221;
      }
    }
    label221:
    for (i1 = i3;; i1 = 0)
    {
      I = false;
      J = false;
      break;
    }
  }
  
  private boolean b(final String paramString, ev paramev)
  {
    Boolean localBoolean = (Boolean)cs.a(paramev, new cd() {}, "gdrive-service/delete-folder/" + paramString);
    paramev = localBoolean;
    if (localBoolean == null) {
      paramev = Boolean.FALSE;
    }
    if (paramev.booleanValue())
    {
      Log.i("gdrive-service/delete-folder successfully deleted folder " + paramString + " and all files inside it.");
      return true;
    }
    return false;
  }
  
  private static boolean b(List<File> paramList, File paramFile)
  {
    if (!m())
    {
      Log.e("gdrive-service/get-files-in-folder/timeout " + paramFile.getAbsolutePath());
      return false;
    }
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramFile);
    while (localLinkedList.peek() != null)
    {
      paramFile = (File)localLinkedList.poll();
      if (paramFile.exists())
      {
        if (paramFile.isDirectory())
        {
          paramFile = paramFile.listFiles();
          if (paramFile != null)
          {
            int i2 = paramFile.length;
            int i1 = 0;
            label98:
            Object localObject;
            if (i1 < i2)
            {
              localObject = paramFile[i1];
              if (!((File)localObject).exists()) {
                break label163;
              }
              if (!((File)localObject).isDirectory()) {
                break label141;
              }
              localLinkedList.add(localObject);
            }
            for (;;)
            {
              i1 += 1;
              break label98;
              break;
              label141:
              if (((File)localObject).length() > 0L)
              {
                paramList.add(localObject);
                continue;
                label163:
                Log.w("gdrive-service/get-files-in-folder/does-not-exist " + ((File)localObject).getAbsolutePath());
              }
            }
          }
        }
        else if (paramFile.length() > 0L)
        {
          paramList.add(paramFile);
        }
      }
      else {
        Log.w("gdrive-service/get-files-in-folder/does-not-exist " + paramFile.getAbsolutePath());
      }
    }
    return true;
  }
  
  private String c(ev paramev)
  {
    paramev = b(paramev);
    if (paramev != null) {
      return paramev.c;
    }
    return null;
  }
  
  static void c(atv paramatv)
  {
    Q = true;
    b((com.whatsapp.g.d)b.a.a.c.a().a(com.whatsapp.g.d.class));
    com.whatsapp.util.bu.a(bw.a(paramatv));
  }
  
  private void c(String paramString)
  {
    Log.e("gdrive-service/restore weird situation, no message backup file found for paths [" + TextUtils.join(", ", this.at.c.c()) + "] in primary base folder \"" + paramString + "\" (while looking in gdrive_file_map (size: " + this.j.e.size() + ")");
    List localList = this.k.a(paramString, this.ap);
    if (localList == null) {
      Log.e("gdrive-service/restore unable to fetch list of files in primary base folder.");
    }
    for (;;)
    {
      return;
      Log.i("gdrive-service/restore number of files in " + paramString + ": " + localList.size());
      int i1 = 0;
      while (i1 < Math.min(100, localList.size()))
      {
        Log.i(String.format(Locale.ENGLISH, "gdrive-service/restore/file #%d/%d: %s", new Object[] { Integer.valueOf(i1 + 1), Integer.valueOf(localList.size()), ((bb)localList.get(i1)).toString() }));
        i1 += 1;
      }
    }
  }
  
  public static boolean c()
  {
    if ((av.d()) && (!ao)) {
      return false;
    }
    int i1;
    try
    {
      i1 = ch.a(u.a());
      if (i1 == 0) {
        return true;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      Log.e("gdrive-service/is-access-possible Google Play services are not available.");
      Log.d("gdrive-service/is-access-possible", localNullPointerException);
      return false;
    }
    try
    {
      u.a().getPackageManager().getPackageInfo("com.android.vending", 0);
      Log.i("gdrive-service/is-access-possible Google Play services are missing and can be installed,  status code: " + ch.c(i1));
      return true;
    }
    catch (Exception localException)
    {
      Log.i("gdrive-services/is-access-possible Google Play services are missing and cannot be installed, status code: " + ch.c(i1));
      Log.b("gdrive-services/is-access-possible", localException);
    }
    return false;
  }
  
  private String d(ev paramev)
  {
    Object localObject = null;
    if (this.f != null) {
      paramev = this.f.c;
    }
    do
    {
      return paramev;
      bb localbb = b(paramev);
      if (localbb == null)
      {
        Log.e("gdrive-service/get-secondary-base-folder-id/primary-base-folder-is-null");
        return null;
      }
      this.f = a(this.k, localbb, paramev);
      if (this.f == null)
      {
        Log.i("gdrive-service/get-secondary-base-folder-id/looking-in-secondary-space");
        this.f = a("appContent", paramev);
      }
      paramev = (ev)localObject;
    } while (this.f == null);
    return this.f.c;
  }
  
  private static String d(String paramString)
  {
    return e(paramString) + "-invisible";
  }
  
  static void d(atv paramatv)
  {
    for (;;)
    {
      try
      {
        M = paramatv.ad();
        N = paramatv.V();
        switch (M)
        {
        default: 
          Log.d("gdrive-service/init-network network setting for backup is " + M + " (" + paramatv + ")");
          switch (N)
          {
          case 1: 
            Log.d("gdrive-service/init-network network setting for media restore is " + M + " (" + paramatv + ")");
            return;
          }
          break;
        }
      }
      catch (NumberFormatException paramatv)
      {
        Log.e(paramatv);
        return;
      }
      paramatv = "Wi-Fi or cellular";
      continue;
      paramatv = "unknown";
      continue;
      paramatv = "unknown";
      continue;
      paramatv = "Wi-Fi only";
      continue;
      paramatv = "Wi-Fi or cellular";
      continue;
      paramatv = "Wi-Fi only";
    }
  }
  
  private static String e(String paramString)
  {
    String str;
    if ((!paramString.equals("14085556666")) && (!paramString.equals("14085551235")) && (!paramString.equals("14085551236")) && (!paramString.equals("14085551237")))
    {
      str = paramString;
      if (!paramString.equals("14085551238")) {}
    }
    else
    {
      str = aut.r;
    }
    return str;
  }
  
  static void e()
  {
    boolean bool3 = true;
    boolean bool2 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool1 = false;
    for (;;)
    {
      label237:
      try
      {
        a.d.c();
        localObject1 = and.a();
        O = aat.a().a(true);
        Log.d("gdrive-service/can-use-network/active_network " + O);
        switch (O)
        {
        case 1: 
          if (bool1)
          {
            Log.i("gdrive-service/can-use-network/message-restore/" + D);
            Log.i("gdrive-service/can-use-network/media-restore/" + C);
            Log.i("gdrive-service/can-use-network/backup/" + B);
          }
          return;
        }
      }
      finally {}
      Object localObject1 = ((and)localObject1).e;
      NetworkInfo localNetworkInfo;
      if (localObject1 != null)
      {
        localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if (localObject1 == null)
        {
          Log.i("gdrive-service/can-use-network/active_network/wifi active network info is null, no connection");
          A.close();
          z.close();
          y.close();
          if ((D) || (C)) {
            break;
          }
          bool1 = bool2;
          if (B) {
            break;
          }
          D = false;
          C = false;
          B = false;
        }
      }
      else
      {
        localNetworkInfo = null;
        continue;
      }
      if (CaptivePortalActivity.a(pv.a(), localNetworkInfo))
      {
        Log.i("gdrive-service/can-use-network/active_network/wifi/captive");
        A.close();
        z.close();
        y.close();
        if ((D) || (C)) {
          break label665;
        }
        bool1 = bool4;
        if (B) {
          break label665;
        }
        label324:
        D = false;
        C = false;
        B = false;
      }
      else
      {
        Log.i("gdrive-service/can-use-network/active_network/wifi");
        A.open();
        z.open();
        y.open();
        if ((!D) || (!C)) {
          break label670;
        }
        bool1 = bool5;
        if (!B) {
          break label670;
        }
        label387:
        D = true;
        C = true;
        B = true;
        continue;
        Log.i("gdrive-service/can-use-network/active_network/cellular");
        A.open();
        if (D) {
          break label675;
        }
        bool1 = true;
        label422:
        D = true;
        if ((P) || (M == 1))
        {
          y.open();
          if (B) {
            break label680;
          }
          bool2 = true;
          label453:
          bool1 = bool2 | bool1;
        }
        for (B = true;; B = false)
        {
          if (N != 1) {
            break label512;
          }
          z.open();
          if (C) {
            break label685;
          }
          bool2 = bool3;
          label482:
          bool1 |= bool2;
          C = true;
          break;
          y.close();
          bool1 = B | bool1;
        }
        label512:
        z.close();
        bool1 = C | bool1;
        C = false;
        continue;
        Log.i("gdrive-service/can-use-network/active_network/roaming");
        A.open();
        z.close();
        y.close();
        if ((!D) || (C)) {
          break label690;
        }
        bool1 = bool6;
        if (B) {
          break label690;
        }
        label579:
        D = true;
        C = false;
        B = false;
      }
    }
    Log.i("gdrive-service/can-use-network/active_network/none");
    A.close();
    z.close();
    y.close();
    if ((!D) && (!C))
    {
      bool1 = bool7;
      if (B) {}
    }
    for (;;)
    {
      D = false;
      C = false;
      B = false;
      break;
      break;
      bool1 = true;
      break label237;
      label665:
      bool1 = true;
      break label324;
      label670:
      bool1 = true;
      break label387;
      label675:
      bool1 = false;
      break label422;
      label680:
      bool2 = false;
      break label453;
      label685:
      bool2 = false;
      break label482;
      label690:
      bool1 = true;
      break label579;
      bool1 = true;
    }
  }
  
  static void e(atv paramatv)
  {
    P = true;
    com.whatsapp.util.bu.a(bn.a(paramatv));
  }
  
  private boolean e(ev paramev)
  {
    boolean bool;
    Iterator localIterator;
    if (this.j != null)
    {
      bool = true;
      a.d.a(bool, "mGdriveFileMap is null");
      localIterator = a(this).iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label254;
      }
      File localFile = (File)localIterator.next();
      String str = ch.a(this.t, localFile);
      if (str == null)
      {
        Log.i("gdrive-service/restore-settings-file/skipping/null-title " + localFile.getAbsolutePath());
        continue;
        bool = false;
        break;
      }
      bb localbb = this.j.a(str);
      if (localbb == null) {
        Log.i("gdrive-service/restore-settings-file/skipping/google-drive-file-not-found " + str);
      } else if ((localbb.f == null) || (localbb.f.equals(ch.a(this.t, this.az, localFile)))) {
        Log.i("gdrive-service/restore-settings-file/skipping/already-downloaded " + str);
      } else {
        try
        {
          a(localFile, localbb, paramev);
          Log.i("gdrive-service/restore-settings-file/success " + localFile.getAbsolutePath() + " size: " + localFile.length());
        }
        catch (be localbe)
        {
          Log.d("gdrive-service/restore-settings-file/file-not-found", localbe);
        }
      }
    }
    label254:
    this.ax.b = true;
    return true;
  }
  
  static void f()
  {
    W.set(false);
  }
  
  static void f(atv paramatv)
  {
    paramatv.W();
    d(paramatv);
    com.whatsapp.util.bu.a(bo.a(paramatv));
  }
  
  private boolean f(String paramString)
  {
    if (this.af == null)
    {
      Log.i("gdrive-service/delete-files mAccountName is null, nothing to be deleted.");
      return true;
    }
    Object localObject = d(paramString);
    String str = e(paramString);
    this.k = new at(this, this.r, this.t, this.az, this.af, at.d.d);
    if (!a(this.k, o, 14))
    {
      Log.e("gdrive-service/delete-files/failed-to-fetch-auth-token");
      return false;
    }
    paramString = this.k.a("appDataFolder", (String)localObject, "appDataFolder", o, false);
    if (paramString == null)
    {
      Log.e("gdrive-service/delete-files fetching list of primary base folders with name " + (String)localObject + " returned null, unexpected.");
      return false;
    }
    List localList = this.k.a("appContent", str, "appContent", o, false);
    if (localList == null)
    {
      Log.e("gdrive-service/delete-files fetching list of secondary base folders with name " + str + " returned null, unexpected.");
      return false;
    }
    Log.i("gdrive-service/delete-files/" + (String)localObject + "/num-folders/primary/" + paramString.size());
    Log.i("gdrive-service/delete-files/" + str + "/num-folders/secondary/" + localList.size());
    localObject = new ArrayList();
    ((List)localObject).addAll(paramString);
    ((List)localObject).addAll(localList);
    paramString = ((List)localObject).iterator();
    boolean bool1 = true;
    while (paramString.hasNext())
    {
      localObject = (bb)paramString.next();
      try
      {
        boolean bool2 = b(((bb)localObject).c, o);
        bool1 = bool2 & bool1;
      }
      catch (be localbe)
      {
        Log.d("gdrive-service/delete-files/base-folder-not-found/" + ((bb)localObject).c, localbe);
      }
    }
    this.j = null;
    Log.i("gdrive-service/delete-files/success/" + bool1);
    return bool1;
  }
  
  static void g(atv paramatv)
  {
    a(Environment.getExternalStorageState(), paramatv);
  }
  
  public static void h(atv paramatv)
  {
    
    if ((ch.c(paramatv)) && (!V.get()))
    {
      a(Environment.getExternalStorageState(), paramatv);
      d(paramatv);
      e();
      if ((C) && (J) && (L))
      {
        paramatv = new Intent(u.a(), GoogleDriveService.class);
        paramatv.setAction("action_restore_media");
        u.a().startService(paramatv);
        Log.i("gdrive-service/trigger-pending-media-restore");
        return;
      }
      Log.i("gdrive-service/trigger-nothing media-restore-pending: " + ch.c(paramatv) + " media-restore-running: " + V.get() + " network_available_for_media_restore: " + C + " battery_available_for_media_restore: " + J + " sdcard_available: " + L);
      return;
    }
    if ((ch.a(paramatv)) && (!T.get()))
    {
      a(Environment.getExternalStorageState(), paramatv);
      d(paramatv);
      e();
      if ((B) && (I) && (L))
      {
        paramatv = new Intent(u.a(), GoogleDriveService.class);
        paramatv.setAction("action_backup");
        paramatv.putExtra("only_if_pending", true);
        u.a().startService(paramatv);
        Log.i("gdrive-service/trigger-pending-backup");
        return;
      }
      Log.i("gdrive-service/trigger-nothing is-backup-pending: " + ch.a(paramatv) + " is-backup-running: " + T.get() + " network_available_for_backup: " + B + " battery_available_for_backup: " + I + " sdcard_available: " + L);
      return;
    }
    if ((S.get()) || (W.get()))
    {
      Log.i("gdrive-service/service-running/recalculate-network-and-sdcard");
      a(Environment.getExternalStorageState(), paramatv);
      d(paramatv);
      e();
      return;
    }
    Log.i("gdrive-service/trigger-nothing/nothing-pending");
  }
  
  static void i(atv paramatv)
  {
    W.set(true);
    a(Environment.getExternalStorageState(), paramatv);
    d(paramatv);
    e();
  }
  
  private boolean k()
  {
    if (this.af == null)
    {
      Log.e("gdrive-service/should-run-scrub/account name is null");
      return true;
    }
    Object localObject = this.u;
    String str = this.af;
    long l3 = ((atv)localObject).a.getLong("gdrive_next_scrub_timestamp:" + str, 0L);
    long l4 = System.currentTimeMillis();
    long l1;
    long l2;
    if (l3 == 0L)
    {
      localObject = this.ar.b;
      l1 = l3;
      if (localObject != null)
      {
        l1 = l3;
        l2 = l3;
      }
    }
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(((Me)localObject).number))
        {
          l2 = l3;
          l1 = (int)(Long.valueOf(((Me)localObject).number).longValue() % 7L) * 86400000L + l4;
          l2 = l1;
          this.u.b(this.af, l1);
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        Log.w("gdrive-service/should-run-scrub/number format not valid: " + ((Me)localObject).number);
        l1 = l2;
        continue;
      }
      Log.d("gdrive-service/should-run-scrub/next scrub time is " + l1 + " current time " + l4);
      if (l4 - l1 + 86400000L <= 0L) {
        break;
      }
      return true;
      l1 = l3;
      if (l3 - l4 > 691200000L)
      {
        Log.w("gdrive-service/should-run-scrub/next scrub time (" + l3 + ") too far from a current time (" + l4 + " ) reset to the current time");
        l1 = l4;
      }
    }
    return false;
  }
  
  private static boolean l()
  {
    if (T.get())
    {
      if (!y.block(86400000L))
      {
        Log.e("gdrive-service/network-wait/backup 86400000 milliseconds, giving up now.");
        return false;
      }
    }
    else
    {
      if (!V.get()) {
        break label58;
      }
      if (!z.block(86400000L)) {
        Log.e("gdrive-service/network-wait/media-restore 86400000 milliseconds, giving up now.");
      }
    }
    label58:
    while (A.block(86400000L)) {
      return true;
    }
    Log.e("gdrive-service/network-wait/message-restore 86400000 milliseconds, giving up now.");
    return false;
  }
  
  private static boolean m()
  {
    if (!E.block(86400000L))
    {
      Log.e("gdrive-service/sdcard-wait 86400000 milliseconds, giving up now.");
      return false;
    }
    return true;
  }
  
  private boolean n()
  {
    Log.i("gdrive-service/backup");
    this.n.a();
    File localFile1 = p();
    if ((!T.get()) || (localFile1 == null))
    {
      Log.i("gdrive-service/backup/cancelled");
      return false;
    }
    if (!o())
    {
      this.u.ab();
      return false;
    }
    Log.i("gdrive-service/backup starting initGdriveFileMap");
    if (!this.p.a()) {
      return false;
    }
    if (!a(x(), this.p)) {
      return false;
    }
    this.ae = this.at.z.a.g;
    this.aa = 0L;
    this.c.set(0L);
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(localFile1);
    ((List)localObject1).add(com.whatsapp.cc.a(this.t));
    Collections.addAll((Collection)localObject1, this.aA);
    Object localObject2 = a(this).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add((File)((Iterator)localObject2).next());
    }
    Log.i("gdrive-service/backup calculating total backup size");
    localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (File)((Iterator)localObject2).next();
      if (localObject3 != null) {
        this.d += ch.a((File)localObject3, this.v);
      }
    }
    Log.i("gdrive-service/backup/total-size/" + this.d);
    Log.i("gdrive-service/backup finding filesToBeUploaded");
    Object localObject3 = new bd("gdrive-service/files-to-be-uploaded");
    localObject2 = Collections.synchronizedList(new ArrayList(1000));
    localObject1 = ((List)localObject1).iterator();
    boolean bool3 = true;
    Object localObject4;
    boolean bool4;
    if (((Iterator)localObject1).hasNext())
    {
      localObject4 = (File)((Iterator)localObject1).next();
      if (localObject4 == null) {
        break label1557;
      }
      if (!this.p.a()) {
        return false;
      }
      Log.d("gdrive-service/backup/scanning " + localObject4 + " for files to be uploaded, current upload count: " + ((List)localObject2).size());
      bool3 = a((List)localObject2, (File)localObject4);
      bool4 = bool3;
      if (!bool3) {
        break label437;
      }
    }
    label437:
    long l2;
    long l1;
    boolean bool1;
    label1232:
    label1363:
    label1534:
    label1542:
    label1551:
    label1557:
    for (;;)
    {
      break;
      bool4 = bool3;
      ((bd)localObject3).b();
      if (!this.p.a()) {
        return false;
      }
      if (!bool4)
      {
        Log.e("gdrive-service/backup failed to generate list of files to be uploaded.");
        return false;
      }
      Log.i("gdrive-service/backup/files-to-be-uploaded/count/" + ((List)localObject2).size());
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (File)((Iterator)localObject1).next();
        this.aa += ((File)localObject3).length();
      }
      if (!this.p.a()) {
        return false;
      }
      l2 = this.d;
      localObject1 = this.j;
      if (((bc)localObject1).f.exists()) {}
      for (l1 = ((bc)localObject1).f.length();; l1 = -1L)
      {
        this.d = (l1 + l2);
        if ((w) || (this.ak != null)) {
          break;
        }
        throw new AssertionError();
      }
      if (O == 1) {
        this.ak.c = Long.valueOf(1L);
      }
      for (;;)
      {
        l2 = this.u.a.getLong("gdrive_backup_start_timestamp", -1L);
        l1 = l2;
        if (l2 < 0L)
        {
          l2 = System.currentTimeMillis();
          localObject1 = this.u.a.edit();
          ((SharedPreferences.Editor)localObject1).putLong("gdrive_backup_start_timestamp", l2);
          l1 = l2;
          if (!((SharedPreferences.Editor)localObject1).commit())
          {
            Log.w("wa-shared-preferences/set-backup-start-timestamp unable to commit backup start timestamp to shared prefs");
            l1 = l2;
          }
        }
        l2 = this.u.a.getLong("gdrive_already_uploaded_bytes", 0L);
        this.ab.set(l2);
        this.aa = (l2 + this.aa);
        this.n.l(this.ab.get(), this.aa);
        if ((this.aa <= 0L) || (w())) {
          break;
        }
        Log.e("gdrive-service/backup unable to insert incomplete backup indicator");
        return false;
        if (O == 2) {
          this.ak.c = Long.valueOf(0L);
        }
      }
      this.l = true;
      localObject3 = new AtomicReference(null);
      this.m = new CountDownLatch(((List)localObject2).size());
      localObject4 = ((List)localObject2).iterator();
      boolean bool2 = true;
      if (((Iterator)localObject4).hasNext())
      {
        File localFile2 = (File)((Iterator)localObject4).next();
        if (a((List)localObject2, (AtomicReference)localObject3)) {
          return false;
        }
        if (!localFile2.exists())
        {
          Log.i("gdrive-service/backup-file file " + localFile2.getAbsolutePath() + " does not exist");
          this.ac.incrementAndGet();
          this.m.countDown();
          bool1 = true;
        }
        for (;;)
        {
          bool2 = bool1 & bool2;
          break;
          if (localFile2.isDirectory()) {
            throw new IllegalStateException("gdrive-service/backup-file/expected-file-got-directory-instead/" + localFile2.getAbsolutePath());
          }
          if (!T.get())
          {
            Log.i("gdrive-service/backup-file backup has been cancelled.");
            this.m.countDown();
            bool1 = false;
          }
          else if ((this.aa > 0L) && (100.0D * this.ad.get() / this.aa > 1.0D))
          {
            Log.i("gdrive-service/backup-file/too-many-failures upload-failed:" + this.ad.get() + " upload-total:" + this.aa);
            bool1 = false;
          }
          else
          {
            String str = ch.a(this.t, localFile2);
            if (str == null)
            {
              Log.e("gdrive-service/backup-file fileUploadPath is null for file path: " + localFile2.getAbsolutePath() + ", unexpected");
              bool1 = false;
            }
            else
            {
              if (ch.a(localFile2, this.s)) {}
              for (localObject1 = d(this.p);; localObject1 = c(this.p))
              {
                if (localObject1 != null) {
                  break label1232;
                }
                Log.e("gdrive-service/backup-file/upload-base-folder-is-null " + localFile2.getAbsolutePath());
                bool1 = false;
                break;
              }
              ch.d().execute(br.a(this, (AtomicReference)localObject3, (String)localObject1, localFile2, str));
              bool1 = true;
            }
          }
        }
      }
      Log.i("gdrive-service/backup waiting for backup to finish...");
      try
      {
        bool3 = this.m.await(86400000L, TimeUnit.MILLISECONDS);
        bool1 = bool3 & bool2;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Log.e(localInterruptedException);
          bool1 = false;
        }
        if (this.j.a(ch.a(this.t, localFile1)) != null) {
          break label1363;
        }
        Log.e("gdrive-service/backup/chat-database-not-uploaded/cancel-backup");
        throw new cl("File " + localFile1 + " not backed up");
        bool3 = bool1 & this.l;
        if (!bool3) {
          break label1542;
        }
        Log.i("gdrive-service/backup/files/successful, now backing up gdrive_file_map");
        if (!q()) {
          break label1534;
        }
        Log.i("gdrive-service/backup gdrive_file_map backup successful.");
        bool3 = y();
        l2 = System.currentTimeMillis();
        Log.d(String.format(Locale.ENGLISH, "gdrive-service/backup total wall time for backup: %2f seconds.", new Object[] { Double.valueOf((l2 - l1) / 1000.0D) }));
        this.ak.l = Double.valueOf(this.ab.get() + this.ad.get());
        this.ak.m = Double.valueOf(this.ad.get());
        k localk = this.ak;
        if (this.aa != this.d) {
          break label1551;
        }
        for (bool4 = true;; bool4 = false)
        {
          localk.b = Boolean.valueOf(bool4);
          this.ak.h = Double.valueOf(l2 - l1);
          Log.i("gdrive-service/backup backup finished.");
          return bool3;
          Log.i("gdrive-service/backup gdrive_file_map backup failed.");
          return false;
          Log.i("gdrive-service/backup backup failed.");
          break;
        }
      }
      if (a((List)localObject2, (AtomicReference)localObject3)) {
        return false;
      }
    }
  }
  
  private boolean o()
  {
    boolean bool2 = true;
    Log.i("gdrive-service/init-base");
    Object localObject = s();
    String str3 = t();
    boolean bool1;
    if ((localObject == null) || (str3 == null))
    {
      Log.e("gdrive-service/init-base/folder name null, aborting backup (" + (String)localObject + ", " + str3 + ")");
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      final String str1 = this.u.a.getString("gdrive_primary_base_folder_id", null);
      Log.i("gdrive-service/init-base/folder cached id " + str1);
      if (!TextUtils.isEmpty(str1)) {}
      try
      {
        this.e = ((bb)cs.a(this.p, new ce() {}, "gdrive-service/init-base/"));
        if (this.e != null)
        {
          Log.i("gdrive-service/init-base/got base folder from cached id(" + str1 + ")");
          bool1 = bool2;
          if (d(this.p) != null) {
            continue;
          }
          Log.e("gdrive-service/init-base/unable to create secondary base folder.");
          this.e = null;
          return false;
        }
      }
      catch (be localbe)
      {
        Log.c("gdrive-service/init-base/unable to get primary base folder from saved res id", localbe);
        this.ai = this.k.a("appDataFolder", (String)localObject, "appDataFolder", this.p, true);
        if ((this.ai != null) && (this.ai.isEmpty())) {
          Log.i("gdrive-service/init-base/none primary base folders found");
        }
        this.aj = this.k.a("appContent", str3, "appContent", this.p, true);
        if ((this.ai == null) || (this.ai.isEmpty()) || (c(this.p) == null))
        {
          Log.d("gdrive-service/create-primary-folder");
          if ((this.j != null) && (this.j.e.size() > 0))
          {
            Log.e("gdrive-service/create-primary-folder serious error: mGdriveFileMap is not empty but we don't have primary base folder.");
            Thread.dumpStack();
          }
          for (int i1 = 0;; i1 = 1)
          {
            if (i1 != 0) {
              break label405;
            }
            Log.e("gdrive-service/init-base/primary base folder id is null, aborting backup.");
            return false;
            this.e = ((bb)cs.a(this.p, new cc() {}, "gdrive-service/create-primary-folder/failed"));
            if (this.e == null) {
              break;
            }
          }
        }
        String str2 = c(this.p);
        Log.d("gdrive-service/init-base/primary base folder id is " + str2);
        if (((this.aj == null) || (this.aj.isEmpty()) || (d(this.p) == null)) && (!u()))
        {
          Log.e("gdrive-service/init-base/unable to create secondary base folder.");
          return false;
        }
        Log.d("gdrive-service/init-base/secondary base folder id is " + d(this.p));
        if ((!w) && (str2 == null)) {
          throw new AssertionError();
        }
        localObject = this.u;
        Log.i("wa-shared-preferences/set-backup-primary-base-folder-id");
        bool1 = bool2;
        if (((atv)localObject).a.edit().putString("gdrive_primary_base_folder_id", str2).commit()) {
          continue;
        }
        Log.w("wa-shared-preferences/set-backup-primary-base-folder-id unable to commit the changes");
        return true;
      }
      catch (bg localbg)
      {
        label405:
        for (;;) {}
      }
    }
  }
  
  private File p()
  {
    final AtomicReference localAtomicReference = new AtomicReference();
    Boolean localBoolean;
    try
    {
      localBoolean = (Boolean)cs.a(this.p, new cb() {}, "gdrive-service/backup/get-chatdb-file looking for " + localAtomicReference);
      if (!T.get())
      {
        Log.i("gdrive-service/backup/get-chatdb-file/cancelled");
        return null;
      }
    }
    catch (ba localba)
    {
      throw new IllegalStateException("Unexpected failure: ", localba);
    }
    if ((localBoolean == null) || (!localBoolean.booleanValue()))
    {
      Log.e("gdrive-service/backup/get-chatdb-file " + localba + " does not exist, may be user deleted it or local backup is running?");
      throw new cl("File " + localba + " does not exist.");
    }
    return (File)localba.get();
  }
  
  private boolean q()
  {
    File localFile = this.j.a(this.p);
    if (localFile == null) {
      return false;
    }
    final Object localObject3;
    final Object localObject4;
    try
    {
      localObject3 = this.j;
      long l1 = this.ae;
      int i1 = this.u.R();
      int i2 = this.u.ad();
      boolean bool = this.u.ae();
      if (((bc)localObject3).d == null) {
        Log.e("gdrive-map/get-metadata mNewMetadata is null, did you save gdrive file map?");
      }
      ((bc)localObject3).d.put("backupVersion", 1);
      ((bc)localObject3).d.put("numOfMessages", l1);
      ((bc)localObject3).d.put("backupFrequency", i1);
      ((bc)localObject3).d.put("backupNetworkSettings", i2);
      ((bc)localObject3).d.put("includeVideosInBackup", bool);
      localObject3 = ((bc)localObject3).d.toString();
      localObject4 = c(this.p);
      if (localObject4 == null)
      {
        Log.e("gdrive-service/backup-map primary base folder id is null, aborting gdrive_file_map backup");
        return false;
      }
    }
    catch (JSONException localJSONException)
    {
      Log.d("gdrive-service/backup-map", localJSONException);
      return false;
    }
    if (this.al != null) {
      this.al.b(localJSONException.length());
    }
    try
    {
      localObject4 = (bb)cs.a(this.p, new cg() {}, "gdrive-service/backup-map");
      if (localObject4 == null)
      {
        Log.e("gdrive-service/backup-map failed to create file gdrive_file_map in " + c(this.p));
        return false;
      }
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Log.d("gdrive-service/backup-map", localFileNotFoundException);
      throw new cm(localFileNotFoundException);
      final Object localObject1 = c(this.p);
      if (localObject1 == null) {
        throw new IllegalStateException("Primary base folder id cannot be null at this point");
      }
      this.au.a(86400000L);
      try
      {
        localObject3 = (Boolean)cs.a(this.p, new ce() {}, "gdrive-service/backup-map/insert-property/gdrive_file_map_id");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = Boolean.FALSE;
        }
        if (!((Boolean)localObject1).booleanValue()) {
          break label504;
        }
        localObject1 = b(this.p);
        if ((!w) && (localObject1 == null)) {
          throw new AssertionError();
        }
      }
      catch (be localbe1)
      {
        Log.d("gdrive-service/backup-map", localbe1);
        throw new ay(localbe1);
      }
      localbe1.a("gdrive_file_map_id", ((bb)localObject4).c);
      localObject3 = new ArrayList(Collections.unmodifiableList(this.j.g));
      Object localObject2 = ((List)localObject3).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject5 = (bb)((Iterator)localObject2).next();
        Log.i("gdrive-service/backup-map/deleting " + localObject5);
        continue;
        Log.e("gdrive-service/backup-map failed to update title of the file " + localObject4 + " to gdrive_file_map");
        return false;
      }
      Object localObject5 = new StringBuilder("gdrive-service/backup-map number of old GDRIVE_FILE_MAP_FILENAME files: ");
      if (this.i != null) {}
      for (localObject2 = Integer.valueOf(this.i.size());; localObject2 = "null")
      {
        Log.i(localObject2);
        if ((this.i == null) || (this.i.size() <= 0)) {
          break label757;
        }
        Log.i("gdrive-service/backup-map latest file has modification timestamp: " + ((bb)localObject4).e + " " + l.g(this, this.aw, ((bb)localObject4).e));
        localObject2 = this.i.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject5 = (bb)((Iterator)localObject2).next();
          Log.i("gdrive-service/backup-map deleting old GDRIVE_FILE_MAP_FILENAME " + localObject5 + " with timestamp:" + ((bb)localObject5).e + " " + l.g(this, this.aw, ((bb)localObject5).e));
        }
      }
      ((List)localObject3).addAll(this.i);
      if (((List)localObject3).size() > 0) {}
      for (;;)
      {
        try
        {
          cs.a(this.p, new ce() {}, "gdrive-service/backup-map/delete-files-after-map-backup");
          localObject2 = this.j;
          Log.i("gdrive-map/update-drive-file " + ((bc)localObject2).b + " -> " + localObject4);
          ((bc)localObject2).b = ((bb)localObject4);
          ((bc)localObject2).a();
          this.j.g.clear();
          this.i = Collections.singletonList(localObject4);
          return true;
        }
        catch (be localbe2)
        {
          Log.d("gdrive-service/backup-map/deletion-failed", localbe2);
          continue;
        }
        Log.i("gdrive-service/backup-map/nothing-to-delete-post-backup");
      }
    }
    catch (a locala)
    {
      label504:
      label757:
      for (;;) {}
    }
  }
  
  private boolean r()
  {
    final Object localObject2 = c(this.ap);
    if (localObject2 == null)
    {
      Log.e("gdrive-service/restore primary base folder id is null, aborting restore.");
      return false;
    }
    if (this.u.aa() == 1)
    {
      Log.e("gdrive-service/restore cannot start restore, backup in progress.");
      return false;
    }
    if ((this.j == null) && (!a(false, o))) {
      return false;
    }
    if (this.u.T())
    {
      final Object localObject1 = null;
      File[] arrayOfFile = this.at.c.c();
      int i2 = arrayOfFile.length;
      int i1 = 0;
      for (;;)
      {
        if (i1 < i2)
        {
          localObject1 = arrayOfFile[i1];
          localObject1 = ch.a(this.t, (File)localObject1);
          if (localObject1 == null) {
            throw new IllegalStateException("gdrive-service/restore upload title for database is null");
          }
          localObject1 = this.j.a((String)localObject1);
          if (localObject1 != null) {
            Log.i("gdrive-service/restore found backup file: " + localObject1);
          }
        }
        else
        {
          if (this.ap.a()) {
            break;
          }
          return false;
        }
        i1 += 1;
      }
      a(this.ap);
      if (localObject1 == null)
      {
        if (a(this.j)) {
          throw new ew();
        }
        c((String)localObject2);
        throw new be("no message backup file found for paths [" + TextUtils.join(", ", this.at.c.c()) + "]");
      }
      if (((bb)localObject1).f == null) {
        throw new IllegalStateException("gdrive-service/restore/as-per-map-md5-of-msgstore-is-null");
      }
      localObject2 = new File(ch.a(this.r, this.t, ((bb)localObject1).d));
      if ((((File)localObject2).exists()) && (((File)localObject2).length() > 0L))
      {
        if (((bb)localObject1).f.equals(ch.a(this.t, this.az, (File)localObject2)))
        {
          Log.i("gdrive-service/restore file " + localObject2 + " is same as remote file, no need to download");
          return true;
        }
        Log.i("gdrive-service/restore/rotate-current-backup-file-to-preserve-it");
        a.a.a.a.d.c((File)localObject2, "");
      }
      localObject1 = (Boolean)cs.a(this.ap, new cf() {}, "gdrive-service/restore-messages");
      if ((localObject1 == null) || (!((Boolean)localObject1).booleanValue()))
      {
        Log.e("gdrive-service/restore failed to restore database.");
        return false;
      }
    }
    return true;
  }
  
  private String s()
  {
    Object localObject = this.ar.b;
    if (localObject == null)
    {
      Log.i("gdrive-service/primary-base-folder-name-for-backup App.me is null, can't proceed");
      return null;
    }
    localObject = ((Me)localObject).jabber_id;
    if (localObject == null)
    {
      Log.e("gdrive-service/primary-base-folder-name-for-backup jid is null, fatal error.");
      return null;
    }
    return d((String)localObject);
  }
  
  private String t()
  {
    Object localObject = this.ar.b;
    if (localObject == null)
    {
      Log.i("gdrive-service/secondary-base-folder-name-for-backup App.me is null, can't proceed");
      return null;
    }
    localObject = ((Me)localObject).jabber_id;
    if (localObject == null)
    {
      Log.e("gdrive-service/secondary-base-folder-name-for-backup jid is null, fatal error.");
      return null;
    }
    return e((String)localObject);
  }
  
  private boolean u()
  {
    Log.d("gdrive-service/create-secondary-folder");
    this.f = ((bb)cs.a(this.p, new cd() {}, "gdrive-service/create-secondary-folder/failed"));
    if (this.f == null)
    {
      Log.e("gdrive-service/create-secondary-base-folder/unable-to-create-secondary-base-folder");
      return false;
    }
    bb localbb = b(this.p);
    if (localbb == null)
    {
      Log.e("gdrive-service/create-secondary-base-folder/unable-to-access-primary-base-folder");
      return false;
    }
    try
    {
      boolean bool = a(localbb, this.f, this.p);
      return bool;
    }
    catch (be localbe)
    {
      throw new ay(localbe);
    }
  }
  
  private boolean v()
  {
    Log.i("gdrive-service/scrub");
    if (this.u.aa() != 0) {
      Log.e("gdrive-service/scrub cannot perform scrub if backup/restore is pending.");
    }
    final Object localObject1;
    Object localObject3;
    int i2;
    int i1;
    do
    {
      do
      {
        return false;
        if (!this.p.a())
        {
          Log.w("gdrive-service/scrub cannot perform scrub: backup condition is not met.");
          return false;
        }
        if (this.ai == null)
        {
          Log.i("gdrive-service/scrub/primary-base-folders-are-null/fetching-the-list-again");
          this.ai = this.k.a("appDataFolder", this.ag, "appDataFolder", this.p, true);
        }
        if (this.ai == null)
        {
          Log.e("gdrive-service/scrub null files found with name " + this.ag + " (could be due to a network error).");
          return false;
        }
        if (this.aj == null)
        {
          Log.i("gdrive-service/scrub/secondary-base-folders-are-null/fetching-the-list-again");
          this.aj = this.k.a("appContent", this.ah, "appContent", this.p, false);
        }
        if (this.aj == null)
        {
          Log.e("gdrive-service/scrub null files found with name " + this.ah + " (could be due to a network error).");
          return false;
        }
        localObject1 = b(this.p);
        Log.i("gdrive-service/scrub/best-primary-base-folder " + localObject1);
        if (localObject1 == null)
        {
          Log.e("gdrive-service/scrub primary base folder is null.");
          return false;
        }
        localObject2 = ((bb)localObject1).c;
        localObject1 = d(this.p);
        if (localObject1 == null)
        {
          Log.e("gdrive-service/scrub secondary base folder id is null");
          return false;
        }
        Log.i("gdrive-service/scrub found " + this.ai.size() + " primary folders with title " + this.ag);
        localObject3 = this.ai.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          bb localbb = (bb)((Iterator)localObject3).next();
          if (!localbb.c.equals(localObject2))
          {
            Log.i("gdrive-service/scrub/deleting-primary-folder/" + localbb);
            try
            {
              b(localbb.c, this.p);
            }
            catch (be localbe3)
            {
              Log.e("gdrive-service/scrub/deleting-primary-folder/not-found " + localbb);
            }
          }
        }
        Log.i("gdrive-service/scrub found " + this.aj.size() + " secondary folders with title " + this.ah);
        localObject2 = this.aj.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bb)((Iterator)localObject2).next();
          if (!((bb)localObject3).c.equals(localObject1))
          {
            Log.i("gdrive-service/scrub/deleting-secondary-folder/" + ((bb)localObject3).c);
            try
            {
              b(((bb)localObject3).c, this.p);
            }
            catch (be localbe2)
            {
              Log.e("gdrive-service/scrub/deleting-secondary-folder/not-found " + localObject3);
            }
          }
        }
      } while (!this.p.a());
      Log.i("gdrive-service/scrub/primary-and-secondary-base-folder/list-files");
      localObject1 = this.k;
      localObject2 = c(this.p);
      localObject3 = d(this.p);
      ev localev = this.p;
      localObject3 = ((at)localObject1).a(new String[] { localObject2, localObject3 }, localev);
      if (localObject3 == null)
      {
        Log.e("gdrive-service/scrub backup dir (" + c(this.p) + " has no files (could be due to network error).");
        return false;
      }
      i2 = ((List)localObject3).size();
      localObject1 = new ArrayList(100);
      i1 = 0;
      if ((i1 >= ((List)localObject3).size()) || (((List)localObject1).size() >= 100)) {
        break;
      }
    } while (!this.p.a());
    this.n.a(Math.max(i1 * 100 / ((List)localObject3).size(), ((List)localObject1).size() * 100 / 100));
    Object localObject2 = (bb)((List)localObject3).get(i1);
    if ((!((bb)localObject2).c.equals(c(this.p))) && (!((bb)localObject2).c.equals(d(this.p))) && (!((bb)localObject2).c.equals(this.j.b.c)) && ((this.j.a(((bb)localObject2).d) == null) || (!((bb)localObject2).equals(this.j.a(((bb)localObject2).d)))))
    {
      Log.i("gdrive-service/scrub deleting file not listed in GDRIVE_FILE_MAP: " + localObject2);
      if (((bb)localObject2).b) {
        break label928;
      }
      ((List)localObject1).add(localObject2);
    }
    for (;;)
    {
      i1 += 1;
      break;
      label928:
      Log.e("gdrive-service/scrub file is a directory, which should not have happened." + ((bb)localObject2).c);
    }
    int i3 = ((List)localObject1).size();
    if (i3 == 100) {
      Log.i("gdrive-service/scrub " + i3 + " files found to be deleted in this scrub, hard limit reached. No more deletions.");
    }
    if ((!w) && (this.ak == null)) {
      throw new AssertionError();
    }
    this.ak.p = Long.valueOf(i3);
    if (i3 == 0) {
      Log.i("gdrive-service/scrub nothing to delete.");
    }
    for (;;)
    {
      this.n.a(100);
      if (i2 >= this.j.e.size()) {
        break label1410;
      }
      Log.d("gdrive-service/scrub " + i2 + " files are on Google Drive, which is less than total files in gdrive_file_map (" + this.j.e.size() + "), therefore, marking backup as incomplete.");
      localObject1 = new TreeSet((Collection)localObject3);
      localObject2 = this.j.e.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (bb)((Iterator)localObject2).next();
        if (!((Set)localObject1).contains(localObject3)) {
          Log.i("gdrive-service/scrub file is in gdrive_file_map but is missing from Google Drive: " + localObject3);
        }
      }
      Log.i(String.format(Locale.ENGLISH, "gdrive-service/scrub sending request to delete %d files.", new Object[] { Integer.valueOf(i3) }));
      if (i3 < 10)
      {
        i1 = 0;
        while (i1 < i3)
        {
          Log.i("gdrive-service/scrub/going-to-delete " + ((List)localObject1).get(i1));
          i1 += 1;
        }
      }
      try
      {
        localObject2 = (Boolean)cs.a(this.p, new cd() {}, String.format(Locale.ENGLISH, "gdrive-service/scrub failed to delete %d files, retrying.", new Object[] { Integer.valueOf(i3) }));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = Boolean.FALSE;
        }
        if (!((Boolean)localObject1).booleanValue()) {
          break;
        }
        Log.i(String.format(Locale.ENGLISH, "gdrive-service/scrub %d of %d files were deleted.", new Object[] { Integer.valueOf(i3), Integer.valueOf(i2) }));
      }
      catch (be localbe1)
      {
        Log.d("gdrive-service/scrub", localbe1);
      }
    }
    Log.e(String.format(Locale.ENGLISH, "gdrive-service/scrub failed to delete %d files, retrying.", new Object[] { Integer.valueOf(i3) }));
    return false;
    try
    {
      if (!w()) {
        Log.e("gdrive-service/backup unable to insert incomplete backup indicator, bad but not fatal.");
      }
      label1410:
      return true;
    }
    catch (ay localay)
    {
      for (;;)
      {
        Log.d("gdrive-service/scrub", localay);
      }
    }
    catch (bl localbl)
    {
      for (;;) {}
    }
    catch (bf localbf)
    {
      for (;;) {}
    }
  }
  
  private boolean w()
  {
    if (x()) {
      return true;
    }
    final Object localObject = c(this.p);
    if (localObject == null) {
      return false;
    }
    try
    {
      Boolean localBoolean = (Boolean)cs.a(this.p, new ce() {}, "gdrive-service/insert-incomplete-backup-indicator");
      localObject = localBoolean;
      if (localBoolean == null) {
        localObject = Boolean.FALSE;
      }
      if (!((Boolean)localObject).booleanValue()) {
        break label113;
      }
      localObject = b(this.p);
      if ((!w) && (localObject == null)) {
        throw new AssertionError();
      }
    }
    catch (be localbe)
    {
      throw new ay(localbe);
    }
    localbe.a("incomplete_backup_marker", "true");
    return true;
    label113:
    return false;
  }
  
  private boolean x()
  {
    Object localObject = b(this.p);
    if (localObject == null) {
      Log.e("gdrive-service/is-incomplete-backup-indicator-present/primary-base-folder-is-null");
    }
    do
    {
      return false;
      localObject = ((bb)localObject).b("incomplete_backup_marker");
    } while ((localObject == null) || (!Boolean.parseBoolean((String)localObject)));
    return true;
  }
  
  /* Error */
  private boolean y()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 409	com/whatsapp/gdrive/GoogleDriveService:p	Lcom/whatsapp/gdrive/ev;
    //   5: invokespecial 562	com/whatsapp/gdrive/GoogleDriveService:c	(Lcom/whatsapp/gdrive/ev;)Ljava/lang/String;
    //   8: astore_1
    //   9: aload_1
    //   10: ifnonnull +11 -> 21
    //   13: ldc_w 2331
    //   16: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_0
    //   22: getfield 409	com/whatsapp/gdrive/GoogleDriveService:p	Lcom/whatsapp/gdrive/ev;
    //   25: new 22	com/whatsapp/gdrive/GoogleDriveService$17
    //   28: dup
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial 2332	com/whatsapp/gdrive/GoogleDriveService$17:<init>	(Lcom/whatsapp/gdrive/GoogleDriveService;Ljava/lang/String;)V
    //   34: ldc_w 2334
    //   37: invokestatic 719	com/whatsapp/gdrive/cs:a	(Lcom/whatsapp/gdrive/ev;Lcom/whatsapp/gdrive/cg;Ljava/lang/String;)Ljava/lang/Object;
    //   40: checkcast 1018	java/lang/Boolean
    //   43: astore_2
    //   44: aload_2
    //   45: astore_1
    //   46: aload_2
    //   47: ifnonnull +7 -> 54
    //   50: getstatic 1036	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual 1021	java/lang/Boolean:booleanValue	()Z
    //   58: ifeq +14 -> 72
    //   61: ldc_w 2336
    //   64: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   67: aload_1
    //   68: invokevirtual 1021	java/lang/Boolean:booleanValue	()Z
    //   71: ireturn
    //   72: ldc_w 2338
    //   75: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   78: goto -11 -> 67
    //   81: astore_1
    //   82: new 771	com/whatsapp/gdrive/ay
    //   85: dup
    //   86: aload_1
    //   87: invokespecial 774	com/whatsapp/gdrive/ay:<init>	(Ljava/lang/Throwable;)V
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	GoogleDriveService
    //   8	60	1	localObject	Object
    //   81	6	1	localbe	be
    //   43	4	2	localBoolean	Boolean
    // Exception table:
    //   from	to	target	type
    //   21	44	81	com/whatsapp/gdrive/be
    //   50	54	81	com/whatsapp/gdrive/be
    //   54	67	81	com/whatsapp/gdrive/be
    //   67	72	81	com/whatsapp/gdrive/be
    //   72	78	81	com/whatsapp/gdrive/be
  }
  
  private void z()
  {
    List localList1;
    try
    {
      if (!a(this.k, o, 14)) {
        return;
      }
      localList1 = this.k.a("appDataFolder", this.ag, "appDataFolder", o, true);
      if (localList1 == null)
      {
        Log.e("gdrive-service/list-files/failed-to-fetch-list-of-primary-base-folders");
        return;
      }
    }
    catch (ba localba)
    {
      Log.d("gdrive-service/list-files", localba);
      return;
    }
    Log.i("gdrive-service/list-files/num-primary-base-folder/" + this.ag + "/" + localList1.size());
    List localList2 = this.k.a("appDataFolder", this.ah, "appDataFolder", o, true);
    if (localList2 == null)
    {
      Log.e("gdrive-service/list-files/failed-to-fetch-list-of-old-primary-base-folders");
      return;
    }
    Log.i("gdrive-service/list-files/num-old-primary-base-folder/" + this.ah + "/" + localList2.size());
    List localList3 = this.k.a("appContent", this.ah, "appContent", o, false);
    if (localList3 == null)
    {
      Log.e("gdrive-service/list-files/failed-to-fetch-list-of-secondary-base-folders");
      return;
    }
    Log.i("gdrive-service/list-files/num-secondary-base-folder/" + this.ah + "/" + localList3.size());
    Object localObject = new ArrayList();
    ((List)localObject).add(this.k.a("appDataFolder", "appDataFolder", false));
    ((List)localObject).add(this.k.a("appContent", "appContent", false));
    ((List)localObject).addAll(localList1);
    ((List)localObject).addAll(localList2);
    ((List)localObject).addAll(localList3);
    Iterator localIterator = ((List)localObject).iterator();
    if (localIterator.hasNext())
    {
      bb localbb = (bb)localIterator.next();
      localObject = localbb.d;
      if (localList1.contains(localbb)) {
        localObject = "primary-base-folder";
      }
      List localList4;
      for (;;)
      {
        Log.i("gdrive-service/list-files/" + (String)localObject + "/" + localbb);
        localList4 = this.k.a(localbb.c, o);
        if (localList4 != null) {
          break label476;
        }
        Log.i("gdrive-service/list-files/files-are-null probably due to a network issue");
        break;
        if (localList2.contains(localbb)) {
          localObject = "old-primary-base-folder";
        } else if (localList3.contains(localbb)) {
          localObject = "secondary-base-folder";
        }
      }
      label476:
      Log.i("gdrive-service/list-files/" + (String)localObject + "/" + localbb.d + "/num-files/" + localList4.size());
      int i1 = 0;
      for (;;)
      {
        int i2 = localList4.size();
        if (i1 >= i2) {
          break;
        }
        i1 += 1;
      }
    }
  }
  
  final void a(int paramInt)
  {
    Object localObject = ch.a(paramInt);
    if (paramInt != 10) {
      Log.e("gdrive-service/set-error/" + (String)localObject);
    }
    localObject = this.u.a.edit();
    ((SharedPreferences.Editor)localObject).putInt("gdrive_error_code", paramInt);
    if (!((SharedPreferences.Editor)localObject).commit()) {
      Log.w("wa-shared-preferences/set-error/unable-to-save-to-shared-prefs");
    }
    if (ch.c(this.u))
    {
      this.Y = new Bundle();
      this.Y.putLong("total_bytes_to_be_downloaded", this.Z);
      this.Y.putLong("total_bytes_downloaded", this.a.get());
      this.n.b(paramInt, this.Y);
      if (this.g != null) {
        this.g.a = Integer.valueOf(ch.e(paramInt));
      }
      label155:
      return;
    }
    if (ch.b(this.u))
    {
      this.Y = new Bundle();
      if (this.j != null) {
        this.Y.putLong("msgstore_bytes_to_be_downloaded", this.j.c());
      }
      this.n.c(paramInt, this.Y);
      return;
    }
    if (ch.a(this.u))
    {
      if (this.ak != null) {
        this.ak.a = Integer.valueOf(ch.e(paramInt));
      }
      this.Y = new Bundle();
      this.Y.putLong("total_bytes_to_be_uploaded", this.aa);
      this.n.a(paramInt, this.Y);
      return;
    }
    if (this.am != null)
    {
      localObject = this.am.getAction();
      int i1 = -1;
      switch (((String)localObject).hashCode())
      {
      }
      for (;;)
      {
        switch (i1)
        {
        default: 
          if (paramInt == 10) {
            break label155;
          }
          Log.e("gdrive-service/set-error/unexpected-service-start-action/" + this.am.getAction());
          return;
          if (((String)localObject).equals("action_backup"))
          {
            i1 = 0;
            continue;
            if (((String)localObject).equals("action_restore_media"))
            {
              i1 = 1;
              continue;
              if (((String)localObject).equals("action_restore")) {
                i1 = 2;
              }
            }
          }
          break;
        }
      }
      if (this.ak != null) {
        this.ak.a = Integer.valueOf(ch.e(paramInt));
      }
      this.Y = new Bundle();
      this.Y.putLong("total_bytes_to_be_uploaded", this.aa);
      this.n.a(paramInt, this.Y);
      return;
      if (this.g != null) {
        this.g.a = Integer.valueOf(ch.e(paramInt));
      }
      this.Y = new Bundle();
      this.Y.putLong("total_bytes_to_be_downloaded", this.Z);
      this.Y.putLong("total_bytes_downloaded", this.a.get());
      this.n.b(paramInt, this.Y);
      return;
      this.Y = new Bundle();
      if (this.j != null) {
        this.Y.putLong("msgstore_bytes_to_be_downloaded", this.j.c());
      }
      this.n.c(paramInt, this.Y);
      return;
    }
    Log.i("gdrive-service/set-error/intent-is-null and nothing is pending (probably backup attempt failed)");
    this.Y = new Bundle();
    this.Y.putLong("total_bytes_to_be_uploaded", this.aa);
    this.n.a(paramInt, this.Y);
  }
  
  public final void a(e parame)
  {
    this.n.registerObserver(parame);
    if ((ch.a(this.u)) || (T.get()))
    {
      if (!B) {
        if (M == 0) {
          parame.g(this.ab.get(), this.aa);
        }
      }
      for (;;)
      {
        this.n.a(this.u.Q(), this.Y);
        return;
        parame.h(this.ab.get(), this.aa);
        continue;
        if (!I) {
          parame.i(this.ab.get(), this.aa);
        } else if (!L)
        {
          if ("unmounted".equals(Environment.getExternalStorageState())) {
            parame.j(this.ab.get(), this.aa);
          } else {
            parame.k(this.ab.get(), this.aa);
          }
        }
        else if (this.aa > 0L) {
          parame.l(this.ab.get(), this.aa);
        } else if (ch.a(this.u)) {
          parame.e();
        } else {
          parame.g();
        }
      }
    }
    if ((V.get()) || (ch.c(this.u)))
    {
      if (!C) {
        if (N == 0) {
          parame.a(this.a.get(), this.Z);
        }
      }
      for (;;)
      {
        this.n.b(this.u.Q(), this.Y);
        return;
        parame.b(this.a.get(), this.Z);
        continue;
        if (!J) {
          parame.c(this.a.get(), this.Z);
        } else if (!L)
        {
          if ("unmounted".equals(Environment.getExternalStorageState())) {
            parame.d(this.a.get(), this.Z);
          } else {
            parame.e(this.a.get(), this.Z);
          }
        }
        else if (this.Z > 0L) {
          parame.a(this.a.get(), this.b.get(), this.Z);
        } else {
          parame.a();
        }
      }
    }
    if (ch.b(this.u))
    {
      Log.i("gdrive-service/observer/registered/error/" + ch.a(this.u.Q()));
      return;
    }
    this.n.a(this.u.Q(), this.Y);
  }
  
  final boolean a(ev paramev)
  {
    int i3 = -1;
    Object localObject;
    int i1;
    label126:
    label153:
    boolean bool4;
    if (this.j != null)
    {
      bool2 = true;
      a.d.a(bool2, "gdrive file map is null");
      if (this.af != null)
      {
        this.u.g(this.af);
        this.u.c(this.af, this.j.b.e);
        this.u.d(this.af, this.j.b());
        this.u.e(this.af, this.j.e());
      }
      localObject = this.j;
      if (((bc)localObject).c == null) {
        break label321;
      }
      i1 = ((bc)localObject).c.optInt("backupFrequency", -1);
      localObject = this.j;
      if (((bc)localObject).c == null) {
        break label332;
      }
      i3 = ((bc)localObject).c.optInt("backupNetworkSettings", -1);
      bool4 = this.j.f();
      if (i1 < 0) {
        break label352;
      }
      Log.d("gdrive-service/restore-settings setting backup frequency to " + i1);
    }
    label321:
    label332:
    label350:
    label352:
    for (boolean bool2 = this.u.h(i1);; bool2 = true)
    {
      boolean bool3 = bool2;
      if (i3 >= 0)
      {
        Log.d("gdrive-service/restore-settings setting backup network settings to " + i3);
        bool3 = bool2 & a(i3, this.u);
      }
      boolean bool1 = bool3 & this.u.k(bool4);
      localObject = this.j.g();
      if (localObject != null)
      {
        Log.i("gdrive-service/restore-settings/setting-local-settings " + localObject);
        bool1 &= this.u.a((JSONObject)localObject);
      }
      for (;;)
      {
        if ((bool1 & e(paramev))) {
          break label350;
        }
        Log.w("gdrive-service/restore-settings unable to commit gdrive settings to shared prefs");
        return false;
        bool2 = false;
        break;
        Log.e("gdrive-map/backup-frequency metadata is null.");
        int i2 = -1;
        break label126;
        Log.e("gdrive-map/network-settings metadata is null.");
        break label153;
        Log.i("gdrive-service/restore-settings/local-settings-object-is-null");
      }
      return true;
    }
  }
  
  final boolean a(File paramFile)
  {
    try
    {
      oz localoz = this.s;
      if (!localoz.l) {
        localoz.j();
      }
      if (!localoz.a(paramFile)) {
        return false;
      }
      paramFile = paramFile.getCanonicalPath();
      if ((!paramFile.startsWith(localoz.f.getCanonicalPath())) && (!paramFile.startsWith(localoz.e.getCanonicalPath())) && (!paramFile.startsWith(localoz.i.getCanonicalPath())) && (!paramFile.startsWith(localoz.h.getCanonicalPath())) && (!paramFile.startsWith(localoz.g.getCanonicalPath())))
      {
        boolean bool = paramFile.startsWith(localoz.k.getCanonicalPath());
        if (!bool) {
          return true;
        }
      }
    }
    catch (IOException paramFile) {}
    return false;
  }
  
  final boolean a(final File paramFile, final bb parambb, final ev paramev)
  {
    if (paramev == this.q) {}
    for (final boolean bool = true;; bool = false)
    {
      paramFile = (Boolean)cs.a(paramev, new cf() {}, "gdrive-service/restore-file " + paramFile.getAbsolutePath());
      if ((paramFile == null) || (!paramFile.booleanValue())) {
        break;
      }
      return true;
    }
    throw new bl(String.format(Locale.ENGLISH, "Failed to download file: (%s)", new Object[] { parambb.toString() }));
  }
  
  final boolean a(final String paramString1, final File paramFile, final String paramString2)
  {
    if ((this.aa > 0L) && (100.0D * this.ad.get() / this.aa > 1.0D))
    {
      Log.i("gdrive-service/upload-file/too-many-failures");
      return false;
    }
    if (!this.p.a()) {
      return false;
    }
    if (O == 2)
    {
      if ((!w) && (this.ak == null)) {
        throw new AssertionError();
      }
      this.ak.c = Long.valueOf(0L);
    }
    if (this.al != null) {
      this.al.b(paramFile.length());
    }
    try
    {
      paramString1 = (bb)cs.a(this.p, new cg() {}, "gdrive-service/upload " + paramFile.getAbsolutePath());
      if (paramString1 == null)
      {
        this.ad.addAndGet(paramFile.length());
        this.ac.incrementAndGet();
        Log.i("gdrive-service/upload/failed-bytes/" + this.ad.get());
        Log.i("gdrive-service/upload/failure-percentage/" + 100.0D * this.ad.get() / this.aa + "% bytes");
      }
      if (!this.p.a()) {
        return false;
      }
    }
    finally
    {
      this.ad.addAndGet(paramFile.length());
      this.ac.incrementAndGet();
      Log.i("gdrive-service/upload/failed-bytes/" + this.ad.get());
      Log.i("gdrive-service/upload/failure-percentage/" + 100.0D * this.ad.get() / this.aa + "% bytes");
    }
    if (paramString1 != null)
    {
      Log.i("gdrive-service/upload/success " + paramString1.d + " resId: " + paramString1.c + " size: " + paramString1.a);
      if (this.j == null) {
        break label501;
      }
      this.j.a(paramString1);
      this.ab.addAndGet(paramString1.a);
      paramFile = this.u;
      long l1 = this.ab.get();
      paramFile = paramFile.a.edit();
      paramFile.putLong("gdrive_already_uploaded_bytes", l1);
      paramFile.apply();
      if (this.j == null) {
        break label510;
      }
      this.n.l(this.ab.get(), this.aa);
    }
    for (;;)
    {
      if (paramString1 == null) {
        break label552;
      }
      return true;
      label501:
      Log.i("gdrive-service/upload/success gdrive file map is null, did backup fail already?");
      break;
      label510:
      Log.i(String.format(Locale.ENGLISH, "gdrive-service/upload/success gdrive file map is null, notify backup progress suppressed: %d/%d", new Object[] { Long.valueOf(this.ab.get()), Long.valueOf(this.aa) }));
    }
    label552:
    return false;
  }
  
  public final void b()
  {
    Log.i("gdrive-service/cancel-pending-backup-and-restore-if-any");
    if ((ch.a(this.u)) || (T.get()))
    {
      Log.d("gdrive-service/cancel setting is_backup_running to false.");
      T.set(false);
      cs.a();
      E.open();
      if (this.k != null)
      {
        Log.i("gdrive-service/cancel-backup/interrupt-drive-api");
        this.k.a(false);
        y.open();
        F.open();
        this.h.d();
        P = false;
        this.u.i(0);
      }
    }
    for (;;)
    {
      a(10);
      if (this.u.X()) {
        this.u.j(false);
      }
      return;
      Log.i("gdrive-service/drive-api/null");
      y.open();
      F.open();
      com.whatsapp.util.bu.a(bp.a(this));
      break;
      if (ch.c(this.u))
      {
        Log.d("gdrive-service/cancel setting is_media_restore_running to false.");
        V.set(false);
        E.open();
        if (this.k != null)
        {
          Log.i("gdrive-service/cancel-media-restore/interrupt-drive-api");
          this.k.a(false);
          z.open();
          G.open();
          this.n.c();
          this.u.i(0);
        }
        else
        {
          Log.i("gdrive-service/drive-api/null");
          z.open();
          G.open();
          com.whatsapp.util.bu.a(bq.a(this));
        }
      }
      else if (ch.b(this.u))
      {
        Log.d("gdrive-service/cancel/message-restore");
        U.set(false);
        E.open();
        if (this.k != null) {
          this.k.a(false);
        }
        A.open();
        H.open();
        this.h.d();
        this.u.i(0);
      }
      else
      {
        Log.i("gdrive-service/cancel/nothing-to-cancel");
      }
    }
  }
  
  public final void b(e parame)
  {
    try
    {
      this.n.unregisterObserver(parame);
      return;
    }
    catch (IllegalStateException parame) {}
  }
  
  final void d()
  {
    this.n.a(this.a.get(), this.b.get(), this.Z);
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    return this.R;
  }
  
  public final void onCreate()
  {
    Log.i("gdrive-service/create");
    super.onCreate();
    this.h = new bk(u.a(), this.ay, this.u);
    a(this.h);
  }
  
  public final void onDestroy()
  {
    Log.i("gdrive-service/destroy");
    bk localbk;
    if (this.h != null)
    {
      localbk = this.h;
      Log.i("gdrive-notification-manager/destroy");
      if (localbk.h == null) {}
    }
    try
    {
      localbk.b.unregisterReceiver(localbk.h);
      if (localbk.g != null) {}
      try
      {
        localbk.b.unregisterReceiver(localbk.g);
        if (localbk.i != null) {}
        try
        {
          localbk.b.unregisterReceiver(localbk.i);
          b.a.a.c.a().a(localbk.j);
          b(this.h);
          if (this.k != null) {
            this.k.a(false);
          }
          A();
          S.set(false);
          super.onDestroy();
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          for (;;) {}
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        for (;;) {}
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException3)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public final void onHandleIntent(Intent paramIntent)
  {
    // Byte code:
    //   0: invokestatic 844	com/whatsapp/gdrive/GoogleDriveService:c	()Z
    //   3: ifne +10 -> 13
    //   6: ldc_w 2633
    //   9: invokestatic 763	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   12: return
    //   13: aload_0
    //   14: aload_1
    //   15: putfield 2415	com/whatsapp/gdrive/GoogleDriveService:am	Landroid/content/Intent;
    //   18: aload_1
    //   19: ifnull +21 -> 40
    //   22: aload_1
    //   23: invokevirtual 2418	android/content/Intent:getAction	()Ljava/lang/String;
    //   26: astore 26
    //   28: aload 26
    //   30: ifnonnull +16 -> 46
    //   33: ldc_w 2635
    //   36: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   39: return
    //   40: aconst_null
    //   41: astore 26
    //   43: goto -15 -> 28
    //   46: getstatic 344	com/whatsapp/gdrive/GoogleDriveService:S	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   49: iconst_1
    //   50: invokevirtual 1684	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   53: aload_0
    //   54: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   57: astore 25
    //   59: invokestatic 998	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   62: aload 25
    //   64: invokestatic 1722	com/whatsapp/gdrive/GoogleDriveService:a	(Ljava/lang/String;Lcom/whatsapp/atv;)V
    //   67: aload_0
    //   68: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   71: invokestatic 1688	com/whatsapp/gdrive/GoogleDriveService:d	(Lcom/whatsapp/atv;)V
    //   74: invokestatic 859	com/whatsapp/gdrive/GoogleDriveService:e	()V
    //   77: ldc_w 1756
    //   80: aload 26
    //   82: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifeq +48 -> 133
    //   88: aload_0
    //   89: aload_0
    //   90: invokespecial 908	com/whatsapp/gdrive/GoogleDriveService:s	()Ljava/lang/String;
    //   93: putfield 735	com/whatsapp/gdrive/GoogleDriveService:ag	Ljava/lang/String;
    //   96: aload_0
    //   97: invokespecial 2000	com/whatsapp/gdrive/GoogleDriveService:t	()Ljava/lang/String;
    //   100: astore 25
    //   102: aload_0
    //   103: aload 25
    //   105: putfield 743	com/whatsapp/gdrive/GoogleDriveService:ah	Ljava/lang/String;
    //   108: aload_0
    //   109: getfield 735	com/whatsapp/gdrive/GoogleDriveService:ag	Ljava/lang/String;
    //   112: ifnonnull +68 -> 180
    //   115: aload 26
    //   117: ldc_w 2637
    //   120: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   123: ifne +57 -> 180
    //   126: ldc_w 2639
    //   129: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   132: return
    //   133: aload_0
    //   134: aload_0
    //   135: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   138: invokestatic 2641	com/whatsapp/gdrive/GoogleDriveService:a	(Lcom/whatsapp/atv;)Ljava/lang/String;
    //   141: putfield 735	com/whatsapp/gdrive/GoogleDriveService:ag	Ljava/lang/String;
    //   144: aload_0
    //   145: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   148: invokevirtual 807	com/whatsapp/atv:af	()Ljava/lang/String;
    //   151: astore 25
    //   153: aload 25
    //   155: ifnonnull +15 -> 170
    //   158: ldc_w 2643
    //   161: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   164: aconst_null
    //   165: astore 25
    //   167: goto -65 -> 102
    //   170: aload 25
    //   172: invokestatic 1420	com/whatsapp/gdrive/GoogleDriveService:e	(Ljava/lang/String;)Ljava/lang/String;
    //   175: astore 25
    //   177: goto -75 -> 102
    //   180: ldc_w 2645
    //   183: aload_1
    //   184: ldc_w 2647
    //   187: invokevirtual 2650	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   190: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   193: istore 5
    //   195: iload 5
    //   197: ifeq +350 -> 547
    //   200: aload_0
    //   201: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   204: iconst_1
    //   205: invokevirtual 2561	com/whatsapp/atv:j	(Z)Z
    //   208: pop
    //   209: aload_0
    //   210: getfield 2552	com/whatsapp/gdrive/GoogleDriveService:h	Lcom/whatsapp/gdrive/bk;
    //   213: iload 5
    //   215: putfield 2652	com/whatsapp/gdrive/bk:d	Z
    //   218: aload 26
    //   220: ldc_w 2637
    //   223: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   226: ifeq +333 -> 559
    //   229: aload_1
    //   230: ldc_w 2654
    //   233: invokevirtual 2650	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   236: astore 25
    //   238: aload_0
    //   239: aload 25
    //   241: putfield 1693	com/whatsapp/gdrive/GoogleDriveService:af	Ljava/lang/String;
    //   244: aload_0
    //   245: getfield 1693	com/whatsapp/gdrive/GoogleDriveService:af	Ljava/lang/String;
    //   248: ifnull +488 -> 736
    //   251: aload_0
    //   252: getfield 429	com/whatsapp/gdrive/GoogleDriveService:r	Lcom/whatsapp/util/a/c;
    //   255: astore 27
    //   257: aload_0
    //   258: getfield 450	com/whatsapp/gdrive/GoogleDriveService:t	Lcom/whatsapp/ox;
    //   261: astore 28
    //   263: aload_0
    //   264: getfield 506	com/whatsapp/gdrive/GoogleDriveService:az	Lcom/whatsapp/atu;
    //   267: astore 29
    //   269: aload_0
    //   270: getfield 1693	com/whatsapp/gdrive/GoogleDriveService:af	Ljava/lang/String;
    //   273: astore 30
    //   275: ldc_w 1756
    //   278: aload 26
    //   280: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   283: ifne +14 -> 297
    //   286: ldc_w 2656
    //   289: aload 26
    //   291: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   294: ifeq +277 -> 571
    //   297: getstatic 896	com/whatsapp/gdrive/at$d:a	Lcom/whatsapp/gdrive/at$d;
    //   300: astore 25
    //   302: aload_0
    //   303: new 568	com/whatsapp/gdrive/at
    //   306: dup
    //   307: aload_0
    //   308: aload 27
    //   310: aload 28
    //   312: aload 29
    //   314: aload 30
    //   316: aload 25
    //   318: invokespecial 899	com/whatsapp/gdrive/at:<init>	(Landroid/content/Context;Lcom/whatsapp/util/a/c;Lcom/whatsapp/ox;Lcom/whatsapp/atu;Ljava/lang/String;Lcom/whatsapp/gdrive/at$d;)V
    //   321: putfield 566	com/whatsapp/gdrive/GoogleDriveService:k	Lcom/whatsapp/gdrive/at;
    //   324: new 573	java/lang/StringBuilder
    //   327: dup
    //   328: ldc_w 2658
    //   331: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   334: aload_0
    //   335: getfield 735	com/whatsapp/gdrive/GoogleDriveService:ag	Ljava/lang/String;
    //   338: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 763	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   347: new 573	java/lang/StringBuilder
    //   350: dup
    //   351: ldc_w 2660
    //   354: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   357: aload_0
    //   358: getfield 743	com/whatsapp/gdrive/GoogleDriveService:ah	Ljava/lang/String;
    //   361: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 763	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   370: new 573	java/lang/StringBuilder
    //   373: dup
    //   374: ldc_w 2662
    //   377: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   380: aload 26
    //   382: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   391: ldc_w 1756
    //   394: aload 26
    //   396: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   399: ifne +10 -> 409
    //   402: aload_0
    //   403: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   406: invokevirtual 1841	com/whatsapp/atv:ab	()V
    //   409: iconst_m1
    //   410: istore 4
    //   412: aload 26
    //   414: invokevirtual 2421	java/lang/String:hashCode	()I
    //   417: lookupswitch	default:+75->492, -1755890518:+475->892, -818191995:+458->875, 1035381739:+441->858, 1096596436:+492->909, 1122735421:+526->943, 1461510777:+543->960, 1583504647:+561->978, 1996912751:+509->926
    //   492: iload 4
    //   494: tableswitch	default:+46->540, 0:+502->996, 1:+2492->2986, 2:+3401->3895, 3:+4178->4672, 4:+4596->5090, 5:+4752->5246, 6:+4845->5339, 7:+5057->5551
    //   540: ldc_w 2635
    //   543: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   546: return
    //   547: aload_0
    //   548: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   551: invokevirtual 2559	com/whatsapp/atv:X	()Z
    //   554: istore 5
    //   556: goto -347 -> 209
    //   559: aload_0
    //   560: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   563: invokevirtual 2664	com/whatsapp/atv:ac	()Ljava/lang/String;
    //   566: astore 25
    //   568: goto -330 -> 238
    //   571: ldc_w 2425
    //   574: aload 26
    //   576: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   579: ifne +14 -> 593
    //   582: ldc_w 1732
    //   585: aload 26
    //   587: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   590: ifeq +11 -> 601
    //   593: getstatic 2666	com/whatsapp/gdrive/at$d:b	Lcom/whatsapp/gdrive/at$d;
    //   596: astore 25
    //   598: goto -296 -> 302
    //   601: ldc_w 2668
    //   604: aload 26
    //   606: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   609: ifeq +11 -> 620
    //   612: getstatic 2670	com/whatsapp/gdrive/at$d:c	Lcom/whatsapp/gdrive/at$d;
    //   615: astore 25
    //   617: goto -315 -> 302
    //   620: ldc_w 2637
    //   623: aload 26
    //   625: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   628: ifeq +11 -> 639
    //   631: getstatic 1697	com/whatsapp/gdrive/at$d:d	Lcom/whatsapp/gdrive/at$d;
    //   634: astore 25
    //   636: goto -334 -> 302
    //   639: ldc_w 2672
    //   642: aload 26
    //   644: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   647: ifeq +11 -> 658
    //   650: getstatic 2674	com/whatsapp/gdrive/at$d:e	Lcom/whatsapp/gdrive/at$d;
    //   653: astore 25
    //   655: goto -353 -> 302
    //   658: invokestatic 2676	com/whatsapp/av:i	()Z
    //   661: ifeq +45 -> 706
    //   664: aload_0
    //   665: getfield 429	com/whatsapp/gdrive/GoogleDriveService:r	Lcom/whatsapp/util/a/c;
    //   668: new 573	java/lang/StringBuilder
    //   671: dup
    //   672: ldc_w 2678
    //   675: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   678: aload 26
    //   680: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: ldc_w 2680
    //   686: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   692: iconst_0
    //   693: aconst_null
    //   694: iconst_2
    //   695: invokevirtual 2683	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   698: getstatic 2685	com/whatsapp/gdrive/at$d:f	Lcom/whatsapp/gdrive/at$d;
    //   701: astore 25
    //   703: goto -401 -> 302
    //   706: new 573	java/lang/StringBuilder
    //   709: dup
    //   710: ldc_w 2687
    //   713: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   716: aload 26
    //   718: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: ldc_w 2680
    //   724: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   730: invokestatic 701	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   733: goto -35 -> 698
    //   736: aload 26
    //   738: ldc_w 2637
    //   741: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   744: ifeq +18 -> 762
    //   747: ldc_w 2689
    //   750: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   753: aload_0
    //   754: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   757: iconst_1
    //   758: invokevirtual 2691	com/whatsapp/gdrive/GoogleDriveService$d:c	(Z)V
    //   761: return
    //   762: aload_0
    //   763: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   766: invokevirtual 957	com/whatsapp/atv:aa	()I
    //   769: ifeq +62 -> 831
    //   772: new 573	java/lang/StringBuilder
    //   775: dup
    //   776: ldc_w 2693
    //   779: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   782: aload_1
    //   783: invokevirtual 669	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   786: ldc_w 2695
    //   789: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: aload_0
    //   793: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   796: invokevirtual 957	com/whatsapp/atv:aa	()I
    //   799: invokevirtual 678	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   802: ldc_w 2697
    //   805: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   814: aload_0
    //   815: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   818: iconst_0
    //   819: invokevirtual 2557	com/whatsapp/atv:i	(I)Z
    //   822: pop
    //   823: aload_0
    //   824: getfield 2552	com/whatsapp/gdrive/GoogleDriveService:h	Lcom/whatsapp/gdrive/bk;
    //   827: invokevirtual 2555	com/whatsapp/gdrive/bk:d	()V
    //   830: return
    //   831: new 573	java/lang/StringBuilder
    //   834: dup
    //   835: ldc_w 2693
    //   838: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   841: aload_1
    //   842: invokevirtual 669	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   845: ldc_w 2699
    //   848: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   854: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   857: return
    //   858: aload 26
    //   860: ldc_w 1756
    //   863: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   866: ifeq -374 -> 492
    //   869: iconst_0
    //   870: istore 4
    //   872: goto -380 -> 492
    //   875: aload 26
    //   877: ldc_w 2425
    //   880: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   883: ifeq -391 -> 492
    //   886: iconst_1
    //   887: istore 4
    //   889: goto -397 -> 492
    //   892: aload 26
    //   894: ldc_w 1732
    //   897: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   900: ifeq -408 -> 492
    //   903: iconst_2
    //   904: istore 4
    //   906: goto -414 -> 492
    //   909: aload 26
    //   911: ldc_w 2637
    //   914: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   917: ifeq -425 -> 492
    //   920: iconst_3
    //   921: istore 4
    //   923: goto -431 -> 492
    //   926: aload 26
    //   928: ldc_w 2668
    //   931: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   934: ifeq -442 -> 492
    //   937: iconst_4
    //   938: istore 4
    //   940: goto -448 -> 492
    //   943: aload 26
    //   945: ldc_w 2656
    //   948: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   951: ifeq -459 -> 492
    //   954: iconst_5
    //   955: istore 4
    //   957: goto -465 -> 492
    //   960: aload 26
    //   962: ldc_w 2672
    //   965: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   968: ifeq -476 -> 492
    //   971: bipush 6
    //   973: istore 4
    //   975: goto -483 -> 492
    //   978: aload 26
    //   980: ldc_w 2701
    //   983: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   986: ifeq -494 -> 492
    //   989: bipush 7
    //   991: istore 4
    //   993: goto -501 -> 492
    //   996: aload_1
    //   997: ldc_w 1758
    //   1000: iconst_0
    //   1001: invokevirtual 2705	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1004: istore 6
    //   1006: ldc_w 2707
    //   1009: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1012: invokestatic 1787	java/lang/System:currentTimeMillis	()J
    //   1015: aload_0
    //   1016: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   1019: aload_0
    //   1020: getfield 1693	com/whatsapp/gdrive/GoogleDriveService:af	Ljava/lang/String;
    //   1023: invokevirtual 2710	com/whatsapp/atv:e	(Ljava/lang/String;)J
    //   1026: lsub
    //   1027: ldc2_w 2711
    //   1030: lcmp
    //   1031: ifle +46 -> 1077
    //   1034: iconst_1
    //   1035: istore 4
    //   1037: iload 6
    //   1039: ifeq +13 -> 1052
    //   1042: aload_0
    //   1043: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   1046: invokestatic 1754	com/whatsapp/gdrive/ch:a	(Lcom/whatsapp/atv;)Z
    //   1049: ifeq +34 -> 1083
    //   1052: iload 5
    //   1054: ifne +8 -> 1062
    //   1057: iload 4
    //   1059: ifeq +24 -> 1083
    //   1062: iconst_1
    //   1063: istore 4
    //   1065: iload 4
    //   1067: ifne +22 -> 1089
    //   1070: ldc_w 2714
    //   1073: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1076: return
    //   1077: iconst_0
    //   1078: istore 4
    //   1080: goto -43 -> 1037
    //   1083: iconst_0
    //   1084: istore 4
    //   1086: goto -21 -> 1065
    //   1089: aload_0
    //   1090: getfield 457	com/whatsapp/gdrive/GoogleDriveService:as	Lcom/whatsapp/registration/x;
    //   1093: getfield 2716	com/whatsapp/registration/x:a	Z
    //   1096: ifeq +10 -> 1106
    //   1099: ldc_w 2718
    //   1102: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1105: return
    //   1106: aload_0
    //   1107: getfield 506	com/whatsapp/gdrive/GoogleDriveService:az	Lcom/whatsapp/atu;
    //   1110: invokevirtual 1146	com/whatsapp/atu:b	()Z
    //   1113: ifne +16 -> 1129
    //   1116: ldc_w 2720
    //   1119: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1122: aload_0
    //   1123: bipush 23
    //   1125: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   1128: return
    //   1129: aload_0
    //   1130: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   1133: invokestatic 1725	com/whatsapp/gdrive/ch:c	(Lcom/whatsapp/atv;)Z
    //   1136: ifeq +10 -> 1146
    //   1139: ldc_w 2722
    //   1142: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1145: return
    //   1146: getstatic 346	com/whatsapp/gdrive/GoogleDriveService:T	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1149: iconst_1
    //   1150: invokevirtual 2725	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   1153: ifeq +10 -> 1163
    //   1156: ldc_w 2727
    //   1159: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1162: return
    //   1163: aload_0
    //   1164: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   1167: invokevirtual 2434	com/whatsapp/atv:Q	()I
    //   1170: bipush 10
    //   1172: if_icmpeq +9 -> 1181
    //   1175: aload_0
    //   1176: bipush 10
    //   1178: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   1181: aload_0
    //   1182: getfield 546	com/whatsapp/gdrive/GoogleDriveService:an	Landroid/net/wifi/WifiManager$WifiLock;
    //   1185: ifnonnull +21 -> 1206
    //   1188: aload_0
    //   1189: getfield 478	com/whatsapp/gdrive/GoogleDriveService:av	Lcom/whatsapp/and;
    //   1192: getfield 2730	com/whatsapp/and:d	Landroid/net/wifi/WifiManager;
    //   1195: astore_1
    //   1196: aload_1
    //   1197: ifnonnull +407 -> 1604
    //   1200: ldc_w 2732
    //   1203: invokestatic 701	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1206: aload_0
    //   1207: getfield 546	com/whatsapp/gdrive/GoogleDriveService:an	Landroid/net/wifi/WifiManager$WifiLock;
    //   1210: ifnull +10 -> 1220
    //   1213: aload_0
    //   1214: getfield 546	com/whatsapp/gdrive/GoogleDriveService:an	Landroid/net/wifi/WifiManager$WifiLock;
    //   1217: invokevirtual 972	android/net/wifi/WifiManager$WifiLock:acquire	()V
    //   1220: aload_0
    //   1221: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   1224: invokevirtual 2734	com/whatsapp/gdrive/GoogleDriveService$d:b	()V
    //   1227: aload_0
    //   1228: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   1231: iconst_1
    //   1232: invokevirtual 2557	com/whatsapp/atv:i	(I)Z
    //   1235: pop
    //   1236: invokestatic 1425	b/a/a/c:a	()Lb/a/a/c;
    //   1239: ldc_w 1427
    //   1242: invokevirtual 1430	b/a/a/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   1245: checkcast 1427	com/whatsapp/g/d
    //   1248: astore_1
    //   1249: iload 5
    //   1251: ifeq +376 -> 1627
    //   1254: aload_1
    //   1255: ifnull +372 -> 1627
    //   1258: aload_1
    //   1259: invokevirtual 1444	com/whatsapp/g/d:c	()Z
    //   1262: ifne +365 -> 1627
    //   1265: iconst_1
    //   1266: istore 5
    //   1268: iload 5
    //   1270: putstatic 339	com/whatsapp/gdrive/GoogleDriveService:Q	Z
    //   1273: aload_1
    //   1274: invokestatic 832	com/whatsapp/gdrive/GoogleDriveService:b	(Lcom/whatsapp/g/d;)V
    //   1277: new 573	java/lang/StringBuilder
    //   1280: dup
    //   1281: ldc_w 2736
    //   1284: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1287: getstatic 337	com/whatsapp/gdrive/GoogleDriveService:P	Z
    //   1290: invokevirtual 1451	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1293: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1296: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1299: aload_0
    //   1300: new 1895	com/whatsapp/fieldstats/events/k
    //   1303: dup
    //   1304: invokespecial 2737	com/whatsapp/fieldstats/events/k:<init>	()V
    //   1307: putfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   1310: aload_0
    //   1311: new 2110	com/whatsapp/gdrive/ex
    //   1314: dup
    //   1315: invokespecial 2738	com/whatsapp/gdrive/ex:<init>	()V
    //   1318: putfield 2108	com/whatsapp/gdrive/GoogleDriveService:al	Lcom/whatsapp/gdrive/ex;
    //   1321: aload_0
    //   1322: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   1325: ldc2_w 660
    //   1328: invokestatic 1253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1331: putfield 2298	com/whatsapp/fieldstats/events/k:p	Ljava/lang/Long;
    //   1334: aload_0
    //   1335: getfield 566	com/whatsapp/gdrive/GoogleDriveService:k	Lcom/whatsapp/gdrive/at;
    //   1338: aload_0
    //   1339: getfield 2108	com/whatsapp/gdrive/GoogleDriveService:al	Lcom/whatsapp/gdrive/ex;
    //   1342: invokevirtual 2741	com/whatsapp/gdrive/at:a	(Lcom/whatsapp/gdrive/ex;)V
    //   1345: aload_0
    //   1346: getfield 399	com/whatsapp/gdrive/GoogleDriveService:ad	Ljava/util/concurrent/atomic/AtomicLong;
    //   1349: lconst_0
    //   1350: invokevirtual 1329	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   1353: aload_0
    //   1354: getfield 397	com/whatsapp/gdrive/GoogleDriveService:ac	Ljava/util/concurrent/atomic/AtomicInteger;
    //   1357: iconst_0
    //   1358: invokevirtual 2743	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   1361: iconst_0
    //   1362: istore 8
    //   1364: iconst_0
    //   1365: istore 5
    //   1367: iload 5
    //   1369: istore 6
    //   1371: iload 8
    //   1373: istore 7
    //   1375: aload_0
    //   1376: getfield 566	com/whatsapp/gdrive/GoogleDriveService:k	Lcom/whatsapp/gdrive/at;
    //   1379: aload_0
    //   1380: getfield 409	com/whatsapp/gdrive/GoogleDriveService:p	Lcom/whatsapp/gdrive/ev;
    //   1383: bipush 14
    //   1385: invokestatic 902	com/whatsapp/gdrive/GoogleDriveService:a	(Lcom/whatsapp/gdrive/at;Lcom/whatsapp/gdrive/ev;I)Z
    //   1388: ifeq +245 -> 1633
    //   1391: iload 5
    //   1393: istore 6
    //   1395: iload 8
    //   1397: istore 7
    //   1399: aload_0
    //   1400: invokespecial 2745	com/whatsapp/gdrive/GoogleDriveService:n	()Z
    //   1403: istore 5
    //   1405: iload 5
    //   1407: ifne +34 -> 1441
    //   1410: iload 5
    //   1412: istore 6
    //   1414: iload 5
    //   1416: istore 7
    //   1418: getstatic 346	com/whatsapp/gdrive/GoogleDriveService:T	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1421: invokevirtual 854	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1424: ifeq +17 -> 1441
    //   1427: iload 5
    //   1429: istore 6
    //   1431: iload 5
    //   1433: istore 7
    //   1435: aload_0
    //   1436: bipush 14
    //   1438: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   1441: iload 5
    //   1443: istore 6
    //   1445: iload 5
    //   1447: ifeq +124 -> 1571
    //   1450: iload 5
    //   1452: istore 6
    //   1454: iload 5
    //   1456: istore 7
    //   1458: aload_0
    //   1459: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   1462: iconst_0
    //   1463: invokevirtual 2557	com/whatsapp/atv:i	(I)Z
    //   1466: pop
    //   1467: aload_0
    //   1468: invokespecial 2747	com/whatsapp/gdrive/GoogleDriveService:k	()Z
    //   1471: ifeq +283 -> 1754
    //   1474: new 1274	com/whatsapp/util/bd
    //   1477: dup
    //   1478: ldc_w 2244
    //   1481: invokespecial 1277	com/whatsapp/util/bd:<init>	(Ljava/lang/String;)V
    //   1484: astore_1
    //   1485: aload_0
    //   1486: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   1489: invokevirtual 2748	com/whatsapp/gdrive/GoogleDriveService$d:d	()V
    //   1492: aload_0
    //   1493: invokespecial 2750	com/whatsapp/gdrive/GoogleDriveService:v	()Z
    //   1496: istore 6
    //   1498: iload 6
    //   1500: ifeq +27 -> 1527
    //   1503: aload_0
    //   1504: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   1507: aload_0
    //   1508: getfield 1693	com/whatsapp/gdrive/GoogleDriveService:af	Ljava/lang/String;
    //   1511: invokestatic 1787	java/lang/System:currentTimeMillis	()J
    //   1514: ldc2_w 2751
    //   1517: ladd
    //   1518: invokevirtual 1809	com/whatsapp/atv:b	(Ljava/lang/String;J)V
    //   1521: aload_0
    //   1522: bipush 10
    //   1524: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   1527: iload 6
    //   1529: ifne +18 -> 1547
    //   1532: getstatic 346	com/whatsapp/gdrive/GoogleDriveService:T	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1535: invokevirtual 854	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1538: ifeq +9 -> 1547
    //   1541: aload_0
    //   1542: bipush 14
    //   1544: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   1547: aload_1
    //   1548: invokevirtual 1282	com/whatsapp/util/bd:b	()J
    //   1551: pop2
    //   1552: iload 5
    //   1554: istore 6
    //   1556: iload 5
    //   1558: istore 7
    //   1560: getstatic 346	com/whatsapp/gdrive/GoogleDriveService:T	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1563: iconst_0
    //   1564: invokevirtual 1684	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1567: iload 5
    //   1569: istore 6
    //   1571: iload 6
    //   1573: ifeq +926 -> 2499
    //   1576: getstatic 202	com/whatsapp/gdrive/GoogleDriveService:w	Z
    //   1579: ifne +359 -> 1938
    //   1582: aload_0
    //   1583: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   1586: ifnonnull +352 -> 1938
    //   1589: new 768	java/lang/AssertionError
    //   1592: dup
    //   1593: invokespecial 769	java/lang/AssertionError:<init>	()V
    //   1596: athrow
    //   1597: astore_1
    //   1598: aload_0
    //   1599: invokespecial 2625	com/whatsapp/gdrive/GoogleDriveService:A	()V
    //   1602: aload_1
    //   1603: athrow
    //   1604: aload_0
    //   1605: aload_1
    //   1606: iconst_1
    //   1607: ldc_w 2754
    //   1610: invokevirtual 2760	android/net/wifi/WifiManager:createWifiLock	(ILjava/lang/String;)Landroid/net/wifi/WifiManager$WifiLock;
    //   1613: putfield 546	com/whatsapp/gdrive/GoogleDriveService:an	Landroid/net/wifi/WifiManager$WifiLock;
    //   1616: aload_0
    //   1617: getfield 546	com/whatsapp/gdrive/GoogleDriveService:an	Landroid/net/wifi/WifiManager$WifiLock;
    //   1620: iconst_0
    //   1621: invokevirtual 2763	android/net/wifi/WifiManager$WifiLock:setReferenceCounted	(Z)V
    //   1624: goto -418 -> 1206
    //   1627: iconst_0
    //   1628: istore 5
    //   1630: goto -362 -> 1268
    //   1633: iload 5
    //   1635: istore 6
    //   1637: iload 8
    //   1639: istore 7
    //   1641: ldc_w 2765
    //   1644: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1647: iload 5
    //   1649: istore 6
    //   1651: iload 8
    //   1653: istore 7
    //   1655: aload_0
    //   1656: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   1659: iconst_2
    //   1660: invokestatic 1526	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1663: putfield 2767	com/whatsapp/fieldstats/events/k:g	Ljava/lang/Integer;
    //   1666: iconst_0
    //   1667: istore 5
    //   1669: goto -264 -> 1405
    //   1672: astore 25
    //   1674: aload_1
    //   1675: invokevirtual 1282	com/whatsapp/util/bd:b	()J
    //   1678: pop2
    //   1679: aload 25
    //   1681: athrow
    //   1682: astore_1
    //   1683: iload 5
    //   1685: istore 6
    //   1687: iload 5
    //   1689: istore 7
    //   1691: getstatic 346	com/whatsapp/gdrive/GoogleDriveService:T	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1694: iconst_0
    //   1695: invokevirtual 1684	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   1698: iload 5
    //   1700: istore 6
    //   1702: iload 5
    //   1704: istore 7
    //   1706: aload_1
    //   1707: athrow
    //   1708: astore_1
    //   1709: ldc_w 2769
    //   1712: aload_1
    //   1713: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1716: aload_1
    //   1717: instanceof 1117
    //   1720: ifeq +59 -> 1779
    //   1723: aload_1
    //   1724: invokevirtual 2773	com/whatsapp/gdrive/ba:getCause	()Ljava/lang/Throwable;
    //   1727: astore_1
    //   1728: aload_1
    //   1729: ifnull +34 -> 1763
    //   1732: aload_1
    //   1733: instanceof 2775
    //   1736: ifeq +27 -> 1763
    //   1739: ldc_w 2777
    //   1742: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   1745: aload_0
    //   1746: bipush 21
    //   1748: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   1751: goto -180 -> 1571
    //   1754: aload_0
    //   1755: bipush 10
    //   1757: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   1760: goto -208 -> 1552
    //   1763: ldc_w 2779
    //   1766: aload_1
    //   1767: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1770: aload_0
    //   1771: bipush 11
    //   1773: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   1776: goto -205 -> 1571
    //   1779: aload_1
    //   1780: instanceof 1115
    //   1783: ifeq +12 -> 1795
    //   1786: aload_0
    //   1787: bipush 12
    //   1789: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   1792: goto -221 -> 1571
    //   1795: aload_1
    //   1796: instanceof 771
    //   1799: ifeq +12 -> 1811
    //   1802: aload_0
    //   1803: bipush 18
    //   1805: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   1808: goto -237 -> 1571
    //   1811: aload_1
    //   1812: instanceof 1352
    //   1815: ifeq +12 -> 1827
    //   1818: aload_0
    //   1819: bipush 15
    //   1821: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   1824: goto -253 -> 1571
    //   1827: aload_1
    //   1828: instanceof 1119
    //   1831: ifeq +12 -> 1843
    //   1834: aload_0
    //   1835: bipush 19
    //   1837: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   1840: goto -269 -> 1571
    //   1843: aload_1
    //   1844: instanceof 1023
    //   1847: ifeq +12 -> 1859
    //   1850: aload_0
    //   1851: bipush 13
    //   1853: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   1856: goto -285 -> 1571
    //   1859: aload_1
    //   1860: instanceof 1961
    //   1863: ifeq +12 -> 1875
    //   1866: aload_0
    //   1867: bipush 16
    //   1869: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   1872: goto -301 -> 1571
    //   1875: aload_1
    //   1876: instanceof 2119
    //   1879: ifeq +12 -> 1891
    //   1882: aload_0
    //   1883: bipush 22
    //   1885: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   1888: goto -317 -> 1571
    //   1891: aload_1
    //   1892: instanceof 559
    //   1895: ifeq +12 -> 1907
    //   1898: aload_0
    //   1899: bipush 23
    //   1901: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   1904: goto -333 -> 1571
    //   1907: ldc_w 2781
    //   1910: aload_1
    //   1911: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1914: goto -343 -> 1571
    //   1917: astore_1
    //   1918: ldc_w 2783
    //   1921: aload_1
    //   1922: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1925: aload_0
    //   1926: bipush 20
    //   1928: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   1931: iload 7
    //   1933: istore 6
    //   1935: goto -364 -> 1571
    //   1938: aload_0
    //   1939: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   1942: aload_0
    //   1943: getfield 1198	com/whatsapp/gdrive/GoogleDriveService:j	Lcom/whatsapp/gdrive/bc;
    //   1946: invokevirtual 2406	com/whatsapp/gdrive/bc:c	()J
    //   1949: l2d
    //   1950: invokestatic 1321	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1953: putfield 2785	com/whatsapp/fieldstats/events/k:j	Ljava/lang/Double;
    //   1956: aload_0
    //   1957: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   1960: aload_0
    //   1961: getfield 1198	com/whatsapp/gdrive/GoogleDriveService:j	Lcom/whatsapp/gdrive/bc;
    //   1964: invokevirtual 2787	com/whatsapp/gdrive/bc:d	()J
    //   1967: l2d
    //   1968: invokestatic 1321	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1971: putfield 2789	com/whatsapp/fieldstats/events/k:k	Ljava/lang/Double;
    //   1974: aload_0
    //   1975: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   1978: aload_0
    //   1979: getfield 1198	com/whatsapp/gdrive/GoogleDriveService:j	Lcom/whatsapp/gdrive/bc;
    //   1982: invokevirtual 944	com/whatsapp/gdrive/bc:b	()J
    //   1985: l2d
    //   1986: invokestatic 1321	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   1989: putfield 2791	com/whatsapp/fieldstats/events/k:i	Ljava/lang/Double;
    //   1992: aload_0
    //   1993: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   1996: astore_1
    //   1997: aload_0
    //   1998: getfield 1198	com/whatsapp/gdrive/GoogleDriveService:j	Lcom/whatsapp/gdrive/bc;
    //   2001: astore 25
    //   2003: aload 25
    //   2005: getfield 2460	com/whatsapp/gdrive/bc:c	Lorg/json/JSONObject;
    //   2008: ifnull +372 -> 2380
    //   2011: aload 25
    //   2013: getfield 2460	com/whatsapp/gdrive/bc:c	Lorg/json/JSONObject;
    //   2016: ldc_w 2793
    //   2019: iconst_m1
    //   2020: invokevirtual 2464	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   2023: istore 4
    //   2025: aload_1
    //   2026: iload 4
    //   2028: i2d
    //   2029: invokestatic 1321	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   2032: putfield 2795	com/whatsapp/fieldstats/events/k:n	Ljava/lang/Double;
    //   2035: aload_0
    //   2036: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2039: iconst_1
    //   2040: invokestatic 1526	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2043: putfield 2409	com/whatsapp/fieldstats/events/k:a	Ljava/lang/Integer;
    //   2046: aload_0
    //   2047: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2050: aload_0
    //   2051: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   2054: invokevirtual 2797	com/whatsapp/atv:Y	()I
    //   2057: i2l
    //   2058: invokestatic 1253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2061: putfield 2799	com/whatsapp/fieldstats/events/k:d	Ljava/lang/Long;
    //   2064: aload_0
    //   2065: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2068: aload_0
    //   2069: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   2072: invokevirtual 1081	com/whatsapp/atv:ae	()Z
    //   2075: invokestatic 1984	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2078: putfield 2801	com/whatsapp/fieldstats/events/k:e	Ljava/lang/Boolean;
    //   2081: aload_0
    //   2082: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2085: astore_1
    //   2086: getstatic 1246	com/whatsapp/gdrive/GoogleDriveService:O	I
    //   2089: iconst_1
    //   2090: if_icmpne +3478 -> 5568
    //   2093: lconst_1
    //   2094: lstore 23
    //   2096: aload_1
    //   2097: lload 23
    //   2099: invokestatic 1253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2102: putfield 2803	com/whatsapp/fieldstats/events/k:f	Ljava/lang/Long;
    //   2105: aload_0
    //   2106: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2109: getfield 2767	com/whatsapp/fieldstats/events/k:g	Ljava/lang/Integer;
    //   2112: ifnonnull +14 -> 2126
    //   2115: aload_0
    //   2116: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2119: iconst_1
    //   2120: invokestatic 1526	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2123: putfield 2767	com/whatsapp/fieldstats/events/k:g	Ljava/lang/Integer;
    //   2126: aload_0
    //   2127: getfield 566	com/whatsapp/gdrive/GoogleDriveService:k	Lcom/whatsapp/gdrive/at;
    //   2130: invokevirtual 2805	com/whatsapp/gdrive/at:d	()I
    //   2133: istore 4
    //   2135: new 573	java/lang/StringBuilder
    //   2138: dup
    //   2139: ldc_w 2807
    //   2142: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2145: iload 4
    //   2147: invokevirtual 678	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2150: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2153: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2156: aload_0
    //   2157: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2160: iload 4
    //   2162: i2d
    //   2163: invokestatic 1321	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   2166: putfield 2808	com/whatsapp/fieldstats/events/k:o	Ljava/lang/Double;
    //   2169: aload_0
    //   2170: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   2173: aload_0
    //   2174: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   2177: invokevirtual 2664	com/whatsapp/atv:ac	()Ljava/lang/String;
    //   2180: invokestatic 1787	java/lang/System:currentTimeMillis	()J
    //   2183: invokevirtual 942	com/whatsapp/atv:c	(Ljava/lang/String;J)Z
    //   2186: pop
    //   2187: aload_0
    //   2188: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   2191: aload_0
    //   2192: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   2195: invokevirtual 2664	com/whatsapp/atv:ac	()Ljava/lang/String;
    //   2198: aload_0
    //   2199: getfield 1198	com/whatsapp/gdrive/GoogleDriveService:j	Lcom/whatsapp/gdrive/bc;
    //   2202: invokevirtual 944	com/whatsapp/gdrive/bc:b	()J
    //   2205: invokevirtual 946	com/whatsapp/atv:d	(Ljava/lang/String;J)Z
    //   2208: pop
    //   2209: aload_0
    //   2210: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   2213: aload_0
    //   2214: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   2217: invokevirtual 2664	com/whatsapp/atv:ac	()Ljava/lang/String;
    //   2220: aload_0
    //   2221: getfield 1198	com/whatsapp/gdrive/GoogleDriveService:j	Lcom/whatsapp/gdrive/bc;
    //   2224: invokevirtual 948	com/whatsapp/gdrive/bc:e	()J
    //   2227: invokevirtual 950	com/whatsapp/atv:e	(Ljava/lang/String;J)Z
    //   2230: pop
    //   2231: aload_0
    //   2232: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   2235: invokevirtual 2810	com/whatsapp/atv:Z	()Z
    //   2238: pop
    //   2239: aload_0
    //   2240: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   2243: getfield 862	com/whatsapp/atv:a	Landroid/content/SharedPreferences;
    //   2246: invokeinterface 868 1 0
    //   2251: astore_1
    //   2252: aload_1
    //   2253: ldc_w 1898
    //   2256: invokeinterface 2813 2 0
    //   2261: pop
    //   2262: aload_1
    //   2263: ldc_w 1906
    //   2266: invokeinterface 2813 2 0
    //   2271: pop
    //   2272: aload_1
    //   2273: ldc_w 2815
    //   2276: invokeinterface 2813 2 0
    //   2281: pop
    //   2282: aload_1
    //   2283: invokeinterface 883 1 0
    //   2288: ifne +9 -> 2297
    //   2291: ldc_w 2817
    //   2294: invokestatic 701	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   2297: aload_0
    //   2298: getfield 566	com/whatsapp/gdrive/GoogleDriveService:k	Lcom/whatsapp/gdrive/at;
    //   2301: invokevirtual 2818	com/whatsapp/gdrive/at:c	()Z
    //   2304: pop
    //   2305: aload_0
    //   2306: lconst_0
    //   2307: putfield 976	com/whatsapp/gdrive/GoogleDriveService:aa	J
    //   2310: aload_0
    //   2311: getfield 390	com/whatsapp/gdrive/GoogleDriveService:ab	Ljava/util/concurrent/atomic/AtomicLong;
    //   2314: lconst_0
    //   2315: invokevirtual 1329	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   2318: aload_0
    //   2319: getfield 399	com/whatsapp/gdrive/GoogleDriveService:ad	Ljava/util/concurrent/atomic/AtomicLong;
    //   2322: lconst_0
    //   2323: invokevirtual 1329	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   2326: aload_0
    //   2327: getfield 397	com/whatsapp/gdrive/GoogleDriveService:ac	Ljava/util/concurrent/atomic/AtomicInteger;
    //   2330: iconst_0
    //   2331: invokevirtual 2743	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   2334: iconst_0
    //   2335: putstatic 337	com/whatsapp/gdrive/GoogleDriveService:P	Z
    //   2338: invokestatic 2548	com/whatsapp/gdrive/cs:a	()V
    //   2341: aload_0
    //   2342: getfield 566	com/whatsapp/gdrive/GoogleDriveService:k	Lcom/whatsapp/gdrive/at;
    //   2345: invokevirtual 1379	com/whatsapp/gdrive/at:a	()Z
    //   2348: ifeq +44 -> 2392
    //   2351: aload_0
    //   2352: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   2355: invokevirtual 2819	com/whatsapp/gdrive/GoogleDriveService$d:e	()V
    //   2358: aload_0
    //   2359: aconst_null
    //   2360: putfield 733	com/whatsapp/gdrive/GoogleDriveService:ai	Ljava/util/List;
    //   2363: aload_0
    //   2364: aconst_null
    //   2365: putfield 741	com/whatsapp/gdrive/GoogleDriveService:aj	Ljava/util/List;
    //   2368: getstatic 346	com/whatsapp/gdrive/GoogleDriveService:T	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2371: iconst_0
    //   2372: invokevirtual 1684	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   2375: aload_0
    //   2376: invokespecial 2625	com/whatsapp/gdrive/GoogleDriveService:A	()V
    //   2379: return
    //   2380: ldc_w 2821
    //   2383: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   2386: iconst_m1
    //   2387: istore 4
    //   2389: goto -364 -> 2025
    //   2392: aload_0
    //   2393: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   2396: iconst_1
    //   2397: invokevirtual 2822	com/whatsapp/gdrive/GoogleDriveService$d:a	(Z)V
    //   2400: aload_0
    //   2401: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2404: aload_0
    //   2405: getfield 544	com/whatsapp/gdrive/GoogleDriveService:aA	[Ljava/io/File;
    //   2408: invokestatic 2825	com/whatsapp/gdrive/ch:a	([Ljava/io/File;)J
    //   2411: l2d
    //   2412: invokestatic 1321	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   2415: putfield 2795	com/whatsapp/fieldstats/events/k:n	Ljava/lang/Double;
    //   2418: new 573	java/lang/StringBuilder
    //   2421: dup
    //   2422: ldc_w 2827
    //   2425: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2428: aload_0
    //   2429: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2432: invokestatic 2830	com/whatsapp/gdrive/ch:a	(Lcom/whatsapp/fieldstats/events/k;)Ljava/lang/String;
    //   2435: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2438: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2441: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2444: aload_0
    //   2445: aload_0
    //   2446: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2449: invokestatic 2835	com/whatsapp/fieldstats/l:a	(Landroid/content/Context;Lcom/whatsapp/fieldstats/e;)V
    //   2452: getstatic 202	com/whatsapp/gdrive/GoogleDriveService:w	Z
    //   2455: ifne +18 -> 2473
    //   2458: aload_0
    //   2459: getfield 2108	com/whatsapp/gdrive/GoogleDriveService:al	Lcom/whatsapp/gdrive/ex;
    //   2462: ifnonnull +11 -> 2473
    //   2465: new 768	java/lang/AssertionError
    //   2468: dup
    //   2469: invokespecial 769	java/lang/AssertionError:<init>	()V
    //   2472: athrow
    //   2473: aload_0
    //   2474: getfield 2108	com/whatsapp/gdrive/GoogleDriveService:al	Lcom/whatsapp/gdrive/ex;
    //   2477: aload_0
    //   2478: invokevirtual 2838	com/whatsapp/gdrive/ex:a	(Landroid/content/Context;)V
    //   2481: aload_0
    //   2482: aconst_null
    //   2483: putfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2486: aload_0
    //   2487: aconst_null
    //   2488: putfield 2108	com/whatsapp/gdrive/GoogleDriveService:al	Lcom/whatsapp/gdrive/ex;
    //   2491: aload_0
    //   2492: lconst_0
    //   2493: putfield 1870	com/whatsapp/gdrive/GoogleDriveService:d	J
    //   2496: goto -138 -> 2358
    //   2499: invokestatic 2548	com/whatsapp/gdrive/cs:a	()V
    //   2502: aload_0
    //   2503: getfield 399	com/whatsapp/gdrive/GoogleDriveService:ad	Ljava/util/concurrent/atomic/AtomicLong;
    //   2506: lconst_0
    //   2507: invokevirtual 1329	java/util/concurrent/atomic/AtomicLong:set	(J)V
    //   2510: aload_0
    //   2511: getfield 397	com/whatsapp/gdrive/GoogleDriveService:ac	Ljava/util/concurrent/atomic/AtomicInteger;
    //   2514: iconst_0
    //   2515: invokevirtual 2743	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   2518: aload_0
    //   2519: getfield 566	com/whatsapp/gdrive/GoogleDriveService:k	Lcom/whatsapp/gdrive/at;
    //   2522: invokevirtual 1379	com/whatsapp/gdrive/at:a	()Z
    //   2525: ifeq +22 -> 2547
    //   2528: aload_0
    //   2529: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   2532: iconst_0
    //   2533: invokevirtual 2557	com/whatsapp/atv:i	(I)Z
    //   2536: pop
    //   2537: aload_0
    //   2538: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   2541: invokevirtual 2819	com/whatsapp/gdrive/GoogleDriveService$d:e	()V
    //   2544: goto -186 -> 2358
    //   2547: aload_0
    //   2548: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   2551: iconst_0
    //   2552: invokevirtual 2822	com/whatsapp/gdrive/GoogleDriveService$d:a	(Z)V
    //   2555: aload_0
    //   2556: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   2559: astore_1
    //   2560: aload_1
    //   2561: getfield 862	com/whatsapp/atv:a	Landroid/content/SharedPreferences;
    //   2564: ldc_w 2840
    //   2567: iconst_0
    //   2568: invokeinterface 2843 3 0
    //   2573: iconst_1
    //   2574: iadd
    //   2575: istore 4
    //   2577: new 573	java/lang/StringBuilder
    //   2580: dup
    //   2581: ldc_w 2845
    //   2584: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2587: iload 4
    //   2589: invokevirtual 678	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2592: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2595: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2598: aload_1
    //   2599: getfield 862	com/whatsapp/atv:a	Landroid/content/SharedPreferences;
    //   2602: invokeinterface 868 1 0
    //   2607: astore_1
    //   2608: aload_1
    //   2609: ldc_w 2840
    //   2612: iload 4
    //   2614: invokeinterface 2378 3 0
    //   2619: pop
    //   2620: aload_1
    //   2621: invokeinterface 883 1 0
    //   2626: ifne +9 -> 2635
    //   2629: ldc_w 2847
    //   2632: invokestatic 701	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   2635: aload_0
    //   2636: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   2639: invokevirtual 2797	com/whatsapp/atv:Y	()I
    //   2642: iconst_4
    //   2643: if_icmplt +35 -> 2678
    //   2646: new 573	java/lang/StringBuilder
    //   2649: dup
    //   2650: ldc_w 2827
    //   2653: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2656: aload_0
    //   2657: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   2660: invokevirtual 2797	com/whatsapp/atv:Y	()I
    //   2663: invokevirtual 678	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2666: ldc_w 2849
    //   2669: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2672: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2675: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   2678: getstatic 202	com/whatsapp/gdrive/GoogleDriveService:w	Z
    //   2681: ifne +18 -> 2699
    //   2684: aload_0
    //   2685: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2688: ifnonnull +11 -> 2699
    //   2691: new 768	java/lang/AssertionError
    //   2694: dup
    //   2695: invokespecial 769	java/lang/AssertionError:<init>	()V
    //   2698: athrow
    //   2699: aload_0
    //   2700: getfield 464	com/whatsapp/gdrive/GoogleDriveService:at	Lcom/whatsapp/data/ad;
    //   2703: getfield 1496	com/whatsapp/data/ad:c	Lcom/whatsapp/data/cb;
    //   2706: invokevirtual 2850	com/whatsapp/data/cb:g	()Ljava/io/File;
    //   2709: astore_1
    //   2710: aload_0
    //   2711: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2714: astore 25
    //   2716: aload_1
    //   2717: ifnull +2857 -> 5574
    //   2720: aload_1
    //   2721: invokevirtual 691	java/io/File:length	()J
    //   2724: l2d
    //   2725: dstore_2
    //   2726: aload 25
    //   2728: dload_2
    //   2729: invokestatic 1321	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   2732: putfield 2785	com/whatsapp/fieldstats/events/k:j	Ljava/lang/Double;
    //   2735: aload_0
    //   2736: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2739: aload_0
    //   2740: getfield 976	com/whatsapp/gdrive/GoogleDriveService:aa	J
    //   2743: l2d
    //   2744: aload_0
    //   2745: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2748: getfield 2785	com/whatsapp/fieldstats/events/k:j	Ljava/lang/Double;
    //   2751: invokevirtual 2853	java/lang/Double:doubleValue	()D
    //   2754: dsub
    //   2755: invokestatic 1321	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   2758: putfield 2789	com/whatsapp/fieldstats/events/k:k	Ljava/lang/Double;
    //   2761: aload_0
    //   2762: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2765: aload_0
    //   2766: getfield 1870	com/whatsapp/gdrive/GoogleDriveService:d	J
    //   2769: l2d
    //   2770: invokestatic 1321	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   2773: putfield 2791	com/whatsapp/fieldstats/events/k:i	Ljava/lang/Double;
    //   2776: aload_0
    //   2777: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2780: aload_0
    //   2781: getfield 544	com/whatsapp/gdrive/GoogleDriveService:aA	[Ljava/io/File;
    //   2784: invokestatic 2825	com/whatsapp/gdrive/ch:a	([Ljava/io/File;)J
    //   2787: l2d
    //   2788: invokestatic 1321	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   2791: putfield 2795	com/whatsapp/fieldstats/events/k:n	Ljava/lang/Double;
    //   2794: aload_0
    //   2795: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2798: aload_0
    //   2799: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   2802: invokevirtual 2797	com/whatsapp/atv:Y	()I
    //   2805: i2l
    //   2806: invokestatic 1253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2809: putfield 2799	com/whatsapp/fieldstats/events/k:d	Ljava/lang/Long;
    //   2812: aload_0
    //   2813: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2816: aload_0
    //   2817: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   2820: invokevirtual 1081	com/whatsapp/atv:ae	()Z
    //   2823: invokestatic 1984	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2826: putfield 2801	com/whatsapp/fieldstats/events/k:e	Ljava/lang/Boolean;
    //   2829: aload_0
    //   2830: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2833: astore_1
    //   2834: getstatic 1246	com/whatsapp/gdrive/GoogleDriveService:O	I
    //   2837: iconst_1
    //   2838: if_icmpne +2741 -> 5579
    //   2841: lconst_1
    //   2842: lstore 23
    //   2844: aload_1
    //   2845: lload 23
    //   2847: invokestatic 1253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2850: putfield 2803	com/whatsapp/fieldstats/events/k:f	Ljava/lang/Long;
    //   2853: aload_0
    //   2854: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2857: getfield 2767	com/whatsapp/fieldstats/events/k:g	Ljava/lang/Integer;
    //   2860: ifnonnull +14 -> 2874
    //   2863: aload_0
    //   2864: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2867: iconst_1
    //   2868: invokestatic 1526	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2871: putfield 2767	com/whatsapp/fieldstats/events/k:g	Ljava/lang/Integer;
    //   2874: aload_0
    //   2875: aload_0
    //   2876: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2879: invokestatic 2835	com/whatsapp/fieldstats/l:a	(Landroid/content/Context;Lcom/whatsapp/fieldstats/e;)V
    //   2882: new 573	java/lang/StringBuilder
    //   2885: dup
    //   2886: ldc_w 2827
    //   2889: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2892: aload_0
    //   2893: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2896: invokestatic 2830	com/whatsapp/gdrive/ch:a	(Lcom/whatsapp/fieldstats/events/k;)Ljava/lang/String;
    //   2899: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2902: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2905: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   2908: getstatic 202	com/whatsapp/gdrive/GoogleDriveService:w	Z
    //   2911: ifne +40 -> 2951
    //   2914: aload_0
    //   2915: getfield 2108	com/whatsapp/gdrive/GoogleDriveService:al	Lcom/whatsapp/gdrive/ex;
    //   2918: ifnonnull +33 -> 2951
    //   2921: new 768	java/lang/AssertionError
    //   2924: dup
    //   2925: invokespecial 769	java/lang/AssertionError:<init>	()V
    //   2928: athrow
    //   2929: astore_1
    //   2930: ldc_w 2783
    //   2933: aload_1
    //   2934: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2937: aload_0
    //   2938: getfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2941: dconst_0
    //   2942: invokestatic 1321	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   2945: putfield 2785	com/whatsapp/fieldstats/events/k:j	Ljava/lang/Double;
    //   2948: goto -213 -> 2735
    //   2951: aload_0
    //   2952: getfield 2108	com/whatsapp/gdrive/GoogleDriveService:al	Lcom/whatsapp/gdrive/ex;
    //   2955: aload_0
    //   2956: invokevirtual 2838	com/whatsapp/gdrive/ex:a	(Landroid/content/Context;)V
    //   2959: aload_0
    //   2960: aconst_null
    //   2961: putfield 1893	com/whatsapp/gdrive/GoogleDriveService:ak	Lcom/whatsapp/fieldstats/events/k;
    //   2964: aload_0
    //   2965: aconst_null
    //   2966: putfield 2108	com/whatsapp/gdrive/GoogleDriveService:al	Lcom/whatsapp/gdrive/ex;
    //   2969: aload_0
    //   2970: lconst_0
    //   2971: putfield 1870	com/whatsapp/gdrive/GoogleDriveService:d	J
    //   2974: aload_0
    //   2975: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   2978: iconst_0
    //   2979: invokevirtual 2557	com/whatsapp/atv:i	(I)Z
    //   2982: pop
    //   2983: goto -625 -> 2358
    //   2986: aload_0
    //   2987: getfield 464	com/whatsapp/gdrive/GoogleDriveService:at	Lcom/whatsapp/data/ad;
    //   2990: invokevirtual 2854	com/whatsapp/data/ad:d	()Z
    //   2993: ifeq +18 -> 3011
    //   2996: ldc_w 2856
    //   2999: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3002: aload_0
    //   3003: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   3006: iconst_1
    //   3007: invokevirtual 2858	com/whatsapp/gdrive/GoogleDriveService$d:b	(Z)V
    //   3010: return
    //   3011: getstatic 348	com/whatsapp/gdrive/GoogleDriveService:U	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3014: iconst_1
    //   3015: invokevirtual 2725	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   3018: ifeq +10 -> 3028
    //   3021: ldc_w 2860
    //   3024: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   3027: return
    //   3028: iconst_0
    //   3029: istore 15
    //   3031: iconst_0
    //   3032: istore 16
    //   3034: iconst_0
    //   3035: istore 17
    //   3037: iconst_0
    //   3038: istore 18
    //   3040: iconst_0
    //   3041: istore 19
    //   3043: iconst_0
    //   3044: istore 20
    //   3046: iconst_0
    //   3047: istore 21
    //   3049: iconst_0
    //   3050: istore 22
    //   3052: iconst_0
    //   3053: istore 6
    //   3055: aload_0
    //   3056: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   3059: invokevirtual 2862	com/whatsapp/atv:U	()J
    //   3062: lconst_0
    //   3063: lcmp
    //   3064: ifgt +14 -> 3078
    //   3067: aload_0
    //   3068: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   3071: invokestatic 1787	java/lang/System:currentTimeMillis	()J
    //   3074: invokevirtual 2864	com/whatsapp/atv:j	(J)Z
    //   3077: pop
    //   3078: aload_0
    //   3079: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   3082: invokevirtual 2865	com/whatsapp/gdrive/GoogleDriveService$d:g	()V
    //   3085: aload_0
    //   3086: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   3089: iconst_3
    //   3090: invokevirtual 2557	com/whatsapp/atv:i	(I)Z
    //   3093: pop
    //   3094: iload 6
    //   3096: istore 7
    //   3098: iload 15
    //   3100: istore 8
    //   3102: iload 16
    //   3104: istore 5
    //   3106: iload 17
    //   3108: istore 9
    //   3110: iload 18
    //   3112: istore 10
    //   3114: iload 19
    //   3116: istore 11
    //   3118: iload 20
    //   3120: istore 12
    //   3122: iload 21
    //   3124: istore 13
    //   3126: iload 22
    //   3128: istore 14
    //   3130: aload_0
    //   3131: getfield 566	com/whatsapp/gdrive/GoogleDriveService:k	Lcom/whatsapp/gdrive/at;
    //   3134: aload_0
    //   3135: getfield 415	com/whatsapp/gdrive/GoogleDriveService:ap	Lcom/whatsapp/gdrive/ev;
    //   3138: bipush 14
    //   3140: invokestatic 902	com/whatsapp/gdrive/GoogleDriveService:a	(Lcom/whatsapp/gdrive/at;Lcom/whatsapp/gdrive/ev;I)Z
    //   3143: ifne +87 -> 3230
    //   3146: iload 6
    //   3148: istore 7
    //   3150: iload 15
    //   3152: istore 8
    //   3154: iload 16
    //   3156: istore 5
    //   3158: iload 17
    //   3160: istore 9
    //   3162: iload 18
    //   3164: istore 10
    //   3166: iload 19
    //   3168: istore 11
    //   3170: iload 20
    //   3172: istore 12
    //   3174: iload 21
    //   3176: istore 13
    //   3178: iload 22
    //   3180: istore 14
    //   3182: aload_0
    //   3183: bipush 11
    //   3185: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   3188: aload_0
    //   3189: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   3192: iconst_0
    //   3193: invokevirtual 2858	com/whatsapp/gdrive/GoogleDriveService$d:b	(Z)V
    //   3196: getstatic 348	com/whatsapp/gdrive/GoogleDriveService:U	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3199: iconst_0
    //   3200: invokevirtual 1684	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   3203: new 573	java/lang/StringBuilder
    //   3206: dup
    //   3207: ldc_w 2867
    //   3210: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3213: aload_0
    //   3214: getfield 566	com/whatsapp/gdrive/GoogleDriveService:k	Lcom/whatsapp/gdrive/at;
    //   3217: invokevirtual 2805	com/whatsapp/gdrive/at:d	()I
    //   3220: invokevirtual 678	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3223: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3226: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3229: return
    //   3230: iload 6
    //   3232: istore 7
    //   3234: iload 15
    //   3236: istore 8
    //   3238: iload 16
    //   3240: istore 5
    //   3242: iload 17
    //   3244: istore 9
    //   3246: iload 18
    //   3248: istore 10
    //   3250: iload 19
    //   3252: istore 11
    //   3254: iload 20
    //   3256: istore 12
    //   3258: iload 21
    //   3260: istore 13
    //   3262: iload 22
    //   3264: istore 14
    //   3266: aload_0
    //   3267: invokespecial 2869	com/whatsapp/gdrive/GoogleDriveService:r	()Z
    //   3270: istore 6
    //   3272: iload 6
    //   3274: ifne +147 -> 3421
    //   3277: iload 6
    //   3279: istore 7
    //   3281: iload 6
    //   3283: istore 8
    //   3285: iload 6
    //   3287: istore 5
    //   3289: iload 6
    //   3291: istore 9
    //   3293: iload 6
    //   3295: istore 10
    //   3297: iload 6
    //   3299: istore 11
    //   3301: iload 6
    //   3303: istore 12
    //   3305: iload 6
    //   3307: istore 13
    //   3309: iload 6
    //   3311: istore 14
    //   3313: aload_0
    //   3314: bipush 14
    //   3316: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   3319: aload_0
    //   3320: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   3323: iload 6
    //   3325: invokevirtual 2858	com/whatsapp/gdrive/GoogleDriveService$d:b	(Z)V
    //   3328: getstatic 1517	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   3331: ldc_w 2871
    //   3334: iconst_1
    //   3335: anewarray 1521	java/lang/Object
    //   3338: dup
    //   3339: iconst_0
    //   3340: invokestatic 1787	java/lang/System:currentTimeMillis	()J
    //   3343: aload_0
    //   3344: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   3347: invokevirtual 2862	com/whatsapp/atv:U	()J
    //   3350: lsub
    //   3351: l2d
    //   3352: ldc2_w 1977
    //   3355: ddiv
    //   3356: invokestatic 1321	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   3359: aastore
    //   3360: invokestatic 1530	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3363: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3366: new 573	java/lang/StringBuilder
    //   3369: dup
    //   3370: ldc_w 2873
    //   3373: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3376: iload 6
    //   3378: invokevirtual 1451	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3381: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3384: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3387: getstatic 348	com/whatsapp/gdrive/GoogleDriveService:U	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3390: iconst_0
    //   3391: invokevirtual 1684	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   3394: new 573	java/lang/StringBuilder
    //   3397: dup
    //   3398: ldc_w 2867
    //   3401: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3404: aload_0
    //   3405: getfield 566	com/whatsapp/gdrive/GoogleDriveService:k	Lcom/whatsapp/gdrive/at;
    //   3408: invokevirtual 2805	com/whatsapp/gdrive/at:d	()I
    //   3411: invokevirtual 678	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3414: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3417: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3420: return
    //   3421: iload 6
    //   3423: istore 7
    //   3425: iload 6
    //   3427: istore 8
    //   3429: iload 6
    //   3431: istore 5
    //   3433: iload 6
    //   3435: istore 9
    //   3437: iload 6
    //   3439: istore 10
    //   3441: iload 6
    //   3443: istore 11
    //   3445: iload 6
    //   3447: istore 12
    //   3449: iload 6
    //   3451: istore 13
    //   3453: iload 6
    //   3455: istore 14
    //   3457: aload_0
    //   3458: bipush 10
    //   3460: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   3463: goto -144 -> 3319
    //   3466: astore_1
    //   3467: iload 7
    //   3469: istore 5
    //   3471: aload_0
    //   3472: bipush 12
    //   3474: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   3477: iload 7
    //   3479: istore 5
    //   3481: ldc_w 2875
    //   3484: aload_1
    //   3485: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3488: aload_0
    //   3489: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   3492: iload 7
    //   3494: invokevirtual 2858	com/whatsapp/gdrive/GoogleDriveService$d:b	(Z)V
    //   3497: iload 7
    //   3499: istore 6
    //   3501: goto -173 -> 3328
    //   3504: astore_1
    //   3505: getstatic 348	com/whatsapp/gdrive/GoogleDriveService:U	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3508: iconst_0
    //   3509: invokevirtual 1684	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   3512: new 573	java/lang/StringBuilder
    //   3515: dup
    //   3516: ldc_w 2867
    //   3519: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3522: aload_0
    //   3523: getfield 566	com/whatsapp/gdrive/GoogleDriveService:k	Lcom/whatsapp/gdrive/at;
    //   3526: invokevirtual 2805	com/whatsapp/gdrive/at:d	()I
    //   3529: invokevirtual 678	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3532: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3535: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3538: aload_1
    //   3539: athrow
    //   3540: astore_1
    //   3541: iload 8
    //   3543: istore 5
    //   3545: ldc_w 2875
    //   3548: aload_1
    //   3549: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3552: iload 8
    //   3554: istore 5
    //   3556: aload_1
    //   3557: invokevirtual 2876	com/whatsapp/gdrive/ax:getCause	()Ljava/lang/Throwable;
    //   3560: astore_1
    //   3561: aload_1
    //   3562: ifnonnull +39 -> 3601
    //   3565: iload 8
    //   3567: istore 5
    //   3569: ldc_w 2878
    //   3572: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   3575: iload 8
    //   3577: istore 5
    //   3579: aload_0
    //   3580: bipush 11
    //   3582: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   3585: aload_0
    //   3586: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   3589: iload 8
    //   3591: invokevirtual 2858	com/whatsapp/gdrive/GoogleDriveService$d:b	(Z)V
    //   3594: iload 8
    //   3596: istore 6
    //   3598: goto -270 -> 3328
    //   3601: iload 8
    //   3603: istore 5
    //   3605: aload_1
    //   3606: instanceof 2775
    //   3609: ifeq +28 -> 3637
    //   3612: iload 8
    //   3614: istore 5
    //   3616: aload_0
    //   3617: bipush 21
    //   3619: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   3622: goto -37 -> 3585
    //   3625: astore_1
    //   3626: aload_0
    //   3627: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   3630: iload 5
    //   3632: invokevirtual 2858	com/whatsapp/gdrive/GoogleDriveService$d:b	(Z)V
    //   3635: aload_1
    //   3636: athrow
    //   3637: iload 8
    //   3639: istore 5
    //   3641: aload_0
    //   3642: bipush 11
    //   3644: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   3647: goto -62 -> 3585
    //   3650: astore_1
    //   3651: iload 9
    //   3653: istore 5
    //   3655: aload_0
    //   3656: bipush 18
    //   3658: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   3661: iload 9
    //   3663: istore 5
    //   3665: ldc_w 2875
    //   3668: aload_1
    //   3669: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3672: aload_0
    //   3673: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   3676: iload 9
    //   3678: invokevirtual 2858	com/whatsapp/gdrive/GoogleDriveService$d:b	(Z)V
    //   3681: iload 9
    //   3683: istore 6
    //   3685: goto -357 -> 3328
    //   3688: astore_1
    //   3689: iload 10
    //   3691: istore 5
    //   3693: aload_0
    //   3694: bipush 17
    //   3696: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   3699: iload 10
    //   3701: istore 5
    //   3703: ldc_w 2875
    //   3706: aload_1
    //   3707: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3710: iload 10
    //   3712: istore 5
    //   3714: aload_0
    //   3715: getfield 429	com/whatsapp/gdrive/GoogleDriveService:r	Lcom/whatsapp/util/a/c;
    //   3718: ldc_w 2880
    //   3721: iconst_0
    //   3722: aconst_null
    //   3723: iconst_m1
    //   3724: invokevirtual 2683	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   3727: aload_0
    //   3728: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   3731: iload 10
    //   3733: invokevirtual 2858	com/whatsapp/gdrive/GoogleDriveService$d:b	(Z)V
    //   3736: iload 10
    //   3738: istore 6
    //   3740: goto -412 -> 3328
    //   3743: astore_1
    //   3744: iload 11
    //   3746: istore 5
    //   3748: aload_0
    //   3749: bipush 15
    //   3751: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   3754: iload 11
    //   3756: istore 5
    //   3758: ldc_w 2875
    //   3761: aload_1
    //   3762: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3765: aload_0
    //   3766: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   3769: iload 11
    //   3771: invokevirtual 2858	com/whatsapp/gdrive/GoogleDriveService$d:b	(Z)V
    //   3774: iload 11
    //   3776: istore 6
    //   3778: goto -450 -> 3328
    //   3781: astore_1
    //   3782: iload 12
    //   3784: istore 5
    //   3786: aload_0
    //   3787: bipush 19
    //   3789: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   3792: iload 12
    //   3794: istore 5
    //   3796: ldc_w 2875
    //   3799: aload_1
    //   3800: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3803: aload_0
    //   3804: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   3807: iload 12
    //   3809: invokevirtual 2858	com/whatsapp/gdrive/GoogleDriveService$d:b	(Z)V
    //   3812: iload 12
    //   3814: istore 6
    //   3816: goto -488 -> 3328
    //   3819: astore_1
    //   3820: iload 13
    //   3822: istore 5
    //   3824: aload_0
    //   3825: bipush 23
    //   3827: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   3830: iload 13
    //   3832: istore 5
    //   3834: ldc_w 2875
    //   3837: aload_1
    //   3838: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3841: aload_0
    //   3842: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   3845: iload 13
    //   3847: invokevirtual 2858	com/whatsapp/gdrive/GoogleDriveService$d:b	(Z)V
    //   3850: iload 13
    //   3852: istore 6
    //   3854: goto -526 -> 3328
    //   3857: astore_1
    //   3858: iload 14
    //   3860: istore 5
    //   3862: aload_0
    //   3863: bipush 24
    //   3865: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   3868: iload 14
    //   3870: istore 5
    //   3872: ldc_w 2875
    //   3875: aload_1
    //   3876: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   3879: aload_0
    //   3880: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   3883: iload 14
    //   3885: invokevirtual 2858	com/whatsapp/gdrive/GoogleDriveService$d:b	(Z)V
    //   3888: iload 14
    //   3890: istore 6
    //   3892: goto -564 -> 3328
    //   3895: aload_0
    //   3896: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   3899: invokestatic 1725	com/whatsapp/gdrive/ch:c	(Lcom/whatsapp/atv;)Z
    //   3902: ifne +10 -> 3912
    //   3905: ldc_w 2882
    //   3908: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   3911: return
    //   3912: getstatic 350	com/whatsapp/gdrive/GoogleDriveService:V	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3915: iconst_1
    //   3916: invokevirtual 2725	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   3919: ifeq +10 -> 3929
    //   3922: ldc_w 2884
    //   3925: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   3928: return
    //   3929: aload_0
    //   3930: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   3933: invokevirtual 2434	com/whatsapp/atv:Q	()I
    //   3936: bipush 10
    //   3938: if_icmpeq +9 -> 3947
    //   3941: aload_0
    //   3942: bipush 10
    //   3944: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   3947: aload_0
    //   3948: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   3951: invokevirtual 2886	com/whatsapp/gdrive/GoogleDriveService$d:f	()V
    //   3954: aload_0
    //   3955: new 1255	com/whatsapp/fieldstats/events/bi
    //   3958: dup
    //   3959: invokespecial 2887	com/whatsapp/fieldstats/events/bi:<init>	()V
    //   3962: putfield 1248	com/whatsapp/gdrive/GoogleDriveService:g	Lcom/whatsapp/fieldstats/events/bi;
    //   3965: aload_0
    //   3966: getfield 1248	com/whatsapp/gdrive/GoogleDriveService:g	Lcom/whatsapp/fieldstats/events/bi;
    //   3969: iconst_1
    //   3970: invokestatic 1984	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   3973: putfield 2888	com/whatsapp/fieldstats/events/bi:b	Ljava/lang/Boolean;
    //   3976: aload_0
    //   3977: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   3980: invokevirtual 2862	com/whatsapp/atv:U	()J
    //   3983: lconst_0
    //   3984: lcmp
    //   3985: ifgt +14 -> 3999
    //   3988: aload_0
    //   3989: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   3992: invokestatic 1787	java/lang/System:currentTimeMillis	()J
    //   3995: invokevirtual 2864	com/whatsapp/atv:j	(J)Z
    //   3998: pop
    //   3999: aload_0
    //   4000: getfield 566	com/whatsapp/gdrive/GoogleDriveService:k	Lcom/whatsapp/gdrive/at;
    //   4003: aconst_null
    //   4004: invokevirtual 2741	com/whatsapp/gdrive/at:a	(Lcom/whatsapp/gdrive/ex;)V
    //   4007: aload_0
    //   4008: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   4011: invokestatic 2890	com/whatsapp/gdrive/ch:d	(Lcom/whatsapp/atv;)Z
    //   4014: pop
    //   4015: aload_0
    //   4016: getfield 566	com/whatsapp/gdrive/GoogleDriveService:k	Lcom/whatsapp/gdrive/at;
    //   4019: aload_0
    //   4020: getfield 412	com/whatsapp/gdrive/GoogleDriveService:q	Lcom/whatsapp/gdrive/ev;
    //   4023: bipush 14
    //   4025: invokestatic 902	com/whatsapp/gdrive/GoogleDriveService:a	(Lcom/whatsapp/gdrive/at;Lcom/whatsapp/gdrive/ev;I)Z
    //   4028: ifne +22 -> 4050
    //   4031: aload_0
    //   4032: bipush 11
    //   4034: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   4037: getstatic 350	com/whatsapp/gdrive/GoogleDriveService:V	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4040: iconst_0
    //   4041: invokevirtual 1684	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   4044: aload_0
    //   4045: aconst_null
    //   4046: putfield 1248	com/whatsapp/gdrive/GoogleDriveService:g	Lcom/whatsapp/fieldstats/events/bi;
    //   4049: return
    //   4050: aload_0
    //   4051: getfield 1198	com/whatsapp/gdrive/GoogleDriveService:j	Lcom/whatsapp/gdrive/bc;
    //   4054: ifnonnull +375 -> 4429
    //   4057: aload_0
    //   4058: iconst_0
    //   4059: aload_0
    //   4060: getfield 412	com/whatsapp/gdrive/GoogleDriveService:q	Lcom/whatsapp/gdrive/ev;
    //   4063: invokespecial 1846	com/whatsapp/gdrive/GoogleDriveService:a	(ZLcom/whatsapp/gdrive/ev;)Z
    //   4066: ifne +363 -> 4429
    //   4069: ldc_w 2892
    //   4072: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   4075: iconst_0
    //   4076: istore 5
    //   4078: iload 5
    //   4080: ifeq +436 -> 4516
    //   4083: aload_0
    //   4084: getfield 1248	com/whatsapp/gdrive/GoogleDriveService:g	Lcom/whatsapp/fieldstats/events/bi;
    //   4087: iconst_1
    //   4088: invokestatic 1526	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4091: putfield 2400	com/whatsapp/fieldstats/events/bi:a	Ljava/lang/Integer;
    //   4094: getstatic 1246	com/whatsapp/gdrive/GoogleDriveService:O	I
    //   4097: iconst_1
    //   4098: if_icmpne +459 -> 4557
    //   4101: aload_0
    //   4102: getfield 1248	com/whatsapp/gdrive/GoogleDriveService:g	Lcom/whatsapp/fieldstats/events/bi;
    //   4105: lconst_1
    //   4106: invokestatic 1253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4109: putfield 1258	com/whatsapp/fieldstats/events/bi:c	Ljava/lang/Long;
    //   4112: invokestatic 1787	java/lang/System:currentTimeMillis	()J
    //   4115: lstore 23
    //   4117: aload_0
    //   4118: getfield 1248	com/whatsapp/gdrive/GoogleDriveService:g	Lcom/whatsapp/fieldstats/events/bi;
    //   4121: lload 23
    //   4123: aload_0
    //   4124: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   4127: invokevirtual 2862	com/whatsapp/atv:U	()J
    //   4130: lsub
    //   4131: l2d
    //   4132: invokestatic 1321	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   4135: putfield 2894	com/whatsapp/fieldstats/events/bi:f	Ljava/lang/Double;
    //   4138: aload_0
    //   4139: getfield 1248	com/whatsapp/gdrive/GoogleDriveService:g	Lcom/whatsapp/fieldstats/events/bi;
    //   4142: aload_0
    //   4143: getfield 983	com/whatsapp/gdrive/GoogleDriveService:Z	J
    //   4146: l2d
    //   4147: invokestatic 1321	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   4150: putfield 2895	com/whatsapp/fieldstats/events/bi:j	Ljava/lang/Double;
    //   4153: aload_0
    //   4154: getfield 1248	com/whatsapp/gdrive/GoogleDriveService:g	Lcom/whatsapp/fieldstats/events/bi;
    //   4157: aload_0
    //   4158: getfield 388	com/whatsapp/gdrive/GoogleDriveService:b	Ljava/util/concurrent/atomic/AtomicLong;
    //   4161: invokevirtual 657	java/util/concurrent/atomic/AtomicLong:get	()J
    //   4164: l2d
    //   4165: invokestatic 1321	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   4168: putfield 2896	com/whatsapp/fieldstats/events/bi:k	Ljava/lang/Double;
    //   4171: aload_0
    //   4172: getfield 388	com/whatsapp/gdrive/GoogleDriveService:b	Ljava/util/concurrent/atomic/AtomicLong;
    //   4175: invokevirtual 657	java/util/concurrent/atomic/AtomicLong:get	()J
    //   4178: lconst_0
    //   4179: lcmp
    //   4180: ifle +16 -> 4196
    //   4183: aload_0
    //   4184: getfield 429	com/whatsapp/gdrive/GoogleDriveService:r	Lcom/whatsapp/util/a/c;
    //   4187: ldc_w 2898
    //   4190: iconst_0
    //   4191: aconst_null
    //   4192: iconst_m1
    //   4193: invokevirtual 2683	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
    //   4196: getstatic 1517	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   4199: ldc_w 2900
    //   4202: iconst_1
    //   4203: anewarray 1521	java/lang/Object
    //   4206: dup
    //   4207: iconst_0
    //   4208: lload 23
    //   4210: aload_0
    //   4211: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   4214: invokevirtual 2862	com/whatsapp/atv:U	()J
    //   4217: lsub
    //   4218: l2d
    //   4219: ldc2_w 1977
    //   4222: ddiv
    //   4223: invokestatic 1321	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   4226: aastore
    //   4227: invokestatic 1530	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4230: invokestatic 763	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   4233: aload_0
    //   4234: getfield 1198	com/whatsapp/gdrive/GoogleDriveService:j	Lcom/whatsapp/gdrive/bc;
    //   4237: ifnull +125 -> 4362
    //   4240: aload_0
    //   4241: getfield 1248	com/whatsapp/gdrive/GoogleDriveService:g	Lcom/whatsapp/fieldstats/events/bi;
    //   4244: aload_0
    //   4245: getfield 1198	com/whatsapp/gdrive/GoogleDriveService:j	Lcom/whatsapp/gdrive/bc;
    //   4248: invokevirtual 944	com/whatsapp/gdrive/bc:b	()J
    //   4251: l2d
    //   4252: invokestatic 1321	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   4255: putfield 2902	com/whatsapp/fieldstats/events/bi:g	Ljava/lang/Double;
    //   4258: aload_0
    //   4259: getfield 1248	com/whatsapp/gdrive/GoogleDriveService:g	Lcom/whatsapp/fieldstats/events/bi;
    //   4262: aload_0
    //   4263: getfield 1198	com/whatsapp/gdrive/GoogleDriveService:j	Lcom/whatsapp/gdrive/bc;
    //   4266: invokevirtual 2406	com/whatsapp/gdrive/bc:c	()J
    //   4269: l2d
    //   4270: invokestatic 1321	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   4273: putfield 2903	com/whatsapp/fieldstats/events/bi:h	Ljava/lang/Double;
    //   4276: aload_0
    //   4277: getfield 1248	com/whatsapp/gdrive/GoogleDriveService:g	Lcom/whatsapp/fieldstats/events/bi;
    //   4280: aload_0
    //   4281: getfield 1198	com/whatsapp/gdrive/GoogleDriveService:j	Lcom/whatsapp/gdrive/bc;
    //   4284: invokevirtual 2787	com/whatsapp/gdrive/bc:d	()J
    //   4287: l2d
    //   4288: invokestatic 1321	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   4291: putfield 2904	com/whatsapp/fieldstats/events/bi:i	Ljava/lang/Double;
    //   4294: aload_0
    //   4295: getfield 566	com/whatsapp/gdrive/GoogleDriveService:k	Lcom/whatsapp/gdrive/at;
    //   4298: invokevirtual 2805	com/whatsapp/gdrive/at:d	()I
    //   4301: istore 4
    //   4303: aload_0
    //   4304: getfield 1248	com/whatsapp/gdrive/GoogleDriveService:g	Lcom/whatsapp/fieldstats/events/bi;
    //   4307: iload 4
    //   4309: i2d
    //   4310: invokestatic 1321	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   4313: putfield 2905	com/whatsapp/fieldstats/events/bi:m	Ljava/lang/Double;
    //   4316: aload_0
    //   4317: getfield 1248	com/whatsapp/gdrive/GoogleDriveService:g	Lcom/whatsapp/fieldstats/events/bi;
    //   4320: aload_0
    //   4321: getfield 1198	com/whatsapp/gdrive/GoogleDriveService:j	Lcom/whatsapp/gdrive/bc;
    //   4324: invokevirtual 2466	com/whatsapp/gdrive/bc:f	()Z
    //   4327: invokestatic 1984	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4330: putfield 2906	com/whatsapp/fieldstats/events/bi:e	Ljava/lang/Boolean;
    //   4333: new 573	java/lang/StringBuilder
    //   4336: dup
    //   4337: ldc_w 2908
    //   4340: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4343: iload 4
    //   4345: invokevirtual 678	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4348: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4351: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   4354: aload_0
    //   4355: aload_0
    //   4356: getfield 1248	com/whatsapp/gdrive/GoogleDriveService:g	Lcom/whatsapp/fieldstats/events/bi;
    //   4359: invokestatic 2835	com/whatsapp/fieldstats/l:a	(Landroid/content/Context;Lcom/whatsapp/fieldstats/e;)V
    //   4362: iload 5
    //   4364: ifeq +11 -> 4375
    //   4367: aload_0
    //   4368: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   4371: invokevirtual 2910	com/whatsapp/atv:S	()Z
    //   4374: pop
    //   4375: getstatic 350	com/whatsapp/gdrive/GoogleDriveService:V	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4378: invokevirtual 854	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   4381: ifeq +214 -> 4595
    //   4384: aload_0
    //   4385: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   4388: invokevirtual 2434	com/whatsapp/atv:Q	()I
    //   4391: bipush 10
    //   4393: if_icmpne +23 -> 4416
    //   4396: aload_0
    //   4397: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   4400: iload 5
    //   4402: aload_0
    //   4403: getfield 388	com/whatsapp/gdrive/GoogleDriveService:b	Ljava/util/concurrent/atomic/AtomicLong;
    //   4406: invokevirtual 657	java/util/concurrent/atomic/AtomicLong:get	()J
    //   4409: aload_0
    //   4410: getfield 983	com/whatsapp/gdrive/GoogleDriveService:Z	J
    //   4413: invokevirtual 2913	com/whatsapp/gdrive/GoogleDriveService$d:a	(ZJJ)V
    //   4416: getstatic 350	com/whatsapp/gdrive/GoogleDriveService:V	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4419: iconst_0
    //   4420: invokevirtual 1684	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   4423: aload_0
    //   4424: aconst_null
    //   4425: putfield 1248	com/whatsapp/gdrive/GoogleDriveService:g	Lcom/whatsapp/fieldstats/events/bi;
    //   4428: return
    //   4429: aload_0
    //   4430: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   4433: invokevirtual 2186	com/whatsapp/atv:T	()Z
    //   4436: istore 5
    //   4438: new 602	java/util/HashSet
    //   4441: dup
    //   4442: invokespecial 603	java/util/HashSet:<init>	()V
    //   4445: astore_1
    //   4446: aload_1
    //   4447: aload_0
    //   4448: getfield 443	com/whatsapp/gdrive/GoogleDriveService:s	Lcom/whatsapp/oz;
    //   4451: invokevirtual 2915	com/whatsapp/oz:d	()Ljava/io/File;
    //   4454: invokevirtual 1102	java/io/File:getName	()Ljava/lang/String;
    //   4457: invokeinterface 628 2 0
    //   4462: pop
    //   4463: aload_0
    //   4464: aload_1
    //   4465: iload 5
    //   4467: invokespecial 2917	com/whatsapp/gdrive/GoogleDriveService:a	(Ljava/util/Set;Z)Z
    //   4470: istore 5
    //   4472: aload_0
    //   4473: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   4476: iconst_0
    //   4477: invokevirtual 2557	com/whatsapp/atv:i	(I)Z
    //   4480: pop
    //   4481: goto -403 -> 4078
    //   4484: astore_1
    //   4485: aload_0
    //   4486: bipush 12
    //   4488: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   4491: ldc_w 2919
    //   4494: aload_1
    //   4495: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4498: goto -82 -> 4416
    //   4501: astore_1
    //   4502: getstatic 350	com/whatsapp/gdrive/GoogleDriveService:V	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4505: iconst_0
    //   4506: invokevirtual 1684	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   4509: aload_0
    //   4510: aconst_null
    //   4511: putfield 1248	com/whatsapp/gdrive/GoogleDriveService:g	Lcom/whatsapp/fieldstats/events/bi;
    //   4514: aload_1
    //   4515: athrow
    //   4516: aload_0
    //   4517: bipush 14
    //   4519: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   4522: goto -428 -> 4094
    //   4525: astore_1
    //   4526: ldc_w 2919
    //   4529: aload_1
    //   4530: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4533: aload_1
    //   4534: invokevirtual 2876	com/whatsapp/gdrive/ax:getCause	()Ljava/lang/Throwable;
    //   4537: astore_1
    //   4538: aload_1
    //   4539: ifnonnull +83 -> 4622
    //   4542: ldc_w 2878
    //   4545: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   4548: aload_0
    //   4549: bipush 11
    //   4551: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   4554: goto -138 -> 4416
    //   4557: getstatic 1246	com/whatsapp/gdrive/GoogleDriveService:O	I
    //   4560: iconst_2
    //   4561: if_icmpne -449 -> 4112
    //   4564: aload_0
    //   4565: getfield 1248	com/whatsapp/gdrive/GoogleDriveService:g	Lcom/whatsapp/fieldstats/events/bi;
    //   4568: lconst_0
    //   4569: invokestatic 1253	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   4572: putfield 1258	com/whatsapp/fieldstats/events/bi:c	Ljava/lang/Long;
    //   4575: goto -463 -> 4112
    //   4578: astore_1
    //   4579: aload_0
    //   4580: bipush 18
    //   4582: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   4585: ldc_w 2919
    //   4588: aload_1
    //   4589: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4592: goto -176 -> 4416
    //   4595: aload_0
    //   4596: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   4599: invokevirtual 2573	com/whatsapp/gdrive/GoogleDriveService$d:c	()V
    //   4602: goto -186 -> 4416
    //   4605: astore_1
    //   4606: aload_0
    //   4607: bipush 15
    //   4609: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   4612: ldc_w 2919
    //   4615: aload_1
    //   4616: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4619: goto -203 -> 4416
    //   4622: aload_1
    //   4623: instanceof 2775
    //   4626: ifeq -78 -> 4548
    //   4629: aload_0
    //   4630: bipush 21
    //   4632: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   4635: goto -219 -> 4416
    //   4638: astore_1
    //   4639: aload_0
    //   4640: bipush 19
    //   4642: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   4645: ldc_w 2919
    //   4648: aload_1
    //   4649: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4652: goto -236 -> 4416
    //   4655: astore_1
    //   4656: aload_0
    //   4657: bipush 23
    //   4659: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   4662: ldc_w 2919
    //   4665: aload_1
    //   4666: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4669: goto -253 -> 4416
    //   4672: aload_0
    //   4673: getfield 379	com/whatsapp/gdrive/GoogleDriveService:X	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4676: iconst_1
    //   4677: invokevirtual 2725	java/util/concurrent/atomic/AtomicBoolean:getAndSet	(Z)Z
    //   4680: ifeq +10 -> 4690
    //   4683: ldc_w 2921
    //   4686: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   4689: return
    //   4690: iconst_0
    //   4691: istore 10
    //   4693: iconst_0
    //   4694: istore 11
    //   4696: iconst_0
    //   4697: istore 12
    //   4699: iconst_0
    //   4700: istore 13
    //   4702: iconst_0
    //   4703: istore 9
    //   4705: iload 10
    //   4707: istore 6
    //   4709: iload 11
    //   4711: istore 7
    //   4713: iload 12
    //   4715: istore 8
    //   4717: iload 13
    //   4719: istore 5
    //   4721: aload_1
    //   4722: ldc_w 2923
    //   4725: invokevirtual 2650	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   4728: astore_1
    //   4729: aload_1
    //   4730: ifnonnull +105 -> 4835
    //   4733: iload 10
    //   4735: istore 6
    //   4737: iload 11
    //   4739: istore 7
    //   4741: iload 12
    //   4743: istore 8
    //   4745: iload 13
    //   4747: istore 5
    //   4749: ldc_w 2925
    //   4752: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   4755: iload 9
    //   4757: istore 5
    //   4759: aload_0
    //   4760: getfield 379	com/whatsapp/gdrive/GoogleDriveService:X	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4763: iconst_0
    //   4764: invokevirtual 1684	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   4767: aload_0
    //   4768: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   4771: iload 5
    //   4773: invokevirtual 2691	com/whatsapp/gdrive/GoogleDriveService$d:c	(Z)V
    //   4776: iload 5
    //   4778: istore 6
    //   4780: aload_0
    //   4781: getfield 422	com/whatsapp/gdrive/GoogleDriveService:aq	Lcom/whatsapp/pv;
    //   4784: astore 25
    //   4786: new 573	java/lang/StringBuilder
    //   4789: dup
    //   4790: ldc_w 2927
    //   4793: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4796: aload_0
    //   4797: getfield 1693	com/whatsapp/gdrive/GoogleDriveService:af	Ljava/lang/String;
    //   4800: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4803: ldc_w 1336
    //   4806: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4809: astore 26
    //   4811: iload 6
    //   4813: ifeq +270 -> 5083
    //   4816: ldc_w 2929
    //   4819: astore_1
    //   4820: aload 25
    //   4822: aload 26
    //   4824: aload_1
    //   4825: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4828: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4831: invokevirtual 2931	com/whatsapp/pv:a	(Ljava/lang/String;)V
    //   4834: return
    //   4835: iload 10
    //   4837: istore 6
    //   4839: iload 11
    //   4841: istore 7
    //   4843: iload 12
    //   4845: istore 8
    //   4847: iload 13
    //   4849: istore 5
    //   4851: aload_0
    //   4852: aload_1
    //   4853: invokespecial 2933	com/whatsapp/gdrive/GoogleDriveService:f	(Ljava/lang/String;)Z
    //   4856: istore 9
    //   4858: iload 9
    //   4860: istore 5
    //   4862: iload 5
    //   4864: istore 6
    //   4866: iload 5
    //   4868: istore 7
    //   4870: iload 5
    //   4872: istore 8
    //   4874: new 573	java/lang/StringBuilder
    //   4877: dup
    //   4878: ldc_w 2935
    //   4881: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   4884: astore 25
    //   4886: iload 5
    //   4888: ifeq +76 -> 4964
    //   4891: ldc_w 2929
    //   4894: astore_1
    //   4895: iload 5
    //   4897: istore 6
    //   4899: iload 5
    //   4901: istore 7
    //   4903: iload 5
    //   4905: istore 8
    //   4907: aload 25
    //   4909: aload_1
    //   4910: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4913: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4916: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   4919: goto -160 -> 4759
    //   4922: astore_1
    //   4923: iload 6
    //   4925: istore 5
    //   4927: aload_0
    //   4928: bipush 12
    //   4930: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   4933: iload 6
    //   4935: istore 5
    //   4937: ldc_w 2937
    //   4940: aload_1
    //   4941: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4944: aload_0
    //   4945: getfield 379	com/whatsapp/gdrive/GoogleDriveService:X	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4948: iconst_0
    //   4949: invokevirtual 1684	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   4952: aload_0
    //   4953: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   4956: iload 6
    //   4958: invokevirtual 2691	com/whatsapp/gdrive/GoogleDriveService$d:c	(Z)V
    //   4961: goto -181 -> 4780
    //   4964: ldc_w 2939
    //   4967: astore_1
    //   4968: goto -73 -> 4895
    //   4971: astore_1
    //   4972: iload 7
    //   4974: istore 5
    //   4976: aload_0
    //   4977: bipush 11
    //   4979: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   4982: iload 7
    //   4984: istore 5
    //   4986: ldc_w 2937
    //   4989: aload_1
    //   4990: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   4993: aload_0
    //   4994: getfield 379	com/whatsapp/gdrive/GoogleDriveService:X	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4997: iconst_0
    //   4998: invokevirtual 1684	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   5001: aload_0
    //   5002: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   5005: iload 7
    //   5007: invokevirtual 2691	com/whatsapp/gdrive/GoogleDriveService$d:c	(Z)V
    //   5010: iload 7
    //   5012: istore 6
    //   5014: goto -234 -> 4780
    //   5017: astore_1
    //   5018: iload 8
    //   5020: istore 5
    //   5022: aload_0
    //   5023: bipush 19
    //   5025: invokevirtual 1123	com/whatsapp/gdrive/GoogleDriveService:a	(I)V
    //   5028: iload 8
    //   5030: istore 5
    //   5032: ldc_w 2937
    //   5035: aload_1
    //   5036: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5039: aload_0
    //   5040: getfield 379	com/whatsapp/gdrive/GoogleDriveService:X	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   5043: iconst_0
    //   5044: invokevirtual 1684	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   5047: aload_0
    //   5048: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   5051: iload 8
    //   5053: invokevirtual 2691	com/whatsapp/gdrive/GoogleDriveService$d:c	(Z)V
    //   5056: iload 8
    //   5058: istore 6
    //   5060: goto -280 -> 4780
    //   5063: astore_1
    //   5064: aload_0
    //   5065: getfield 379	com/whatsapp/gdrive/GoogleDriveService:X	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   5068: iconst_0
    //   5069: invokevirtual 1684	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   5072: aload_0
    //   5073: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   5076: iload 5
    //   5078: invokevirtual 2691	com/whatsapp/gdrive/GoogleDriveService$d:c	(Z)V
    //   5081: aload_1
    //   5082: athrow
    //   5083: ldc_w 2939
    //   5086: astore_1
    //   5087: goto -267 -> 4820
    //   5090: aload_1
    //   5091: ldc_w 2941
    //   5094: invokevirtual 2650	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   5097: astore 25
    //   5099: aload_1
    //   5100: ldc_w 2943
    //   5103: invokevirtual 2650	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   5106: astore_1
    //   5107: aload 25
    //   5109: ifnonnull +10 -> 5119
    //   5112: ldc_w 2945
    //   5115: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   5118: return
    //   5119: aload_1
    //   5120: ifnonnull +9 -> 5129
    //   5123: ldc_w 2947
    //   5126: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   5129: new 573	java/lang/StringBuilder
    //   5132: dup
    //   5133: ldc_w 2949
    //   5136: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5139: aload 25
    //   5141: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5144: ldc_w 2951
    //   5147: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5150: aload_1
    //   5151: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5154: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5157: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   5160: aload_0
    //   5161: aload 25
    //   5163: aload_1
    //   5164: invokespecial 2953	com/whatsapp/gdrive/GoogleDriveService:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   5167: ifeq +41 -> 5208
    //   5170: new 573	java/lang/StringBuilder
    //   5173: dup
    //   5174: ldc_w 2955
    //   5177: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5180: aload 25
    //   5182: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5185: ldc_w 2951
    //   5188: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5191: aload_1
    //   5192: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5195: ldc_w 2957
    //   5198: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5201: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5204: invokestatic 591	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   5207: return
    //   5208: new 573	java/lang/StringBuilder
    //   5211: dup
    //   5212: ldc_w 2955
    //   5215: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5218: aload 25
    //   5220: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5223: ldc_w 2951
    //   5226: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5229: aload_1
    //   5230: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5233: ldc_w 2959
    //   5236: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5239: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5242: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   5245: return
    //   5246: aload_1
    //   5247: invokevirtual 2963	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   5250: ldc_w 2654
    //   5253: invokevirtual 2965	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   5256: astore_1
    //   5257: aload_1
    //   5258: ifnonnull +31 -> 5289
    //   5261: new 573	java/lang/StringBuilder
    //   5264: dup
    //   5265: ldc_w 2967
    //   5268: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5271: aload 26
    //   5273: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5276: ldc_w 2969
    //   5279: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5282: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5285: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   5288: return
    //   5289: aload_0
    //   5290: aload_0
    //   5291: aload_1
    //   5292: invokespecial 2971	com/whatsapp/gdrive/GoogleDriveService:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   5295: istore 5
    //   5297: iload 5
    //   5299: ifeq -5287 -> 12
    //   5302: aload_0
    //   5303: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   5306: invokevirtual 2973	com/whatsapp/gdrive/GoogleDriveService$d:h	()V
    //   5309: return
    //   5310: astore_1
    //   5311: new 573	java/lang/StringBuilder
    //   5314: dup
    //   5315: ldc_w 2975
    //   5318: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5321: aload 26
    //   5323: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5326: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5329: aload_1
    //   5330: invokestatic 685	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   5333: iconst_0
    //   5334: istore 5
    //   5336: goto -39 -> 5297
    //   5339: aload_1
    //   5340: invokevirtual 2963	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   5343: ldc_w 2654
    //   5346: invokevirtual 2965	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   5349: astore 25
    //   5351: aload 25
    //   5353: ifnonnull +31 -> 5384
    //   5356: new 573	java/lang/StringBuilder
    //   5359: dup
    //   5360: ldc_w 2967
    //   5363: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5366: aload 26
    //   5368: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5371: ldc_w 2969
    //   5374: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5377: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5380: invokestatic 643	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
    //   5383: return
    //   5384: aload_0
    //   5385: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   5388: getfield 862	com/whatsapp/atv:a	Landroid/content/SharedPreferences;
    //   5391: invokeinterface 868 1 0
    //   5396: astore 26
    //   5398: aload 26
    //   5400: new 573	java/lang/StringBuilder
    //   5403: dup
    //   5404: ldc_w 888
    //   5407: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5410: aload 25
    //   5412: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5415: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5418: invokeinterface 2813 2 0
    //   5423: pop
    //   5424: aload 26
    //   5426: new 573	java/lang/StringBuilder
    //   5429: dup
    //   5430: ldc_w 2977
    //   5433: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5436: aload 25
    //   5438: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5441: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5444: invokeinterface 2813 2 0
    //   5449: pop
    //   5450: aload 26
    //   5452: new 573	java/lang/StringBuilder
    //   5455: dup
    //   5456: ldc_w 2979
    //   5459: invokespecial 576	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   5462: aload 25
    //   5464: invokevirtual 580	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5467: invokevirtual 587	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5470: invokeinterface 2813 2 0
    //   5475: pop
    //   5476: aload 26
    //   5478: invokeinterface 883 1 0
    //   5483: ifne +62 -> 5545
    //   5486: ldc_w 2981
    //   5489: invokestatic 701	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   5492: iconst_0
    //   5493: istore 4
    //   5495: iload 4
    //   5497: ifeq -5485 -> 12
    //   5500: aload 25
    //   5502: aload_0
    //   5503: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   5506: invokevirtual 2664	com/whatsapp/atv:ac	()Ljava/lang/String;
    //   5509: invokevirtual 731	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5512: ifeq +25 -> 5537
    //   5515: aload_1
    //   5516: invokevirtual 2963	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   5519: ldc_w 2983
    //   5522: invokevirtual 2986	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   5525: ifeq +12 -> 5537
    //   5528: aload_0
    //   5529: getfield 513	com/whatsapp/gdrive/GoogleDriveService:u	Lcom/whatsapp/atv;
    //   5532: aconst_null
    //   5533: invokevirtual 2458	com/whatsapp/atv:g	(Ljava/lang/String;)Z
    //   5536: pop
    //   5537: aload_0
    //   5538: getfield 406	com/whatsapp/gdrive/GoogleDriveService:n	Lcom/whatsapp/gdrive/GoogleDriveService$d;
    //   5541: invokevirtual 2973	com/whatsapp/gdrive/GoogleDriveService$d:h	()V
    //   5544: return
    //   5545: iconst_1
    //   5546: istore 4
    //   5548: goto -53 -> 5495
    //   5551: aload_0
    //   5552: invokespecial 2988	com/whatsapp/gdrive/GoogleDriveService:z	()V
    //   5555: return
    //   5556: astore_1
    //   5557: goto -246 -> 5311
    //   5560: astore_1
    //   5561: goto -250 -> 5311
    //   5564: astore_1
    //   5565: goto -501 -> 5064
    //   5568: lconst_0
    //   5569: lstore 23
    //   5571: goto -3475 -> 2096
    //   5574: dconst_0
    //   5575: dstore_2
    //   5576: goto -2850 -> 2726
    //   5579: lconst_0
    //   5580: lstore 23
    //   5582: goto -2738 -> 2844
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5585	0	this	GoogleDriveService
    //   0	5585	1	paramIntent	Intent
    //   2725	2851	2	d1	double
    //   410	5137	4	i1	int
    //   193	5142	5	bool1	boolean
    //   1004	4055	6	bool2	boolean
    //   1373	3638	7	bool3	boolean
    //   1362	3695	8	bool4	boolean
    //   3108	1751	9	bool5	boolean
    //   3112	1724	10	bool6	boolean
    //   3116	1724	11	bool7	boolean
    //   3120	1724	12	bool8	boolean
    //   3124	1724	13	bool9	boolean
    //   3128	761	14	bool10	boolean
    //   3029	206	15	bool11	boolean
    //   3032	207	16	bool12	boolean
    //   3035	208	17	bool13	boolean
    //   3038	209	18	bool14	boolean
    //   3041	210	19	bool15	boolean
    //   3044	211	20	bool16	boolean
    //   3047	212	21	bool17	boolean
    //   3050	213	22	bool18	boolean
    //   2094	3487	23	l1	long
    //   57	645	25	localObject1	Object
    //   1672	8	25	localObject2	Object
    //   2001	3500	25	localObject3	Object
    //   26	5451	26	localObject4	Object
    //   255	54	27	localc	com.whatsapp.util.a.c
    //   261	50	28	localox	ox
    //   267	46	29	localatu	atu
    //   273	42	30	str	String
    // Exception table:
    //   from	to	target	type
    //   1181	1196	1597	finally
    //   1200	1206	1597	finally
    //   1206	1220	1597	finally
    //   1220	1249	1597	finally
    //   1258	1265	1597	finally
    //   1268	1361	1597	finally
    //   1375	1391	1597	finally
    //   1399	1405	1597	finally
    //   1418	1427	1597	finally
    //   1435	1441	1597	finally
    //   1458	1467	1597	finally
    //   1560	1567	1597	finally
    //   1576	1597	1597	finally
    //   1604	1624	1597	finally
    //   1641	1647	1597	finally
    //   1655	1666	1597	finally
    //   1691	1698	1597	finally
    //   1706	1708	1597	finally
    //   1709	1728	1597	finally
    //   1732	1751	1597	finally
    //   1763	1776	1597	finally
    //   1779	1792	1597	finally
    //   1795	1808	1597	finally
    //   1811	1824	1597	finally
    //   1827	1840	1597	finally
    //   1843	1856	1597	finally
    //   1859	1872	1597	finally
    //   1875	1888	1597	finally
    //   1891	1904	1597	finally
    //   1907	1914	1597	finally
    //   1918	1931	1597	finally
    //   1938	2025	1597	finally
    //   2025	2093	1597	finally
    //   2096	2126	1597	finally
    //   2126	2297	1597	finally
    //   2297	2358	1597	finally
    //   2358	2375	1597	finally
    //   2380	2386	1597	finally
    //   2392	2473	1597	finally
    //   2473	2496	1597	finally
    //   2499	2544	1597	finally
    //   2547	2635	1597	finally
    //   2635	2678	1597	finally
    //   2678	2699	1597	finally
    //   2699	2716	1597	finally
    //   2720	2726	1597	finally
    //   2726	2735	1597	finally
    //   2735	2841	1597	finally
    //   2844	2874	1597	finally
    //   2874	2929	1597	finally
    //   2930	2948	1597	finally
    //   2951	2983	1597	finally
    //   1485	1498	1672	finally
    //   1503	1527	1672	finally
    //   1532	1547	1672	finally
    //   1467	1485	1682	finally
    //   1547	1552	1682	finally
    //   1674	1682	1682	finally
    //   1754	1760	1682	finally
    //   1375	1391	1708	com/whatsapp/gdrive/ba
    //   1399	1405	1708	com/whatsapp/gdrive/ba
    //   1418	1427	1708	com/whatsapp/gdrive/ba
    //   1435	1441	1708	com/whatsapp/gdrive/ba
    //   1458	1467	1708	com/whatsapp/gdrive/ba
    //   1560	1567	1708	com/whatsapp/gdrive/ba
    //   1641	1647	1708	com/whatsapp/gdrive/ba
    //   1655	1666	1708	com/whatsapp/gdrive/ba
    //   1691	1698	1708	com/whatsapp/gdrive/ba
    //   1706	1708	1708	com/whatsapp/gdrive/ba
    //   1375	1391	1917	com/whatsapp/zg
    //   1399	1405	1917	com/whatsapp/zg
    //   1418	1427	1917	com/whatsapp/zg
    //   1435	1441	1917	com/whatsapp/zg
    //   1458	1467	1917	com/whatsapp/zg
    //   1560	1567	1917	com/whatsapp/zg
    //   1641	1647	1917	com/whatsapp/zg
    //   1655	1666	1917	com/whatsapp/zg
    //   1691	1698	1917	com/whatsapp/zg
    //   1706	1708	1917	com/whatsapp/zg
    //   2699	2716	2929	java/io/IOException
    //   2720	2726	2929	java/io/IOException
    //   2726	2735	2929	java/io/IOException
    //   3130	3146	3466	com/whatsapp/gdrive/f
    //   3182	3188	3466	com/whatsapp/gdrive/f
    //   3266	3272	3466	com/whatsapp/gdrive/f
    //   3313	3319	3466	com/whatsapp/gdrive/f
    //   3457	3463	3466	com/whatsapp/gdrive/f
    //   3055	3078	3504	finally
    //   3078	3094	3504	finally
    //   3188	3196	3504	finally
    //   3319	3328	3504	finally
    //   3328	3387	3504	finally
    //   3488	3497	3504	finally
    //   3585	3594	3504	finally
    //   3626	3637	3504	finally
    //   3672	3681	3504	finally
    //   3727	3736	3504	finally
    //   3765	3774	3504	finally
    //   3803	3812	3504	finally
    //   3841	3850	3504	finally
    //   3879	3888	3504	finally
    //   3130	3146	3540	com/whatsapp/gdrive/ax
    //   3182	3188	3540	com/whatsapp/gdrive/ax
    //   3266	3272	3540	com/whatsapp/gdrive/ax
    //   3313	3319	3540	com/whatsapp/gdrive/ax
    //   3457	3463	3540	com/whatsapp/gdrive/ax
    //   3130	3146	3625	finally
    //   3182	3188	3625	finally
    //   3266	3272	3625	finally
    //   3313	3319	3625	finally
    //   3457	3463	3625	finally
    //   3471	3477	3625	finally
    //   3481	3488	3625	finally
    //   3545	3552	3625	finally
    //   3556	3561	3625	finally
    //   3569	3575	3625	finally
    //   3579	3585	3625	finally
    //   3605	3612	3625	finally
    //   3616	3622	3625	finally
    //   3641	3647	3625	finally
    //   3655	3661	3625	finally
    //   3665	3672	3625	finally
    //   3693	3699	3625	finally
    //   3703	3710	3625	finally
    //   3714	3727	3625	finally
    //   3748	3754	3625	finally
    //   3758	3765	3625	finally
    //   3786	3792	3625	finally
    //   3796	3803	3625	finally
    //   3824	3830	3625	finally
    //   3834	3841	3625	finally
    //   3862	3868	3625	finally
    //   3872	3879	3625	finally
    //   3130	3146	3650	com/whatsapp/gdrive/ay
    //   3182	3188	3650	com/whatsapp/gdrive/ay
    //   3266	3272	3650	com/whatsapp/gdrive/ay
    //   3313	3319	3650	com/whatsapp/gdrive/ay
    //   3457	3463	3650	com/whatsapp/gdrive/ay
    //   3130	3146	3688	com/whatsapp/gdrive/be
    //   3182	3188	3688	com/whatsapp/gdrive/be
    //   3266	3272	3688	com/whatsapp/gdrive/be
    //   3313	3319	3688	com/whatsapp/gdrive/be
    //   3457	3463	3688	com/whatsapp/gdrive/be
    //   3130	3146	3743	com/whatsapp/gdrive/cn
    //   3182	3188	3743	com/whatsapp/gdrive/cn
    //   3266	3272	3743	com/whatsapp/gdrive/cn
    //   3313	3319	3743	com/whatsapp/gdrive/cn
    //   3457	3463	3743	com/whatsapp/gdrive/cn
    //   3130	3146	3781	com/whatsapp/gdrive/bl
    //   3182	3188	3781	com/whatsapp/gdrive/bl
    //   3266	3272	3781	com/whatsapp/gdrive/bl
    //   3313	3319	3781	com/whatsapp/gdrive/bl
    //   3457	3463	3781	com/whatsapp/gdrive/bl
    //   3130	3146	3819	com/whatsapp/gdrive/a
    //   3182	3188	3819	com/whatsapp/gdrive/a
    //   3266	3272	3819	com/whatsapp/gdrive/a
    //   3313	3319	3819	com/whatsapp/gdrive/a
    //   3457	3463	3819	com/whatsapp/gdrive/a
    //   3130	3146	3857	com/whatsapp/gdrive/ew
    //   3182	3188	3857	com/whatsapp/gdrive/ew
    //   3266	3272	3857	com/whatsapp/gdrive/ew
    //   3313	3319	3857	com/whatsapp/gdrive/ew
    //   3457	3463	3857	com/whatsapp/gdrive/ew
    //   4015	4037	4484	com/whatsapp/gdrive/f
    //   4050	4075	4484	com/whatsapp/gdrive/f
    //   4083	4094	4484	com/whatsapp/gdrive/f
    //   4094	4112	4484	com/whatsapp/gdrive/f
    //   4112	4196	4484	com/whatsapp/gdrive/f
    //   4196	4362	4484	com/whatsapp/gdrive/f
    //   4367	4375	4484	com/whatsapp/gdrive/f
    //   4375	4416	4484	com/whatsapp/gdrive/f
    //   4429	4481	4484	com/whatsapp/gdrive/f
    //   4516	4522	4484	com/whatsapp/gdrive/f
    //   4557	4575	4484	com/whatsapp/gdrive/f
    //   4595	4602	4484	com/whatsapp/gdrive/f
    //   3976	3999	4501	finally
    //   3999	4015	4501	finally
    //   4015	4037	4501	finally
    //   4050	4075	4501	finally
    //   4083	4094	4501	finally
    //   4094	4112	4501	finally
    //   4112	4196	4501	finally
    //   4196	4362	4501	finally
    //   4367	4375	4501	finally
    //   4375	4416	4501	finally
    //   4429	4481	4501	finally
    //   4485	4498	4501	finally
    //   4516	4522	4501	finally
    //   4526	4538	4501	finally
    //   4542	4548	4501	finally
    //   4548	4554	4501	finally
    //   4557	4575	4501	finally
    //   4579	4592	4501	finally
    //   4595	4602	4501	finally
    //   4606	4619	4501	finally
    //   4622	4635	4501	finally
    //   4639	4652	4501	finally
    //   4656	4669	4501	finally
    //   4015	4037	4525	com/whatsapp/gdrive/ax
    //   4050	4075	4525	com/whatsapp/gdrive/ax
    //   4083	4094	4525	com/whatsapp/gdrive/ax
    //   4094	4112	4525	com/whatsapp/gdrive/ax
    //   4112	4196	4525	com/whatsapp/gdrive/ax
    //   4196	4362	4525	com/whatsapp/gdrive/ax
    //   4367	4375	4525	com/whatsapp/gdrive/ax
    //   4375	4416	4525	com/whatsapp/gdrive/ax
    //   4429	4481	4525	com/whatsapp/gdrive/ax
    //   4516	4522	4525	com/whatsapp/gdrive/ax
    //   4557	4575	4525	com/whatsapp/gdrive/ax
    //   4595	4602	4525	com/whatsapp/gdrive/ax
    //   4015	4037	4578	com/whatsapp/gdrive/ay
    //   4050	4075	4578	com/whatsapp/gdrive/ay
    //   4083	4094	4578	com/whatsapp/gdrive/ay
    //   4094	4112	4578	com/whatsapp/gdrive/ay
    //   4112	4196	4578	com/whatsapp/gdrive/ay
    //   4196	4362	4578	com/whatsapp/gdrive/ay
    //   4367	4375	4578	com/whatsapp/gdrive/ay
    //   4375	4416	4578	com/whatsapp/gdrive/ay
    //   4429	4481	4578	com/whatsapp/gdrive/ay
    //   4516	4522	4578	com/whatsapp/gdrive/ay
    //   4557	4575	4578	com/whatsapp/gdrive/ay
    //   4595	4602	4578	com/whatsapp/gdrive/ay
    //   4015	4037	4605	com/whatsapp/gdrive/cn
    //   4050	4075	4605	com/whatsapp/gdrive/cn
    //   4083	4094	4605	com/whatsapp/gdrive/cn
    //   4094	4112	4605	com/whatsapp/gdrive/cn
    //   4112	4196	4605	com/whatsapp/gdrive/cn
    //   4196	4362	4605	com/whatsapp/gdrive/cn
    //   4367	4375	4605	com/whatsapp/gdrive/cn
    //   4375	4416	4605	com/whatsapp/gdrive/cn
    //   4429	4481	4605	com/whatsapp/gdrive/cn
    //   4516	4522	4605	com/whatsapp/gdrive/cn
    //   4557	4575	4605	com/whatsapp/gdrive/cn
    //   4595	4602	4605	com/whatsapp/gdrive/cn
    //   4015	4037	4638	com/whatsapp/gdrive/bl
    //   4050	4075	4638	com/whatsapp/gdrive/bl
    //   4083	4094	4638	com/whatsapp/gdrive/bl
    //   4094	4112	4638	com/whatsapp/gdrive/bl
    //   4112	4196	4638	com/whatsapp/gdrive/bl
    //   4196	4362	4638	com/whatsapp/gdrive/bl
    //   4367	4375	4638	com/whatsapp/gdrive/bl
    //   4375	4416	4638	com/whatsapp/gdrive/bl
    //   4429	4481	4638	com/whatsapp/gdrive/bl
    //   4516	4522	4638	com/whatsapp/gdrive/bl
    //   4557	4575	4638	com/whatsapp/gdrive/bl
    //   4595	4602	4638	com/whatsapp/gdrive/bl
    //   4015	4037	4655	com/whatsapp/gdrive/a
    //   4050	4075	4655	com/whatsapp/gdrive/a
    //   4083	4094	4655	com/whatsapp/gdrive/a
    //   4094	4112	4655	com/whatsapp/gdrive/a
    //   4112	4196	4655	com/whatsapp/gdrive/a
    //   4196	4362	4655	com/whatsapp/gdrive/a
    //   4367	4375	4655	com/whatsapp/gdrive/a
    //   4375	4416	4655	com/whatsapp/gdrive/a
    //   4429	4481	4655	com/whatsapp/gdrive/a
    //   4516	4522	4655	com/whatsapp/gdrive/a
    //   4557	4575	4655	com/whatsapp/gdrive/a
    //   4595	4602	4655	com/whatsapp/gdrive/a
    //   4721	4729	4922	com/whatsapp/gdrive/f
    //   4749	4755	4922	com/whatsapp/gdrive/f
    //   4851	4858	4922	com/whatsapp/gdrive/f
    //   4874	4886	4922	com/whatsapp/gdrive/f
    //   4907	4919	4922	com/whatsapp/gdrive/f
    //   4721	4729	4971	com/whatsapp/gdrive/ax
    //   4749	4755	4971	com/whatsapp/gdrive/ax
    //   4851	4858	4971	com/whatsapp/gdrive/ax
    //   4874	4886	4971	com/whatsapp/gdrive/ax
    //   4907	4919	4971	com/whatsapp/gdrive/ax
    //   4721	4729	5017	com/whatsapp/gdrive/bl
    //   4749	4755	5017	com/whatsapp/gdrive/bl
    //   4851	4858	5017	com/whatsapp/gdrive/bl
    //   4874	4886	5017	com/whatsapp/gdrive/bl
    //   4907	4919	5017	com/whatsapp/gdrive/bl
    //   4721	4729	5063	finally
    //   4749	4755	5063	finally
    //   4851	4858	5063	finally
    //   4927	4933	5063	finally
    //   4937	4944	5063	finally
    //   4976	4982	5063	finally
    //   4986	4993	5063	finally
    //   5022	5028	5063	finally
    //   5032	5039	5063	finally
    //   5289	5297	5310	com/whatsapp/gdrive/f
    //   5289	5297	5556	com/whatsapp/gdrive/ax
    //   5289	5297	5560	com/whatsapp/gdrive/bl
    //   4874	4886	5564	finally
    //   4907	4919	5564	finally
  }
  
  public static abstract class a
    implements GoogleDriveService.e
  {
    public final void a() {}
    
    public final void a(int paramInt) {}
    
    public final void a(int paramInt, Bundle paramBundle) {}
    
    public final void a(long paramLong1, long paramLong2) {}
    
    public final void a(long paramLong1, long paramLong2, long paramLong3) {}
    
    public final void a(boolean paramBoolean, long paramLong1, long paramLong2) {}
    
    public final void b() {}
    
    public final void b(int paramInt) {}
    
    public final void b(int paramInt, Bundle paramBundle) {}
    
    public final void b(long paramLong1, long paramLong2) {}
    
    public final void b(boolean paramBoolean) {}
    
    public final void c() {}
    
    public final void c(int paramInt) {}
    
    public final void c(int paramInt, Bundle paramBundle) {}
    
    public final void c(long paramLong1, long paramLong2) {}
    
    public final void c(boolean paramBoolean) {}
    
    public final void d(long paramLong1, long paramLong2) {}
    
    public final void e() {}
    
    public final void e(long paramLong1, long paramLong2) {}
    
    public final void f() {}
    
    public final void f(long paramLong1, long paramLong2) {}
    
    public final void g() {}
    
    public final void g(long paramLong1, long paramLong2) {}
    
    public final void h() {}
    
    public final void h(long paramLong1, long paramLong2) {}
    
    public final void i() {}
    
    public final void i(long paramLong1, long paramLong2) {}
    
    public final void j(long paramLong1, long paramLong2) {}
    
    public final void k(long paramLong1, long paramLong2) {}
    
    public final void l(long paramLong1, long paramLong2) {}
  }
  
  public static abstract class b
    implements GoogleDriveService.e
  {
    public final void a(boolean paramBoolean) {}
    
    public final void b(int paramInt) {}
    
    public final void b(int paramInt, Bundle paramBundle) {}
    
    public final void b(boolean paramBoolean) {}
    
    public final void c() {}
    
    public final void c(int paramInt) {}
    
    public final void c(int paramInt, Bundle paramBundle) {}
    
    public final void c(boolean paramBoolean) {}
    
    public final void e() {}
    
    public final void f() {}
    
    public final void f(long paramLong1, long paramLong2) {}
    
    public final void g() {}
    
    public final void g(long paramLong1, long paramLong2) {}
    
    public final void h() {}
    
    public final void h(long paramLong1, long paramLong2) {}
    
    public final void i() {}
    
    public final void i(long paramLong1, long paramLong2) {}
    
    public final void j(long paramLong1, long paramLong2) {}
    
    public final void k(long paramLong1, long paramLong2) {}
    
    public final void l(long paramLong1, long paramLong2) {}
  }
  
  public static abstract class c
    implements GoogleDriveService.e
  {
    public final void a() {}
    
    public final void a(int paramInt) {}
    
    public final void a(int paramInt, Bundle paramBundle) {}
    
    public final void a(long paramLong1, long paramLong2) {}
    
    public final void a(long paramLong1, long paramLong2, long paramLong3) {}
    
    public final void a(boolean paramBoolean) {}
    
    public final void a(boolean paramBoolean, long paramLong1, long paramLong2) {}
    
    public final void b() {}
    
    public final void b(int paramInt) {}
    
    public final void b(long paramLong1, long paramLong2) {}
    
    public final void c(int paramInt) {}
    
    public final void c(int paramInt, Bundle paramBundle) {}
    
    public final void c(long paramLong1, long paramLong2) {}
    
    public final void c(boolean paramBoolean) {}
    
    public final void d(long paramLong1, long paramLong2) {}
    
    public final void e() {}
    
    public final void e(long paramLong1, long paramLong2) {}
    
    public final void f() {}
    
    public final void g() {}
    
    public final void g(long paramLong1, long paramLong2) {}
    
    public final void h() {}
    
    public final void h(long paramLong1, long paramLong2) {}
    
    public final void i() {}
    
    public final void i(long paramLong1, long paramLong2) {}
    
    public final void j(long paramLong1, long paramLong2) {}
    
    public final void k(long paramLong1, long paramLong2) {}
    
    public final void l(long paramLong1, long paramLong2) {}
  }
  
  static final class d
    extends Observable<GoogleDriveService.e>
  {
    private int a = -1;
    private int b = -1;
    private int c = -1;
    
    public final void a()
    {
      this.a = 0;
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).e();
        }
      }
    }
    
    public final void a(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt != this.b))
      {
        this.b = paramInt;
        Log.i("gdrive-service/scrub-progress/" + this.b + "%");
        synchronized (this.mObservers)
        {
          Iterator localIterator = this.mObservers.iterator();
          if (localIterator.hasNext()) {
            ((GoogleDriveService.e)localIterator.next()).c(paramInt);
          }
        }
      }
    }
    
    public final void a(int paramInt, Bundle paramBundle)
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).c(paramInt, paramBundle);
        }
      }
    }
    
    public final void a(long paramLong1, long paramLong2)
    {
      if (paramLong2 > 0L) {}
      for (int i = (int)(100L * paramLong1 / paramLong2);; i = -1)
      {
        if (paramLong2 <= 0L) {
          Log.i("gdrive-service/backup-preparation-progress " + paramLong1 + "/" + paramLong2);
        }
        if (i == this.a) {
          return;
        }
        this.a = i;
        Log.i("gdrive-service/backup-preparation-progress/" + i + "%");
        synchronized (this.mObservers)
        {
          Iterator localIterator = this.mObservers.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          ((GoogleDriveService.e)localIterator.next()).b(this.a);
        }
      }
    }
    
    public final void a(long paramLong1, long paramLong2, long paramLong3)
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).a(paramLong1, paramLong2, paramLong3);
        }
      }
    }
    
    public final void a(boolean paramBoolean)
    {
      Log.i("gdrive-service/backup-end/success/" + paramBoolean);
      this.a = 0;
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).c(paramBoolean);
        }
      }
    }
    
    public final void a(boolean paramBoolean, long paramLong1, long paramLong2)
    {
      this.c = -1;
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).a(paramBoolean, paramLong1, paramLong2);
        }
      }
    }
    
    public final void b()
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).f();
        }
      }
    }
    
    public final void b(int paramInt, Bundle paramBundle)
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).a(paramInt, paramBundle);
        }
      }
    }
    
    public final void b(long paramLong1, long paramLong2)
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).g(paramLong1, paramLong2);
        }
      }
    }
    
    public final void b(boolean paramBoolean)
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).b(paramBoolean);
        }
      }
    }
    
    public final void c()
    {
      Log.i("gdrive-service/notify-media-restore-cancelled");
      this.c = -1;
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).b();
        }
      }
    }
    
    public final void c(int paramInt, Bundle paramBundle)
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).b(paramInt, paramBundle);
        }
      }
    }
    
    public final void c(long paramLong1, long paramLong2)
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).h(paramLong1, paramLong2);
        }
      }
    }
    
    public final void c(boolean paramBoolean)
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).a(paramBoolean);
        }
      }
    }
    
    public final void d()
    {
      this.b = 0;
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).g();
        }
      }
    }
    
    public final void d(long paramLong1, long paramLong2)
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).i(paramLong1, paramLong2);
        }
      }
    }
    
    public final void e()
    {
      Log.i("gdrive-service/backup-cancelled");
      this.a = 0;
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).h();
        }
      }
    }
    
    public final void e(long paramLong1, long paramLong2)
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).j(paramLong1, paramLong2);
        }
      }
    }
    
    public final void f()
    {
      this.c = 0;
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).a();
        }
      }
    }
    
    public final void f(long paramLong1, long paramLong2)
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).k(paramLong1, paramLong2);
        }
      }
    }
    
    public final void g()
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).c();
        }
      }
    }
    
    public final void g(long paramLong1, long paramLong2)
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).a(paramLong1, paramLong2);
        }
      }
    }
    
    public final void h()
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).i();
        }
      }
    }
    
    public final void h(long paramLong1, long paramLong2)
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).b(paramLong1, paramLong2);
        }
      }
    }
    
    public final void i(long paramLong1, long paramLong2)
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).c(paramLong1, paramLong2);
        }
      }
    }
    
    public final void j(long paramLong1, long paramLong2)
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).d(paramLong1, paramLong2);
        }
      }
    }
    
    public final void k(long paramLong1, long paramLong2)
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).e(paramLong1, paramLong2);
        }
      }
    }
    
    public final void l(long paramLong1, long paramLong2)
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).l(paramLong1, paramLong2);
        }
      }
    }
    
    public final void m(long paramLong1, long paramLong2)
    {
      int i = this.c;
      if (paramLong2 > 0L) {
        i = (int)(100L * paramLong1 / paramLong2);
      }
      if (i != this.c)
      {
        Log.i(String.format(Locale.ENGLISH, "gdrive-service/media-restore-preparation-progress %d/%d (%d%%)", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(i) }));
        this.c = i;
        synchronized (this.mObservers)
        {
          Iterator localIterator = this.mObservers.iterator();
          if (localIterator.hasNext()) {
            ((GoogleDriveService.e)localIterator.next()).a(this.c);
          }
        }
      }
    }
    
    public final void n(long paramLong1, long paramLong2)
    {
      synchronized (this.mObservers)
      {
        Iterator localIterator = this.mObservers.iterator();
        if (localIterator.hasNext()) {
          ((GoogleDriveService.e)localIterator.next()).f(paramLong1, paramLong2);
        }
      }
    }
  }
  
  public static abstract interface e
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
    
    public abstract void a(int paramInt, Bundle paramBundle);
    
    public abstract void a(long paramLong1, long paramLong2);
    
    public abstract void a(long paramLong1, long paramLong2, long paramLong3);
    
    public abstract void a(boolean paramBoolean);
    
    public abstract void a(boolean paramBoolean, long paramLong1, long paramLong2);
    
    public abstract void b();
    
    public abstract void b(int paramInt);
    
    public abstract void b(int paramInt, Bundle paramBundle);
    
    public abstract void b(long paramLong1, long paramLong2);
    
    public abstract void b(boolean paramBoolean);
    
    public abstract void c();
    
    public abstract void c(int paramInt);
    
    public abstract void c(int paramInt, Bundle paramBundle);
    
    public abstract void c(long paramLong1, long paramLong2);
    
    public abstract void c(boolean paramBoolean);
    
    public abstract void d(long paramLong1, long paramLong2);
    
    public abstract void e();
    
    public abstract void e(long paramLong1, long paramLong2);
    
    public abstract void f();
    
    public abstract void f(long paramLong1, long paramLong2);
    
    public abstract void g();
    
    public abstract void g(long paramLong1, long paramLong2);
    
    public abstract void h();
    
    public abstract void h(long paramLong1, long paramLong2);
    
    public abstract void i();
    
    public abstract void i(long paramLong1, long paramLong2);
    
    public abstract void j(long paramLong1, long paramLong2);
    
    public abstract void k(long paramLong1, long paramLong2);
    
    public abstract void l(long paramLong1, long paramLong2);
  }
  
  public final class f
    extends Binder
  {
    public f() {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gdrive/GoogleDriveService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */