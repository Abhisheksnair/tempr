package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.ab;
import android.support.v4.view.o;
import android.support.v7.app.b.a;
import android.text.format.DateUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.whatsapp.data.ad;
import com.whatsapp.data.ad.b;
import com.whatsapp.data.an;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.data.l;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.bu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CallLogActivity
  extends nh
{
  private final l A = l.a();
  private final dh.a B = new dh.a()
  {
    public final void a()
    {
      CallLogActivity.a(CallLogActivity.this);
    }
    
    protected final void a(String paramAnonymousString)
    {
      if (paramAnonymousString.equals(CallLogActivity.this.getIntent().getStringExtra("jid"))) {
        CallLogActivity.a(CallLogActivity.this);
      }
    }
    
    public final void b(String paramAnonymousString)
    {
      if (paramAnonymousString.equals(CallLogActivity.this.getIntent().getStringExtra("jid"))) {
        CallLogActivity.a(CallLogActivity.this);
      }
    }
    
    public final void c(String paramAnonymousString)
    {
      if (paramAnonymousString.equals(CallLogActivity.this.getIntent().getStringExtra("jid"))) {
        CallLogActivity.a(CallLogActivity.this);
      }
    }
    
    public final void d(String paramAnonymousString)
    {
      if (paramAnonymousString.equals(CallLogActivity.this.getIntent().getStringExtra("jid"))) {
        ((TextView)CallLogActivity.this.findViewById(2131755461)).setText(CallLogActivity.c(CallLogActivity.this).b(CallLogActivity.b(CallLogActivity.this)));
      }
    }
  };
  private ListView n;
  private View o;
  private ImageView p;
  private cs q;
  private b r;
  private ArrayList<j> s;
  private boolean t;
  private final ant u = ant.a();
  private final ad v = ad.a();
  private final e w = e.a();
  private final el x = el.a();
  private final aq y = aq.a();
  private final dh z = dh.a();
  
  public static int a(j paramj)
  {
    if (paramj.e.b) {
      return 2130837727;
    }
    if (paramj.w > 0) {
      return 2130837725;
    }
    return 2130837726;
  }
  
  public static String a(long paramLong, Context paramContext)
  {
    double d = paramLong;
    int i = 0;
    while ((i < 3) && (d > 1024.0D))
    {
      d /= 1024.0D;
      i += 1;
    }
    switch (i)
    {
    default: 
      i = 2131297246;
    }
    for (;;)
    {
      return String.format(paramContext.getString(i), new Object[] { Double.valueOf(d) });
      return String.format(u.a.a(2131230775, (int)paramLong), new Object[] { Long.valueOf(paramLong) });
      i = 2131297248;
      continue;
      i = 2131297249;
    }
  }
  
  public static int b(j paramj)
  {
    if (paramj.e.b)
    {
      if (Voip.b(paramj)) {
        return 2131298118;
      }
      return 2131297338;
    }
    if (paramj.w > 0)
    {
      if (Voip.b(paramj)) {
        return 2131298113;
      }
      return 2131297039;
    }
    if (Voip.b(paramj)) {
      return 2131298114;
    }
    return 2131297187;
  }
  
  private void l()
  {
    View localView = this.n.getChildAt(0);
    if (localView != null)
    {
      if (this.n.getWidth() <= this.n.getHeight()) {
        break label76;
      }
      if (this.n.getFirstVisiblePosition() != 0) {
        break label62;
      }
      i = localView.getTop();
      this.o.offsetTopAndBottom(i - this.o.getTop());
    }
    label62:
    label76:
    while (this.o.getTop() == 0) {
      for (;;)
      {
        return;
        int i = -this.o.getHeight() + 1;
      }
    }
    this.o.offsetTopAndBottom(-this.o.getTop());
  }
  
  private void m()
  {
    Log.i("calllog/update");
    this.q = this.w.a(getIntent().getStringExtra("jid"));
    this.p.setImageBitmap(cs.b(this.q.e()));
    ((TextEmojiLabel)findViewById(2131755460)).setContact(this.q);
    ((TextView)findViewById(2131755461)).setText(this.x.b(this.q));
    if (this.r != null) {
      this.r.cancel(true);
    }
    this.r = new b((byte)0);
    bu.a(this.r, new Void[0]);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Log.i("calllog/create");
    super.onCreate(paramBundle);
    ((android.support.v7.app.a)a.d.a(i())).a(true);
    setContentView(2130903107);
    this.n = ((ListView)findViewById(16908298));
    paramBundle = al.a(this.aq, getLayoutInflater(), 2130903108, this.n, false);
    this.n.addHeaderView(paramBundle, null, false);
    this.o = findViewById(2131755386);
    this.o.setClickable(true);
    this.n.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        CallLogActivity.d(CallLogActivity.this);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.n.getViewTreeObserver().addOnGlobalLayoutListener(ax.a(this));
    this.p = ((ImageView)findViewById(2131755458));
    paramBundle = getString(2131298269) + "-avatar";
    ab.a(this.p, paramBundle);
    this.p.setOnClickListener(new QuickContactActivity.a(this, getIntent().getStringExtra("jid"), paramBundle));
    paramBundle = (ImageButton)a.d.a(findViewById(2131755396));
    paramBundle.setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        if (CallLogActivity.this.aB.a(CallLogActivity.b(CallLogActivity.this), CallLogActivity.this, Integer.valueOf(4), false, CallLogActivity.e(CallLogActivity.this))) {
          CallLogActivity.this.finish();
        }
      }
    });
    if (aic.h()) {
      a.d.b(paramBundle.getDrawable(), getResources().getColor(2131623985));
    }
    Object localObject1 = new a((byte)0);
    this.n.setAdapter((ListAdapter)localObject1);
    Object localObject2 = getIntent().getParcelableArrayListExtra("calls");
    long l;
    if (localObject2 != null)
    {
      this.s = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (FMessageKey)((Iterator)localObject2).next();
        localObject3 = this.A.a(((FMessageKey)localObject3).a);
        if (localObject3 != null) {
          this.s.add(localObject3);
        }
      }
      ((a)localObject1).a = this.s;
      ((a)localObject1).notifyDataSetChanged();
      if (this.s.isEmpty()) {
        break label540;
      }
      localObject1 = (j)this.s.get(0);
      l = this.u.a((j)localObject1);
      localObject2 = (TextView)findViewById(2131755463);
      if (!DateUtils.isToday(l)) {
        break label503;
      }
      ((TextView)localObject2).setText(2131297987);
      if (Voip.b((j)localObject1))
      {
        paramBundle.setImageResource(2130840085);
        paramBundle.setContentDescription(getString(2131298106));
        if (aic.h()) {
          a.d.b(paramBundle.getDrawable(), getResources().getColor(2131624128));
        }
        this.t = true;
      }
    }
    for (;;)
    {
      m();
      this.z.registerObserver(this.B);
      return;
      label503:
      if (DateUtils.isToday(86400000L + l))
      {
        ((TextView)localObject2).setText(2131298214);
        break;
      }
      ((TextView)localObject2).setText(DateUtils.formatDateTime(this, l, 16));
      break;
      label540:
      finish();
    }
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    DialogInterface.OnClickListener localOnClickListener = ay.a(this);
    return new b.a(this).b(getString(2131296351, new Object[] { this.q.a(this) })).a(2131297331, localOnClickListener).b(2131296398, null).a();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    o.a(paramMenu.add(0, 2131755062, 0, 2131297147).setIcon(2130840065).setAlphabeticShortcut('n'), 2);
    paramMenu.add(0, 2131755034, 0, 2131296438).setIcon(2130840058);
    paramMenu.add(0, 2131755082, 0, 2131298057);
    paramMenu.add(0, 2131755031, 0, 2131296350);
    return true;
  }
  
  public void onDestroy()
  {
    Log.i("calllog/destroy");
    super.onDestroy();
    this.z.unregisterObserver(this.B);
    if (this.r != null) {
      this.r.cancel(true);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332) {
      finish();
    }
    do
    {
      return true;
      if (paramMenuItem.getItemId() != 2131755034) {
        break;
      }
      Log.i("calllog/delete");
    } while (this.s == null);
    paramMenuItem = this.v;
    ArrayList localArrayList = this.s;
    Log.i("msgstore/deletecalllogs " + localArrayList.size());
    paramMenuItem.d.post(an.a(paramMenuItem, localArrayList));
    finish();
    return true;
    if (paramMenuItem.getItemId() == 2131755062)
    {
      Log.i("calllog/new_conversation");
      startActivity(Conversation.a(this.q));
      finish();
      return true;
    }
    if (paramMenuItem.getItemId() == 2131755082)
    {
      this.y.a(this, false, this.q.t);
      return true;
    }
    if (paramMenuItem.getItemId() == 2131755031)
    {
      d.a(this, 0);
      return true;
    }
    return false;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    boolean bool = this.y.a(this.q.t);
    MenuItem localMenuItem = paramMenu.findItem(2131755082);
    if (localMenuItem != null) {
      localMenuItem.setVisible(bool);
    }
    paramMenu = paramMenu.findItem(2131755031);
    if (paramMenu != null) {
      if (bool) {
        break label67;
      }
    }
    label67:
    for (bool = true;; bool = false)
    {
      paramMenu.setVisible(bool);
      return true;
    }
  }
  
  final class a
    extends BaseAdapter
  {
    List<j> a = new ArrayList();
    
    private a() {}
    
    private j a(int paramInt)
    {
      return (j)this.a.get(paramInt);
    }
    
    public final int getCount()
    {
      if (this.a == null) {
        return 0;
      }
      return this.a.size();
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = al.a(CallLogActivity.this.aq, CallLogActivity.this.getLayoutInflater(), 2130903094, paramViewGroup, false);
        paramViewGroup = new CallLogActivity.c(CallLogActivity.this, paramView);
        paramView.setTag(paramViewGroup);
        if (paramInt != getCount() - 1) {
          break label213;
        }
        paramView.setBackgroundResource(2130840429);
        paramViewGroup.f.setVisibility(8);
      }
      j localj;
      for (;;)
      {
        localj = a(paramInt);
        paramViewGroup.a.setImageResource(CallLogActivity.a(localj));
        paramViewGroup.b.setText(CallLogActivity.b(localj));
        paramViewGroup.c.setText(DateUtils.formatDateTime(paramViewGroup.g.getBaseContext(), CallLogActivity.g(paramViewGroup.g).a(localj), 1));
        if (localj.w <= 0) {
          break label241;
        }
        paramViewGroup.d.setText(DateUtils.formatElapsedTime(localj.w));
        paramViewGroup.d.setVisibility(0);
        long l = Voip.c(localj);
        if (l <= 0L) {
          break label230;
        }
        paramViewGroup.e.setText(CallLogActivity.a(l, paramViewGroup.g));
        paramViewGroup.e.setVisibility(0);
        return paramView;
        paramViewGroup = (CallLogActivity.c)paramView.getTag();
        break;
        label213:
        paramView.setBackgroundResource(2130840431);
        paramViewGroup.f.setVisibility(0);
      }
      label230:
      paramViewGroup.e.setVisibility(8);
      return paramView;
      label241:
      if (localj.e.b)
      {
        paramViewGroup.d.setText(2131296371);
        paramViewGroup.d.setVisibility(0);
      }
      for (;;)
      {
        paramViewGroup.e.setVisibility(8);
        return paramView;
        paramViewGroup.d.setVisibility(8);
      }
    }
    
    public final int getViewTypeCount()
    {
      return 1;
    }
  }
  
  final class b
    extends AsyncTask<Void, Void, Void>
  {
    private b() {}
  }
  
  final class c
  {
    final ImageView a;
    final TextView b;
    final TextView c;
    final TextView d;
    final TextView e;
    final View f;
    
    c(View paramView)
    {
      this.a = ((ImageView)paramView.findViewById(2131755380));
      this.b = ((TextView)paramView.findViewById(2131755381));
      this.c = ((TextView)paramView.findViewById(2131755383));
      this.d = ((TextView)paramView.findViewById(2131755382));
      this.e = ((TextView)paramView.findViewById(2131755384));
      this.f = paramView.findViewById(2131755385);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/CallLogActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */