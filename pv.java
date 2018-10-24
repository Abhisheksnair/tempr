package com.whatsapp;

import a.a.a.a.a.a.d;
import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.whatsapp.j.a.a;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;
import java.util.List;

public class pv
{
  @SuppressLint({"StaticFieldLeak"})
  private static volatile pv g;
  public boolean a;
  final Context b;
  public final vv c;
  public final atu d;
  public ng e;
  public a f;
  private final Handler h = new Handler(Looper.getMainLooper());
  private final aus i;
  
  private pv(Context paramContext, aus paramaus, vv paramvv, atu paramatu)
  {
    this.b = paramContext;
    this.i = paramaus;
    this.c = paramvv;
    this.d = paramatu;
  }
  
  public static pv a()
  {
    if (g == null) {}
    try
    {
      if (g == null) {
        g = new pv(u.a(), aus.a(), vv.a(), atu.a());
      }
      return g;
    }
    finally {}
  }
  
  public static void a(Context paramContext)
  {
    a(paramContext, u.a.a(2131230815, aic.S, new Object[] { Integer.valueOf(aic.S) }), 1);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2)
  {
    paramContext = Toast.makeText(paramContext.getApplicationContext(), paramContext.getString(paramInt1), paramInt2);
    paramContext.setGravity(17, 0, 0);
    paramContext.show();
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramContext.startActivity(paramIntent);
      return;
    }
    catch (ActivityNotFoundException paramIntent)
    {
      Log.e("app/start-activity " + paramIntent);
      a(paramContext, 2131296289, 0);
    }
  }
  
  public static void a(Context paramContext, Uri paramUri)
  {
    if (paramUri == null)
    {
      Log.e("app/start-activity/uri-is-null");
      return;
    }
    if (!TextUtils.isEmpty(AcceptInviteLinkActivity.a(paramUri)))
    {
      Intent localIntent = new Intent(paramContext, AcceptInviteLinkActivity.class);
      localIntent.putExtra("code", AcceptInviteLinkActivity.a(paramUri));
      paramUri = localIntent;
    }
    for (;;)
    {
      a(paramContext, paramUri);
      return;
      paramUri = new Intent("android.intent.action.VIEW", paramUri);
      paramUri.putExtra("com.android.browser.application_id", paramContext.getPackageName());
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Log.e(paramString);
    paramContext = Toast.makeText(paramContext.getApplicationContext(), paramContext.getString(2131296757), 1);
    paramContext.setGravity(17, 0, 0);
    paramContext.show();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = Toast.makeText(paramContext.getApplicationContext(), paramString, paramInt);
    paramContext.setGravity(17, 0, 0);
    paramContext.show();
  }
  
  public static void a(Context paramContext, List<String> paramList)
  {
    if (paramList.size() == 1)
    {
      if (j.c((String)paramList.get(0)))
      {
        a(paramContext, 2131297678, 1);
        return;
      }
      a(paramContext, 2131297674, 1);
      return;
    }
    if (paramList.contains("status@broadcast"))
    {
      a(paramContext, 2131297676, 1);
      return;
    }
    a(paramContext, 2131297675, 1);
  }
  
  public final void a(ng paramng)
  {
    Log.i("app/dt/set " + paramng);
    this.e = paramng;
    if ((this.f != null) && (this.e != null))
    {
      Log.i("app/dt/set show_progress_data=" + this.f + " dialog_toast=" + this.e);
      this.e.a(this.f.a, this.f.b);
      if (this.f.c != null)
      {
        Log.i("app/dt/set/update");
        this.e.e(this.f.c);
      }
      this.f = null;
    }
    Log.i("app/dt/set done");
  }
  
  public final void a(ng paramng, String paramString)
  {
    if (paramng != null)
    {
      paramng.d(paramString);
      return;
    }
    b(this.b, paramString, 0);
  }
  
  public final void a(nh paramnh)
  {
    String str = Environment.getExternalStorageState();
    if ((!"mounted".equals(str)) && (!"mounted_ro".equals(str))) {
      if (!vv.i()) {
        break label72;
      }
    }
    label72:
    for (int j = 2131297241;; j = 2131297242)
    {
      paramnh.b_(j);
      if ((Build.VERSION.SDK_INT < 23) || (this.d.a("android.permission.READ_EXTERNAL_STORAGE") != -1)) {
        break;
      }
      RequestPermissionActivity.b(paramnh, 2131297450, 2131297419);
      return;
    }
    paramnh.b_(vv.h());
  }
  
  public final void a(Runnable paramRunnable)
  {
    this.h.post(paramRunnable);
  }
  
  public final void a(Runnable paramRunnable, long paramLong)
  {
    this.h.postDelayed(paramRunnable, paramLong);
  }
  
  public final void a(String paramString)
  {
    if (av.d())
    {
      Log.i("app info toast; message=" + paramString);
      this.h.post(pw.a(this, paramString));
    }
  }
  
  public final void b()
  {
    a(this.b, 2131298060, 0);
  }
  
  public final void b(Context paramContext, int paramInt1, int paramInt2)
  {
    if (this.e != null)
    {
      this.e.b_(paramInt1);
      return;
    }
    a(paramContext, paramInt1, paramInt2);
  }
  
  public final void b(Context paramContext, String paramString, int paramInt)
  {
    if (this.e != null)
    {
      this.e.d(paramString);
      return;
    }
    a(paramContext, paramString, paramInt);
  }
  
  public final void b(ng paramng)
  {
    Log.i("app/dt/clear dt=" + paramng + " dialog_toast=" + this.e);
    if (this.e == paramng)
    {
      if ((this.f != null) && (this.e != null)) {
        this.e.d();
      }
      this.e = null;
    }
    Log.i("app/dt/clear done");
  }
  
  public final void b(Runnable paramRunnable)
  {
    this.h.removeCallbacks(paramRunnable);
  }
  
  public final void c()
  {
    a(this.b, 2131298123, 0);
  }
  
  public final void c(ng paramng)
  {
    ng localng = paramng;
    if (paramng == null) {
      localng = this.e;
    }
    if (localng != null)
    {
      localng.a(0, 2131297592);
      return;
    }
    a.d.a(false, "dialogToast == null");
    a(this.b, 2131297592, 0);
  }
  
  public final void d(ng paramng)
  {
    ng localng = paramng;
    if (paramng == null) {
      localng = this.e;
    }
    if (localng != null)
    {
      localng.d();
      return;
    }
    a.d.a(false, "dialogToast == null");
    Log.w("app/removeProgressSpinner/ignore dialogToast == null");
  }
  
  public final boolean d()
  {
    return !this.a;
  }
  
  @SuppressLint({"NewApi"})
  final void e()
  {
    boolean bool1 = false;
    boolean bool2 = true;
    if (al.a)
    {
      if (TextUtils.getLayoutDirectionFromLocale(this.b.getResources().getConfiguration().locale) == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        this.a = bool1;
        return;
      }
    }
    String str = this.i.d();
    if (("ar".equals(str)) || ("fa".equals(str)) || ("iw".equals(str)) || ("he".equals(str))) {
      bool1 = true;
    }
    this.a = bool1;
  }
  
  final void f()
  {
    if ((this.e == null) || (!this.e.e()))
    {
      Log.i("app/loginfailed/popup");
      Intent localIntent = new Intent(this.b, OverlayAlert.class);
      localIntent.putExtra("stringid", 2131297129);
      localIntent.setFlags(268697600);
      this.b.startActivity(localIntent);
    }
  }
  
  public final void g()
  {
    Log.i("app/progress-spinner/remove dt=" + this.e);
    this.f = null;
    if (this.e != null) {
      this.e.d();
    }
    Log.i("app/progress-spinner/remove done");
  }
  
  public static final class a
  {
    final int a = 2131297195;
    final int b = 2131297193;
    public String c;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/pv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */