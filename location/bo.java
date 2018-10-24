package com.whatsapp.location;

import com.whatsapp.protocol.x;
import com.whatsapp.util.Log;

public final class bo
  implements x, Runnable
{
  public String a;
  
  bo(String paramString)
  {
    this.a = paramString;
  }
  
  public final void a(int paramInt)
  {
    Log.e("locationsunsubscriberesponsehandler/error " + paramInt);
  }
  
  public final void run()
  {
    Log.i("locationsunsubscriberesponsehandler/success");
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/location/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */