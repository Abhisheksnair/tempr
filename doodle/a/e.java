package com.whatsapp.doodle.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import org.json.JSONObject;

public abstract class e
{
  public static final a i = new a();
  public final RectF d = new RectF();
  public float e;
  public final Paint f = new Paint(1);
  public boolean g;
  public long h;
  
  e()
  {
    this.f.setStyle(Paint.Style.STROKE);
    this.f.setStrokeJoin(Paint.Join.ROUND);
    this.f.setStrokeCap(Paint.Cap.ROUND);
  }
  
  public static float b(int paramInt)
  {
    return paramInt / 100.0F;
  }
  
  public static int c(float paramFloat)
  {
    return (int)(100.0F * paramFloat);
  }
  
  public String a()
  {
    return "";
  }
  
  public void a(float paramFloat)
  {
    this.f.setStrokeWidth(paramFloat);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat3;
    if (paramFloat1 == paramFloat3) {
      f1 = paramFloat3 + 1.0F;
    }
    paramFloat3 = paramFloat4;
    if (paramFloat2 == paramFloat4) {
      paramFloat3 = paramFloat4 + 1.0F;
    }
    this.d.set(paramFloat1, paramFloat2, f1, paramFloat3);
    this.d.sort();
    g();
  }
  
  public void a(int paramInt)
  {
    this.f.setColor(paramInt);
  }
  
  public abstract void a(Canvas paramCanvas);
  
  public void a(b paramb)
  {
    this.d.set(paramb.b);
    this.e = paramb.a;
    a(paramb.c);
    a(paramb.d);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    paramJSONObject.put("type", a());
    paramJSONObject.put("l", (int)(this.d.left * 100.0F));
    paramJSONObject.put("t", (int)(this.d.top * 100.0F));
    paramJSONObject.put("r", (int)(this.d.right * 100.0F));
    paramJSONObject.put("b", (int)(this.d.bottom * 100.0F));
    if (this.e != 0.0F) {
      paramJSONObject.put("rotate", (int)(this.e * 100.0F));
    }
    paramJSONObject.put("color", this.f.getColor());
    paramJSONObject.put("stroke", (int)(f() * 100.0F));
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    return this.d.contains(paramFloat1, paramFloat2);
  }
  
  public final void b(float paramFloat)
  {
    this.e += paramFloat;
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    paramFloat2 = this.d.centerX();
    float f1 = this.d.centerY();
    this.d.set(paramFloat2 - (paramFloat2 - this.d.left) * paramFloat1, f1 - (f1 - this.d.top) * paramFloat1, paramFloat2 - (paramFloat2 - this.d.right) * paramFloat1, f1 - (f1 - this.d.bottom) * paramFloat1);
    g();
  }
  
  public void b(JSONObject paramJSONObject)
  {
    this.d.left = (paramJSONObject.getInt("l") / 100.0F);
    this.d.top = (paramJSONObject.getInt("t") / 100.0F);
    this.d.right = (paramJSONObject.getInt("r") / 100.0F);
    this.d.bottom = (paramJSONObject.getInt("b") / 100.0F);
    this.e = (paramJSONObject.optInt("rotate", 0) / 100.0F);
    a(paramJSONObject.getInt("color"));
    a(paramJSONObject.getInt("stroke") / 100.0F);
  }
  
  public boolean b()
  {
    return true;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean d()
  {
    return true;
  }
  
  public b e()
  {
    return new b(this.d, this.e, this.f.getColor(), f());
  }
  
  public float f()
  {
    return this.f.getStrokeWidth();
  }
  
  final void g()
  {
    if (this.d.width() < i.b) {
      this.d.set(this.d.centerX() - i.b / 2.0F, this.d.top, this.d.centerX() + i.b / 2.0F, this.d.bottom);
    }
    if (this.d.height() < i.b) {
      this.d.set(this.d.left, this.d.centerY() - i.b / 2.0F, this.d.right, this.d.centerY() + i.b / 2.0F);
    }
  }
  
  public int h()
  {
    return 1;
  }
  
  public boolean i()
  {
    return false;
  }
  
  public static final class a
  {
    public int a = -31;
    public float b = 12.0F;
    public float c = 24.0F;
    public float d = 96.0F;
    public float e = 24.0F;
    public float f = 96.0F;
    public float g = 32.0F;
  }
  
  public static class b
  {
    public final float a;
    public final RectF b = new RectF();
    public final int c;
    public final float d;
    
    public b(RectF paramRectF, float paramFloat1, int paramInt, float paramFloat2)
    {
      this.a = paramFloat1;
      this.b.set(paramRectF);
      this.c = paramInt;
      this.d = paramFloat2;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */