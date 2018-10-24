package com.whatsapp.accountsync;

import a.a.a.a.d;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import com.whatsapp.Conversation;
import com.whatsapp.Main;
import com.whatsapp.RequestPermissionActivity;
import com.whatsapp.TosUpdateActivity;
import com.whatsapp.anv;
import com.whatsapp.apf;
import com.whatsapp.apg;
import com.whatsapp.atu;
import com.whatsapp.br;
import com.whatsapp.data.ad;
import com.whatsapp.data.cb;
import com.whatsapp.data.ch;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.pv;
import com.whatsapp.qz;
import com.whatsapp.registration.bb;
import com.whatsapp.util.Log;
import com.whatsapp.util.WhatsAppLibLoader;
import com.whatsapp.util.bu;
import com.whatsapp.va;

public class ProfileActivity
  extends apf
{
  a n = null;
  private final va o = va.a();
  private final br p = br.a();
  private final e q = e.a();
  
  private void m()
  {
    if (isFinishing())
    {
      Log.w("sync profile activity already finishing, ignoring gotoActivity call");
      return;
    }
    if (!this.aP.d())
    {
      RequestPermissionActivity.a(this, 2131297379, 2131297380, true);
      return;
    }
    if (getIntent().getData() != null)
    {
      Cursor localCursor = getContentResolver().query(getIntent().getData(), null, null, null, null);
      if (localCursor != null)
      {
        for (;;)
        {
          Object localObject2;
          try
          {
            if (!localCursor.moveToNext()) {
              break;
            }
            String str = localCursor.getString(localCursor.getColumnIndex("mimetype"));
            localObject2 = localCursor.getString(localCursor.getColumnIndex("data1"));
            localObject2 = this.q.d((String)localObject2);
            if ((((cs)localObject2).d()) || (cs.e(((cs)localObject2).t)))
            {
              startActivity(new Intent(this, Main.n()));
              finish();
              return;
            }
            if ("vnd.android.cursor.item/vnd.com.whatsapp.profile".equals(str))
            {
              startActivity(Conversation.a((cs)localObject2));
              continue;
            }
            if (!"vnd.android.cursor.item/vnd.com.whatsapp.voip.call".equals(localObject1)) {
              break label241;
            }
          }
          finally
          {
            localCursor.close();
          }
          if (this.at.e())
          {
            this.p.a((cs)localObject2, this, Integer.valueOf(14), false);
          }
          else
          {
            startActivity(new Intent(this, TosUpdateActivity.class));
            continue;
            label241:
            if ("vnd.android.cursor.item/vnd.com.whatsapp.video.call".equals(localObject1)) {
              if (this.at.e()) {
                this.p.a((cs)localObject2, this, Integer.valueOf(14), false, true);
              } else {
                startActivity(new Intent(this, TosUpdateActivity.class));
              }
            }
          }
        }
        localCursor.close();
      }
    }
    Log.e("failed to go anywhere from sync profile activity; intent=" + getIntent());
    finish();
  }
  
  protected final void l()
  {
    if (this.B.b)
    {
      if ((this.n == null) || (this.n.getStatus() != AsyncTask.Status.RUNNING))
      {
        this.n = new a();
        bu.a(this.n, new Void[0]);
      }
      return;
    }
    m();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt2 == -1)
      {
        m();
      }
      else
      {
        Log.w("profileactivity/contact access denied");
        finish();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i("profileactivity/create");
    if (!WhatsAppLibLoader.a(null))
    {
      Log.i("aborting due to native libraries missing");
      finish();
    }
    do
    {
      return;
      if ((this.o.b == null) || (!this.L.b()))
      {
        pv.a(this, 2131296797, 1);
        finish();
        return;
      }
      if (this.y.z.d) {
        break;
      }
    } while (!this.M.d());
    int i = this.y.c.d();
    Log.i("profileactivity/create/backupfilesfound " + i);
    if (i > 0)
    {
      d.a(this, 105);
      return;
    }
    c(false);
    return;
    l();
  }
  
  public final class a
    extends AsyncTask<Void, Void, Void>
  {
    public a() {}
    
    private Void a()
    {
      int i = 0;
      while ((ProfileActivity.a(ProfileActivity.this).b) && (i < 45000))
      {
        i += 200;
        try
        {
          Thread.sleep(200L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
      if ((i >= 45000) && (ProfileActivity.b(ProfileActivity.this).b)) {
        ProfileActivity.c(ProfileActivity.this).d();
      }
      return null;
    }
    
    protected final void onPreExecute()
    {
      d.a(ProfileActivity.this, 104);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/accountsync/ProfileActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */