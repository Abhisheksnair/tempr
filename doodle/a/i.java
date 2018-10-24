package com.whatsapp.doodle.a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.whatsapp.emoji.c;
import org.json.JSONObject;

public final class i
  extends e
{
  private static Typeface q;
  private static Typeface r;
  public String a;
  public TextPaint b = new TextPaint(1);
  float c;
  float j;
  float k;
  float l;
  public int m = 0;
  private final Context n;
  private String o;
  private StaticLayout p;
  
  public i(Context paramContext)
  {
    this.n = paramContext;
    this.f.setStyle(Paint.Style.FILL);
  }
  
  public static Typeface a(Context paramContext)
  {
    if (q == null) {
      q = Typeface.createFromAsset(paramContext.getAssets(), "fonts/Oswald-Heavy.ttf");
    }
    return q;
  }
  
  public static Typeface b(Context paramContext)
  {
    if (r == null) {
      r = Typeface.createFromAsset(paramContext.getAssets(), "fonts/Norican-Regular.ttf");
    }
    return r;
  }
  
  private void j()
  {
    int i = 0;
    if (TextUtils.isEmpty(this.a)) {
      return;
    }
    if (this.m == 3) {}
    for (String str = this.o;; str = this.a)
    {
      f2 = i.c + 1.0F;
      this.b.setTextSize(f2);
      for (f1 = Layout.getDesiredWidth(str, this.b); (f2 < i.d) && (f1 < this.d.width()); f1 = Layout.getDesiredWidth(str, this.b))
      {
        f2 += 1.0F;
        this.b.setTextSize(f2);
      }
    }
    this.b.setTextSize(f2 - 1.0F);
    this.b.setColor(this.f.getColor());
    this.p = new StaticLayout(c.a(str, this.n, this.b), this.b, (int)this.d.width() + 1, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
    this.k = 0.0F;
    while (i < this.p.getLineCount())
    {
      f1 = this.p.getLineWidth(i);
      if (f1 > this.k) {
        this.k = f1;
      }
      i += 1;
    }
    this.l = this.p.getHeight();
    float f1 = this.d.left;
    float f2 = this.d.top;
    float f3 = this.d.right;
    float f4 = this.d.bottom;
    this.d.set((f1 + f3 - this.k) / 2.0F, (f2 + f4 - this.l) / 2.0F, (f1 + f3 + this.k) / 2.0F, (f2 + f4 + this.l) / 2.0F);
    this.d.sort();
  }
  
  public final String a()
  {
    return "text";
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.c = Math.abs(paramFloat3 - paramFloat1);
    this.j = Math.abs(paramFloat4 - paramFloat2);
    this.d.set(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    this.d.sort();
    j();
  }
  
  public final void a(Canvas paramCanvas)
  {
    if (TextUtils.isEmpty(this.a)) {
      return;
    }
    this.d.sort();
    paramCanvas.save();
    float f;
    if (Math.abs(this.e) < 3.0F)
    {
      f = 0.0F;
      paramCanvas.rotate(f, this.d.centerX(), this.d.centerY());
      f = this.d.width() / this.k;
      paramCanvas.translate(this.d.left + this.d.width() / 2.0F - this.p.getWidth() * f / 2.0F, this.d.top);
      paramCanvas.scale(f, f, 0.0F, 0.0F);
      if (this.m != 3) {
        break label218;
      }
      this.b.setStrokeWidth(this.b.getTextSize() / 12.0F);
      this.b.setStyle(Paint.Style.STROKE);
      this.b.setColor(-16777216);
      this.p.draw(paramCanvas);
      this.b.setStrokeWidth(0.0F);
      this.b.setStyle(Paint.Style.FILL);
      this.b.setColor(-1);
      this.p.draw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      return;
      f = this.e;
      break;
      label218:
      this.b.setColor(this.f.getColor());
      this.p.draw(paramCanvas);
    }
  }
  
  public final void a(e.b paramb)
  {
    super.a(paramb);
    paramb = (a)paramb;
    a(paramb.e, paramb.f);
  }
  
  public final void a(String paramString, int paramInt)
  {
    boolean bool = true;
    this.a = paramString;
    this.o = paramString.toUpperCase();
    this.m = paramInt;
    if (paramInt == 3)
    {
      this.b.setTypeface(a(this.n));
      paramString = this.b;
      if (paramInt != 1) {
        break label297;
      }
    }
    for (;;)
    {
      paramString.setFakeBoldText(bool);
      if (this.k != 0.0F)
      {
        float f1 = this.d.width() / this.k;
        this.d.set(this.d.centerX() - this.c / 2.0F, this.d.centerY() - this.j / 2.0F, this.d.centerX() + this.c / 2.0F, this.d.centerY() + this.j / 2.0F);
        j();
        paramString = this.d;
        float f2 = this.d.centerX();
        float f3 = this.d.width() * f1 / 2.0F;
        float f4 = this.d.centerY();
        float f5 = this.d.height() * f1 / 2.0F;
        float f6 = this.d.centerX();
        float f7 = this.d.width() * f1 / 2.0F;
        float f8 = this.d.centerY();
        paramString.set(f2 - f3, f4 - f5, f6 + f7, f1 * this.d.height() / 2.0F + f8);
      }
      return;
      if (paramInt == 2)
      {
        this.b.setTypeface(b(this.n));
        break;
      }
      this.b.setTypeface(Typeface.DEFAULT);
      break;
      label297:
      bool = false;
    }
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    paramJSONObject.put("orig-w", (int)(this.c * 100.0F));
    paramJSONObject.put("orig-h", (int)(this.j * 100.0F));
    paramJSONObject.put("text", this.a);
    paramJSONObject.put("text-size", (int)(this.b.getTextSize() * 100.0F));
    paramJSONObject.put("style", this.m);
  }
  
  public final boolean a(float paramFloat1, float paramFloat2)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.setRotate(-this.e, this.d.centerX(), this.d.centerY());
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = paramFloat1;
    arrayOfFloat[1] = paramFloat2;
    localMatrix.mapPoints(arrayOfFloat);
    return this.d.contains(arrayOfFloat[0], arrayOfFloat[1]);
  }
  
  public final void b(JSONObject paramJSONObject)
  {
    int i = 0;
    super.b(paramJSONObject);
    this.c = (paramJSONObject.getInt("orig-w") / 100.0F);
    this.j = (paramJSONObject.getInt("orig-h") / 100.0F);
    this.k = 0.0F;
    a(paramJSONObject.getString("text"), paramJSONObject.getInt("style"));
    if (this.m == 3) {}
    for (String str = this.o;; str = this.a)
    {
      float f = paramJSONObject.getInt("text-size") / 100.0F;
      this.b.setTextSize(f);
      this.p = new StaticLayout(c.a(str, this.n, this.b), this.b, (int)this.c + 1, Layout.Alignment.ALIGN_CENTER, 1.0F, 0.0F, false);
      this.k = 0.0F;
      while (i < this.p.getLineCount())
      {
        f = this.p.getLineWidth(i);
        if (f > this.k) {
          this.k = f;
        }
        i += 1;
      }
    }
    this.l = this.p.getHeight();
  }
  
  public final boolean b()
  {
    return false;
  }
  
  public final void c(int paramInt)
  {
    boolean bool = true;
    if (this.m == paramInt) {
      return;
    }
    this.m = paramInt;
    label37:
    Object localObject;
    if (paramInt == 3)
    {
      this.b.setTypeface(a(this.n));
      localObject = this.b;
      if (paramInt != 1) {
        break label295;
      }
    }
    for (;;)
    {
      ((TextPaint)localObject).setFakeBoldText(bool);
      if (this.k == 0.0F) {
        break;
      }
      float f1 = this.d.width() / this.k;
      this.d.set(this.d.centerX() - this.c / 2.0F, this.d.centerY() - this.j / 2.0F, this.d.centerX() + this.c / 2.0F, this.d.centerY() + this.j / 2.0F);
      j();
      localObject = this.d;
      float f2 = this.d.centerX();
      float f3 = this.d.width() * f1 / 2.0F;
      float f4 = this.d.centerY();
      float f5 = this.d.height() * f1 / 2.0F;
      float f6 = this.d.centerX();
      float f7 = this.d.width() * f1 / 2.0F;
      float f8 = this.d.centerY();
      ((RectF)localObject).set(f2 - f3, f4 - f5, f6 + f7, f1 * this.d.height() / 2.0F + f8);
      return;
      if (paramInt == 2)
      {
        this.b.setTypeface(b(this.n));
        break label37;
      }
      this.b.setTypeface(Typeface.DEFAULT);
      break label37;
      label295:
      bool = false;
    }
  }
  
  public final e.b e()
  {
    return new a(this.d, this.e, this.f.getColor(), f(), this.a, this.m);
  }
  
  static final class a
    extends e.b
  {
    final String e;
    final int f;
    
    a(RectF paramRectF, float paramFloat1, int paramInt1, float paramFloat2, String paramString, int paramInt2)
    {
      super(paramFloat1, paramInt1, paramFloat2);
      this.e = paramString;
      this.f = paramInt2;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */