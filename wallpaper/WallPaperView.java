package com.whatsapp.wallpaper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.whatsapp.Conversation;
import com.whatsapp.aqs;
import com.whatsapp.util.Log;

public class WallPaperView
  extends ImageView
{
  private Rect a;
  private Bitmap b;
  private boolean c;
  private a d;
  
  public WallPaperView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  public final void a()
  {
    this.c = false;
    setImageDrawable(null);
    this.b = null;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 1;
    int j = getMeasuredWidth();
    int k = getMeasuredHeight();
    if (this.a == null)
    {
      Log.i("redraw:" + j + " | " + k);
      this.a = new Rect(0, 0, j, k);
    }
    for (;;)
    {
      super.onDraw(paramCanvas);
      if (((i != 0) || (this.c)) && (k > 0) && (j > 0))
      {
        if (this.d != null)
        {
          paramCanvas = this.d.a;
          if (paramCanvas.N != null) {
            paramCanvas.N.f();
          }
        }
        if (this.b != null) {
          this.c = false;
        }
      }
      return;
      if ((this.a.width() != j) || (this.a.height() != k))
      {
        this.a.set(0, 0, j, k);
        Log.i("redraw changed:" + j + " | " + k);
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public void setDrawable(Drawable paramDrawable)
  {
    this.c = true;
    this.b = ((BitmapDrawable)paramDrawable).getBitmap();
    setImageBitmap(this.b);
    invalidate();
  }
  
  protected boolean setFrame(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
    {
      Matrix localMatrix = getImageMatrix();
      float f = Math.max((paramInt3 - paramInt1) / localDrawable.getIntrinsicWidth(), (paramInt4 - paramInt2) / localDrawable.getIntrinsicHeight());
      localMatrix.setScale(f, f, 0.0F, 0.0F);
      setImageMatrix(localMatrix);
    }
    return super.setFrame(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setOnSizeChangedListener(a parama)
  {
    this.d = parama;
  }
  
  public static final class a
  {
    public final Conversation a;
    
    public a(Conversation paramConversation)
    {
      this.a = paramConversation;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/wallpaper/WallPaperView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */