package com.whatsapp.wallpaper;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public final class h
  extends ImageView
{
  public h(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private h(Context paramContext, byte paramByte)
  {
    this(paramContext, '\000');
  }
  
  private h(Context paramContext, char paramChar)
  {
    super(paramContext, null, 0);
    super.setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  protected final boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = 0.0F;
    Object localObject = getDrawable();
    float f5;
    float f2;
    if (localObject != null)
    {
      f5 = ((Drawable)localObject).getIntrinsicWidth();
      f2 = ((Drawable)localObject).getIntrinsicHeight();
      localObject = g.f(getContext());
      float f7 = Math.max(((Point)localObject).x / f5, ((Point)localObject).y / f2);
      float f3 = (paramInt3 - paramInt1) / ((Point)localObject).x;
      float f6 = ((Point)localObject).x;
      float f4 = ((Point)localObject).y;
      f7 *= f3;
      localObject = getImageMatrix();
      ((Matrix)localObject).setScale(f7, f7, 0.0F, 0.0F);
      f5 = (f6 * f3 - f5 * f7) / 2.0F;
      f2 = (f4 * f3 - f2 * f7) / 2.0F;
      if (getResources().getConfiguration().orientation != 2) {
        break label185;
      }
    }
    for (;;)
    {
      ((Matrix)localObject).postTranslate(f5, f1);
      setImageMatrix((Matrix)localObject);
      return super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
      label185:
      f1 = f2;
    }
  }
  
  public final void setScaleType(ImageView.ScaleType paramScaleType) {}
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/wallpaper/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */