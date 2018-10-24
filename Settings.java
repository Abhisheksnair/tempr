package com.whatsapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.a;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.whatsapp.data.cs;
import com.whatsapp.messaging.w;
import com.whatsapp.util.Log;

public class Settings
  extends nh
{
  ImageView n;
  boolean o;
  private TextEmojiLabel p;
  private cs q;
  private int r;
  private TextEmojiLabel s;
  private final aaq t = aaq.a();
  private final va u = va.a();
  private final di v = di.a();
  private final dh w = dh.a();
  private final dh.a x = new dh.a()
  {
    public final void b(String paramAnonymousString)
    {
      if ((Settings.a(Settings.this) != null) && (paramAnonymousString.equals(Settings.a(Settings.this).t)))
      {
        Settings.a(Settings.this, Settings.b(Settings.this).c());
        Settings.c(Settings.this);
      }
    }
    
    public final void c(String paramAnonymousString)
    {
      Settings.this.runOnUiThread(aiv.a(this, paramAnonymousString));
    }
  };
  private di.e y;
  private final aus.a z = new ain(this);
  
  private void l()
  {
    if (this.q != null)
    {
      this.y.a(this.q, this.n);
      return;
    }
    Bitmap localBitmap = cs.a(2130837625, this.r, -1.0F);
    this.n.setImageBitmap(localBitmap);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().requestFeature(12);
    }
    super.onCreate(paramBundle);
    pb.a(3);
    setContentView(al.a(this.aq, getLayoutInflater(), 2130903335, null, false));
    paramBundle = i();
    if (paramBundle != null)
    {
      paramBundle.a(getString(2131297775));
      paramBundle.a(true);
    }
    this.q = this.u.c();
    if (this.q == null)
    {
      Log.i("settings/create/no-me");
      this.aq.a("conversations bounce to main");
      startActivity(new Intent(this, Main.class));
      finish();
      return;
    }
    this.r = getResources().getDimensionPixelSize(2131362073);
    this.y = this.v.a(this.r, -1.0F);
    this.n = ((ImageView)findViewById(2131756018));
    this.n.setVisibility(0);
    this.s = ((TextEmojiLabel)findViewById(2131756019));
    this.s.setVisibility(0);
    this.s.a(this.aQ.l());
    this.p = ((TextEmojiLabel)findViewById(2131756020));
    findViewById(2131756017).setOnClickListener(aio.a(this));
    l();
    this.w.registerObserver(this.x);
    findViewById(2131756026).setOnClickListener(aip.a(this));
    findViewById(2131756025).setOnClickListener(aiq.a(this));
    findViewById(2131756021).setOnClickListener(air.a(this));
    findViewById(2131756022).setOnClickListener(ais.a(this));
    findViewById(2131756024).setOnClickListener(ait.a(this));
    findViewById(2131756023).setOnClickListener(aiu.a(this));
    this.o = false;
    this.aF.a(this.z);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i("profileinfo/destroy");
    this.w.unregisterObserver(this.x);
    this.y.a();
    this.aF.b(this.z);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (av.j()) {}
    switch (paramInt)
    {
    default: 
      return super.onKeyDown(paramInt, paramKeyEvent);
    case 29: 
      paramKeyEvent = new Intent(this, TosUpdateActivity.class);
      paramKeyEvent.putExtra("automation_tos_update_stage", 1);
      startActivity(paramKeyEvent);
      return true;
    case 30: 
      paramKeyEvent = new Intent(this, TosUpdateActivity.class);
      paramKeyEvent.putExtra("automation_tos_update_stage", 2);
      startActivity(paramKeyEvent);
      return true;
    }
    this.at.j();
    this.ay.h();
    return true;
  }
  
  protected void onResume()
  {
    if (this.o)
    {
      this.o = false;
      finish();
      startActivity(getIntent());
    }
    super.onResume();
    this.q = this.u.c();
    this.s.a(this.aQ.l());
    this.p.a(this.t.c());
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/Settings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */