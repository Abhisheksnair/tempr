package com.whatsapp.registration;

import android.content.SharedPreferences;
import com.whatsapp.and;
import com.whatsapp.atu;
import com.whatsapp.atv;
import com.whatsapp.aus;
import com.whatsapp.r;
import com.whatsapp.util.Log;

public class bk
{
  private static volatile bk k;
  public String a;
  public boolean b = false;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  public boolean h = true;
  public final and i;
  public final aus j;
  private final atu l;
  private final atv m;
  
  private bk(and paramand, aus paramaus, atu paramatu, atv paramatv)
  {
    this.i = paramand;
    this.j = paramaus;
    this.l = paramatu;
    this.m = paramatv;
    this.b = paramatv.a.getBoolean("pref_fail_too_many", false);
    this.c = paramatv.a.getBoolean("pref_no_route_sms", false);
    this.d = paramatv.a.getBoolean("pref_no_route_voice", false);
    this.e = paramatv.a.getBoolean("pref_fail_too_many_attempts", false);
    this.f = paramatv.a.getBoolean("pref_fail_too_many_guesses", false);
  }
  
  public static bk a()
  {
    if (k == null) {}
    try
    {
      if (k == null) {
        k = new bk(and.a(), aus.a(), atu.a(), atv.a());
      }
      return k;
    }
    finally {}
  }
  
  public final void a(String paramString)
  {
    this.a = paramString;
    if (paramString.equals("verify-tmg"))
    {
      this.f = true;
      this.e = false;
      this.m.a(this);
    }
    do
    {
      for (;;)
      {
        if (paramString.equals("verify-sms"))
        {
          if (!this.f) {
            break;
          }
          this.a = "verify-tmg";
        }
        return;
        if (paramString.equals("verify-tma"))
        {
          this.f = false;
          this.e = true;
          this.m.a(this);
        }
      }
    } while (!this.e);
    this.a = "verify-tma";
  }
  
  public final String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (r.a(this.i, this.l)) {
      localStringBuilder.append("rted ");
    }
    try
    {
      Class.forName("org.acra.ACRA");
      localStringBuilder.append("nw-wap ");
      if (localStringBuilder.length() == 0) {
        return null;
      }
      return localStringBuilder.toString();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
  }
  
  public final void b(String paramString)
  {
    int n = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (n)
      {
      }
      break;
    }
    for (;;)
    {
      this.m.a(this);
      return;
      if (!paramString.equals("failTooMany")) {
        break;
      }
      n = 0;
      break;
      if (!paramString.equals("noRouteSms")) {
        break;
      }
      n = 1;
      break;
      if (!paramString.equals("noRouteVoice")) {
        break;
      }
      n = 2;
      break;
      if (!paramString.equals("validNumber")) {
        break;
      }
      n = 3;
      break;
      if (!paramString.equals("notValidNumber")) {
        break;
      }
      n = 4;
      break;
      if (!paramString.equals("emptyNumber")) {
        break;
      }
      n = 5;
      break;
      if (!paramString.equals("notEmptyNumber")) {
        break;
      }
      n = 6;
      break;
      this.b = true;
      continue;
      this.c = true;
      continue;
      this.d = true;
      continue;
      this.h = true;
      continue;
      this.h = false;
      continue;
      this.g = true;
      continue;
      this.g = false;
    }
  }
  
  public final String c(String paramString)
  {
    boolean bool = r.a(this.i, this.l);
    Log.d("VerificationFlowState/getContactUsContextInternal context " + this.a + " phoneNumberIsEmpty " + this.g + " phoneNumberIsValid " + this.h + " noRouteSms " + this.c + " noRouteVoice " + this.d + " failTooMany " + this.b);
    if ("register-phone".equals(this.a)) {
      if (bool) {
        paramString = "register-phone-rtd";
      }
    }
    do
    {
      do
      {
        do
        {
          return paramString;
          if (this.g) {
            return "register-phone-no_number";
          }
        } while (this.h);
        return "register-phone-invalid";
        if (!"verify-sms".equals(this.a)) {
          break;
        }
        if (bool) {
          return "verify-sms-rtd";
        }
        if ((!this.c) && (!this.d) && (!this.b)) {
          return "verify-sms-normal";
        }
        if ((this.c) && (this.d)) {
          return "verify-sms-no_routes_both";
        }
        if (this.c) {
          return "verify-sms-no_routes_sms";
        }
      } while (!this.d);
      return "verify-sms-no_routes_voice";
      if ("verify-tma".equals(this.a)) {
        return "verify-tma";
      }
    } while (!"verify-tmg".equals(this.a));
    return "verify-tmg";
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/registration/bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */