package com.whatsapp.registration;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.m;
import android.support.v4.view.ae;
import android.support.v7.app.b.a;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.whatsapp.atv;
import com.whatsapp.av;
import com.whatsapp.contact.sync.i;
import com.whatsapp.data.ad;
import com.whatsapp.g.j;
import com.whatsapp.i.b;
import com.whatsapp.i.b.c;
import com.whatsapp.i.b.h;
import com.whatsapp.i.b.i;
import com.whatsapp.nh;
import com.whatsapp.twofactor.q;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class VerifyTwoFactorAuth
  extends nh
{
  private CountDownTimer A;
  private d B;
  private a C;
  private final Handler D = new Handler(Looper.getMainLooper());
  private final Runnable E = cl.a(this);
  private final com.whatsapp.util.a.c F = com.whatsapp.util.a.c.a();
  private final ad G = ad.a();
  private final b H = b.a();
  private final i I = i.a();
  private final aw J = aw.a();
  private final q K = q.a();
  private final bk L = bk.a();
  private final bb M = bb.a();
  private final bc.a N = new bc.a(this);
  au n = new au(this.H, this.aE, this.aM, this.aP, this.aQ);
  private CodeInputField o;
  private ProgressBar p;
  private TextView q;
  private String r;
  private String s;
  private boolean t;
  private String u;
  private String v;
  private long w;
  private long x;
  private long y;
  private long z;
  
  private void a(long paramLong)
  {
    if (paramLong < 1000L)
    {
      r();
      n();
      return;
    }
    long l = q();
    getPreferences(0).edit().putLong("code_retry_time", l + paramLong).apply();
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.o.getWindowToken(), 0);
    this.o.setEnabled(false);
    this.p.setProgress(0);
    this.q.setText(2131298007);
    this.q.setVisibility(0);
    this.A = new CountDownTimer(paramLong, paramLong)
    {
      public final void onFinish()
      {
        VerifyTwoFactorAuth.c(VerifyTwoFactorAuth.this);
        VerifyTwoFactorAuth.d(VerifyTwoFactorAuth.this).setEnabled(true);
        VerifyTwoFactorAuth.b(VerifyTwoFactorAuth.this).setProgress(100);
        VerifyTwoFactorAuth.e(VerifyTwoFactorAuth.this).setVisibility(4);
        VerifyTwoFactorAuth.e(VerifyTwoFactorAuth.this).setText(2131298024);
        VerifyTwoFactorAuth.f(VerifyTwoFactorAuth.this);
      }
      
      public final void onTick(long paramAnonymousLong)
      {
        VerifyTwoFactorAuth.b(VerifyTwoFactorAuth.this).setProgress((int)((this.a - paramAnonymousLong) * 100.0D / this.a));
      }
    }.start();
  }
  
  private void a(String paramString, int paramInt, boolean paramBoolean)
  {
    paramString = new d(paramString, paramInt, paramBoolean);
    this.B = paramString;
    bu.a(paramString, new String[0]);
  }
  
  static boolean a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    return paramLong2 - paramLong3 * 1000L + 1000L * paramLong4 >= paramLong1;
  }
  
  private void c(long paramLong)
  {
    Log.d("verifytwofactorauth/do-check-if-exists");
    this.D.postDelayed(this.E, paramLong);
  }
  
  private void c(boolean paramBoolean)
  {
    this.o.setEnabled(paramBoolean);
    ProgressBar localProgressBar = this.p;
    if (paramBoolean) {}
    for (int i = 100;; i = 0)
    {
      localProgressBar.setProgress(i);
      return;
    }
  }
  
  private Dialog d(int paramInt)
  {
    ProgressDialog localProgressDialog = new ProgressDialog(this);
    localProgressDialog.setMessage(getString(paramInt));
    localProgressDialog.setIndeterminate(true);
    localProgressDialog.setCancelable(false);
    return localProgressDialog;
  }
  
  private void d(boolean paramBoolean)
  {
    Log.d("verifytwofactorauth/stop-checking-if-exists");
    if (this.C != null) {
      this.C.cancel(true);
    }
    if (paramBoolean)
    {
      this.x = -1L;
      u();
    }
    this.D.removeCallbacks(this.E);
  }
  
  private void n()
  {
    if (this.A != null)
    {
      this.A.cancel();
      this.A = null;
    }
  }
  
  private long o()
  {
    return this.z + this.w * 1000L - q();
  }
  
  private int p()
  {
    if (o() > 0L) {}
    do
    {
      return 1;
      if ("offline".equals(this.u)) {
        return 2;
      }
    } while (!"full".equals(this.u));
    return 3;
  }
  
  private static long q()
  {
    return ((j)b.a.a.c.a().a(j.class)).a();
  }
  
  private void r()
  {
    getPreferences(0).edit().remove("code_retry_time").apply();
  }
  
  private void s()
  {
    this.J.e();
    startActivity(new Intent(this, RegisterPhone.class));
    finish();
  }
  
  private void t()
  {
    d(false);
    c(0L);
  }
  
  private void u()
  {
    this.aQ.a(this.u, this.v, this.w, this.x, this.y, this.z);
  }
  
  public final void c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 2131298044: 
      do
      {
        return;
      } while (!this.o.isEnabled());
      ((InputMethodManager)getSystemService("input_method")).toggleSoftInput(1, 0);
      return;
    }
    s();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Log.i("verifytwofactorauth/on-create");
    super.onCreate(paramBundle);
    Object localObject = getIntent();
    if ((((Intent)localObject).getExtras() != null) && (((Intent)localObject).getBooleanExtra("changenumber", false)))
    {
      Log.d("verifytwofactorauth/on-create/changenumber");
      this.t = true;
    }
    setContentView(2130903081);
    localObject = (Toolbar)findViewById(2131755264);
    if (!ae.a(ViewConfiguration.get(getApplicationContext())))
    {
      a((Toolbar)localObject);
      localObject = i();
      if (localObject != null)
      {
        ((android.support.v7.app.a)localObject).a(false);
        ((android.support.v7.app.a)localObject).b();
      }
    }
    this.o = ((CodeInputField)findViewById(2131755323));
    this.o.a(new CodeInputField.a()
    {
      public final void a(String paramAnonymousString)
      {
        VerifyTwoFactorAuth.a(VerifyTwoFactorAuth.this);
      }
      
      public final void b(String paramAnonymousString) {}
    }, '*', '*', CodeInputField.a(this));
    this.o.setPasswordTransformationEnabled(true);
    this.p = ((ProgressBar)findViewById(2131755324));
    c(true);
    this.q = ((TextView)findViewById(2131755325));
    this.r = this.aQ.F();
    this.s = this.aQ.G();
    this.u = this.aQ.a.getString("registration_wipe_type", null);
    this.v = this.aQ.a.getString("registration_wipe_token", null);
    this.w = this.aQ.a.getLong("registration_wipe_wait", -1L);
    this.x = this.aQ.a.getLong("registration_wipe_expiry", -1L);
    this.y = this.aQ.a.getLong("registration_wipe_server_time", -1L);
    this.z = this.aQ.a.getLong("registration_wipe_info_timestamp", -1L);
    if (this.x > 0L) {
      t();
    }
    if ((paramBundle != null) && (!paramBundle.getBoolean("shouldShowTheForgetPinDialog", false))) {
      h("forgotPinDialogTag");
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 32: 
      return new b.a(this).b(getString(2131297527, new Object[] { getString(2131296506) })).a(2131297331, cm.a(this)).a();
    case 31: 
      return d(2131297591);
    case 33: 
      return d(2131298038);
    case 34: 
      return d(2131298033);
    case 124: 
      return bc.a(this, this.aq, this.r, this.s, cn.a(this));
    }
    return bc.a(this, this.aE, this.aM, this.aP, this.aQ);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add(0, 0, 0, 2131297595);
    if (av.d()) {
      paramMenu.add(0, 1, 0, "Reset");
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    Log.i("verifytwofactorauth/on-destroy");
    if (this.B != null) {
      this.B.cancel(true);
    }
    d(false);
    n();
    this.n.a();
    super.onDestroy();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    String str = "register-2fa +" + this.r + this.s;
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 0: 
      this.L.a("verify-2fa");
      this.n.a(this, this.L, str);
      return true;
    }
    this.J.e();
    startActivity(new Intent(this, EULA.class));
    finish();
    return true;
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.A == null)
    {
      long l = getPreferences(0).getLong("code_retry_time", -1L);
      if (l != -1L) {
        a(l - q());
      }
    }
    this.o.requestFocus();
    TextView localTextView = (TextView)findViewById(2131755322);
    localTextView.setText(bc.a(getString(2131298042), "forgot-pin", co.a(this)));
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    if (j_().a("forgotPinDialogTag") != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.putBoolean("shouldShowTheForgetPinDialog", bool);
      super.onSaveInstanceState(paramBundle);
      return;
    }
  }
  
  public final class a
    extends AsyncTask<Void, Void, b.c>
  {
    private final long b = 5000L;
    
    protected a() {}
    
    private b.c a()
    {
      try
      {
        Object localObject = (byte[])a.d.a(com.whatsapp.r.c(bc.a(VerifyTwoFactorAuth.h(VerifyTwoFactorAuth.this) + VerifyTwoFactorAuth.i(VerifyTwoFactorAuth.this))));
        bj localbj = bj.a(VerifyTwoFactorAuth.this, VerifyTwoFactorAuth.i(VerifyTwoFactorAuth.this));
        localObject = VerifyTwoFactorAuth.j(VerifyTwoFactorAuth.this).a(VerifyTwoFactorAuth.h(VerifyTwoFactorAuth.this).getBytes(), VerifyTwoFactorAuth.i(VerifyTwoFactorAuth.this).getBytes(), (byte[])localObject, localbj.toString(), "-1".getBytes());
        return (b.c)localObject;
      }
      catch (Exception localException)
      {
        Log.d("verifytwofactorauth/checkifexists/error", localException);
      }
      return null;
    }
  }
  
  public static final class b
    extends m
  {
    @SuppressLint({"InflateParams"})
    public final Dialog c(Bundle paramBundle)
    {
      paramBundle = i();
      int i = paramBundle.getInt("wipeStatus");
      long l1 = paramBundle.getLong("timeToWaitInMillis");
      b.a locala = new b.a(k());
      View localView1 = LayoutInflater.from(k()).inflate(2130903388, null);
      TextView localTextView = (TextView)localView1.findViewById(2131756144);
      paramBundle = localView1.findViewById(16908313);
      View localView2 = localView1.findViewById(16908314);
      View localView3 = localView1.findViewById(16908315);
      View localView4 = localView1.findViewById(2131755179);
      paramBundle.setOnClickListener(cp.a(this));
      localView2.setOnClickListener(cq.a(this));
      switch (i)
      {
      }
      for (;;)
      {
        locala.a(localView1);
        return locala.a();
        paramBundle = u.a;
        long l2 = TimeUnit.DAYS.toMillis(1L);
        if (l1 > l2)
        {
          i = (int)(l1 / l2);
          paramBundle = paramBundle.a(2131230740, i, new Object[] { Integer.valueOf(i) });
        }
        for (;;)
        {
          localTextView.setText(a(2131298025, new Object[] { paramBundle }));
          break;
          l2 = TimeUnit.HOURS.toMillis(1L);
          if (l1 > l2)
          {
            i = (int)(l1 / l2);
            paramBundle = paramBundle.a(2131230755, i, new Object[] { Integer.valueOf(i) });
          }
          else
          {
            l2 = TimeUnit.MINUTES.toMillis(1L);
            if (l1 > l2)
            {
              i = (int)(l1 / l2);
              paramBundle = paramBundle.a(2131230763, i, new Object[] { Integer.valueOf(i) });
            }
            else
            {
              i = (int)(l1 / TimeUnit.SECONDS.toMillis(1L));
              paramBundle = paramBundle.a(2131230793, i, new Object[] { Integer.valueOf(i) });
            }
          }
        }
        localTextView.setText(2131298027);
        localView3.setOnClickListener(cr.a(this));
        localView3.setVisibility(0);
        localView4.setVisibility(0);
      }
    }
  }
  
  public static final class c
    extends m
  {
    public final Dialog c(Bundle paramBundle)
    {
      int i = i().getInt("wipeStatus");
      paramBundle = (VerifyTwoFactorAuth)l();
      paramBundle = new b.a(paramBundle).a(2131298026, cs.a(paramBundle)).b(2131296398, null);
      switch (i)
      {
      }
      for (;;)
      {
        return paramBundle.a();
        paramBundle.b(2131298031);
        continue;
        paramBundle.b(2131298030);
      }
    }
  }
  
  final class d
    extends AsyncTask<String, Void, b.i>
  {
    b.h a;
    private final String c;
    private final boolean d;
    private final int e;
    private final int f;
    
    d(String paramString, int paramInt, boolean paramBoolean)
    {
      this.c = paramString;
      this.d = paramBoolean;
      this.e = paramInt;
      switch (paramInt)
      {
      default: 
        this.f = 31;
        return;
      case 1: 
        this.f = 33;
        return;
      }
      this.f = 34;
    }
    
    private b.i a()
    {
      Log.d("verifytwofactorauth/verifycodetask code=" + this.c + " resetMode=" + this.e);
      try
      {
        if (this.c != null) {}
        for (this.a = VerifyTwoFactorAuth.j(VerifyTwoFactorAuth.this).a(VerifyTwoFactorAuth.h(VerifyTwoFactorAuth.this), VerifyTwoFactorAuth.i(VerifyTwoFactorAuth.this), this.c, null, null);; this.a = VerifyTwoFactorAuth.j(VerifyTwoFactorAuth.this).a(VerifyTwoFactorAuth.h(VerifyTwoFactorAuth.this), VerifyTwoFactorAuth.i(VerifyTwoFactorAuth.this), "email", null))
        {
          return this.a.a;
          if (this.e != 1) {
            break;
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("verifytwofactorauth/verifycodetask/ioerror " + localIOException.toString());
          return b.i.c;
          if (this.e == 2) {
            this.a = VerifyTwoFactorAuth.j(VerifyTwoFactorAuth.this).a(VerifyTwoFactorAuth.h(VerifyTwoFactorAuth.this), VerifyTwoFactorAuth.i(VerifyTwoFactorAuth.this), "wipe", VerifyTwoFactorAuth.k(VerifyTwoFactorAuth.this));
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("verifytwofactorauth/verifycodetask/error " + localException.toString());
      }
      return b.i.b;
    }
    
    protected final void onCancelled()
    {
      VerifyTwoFactorAuth.a(VerifyTwoFactorAuth.this, true);
    }
    
    protected final void onPreExecute()
    {
      Log.i("verifytwofactorauth/verifycodetask/pre");
      VerifyTwoFactorAuth.a(VerifyTwoFactorAuth.this, false);
      d.a(VerifyTwoFactorAuth.this, this.f);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/registration/VerifyTwoFactorAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */