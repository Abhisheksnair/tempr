package com.whatsapp.n;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.Animator.AnimatorPauseListener;
import android.animation.TimeInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends Animator
  implements Animator.AnimatorListener
{
  private Animator a;
  private ArrayList<Animator.AnimatorListener> b;
  
  public b(Animator paramAnimator)
  {
    this.a = paramAnimator;
    this.a.addListener(this);
  }
  
  private b a()
  {
    b localb = (b)super.clone();
    if (this.b != null)
    {
      ArrayList localArrayList = this.b;
      localb.b = new ArrayList();
      localb.b.addAll(localArrayList);
    }
    return localb;
  }
  
  public final void addListener(Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.add(paramAnimatorListener);
  }
  
  public final void addPauseListener(Animator.AnimatorPauseListener paramAnimatorPauseListener) {}
  
  public final void cancel()
  {
    this.a.cancel();
  }
  
  public final void end()
  {
    this.a.end();
  }
  
  public final long getDuration()
  {
    return this.a.getDuration();
  }
  
  public final TimeInterpolator getInterpolator()
  {
    return this.a.getInterpolator();
  }
  
  public final ArrayList<Animator.AnimatorListener> getListeners()
  {
    return this.b;
  }
  
  public final long getStartDelay()
  {
    return this.a.getStartDelay();
  }
  
  public final boolean isPaused()
  {
    return this.a.isPaused();
  }
  
  public final boolean isRunning()
  {
    return this.a.isRunning();
  }
  
  public final boolean isStarted()
  {
    return this.a.isStarted();
  }
  
  public final void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = ((ArrayList)this.b.clone()).iterator();
    while (paramAnimator.hasNext()) {
      ((Animator.AnimatorListener)paramAnimator.next()).onAnimationCancel(this);
    }
  }
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = ((ArrayList)this.b.clone()).iterator();
    while (paramAnimator.hasNext()) {
      ((Animator.AnimatorListener)paramAnimator.next()).onAnimationEnd(this);
    }
  }
  
  public final void onAnimationRepeat(Animator paramAnimator)
  {
    paramAnimator = ((ArrayList)this.b.clone()).iterator();
    while (paramAnimator.hasNext()) {
      ((Animator.AnimatorListener)paramAnimator.next()).onAnimationRepeat(this);
    }
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = ((ArrayList)this.b.clone()).iterator();
    while (paramAnimator.hasNext()) {
      ((Animator.AnimatorListener)paramAnimator.next()).onAnimationStart(this);
    }
  }
  
  public final void pause() {}
  
  public final void removeAllListeners()
  {
    if (this.b != null)
    {
      this.b.clear();
      this.b = null;
    }
  }
  
  public final void removeListener(Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.b != null)
    {
      this.b.remove(paramAnimatorListener);
      if (this.b.isEmpty()) {
        this.b = null;
      }
    }
  }
  
  public final void removePauseListener(Animator.AnimatorPauseListener paramAnimatorPauseListener) {}
  
  public final void resume() {}
  
  public final Animator setDuration(long paramLong)
  {
    this.a.setDuration(paramLong);
    return this;
  }
  
  public final void setInterpolator(TimeInterpolator paramTimeInterpolator)
  {
    this.a.setInterpolator(paramTimeInterpolator);
  }
  
  public final void setStartDelay(long paramLong)
  {
    this.a.setStartDelay(paramLong);
  }
  
  public final void setTarget(Object paramObject)
  {
    this.a.setTarget(paramObject);
  }
  
  public final void setupEndValues()
  {
    this.a.setupEndValues();
  }
  
  public final void setupStartValues()
  {
    this.a.setupStartValues();
  }
  
  public final void start()
  {
    this.a.start();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/n/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */