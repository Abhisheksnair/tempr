package com.whatsapp.camera;

import android.os.Bundle;
import com.whatsapp.util.Log;

public class LauncherCameraActivity
  extends CameraActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    Log.i("launchercameraactivity/create");
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    Log.i("launchercameraactivity/destroy");
    super.onDestroy();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/camera/LauncherCameraActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */