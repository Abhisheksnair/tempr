package com.whatsapp.registration;

import a.a.a.a.d;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract.Profile;
import android.support.v7.app.b.a;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.whatsapp.EmojiPicker.c;
import com.whatsapp.Main;
import com.whatsapp.Me;
import com.whatsapp.ProfilePhotoReminder;
import com.whatsapp.ach;
import com.whatsapp.acm;
import com.whatsapp.acw;
import com.whatsapp.agt;
import com.whatsapp.ahc;
import com.whatsapp.aoj;
import com.whatsapp.apf;
import com.whatsapp.att;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.aus;
import com.whatsapp.av;
import com.whatsapp.data.cb;
import com.whatsapp.data.ch;
import com.whatsapp.data.co;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.data.n;
import com.whatsapp.data.v;
import com.whatsapp.dh;
import com.whatsapp.dh.a;
import com.whatsapp.emoji.h;
import com.whatsapp.gdrive.GoogleDriveActivity;
import com.whatsapp.gdrive.GoogleDriveNewUserSetupActivity;
import com.whatsapp.i.b;
import com.whatsapp.messaging.m;
import com.whatsapp.nh;
import com.whatsapp.notification.f;
import com.whatsapp.os;
import com.whatsapp.oz;
import com.whatsapp.pf;
import com.whatsapp.pv;
import com.whatsapp.px;
import com.whatsapp.qz;
import com.whatsapp.tg;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import com.whatsapp.util.l;
import com.whatsapp.util.w;
import com.whatsapp.va;
import java.io.File;
import java.net.URISyntaxException;

public class RegisterName
  extends apf
{
  private static a O;
  EmojiPicker.c N = new EmojiPicker.c()
  {
    public final void a() {}
    
    public final void a(int paramAnonymousInt)
    {
      int i = RegisterName.c(RegisterName.this).getSelectionStart();
      int j = RegisterName.c(RegisterName.this).getSelectionEnd();
      int k;
      if (i > j)
      {
        k = j;
        j = i;
      }
      for (;;)
      {
        StringBuilder localStringBuilder = new StringBuilder(RegisterName.c(RegisterName.this).getText().toString());
        localStringBuilder.replace(k, j, com.whatsapp.emoji.c.b(paramAnonymousInt));
        if (com.whatsapp.emoji.c.c(localStringBuilder) > 25) {}
        do
        {
          return;
          RegisterName.c(RegisterName.this).setText(localStringBuilder);
        } while (k > RegisterName.c(RegisterName.this).length() - com.whatsapp.emoji.c.a(paramAnonymousInt));
        RegisterName.c(RegisterName.this).setSelection(k + com.whatsapp.emoji.c.a(paramAnonymousInt));
        return;
        k = i;
      }
    }
  };
  private b P;
  private ImageView Q;
  private View R;
  private View S;
  private boolean T;
  private final va U = va.a();
  private final aoj V = aoj.a();
  private final x W = x.a();
  private final h X = h.a();
  private final att Y = att.a();
  private final b Z = b.a();
  private Handler aT = new Handler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      RegisterName.b(RegisterName.this);
    }
  };
  private Bitmap aU;
  private final e aa = e.a();
  private final dh ab = dh.a();
  private final w ac = w.a();
  private final v ad = v.a();
  private final co ae = co.a();
  private final f af = f.a();
  private final acm ag = acm.a();
  private final bk ah = bk.a();
  private dh.a ai = null;
  private Handler aj = new Handler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if ((RegisterName.q() != null) && (RegisterName.a.a(RegisterName.q())))
      {
        if (!RegisterName.a.b(RegisterName.q())) {
          break label46;
        }
        if (RegisterName.a(RegisterName.this) != null) {
          RegisterName.a(RegisterName.this).a(1);
        }
      }
      return;
      label46:
      d.b(RegisterName.this, 0);
      switch (RegisterName.a.c(RegisterName.q()))
      {
      case 2: 
      default: 
        return;
      case 1: 
        d.a(RegisterName.this, 1);
        return;
      }
      d.a(RegisterName.this, 109);
    }
  };
  agt n;
  cs o;
  EditText p;
  os q;
  com.whatsapp.emoji.search.i r;
  final oz s = oz.a();
  final com.whatsapp.data.ad t = com.whatsapp.data.ad.a();
  final acw u = acw.a();
  au v = new au(this.Z, this.aE, this.aM, this.aP, this.H);
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent1 = new Intent();
    localIntent1.setClassName("com.whatsapp", "com.whatsapp.Main");
    localIntent1.setAction("android.intent.action.MAIN");
    localIntent1.addCategory("android.intent.category.LAUNCHER");
    localIntent1.addFlags(268435456);
    localIntent1.addFlags(2097152);
    Intent localIntent2 = new Intent();
    localIntent2.putExtra("android.intent.extra.shortcut.INTENT", localIntent1);
    localIntent2.putExtra("duplicate", false);
    localIntent2.putExtra("android.intent.extra.shortcut.NAME", paramString);
    localIntent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramContext, 2130840274));
    localIntent2.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
    paramContext.sendBroadcast(localIntent2);
  }
  
  public static void b(Context paramContext, String paramString)
  {
    Intent localIntent2 = new Intent();
    localIntent2.setClassName("com.whatsapp", "com.whatsapp.Main");
    localIntent2.addFlags(268435456);
    localIntent2.addFlags(67108864);
    Intent localIntent1 = new Intent();
    try
    {
      localIntent1.putExtra("android.intent.extra.shortcut.INTENT", Intent.parseUri(localIntent2.toUri(0), 0));
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", paramString);
      localIntent1.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
      paramContext.sendBroadcast(localIntent1);
      return;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      for (;;)
      {
        Log.e("registername/remove-shortcut cannot parse shortcut uri " + localURISyntaxException.getMessage());
      }
    }
  }
  
  private String s()
  {
    Object localObject1 = null;
    if ("samsung".equalsIgnoreCase(Build.MANUFACTURER)) {
      return null;
    }
    if (Build.VERSION.SDK_INT >= 14) {}
    for (;;)
    {
      try
      {
        Object localObject3 = getContentResolver().query(ContactsContract.Profile.CONTENT_URI, new String[] { "display_name" }, null, null, null);
        Object localObject2;
        if (localObject3 != null) {
          if (((Cursor)localObject3).moveToFirst())
          {
            localObject2 = ((Cursor)localObject3).getString(0);
            localObject1 = localObject2;
          }
        }
        int j;
        int i;
        localObject1 = null;
      }
      catch (Exception localException1)
      {
        try
        {
          ((Cursor)localObject3).close();
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject3 = AccountManager.get(u.a().getApplicationContext());
            localObject2 = localObject1;
            if (localObject3 != null)
            {
              localObject3 = ((AccountManager)localObject3).getAccounts();
              localObject2 = localObject1;
              if (localObject3 != null)
              {
                j = localObject3.length;
                i = 0;
                localObject2 = localObject1;
                if (i < j)
                {
                  localObject2 = localObject3[i];
                  if (!((Account)localObject2).type.equals("com.google")) {
                    continue;
                  }
                  localObject2 = ((Account)localObject2).name;
                }
              }
            }
          }
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            if (!((String)localObject2).contains("@")) {
              continue;
            }
            localObject1 = ((String)localObject2).substring(0, ((String)localObject2).indexOf("@")).replace('.', ' ');
          }
          return (String)localObject1;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1 = localException1;
        Log.w("registername/getmename " + localException1);
        continue;
        i += 1;
        continue;
        localObject1 = localException1.replace('.', ' ');
        continue;
        localObject1 = null;
      }
    }
  }
  
  private void t()
  {
    long l = this.H.a.getLong("com.whatsapp.registername.initializer_start_time", -1L);
    if ((l > 0L) && (System.currentTimeMillis() - l > 600000L) && (this.S != null)) {
      this.S.setVisibility(0);
    }
  }
  
  private void u()
  {
    int i = getResources().getDimensionPixelSize(2131362080);
    float f = getResources().getDimension(2131361832);
    Bitmap localBitmap2 = null;
    Bitmap localBitmap1;
    if ((this.o == null) || (ach.b(this.o.t)))
    {
      this.Q.setEnabled(false);
      this.R.setVisibility(0);
      if (this.aU == null) {
        this.aU = Bitmap.createBitmap(i, i, Bitmap.Config.ALPHA_8);
      }
      localBitmap1 = this.aU;
    }
    for (;;)
    {
      this.Q.setImageBitmap(localBitmap1);
      return;
      this.Q.setEnabled(true);
      this.R.setVisibility(8);
      if (this.o.c().exists()) {
        localBitmap2 = this.o.a(i, f, false);
      }
      localBitmap1 = localBitmap2;
      if (localBitmap2 == null) {
        localBitmap1 = cs.a(2130840090, i, f);
      }
    }
  }
  
  protected final void c(boolean paramBoolean)
  {
    super.c(paramBoolean);
    if ((this.n != null) && (paramBoolean)) {
      this.n.a(1);
    }
  }
  
  protected final void l()
  {
    Me localMe;
    if ((getIntent().getExtras() != null) && (getIntent().getBooleanExtra("debug", false)))
    {
      localMe = this.U.b;
      localMe.jabber_id = this.H.af();
      if (localMe.jabber_id != null) {
        break label95;
      }
      Log.e("registername/messagestoreverified/missing-params bounce to regphone");
      this.L.a(1);
      startActivity(new Intent(this, RegisterPhone.class));
      finish();
    }
    label95:
    do
    {
      return;
      localMe = this.G.d();
      break;
      if (!this.U.a(localMe, "me"))
      {
        finish();
        return;
      }
      this.U.b = localMe;
      ProfilePhotoReminder.b(this.av);
      Log.i("registername/set_dirty");
      this.A.g = false;
      this.G.f();
      this.A.c();
      Log.i("regname/msgstoreverified/group_sync_required");
      this.B.c();
      this.o = this.U.c();
      this.ag.a(this.o.t, 0, 2);
      u();
      this.R.setVisibility(0);
      if (this.n != null)
      {
        if (this.t.z.a.g != 0)
        {
          Log.i("registername/restoredialog/congrats");
          this.n.a(2);
          return;
        }
        Log.i("registername/restoredialog/empty-msg-restore");
        if ((!this.T) && (GoogleDriveNewUserSetupActivity.a(this.av, this.W, this.t, this.L, this.H)))
        {
          startActivityForResult(new Intent(this, GoogleDriveNewUserSetupActivity.class), 15);
          this.T = true;
        }
        d.b(this, 103);
        return;
      }
    } while (this.aP.a("android.permission.GET_ACCOUNTS") == 0);
    Log.i("registername/delay google drive setup due to lack of permissions");
    GoogleDriveNewUserSetupActivity.a(System.currentTimeMillis() + 604800000L);
  }
  
  final void m()
  {
    Log.i("registername/start");
    String str = com.whatsapp.emoji.c.b(((EditText)findViewById(2131756029)).getText().toString().trim());
    if (str.length() == 0)
    {
      Log.w("registername/no-pushname");
      pv.a(this, 2131297534, 0);
    }
    while ((O != null) && (!a.a(O))) {
      return;
    }
    if ((aw.g().exists()) && (!this.H.a.getBoolean("registration_biz_user_confirmed_certificate", false)))
    {
      if ((aw.h() != null) && (aw.i() != null))
      {
        d.a(this, 2);
        return;
      }
      Log.e("registername/start/unsignedcert/no-vname");
      aw.g().delete();
      this.w.a("biz: no vname in cert", false, null, 14);
    }
    if (aw.g().exists())
    {
      Log.i("registername/start/pushname/biz");
      str = aw.i();
    }
    this.H.c(str);
    this.V.a(str, null);
    O = new a(this.aj);
    d.a(this, 0);
    if (((CheckBox)findViewById(2131756037)).isChecked()) {
      a(this, getString(2131298233));
    }
    if (this.S != null) {
      this.S.setVisibility(4);
    }
    long l = System.currentTimeMillis();
    this.H.c().putLong("com.whatsapp.registername.initializer_start_time", l).apply();
    this.aT.sendEmptyMessageDelayed(0, 600000L);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.i("registername/activity-result request:" + paramInt1 + " result:" + paramInt2);
    switch (paramInt1)
    {
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    case 12: 
    case 13: 
    case 14: 
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while (paramInt2 != -1);
            if ((paramIntent != null) && (paramIntent.getBooleanExtra("is_reset", false)))
            {
              this.u.a(this.o);
              u();
              return;
            }
            this.u.a(this, 13, paramIntent);
            return;
            this.u.b().delete();
            if (paramInt2 != -1) {
              break;
            }
          } while (!this.u.a(this, this.o));
          u();
          return;
        } while ((paramInt2 != 0) || (paramIntent == null));
        this.u.a(this, paramIntent);
        return;
        if (paramInt2 != 3) {
          break;
        }
        Log.i("registername/activity-result backup (Google Drive or local) found and is being restored.");
        Log.i("registername/msgstore-download-finished");
        this.t.c();
        this.aH.d();
        l();
      } while (this.n == null);
      this.n.hide();
      return;
      if (paramInt2 == 0)
      {
        Log.i("registername/activity-result gdrive-activity canceled");
        p();
        return;
      }
      if ((paramInt2 == 2) || (paramInt2 == 1))
      {
        c(false);
        return;
      }
      Log.e("registername/activity-result unknown result code " + paramInt2 + " from GoogleDriveActivity.");
      return;
    }
    Log.d("registername/activity-result/restore_from_backup/remove");
    d.b(this, 103);
  }
  
  public void onBackPressed()
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.HOME");
    localIntent.setFlags(268435456);
    startActivity(localIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.P != null)
    {
      this.P.a();
      paramConfiguration = this.P;
      paramConfiguration.a.S = paramConfiguration.findViewById(2131755853);
      t();
    }
    if (this.n != null) {
      this.n.a();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Log.i("registername/create");
    super.onCreate(paramBundle);
    boolean bool;
    if ((paramBundle != null) && (paramBundle.getBoolean("started_gdrive_new_user_activity", false)))
    {
      bool = true;
      this.T = bool;
      setContentView(2130903345);
      int i = this.L.c();
      if (i == 2) {
        break label98;
      }
      if (i != 3) {
        break label89;
      }
      Log.i("registername/create/registration already verified bounce to main");
    }
    for (;;)
    {
      startActivity(new Intent(this, Main.class));
      finish();
      return;
      bool = false;
      break;
      label89:
      Log.e("registername/create/bad-state bounce to main");
    }
    label98:
    paramBundle = this.H.af();
    this.p = ((EditText)findViewById(2131756029));
    Button localButton = (Button)findViewById(2131756062);
    localButton.setOnClickListener(z.a(this));
    if (paramBundle == null)
    {
      Log.e("registername/create/missing-params bounce to regphone");
      this.L.a(1);
      startActivity(new Intent(this, RegisterPhone.class));
      finish();
      return;
    }
    if ((av.g()) || (Build.MANUFACTURER.startsWith("Sony")))
    {
      findViewById(2131756035).setVisibility(8);
      ((CheckBox)findViewById(2131756037)).setChecked(false);
      paramBundle = (ImageButton)findViewById(2131755724);
      paramBundle.setOnClickListener(ag.a(this, paramBundle));
      this.q = new os(this.an, this, this.aq, this.X, this.H);
      this.q.a(this.N);
      this.q.setOnDismissListener(ah.a(this));
      this.r = new com.whatsapp.emoji.search.i(this.q, this, this.an, true);
      this.r.a(new ai(this));
      this.Q = ((ImageView)findViewById(2131755974));
      this.Q.setOnClickListener(aj.a(this));
      this.R = findViewById(2131755538);
      if (O == null) {
        break label648;
      }
      this.o = this.U.c();
      u();
      d.a(this, 0);
      label391:
      this.p = ((EditText)findViewById(2131756029));
      com.whatsapp.al.b(this.aq, this.p);
      com.whatsapp.al.a(this.aq, this.p);
      paramBundle = (TextView)findViewById(2131756034);
      this.p.addTextChangedListener(new tg(this.aq, this.aE, this.p, paramBundle, 25));
      this.p.setFilters(new InputFilter[] { new px(25) });
      if (!aw.g().exists()) {
        break label792;
      }
      paramBundle = aw.i();
      label503:
      if (!TextUtils.isEmpty(paramBundle))
      {
        this.p.setText(paramBundle);
        this.p.setSelection(this.p.length());
      }
      if (!this.av.b()) {
        break label800;
      }
      Log.w("registername/clock-wrong");
      f();
    }
    for (;;)
    {
      this.L.a(2);
      this.ai = new dh.a()
      {
        public final void b(String paramAnonymousString)
        {
          if ((RegisterName.d(RegisterName.this) != null) && (paramAnonymousString.equals(RegisterName.d(RegisterName.this).t))) {
            RegisterName.e(RegisterName.this);
          }
        }
      };
      this.ab.registerObserver(this.ai);
      this.ad.a = false;
      paramBundle = (ScrollView)findViewById(2131756061);
      paramBundle.getViewTreeObserver().addOnGlobalLayoutListener(ak.a(paramBundle, localButton));
      return;
      ((CheckBox)findViewById(2131756037)).setChecked(true);
      findViewById(2131756035).setOnClickListener(af.a(this));
      break;
      label648:
      if (!this.t.d())
      {
        paramBundle = Environment.getExternalStorageState();
        Log.i("registername/clicked/sdcardstate " + paramBundle);
        if ((!"mounted".equals(paramBundle)) && (!"mounted_ro".equals(paramBundle)))
        {
          d.a(this, 107);
          break label391;
        }
        Log.i("registername/check-for-local-and-remote-backups");
        paramBundle = new Intent(this, GoogleDriveActivity.class);
        paramBundle.setAction("action_show_restore_one_time_setup");
        startActivityForResult(paramBundle, 14);
        break label391;
      }
      Log.i("registername/msgstore/healthy");
      this.t.c();
      this.aH.d();
      l();
      if (this.T) {
        break label391;
      }
      GoogleDriveNewUserSetupActivity.a(System.currentTimeMillis() + 604800000L);
      break label391;
      label792:
      paramBundle = s();
      break label503;
      label800:
      if (this.av.c())
      {
        Log.w("registername/sw-expired");
        g();
      }
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 0: 
      Log.i("registername/dialog/initprogress");
      if (O == null)
      {
        Log.w("registername/dialog/initprogress/init-null/remove");
        new Handler(Looper.getMainLooper()).postDelayed(al.a(this), 3L);
      }
      this.P = new b();
      this.P.setCancelable(false);
      return this.P;
    case 103: 
      Log.i("registername/dialog/restore");
      this.n = new agt(this)
      {
        public final void b()
        {
          RegisterName.this.c(true);
        }
        
        public final void c()
        {
          Log.i("registername/restoredialog/skip");
          d.a(RegisterName.this, 106);
        }
        
        public final void d()
        {
          Log.i("registername/restoredialog/done");
          Log.i("registername/restore/dialog/launch-gdrive-new-user");
          if ((!RegisterName.F(RegisterName.this)) && (GoogleDriveNewUserSetupActivity.a(RegisterName.G(RegisterName.this), RegisterName.H(RegisterName.this), RegisterName.v(RegisterName.this), RegisterName.I(RegisterName.this), RegisterName.J(RegisterName.this))))
          {
            GoogleDriveNewUserSetupActivity.a(System.currentTimeMillis() + 604800000L);
            RegisterName.K(RegisterName.this);
            return;
          }
          Log.d("registername/restoredialog/remove");
          d.b(RegisterName.this, 103);
        }
      };
      this.n.setCancelable(false);
      aus localaus = this.aF;
      Log.d("restorebackupdialog/lastbackup/look at files");
      long l = this.t.c.h();
      if (l != -1L) {
        Log.d("restorebackupdialog/lastbackup/fromfiles/set to " + l);
      }
      bu.a(ad.a(this, l.b(this, localaus, l).toString()));
      return this.n;
    case 1: 
      Log.w("registername/dialog/failed-net");
      return new b.a(this).a(2131297055).b(getString(2131297053, new Object[] { getString(2131296506) })).a(2131297054, am.a(this)).a();
    case 109: 
      Log.w("registername/dialog/cant-connect");
      return bc.a(this, this.aE, this.aM, this.aP, this.H);
    }
    Log.i("registername/dialog/confirm-biz-name");
    return new b.a(this).b(getString(2131298236, new Object[] { aw.i() })).a(2131298213, aa.a(this)).b(2131297281, ab.a(this)).a(ac.a()).a();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add(0, 0, 0, 2131297595);
    if (av.d()) {
      paramMenu.add(0, 1, 0, "Reset");
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onDestroy()
  {
    Log.i("registername/destroy");
    if (isFinishing()) {
      this.af.b();
    }
    if (this.ai != null)
    {
      this.ab.unregisterObserver(this.ai);
      this.ai = null;
    }
    this.v.a();
    super.onDestroy();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 0: 
      this.ah.a("register-name");
      this.v.a(this, this.ah, "register-name");
      return true;
    }
    this.L.a(1);
    startActivity(new Intent(this, EULA.class));
    finish();
    return true;
  }
  
  public void onPause()
  {
    Log.i("registername/pause");
    super.onPause();
    if (O != null)
    {
      a locala = O;
      if (locala.a != null)
      {
        locala.a.removeMessages(0);
        locala.a = null;
      }
    }
  }
  
  public void onResume()
  {
    Log.i("registername/resume");
    super.onResume();
    o();
    if (O != null)
    {
      d.a(this, 0);
      a locala = O;
      Handler localHandler = this.aj;
      if (locala.b) {
        localHandler.sendEmptyMessage(0);
      }
      locala.a = localHandler;
      t();
    }
    if ((this.L.b()) && (this.P == null))
    {
      d.a(this, 0);
      Log.i("registername/resume reg verified; explicitly display continue screen");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putBoolean("started_gdrive_new_user_activity", this.T);
    }
  }
  
  final class a
    extends Thread
  {
    Handler a;
    boolean b = false;
    private boolean d = false;
    private int e = 0;
    
    public a(Handler paramHandler)
    {
      this.a = paramHandler;
      start();
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 47
      //   2: invokestatic 52	com/whatsapp/k/c:b	(Ljava/lang/String;)Lcom/whatsapp/k/d;
      //   5: astore 4
      //   7: aload 4
      //   9: invokeinterface 56 1 0
      //   14: ldc 58
      //   16: invokestatic 64	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   19: invokestatic 70	com/whatsapp/registration/aw:g	()Ljava/io/File;
      //   22: invokevirtual 76	java/io/File:exists	()Z
      //   25: ifeq +99 -> 124
      //   28: invokestatic 80	com/whatsapp/registration/aw:h	()Lcom/whatsapp/proto/c;
      //   31: astore 5
      //   33: aload 5
      //   35: ifnull +89 -> 124
      //   38: ldc 82
      //   40: invokestatic 64	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   43: invokestatic 87	com/whatsapp/a/c:a	()Lcom/whatsapp/a/c;
      //   46: astore 7
      //   48: aload 5
      //   50: invokestatic 92	com/whatsapp/proto/c:a	(Lcom/whatsapp/proto/c;)Lcom/whatsapp/proto/c$a;
      //   53: astore 6
      //   55: aload 7
      //   57: invokevirtual 95	com/whatsapp/a/c:h	()Lorg/whispersystems/a/d;
      //   60: astore 7
      //   62: aload 6
      //   64: aload 7
      //   66: invokevirtual 100	org/whispersystems/a/d:b	()Lorg/whispersystems/a/a/c;
      //   69: aload 5
      //   71: getfield 103	com/whatsapp/proto/c:b	Lcom/google/protobuf/e;
      //   74: invokevirtual 108	com/google/protobuf/e:d	()[B
      //   77: invokestatic 113	a/a/a/a/d:a	(Lorg/whispersystems/a/a/c;[B)[B
      //   80: invokestatic 116	com/google/protobuf/e:a	([B)Lcom/google/protobuf/e;
      //   83: invokevirtual 121	com/whatsapp/proto/c$a:a	(Lcom/google/protobuf/e;)Lcom/whatsapp/proto/c$a;
      //   86: pop
      //   87: aload_0
      //   88: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   91: invokestatic 125	com/whatsapp/registration/RegisterName:f	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/atv;
      //   94: aconst_null
      //   95: invokevirtual 128	com/whatsapp/atv:i	(Ljava/lang/String;)V
      //   98: invokestatic 133	com/whatsapp/messaging/w:a	()Lcom/whatsapp/messaging/w;
      //   101: aload 6
      //   103: invokevirtual 135	com/whatsapp/proto/c$a:b	()Lcom/whatsapp/proto/c;
      //   106: invokevirtual 138	com/whatsapp/proto/c:toByteArray	()[B
      //   109: invokevirtual 141	com/whatsapp/messaging/w:a	([B)Ljava/util/concurrent/Future;
      //   112: astore 5
      //   114: aload 5
      //   116: ifnonnull +284 -> 400
      //   119: ldc -113
      //   121: invokestatic 145	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
      //   124: sipush 1001
      //   127: istore_1
      //   128: aload_0
      //   129: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   132: invokestatic 148	com/whatsapp/registration/RegisterName:i	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/and;
      //   135: aload_0
      //   136: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   139: invokestatic 152	com/whatsapp/registration/RegisterName:j	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/atu;
      //   142: getstatic 157	com/whatsapp/contact/sync/p:a	Lcom/whatsapp/contact/sync/p;
      //   145: invokestatic 160	a/a/a/a/d:a	(Lcom/whatsapp/and;Lcom/whatsapp/atu;Lcom/whatsapp/contact/sync/p;)Ljava/lang/Integer;
      //   148: astore 5
      //   150: aload 5
      //   152: ifnonnull +8 -> 160
      //   155: ldc -94
      //   157: invokestatic 165	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
      //   160: aload 5
      //   162: ifnonnull +512 -> 674
      //   165: iconst_0
      //   166: istore_1
      //   167: aload 4
      //   169: getstatic 170	com/whatsapp/k/d$b:b	Lcom/whatsapp/k/d$b;
      //   172: iload_1
      //   173: invokeinterface 173 3 0
      //   178: aload_0
      //   179: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   182: invokestatic 176	com/whatsapp/registration/RegisterName:k	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/atv;
      //   185: astore 5
      //   187: iload_1
      //   188: sipush 1000
      //   191: if_icmpgt +570 -> 761
      //   194: iconst_1
      //   195: istore_3
      //   196: aload 5
      //   198: iload_3
      //   199: invokevirtual 179	com/whatsapp/atv:a	(Z)V
      //   202: new 181	java/lang/StringBuilder
      //   205: dup
      //   206: ldc -73
      //   208: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   211: iload_1
      //   212: invokevirtual 189	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   215: ldc -65
      //   217: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   220: aload_0
      //   221: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   224: invokestatic 197	com/whatsapp/registration/RegisterName:l	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/atv;
      //   227: invokevirtual 199	com/whatsapp/atv:b	()Z
      //   230: invokevirtual 202	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   233: ldc -52
      //   235: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   238: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   241: invokestatic 64	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   244: aload_0
      //   245: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   248: invokestatic 211	com/whatsapp/registration/RegisterName:m	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/atv;
      //   251: invokevirtual 213	com/whatsapp/atv:k	()V
      //   254: aload 4
      //   256: getstatic 218	com/whatsapp/k/d$e:j	Lcom/whatsapp/k/d$e;
      //   259: invokeinterface 221 2 0
      //   264: new 223	com/whatsapp/contact/sync/t$a
      //   267: dup
      //   268: getstatic 228	com/whatsapp/contact/sync/w:a	Lcom/whatsapp/contact/sync/w;
      //   271: invokespecial 231	com/whatsapp/contact/sync/t$a:<init>	(Lcom/whatsapp/contact/sync/w;)V
      //   274: astore 5
      //   276: aload 5
      //   278: iconst_1
      //   279: putfield 232	com/whatsapp/contact/sync/t$a:b	Z
      //   282: aload 5
      //   284: iconst_1
      //   285: putfield 234	com/whatsapp/contact/sync/t$a:e	Z
      //   288: aload 5
      //   290: invokevirtual 237	com/whatsapp/contact/sync/t$a:a	()Lcom/whatsapp/contact/sync/t;
      //   293: astore 5
      //   295: aload_0
      //   296: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   299: invokestatic 241	com/whatsapp/registration/RegisterName:n	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/contact/sync/i;
      //   302: aload 5
      //   304: invokevirtual 246	com/whatsapp/contact/sync/i:a	(Lcom/whatsapp/contact/sync/t;)Lcom/whatsapp/contact/sync/v;
      //   307: astore 5
      //   309: aload 4
      //   311: getstatic 218	com/whatsapp/k/d$e:j	Lcom/whatsapp/k/d$e;
      //   314: invokeinterface 248 2 0
      //   319: new 181	java/lang/StringBuilder
      //   322: dup
      //   323: ldc -6
      //   325: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   328: aload 5
      //   330: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   333: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   336: invokestatic 64	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   339: aload 5
      //   341: getstatic 258	com/whatsapp/contact/sync/v:a	Lcom/whatsapp/contact/sync/v;
      //   344: if_acmpne +430 -> 774
      //   347: aload_0
      //   348: iconst_1
      //   349: putfield 30	com/whatsapp/registration/RegisterName$a:e	I
      //   352: aload 4
      //   354: invokeinterface 260 1 0
      //   359: aload_0
      //   360: iconst_1
      //   361: putfield 26	com/whatsapp/registration/RegisterName$a:b	Z
      //   364: ldc_w 262
      //   367: invokestatic 64	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   370: aload_0
      //   371: getfield 32	com/whatsapp/registration/RegisterName$a:a	Landroid/os/Handler;
      //   374: ifnull +12 -> 386
      //   377: aload_0
      //   378: getfield 32	com/whatsapp/registration/RegisterName$a:a	Landroid/os/Handler;
      //   381: iconst_0
      //   382: invokevirtual 268	android/os/Handler:sendEmptyMessage	(I)Z
      //   385: pop
      //   386: invokestatic 272	com/whatsapp/av:e	()Z
      //   389: ifeq +377 -> 766
      //   392: aload 4
      //   394: invokeinterface 260 1 0
      //   399: return
      //   400: aload 5
      //   402: ldc2_w 273
      //   405: getstatic 280	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
      //   408: invokeinterface 286 4 0
      //   413: pop
      //   414: aload_0
      //   415: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   418: invokestatic 288	com/whatsapp/registration/RegisterName:g	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/atv;
      //   421: invokevirtual 291	com/whatsapp/atv:ag	()Ljava/lang/String;
      //   424: invokestatic 297	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   427: ifeq -303 -> 124
      //   430: ldc_w 299
      //   433: invokestatic 165	com/whatsapp/util/Log:w	(Ljava/lang/String;)V
      //   436: aload_0
      //   437: iconst_3
      //   438: putfield 30	com/whatsapp/registration/RegisterName$a:e	I
      //   441: aload 4
      //   443: invokeinterface 260 1 0
      //   448: aload_0
      //   449: iconst_1
      //   450: putfield 26	com/whatsapp/registration/RegisterName$a:b	Z
      //   453: ldc_w 262
      //   456: invokestatic 64	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   459: aload_0
      //   460: getfield 32	com/whatsapp/registration/RegisterName$a:a	Landroid/os/Handler;
      //   463: ifnull +12 -> 475
      //   466: aload_0
      //   467: getfield 32	com/whatsapp/registration/RegisterName$a:a	Landroid/os/Handler;
      //   470: iconst_0
      //   471: invokevirtual 268	android/os/Handler:sendEmptyMessage	(I)Z
      //   474: pop
      //   475: invokestatic 272	com/whatsapp/av:e	()Z
      //   478: ifeq +11 -> 489
      //   481: aload 4
      //   483: invokeinterface 260 1 0
      //   488: return
      //   489: aload 4
      //   491: invokeinterface 301 1 0
      //   496: return
      //   497: astore 5
      //   499: new 181	java/lang/StringBuilder
      //   502: dup
      //   503: ldc_w 303
      //   506: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   509: aload 5
      //   511: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   514: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   517: invokestatic 145	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
      //   520: aload_0
      //   521: iconst_3
      //   522: putfield 30	com/whatsapp/registration/RegisterName$a:e	I
      //   525: aload 4
      //   527: invokeinterface 260 1 0
      //   532: aload_0
      //   533: iconst_1
      //   534: putfield 26	com/whatsapp/registration/RegisterName$a:b	Z
      //   537: ldc_w 262
      //   540: invokestatic 64	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   543: aload_0
      //   544: getfield 32	com/whatsapp/registration/RegisterName$a:a	Landroid/os/Handler;
      //   547: ifnull +12 -> 559
      //   550: aload_0
      //   551: getfield 32	com/whatsapp/registration/RegisterName$a:a	Landroid/os/Handler;
      //   554: iconst_0
      //   555: invokevirtual 268	android/os/Handler:sendEmptyMessage	(I)Z
      //   558: pop
      //   559: invokestatic 272	com/whatsapp/av:e	()Z
      //   562: ifeq +11 -> 573
      //   565: aload 4
      //   567: invokeinterface 260 1 0
      //   572: return
      //   573: aload 4
      //   575: invokeinterface 301 1 0
      //   580: return
      //   581: astore 5
      //   583: new 181	java/lang/StringBuilder
      //   586: dup
      //   587: ldc_w 305
      //   590: invokespecial 185	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   593: aload 5
      //   595: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   598: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   601: invokestatic 145	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
      //   604: aload_0
      //   605: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   608: invokestatic 308	com/whatsapp/registration/RegisterName:h	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/util/a/c;
      //   611: ldc_w 310
      //   614: iconst_0
      //   615: aconst_null
      //   616: bipush 14
      //   618: invokevirtual 315	com/whatsapp/util/a/c:a	(Ljava/lang/String;ZLjava/util/EnumSet;I)V
      //   621: goto -497 -> 124
      //   624: astore 5
      //   626: aload 4
      //   628: invokeinterface 260 1 0
      //   633: aload_0
      //   634: iconst_1
      //   635: putfield 26	com/whatsapp/registration/RegisterName$a:b	Z
      //   638: ldc_w 262
      //   641: invokestatic 64	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   644: aload_0
      //   645: getfield 32	com/whatsapp/registration/RegisterName$a:a	Landroid/os/Handler;
      //   648: ifnull +12 -> 660
      //   651: aload_0
      //   652: getfield 32	com/whatsapp/registration/RegisterName$a:a	Landroid/os/Handler;
      //   655: iconst_0
      //   656: invokevirtual 268	android/os/Handler:sendEmptyMessage	(I)Z
      //   659: pop
      //   660: invokestatic 272	com/whatsapp/av:e	()Z
      //   663: ifeq +783 -> 1446
      //   666: aload 4
      //   668: invokeinterface 260 1 0
      //   673: return
      //   674: aload 5
      //   676: invokevirtual 321	java/lang/Integer:intValue	()I
      //   679: istore_2
      //   680: iload_2
      //   681: istore_1
      //   682: goto -515 -> 167
      //   685: astore 5
      //   687: ldc_w 323
      //   690: aload 5
      //   692: invokestatic 326	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   695: goto -528 -> 167
      //   698: astore 5
      //   700: aload_0
      //   701: iconst_3
      //   702: putfield 30	com/whatsapp/registration/RegisterName$a:e	I
      //   705: ldc_w 328
      //   708: aload 5
      //   710: invokestatic 326	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   713: aload 4
      //   715: invokeinterface 260 1 0
      //   720: aload_0
      //   721: iconst_1
      //   722: putfield 26	com/whatsapp/registration/RegisterName$a:b	Z
      //   725: ldc_w 262
      //   728: invokestatic 64	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   731: aload_0
      //   732: getfield 32	com/whatsapp/registration/RegisterName$a:a	Landroid/os/Handler;
      //   735: ifnull +12 -> 747
      //   738: aload_0
      //   739: getfield 32	com/whatsapp/registration/RegisterName$a:a	Landroid/os/Handler;
      //   742: iconst_0
      //   743: invokevirtual 268	android/os/Handler:sendEmptyMessage	(I)Z
      //   746: pop
      //   747: invokestatic 272	com/whatsapp/av:e	()Z
      //   750: ifeq +704 -> 1454
      //   753: aload 4
      //   755: invokeinterface 260 1 0
      //   760: return
      //   761: iconst_0
      //   762: istore_3
      //   763: goto -567 -> 196
      //   766: aload 4
      //   768: invokeinterface 301 1 0
      //   773: return
      //   774: aload 5
      //   776: getstatic 330	com/whatsapp/contact/sync/v:d	Lcom/whatsapp/contact/sync/v;
      //   779: if_acmpne +64 -> 843
      //   782: aload_0
      //   783: iconst_3
      //   784: putfield 30	com/whatsapp/registration/RegisterName$a:e	I
      //   787: aload 4
      //   789: invokeinterface 260 1 0
      //   794: aload_0
      //   795: iconst_1
      //   796: putfield 26	com/whatsapp/registration/RegisterName$a:b	Z
      //   799: ldc_w 262
      //   802: invokestatic 64	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   805: aload_0
      //   806: getfield 32	com/whatsapp/registration/RegisterName$a:a	Landroid/os/Handler;
      //   809: ifnull +12 -> 821
      //   812: aload_0
      //   813: getfield 32	com/whatsapp/registration/RegisterName$a:a	Landroid/os/Handler;
      //   816: iconst_0
      //   817: invokevirtual 268	android/os/Handler:sendEmptyMessage	(I)Z
      //   820: pop
      //   821: invokestatic 272	com/whatsapp/av:e	()Z
      //   824: ifeq +11 -> 835
      //   827: aload 4
      //   829: invokeinterface 260 1 0
      //   834: return
      //   835: aload 4
      //   837: invokeinterface 301 1 0
      //   842: return
      //   843: aload 5
      //   845: getstatic 332	com/whatsapp/contact/sync/v:e	Lcom/whatsapp/contact/sync/v;
      //   848: if_acmpne +70 -> 918
      //   851: ldc_w 334
      //   854: invokestatic 145	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
      //   857: aload_0
      //   858: iconst_3
      //   859: putfield 30	com/whatsapp/registration/RegisterName$a:e	I
      //   862: aload 4
      //   864: invokeinterface 260 1 0
      //   869: aload_0
      //   870: iconst_1
      //   871: putfield 26	com/whatsapp/registration/RegisterName$a:b	Z
      //   874: ldc_w 262
      //   877: invokestatic 64	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   880: aload_0
      //   881: getfield 32	com/whatsapp/registration/RegisterName$a:a	Landroid/os/Handler;
      //   884: ifnull +12 -> 896
      //   887: aload_0
      //   888: getfield 32	com/whatsapp/registration/RegisterName$a:a	Landroid/os/Handler;
      //   891: iconst_0
      //   892: invokevirtual 268	android/os/Handler:sendEmptyMessage	(I)Z
      //   895: pop
      //   896: invokestatic 272	com/whatsapp/av:e	()Z
      //   899: ifeq +11 -> 910
      //   902: aload 4
      //   904: invokeinterface 260 1 0
      //   909: return
      //   910: aload 4
      //   912: invokeinterface 301 1 0
      //   917: return
      //   918: ldc_w 336
      //   921: invokestatic 64	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   924: aload_0
      //   925: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   928: invokestatic 340	com/whatsapp/registration/RegisterName:o	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/messaging/w;
      //   931: invokevirtual 342	com/whatsapp/messaging/w:f	()V
      //   934: new 9	com/whatsapp/registration/RegisterName$a$1
      //   937: dup
      //   938: aload_0
      //   939: invokespecial 345	com/whatsapp/registration/RegisterName$a$1:<init>	(Lcom/whatsapp/registration/RegisterName$a;)V
      //   942: astore 5
      //   944: aload 5
      //   946: iconst_1
      //   947: invokevirtual 349	java/lang/Thread:setPriority	(I)V
      //   950: aload 5
      //   952: invokevirtual 350	java/lang/Thread:start	()V
      //   955: aload 5
      //   957: invokevirtual 353	java/lang/Thread:join	()V
      //   960: ldc_w 355
      //   963: invokestatic 64	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   966: aload_0
      //   967: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   970: invokestatic 358	com/whatsapp/registration/RegisterName:s	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/atv;
      //   973: iconst_1
      //   974: invokevirtual 360	com/whatsapp/atv:b	(Z)V
      //   977: aload 4
      //   979: getstatic 362	com/whatsapp/k/d$e:k	Lcom/whatsapp/k/d$e;
      //   982: invokeinterface 221 2 0
      //   987: aload_0
      //   988: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   991: invokestatic 365	com/whatsapp/registration/RegisterName:t	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/messaging/w;
      //   994: invokevirtual 367	com/whatsapp/messaging/w:g	()V
      //   997: aload_0
      //   998: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   1001: invokestatic 370	com/whatsapp/registration/RegisterName:u	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/messaging/w;
      //   1004: invokevirtual 372	com/whatsapp/messaging/w:d	()V
      //   1007: aload_0
      //   1008: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   1011: invokestatic 376	com/whatsapp/registration/RegisterName:v	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/data/ad;
      //   1014: getfield 381	com/whatsapp/data/ad:e	Ljava/io/File;
      //   1017: invokevirtual 76	java/io/File:exists	()Z
      //   1020: ifeq +33 -> 1053
      //   1023: aload_0
      //   1024: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   1027: invokestatic 384	com/whatsapp/registration/RegisterName:w	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/data/co;
      //   1030: invokevirtual 387	com/whatsapp/data/co:b	()Z
      //   1033: ifne +20 -> 1053
      //   1036: aload_0
      //   1037: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   1040: invokestatic 391	com/whatsapp/registration/RegisterName:x	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/att;
      //   1043: new 393	com/whatsapp/jobqueue/job/GetStatusPrivacyJob
      //   1046: dup
      //   1047: invokespecial 394	com/whatsapp/jobqueue/job/GetStatusPrivacyJob:<init>	()V
      //   1050: invokevirtual 399	com/whatsapp/att:a	(Lorg/whispersystems/jobqueue/Job;)V
      //   1053: aload_0
      //   1054: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   1057: invokestatic 403	com/whatsapp/registration/RegisterName:y	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/data/e;
      //   1060: bipush 50
      //   1062: invokevirtual 408	com/whatsapp/data/e:a	(I)Ljava/util/ArrayList;
      //   1065: invokevirtual 414	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   1068: astore 5
      //   1070: aload 5
      //   1072: invokeinterface 419 1 0
      //   1077: ifeq +80 -> 1157
      //   1080: aload 5
      //   1082: invokeinterface 423 1 0
      //   1087: checkcast 425	com/whatsapp/data/cs
      //   1090: astore 6
      //   1092: aload_0
      //   1093: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   1096: invokestatic 429	com/whatsapp/registration/RegisterName:z	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/acm;
      //   1099: aload 6
      //   1101: getfield 432	com/whatsapp/data/cs:t	Ljava/lang/String;
      //   1104: iconst_0
      //   1105: iconst_2
      //   1106: invokevirtual 437	com/whatsapp/acm:a	(Ljava/lang/String;II)V
      //   1109: goto -39 -> 1070
      //   1112: astore 5
      //   1114: aload_0
      //   1115: iconst_1
      //   1116: putfield 26	com/whatsapp/registration/RegisterName$a:b	Z
      //   1119: ldc_w 262
      //   1122: invokestatic 64	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   1125: aload_0
      //   1126: getfield 32	com/whatsapp/registration/RegisterName$a:a	Landroid/os/Handler;
      //   1129: ifnull +12 -> 1141
      //   1132: aload_0
      //   1133: getfield 32	com/whatsapp/registration/RegisterName$a:a	Landroid/os/Handler;
      //   1136: iconst_0
      //   1137: invokevirtual 268	android/os/Handler:sendEmptyMessage	(I)Z
      //   1140: pop
      //   1141: invokestatic 272	com/whatsapp/av:e	()Z
      //   1144: ifeq +318 -> 1462
      //   1147: aload 4
      //   1149: invokeinterface 260 1 0
      //   1154: aload 5
      //   1156: athrow
      //   1157: aload_0
      //   1158: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   1161: invokestatic 403	com/whatsapp/registration/RegisterName:y	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/data/e;
      //   1164: invokevirtual 440	com/whatsapp/data/e:e	()Ljava/util/ArrayList;
      //   1167: astore 5
      //   1169: aload 5
      //   1171: new 442	com/whatsapp/ch
      //   1174: dup
      //   1175: aload_0
      //   1176: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   1179: invokespecial 445	com/whatsapp/ch:<init>	(Landroid/content/Context;)V
      //   1182: invokestatic 451	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
      //   1185: aload 4
      //   1187: getstatic 453	com/whatsapp/k/d$b:c	Lcom/whatsapp/k/d$b;
      //   1190: aload 5
      //   1192: invokevirtual 456	java/util/ArrayList:size	()I
      //   1195: invokeinterface 173 3 0
      //   1200: aload 5
      //   1202: invokevirtual 414	java/util/ArrayList:iterator	()Ljava/util/Iterator;
      //   1205: astore 5
      //   1207: iconst_0
      //   1208: istore_1
      //   1209: aload 5
      //   1211: invokeinterface 419 1 0
      //   1216: ifeq +55 -> 1271
      //   1219: aload 5
      //   1221: invokeinterface 423 1 0
      //   1226: checkcast 425	com/whatsapp/data/cs
      //   1229: astore 6
      //   1231: iload_1
      //   1232: istore_2
      //   1233: aload 6
      //   1235: getfield 458	com/whatsapp/data/cs:h	Z
      //   1238: ifeq +234 -> 1472
      //   1241: iload_1
      //   1242: iconst_1
      //   1243: iadd
      //   1244: istore_2
      //   1245: aload_0
      //   1246: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   1249: invokestatic 429	com/whatsapp/registration/RegisterName:z	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/acm;
      //   1252: aload 6
      //   1254: getfield 432	com/whatsapp/data/cs:t	Ljava/lang/String;
      //   1257: iconst_0
      //   1258: iconst_2
      //   1259: invokevirtual 437	com/whatsapp/acm:a	(Ljava/lang/String;II)V
      //   1262: iload_2
      //   1263: bipush 50
      //   1265: if_icmpgt +6 -> 1271
      //   1268: goto +204 -> 1472
      //   1271: aload_0
      //   1272: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   1275: invokestatic 461	com/whatsapp/registration/RegisterName:d	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/data/cs;
      //   1278: getfield 463	com/whatsapp/data/cs:l	I
      //   1281: ifne +196 -> 1477
      //   1284: aload_0
      //   1285: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   1288: invokestatic 429	com/whatsapp/registration/RegisterName:z	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/acm;
      //   1291: aload_0
      //   1292: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   1295: invokestatic 461	com/whatsapp/registration/RegisterName:d	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/data/cs;
      //   1298: getfield 432	com/whatsapp/data/cs:t	Ljava/lang/String;
      //   1301: iconst_0
      //   1302: iconst_1
      //   1303: invokevirtual 437	com/whatsapp/acm:a	(Ljava/lang/String;II)V
      //   1306: goto +171 -> 1477
      //   1309: aload_0
      //   1310: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   1313: invokestatic 467	com/whatsapp/registration/RegisterName:A	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/util/w;
      //   1316: getfield 472	com/whatsapp/util/w:c	Lcom/whatsapp/util/w$a;
      //   1319: invokevirtual 476	com/whatsapp/util/w$a:c	()Z
      //   1322: ifne +25 -> 1347
      //   1325: iload_1
      //   1326: sipush 10000
      //   1329: if_icmpge +18 -> 1347
      //   1332: ldc2_w 477
      //   1335: invokestatic 484	android/os/SystemClock:sleep	(J)V
      //   1338: iload_1
      //   1339: sipush 200
      //   1342: iadd
      //   1343: istore_1
      //   1344: goto -35 -> 1309
      //   1347: aload_0
      //   1348: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   1351: invokestatic 488	com/whatsapp/registration/RegisterName:B	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/pv;
      //   1354: new 490	com/whatsapp/registration/an
      //   1357: dup
      //   1358: aload_0
      //   1359: invokespecial 491	com/whatsapp/registration/an:<init>	(Lcom/whatsapp/registration/RegisterName$a;)V
      //   1362: invokevirtual 496	com/whatsapp/pv:a	(Ljava/lang/Runnable;)V
      //   1365: aload 4
      //   1367: getstatic 362	com/whatsapp/k/d$e:k	Lcom/whatsapp/k/d$e;
      //   1370: invokeinterface 248 2 0
      //   1375: aload_0
      //   1376: iconst_1
      //   1377: putfield 28	com/whatsapp/registration/RegisterName$a:d	Z
      //   1380: aload_0
      //   1381: getfield 21	com/whatsapp/registration/RegisterName$a:c	Lcom/whatsapp/registration/RegisterName;
      //   1384: invokestatic 500	com/whatsapp/registration/RegisterName:C	(Lcom/whatsapp/registration/RegisterName;)Lcom/whatsapp/registration/bb;
      //   1387: iconst_3
      //   1388: invokevirtual 504	com/whatsapp/registration/bb:a	(I)V
      //   1391: ldc_w 506
      //   1394: invokestatic 64	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   1397: aload_0
      //   1398: iconst_1
      //   1399: putfield 26	com/whatsapp/registration/RegisterName$a:b	Z
      //   1402: ldc_w 262
      //   1405: invokestatic 64	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   1408: aload_0
      //   1409: getfield 32	com/whatsapp/registration/RegisterName$a:a	Landroid/os/Handler;
      //   1412: ifnull +12 -> 1424
      //   1415: aload_0
      //   1416: getfield 32	com/whatsapp/registration/RegisterName$a:a	Landroid/os/Handler;
      //   1419: iconst_0
      //   1420: invokevirtual 268	android/os/Handler:sendEmptyMessage	(I)Z
      //   1423: pop
      //   1424: invokestatic 272	com/whatsapp/av:e	()Z
      //   1427: ifeq +11 -> 1438
      //   1430: aload 4
      //   1432: invokeinterface 260 1 0
      //   1437: return
      //   1438: aload 4
      //   1440: invokeinterface 301 1 0
      //   1445: return
      //   1446: aload 4
      //   1448: invokeinterface 301 1 0
      //   1453: return
      //   1454: aload 4
      //   1456: invokeinterface 301 1 0
      //   1461: return
      //   1462: aload 4
      //   1464: invokeinterface 301 1 0
      //   1469: goto -315 -> 1154
      //   1472: iload_2
      //   1473: istore_1
      //   1474: goto -265 -> 1209
      //   1477: iconst_0
      //   1478: istore_1
      //   1479: goto -170 -> 1309
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1482	0	this	a
      //   127	1352	1	i	int
      //   679	794	2	j	int
      //   195	568	3	bool	boolean
      //   5	1458	4	locald	com.whatsapp.k.d
      //   31	370	5	localObject1	Object
      //   497	13	5	localException1	Exception
      //   581	13	5	locale	org.whispersystems.a.e
      //   624	51	5	localInterruptedException	InterruptedException
      //   685	6	5	localException2	Exception
      //   698	146	5	localException3	Exception
      //   942	139	5	localObject2	Object
      //   1112	43	5	localObject3	Object
      //   1167	53	5	localObject4	Object
      //   53	1200	6	localObject5	Object
      //   46	19	7	localObject6	Object
      // Exception table:
      //   from	to	target	type
      //   400	448	497	java/lang/Exception
      //   62	114	581	org/whispersystems/a/e
      //   119	124	581	org/whispersystems/a/e
      //   400	448	581	org/whispersystems/a/e
      //   499	532	581	org/whispersystems/a/e
      //   7	33	624	java/lang/InterruptedException
      //   38	62	624	java/lang/InterruptedException
      //   62	114	624	java/lang/InterruptedException
      //   119	124	624	java/lang/InterruptedException
      //   128	150	624	java/lang/InterruptedException
      //   155	160	624	java/lang/InterruptedException
      //   167	187	624	java/lang/InterruptedException
      //   196	359	624	java/lang/InterruptedException
      //   400	448	624	java/lang/InterruptedException
      //   499	532	624	java/lang/InterruptedException
      //   583	621	624	java/lang/InterruptedException
      //   674	680	624	java/lang/InterruptedException
      //   687	695	624	java/lang/InterruptedException
      //   774	794	624	java/lang/InterruptedException
      //   843	869	624	java/lang/InterruptedException
      //   918	1053	624	java/lang/InterruptedException
      //   1053	1070	624	java/lang/InterruptedException
      //   1070	1109	624	java/lang/InterruptedException
      //   1157	1207	624	java/lang/InterruptedException
      //   1209	1231	624	java/lang/InterruptedException
      //   1233	1241	624	java/lang/InterruptedException
      //   1245	1262	624	java/lang/InterruptedException
      //   1271	1306	624	java/lang/InterruptedException
      //   1309	1325	624	java/lang/InterruptedException
      //   1332	1338	624	java/lang/InterruptedException
      //   1347	1397	624	java/lang/InterruptedException
      //   128	150	685	java/lang/Exception
      //   155	160	685	java/lang/Exception
      //   674	680	685	java/lang/Exception
      //   7	33	698	java/lang/Exception
      //   38	62	698	java/lang/Exception
      //   62	114	698	java/lang/Exception
      //   119	124	698	java/lang/Exception
      //   167	187	698	java/lang/Exception
      //   196	359	698	java/lang/Exception
      //   499	532	698	java/lang/Exception
      //   583	621	698	java/lang/Exception
      //   687	695	698	java/lang/Exception
      //   774	794	698	java/lang/Exception
      //   843	869	698	java/lang/Exception
      //   918	1053	698	java/lang/Exception
      //   1053	1070	698	java/lang/Exception
      //   1070	1109	698	java/lang/Exception
      //   1157	1207	698	java/lang/Exception
      //   1209	1231	698	java/lang/Exception
      //   1233	1241	698	java/lang/Exception
      //   1245	1262	698	java/lang/Exception
      //   1271	1306	698	java/lang/Exception
      //   1309	1325	698	java/lang/Exception
      //   1332	1338	698	java/lang/Exception
      //   1347	1397	698	java/lang/Exception
      //   7	33	1112	finally
      //   38	62	1112	finally
      //   62	114	1112	finally
      //   119	124	1112	finally
      //   128	150	1112	finally
      //   155	160	1112	finally
      //   167	187	1112	finally
      //   196	359	1112	finally
      //   400	448	1112	finally
      //   499	532	1112	finally
      //   583	621	1112	finally
      //   626	633	1112	finally
      //   674	680	1112	finally
      //   687	695	1112	finally
      //   700	720	1112	finally
      //   774	794	1112	finally
      //   843	869	1112	finally
      //   918	1053	1112	finally
      //   1053	1070	1112	finally
      //   1070	1109	1112	finally
      //   1157	1207	1112	finally
      //   1209	1231	1112	finally
      //   1233	1241	1112	finally
      //   1245	1262	1112	finally
      //   1271	1306	1112	finally
      //   1309	1325	1112	finally
      //   1332	1338	1112	finally
      //   1347	1397	1112	finally
    }
  }
  
  final class b
    extends pf
  {
    private int b = 0;
    
    b()
    {
      super(2130903259, true);
    }
    
    protected final void a(int paramInt)
    {
      Log.i("registername/updatestate/state " + paramInt);
      this.b = paramInt;
      if ((paramInt == 1) || (RegisterName.M(RegisterName.this).b()))
      {
        findViewById(2131755852).setVisibility(4);
        findViewById(2131755457).setVisibility(4);
        RegisterName.N(RegisterName.this).c().remove("com.whatsapp.registername.initializer_start_time").apply();
        if (RegisterName.L(RegisterName.this) != null) {
          RegisterName.L(RegisterName.this).setVisibility(4);
        }
        RegisterName.O(RegisterName.this).removeMessages(0);
        Log.i("registername/sync/finished");
        Intent localIntent = new Intent(RegisterName.this, Main.class);
        RegisterName.this.startActivity(localIntent);
        RegisterName.this.finish();
        RegisterName.r();
        d.b(RegisterName.this, 0);
        return;
      }
      findViewById(2131755852).setVisibility(0);
      findViewById(2131755457).setVisibility(0);
    }
    
    protected final void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      getWindow().setFormat(1);
      getWindow().addFlags(4096);
      getWindow().setSoftInputMode(3);
      if (paramBundle == null) {}
      for (int i = 0;; i = paramBundle.getInt("state"))
      {
        a(i);
        RegisterName.a(RegisterName.this, findViewById(2131755853));
        if (RegisterName.L(RegisterName.this) != null) {
          RegisterName.L(RegisterName.this).setOnClickListener(ao.a(this));
        }
        if (Build.VERSION.SDK_INT >= 21)
        {
          getWindow().addFlags(Integer.MIN_VALUE);
          getWindow().setStatusBarColor(getContext().getResources().getColor(2131624104));
          getWindow().setNavigationBarColor(getContext().getResources().getColor(2131623964));
        }
        return;
      }
    }
    
    public final Bundle onSaveInstanceState()
    {
      Bundle localBundle = super.onSaveInstanceState();
      localBundle.putInt("state", this.b);
      return localBundle;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/registration/RegisterName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */