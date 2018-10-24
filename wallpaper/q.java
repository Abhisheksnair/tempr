package com.whatsapp.wallpaper;

import android.content.Context;
import android.support.v4.view.w;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.whatsapp.hy;
import com.whatsapp.jr;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.m;
import com.whatsapp.va;

public abstract class q
  extends w
{
  private final Context a;
  private final va b;
  
  public q(Context paramContext, va paramva)
  {
    this.a = paramContext;
    this.b = paramva;
  }
  
  public final Object a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject1 = new ViewGroup.LayoutParams(-1, -1);
    FrameLayout localFrameLayout = new FrameLayout(this.a);
    localFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    Object localObject3 = new FrameLayout.LayoutParams(-1, -1);
    j localj = new j(j.a(this.b, "", false));
    localj.n = m.a();
    Object localObject2 = new j(j.a(this.b, this.b.b(), true));
    ((j)localObject2).n = m.a();
    ((j)localObject2).d = 5;
    a(localj, (j)localObject2, paramInt);
    localObject1 = new h(this.a);
    ((h)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((h)localObject1).setImageDrawable(null);
    h localh = new h(this.a);
    localh.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localh.setImageDrawable(null);
    LinearLayout localLinearLayout = new LinearLayout(this.a);
    localLinearLayout.setId(2131755098);
    localLinearLayout.setTag("chatlayout-" + paramInt);
    localLinearLayout.setBackgroundResource(0);
    localLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject3);
    localLinearLayout.setOrientation(1);
    localObject3 = new jr(this.a, localj);
    ((hy)localObject3).a(true);
    ((hy)localObject3).setEnabled(false);
    localObject2 = new jr(this.a, (j)localObject2);
    ((hy)localObject2).a(false);
    ((hy)localObject2).setEnabled(false);
    localLinearLayout.addView((View)localObject3);
    localLinearLayout.addView((View)localObject2);
    a(localh, (h)localObject1, paramInt);
    localFrameLayout.addView((View)localObject1);
    localFrameLayout.addView(localh);
    localFrameLayout.addView(localLinearLayout);
    paramViewGroup.addView(localFrameLayout);
    return localFrameLayout;
  }
  
  public void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public abstract void a(j paramj1, j paramj2, int paramInt);
  
  public abstract void a(h paramh1, h paramh2, int paramInt);
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/wallpaper/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */