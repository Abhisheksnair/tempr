package com.whatsapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.support.v7.c.a.a;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.s;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;

public abstract class jm
  extends hy
{
  private final vx O;
  private final vs P;
  protected at T;
  protected at U;
  protected at V;
  protected at W;
  
  public jm(Context paramContext, j paramj)
  {
    super(paramContext, paramj);
    if (isInEditMode())
    {
      paramContext = null;
      this.O = paramContext;
      if (!isInEditMode()) {
        break label92;
      }
    }
    label92:
    for (paramContext = (Context)localObject;; paramContext = vs.a())
    {
      this.P = paramContext;
      this.T = new at()
      {
        public final void a(View paramAnonymousView)
        {
          if (jm.this.a.b().suspiciousContent == MediaData.SUSPICIOUS_CONTENT_YES)
          {
            if (jm.this.a.s == 2)
            {
              jm.this.l.b(jm.this.getContext(), 2131296829, 1);
              return;
            }
            jm.this.l.b(jm.this.getContext(), 2131296830, 1);
            return;
          }
          if (jm.this.a.p != null)
          {
            jm.this.C.a((nh)jm.this.getContext(), jm.this.a);
            return;
          }
          Log.e("cannot download media message with no media attached");
          paramAnonymousView = jm.this.l;
          pv.a(jm.this.getContext(), 2131297063, 0);
        }
      };
      this.U = new at()
      {
        public final void a(View paramAnonymousView)
        {
          jm.this.x.a(jm.this.a, true);
        }
      };
      this.V = new at()
      {
        public final void a(View paramAnonymousView)
        {
          paramAnonymousView = jm.this.a.b();
          int i;
          if ((jm.this.a.e.b) && (paramAnonymousView.file == null) && (jm.this.a.p != null))
          {
            i = 1;
            if ((!jm.this.a.e.b) || (i != 0)) {
              break label169;
            }
            if (s.a(jm.this.a.d, 2) < 0) {
              break label113;
            }
            paramAnonymousView = jm.this.l;
            pv.a(jm.this.getContext(), 2131296796, 0);
          }
          label113:
          do
          {
            return;
            i = 0;
            break;
            jm.a(jm.this).a(jm.this.a);
            jm.b(jm.this).a(jm.this.a);
          } while (paramAnonymousView.uploader == null);
          paramAnonymousView.uploader.b(jm.this.a);
          return;
          label169:
          paramAnonymousView.downloader.b();
        }
      };
      this.W = new at()
      {
        public final void a(View paramAnonymousView)
        {
          jm.this.b();
        }
      };
      return;
      paramContext = vx.a();
      break;
    }
  }
  
  protected static int a(ProgressBar paramProgressBar, MediaData paramMediaData)
  {
    boolean bool = false;
    if ((paramMediaData.transferring) && (!paramMediaData.prefetching))
    {
      paramProgressBar.setVisibility(0);
      if ((paramMediaData.progress == 0L) || (paramMediaData.progress == 100L)) {
        bool = true;
      }
      paramProgressBar.setIndeterminate(bool);
      int j = (int)paramMediaData.progress;
      int i = j;
      if (paramMediaData.transcoder != null)
      {
        i = j;
        if (paramMediaData.transcoder.c()) {
          if (paramMediaData.uploader != null) {
            break label98;
          }
        }
      }
      label98:
      for (i = j / 2;; i = j / 2 + 50)
      {
        paramProgressBar.setProgress(i);
        return i;
      }
    }
    paramProgressBar.setVisibility(8);
    return 0;
  }
  
  protected static void a(boolean paramBoolean1, boolean paramBoolean2, View paramView1, View paramView2, ImageView paramImageView, View paramView3)
  {
    a(paramBoolean1, paramBoolean2, false, paramView1, paramView2, paramImageView, paramView3);
  }
  
  protected static void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, View paramView1, final View paramView2, ImageView paramImageView, View paramView3)
  {
    final int j = paramView1.getWidth();
    final int i = 0;
    ScaleAnimation localScaleAnimation;
    AlphaAnimation localAlphaAnimation;
    AnimationSet localAnimationSet;
    if (paramBoolean1) {
      if (paramView2.getVisibility() != 0)
      {
        if (!paramBoolean2) {
          break label305;
        }
        localScaleAnimation = new ScaleAnimation(1.0F, 0.5F, 1.0F, 0.5F, 1, 0.5F, 1, 0.5F);
        localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        localAnimationSet = new AnimationSet(true);
        localAnimationSet.addAnimation(localScaleAnimation);
        localAnimationSet.addAnimation(localAlphaAnimation);
        localAnimationSet.setDuration(150L);
        paramView3.startAnimation(localAnimationSet);
        paramView3.setVisibility(8);
        paramView2.setVisibility(0);
        if (!paramBoolean3) {
          break label313;
        }
        paramImageView.setImageResource(2130840265);
        label120:
        paramImageView.setContentDescription(null);
        paramImageView.setVisibility(0);
        if (!paramBoolean2) {
          break label323;
        }
        paramView3 = new AlphaAnimation(0.0F, 1.0F);
        paramView3.setDuration(300L);
        paramView3.setStartOffset(150L);
        paramView2.startAnimation(paramView3);
        paramImageView.startAnimation(paramView3);
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        if (!paramBoolean2) {
          break label460;
        }
        paramView1.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        i = paramView1.getMeasuredWidth();
        paramView2 = paramView1.getBackground();
        if (!(paramView2 instanceof a)) {
          paramView1.setBackgroundDrawable(new a(paramView2, paramBoolean3));
        }
        paramView2 = (a)paramView1.getBackground();
        paramView1.getLayoutParams().width = Math.max(j, i);
        paramImageView = new Animation()
        {
          public final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
          {
            if (paramAnonymousFloat != 1.0F) {
              this.a.a(j + (int)((i - j) * paramAnonymousFloat));
            }
          }
        };
        paramImageView.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            this.a.getLayoutParams().width = -2;
            this.a.requestLayout();
            this.a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
            {
              public final void onGlobalLayout()
              {
                jm.5.this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                jm.5.this.b.a(-1);
              }
            });
            this.a.clearAnimation();
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        paramImageView.setDuration(300L);
        paramView1.startAnimation(paramImageView);
      }
      return;
      label305:
      paramView3.clearAnimation();
      break;
      label313:
      paramImageView.setImageResource(2130837659);
      break label120;
      label323:
      paramView2.clearAnimation();
      paramImageView.clearAnimation();
      i = 1;
      continue;
      if (paramView2.getVisibility() != 8)
      {
        paramView3.setVisibility(0);
        if (paramBoolean2)
        {
          localScaleAnimation = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 1, 0.5F, 1, 0.5F);
          localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation(localScaleAnimation);
          localAnimationSet.addAnimation(localAlphaAnimation);
          localAnimationSet.setDuration(300L);
          paramView3.startAnimation(localAnimationSet);
        }
        paramView2.clearAnimation();
        paramView2.setVisibility(8);
        paramImageView.clearAnimation();
        paramImageView.setVisibility(8);
        i = 1;
      }
    }
    label460:
    paramView1.clearAnimation();
  }
  
  public static String b(j paramj)
  {
    return "thumb-transition-" + paramj.e;
  }
  
  public static String c(j paramj)
  {
    return "date-transition-" + paramj.e;
  }
  
  public static String d(j paramj)
  {
    return "status-transition-" + paramj.e;
  }
  
  final void a(View paramView, TextEmojiLabel paramTextEmojiLabel)
  {
    Resources localResources = getResources();
    if (!TextUtils.isEmpty(this.a.z))
    {
      paramTextEmojiLabel.setVisibility(0);
      a(this.a.z, paramTextEmojiLabel, this.a);
      this.n.setTextColor(b.c(getContext(), 2131624000));
      this.p.setPadding(localResources.getDimensionPixelSize(2131361927), 0, localResources.getDimensionPixelSize(2131361927), localResources.getDimensionPixelSize(2131361925));
      ((ViewGroup.MarginLayoutParams)paramView.getLayoutParams()).topMargin = 0;
      return;
    }
    paramTextEmojiLabel.setVisibility(8);
    this.n.setTextColor(b.c(getContext(), 2131624001));
    this.p.setPadding(localResources.getDimensionPixelSize(2131361928), 0, localResources.getDimensionPixelSize(2131361928), 0);
    this.p.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    ((ViewGroup.MarginLayoutParams)paramView.getLayoutParams()).topMargin = (-this.p.getMeasuredHeight() - getResources().getDimensionPixelSize(2131361926));
  }
  
  protected abstract void b();
  
  static final class a
    extends a
  {
    int a = -1;
    private final boolean b;
    
    public a(Drawable paramDrawable, boolean paramBoolean)
    {
      super();
      this.b = paramBoolean;
    }
    
    final void a(int paramInt)
    {
      this.a = paramInt;
      invalidateSelf();
    }
    
    public final void draw(Canvas paramCanvas)
    {
      Rect localRect = getBounds();
      if (this.a >= 0)
      {
        int i = (this.a - localRect.width()) / 2;
        if (this.b) {
          a().setBounds(localRect.left, localRect.top, (i << 1) + localRect.right, localRect.bottom);
        }
        for (;;)
        {
          a().draw(paramCanvas);
          return;
          a().setBounds(localRect.left - i, localRect.top, i + localRect.right, localRect.bottom);
        }
      }
      a().setBounds(localRect.left, localRect.top, localRect.right, localRect.bottom);
      super.draw(paramCanvas);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/jm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */