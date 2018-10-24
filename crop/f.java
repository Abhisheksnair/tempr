package com.whatsapp.crop;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public final class f
{
  Bitmap a;
  Matrix b;
  
  public f(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.b != null)
    {
      float[] arrayOfFloat = new float[2];
      float[] tmp16_15 = arrayOfFloat;
      tmp16_15[0] = 0.0F;
      float[] tmp20_16 = tmp16_15;
      tmp20_16[1] = 1.0F;
      tmp20_16;
      this.b.mapVectors(arrayOfFloat);
      bool1 = bool2;
      if (arrayOfFloat[0] != 0.0F) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final int a()
  {
    if (c()) {
      return this.a.getWidth();
    }
    return this.a.getHeight();
  }
  
  public final int b()
  {
    if (c()) {
      return this.a.getHeight();
    }
    return this.a.getWidth();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/crop/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */