package com.whatsapp;

import a.a.a.a.a.a.d;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.m;
import android.support.v7.app.b.a;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;

public final class agm
  extends m
{
  final pv aa = pv.a();
  final ame ab = ame.a();
  a ac;
  private final e ad = e.a();
  
  public static agm a(String paramString1, String paramString2)
  {
    agm localagm = new agm();
    Bundle localBundle = new Bundle();
    localBundle.putString("jid", paramString1);
    localBundle.putString("flow", paramString2);
    localagm.f(localBundle);
    return localagm;
  }
  
  public final void a(Context paramContext)
  {
    super.a(paramContext);
    try
    {
      this.ac = ((a)paramContext);
      return;
    }
    catch (ClassCastException paramContext)
    {
      this.ac = null;
    }
  }
  
  public final Dialog c(Bundle paramBundle)
  {
    paramBundle = l();
    Object localObject1 = (String)a.d.a(i().getString("jid"));
    Object localObject2 = i().getString("flow");
    localObject1 = this.ad.d((String)localObject1);
    localObject2 = agn.a(this, (cs)localObject1, (String)localObject2);
    paramBundle = new b.a(paramBundle);
    if (((cs)localObject1).d()) {
      paramBundle.b(2131297614);
    }
    for (;;)
    {
      paramBundle.a(2131297612, (DialogInterface.OnClickListener)localObject2);
      paramBundle.b(2131296398, null);
      paramBundle = paramBundle.a();
      paramBundle.setCanceledOnTouchOutside(true);
      return paramBundle;
      paramBundle.b(2131297613);
    }
  }
  
  public final void d()
  {
    super.d();
    this.ac = null;
  }
  
  public static abstract interface a
  {
    public abstract void p();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/agm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */