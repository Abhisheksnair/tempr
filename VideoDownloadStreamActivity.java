package com.whatsapp;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.google.android.exoplayer2.c.a;
import com.google.android.exoplayer2.d.b.a;
import com.google.android.exoplayer2.d.d.b;
import com.google.android.exoplayer2.g.e;
import com.google.android.exoplayer2.g.e.a;
import com.google.android.exoplayer2.h;
import com.google.android.exoplayer2.i.p;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.n;
import com.google.android.exoplayer2.n.b;
import com.whatsapp.g.f;
import com.whatsapp.m.a;
import com.whatsapp.m.a.a;
import com.whatsapp.m.a.b;
import com.whatsapp.m.a.c;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;
import com.whatsapp.videoplayback.ExoPlaybackControlView;
import com.whatsapp.videoplayback.ExoPlaybackControlView.a;
import com.whatsapp.videoplayback.ExoPlayerErrorFrame;
import com.whatsapp.videoplayback.ExoPlayerView;

public class VideoDownloadStreamActivity
  extends nh
  implements c.a, a.c
{
  public static final boolean n;
  private static final com.google.android.exoplayer2.h.d q;
  private boolean A;
  private int B;
  private long C;
  private final aoj D = aoj.a();
  private final com.whatsapp.data.l E = com.whatsapp.data.l.a();
  private AudioManager.OnAudioFocusChangeListener F;
  private aqb G;
  private int H;
  a o;
  ExoPlayerView p;
  private j r;
  private MediaData s;
  private Handler t;
  private ExoPlaybackControlView u;
  private com.google.android.exoplayer2.h.f.a v;
  private m w;
  private e x;
  private boolean y;
  private boolean z;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (boolean bool = true;; bool = false)
    {
      n = bool;
      q = new com.google.android.exoplayer2.h.d();
      return;
    }
  }
  
  private static float a(Context paramContext, float paramFloat)
  {
    return paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F;
  }
  
  public static Intent a(j paramj, Context paramContext, int paramInt)
  {
    paramContext = new Intent(paramContext, VideoDownloadStreamActivity.class);
    paramContext.putExtra("key", new FMessageKey(paramj.e));
    paramContext.putExtra("video_play_origin", paramInt);
    return paramContext;
  }
  
  private boolean o()
  {
    this.s = this.r.b();
    if ((this.s.downloader == null) || (this.s.downloader.g == null))
    {
      Log.e("VideoDownloadStreamActivity/download not in progress or download context missing");
      finish();
      return false;
    }
    this.o = this.r.b().downloader.g;
    this.v = new com.whatsapp.h.b(this.o);
    if (this.o.g() == null) {
      throw new IllegalStateException("download file is null");
    }
    if (this.o.d() == a.b.d) {
      a(this.o.m(), this.o.l());
    }
    this.o.a(this);
    return true;
  }
  
  private void p()
  {
    if (this.w != null)
    {
      this.z = this.w.b();
      this.A = false;
      Object localObject = this.w.e();
      if ((localObject != null) && (!((n)localObject).a()))
      {
        this.B = this.w.f();
        localObject = ((n)localObject).a(this.B, new n.b());
        if (!((n.b)localObject).e)
        {
          this.A = true;
          if (!((n.b)localObject).d) {
            break label143;
          }
        }
      }
    }
    label143:
    for (long l = this.w.h();; l = -9223372036854775807L)
    {
      this.C = l;
      this.w.d();
      this.w = null;
      this.p.b();
      this.x = null;
      ((AudioManager)getSystemService("audio")).abandonAudioFocus(q());
      return;
    }
  }
  
  private AudioManager.OnAudioFocusChangeListener q()
  {
    if (this.F == null) {
      this.F = apy.a();
    }
    return this.F;
  }
  
  public final void a(com.google.android.exoplayer2.b paramb)
  {
    Object localObject;
    if (paramb.a == 1)
    {
      localObject = paramb.a();
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
      Log.d("VideoDownloadStreamActivity/error in playback: " + (String)localObject, paramb);
      a(getResources().getString(2131296759), false);
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
  
  public final void a(a.a parama) {}
  
  public final void a(a parama)
  {
    this.t.post(apz.a(this));
  }
  
  final void a(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    Log.e("VideoDownloadStreamActivity/onError=" + paramString);
    String str = paramString;
    if (paramString == null) {
      str = getResources().getString(2131298049);
    }
    if (!paramBoolean)
    {
      this.y = true;
      this.s.streamViewable = false;
      p();
      if (!isFinishing())
      {
        paramString = new AlertDialog.Builder(this);
        paramString.setMessage(str).setTitle(2131296692).setPositiveButton(2131296768, aqa.a(this));
        paramString.create().show();
      }
    }
    if (this.G != null)
    {
      paramString = this.G;
      if (paramBoolean) {
        break label132;
      }
    }
    label132:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      paramString.b(paramBoolean);
      return;
    }
  }
  
  public final void a(boolean paramBoolean, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("videodownloadstream/statechange/");
    String str;
    switch (paramInt)
    {
    default: 
      str = "none";
      localStringBuilder = localStringBuilder.append(str).append(" ");
      if (paramBoolean)
      {
        str = "playing";
        label70:
        Log.d(str + " " + this.r.e);
        if (paramInt != 3) {
          break label180;
        }
        this.G.a(paramBoolean);
        if ((paramBoolean) && (this.z))
        {
          this.z = false;
          if (this.u != null) {
            this.u.a(500);
          }
        }
      }
      break;
    }
    label180:
    do
    {
      return;
      str = "idle";
      break;
      str = "ready";
      break;
      str = "buffering";
      break;
      str = "ended";
      break;
      str = "paused";
      break label70;
      if (paramInt == 4)
      {
        this.G.c();
        return;
      }
    } while (paramInt != 2);
    this.G.b();
  }
  
  public final void b(a parama) {}
  
  public final void c() {}
  
  final void l()
  {
    if (!this.o.f()) {}
    do
    {
      return;
      if (this.r.p == null) {
        throw new IllegalStateException("cannot retry download on message with null url, key=" + this.r.e);
      }
      if (this.o != null) {
        this.o.b(this);
      }
      this.D.a(this, this.r);
    } while (!o());
    this.o.b();
    if (this.w == null)
    {
      m();
      return;
    }
    Object localObject = Uri.fromFile(this.o.g());
    this.p.a(this.o.f(), this.o.m());
    localObject = new com.google.android.exoplayer2.e.b((Uri)localObject, this.v, new com.google.android.exoplayer2.c.c(), this.t);
    this.w.a((com.google.android.exoplayer2.e.b)localObject, false, false);
    this.y = false;
  }
  
  final void m()
  {
    boolean bool = true;
    com.google.android.exoplayer2.e.b localb;
    m localm;
    if (this.w == null)
    {
      this.x = new com.google.android.exoplayer2.g.c(new com.google.android.exoplayer2.g.f.a(q));
      this.w = a.a.a.a.d.a(this, this.x, new h());
      this.w.a(this);
      this.p.setMessage(this.r);
      this.p.setPlayer(this.w);
      this.p.a(this.o.f(), this.o.m());
      if (this.A)
      {
        if (this.C == -9223372036854775807L) {
          this.w.a(this.B);
        }
      }
      else
      {
        this.w.a(this.z);
        this.y = true;
      }
    }
    else if (this.y)
    {
      localb = new com.google.android.exoplayer2.e.b(Uri.fromFile(this.o.g()), this.v, new com.google.android.exoplayer2.c.c(), this.t);
      localm = this.w;
      if (this.A) {
        break label247;
      }
    }
    for (;;)
    {
      localm.a(localb, bool, false);
      this.y = false;
      ((AudioManager)getSystemService("audio")).requestAudioFocus(q(), 3, 2);
      return;
      this.w.a(this.B, this.C);
      break;
      label247:
      bool = false;
    }
  }
  
  public final void m_() {}
  
  public final void n_()
  {
    e.a locala = this.x.a();
    if (locala != null)
    {
      if (locala.a(2) != 1) {
        break label43;
      }
      Log.i("VideoDownloadStreamActivity/unplayable video track");
      a(getResources().getString(2131296759), false);
    }
    label43:
    while (locala.a(1) != 1) {
      return;
    }
    Log.i("VideoDownloadStreamActivity/unplayable audio track");
    a(getResources().getString(2131296759), false);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    LinearLayout localLinearLayout = (LinearLayout)this.u.findViewById(2131756249);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localLinearLayout.getLayoutParams();
    if (paramConfiguration.orientation == 2)
    {
      localLayoutParams.bottomMargin = ((int)a(this, 15.0F));
      localLayoutParams.rightMargin = ((int)a(this, 48.0F));
    }
    for (localLayoutParams.leftMargin = ((int)a(this, 48.0F));; localLayoutParams.leftMargin = ((int)a(this, 4.0F)))
    {
      localLinearLayout.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.bottomMargin = ((int)a(this, 34.0F));
      localLayoutParams.rightMargin = ((int)a(this, 4.0F));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903394);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      Log.e("VideoDownloadStreamActivity/intent is null");
      finish();
      return;
    }
    if (!n)
    {
      Log.e("VideoDownloadStreamActivity/exoplayer not supported");
      finish();
      return;
    }
    FMessageKey localFMessageKey = (FMessageKey)paramBundle.getParcelableExtra("key");
    if (localFMessageKey != null)
    {
      this.r = this.E.a(localFMessageKey.a);
      if (this.r == null)
      {
        Log.e("VideoDownloadStreamActivity/message not found");
        finish();
      }
    }
    else
    {
      Log.e("VideoDownloadStreamActivity/message key not found in intent");
      finish();
      return;
    }
    this.H = pb.b(paramBundle.getIntExtra("video_play_origin", 5));
    this.z = true;
    this.t = new Handler();
    this.p = ((ExoPlayerView)findViewById(2131756171));
    this.u = ((ExoPlaybackControlView)findViewById(2131756172));
    this.p.setController(this.u);
    paramBundle = new com.whatsapp.videoplayback.d((ExoPlayerErrorFrame)findViewById(2131755939), this.u);
    paramBundle.a(apx.a(this));
    this.p.setExoPlayerErrorActionsController(paramBundle);
    this.p.requestFocus();
    this.p.setBackpressListener(new ExoPlaybackControlView.a(this));
    if (Build.VERSION.SDK_INT >= 19)
    {
      getWindow().setFlags(134217728, 134217728);
      getWindow().setFlags(67108864, 67108864);
    }
    b.a.a.c.a().a(this, false);
    if (o())
    {
      this.G = new aqb(this.r, this.o, this.s.downloader.e);
      this.G.a();
    }
    onConfigurationChanged(getResources().getConfiguration());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.G != null)
    {
      this.G.f();
      com.whatsapp.fieldstats.l.a(this, this.G.a(3, this.H));
      com.whatsapp.fieldstats.l.a(this, this.G.g());
    }
    if (this.o != null) {
      this.o.b(this);
    }
    this.p.a();
    b.a.a.c.a().a(this);
  }
  
  public void onEvent(f paramf)
  {
    if ((!isFinishing()) && (this.w != null) && (paramf.a) && (this.o.d() == a.b.d) && (this.o.l()))
    {
      Log.i("VideoDownloadStreamActivity/auto-retry");
      l();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    p();
    this.A = false;
    setIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (!isFinishing()) {
      this.G.e();
    }
    if (p.a <= 23) {
      p();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
    {
      m();
      return;
    }
    finish();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((p.a <= 23) || (this.w == null)) {
      m();
    }
    this.G.d();
  }
  
  public void onStart()
  {
    super.onStart();
    if (p.a > 23) {
      m();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (p.a > 23) {
      p();
    }
  }
  
  public final void x_() {}
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/VideoDownloadStreamActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */