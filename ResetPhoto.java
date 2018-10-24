package com.whatsapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.m;
import android.support.v4.app.n;
import android.support.v7.app.b.a;
import com.whatsapp.util.Log;

public class ResetPhoto
  extends n
{
  private static final String n = au.b() + ".intent.action.REMOVE_SCREENSHOT";
  private static final String o = au.b() + ".intent.action.RESET_GROUP_PHOTO";
  private final aus p = aus.a();
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.p.e();
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("resetphoto/create");
    this.p.e();
    super.onCreate(paramBundle);
    if (n.equals(getIntent().getAction()))
    {
      paramBundle = new Intent();
      paramBundle.putExtra("is_reset", true);
      setResult(-1, paramBundle);
      finish();
    }
    while (paramBundle != null) {
      return;
    }
    new a().a(j_(), null);
  }
  
  public void onDestroy()
  {
    Log.i("resetphoto/destroy");
    super.onDestroy();
  }
  
  public static final class a
    extends m
  {
    public final Dialog c(Bundle paramBundle)
    {
      if (ResetPhoto.i().equals(l().getIntent().getAction())) {}
      for (int i = 2131297603;; i = 2131297607) {
        return new b.a(l(), 2131427707).b(a(i)).a(true).b(2131296398, agr.a(this)).a(2131297598, ags.a(this)).a();
      }
    }
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      super.onDismiss(paramDialogInterface);
      paramDialogInterface = l();
      if (paramDialogInterface != null) {
        paramDialogInterface.finish();
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ResetPhoto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */