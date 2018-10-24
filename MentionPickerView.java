package com.whatsapp;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.whatsapp.data.ad;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.data.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MentionPickerView
  extends FrameLayout
{
  RecyclerView a;
  String b;
  yv c;
  String d;
  boolean e;
  final pv f;
  final va g;
  final di h;
  private View i;
  private ValueAnimator j;
  private int k;
  private final e l;
  private final rh m;
  private b n;
  
  public MentionPickerView(Context paramContext)
  {
    super(paramContext);
    if (isInEditMode())
    {
      paramContext = null;
      this.f = paramContext;
      if (!isInEditMode()) {
        break label85;
      }
      paramContext = null;
      label30:
      this.g = paramContext;
      if (!isInEditMode()) {
        break label92;
      }
      paramContext = null;
      label44:
      this.h = paramContext;
      if (!isInEditMode()) {
        break label99;
      }
      paramContext = null;
      label58:
      this.l = paramContext;
      if (!isInEditMode()) {
        break label106;
      }
    }
    label85:
    label92:
    label99:
    label106:
    for (paramContext = (Context)localObject;; paramContext = rh.a())
    {
      this.m = paramContext;
      return;
      paramContext = pv.a();
      break;
      paramContext = va.a();
      break label30;
      paramContext = di.a();
      break label44;
      paramContext = e.a();
      break label58;
    }
  }
  
  public MentionPickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (isInEditMode())
    {
      paramContext = null;
      this.f = paramContext;
      if (!isInEditMode()) {
        break label86;
      }
      paramContext = null;
      label31:
      this.g = paramContext;
      if (!isInEditMode()) {
        break label93;
      }
      paramContext = null;
      label45:
      this.h = paramContext;
      if (!isInEditMode()) {
        break label100;
      }
      paramContext = null;
      label59:
      this.l = paramContext;
      if (!isInEditMode()) {
        break label107;
      }
    }
    label86:
    label93:
    label100:
    label107:
    for (paramContext = (Context)localObject;; paramContext = rh.a())
    {
      this.m = paramContext;
      return;
      paramContext = pv.a();
      break;
      paramContext = va.a();
      break label31;
      paramContext = di.a();
      break label45;
      paramContext = e.a();
      break label59;
    }
  }
  
  private void a(final int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramInt == this.k) {
        return;
      }
      this.k = paramInt;
      if (this.j != null) {
        this.j.cancel();
      }
      if (c()) {}
      for (int i1 = getHeight();; i1 = 0)
      {
        this.j = ValueAnimator.ofInt(new int[] { i1, paramInt });
        this.j.addUpdateListener(yt.a(this));
        this.j.addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            paramAnonymousAnimator = (FrameLayout.LayoutParams)MentionPickerView.this.getLayoutParams();
            paramAnonymousAnimator.height = paramInt;
            MentionPickerView.this.setLayoutParams(paramAnonymousAnimator);
            if (paramInt == 0)
            {
              MentionPickerView.this.setVisibility(8);
              if (MentionPickerView.c(MentionPickerView.this) != null) {
                MentionPickerView.c(MentionPickerView.this).a(false);
              }
            }
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator)
          {
            MentionPickerView.b(MentionPickerView.this);
          }
        });
        this.j.setDuration(250L);
        this.j.start();
        return;
      }
    }
    if ((paramInt >= 0) && (paramInt != this.a.getHeight()))
    {
      ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
      localLayoutParams.height = paramInt;
      this.a.setLayoutParams(localLayoutParams);
    }
    b();
  }
  
  private void b()
  {
    if (!c())
    {
      d();
      setVisibility(0);
      if (this.n != null) {
        this.n.a(true);
      }
    }
  }
  
  private boolean c()
  {
    return getVisibility() == 0;
  }
  
  private void d()
  {
    if (this.i == null) {
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.a.getLayoutParams();
    localLayoutParams.width = this.i.getWidth();
    this.a.setLayoutParams(localLayoutParams);
  }
  
  public final void a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.b != null) && (!this.b.isEmpty()))
    {
      localObject = this.m.a(this.b).b().iterator();
      while (((Iterator)localObject).hasNext())
      {
        rf localrf = (rf)((Iterator)localObject).next();
        if (!this.g.a(localrf.a)) {
          localArrayList.add(this.l.d(localrf.a));
        }
      }
    }
    Object localObject = this.c;
    ((yv)localObject).d = localArrayList;
    ((yv)localObject).c();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.i == null) {}
    while (!c()) {
      return;
    }
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        MentionPickerView.d(MentionPickerView.this);
        MentionPickerView.a(MentionPickerView.this, MentionPickerView.a(MentionPickerView.this).a());
        if (Build.VERSION.SDK_INT < 16)
        {
          MentionPickerView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
          return;
        }
        MentionPickerView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
    });
  }
  
  public void setAnchorWidthView(View paramView)
  {
    this.i = paramView;
    d();
  }
  
  public void setVisibilityChangeListener(b paramb)
  {
    this.n = paramb;
  }
  
  public final class a
    extends AsyncTask<String, Void, Set<String>>
  {
    private final String b;
    private final CharSequence c;
    private final ad d = ad.a();
    private final l e = l.a();
    
    private a(String paramString, CharSequence paramCharSequence)
    {
      this.b = paramString;
      this.c = paramCharSequence;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(boolean paramBoolean);
  }
  
  public static abstract interface c
  {
    public abstract void a(cs paramcs);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/MentionPickerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */