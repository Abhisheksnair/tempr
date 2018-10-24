package com.whatsapp.util;

import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;

public abstract class at
  implements View.OnClickListener
{
  private long a;
  
  public abstract void a(View paramView);
  
  public final void onClick(View paramView)
  {
    long l = SystemClock.elapsedRealtime();
    if (l - this.a > 1000L)
    {
      this.a = l;
      a(paramView);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */