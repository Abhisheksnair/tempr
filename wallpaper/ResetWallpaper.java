package com.whatsapp.wallpaper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ResetWallpaper
  extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new Intent();
    if (g.a.equals(getIntent().getAction())) {
      paramBundle.putExtra("is_reset", true);
    }
    for (;;)
    {
      setResult(-1, paramBundle);
      finish();
      return;
      paramBundle.putExtra("is_default", true);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/wallpaper/ResetWallpaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */