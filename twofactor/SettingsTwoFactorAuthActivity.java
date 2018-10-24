package com.whatsapp.twofactor;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.a;
import android.support.v7.app.b.a;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.whatsapp.nh;
import com.whatsapp.nh.h;
import com.whatsapp.pv;
import com.whatsapp.u;
import com.whatsapp.util.Log;

public class SettingsTwoFactorAuthActivity
  extends nh
  implements q.a
{
  private final Handler n = new Handler(Looper.getMainLooper());
  private final Runnable o = h.a(this);
  private final q p = q.a();
  private ImageView q;
  private View r;
  private View s;
  private TextView t;
  private TextView u;
  
  private void m()
  {
    int j = 0;
    boolean bool = this.p.e();
    Object localObject = this.r;
    if (bool)
    {
      i = 8;
      ((View)localObject).setVisibility(i);
      localObject = this.s;
      if (!bool) {
        break label117;
      }
      i = j;
      label41:
      ((View)localObject).setVisibility(i);
      localObject = this.q;
      if (!bool) {
        break label123;
      }
      i = 2130840148;
      label60:
      ((ImageView)localObject).setImageResource(i);
      localObject = this.t;
      if (!bool) {
        break label129;
      }
      i = 2131297828;
      label79:
      ((TextView)localObject).setText(i);
      localObject = this.u;
      if (this.p.f() != 1) {
        break label135;
      }
    }
    label117:
    label123:
    label129:
    label135:
    for (int i = 2131297823;; i = 2131297821)
    {
      ((TextView)localObject).setText(i);
      return;
      i = 0;
      break;
      i = 8;
      break label41;
      i = 2130840147;
      break label60;
      i = 2131297827;
      break label79;
    }
  }
  
  final void a(int... paramVarArgs)
  {
    startActivity(TwoFactorAuthActivity.a(this, paramVarArgs));
  }
  
  public final void c(boolean paramBoolean)
  {
    Log.d("settingstwofactorauthactivity/on-two-factor-auth-settings-refresh-error");
    this.n.removeCallbacks(this.o);
    nh.h.a(this.aS);
    if (paramBoolean) {}
    for (int i = 2131298035;; i = 2131298034)
    {
      b_(i);
      m();
      return;
    }
  }
  
  public final void l()
  {
    Log.d("settingstwofactorauthactivity/on-two-factor-auth-settings-refreshed");
    this.n.removeCallbacks(this.o);
    nh.h.a(this.aS);
    m();
    pv.a(u.a(), 2131298015, 1);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Log.i("settingstwofactorauthactivity/create");
    super.onCreate(paramBundle);
    paramBundle = i();
    if (paramBundle != null) {
      paramBundle.a(true);
    }
    setContentView(2130903363);
    this.q = ((ImageView)findViewById(2131755220));
    this.r = findViewById(2131756077);
    this.s = findViewById(2131756079);
    this.t = ((TextView)findViewById(2131755322));
    findViewById(2131756078).setOnClickListener(i.a(this));
    findViewById(2131756080).setOnClickListener(j.a(this));
    findViewById(2131756081).setOnClickListener(k.a(this));
    this.u = ((TextView)findViewById(2131756082));
    this.u.setOnClickListener(l.a(this));
  }
  
  protected void onDestroy()
  {
    Log.i("settingstwofactorauthactivity/destroy");
    super.onDestroy();
  }
  
  public void onPause()
  {
    Log.i("settingstwofactorauthactivity/pause");
    super.onPause();
    this.p.b(this);
  }
  
  public void onResume()
  {
    Log.i("settingstwofactorauthactivity/resume");
    super.onResume();
    View localView = getCurrentFocus();
    if (localView != null) {
      localView.clearFocus();
    }
    this.p.a(this);
    m();
  }
  
  public static final class a
    extends android.support.v4.app.m
  {
    public static a R()
    {
      return new a();
    }
    
    public final Dialog c(Bundle paramBundle)
    {
      return new b.a(k()).b(a(2131297825)).a(2131297824, m.a(this)).b(2131296398, null).a();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/twofactor/SettingsTwoFactorAuthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */