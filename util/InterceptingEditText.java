package com.whatsapp.util;

import android.content.Context;
import android.support.v7.widget.n;
import android.util.AttributeSet;
import android.view.KeyEvent;

public class InterceptingEditText
  extends n
{
  private a a;
  
  public InterceptingEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public InterceptingEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public InterceptingEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 1))
    {
      if (this.a != null) {
        this.a.a();
      }
      return true;
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  public void setOnBackButtonListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/InterceptingEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */