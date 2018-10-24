package com.whatsapp.gallerypicker;

import a.a.a.a.a.a.d;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.support.v4.app.Fragment;
import android.support.v4.app.r;
import android.support.v4.app.v;
import android.support.v4.content.b;
import android.support.v4.f.f;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.i;
import android.support.v4.view.ab;
import android.support.v4.view.w;
import android.text.TextUtils;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.whatsapp.PagerSlidingTabStrip;
import com.whatsapp.PagerSlidingTabStrip.c;
import com.whatsapp.av;
import com.whatsapp.data.cs;
import com.whatsapp.nh;
import com.whatsapp.pv;
import com.whatsapp.util.Log;
import com.whatsapp.util.az;
import com.whatsapp.util.bm;
import java.util.ArrayList;
import java.util.List;

public class GalleryPicker
  extends nh
{
  int n = 1;
  private int o = 7;
  private final com.whatsapp.c.a p = com.whatsapp.c.a.a();
  private final com.whatsapp.data.e q = com.whatsapp.data.e.a();
  
  static boolean l()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    ArrayList localArrayList1;
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt2 == -1) {
            break;
          }
        } while (paramInt2 != 2);
        setResult(2);
        finish();
        return;
      } while (paramInt2 != -1);
      if (!getIntent().getBooleanExtra("preview", true)) {
        break;
      }
      ArrayList localArrayList2 = paramIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
      localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        paramIntent = paramIntent.getData();
        localArrayList1 = localArrayList2;
        if (paramIntent != null)
        {
          localArrayList1 = new ArrayList();
          localArrayList1.add(paramIntent);
        }
      }
    } while (localArrayList1 == null);
    paramIntent = new Intent(this, MediaPreviewActivity.class);
    paramIntent.putExtra("android.intent.extra.STREAM", localArrayList1);
    paramIntent.putExtra("jid", getIntent().getStringExtra("jid"));
    paramIntent.putExtra("max_items", getIntent().getStringExtra("max_items"));
    paramIntent.putExtra("quoted_message_row_id", getIntent().getLongExtra("quoted_message_row_id", 0L));
    paramIntent.putExtra("number_from_url", getIntent().getBooleanExtra("number_from_url", false));
    paramIntent.putExtra("max_items", 0);
    paramIntent.putExtra("picker_open_time", getIntent().getLongExtra("picker_open_time", 0L));
    paramIntent.putExtra("origin", 1);
    startActivityForResult(paramIntent, 0);
    return;
    setResult(-1, paramIntent);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("gallerypicker/create");
    b(5);
    Object localObject1;
    final Object localObject2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject1 = getWindow();
      ((Window)localObject1).requestFeature(13);
      ((Window)localObject1).requestFeature(12);
      localObject2 = TransitionInflater.from(this).inflateTransition(17760258);
      ((Transition)localObject2).excludeTarget(16908335, true);
      ((Transition)localObject2).excludeTarget(16908336, true);
      ((Window)localObject1).setExitTransition((Transition)localObject2);
      localObject2 = TransitionInflater.from(this).inflateTransition(17760259);
      ((Transition)localObject2).excludeTarget(16908335, true);
      ((Transition)localObject2).excludeTarget(16908336, true);
      ((Window)localObject1).setReenterTransition((Transition)localObject2);
    }
    super.onCreate(paramBundle);
    paramBundle = (android.support.v7.app.a)a.d.a(i());
    paramBundle.a(true);
    if (!this.aq.d()) {
      paramBundle.b(new az(b.a(this, 2130840097)));
    }
    paramBundle.a(true);
    paramBundle = getIntent().getStringExtra("jid");
    if (!TextUtils.isEmpty(paramBundle))
    {
      paramBundle = this.q.d(paramBundle);
      if (paramBundle.d())
      {
        paramBundle = getString(2131297682, new Object[] { paramBundle.a(this) });
        f(paramBundle);
      }
    }
    else
    {
      this.o = getIntent().getIntExtra("include_media", 7);
      if ((this.o != 7) || (l())) {
        break label599;
      }
      this.n = getSharedPreferences("com.whatsapp_preferences", 0).getInt("gallerypickerinclude", 1);
      label261:
      setContentView(2130903232);
      paramBundle = (PagerSlidingTabStrip)findViewById(2131755780);
      if ((this.o != 7) || (l())) {
        paramBundle.setVisibility(8);
      }
      localObject1 = (ViewPager)findViewById(2131755748);
      ((ViewPager)localObject1).setOffscreenPageLimit(0);
      localObject2 = new a(j_());
      ((ViewPager)localObject1).setAdapter((w)localObject2);
      paramBundle.setViewPager((ViewPager)localObject1);
      paramBundle.setOnPageChangeListener(new ViewPager.i()
      {
        public final void b(int paramAnonymousInt)
        {
          super.b(paramAnonymousInt);
          localObject2.b(paramAnonymousInt);
          if ((GalleryPicker.a(GalleryPicker.this) == 7) && (!GalleryPicker.l())) {
            switch (paramAnonymousInt)
            {
            }
          }
          for (;;)
          {
            GalleryPicker.this.invalidateOptionsMenu();
            return;
            GalleryPicker.a(GalleryPicker.this, 1);
            continue;
            GalleryPicker.a(GalleryPicker.this, 4);
            continue;
            GalleryPicker.a(GalleryPicker.this, 2);
          }
        }
      });
      paramBundle.setTextColorResource(2131623944);
      if ((this.o != 7) || (l()) || (this.n == 1)) {
        break label632;
      }
      if (this.n != 4) {
        break label610;
      }
      ((ViewPager)localObject1).a(1, false);
      ((a)localObject2).b(1);
    }
    for (;;)
    {
      ab.f(paramBundle, getResources().getDimension(2131361891));
      paramBundle = getIntent().getParcelableArrayListExtra("android.intent.extra.STREAM");
      localObject1 = (Uri)getIntent().getParcelableExtra("bucket_uri");
      if (localObject1 != null)
      {
        localObject1 = new Intent("android.intent.action.VIEW", (Uri)localObject1);
        ((Intent)localObject1).putExtra("include_media", this.n);
        ((Intent)localObject1).putExtra("preview", getIntent().getBooleanExtra("preview", true));
        ((Intent)localObject1).putExtra("quoted_message_row_id", getIntent().getLongExtra("quoted_message_row_id", 0L));
        ((Intent)localObject1).putExtra("jid", getIntent().getStringExtra("jid"));
        ((Intent)localObject1).putExtra("max_items", getIntent().getIntExtra("max_items", Integer.MAX_VALUE));
        ((Intent)localObject1).putExtra("android.intent.extra.STREAM", paramBundle);
        ((Intent)localObject1).putExtra("picker_open_time", getIntent().getLongExtra("picker_open_time", 0L));
        ((Intent)localObject1).setClass(this, MediaPicker.class);
        startActivityForResult((Intent)localObject1, 0);
      }
      return;
      paramBundle = getString(2131297683, new Object[] { paramBundle.a(this) });
      break;
      label599:
      this.n = this.o;
      break label261;
      label610:
      if (this.n == 2)
      {
        ((ViewPager)localObject1).a(2, false);
        ((a)localObject2).b(2);
        continue;
        label632:
        ((ViewPager)localObject1).a(0, false);
        ((a)localObject2).b(0);
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    int i = 0;
    Intent localIntent;
    if (this.n == 4)
    {
      localIntent = new Intent("android.intent.action.PICK", MediaStore.Video.Media.INTERNAL_CONTENT_URI);
      localIntent.setType("video/*");
    }
    for (;;)
    {
      PackageManager localPackageManager = getPackageManager();
      List localList = localPackageManager.queryIntentActivities(localIntent, 0);
      int j = localList.size();
      if (j > 0)
      {
        getMenuInflater().inflate(2131820546, paramMenu);
        SubMenu localSubMenu = paramMenu.findItem(2131755578).getSubMenu();
        localSubMenu.clear();
        paramMenu.findItem(2131756283).setVisible(false);
        while (i < j)
        {
          paramMenu = (ResolveInfo)localList.get(i);
          Drawable localDrawable = paramMenu.loadIcon(localPackageManager);
          MenuItem localMenuItem = localSubMenu.add(paramMenu.loadLabel(localPackageManager));
          localMenuItem.setIcon(localDrawable);
          localMenuItem.setOnMenuItemClickListener(d.a(this, paramMenu, localIntent));
          i += 1;
          continue;
          if (this.n != 2) {
            break label194;
          }
        }
      }
      return true;
      label194:
      localIntent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.INTERNAL_CONTENT_URI);
      localIntent.setType("image/*");
    }
  }
  
  public void onDestroy()
  {
    Log.i("gallerypicker/destroy");
    super.onDestroy();
    this.p.a.a(-1);
    getSharedPreferences("com.whatsapp_preferences", 0).edit().putInt("gallerypickerinclude", this.n).apply();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((av.j()) && (paramInt == 84))
    {
      bm.a(this);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    finish();
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  final class a
    extends v
    implements PagerSlidingTabStrip.c
  {
    private TextView[] b = new TextView[3];
    
    a(r paramr)
    {
      super();
    }
    
    public final Fragment a(int paramInt)
    {
      e locale = new e();
      Bundle localBundle = new Bundle();
      if (GalleryPicker.a(GalleryPicker.this) == 7) {
        if (GalleryPicker.l()) {
          localBundle.putInt("include", 7);
        }
      }
      for (;;)
      {
        locale.f(localBundle);
        return locale;
        switch (paramInt)
        {
        default: 
          break;
        case 0: 
          localBundle.putInt("include", 1);
          break;
        case 1: 
          localBundle.putInt("include", 4);
          break;
        case 2: 
          localBundle.putInt("include", 2);
          continue;
          if (GalleryPicker.a(GalleryPicker.this) == 1) {
            localBundle.putInt("include", 1);
          } else if (GalleryPicker.a(GalleryPicker.this) == 4) {
            localBundle.putInt("include", 4);
          } else if (GalleryPicker.a(GalleryPicker.this) == 2) {
            localBundle.putInt("include", 2);
          }
          break;
        }
      }
    }
    
    public final int b()
    {
      if ((GalleryPicker.a(GalleryPicker.this) == 7) && (!GalleryPicker.l())) {
        return 3;
      }
      return 1;
    }
    
    final void b(int paramInt)
    {
      int i = 0;
      if (i < this.b.length)
      {
        TextView localTextView = this.b[i];
        if (localTextView != null)
        {
          if (i != paramInt) {
            break label47;
          }
          localTextView.setTextColor(b.c(GalleryPicker.this, 2131623944));
        }
        for (;;)
        {
          i += 1;
          break;
          label47:
          localTextView.setTextColor(b.c(GalleryPicker.this, 2131624003));
        }
      }
    }
    
    public final CharSequence c(int paramInt)
    {
      if (GalleryPicker.a(GalleryPicker.this) == 7)
      {
        if (GalleryPicker.l()) {
          return GalleryPicker.this.getResources().getString(2131296310);
        }
        switch (paramInt)
        {
        }
      }
      do
      {
        return null;
        return GalleryPicker.this.getResources().getString(2131297967);
        return GalleryPicker.this.getResources().getString(2131297968);
        return GalleryPicker.this.getResources().getString(2131297966);
        if (GalleryPicker.a(GalleryPicker.this) == 1) {
          return GalleryPicker.this.getResources().getString(2131297967);
        }
        if (GalleryPicker.a(GalleryPicker.this) == 4) {
          return GalleryPicker.this.getResources().getString(2131297968);
        }
      } while (GalleryPicker.a(GalleryPicker.this) != 2);
      return GalleryPicker.this.getResources().getString(2131297966);
    }
    
    public final View f(int paramInt)
    {
      if (this.b[paramInt] == null)
      {
        TextView localTextView = new TextView(GalleryPicker.this.getBaseContext());
        localTextView.setText(c(paramInt));
        localTextView.setTextColor(b.c(GalleryPicker.this, 2131623944));
        localTextView.setGravity(17);
        localTextView.setSingleLine();
        localTextView.setTextSize(14.0F);
        this.b[paramInt] = localTextView;
      }
      return this.b[paramInt];
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/GalleryPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */