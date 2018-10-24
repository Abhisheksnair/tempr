package com.whatsapp;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Looper;
import android.os.SystemClock;
import com.whatsapp.contact.sync.i;
import com.whatsapp.contact.sync.p;
import com.whatsapp.data.ad;
import com.whatsapp.data.ci;
import com.whatsapp.data.cl;
import com.whatsapp.data.o;
import com.whatsapp.fieldstats.e;
import com.whatsapp.g.j;
import com.whatsapp.gdrive.GoogleDriveService;
import com.whatsapp.gdrive.ch;
import com.whatsapp.messaging.m;
import com.whatsapp.registration.bb;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class AlarmService
  extends IntentService
{
  public static final String a = au.b() + ".action.DAILY_CRON";
  public static final String b = au.b() + ".action.HOURLY_CRON";
  public static final String c = au.b() + ".action.SETUP";
  private static final String l = au.b() + ".action.BACKUP_MESSAGES";
  private static final String m = au.b() + ".action.UPDATE_NTP";
  private static final String n = au.b() + ".action.ROTATE_SIGNED_PREKEY";
  private static final String o = au.b() + ".action.HEARTBEAT_WAKEUP";
  private final vv A = vv.a();
  private final ane B = ane.a();
  private final com.whatsapp.data.v C = com.whatsapp.data.v.a();
  private final aat D = aat.a();
  private final com.whatsapp.b.a E = com.whatsapp.b.a.a();
  private final atu F = atu.a();
  private final lt G = lt.a();
  private final bb H = bb.a();
  final oz d = oz.a();
  final ad e = ad.a();
  final att f = att.a();
  final com.whatsapp.a.c g = com.whatsapp.a.c.a();
  final cl h = cl.a();
  final atv i = atv.a();
  final o j = o.a();
  final ci k = ci.a();
  private final Random p = new Random();
  private String q = "2.android.pool.ntp.org";
  private final ant r = ant.a();
  private final com.whatsapp.util.a.c s = com.whatsapp.util.a.c.a();
  private final va t = va.a();
  private final com.whatsapp.data.d u = com.whatsapp.data.d.a();
  private final com.whatsapp.phoneid.a v = com.whatsapp.phoneid.a.a();
  private final m w = m.a();
  private final and x = and.a();
  private final aob y = aob.a();
  private final i z = i.a();
  
  public AlarmService()
  {
    super("AlarmService");
  }
  
  private void b()
  {
    Object localObject = Calendar.getInstance();
    if (((Calendar)localObject).get(11) >= 2) {
      ((Calendar)localObject).add(5, 1);
    }
    ((Calendar)localObject).set(14, 0);
    ((Calendar)localObject).set(13, 0);
    ((Calendar)localObject).set(12, 0);
    ((Calendar)localObject).set(11, 2);
    long l1 = ((Calendar)localObject).getTimeInMillis();
    Log.i("AlarmService setting next message backup alarm; alarmTimeMillis=" + new Date(l1));
    localObject = PendingIntent.getBroadcast(this, 0, new Intent(l, null, this, AlarmBroadcastReceiver.class), 0);
    AlarmManager localAlarmManager = (AlarmManager)getSystemService("alarm");
    localAlarmManager.cancel((PendingIntent)localObject);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localAlarmManager.setExactAndAllowWhileIdle(0, l1, (PendingIntent)localObject);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      localAlarmManager.setExact(0, l1, (PendingIntent)localObject);
      return;
    }
    localAlarmManager.set(0, l1, (PendingIntent)localObject);
  }
  
  private void c()
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).add(5, 1);
    ((Calendar)localObject).set(14, 0);
    ((Calendar)localObject).set(13, 0);
    ((Calendar)localObject).set(12, 0);
    ((Calendar)localObject).set(11, 0);
    long l1 = ((Calendar)localObject).getTimeInMillis();
    Log.i("AlarmService setting next daily cron; alarmTimeMillis=" + new Date(l1));
    localObject = PendingIntent.getBroadcast(this, 0, new Intent(a, null, this, AlarmBroadcastReceiver.class), 0);
    AlarmManager localAlarmManager = (AlarmManager)getSystemService("alarm");
    localAlarmManager.cancel((PendingIntent)localObject);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localAlarmManager.setExactAndAllowWhileIdle(0, l1, (PendingIntent)localObject);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      localAlarmManager.setExact(0, l1, (PendingIntent)localObject);
      return;
    }
    localAlarmManager.set(0, l1, (PendingIntent)localObject);
  }
  
  private void c(Intent paramIntent)
  {
    Log.i("AlarmService#heartbeatWakeup; intent=" + paramIntent);
    long l1 = ((j)b.a.a.c.a().a(j.class)).a();
    this.w.a(true, true, false, null, null, null, null, false);
    this.i.h(l1);
    e();
  }
  
  private void d()
  {
    long l1 = ((j)b.a.a.c.a().a(j.class)).a();
    if (!this.i.a.contains("dithered_last_signed_prekey_rotation"))
    {
      l2 = l1 - 1000L * this.p.nextInt(2592000);
      Log.i("no signed prekey rotation schedule established; setting last rotation time to " + com.whatsapp.util.l.a(l2));
      this.i.g(l2);
    }
    long l2 = this.i.x();
    if ((l2 < 0L) || (l2 > l1) || (l2 + 2592000000L < l1))
    {
      Log.i("scheduling immediate signed prekey rotation; now=" + com.whatsapp.util.l.a(l1) + "; lastSignedPrekeyRotation=" + com.whatsapp.util.l.a(l2));
      bu.a(q.a(this));
      return;
    }
    long l3 = l2 + 2592000000L - l1;
    Log.i("scheduling alarm to trigger signed prekey rotation; now=" + com.whatsapp.util.l.a(l1) + "; lastSignedPrekeyRotation=" + com.whatsapp.util.l.a(l2) + "; deltaToAlarm=" + l3);
    l1 = l3 + SystemClock.elapsedRealtime();
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(this, 0, new Intent(n, null, this, AlarmBroadcastReceiver.class), 0);
    AlarmManager localAlarmManager = (AlarmManager)getSystemService("alarm");
    if (Build.VERSION.SDK_INT >= 23)
    {
      localAlarmManager.setExactAndAllowWhileIdle(2, l1, localPendingIntent);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      localAlarmManager.setExact(2, l1, localPendingIntent);
      return;
    }
    localAlarmManager.set(2, l1, localPendingIntent);
  }
  
  private void e()
  {
    long l1 = ((j)b.a.a.c.a().a(j.class)).a();
    int i1 = aic.F;
    if (!this.i.a.contains("last_heartbeat_login"))
    {
      l2 = l1 - 1000L * this.p.nextInt(i1);
      this.i.h(l2);
      Log.i("no last heartbeat known; setting to " + com.whatsapp.util.l.a(l2));
    }
    long l2 = this.i.a.getLong("last_heartbeat_login", 0L);
    if ((l2 <= 0L) || (l2 > l1) || (aic.F * 1000 + l2 < l1))
    {
      c(null);
      return;
    }
    long l3 = i1;
    l1 = SystemClock.elapsedRealtime() + (l3 * 1000L + l2 - l1);
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(this, 0, new Intent(o, null, this, AlarmBroadcastReceiver.class), 0);
    AlarmManager localAlarmManager = (AlarmManager)getSystemService("alarm");
    if (Build.VERSION.SDK_INT >= 23)
    {
      localAlarmManager.setExactAndAllowWhileIdle(2, l1, localPendingIntent);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      localAlarmManager.setExact(2, l1, localPendingIntent);
      return;
    }
    localAlarmManager.set(2, l1, localPendingIntent);
  }
  
  private void f()
  {
    int i2 = 0;
    Object localObject = new Debug.MemoryInfo();
    Debug.getMemoryInfo((Debug.MemoryInfo)localObject);
    Log.i("device/memory private_dirty=" + ((Debug.MemoryInfo)localObject).getTotalPrivateDirty() + "kB pss=" + ((Debug.MemoryInfo)localObject).getTotalPss() + "kB shared_dirty=" + ((Debug.MemoryInfo)localObject).getTotalSharedDirty() + "kB");
    ActivityManager localActivityManager = this.x.b;
    if (localActivityManager == null)
    {
      Log.w("device/info am=null");
      localObject = null;
      if (localObject != null) {
        break label164;
      }
      Log.w("device/processes/none");
    }
    for (;;)
    {
      localObject = (com.whatsapp.g.d)b.a.a.c.a().a(com.whatsapp.g.d.class);
      Log.i("device/battery " + localObject);
      bu.a(anf.a(this.B));
      return;
      localObject = localActivityManager.getRunningAppProcesses();
      break;
      try
      {
        label164:
        int[] arrayOfInt = new int[((List)localObject).size()];
        int i1 = 0;
        while (i1 < ((List)localObject).size())
        {
          arrayOfInt[i1] = ((ActivityManager.RunningAppProcessInfo)((List)localObject).get(i1)).pid;
          i1 += 1;
        }
        localObject = localActivityManager.getProcessMemoryInfo(arrayOfInt);
        if (localObject != null)
        {
          int i3 = localObject.length;
          i1 = 0;
          while (i1 < i3)
          {
            i2 += localObject[i1].getTotalPss();
            i1 += 1;
          }
          Log.i("device/memory processes=" + localObject.length + " total=" + i2);
        }
      }
      catch (Exception localException)
      {
        Log.i("device/processes/error " + localException);
      }
    }
  }
  
  final void a()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      throw new IllegalThreadStateException("method should never be run from the UI thread");
    }
    pb.a(this, this.x, this.D);
    int i1 = this.i.R();
    switch (i1)
    {
    default: 
      Log.e("alarm-service/update-expensive-fieldstats/gdrive-backup/unexpected-frequency/" + i1);
      com.whatsapp.fieldstats.l.a(this, 345, Integer.valueOf(i1));
      if (this.i.ac() != null) {
        i1 = this.i.ad();
      }
      switch (i1)
      {
      default: 
        Log.e("alarm-service/update-expensive-fieldstats/gdrive-backup/unexpected-network-setting/" + i1);
        label168:
        com.whatsapp.fieldstats.l.a(this, 647, Integer.valueOf(i1));
        localObject = a.a.a.a.d.a(this.x, this.F, p.a);
        if (localObject != null) {
          com.whatsapp.fieldstats.l.a(this, 137, Long.valueOf(((Integer)localObject).longValue()));
        }
        pb.a(this.u, this.G);
        localObject = this.e;
        if (!((ad)localObject).e.exists()) {}
        break;
      }
      break;
    }
    for (Object localObject = Long.valueOf(((ad)localObject).e.length());; localObject = null)
    {
      if (localObject != null) {
        com.whatsapp.fieldstats.l.a(this, 241, localObject);
      }
      pb.a(this.d);
      com.whatsapp.fieldstats.l.a(this, 209, Long.valueOf(r.p()));
      if (r.p() <= 10) {
        com.whatsapp.fieldstats.l.a(this, 221, r.q());
      }
      com.whatsapp.fieldstats.l.a(this, 237, Boolean.valueOf(r.b()));
      com.whatsapp.fieldstats.l.a(this, 245, r.d());
      a.a.a.a.d.a(this, Boolean.valueOf(vv.i()));
      com.whatsapp.fieldstats.l.a(this, 625, Boolean.valueOf(true));
      com.whatsapp.fieldstats.l.a(this, 627, Boolean.valueOf(GoogleDriveService.c()));
      com.whatsapp.fieldstats.l.a(this, 771, Boolean.valueOf(ch.c()));
      com.whatsapp.fieldstats.l.a(this, 203, Boolean.valueOf(r.f()));
      com.whatsapp.fieldstats.l.a(this, 215, Boolean.valueOf(r.g()));
      com.whatsapp.fieldstats.l.a(this, 217, Boolean.valueOf(r.h()));
      switch (1.a[(aqe.a() - 1)])
      {
      default: 
        localObject = null;
        label459:
        com.whatsapp.fieldstats.l.a(this, 843, localObject);
        com.whatsapp.fieldstats.l.a(this, 797, Long.valueOf(this.F.a("android.permission.READ_CONTACTS")));
        com.whatsapp.fieldstats.l.a(this, 799, Long.valueOf(this.F.a("android.permission.WRITE_CONTACTS")));
        com.whatsapp.fieldstats.l.a(this, 801, Long.valueOf(this.F.a("android.permission.GET_ACCOUNTS")));
        if (Build.VERSION.SDK_INT >= 23) {
          break;
        }
      }
      for (i1 = 0;; i1 = this.F.a("android.permission.READ_EXTERNAL_STORAGE"))
      {
        com.whatsapp.fieldstats.l.a(this, 805, Long.valueOf(i1));
        com.whatsapp.fieldstats.l.a(this, 803, Long.valueOf(this.F.a("android.permission.WRITE_EXTERNAL_STORAGE")));
        com.whatsapp.fieldstats.l.a(this, 849, Long.valueOf(this.F.a("android.permission.RECORD_AUDIO")));
        com.whatsapp.fieldstats.l.a(this, 855, Long.valueOf(this.F.a("android.permission.CAMERA")));
        com.whatsapp.fieldstats.l.a(this, 851, Long.valueOf(this.F.a("android.permission.ACCESS_COARSE_LOCATION")));
        com.whatsapp.fieldstats.l.a(this, 853, Long.valueOf(this.F.a("android.permission.ACCESS_FINE_LOCATION")));
        com.whatsapp.fieldstats.l.a(this, 857, Long.valueOf(this.F.a("android.permission.RECEIVE_SMS")));
        com.whatsapp.fieldstats.l.a(this, 205, Boolean.valueOf(r.a(this.x, this.F)));
        com.whatsapp.fieldstats.l.a(this, 207, Boolean.valueOf(r.a()));
        com.whatsapp.fieldstats.l.a(this, 239, Long.valueOf(r.c()));
        localObject = this.i.ac();
        if (localObject != null)
        {
          long l1 = this.i.e((String)localObject);
          if ((l1 != 0L) && (l1 != -1L))
          {
            Log.i(String.format(Locale.ENGLISH, "alarm-service/update-expensive-fieldstats/last-backup-timestamp/%d", new Object[] { Long.valueOf(l1) }));
            com.whatsapp.fieldstats.l.a(this, 847, Long.valueOf(l1));
          }
        }
        com.whatsapp.fieldstats.l.a(this, 255, r.b(this));
        if (r.r()) {
          a.a.a.a.d.f(this, Boolean.valueOf(true));
        }
        localObject = new com.whatsapp.fieldstats.events.v();
        ((com.whatsapp.fieldstats.events.v)localObject).a = Long.valueOf(this.i.y());
        com.whatsapp.fieldstats.l.c(u.a(), (e)localObject);
        this.i.c().remove("decryption_failure_views").apply();
        return;
        i1 = 0;
        break;
        i1 = 1;
        break;
        i1 = 2;
        break;
        i1 = 3;
        break;
        i1 = 4;
        break;
        i1 = 0;
        break label168;
        i1 = 1;
        break label168;
        localObject = Integer.valueOf(0);
        break label459;
        localObject = Integer.valueOf(1);
        break label459;
        localObject = Integer.valueOf(2);
        break label459;
        localObject = Integer.valueOf(3);
        break label459;
      }
    }
  }
  
  /* Error */
  final void a(Intent paramIntent)
  {
    // Byte code:
    //   0: new 71	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 903
    //   7: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17: invokestatic 370	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: getfield 199	com/whatsapp/AlarmService:x	Lcom/whatsapp/and;
    //   24: getfield 906	com/whatsapp/and:a	Landroid/os/PowerManager;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnonnull +249 -> 278
    //   32: ldc_w 908
    //   35: invokestatic 678	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   38: aconst_null
    //   39: astore 12
    //   41: invokestatic 913	com/whatsapp/util/dns/b:a	()Lcom/whatsapp/util/dns/b;
    //   44: aload_0
    //   45: getfield 129	com/whatsapp/AlarmService:q	Ljava/lang/String;
    //   48: invokevirtual 916	com/whatsapp/util/dns/b:a	(Ljava/lang/String;)Ljava/util/List;
    //   51: astore_1
    //   52: new 918	org/a/a/a/a/a
    //   55: dup
    //   56: invokespecial 919	org/a/a/a/a/a:<init>	()V
    //   59: astore 14
    //   61: aload 14
    //   63: invokevirtual 921	org/a/a/a/a/a:d	()V
    //   66: aconst_null
    //   67: astore 13
    //   69: aload_1
    //   70: invokeinterface 922 1 0
    //   75: astore 15
    //   77: aload 13
    //   79: astore_1
    //   80: aload 15
    //   82: invokeinterface 433 1 0
    //   87: ifeq +153 -> 240
    //   90: aload 15
    //   92: invokeinterface 437 1 0
    //   97: checkcast 924	java/net/InetAddress
    //   100: astore 16
    //   102: aload 14
    //   104: invokevirtual 925	org/a/a/a/a/a:a	()V
    //   107: aload 14
    //   109: invokevirtual 926	org/a/a/a/a/a:c	()Z
    //   112: ifne +8 -> 120
    //   115: aload 14
    //   117: invokevirtual 925	org/a/a/a/a/a:a	()V
    //   120: new 928	org/a/a/a/a/b
    //   123: dup
    //   124: invokespecial 929	org/a/a/a/a/b:<init>	()V
    //   127: astore_1
    //   128: aload_1
    //   129: invokeinterface 932 1 0
    //   134: aload_1
    //   135: aload 14
    //   137: getfield 934	org/a/a/a/a/a:e	I
    //   140: invokeinterface 937 2 0
    //   145: aload_1
    //   146: invokeinterface 940 1 0
    //   151: astore 17
    //   153: aload 17
    //   155: aload 16
    //   157: invokevirtual 946	java/net/DatagramPacket:setAddress	(Ljava/net/InetAddress;)V
    //   160: aload 17
    //   162: bipush 123
    //   164: invokevirtual 949	java/net/DatagramPacket:setPort	(I)V
    //   167: new 928	org/a/a/a/a/b
    //   170: dup
    //   171: invokespecial 929	org/a/a/a/a/b:<init>	()V
    //   174: astore 18
    //   176: aload 18
    //   178: invokeinterface 940 1 0
    //   183: astore 19
    //   185: aload_1
    //   186: invokestatic 954	org/a/a/a/a/e:a	()Lorg/a/a/a/a/e;
    //   189: invokeinterface 957 2 0
    //   194: aload 14
    //   196: getfield 960	org/a/a/a/a/a:b	Ljava/net/DatagramSocket;
    //   199: aload 17
    //   201: invokevirtual 966	java/net/DatagramSocket:send	(Ljava/net/DatagramPacket;)V
    //   204: aload 14
    //   206: getfield 960	org/a/a/a/a/a:b	Ljava/net/DatagramSocket;
    //   209: aload 19
    //   211: invokevirtual 969	java/net/DatagramSocket:receive	(Ljava/net/DatagramPacket;)V
    //   214: new 971	org/a/a/a/a/d
    //   217: dup
    //   218: aload 18
    //   220: invokestatic 505	java/lang/System:currentTimeMillis	()J
    //   223: invokespecial 974	org/a/a/a/a/d:<init>	(Lorg/a/a/a/a/c;J)V
    //   226: astore_1
    //   227: aload 14
    //   229: invokevirtual 926	org/a/a/a/a/a:c	()Z
    //   232: ifeq +760 -> 992
    //   235: aload 14
    //   237: invokevirtual 976	org/a/a/a/a/a:b	()V
    //   240: aload_1
    //   241: ifnonnull +232 -> 473
    //   244: new 71	java/lang/StringBuilder
    //   247: dup
    //   248: ldc_w 978
    //   251: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   254: aload_0
    //   255: getfield 129	com/whatsapp/AlarmService:q	Ljava/lang/String;
    //   258: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 678	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   267: aload 12
    //   269: ifnull +8 -> 277
    //   272: aload 12
    //   274: invokevirtual 983	android/os/PowerManager$WakeLock:release	()V
    //   277: return
    //   278: aload_1
    //   279: iconst_1
    //   280: ldc_w 985
    //   283: invokevirtual 991	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   286: astore 12
    //   288: aload 12
    //   290: iconst_0
    //   291: invokevirtual 995	android/os/PowerManager$WakeLock:setReferenceCounted	(Z)V
    //   294: aload 12
    //   296: ldc2_w 996
    //   299: invokevirtual 1000	android/os/PowerManager$WakeLock:acquire	(J)V
    //   302: goto -261 -> 41
    //   305: astore_1
    //   306: new 71	java/lang/StringBuilder
    //   309: dup
    //   310: ldc_w 1002
    //   313: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   316: aload_0
    //   317: getfield 129	com/whatsapp/AlarmService:q	Ljava/lang/String;
    //   320: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: aload_1
    //   327: invokestatic 1005	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   330: aload 12
    //   332: ifnull -55 -> 277
    //   335: aload 12
    //   337: invokevirtual 983	android/os/PowerManager$WakeLock:release	()V
    //   340: return
    //   341: astore_1
    //   342: new 71	java/lang/StringBuilder
    //   345: dup
    //   346: ldc_w 1007
    //   349: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   352: aload_0
    //   353: getfield 129	com/whatsapp/AlarmService:q	Ljava/lang/String;
    //   356: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc_w 1009
    //   362: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 16
    //   367: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 678	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   376: aload 14
    //   378: invokevirtual 926	org/a/a/a/a/a:c	()Z
    //   381: ifeq -304 -> 77
    //   384: aload 14
    //   386: invokevirtual 976	org/a/a/a/a/a:b	()V
    //   389: goto -312 -> 77
    //   392: astore_1
    //   393: aload 12
    //   395: ifnull +8 -> 403
    //   398: aload 12
    //   400: invokevirtual 983	android/os/PowerManager$WakeLock:release	()V
    //   403: aload_1
    //   404: athrow
    //   405: astore_1
    //   406: new 71	java/lang/StringBuilder
    //   409: dup
    //   410: ldc_w 1011
    //   413: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   416: aload_0
    //   417: getfield 129	com/whatsapp/AlarmService:q	Ljava/lang/String;
    //   420: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: ldc_w 1009
    //   426: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload 16
    //   431: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: aload_1
    //   438: invokestatic 1005	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   441: aload 14
    //   443: invokevirtual 926	org/a/a/a/a/a:c	()Z
    //   446: ifeq -369 -> 77
    //   449: aload 14
    //   451: invokevirtual 976	org/a/a/a/a/a:b	()V
    //   454: goto -377 -> 77
    //   457: astore_1
    //   458: aload 14
    //   460: invokevirtual 926	org/a/a/a/a/a:c	()Z
    //   463: ifeq +8 -> 471
    //   466: aload 14
    //   468: invokevirtual 976	org/a/a/a/a/a:b	()V
    //   471: aload_1
    //   472: athrow
    //   473: aload_1
    //   474: getfield 1013	org/a/a/a/a/d:f	Z
    //   477: ifne +136 -> 613
    //   480: aload_1
    //   481: iconst_1
    //   482: putfield 1013	org/a/a/a/a/d:f	Z
    //   485: aload_1
    //   486: getfield 1016	org/a/a/a/a/d:b	Ljava/util/List;
    //   489: ifnonnull +14 -> 503
    //   492: aload_1
    //   493: new 423	java/util/ArrayList
    //   496: dup
    //   497: invokespecial 1017	java/util/ArrayList:<init>	()V
    //   500: putfield 1016	org/a/a/a/a/d:b	Ljava/util/List;
    //   503: aload_1
    //   504: getfield 1020	org/a/a/a/a/d:a	Lorg/a/a/a/a/c;
    //   507: invokeinterface 1022 1 0
    //   512: astore 13
    //   514: aload 13
    //   516: getfield 1024	org/a/a/a/a/e:a	J
    //   519: invokestatic 1027	org/a/a/a/a/e:a	(J)J
    //   522: lstore 6
    //   524: aload_1
    //   525: getfield 1020	org/a/a/a/a/d:a	Lorg/a/a/a/a/c;
    //   528: invokeinterface 1029 1 0
    //   533: astore 14
    //   535: aload 14
    //   537: getfield 1024	org/a/a/a/a/e:a	J
    //   540: invokestatic 1027	org/a/a/a/a/e:a	(J)J
    //   543: lstore 8
    //   545: aload_1
    //   546: getfield 1020	org/a/a/a/a/d:a	Lorg/a/a/a/a/c;
    //   549: invokeinterface 1031 1 0
    //   554: astore 15
    //   556: aload 15
    //   558: getfield 1024	org/a/a/a/a/e:a	J
    //   561: invokestatic 1027	org/a/a/a/a/e:a	(J)J
    //   564: lstore 10
    //   566: aload 13
    //   568: getfield 1024	org/a/a/a/a/e:a	J
    //   571: lconst_0
    //   572: lcmp
    //   573: ifne +147 -> 720
    //   576: aload 15
    //   578: getfield 1024	org/a/a/a/a/e:a	J
    //   581: lconst_0
    //   582: lcmp
    //   583: ifeq +121 -> 704
    //   586: aload_1
    //   587: lload 10
    //   589: aload_1
    //   590: getfield 1033	org/a/a/a/a/d:e	J
    //   593: lsub
    //   594: invokestatic 761	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   597: putfield 1035	org/a/a/a/a/d:d	Ljava/lang/Long;
    //   600: aload_1
    //   601: getfield 1016	org/a/a/a/a/d:b	Ljava/util/List;
    //   604: ldc_w 1037
    //   607: invokeinterface 1040 2 0
    //   612: pop
    //   613: new 71	java/lang/StringBuilder
    //   616: dup
    //   617: ldc_w 1042
    //   620: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   623: aload_1
    //   624: getfield 1035	org/a/a/a/a/d:d	Ljava/lang/Long;
    //   627: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   630: ldc_w 1044
    //   633: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: aload_1
    //   637: getfield 1046	org/a/a/a/a/d:c	Ljava/lang/Long;
    //   640: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   643: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   646: invokestatic 1048	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   649: aload_1
    //   650: getfield 1035	org/a/a/a/a/d:d	Ljava/lang/Long;
    //   653: astore_1
    //   654: aload_1
    //   655: ifnull +38 -> 693
    //   658: invokestatic 505	java/lang/System:currentTimeMillis	()J
    //   661: lstore_2
    //   662: invokestatic 629	android/os/SystemClock:elapsedRealtime	()J
    //   665: lstore 4
    //   667: aload_1
    //   668: invokevirtual 1049	java/lang/Long:longValue	()J
    //   671: lstore 6
    //   673: invokestatic 564	b/a/a/c:a	()Lb/a/a/c;
    //   676: new 566	com/whatsapp/g/j
    //   679: dup
    //   680: lload 6
    //   682: lload_2
    //   683: ladd
    //   684: lload 4
    //   686: lsub
    //   687: invokespecial 1050	com/whatsapp/g/j:<init>	(J)V
    //   690: invokevirtual 1053	b/a/a/c:c	(Ljava/lang/Object;)V
    //   693: aload 12
    //   695: ifnull -418 -> 277
    //   698: aload 12
    //   700: invokevirtual 983	android/os/PowerManager$WakeLock:release	()V
    //   703: return
    //   704: aload_1
    //   705: getfield 1016	org/a/a/a/a/d:b	Ljava/util/List;
    //   708: ldc_w 1055
    //   711: invokeinterface 1040 2 0
    //   716: pop
    //   717: goto -104 -> 613
    //   720: aload 14
    //   722: getfield 1024	org/a/a/a/a/e:a	J
    //   725: lconst_0
    //   726: lcmp
    //   727: ifeq +13 -> 740
    //   730: aload 15
    //   732: getfield 1024	org/a/a/a/a/e:a	J
    //   735: lconst_0
    //   736: lcmp
    //   737: ifne +108 -> 845
    //   740: aload_1
    //   741: getfield 1016	org/a/a/a/a/d:b	Ljava/util/List;
    //   744: ldc_w 1057
    //   747: invokeinterface 1040 2 0
    //   752: pop
    //   753: lload 6
    //   755: aload_1
    //   756: getfield 1033	org/a/a/a/a/d:e	J
    //   759: lcmp
    //   760: ifle +41 -> 801
    //   763: aload_1
    //   764: getfield 1016	org/a/a/a/a/d:b	Ljava/util/List;
    //   767: ldc_w 1059
    //   770: invokeinterface 1040 2 0
    //   775: pop
    //   776: aload 14
    //   778: getfield 1024	org/a/a/a/a/e:a	J
    //   781: lconst_0
    //   782: lcmp
    //   783: ifeq +35 -> 818
    //   786: aload_1
    //   787: lload 8
    //   789: lload 6
    //   791: lsub
    //   792: invokestatic 761	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   795: putfield 1035	org/a/a/a/a/d:d	Ljava/lang/Long;
    //   798: goto -185 -> 613
    //   801: aload_1
    //   802: aload_1
    //   803: getfield 1033	org/a/a/a/a/d:e	J
    //   806: lload 6
    //   808: lsub
    //   809: invokestatic 761	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   812: putfield 1046	org/a/a/a/a/d:c	Ljava/lang/Long;
    //   815: goto -39 -> 776
    //   818: aload 15
    //   820: getfield 1024	org/a/a/a/a/e:a	J
    //   823: lconst_0
    //   824: lcmp
    //   825: ifeq -212 -> 613
    //   828: aload_1
    //   829: lload 10
    //   831: aload_1
    //   832: getfield 1033	org/a/a/a/a/d:e	J
    //   835: lsub
    //   836: invokestatic 761	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   839: putfield 1035	org/a/a/a/a/d:d	Ljava/lang/Long;
    //   842: goto -229 -> 613
    //   845: aload_1
    //   846: getfield 1033	org/a/a/a/a/d:e	J
    //   849: lload 6
    //   851: lsub
    //   852: lstore 4
    //   854: lload 10
    //   856: lload 8
    //   858: lcmp
    //   859: ifge +136 -> 995
    //   862: aload_1
    //   863: getfield 1016	org/a/a/a/a/d:b	Ljava/util/List;
    //   866: ldc_w 1061
    //   869: invokeinterface 1040 2 0
    //   874: pop
    //   875: lload 4
    //   877: lstore_2
    //   878: aload_1
    //   879: lload_2
    //   880: invokestatic 761	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   883: putfield 1046	org/a/a/a/a/d:c	Ljava/lang/Long;
    //   886: lload 6
    //   888: aload_1
    //   889: getfield 1033	org/a/a/a/a/d:e	J
    //   892: lcmp
    //   893: ifle +16 -> 909
    //   896: aload_1
    //   897: getfield 1016	org/a/a/a/a/d:b	Ljava/util/List;
    //   900: ldc_w 1059
    //   903: invokeinterface 1040 2 0
    //   908: pop
    //   909: aload_1
    //   910: lload 8
    //   912: lload 6
    //   914: lsub
    //   915: lload 10
    //   917: aload_1
    //   918: getfield 1033	org/a/a/a/a/d:e	J
    //   921: lsub
    //   922: ladd
    //   923: ldc2_w 1062
    //   926: ldiv
    //   927: invokestatic 761	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   930: putfield 1035	org/a/a/a/a/d:d	Ljava/lang/Long;
    //   933: goto -320 -> 613
    //   936: lload_2
    //   937: lload 4
    //   939: lsub
    //   940: lconst_1
    //   941: lcmp
    //   942: ifne +31 -> 973
    //   945: lload 4
    //   947: lstore_2
    //   948: lload 4
    //   950: lconst_0
    //   951: lcmp
    //   952: ifeq -74 -> 878
    //   955: aload_1
    //   956: getfield 1016	org/a/a/a/a/d:b	Ljava/util/List;
    //   959: ldc_w 1065
    //   962: invokeinterface 1040 2 0
    //   967: pop
    //   968: lconst_0
    //   969: lstore_2
    //   970: goto -92 -> 878
    //   973: aload_1
    //   974: getfield 1016	org/a/a/a/a/d:b	Ljava/util/List;
    //   977: ldc_w 1067
    //   980: invokeinterface 1040 2 0
    //   985: pop
    //   986: lload 4
    //   988: lstore_2
    //   989: goto -111 -> 878
    //   992: goto -752 -> 240
    //   995: lload 10
    //   997: lload 8
    //   999: lsub
    //   1000: lstore_2
    //   1001: lload_2
    //   1002: lload 4
    //   1004: lcmp
    //   1005: ifgt -69 -> 936
    //   1008: lload 4
    //   1010: lload_2
    //   1011: lsub
    //   1012: lstore_2
    //   1013: goto -135 -> 878
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1016	0	this	AlarmService
    //   0	1016	1	paramIntent	Intent
    //   661	352	2	l1	long
    //   665	344	4	l2	long
    //   522	391	6	l3	long
    //   543	455	8	l4	long
    //   564	432	10	l5	long
    //   39	660	12	localWakeLock	android.os.PowerManager.WakeLock
    //   67	500	13	locale	org.a.a.a.a.e
    //   59	718	14	localObject1	Object
    //   75	744	15	localObject2	Object
    //   100	330	16	localInetAddress	java.net.InetAddress
    //   151	49	17	localDatagramPacket1	java.net.DatagramPacket
    //   174	45	18	localb	org.a.a.a.a.b
    //   183	27	19	localDatagramPacket2	java.net.DatagramPacket
    // Exception table:
    //   from	to	target	type
    //   41	52	305	java/net/UnknownHostException
    //   102	120	341	java/net/SocketTimeoutException
    //   120	227	341	java/net/SocketTimeoutException
    //   41	52	392	finally
    //   52	66	392	finally
    //   69	77	392	finally
    //   80	102	392	finally
    //   227	240	392	finally
    //   244	267	392	finally
    //   306	330	392	finally
    //   376	389	392	finally
    //   441	454	392	finally
    //   458	471	392	finally
    //   471	473	392	finally
    //   473	503	392	finally
    //   503	613	392	finally
    //   613	654	392	finally
    //   658	693	392	finally
    //   704	717	392	finally
    //   720	740	392	finally
    //   740	776	392	finally
    //   776	798	392	finally
    //   801	815	392	finally
    //   818	842	392	finally
    //   845	854	392	finally
    //   862	875	392	finally
    //   878	909	392	finally
    //   909	933	392	finally
    //   955	968	392	finally
    //   973	986	392	finally
    //   102	120	405	java/io/IOException
    //   120	227	405	java/io/IOException
    //   102	120	457	finally
    //   120	227	457	finally
    //   342	376	457	finally
    //   406	441	457	finally
  }
  
  /* Error */
  final void b(Intent paramIntent)
  {
    // Byte code:
    //   0: new 71	java/lang/StringBuilder
    //   3: dup
    //   4: ldc_w 1073
    //   7: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   10: aload_1
    //   11: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   14: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   17: invokestatic 370	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   20: aload_0
    //   21: getfield 199	com/whatsapp/AlarmService:x	Lcom/whatsapp/and;
    //   24: getfield 906	com/whatsapp/and:a	Landroid/os/PowerManager;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnonnull +42 -> 71
    //   32: ldc_w 1075
    //   35: invokestatic 678	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   38: aconst_null
    //   39: astore_1
    //   40: getstatic 1078	com/whatsapp/a/c:a	Ljava/util/concurrent/ExecutorService;
    //   43: aload_0
    //   44: invokestatic 1081	com/whatsapp/p:a	(Lcom/whatsapp/AlarmService;)Ljava/lang/Runnable;
    //   47: invokeinterface 1087 2 0
    //   52: invokeinterface 1091 1 0
    //   57: pop
    //   58: aload_0
    //   59: invokespecial 1092	com/whatsapp/AlarmService:d	()V
    //   62: aload_1
    //   63: ifnull +7 -> 70
    //   66: aload_1
    //   67: invokevirtual 983	android/os/PowerManager$WakeLock:release	()V
    //   70: return
    //   71: aload_1
    //   72: iconst_1
    //   73: ldc_w 1094
    //   76: invokevirtual 991	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   79: astore_1
    //   80: aload_1
    //   81: iconst_0
    //   82: invokevirtual 995	android/os/PowerManager$WakeLock:setReferenceCounted	(Z)V
    //   85: aload_1
    //   86: ldc2_w 996
    //   89: invokevirtual 1000	android/os/PowerManager$WakeLock:acquire	(J)V
    //   92: goto -52 -> 40
    //   95: astore_2
    //   96: new 1096	java/lang/AssertionError
    //   99: dup
    //   100: ldc_w 1098
    //   103: invokespecial 1100	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   106: astore_3
    //   107: aload_3
    //   108: aload_2
    //   109: invokevirtual 1104	java/lang/AssertionError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   112: pop
    //   113: aload_3
    //   114: athrow
    //   115: astore_2
    //   116: aload_1
    //   117: ifnull +7 -> 124
    //   120: aload_1
    //   121: invokevirtual 983	android/os/PowerManager$WakeLock:release	()V
    //   124: aload_2
    //   125: athrow
    //   126: astore_2
    //   127: new 1096	java/lang/AssertionError
    //   130: dup
    //   131: ldc_w 1106
    //   134: invokespecial 1100	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   137: astore_3
    //   138: aload_3
    //   139: aload_2
    //   140: invokevirtual 1104	java/lang/AssertionError:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   143: pop
    //   144: aload_3
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	AlarmService
    //   0	146	1	paramIntent	Intent
    //   95	14	2	localInterruptedException	InterruptedException
    //   115	10	2	localObject	Object
    //   126	14	2	localExecutionException	java.util.concurrent.ExecutionException
    //   106	39	3	localAssertionError	AssertionError
    // Exception table:
    //   from	to	target	type
    //   40	62	95	java/lang/InterruptedException
    //   40	62	115	finally
    //   96	115	115	finally
    //   127	146	115	finally
    //   40	62	126	java/util/concurrent/ExecutionException
  }
  
  /* Error */
  protected void onHandleIntent(Intent paramIntent)
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 1114	android/os/Process:setThreadPriority	(I)V
    //   5: aload_1
    //   6: ifnonnull +10 -> 16
    //   9: ldc_w 1116
    //   12: invokestatic 678	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   15: return
    //   16: aload_1
    //   17: invokevirtual 1119	android/content/Intent:getAction	()Ljava/lang/String;
    //   20: astore 15
    //   22: aload 15
    //   24: ifnonnull +15 -> 39
    //   27: ldc_w 1121
    //   30: invokestatic 678	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   33: aload_1
    //   34: invokestatic 1124	com/whatsapp/AlarmBroadcastReceiver:a	(Landroid/content/Intent;)Z
    //   37: pop
    //   38: return
    //   39: aload 15
    //   41: getstatic 90	com/whatsapp/AlarmService:l	Ljava/lang/String;
    //   44: invokestatic 1130	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   47: ifeq +286 -> 333
    //   50: new 71	java/lang/StringBuilder
    //   53: dup
    //   54: ldc_w 1132
    //   57: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   60: aload_1
    //   61: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   64: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 370	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   70: aload_0
    //   71: getfield 199	com/whatsapp/AlarmService:x	Lcom/whatsapp/and;
    //   74: getfield 906	com/whatsapp/and:a	Landroid/os/PowerManager;
    //   77: astore 16
    //   79: aload 16
    //   81: ifnonnull +58 -> 139
    //   84: ldc_w 1134
    //   87: invokestatic 678	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   90: aconst_null
    //   91: astore 15
    //   93: aload_0
    //   94: getfield 150	com/whatsapp/AlarmService:t	Lcom/whatsapp/va;
    //   97: getfield 1137	com/whatsapp/va:b	Lcom/whatsapp/Me;
    //   100: ifnull +13 -> 113
    //   103: aload_0
    //   104: getfield 171	com/whatsapp/AlarmService:e	Lcom/whatsapp/data/ad;
    //   107: invokevirtual 1139	com/whatsapp/data/ad:d	()Z
    //   110: ifne +57 -> 167
    //   113: ldc_w 1141
    //   116: invokestatic 370	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   119: aload_0
    //   120: invokespecial 1142	com/whatsapp/AlarmService:b	()V
    //   123: aload 15
    //   125: ifnull +8 -> 133
    //   128: aload 15
    //   130: invokevirtual 983	android/os/PowerManager$WakeLock:release	()V
    //   133: aload_1
    //   134: invokestatic 1124	com/whatsapp/AlarmBroadcastReceiver:a	(Landroid/content/Intent;)Z
    //   137: pop
    //   138: return
    //   139: aload 16
    //   141: iconst_1
    //   142: ldc_w 1144
    //   145: invokevirtual 991	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   148: astore 15
    //   150: aload 15
    //   152: iconst_0
    //   153: invokevirtual 995	android/os/PowerManager$WakeLock:setReferenceCounted	(Z)V
    //   156: aload 15
    //   158: ldc2_w 1145
    //   161: invokevirtual 1000	android/os/PowerManager$WakeLock:acquire	(J)V
    //   164: goto -71 -> 93
    //   167: aload_0
    //   168: getfield 220	com/whatsapp/AlarmService:A	Lcom/whatsapp/vv;
    //   171: invokevirtual 1147	com/whatsapp/vv:c	()Z
    //   174: ifeq +39 -> 213
    //   177: ldc_w 1149
    //   180: invokestatic 370	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   183: aload_0
    //   184: getfield 234	com/whatsapp/AlarmService:C	Lcom/whatsapp/data/v;
    //   187: aload_0
    //   188: getfield 220	com/whatsapp/AlarmService:A	Lcom/whatsapp/vv;
    //   191: getfield 1151	com/whatsapp/vv:a	Z
    //   194: putfield 1152	com/whatsapp/data/v:a	Z
    //   197: goto -78 -> 119
    //   200: astore_1
    //   201: aload 15
    //   203: ifnull +8 -> 211
    //   206: aload 15
    //   208: invokevirtual 983	android/os/PowerManager$WakeLock:release	()V
    //   211: aload_1
    //   212: athrow
    //   213: invokestatic 564	b/a/a/c:a	()Lb/a/a/c;
    //   216: ldc_w 682
    //   219: invokevirtual 569	b/a/a/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   222: checkcast 682	com/whatsapp/g/d
    //   225: astore 17
    //   227: aload 17
    //   229: ifnull +28 -> 257
    //   232: aload 17
    //   234: invokevirtual 1153	com/whatsapp/g/d:c	()Z
    //   237: ifne +20 -> 257
    //   240: ldc_w 1155
    //   243: invokestatic 370	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   246: aload_0
    //   247: getfield 234	com/whatsapp/AlarmService:C	Lcom/whatsapp/data/v;
    //   250: iconst_1
    //   251: putfield 1152	com/whatsapp/data/v:a	Z
    //   254: goto -135 -> 119
    //   257: ldc_w 1157
    //   260: invokestatic 370	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   263: aload_0
    //   264: getfield 234	com/whatsapp/AlarmService:C	Lcom/whatsapp/data/v;
    //   267: iconst_0
    //   268: putfield 1152	com/whatsapp/data/v:a	Z
    //   271: aload_0
    //   272: getfield 234	com/whatsapp/AlarmService:C	Lcom/whatsapp/data/v;
    //   275: iconst_1
    //   276: invokevirtual 1159	com/whatsapp/data/v:a	(Z)V
    //   279: aload 16
    //   281: ifnonnull +24 -> 305
    //   284: ldc_w 1161
    //   287: invokestatic 678	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   290: aconst_null
    //   291: astore 16
    //   293: aload_0
    //   294: aload 16
    //   296: invokestatic 1166	com/whatsapp/l:a	(Lcom/whatsapp/AlarmService;Landroid/os/PowerManager$WakeLock;)Ljava/lang/Runnable;
    //   299: invokestatic 617	com/whatsapp/util/bu:a	(Ljava/lang/Runnable;)V
    //   302: goto -183 -> 119
    //   305: aload 16
    //   307: iconst_1
    //   308: ldc_w 1168
    //   311: invokevirtual 991	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   314: astore 16
    //   316: aload 16
    //   318: iconst_0
    //   319: invokevirtual 995	android/os/PowerManager$WakeLock:setReferenceCounted	(Z)V
    //   322: aload 16
    //   324: ldc2_w 1169
    //   327: invokevirtual 1000	android/os/PowerManager$WakeLock:acquire	(J)V
    //   330: goto -37 -> 293
    //   333: aload 15
    //   335: getstatic 94	com/whatsapp/AlarmService:a	Ljava/lang/String;
    //   338: invokestatic 1130	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   341: ifeq +360 -> 701
    //   344: new 71	java/lang/StringBuilder
    //   347: dup
    //   348: ldc_w 1172
    //   351: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   354: aload_1
    //   355: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   358: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 370	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   364: aload_0
    //   365: getfield 199	com/whatsapp/AlarmService:x	Lcom/whatsapp/and;
    //   368: getfield 906	com/whatsapp/and:a	Landroid/os/PowerManager;
    //   371: astore 15
    //   373: aload 15
    //   375: ifnonnull +270 -> 645
    //   378: ldc_w 1174
    //   381: invokestatic 678	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   384: aconst_null
    //   385: astore 15
    //   387: invokestatic 1175	com/whatsapp/util/Log:d	()Z
    //   390: ifeq +283 -> 673
    //   393: ldc_w 1177
    //   396: invokestatic 1048	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   399: invokestatic 1180	com/whatsapp/util/Log:e	()Ljava/io/File;
    //   402: pop
    //   403: invokestatic 1182	com/whatsapp/util/Log:f	()V
    //   406: aload_0
    //   407: invokestatic 1185	com/whatsapp/m:a	(Lcom/whatsapp/AlarmService;)Ljava/lang/Runnable;
    //   410: invokestatic 617	com/whatsapp/util/bu:a	(Ljava/lang/Runnable;)V
    //   413: aload_0
    //   414: getfield 276	com/whatsapp/AlarmService:i	Lcom/whatsapp/atv;
    //   417: getfield 454	com/whatsapp/atv:a	Landroid/content/SharedPreferences;
    //   420: ldc_w 1187
    //   423: ldc2_w 1188
    //   426: invokeinterface 462 4 0
    //   431: lstore 5
    //   433: invokestatic 564	b/a/a/c:a	()Lb/a/a/c;
    //   436: ldc_w 566
    //   439: invokevirtual 569	b/a/a/c:a	(Ljava/lang/Class;)Ljava/lang/Object;
    //   442: checkcast 566	com/whatsapp/g/j
    //   445: invokevirtual 571	com/whatsapp/g/j:a	()J
    //   448: lstore 7
    //   450: lload 5
    //   452: lconst_0
    //   453: lcmp
    //   454: iflt +23 -> 477
    //   457: lload 5
    //   459: lload 7
    //   461: lcmp
    //   462: ifgt +15 -> 477
    //   465: lload 5
    //   467: ldc2_w 1190
    //   470: ladd
    //   471: lload 7
    //   473: lcmp
    //   474: ifge +41 -> 515
    //   477: new 1193	com/facebook/phoneid/PhoneIdRequester
    //   480: dup
    //   481: aload_0
    //   482: aload_0
    //   483: getfield 178	com/whatsapp/AlarmService:v	Lcom/whatsapp/phoneid/a;
    //   486: aconst_null
    //   487: invokespecial 1196	com/facebook/phoneid/PhoneIdRequester:<init>	(Landroid/content/Context;Lcom/facebook/phoneid/PhoneIdStore;Lcom/facebook/phoneid/PhoneIdUpdatedCallback;)V
    //   490: invokevirtual 1199	com/facebook/phoneid/PhoneIdRequester:startPhoneIdSynchronization	()V
    //   493: aload_0
    //   494: getfield 276	com/whatsapp/AlarmService:i	Lcom/whatsapp/atv;
    //   497: invokevirtual 467	com/whatsapp/atv:c	()Landroid/content/SharedPreferences$Editor;
    //   500: ldc_w 1187
    //   503: lload 7
    //   505: invokeinterface 473 4 0
    //   510: invokeinterface 476 1 0
    //   515: aload_0
    //   516: getfield 171	com/whatsapp/AlarmService:e	Lcom/whatsapp/data/ad;
    //   519: getfield 767	com/whatsapp/data/ad:e	Ljava/io/File;
    //   522: invokevirtual 772	java/io/File:exists	()Z
    //   525: ifeq +10 -> 535
    //   528: aload_0
    //   529: invokestatic 1202	com/whatsapp/n:a	(Lcom/whatsapp/AlarmService;)Ljava/lang/Runnable;
    //   532: invokestatic 617	com/whatsapp/util/bu:a	(Ljava/lang/Runnable;)V
    //   535: aload_0
    //   536: getfield 248	com/whatsapp/AlarmService:g	Lcom/whatsapp/a/c;
    //   539: invokevirtual 1203	com/whatsapp/a/c:b	()V
    //   542: aload_0
    //   543: getfield 255	com/whatsapp/AlarmService:E	Lcom/whatsapp/b/a;
    //   546: astore 17
    //   548: aload 17
    //   550: getfield 1206	com/whatsapp/b/a:a	Lcom/whatsapp/b/b;
    //   553: invokevirtual 1209	com/whatsapp/b/b:a	()Z
    //   556: ifeq +59 -> 615
    //   559: aload 17
    //   561: getfield 1212	com/whatsapp/b/a:b	Lcom/whatsapp/util/z;
    //   564: astore 16
    //   566: aload 16
    //   568: monitorenter
    //   569: aload 17
    //   571: getfield 1212	com/whatsapp/b/a:b	Lcom/whatsapp/util/z;
    //   574: invokevirtual 1217	com/whatsapp/util/z:clear	()V
    //   577: aload 17
    //   579: getfield 1220	com/whatsapp/b/a:c	Ljava/util/HashSet;
    //   582: invokevirtual 1223	java/util/HashSet:clear	()V
    //   585: aload 16
    //   587: monitorexit
    //   588: aload 17
    //   590: getfield 1206	com/whatsapp/b/a:a	Lcom/whatsapp/b/b;
    //   593: astore 16
    //   595: ldc_w 1225
    //   598: invokestatic 370	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   601: aload 16
    //   603: getfield 1228	com/whatsapp/b/b:a	Lcom/whatsapp/b/b$a;
    //   606: invokevirtual 1234	com/whatsapp/b/b$a:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   609: ldc_w 1236
    //   612: invokevirtual 1241	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   615: invokestatic 1244	com/whatsapp/acx:a	()V
    //   618: aload_0
    //   619: getfield 143	com/whatsapp/AlarmService:s	Lcom/whatsapp/util/a/c;
    //   622: invokestatic 1249	com/whatsapp/util/a/e:a	(Lcom/whatsapp/util/a/c;)Ljava/lang/Runnable;
    //   625: invokestatic 617	com/whatsapp/util/bu:a	(Ljava/lang/Runnable;)V
    //   628: aload_0
    //   629: invokespecial 1251	com/whatsapp/AlarmService:c	()V
    //   632: aload 15
    //   634: ifnull -501 -> 133
    //   637: aload 15
    //   639: invokevirtual 983	android/os/PowerManager$WakeLock:release	()V
    //   642: goto -509 -> 133
    //   645: aload 15
    //   647: iconst_1
    //   648: ldc_w 1253
    //   651: invokevirtual 991	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   654: astore 15
    //   656: aload 15
    //   658: iconst_0
    //   659: invokevirtual 995	android/os/PowerManager$WakeLock:setReferenceCounted	(Z)V
    //   662: aload 15
    //   664: ldc2_w 1145
    //   667: invokevirtual 1000	android/os/PowerManager$WakeLock:acquire	(J)V
    //   670: goto -283 -> 387
    //   673: ldc_w 1255
    //   676: invokestatic 1048	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   679: goto -276 -> 403
    //   682: astore_1
    //   683: aload 15
    //   685: ifnull +8 -> 693
    //   688: aload 15
    //   690: invokevirtual 983	android/os/PowerManager$WakeLock:release	()V
    //   693: aload_1
    //   694: athrow
    //   695: astore_1
    //   696: aload 16
    //   698: monitorexit
    //   699: aload_1
    //   700: athrow
    //   701: aload 15
    //   703: getstatic 98	com/whatsapp/AlarmService:b	Ljava/lang/String;
    //   706: invokestatic 1130	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   709: ifeq +797 -> 1506
    //   712: new 71	java/lang/StringBuilder
    //   715: dup
    //   716: ldc_w 1257
    //   719: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   722: aload_1
    //   723: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   726: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   729: invokestatic 370	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   732: aload_0
    //   733: invokespecial 1258	com/whatsapp/AlarmService:f	()V
    //   736: aload_0
    //   737: getfield 234	com/whatsapp/AlarmService:C	Lcom/whatsapp/data/v;
    //   740: invokevirtual 1259	com/whatsapp/data/v:b	()Z
    //   743: ifeq +685 -> 1428
    //   746: aload_0
    //   747: getfield 234	com/whatsapp/AlarmService:C	Lcom/whatsapp/data/v;
    //   750: iconst_0
    //   751: invokevirtual 1159	com/whatsapp/data/v:a	(Z)V
    //   754: aload_0
    //   755: getfield 199	com/whatsapp/AlarmService:x	Lcom/whatsapp/and;
    //   758: getfield 1262	com/whatsapp/and:e	Landroid/net/ConnectivityManager;
    //   761: astore 15
    //   763: aload 15
    //   765: ifnonnull +673 -> 1438
    //   768: ldc_w 1264
    //   771: invokestatic 678	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   774: iconst_0
    //   775: istore 11
    //   777: new 71	java/lang/StringBuilder
    //   780: dup
    //   781: ldc_w 1266
    //   784: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   787: iload 11
    //   789: invokevirtual 1269	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   792: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   795: invokestatic 370	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   798: iload 11
    //   800: ifne +28 -> 828
    //   803: aload_0
    //   804: getfield 276	com/whatsapp/AlarmService:i	Lcom/whatsapp/atv;
    //   807: iconst_1
    //   808: invokevirtual 1271	com/whatsapp/atv:c	(Z)V
    //   811: aload_0
    //   812: getfield 192	com/whatsapp/AlarmService:w	Lcom/whatsapp/messaging/m;
    //   815: invokevirtual 1272	com/whatsapp/messaging/m:b	()V
    //   818: aload_0
    //   819: getfield 227	com/whatsapp/AlarmService:B	Lcom/whatsapp/ane;
    //   822: ldc_w 1274
    //   825: invokevirtual 1276	com/whatsapp/ane:a	(Ljava/lang/String;)V
    //   828: ldc_w 1278
    //   831: invokestatic 1048	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   834: aload_0
    //   835: getfield 150	com/whatsapp/AlarmService:t	Lcom/whatsapp/va;
    //   838: getfield 1137	com/whatsapp/va:b	Lcom/whatsapp/Me;
    //   841: ifnull -708 -> 133
    //   844: aload_0
    //   845: getfield 304	com/whatsapp/AlarmService:H	Lcom/whatsapp/registration/bb;
    //   848: invokevirtual 1279	com/whatsapp/registration/bb:b	()Z
    //   851: ifeq -718 -> 133
    //   854: aload_0
    //   855: getfield 213	com/whatsapp/AlarmService:z	Lcom/whatsapp/contact/sync/i;
    //   858: astore 15
    //   860: ldc_w 1281
    //   863: invokestatic 1048	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   866: aload 15
    //   868: getfield 1283	com/whatsapp/contact/sync/i:f	Lcom/whatsapp/atv;
    //   871: invokevirtual 1285	com/whatsapp/atv:f	()J
    //   874: lconst_0
    //   875: lcmp
    //   876: ifge +572 -> 1448
    //   879: iconst_1
    //   880: istore 11
    //   882: aload 15
    //   884: getfield 1283	com/whatsapp/contact/sync/i:f	Lcom/whatsapp/atv;
    //   887: invokevirtual 1287	com/whatsapp/atv:g	()J
    //   890: invokestatic 505	java/lang/System:currentTimeMillis	()J
    //   893: lsub
    //   894: aload 15
    //   896: getfield 1283	com/whatsapp/contact/sync/i:f	Lcom/whatsapp/atv;
    //   899: invokevirtual 1285	com/whatsapp/atv:f	()J
    //   902: ladd
    //   903: lstore 5
    //   905: iload 11
    //   907: ifne +10 -> 917
    //   910: lload 5
    //   912: lconst_0
    //   913: lcmp
    //   914: ifgt +540 -> 1454
    //   917: iconst_1
    //   918: istore 13
    //   920: aload 15
    //   922: getfield 1283	com/whatsapp/contact/sync/i:f	Lcom/whatsapp/atv;
    //   925: astore 16
    //   927: aload 16
    //   929: getfield 454	com/whatsapp/atv:a	Landroid/content/SharedPreferences;
    //   932: ldc_w 1289
    //   935: aload 16
    //   937: invokevirtual 1287	com/whatsapp/atv:g	()J
    //   940: invokeinterface 462 4 0
    //   945: invokestatic 505	java/lang/System:currentTimeMillis	()J
    //   948: lsub
    //   949: aload 15
    //   951: getfield 1283	com/whatsapp/contact/sync/i:f	Lcom/whatsapp/atv;
    //   954: getfield 454	com/whatsapp/atv:a	Landroid/content/SharedPreferences;
    //   957: ldc_w 1291
    //   960: ldc2_w 849
    //   963: invokeinterface 462 4 0
    //   968: ladd
    //   969: lstore 7
    //   971: lload 7
    //   973: lconst_0
    //   974: lcmp
    //   975: ifgt +485 -> 1460
    //   978: iconst_1
    //   979: istore 14
    //   981: aload 15
    //   983: getfield 1283	com/whatsapp/contact/sync/i:f	Lcom/whatsapp/atv;
    //   986: astore 16
    //   988: aload 16
    //   990: getfield 454	com/whatsapp/atv:a	Landroid/content/SharedPreferences;
    //   993: ldc_w 1293
    //   996: aload 16
    //   998: invokevirtual 1287	com/whatsapp/atv:g	()J
    //   1001: invokeinterface 462 4 0
    //   1006: invokestatic 505	java/lang/System:currentTimeMillis	()J
    //   1009: lsub
    //   1010: aload 15
    //   1012: getfield 1283	com/whatsapp/contact/sync/i:f	Lcom/whatsapp/atv;
    //   1015: getfield 454	com/whatsapp/atv:a	Landroid/content/SharedPreferences;
    //   1018: ldc_w 1295
    //   1021: ldc2_w 849
    //   1024: invokeinterface 462 4 0
    //   1029: ladd
    //   1030: lstore 9
    //   1032: lload 9
    //   1034: lconst_0
    //   1035: lcmp
    //   1036: ifgt +430 -> 1466
    //   1039: iconst_1
    //   1040: istore 12
    //   1042: iload 13
    //   1044: ifne +13 -> 1057
    //   1047: iload 14
    //   1049: ifne +8 -> 1057
    //   1052: iload 12
    //   1054: ifeq +304 -> 1358
    //   1057: lload 5
    //   1059: ldc2_w 1296
    //   1062: lcmp
    //   1063: ifgt +409 -> 1472
    //   1066: iconst_1
    //   1067: istore_2
    //   1068: lload 7
    //   1070: ldc2_w 1296
    //   1073: lcmp
    //   1074: ifgt +403 -> 1477
    //   1077: iconst_1
    //   1078: istore_3
    //   1079: lload 9
    //   1081: ldc2_w 1296
    //   1084: lcmp
    //   1085: ifgt +397 -> 1482
    //   1088: iconst_1
    //   1089: istore 4
    //   1091: new 71	java/lang/StringBuilder
    //   1094: dup
    //   1095: ldc_w 1299
    //   1098: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1101: astore 16
    //   1103: aload 16
    //   1105: new 71	java/lang/StringBuilder
    //   1108: dup
    //   1109: ldc_w 1301
    //   1112: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1115: iload 13
    //   1117: invokevirtual 1269	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1120: ldc_w 1303
    //   1123: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: lload 5
    //   1128: ldc2_w 1304
    //   1131: ldiv
    //   1132: invokevirtual 624	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1135: ldc_w 1307
    //   1138: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1144: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: pop
    //   1148: iload 13
    //   1150: ifne +16 -> 1166
    //   1153: iload_2
    //   1154: ifeq +12 -> 1166
    //   1157: aload 16
    //   1159: ldc_w 1309
    //   1162: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1165: pop
    //   1166: aload 16
    //   1168: new 71	java/lang/StringBuilder
    //   1171: dup
    //   1172: ldc_w 1311
    //   1175: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1178: iload 14
    //   1180: invokevirtual 1269	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1183: ldc_w 1303
    //   1186: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: lload 7
    //   1191: ldc2_w 1304
    //   1194: ldiv
    //   1195: invokevirtual 624	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1198: ldc_w 1307
    //   1201: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1207: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: pop
    //   1211: iload 14
    //   1213: ifne +16 -> 1229
    //   1216: iload_3
    //   1217: ifeq +12 -> 1229
    //   1220: aload 16
    //   1222: ldc_w 1309
    //   1225: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1228: pop
    //   1229: aload 16
    //   1231: new 71	java/lang/StringBuilder
    //   1234: dup
    //   1235: ldc_w 1313
    //   1238: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1241: iload 12
    //   1243: invokevirtual 1269	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1246: ldc_w 1303
    //   1249: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1252: lload 9
    //   1254: ldc2_w 1304
    //   1257: ldiv
    //   1258: invokevirtual 624	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1261: ldc_w 1307
    //   1264: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1270: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1273: pop
    //   1274: iload 12
    //   1276: ifne +17 -> 1293
    //   1279: iload 4
    //   1281: ifeq +12 -> 1293
    //   1284: aload 16
    //   1286: ldc_w 1309
    //   1289: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1292: pop
    //   1293: aload 16
    //   1295: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1298: invokestatic 370	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1301: getstatic 1318	com/whatsapp/contact/sync/w:d	Lcom/whatsapp/contact/sync/w;
    //   1304: astore 16
    //   1306: iload 13
    //   1308: ifne +7 -> 1315
    //   1311: iload_2
    //   1312: ifeq +176 -> 1488
    //   1315: iconst_1
    //   1316: istore 13
    //   1318: iload 14
    //   1320: ifne +7 -> 1327
    //   1323: iload_3
    //   1324: ifeq +170 -> 1494
    //   1327: iconst_1
    //   1328: istore 14
    //   1330: iload 12
    //   1332: ifne +8 -> 1340
    //   1335: iload 4
    //   1337: ifeq +163 -> 1500
    //   1340: iconst_1
    //   1341: istore 12
    //   1343: aload 15
    //   1345: aload 16
    //   1347: iload 11
    //   1349: iload 13
    //   1351: iload 14
    //   1353: iload 12
    //   1355: invokevirtual 1321	com/whatsapp/contact/sync/i:a	(Lcom/whatsapp/contact/sync/w;ZZZZ)V
    //   1358: iload 11
    //   1360: ifeq -1227 -> 133
    //   1363: ldc_w 1323
    //   1366: invokestatic 370	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1369: aload 15
    //   1371: getfield 1326	com/whatsapp/contact/sync/i:a	Lcom/whatsapp/messaging/w;
    //   1374: invokevirtual 1330	com/whatsapp/messaging/w:g	()V
    //   1377: aload 15
    //   1379: getfield 1326	com/whatsapp/contact/sync/i:a	Lcom/whatsapp/messaging/w;
    //   1382: invokevirtual 1331	com/whatsapp/messaging/w:d	()V
    //   1385: aload 15
    //   1387: getfield 1333	com/whatsapp/contact/sync/i:b	Lcom/whatsapp/data/ad;
    //   1390: getfield 767	com/whatsapp/data/ad:e	Ljava/io/File;
    //   1393: invokevirtual 772	java/io/File:exists	()Z
    //   1396: ifeq -1263 -> 133
    //   1399: aload 15
    //   1401: getfield 1336	com/whatsapp/contact/sync/i:e	Lcom/whatsapp/data/co;
    //   1404: invokevirtual 1339	com/whatsapp/data/co:b	()Z
    //   1407: ifne -1274 -> 133
    //   1410: aload 15
    //   1412: getfield 1341	com/whatsapp/contact/sync/i:c	Lcom/whatsapp/att;
    //   1415: new 1343	com/whatsapp/jobqueue/job/GetStatusPrivacyJob
    //   1418: dup
    //   1419: invokespecial 1344	com/whatsapp/jobqueue/job/GetStatusPrivacyJob:<init>	()V
    //   1422: invokevirtual 1347	com/whatsapp/att:a	(Lorg/whispersystems/jobqueue/Job;)V
    //   1425: goto -1292 -> 133
    //   1428: aload_0
    //   1429: invokestatic 1350	com/whatsapp/o:a	(Lcom/whatsapp/AlarmService;)Ljava/lang/Runnable;
    //   1432: invokestatic 617	com/whatsapp/util/bu:a	(Ljava/lang/Runnable;)V
    //   1435: goto -681 -> 754
    //   1438: aload 15
    //   1440: invokevirtual 1355	android/net/ConnectivityManager:getBackgroundDataSetting	()Z
    //   1443: istore 11
    //   1445: goto -668 -> 777
    //   1448: iconst_0
    //   1449: istore 11
    //   1451: goto -569 -> 882
    //   1454: iconst_0
    //   1455: istore 13
    //   1457: goto -537 -> 920
    //   1460: iconst_0
    //   1461: istore 14
    //   1463: goto -482 -> 981
    //   1466: iconst_0
    //   1467: istore 12
    //   1469: goto -427 -> 1042
    //   1472: iconst_0
    //   1473: istore_2
    //   1474: goto -406 -> 1068
    //   1477: iconst_0
    //   1478: istore_3
    //   1479: goto -400 -> 1079
    //   1482: iconst_0
    //   1483: istore 4
    //   1485: goto -394 -> 1091
    //   1488: iconst_0
    //   1489: istore 13
    //   1491: goto -173 -> 1318
    //   1494: iconst_0
    //   1495: istore 14
    //   1497: goto -167 -> 1330
    //   1500: iconst_0
    //   1501: istore 12
    //   1503: goto -160 -> 1343
    //   1506: aload 15
    //   1508: getstatic 102	com/whatsapp/AlarmService:c	Ljava/lang/String;
    //   1511: invokestatic 1130	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1514: ifeq +237 -> 1751
    //   1517: new 71	java/lang/StringBuilder
    //   1520: dup
    //   1521: ldc_w 1357
    //   1524: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1527: aload_1
    //   1528: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1531: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1534: invokestatic 370	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   1537: aload_0
    //   1538: invokespecial 1142	com/whatsapp/AlarmService:b	()V
    //   1541: aload_0
    //   1542: invokespecial 1251	com/whatsapp/AlarmService:c	()V
    //   1545: aload_0
    //   1546: iconst_0
    //   1547: new 372	android/content/Intent
    //   1550: dup
    //   1551: getstatic 98	com/whatsapp/AlarmService:b	Ljava/lang/String;
    //   1554: aconst_null
    //   1555: aload_0
    //   1556: ldc_w 374
    //   1559: invokespecial 377	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;Landroid/content/Context;Ljava/lang/Class;)V
    //   1562: iconst_0
    //   1563: invokestatic 383	android/app/PendingIntent:getBroadcast	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   1566: astore 15
    //   1568: aload_0
    //   1569: ldc_w 385
    //   1572: invokevirtual 389	com/whatsapp/AlarmService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1575: checkcast 391	android/app/AlarmManager
    //   1578: astore 16
    //   1580: aload 16
    //   1582: aload 15
    //   1584: invokevirtual 395	android/app/AlarmManager:cancel	(Landroid/app/PendingIntent;)V
    //   1587: aload 16
    //   1589: iconst_3
    //   1590: lconst_0
    //   1591: ldc2_w 1358
    //   1594: aload 15
    //   1596: invokevirtual 1363	android/app/AlarmManager:setInexactRepeating	(IJJLandroid/app/PendingIntent;)V
    //   1599: aload_0
    //   1600: iconst_0
    //   1601: new 372	android/content/Intent
    //   1604: dup
    //   1605: getstatic 106	com/whatsapp/AlarmService:m	Ljava/lang/String;
    //   1608: aconst_null
    //   1609: aload_0
    //   1610: ldc_w 374
    //   1613: invokespecial 377	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;Landroid/content/Context;Ljava/lang/Class;)V
    //   1616: iconst_0
    //   1617: invokestatic 383	android/app/PendingIntent:getBroadcast	(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;
    //   1620: astore 15
    //   1622: aload_0
    //   1623: ldc_w 385
    //   1626: invokevirtual 389	com/whatsapp/AlarmService:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1629: checkcast 391	android/app/AlarmManager
    //   1632: astore 16
    //   1634: aload 16
    //   1636: aload 15
    //   1638: invokevirtual 395	android/app/AlarmManager:cancel	(Landroid/app/PendingIntent;)V
    //   1641: aload 16
    //   1643: iconst_3
    //   1644: lconst_0
    //   1645: ldc2_w 1364
    //   1648: aload 15
    //   1650: invokevirtual 1363	android/app/AlarmManager:setInexactRepeating	(IJJLandroid/app/PendingIntent;)V
    //   1653: aload_0
    //   1654: invokespecial 1092	com/whatsapp/AlarmService:d	()V
    //   1657: aload_0
    //   1658: invokespecial 578	com/whatsapp/AlarmService:e	()V
    //   1661: invokestatic 1371	android/content/res/Resources:getSystem	()Landroid/content/res/Resources;
    //   1664: ldc_w 1373
    //   1667: aconst_null
    //   1668: aconst_null
    //   1669: invokevirtual 1377	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   1672: istore_2
    //   1673: iload_2
    //   1674: ifne +19 -> 1693
    //   1677: aload_0
    //   1678: ldc 127
    //   1680: putfield 129	com/whatsapp/AlarmService:q	Ljava/lang/String;
    //   1683: aload_0
    //   1684: invokestatic 1380	com/whatsapp/k:a	(Lcom/whatsapp/AlarmService;)Ljava/lang/Runnable;
    //   1687: invokestatic 617	com/whatsapp/util/bu:a	(Ljava/lang/Runnable;)V
    //   1690: goto -1557 -> 133
    //   1693: aload_0
    //   1694: invokevirtual 1383	com/whatsapp/AlarmService:getResources	()Landroid/content/res/Resources;
    //   1697: iload_2
    //   1698: invokevirtual 1384	android/content/res/Resources:getString	(I)Ljava/lang/String;
    //   1701: astore 16
    //   1703: aload 16
    //   1705: astore 15
    //   1707: aload 16
    //   1709: invokestatic 1388	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1712: ifeq +13 -> 1725
    //   1715: ldc_w 1390
    //   1718: invokestatic 678	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1721: ldc 127
    //   1723: astore 15
    //   1725: aload_0
    //   1726: aload 15
    //   1728: putfield 129	com/whatsapp/AlarmService:q	Ljava/lang/String;
    //   1731: goto -48 -> 1683
    //   1734: astore 15
    //   1736: ldc_w 1392
    //   1739: aload 15
    //   1741: invokestatic 1005	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1744: ldc 127
    //   1746: astore 15
    //   1748: goto -23 -> 1725
    //   1751: aload 15
    //   1753: getstatic 106	com/whatsapp/AlarmService:m	Ljava/lang/String;
    //   1756: invokestatic 1130	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1759: ifeq +11 -> 1770
    //   1762: aload_0
    //   1763: aload_1
    //   1764: invokevirtual 1394	com/whatsapp/AlarmService:a	(Landroid/content/Intent;)V
    //   1767: goto -1634 -> 133
    //   1770: aload 15
    //   1772: getstatic 110	com/whatsapp/AlarmService:n	Ljava/lang/String;
    //   1775: invokestatic 1130	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1778: ifeq +11 -> 1789
    //   1781: aload_0
    //   1782: aload_1
    //   1783: invokevirtual 1396	com/whatsapp/AlarmService:b	(Landroid/content/Intent;)V
    //   1786: goto -1653 -> 133
    //   1789: aload 15
    //   1791: getstatic 114	com/whatsapp/AlarmService:o	Ljava/lang/String;
    //   1794: invokestatic 1130	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   1797: ifeq +11 -> 1808
    //   1800: aload_0
    //   1801: aload_1
    //   1802: invokespecial 639	com/whatsapp/AlarmService:c	(Landroid/content/Intent;)V
    //   1805: goto -1672 -> 133
    //   1808: new 71	java/lang/StringBuilder
    //   1811: dup
    //   1812: ldc_w 1398
    //   1815: invokespecial 358	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1818: aload_1
    //   1819: invokevirtual 366	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1822: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1825: invokestatic 678	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
    //   1828: goto -1695 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1831	0	this	AlarmService
    //   0	1831	1	paramIntent	Intent
    //   1067	631	2	i1	int
    //   1078	401	3	i2	int
    //   1089	395	4	i3	int
    //   431	696	5	l1	long
    //   448	742	7	l2	long
    //   1030	223	9	l3	long
    //   775	675	11	bool1	boolean
    //   1040	462	12	bool2	boolean
    //   918	572	13	bool3	boolean
    //   979	517	14	bool4	boolean
    //   20	1707	15	localObject1	Object
    //   1734	6	15	localNotFoundException	android.content.res.Resources.NotFoundException
    //   1746	44	15	str	String
    //   225	364	17	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   93	113	200	finally
    //   113	119	200	finally
    //   119	123	200	finally
    //   167	197	200	finally
    //   213	227	200	finally
    //   232	254	200	finally
    //   257	279	200	finally
    //   284	290	200	finally
    //   293	302	200	finally
    //   305	330	200	finally
    //   387	403	682	finally
    //   403	450	682	finally
    //   477	515	682	finally
    //   515	535	682	finally
    //   535	569	682	finally
    //   588	615	682	finally
    //   615	632	682	finally
    //   673	679	682	finally
    //   699	701	682	finally
    //   569	588	695	finally
    //   696	699	695	finally
    //   1693	1703	1734	android/content/res/Resources$NotFoundException
    //   1707	1721	1734	android/content/res/Resources$NotFoundException
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/AlarmService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */