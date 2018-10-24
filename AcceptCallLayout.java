package com.whatsapp;

import a.a.a.a.d;
import android.content.Context;
import android.support.v4.view.ab;
import android.support.v4.widget.m;
import android.support.v4.widget.m.a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class AcceptCallLayout
  extends FrameLayout
{
  private m a = m.a(this, new b((byte)0));
  private ImageView b;
  private View c;
  private a d;
  
  public AcceptCallLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AcceptCallLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    if (this.a.b()) {
      ab.c(this);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = ((ImageView)findViewById(2131755335));
    this.c = findViewById(2131755334);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if ((i == 3) || (i == 1))
    {
      this.a.a();
      return false;
    }
    return this.a.a(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.a.b(paramMotionEvent);
    return true;
  }
  
  public void setAcceptCallListener(a parama)
  {
    this.d = parama;
  }
  
  static final class a
  {
    final VoipActivityV2 a;
    
    a(VoipActivityV2 paramVoipActivityV2)
    {
      this.a = paramVoipActivityV2;
    }
  }
  
  final class b
    extends m.a
  {
    private int b;
    private int c;
    
    private b() {}
    
    public final int a(View paramView, int paramInt1, int paramInt2)
    {
      if (paramInt2 > 0) {
        return paramView.getTop();
      }
      paramInt2 = AcceptCallLayout.this.getPaddingTop();
      int i = AcceptCallLayout.this.getHeight();
      int j = paramView.getHeight();
      return Math.min(Math.max(paramInt1, paramInt2), i - j);
    }
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      super.a(paramView, paramFloat1, paramFloat2);
      if ((this.c - paramView.getTop() > AcceptCallLayout.this.getHeight() / 16) && (AcceptCallLayout.c(AcceptCallLayout.this) != null))
      {
        VoipActivityV2.F(AcceptCallLayout.c(AcceptCallLayout.this).a);
        return;
      }
      AcceptCallLayout.d(AcceptCallLayout.this).a(this.b, this.c);
      paramView = d.d(AcceptCallLayout.a(AcceptCallLayout.this));
      AcceptCallLayout.a(AcceptCallLayout.this).startAnimation(paramView);
      AcceptCallLayout.b(AcceptCallLayout.this).setVisibility(0);
      AcceptCallLayout.this.invalidate();
    }
    
    public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public final boolean a(View paramView, int paramInt)
    {
      return paramView == AcceptCallLayout.a(AcceptCallLayout.this);
    }
    
    public final int b(View paramView, int paramInt)
    {
      return paramView.getLeft();
    }
    
    public final void c(View paramView, int paramInt)
    {
      super.c(paramView, paramInt);
      this.b = paramView.getLeft();
      this.c = paramView.getTop();
      AcceptCallLayout.a(AcceptCallLayout.this).clearAnimation();
      AcceptCallLayout.b(AcceptCallLayout.this).setVisibility(8);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/AcceptCallLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */