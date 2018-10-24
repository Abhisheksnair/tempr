package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ab;
import android.support.v4.view.o;
import android.support.v4.view.o.e;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.SearchView.b;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.whatsapp.data.cs;
import com.whatsapp.data.cs.b;
import com.whatsapp.data.cs.c;
import com.whatsapp.data.cs.d;
import com.whatsapp.data.e;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.az;
import com.whatsapp.util.be;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class aai
  extends nm
{
  private final b A = new b((byte)0);
  private InputMethodManager B;
  private ListView C;
  private View D;
  private View E;
  private boolean F;
  private RecyclerView G;
  private final dh H = dh.a();
  private final dh.a I = new dh.a()
  {
    public final void a()
    {
      aai.a(aai.this);
      aai.b(aai.this).notifyDataSetChanged();
    }
    
    protected final void a(String paramAnonymousString)
    {
      if (!qz.e(paramAnonymousString))
      {
        paramAnonymousString = new cs.b(aai.this.p.d(paramAnonymousString));
        if (cs.a(aai.c(aai.this), paramAnonymousString)) {
          aai.b(aai.this).notifyDataSetChanged();
        }
      }
    }
    
    public final void a(Collection<String> paramAnonymousCollection)
    {
      aai.b(aai.this).notifyDataSetChanged();
    }
    
    public final void b(String paramAnonymousString)
    {
      if (!qz.e(paramAnonymousString))
      {
        paramAnonymousString = new cs.c(aai.this.p.d(paramAnonymousString));
        if (cs.a(aai.c(aai.this), paramAnonymousString)) {
          aai.b(aai.this).notifyDataSetChanged();
        }
      }
    }
    
    public final void c(String paramAnonymousString)
    {
      paramAnonymousString = new cs.d(aai.this.p.d(paramAnonymousString));
      if (cs.a(aai.c(aai.this), paramAnonymousString)) {
        aai.b(aai.this).notifyDataSetChanged();
      }
    }
  };
  protected final va n = va.a();
  protected final aoj o = aoj.a();
  protected final e p = e.a();
  protected final aq q = aq.a();
  protected final di.e r = di.a().b();
  private a t;
  private final ArrayList<cs> u = new ArrayList();
  private final ArrayList<cs> v = new ArrayList();
  private ArrayList<String> w;
  private String x;
  private ahp y;
  private final List<cs> z = new ArrayList();
  
  static
  {
    if (!aai.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      s = bool;
      return;
    }
  }
  
  private void b(cs paramcs)
  {
    if (this.q.a(paramcs.t)) {
      return;
    }
    Object localObject1 = (SelectionCheckView)this.C.findViewWithTag(paramcs);
    label39:
    label79:
    label161:
    int i;
    label184:
    Object localObject2;
    if (paramcs.i)
    {
      paramcs.i = false;
      if (!paramcs.i) {
        break label352;
      }
      if (this.z.add(paramcs))
      {
        if (this.z.size() != 1) {
          break label331;
        }
        this.A.c();
      }
      if (localObject1 != null) {
        ((SelectionCheckView)localObject1).a(paramcs.i, false);
      }
      if (!this.z.isEmpty()) {
        break label387;
      }
      this.D.setVisibility(8);
      v();
      if (!this.F)
      {
        localObject1 = new TranslateAnimation(0.0F, 0.0F, getResources().getDimensionPixelSize(2131362081), 0.0F);
        ((TranslateAnimation)localObject1).setDuration(240L);
        this.C.startAnimation((Animation)localObject1);
      }
      d(this.z.size());
      localObject1 = this.u.iterator();
      i = 0;
      if (!((Iterator)localObject1).hasNext()) {
        break label506;
      }
      localObject2 = (cs)((Iterator)localObject1).next();
      if ((localObject2 == paramcs) || (!paramcs.t.equals(((cs)localObject2).t))) {
        break label518;
      }
      ((cs)localObject2).i = paramcs.i;
      i = 1;
    }
    label331:
    label352:
    label387:
    label506:
    label518:
    for (;;)
    {
      break label184;
      if (this.z.size() == m())
      {
        d(getString(o(), new Object[] { Integer.valueOf(m()) }));
        if (localObject1 == null) {
          break;
        }
        ((SelectionCheckView)localObject1).a(false, false);
        return;
      }
      localObject2 = (EditText)findViewById(2131755496).findViewById(2131755212);
      if (localObject2 != null) {
        ((EditText)localObject2).setText("");
      }
      paramcs.i = true;
      break label39;
      this.A.c(this.z.size() - 1);
      break label79;
      i = this.z.indexOf(paramcs);
      if (!this.z.remove(paramcs)) {
        break label79;
      }
      this.A.d(i);
      break label79;
      if (this.D.getVisibility() != 0)
      {
        if (this.E.getVisibility() != 0)
        {
          i = getResources().getDimensionPixelSize(2131362081);
          this.D.setVisibility(0);
          localObject1 = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
          ((TranslateAnimation)localObject1).setDuration(240L);
          this.C.startAnimation((Animation)localObject1);
          break label161;
        }
        this.E.setVisibility(8);
        this.D.setVisibility(0);
        break label161;
      }
      if (!paramcs.i) {
        break label161;
      }
      this.G.a(this.z.size() - 1);
      break label161;
      if (i == 0) {
        break;
      }
      this.t.notifyDataSetChanged();
      return;
    }
  }
  
  private static boolean c(cs paramcs)
  {
    return "no-matches".equals(paramcs.t);
  }
  
  private void v()
  {
    if ((this.D.getVisibility() != 0) && (this.F))
    {
      this.E.setVisibility(0);
      return;
    }
    this.E.setVisibility(8);
  }
  
  private void w()
  {
    cs localcs1;
    synchronized (this.u)
    {
      localObject2 = new ArrayList();
      Iterator localIterator1 = this.u.iterator();
      while (localIterator1.hasNext())
      {
        localcs1 = (cs)localIterator1.next();
        if ((localcs1 != null) && (localcs1.i)) {
          ((ArrayList)localObject2).add(localcs1);
        }
      }
    }
    this.u.clear();
    this.p.d(this.u);
    ch localch = new ch(getApplicationContext());
    Object localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localcs1 = (cs)((Iterator)localObject2).next();
      Iterator localIterator2 = this.u.iterator();
      while (localIterator2.hasNext())
      {
        cs localcs2 = (cs)localIterator2.next();
        if ((localcs1 != null) && (localcs2 != null) && (localch.a(localcs1, localcs2) == 0)) {
          localcs2.i = true;
        }
      }
    }
    Collections.sort(this.u, new ch(getApplicationContext()));
    x();
  }
  
  private void x()
  {
    this.v.clear();
    Iterator localIterator = this.u.iterator();
    while (localIterator.hasNext())
    {
      cs localcs = (cs)localIterator.next();
      this.v.add(localcs);
    }
    if (this.t != null) {
      this.t.notifyDataSetChanged();
    }
  }
  
  protected void d(int paramInt)
  {
    android.support.v7.app.a locala = i();
    if ((!s) && (locala == null)) {
      throw new AssertionError();
    }
    if (m() > 0)
    {
      locala.b(String.format(u.a.a(2131230772, paramInt), new Object[] { Integer.valueOf(paramInt), Integer.valueOf(m()) }));
      return;
    }
    locala.b(String.format(u.a.a(2131230771, paramInt), new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent) {}
    return false;
  }
  
  protected abstract int l();
  
  protected abstract int m();
  
  protected abstract int n();
  
  protected abstract int o();
  
  public void onBackPressed()
  {
    if (this.y.c())
    {
      this.y.b();
      x();
      return;
    }
    finish();
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    Object localObject = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
    localObject = (cs)W().getItemAtPosition(((AdapterView.AdapterContextMenuInfo)localObject).position);
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onContextItemSelected(paramMenuItem);
    }
    this.q.a(this, false, ((cs)localObject).t);
    return true;
  }
  
  @SuppressLint({"InflateParams"})
  public void onCreate(Bundle paramBundle)
  {
    Log.i("multiplecontactpicker/create");
    super.onCreate(paramBundle);
    setContentView(getLayoutInflater().inflate(2130903304, null, false));
    paramBundle = (Toolbar)findViewById(2131755412);
    a(paramBundle);
    Object localObject = (android.support.v7.app.a)a.d.a(i());
    ((android.support.v7.app.a)localObject).a(true);
    ((android.support.v7.app.a)localObject).c();
    this.y = new ahp(this, this.aq, findViewById(2131755496), paramBundle, new SearchView.b()
    {
      public final boolean a(String paramAnonymousString)
      {
        return false;
      }
      
      public final boolean b(String paramAnonymousString)
      {
        aai.a(aai.this, paramAnonymousString);
        aai.a(aai.this, be.c(paramAnonymousString));
        if (aai.d(aai.this).isEmpty())
        {
          aai.a(aai.this, null);
          aai.e(aai.this);
        }
        for (;;)
        {
          return false;
          aai.b(aai.this, aai.d(aai.this));
        }
      }
    });
    setTitle(l());
    this.C = W();
    this.C.setDivider(new az(getResources().getDrawable(2130837766)));
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.C.setFastScrollAlwaysVisible(true);
      this.C.setScrollBarStyle(33554432);
    }
    this.B = ((InputMethodManager)getSystemService("input_method"));
    w();
    this.z.clear();
    paramBundle = getIntent().getStringArrayListExtra("selected");
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      localObject = this.u.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cs localcs = (cs)((Iterator)localObject).next();
        if (paramBundle.contains(localcs.t))
        {
          localcs.i = true;
          this.z.add(localcs);
        }
      }
    }
    this.G = ((RecyclerView)findViewById(2131755964));
    final int i = getResources().getDimensionPixelSize(2131362083);
    if ((!s) && (this.G == null)) {
      throw new AssertionError();
    }
    this.G.a(new RecyclerView.f()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView)
      {
        paramAnonymousRect.set(0, i, 0, i);
      }
    });
    paramBundle = new LinearLayoutManager(this);
    paramBundle.b(0);
    this.G.setLayoutManager(paramBundle);
    this.G.setAdapter(this.A);
    this.G.setItemAnimator(new ahs());
    this.C.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      int a = 0;
      
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        if ((this.a == 0) && (paramAnonymousInt != this.a)) {
          aai.f(aai.this).hideSoftInputFromWindow(paramAnonymousAbsListView.getWindowToken(), 0);
        }
        this.a = paramAnonymousInt;
      }
    });
    if (this.aP.d())
    {
      paramBundle = findViewById(2131755509);
      if ((!s) && (paramBundle == null)) {
        throw new AssertionError();
      }
      paramBundle.setVisibility(0);
      this.C.setEmptyView(paramBundle);
      this.C.setFastScrollEnabled(true);
      this.C.setScrollbarFadingEnabled(true);
      if (Build.VERSION.SDK_INT < 11) {
        break label659;
      }
      if (!this.aq.a) {
        break label619;
      }
      this.C.setVerticalScrollbarPosition(1);
      this.C.setPadding(getResources().getDimensionPixelSize(2131361817), 0, getResources().getDimensionPixelSize(2131361816), 0);
    }
    for (;;)
    {
      this.C.setOnItemClickListener(aaj.a(this));
      d(this.z.size());
      this.D = findViewById(2131755831);
      if ((s) || (this.D != null)) {
        break label672;
      }
      throw new AssertionError();
      paramBundle = findViewById(2131755393);
      if ((!s) && (paramBundle == null)) {
        throw new AssertionError();
      }
      paramBundle.setVisibility(0);
      this.C.setEmptyView(paramBundle);
      break;
      label619:
      this.C.setVerticalScrollbarPosition(2);
      this.C.setPadding(getResources().getDimensionPixelSize(2131361816), 0, getResources().getDimensionPixelSize(2131361817), 0);
      continue;
      label659:
      this.C.setSelector(2130840501);
    }
    label672:
    if (this.z.isEmpty()) {
      this.D.setVisibility(8);
    }
    this.E = findViewById(2131755962);
    if ((!s) && (this.E == null)) {
      throw new AssertionError();
    }
    paramBundle = (TextView)findViewById(2131755963);
    if ((!s) && (paramBundle == null)) {
      throw new AssertionError();
    }
    paramBundle.setText(s());
    if (!TextUtils.isEmpty(paramBundle.getText())) {}
    for (boolean bool = true;; bool = false)
    {
      this.F = bool;
      v();
      this.t = new a(this, this.v);
      a(this.t);
      paramBundle = (ImageView)a.d.a(findViewById(2131755357));
      paramBundle.setImageDrawable(getResources().getDrawable(q()));
      paramBundle.setContentDescription(getResources().getString(p()));
      paramBundle.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          if (aai.g(aai.this).size() < aai.this.n())
          {
            pv.a(aai.this.getBaseContext(), String.format(u.a.a(2131230770, aai.this.n()), new Object[] { Integer.valueOf(aai.this.n()) }), 0);
            return;
          }
          aai.this.r();
        }
      });
      paramBundle = findViewById(2131755770);
      if ((s) || (paramBundle != null)) {
        break;
      }
      throw new AssertionError();
    }
    paramBundle.setOnClickListener(aak.a(this));
    paramBundle = findViewById(2131755769);
    if ((!s) && (paramBundle == null)) {
      throw new AssertionError();
    }
    paramBundle.setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        d.d(aai.this);
      }
    });
    registerForContextMenu(this.C);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    Object localObject = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    localObject = (cs)W().getItemAtPosition(((AdapterView.AdapterContextMenuInfo)localObject).position);
    if (localObject == null) {}
    while ((c((cs)localObject)) || (!this.q.a(((cs)localObject).t))) {
      return;
    }
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 0, 0, String.format(getString(2131296354), new Object[] { ((cs)localObject).a(this.t.getContext()) }));
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool = false;
    MenuItem localMenuItem = paramMenu.add(0, 2131755072, 0, 2131297631).setIcon(2130840073);
    o.a(localMenuItem, 10);
    o.a(localMenuItem, new o.e()
    {
      public final boolean a(MenuItem paramAnonymousMenuItem)
      {
        return true;
      }
      
      public final boolean b(MenuItem paramAnonymousMenuItem)
      {
        aai.a(aai.this, null);
        aai.e(aai.this);
        return true;
      }
    });
    if (!this.u.isEmpty()) {
      bool = true;
    }
    localMenuItem.setVisible(bool);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onDestroy()
  {
    Log.i("multiplecontactpicker/destroy");
    super.onDestroy();
    this.u.clear();
    this.v.clear();
    this.r.a();
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
    }
    finish();
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
    this.H.unregisterObserver(this.I);
  }
  
  public void onResume()
  {
    super.onResume();
    this.H.registerObserver(this.I);
    this.t.notifyDataSetChanged();
  }
  
  public boolean onSearchRequested()
  {
    this.y.a();
    return false;
  }
  
  protected abstract int p();
  
  protected abstract int q();
  
  protected abstract void r();
  
  protected String s()
  {
    return "";
  }
  
  protected final ArrayList<String> t()
  {
    ArrayList localArrayList = new ArrayList(this.z.size());
    Iterator localIterator = this.z.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((cs)localIterator.next()).t);
    }
    return localArrayList;
  }
  
  final class a
    extends ArrayAdapter<cs>
  {
    public a(int paramInt)
    {
      super(2130903305, localList);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      cs localcs = (cs)a.d.a(getItem(paramInt));
      if (aai.a(localcs))
      {
        paramView = al.a(aai.this.aq, aai.this.getLayoutInflater(), 2130903306, paramViewGroup, false);
        ((TextView)paramView.findViewById(2131755969)).setText(localcs.a(getContext()));
        paramView.setTag(Integer.valueOf(2));
        return paramView;
      }
      View localView;
      if (paramView != null)
      {
        localView = paramView;
        if (((Integer)paramView.getTag()).intValue() == 1) {}
      }
      else
      {
        localView = al.a(aai.this.aq, aai.this.getLayoutInflater(), 2130903305, paramViewGroup, false);
      }
      localView.setTag(Integer.valueOf(1));
      aai.this.r.a(localcs, (ImageView)localView.findViewById(2131755363));
      paramViewGroup = (TextEmojiLabel)localView.findViewById(2131755966);
      aoa.b(paramViewGroup);
      paramViewGroup.a(localcs, aai.d(aai.this));
      ab.c(paramViewGroup, 2);
      TextEmojiLabel localTextEmojiLabel = (TextEmojiLabel)localView.findViewById(2131755967);
      if (localcs.u != null) {}
      SelectionCheckView localSelectionCheckView;
      for (paramView = localcs.u + "  ";; paramView = "  ")
      {
        localTextEmojiLabel.setText(paramView);
        localSelectionCheckView = (SelectionCheckView)localView.findViewById(2131755512);
        if (!aai.this.q.a(localcs.t)) {
          break;
        }
        localTextEmojiLabel.setText(2131297975);
        paramViewGroup.setTextColor(-7829368);
        localView.setLongClickable(true);
        localSelectionCheckView.a(false, false);
        localSelectionCheckView.setTag(localcs);
        return localView;
      }
      if (localcs.u != null) {}
      for (paramView = localcs.u + "  ";; paramView = "  ")
      {
        localTextEmojiLabel.a(paramView);
        paramViewGroup.setTextColor(-16777216);
        localView.setLongClickable(false);
        localSelectionCheckView.a(localcs.i, false);
        break;
      }
    }
  }
  
  final class b
    extends RecyclerView.a<ahr>
  {
    private b() {}
    
    public final int a()
    {
      return aai.g(aai.this).size();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */