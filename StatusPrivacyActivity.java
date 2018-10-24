package com.whatsapp;

import a.a.a.a.a.a.d;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.a;
import android.view.View;
import android.widget.RadioButton;
import com.whatsapp.data.ad;
import com.whatsapp.data.co;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.bu;

public class StatusPrivacyActivity
  extends nh
{
  final att n = att.a();
  final co o = co.a();
  private RadioButton p;
  private RadioButton q;
  private RadioButton r;
  private final ad s = ad.a();
  
  private void l()
  {
    switch (this.o.f())
    {
    default: 
      throw new IllegalStateException("unknown status distribution mode");
    case 0: 
      this.p.setChecked(true);
      this.q.setChecked(false);
      this.r.setChecked(false);
      return;
    case 2: 
      this.p.setChecked(false);
      this.q.setChecked(false);
      this.r.setChecked(true);
      return;
    }
    this.p.setChecked(false);
    this.q.setChecked(true);
    this.r.setChecked(false);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 0)
    {
      if (paramInt2 == -1)
      {
        finish();
        return;
      }
      l();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("statusrecipientstype/create");
    super.onCreate(paramBundle);
    setContentView(2130903378);
    paramBundle = (a)a.d.a(i());
    paramBundle.a(true);
    paramBundle.a(2131297912);
    this.p = ((RadioButton)findViewById(2131756118));
    this.q = ((RadioButton)findViewById(2131756120));
    this.r = ((RadioButton)findViewById(2131756119));
    l();
    this.p.setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        StatusPrivacyActivity.a(StatusPrivacyActivity.this);
      }
    });
    this.q.setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        StatusPrivacyActivity.a(StatusPrivacyActivity.this, false);
      }
    });
    this.r.setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        StatusPrivacyActivity.a(StatusPrivacyActivity.this, true);
      }
    });
    if (!this.o.b()) {
      bu.a(amp.a(this));
    }
  }
  
  public void onDestroy()
  {
    Log.i("statusrecipientstype/destroy");
    super.onDestroy();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/StatusPrivacyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */