package com.whatsapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.support.v4.view.o;
import android.support.v7.app.b.a;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.whatsapp.contact.sync.i;
import com.whatsapp.data.ac;
import com.whatsapp.data.ad;
import com.whatsapp.data.cs;
import com.whatsapp.data.cs.b;
import com.whatsapp.data.cs.c;
import com.whatsapp.data.cs.d;
import com.whatsapp.data.e;
import com.whatsapp.k.d.e;
import com.whatsapp.messaging.aj;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.m;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.az;
import com.whatsapp.util.bu;
import com.whatsapp.util.l;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListChatInfo
  extends bt
{
  private ListView A;
  private View B;
  private TextView C;
  private TextView D;
  private c E;
  private com.whatsapp.k.d F;
  private final va G = va.a();
  private final aoj H = aoj.a();
  private final rh I = rh.a();
  private final di.e J = di.a().b();
  private final dh K = dh.a();
  private final dh.a L = new dh.a()
  {
    public final void a()
    {
      Log.d("list_chat_info/onContactsChanged");
      ListChatInfo.a(ListChatInfo.this).clear();
      Iterator localIterator = ListChatInfo.c(ListChatInfo.this).a(ListChatInfo.b(ListChatInfo.this).t).a().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = ListChatInfo.d(ListChatInfo.this).d((String)localObject);
        if (!ListChatInfo.a(ListChatInfo.this).contains(localObject)) {
          ListChatInfo.a(ListChatInfo.this).add(localObject);
        }
      }
      ListChatInfo.e(ListChatInfo.this);
      ListChatInfo.f(ListChatInfo.this);
    }
    
    protected final void a(String paramAnonymousString)
    {
      Log.d("list_chat_info/onDisplayNameChanged");
      if (!qz.e(paramAnonymousString))
      {
        paramAnonymousString = new cs.b(ListChatInfo.d(ListChatInfo.this).d(paramAnonymousString));
        cs.a(ListChatInfo.a(ListChatInfo.this), paramAnonymousString);
        ListChatInfo.g(ListChatInfo.this).notifyDataSetChanged();
      }
    }
    
    public final void b(String paramAnonymousString)
    {
      Log.d("list_chat_info/onProfilePhotoChanged");
      if (!qz.e(paramAnonymousString))
      {
        paramAnonymousString = new cs.c(ListChatInfo.d(ListChatInfo.this).d(paramAnonymousString));
        cs.a(ListChatInfo.a(ListChatInfo.this), paramAnonymousString);
        ListChatInfo.g(ListChatInfo.this).notifyDataSetChanged();
      }
    }
    
    public final void c(String paramAnonymousString)
    {
      Log.d("list_chat_info/onStatusChanged:" + paramAnonymousString);
      if (!paramAnonymousString.equals(ListChatInfo.h(ListChatInfo.this).b() + "@s.whatsapp.net"))
      {
        paramAnonymousString = new cs.d(ListChatInfo.d(ListChatInfo.this).d(paramAnonymousString));
        cs.a(ListChatInfo.a(ListChatInfo.this), paramAnonymousString);
        ListChatInfo.g(ListChatInfo.this).notifyDataSetChanged();
      }
    }
  };
  private final ac M = ac.a();
  private final com.whatsapp.data.ab N = new com.whatsapp.data.ab()
  {
    public final void a(Collection<j> paramAnonymousCollection, String paramAnonymousString, Map<String, Integer> paramAnonymousMap, boolean paramAnonymousBoolean)
    {
      if ((paramAnonymousCollection != null) && (!paramAnonymousCollection.isEmpty()))
      {
        paramAnonymousCollection = paramAnonymousCollection.iterator();
        while (paramAnonymousCollection.hasNext()) {
          if (((j)paramAnonymousCollection.next()).e.a.equals(ListChatInfo.b(ListChatInfo.this).t)) {
            ListChatInfo.i(ListChatInfo.this);
          }
        }
      }
      while ((paramAnonymousString != null) && (!ListChatInfo.b(ListChatInfo.this).t.equals(paramAnonymousString))) {
        return;
      }
      ListChatInfo.i(ListChatInfo.this);
    }
    
    public final void a(Collection<j> paramAnonymousCollection, Map<String, Integer> paramAnonymousMap)
    {
      paramAnonymousCollection = paramAnonymousCollection.iterator();
      while (paramAnonymousCollection.hasNext())
      {
        paramAnonymousMap = (j)paramAnonymousCollection.next();
        if ((paramAnonymousMap.e.a.equals(ListChatInfo.b(ListChatInfo.this).t)) && ((m.a(paramAnonymousMap.s)) || (paramAnonymousMap.T))) {
          ListChatInfo.i(ListChatInfo.this);
        }
      }
    }
  };
  cs q;
  ArrayList<cs> r = new ArrayList();
  cs s;
  final ad t = ad.a();
  final e u = e.a();
  final aj v = aj.a();
  final qz w = qz.a();
  final hx x = hx.a();
  private b y;
  private ChatInfoLayout z;
  
  public static void a(cs paramcs, Activity paramActivity)
  {
    a(paramcs, paramActivity, null);
  }
  
  public static void a(cs paramcs, Activity paramActivity, android.support.v4.app.c paramc)
  {
    Intent localIntent = new Intent(paramActivity, ListChatInfo.class);
    localIntent.putExtra("gid", paramcs.t);
    localIntent.putExtra("circular_transition", true);
    if (paramc == null) {}
    for (paramcs = null;; paramcs = paramc.a())
    {
      android.support.v4.app.a.a(paramActivity, localIntent, paramcs);
      return;
    }
  }
  
  private void u()
  {
    View localView = this.A.getChildAt(0);
    if (localView != null)
    {
      if (this.A.getWidth() <= this.A.getHeight()) {
        break label76;
      }
      if (this.A.getFirstVisiblePosition() != 0) {
        break label62;
      }
      i = localView.getTop();
      this.B.offsetTopAndBottom(i - this.B.getTop());
    }
    label62:
    label76:
    while (this.B.getTop() == 0) {
      for (;;)
      {
        return;
        int i = -this.B.getHeight() + 1;
      }
    }
    this.B.offsetTopAndBottom(-this.B.getTop());
  }
  
  private void v()
  {
    try
    {
      String str = l.e(this, this.aF, Long.parseLong(this.q.g));
      this.D.setText(getResources().getString(2131296953, new Object[] { str }));
      this.D.setVisibility(0);
      if (this.E != null) {
        this.E.cancel(true);
      }
      o();
      b(true);
      this.E = new c((byte)0);
      bu.a(this.E, new Void[0]);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        Log.e("listchatinfo/creation-time/error " + localNumberFormatException);
        this.D.setVisibility(8);
      }
    }
  }
  
  public void finishAfterTransition()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.B.setTransitionName(null);
      TransitionSet localTransitionSet = new TransitionSet();
      Slide localSlide = new Slide(48);
      localSlide.addTarget(this.B);
      localTransitionSet.addTransition(localSlide);
      localSlide = new Slide(80);
      localSlide.addTarget(this.A);
      localTransitionSet.addTransition(localSlide);
      getWindow().setReturnTransition(localTransitionSet);
    }
    super.finishAfterTransition();
  }
  
  public final String l()
  {
    if (this.q == null) {
      return null;
    }
    return this.q.t;
  }
  
  final void m()
  {
    super.m();
    if (this.E != null)
    {
      this.E.cancel(true);
      this.E = null;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
      this.aH.b();
      return;
    } while (paramInt2 != -1);
    paramIntent = paramIntent.getStringExtra("contact");
    this.w.a(this.q.t, paramIntent);
    paramIntent = this.u.d(paramIntent);
    this.r.add(paramIntent);
    r();
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    this.s = ((d)((AdapterView.AdapterContextMenuInfo)paramMenuItem.getMenuInfo()).targetView.getTag()).a;
    cs localcs = this.s;
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return true;
      if (localcs.d != null)
      {
        ContactInfo.a(localcs, this);
        continue;
        if (localcs == null)
        {
          pv.a(this, 2131296941, 0);
        }
        else
        {
          paramMenuItem = cs.b(localcs.t);
          Intent localIntent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
          if (localcs.f()) {
            localIntent.putExtra("name", localcs.j());
          }
          localIntent.putExtra("phone", paramMenuItem);
          localIntent.setComponent(localIntent.resolveActivity(getPackageManager()));
          if (localIntent.getComponent() != null)
          {
            startActivityForResult(localIntent, 10);
          }
          else
          {
            Log.i("group info/context system contact list could not found");
            this.aq.b();
            continue;
            try
            {
              paramMenuItem = new Intent("android.intent.action.INSERT_OR_EDIT");
              paramMenuItem.setType("vnd.android.cursor.item/contact");
              paramMenuItem.putExtra("phone", this.s.a(this));
              paramMenuItem.putExtra("phone_type", 2);
              paramMenuItem.setFlags(524288);
              startActivityForResult(paramMenuItem, 11);
            }
            catch (ActivityNotFoundException paramMenuItem)
            {
              a.a.a.a.d.a(this, 4);
            }
            continue;
            startActivity(Conversation.a(localcs));
            continue;
            this.aB.a(localcs, this, Integer.valueOf(13), false);
            continue;
            a.a.a.a.d.a(this, 6);
            continue;
            paramMenuItem = new Intent(this, IdentityVerificationActivity.class);
            paramMenuItem.putExtra("jid", this.s.t);
            startActivity(paramMenuItem);
          }
        }
      }
    }
  }
  
  @SuppressLint({"PrivateResource"})
  public void onCreate(Bundle paramBundle)
  {
    Log.i("list_chat_info/create");
    b(5);
    this.F = com.whatsapp.k.c.a("ListChatInfoInit");
    this.F.a();
    this.F.a(d.e.b);
    super.onCreate(paramBundle);
    o_();
    this.z = ((ChatInfoLayout)al.a(this.aq, getLayoutInflater(), 2130903248, null, false));
    setContentView(this.z);
    Object localObject1 = (Toolbar)findViewById(2131755412);
    ((Toolbar)localObject1).setTitle("");
    ((Toolbar)localObject1).e();
    a((Toolbar)localObject1);
    i().a(true);
    ((Toolbar)localObject1).setNavigationIcon(new az(android.support.v4.content.b.a(this, 2130840096)));
    this.A = W();
    localObject1 = al.a(this.aq, getLayoutInflater(), 2130903250, this.A, false);
    this.A.addHeaderView((View)localObject1, null, false);
    this.B = findViewById(2131755386);
    this.z.a();
    this.z.setColor(android.support.v4.content.b.c(this, 2131624091));
    this.z.a(getResources().getDimensionPixelSize(2131361843), getResources().getDimensionPixelSize(2131361843));
    View localView = al.a(this.aq, getLayoutInflater(), 2130903249, this.A, false);
    this.A.addFooterView(localView, null, false);
    LinearLayout localLinearLayout = new LinearLayout(this);
    localLinearLayout.setPadding(0, 0, 0, getWindowManager().getDefaultDisplay().getHeight());
    this.A.addFooterView(localLinearLayout, null, false);
    this.q = this.u.d(getIntent().getStringExtra("gid"));
    this.y = new b(this, this.r);
    this.B = findViewById(2131755386);
    this.A.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        ListChatInfo.j(ListChatInfo.this);
      }
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.A.getViewTreeObserver().addOnGlobalLayoutListener(tq.a(this));
    this.A.setOnItemClickListener(tw.a(this));
    Log.d("list_chat_info/" + this.q.toString());
    Object localObject2 = findViewById(2131755817);
    ((TextView)((View)localObject2).findViewById(2131755819)).setText(2131296290);
    ((View)localObject2).setVisibility(0);
    ((View)localObject2).setOnClickListener(tx.a(this));
    findViewById(2131755907).setVisibility(8);
    findViewById(2131755243).setVisibility(8);
    findViewById(2131755247).setVisibility(8);
    findViewById(2131755246).setVisibility(8);
    this.D = ((TextView)findViewById(2131755461));
    ((TextView)findViewById(2131755815)).setText(2131297508);
    localObject2 = ty.a(this);
    findViewById(2131755917).setOnClickListener((View.OnClickListener)localObject2);
    findViewById(2131755918).setOnClickListener((View.OnClickListener)localObject2);
    this.A.setAdapter(this.y);
    registerForContextMenu(this.A);
    Log.d("list_chat_info/" + this.q.toString());
    ((ImageButton)findViewById(2131755805)).setOnClickListener(tz.a(this));
    this.C = ((TextView)findViewById(2131755816));
    this.C.setText(getString(2131297342, new Object[] { Integer.valueOf(this.r.size()), Integer.valueOf(aic.r) }));
    a(2130837624, 2131623957, false);
    ((TextView)findViewById(2131755809)).setText(2131296647);
    ((ImageView)findViewById(2131755808)).setImageResource(2130840058);
    findViewById(2131755807).setOnClickListener(ua.a(this));
    localObject2 = this.I.a(this.q.t).a().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (String)((Iterator)localObject2).next();
      localObject3 = this.u.d((String)localObject3);
      if (!this.r.contains(localObject3)) {
        this.r.add(localObject3);
      }
    }
    q();
    v();
    r();
    s();
    findViewById(2131755250).setOnClickListener(ub.a(this));
    this.K.registerObserver(this.L);
    this.M.registerObserver(this.N);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("selected_jid");
      if (paramBundle != null) {
        this.s = this.u.d(paramBundle);
      }
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (!getIntent().getBooleanExtra("circular_transition", false)) {
        break label976;
      }
      this.B.setTransitionName(getString(2131298269));
    }
    for (;;)
    {
      this.z.a((View)localObject1, localView, localLinearLayout, this.y);
      a.a.a.a.d.a(W(), this.F);
      this.F.b(d.e.b);
      return;
      label976:
      findViewById(2131755467).setTransitionName(getString(2131298269));
    }
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramView = ((d)((AdapterView.AdapterContextMenuInfo)paramContextMenuInfo).targetView.getTag()).a;
    if (paramView == null) {
      return;
    }
    paramContextMenu.add(0, 1, 0, getString(2131297166, new Object[] { paramView.k() }));
    paramContextMenu.add(0, 4, 0, getString(2131296373, new Object[] { paramView.k() }));
    if (paramView.d == null)
    {
      paramContextMenu.add(0, 2, 0, getString(2131296292));
      paramContextMenu.add(0, 3, 0, getString(2131296296));
    }
    for (;;)
    {
      if (this.r.size() > 1) {
        paramContextMenu.add(0, 5, 0, getString(2131297600, new Object[] { paramView.k() }));
      }
      paramContextMenu.add(0, 6, 0, getString(2131298084));
      return;
      paramContextMenu.add(0, 0, 0, getString(2131298122, new Object[] { paramView.k() }));
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 50: 
      localObject = new uc(this);
      return new oe(this, 2131296697, this.u.e(this.q.t).e, (oe.a)localObject, aic.q, 0, 0);
    case 2: 
      if (TextUtils.isEmpty(this.q.a(this))) {}
      for (localObject = getString(2131296649);; localObject = getString(2131296648, new Object[] { this.q.a(this) })) {
        return new b.a(this).b(com.whatsapp.emoji.c.a((CharSequence)localObject, getBaseContext())).a(true).b(2131296398, ud.a(this)).a(2131297331, tr.a(this)).a();
      }
    case 6: 
      if (this.s != null)
      {
        localObject = getString(2131297608, new Object[] { this.s.a(this) });
        return new b.a(this).b(com.whatsapp.emoji.c.a((CharSequence)localObject, getBaseContext())).a(true).b(2131296398, ts.a(this)).a(2131297331, tt.a(this)).a();
      }
      return super.onCreateDialog(paramInt);
    }
    Log.w("listchatinfo/add existing contact: activity not found, probably tablet");
    return new b.a(this).b(2131296289).a(2131297331, tu.a(this)).a();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    o.a(paramMenu.add(0, 1, 0, 2131296290).setIcon(2130840047), 2);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onDestroy()
  {
    Log.i("list_chat_info/destroy");
    super.onDestroy();
    this.F.c();
    this.J.a();
    this.K.unregisterObserver(this.L);
    this.M.unregisterObserver(this.N);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 1: 
      p();
      return true;
    }
    android.support.v4.app.a.c(this);
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
    this.F.c();
  }
  
  public void onResume()
  {
    this.F.a(d.e.g);
    super.onResume();
    this.F.b(d.e.g);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (this.s != null) {
      paramBundle.putString("selected_jid", this.s.t);
    }
  }
  
  final void p()
  {
    if (this.r.size() < aic.r)
    {
      Intent localIntent = new Intent(this, ContactPicker.class);
      localIntent.putExtra("gid", this.q.t);
      startActivityForResult(localIntent, 12);
      return;
    }
    new b.a(this).a(getString(2131296307)).b(getString(2131296360, new Object[] { Integer.valueOf(aic.r) })).a(getString(2131297331), tv.a()).a().show();
  }
  
  final void q()
  {
    if (TextUtils.isEmpty(this.q.e))
    {
      this.z.setTitleText(String.format(u.a.a(2131230720, this.r.size()), new Object[] { Integer.valueOf(this.r.size()) }));
      return;
    }
    this.z.setTitleText(this.q.a(this));
  }
  
  final void r()
  {
    if (aic.r == 0) {
      this.C.setText(NumberFormat.getInstance().format(this.r.size()));
    }
    for (;;)
    {
      Collections.sort(this.r, new a(getApplicationContext()));
      this.y.notifyDataSetChanged();
      q();
      return;
      this.C.setText(getString(2131297342, new Object[] { Integer.valueOf(this.r.size()), Integer.valueOf(aic.r) }));
    }
  }
  
  final void s()
  {
    TextView localTextView = (TextView)findViewById(2131755254);
    ImageView localImageView = (ImageView)findViewById(2131755255);
    localTextView.setText(2131296358);
    localImageView.setImageDrawable(new az(android.support.v4.content.b.a(this, 2130840154)));
    findViewById(2131755253).setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        bt.a.a(ListChatInfo.b(ListChatInfo.this).t).a(ListChatInfo.this.j_(), null);
      }
    });
    findViewById(2131755253).setVisibility(0);
    findViewById(2131755252).setVisibility(0);
  }
  
  public static final class a
    implements Comparator<cs>
  {
    private final Context a;
    
    public a(Context paramContext)
    {
      this.a = paramContext;
    }
  }
  
  final class b
    extends ArrayAdapter<cs>
  {
    public final LayoutInflater a;
    
    public b(int paramInt)
    {
      super(2130903330, localList);
      this.a = LayoutInflater.from(paramInt);
    }
    
    public final int getCount()
    {
      return ListChatInfo.a(ListChatInfo.this).size();
    }
    
    public final int getItemViewType(int paramInt)
    {
      if (((cs)getItem(paramInt)).h()) {
        return 1;
      }
      return 0;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i;
      label101:
      cs localcs;
      TextEmojiLabel localTextEmojiLabel;
      if (paramView == null) {
        if (getItemViewType(paramInt) == 0)
        {
          i = 2130903246;
          paramView = al.a(ListChatInfo.this.aq, this.a, i, paramViewGroup, false);
          paramViewGroup = new ListChatInfo.d((byte)0);
          paramViewGroup.b = ((TextEmojiLabel)paramView.findViewById(2131755507));
          paramViewGroup.c = ((TextEmojiLabel)paramView.findViewById(2131755329));
          paramViewGroup.d = ((ImageView)paramView.findViewById(2131755801));
          paramView.setTag(paramViewGroup);
          paramView.setBackgroundColor(android.support.v4.content.b.c(getContext(), 2131624135));
          localcs = (cs)getItem(paramInt);
          paramViewGroup.a = localcs;
          paramViewGroup.b.setContact(localcs);
          android.support.v4.view.ab.a(paramViewGroup.d, ListChatInfo.this.getString(2131298268) + localcs.t);
          ListChatInfo.n(ListChatInfo.this).a(localcs, paramViewGroup.d);
          paramViewGroup.d.setOnClickListener(ue.a(this, localcs, paramViewGroup));
          if (!localcs.h()) {
            break label267;
          }
          localTextEmojiLabel = paramViewGroup.c;
          if (localcs.q == null) {
            break label262;
          }
        }
      }
      label262:
      for (paramViewGroup = "~" + localcs.q;; paramViewGroup = null)
      {
        localTextEmojiLabel.a(paramViewGroup);
        return paramView;
        i = 2130903247;
        break;
        paramViewGroup = (ListChatInfo.d)paramView.getTag();
        break label101;
      }
      label267:
      paramViewGroup.c.a(localcs.u);
      return paramView;
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
  }
  
  final class c
    extends AsyncTask<Void, Void, Void>
  {
    private c() {}
  }
  
  static final class d
  {
    cs a;
    TextEmojiLabel b;
    TextEmojiLabel c;
    ImageView d;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ListChatInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */