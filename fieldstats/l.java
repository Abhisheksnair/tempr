package com.whatsapp.fieldstats;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.whatsapp.aic;
import com.whatsapp.atv;
import com.whatsapp.fieldstats.events.bw;
import com.whatsapp.util.Log;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class l
{
  private static final com.whatsapp.k.h h = new com.whatsapp.k.h(1, 20);
  private static l i = null;
  public final Handler a;
  public final Handler b;
  final CountDownLatch c = new CountDownLatch(1);
  final CountDownLatch d = new CountDownLatch(1);
  j e;
  private final File f;
  private final File g;
  private final b j = new b();
  private final f k = new f();
  private final c l = new c();
  private final b m = new b((byte)0);
  
  private l(Context paramContext)
  {
    this.f = new File(paramContext.getFilesDir(), "wastats.log");
    this.g = new File(paramContext.getFilesDir(), "wastats.log.0");
    HandlerThread localHandlerThread1 = new HandlerThread("Wam_internal");
    HandlerThread localHandlerThread2 = new HandlerThread("Wam_post");
    localHandlerThread1.start();
    localHandlerThread2.start();
    this.a = new Handler(localHandlerThread1.getLooper());
    this.b = new Handler(localHandlerThread2.getLooper());
    this.a.post(r.a(this, paramContext));
    this.b.post(s.a(this));
  }
  
  public static l a(Context paramContext)
  {
    try
    {
      if (i == null) {
        i = new l(paramContext);
      }
      paramContext = i;
      return paramContext;
    }
    finally {}
  }
  
  private void a(int paramInt)
  {
    a(paramInt, this.j.a(paramInt));
  }
  
  private void a(int paramInt, a parama)
  {
    Object localObject = this.e.e();
    if (!((j.a)localObject).a()) {
      throw new UnsupportedOperationException("No attribute value available for rotated buffer");
    }
    localObject = ((j.a)localObject).f.a(paramInt);
    if ((!this.l.a(paramInt)) && (!parama.equals(localObject))) {
      this.l.a(paramInt, parama);
    }
  }
  
  public static void a(Context paramContext, int paramInt, Object paramObject)
  {
    paramContext = a(paramContext);
    if (Looper.myLooper() == paramContext.a.getLooper())
    {
      paramContext.j.a(paramInt, paramObject);
      return;
    }
    paramContext.b.post(m.a(paramContext, paramInt, paramObject));
  }
  
  public static void a(Context paramContext, e parame)
  {
    c(paramContext, parame, 1);
  }
  
  public static void a(Context paramContext, e parame, int paramInt)
  {
    c(paramContext, parame, paramInt);
  }
  
  private void a(e parame)
  {
    this.l.a();
    long l1 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    this.j.a(47, Long.valueOf(l1));
    parame.serialize(this.m, null);
    parame = this.m;
    parame.a(1657);
    parame.a(1659);
    parame.a(21);
    parame.a(17);
    parame.a(495);
    parame.a(287);
    parame.a(289);
    parame.a(13);
    parame.a(5);
    parame.a(655);
    parame.a(3);
    parame.a(23);
    parame.a(105);
    parame.a(15);
    parame.a(11);
    parame.a(47);
    parame.a(689);
    parame = this.e.e();
    if (!parame.a()) {
      throw new UnsupportedOperationException("No attribute codes available for rotated buffer");
    }
    parame = Collections.unmodifiableCollection(parame.f.a.keySet()).iterator();
    while (parame.hasNext()) {
      a(((Integer)parame.next()).intValue());
    }
  }
  
  private void a(e parame, int paramInt, boolean paramBoolean)
  {
    e();
    this.k.a();
    this.k.a(parame.code, Integer.valueOf(paramInt));
    parame.serialize(null, new g(this));
    Object localObject1 = this.k;
    Object localObject2 = this.k;
    ((f)localObject1).a((byte)(localObject2.b.a()[localObject2.c] | 0x4));
    a(parame);
    if ((this.k.b.size() + this.l.b.size() > this.e.e().e()) && (!this.e.e().d()))
    {
      if (!this.e.b())
      {
        c();
        a(parame);
      }
    }
    else
    {
      if (this.k.b.size() + this.l.b.size() <= this.e.e().a.b.capacity() - j.h().length) {
        break label322;
      }
      Log.e("wamruntime/logevent: dropping event because it is larger than the buffer itself");
      return;
    }
    if (k.a().a == null) {
      k.a().a = Long.valueOf(0L);
    }
    if (k.a().b == null) {
      k.a().b = Long.valueOf(0L);
    }
    parame = k.a();
    parame.a = Long.valueOf(parame.a.longValue() + 1L);
    parame = k.a();
    parame.b = Long.valueOf(parame.b.longValue() + this.k.b.size());
    parame = k.a();
    parame.b = Long.valueOf(parame.b.longValue() + this.l.b.size());
    Log.w("wamruntime/logevent: no room for a new event record");
    return;
    label322:
    localObject2 = this.e;
    localObject1 = this.l;
    Object localObject3 = this.k;
    localObject2 = ((j)localObject2).e();
    if (((j.a)localObject2).d())
    {
      ((j.a)localObject2).a.a(j.h());
      localObject2.c.b[localObject2.b].b = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }
    if (((i)localObject1).b.size() + ((i)localObject3).b.size() > ((j.a)localObject2).e()) {
      throw new Error("Not enough space in the buffer");
    }
    ((j.a)localObject2).a.a(((i)localObject1).b.b());
    ((j.a)localObject2).a.a(((i)localObject3).b.b());
    ((j.a)localObject2).d += ((i)localObject1).d;
    ((j.a)localObject2).d += ((i)localObject3).d;
    ((j.a)localObject2).e += 1;
    localObject3 = Collections.unmodifiableCollection(((c)localObject1).a.keySet()).iterator();
    int n;
    while (((Iterator)localObject3).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject3).next();
      b localb = ((j.a)localObject2).f;
      paramInt = localInteger.intValue();
      n = localInteger.intValue();
      if (!((c)localObject1).a(n)) {
        throw new Error("The buffer does not contain the given attribute");
      }
      localb.a(paramInt, ((a)((c)localObject1).a.get(Integer.valueOf(n))).a);
    }
    label673:
    label684:
    int i1;
    label695:
    int i2;
    label706:
    int i3;
    label717:
    int i4;
    label728:
    int i5;
    label739:
    int i6;
    label750:
    int i7;
    label761:
    int i8;
    label772:
    int i9;
    label783:
    int i10;
    label794:
    int i11;
    label805:
    int i12;
    label816:
    int i13;
    label827:
    int i14;
    label838:
    int i15;
    label849:
    int i16;
    label860:
    int i17;
    if ((this.e.e().c() == 1) && (!paramBoolean))
    {
      if (!this.e.a) {
        k.a().t = Boolean.valueOf(true);
      }
      localObject1 = k.a();
      if (((bw)localObject1).a != null) {
        break label1077;
      }
      paramInt = 1;
      if (((bw)localObject1).b != null) {
        break label1082;
      }
      n = 1;
      if (((bw)localObject1).c != null) {
        break label1088;
      }
      i1 = 1;
      if (((bw)localObject1).d != null) {
        break label1094;
      }
      i2 = 1;
      if (((bw)localObject1).e != null) {
        break label1100;
      }
      i3 = 1;
      if (((bw)localObject1).f != null) {
        break label1106;
      }
      i4 = 1;
      if (((bw)localObject1).g != null) {
        break label1112;
      }
      i5 = 1;
      if (((bw)localObject1).h != null) {
        break label1118;
      }
      i6 = 1;
      if (((bw)localObject1).i != null) {
        break label1124;
      }
      i7 = 1;
      if (((bw)localObject1).j != null) {
        break label1130;
      }
      i8 = 1;
      if (((bw)localObject1).k != null) {
        break label1136;
      }
      i9 = 1;
      if (((bw)localObject1).l != null) {
        break label1142;
      }
      i10 = 1;
      if (((bw)localObject1).m != null) {
        break label1148;
      }
      i11 = 1;
      if (((bw)localObject1).n != null) {
        break label1154;
      }
      i12 = 1;
      if (((bw)localObject1).o != null) {
        break label1160;
      }
      i13 = 1;
      if (((bw)localObject1).p != null) {
        break label1166;
      }
      i14 = 1;
      if (((bw)localObject1).q != null) {
        break label1172;
      }
      i15 = 1;
      if (((bw)localObject1).r != null) {
        break label1178;
      }
      i16 = 1;
      if (((bw)localObject1).s != null) {
        break label1184;
      }
      i17 = 1;
      label871:
      if (((bw)localObject1).t != null) {
        break label1190;
      }
    }
    label1077:
    label1082:
    label1088:
    label1094:
    label1100:
    label1106:
    label1112:
    label1118:
    label1124:
    label1130:
    label1136:
    label1142:
    label1148:
    label1154:
    label1160:
    label1166:
    label1172:
    label1178:
    label1184:
    label1190:
    for (int i18 = 1;; i18 = 0)
    {
      if ((i18 & paramInt & 0x1 & n & i1 & i2 & i3 & i4 & i5 & i6 & i7 & i8 & i9 & i10 & i11 & i12 & i13 & i14 & i15 & i16 & i17) == 0) {
        a(k.a(), 0, true);
      }
      if (parame == k.a())
      {
        parame = k.a();
        parame.a = null;
        parame.b = null;
        parame.c = null;
        parame.d = null;
        parame.e = null;
        parame.f = null;
        parame.g = null;
        parame.h = null;
        parame.i = null;
        parame.j = null;
        parame.k = null;
        parame.l = null;
        parame.m = null;
        parame.n = null;
        parame.o = null;
        parame.p = null;
        parame.q = null;
        parame.r = null;
        parame.s = null;
        parame.t = null;
      }
      if (paramBoolean) {
        break;
      }
      this.e.d();
      return;
      paramInt = 0;
      break label673;
      n = 0;
      break label684;
      i1 = 0;
      break label695;
      i2 = 0;
      break label706;
      i3 = 0;
      break label717;
      i4 = 0;
      break label728;
      i5 = 0;
      break label739;
      i6 = 0;
      break label750;
      i7 = 0;
      break label761;
      i8 = 0;
      break label772;
      i9 = 0;
      break label783;
      i10 = 0;
      break label794;
      i11 = 0;
      break label805;
      i12 = 0;
      break label816;
      i13 = 0;
      break label827;
      i14 = 0;
      break label838;
      i15 = 0;
      break label849;
      i16 = 0;
      break label860;
      i17 = 0;
      break label871;
    }
  }
  
  private static void a(File paramFile)
  {
    if (paramFile.isFile())
    {
      Log.i("wamruntime/send: found old wam file " + paramFile.getAbsolutePath() + "; sending");
      byte[] arrayOfByte = b(paramFile);
      if ((arrayOfByte != null) && (a(arrayOfByte)))
      {
        Log.i("wamruntime/send: successfully sent old wam file " + paramFile.getAbsolutePath() + "; deleting");
        paramFile.delete();
      }
    }
  }
  
  private static boolean a(byte[] paramArrayOfByte)
  {
    return new a((byte)0).a(paramArrayOfByte);
  }
  
  private void b()
  {
    a(false);
    this.b.postDelayed(q.a(this), TimeUnit.SECONDS.toMillis(300L));
  }
  
  public static void b(Context paramContext, e parame)
  {
    if (h.a(1)) {
      c(paramContext, parame, h.b(1));
    }
  }
  
  /* Error */
  private static byte[] b(File paramFile)
  {
    // Byte code:
    //   0: new 543	java/io/RandomAccessFile
    //   3: dup
    //   4: aload_0
    //   5: ldc_w 544
    //   8: invokespecial 545	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   11: astore_3
    //   12: aload_3
    //   13: invokevirtual 548	java/io/RandomAccessFile:length	()J
    //   16: l2i
    //   17: newarray <illegal type>
    //   19: astore_0
    //   20: aload_3
    //   21: aload_0
    //   22: invokevirtual 552	java/io/RandomAccessFile:readFully	([B)V
    //   25: aload_3
    //   26: invokevirtual 555	java/io/RandomAccessFile:close	()V
    //   29: aload_0
    //   30: areturn
    //   31: astore_0
    //   32: aload_0
    //   33: athrow
    //   34: astore_1
    //   35: aload_0
    //   36: astore_2
    //   37: aload_1
    //   38: astore_0
    //   39: aload_2
    //   40: ifnull +9 -> 49
    //   43: aload_3
    //   44: invokevirtual 555	java/io/RandomAccessFile:close	()V
    //   47: aload_0
    //   48: athrow
    //   49: aload_3
    //   50: invokevirtual 555	java/io/RandomAccessFile:close	()V
    //   53: goto -6 -> 47
    //   56: astore_0
    //   57: goto +14 -> 71
    //   60: astore_1
    //   61: goto -14 -> 47
    //   64: astore_0
    //   65: aconst_null
    //   66: astore_2
    //   67: goto -28 -> 39
    //   70: astore_0
    //   71: aconst_null
    //   72: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramFile	File
    //   34	4	1	localObject	Object
    //   60	1	1	localThrowable	Throwable
    //   36	31	2	localFile	File
    //   11	39	3	localRandomAccessFile	java.io.RandomAccessFile
    // Exception table:
    //   from	to	target	type
    //   12	25	31	java/lang/Throwable
    //   32	34	34	finally
    //   0	12	56	java/lang/OutOfMemoryError
    //   25	29	56	java/lang/OutOfMemoryError
    //   43	47	56	java/lang/OutOfMemoryError
    //   47	49	56	java/lang/OutOfMemoryError
    //   49	53	56	java/lang/OutOfMemoryError
    //   43	47	60	java/lang/Throwable
    //   12	25	64	finally
    //   0	12	70	java/io/IOException
    //   25	29	70	java/io/IOException
    //   43	47	70	java/io/IOException
    //   47	49	70	java/io/IOException
    //   49	53	70	java/io/IOException
  }
  
  private void c()
  {
    j localj = this.e;
    if (localj.e().d()) {
      throw new Error("Rotation failed since the current event buffer is empty");
    }
    if (localj.b()) {
      throw new Error("Rotation failed since there is already a rotated buffer");
    }
    Log.i(String.format(Locale.US, "wambuffer/rotate: rotated event buffer %d: size = %d, event count = %d, timestamp = %d", new Object[] { Integer.valueOf(localj.c.a), Integer.valueOf(localj.e().a.b.position()), Integer.valueOf(localj.e().c()), Long.valueOf(localj.a()) }));
    localj.c.a = (1 - localj.c.a);
    localj.b = true;
    atv.a().d(false);
  }
  
  public static void c(Context paramContext, e parame)
  {
    c(paramContext, parame, 0);
  }
  
  private static void c(Context paramContext, e parame, int paramInt)
  {
    parame = (e)parame.clone();
    a(paramContext).b.post(n.a(paramContext, parame, paramInt));
  }
  
  private void d()
  {
    try
    {
      this.d.await();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Log.a("wamruntime: unexpected thread interrupt (" + localInterruptedException + ")");
      Thread.currentThread().interrupt();
    }
  }
  
  private void e()
  {
    try
    {
      this.c.await();
      d();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        Log.a("wamruntime: unexpected thread interrupt (" + localInterruptedException + ")");
        Thread.currentThread().interrupt();
      }
    }
  }
  
  final void a(boolean paramBoolean)
  {
    e();
    a(this.f);
    a(this.g);
    long l2;
    if ((!this.e.b()) && (!this.e.e().d()))
    {
      l2 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
      if (!atv.a().a.getBoolean("wam_is_current_buffer_real_time", false)) {
        break label157;
      }
    }
    j localj;
    label157:
    for (long l1 = 300L;; l1 = Math.max(aic.af, 300))
    {
      if ((paramBoolean) || (l2 - this.e.a() > l1)) {
        c();
      }
      if (!this.e.b()) {
        break label198;
      }
      Log.d("wamruntime/send: sending data");
      if (!a(this.e.c())) {
        break label191;
      }
      Log.i("wamruntime/send: successfully sent data; dropping the buffer");
      localj = this.e;
      if (localj.b()) {
        break;
      }
      throw new Error("Tried to drop empty buffer");
    }
    localj.f().f();
    localj.d();
    Log.i("wamruntime/sendack: dropped rotated buffer");
    return;
    label191:
    Log.i("wamruntime/send: failed to send data");
    return;
    label198:
    Log.d("wamruntime/send: not ready to send");
  }
  
  static final class a
  {
    volatile boolean a;
    
    /* Error */
    public final boolean a(byte[] paramArrayOfByte)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_0
      //   3: monitorenter
      //   4: aload_0
      //   5: iconst_0
      //   6: putfield 24	com/whatsapp/fieldstats/l$a:a	Z
      //   9: invokestatic 29	com/whatsapp/messaging/m:a	()Lcom/whatsapp/messaging/m;
      //   12: astore 4
      //   14: iload_3
      //   15: istore_2
      //   16: aload 4
      //   18: getfield 32	com/whatsapp/messaging/m:d	Z
      //   21: ifeq +59 -> 80
      //   24: iload_3
      //   25: istore_2
      //   26: invokestatic 38	com/whatsapp/Voip:e	()Z
      //   29: ifne +51 -> 80
      //   32: aload 4
      //   34: invokevirtual 42	com/whatsapp/messaging/m:f	()Ljava/lang/String;
      //   37: astore 5
      //   39: aload 4
      //   41: aload 5
      //   43: aconst_null
      //   44: iconst_0
      //   45: bipush 58
      //   47: iconst_0
      //   48: new 44	com/whatsapp/messaging/bs
      //   51: dup
      //   52: aload 5
      //   54: aload_1
      //   55: aload_0
      //   56: invokestatic 49	com/whatsapp/fieldstats/u:a	(Lcom/whatsapp/fieldstats/l$a;)Ljava/lang/Runnable;
      //   59: invokespecial 52	com/whatsapp/messaging/bs:<init>	(Ljava/lang/String;[BLjava/lang/Runnable;)V
      //   62: invokestatic 58	android/os/Message:obtain	(Landroid/os/Handler;IIILjava/lang/Object;)Landroid/os/Message;
      //   65: iconst_1
      //   66: invokevirtual 61	com/whatsapp/messaging/m:a	(Ljava/lang/String;Landroid/os/Message;Z)Ljava/util/concurrent/Future;
      //   69: invokeinterface 67 1 0
      //   74: pop
      //   75: aload_0
      //   76: getfield 24	com/whatsapp/fieldstats/l$a:a	Z
      //   79: istore_2
      //   80: aload_0
      //   81: monitorexit
      //   82: iload_2
      //   83: ireturn
      //   84: astore_1
      //   85: new 69	java/lang/StringBuilder
      //   88: dup
      //   89: ldc 71
      //   91: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   94: aload_1
      //   95: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   98: ldc 80
      //   100: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   103: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   106: invokestatic 90	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
      //   109: iload_3
      //   110: istore_2
      //   111: goto -31 -> 80
      //   114: astore_1
      //   115: aload_0
      //   116: monitorexit
      //   117: aload_1
      //   118: athrow
      //   119: astore_1
      //   120: iload_3
      //   121: istore_2
      //   122: goto -42 -> 80
      //   125: astore_1
      //   126: iload_3
      //   127: istore_2
      //   128: goto -48 -> 80
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	131	0	this	a
      //   0	131	1	paramArrayOfByte	byte[]
      //   15	113	2	bool1	boolean
      //   1	126	3	bool2	boolean
      //   12	28	4	localm	com.whatsapp.messaging.m
      //   37	16	5	str	String
      // Exception table:
      //   from	to	target	type
      //   39	75	84	com/whatsapp/messaging/m$b
      //   4	14	114	finally
      //   16	24	114	finally
      //   26	39	114	finally
      //   39	75	114	finally
      //   75	80	114	finally
      //   85	109	114	finally
      //   39	75	119	java/lang/InterruptedException
      //   39	75	125	java/util/concurrent/ExecutionException
    }
  }
  
  final class b
    implements d
  {
    private b() {}
    
    public final void a(int paramInt)
    {
      l.a(l.this, paramInt);
    }
    
    public final void a(int paramInt, Object paramObject)
    {
      l.a(l.this, paramInt, new a(paramObject));
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/fieldstats/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */