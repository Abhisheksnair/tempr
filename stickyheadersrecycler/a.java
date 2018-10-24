package com.whatsapp.stickyheadersrecycler;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.f;
import android.view.View;

public final class a
  extends RecyclerView.f
{
  private int a;
  
  public a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView)
  {
    paramView = (GridLayoutManager.b)paramView.getLayoutParams();
    int j = paramView.b();
    int i = ((GridLayoutManager)paramRecyclerView.getLayoutManager()).c();
    if ((j == i) || (i == 0))
    {
      paramRect.set(0, 0, 0, 0);
      return;
    }
    j = paramView.a();
    paramRect.top = 0;
    paramRect.bottom = this.a;
    paramRect.left = ((int)Math.floor(this.a * j / i));
    float f = this.a;
    paramRect.right = ((int)Math.ceil((i - j - 1) * f / i));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/stickyheadersrecycler/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */