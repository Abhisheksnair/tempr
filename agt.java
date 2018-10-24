package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.whatsapp.data.ad;
import com.whatsapp.data.cb;
import com.whatsapp.data.ch;
import com.whatsapp.data.n;
import com.whatsapp.gdrive.GoogleDriveRestoreAnimationView;
import com.whatsapp.j.a.a;
import com.whatsapp.registration.EULA;
import com.whatsapp.registration.aw;
import com.whatsapp.util.Log;
import com.whatsapp.util.l;

public abstract class agt
  extends pf
{
  private Activity a;
  private final ad b = ad.a();
  private final aus c = aus.a();
  private final aw d = aw.a();
  private GoogleDriveRestoreAnimationView e;
  private ProgressBar f;
  private TextView g;
  private int h = 0;
  
  public agt(Activity paramActivity)
  {
    super(paramActivity, 2130903088, false);
    this.a = paramActivity;
  }
  
  public final void a(int paramInt)
  {
    this.h = paramInt;
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      if (this.e == null) {
        this.e = ((GoogleDriveRestoreAnimationView)findViewById(2131755355));
      }
      findViewById(2131755279).setVisibility(8);
      findViewById(2131755355).setVisibility(0);
      this.f = ((ProgressBar)findViewById(2131755224));
      this.g = ((TextView)findViewById(2131755356));
      this.f.setVisibility(0);
      this.f.setIndeterminate(true);
      d.a(this.f, getContext().getResources().getColor(2131624069));
      this.g.setVisibility(0);
      this.e.b();
      return;
    }
    if (this.e == null) {
      this.e = ((GoogleDriveRestoreAnimationView)findViewById(2131755355));
    }
    this.e.a();
    findViewById(2131755279).setVisibility(8);
    if (this.f != null) {
      this.f.setVisibility(8);
    }
    if (this.g != null) {
      this.g.setVisibility(8);
    }
    TextView localTextView = (TextView)findViewById(2131755277);
    localTextView.setVisibility(0);
    String str = u.a.a(2131230750, this.b.z.a.g, new Object[] { Integer.valueOf(this.b.z.a.g) });
    Log.i("restorebackupdialog/after-msgstore-verified/ " + str);
    localTextView.setText(str);
    ((Button)findViewById(2131755357)).setVisibility(0);
  }
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    findViewById(2131755280).setOnClickListener(agu.a(this));
    findViewById(2131755281).setOnClickListener(agv.a(this));
    findViewById(2131755357).setOnClickListener(agw.a(this));
    if (paramBundle == null) {}
    for (int i = 0;; i = paramBundle.getInt("state"))
    {
      a(i);
      ((Window)a.d.a(getWindow())).setSoftInputMode(3);
      setTitle(2131298232);
      paramBundle = this.a;
      aus localaus = this.c;
      Log.d("restorebackupdialog/lastbackup/look at files");
      long l = this.b.c.h();
      if (l != -1L) {
        Log.d("restorebackupdialog/lastbackup/fromfiles/set to " + l);
      }
      paramBundle = l.b(paramBundle, localaus, l).toString();
      ((TextView)findViewById(2131755354)).setText(getContext().getResources().getString(2131297115, new Object[] { paramBundle }));
      findViewById(2131755279).getViewTreeObserver().addOnGlobalLayoutListener(agx.a(this));
      return;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (av.d()) {
      paramMenu.add(0, 0, 0, "Reset");
    }
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    }
    this.d.e();
    this.a.startActivity(new Intent(this.a, EULA.class));
    return true;
  }
  
  public Bundle onSaveInstanceState()
  {
    Bundle localBundle = super.onSaveInstanceState();
    localBundle.putInt("state", this.h);
    return localBundle;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/agt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */