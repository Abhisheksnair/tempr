package com.whatsapp.contact.sync;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Context;
import com.whatsapp.aat;
import com.whatsapp.and;
import com.whatsapp.att;
import com.whatsapp.atv;
import com.whatsapp.data.ad;
import com.whatsapp.data.co;
import com.whatsapp.pc;
import com.whatsapp.s;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import com.whatsapp.util.n;
import com.whatsapp.va;
import java.util.concurrent.ExecutionException;

public class i
{
  private static volatile i h;
  public final com.whatsapp.messaging.w a;
  public final ad b;
  public final att c;
  final and d;
  public final co e;
  public final atv f;
  public s g;
  private final va i;
  private final pc j;
  private final a k;
  private final aat l;
  
  private i(va paramva, com.whatsapp.messaging.w paramw, ad paramad, att paramatt, and paramand, pc parampc, co paramco, a parama, aat paramaat, atv paramatv)
  {
    this.i = paramva;
    this.a = paramw;
    this.b = paramad;
    this.c = paramatt;
    this.d = paramand;
    this.j = parampc;
    this.e = paramco;
    this.k = parama;
    this.l = paramaat;
    this.f = paramatv;
    this.g = new s(paramva, parampc, this);
  }
  
  public static i a()
  {
    if (h == null) {}
    try
    {
      if (h == null) {
        h = new i(va.a(), com.whatsapp.messaging.w.a(), ad.a(), att.a(), and.a(), pc.a(), co.a(), a.a(), aat.a(), atv.a());
      }
      return h;
    }
    finally {}
  }
  
  private static v a(n<v> paramn)
  {
    try
    {
      paramn = (v)paramn.get();
      return paramn;
    }
    catch (InterruptedException paramn)
    {
      return v.d;
    }
    catch (ExecutionException paramn) {}
    return v.d;
  }
  
  private static n<v> a(a parama, t paramt, boolean paramBoolean)
  {
    String str = g.a().b();
    n localn = new n();
    g.a().a(str, localn);
    paramt.a(str, paramBoolean);
    parama.a(paramt);
    return localn;
  }
  
  final Account a(Context paramContext, AccountManager paramAccountManager)
  {
    if (this.i.b() == null)
    {
      Log.e("ContactSyncUtil/get-or-create-account null jid");
      return null;
    }
    paramContext = new Account(paramContext.getString(2131298233), "com.whatsapp");
    if (paramAccountManager.addAccountExplicitly(paramContext, null, null))
    {
      ContentResolver.setIsSyncable(paramContext, "com.android.contacts", 1);
      return paramContext;
    }
    Log.e("ContactSyncUtil/get-or-create-account failed to add account");
    return null;
  }
  
  public final v a(t paramt)
  {
    if (!this.l.b())
    {
      Log.i("ContactsSyncUtil/network_unavailable");
      return v.a;
    }
    return a(a(this.k, paramt, false));
  }
  
  public final void a(w paramw, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    bu.a(j.a(this, paramw, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4));
  }
  
  public final n<v> b(t paramt)
  {
    return a(this.k, paramt, true);
  }
  
  public final void b()
  {
    if (this.j.e()) {}
    for (Object localObject = w.c;; localObject = w.e)
    {
      localObject = new t.a((w)localObject);
      ((t.a)localObject).c = true;
      ((t.a)localObject).d = true;
      ((t.a)localObject).b = true;
      b(((t.a)localObject).a());
      return;
    }
  }
  
  public final void c()
  {
    t.a locala = new t.a(w.d);
    locala.d = true;
    b(locala.a());
  }
  
  public final void d()
  {
    if (this.i.b == null) {
      return;
    }
    bu.a(k.a(this));
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/contact/sync/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */