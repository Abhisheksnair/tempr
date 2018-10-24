package com.whatsapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public final class aoa
{
  private static aoa u = null;
  private static Boolean v = null;
  private static Typeface w = null;
  private static Typeface x = null;
  private static Typeface y = null;
  private static Typeface z = null;
  public final float a;
  public final int b;
  public final int c;
  public final int d;
  public final int e;
  public final int f;
  public final int g;
  public final int h;
  public final float i;
  public final float j;
  public final float k;
  public final int l;
  public final int m;
  public final float n;
  public final int o;
  public final int p;
  public final int q;
  public final int r;
  public final int s;
  public final int t;
  
  private aoa(Context paramContext)
  {
    this.a = paramContext.getResources().getDisplayMetrics().density;
    if (paramContext.getResources().getDisplayMetrics().widthPixels / this.a >= 360.0F)
    {
      f1 = 8.0F;
      this.b = Math.round(f1 * this.a);
      this.c = ((int)(this.a * 42.0F));
      this.d = ((int)(this.a * 22.0F));
      this.e = ((int)(this.a * 3.0F));
      this.f = ((int)(this.a * 2.0F));
      this.h = ((int)(this.a * 10.0F));
      this.g = ((int)(this.a * 4.0F / 3.0F));
      this.s = ((int)(this.a * 3.0F / 2.0F));
      this.t = Math.max(1, (int)(this.a / 2.0F));
      if (this.a < 1.5F) {
        break label289;
      }
    }
    label289:
    for (float f1 = 52.0F;; f1 = 42.0F)
    {
      this.i = f1;
      this.j = ((int)(this.a * 4.0F));
      this.k = (this.a * 2.0F);
      this.l = ((int)(83.333336F * this.a));
      this.m = ((int)(this.a * 1.3333334F));
      this.n = (3.3333333F * this.a);
      this.o = ((int)(66.666664F * this.a));
      this.q = ((int)(2.6666667F * this.a));
      this.p = ((int)(this.a * 1.3333334F));
      this.r = ((int)(this.a * 4.0F));
      return;
      f1 = 2.0F;
      break;
    }
  }
  
  public static aoa a()
  {
    return u;
  }
  
  public static void a(Context paramContext)
  {
    if (u != null) {
      throw new IllegalStateException("scaler should only be initialized once");
    }
    u = new aoa(paramContext);
  }
  
  public static void a(TextView paramTextView)
  {
    if (v == null) {
      c();
    }
    if (v.booleanValue())
    {
      if (w == null) {
        if (Build.VERSION.SDK_INT < 21) {
          break label50;
        }
      }
      label50:
      for (w = Typeface.create("sans-serif-light", 0);; w = Typeface.createFromAsset(u.a().getAssets(), "fonts/Roboto-Light.ttf"))
      {
        paramTextView.setTypeface(w);
        return;
      }
    }
    if (y == null) {
      y = Typeface.defaultFromStyle(0);
    }
    paramTextView.setTypeface(y);
    paramTextView.getPaint().setFakeBoldText(false);
  }
  
  public static float b(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().scaledDensity * 22.0F;
  }
  
  public static int b()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)u.a().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    if (localDisplayMetrics.densityDpi >= 320) {
      return (int)(localDisplayMetrics.density * 25.0F);
    }
    if (localDisplayMetrics.densityDpi >= 240) {
      return 38;
    }
    if (localDisplayMetrics.densityDpi >= 160) {
      return 25;
    }
    return 19;
  }
  
  public static void b(TextView paramTextView)
  {
    boolean bool = true;
    if (v == null) {
      c();
    }
    if (v.booleanValue())
    {
      paramTextView.setTypeface(d());
      return;
    }
    if (z == null) {
      z = Typeface.create(Typeface.DEFAULT, 1);
    }
    paramTextView.setTypeface(z);
    paramTextView = paramTextView.getPaint();
    if ((z.getStyle() & 0x1) == 0) {}
    for (;;)
    {
      paramTextView.setFakeBoldText(bool);
      return;
      bool = false;
    }
  }
  
  public static boolean c()
  {
    boolean bool2 = true;
    boolean bool1 = true;
    TextPaint localTextPaint = new TextPaint();
    localTextPaint.setTextSize(20.0F);
    localTextPaint.setTypeface(Typeface.DEFAULT);
    float f1 = localTextPaint.measureText("ABCabc123");
    if (Build.VERSION.SDK_INT >= 21) {}
    for (;;)
    {
      v = Boolean.valueOf(bool1);
      return v.booleanValue();
      if (Build.VERSION.SDK_INT >= 14)
      {
        if (f1 == 105.0F) {}
        for (bool1 = bool2;; bool1 = false)
        {
          v = Boolean.valueOf(bool1);
          break;
        }
      }
      if (f1 != 101.0F) {
        bool1 = false;
      }
    }
  }
  
  public static Typeface d()
  {
    if (x == null) {
      if (Build.VERSION.SDK_INT < 21) {
        break label28;
      }
    }
    label28:
    for (x = Typeface.create("sans-serif-medium", 0);; x = Typeface.createFromAsset(u.a().getAssets(), "fonts/Roboto-Medium.ttf")) {
      return x;
    }
  }
  
  public final void a(EditText paramEditText)
  {
    if (this.a >= 1.5F)
    {
      paramEditText.setMaxLines(6);
      return;
    }
    if (this.a >= 1.0F)
    {
      paramEditText.setMaxLines(5);
      return;
    }
    paramEditText.setMaxLines(4);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aoa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */