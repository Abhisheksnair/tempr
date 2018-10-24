package com.whatsapp;

import android.content.Context;
import android.graphics.Canvas;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;

public final class iw
  extends hy
{
  int O;
  
  public iw(Context paramContext, j paramj)
  {
    super(paramContext, paramj);
  }
  
  public final void a(j paramj, boolean paramBoolean) {}
  
  protected final boolean a()
  {
    return false;
  }
  
  public final boolean a(j.b paramb)
  {
    return false;
  }
  
  protected final int getCenteredLayoutId()
  {
    return 0;
  }
  
  protected final int getIncomingLayoutId()
  {
    return 2130903134;
  }
  
  protected final int getOutgoingLayoutId()
  {
    return 2130903135;
  }
  
  public final void i() {}
  
  protected final void onDraw(Canvas paramCanvas) {}
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(0, this.O);
  }
  
  public final void setFixedHeight(int paramInt)
  {
    this.O = paramInt;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/iw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */