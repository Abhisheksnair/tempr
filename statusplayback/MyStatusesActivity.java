package com.whatsapp.statusplayback;

import a.a.a.a.a.a.d;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.view.b.a;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.whatsapp.ContactStatusThumbnail;
import com.whatsapp.Conversation;
import com.whatsapp.FMessageKey;
import com.whatsapp.MediaData;
import com.whatsapp.RequestPermissionActivity;
import com.whatsapp.SelectionCheckView;
import com.whatsapp.aaf;
import com.whatsapp.ahd;
import com.whatsapp.aic;
import com.whatsapp.al;
import com.whatsapp.ant;
import com.whatsapp.aoa;
import com.whatsapp.aoj;
import com.whatsapp.atv;
import com.whatsapp.br;
import com.whatsapp.camera.CameraActivity;
import com.whatsapp.data.ac;
import com.whatsapp.data.ad;
import com.whatsapp.data.ck;
import com.whatsapp.data.co;
import com.whatsapp.lt;
import com.whatsapp.nh;
import com.whatsapp.nm;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.s;
import com.whatsapp.pv;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import com.whatsapp.util.ag;
import com.whatsapp.util.at;
import com.whatsapp.util.az;
import com.whatsapp.util.bh;
import com.whatsapp.util.bu;
import com.whatsapp.vv;
import com.whatsapp.vv.a;
import java.io.File;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyStatusesActivity
  extends nm
{
  private final ad A;
  private final com.whatsapp.data.e B;
  private final com.whatsapp.data.l C;
  private final ag D;
  private final co E;
  private final lt F;
  private final ck G;
  private final b.a H;
  private final ac I;
  private final com.whatsapp.data.ab J;
  private final Runnable K;
  private final Runnable L;
  private final vv.a M;
  private final View.OnClickListener N;
  private final View.OnClickListener O;
  private final View.OnClickListener P;
  c n;
  android.support.v7.view.b o;
  final HashMap<j.b, j> p = new HashMap();
  j q;
  final aoj r;
  private a s;
  private z t;
  private final Set<j.b> u = new HashSet();
  private final Runnable v;
  private final Handler w;
  private final HashMap<j.b, Integer> x;
  private final HashMap<j.b, b> y;
  private final ant z;
  
  public MyStatusesActivity()
  {
    Set localSet = this.u;
    localSet.getClass();
    this.v = a.a(localSet);
    this.w = new Handler(Looper.getMainLooper());
    this.x = new HashMap();
    this.y = new HashMap();
    this.z = ant.a();
    this.r = aoj.a();
    this.A = ad.a();
    this.B = com.whatsapp.data.e.a();
    this.C = com.whatsapp.data.l.a();
    this.D = ag.a();
    this.E = co.a();
    this.F = lt.a();
    this.G = ck.a();
    this.H = new aaf(this, this.z, this.aq, this.r, this.aB, this.A, this.B, this.aQ, this.F)
    {
      public final Map<j.b, j> a()
      {
        return MyStatusesActivity.b(MyStatusesActivity.this);
      }
      
      public final void a(android.support.v7.view.b paramAnonymousb)
      {
        MyStatusesActivity.c(MyStatusesActivity.this).clear();
        MyStatusesActivity.c(MyStatusesActivity.this).addAll(MyStatusesActivity.b(MyStatusesActivity.this).keySet());
        MyStatusesActivity.e(MyStatusesActivity.this).removeCallbacks(MyStatusesActivity.d(MyStatusesActivity.this));
        MyStatusesActivity.e(MyStatusesActivity.this).postDelayed(MyStatusesActivity.d(MyStatusesActivity.this), 200L);
        MyStatusesActivity.b(MyStatusesActivity.this).clear();
        MyStatusesActivity.f(MyStatusesActivity.this);
        MyStatusesActivity.g(MyStatusesActivity.this).notifyDataSetChanged();
      }
      
      public final void b()
      {
        if (MyStatusesActivity.a(MyStatusesActivity.this) != null) {
          MyStatusesActivity.a(MyStatusesActivity.this).c();
        }
      }
      
      public final boolean b(android.support.v7.view.b paramAnonymousb, Menu paramAnonymousMenu)
      {
        super.b(paramAnonymousb, paramAnonymousMenu);
        this.f.setVisible(false);
        this.g.setVisible(false);
        this.h.setVisible(false);
        this.i.setVisible(false);
        this.l.setVisible(false);
        this.m.setVisible(false);
        this.n.setVisible(false);
        this.o.setVisible(false);
        this.j.setVisible(false);
        this.k.setVisible(false);
        if (this.p != null) {
          this.p.setVisible(false);
        }
        this.q.setVisible(false);
        return true;
      }
    };
    this.I = ac.a();
    this.J = new com.whatsapp.data.ab()
    {
      public final void a(j paramAnonymousj, int paramAnonymousInt)
      {
        if ((paramAnonymousj != null) && (paramAnonymousj.a()) && (paramAnonymousj.e.b))
        {
          if (s.a(paramAnonymousj.d, 4) > 0) {
            MyStatusesActivity.a(MyStatusesActivity.this, paramAnonymousj.e, true);
          }
        }
        else {
          return;
        }
        MyStatusesActivity.g(MyStatusesActivity.this).notifyDataSetChanged();
      }
      
      public final void a(Collection<j> paramAnonymousCollection, Map<String, Integer> paramAnonymousMap)
      {
        paramAnonymousCollection = paramAnonymousCollection.iterator();
        do
        {
          if (!paramAnonymousCollection.hasNext()) {
            break;
          }
          paramAnonymousMap = (j)paramAnonymousCollection.next();
        } while ((!paramAnonymousMap.a()) || (!paramAnonymousMap.e.b));
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            MyStatusesActivity.h(MyStatusesActivity.this);
          }
          return;
        }
      }
      
      public final void b(j paramAnonymousj)
      {
        if ((paramAnonymousj != null) && (paramAnonymousj.a()) && (paramAnonymousj.e.b)) {
          MyStatusesActivity.a(MyStatusesActivity.this, paramAnonymousj.e, true);
        }
      }
      
      public final void c(j paramAnonymousj, int paramAnonymousInt)
      {
        if ((paramAnonymousj.a()) && (paramAnonymousj.e.b)) {
          MyStatusesActivity.h(MyStatusesActivity.this);
        }
      }
    };
    this.K = new Runnable()
    {
      public final void run()
      {
        MyStatusesActivity.g(MyStatusesActivity.this).notifyDataSetChanged();
        MyStatusesActivity.i(MyStatusesActivity.this);
      }
    };
    this.L = b.a(this);
    this.M = new vv.a()
    {
      public final void a()
      {
        MyStatusesActivity localMyStatusesActivity = MyStatusesActivity.this;
        int i;
        if (vv.i())
        {
          i = 2131297515;
          if (!vv.i()) {
            break label40;
          }
        }
        label40:
        for (int j = 2131297513;; j = 2131297514)
        {
          localMyStatusesActivity.a(i, j, new Object[0]);
          return;
          i = 2131297516;
          break;
        }
      }
      
      public final void b()
      {
        MyStatusesActivity localMyStatusesActivity = MyStatusesActivity.this;
        int i;
        if (vv.i())
        {
          i = 2131297515;
          if (!vv.i()) {
            break label40;
          }
        }
        label40:
        for (int j = 2131297513;; j = 2131297514)
        {
          localMyStatusesActivity.a(i, j, new Object[0]);
          return;
          i = 2131297516;
          break;
        }
      }
      
      public final void c()
      {
        MyStatusesActivity.this.a(2131296307, 2131297418, new Object[0]);
      }
      
      public final void d()
      {
        MyStatusesActivity.this.a(2131296307, 2131297418, new Object[0]);
      }
    };
    this.N = c.a(this);
    this.O = d.a(this);
    this.P = e.a(this);
  }
  
  private void l()
  {
    if (!RequestPermissionActivity.a(this, this.aP, 33)) {}
    while (!this.aI.a(this.M)) {
      return;
    }
    if (vv.f() < aic.s << 10 << 10)
    {
      b_(2131296742);
      return;
    }
    Intent localIntent = new Intent(this, CameraActivity.class);
    localIntent.putExtra("jid", "status@broadcast");
    localIntent.putExtra("origin", 4);
    startActivity(localIntent);
  }
  
  private void m()
  {
    if (this.s != null) {
      this.s.cancel(true);
    }
    this.s = new a((byte)0);
    bu.a(this.s, new Void[0]);
  }
  
  private void n()
  {
    this.aq.b(this.K);
    if (!this.n.isEmpty())
    {
      long l = c.a(this.n);
      this.aq.a(this.K, com.whatsapp.util.l.e(l) - System.currentTimeMillis() + 1000L);
    }
  }
  
  private void o()
  {
    this.aq.b(this.L);
    long l = this.E.e();
    if (l == 0L)
    {
      localad = this.A;
      localad.getClass();
      bu.a(i.a(localad));
    }
    while (l <= 0L)
    {
      ad localad;
      return;
    }
    this.aq.a(this.L, l + 1000L);
  }
  
  public final void a(android.support.v7.view.b paramb)
  {
    super.a(paramb);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(android.support.v4.content.b.c(this, 2131623951));
    }
  }
  
  public final void a(j paramj, View paramView)
  {
    if (this.p.containsKey(paramj.e))
    {
      this.p.remove(paramj.e);
      paramView.setBackgroundResource(0);
      if (!this.p.isEmpty()) {
        break label126;
      }
      if (this.o != null) {
        this.o.c();
      }
    }
    for (;;)
    {
      this.u.add(paramj.e);
      this.w.removeCallbacks(this.v);
      this.w.postDelayed(this.v, 200L);
      this.n.notifyDataSetChanged();
      return;
      this.p.put(paramj.e, paramj);
      paramView.setBackgroundResource(2131624041);
      break;
      label126:
      if (this.o == null) {
        this.o = a(this.H);
      }
      this.o.b(NumberFormat.getInstance().format(this.p.size()));
      this.o.d();
    }
  }
  
  public final void a(j paramj, boolean paramBoolean)
  {
    if (this.o != null) {
      this.o.c();
    }
    Intent localIntent = new Intent(this, StatusPlaybackActivity.class);
    localIntent.putExtra("jid", paramj.f);
    localIntent.putExtra("message_key", new FMessageKey(paramj.e));
    localIntent.putExtra("show_details", paramBoolean);
    startActivity(localIntent);
  }
  
  public final void b(android.support.v7.view.b paramb)
  {
    super.b(paramb);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(android.support.v4.content.b.c(this, 2131624092));
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    do
    {
      for (;;)
      {
        return;
        if (paramInt2 == -1)
        {
          Object localObject = new ArrayList();
          if (!this.p.isEmpty()) {
            ((ArrayList)localObject).addAll(this.p.values());
          }
          for (;;)
          {
            if (!((Collection)localObject).isEmpty())
            {
              paramIntent = paramIntent.getStringArrayListExtra("jids");
              localObject = lt.a((Collection)localObject).iterator();
              for (;;)
              {
                if (((Iterator)localObject).hasNext())
                {
                  j localj = (j)((Iterator)localObject).next();
                  this.r.a(this.as, localj, paramIntent);
                  continue;
                  if (this.q == null) {
                    break;
                  }
                  ((ArrayList)localObject).add(this.q);
                  break;
                }
              }
              if ((paramIntent.size() == 1) && (!j.c((String)paramIntent.get(0)))) {
                startActivity(Conversation.a(this.B.d((String)paramIntent.get(0))));
              }
            }
          }
          while (this.o != null)
          {
            this.o.c();
            return;
            pv.a(getBaseContext(), paramIntent);
            continue;
            Log.w("mystatuses/forward/failed");
            pv.a(this, 2131297172, 0);
          }
        }
      }
    } while (paramInt2 != -1);
    l();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("mystatuses/create");
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().addFlags(Integer.MIN_VALUE);
    }
    super.onCreate(paramBundle);
    V();
    ((android.support.v7.app.a)a.d.a(i())).a(true);
    setContentView(2130903309);
    paramBundle = findViewById(2131755835);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramBundle.setSystemUiVisibility(1280);
      android.support.v4.view.ab.w(this.am);
    }
    this.t = new z(this);
    this.n = new c((byte)0);
    paramBundle = W();
    paramBundle.setDivider(new az(android.support.v4.content.b.a(this, 2130837766)));
    if (Build.VERSION.SDK_INT < 11) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.setFastScrollEnabled(bool);
      if (Build.VERSION.SDK_INT < 11) {
        paramBundle.setSelector(2130840501);
      }
      View localView = getLayoutInflater().inflate(2130903184, paramBundle, false);
      paramBundle.addFooterView(localView, null, false);
      ((TextView)localView.findViewById(2131755670)).setText(2131297911);
      paramBundle.setAdapter(this.n);
      paramBundle.setOnItemClickListener(f.a(this));
      paramBundle.setOnItemLongClickListener(g.a(this));
      paramBundle = (TextView)findViewById(16908292);
      paramBundle.setText(bh.a(getResources().getString(2131298204), android.support.v4.content.b.a(this, 2130840221), paramBundle.getPaint()));
      findViewById(2131755838).setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          MyStatusesActivity.j(MyStatusesActivity.this);
        }
      });
      ((View)a.d.a(findViewById(2131755224))).setVisibility(0);
      m();
      this.I.registerObserver(this.J);
      return;
    }
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    if (this.p.isEmpty())
    {
      Log.e("mediagallery/dialog/delete no messages");
      return super.onCreateDialog(paramInt);
    }
    Log.i("mediagallery/dialog/delete/" + this.p.size());
    ArrayList localArrayList = new ArrayList(this.p.values());
    return a.a.a.a.d.a(this, this.aq, this.r, localArrayList, new h(this));
  }
  
  public void onDestroy()
  {
    Log.i("mystatuses/destroy");
    super.onDestroy();
    this.I.unregisterObserver(this.J);
    if (this.s != null) {
      this.s.cancel(true);
    }
    Iterator localIterator = this.y.values().iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).cancel(true);
    }
    this.y.clear();
    this.aq.b(this.K);
    this.aq.b(this.L);
  }
  
  public void onPause()
  {
    Log.i("mystatuses/pause");
    super.onPause();
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (paramBundle != null)
    {
      Object localObject = paramBundle.getParcelableArrayList("selected_messages");
      if (localObject != null)
      {
        this.p.clear();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          FMessageKey localFMessageKey = (FMessageKey)((Iterator)localObject).next();
          this.p.put(localFMessageKey.a, this.C.a(localFMessageKey.a));
        }
        if (this.o == null) {
          this.o = a(this.H);
        }
        this.o.b(NumberFormat.getInstance().format(this.p.size()));
        this.o.d();
        this.n.notifyDataSetChanged();
      }
      paramBundle = (FMessageKey)paramBundle.getParcelable("forwarded_message");
      if (paramBundle != null) {
        this.q = this.C.a(paramBundle.a);
      }
    }
  }
  
  public void onResume()
  {
    Log.i("mystatuses/resume");
    super.onResume();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (!this.p.isEmpty())
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.p.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new FMessageKey(((j)localIterator.next()).e));
      }
      paramBundle.putParcelableArrayList("selected_messages", localArrayList);
    }
    if (this.q != null) {
      paramBundle.putParcelable("forwarded_message", new FMessageKey(this.q.e));
    }
  }
  
  public void onStart()
  {
    Log.i("mystatuses/start");
    super.onStart();
    n();
    o();
  }
  
  public void onStop()
  {
    Log.i("mystatuses/stop");
    super.onStop();
  }
  
  final class a
    extends AsyncTask<Void, List<j>, List<j>>
  {
    private a() {}
  }
  
  final class b
    extends AsyncTask<Void, Void, Integer>
  {
    final j.b a;
    
    b(j.b paramb)
    {
      this.a = paramb;
    }
  }
  
  final class c
    extends BaseAdapter
  {
    List<j> a = new ArrayList();
    
    private c() {}
    
    public final j a(int paramInt)
    {
      return (j)this.a.get(paramInt);
    }
    
    public final int getCount()
    {
      return this.a.size();
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      j localj;
      Object localObject;
      label111:
      label157:
      boolean bool;
      if (paramView == null)
      {
        paramView = al.a(MyStatusesActivity.t(MyStatusesActivity.this), MyStatusesActivity.this.getLayoutInflater(), 2130903310, paramViewGroup, false);
        paramViewGroup = new MyStatusesActivity.d(MyStatusesActivity.this, paramView);
        paramView.setTag(paramViewGroup);
        localj = a(paramInt);
        if (!(localj.N instanceof MediaData)) {
          break label412;
        }
        localObject = localj.b();
        if ((((MediaData)localObject).file != null) && (((MediaData)localObject).file.exists())) {
          break label386;
        }
        MyStatusesActivity.o(paramViewGroup.k).b(localj, paramViewGroup.b, MyStatusesActivity.n(paramViewGroup.k));
        if (localj.I <= 0L) {
          break label491;
        }
        paramViewGroup.d.setText(com.whatsapp.util.l.b(paramViewGroup.k, MyStatusesActivity.q(paramViewGroup.k), MyStatusesActivity.r(paramViewGroup.k).a(localj.I)));
        bool = MyStatusesActivity.b(paramViewGroup.k).containsKey(localj.e);
        localObject = paramViewGroup.a;
        if (!bool) {
          break label562;
        }
        paramInt = 2131624041;
        label188:
        ((View)localObject).setBackgroundResource(paramInt);
        if (!MyStatusesActivity.c(paramViewGroup.k).remove(localj.e)) {
          break label567;
        }
        paramViewGroup.j.getViewTreeObserver().addOnPreDrawListener(new MyStatusesActivity.d.1(paramViewGroup, bool));
        label234:
        localObject = localj.b();
        if ((localObject != null) && (!((MediaData)localObject).transferred)) {
          break label636;
        }
        paramViewGroup.e.setVisibility(0);
        localObject = (Integer)MyStatusesActivity.s(paramViewGroup.k).get(localj.e);
        if (localObject != null) {
          break label580;
        }
        paramViewGroup.f.setVisibility(8);
        MyStatusesActivity.a(paramViewGroup.k, localj.e, false);
        label309:
        paramViewGroup.d.setTextColor(android.support.v4.content.b.c(paramViewGroup.k.getBaseContext(), 2131624118));
        paramViewGroup.i.setVisibility(8);
        paramViewGroup.h.setVisibility(8);
      }
      for (;;)
      {
        paramViewGroup.e.setTag(localj);
        paramViewGroup.f.setTag(localj);
        paramViewGroup.h.setTag(localj);
        return paramView;
        paramViewGroup = (MyStatusesActivity.d)paramView.getTag();
        break;
        label386:
        MyStatusesActivity.o(paramViewGroup.k).a(localj, paramViewGroup.b, MyStatusesActivity.n(paramViewGroup.k));
        break label111;
        label412:
        if (localj.s == 0)
        {
          localObject = new ahd(paramViewGroup.k, MyStatusesActivity.p(paramViewGroup.k), localj.e(), localj.c());
          ((ahd)localObject).a = (paramViewGroup.b.getBorderSize() / 2.0F);
          paramViewGroup.b.setImageDrawable((Drawable)localObject);
          break label111;
        }
        paramViewGroup.b.setImageResource(z.a(localj));
        break label111;
        label491:
        if ((localj.N instanceof MediaData)) {}
        for (localObject = localj.b();; localObject = null)
        {
          if ((localObject == null) || (((MediaData)localObject).transferred) || (((MediaData)localObject).transferring)) {
            break label549;
          }
          paramViewGroup.d.setText(2131297679);
          break;
        }
        label549:
        paramViewGroup.d.setText(2131297680);
        break label157;
        label562:
        paramInt = 0;
        break label188;
        label567:
        paramViewGroup.j.a(bool, false);
        break label234;
        label580:
        paramViewGroup.f.setVisibility(0);
        paramViewGroup.f.setContentDescription(u.a.a(2131230817, ((Integer)localObject).intValue(), new Object[] { localObject }));
        paramViewGroup.g.setText(NumberFormat.getInstance().format(localObject));
        break label309;
        label636:
        paramViewGroup.e.setVisibility(8);
        paramViewGroup.f.setVisibility(8);
        if (((MediaData)localObject).transferring)
        {
          paramViewGroup.d.setTextColor(android.support.v4.content.b.c(paramViewGroup.k.getBaseContext(), 2131624118));
          paramViewGroup.i.setVisibility(0);
          paramViewGroup.h.setVisibility(8);
        }
        else
        {
          paramViewGroup.d.setTextColor(android.support.v4.content.b.c(paramViewGroup.k.getBaseContext(), 2131624117));
          paramViewGroup.i.setVisibility(8);
          paramViewGroup.h.setVisibility(0);
        }
      }
    }
  }
  
  final class d
  {
    final View a;
    final ContactStatusThumbnail b;
    final View c;
    final TextView d;
    final View e;
    final View f;
    final TextView g;
    final View h;
    final ProgressBar i;
    final SelectionCheckView j;
    
    d(View paramView)
    {
      this.a = paramView;
      this.b = ((ContactStatusThumbnail)paramView.findViewById(2131755363));
      this.b.setClickable(false);
      this.c = paramView.findViewById(2131755395);
      this.c.setClickable(false);
      this.d = ((TextView)paramView.findViewById(2131755399));
      this.e = paramView.findViewById(2131755581);
      this.e.setOnClickListener(MyStatusesActivity.k(MyStatusesActivity.this));
      this.f = paramView.findViewById(2131755972);
      this.f.setOnClickListener(MyStatusesActivity.l(MyStatusesActivity.this));
      this.g = ((TextView)paramView.findViewById(2131755973));
      this.h = paramView.findViewById(2131755797);
      this.h.setOnClickListener(MyStatusesActivity.m(MyStatusesActivity.this));
      this.i = ((ProgressBar)paramView.findViewById(2131755224));
      a.a.a.a.d.a(this.i, android.support.v4.content.b.c(paramView.getContext(), 2131623944));
      this.j = ((SelectionCheckView)paramView.findViewById(2131755512));
      aoa.b(this.g);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/MyStatusesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */