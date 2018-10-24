package com.whatsapp;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.a;
import android.transition.AutoTransition;
import android.transition.Transition;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.whatsapp.data.cs;
import com.whatsapp.n.c;
import com.whatsapp.registration.ChangeNumberOverview;
import com.whatsapp.util.Log;
import com.whatsapp.util.WhatsAppLibLoader;
import com.whatsapp.util.at;
import java.io.File;

public class ProfileInfoActivity
  extends nh
{
  private final dh A = dh.a();
  private final dh.a B = new dh.a()
  {
    public final void b(String paramAnonymousString)
    {
      if ((ProfileInfoActivity.a(ProfileInfoActivity.this) != null) && (paramAnonymousString.equals(ProfileInfoActivity.a(ProfileInfoActivity.this).t)))
      {
        ProfileInfoActivity.a(ProfileInfoActivity.this, ProfileInfoActivity.b(ProfileInfoActivity.this).c());
        ProfileInfoActivity.c(ProfileInfoActivity.this);
      }
    }
    
    public final void c(String paramAnonymousString)
    {
      ProfileInfoActivity.this.runOnUiThread(acd.a(this, paramAnonymousString));
    }
  };
  TextEmojiLabel n;
  View o;
  cs p;
  final aoj q = aoj.a();
  final atv r = atv.a();
  private ImageView s;
  private boolean t;
  private Handler u;
  private Runnable v;
  private TextEmojiLabel w;
  private View x;
  private final aaq y = aaq.a();
  private final va z = va.a();
  
  @TargetApi(12)
  private void a(final Runnable paramRunnable)
  {
    if (this.x == null)
    {
      paramRunnable.run();
      return;
    }
    this.x.animate().scaleX(0.0F).scaleY(0.0F).setDuration(125L).setListener(new Animator.AnimatorListener()
    {
      private boolean c = true;
      
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      @TargetApi(21)
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (this.c)
        {
          this.c = false;
          paramRunnable.run();
        }
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
  }
  
  private void a(String paramString)
  {
    this.w.a(paramString);
  }
  
  private void o()
  {
    this.o.setVisibility(8);
    int i = getResources().getDimensionPixelSize(2131362072);
    Bitmap localBitmap;
    if (ach.b(this.p.t))
    {
      this.s.setEnabled(false);
      this.o.setVisibility(0);
      localBitmap = this.p.a(i, -1.0F, false);
      if (localBitmap != null) {
        break label200;
      }
      if ((this.p.m != 0) || (this.p.l != 0)) {
        break label189;
      }
      this.o.setVisibility(0);
      if (this.u == null)
      {
        this.u = new Handler(Looper.getMainLooper());
        this.v = abz.a(this);
      }
      this.u.removeCallbacks(this.v);
      this.u.postDelayed(this.v, 30000L);
      label147:
      localBitmap = cs.a(2130840246, i, -1.0F);
    }
    label189:
    label200:
    for (this.t = false;; this.t = true)
    {
      this.s.setImageBitmap(localBitmap);
      return;
      this.s.setEnabled(true);
      this.o.setVisibility(4);
      break;
      this.o.setVisibility(4);
      break label147;
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt2 != -1);
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("is_reset", false)))
        {
          this.o.setVisibility(0);
          this.aO.a(this.p);
          return;
        }
        this.aO.a(this, 13, paramIntent);
        return;
        this.aO.b().delete();
        if (paramInt2 != -1) {
          break;
        }
      } while (!this.aO.a(this, this.p));
      o();
      return;
    } while ((paramInt2 != 0) || (paramIntent == null));
    this.aO.a(this, paramIntent);
  }
  
  public void onBackPressed()
  {
    Runnable localRunnable = aca.a(this);
    if (Build.VERSION.SDK_INT >= 21)
    {
      a(localRunnable);
      return;
    }
    localRunnable.run();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject;
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().requestFeature(12);
      localObject = new AutoTransition();
      ((Transition)localObject).excludeTarget(16908335, true);
      ((Transition)localObject).excludeTarget(16908336, true);
      ((Transition)localObject).excludeTarget(2131755202, true);
      getWindow().setExitTransition((Transition)localObject);
      getWindow().setEnterTransition((Transition)localObject);
    }
    super.onCreate(paramBundle);
    Log.i("profileinfo/create");
    if (!WhatsAppLibLoader.a(null))
    {
      Log.i("aborting due to native libraries missing");
      finish();
    }
    do
    {
      return;
      setContentView(2130903338);
      pb.a(4);
      localObject = i();
      if (localObject != null) {
        ((a)localObject).a(true);
      }
      this.p = this.z.c();
      if (this.p == null)
      {
        Log.i("profileinfo/create/no-me");
        this.aq.a("conversations bounce to main");
        startActivity(new Intent(this, Main.class));
        finish();
        return;
      }
      this.n = ((TextEmojiLabel)findViewById(2131756029));
      this.n.a(this.r.l());
      findViewById(2131756030).setOnClickListener(abw.a(this));
      this.s = ((ImageView)findViewById(2131755458));
      this.s.setOnClickListener(abx.a(this));
      this.x = findViewById(2131755974);
      this.x.setOnClickListener(aby.a(this));
      if ((Build.VERSION.SDK_INT >= 21) && (paramBundle == null))
      {
        paramBundle = getWindow().getSharedElementEnterTransition();
        getWindow().setSharedElementExitTransition(paramBundle.clone());
        getWindow().setSharedElementReenterTransition(paramBundle.clone());
        getWindow().setSharedElementReturnTransition(paramBundle.clone());
        this.x.setScaleX(0.0F);
        this.x.setScaleY(0.0F);
        this.x.setVisibility(0);
        getWindow().getSharedElementEnterTransition().addListener(new c()
        {
          @TargetApi(12)
          public final void onTransitionEnd(Transition paramAnonymousTransition)
          {
            ProfileInfoActivity.e(ProfileInfoActivity.this).animate().scaleX(1.0F).scaleY(1.0F).setDuration(125L);
          }
        });
        getWindow().getSharedElementExitTransition().addListener(new c()
        {
          @TargetApi(12)
          public final void onTransitionStart(Transition paramAnonymousTransition)
          {
            ProfileInfoActivity.e(ProfileInfoActivity.this).setScaleX(1.0F);
            ProfileInfoActivity.e(ProfileInfoActivity.this).setScaleY(1.0F);
            ProfileInfoActivity.e(ProfileInfoActivity.this).animate().scaleX(0.0F).scaleY(0.0F).setDuration(125L);
          }
        });
        getWindow().getSharedElementReenterTransition().addListener(new c()
        {
          @TargetApi(12)
          public final void onTransitionStart(Transition paramAnonymousTransition)
          {
            ProfileInfoActivity.e(ProfileInfoActivity.this).setScaleX(0.0F);
            ProfileInfoActivity.e(ProfileInfoActivity.this).setScaleY(0.0F);
            ProfileInfoActivity.e(ProfileInfoActivity.this).animate().scaleX(1.0F).scaleY(1.0F).setDuration(125L);
          }
        });
      }
      this.o = findViewById(2131755538);
      o();
      ((TextView)findViewById(2131756032)).setText(cs.b(this.p.t));
      findViewById(2131756031).setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          ProfileInfoActivity.this.startActivity(new Intent(ProfileInfoActivity.this, ChangeNumberOverview.class));
        }
      });
      paramBundle = findViewById(2131755479);
      this.w = ((TextEmojiLabel)findViewById(2131755329));
      paramBundle.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          ProfileInfoActivity.this.startActivity(new Intent(ProfileInfoActivity.this, SetStatus.class));
        }
      });
      a(this.y.c());
      this.A.registerObserver(this.B);
    } while (!"android.intent.action.ATTACH_DATA".equals(getIntent().getAction()));
    this.aO.a(this, 13, getIntent());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i("profileinfo/destroy");
    this.A.unregisterObserver(this.B);
    if (this.u != null) {
      this.u.removeCallbacks(this.v);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    if (Build.VERSION.SDK_INT >= 21) {
      a(acb.a(this));
    }
    for (;;)
    {
      return true;
      finish();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ProfileInfoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */