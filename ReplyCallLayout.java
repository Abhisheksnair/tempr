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

public class ReplyCallLayout
  extends FrameLayout
{
  private m a = m.a(this, new a((byte)0));
  private View b;
  private View c;
  private b d;
  private ViewConfiguration e = ViewConfiguration.get(getContext());
  
  public ReplyCallLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReplyCallLayout(Context paramContext, AttributeSet paramAttributeSet)
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
    this.b = findViewById(2131755338);
    this.c = findViewById(2131755337);
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
  
  public void setDeclineCallWithMessageListener(b paramb)
  {
    this.d = paramb;
  }
  
  final class a
    extends m.a
  {
    private int b;
    private int c;
    
    private a() {}
    
    public final int a(View paramView, int paramInt1, int paramInt2)
    {
      if (paramInt2 > 0) {
        return paramView.getTop();
      }
      paramInt2 = ReplyCallLayout.this.getPaddingTop();
      int i = ReplyCallLayout.this.getHeight();
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
      if ((this.c - paramView.getTop() > ReplyCallLayout.this.getHeight() / 16) && (ReplyCallLayout.b(ReplyCallLayout.this) != null)) {
        VoipActivityV2.H(ReplyCallLayout.b(ReplyCallLayout.this).a);
      }
      ReplyCallLayout.c(ReplyCallLayout.this).a(this.b, this.c);
      ReplyCallLayout.this.invalidate();
    }
    
    public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((this.c - paramView.getTop() > ReplyCallLayout.d(ReplyCallLayout.this).getScaledTouchSlop()) && (ReplyCallLayout.e(ReplyCallLayout.this).getVisibility() == 0))
      {
        ReplyCallLayout.e(ReplyCallLayout.this).clearAnimation();
        ReplyCallLayout.e(ReplyCallLayout.this).setVisibility(4);
      }
    }
    
    public final boolean a(View paramView, int paramInt)
    {
      return paramView == ReplyCallLayout.a(ReplyCallLayout.this);
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
  
  static final class b
  {
    final VoipActivityV2 a;
    
    b(VoipActivityV2 paramVoipActivityV2)
    {
      this.a = paramVoipActivityV2;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ReplyCallLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */