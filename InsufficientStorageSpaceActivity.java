package com.whatsapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.whatsapp.fieldstats.events.aq;
import com.whatsapp.fieldstats.l;
import com.whatsapp.util.Log;
import java.util.Locale;

public class InsufficientStorageSpaceActivity
  extends nh
{
  long n;
  private final vv o = vv.a();
  
  public static boolean l()
  {
    return System.currentTimeMillis() - m().getLong("insufficient_storage_prompt_timestamp", -1L) > 43200000L;
  }
  
  static SharedPreferences m()
  {
    return u.a().getSharedPreferences("com.whatsapp_preferences", 0);
  }
  
  public void onBackPressed()
  {
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.HOME");
    localIntent.setFlags(268435456);
    startActivity(localIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903076);
    Log.d("InsufficientStorageSpaceActivity/create");
    paramBundle = (Button)findViewById(2131755286);
    TextView localTextView = (TextView)findViewById(2131755285);
    this.n = getIntent().getLongExtra("spaceNeededInBytes", -1L);
    localTextView.setText(String.format(getString(2131297059), new Object[] { Formatter.formatShortFileSize(this, this.n) }));
    paramBundle.setOnClickListener(td.a(this));
    if ((getIntent() != null) && (getIntent().getBooleanExtra("allowSkipKey", false))) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramBundle = (Button)findViewById(2131755287);
        paramBundle.setVisibility(0);
        paramBundle.setOnClickListener(te.a(this));
      }
      return;
    }
  }
  
  protected void onResume()
  {
    boolean bool = false;
    super.onResume();
    long l = vv.e();
    Log.i(String.format(Locale.ENGLISH, "insufficient-storage-activity/internal-storage available: %,d required: %,d", new Object[] { Long.valueOf(l), Long.valueOf(this.n) }));
    if (l > this.n)
    {
      Log.i("insufficient-storage-activity/space-available/finishing-the-activity");
      if (this.n > 0L)
      {
        aq localaq = new aq();
        localaq.a = Long.valueOf(this.n);
        if (findViewById(2131755287).getVisibility() == 0) {
          bool = true;
        }
        localaq.b = Boolean.valueOf(bool);
        localaq.c = Integer.valueOf(1);
        l.a(this, localaq);
      }
      finish();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/InsufficientStorageSpaceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */