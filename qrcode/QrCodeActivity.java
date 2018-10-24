package com.whatsapp.qrcode;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Vibrator;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.google.c.i;
import com.whatsapp.RequestPermissionActivity;
import com.whatsapp.Voip;
import com.whatsapp.al;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.auj;
import com.whatsapp.auj.d;
import com.whatsapp.auj.s;
import com.whatsapp.av;
import com.whatsapp.messaging.ag;
import com.whatsapp.messaging.aj;
import com.whatsapp.nh;
import com.whatsapp.ox;
import com.whatsapp.pv;
import com.whatsapp.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QrCodeActivity
  extends nh
{
  private static int s = 1;
  QrCodeView n;
  boolean o = true;
  boolean p;
  String q;
  Camera.PreviewCallback r = new Camera.PreviewCallback()
  {
    public final void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
    {
      QrCodeActivity.c(QrCodeActivity.this).post(f.a(this, paramAnonymousArrayOfByte));
    }
  };
  private HandlerThread t;
  private Handler u;
  private i v = new i();
  private String w;
  private auj.s x = new auj.s()
  {
    public final void a()
    {
      if (auj.b(QrCodeActivity.a(QrCodeActivity.this)))
      {
        ((Vibrator)QrCodeActivity.this.getSystemService("vibrator")).vibrate(75L);
        QrCodeActivity.this.finish();
      }
    }
    
    public final void a(int paramAnonymousInt)
    {
      if (paramAnonymousInt == 403)
      {
        QrCodeActivity.b(QrCodeActivity.this);
        return;
      }
      pv.a(QrCodeActivity.this.getBaseContext(), QrCodeActivity.this.getString(2131297064, new Object[] { "web.whatsapp.com" }), 1);
      QrCodeActivity.this.finish();
    }
  };
  private final aj y = aj.a();
  private final ag z = ag.a();
  
  private auj.d a(String paramString)
  {
    paramString = auj.g(paramString);
    if (paramString == null) {}
    String str;
    do
    {
      return null;
      if (auj.c()) {
        this.y.a(false);
      }
      str = auj.a(paramString.e, paramString.c);
    } while (str == null);
    this.z.a(paramString.a, paramString.b, paramString.d, str, 0);
    return paramString;
  }
  
  final void l()
  {
    if (this.aP.a("android.permission.CAMERA") != 0)
    {
      this.n.setVisibility(8);
      startActivityForResult(new Intent(this, RequestPermissionActivity.class).putExtra("drawable_id", 2130840436).putExtra("message_id", 2131297362).putExtra("perm_denial_message_id", 2131297361).putExtra("permissions", new String[] { "android.permission.CAMERA" }).putExtra("force_ui", true), s);
      return;
    }
    this.n.setVisibility(0);
  }
  
  final void m()
  {
    runOnUiThread(e.a(this));
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == s)
    {
      if (paramInt2 == 0)
      {
        finish();
        return;
      }
      this.n.setVisibility(0);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Log.i("qractivity/create");
    b(5);
    super.onCreate(paramBundle);
    getWindow().addFlags(128);
    setContentView((ViewGroup)al.a(this.aq, getLayoutInflater(), 2130903340, null, false));
    i().a(true);
    b(false);
    paramBundle = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(com.google.c.a.l);
    paramBundle.put(com.google.c.e.c, localArrayList);
    this.v.a(paramBundle);
    this.t = new HandlerThread("QrDecode");
    this.t.start();
    this.u = new Handler(this.t.getLooper());
    this.o = this.aQ.a.getBoolean("qr_education", true);
    this.n = ((QrCodeView)findViewById(2131755414));
    this.n.setCameraCallback(new QrCodeView.a()
    {
      public final void a()
      {
        Log.i("qractivity/previewready");
        QrCodeActivity.d(QrCodeActivity.this);
        if (!QrCodeActivity.e(QrCodeActivity.this)) {
          QrCodeActivity.g(QrCodeActivity.this).getCamera().setOneShotPreviewCallback(QrCodeActivity.f(QrCodeActivity.this));
        }
      }
      
      public final void a(int paramAnonymousInt)
      {
        if (Voip.f()) {
          pv.a(QrCodeActivity.this, 2131296732, 1);
        }
        for (;;)
        {
          QrCodeActivity.this.finish();
          return;
          if (paramAnonymousInt != 2) {
            pv.a(QrCodeActivity.this, 2131296406, 1);
          }
        }
      }
    });
    ((TextView)findViewById(2131755520)).setText(Html.fromHtml(getString(2131297494, new Object[] { "<font color='#000000'>web.whatsapp.com</font>" })));
    findViewById(2131755228).setOnClickListener(a.a(this));
    if (this.o)
    {
      findViewById(2131756039).setVisibility(0);
      findViewById(2131756038).setVisibility(0);
      findViewById(2131755843).setVisibility(8);
      this.n.setVisibility(8);
    }
    for (;;)
    {
      auj.a(this.x);
      return;
      findViewById(2131756039).setVisibility(8);
      findViewById(2131756038).setVisibility(8);
      findViewById(2131755843).setVisibility(0);
      l();
    }
  }
  
  protected void onDestroy()
  {
    Log.i("qractivity/destroy");
    super.onDestroy();
    this.t.quit();
    auj.b(this.x);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((av.j()) && (paramInt == 25))
    {
      Context localContext = getBaseContext();
      File localFile = this.ax.a("AutomationQRCode.txt");
      if (localFile.exists()) {}
      for (;;)
      {
        try
        {
          if (a(new Scanner(localFile).nextLine()) == null) {
            pv.a(localContext, "invalid QRCode in AutomationQRCode.txt", 1);
          }
          finish();
          return super.onKeyDown(paramInt, paramKeyEvent);
        }
        catch (Exception localException)
        {
          pv.a(localContext, "unable to read AutomationQRCode.txt", 1);
          continue;
        }
        pv.a(localContext, "AutomationQRCode.txt is missing", 1);
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.n.getVisibility() == 0) {
      this.n.setVisibility(4);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.n.getVisibility() == 4) {
      this.n.setVisibility(0);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/qrcode/QrCodeActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */