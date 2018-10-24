package com.whatsapp;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.b.a;
import android.text.TextUtils;
import com.whatsapp.data.ad;
import com.whatsapp.data.cb;
import com.whatsapp.data.ch;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.k.a.a;
import com.whatsapp.k.c;
import com.whatsapp.k.d.a;
import com.whatsapp.k.d.e;
import com.whatsapp.registration.EULA;
import com.whatsapp.registration.RegisterName;
import com.whatsapp.registration.VerifySms;
import com.whatsapp.registration.VerifyTwoFactorAuth;
import com.whatsapp.registration.aw;
import com.whatsapp.registration.bb;
import com.whatsapp.util.Log;
import com.whatsapp.util.WhatsAppLibLoader;
import com.whatsapp.util.bu;

public class Main
  extends apf
{
  private static boolean o = true;
  final aog n = aog.a();
  private long p = SystemClock.elapsedRealtime();
  private Uri q;
  private b r;
  private a s;
  private boolean t;
  private final va u = va.a();
  private final e v = e.a();
  
  public static Class<?> n()
  {
    return HomeActivity.class;
  }
  
  private void q()
  {
    if ((this.s == null) || (this.s.getStatus() != AsyncTask.Status.RUNNING))
    {
      this.s = new a();
      bu.a(this.s, new Void[0]);
      return;
    }
    Log.i("main/show dialog sync");
    a.a.a.a.d.a(this, 104);
  }
  
  private void r()
  {
    Object localObject = getIntent().getStringExtra("jid");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = this.v.d((String)localObject);
      if (((!((cs)localObject).d()) && (!cs.d(((cs)localObject).t))) || (((cs)localObject).e != null))
      {
        if (!isFinishing())
        {
          startActivity(Conversation.a((cs)localObject));
          finish();
        }
        return;
      }
    }
    m();
  }
  
  protected final void l()
  {
    super.l();
    Object localObject;
    if (this.u.b == null)
    {
      if (!isFinishing())
      {
        int i = this.L.c();
        switch (i)
        {
        case 3: 
        default: 
          Log.e("main/invalid/registration state=" + i + "; default to EULA");
          this.L.a(0);
          localObject = new Intent(this, EULA.class);
        }
      }
      for (;;)
      {
        startActivity((Intent)localObject);
        finish();
        Log.i("main/me App.me is null, can't proceed.");
        return;
        Intent localIntent = new Intent(this, EULA.class);
        localObject = localIntent;
        if (getIntent().getBooleanExtra("show_registration_first_dlg", false))
        {
          localIntent.putExtra("show_registration_first_dlg", true);
          localObject = localIntent;
          continue;
          this.L.a(0);
          localObject = new Intent(this, EULA.class);
          continue;
          Log.i("main/no-me/regname");
          localObject = new Intent(this, RegisterName.class);
          continue;
          localIntent = new Intent(this, VerifySms.class);
          localObject = localIntent;
          if (this.G.m())
          {
            localIntent.putExtra("changenumber", true);
            localObject = localIntent;
            continue;
            localObject = new Intent(this, DeleteAccountConfirmation.class);
            continue;
            localIntent = new Intent(this, VerifyTwoFactorAuth.class);
            localObject = localIntent;
            if (this.G.m())
            {
              localIntent.putExtra("changenumber", true);
              localObject = localIntent;
            }
          }
        }
      }
    }
    if (this.L.c() == 2)
    {
      Log.i("main/me/regname");
      startActivity(new Intent(this, RegisterName.class));
      finish();
      return;
    }
    this.L.a(3);
    Log.i("main/verified/setregverified");
    this.q = this.n.c();
    if ((av.f()) && (this.q != null) && (this.r == null))
    {
      localObject = new b(this.q.getPath());
      this.r = ((b)localObject);
      bu.a((AsyncTask)localObject, new Void[0]);
      return;
    }
    if (this.B.b)
    {
      q();
      return;
    }
    Log.i("main/gotoActivity");
    r();
  }
  
  final void m()
  {
    if (!isFinishing())
    {
      Intent localIntent = getIntent();
      if ((localIntent != null) && (!"android.intent.action.MAIN".equals(localIntent.getAction())) && ((localIntent.getFlags() & 0x4000000) != 0) && (!localIntent.hasExtra("jid")) && (this.H.a.getInt("shortcut_version", 0) == 0))
      {
        Log.i("main/recreate_shortcut");
        RegisterName.b(this, getString(2131298233));
        RegisterName.a(this, getString(2131298233));
        this.H.c().putInt("shortcut_version", 1).apply();
      }
      startActivity(new Intent(this, HomeActivity.class));
      finish();
      this.t = true;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    com.whatsapp.k.d locald = c.a("MainActivityInit");
    locald.a(this.p);
    locald.a(d.e.a, this.p);
    locald.b(d.e.a);
    locald.a(d.e.b);
    d.a locala = d.a.d;
    boolean bool;
    if (paramBundle != null)
    {
      bool = true;
      locald.a(locala, bool);
      locald.a(d.a.c, o);
      o = false;
      this.al = false;
      super.onCreate(paramBundle);
      Log.i("main/create");
      if (WhatsAppLibLoader.a(null)) {
        break label130;
      }
      Log.i("aborting due to native libraries missing");
      finish();
    }
    label130:
    int i;
    label215:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        if (ahc.e())
        {
          a.a.a.a.d.a(this, 3);
          return;
        }
        i = this.L.c();
        paramBundle = this.u.b;
        if ((paramBundle != null) || (i != 0)) {
          break label215;
        }
      } while (isFinishing());
      paramBundle = new Intent(this, EULA.class);
      if (getIntent().getBooleanExtra("show_registration_first_dlg", false)) {
        paramBundle.putExtra("show_registration_first_dlg", true);
      }
      startActivity(paramBundle);
      finish();
      return;
      if (i != 6) {
        break label247;
      }
    } while (isFinishing());
    startActivity(new Intent(this, DeleteAccountConfirmation.class));
    finish();
    return;
    label247:
    if ((paramBundle != null) && (!this.y.z.d)) {
      if (this.M.d())
      {
        i = this.y.c.d();
        Log.i("main/create/backupfilesfound " + i);
        if (i > 0) {
          a.a.a.a.d.a(this, 105);
        }
      }
      else
      {
        label315:
        this.al = true;
        U();
      }
    }
    for (;;)
    {
      locald.b(d.e.b);
      locald.b();
      if (!this.t) {
        break;
      }
      paramBundle = a.a();
      paramBundle.b = c.a("MainToHomeActivity");
      paramBundle.b.a(d.a.c, a.a);
      paramBundle.b.a();
      a.a = false;
      paramBundle.c = true;
      return;
      c(false);
      break label315;
      l();
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return super.onCreateDialog(paramInt);
    case 0: 
      Log.i("main/dialog/upgrade");
      return new b.a(this).a(2131298074).b(2131298073).a(false).a(2131298213, uo.a(this)).c(2131297317, up.a(this)).b(2131297082, uq.a(this)).a();
    }
    Log.i("main/dialog/unsupported");
    return new b.a(this).a(2131298233).a(false).b(2131296659).a(2131297331, ur.a(this)).a();
  }
  
  public final class a
    extends AsyncTask<Void, Void, Void>
  {
    public a() {}
    
    private Void a()
    {
      int i = 0;
      while ((Main.this.B.b) && (i < 45000))
      {
        i += 200;
        try
        {
          Thread.sleep(200L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      if ((i >= 45000) && (Main.this.B.b)) {
        Main.this.B.d();
      }
      return null;
    }
    
    protected final void onPreExecute()
    {
      a.a.a.a.d.a(Main.this, 104);
    }
  }
  
  public final class b
    extends AsyncTask<Void, Void, apw>
  {
    private String b;
    
    public b(String paramString)
    {
      this.b = paramString;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/Main.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */