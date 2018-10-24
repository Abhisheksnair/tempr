package com.whatsapp.wallpaper;

import a.a.a.a.d;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.b;
import android.support.v7.app.a;
import android.support.v7.app.b.a;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.whatsapp.and;
import com.whatsapp.aus;
import com.whatsapp.util.Log;
import com.whatsapp.util.az;
import java.util.ArrayList;

public class WallpaperPicker
  extends android.support.v7.app.c
{
  final and n = and.a();
  private ArrayList<Integer> o = new ArrayList();
  private ArrayList<Integer> p = new ArrayList();
  private Resources q = null;
  private a r;
  private final aus s = aus.a();
  
  final boolean a(Uri paramUri)
  {
    try
    {
      startActivity(new Intent("android.intent.action.VIEW", paramUri));
      return true;
    }
    catch (ActivityNotFoundException paramUri)
    {
      Log.d("wallpaperpicker/activity for install uri not found", paramUri);
    }
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramIntent.hasExtra("selected_res_id"))) {
          break label34;
        }
        setResult(0, null);
      }
      for (;;)
      {
        finish();
        return;
        label34:
        setResult(-1, paramIntent);
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.s.e();
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.s.e();
    super.onCreate(paramBundle);
    setContentView(2130903405);
    a((Toolbar)findViewById(2131755412));
    paramBundle = i();
    paramBundle.a(true);
    paramBundle.b(new az(b.a(this, 2130840097)));
    if (Build.VERSION.SDK_INT >= 21) {
      findViewById(2131755785).setVisibility(8);
    }
    paramBundle = (GridView)findViewById(2131756254);
    this.r = new a(this);
    paramBundle.setAdapter(this.r);
    try
    {
      this.q = getPackageManager().getResourcesForApplication("com.whatsapp.wallpaper");
      return;
    }
    catch (PackageManager.NameNotFoundException paramBundle)
    {
      Log.e("wallpaperpicker/no application found for com.whatsapp.wallpaper");
      d.a(this, 1);
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 2: 
      if (Build.VERSION.SDK_INT >= 14) {}
      for (localObject = "android.settings.SECURITY_SETTINGS";; localObject = "android.settings.APPLICATION_SETTINGS") {
        return new b.a(this).b(2131297056).a(2131296312, i.a(this, (String)localObject)).b(2131296398, j.a(this)).a();
      }
    }
    Object localObject = k.a(this);
    return new b.a(this).b(2131296693).a(2131297331, (DialogInterface.OnClickListener)localObject).b(2131296398, l.a(this)).a(m.a(this)).a();
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
  
  protected void onResume()
  {
    super.onResume();
    if (this.p.size() > 0)
    {
      Log.i("wallpaperpicker/wallpapers already loaded.");
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        i = this.q.getIdentifier("wallpapers", "array", "com.whatsapp.wallpaper");
        if (i != 0)
        {
          String[] arrayOfString = this.q.getStringArray(i);
          int j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            String str = arrayOfString[i];
            int k = this.q.getIdentifier(str, "drawable", "com.whatsapp.wallpaper");
            if (k == 0) {
              break label211;
            }
            int m = this.q.getIdentifier(str + "_small", "drawable", "com.whatsapp.wallpaper");
            if (m == 0) {
              break label211;
            }
            this.o.add(Integer.valueOf(m));
            this.p.add(Integer.valueOf(k));
            break label211;
          }
        }
        if (this.p.size() == 0)
        {
          d.a(this, 1);
          return;
        }
      }
      catch (Resources.NotFoundException localNotFoundException)
      {
        Log.d("wallpaperpicker/resource not found", localNotFoundException);
        d.a(this, 1);
        return;
        this.r.notifyDataSetChanged();
        return;
      }
      catch (NullPointerException localNullPointerException)
      {
        Log.d("wallpaperpicker/resource is null", localNullPointerException);
        d.a(this, 1);
        return;
      }
      label211:
      i += 1;
    }
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
      return WallpaperPicker.a(WallpaperPicker.this).size();
    }
    
    public final Object getItem(int paramInt)
    {
      return Integer.valueOf(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      int i = ((Integer)WallpaperPicker.a(WallpaperPicker.this).get(paramInt)).intValue();
      if (paramView == null)
      {
        paramView = new c(this.b);
        paramView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      }
      for (;;)
      {
        ((ImageView)paramView).setImageDrawable(WallpaperPicker.b(WallpaperPicker.this).getDrawable(i));
        ((ImageView)paramView).setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramView.setOnClickListener(n.a(this, paramInt));
        return paramView;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/wallpaper/WallpaperPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */