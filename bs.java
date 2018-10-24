package com.whatsapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.n;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public final class bs
  extends Fragment
{
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    paramLayoutInflater = (ViewGroup)paramLayoutInflater.inflate(2130903099, paramViewGroup, false);
    paramLayoutInflater.addView(new View(k())
    {
      View a;
      
      public final boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent)
      {
        if (this.a == null) {
          this.a = bs.this.l().findViewById(2131755414);
        }
        if (this.a == null) {
          return super.onTouchEvent(paramAnonymousMotionEvent);
        }
        return this.a.onTouchEvent(paramAnonymousMotionEvent);
      }
    }, 0);
    return paramLayoutInflater;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */