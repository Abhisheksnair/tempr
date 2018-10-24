package com.whatsapp.registration;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.os.Bundle;
import android.support.v7.app.a;
import com.whatsapp.nh;
import com.whatsapp.pb;
import com.whatsapp.util.Log;

public class ChangeNumberOverview
  extends nh
{
  protected void onCreate(Bundle paramBundle)
  {
    Log.i("changenumberoverview/create");
    super.onCreate(paramBundle);
    pb.a(6);
    paramBundle = (a)a.d.a(i());
    paramBundle.a(true);
    paramBundle.c();
    setContentView(2130903105);
    d.a(paramBundle, this.aq, getString(2131297280).toUpperCase(), e.a(this));
  }
  
  protected void onDestroy()
  {
    Log.i("changenumberoverview/destroy");
    super.onDestroy();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/registration/ChangeNumberOverview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */