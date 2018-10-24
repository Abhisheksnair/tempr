package com.whatsapp.gallerypicker;

import a.a.a.a.d;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.n;
import android.support.v4.content.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.p;
import android.util.SparseBooleanArray;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.whatsapp.and;
import com.whatsapp.aus;
import com.whatsapp.c.a;
import com.whatsapp.oz;
import com.whatsapp.pv;
import com.whatsapp.stickyheadersrecycler.StickyHeadersRecyclerView.a;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.p;
import com.whatsapp.va;
import java.util.ArrayList;

public abstract class w
  extends Fragment
{
  public static final Bitmap ab;
  private ao a;
  protected final and aa = and.a();
  private View ad;
  private int ae;
  private Drawable af;
  private int ag;
  private int ah;
  private final aus ai = aus.a();
  private final ar aj = new ar(this.ai);
  private final ArrayList<ar.a> ak = new ArrayList();
  private AsyncTask<Void, Void, Void> al;
  private final Handler am = new Handler(Looper.getMainLooper());
  private final ContentObserver an = new ContentObserver(this.am)
  {
    public final boolean deliverSelfNotifications()
    {
      return true;
    }
    
    public final void onChange(boolean paramAnonymousBoolean)
    {
      Log.i("mediagalleryfragmentbase/onchange " + paramAnonymousBoolean);
      if (w.this.b != null)
      {
        if (!paramAnonymousBoolean) {
          w.this.b.e();
        }
        w.this.c = w.this.b.b();
      }
      w.this.e.c();
    }
  };
  public r b;
  protected int c;
  public RecyclerView d;
  public RecyclerView.a e;
  protected final a f = a.a();
  protected final pv g = pv.a();
  protected final va h = va.a();
  protected final oz i = oz.a();
  
  static
  {
    if (!w.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      ac = bool;
      ab = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
      return;
    }
  }
  
  public void A()
  {
    Log.i("mediagalleryfragmentbase/destroy");
    super.A();
    if (this.al != null)
    {
      this.al.cancel(true);
      this.al = null;
    }
    if (this.a != null)
    {
      this.a.a();
      this.a = null;
    }
    if (this.b != null)
    {
      this.b.b(this.an);
      this.b.d();
      this.b = null;
    }
    this.c = 0;
  }
  
  public final ContentResolver S()
  {
    n localn = l();
    if (localn == null) {
      return null;
    }
    return localn.getContentResolver();
  }
  
  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2130903257, paramViewGroup, false);
  }
  
  public abstract r a(boolean paramBoolean);
  
  public abstract void a(q paramq, ab paramab);
  
  public final void a(final boolean paramBoolean1, final boolean paramBoolean2)
  {
    Log.i("mediagalleryfragmentbase/rebake unmounted:" + paramBoolean1 + " scanning:" + paramBoolean2);
    if (this.al != null)
    {
      this.al.cancel(true);
      this.al = null;
    }
    if (this.b != null)
    {
      this.b.b(this.an);
      this.b.d();
      this.b = null;
    }
    e(true);
    this.c = 0;
    this.ak.clear();
    this.e.c();
    this.al = new AsyncTask()
    {
      r a;
    };
    this.al.execute(new Void[0]);
  }
  
  public abstract ab b();
  
  public abstract boolean b(q paramq, ab paramab);
  
  public void d(Bundle paramBundle)
  {
    Log.i("mediagalleryfragmentbase/create");
    super.d(paramBundle);
    this.ag = b.c(k(), 2131624032);
    this.af = new ColorDrawable(this.ag);
    this.ae = m().getDimensionPixelSize(2131362001);
    paramBundle = x();
    if ((!ac) && (paramBundle == null)) {
      throw new AssertionError();
    }
    this.ad = paramBundle.findViewById(2131755782);
    this.d = ((RecyclerView)paramBundle.findViewById(2131755713));
    this.e = new c();
    this.d.setAdapter(this.e);
    int j = l().getWindowManager().getDefaultDisplay().getHeight();
    int k = l().getWindowManager().getDefaultDisplay().getWidth();
    int m = m().getDimensionPixelSize(2131362001);
    this.ah = (j * k / (m * m) + 1);
    this.a = new ao(this.f, l().getContentResolver(), new Handler(Looper.getMainLooper()));
  }
  
  public abstract boolean d(int paramInt);
  
  protected final void e(boolean paramBoolean)
  {
    View localView = x();
    if (localView != null)
    {
      localView = localView.findViewById(2131755238);
      if (!paramBoolean) {
        break label29;
      }
    }
    label29:
    for (int j = 0;; j = 8)
    {
      localView.setVisibility(j);
      return;
    }
  }
  
  static final class a
    extends RecyclerView.p
  {
    private TextView n;
    
    a(View paramView)
    {
      super();
      this.n = ((TextView)paramView.findViewById(2131755922));
    }
  }
  
  final class b
    extends AsyncTask<Void, Void, Void>
  {
    boolean a;
    boolean b;
    int c;
    
    b(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.a = paramBoolean1;
      this.b = paramBoolean2;
    }
  }
  
  final class c
    extends RecyclerView.a<w.d>
    implements StickyHeadersRecyclerView.a<w.a>
  {
    final SparseBooleanArray c = new SparseBooleanArray();
    private boolean e;
    
    c()
    {
      a(true);
    }
    
    public final int a()
    {
      return w.this.c;
    }
    
    public final long b(int paramInt)
    {
      return paramInt;
    }
    
    public final int d()
    {
      return w.g(w.this).size();
    }
    
    public final int e(int paramInt)
    {
      return ((ar.a)w.g(w.this).get(paramInt)).b;
    }
  }
  
  final class d
    extends RecyclerView.p
  {
    d(final ab paramab)
    {
      super();
      paramab.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          if (paramab.getMediaItem() != null) {
            w.this.a(paramab.getMediaItem(), paramab);
          }
        }
      });
      paramab.setOnLongClickListener(aa.a(this, paramab));
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */