package com.whatsapp;

import a.a.a.a.a.a.d;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.n;
import android.support.v4.content.b;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.whatsapp.camera.CameraActivity;
import com.whatsapp.data.ac;
import com.whatsapp.data.ad;
import com.whatsapp.data.ad.n;
import com.whatsapp.data.co;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.fieldstats.events.bp;
import com.whatsapp.j.a.a;
import com.whatsapp.k.c;
import com.whatsapp.k.d.e;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.statusplayback.StatusPlaybackActivity;
import com.whatsapp.statusplayback.z;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.az;
import com.whatsapp.util.be;
import com.whatsapp.util.bu;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class amu
  extends android.support.v4.app.ag
  implements sg
{
  private final ac aA = ac.a();
  private final com.whatsapp.data.ab aB = new com.whatsapp.data.ab()
  {
    public final void a(j paramAnonymousj, int paramAnonymousInt)
    {
      if ((paramAnonymousInt != 8) && (paramAnonymousj.a()) && (paramAnonymousj.e.b) && (amu.e(amu.this).a != null)) {
        amu.f(amu.this);
      }
    }
    
    public final void a(String paramAnonymousString)
    {
      if (j.c(paramAnonymousString)) {
        amu.c(amu.this);
      }
    }
    
    public final void a(Collection<j> paramAnonymousCollection, Map<String, Integer> paramAnonymousMap)
    {
      paramAnonymousCollection = paramAnonymousCollection.iterator();
      while (paramAnonymousCollection.hasNext()) {
        if (((j)paramAnonymousCollection.next()).a()) {
          amu.c(amu.this);
        }
      }
    }
    
    public final void c(j paramAnonymousj)
    {
      if (paramAnonymousj.a()) {
        amu.c(amu.this);
      }
    }
    
    public final void c(j paramAnonymousj, int paramAnonymousInt)
    {
      if (paramAnonymousj.a())
      {
        amu.c(amu.this);
        if ((paramAnonymousj.e.b) && (amu.d(amu.this) != null))
        {
          amu.this.k().getSharedPreferences("com.whatsapp_preferences", 0).edit().putBoolean("show_statuses_education", false).apply();
          amu.d(amu.this).setVisibility(8);
        }
      }
    }
  };
  private final Runnable aC = new Runnable()
  {
    public final void run()
    {
      amu.b(amu.this).notifyDataSetChanged();
      amu.g(amu.this);
    }
  };
  private final Runnable aD = amv.a(this);
  private final vv.a aE = new vv.a()
  {
    public final void a()
    {
      amu localamu = amu.this;
      amu.j(amu.this);
      int i;
      if (vv.i())
      {
        i = 2131297515;
        amu.j(amu.this);
        if (!vv.i()) {
          break label56;
        }
      }
      label56:
      for (int j = 2131297513;; j = 2131297514)
      {
        amu.a(localamu, i, j, new Object[0]);
        return;
        i = 2131297516;
        break;
      }
    }
    
    public final void b()
    {
      amu localamu = amu.this;
      amu.j(amu.this);
      int i;
      if (vv.i())
      {
        i = 2131297515;
        amu.j(amu.this);
        if (!vv.i()) {
          break label56;
        }
      }
      label56:
      for (int j = 2131297513;; j = 2131297514)
      {
        amu.a(localamu, i, j, new Object[0]);
        return;
        i = 2131297516;
        break;
      }
    }
    
    public final void c()
    {
      amu.a(amu.this, 2131296307, 2131297418, new Object[0]);
    }
    
    public final void d()
    {
      amu.a(amu.this, 2131296307, 2131297418, new Object[0]);
    }
  };
  final cc aa = cc.a();
  private g ab;
  private f ac = new f((byte)0);
  private CharSequence ad;
  private ArrayList<String> ae;
  private ArrayList<a> af = new ArrayList();
  private c ag;
  private b ah;
  private z ai;
  private final List<Integer> aj = new ArrayList();
  private final List<Integer> ak = new ArrayList();
  private com.whatsapp.k.d al;
  private boolean am;
  private final ant an = ant.a();
  private final pv ao = pv.a();
  private final ani ap = ani.a();
  private final ad aq = ad.a();
  private final e ar = e.a();
  private final aus as = aus.a();
  private final vv at = vv.a();
  private final com.whatsapp.util.ag au = com.whatsapp.util.ag.a();
  private final co av = co.a();
  private final atu aw = atu.a();
  private final and ax = and.a();
  private final dh ay = dh.a();
  private final dh.a az = new dh.a()
  {
    public final void a()
    {
      amu.b(amu.this).getFilter().filter(amu.a(amu.this));
    }
    
    protected final void a(String paramAnonymousString)
    {
      amu.b(amu.this).notifyDataSetChanged();
    }
    
    public final void b()
    {
      amu.c(amu.this);
    }
    
    public final void b(String paramAnonymousString)
    {
      amu.b(amu.this).notifyDataSetChanged();
    }
  };
  View i;
  
  private void S()
  {
    if (this.ag != null) {
      this.ag.cancel(true);
    }
    this.ag = new c((byte)0);
    bu.a(this.ag, new Void[0]);
  }
  
  private void T()
  {
    if (!RequestPermissionActivity.a(this, this.aw)) {}
    while (!this.at.a(this.aE)) {
      return;
    }
    if (vv.f() < aic.s << 10 << 10)
    {
      ((ng)l()).b_(2131296742);
      return;
    }
    if (this.i != null)
    {
      k().getSharedPreferences("com.whatsapp_preferences", 0).edit().putBoolean("show_statuses_education", false).apply();
      this.i.setVisibility(8);
    }
    Intent localIntent = new Intent(k(), CameraActivity.class);
    localIntent.putExtra("jid", "status@broadcast");
    localIntent.putExtra("origin", 4);
    a(localIntent);
  }
  
  private void U()
  {
    this.ao.b(this.aC);
    f localf;
    Iterator localIterator;
    long l1;
    ad.n localn;
    if ((!this.ac.a()) && (l() != null))
    {
      localf = this.ac;
      localIterator = localf.b.iterator();
      l1 = 0L;
      if (localIterator.hasNext())
      {
        localn = (ad.n)localIterator.next();
        if (localn.h <= l1) {
          break label253;
        }
        l1 = localn.h;
      }
    }
    label253:
    for (;;)
    {
      break;
      localIterator = localf.c.iterator();
      while (localIterator.hasNext())
      {
        localn = (ad.n)localIterator.next();
        if (localn.h > l1) {
          l1 = localn.h;
        }
      }
      localIterator = localf.d.iterator();
      while (localIterator.hasNext())
      {
        localn = (ad.n)localIterator.next();
        if (localn.h > l1) {
          l1 = localn.h;
        }
      }
      long l2 = l1;
      if (localf.a != null)
      {
        l2 = l1;
        if (localf.a.h > l1) {
          l2 = localf.a.h;
        }
      }
      this.ao.a(this.aC, com.whatsapp.util.l.e(l2) - System.currentTimeMillis() + 1000L);
      return;
    }
  }
  
  private void V()
  {
    this.ao.b(this.aD);
    long l = this.av.e();
    if (l == 0L)
    {
      localad = this.aq;
      localad.getClass();
      bu.a(amz.a(localad));
    }
    while (l <= 0L)
    {
      ad localad;
      return;
    }
    this.ao.a(this.aD, l + 1000L);
  }
  
  public final void A()
  {
    Log.i("statusesfragment/onDestroy");
    super.A();
    this.al.c();
    this.ay.unregisterObserver(this.az);
    this.aA.unregisterObserver(this.aB);
    this.ao.b(this.aC);
    this.ao.b(this.aD);
    if (this.ag != null) {
      this.ag.cancel(true);
    }
    if (this.ah != null) {
      this.ah.cancel(true);
    }
  }
  
  final void R()
  {
    if (this.i == null)
    {
      ListView localListView = b();
      this.i = al.a(this.ao, l().getLayoutInflater(), 2130903373, localListView, false);
      this.i.findViewById(2131755378).setOnClickListener(amx.a(this));
      this.i.findViewById(2131756103).setOnClickListener(amy.a(this));
      FrameLayout localFrameLayout = new FrameLayout(k());
      localFrameLayout.addView(this.i);
      localListView.addHeaderView(localFrameLayout, null, true);
    }
    this.i.setVisibility(0);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    this.al.a(d.e.c);
    paramLayoutInflater = HomeActivity.a(paramLayoutInflater.inflate(2130903379, paramViewGroup, false), this);
    this.al.b(d.e.c);
    return paramLayoutInflater;
  }
  
  public final void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    T();
  }
  
  public final void a(Bundle paramBundle)
  {
    this.al = c.a("StatusFragmentInit");
    this.al.a();
    this.al.a(d.e.b);
    super.a(paramBundle);
    this.al.b(d.e.b);
  }
  
  public final void a(Menu paramMenu) {}
  
  public final void a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.a(paramMenu, paramMenuInflater);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.ad = paramCharSequence;
    this.ab.getFilter().filter(paramCharSequence);
  }
  
  public final void a(boolean paramBoolean)
  {
    amt localamt = amt.a();
    if (paramBoolean)
    {
      localamt.c = new amt.a();
      if (this.ag == null) {
        localamt.a(this.ac.b.size());
      }
      return;
    }
    if (localamt.c != null)
    {
      bp localbp = new bp();
      localbp.a = Long.valueOf(localamt.c.a);
      localbp.b = Double.valueOf(SystemClock.elapsedRealtime() - localamt.c.b);
      localbp.c = Long.valueOf(localamt.c.d);
      localbp.d = Long.valueOf(localamt.c.e);
      com.whatsapp.fieldstats.l.a(localamt.b, localbp);
    }
    localamt.c = null;
  }
  
  public final boolean a(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131755064)
    {
      T();
      return true;
    }
    if (paramMenuItem.getItemId() == 2131755080)
    {
      a(new Intent(k(), StatusPrivacyActivity.class));
      return true;
    }
    if (paramMenuItem.getItemId() == 2131755065)
    {
      paramMenuItem = new Intent(k(), TextStatusComposerActivity.class);
      paramMenuItem.putExtra("origin", 4);
      a(paramMenuItem);
      return true;
    }
    return super.a(paramMenuItem);
  }
  
  public final void d(Bundle paramBundle)
  {
    Log.i("statusesfragment/onActivityCreated");
    this.al.a(d.e.d);
    super.d(paramBundle);
    s();
    paramBundle = b();
    if (Build.VERSION.SDK_INT < 11) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.setFastScrollEnabled(bool);
      if (Build.VERSION.SDK_INT < 11) {
        paramBundle.setSelector(2130840501);
      }
      paramBundle.setScrollbarFadingEnabled(true);
      paramBundle.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        private long b;
        
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousAdapterView = (amu.i)paramAnonymousView.getTag();
          if (paramAnonymousAdapterView != null)
          {
            paramAnonymousLong = SystemClock.elapsedRealtime();
            if (paramAnonymousLong - this.b > 1000L)
            {
              this.b = paramAnonymousLong;
              if ((!TextUtils.isEmpty(paramAnonymousAdapterView.g)) || (paramAnonymousAdapterView.h != 0)) {
                break label62;
              }
              amu.h(amu.this);
            }
          }
          return;
          label62:
          paramAnonymousView = new Intent(amu.this.k(), StatusPlaybackActivity.class);
          if (j.c(paramAnonymousAdapterView.g)) {}
          for (paramAnonymousAdapterView = "";; paramAnonymousAdapterView = paramAnonymousAdapterView.g)
          {
            paramAnonymousView.putExtra("jid", paramAnonymousAdapterView);
            amu.this.a(paramAnonymousView);
            return;
          }
        }
      });
      paramBundle.setOnItemLongClickListener(amw.a(this));
      if ((k().getSharedPreferences("com.whatsapp_preferences", 0).getBoolean("show_statuses_education", true)) && (!this.av.b())) {
        R();
      }
      ((View)a.d.a(x())).findViewById(2131756123).setVisibility(0);
      this.ai = new z(k());
      this.ab = new g((byte)0);
      a(this.ab);
      this.ay.registerObserver(this.az);
      this.aA.registerObserver(this.aB);
      S();
      this.al.b(d.e.d);
      return;
    }
  }
  
  public final void e()
  {
    super.e();
    U();
    V();
  }
  
  public final void k_()
  {
    T();
  }
  
  public final void y()
  {
    Log.i("statusesfragment/onResume");
    super.y();
  }
  
  public final void z()
  {
    Log.i("statusesfragment/onPause");
    super.z();
    this.al.c();
  }
  
  static abstract interface a
  {
    public abstract View a(int paramInt, View paramView, ViewGroup paramViewGroup, Context paramContext);
  }
  
  final class b
    extends AsyncTask<Void, List<j>, List<j>>
  {
    private b() {}
  }
  
  final class c
    extends AsyncTask<Void, amu.f, amu.f>
  {
    private c() {}
  }
  
  final class d
    implements amu.a
  {
    final String a;
    
    d(String paramString)
    {
      this.a = paramString;
    }
    
    public final View a(int paramInt, View paramView, ViewGroup paramViewGroup, Context paramContext)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = al.a(amu.y(amu.this), LayoutInflater.from(paramContext), 2130903183, paramViewGroup, false);
      }
      paramView = (TextView)localView.findViewById(2131755177);
      aoa.b(paramView);
      paramView.setText(this.a);
      return localView;
    }
  }
  
  final class e
    implements amu.a
  {
    final ad.n a;
    
    e(ad.n paramn)
    {
      this.a = paramn;
    }
    
    public final View a(int paramInt, View paramView, ViewGroup paramViewGroup, Context paramContext)
    {
      ad.n localn;
      Object localObject1;
      Object localObject2;
      label100:
      label114:
      int i;
      if (paramView == null)
      {
        paramContext = al.a(amu.y(amu.this), LayoutInflater.from(paramContext), 2130903380, paramViewGroup, false);
        paramViewGroup = new amu.i(amu.this, paramContext);
        paramContext.setTag(paramViewGroup);
        localn = this.a;
        localObject1 = amu.p(paramViewGroup.i);
        paramView = localn.a;
        localObject2 = ((ad)localObject1).x.a(paramView);
        if (localObject2 != null) {
          break label744;
        }
        localObject1 = new StringBuilder("msgstore/getlaststatusmessage/no status for ");
        if (TextUtils.isEmpty(paramView)) {
          break label737;
        }
        Log.w(paramView);
        paramView = null;
        if (!TextUtils.isEmpty(localn.a)) {
          break label799;
        }
        paramViewGroup.c.setText(2131297237);
        paramViewGroup.c.setVerified(false);
        if (paramView == null) {
          break label787;
        }
        paramViewGroup.e.setVisibility(0);
        paramViewGroup.e.setImageResource(2130840207);
        paramViewGroup.e.setContentDescription(paramViewGroup.i.a(2131297238));
        localObject1 = paramViewGroup.e;
        localObject2 = paramViewGroup.i.k();
        if (!amu.r(paramViewGroup.i).isEmpty()) {
          break label779;
        }
        i = 2131623944;
        label213:
        ((ImageView)localObject1).setColorFilter(b.c((Context)localObject2, i));
        paramViewGroup.e.setOnClickListener(anb.a(paramViewGroup));
        label236:
        if (e.b(localn.a)) {
          break label866;
        }
        paramViewGroup.d.setVisibility(0);
        paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        paramViewGroup.c.setTextColor(b.c(paramViewGroup.i.k(), 2131624047));
        label285:
        if (paramView == null) {
          break label1255;
        }
        if (!e.b(localn.a)) {
          break label898;
        }
        paramViewGroup.a.setTag("");
        paramViewGroup.a.setImageBitmap(cs.b(e.b().e()));
        label325:
        if ((!TextUtils.isEmpty(localn.a)) || (amu.s(paramViewGroup.i).size() + amu.r(paramViewGroup.i).size() == 0)) {
          break label1202;
        }
        if ((amu.s(paramViewGroup.i).size() <= 0) || (amu.r(paramViewGroup.i).size() <= 0)) {
          break label1076;
        }
        paramView = paramViewGroup.i.a(2131297670, new Object[] { u.a.a(2131230803, amu.s(paramViewGroup.i).size(), new Object[] { Integer.valueOf(amu.s(paramViewGroup.i).size()) }), u.a.a(2131230746, amu.r(paramViewGroup.i).size(), new Object[] { Integer.valueOf(amu.r(paramViewGroup.i).size()) }) });
        label498:
        paramViewGroup.d.setText(paramView);
        if (!amu.r(paramViewGroup.i).isEmpty()) {
          break label1183;
        }
        i = 2130840390;
        label525:
        paramView = new az(b.a(paramViewGroup.i.k(), i));
        localObject2 = paramViewGroup.d;
        if (!amu.y(paramViewGroup.i).a) {
          break label1191;
        }
        localObject1 = null;
        label567:
        if (!amu.y(paramViewGroup.i).a) {
          break label1197;
        }
        label580:
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject1, null, paramView, null);
        paramViewGroup.a.a.clear();
        if (!amu.l(paramViewGroup.i).f(localn.a)) {
          break label1321;
        }
        paramViewGroup.a.a(0, 0);
        android.support.v4.view.ab.c(paramViewGroup.a, 0.5F);
        android.support.v4.view.ab.c(paramViewGroup.c, 0.5F);
        android.support.v4.view.ab.c(paramViewGroup.d, 0.5F);
      }
      for (;;)
      {
        paramViewGroup.g = localn.a;
        paramViewGroup.h = localn.j;
        if ((paramInt >= amu.b(amu.this).getCount() - 1) || (!(amu.b(amu.this).a(paramInt + 1) instanceof e))) {
          break label1498;
        }
        paramViewGroup.f.setVisibility(0);
        return paramContext;
        paramViewGroup = (amu.i)paramView.getTag();
        paramContext = paramView;
        break;
        label737:
        paramView = "me";
        break label100;
        label744:
        if (((ad.n)localObject2).c == null) {
          ((ad.n)localObject2).c = ((ad)localObject1).t.a(((ad.n)localObject2).b);
        }
        paramView = ((ad.n)localObject2).c;
        break label114;
        label779:
        i = 2131624117;
        break label213;
        label787:
        paramViewGroup.e.setVisibility(8);
        break label236;
        label799:
        localObject1 = amu.t(paramViewGroup.i).d(localn.a);
        paramViewGroup.c.a(((cs)localObject1).b(paramViewGroup.i.k()), amu.u(paramViewGroup.i));
        paramViewGroup.c.setVerified(((cs)localObject1).f());
        paramViewGroup.e.setVisibility(8);
        break label236;
        label866:
        paramViewGroup.c.setTextColor(b.c(paramViewGroup.i.k(), 2131624048));
        paramViewGroup.d.setVisibility(8);
        break label285;
        label898:
        if ((paramView.N instanceof MediaData))
        {
          localObject1 = paramView.b();
          if ((((MediaData)localObject1).file == null) || (!((MediaData)localObject1).file.exists()))
          {
            amu.w(paramViewGroup.i).b(paramView, paramViewGroup.a, amu.v(paramViewGroup.i));
            break label325;
          }
          amu.w(paramViewGroup.i).a(paramView, paramViewGroup.a, amu.v(paramViewGroup.i));
          break label325;
        }
        if (paramView.s == 0)
        {
          paramViewGroup.a.setTag("");
          paramView = new ahd(paramViewGroup.i.k(), amu.x(paramViewGroup.i), paramView.e(), paramView.c());
          paramView.a = (paramViewGroup.a.getBorderSize() / 2.0F);
          paramViewGroup.a.setImageDrawable(paramView);
          break label325;
        }
        paramViewGroup.a.setTag("");
        paramViewGroup.a.setImageResource(z.a(paramView));
        break label325;
        label1076:
        if (amu.s(paramViewGroup.i).size() > 0)
        {
          paramView = u.a.a(2131230803, amu.s(paramViewGroup.i).size(), new Object[] { Integer.valueOf(amu.s(paramViewGroup.i).size()) });
          break label498;
        }
        paramView = u.a.a(2131230746, amu.r(paramViewGroup.i).size(), new Object[] { Integer.valueOf(amu.r(paramViewGroup.i).size()) });
        break label498;
        label1183:
        i = 2130840386;
        break label525;
        label1191:
        localObject1 = paramView;
        break label567;
        label1197:
        paramView = null;
        break label580;
        label1202:
        paramViewGroup.d.setText(com.whatsapp.util.l.b(paramViewGroup.i.l(), amu.z(paramViewGroup.i), amu.A(paramViewGroup.i).a(localn.h)));
        for (;;)
        {
          paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
          break;
          label1255:
          paramViewGroup.a.setTag("");
          if (TextUtils.isEmpty(localn.a))
          {
            paramViewGroup.a.setImageBitmap(cs.b(2130837632));
            paramViewGroup.d.setText(2131296305);
          }
          else
          {
            paramViewGroup.a.setImageDrawable(null);
            paramViewGroup.d.setText("");
          }
        }
        label1321:
        paramViewGroup.a.a(localn.i, localn.j);
        if (TextUtils.isEmpty(localn.a))
        {
          paramView = amu.r(paramViewGroup.i).iterator();
          while (paramView.hasNext())
          {
            localObject1 = (Integer)paramView.next();
            paramViewGroup.a.b(((Integer)localObject1).intValue(), b.c(paramViewGroup.i.k(), 2131624117));
          }
          paramView = amu.s(paramViewGroup.i).iterator();
          while (paramView.hasNext())
          {
            localObject1 = (Integer)paramView.next();
            paramViewGroup.a.b(((Integer)localObject1).intValue(), b.c(paramViewGroup.i.k(), 2131624121));
          }
        }
        android.support.v4.view.ab.c(paramViewGroup.a, 1.0F);
        android.support.v4.view.ab.c(paramViewGroup.c, 1.0F);
        android.support.v4.view.ab.c(paramViewGroup.d, 1.0F);
      }
      label1498:
      paramViewGroup.f.setVisibility(4);
      return paramContext;
    }
  }
  
  static final class f
  {
    ad.n a;
    List<ad.n> b = new ArrayList();
    List<ad.n> c = new ArrayList();
    List<ad.n> d = new ArrayList();
    
    final boolean a()
    {
      return (this.a == null) && (this.b.isEmpty()) && (this.c.isEmpty()) && (this.d.isEmpty());
    }
  }
  
  final class g
    extends BaseAdapter
    implements Filterable
  {
    private Filter b;
    
    private g() {}
    
    public final amu.a a(int paramInt)
    {
      return (amu.a)amu.B(amu.this).get(paramInt);
    }
    
    public final int getCount()
    {
      return amu.B(amu.this).size();
    }
    
    public final Filter getFilter()
    {
      if (this.b == null) {
        this.b = new amu.h(amu.this, (byte)0);
      }
      return this.b;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      if ((a(paramInt) instanceof amu.d)) {
        return 1;
      }
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      return a(paramInt).a(paramInt, paramView, paramViewGroup, amu.this.k());
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
    
    public final boolean hasStableIds()
    {
      return true;
    }
  }
  
  final class h
    extends Filter
  {
    private h() {}
    
    private List<amu.a> a(List<ad.n> paramList, ArrayList<String> paramArrayList)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ad.n localn = (ad.n)paramList.next();
        if (amu.t(amu.this).d(localn.a).a(paramArrayList)) {
          localArrayList.add(new amu.e(amu.this, localn));
        }
      }
      return localArrayList;
    }
    
    protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      ArrayList localArrayList = new ArrayList();
      Object localObject2;
      Object localObject1;
      if (TextUtils.isEmpty(paramCharSequence))
      {
        localObject2 = amu.this;
        if (amu.e(amu.this).a == null)
        {
          localObject1 = new ad.n(amu.A(amu.this), "", -1L, -1L, -1L, -1L, -1L, 0L, 0, 0);
          localArrayList.add(new amu.e((amu)localObject2, (ad.n)localObject1));
        }
      }
      else
      {
        if (!TextUtils.isEmpty(paramCharSequence)) {
          break label311;
        }
      }
      label311:
      for (paramCharSequence = null;; paramCharSequence = be.c(paramCharSequence.toString()))
      {
        localObject1 = a(amu.e(amu.this).b, paramCharSequence);
        localObject2 = a(amu.e(amu.this).c, paramCharSequence);
        paramCharSequence = a(amu.e(amu.this).d, paramCharSequence);
        if (!((List)localObject1).isEmpty())
        {
          localArrayList.add(new amu.d(amu.this, amu.this.a(2131297507)));
          localArrayList.addAll((Collection)localObject1);
        }
        if (!((List)localObject2).isEmpty())
        {
          localArrayList.add(new amu.d(amu.this, amu.this.a(2131298133)));
          localArrayList.addAll((Collection)localObject2);
        }
        if (!paramCharSequence.isEmpty())
        {
          localArrayList.add(new amu.d(amu.this, amu.this.a(2131297234)));
          localArrayList.addAll(paramCharSequence);
        }
        localFilterResults.values = localArrayList;
        localFilterResults.count = localArrayList.size();
        return localFilterResults;
        localObject1 = amu.e(amu.this).a;
        break;
      }
    }
    
    protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      if (paramFilterResults.values != null) {
        amu.a(amu.this, (ArrayList)paramFilterResults.values);
      }
      amu.a(amu.this, paramCharSequence);
      paramFilterResults = amu.this;
      if (paramCharSequence == null) {}
      for (paramCharSequence = null;; paramCharSequence = paramCharSequence.toString())
      {
        amu.b(paramFilterResults, be.c(paramCharSequence));
        amu.n(amu.this);
        amu.C(amu.this);
        amu.b(amu.this).notifyDataSetChanged();
        return;
      }
    }
  }
  
  final class i
  {
    final ContactStatusThumbnail a;
    final View b;
    final TextEmojiLabel c;
    final TextView d;
    final ImageView e;
    final View f;
    String g;
    int h;
    
    i(View paramView)
    {
      this.a = ((ContactStatusThumbnail)paramView.findViewById(2131755363));
      this.a.setClickable(false);
      this.b = paramView.findViewById(2131755395);
      this.b.setClickable(false);
      this.c = ((TextEmojiLabel)paramView.findViewById(2131755397));
      this.d = ((TextView)paramView.findViewById(2131755399));
      this.e = ((ImageView)paramView.findViewById(2131756124));
      this.f = paramView.findViewById(2131755385);
      this.f.setBackgroundDrawable(new az(b.a(paramView.getContext(), 2130837766)));
      aoa.b(this.c);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/amu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */