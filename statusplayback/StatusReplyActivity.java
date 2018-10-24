package com.whatsapp.statusplayback;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ab;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.whatsapp.MessageReplyActivity;
import com.whatsapp.util.Log;

public class StatusReplyActivity
  extends MessageReplyActivity
{
  private final Rect A = new Rect();
  private final Runnable B = y.a(this);
  private final ViewTreeObserver.OnGlobalLayoutListener C = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      StatusReplyActivity.a(StatusReplyActivity.this);
      StatusReplyActivity.c(StatusReplyActivity.this).removeCallbacks(StatusReplyActivity.b(StatusReplyActivity.this));
      StatusReplyActivity.d(StatusReplyActivity.this).postDelayed(StatusReplyActivity.b(StatusReplyActivity.this), StatusReplyActivity.this.getResources().getInteger(17694722));
    }
  };
  
  private void t()
  {
    this.r.getWindowVisibleDisplayFrame(this.A);
    int i = this.A.height();
    int j = this.s.getMeasuredHeight();
    int[] arrayOfInt = new int[2];
    this.r.getLocationOnScreen(arrayOfInt);
    int k = arrayOfInt[1];
    ab.e(this.s, i - j - k - this.s.getTop());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("statusreply/create");
    getWindow().setFlags(1024, 1024);
    if (Build.VERSION.SDK_INT >= 19)
    {
      getWindow().setFlags(134217728, 134217728);
      getWindow().setFlags(67108864, 67108864);
    }
    super.onCreate(paramBundle);
    if (this.r == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      this.r.setSystemUiVisibility(4);
    }
    this.r.getViewTreeObserver().addOnGlobalLayoutListener(this.C);
  }
  
  public void onDestroy()
  {
    Log.i("statusreply/destroy");
    super.onDestroy();
    if (this.r != null)
    {
      this.r.getViewTreeObserver().removeGlobalOnLayoutListener(this.C);
      this.r.removeCallbacks(this.B);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/statusplayback/StatusReplyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */