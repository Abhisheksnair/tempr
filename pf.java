package com.whatsapp;

import a.a.a.a.a.a.d;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.Window;
import com.whatsapp.util.bm;

public class pf
  extends Dialog
{
  private final Activity a;
  private final int b;
  protected final pv j;
  
  public pf(Activity paramActivity)
  {
    this(paramActivity, 2130903214, false);
  }
  
  public pf(Activity paramActivity, int paramInt, boolean paramBoolean) {}
  
  public final void a()
  {
    onCreate(onSaveInstanceState());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    al.a(getWindow());
    super.onCreate(paramBundle);
    setContentView(al.a(this.j, ((Window)a.d.a(getWindow())).getLayoutInflater(), this.b, null, false));
    getWindow().setLayout(-1, -1);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    ViewGroup localViewGroup;
    if (av.j()) {
      localViewGroup = (ViewGroup)findViewById(16908290);
    }
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    case 24: 
      return true;
    case 84: 
      bm.a(localViewGroup, this.a, false);
      return true;
    }
    bm.a();
    return true;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/pf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */