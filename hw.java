package com.whatsapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import com.whatsapp.emoji.h;
import com.whatsapp.util.a;

public class hw
  extends os
{
  public final and a;
  public boolean b;
  private View u;
  
  public hw(Activity paramActivity, pv parampv, h paramh, and paramand, atv paramatv)
  {
    this(paramActivity.getWindow().getDecorView(), paramActivity, parampv, paramh, paramand, paramatv);
  }
  
  public hw(View paramView, Activity paramActivity, pv parampv, h paramh, and paramand, atv paramatv)
  {
    super(paramView, paramActivity, parampv, paramh, paramatv);
    this.a = paramand;
  }
  
  public void a()
  {
    super.a();
    this.g.b();
    setTouchInterceptor(new View.OnTouchListener()
    {
      final int[] a = new int[2];
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        int j = (int)paramAnonymousMotionEvent.getX();
        int i = (int)paramAnonymousMotionEvent.getY();
        paramAnonymousView.getLocationOnScreen(this.a);
        int k = this.a[0];
        i += this.a[1];
        if (hw.a(hw.this) != null)
        {
          hw.a(hw.this).getLocationOnScreen(this.a);
          j = j + k - this.a[0];
          k = i - this.a[1];
          if ((j >= 0) && (j < hw.a(hw.this).getWidth()) && (k >= 0) && (k < hw.a(hw.this).getHeight()))
          {
            hw.this.t = true;
            return false;
          }
        }
        hw.this.h.getLocationOnScreen(this.a);
        i -= this.a[1];
        if ((i >= 0) && (i < hw.this.h.getHeight())) {
          return true;
        }
        hw.this.g.a(paramAnonymousView, paramAnonymousMotionEvent);
        return false;
      }
    });
    setFocusable(false);
  }
  
  public void a(View paramView1, ImageButton paramImageButton, View paramView2)
  {
    int i = 1;
    this.u = paramView2;
    paramView2 = new int[2];
    paramView1.getLocationOnScreen(paramView2);
    int j = paramView2[1] + paramView1.getHeight();
    int k = this.c.getWindowManager().getDefaultDisplay().getHeight();
    if (k - j < 128.0F * aoa.a().a) {
      if ((i == 0) && (!this.b) && (this.t)) {
        if (this.c.getResources().getConfiguration().orientation != 2) {
          break label149;
        }
      }
    }
    label149:
    for (paramView2 = "emoji_popup_landscape_height";; paramView2 = "emoji_popup_height")
    {
      this.c.getApplicationContext().getSharedPreferences("com.whatsapp_preferences", 0).edit().putInt(paramView2, k - j).apply();
      super.a(paramView1, paramImageButton);
      return;
      i = 0;
      break;
    }
  }
  
  protected final int b()
  {
    int i = 1;
    int[] arrayOfInt = new int[2];
    this.i.getLocationOnScreen(arrayOfInt);
    int j = arrayOfInt[1] + this.i.getHeight();
    int k = this.c.getWindowManager().getDefaultDisplay().getHeight();
    if (k - j < 128.0F * aoa.a().a) {}
    while (this.b) {
      if (a.a)
      {
        if (i != 0)
        {
          j = c();
          i = j;
          if (j == 0) {
            i = k / 2;
          }
          return i;
          i = 0;
        }
        else
        {
          return k - j;
        }
      }
      else {
        return -2;
      }
    }
    return super.b();
  }
  
  public final int c()
  {
    if (this.c.getResources().getConfiguration().orientation == 2) {}
    for (String str = "emoji_popup_landscape_height";; str = "emoji_popup_height") {
      return this.c.getApplicationContext().getSharedPreferences("com.whatsapp_preferences", 0).getInt(str, 0);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/hw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */