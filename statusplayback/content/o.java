package com.whatsapp.statusplayback.content;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.a;
import android.support.v4.content.b;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.whatsapp.CircularProgressBar;
import com.whatsapp.MediaData;
import com.whatsapp.ahx;
import com.whatsapp.aus;
import com.whatsapp.data.ac;
import com.whatsapp.data.ck;
import com.whatsapp.data.co;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.s;
import com.whatsapp.pv;
import com.whatsapp.statusplayback.StatusPlaybackProgressView;
import com.whatsapp.statusplayback.j.a;
import com.whatsapp.statusplayback.k;
import com.whatsapp.util.at;
import com.whatsapp.util.bu;
import com.whatsapp.vs;
import com.whatsapp.vx;
import com.whatsapp.xg;
import java.util.List;

public final class o
  extends i
{
  private final View A;
  private final CircularProgressBar B;
  private final View C;
  private a D;
  private final ac E = ac.a();
  private final com.whatsapp.data.ab F = new com.whatsapp.data.ab()
  {
    public final void a(com.whatsapp.protocol.j paramAnonymousj, int paramAnonymousInt)
    {
      if ((paramAnonymousj != null) && (paramAnonymousj.e.equals(o.this.k.e)) && (paramAnonymousj.e.b))
      {
        o.this.l();
        if (s.a(paramAnonymousj.d, 4) > 0) {
          o.this.k();
        }
      }
    }
    
    public final void b(com.whatsapp.protocol.j paramAnonymousj)
    {
      if ((paramAnonymousj != null) && (paramAnonymousj.e.c.equals(o.this.k.e.c)) && (paramAnonymousj.e.b)) {
        o.this.k();
      }
    }
  };
  private final at G = new at()
  {
    public final void a(View paramAnonymousView)
    {
      o.this.u.a(o.this.k, true);
    }
  };
  final com.whatsapp.statusplayback.j y;
  final View z = a(2131755493);
  
  public o(final pv parampv, final ahx paramahx, aus paramaus, co paramco, ck paramck, k paramk, View paramView, StatusPlaybackProgressView paramStatusPlaybackProgressView, final com.whatsapp.protocol.j paramj, final i.a parama)
  {
    super(parampv, paramahx, paramaus, paramco, paramck, paramk, paramView, paramStatusPlaybackProgressView, paramj, parama);
    paramahx = a(2131756111);
    paramahx.setOnClickListener(p.a(this));
    this.g.setBottomSheetCallback(new BottomSheetBehavior.a()
    {
      boolean a = true;
      
      public final void a(View paramAnonymousView, float paramAnonymousFloat)
      {
        paramahx.setVisibility(0);
        android.support.v4.view.ab.c(paramahx, paramAnonymousFloat);
        android.support.v4.view.ab.c(o.this.z, 1.0F - paramAnonymousFloat);
        if (TextUtils.isEmpty(paramj.z))
        {
          if (paramAnonymousFloat == 0.0F) {
            break label79;
          }
          if (this.a)
          {
            this.a = false;
            o.this.z.setBackgroundColor(0);
          }
        }
        for (;;)
        {
          o.this.d();
          return;
          label79:
          if (!this.a)
          {
            this.a = true;
            o.this.z.setBackgroundResource(2130840133);
          }
        }
      }
      
      public final void a(View paramAnonymousView, int paramAnonymousInt)
      {
        if (paramAnonymousInt == 4)
        {
          paramahx.setVisibility(8);
          android.support.v4.view.ab.c(o.this.z, 1.0F);
          o.this.z.setVisibility(0);
          if (o.this.n) {
            o.this.g();
          }
        }
        do
        {
          return;
          if ((Build.VERSION.SDK_INT < 11) && (paramAnonymousInt == 3)) {
            o.this.z.setVisibility(4);
          }
        } while (o.this.n);
        o.this.f();
      }
    });
    this.y = new com.whatsapp.statusplayback.j(this.h);
    this.A = a(2131755642);
    this.C = a(2131756115);
    this.B = ((CircularProgressBar)a(2131755238));
    this.B.setMax(100);
    this.B.setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        if (s.a(paramj.d, 2) >= 0) {
          pv.a(o.this.e.getContext(), 2131296796, 0);
        }
        do
        {
          return;
          vs.a().a(paramj);
          vx.a().a(paramj);
          paramAnonymousView = paramj.b();
        } while (paramAnonymousView.uploader == null);
        paramAnonymousView.uploader.b(paramj);
      }
    });
    this.z.setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        if (o.this.g.getState() != 3)
        {
          o.this.g.setState(3);
          return;
        }
        o.this.g.setState(4);
      }
    });
    paramView.findViewById(2131755923).setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        parama.b(paramj);
      }
    });
    paramView.findViewById(2131755581).setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        parama.a(paramj);
      }
    });
    k();
    l();
    this.E.registerObserver(this.F);
  }
  
  public final void a()
  {
    f();
    this.h.postDelayed(q.a(this), 300L);
  }
  
  public final void b()
  {
    super.b();
    if (this.D != null)
    {
      this.D.cancel(true);
      this.D = null;
    }
    this.E.unregisterObserver(this.F);
  }
  
  final void c()
  {
    super.c();
    Object localObject = this.C;
    int i;
    View localView;
    if (TextUtils.isEmpty(this.k.z))
    {
      i = 0;
      ((View)localObject).setVisibility(i);
      localView = this.z;
      if (!TextUtils.isEmpty(this.k.z)) {
        break label72;
      }
    }
    label72:
    for (localObject = b.a(this.e.getContext(), 2130840133);; localObject = null)
    {
      localView.setBackgroundDrawable((Drawable)localObject);
      return;
      i = 8;
      break;
    }
  }
  
  final void k()
  {
    if (this.D != null) {
      this.D.cancel(true);
    }
    this.D = new a((byte)0);
    bu.a(this.D, new Void[0]);
  }
  
  final void l()
  {
    MediaData localMediaData = this.k.b();
    if ((localMediaData == null) || (localMediaData.transferred))
    {
      this.b.setVisibility(8);
      this.h.setVisibility(0);
      return;
    }
    if (localMediaData.transferring)
    {
      this.b.setVisibility(0);
      CircularProgressBar localCircularProgressBar = this.B;
      if ((localMediaData.progress == 0L) || (localMediaData.progress == 100L)) {}
      for (boolean bool = true;; bool = false)
      {
        localCircularProgressBar.setIndeterminate(bool);
        this.B.setProgress((int)localMediaData.progress);
        this.B.setVisibility(0);
        this.a.setVisibility(8);
        this.A.setVisibility(0);
        this.h.setVisibility(8);
        return;
      }
    }
    this.b.setVisibility(0);
    this.B.setVisibility(8);
    this.a.setVisibility(0);
    this.a.setText(2131297619);
    this.a.setCompoundDrawablesWithIntrinsicBounds(2130837714, 0, 0, 0);
    this.a.setOnClickListener(this.G);
    this.A.setVisibility(8);
    this.h.setVisibility(8);
  }
  
  final class a
    extends AsyncTask<Void, Void, List<j.a>>
  {
    private a() {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/content/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */