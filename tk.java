package com.whatsapp;

import a.a.a.a.d;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDiskIOException;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.n;
import android.support.v4.d.a;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.p;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.whatsapp.data.ac;
import com.whatsapp.data.ad;
import com.whatsapp.data.l;
import com.whatsapp.gallerypicker.ar;
import com.whatsapp.gallerypicker.ar.a;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.stickyheadersrecycler.StickyHeadersRecyclerView.a;
import com.whatsapp.util.Log;
import com.whatsapp.util.ag;
import com.whatsapp.util.ag.a;
import com.whatsapp.util.bu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class tk
  extends Fragment
  implements MediaGallery.a
{
  String a;
  private final pv aa = pv.a();
  private final ad ab = ad.a();
  private final vv ac = vv.a();
  private final ag ad = ag.a();
  private final ac ae = ac.a();
  private final com.whatsapp.data.ab af = new com.whatsapp.data.ab()
  {
    public final void a(Collection<j> paramAnonymousCollection, String paramAnonymousString, Map<String, Integer> paramAnonymousMap, boolean paramAnonymousBoolean)
    {
      if ((paramAnonymousCollection != null) && (!paramAnonymousCollection.isEmpty()))
      {
        paramAnonymousCollection = paramAnonymousCollection.iterator();
        while (paramAnonymousCollection.hasNext()) {
          if (((j)paramAnonymousCollection.next()).e.a.equals(tk.a(tk.this))) {
            break;
          }
        }
      }
      for (;;)
      {
        tk.b(tk.this);
        return;
        if (paramAnonymousString != null) {
          if (!paramAnonymousString.equals(tk.a(tk.this))) {
            break;
          }
        }
      }
    }
    
    public final void a(Collection<j> paramAnonymousCollection, Map<String, Integer> paramAnonymousMap)
    {
      paramAnonymousCollection = paramAnonymousCollection.iterator();
      while (paramAnonymousCollection.hasNext()) {
        if (((j)paramAnonymousCollection.next()).e.a.equals(tk.a(tk.this))) {
          tk.b(tk.this);
        }
      }
    }
  };
  b b;
  final ar c = new ar(this.h);
  final ArrayList<ar.a> d = new ArrayList();
  e e;
  final l f = l.a();
  private String g = "";
  private final aus h = aus.a();
  private d i;
  
  private void b()
  {
    if (this.i != null) {
      this.i.a();
    }
    if (this.e != null) {
      this.e.a();
    }
    this.i = new d(((jz)l()).y());
    bu.a(this.i, new Void[0]);
  }
  
  public final void A()
  {
    Log.i("linksgalleryfragment/destroy");
    super.A();
    this.ae.unregisterObserver(this.af);
    this.b.a(null);
    if (this.e != null)
    {
      this.e.a();
      this.e = null;
    }
    if (this.i != null)
    {
      this.i.a();
      this.i = null;
    }
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2130903264, paramViewGroup, false);
  }
  
  public final void a()
  {
    this.b.c();
  }
  
  public final void a(String paramString)
  {
    if (!TextUtils.equals(this.g, paramString))
    {
      this.g = paramString;
      b();
    }
  }
  
  final void a(boolean paramBoolean)
  {
    View localView = x();
    if (localView != null)
    {
      localView = localView.findViewById(2131755238);
      if (!paramBoolean) {
        break label28;
      }
    }
    label28:
    for (int j = 0;; j = 8)
    {
      localView.setVisibility(j);
      return;
    }
  }
  
  public final void d(Bundle paramBundle)
  {
    Log.i("linksgalleryfragment/create");
    super.d(paramBundle);
    this.a = l().getIntent().getStringExtra("jid");
    paramBundle = (RecyclerView)x().findViewById(2131755713);
    this.b = new b();
    paramBundle.setAdapter(this.b);
    android.support.v4.view.ab.D(paramBundle);
    android.support.v4.view.ab.D(x().findViewById(16908292));
    if ((l() instanceof MediaGallery)) {
      paramBundle.setOnScrollListener(((MediaGallery)l()).p);
    }
    this.ae.registerObserver(this.af);
    a(true);
    b();
  }
  
  public static final class a
    extends RecyclerView.p
  {
    private TextView n;
    
    public a(View paramView)
    {
      super();
      this.n = ((TextView)paramView.findViewById(2131755922));
    }
  }
  
  final class b
    extends mc<tk.c>
    implements StickyHeadersRecyclerView.a<tk.a>
  {
    public b()
    {
      super();
    }
    
    public final int d()
    {
      return tk.h(tk.this).size();
    }
    
    public final int e(int paramInt)
    {
      return ((ar.a)tk.h(tk.this).get(paramInt)).b;
    }
  }
  
  public final class c
    extends RecyclerView.p
  {
    final TextView n;
    final View o;
    final ImageView p;
    final TextView q;
    final TextView r;
    j s;
    private final View u;
    private final View v;
    
    public c(View paramView)
    {
      super();
      this.n = ((TextView)paramView.findViewById(2131755603));
      this.u = paramView.findViewById(2131755856);
      this.o = paramView.findViewById(2131755708);
      this.v = paramView.findViewById(2131755640);
      this.p = ((ImageView)paramView.findViewById(2131755327));
      this.q = ((TextView)paramView.findViewById(2131755177));
      this.r = ((TextView)paramView.findViewById(2131756263));
      this.u.setOnClickListener(tl.a(this));
      paramView.setOnClickListener(tm.a(this));
      paramView.setOnLongClickListener(tn.a(this));
    }
  }
  
  final class d
    extends AsyncTask<Void, Void, Void>
  {
    private final String b;
    private Cursor c;
    private int d;
    private a e;
    
    public d(String paramString)
    {
      this.b = paramString;
    }
    
    /* Error */
    private Void b()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokevirtual 34	com/whatsapp/tk$d:isCancelled	()Z
      //   4: ifeq +5 -> 9
      //   7: aconst_null
      //   8: areturn
      //   9: aload_0
      //   10: monitorenter
      //   11: aload_0
      //   12: new 36	android/support/v4/d/a
      //   15: dup
      //   16: invokespecial 37	android/support/v4/d/a:<init>	()V
      //   19: putfield 39	com/whatsapp/tk$d:e	Landroid/support/v4/d/a;
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_0
      //   25: aload_0
      //   26: getfield 21	com/whatsapp/tk$d:a	Lcom/whatsapp/tk;
      //   29: invokestatic 42	com/whatsapp/tk:c	(Lcom/whatsapp/tk;)Lcom/whatsapp/data/ad;
      //   32: aload_0
      //   33: getfield 21	com/whatsapp/tk$d:a	Lcom/whatsapp/tk;
      //   36: invokestatic 45	com/whatsapp/tk:a	(Lcom/whatsapp/tk;)Ljava/lang/String;
      //   39: aload_0
      //   40: getfield 26	com/whatsapp/tk$d:b	Ljava/lang/String;
      //   43: aload_0
      //   44: getfield 39	com/whatsapp/tk$d:e	Landroid/support/v4/d/a;
      //   47: invokevirtual 50	com/whatsapp/data/ad:b	(Ljava/lang/String;Ljava/lang/String;Landroid/support/v4/d/a;)Landroid/database/Cursor;
      //   50: putfield 52	com/whatsapp/tk$d:c	Landroid/database/Cursor;
      //   53: aload_0
      //   54: getfield 52	com/whatsapp/tk$d:c	Landroid/database/Cursor;
      //   57: astore_1
      //   58: aload_1
      //   59: ifnull +38 -> 97
      //   62: aload_0
      //   63: aload_0
      //   64: getfield 52	com/whatsapp/tk$d:c	Landroid/database/Cursor;
      //   67: invokeinterface 58 1 0
      //   72: putfield 60	com/whatsapp/tk$d:d	I
      //   75: new 62	java/lang/StringBuilder
      //   78: dup
      //   79: ldc 64
      //   81: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   84: aload_0
      //   85: getfield 60	com/whatsapp/tk$d:d	I
      //   88: invokevirtual 71	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   91: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   94: invokestatic 80	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   97: aload_0
      //   98: monitorenter
      //   99: aload_0
      //   100: aconst_null
      //   101: putfield 39	com/whatsapp/tk$d:e	Landroid/support/v4/d/a;
      //   104: aload_0
      //   105: monitorexit
      //   106: aconst_null
      //   107: areturn
      //   108: astore_1
      //   109: aload_0
      //   110: monitorexit
      //   111: aload_1
      //   112: athrow
      //   113: astore_1
      //   114: aload_0
      //   115: monitorexit
      //   116: aload_1
      //   117: athrow
      //   118: astore_1
      //   119: aload_0
      //   120: getfield 52	com/whatsapp/tk$d:c	Landroid/database/Cursor;
      //   123: invokeinterface 83 1 0
      //   128: aload_0
      //   129: aconst_null
      //   130: putfield 52	com/whatsapp/tk$d:c	Landroid/database/Cursor;
      //   133: aload_1
      //   134: athrow
      //   135: astore_1
      //   136: aload_0
      //   137: monitorenter
      //   138: aload_0
      //   139: aconst_null
      //   140: putfield 39	com/whatsapp/tk$d:e	Landroid/support/v4/d/a;
      //   143: aload_0
      //   144: monitorexit
      //   145: aload_1
      //   146: athrow
      //   147: astore_1
      //   148: aload_0
      //   149: monitorexit
      //   150: aload_1
      //   151: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	152	0	this	d
      //   57	2	1	localCursor	Cursor
      //   108	4	1	localObject1	Object
      //   113	4	1	localObject2	Object
      //   118	16	1	localRuntimeException	RuntimeException
      //   135	11	1	localObject3	Object
      //   147	4	1	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   99	106	108	finally
      //   109	111	108	finally
      //   11	24	113	finally
      //   114	116	113	finally
      //   62	97	118	java/lang/RuntimeException
      //   24	58	135	finally
      //   62	97	135	finally
      //   119	135	135	finally
      //   138	145	147	finally
      //   148	150	147	finally
    }
    
    final void a()
    {
      super.cancel(true);
      try
      {
        if (this.e != null) {
          this.e.b();
        }
        return;
      }
      finally {}
    }
  }
  
  final class e
    extends AsyncTask<Void, Void, Void>
  {
    int a;
    private a c;
    private final String d;
    
    public e(String paramString)
    {
      this.d = paramString;
    }
    
    private Void b()
    {
      if (isCancelled()) {
        return null;
      }
      Cursor localCursor;
      ArrayList localArrayList;
      try
      {
        this.c = new a();
        localCursor = tk.c(tk.this).b(tk.a(tk.this), this.d, this.c);
        long l = SystemClock.uptimeMillis();
        localArrayList = new ArrayList();
        Object localObject1 = null;
        try
        {
          Object localObject6;
          while ((localCursor.moveToNext()) && (!isCancelled()))
          {
            localObject6 = tk.d(tk.this).a(localCursor, tk.a(tk.this));
            ar.a locala = tk.e(tk.this).a(((j)localObject6).n);
            if (localObject1 != null)
            {
              localObject6 = localObject1;
              if (((ar.a)localObject1).equals(locala)) {}
            }
            else
            {
              if (localObject1 != null) {
                localArrayList.add(localObject1);
              }
              locala.b = 0;
              localObject6 = locala;
            }
            ((ar.a)localObject6).b += 1;
            localObject1 = localObject6;
            if (!localArrayList.isEmpty())
            {
              localObject1 = localObject6;
              if (1000L + l < SystemClock.uptimeMillis())
              {
                l = SystemClock.uptimeMillis();
                localObject1 = new ArrayList(localArrayList);
                localArrayList.clear();
                tk.a(tk.this, to.a(this, (ArrayList)localObject1));
                localObject1 = localObject6;
              }
            }
          }
          try
          {
            this.c = null;
            if (localCursor != null) {
              localCursor.close();
            }
            throw ((Throwable)localObject2);
          }
          finally {}
        }
        catch (SQLiteDiskIOException localSQLiteDiskIOException)
        {
          localObject6 = tk.this.k();
          tk.f(tk.this);
          d.h((Context)localObject6);
          throw localSQLiteDiskIOException;
        }
        finally {}
        if (localObject3 == null) {
          break label305;
        }
      }
      finally {}
      if (!isCancelled()) {
        localArrayList.add(localObject3);
      }
      label305:
      tk.a(tk.this, tp.a(this, localArrayList));
      try
      {
        this.c = null;
        if (localCursor != null) {
          localCursor.close();
        }
        Log.i("linksgalleryfragment/all buckets assigned");
        return null;
      }
      finally {}
    }
    
    final void a()
    {
      super.cancel(true);
      try
      {
        if (this.c != null) {
          this.c.b();
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/tk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */