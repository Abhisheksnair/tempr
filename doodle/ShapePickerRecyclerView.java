package com.whatsapp.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.util.AttributeSet;

public class ShapePickerRecyclerView
  extends RecyclerView
{
  private int M;
  
  public ShapePickerRecyclerView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ShapePickerRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ShapePickerRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.M = paramContext.getResources().getDimensionPixelSize(2131361989);
    setHasFixedSize(true);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.M > 0)
    {
      paramInt1 = Math.max(1, (getMeasuredWidth() + this.M / 2) / this.M);
      ((GridLayoutManager)getLayoutManager()).a(paramInt1);
    }
  }
  
  public void setAdapter(RecyclerView.a parama)
  {
    super.setAdapter(parama);
    int i = Math.max(1, (getMeasuredWidth() + this.M / 2) / this.M);
    setLayoutManager(new GridLayoutManager(getContext(), i));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/ShapePickerRecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */