package com.whatsapp;

import android.content.Context;
import android.support.v4.view.ab;
import android.support.v4.widget.m;
import android.support.v4.widget.m.a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;

public class DeclineCallLayout
  extends FrameLayout
{
  private m a = m.a(this, new b((byte)0));
  private View b;
  private View c;
  private a d;
  private ViewConfiguration e = ViewConfiguration.get(getContext());
  
  public DeclineCallLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DeclineCallLayout(Context paramContext, AttributeSet paramAttributeSet)
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
    this.b = findViewById(2131755332);
    this.c = findViewById(2131755331);
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
  
  public void setDeclineCallListener(a parama)
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
      paramInt2 = DeclineCallLayout.this.getPaddingTop();
      int i = DeclineCallLayout.this.getHeight();
      int j = paramView.getHeight();
      return Math.min(Math.max(paramInt1, paramInt2), i - j);
    }
    
    public final void a(int paramInt)
    {
      super.a(paramInt);
    }
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      super.a(paramView, paramFloat1, paramFloat2);
      if ((this.c - paramView.getTop() > DeclineCallLayout.this.getHeight() / 16) && (DeclineCallLayout.b(DeclineCallLayout.this) != null))
      {
        VoipActivityV2.G(DeclineCallLayout.b(DeclineCallLayout.this).a);
        return;
      }
      DeclineCallLayout.c(DeclineCallLayout.this).a(this.b, this.c);
      DeclineCallLayout.this.invalidate();
    }
    
    public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((this.c - paramView.getTop() > DeclineCallLayout.d(DeclineCallLayout.this).getScaledTouchSlop()) && (DeclineCallLayout.e(DeclineCallLayout.this).getVisibility() == 0))
      {
        DeclineCallLayout.e(DeclineCallLayout.this).clearAnimation();
        DeclineCallLayout.e(DeclineCallLayout.this).setVisibility(4);
      }
    }
    
    public final boolean a(View paramView, int paramInt)
    {
      return paramView == DeclineCallLayout.a(DeclineCallLayout.this);
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
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/DeclineCallLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */