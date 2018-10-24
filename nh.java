package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.n;
import android.support.v4.app.r;
import android.support.v7.app.a.a;
import android.support.v7.view.b;
import android.support.v7.widget.Toolbar;
import android.text.TextPaint;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.whatsapp.contact.sync.i;
import com.whatsapp.data.ad;
import com.whatsapp.g.l;
import com.whatsapp.messaging.m.d;
import com.whatsapp.notification.f;
import com.whatsapp.registration.aw;
import com.whatsapp.registration.x;
import com.whatsapp.util.Log;
import com.whatsapp.util.ag;
import com.whatsapp.util.bm;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class nh
  extends android.support.v7.app.c
  implements ng
{
  protected final ani aA = ani.a();
  public final br aB = br.a();
  protected final x aC = x.a();
  protected final com.whatsapp.messaging.m aD = com.whatsapp.messaging.m.a();
  public final and aE = and.a();
  public final aus aF = aus.a();
  protected final com.whatsapp.data.a aG = com.whatsapp.data.a.a();
  public final i aH = i.a();
  public final vv aI = vv.a();
  protected final ag aJ = ag.a();
  public final ane aK = ane.a();
  protected final f aL = f.a();
  public final aat aM = aat.a();
  protected final acm aN = acm.a();
  protected final acw aO = acw.a();
  public final atu aP = atu.a();
  public final atv aQ = atv.a();
  protected final pd aR = pd.a();
  public final h aS = new h(this, (byte)0);
  boolean ak = true;
  public boolean al = true;
  public ViewGroup am;
  public View an;
  protected final ant ao = ant.a();
  public final com.whatsapp.c.a ap = com.whatsapp.c.a.a();
  public final pv aq = pv.a();
  public final va ar = va.a();
  public final ahx as = ahx.a();
  public final anv at = anv.a();
  public final oz au = oz.a();
  public final ahc av = ahc.a();
  protected final od aw = od.a();
  public final ox ax = ox.a();
  public final com.whatsapp.messaging.w ay = com.whatsapp.messaging.w.a();
  public final aic az = aic.a();
  private c n;
  private boolean o = true;
  private View p;
  private boolean q = false;
  private ViewGroup r;
  private boolean s;
  private List<WeakReference<Fragment>> t = new ArrayList();
  
  public static void b(long paramLong)
  {
    paramLong = SystemClock.elapsedRealtime() - paramLong;
    if (paramLong < 300L) {
      SystemClock.sleep(300L - paramLong);
    }
  }
  
  final void R()
  {
    Log.w("dialogtoastactivity/unregisterservices");
    com.whatsapp.messaging.m localm = this.aD;
    localm.d = false;
    Message localMessage = Message.obtain(null, 0, 1, 0);
    localMessage.getData().putBoolean("should_unregister", true);
    localm.b.sendMessage(localMessage);
  }
  
  public final List<Fragment> S()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.t.iterator();
    while (localIterator.hasNext())
    {
      Fragment localFragment = (Fragment)((WeakReference)localIterator.next()).get();
      if ((localFragment != null) && (localFragment.o())) {
        localArrayList.add(localFragment);
      }
    }
    return localArrayList;
  }
  
  public final boolean T()
  {
    return !this.o;
  }
  
  protected void U()
  {
    if ((this.al) && (this.at.d())) {
      startActivity(new Intent(this, TosUpdateActivity.class));
    }
  }
  
  public final void V()
  {
    int j = 0;
    Toolbar localToolbar = (Toolbar)getLayoutInflater().inflate(2130903384, null, false);
    if (Build.VERSION.SDK_INT >= 14) {
      localToolbar.setFitsSystemWindows(true);
    }
    if (this.aq.a) {
      localToolbar.setNavigationIcon(2130840095);
    }
    Object localObject;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = new TypedValue();
      getTheme().resolveAttribute(2130772040, (TypedValue)localObject, true);
      localObject = getTheme().obtainStyledAttributes(((TypedValue)localObject).resourceId, adn.ActionBar);
    }
    for (;;)
    {
      try
      {
        float f = ((TypedArray)localObject).getDimension(26, 0.0F);
        ((TypedArray)localObject).recycle();
        localToolbar.setElevation(f);
        localObject = new TypedValue();
        getTheme().resolveAttribute(2130772026, (TypedValue)localObject, true);
        int i = j;
        if (((TypedValue)localObject).type == 18)
        {
          i = j;
          if (((TypedValue)localObject).data != 0) {
            i = 1;
          }
        }
        if (i != 0)
        {
          this.am = new FrameLayout(this);
          this.r = new FrameLayout(this);
          this.am.addView(this.r, -1, -1);
          this.am.addView(localToolbar, -1, getResources().getDimensionPixelSize(2131361892));
          a(localToolbar);
          if (this.aq.a) {
            ((android.support.v7.app.a)a.d.a(i())).b(getResources().getDrawable(2130840095));
          }
          localToolbar.setNavigationOnClickListener(nj.a(this));
          return;
        }
      }
      finally
      {
        ((TypedArray)localObject).recycle();
      }
      this.am = new LinearLayout(this);
      this.r = this.am;
      ((LinearLayout)this.am).setOrientation(1);
      this.am.addView(localView, -1, getResources().getDimensionPixelSize(2131361892));
    }
  }
  
  public b a(android.support.v7.view.b.a parama)
  {
    parama = super.a(parama);
    if (parama != null) {
      parama.d();
    }
    return parama;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (d.a(this)) {
      return;
    }
    h.a(this.aS, paramInt1, paramInt2);
  }
  
  public final void a(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    if (!d.a(this)) {
      f.a(paramInt1, paramInt2, paramVarArgs).a(j_(), null);
    }
  }
  
  public final void a(Fragment paramFragment)
  {
    this.t.add(new WeakReference(paramFragment));
  }
  
  public final void a(android.support.v4.app.m paramm)
  {
    if (d.a(this)) {}
    while (j_().a(paramm.getClass().getName()) != null) {
      return;
    }
    paramm.a(j_(), paramm.getClass().getName());
  }
  
  public final void a(android.support.v4.app.m paramm, String paramString)
  {
    if (d.a(this)) {
      return;
    }
    android.support.v4.app.w localw = j_().a();
    localw.a(paramm, paramString);
    localw.e();
  }
  
  public final void b(boolean paramBoolean)
  {
    int i = 0;
    View localView;
    if (this.p == null)
    {
      localView = getLayoutInflater().inflate(2130903070, null, false);
      this.p = localView.findViewById(2131755238);
      if (this.p != null)
      {
        android.support.v7.app.a locala = i();
        if (locala != null)
        {
          locala.c();
          locala.a(localView, new a.a((byte)0));
        }
      }
    }
    if (this.p != null)
    {
      localView = this.p;
      if (!paramBoolean) {
        break label92;
      }
    }
    for (;;)
    {
      localView.setVisibility(i);
      return;
      label92:
      i = 8;
    }
  }
  
  public final boolean b(String paramString1, String paramString2)
  {
    if (d.a(this)) {
      return false;
    }
    a(d.a(paramString1, paramString2));
    return true;
  }
  
  public final void b_(int paramInt)
  {
    if (!d.a(this)) {
      f.d(paramInt).a(j_(), null);
    }
  }
  
  public void c(int paramInt) {}
  
  public final void d()
  {
    h.a(this.aS);
  }
  
  @Deprecated
  public final void d(String paramString)
  {
    if (!d.a(this)) {
      f.a(paramString).a(j_(), null);
    }
  }
  
  public final void e(String paramString)
  {
    if (d.a(this)) {
      return;
    }
    h.a(this.aS, paramString);
  }
  
  public final boolean e()
  {
    if (d.a(this)) {
      return false;
    }
    a(new e());
    return true;
  }
  
  public final void f(String paramString)
  {
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(getResources().getDimension(2131362108));
    setTitle(com.whatsapp.emoji.c.a(paramString, getBaseContext(), localTextPaint));
  }
  
  public final boolean f()
  {
    if (d.a(this)) {
      return false;
    }
    this.aL.c = true;
    R();
    a(new b());
    return true;
  }
  
  public final void g(int paramInt)
  {
    if (d.a(this)) {
      return;
    }
    a(0, paramInt);
  }
  
  public final void g(String paramString)
  {
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(getResources().getDimension(2131362103));
    ((android.support.v7.app.a)a.d.a(i())).b(com.whatsapp.emoji.c.a(paramString, getBaseContext(), localTextPaint));
  }
  
  public final boolean g()
  {
    if (d.a(this)) {
      return false;
    }
    this.aL.c = true;
    R();
    a(new j());
    return true;
  }
  
  public final void h(String paramString)
  {
    if (d.a(this)) {}
    android.support.v4.app.w localw;
    do
    {
      return;
      r localr = j_();
      localw = localr.a();
      paramString = localr.a(paramString);
    } while (paramString == null);
    localw.a(paramString);
    localw.e();
  }
  
  public void onBackPressed()
  {
    if (this.o)
    {
      super.onBackPressed();
      return;
    }
    Log.e("dialogtoastfragmentactivity/onbackpressed/activity no active");
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.aF.e();
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i(getClass().getName() + ".onCreate");
    if (av.j()) {
      bm.c(this);
    }
    al.a(getWindow());
    this.aF.e();
    super.onCreate(paramBundle);
    boolean bool;
    if (this.aq.a)
    {
      if (!al.a)
      {
        paramBundle = new TypedValue();
        getTheme().resolveAttribute(2130772024, paramBundle, true);
        if (paramBundle.type == 18)
        {
          if (paramBundle.data != 0) {
            break label183;
          }
          bool = true;
          this.s = bool;
        }
        getTheme().applyStyle(2131427593, true);
      }
      getTheme().applyStyle(2131427603, true);
      if (al.a) {
        break label188;
      }
      if (!this.s) {
        V();
      }
    }
    for (;;)
    {
      this.n = new c(Looper.getMainLooper(), this.aR);
      h.b(this.aS);
      return;
      label183:
      bool = false;
      break;
      label188:
      if ((Build.VERSION.SDK_INT < 21) && (i() != null)) {
        i().b(getResources().getDrawable(2130840095));
      }
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (av.j()) {
      bm.b(this);
    }
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 122: 
      ProgressDialog localProgressDialog = new ProgressDialog(this);
      localProgressDialog.setMessage(getString(2131297530));
      localProgressDialog.setIndeterminate(true);
      localProgressDialog.setCancelable(false);
      return localProgressDialog;
    }
    return new android.support.v7.app.b.a(this).b(2131297786).a(2131297333, ni.a(this)).a();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (av.j()) {
      bm.b(this);
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onDestroy()
  {
    Log.i(getClass().getName() + ".onDestroy");
    h.c(this.aS);
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 82) && (this.q)) {
      return true;
    }
    if (av.j()) {}
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    case 24: 
      bm.a(this.ax, this.aF, this).b();
      return true;
    case 84: 
      bm.a(this);
      return true;
    }
    bm.a();
    return true;
  }
  
  public boolean onKeyLongPress(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      this.q = true;
    }
    return super.onKeyLongPress(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      this.q = false;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    finish();
    return true;
  }
  
  public void onPause()
  {
    Log.i(getClass().getName() + ".onPause");
    this.aq.b(this);
    super.onPause();
    if (this.n.hasMessages(0)) {
      this.n.removeMessages(0);
    }
    this.aR.b();
    this.o = false;
  }
  
  public void onResume()
  {
    Log.i(getClass().getName() + ".onResume");
    super.onResume();
    this.aq.a(this);
    if (this.ak) {
      this.n.sendEmptyMessageDelayed(0, 3000L);
    }
    this.o = true;
    if (((getClass() != VoipActivity.class) || (getClass() != VoipActivityV2.class)) && (Voip.e())) {
      startService(new Intent("show_voip_activity", null, this, VoiceService.class));
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    Log.i(getClass().getName() + ".onSaveInstanceState");
    super.onSaveInstanceState(paramBundle);
  }
  
  public void onStart()
  {
    Log.i(getClass().getName() + ".onStart");
    super.onStart();
    this.at.b();
    U();
  }
  
  public void onStop()
  {
    Log.i(getClass().getName() + ".onStop");
    super.onStop();
  }
  
  public void setContentView(int paramInt)
  {
    setContentView(al.a(this.aq, getLayoutInflater(), paramInt, null, false));
  }
  
  public void setContentView(View paramView)
  {
    if (this.am != null)
    {
      this.r.addView(paramView, -1, -1);
      this.an = this.am;
      super.setContentView(this.am);
      return;
    }
    this.an = paramView;
    super.setContentView(paramView);
  }
  
  public static final class a
    extends ProgressDialog
  {
    CharSequence a;
    
    public a(Context paramContext)
    {
      super();
    }
    
    public final void setMessage(CharSequence paramCharSequence)
    {
      super.setMessage(paramCharSequence);
      this.a = paramCharSequence;
    }
  }
  
  public static final class b
    extends android.support.v4.app.m
  {
    boolean aa = true;
    private final ahc ab = ahc.a();
    
    public final Dialog c(Bundle paramBundle)
    {
      Log.w("home/dialog clock-wrong");
      paramBundle = l();
      pr localpr = new pr(paramBundle, paramBundle);
      localpr.setOnCancelListener(new po(paramBundle));
      return localpr;
    }
    
    public final void onConfigurationChanged(Configuration paramConfiguration)
    {
      super.onConfigurationChanged(paramConfiguration);
      this.aa = false;
      a();
      new b().a(l().j_(), getClass().getName());
    }
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      super.onDismiss(paramDialogInterface);
      if ((this.aa) && (l() != null)) {
        l().finish();
      }
    }
    
    public final void y()
    {
      super.y();
      if (!this.ab.b()) {
        a();
      }
    }
  }
  
  static final class c
    extends Handler
  {
    private final pd a;
    
    public c(Looper paramLooper, pd parampd)
    {
      super();
      this.a = parampd;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if (!((l)b.a.a.c.a().a(l.class)).a) {
        this.a.a(true);
      }
    }
  }
  
  public static final class d
    extends android.support.v4.app.m
  {
    private final aq aa = aq.a();
    
    public final Dialog c(Bundle paramBundle)
    {
      Log.w("home/dialog contact-blocked");
      paramBundle = l();
      aq localaq = this.aa;
      String str1 = i().getString("message");
      String str2 = i().getString("jid");
      return new android.support.v7.app.b.a(paramBundle).b(str1).a(2131298057, pq.a(localaq, paramBundle, str2)).b(2131296398, null).a();
    }
  }
  
  public static final class e
    extends android.support.v4.app.m
  {
    final ad aa = ad.a();
    final aw ab = aw.a();
    
    public final Dialog c(Bundle paramBundle)
    {
      return new android.support.v7.app.b.a(l()).b(2131297129).a(false).a(2131297339, nk.a(this)).a();
    }
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      super.onDismiss(paramDialogInterface);
      paramDialogInterface = l();
      if (paramDialogInterface != null) {
        paramDialogInterface.finish();
      }
    }
  }
  
  public static final class f
    extends android.support.v4.app.m
  {
    public final void a(r paramr, String paramString)
    {
      paramr = paramr.a();
      paramr.a(this, paramString);
      paramr.e();
    }
    
    public final Dialog c(Bundle paramBundle)
    {
      int j = i().getInt("message_id");
      if (j == 0) {
        paramBundle = i().getString("message");
      }
      for (;;)
      {
        int i = i().getInt("title_id");
        paramBundle = new android.support.v7.app.b.a(l()).b(com.whatsapp.emoji.c.a(paramBundle, k(), null)).a(true).a(2131297331, nl.a(this));
        if (i != 0) {
          paramBundle.a(i);
        }
        return paramBundle.a();
        paramBundle = i().getStringArrayList("params_values");
        if (paramBundle == null)
        {
          paramBundle = a(j);
        }
        else
        {
          ArrayList localArrayList = i().getIntegerArrayList("params_types");
          if ((localArrayList == null) || (localArrayList.size() != paramBundle.size())) {
            throw new IllegalArgumentException();
          }
          Object[] arrayOfObject = new Object[paramBundle.size()];
          i = 0;
          if (i < paramBundle.size())
          {
            if (((Integer)localArrayList.get(i)).intValue() == 1) {
              arrayOfObject[i] = Long.valueOf(Long.parseLong((String)paramBundle.get(i)));
            }
            for (;;)
            {
              i += 1;
              break;
              arrayOfObject[i] = paramBundle.get(i);
            }
          }
          paramBundle = a(j, arrayOfObject);
        }
      }
    }
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      super.onDismiss(paramDialogInterface);
      if ((l() instanceof nh)) {
        ((nh)l()).c(i().getInt("message_id"));
      }
    }
  }
  
  public static class g
    extends android.support.v4.app.m
  {
    boolean aa = false;
    
    public g()
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("title_id", 2131297488);
      localBundle.putInt("message_id", 2131297592);
      f(localBundle);
    }
    
    public final void a(r paramr, String paramString)
    {
      paramr = paramr.a();
      paramr.a(this, paramString);
      paramr.e();
    }
    
    public final Dialog c(Bundle paramBundle)
    {
      boolean bool;
      int j;
      String str;
      if (paramBundle != null)
      {
        if (!nh.h.a())
        {
          bool = true;
          this.aa = bool;
        }
      }
      else
      {
        int i = i().getInt("title_id");
        j = i().getInt("message_id");
        str = null;
        if (paramBundle != null) {
          str = paramBundle.getString("previous_message_text");
        }
        paramBundle = new nh.a(l());
        if (i != 0) {
          paramBundle.setTitle(a(i));
        }
        if (str == null) {
          break label108;
        }
      }
      for (;;)
      {
        paramBundle.setMessage(str);
        paramBundle.setIndeterminate(true);
        a(false);
        return paramBundle;
        bool = false;
        break;
        label108:
        str = a(j);
      }
    }
    
    public final void e()
    {
      super.e();
      if (this.aa)
      {
        a();
        this.aa = false;
      }
    }
    
    public final void e(Bundle paramBundle)
    {
      super.e(paramBundle);
      Object localObject = (nh.a)c();
      if (localObject != null)
      {
        localObject = ((nh.a)localObject).a;
        if (localObject != null) {
          paramBundle.putString("previous_message_text", ((CharSequence)localObject).toString());
        }
      }
    }
  }
  
  public static final class h
  {
    private static final String a = nh.g.class.getName();
    private static boolean b;
    private android.support.v4.app.m c;
    private final nh d;
    
    private h(nh paramnh)
    {
      this.d = paramnh;
    }
    
    private void b()
    {
      if (this.c != null) {
        this.c.b();
      }
      this.c = null;
    }
  }
  
  public static final class i
    extends android.support.v4.app.m
  {
    private final ahc aa = ahc.a();
    
    public final Dialog c(Bundle paramBundle)
    {
      Log.i("home/dialog software-about-to-expire");
      return amb.a(l(), this.aa);
    }
  }
  
  public static final class j
    extends android.support.v4.app.m
  {
    public final Dialog c(Bundle paramBundle)
    {
      Log.w("home/dialog software-expired");
      return d.b(l());
    }
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      super.onDismiss(paramDialogInterface);
      paramDialogInterface = l();
      if (paramDialogInterface != null) {
        paramDialogInterface.finish();
      }
    }
  }
  
  public static final class k
    extends android.support.v4.app.m
  {
    public final Dialog c(Bundle paramBundle)
    {
      return new android.support.v7.app.b.a(l()).a(2131298233).b(2131296659).a(false).a(2131297331, null).a();
    }
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      super.onDismiss(paramDialogInterface);
      paramDialogInterface = l();
      if (paramDialogInterface != null) {
        paramDialogInterface.finish();
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/nh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */