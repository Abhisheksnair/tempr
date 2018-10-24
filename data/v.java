package com.whatsapp.data;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Observable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.SystemClock;
import b.a.a.c;
import com.whatsapp.and;
import com.whatsapp.atv;
import com.whatsapp.cc;
import com.whatsapp.g.d;
import com.whatsapp.g.l;
import com.whatsapp.gdrive.GoogleDriveService;
import com.whatsapp.messaging.w;
import com.whatsapp.ng;
import com.whatsapp.pv;
import com.whatsapp.pv.a;
import com.whatsapp.r;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import com.whatsapp.va;
import com.whatsapp.vv;
import com.whatsapp.wallpaper.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public final class v
{
  private static volatile v c;
  public boolean a;
  public boolean b;
  private final pv d;
  private final va e;
  private final w f;
  private final ad g;
  private final and h;
  private final g i;
  private final cc j;
  private final vv k;
  private final atv l;
  private final k m;
  private final b n = new b((byte)0);
  
  private v(pv parampv, va paramva, w paramw, ad paramad, and paramand, g paramg, cc paramcc, vv paramvv, atv paramatv, k paramk)
  {
    this.d = parampv;
    this.e = paramva;
    this.f = paramw;
    this.g = paramad;
    this.h = paramand;
    this.i = paramg;
    this.j = paramcc;
    this.k = paramvv;
    this.l = paramatv;
    this.m = paramk;
  }
  
  public static v a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new v(pv.a(), va.a(), w.a(), ad.a(), and.a(), g.a(), cc.a(), vv.a(), atv.a(), k.a());
      }
      return c;
    }
    finally {}
  }
  
  private boolean c(boolean paramBoolean)
  {
    d locald = (d)c.a().a(d.class);
    if ((locald != null) && (locald.c())) {}
    for (int i1 = 1; (this.e.b != null) && (this.a) && (paramBoolean) && (!this.k.c()) && (i1 != 0); i1 = 0) {
      return true;
    }
    return false;
  }
  
  public final void a(c paramc)
  {
    this.n.unregisterObserver(paramc);
  }
  
  public final void a(boolean paramBoolean)
  {
    a(paramBoolean, -1L, new c()
    {
      public final void a()
      {
        v.this.a = false;
        pv localpv = v.a(v.this);
        Log.i("app/progress-spinner/show dt=" + localpv.e);
        localpv.f = new pv.a((byte)0);
        if (localpv.e != null) {
          localpv.e.a(2131297195, 2131297193);
        }
        Log.i("app/progress-spinner/show done");
      }
      
      public final void a(int paramAnonymousInt)
      {
        Object localObject = String.format(Locale.ENGLISH, "app/backup/progress/%d%%", new Object[] { Integer.valueOf(paramAnonymousInt) });
        if (paramAnonymousInt % 10 == 0) {
          Log.i((String)localObject);
        }
        localObject = v.a(v.this);
        String str = u.a().getString(2131297194, new Object[] { Integer.valueOf(paramAnonymousInt) });
        Log.i("app/progress-spinner/update-message dt=" + ((pv)localObject).e);
        if (((pv)localObject).f != null) {
          ((pv)localObject).f.c = str;
        }
        for (;;)
        {
          if (((pv)localObject).e != null) {
            ((pv)localObject).e.e(str);
          }
          Log.i("app/progress-spinner/update-message done");
          return;
          Log.w("app/progress-spinner/update-message no progress data");
        }
      }
      
      public final void a(ad.c paramAnonymousc)
      {
        v.this.a(this);
        long l;
        Object localObject2;
        Object localObject1;
        if (v.a(v.this, paramAnonymousc, v.b(v.this)))
        {
          l = v.b(v.b(v.this));
          Log.i("local/backup/gdrive/random-wait-time-in-secs/" + l);
          localObject2 = new Intent(u.a(), GoogleDriveService.class);
          ((Intent)localObject2).setAction("action_backup");
          if (!v.b(v.this)) {
            break label182;
          }
          localObject1 = "user_initiated";
          ((Intent)localObject2).putExtra("backup_mode", (String)localObject1);
          localObject1 = (AlarmManager)u.a().getSystemService("alarm");
          localObject2 = PendingIntent.getService(u.a(), 0, (Intent)localObject2, 0);
          if (Build.VERSION.SDK_INT < 19) {
            break label189;
          }
          ((AlarmManager)localObject1).setExact(2, l * 1000L + SystemClock.elapsedRealtime(), (PendingIntent)localObject2);
        }
        for (;;)
        {
          v.c(v.this);
          v.a(v.this).g();
          if (paramAnonymousc == ad.c.d) {
            r.m();
          }
          return;
          label182:
          localObject1 = "automated";
          break;
          label189:
          ((AlarmManager)localObject1).set(2, l * 1000L + SystemClock.elapsedRealtime(), (PendingIntent)localObject2);
        }
      }
    });
  }
  
  public final void a(boolean paramBoolean, long paramLong, c paramc)
  {
    this.n.registerObserver(paramc);
    bu.a(new a(paramBoolean, paramLong, this.f, this.g, this.h, this.i, this.n, this.j, this.m), new Void[0]);
  }
  
  public final boolean b()
  {
    l locall = (l)c.a().a(l.class);
    if ((locall != null) && (locall.a)) {}
    for (boolean bool = true;; bool = false) {
      return c(bool);
    }
  }
  
  public final void onEvent(l paraml)
  {
    if (c(paraml.a)) {
      a(false);
    }
  }
  
  public static final class a
    extends AsyncTask<Void, Integer, ad.c>
  {
    private final boolean a;
    private final long b;
    private final w c;
    private final ad d;
    private final and e;
    private final g f;
    private final v.b g;
    private final cc h;
    private final k i;
    
    public a(boolean paramBoolean, long paramLong, w paramw, ad paramad, and paramand, g paramg, v.b paramb, cc paramcc, k paramk)
    {
      this.a = paramBoolean;
      this.b = paramLong;
      this.c = paramw;
      this.d = paramad;
      this.e = paramand;
      this.f = paramg;
      this.g = paramb;
      this.h = paramcc;
      this.i = paramk;
    }
    
    /* Error */
    private ad.c a()
    {
      // Byte code:
      //   0: getstatic 59	com/whatsapp/data/ad$c:b	Lcom/whatsapp/data/ad$c;
      //   3: astore 5
      //   5: aload_0
      //   6: getfield 40	com/whatsapp/data/v$a:e	Lcom/whatsapp/and;
      //   9: getfield 64	com/whatsapp/and:a	Landroid/os/PowerManager;
      //   12: astore 6
      //   14: aload 6
      //   16: ifnonnull +254 -> 270
      //   19: ldc 66
      //   21: invokestatic 72	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
      //   24: aconst_null
      //   25: astore 6
      //   27: aload 6
      //   29: ifnull +8 -> 37
      //   32: aload 6
      //   34: invokevirtual 77	android/os/PowerManager$WakeLock:acquire	()V
      //   37: ldc 79
      //   39: invokestatic 81	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   42: invokestatic 87	java/lang/System:currentTimeMillis	()J
      //   45: lstore_1
      //   46: invokestatic 93	com/whatsapp/r:l	()Z
      //   49: ifeq +77 -> 126
      //   52: invokestatic 96	com/whatsapp/r:e	()[B
      //   55: astore 7
      //   57: aload 7
      //   59: invokestatic 99	com/whatsapp/r:a	([B)[B
      //   62: astore 8
      //   64: aload 8
      //   66: ifnull +268 -> 334
      //   69: new 101	android/os/ConditionVariable
      //   72: dup
      //   73: iconst_0
      //   74: invokespecial 104	android/os/ConditionVariable:<init>	(Z)V
      //   77: astore 9
      //   79: aload_0
      //   80: getfield 36	com/whatsapp/data/v$a:c	Lcom/whatsapp/messaging/w;
      //   83: astore 10
      //   85: aload 9
      //   87: invokevirtual 110	java/lang/Object:getClass	()Ljava/lang/Class;
      //   90: pop
      //   91: aload 10
      //   93: aload 8
      //   95: aload 7
      //   97: aload 9
      //   99: invokestatic 115	com/whatsapp/data/w:a	(Landroid/os/ConditionVariable;)Ljava/lang/Runnable;
      //   102: invokevirtual 120	com/whatsapp/messaging/w:a	([B[BLjava/lang/Runnable;)V
      //   105: ldc 122
      //   107: invokestatic 81	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   110: aload 9
      //   112: ldc2_w 123
      //   115: invokevirtual 128	android/os/ConditionVariable:block	(J)Z
      //   118: ifne +165 -> 283
      //   121: ldc -126
      //   123: invokestatic 132	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
      //   126: aload_0
      //   127: getfield 48	com/whatsapp/data/v$a:i	Lcom/whatsapp/data/k;
      //   130: invokevirtual 136	com/whatsapp/data/k:b	()V
      //   133: aload_0
      //   134: getfield 38	com/whatsapp/data/v$a:d	Lcom/whatsapp/data/ad;
      //   137: aload_0
      //   138: getfield 32	com/whatsapp/data/v$a:a	Z
      //   141: new 138	com/whatsapp/data/x
      //   144: dup
      //   145: aload_0
      //   146: invokespecial 141	com/whatsapp/data/x:<init>	(Lcom/whatsapp/data/v$a;)V
      //   149: invokevirtual 146	com/whatsapp/data/ad:a	(ZLcom/whatsapp/gdrive/ch$a;)Lcom/whatsapp/data/ad$c;
      //   152: astore 7
      //   154: aload 7
      //   156: astore 5
      //   158: aload_0
      //   159: getfield 42	com/whatsapp/data/v$a:f	Lcom/whatsapp/wallpaper/g;
      //   162: invokestatic 151	com/whatsapp/u:a	()Landroid/content/Context;
      //   165: invokevirtual 156	com/whatsapp/wallpaper/g:e	(Landroid/content/Context;)V
      //   168: ldc -98
      //   170: invokestatic 81	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   173: aload_0
      //   174: getfield 46	com/whatsapp/data/v$a:h	Lcom/whatsapp/cc;
      //   177: invokevirtual 162	com/whatsapp/cc:b	()Z
      //   180: ifne +8 -> 188
      //   183: ldc -92
      //   185: invokestatic 132	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
      //   188: invokestatic 87	java/lang/System:currentTimeMillis	()J
      //   191: lstore_3
      //   192: aload_0
      //   193: getfield 34	com/whatsapp/data/v$a:b	J
      //   196: lconst_0
      //   197: lcmp
      //   198: ifle +34 -> 232
      //   201: aload_0
      //   202: getfield 34	com/whatsapp/data/v$a:b	J
      //   205: lload_3
      //   206: lload_1
      //   207: lsub
      //   208: lsub
      //   209: lstore_1
      //   210: lload_1
      //   211: lconst_0
      //   212: lcmp
      //   213: ifle +19 -> 232
      //   216: getstatic 166	com/whatsapp/data/ad$c:a	Lcom/whatsapp/data/ad$c;
      //   219: astore 7
      //   221: aload 5
      //   223: aload 7
      //   225: if_acmpne +7 -> 232
      //   228: lload_1
      //   229: invokestatic 172	java/lang/Thread:sleep	(J)V
      //   232: aload 5
      //   234: astore 7
      //   236: aload 6
      //   238: ifnull +29 -> 267
      //   241: aload 5
      //   243: astore 7
      //   245: aload 6
      //   247: invokevirtual 175	android/os/PowerManager$WakeLock:isHeld	()Z
      //   250: ifeq +17 -> 267
      //   253: aload 6
      //   255: invokevirtual 178	android/os/PowerManager$WakeLock:release	()V
      //   258: ldc -76
      //   260: invokestatic 81	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   263: aload 5
      //   265: astore 7
      //   267: aload 7
      //   269: areturn
      //   270: aload 6
      //   272: iconst_1
      //   273: ldc -74
      //   275: invokevirtual 188	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
      //   278: astore 6
      //   280: goto -253 -> 27
      //   283: ldc -66
      //   285: invokestatic 81	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   288: goto -162 -> 126
      //   291: astore 7
      //   293: ldc -64
      //   295: aload 7
      //   297: invokestatic 195	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   300: aload 5
      //   302: astore 7
      //   304: aload 6
      //   306: ifnull -39 -> 267
      //   309: aload 5
      //   311: astore 7
      //   313: aload 6
      //   315: invokevirtual 175	android/os/PowerManager$WakeLock:isHeld	()Z
      //   318: ifeq -51 -> 267
      //   321: aload 6
      //   323: invokevirtual 178	android/os/PowerManager$WakeLock:release	()V
      //   326: ldc -76
      //   328: invokestatic 81	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   331: aload 5
      //   333: areturn
      //   334: ldc -59
      //   336: invokestatic 72	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
      //   339: goto -213 -> 126
      //   342: astore 5
      //   344: aload 6
      //   346: ifnull +21 -> 367
      //   349: aload 6
      //   351: invokevirtual 175	android/os/PowerManager$WakeLock:isHeld	()Z
      //   354: ifeq +13 -> 367
      //   357: aload 6
      //   359: invokevirtual 178	android/os/PowerManager$WakeLock:release	()V
      //   362: ldc -76
      //   364: invokestatic 81	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   367: aload 5
      //   369: athrow
      //   370: astore 7
      //   372: aload 7
      //   374: invokestatic 200	com/whatsapp/util/Log:e	(Ljava/lang/Throwable;)V
      //   377: goto -145 -> 232
      //   380: astore 7
      //   382: goto -89 -> 293
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	385	0	this	a
      //   45	184	1	l1	long
      //   191	15	3	l2	long
      //   3	329	5	localObject1	Object
      //   342	26	5	localObject2	Object
      //   12	346	6	localObject3	Object
      //   55	213	7	localObject4	Object
      //   291	5	7	localException1	Exception
      //   302	10	7	localObject5	Object
      //   370	3	7	localInterruptedException	InterruptedException
      //   380	1	7	localException2	Exception
      //   62	32	8	arrayOfByte	byte[]
      //   77	34	9	localConditionVariable	android.os.ConditionVariable
      //   83	9	10	localw	w
      // Exception table:
      //   from	to	target	type
      //   32	37	291	java/lang/Exception
      //   37	64	291	java/lang/Exception
      //   69	126	291	java/lang/Exception
      //   126	154	291	java/lang/Exception
      //   283	288	291	java/lang/Exception
      //   334	339	291	java/lang/Exception
      //   32	37	342	finally
      //   37	64	342	finally
      //   69	126	342	finally
      //   126	154	342	finally
      //   158	188	342	finally
      //   188	210	342	finally
      //   216	221	342	finally
      //   228	232	342	finally
      //   283	288	342	finally
      //   293	300	342	finally
      //   334	339	342	finally
      //   372	377	342	finally
      //   228	232	370	java/lang/InterruptedException
      //   158	188	380	java/lang/Exception
      //   188	210	380	java/lang/Exception
      //   216	221	380	java/lang/Exception
      //   228	232	380	java/lang/Exception
      //   372	377	380	java/lang/Exception
    }
    
    protected final void onPreExecute()
    {
      this.g.a();
    }
  }
  
  static final class b
    extends Observable<v.c>
  {
    public final void a()
    {
      Iterator localIterator = new ArrayList(this.mObservers).iterator();
      while (localIterator.hasNext()) {
        ((v.c)localIterator.next()).a();
      }
    }
    
    public final void a(int paramInt)
    {
      Iterator localIterator = new ArrayList(this.mObservers).iterator();
      while (localIterator.hasNext()) {
        ((v.c)localIterator.next()).a(paramInt);
      }
    }
    
    public final void a(ad.c paramc)
    {
      Iterator localIterator = new ArrayList(this.mObservers).iterator();
      while (localIterator.hasNext()) {
        ((v.c)localIterator.next()).a(paramc);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
    
    public abstract void a(ad.c paramc);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/data/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */