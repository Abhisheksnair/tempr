package com.whatsapp.i;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public final class f
  implements HostnameVerifier
{
  private final String a;
  
  public f(String paramString)
  {
    this.a = paramString;
  }
  
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    return HttpsURLConnection.getDefaultHostnameVerifier().verify(this.a, paramSSLSession);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/i/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */