package com.whatsapp.videoplayback;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.view.TextureView;

@TargetApi(14)
public final class n
  extends TextureView
{
  private int a;
  
  public n(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.a == 90) || (this.a == 270))
    {
      int i = this.a;
      int j = getMeasuredWidth();
      int k = getMeasuredHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.postRotate(i, j / 2.0F, k / 2.0F);
      localMatrix.postScale(j / k, k / j, j / 2.0F, k / 2.0F);
      setTransform(localMatrix);
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final void setRotationAngle(int paramInt)
  {
    if (this.a != paramInt)
    {
      this.a = paramInt;
      requestLayout();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/videoplayback/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */