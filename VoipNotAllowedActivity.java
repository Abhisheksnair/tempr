package com.whatsapp;

import a.a.a.a.a.a.d;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.protocol.j;
import com.whatsapp.util.Log;

public class VoipNotAllowedActivity
  extends nh
{
  private final e n = e.a();
  private final bb o = bb.a();
  private final bb.a p = new bb.a()
  {
    protected final void a(j paramAnonymousj)
    {
      Log.i("voipnotallowedactivity/onCallStarted finish this activity");
      super.a(paramAnonymousj);
      VoipNotAllowedActivity.this.finish();
    }
  };
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    LinearLayout localLinearLayout = (LinearLayout)a.d.a(findViewById(2131755340));
    if (paramConfiguration.orientation == 1)
    {
      localLinearLayout.setOrientation(1);
      return;
    }
    localLinearLayout.setOrientation(0);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    TextView localTextView1 = null;
    super.onCreate(paramBundle);
    Log.i("voipnotallowedactivity/create");
    setContentView(2130903400);
    paramBundle = (TextView)a.d.a(findViewById(2131755177));
    aoa.b(paramBundle);
    Object localObject = getIntent().getStringExtra("jid");
    int i = getIntent().getIntExtra("reason", 0);
    localObject = this.n.d((String)localObject);
    TextView localTextView2 = (TextView)a.d.a(findViewById(2131755691));
    switch (i)
    {
    default: 
      localTextView2.setText(getString(2131298156, new Object[] { ((cs)localObject).k() }));
      paramBundle = localTextView1;
      localTextView1 = (TextView)a.d.a(findViewById(2131755228));
      localObject = (TextView)a.d.a(findViewById(2131755578));
      if (paramBundle == null)
      {
        ((TextView)localObject).setVisibility(8);
        localTextView1.setText(2131297331);
        label209:
        localTextView1.setOnClickListener(ats.a(this));
        paramBundle = (LinearLayout)a.d.a(findViewById(2131755340));
        if (getResources().getConfiguration().orientation != 1) {
          break label599;
        }
        paramBundle.setOrientation(1);
      }
      break;
    }
    for (;;)
    {
      this.o.registerObserver(this.p);
      return;
      localTextView2.setText(getString(2131298159, new Object[] { ((cs)localObject).k() }));
      paramBundle = localTextView1;
      break;
      localTextView2.setText(getString(2131298160, new Object[] { ((cs)localObject).k() }));
      paramBundle = localTextView1;
      break;
      localTextView2.setText(getString(2131298158));
      paramBundle = aic.j().appendPath("general").appendPath("28030008").toString();
      break;
      localTextView2.setText(getString(2131298157, new Object[] { ((cs)localObject).k() }));
      paramBundle = aic.j().appendPath("general").appendPath("28030008").toString();
      break;
      paramBundle.setText(2131298165);
      localTextView2.setText(getIntent().getStringExtra("message"));
      paramBundle = localTextView1;
      break;
      paramBundle.setText(2131298165);
      localTextView2.setText(getString(2131298164, new Object[] { ((cs)localObject).k() }));
      paramBundle = localTextView1;
      break;
      localTextView2.setText(2131298179);
      paramBundle = localTextView1;
      break;
      localTextView2.setText(getString(2131298178, new Object[] { ((cs)localObject).k() }));
      paramBundle = localTextView1;
      break;
      localTextView2.setText(getString(2131298175, new Object[] { ((cs)localObject).k() }));
      paramBundle = localTextView1;
      break;
      localTextView2.setText(getString(2131298176, new Object[] { ((cs)localObject).k() }));
      paramBundle = localTextView1;
      break;
      localTextView2.setText(getString(2131298176, new Object[] { ((cs)localObject).k() }));
      paramBundle = localTextView1;
      break;
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setOnClickListener(atr.a(this, paramBundle));
      localTextView1.setText(2131297332);
      break label209;
      label599:
      paramBundle.setOrientation(0);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i("voipnotallowedactivity/destroy");
    this.o.unregisterObserver(this.p);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/VoipNotAllowedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */