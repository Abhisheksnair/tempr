package com.whatsapp.accountsync;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;
import com.whatsapp.Main;
import com.whatsapp.aus;
import com.whatsapp.util.Log;
import com.whatsapp.util.bu;
import com.whatsapp.va;

public class LoginActivity
  extends AccountAuthenticatorActivity
{
  private final va a = va.a();
  private final aus b = aus.a();
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b.e();
    setContentView(2130903282);
    Log.i("loginactivity/create");
    paramBundle = AccountManager.get(this).getAccounts();
    int k = paramBundle.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      if ("com.whatsapp".contains(paramBundle[i].type)) {
        j = 1;
      }
      i += 1;
    }
    if (j != 0)
    {
      Toast.makeText(getApplicationContext(), getString(2131296277), 1).show();
      finish();
      return;
    }
    if (this.a.b() == null)
    {
      paramBundle = new Intent(this, Main.class);
      paramBundle.putExtra("show_registration_first_dlg", true);
      startActivity(paramBundle);
      finish();
      return;
    }
    bu.a(new a(this, (byte)0), new Void[0]);
  }
  
  final class a
    extends AsyncTask<Void, Void, Boolean>
  {
    final ProgressDialog a;
    
    private a(Context paramContext)
    {
      this.a = ProgressDialog.show(paramContext, "", LoginActivity.this.getString(2131296279), true, false);
      this.a.setCancelable(true);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/accountsync/LoginActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */