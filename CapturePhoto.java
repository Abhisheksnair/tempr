package com.whatsapp;

import a.a.a.a.d;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.n;
import com.whatsapp.util.Log;

public class CapturePhoto
  extends n
{
  private final pv n = pv.a();
  private final acw o = acw.a();
  private final atu p = atu.a();
  
  private void i()
  {
    Uri localUri;
    if (RequestPermissionActivity.a(this, this.p, 30)) {
      localUri = d.a(this, this.o.b());
    }
    try
    {
      startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", localUri).setFlags(2), 1);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Log.e("capturephoto/start-activity " + localActivityNotFoundException);
      pv.a(this, 2131296289, 0);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    case 1: 
      setResult(paramInt2, paramIntent);
      finish();
      return;
    }
    if (paramInt2 == -1)
    {
      i();
      return;
    }
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("capturephoto/create");
    super.onCreate(paramBundle);
    if (paramBundle == null) {
      i();
    }
  }
  
  public void onDestroy()
  {
    Log.i("capturephoto/destroy");
    super.onDestroy();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/CapturePhoto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */