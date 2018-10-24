package com.whatsapp.accountsync;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.whatsapp.util.Log;
import java.util.Arrays;

public class AccountAuthenticatorService
  extends Service
{
  private static a a = null;
  
  public IBinder onBind(Intent paramIntent)
  {
    IBinder localIBinder = null;
    if (paramIntent.getAction().equals("android.accounts.AccountAuthenticator"))
    {
      if (a == null) {
        a = new a(this);
      }
      localIBinder = a.getIBinder();
    }
    return localIBinder;
  }
  
  static final class a
    extends AbstractAccountAuthenticator
  {
    private final Context a;
    
    public a(Context paramContext)
    {
      super();
      this.a = paramContext;
    }
    
    public final Bundle addAccount(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString1, String paramString2, String[] paramArrayOfString, Bundle paramBundle)
    {
      Log.i("account/sync/addAccount");
      paramString1 = new Bundle();
      paramString2 = new Intent(this.a, LoginActivity.class);
      paramString2.putExtra("accountAuthenticatorResponse", paramAccountAuthenticatorResponse);
      paramString1.putParcelable("intent", paramString2);
      return paramString1;
    }
    
    public final Bundle confirmCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, Bundle paramBundle)
    {
      Log.i("account/sync/confirmCredentials");
      return null;
    }
    
    public final Bundle editProperties(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString)
    {
      Log.i("account/sync/editProperties");
      return null;
    }
    
    public final Bundle getAuthToken(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle)
    {
      Log.i("account/sync/getAuthToken");
      return null;
    }
    
    public final String getAuthTokenLabel(String paramString)
    {
      Log.i("account/sync/getAuthTokenLabel");
      return null;
    }
    
    public final Bundle hasFeatures(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String[] paramArrayOfString)
    {
      Log.i("account/sync/hasFeatures: " + Arrays.toString(paramArrayOfString));
      return null;
    }
    
    public final Bundle updateCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle)
    {
      Log.i("account/sync/updateCredentials");
      return null;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/accountsync/AccountAuthenticatorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */