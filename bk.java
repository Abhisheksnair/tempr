package com.whatsapp;

import a.a.a.a.a.a.d;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ag;
import android.support.v4.app.m;
import android.support.v4.app.n;
import android.support.v4.content.b;
import android.support.v4.view.ab;
import android.support.v7.app.b.a;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.whatsapp.data.ad;
import com.whatsapp.data.ad.j;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.k.c;
import com.whatsapp.k.d.e;
import com.whatsapp.notification.k;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.az;
import com.whatsapp.util.be;
import com.whatsapp.util.bu;
import com.whatsapp.util.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class bk
  extends ag
  implements sg
{
  private ArrayList<a> aa = new ArrayList();
  private CharSequence ab;
  private ArrayList<String> ac;
  private ArrayList<a> ad = new ArrayList();
  private f ae;
  private MenuItem af;
  private com.whatsapp.k.d ag;
  private boolean ah = false;
  private final ant ai = ant.a();
  private final pv aj = pv.a();
  private final ani ak = ani.a();
  private final br al = br.a();
  private final ad am = ad.a();
  private final aus an = aus.a();
  private final dh ao = dh.a();
  private final atu ap = atu.a();
  private final di.e aq = di.a().b();
  private final e ar = e.a();
  private final dh.a as = new dh.a()
  {
    public final void a()
    {
      bk.b(bk.this).getFilter().filter(bk.a(bk.this));
    }
    
    protected final void a(String paramAnonymousString)
    {
      bk.b(bk.this).notifyDataSetChanged();
    }
    
    public final void b(String paramAnonymousString)
    {
      bk.b(bk.this).notifyDataSetChanged();
    }
  };
  private final ba at = ba.a();
  private final ba.a au = new ba.a(this);
  private final bb av = bb.a();
  private final bb.a aw = new bb.a()
  {
    public final void b(j paramAnonymousj)
    {
      Log.i("voip/CallsFragment/onCallEnded");
      if (!Voip.a(paramAnonymousj)) {
        bk.c(bk.this);
      }
    }
    
    public final void c(j paramAnonymousj)
    {
      Log.i("voip/CallsFragment/onCallMissed");
      bk.c(bk.this);
    }
  };
  private final Runnable ax = bl.a(this);
  private final at ay = new at()
  {
    public final void a(View paramAnonymousView)
    {
      bk.a locala = (bk.a)paramAnonymousView.getTag();
      cs localcs;
      if (locala != null)
      {
        localcs = locala.a();
        switch (bk.6.a[(locala.c() - 1)])
        {
        default: 
          paramAnonymousView = null;
        }
      }
      for (;;)
      {
        bk.m(bk.this).a(localcs, bk.this.l(), paramAnonymousView, true, locala.d());
        return;
        paramAnonymousView = Integer.valueOf(9);
        continue;
        paramAnonymousView = Integer.valueOf(2);
        continue;
        paramAnonymousView = Integer.valueOf(1);
      }
    }
  };
  private final View.OnTouchListener az = new agl(0.15F, 0.15F, 0.15F, 0.15F);
  c i;
  
  private void T()
  {
    Intent localIntent = new Intent(l(), ContactPicker.class);
    localIntent.putExtra("call_picker", true);
    startActivityForResult(localIntent, 10);
  }
  
  public final void A()
  {
    Log.i("voip/CallsFragment/onDestroy");
    super.A();
    this.ag.c();
    this.ao.unregisterObserver(this.as);
    this.at.unregisterObserver(this.au);
    this.av.unregisterObserver(this.aw);
    this.aq.a();
    this.aj.b(this.ax);
  }
  
  final void R()
  {
    this.aj.b(this.ax);
    if ((!this.aa.isEmpty()) && (l() != null)) {
      this.aj.a(this.ax, l.e(((a)this.aa.get(0)).b()) - System.currentTimeMillis() + 1000L);
    }
  }
  
  final void S()
  {
    if (this.ae != null) {
      this.ae.cancel(true);
    }
    this.ae = new f((byte)0);
    bu.a(this.ae, new Void[0]);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    this.ag.a(d.e.c);
    paramLayoutInflater = HomeActivity.a(paramLayoutInflater.inflate(2130903096, paramViewGroup, false), this);
    this.ag.b(d.e.c);
    return paramLayoutInflater;
  }
  
  public final void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool = true;
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt2 != -1);
        localObject = paramIntent.getStringExtra("contact");
        paramInt1 = paramIntent.getIntExtra("call_type", 1);
      } while ((paramInt1 != 1) && (paramInt1 != 2));
      paramIntent = this.al;
      Object localObject = this.ar.d((String)localObject);
      n localn = l();
      if (paramInt1 == 2) {}
      for (;;)
      {
        paramIntent.a((cs)localObject, localn, Integer.valueOf(3), false, bool);
        return;
        bool = false;
      }
    } while (paramInt2 != -1);
    T();
  }
  
  public final void a(Bundle paramBundle)
  {
    this.ag = c.a("CallFragmentInit");
    this.ag.a();
    this.ag.a(d.e.b);
    super.a(paramBundle);
    this.ag.b(d.e.b);
  }
  
  public final void a(Menu paramMenu)
  {
    this.af = paramMenu.findItem(2131755034);
    if (this.af != null)
    {
      paramMenu = this.af;
      if (this.aa.isEmpty()) {
        break label46;
      }
    }
    label46:
    for (boolean bool = true;; bool = false)
    {
      paramMenu.setVisible(bool);
      return;
    }
  }
  
  public final void a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.a(paramMenu, paramMenuInflater);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.ab = paramCharSequence;
    this.i.getFilter().filter(paramCharSequence);
  }
  
  public final void a(boolean paramBoolean) {}
  
  public final boolean a(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131755060) {
      k_();
    }
    do
    {
      return true;
      if (paramMenuItem.getItemId() != 2131755034) {
        break;
      }
    } while (!p());
    new e().a(n(), null);
    return true;
    return super.a(paramMenuItem);
  }
  
  public final void d(Bundle paramBundle)
  {
    Log.i("voip/CallsFragment/onActivityCreated");
    this.ag.a(d.e.d);
    super.d(paramBundle);
    s();
    paramBundle = b();
    paramBundle.setDivider(new az(b.a(k(), 2130837766)));
    if (Build.VERSION.SDK_INT < 11) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.setFastScrollEnabled(bool);
      if (Build.VERSION.SDK_INT < 11) {
        paramBundle.setSelector(2130840501);
      }
      paramBundle.setScrollbarFadingEnabled(true);
      paramBundle.setOnItemClickListener(bm.a(this));
      ((View)a.d.a(x())).findViewById(2131755394).setVisibility(0);
      this.i = new c();
      a(this.i);
      this.ao.registerObserver(this.as);
      this.at.registerObserver(this.au);
      this.av.registerObserver(this.aw);
      S();
      this.ag.b(d.e.d);
      return;
    }
  }
  
  public final void e()
  {
    super.e();
    R();
  }
  
  public final void k_()
  {
    if (Voip.e())
    {
      Log.w("voip/CallsFragment try to start outgoing call from active voip call");
      pv.a(l(), 2131296731, 0);
      return;
    }
    if (this.ap.d())
    {
      T();
      return;
    }
    RequestPermissionActivity.a(this, 2131297374, 2131297373);
  }
  
  public final void y()
  {
    Log.i("voip/CallsFragment/onResume");
    super.y();
  }
  
  public final void z()
  {
    Log.i("voip/CallsFragment/onPause");
    super.z();
    this.ag.c();
  }
  
  final class a
  {
    final ArrayList<j> a = new ArrayList();
    
    a() {}
    
    a(j paramj)
    {
      this.a.add(paramj);
    }
    
    final cs a()
    {
      if (this.a.isEmpty()) {
        return null;
      }
      return bk.k(bk.this).d(((j)this.a.get(0)).e.a);
    }
    
    final boolean a(j paramj)
    {
      boolean bool = false;
      int i;
      int j;
      if (!this.a.isEmpty())
      {
        j localj = (j)this.a.get(this.a.size() - 1);
        if ((!paramj.e.a.equals(localj.e.a)) || (!l.a(paramj.n, localj.n))) {
          break label168;
        }
        if ((paramj.e.b) || (paramj.w != 0)) {
          break label153;
        }
        i = 1;
        if ((localj.e.b) || (localj.w != 0)) {
          break label158;
        }
        j = 1;
        label110:
        if ((i != j) || (Voip.b(paramj) != Voip.b(localj))) {
          break label163;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0) {
          bool = true;
        }
        if (bool) {
          this.a.add(paramj);
        }
        return bool;
        label153:
        i = 0;
        break;
        label158:
        j = 0;
        break label110;
        label163:
        i = 0;
        continue;
        label168:
        i = 0;
      }
    }
    
    final long b()
    {
      if (this.a.isEmpty()) {
        return 0L;
      }
      return bk.l(bk.this).a((j)this.a.get(0));
    }
    
    final int c()
    {
      if (this.a.isEmpty()) {
        return bk.b.d;
      }
      j localj = (j)this.a.get(0);
      if (localj.e.b) {
        return bk.b.a;
      }
      if (localj.w > 0) {
        return bk.b.b;
      }
      return bk.b.c;
    }
    
    final boolean d()
    {
      return (!this.a.isEmpty()) && (Voip.b((j)this.a.get(0)));
    }
    
    public final String toString()
    {
      if (this.a.isEmpty()) {
        return null;
      }
      return a().a(bk.this.l());
    }
  }
  
  static enum b
  {
    public static int[] a()
    {
      return (int[])e.clone();
    }
  }
  
  final class c
    extends BaseAdapter
    implements Filterable
  {
    private Filter b;
    
    c() {}
    
    private bk.a a(int paramInt)
    {
      return (bk.a)bk.s(bk.this).get(paramInt);
    }
    
    public final int getCount()
    {
      return bk.s(bk.this).size();
    }
    
    public final Filter getFilter()
    {
      if (this.b == null) {
        this.b = new bk.d(bk.this, (byte)0);
      }
      return this.b;
    }
    
    public final long getItemId(int paramInt)
    {
      return ((bk.a)bk.s(bk.this).get(paramInt)).hashCode();
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = 0;
      bk.a locala;
      if (paramView == null)
      {
        paramView = al.a(bk.t(bk.this), bk.this.l().getLayoutInflater(), 2130903097, paramViewGroup, false);
        paramViewGroup = new bk.g(bk.this, paramView);
        paramView.setTag(paramViewGroup);
        locala = a(paramInt);
        paramViewGroup.h = locala;
        Object localObject1 = locala.a();
        Object localObject2 = bk.class.getName() + ((cs)localObject1).t + " " + locala.b();
        ab.a(paramViewGroup.a, (String)localObject2);
        localObject2 = new QuickContactActivity.a(paramViewGroup.i.l(), ((cs)localObject1).t, (String)localObject2);
        paramViewGroup.a.setOnClickListener((View.OnClickListener)localObject2);
        paramViewGroup.b.setOnClickListener((View.OnClickListener)localObject2);
        bk.n(paramViewGroup.i).a((cs)localObject1, paramViewGroup.a);
        paramViewGroup.c.a((cs)localObject1, bk.o(paramViewGroup.i));
        paramViewGroup.d.setText(l.b(paramViewGroup.i.l(), bk.p(paramViewGroup.i), locala.b()));
        paramInt = locala.a.size();
        if (paramInt <= 1) {
          break label506;
        }
        paramViewGroup.f.setText("(" + Integer.toString(paramInt) + ")");
        paramViewGroup.f.setVisibility(0);
        label275:
        localObject1 = paramViewGroup.e;
        paramInt = locala.c();
        switch (bk.6.a[(paramInt - 1)])
        {
        default: 
          paramInt = 0;
          label322:
          ((ImageView)localObject1).setImageResource(paramInt);
          localObject1 = paramViewGroup.e;
          localObject2 = paramViewGroup.i;
          paramInt = locala.c();
          switch (bk.6.a[(paramInt - 1)])
          {
          default: 
            paramInt = i;
            label383:
            ((ImageView)localObject1).setContentDescription(((bk)localObject2).a(paramInt));
            paramViewGroup.g.setOnClickListener(bk.q(paramViewGroup.i));
            paramViewGroup.g.setTag(locala);
            paramViewGroup.g.setOnTouchListener(bk.r(paramViewGroup.i));
            if (locala.d())
            {
              paramViewGroup.g.setImageResource(2130840085);
              paramViewGroup.g.setContentDescription(paramViewGroup.i.a(2131298106));
              if (aic.h()) {
                a.d.b(paramViewGroup.g.getDrawable(), paramViewGroup.i.m().getColor(2131624128));
              }
            }
            break;
          }
          break;
        }
      }
      label506:
      do
      {
        return paramView;
        paramViewGroup = (bk.g)paramView.getTag();
        break;
        paramViewGroup.f.setVisibility(8);
        break label275;
        paramInt = 2130837727;
        break label322;
        paramInt = 2130837725;
        break label322;
        paramInt = 2130837726;
        break label322;
        if (locala.d())
        {
          paramInt = 2131298118;
          break label383;
        }
        paramInt = 2131297338;
        break label383;
        if (locala.d())
        {
          paramInt = 2131298113;
          break label383;
        }
        paramInt = 2131297039;
        break label383;
        if (locala.d())
        {
          paramInt = 2131298114;
          break label383;
        }
        paramInt = 2131297187;
        break label383;
        paramViewGroup.g.setImageResource(2130840052);
        paramViewGroup.g.setContentDescription(paramViewGroup.i.a(2131296341));
      } while (!aic.h());
      a.d.b(paramViewGroup.g.getDrawable(), paramViewGroup.i.m().getColor(2131623985));
      return paramView;
    }
    
    public final boolean hasStableIds()
    {
      return true;
    }
  }
  
  final class d
    extends Filter
  {
    private d() {}
    
    protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
    {
      Filter.FilterResults localFilterResults = new Filter.FilterResults();
      ArrayList localArrayList;
      if (!TextUtils.isEmpty(paramCharSequence))
      {
        localArrayList = new ArrayList(bk.h(bk.this));
        paramCharSequence = be.c(paramCharSequence.toString());
        ListIterator localListIterator = localArrayList.listIterator();
        while (localListIterator.hasNext()) {
          if (!((bk.a)localListIterator.next()).a().a(paramCharSequence)) {
            localListIterator.remove();
          }
        }
      }
      for (paramCharSequence = localArrayList;; paramCharSequence = bk.h(bk.this))
      {
        localFilterResults.values = paramCharSequence;
        localFilterResults.count = paramCharSequence.size();
        return localFilterResults;
      }
    }
    
    protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
    {
      bk.b(bk.this, (ArrayList)paramFilterResults.values);
      if (bk.s(bk.this) == null) {
        bk.b(bk.this, bk.h(bk.this));
      }
      bk.a(bk.this, paramCharSequence);
      paramFilterResults = bk.this;
      if (paramCharSequence == null) {}
      for (paramCharSequence = null;; paramCharSequence = paramCharSequence.toString())
      {
        bk.c(paramFilterResults, be.c(paramCharSequence));
        bk.i(bk.this);
        bk.u(bk.this);
        bk.b(bk.this).notifyDataSetChanged();
        return;
      }
    }
  }
  
  public static final class e
    extends m
  {
    final pv aa = pv.a();
    final ad ab = ad.a();
    final ba ac = ba.a();
    final k ad = k.a();
    
    public final Dialog c(Bundle paramBundle)
    {
      paramBundle = bn.a(this);
      return new b.a(l()).b(2131296435).a(2131297331, paramBundle).b(2131296398, null).a();
    }
  }
  
  final class f
    extends AsyncTask<Void, ArrayList<bk.a>, ArrayList<bk.a>>
  {
    private f() {}
    
    private ArrayList<bk.a> a()
    {
      Object localObject2 = new bq(this);
      ArrayList localArrayList2 = bk.e(bk.this).a(0, 100, (ad.j)localObject2);
      if (isCancelled()) {
        return null;
      }
      Log.i("calls/RefreshCallsTask/doInBackground");
      ArrayList localArrayList1 = new ArrayList();
      bk.a locala = new bk.a(bk.this);
      label281:
      for (;;)
      {
        try
        {
          j.b localb = Voip.a();
          Iterator localIterator = localArrayList2.iterator();
          if (localIterator.hasNext())
          {
            j localj = (j)localIterator.next();
            if ((localj.e.equals(localb)) || (locala.a(localj))) {
              break label281;
            }
            localArrayList1.add(locala);
            locala = new bk.a(bk.this, localj);
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          Log.e(localUnsatisfiedLinkError);
          Object localObject1 = null;
          continue;
          localObject1 = locala;
          if (localArrayList2.size() >= 100)
          {
            publishProgress(new ArrayList[] { new ArrayList(localArrayList1) });
            localObject1 = bk.e(bk.this).a(100, 1000, (ad.j)localObject2);
            if (isCancelled()) {
              break;
            }
            localObject2 = ((ArrayList)localObject1).iterator();
            localObject1 = locala;
            if (((Iterator)localObject2).hasNext())
            {
              localObject1 = (j)((Iterator)localObject2).next();
              if (locala.a((j)localObject1)) {
                continue;
              }
              localArrayList1.add(locala);
              locala = new bk.a(bk.this, (j)localObject1);
              continue;
            }
          }
          if (!((bk.a)localObject1).a.isEmpty()) {
            localArrayList1.add(localObject1);
          }
          return localArrayList1;
        }
      }
    }
  }
  
  final class g
  {
    final ImageView a;
    final View b;
    final TextEmojiLabel c;
    final TextView d;
    final ImageView e;
    final TextView f;
    final ImageView g;
    bk.a h;
    
    g(View paramView)
    {
      this.a = ((ImageView)paramView.findViewById(2131755363));
      this.b = paramView.findViewById(2131755395);
      this.c = ((TextEmojiLabel)paramView.findViewById(2131755397));
      this.d = ((TextView)paramView.findViewById(2131755399));
      this.e = ((ImageView)paramView.findViewById(2131755380));
      this.f = ((TextView)paramView.findViewById(2131755398));
      this.g = ((ImageView)paramView.findViewById(2131755396));
      aoa.b(this.c);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */