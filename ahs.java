package com.whatsapp;

import android.support.v4.a.a;
import android.support.v4.view.ab;
import android.support.v4.view.ag;
import android.support.v4.view.ak;
import android.support.v7.widget.RecyclerView.p;
import android.support.v7.widget.ay;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class ahs
  extends ay
{
  List<List<RecyclerView.p>> a = new ArrayList();
  List<List<b>> b = new ArrayList();
  List<List<a>> c = new ArrayList();
  List<RecyclerView.p> d = new ArrayList();
  List<RecyclerView.p> e = new ArrayList();
  List<RecyclerView.p> f = new ArrayList();
  List<RecyclerView.p> g = new ArrayList();
  private List<RecyclerView.p> n = new ArrayList();
  private List<RecyclerView.p> o = new ArrayList();
  private List<b> p = new ArrayList();
  private List<a> q = new ArrayList();
  
  public ahs()
  {
    h();
    l();
    f();
    j();
    n();
  }
  
  private void a(a parama)
  {
    if (parama.a != null) {
      a(parama, parama.a);
    }
    if (parama.b != null) {
      a(parama, parama.b);
    }
  }
  
  private static void a(List<RecyclerView.p> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ab.r(((RecyclerView.p)paramList.get(i)).a).c();
      i -= 1;
    }
  }
  
  private void a(List<a> paramList, RecyclerView.p paramp)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramp)) && (locala.a == null) && (locala.b == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
  }
  
  private boolean a(a parama, RecyclerView.p paramp)
  {
    if (parama.b == paramp) {
      parama.b = null;
    }
    for (;;)
    {
      ab.c(paramp.a, 1.0F);
      ab.a(paramp.a, 0.0F);
      ab.b(paramp.a, 0.0F);
      j(paramp);
      return true;
      if (parama.a != paramp) {
        break;
      }
      parama.a = null;
    }
    return false;
  }
  
  private void k(RecyclerView.p paramp)
  {
    a.a(paramp.a);
    c(paramp);
  }
  
  public final void a()
  {
    int i;
    int j;
    label28:
    int k;
    if (!this.n.isEmpty())
    {
      i = 1;
      if (this.p.isEmpty()) {
        break label80;
      }
      j = 1;
      if (this.q.isEmpty()) {
        break label85;
      }
      k = 1;
      label42:
      if (this.o.isEmpty()) {
        break label90;
      }
    }
    label80:
    label85:
    label90:
    for (int m = 1;; m = 0)
    {
      if ((i != 0) || (j != 0) || (m != 0) || (k != 0)) {
        break label96;
      }
      return;
      i = 0;
      break;
      j = 0;
      break label28;
      k = 0;
      break label42;
    }
    label96:
    Object localObject1 = this.n.iterator();
    final Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.p)((Iterator)localObject1).next();
      final ag localag = ab.r(((RecyclerView.p)localObject2).a);
      this.f.add(localObject2);
      localag.a(i()).d(0.0F).e(0.0F).a(new c((RecyclerView.p)localObject2)
      {
        public final void a(View paramAnonymousView) {}
        
        public final void b(View paramAnonymousView)
        {
          localag.a(null);
          ab.d(paramAnonymousView, 1.0F);
          ab.e(paramAnonymousView, 1.0F);
          ahs.this.g(localObject2);
          ahs.this.f.remove(localObject2);
          ahs.this.c();
        }
      }).d();
    }
    this.n.clear();
    label282:
    label366:
    long l1;
    label443:
    long l2;
    if (j != 0)
    {
      localObject1 = new ArrayList();
      ((List)localObject1).addAll(this.p);
      this.b.add(localObject1);
      this.p.clear();
      localObject2 = aht.a(this, (List)localObject1);
      if (i != 0) {
        ab.a(((b)((List)localObject1).get(0)).a.a, (Runnable)localObject2, i());
      }
    }
    else
    {
      if (k != 0)
      {
        localObject1 = new ArrayList();
        ((List)localObject1).addAll(this.q);
        this.c.add(localObject1);
        this.q.clear();
        localObject2 = ahu.a(this, (List)localObject1);
        if (i == 0) {
          break label507;
        }
        ab.a(((a)((List)localObject1).get(0)).a.a, (Runnable)localObject2, i());
      }
      if (m == 0) {
        break label515;
      }
      localObject1 = new ArrayList();
      ((List)localObject1).addAll(this.o);
      this.a.add(localObject1);
      this.o.clear();
      localObject2 = ahv.a(this, (List)localObject1);
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label535;
      }
      if (i == 0) {
        break label517;
      }
      l1 = i();
      if (j == 0) {
        break label523;
      }
      l2 = e();
      label453:
      if (k == 0) {
        break label529;
      }
    }
    label507:
    label515:
    label517:
    label523:
    label529:
    for (long l3 = k();; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      ab.a(((RecyclerView.p)((List)localObject1).get(0)).a, (Runnable)localObject2, l1 + l2);
      return;
      ((Runnable)localObject2).run();
      break label282;
      ((Runnable)localObject2).run();
      break label366;
      break;
      l1 = 0L;
      break label443;
      l2 = 0L;
      break label453;
    }
    label535:
    ((Runnable)localObject2).run();
  }
  
  public final boolean a(RecyclerView.p paramp)
  {
    k(paramp);
    this.n.add(paramp);
    return true;
  }
  
  public final boolean a(RecyclerView.p paramp, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramp.a;
    paramInt1 = (int)(paramInt1 + ab.m(paramp.a));
    paramInt2 = (int)(paramInt2 + ab.n(paramp.a));
    k(paramp);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      h(paramp);
      return false;
    }
    if (i != 0) {
      ab.a(localView, -i);
    }
    if (j != 0) {
      ab.b(localView, -j);
    }
    this.p.add(new b(paramp, paramInt1, paramInt2, paramInt3, paramInt4, (byte)0));
    return true;
  }
  
  public final boolean a(RecyclerView.p paramp1, RecyclerView.p paramp2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramp1 == paramp2) {
      return a(paramp1, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    float f1 = ab.m(paramp1.a);
    float f2 = ab.n(paramp1.a);
    float f3 = ab.e(paramp1.a);
    k(paramp1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    ab.a(paramp1.a, f1);
    ab.b(paramp1.a, f2);
    ab.c(paramp1.a, f3);
    if (paramp2 != null)
    {
      k(paramp2);
      ab.a(paramp2.a, -i);
      ab.b(paramp2.a, -j);
      ab.c(paramp2.a, 0.0F);
    }
    this.q.add(new a(paramp1, paramp2, paramInt1, paramInt2, paramInt3, paramInt4, (byte)0));
    return true;
  }
  
  public final boolean a(RecyclerView.p paramp, List<Object> paramList)
  {
    return (!paramList.isEmpty()) || (super.a(paramp, paramList));
  }
  
  public final boolean b()
  {
    return (!this.o.isEmpty()) || (!this.q.isEmpty()) || (!this.p.isEmpty()) || (!this.n.isEmpty()) || (!this.e.isEmpty()) || (!this.f.isEmpty()) || (!this.d.isEmpty()) || (!this.g.isEmpty()) || (!this.b.isEmpty()) || (!this.a.isEmpty()) || (!this.c.isEmpty());
  }
  
  public final boolean b(RecyclerView.p paramp)
  {
    k(paramp);
    ab.d(paramp.a, 0.0F);
    ab.e(paramp.a, 0.0F);
    this.o.add(paramp);
    return true;
  }
  
  final void c()
  {
    if (!b()) {
      m();
    }
  }
  
  public final void c(RecyclerView.p paramp)
  {
    View localView = paramp.a;
    ab.r(localView).c();
    int i = this.p.size() - 1;
    while (i >= 0)
    {
      if (((b)this.p.get(i)).a == paramp)
      {
        ab.b(localView, 0.0F);
        ab.a(localView, 0.0F);
        h(paramp);
        this.p.remove(i);
      }
      i -= 1;
    }
    a(this.q, paramp);
    if (this.n.remove(paramp))
    {
      ab.d(localView, 1.0F);
      ab.e(localView, 1.0F);
      g(paramp);
    }
    if (this.o.remove(paramp))
    {
      ab.d(localView, 1.0F);
      ab.e(localView, 1.0F);
      i(paramp);
    }
    i = this.c.size() - 1;
    List localList;
    while (i >= 0)
    {
      localList = (List)this.c.get(i);
      a(localList, paramp);
      if (localList.isEmpty()) {
        this.c.remove(i);
      }
      i -= 1;
    }
    i = this.b.size() - 1;
    if (i >= 0)
    {
      localList = (List)this.b.get(i);
      int j = localList.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if (((b)localList.get(j)).a != paramp) {
            break label337;
          }
          ab.b(localView, 0.0F);
          ab.a(localView, 0.0F);
          h(paramp);
          localList.remove(j);
          if (localList.isEmpty()) {
            this.b.remove(i);
          }
        }
        i -= 1;
        break;
        label337:
        j -= 1;
      }
    }
    i = this.a.size() - 1;
    while (i >= 0)
    {
      localList = (List)this.a.get(i);
      if (localList.remove(paramp))
      {
        ab.d(localView, 1.0F);
        ab.e(localView, 1.0F);
        i(paramp);
        if (localList.isEmpty()) {
          this.a.remove(i);
        }
      }
      i -= 1;
    }
    this.f.remove(paramp);
    this.d.remove(paramp);
    this.g.remove(paramp);
    this.e.remove(paramp);
    c();
  }
  
  public final void d()
  {
    int i = this.p.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (b)this.p.get(i);
      localObject2 = ((b)localObject1).a.a;
      ab.b((View)localObject2, 0.0F);
      ab.a((View)localObject2, 0.0F);
      h(((b)localObject1).a);
      this.p.remove(i);
      i -= 1;
    }
    i = this.n.size() - 1;
    while (i >= 0)
    {
      g((RecyclerView.p)this.n.get(i));
      this.n.remove(i);
      i -= 1;
    }
    i = this.o.size() - 1;
    while (i >= 0)
    {
      localObject1 = (RecyclerView.p)this.o.get(i);
      localObject2 = ((RecyclerView.p)localObject1).a;
      ab.d((View)localObject2, 1.0F);
      ab.e((View)localObject2, 1.0F);
      i((RecyclerView.p)localObject1);
      this.o.remove(i);
      i -= 1;
    }
    i = this.q.size() - 1;
    while (i >= 0)
    {
      a((a)this.q.get(i));
      i -= 1;
    }
    this.q.clear();
    if (!b()) {
      return;
    }
    i = this.b.size() - 1;
    int j;
    View localView;
    while (i >= 0)
    {
      localObject1 = (List)this.b.get(i);
      j = ((List)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (b)((List)localObject1).get(j);
        localView = ((b)localObject2).a.a;
        ab.b(localView, 0.0F);
        ab.a(localView, 0.0F);
        h(((b)localObject2).a);
        ((List)localObject1).remove(j);
        if (((List)localObject1).isEmpty()) {
          this.b.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.a.size() - 1;
    while (i >= 0)
    {
      localObject1 = (List)this.a.get(i);
      j = ((List)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (RecyclerView.p)((List)localObject1).get(j);
        localView = ((RecyclerView.p)localObject2).a;
        ab.d(localView, 1.0F);
        ab.e(localView, 1.0F);
        i((RecyclerView.p)localObject2);
        ((List)localObject1).remove(j);
        if (((List)localObject1).isEmpty()) {
          this.a.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.c.size() - 1;
    while (i >= 0)
    {
      localObject1 = (List)this.c.get(i);
      j = ((List)localObject1).size() - 1;
      while (j >= 0)
      {
        a((a)((List)localObject1).get(j));
        if (((List)localObject1).isEmpty()) {
          this.c.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    a(this.f);
    a(this.e);
    a(this.d);
    a(this.g);
    m();
  }
  
  static final class a
  {
    public RecyclerView.p a;
    public RecyclerView.p b;
    public int c;
    public int d;
    public int e;
    public int f;
    
    private a(RecyclerView.p paramp1, RecyclerView.p paramp2)
    {
      this.a = paramp1;
      this.b = paramp2;
    }
    
    private a(RecyclerView.p paramp1, RecyclerView.p paramp2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this(paramp1, paramp2);
      this.c = paramInt1;
      this.d = paramInt2;
      this.e = paramInt3;
      this.f = paramInt4;
    }
    
    public final String toString()
    {
      return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + '}';
    }
  }
  
  static final class b
  {
    public RecyclerView.p a;
    public int b;
    public int c;
    public int d;
    public int e;
    
    private b(RecyclerView.p paramp, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.a = paramp;
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramInt3;
      this.e = paramInt4;
    }
  }
  
  static class c
    implements ak
  {
    public void a(View paramView) {}
    
    public void b(View paramView) {}
    
    public void c(View paramView) {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ahs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */