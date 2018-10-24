package com.whatsapp;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout.LayoutParams;

public final class atp
  implements Animation.AnimationListener
{
  public atp(RelativeLayout.LayoutParams paramLayoutParams, float paramFloat, View paramView) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    this.c.setLayoutParams(this.a);
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    paramAnimation = this.a;
    paramAnimation.topMargin = ((int)(paramAnimation.topMargin + this.b / 2.0F));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/atp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */