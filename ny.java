package com.whatsapp;

import a.a.a.a.d;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDiskIOException;
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
import com.whatsapp.util.bu;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class ny
  extends Fragment
  implements MediaGallery.a
{
  b a;
  private final ad aa = ad.a();
  private final l ab = l.a();
  private final vv ac = vv.a();
  private final ac ad = ac.a();
  private final com.whatsapp.data.ab ae = new com.whatsapp.data.ab()
  {
    public final void a(Collection<j> paramAnonymousCollection, String paramAnonymousString, Map<String, Integer> paramAnonymousMap, boolean paramAnonymousBoolean)
    {
      if ((paramAnonymousCollection != null) && (!paramAnonymousCollection.isEmpty()))
      {
        paramAnonymousCollection = paramAnonymousCollection.iterator();
        while (paramAnonymousCollection.hasNext()) {
          if (((j)paramAnonymousCollection.next()).e.a.equals(ny.a(ny.this))) {
            break;
          }
        }
      }
      for (;;)
      {
        ny.b(ny.this);
        return;
        if (paramAnonymousString != null) {
          if (!paramAnonymousString.equals(ny.a(ny.this))) {
            break;
          }
        }
      }
    }
    
    public final void a(Collection<j> paramAnonymousCollection, Map<String, Integer> paramAnonymousMap)
    {
      paramAnonymousCollection = paramAnonymousCollection.iterator();
      while (paramAnonymousCollection.hasNext()) {
        if (((j)paramAnonymousCollection.next()).e.a.equals(ny.a(ny.this))) {
          ny.b(ny.this);
        }
      }
    }
  };
  final ar b = new ar(this.g);
  final ArrayList<ar.a> c = new ArrayList();
  e d;
  private String e;
  private String f = "";
  private final aus g = aus.a();
  private d h;
  private final pv i = pv.a();
  
  private void b()
  {
    if (this.h != null) {
      this.h.a();
    }
    if (this.d != null) {
      this.d.a();
    }
    this.h = new d(((jz)l()).y());
    bu.a(this.h, new Void[0]);
  }
  
  public final void A()
  {
    Log.i("documentsgalleryfragment/destroy");
    super.A();
    this.ad.unregisterObserver(this.ae);
    this.a.a(null);
    if (this.d != null)
    {
      this.d.a();
      this.d = null;
    }
    if (this.h != null)
    {
      this.h.a();
      this.h = null;
    }
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2130903211, paramViewGroup, false);
  }
  
  public final void a()
  {
    this.a.c();
  }
  
  public final void a(String paramString)
  {
    if (!TextUtils.equals(this.f, paramString))
    {
      this.f = paramString;
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
    Log.i("documentsgalleryfragment/create");
    super.d(paramBundle);
    this.e = l().getIntent().getStringExtra("jid");
    paramBundle = (RecyclerView)x().findViewById(2131755713);
    this.a = new b();
    paramBundle.setAdapter(this.a);
    android.support.v4.view.ab.D(paramBundle);
    android.support.v4.view.ab.D(x().findViewById(16908292));
    if ((l() instanceof MediaGallery)) {
      paramBundle.setOnScrollListener(((MediaGallery)l()).p);
    }
    this.ad.registerObserver(this.ae);
    a(true);
    b();
  }
  
  public final class a
    extends RecyclerView.p
  {
    ImageView n;
    TextView o;
    TextView p;
    TextView q;
    View r;
    TextView s;
    View t;
    TextView u;
    View v;
    j w;
    
    public a(View paramView)
    {
      super();
      this.n = ((ImageView)paramView.findViewById(2131755176));
      this.o = ((TextView)paramView.findViewById(2131755177));
      this.p = ((TextView)paramView.findViewById(2131755328));
      this.q = ((TextView)paramView.findViewById(2131755709));
      this.r = paramView.findViewById(2131755710);
      this.s = ((TextView)paramView.findViewById(2131755493));
      this.t = paramView.findViewById(2131755607);
      this.u = ((TextView)paramView.findViewById(2131755711));
      this.v = paramView.findViewById(2131755708);
      paramView.setOnClickListener(nz.a(this));
      paramView.setOnLongClickListener(oa.a(this));
    }
  }
  
  final class b
    extends mc<ny.a>
    implements StickyHeadersRecyclerView.a<ny.c>
  {
    public b()
    {
      super();
    }
    
    public final int d()
    {
      return ny.h(ny.this).size();
    }
    
    public final int e(int paramInt)
    {
      return ((ar.a)ny.h(ny.this).get(paramInt)).b;
    }
  }
  
  public static final class c
    extends RecyclerView.p
  {
    private TextView n;
    
    public c(View paramView)
    {
      super();
      this.n = ((TextView)paramView.findViewById(2131755922));
    }
  }
  
  final class d
    extends AsyncTask<Void, Void, Void>
  {
    private final String b;
    private vj c;
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
      //   1: invokevirtual 34	com/whatsapp/ny$d:isCancelled	()Z
      //   4: ifeq +5 -> 9
      //   7: aconst_null
      //   8: areturn
      //   9: aload_0
      //   10: monitorenter
      //   11: aload_0
      //   12: new 36	android/support/v4/d/a
      //   15: dup
      //   16: invokespecial 37	android/support/v4/d/a:<init>	()V
      //   19: putfield 39	com/whatsapp/ny$d:e	Landroid/support/v4/d/a;
      //   22: aload_0
      //   23: monitorexit
      //   24: aload_0
      //   25: new 41	com/whatsapp/vj
      //   28: dup
      //   29: aload_0
      //   30: getfield 21	com/whatsapp/ny$d:a	Lcom/whatsapp/ny;
      //   33: invokestatic 44	com/whatsapp/ny:c	(Lcom/whatsapp/ny;)Lcom/whatsapp/data/l;
      //   36: aload_0
      //   37: getfield 21	com/whatsapp/ny$d:a	Lcom/whatsapp/ny;
      //   40: invokestatic 47	com/whatsapp/ny:a	(Lcom/whatsapp/ny;)Ljava/lang/String;
      //   43: aload_0
      //   44: getfield 21	com/whatsapp/ny$d:a	Lcom/whatsapp/ny;
      //   47: invokestatic 50	com/whatsapp/ny:d	(Lcom/whatsapp/ny;)Lcom/whatsapp/data/ad;
      //   50: aload_0
      //   51: getfield 21	com/whatsapp/ny$d:a	Lcom/whatsapp/ny;
      //   54: invokestatic 47	com/whatsapp/ny:a	(Lcom/whatsapp/ny;)Ljava/lang/String;
      //   57: aload_0
      //   58: getfield 26	com/whatsapp/ny$d:b	Ljava/lang/String;
      //   61: aload_0
      //   62: getfield 39	com/whatsapp/ny$d:e	Landroid/support/v4/d/a;
      //   65: invokevirtual 55	com/whatsapp/data/ad:c	(Ljava/lang/String;Ljava/lang/String;Landroid/support/v4/d/a;)Landroid/database/Cursor;
      //   68: invokespecial 58	com/whatsapp/vj:<init>	(Lcom/whatsapp/data/l;Ljava/lang/String;Landroid/database/Cursor;)V
      //   71: putfield 60	com/whatsapp/ny$d:c	Lcom/whatsapp/vj;
      //   74: aload_0
      //   75: getfield 60	com/whatsapp/ny$d:c	Lcom/whatsapp/vj;
      //   78: astore_1
      //   79: aload_1
      //   80: ifnull +36 -> 116
      //   83: aload_0
      //   84: aload_0
      //   85: getfield 60	com/whatsapp/ny$d:c	Lcom/whatsapp/vj;
      //   88: invokevirtual 64	com/whatsapp/vj:getCount	()I
      //   91: putfield 66	com/whatsapp/ny$d:d	I
      //   94: new 68	java/lang/StringBuilder
      //   97: dup
      //   98: ldc 70
      //   100: invokespecial 73	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   103: aload_0
      //   104: getfield 66	com/whatsapp/ny$d:d	I
      //   107: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   110: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   113: invokestatic 86	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
      //   116: aload_0
      //   117: monitorenter
      //   118: aload_0
      //   119: aconst_null
      //   120: putfield 39	com/whatsapp/ny$d:e	Landroid/support/v4/d/a;
      //   123: aload_0
      //   124: monitorexit
      //   125: aconst_null
      //   126: areturn
      //   127: astore_1
      //   128: aload_0
      //   129: monitorexit
      //   130: aload_1
      //   131: athrow
      //   132: astore_1
      //   133: aload_0
      //   134: monitorexit
      //   135: aload_1
      //   136: athrow
      //   137: astore_1
      //   138: aload_0
      //   139: getfield 60	com/whatsapp/ny$d:c	Lcom/whatsapp/vj;
      //   142: invokevirtual 89	com/whatsapp/vj:close	()V
      //   145: aload_0
      //   146: aconst_null
      //   147: putfield 60	com/whatsapp/ny$d:c	Lcom/whatsapp/vj;
      //   150: aload_1
      //   151: athrow
      //   152: astore_1
      //   153: aload_0
      //   154: monitorenter
      //   155: aload_0
      //   156: aconst_null
      //   157: putfield 39	com/whatsapp/ny$d:e	Landroid/support/v4/d/a;
      //   160: aload_0
      //   161: monitorexit
      //   162: aload_1
      //   163: athrow
      //   164: astore_1
      //   165: aload_0
      //   166: monitorexit
      //   167: aload_1
      //   168: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	169	0	this	d
      //   78	2	1	localvj	vj
      //   127	4	1	localObject1	Object
      //   132	4	1	localObject2	Object
      //   137	14	1	localRuntimeException	RuntimeException
      //   152	11	1	localObject3	Object
      //   164	4	1	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   118	125	127	finally
      //   128	130	127	finally
      //   11	24	132	finally
      //   133	135	132	finally
      //   83	116	137	java/lang/RuntimeException
      //   24	79	152	finally
      //   83	116	152	finally
      //   138	152	152	finally
      //   155	162	164	finally
      //   165	167	164	finally
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
      for (;;)
      {
        vj localvj;
        Object localObject6;
        try
        {
          this.c = new a();
          localvj = new vj(ny.c(ny.this), ny.a(ny.this), ny.d(ny.this).c(ny.a(ny.this), this.d, this.c));
          l1 = SystemClock.uptimeMillis();
          localArrayList = new ArrayList();
        }
        finally
        {
          try
          {
            long l1;
            ArrayList localArrayList;
            Object localObject1;
            this.c = null;
            localvj.close();
            Log.i("documentsgalleryfragment/all buckets assigned");
            return null;
          }
          finally {}
          localObject2 = finally;
        }
        try
        {
          if (!localvj.moveToFirst()) {
            break label377;
          }
          localObject1 = null;
          localObject6 = localObject1;
          if (!isCancelled())
          {
            localObject6 = localvj.a();
            ar.a locala = ny.e(ny.this).a(((j)localObject6).n);
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
            long l2 = l1;
            if (!localArrayList.isEmpty())
            {
              l2 = l1;
              if (1000L + l1 < SystemClock.uptimeMillis())
              {
                l2 = SystemClock.uptimeMillis();
                localObject1 = new ArrayList(localArrayList);
                localArrayList.clear();
                ny.a(ny.this, ob.a(this, (ArrayList)localObject1));
              }
            }
            localObject1 = localObject6;
            l1 = l2;
            if (localvj.moveToNext()) {
              continue;
            }
          }
        }
        catch (SQLiteDiskIOException localSQLiteDiskIOException)
        {
          localObject6 = ny.this.k();
          ny.f(ny.this);
          d.h((Context)localObject6);
          throw localSQLiteDiskIOException;
        }
        finally
        {
          try
          {
            this.c = null;
            localvj.close();
            throw ((Throwable)localObject4);
          }
          finally {}
          localObject6 = null;
        }
      }
      if ((localObject6 != null) && (!isCancelled())) {
        localArrayList.add(localObject6);
      }
      ny.a(ny.this, oc.a(this, localArrayList));
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


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ny.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */