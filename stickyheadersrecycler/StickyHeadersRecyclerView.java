package com.whatsapp.stickyheadersrecycler;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.c;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.p;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import com.whatsapp.adn;

public class StickyHeadersRecyclerView
  extends RecyclerView
{
  private int M;
  private RecyclerView.p N;
  private int O = -1;
  private int P = -1;
  private long Q;
  private int R;
  private long S;
  private final Rect T = new Rect();
  
  public StickyHeadersRecyclerView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public StickyHeadersRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public StickyHeadersRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  static int a(long paramLong)
  {
    return (int)(paramLong >> 32);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i = 0;
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, adn.StickyHeadersRecyclerView);
      this.M = paramContext.getDimensionPixelSize(0, this.M);
      i = paramContext.getDimensionPixelSize(1, 0);
      paramContext.recycle();
    }
    if (this.M > 0) {
      a(new a(i));
    }
    setHasFixedSize(true);
  }
  
  static boolean b(long paramLong)
  {
    return (paramLong & 0xFFFFFFFF) == 4294967295L;
  }
  
  static int c(long paramLong)
  {
    return (int)paramLong;
  }
  
  private b<RecyclerView.p> getStickyHeadersAdapter()
  {
    return (b)getAdapter();
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    LinearLayoutManager localLinearLayoutManager = (LinearLayoutManager)getLayoutManager();
    Object localObject = getStickyHeadersAdapter();
    int i = localLinearLayoutManager.k();
    if (i != -1)
    {
      if (i != this.P)
      {
        this.P = i;
        this.Q = ((b)localObject).e(i);
        i = (int)(this.Q >> 32);
        if (this.O != i)
        {
          this.O = i;
          ((a)((b)localObject).c).b(this.N, this.O);
          View localView = this.N.a;
          localView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
          localView.layout(0, 0, localView.getMeasuredWidth(), localView.getMeasuredHeight());
        }
      }
      if (b(this.Q)) {
        break label304;
      }
      i = localLinearLayoutManager.l();
      if (this.R != i)
      {
        this.R = i;
        this.S = ((b)localObject).e(i);
      }
      if (!b(this.S)) {
        break label304;
      }
      localObject = localLinearLayoutManager.c(i);
      i = ((View)localObject).getTop();
      int j = this.N.a.getMeasuredHeight();
      localLinearLayoutManager.b((View)localObject, this.T);
      j = i - j - this.T.top;
      i = j;
      if (j <= 0) {}
    }
    label304:
    for (i = 0;; i = 0)
    {
      paramCanvas.save();
      paramCanvas.clipRect(0, i, this.N.a.getMeasuredWidth(), this.N.a.getMeasuredHeight() + i);
      paramCanvas.translate(0.0F, i);
      this.N.a.draw(paramCanvas);
      paramCanvas.restore();
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.M > 0)
    {
      paramInt1 = Math.max(1, (getMeasuredWidth() + this.M / 2) / this.M);
      ((GridLayoutManager)getLayoutManager()).a(paramInt1);
    }
    if ((this.N != null) && (this.N.a != null))
    {
      View localView = this.N.a;
      localView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
      localView.layout(0, 0, localView.getMeasuredWidth(), localView.getMeasuredHeight());
    }
  }
  
  public void setAdapter(final RecyclerView.a parama)
  {
    super.setAdapter(new b(parama));
    if (this.M > 0)
    {
      int i = Math.max(1, (getMeasuredWidth() + this.M / 2) / this.M);
      parama = new GridLayoutManager(getContext(), i);
      parama.a(new GridLayoutManager.c()
      {
        public final int a(int paramAnonymousInt)
        {
          if (StickyHeadersRecyclerView.a(StickyHeadersRecyclerView.this).f(paramAnonymousInt)) {
            return parama.c();
          }
          return 1;
        }
      });
      setLayoutManager(parama);
    }
    for (;;)
    {
      this.N = getStickyHeadersAdapter().a(this, 0);
      return;
      setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
    }
  }
  
  public static abstract interface a<VH extends RecyclerView.p>
  {
    public abstract VH a(ViewGroup paramViewGroup);
    
    public abstract void b(VH paramVH, int paramInt);
    
    public abstract int d();
    
    public abstract int e(int paramInt);
  }
  
  static final class b<VH extends RecyclerView.p>
    extends RecyclerView.a<VH>
  {
    RecyclerView.a<VH> c;
    
    public b(RecyclerView.a<VH> parama)
    {
      this.c = parama;
      a(parama.b());
      parama.a(new RecyclerView.c()
      {
        public final void a()
        {
          StickyHeadersRecyclerView.b.this.c();
        }
      });
    }
    
    public final int a()
    {
      int i = this.c.a();
      return ((StickyHeadersRecyclerView.a)this.c).d() + i;
    }
    
    public final int a(int paramInt)
    {
      if (f(paramInt)) {
        return 0;
      }
      return this.c.a(paramInt) + 1;
    }
    
    public final VH a(ViewGroup paramViewGroup, int paramInt)
    {
      if (paramInt == 0) {
        return ((StickyHeadersRecyclerView.a)this.c).a(paramViewGroup);
      }
      return this.c.a(paramViewGroup, paramInt);
    }
    
    public final void a(VH paramVH, int paramInt)
    {
      long l = e(paramInt);
      if (StickyHeadersRecyclerView.b(l))
      {
        ((StickyHeadersRecyclerView.a)this.c).b(paramVH, StickyHeadersRecyclerView.a(l));
        return;
      }
      this.c.a(paramVH, StickyHeadersRecyclerView.c(l));
    }
    
    public final long b(int paramInt)
    {
      long l = e(paramInt);
      if (StickyHeadersRecyclerView.b(l)) {
        return -StickyHeadersRecyclerView.a(l);
      }
      return this.c.b(StickyHeadersRecyclerView.c(l));
    }
    
    final long e(int paramInt)
    {
      int j = 0;
      StickyHeadersRecyclerView.a locala = (StickyHeadersRecyclerView.a)this.c;
      int m = locala.d();
      int k = 0;
      int i = 0;
      while (j < m)
      {
        if (k == paramInt) {
          return j << 32 | 0xFFFFFFFF;
        }
        k += 1;
        int n = locala.e(j);
        if (k + n > paramInt) {
          return j << 32 | paramInt - k + i;
        }
        k += n;
        i += n;
        j += 1;
      }
      return m - 1 << 32 | paramInt - k + i;
    }
    
    final boolean f(int paramInt)
    {
      return (e(paramInt) & 0xFFFFFFFF) == 4294967295L;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/stickyheadersrecycler/StickyHeadersRecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */