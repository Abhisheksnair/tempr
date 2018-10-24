package com.whatsapp.crop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.AppBarLayout.b;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public abstract class e
  extends ImageView
{
  private Matrix a = new Matrix();
  private Matrix b = new Matrix();
  protected final f c = new f(null);
  int d = -1;
  int e = -1;
  protected float f;
  Handler g = new Handler(Looper.getMainLooper());
  private Matrix h = new Matrix();
  private final float[] i = new float[9];
  private float j = 3.0F;
  private Runnable k;
  private AppBarLayout.b l;
  
  public e(Context paramContext)
  {
    super(paramContext);
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  public e(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private void a(f paramf, Matrix paramMatrix)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    float f3 = paramf.b();
    float f4 = paramf.a();
    paramMatrix.reset();
    float f5 = Math.min(Math.min(f1 / f3, this.j), Math.min(f2 / f4, this.j));
    Matrix localMatrix = new Matrix();
    if (paramf.b != null)
    {
      int m = paramf.a.getWidth() / 2;
      int n = paramf.a.getHeight() / 2;
      localMatrix.preTranslate(-m, -n);
      localMatrix.postConcat(paramf.b);
      localMatrix.postTranslate(paramf.b() / 2, paramf.a() / 2);
    }
    paramMatrix.postConcat(localMatrix);
    paramMatrix.postScale(f5, f5);
    paramMatrix.postTranslate((f1 - f3 * f5) / 2.0F, (f2 - f4 * f5) / 2.0F);
  }
  
  private void setImageBitmapResetBase$1fdc9e65(Bitmap paramBitmap)
  {
    a(new f(paramBitmap), true);
  }
  
  public void a()
  {
    setImageBitmapResetBase$1fdc9e65(null);
  }
  
  protected void a(float paramFloat1, float paramFloat2)
  {
    this.b.postTranslate(paramFloat1, paramFloat2);
  }
  
  protected void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = paramFloat1;
    if (paramFloat1 > this.f) {
      f1 = this.f;
    }
    paramFloat1 = f1 / getScale();
    this.b.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    setImageMatrix(getImageViewMatrix());
    b();
  }
  
  public final void a(final f paramf, final boolean paramBoolean)
  {
    float f1 = 1.0F;
    if (getWidth() <= 0)
    {
      this.k = new Runnable()
      {
        public final void run()
        {
          e.this.a(paramf, paramBoolean);
        }
      };
      return;
    }
    if (paramf.a != null)
    {
      a(paramf, this.a);
      Bitmap localBitmap = paramf.a;
      paramf = paramf.b;
      super.setImageBitmap(localBitmap);
      Drawable localDrawable = getDrawable();
      if (localDrawable != null)
      {
        localDrawable.setDither(true);
        localDrawable.setFilterBitmap(true);
      }
      this.c.a = localBitmap;
      this.c.b = paramf;
      if (paramBoolean) {
        this.b.reset();
      }
      setImageMatrix(getImageViewMatrix());
      if (this.c.a != null) {
        break label147;
      }
    }
    for (;;)
    {
      this.f = f1;
      return;
      this.a.reset();
      super.setImageBitmap(null);
      break;
      label147:
      f1 = Math.max(1.0F, Math.max(this.c.b() / this.d, this.c.a() / this.e) * 4.0F);
    }
  }
  
  protected final void b()
  {
    float f2 = 0.0F;
    if (this.c.a == null) {
      return;
    }
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF = new RectF(0.0F, 0.0F, this.c.a.getWidth(), this.c.a.getHeight());
    localMatrix.mapRect(localRectF);
    float f1 = localRectF.height();
    float f3 = localRectF.width();
    int m = getHeight();
    if (f1 < m) {
      f1 = (m - f1) / 2.0F - localRectF.top;
    }
    for (;;)
    {
      m = getWidth();
      if (f3 < m) {
        f2 = (m - f3) / 2.0F - localRectF.left;
      }
      for (;;)
      {
        a(f2, f1);
        setImageMatrix(getImageViewMatrix());
        return;
        if (localRectF.top > 0.0F)
        {
          f1 = -localRectF.top;
          break;
        }
        if (localRectF.bottom >= m) {
          break label235;
        }
        f1 = getHeight() - localRectF.bottom;
        break;
        if (localRectF.left > 0.0F) {
          f2 = -localRectF.left;
        } else if (localRectF.right < m) {
          f2 = m - localRectF.right;
        }
      }
      label235:
      f1 = 0.0F;
    }
  }
  
  public final void b(float paramFloat1, float paramFloat2)
  {
    if ((paramFloat1 != 0.0F) || (paramFloat2 != 0.0F))
    {
      a(paramFloat1, paramFloat2);
      setImageMatrix(getImageViewMatrix());
    }
  }
  
  public Matrix getImageViewMatrix()
  {
    this.h.set(this.a);
    this.h.postConcat(this.b);
    return this.h;
  }
  
  public float getScale()
  {
    this.b.getValues(this.i);
    return this.i[0];
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (getScale() > 1.0F))
    {
      a(1.0F, getWidth() / 2.0F, getHeight() / 2.0F);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.d = (paramInt3 - paramInt1);
    this.e = (paramInt4 - paramInt2);
    Runnable localRunnable = this.k;
    if (localRunnable != null)
    {
      this.k = null;
      localRunnable.run();
    }
    if (this.c.a != null)
    {
      a(this.c, this.a);
      setImageMatrix(getImageViewMatrix());
    }
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null)
    {
      super.setImageBitmap(paramBitmap);
      return;
    }
    setImageBitmapResetBase$1fdc9e65(paramBitmap);
  }
  
  public void setMaxProperScale(float paramFloat)
  {
    this.j = paramFloat;
  }
  
  public void setRecycler$5fd15037(AppBarLayout.b paramb)
  {
    this.l = paramb;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/crop/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */