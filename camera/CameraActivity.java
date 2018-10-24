package com.whatsapp.camera;

import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ab;
import android.view.KeyEvent;
import android.view.Window;
import com.whatsapp.Main;
import com.whatsapp.aic;
import com.whatsapp.data.ad;
import com.whatsapp.data.ch;
import com.whatsapp.nh;
import com.whatsapp.pv;
import com.whatsapp.registration.bb;
import com.whatsapp.util.Log;
import com.whatsapp.util.WhatsAppLibLoader;
import com.whatsapp.va;
import com.whatsapp.vv;

public class CameraActivity
  extends nh
  implements ai.a
{
  final Rect n = new Rect();
  private final va o = va.a();
  private final ad p = ad.a();
  private final bb q = bb.a();
  private final h r = new h()
  {
    protected final void a()
    {
      CameraActivity.this.finish();
    }
    
    protected final void b()
    {
      CameraActivity.this.setResult(-1);
      CameraActivity.this.finish();
    }
    
    protected final int c()
    {
      return CameraActivity.this.getIntent().getIntExtra("origin", 1);
    }
  };
  
  public final h m()
  {
    return this.r;
  }
  
  public final Rect n()
  {
    return this.n;
  }
  
  public void onBackPressed()
  {
    if ((this.r != null) && (this.r.k())) {
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("cameraactivity/create");
    if ((this.o.b == null) || (!this.p.z.d) || (!this.q.b()))
    {
      Log.i("cameraactivity/create/no-me-or-msgstore-db");
      this.aq.a("cameraactivity bounce to main");
      startActivity(new Intent(this, Main.class));
      finish();
      return;
    }
    if (!WhatsAppLibLoader.a(null))
    {
      Log.i("aborting due to native libraries missing");
      finish();
      return;
    }
    if ("android.intent.action.CREATE_SHORTCUT".equals(getIntent().getAction()))
    {
      paramBundle = new Intent(this, LauncherCameraActivity.class);
      paramBundle.addFlags(268435456);
      Intent localIntent = new Intent();
      localIntent.putExtra("android.intent.extra.shortcut.INTENT", paramBundle);
      localIntent.putExtra("android.intent.extra.shortcut.NAME", getString(2131296391));
      localIntent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(this, 2130840326));
      setResult(-1, localIntent);
      finish();
      return;
    }
    if (vv.f() < aic.s << 10 << 10)
    {
      this.aq.b(getApplicationContext(), 2131296742, 1);
      finish();
      return;
    }
    if ((getIntent().getFlags() & 0x40000000) != 0)
    {
      Log.i("cameraactivity/create/restart-old-shortcut");
      paramBundle = new Intent(this, LauncherCameraActivity.class);
      paramBundle.addFlags(268435456);
      paramBundle.putExtra("origin", 1);
      startActivity(paramBundle);
      finish();
      return;
    }
    getWindow().setFlags(1024, 1024);
    getWindow().setBackgroundDrawable(new ColorDrawable(-16777216));
    setContentView(2130903098);
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().addFlags(134217728);
      ab.a(findViewById(2131755400), new b(this));
    }
    this.r.a(this, this.ap, this.aq, this.au, this.az, this.aE, this.aP, getIntent().getStringExtra("jid"), getIntent().getLongExtra("quoted_message_row_id", 0L), getIntent().getBooleanExtra("chat_opened_from_url", false));
    this.r.j();
  }
  
  protected void onDestroy()
  {
    Log.i("cameraactivity/destroy");
    super.onDestroy();
    this.r.f();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return (this.r.a(paramInt)) || (super.onKeyDown(paramInt, paramKeyEvent));
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return (this.r.b(paramInt)) || (super.onKeyUp(paramInt, paramKeyEvent));
  }
  
  protected void onPause()
  {
    super.onPause();
    this.r.g();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.r.h();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/camera/CameraActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */