package com.whatsapp;

import a.a.a.a.a.a.d;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.m;
import android.support.v7.app.b.a;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.statusplayback.StatusPlaybackActivity;

public class amm
  extends m
{
  final cc aa = cc.a();
  private final e ab = e.a();
  
  public static amm a(String paramString)
  {
    amm localamm = new amm();
    Bundle localBundle = new Bundle();
    localBundle.putString("jid", paramString);
    localamm.f(localBundle);
    return localamm;
  }
  
  public final Dialog c(Bundle paramBundle)
  {
    if ((l() instanceof StatusPlaybackActivity)) {
      ((StatusPlaybackActivity)l()).l();
    }
    paramBundle = this.ab.d((String)a.d.a(i().getString("jid")));
    return new b.a(l()).a(a(2131298064, new Object[] { paramBundle.k() })).b(a(2131298063, new Object[] { paramBundle.a(l()) })).b(2131296398, amn.a(this)).a(2131298062, amo.a(this, paramBundle)).a();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if ((l() instanceof StatusPlaybackActivity)) {
      ((StatusPlaybackActivity)l()).m();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/amm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */