package com.whatsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.util.Log;

public class VoipPermissionsActivity
  extends Activity
{
  private String a;
  private Integer b;
  private boolean c;
  private boolean d;
  private final pv e = pv.a();
  private final br f = br.a();
  private final atu g = atu.a();
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.i("VoipPermissionsActivity onActivityResult got result: " + paramInt2 + " for request: " + paramInt1 + " data: " + paramIntent);
    switch (paramInt1)
    {
    default: 
      Log.i("VoipPermissionsActivity onActivityResult unhandled request: " + paramInt1 + " result: " + paramInt2);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    for (;;)
    {
      finish();
      return;
      if (paramInt2 == -1)
      {
        paramIntent = e.a().c(this.a);
        if (paramIntent != null)
        {
          Log.i("VoipPermissionsActivity onActivityResult starting call: " + paramIntent.t);
          this.f.a(paramIntent, this, this.b, this.c, this.d);
        }
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Log.i("voip/VoipPermissionsActivity/onCreate");
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    this.a = localIntent.getStringExtra("jid");
    if (localIntent.hasExtra("call_from")) {}
    for (paramBundle = Integer.valueOf(localIntent.getIntExtra("call_from", -1));; paramBundle = null)
    {
      this.b = paramBundle;
      this.c = localIntent.getBooleanExtra("smaller_call_btn", false);
      this.d = localIntent.getBooleanExtra("video_call", false);
      RequestPermissionActivity.a(this, this.e, this.g, this.a, this.d);
      return;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/VoipPermissionsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */