package com.whatsapp.statusplayback.content;

import a.a.a.a.a.a.d;
import android.graphics.drawable.Drawable;
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
import com.whatsapp.aoa;
import com.whatsapp.aoj;
import com.whatsapp.aus;
import com.whatsapp.data.ac;
import com.whatsapp.data.ck;
import com.whatsapp.data.co;
import com.whatsapp.data.e;
import com.whatsapp.nh;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.pv;
import com.whatsapp.statusplayback.StatusPlaybackProgressView;
import com.whatsapp.statusplayback.k;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.z;
import com.whatsapp.vk;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class n
  extends i
{
  private final CircularProgressBar A;
  private final ac B = ac.a();
  private final com.whatsapp.data.ab C = new com.whatsapp.data.ab()
  {
    public final void a(j paramAnonymousj, int paramAnonymousInt)
    {
      if ((paramAnonymousj != null) && (paramAnonymousj.e.equals(n.this.k.e)) && (!paramAnonymousj.e.b))
      {
        n.this.k();
        if (3 == paramAnonymousInt)
        {
          n.this.c();
          if ((!n.this.m) && (n.this.l) && (i.a(paramAnonymousj))) {
            n.this.e();
          }
        }
      }
    }
    
    public final void a(Collection<j> paramAnonymousCollection, Map<String, Integer> paramAnonymousMap)
    {
      paramAnonymousCollection = paramAnonymousCollection.iterator();
      while (paramAnonymousCollection.hasNext())
      {
        paramAnonymousMap = (j)paramAnonymousCollection.next();
        if (paramAnonymousMap.e.equals(n.this.k.e))
        {
          n.this.b.setVisibility(8);
          n.this.k.af = true;
          paramAnonymousCollection = paramAnonymousMap.b();
          if ((paramAnonymousCollection != null) && (!paramAnonymousCollection.transferred) && (n.this.l)) {
            n.this.g();
          }
        }
      }
    }
  };
  private final at D = new at()
  {
    public final void a(View paramAnonymousView)
    {
      if (!n.this.k.af)
      {
        if (n.this.k.b().suspiciousContent != MediaData.SUSPICIOUS_CONTENT_YES) {
          break label94;
        }
        if (n.this.k.s == 2) {
          n.this.t.b(n.this.e.getContext(), 2131296829, 1);
        }
      }
      else
      {
        return;
      }
      n.this.t.b(n.this.e.getContext(), 2131296830, 1);
      return;
      label94:
      if (n.this.k.p != null)
      {
        aoj.a().a((nh)n.this.e.getContext(), n.this.k);
        return;
      }
      Log.e("cannot download media message with no media attached");
      pv.a(n.this.e.getContext(), 2131297063, 0);
    }
  };
  final View y;
  final View z;
  
  public n(pv parampv, ahx paramahx, aus paramaus, co paramco, ck paramck, k paramk, View paramView, StatusPlaybackProgressView paramStatusPlaybackProgressView, final j paramj, i.a parama)
  {
    super(parampv, paramahx, paramaus, paramco, paramck, paramk, paramView, paramStatusPlaybackProgressView, paramj, parama);
    parampv = this.h;
    if (e.b(paramj.f)) {}
    for (int i = 8;; i = 0)
    {
      parampv.setVisibility(i);
      this.y = a(2131756112);
      this.z = a(2131756111);
      parampv = (TextView)a(2131756113);
      aoa.b(parampv);
      parampv.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          n.this.z.setVisibility(0);
          android.support.v4.view.ab.c(n.this.z, 1.0F);
          n.a(n.this);
        }
      });
      this.A = ((CircularProgressBar)a(2131755238));
      this.A.setMax(100);
      this.g.setBottomSheetCallback(new BottomSheetBehavior.a()
      {
        boolean a = true;
        
        public final void a(View paramAnonymousView, float paramAnonymousFloat)
        {
          n.this.z.setVisibility(0);
          android.support.v4.view.ab.c(n.this.z, paramAnonymousFloat);
          android.support.v4.view.ab.c(n.this.y, 1.0F - paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat);
          if (TextUtils.isEmpty(paramj.z))
          {
            if (paramAnonymousFloat == 0.0F) {
              break label91;
            }
            if (this.a)
            {
              this.a = false;
              n.this.y.setBackgroundColor(0);
            }
          }
          for (;;)
          {
            n.this.d();
            return;
            label91:
            if (!this.a)
            {
              this.a = true;
              n.this.y.setBackgroundResource(2130840133);
            }
          }
        }
        
        public final void a(View paramAnonymousView, int paramAnonymousInt)
        {
          if (paramAnonymousInt == 3) {
            n.a(n.this);
          }
          do
          {
            do
            {
              return;
              if (paramAnonymousInt != 4) {
                break;
              }
              n.this.z.setVisibility(8);
              android.support.v4.view.ab.c(n.this.y, 1.0F);
            } while (!n.this.n);
            n.this.g();
            return;
          } while (n.this.n);
          n.this.f();
        }
      });
      d(false);
      k();
      this.B.registerObserver(this.C);
      return;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    k localk = this.x;
    j localj1 = this.k;
    a.d.b();
    if ((localj1.e.b) || (!(localj1.N instanceof MediaData))) {}
    Object localObject;
    do
    {
      return;
      localObject = localj1.b();
    } while ((((MediaData)localObject).transferred) || (((MediaData)localObject).suspiciousContent == MediaData.SUSPICIOUS_CONTENT_YES) || (localj1.p == null));
    Log.i("statusdownload/downloadifneeded " + paramBoolean + " " + localj1.e.c + " " + localj1.f);
    if (paramBoolean)
    {
      localObject = vk.a().iterator();
      while (((Iterator)localObject).hasNext())
      {
        j localj2 = (j)((Iterator)localObject).next();
        if ((localj2.a()) && (!localj2.e.equals(localj1.e)))
        {
          localj2.b().downloader.b();
          localk.b.put(localj1.e, localj2);
          Log.i("statusdownload/cancel " + localj2.e.c + " " + localj2.f);
        }
        else
        {
          Log.i("statusdownload/is-current " + localj2.e.c + " " + localj2.f);
        }
      }
      localk.a(localk.c, localk.d, localj1);
      return;
    }
    if (localk.a != null)
    {
      Log.i("statusdownload/add-pending-message " + localj1.e.c + " " + localj1.f);
      localk.b.put(localj1.e, localj1);
      return;
    }
    localk.a(localk.c, localk.d, localj1);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      d(paramBoolean);
      k();
    }
    super.a(paramBoolean);
  }
  
  public final void b()
  {
    super.b();
    this.B.unregisterObserver(this.C);
  }
  
  final void c()
  {
    super.c();
    View localView = this.y;
    if (TextUtils.isEmpty(this.k.z)) {}
    for (Drawable localDrawable = b.a(this.e.getContext(), 2130840133);; localDrawable = null)
    {
      localView.setBackgroundDrawable(localDrawable);
      return;
    }
  }
  
  public final void g()
  {
    super.g();
    if (this.g.getState() != 4) {
      this.g.setState(4);
    }
    this.z.setVisibility(8);
  }
  
  public final boolean h()
  {
    return false;
  }
  
  final void k()
  {
    if ((!a(this.k)) && (!this.k.af))
    {
      Object localObject = this.k.b();
      if (((MediaData)localObject).transferring)
      {
        this.b.setVisibility(0);
        this.b.setBackgroundDrawable(null);
        CircularProgressBar localCircularProgressBar = this.A;
        if ((((MediaData)localObject).progress == 0L) || (((MediaData)localObject).progress == 100L)) {}
        for (boolean bool = true;; bool = false)
        {
          localCircularProgressBar.setIndeterminate(bool);
          this.A.setProgress((int)((MediaData)localObject).progress);
          this.A.setVisibility(0);
          this.a.setVisibility(8);
          return;
        }
      }
      if (((MediaData)localObject).suspiciousContent == MediaData.SUSPICIOUS_CONTENT_YES)
      {
        this.b.setVisibility(8);
        localObject = (TextView)a(2131755226);
        if (this.k.s == 2) {
          ((TextView)localObject).setText(2131296829);
        }
        for (;;)
        {
          ((TextView)localObject).setVisibility(0);
          return;
          ((TextView)localObject).setText(2131296830);
        }
      }
      if (!((MediaData)localObject).transferred)
      {
        this.b.setBackgroundResource(2130837783);
        this.b.setVisibility(0);
        this.A.setVisibility(8);
        this.a.setVisibility(0);
        this.a.setOnClickListener(this.D);
        return;
      }
    }
    this.b.setVisibility(8);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/content/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */