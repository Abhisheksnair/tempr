package com.whatsapp.phoneid;

import android.content.Context;
import com.facebook.phoneid.AbstractPhoneIdRequestReceiver;
import com.facebook.phoneid.PhoneId;

public class PhoneIdRequestReceiver
  extends AbstractPhoneIdRequestReceiver
{
  protected PhoneId getLocalPhoneId(Context paramContext)
  {
    return a.a().getPhoneId();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/phoneid/PhoneIdRequestReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */