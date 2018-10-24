package com.whatsapp;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;

public final class atq
  implements Animation.AnimationListener
{
  public atq(AnimationSet paramAnimationSet, View paramView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setStartOffset(1500L);
    this.b.startAnimation(this.a);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/atq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */