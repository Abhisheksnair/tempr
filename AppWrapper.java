package com.whatsapp;

import android.app.Application;
import android.content.res.Configuration;
import android.support.annotation.Keep;
import com.facebook.buck.android.support.exopackage.ApplicationLike;

@Keep
public class AppWrapper
  implements ApplicationLike
{
  private final u mApp;
  
  public AppWrapper(Application paramApplication)
  {
    this.mApp = new u(paramApplication);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.mApp.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate()
  {
    this.mApp.onCreate();
  }
  
  public void onLowMemory()
  {
    this.mApp.onLowMemory();
  }
  
  public void onTerminate()
  {
    this.mApp.onTerminate();
  }
  
  public void onTrimMemory(int paramInt)
  {
    this.mApp.onTrimMemory(paramInt);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/AppWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */