package com.whatsapp.gallerypicker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.n;
import com.whatsapp.RequestPermissionActivity;
import com.whatsapp.acw;
import com.whatsapp.atu;
import com.whatsapp.util.Log;

public class GalleryPickerLauncher
  extends n
{
  private final acw n = acw.a();
  private final atu o = atu.a();
  
  private void i()
  {
    if (this.o.b())
    {
      Intent localIntent = new Intent(this, GalleryPicker.class);
      localIntent.putExtra("include_media", 1);
      localIntent.putExtra("max_items", 1);
      localIntent.putExtra("preview", false);
      localIntent.putExtra("output", Uri.fromFile(this.n.b()));
      startActivityForResult(localIntent, 1);
      return;
    }
    RequestPermissionActivity.b(this, 2131297450, 2131297419);
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
    Log.i("gallery/picker/launcher/create");
    super.onCreate(paramBundle);
    if (paramBundle == null) {
      i();
    }
  }
  
  public void onDestroy()
  {
    Log.i("gallery/picker/launcher/destroy");
    super.onDestroy();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/GalleryPickerLauncher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */