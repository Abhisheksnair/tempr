package com.whatsapp.gdrive;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.an.a;
import android.support.v4.app.an.d;
import android.support.v4.app.aw;
import b.a.a.c;
import com.whatsapp.aat;
import com.whatsapp.atv;
import com.whatsapp.g.f;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.be;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

public final class bk
  implements GoogleDriveService.e
{
  final AtomicReference<Integer> a = new AtomicReference(Integer.valueOf(10));
  final Context b;
  final aw c;
  boolean d;
  boolean e;
  int f;
  BroadcastReceiver g;
  BroadcastReceiver h;
  BroadcastReceiver i;
  final Object j = new Object()
  {
    public final void onEventAsync(f paramAnonymousf)
    {
      int i = ((Integer)bk.this.a.get()).intValue();
      int j = bk.this.k.a(true);
      if ((i == 28) && ((j == 2) || (j == 0)))
      {
        bk.this.a.set(Integer.valueOf(10));
        bk.this.a(bk.this.f, 100L);
      }
      if ((i == 16) && ((j == 2) || (j == 0)))
      {
        bk.this.a.set(Integer.valueOf(10));
        bk.this.g(bk.this.f, 100L);
      }
    }
  };
  final aat k;
  final atv l;
  private boolean m;
  private int n;
  private long o;
  private long p;
  private String q;
  private BroadcastReceiver r;
  
  public bk(Context paramContext, aat paramaat, atv paramatv)
  {
    this.b = paramContext;
    this.k = paramaat;
    this.c = aw.a(u.a());
    this.l = paramatv;
  }
  
  private void a(String arg1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, an.a parama)
  {
    boolean bool = true;
    if ((!paramBoolean1) && (SettingsGoogleDrive.r()))
    {
      d();
      return;
    }
    this.q = paramString2;
    if (this.m) {
      this.c.a(8);
    }
    an.d locald = new an.d(u.a());
    locald.a(2130840424);
    locald.a(PendingIntent.getActivity(u.a(), 0, new Intent(u.a(), SettingsGoogleDrive.class), 0));
    locald.e(this.b.getResources().getColor(2131624091));
    if (Build.VERSION.SDK_INT >= 21) {
      locald.c();
    }
    switch (paramInt1)
    {
    default: 
      throw new IllegalStateException("unexpected value for progress bar style" + paramInt1);
    case 1: 
      locald.a(0, 0, false);
      locald.c(paramBoolean2);
      locald.b(paramBoolean1);
      locald.a(???);
      locald.b(paramString2);
      this.e = paramBoolean1;
      if (parama != null)
      {
        paramBoolean1 = bool;
        label222:
        this.m = paramBoolean1;
        if (parama != null) {
          locald.a(parama);
        }
        ??? = new StringBuilder();
        if (paramInt1 != 2) {
          break label324;
        }
        ???.append("indeterminate");
      }
      break;
    }
    for (;;)
    {
      synchronized (this.c)
      {
        this.c.a(8, locald.e());
        return;
      }
      locald.a(100, paramInt2, false);
      break;
      locald.a(100, paramInt2, true);
      break;
      paramBoolean1 = false;
      break label222;
      label324:
      ???.append(paramInt2).append('%');
    }
  }
  
  public final void a()
  {
    String str = this.b.getString(2131296881);
    if (((Integer)this.a.getAndSet(Integer.valueOf(24))).intValue() != 24) {
      Log.i("gdrive-notification-manager/restore-prep-start");
    }
    a(str, this.b.getString(2131296875), 2, -1, true, false, null);
  }
  
  public final void a(int paramInt)
  {
    String str = this.b.getString(2131296881);
    if ((((Integer)this.a.get()).intValue() == 25) && (System.currentTimeMillis() - this.o < 200L)) {}
    for (;;)
    {
      return;
      this.o = System.currentTimeMillis();
      if (((Integer)this.a.getAndSet(Integer.valueOf(25))).intValue() != 25) {}
      for (int i1 = 1; (paramInt > 0) || (i1 != 0); i1 = 0)
      {
        a(str, this.b.getString(2131296876, new Object[] { Integer.valueOf(paramInt) }), 2, paramInt, true, false, null);
        return;
      }
    }
  }
  
  public final void a(int paramInt, Bundle paramBundle)
  {
    if (paramInt == 10) {}
    while (((Integer)this.a.getAndSet(Integer.valueOf(27))).intValue() == 27) {
      return;
    }
    Log.i("gdrive-notification-manager/media-restore-error/" + ch.a(paramInt));
    a(this.b.getString(2131296878), this.b.getString(2131298246), 1, -1, false, true, null);
  }
  
  public final void a(long paramLong1, long paramLong2)
  {
    if (((Integer)this.a.getAndSet(Integer.valueOf(28))).intValue() == 28) {
      return;
    }
    Log.i("gdrive-notification-manager/restore-paused-wifi-unavailable");
    if (this.h == null)
    {
      this.h = new BroadcastReceiver()
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          Log.i("gdrive-notification-manager/user-decided-to-restore-over-data-connection");
          paramAnonymousContext = new Intent(bk.this.b, SettingsGoogleDrive.class);
          paramAnonymousContext.setAction("action_perform_media_restore_over_cellular");
          paramAnonymousContext.setFlags(335544320);
          bk.this.b.startActivity(paramAnonymousContext);
          bk.this.b.unregisterReceiver(this);
          bk.this.c.a(8);
        }
      };
      this.b.registerReceiver(this.h, new IntentFilter("enable_restore_over_cellular"));
    }
    Object localObject1 = new Intent("enable_restore_over_cellular");
    Object localObject2 = PendingIntent.getBroadcast(this.b, 0, (Intent)localObject1, 0);
    localObject1 = null;
    if (this.k.a(true) == 2) {
      localObject1 = new an.a(2130840070, this.b.getString(2131296868), (PendingIntent)localObject2);
    }
    localObject2 = this.b.getString(2131296880);
    String str = this.b.getString(2131296874);
    if (paramLong2 > 0L) {}
    for (int i1 = (int)(100L * paramLong1 / paramLong2);; i1 = -1)
    {
      a((String)localObject2, str, 3, i1, false, true, (an.a)localObject1);
      return;
    }
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3)
  {
    for (;;)
    {
      try
      {
        String str3 = this.b.getString(2131296881);
        if (((Integer)this.a.get()).intValue() == 26)
        {
          long l1 = System.currentTimeMillis();
          long l2 = this.p;
          if (l1 - l2 < 200L) {
            return;
          }
        }
        this.p = System.currentTimeMillis();
        if (((Integer)this.a.getAndSet(Integer.valueOf(26))).intValue() != 26) {
          Log.i("gdrive-notification-manager/restore-progress " + paramLong1 + "/" + paramLong3 + " bytes (" + paramLong2 + " bytes failed).");
        }
        if (paramLong3 > 0L)
        {
          i1 = (int)(100L * paramLong1 / paramLong3);
          this.f = i1;
          if (paramLong2 <= 0L) {
            break label257;
          }
          String str1 = this.b.getString(2131296877, new Object[] { be.a(this.b, paramLong1), be.a(this.b, paramLong3), Integer.valueOf(this.f) });
          if (str1.equals(this.q)) {
            continue;
          }
          a(str3, str1, 3, this.f, true, false, null);
          continue;
        }
        int i1 = -1;
      }
      finally {}
      continue;
      label257:
      String str2 = this.b.getString(2131296871, new Object[] { be.a(this.b, paramLong1), be.a(this.b, paramLong3), Integer.valueOf(this.f) });
    }
  }
  
  public final void a(boolean paramBoolean) {}
  
  public final void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (((Integer)this.a.getAndSet(Integer.valueOf(33))).intValue() != 33)
    {
      localObject = new StringBuilder("gdrive-notification-manager/restore-end/");
      if (!paramBoolean) {
        break label90;
      }
    }
    label90:
    for (String str = "success";; str = "failed")
    {
      Log.i(str + " total: " + paramLong2 + " failed: " + paramLong1);
      if (paramLong2 != 0L) {
        break;
      }
      d();
      return;
    }
    Object localObject = this.b.getString(2131296879);
    if (paramLong1 > 0L) {}
    for (str = this.b.getString(2131296870, new Object[] { be.a(this.b, paramLong2 - paramLong1), be.a(this.b, paramLong1) });; str = this.b.getString(2131296869, new Object[] { be.a(this.b, paramLong2) }))
    {
      a((String)localObject, str, 1, -1, false, true, null);
      return;
    }
  }
  
  public final void b()
  {
    this.c.a(8);
  }
  
  public final void b(int paramInt)
  {
    if (!this.d) {}
    label127:
    for (;;)
    {
      return;
      if (((Integer)this.a.get()).intValue() != 12) {}
      for (int i1 = 1;; i1 = 0)
      {
        if ((((Integer)this.a.getAndSet(Integer.valueOf(12))).intValue() == 12) && (System.currentTimeMillis() - this.p < 200L)) {
          break label127;
        }
        this.p = System.currentTimeMillis();
        String str = this.b.getString(2131296851);
        if ((paramInt < 0) && (i1 == 0)) {
          break;
        }
        a(str, this.b.getString(2131296842, new Object[] { Integer.valueOf(paramInt) }), 2, -1, true, false, null);
        return;
      }
    }
  }
  
  public final void b(int paramInt, Bundle paramBundle)
  {
    Log.i("gdrive-notification-manager/msgstore-restore-error/" + ch.a(paramInt));
  }
  
  public final void b(long paramLong1, long paramLong2)
  {
    if (((Integer)this.a.getAndSet(Integer.valueOf(29))).intValue() == 29) {
      return;
    }
    Log.i("gdrive-notification-manager/restore-paused-data-unavailable");
    String str1 = this.b.getString(2131296880);
    String str2 = this.b.getString(2131296873);
    if (paramLong2 > 0L) {}
    for (int i1 = (int)(100L * paramLong1 / paramLong2);; i1 = -1)
    {
      a(str1, str2, 3, i1, false, true, null);
      return;
    }
  }
  
  public final void b(boolean paramBoolean) {}
  
  public final void c() {}
  
  public final void c(int paramInt)
  {
    if (!this.d) {}
    while ((((Integer)this.a.getAndSet(Integer.valueOf(22))).intValue() == 22) && (System.currentTimeMillis() - this.p < 200L)) {
      return;
    }
    this.p = System.currentTimeMillis();
    a(this.b.getString(2131296851), this.b.getString(2131297734, new Object[] { Integer.valueOf(paramInt) }), 2, paramInt, true, false, null);
  }
  
  public final void c(int paramInt, Bundle paramBundle)
  {
    int i1 = 2;
    if (paramInt == 10) {}
    boolean bool;
    do
    {
      do
      {
        return;
      } while (((Integer)this.a.getAndSet(Integer.valueOf(15))).intValue() == 15);
      Log.i("gdrive-notification-manager/backup-error/" + ch.a(paramInt));
      if (!this.d) {
        break;
      }
      Log.i("gdrive-notification-manager/backup-error/backup-user-initiated/true");
      bool = true;
    } while (!bool);
    a(this.b.getString(2131296843), this.b.getString(2131296840), 1, -1, false, true, null);
    return;
    int i2 = this.l.R();
    long l1;
    switch (i2)
    {
    default: 
      Log.e("gdrive-notification-manager/backup-error/unexpected-frequency/" + i2);
      l1 = 5184000000L;
      paramInt = i1;
      label180:
      i1 = this.l.Y();
      if ((i1 + 1) % paramInt == 0)
      {
        bool = true;
        label199:
        if (bool) {
          break label357;
        }
        paramBundle = this.l.ac();
        if (paramBundle == null) {
          break label351;
        }
        long l2 = this.l.e(paramBundle);
        if (System.currentTimeMillis() - l2 <= l1) {
          break label345;
        }
        bool = true;
      }
      break;
    }
    label345:
    label351:
    label357:
    for (;;)
    {
      Log.i("gdrive-notification-manager/backup-error/frequency=" + ch.d(i2) + "/success-backup-fail-count=" + i1 + "/show-notification=" + bool);
      break;
      l1 = 86400000L;
      paramInt = 1;
      break label180;
      l1 = 86400000L;
      paramInt = 1;
      break label180;
      paramInt = 5;
      l1 = 432000000L;
      break label180;
      l1 = 1209600000L;
      paramInt = i1;
      break label180;
      l1 = 5184000000L;
      paramInt = i1;
      break label180;
      bool = false;
      break label199;
      bool = false;
      continue;
      Log.e("gdrive-notification-manager/backup-error/google-account-is-null/unexpected");
    }
  }
  
  public final void c(long paramLong1, long paramLong2)
  {
    if (((Integer)this.a.getAndSet(Integer.valueOf(30))).intValue() == 30) {
      return;
    }
    Log.i("gdrive-notification-manager/restore-paused-for-battery");
    if (this.i == null)
    {
      this.i = new BroadcastReceiver()
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          Log.i("gdrive-notification-manager/user-decided-to-restore-over-low-battery");
          GoogleDriveService.c(bk.this.l);
          bk.this.b.unregisterReceiver(this);
          bk.this.c.a(8);
        }
      };
      this.b.registerReceiver(this.i, new IntentFilter("enable_restore_over_low_battery"));
    }
    Object localObject = new Intent("enable_restore_over_low_battery");
    localObject = PendingIntent.getBroadcast(this.b, 0, (Intent)localObject, 0);
    localObject = new an.a(2130840070, this.b.getString(2131296868), (PendingIntent)localObject);
    String str1 = this.b.getString(2131296880);
    String str2 = this.b.getString(2131296872);
    if (paramLong2 > 0L) {}
    for (int i1 = (int)(100L * paramLong1 / paramLong2);; i1 = -1)
    {
      a(str1, str2, 3, i1, false, true, (an.a)localObject);
      return;
    }
  }
  
  public final void c(boolean paramBoolean)
  {
    if (!this.d) {}
    while (((Integer)this.a.getAndSet(Integer.valueOf(23))).intValue() == 23) {
      return;
    }
    Log.i("gdrive-notification-manager/backup-end");
    this.n = 0;
    Context localContext = this.b;
    if (paramBoolean) {}
    for (int i1 = 2131296844;; i1 = 2131296843)
    {
      a(localContext.getString(i1), this.b.getString(2131296840), 1, -1, false, true, null);
      return;
    }
  }
  
  public final void d()
  {
    this.c.a(8);
  }
  
  public final void d(long paramLong1, long paramLong2)
  {
    if (((Integer)this.a.getAndSet(Integer.valueOf(31))).intValue() == 31) {
      return;
    }
    Log.i("gdrive-notification-manager/restore-paused-sdcard-unmounted");
    this.c.a(8);
    String str1 = this.b.getString(2131296880);
    String str2 = this.b.getString(2131298248);
    if (paramLong2 > 0L) {}
    for (int i1 = (int)(100L * paramLong1 / paramLong2);; i1 = -1)
    {
      a(str1, str2, 3, i1, false, true, null);
      return;
    }
  }
  
  public final void e()
  {
    if (!this.d) {
      d();
    }
    while (((Integer)this.a.getAndSet(Integer.valueOf(11))).intValue() == 11) {
      return;
    }
    Log.i("gdrive-notification-manager/backup-prep-start");
    a(this.b.getString(2131296851), this.b.getString(2131296841), 2, -1, true, false, null);
  }
  
  public final void e(long paramLong1, long paramLong2)
  {
    if (((Integer)this.a.getAndSet(Integer.valueOf(32))).intValue() == 32) {
      return;
    }
    Log.i("gdrive-notification-manager/restore-paused-sdcard-missing");
    String str1 = this.b.getString(2131296880);
    String str2 = this.b.getString(2131298247);
    if (paramLong2 > 0L) {}
    for (int i1 = (int)(100L * paramLong1 / paramLong2);; i1 = -1)
    {
      a(str1, str2, 3, i1, false, true, null);
      return;
    }
  }
  
  public final void f()
  {
    this.a.getAndSet(Integer.valueOf(13));
  }
  
  public final void f(long paramLong1, long paramLong2) {}
  
  public final void g()
  {
    if (!this.d) {}
    while (((Integer)this.a.getAndSet(Integer.valueOf(21))).intValue() == 21) {
      return;
    }
    Log.i("gdrive-notification-manager/backup-scrub-start");
    a(this.b.getString(2131296851), this.b.getString(2131297733), 2, -1, true, false, null);
  }
  
  public final void g(long paramLong1, long paramLong2)
  {
    if (!this.d) {}
    while (((Integer)this.a.getAndSet(Integer.valueOf(16))).intValue() == 16) {
      return;
    }
    Log.i("gdrive-notification-manager/backup-paused-wifi-unavailable");
    if (this.r == null)
    {
      this.r = new BroadcastReceiver()
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          Log.i("gdrive-notification-manager/user-decided-to-backup-over-data-connection");
          paramAnonymousContext = new Intent(bk.this.b, SettingsGoogleDrive.class);
          paramAnonymousContext.setAction("action_perform_backup_over_cellular");
          paramAnonymousContext.setFlags(335544320);
          bk.this.b.startActivity(paramAnonymousContext);
          bk.this.b.unregisterReceiver(this);
          bk.this.c.a(8);
        }
      };
      this.b.registerReceiver(this.r, new IntentFilter("enable_backup_over_cellular"));
    }
    Object localObject = new Intent("enable_backup_over_cellular");
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(this.b, 0, (Intent)localObject, 0);
    localObject = null;
    if (this.k.a(true) == 2) {
      localObject = new an.a(2130840070, this.b.getString(2131296868), localPendingIntent);
    }
    if (paramLong2 > 0L) {}
    for (int i1 = (int)(100L * paramLong1 / paramLong2);; i1 = -1)
    {
      a(this.b.getString(2131296852), this.b.getString(2131298244), 3, i1, false, false, (an.a)localObject);
      return;
    }
  }
  
  public final void h()
  {
    this.c.a(8);
  }
  
  public final void h(long paramLong1, long paramLong2)
  {
    if (!this.d) {}
    while (((Integer)this.a.getAndSet(Integer.valueOf(17))).intValue() == 17) {
      return;
    }
    Log.i("gdrive-notification-manager/backup-paused-for-data-connection");
    if (paramLong2 > 0L) {}
    for (int i1 = (int)(100L * paramLong1 / paramLong2);; i1 = -1)
    {
      a(this.b.getString(2131296852), this.b.getString(2131296873), 3, i1, false, false, null);
      return;
    }
  }
  
  public final void i() {}
  
  public final void i(long paramLong1, long paramLong2)
  {
    if (!this.d) {}
    while (((Integer)this.a.getAndSet(Integer.valueOf(18))).intValue() == 18) {
      return;
    }
    Log.i("gdrive-notification-manager/backup-paused-for-low-battery");
    if (this.g == null)
    {
      this.g = new BroadcastReceiver()
      {
        public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
        {
          Log.i("gdrive-notification-manager/user-decided-to-restore-over-low-battery");
          GoogleDriveService.b(bk.this.l);
          bk.this.b.unregisterReceiver(this);
          bk.this.c.a(8);
        }
      };
      this.b.registerReceiver(this.g, new IntentFilter("enable_backup_over_low_battery"));
    }
    Object localObject = new Intent("enable_backup_over_low_battery");
    localObject = PendingIntent.getBroadcast(this.b, 0, (Intent)localObject, 0);
    localObject = new an.a(2130840070, this.b.getString(2131296868), (PendingIntent)localObject);
    if (paramLong2 > 0L) {}
    for (int i1 = (int)(100L * paramLong1 / paramLong2);; i1 = -1)
    {
      a(this.b.getString(2131296852), this.b.getString(2131296872), 3, i1, false, false, (an.a)localObject);
      return;
    }
  }
  
  public final void j(long paramLong1, long paramLong2)
  {
    if (!this.d) {}
    while (((Integer)this.a.getAndSet(Integer.valueOf(19))).intValue() == 19) {
      return;
    }
    Log.i("gdrive-notification-manager/backup-paused-for-sdcard-unmounted");
    if (paramLong2 > 0L) {}
    for (int i1 = (int)(100L * paramLong1 / paramLong2);; i1 = -1)
    {
      a(this.b.getString(2131296852), this.b.getString(2131298248), 3, i1, false, false, null);
      return;
    }
  }
  
  public final void k(long paramLong1, long paramLong2)
  {
    if (!this.d) {}
    while (((Integer)this.a.getAndSet(Integer.valueOf(20))).intValue() == 20) {
      return;
    }
    Log.i("gdrive-notification-manager/backup-paused-for-sdcard-missing");
    if (paramLong2 > 0L) {}
    for (int i1 = (int)(100L * paramLong1 / paramLong2);; i1 = -1)
    {
      a(this.b.getString(2131296852), this.b.getString(2131298247), 3, i1, false, false, null);
      return;
    }
  }
  
  public final void l(long paramLong1, long paramLong2)
  {
    if (!this.d) {}
    label241:
    for (;;)
    {
      return;
      int i1 = 0;
      if (((Integer)this.a.get()).intValue() != 14) {
        i1 = 1;
      }
      if ((((Integer)this.a.getAndSet(Integer.valueOf(14))).intValue() != 14) || (System.currentTimeMillis() - this.p >= 200L))
      {
        this.p = System.currentTimeMillis();
        if (paramLong2 > 0L) {}
        for (int i2 = (int)(100L * paramLong1 / paramLong2);; i2 = 0)
        {
          if ((i2 - this.n <= 0) && (i1 == 0)) {
            break label241;
          }
          Log.i(String.format(Locale.ENGLISH, "gdrive-notification-manager/backup-progress %d/%d (%d)", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(i2) }));
          this.n = i2;
          String str1 = this.b.getString(2131296851);
          String str2 = this.b.getString(2131297754, new Object[] { be.a(this.b, paramLong1), be.a(this.b, paramLong2), Integer.valueOf(i2) });
          if (str2.equals(this.q)) {
            break;
          }
          a(str1, str2, 3, i2, true, false, null);
          return;
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gdrive/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */