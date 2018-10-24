package com.whatsapp.registration;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.whatsapp.aat;
import com.whatsapp.and;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.i.b;
import com.whatsapp.i.b.e;
import com.whatsapp.nh;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;

public final class au
{
  final b a;
  final and b;
  final aat c;
  final atu d;
  final atv e;
  AsyncTask<String, Void, b.e> f;
  ProgressDialog g;
  nh h;
  
  public au(b paramb, and paramand, aat paramaat, atu paramatu, atv paramatv)
  {
    this.a = paramb;
    this.b = paramand;
    this.c = paramaat;
    this.d = paramatu;
    this.e = paramatv;
  }
  
  public final void a()
  {
    if ((this.g != null) && (this.g.isShowing())) {
      this.g.cancel();
    }
    this.h = null;
  }
  
  public final void a(final nh paramnh, final bk parambk, final String paramString)
  {
    this.h = paramnh;
    if (this.f != null) {
      this.f.cancel(true);
    }
    this.f = bu.a(new AsyncTask()
    {
      private b.e a()
      {
        try
        {
          b.e locale = b.a(parambk);
          return locale;
        }
        catch (Exception localException)
        {
          Log.d("Could not fetch help response", localException);
        }
        return null;
      }
      
      protected final void onPreExecute()
      {
        if (au.this.g == null)
        {
          au.this.g = new ProgressDialog(paramnh);
          au.this.g.setOnCancelListener(av.a(this));
          au.this.g.setCanceledOnTouchOutside(false);
        }
        if (!au.this.g.isShowing())
        {
          au.this.g.setMessage(paramnh.getString(2131297596));
          au.this.g.setIndeterminate(true);
          au.this.g.show();
        }
      }
    }, new String[0]);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/registration/au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */