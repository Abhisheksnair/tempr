package com.whatsapp.videoplayback;

import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;

public final class d
{
  final ExoPlayerErrorFrame a;
  final ExoPlaybackControlView b;
  private final Handler c = new Handler();
  private a d;
  
  public d(ExoPlayerErrorFrame paramExoPlayerErrorFrame, ExoPlaybackControlView paramExoPlaybackControlView)
  {
    this.a = paramExoPlayerErrorFrame;
    this.b = paramExoPlaybackControlView;
  }
  
  final void a()
  {
    this.a.setLoadingViewVisibility(0);
    this.a.a();
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnRetryListener(paramOnClickListener);
  }
  
  public final void a(String paramString)
  {
    if (this.d != null) {
      this.c.removeCallbacks(this.d);
    }
    for (;;)
    {
      this.a.setLoadingViewVisibility(0);
      this.c.postDelayed(this.d, 5000L);
      return;
      this.d = new a(paramString);
    }
  }
  
  public final void b()
  {
    this.a.setLoadingViewVisibility(8);
    if (this.d != null) {
      this.c.removeCallbacks(this.d);
    }
    if (this.a.getErrorScreenVisibility() == 0)
    {
      if (this.b != null) {
        this.b.setPlayControlVisibility(0);
      }
      this.a.a();
    }
  }
  
  final class a
    implements Runnable
  {
    final String a;
    
    a(String paramString)
    {
      this.a = paramString;
    }
    
    public final void run()
    {
      d.this.a.setLoadingViewVisibility(8);
      if (d.this.b != null) {
        d.this.b.setPlayControlVisibility(8);
      }
      ExoPlayerErrorFrame localExoPlayerErrorFrame = d.this.a;
      String str = this.a;
      if (str == null) {
        str = localExoPlayerErrorFrame.getResources().getString(2131298049);
      }
      for (;;)
      {
        if (localExoPlayerErrorFrame.b == null)
        {
          localExoPlayerErrorFrame.b = ((FrameLayout)LayoutInflater.from(localExoPlayerErrorFrame.getContext()).inflate(2130903402, null));
          localExoPlayerErrorFrame.a.addView(localExoPlayerErrorFrame.b);
          localExoPlayerErrorFrame.c = ((TextView)localExoPlayerErrorFrame.findViewById(2131755227));
          localExoPlayerErrorFrame.e = localExoPlayerErrorFrame.findViewById(2131755797);
          localExoPlayerErrorFrame.e.setOnClickListener(localExoPlayerErrorFrame.d);
        }
        localExoPlayerErrorFrame.c.setText(str);
        localExoPlayerErrorFrame.b.setVisibility(0);
        return;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/videoplayback/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */