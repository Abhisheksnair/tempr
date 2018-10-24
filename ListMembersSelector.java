package com.whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.a;
import com.whatsapp.data.ad;
import com.whatsapp.data.e;
import com.whatsapp.messaging.aj;
import com.whatsapp.protocol.j;
import com.whatsapp.registration.bc;
import com.whatsapp.util.Log;
import java.util.ArrayList;

public class ListMembersSelector
  extends aai
{
  private final ant t = ant.a();
  private final va u = va.a();
  private final ad v = ad.a();
  private final aj w = aj.a();
  private final qz x = qz.a();
  private final lt y = lt.a();
  private final rh z = rh.a();
  
  protected final int l()
  {
    return 2131297279;
  }
  
  protected final int m()
  {
    if (aic.r == 0) {
      return -1;
    }
    return aic.r;
  }
  
  protected final int n()
  {
    return 2;
  }
  
  protected final int o()
  {
    return 2131296360;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 150)
    {
      if (paramInt2 != -1)
      {
        Log.i("listmembersselector/permissions denied");
        finish();
      }
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("listmembersselector/create");
    super.onCreate(paramBundle);
    pb.a(2);
    a locala = i();
    locala.a(true);
    locala.a(2131297279);
    if ((paramBundle == null) && (!this.aP.d())) {
      RequestPermissionActivity.a(this, 2131297372, 2131297371);
    }
  }
  
  public void onDestroy()
  {
    Log.i("listmembersselector/destroy");
    super.onDestroy();
  }
  
  protected final int p()
  {
    return 2131296595;
  }
  
  protected final int q()
  {
    return 2130840162;
  }
  
  protected final void r()
  {
    String str = this.y.k();
    ArrayList localArrayList = t();
    this.x.a(str, localArrayList);
    j localj = new j(this.u, str, "");
    localj.n = this.t.b();
    localj.d = 6;
    localj.t = 9L;
    localj.N = localArrayList;
    localj.f = (this.u.b() + "@s.whatsapp.net");
    this.v.b(localj, -1);
    this.w.a(this.z, str, false);
    startActivity(Conversation.a(this.p.a(str, "", System.currentTimeMillis())));
    finish();
  }
  
  protected final String s()
  {
    Me localMe = this.u.b;
    return getString(2131296361, new Object[] { ("‪" + bc.a(localMe.cc, localMe.jabber_id.substring(localMe.cc.length())) + "‬").replaceAll(" ", " ") });
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ListMembersSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */