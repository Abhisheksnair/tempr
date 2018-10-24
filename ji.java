package com.whatsapp;

import a.a.a.a.d;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CameraPosition.a;
import com.google.android.gms.maps.model.LatLng;
import com.whatsapp.data.cs;
import com.whatsapp.location.bp;
import com.whatsapp.location.cc;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.ag;
import com.whatsapp.util.ag.a;
import com.whatsapp.util.at;
import com.whatsapp.util.l;

public final class ji
  extends hy
{
  private final TextView O;
  private final View P;
  private final View Q;
  private final ImageView R;
  private final View S;
  private final TextView T;
  private final View U;
  private final TextView V;
  private final View W;
  private final ViewGroup aa;
  private final ThumbnailButton ab;
  private final View ac;
  private final View ad;
  private final View ae;
  private final View af;
  private final TextEmojiLabel ag;
  private final TextEmojiLabel ah;
  private final ImageView ai;
  private com.google.android.gms.maps.c aj;
  private final bp ak;
  private final di.e al;
  
  ji(Context paramContext, com.whatsapp.protocol.j paramj, di.e parame)
  {
    super(paramContext, paramj);
    if (isInEditMode()) {}
    for (paramContext = null;; paramContext = bp.a())
    {
      this.ak = paramContext;
      this.al = parame;
      this.R = ((ImageView)findViewById(2131755327));
      this.S = findViewById(2131755625);
      this.O = ((TextView)findViewById(2131755580));
      this.P = findViewById(2131755579);
      this.Q = findViewById(2131755238);
      this.T = ((TextView)findViewById(2131755619));
      this.U = findViewById(2131755617);
      this.V = ((TextView)findViewById(2131755622));
      this.W = findViewById(2131755620);
      this.aa = ((ViewGroup)findViewById(2131755624));
      this.ab = ((ThumbnailButton)findViewById(2131755629));
      this.ac = findViewById(2131755630);
      this.ad = findViewById(2131755616);
      this.ae = findViewById(2131755614);
      this.af = findViewById(2131755626);
      this.ag = ((TextEmojiLabel)findViewById(2131755627));
      this.ah = ((TextEmojiLabel)findViewById(2131755623));
      this.ai = ((ImageView)findViewById(2131755618));
      this.ah.setLinkHandler(new th());
      this.ah.setAutoLinkMask(0);
      this.ah.setLinksClickable(false);
      this.ah.setFocusable(false);
      this.ah.setClickable(false);
      this.ah.setLongClickable(false);
      p();
      return;
    }
  }
  
  private void p()
  {
    this.S.setOnLongClickListener(this.u);
    this.ag.setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        if (ji.this.a.e.b)
        {
          d.a((Activity)ji.this.getContext(), 19);
          return;
        }
        ji.this.m.a(ji.this.getContext(), ji.this.a.e.a, null);
      }
    });
    this.ag.setOnLongClickListener(this.u);
    MediaData localMediaData = this.a.b();
    if (this.P != null) {
      this.P.setVisibility(8);
    }
    Object localObject1;
    if (this.ae != null)
    {
      localObject1 = (ViewGroup.MarginLayoutParams)this.ae.getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject1).topMargin = 0;
      ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = 0;
    }
    this.W.setVisibility(8);
    this.aa.setVisibility(0);
    long l1;
    long l3;
    boolean bool;
    label249:
    label400:
    label488:
    int i;
    if (this.a.e.b)
    {
      l1 = this.ak.b(this.a);
      long l2 = ((com.whatsapp.g.j)b.a.a.c.a().a(com.whatsapp.g.j.class)).a();
      l3 = this.a.n;
      l3 = this.a.w * 1000 + l3;
      if (((this.a.e.b) || (l1 <= l2)) && ((!this.a.e.b) || (l1 != -1L) || (l3 <= l2)) && ((!this.a.e.b) || (l1 <= l2))) {
        break label1099;
      }
      bool = true;
      this.af.setVisibility(0);
      this.ag.setVisibility(0);
      if (this.ad != null) {
        this.ad.setMinimumHeight(getResources().getDimensionPixelSize(2131362048));
      }
      this.ai.clearAnimation();
      if ((!bool) || (l1 <= l2)) {
        break label1105;
      }
      localObject1 = new AlphaAnimation(1.0F, 0.3F);
      ((AlphaAnimation)localObject1).setDuration(1000L);
      ((AlphaAnimation)localObject1).setInterpolator(new DecelerateInterpolator());
      ((AlphaAnimation)localObject1).setRepeatCount(-1);
      ((AlphaAnimation)localObject1).setRepeatMode(2);
      this.ai.startAnimation((Animation)localObject1);
      this.T.setText(getResources().getString(2131297098, new Object[] { l.a(getContext(), this.v.a(l1)) }));
      this.U.setVisibility(0);
      this.W.setVisibility(8);
      this.aa.setVisibility(0);
      if (!bool) {
        break label1146;
      }
      this.ai.setImageResource(2130840192);
      this.T.setTextColor(getResources().getColor(2131624043));
      this.af.setVisibility(0);
      this.ag.setVisibility(0);
      this.S.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          paramAnonymousView = null;
          if (!ji.this.a.e.b) {
            if (!qz.e(ji.this.a.e.a)) {
              break label80;
            }
          }
          label80:
          for (paramAnonymousView = ji.this.a.f;; paramAnonymousView = ji.this.a.e.a)
          {
            ji.this.m.a(ji.this.getContext(), ji.this.a.e.a, paramAnonymousView);
            return;
          }
        }
      });
      if (this.ac != null)
      {
        localObject1 = this.ac;
        if (!bool) {
          break label1212;
        }
        i = 8;
        label509:
        ((View)localObject1).setVisibility(i);
      }
      if ((this.a.C == 0.0D) && (this.a.B == 0.0D)) {
        break label1217;
      }
      i = 1;
      label541:
      if ((this.aa.getVisibility() != 0) || (!this.m.c()) || (i == 0)) {
        break label1341;
      }
    }
    label731:
    label798:
    label853:
    label906:
    label973:
    label1099:
    label1105:
    label1146:
    label1212:
    label1217:
    label1222:
    label1250:
    Object localObject2;
    try
    {
      if (this.aj == null)
      {
        localObject1 = (ViewGroup)findViewById(2131755628);
        GoogleMapOptions localGoogleMapOptions = new GoogleMapOptions();
        Object localObject3 = new LatLng(this.a.B, this.a.C);
        localObject3 = new CameraPosition.a().a((LatLng)localObject3).a(15.0F).a();
        localGoogleMapOptions.a().e().b().b(false).a(false).d(false).c(false).c().a((CameraPosition)localObject3).d();
        com.google.android.gms.maps.e.a(getContext());
        this.aj = new com.google.android.gms.maps.c(getContext(), localGoogleMapOptions);
        if (this.m.a) {
          break label1222;
        }
        this.aj.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
        {
          public final boolean onPreDraw()
          {
            ji.a(ji.this).getViewTreeObserver().removeOnPreDrawListener(this);
            ji.a(ji.this).post(new Runnable()
            {
              public final void run()
              {
                if (d.n())
                {
                  ji.this.postDelayed(this, 1000L);
                  return;
                }
                try
                {
                  ji.a(ji.this).a(null);
                  ji.a(ji.this).a();
                  ji.this.m.a = true;
                  return;
                }
                catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
                {
                  for (;;)
                  {
                    Log.i(localIncompatibleClassChangeError);
                  }
                }
              }
            });
            return true;
          }
        });
        ((ViewGroup)localObject1).addView(this.aj, -1, -1);
      }
      this.aj.setVisibility(0);
      this.aj.a(new jj(this, bool));
      if (!this.a.e.b) {
        break label1250;
      }
      this.al.a(this.w.c(), this.ab);
    }
    catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
    {
      for (;;)
      {
        Log.i(localIncompatibleClassChangeError);
        continue;
        if (qz.e(this.a.e.a)) {}
        for (localObject2 = this.a.f;; localObject2 = this.a.e.a)
        {
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label1325;
          }
          localObject2 = this.F.a((String)localObject2);
          this.al.a((cs)localObject2, this.ab);
          break;
        }
        this.ab.setImageBitmap(cs.b(2130837625));
      }
    }
    if (!TextUtils.isEmpty(this.a.z))
    {
      a(this.a.z, this.ah, this.a);
      if (this.m.c())
      {
        localObject1 = this.af;
        if (bool)
        {
          i = 0;
          ((View)localObject1).setVisibility(i);
          this.ag.setPadding(getResources().getDimensionPixelSize(2131361929), getResources().getDimensionPixelSize(2131361931), getResources().getDimensionPixelSize(2131361929), getResources().getDimensionPixelSize(2131361929));
        }
      }
      else
      {
        if ((this.m.c()) && (this.ae != null))
        {
          if (!TextUtils.isEmpty(this.a.z)) {
            break label1450;
          }
          localObject1 = new RelativeLayout.LayoutParams(-1, -2);
          ((RelativeLayout.LayoutParams)localObject1).addRule(11);
          ((RelativeLayout.LayoutParams)localObject1).addRule(8, 2131755617);
          this.ae.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        if (this.O != null) {
          this.O.setVisibility(8);
        }
        if ((localMediaData == null) || (!localMediaData.transferring)) {
          break label1500;
        }
        if (!this.a.e.b) {
          break label1489;
        }
        this.Q.setVisibility(0);
        if (this.P != null) {
          this.P.setVisibility(0);
        }
        this.S.setOnClickListener(null);
      }
    }
    for (;;)
    {
      localObject1 = new ag.a()
      {
        public final int a()
        {
          return (int)(252.0F * aoa.a().a);
        }
        
        public final void a(View paramAnonymousView)
        {
          ji.b(ji.this).setImageDrawable(null);
          ji.b(ji.this).setBackgroundColor(-7829368);
        }
        
        public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap, com.whatsapp.protocol.j paramAnonymousj)
        {
          if (paramAnonymousBitmap != null)
          {
            ji.b(ji.this).setImageBitmap(paramAnonymousBitmap);
            return;
          }
          ji.b(ji.this).setImageResource(2130840348);
        }
      };
      if (!this.m.c()) {
        break label1654;
      }
      this.L.a(this.a, this.R, (ag.a)localObject1);
      return;
      l1 = this.ak.a(this.a);
      break;
      bool = false;
      break label249;
      if (!bool) {
        break label400;
      }
      this.T.setText(getResources().getString(2131297098, new Object[] { l.a(getContext(), l3) }));
      break label400;
      this.ai.setImageResource(2130840161);
      this.T.setTextColor(getResources().getColor(2131624052));
      this.af.setVisibility(8);
      this.ag.setVisibility(8);
      this.T.setText(2131297107);
      this.S.setOnClickListener(null);
      break label488;
      i = 0;
      break label509;
      i = 0;
      break label541;
      this.aj.a(null);
      this.aj.a();
      break label731;
      label1325:
      label1341:
      if (this.aj == null) {
        break label798;
      }
      this.aj.setVisibility(8);
      break label798;
      i = 8;
      break label853;
      a("", this.ah, this.a);
      if (!this.m.c()) {
        break label906;
      }
      this.af.setVisibility(8);
      this.ag.setPadding(getResources().getDimensionPixelSize(2131361929), getResources().getDimensionPixelSize(2131361932), getResources().getDimensionPixelSize(2131361929), getResources().getDimensionPixelSize(2131361930));
      break label906;
      label1450:
      localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, 2131755617);
      this.ae.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      break label973;
      label1489:
      this.Q.setVisibility(0);
      continue;
      label1500:
      if ((!this.a.e.b) || (localMediaData == null) || (localMediaData.transferred))
      {
        if (this.Q != null) {
          this.Q.setVisibility(8);
        }
      }
      else
      {
        if (this.Q != null) {
          this.Q.setVisibility(8);
        }
        if (this.O != null)
        {
          this.O.setVisibility(0);
          this.O.setText(2131297619);
          this.O.setOnClickListener(new a((byte)0));
        }
        if (this.P != null) {
          this.P.setVisibility(0);
        }
        this.af.setVisibility(8);
        this.ag.setVisibility(8);
        this.S.setOnClickListener(new a((byte)0));
      }
    }
    label1654:
    this.L.b(this.a, this.R, (ag.a)localObject2);
  }
  
  public final void a(com.whatsapp.protocol.j paramj, boolean paramBoolean)
  {
    if (paramj != this.a) {}
    for (int i = 1;; i = 0)
    {
      super.a(paramj, paramBoolean);
      if ((paramBoolean) || (i != 0)) {
        p();
      }
      return;
    }
  }
  
  protected final boolean a()
  {
    return false;
  }
  
  protected final int getCenteredLayoutId()
  {
    return getIncomingLayoutId();
  }
  
  protected final int getIncomingLayoutId()
  {
    if (this.m.c()) {
      return 2130903156;
    }
    return 2130903155;
  }
  
  protected final int getOutgoingLayoutId()
  {
    if (this.m.c()) {
      return 2130903158;
    }
    return 2130903157;
  }
  
  public final void i()
  {
    p();
    super.i();
  }
  
  final class a
    extends at
  {
    private a() {}
    
    public final void a(View paramView)
    {
      ji.this.C.c(ji.this.a);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */