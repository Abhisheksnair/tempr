package com.whatsapp;

import a.a.a.a.d;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.support.v7.app.a;
import android.support.v7.app.b;
import android.support.v7.app.b.a;
import android.support.v7.app.e;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.whatsapp.registration.bb;
import com.whatsapp.util.Log;
import com.whatsapp.util.bm;
import com.whatsapp.wallpaper.g;

public class nn
  extends PreferenceActivity
  implements ng
{
  protected final pv a = pv.a();
  protected final va b = va.a();
  protected final anv c = anv.a();
  protected final ox d = ox.a();
  protected final aic e = aic.a();
  protected final and f = and.a();
  protected final aus g = aus.a();
  protected final g h = g.a();
  protected final vv i = vv.a();
  protected final atu j = atu.a();
  protected final pd k = pd.a();
  protected final rh l = rh.a();
  protected final bb m = bb.a();
  private int n;
  private int o;
  private String p;
  private nh.c q;
  private ProgressDialog r;
  private boolean s = true;
  private e t;
  private boolean u;
  private final aus.a v = new no(this);
  
  private e b()
  {
    if (this.t == null) {
      this.t = e.a(this, null);
    }
    return this.t;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    this.n = paramInt1;
    this.o = paramInt2;
    d.a(this, 501);
  }
  
  public final void a(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    this.n = paramInt1;
    this.o = paramInt2;
    d.a(this, 500);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    b().b(paramView, paramLayoutParams);
  }
  
  public void addPreferencesFromResource(int paramInt)
  {
    super.addPreferencesFromResource(paramInt);
    CharSequence localCharSequence = getPreferenceScreen().getTitle();
    if (!TextUtils.isEmpty(localCharSequence)) {
      b().a().a(localCharSequence);
    }
  }
  
  public final boolean b(String paramString1, String paramString2)
  {
    return false;
  }
  
  public final void b_(int paramInt)
  {
    this.o = paramInt;
    d.a(this, 500);
  }
  
  public final void d()
  {
    this.r = null;
    d.b(this, 501);
  }
  
  public final void d(String paramString)
  {
    this.p = paramString;
    d.a(this, 500);
  }
  
  public final void e(String paramString)
  {
    if (this.r != null) {
      this.r.setMessage(paramString);
    }
  }
  
  public final boolean e()
  {
    return false;
  }
  
  public final boolean f()
  {
    return false;
  }
  
  public final boolean g()
  {
    return false;
  }
  
  public MenuInflater getMenuInflater()
  {
    return b().b();
  }
  
  public void invalidateOptionsMenu()
  {
    b().g();
  }
  
  public void onBackPressed()
  {
    if ((this.s) || (Build.VERSION.SDK_INT < 11))
    {
      super.onBackPressed();
      return;
    }
    Log.e("dialogtoasttreferenceactivity/onbackpressed/activity no active");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.g.e();
    super.onConfigurationChanged(paramConfiguration);
    b().a(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Log.i(getClass().getName() + ".onCreate");
    this.g.e();
    this.u = false;
    al.a(getWindow());
    getTheme().applyStyle(2131427593, true);
    b().i();
    b().a(paramBundle);
    super.onCreate(paramBundle);
    this.q = new nh.c(Looper.getMainLooper(), this.k);
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramBundle = findViewById(16908298);
      if (paramBundle != null)
      {
        int i4 = paramBundle.getPaddingLeft();
        int i3 = paramBundle.getPaddingLeft();
        Object localObject = paramBundle.getParent();
        int i2 = i3;
        int i1 = i4;
        if ((localObject instanceof View))
        {
          localObject = (View)localObject;
          i1 = i4 + ((View)localObject).getPaddingLeft();
          i2 = i3 + ((View)localObject).getPaddingRight();
          ((View)localObject).setPadding(0, 0, 0, 0);
        }
        paramBundle.setPadding(i1, 0, i2, 0);
        paramBundle.setScrollBarStyle(33554432);
      }
    }
    this.g.a(this.v);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (av.j()) {
      bm.b(this);
    }
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 500: 
      b.a locala = new b.a(this);
      if (TextUtils.isEmpty(this.p)) {}
      for (localObject = getString(this.o);; localObject = this.p)
      {
        localObject = locala.b((CharSequence)localObject).a(2131297331, np.a(this));
        if (this.n != 0) {
          ((b.a)localObject).a(this.n);
        }
        return ((b.a)localObject).a();
      }
    case 501: 
      localObject = new ProgressDialog(this);
      if (this.n != 0) {
        ((ProgressDialog)localObject).setTitle(this.n);
      }
      ((ProgressDialog)localObject).setMessage(getString(this.o));
      ((ProgressDialog)localObject).setIndeterminate(true);
      ((ProgressDialog)localObject).setCancelable(false);
      this.r = ((ProgressDialog)localObject);
      return (Dialog)localObject;
    }
    Object localObject = new b.a(this).a(getString(2131297202));
    if (vv.i()) {}
    for (paramInt = 2131297502;; paramInt = 2131297503) {
      return ((b.a)localObject).b(getString(paramInt)).a(2131297331, null).a();
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (av.j()) {
      bm.b(this);
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    Log.i(getClass().getName() + ".onDestroy");
    super.onDestroy();
    b().h();
    this.g.b(this.v);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (av.j()) {}
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    case 24: 
      bm.a(this.d, this.g, this).b();
      return true;
    case 84: 
      bm.a(this);
      return true;
    }
    bm.a();
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    finish();
    return true;
  }
  
  protected void onPause()
  {
    Log.i(getClass().getName() + ".onPause");
    this.a.b(this);
    super.onPause();
    if (this.q.hasMessages(0)) {
      this.q.removeMessages(0);
    }
    this.k.b();
    this.s = false;
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    b().c();
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    b().f();
  }
  
  protected void onPrepareDialog(int paramInt, Dialog paramDialog)
  {
    switch (paramInt)
    {
    default: 
      super.onPrepareDialog(paramInt, paramDialog);
      return;
    }
    b localb = (b)paramDialog;
    if (TextUtils.isEmpty(this.p)) {}
    for (paramDialog = getString(this.o);; paramDialog = this.p)
    {
      localb.a(paramDialog);
      Log.d("dialogtoastpref/preparedialog/message " + paramDialog);
      return;
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    this.p = paramBundle.getString("dialogToastMessage");
    this.o = paramBundle.getInt("dialogToastMessageId", 0);
    this.n = paramBundle.getInt("dialogToastTitleId", 0);
  }
  
  protected void onResume()
  {
    Log.i(getClass().getName() + ".onResume");
    if (this.u)
    {
      this.u = false;
      finish();
      startActivity(getIntent());
    }
    super.onResume();
    this.a.a(this);
    this.q.sendEmptyMessageDelayed(0, 3000L);
    this.s = true;
    if ((!this.m.b()) && (this.m.c() != 2))
    {
      Log.i("settings/resume/wrong-state " + this.m.c());
      startActivity(new Intent(this, Main.class));
      finish();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    Log.i(getClass().getName() + ".onSaveInstanceState");
    super.onSaveInstanceState(paramBundle);
    paramBundle.putCharSequence("dialogToastMessage", this.p);
    paramBundle.putInt("dialogToastMessageId", this.o);
    paramBundle.putInt("dialogToastTitleId", this.n);
  }
  
  protected void onStart()
  {
    Log.i(getClass().getName() + ".onStart");
    super.onStart();
  }
  
  protected void onStop()
  {
    Log.i(getClass().getName() + ".onStop");
    super.onStop();
    b().e();
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    b().a(paramCharSequence);
  }
  
  public void setContentView(int paramInt)
  {
    Toolbar localToolbar = (Toolbar)getLayoutInflater().inflate(2130903384, null, false);
    localToolbar.setTitle(getTitle());
    if (Build.VERSION.SDK_INT >= 21) {
      localToolbar.setElevation(getResources().getDimension(2131361891));
    }
    if (this.a.a) {
      localToolbar.setNavigationIcon(2130840095);
    }
    for (;;)
    {
      LinearLayout localLinearLayout = new LinearLayout(this);
      localLinearLayout.setOrientation(1);
      localLinearLayout.addView(localToolbar, -1, getResources().getDimensionPixelSize(2131361793));
      FrameLayout localFrameLayout = new FrameLayout(this);
      al.a(this.a, getLayoutInflater(), paramInt, localFrameLayout, true);
      localLinearLayout.addView(localFrameLayout, -1, -1);
      setContentView(localLinearLayout);
      b().a(localToolbar);
      localToolbar.setNavigationOnClickListener(nq.a(this));
      return;
      localToolbar.setNavigationIcon(2130837523);
    }
  }
  
  public void setContentView(View paramView)
  {
    b().a(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    b().a(paramView, paramLayoutParams);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/nn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */