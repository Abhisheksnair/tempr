package com.whatsapp.n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.graphics.Outline;
import android.transition.PathMotion;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import java.util.Map;

@TargetApi(21)
public final class a
  extends Transition
{
  private static final String[] c = { "circleTransition:transforms" };
  private final boolean a;
  private final boolean b;
  
  public a(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramBoolean1;
    this.b = paramBoolean2;
  }
  
  private static void a(TransitionValues paramTransitionValues)
  {
    View localView = paramTransitionValues.view;
    paramTransitionValues.values.put("circleTransition:transforms", new a(localView));
  }
  
  public final void captureEndValues(TransitionValues paramTransitionValues)
  {
    View localView = paramTransitionValues.view;
    if ((localView.getWidth() <= 0) || (localView.getHeight() <= 0)) {
      return;
    }
    a(paramTransitionValues);
  }
  
  public final void captureStartValues(TransitionValues paramTransitionValues)
  {
    View localView = paramTransitionValues.view;
    if ((localView.getWidth() <= 0) || (localView.getHeight() <= 0)) {
      return;
    }
    a(paramTransitionValues);
  }
  
  public final Animator createAnimator(ViewGroup paramViewGroup, final TransitionValues paramTransitionValues1, final TransitionValues paramTransitionValues2)
  {
    if ((paramTransitionValues1 == null) || (paramTransitionValues2 == null)) {
      return null;
    }
    Object localObject1 = (a)paramTransitionValues1.values.get("circleTransition:transforms");
    paramTransitionValues1 = (a)paramTransitionValues2.values.get("circleTransition:transforms");
    if ((localObject1 == null) || (paramTransitionValues1 == null) || (((a)localObject1).equals(paramTransitionValues1))) {
      return null;
    }
    float f1 = -paramTransitionValues1.g + ((a)localObject1).g + (((a)localObject1).e * ((a)localObject1).c - paramTransitionValues1.e * paramTransitionValues1.c) / 2.0F + ((a)localObject1).a;
    float f2 = -paramTransitionValues1.h + ((a)localObject1).h + (((a)localObject1).f * ((a)localObject1).d - paramTransitionValues1.f * paramTransitionValues1.d) / 2.0F + ((a)localObject1).b;
    paramViewGroup = getPathMotion().getPath(f1, f2, paramTransitionValues1.a, paramTransitionValues1.b);
    paramViewGroup = ObjectAnimator.ofFloat(paramTransitionValues2.view, View.TRANSLATION_X, View.TRANSLATION_Y, paramViewGroup);
    paramTransitionValues2.view.setTranslationX(f1);
    paramTransitionValues2.view.setTranslationY(f2);
    f1 = ((a)localObject1).e * ((a)localObject1).c / paramTransitionValues1.e;
    f2 = ((a)localObject1).f;
    f1 = Math.min(f1, ((a)localObject1).d * f2 / paramTransitionValues1.f);
    localObject1 = ObjectAnimator.ofFloat(paramTransitionValues2.view, View.SCALE_X, new float[] { f1, paramTransitionValues1.c });
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(paramTransitionValues2.view, View.SCALE_Y, new float[] { f1, paramTransitionValues1.d });
    f1 = Math.min(paramTransitionValues1.e, paramTransitionValues1.f) / 2;
    f2 = (float)(Math.sqrt(paramTransitionValues1.e * paramTransitionValues1.e + paramTransitionValues1.f * paramTransitionValues1.f) / 2.0D);
    Object localObject2 = paramTransitionValues2.view;
    int i = paramTransitionValues1.e / 2;
    int j = paramTransitionValues1.f / 2;
    float f3;
    if (this.a)
    {
      f3 = f1;
      if (!this.b) {
        break label531;
      }
    }
    for (;;)
    {
      localObject2 = new b(ViewAnimationUtils.createCircularReveal((View)localObject2, i, j, f3, f1));
      paramTransitionValues2.view.setAlpha(0.0F);
      ((Animator)localObject2).addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          paramTransitionValues2.view.setAlpha(1.0F);
        }
      });
      if (this.b)
      {
        paramTransitionValues1 = new ViewOutlineProvider()
        {
          @TargetApi(21)
          public final void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
          {
            paramAnonymousOutline.setOval(0, 0, paramTransitionValues1.e, paramTransitionValues1.f);
          }
        };
        paramTransitionValues2.view.setOutlineProvider(paramTransitionValues1);
        paramTransitionValues2.view.setClipToOutline(true);
        paramTransitionValues2.view.invalidateOutline();
      }
      paramTransitionValues1 = new AnimatorSet();
      paramTransitionValues1.playTogether(new Animator[] { paramViewGroup, localObject2, localObject1, localObjectAnimator });
      paramTransitionValues1.setInterpolator(getInterpolator());
      return paramTransitionValues1;
      f3 = f2;
      break;
      label531:
      f1 = f2;
    }
  }
  
  public final String[] getTransitionProperties()
  {
    return c;
  }
  
  static final class a
  {
    final float a;
    final float b;
    final float c;
    final float d;
    final int e;
    final int f;
    final int g;
    final int h;
    
    public a(View paramView)
    {
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      this.g = arrayOfInt[0];
      this.h = arrayOfInt[1];
      this.a = paramView.getTranslationX();
      this.b = paramView.getTranslationY();
      this.c = paramView.getScaleX();
      this.d = paramView.getScaleY();
      this.e = paramView.getWidth();
      this.f = paramView.getHeight();
    }
    
    public final boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a)) {}
      do
      {
        return false;
        paramObject = (a)paramObject;
      } while ((((a)paramObject).a != this.a) || (((a)paramObject).b != this.b) || (((a)paramObject).c != this.c) || (((a)paramObject).d != this.d) || (((a)paramObject).e != this.e) || (((a)paramObject).f != this.f) || (((a)paramObject).g != this.g) || (((a)paramObject).h != this.h));
      return true;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/n/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */