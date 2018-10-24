package com.whatsapp.gdrive;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.app.m;
import android.support.v4.app.r;
import android.support.v4.app.w;
import android.support.v7.app.a;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import b.a.a.c;
import com.whatsapp.Main;
import com.whatsapp.RequestPermissionActivity;
import com.whatsapp.SettingsChat;
import com.whatsapp.aat;
import com.whatsapp.acy;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.av;
import com.whatsapp.data.ad;
import com.whatsapp.data.v;
import com.whatsapp.g.f;
import com.whatsapp.ng;
import com.whatsapp.nh;
import com.whatsapp.oz;
import com.whatsapp.pv;
import com.whatsapp.util.Log;
import com.whatsapp.util.bd;
import com.whatsapp.util.be;
import com.whatsapp.util.bu;
import com.whatsapp.util.l;
import com.whatsapp.vv;
import com.whatsapp.vv.a;

public class SettingsGoogleDrive
  extends nh
  implements co.b, es.a
{
  private static boolean y;
  private TextView A;
  private Button B;
  private TextView C;
  private ProgressBar D;
  private ImageView E;
  private View F;
  private View G;
  private TextView H;
  private CheckBox I;
  private String J;
  private View.OnClickListener K;
  private View.OnClickListener L;
  private View.OnClickListener M;
  private View.OnClickListener N;
  private Object O;
  private boolean P;
  private final aat Q = aat.a();
  private final v R = v.a();
  private final GoogleDriveService.e S = new GoogleDriveService.e()
  {
    private long b = -1L;
    private long c = -1L;
    private int d;
    
    private void a(int paramAnonymousInt1, String paramAnonymousString, View.OnClickListener paramAnonymousOnClickListener1, View.OnClickListener paramAnonymousOnClickListener2, int paramAnonymousInt2)
    {
      switch (paramAnonymousInt1)
      {
      default: 
      case 1: 
      case 2: 
        do
        {
          do
          {
            return;
          } while (this.d == 1);
          SettingsGoogleDrive.this.runOnUiThread(em.a(this));
          this.d = 1;
          return;
          if (this.d != 2)
          {
            SettingsGoogleDrive.this.runOnUiThread(en.a(this));
            this.d = 2;
          }
        } while (paramAnonymousString == null);
        throw new IllegalArgumentException("message should be null when button has to be displayed.");
      case 3: 
        a.d.a(paramAnonymousString);
        if (this.d != 3)
        {
          SettingsGoogleDrive.this.runOnUiThread(eo.a(this, paramAnonymousOnClickListener1));
          this.d = 3;
        }
        SettingsGoogleDrive.this.runOnUiThread(ee.a(this, paramAnonymousInt2, paramAnonymousString, paramAnonymousOnClickListener2));
        return;
      }
      a.d.a(paramAnonymousString);
      if (this.d != 4)
      {
        Log.i("settings-gdrive/set-message/show-indeterminate");
        Log.d("settings-gdrive/progress-bar-state-change " + this.d + " -> 4");
        SettingsGoogleDrive.this.runOnUiThread(ef.a(this, paramAnonymousOnClickListener1, paramAnonymousOnClickListener2));
        this.d = 4;
      }
      SettingsGoogleDrive.this.runOnUiThread(eg.a(this, paramAnonymousString));
    }
    
    public final void a()
    {
      Log.i("settings-gdrive-observer/restore-start");
      a(4, SettingsGoogleDrive.this.getString(2131297766), null, null, -1);
    }
    
    public final void a(int paramAnonymousInt)
    {
      if (paramAnonymousInt >= 0) {
        a(4, SettingsGoogleDrive.this.getString(2131297767, new Object[] { Integer.valueOf(paramAnonymousInt) }), null, null, paramAnonymousInt);
      }
    }
    
    public final void a(int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      if (paramAnonymousInt != 10) {
        a(1, null, null, null, -1);
      }
      SettingsGoogleDrive.this.runOnUiThread(eh.a(this, paramAnonymousInt, paramAnonymousBundle));
    }
    
    public final void a(long paramAnonymousLong1, long paramAnonymousLong2)
    {
      Log.i("settings-gdrive-observer/restore-paused/no-wifi");
      int i;
      if (paramAnonymousLong2 > 0L)
      {
        i = (int)(100L * paramAnonymousLong1 / paramAnonymousLong2);
        if (SettingsGoogleDrive.b(SettingsGoogleDrive.this).a(true) != 2) {
          break label73;
        }
        Log.i("settings-gdrive-observer/restore-paused/cellular-available");
      }
      label73:
      for (View.OnClickListener localOnClickListener = ej.a(this);; localOnClickListener = null)
      {
        a(3, SettingsGoogleDrive.this.getString(2131297768), null, localOnClickListener, i);
        return;
        i = -1;
        break;
      }
    }
    
    public final void a(long paramAnonymousLong1, long paramAnonymousLong2, long paramAnonymousLong3)
    {
      String str;
      if (paramAnonymousLong1 == 0L) {
        str = SettingsGoogleDrive.this.getString(2131298217);
      }
      for (;;)
      {
        if (!be.a(SettingsGoogleDrive.this, paramAnonymousLong1).equals(be.a(SettingsGoogleDrive.this, this.c)))
        {
          this.c = paramAnonymousLong1;
          a(3, SettingsGoogleDrive.this.getString(2131297769, new Object[] { str, be.a(SettingsGoogleDrive.this, paramAnonymousLong3), Long.valueOf(100L * paramAnonymousLong1 / paramAnonymousLong3) }), null, null, (int)(100L * paramAnonymousLong1 / paramAnonymousLong3));
        }
        return;
        if (paramAnonymousLong1 < 1024L) {
          str = SettingsGoogleDrive.this.getString(2131297247, new Object[] { Double.valueOf(paramAnonymousLong1) });
        } else {
          str = be.a(SettingsGoogleDrive.this, paramAnonymousLong1);
        }
      }
    }
    
    public final void a(boolean paramAnonymousBoolean)
    {
      Log.e("settings-gdrive-observer/account-deletion-end/unexpected-state");
    }
    
    public final void a(boolean paramAnonymousBoolean, long paramAnonymousLong1, long paramAnonymousLong2)
    {
      Log.i("settings-gdrive-observer/restore-end " + paramAnonymousBoolean);
      a(2, null, null, null, -1);
      this.c = -1L;
      this.b = -1L;
      if ((paramAnonymousBoolean) && (SettingsGoogleDrive.f(SettingsGoogleDrive.this) != null)) {
        SettingsGoogleDrive.f(SettingsGoogleDrive.this).h.d();
      }
    }
    
    public final void b()
    {
      Log.i("settings-gdrive-observer/restore-cancelled");
      SettingsGoogleDrive.this.runOnUiThread(el.a(this));
      a(2, null, null, null, -1);
      this.c = -1L;
      this.b = -1L;
    }
    
    public final void b(int paramAnonymousInt)
    {
      if (paramAnonymousInt >= 0)
      {
        a.d.c();
        a(4, SettingsGoogleDrive.this.getString(2131297753, new Object[] { Integer.valueOf(paramAnonymousInt) }), SettingsGoogleDrive.e(SettingsGoogleDrive.this), null, paramAnonymousInt);
      }
    }
    
    public final void b(int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      Log.e("settings-gdrive-observer/msgstore-download-error/unexpected-state");
    }
    
    public final void b(long paramAnonymousLong1, long paramAnonymousLong2)
    {
      Log.i("settings-gdrive-observer/restore-paused/no-data-connection");
      if (paramAnonymousLong2 > 0L) {}
      for (int i = (int)(100L * paramAnonymousLong1 / paramAnonymousLong2);; i = -1)
      {
        a(3, SettingsGoogleDrive.this.getString(2131297764), null, null, i);
        return;
      }
    }
    
    public final void b(boolean paramAnonymousBoolean)
    {
      Log.e("settings-gdrive-observer/msgstore-download-end/unexpected-state");
    }
    
    public final void c()
    {
      Log.e("settings-gdrive-observer/msgstore-download-start/unexpected-state");
    }
    
    public final void c(int paramAnonymousInt)
    {
      if (paramAnonymousInt >= 0) {
        a(4, SettingsGoogleDrive.this.getString(2131297734, new Object[] { Integer.valueOf(paramAnonymousInt) }), SettingsGoogleDrive.e(SettingsGoogleDrive.this), null, -1);
      }
    }
    
    public final void c(int paramAnonymousInt, Bundle paramAnonymousBundle)
    {
      if (paramAnonymousInt != 10) {
        a(2, null, null, null, -1);
      }
      SettingsGoogleDrive.this.runOnUiThread(ed.a(this, paramAnonymousInt, paramAnonymousBundle));
    }
    
    public final void c(long paramAnonymousLong1, long paramAnonymousLong2)
    {
      Log.i("settings-gdrive-observer/restore-paused/low-battery");
      if (paramAnonymousLong2 > 0L) {}
      for (int i = (int)(100L * paramAnonymousLong1 / paramAnonymousLong2);; i = -1)
      {
        View.OnClickListener localOnClickListener = ek.a(this);
        a(3, SettingsGoogleDrive.this.getString(2131297765), null, localOnClickListener, i);
        return;
      }
    }
    
    public final void c(boolean paramAnonymousBoolean)
    {
      Log.i("settings-gdrive-observer/backup-end " + paramAnonymousBoolean);
      a(2, null, null, null, -1);
      if ((paramAnonymousBoolean) && (SettingsGoogleDrive.f(SettingsGoogleDrive.this) != null)) {
        SettingsGoogleDrive.f(SettingsGoogleDrive.this).h.d();
      }
    }
    
    public final void d(long paramAnonymousLong1, long paramAnonymousLong2)
    {
      Log.i("settings-gdrive-observer/restore-paused/sdcard-unmounted");
      if (paramAnonymousLong2 > 0L) {}
      for (int i = (int)(100L * paramAnonymousLong1 / paramAnonymousLong2);; i = -1)
      {
        a(3, SettingsGoogleDrive.this.getString(2131296908), null, null, i);
        return;
      }
    }
    
    public final void e()
    {
      Log.i("settings-gdrive-observer/backup-prep-start");
      a(4, SettingsGoogleDrive.this.getString(2131297752), SettingsGoogleDrive.e(SettingsGoogleDrive.this), null, -1);
    }
    
    public final void e(long paramAnonymousLong1, long paramAnonymousLong2)
    {
      Log.i("settings-gdrive-observer/restore-paused/sdcard-missing");
      if (paramAnonymousLong2 > 0L) {}
      for (int i = (int)(100L * paramAnonymousLong1 / paramAnonymousLong2);; i = -1)
      {
        a(3, SettingsGoogleDrive.this.getString(2131296907), null, null, i);
        return;
      }
    }
    
    public final void f()
    {
      Log.i("settings-gdrive-observer/backup-start");
      this.b = -1L;
      b(0);
    }
    
    public final void f(long paramAnonymousLong1, long paramAnonymousLong2)
    {
      Log.e("settings-gdrive-observer/msgstore-download-progress/unexpected-state");
      Log.i("settings-gdrive-observer/msgstore-download-progress/downloaded: " + paramAnonymousLong1 + " total: " + paramAnonymousLong2);
    }
    
    public final void g()
    {
      Log.i("settings-gdrive-observer/post-backup-scrub-start");
      a(4, SettingsGoogleDrive.this.getString(2131297733), SettingsGoogleDrive.e(SettingsGoogleDrive.this), null, -1);
    }
    
    public final void g(long paramAnonymousLong1, long paramAnonymousLong2)
    {
      Log.i("settings-gdrive-observer/backup-paused/no-wifi");
      int i;
      if (paramAnonymousLong2 > 0L)
      {
        i = (int)(100L * paramAnonymousLong1 / paramAnonymousLong2);
        if (SettingsGoogleDrive.b(SettingsGoogleDrive.this).a(true) != 2) {
          break label73;
        }
      }
      label73:
      for (String str = SettingsGoogleDrive.this.getString(2131297750);; str = SettingsGoogleDrive.this.getString(2131297751))
      {
        a(3, str, SettingsGoogleDrive.e(SettingsGoogleDrive.this), null, i);
        return;
        i = -1;
        break;
      }
    }
    
    public final void h()
    {
      Log.i("settings-gdrive-observer/backup-cancelled");
      a(2, null, null, null, -1);
    }
    
    public final void h(long paramAnonymousLong1, long paramAnonymousLong2)
    {
      Log.i("settings-gdrive-observer/backup-paused/no-data-connection");
      if (paramAnonymousLong2 > 0L) {}
      for (int i = (int)(100L * paramAnonymousLong1 / paramAnonymousLong2);; i = -1)
      {
        a(3, SettingsGoogleDrive.this.getString(2131297756), SettingsGoogleDrive.e(SettingsGoogleDrive.this), null, i);
        return;
      }
    }
    
    public final void i()
    {
      SettingsGoogleDrive.this.runOnUiThread(ei.a(this));
    }
    
    public final void i(long paramAnonymousLong1, long paramAnonymousLong2)
    {
      Log.i("settings-gdrive-observer/backup-paused/low-battery");
      if (paramAnonymousLong2 > 0L) {}
      for (int i = (int)(100L * paramAnonymousLong1 / paramAnonymousLong2);; i = -1)
      {
        a(3, SettingsGoogleDrive.this.getString(2131297749), SettingsGoogleDrive.e(SettingsGoogleDrive.this), null, i);
        return;
      }
    }
    
    public final void j(long paramAnonymousLong1, long paramAnonymousLong2)
    {
      Log.i("settings-gdrive-observer/backup-paused/sdcard-unmounted");
      if (paramAnonymousLong2 > 0L) {}
      for (int i = (int)(100L * paramAnonymousLong1 / paramAnonymousLong2);; i = -1)
      {
        a(3, SettingsGoogleDrive.this.getString(2131298243), SettingsGoogleDrive.e(SettingsGoogleDrive.this), null, i);
        return;
      }
    }
    
    public final void k(long paramAnonymousLong1, long paramAnonymousLong2)
    {
      Log.i("settings-gdrive-observer/backup-paused/sdcard-missing");
      if (paramAnonymousLong2 > 0L) {}
      for (int i = (int)(100L * paramAnonymousLong1 / paramAnonymousLong2);; i = -1)
      {
        a(3, SettingsGoogleDrive.this.getString(2131296837), SettingsGoogleDrive.e(SettingsGoogleDrive.this), null, i);
        return;
      }
    }
    
    public final void l(long paramAnonymousLong1, long paramAnonymousLong2)
    {
      if (paramAnonymousLong2 <= 0L) {
        Log.e("settings-gdrive-observer/backup-progress incorrect invocation: " + paramAnonymousLong1 + "/" + paramAnonymousLong2);
      }
      String str;
      int i;
      int j;
      do
      {
        return;
        str = be.a(SettingsGoogleDrive.this, paramAnonymousLong1);
        i = (int)(this.b * 100L / paramAnonymousLong2);
        j = (int)(100L * paramAnonymousLong1 / paramAnonymousLong2);
      } while ((i == j) && (be.a(SettingsGoogleDrive.this, paramAnonymousLong1).equals(be.a(SettingsGoogleDrive.this, this.b))));
      this.b = paramAnonymousLong1;
      a(3, SettingsGoogleDrive.this.getString(2131297754, new Object[] { str, be.a(SettingsGoogleDrive.this, paramAnonymousLong2), Integer.valueOf(j) }), SettingsGoogleDrive.e(SettingsGoogleDrive.this), null, j);
    }
  };
  private final ServiceConnection T = new ServiceConnection()
  {
    public final void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
    {
      SettingsGoogleDrive.a(SettingsGoogleDrive.this, ((GoogleDriveService.f)paramAnonymousIBinder).a);
      paramAnonymousComponentName = SettingsGoogleDrive.f(SettingsGoogleDrive.this).h;
      if (!paramAnonymousComponentName.e) {
        paramAnonymousComponentName.d();
      }
      bu.a(eq.a(this));
      SettingsGoogleDrive.o(SettingsGoogleDrive.this).open();
      SettingsGoogleDrive.l(SettingsGoogleDrive.this);
      Log.i("settings-gdrive/service-connected");
    }
    
    public final void onServiceDisconnected(ComponentName paramAnonymousComponentName)
    {
      SettingsGoogleDrive.a(SettingsGoogleDrive.this, null);
      SettingsGoogleDrive.o(SettingsGoogleDrive.this).close();
      Log.i("settings-gdrive/service-disconnected");
    }
  };
  private final vv.a n = new vv.a()
  {
    private void e()
    {
      RequestPermissionActivity.b(SettingsGoogleDrive.this, 2131297425, 2131297424);
    }
    
    public final void a()
    {
      Log.i("settings-gdrive/readonly-external-storage-readonly");
      SettingsGoogleDrive localSettingsGoogleDrive = SettingsGoogleDrive.this;
      SettingsGoogleDrive.a(SettingsGoogleDrive.this);
      if (vv.i()) {}
      for (int i = 2131297502;; i = 2131297503)
      {
        localSettingsGoogleDrive.a(2131297202, i, new Object[0]);
        return;
      }
    }
    
    public final void b()
    {
      Log.i("settings-gdrive/external-storage-unavailable");
      d.a(SettingsGoogleDrive.this, 602);
    }
    
    public final void c()
    {
      Log.i("settings-gdrive/external-storage-unavailable-permission");
      e();
    }
    
    public final void d()
    {
      Log.i("settings-gdrive/readonly-external-storage-readonly-permission");
      e();
    }
  };
  ImageView o;
  TextView p;
  String[] q;
  final ConditionVariable r = new ConditionVariable(false);
  GoogleDriveService s = null;
  final ConditionVariable t = new ConditionVariable(false);
  boolean u;
  View v;
  protected final ad w = ad.a();
  private View z;
  
  static
  {
    if (!SettingsGoogleDrive.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      x = bool;
      return;
    }
  }
  
  private void l()
  {
    String str2 = SettingsChat.a(this.w, this, this.aF);
    String str3 = this.aQ.ac();
    if (str3 != null) {}
    for (long l = this.aQ.e(str3);; l = 0L)
    {
      String str1;
      if (l == 0L)
      {
        str1 = getString(2131297272);
        if (str3 == null) {
          break label331;
        }
      }
      label241:
      label331:
      for (l = this.aQ.f(str3);; l = -1L)
      {
        if (this.B != null)
        {
          if (l <= 0L) {
            break label241;
          }
          ((TextView)a.d.a((TextView)findViewById(2131755295))).setText(getString(2131297113, new Object[] { str2 }));
          ((TextView)a.d.a((TextView)findViewById(2131755296))).setText(getString(2131296921, new Object[] { str1 }));
          ((View)a.d.a(findViewById(2131755297))).setVisibility(0);
          ((TextView)a.d.a((TextView)findViewById(2131755297))).setText(getString(2131296920, new Object[] { be.a(this, l) }));
        }
        for (;;)
        {
          p();
          return;
          if (l == -1L)
          {
            str1 = getString(2131298061);
            break;
          }
          str1 = l.g(this, this.aF, l);
          break;
          ((TextView)a.d.a((TextView)findViewById(2131755295))).setText(getString(2131297113, new Object[] { str2 }));
          ((TextView)a.d.a((TextView)findViewById(2131755296))).setText(getString(2131296921, new Object[] { str1 }));
          ((View)a.d.a(findViewById(2131755297))).setVisibility(8);
        }
      }
    }
  }
  
  private void m()
  {
    bu.a(dj.a(this, AccountManager.get(this).addAccount("com.google", null, null, null, this, null, null)));
  }
  
  static boolean r()
  {
    return y;
  }
  
  public static void s()
  {
    ng localng = pv.a().e;
    if ((localng instanceof SettingsGoogleDrive)) {
      ((SettingsGoogleDrive)localng).l();
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    if (paramInt1 == 10)
    {
      paramArrayOfString = getResources().getStringArray(2131689484);
      if (paramInt2 > paramArrayOfString.length) {
        Log.e("settings-gdrive/change-freq/unexpected-choice/" + paramInt2);
      }
      int i;
      do
      {
        return;
        Log.i("settings-gdrive/change-freq/index:" + paramInt2 + "/value:" + paramArrayOfString[paramInt2]);
        paramInt1 = this.aQ.R();
        i = Integer.parseInt(paramArrayOfString[paramInt2]);
        if (!this.aQ.h(i))
        {
          Log.e("settings-gdrive/change-freq failed to set the new frequency.");
          return;
        }
        this.p.setText(this.q[paramInt2]);
        if ((i != 0) && (paramInt1 == 0) && (!ch.a(this.aQ)) && (!ch.c(this.aQ))) {
          this.z.performClick();
        }
      } while ((i != 0) || (GoogleDriveNewUserSetupActivity.n() >= System.currentTimeMillis() + 2592000000L));
      GoogleDriveNewUserSetupActivity.a(System.currentTimeMillis() + 2592000000L);
      return;
    }
    if (paramInt1 == 11)
    {
      paramArrayOfString = getResources().getStringArray(2131689486)[paramInt2];
      Log.i("settings-gdrive/backup-network/" + paramArrayOfString);
      this.H.setText(paramArrayOfString);
      bu.a(dk.a(this, paramInt2));
      return;
    }
    if (paramInt1 == 17)
    {
      if (paramArrayOfString[paramInt2].equals(getString(2131296918)))
      {
        m();
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("authAccount", paramArrayOfString[paramInt2]);
      onActivityResult(2, -1, localIntent);
      return;
    }
    throw new IllegalStateException("unexpected dialog box: " + paramInt1);
  }
  
  final boolean a(String paramString)
  {
    a.d.c();
    Log.i("settings-gdrive/auth-request account being used is " + ch.a(paramString));
    a locala = new a();
    runOnUiThread(ec.a(this, locala));
    this.r.close();
    bu.a(cu.a(this, paramString, locala));
    Log.i("settings-gdrive/auth-request blocking on tokenReceived");
    paramString = new bd("settings-gdrive/fetch-auth-token");
    this.r.block(30000L);
    if (this.J == null)
    {
      paramString = (m)j_().a("auth_request_dialog");
      if (paramString != null) {
        paramString.b();
      }
    }
    for (;;)
    {
      if (this.J != null)
      {
        return true;
        long l = paramString.b();
        if (l < 500L) {}
        try
        {
          Thread.sleep(500L - l);
          paramString = (m)j_().a("auth_request_dialog");
          if (paramString != null) {
            paramString.b();
          }
        }
        catch (InterruptedException paramString)
        {
          for (;;)
          {
            Log.d("settings-gdrive/auth-request", paramString);
          }
        }
      }
    }
    return false;
  }
  
  public void f(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException("unexpected dialog box: " + paramInt);
    case 12: 
      if (this.s != null)
      {
        this.s.b();
        return;
      }
      Log.e("settings-gdrive/cancel-media-restore google drive service object is null, unexpected.");
      return;
    case 13: 
      Log.i("settings-gdrive/perform-backup user decided to perform Google Drive backup over cellular (when the settings say Wi-Fi only)");
      GoogleDriveService.e(this.aQ);
      w();
      return;
    case 14: 
      Log.i("settings-gdrive/google-play-services-is-broken");
      this.aQ.h(0);
      this.p.setText(this.q[v()]);
      return;
    case 15: 
      Log.i("settings-gdrive/user-confirmed-media-restore-over-cellular");
      GoogleDriveService.f(this.aQ);
      return;
    }
    Log.i("settings-gdrive/user-confirmed-backup-over-cellular");
    GoogleDriveService.e(this.aQ);
  }
  
  public final void h(int paramInt)
  {
    switch (paramInt)
    {
    case 14: 
    default: 
      throw new IllegalStateException("unexpected dialog box: " + paramInt);
    case 12: 
      Log.i("settings-gdrive/cancel-media-restore-dialog/user-decided-not-to-cancel");
      return;
    case 13: 
      Log.i("settings-gdrive/perform-backup user declined to perform Google Drive backup over cellular (when the settings say Wi-Fi only)");
      return;
    case 15: 
      Log.i("settings-gdrive/user-declined-to-restore-media-over-cellular");
      return;
    }
    Log.i("settings-gdrive/user-declined-to-backup-over-cellular");
  }
  
  public final void i(int paramInt)
  {
    throw new IllegalStateException("unexpected dialog box: " + paramInt);
  }
  
  public final void j(int paramInt)
  {
    Log.i("settings-gdrive/dialogId-" + paramInt + "-dismissed");
  }
  
  protected void o()
  {
    this.aQ.h(0);
    this.p.setText(this.q[v()]);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.i("settings-gdrive/activity-result request: " + paramInt1 + " result: " + paramInt2);
    switch (paramInt1)
    {
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    label375:
    label385:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramIntent != null) {}
            for (paramIntent = paramIntent.getStringExtra("authAccount");; paramIntent = null)
            {
              Log.i("setting-gdrive/activity-result/account-picker accountName is " + ch.a(paramIntent));
              if ((paramInt2 != -1) || (paramIntent == null)) {
                break;
              }
              bu.a(cv.a(this, paramIntent));
              return;
            }
          } while (this.aQ.ac() != null);
          Log.i("setting-gdrive/activity-result/account-picker accountName is null");
          o();
          return;
          if (paramInt2 == -1)
          {
            this.J = paramIntent.getStringExtra("authtoken");
            this.r.open();
            Object localObject = (m)j_().a("auth_request_dialog");
            if (localObject != null) {
              ((m)localObject).b();
            }
            if (this.J != null)
            {
              paramIntent = paramIntent.getStringExtra("authAccount");
              if (TextUtils.equals(this.aQ.ac(), paramIntent)) {
                break label385;
              }
              if (!this.aQ.g(paramIntent)) {
                break label375;
              }
              if (this.s != null)
              {
                localObject = this.s;
                Log.i("gdrive-service/reset");
                ((GoogleDriveService)localObject).e = null;
                ((GoogleDriveService)localObject).f = null;
                ((GoogleDriveService)localObject).k = null;
                ((GoogleDriveService)localObject).i = null;
                ((GoogleDriveService)localObject).j = null;
              }
              Log.i("settings-gdrive/activity-result new accountName is " + ch.a(paramIntent));
              localObject = new Intent(this, GoogleDriveService.class);
              ((Intent)localObject).setAction("action_fetch_backup_info");
              ((Intent)localObject).putExtra("account_name", paramIntent);
              startService((Intent)localObject);
              runOnUiThread(cw.a(this, paramIntent));
            }
            for (;;)
            {
              bu.a(cx.a(this));
              return;
              b_(2131297772);
              continue;
              Log.i("settings-gdrive/activity-result account unchanged, token received for " + ch.a(paramIntent));
            }
          }
          paramIntent = (m)j_().a("auth_request_dialog");
        } while (paramIntent == null);
        paramIntent.b();
        return;
      } while (paramInt2 != -1);
      u();
      return;
    } while (paramInt2 != -1);
    if ((this.s != null) && (this.aQ.Q() == 23)) {
      this.s.a(10);
    }
    if ((ch.c(this.aQ)) || (ch.a(this.aQ)))
    {
      bu.a(cy.a(this));
      return;
    }
    t();
  }
  
  public void onBackPressed()
  {
    if (isTaskRoot()) {
      startActivity(new Intent(this, Main.class));
    }
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    int j = 0;
    super.onCreate(paramBundle);
    Log.i("settings-gdrive/create");
    setContentView(2130903078);
    i().a(true);
    this.v = ((View)a.d.a(findViewById(2131755271)));
    this.z = findViewById(2131755306);
    Object localObject = this.aQ.ac();
    if (localObject == null) {
      localObject = getString(2131297729);
    }
    for (;;)
    {
      this.A = ((TextView)findViewById(2131755308));
      if ((!x) && (this.A == null)) {
        throw new AssertionError();
      }
      this.A.setText((CharSequence)localObject);
      this.B = ((Button)findViewById(2131755299));
      if ((GoogleDriveService.a()) || (ch.c(this.aQ))) {
        this.B.setVisibility(8);
      }
      this.C = ((TextView)findViewById(2131755302));
      localObject = (TextView)a.d.a((TextView)findViewById(2131755298));
      int i;
      if (vv.i())
      {
        i = 2131297740;
        ((TextView)localObject).setText(i);
        this.D = ((ProgressBar)findViewById(2131755274));
        d.a(this.D, getResources().getColor(2131624069));
        this.o = ((ImageView)findViewById(2131755300));
        this.E = ((ImageView)findViewById(2131755301));
        this.F = findViewById(2131755304);
        this.p = ((TextView)findViewById(2131755305));
        this.q = getResources().getStringArray(2131689483);
        i = 0;
      }
      for (;;)
      {
        if (i < this.q.length)
        {
          if (getString(2131297736).equals(this.q[i])) {
            this.q[i] = getString(2131297736, new Object[] { getString(2131298267) });
          }
        }
        else
        {
          this.p.setText(this.q[v()]);
          this.G = findViewById(2131755310);
          this.H = ((TextView)findViewById(2131755311));
          localObject = getResources().getStringArray(2131689486)[this.aQ.ad()];
          this.H.setText((CharSequence)localObject);
          this.I = ((CheckBox)findViewById(2131755314));
          this.I.setChecked(this.aQ.ae());
          this.L = ct.a(this);
          this.M = de.a(this);
          this.N = dp.a(this);
          this.B.setOnClickListener(this.L);
          this.z.setOnClickListener(dx.a(this));
          l();
          this.G.setOnClickListener(dy.a(this));
          this.F.setOnClickListener(dz.a(this));
          ((View)a.d.a(findViewById(2131755312))).setOnClickListener(ea.a(this));
          bindService(new Intent(this, GoogleDriveService.class), this.T, 1);
          if (!GoogleDriveService.c())
          {
            Log.i("settings-gdrive/create google drive access not allowed.");
            finish();
          }
          i = j;
          if (paramBundle != null)
          {
            i = j;
            if (paramBundle.getBoolean("intent_already_parsed", false)) {
              i = 1;
            }
          }
          if (i == 0)
          {
            paramBundle = getIntent();
            if ((paramBundle != null) && (paramBundle.getAction() != null)) {
              onNewIntent(paramBundle);
            }
          }
          return;
          i = 2131297741;
          break;
        }
        i += 1;
      }
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    case 601: 
    default: 
      return super.onCreateDialog(paramInt);
    case 600: 
      return SettingsChat.a(this);
    }
    return SettingsChat.b(this);
  }
  
  protected void onDestroy()
  {
    Log.i("settings-gdrive/destroy");
    this.u = true;
    if (this.s != null) {
      this.s.b(this.S);
    }
    unbindService(this.T);
    c.a().a(this.O);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (av.j())
    {
      a.d.a(this.s);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      return super.onKeyDown(paramInt, paramKeyEvent);
      ch.e(this.aQ);
      this.s.a(11);
      continue;
      ch.e(this.aQ);
      this.s.a(12);
      continue;
      ch.e(this.aQ);
      this.s.a(14);
      continue;
      ch.e(this.aQ);
      this.s.a(13);
      continue;
      ch.e(this.aQ);
      this.s.a(16);
      continue;
      ch.e(this.aQ);
      this.s.a(18);
      continue;
      ch.d(this.aQ);
      this.s.a(11);
      continue;
      ch.d(this.aQ);
      this.s.a(12);
      continue;
      ch.d(this.aQ);
      this.s.a(14);
      continue;
      ch.d(this.aQ);
      this.s.a(15);
      continue;
      ch.d(this.aQ);
      this.s.a(18);
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    Object localObject = paramIntent.getAction();
    Log.i("settings-gdrive/new-intent/action/" + (String)localObject);
    if (localObject == null) {
      return;
    }
    int i = -1;
    switch (((String)localObject).hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        Log.e("settings-gdrive/new-intent/unexpected-action/" + paramIntent.getAction());
        return;
        if (((String)localObject).equals("action_perform_media_restore_over_cellular"))
        {
          i = 0;
          continue;
          if (((String)localObject).equals("action_perform_backup_over_cellular")) {
            i = 1;
          }
        }
        break;
      }
    }
    paramIntent = new co.a(this, 15).a(getString(2131296923)).a(false).b(2131296937).c(2131297315).a();
    localObject = j_().a();
    ((w)localObject).a(paramIntent, "action_perform_media_restore_over_cellular");
    ((w)localObject).e();
    return;
    paramIntent = new co.a(this, 16).a(getString(2131296922)).a(false).b(2131296937).c(2131297315).a();
    localObject = j_().a();
    ((w)localObject).a(paramIntent, "action_perform_backup_over_cellular");
    ((w)localObject).e();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    onBackPressed();
    return true;
  }
  
  protected void onPause()
  {
    super.onPause();
    y = false;
  }
  
  protected void onResume()
  {
    super.onResume();
    l();
    Log.i("settings-gdrive/resume");
    TextView localTextView1 = (TextView)findViewById(2131755289);
    TextView localTextView2 = (TextView)findViewById(2131755303);
    if ((!x) && (localTextView1 == null)) {
      throw new AssertionError();
    }
    if ((!x) && (localTextView2 == null)) {
      throw new AssertionError();
    }
    if (this.aq.d())
    {
      localTextView1.setCompoundDrawablesWithIntrinsicBounds(2130840103, 0, 0, 0);
      localTextView2.setCompoundDrawablesWithIntrinsicBounds(2130840151, 0, 0, 0);
    }
    for (;;)
    {
      y = true;
      return;
      localTextView1.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130840103, 0);
      localTextView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 2130840151, 0);
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("intent_already_parsed", true);
  }
  
  protected void p()
  {
    long l1 = -1L;
    TextView localTextView = (TextView)findViewById(2131755313);
    if ((!x) && (localTextView == null)) {
      throw new AssertionError();
    }
    Object localObject = this.aQ;
    String str = this.aQ.ac();
    long l2 = ((atv)localObject).a.getLong("gdrive_last_successful_backup_video_size:" + str, -1L);
    if (l2 > 0L)
    {
      localTextView.setVisibility(0);
      localObject = getString(2131297773, new Object[] { be.a(this, l2) });
    }
    for (;;)
    {
      localTextView.setText((CharSequence)localObject);
      return;
      if (this.I.isChecked())
      {
        localTextView.setVisibility(0);
        if (this.s != null)
        {
          localObject = this.s;
          l1 = ch.a(this.au.f(), ((GoogleDriveService)localObject).v);
        }
        localObject = getString(2131297774, new Object[] { be.a(this, l1) });
      }
      else
      {
        localTextView.setVisibility(8);
        localObject = null;
      }
    }
  }
  
  final void t()
  {
    if (this.aI.a(this.n))
    {
      if (this.s != null) {
        this.s.a(10);
      }
      SettingsChat.a(this, this, this.R, this.ay, this.aI, this.aP, eb.a(this));
    }
  }
  
  protected final boolean u()
  {
    int i = 0;
    a.d.b();
    if (ch.a(this)) {
      return false;
    }
    if (ch.a(this.aQ))
    {
      Log.i("settings-gdrive/account-selector/backup/running");
      b_(2131297760);
    }
    for (;;)
    {
      return true;
      if (ch.c(this.aQ))
      {
        Log.i("settings-gdrive/account-selector/restore/running");
        b_(2131297763);
      }
      else if (this.aP.a("android.permission.GET_ACCOUNTS") != 0)
      {
        startActivityForResult(new Intent(this, RequestPermissionActivity.class).putExtra("drawable_id", 2130840438).putExtra("permissions", new String[] { "android.permission.GET_ACCOUNTS" }).putExtra("message_id", 2131297368).putExtra("perm_denial_message_id", 2131297367), 150);
      }
      else
      {
        Object localObject2 = this.aQ.ac();
        Object localObject3 = AccountManager.get(this).getAccountsByType("com.google");
        if (localObject3.length > 0)
        {
          Log.i("settings-gdrive/account-selector/starting-account-picker/num-accounts/" + localObject3.length);
          int j = -1;
          Object localObject1 = new String[localObject3.length + 1];
          while (i < localObject3.length)
          {
            localObject1[i] = localObject3[i].name;
            int k = j;
            if (localObject2 != null)
            {
              k = j;
              if (((String)localObject2).equals(localObject1[i])) {
                k = i;
              }
            }
            i += 1;
            j = k;
          }
          localObject1[(localObject1.length - 1)] = getString(2131296918);
          localObject2 = new es();
          localObject3 = new Bundle();
          ((Bundle)localObject3).putInt("dialog_id", 17);
          ((Bundle)localObject3).putString("title", getString(2131296919));
          ((Bundle)localObject3).putInt("selected_item_index", j);
          ((Bundle)localObject3).putStringArray("multi_line_list_items_key", (String[])localObject1);
          ((m)localObject2).f((Bundle)localObject3);
          if (j_().a("account-picker") == null)
          {
            localObject1 = j_().a();
            ((w)localObject1).a((Fragment)localObject2, "account-picker");
            ((w)localObject1).e();
          }
        }
        else
        {
          Log.i("settings-gdrive/account-selector/no-account-found/start-add-account-activity");
          m();
        }
      }
    }
  }
  
  final int v()
  {
    int j = this.aQ.R();
    String[] arrayOfString = getResources().getStringArray(2131689484);
    int i = 0;
    while (i < arrayOfString.length)
    {
      if (Integer.parseInt(arrayOfString[i]) == j) {
        return i;
      }
      i += 1;
    }
    Log.e("settings-gdrive/get-backup-freq-index/" + j);
    return 0;
  }
  
  final void w()
  {
    if (this.s != null) {
      this.s.a(10);
    }
    Intent localIntent = new Intent(this, GoogleDriveService.class);
    localIntent.setAction("action_backup");
    localIntent.putExtra("backup_mode", "user_initiated");
    startService(localIntent);
  }
  
  public static final class a
    extends m
  {
    public final Dialog c(Bundle paramBundle)
    {
      paramBundle = new acy(k());
      paramBundle.setTitle(2131297732);
      paramBundle.setIndeterminate(true);
      paramBundle.setMessage(a(2131297731));
      paramBundle.setCancelable(true);
      paramBundle.setOnCancelListener(new er(this));
      return paramBundle;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gdrive/SettingsGoogleDrive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */