package com.whatsapp.videoplayback;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.android.exoplayer2.c.a;
import com.google.android.exoplayer2.d.b.a;
import com.google.android.exoplayer2.d.d.b;
import com.google.android.exoplayer2.g.e;
import com.google.android.exoplayer2.g.e.a;
import com.google.android.exoplayer2.h;
import com.google.android.exoplayer2.m;
import com.whatsapp.MediaData;
import com.whatsapp.m.a;
import com.whatsapp.m.a.a;
import com.whatsapp.m.a.b;
import com.whatsapp.m.a.c;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;
import com.whatsapp.vk;

final class u
  extends o
{
  private static final com.google.android.exoplayer2.h.d a = new com.google.android.exoplayer2.h.d();
  private final Handler b = new Handler(Looper.getMainLooper());
  private final ExoPlayerView f;
  private final j g;
  private a h;
  private com.google.android.exoplayer2.h.f.a i;
  private m j;
  private e k;
  private boolean l;
  private boolean m;
  private final c.a n = new c.a()
  {
    boolean a;
    boolean b;
    
    public final void a(com.google.android.exoplayer2.b paramAnonymousb)
    {
      Object localObject;
      if (paramAnonymousb.a == 1)
      {
        localObject = paramAnonymousb.a();
        if ((localObject instanceof b.a))
        {
          localObject = (b.a)localObject;
          if (((b.a)localObject).c == null) {
            if ((((b.a)localObject).getCause() instanceof d.b)) {
              localObject = "error querying decoder";
            }
          }
        }
      }
      for (;;)
      {
        Log.d("exoplayer/error in playback: " + (String)localObject, paramAnonymousb);
        u.this.a(u.a(u.this).getContext().getResources().getString(2131296759), true);
        return;
        if (((b.a)localObject).b)
        {
          localObject = "error no secure decoder";
        }
        else
        {
          localObject = "no secure decoder";
          continue;
          localObject = "error instantiating decoder";
          continue;
          localObject = null;
        }
      }
    }
    
    public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt)
    {
      if (((paramAnonymousInt == 3) || (paramAnonymousInt == 4)) && (paramAnonymousBoolean) && (!this.a))
      {
        this.a = true;
        u.this.w();
      }
      if ((paramAnonymousInt == 4) && (!this.b))
      {
        this.b = true;
        u.this.v();
      }
    }
    
    public final void c() {}
    
    public final void m_() {}
    
    public final void n_()
    {
      Log.d("exoplayer/track selection changed");
      e.a locala = u.b(u.this).a();
      if (locala != null)
      {
        if (locala.a(2) != 1) {
          break label61;
        }
        Log.i("exoplayer/unplayable video track");
        u.this.a(u.a(u.this).getContext().getResources().getString(2131296759), true);
      }
      label61:
      while (locala.a(1) != 1) {
        return;
      }
      Log.i("exoplayer/unplayable audio track");
      u.this.a(u.a(u.this).getContext().getResources().getString(2131296759), true);
    }
  };
  private final a.c o = new a.c()
  {
    public final void a(a.a paramAnonymousa) {}
    
    public final void a(a paramAnonymousa)
    {
      u.c(u.this).post(v.a(this));
    }
    
    public final void b(a paramAnonymousa) {}
    
    public final void x_() {}
  };
  
  u(Context paramContext, j paramj)
  {
    this.g = paramj;
    this.f = new ExoPlayerView(paramContext);
    paramContext = new ExoPlayerErrorFrame(paramContext);
    d locald = new d(paramContext, null);
    this.f.setExoPlayerErrorActionsController(locald);
    this.f.addView(paramContext);
    this.f.setMessage(paramj);
    j();
    k();
  }
  
  private void j()
  {
    MediaData localMediaData = this.g.b();
    if ((localMediaData.downloader == null) || (localMediaData.downloader.g == null))
    {
      Log.e("exoplayer/download not in progress or download context missing");
      throw new IllegalStateException("download not in progress or download context missing");
    }
    this.h = localMediaData.downloader.g;
    this.i = new com.whatsapp.h.b(this.h);
    if (this.h.g() == null) {
      throw new IllegalStateException("download file is null");
    }
    if (this.h.d() == a.b.d) {
      a(this.h.m(), this.h.l());
    }
    this.h.a(this.o);
  }
  
  private void k()
  {
    Object localObject;
    if (this.j == null)
    {
      Log.d("exoplayer/create player");
      this.k = new com.google.android.exoplayer2.g.c(new com.google.android.exoplayer2.g.f.a(a));
      this.j = a.a.a.a.d.a(this.f.getContext(), this.k, new h());
      this.j.a(this.n);
      this.f.setMessage(this.g);
      this.f.setPlayer(this.j);
      this.f.a(this.h.f(), this.h.m());
      this.j.a(false);
      localObject = this.j;
      if (!this.m) {
        break label205;
      }
    }
    label205:
    for (float f1 = 0.0F;; f1 = 1.0F)
    {
      ((m)localObject).a(f1);
      this.l = true;
      if (this.l)
      {
        Log.d("exoplayer/create media source");
        localObject = new com.google.android.exoplayer2.e.b(Uri.fromFile(this.h.g()), this.i, new com.google.android.exoplayer2.c.c(), this.b);
        this.j.a((com.google.android.exoplayer2.e.b)localObject, true, false);
        this.l = false;
      }
      return;
    }
  }
  
  public final View a()
  {
    return this.f;
  }
  
  public final void a(int paramInt)
  {
    if (this.j != null) {
      this.j.a(paramInt);
    }
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    Log.e("exoplayer/onError=" + paramString);
    if (!paramBoolean)
    {
      this.l = true;
      this.g.b().streamViewable = false;
      d();
    }
    b(paramString, paramBoolean);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
    m localm;
    if (this.j != null)
    {
      localm = this.j;
      if (!paramBoolean) {
        break label29;
      }
    }
    label29:
    for (float f1 = 0.0F;; f1 = 1.0F)
    {
      localm.a(f1);
      return;
    }
  }
  
  public final void b()
  {
    if ((this.g.b().downloader != null) && (this.g.b().downloader.g != this.h))
    {
      Log.d("exoplayer/reset download context");
      if (this.h != null) {
        this.h.b(this.o);
      }
      this.l = true;
      j();
    }
    k();
    if (this.j != null) {
      this.j.a(true);
    }
  }
  
  public final void c()
  {
    if (this.j != null) {
      this.j.a(false);
    }
  }
  
  public final void d()
  {
    Log.d("exoplayer/stop");
    if (this.j != null)
    {
      this.j.d();
      this.j = null;
      this.f.b();
      this.k = null;
    }
  }
  
  public final void e()
  {
    throw new UnsupportedOperationException("not implemented");
  }
  
  public final boolean f()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.j != null)
    {
      int i1 = this.j.a();
      if (i1 != 3)
      {
        bool1 = bool2;
        if (i1 != 2) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final boolean g()
  {
    return true;
  }
  
  public final int h()
  {
    if (this.j != null) {
      return (int)this.j.g();
    }
    return 0;
  }
  
  public final int i()
  {
    if (this.j != null) {
      return (int)this.j.h();
    }
    return 0;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/videoplayback/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */