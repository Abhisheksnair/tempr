package com.whatsapp;

import android.content.Context;
import android.content.Intent;
import android.text.style.ClickableSpan;
import android.view.View;
import com.whatsapp.util.Log;

public class j
  extends ClickableSpan
{
  private final Intent a;
  
  public j(Intent paramIntent)
  {
    this.a = paramIntent;
  }
  
  public void onClick(View paramView)
  {
    Log.i("activity-intent-span/go intent=" + this.a);
    paramView.getContext().startActivity(this.a);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */