package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.a;
import android.text.InputFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.whatsapp.data.cs;
import com.whatsapp.emoji.c;
import com.whatsapp.emoji.h;
import com.whatsapp.emoji.search.i;
import com.whatsapp.registration.aw;
import com.whatsapp.util.Log;
import java.io.File;
import java.util.Date;

public class ProfilePhotoReminder
  extends nh
{
  private static long A = -1L;
  public static boolean s;
  private final h B = h.a();
  private final dh C = dh.a();
  private final dh.a D = new dh.a()
  {
    public final void b(String paramAnonymousString)
    {
      if ((ProfilePhotoReminder.b(ProfilePhotoReminder.this) != null) && (paramAnonymousString.equals(ProfilePhotoReminder.b(ProfilePhotoReminder.this).t)))
      {
        ProfilePhotoReminder.a(ProfilePhotoReminder.this, ProfilePhotoReminder.this.ar.c());
        ProfilePhotoReminder.c(ProfilePhotoReminder.this);
      }
    }
  };
  View n;
  EditText o;
  cs p;
  os q;
  i r;
  EmojiPicker.c t = new EmojiPicker.c()
  {
    public final void a() {}
    
    public final void a(int paramAnonymousInt)
    {
      int i = ProfilePhotoReminder.a(ProfilePhotoReminder.this).getSelectionStart();
      int j = ProfilePhotoReminder.a(ProfilePhotoReminder.this).getSelectionEnd();
      int k;
      if (i > j)
      {
        k = j;
        j = i;
      }
      for (;;)
      {
        StringBuilder localStringBuilder = new StringBuilder(ProfilePhotoReminder.a(ProfilePhotoReminder.this).getText().toString());
        localStringBuilder.replace(k, j, c.b(paramAnonymousInt));
        if (c.c(localStringBuilder) > 25) {}
        do
        {
          return;
          ProfilePhotoReminder.a(ProfilePhotoReminder.this).setText(localStringBuilder);
        } while (k > ProfilePhotoReminder.a(ProfilePhotoReminder.this).length() - c.a(paramAnonymousInt));
        ProfilePhotoReminder.a(ProfilePhotoReminder.this).setSelection(k + c.a(paramAnonymousInt));
        return;
        k = i;
      }
    }
  };
  final aoj u = aoj.a();
  final aw v = aw.a();
  private ImageView w;
  private Handler x;
  private Runnable y;
  private Bitmap z;
  
  public static boolean a(ahc paramahc)
  {
    if (paramahc.b()) {}
    Date localDate;
    do
    {
      return false;
      if (A < 0L) {
        A = u.a().getSharedPreferences("com.whatsapp_preferences", 0).getLong("wa_last_reminder_timestamp", -1L);
      }
      if (A < 0L) {
        return true;
      }
      paramahc = new Date(System.currentTimeMillis());
      localDate = new Date(A);
    } while ((paramahc.getTime() - localDate.getTime()) / 86400000L < 90L);
    return true;
  }
  
  public static void b(ahc paramahc)
  {
    s = true;
    if (paramahc.b()) {
      Log.w("profilephotoreminder/savelastremindertimestamp/clock is wrong, not saving last profile photo reminder time");
    }
    do
    {
      return;
      A = System.currentTimeMillis();
      paramahc = u.a().getSharedPreferences("com.whatsapp_preferences", 0).edit();
      paramahc.putLong("wa_last_reminder_timestamp", A);
    } while (paramahc.commit());
    Log.e("profilephotoreminder/savelastremindertimestamp/failed to save reminder time of " + A);
  }
  
  private void m()
  {
    this.n.setVisibility(8);
    int i = getResources().getDimensionPixelSize(2131362080);
    float f = getResources().getDimension(2131361832);
    Object localObject;
    if (ach.b(this.p.t))
    {
      this.w.setEnabled(false);
      this.n.setVisibility(0);
      if (this.z == null) {
        this.z = Bitmap.createBitmap(i, i, Bitmap.Config.ALPHA_8);
      }
      localObject = this.z;
    }
    Bitmap localBitmap;
    do
    {
      this.w.setImageBitmap((Bitmap)localObject);
      return;
      this.w.setEnabled(true);
      this.n.setVisibility(4);
      localBitmap = this.p.a(i, f, false);
      localObject = localBitmap;
    } while (localBitmap != null);
    if ((this.p.m == 0) && (this.p.l == 0))
    {
      this.n.setVisibility(0);
      if (this.x == null)
      {
        this.x = new Handler(Looper.getMainLooper());
        this.y = acv.a(this);
      }
      this.x.removeCallbacks(this.y);
      this.x.postDelayed(this.y, 30000L);
    }
    for (;;)
    {
      localObject = cs.a(2130837625, i, f);
      break;
      this.n.setVisibility(4);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt2 != -1);
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("is_reset", false)))
        {
          this.n.setVisibility(0);
          this.aO.a(this.p);
          return;
        }
        this.aO.a(this, 13, paramIntent);
        return;
        this.aO.b().delete();
        if (paramInt2 != -1) {
          break;
        }
      } while (!this.aO.a(this, this.p));
      this.n.setVisibility(0);
      return;
    } while ((paramInt2 != 0) || (paramIntent == null));
    this.aO.a(this, paramIntent);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("profilephotoreminder/create");
    super.onCreate(paramBundle);
    paramBundle = (a)a.d.a(i());
    paramBundle.c();
    setContentView(2130903339);
    this.p = this.ar.c();
    if (this.p == null)
    {
      Log.i("profilephotoreminder/create/no-me");
      this.aq.a("conversations bounce to main");
      startActivity(new Intent(this, Main.class));
      finish();
      return;
    }
    TextView localTextView = (TextView)findViewById(2131756034);
    Object localObject = (ImageButton)findViewById(2131755724);
    ((ImageButton)localObject).setOnClickListener(acq.a(this, (ImageButton)localObject));
    this.q = new os(this.an, this, this.aq, this.B, this.aQ);
    this.q.a(this.t);
    this.q.setOnDismissListener(acr.a(this));
    this.q.t = true;
    this.r = new i(this.q, this, this.an, true);
    this.r.a(new acs(this));
    this.w = ((ImageView)findViewById(2131755974));
    localObject = act.a(this);
    this.w.setOnClickListener((View.OnClickListener)localObject);
    d.a(paramBundle, this.aq, getString(2131297280), acu.a(this));
    this.n = findViewById(2131755538);
    m();
    this.o = ((EditText)findViewById(2131756029));
    al.a(this.aq, this.o);
    this.o.addTextChangedListener(new tg(this.aq, this.aE, this.o, localTextView, 25));
    this.o.setFilters(new InputFilter[] { new px(25) });
    paramBundle = this.aQ.l();
    this.o.setText(paramBundle);
    al.a(this.aq, this.o, paramBundle);
    this.o.setSelection(this.o.length());
    if (this.av.b())
    {
      Log.w("profilephotoreminder/clock-wrong");
      f();
    }
    for (;;)
    {
      this.C.registerObserver(this.D);
      return;
      if (this.av.c())
      {
        Log.w("profilephotoreminder/sw-expired");
        g();
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i("profilephotoreminder/destroy");
    this.C.unregisterObserver(this.D);
    if (this.x != null) {
      this.x.removeCallbacks(this.y);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ProfilePhotoReminder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */