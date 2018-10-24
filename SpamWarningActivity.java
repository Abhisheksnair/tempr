package com.whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.CountDownTimer;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.whatsapp.util.Log;

public class SpamWarningActivity
  extends nh
{
  private static ConditionVariable p = new ConditionVariable(false);
  final aus n = aus.a();
  private int o;
  
  public static void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      p.open();
      return;
    }
    p.close();
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.HOME");
    localIntent.setFlags(268435456);
    startActivity(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903079);
    setTitle(2131297883);
    int j = getIntent().getIntExtra("spam_warning_reason_key", 100);
    this.o = getIntent().getIntExtra("expiry_in_seconds", -1);
    Log.i("SpamWarningActivity started with code " + j + " and expiry (in seconds) " + this.o);
    int i;
    switch (j)
    {
    case 105: 
    default: 
      if (this.o == -1) {
        i = 2131297881;
      }
      break;
    }
    for (;;)
    {
      ((Button)findViewById(2131755318)).setOnClickListener(amf.a(this, j));
      ((TextView)findViewById(2131755317)).setText(i);
      if (this.o != -1) {
        break;
      }
      Log.d("unknown expiry time.");
      findViewById(2131755238).setVisibility(8);
      new Thread()
      {
        public final void run()
        {
          SpamWarningActivity.l().block();
          Intent localIntent = new Intent(null, null, SpamWarningActivity.this, Main.n());
          SpamWarningActivity.this.startActivity(localIntent);
          SpamWarningActivity.this.finish();
        }
      }.start();
      return;
      i = 2131297886;
      continue;
      i = 2131297884;
      continue;
      i = 2131297885;
      continue;
      i = 2131297888;
      continue;
      i = 2131297887;
      continue;
      i = 2131297879;
    }
    findViewById(2131755319).setVisibility(8);
    paramBundle = (CircularProgressBar)findViewById(2131755238);
    paramBundle.setVisibility(0);
    paramBundle.setProgressBarBackgroundColor(-65536);
    paramBundle.setProgressBarColor(-2039584);
    paramBundle.setPaintStrokeFactor(30.0F);
    paramBundle.setKnobEnabled(true);
    paramBundle.setMax(this.o * 1000);
    new CountDownTimer(this.o * 1000, paramBundle)
    {
      public final void onFinish()
      {
        SpamWarningActivity.this.finish();
      }
      
      public final void onTick(long paramAnonymousLong)
      {
        int i = (int)paramAnonymousLong / 1000;
        Log.d("expiryInSeconds:" + SpamWarningActivity.a(SpamWarningActivity.this) + " secondsPassed:" + i);
        this.a.setCenterText(DateUtils.formatElapsedTime(i));
        this.a.setProgress((int)paramAnonymousLong);
      }
    }.start();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/SpamWarningActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */