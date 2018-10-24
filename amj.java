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

public class amj
  extends m
{
  final cc aa = cc.a();
  private final e ab = e.a();
  
  public static amj a(String paramString)
  {
    amj localamj = new amj();
    Bundle localBundle = new Bundle();
    localBundle.putString("jid", paramString);
    localamj.f(localBundle);
    return localamj;
  }
  
  public final Dialog c(Bundle paramBundle)
  {
    paramBundle = this.ab.d((String)a.d.a(i().getString("jid")));
    if ((l() instanceof StatusPlaybackActivity)) {
      ((StatusPlaybackActivity)l()).l();
    }
    return new b.a(l()).a(a(2131297230, new Object[] { paramBundle.k() })).b(a(2131297229, new Object[] { paramBundle.a(l()) })).b(2131296398, amk.a(this)).a(2131297228, aml.a(this, paramBundle)).a();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if ((l() instanceof StatusPlaybackActivity)) {
      ((StatusPlaybackActivity)l()).m();
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/amj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */