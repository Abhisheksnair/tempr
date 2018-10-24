package com.whatsapp.twofactor;

import a.a.a.a.a.a.d;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.r;
import android.support.v4.app.w;
import android.support.v7.app.a;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.whatsapp.nh;
import com.whatsapp.util.Log;

public class TwoFactorAuthActivity
  extends nh
  implements q.a
{
  private static final int[] w = { 2131756000, 2131756001, 2131756002 };
  int[] n;
  a o;
  String p;
  String q;
  String r;
  String s;
  private final Handler t = new Handler(Looper.getMainLooper());
  private final Runnable u = n.a(this);
  private final q v = q.a();
  
  public static Intent a(Context paramContext, int... paramVarArgs)
  {
    paramContext = new Intent(paramContext, TwoFactorAuthActivity.class);
    paramContext.putExtra("workflows", paramVarArgs);
    return paramContext;
  }
  
  final void a(Fragment paramFragment, boolean paramBoolean)
  {
    Log.d("twofactorauthactivity/navigate-to fragment=" + paramFragment.getClass().getName() + " add=" + paramBoolean);
    w localw = j_().a();
    localw.a();
    localw.b(2131755320, paramFragment);
    if (paramBoolean) {
      localw.c();
    }
    localw.d();
  }
  
  final void a(View paramView, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      ((ImageView)paramView.findViewById(w[(i + 1)])).setImageResource(2130840223);
      i += 1;
    }
    paramInt = this.n.length + 1;
    while (paramInt < w.length)
    {
      paramView.findViewById(w[paramInt]).setVisibility(8);
      paramInt += 1;
    }
  }
  
  final boolean b(Fragment paramFragment)
  {
    return (this.n.length == 1) || (paramFragment.getClass() == e.class);
  }
  
  public final void c(int paramInt)
  {
    if (paramInt == 2131298035)
    {
      finish();
      return;
    }
    super.c(paramInt);
  }
  
  public final void c(boolean paramBoolean)
  {
    Log.d("twofactorauthactivity/two-factor-auth-settings-refresh-error");
    this.t.removeCallbacks(this.u);
    this.t.postDelayed(p.a(this, paramBoolean), 700L);
  }
  
  public final void l()
  {
    Log.d("twofactorauthactivity/two-factor-auth-settings-refreshed");
    this.t.removeCallbacks(this.u);
    this.t.postDelayed(o.a(this), 700L);
  }
  
  final Fragment m()
  {
    switch (this.n[0])
    {
    default: 
      return null;
    case 1: 
      return c.d(1);
    }
    return e.d(1);
  }
  
  final void n()
  {
    g(2131298040);
    this.t.postDelayed(this.u, q.c);
    if (this.p == null) {
      this.p = this.v.b();
    }
    this.v.a(this.p, this.r);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Log.i("twofactorauthactivity/create");
    super.onCreate(paramBundle);
    this.o = i();
    if (this.o != null) {
      this.o.a(true);
    }
    setContentView(2130903080);
    this.n = ((int[])a.d.a(getIntent().getIntArrayExtra("workflows")));
    if (this.n.length > 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.d.a(bool);
      j_().a().b(2131755320, m()).d();
      return;
    }
  }
  
  protected void onDestroy()
  {
    Log.i("twofactorauthactivity/destroy");
    super.onDestroy();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if ((paramMenuItem.getItemId() == 16908332) && (j_().d() > 0))
    {
      j_().b();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onPause()
  {
    Log.i("twofactorauthactivity/pause");
    super.onPause();
    this.v.b(this);
  }
  
  public void onResume()
  {
    Log.i("twofactorauthactivity/resume");
    super.onResume();
    this.v.a(this);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/twofactor/TwoFactorAuthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */