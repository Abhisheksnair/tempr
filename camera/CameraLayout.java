package com.whatsapp.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class CameraLayout
  extends FrameLayout
{
  private a a;
  private Display b = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
  private View c;
  private View d;
  private View e;
  private View f;
  
  public CameraLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CameraLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CameraLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = new a(paramContext);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.c == null)
    {
      this.c = findViewById(2131755408);
      this.d = findViewById(2131755410);
      this.e = findViewById(2131755409);
      this.f = findViewById(2131755411);
    }
    int n = this.c.getMeasuredWidth();
    int i2 = this.c.getMeasuredHeight();
    this.c.getPaddingTop();
    int i4 = this.c.getPaddingBottom();
    int i = this.d.getMeasuredWidth();
    int j = this.d.getMeasuredHeight();
    int m = this.e.getMeasuredWidth();
    int k = this.e.getMeasuredHeight();
    int i1 = this.f.getMeasuredWidth();
    int i3 = this.f.getMeasuredHeight();
    View localView;
    if (paramInt5 - paramInt3 > paramInt4 - paramInt2)
    {
      this.f.layout((paramInt2 + paramInt4 - i1) / 2, paramInt5 - i3 - i4 / 2, (i1 + (paramInt2 + paramInt4)) / 2, paramInt5 - i4 / 2);
      this.c.layout((paramInt2 + paramInt4 - n) / 2, paramInt5 - i2 - i3, (paramInt2 + paramInt4 + n) / 2, paramInt5 - i3);
      paramInt1 = (paramInt4 - paramInt2 - n) / 4;
      localView = this.e;
      paramInt3 = m / 2;
      n = i2 / 2;
      i1 = k / 2;
      m /= 2;
      i4 = i2 / 2;
      localView.layout(paramInt4 - paramInt1 - paramInt3, paramInt5 - n - i1 - i3, m + (paramInt4 - paramInt1), k / 2 + (paramInt5 - i4) - i3);
      this.d.layout(paramInt2 + paramInt1 - i / 2, paramInt5 - i2 / 2 - j / 2 - i3, paramInt1 + paramInt2 + i / 2, paramInt5 - i2 / 2 + j / 2 - i3);
      return;
    }
    int i5;
    if ((paramInt1 == 0) || (paramInt1 == 1))
    {
      this.c.layout(paramInt4 - n, (paramInt3 + paramInt5 - i2) / 2, paramInt4, (paramInt3 + paramInt5 + i2) / 2);
      paramInt1 = (paramInt5 - paramInt3 - i2) / 4;
      localView = this.e;
      i2 = n / 2;
      i3 = m / 2;
      i4 = k / 2;
      i5 = n / 2;
      localView.layout(paramInt4 - i2 - i3, paramInt3 + paramInt1 - i4, m / 2 + (paramInt4 - i5), k / 2 + (paramInt3 + paramInt1));
      this.d.layout(paramInt4 - n / 2 - i / 2, paramInt5 - paramInt1 - j / 2, paramInt4 - n / 2 + i / 2, paramInt5 - paramInt1 + j / 2);
    }
    for (;;)
    {
      this.f.layout((paramInt2 + paramInt4 - i1) / 2, paramInt5, (paramInt2 + paramInt4 + i1) / 2, paramInt5);
      return;
      this.c.layout(paramInt2, (paramInt3 + paramInt5 - i2) / 2, paramInt2 + n, (paramInt3 + paramInt5 + i2) / 2);
      paramInt1 = (paramInt5 - paramInt3 - i2) / 4;
      localView = this.e;
      i2 = n / 2;
      i3 = m / 2;
      i4 = k / 2;
      i5 = n / 2;
      localView.layout(i2 + paramInt2 - i3, paramInt3 + paramInt1 - i4, m / 2 + (i5 + paramInt2), k / 2 + (paramInt3 + paramInt1));
      this.d.layout(n / 2 + paramInt2 - i / 2, paramInt5 - paramInt1 - j / 2, n / 2 + paramInt2 + i / 2, paramInt5 - paramInt1 + j / 2);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.a.enable();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a.disable();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    a(this.b.getOrientation(), paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  final class a
    extends OrientationEventListener
  {
    int a = CameraLayout.a(CameraLayout.this).getOrientation();
    
    public a(Context paramContext)
    {
      super();
    }
    
    public final void onOrientationChanged(int paramInt)
    {
      paramInt = CameraLayout.a(CameraLayout.this).getOrientation();
      if ((paramInt != -1) && (((this.a == 1) && (paramInt == 3)) || ((this.a == 3) && (paramInt == 1)))) {
        CameraLayout.a(CameraLayout.this, paramInt, CameraLayout.a(CameraLayout.this).getWidth(), CameraLayout.a(CameraLayout.this).getHeight());
      }
      this.a = paramInt;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/camera/CameraLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */