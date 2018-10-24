package com.whatsapp.wallpaper;

import a.a.a.a.a.a.d;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.b;
import android.support.v7.app.a;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import com.whatsapp.aus;
import com.whatsapp.util.az;

public class SolidColorWallpaper
  extends android.support.v7.app.c
{
  private int[] n;
  private String[] o;
  private final aus p = aus.a();
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      if ((paramIntent == null) || (!paramIntent.hasExtra("wallpaper_color_file")))
      {
        setResult(0, null);
        finish();
        return;
      }
      setResult(-1, paramIntent);
      finish();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.p.e();
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.p.e();
    super.onCreate(paramBundle);
    setContentView(2130903405);
    a((Toolbar)findViewById(2131755412));
    paramBundle = (a)a.d.a(i());
    paramBundle.a(true);
    paramBundle.b(new az(b.a(this, 2130840097)));
    if (Build.VERSION.SDK_INT >= 21) {
      ((View)a.d.a(findViewById(2131755785))).setVisibility(8);
    }
    paramBundle = (GridView)a.d.a(findViewById(2131756254));
    this.n = getResources().getIntArray(2131689499);
    this.o = getResources().getStringArray(2131689498);
    paramBundle.setAdapter(new a(this));
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    setResult(0, null);
    finish();
    return true;
  }
  
  final class a
    extends BaseAdapter
  {
    private final Context b;
    
    a(Context paramContext)
    {
      this.b = paramContext;
    }
    
    public final int getCount()
    {
      return SolidColorWallpaper.a(SolidColorWallpaper.this).length;
    }
    
    public final Object getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = new c(this.b);
        paramViewGroup.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      }
      paramViewGroup.setBackgroundColor(SolidColorWallpaper.a(SolidColorWallpaper.this)[paramInt]);
      paramViewGroup.setContentDescription(SolidColorWallpaper.b(SolidColorWallpaper.this)[paramInt]);
      paramViewGroup.setOnClickListener(d.a(this, paramInt));
      return paramViewGroup;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/wallpaper/SolidColorWallpaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */