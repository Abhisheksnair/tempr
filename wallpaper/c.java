package com.whatsapp.wallpaper;

import android.content.Context;
import android.widget.ImageView;

public final class c
  extends ImageView
{
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
    setMeasuredDimension(paramInt1, (int)(paramInt1 * 1.5D));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/wallpaper/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */