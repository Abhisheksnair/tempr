package com.whatsapp;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.app.ag;
import android.support.v4.app.n;
import android.support.v4.view.ab;
import android.support.v4.view.o;
import android.support.v7.view.b.a;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.whatsapp.contact.sync.i;
import com.whatsapp.data.cs;
import com.whatsapp.data.cs.a;
import com.whatsapp.data.cs.b;
import com.whatsapp.data.cs.c;
import com.whatsapp.data.cs.d;
import com.whatsapp.data.e;
import com.whatsapp.k.d.e;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.az;
import com.whatsapp.util.be;
import com.whatsapp.util.bu;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class em
  extends ag
  implements aah, sg
{
  HashMap<String, cs> aa;
  Handler ab = new Handler(Looper.getMainLooper());
  boolean ac = true;
  final ani ad = ani.a();
  final aq ae = aq.a();
  final i af = i.a();
  final atu ag = atu.a();
  private final ArrayList<cs> ah = new ArrayList();
  private ArrayList<cs> ai = new ArrayList();
  private b aj;
  private CharSequence ak;
  private ArrayList<String> al;
  private android.support.v7.view.b am;
  private b.a an;
  private com.whatsapp.k.d ao;
  private boolean ap;
  private boolean aq = true;
  private final pv ar = pv.a();
  private final va as = va.a();
  private final e at = e.a();
  private final rh au = rh.a();
  private final di.e av = di.a().b();
  private final dh aw = dh.a();
  private final dh.a ax = new dh.a()
  {
    public final void a()
    {
      em.a(em.this);
    }
    
    protected final void a(String paramAnonymousString)
    {
      paramAnonymousString = new cs.b(em.b(em.this).d(paramAnonymousString));
      if (cs.a(em.c(em.this), paramAnonymousString)) {
        em.d(em.this).notifyDataSetChanged();
      }
    }
    
    public final void a(Collection<String> paramAnonymousCollection)
    {
      em.d(em.this).notifyDataSetChanged();
    }
    
    public final void b(String paramAnonymousString)
    {
      paramAnonymousString = new cs.c(em.b(em.this).d(paramAnonymousString));
      if (cs.a(em.c(em.this), paramAnonymousString)) {
        em.d(em.this).notifyDataSetChanged();
      }
    }
    
    public final void c(String paramAnonymousString)
    {
      paramAnonymousString = new cs.d(em.b(em.this).d(paramAnonymousString));
      if (cs.a(em.c(em.this), paramAnonymousString)) {
        em.d(em.this).notifyDataSetChanged();
      }
    }
  };
  a i;
  
  private boolean V()
  {
    if (this.am != null) {
      return false;
    }
    if (this.an == null) {
      this.an = new b.a()
      {
        public final void a(android.support.v7.view.b paramAnonymousb)
        {
          paramAnonymousb = em.this.b();
          int i = 0;
          while (i < paramAnonymousb.getCount())
          {
            View localView = paramAnonymousb.getChildAt(i);
            if (localView != null)
            {
              em.d locald = (em.d)localView.getTag();
              if ((locald != null) && (em.e(em.this).containsKey(locald.a)))
              {
                localView.setBackgroundResource(0);
                ((SelectionCheckView)localView.findViewById(2131755512)).a(false, true);
              }
            }
            i += 1;
          }
          em.f(em.this);
          em.g(em.this);
        }
        
        public final boolean a(android.support.v7.view.b paramAnonymousb, Menu paramAnonymousMenu)
        {
          o.a(paramAnonymousMenu.add(0, 2131755059, 0, 2131297273), 6);
          o.a(paramAnonymousMenu.add(0, 2131755063, 0, 2131297143), 6);
          return true;
        }
        
        public final boolean a(android.support.v7.view.b paramAnonymousb, MenuItem paramAnonymousMenuItem)
        {
          if (paramAnonymousMenuItem.getItemId() == 2131755059) {
            em.this.a(new Intent(em.this.l(), ListMembersSelector.class).putExtra("selected", new ArrayList(em.e(em.this).keySet())));
          }
          for (;;)
          {
            return false;
            if (paramAnonymousMenuItem.getItemId() == 2131755063) {
              NewGroup.a(em.this.l(), 4, em.e(em.this).keySet());
            }
          }
        }
        
        public final boolean b(android.support.v7.view.b paramAnonymousb, Menu paramAnonymousMenu)
        {
          return false;
        }
      };
    }
    this.am = ((android.support.v7.app.c)l()).a(this.an);
    return true;
  }
  
  private void W()
  {
    if (this.as.b == null)
    {
      pv.a(l(), 2131296797, 1);
      return;
    }
    ((android.support.v7.app.c)l()).b(true);
    bu.a(ep.a(this));
  }
  
  private void X()
  {
    View localView = x();
    if (localView == null) {}
    do
    {
      return;
      if (this.ah.isEmpty())
      {
        if (this.aj != null)
        {
          localView.findViewById(2131755509).setVisibility(8);
          localView.findViewById(2131755393).setVisibility(8);
          localView.findViewById(2131755510).setVisibility(0);
          localView.findViewById(2131755391).setVisibility(8);
          return;
        }
        if (this.ag.d())
        {
          localObject = (ViewGroup)localView.findViewById(2131755509);
          if (((ViewGroup)localObject).getChildCount() == 0)
          {
            al.a(this.ar, b(null), 2130903221, (ViewGroup)localObject, true);
            ((ViewGroup)localObject).findViewById(2131755770).setOnClickListener(new at()
            {
              public final void a(View paramAnonymousView)
              {
                pb.a(22, Integer.valueOf(7));
                em.h(em.this).a(em.this.l());
              }
            });
          }
          ((ViewGroup)localObject).setVisibility(0);
          localView.findViewById(2131755393).setVisibility(8);
          localView.findViewById(2131755510).setVisibility(8);
          localView.findViewById(2131755391).setVisibility(8);
          return;
        }
        localObject = (ViewGroup)localView.findViewById(2131755393);
        if (((ViewGroup)localObject).getChildCount() == 0)
        {
          al.a(this.ar, b(null), 2130903220, (ViewGroup)localObject, true);
          ((ViewGroup)localObject).findViewById(2131755769).setOnClickListener(new at()
          {
            public final void a(View paramAnonymousView)
            {
              a.a.a.a.d.d(em.this.l());
            }
          });
        }
        ((ViewGroup)localObject).setVisibility(0);
        localView.findViewById(2131755509).setVisibility(8);
        localView.findViewById(2131755510).setVisibility(8);
        localView.findViewById(2131755391).setVisibility(8);
        return;
      }
    } while (!this.ai.isEmpty());
    localView.findViewById(2131755509).setVisibility(8);
    localView.findViewById(2131755393).setVisibility(8);
    localView.findViewById(2131755510).setVisibility(8);
    Object localObject = (TextView)localView.findViewById(2131755391);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setText(localView.getContext().getString(2131297639, new Object[] { this.ak }));
  }
  
  private ArrayList<cs> b(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {}
    for (paramCharSequence = be.c(paramCharSequence.toString());; paramCharSequence = null)
    {
      ArrayList localArrayList2;
      synchronized (this.ah)
      {
        localArrayList2 = new ArrayList();
        if ((paramCharSequence != null) && (!paramCharSequence.isEmpty()))
        {
          Iterator localIterator = this.ah.iterator();
          cs localcs;
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localcs = (cs)localIterator.next();
          } while ((localcs.d == null) || (!localcs.a(paramCharSequence)));
          localArrayList2.add(localcs);
        }
      }
      localArrayList2.addAll(this.ah);
      return localArrayList2;
    }
  }
  
  public final void A()
  {
    super.A();
    this.ao.c();
    this.aw.unregisterObserver(this.ax);
    if (this.aj != null) {
      this.aj.cancel(true);
    }
    this.av.a();
  }
  
  final void R()
  {
    if (this.aj != null) {
      this.aj.cancel(true);
    }
    this.aj = new b((byte)0);
    bu.a(this.aj, new Void[0]);
  }
  
  final void S()
  {
    a(new Intent(l(), ContactPickerHelp.class));
  }
  
  public final void T()
  {
    this.ac = true;
  }
  
  public final void U()
  {
    this.ac = false;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    this.ao.a(d.e.c);
    paramLayoutInflater = HomeActivity.a(paramLayoutInflater.inflate(2130903122, paramViewGroup, false), this);
    this.ao.b(d.e.c);
    return paramLayoutInflater;
  }
  
  public final void a(Bundle paramBundle)
  {
    this.ao = com.whatsapp.k.c.a("ContactFragmentInit");
    this.ao.a();
    this.ao.a(d.e.b);
    super.a(paramBundle);
    this.ao.b(d.e.b);
  }
  
  public final void a(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    super.a(paramMenu, paramMenuInflater);
  }
  
  final void a(cs paramcs)
  {
    pb.a(22, Integer.valueOf(8));
    ani.a(l(), Uri.parse("smsto:" + paramcs.d.b), a(2131297981, new Object[] { "https://whatsapp.com/dl/" }));
  }
  
  final void a(cs paramcs, View paramView, SelectionCheckView paramSelectionCheckView)
  {
    if (!this.ac) {}
    for (;;)
    {
      return;
      if (this.aa == null) {
        this.aa = new HashMap();
      }
      if (this.aa.containsKey(paramcs.t))
      {
        this.aa.remove(paramcs.t);
        paramView.setBackgroundResource(0);
        paramSelectionCheckView.a(false, true);
      }
      while (this.am != null)
      {
        if (this.aa.size() != 0) {
          break label189;
        }
        this.am.c();
        return;
        if ((aic.r > 0) && (this.aa.size() >= aic.r))
        {
          ((ng)l()).d(String.format(a(2131296360), new Object[] { Integer.valueOf(aic.r) }));
        }
        else
        {
          if (this.aa.isEmpty()) {
            V();
          }
          this.aa.put(paramcs.t, paramcs);
          paramView.setBackgroundResource(2131624041);
          paramSelectionCheckView.a(true, true);
        }
      }
    }
    label189:
    this.am.b(NumberFormat.getInstance().format(this.aa.size()));
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.i.getFilter().filter(paramCharSequence);
  }
  
  public final void a(boolean paramBoolean) {}
  
  public final boolean a(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131755061)
    {
      k_();
      return true;
    }
    if (paramMenuItem.getItemId() == 2131755081)
    {
      pb.a(22, Integer.valueOf(3));
      this.ad.a(l());
      return true;
    }
    if (paramMenuItem.getItemId() == 2131755067)
    {
      W();
      return true;
    }
    if (paramMenuItem.getItemId() == 2131755036)
    {
      S();
      return true;
    }
    return super.a(paramMenuItem);
  }
  
  public final boolean b(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131755082)
    {
      paramMenuItem = (AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo();
      paramMenuItem = (cs)b().getItemAtPosition(paramMenuItem.position);
      this.ae.a(l(), false, paramMenuItem.t);
      return true;
    }
    return super.b(paramMenuItem);
  }
  
  public final void d(Bundle paramBundle)
  {
    this.ao.a(d.e.d);
    super.d(paramBundle);
    s();
    R();
    X();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getStringArrayList("selected_contact_jids");
      if ((paramBundle != null) && ((this.aa == null) || (this.aa.isEmpty())))
      {
        this.aa = new HashMap();
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext())
        {
          String str = (String)paramBundle.next();
          cs localcs = this.at.d(str);
          this.aa.put(str, localcs);
        }
        if (!this.aa.isEmpty()) {
          V();
        }
      }
    }
    this.i = new a(l(), this.ai);
    a(this.i);
    paramBundle = b();
    paramBundle.setDivider(new az(android.support.v4.content.b.a(k(), 2130837766)));
    paramBundle.setFastScrollEnabled(true);
    paramBundle.setScrollbarFadingEnabled(true);
    x().findViewById(2131755510).setVisibility(0);
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (this.ar.a)
      {
        paramBundle.setVerticalScrollbarPosition(1);
        paramBundle.setPadding(m().getDimensionPixelSize(2131361817), paramBundle.getPaddingTop(), m().getDimensionPixelSize(2131361816), paramBundle.getPaddingBottom());
      }
    }
    else
    {
      paramBundle.setTextFilterEnabled(true);
      if (Build.VERSION.SDK_INT < 11) {
        break label422;
      }
      paramBundle.setFastScrollAlwaysVisible(true);
      paramBundle.setScrollBarStyle(33554432);
    }
    for (;;)
    {
      a(paramBundle);
      paramBundle.setOnItemClickListener(en.a(this));
      paramBundle.setOnItemLongClickListener(eo.a(this));
      paramBundle.addFooterView(al.a(this.ar, l().getLayoutInflater(), 2130903126), null, true);
      paramBundle.addFooterView(al.a(this.ar, l().getLayoutInflater(), 2130903123), null, true);
      this.aw.registerObserver(this.ax);
      this.ao.b(d.e.d);
      return;
      paramBundle.setVerticalScrollbarPosition(2);
      paramBundle.setPadding(m().getDimensionPixelSize(2131361816), paramBundle.getPaddingTop(), m().getDimensionPixelSize(2131361817), paramBundle.getPaddingBottom());
      break;
      label422:
      paramBundle.setSelector(2130840501);
    }
  }
  
  public final void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    if (this.aa != null) {
      paramBundle.putStringArrayList("selected_contact_jids", new ArrayList(this.aa.keySet()));
    }
  }
  
  public final void k_()
  {
    Intent localIntent = new Intent("android.intent.action.INSERT");
    localIntent.setType("vnd.android.cursor.dir/contact");
    try
    {
      a(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      this.ar.b();
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    Object localObject = (AdapterView.AdapterContextMenuInfo)paramContextMenuInfo;
    localObject = (cs)((ListView)paramView).getItemAtPosition(((AdapterView.AdapterContextMenuInfo)localObject).position);
    if (!this.ae.a(((cs)localObject).t)) {
      return;
    }
    paramContextMenu.add(0, 2131755082, 0, String.format(a(2131296354), new Object[] { ((cs)localObject).a(this.i.getContext()) }));
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public final void y()
  {
    super.y();
    if ((!this.aq) && (this.ag.d())) {
      W();
    }
    X();
  }
  
  public final void z()
  {
    super.z();
    this.aq = this.ag.d();
    this.ao.c();
  }
  
  final class a
    extends ArrayAdapter<cs>
    implements SectionIndexer
  {
    protected final ArrayList<cs> a;
    private final LayoutInflater c;
    private final Filter d = new a((byte)0);
    private ArrayList<String> e = new ArrayList();
    private ArrayList<Integer> f = new ArrayList();
    
    public a(ArrayList<cs> paramArrayList)
    {
      super(2130903124, localList);
      this.a = localList;
      this.c = LayoutInflater.from(paramArrayList);
    }
    
    public final cs a(int paramInt)
    {
      return (cs)this.a.get(paramInt);
    }
    
    public final int getCount()
    {
      return this.a.size();
    }
    
    public final Filter getFilter()
    {
      return this.d;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt << 10;
    }
    
    public final int getPositionForSection(int paramInt)
    {
      if ((this.f == null) || (paramInt >= this.f.size()) || (paramInt < 0)) {
        return -1;
      }
      return ((Integer)this.f.get(paramInt)).intValue();
    }
    
    public final int getSectionForPosition(int paramInt)
    {
      if (paramInt < 0) {
        return 0;
      }
      if (paramInt >= this.a.size()) {
        return this.e.size() - 1;
      }
      int i = this.f.size() - 1;
      while (i >= 0)
      {
        if (((Integer)this.f.get(i)).intValue() <= paramInt) {
          return i;
        }
        i -= 1;
      }
      return 0;
    }
    
    public final Object[] getSections()
    {
      return this.e.toArray(new String[1]);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      boolean bool = true;
      final cs localcs = a(paramInt);
      Object localObject1;
      Object localObject2;
      if (paramView == null)
      {
        paramView = al.a(em.i(em.this), this.c, 2130903124, paramViewGroup, false);
        paramViewGroup = new em.d((byte)0);
        paramView.setTag(paramViewGroup);
        paramViewGroup.b = ((ImageView)paramView.findViewById(2131755511));
        paramViewGroup.c = ((TextEmojiLabel)paramView.findViewById(2131755517));
        paramViewGroup.d = ((TextEmojiLabel)paramView.findViewById(2131755519));
        paramViewGroup.e = ((TextView)paramView.findViewById(2131755518));
        paramViewGroup.f = paramView.findViewById(2131755395);
        paramViewGroup.g = ((SelectionCheckView)paramView.findViewById(2131755512));
        paramViewGroup.h = paramView.findViewById(2131755514);
        aoa.b(paramViewGroup.c);
        em.j(em.this).a(localcs, paramViewGroup.b);
        localObject1 = em.class.getName() + localcs.t;
        ab.a(paramViewGroup.b, (String)localObject1);
        localObject1 = new em.c(em.this, localcs, paramView, paramViewGroup.g);
        localObject2 = er.a(this, localcs, paramView, paramViewGroup);
        paramViewGroup.f.setOnClickListener((View.OnClickListener)localObject1);
        paramViewGroup.b.setOnClickListener((View.OnClickListener)localObject1);
        paramViewGroup.g.setOnClickListener((View.OnClickListener)localObject1);
        paramViewGroup.f.setOnLongClickListener((View.OnLongClickListener)localObject2);
        paramViewGroup.b.setOnLongClickListener((View.OnLongClickListener)localObject2);
        paramViewGroup.g.setOnLongClickListener((View.OnLongClickListener)localObject2);
        paramViewGroup.c.a(localcs, em.k(em.this));
        if (!localcs.d()) {
          break label440;
        }
        paramViewGroup.c.setTextColor(android.support.v4.content.b.c(getContext(), 2131624047));
        paramViewGroup.d.setText(em.l(em.this).g(localcs.t));
        paramViewGroup.e.setVisibility(8);
        paramViewGroup.h.setVisibility(8);
        paramView.setLongClickable(false);
        if ((em.e(em.this) == null) || (!em.e(em.this).containsKey(localcs.t))) {
          break label702;
        }
        label389:
        if (!bool) {
          break label708;
        }
      }
      label440:
      label580:
      label694:
      label702:
      label708:
      for (paramInt = 2131624041;; paramInt = 0)
      {
        paramView.setBackgroundResource(paramInt);
        paramViewGroup.g.a(bool, false);
        paramViewGroup.a = localcs.t;
        paramView.setTag(paramViewGroup);
        return paramView;
        paramViewGroup = (em.d)paramView.getTag();
        break;
        if (em.m(em.this).a(localcs.t))
        {
          paramViewGroup.c.setTextColor(-7829368);
          paramViewGroup.d.setText(2131297975);
          paramViewGroup.e.setVisibility(0);
          paramViewGroup.h.setVisibility(8);
          paramView.setLongClickable(true);
          localObject1 = localcs.a(em.this.m());
          localObject2 = paramViewGroup.e;
          if (localObject1 == null) {
            break label694;
          }
        }
        for (;;)
        {
          ((TextView)localObject2).setText((CharSequence)localObject1);
          break;
          paramViewGroup.c.setTextColor(android.support.v4.content.b.c(getContext(), 2131624047));
          if (localcs.h)
          {
            localObject2 = paramViewGroup.d;
            if (localcs.u != null)
            {
              localObject1 = localcs.u;
              ((TextEmojiLabel)localObject2).a((CharSequence)localObject1);
              paramViewGroup.e.setVisibility(0);
              paramViewGroup.h.setVisibility(8);
            }
          }
          for (;;)
          {
            paramView.setLongClickable(false);
            break;
            localObject1 = "";
            break label580;
            paramViewGroup.d.setText("‪" + cs.b(localcs.t) + "‬");
            paramViewGroup.e.setVisibility(8);
            paramViewGroup.h.setVisibility(0);
            paramViewGroup.h.setOnClickListener(new at()
            {
              public final void a(View paramAnonymousView)
              {
                em.a(em.this, localcs);
              }
            });
          }
          localObject1 = "";
        }
        bool = false;
        break label389;
      }
    }
    
    public final boolean hasStableIds()
    {
      return true;
    }
    
    public final void notifyDataSetChanged()
    {
      super.notifyDataSetChanged();
      this.e = new ArrayList();
      this.f = new ArrayList();
      int j = this.a.size();
      Object localObject1 = "";
      int i = 0;
      Object localObject2;
      if (i < j)
      {
        localObject2 = ((cs)this.a.get(i)).a(getContext());
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break label159;
        }
        String str = ((String)localObject2).substring(0, 1).toUpperCase();
        if (!Character.isDigit(str.charAt(0)))
        {
          localObject2 = str;
          if (str.charAt(0) != '+') {}
        }
        else
        {
          localObject2 = "#";
        }
        if (((String)localObject1).equals(localObject2)) {
          break label159;
        }
        this.e.add(localObject2);
        this.f.add(Integer.valueOf(i));
      }
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        return;
        label159:
        localObject2 = localObject1;
      }
    }
    
    final class a
      extends Filter
    {
      private a() {}
      
      protected final Filter.FilterResults performFiltering(CharSequence paramCharSequence)
      {
        Filter.FilterResults localFilterResults = new Filter.FilterResults();
        try
        {
          paramCharSequence = em.a(em.this, paramCharSequence);
          localFilterResults.values = paramCharSequence;
          localFilterResults.count = paramCharSequence.size();
          return localFilterResults;
        }
        catch (Exception paramCharSequence)
        {
          Log.d("contactsfragment", paramCharSequence);
        }
        return localFilterResults;
      }
      
      protected final void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
      {
        em localem;
        if (!em.c(em.this).isEmpty())
        {
          em.b(em.this, paramCharSequence);
          localem = em.this;
          if (paramCharSequence != null) {
            break label103;
          }
        }
        label103:
        for (paramCharSequence = null;; paramCharSequence = paramCharSequence.toString())
        {
          em.a(localem, be.c(paramCharSequence));
          em.n(em.this).clear();
          em.n(em.this).addAll((ArrayList)paramFilterResults.values);
          em.o(em.this);
          em.a.this.notifyDataSetChanged();
          return;
        }
      }
    }
  }
  
  final class b
    extends AsyncTask<Void, Void, ArrayList<cs>>
  {
    private b() {}
  }
  
  final class c
    implements View.OnClickListener
  {
    private long b;
    private cs c;
    private View d;
    private SelectionCheckView e;
    
    c(cs paramcs, View paramView, SelectionCheckView paramSelectionCheckView)
    {
      this.c = paramcs;
      this.d = paramView;
      this.e = paramSelectionCheckView;
    }
    
    public final void onClick(View paramView)
    {
      long l = SystemClock.elapsedRealtime();
      if ((this.c.h) && (!em.m(em.this).a(this.c.t)))
      {
        if ((em.t(em.this) == null) || (!em.p(em.this))) {
          break label74;
        }
        em.a(em.this, this.c, this.d, this.e);
      }
      label74:
      while (l - this.b <= 1000L) {
        return;
      }
      this.b = l;
      QuickContactActivity.a(em.this.l(), paramView, this.c.t, ab.s(this.d.findViewById(2131755511)));
    }
  }
  
  static final class d
  {
    String a;
    ImageView b;
    TextEmojiLabel c;
    TextEmojiLabel d;
    TextView e;
    View f;
    SelectionCheckView g;
    View h;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/em.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */