package com.whatsapp.statusplayback.content;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.a;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.view.ab;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import com.whatsapp.MediaData;
import com.whatsapp.RequestPermissionActivity;
import com.whatsapp.TextEmojiLabel;
import com.whatsapp.ahx;
import com.whatsapp.amt;
import com.whatsapp.amt.a;
import com.whatsapp.atu;
import com.whatsapp.aus;
import com.whatsapp.cc;
import com.whatsapp.data.ck;
import com.whatsapp.data.co;
import com.whatsapp.fieldstats.events.bs;
import com.whatsapp.fieldstats.l;
import com.whatsapp.nh;
import com.whatsapp.protocol.j.b;
import com.whatsapp.pv;
import com.whatsapp.statusplayback.StatusPlaybackProgressView;
import com.whatsapp.statusplayback.k;
import com.whatsapp.util.Log;
import com.whatsapp.vk;
import com.whatsapp.vv;
import java.io.File;

public class i
{
  final TextView a;
  final View b;
  public final TextEmojiLabel c;
  final View d;
  public final View e;
  final a f;
  public final BottomSheetBehavior g;
  final ViewGroup h;
  public final c i;
  final StatusPlaybackProgressView j;
  public final com.whatsapp.protocol.j k;
  boolean l;
  boolean m;
  boolean n;
  boolean o;
  public boolean p;
  boolean q;
  final Handler r = new Handler(Looper.getMainLooper());
  final Runnable s = j.a(this);
  protected final pv t;
  protected final ahx u;
  protected final co v;
  protected final ck w;
  protected final k x;
  private final Rect y = new Rect();
  private boolean z;
  
  public i(final pv parampv, ahx paramahx, aus paramaus, co paramco, ck paramck, k paramk, View paramView, StatusPlaybackProgressView paramStatusPlaybackProgressView, com.whatsapp.protocol.j paramj, final a parama)
  {
    Log.i("statusplayback/create page " + paramj.e + " " + paramj.f + " " + paramj.s);
    this.t = parampv;
    this.u = paramahx;
    this.v = paramco;
    this.w = paramck;
    this.x = paramk;
    this.e = paramView;
    this.f = parama;
    this.k = paramj;
    this.j = paramStatusPlaybackProgressView;
    switch (paramj.s)
    {
    default: 
      this.i = new u(this, paramaus);
    }
    for (;;)
    {
      this.a = ((TextView)a(2131755580));
      this.b = a(2131755579);
      this.c = ((TextEmojiLabel)a(2131755436));
      this.d = a(2131756110);
      this.h = ((ViewGroup)a(2131755402));
      this.g = new StatusPlaybackPage.1(this);
      ((CoordinatorLayout.d)this.h.getLayoutParams()).a(this.g);
      parampv = a(2131756108);
      paramahx = new StatusPlaybackPage.2(this);
      ((CoordinatorLayout.d)parampv.getLayoutParams()).a(paramahx);
      paramahx.setBottomSheetCallback(new BottomSheetBehavior.a()
      {
        public final void a(View paramAnonymousView, float paramAnonymousFloat)
        {
          if (paramAnonymousFloat > 0.95F)
          {
            i.this.r.removeCallbacks(i.this.s);
            i.this.j();
            paramAnonymousView = parampv;
            if (paramAnonymousFloat >= 0.5F) {
              break label74;
            }
          }
          label74:
          for (float f = 2.0F * paramAnonymousFloat;; f = 1.0F)
          {
            ab.c(paramAnonymousView, f);
            parama.a(paramAnonymousFloat);
            return;
            i.this.c(false);
            break;
          }
        }
        
        public final void a(View paramAnonymousView, int paramAnonymousInt)
        {
          if (paramAnonymousInt == 4)
          {
            paramAnonymousView = (Activity)i.this.e.getContext();
            paramAnonymousView.finish();
            paramAnonymousView.overridePendingTransition(0, 0);
          }
          while ((paramAnonymousInt != 3) || (i.this.g.getState() == 3)) {
            return;
          }
          i.this.g();
        }
      });
      return;
      this.i = new s(this);
      continue;
      this.i = new g(this);
      continue;
      this.i = new w(this);
      continue;
      this.i = new d(this);
    }
  }
  
  static boolean a(com.whatsapp.protocol.j paramj)
  {
    MediaData localMediaData;
    if (((paramj.N instanceof MediaData)) && (!paramj.e.b))
    {
      localMediaData = paramj.b();
      if ((paramj.s != 3) || (!localMediaData.transferring) || (localMediaData.downloader == null) || (localMediaData.downloader.g == null) || (Build.VERSION.SDK_INT < 16)) {
        break label67;
      }
    }
    label67:
    while ((localMediaData.transferred) && (localMediaData.suspiciousContent != MediaData.SUSPICIOUS_CONTENT_YES) && (localMediaData.file != null)) {
      return true;
    }
    return false;
  }
  
  private void k()
  {
    int i2 = 1;
    int i3;
    if (this.k.e.b) {
      i3 = 4;
    }
    for (;;)
    {
      Log.d("statusplayback/stats " + this.k.e + " " + this.k.f + " " + this.k.s + " origin:" + i3 + " result:" + i2);
      Object localObject = amt.a();
      com.whatsapp.protocol.j localj = this.k;
      bs localbs = new bs();
      localbs.a = Long.valueOf(((amt)localObject).c());
      localbs.b = Integer.valueOf(a.a.a.a.d.a(localj));
      localbs.d = Integer.valueOf(i3);
      localbs.c = Integer.valueOf(i2);
      l.a(((amt)localObject).b, localbs);
      if (((amt)localObject).c != null)
      {
        localObject = ((amt)localObject).c;
        ((amt.a)localObject).d += 1;
      }
      return;
      int i1;
      if (cc.a().f(this.k.f)) {
        i1 = 3;
      }
      for (;;)
      {
        if (a(this.k))
        {
          i3 = i1;
          if (this.m) {
            break;
          }
        }
        if (!this.k.b().transferring) {
          break label269;
        }
        i2 = 2;
        i3 = i1;
        break;
        if (this.o) {
          i1 = 1;
        } else {
          i1 = 2;
        }
      }
      label269:
      i2 = 3;
      i3 = i1;
    }
  }
  
  public final View a(int paramInt)
  {
    return this.e.findViewById(paramInt);
  }
  
  public void a() {}
  
  public final void a(Rect paramRect)
  {
    this.y.set(paramRect);
    this.d.setPadding(paramRect.left, 0, paramRect.right, paramRect.bottom);
    a(2131756114).setPadding(paramRect.left, 0, paramRect.right, paramRect.bottom);
    this.g.setPeekHeight(this.e.getContext().getResources().getDimensionPixelSize(2131362097) + paramRect.bottom);
    this.h.setPadding(paramRect.left, this.h.getPaddingTop(), paramRect.right, this.h.getPaddingBottom());
    View localView = a(2131756102);
    if (localView != null) {
      localView.setPadding(paramRect.left, 0, paramRect.right, paramRect.bottom);
    }
    this.i.a(paramRect);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.l)) {
      k();
    }
    this.l = paramBoolean;
    if (paramBoolean)
    {
      this.o = this.v.a(this.k);
      Log.i("statusplayback/setactive " + this.k.e + " " + this.k.f + " " + this.k.s);
      if ((a(this.k)) && (!h())) {
        e();
      }
      return;
    }
    f();
    j();
  }
  
  public void b()
  {
    Log.i("statusplayback/destroy page " + this.k.e + " " + this.k.f + " " + this.k.s);
    if (this.l) {
      k();
    }
    Log.i("statusplayback/stop " + this.k.e + " " + this.k.f + " " + this.k.s);
    this.z = false;
    this.n = false;
    this.i.j();
    j();
    this.i.n();
  }
  
  public final void b(boolean paramBoolean)
  {
    this.i.a(paramBoolean);
  }
  
  public void c()
  {
    this.i.m();
  }
  
  final void c(boolean paramBoolean)
  {
    if (this.h.getVisibility() == 4) {
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    localAlphaAnimation.setDuration(300L);
    if (!this.q)
    {
      this.d.startAnimation(localAlphaAnimation);
      this.d.setVisibility(4);
      if ((paramBoolean) && (Build.VERSION.SDK_INT >= 11)) {
        this.e.setSystemUiVisibility(1798);
      }
    }
    if (this.h.getVisibility() != 8)
    {
      this.h.startAnimation(localAlphaAnimation);
      this.h.setVisibility(4);
    }
    this.f.d();
  }
  
  final void d()
  {
    this.r.removeCallbacks(this.s);
    j();
  }
  
  final void e()
  {
    if (!a(this.k))
    {
      Log.w("statusplayback/start not possible " + this.k.e + " " + this.k.f + " " + this.k.s);
      return;
    }
    nh localnh;
    int i1;
    if ((this.k.N instanceof MediaData))
    {
      Object localObject = this.k.b();
      if ((((MediaData)localObject).file != null) && (!((MediaData)localObject).file.exists()))
      {
        localObject = this.t;
        localnh = (nh)this.e.getContext();
        String str = Environment.getExternalStorageState();
        if ((!"mounted".equals(str)) && (!"mounted_ro".equals(str)))
        {
          if (!vv.i()) {
            break label274;
          }
          i1 = 2131297241;
          pv.a(localnh, i1, 1);
        }
        if ((Build.VERSION.SDK_INT < 23) || (((pv)localObject).d.a("android.permission.READ_EXTERNAL_STORAGE") != -1)) {
          break label281;
        }
        RequestPermissionActivity.b(localnh, 2131297450, 2131297419);
      }
    }
    for (;;)
    {
      Log.i("statusplayback/start " + this.k.e + " " + this.k.f + " " + this.k.s);
      this.z = true;
      this.n = false;
      this.i.i();
      j();
      return;
      label274:
      i1 = 2131297242;
      break;
      label281:
      pv.a(localnh, vv.h(), 1);
    }
  }
  
  public final void f()
  {
    if (!this.z) {
      return;
    }
    this.n = true;
    this.i.k();
    Log.i("statusplayback/pause " + this.k.e + " " + this.k.f + " " + this.k.s);
  }
  
  public void g()
  {
    if (!this.z) {
      return;
    }
    this.n = false;
    this.i.l();
    Log.i("statusplayback/resume " + this.k.e + " " + this.k.f + " " + this.k.s);
    this.r.removeCallbacks(this.s);
    j();
  }
  
  public boolean h()
  {
    return this.g.getState() != 4;
  }
  
  final void i()
  {
    this.z = false;
    this.f.b();
  }
  
  final void j()
  {
    if (this.h.getVisibility() == 0) {}
    do
    {
      return;
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(300L);
      if (this.d.getVisibility() != 0)
      {
        this.d.startAnimation(localAlphaAnimation);
        this.d.setVisibility(0);
      }
      if (this.h.getVisibility() == 4)
      {
        this.h.startAnimation(localAlphaAnimation);
        this.h.setVisibility(0);
      }
      this.f.c();
    } while (Build.VERSION.SDK_INT < 11);
    this.e.setSystemUiVisibility(1792);
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(float paramFloat);
    
    public abstract void a(com.whatsapp.protocol.j paramj);
    
    public abstract void a(Object paramObject);
    
    public abstract boolean a(boolean paramBoolean);
    
    public abstract void b();
    
    public abstract void b(com.whatsapp.protocol.j paramj);
    
    public abstract void b(Object paramObject);
    
    public abstract void c();
    
    public abstract void d();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/content/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */