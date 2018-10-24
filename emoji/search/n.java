package com.whatsapp.emoji.search;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.support.v4.content.b;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.whatsapp.al;
import com.whatsapp.aoa;
import com.whatsapp.pv;

public final class n
  extends PopupWindow
{
  final Activity a;
  final pv b;
  final EmojiSearchContainer c;
  i d;
  View e;
  boolean f;
  final ViewTreeObserver.OnGlobalLayoutListener g = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      int[] arrayOfInt = new int[2];
      n.a(n.this).getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[1];
      int j = n.a(n.this).getHeight();
      if (n.b(n.this).getWindowManager().getDefaultDisplay().getHeight() - (i + j) < 128.0F * aoa.a().a)
      {
        i = 1;
        if (i == 0) {
          n.a(n.this, true);
        }
        if ((!n.c(n.this)) || (i == 0)) {
          break label136;
        }
        n.a(n.this, false);
        if (n.this.getInputMethodMode() == 1)
        {
          n.this.setInputMethodMode(2);
          n.this.update();
        }
      }
      label136:
      while (n.this.getInputMethodMode() == 1)
      {
        return;
        i = 0;
        break;
      }
      n.this.setInputMethodMode(1);
      n.this.update();
    }
  };
  
  public n(Activity paramActivity, pv parampv)
  {
    super(paramActivity);
    this.b = parampv;
    this.a = paramActivity;
    parampv = (FrameLayout)al.a(parampv, paramActivity.getLayoutInflater(), 2130903218);
    this.c = ((EmojiSearchContainer)parampv.findViewById(2131755563));
    int i = b.c(paramActivity.getApplicationContext(), 2131624028);
    int j = b.c(paramActivity.getApplicationContext(), 2131624027);
    setBackgroundDrawable(new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { i, j }));
    setWidth(-1);
    setHeight(-2);
    setContentView(parampv);
    setTouchable(true);
    setFocusable(true);
    setOutsideTouchable(true);
    setInputMethodMode(2);
    setTouchInterceptor(o.a(this));
  }
  
  public final void dismiss()
  {
    ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(getContentView().getWindowToken(), 0);
    this.e.getViewTreeObserver().removeGlobalOnLayoutListener(this.g);
    super.dismiss();
    this.d.b();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/emoji/search/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */