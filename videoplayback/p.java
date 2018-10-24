package com.whatsapp.videoplayback;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.google.android.exoplayer2.c.a;
import com.google.android.exoplayer2.d.b.a;
import com.google.android.exoplayer2.d.d.b;
import com.google.android.exoplayer2.g.e;
import com.google.android.exoplayer2.g.e.a;
import com.google.android.exoplayer2.h;
import com.google.android.exoplayer2.h.k;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.n;
import com.google.android.exoplayer2.n.b;
import com.whatsapp.MediaData;
import com.whatsapp.MediaView;
import com.whatsapp.PhotoView;
import com.whatsapp.fieldstats.events.bv;
import com.whatsapp.fieldstats.l;
import com.whatsapp.k.i;
import com.whatsapp.nh;
import com.whatsapp.pb;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.pv;
import com.whatsapp.util.Log;
import java.io.File;
import java.lang.invoke.LambdaForm.Hidden;
import java.net.URI;

@TargetApi(16)
public class p
  extends o
{
  private static final com.google.android.exoplayer2.h.d o = new com.google.android.exoplayer2.h.d();
  protected final pv a = pv.a();
  final Handler b = new Handler(Looper.getMainLooper());
  protected final ExoPlayerView f;
  protected final j g;
  protected final nh h;
  m i;
  public a j;
  public ExoPlaybackControlView k;
  public boolean l = false;
  protected boolean m = false;
  public int n;
  private final i p = new i();
  private com.google.android.exoplayer2.h.f.a q;
  private e r;
  private boolean s = false;
  private boolean t = false;
  private int u;
  private long v;
  private AudioManager.OnAudioFocusChangeListener w;
  private final c.a x = new c.a()
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
        Log.d("VideoPlayerNonStreamingOnExoPlayerView/error in playback: " + (String)localObject, paramAnonymousb);
        p.this.a(p.this.f.getContext().getResources().getString(2131296759), true);
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
      if (p.a(p.this) != null) {
        p.a(p.this).a(paramAnonymousBoolean, paramAnonymousInt);
      }
      p.this.a(paramAnonymousBoolean, paramAnonymousInt);
      if ((paramAnonymousInt == 3) && (paramAnonymousBoolean) && (p.this.m))
      {
        p.this.m = false;
        if (p.b(p.this) != null) {
          p.b(p.this).a(500);
        }
      }
      if (((paramAnonymousInt == 3) || (paramAnonymousInt == 4)) && (!this.a))
      {
        this.a = true;
        p.this.w();
      }
      if ((paramAnonymousInt == 4) && (!this.b))
      {
        this.b = true;
        p.this.v();
      }
    }
    
    public final void c() {}
    
    public final void m_() {}
    
    public final void n_()
    {
      Log.d("VideoPlayerNonStreamingOnExoPlayerView/track selection changed");
      e.a locala = p.c(p.this).a();
      if (locala != null)
      {
        if (locala.a(2) != 1) {
          break label61;
        }
        Log.i("VideoPlayerNonStreamingOnExoPlayerView/unplayable video track");
        p.this.a(p.this.f.getContext().getResources().getString(2131296759), true);
      }
      label61:
      while (locala.a(1) != 1) {
        return;
      }
      Log.i("VideoPlayerNonStreamingOnExoPlayerView/unplayable audio track");
      p.this.a(p.this.f.getContext().getResources().getString(2131296759), true);
    }
  };
  
  public p(nh paramnh, j paramj)
  {
    Log.d("VideoPlayerNonStreamingOnExoPlayerView/constructor=" + paramj.e.c);
    this.g = paramj;
    this.h = paramnh;
    this.f = new ExoPlayerView(paramnh);
    this.f.setMessage(paramj);
    paramnh = this.f;
    paramnh.a.setVisibility(8);
    paramnh.b = false;
  }
  
  private void q()
  {
    if (this.i == null)
    {
      this.r = new com.google.android.exoplayer2.g.c(new com.google.android.exoplayer2.g.f.a(o));
      this.i = a.a.a.a.d.a(this.f.getContext(), this.r, new h());
      this.i.a(this.x);
      this.f.setPlayer(this.i);
      if (this.s)
      {
        if (this.v != -9223372036854775807L) {
          break label105;
        }
        this.i.a(this.u);
      }
    }
    return;
    label105:
    this.i.a(this.u, this.v);
  }
  
  private void r()
  {
    ((AudioManager)this.h.getSystemService("audio")).requestAudioFocus(s(), 3, 2);
  }
  
  private AudioManager.OnAudioFocusChangeListener s()
  {
    if (this.w == null) {
      this.w = t.a();
    }
    return this.w;
  }
  
  public final View a()
  {
    return this.f;
  }
  
  public final void a(int paramInt)
  {
    if (this.i != null) {
      this.i.a(paramInt);
    }
  }
  
  protected void a(com.google.android.exoplayer2.e.b paramb)
  {
    if (this.k != null)
    {
      this.k.setPlayButtonClickListener(null);
      this.k.setSeekbarStartTrackingTouchListener(null);
    }
    q();
    this.t = true;
    if ((this.i != null) && (this.i.a() == 1)) {
      this.i.a(paramb);
    }
    r();
  }
  
  public final void a(ExoPlaybackControlView paramExoPlaybackControlView)
  {
    this.k = paramExoPlaybackControlView;
    this.f.a(paramExoPlaybackControlView, false);
  }
  
  public void a(d paramd)
  {
    this.f.setExoPlayerErrorActionsController(paramd);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    Log.e("VideoPlayerNonStreamingOnExoPlayerView/onError=" + paramString);
    if (!paramBoolean)
    {
      this.g.b().streamViewable = false;
      d();
    }
    b(paramString, paramBoolean);
  }
  
  public final void a(boolean paramBoolean)
  {
    m localm;
    if (this.i != null)
    {
      localm = this.i;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (float f1 = 0.0F;; f1 = 1.0F)
    {
      localm.a(f1);
      return;
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (paramInt == 3) {
      if (paramBoolean) {
        this.p.a();
      }
    }
    while ((paramInt != 1) && (paramInt != 4) && (paramInt != 2))
    {
      return;
      this.p.b();
      return;
    }
    this.p.b();
  }
  
  public final void b()
  {
    Log.d("VideoPlayerNonStreamingOnExoPlayerView/start");
    this.m = true;
    m();
  }
  
  public final void c()
  {
    if (this.i != null) {
      this.i.a(false);
    }
  }
  
  public void d()
  {
    Log.d("VideoPlayerNonStreamingOnExoPlayerView/stop");
    this.l = false;
    Object localObject;
    if (this.i != null)
    {
      this.i.a(false);
      this.m = this.i.b();
      this.s = false;
      localObject = this.i.e();
      if ((localObject != null) && (!((n)localObject).a()))
      {
        this.u = this.i.f();
        localObject = ((n)localObject).a(this.u, new n.b());
        if (!((n.b)localObject).e)
        {
          this.s = true;
          if (!((n.b)localObject).d) {
            break label219;
          }
        }
      }
    }
    label219:
    for (long l1 = this.i.h();; l1 = -9223372036854775807L)
    {
      this.v = l1;
      this.i.d();
      if (this.j != null) {
        this.j.a(false, 1);
      }
      this.i = null;
      this.f.b();
      this.r = null;
      if (this.k != null)
      {
        this.k.setPlayer(null);
        localObject = this.k;
        ((ExoPlaybackControlView)localObject).removeCallbacks(((ExoPlaybackControlView)localObject).d);
        ((ExoPlaybackControlView)localObject).removeCallbacks(((ExoPlaybackControlView)localObject).c);
      }
      ((AudioManager)this.h.getSystemService("audio")).abandonAudioFocus(s());
      return;
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
    if (this.i != null)
    {
      int i1 = this.i.a();
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
    return this.l;
  }
  
  public final int h()
  {
    if (this.i != null) {
      return (int)this.i.g();
    }
    return 0;
  }
  
  public final int i()
  {
    if (this.i != null) {
      return (int)this.i.h();
    }
    return 0;
  }
  
  public void j()
  {
    if (this.q == null) {
      this.q = k();
    }
  }
  
  protected com.google.android.exoplayer2.h.f.a k()
  {
    return new k(this.h, com.google.android.exoplayer2.i.p.a(this.h, this.h.getString(2131298233)));
  }
  
  protected Uri l()
  {
    return Uri.parse(this.g.b().file.toURI().toString());
  }
  
  public void m()
  {
    Log.d("VideoPlayerNonStreamingOnExoPlayerView/initialize");
    if (this.i != null) {}
    com.google.android.exoplayer2.e.b localb;
    label148:
    do
    {
      return;
      if (this.k != null)
      {
        if (x()) {
          break label148;
        }
        this.k.b();
      }
      for (;;)
      {
        this.l = true;
        q();
        if (this.k != null) {
          this.k.setDuration(this.g.w * 1000);
        }
        localb = new com.google.android.exoplayer2.e.b(l(), this.q, new com.google.android.exoplayer2.c.c(), this.b);
        if (!this.m) {
          break;
        }
        this.i.a(true);
        if (this.k != null)
        {
          this.k.setPlayButtonClickListener(null);
          this.k.setSeekbarStartTrackingTouchListener(null);
        }
        this.a.a(q.a(this, localb));
        return;
        this.k.c();
      }
      this.i.a(false);
    } while (this.k == null);
    this.k.setPlayButtonClickListener(new r(this, localb));
    this.k.setSeekbarStartTrackingTouchListener(new s(this, localb));
  }
  
  public void n()
  {
    bv localbv;
    if (this.t)
    {
      localbv = new bv();
      if (!this.g.e.b) {
        break label197;
      }
    }
    label197:
    for (int i1 = 3;; i1 = 1)
    {
      localbv.e = Integer.valueOf(i1);
      localbv.h = Integer.valueOf(2);
      localbv.c = Long.valueOf(this.p.a / 1000L);
      this.p.c();
      if (this.g.b().file != null) {
        localbv.d = Long.valueOf((System.currentTimeMillis() - this.g.b().file.lastModified()) / 1000L);
      }
      localbv.a = Long.valueOf(this.g.w);
      localbv.b = Double.valueOf(this.g.t);
      localbv.i = Integer.valueOf(this.n);
      Log.d("VideoPlayerNonStreamingOnExoPlayerView/" + pb.a(localbv));
      l.a(this.h, localbv);
      this.t = false;
      this.p.c();
      return;
    }
  }
  
  public void o()
  {
    this.p.b();
  }
  
  public void p() {}
  
  final boolean x()
  {
    return (this.h.getWindow().getDecorView().getSystemUiVisibility() & 0x4) == 0;
  }
  
  public final j y()
  {
    return this.g;
  }
  
  public static final class a
  {
    public final MediaView a;
    public final PhotoView b;
    
    public a(MediaView paramMediaView, PhotoView paramPhotoView)
    {
      this.a = paramMediaView;
      this.b = paramPhotoView;
    }
    
    @LambdaForm.Hidden
    public final void a(boolean paramBoolean, int paramInt)
    {
      MediaView localMediaView = this.a;
      PhotoView localPhotoView = this.b;
      if (paramInt == 3)
      {
        localPhotoView.setVisibility(8);
        if ((paramBoolean) && (!localMediaView.A) && (MediaView.n) && ((localMediaView.getWindow().getDecorView().getSystemUiVisibility() & 0x2) == 0))
        {
          paramInt = localMediaView.getWindow().getDecorView().getSystemUiVisibility();
          localMediaView.getWindow().getDecorView().setSystemUiVisibility(paramInt | 0x2);
        }
      }
      while (paramInt != 1) {
        return;
      }
      localPhotoView.setVisibility(0);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/videoplayback/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */