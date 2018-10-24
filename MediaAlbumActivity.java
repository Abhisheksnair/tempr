package com.whatsapp;

import a.a.a.a.a.a.d;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ah;
import android.support.v4.app.ah.a;
import android.support.v4.content.d;
import android.support.v7.view.b.a;
import android.text.TextUtils;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.whatsapp.data.ac;
import com.whatsapp.data.ad;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MediaAlbumActivity
  extends jw
  implements ah.a<List<j>>, jz
{
  private b n;
  private final HashSet<j.b> o = new HashSet();
  private final HashSet<j.b> p = new HashSet();
  private final ac q = ac.a();
  private final com.whatsapp.data.ab r = new com.whatsapp.data.ab()
  {
    public final void a(j paramAnonymousj, int paramAnonymousInt)
    {
      if (MediaAlbumActivity.a(MediaAlbumActivity.this).a(paramAnonymousj.e)) {
        MediaAlbumActivity.a(MediaAlbumActivity.this, paramAnonymousj, paramAnonymousInt);
      }
    }
    
    public final void a(Collection<j> paramAnonymousCollection, String paramAnonymousString, Map<String, Integer> paramAnonymousMap, boolean paramAnonymousBoolean)
    {
      int i = 0;
      paramAnonymousCollection = paramAnonymousCollection.iterator();
      if (paramAnonymousCollection.hasNext())
      {
        paramAnonymousString = (j)paramAnonymousCollection.next();
        if (!MediaAlbumActivity.a(MediaAlbumActivity.this).a(paramAnonymousString.e)) {
          break label83;
        }
        MediaAlbumActivity.c(MediaAlbumActivity.this).add(paramAnonymousString.e);
        i = 1;
      }
      label83:
      for (;;)
      {
        break;
        if (i != 0) {
          MediaAlbumActivity.a(MediaAlbumActivity.this).notifyDataSetChanged();
        }
        return;
      }
    }
    
    public final void a(Collection<j> paramAnonymousCollection, Map<String, Integer> paramAnonymousMap)
    {
      paramAnonymousMap = MediaAlbumActivity.a(MediaAlbumActivity.this);
      paramAnonymousCollection = paramAnonymousCollection.iterator();
      int i = 0;
      label109:
      while (paramAnonymousCollection.hasNext())
      {
        j localj = (j)paramAnonymousCollection.next();
        Iterator localIterator = paramAnonymousMap.a.iterator();
        int j = 0;
        for (;;)
        {
          if (!localIterator.hasNext()) {
            break label109;
          }
          if (((j)localIterator.next()).e.equals(localj.e))
          {
            paramAnonymousMap.a.remove(j);
            i = 1;
            break;
          }
          j += 1;
        }
      }
      if (i != 0) {
        paramAnonymousMap.notifyDataSetChanged();
      }
      if (MediaAlbumActivity.a(MediaAlbumActivity.this).isEmpty())
      {
        MediaAlbumActivity.this.finish();
        return;
      }
      MediaAlbumActivity.b(MediaAlbumActivity.this);
    }
  };
  private final dh s = dh.a();
  private final dh.a t = new dh.a()
  {
    public final void a()
    {
      MediaAlbumActivity.a(MediaAlbumActivity.this).notifyDataSetChanged();
    }
    
    protected final void a(String paramAnonymousString)
    {
      MediaAlbumActivity.a(MediaAlbumActivity.this).notifyDataSetChanged();
    }
    
    public final void b(String paramAnonymousString)
    {
      MediaAlbumActivity.a(MediaAlbumActivity.this).notifyDataSetChanged();
    }
  };
  
  private void l()
  {
    if ((b.a(this.n) == null) || (b.a(this.n).isEmpty())) {
      return;
    }
    Object localObject1 = b.a(this.n).iterator();
    int i = 0;
    int j = 0;
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (j)((Iterator)localObject1).next();
      if (((j)localObject2).s == 1)
      {
        j += 1;
      }
      else
      {
        if (((j)localObject2).s != 3) {
          break label306;
        }
        i += 1;
      }
    }
    label306:
    for (;;)
    {
      break;
      j localj = (j)b.a(this.n).get(0);
      if (i == 0) {
        localObject1 = u.a.a(2131230783, j, new Object[] { Integer.valueOf(j) });
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (!com.whatsapp.util.l.d(localj.n)) {
          localObject2 = (String)localObject1 + "  " + getString(2131296539) + "  " + com.whatsapp.util.l.e(this, localj.n);
        }
        ((android.support.v7.app.a)a.d.a(i())).b((CharSequence)localObject2);
        return;
        if (j == 0) {
          localObject1 = u.a.a(2131230786, i, new Object[] { Integer.valueOf(i) });
        } else {
          localObject1 = getString(2131297330, new Object[] { u.a.a(2131230783, j, new Object[] { Integer.valueOf(j) }), u.a.a(2131230786, i, new Object[] { Integer.valueOf(i) }) });
        }
      }
    }
  }
  
  private int m()
  {
    int i = getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      return getResources().getDimensionPixelSize(i);
    }
    return 0;
  }
  
  public final d<List<j>> a(Bundle paramBundle)
  {
    return new c(this, getIntent().getLongArrayExtra("message_ids"));
  }
  
  public final android.support.v7.view.b a(b.a parama)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().clearFlags(67108864);
    }
    return super.a(parama);
  }
  
  public final void a() {}
  
  public final void b(android.support.v7.view.b paramb)
  {
    super.b(paramb);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().addFlags(67108864);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
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
        this.aj.a(this.as, localj, paramIntent);
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
      Log.w("mediaalbum/forward/failed");
      pv.a(this, 2131297172, 0);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("mediaalbum/create");
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().requestFeature(12);
      getWindow().requestFeature(13);
      localObject1 = new AutoTransition();
      ((Transition)localObject1).setDuration(220L);
      ((Transition)localObject1).setInterpolator(new AccelerateDecelerateInterpolator());
      getWindow().setSharedElementEnterTransition((Transition)localObject1);
    }
    super.onCreate(paramBundle);
    o_();
    paramBundle = (android.support.v7.app.a)a.d.a(i());
    paramBundle.a(true);
    this.s.registerObserver(this.t);
    this.q.registerObserver(this.r);
    setContentView(2130903283);
    final Object localObject2 = findViewById(2131755913);
    final Object localObject1 = new ColorDrawable(android.support.v4.content.b.c(this, 2131623944));
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().getDecorView().setSystemUiVisibility(1792);
      getWindow().addFlags(201326592);
      getWindow().addFlags(Integer.MIN_VALUE);
      ((View)localObject2).setBackgroundDrawable((Drawable)localObject1);
      ((View)localObject2).setPadding(0, 0, 0, m());
    }
    localObject2 = getIntent().getStringExtra("jid");
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramBundle.a(getString(2131298216));
      this.n = new b((byte)0);
      localObject2 = W();
      if (Build.VERSION.SDK_INT >= 11) {
        break label495;
      }
    }
    label495:
    for (boolean bool = true;; bool = false)
    {
      ((ListView)localObject2).setFastScrollEnabled(bool);
      if (Build.VERSION.SDK_INT < 11) {
        ((ListView)localObject2).setSelector(2130840501);
      }
      ((ListView)localObject2).setScrollbarFadingEnabled(true);
      final FrameLayout localFrameLayout = new FrameLayout(this);
      localFrameLayout.setPadding(0, 0, 0, getResources().getDimensionPixelSize(2131361892));
      ((ListView)localObject2).addHeaderView(localFrameLayout, null, false);
      final Object localObject3 = new FrameLayout(this);
      ((ListView)localObject2).addFooterView((View)localObject3, null, false);
      android.support.v4.view.ab.a((View)localObject2, new vb(localFrameLayout, (View)localObject3, findViewById(2131755912)));
      localObject3 = new a(android.support.v4.content.b.c(this, 2131624091));
      paramBundle.a((Drawable)localObject3);
      final int i = android.support.v4.content.b.c(this, 2131624091);
      ((ListView)localObject2).setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          if (localObject2.getFirstVisiblePosition() <= 0)
          {
            paramAnonymousInt1 = localFrameLayout.getTop();
            paramAnonymousInt2 = localFrameLayout.getHeight();
            if (paramAnonymousInt2 > 0)
            {
              localObject3.a(android.support.v4.b.a.b(i, this.c, 1.0F * -paramAnonymousInt1 / paramAnonymousInt2));
              paramAnonymousInt1 = Math.max(0, Math.min(255, 255 - -paramAnonymousInt1 * 255 / paramAnonymousInt2));
              localObject1.setAlpha(paramAnonymousInt1);
              return;
            }
          }
          localObject3.a(this.c);
          localObject1.setAlpha(0);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
      });
      a(this.n);
      localObject1 = getIntent().getLongArrayExtra("message_ids");
      if ((localObject1 != null) && (localObject1.length != 0)) {
        break label500;
      }
      finish();
      return;
      paramBundle.a(this.ae.d((String)localObject2).a(this));
      break;
    }
    label500:
    paramBundle.b(u.a.a(2131230780, localObject1.length, new Object[] { Integer.valueOf(localObject1.length) }));
    h().a(this);
  }
  
  public void onDestroy()
  {
    Log.i("mediaalbum/destroy");
    super.onDestroy();
    this.s.unregisterObserver(this.t);
    this.q.unregisterObserver(this.r);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return true;
    }
    a_();
    return true;
  }
  
  final boolean w()
  {
    if (this.Z != null) {
      return false;
    }
    Log.i("starred/selectionrequested");
    this.n.notifyDataSetChanged();
    this.Z = a(new aaf(this, this.ao, this.aq, this.aj, this.aB, this.ac, this.ae, this.ag, this.ah)
    {
      public final Map<j.b, j> a()
      {
        return MediaAlbumActivity.this.aa;
      }
      
      public final void a(android.support.v7.view.b paramAnonymousb)
      {
        Log.i("starred/selectionended");
        super.a(paramAnonymousb);
        MediaAlbumActivity.this.aa = null;
        MediaAlbumActivity.a(MediaAlbumActivity.this).notifyDataSetChanged();
        MediaAlbumActivity.this.Z = null;
      }
      
      public final boolean a(android.support.v7.view.b paramAnonymousb, MenuItem paramAnonymousMenuItem)
      {
        if ((MediaAlbumActivity.this.aa == null) || (MediaAlbumActivity.this.aa.size() == 0)) {
          return true;
        }
        if (paramAnonymousMenuItem.getItemId() == 2131755068)
        {
          MediaAlbumActivity.a(MediaAlbumActivity.this, c());
          b();
          return true;
        }
        return super.a(paramAnonymousb, paramAnonymousMenuItem);
      }
      
      public final void b()
      {
        if (MediaAlbumActivity.this.Z != null) {
          MediaAlbumActivity.this.Z.c();
        }
      }
      
      public final boolean b(android.support.v7.view.b paramAnonymousb, Menu paramAnonymousMenu)
      {
        super.b(paramAnonymousb, paramAnonymousMenu);
        this.l.setVisible(false);
        this.m.setVisible(false);
        this.n.setVisible(false);
        this.o.setVisible(false);
        if (this.p != null) {
          this.p.setVisible(false);
        }
        return true;
      }
    });
    return true;
  }
  
  public final ArrayList<String> x()
  {
    return null;
  }
  
  public final String y()
  {
    return null;
  }
  
  public final int z()
  {
    return 2;
  }
  
  static final class a
    extends Drawable
  {
    private final Paint a = new Paint(1);
    
    a(int paramInt)
    {
      a(paramInt);
    }
    
    final void a(int paramInt)
    {
      if (this.a.getColor() != paramInt)
      {
        this.a.setColor(paramInt);
        invalidateSelf();
      }
    }
    
    public final void draw(Canvas paramCanvas)
    {
      paramCanvas.drawRect(getBounds(), this.a);
    }
    
    public final int getOpacity()
    {
      return -3;
    }
    
    public final void setAlpha(int paramInt) {}
    
    public final void setColorFilter(ColorFilter paramColorFilter) {}
  }
  
  final class b
    extends BaseAdapter
  {
    List<j> a;
    
    private b() {}
    
    private j a(int paramInt)
    {
      if (this.a == null) {
        return null;
      }
      return (j)this.a.get(paramInt);
    }
    
    final boolean a(j.b paramb)
    {
      if (this.a != null)
      {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
          if (((j)localIterator.next()).e.equals(paramb)) {
            return true;
          }
        }
      }
      return false;
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
    
    public final int getItemViewType(int paramInt)
    {
      return jd.a(a(paramInt));
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      j localj = a(paramInt);
      if (paramView == null)
      {
        paramViewGroup = MediaAlbumActivity.this.ai.a(paramViewGroup.getContext(), localj);
        paramView = (ViewGroup.MarginLayoutParams)paramViewGroup.getChildAt(0).getLayoutParams();
        paramView.leftMargin = 0;
        paramView.rightMargin = 0;
        View localView = paramViewGroup.findViewById(2131755615);
        paramView = paramViewGroup;
        if (localView != null)
        {
          localView.setPadding(0, 0, 0, 0);
          paramView = paramViewGroup;
        }
        if (MediaAlbumActivity.c(MediaAlbumActivity.this).contains(localj.e))
        {
          MediaAlbumActivity.c(MediaAlbumActivity.this).remove(localj.e);
          if (!MediaAlbumActivity.this.T()) {
            paramView.b(localj.T);
          }
        }
        return paramView;
      }
      paramView = (hy)paramView;
      if ((MediaAlbumActivity.c(MediaAlbumActivity.this).contains(localj.e)) || (MediaAlbumActivity.d(MediaAlbumActivity.this).contains(localj.e)) || (MediaAlbumActivity.this.Z != null)) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.a(localj, bool);
        MediaAlbumActivity.d(MediaAlbumActivity.this).remove(localj.e);
        break;
      }
    }
    
    public final int getViewTypeCount()
    {
      return 37;
    }
  }
  
  static final class c
    extends android.support.v4.content.a<List<j>>
  {
    private List<j> o;
    private final long[] p;
    private final com.whatsapp.data.l q = com.whatsapp.data.l.a();
    
    c(Context paramContext, long[] paramArrayOfLong)
    {
      super();
      this.p = paramArrayOfLong;
    }
    
    private void a(List<j> paramList)
    {
      if (h()) {}
      while (!g()) {
        return;
      }
      super.b(paramList);
    }
    
    private List<j> o()
    {
      ArrayList localArrayList = new ArrayList();
      long[] arrayOfLong = this.p;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = arrayOfLong[i];
        try
        {
          if (f()) {
            throw new android.support.v4.d.b();
          }
        }
        finally {}
        j localj = this.q.a(l);
        if (localj != null) {
          localList.add(localj);
        }
        i += 1;
      }
      return localList;
    }
    
    public final void e()
    {
      super.e();
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
      this.o = null;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/MediaAlbumActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */