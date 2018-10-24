package com.whatsapp.gallerypicker;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.q;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

abstract class b
{
  ViewGroup a;
  ViewGroup b;
  ImageView c;
  TextView d;
  View e;
  View f;
  Uri g;
  float h;
  float i;
  final int[] j = new int[2];
  boolean k;
  Drawable l;
  Drawable m;
  final Handler n = new Handler(Looper.getMainLooper());
  final Runnable o = new Runnable()
  {
    public final void run()
    {
      b.this.e.setBackgroundColor(1962934272);
      if (!b.this.k)
      {
        b.this.d.setTextColor(-1291845633);
        b.this.l.setAlpha(178);
      }
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(300L);
      b.this.e.startAnimation(localAlphaAnimation);
    }
  };
  
  b(Activity paramActivity)
  {
    this.l = android.support.v4.content.b.a(paramActivity, 2130840230);
    this.m = android.support.v4.content.b.a(paramActivity, 2130840229);
    this.a = ((ViewGroup)paramActivity.findViewById(2131755924));
    this.d = ((TextView)paramActivity.findViewById(2131755926));
    this.e = paramActivity.findViewById(2131755925);
    this.b = ((ViewGroup)paramActivity.findViewById(2131755927));
    this.c = new a(paramActivity);
    this.c.setSelected(true);
    this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.b.addView(this.c);
  }
  
  abstract void a(Uri paramUri);
  
  final class a
    extends q
  {
    private final Paint b = new Paint(1);
    
    public a(Context paramContext)
    {
      super();
      this.b.setColor(-16725026);
      this.b.setStrokeWidth(paramContext.getResources().getDimensionPixelSize(2131362002));
      this.b.setStyle(Paint.Style.STROKE);
      this.b.setAntiAlias(true);
    }
    
    public final void onDraw(Canvas paramCanvas)
    {
      super.onDraw(paramCanvas);
      paramCanvas.drawColor(1711315404);
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.b);
      if (b.this.k) {
        paramCanvas.drawColor(1727987712);
      }
    }
    
    protected final void onMeasure(int paramInt1, int paramInt2)
    {
      paramInt1 = getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
      setMeasuredDimension(paramInt1, paramInt1);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */