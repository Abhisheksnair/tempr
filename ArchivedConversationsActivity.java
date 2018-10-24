package com.whatsapp;

import android.os.Bundle;
import android.support.v4.app.r;
import android.support.v4.app.w;
import android.support.v7.app.a;
import android.view.MenuItem;
import com.whatsapp.util.Log;

public class ArchivedConversationsActivity
  extends nh
{
  protected void onCreate(Bundle paramBundle)
  {
    Log.i("archivedconversations/create");
    super.onCreate(paramBundle);
    i().a(true);
    setContentView(2130903085);
    if (paramBundle == null) {
      j_().a().a(2131755320, new ab()).d();
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Log.i("archivedconversations/destroy");
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    finish();
    return true;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ArchivedConversationsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */