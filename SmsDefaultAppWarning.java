package com.whatsapp;

import a.a.a.a.d;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.b.a;
import com.whatsapp.util.Log;

public class SmsDefaultAppWarning
  extends nh
{
  final void l()
  {
    ani.a(this, getIntent().getData(), null);
  }
  
  final void m()
  {
    ani.a(this, getIntent().getData(), getString(2131297981, new Object[] { "https://whatsapp.com/dl/" }));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("smsdefaultappwarning/create");
    paramBundle = new Intent("android.intent.action.SENDTO");
    paramBundle.setData(getIntent().getData());
    paramBundle = getPackageManager().resolveActivity(paramBundle, 0);
    if ((paramBundle != null) && (paramBundle.activityInfo != null) && ("com.whatsapp".equals(paramBundle.activityInfo.packageName)))
    {
      d.a(this, 0);
      return;
    }
    d.a(this, 1);
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 0: 
      return new b.a(this).b(2131298192).c(2131297860, alu.a(this)).b(2131297867, alv.a(this)).a(2131297868, alw.a(this)).a(alx.a(this)).a();
    }
    return new b.a(this).b(2131298191).c(2131297860, aly.a(this)).a(2131297868, alz.a(this)).a(ama.a(this)).a();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/SmsDefaultAppWarning.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */