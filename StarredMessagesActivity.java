package com.whatsapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ah;
import android.support.v4.app.ah.a;
import android.support.v4.app.m;
import android.support.v4.content.d;
import android.support.v4.view.o;
import android.support.v4.view.o.e;
import android.support.v4.widget.c;
import android.support.v7.app.b.a;
import android.support.v7.view.b;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.SearchView.b;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.whatsapp.data.ab;
import com.whatsapp.data.ac;
import com.whatsapp.data.ad;
import com.whatsapp.data.ch;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.data.l;
import com.whatsapp.data.q;
import com.whatsapp.messaging.aj;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.registration.bb;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.be;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StarredMessagesActivity
  extends jw
  implements ah.a<Cursor>, jz
{
  private final di.e A = di.a().b();
  private final ac B = ac.a();
  private final ab C = new ab()
  {
    public final void a(j paramAnonymousj, int paramAnonymousInt)
    {
      if ((paramAnonymousj != null) && (paramAnonymousj.T)) {
        StarredMessagesActivity.a(StarredMessagesActivity.this, paramAnonymousj);
      }
    }
    
    public final void a(Collection<j> paramAnonymousCollection, String paramAnonymousString, Map<String, Integer> paramAnonymousMap, boolean paramAnonymousBoolean)
    {
      if (((paramAnonymousCollection != null) && (!paramAnonymousCollection.isEmpty()) && (paramAnonymousMap != null)) || ((paramAnonymousCollection == null) && (paramAnonymousMap == null))) {
        StarredMessagesActivity.a(StarredMessagesActivity.this);
      }
    }
    
    public final void a(Collection<j> paramAnonymousCollection, Map<String, Integer> paramAnonymousMap)
    {
      paramAnonymousCollection = paramAnonymousCollection.iterator();
      while (paramAnonymousCollection.hasNext()) {
        if (((j)paramAnonymousCollection.next()).T) {
          StarredMessagesActivity.a(StarredMessagesActivity.this);
        }
      }
    }
  };
  private final dh D = dh.a();
  private final dh.a E = new dh.a()
  {
    public final void a()
    {
      StarredMessagesActivity.b(StarredMessagesActivity.this).notifyDataSetChanged();
    }
    
    protected final void a(String paramAnonymousString)
    {
      StarredMessagesActivity.b(StarredMessagesActivity.this).notifyDataSetChanged();
    }
    
    public final void b(String paramAnonymousString)
    {
      StarredMessagesActivity.b(StarredMessagesActivity.this).notifyDataSetChanged();
    }
  };
  private a n;
  private MenuItem o;
  private MenuItem p;
  private ArrayList<String> q;
  private String r;
  private String s;
  private final va t = va.a();
  private final aoj u = aoj.a();
  private final ad v = ad.a();
  private final aj w = aj.a();
  private final q x = q.a();
  private final l y = l.a();
  private final bb z = bb.a();
  
  private void l()
  {
    if (this.n.a() == null)
    {
      findViewById(2131756097).setVisibility(8);
      findViewById(2131755391).setVisibility(8);
      findViewById(2131755224).setVisibility(0);
      return;
    }
    if ((this.q != null) && (!this.q.isEmpty()))
    {
      findViewById(2131756097).setVisibility(8);
      TextView localTextView = (TextView)findViewById(2131755391);
      localTextView.setVisibility(0);
      localTextView.setText(getString(2131297639, new Object[] { this.r }));
      findViewById(2131755224).setVisibility(8);
      return;
    }
    findViewById(2131756097).setVisibility(0);
    findViewById(2131755391).setVisibility(8);
    findViewById(2131755224).setVisibility(8);
  }
  
  public final d<Cursor> a(Bundle paramBundle)
  {
    if (paramBundle == null) {}
    for (paramBundle = null;; paramBundle = paramBundle.getString("query")) {
      return new b(this, paramBundle, this.s);
    }
  }
  
  public final void a()
  {
    this.n.b(null);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while (paramInt2 != -1);
    Object localObject = Q();
    if (!((Collection)localObject).isEmpty())
    {
      paramIntent = paramIntent.getStringArrayListExtra("jids");
      localObject = lt.a((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        j localj = (j)((Iterator)localObject).next();
        this.u.a(this.as, localj, paramIntent);
      }
      if ((paramIntent.size() == 1) && (!j.c((String)paramIntent.get(0)))) {
        startActivity(Conversation.a(this.ae.d((String)paramIntent.get(0))));
      }
    }
    for (;;)
    {
      P();
      return;
      pv.a(getBaseContext(), paramIntent);
      continue;
      Log.w("starred/forward/failed");
      pv.a(this, 2131297172, 0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("starred/create");
    super.onCreate(paramBundle);
    V();
    i().a(true);
    this.D.registerObserver(this.E);
    this.B.registerObserver(this.C);
    if ((this.t.b == null) || (!this.v.z.d) || (!this.z.b()))
    {
      Log.i("starred/create/no-me-or-msgstore-db");
      this.aq.a("starred bounce to main");
      startActivity(new Intent(this, Main.class));
      finish();
      return;
    }
    this.s = getIntent().getStringExtra("jid");
    setContentView(2130903368);
    this.n = new a();
    paramBundle = W();
    if (Build.VERSION.SDK_INT < 11) {}
    for (boolean bool = true;; bool = false)
    {
      paramBundle.setFastScrollEnabled(bool);
      if (Build.VERSION.SDK_INT < 11) {
        paramBundle.setSelector(2130840501);
      }
      paramBundle.setScrollbarFadingEnabled(true);
      a(this.n);
      h().a(this);
      l();
      return;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    boolean bool2 = true;
    this.p = paramMenu.add(0, 2131755084, 0, 2131298067);
    o.a(this.p, 0);
    Object localObject = this.p;
    MenuItem localMenuItem;
    if (!this.aT.isEmpty())
    {
      bool1 = true;
      ((MenuItem)localObject).setVisible(bool1);
      if (this.x.b())
      {
        localObject = new SearchView(i().h());
        ((TextView)((SearchView)localObject).findViewById(2131755212)).setTextColor(getResources().getColor(2131624098));
        ((SearchView)localObject).setQueryHint(getString(2131297635));
        ((SearchView)localObject).setOnQueryTextListener(new SearchView.b()
        {
          public final boolean a(String paramAnonymousString)
          {
            return false;
          }
          
          public final boolean b(String paramAnonymousString)
          {
            StarredMessagesActivity.a(StarredMessagesActivity.this, paramAnonymousString);
            StarredMessagesActivity.a(StarredMessagesActivity.this, be.c(paramAnonymousString));
            Bundle localBundle = new Bundle();
            localBundle.putString("query", paramAnonymousString);
            StarredMessagesActivity.this.h().a(localBundle, StarredMessagesActivity.this);
            return false;
          }
        });
        this.o = paramMenu.add(0, 2131755072, 0, 2131297631).setIcon(2130840073);
        localMenuItem = this.o;
        if (this.aT.isEmpty()) {
          break label233;
        }
      }
    }
    label233:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localMenuItem.setVisible(bool1);
      o.a(this.o, (View)localObject);
      o.a(this.o, 10);
      o.a(this.o, new o.e()
      {
        public final boolean a(MenuItem paramAnonymousMenuItem)
        {
          return true;
        }
        
        public final boolean b(MenuItem paramAnonymousMenuItem)
        {
          StarredMessagesActivity.a(StarredMessagesActivity.this, null);
          return true;
        }
      });
      return super.onCreateOptionsMenu(paramMenu);
      bool1 = false;
      break;
    }
  }
  
  public void onDestroy()
  {
    Log.i("starred/destroy");
    super.onDestroy();
    this.A.a();
    this.D.unregisterObserver(this.E);
    this.B.unregisterObserver(this.C);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131755084)
    {
      new c().a(j_(), "UnstarAllDialogFragment");
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public boolean onSearchRequested()
  {
    if (this.o != null) {
      o.b(this.o);
    }
    return false;
  }
  
  final boolean w()
  {
    if (this.Z != null) {
      return false;
    }
    Log.i("starred/selectionrequested");
    this.n.notifyDataSetChanged();
    this.Z = a(new aaf(this, this.ao, this.aq, this.u, this.aB, this.v, this.ae, this.ag, this.ah)
    {
      public final Map<j.b, j> a()
      {
        return StarredMessagesActivity.this.aa;
      }
      
      public final void a(b paramAnonymousb)
      {
        Log.i("starred/selectionended");
        super.a(paramAnonymousb);
        StarredMessagesActivity.this.aa = null;
        StarredMessagesActivity.b(StarredMessagesActivity.this).notifyDataSetChanged();
        StarredMessagesActivity.this.Z = null;
      }
      
      public final void b()
      {
        if (StarredMessagesActivity.this.Z != null) {
          StarredMessagesActivity.this.Z.c();
        }
      }
      
      public final boolean b(b paramAnonymousb, Menu paramAnonymousMenu)
      {
        super.b(paramAnonymousb, paramAnonymousMenu);
        this.l.setVisible(false);
        this.m.setVisible(false);
        this.q.setVisible(false);
        if ((StarredMessagesActivity.this.aa == null) || (StarredMessagesActivity.this.aa.size() == 0)) {}
        do
        {
          do
          {
            return true;
          } while (StarredMessagesActivity.this.aa.size() != 1);
          paramAnonymousb = qz.b(c());
        } while ((paramAnonymousb == null) || (e.b(paramAnonymousb)));
        paramAnonymousb = StarredMessagesActivity.this.ae.d(paramAnonymousb);
        if (paramAnonymousb.d == null)
        {
          this.l.setVisible(true);
          this.m.setVisible(true);
        }
        this.n.setVisible(true);
        this.n.setTitle(this.b.getResources().getString(2131297166, new Object[] { paramAnonymousb.k() }));
        this.o.setVisible(true);
        if (this.p != null)
        {
          this.p.setVisible(true);
          this.p.setTitle(this.b.getResources().getString(2131298108, new Object[] { paramAnonymousb.k() }));
          this.o.setTitle(this.b.getResources().getString(2131298134, new Object[] { paramAnonymousb.k() }));
          return true;
        }
        this.o.setTitle(this.b.getResources().getString(2131296373, new Object[] { paramAnonymousb.k() }));
        return true;
      }
    });
    return true;
  }
  
  public final ArrayList<String> x()
  {
    return this.q;
  }
  
  public final String y()
  {
    return this.r;
  }
  
  public final int z()
  {
    return 1;
  }
  
  final class a
    extends c
  {
    public a()
    {
      super();
    }
    
    private j a(int paramInt)
    {
      Cursor localCursor = a();
      if (localCursor != null)
      {
        int i = localCursor.getColumnIndex("key_remote_jid");
        localCursor.moveToPosition(paramInt);
        String str = localCursor.getString(i);
        return StarredMessagesActivity.g(StarredMessagesActivity.this).a(localCursor, str);
      }
      return null;
    }
    
    public final View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup)
    {
      throw new AssertionError();
    }
    
    public final void a(View paramView, Cursor paramCursor)
    {
      throw new AssertionError();
    }
    
    public final int getItemViewType(int paramInt)
    {
      return jd.a(a(paramInt));
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      final j localj = a(paramInt);
      if (paramView == null) {
        paramView = StarredMessagesActivity.this.ai.a(paramViewGroup.getContext(), localj);
      }
      for (;;)
      {
        ImageView localImageView = (ImageView)paramView.findViewById(2131755440);
        if (!localj.e.b) {
          break;
        }
        paramViewGroup = StarredMessagesActivity.h(StarredMessagesActivity.this).c();
        StarredMessagesActivity.i(StarredMessagesActivity.this).a(paramViewGroup, localImageView);
        paramView.setOnClickListener(new at()
        {
          public final void a(View paramAnonymousView)
          {
            long l = ad.e(localj);
            paramAnonymousView = Conversation.a(localj.e.a);
            paramAnonymousView.putExtra("row_id", l);
            paramAnonymousView.putExtra("key", new FMessageKey(localj.e));
            StarredMessagesActivity.this.startActivity(paramAnonymousView);
          }
        });
        return paramView;
        paramView = (hy)paramView;
        paramView.a(localj, true);
      }
      e locale = StarredMessagesActivity.this.ae;
      if (qz.e(localj.e.a)) {}
      for (paramViewGroup = localj.f;; paramViewGroup = localj.e.a)
      {
        paramViewGroup = locale.d(paramViewGroup);
        break;
      }
    }
    
    public final int getViewTypeCount()
    {
      return 37;
    }
  }
  
  static final class b
    extends android.support.v4.content.a<Cursor>
  {
    private Cursor o;
    private android.support.v4.d.a p;
    private String q;
    private String r;
    private final ad s = ad.a();
    
    public b(Context paramContext, String paramString1, String paramString2)
    {
      super();
      this.q = paramString1;
      this.r = paramString2;
    }
    
    private void a(Cursor paramCursor)
    {
      if (h()) {
        if (paramCursor != null) {
          paramCursor.close();
        }
      }
      Cursor localCursor;
      do
      {
        return;
        localCursor = this.o;
        this.o = paramCursor;
        if (g()) {
          super.b(paramCursor);
        }
      } while ((localCursor == null) || (localCursor == paramCursor) || (localCursor.isClosed()));
      localCursor.close();
    }
    
    /* Error */
    private Cursor o()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: invokevirtual 63	com/whatsapp/StarredMessagesActivity$b:f	()Z
      //   6: ifeq +16 -> 22
      //   9: new 65	android/support/v4/d/b
      //   12: dup
      //   13: invokespecial 67	android/support/v4/d/b:<init>	()V
      //   16: athrow
      //   17: astore_1
      //   18: aload_0
      //   19: monitorexit
      //   20: aload_1
      //   21: athrow
      //   22: aload_0
      //   23: new 69	android/support/v4/d/a
      //   26: dup
      //   27: invokespecial 70	android/support/v4/d/a:<init>	()V
      //   30: putfield 72	com/whatsapp/StarredMessagesActivity$b:p	Landroid/support/v4/d/a;
      //   33: aload_0
      //   34: monitorexit
      //   35: aload_0
      //   36: getfield 34	com/whatsapp/StarredMessagesActivity$b:r	Ljava/lang/String;
      //   39: ifnull +45 -> 84
      //   42: aload_0
      //   43: getfield 30	com/whatsapp/StarredMessagesActivity$b:s	Lcom/whatsapp/data/ad;
      //   46: aload_0
      //   47: getfield 34	com/whatsapp/StarredMessagesActivity$b:r	Ljava/lang/String;
      //   50: aload_0
      //   51: getfield 32	com/whatsapp/StarredMessagesActivity$b:q	Ljava/lang/String;
      //   54: aload_0
      //   55: getfield 72	com/whatsapp/StarredMessagesActivity$b:p	Landroid/support/v4/d/a;
      //   58: invokevirtual 75	com/whatsapp/data/ad:a	(Ljava/lang/String;Ljava/lang/String;Landroid/support/v4/d/a;)Landroid/database/Cursor;
      //   61: astore_1
      //   62: aload_1
      //   63: ifnull +10 -> 73
      //   66: aload_1
      //   67: invokeinterface 79 1 0
      //   72: pop
      //   73: aload_0
      //   74: monitorenter
      //   75: aload_0
      //   76: aconst_null
      //   77: putfield 72	com/whatsapp/StarredMessagesActivity$b:p	Landroid/support/v4/d/a;
      //   80: aload_0
      //   81: monitorexit
      //   82: aload_1
      //   83: areturn
      //   84: aload_0
      //   85: getfield 30	com/whatsapp/StarredMessagesActivity$b:s	Lcom/whatsapp/data/ad;
      //   88: aload_0
      //   89: getfield 32	com/whatsapp/StarredMessagesActivity$b:q	Ljava/lang/String;
      //   92: aload_0
      //   93: getfield 72	com/whatsapp/StarredMessagesActivity$b:p	Landroid/support/v4/d/a;
      //   96: invokevirtual 82	com/whatsapp/data/ad:a	(Ljava/lang/String;Landroid/support/v4/d/a;)Landroid/database/Cursor;
      //   99: astore_1
      //   100: goto -38 -> 62
      //   103: astore_2
      //   104: aload_1
      //   105: invokeinterface 46 1 0
      //   110: aload_2
      //   111: athrow
      //   112: astore_1
      //   113: aload_0
      //   114: monitorenter
      //   115: aload_0
      //   116: aconst_null
      //   117: putfield 72	com/whatsapp/StarredMessagesActivity$b:p	Landroid/support/v4/d/a;
      //   120: aload_0
      //   121: monitorexit
      //   122: aload_1
      //   123: athrow
      //   124: astore_1
      //   125: aload_0
      //   126: monitorexit
      //   127: aload_1
      //   128: athrow
      //   129: astore_1
      //   130: aload_0
      //   131: monitorexit
      //   132: aload_1
      //   133: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	134	0	this	b
      //   17	4	1	localObject1	Object
      //   61	44	1	localCursor	Cursor
      //   112	11	1	localObject2	Object
      //   124	4	1	localObject3	Object
      //   129	4	1	localObject4	Object
      //   103	8	2	localRuntimeException	RuntimeException
      // Exception table:
      //   from	to	target	type
      //   2	17	17	finally
      //   18	20	17	finally
      //   22	35	17	finally
      //   66	73	103	java/lang/RuntimeException
      //   35	62	112	finally
      //   66	73	112	finally
      //   84	100	112	finally
      //   104	112	112	finally
      //   75	82	124	finally
      //   125	127	124	finally
      //   115	122	129	finally
      //   130	132	129	finally
    }
    
    public final void e()
    {
      super.e();
      try
      {
        if (this.p != null) {
          this.p.b();
        }
        return;
      }
      finally {}
    }
    
    protected final void i()
    {
      if (this.o != null) {
        a(this.o);
      }
      if ((n()) || (this.o == null)) {
        k();
      }
    }
    
    protected final void l()
    {
      j();
    }
    
    protected final void m()
    {
      super.m();
      j();
      if ((this.o != null) && (!this.o.isClosed())) {
        this.o.close();
      }
      this.o = null;
    }
  }
  
  public static final class c
    extends m
  {
    public final Dialog c(Bundle paramBundle)
    {
      return new b.a(l()).b(2131298068).a(2131297609, amh.a(this)).b(2131296398, null).a();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/StarredMessagesActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */