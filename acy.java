package com.whatsapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.KeyEvent;

public final class acy
  extends ProgressDialog
{
  public acy(Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 84) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/acy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */