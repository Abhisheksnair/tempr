package com.whatsapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import com.whatsapp.contact.sync.i;
import com.whatsapp.data.a;
import com.whatsapp.data.ad;
import com.whatsapp.data.ch.a;
import com.whatsapp.data.ci;
import com.whatsapp.data.co;
import com.whatsapp.messaging.m;
import com.whatsapp.messaging.w;
import com.whatsapp.registration.aw;
import com.whatsapp.registration.bb;
import com.whatsapp.util.a.c;
import com.whatsapp.wallpaper.g;

public abstract class apf
  extends nh
{
  public final m A = m.a();
  public final qz B = qz.a();
  protected final g C = g.a();
  protected final cc D = cc.a();
  public final vv E = vv.a();
  protected final co F = co.a();
  public final aw G = aw.a();
  public final atv H = atv.a();
  protected final lt I = lt.a();
  protected final ci J = ci.a();
  public final rh K = rh.a();
  public final bb L = bb.a();
  public apg M = new apg(this, this.x, this.ay, this.y, this.z, this.A, this.aG, this.aH, this.B, this.C, this.D, this.E, this.F, this.G, this.H, this.J, this.K, this.L)
  {
    protected final void a()
    {
      apf.this.l();
    }
    
    protected final void a(int paramAnonymousInt)
    {
      apf.this.d(paramAnonymousInt);
    }
    
    protected final void a(ch.a paramAnonymousa)
    {
      apf.this.a(paramAnonymousa);
    }
  };
  public final c w = c.a();
  protected final va x = va.a();
  public final ad y = ad.a();
  protected final att z = att.a();
  
  public void a(ch.a parama) {}
  
  public void c(boolean paramBoolean)
  {
    this.M.a(paramBoolean, true);
  }
  
  public void d(int paramInt) {}
  
  public void l() {}
  
  public final void o()
  {
    this.M.b();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 200)
    {
      if (paramInt2 == -1)
      {
        if (this.M.d()) {
          this.M.c();
        }
        return;
      }
      c(false);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    Dialog localDialog = this.M.b(paramInt);
    if (localDialog != null) {
      return localDialog;
    }
    return super.onCreateDialog(paramInt);
  }
  
  public final void p()
  {
    this.M.c();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/apf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */