package com.whatsapp;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;

public final class aag
  extends Animation
{
  private ImageView a;
  private int b;
  private boolean c;
  private Camera d;
  
  aag(ImageView paramImageView, int paramInt)
  {
    this.a = paramImageView;
    this.b = paramInt;
  }
  
  protected final void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    int i = (int)(180.0F * paramFloat) % 360;
    paramTransformation = paramTransformation.getMatrix();
    this.d.save();
    this.d.translate(0.0F, 0.0F, (float)(this.a.getWidth() * Math.sin(3.141592653589793D * i / 180.0D)));
    if (i < 90) {
      this.d.rotateY(i);
    }
    for (;;)
    {
      this.d.getMatrix(paramTransformation);
      this.d.restore();
      paramTransformation.preTranslate(-this.a.getWidth() / 2, -this.a.getHeight() / 2);
      paramTransformation.postTranslate(this.a.getWidth() / 2, this.a.getHeight() / 2);
      if ((i > 90) && (!this.c))
      {
        this.c = true;
        this.a.setImageResource(this.b);
      }
      return;
      this.d.rotateY(i + 180);
    }
  }
  
  public final void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.d = new Camera();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/aag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */