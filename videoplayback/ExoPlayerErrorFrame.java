package com.whatsapp.videoplayback;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.whatsapp.CircularProgressBar;

@TargetApi(16)
public final class ExoPlayerErrorFrame
  extends FrameLayout
{
  final FrameLayout a;
  FrameLayout b;
  TextView c;
  View.OnClickListener d;
  View e;
  private final CircularProgressBar f;
  
  public ExoPlayerErrorFrame(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExoPlayerErrorFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExoPlayerErrorFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = ((FrameLayout)LayoutInflater.from(paramContext).inflate(2130903401, this));
    this.f = ((CircularProgressBar)findViewById(2131756246));
  }
  
  public final void a()
  {
    if (this.b != null) {
      this.b.setVisibility(8);
    }
  }
  
  public final int getErrorScreenVisibility()
  {
    if (this.b != null) {
      return this.b.getVisibility();
    }
    return 8;
  }
  
  public final void setLoadingViewVisibility(int paramInt)
  {
    this.f.setVisibility(paramInt);
  }
  
  public final void setOnRetryListener(View.OnClickListener paramOnClickListener)
  {
    this.d = paramOnClickListener;
    if (this.e != null) {
      this.e.setOnClickListener(this.d);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/videoplayback/ExoPlayerErrorFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */