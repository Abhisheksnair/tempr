package com.whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.a;
import com.whatsapp.data.ad;
import com.whatsapp.util.Log;
import java.util.ArrayList;

public class GroupMembersSelector
  extends aai
{
  private final com.whatsapp.data.d t = com.whatsapp.data.d.a();
  private final ad u = ad.a();
  
  protected final void d(int paramInt)
  {
    if (paramInt <= 0)
    {
      i().b(2131296299);
      return;
    }
    super.d(paramInt);
  }
  
  protected final int l()
  {
    return 2131297275;
  }
  
  protected final int m()
  {
    return aic.o;
  }
  
  protected final int n()
  {
    return 1;
  }
  
  protected final int o()
  {
    return 2131297021;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    default: 
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    do
    {
      do
      {
        return;
      } while (paramInt2 != -1);
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getStringExtra("group_jid");
        Log.i("groupmembersselector/group created " + paramIntent);
        if ((this.t.a(paramIntent)) && (!a.a.a.a.d.a(this)))
        {
          Log.i("groupmembersselector/opening conversation" + paramIntent);
          startActivity(Conversation.a(paramIntent));
          finish();
          return;
        }
      }
      startActivity(new Intent(this, Main.n()));
      finish();
      return;
    } while (paramInt2 == -1);
    Log.i("groupmembersselector/permissions denied");
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("groupmembersselector/create");
    super.onCreate(paramBundle);
    if ((paramBundle == null) && (!this.aP.d())) {
      RequestPermissionActivity.a(this, 2131297376, 2131297375);
    }
  }
  
  public void onDestroy()
  {
    Log.i("groupmembersselector/destroy");
    super.onDestroy();
  }
  
  protected final int p()
  {
    return 2131297280;
  }
  
  protected final int q()
  {
    return 2130840163;
  }
  
  protected final void r()
  {
    ArrayList localArrayList = t();
    if (localArrayList.isEmpty())
    {
      pv.a(this, getString(2131297309), 0);
      return;
    }
    startActivityForResult(new Intent(this, NewGroup.class).putExtra("selected", localArrayList).putExtra("entry_point", getIntent().getIntExtra("entry_point", -1)), 1);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/GroupMembersSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */