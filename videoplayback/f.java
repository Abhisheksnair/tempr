package com.whatsapp.videoplayback;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.h.f.a;
import com.whatsapp.MediaData;
import com.whatsapp.aoj;
import com.whatsapp.aqb;
import com.whatsapp.fieldstats.l;
import com.whatsapp.m.a;
import com.whatsapp.m.a.a;
import com.whatsapp.m.a.b;
import com.whatsapp.m.a.c;
import com.whatsapp.nh;
import com.whatsapp.util.Log;
import com.whatsapp.vk;

@TargetApi(16)
public final class f
  extends p
{
  private a o;
  private final aoj p = aoj.a();
  private aqb q;
  private boolean r = false;
  private final a.c s = new a.c()
  {
    public final void a(a.a paramAnonymousa) {}
    
    public final void a(a paramAnonymousa)
    {
      f.this.b.post(m.a(this, paramAnonymousa));
    }
    
    public final void b(a paramAnonymousa) {}
    
    public final void x_() {}
  };
  
  public f(nh paramnh, com.whatsapp.protocol.j paramj)
  {
    super(paramnh, paramj);
  }
  
  private void A()
  {
    this.p.a(this.h, this.g);
    MediaData localMediaData = this.g.b();
    if ((localMediaData.downloader != null) && (localMediaData.downloader.g != null)) {
      localMediaData.downloader.g.b();
    }
  }
  
  private void B()
  {
    if (!this.o.f()) {
      return;
    }
    if (this.g.p == null) {
      throw new IllegalStateException("cannot retry download on message with null url, key=" + this.g.e);
    }
    if (this.o != null) {
      this.o.b(this.s);
    }
    this.p.a(this.h, this.g);
    j();
    Object localObject = this.k;
    if (localObject != null) {
      ((ExoPlaybackControlView)localObject).setPlayControlVisibility(0);
    }
    localObject = this.i;
    if (localObject == null)
    {
      b();
      return;
    }
    this.f.a(this.o.f(), this.o.m());
    ((com.google.android.exoplayer2.m)localObject).a(new com.google.android.exoplayer2.e.b(l(), k(), new com.google.android.exoplayer2.c.c(), this.b), false, false);
  }
  
  protected final void a(com.google.android.exoplayer2.e.b paramb)
  {
    if (this.q == null)
    {
      this.q = new aqb(this.g, this.o, this.g.b().downloader.e);
      this.q.a();
    }
    super.a(paramb);
  }
  
  public final void a(d paramd)
  {
    paramd.a(j.a(this));
    super.a(paramd);
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    Log.e("MediaViewStreamingVideoPlayer/onError=" + paramString);
    b(paramString, paramBoolean);
    String str = paramString;
    if (paramString == null) {
      str = this.h.getResources().getString(2131298049);
    }
    if (!paramBoolean)
    {
      this.g.b().streamViewable = false;
      d();
      if (!this.h.isFinishing())
      {
        paramString = new AlertDialog.Builder(this.h);
        paramString.setMessage(str).setTitle(2131296692).setPositiveButton(2131296768, i.a(this));
        paramString.create().show();
      }
    }
    if (this.q != null)
    {
      paramString = this.q;
      if (!paramBoolean) {
        bool = true;
      }
      paramString.b(bool);
    }
  }
  
  protected final void a(boolean paramBoolean, int paramInt)
  {
    if (this.q != null)
    {
      if (paramInt != 3) {
        break label21;
      }
      this.q.a(paramBoolean);
    }
    label21:
    do
    {
      return;
      if (paramInt == 4)
      {
        this.q.c();
        return;
      }
    } while (paramInt != 2);
    this.q.b();
  }
  
  public final void d()
  {
    if (this.o != null) {
      this.o.b(this.s);
    }
    super.d();
    this.f.a();
  }
  
  public final void j()
  {
    MediaData localMediaData = this.g.b();
    if ((localMediaData.downloader == null) || (localMediaData.downloader.g == null))
    {
      Log.e("MediaViewStreamingVideoPlayer/download not in progress or download context missing");
      throw new IllegalStateException("download not in progress or download context missing");
    }
    this.o = localMediaData.downloader.g;
    super.j();
    if (this.o.g() == null) {
      throw new IllegalStateException("download file is null");
    }
    this.o.a(this.s);
    this.o.b();
    if (!this.r)
    {
      b.a.a.c.a().a(this, false);
      this.r = true;
    }
  }
  
  protected final f.a k()
  {
    return new com.whatsapp.h.b(this.o);
  }
  
  protected final Uri l()
  {
    return Uri.fromFile(this.o.g());
  }
  
  public final void m()
  {
    if ((this.g.b().downloader == null) || (this.g.b().downloader.g == null) || (this.g.b().downloader.g.d() == a.b.d))
    {
      ExoPlaybackControlView localExoPlaybackControlView = this.k;
      if (localExoPlaybackControlView != null)
      {
        if (x()) {
          break label121;
        }
        localExoPlaybackControlView.b();
      }
      for (;;)
      {
        this.l = true;
        if (localExoPlaybackControlView != null)
        {
          localExoPlaybackControlView.setDuration(this.g.w * 1000);
          localExoPlaybackControlView.setPlayButtonClickListener(new g(this));
          localExoPlaybackControlView.setSeekbarStartTrackingTouchListener(new h(this));
        }
        return;
        label121:
        localExoPlaybackControlView.c();
      }
    }
    if ((this.g.b().downloader != null) && (this.g.b().downloader.g != this.o))
    {
      Log.d("VideoPlayerStreamingOnExoPlayer/reset download context");
      if (this.o != null) {
        this.o.b(this.s);
      }
    }
    if ((this.q == null) && (this.m))
    {
      this.q = new aqb(this.g, this.o, this.g.b().downloader.e);
      this.q.a();
    }
    j();
    super.m();
    this.f.a(this.o.f(), this.o.m());
  }
  
  public final void n()
  {
    if (this.r)
    {
      b.a.a.c.a().a(this);
      this.r = false;
    }
    if (this.q != null)
    {
      this.q.f();
      l.a(this.h, this.q.a(2, this.n));
      l.a(this.h, this.q.g());
      this.q = null;
    }
  }
  
  public final void o()
  {
    if (this.q != null) {
      this.q.e();
    }
  }
  
  public final void onEvent(com.whatsapp.g.f paramf)
  {
    if ((!this.h.isFinishing()) && (this.i != null) && (paramf.a) && (this.o.d() == a.b.d) && (this.o.l()))
    {
      Log.i("MediaViewStreamingVideoPlayer/auto-retry");
      B();
    }
  }
  
  public final void p()
  {
    if (this.q != null) {
      this.q.d();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/videoplayback/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */