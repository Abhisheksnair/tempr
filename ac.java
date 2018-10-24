package com.whatsapp;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.support.v4.content.b;
import android.view.Display;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;

public final class ac
  extends PopupWindow
{
  final FrameLayout a;
  final CircularRevealView b;
  private int c;
  private final pv d;
  private final WeakReference<Activity> e;
  private final FrameLayout.LayoutParams f;
  private final int g;
  private View h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private int n;
  private int o;
  private ViewTreeObserver.OnGlobalLayoutListener p = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      int[] arrayOfInt = new int[2];
      ac.a(ac.this).getLocationOnScreen(arrayOfInt);
      if (!ac.this.isShowing()) {
        ac.b(ac.this);
      }
      while (ac.c(ac.this) == arrayOfInt[0]) {
        return;
      }
      ac.b(ac.this);
      ac.a(ac.this).post(af.a(this));
    }
  };
  
  public ac(final Activity paramActivity, pv parampv)
  {
    super(paramActivity);
    this.d = parampv;
    this.e = new WeakReference(paramActivity);
    this.a = new FrameLayout(paramActivity)
    {
      int a = -1;
      
      protected final void onLayout(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        int i = paramActivity.getWindowManager().getDefaultDisplay().getOrientation();
        if ((this.a != -1) && (this.a != i))
        {
          if ((ac.h(ac.this)) || (ac.j(ac.this))) {
            break label100;
          }
          ac.k(ac.this);
          ac.m(ac.this).getViewTreeObserver().addOnGlobalLayoutListener(ac.l(ac.this));
        }
        for (;;)
        {
          this.a = i;
          super.onLayout(paramAnonymousBoolean, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
          return;
          label100:
          ac.d(ac.this);
        }
      }
    };
    this.a.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    al.a(parampv, paramActivity.getLayoutInflater(), 2130903086, this.a, true);
    this.b = ((CircularRevealView)this.a.findViewById(2131755339));
    this.f = ((FrameLayout.LayoutParams)this.b.getLayoutParams());
    this.g = this.b.getPaddingBottom();
    this.b.setVisibility(0);
    setContentView(this.a);
    setBackgroundDrawable(new BitmapDrawable());
    setWidth(-1);
    setHeight(-2);
    setAnimationStyle(0);
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(true);
    setInputMethodMode(2);
    setTouchInterceptor(ad.a(this, paramActivity));
  }
  
  private int a(View paramView)
  {
    if (this.j)
    {
      paramView = new int[2];
      this.h.getLocationOnScreen(paramView);
      int i1 = this.c;
      return paramView[0] + i1;
    }
    if (this.d.d()) {
      return paramView.getWidth() - this.c / 2;
    }
    return this.c / 2;
  }
  
  private static AnimationSet a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    float f6 = 0.0F;
    float f2;
    label16:
    float f3;
    label23:
    float f4;
    label30:
    float f5;
    label41:
    ScaleAnimation localScaleAnimation;
    if (paramBoolean2)
    {
      f1 = 0.0F;
      if (!paramBoolean2) {
        break label123;
      }
      f2 = 1.0F;
      if (!paramBoolean2) {
        break label129;
      }
      f3 = 0.0F;
      if (!paramBoolean2) {
        break label135;
      }
      f4 = 1.0F;
      float f7 = paramInt;
      if (!paramBoolean1) {
        break label141;
      }
      f5 = 1.0F;
      localScaleAnimation = new ScaleAnimation(f1, f2, f3, f4, 0, f7, 1, f5);
      if (!paramBoolean2) {
        break label147;
      }
    }
    label123:
    label129:
    label135:
    label141:
    label147:
    for (float f1 = f6;; f1 = 1.0F)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(f1, 1.0F - f1);
      AnimationSet localAnimationSet = new AnimationSet(true);
      localAnimationSet.addAnimation(localScaleAnimation);
      localAnimationSet.addAnimation(localAlphaAnimation);
      localAnimationSet.setDuration(300L);
      return localAnimationSet;
      f1 = 1.0F;
      break;
      f2 = 0.0F;
      break label16;
      f3 = 1.0F;
      break label23;
      f4 = 0.0F;
      break label30;
      f5 = 0.0F;
      break label41;
    }
  }
  
  private void a(Activity paramActivity, View paramView, final boolean paramBoolean1, boolean paramBoolean2, final boolean paramBoolean3, final int paramInt1, int paramInt2)
  {
    this.h = paramView;
    this.i = paramBoolean1;
    this.j = paramBoolean2;
    this.k = paramBoolean3;
    this.o = paramInt2;
    Object localObject = paramActivity.getWindowManager().getDefaultDisplay();
    this.l = false;
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i1 = arrayOfInt[1] + paramView.getHeight();
    this.n = arrayOfInt[0];
    if (paramBoolean3)
    {
      this.b.setPadding(this.b.getPaddingLeft(), this.b.getPaddingTop(), this.b.getPaddingRight(), 0);
      if ((((Display)localObject).getRotation() == 0) || (((Display)localObject).getRotation() == 2))
      {
        this.f.height = -1;
        this.b.findViewById(2131755340).getLayoutParams().height = (((Display)localObject).getHeight() - (i1 + paramInt2));
        showAtLocation(paramView, 8388661, 0, i1);
        this.b.forceLayout();
        this.b.setDuration(paramInt1);
        if ((paramBoolean3) && (!this.l)) {
          break label752;
        }
        if ((((Display)localObject).getRotation() != 1) && (((Display)localObject).getRotation() != 3)) {
          break label705;
        }
        paramView = this.f;
        float f1 = paramActivity.getResources().getDimensionPixelSize(2131361822) + paramActivity.getResources().getDimensionPixelSize(2131361824) + paramActivity.getResources().getDimensionPixelSize(2131361823);
        float f2 = aoa.a().a;
        paramView.width = ((int)(((Display)localObject).getWidth() - (f1 + f2 * 4.0F) * 2.0F));
        paramView = this.f;
        this.f.rightMargin = 0;
        paramView.leftMargin = 0;
        label305:
        this.b.findViewById(2131755340).setBackgroundDrawable(b.a(paramActivity, 2130840034));
        this.b.setVisibility(0);
        this.b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            if (Build.VERSION.SDK_INT < 16) {
              ac.n(ac.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
            for (;;)
            {
              ac.o(ac.this);
              if ((Build.VERSION.SDK_INT >= 18) || ((paramBoolean3) && (!ac.p(ac.this)))) {
                break;
              }
              localObject = ac.this.getContentView().findViewById(2131755340);
              localObject = ac.a(ac.a(ac.this, (View)localObject), paramBoolean1);
              ((AnimationSet)localObject).setDuration(paramInt1);
              ac.n(ac.this).a((Animation)localObject);
              return;
              ac.n(ac.this).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            Object localObject = ac.n(ac.this);
            if (Build.VERSION.SDK_INT < 21)
            {
              ((CircularRevealView)localObject).clearAnimation();
              ((CircularRevealView)localObject).setWillNotDraw(false);
              ((CircularRevealView)localObject).setBackgroundColor(0);
              ((CircularRevealView)localObject).d = new CircularRevealView.a((CircularRevealView)localObject, false);
              ((CircularRevealView)localObject).d.setDuration(((CircularRevealView)localObject).a);
              ((CircularRevealView)localObject).startAnimation(((CircularRevealView)localObject).d);
              return;
            }
            ((CircularRevealView)localObject).setVisibility(0);
            int i = Math.max(((CircularRevealView)localObject).getWidth(), ((CircularRevealView)localObject).getHeight());
            Animator localAnimator = ViewAnimationUtils.createCircularReveal((View)localObject, ((CircularRevealView)localObject).b, paramInt1, 0.0F, i);
            localAnimator.setDuration(((CircularRevealView)localObject).a);
            localAnimator.start();
          }
        });
        if (paramBoolean2) {
          break label810;
        }
        if (this.d.d()) {
          break label860;
        }
        paramActivity = new int[2][];
        paramActivity[0] = { 0, 6, 3 };
        paramActivity[1] = { 6, 3, 2 };
      }
    }
    for (;;)
    {
      if (paramInt1 > 0)
      {
        a(this.a.findViewById(2131755341), paramInt1, paramActivity[0][0], paramBoolean1);
        a(this.a.findViewById(2131755343), paramInt1, paramActivity[0][1], paramBoolean1);
        a(this.a.findViewById(2131755345), paramInt1, paramActivity[0][2], paramBoolean1);
        a(this.a.findViewById(2131755347), paramInt1, paramActivity[1][0], paramBoolean1);
        a(this.a.findViewById(2131755349), paramInt1, paramActivity[1][1], paramBoolean1);
        a(this.a.findViewById(2131755351), paramInt1, paramActivity[1][2], paramBoolean1);
      }
      return;
      this.a.measure(0, 0);
      this.b.findViewById(2131755340).getLayoutParams().height = -2;
      this.f.height = -2;
      showAtLocation(paramView, 8388661, 0, ((Display)localObject).getHeight() / 2 - this.a.getMeasuredHeight() / 2);
      this.l = true;
      break;
      this.b.setPadding(this.b.getPaddingLeft(), this.b.getPaddingTop(), this.b.getPaddingRight(), this.g);
      this.b.findViewById(2131755340).getLayoutParams().height = -2;
      this.f.height = -2;
      if (Build.VERSION.SDK_INT >= 19)
      {
        showAsDropDown(paramView, 0, paramInt2, 8388661);
        break;
      }
      showAsDropDown(paramView, 0, paramInt2);
      break;
      label705:
      this.f.width = -1;
      paramView = this.f;
      localObject = this.f;
      paramInt2 = paramActivity.getResources().getDimensionPixelSize(2131361894);
      ((FrameLayout.LayoutParams)localObject).rightMargin = paramInt2;
      paramView.leftMargin = paramInt2;
      break label305;
      label752:
      this.f.width = -1;
      paramView = this.b;
      if (paramBoolean3) {}
      for (paramInt2 = 17170443;; paramInt2 = 2131623956)
      {
        paramView.setBackgroundColor(b.c(paramActivity, paramInt2));
        this.b.setColor(b.c(paramActivity, 2131623956));
        break;
      }
      label810:
      if (paramBoolean1)
      {
        paramActivity = new int[2][];
        paramActivity[0] = { 2, 3, 6 };
        paramActivity[1] = { 3, 6, 0 };
      }
      else
      {
        label860:
        paramActivity = new int[2][];
        paramActivity[0] = { 3, 6, 0 };
        paramActivity[1] = { 2, 3, 6 };
      }
    }
  }
  
  private static void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    float f1;
    if (paramBoolean)
    {
      f1 = 1.0F;
      localAnimationSet.addAnimation(new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, f1));
      localAnimationSet.setInterpolator(new OvershootInterpolator(1.0F));
      localAnimationSet.setDuration(300L);
      if (paramInt2 != 0) {
        break label88;
      }
    }
    label88:
    for (long l1 = 0L;; l1 = paramInt1 / paramInt2)
    {
      localAnimationSet.setStartOffset(l1);
      paramView.startAnimation(localAnimationSet);
      return;
      f1 = 0.0F;
      break;
    }
  }
  
  private void c()
  {
    if (!this.m) {
      return;
    }
    this.m = false;
    if (Build.VERSION.SDK_INT < 16)
    {
      this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this.p);
      return;
    }
    this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this.p);
  }
  
  private void d()
  {
    this.b.a();
    super.dismiss();
  }
  
  private void e()
  {
    int[] arrayOfInt1 = new int[2];
    this.h.getLocationOnScreen(arrayOfInt1);
    int[] arrayOfInt2 = new int[2];
    this.b.getLocationOnScreen(arrayOfInt2);
    int i1;
    if (this.j)
    {
      i1 = arrayOfInt1[0] + this.c - arrayOfInt2[0];
      if (this.i) {
        this.b.a(i1, this.a.getMeasuredHeight());
      }
    }
    for (;;)
    {
      if (this.l) {
        this.b.a(this.a.getMeasuredWidth() / 2, this.a.getMeasuredHeight() / 2);
      }
      return;
      this.b.a(i1, 0);
      continue;
      if (this.d.d()) {
        this.b.a(this.b.getRight() - this.c, 0);
      } else {
        this.b.a(this.b.getLeft() + this.c, 0);
      }
    }
  }
  
  public final void a()
  {
    c();
    d();
  }
  
  public final void a(Activity paramActivity, View paramView1, View paramView2)
  {
    Object localObject1 = paramActivity.getResources();
    Object localObject2 = new int[2];
    paramView2.getLocationOnScreen((int[])localObject2);
    int i1 = localObject2[1];
    int i2 = paramView2.getHeight();
    localObject2 = paramActivity.getWindowManager().getDefaultDisplay();
    if (((Display)localObject2).getHeight() - (i1 + i2) < 64.0F * aoa.a().a)
    {
      i1 = 1;
      this.c = (((Resources)localObject1).getDimensionPixelSize(2131361843) / 2);
      if (i1 == 0) {
        break label196;
      }
      paramView2 = new int[2];
      paramView1.getLocationOnScreen(paramView2);
      i1 = paramView2[1];
      i2 = paramView1.getHeight();
      if (((Display)localObject2).getHeight() - (i1 + i2) >= 128.0F * aoa.a().a) {
        break label190;
      }
    }
    label190:
    for (i1 = 1;; i1 = 0)
    {
      i2 = 0;
      this.a.measure(0, 0);
      if (i1 != 0) {
        i2 = -(paramView1.getMeasuredHeight() + this.a.getMeasuredHeight());
      }
      a(paramActivity, paramView1, true, true, false, 300, i2);
      return;
      i1 = 0;
      break;
    }
    label196:
    localObject1 = new int[2];
    paramView1.getLocationOnScreen((int[])localObject1);
    i1 = this.c;
    this.c = (localObject1[0] + i1);
    a(paramActivity, paramView2, false, true, true, 300, 0);
  }
  
  public final void dismiss()
  {
    View localView;
    AnimationSet localAnimationSet;
    if (isShowing())
    {
      e();
      this.b.setDuration(300);
      localView = getContentView().findViewById(2131755340);
      localAnimationSet = a(a(localView), this.i, false);
      this.b.setDuration(300);
      if ((Build.VERSION.SDK_INT >= 18) || ((this.k) && (!this.l))) {
        break label104;
      }
      this.b.a(localAnimationSet);
    }
    for (;;)
    {
      c();
      this.d.a(ae.a(this), 300L);
      return;
      label104:
      this.b.a();
      if ((Build.VERSION.SDK_INT < 21) && (this.k) && (!this.l)) {
        localView.startAnimation(localAnimationSet);
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */