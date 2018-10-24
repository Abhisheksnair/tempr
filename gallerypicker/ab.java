package com.whatsapp.gallerypicker;

import a.a.a.a.a.a.d;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.b;
import android.view.View;
import android.widget.ImageView.ScaleType;

public class ab
  extends View
{
  private boolean a;
  public q b;
  protected Drawable c;
  private Drawable d;
  private ImageView.ScaleType e = ImageView.ScaleType.CENTER_CROP;
  private Drawable f;
  private Matrix g = new Matrix();
  private int h;
  
  public ab(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    float f1 = 0.0F;
    if (this.f == null) {
      return;
    }
    int i = this.f.getIntrinsicWidth();
    int j = this.f.getIntrinsicHeight();
    int k = getWidth();
    int m = getHeight();
    this.f.setBounds(0, 0, i, j);
    if (ImageView.ScaleType.CENTER == this.e)
    {
      this.g.reset();
      this.g.setTranslate(Math.round((k - i) * 0.5F), Math.round((m - j) * 0.5F));
    }
    while (ImageView.ScaleType.CENTER_CROP != this.e)
    {
      this.h = k;
      return;
    }
    this.g.reset();
    float f3;
    float f2;
    if (i * m > k * j)
    {
      f3 = m / j;
      f2 = (k - i * f3) * 0.5F;
    }
    for (;;)
    {
      this.g.setScale(f3, f3);
      this.g.postTranslate(Math.round(f2), Math.round(f1));
      break;
      f3 = k / i;
      f1 = m;
      float f4 = j;
      f2 = 0.0F;
      f1 = (f1 - f4 * f3) * 0.5F;
    }
  }
  
  private void a(Drawable paramDrawable)
  {
    if (this.f != null)
    {
      this.f.setCallback(null);
      unscheduleDrawable(this.f);
    }
    this.f = paramDrawable;
    if (paramDrawable != null) {
      paramDrawable.setCallback(this);
    }
    a();
  }
  
  public void a(Canvas paramCanvas) {}
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable = this.d;
    if (localDrawable != null)
    {
      localDrawable.setBounds(0, 0, getWidth(), getHeight());
      localDrawable.draw(paramCanvas);
    }
  }
  
  @TargetApi(21)
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT < 21) {}
    Drawable localDrawable;
    do
    {
      return;
      super.drawableHotspotChanged(paramFloat1, paramFloat2);
      localDrawable = this.d;
      if (localDrawable != null) {
        localDrawable.setHotspot(paramFloat1, paramFloat2);
      }
      localDrawable = this.f;
    } while (localDrawable == null);
    localDrawable.setHotspot(paramFloat1, paramFloat2);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.d;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
    localDrawable = this.f;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  public Drawable getDrawable()
  {
    return this.f;
  }
  
  public q getMediaItem()
  {
    return this.b;
  }
  
  public Uri getUri()
  {
    return this.b.a();
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == this.f)
    {
      invalidate();
      return;
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  @TargetApi(11)
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    Drawable localDrawable = this.d;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
    localDrawable = this.f;
    if (localDrawable != null) {
      localDrawable.jumpToCurrentState();
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i;
    if (this.f != null)
    {
      i = paramCanvas.getSaveCount();
      paramCanvas.save();
      if (this.g != null) {
        paramCanvas.concat(this.g);
      }
      this.f.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
    a(paramCanvas);
    if (this.a)
    {
      if (this.c == null) {
        this.c = b.a(getContext(), 2130840445);
      }
      paramCanvas.drawColor(1073741824);
      i = (getWidth() - this.c.getIntrinsicWidth()) / 2;
      int j = (getHeight() - this.c.getIntrinsicHeight()) / 2;
      this.c.setBounds(i, j, this.c.getIntrinsicWidth() + i, this.c.getIntrinsicHeight() + j);
      this.c.draw(paramCanvas);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.h != getWidth()) {
      a();
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
    setMeasuredDimension(paramInt1, paramInt1);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.a != paramBoolean)
    {
      this.a = paramBoolean;
      invalidate();
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    a(new BitmapDrawable(getContext().getResources(), paramBitmap));
    invalidate();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    a(paramDrawable);
    invalidate();
  }
  
  public void setImageResource(int paramInt)
  {
    if (paramInt == 0) {}
    for (Drawable localDrawable = null;; localDrawable = b.a(getContext(), paramInt))
    {
      a(localDrawable);
      invalidate();
      return;
    }
  }
  
  public void setMediaItem(q paramq)
  {
    this.b = paramq;
    if (this.d == null)
    {
      this.d = b.a(getContext(), 2130840501);
      this.d.setCallback(this);
    }
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if ((paramScaleType == ImageView.ScaleType.CENTER_CROP) || (paramScaleType == ImageView.ScaleType.CENTER)) {}
    for (boolean bool = true;; bool = false)
    {
      a.d.a(bool, "only CENTER or CENTER_CROP supported");
      this.e = paramScaleType;
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (paramDrawable == this.d) || (paramDrawable == this.f) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */