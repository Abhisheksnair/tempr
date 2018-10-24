package com.whatsapp;

import a.a.a.a.a.a.d;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.a;
import android.support.v4.app.ah;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.protocol.j;
import com.whatsapp.util.FloatingChildLayout;
import com.whatsapp.util.FloatingChildLayout.3;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;

public class QuickContactActivity
  extends nh
{
  cs n;
  FloatingChildLayout o;
  ImageView p;
  boolean q;
  private final e r = e.a();
  private final dh s = dh.a();
  private final dh.a t = new dh.a()
  {
    public final void b(String paramAnonymousString)
    {
      QuickContactActivity.a(QuickContactActivity.this);
    }
  };
  
  public static void a(Context paramContext, View paramView, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(paramContext, QuickContactActivity.class);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect();
    localRect.left = ((int)(arrayOfInt[0] + 0.5F));
    localRect.top = ((int)(arrayOfInt[1] + 0.5F));
    localRect.right = ((int)(arrayOfInt[0] + paramView.getWidth() + 0.5F));
    localRect.bottom = ((int)(arrayOfInt[1] + paramView.getHeight() + 0.5F));
    localIntent.setSourceBounds(localRect);
    if (paramString2 != null) {
      localIntent.putExtra("transition_name", paramString2);
    }
    localIntent.putExtra("jid", paramString1);
    paramContext.startActivity(localIntent);
  }
  
  private void l()
  {
    Bitmap localBitmap = this.n.a(getResources().getDimensionPixelSize(2131362075), 0.0F, false);
    if (localBitmap != null)
    {
      this.p.setImageBitmap(localBitmap);
      return;
    }
    if (this.n.d())
    {
      this.p.setImageResource(2130837629);
      return;
    }
    if (j.b(this.n.t))
    {
      this.p.setImageResource(2130837624);
      return;
    }
    if (e.b(this.n.t))
    {
      this.p.setImageResource(2130837631);
      return;
    }
    this.p.setImageResource(2130837627);
  }
  
  final void c(boolean paramBoolean)
  {
    int i = 1;
    h().a();
    if (paramBoolean)
    {
      FloatingChildLayout localFloatingChildLayout = this.o;
      Object localObject;
      if (localFloatingChildLayout.d == 1)
      {
        localFloatingChildLayout.d = 3;
        if (!FloatingChildLayout.c) {
          break label155;
        }
        if (localFloatingChildLayout.e.isRunning()) {
          localFloatingChildLayout.e.reverse();
        }
      }
      else
      {
        localFloatingChildLayout = this.o;
        localObject = adm.a(this);
        if ((localFloatingChildLayout.f != 1) && (localFloatingChildLayout.f != 2)) {
          break label191;
        }
        localFloatingChildLayout.f = 3;
        localFloatingChildLayout.a.invalidate();
        localFloatingChildLayout.a(true, (Runnable)localObject);
      }
      for (;;)
      {
        if (i == 0) {
          finish();
        }
        return;
        localObject = ValueAnimator.ofInt(new int[] { 127, 0 });
        ((ValueAnimator)localObject).addUpdateListener(new FloatingChildLayout.3(localFloatingChildLayout));
        ((ValueAnimator)localObject).setDuration(localFloatingChildLayout.b).start();
        break;
        label155:
        localObject = new AlphaAnimation(1.0F, 0.0F);
        ((Animation)localObject).setDuration(localFloatingChildLayout.b);
        ((Animation)localObject).setFillAfter(true);
        localFloatingChildLayout.startAnimation((Animation)localObject);
        break;
        label191:
        i = 0;
      }
    }
    a.c(this);
  }
  
  public void onBackPressed()
  {
    c(true);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Log.i("quickcontactinfo/create");
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().requestFeature(12);
    }
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().addFlags(Integer.MIN_VALUE);
    }
    paramBundle = getIntent();
    this.n = this.r.d(paramBundle.getStringExtra("jid"));
    getWindow().setFlags(131072, 131072);
    setContentView(2130903341);
    this.o = ((FloatingChildLayout)findViewById(2131756040));
    this.o.setOnOutsideTouchListener(ada.a(this));
    paramBundle = paramBundle.getSourceBounds();
    if (paramBundle != null)
    {
      this.o.setChildTargetScreen(paramBundle);
      this.o.setCircularReveal(true);
    }
    ((TextEmojiLabel)findViewById(2131755507)).setContact(this.n);
    ImageButton localImageButton;
    if ((this.n.h) || (this.n.d()) || (j.b(this.n.t)))
    {
      findViewById(2131755513).setVisibility(0);
      findViewById(2131756041).setVisibility(8);
      this.p = ((ImageView)findViewById(2131755467));
      l();
      this.p.setOnClickListener(adf.a(this));
      findViewById(2131756042).setOnClickListener(adg.a(this));
      paramBundle = (ImageButton)findViewById(2131756043);
      paramBundle.setOnTouchListener(new agl(0.2F, 0.0F, 0.2F, 0.0F));
      localImageButton = (ImageButton)findViewById(2131756044);
      localImageButton.setOnTouchListener(new agl(0.2F, 0.0F, 0.2F, 0.0F));
      if (aic.h())
      {
        a.d.b(paramBundle.getDrawable(), getResources().getColor(2131623985));
        a.d.b(localImageButton.getDrawable(), getResources().getColor(2131624128));
      }
      if ((!this.n.d()) && (!j.b(this.n.t)) && (!e.b(this.n.t))) {
        break label492;
      }
      paramBundle.setVisibility(8);
      label396:
      localImageButton.setVisibility(8);
    }
    for (;;)
    {
      findViewById(2131755865).setOnClickListener(adj.a(this));
      findViewById(2131756041).setOnClickListener(adk.a(this));
      if (Build.VERSION.SDK_INT >= 21) {
        this.q = true;
      }
      FloatingChildLayout.a(this.o, adl.a(this));
      this.s.registerObserver(this.t);
      return;
      findViewById(2131755513).setVisibility(8);
      findViewById(2131756041).setVisibility(0);
      break;
      label492:
      paramBundle.setOnClickListener(adh.a(this));
      if (!br.b()) {
        break label396;
      }
      localImageButton.setVisibility(0);
      localImageButton.setOnClickListener(adi.a(this));
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i("quickcontactinfo/destroy");
    this.s.unregisterObserver(this.t);
  }
  
  public static final class a
    extends at
  {
    private final String a;
    private final String b;
    private final Context c;
    
    a(Context paramContext, String paramString1, String paramString2)
    {
      this.c = paramContext;
      this.a = paramString1;
      this.b = paramString2;
    }
    
    public final void a(View paramView)
    {
      QuickContactActivity.a(this.c, paramView, this.a, this.b);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/QuickContactActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */