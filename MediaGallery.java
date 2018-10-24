package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout.a;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.b;
import android.support.design.widget.TabLayout.e;
import android.support.v4.app.Fragment;
import android.support.v4.app.r;
import android.support.v4.view.ViewPager;
import android.support.v4.view.o;
import android.support.v4.view.o.e;
import android.support.v7.app.a;
import android.support.v7.view.b.a;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.b;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.whatsapp.data.ad;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.data.l;
import com.whatsapp.data.q;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.az;
import com.whatsapp.util.be;
import com.whatsapp.util.bu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MediaGallery
  extends nh
  implements jz
{
  private final e A = e.a();
  private final q B = q.a();
  private final l C = l.a();
  private final com.whatsapp.data.u D = com.whatsapp.data.u.a();
  private final lt E = lt.a();
  private final b.a F = new aaf(this, this.x, this.aq, this.y, this.aB, this.z, this.A, this.aQ, this.E)
  {
    public final Map<j.b, j> a()
    {
      return MediaGallery.b(MediaGallery.this);
    }
    
    public final void a(android.support.v7.view.b paramAnonymousb)
    {
      MediaGallery.c(MediaGallery.this);
      MediaGallery.d(MediaGallery.this);
      paramAnonymousb = MediaGallery.this.S().iterator();
      while (paramAnonymousb.hasNext())
      {
        Fragment localFragment = (Fragment)paramAnonymousb.next();
        if ((localFragment instanceof MediaGallery.a)) {
          ((MediaGallery.a)localFragment).a();
        }
      }
    }
    
    public final void b()
    {
      if (MediaGallery.a(MediaGallery.this) != null) {
        MediaGallery.a(MediaGallery.this).c();
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
      if (this.p != null) {
        this.p.setVisible(false);
      }
      this.q.setVisible(false);
      return true;
    }
  };
  HashMap<j.b, j> n;
  android.support.v7.view.b o;
  final RecyclerView.i p = new RecyclerView.i()
  {
    public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
    {
      if ((MediaGallery.e(MediaGallery.this) != null) && (o.c(MediaGallery.e(MediaGallery.this))) && (MediaGallery.this.getCurrentFocus() != null)) {
        MediaGallery.h(MediaGallery.this).hideSoftInputFromWindow(paramAnonymousRecyclerView.getWindowToken(), 2);
      }
    }
  };
  private String q;
  private MenuItem r;
  private ArrayList<String> s;
  private String t = "";
  private int u;
  private final InputMethodManager v = (InputMethodManager)u.a().getSystemService("input_method");
  private int w = 2;
  private final ant x = ant.a();
  private final aoj y = aoj.a();
  private final ad z = ad.a();
  
  public final boolean O()
  {
    return this.n != null;
  }
  
  public final void a(android.support.v7.view.b paramb)
  {
    super.a(paramb);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(android.support.v4.content.b.c(this, 2131623951));
    }
  }
  
  public final void a(j paramj)
  {
    this.n = new HashMap();
    this.n.put(paramj.e, paramj);
    this.o = a(this.F);
  }
  
  public final void a(j paramj, int paramInt) {}
  
  public final boolean a(j.b paramb)
  {
    return true;
  }
  
  public final boolean a(j.b paramb, long paramLong, boolean paramBoolean)
  {
    return true;
  }
  
  public void animateStar(View paramView) {}
  
  public final void b(android.support.v7.view.b paramb)
  {
    super.b(paramb);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(android.support.v4.content.b.c(this, 17170444));
    }
  }
  
  public final void b(j.b paramb) {}
  
  public final boolean b(j paramj)
  {
    if (this.n == null) {}
    for (;;)
    {
      return false;
      boolean bool = this.n.containsKey(paramj.e);
      if (bool)
      {
        this.n.remove(paramj.e);
        if (this.n.isEmpty()) {
          this.o.c();
        }
      }
      while (!bool)
      {
        return true;
        this.o.d();
        continue;
        this.n.put(paramj.e, paramj);
        this.o.d();
      }
    }
  }
  
  public final boolean c(j paramj)
  {
    return (this.n != null) && (this.n.containsKey(paramj.e));
  }
  
  public final int d(j paramj)
  {
    return 0;
  }
  
  public final void e(j paramj) {}
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      return;
      if (paramInt2 == -1)
      {
        if (this.n != null)
        {
          paramIntent = paramIntent.getStringArrayListExtra("jids");
          Iterator localIterator = lt.a(this.n.values()).iterator();
          while (localIterator.hasNext())
          {
            j localj = (j)localIterator.next();
            this.y.a(this.as, localj, paramIntent);
          }
          if ((paramIntent.size() == 1) && (!j.c((String)paramIntent.get(0)))) {
            startActivity(Conversation.a(this.A.d((String)paramIntent.get(0))));
          }
        }
        while (this.o != null)
        {
          this.o.c();
          return;
          pv.a(getBaseContext(), paramIntent);
          continue;
          Log.w("mediagallery/forward/failed");
          pv.a(this, 2131297172, 0);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("mediagallery/create");
    super.onCreate(paramBundle);
    bu.a(anf.a(this.aK));
    setContentView(2130903286);
    Object localObject1 = (Toolbar)findViewById(2131755412);
    a((Toolbar)localObject1);
    final Object localObject2 = (a)a.d.a(i());
    ((a)localObject2).b(new az(android.support.v4.content.b.a(this, 2130840097)));
    ((a)localObject2).a(true);
    if (Build.VERSION.SDK_INT >= 21) {
      findViewById(2131755785).setVisibility(8);
    }
    this.q = getIntent().getStringExtra("jid");
    f(this.A.d(this.q).a(this));
    if (getIntent().getBooleanExtra("alert", false)) {
      this.aq.a(this);
    }
    localObject2 = (ViewPager)findViewById(2131755921);
    b localb = new b(j_());
    localb.a(new vr(), getString(2131296828));
    localb.a(new ny(), getString(2131296826));
    TabLayout localTabLayout;
    if (this.D.b())
    {
      localb.a(new tk(), getString(2131296827));
      this.w = 2;
      ((ViewPager)localObject2).setAdapter(localb);
      ((ViewPager)localObject2).setOffscreenPageLimit(localb.b());
      localTabLayout = (TabLayout)findViewById(2131755780);
      if (localb.b() <= 1) {
        break label412;
      }
      localTabLayout.a(android.support.v4.content.b.c(this, 2131624003), android.support.v4.content.b.c(this, 2131623944));
      localTabLayout.setupWithViewPager((ViewPager)localObject2);
      localTabLayout.setOnTabSelectedListener(new TabLayout.b()
      {
        public final void a(TabLayout.e paramAnonymouse)
        {
          localObject2.setCurrentItem(paramAnonymouse.a());
          MenuItem localMenuItem;
          if (MediaGallery.e(MediaGallery.this) != null)
          {
            localMenuItem = MediaGallery.e(MediaGallery.this);
            if (paramAnonymouse.a() == 0) {
              break label84;
            }
          }
          label84:
          for (boolean bool = true;; bool = false)
          {
            localMenuItem.setVisible(bool);
            MediaGallery.a(MediaGallery.this, paramAnonymouse.a());
            paramAnonymouse = MediaGallery.f(MediaGallery.this);
            if (paramAnonymouse != null) {
              paramAnonymouse.a(MediaGallery.g(MediaGallery.this));
            }
            return;
          }
        }
      });
    }
    for (;;)
    {
      label324:
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getParcelableArrayList("selected_messages");
        if (paramBundle != null)
        {
          this.n = new HashMap();
          paramBundle = paramBundle.iterator();
          for (;;)
          {
            if (paramBundle.hasNext())
            {
              localObject1 = (FMessageKey)paramBundle.next();
              this.n.put(((FMessageKey)localObject1).a, this.C.a(((FMessageKey)localObject1).a));
              continue;
              this.w = -1;
              break;
              label412:
              ((AppBarLayout.a)((Toolbar)localObject1).getLayoutParams()).a(0);
              localTabLayout.setVisibility(8);
              break label324;
            }
          }
          this.o = a(this.F);
        }
      }
    }
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    if ((this.n == null) || (this.n.isEmpty()))
    {
      Log.e("mediagallery/dialog/delete no messages");
      return super.onCreateDialog(paramInt);
    }
    Log.i("mediagallery/dialog/delete/" + this.n.size());
    ArrayList localArrayList = new ArrayList(this.n.values());
    return d.a(this, this.aq, this.x, this.y, this.A, localArrayList, this.q, 13, false, new vq(this));
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    Object localObject;
    if (this.B.b())
    {
      localObject = new SearchView(this);
      ((TextView)((SearchView)localObject).findViewById(2131755212)).setTextColor(android.support.v4.content.b.c(this, 2131624099));
      ((SearchView)localObject).setQueryHint(getString(2131297635));
      ((SearchView)localObject).setOnQueryTextListener(new SearchView.b()
      {
        public final boolean a(String paramAnonymousString)
        {
          return false;
        }
        
        public final boolean b(String paramAnonymousString)
        {
          if (!TextUtils.equals(MediaGallery.g(MediaGallery.this), paramAnonymousString))
          {
            MediaGallery.a(MediaGallery.this, paramAnonymousString);
            MediaGallery.a(MediaGallery.this, be.c(paramAnonymousString));
            MediaGallery.a locala = MediaGallery.f(MediaGallery.this);
            if (locala != null) {
              locala.a(paramAnonymousString);
            }
          }
          return false;
        }
      });
      this.r = paramMenu.add(0, 2131755072, 0, 2131297631).setIcon(2130840074);
      o.a(this.r, (View)localObject);
      o.a(this.r, 10);
      o.a(this.r, new o.e()
      {
        public final boolean a(MenuItem paramAnonymousMenuItem)
        {
          ((AppBarLayout.a)MediaGallery.this.findViewById(2131755412).getLayoutParams()).a(0);
          return true;
        }
        
        public final boolean b(MenuItem paramAnonymousMenuItem)
        {
          MediaGallery.a(MediaGallery.this, null);
          ((AppBarLayout.a)MediaGallery.this.findViewById(2131755412).getLayoutParams()).a(21);
          return true;
        }
      });
      localObject = this.r;
      if (this.u == 0) {
        break label150;
      }
    }
    label150:
    for (boolean bool = true;; bool = false)
    {
      ((MenuItem)localObject).setVisible(bool);
      return super.onCreateOptionsMenu(paramMenu);
    }
  }
  
  public void onDestroy()
  {
    Log.i("mediagallery/destroy");
    super.onDestroy();
    bu.a(anf.a(this.aK));
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.n != null)
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.n.values().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(new FMessageKey(((j)localIterator.next()).e));
      }
      paramBundle.putParcelableArrayList("selected_messages", localArrayList);
    }
  }
  
  public final ArrayList<String> x()
  {
    return this.s;
  }
  
  public final String y()
  {
    return this.t;
  }
  
  public final int z()
  {
    return 0;
  }
  
  static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(String paramString);
  }
  
  static final class b
    extends android.support.v4.app.u
  {
    private final List<Fragment> a = new ArrayList();
    private final List<String> b = new ArrayList();
    
    b(r paramr)
    {
      super();
    }
    
    public final Fragment a(int paramInt)
    {
      return (Fragment)this.a.get(paramInt);
    }
    
    final void a(Fragment paramFragment, String paramString)
    {
      this.a.add(paramFragment);
      this.b.add(paramString);
    }
    
    public final int b()
    {
      return this.a.size();
    }
    
    public final CharSequence c(int paramInt)
    {
      return (CharSequence)this.b.get(paramInt);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/MediaGallery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */