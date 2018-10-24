package com.whatsapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;

public class nm
  extends nh
{
  ListAdapter aT;
  private ListView n;
  private Handler o = new Handler(Looper.getMainLooper());
  private boolean p = false;
  private Runnable q = new Runnable()
  {
    public final void run()
    {
      nm.a(nm.this).focusableViewAvailable(nm.a(nm.this));
    }
  };
  private AdapterView.OnItemClickListener r = new AdapterView.OnItemClickListener()
  {
    public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong) {}
  };
  
  private void l()
  {
    if (this.n != null) {
      return;
    }
    setContentView(17367060);
  }
  
  public final ListView W()
  {
    l();
    return this.n;
  }
  
  public final void a(ListAdapter paramListAdapter)
  {
    try
    {
      l();
      this.aT = paramListAdapter;
      this.n.setAdapter(paramListAdapter);
      return;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    this.o.removeCallbacks(this.q);
    super.onDestroy();
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    l();
    super.onRestoreInstanceState(paramBundle);
  }
  
  public final void w_()
  {
    super.w_();
    View localView = findViewById(16908292);
    this.n = ((ListView)findViewById(16908298));
    if (this.n == null) {
      throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
    }
    if (localView != null) {
      this.n.setEmptyView(localView);
    }
    this.n.setOnItemClickListener(this.r);
    if (this.p) {
      a(this.aT);
    }
    this.o.post(this.q);
    this.p = true;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/nm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */