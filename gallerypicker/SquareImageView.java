package com.whatsapp.gallerypicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.whatsapp.adn;

public class SquareImageView
  extends ImageView
{
  private int a = 0;
  
  public SquareImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SquareImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public SquareImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {}
    do
    {
      return;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, adn.SquareImageView);
    } while (paramContext == null);
    if (paramContext.hasValue(0)) {
      this.a = paramContext.getInt(0, this.a);
    }
    paramContext.recycle();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    switch (this.a)
    {
    default: 
      throw new IllegalArgumentException("Illegal value: " + this.a);
    }
    for (paramInt1 = getDefaultSize(getSuggestedMinimumWidth(), paramInt1);; paramInt1 = getDefaultSize(getSuggestedMinimumHeight(), paramInt2))
    {
      setMeasuredDimension(paramInt1, paramInt1);
      return;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/SquareImageView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */