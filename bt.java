package com.whatsapp;

import a.a.a.a.a.a.d;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.m;
import android.support.v4.app.n;
import android.support.v7.app.b.a;
import android.support.v7.c.b.c;
import android.text.format.DateUtils;
import android.text.format.Formatter;
import android.transition.Fade;
import android.transition.Transition;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.whatsapp.data.ad;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.n.a;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.ag;
import com.whatsapp.util.ag.a;
import com.whatsapp.util.az;
import com.whatsapp.util.p;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public abstract class bt
  extends nm
{
  boolean n;
  protected final ad o = ad.a();
  protected final ag p = ag.a();
  private b q;
  private final HashSet<j.b> r = new HashSet();
  
  private void b(Bitmap paramBitmap)
  {
    android.support.v7.c.b.a(paramBitmap, new b.c(this, (ChatInfoLayout)findViewById(2131755340)));
  }
  
  final void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = (ChatInfoLayout)findViewById(2131755340);
    ((ChatInfoLayout)localObject).findViewById(2131755457).setVisibility(8);
    ((ImageView)((ChatInfoLayout)localObject).findViewById(2131755467)).setImageResource(paramInt1);
    int j = android.support.v4.content.b.c(this, paramInt2);
    ((ChatInfoLayout)localObject).setColor(j);
    findViewById(2131755464).setBackgroundColor(0);
    findViewById(2131755468).setBackgroundColor(0);
    float f1;
    float f4;
    float f5;
    float f6;
    float f2;
    float f3;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = new float[3];
      paramInt2 = Color.red(j);
      int i = Color.green(j);
      j = Color.blue(j);
      f1 = paramInt2 / 255.0F;
      f4 = i / 255.0F;
      f5 = j / 255.0F;
      f6 = Math.max(f1, Math.max(f4, f5));
      float f7 = Math.min(f1, Math.min(f4, f5));
      f2 = f6 - f7;
      f3 = (f6 + f7) / 2.0F;
      if (f6 == f7)
      {
        f2 = 0.0F;
        f1 = 0.0F;
        localObject[0] = (f1 * 60.0F % 360.0F);
        localObject[1] = f2;
        localObject[2] = f3;
        localObject[2] = (localObject[2] * 8.0F / 10.0F);
        paramInt2 = a.d.a((float[])localObject);
        getWindow().setStatusBarColor(paramInt2);
      }
    }
    else
    {
      if (paramBoolean) {
        b(BitmapFactory.decodeResource(getResources(), paramInt1));
      }
      return;
    }
    if (f6 == f1) {
      f1 = (f4 - f5) / f2 % 6.0F;
    }
    for (;;)
    {
      f2 /= (1.0F - Math.abs(2.0F * f3 - 1.0F));
      break;
      if (f6 == f4) {
        f1 = (f5 - f1) / f2 + 2.0F;
      } else {
        f1 = (f1 - f4) / f2 + 4.0F;
      }
    }
  }
  
  protected final void a(long paramLong)
  {
    View localView1 = findViewById(2131755250);
    View localView2 = findViewById(2131755249);
    if (paramLong == 0L)
    {
      localView1.setVisibility(8);
      localView2.setVisibility(8);
      return;
    }
    localView1.setVisibility(0);
    localView2.setVisibility(0);
    ((TextView)findViewById(2131755251)).setText(NumberFormat.getInstance().format(paramLong));
  }
  
  final void a(Bitmap paramBitmap)
  {
    Object localObject = (ChatInfoLayout)findViewById(2131755340);
    ((ChatInfoLayout)localObject).findViewById(2131755457).setVisibility(8);
    localObject = (ImageView)((ChatInfoLayout)localObject).findViewById(2131755467);
    if (paramBitmap != null)
    {
      b(paramBitmap);
      ((ImageView)localObject).setImageBitmap(paramBitmap);
    }
  }
  
  protected final void a(final ArrayList<j> paramArrayList)
  {
    Object localObject = findViewById(2131755916);
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      ((View)localObject).setVisibility(8);
    }
    label280:
    label387:
    do
    {
      return;
      ((View)localObject).setVisibility(0);
      ViewGroup localViewGroup = (ViewGroup)findViewById(2131755920);
      localViewGroup.removeAllViews();
      final int i = getResources().getDimensionPixelSize(2131362050);
      int j = getResources().getDimensionPixelSize(2131362049);
      ImageView localImageView = new ImageView(this);
      localImageView.setBackgroundResource(2130840501);
      localImageView.setLayoutParams(new ViewGroup.LayoutParams(i + j, i + j));
      localImageView.setPadding(j, j, j, j);
      localImageView.setOnClickListener(bu.a(this));
      localImageView.setImageDrawable(new az(android.support.v4.content.b.a(this, 2130840030)));
      localImageView.setScaleType(ImageView.ScaleType.CENTER);
      Iterator localIterator = paramArrayList.iterator();
      if (localIterator.hasNext())
      {
        j localj = (j)localIterator.next();
        ans localans = new ans(this);
        localans.setScaleType(ImageView.ScaleType.CENTER_CROP);
        localans.setLayoutParams(new ViewGroup.LayoutParams(i + j, i + j));
        localans.setPadding(j, j, j, j);
        localans.setTextSize(i / 6);
        localans.setTextGravity(5);
        if ((localj.s == 3) || (localj.s == 2) || (localj.s == 13)) {
          if (localj.s == 13)
          {
            localObject = " ";
            localans.setText((CharSequence)localObject);
            if (localj.s != 3) {
              break label387;
            }
            localans.setIcon(android.support.v4.content.b.a(this, 2130840345));
          }
        }
        for (;;)
        {
          localans.setOnClickListener(bv.a(this, localj));
          this.p.a(localj, localans, new ag.a()
          {
            public final int a()
            {
              return (int)(i * aoa.a().a);
            }
            
            public final void a(View paramAnonymousView)
            {
              ((ans)paramAnonymousView).setImageDrawable(new ColorDrawable(-7829368));
            }
            
            public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap, j paramAnonymousj)
            {
              ans localans = (ans)paramAnonymousView;
              if (paramAnonymousBitmap == null)
              {
                localans.setTextBackgroundColor(0);
                switch (paramAnonymousj.s)
                {
                default: 
                  localans.setImageResource(0);
                }
              }
              for (;;)
              {
                if (!bt.a(bt.this).contains(paramAnonymousj.e))
                {
                  bt.a(bt.this).add(paramAnonymousj.e);
                  paramAnonymousBitmap = new AlphaAnimation(0.0F, 1.0F);
                  paramAnonymousBitmap.setDuration(300L);
                  paramAnonymousView.setAnimation(paramAnonymousBitmap);
                }
                return;
                localans.setImageResource(2130840347);
                continue;
                localans.setImageDrawable(new LayerDrawable(new Drawable[] { new ColorDrawable(android.support.v4.content.b.c(paramAnonymousView.getContext(), 2131624084)), new InsetDrawable(android.support.v4.content.b.a(paramAnonymousView.getContext(), 2130840022), paramAnonymousView.getResources().getDimensionPixelSize(2131362105)) }));
                continue;
                localans.setImageResource(2130840352);
                continue;
                localans.setImageDrawable(p.a(paramAnonymousView.getContext(), paramAnonymousj));
                continue;
                localans.setImageBitmap(paramAnonymousBitmap);
              }
            }
          });
          localViewGroup.addView(localans);
          break;
          if (localj.w != 0)
          {
            localObject = DateUtils.formatElapsedTime(localj.w);
            break label280;
          }
          localObject = Formatter.formatShortFileSize(u.a(), localj.t);
          break label280;
          if (localj.s == 13)
          {
            localans.setIcon(android.support.v4.content.b.a(this, 2130840344));
            continue;
            if ((localj.s == 9) && (localj.x != 0)) {
              localans.setText(p.a(localj));
            }
          }
        }
      }
      if (paramArrayList.size() >= 12) {
        localViewGroup.addView(localImageView);
      }
      al.a(this.aq, localViewGroup);
    } while (this.aq.d());
    paramArrayList = (HorizontalScrollView)findViewById(2131755919);
    paramArrayList.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        paramArrayList.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        paramArrayList.fullScroll(66);
      }
    });
  }
  
  public void finishAfterTransition()
  {
    m();
    super.finishAfterTransition();
  }
  
  public abstract String l();
  
  void m()
  {
    o();
  }
  
  final void n()
  {
    o();
    this.q = new b(l());
    com.whatsapp.util.bu.a(this.q, new Void[0]);
  }
  
  final void o()
  {
    if (this.q != null)
    {
      this.q.cancel(true);
      this.q = null;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Window localWindow = getWindow();
    if (Build.VERSION.SDK_INT >= 21)
    {
      localWindow.requestFeature(13);
      if (getIntent().getBooleanExtra("circular_transition", false))
      {
        localWindow.requestFeature(12);
        localObject = new a(true, false);
        ((Transition)localObject).addTarget(getString(2131298269));
        localWindow.setSharedElementEnterTransition((Transition)localObject);
        ((Transition)localObject).addListener(new com.whatsapp.n.c()
        {
          public final void onTransitionEnd(Transition paramAnonymousTransition)
          {
            bt.a(bt.this, false);
          }
          
          public final void onTransitionStart(Transition paramAnonymousTransition)
          {
            bt.a(bt.this, true);
          }
        });
      }
      Object localObject = new Fade();
      ((Transition)localObject).excludeTarget(16908335, true);
      ((Transition)localObject).excludeTarget(16908336, true);
      localWindow.setExitTransition((Transition)localObject);
      localWindow.setEnterTransition((Transition)localObject);
      localWindow.addFlags(Integer.MIN_VALUE);
      localWindow.clearFlags(67108864);
    }
    b(5);
    super.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    m();
  }
  
  public void onPause()
  {
    super.onPause();
    if (isFinishing()) {
      m();
    }
  }
  
  public static final class a
    extends m
  {
    final pv aa = pv.a();
    final aus ab = aus.a();
    private final aic ac = aic.a();
    private final e ad = e.a();
    
    public static a a(String paramString)
    {
      a locala = new a();
      Bundle localBundle = new Bundle();
      localBundle.putString("jid", paramString);
      locala.f(localBundle);
      return locala;
    }
    
    public final Dialog c(Bundle paramBundle)
    {
      cs localcs = this.ad.d(i().getString("jid"));
      if (localcs.d()) {
        paramBundle = k().getString(2131296988);
      }
      for (;;)
      {
        paramBundle = new b.a(l()).b(com.whatsapp.emoji.c.a(paramBundle, l().getBaseContext())).a(true).c(2131297028, bw.a(this)).b(2131297331, bx.a(this));
        if ((!localcs.d()) && (!j.b(localcs.t))) {
          paramBundle.a(2131297029, by.a(this, localcs));
        }
        return paramBundle.a();
        if (j.b(localcs.t)) {
          paramBundle = k().getString(2131296359);
        } else {
          paramBundle = k().getString(2131296518);
        }
      }
    }
  }
  
  final class b
    extends AsyncTask<Void, Void, Integer>
  {
    String a;
    
    public b(String paramString)
    {
      this.a = paramString;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */