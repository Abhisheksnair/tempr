package com.whatsapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.whatsapp.data.ad;
import com.whatsapp.registration.aw;

public class OverlayAlert
  extends Activity
{
  final ad a = ad.a();
  final aw b = aw.a();
  private final pv c = pv.a();
  private final aus d = aus.a();
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.d.e();
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.d.e();
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    if (Build.VERSION.SDK_INT >= 11) {
      setFinishOnTouchOutside(false);
    }
    setContentView(al.a(this.c, getLayoutInflater(), 2130903328, null, false));
    paramBundle = (Button)findViewById(2131755642);
    paramBundle.setText(2131296442);
    paramBundle.setOnClickListener(abe.a(this));
    paramBundle = (Button)findViewById(2131755679);
    paramBundle.setText(2131297339);
    paramBundle.setOnClickListener(abf.a(this));
    int i = getIntent().getIntExtra("stringid", -1);
    if (i == -1)
    {
      finish();
      return;
    }
    ((TextView)findViewById(2131755999)).setText(getString(i));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/OverlayAlert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */