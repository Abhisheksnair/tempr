package com.whatsapp.twofactor;

import a.a.a.a.a.a.d;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import b.a.a.c;
import com.whatsapp.g.j;
import com.whatsapp.messaging.m;
import com.whatsapp.messaging.w;
import com.whatsapp.u;
import com.whatsapp.util.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class q
{
  public static final long[] a = { TimeUnit.HOURS.toMillis(6L), TimeUnit.HOURS.toMillis(12L), TimeUnit.DAYS.toMillis(1L), TimeUnit.DAYS.toMillis(1L), TimeUnit.DAYS.toMillis(3L), TimeUnit.DAYS.toMillis(7L) };
  public static final int b = 5;
  static final long c = TimeUnit.SECONDS.toMillis(35L);
  private static volatile q f;
  public final w d;
  public final SharedPreferences e;
  private final List<a> g = new LinkedList();
  
  private q(w paramw, SharedPreferences paramSharedPreferences)
  {
    this.d = paramw;
    this.e = paramSharedPreferences;
  }
  
  public static q a()
  {
    if (f == null) {}
    try
    {
      if (f == null) {
        f = new q(w.a(), u.a().getSharedPreferences("com.whatsapp_preferences", 0));
      }
      return f;
    }
    finally {}
  }
  
  public static long c()
  {
    return ((j)c.a().a(j.class)).a();
  }
  
  final void a(a parama)
  {
    if (!this.g.contains(parama)) {}
    for (boolean bool = true;; bool = false)
    {
      a.d.a(bool);
      this.g.add(parama);
      return;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    Log.d("twofactorauthmanager/set-two-factor-auth-settings code [" + paramString1 + "] email [" + paramString2 + "]");
    Object localObject = this.d;
    if (((w)localObject).b.d)
    {
      Log.i("sendmethods/send-set-two-factor-auth");
      localObject = ((w)localObject).b;
      Message localMessage = Message.obtain(null, 0, 111, 0);
      localMessage.getData().putString("code", paramString1);
      localMessage.getData().putString("email", paramString2);
      ((m)localObject).a(localMessage);
    }
  }
  
  public final void a(String paramString1, String paramString2, int paramInt)
  {
    Log.i("twofactorauthmanager/store-new-auth-settings");
    Log.d("twofactorauthmanager/store-new-auth-settings received [" + paramString1 + "] email [" + paramString2 + "]");
    this.e.edit().remove("two_factor_auth_new_code").remove("two_factor_auth_new_email").apply();
    SharedPreferences.Editor localEditor = this.e.edit();
    if (!TextUtils.isEmpty(paramString1))
    {
      localEditor.putString("two_factor_auth_code", paramString1);
      localEditor.putLong("two_factor_auth_nag_time", System.currentTimeMillis());
      localEditor.putInt("two_factor_auth_nag_interval", paramInt);
      if (paramString2 != null) {
        if (paramString2.length() <= 0) {
          break label229;
        }
      }
    }
    label229:
    for (paramInt = 1;; paramInt = 2)
    {
      localEditor.putInt("two_factor_auth_email_set", paramInt);
      localEditor.apply();
      paramString1 = this.g.iterator();
      while (paramString1.hasNext()) {
        ((a)paramString1.next()).l();
      }
      localEditor.remove("two_factor_auth_code");
      localEditor.remove("two_factor_auth_email_set");
      localEditor.remove("two_factor_auth_nag_time");
      localEditor.remove("two_factor_auth_nag_interval");
      break;
    }
  }
  
  public final void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    Log.w("twofactorauthmanager/store-auth-settings-error errorCode [" + paramInt + "] errorMessage [" + paramString3 + "]");
    if (paramInt == -1) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        b(paramString1, paramString2);
      }
      paramString1 = this.g.iterator();
      while (paramString1.hasNext()) {
        ((a)paramString1.next()).c(bool);
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    int i = this.e.getInt("two_factor_auth_nag_interval", 0);
    if (paramBoolean) {}
    for (i = Math.min(i + 1, a.length - 1);; i = Math.max(i - 1, 0))
    {
      this.e.edit().putLong("two_factor_auth_nag_time", c()).putInt("two_factor_auth_nag_interval", i).apply();
      return;
    }
  }
  
  public final String b()
  {
    if (this.e.contains("two_factor_auth_new_code")) {
      return this.e.getString("two_factor_auth_new_code", "");
    }
    return this.e.getString("two_factor_auth_code", "");
  }
  
  final void b(a parama)
  {
    a.d.a(this.g.contains(parama));
    this.g.remove(parama);
  }
  
  public final void b(String paramString1, String paramString2)
  {
    Log.d("twofactorauthmanager/set-pending-change code [" + paramString1 + "] email [" + paramString2 + "]");
    this.e.edit().putString("two_factor_auth_new_code", paramString1).putString("two_factor_auth_new_email", paramString2).apply();
  }
  
  public final void d()
  {
    Log.i("twofactorauthmanager/disable-two-factor-auth");
    a("", null);
  }
  
  public final boolean e()
  {
    return !TextUtils.isEmpty(b());
  }
  
  public final int f()
  {
    return this.e.getInt("two_factor_auth_email_set", 0);
  }
  
  public static abstract interface a
  {
    public abstract void c(boolean paramBoolean);
    
    public abstract void l();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/twofactor/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */