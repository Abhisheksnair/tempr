package com.whatsapp.registration;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.f.h;
import android.support.v4.view.ae;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.whatsapp.Main;
import com.whatsapp.aic;
import com.whatsapp.al;
import com.whatsapp.and;
import com.whatsapp.ane;
import com.whatsapp.atv;
import com.whatsapp.aus;
import com.whatsapp.av;
import com.whatsapp.data.ad;
import com.whatsapp.i.b.f;
import com.whatsapp.i.b.g;
import com.whatsapp.i.b.j;
import com.whatsapp.i.b.k;
import com.whatsapp.nh;
import com.whatsapp.pv;
import com.whatsapp.util.Log;
import com.whatsapp.util.az;
import com.whatsapp.util.l;
import java.io.IOException;

public class VerifySms
  extends nh
{
  static final long n;
  static int o;
  private static int v;
  private static int w;
  private long A = 0L;
  private String B;
  private boolean C;
  private boolean D;
  private CountDownTimer E;
  private final c F = new c(Looper.getMainLooper());
  private a G;
  private a H;
  private boolean I;
  private ImageButton J;
  private final bc.a K = new bc.a(this);
  private final com.whatsapp.util.a.c L = com.whatsapp.util.a.c.a();
  private final ad M = ad.a();
  private final com.whatsapp.i.b N = com.whatsapp.i.b.a();
  private final bi O = bi.a();
  private final aus P = aus.a();
  private final aw Q = aw.a();
  private final bk R = bk.a();
  private final y S = new y(this);
  private boolean T;
  private int U = -2;
  String p;
  String q;
  int r;
  final and s = and.a();
  final bb t = bb.a();
  au u = new au(this.N, this.s, this.aM, this.aP, this.aQ);
  private CodeInputField x;
  private String y;
  private boolean z;
  
  static
  {
    if (av.d()) {}
    for (long l = 20000L;; l = 300000L)
    {
      n = l;
      o = 0;
      v = 6;
      w = 6;
      return;
    }
  }
  
  private long A()
  {
    return getPreferences(0).getLong("com.whatsapp.registration.VerifySms.sms_request_failed_retry_time", -1L);
  }
  
  private void B()
  {
    SharedPreferences.Editor localEditor = getPreferences(0).edit();
    localEditor.remove("com.whatsapp.registration.VerifySms.code_verification_retry_time");
    if (!localEditor.commit()) {
      Log.e("verifysms/clear-code-verification-retry-time/error");
    }
  }
  
  private void C()
  {
    SharedPreferences.Editor localEditor = getPreferences(0).edit();
    localEditor.remove("com.whatsapp.registration.VerifySms.call_countdown_end_time");
    if (!localEditor.commit()) {
      Log.e("verifysms/clear-voice-retry-time/error");
    }
  }
  
  private long D()
  {
    return getPreferences(0).getLong("com.whatsapp.registration.VerifySms.call_countdown_end_time", -1L);
  }
  
  private void E()
  {
    long l = D();
    if (l != -1L)
    {
      l -= System.currentTimeMillis();
      if (l > 0L) {
        this.H.a(l, true);
      }
    }
    else
    {
      return;
    }
    C();
  }
  
  private static String a(Intent paramIntent)
  {
    Object localObject2 = null;
    Object localObject1;
    if ("whatsapp".equals(paramIntent.getScheme()))
    {
      paramIntent = paramIntent.getData();
      localObject1 = localObject2;
      if (paramIntent != null)
      {
        localObject1 = localObject2;
        if ("r".equals(paramIntent.getHost()))
        {
          localObject1 = paramIntent.getQueryParameter("c");
          Log.i("verifysms/codefromverificationlink/code/" + (String)localObject1);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          return (String)localObject1;
          if ("http".equals(paramIntent.getScheme())) {
            break;
          }
          localObject1 = localObject2;
        } while (!"https".equals(paramIntent.getScheme()));
        paramIntent = paramIntent.getData();
        localObject1 = localObject2;
      } while (paramIntent == null);
      localObject1 = localObject2;
    } while (!"v.whatsapp.com".equals(paramIntent.getHost()));
    paramIntent = paramIntent.getPath();
    paramIntent = paramIntent.substring(paramIntent.lastIndexOf("/") + 1);
    Log.i("verifysms/codefromverificationlink/code/" + paramIntent);
    return paramIntent;
  }
  
  private void a(final long paramLong)
  {
    if (this.E != null)
    {
      this.E.cancel();
      this.E = null;
    }
    if (paramLong < 1000L)
    {
      B();
      return;
    }
    this.I = true;
    long l = System.currentTimeMillis();
    Object localObject = getPreferences(0).edit();
    ((SharedPreferences.Editor)localObject).putLong("com.whatsapp.registration.VerifySms.code_verification_retry_time", l + paramLong);
    if (!((SharedPreferences.Editor)localObject).commit()) {
      Log.e("verifysms/save-code-verification-retry-time/error");
    }
    this.x.setEnabled(false);
    localObject = (ProgressBar)findViewById(2131755324);
    ((ProgressBar)localObject).setProgress(0);
    final TextView localTextView = (TextView)findViewById(2131756158);
    localTextView.setText(2131298083);
    this.E = new CountDownTimer(paramLong, (ProgressBar)localObject)
    {
      public final void onFinish()
      {
        VerifySms.a(VerifySms.this);
        VerifySms.b(VerifySms.this).setEnabled(true);
        paramLong.setProgress(100);
        this.c.setText(VerifySms.this.getString(2131298082, new Object[] { Integer.valueOf(VerifySms.p()) }));
        VerifySms.c(VerifySms.this);
        VerifySms.d(VerifySms.this);
        String str = VerifySms.e(VerifySms.this);
        if (str != null)
        {
          Log.i("verifysms/countdowntimer/done/try-savedcode");
          VerifySms.f(VerifySms.this);
          com.whatsapp.util.bu.a(new VerifySms.d(VerifySms.this), new String[] { str, "tapped" });
        }
      }
      
      public final void onTick(long paramAnonymousLong)
      {
        paramLong.setProgress((int)((localTextView - paramAnonymousLong) * 100.0D / localTextView));
      }
    }.start();
  }
  
  private void c(long paramLong)
  {
    Log.i("verifysms/save-sms-retry-time/" + paramLong);
    SharedPreferences.Editor localEditor = getPreferences(0).edit();
    localEditor.putLong("com.whatsapp.registration.VerifySms.sms_request_failed_retry_time", paramLong);
    if (!localEditor.commit()) {
      Log.e("verifysms/save-sms-retry-time/error");
    }
  }
  
  private void c(String paramString)
  {
    if (this.I)
    {
      Log.i("verifysms/verificationlink/voice/code-entry-blocked-retry-later");
      a(paramString);
      return;
    }
    Log.i("verifysms/verificationlink/voice/state " + o);
    this.x.setText(paramString);
  }
  
  private void d(long paramLong)
  {
    SharedPreferences.Editor localEditor = getPreferences(0).edit();
    localEditor.putLong("com.whatsapp.registration.VerifySms.call_countdown_end_time", paramLong);
    if (!localEditor.commit()) {
      Log.e("verifysms/save-voice-retry-time/error");
    }
  }
  
  private void q()
  {
    if (!this.T) {
      return;
    }
    unregisterReceiver(this.S);
    this.T = false;
  }
  
  private String r()
  {
    Object localObject2 = null;
    SharedPreferences localSharedPreferences = getPreferences(0);
    String str1 = localSharedPreferences.getString("com.whatsapp.registration.VerifySms.sms_cc", null);
    String str2 = localSharedPreferences.getString("com.whatsapp.registration.VerifySms.sms_phone_number", null);
    Object localObject1 = localObject2;
    if (this.p.equals(str1))
    {
      localObject1 = localObject2;
      if (this.q.equals(str2)) {
        localObject1 = localSharedPreferences.getString("com.whatsapp.registration.VerifySms.sms_code", null);
      }
    }
    return (String)localObject1;
  }
  
  private void s()
  {
    SharedPreferences.Editor localEditor = getPreferences(0).edit();
    localEditor.remove("com.whatsapp.registration.VerifySms.sms_code");
    localEditor.remove("com.whatsapp.registration.VerifySms.sms_cc");
    localEditor.remove("com.whatsapp.registration.VerifySms.sms_phone_number");
    if (!localEditor.commit()) {
      Log.w("verifysms/savedcode/clear/commit failed");
    }
  }
  
  private void t()
  {
    this.aK.b();
    Object localObject = this.s.e;
    int j;
    if (localObject == null)
    {
      Log.w("verifysms/check-network-state cm=null");
      j = -1;
      Log.i("verifysms/network/switch old=" + this.U + " new=" + j);
      this.U = j;
      if ((this.U != -1) && (this.F.hasMessages(1)))
      {
        Log.i("verifysms/network/switch/has-retry-pending");
        this.F.removeMessages(1);
        this.r = 0;
        localObject = r();
        if (localObject == null) {
          break label182;
        }
        localObject = this.F.obtainMessage(1, localObject);
        this.F.sendMessage((Message)localObject);
      }
    }
    else
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      Log.i("verifysms/network/active " + localObject);
      if (localObject == null) {}
      for (int i = -1;; i = ((NetworkInfo)localObject).getType())
      {
        j = i;
        if (i != this.U) {
          break;
        }
        return;
      }
    }
    label182:
    Log.e("verifysms/network/switch/no-saved-code");
  }
  
  private void u()
  {
    this.y = ("+" + this.p + this.q);
    String str = getString(2131297577);
    ((TextView)findViewById(2131756152)).setText(str);
    ((TextView)findViewById(2131756158)).setText(getString(2131297576));
    findViewById(2131756159).setVisibility(8);
    findViewById(2131756162).setVisibility(8);
    findViewById(2131756154).setVisibility(8);
    d.a(this, 124);
  }
  
  private String v()
  {
    long l1 = -1L;
    long l2 = A();
    long l3 = System.currentTimeMillis();
    if (l2 != -1L) {
      l1 = l2 - l3;
    }
    Log.i("verifysms/sms-retry-time/diff/" + l1);
    if (l2 > l3) {
      return getString(2131297560, new Object[] { getString(2131298091), l.d(this, l1) });
    }
    return getString(2131297559, new Object[] { getString(2131298091) });
  }
  
  private String w()
  {
    long l1 = -1L;
    long l2 = D();
    if (l2 != -1L) {
      l1 = l2 - System.currentTimeMillis();
    }
    Log.i("verifysms/voice-retry-time/diff/" + l1);
    if (l1 > 0L) {
      return getString(2131297555, new Object[] { getString(2131298098), l.d(this, l1) });
    }
    return getString(2131297554, new Object[] { getString(2131298098) });
  }
  
  private String x()
  {
    long l1 = -1L;
    long l2 = A();
    long l3 = System.currentTimeMillis();
    if (l2 != -1L) {
      l1 = l2 - l3;
    }
    Log.i("verifysms/sms-retry-time/diff/" + l1);
    if (l1 > 0L) {
      return getString(2131297557, new Object[] { getString(2131298091), l.d(this, l1) });
    }
    return getString(2131297556, new Object[] { getString(2131298091) });
  }
  
  private String y()
  {
    long l1 = -1L;
    long l2 = D();
    long l3 = System.currentTimeMillis();
    if (l2 != -1L) {
      l1 = l2 - l3;
    }
    Log.i("verifysms/voice-retry-time/diff/" + l1);
    if (l1 > 0L) {
      return getString(2131297553, new Object[] { getString(2131298098), l.d(this, l1) });
    }
    return getString(2131297552, new Object[] { getString(2131298098) });
  }
  
  private void z()
  {
    SharedPreferences.Editor localEditor = getPreferences(0).edit();
    localEditor.remove("com.whatsapp.registration.VerifySms.sms_request_failed_retry_time");
    if (!localEditor.commit()) {
      Log.e("verifysms/clear-sms-retry-time/error");
    }
  }
  
  final void a(String paramString)
  {
    SharedPreferences.Editor localEditor = getPreferences(0).edit();
    localEditor.putString("com.whatsapp.registration.VerifySms.sms_code", paramString);
    localEditor.putString("com.whatsapp.registration.VerifySms.sms_cc", this.p);
    localEditor.putString("com.whatsapp.registration.VerifySms.sms_phone_number", this.q);
    if (!localEditor.commit()) {
      Log.w("verifysms/savedcode/save/commit failed");
    }
  }
  
  public final void b(String paramString)
  {
    if ((paramString == null) || (paramString.length() != v)) {
      return;
    }
    if ((paramString != null) && (paramString.length() == v))
    {
      int j = paramString.length();
      i = 0;
      while (i < j)
      {
        if (!Character.isDigit(paramString.charAt(i))) {
          break label86;
        }
        i += 1;
      }
    }
    label86:
    for (int i = 1; i != 0; i = 0)
    {
      com.whatsapp.util.bu.a(new e(), new String[] { paramString });
      return;
    }
    d.a(this, 33);
  }
  
  final void c(boolean paramBoolean)
  {
    ((InputMethodManager)getSystemService("input_method")).toggleSoftInput(0, 0);
    TelephonyManager localTelephonyManager = this.s.c;
    if (localTelephonyManager != null)
    {
      Log.d("verifysms/verify-number/network " + localTelephonyManager.getNetworkOperator());
      Log.d("verifysms/verify-number/network/name " + localTelephonyManager.getNetworkOperatorName());
      Log.d("verifysms/verify-number/sim " + localTelephonyManager.getSimOperator() + " name=" + localTelephonyManager.getSimOperatorName());
      Log.d("verifysms/verify-number/verification_state " + o);
    }
    for (;;)
    {
      Log.i("verifysms/request-sms");
      this.aQ.h(null);
      com.whatsapp.util.bu.a(new a(paramBoolean), new String[0]);
      return;
      Log.d("verifysms/verify-number tm=null");
    }
  }
  
  final void l()
  {
    Object localObject = this.P.d();
    String str = this.P.c();
    localObject = new Intent("android.intent.action.VIEW", aic.j().appendPath("link").appendPath("verification.php").appendQueryParameter("platform", "android").appendQueryParameter("lc", str).appendQueryParameter("lg", (String)localObject).build());
    try
    {
      startActivity((Intent)localObject);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      pv.a(this, 2131296289, 0);
    }
  }
  
  final void m()
  {
    o = 0;
    n();
    this.F.removeMessages(1);
    Intent localIntent;
    if (!this.D)
    {
      this.t.a(1);
      localIntent = new Intent(this, RegisterPhone.class);
      localIntent.putExtra("com.whatsapp.registration.RegisterPhone.clear_phone_number", true);
    }
    for (;;)
    {
      C();
      z();
      B();
      startActivity(localIntent);
      finish();
      return;
      this.t.a(3);
      Log.i("verifysms/returntoregphone/changenumber/setregverified");
      if (!this.Q.b(this.M, this.aH)) {
        finish();
      }
      localIntent = new Intent(this, ChangeNumber.class);
    }
  }
  
  final void n()
  {
    SharedPreferences.Editor localEditor = getPreferences(0).edit();
    localEditor.putInt("com.whatsapp.registration.VerifySms.verification_state", o);
    if (!localEditor.commit()) {
      Log.w("verifysms/savestate/commit failed");
    }
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("verifysms/create");
    super.onCreate(paramBundle);
    b.a.a.c.a().a(this, false);
    setContentView(2130903391);
    Object localObject = (Toolbar)findViewById(2131755264);
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
    localObject = getIntent();
    if (("whatsapp".equals(((Intent)localObject).getScheme())) || ("http".equals(((Intent)localObject).getScheme())) || ("https".equals(((Intent)localObject).getScheme())))
    {
      if (this.t.c() == 1)
      {
        paramBundle = new Intent(this, RegisterPhone.class);
        paramBundle.putExtra("com.whatsapp.registration.RegisterPhone.tapped_sms_link", true);
        startActivity(paramBundle);
        finish();
        return;
      }
      this.B = a((Intent)localObject);
      Log.i("verifysms/create/code " + this.B);
    }
    for (;;)
    {
      int i = this.t.c();
      if (i == 4) {
        break;
      }
      Log.e("verifysms/wrong-state bounce to main " + i);
      startActivity(new Intent(this, Main.class));
      finish();
      return;
      this.B = null;
    }
    this.y = null;
    boolean bool;
    long l1;
    if (paramBundle != null)
    {
      bool = true;
      this.C = bool;
      if (this.O.a)
      {
        Log.i("verifysms/create/display-roaming");
        findViewById(2131756153).setVisibility(0);
      }
      if (getIntent().getExtras() != null)
      {
        if (getIntent().getBooleanExtra("changenumber", false))
        {
          Log.d("verifysms/create/changenumber");
          this.D = true;
        }
        Log.i("verifysms/create/ssend");
        if (paramBundle == null)
        {
          l1 = getIntent().getLongExtra("sms_retry_time", 0L);
          long l2 = getIntent().getLongExtra("voice_retry_time", 0L);
          bool = getIntent().getBooleanExtra("is_potentially_biz_client", false);
          Log.d("verifysms/create/sms_retry=" + l1 + ", voice-retry=" + l2 + ", potentially-biz=" + bool);
          c(l1);
          d(l2);
          paramBundle = getPreferences(0).edit();
          if (!bool) {
            break label555;
          }
          paramBundle.putBoolean("com.whatsapp.registration.VerifySms.is_potentially_biz_client", true);
        }
      }
    }
    for (;;)
    {
      if (!paramBundle.commit()) {
        Log.e("verifysms/set-is-potentially-biz-client/error");
      }
      setIntent(new Intent(this, VerifySms.class));
      this.p = this.aQ.F();
      this.q = this.aQ.G();
      if ((!TextUtils.isEmpty(this.p)) && (!TextUtils.isEmpty(this.q))) {
        break label568;
      }
      Log.w("verifysms/create/cc or num is missing, bounce to regphone");
      m();
      return;
      bool = false;
      break;
      label555:
      paramBundle.remove("com.whatsapp.registration.VerifySms.is_potentially_biz_client");
    }
    label568:
    this.O.a(new bi.a(this));
    this.x = ((CodeInputField)findViewById(2131756156));
    paramBundle = this.x;
    paramBundle.a(new CodeInputField.a()
    {
      public final void a(String paramAnonymousString)
      {
        VerifySms.this.b(paramAnonymousString);
      }
      
      public final void b(String paramAnonymousString) {}
    }, '–', '•', new f(paramBundle));
    ((ProgressBar)findViewById(2131755324)).setProgress(100);
    findViewById(2131756163).setOnClickListener(cb.a(this));
    this.J = ((ImageButton)findViewById(2131756157));
    this.J.setImageDrawable(new az(getResources().getDrawable(2130840050)));
    this.J.setOnClickListener(cc.a(this));
    findViewById(2131756160).setOnClickListener(cd.a(this));
    this.G = new a(this.aq, this, "sms", 2131756160, 2131756161, 2130840228, 2130840227, 2131298091, 2131298092);
    this.H = new a(this.aq, this, "voice", 2131756163, 2131756164, 2130840226, 2130840225, 2131298098, 2131298099);
    paramBundle = al.a(this.aq, bc.a(this.p, this.q));
    localObject = (TextView)findViewById(2131755265);
    if (localObject != null) {
      ((TextView)localObject).setText(getString(2131298096, new Object[] { paramBundle }));
    }
    findViewById(2131756162).setVisibility(0);
    ((TextView)findViewById(2131756158)).setText(getString(2131298082, new Object[] { Integer.valueOf(w) }));
    findViewById(2131756154).setVisibility(0);
    localObject = (TextView)findViewById(2131756152);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.replaceAll(" ", "&nbsp;");
      label932:
      l1 = System.currentTimeMillis();
      if (A() <= l1) {
        break label1141;
      }
      if (D() - l1 >= 5000L) {
        break label1122;
      }
      paramBundle = getString(2131298094, new Object[] { paramBundle });
    }
    for (;;)
    {
      ((TextView)localObject).setText(bc.a(paramBundle, "edit-number", bw.a(this)));
      if (av.j()) {
        ((TextView)localObject).setOnClickListener(bl.a(this));
      }
      ((TextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
      this.J.setVisibility(4);
      t();
      paramBundle = getResources().getDisplayMetrics();
      if (paramBundle.heightPixels / paramBundle.density < 500.0F) {
        getWindow().setSoftInputMode(2);
      }
      paramBundle = r();
      if (paramBundle == null) {
        break;
      }
      Log.i("verifysms/create/savedcode " + paramBundle);
      com.whatsapp.util.bu.a(new d(), new String[] { paramBundle, "retried" });
      return;
      paramBundle = null;
      break label932;
      label1122:
      paramBundle = getString(2131298095, new Object[] { paramBundle });
      continue;
      label1141:
      if (getPreferences(0).getBoolean("com.whatsapp.registration.VerifySms.is_potentially_biz_client", false)) {
        paramBundle = getString(2131298271);
      } else {
        paramBundle = getString(2131298093, new Object[] { paramBundle });
      }
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = super.onCreateDialog(paramInt);
    case 21: 
    case 34: 
    case 23: 
    case 24: 
    case 25: 
    case 39: 
    case 27: 
    case 28: 
    case 38: 
    case 29: 
    case 42: 
    case 41: 
    case 40: 
    case 30: 
    case 35: 
    case 31: 
    case 36: 
    case 33: 
    case 500: 
      Dialog localDialog;
      do
      {
        do
        {
          return (Dialog)localObject;
          return new android.support.v7.app.b.a(this).b(getString(2131297528, new Object[] { getString(2131296506) })).a(2131297331, ce.a(this)).a();
          return new android.support.v7.app.b.a(this).b(2131297579).a(2131297331, cf.a(this)).a();
          o = 0;
          n();
          this.t.a(1);
          return d.b(this);
          localObject = new ProgressDialog(this);
          ((ProgressDialog)localObject).setMessage(getString(2131297591));
          ((ProgressDialog)localObject).setIndeterminate(true);
          ((ProgressDialog)localObject).setCancelable(false);
          return (Dialog)localObject;
          localObject = new ProgressDialog(this);
          ((ProgressDialog)localObject).setMessage(getString(2131297590));
          ((ProgressDialog)localObject).setIndeterminate(true);
          ((ProgressDialog)localObject).setCancelable(false);
          return (Dialog)localObject;
          localObject = new ProgressDialog(this);
          ((ProgressDialog)localObject).setMessage(getString(2131297567));
          ((ProgressDialog)localObject).setIndeterminate(true);
          ((ProgressDialog)localObject).setCancelable(false);
          return (Dialog)localObject;
          return new android.support.v7.app.b.a(this).b(2131297575).a(false).a(2131297531, cg.a(this, paramInt)).b(2131296398, ch.a(this, paramInt)).a();
          return new android.support.v7.app.b.a(this).b(2131297522).a(false).c(2131297333, ci.a(this, paramInt)).a();
          return new android.support.v7.app.b.a(this).b(v()).a(2131297331, cj.a(this, paramInt)).a();
          return new android.support.v7.app.b.a(this).b(w()).a(2131297331, ck.a(this, paramInt)).a();
          return new android.support.v7.app.b.a(this).b(x()).a(2131297331, bm.a(this, paramInt)).a();
          return new android.support.v7.app.b.a(this).b(y()).a(2131297331, bn.a(this, paramInt)).a();
          return new android.support.v7.app.b.a(this).b(getString(2131297558)).a(false).a(2131297531, bo.a(this, paramInt)).b(2131296398, bp.a(this, paramInt)).a();
          return new android.support.v7.app.b.a(this).b(getString(2131297589, new Object[] { l.d(this, this.A) })).a(false).a(2131297539, bq.a(this, paramInt)).b(2131296398, br.a(this, paramInt)).a();
          return new android.support.v7.app.b.a(this).b(getString(2131297581)).a(false).a(2131297531, bs.a(this, paramInt)).b(2131296398, bt.a(this, paramInt)).a();
          return new android.support.v7.app.b.a(this).b(getString(2131297582, new Object[] { l.d(this, this.A) })).a(false).a(2131297539, bu.a(this, paramInt)).b(2131296398, bv.a(this, paramInt)).a();
          return new android.support.v7.app.b.a(this).b(getString(2131297580, new Object[] { Integer.valueOf(v) })).a(2131297331, bx.a(this)).a();
          localDialog = super.onCreateDialog(paramInt);
          localObject = localDialog;
        } while (localDialog == null);
        localObject = localDialog;
      } while (!this.z);
      localDialog.setCancelable(false);
      localDialog.setOnDismissListener(by.a(this));
      return localDialog;
    case 43: 
      if (av.g()) {}
      for (localObject = getString(2131297561);; localObject = getString(2131297562, new Object[] { "https://whatsapp.com/android" })) {
        return new android.support.v7.app.b.a(this).b(getString(2131297526, new Object[] { localObject })).a(false).a(2131297331, bz.a(this)).a();
      }
    case 124: 
      return bc.a(this, this.aq, this.p, this.q, ca.a(this));
    }
    return bc.a(this, this.s, this.aM, this.aP, this.aQ);
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
    Log.i("verifysms/destroy");
    this.O.b();
    q();
    if (this.E != null)
    {
      this.E.cancel();
      this.E = null;
    }
    if (this.H != null) {
      this.H.a(true);
    }
    if (this.G != null) {
      this.G.a(true);
    }
    b.a.a.c.a().a(this);
    this.u.a();
    super.onDestroy();
  }
  
  public void onEvent(com.whatsapp.g.f paramf)
  {
    t();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((av.j()) && (paramInt == 84))
    {
      com.whatsapp.util.bm.a(this);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    Log.i("verifysms/intent");
    super.onNewIntent(paramIntent);
    String str = a(paramIntent);
    if (str != null)
    {
      if (this.C)
      {
        c(str);
        return;
      }
      Log.i("verifysms/intent/defer-code/" + str);
      this.B = str;
      return;
    }
    int i = paramIntent.getIntExtra("com.whatsapp.verifynumber.dialog", 0);
    switch (i)
    {
    case 22: 
    default: 
      Log.i("verifysms/intent/unknown " + i);
      return;
    case 21: 
      d.a(this, 21);
      return;
    }
    d.a(this, 23);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 0: 
      this.u.a(this, this.R, "verify-sms +" + this.p + this.q);
      return true;
    }
    this.Q.e();
    z();
    C();
    B();
    startActivity(new Intent(this, EULA.class));
    finish();
    return true;
  }
  
  public void onPause()
  {
    Log.i("verifysms/pause " + o);
    super.onPause();
    this.K.b();
    Object localObject = getPreferences(0).edit();
    ((SharedPreferences.Editor)localObject).putInt("com.whatsapp.registration.VerifySms.verification_state", o);
    if (!((SharedPreferences.Editor)localObject).commit()) {
      Log.w("verifysms/pause/commit failed");
    }
    localObject = this.x.getCode();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      this.aQ.h((String)localObject);
    }
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 29: 
      ((android.support.v7.app.b)paramDialog).a(v());
      return;
    case 42: 
      ((android.support.v7.app.b)paramDialog).a(w());
      return;
    case 41: 
      ((android.support.v7.app.b)paramDialog).a(x());
      return;
    }
    ((android.support.v7.app.b)paramDialog).a(y());
  }
  
  public void onResume()
  {
    Log.i("verifysms/resume");
    super.onResume();
    this.K.a();
    o = getPreferences(0).getInt("com.whatsapp.registration.VerifySms.verification_state", 0);
    w = this.aQ.a.getInt("registration_sms_code_length", 6);
    v = this.aQ.a.getInt("registration_voice_code_length", 6);
    this.x.setRegistrationVoiceCodeLength(v);
    if ((this.p == null) || (this.q == null))
    {
      Log.w("verifysms/resume/cc or num is missing, bounce to regphone");
      m();
      return;
    }
    this.t.a(4);
    this.R.a("verify-sms");
    Log.i("verifysms/resume verification_state=" + o);
    switch (o)
    {
    default: 
      long l = A() - System.currentTimeMillis();
      if (l > 0L) {
        this.G.a(l, true);
      }
      break;
    }
    for (;;)
    {
      E();
      if (this.E == null) {
        a(getPreferences(0).getLong("com.whatsapp.registration.VerifySms.code_verification_retry_time", -1L) - System.currentTimeMillis());
      }
      for (;;)
      {
        android.support.v4.app.aw.a(this).a(1);
        if (this.B != null)
        {
          Log.i("verifysms/resume/scheme/code " + this.B);
          c(this.B);
          this.B = null;
        }
        this.C = true;
        return;
        d.a(this, 21);
        continue;
        d.a(this, 23);
        continue;
        u();
      }
      z();
      if (!this.C) {
        c(false);
      }
    }
  }
  
  public final class a
    extends AsyncTask<String, Void, h<b.g, b.f>>
  {
    final String a = "sms";
    final String b = "s";
    final boolean c;
    
    a(boolean paramBoolean)
    {
      this.c = paramBoolean;
      Log.i("verifysms/request " + this.b);
    }
    
    /* Error */
    private h<b.g, b.f> a()
    {
      // Byte code:
      //   0: getstatic 62	com/whatsapp/i/b$g:d	Lcom/whatsapp/i/b$g;
      //   3: astore_2
      //   4: aload_0
      //   5: getfield 18	com/whatsapp/registration/VerifySms$a:d	Lcom/whatsapp/registration/VerifySms;
      //   8: aload_0
      //   9: getfield 18	com/whatsapp/registration/VerifySms$a:d	Lcom/whatsapp/registration/VerifySms;
      //   12: aload_0
      //   13: getfield 18	com/whatsapp/registration/VerifySms$a:d	Lcom/whatsapp/registration/VerifySms;
      //   16: invokestatic 66	com/whatsapp/registration/VerifySms:j	(Lcom/whatsapp/registration/VerifySms;)Ljava/lang/String;
      //   19: aload_0
      //   20: getfield 18	com/whatsapp/registration/VerifySms$a:d	Lcom/whatsapp/registration/VerifySms;
      //   23: invokestatic 69	com/whatsapp/registration/VerifySms:k	(Lcom/whatsapp/registration/VerifySms;)Ljava/lang/String;
      //   26: aload_0
      //   27: getfield 25	com/whatsapp/registration/VerifySms$a:a	Ljava/lang/String;
      //   30: getstatic 72	com/whatsapp/registration/bc:a	Ljava/lang/String;
      //   33: invokestatic 75	com/whatsapp/registration/VerifySms:a	(Lcom/whatsapp/registration/VerifySms;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/i/b$f;
      //   36: astore_1
      //   37: aload_1
      //   38: getfield 79	com/whatsapp/i/b$f:a	Lcom/whatsapp/i/b$g;
      //   41: astore 4
      //   43: aload 4
      //   45: getstatic 81	com/whatsapp/i/b$g:b	Lcom/whatsapp/i/b$g;
      //   48: if_acmpne +41 -> 89
      //   51: new 33	java/lang/StringBuilder
      //   54: dup
      //   55: ldc 83
      //   57: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   60: aload_0
      //   61: getfield 29	com/whatsapp/registration/VerifySms$a:b	Ljava/lang/String;
      //   64: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   67: ldc 85
      //   69: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   72: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   75: invokestatic 88	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
      //   78: aload 4
      //   80: astore_3
      //   81: aload_1
      //   82: astore_2
      //   83: aload_3
      //   84: aload_2
      //   85: invokestatic 93	android/support/v4/f/h:a	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/support/v4/f/h;
      //   88: areturn
      //   89: aload_1
      //   90: astore_2
      //   91: aload 4
      //   93: astore_3
      //   94: aload 4
      //   96: getstatic 94	com/whatsapp/i/b$g:a	Lcom/whatsapp/i/b$g;
      //   99: if_acmpne -16 -> 83
      //   102: aload_1
      //   103: astore_2
      //   104: aload 4
      //   106: astore_3
      //   107: aload_1
      //   108: getfield 97	com/whatsapp/i/b$f:d	I
      //   111: ifeq -28 -> 83
      //   114: aload_1
      //   115: getfield 97	com/whatsapp/i/b$f:d	I
      //   118: invokestatic 100	com/whatsapp/registration/VerifySms:d	(I)I
      //   121: pop
      //   122: aload_1
      //   123: astore_2
      //   124: aload 4
      //   126: astore_3
      //   127: goto -44 -> 83
      //   130: astore_2
      //   131: new 33	java/lang/StringBuilder
      //   134: dup
      //   135: ldc 83
      //   137: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   140: aload_0
      //   141: getfield 29	com/whatsapp/registration/VerifySms$a:b	Ljava/lang/String;
      //   144: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   147: ldc 102
      //   149: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   152: aload_2
      //   153: invokevirtual 103	java/io/IOException:toString	()Ljava/lang/String;
      //   156: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   159: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   162: invokestatic 88	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
      //   165: getstatic 105	com/whatsapp/i/b$g:e	Lcom/whatsapp/i/b$g;
      //   168: astore_3
      //   169: aload_1
      //   170: astore_2
      //   171: goto -88 -> 83
      //   174: astore_3
      //   175: aload_2
      //   176: astore_1
      //   177: aconst_null
      //   178: astore_2
      //   179: new 33	java/lang/StringBuilder
      //   182: dup
      //   183: ldc 83
      //   185: invokespecial 38	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   188: aload_0
      //   189: getfield 29	com/whatsapp/registration/VerifySms$a:b	Ljava/lang/String;
      //   192: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   195: ldc 107
      //   197: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   200: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   203: aload_3
      //   204: invokestatic 110	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   207: aload_1
      //   208: astore_3
      //   209: goto -126 -> 83
      //   212: astore_3
      //   213: aload_2
      //   214: astore 4
      //   216: aload_1
      //   217: astore_2
      //   218: aload 4
      //   220: astore_1
      //   221: goto -42 -> 179
      //   224: astore_3
      //   225: aload_1
      //   226: astore_2
      //   227: aload 4
      //   229: astore_1
      //   230: goto -51 -> 179
      //   233: astore_2
      //   234: aconst_null
      //   235: astore_1
      //   236: goto -105 -> 131
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	239	0	this	a
      //   36	200	1	localObject1	Object
      //   3	121	2	localObject2	Object
      //   130	23	2	localIOException1	IOException
      //   170	57	2	localObject3	Object
      //   233	1	2	localIOException2	IOException
      //   80	89	3	localObject4	Object
      //   174	30	3	localException1	Exception
      //   208	1	3	localObject5	Object
      //   212	1	3	localException2	Exception
      //   224	1	3	localException3	Exception
      //   41	187	4	localObject6	Object
      // Exception table:
      //   from	to	target	type
      //   37	43	130	java/io/IOException
      //   43	78	130	java/io/IOException
      //   94	102	130	java/io/IOException
      //   107	122	130	java/io/IOException
      //   4	37	174	java/lang/Exception
      //   37	43	212	java/lang/Exception
      //   43	78	224	java/lang/Exception
      //   94	102	224	java/lang/Exception
      //   107	122	224	java/lang/Exception
      //   4	37	233	java/io/IOException
    }
    
    private void a(b.f paramf)
    {
      Object localObject;
      long l;
      if (paramf.h != null)
      {
        localObject = paramf.h;
        l = bc.a((String)localObject, -1L) * 1000L;
        localObject = VerifySms.this.findViewById(2131756159);
        if (l <= 0L) {
          break label143;
        }
        ((View)localObject).setVisibility(0);
        VerifySms.p(VerifySms.this).a(l, true);
        VerifySms.b(VerifySms.this, l + System.currentTimeMillis());
      }
      for (;;)
      {
        l = bc.a(paramf.i, -1L) * 1000L;
        paramf = VerifySms.this.findViewById(2131756162);
        if (l <= 0L) {
          break label186;
        }
        paramf.setVisibility(0);
        VerifySms.D(VerifySms.this).a(l, true);
        VerifySms.c(VerifySms.this, l + System.currentTimeMillis());
        return;
        localObject = paramf.c;
        break;
        label143:
        if (l < 0L)
        {
          ((View)localObject).setVisibility(8);
        }
        else
        {
          ((View)localObject).setVisibility(0);
          VerifySms.p(VerifySms.this).a(true);
          VerifySms.af(VerifySms.this);
        }
      }
      label186:
      if (l < 0L)
      {
        paramf.setVisibility(8);
        return;
      }
      paramf.setVisibility(0);
      VerifySms.D(VerifySms.this).a(true);
      VerifySms.ag(VerifySms.this);
    }
    
    protected final void onPreExecute()
    {
      VerifySms.o = 0;
      VerifySms.p(VerifySms.this).a();
      VerifySms.D(VerifySms.this).a();
      VerifySms.E(VerifySms.this);
      aw localaw = VerifySms.F(VerifySms.this);
      Object localObject = new Intent("com.whatsapp.alarm.REGISTRATION_RETRY").setPackage(com.whatsapp.au.b());
      localObject = PendingIntent.getBroadcast(localaw.a, 0, (Intent)localObject, 536870912);
      if (localObject != null) {
        ((AlarmManager)localaw.a.getSystemService("alarm")).cancel((PendingIntent)localObject);
      }
      if (this.c) {
        d.a(VerifySms.this, 39);
      }
    }
  }
  
  public final class b
    extends AsyncTask<String, Void, h<b.g, b.f>>
  {
    final String a = "voice";
    final String b = "v";
    
    b() {}
    
    /* Error */
    private h<b.g, b.f> a()
    {
      // Byte code:
      //   0: getstatic 39	com/whatsapp/i/b$g:d	Lcom/whatsapp/i/b$g;
      //   3: astore_2
      //   4: aload_0
      //   5: getfield 16	com/whatsapp/registration/VerifySms$b:c	Lcom/whatsapp/registration/VerifySms;
      //   8: aload_0
      //   9: getfield 16	com/whatsapp/registration/VerifySms$b:c	Lcom/whatsapp/registration/VerifySms;
      //   12: aload_0
      //   13: getfield 16	com/whatsapp/registration/VerifySms$b:c	Lcom/whatsapp/registration/VerifySms;
      //   16: invokestatic 43	com/whatsapp/registration/VerifySms:j	(Lcom/whatsapp/registration/VerifySms;)Ljava/lang/String;
      //   19: aload_0
      //   20: getfield 16	com/whatsapp/registration/VerifySms$b:c	Lcom/whatsapp/registration/VerifySms;
      //   23: invokestatic 46	com/whatsapp/registration/VerifySms:k	(Lcom/whatsapp/registration/VerifySms;)Ljava/lang/String;
      //   26: aload_0
      //   27: getfield 23	com/whatsapp/registration/VerifySms$b:a	Ljava/lang/String;
      //   30: getstatic 49	com/whatsapp/registration/bc:a	Ljava/lang/String;
      //   33: invokestatic 52	com/whatsapp/registration/VerifySms:a	(Lcom/whatsapp/registration/VerifySms;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/whatsapp/i/b$f;
      //   36: astore_1
      //   37: aload_1
      //   38: getfield 56	com/whatsapp/i/b$f:a	Lcom/whatsapp/i/b$g;
      //   41: astore 4
      //   43: aload_1
      //   44: astore_3
      //   45: aload 4
      //   47: astore_2
      //   48: aload 4
      //   50: getstatic 58	com/whatsapp/i/b$g:b	Lcom/whatsapp/i/b$g;
      //   53: if_acmpne +35 -> 88
      //   56: new 60	java/lang/StringBuilder
      //   59: dup
      //   60: ldc 62
      //   62: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   65: aload_0
      //   66: getfield 27	com/whatsapp/registration/VerifySms$b:b	Ljava/lang/String;
      //   69: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   72: ldc 71
      //   74: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   77: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   80: invokestatic 80	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
      //   83: aload 4
      //   85: astore_2
      //   86: aload_1
      //   87: astore_3
      //   88: aload_2
      //   89: aload_3
      //   90: invokestatic 85	android/support/v4/f/h:a	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/support/v4/f/h;
      //   93: areturn
      //   94: astore_2
      //   95: aconst_null
      //   96: astore_1
      //   97: aload_2
      //   98: invokevirtual 86	java/io/IOException:toString	()Ljava/lang/String;
      //   101: astore_2
      //   102: new 60	java/lang/StringBuilder
      //   105: dup
      //   106: ldc 62
      //   108: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   111: aload_0
      //   112: getfield 27	com/whatsapp/registration/VerifySms$b:b	Ljava/lang/String;
      //   115: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   118: ldc 88
      //   120: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   123: aload_2
      //   124: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   127: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   130: invokestatic 80	com/whatsapp/util/Log:e	(Ljava/lang/String;)V
      //   133: aload_2
      //   134: ifnull +21 -> 155
      //   137: aload_2
      //   138: ldc 90
      //   140: invokevirtual 96	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   143: ifeq +12 -> 155
      //   146: getstatic 39	com/whatsapp/i/b$g:d	Lcom/whatsapp/i/b$g;
      //   149: astore_2
      //   150: aload_1
      //   151: astore_3
      //   152: goto -64 -> 88
      //   155: getstatic 98	com/whatsapp/i/b$g:e	Lcom/whatsapp/i/b$g;
      //   158: astore_2
      //   159: aload_1
      //   160: astore_3
      //   161: goto -73 -> 88
      //   164: astore_1
      //   165: aload_2
      //   166: astore_3
      //   167: aconst_null
      //   168: astore 4
      //   170: aload_1
      //   171: astore_2
      //   172: aload_3
      //   173: astore_1
      //   174: aload 4
      //   176: astore_3
      //   177: new 60	java/lang/StringBuilder
      //   180: dup
      //   181: ldc 62
      //   183: invokespecial 65	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   186: aload_0
      //   187: getfield 27	com/whatsapp/registration/VerifySms$b:b	Ljava/lang/String;
      //   190: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   193: ldc 100
      //   195: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   198: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   201: aload_2
      //   202: invokestatic 103	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   205: aload_1
      //   206: astore_2
      //   207: goto -119 -> 88
      //   210: astore 4
      //   212: aload_1
      //   213: astore_3
      //   214: aload_2
      //   215: astore_1
      //   216: aload 4
      //   218: astore_2
      //   219: goto -42 -> 177
      //   222: astore_2
      //   223: aload_1
      //   224: astore_3
      //   225: aload 4
      //   227: astore_1
      //   228: goto -51 -> 177
      //   231: astore_2
      //   232: goto -135 -> 97
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	235	0	this	b
      //   36	124	1	localf	b.f
      //   164	7	1	localException1	Exception
      //   173	55	1	localObject1	Object
      //   3	86	2	localObject2	Object
      //   94	4	2	localIOException1	IOException
      //   101	118	2	localObject3	Object
      //   222	1	2	localException2	Exception
      //   231	1	2	localIOException2	IOException
      //   44	181	3	localObject4	Object
      //   41	134	4	localg	b.g
      //   210	16	4	localException3	Exception
      // Exception table:
      //   from	to	target	type
      //   4	37	94	java/io/IOException
      //   4	37	164	java/lang/Exception
      //   37	43	210	java/lang/Exception
      //   48	83	222	java/lang/Exception
      //   37	43	231	java/io/IOException
      //   48	83	231	java/io/IOException
    }
    
    private void a(b.f paramf)
    {
      Object localObject;
      long l;
      if (paramf.i != null)
      {
        localObject = paramf.i;
        l = bc.a((String)localObject, -1L) * 1000L;
        localObject = VerifySms.this.findViewById(2131756162);
        if (l <= 0L) {
          break label143;
        }
        ((View)localObject).setVisibility(0);
        VerifySms.D(VerifySms.this).a(l, true);
        VerifySms.c(VerifySms.this, l + System.currentTimeMillis());
      }
      for (;;)
      {
        l = bc.a(paramf.h, -1L) * 1000L;
        paramf = VerifySms.this.findViewById(2131756159);
        if (l <= 0L) {
          break label186;
        }
        paramf.setVisibility(0);
        VerifySms.p(VerifySms.this).a(l, true);
        VerifySms.b(VerifySms.this, l + System.currentTimeMillis());
        return;
        localObject = paramf.c;
        break;
        label143:
        if (l < 0L)
        {
          ((View)localObject).setVisibility(8);
        }
        else
        {
          ((View)localObject).setVisibility(0);
          VerifySms.D(VerifySms.this).a(true);
          VerifySms.ag(VerifySms.this);
        }
      }
      label186:
      if (l < 0L)
      {
        paramf.setVisibility(8);
        return;
      }
      paramf.setVisibility(0);
      VerifySms.p(VerifySms.this).a(true);
      VerifySms.af(VerifySms.this);
    }
    
    protected final void onPreExecute()
    {
      d.a(VerifySms.this, 25);
    }
  }
  
  final class c
    extends Handler
  {
    c(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      }
      com.whatsapp.util.bu.a(new VerifySms.d(VerifySms.this), new String[] { (String)paramMessage.obj, "retried" });
    }
  }
  
  public final class d
    extends AsyncTask<String, Void, b.k>
  {
    private b.j b;
    
    protected d() {}
    
    private b.k a(String... paramVarArgs)
    {
      String str1 = (String)a.d.a(paramVarArgs[0]);
      Log.i("verifysms/verifysms/code " + str1);
      try
      {
        com.whatsapp.i.b localb = VerifySms.m(VerifySms.this);
        String str2 = VerifySms.j(VerifySms.this);
        String str3 = VerifySms.k(VerifySms.this);
        paramVarArgs = paramVarArgs[1];
        int i;
        if ("tapped".equals(paramVarArgs)) {
          i = com.whatsapp.i.b.a.c;
        }
        for (;;)
        {
          this.b = localb.a(str2, str3, str1, i, VerifySms.l(VerifySms.this).H());
          VerifySms.n(VerifySms.this).h(str1);
          return this.b.a;
          if ("retried".equals(paramVarArgs)) {
            i = com.whatsapp.i.b.a.d;
          } else {
            i = com.whatsapp.i.b.a.b;
          }
        }
        return b.k.b;
      }
      catch (IOException paramVarArgs)
      {
        Log.e("verifysms/verifysms/ioerror " + paramVarArgs.toString());
        return b.k.c;
      }
      catch (Exception paramVarArgs)
      {
        Log.e("verifysms/verifysms/error " + paramVarArgs.toString());
      }
    }
    
    private void a(String paramString)
    {
      int i = VerifySms.g(VerifySms.this);
      Log.i("verifysms/verifysms/schedule-retry/" + i);
      paramString = VerifySms.h(VerifySms.this).obtainMessage(1, paramString);
      VerifySms.h(VerifySms.this).sendMessageDelayed(paramString, i);
    }
    
    protected final void onPreExecute()
    {
      Log.i("verifysms/verifysms");
      d.a(VerifySms.this, 24);
    }
  }
  
  public final class e
    extends AsyncTask<String, Void, b.k>
  {
    b.j a;
    
    protected e() {}
    
    private b.k a(String... paramVarArgs)
    {
      Object localObject = (String)a.d.a(paramVarArgs[0]);
      Log.i("verifyvoice/verifyvoice/code " + (String)localObject);
      paramVarArgs = b.k.b;
      String str = VerifySms.aB(VerifySms.this).H();
      try
      {
        this.a = VerifySms.m(VerifySms.this).a(VerifySms.j(VerifySms.this), VerifySms.k(VerifySms.this), (String)localObject, com.whatsapp.i.b.a.a, str);
        VerifySms.aC(VerifySms.this).h((String)localObject);
        localObject = this.a.a;
        return (b.k)localObject;
      }
      catch (IOException paramVarArgs)
      {
        paramVarArgs = paramVarArgs.toString();
        Log.w("verifyvoice/verifyvoice/ioerror " + paramVarArgs);
        if ((paramVarArgs != null) && (paramVarArgs.contains("refused"))) {
          return b.k.b;
        }
        return b.k.c;
      }
      catch (Exception localException)
      {
        Log.e("verifyvoice/verifyvoice/error " + localException.toString());
      }
      return paramVarArgs;
    }
    
    protected final void onPreExecute()
    {
      Log.i("verifyvoice/verifyvoice");
      d.a(VerifySms.this, 24);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/registration/VerifySms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */