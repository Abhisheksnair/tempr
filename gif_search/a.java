package com.whatsapp.gif_search;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.c;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.whatsapp.aic;
import com.whatsapp.and;
import com.whatsapp.atv;
import com.whatsapp.emoji.search.i.b;
import com.whatsapp.emoji.search.q;
import com.whatsapp.hw;
import com.whatsapp.os.a;
import com.whatsapp.pv;
import com.whatsapp.util.at;

public final class a
  extends hw
  implements f.a
{
  private RecyclerView A;
  private View B;
  private View C;
  f.b u;
  private View v;
  private k w;
  private View x;
  private p y;
  private View z;
  
  public a(View paramView, Activity paramActivity, pv parampv, com.whatsapp.emoji.h paramh, and paramand, atv paramatv)
  {
    super(paramView, paramActivity, parampv, paramh, paramand, paramatv);
  }
  
  private void j()
  {
    this.B.setVisibility(8);
    this.v.setVisibility(0);
    this.w.b(null);
    this.w = new a();
    this.A.setAdapter(this.w);
    this.w.b(this.y.b());
  }
  
  protected final void a()
  {
    int i = 0;
    super.a();
    this.C = this.j.findViewById(2131755759);
    this.y = p.a();
    this.A = ((RecyclerView)this.j.findViewById(2131755754));
    this.A.a(new RecyclerView.i()
    {
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        super.a(paramAnonymousRecyclerView, paramAnonymousInt);
        if (paramAnonymousInt == 0)
        {
          paramAnonymousInt = a.a(a.this).getHeight();
          if ((a.b(a.this) <= 0) || (a.c(a.this) <= paramAnonymousInt / 2)) {
            break label78;
          }
        }
        for (;;)
        {
          if (paramAnonymousInt != a.d(a.this)) {
            a.e(a.this).startAnimation(new os.a(a.this, paramAnonymousInt));
          }
          return;
          label78:
          paramAnonymousInt = 0;
        }
      }
      
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        if (paramAnonymousInt2 == 0) {
          return;
        }
        paramAnonymousRecyclerView = a.f(a.this).getAnimation();
        if (paramAnonymousRecyclerView != null) {
          paramAnonymousRecyclerView.cancel();
        }
        a.a(a.this, a.g(a.this) + paramAnonymousInt2);
        a.b(a.this, paramAnonymousInt2);
        a.h(a.this);
      }
    });
    final int j = this.c.getResources().getDimensionPixelSize(2131362083);
    this.A.a(new RecyclerView.f()
    {
      public final void a(Rect paramAnonymousRect, View paramAnonymousView, RecyclerView paramAnonymousRecyclerView)
      {
        paramAnonymousRect.set(0, j, j, 0);
      }
    });
    this.v = this.j.findViewById(2131755761);
    this.z = this.j.findViewById(2131755760);
    this.B = this.j.findViewById(2131755796);
    this.j.findViewById(2131755797).setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        a.i(a.this);
      }
    });
    this.w = new a();
    this.A.setAdapter(this.w);
    this.A.setHasFixedSize(true);
    final Object localObject = new GridLayoutManager(this.c, 2);
    ((GridLayoutManager)localObject).a(new GridLayoutManager.c()
    {
      public final int a(int paramAnonymousInt)
      {
        int i = 1;
        k localk = a.j(a.this);
        if ((localk.d != null) && (paramAnonymousInt == localk.d.a())) {}
        for (paramAnonymousInt = 1;; paramAnonymousInt = 0)
        {
          if (paramAnonymousInt != 0) {
            i = localObject.c();
          }
          return i;
        }
      }
    });
    this.A.setLayoutManager((RecyclerView.g)localObject);
    this.x = this.j.findViewById(2131755753);
    localObject = this.j.findViewById(2131755208);
    final ImageView localImageView1 = (ImageView)this.j.findViewById(2131755757);
    final ImageView localImageView2 = (ImageView)this.j.findViewById(2131755756);
    if (aic.H)
    {
      localImageView1.setVisibility(0);
      localImageView2.setVisibility(0);
    }
    if ((aic.G) && (this.r.b)) {}
    for (;;)
    {
      ((View)localObject).setVisibility(i);
      localImageView2.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          int j = 8;
          a.k(a.this).setVisibility(8);
          a.l(a.this).setVisibility(8);
          paramAnonymousView = localObject;
          int i = j;
          if (a.i())
          {
            i = j;
            if (a.m(a.this).b) {
              i = 0;
            }
          }
          paramAnonymousView.setVisibility(i);
          a.n(a.this).findViewById(2131755758).setVisibility(0);
          localImageView2.setImageResource(2130840157);
          localImageView1.setImageResource(2130840171);
        }
      });
      localImageView1.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          if (a.l(a.this).getVisibility() != 0)
          {
            a.l(a.this).setVisibility(0);
            a.k(a.this).setVisibility(0);
            a.i(a.this);
            localObject.setVisibility(0);
            a.o(a.this).findViewById(2131755758).setVisibility(4);
            localImageView2.setImageResource(2130840156);
            localImageView1.setImageResource(2130840175);
          }
        }
      });
      ((View)localObject).setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          a.p(a.this);
          if (a.l(a.this).getVisibility() == 0) {
            if (a.q(a.this) != null) {
              a.q(a.this).a(a.r(a.this));
            }
          }
          while ((a.s(a.this) == null) || (!a.t(a.this).b) || (a.u(a.this) == null)) {
            return;
          }
          a.w(a.this).a(a.v(a.this));
        }
      });
      return;
      i = 8;
    }
  }
  
  public final void a(View paramView1, ImageButton paramImageButton, View paramView2)
  {
    super.a(paramView1, paramImageButton, paramView2);
    if (this.x.getVisibility() == 0) {
      j();
    }
  }
  
  public final void a(j paramj)
  {
    h();
    if (this.u != null) {
      this.u.a(paramj);
    }
  }
  
  protected final boolean d()
  {
    if (!aic.H) {
      return super.d();
    }
    return true;
  }
  
  public final void dismiss()
  {
    if (this.y != null) {
      h.a().b();
    }
    if (this.r != null) {
      this.r.a = null;
    }
    super.dismiss();
  }
  
  protected final int f()
  {
    if (aic.H) {
      return 2131755758;
    }
    return super.f();
  }
  
  final class a
    extends k
  {
    public a()
    {
      super(a.y(a.this), a.z(a.this), a.this, a.A(a.this).getResources().getDimensionPixelSize(2131362012), false);
    }
    
    public final void a(r paramr)
    {
      int j = 0;
      super.a(paramr);
      a.B(a.this).setVisibility(8);
      View localView = a.C(a.this);
      if ((a.j(a.this).a() == 0) && (!paramr.d))
      {
        i = 0;
        localView.setVisibility(i);
        localView = a.D(a.this);
        if ((a.j(a.this).a() != 0) || (!paramr.d)) {
          break label100;
        }
      }
      label100:
      for (int i = j;; i = 8)
      {
        localView.setVisibility(i);
        return;
        i = 8;
        break;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gif_search/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */