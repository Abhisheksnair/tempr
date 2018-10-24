package com.whatsapp.registration;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.CountDownTimer;
import android.text.format.DateUtils;
import android.widget.Button;
import android.widget.TextView;
import com.whatsapp.pv;
import com.whatsapp.util.Log;

final class a
{
  final Button a;
  final TextView b;
  CountDownTimer c;
  long d;
  final int e;
  final int f;
  private final String g;
  private final int h;
  private final int i;
  private final pv j;
  
  a(pv parampv, Activity paramActivity, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.j = parampv;
    this.g = paramString;
    this.h = paramInt3;
    this.i = paramInt4;
    this.e = paramInt5;
    this.f = paramInt6;
    this.a = ((Button)paramActivity.findViewById(paramInt1));
    this.b = ((TextView)paramActivity.findViewById(paramInt2));
    if (Build.VERSION.SDK_INT >= 14) {
      this.a.setAllCaps(false);
    }
    a(true);
  }
  
  static CharSequence a(long paramLong)
  {
    return DateUtils.formatElapsedTime(paramLong / 1000L);
  }
  
  public final void a()
  {
    if (this.c != null)
    {
      if (this.d > VerifySms.n) {
        return;
      }
      this.c.cancel();
      this.c = null;
      this.d = 0L;
    }
    a(VerifySms.n, false);
  }
  
  final void a(long paramLong, boolean paramBoolean)
  {
    if (paramLong < 3000L)
    {
      a(true);
      return;
    }
    a(false);
    if (this.c != null)
    {
      this.c.cancel();
      this.d = 0L;
    }
    Log.d("buttonwithprogress/" + this.g + "/disabling for " + paramLong);
    this.b.setText(a(paramLong));
    Log.d("buttonwithprogress/" + this.g + "/stating progress for " + paramLong + " at " + System.currentTimeMillis());
    this.c = new CountDownTimer(paramLong, paramBoolean)
    {
      public final void onFinish()
      {
        a.this.a(true);
        a.this.c = null;
      }
      
      public final void onTick(long paramAnonymousLong)
      {
        a.this.d = paramAnonymousLong;
        if (!this.a)
        {
          a.this.a.setText(a.this.e);
          a.this.b.setVisibility(8);
          return;
        }
        if (paramAnonymousLong > 3600000L)
        {
          paramAnonymousLong = (int)Math.ceil(paramAnonymousLong / 3600000.0D) * 3600000;
          long l = System.currentTimeMillis();
          a.this.a.setText(a.this.a.getContext().getString(a.this.f, new Object[] { DateUtils.getRelativeTimeSpanString(paramAnonymousLong + l, l, 0L) }));
          return;
        }
        a.this.a.setText(a.this.e);
        a.this.b.setVisibility(0);
        a.this.b.setText(a.a(paramAnonymousLong));
      }
    }.start();
  }
  
  public final void a(boolean paramBoolean)
  {
    this.a.setEnabled(paramBoolean);
    if (paramBoolean)
    {
      if (this.c != null)
      {
        this.c.cancel();
        this.c = null;
      }
      this.a.setEnabled(true);
      this.a.setText(this.e);
      if (this.j.d()) {
        this.a.setCompoundDrawablesWithIntrinsicBounds(this.h, 0, 0, 0);
      }
      for (;;)
      {
        this.b.setVisibility(8);
        return;
        this.a.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.h, 0);
      }
    }
    if (this.j.d()) {
      this.a.setCompoundDrawablesWithIntrinsicBounds(this.i, 0, 0, 0);
    }
    for (;;)
    {
      this.b.setVisibility(8);
      return;
      this.a.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.i, 0);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/registration/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */