package com.whatsapp;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@TargetApi(11)
public class AnimatingArrowsLayout
  extends LinearLayout
{
  List<View> a;
  final AnimatorSet b = new AnimatorSet();
  
  public AnimatingArrowsLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AnimatingArrowsLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    int i = 0;
    super.onFinishInflate();
    this.a = Arrays.asList(new View[] { getChildAt(3), getChildAt(2), getChildAt(1), getChildAt(0) });
    ArrayList localArrayList = new ArrayList(4);
    while (i < 4)
    {
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.a.get(i), "alpha", new float[] { 0.0F, 0.6F, 0.0F });
      localObjectAnimator.setDuration(750L);
      localObjectAnimator.setStartDelay(i * 100);
      localArrayList.add(localObjectAnimator);
      i += 1;
    }
    this.b.playTogether(localArrayList);
    this.b.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AnimatingArrowsLayout.this.post(t.a(this));
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    this.b.start();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/AnimatingArrowsLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */