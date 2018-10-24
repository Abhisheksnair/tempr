package com.whatsapp;

import a.a.a.a.a.a.d;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.m;
import android.support.v7.app.b.a;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;

public final class am
  extends m
{
  final aq aa = aq.a();
  private final e ab = e.a();
  
  public static am a(String paramString)
  {
    am localam = new am();
    Bundle localBundle = new Bundle();
    localBundle.putString("jid", paramString);
    localam.f(localBundle);
    return localam;
  }
  
  public final Dialog c(Bundle paramBundle)
  {
    Object localObject1 = l();
    Object localObject2 = (String)a.d.a(i().getString("jid"));
    paramBundle = this.ab.d((String)localObject2);
    localObject2 = an.a(this, (Activity)localObject1, (String)localObject2);
    localObject1 = new b.a((Context)localObject1);
    ((b.a)localObject1).b(a(2131296351, new Object[] { paramBundle.a(k()) }));
    ((b.a)localObject1).a(2131296350, (DialogInterface.OnClickListener)localObject2);
    ((b.a)localObject1).b(2131296398, null).a();
    paramBundle = ((b.a)localObject1).a();
    paramBundle.setCanceledOnTouchOutside(true);
    return paramBundle;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */