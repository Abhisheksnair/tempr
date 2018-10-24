package com.whatsapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;

public final class ans
  extends ThumbnailButton
{
  private int a = -1728053248;
  private int k = -1;
  private Drawable l;
  private CharSequence m;
  private float n = 15.0F;
  private int o = 17;
  private TextPaint p;
  private Paint q;
  private RectF r;
  private Rect s;
  
  public ans(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void a(Canvas paramCanvas)
  {
    super.a(paramCanvas);
    if (TextUtils.isEmpty(this.m)) {
      return;
    }
    if (this.q == null)
    {
      this.q = new Paint();
      this.q.setAntiAlias(true);
      this.q.setStyle(Paint.Style.FILL);
      this.q.setColor(this.a);
    }
    if (this.p == null)
    {
      this.p = new TextPaint();
      this.p.setAntiAlias(true);
      this.p.setColor(this.k);
      this.p.setTextSize(this.n);
      this.p.setTextAlign(Paint.Align.CENTER);
    }
    if (this.r == null) {
      this.r = new RectF();
    }
    if (this.s == null) {
      this.s = new Rect();
    }
    float f2 = this.n * 1.25F;
    float f3 = f2 - this.n;
    Object localObject = new Path();
    ((Path)localObject).moveTo(this.i.left, this.i.bottom - f2);
    ((Path)localObject).lineTo(this.i.right, this.i.bottom - f2);
    ((Path)localObject).lineTo(this.i.right, this.i.bottom - this.b);
    this.r.set(this.i.right - this.b * 2.0F, this.i.bottom - this.b * 2.0F, this.i.right, this.i.bottom);
    ((Path)localObject).arcTo(this.r, 0.0F, 90.0F);
    ((Path)localObject).lineTo(this.i.left + this.b, this.i.bottom);
    this.r.set(this.i.left, this.i.bottom - this.b * 2.0F, this.i.left + this.b * 2.0F, this.i.bottom);
    ((Path)localObject).arcTo(this.r, 90.0F, 90.0F);
    ((Path)localObject).lineTo(this.i.left, this.i.bottom - f2);
    paramCanvas.drawPath((Path)localObject, this.q);
    localObject = TextUtils.ellipsize(this.m, this.p, this.i.width() - this.b, TextUtils.TruncateAt.END).toString();
    this.p.getTextBounds((String)localObject, 0, ((String)localObject).length(), this.s);
    float f1;
    switch (this.o)
    {
    case 4: 
    default: 
      f1 = (this.i.right + this.i.left) / 2.0F;
    }
    for (;;)
    {
      paramCanvas.drawText((String)localObject, 0, ((String)localObject).length(), f1, this.i.bottom - f2 / 2.0F + this.n / 2.0F - this.p.descent() / 2.0F, this.p);
      if (this.l == null) {
        break;
      }
      f1 = this.l.getIntrinsicWidth() * this.n / this.l.getIntrinsicHeight();
      this.l.setBounds((int)(this.i.left + f3 + this.b), (int)(this.i.bottom - f2 + (f2 - this.n) / 2.0F), (int)(f1 + (this.i.left + f3 + this.b)), (int)(this.i.bottom - (f2 - this.n) / 2.0F));
      this.l.draw(paramCanvas);
      return;
      f1 = this.i.left + (this.s.right - this.s.left) / 2 + f3;
      continue;
      f1 = this.i.right - (this.s.right - this.s.left) / 2 - f3;
    }
  }
  
  public final void setIcon(Drawable paramDrawable)
  {
    this.l = paramDrawable;
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.m = paramCharSequence;
  }
  
  public final void setTextBackgroundColor(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void setTextColor(int paramInt)
  {
    this.k = paramInt;
  }
  
  public final void setTextGravity(int paramInt)
  {
    this.o = paramInt;
  }
  
  public final void setTextSize(float paramFloat)
  {
    this.n = paramFloat;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ans.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */