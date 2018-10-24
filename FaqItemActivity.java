package com.whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.a;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import com.whatsapp.util.Log;

public class FaqItemActivity
  extends nh
  implements ahw
{
  private long n;
  private long o;
  private long p;
  private long q;
  
  public final void l()
  {
    finish();
  }
  
  public void onBackPressed()
  {
    this.q = System.currentTimeMillis();
    this.o += this.q - this.p;
    this.p = System.currentTimeMillis();
    Log.d("faq-item/back-pressed has been called with " + this.o / 1000L + " seconds.");
    setResult(-1, new Intent().putExtra("article_id", this.n).putExtra("total_time_spent", this.o));
    super.onBackPressed();
    overridePendingTransition(2130968601, 2130968604);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    i().a(true);
    setContentView(2130903226);
    paramBundle = getIntent().getStringExtra("title");
    i().a(paramBundle);
    paramBundle = getIntent().getStringExtra("content");
    Object localObject = getIntent().getStringExtra("url");
    ((WebView)findViewById(2131755774)).loadDataWithBaseURL((String)localObject, paramBundle, "text/html", "UTF-8", null);
    this.n = getIntent().getLongExtra("article_id", -1L);
    this.o = 0L;
    if (getIntent().getBooleanExtra("show_contact_support_button", false))
    {
      paramBundle = getIntent().getStringExtra("contact_us_context");
      localObject = findViewById(2131755775);
      ((View)localObject).setOnClickListener(pa.a(this, paramBundle));
      ((View)localObject).setVisibility(0);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    finish();
    overridePendingTransition(2130968601, 2130968604);
    return true;
  }
  
  public void onPause()
  {
    super.onPause();
    this.q = System.currentTimeMillis();
    this.o += this.q - this.p;
    this.p = System.currentTimeMillis();
  }
  
  public void onResume()
  {
    super.onResume();
    this.p = System.currentTimeMillis();
  }
  
  public void onStop()
  {
    super.onStop();
    this.q = System.currentTimeMillis();
    this.o += this.q - this.p;
    this.p = System.currentTimeMillis();
    Log.d("faq-item/stop has been called with " + this.o / 1000L + " seconds.");
    setResult(-1, new Intent().putExtra("article_id", this.n).putExtra("total_time_spent", this.o));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/FaqItemActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */