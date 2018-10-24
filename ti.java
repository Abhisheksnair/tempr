package com.whatsapp;

import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class ti
  extends anx
{
  final String a;
  private Runnable c;
  private final pv d;
  
  public ti(pv parampv, String paramString, int paramInt)
  {
    super(paramInt, 1711315404);
    this.d = parampv;
    this.a = paramString;
  }
  
  public final void a(View paramView)
  {
    if (this.b) {
      pv.a(paramView.getContext(), Uri.parse(this.a));
    }
  }
  
  public final boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    super.a(paramView, paramMotionEvent);
    if (this.b)
    {
      paramMotionEvent = Uri.parse(this.a).getScheme();
      if (("http".equals(paramMotionEvent)) || ("https".equals(paramMotionEvent)) || ("rtsp".equals(paramMotionEvent)))
      {
        if (this.c == null) {
          this.c = tj.a(this, paramView);
        }
        this.d.a(this.c, ViewConfiguration.getLongPressTimeout());
      }
    }
    for (;;)
    {
      return false;
      if (this.c != null) {
        this.d.b(this.c);
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ti.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */