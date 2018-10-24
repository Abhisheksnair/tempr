package com.whatsapp;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.m;
import android.support.v4.view.o;
import android.support.v7.app.a;
import android.support.v7.app.b.a;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.whatsapp.messaging.aj;
import com.whatsapp.qrcode.QrCodeActivity;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.util.l;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class WebSessionsActivity
  extends nh
{
  c n;
  private View o;
  private View p;
  private HashMap<String, CountDownTimer> q;
  private auj.s r = new auj.s()
  {
    public final void a()
    {
      if (!WebSessionsActivity.this.isFinishing()) {
        WebSessionsActivity.this.runOnUiThread(auo.a(this));
      }
    }
    
    public final void a(int paramAnonymousInt) {}
  };
  private final Runnable s = new Runnable()
  {
    public final void run()
    {
      WebSessionsActivity.a(WebSessionsActivity.this).notifyDataSetChanged();
      WebSessionsActivity.this.aq.a(WebSessionsActivity.d(WebSessionsActivity.this), 30000L);
    }
  };
  private final aat t = aat.a();
  
  private void l()
  {
    if (this.t.b())
    {
      startActivity(new Intent(this, QrCodeActivity.class));
      return;
    }
    if (aat.a(this))
    {
      pv.a(getBaseContext(), 2131297244, 0);
      return;
    }
    pv.a(getBaseContext(), 2131297243, 0);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Log.i("websessions/create");
    super.onCreate(paramBundle);
    this.q = new HashMap();
    paramBundle = i();
    if (paramBundle != null) {
      paramBundle.a(true);
    }
    setContentView(2130903411);
    paramBundle = (ListView)findViewById(16908298);
    View localView = al.a(this.aq, getLayoutInflater(), 2130903413, null, false);
    this.o = localView.findViewById(2131755386);
    aoa.a((TextView)localView.findViewById(2131756267));
    paramBundle.addHeaderView(localView, null, false);
    localView = al.a(this.aq, getLayoutInflater(), 2130903412, null, false);
    this.p = localView.findViewById(2131755524);
    localView.findViewById(2131756266).setOnClickListener(new at()
    {
      public final void a(View paramAnonymousView)
      {
        new WebSessionsActivity.a().a(WebSessionsActivity.this.j_(), null);
      }
    });
    ((TextView)localView.findViewById(2131755520)).setText(getString(2131297495, new Object[] { "web.whatsapp.com" }));
    paramBundle.addFooterView(localView, null, false);
    this.n = new c((byte)0);
    this.n.a(auj.a());
    if (this.n.getCount() == 0)
    {
      l();
      finish();
      return;
    }
    paramBundle.setVisibility(0);
    paramBundle.setAdapter(this.n);
    paramBundle.setOnItemClickListener(aun.a(this));
    this.aq.a(this.s, 30000L);
    auj.a(this.r);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    o.a(paramMenu.add(0, 2131755071, 0, 2131297154).setIcon(2130840045), 2);
    return true;
  }
  
  public void onDestroy()
  {
    Log.i("websessions/destroy");
    super.onDestroy();
    auj.b(this.r);
    this.aq.b(this.s);
    Iterator localIterator = this.q.values().iterator();
    while (localIterator.hasNext()) {
      ((CountDownTimer)localIterator.next()).cancel();
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      return true;
    }
    if (paramMenuItem.getItemId() == 2131755071)
    {
      l();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public static final class a
    extends m
  {
    final aj aa = aj.a();
    
    public final Dialog c(Bundle paramBundle)
    {
      return new b.a(l()).b(2131296503).b(2131296398, null).a(2131297128, aup.a(this)).a();
    }
  }
  
  public static final class b
    extends m
  {
    final aj aa = aj.a();
    
    public static b a(String paramString)
    {
      b localb = new b();
      Bundle localBundle = new Bundle();
      localBundle.putString("browserId", paramString);
      localb.f(localBundle);
      return localb;
    }
    
    public final Dialog c(Bundle paramBundle)
    {
      paramBundle = i().getString("browserId");
      return new b.a(l()).b(2131296504).b(2131296398, null).a(2131297128, auq.a(this, paramBundle)).a();
    }
  }
  
  final class c
    extends BaseAdapter
  {
    protected List<aur.b> a;
    
    private c() {}
    
    public final aur.b a(int paramInt)
    {
      return (aur.b)this.a.get(paramInt);
    }
    
    public final void a(List<aur.b> paramList)
    {
      this.a = paramList;
      notifyDataSetChanged();
    }
    
    public final int getCount()
    {
      if (this.a == null) {
        return 0;
      }
      return this.a.size();
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = al.a(WebSessionsActivity.this.aq, WebSessionsActivity.this.getLayoutInflater(), 2130903410, paramViewGroup, false);
      }
      paramView = a(paramInt);
      paramViewGroup = (TextView)localView.findViewById(2131755507);
      TextView localTextView = (TextView)localView.findViewById(2131755329);
      aoa.a(localTextView);
      boolean bool = auj.c(paramView.a);
      paramViewGroup.setText(l.a(WebSessionsActivity.this.getBaseContext(), WebSessionsActivity.this.aF, paramView.j, bool));
      if (!TextUtils.isEmpty(paramView.i))
      {
        localTextView.setText(WebSessionsActivity.this.getResources().getString(2131298195, new Object[] { paramView.i, paramView.d }));
        if (paramView.e == null) {
          break label465;
        }
        paramViewGroup = paramView.e.toLowerCase(Locale.US);
        paramInt = -1;
        switch (paramViewGroup.hashCode())
        {
        default: 
          switch (paramInt)
          {
          default: 
            label228:
            paramInt = 2130837597;
          }
          break;
        }
      }
      for (;;)
      {
        ((ImageView)localView.findViewById(2131755801)).setImageResource(paramInt);
        if ((paramView.k) && (paramView.l != 0L))
        {
          WebSessionsActivity.a(WebSessionsActivity.this, paramView.a, paramView.l);
          return localView;
          localTextView.setText(paramView.d);
          break;
          if (!paramViewGroup.equals("chrome")) {
            break label228;
          }
          paramInt = 0;
          break label228;
          if (!paramViewGroup.equals("firefox")) {
            break label228;
          }
          paramInt = 1;
          break label228;
          if (!paramViewGroup.equals("opera")) {
            break label228;
          }
          paramInt = 2;
          break label228;
          if (!paramViewGroup.equals("safari")) {
            break label228;
          }
          paramInt = 3;
          break label228;
          if (!paramViewGroup.equals("ie")) {
            break label228;
          }
          paramInt = 4;
          break label228;
          if (!paramViewGroup.equals("edge")) {
            break label228;
          }
          paramInt = 5;
          break label228;
          paramInt = 2130837590;
          continue;
          paramInt = 2130837592;
          continue;
          paramInt = 2130837595;
          continue;
          paramInt = 2130837596;
          continue;
          paramInt = 2130837593;
          continue;
          paramInt = 2130837591;
          continue;
        }
        WebSessionsActivity.a(WebSessionsActivity.this, paramView.a);
        return localView;
        label465:
        paramInt = 2130837590;
      }
    }
    
    public final int getViewTypeCount()
    {
      return 1;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/WebSessionsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */