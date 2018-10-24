package com.whatsapp;

import a.a.a.a.a.a.d;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.m;
import android.support.v4.view.ab;
import android.support.v4.view.o;
import android.support.v4.view.o.e;
import android.support.v7.app.b.a;
import android.support.v7.widget.SearchView.b;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import com.whatsapp.data.ad;
import com.whatsapp.data.co;
import com.whatsapp.data.cs;
import com.whatsapp.data.cs.b;
import com.whatsapp.data.cs.c;
import com.whatsapp.data.cs.d;
import com.whatsapp.data.e;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.be;
import com.whatsapp.util.bu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StatusRecipientsActivity
  extends nm
{
  private final Set<String> A = new HashSet();
  private boolean B = true;
  private final ad C;
  private final att D;
  private final e E;
  private final co F;
  private final di.e G;
  private final dh H;
  private final dh.a I;
  a n;
  String o;
  ahp p;
  final Set<String> q = new HashSet();
  final Set<String> r = new HashSet();
  final Runnable s;
  Handler t;
  private List<cs> u = new ArrayList();
  private Set<String> v = new HashSet();
  private ArrayList<String> w;
  private MenuItem x;
  private e y;
  private c z;
  
  public StatusRecipientsActivity()
  {
    Set localSet = this.r;
    localSet.getClass();
    this.s = amq.a(localSet);
    this.t = new Handler(Looper.getMainLooper());
    this.C = ad.a();
    this.D = att.a();
    this.E = e.a();
    this.F = co.a();
    this.G = di.a().b();
    this.H = dh.a();
    this.I = new dh.a()
    {
      public final void a()
      {
        Log.d("statusrecipients/onContactsChanged");
        StatusRecipientsActivity.a(StatusRecipientsActivity.this);
      }
      
      protected final void a(String paramAnonymousString)
      {
        paramAnonymousString = new cs.b(StatusRecipientsActivity.b(StatusRecipientsActivity.this).d(paramAnonymousString));
        if (cs.a(StatusRecipientsActivity.c(StatusRecipientsActivity.this), paramAnonymousString)) {
          StatusRecipientsActivity.d(StatusRecipientsActivity.this);
        }
      }
      
      public final void a(Collection<String> paramAnonymousCollection)
      {
        StatusRecipientsActivity.d(StatusRecipientsActivity.this);
      }
      
      public final void b(String paramAnonymousString)
      {
        paramAnonymousString = new cs.c(StatusRecipientsActivity.b(StatusRecipientsActivity.this).d(paramAnonymousString));
        if (cs.a(StatusRecipientsActivity.c(StatusRecipientsActivity.this), paramAnonymousString)) {
          StatusRecipientsActivity.d(StatusRecipientsActivity.this);
        }
      }
      
      public final void c(String paramAnonymousString)
      {
        paramAnonymousString = new cs.d(StatusRecipientsActivity.b(StatusRecipientsActivity.this).d(paramAnonymousString));
        if (cs.a(StatusRecipientsActivity.c(StatusRecipientsActivity.this), paramAnonymousString)) {
          StatusRecipientsActivity.d(StatusRecipientsActivity.this);
        }
      }
    };
  }
  
  private void m()
  {
    if (this.y != null) {
      this.y.cancel(true);
    }
    if (this.z != null)
    {
      this.z.cancel(true);
      this.z = null;
    }
    this.y = new e((byte)0);
    bu.a(this.y, new Void[0]);
  }
  
  private void n()
  {
    if ((this.A.containsAll(this.q)) && (this.q.containsAll(this.A)))
    {
      finish();
      return;
    }
    a(new b());
  }
  
  final void l()
  {
    String str;
    if (this.B) {
      if (this.q.isEmpty()) {
        str = getString(2131297284);
      }
    }
    for (;;)
    {
      ((android.support.v7.app.a)a.d.a(i())).b(str);
      return;
      str = u.a.a(2131230807, this.q.size(), new Object[] { Integer.valueOf(this.q.size()) });
      continue;
      if (this.q.isEmpty()) {
        str = getString(2131297285);
      } else {
        str = u.a.a(2131230808, this.q.size(), new Object[] { Integer.valueOf(this.q.size()) });
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 150)
    {
      if (paramInt2 != -1)
      {
        Log.i("statusrecipients/permissions denied");
        finish();
      }
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    if (this.p.c())
    {
      this.p.b();
      return;
    }
    n();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("statusrecipients/create");
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().addFlags(Integer.MIN_VALUE);
    }
    super.onCreate(paramBundle);
    setContentView(2130903369);
    Object localObject = (Toolbar)findViewById(2131755412);
    a((Toolbar)localObject);
    this.p = new ahp(this, this.aq, findViewById(2131755496), (Toolbar)localObject, new SearchView.b()
    {
      public final boolean a(String paramAnonymousString)
      {
        return false;
      }
      
      public final boolean b(String paramAnonymousString)
      {
        StatusRecipientsActivity.a(StatusRecipientsActivity.this, paramAnonymousString);
        StatusRecipientsActivity.a(StatusRecipientsActivity.this, be.c(paramAnonymousString));
        if (StatusRecipientsActivity.e(StatusRecipientsActivity.this).isEmpty()) {
          StatusRecipientsActivity.a(StatusRecipientsActivity.this, null);
        }
        StatusRecipientsActivity.f(StatusRecipientsActivity.this);
        return false;
      }
    });
    this.B = getIntent().getBooleanExtra("is_black_list", true);
    localObject = (android.support.v7.app.a)a.d.a(i());
    ((android.support.v7.app.a)localObject).a(true);
    if (this.B) {}
    for (int i = 2131297914;; i = 2131297915)
    {
      ((android.support.v7.app.a)localObject).a(i);
      if ((paramBundle == null) && (!this.aP.d())) {
        RequestPermissionActivity.a(this, 2131297372, 2131297371);
      }
      findViewById(2131756098).setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          StatusRecipientsActivity.g(StatusRecipientsActivity.this);
        }
      });
      m();
      paramBundle = (ListView)findViewById(16908298);
      localObject = new View(this);
      ((View)localObject).setLayoutParams(new AbsListView.LayoutParams(1, getResources().getDimensionPixelSize(2131361892)));
      paramBundle.addFooterView((View)localObject, null, false);
      this.n = new a((byte)0);
      paramBundle.setAdapter(this.n);
      paramBundle.setOnItemClickListener(amr.a(this));
      l();
      findViewById(16908292).setVisibility(0);
      findViewById(2131755510).setVisibility(0);
      this.H.registerObserver(this.I);
      return;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    this.x = paramMenu.add(0, 2131755072, 0, 2131297631).setIcon(2130840073);
    o.a(this.x, 10);
    o.a(this.x, new o.e()
    {
      public final boolean a(MenuItem paramAnonymousMenuItem)
      {
        return true;
      }
      
      public final boolean b(MenuItem paramAnonymousMenuItem)
      {
        StatusRecipientsActivity.a(StatusRecipientsActivity.this, null);
        StatusRecipientsActivity.f(StatusRecipientsActivity.this);
        return true;
      }
    });
    MenuItem localMenuItem = this.x;
    if (!this.u.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      localMenuItem.setVisible(bool);
      o.a(paramMenu.add(0, 2131755073, 0, 2131297646).setIcon(2130840075), 2);
      return super.onCreateOptionsMenu(paramMenu);
    }
  }
  
  public void onDestroy()
  {
    Log.i("statusrecipients/destroy");
    super.onDestroy();
    this.H.unregisterObserver(this.I);
    this.G.a();
    if (this.y != null)
    {
      this.y.cancel(true);
      this.y = null;
    }
    if (this.z != null)
    {
      this.z.cancel(true);
      this.z = null;
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return true;
    case 2131755072: 
      onSearchRequested();
      return true;
    case 2131755073: 
      if (this.q.size() == this.v.size())
      {
        this.q.clear();
        this.n.notifyDataSetChanged();
        l();
        return true;
      }
      int i = 0;
      while (i < this.n.getCount())
      {
        this.q.add(this.n.a(i).t);
        i += 1;
      }
    }
    n();
    return true;
  }
  
  public boolean onSearchRequested()
  {
    this.p.a();
    return false;
  }
  
  final class a
    extends BaseAdapter
  {
    List<cs> a = new ArrayList();
    
    private a() {}
    
    private void a(SelectionCheckView paramSelectionCheckView, boolean paramBoolean)
    {
      if (StatusRecipientsActivity.h(StatusRecipientsActivity.this))
      {
        localStatusRecipientsActivity = StatusRecipientsActivity.this;
        if (paramBoolean) {}
        for (i = 2131297894;; i = 2131297895)
        {
          paramSelectionCheckView.setContentDescription(localStatusRecipientsActivity.getString(i));
          return;
        }
      }
      StatusRecipientsActivity localStatusRecipientsActivity = StatusRecipientsActivity.this;
      if (paramBoolean) {}
      for (int i = 2131297897;; i = 2131297896)
      {
        paramSelectionCheckView.setContentDescription(localStatusRecipientsActivity.getString(i));
        return;
      }
    }
    
    public final cs a(int paramInt)
    {
      return (cs)this.a.get(paramInt);
    }
    
    public final int getCount()
    {
      return this.a.size();
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, final ViewGroup paramViewGroup)
    {
      cs localcs = a(paramInt);
      View localView;
      final boolean bool;
      if (paramView == null)
      {
        localView = al.a(StatusRecipientsActivity.this.aq, StatusRecipientsActivity.this.getLayoutInflater(), 2130903370, paramViewGroup, false);
        paramView = new StatusRecipientsActivity.f((byte)0);
        localView.setTag(paramView);
        paramView.b = ((ImageView)localView.findViewById(2131755511));
        paramView.c = ((TextEmojiLabel)localView.findViewById(2131755517));
        paramView.d = ((SelectionCheckView)localView.findViewById(2131755512));
        aoa.b(paramView.c);
        paramViewGroup = paramView;
        localView.setClickable(false);
        localView.setLongClickable(false);
        paramViewGroup.a = localcs.t;
        StatusRecipientsActivity.s(StatusRecipientsActivity.this).a(localcs, paramViewGroup.b);
        ab.c(paramViewGroup.b, 2);
        paramViewGroup.c.a(localcs, StatusRecipientsActivity.e(StatusRecipientsActivity.this));
        bool = StatusRecipientsActivity.i(StatusRecipientsActivity.this).contains(localcs.t);
        if (!StatusRecipientsActivity.h(StatusRecipientsActivity.this)) {
          break label257;
        }
        paramViewGroup.d.setSelectionBackground(2130840473);
      }
      for (;;)
      {
        if (!StatusRecipientsActivity.t(StatusRecipientsActivity.this).remove(localcs.t)) {
          break label269;
        }
        paramViewGroup.d.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            paramViewGroup.d.getViewTreeObserver().removeOnPreDrawListener(this);
            paramViewGroup.d.a(bool, true);
            StatusRecipientsActivity.a.a(StatusRecipientsActivity.a.this, paramViewGroup.d, bool);
            return false;
          }
        });
        return localView;
        paramViewGroup = (StatusRecipientsActivity.f)paramView.getTag();
        localView = paramView;
        break;
        label257:
        paramViewGroup.d.setSelectionBackground(2130840520);
      }
      label269:
      paramViewGroup.d.a(bool, false);
      a(paramViewGroup.d, bool);
      return localView;
    }
  }
  
  public static final class b
    extends m
  {
    public final Dialog c(Bundle paramBundle)
    {
      paramBundle = ams.a(this);
      return new b.a(l()).b(2131296674).a(2131296681, paramBundle).b(2131296398, null).a();
    }
  }
  
  final class c
    extends AsyncTask<Void, Void, ArrayList<cs>>
  {
    private final ArrayList<String> b;
    private final List<cs> c;
    
    c(List<cs> paramList)
    {
      if (paramList != null) {}
      for (this$1 = new ArrayList(paramList);; this$1 = null)
      {
        this.b = StatusRecipientsActivity.this;
        List localList;
        this.c = localList;
        return;
      }
    }
  }
  
  static final class d
  {
    ArrayList<cs> a;
    Set<String> b;
    Set<String> c;
  }
  
  final class e
    extends AsyncTask<Void, StatusRecipientsActivity.d, StatusRecipientsActivity.d>
  {
    private e() {}
  }
  
  static final class f
  {
    String a;
    ImageView b;
    TextEmojiLabel c;
    SelectionCheckView d;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/StatusRecipientsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */